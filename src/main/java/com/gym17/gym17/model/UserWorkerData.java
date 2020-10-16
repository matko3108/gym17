package src.main.java.com.gym17.gym17.model;

public class UserWorkerData {
	public User user;
	public String userType;
	public WorkerType workerType;
	
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
	
	public WorkerType getWorkerType() {
		return workerType;
	}
	public void setWorkerType(WorkerType workerType) {
		this.workerType = workerType;
	}
	@Override
	public String toString() {
		return "UserWorkerData [user=" + user + ", userType=" + userType + ", workerType=" + workerType + "]";
	}

	

}