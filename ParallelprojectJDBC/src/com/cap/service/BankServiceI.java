package com.cap.service;

import java.sql.SQLException;
import java.util.List;

import com.cap.beans.BankBean;

public interface BankServiceI {
	public long createAccount(BankBean bean) throws ClassNotFoundException;

	public int showbalance(long account1, String password1) throws ClassNotFoundException, SQLException;

	public int deposit(long account2, String password2, int dep1);

	public int withdrawl(long account3, String password3, int dep3);

	public String fund(long account31, long account32, String password31, int k1);

	public boolean validation(long account1);

	public List transactionui(long account33);

	public boolean namecheck(String bname1);

	public boolean dobcheck(String bdob1);

	public boolean checkpassword(String bpass1);

	public boolean numbercheck(String bnum2);
}
