package com.sync.bean;

public class UserBean {
private String uName;
private Integer uId;

public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public Integer getuId() {
	return uId;
}
public void setuId(Integer uId) {
	this.uId = uId;
}
@Override
public String toString() {
	return "UserBean [uName=" + uName + ", uId=" + uId + "]";
}











}
