# MovieViewerAssist

Library for MovieViewer

## How to use

## Kobis Api

- Search Daily Box Office List

```java
KobisApiService service = ServiceGenerator.createService(KobisApiService.class);
Observable<BoxOfficeList> observable = service.searchDailyBoxOfficeList(YOUR_API_KEY, SearchDate);
MovieViewerAssist.runObservable(observable, new Action1<BoxOfficeList>() {
    @Override
    public void call(BoxOfficeList boxOfficeList) {
        // Update UI
    }
});
```

- Search Movie Information

```java
KobisApiService service = ServiceGenerator.createService(KobisApiService.class);
Observable<DetailInfo> observable = service.searchMovieInfo(YOUR_API_KEY, movieCode);
MovieViewerAssist.runObservable(observable, new Action1<DetailInfo>() {
    @Override
    public void call(DetailInfo datilInfo) {
        // Update UI
    }
});
```

## The Movie DB API

- Search Movie

```java
TheMovieApiService service = ServiceGenerator.createService(TheMovieApiService.class);
Observable<MovieResult> observable = service.searchMovieInfo(YOUR_API_KEY, MovieName);
MovieViewerAssist.runObservable(observable, new Action1<MovieResult>() {
    @Override
    public void call(MovieResult movieResult) {
        // Update UI
    }
});
```
