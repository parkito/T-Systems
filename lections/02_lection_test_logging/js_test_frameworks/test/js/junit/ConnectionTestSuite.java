package js.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
        {
        	ConnectionCase1.class,
        	ConnectionCase2.class
        }
 )
public class ConnectionTestSuite {
	
		
	@BeforeClass
	public static void prepareConnection() {
		ConnectionHolder.establishConnection("url1");
	}
	
	@AfterClass
	public static void closeConnection() {
		ConnectionHolder.closeConnection();
	}

}
