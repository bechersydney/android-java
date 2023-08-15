package com.example.test;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {
    private List<Post> mPosts;
    private Context mContext;
    private PostViewHolder mViewHolder;
    private LayoutInflater mLayoutInflater;
    public PostAdapter(Context context, List<Post> posts){
        this.mContext = context;
        this.mPosts = posts;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mViewHolder = new PostViewHolder(mLayoutInflater.inflate(R.layout.post,parent,false), mContext);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = mPosts.get(position);
        mViewHolder = (PostViewHolder) holder;
        mViewHolder.setValue(post);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }
    public void filterPost(String s){
        List<Post> filteredPost = new ArrayList<>();
        for(Post post: mPosts){
            if(post.getTitle().toLowerCase().contains(s.toLowerCase())){
                filteredPost.add(post);
            }
        }
        mPosts = filteredPost;
        notifyDataSetChanged();
    }
}


