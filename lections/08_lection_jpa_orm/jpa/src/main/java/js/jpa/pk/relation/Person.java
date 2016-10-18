package js.jpa.pk.relation;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapKeyEnumerated;

import js.jpa.BaseEntity;

@Entity
public class Person extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@ElementCollection
	@MapKeyEnumerated
	private Map<PhoneType ,Phone> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<PhoneType, Phone> getPhones() {
		return phones;
	}

	public void setPhones(Map<PhoneType, Phone> phones) {
		this.phones = phones;
	}


}
