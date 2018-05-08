package licenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class closeConnection {
	
	public static void closeCon(Connection con,PreparedStatement stm){
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
