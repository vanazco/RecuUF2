package com.example.vast.recuuf2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder> {

    List<Post> list;

    PostRecyclerAdapter(List<Post> list){
        this.list = list;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View Postitem = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(Postitem);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = list.get(position);
        holder.postContext.setText(post.context);
        holder.poemTitle.setText(post.title);
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView poemTitle;
        private TextView postContext;
        PostViewHolder(View itemPoem) {
            super(itemPoem);
            poemTitle = itemPoem.findViewById(R.id.post_title);
            postContext = itemPoem.findViewById(R.id.post_context);
        }
    }
}