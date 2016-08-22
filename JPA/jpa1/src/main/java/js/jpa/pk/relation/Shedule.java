package js.jpa.pk.relation;

import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Embeddable
public class Shedule {
	
	@Id
	private String id;
	
	@Column(name = "STUDENTID")
	private String studentid;
	
	@Column(name = "LECTIONID")
	private String lectionid;

	public String getId() {
		return id;
	}
	
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Version
    private Timestamp lastModifiedDate;

    /**
     * Prepare entity to persist.
     */
    @PrePersist
    public void prepareEntity() {
    	prepareId();
        if (creationDate == null) {
            creationDate = new Date();
        }
    }
	
	public void prepareId() {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
	}

	
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getLectionid() {
		return lectionid;
	}

	public void setLectionid(String lectionid) {
		this.lectionid = lectionid;
	}
}
