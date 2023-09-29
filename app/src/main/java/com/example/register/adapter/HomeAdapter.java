package com.example.register.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.register.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ArrayList list;
    Context context;
    public HomeAdapter(Context context, ArrayList list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.rowlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        Log.d("TAG22", "onBindViewHolder: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        holder.showQuesTitle.setText((String)list.get(position));
        Log.d("TAG22", "onBindViewHolder: ");
//        holder.showQuesTitle.setText("Question");

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView showQuesTitle, showQuesEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            showQuesTitle = (TextView) itemView.findViewById(R.id.showQuesEmai);
//            showQuesEmail = itemView.findViewById(R.id.showQuesEmail);

        }
    }
}
