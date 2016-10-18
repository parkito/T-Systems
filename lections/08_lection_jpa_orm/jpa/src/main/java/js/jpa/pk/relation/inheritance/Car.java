package js.jpa.pk.relation.inheritance;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
	
	private String carFeature;

}
