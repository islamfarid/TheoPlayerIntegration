package com.example.islam.theoplayerintegration.video_list;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.islam.theoplayerintegration.R;
import com.example.islam.theoplayerintegration.app.BaseFragment;
import com.example.islam.theoplayerintegration.models.VideoListItem;
import com.theoplayer.android.api.THEOplayerView;
import com.theoplayer.android.api.source.SourceDescription;
import com.theoplayer.android.api.source.SourceType;
import com.theoplayer.android.api.source.TypedSource;

import java.util.ArrayList;

import butterknife.BindView;

public class VideoListFragment extends BaseFragment implements VideoListContract.View {
    @BindView(R.id.rv_videos)
    RecyclerView mRVVideos;
    @BindView(R.id.theoplayer)
    THEOplayerView mTheOplayerView;

    @Override
    protected void init() {
        ((VideoListContract.Presenter) mPresenter).getVideoList();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_videos_list;
    }

    public static VideoListFragment newInstance() {
        return new VideoListFragment();
    }

    @Override
    public void displayVideosList(ArrayList<VideoListItem> videoListItems) {
        VideosListAdapter videosListAdapter = new VideosListAdapter(getActivity(), videoListItem -> {
            mTheOplayerView.getSettings().setFullScreenOrientationCoupled(true);
            TypedSource typedSource;
            if (!videoListItem.getVideoStreamLink().endsWith("mp4")) {
                typedSource = TypedSource.Builder
                        .typedSource()
                        .src(videoListItem.getVideoStreamLink())
                        .type(SourceType.HLS)
                        .build();
            } else {
                typedSource = TypedSource.Builder
                        .typedSource()
                        .src(videoListItem.getVideoStreamLink())
                        .type(SourceType.MP4)
                        .build();
            }
            SourceDescription sourceDescription = SourceDescription.Builder
                    .sourceDescription(typedSource)
                    .build();

            mTheOplayerView.getPlayer().setSource(sourceDescription);
            mTheOplayerView.getPlayer().play();
        }, videoListItems);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRVVideos.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRVVideos.getContext(),
                LinearLayoutManager.VERTICAL);
        mRVVideos.addItemDecoration(dividerItemDecoration);
        mRVVideos.setAdapter(videosListAdapter);
    }

    @Override
    public void onPause() {
        super.onPause();
        mTheOplayerView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTheOplayerView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTheOplayerView.onDestroy();
    }
}
