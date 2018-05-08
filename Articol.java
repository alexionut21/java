package views;

import java.sql.Date;

public class Articol {
int id_articol;
Date data;
String titlul;
String continut;
String imagine;
String link;
public int getId_articol() {
	return id_articol;
}
public void setId_articol(int id_articol) {
	this.id_articol = id_articol;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getTitlul() {
	return titlul;
}
public void setTitlul(String titlul) {
	this.titlul = titlul;
}
public String getContinut() {
	return continut;
}
public void setContinut(String continut) {
	this.continut = continut;
}
public String getImagine() {
	return imagine;
}
public void setImagine(String imagine) {
	this.imagine = imagine;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
}
