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

import com.home.movieviewer.R;
import com.home.movieviewer.beans.MovieBean;
import com.namhyun.movieviewerassist.ServiceGenerator;
import com.namhyun.movieviewerassist.models.kobis.DailyBoxOffice;
import com.namhyun.movieviewerassist.models.kobis.DailyBoxOfficeList;
import com.namhyun.movieviewerassist.models.tmdb.Movie;
import com.namhyun.movieviewerassist.services.KobisApiService;
import com.namhyun.movieviewerassist.services.TheMovieApiService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;

/**
 * Created by namhyun on 2015-01-23.
 */
public class MovieFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public MovieAdapter mAdapter;
    public SwipeRefreshLayout mSwipeRefreshLayout;

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
                mAdapter.clearItem();
                updateData(getToday());
            }
        });
        updateData(getToday());
        return rootView;
    }

    private String getToday() {
        final String dateFormat = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return simpleDateFormat.format(calendar.getTime());
    }

    private void updateData(String date) {
        final String KOBIS_API_KEY = "7ffbb106d667ab3ddf34dc7ba8ff2c65";
        final String TMDB_API_KEY = "848790748cc5407875ba6ae106a18f24";
        new DailyBoxOfficeTask().execute(date, KOBIS_API_KEY, TMDB_API_KEY);
    }

    public class DailyBoxOfficeTask extends AsyncTask<String, Void, List<MovieBean>> {

        @Override
        protected List<MovieBean> doInBackground(String... params) {
            List<MovieBean> movieBeanList = new ArrayList<>();

            final String kobisApiKey = params[1];
            final String tmdbApiKey = params[2];
            final String date = params[0];

            KobisApiService kobisApiService = ServiceGenerator.createService(KobisApiService.class);
            TheMovieApiService theMovieApiService = ServiceGenerator.createService(TheMovieApiService.class);

            if (kobisApiService != null) {
                try {
                    Call<DailyBoxOffice> boxOfficeCall
                            = kobisApiService.getDailyBoxOffice(kobisApiKey, date);
                    DailyBoxOffice dailyBoxOffice = boxOfficeCall.execute().body();
                    List<DailyBoxOfficeList> lists = dailyBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList();
                    for (DailyBoxOfficeList item : lists) {
                        Call<Movie> movieCall = theMovieApiService.searchMovie(tmdbApiKey, item.getMovieNm());
                        Movie movie =  movieCall.execute().body();
                        movieBeanList.add(new MovieBean(item, movie));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return movieBeanList;
        }

        @Override
        protected void onPostExecute(List<MovieBean> movieBean) {
            super.onPostExecute(movieBean);
            if (mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(false);
            mAdapter.addItems(movieBean);
        }
    }
}
