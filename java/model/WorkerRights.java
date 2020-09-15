// Generated with g9.

package java.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="worker_rights")
public class WorkerRights implements Serializable {

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
    @OneToMany(mappedBy="workerRights")
    private Set<UserWorkerWorkerRights> userWorkerWorkerRights;
    @ManyToOne
    @JoinColumn(name="fk_rights_type")
    private WorkerRightsType workerRightsType;

    /** Default constructor. */
    public WorkerRights() {
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
     * Access method for userWorkerWorkerRights.
     *
     * @return the current value of userWorkerWorkerRights
     */
    public Set<UserWorkerWorkerRights> getUserWorkerWorkerRights() {
        return userWorkerWorkerRights;
    }

    /**
     * Setter method for userWorkerWorkerRights.
     *
     * @param aUserWorkerWorkerRights the new value for userWorkerWorkerRights
     */
    public void setUserWorkerWorkerRights(Set<UserWorkerWorkerRights> aUserWorkerWorkerRights) {
        userWorkerWorkerRights = aUserWorkerWorkerRights;
    }

    /**
     * Access method for workerRightsType.
     *
     * @return the current value of workerRightsType
     */
    public WorkerRightsType getWorkerRightsType() {
        return workerRightsType;
    }

    /**
     * Setter method for workerRightsType.
     *
     * @param aWorkerRightsType the new value for workerRightsType
     */
    public void setWorkerRightsType(WorkerRightsType aWorkerRightsType) {
        workerRightsType = aWorkerRightsType;
    }

    /**
     * Compares the key for this instance with another WorkerRights.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class WorkerRights and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof WorkerRights)) {
            return false;
        }
        WorkerRights that = (WorkerRights) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another WorkerRights.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof WorkerRights)) return false;
        return this.equalKeys(other) && ((WorkerRights)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[WorkerRights |");
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
