package com.home.movieviewer.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.home.movieviewer.R;
import com.home.movieviewer.beans.MovieBean;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by namhyun on 2015-01-23.
 */
public class MovieFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MovieAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.content_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MovieAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do something
                // e.g. Request data
                updateData();
            }
        });
        // Data request example
        updateData();
        return rootView;
    }

    private void updateData() {
        new RequestTask().execute();
    }

    private String getToday() {
        final String dateFormat = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return simpleDateFormat.format(calendar.getTime());
    }

    private class RequestTask extends AsyncTask<Void, Void, MovieBean[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (!mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        }

        @Override
        protected MovieBean[] doInBackground(Void... params) {
            final String BASE_URL = "http://carbide-primer-853.appspot.com/moviemove";
            OkHttpClient okHttpClient = new OkHttpClient();
            MovieBean[] beans = null;
            String result = null;

            try {
                result = requestDataFromURL(okHttpClient, BASE_URL);
                Gson gson = new Gson();
                beans = gson.fromJson(result, MovieBean[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return beans;
        }

        @Override
        protected void onPostExecute(MovieBean[] movieBeans) {
            super.onPostExecute(movieBeans);
            mAdapter.clearItem();
            if (movieBeans != null) {
                for (MovieBean container : movieBeans) {
                    mAdapter.addItem(container);
                }
            }
            mSwipeRefreshLayout.setRefreshing(false);
        }

        private String requestDataFromURL(OkHttpClient okHttpClient, String url) throws IOException {
            Request request = null;
            Response response = null;
            request = new Request.Builder()
                    .url(url)
                    .build();
            response = okHttpClient.newCall(request).execute();
            return response.body().string();
        }
    }
}
