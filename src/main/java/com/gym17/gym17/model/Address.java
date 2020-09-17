package src.main.java.com.gym17.gym17.model;
// Generated Sep 16, 2020, 7:54:25 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "address", catalog = "heroku_4ee2ecbe460bfa4")
public class Address implements java.io.Serializable {

	private Integer id;
	private String adressLine;
	private String city;
	private String zip;
	private String country;
	private User user;

	public Address() {
	}

	public Address(String adressLine, String city) {
		this.adressLine = adressLine;
		this.city = city;
	}

	public Address(String adressLine, String city, String zip, String country, User user) {
		this.adressLine = adressLine;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.user = user;
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
	public String getAdressLine() {
		return this.adressLine;
	}

	public void setAdressLine(String adressLine) {
		this.adressLine = adressLine;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zip", length = 10)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "country", length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}