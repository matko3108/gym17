// Generated with g9.

package java.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity(name="membership_fee_type")
public class MembershipFeeType implements Serializable {

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
    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal amount;
    @Column(name="validity_period", nullable=false, precision=3)
    private short validityPeriod;
    @OneToMany(mappedBy="membershipFeeType")
    private Set<UserMembershipFee> userMembershipFee;

    /** Default constructor. */
    public MembershipFeeType() {
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
     * Access method for amount.
     *
     * @return the current value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method for amount.
     *
     * @param aAmount the new value for amount
     */
    public void setAmount(BigDecimal aAmount) {
        amount = aAmount;
    }

    /**
     * Access method for validityPeriod.
     *
     * @return the current value of validityPeriod
     */
    public short getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Setter method for validityPeriod.
     *
     * @param aValidityPeriod the new value for validityPeriod
     */
    public void setValidityPeriod(short aValidityPeriod) {
        validityPeriod = aValidityPeriod;
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
     * Compares the key for this instance with another MembershipFeeType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class MembershipFeeType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof MembershipFeeType)) {
            return false;
        }
        MembershipFeeType that = (MembershipFeeType) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another MembershipFeeType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MembershipFeeType)) return false;
        return this.equalKeys(other) && ((MembershipFeeType)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[MembershipFeeType |");
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
