package js.jpa.pk.relation;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Address {

	@OneToOne
	@PrimaryKeyJoinColumn
	private Student student;
	
	@Id
	private String id;
	
	private String street;
	
	@Column(nullable = false, name = "zip")
	private int zipCode;
	
	@PrePersist
	public void prepareId() {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
