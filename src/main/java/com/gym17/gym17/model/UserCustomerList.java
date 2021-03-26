package src.main.java.com.gym17.gym17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import src.test.java.com.gym17.gym17.UserListCustomer;

@Entity
@Table(name = "user_customer", catalog = "heroku_4ee2ecbe460bfa4")
public class UserCustomerList implements java.io.Serializable {

	private int id;
	//@JsonIgnoreProperties(value={"userCustomer", "userWorker","activityLists","hibernateLazyInitializer"})

	public UserCustomerList() {
	}



	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
