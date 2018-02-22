package com.sync.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_INFO")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "USERID")
	 private Integer uId;
	 
	 @Column(name="UNAME")
	 private String uName;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}
	 
	 

}
