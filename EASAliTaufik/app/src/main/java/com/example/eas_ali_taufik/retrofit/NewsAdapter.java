package com.example.eas_ali_taufik.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eas_ali_taufik.NewsActivity;
import com.example.eas_ali_taufik.NewsDetailActivity;
import com.example.eas_ali_taufik.R;
import com.example.eas_ali_taufik.pojo.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> dataNews;
    private Context context;

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
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int pos) {
        int position = pos;
        Picasso.get().load(dataNews.get(position).getUrlToImage()).into(holder.mImages);
        holder.mTitle.setText(dataNews.get(position).getTitle());
        holder.mPublishTime.setText(dataNews.get(position).getPublishedAt());
        holder.mPublisher.setText(dataNews.get(position).getSource().getName());
        holder.mContent.setText(dataNews.get(position).getDescription());
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("images",dataNews.get(position).getUrlToImage());
                bundle.putString("title",dataNews.get(position).getTitle());
                bundle.putString("publish_time",dataNews.get(position).getPublishedAt());
                bundle.putString("publisher",dataNews.get(position).getSource().getName());
                bundle.putString("author",dataNews.get(position).getAuthor());
                bundle.putString("content",dataNews.get(position).getContent());
                bundle.putString("link",dataNews.get(position).getUrl());
                intent.putExtra("news",bundle);
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

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImages = itemView.findViewById(R.id.news_images);
            mTitle = itemView.findViewById(R.id.news_title);
            mPublishTime = itemView.findViewById(R.id.detail_author);
            mPublisher = itemView.findViewById(R.id.detail_publish_time);
            mContent = itemView.findViewById(R.id.detail_publisher);
            mLayout = itemView.findViewById(R.id.news_layout);
        }
    }
}
