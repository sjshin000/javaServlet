package jspPrj;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class Connect {
	String jdbcDriver = "jdbc:mysql://localhost:3307/jspboard"; //프로토콜:
	String dbuser = "root";
	String password = "111111";
	java.sql.Connection conn = null;
	
	PreparedStatement pstmt = null;
	java.sql.Statement stmt = null;
	
	ResultSet rs = null;
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcDriver, dbuser, password);
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void connectionClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
