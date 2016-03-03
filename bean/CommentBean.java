package bean;

public class CommentBean implements Bean{
	
	private int threadNo;
	private int commentNo;
	private String name;
	private String date;
	private String text;
	
	
//setter
	
	//スレッド番号
	public void setThreadNo(int threadNo){
		this.threadNo = threadNo;
	}
	//コメント番号
	public void setCommentNo(int commentNo){
		this.commentNo = commentNo;
	}
	//投稿者名
	public void setName(String name){
		this.name = name;
	}
	//投稿日時
	public void setDate(String date){
		this.date = date;
	}
	//投稿内容
	public void setText(String text){
		this.text = text;
	}


//getter

	//スレッド番号
	public int getThreadNo(){
		return threadNo;
	}
	//コメント番号
	public int getCommentNo(){
		return commentNo;
	}
	//投稿者名
	public String getName(){
		return name;
	}
	//投稿日時
	public String getDate(){
		return date;
	}
	//投稿内容
	public String getText(){
		return text;
	}

}