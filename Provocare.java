package views;

import java.sql.Date;

public class Provocare {
int id_provocare;
Date data;
String descriere;
String imagine;
String ziAfisare;
String repetare;
public int getId_provocare() {
	return id_provocare;
}
public void setId_provocare(int id_provocare) {
	this.id_provocare = id_provocare;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getDescriere() {
	return descriere;
}
public void setDescriere(String descriere) {
	this.descriere = descriere;
}
public String getImagine() {
	return imagine;
}
public void setImagine(String imagine) {
	this.imagine = imagine;
}
public String getZiAfisare() {
	return ziAfisare;
}
public void setZiAfisare(String ziAfisare) {
	this.ziAfisare = ziAfisare;
}
public String getRepetare() {
	return repetare;
}
public void setRepetare(String repetare) {
	this.repetare = repetare;
}

}
