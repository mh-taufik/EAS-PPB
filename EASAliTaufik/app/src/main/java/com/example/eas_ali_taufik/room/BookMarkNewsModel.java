package com.example.eas_ali_taufik.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookMarkNewsModel extends AndroidViewModel {
    private BookMarkNewsRepository mRepository;
    private final LiveData<List<BookMarkNews>> mAllNews;

    public BookMarkNewsModel(@NonNull Application application) {
        super(application);
        mRepository = new BookMarkNewsRepository(application);
        mAllNews = mRepository.getAllbookmark();
    }

    public LiveData<List<BookMarkNews>> getAllNews() {return mAllNews;}

    public void insert(String title,String publisher,String image, String publishtime,String content,String author,String url){
        mRepository.insert(title,publisher,image,publishtime,content,author,url);
    }

    public void delete(BookMarkNews bookMarkNews){mRepository.delete(bookMarkNews);}
}
