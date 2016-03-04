package executer;

import check.*;

import java.util.ArrayList;
import bean.Bean;
import dba.DBAccessor;
import bean.ThreadBean;
import bean.CommentBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThWriteExecuter extends Executer{
	
	public Object execute(Object bean){
		accessor.connect();
		
		int ThCount=0;

		String sql = "SELECT MAX( TH_NO ) FROM THREAD";
		
		try{
			ResultSet rs = accessor.read(sql);
			
			rs.next();
			ThCount = rs.getInt(1)+1;
		}
		catch(SQLException e){
			System.out.println("すれたて：SQLException");
		}
		
		ThreadBean tb = (ThreadBean)bean;
		
		tb = ReplaceCheck.check(tb);
		
		sql = "INSERT INTO Thread( TH_NO, TH_TITLE, TH_CATEGORY, TH_CON_COUNT) VALUES(";
		//sql = sql.concat("1, "スレッドのタイトル", '"+cb.getName()+"', SYSDATE, '"+cb.getText()+"' )");
		
		//Thread表に投稿をインサート。
		sql = sql.concat(ThCount+",'"+tb.getTitle()+"','"+tb.getCategory()+"','"+0+"')");
		accessor.write(sql);
	
		accessor.close();
		
		return ThCount;/*&Y*/
		
	}
}