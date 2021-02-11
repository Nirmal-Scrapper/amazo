package utility;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class create_PDF {
	public static void main(String args[]) throws Exception {
		// Creating a PdfWriter
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("c:/iTextHelloWorld.pdf"));

		document.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);

		document.add(chunk);
		document.close();
		System.out.println("PDF Created");
		new create_PDF().newPDF();
	}

	public  void newPDF() {
		try{
		      String executionPath = System.getProperty("user.dir");
		      System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
		    }catch (Exception e){
		      System.out.println("Exception caught ="+e.getMessage());
		    }
		try {
			String cols[] = { "product", "quantity", "price" };
			String items[]= {"srfgs","sfgssd"};
			int quan[]= {1,2};
			int price[]= {32,232};
			int total=100,discount=20,pay=80;
			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream("/Users/nirmal/eclipse-workspace/amazo/WebContent/WEB-INF/mm.pdf"));
			// Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

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
			 table= new PdfPTable(3);
			phr = new Phrase();
			header = new PdfPCell();
			phr.add("total");
			header.setPhrase(phr);
			table.addCell(header);
			
			phr = new Phrase();
			header = new PdfPCell();phr.add("discount");
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
