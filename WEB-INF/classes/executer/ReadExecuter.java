
package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.DBAccessor;
import bean.ThreadBean;
import bean.CommentBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import check.ReplaceCheck;

public class ReadExecuter extends Executer{
	
	public Object execute(Object thNo){
		
		int ThreadNo = (int)thNo;
		
		accessor.connect();
		
		String sql = "SELECT TH_NO,TH_TITLE,TH_CATEGORY,TH_COM_COUNT FROM THREAD WHRER TH_NO = "+ThreadNo;
	
		ThreadBean tb = new ThreadBean();
		try{
			ResultSet rs = accessor.read(sql);
			
			rs.next();
			tb.setThreadNo(rs.getInt(1));
			String Title = rs.getString(2);
			title = ReplaceCheck.check(title);
			tb.setTitle(title);
			tb.setCategory(rs.getString(3));
			tb.setCount(rs.getInt(4));
			
			sql = "SELECT TH_NO,CON_NO,CON_NAME,TO_CHAR(CON_DATE,'YYYY/MM/DD(DY) HH24:MI:SS'),CON_TEXT FROM CONTENTS WHERE TH_NO = "+ThreadNo+" ORDER BY CON_NO";
			rs = accessor.read(sql);
			
			while(rs.next()){
				CommentBean cb = new CommentBean();
				cb.setThreadNo(rs.getInt(1));
				System.out.println(rs.getInt(1));
				cb.setThreadNo(rs.getInt(2));
				System.out.println(rs.getInt(2));
				cb.setThreadNo(rs.getInt(3));
				System.out.println(rs.getInt(3));
				cb.setThreadNo(rs.getInt(4));
				System.out.println(rs.getInt(4));
				cb.setThreadNo(rs.getInt(5));
				System.out.println(rs.getInt(5));
				
				tb.setCommentList(cb);
			}
		}catch(SQLException e){
			System.out.println("ÉGÉâÅ[ÅFSQLException");
		}
		
		accessor.close();
		
		return tb;
	}
}