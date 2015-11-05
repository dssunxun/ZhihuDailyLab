package com.renova.zhihudailylab.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renova.zhihudailylab.R;
import com.renova.zhihudailylab.entities.LatestNews;

import java.util.List;

/**
 *
 * Created by Renova on 2015/10/30.
 */
public class LatestNewsAdapter extends RecyclerView.Adapter<LatestNewsAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<LatestNews.Storie> storieList;

    public LatestNewsAdapter(Context context,
                             List<LatestNews.Storie> storieList) {
        this.context = context;
        this.mInflater  = LayoutInflater.from(context);
        this.storieList = storieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(mInflater.inflate(R.layout.item_cardview_latestnews,
                parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_latest_news_title.setText(storieList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return storieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_latest_news_title;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_latest_news_title= (TextView) itemView.findViewById(R.id.tv_latest_news_title);
        }
    }
}
