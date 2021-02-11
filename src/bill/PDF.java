package bill;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	static String items[];
	static int quan[], price[];
	static int total, discount, pay;
	static String cols[] = { "product", "quantity", "price" };

//	public PDF(String item[], int qua[], int pric[], int tot, int disc, int pays) {
//		total = tot;
//		discount = disc;
//		pay = pays;
//		price = pric;
//	}
	public static void setItems(String item[]) {
		items = item;
//		System.out.println("items");
//		for (String i : items) {
//			System.out.println(i);
//		}
	}

	public static void setQuantity(int qua[]) {
	//	System.out.println("quantity");
		quan = qua;
//		for (int i : quan) {
//			System.out.println(i);
//		}
	}

	public static void setPrice(int pric[]) {
	//	System.out.println("price");
		price = pric;
//		for (int i : price) {
//			System.out.println(i);
//		}
	}

	public static void setTotal(int tot) {
		total = tot;
		//System.out.println(total);
	}

	public static void setDiscount(int disc) {
		discount = disc;
		//System.out.println(discount);
	}

	public static void setPayable(int pays) {
		pay = pays;
		//System.out.println(pay);
	}

	public static void create() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("/Users/nirmal/eclipse-workspace/amazo/WebContent/WEB-INF/bill.pdf"));

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Hello World", font);
			System.out.println("sample pdf ctreaion---------------------------");
			document.add(chunk);
			Process process = Runtime.getRuntime().exec("ls");
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void newPDF() {
		try {
			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream("/Users/nirmal/eclipse-workspace/amazo/WebContent/WEB-INF/bill.pdf"));
			// Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			System.out.println("bill pdf creation");
			document.open();
			PdfPTable table = new PdfPTable(3);
			PdfPCell header = new PdfPCell();
			Phrase phr = new Phrase();
			for (String i : cols) {
				phr = new Phrase();
				header = new PdfPCell();
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setBorderWidth(1);
				phr.add(i);
				System.out.print(i = "\t");
				header.setPhrase(phr);
				table.addCell(header);
			}
			// PdfPCell cell = new PdfPCell();
			for (int i = 0; i < items.length; i++) {
				phr = new Phrase();
				header = new PdfPCell();
				phr.add(items[i]);
				header.setPhrase(phr);
				table.addCell(header);

				phr = new Phrase();
				header = new PdfPCell();
				phr.add(String.valueOf(quan[i]));
				header.setPhrase(phr);
				table.addCell(header);

				phr = new Phrase();
				header = new PdfPCell();
				phr.add(String.valueOf(price[i]));
				header.setPhrase(phr);
				table.addCell(header);
			}
			document.add(table);
			table = new PdfPTable(3);
			phr = new Phrase();
			header = new PdfPCell();
			phr.add("total");
			header.setPhrase(phr);
			table.addCell(header);

			phr = new Phrase();
			header = new PdfPCell();
			phr.add("discount");
			header.setPhrase(phr);
			table.addCell(header);

			phr = new Phrase();
			header = new PdfPCell();
			phr.add("payable price");
			header.setPhrase(phr);
			table.addCell(header);

			phr = new Phrase();
			header = new PdfPCell();
			phr.add(String.valueOf(total));
			header.setPhrase(phr);
			table.addCell(header);

			phr = new Phrase();
			header = new PdfPCell();
			phr.add(String.valueOf(discount) + "%");
			header.setPhrase(phr);
			table.addCell(header);

			phr = new Phrase();
			header = new PdfPCell();
			phr.add(String.valueOf(pay));
			header.setPhrase(phr);
			table.addCell(header);
			document.add(table);
			document.close();
			System.out.println("pdf ready");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
