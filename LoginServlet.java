package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import licenta.Select;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	  /**
		 * @see HttpServlet#HttpServlet()
		 */
		private static final long serialVersionUID = 1L;

		public LoginServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		System.out.println(email);
		System.out.println(pass);
			if(email!=null && pass!=null && Select.selectLogin(email, pass)==true){					
			Select.selectLogin(email, pass);
			
			HttpSession session = request.getSession();
			session.setAttribute("log", email);
			session.setAttribute("pass", pass);
			System.out.println(request.getAttribute("log"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				request.setAttribute("msg","Email or passowrd wrong!");
				System.out.println(request.getAttribute("msg"));
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}			
	    }
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
