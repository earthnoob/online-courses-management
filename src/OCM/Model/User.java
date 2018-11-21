package OCM.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private String ID;
	private String email;
	private String password;
	private Role roleLevel;
	private String fullName;
	private Boolean gender;
	private LocalDate dob;
	private String telephone;
	private String address;
	private String bio;
	private LocalDateTime joinedAt;
	private Double balance;
	private Long reputation;
	private Integer penaltyCount;
	
	
	public User(String iD, String email, String password, Role roleLevel, String fullName, Boolean gender, LocalDate dob,
			String telephone, String address, String bio, LocalDateTime joinedAt, Double balance, Long reputation,
			Integer penaltyCount) {
		super();
		ID = iD;
		this.email = email;
		this.password = password;
		this.roleLevel = roleLevel;
		this.fullName = fullName;
		this.gender = gender;
		this.dob = dob;
		this.telephone = telephone;
		this.address = address;
		this.bio = bio;
		this.joinedAt = joinedAt;
		this.balance = balance;
		this.reputation = reputation;
		this.penaltyCount = penaltyCount;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Long getReputation() {
		return reputation;
	}

	public void setReputation(Long reputation) {
		this.reputation = reputation;
	}

	public Integer getPenaltyCount() {
		return penaltyCount;
	}

	public void setPenaltyCount(Integer penaltyCount) {
		this.penaltyCount = penaltyCount;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRoleLevel() {
		return roleLevel;
	}
	public void setRoleLevel(Role roleLevel) {
		this.roleLevel = roleLevel;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
}
