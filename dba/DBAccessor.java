/*
 * タイトル：OracleDataBaseとの通信
 * 説明    ：OracleDataBaseとの接続、SQL文の送信とデータの受け取り、コミット、切断を行う
 *
 * 変更履歴：2016/02/23 Tuesday
 *         ：新規作成
 *
 */

package dba;

// インポート文
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

//OracleDBとの通信に関する処理群です。

public class DBAccessor{
	// DBに接続するためのConnection型のオブジェクト
	private Connection Connect;
	//OracleDBに接続するためのメソッド
	public void connect (){
		try{
			/**
			* 
			* OracleDBからデータを読み込むするためのメソッドです。
			* @param 	ＳＱＬ文 sql(String)
			* @return	表データ
			*/
			// OracleDriverクラスのオブジェクトを生成
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// OracleDBに接続する
				Connect = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","info", "pro");
				System.out.println("接続完了");
				// オートコミット機能をOFFにする
				Connect.setAutoCommit(false);	
			}
		//例外をキャッチする可能性のある処理
			catch(ClassNotFoundException e){
				System.out.println("class:Accessor_method:connect() ClassNotFoundException");
			}
			catch(SQLException e){
				System.out.println("class:Accessor_method:connect() SQLException");
			}
			catch(Exception e){
				System.out.println("class:Accessor_method:connect() Exception");
			}
		}
	
	public ResultSet read(String sql){
		// 表データ read ( ＳＱＬ文 )
		// 例外をキャッチする可能性のある処理
			try{
				
			System.out.println("read");
			
			//PreparedStatement st = Connect.prepareStatement(sql);
			// SQL文をDBに送るためのStatementオブジェクトを生成
			Statement st = Connect.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY*/);
			// SQL文を実行し、ResultSetオブジェクトを生成
			ResultSet rs = st.executeQuery(sql);
			// 生成したデータを返す
			return rs;
		}
		catch(SQLException e){
			System.out.println("class:Accessor_method:read() SQLException");
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:read() Exception");
		}
		// 例外が発生した場合、nullを返す
		return null;
	}
	
	//OracleDBにデータを書き込むするためのメソッドです。
public void write (String sql){
		try{ 
			// SQL文をDBに送るためのStatementオブジェクトを生成
			Statement st = Connect.createStatement();
			System.out.println(sql);
			// SQL文を実行
			st.executeUpdate(sql);
			// 結果をコミット
			commit();
		}
		//例外をキャッチする可能性のある処理
		catch(SQLException e){
			System.out.println("class:Accessor_method:write() SQLException");
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:write() Exception");
		}
	}
		/**
	* OracleDBにデータを書き込むするためのメソッドです。
	*
	* @param 	ＳＱＬ文 sql(String)
	* @return	void
	*/
		
	public void commit (){
		try{
			// 例外をキャッチする可能性のある処理→コミット
			Connect.commit();
		}
		catch(SQLException e){}
		catch(Exception e){}
	}
	
	//OracleDBを切断するためのメソッドです。
	public void close (){
		try{
		    //例外をキャッチする可能性のある処理→クローズ
			Connect.close();
		}
		catch(SQLException e){}
		catch(Exception e){}
}

}	

		
// -EOF-