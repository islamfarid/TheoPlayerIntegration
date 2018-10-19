package com.example.islam.theoplayerintegration.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideosListResponseModel{

	@SerializedName("videoList")
	private List<VideoListItem> videoList;

	@SerializedName("responseCode")
	private String responseCode;

	@SerializedName("responseMsg")
	private String responseMsg;

	public void setVideoList(List<VideoListItem> videoList){
		this.videoList = videoList;
	}

	public List<VideoListItem> getVideoList(){
		return videoList;
	}

	public void setResponseCode(String responseCode){
		this.responseCode = responseCode;
	}

	public String getResponseCode(){
		return responseCode;
	}

	public void setResponseMsg(String responseMsg){
		this.responseMsg = responseMsg;
	}

	public String getResponseMsg(){
		return responseMsg;
	}

	@Override
 	public String toString(){
		return 
			"VideosListResponseModel{" + 
			"videoList = '" + videoList + '\'' + 
			",responseCode = '" + responseCode + '\'' + 
			",responseMsg = '" + responseMsg + '\'' + 
			"}";
		}
}