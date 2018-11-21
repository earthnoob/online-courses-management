package OCM.Model;

import java.time.LocalDateTime;

public class Video {
	public String videoID;
	public String chapterID;
	public String name;
	public LocalDateTime createdAt;
	public Integer viewCount;
	
	public Video(String videoID, String chapterID, String name, LocalDateTime createdAt, Integer viewCount) {
		super();
		this.videoID = videoID;
		this.chapterID = chapterID;
		this.name = name;
		this.createdAt = createdAt;
		this.viewCount = viewCount;
	}
	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public String getChapterID() {
		return chapterID;
	}
	public void setChapterID(String chapterID) {
		this.chapterID = chapterID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
