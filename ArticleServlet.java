package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import licenta.DataParser;
import licenta.Insert;

@WebServlet("/Article")
public class ArticleServlet  extends HttpServlet{
	  /**
		 * @see HttpServlet#HttpServlet()
		 */
		private static final long serialVersionUID = 1L;

		public ArticleServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		
		@Override
		    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(request.getParameter("image")!=null){
				try {
					Insert.insertArticol(DataParser.returnSysdate(), request.getParameter("title"), request.getParameter("content"), request.getParameter("image"), 3, request.getParameter("link"));
					response.sendRedirect(request.getContextPath() + "/Article.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				}
		    }

		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}
