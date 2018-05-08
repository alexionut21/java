package licenta;
import java.sql.Connection;
import java.sql.SQLException;

public class testDb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		/*PreparedStatement stm = null;
		ResultSet resultSet = null;
		String query = "select id_zbor_aerian,denumire_linie_aeriana,nr_zbor,aeroport_plecare,tara_plecare,aeroport_destinatie,tara_destinatie,TO_CHAR(data_zbor,'dd/mm/yyyy') data_zbor,ora_plecare,ora_destinatie,pret_zbor,moneda,nr_locuri_zbor from zbor_aerian where data_zbor=? and tara_plecare=? and aeroport_destinatie=?";
*/
		try {
			con = DBConnection.getConnection();
	}
		finally{
			con.close();
		}


	}
	}
