package com.example.islam.theoplayerintegration.video_list;

import com.example.islam.theoplayerintegration.app.BasePresenter;
import com.example.islam.theoplayerintegration.app.BaseView;
import com.example.islam.theoplayerintegration.models.VideoListItem;

import java.util.ArrayList;

public interface VideoListContract {
    interface View extends BaseView<BasePresenter> {
        void displayVideosList(ArrayList<VideoListItem> videoListItems);
    }

    interface Presenter extends BasePresenter {
        void getVideoList();
    }
}
