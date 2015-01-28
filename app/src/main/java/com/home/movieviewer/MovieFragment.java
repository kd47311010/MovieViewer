package com.home.movieviewer;

import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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
//
//    public class VideoBrowseActivity extends ActionBarActivity
//            //implements VideoBrowseFragment.Callbacks {
//
//        private static final String TAG = "VideoBrowseActivity";
//
//        private View  mToolbar;
//        private View mTabContainer;
//
//        private int mMaxTabContainerY;
//        private int mMinTabContainerY;
//        private int mMaxAppBarY;
//        private int mMinAppBarY;
//        private int mActionbarHeight;
//
//        private DrawerLayout mDrawerLayout;
//        private ActionBarDrawerToggle mDrawerToggle;
//        private RecyclerView.OnScrollListener mScrollListener;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_video_browse);
//
//            TypedValue tv = new TypedValue();
//            if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
//                mActionbarHeight
//                        = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
//            }
//
//            initToolbar();
//            //initFragmentPager();
//            initNaviDrawer();
//            initParallaxEffect();
//        }
//
//    private void initToolbar() {
//
//        Log.d(TAG, "initToolbar");
//        //mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        //setSupportActionBar(mToolbar);
//    }
//
//
//
//
//

//
//
//
//        allVideos.setOnClickListener(clickListener);
//        myVideos.setOnClickListener(clickListener);
//        shopping.setOnClickListener(clickListener);
//        settings.setOnClickListener(clickListener);
//        help.setOnClickListener(clickListener);
//    }
//
//    private void initParallaxEffect() {
//
//        mMaxTabContainerY = mActionbarHeight;
//        mMinTabContainerY = 0;
//
//        mMinAppBarY = -mActionbarHeight;
//        mMaxAppBarY = 0;
//
//        mScrollListener = new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                // IGNORED
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                // TODO
//            }
//        };
//    }
//
//
//    private void showHome() {
//        mDrawerLayout.closeDrawers();
//    }
//    private void showMyMovies() {
//        mDrawerLayout.closeDrawers();
//    }
//
//    private void showPurchase_Movies() {
//        mDrawerLayout.closeDrawers();
//    }
//
//    private void showCheck_Tickets() {
//        mDrawerLayout.closeDrawers();
//    }
//
//    private void showMy_Page() {
//        mDrawerLayout.closeDrawers();
//    }
//
//    private void showSettings() {
//        mDrawerLayout.closeDrawers();
//    }
//
//    private void showHelp() {
//        mDrawerLayout.closeDrawers();
//    }


    private class RequestDataTask extends AsyncTask<Uri, Void, String> {

        @Override
        protected String doInBackground(Uri... params) {
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
            return response.body().toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // Do something
            try {
                JSONObject jsonObject = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
