package com.home.movieviewer.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.home.movieviewer.R;
import com.namhyun.movieviewerassist.ServiceGenerator;
import com.namhyun.movieviewerassist.models.BoxOfficeList;
import com.namhyun.movieviewerassist.services.KobisApiService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        final String API_KEY = "7ffbb106d667ab3ddf34dc7ba8ff2c65";

        KobisApiService service = ServiceGenerator.createService(KobisApiService.class);
        if (service != null) {
            Observable<BoxOfficeList> observable =
                    service.searchDailyBoxOfficeList(API_KEY, date);
            observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<BoxOfficeList>() {
                        @Override
                        public void onCompleted() {
                            Log.d("KobisApi", "Completed!");
                        }
                        @Override
                        public void onError(Throwable e) {
                            Log.e("KobisApi", "error: " + e.getMessage());
                        }
                        @Override
                        public void onNext(BoxOfficeList boxOfficeList) {
                            for (BoxOfficeList.BoxOfficeMovie movie : boxOfficeList.get()) {
                                Log.d("KobisApi", movie.getRank() + " : " + movie.getMovieNm());
                                mAdapter.addItem(movie);
                            }
                        }
                    });
        }
    }
}
