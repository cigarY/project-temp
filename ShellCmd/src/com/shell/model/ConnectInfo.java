package com.shell.model;

public class ConnectInfo {
	public String username;
	public String password;
	public String host;
	public int port;
	
	public ConnectInfo() {
		super();
	}
	public ConnectInfo(String username, String password, String host, int port) {
		super();
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getport() {
		return port;
	}
	public void setport(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "ConnectInfo [username=" + username + ", password=" + password + ", host=" + host + ", port=" + port
				+ "]";
	}
	
}
