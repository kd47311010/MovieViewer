package com.home.movieviewer.api;

import android.net.Uri;

/**
 * Created by namhyun on 2015-02-11.
 */
public interface ApiImpl {
    public Uri getUri();

    public int getType();

    public void setParams(String... params);
}