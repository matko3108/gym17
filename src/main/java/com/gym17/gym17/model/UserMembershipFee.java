package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserMembershipFee generated by hbm2java
 */
@Entity
@Table(name = "user_membership_fee", catalog = "heroku_4ee2ecbe460bfa4")
public class UserMembershipFee implements java.io.Serializable {

	private Integer id;
	private MembershipFeeType membershipFeeType;
	private UserCustomer userCustomer;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDate;

	public UserMembershipFee() {
	}

	public UserMembershipFee(MembershipFeeType membershipFeeType, UserCustomer userCustomer, Date endDate,
			Date startDate) {
		this.membershipFeeType = membershipFeeType;
		this.userCustomer = userCustomer;
		this.endDate = endDate;
		this.startDate = startDate;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_membership_fee", nullable = false)
	public MembershipFeeType getMembershipFeeType() {
		return this.membershipFeeType;
	}

	public void setMembershipFeeType(MembershipFeeType membershipFeeType) {
		this.membershipFeeType = membershipFeeType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user", nullable = false)
	public UserCustomer getUserCustomer() {
		return this.userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
