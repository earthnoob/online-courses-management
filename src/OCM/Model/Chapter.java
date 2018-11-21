package OCM.Model;

public class Chapter {
	private String chapterID;
	private String courseID;
	private Integer chapterNumber;
	private String name;
	private String description;
	
	public Chapter(String chapterID, String courseID, Integer chapterNumber, String name, String description) {
		super();
		this.chapterID = chapterID;
		this.courseID = courseID;
		this.chapterNumber = chapterNumber;
		this.name = name;
		this.description = description;
	}
	public String getChapterID() {
		return chapterID;
	}
	public void setChapterID(String chapterID) {
		this.chapterID = chapterID;
	}
	public Integer getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
