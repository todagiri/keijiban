import executer.*;
import bean.*;
import check.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommWriteServlet extends HttpServlet{
	
	WriteExecuter We=new WriteExecuter();
	
	/*int		cTn 	=(0);//checkThreadNo
		int		cCn		=(0);//checkCommentNo*/
		String	cN	=("");//checkName
		String	cTe	=("");//checkText
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		CommentBean CB=new CommentBean();
		
		int threadNo = Integer.parseInt( req.getParameter("threadNo") );
		int CommentNo = Integer.parseInt( req.getParameter("commentNo") );
		String name=req.getParameter("name");
		String text=req.getParameter("text");
		
		
		
		if(name.length()==0){
			name="名無し";
		}
		/*if(cTn.equals(threadNo)){
            res.sendRedirect("/kb/error.html");
			return;
        }
		if(cCn.equals(CommentNo)){
            res.sendRedirect("/kb/error.html");
			return;
        }*/
		if(cN.equals(name)){
            res.sendRedirect("/kb/error.html");
			return;
        }
		if(cTe.equals(text)){
            res.sendRedirect("/kb/error.html");
			return;
        }
		
		//バイト数を超えていないかのチェック-----------
		boolean isError = ByteCheck.check(name,text);
		if(isError){
			res.sendRedirect("/kb/error.html");
			return;
		}
		//--------------------------------------------
		
		
		CB.setThreadNo(threadNo);
		CB.setCommentNo(CommentNo);
		CB.setName(name);
		CB.setText(text);
		
		
		cN	=(name);//checkName
		cTe	=(text);//checkText
		
		
		We.execute(CB);
		
		//書き込んだスレッドを表示----------------------------------------------------
		ReadExecuter RE=new ReadExecuter();
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/comment.jsp");
		dispatcher.forward(req,res);
		//-----------------------------------------------------------------------------
		
	}
}