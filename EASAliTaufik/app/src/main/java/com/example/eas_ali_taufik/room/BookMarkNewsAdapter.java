package com.example.eas_ali_taufik.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookMarkNewsAdapter extends RecyclerView.Adapter<BookMarkNewsAdapter.BookMarkViewHolder>{
    private List<BookMarkNews> dataNews;
    private Context context;
    private AppDatabase database;


    public BookMarkNewsAdapter(List<BookMarkNews> data, Context context) {
        this.dataNews = data;
        this.context = context;
    }

    @NonNull
    @Override
    public BookMarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_news, parent, false);
        return new BookMarkNewsAdapter.BookMarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookMarkViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d("TAG", "onBindViewHolder: "+dataNews.get(position).getPublishtime());

        String formattedDate = dataNews.get(position).getPublishtime();
        Log.d("TAG", "onBindViewHolder: time"+ formattedDate);
        Picasso.get().load(dataNews.get(position).getImage()).into(holder.mImages);
        holder.mTitle.setText(dataNews.get(position).getTitle());
        holder.mPublishTime.setText(formattedDate);
        holder.mPublisher.setText(dataNews.get(position).getPublisher());
        holder.mContent.setText(dataNews.get(position).getContent());
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
                        database.bookMarkNewsDao().insertAll(dataNews.get(position).getTitle(),dataNews.get(position).publisher,dataNews.get(position).getImage(),dataNews.get(position).getPublishtime(),dataNews.get(position).getContent(),dataNews.get(position).getAuthor(),dataNews.get(position).getUrl());
                        Log.d("TAG", "onBindViewHolder: bookmark checked"+checkedId);
                }
            }else {
                if (group.getCheckedButtonId() == View.NO_ID){
                    if(bookMarkNews.getTitle()!=null){
                        database.bookMarkNewsDao().delete(bookMarkNews);
                    }
                    Log.d("TAG", "onBindViewHolder: bookmark uncheked");
                }
            }
        });
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                BookMarkNews news = dataNews.get(position);
                intent.putExtra("images",news.getImage());
                intent.putExtra("title",news.getTitle());
                intent.putExtra("publish_time",news.getPublishtime());
                intent.putExtra("publisher",news.getPublisher());
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


    public class BookMarkViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImages;
        private TextView mTitle, mPublishTime, mPublisher, mContent;
        private ConstraintLayout mLayout;
        private MaterialButtonToggleGroup mTG;
        public BookMarkViewHolder(@NonNull View itemView) {
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
