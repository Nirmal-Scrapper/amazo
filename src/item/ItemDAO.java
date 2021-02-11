package item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import utility.ConnectionUtility;

public class ItemDAO {
	String table = "item";

	public boolean update(String itemid[], String quan[]) {
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			for (int i = 0; i < itemid.length; i++) {
				String sql = "update  " + table + " set quantity = quantity - " + quan[i] + " where itemid="
						+ itemid[i];
				System.out.println(sql);
				boolean flag = st.execute(sql);
				if (!flag)
					return flag;
			}
			con.commit();

		} catch (Exception e) {

		}
		return false;
	}

	public String[][] ReadAll() {
		String items[][] = new String[11][5];
		String sql = "select itemid,itemName,quantity,pic from " + table;
		String[] col= {"itemid","itemName","quantity","pic"};
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			//System.out.println("jdshfgdjshvj");
			// if (rs.last()) {
			// System.out.println(rsmd.getColumnCount());
			// items = new String[rs.getRow()][rsmd.getColumnCount()];
			int i = 0;
			while (rs.next()) {
				for (int j = 0; j < 4 && j<rsmd.getColumnCount(); j++) {
				//	System.out.println(rsmd.getColumnName(j));
					items[i][j] = rs.getString(col[j]);
				}
				i++;
			}
			//System.out.println(items.length);
			return items;
			// }
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}
		System.out.println("null");
		return null;
	}

	public int getPrice(String id) {
		String sql = "select price from " + table + " where itemid=" + id;
		try {
			Connection con = ConnectionUtility.createConnection();
			Statement st = con.createStatement();
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("price");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
