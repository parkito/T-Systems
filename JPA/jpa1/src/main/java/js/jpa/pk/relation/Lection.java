package js.jpa.pk.relation;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

@Entity
public class Lection {
	
	@Id
	private String id;
	
	private String subject;
	
	@ManyToMany(mappedBy="lections")
	private List<Student> students;

	public String getId() {
		return id;
	}
	
	@PrePersist
	public void prepareId() {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
