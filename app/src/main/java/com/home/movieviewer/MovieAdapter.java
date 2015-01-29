package com.home.movieviewer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P400 on 2015-01-29.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<String> mResultContainerList;
    private Activity mActivity;

    public MovieAdapter(Activity mActivity) {
        mResultContainerList = new ArrayList<String>();
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

    public void addItem(String container) {
        mResultContainerList.add(container);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        mResultContainerList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View itemView = holder.getView();
    }

    @Override
    public int getItemCount() {
        return mResultContainerList.size();
    }
}
