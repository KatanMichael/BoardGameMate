package com.michael.boardgamemate.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.michael.boardgamemate.R;
import com.michael.boardgamemate.interfaces.OnItemClickListener;
import com.prof.rssparser.Article;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArcitleViewHolder> {

    private List<Article> list;
    private Context context;
    private OnItemClickListener clickListener;

    public NewsAdapter(Context context, ArrayList<Article> list) {
        this.context = context;
        this.list = list;
    }

    public void setClickListener(OnItemClickListener listener)
    {
        this.clickListener = listener;
    }

    public ArcitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.news_cell, parent, false);
        ArcitleViewHolder holder = new ArcitleViewHolder(listItem);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final NewsAdapter.ArcitleViewHolder holder, int position) {


        final Article currentArticle = list.get(position);

        holder.newsCellTitle.setText(currentArticle.getTitle());
        holder.newsCellsubtitle.setText("Board Game");
        holder.newsCelldate.setText(currentArticle.getPubDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clickListener.onItemClick(currentArticle);
            }
        });

        if(currentArticle.getImage() != null)
        {
            Glide.with(context).load(currentArticle.getImage()).into(holder.newsCellImage);
        }else
        {
            //TODO Find generic placeholder picture of board games
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setlist(List<Article> list)
    {
        Log.d("BoardGameTag","SetList");
        this.list = list;
        this.notifyDataSetChanged();
    }

    public static class ArcitleViewHolder extends RecyclerView.ViewHolder {

        ImageView newsCellImage;
        TextView newsCellTitle;
        TextView newsCellsubtitle;
        TextView newsCelldate;

        public ArcitleViewHolder(@NonNull View itemView)
        {
            super(itemView);

            newsCellImage = itemView.findViewById(R.id.newsCellimage);
            newsCellTitle = itemView.findViewById(R.id.newsCelltitle);
            newsCellsubtitle = itemView.findViewById(R.id.newsCellsubtitle);
            newsCelldate = itemView.findViewById(R.id.newsCelldate);

        }
    }
}

