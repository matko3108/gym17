package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Address generated by hbm2java
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "address", catalog = "heroku_4ee2ecbe460bfa4")
public class Address implements java.io.Serializable {

	private Integer id;
	private String addressLine;
	private String city;
	private String country;
	private String zip;
	@JsonIgnore
	@JsonIgnoreProperties
	@JsonView
	private Set<User> users = new HashSet<User>(0);
	
	public Address() {
	}

	public Address(String addressLine, String city) {
		this.addressLine = addressLine;
		this.city = city;
	}

	public Address(String addressLine, String city, String country, String zip, Set<User> users) {
		this.addressLine = addressLine;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.users = users;
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

	@Column(name = "adress_line", nullable = false)
	public String getAddressLine() {
		return this.addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country", length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "zip", length = 10)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address", cascade =
	  CascadeType.ALL) public Set<User> getUsers() { return this.users; }
	  
	  public void setUsers(Set<User> users) { this.users = users; }
	 

}
