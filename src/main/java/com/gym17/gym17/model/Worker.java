package src.main.java.com.gym17.gym17.model;
// Generated Sep 18, 2020, 8:04:59 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Worker generated by hbm2java
 */
@Entity
@Table(name = "worker", catalog = "heroku_4ee2ecbe460bfa4")
public class Worker implements java.io.Serializable {

	private int id;
	private Address address;
	private WorkerType workerType;
	private String email;
	private String lastname;
	private String name;
	private String password;
	private String phoneNumber;
	private String username;

	public Worker() {
	}

	public Worker(int id, String lastname, String name) {
		this.id = id;
		this.lastname = lastname;
		this.name = name;
	}

	public Worker(int id, Address address, WorkerType workerType, String email, String lastname, String name,
			String password, String phoneNumber, String username) {
		this.id = id;
		this.address = address;
		this.workerType = workerType;
		this.email = email;
		this.lastname = lastname;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.username = username;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_adress")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_worker_type")
	public WorkerType getWorkerType() {
		return this.workerType;
	}

	public void setWorkerType(WorkerType workerType) {
		this.workerType = workerType;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Column(name = "phone_number", length = 50)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
