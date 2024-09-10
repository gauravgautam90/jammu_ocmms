import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class RevokeAirPdfGeneration {


	public File airPdfFunction(String grpName,String desination,String industryId,String occupierName, String address,String indName,String appId,String fileNo,String details,String employeeName,String employeeName1,String createOn,String certFor,String consentFrom,String consentTo,String grpByRoOfficeAddress)throws Exception
			{
		File tempFile = new File("certificate.pdf");
		try
		{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		
		Phrase headerPhrase = new Phrase ("");
		HeaderFooter header = new HeaderFooter(headerPhrase, true);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(header);
		
		document.open();
		
		// For Space	    
	    Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		space.setAlignment(Element.ALIGN_CENTER);
        document.add(space); 
        
     // For Image
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT| Image.TEXTWRAP);
		document.add(image);

		Image image2 = Image.getInstance("images2/SwarnajyantiLogo.jpg");
		image2.scalePercent(70.0f);
		image2.setAlignment(Image.RIGHT | Image.TEXTWRAP);
		image2.setIndentationRight(22);
		document.add(image2);

		
		
	  //For New Heading
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("HARYANA STATE POLLUTION CONTROL BOARD" +
				"\n"+grpByRoOfficeAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
		heading1.setAlignment(Element.ALIGN_CENTER);
	    document.add(heading1);
	    
	    document.add(space);document.add(space);document.add(space);document.add(space);
	    
	    PdfPTable table1=new PdfPTable(2);
	 	table1.setWidthPercentage(100);
		PdfPCell cell1 = new PdfPCell ();
		
		cell1 = new PdfPCell (new Paragraph (new Chunk("No. :"+fileNo, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setPadding (3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (new Paragraph (new Chunk("             Dated :"+createOn, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setPadding (3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		table1.addCell (cell1);
		
		document.add(table1);
	  
	    document.add(space);
	    
	    Paragraph heading4 = new Paragraph();
		heading4.add(new Chunk("To\n" +
				"\n"+indName+
				"\n"+address, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
		heading4.setAlignment(Element.ALIGN_LEFT);
	    document.add(heading4);
	    
	    document.add(space);
	    
	    Paragraph heading5 = new Paragraph();
		heading5.add(new Chunk("Subject: Revocation of Consent to Operate granted under Air Act, 1981.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
		heading5.setAlignment(Element.ALIGN_LEFT);
		heading5.setAlignment(Element.ALIGN_JUSTIFIED);
	    document.add(heading5);
	    
	    document.add(space);
	    
	    Paragraph heading6 = new Paragraph();
		heading6.add(new Chunk("	Please refer to the subject noted above" +
				"\n		The Regional officer "+grpName+" has intimated that the above said unit is violating on following grounds:-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
		heading6.setAlignment(Element.ALIGN_LEFT);
		heading6.setAlignment(Element.ALIGN_JUSTIFIED);
	    document.add(heading6);
	    
	    document.add(space);
	    
	    Paragraph heading61 = new Paragraph();
		heading61.add(new Chunk("   "+details, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
		heading61.setAlignment(Element.ALIGN_LEFT);
	    document.add(heading61);
	    
	    document.add(space);
	    
	    Paragraph heading611 = new Paragraph();
		heading611.add(new Chunk("					A Show Cause notice for revocation of CTO granted under Water Air Act, 1981 was issued to unit vide letter no "+fileNo+
				". The unit has not complied the above mentioned shortcomings against the Show Cause Notice issued.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
		heading611.setAlignment(Element.ALIGN_LEFT);
		heading611.setAlignment(Element.ALIGN_JUSTIFIED);
	    document.add(heading611);
	    
	    document.add(space);
	    
	    Paragraph heading6112 = new Paragraph();
		heading6112.add(new Chunk("Therefore, in view of above, consent to operate granted to you by Board vide letter no "+appId+""+createOn+" for period from " +
				"	"+consentFrom+ " to " +consentTo+" is hereby revoked and further action as per Law shall be taken against the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
		heading6112.setAlignment(Element.ALIGN_LEFT);
		heading6112.setAlignment(Element.ALIGN_JUSTIFIED);
	    document.add(heading6112);
	    
	    document.add(space);document.add(space);document.add(space);
	    
	    Paragraph heading61122 = new Paragraph();
		heading61122.add(new Chunk("Regional Office "+grpName+
				"\nHaryana State Pollution Control Board", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
		heading61122.setAlignment(Element.ALIGN_RIGHT);
	    document.add(heading61122);
	    
	    
		document.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
    	return tempFile;

	}	


}
