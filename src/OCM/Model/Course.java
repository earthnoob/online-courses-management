package OCM.Model;

import java.time.LocalDateTime;

public class Course {
	private String courseID;
	private String ownerID;
	private String name;
	private String category;
	private String descrption;
	private LocalDateTime createdAt;
	private Double price;
	private Long numberOfRegistrations;
	
	public Course(String courseID, String ownerID, String name, String category, String descrption, LocalDateTime createdAt, Double price, 
			Long numberOfRegistrations) {
		super();
		this.courseID = courseID;
		this.ownerID = ownerID;
		this.name = name;
		this.category = category;
		this.descrption = descrption;
		this.createdAt = createdAt;
		this.price = price;
		this.numberOfRegistrations = numberOfRegistrations;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getNumberOfRegistrations() {
		return numberOfRegistrations;
	}
	public void setNumberOfRegistrations(Long numberOfRegistrations) {
		this.numberOfRegistrations = numberOfRegistrations;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public Double getPrice() {
		return price;
	}
}
