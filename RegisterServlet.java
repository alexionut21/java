package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import licenta.IMC;
import licenta.Insert;
import licenta.Select;
import views.Anamneza;
import views.Utilizator;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public RegisterServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		
		@Override
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String fName=request.getParameter("fName");
			String lName=request.getParameter("lName");
			String bDate=request.getParameter("bDate");
			
			String inaltime=request.getParameter("height");
			String greutate=request.getParameter("weight");
			
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String password=request.getParameter("password");
			
			String sex=request.getParameter("gender");
			System.out.println(sex);
			String somatic=request.getParameter("somatic");
			System.out.println(somatic);		
			String nivelStres=request.getParameter("options");
			System.out.println(nivelStres);			
			String stilViata=request.getParameter("lifestyle");
			System.out.println(stilViata);
			String obiectiv=request.getParameter("objective");
			System.out.println(obiectiv);
			
			String aSport=request.getParameter("q1");
			String bCardiace=request.getParameter("q2");
			String tBoala=request.getParameter("q3");
			String iChirurgicala=request.getParameter("q4");
			System.out.println(aSport +" "+bCardiace+" "+tBoala+" "+iChirurgicala);
			
			int id_anamneza = 1;
			int id_antrenament =1;
			int id_planAlim =1;
			Insert.insertUser(email, password, fName, lName, id_anamneza, id_antrenament, id_planAlim);
			Insert.insertAnamneza(sex, Integer.parseInt(greutate), stilViata, nivelStres, somatic, obiectiv, Integer.parseInt(inaltime),IMC.indiceMasaCorporala(Integer.parseInt(greutate), Integer.parseInt(inaltime)), Select.selectLastIdUtilizator(), Select.selectLastIdIstoricMedical());
			
			Utilizator util = Select.selectUtilizatorForProfile(email, password);
			request.setAttribute("nume", util.getNume());
			request.setAttribute("prenume", util.getPrenume());
			Anamneza anam = Select.selectAnamnezaForProfile(util.getId_utilizator());
			 greutate = "" + anam.getGreutate();
			 inaltime = "" + anam.getInaltime();
			 System.out.println(inaltime);
			request.setAttribute("sex", anam.getSex());
			request.setAttribute("greutate", greutate);
			request.setAttribute("stilViata", anam.getStil_viata());
			request.setAttribute("nivelStres", anam.getNivel_stres());
			request.setAttribute("tipSomatic", anam.getTip_somatic());
			request.setAttribute("obiectiv", anam.getObiectiv());
			request.setAttribute("inaltime", inaltime);
			//request.setAttribute("imc", anam.getImc());
			request.getRequestDispatcher("profile.jsp").forward(request, response);
			
			
		}	    	
}
