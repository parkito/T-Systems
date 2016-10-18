package de.tsystems.jschool.sample.logger;

import org.apache.log4j.Logger;

import de.tsystems.jschool.sample.domain.Customer;
import de.tsystems.jschool.sample.domain.Shop;


public class Main {

	 private static Logger logger = Logger.getLogger(Main.class);

	  public static void main(String[] args) throws Exception
	  {
	    logger.debug("Inside main()");
	    logger.info("Hello world!");
	    logger.error("Error!", new Exception("An exception"));

	    Logger hibernateGeneral = Logger.getLogger("org.hibernate");
	    hibernateGeneral.debug("Starting Hibernate");

	    Logger hibernateSql = Logger.getLogger("org.hibernate.SQL");
	    hibernateSql.debug("select * from my table");

	    hibernateGeneral.error("Hibernate error");
	    
	    Customer someCustomer = new Customer("Ivan", "Ivanov");
	    someCustomer.writeInfoLogAboutMe();
	    Shop someShop = new Shop("SPb, Nevskiy", "SomeShop");
	    someShop.writeDebugLogAboutMe();
	  }
}
