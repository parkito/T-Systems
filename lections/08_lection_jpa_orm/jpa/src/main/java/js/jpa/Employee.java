package js.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "NAME", "SURNAME" }), name = "EMPLOYEE")
public class Employee {

	@Id
	private long id;

	@Column(name = "NAME", nullable = false, length = 20)
	private String name;
	@Column(name = "SURNAME", nullable = false, length = 20)
	private String surname;
	
	@Embedded
	private Skill skill;

	// getter and setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
