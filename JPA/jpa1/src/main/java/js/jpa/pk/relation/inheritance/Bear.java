package js.jpa.pk.relation.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Bear extends Animal {
	
	private String bearFeature;

	public String getBearFeature() {
		return bearFeature;
	}

	public void setBearFeature(String bearFeature) {
		this.bearFeature = bearFeature;
	}

}
