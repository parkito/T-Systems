package js.junit;

public class ConnectionHolder {
	
	private final static Connection connection = new Connection();
	
	public synchronized static Connection establishConnection(String url) {
		if (connection.isConnection()) {
			throw new RuntimeException("Connection alredy establish to "+ connection.getUrl());
		}
		connection.establishConnection(url, 5);
		return connection;
	}
	
	public synchronized static void closeConnection() {
		connection.closeConnection();
	}
	
	public synchronized static Connection getConnection() {
		return connection;
	}

}
