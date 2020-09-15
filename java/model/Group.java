// Generated with g9.

package java.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="group")
public class Group implements Serializable {

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
    @Column(name="max_customer", precision=10)
    private int maxCustomer;
    private LocalDateTime created;
    private LocalDateTime start;
    @Column(precision=10)
    private int valid;
    @Column(length=3)
    private boolean active;
    @OneToMany(mappedBy="group")
    private Set<GroupCustomer> groupCustomer;
    @OneToMany(mappedBy="group")
    private Set<GroupWorker> groupWorker;

    /** Default constructor. */
    public Group() {
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
     * Access method for maxCustomer.
     *
     * @return the current value of maxCustomer
     */
    public int getMaxCustomer() {
        return maxCustomer;
    }

    /**
     * Setter method for maxCustomer.
     *
     * @param aMaxCustomer the new value for maxCustomer
     */
    public void setMaxCustomer(int aMaxCustomer) {
        maxCustomer = aMaxCustomer;
    }

    /**
     * Access method for created.
     *
     * @return the current value of created
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * Setter method for created.
     *
     * @param aCreated the new value for created
     */
    public void setCreated(LocalDateTime aCreated) {
        created = aCreated;
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
     * Access method for valid.
     *
     * @return the current value of valid
     */
    public int getValid() {
        return valid;
    }

    /**
     * Setter method for valid.
     *
     * @param aValid the new value for valid
     */
    public void setValid(int aValid) {
        valid = aValid;
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
     * Access method for groupWorker.
     *
     * @return the current value of groupWorker
     */
    public Set<GroupWorker> getGroupWorker() {
        return groupWorker;
    }

    /**
     * Setter method for groupWorker.
     *
     * @param aGroupWorker the new value for groupWorker
     */
    public void setGroupWorker(Set<GroupWorker> aGroupWorker) {
        groupWorker = aGroupWorker;
    }

    /**
     * Compares the key for this instance with another Group.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Group and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Group)) {
            return false;
        }
        Group that = (Group) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Group.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Group)) return false;
        return this.equalKeys(other) && ((Group)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Group |");
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
