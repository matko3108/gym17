// Generated with g9.

package java.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name="user")
public class User implements Serializable {

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Column(nullable=false, length=50)
    private String name;
    @Column(nullable=false, length=50)
    private String lastname;
    @Column(name="fk_adress", precision=7)
    private int fkAdress;
    @Column(name="fk_contact", precision=7)
    private int fkContact;
    @Column(name="fk_user_type", precision=7)
    private int fkUserType;
    @Column(nullable=false, length=50)
    private String username;
    @Column(length=50)
    private String password;
    @OneToMany(mappedBy="user")
    private Set<ActivityList> activityList;
    @OneToOne(mappedBy="user")
    private UserCustomer userCustomer;
    @OneToMany(mappedBy="user")
    private Set<UserMembershipFee> userMembershipFee;
    @OneToOne(optional=false, mappedBy="user")
    @JoinColumn(name="id", nullable=false)
    private UserType userType;
    @OneToOne(mappedBy="user")
    private UserWorker userWorker;

    /** Default constructor. */
    public User() {
        super();
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for lastname.
     *
     * @return the current value of lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Setter method for lastname.
     *
     * @param aLastname the new value for lastname
     */
    public void setLastname(String aLastname) {
        lastname = aLastname;
    }

    /**
     * Access method for fkAdress.
     *
     * @return the current value of fkAdress
     */
    public int getFkAdress() {
        return fkAdress;
    }

    /**
     * Setter method for fkAdress.
     *
     * @param aFkAdress the new value for fkAdress
     */
    public void setFkAdress(int aFkAdress) {
        fkAdress = aFkAdress;
    }

    /**
     * Access method for fkContact.
     *
     * @return the current value of fkContact
     */
    public int getFkContact() {
        return fkContact;
    }

    /**
     * Setter method for fkContact.
     *
     * @param aFkContact the new value for fkContact
     */
    public void setFkContact(int aFkContact) {
        fkContact = aFkContact;
    }

    /**
     * Access method for fkUserType.
     *
     * @return the current value of fkUserType
     */
    public int getFkUserType() {
        return fkUserType;
    }

    /**
     * Setter method for fkUserType.
     *
     * @param aFkUserType the new value for fkUserType
     */
    public void setFkUserType(int aFkUserType) {
        fkUserType = aFkUserType;
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for activityList.
     *
     * @return the current value of activityList
     */
    public Set<ActivityList> getActivityList() {
        return activityList;
    }

    /**
     * Setter method for activityList.
     *
     * @param aActivityList the new value for activityList
     */
    public void setActivityList(Set<ActivityList> aActivityList) {
        activityList = aActivityList;
    }

    /**
     * Access method for userCustomer.
     *
     * @return the current value of userCustomer
     */
    public UserCustomer getUserCustomer() {
        return userCustomer;
    }

    /**
     * Setter method for userCustomer.
     *
     * @param aUserCustomer the new value for userCustomer
     */
    public void setUserCustomer(UserCustomer aUserCustomer) {
        userCustomer = aUserCustomer;
    }

    /**
     * Access method for userMembershipFee.
     *
     * @return the current value of userMembershipFee
     */
    public Set<UserMembershipFee> getUserMembershipFee() {
        return userMembershipFee;
    }

    /**
     * Setter method for userMembershipFee.
     *
     * @param aUserMembershipFee the new value for userMembershipFee
     */
    public void setUserMembershipFee(Set<UserMembershipFee> aUserMembershipFee) {
        userMembershipFee = aUserMembershipFee;
    }

    /**
     * Access method for userType.
     *
     * @return the current value of userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Setter method for userType.
     *
     * @param aUserType the new value for userType
     */
    public void setUserType(UserType aUserType) {
        userType = aUserType;
    }

    /**
     * Access method for userWorker.
     *
     * @return the current value of userWorker
     */
    public UserWorker getUserWorker() {
        return userWorker;
    }

    /**
     * Setter method for userWorker.
     *
     * @param aUserWorker the new value for userWorker
     */
    public void setUserWorker(UserWorker aUserWorker) {
        userWorker = aUserWorker;
    }


}
