package src.main.java.com.gym17.gym17.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "user", catalog = "heroku_4ee2ecbe460bfa4")
public class UserFull implements java.io.Serializable {

	private Integer id;
	@JsonIgnoreProperties(value={"users","hibernateLazyInitializer"})
	private Address address;
	@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
	private UserType userType;
	private String lastname;
	private String name;
	private String password;
	private String username;
	private String email;
	private String phone;
	private String externalId;
	@JsonIgnoreProperties(value={"user","hibernateLazyInitializer"})
	private UserCustomer userCustomer;
	@JsonIgnoreProperties(value={"user","hibernateLazyInitializer"})
	private UserWorker userWorker;
	@JsonIgnoreProperties(value={"user","hibernateLazyInitializer"})
	private Set<ActivityList> activityLists = new HashSet<ActivityList>(0);

	public UserFull() {
	}

	public UserFull(String lastname, String name) {
		this.lastname = lastname;
		this.name = name;
	}

	public UserFull(Address address, UserType userType, String lastname, String name, String password, String username,
			String email, String phone, String externalId, UserCustomer userCustomer, UserWorker userWorker,
			Set<ActivityList> activityLists) {
		this.address = address;
		this.userType = userType;
		this.lastname = lastname;
		this.name = name;
		this.password = password;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.externalId = externalId;
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.activityLists = activityLists;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_adress")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_user_type")
	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Column(name = "lastname", nullable = false, length = 50)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "externalid", length = 50)
	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	public UserCustomer getUserCustomer() {
		return this.userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	public UserWorker getUserWorker() {
		return this.userWorker;
	}

	public void setUserWorker(UserWorker userWorker) {
		this.userWorker = userWorker;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
	public Set<ActivityList> getActivityLists() {
		return this.activityLists;
	}

	public void setActivityLists(Set<ActivityList> activityLists) {
		this.activityLists = activityLists;
	}

}
