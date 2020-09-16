package src.main.java.com.gym17.gym17.response;



public class ErrorResponse {

	private ErrorType errorType;
	private String errorMessage;

	public ErrorResponse(ErrorType errorType) {
		this.errorType = errorType;
		this.errorMessage = this.errorType.toString();
	}

	public ErrorResponse(ErrorType errorType, String message) {
		this(errorType);
		this.errorMessage += " Following error message was received:" + message;
	}

	public ErrorResponse(ErrorType errorType, Object additionalBodyData) {
		this(errorType);
		this.errorMessage += " " + additionalBodyData.toString();
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
