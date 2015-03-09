package com.home.movieviewer.ui;

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

import com.home.movieviewer.R;
import com.home.movieviewer.beans.ResultBean;
import com.home.movieviewer.api.KobisApi;
import com.home.movieviewer.api.TheMovieDbApi;
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

    private void updateData() {
        Log.d("MovieFragment", getToday());
        new RequestTask().execute(KobisApi.TYPE_DAILY_BOX_OFFICE);
    }

    private String getToday() {
        final String dateFormat = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return simpleDateFormat.format(calendar.getTime());
    }


    private class RequestTask extends AsyncTask<Integer, Void, List<ResultBean>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (!mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        }

        @Override
        protected List<ResultBean> doInBackground(Integer... params) {
            OkHttpClient okHttpClient = new OkHttpClient();
            String result = null;
            List<ResultBean> resultBeans = null;
            try {
                KobisApi kobisApi = new KobisApi(params[0]);
                kobisApi.setParams(getToday());
                result = requestDataFromURL(okHttpClient, kobisApi.getUri().toString());
                resultBeans = getCommonCodeFromJson(result);

                TheMovieDbApi theMovieDbApi = null;
                String movieId = null;
                String posterUrl = null;
                for (ResultBean container : resultBeans) {
                    theMovieDbApi = new TheMovieDbApi(TheMovieDbApi.TYPE_SEARCH_MOVIE);
                    theMovieDbApi.setParams(container.getMovieNm());

                    result = requestDataFromURL(okHttpClient, theMovieDbApi.getUri().toString());

                    movieId = TheMovieDbApi.getMovieIdFromJson(result);
                    if(movieId == null)
                        continue;

                    posterUrl = TheMovieDbApi.getMoviePosterUrlFromJson(result);

//                    theMovieDbApi.setType(TheMovieDbApi.TYPE_MOVIE_IMAGE);
//                    theMovieDbApi.setParams(movieId, "ko");
//
//                    result = requestDataFromURL(okHttpClient, theMovieDbApi.getUri().toString());
//
//                    String filePath = TheMovieDbApi.getMovieImageUrlFromJson(result, 0);
                    container.setThumbnailUrl(TheMovieDbApi.createImageUrl(posterUrl));
                }
                return resultBeans;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ResultBean> resultBeans) {
            super.onPostExecute(resultBeans);
            // Do something
            mAdapter.clearItem();
            if (resultBeans != null) {
                for (ResultBean container : resultBeans) {
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

//        private String getThumbnailUrlFromJson(String jsonStr) {
//            final String KEY_ITEM = "item";
//            final String KEY_THUMBNAIL = "thumbnail";
//            try {
//                Log.d("MovieFragment", jsonStr);
//                JSONObject jsonObject = new JSONObject(jsonStr);
//                JSONObject itemObject = jsonObject.getJSONObject(KEY_ITEM);
//                return itemObject.getString(KEY_THUMBNAIL);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }

        private List<ResultBean> getCommonCodeFromJson(String jsonStr) {
            final String OBJECT_BOX_OFFICE_RESULT = "boxOfficeResult";
            final String ARRAY_DAILY_BOX_OFFICE_LIST = "dailyBoxOfficeList";

            List<ResultBean> containers = new ArrayList<>();
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

                    ResultBean resultBean = new ResultBean();
                    resultBean.setRank(rank);
                    resultBean.setRankInten(rankInten);
                    resultBean.setRankOldAndNew(rankOldAndNew);
                    resultBean.setMovieNm(movieNm);
                    resultBean.setOpenDt(openDt);
                    resultBean.setAudiCnt(audiCnt);
                    resultBean.setAudiInten(audiInten);
                    resultBean.setAudiAcc(audiAcc);

                    containers.add(resultBean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return containers;
        }
    }
}
