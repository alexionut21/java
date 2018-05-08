package licenta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Insert {
	 
	public static void main(String[] args) throws FileNotFoundException{		
		int x=1;	
		insertUser("asd","red","dex","qqq",x,1,1);
		//insertIstoricMedical();
		insertAnamneza("M",85,"S","1-4","ENDO","SLABIRE",187,24,Select.selectLastIdUtilizator(),Select.selectLastIdIstoricMedical());
	}
	public static void insertArticol(String date1,String title,String cont,String imageString,Integer id_utilizator,String link) throws SQLException, IOException {
		 Connection con = null;
		 PreparedStatement stm = null;
		 Date date = Date.valueOf(date1);
		System.out.println("DATE IS " + date);
		System.out.println("TITLE IS " + title);
		System.out.println("CONT IS " + cont);
		System.out.println("imageString IS " + imageString);
		System.out.println("id_utilizator IS " + id_utilizator);
		System.out.println("link IS " + link);
		
	 try {
		 con = DBConnection.getConnection();
		 String query = "insert into articol (data_articol,titlul,continut,imagine,id_utilizator,link) values (?,?,?,?,?,?)";
		stm = con.prepareStatement(query);
		stm.setDate(1, date);
	// stm.setString(2, "Your Expert Guide To Green Tea");
	 //stm.setString(3, "Green tea is said to support everything from weight loss to healthy skin and normal aging, but does the science really support the hype?");
	 stm.setString(2,title);
	 stm.setString(3,cont);
	 // File image = new File("C:/Users/meee/Desktop/dbPhoto/green-tea.jpg");
	 File image = new File("C:/Users/meee/Desktop/dbPhoto/"+imageString); 
	 FileInputStream fis = new FileInputStream(image);
	    stm.setBinaryStream(4, fis, (int) image.length());
	    stm.setInt(5, id_utilizator);	
	    //stm.setString(7,"https://www.bodybuilding.com/content/your-expert-guide-to-green-tea.html");
	    stm.setString(6, link);
	    stm.execute();
	    fis.close();
	 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 }finally{		 
		 closeConnection.closeCon(con, stm);
	 }
	}

	 public static void insertComment(String data,String continut,int idUtil){
		 Connection con = null;
		 PreparedStatement stm = null;
		 Date date = Date.valueOf(data);
		 try {
			 con = DBConnection.getConnection();
			 System.out.println("Inainte de insert");
			String query = "insert into comentariu(data_comentariu,continut,id_utilizator) values(?,?,?)";
			 System.out.println("Dupa insert");
			stm = con.prepareStatement(query);
			stm.setDate(1, date);
			System.out.println(date);
			stm.setString(2, continut);
			System.out.println(continut);
			stm.setInt(3, idUtil);
			System.out.println(idUtil);
			stm.execute();
			System.out.println("succes");
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }finally{		 
			 closeConnection.closeCon(con, stm);
		 }
	 }
		
	 public static void insertProvocare(String date1,String descriere,String imageString,String ziAfisare,String repetare) throws FileNotFoundException{
		 Connection con = null;
		 PreparedStatement stm = null;
		 Date date = Date.valueOf(date1);
		 try {
			 con = DBConnection.getConnection();
			 String query = "insert into provocare (DATA_INSERARE,DESCRIERE_PROVOCARE,IMAGINE,ZI_AFISARE,REPETARI) values (?,?,?,?,?)";
			 stm = con.prepareStatement(query);
			 stm.setDate(1, date);
			 stm.setString(2, descriere);
			 File image = new File("C:/workspace/Licenta/WebContent/challengesGifs/"+imageString); 
			 FileInputStream fis = new FileInputStream(image);
			 stm.setBinaryStream(3, fis, (int) image.length());
			 stm.setString(4, ziAfisare);  
			 stm.setString(5, repetare);
			 stm.execute();
			 System.out.println("succes");
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }finally{		 
			 closeConnection.closeCon(con, stm);
		 }
	 }
	 
	 public static void insertUser(String email,String pass,String nume,String prenume,int id_anamneza,int id_antrenament,int id_plan_alimentar){
		 Connection con = null;
		 PreparedStatement stm = null;
		 try {
			 con = DBConnection.getConnection();
			 System.out.println("Inainte de insert");
			String query = "INSERT INTO UTILIZATOR (EMAIL,PAROLA,NUME,PRENUME,ID_ANAMNEZA,ID_ANTRENAMENT,ID_PLAN_ALIMENTAR) values (?,?,?,?,?,?,?)";
			 System.out.println("Dupa insert");
			stm = con.prepareStatement(query);
			stm.setString(1,email);
			 System.out.println(email);	
			stm.setString(2, pass);
			stm.setString(3,nume);
			stm.setString(4, prenume);
			stm.setInt(5, id_anamneza);
			System.out.println(id_anamneza);
			stm.setInt(6, id_antrenament);
			System.out.println(id_antrenament);	
			stm.setInt(7, id_plan_alimentar);
			System.out.println(id_plan_alimentar);	
			stm.execute();
			System.out.println("succes");
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }finally{		 
			 closeConnection.closeCon(con, stm);
		 }
	 }
		
	 
	 public static void insertAnamneza(String sex,int greutate,String stil_viata,String nivel_stres,String tip_somatic,String obiectiv,int inaltime,int imc,int idUtilizator,int idIstoricMedical){

		 Connection con = null;
		 PreparedStatement stm = null;
		 try {
			 con = DBConnection.getConnection();
			 System.out.println("Inainte de insert");
			 String query = "insert into anamneza (sex,greutate,stil_viata,nivel_stres,tip_somatic,obiectiv,inaltime,imc,id_utilizator,id_istoric_medical) values(?,?,?,?,?,?,?,?,?,?)";
			 System.out.println("Dupa insert");
			stm = con.prepareStatement(query);
			 stm.setString(1, sex);
			 stm.setInt(2, greutate);
			 stm.setString(3, stil_viata);
			 stm.setString(4, nivel_stres);
			 stm.setString(5, tip_somatic);
			 stm.setString(6, obiectiv);
			 stm.setInt(7, inaltime);
			 stm.setInt(8, imc);
			 stm.setInt(9, idUtilizator);
			 stm.setInt(10, idIstoricMedical);
			 stm.execute();
			 System.out.println("Succes");
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }finally{		 
			 closeConnection.closeCon(con, stm);
		 }
	 }
}
