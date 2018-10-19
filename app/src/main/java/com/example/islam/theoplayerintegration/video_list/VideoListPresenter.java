package com.example.islam.theoplayerintegration.video_list;

import com.example.islam.theoplayerintegration.app.EspressoIdlingResource;
import com.example.islam.theoplayerintegration.models.VideoListItem;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class VideoListPresenter implements VideoListContract.Presenter {
    private VideoListContract.View mView;
    private VideoListBusiness mVideoListBusiness;
    private CompositeDisposable mSubscriptions;

    @Inject
    public VideoListPresenter(VideoListContract.View view, VideoListBusiness videoListBusiness) {
        this.mView = view;
        this.mVideoListBusiness = videoListBusiness;
        mSubscriptions = new CompositeDisposable();
        mView.setPresenter(this);
    }

    @Override
    public void getVideoList() {
        mView.showLoading();
        EspressoIdlingResource.increment();
        mSubscriptions.add(mVideoListBusiness.getVideosList().observeOn(AndroidSchedulers.
                mainThread()).subscribeOn(Schedulers.io()).doOnTerminate(() -> {
            if (!EspressoIdlingResource.getIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement(); // Set app as idle.
            }
        }).subscribe((videoList) -> {
            if (videoList instanceof ArrayList) {
                mView.displayVideosList((ArrayList<VideoListItem>) videoList);
            } else {
                mView.showError(videoList.toString());
            }
            mView.hideLoading();
        }, throwable -> {
            mView.hideLoading();
            mView.showError(throwable.getMessage());
        }));
    }

    @Override
    public void unSubscribe() {
        mSubscriptions.clear();
    }
}
