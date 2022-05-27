package com.example.eas_ali_taufik.retrofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Picasso.get().load(dataNews.get(position).getUrlToImage()).into(holder.mImages);
        holder.mTitle.setText(dataNews.get(position).getTitle());
        holder.mPublishTime.setText(dataNews.get(position).getPublishedAt());
        holder.mPublisher.setText(dataNews.get(position).getSource().getName());
        holder.mContent.setText(dataNews.get(position).getDescription());
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
                intent.putExtra("content",news.getContent());
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
