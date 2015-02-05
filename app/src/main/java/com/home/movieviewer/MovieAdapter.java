package com.home.movieviewer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

/**
 * Created by P400 on 2015-01-29.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<ResultContainer> mResultContainerList;
    private Activity mActivity;

    public MovieAdapter(Activity mActivity) {
        mResultContainerList = new ArrayList<ResultContainer>();
        this.mActivity = mActivity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mItemView = null;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }

        public View getView() {
            return mItemView;
        }
    }

    public void addItem(ResultContainer container) {
        mResultContainerList.add(container);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        mResultContainerList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View itemView = holder.getView();
        ResultContainer container = mResultContainerList.get(position);


    }


    @Override
    public int getItemCount() {
        return mResultContainerList.size();
    }
}
