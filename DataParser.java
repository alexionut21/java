package licenta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;





public class DataParser {
	   public static void main(String[] args) throws ParseException{
		  Date date = new Date();
		   System.out.println(date.toString());		   
		   System.out.println(returnDay(date));
		   System.out.println(returnMonth(date));		  
		   System.out.println(returnYear(date));
		   System.out.println(returnSysdate());
		   System.out.println(returnDate(date));
		   System.out.println(returnSysday());

	   }
	   public static String returnDay(Date date){
		   return(new SimpleDateFormat("dd").format(date));
	   }
	   public static String returnMonth(Date date){
		   return(new SimpleDateFormat("MMM").format(date));
	   }
	   public static String returnYear(Date date){
		   return(new SimpleDateFormat("yyyy").format(date));
	   }
	   public static String returnSysdate(){	
		   Date date = new Date();	
		   SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		  return sdf.format(date);
	   }
	   public static String returnDate(Date date){	
		   SimpleDateFormat sdf =new SimpleDateFormat("dd-MMM-yyyy");
		  return sdf.format(date);
	   }
	   public static String returnSysday(){	
		   Date date = new Date();
		   SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
		   String dayOfWeek = dateFormat.format(date);
		   return(dayOfWeek);
	   }
}
