package js.jpa.pk.relation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import js.jpa.BaseEntity;

@Entity
public class Pers extends BaseEntity  {
		
	@OneToMany(mappedBy = "pers", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Addr> addr;
	
	private String name;

	public List<Addr> getAddr() {
		return addr;
	}

	public void setAddr(List<Addr> addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
