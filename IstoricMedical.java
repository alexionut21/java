package views;

import java.sql.Date;

public class IstoricMedical {
int id_istoric_medical;
String boli_cardiace;
String terapie_boala;
String interventii_chirurgicale;
String nasteri;
String nr_nasteri;
String apt_sport;
Date perioada;
public int getId_istoric_medical() {
	return id_istoric_medical;
}
public void setId_istoric_medical(int id_istoric_medical) {
	this.id_istoric_medical = id_istoric_medical;
}
public String getBoli_cardiace() {
	return boli_cardiace;
}
public void setBoli_cardiace(String boli_cardiace) {
	this.boli_cardiace = boli_cardiace;
}
public String getTerapie_boala() {
	return terapie_boala;
}
public void setTerapie_boala(String terapie_boala) {
	this.terapie_boala = terapie_boala;
}
public String getInterventii_chirurgicale() {
	return interventii_chirurgicale;
}
public void setInterventii_chirurgicale(String interventii_chirurgicale) {
	this.interventii_chirurgicale = interventii_chirurgicale;
}
public String getNasteri() {
	return nasteri;
}
public void setNasteri(String nasteri) {
	this.nasteri = nasteri;
}
public String getNr_nasteri() {
	return nr_nasteri;
}
public void setNr_nasteri(String nr_nasteri) {
	this.nr_nasteri = nr_nasteri;
}
public Date getPerioada() {
	return perioada;
}
public void setPerioada(Date perioada) {
	this.perioada = perioada;
}
public String getApt_sport() {
	return apt_sport;
}
public void setApt_sport(String apt_sport) {
	this.apt_sport = apt_sport;
}

}
