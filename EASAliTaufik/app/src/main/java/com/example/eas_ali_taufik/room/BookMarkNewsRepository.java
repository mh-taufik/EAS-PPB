package com.example.eas_ali_taufik.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookMarkNewsRepository {
    private BookMarkNewsDao mBookmarkDao;
    private LiveData<List<BookMarkNews>> mAllBookmark;

    BookMarkNewsRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        mBookmarkDao = db.bookMarkNewsDao();
        mAllBookmark = mBookmarkDao.getAllLive();
    }

    LiveData<List<BookMarkNews>> getAllbookmark(){return mAllBookmark; }

    void insert(String title,String publisher,String image, String publishtime,String content,String author,String url){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mBookmarkDao.insertAll(title,publisher,image,publishtime,content,author,url);
        });
    }

    void delete(BookMarkNews bookMarkNews){
        AppDatabase.databaseWriteExecutor.execute(()->{
            mBookmarkDao.delete(bookMarkNews);
        });
    }

}
