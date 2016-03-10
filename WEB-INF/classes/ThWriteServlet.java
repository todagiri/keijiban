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
	WriteExecuter We =new WriteExecuter();
	ThReadExecuter TRE=new ThReadExecuter();
	
	String cTi 	=("");//checkTitle
	String cC		=("");//checkCat
	String cN	=("");//checkName
	String cTe	=("");//checkText
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		ThreadBean TB=new ThreadBean();
		CommentBean CB=new CommentBean();
		
		String title=req.getParameter("title");
		String category=req.getParameter("cat");
		String comname=req.getParameter("name");
		String comtext=req.getParameter("text");
		
		
		
		if(comname.length()==0){
			comname="名無し";
		}
		if(title.length()==0 || title == null){
			title="名無しのスレッド";
		}
		if(cTi.equals(title)){
            res.sendRedirect("/kb/threaderror.html");
			return;
        }
		if(cC.equals(category)){
            res.sendRedirect("/kb/threaderror.html");
			return;
        }
		if(cN.equals(comname)){
            res.sendRedirect("/kb/threaderror.html");
			return;
        }
		if(cTe.equals(comtext)){
            res.sendRedirect("/kb/threaderror.html");
			return;
        }
		
		
		boolean isError = ByteCheck.check(title,comname,comtext);
		if(isError){
			res.sendRedirect("/kb/threaderror.html");
			return;
		}
		
		TB.setTitle(title);
		TB.setCategory(category);
		CB.setName(comname);
		CB.setText(comtext);
		
		ArrayList<CommentBean> AL=new ArrayList<>();
		
		AL.add(CB);
		
		int thc=(int)ThWe.execute(TB);
		
		CB.setThreadNo(thc);
		
		We.execute ( CB );
		
		String a="";
		
		ArrayList ArL=new ArrayList();
		
		ArL=(ArrayList)TRE.execute(a);
		
		
		cTi	=(title);//checkTitle
		cC	=(category);//checkCat
		cN	=(comname);//checkName
		cTe	=(comtext);//checkText
		
		System.out.println("これがタイトルだ！！！"+title);
		req.setAttribute("al",ArL);
		RequestDispatcher dispatcher= req.getRequestDispatcher("/threadresult.jsp");
		dispatcher.forward(req,res);
		
	}
}