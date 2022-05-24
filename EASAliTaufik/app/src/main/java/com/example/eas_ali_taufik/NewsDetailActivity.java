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

        Intent getBundle = getIntent();
        if (getBundle != null){
            Picasso.get().load(getBundle.getBundleExtra("news").getString("images")).into(mImages);
            mTitle.setText(getBundle.getBundleExtra("news").getString("title"));
            mPublishTime.setText(getBundle.getBundleExtra("news").getString("publish_time"));
            mPublisher.setText(getBundle.getBundleExtra("news").getString("publisher"));
            mAuthor.setText(getBundle.getBundleExtra("news").getString("author"));
            mContent.setText(getBundle.getBundleExtra("news").getString("content"));
            mLink.setText(getBundle.getBundleExtra("news").getString("link"));
        }
    }
}