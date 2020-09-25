package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * UserType generated by hbm2java
 */
@Entity
@Table(name = "user_type", catalog = "heroku_4ee2ecbe460bfa4")
public class UserType implements java.io.Serializable {

	private Integer id;
	private String description;
	private String name;
	@JsonIgnore
	private Set<User> users = new HashSet<User>(0);

	public UserType() {
	}

	public UserType(String name) {
		this.name = name;
	}

	public UserType(String description, String name, Set<User> users) {
		this.description = description;
		this.name = name;
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

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userType") public Set<User>
	  getUsers() { return this.users; }
	  
	  public void setUsers(Set<User> users) { this.users = users; }
	 

}
