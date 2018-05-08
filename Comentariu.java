package views;

import java.sql.Date;

public class Comentariu {
	int Id_comentariu;
	Date data;
	String continut;
	int Id_utilizator;
	public int getId_comentariu() {
		return Id_comentariu;
	}
	public void setId_comentariu(int id_comentariu) {
		Id_comentariu = id_comentariu;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getContinut() {
		return continut;
	}
	public void setContinut(String continut) {
		this.continut = continut;
	}
	public int getId_utilizator() {
		return Id_utilizator;
	}
	public void setId_utilizator(int id_utilizator) {
		Id_utilizator = id_utilizator;
	}
	
}
