package com.home.movieviewer.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.home.movieviewer.R;
import com.home.movieviewer.beans.MovieBean;
import com.namhyun.movieviewerassist.Util;
import com.namhyun.movieviewerassist.models.tmdb.ImageSizeOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P400 on 2015-01-29.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<MovieBean> mResultBeanList;
    private Activity mActivity;

    public MovieAdapter(Activity mActivity) {
        mResultBeanList = new ArrayList<>();
        this.mActivity = mActivity;
    }

    public void clearItem() {
        mResultBeanList.clear();
        notifyDataSetChanged();
    }

    public void addItem(MovieBean item) {
        mResultBeanList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<MovieBean> items) {
        mResultBeanList.addAll(items);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        mResultBeanList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MovieBean container = mResultBeanList.get(position);
        View itemView = holder.getView();
        TextView primaryTextView = (TextView) itemView.findViewById(R.id.content_primary);
        TextView secondaryTextView = (TextView) itemView.findViewById(R.id.content_secondary);
        TextView rankTextView = (TextView) itemView.findViewById(R.id.content_rank);
        ImageView thumbnailView = (ImageView) itemView.findViewById(R.id.content_image);
        ImageView rankImageView = (ImageView) itemView.findViewById(R.id.content_rank_background);

        String primaryText = new StringBuilder().append(" ").append(container.getBoxOfficeList().getMovieNm())
                .append(" (").append(container.getBoxOfficeList().getOpenDt().substring(0, 4)).append(")").toString();

        String secondaryText = new StringBuilder()
                .append("누적 " + container.getBoxOfficeList().getAudiAcc() + " 명")
                .append(" ( ").append(container.getBoxOfficeList().getRankInten()).append(" 위 ) ").toString();

        primaryTextView.setText(primaryText);
        secondaryTextView.setText(secondaryText);
        rankTextView.setText(container.getBoxOfficeList().getRank());
        if (container.getTmdbMovieInfo().getResults().size() != 0) {
            Glide.with(mActivity)
                    .load(Util.TheMovieApiUtil.getImageUrl(container.getTmdbMovieInfo().getResults().get(0).getPosterPath(),
                            ImageSizeOptions.Poster.ORIGINAL.toString()))
                    .crossFade()
                    .centerCrop()
                    .placeholder(R.color.colorPrimaryLight)
                    .into(thumbnailView);
        } else {
            thumbnailView.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.colorPrimaryLight));
        }
        setRankImage(rankImageView);
    }

    private void setRankImage(ImageView view) {
        Bitmap bitmap = null;
        view.setColorFilter(mActivity.getResources().getColor(R.color.colorAccent));
        if (view.getDrawable() instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) view.getDrawable()).getBitmap();
            setCircleImage(bitmap, view);
        }
    }

    private void setCircleImage(Bitmap bitmap, ImageView view) {
        RoundedBitmapDrawable bitmapDrawable =
                RoundedBitmapDrawableFactory.create(mActivity.getResources(), bitmap);
        bitmapDrawable.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()) / 2.0f);
        bitmapDrawable.setAntiAlias(true);
        view.setImageDrawable(bitmapDrawable);
    }

    @Override
    public int getItemCount() {
        return mResultBeanList.size();
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
}
