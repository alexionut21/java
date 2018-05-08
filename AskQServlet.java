package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import licenta.DataParser;
import licenta.Insert;

@WebServlet("/AskQ")
public class AskQServlet extends HttpServlet{
	  /**
	 * @see HttpServlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;

	public AskQServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String question = request.getParameter("question");
		  System.out.println("DQWEQWDRQW");
		  	if(request.getParameter("question")!=null){
			Insert.insertComment(DataParser.returnSysdate(), question,3);
		}		 
		  	if(request.getParameter("comment")!=null){
			Insert.insertComment(DataParser.returnSysdate(), request.getParameter("comment"),3);
		}
		  System.out.println("Servlet " + question);
		 // request.getRequestDispatcher("/AskQ.jsp").forward(request, response);
		  response.sendRedirect(request.getContextPath() + "/AskQ.jsp");
	    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
