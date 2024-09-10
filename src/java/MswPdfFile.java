import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class MswPdfFile {

	public File mswPdfFunction(String industryName,String natureComp,String qtyDisposedUnit,String sites,String investReturn,String measurePollution,String measureSafety,String qtyProcessedUnit,String measurePrevention,String nameWastePro,String location,String authorizationType,String authorizationAppl,String address,String industryTele,String industryPin,String industryFax,String nodalOfficer,String nodalDesig,String processDetAttach,String siteclearenceAttach,String detailAttach,String utilizationprogrammeAttach,String methodologyAttach, String detailsexistingsiteAttach,String layoutmapsAttach,String detailmethodologyorcriteriaAttach,String methodologyoperationaldetailsAttach) throws Exception {
		
		
    	java.util.Date date = new java.util.Date();
    	int  year=date.getYear();
    	 if (year < 1000)
            year+=1900;
      	int day=date.getDate();
      	int month=(date.getMonth()) + 1;
      
		File tempFile = new File("MSWForm.pdf");

		Document document = new Document(PageSize.A4);


		PdfWriter.getInstance(document,
				new FileOutputStream(tempFile));
		document.open();

		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));

		space.setAlignment(Element.ALIGN_CENTER);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("Form I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		
		//document.add(space);
		
		Paragraph heading2 = new Paragraph();
		heading2.add(new Chunk("[see rules 4(2) & 6(2)]", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading2.setAlignment(Element.ALIGN_CENTER);

		document.add(heading2);
	
		//document.add(space);		
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("Application for obtaining authorization", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);

		document.add(heading1);
		
		Paragraph headingline = new Paragraph();
		headingline.add(new Chunk("_____________________________________________________________________", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		headingline.setAlignment(Element.ALIGN_CENTER);
		document.add(headingline);

		document.add(space);


        Paragraph heading3 = new Paragraph();
 		heading3.add(new Chunk("To", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,Font.BOLD )));
 		heading3.setAlignment(Element.ALIGN_LEFT);

 		document.add(heading3);
 		
 		Paragraph heading4 = new Paragraph();
 		heading4.add(new Chunk("The Member Secretary, ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,Font.BOLD )));
 		heading4.setAlignment(Element.ALIGN_LEFT);

 		document.add(heading4);
 		 
 		Paragraph heading5 = new Paragraph();
 		heading5.add(new Chunk("J&K Pollution Control Committee ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,Font.BOLD )));
 		heading5.setAlignment(Element.ALIGN_LEFT);

 		document.add(heading5);
		
		document.add(space);



        // float[] widths = {1,1,1,4};
         PdfPTable table = new PdfPTable(2);

         table.setWidthPercentage(100);
         
         
         PdfPCell cell = new PdfPCell();
         
         cell = new PdfPCell(new Paragraph(new Chunk("1. Name of the municipal authority/Name of the agency appointed by the municipal authority ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE ))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (168, 218, 243));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
        // cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+industryName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (232, 246, 249));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderColor(new Color(0, 0, 0));
        // cell.setBorderWidth(2);
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk("2. Corrospondence Address ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+address+" Pin : "+industryPin , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);


         cell = new PdfPCell(new Paragraph(new Chunk("    Telephone Number",  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setBorder(PdfPCell.NO_BORDER);
       //  cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         //cell.setBorderColorBottom();
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+industryTele ,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk("    Fax Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
       //  cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
       //  cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+industryFax, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("3. Nodal Officer & designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+nodalOfficer, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk("(Officer authorised by the municipal authority or agency responsible for operation of processing or disposal facility)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+nodalDesig , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
       //  cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         
         cell = new PdfPCell(new Paragraph(new Chunk("4. Authorization applied for (Please tick mark)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+authorizationAppl , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         

         cell = new PdfPCell(new Paragraph(new Chunk("5. Authorization Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        //setBackgroundColor (new Color (102, 183, 189));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+authorizationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
        // cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk("6. Detailed proposal of waste processing/disposal facility (to be attached ) to include", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(3.0f);
         //cell.setBorderWidth(2);
         cell.setBorder(PdfPCell.NO_BORDER);
         //cell.setBorderColor(new Color(0, 0, 0));
         cell.setColspan(2);
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" 6.1  Processing of Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0)))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
              
         cell = new PdfPCell(new Paragraph(new Chunk("   i. Location of Site", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
        // cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+location, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   ii. Name of Waste Processing Technology", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
        // cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+nameWastePro, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   iii. Details of Processing Technology", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
        // cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+processDetAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   iv. Quantity of waste to be processed per day", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+qtyProcessedUnit, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   v. Site clearence (from Local Authority)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+siteclearenceAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   vi. Details of agreement between municipal authority and operating agency", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+detailAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   vii. Utilization programme for waste processed (Product utilization)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+utilizationprogrammeAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   viii. Methodology for disposal of waste processing rejects (quantity and quality)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+methodologyAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   ix. Measures to be taken for prevention and control of environmental pollution", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+measurePrevention, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   x. Investment on Project and expected returns", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+investReturn, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   xi. Measures to be taken for safety of workers working in the plant", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" : "+measureSafety, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" 6.2  Disposal of Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0)))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell.setBackgroundColor (new Color (102, 183, 189));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);

         cell = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
        
         cell = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   i. Number of sites indentified", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
        // cell.addElement(space);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+sites, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   ii. Layout maps of site", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+layoutmapsAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   iii. Quantity of waste to be disposed per day", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+qtyDisposedUnit, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   iv. Nature and composition of waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+natureComp, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   v. Details of methodology or criteria followed for site selection", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+detailmethodologyorcriteriaAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   vi. Details of Existing Site under Operation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+detailsexistingsiteAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   vii. Methodology and operational details of landfilling", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+methodologyoperationaldetailsAttach, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("   viii. Measures taken to check enviornmental pollution", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk(" : "+measurePollution, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table.addCell(cell);
         
         document.add(table);
         document.add(space);
         
         PdfPTable table1 = new PdfPTable(2);

         table1.setWidthPercentage(100);
         
         cell = new PdfPCell(new Paragraph(new Chunk("Date :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table1.addCell(cell);
         
         cell = new PdfPCell(new Paragraph(new Chunk("        Signature of Nodal Officer:..........", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1))));
         cell.setHorizontalAlignment(Element.ALIGN_LEFT);
         cell.setVerticalAlignment(Element.ALIGN_CENTER);
         //cell.setBackgroundColor (new Color (206, 232, 234));
         cell.setPadding(3.0f);
         cell.setBorder(PdfPCell.NO_BORDER);
        // cell.setBorderWidth(2);
         //cell.setBorderColor(new Color(0, 0, 0));
         table1.addCell(cell);
         document.add(table1);
         
		 document.close();


		return tempFile;
	}
}
