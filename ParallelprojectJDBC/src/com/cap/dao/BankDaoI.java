package com.cap.dao;

import java.sql.SQLException;
import java.util.List;

import com.cap.beans.BankBean;

public interface BankDaoI {

	public long createAccount1(BankBean bean) throws ClassNotFoundException;

	public int showbalace1(long account1, String password1) throws ClassNotFoundException, SQLException;

	public int deposit1(long account2, String password2, int dep1);

	public int withdrawl1(long account3, String password3, int dep3);

	public String fund1(long account31, long account32, String password31, int k1);

	public void checkfund(int a1, int k1);

	public boolean validation(long account1);

	public List transaction(long account33);

}
