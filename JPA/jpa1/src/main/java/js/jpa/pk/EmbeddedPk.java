package js.jpa.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedPk implements Serializable{
	
	int departmentId;
    long projectId;
    
    //equals hashCode e.t.c

}
