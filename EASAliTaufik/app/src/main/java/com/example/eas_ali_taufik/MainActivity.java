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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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