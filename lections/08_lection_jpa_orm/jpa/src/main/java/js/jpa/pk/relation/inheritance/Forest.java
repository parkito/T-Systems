package js.jpa.pk.relation.inheritance;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Forest {
	
	@Id
	private String id;
	
	@OneToMany(mappedBy = "forest")
	private List<Animal> animals;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

}
