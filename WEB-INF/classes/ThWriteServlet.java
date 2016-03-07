import executer.*;
import bean.*;
import check.*;

import java.util.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThWriteServlet extends HttpServlet{
	
	ThWriteExecuter ThWe=new ThWriteExecuter();
	WriteExecuter cWe =new WriteExecuter();
	ThReadExecuter TRE=new ThReadExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		ThreadBean TB=new ThreadBean();
		CommentBean CB=new CommentBean();
		
		String title=req.getParameter("title");
		String category=req.getParameter("cat");
		String conname=req.getParameter("name");
		String cotext=req.getParameter("text");
		
		if(conname.length()==0){
			conname="–¼–³‚µ";
		}
		
		boolean isError = ByteCheck.check(title,conname,cotext);
		if(isError){
			res.sendRedirect("/keijiban/error.html");
			return;
		}
		
		TB.setTitle(title);
		TB.setCategory(category);
		CB.setName(conname);
		CB.setText(cotext);
		
		ArrayList<CommentBean> AL=new ArrayList<>();
		
		AL.add(CB);
		
		int thc=(int)ThWe.execute(TB);
		
		CB.setThreadNo(thc);
		
		String a="";
		
		ArrayList ArL=new ArrayList();
		
		ArL=(ArrayList)TRE.execute(a);
		
		req.setAttribute("al",ArL);
		RequestDispatcher dispatcher= req.getRequestDispatcher("/threadresult.jsp");
		dispatcher.forward(req,res);
		
	}
}