package cn.qlk.test.bean;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 用户
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String passWord;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	

}
