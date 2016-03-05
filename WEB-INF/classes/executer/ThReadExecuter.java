package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.DBAccessor;
import bean.ThreadBean;
//import bean.ContentsBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import check.*;

public class ThReadExecuter extends Executer{
	
	public Object execute(Object s){
	
		String str = (String)s;
		
		accessor.connect();
		
		ThreadBean _tb = new ThreadBean();
		
		String sql = "SELECT * FROM THREAD ORDER BY TH_NO DESC";
		try{
			ResultSet rs = accessor.read(sql);
			
			while(rs.next()){
			
				ThreadBean tb = new ThreadBean();
				
				tb.setThreadNo(rs.getInt(1));
				System.out.println(rs.getInt(1));
				tb.setTitle(rs.getString(2));
				System.out.println(rs.getString(2));
				tb.setCategory(rs.getString(3));
				System.out.println(rs.getString(3));
				tb.setCount(rs.getInt(4));
				System.out.println(rs.getInt(4));
				
				_tb.setThreadList(tb);
			}
		}catch(SQLException e){
			System.out.println("ÉGÉâÅ[:Exception");
		}
			accessor.close();
			
			return _tb.getThreadList();
	}
}