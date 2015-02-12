package com.home.movieviewer;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

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

        public View getView() { return mItemView; }
    }

    public void clearItem() {
        mResultContainerList.clear();
        notifyDataSetChanged();
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultContainer container = mResultContainerList.get(position);
        View itemView = holder.getView();
        TextView primaryTextView = (TextView) itemView.findViewById(R.id.content_primary);
        TextView secondaryTextView = (TextView) itemView.findViewById(R.id.content_secondary);
        TextView threeTextView = (TextView) itemView.findViewById(R.id.content_three);
        ImageView thumbnailView = (ImageView) itemView.findViewById(R.id.content_image);

        String primaryText = new StringBuilder(container.getMovieNm())
                .append(" (").append(container.getOpenDt().substring(0, 4)).append(")").toString();

        String secondaryText = new StringBuilder().append("금일 ").append(container.getAudiCnt()).append(" 명")
                .append(" ( 전일대비 ").append(container.getAudiInten()).append("명 )").toString();

        String threeText = new StringBuilder()
                .append(" ( 누적 ").append(container.getAudiAcc()).append("명 )").toString();

        primaryTextView.setText(primaryText);
        secondaryTextView.setText(secondaryText);
        threeTextView.setText(threeText);
        thumbnailView.setImageDrawable(mActivity.getResources().getDrawable(R.drawable.ic_action_toggle_star));
    }


    @Override
    public int getItemCount() {
        return mResultContainerList.size();
    }
}
