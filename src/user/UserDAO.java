package user;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ConnectionUtility;

public class UserDAO extends User {
	String table = "user";

	public int Login(String Name, String Password) {
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			String sql = "select id from " + table + " where name='" + Name + "' and password='" + Password + "'";
			System.out.println(sql);
			ResultSet rs;

			rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public boolean Signup(String Name, String Password) {
		try {
			Connection con = ConnectionUtility.createConnection();
			System.out.println(con);
			Statement st = con.createStatement();
			String sql = "insert into " + table + "(name,password,status) values('" + Name + "','" + Password + "',0);";
			System.out.println(sql);
			boolean flag = st.execute(sql);
			if (flag)
				con.commit();
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean Update(String id, String status) {
		try {
			Connection con = ConnectionUtility.createConnection();

			Statement st = con.createStatement();
			String sql = "update " + table + " set status=" + status + " where id=" + id+";";
			boolean flag = st.execute(sql);
			if (flag)
				con.commit();
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conn error");
			e.printStackTrace();
		}

		return false;
	}

}
