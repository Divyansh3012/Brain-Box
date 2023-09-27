package com.example.register.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.register.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    String string;
    public HomeAdapter(String str) {
        this.string = str;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.rowlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {

        holder.showQuesEmail.setText(string);
//        holder.showQuesTitle.setText("Question");

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView showQuesTitle, showQuesEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            showQuesTitle = itemView.findViewById(R.id.showQuesEmail);
//            showQuesEmail = itemView.findViewById(R.id.showQuesEmail);

        }
    }
}
