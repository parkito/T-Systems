package js.jpa.pk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProjectEmb {
	
	@EmbeddedId
	private EmbeddedPk id;

}
