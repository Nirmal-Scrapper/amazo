package bill;

import java.sql.Connection;
import java.sql.Statement;

import utility.ConnectionUtility;

public class billDAO {
	String table="bill";
	public boolean create(String detail[]) {
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			String sql="insert into "+table+"(orderid,amount,discount,payable,id) values (";
			for(int i=0;i<detail.length-1;i++)
				sql=sql+detail[i]+",";
			sql=sql+detail[detail.length-1]+")";
			System.out.println(sql);
			boolean flag=st.execute(sql);
			con.commit();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
