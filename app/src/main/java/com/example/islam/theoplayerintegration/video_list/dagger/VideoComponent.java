package com.example.islam.theoplayerintegration.video_list.dagger;


import com.example.islam.theoplayerintegration.app.FragmentScoped;
import com.example.islam.theoplayerintegration.app.TheoPlayerIntegrationComponent;
import com.example.islam.theoplayerintegration.video_list.VideoListActivity;

import dagger.Component;

/**
 * Created by islam on 03/12/16.
 */

@FragmentScoped
@Component(dependencies = TheoPlayerIntegrationComponent.class,
        modules = VideosListModule.class)
public interface VideoComponent {
    void inject(VideoListActivity homeActivity);
}
