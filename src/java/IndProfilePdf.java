	
	import java.awt.Color;
	import java.io.*;

	import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

	public class IndProfilePdf {
	
		public  File indProfileFunction(String date,String loginId,String password,String regId,String industryName,String industryType,String industryCategory,String yearOfCommissioning,String indStatus,String capInvestment,String indAddress ,String indCity,String indDistrict,String indTehsil,String indPin,String stdCode,String phoneNumber, String faxNumber,String eMail,String occName,String occDesignation,String occAddress,String occCity,String occDistrict,String occTehsil,String occPin,String occAreaCode ,String occPhoneNumber,String occFaxNo,String occMobileNo,String occEmail,String occHintQuestion,String occAnswer,String iOtherType,String comMonth,String iFaxCode,String occFaxCode)throws Exception

		{	File tempFile = new File("Industry.pdf");
			try{
			
		Document document = new Document(PageSize.A4);

	    
		PdfWriter.getInstance(document,
				new FileOutputStream(tempFile));
				document.open();

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("Online Industry Registeration Receipt", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD,new Color(0, 67, 134))));
		heading.setAlignment(Element.ALIGN_CENTER);
	
		document.add(heading);
		
		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		
		space.setAlignment(Element.ALIGN_CENTER);
	
		document.add(space);
		
		Paragraph dated = new Paragraph();
		dated.add(new Chunk("Date: "+date, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 67, 134))));
		dated.setAlignment(Element.ALIGN_RIGHT);
		document.add(dated);
		
		Paragraph headingline = new Paragraph();
		headingline.add(new Chunk("________________________________________________________________", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		headingline.setAlignment(Element.ALIGN_CENTER);
		document.add(headingline);
		document.add(space);
		
		Paragraph login = new Paragraph();
		login.add(new Chunk("OCMMS Login ID: "+loginId, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLDITALIC,new Color(0xFF, 0x00, 0x00))));
		login.add(new Chunk("             ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		login.add(new Chunk("Temporary Password: "+ password , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLDITALIC,new Color(0xFF, 0x00, 0x00))));
		login.setAlignment(Element.ALIGN_LEFT);
		document.add(login);
		
		document.add(space);
		
		Paragraph infor = new Paragraph();
		infor.add(new Chunk("Your industry has been successfully registered for the use of 'Online Consent Management & Monitoring System' under the following details", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		document.add(infor);
		
		document.add(space);
		
		PdfPTable table1=new PdfPTable(1);

		PdfPTable table=new PdfPTable(2);
		
		
		
		  
		
		PdfPCell cell = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Industry/Hotel Information", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(255,255,255)))));
		cell.setColspan (2);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBackgroundColor (new Color(0, 67, 134));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);

		
		cell = new PdfPCell (new Paragraph (new Chunk("Industry/Hotel Name : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		//cell.setBorderColorBottom();
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(industryName, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		

		cell = new PdfPCell (new Paragraph (new Chunk("Industry Type : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(industryType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Category : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(industryCategory, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Other Industry Type Detail : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(iOtherType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Month/Year Of Commissioning : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(comMonth+"/"+yearOfCommissioning, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Status : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(indStatus, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
//		cell = new PdfPCell (new Paragraph (new Chunk("Capital Investment of Plant & Machinery : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
//		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
//		cell.setVerticalAlignment(Element.ALIGN_CENTER);
//		//cell.setBackgroundColor (new Color (255, 200, 0));
//		cell.setPadding (3.0f);
//		//cell.setBorder(PdfPCell.NO_BORDER);
//		cell.setBorderColor(new Color(0, 67, 134));
//		table.addCell (cell);
//		
//		cell = new PdfPCell (new Paragraph (new Chunk(capInvestment, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
//		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
//		//cell.setBackgroundColor (new Color (255, 200, 0));
//		cell.setVerticalAlignment(Element.ALIGN_CENTER);
//		cell.setPadding (3.0f);
//		//cell.setBorder(PdfPCell.NO_BORDER);
//		cell.setBorderColor(new Color(0, 67, 134));
//		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Total Capital Investment(in Lakhs) : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(capInvestment, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Address of Establishment : ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(indAddress+" "+indCity+" "+indTehsil+" "+indDistrict, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Pin : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(indPin, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Contact Details : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(stdCode+"-"+phoneNumber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Fax Number : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(iFaxCode+"-"+faxNumber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("EMail Address: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(eMail, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Occupier Details", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(255,255,255)))));
		cell.setColspan (2);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor (new Color(0, 67, 134));
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Occupier Name : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		//cell.setBorderColorBottom();
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(occName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Designation : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(occDesignation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Address : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(occAddress+", "+occCity+", "+occTehsil+", "+occDistrict, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		
		
		
		
		cell = new PdfPCell (new Paragraph (new Chunk("Pin : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(occPin, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		
		/*cell = new PdfPCell (new Paragraph (new Chunk("City : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_RIGHT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		table.addCell (cell);*/
		
		cell = new PdfPCell (new Paragraph (new Chunk("Phone Number : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(occAreaCode+"-"+occPhoneNumber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Fax Number : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(occFaxCode+"-"+occFaxNo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Mobile No : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(occMobileNo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("E-Mail : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(occEmail, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Password Recovery Details", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(255,255,255)))));
		cell.setColspan (2);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor (new Color(0, 67, 134));
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Hint Question : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		
		table.addCell (cell);
		cell = new PdfPCell (new Paragraph (new Chunk(occHintQuestion, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Answer : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  - 2, Font.BOLD,new Color(0, 67, 134)))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk(occAnswer, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 ))));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (3.0f);
		
		//cell.setBorder(PdfPCell.NO_BORDER);
		cell.setBorderColor(new Color(0, 67, 134));
		table.addCell (cell);

		
		
		//table1.addCell(table);
		//document.add(table1);
		document.add(table);
		
		Paragraph belowInf = new Paragraph();
		belowInf.add(new Chunk("*For future use of an application please use above mentioned login-ID.Please change the password in first login due to security reasons.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 , Font.BOLDITALIC ,new Color(0xFF, 0x00, 0x00))));
		
		document.add(belowInf);
		Paragraph blankLine = new Paragraph();
		blankLine.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 , Font.BOLDITALIC ,new Color(0xFF, 0x00, 0x00))));
		document.add(blankLine);
		
		
		document.add(headingline);
		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("INSTRUCTIONS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 , Font.BOLD,new Color(0, 67, 134))));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		document.add(headingline);		
		List list1=new List(true,30);
	
		list1.add(new ListItem("Enter OCMMS login-ID to use the system every time.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2 , Font.BOLD,new Color(0, 67, 134))));
		list1.add(new ListItem("Change the password when first time you log into the system.Please follow the instructions to protect your password from any cyber theft.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2 , Font.BOLD,new Color(0, 67, 134))));
		
		document.add(list1);
		
		Paragraph subHeading1 = new Paragraph();
		subHeading1.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 , Font.BOLD)));
		
		document.add(subHeading1);
		
		Paragraph subHeading2 = new Paragraph();
		subHeading2.add(new Chunk("**This is computer generated receipt**", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 , Font.BOLD)));
		subHeading2.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading2);
		
		document.close();
		
    	}catch (Exception e) {
			e.printStackTrace();
			
		}
    	return tempFile;
		}
	



}
	