package views;

import java.sql.Blob;

public class Antrenament {
int id_antrenament;
String intensitate;
String densitate;
String frecventa;
String volum;
Blob continut;
public int getId_antrenament() {
	return id_antrenament;
}
public void setId_antrenament(int id_antrenament) {
	this.id_antrenament = id_antrenament;
}
public String getIntensitate() {
	return intensitate;
}
public void setIntensitate(String intensitate) {
	this.intensitate = intensitate;
}
public String getDensitate() {
	return densitate;
}
public void setDensitate(String densitate) {
	this.densitate = densitate;
}
public String getFrecventa() {
	return frecventa;
}
public void setFrecventa(String frecventa) {
	this.frecventa = frecventa;
}
public String getVolum() {
	return volum;
}
public void setVolum(String volum) {
	this.volum = volum;
}
public Blob getContinut() {
	return continut;
}
public void setContinut(Blob continut) {
	this.continut = continut;
}

}
