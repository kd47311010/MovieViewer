package com.home.movieviewer;

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



    public class VideoBrowseActivity extends ActionBarActivity
            //implements VideoBrowseFragment.Callbacks {

        private static final String TAG = "VideoBrowseActivity";

        private View  mToolbar;
        private View mTabContainer;

        private int mMaxTabContainerY;
        private int mMinTabContainerY;
        private int mMaxAppBarY;
        private int mMinAppBarY;
        private int mActionbarHeight;

        private DrawerLayout mDrawerLayout;
        private ActionBarDrawerToggle mDrawerToggle;
        private RecyclerView.OnScrollListener mScrollListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_video_browse);

            TypedValue tv = new TypedValue();
            if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
                mActionbarHeight
                        = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            }

            initToolbar();
            initFragmentPager();
            initNaviDrawer();
            initParallaxEffect();
        }



    private void initNaviDrawer() {

        Log.d(TAG, "initNaviDrawer");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final View drawerList = findViewById(R.id.left_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerClosed(View view) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        // Handle Navigation Click Events
        View.OnClickListener clickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.left_drawer_home:
                        showHome();
                        break;
                    case R.id.left_drawer_my_movies:
                        showMyMovies();
                        break;
                    case R.id.left_drawer_purchase_Movies:
                        showPurchase_Movies();
                        break;
                    case R.id.left_drawer_check_tickets:
                        showCheck_Tickets();
                        break;
                    case R.id.left_drawer_my_page:
                        showMy_Page();
                        break;
                    case R.id.left_drawer_settings:
                        showSettings();
                        break;
                    case R.id.left_drawer_help:
                        showHelp();
                        break;
                }
            }

        };


        View allVideos = drawerList.findViewById(R.id.left_drawer_home);
        View myVideos = drawerList.findViewById(R.id.left_drawer_my_movies);
        View shopping = drawerList.findViewById(R.id.left_drawer_purchase_Movies);
        View check = drawerList.findViewById(R.id.left_drawer_check_tickets);
        View mypage = drawerList.findViewById(R.id.left_drawer_my_page);
        View settings = drawerList.findViewById(R.id.left_drawer_settings);
        View help = drawerList.findViewById(R.id.left_drawer_help);

        allVideos.setOnClickListener(clickListener);
        myVideos.setOnClickListener(clickListener);
        shopping.setOnClickListener(clickListener);
        settings.setOnClickListener(clickListener);
        help.setOnClickListener(clickListener);
    }

    private void showHome() {
        mDrawerLayout.closeDrawers();
    }
    private void showMyMovies() {
        mDrawerLayout.closeDrawers();
    }

    private void showPurchase_Movies() {
        mDrawerLayout.closeDrawers();
    }

    private void showCheck_Tickets() {
        mDrawerLayout.closeDrawers();
    }

    private void showMy_Page() {
        mDrawerLayout.closeDrawers();
    }

    private void showSettings() {
        mDrawerLayout.closeDrawers();
    }

    private void showHelp() {
        mDrawerLayout.closeDrawers();
    }


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

        }
    }
}
