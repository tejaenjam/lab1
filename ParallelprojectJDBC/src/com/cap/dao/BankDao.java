package com.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cap.beans.BankBean;
import com.cap.beans.TransBean;

public class BankDao implements BankDaoI {

	PreparedStatement ps = null;
	Connection conn = null;

	long tid = (long) (Math.random() * 965874546);
	private HashMap<Long, BankBean> hm;

	private ArrayList listkey;
	long bacc;
	int dep2;
	int dep4;
	int q1, q2, inibal;
	long balance;
	long bal1;

	public BankDao() {
		hm = new HashMap<Long, BankBean>();
	}

	public long createAccount1(BankBean bean) throws ClassNotFoundException {
		String namd = bean.getBname();
		String numberd = bean.getBnum();
		String dbobd = bean.getBdob();
		String bpassd = bean.getBpass();
		int bbald = bean.getBbal();
		long baccd = bean.getBacc();
		String actyped = bean.getActype();
		String locationd = bean.getLocation();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "qwerty", "qwerty123");
			ps = conn.prepareStatement("insert into bank values(?,?,?,?,?,?,?,?)");
			ps.setString(1, namd);
			ps.setString(2, numberd);
			ps.setString(3, dbobd);
			ps.setString(4, bpassd);
			ps.setInt(5, bbald);
			ps.setLong(6, baccd);
			ps.setString(7, actyped);
			ps.setString(8, locationd);
			int sa = ps.executeUpdate();
			if (sa > 0) {
				return baccd;
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public int showbalace1(long account1, String password1) throws ClassNotFoundException, SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "qwerty", "qwerty123");
			ps = conn.prepareStatement("select cbal from bank where caccnum = ? and cpassword=?");

			ps.setLong(1, account1);
			ps.setString(2, password1);

			ResultSet rs = ps.executeQuery();
			rs.next();
			int bal = rs.getInt("cbal");
			return bal;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
			return 0;
		}

	}

	public int deposit1(long account2, String password2, int dep1) {
		int a12;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "qwerty", "qwerty123");
			ps = conn.prepareStatement("select cbal from bank where caccnum=? and cpassword=?");
			ps.setLong(1, account2);
			ps.setString(2, password2);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bal1 = rs.getInt("cbal");
			a12 = bal1 + dep1;
			System.out.println("ara " + a12);
			ps = conn.prepareStatement("update  bank set cbal= ? where caccnum=?");
			ps.setInt(1, a12);
			ps.setLong(2, account2);
			int sa = ps.executeUpdate();
			ps = conn.prepareStatement("insert into transaction values (?,?,?,?,?,?)");
			ps.setInt(1, a12);
			ps.setString(2, "Deposit");
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setInt(4, dep1);
			ps.setLong(5, account2);
			ps.setLong(6, tid);
			ps.executeUpdate();
			if (sa > 0) {
				return a12;
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
			return 0;
		}
		return 0;
	}

	public int withdrawl1(long account3, String password3, int dep3) {
		try {
			++tid;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "qwerty", "qwerty123");

			ps = conn.prepareStatement("select cbal from bank where caccnum=? and cpassword=?");
			//

			ps.setLong(1, account3);
			ps.setString(2, password3);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bal1 = rs.getInt("cbal");

			int a12 = bal1 - dep3;
			System.out.println("as " + a12);
			ps = conn.prepareStatement("update  bank set cbal=? where caccnum=?");
			ps.setInt(1, a12);
			ps.setLong(2, account3);
			int sa = ps.executeUpdate();

			ps = conn.prepareStatement("insert into transaction values(?,?,?,?,?,?)");
			ps.setInt(1, a12);
			ps.setString(2, "with draw");
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setInt(4, dep3);
			ps.setLong(5, account3);
			ps.setLong(6, tid);
			int a112 = ps.executeUpdate();
			if (sa > 0) {
				return a12;
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
			return 0;
		}
		return 0;

	}

	public String fund1(long account31, long account32, String password31, int k1) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "qwerty", "qwerty123");

			ps = conn.prepareStatement("select cbal from bank where caccnum=? and cpassword=?");
			ps.setLong(1, account31);
			ps.setString(2, password31);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int bal1 = rs.getInt("cbal");
			int a12 = bal1 - k1;
			System.out.println("Account number :" + account31 + " : balance" + a12);
			ps = conn.prepareStatement("update  bank set cbal=? where caccnum=?");
			ps.setInt(1, a12);
			ps.setLong(2, account31);
			ps.executeUpdate();
			ps = conn.prepareStatement("insert into transaction values(?,?,?,?,?,?)");
			ps.setInt(1, a12);
			ps.setString(2, "funds transfer 1");
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setInt(4, k1);
			ps.setLong(5, account31);
			ps.setLong(6, tid);
			ps.executeUpdate();
			ps = conn.prepareStatement("select cbal from bank where caccnum=? ");
			ps.setLong(1, account32);
			ResultSet rs1 = ps.executeQuery();
			rs1.next();
			int bal11 = rs1.getInt("cbal");
			int a121 = bal11 + k1;
			System.out.println("Account number : " + account32 + " : balance " + a121);
			ps = conn.prepareStatement("update  bank set cbal=? where caccnum=?");
			ps.setInt(1, a121);
			ps.setLong(2, account32);
			int sa1 = ps.executeUpdate();
			ps = conn.prepareStatement("insert into transaction values(?,?,?,?,?,?)");
			ps.setInt(1, a121);
			ps.setString(2, "fundstransfer 2");
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			ps.setInt(4, k1);
			ps.setLong(5, account32);
			ps.setLong(6, tid);
			ps.executeUpdate();

			if (sa1 > 0) {
				return "funded";
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getStackTrace());
			return "not funded";
		}
		return "not funded";
	}

	public void checkfund(int a1, int k1) {
		if (a1 < k1) {
			throw new Balance();
		}

	}

	public boolean validation(long account1) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "qwerty", "qwerty123");
			ps = conn.prepareStatement("select * from bank where caccnum = ?");
			ps.setLong(1, account1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			// conn.close();
			return false;
		}

		catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List transaction(long account33) {
		HashMap<TransBean, Long> hmt = new HashMap<TransBean, Long>();
		try {
			ps = conn.prepareStatement("select * from transaction where caccnum = ?");
			ps.setLong(1, account33);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tid12 = rs.getInt("tid");
				String trType = rs.getString("ttype");
				Timestamp getDate = rs.getTimestamp("ttime");
				int amount = rs.getInt("tbal");
				long accountId1 = rs.getLong("caccnum");
				long id1 = rs.getLong("tid1");

				TransBean tb = new TransBean();
				tb.setTransId(tid12);
				tb.setBaccFinal(accountId1);
				tb.setTransMetd(trType);
				tb.setTransBal(amount);
				tb.setTransdate(getDate);
				tb.settid1(id1);
				hmt.put(tb, account33);
			}
			conn.close();
			listkey = new ArrayList(hmt.keySet());
			return listkey;
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
		return listkey;
	}

}
