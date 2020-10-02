package src.main.java.com.gym17.gym17.response;

public class ResponseStatus {
	private boolean status;

	
	public ResponseStatus(boolean status) {
		super();
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseStatus [status=" + status + "]";
	}
	

}
