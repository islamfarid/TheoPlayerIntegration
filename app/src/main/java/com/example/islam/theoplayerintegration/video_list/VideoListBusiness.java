package com.example.islam.theoplayerintegration.video_list;

import com.example.islam.theoplayerintegration.app.Constants;
import com.example.islam.theoplayerintegration.data.TheoPlayerIntegrationRepository;
import com.example.islam.theoplayerintegration.models.VideosListResponseModel;

import javax.inject.Inject;

import io.reactivex.Observable;

public class VideoListBusiness {
    private TheoPlayerIntegrationRepository mTheoPlayerIntegrationRepository;

    @Inject
    public VideoListBusiness(TheoPlayerIntegrationRepository theoPlayerIntegrationRepository) {
        mTheoPlayerIntegrationRepository = theoPlayerIntegrationRepository;
    }

    Observable<Object> getVideosList() {
        return mTheoPlayerIntegrationRepository.loadJSONFromAsset("videos.json",
                VideosListResponseModel.class).map((videosListResponseModel) -> {
            if (videosListResponseModel.getResponseCode().equals(Constants.CODE_SUCCESS)) {
                return videosListResponseModel.getVideoList();
            } else {
                return videosListResponseModel.getResponseMsg();
            }
        });
    }
}
