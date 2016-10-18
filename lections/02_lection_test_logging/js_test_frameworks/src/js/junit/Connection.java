package js.junit;

import java.util.concurrent.TimeUnit;

public class Connection {
	
	private boolean connection;
	private String url;
	
	public boolean establishConnection(String url, Integer  time) {
		if (time != null) {
			try {
				TimeUnit.SECONDS.sleep(time);
				if (url != null) {
					this.url = url;
				} else {
					throw new IllegalArgumentException("Connection must be set");
				}
				this.connection = true;
				System.out.println("Connection to: " +url+ " established");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return  connection;
	}

	public boolean isConnection() {
		return connection;
	}

	public void setConnection(boolean connection) {
		this.connection = connection;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void closeConnection() {
		System.out.println("Connection to: " +url+ " close...");
		connection = false;
		url = null;
	}
	
	public boolean getRealConnection(){
		return connection;
	}
	
	public boolean getRealConnectionStateByPrivateMethod(){
		return getConnectionState();
	}
	
	private boolean getConnectionState(){
		return connection;
	}

}
