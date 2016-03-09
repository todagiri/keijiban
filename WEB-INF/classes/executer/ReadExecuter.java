
package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.DBAccessor;
import bean.ThreadBean;
import bean.CommentBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import check.ReplaceCheck;
import java.util.Date;

public class ReadExecuter extends Executer{
	
	public Object execute(Object thNo){
		
		int ThreadNo = (int)thNo;
		
		accessor.connect();
		
		String sql = "SELECT TH_NO,TH_TITLE,TH_CATEGORY,TH_COM_COUNT FROM Thread WHERE TH_NO = "+ThreadNo;
	
		ThreadBean tb = new ThreadBean();
		try{
			ResultSet rs = accessor.read(sql);
			
			rs.next();
			tb.setThreadNo(rs.getInt(1));
			String Title = rs.getString(2);
			Title = ReplaceCheck.check(Title);
			tb.setTitle(Title);
			tb.setCategory(rs.getString(3));
			tb.setCount(rs.getInt(4));
			
			sql = "SELECT TH_NO,COM_NO,COM_NAME,TO_CHAR(COM_DATE,'YYYY/MM/DD(DY) HH24:MI:SS'),COM_TEXT FROM KOMMENT WHERE TH_NO = "+ThreadNo+" ORDER BY COM_NO";
			rs = accessor.read(sql);
			
			while(rs.next()){

				CommentBean cb = new CommentBean();
				cb.setThreadNo(rs.getInt(1));
				System.out.println(rs.getInt(1));
				cb.setCommentNo(rs.getInt(2));
				System.out.println(rs.getInt(2));
				cb.setName(rs.getString(3));
				System.out.println(rs.getString(3));

				cb.setDate ( rs.getString(4) );
				cb.setText (rs.getString(5) );
				System.out.println(rs.getString(5));
				
				tb.setCommentList(cb);
			}
		}catch(SQLException e){
			System.out.println("ÉGÉâÅ[ÅFSQLException:readexecuter");
		}
		
		accessor.close();
		
		return tb;
	}
}