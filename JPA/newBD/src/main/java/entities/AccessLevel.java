package entities;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table (name = "AccessLevel")
@NamedQuery(name = "AccessLevel.getAll", query = "SELECT a FROM AccessLevel a")
public class AccessLevel {
    private int accessLevelId;
    private String status;

    @Id
    @Column(name = "accessLevel_id")
    public int getAccessLevelId() {
        return accessLevelId;
    }

    public void setAccessLevelId(int accessLevelId) {
        this.accessLevelId = accessLevelId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessLevel that = (AccessLevel) o;

        if (accessLevelId != that.accessLevelId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accessLevelId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
