// Generated with g9.

package java.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name="user_worker")
public class UserWorker implements Serializable {

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
    @OneToMany(mappedBy="userWorker")
    private Set<GroupWorker> groupWorker;
    @OneToMany(mappedBy="userWorker")
    private Set<PrivateCoach> privateCoach;
    @OneToOne(optional=false, mappedBy="userWorker")
    @JoinColumn(name="id", nullable=false)
    private User user;
    @OneToMany(mappedBy="userWorker")
    private Set<UserWorkerWorkerRights> userWorkerWorkerRights;
    @ManyToOne
    @JoinColumn(name="fk_worker_type")
    private WorkerType workerType;

    /** Default constructor. */
    public UserWorker() {
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
     * Access method for workerType.
     *
     * @return the current value of workerType
     */
    public WorkerType getWorkerType() {
        return workerType;
    }

    /**
     * Setter method for workerType.
     *
     * @param aWorkerType the new value for workerType
     */
    public void setWorkerType(WorkerType aWorkerType) {
        workerType = aWorkerType;
    }

}
