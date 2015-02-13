package com.home.movieviewer;

import android.os.AsyncTask;
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

import com.home.movieviewer.api.ApiImpl;
import com.home.movieviewer.api.KobisApi;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    private void updateData(){
        Log.d("MovieFragment", getToday());
        KobisApi kobisApi = new KobisApi(KobisApi.TYPE_DAILY_BOX_OFFICE);
        kobisApi.setParams(getToday());
        new RequestDataTask().execute(kobisApi);
    }

    private String getToday(){
        final String dateFormat = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return simpleDateFormat.format(calendar.getTime());
    }


    private class RequestDataTask extends AsyncTask<ApiImpl, Void, List<ResultContainer>> {

        private List<ResultContainer> getCommonCodeFromJson(String jsonStr) {
            final String OBJECT_BOX_OFFICE_RESULT = "boxOfficeResult";
            final String ARRAY_DAILY_BOX_OFFICE_LIST = "dailyBoxOfficeList";

            List<ResultContainer> containers = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONObject boxOfficeResult = jsonObject.getJSONObject(OBJECT_BOX_OFFICE_RESULT);
                JSONArray dailyBoxOfficeList = boxOfficeResult.getJSONArray(ARRAY_DAILY_BOX_OFFICE_LIST);

                for (int i = 0; i < dailyBoxOfficeList.length(); i++) {
                    JSONObject object = dailyBoxOfficeList.getJSONObject(i);
                    String rank = object.getString("rank"); //순위
                    String rankInten = object.getString("rankInten"); //전일대비 증감분
                    String rankOldAndNew = object.getString("rankOldAndNew"); //랭크 신규 진입 여부
                    String movieNm = object.getString("movieNm"); //영화명
                    String openDt = object.getString("openDt"); //개봉일
                    String audiCnt = object.getString("audiCnt"); //해당일 관객 수
                    String audiInten = object.getString("audiInten"); //관객 수 증감 분
                    String audiAcc = object.getString("audiAcc"); //누적 관객 수

                    ResultContainer resultContainer = new ResultContainer();
                    resultContainer.setRank(rank);
                    resultContainer.setRankInten(rankInten);
                    resultContainer.setRankOldAndNew(rankOldAndNew);
                    resultContainer.setMovieNm(movieNm);
                    resultContainer.setOpenDt(openDt);
                    resultContainer.setAudiCnt(audiCnt);
                    resultContainer.setAudiInten(audiInten);
                    resultContainer.setAudiAcc(audiAcc);

                    containers.add(resultContainer);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return containers;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (!mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        }

        @Override
        protected List<ResultContainer> doInBackground(ApiImpl... params) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = null;
            String result = null;
            try {
                Request request = new Request.Builder()
                        .url(params[0].getUri().toString())
                        .build();
                response = okHttpClient.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (params[0].getType() == KobisApi.TYPE_DAILY_BOX_OFFICE) {
                return getCommonCodeFromJson(result);
            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<ResultContainer> resultContainers) {
            super.onPostExecute(resultContainers);
            // Do something
            mAdapter.clearItem();
            if (resultContainers != null) {
                for (ResultContainer container : resultContainers) {
                    mAdapter.addItem(container);
                }
            }
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
