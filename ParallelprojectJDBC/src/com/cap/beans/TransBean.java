package com.cap.beans;

import java.sql.Timestamp;

public class TransBean
{
	
	private int transId;
	private long baccFinal;
	private String transMetd;
	private int transBal;
	private Timestamp transdate;
	private long tid1;
	
	
	
	public TransBean() {
		super();
		this.transId = transId;
		this.baccFinal = baccFinal;
		this.transMetd = transMetd;
		this.transBal = transBal;
		this.transdate = transdate;
		this.tid1=tid1;
	}


	@Override
	public String toString() {
		return "\n Transaction ::\n Account final Balance =" + transId + "\n Account number = " + baccFinal + "\n Mode of transaction =" + transMetd + "\n Amount transfered = "
				+ transBal + "\n  Date =" + transdate +"\n Transaction Id ="+tid1+ "\n";
	}

	public long gettid1() {
		return tid1;
	}


	public void settid1(long tid1) {
		this.tid1=tid1;
	}
	
	public int getTransId() {
		return transId;
	}



	public void setTransId(int transId) {
		this.transId = transId;
	}



	public long getBaccFinal() {
		return baccFinal;
	}



	public void setBaccFinal(long baccFinal) {
		this.baccFinal = baccFinal;
	}



	public String getTransMetd() {
		return transMetd;
	}



	public void setTransMetd(String transMetd) {
		this.transMetd = transMetd;
	}



	public int getTransBal() {
		return transBal;
	}



	public void setTransBal(int transBal) {
		this.transBal = transBal;
	}



	public Timestamp getTransdate() {
		return transdate;
	}



	public void setTransdate(Timestamp transdate) {
		this.transdate = transdate;
	}



}