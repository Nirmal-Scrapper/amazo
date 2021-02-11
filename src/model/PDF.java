package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import bill.PDF;
public class PDF extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		bill.PDF.newPDF();
		new utility.create_PDF().newPDF();
		return "paid";
	}
}
