package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import licenta.IMC;
import licenta.Insert;
import licenta.Pdf;
import licenta.Select;
import views.Anamneza;
import views.Antrenament;
import views.IstoricMedical;
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
			
			Boolean aptSport=Boolean.valueOf(aSport);
			Boolean boliCardiace=Boolean.valueOf(bCardiace);
			Boolean terapieBoala=Boolean.valueOf(tBoala);
			Boolean iChirurgicale=Boolean.valueOf(iChirurgicala);
			
			System.out.println(aSport +" "+bCardiace+" "+tBoala+" "+iChirurgicala);
			
			int id_planAlim =1;
			
			Utilizator util = Select.selectUtilizatorForProfile(email, password);
			Anamneza anam = Select.selectAnamnezaForProfile(util.getId_utilizator());
			Antrenament antre = Select.selectAntrenamentForProfile(Pdf.register(sex, stilViata, somatic, obiectiv, nivelStres, aptSport, boliCardiace, terapieBoala, iChirurgicale));
			IstoricMedical istMed = Select.selectIstoricMedicalForProfile(anam.getId_anamneza());
			Select.selectLogin(util.getEmail(), util.getParola());	
			
			Insert.insertUser(email, password, fName, lName, 1, 1, id_planAlim);
			Insert.insertAnamneza(sex, Integer.parseInt(greutate), stilViata, nivelStres, somatic, obiectiv, Integer.parseInt(inaltime),IMC.indiceMasaCorporala(Integer.parseInt(greutate), Integer.parseInt(inaltime)), Select.selectLastIdUtilizator(), Select.selectLastIdIstoricMedical());
			Insert.insertIstMedical(aSport,bCardiace,tBoala,iChirurgicala);
		
			System.out.println("CODUL ANTRENAMENTULUI ESTE " +antre.getContinut());
			System.out.println("NUMELE ANTRENAMENTULUI ESTE " +antre.getNumeAntrenament());
			request.setAttribute("util",util);
			request.setAttribute("anam",anam);
			request.setAttribute("istMed",istMed);
			request.setAttribute("antre",antre.getNumeAntrenament());
			
			
			HttpSession session = request.getSession();
			session.setAttribute("log", util.getEmail());
			session.setAttribute("pass", util.getParola());

		
			//request.setAttribute("imc", anam.getImc());
			request.getRequestDispatcher("profile.jsp").forward(request, response);
			
			
		}	    	
}
