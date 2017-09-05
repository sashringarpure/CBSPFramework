package com.cbsp.seed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaJDBC {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private String hostname;
	private String port;
	private String dbName;
	private String username;
	private String password;
	private boolean setAutoCommit;
	static private final String PSQLDriver = "org.postgresql.Driver"; 
	
	public JavaJDBC() {
		this.connection = null;
		this.statement = null;
		this.resultset = null;
		this.hostname = null;
		this.port = null;
		this.dbName = null;
		this.username = null;
		this.password = null;
		this.setAutoCommit = false;
	}
	
	public JavaJDBC(String hostname, String dbname, String port, String user, String pass, boolean autocommit) {
		this.connection = null;
		this.statement = null;
		this.resultset = null;
		this.hostname = hostname;
		this.port = port;
		this.dbName = dbname;
		this.username = user;
		this.password = pass;
		this.setAutoCommit = autocommit;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void setHostname(String hostname) {
		this.hostname = hostname ; 
	}
	
	public void setPort(String port) {
		this.port = port ; 
	}
	
	public void setDbname(String dbName) {
		this.dbName = dbName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAutoCommit(boolean b) {
		this.setAutoCommit = b;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public String getHostname() {
		return this.hostname; 
	}
	
	public String getPort() {
		return this.port; 
	}
	
	public String getDbname() {
		return this.dbName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean getAutoCommit() {
		return this.setAutoCommit;
	}
	
	public void createPSQLConnection() {
		try {
				Class.forName(PSQLDriver);
			} catch(ClassNotFoundException e) {
				System.out.println("Unable to locate PostgreSQL driver class.");
				System.out.print("Please check : maven dependency and class exists in the classpath.");
				System.out.println(e.getMessage());
				System.out.print(e.getStackTrace());
				return;
			} catch(Exception e) {
				System.out.println("Unhandled exception while creating PSQL Driver.");
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				return;
			}
		try {
				connection = DriverManager.getConnection("jdbc:postgresql://"+this.hostname+":"+this.port+"/"+this.dbName,this.username,this.password);
				connection.setAutoCommit(this.setAutoCommit);
			} catch(SQLException e) {
				System.out.println("Exception occurred while connecting to PostgreSQL database");
				System.out.println(this.dbName);
				System.out.println(this.hostname);
				System.out.println(this.password);
				System.out.println(this.port);
				System.out.println(this.username);
				System.out.println(this.PSQLDriver);
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				return;
			} catch(Exception e) {
				System.out.println("Unhandled exception while connecting to PSQL DB.");
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				return;
			}		
	}
	
	
	public void createStatement() {
		try {	
			statement = connection.createStatement();
		} catch(SQLException e) {
			System.out.println("Exception occurred while creating statement object.");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return;
		} catch(Exception e) {
			System.out.println("Unhandled exception while creating statement.");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return;
		}		
	}
	
	public void executeUpdate(String sql) {
		try {	
			statement.executeUpdate(sql);
		} catch(SQLException e) {
			System.out.println("Exception occurred while executing DML/DDL");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(this.PSQLDriver);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} catch(Exception e) {
			System.out.println("Unhandled exception executing DML/DDL.");	
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	public ResultSet executeQuery(String sql) {
		try {	
			resultset = statement.executeQuery(sql);
		} catch(SQLException e) {
			System.out.println("Exception occurred while executing SQL");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(this.PSQLDriver);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return resultset;
		} catch(Exception e) {
			System.out.println("Unhandled exception while executing SQL.");	
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return resultset;
		}
			return resultset;
	}
	
	public ArrayList<ArrayList> toArrayList(ResultSet rs) {
		ArrayList<ArrayList> arrayList = new ArrayList<ArrayList>();
		arrayList.clear();
		try {
			ArrayList<Object> rsCols = new ArrayList<Object>(rs.getMetaData().getColumnCount());
			while (rs.next()) {
				rsCols.clear();
				for ( int col = 1 ; col <= rs.getMetaData().getColumnCount(); col++ ) {
					rsCols.add(rs.getObject(col));
				}
				arrayList.add(rsCols);
			}
		} catch(SQLException e) {
			System.out.println("Exception occurred while converting resultset to arraylist. ");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(this.PSQLDriver);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} catch(Exception e) {
			System.out.println("Unhandled exception while converting resultset to arraylist.");	
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return arrayList;	
	}
	
	public void executeCommit() {
		try {
			connection.commit();
		} catch(SQLException e) {
			System.out.println("Exception occurred while executing COMMIT.");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} catch(Exception e) {
			System.out.println("Unhandled exception while executing commit.");	
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	public void closeResultset() {
		try {	
				resultset.close();
		} catch(SQLException e) {
			System.out.println("Exception occurred while closing resultset object");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(this.PSQLDriver);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} catch(Exception e) {
			System.out.println("Unhandled exception while closing resultset.");	
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
	
	public void closeStatement() {
		try {	
			statement.close();
		} catch(SQLException e) {
			System.out.println("Exception occurred while closing statement object.");
			System.out.println(this.dbName);
			System.out.println(this.hostname);
			System.out.println(this.password);
			System.out.println(this.port);
			System.out.println(this.username);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return;
		} catch(Exception e) {
			System.out.println("Unhandled exception while closing statement.");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return;
		}		
	}
	
	public void closeConnection() {
		try {
				this.connection.close();
			} catch(SQLException e) {
				System.out.println("Exception occurred while closing connection to database");
				System.out.println(this.dbName);
				System.out.println(this.hostname);
				System.out.println(this.password);
				System.out.println(this.port);
				System.out.println(this.username);
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				return;
		} catch(Exception e) {
				System.out.println("Unhandled exception while closing connection.");
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				return;
		}		
	}
	
}
