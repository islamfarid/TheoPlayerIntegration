package com.example.islam.theoplayerintegration.models;

import com.google.gson.annotations.SerializedName;

public class VideoListItem{

	@SerializedName("VideoDuration")
	private String videoDuration;

	@SerializedName("videoSubtitle")
	private String videoSubtitle;

	@SerializedName("videoName")
	private String videoName;

	@SerializedName("VideoStreamLink")
	private String videoStreamLink;

	@SerializedName("videoThumbURL")
	private String videoThumbURL;

	public void setVideoDuration(String videoDuration){
		this.videoDuration = videoDuration;
	}

	public String getVideoDuration(){
		return videoDuration;
	}

	public void setVideoSubtitle(String videoSubtitle){
		this.videoSubtitle = videoSubtitle;
	}

	public String getVideoSubtitle(){
		return videoSubtitle;
	}

	public void setVideoName(String videoName){
		this.videoName = videoName;
	}

	public String getVideoName(){
		return videoName;
	}

	public void setVideoStreamLink(String videoStreamLink){
		this.videoStreamLink = videoStreamLink;
	}

	public String getVideoStreamLink(){
		return videoStreamLink;
	}

	public void setVideoThumbURL(String videoThumbURL){
		this.videoThumbURL = videoThumbURL;
	}

	public String getVideoThumbURL(){
		return videoThumbURL;
	}

	@Override
 	public String toString(){
		return 
			"VideoListItem{" + 
			"videoDuration = '" + videoDuration + '\'' + 
			",videoSubtitle = '" + videoSubtitle + '\'' + 
			",videoName = '" + videoName + '\'' + 
			",videoStreamLink = '" + videoStreamLink + '\'' + 
			",videoThumbURL = '" + videoThumbURL + '\'' + 
			"}";
		}
}