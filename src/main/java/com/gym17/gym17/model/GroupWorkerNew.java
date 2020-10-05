package src.main.java.com.gym17.gym17.model;

public class GroupWorkerNew {
	private Group group;
	private UserWorker userWorker;
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public UserWorker getUserWorker() {
		return userWorker;
	}
	public void setUserWorker(UserWorker userWorker) {
		this.userWorker = userWorker;
	}
	@Override
	public String toString() {
		return "GroupWorkerNew [group=" + group + ", userWorker=" + userWorker + "]";
	}
	
	
	

}
