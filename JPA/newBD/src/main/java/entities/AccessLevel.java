package entities;

import javax.persistence.*;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "AccessLevel")
@NamedQuery(name = "AccessLevel.getAll", query = "SELECT a FROM AccessLevel a")
public class AccessLevel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accessLevelId;
    private String status;

    public AccessLevel(String status) {
        this.status = status;
    }

    public AccessLevel() {
    }

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


}
