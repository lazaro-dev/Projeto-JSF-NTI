package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
	
	private Connection con = null;
	private String hostName = "localhost";
	private String userName = "SYSDBA";
	private String password = "masterkey";
	private String jdbcDriver = "org.firebirdsql.jdbc.FBDriver";
	private String dataBaseName = "BANCO";
	private String dataBasePrefix = "jdbc:firebirdsql";
	private String url = dataBasePrefix + ":" + hostName + ":" + dataBaseName;

	public Banco() {	
		
	}

	public Connection connection() {
		
		Runtime.getRuntime().gc();
		try {
			if (con == null) {
				Class.forName(jdbcDriver);
				con = DriverManager.getConnection(url + "?defaultResultSetHoldable=True", userName, password);
			} else if (con.isClosed()) {
				con = null;
				return connection();
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
