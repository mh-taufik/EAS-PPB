package com.example.eas_ali_taufik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.eas_ali_taufik.pojo.News;
import com.example.eas_ali_taufik.pojo.NewsResponse;
import com.example.eas_ali_taufik.retrofit.NewsAdapter;
import com.example.eas_ali_taufik.retrofit.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<News> listNews;
    private NewsAdapter adapter;
    private RadioGroup opsiNegara;
    private RadioGroup opsiSort;
    private EditText opsiSearch;
    private Button filterButton;
    private String fNegara,fSort,fSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fNegara = "id";
        fSort = "";
        opsiNegara = findViewById(R.id.opsiNegara);
        opsiSort = findViewById(R.id.sortBy);
        opsiSearch = findViewById(R.id.searchKey);
        filterButton = findViewById(R.id.filterbutton);




    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: ");
        RecyclerView recyclerView = findViewById(R.id.rv_news);
        RestClient.getService().getAllNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                listNews = response.body().getArticles();
                adapter = new NewsAdapter(listNews, MainActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d("Failure" ,t.getMessage());
            }
        });
        opsiNegara.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.negaraId:
                        fNegara = "id";
                        break;
                    case R.id.negaraAu:
                        fNegara = "au";
                        break;
                    case R.id.negaraUs:
                        fNegara = "us";
                        break;
                    default:
                        fNegara = "id";
                        break;
                }
            }
        });

        opsiSort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sortPopularity:
                        fSort = "popularity";
                        break;
                    case R.id.sortPublishedAt:
                        fSort= "publishedAt";
                        break;
                    default:
                        fSort = "";
                        break;
                }
            }
        });


        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fSearch = opsiSearch.getText().toString();
                if(fSearch==null){
                    fSearch = "";
                }
                Log.d("TAG", "onClick: "+fSearch+" "+fNegara+" "+fSort);
                RestClient.getService().getFiltersNews(fSearch,fNegara,fSort).enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        Log.d("res",response.body().toString());
                        listNews = response.body().getArticles();
                        adapter = new NewsAdapter(listNews, MainActivity.this);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        Log.d("Failure" ,t.getMessage());
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bookmark_all_list:
                startActivity(new Intent(this,BookmarkActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}