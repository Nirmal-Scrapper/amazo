package order;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import bill.BillBuisness;
import bill.PDF;
import item.ItemDAO;
 

public class orderBuisness extends Order {

	@Override
	public String order(String[] items, int[] quan, String uname) {
		// TODO Auto-generated method stub
		int price[] = new int[items.length];
		String bill[]= new String[5];
		String orders[] = new String[5];
		int total = 0;
		OrderDAO ob1 = new OrderDAO();
		ItemDAO ob = new ItemDAO();
		for(String i:items) {
			System.out.println(i);
		}
		String id = random();
		while (!ob1.check(id)) {
			id = random();
		}
		bill[0]=id;
		for (int i = 0; i < items.length; i++) {
			price[i] = ob.getPrice(items[i]);
			total = total + (price[i] * quan[i]);
			
			orders[0] = id;
			orders[1] = items[i];
			orders[2] = String.valueOf(quan[i]);
			orders[3] = String.valueOf(price[i]);
			orders[4] = uname;
			ob1.placeOrder(orders);
		}
		bill[1]=String.valueOf(total);
		bill[4]=uname;
		ob1.commit();
		PDF.setPrice(price);
		PDF.setQuantity(quan);
		PDF.setTotal(total);
		BillBuisness ob2=new BillBuisness();
		ob2.newBill(bill);
		return null;
	}

	public String random() {
		int length = 4;
		boolean useLetters = false;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
//		byte[] array = new byte[7]; // length is bounded by 7
//	    new Random().nextBytes(array);
//	    String generatedString = new String(array, Charset.forName("UTF-8"));
		System.out.println(generatedString);
		return generatedString;
	}
}
