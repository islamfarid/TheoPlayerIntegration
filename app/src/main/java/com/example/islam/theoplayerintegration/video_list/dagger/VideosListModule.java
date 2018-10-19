package com.example.islam.theoplayerintegration.video_list.dagger;


import com.example.islam.theoplayerintegration.data.TheoPlayerIntegrationRepository;
import com.example.islam.theoplayerintegration.video_list.VideoListBusiness;
import com.example.islam.theoplayerintegration.video_list.VideoListContract;
import com.example.islam.theoplayerintegration.video_list.VideoListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by islam on 03/12/16.
 */
@Module
public class VideosListModule {
    private final VideoListContract.View mView;

    public VideosListModule(VideoListContract.View view) {
        this.mView = view;
    }

    @Provides
    VideoListContract.View provideVideoListView() {
        return mView;
    }

    @Provides
    VideoListContract.Presenter provideVideoListPresenter(VideoListBusiness videoListBusiness) {
        return new VideoListPresenter(mView, videoListBusiness);
    }

    @Provides
    VideoListBusiness provideVideoListBusiness(TheoPlayerIntegrationRepository theoPlayerIntegrationRepository) {
        return new VideoListBusiness(theoPlayerIntegrationRepository);
    }


}
