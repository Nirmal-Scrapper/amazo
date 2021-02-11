package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.ConnectionUtility;

public class OrderDAO {
	public boolean placeOrder(String order[]) {
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			String sql="insert into orders values(";
			//PreparedStatement ps=con.prepareStatement(null);
			for(int i=0;i<order.length-1;i++)
				sql=sql+order[i]+",";
			sql=sql+order[order.length-1]+")";
			System.out.println(sql);
			boolean flag=st.execute(sql);
			return flag;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean commit() {
		Connection con = ConnectionUtility.createConnection();
		try {
			con.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean check(String id) {
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			String sql="select * from orders where orderid="+id;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
