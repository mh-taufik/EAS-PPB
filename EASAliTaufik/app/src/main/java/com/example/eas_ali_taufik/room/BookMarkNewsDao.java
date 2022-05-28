package com.example.eas_ali_taufik.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookMarkNewsDao {
    @Query("SELECT * FROM bookmarknews")
    List<BookMarkNews> getAll();

    @Query("SELECT * FROM bookmarknews")
    LiveData<List<BookMarkNews>> getAllLive();

    @Query("INSERT INTO bookmarknews (title,publisher,image,publishtime,content,author,url) VALUES (:title,:publisher,:image,:publishtime,:content,:author,:url)")
    void insertAll(String title,String publisher,String image, String publishtime,String content,String author,String url);

    @Delete
    void delete(BookMarkNews bookMarkNews);

    @Query("SELECT * FROM bookmarknews WHERE title=:title")
    BookMarkNews get(String title);
}
