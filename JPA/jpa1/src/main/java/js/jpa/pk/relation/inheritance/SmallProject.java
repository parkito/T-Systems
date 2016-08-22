package js.jpa.pk.relation.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SmallProject extends ItProject{
	
	private String smallFeature;

}
