/**
 * 
 */
package js.mock;

import js.junit.Connection;
import junit.framework.Assert;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * @author <a href="mailto:Alekseychenko.Vladimir@t-systems.ru">Alekseychenko.Vladimir</a>
 *
 */
public class MockitoConnectionTest {

	@Test
	public void mockCreation(){
		Connection connection = Mockito.mock(Connection.class);
	}
	
	
	@Test
	public void spyCreation(){
		Connection connection = Mockito.spy(new Connection());
	}
	
	@Test
	public void verifyPresentation(){
		
		Connection connection = Mockito.mock(Connection.class);
		
		connection.closeConnection();
		connection.closeConnection();
		
		Mockito.verify(connection, Mockito.atLeastOnce()).closeConnection();
		Mockito.verify(connection, Mockito.times(2)).closeConnection();
		Mockito.verify(connection, Mockito.never()).isConnection();
		
		Mockito.reset(connection);
		
		connection.isConnection();
		connection.isConnection();
		connection.isConnection();
		
		Mockito.verify(connection, Mockito.never()).closeConnection();
		Mockito.verify(connection, Mockito.atMost(5)).isConnection();
		
	}
	
	@Test
	public void preconditionsPresentation(){
		
		Connection connection = Mockito.mock(Connection.class);
		
		Mockito.when(connection.isConnection()).thenReturn(true);
		connection.setConnection(false);
		
		Assert.assertEquals(true, connection.isConnection());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void preconditionsExceptionPresentation(){
		
		Connection connection = Mockito.mock(Connection.class);
		
		Mockito.when(connection.isConnection()).thenThrow(new IllegalArgumentException("Some info"));
		
		connection.isConnection();
		
	}
	
	@Test
	public void spyPresentation(){
		
		
		Connection connection = Mockito.spy(new Connection());
		
		connection.setConnection(true);
		Assert.assertEquals(true, connection.isConnection());
		
		connection.setConnection(false);
		Assert.assertEquals(false, connection.isConnection());
		
		Mockito.doNothing().when(connection).setConnection(Mockito.anyBoolean());
		
		connection.setConnection(true);
		Assert.assertEquals(false, connection.isConnection());
		
		
		Mockito.reset(connection);
		
		Mockito.when(connection.isConnection()).thenReturn(true);
		
		connection.setConnection(false);
		
		Assert.assertEquals(true, connection.isConnection());
		Assert.assertEquals(false, connection.getRealConnection());
		
		
	}
	
	
	@Test
	public void inOrderPresentation(){
	
		Connection connection = Mockito.mock(Connection.class);
		
		InOrder inOrder = Mockito.inOrder(connection);
		
		connection.isConnection();
		connection.getRealConnection();
		
		inOrder.verify(connection).isConnection();
		inOrder.verify(connection).getRealConnection();
		
	}
}
