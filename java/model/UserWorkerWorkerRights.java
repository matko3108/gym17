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

@Entity(name="user_worker_worker_rights")
public class UserWorkerWorkerRights implements Serializable {

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
    private LocalDateTime created;
    @Column(length=3)
    private boolean active;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_worker", nullable=false)
    private UserWorker userWorker;
    @ManyToOne(optional=false)
    @JoinColumn(name="fk_rights", nullable=false)
    private WorkerRights workerRights;

    /** Default constructor. */
    public UserWorkerWorkerRights() {
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
     * Access method for workerRights.
     *
     * @return the current value of workerRights
     */
    public WorkerRights getWorkerRights() {
        return workerRights;
    }

    /**
     * Setter method for workerRights.
     *
     * @param aWorkerRights the new value for workerRights
     */
    public void setWorkerRights(WorkerRights aWorkerRights) {
        workerRights = aWorkerRights;
    }

    /**
     * Compares the key for this instance with another UserWorkerWorkerRights.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserWorkerWorkerRights and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserWorkerWorkerRights)) {
            return false;
        }
        UserWorkerWorkerRights that = (UserWorkerWorkerRights) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserWorkerWorkerRights.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserWorkerWorkerRights)) return false;
        return this.equalKeys(other) && ((UserWorkerWorkerRights)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[UserWorkerWorkerRights |");
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
