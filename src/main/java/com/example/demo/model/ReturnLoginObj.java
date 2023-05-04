package com.example.demo.model;

public class ReturnLoginObj {

	int status;
	String errortMessage;
	String jwtToken;
	
	@Override
	public String toString() {
		return "ReturnLoginObject [status=" + status + ", errortMessage=" + errortMessage + ", jwtToken=" + jwtToken
				+ "]";
	}
	public ReturnLoginObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnLoginObj(int status, String errortMessage, String jwtToken) {
		super();
		this.status = status;
		this.errortMessage = errortMessage;
		this.jwtToken = jwtToken;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrortMessage() {
		return errortMessage;
	}
	public void setErrortMessage(String errortMessage) {
		this.errortMessage = errortMessage;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
}
