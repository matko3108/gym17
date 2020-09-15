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

@Entity(name="private_coach")
public class PrivateCoach implements Serializable {

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
    @Column(nullable=false)
    private LocalDateTime start;
    private LocalDateTime end;
    @Column(length=255)
    private String description;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_customer", nullable=false)
    private UserCustomer userCustomer;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_worker", nullable=false)
    private UserWorker userWorker;

    /** Default constructor. */
    public PrivateCoach() {
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
     * Access method for start.
     *
     * @return the current value of start
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Setter method for start.
     *
     * @param aStart the new value for start
     */
    public void setStart(LocalDateTime aStart) {
        start = aStart;
    }

    /**
     * Access method for end.
     *
     * @return the current value of end
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * Setter method for end.
     *
     * @param aEnd the new value for end
     */
    public void setEnd(LocalDateTime aEnd) {
        end = aEnd;
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

    /**
     * Compares the key for this instance with another PrivateCoach.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PrivateCoach and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PrivateCoach)) {
            return false;
        }
        PrivateCoach that = (PrivateCoach) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PrivateCoach.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PrivateCoach)) return false;
        return this.equalKeys(other) && ((PrivateCoach)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[PrivateCoach |");
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
