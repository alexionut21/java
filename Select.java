package licenta;

import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Decoder.BASE64Encoder;
import views.Anamneza;
import views.Articol;
import views.Comentariu;
import views.Provocare;
import views.Utilizator;

public class Select {
public static void main(String[] args) throws FileNotFoundException{
		//System.out.println(selectUtilizatorForProfile("admin","admin").getEmail());
	System.out.println(selectAnamnezaForProfile(78));
}
		
    public static ArrayList<Articol> selectArticol() throws SQLException {

    ArrayList<Articol> arts = new ArrayList<Articol>();	
	Connection con = null;
	PreparedStatement stm = null;
	ResultSet resultSet = null;
	String query = "Select * from articol";
		
	try {
		con = DBConnection.getConnection();
		stm = con.prepareStatement(query);
		resultSet = stm.executeQuery();
		while(resultSet.next()){
			Articol art = new Articol();
			art.setId_articol(resultSet.getInt("ID_ARTICOL"));
			System.out.println(art.getId_articol());
			art.setData(resultSet.getDate("DATA_ARTICOL"));
			System.out.println(art.getData());
			art.setTitlul(resultSet.getString("TITLUL"));
			System.out.println(art.getTitlul());
			art.setContinut(resultSet.getString("CONTINUT"));
			System.out.println(art.getContinut());
			art.setImagine(blobToString(resultSet.getBlob("IMAGINE")));
			System.out.println("QQQQQQQQQ "+art.getImagine());
			art.setLink(resultSet.getString("LINK"));
			System.out.println("LINK "+art.getLink());
			arts.add(art);
		}
	} catch (SQLException err) {
		throw new SQLException(err.getMessage(), err);
	}finally{
		closeConnection.closeCon(con, stm);
	}	
	return arts;	
	}
    
    
    public static String blobToString(Blob artImg){
    	Blob img;
    	byte[] imgData = null ;
    	String image="";
		img=artImg;
		try {
			imgData = img.getBytes(1,(int)img.length());
			BASE64Encoder encoder = new BASE64Encoder();
			StringBuilder imageString = new StringBuilder();
			imageString.append("data:image/png;base64,");
			imageString.append(encoder.encode(imgData));
			image = imageString.toString();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
    }
    

	 public static ArrayList<Provocare> selectProvocare() throws SQLException {
		 ArrayList<Provocare> provocare = new ArrayList<Provocare>();	
			Connection con = null;
			PreparedStatement stm = null;
			ResultSet resultSet = null;
			String query = "Select * from provocare where zi_afisare = ?";
		 try {
				con = DBConnection.getConnection();
				stm = con.prepareStatement(query);
				stm.setString(1,DataParser.returnSysday());
				resultSet = stm.executeQuery();
				while(resultSet.next()){
					Provocare pro = new Provocare();
					pro.setId_provocare(resultSet.getInt("ID_PROVOCARE"));
					System.out.println(pro.getId_provocare());
					pro.setData(resultSet.getDate("DATA_INSERARE"));
					System.out.println(pro.getData());
					pro.setDescriere(resultSet.getString("DESCRIERE_PROVOCARE"));
					System.out.println(pro.getDescriere());
					pro.setImagine(Select.blobToString(resultSet.getBlob("IMAGINE")));
					System.out.println("QQQQQQQQQ "+pro.getImagine());
					pro.setZiAfisare(resultSet.getString("ZI_AFISARE"));
					System.out.println(pro.getZiAfisare());
					pro.setRepetare(resultSet.getString("REPETARI"));
					System.out.println(pro.getRepetare());
					provocare.add(pro);
				}
			} catch (SQLException err) {
				throw new SQLException(err.getMessage(), err);
			}finally{
				closeConnection.closeCon(con, stm);
			}	
			return provocare;	
			}
	 
	 public static ArrayList<Comentariu> selectComentariu() throws SQLException {

		 ArrayList<Comentariu> comentariu = new ArrayList<Comentariu>();	
			Connection con = null;
			PreparedStatement stm = null;
			ResultSet resultSet = null;
			String query = "Select * from comentariu order by id_comentariu desc";
		 try {
				con = DBConnection.getConnection();
				stm = con.prepareStatement(query);
				resultSet = stm.executeQuery();
				while(resultSet.next()){
					Comentariu com = new Comentariu();
					com.setId_comentariu(resultSet.getInt("ID_COMENTARIU"));
					System.out.println(com.getId_comentariu());
					com.setData(resultSet.getDate("DATA_COMENTARIU"));
					System.out.println(com.getData());
					com.setContinut(resultSet.getString("CONTINUT"));
					System.out.println(com.getContinut());	
					com.setId_utilizator(resultSet.getInt("ID_UTILIZATOR"));
					System.out.println(com.getId_utilizator());	
					comentariu.add(com);
				}
			} catch (SQLException err) {
				throw new SQLException(err.getMessage(), err);
			}finally{
				closeConnection.closeCon(con, stm);
			}	
			return comentariu;				
	 }
	 
	public static String selectNume(int idUtil){
		 Connection con = null;
			PreparedStatement stm = null;
			ResultSet resultSet = null;
			String nume="";
			try {
			con = DBConnection.getConnection();
			String query = "SELECT NUME FROM UTILIZATOR WHERE ID_UTILIZATOR = ?";
			stm = con.prepareStatement(query);
			stm.setInt(1, idUtil);
			resultSet = stm.executeQuery();
			while(resultSet.next()){
				nume = resultSet.getString("NUME");
				System.out.println(nume);
			}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return nume;
	 }
	
	 public static Boolean selectLogin(String nume,String parola){
		 	Connection con = null;
		 	PreparedStatement stm = null;
			ResultSet resultSet = null;
			Boolean flag= false;
			try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM UTILIZATOR WHERE email= ? and parola = ?";
			stm = con.prepareStatement(query);
			stm.setString(1, nume);
			stm.setString(2, parola);
			resultSet = stm.executeQuery();
			while(resultSet.next()){
			String	nm = resultSet.getString("EMAIL");
			String	pass = resultSet.getString("PAROLA");
				System.out.println(nm);
				System.out.println(pass);
				flag=true;
			}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return flag;
	 }
	 public static int selectLastIdUtilizator(){
		 Connection con = null;
		 PreparedStatement stm = null;
			ResultSet resultSet = null;
			int id=0;
			try {
				con = DBConnection.getConnection();
				String query = "SELECT MAX(ID_UTILIZATOR) FROM UTILIZATOR";
				stm = con.prepareStatement(query);
				resultSet = stm.executeQuery();
				while(resultSet.next()){
					id=resultSet.getInt("MAX(ID_UTILIZATOR)");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return id;
	 }
	 
	 public static int selectLastIdIstoricMedical(){
		 Connection con = null;
		 PreparedStatement stm = null;
			ResultSet resultSet = null;
			int id=0;
			try {
				con = DBConnection.getConnection();
				String query = "SELECT MAX(ID_ISTORIC_MEDICAL) FROM ISTORIC_MEDICAL";
				stm = con.prepareStatement(query);
				resultSet = stm.executeQuery();
				while(resultSet.next()){
					id=resultSet.getInt("MAX(ID_ISTORIC_MEDICAL)");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return id;
	 }
	 
	 public static Utilizator selectUtilizatorForProfile(String email,String parola){
		 Connection con = null;
		 	PreparedStatement stm = null;
			ResultSet resultSet = null;
			Utilizator util = new Utilizator();
			try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM UTILIZATOR WHERE email= ? and parola = ?";
			stm = con.prepareStatement(query);
			stm.setString(1, email);
			stm.setString(2, parola);
			resultSet = stm.executeQuery();
			while(resultSet.next()){
				util.setId_utilizator(resultSet.getInt("ID_UTILIZATOR"));
				System.out.println(util.getId_utilizator());
				util.setEmail(resultSet.getString("EMAIL"));
				System.out.println(util.getEmail());
				util.setParola(resultSet.getString("PAROLA"));
				System.out.println(util.getParola());
				util.setNume(resultSet.getString("NUME"));
				System.out.println(util.getNume());
				util.setPrenume(resultSet.getString("PRENUME"));
				System.out.println(util.getPrenume());
				
			}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return util;
	 }
	 
	 
	 public static Anamneza selectAnamnezaForProfile(int idUtilizator){
		 Connection con = null;
		 	PreparedStatement stm = null;
			ResultSet resultSet = null;
			Anamneza anam = new Anamneza();
			try {
			con = DBConnection.getConnection();
			String query = "SELECT * FROM ANAMNEZA WHERE ID_UTILIZATOR = ?";
			stm = con.prepareStatement(query);
			stm.setInt(1, idUtilizator);
			resultSet = stm.executeQuery();
			while(resultSet.next()){
				anam.setSex(resultSet.getString("SEX"));
				System.out.println(anam.getSex());
				anam.setGreutate(resultSet.getInt("GREUTATE"));
				System.out.println(anam.getGreutate());
				anam.setStil_viata(resultSet.getString("STIL_VIATA"));
				System.out.println(anam.getStil_viata());
				anam.setNivel_stres(resultSet.getString("NIVEL_STRES"));
				System.out.println(anam.getNivel_stres());
				anam.setTip_somatic(resultSet.getString("TIP_SOMATIC"));
				System.out.println(anam.getTip_somatic());
				anam.setObiectiv(resultSet.getString("OBIECTIV"));
				System.out.println(anam.getObiectiv());
				anam.setInaltime(resultSet.getInt("INALTIME"));
				System.out.println(anam.getInaltime());
				anam.setImc(resultSet.getInt("IMC"));
				System.out.println(anam.getImc());			
			}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return anam;
	 }
}
