package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.course.dao.VidDao;
import com.course.model.Video;
import com.course.service.VidMgr;
@Component("vidMgr")
public class VideoMgrImpl implements VidMgr{

	private VidDao vidDao;
	
	@Override
	public boolean save(Video vid) {
		return vidDao.save(vid);
	}

	@Override
	public List<Video> getAllVideo() {
		return vidDao.getAllVideo();
	}

	@Override
	public List<Video> getVideos(int pageNo, int PAGE_SIZE) {
		return vidDao.getVideos(pageNo, PAGE_SIZE);
	}
	@Resource
	public void setVidDao(VidDao vidDao) {
		this.vidDao = vidDao;
	}

}
