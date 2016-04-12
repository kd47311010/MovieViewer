package com.namhyun.movieviewerassist;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieViewerAssist {

    public static <T> void runObservable(Observable<T> observable, Action1<? super T> onNext) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(onNext);
    }
}
