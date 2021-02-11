package item;

import java.sql.Connection;
import java.sql.Statement;

import utility.ConnectionUtility;

public class ItemBuisness extends item{
	@Override
	public boolean update(String itemid[], String quan[]) {
		// TODO Auto-generated method stub
		ItemDAO ob=new ItemDAO();
		boolean flag=ob.update(itemid, quan);
		return flag;
	}

	@Override
	public String[][] read() {
		// TODO Auto-generated method stub
		ItemDAO ob=new ItemDAO();
		String res[][]=ob.ReadAll();
		return res;
	}
	

}
