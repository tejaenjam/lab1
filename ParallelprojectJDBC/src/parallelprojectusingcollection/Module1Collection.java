package parallelprojectusingcollection;

import java.util.HashMap;
import java.util.Scanner;

class Method1 {
	private long mobile;
	private String name;
	private String dob;
	private String password;
	private int balance;
	private long account;
	

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public Method1(long mobile, String name, String dob, String password, int balance) {
		// TODO Auto-generated constructor stub
		this.mobile = mobile;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Method1 [mobile=" + mobile + ", name=" + name + ", dob=" + dob + ", password=" + password + ", balance="
				+ balance + "]";
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;

	}
	

	public boolean getPassword(String password1) {
		// TODO Auto-generated method stub
		if ((password1).equals(password)) {
			return true;
		}
		return false;
	}

} 

public class Module1Collection
{
	
public static void main(String[] args) 
	{
		
	
		HashMap<Long,Method1> hm  = new HashMap<Long,Method1>();
		
		while (1 != 0) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.create 2.balance  3.deposit  4.withdraw  5.fund transfer  6.print transaction ");
			int a1 = sc.nextInt();
			 

			switch (a1) {
			case 1:
				System.out.println("enter your 10 digit mobile number");
				long mobile = sc.nextLong();

				System.out.println("enter your name");
				String name = sc.next();
				
				System.out.println("enter date of birth  :DD:MM:YYYY");
				String dob = sc.next();

				System.out.println("enter new password ");
				String password = sc.next();

				System.out.println("default balance is 100");
				int balance = 100;

				long account = mobile + 2431;
				 Method1 m1 =new Method1(mobile, name, dob, password, balance);
				
				 hm.put(account, m1);

				System.out.println("account is created and number is :" + account);
				System.out.println("account details are");
				System.out.println(hm);
				break;

			case 2:
			
				System.out.println("enter Account number");
				long account1 = sc.nextLong();
			
				Method1 ac1 = (Method1) hm.get(account1);
				if (hm.containsKey(account1)) {
					System.out.println("enter password");
					String password1 = sc.next();
					
					if (ac1.getPassword(password1)) {
						System.out.println(ac1.getBalance());
						//ac1.transaction(ac1.getBalance(),a1);
						
						
					}
				}
				break;

			case 3:
				System.out.println("enter your account number");
				long account2 = sc.nextLong();
				Method1 ac2 = (Method1) hm.get(account2);
				if (hm.containsKey(account2)) {
					System.out.println("enter password");
					String password1 = sc.next();
					if (ac2.getPassword(password1)) {
						System.out.println("enter amount to be deposit");
						int dp1 = sc.nextInt();
						int s11 = ac2.getBalance() + dp1;
						ac2.setBalance(s11);
						System.out.println("balance after deposit");
						System.out.println(ac2.getBalance());
						
					}

				}
				break;

			case 4:
				System.out.println("enter your account number");
				long account3 = sc.nextLong();
				Method1 ac3 = (Method1) hm.get(account3);
				if (hm.containsKey(account3)) {
					System.out.println("enter password");
					String password1 = sc.next();
					if (ac3.getPassword(password1)) {
						System.out.println("enter amount to be withdrawl");
						int dp1 = sc.nextInt();
						int s11 = ac3.getBalance() - dp1;
						ac3.setBalance(s11);
						System.out.println("balance after withdrawl");
						System.out.println(ac3.getBalance());
						
					}
				}
				break;

			case 5:
					System.out.println("enter account number 1 to transfer");
					long account4 = sc.nextLong();
					System.out.println("enter account number 2 to receive");
					long account5 = sc.nextLong();
					Method1 ac4 = (Method1) hm.get(account4);
					Method1 ac5 = (Method1) hm.get(account5);
					if (hm.containsKey(account4) && hm.containsKey(account5)) 
					{
						System.out.println("enter account 1 password");
						String password1 = sc.next();
						System.out.println("enter account 2 password");
						String password2 = sc.next();
						if (ac4.getPassword(password1) && ac5.getPassword(password2)) 
						{
							System.out.println("enter fund amount from account 1 to account 2");
							int fd = sc.nextInt();
							int a11 = ac4.getBalance() - fd;
							int a12 = ac5.getBalance() + fd;
							ac4.setBalance(a11);
							
							ac5.setBalance(a12);
							
							System.out.println("balance account 1 after giving fund :" + ac4.getBalance());
							System.out.println("balance account 2 after receiving fund  :" + ac5.getBalance());
							
							
						}
					}
					break;
			case 6: 
	
				}

			}

	}
}

	


