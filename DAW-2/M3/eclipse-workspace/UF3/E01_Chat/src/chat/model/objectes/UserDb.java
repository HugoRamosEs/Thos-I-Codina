package chat.model.objectes;

public class UserDb {
	private String host;
	private String user;
	private String password;
	private String db;
	
	public UserDb(String host, String user, String password, String db) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.db = db;
	}

	public String getHost() {
		return host;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public String getDb() {
		return db;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDb(String db) {
		this.db = db;
	}
}
