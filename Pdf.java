package licenta;


public class Pdf {

public static void main(String[] args){
	
	String s="f";
	String stilDeViata="activ";
	String cc="mezomorf";
	String ob="slabire";
	String nStres="1-4";
	boolean aptSport=false;
	boolean boliCardiace=false;
	boolean tBoala=false;
	boolean interventiiChirurgicale=false;
	//boolean nasteri=false;
	//System.out.println(register(s,stilDeViata,cc,ob,nStres,aptSport,boliCardiace,tBoala,interventiiChirurgicale));
	System.out.println(register("B","activ","ectomorf","hipertrofie","1-4",aptSport,boliCardiace,tBoala,interventiiChirurgicale));
} 
public static String register(String s,String stilDeViata,String cc,String ob,String nStres,boolean aptSport,boolean boliCardiace,boolean tBoala,boolean interventiiChirurgicale){
	int rez=0;
	System.out.println("SEXUL ESTE " +s+" "+stilDeViata+" "+cc+" "+ob+" "+nStres);
	if(s.equals(Constante.barbat)){
		rez+=Constante.intBarbat;
	}else if(s.equals(Constante.femeie)){
		rez+=Constante.intFemeie;
	}
	if(stilDeViata.equals(Constante.sedentar)){
		rez+=Constante.intSedentar;
	}else if(stilDeViata.equals(Constante.semiActiv)){
		rez+=Constante.intSemiActiv;
	}else if(stilDeViata.equals(Constante.activ)){
		rez+=Constante.intActiv;
	}
	if(cc.equals(Constante.ectomorf)){
		rez+=Constante.intEctomorf;
	}else if(cc.equals(Constante.mezomorf)){
		rez+=Constante.intMezomorf;
	}else if(cc.equals(Constante.endomorf)){
		rez+=Constante.intEndomorf;
	}
	if(ob.equals(Constante.slabire)){
		rez+=Constante.intSlabire;
	}else if(ob.equals(Constante.hipertrofie)){
		rez+=Constante.intHipertrofie;
	}
	if(nStres.equals(Constante.lowStress)){
		rez+=Constante.intLowStress;
	}else if(nStres.equals(Constante.midStress)){
		rez+=Constante.intMidStress;
	}else if(nStres.equals(Constante.highStress)){
		rez+=Constante.intHighStress;
	}
	if(aptSport){
		rez=-1;
	}else if(boliCardiace){
		rez=-1;
	}else if(tBoala){
		rez=-1;
	}else if(interventiiChirurgicale){
		rez=-1;
	}
	System.out.println("REZ ESTE "+rez);
	String result=result(rez);
	return result;
}

public static String result(int rez){
	String numePdf = null;
	if(rez==-1){
		numePdf="Nu sunteti apt de sport.";
	}else if(rez==10010513 || rez==20010513){
		numePdf="MenBeginnerBM";
	}else if(rez==10001513 || rez==20001513){
		numePdf="MenBeginnerLW";
	}else if(rez==10010523 || rez==20010523){
		numePdf="MenIntBM";
	}else if(rez==10001523 || rez==20001523){
		numePdf="MenIntLW";
	}else if(rez==10010533 || rez==20001523){
		numePdf="MenAdvBM";
	}else if(rez==10001533 || rez==20001533){
		numePdf="MenAdvLW";
	}
	return numePdf;
	
}
}