import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WaterReportCert {

public File waterReportCert(String Aldrin,String AlphaBHC,String BetaBHC,String GamaBHC,String Ddt,String Dieldrin,String Endrin,String Endosulphan1,String Endosulphan2,String Heptachlor,String Methoxychlore,String Malathion,String MethylParathion,String Phorate,String currentDate) throws Exception {
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);
		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		
		Paragraph heading = new Paragraph();
		heading.add(new Chunk("CHHATTISGARH POLLUTION CONTROL BOARD",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("Centarl Laboratory",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);

		document.add(heading1);
		
		document.add(space12);
		document.add(space12);
		
		heading.add(new Chunk("DRAFT ANALYSIS REPORT",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		
		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("NAMP : Sampling Cum Analysis Sheet",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		
	
		
		document.add(space12);

		Paragraph videNo = new Paragraph();
		
		videNo.add(new Chunk("Date Of Receipt Of Sample:", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +currentDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNo);
		document.add(space12);
		
		PdfPTable table=new PdfPTable(3);
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph (new Chunk("SN", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Parameters", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Value", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("1"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Aldrin"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Aldrin));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("2"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Alpha BHC"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (AlphaBHC));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("3"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Beta BHC"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (BetaBHC));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("4"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Gama BHC"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (GamaBHC));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("5"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("DDT"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Ddt));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("6"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Dieldrin"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Dieldrin));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("7"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Endrin"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Endrin));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		
		cell = new PdfPCell (new Paragraph ("8"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("EndoSulphan I"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Endosulphan1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("9"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("EndoSulphan II"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Endosulphan2));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("10"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Heptachlor"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Heptachlor));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("11"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Methoxychlore"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Methoxychlore));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("12"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Malathion"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Malathion));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph ("13"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Methyl Parathion"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (MethylParathion));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("14"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Phorate"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (Phorate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		document.add(table);
		
		document.add(space12);
		
		Paragraph address = new Paragraph("Unit: ug/l for Water Samples");
		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(20);
		document.add(address);
		
		address = new Paragraph("ug/kg for Solid Samples");
		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(40);
		document.add(address);
		document.add(space12);
		
		Paragraph subject = new Paragraph("Remark: ND-Not Detectable");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(subject);
		
		
		Paragraph encl = new Paragraph();
		encl.add(new Chunk("Scientist                    ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		document.add(space12);
		document.add(space12);
		encl.add(new Chunk("Senior Scientific Officer ",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		document.add(encl);
		
		document.add(space12);
		
		
		
		document.close();
		
		return tempFile;
	}
	
	
}
