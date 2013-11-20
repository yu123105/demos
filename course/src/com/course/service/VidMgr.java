package com.course.service;

import java.util.List;

import com.course.model.Video;

public interface VidMgr {

	boolean save(Video vid);

	List<Video> getAllVideo();

	List<Video> getVideos(int pageNo, int PAGE_SIZE);
	
}
