package bean;

import java.util.ArrayList;
	
public class ThreadBean implements Bean{
	
	private int threadNo;
	private String title;
	private String category;
	private int commentCount;
	
	private ArrayList<CommentBean> commentList = new ArrayList<CommentBean>();
	private ArrayList<ThreadBean> threadList = new ArrayList<ThreadBean>();


//setter

	//スレッド番号
	public void setThreadNo(int threadNo){
		this.threadNo = threadNo;
	}
	//スレッドタイトル
	public void setTitle(String title){
		this.title = title;
	}
	//カテゴリー
	public void setCategory(String category){
		this.category = category;
	}
	//投稿数
	public void setCount(int commentCount){
		this.commentCount = commentCount;
	}
	//スレッドの全件データをArrayListにセット
	public void setCommentList(CommentBean list){
		commentList.add(list);
	}
	//スレッド一覧をArrayListにセット
	public void setThreadList(ThreadBean list){
		threadList.add(list);
	}

//getter

	//スレッド番号
	public int getThreadNo(){
		return threadNo;
	}
	//スレッドタイトル
	public String getTitle(){
		return title;
	}
	//カテゴリー
	public String getCategory(){
		return category;
	}
	//投稿数
	public int getCommentCount(){
		return commentCount;
	}
	//スレッドの全件データを返す
	public ArrayList getCommentList(){
		return commentList;
	}
	//スレッド一覧を返す
	public ArrayList getThreadList(){
		return threadList;
	}
	
}

