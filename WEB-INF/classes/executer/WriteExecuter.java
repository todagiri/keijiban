package executer;
//-----------����import��java�̃N���X-----------
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
//-----------����import�͎���N���X-----------
import bean.Bean;
import bean.ThreadBean;
import bean.CommentBean;
import dba.DBAccessor;
import check.*;

public class WriteExecuter extends Executer{
	
	public Object execute(Object bean){
		accessor.connect();
		
		CommentBean cb = (CommentBean)bean;
		
		//�V���O���N�H�[�g�u��
		cb = ReplaceCheck.check(cb);
		
		String sql = "INSERT INTO KOMMENT( TH_NO, COM_NO, COM_NAME, COM_DATE, COM_TEXT) VALUES(";
		//sql = sql.concat("1, 0, '"+cb.getName()+"', SYSDATE, '"+cb.getText()+"' )");
		
		//Contents�\�ɓ��e���C���T�[�g�BCON_NO�i�R���e���c�̒ʂ��ԍ��j�͂��̃X���b�h�̃R���e���c��+1���i�[�B
		sql = sql.concat(cb.getThreadNo()+", (SELECT th_com_count+1 FROM thread WHERE th_no = "+cb.getThreadNo()+"),'"+cb.getName()+"', SYSDATE, '"+cb.getText()+"')");
	System.out.println ( sql );
	
		accessor.write(sql);

		//Thread�\��TH_CON_COUNT�i���̃X���b�h�̃R���e���c���j��+1���ăA�b�v�f�[�g�B
		sql = "UPDATE thread SET th_com_count = (SELECT th_com_count+1 FROM thread WHERE th_no = "+cb.getThreadNo()+") WHERE th_no = "+cb.getThreadNo();
		accessor.write(sql);
		
		accessor.close();
		
		String str = "�������ݐ���";
		return str;
		
	}
}