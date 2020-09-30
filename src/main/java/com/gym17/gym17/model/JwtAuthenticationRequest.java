package src.main.java.com.gym17.gym17.model;

public class JwtAuthenticationRequest {
	private String username;
	private String password;
	private String licenceName;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLicenceName() {
		return licenceName;
	}
	public void setLicenceName(String licenceName) {
		this.licenceName = licenceName;
	}
	@Override
	public String toString() {
		return "JwtAuthenticationRequest [username=" + username + ", password=" + password + ", licenceName="
				+ licenceName + "]";
	}

	
}
