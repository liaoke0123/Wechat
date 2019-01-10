package com.wechat.friends.reps;



public class ErrorResult {
	
	private String msg;//业务msg
	private Integer code;//业务code
	private Integer notifyCode;//通知code
	
	public ErrorResult () {
	}
	
	public ErrorResult (String msg) {
		this.msg = msg;
	}
	
	public ErrorResult (String msg, Integer code, Integer notifyCode) {
		this.msg = msg;
		this.code = code;
		this.notifyCode = notifyCode;
	}
	
	public String getMsg () {
		return msg;
	}
	
	public void setMsg (String msg) {
		this.msg = msg;
	}
	
	public Integer getCode () {
		return code;
	}
	
	public void setCode (Integer code) {
		this.code = code;
	}
	
	public Integer getNotifyCode () {
		return notifyCode;
	}
	
	public void setNotifyCode (Integer notifyCode) {
		this.notifyCode = notifyCode;
	}
	
}
