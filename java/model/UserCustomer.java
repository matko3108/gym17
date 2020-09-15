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

@Entity(name="user_customer")
public class UserCustomer implements Serializable {

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

    @Column(name="additional_data", length=255)
    private String additionalData;
    @OneToMany(mappedBy="userCustomer")
    private Set<GroupCustomer> groupCustomer;
    @OneToMany(mappedBy="userCustomer")
    private Set<PrivateCoach> privateCoach;
    @OneToOne(optional=false, mappedBy="userCustomer")
    @JoinColumn(name="id", nullable=false)
    private User user;

    /** Default constructor. */
    public UserCustomer() {
        super();
    }

    /**
     * Access method for additionalData.
     *
     * @return the current value of additionalData
     */
    public String getAdditionalData() {
        return additionalData;
    }

    /**
     * Setter method for additionalData.
     *
     * @param aAdditionalData the new value for additionalData
     */
    public void setAdditionalData(String aAdditionalData) {
        additionalData = aAdditionalData;
    }

    /**
     * Access method for groupCustomer.
     *
     * @return the current value of groupCustomer
     */
    public Set<GroupCustomer> getGroupCustomer() {
        return groupCustomer;
    }

    /**
     * Setter method for groupCustomer.
     *
     * @param aGroupCustomer the new value for groupCustomer
     */
    public void setGroupCustomer(Set<GroupCustomer> aGroupCustomer) {
        groupCustomer = aGroupCustomer;
    }

    /**
     * Access method for privateCoach.
     *
     * @return the current value of privateCoach
     */
    public Set<PrivateCoach> getPrivateCoach() {
        return privateCoach;
    }

    /**
     * Setter method for privateCoach.
     *
     * @param aPrivateCoach the new value for privateCoach
     */
    public void setPrivateCoach(Set<PrivateCoach> aPrivateCoach) {
        privateCoach = aPrivateCoach;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(User aUser) {
        user = aUser;
    }

}
