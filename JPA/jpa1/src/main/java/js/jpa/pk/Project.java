package js.jpa.pk;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(ProjectId.class)
public class Project {
	@Id
	int departmentId;
	@Id
	long projectId;
	
	
}
