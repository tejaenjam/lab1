package com.cap.beans;

import java.io.Serializable;

public class BankBean implements Serializable {
	private String bname;
	private String bnum2;
	private String bdob;
	private String bpass;
	private int bbal;
	private long bacc;
	private String actype;
	private String location;

	public BankBean(String bname, String bnum2, String bdob, String bpass, int bbal, long bacc,String location,String actype) {
		super();
		this.bname = bname;
		this.bnum2 = bnum2;
		this.bdob = bdob;
		this.bpass = bpass;
		this.bbal = bbal;
		this.bacc = bacc;
		this.location=location;
		this.actype=actype;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBnum() {
		return bnum2;
	}

	public void setBnum(String bnum) {
		this.bnum2 = bnum2;
	}

	public String getBdob() {
		return bdob;
	}

	public void setBdob(String bdob) {
		this.bdob = bdob;
	}

	public String getBpass() {
		return bpass;
	}

	public void setBpass(String bpass) {
		this.bpass = bpass;
	}

	public int getBbal() {
		return bbal;
	}

	public void setBbal(int bbal) {
		this.bbal = bbal;
	}

	public long getBacc() {
		return bacc;
	}

	public void setBacc(long bacc) {
		this.bacc = bacc;
	}

	public String getActype() {
		return actype;
	}

	public void setActype(String actype) {
		this.actype = actype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return " \n Username =  " + bname + "\n Phone Number =  " + bnum2 + " \n Date Of Birth =  " + bdob + " \n Password  =  " + bpass + " \n Balance  =  " + bbal
				+ " \n Account Number  =  " + bacc + "\n  Account Type = " + actype + "\n Branch  = " + location + "\n";
	}

	

	
}
