package src.main.java.com.gym17.gym17.model;


public class GroupCustomerNew {
	private Group group;
	private UserCustomer userCustomer;
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public UserCustomer getUserCustomer() {
		return userCustomer;
	}
	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}
	@Override
	public String toString() {
		return "GroupCustomerNew [group=" + group + ", userCustomer=" + userCustomer + "]";
	}
	
	
}
