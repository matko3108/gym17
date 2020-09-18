package src.main.java.com.gym17.gym17.model;

public class UserData {
	public User user;
	public String userType;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserData [user=" + user + ", userType=" + userType + "]";
	}
	

}
