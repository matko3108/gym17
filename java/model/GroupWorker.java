// Generated with g9.

package java.model;

import java.io.Serializable;
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

@Entity(name="group_worker")
public class GroupWorker implements Serializable {

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
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_group", nullable=false)
    private Group group;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_worker", nullable=false)
    private UserWorker userWorker;

    /** Default constructor. */
    public GroupWorker() {
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
     * Access method for group.
     *
     * @return the current value of group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Setter method for group.
     *
     * @param aGroup the new value for group
     */
    public void setGroup(Group aGroup) {
        group = aGroup;
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
     * Compares the key for this instance with another GroupWorker.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class GroupWorker and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof GroupWorker)) {
            return false;
        }
        GroupWorker that = (GroupWorker) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another GroupWorker.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof GroupWorker)) return false;
        return this.equalKeys(other) && ((GroupWorker)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[GroupWorker |");
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
