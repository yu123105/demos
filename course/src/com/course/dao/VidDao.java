package com.course.dao;

import java.util.List;

import com.course.model.Video;

public interface VidDao {

	boolean save(Video vid);

	List<Video> getAllVideo();

	List<Video> getVideos(int pageNo, int PAGE_SIZE);

}
