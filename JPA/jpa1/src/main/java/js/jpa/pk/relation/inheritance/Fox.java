package js.jpa.pk.relation.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Fox extends Animal {
	
	private String foxFeature;

	public String getFoxFeature() {
		return foxFeature;
	}

	public void setFoxFeature(String foxFeature) {
		this.foxFeature = foxFeature;
	}

}
