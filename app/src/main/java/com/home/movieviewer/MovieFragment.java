package com.home.movieviewer;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by namhyun on 2015-01-23.
 */
public class MovieFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.content_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);

        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do something
                // e.g. Request data
            }
        });
        // Data request example
        //new RequestDataTask().execute(MovieApi.getUri(MovieApi.TYPE_COMMON_CODE));
        return rootView;
    }

    private class RequestDataTask extends AsyncTask<Uri, Void, List<ResultContainer>> {

        private List<ResultContainer> getValueFromSource(String jsonStr) {
            final String OBJECT_BOX_OFFICE_RESULT = "boxOfficeResult";
            final String ARRAY_DAILY_BOX_OFFICE_LIST = "dailyBoxOfficeList";

            List<ResultContainer> containers = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONObject boxOfficeResult = jsonObject.getJSONObject(OBJECT_BOX_OFFICE_RESULT);
                JSONArray dailyBoxOfficeList = boxOfficeResult.getJSONArray(ARRAY_DAILY_BOX_OFFICE_LIST);

                for (int i = 0; i < dailyBoxOfficeList.length(); i++) {
                    JSONObject object = dailyBoxOfficeList.getJSONObject(i);
                    String rnum = object.getString("rnum");
                    String rank = object.getString("rank");
                    String rankInten = object.getString("rankInten");
                    String rankOldAndNew = object.getString("rankOldAndNew");
                    String movieNm = object.getString("movieNm");
                    String openDt = object.getString("openDt");
                    String audiCnt = object.getString("audiCnt");

                    containers.add(new ResultContainer(rnum, rank, rankInten, rankOldAndNew, movieNm, openDt, audiCnt));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return containers;
        }

        @Override
        protected List<ResultContainer> doInBackground(Uri... params) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = null;
            try {
                Request request = new Request.Builder()
                        .url(params[0].toString())
                        .build();
                response = okHttpClient.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return getValueFromSource(response.body().toString());
        }

        @Override
        protected void onPostExecute(List<ResultContainer> resultContainers) {
            super.onPostExecute(resultContainers);
            // Do something
            for(ResultContainer resultContainer : resultContainers){
//+addItem
            }
        }
    }

    private class ResultContainer{
        private String rnum;
        private String rank;
        private String rankInten;
        private String rankOldAndNew;
        private String movieNm;
        private String openDt;
        private String audiCnt;

        private ResultContainer(String rnum, String rank, String rankInten, String rankOldAndNew, String movieNm, String openDt, String audiCnt) {
            this.rnum = rnum;
            this.rank = rank;
            this.rankInten = rankInten;
            this.rankOldAndNew = rankOldAndNew;
            this.movieNm = movieNm;
            this.openDt = openDt;
            this.audiCnt = audiCnt;
        }

        public String getRnum() {
            return rnum;
        }

        public String getRank() {
            return rank;
        }

        public String getRankInten() {
            return rankInten;
        }

        public String getRankOldAndNew() {
            return rankOldAndNew;
        }

        public String getMovieNm() {
            return movieNm;
        }

        public String getOpenDt() {
            return openDt;
        }

        public String getAudiCnt() {
            return audiCnt;
        }
    }
}
