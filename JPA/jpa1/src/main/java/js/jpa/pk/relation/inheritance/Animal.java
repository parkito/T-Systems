package js.jpa.pk.relation.inheritance;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {
	
	@Id
	private String id;
	
	private String woolColor;
	
	@ManyToOne
	private Forest forest;
	
	public String getWoolColor() {
		return woolColor;
	}

	public void setWoolColor(String woolColor) {
		this.woolColor = woolColor;
	}

	public Forest getForest() {
		return forest;
	}

	public void setForest(Forest forest) {
		this.forest = forest;
	}

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

}
