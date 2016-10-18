/**
 * 
 */
package js.mock;

import js.junit.Connection;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * @author <a href="mailto:Alekseychenko.Vladimir@t-systems.ru">Alekseychenko.Vladimir</a>
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Connection.class)
public class PowerMockConnectionTest {

	
	public static final String TEST_URL = "test_url";
	
	@Test
	public void mockCreation(){
		Connection connection = PowerMockito.mock(Connection.class);
	}
	
	
	@Test
	public void spyCreation(){
		Connection connection = PowerMockito.spy(new Connection());
	}
	
	@Test
	public void whiteBoxPresentation(){
		
		Connection connection = new Connection();
	
		Whitebox.setInternalState(connection, String.class, TEST_URL);
		
		Assert.assertEquals(TEST_URL, connection.getUrl());
	}
	
	
	@Test
	public void privateMethodsPresentation() throws Exception{
		
		Connection connection = PowerMockito.spy(new Connection());
		
		connection.setConnection(false);
		Assert.assertEquals(false, connection.getRealConnectionStateByPrivateMethod());
		
		PowerMockito.when(connection, "getConnectionState").thenReturn(Boolean.TRUE);
		
		Assert.assertEquals(true, connection.getRealConnectionStateByPrivateMethod());
		
		PowerMockito.verifyPrivate(connection, Mockito.times(2)).invoke("getConnectionState");
	}
	
	@Test
	public void constructorPresentation() throws Exception{
		
		Connection connection = new Connection();
		connection.setConnection(true);
		connection.setUrl(TEST_URL);

		PowerMockito.whenNew(Connection.class).withNoArguments().thenReturn(connection);
		
		Connection anotherConnection = new Connection();
		
		Assert.assertEquals(TEST_URL, anotherConnection.getUrl());
		Assert.assertEquals(true, anotherConnection.isConnection());
		
		connection.setConnection(false);
		Assert.assertEquals(false, anotherConnection.isConnection());
	}
}
