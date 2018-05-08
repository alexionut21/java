package views;

import java.sql.Blob;

public class Utilizator {
int id_utilizator;
String email;
String parola;
String nume;
String prenume;
Blob poza;
public int getId_utilizator() {
	return id_utilizator;
}
public void setId_utilizator(int id_utilizator) {
	this.id_utilizator = id_utilizator;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String getPrenume() {
	return prenume;
}
public void setPrenume(String prenume) {
	this.prenume = prenume;
}
public Blob getPoza() {
	return poza;
}
public void setPoza(Blob poza) {
	this.poza = poza;
}
public String getParola() {
	return parola;
}
public void setParola(String parola) {
	this.parola = parola;
}


}
