package com.example.test;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView userId,title, body;
    private Context mContext;
    public PostViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        userId = itemView.findViewById(R.id.user_id);
        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body);
    }

    void setValue(Post post){
        userId.setText(""+ post.getUserID());
        title.setText(post.getTitle());
        body.setText(post.getBody());
    }
}
