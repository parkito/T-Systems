package js.jpa.pk.relation.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class LargeProject extends ItProject{
	
	private String largeFeature;

}
