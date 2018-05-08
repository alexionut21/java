package licenta;

import java.text.ParseException;

public class IMC {
	 public static void main(String[] args) throws ParseException{
		 System.out.println(indiceMasaCorporala(85,184));
	 }
	public static int indiceMasaCorporala(int greutate,int inaltime){
		float i=inaltime;
		float x=i/100;
		System.out.println(x);
		int d=Math.round(greutate/(x*x));
		System.out.println(d);
		return d;
	}
}
