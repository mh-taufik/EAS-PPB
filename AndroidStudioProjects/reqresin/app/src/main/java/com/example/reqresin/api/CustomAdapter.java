package com.example.reqresin.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reqresin.data.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter, CustomAdapter.CustomViewHolder> {

    private List<User> data;
    private Context context;

    public CustomAdapter(Context context,List<User> data){
        this.context = context;
        this.data = data;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public CustomViewHolder(@NonNull View itemView, View mView) {
            super(itemView);
            this.mView = mView;
        }
    }

    @NonNull
    @Override
    public CustomAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
