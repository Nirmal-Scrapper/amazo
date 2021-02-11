package bill;

public class BillBuisness extends bill{

	@Override
	public String newBill(String[] detail) {
		// TODO Auto-generated method stub
		int discount=20;
		PDF.setDiscount(discount);
		detail[3]=String.valueOf((Float.parseFloat(detail[1])*(100-discount))/100);
		detail[2]=String.valueOf(discount);
		PDF.setPayable((int)(Float.parseFloat(detail[1])*(100-discount))/100);
		billDAO ob=new billDAO();
		ob.create(detail);
		return null;
	}

}
