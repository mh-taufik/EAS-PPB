package com.example.eas_ali_taufik.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    }

    @Override
    public int getItemCount() {
        return dataNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImages;
        private TextView mTitle, mPublishTime, mPublisher, mContent;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImages = itemView.findViewById(R.id.news_images);
            mTitle = itemView.findViewById(R.id.news_title);
            mPublishTime = itemView.findViewById(R.id.news_publish_time);
            mPublisher = itemView.findViewById(R.id.news_publisher);
            mContent = itemView.findViewById(R.id.news_content);
        }
    }
}
