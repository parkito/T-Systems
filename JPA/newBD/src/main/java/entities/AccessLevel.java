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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accessLevel_id")
    private int accessLevelId;
    @Basic
    @Column(name = "status")
    private String status;

    public AccessLevel(String status) {
        this.status = status;
    }


    public AccessLevel() {
    }


    public int getAccessLevelId() {
        return accessLevelId;
    }

    public void setAccessLevelId(int accessLevelId) {
        this.accessLevelId = accessLevelId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
