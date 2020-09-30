package src.main.java.com.gym17.gym17.response;


public enum ErrorType {

	// @SerializedName("blabla")

	USER_NOT_FOUND("461", "User not found"),
	ACTIVITY_NOT_FOUND("471", "Activity not found"),
	BAD_CREDENTIALS("481", "Bad credentials"), 
	MEMBERSHIP_NOT_FOUND("491", "Membership not found\"");



	private final String code;
	private final String description;

	private ErrorType(final String code, final String description) {
		this.code = code;
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb =new StringBuilder();
		sb.append("Error ").append(this.code).append(" - ").append(super.toString());
		sb.append(": ").append(this.description);
		return sb.toString();
	}
}
