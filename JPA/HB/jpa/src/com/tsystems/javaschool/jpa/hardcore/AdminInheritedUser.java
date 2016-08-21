package com.tsystems.javaschool.jpa.hardcore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
public class AdminInheritedUser extends JSSuperUser {

}
