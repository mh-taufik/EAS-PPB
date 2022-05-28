package com.example.eas_ali_taufik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    private ImageView mImages;
    private TextView mTitle, mPublishTime, mPublisher, mAuthor, mContent, mLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        mImages = findViewById(R.id.detail_images);
        mTitle = findViewById(R.id.detail_title);
        mPublishTime = findViewById(R.id.detail_publish_time);
        mPublisher = findViewById(R.id.detail_publisher);
        mAuthor = findViewById(R.id.detail_author);
        mContent = findViewById(R.id.detail_content);
        mLink = findViewById(R.id.detail_link);

        Intent intent = getIntent();
        if (intent != null){
            Picasso.get().load(intent.getStringExtra("images")).into(mImages);
            mTitle.setText(intent.getStringExtra("title"));
            mPublishTime.setText(intent.getStringExtra("publish_time"));
            mPublisher.setText(intent.getStringExtra("publisher"));
            mAuthor.setText(intent.getStringExtra("author"));
            mContent.setText(intent.getStringExtra("content"));
            mLink.setText(intent.getStringExtra("link"));
        }
    }
}