package com.example.eas_ali_taufik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.eas_ali_taufik.pojo.News;
import com.example.eas_ali_taufik.pojo.NewsResponse;
import com.example.eas_ali_taufik.retrofit.NewsAdapter;
import com.example.eas_ali_taufik.retrofit.RestClient;
import com.example.eas_ali_taufik.room.AppDatabase;
import com.example.eas_ali_taufik.room.BookMarkNews;
import com.example.eas_ali_taufik.room.BookMarkNewsAdapter;
import com.example.eas_ali_taufik.room.BookMarkNewsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookmarkActivity extends AppCompatActivity {
    private List<BookMarkNews> list = new ArrayList<>();
    private BookMarkNewsAdapter adapter;
    private AppDatabase database;
    private BookMarkNewsModel mBookmarkViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        mBookmarkViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(BookMarkNewsModel.class);

        RecyclerView recyclerView = findViewById(R.id.rv_news);
        database = AppDatabase.getInstance(getApplicationContext());
        mBookmarkViewModel.getAllNews().observe(this, bookMarkNews -> {
            list = bookMarkNews;
            adapter = new BookMarkNewsAdapter(list, BookmarkActivity.this);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(adapter);
        });
//                list.clear();
//                list.addAll(database.bookMarkNewsDao().getAll());

//        RestClient.getService().getAllNews().enqueue(new Callback<NewsResponse>() {
//            @Override
//            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                database = AppDatabase.getInstance(getApplicationContext());
//                mBookmarkViewModel.getAllNews().observe(() -> {
//                    return null;
//                }, bookMarkNews -> {
//                    list = bookMarkNews;
//
//                });
////                list.clear();
////                list.addAll(database.bookMarkNewsDao().getAll());
//                adapter = new BookMarkNewsAdapter(list, BookmarkActivity.this);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<NewsResponse> call, Throwable t) {
//                Log.d("Failure" ,t.getMessage());
//            }
//        });
    }
}