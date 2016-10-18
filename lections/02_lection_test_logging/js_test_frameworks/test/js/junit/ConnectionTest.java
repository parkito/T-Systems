package js.junit;

import org.junit.Ignore;
import org.junit.Test;

public class ConnectionTest {
	
	@Ignore
	@Test(timeout=3000)
	public void timeoutTest() {
		Connection connection = new Connection();
		connection.establishConnection("url2", 6);
	}

}
