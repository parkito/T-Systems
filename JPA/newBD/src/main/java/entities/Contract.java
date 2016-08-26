package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
public class Contract {
    private int contractId;
    private String number;
    private byte isBlocked;
    private Byte blockedByAdmin;
    private String whoBlockedId;

    @Id
    @Column(name = "contract_id")
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "isBlocked")
    public byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Basic
    @Column(name = "blockedByAdmin")
    public Byte getBlockedByAdmin() {
        return blockedByAdmin;
    }

    public void setBlockedByAdmin(Byte blockedByAdmin) {
        this.blockedByAdmin = blockedByAdmin;
    }

    @Basic
    @Column(name = "whoBlocked_id")
    public String getWhoBlockedId() {
        return whoBlockedId;
    }

    public void setWhoBlockedId(String whoBlockedId) {
        this.whoBlockedId = whoBlockedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (contractId != contract.contractId) return false;
        if (isBlocked != contract.isBlocked) return false;
        if (number != null ? !number.equals(contract.number) : contract.number != null) return false;
        if (blockedByAdmin != null ? !blockedByAdmin.equals(contract.blockedByAdmin) : contract.blockedByAdmin != null)
            return false;
        if (whoBlockedId != null ? !whoBlockedId.equals(contract.whoBlockedId) : contract.whoBlockedId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractId;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) isBlocked;
        result = 31 * result + (blockedByAdmin != null ? blockedByAdmin.hashCode() : 0);
        result = 31 * result + (whoBlockedId != null ? whoBlockedId.hashCode() : 0);
        return result;
    }
}
