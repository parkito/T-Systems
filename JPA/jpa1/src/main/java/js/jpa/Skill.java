package js.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Skill {
	
	private String skillName;
	
	private String skillLevel;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

}
