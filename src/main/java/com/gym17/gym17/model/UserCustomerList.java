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

@Entity
@Table(name = "user_customer", catalog = "heroku_4ee2ecbe460bfa4")
public class UserCustomerList implements java.io.Serializable {

	private int id;
	@JsonIgnoreProperties("userCustomer")
	private User user;
	private String additionalData;
	@JsonIgnoreProperties("userCustomer")
	private Set<CustomerMembershipFee> customerMembershipFees = new HashSet<CustomerMembershipFee>(0);

	public UserCustomerList() {
	}

	public UserCustomerList(User user) {
		this.user = user;
	}

	public UserCustomerList(User user, String additionalData, Set<CustomerMembershipFee> customerMembershipFees, Set<UserMembershipFee> userMembershipFees) {
		this.user = user;
		this.additionalData = additionalData;
		this.customerMembershipFees = customerMembershipFees;
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

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "additional_data")
	public String getAdditionalData() {
		return this.additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userCustomer", cascade = CascadeType.ALL)
	public Set<CustomerMembershipFee> getCustomerMembershipFees() {
		return this.customerMembershipFees;
	}

	public void setCustomerMembershipFees(Set<CustomerMembershipFee> customerMembershipFees) {
		this.customerMembershipFees = customerMembershipFees;
	}


}
