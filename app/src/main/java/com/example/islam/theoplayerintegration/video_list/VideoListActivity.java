package com.example.islam.theoplayerintegration.video_list;

import android.os.Bundle;

import com.example.islam.theoplayerintegration.R;
import com.example.islam.theoplayerintegration.app.BaseActivity;
import com.example.islam.theoplayerintegration.app.TheoPlayerIntegrationAPP;
import com.example.islam.theoplayerintegration.utils.ActivityUtils;
import com.example.islam.theoplayerintegration.video_list.dagger.DaggerVideoComponent;
import com.example.islam.theoplayerintegration.video_list.dagger.VideosListModule;

import javax.inject.Inject;

public class VideoListActivity extends BaseActivity {
    @Inject
    VideoListContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_list);
        VideoListFragment videoListFragment =
                (VideoListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (videoListFragment == null) {
            // Create the fragment
            videoListFragment = VideoListFragment.newInstance();
            videoListFragment.setArguments(getIntent().getExtras());
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), videoListFragment, R.id.contentFrame);
        }

        DaggerVideoComponent.builder().
                theoPlayerIntegrationComponent(((TheoPlayerIntegrationAPP) getApplication()).
                        getTheoPlayerIntegrationComponentComponent()).videosListModule(new VideosListModule(videoListFragment)).build().inject(this);
    }
}

