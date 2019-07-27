package com.cap.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import com.cap.beans.BankBean;
import com.cap.dao.BankDao;
import com.cap.beans.TransBean;

public class BankService implements BankServiceI

{
	BankDao d=new BankDao();
	
	public long createAccount(BankBean bean) throws ClassNotFoundException
	{
		long accNo=d.createAccount1(bean);
		return accNo;
	}
	
	public int showbalance(long account1,String password1) throws ClassNotFoundException, SQLException
	{
		int bal= d.showbalace1(account1,password1);
		return bal;
	}
	
	public int deposit(long account2,String password2,int dep1)
	{
		int d1=d.deposit1(account2,password2,dep1);
		return d1;
	}

	public int withdrawl(long account3, String password3, int dep3) {
		// TODO Auto-generated method stub
		int d3=d.withdrawl1(account3,password3,dep3);
		return d3;
	}

	public String fund(long account31, long account32, String password31, int k1) 
	{
		// TODO Auto-generated method stub
		String d11=d.fund1(account31,account32,password31,k1);
		return d11;
	}

	
	
	public boolean validation(long account1) {     
		// TODO Auto-generated method stub
		boolean d11 = d.validation(account1);
		return d11;
	}

	public List transactionui(long account33) 
	{
		// TODO Auto-generated method stub
		List trans1=d.transaction(account33);
		return trans1;
	}

	
	
	//check mobile  number
		 public boolean numbercheck(String bnum2)
		{
			// TODO Auto-generated method stub
			
			if((bnum2.length())==10 && bnum2.matches("[6-9][0-9]{9}"))
					{
						
						return true;
					}else
					{
						return false;
						
					}
				
		}

	
		 
		 public boolean checkpassword(String bpass1) 
			{
				// TODO Auto-generated method stub
				
				if(bpass1.length()<8)
				{
					return false;
					
				}else
				{
					return true;
				}
				
			}
		 
		//check date of birth
			public boolean dobcheck(String bdob1)
			{
				// TODO Auto-generated method stub
				
				if(bdob1.length()==8 && bdob1.matches("[0-9]*" ))
					{
					return true;
					}else
					{
					return false;
					
					}	
				
			}
			
	 public boolean namecheck(String bname1)
		{
			
			if(Pattern.matches("[A-Z][A-Za-z( )(.)]*", bname1))
			{
				System.out.println("truecheck");
				return true;
			} else
			{
				System.out.println("false check");
				return false;	
			}
	}
		
}


		
	
	 

