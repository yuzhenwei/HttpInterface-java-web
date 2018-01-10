package cn.qlk.test.bean;

import java.io.Serializable;

public class HeaderManger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String headerName;
	private String headerContent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public String getHeaderContent() {
		return headerContent;
	}
	public void setHeaderContent(String headerContent) {
		this.headerContent = headerContent;
	}
	
	
}
