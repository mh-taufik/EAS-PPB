package com.example.eas_ali_taufik.retrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eas_ali_taufik.NewsDetailActivity;
import com.example.eas_ali_taufik.R;
import com.example.eas_ali_taufik.pojo.News;
import com.example.eas_ali_taufik.room.AppDatabase;
import com.example.eas_ali_taufik.room.BookMarkNews;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> dataNews;
    private Context context;
    private AppDatabase database;

    public NewsAdapter(List<News> data, Context context) {
        this.dataNews = data;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load(dataNews.get(position).getUrlToImage()).into(holder.mImages);
        holder.mTitle.setText(dataNews.get(position).getTitle());
        holder.mPublishTime.setText(dataNews.get(position).getPublishedAt());
        holder.mPublisher.setText(dataNews.get(position).getSource().getName());
        holder.mContent.setText(dataNews.get(position).getDescription());
        database = AppDatabase.getInstance(context.getApplicationContext());
        BookMarkNews bookMarkNews = database.bookMarkNewsDao().get(dataNews.get(position).getTitle());
        if(bookMarkNews != null){
            holder.mTG.check(R.id.buttonBookMark);
        }else{
            Log.d("TAG", "kosong");
        }

        holder.mTG.addOnButtonCheckedListener((group, checkedId, isChecked) ->{
            if(isChecked){
                switch (checkedId){
                    case R.id.buttonBookMark:
                        database.bookMarkNewsDao().insertAll(dataNews.get(position).getTitle(),dataNews.get(position).getSource().getName(),dataNews.get(position).getUrlToImage(),dataNews.get(position).getPublishedAt(),dataNews.get(position).getDescription(),dataNews.get(position).getAuthor(),dataNews.get(position).getUrl());
                        Log.d("TAG", "onBindViewHolder: bookmark checked"+checkedId);
                }
            }else {
                if (group.getCheckedButtonId() == View.NO_ID){
//                    if(bookMarkNews.getTitle()!=null){
                        database.bookMarkNewsDao().delete(bookMarkNews);
//                    }
                    Log.d("TAG", "onBindViewHolder: bookmark uncheked");
                }
            }
        });
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                News news = dataNews.get(position);
                intent.putExtra("images",news.getUrlToImage());
                intent.putExtra("title",news.getTitle());
                intent.putExtra("publish_time",news.getPublishedAt());
                intent.putExtra("publisher",news.getSource().getName());
                intent.putExtra("author",news.getAuthor());
                intent.putExtra("content",news.getDescription());
                intent.putExtra("link",news.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImages;
        private TextView mTitle, mPublishTime, mPublisher, mContent;
        private ConstraintLayout mLayout;
        private MaterialButtonToggleGroup mTG;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImages = itemView.findViewById(R.id.news_images);
            mTitle = itemView.findViewById(R.id.news_title);
            mPublishTime = itemView.findViewById(R.id.news_publish_time);
            mPublisher = itemView.findViewById(R.id.news_publisher);
            mContent = itemView.findViewById(R.id.news_content);
            mLayout = itemView.findViewById(R.id.news_layout);

            mTG = itemView.findViewById(R.id.toggleButtonGroup);

        }
    }
}
