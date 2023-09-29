package com.example.register.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.register.R;
import com.example.register.adapter.HomeAdapter;

import java.util.ArrayList;

public class NewAdapter extends  RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    ArrayList list;
    Context context;
    public NewAdapter(Context context, ArrayList list) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context1 = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context1);
        View photoView = inflater.inflate(R.layout.rowlayout,parent,false);
//        HomeAdapter.ViewHolder viewHolder = new HomeAdapter.ViewHolder(photoView);
        Log.d("TAG22", "onBindViewHolder: ");
//        return viewHolder;
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
