package js.jpa.pk.relation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import js.jpa.BaseEntity;

@Entity
public class Addr extends BaseEntity {
	
	@ManyToOne
	private Pers pers;
	
	private String addr;

	public Pers getPers() {
		return pers;
	}

	public void setPers(Pers pers) {
		this.pers = pers;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
