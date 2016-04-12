# MovieViewerAssist

Library for MovieViewer

# Example

## Kobis Api

- Search Daily Box Office List

```java
KobisApiService service = ServiceGenerator.createService(KobisApiService.class);
if (service != null) {
    Observable<BoxOfficeList> observable =
            service.searchDailyBoxOfficeList(YOUR_API_KEY, SearchDate);
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
                    }
                }
            });
}
```

- Search Movie Information

```java
KobisApiService service = ServiceGenerator.createService(KobisApiService.class);
if (service != null) {
    Observable<DetailInfo> observable = service.searchMovieInfo(YOUR_API_KEY, MovieCode);
    observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<DetailInfo>() {
                @Override
                public void onCompleted() {
                    Log.d("KobisApi", "Completed!");
                }
                @Override
                public void onError(Throwable e) {
                    Log.e("KobisApi", "error: " + e.getMessage());
                }
                @Override
                public void onNext(DetailInfo detailInfo) {
                    DetailInfo.MovieInfo info = detailInfo.getInfo();
                    Log.d("KobisApi", info.getMovieNm() + " Opened: " + info.getOpenDt());
                }
            });
}
```

## The Movie DB API

- Search Movie

```java
TheMovieApiService service = ServiceGenerator.createService(TheMovieApiService.class);
if (service != null) {
    Observable<MovieResult> observable =
            service.searchMovie(YOUR_API_KEY, MovieName);
    observable.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<MovieResult>() {
                @Override
                public void onCompleted() {
                    Log.d("TheMovie", "Completed!");
                }
                @Override
                public void onError(Throwable e) {
                    Log.e("TheMovie", "error: " + e.getMessage());
                }
                @Override
                public void onNext(MovieResult movieResult) {
                    for (MovieResult.Movie movie : movieResult.get()) {
                        Log.d("TheMovie", movie.getTitle() +
                            " poster :" + movie.getPosterPath());
                    }
                }
            });
}
```
