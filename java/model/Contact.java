// Generated with g9.

package java.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity(name="contact")
public class Contact implements Serializable {

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

    @Column(length=255)
    private String data;
    @Column(length=255)
    private String description;
    @Column(name="fk_type", nullable=false, precision=7)
    private int fkType;
    @OneToOne(optional=false, mappedBy="contact")
    @JoinColumn(name="id", nullable=false)
    private ContactType contactType;

    /** Default constructor. */
    public Contact() {
        super();
    }

    /**
     * Access method for data.
     *
     * @return the current value of data
     */
    public String getData() {
        return data;
    }

    /**
     * Setter method for data.
     *
     * @param aData the new value for data
     */
    public void setData(String aData) {
        data = aData;
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
     * Access method for fkType.
     *
     * @return the current value of fkType
     */
    public int getFkType() {
        return fkType;
    }

    /**
     * Setter method for fkType.
     *
     * @param aFkType the new value for fkType
     */
    public void setFkType(int aFkType) {
        fkType = aFkType;
    }

    /**
     * Access method for contactType.
     *
     * @return the current value of contactType
     */
    public ContactType getContactType() {
        return contactType;
    }

    /**
     * Setter method for contactType.
     *
     * @param aContactType the new value for contactType
     */
    public void setContactType(ContactType aContactType) {
        contactType = aContactType;
    }

}
