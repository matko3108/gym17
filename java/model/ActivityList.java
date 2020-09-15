// Generated with g9.

package java.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="activity_list")
public class ActivityList implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

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

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=7)
    private int id;
    @Column(nullable=false, length=50)
    private String name;
    @Column(length=255)
    private String description;
    @Column(name="create_date")
    private LocalDateTime createDate;
    @Column(name="validity_period", precision=10)
    private int validityPeriod;
    @Column(length=3)
    private boolean active;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_activity_type", nullable=false)
    private ActivityType activityType;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_user", nullable=false)
    private User user;

    /** Default constructor. */
    public ActivityList() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
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
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * Access method for createDate.
     *
     * @return the current value of createDate
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * Setter method for createDate.
     *
     * @param aCreateDate the new value for createDate
     */
    public void setCreateDate(LocalDateTime aCreateDate) {
        createDate = aCreateDate;
    }

    /**
     * Access method for validityPeriod.
     *
     * @return the current value of validityPeriod
     */
    public int getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Setter method for validityPeriod.
     *
     * @param aValidityPeriod the new value for validityPeriod
     */
    public void setValidityPeriod(int aValidityPeriod) {
        validityPeriod = aValidityPeriod;
    }

    /**
     * Access method for active.
     *
     * @return true if and only if active is currently true
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Setter method for active.
     *
     * @param aActive the new value for active
     */
    public void setActive(boolean aActive) {
        active = aActive;
    }

    /**
     * Access method for activityType.
     *
     * @return the current value of activityType
     */
    public ActivityType getActivityType() {
        return activityType;
    }

    /**
     * Setter method for activityType.
     *
     * @param aActivityType the new value for activityType
     */
    public void setActivityType(ActivityType aActivityType) {
        activityType = aActivityType;
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

    /**
     * Compares the key for this instance with another ActivityList.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ActivityList and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ActivityList)) {
            return false;
        }
        ActivityList that = (ActivityList) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ActivityList.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ActivityList)) return false;
        return this.equalKeys(other) && ((ActivityList)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[ActivityList |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
