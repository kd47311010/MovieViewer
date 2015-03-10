package com.home.movieviewer;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;

/**
 * Created by namhyun on 2015-03-09.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Caculate Memory Size
        MemorySizeCalculator calculator = new MemorySizeCalculator(this);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        final int defaultDiskCacheSize = 1024 * 1024 * 10; // 10MB

        // Initial Glide
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH);
        if (!Glide.isSetup()) {
            Glide.setup(new GlideBuilder(this)
                    .setDiskCache(DiskLruCacheWrapper.get(Glide.getPhotoCacheDir(this), defaultDiskCacheSize))
                    .setMemoryCache(new LruResourceCache(defaultMemoryCacheSize))
                    .setBitmapPool(new LruBitmapPool(defaultBitmapPoolSize)));
        }
    }
}
