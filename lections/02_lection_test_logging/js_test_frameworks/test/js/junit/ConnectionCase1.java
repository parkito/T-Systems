package js.junit;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionCase1 {
	
	@Test
	public void testConnection() {
		Assert.assertTrue(ConnectionHolder.getConnection().isConnection());
	}

}
