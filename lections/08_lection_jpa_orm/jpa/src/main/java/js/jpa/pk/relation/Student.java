package js.jpa.pk.relation;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Student {
	
	@Id
	private String id;
	
	private String name;
	
	@OneToOne(mappedBy = "student")
	private Address address;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="SHEDULE", 
                joinColumns={@JoinColumn(name="STUDENTID")}, 
                inverseJoinColumns={@JoinColumn(name="LECTIONID")})
	private List<Lection> lections;
	
	@ManyToOne
	private WorkGroup workGroup;

	@PrePersist
	public void prepareId() {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkGroup getWorkGroup() {
		return workGroup;
	}

	public void setWorkGroup(WorkGroup workGroup) {
		this.workGroup = workGroup;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Lection> getLections() {
		return lections;
	}

	public void setLections(List<Lection> lections) {
		this.lections = lections;
	}
	
}
