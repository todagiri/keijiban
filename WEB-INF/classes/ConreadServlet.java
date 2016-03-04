import executer.*;

import bean.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConReadServlet extends HttpServlet{
	ReadExecuter RE = new ReadExecuter();
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		int ThreadNo = Integer.parseInt(req.getParameter("thread"));
		
		CommentBean CB = new CommentBean();
		
		ThreadBean tb = (ThreadBean) RE.execute(ThreadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/comment.jsp");
		dispatcher.forward(req,res);
	}
}