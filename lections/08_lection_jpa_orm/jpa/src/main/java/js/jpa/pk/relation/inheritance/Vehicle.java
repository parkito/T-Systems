package js.jpa.pk.relation.inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
	
	@Id
	private long id;
	
	private String common;

}
