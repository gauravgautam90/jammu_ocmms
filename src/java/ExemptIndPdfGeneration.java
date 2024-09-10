import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;

public class ExemptIndPdfGeneration {
	public File pdfFunction(String indname,String indaddress,String inddistrict,String indtehsil,String indPin,String manufacturing,
			String divisionalofficer,String reginaldirector,String conditions,String draftDate,
			String yearString,String issuingConsentTypeNo,String appID,String currentYear,String occName) throws Exception {
		// Rectangle pageSize = new Rectangle(PageSize.A4);
		// // pageSize.setBackgroundColor
		// // (new java.awt.Color(0xaa, 0xaa, 0xDE));
		 //File tempFile = null;
		File tempFile = new File("certificate.pdf");
		Document document = new Document(PageSize.A4);

		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase footerPhrase = new Phrase ("The industry can apply for Renewal/Expansion of Consent on the Site www.jkocmms.nic.in directly"+"\n"+"Page",new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -4,Font.ITALIC));
		HeaderFooter footer = new HeaderFooter(footerPhrase, true);
		//footer.setBorderWidthTop(2);
		footer.setAlignment(Element.ALIGN_CENTER);
		//footer.setBorder(Rectangle.NO_BORDER); 
		document.setFooter(footer);
		document.open();

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);

		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		image.scalePercent(80.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space12);document.add(space12);document.add(space12);document.add(space12);
		
		PdfPTable table11a = new PdfPTable(2);
		table11a.setWidthPercentage(100);
		float[] columnWidthsA = {3f,1f};
		table11a.setWidths(columnWidthsA);
		PdfPCell cell11a = new PdfPCell();
		
		cell11a = new PdfPCell(new Paragraph(new Chunk("No.:- PCC/digital/"+yearString+issuingConsentTypeNo+appID+" of "+currentYear, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11a.setPadding(3.0f);
		cell11a.setBorder(PdfPCell.NO_BORDER);
		table11a.addCell(cell11a);
		
		cell11a = new PdfPCell(new Paragraph(new Chunk("Date:- "+ draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11a.setPadding(3.0f);
		cell11a.setBorder(PdfPCell.NO_BORDER);
		table11a.addCell(cell11a);
		
		document.add(table11a);
		
		PdfPTable tableA = new PdfPTable(2);
		tableA.setWidthPercentage(90);
		float[] columnWidthsA1 = {1.2f,1.5f};
		tableA.setWidths(columnWidthsA1);
		PdfPCell cellA = new PdfPCell();
		
		cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk(
				"Sh. "+occName+
				"\nM/s "+ indname +
				"\n" + indaddress +
				"\n" + inddistrict +", "+indPin , new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
	
		document.add(tableA);
		
		Paragraph heading12 = new Paragraph();
		heading12.add(new Chunk("Sub :- 	Application for seeking Consent in favour of M/s "+indname,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		heading12.setAlignment(Element.ALIGN_LEFT);
		heading12.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading12);
		
		document.add(space12);
		
		Paragraph heading121 = new Paragraph();
		heading121.add(new Chunk("							The activity of manufacturing of "+ manufacturing +" falls under White Category as per revised Guidelines issued by the Committee vide No. SPCB/Estb/Co/ Gen./ICC/91/1253-61 dated :- 29/04/2016",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		heading121.setAlignment(Element.ALIGN_LEFT);
		heading121.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading121);
		
		document.add(space12);
		
		PdfPTable table11=new PdfPTable(2);
	 	table11.setWidthPercentage(100);
	 	float[] columnWidths11 = {0.1f,1.6f};
		table11.setWidths(columnWidths11);
		PdfPCell cell11 = new PdfPCell ();
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("The White / Exemption Certificate is being issued subject to the following conditions:-", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setColspan(2);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("1. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("It shall be responsibility of the entrepreneur to ensure that there is no complaint from the surrounding area as a result of discharge of any type of emissions/effluents.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("2. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("The unit shall maintain cleanliness and good housekeeping both within and around the premises", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		//cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("3. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("There shall be no perspective odours, noise, smoke and dust inside and outside the premises.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		//cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("4. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("The unit shall abide by the direction of the Committee issued from time to time. Any infringement / violation or transgression of the statutory enactments of pollution Control Acts by the unit holder shall be sufficient cause to prosecute the violator in conformity with the relevant sections Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		//cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("5. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("The unit shall be under surveillance and monitoring of J&K SPCB.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		//cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("6. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("The unit holder should not cause any type of pollution (air/water/noise) beyond the permissible limits.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		//cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("7. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("Fast growing trees should be planted in the vacant spaces in and around the premises in order to develop Green Belt Cover.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		//cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("8. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk(conditions, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.NORMAL,new Color(0,0,0)))));
		cell11.setPadding (3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.BOLD,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setColspan(2);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell (cell11);
		
		cell11 = new PdfPCell (new Paragraph (new Chunk("In case of violation of above conditions, the certificate be treated as cancelled without any notice.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE -1, Font.BOLD,new Color(0,0,0)))));
		cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell11.setPadding (3.0f);
		cell11.setColspan(2);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table11.addCell (cell11);
		
		document.add(table11);
		document.add(space12);document.add(space12);
		
		PdfPTable table311 = new PdfPTable(2);
		table311.setWidthPercentage(100);
		PdfPCell cell311 = new PdfPCell();
				
		cell311 = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell311.setVerticalAlignment(Element.ALIGN_LEFT);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		cell311 = new PdfPCell(new Paragraph(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell311.setVerticalAlignment(Element.ALIGN_CENTER);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		document.add(table311);
		
		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("Copy to the :" +
				"\n		1. Member Secretary SPCB (JAMMU/SRINAGAR) for information please." +
				"\n		2. Director Industries & Commerce, Jammu for information & necessary action." +
				"\n		3. Divisional Officer SPCB "+ divisionalofficer +" for information & necessary action.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space12);document.add(space12);
		
		
		Paragraph subHeading2 = new Paragraph();
		subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCB” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
		subHeading2.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading2);
		
		document.close();
		return tempFile;
	}

}
