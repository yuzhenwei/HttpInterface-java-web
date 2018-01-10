package cn.qlk.test.bean;

import java.io.Serializable;

public class CaseManger implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int caseId;//���
	private String interfaceName; //�ӿ����
	private String interfaceAdress;  //�ӿڵ�ַ
	private String interfaceType;
	private String interfaceParameter; //���
	private String expectResult; //Ԥ�ڽ��
	private String authResult;//ʵ�ʽ��
	private String authStatus; //״̬
	private String interfaceDese; //接口描述
	private String runTime; //耗时
	private String reason;//原因
	private String region;//平台
	private String parameterType;//参数请求类型
	private String depend;//接口依赖
	private int dependStatus;//接口依赖状态
	private String header;
	private int headerStatus;
	
	
	
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getInterfaceAdress() {
		return interfaceAdress;
	}
	public void setInterfaceAdress(String interfaceAdress) {
		this.interfaceAdress = interfaceAdress;
	}
	public String getInterfaceParameter() {
		return interfaceParameter;
	}
	public void setInterfaceParameter(String interfaceParameter) {
		this.interfaceParameter = interfaceParameter;
	}
	public String getExpectResult() {
		return expectResult;
	}
	public void setExpectResult(String expectResult) {
		this.expectResult = expectResult;
	}

	
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	public String getInterfaceDese() {
		return interfaceDese;
	}
	public void setInterfaceDese(String interfaceDese) {
		this.interfaceDese = interfaceDese;
	}
	public String getInterfaceType() {
		return interfaceType;
	}
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public String getAuthResult() {
		return authResult;
	}
	public void setAuthResult(String authResult) {
		this.authResult = authResult;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	public String getParameterType() {
		return parameterType;
	}
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	
	
	public String getDepend() {
		return depend;
	}
	public void setDepend(String depend) {
		this.depend = depend;
	}
	
	
	

	public int getDependStatus() {
		return dependStatus;
	}
	public void setDependStatus(int dependStatus) {
		this.dependStatus = dependStatus;
	}
	
	
	
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	
	}
	
	

	public int getHeaderStatus() {
		return headerStatus;
	}
	public void setHeaderStatus(int headerStatus) {
		this.headerStatus = headerStatus;
	}
	@Override
	public String toString() {
		return "CaseManger [caseId=" + caseId + ", interfaceName=" + interfaceName + ", interfaceAdress="
				+ interfaceAdress + ", interfaceType=" + interfaceType + ", interfaceParameter=" + interfaceParameter
				+ ", expectResult=" + expectResult + ", authResult=" + authResult + ", authStatus=" + authStatus
				+ ", interfaceDese=" + interfaceDese + ", runTime=" + runTime + ", reason=" + reason + "]";
	}
	
	

}
