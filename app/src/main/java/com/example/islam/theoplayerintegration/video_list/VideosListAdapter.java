package com.example.islam.theoplayerintegration.video_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.islam.theoplayerintegration.R;
import com.example.islam.theoplayerintegration.models.VideoListItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideosListAdapter extends RecyclerView.Adapter<VideosListAdapter.VideosViewHolder> {
    private Context mContext;
    OnVideoSelected mOnVideoSelected;
    ArrayList<VideoListItem> mVideoListItems;

    VideosListAdapter(Context context, OnVideoSelected onVideoSelected, ArrayList<VideoListItem> mVideoListItems) {
        this.mContext = context;
        this.mVideoListItems = mVideoListItems;
        this.mOnVideoSelected = onVideoSelected;
    }

    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_video_list_item, null);
        return new VideosViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mVideoListItems.get(position).getVideoThumbURL())
                .into(holder.ivVideoThumb);
        holder.tvVideoTitle.setText(mVideoListItems.get(position).getVideoName());
        holder.tvVideoSubTitle.setText(mVideoListItems.get(position).getVideoSubtitle());
        holder.mTVDuration.setText(mVideoListItems.get(position).getVideoDuration());
    }

    @Override
    public int getItemCount() {
        return mVideoListItems.size();
    }

    public class VideosViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_video_thumb)
        ImageView ivVideoThumb;
        @BindView(R.id.tv_video_title)
        AppCompatTextView tvVideoTitle;
        @BindView(R.id.tv_video_sub_title)
        AppCompatTextView tvVideoSubTitle;
        @BindView(R.id.tv_duration)
        AppCompatTextView mTVDuration;

        public VideosViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.rl_video_list_item_layout)
        void onListItemClick() {
            mOnVideoSelected.onVideoSelected(mVideoListItems.get(getAdapterPosition()));
        }

    }

}

