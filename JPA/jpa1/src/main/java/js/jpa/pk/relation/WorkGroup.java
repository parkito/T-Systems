package js.jpa.pk.relation;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

@Entity
public class WorkGroup {
	
	@Id
	private String id;

	private int number;
	
	//@OneToMany(mappedBy = "workGroup")
	//@OneToMany(mappedBy = "workGroup", cascade = CascadeType.REMOVE)
	@OneToMany(mappedBy = "workGroup", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Student> student;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	@PrePersist
	public void prepareId() {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
	}

}
