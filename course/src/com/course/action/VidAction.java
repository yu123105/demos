package com.course.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.course.model.Video;
import com.course.service.VidMgr;
import com.opensymphony.xwork2.ActionSupport;

public class VidAction extends ActionSupport{
	private File vidFile;
	private String vidFileContentType;
	private String vidFileFileName;
	private String destPath;

	private Video vid;
	private VidMgr vidMgr;
	private List<Video> vids;
	
	/*
    分页处理
     */
    private int pageNo = 1;
    private int PAGE_SIZE;
    private int totalPage;

	/*
	 * 注：getters和setters的名字因与属性名对应，否则struts2找不到该属性的setter方法，因而赋不了值
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		System.out.println("Execute!");
		destPath = ServletActionContext.getServletContext().getRealPath(
				"/video/");

		try {
			System.out.println("Src File name: " + vidFile);
			System.out.println("Dst File name: " + vidFileFileName);

			File destFile = new File(destPath, vidFileFileName);
			FileUtils.copyFile(vidFile, destFile);

		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		if (vid.getVname() == null) {
			vid.setVname(vidFileFileName);
		}
		vid.setPath("video/" + vidFileFileName);
		vid.setDatetime(new Timestamp(System.currentTimeMillis()));

		if (!vidMgr.save(vid)) {
			return ERROR;
		}
		System.out.println("Upload Finish!");
		return SUCCESS;
	}

	public String view() {
		System.out.println("Vid-view");
		PAGE_SIZE = 5;
        totalPage = (vidMgr.getAllVideo().size() + PAGE_SIZE - 1) / PAGE_SIZE;
        if (pageNo == 0) {
            pageNo = 1;
        } else if (pageNo > totalPage) {
            pageNo = totalPage;
        }
		vids = vidMgr.getVideos(pageNo, PAGE_SIZE);
		return "vidview";
	}

	public File getVidFile() {
		return vidFile;
	}

	public void setVidFile(File vidFile) {
		this.vidFile = vidFile;
	}

	public String getVidFileContentType() {
		return vidFileContentType;
	}

	public void setVidFileContentType(String vidFileContentType) {
		this.vidFileContentType = vidFileContentType;
	}

	public String getVidFileFileName() {
		return vidFileFileName;
	}

	public void setVidFileFileName(String vidFileFileName) {
		this.vidFileFileName = vidFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public Video getVid() {
		return vid;
	}

	public void setVid(Video vid) {
		this.vid = vid;
	}

	public VidMgr getVidMgr() {
		return vidMgr;
	}

	public void setVidMgr(VidMgr vidMgr) {
		this.vidMgr = vidMgr;
	}

	public List<Video> getVids() {
		return vids;
	}

	public void setVids(List<Video> vids) {
		this.vids = vids;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPAGE_SIZE() {
		return PAGE_SIZE;
	}

	public void setPAGE_SIZE(int pAGE_SIZE) {
		PAGE_SIZE = pAGE_SIZE;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
