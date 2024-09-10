
import java.beans.DesignMode;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class HWMInspectionReport
{ public File getDetails(String indName,String indAddress,String website,String telephone,String faxno,String email,String dobVisit,String contactName,String mobile,String conDesignation,ArrayList listofOfficer,String processDesc,String yearCom,String wateractvalid,String airact,String hwmact,ArrayList arraylist1,ArrayList arraylist2,ArrayList arraylist3,ArrayList arraylist4,ArrayList arraylist6 ,ArrayList arraylist5,String inspOfficer,String todayDate,String remarks,String contaminated,ArrayList officerList){
	File tempFile = new File("inspection.pdf");
	try{

		//Document document = new Document(PageSize.A4);
		//String cont = "/home1/Documents/Noise";
		//File tempFile = new File(cont+"_CertificateHWM.pdf");
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		//PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase headerPhrase = new Phrase("");
		HeaderFooter header = new HeaderFooter(headerPhrase, true);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(header);

		/*Phrase footerPhrase = new Phrase(
				"----This is computer generated application ---- \n https://upocmms.nic.in/ - (UPPCB)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2));
		HeaderFooter footer = new HeaderFooter(footerPhrase, false);

		footer.setAlignment(HeaderFooter.ALIGN_CENTER);
		footer.setBorder(Rectangle.NO_BORDER);
		document.setFooter(footer);
	*/
		document.open();
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.ALIGN_MIDDLE | Image.TEXTWRAP);
		document.add(image);

		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ",
				new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD)));
		space.setAlignment(Element.ALIGN_CENTER);
		document.add(space);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J&K Pollution Control Committee JAMMU",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		
		document.add(space);
		
		
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Hazardeous-Waste Insepction Report",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		document.add(space);

		PdfPTable table = new PdfPTable(3);
		float[] columnWidths = new float[] { 1.5f, 10f, 8f };
		table.setWidths(columnWidths);
		table.setWidthPercentage(100);

		heading = new Paragraph("I. General Information:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD));
		PdfPCell cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD));
		//PdfPCell cell = new PdfPCell(heading);
		cell= new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Name of Industry",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph( ""+indName ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Complete Address of Industry",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(indAddress, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);



		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph("Website", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+website, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		
		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph("Telephone and Fax no", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+telephone, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		

		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Email",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+email, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Date of Visit",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(" "+dobVisit, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);


		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Contact Person Name,contact,Designation",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("Contact Person: "+contactName +"\n contact: "+mobile+" \n Designation: "+conDesignation, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("8.(a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Name and Designation of the Officials visiting the unit",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+officerList.toString(), new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("8.(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Process description in brief.for each Product. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+processDesc, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		/*
		heading = new Paragraph("8.(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Bedded / Non Bedded Fee ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		*/
		heading = new Paragraph("8.(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Year of Commisioning",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+yearCom, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("9.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Status of Consent under Water act,1974",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+wateractvalid, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("10.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Status of Consent under Air Act,1974",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+airact, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("11.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Status of Authrizaation under the Hazardeous Waste Management,1974",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+hwmact, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Remarks",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+remarks, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Details of HW contaminated sites if any within and outside the industry primise",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+contaminated, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		document.add(table);
		
		//=================================================================//
		/*heading = new Paragraph();
		heading.add(new Chunk("Part D: Hazardous substances used", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);*/

		
		PdfPTable table4 = new PdfPTable(3);
		float[] columnWidths4 = new float[] { 1f, 10f, 8f };
		table4.setWidths(columnWidths4);
		table4.setWidthPercentage(100);


		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell31 = new PdfPCell(heading);
		cell31 = new PdfPCell(heading);
		cell31.setPadding(3.0f);
		cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell31);

		heading = new Paragraph(
				"Name and Categories of HWM generated and their respective quantity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table4.addCell(cell);

		PdfPTable nestedTable111 = new PdfPTable(10);
		cell = new PdfPCell();
		float[] columnWidthscc11 = new float[] {4f,3f,3f,3f,3f,3f,3f,3f,3f,3f};
		nestedTable111.setWidths(columnWidthscc11);
		nestedTable111.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Various production plant/process at facilit", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);


		cell = new PdfPCell(new Paragraph(new Chunk("Name of HWM (with category) generated in Tonne and half quantity per tonne of input",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("HWM Generation(in tonne) per tonne of the consented product",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("HWM Generation as per the consented capecity of product(Tonne per day or month or annum)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity During current fincial year \n(Production)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity During current fincial year \n (Input)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity During Previous fincial year \n (Production)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity During Previous fincial year \n (Input)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity of Generated HWM During Current year ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity of Generated HWM During Previous year ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable111.addCell(cell);

		for (int var21 = 0; var21 < arraylist2.size(); var21++) {
			ArrayList<String> al = (ArrayList)arraylist2.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable111.addCell(cell);
			}
		}

		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable111);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table4.addCell(cell);
		document.add(table4);
		document.add(space);
		//-------------------------------------------------------------------------------------------------------------------//
		/*heading = new Paragraph();
		heading.add(new Chunk("Part D1: HDetails of HW Storage,Qanitity of HW Stored and period of storage", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);*/
		
		PdfPTable table5 = new PdfPTable(3);
		float[] columnWidths5 = new float[] { 1f, 10f, 8f };
		table5.setWidths(columnWidths5);
		table5.setWidthPercentage(100);
		
		

		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3133 = new PdfPCell(heading);
		cell3133 = new PdfPCell(heading);
		cell3133.setPadding(3.0f);
		cell3133.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell3133);

		heading = new Paragraph(
				"Details of HW Storage,Qanitity of HW Stored and period of storage",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table5.addCell(cell);
		
		PdfPTable nestedTable11P = new PdfPTable(6);
		cell = new PdfPCell();
		float[] columnWidthscc11p = new float[] {4f,3f,3f,3f,3f,3f};
		nestedTable11P.setWidths(columnWidthscc11p);
		nestedTable11P.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Name and Category HWM", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11P.addCell(cell);


		cell = new PdfPCell(new Paragraph(new Chunk("Actual HW generated(in Tonne)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11P.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Previous Stock(in Tonne) stored in storage shed(at the beginning of prev financial year)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11P.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Actual Quantity(in tonne) found stored on the day of inspection",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11P.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Balance(in Tonne)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11P.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Latest date of transfer of HW to authorized recyler/Co-processor",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11P.addCell(cell);
		
		
		for (int var21 = 0; var21 < arraylist3.size(); var21++) {
			ArrayList<String> al = (ArrayList)arraylist3.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable11P.addCell(cell);
			}
		}
		
		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable11P);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table5.addCell(cell);
		document.add(table5);
		//============================================
		
		
		
		
		PdfPTable table6 = new PdfPTable(3);
		float[] columnWidths6 = new float[] { 1f, 10f, 8f };
		table6.setWidths(columnWidths6);
		table6.setWidthPercentage(100);
		
		

		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3132 = new PdfPCell(heading);
		cell3132 = new PdfPCell(heading);
		cell3132.setPadding(3.0f);
		cell3132.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6.addCell(cell3132);

		heading = new Paragraph(
				"Categories and quantity of HW sent to authorized actual user/Common TSDF",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table6.addCell(cell);

		PdfPTable nestedTable11W = new PdfPTable(4);
		cell = new PdfPCell();
		float[] columnWidthscc11W = new float[] {4f,3f,3f,3f};
		nestedTable11W.setWidths(columnWidthscc11W);
		nestedTable11W.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Name and Address of the authorized common TSDF/Actual user", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11W.addCell(cell);


		cell = new PdfPCell(new Paragraph(new Chunk("Name of SPCB/PCC who granted to the authorization to the authorized TSDF/Actual user and authorization no. and with its validity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11W.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Activities for which authorization granted to the authorized TSDF/Actual User (Specify among Transportation/Recycling)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11W.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Name and Category of HW which authorization granted",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11W.addCell(cell);
		
		for (int var21 = 0; var21 < arraylist4.size(); var21++) {
			ArrayList<String> al = (ArrayList)arraylist4.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable11W.addCell(cell);
			}
		}
		
		
		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable11W);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table6.addCell(cell);
		
		document.add(table6);
		//==========================================
		
		PdfPTable table7 = new PdfPTable(3);
		float[] columnWidths7 = new float[] { 1f, 10f, 8f };
		table7.setWidths(columnWidths7);
		table7.setWidthPercentage(100);
		
		

		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3130 = new PdfPCell(heading);
		cell3130 = new PdfPCell(heading);
		cell3130.setPadding(3.0f);
		cell3130.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7.addCell(cell3130);

		heading = new Paragraph(
				"Safety Facelities provided at storage facility",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table7.addCell(cell);

		PdfPTable nestedTable11Z = new PdfPTable(1);
		cell = new PdfPCell();
		float[] columnWidthscc11Z = new float[] {4f};
		nestedTable11Z.setWidths(columnWidthscc11Z);
		nestedTable11Z.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Safety Facelity", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11Z.addCell(cell);
		
		for (int var21 = 0; var21 < arraylist5.size(); var21++) {
			ArrayList<String> al = (ArrayList)arraylist5.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable11Z.addCell(cell);
			}
		}
		
		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable11Z);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table7.addCell(cell);
		
		document.add(table7);
		
		
		//====================================================
		PdfPTable table8 = new PdfPTable(3);
		float[] columnWidths8 = new float[] { 1f, 10f, 8f };
		table8.setWidths(columnWidths8);
		table8.setWidthPercentage(100);
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3138 = new PdfPCell(heading);
		cell3138 = new PdfPCell(heading);
		cell3138.setPadding(3.0f);
		cell3138.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8.addCell(cell3138);

		heading = new Paragraph(
				"Generated Hazardeous Waste Details",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table8.addCell(cell);
		
		PdfPTable nestedTable11S = new PdfPTable(4);
		cell = new PdfPCell();
		float[] columnWidthscc11S = new float[] {4f,3f,4f,3f};
		nestedTable11S.setWidths(columnWidthscc11S);
		nestedTable11S.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Name of HWM", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11S.addCell(cell);


		cell = new PdfPCell(new Paragraph(new Chunk("Category",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11S.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Quantity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11S.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk("Mode of Treatment",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11S.addCell(cell);

		for (int var21 = 0; var21 < arraylist1.size(); var21++) {
			ArrayList<String> al = (ArrayList)arraylist1.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable11S.addCell(cell);
			}
		}
		
		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable11S);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table8.addCell(cell);
		
		document.add(table8);
		//=================================================================
		
		PdfPTable table9 = new PdfPTable(3);
		float[] columnWidths9 = new float[] { 1f, 10f, 8f };
		table9.setWidths(columnWidths9);
		table9.setWidthPercentage(100);
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3140 = new PdfPCell(heading);
		cell3140 = new PdfPCell(heading);
		cell3140.setPadding(3.0f);
		cell3140.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9.addCell(cell3140);

		heading = new Paragraph(
				"Production in MT or KL/day",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table9.addCell(cell);
		
		PdfPTable nestedTable11K = new PdfPTable(3);
		cell = new PdfPCell();
		float[] columnWidthscc11K = new float[] {4f,3f,4f};
		nestedTable11K.setWidths(columnWidthscc11K);
		nestedTable11K.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Product", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11K.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk(
				"Quantity", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11K.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk(
				"Status", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11K.addCell(cell);
		
		for (int var21 = 0; var21 < arraylist6.size(); var21++) {
			ArrayList<String> al = (ArrayList)arraylist6.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable11K.addCell(cell);
			}
		}
		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable11K);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table9.addCell(cell);
		
		document.add(table9);
		//======================================================================================
				
		//====================================================================================
		
		
		
		
		document.add(space);
		heading = new Paragraph();
		heading.add(new Chunk("Date: "+todayDate, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);
		
		heading = new Paragraph();
		heading.add(new Chunk("Inspecting Officer", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_RIGHT);
		document.add(heading);
		
		heading = new Paragraph();
		heading.add(new Chunk(""+inspOfficer, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_RIGHT);
		document.add(heading);
		
		document.add(space);
		document.close();

	}
		
	catch (Exception e) {
		e.printStackTrace();
	}
	return tempFile;
}
/*public  static void main(String[]args){
	HWMInspectionReport b= new HWMInspectionReport();
	b.getDetails();
}*/
} 

