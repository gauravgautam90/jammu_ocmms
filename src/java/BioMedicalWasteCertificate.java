	
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;


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

	
public class BioMedicalWasteCertificate{

	public File bioCert(String draftLetterFor, ArrayList catList,String industryName,String industryAddress,String industryTehsil,
			String industryDistrict,String nameOfDistrict,String authorizationNumber,String letternumber,
			String noticeDate,String copyTo,ArrayList chk,String authPer, String noOfBeds,
			String noOfsamples,String noOfSamples,String noOfpatients,String noOfPatients,
			String expiryDate,String activityauthorizationsoughtfor, String subject,String appDate, 
	String catinst,String noOfchairs,String noOfbeds,String occName,String offAddres,
			String addrPlaceDisposalOfWaste,String termsco, String facility,String serviceProvider,
			String collected,String authCancelled, String desination, Float sum, String draftLetterDate,
			ArrayList conditionDetailsList, String reference,String roleName1,String appId,String dateofsubmition,
			String name,String nameind, String address,String date,String offname,String offdesg,String renewFrom,
			String renewTo,String officername,Boolean generation,Boolean collection,Boolean storage,Boolean transportation,Boolean reception,
			Boolean reuse,Boolean recycling,Boolean recovery,Boolean preprocessing,Boolean coprocessing,
			Boolean treatment,Boolean disposal,Boolean incineration,Boolean utilisation) throws Exception {
		
		
		{	File tempFile = new File("certificate.pdf");
			try{
			
		Document document = new Document(PageSize.A4);

	    
		PdfWriter.getInstance(document,
				new FileOutputStream(tempFile));
			

				
				Phrase footerPhrase = new Phrase ("Keep J&K Clean & Green",new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE-2));
				HeaderFooter footer = new HeaderFooter(footerPhrase, true);
				footer.setAlignment(Element.ALIGN_CENTER);
				//document.setFooter(footer);
				document.open();
	                                                 
				//SAURAV CODE FOR BIO MEDICAL WASTE
				
				List list = new List(true, 30);

				list.add(new ListItem(copyTo));
				

				
Image image = Image.getInstance("images2/JHK_Logo.jpg");
				
				image.scalePercent(50.0f);
				image.setAlignment(Image.LEFT| Image.TEXTWRAP);
				document.add(image);
				
				Image image1 = Image.getInstance("images2/check.png");
				image1.scalePercent(20.0f);
				 image1.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
				 
				Paragraph space4 = new Paragraph();
				space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 3, Font.BOLD)));
				space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 1)));

				document.add(space4);
			
				Paragraph heading = new Paragraph();
				
				//if(typeOfInd.equals("bmw")){
				//heading.add(new Chunk("Online Health Care Establishment Registeration Receipt", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD,new Color(0, 0, 0))));
			//	}else{
					heading.add(new Chunk("J & K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 5, Font.BOLD,new Color(0, 0, 0))));
			
				//}
				heading.setAlignment(Element.ALIGN_CENTER);
			
				document.add(heading);
				
				

				Paragraph space = new Paragraph();
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				//space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				
				space.setAlignment(Element.ALIGN_CENTER);
			
			
				
				Paragraph  headinginfo = new Paragraph();
				
				headinginfo.add(new Chunk("Jammu/Kashmir" ,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				
			//	headinginfo.add(new Chunk("                                                  S.C.O. 180,IInd Floor,Sector 5,Panchkula(Hry)" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				headinginfo.setAlignment(Element.ALIGN_CENTER);
				
				document.add(headinginfo);
                
				
				
				Paragraph  PHONE = new Paragraph();
				
				PHONE.add(new Chunk("www.jkspcb.nic.in" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));
						
				PHONE.setAlignment(Element.ALIGN_CENTER);

						document.add(PHONE);
				
				
				
				
				document.add(space);

				 Paragraph para211 = new Paragraph();
					para211.add(new Chunk("Specific Conditions:\n" 
							, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE - 1, Font.BOLD)));
					para211.add(new Chunk(""+termsco 
							, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE - 1, Font.NORMAL)));

					para211.setAlignment(Element.ALIGN_LEFT);
				
    		//	System.out.println("para211----------"+para211);
				
			
				
				Paragraph  head1 = new Paragraph();
				
				head1.add(new Chunk("FORM III \n" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));
				head1.setAlignment(Element.ALIGN_CENTER);

                document.add(head1);
				
				
                 Paragraph  head1e = new Paragraph();
				
				head1e.add(new Chunk("(See Rule 10)\nAUTHORISATION" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));
				head1e.setAlignment(Element.ALIGN_CENTER);

                document.add(head1e);
		
                /*PdfPTable table1qq=new PdfPTable(2);
            	
            	float[] columnWidths1qq = { 1.8f, 1f };
            	table1qq.setWidths(columnWidths1qq);
            	table1qq.setWidthPercentage(100);
            	PdfPCell cell1qq = new PdfPCell ();

            	cell1qq = new PdfPCell (new Paragraph (new Chunk("File no. of authorization: "+authorizationNumber, new Font(Font.TIMES_ROMAN,
            			Font.DEFAULTSIZE - 1, Font.NORMAL))));
            	cell1qq.setHorizontalAlignment (Element.ALIGN_LEFT);
            	cell1qq.setBorder(PdfPCell.NO_BORDER);

            	cell1qq.setPadding (10.0f);
            	table1qq.addCell (cell1qq);

            	cell1qq = new PdfPCell (new Paragraph (new Chunk("Dated:"+date, new Font(Font.TIMES_ROMAN,
            			Font.DEFAULTSIZE - 1, Font.NORMAL))));
            	cell1qq.setHorizontalAlignment (Element.ALIGN_RIGHT);
            	cell1qq.setBorder(PdfPCell.NO_BORDER);

            	cell1qq.setPadding (10.0f);
            	table1qq.addCell (cell1qq);


            	document.add(table1qq);*/
            	document.add(space4);

                
                
				Paragraph  head = new Paragraph();
				
				head.add(new Chunk("   (AUTHORISATION FOR OPERATING A FACILITY FOR COLLECTION, RECEPTION, TREATMENT, STORAGE, TRANSPORT AND DISPOSAL OF BIOMEDICAL WASTES)\n\n" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				head.setAlignment(Element.ALIGN_CENTER);

                document.add(head);
                
                
                
                ///////////////
       		 
       		 
       		
       		PdfPTable table35b = new PdfPTable(4);
       		float[] columnWidths35b = {1f,0.3f,1f,0.3f};
       		table35b.setWidths(columnWidths35b);
       		table35b.setWidthPercentage(100);
       		
       		PdfPCell cell35b = new PdfPCell();
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Generation, segregation", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(generation)	
       		{		
       			System.out.println("generation"+generation);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Collection", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(collection)	
       		{		
       			System.out.println("collection"+collection);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Storage", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(storage)	
       		{		
       			System.out.println("storage"+storage);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Transportation", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(transportation)	
       		{		
       			System.out.println("transportation"+transportation);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Reception", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       	    cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(reception)	
       		{		
       			System.out.println("reception"+reception);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Use", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(reuse)	
       		{		
       			System.out.println("reuse"+reuse);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Recycling", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(recycling)	
       		{		
       			System.out.println("recycling"+recycling);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Offering for sale", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(recovery)	
       		{		
       			System.out.println("recovery"+recovery);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Packaging", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(preprocessing)	
       		{		
       			System.out.println("preprocessing"+preprocessing);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Transfer", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(coprocessing)	
       		{		
       			System.out.println("coprocessing"+coprocessing);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		
       		/*cell35b = new PdfPCell(new Paragraph(new Chunk("Utilisation", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(treatment)	
       		{		
       			System.out.println("utilisation"+utilisation);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);*/
       		
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Treatment or Processing or Conversion", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(treatment)	
       		{		
       			System.out.println("treatment"+treatment);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Disposal or destruction", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(disposal)	
       		{		
       			System.out.println("disposal"+disposal);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
       		
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("Any other form of handling", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		if(incineration)	
       		{		
       			System.out.println("incineration"+incineration);
       			cell35b.addElement(image1);
       		}
       		table35b.addCell(cell35b);
                
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		table35b.addCell(cell35b);
       		
       		cell35b = new PdfPCell(new Paragraph(new Chunk("", new Font(
       				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.NORMAL))));
       		cell35b.setHorizontalAlignment(Element.ALIGN_LEFT);
       		cell35b.setVerticalAlignment(Element.ALIGN_LEFT);
       		cell35b.setPadding(3.0f);
       		cell35b.setBorder(PdfPCell.NO_BORDER);
       		
       		table35b.addCell(cell35b);
                  
                
                
                PdfPTable table1=new PdfPTable(3);
        		
        		float[] columnWidths1 = { 0.8f, 5f, 7f};
        		table1.setWidths(columnWidths1);
        		table1.setWidthPercentage(100);
        			PdfPCell cell1 = new PdfPCell ();
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("File no. of authorisation and date of issue:", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
        		
        			cell1 = new PdfPCell (new Paragraph (new Chunk(""+authorizationNumber+"  "+date, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
                
        			cell1 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("M/s "+industryName+", "+occName+" an occupier or operator of the facility located at "+industryAddress+" is hereby granted an authorisation for:", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
                
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell ();
        			cell1.addElement(table35b);
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (8.0f);
        			table1.addCell (cell1);
                
        			cell1 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (10.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("M/s "+industryName+" is hereby authorized for handling of biomedical waste as per the capacity given below:", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (10.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("(i)  Number of beds of HCF: "+collected, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
                
        			cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("(ii)  Number of health care facilities covered by CBMWTF: "+facility, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("(iii)  Installed treatment and disposal capacity: "+authCancelled, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("(iv)  Area or distance covered by CBMWTF: "+serviceProvider, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("(v)  Quantity of Biomedical waste handled, treated or disposed: "+offname, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (3.0f);
        			table1.addCell (cell1);
        			
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (5.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("This authorisation shall be in force for a period of "+letternumber+" Years from the date of issue.", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (5.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			
        			cell1.setPadding (5.0f);
        			table1.addCell (cell1);
        			
        			cell1 = new PdfPCell (new Paragraph (new Chunk("This authorisation is subject to the conditions stated below and to such other conditions as may be specified in the rules for the time being in force under the Environment (Protection) Act, 1986", new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE - 1, Font.NORMAL))));
        			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell1.setBorder(PdfPCell.NO_BORDER);
        			cell1.setColspan(2);
        			cell1.setPadding (5.0f);
        			table1.addCell (cell1);
        			
        			document.add(table1);
        			
        			document.add(space4);
        			document.add(space4);
        			//document.add(space4);
        			
        			PdfPTable table31=new PdfPTable(2);
        			
        			PdfPCell cell31 = new PdfPCell ();
        			
        			float[] columnWidths31 = { 1f,1f };
        			table31.setWidths(columnWidths31);
        			table31.setWidthPercentage(100);
        			
        			cell31 = new PdfPCell (new Paragraph (new Chunk("Date: "+date+"\nPlace: "+offAddres, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE ))));
        			cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
        			cell31.setBorder(PdfPCell.NO_BORDER);
        			cell31.setPadding (5.0f);
        			table31.addCell (cell31);
        			
        			cell31 = new PdfPCell (new Paragraph (new Chunk(""+officername+"\n"+offdesg, new Font(Font.TIMES_ROMAN,
        					Font.DEFAULTSIZE + 1))));
        			cell31.setHorizontalAlignment (Element.ALIGN_RIGHT);
        			cell31.setBorder(PdfPCell.NO_BORDER);
        			cell31.setPadding (5.0f);
        			table31.addCell (cell31);
        			
        			
        			document.add(table31);
        			
        			document.add(space4);
        			
        			
        			PdfPTable table1aa=new PdfPTable(3);
            		
            		float[] columnWidths1aa = { 0.8f, 5f, 7f};
            		table1aa.setWidths(columnWidths1aa);
            		table1aa.setWidthPercentage(100);
            			PdfPCell cell1aa = new PdfPCell ();
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (8.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("Terms and Conditions of Authorisation", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.BOLD))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (8.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("1. The authorisation shall comply with the provisions of the Environment (Protection) Act, 1986 and the rules made there under.", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("2. The authorisation or its renewal shall be produced for inspection at the request of an officer authorised by the prescribed authority.", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("3. The person authorized shall not rent, lend, sell, transfer or otherwise transport the biomedical wastes without obtaining prior permission of the prescribed authority.", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("4. Any unauthorised change in personnel, equipment or working conditions as mentioned in the application by the person authorised shall constitute a breach of his authorisation.", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("5. It is the duty of the authorised person to take prior permission of the prescribed authority to close down the facility and such other terms and conditions may be stipulated by the prescribed authority.", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(3);
            			cell1aa.setPadding (1.0f);
            			table1aa.addCell (cell1aa);
            			
            			cell1aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
            					Font.DEFAULTSIZE - 1, Font.NORMAL))));
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			
            		
            			
            			cell1aa = new PdfPCell ();
            			cell1aa.addElement(para211);
            			cell1aa.setHorizontalAlignment (Element.ALIGN_LEFT);
            			cell1aa.setBorder(PdfPCell.NO_BORDER);
            			cell1aa.setColspan(2);
            			cell1aa.setPadding (4.0f);
            			table1aa.addCell (cell1aa);
            			document.add(table1aa);
        			document.add(space4);
        			document.add(space4);
            			
            			
            			
            			
            			 PdfPTable table1q=new PdfPTable(2);
			            	
			            	float[] columnWidths1q = { 1.5f, 1f };
			            	table1q.setWidths(columnWidths1q);
			            	table1q.setWidthPercentage(100);
			            	PdfPCell cell1q = new PdfPCell ();

			            	cell1q = new PdfPCell (new Paragraph (new Chunk("Memo No.:  "+authorizationNumber, new Font(Font.TIMES_ROMAN,
			            			Font.DEFAULTSIZE - 1, Font.NORMAL))));
			            	cell1q.setHorizontalAlignment (Element.ALIGN_LEFT);
			            	cell1q.setBorder(PdfPCell.NO_BORDER);

			            	cell1q.setPadding (10.0f);
			            	table1q.addCell (cell1q);

			            	cell1q = new PdfPCell (new Paragraph (new Chunk("Dated:"+date, new Font(Font.TIMES_ROMAN,
			            			Font.DEFAULTSIZE - 1, Font.NORMAL))));
			            	cell1q.setHorizontalAlignment (Element.ALIGN_RIGHT);
			            	cell1q.setBorder(PdfPCell.NO_BORDER);

			            	cell1q.setPadding (10.0f);
			            	table1q.addCell (cell1q);
			            	

			            	document.add(table1q);
						
						
						
						Paragraph para44 = new Paragraph();
						para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
						para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
						para44.add(new Chunk("Copy To:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
						para44.add(new Chunk("\n"+copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
						
//						para44.add(list);
						para44.setAlignment(Element.ALIGN_JUSTIFIED);
						para44.setIndentationLeft(45);
						document.add(para44);

						document.add(space4);
						document.add(space4);
						document.add(space4);
						Paragraph heading2zc = new Paragraph();
						heading2zc.add(new Chunk(""+officername, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
						heading2zc.setAlignment(Element.ALIGN_RIGHT);
						document.add(heading2zc);
						
						Paragraph heading2z = new Paragraph();
						heading2z.add(new Chunk(""+offdesg, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
						heading2z.setAlignment(Element.ALIGN_RIGHT);
						document.add(heading2z);
//						document.add(space4);	    
			                
            			
            			
            			
            			
            			
            			
        		/////////////////////////////////????????????????????	
             /*   Paragraph  head1a = new Paragraph();
    			
    			head1a.add(new Chunk("1. Mr. "+name+" of M/s. "+nameind+", "+address+", is hereby granted an authorization to operate a facility for collection, reception, storage, transport and disposal of biomedical waste on the premises situated At-"+address +"  under Bio-medical Waste (Management & Handling) Rules,1998." ,
    					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
    			head1a.setAlignment(Element.ALIGN_JUSTIFIED);

                document.add(head1a);
                 document.add(space);
                Paragraph  head1b = new Paragraph();
				
				head1b.add(new Chunk("2. This authorization shall be in force for a period to "+renewTo+" from the date of issue." ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				head1b.setAlignment(Element.ALIGN_JUSTIFIED);

                document.add(head1b);
                document.add(space);
                 Paragraph  head1c = new Paragraph();
				
				head1c.add(new Chunk("3.This authorization is subject to the conditions stated below and to such other conditions as may be specified in the rules for the time being in force under the Environment (Protection) Act,1986." ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				head1c.setAlignment(Element.ALIGN_JUSTIFIED);

                document.add(head1c);
                document.add(space);

																			
																			
																			
																			PdfPTable table2=new PdfPTable(2);
																				
																				float[] columnWidths2 = {7f,3.6f};
																       		    table2.setWidths(columnWidths2);
																				
																				
																				
																				PdfPCell cell2 = new PdfPCell ();
																				
																				
																				
																				
																				
																				cell2 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
																				//cell2.setColspan (2);
																				cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
																				//cell2.setBackgroundColor (new Color(0, 0, 0));
																				cell2.setVerticalAlignment(Element.ALIGN_CENTER);
																                 cell2.setBorder(PdfPCell.NO_BORDER);
																				cell2.setPadding (1.0f);
																				table2.addCell (cell2);

																				
																				cell2 = new PdfPCell (new Paragraph (new Chunk("\n\n\n"+roleName1+"\nJharkhand State Polution Control Committee\nRegional Office", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.NORMAL,new Color(0, 0, 0)))));
																				cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
																				//cell2.setBackgroundColor (new Color (255, 200, 0));
																				cell2.setPadding (1.0f);
																				cell2.setVerticalAlignment(Element.ALIGN_CENTER);
																				//cell2.setBorder(PdfPCell.NO_BORDER);
																				cell2.setBorder(PdfPCell.NO_BORDER);

																			  //  cell2.setBorder(PdfPCell.NO_BORDER); 
																				//cell2.setBorderColorBottom();
																				table2.addCell (cell2);
																				
//																				document.add(table2);
//															document.newPage();
															
															Paragraph subHeading1 = new Paragraph();
															subHeading1.add(new Chunk("                                 TERMS & CONDITIONS OF AUTHORISATION:-    ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  , Font.BOLD)));
															
															document.add(subHeading1);
																	
														
															Paragraph heading1n = new Paragraph();
															heading1n.add(new Chunk(""+termsco, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
															heading1n.setAlignment(Element.ALIGN_LEFT);
															document.add(heading1n);
															
															
															 document.add(space4);
															 Paragraph heading2j = new Paragraph();
																heading2j.add(new Chunk(""+officername, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
																heading2j.setAlignment(Element.ALIGN_RIGHT);
																document.add(heading2j);
															
															 
															 Paragraph heading2 = new Paragraph();
																heading2.add(new Chunk(""+offdesg, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
																heading2.setAlignment(Element.ALIGN_RIGHT);
																document.add(heading2);
															 document.add(space4);
															
														
												                PdfPTable table1q=new PdfPTable(2);
												            	
												            	float[] columnWidths1q = { 1.5f, 1f };
												            	table1q.setWidths(columnWidths1q);
												            	table1q.setWidthPercentage(100);
												            	PdfPCell cell1q = new PdfPCell ();

												            	cell1q = new PdfPCell (new Paragraph (new Chunk("Memo No.:  "+authorizationNumber, new Font(Font.TIMES_ROMAN,
												            			Font.DEFAULTSIZE - 1, Font.NORMAL))));
												            	cell1q.setHorizontalAlignment (Element.ALIGN_LEFT);
												            	cell1q.setBorder(PdfPCell.NO_BORDER);

												            	cell1q.setPadding (10.0f);
												            	table1q.addCell (cell1q);

												            	cell1q = new PdfPCell (new Paragraph (new Chunk("Dated:"+date, new Font(Font.TIMES_ROMAN,
												            			Font.DEFAULTSIZE - 1, Font.NORMAL))));
												            	cell1q.setHorizontalAlignment (Element.ALIGN_RIGHT);
												            	cell1q.setBorder(PdfPCell.NO_BORDER);

												            	cell1q.setPadding (10.0f);
												            	table1q.addCell (cell1q);
												            	document.add(space4);

												            	document.add(table1q);
															
															
															
															Paragraph para44 = new Paragraph();
															para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															para44.add(new Chunk("Copy To:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															para44.add(new Chunk("\n"+copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															
//															para44.add(list);
															para44.setAlignment(Element.ALIGN_JUSTIFIED);
															para44.setIndentationLeft(45);
															document.add(para44);

															
															Paragraph heading2zc = new Paragraph();
															heading2zc.add(new Chunk(""+officername, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
															heading2zc.setAlignment(Element.ALIGN_RIGHT);
															document.add(heading2zc);
															
															Paragraph heading2z = new Paragraph();
															heading2z.add(new Chunk(""+offdesg, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
															heading2z.setAlignment(Element.ALIGN_RIGHT);
															document.add(heading2z);
															document.add(space4);	    
												                
                                                               
																	
										      
																
																				
															
															
															
														*/	
															
															
															
															
															
													      
				
		
		document.close();
			
			}catch (Exception e) {
			e.printStackTrace();
			}
		
    	return tempFile;
		}
	



}
	
	
//for string array[]
	
	public File bioCert(String draftLetterFor, ArrayList catList,String industryName,String industryAddress,String industryTehsil,
			String industryDistrict,String nameOfDistrict,String authorizationNumber,String letternumber,
			String noticeDate,String[] copyTo,ArrayList chk,String authPer, String noOfBeds,
			String noOfsamples,String noOfSamples,String noOfpatients,String noOfPatients,
			String expiryDate,String activityauthorizationsoughtfor, String subject,String appDate, 
			String details,String catinst,String noOfchairs,String noOfbeds,String occName,String offAddres,
			String addrPlaceDisposalOfWaste,String termsco, String facility,String serviceProvider,
			String collected,String authCancelled, String desination, Float sum, String draftLetterDate,
			ArrayList conditionDetailsList, String reference,String roleName1,String appId,String dateofsubmition) throws Exception {
		
		
		{	File tempFile = new File("certificate.pdf");
			try{
			
		Document document = new Document(PageSize.A4);

	    
		PdfWriter.getInstance(document,
				new FileOutputStream(tempFile));
			

				
				Phrase footerPhrase = new Phrase ("                      Keep Jammu & Kashmir Clean & Green",new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE-2));
				HeaderFooter footer = new HeaderFooter(footerPhrase, true);
				footer.setAlignment(Element.ALIGN_CENTER);
				document.setFooter(footer);
				document.open();
	                                                 
				//SAURAV CODE FOR BIO MEDICAL WASTE
				
				List list = new List(true, 30);
                for(int i=0;i<copyTo.length;i++){
				list.add(new ListItem(copyTo[i]));
                }
				

 
				
			
Paragraph heading = new Paragraph();
				
				
//if(typeOfInd.equals("bmw")){
				//heading.add(new Chunk("Online Health Care Establishment Registeration Receipt", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD,new Color(0, 0, 0))));
			//	}else{
					heading.add(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD,new Color(0, 0, 0))));
			
				//}
				heading.setAlignment(Element.ALIGN_CENTER);
			
				document.add(heading);
				
				

				Paragraph space = new Paragraph();
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				//space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				
				space.setAlignment(Element.ALIGN_CENTER);
			
			
				
				Paragraph  headinginfo = new Paragraph();
				
				headinginfo.add(new Chunk("Jammu/Kashmir" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				
			//	headinginfo.add(new Chunk("                                                  S.C.O. 180,IInd Floor,Sector 5,Panchkula(Hry)" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0))));
				headinginfo.setAlignment(Element.ALIGN_CENTER);
				
				document.add(headinginfo);
                
				
				
				Paragraph  PHONE = new Paragraph();
				
				PHONE.add(new Chunk("www.jspcb.nic.in" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));
						
				PHONE.setAlignment(Element.ALIGN_CENTER);

						document.add(PHONE);
				
				
				
				
				document.add(space);


					
				Paragraph  headinginfo2 = new Paragraph();
				Paragraph  headinginfo21 = new Paragraph();
				Paragraph  headinginfo22 = new Paragraph();
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
				int year1 = year+1;
					headinginfo2.add(new Chunk("                No.:JKPCC/BMW/"+year+"-"+(year1)+"                                              Dated: " +draftLetterDate,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));
					headinginfo22.add(new Chunk("               Authorization No.: "+authorizationNumber+"                             Application No.:"+appId,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));
					headinginfo21.add(new Chunk("               Date of Submission.: "+dateofsubmition,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0))));

					headinginfo2.setAlignment(Element.ALIGN_LEFT);
					headinginfo21.setAlignment(Element.ALIGN_LEFT);
					headinginfo22.setAlignment(Element.ALIGN_LEFT);
					document.add(headinginfo2);
					document.add(headinginfo22);
					document.add(headinginfo21);
					
				
				
			
				
				Paragraph  head1 = new Paragraph();
				
				head1.add(new Chunk("\nBIO MEDICAL WASTE AUTHORIZATION CERTIFICATE\n" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE+6, Font.BOLD,new Color(0, 0, 0))));
				head1.setAlignment(Element.ALIGN_CENTER);

                document.add(head1);
				
				
				
               
		
				
				Paragraph  head = new Paragraph();
				
				head.add(new Chunk("   UNDER BIO MEDICAL WASTE (M&H)RULES,1998.\n\n" ,  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE+2, Font.BOLD,new Color(0, 0, 0))));
				head.setAlignment(Element.ALIGN_CENTER);

                document.add(head);
				

	               PdfPTable table=new PdfPTable(3) ;
	               float[] columnWidths = {0.50f,6f,6f};
	       		    table.setWidths(columnWidths);
	                PdfPCell cell = new PdfPCell ();
	                
	        		cell = new PdfPCell (new Paragraph (new Chunk("1. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
	        	//	cell.setspan (2);
	            //   cell.setRowspan(5);
	        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
	        		cell.setVerticalAlignment(Element.ALIGN_TOP);
	        	//	cell.setBackgroundColor (new Color (255, 200, 0));
	        		cell.setPadding (2);
	        		cell.setBorder(PdfPCell.NO_BORDER);
	        		//cell.setBorderColor(new Color(0, 0, 0));
	        		table.addCell(cell);
	        		
	        		cell = new PdfPCell (new Paragraph (new Chunk("Name of the Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
	        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
	        		cell.setVerticalAlignment(Element.ALIGN_TOP);
	        	//    cell.setBackgroundColor (new Color (255, 200, 0));
	        		cell.setPadding (2);
	        		cell.setBorder(PdfPCell.NO_BORDER);
	        	//	cell.setBorderColor(new Color(0, 0, 0));
	        		table.addCell(cell);
	        		
	                
	                
	        		cell = new PdfPCell (new Paragraph (new Chunk(": "+industryName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
	        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
	        		cell.setVerticalAlignment(Element.ALIGN_TOP);
	        		//cell.setBackgroundColor (new Color (255, 200, 0));
	        		cell.setPadding (2);
	        		cell.setBorder(PdfPCell.NO_BORDER);
	        		cell.setBorderColor(new Color(0, 0, 0));
	        		table.addCell(cell);
	        		
	        		
				
				//2nd row
	        		

	        		
	        		
		                
		        		cell = new PdfPCell (new Paragraph (new Chunk("2. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
		        	//	cell.setspan (2);
		            //   cell.setRowspan(5);
		        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		        		cell.setVerticalAlignment(Element.ALIGN_TOP);
		        	//	cell.setBackgroundColor (new Color (255, 200, 0));
		        		cell.setPadding (2);
		        		cell.setBorder(PdfPCell.NO_BORDER);
		        	//	cell.setBorderColor(new Color(0, 0, 0));
		        		table.addCell(cell);
		        		
		        		cell = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
		        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		        		cell.setVerticalAlignment(Element.ALIGN_TOP);
		        	//    cell.setBackgroundColor (new Color (255, 200, 0));
		        		cell.setPadding (2);
		        		cell.setBorder(PdfPCell.NO_BORDER);
		        		//cell.setBorderColor(new Color(0, 0, 0));
		        		table.addCell(cell);
		        		
		                
		                
		        		cell = new PdfPCell (new Paragraph (new Chunk(": "+industryAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
		        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		        		cell.setVerticalAlignment(Element.ALIGN_TOP);
		        		//cell.setBackgroundColor (new Color (255, 200, 0));
		        		cell.setPadding (2);
		        		cell.setBorder(PdfPCell.NO_BORDER);
		        		//cell.setBorderColor(new Color(0, 0, 0));
		        		table.addCell(cell);
		        		
				
				//3rd row

			              
			        		cell = new PdfPCell (new Paragraph (new Chunk("3. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
			        	//	cell.setspan (2);
			              // cell.setRowspan(3);
			        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
			        		cell.setVerticalAlignment(Element.ALIGN_TOP);
			        	//	cell.setBackgroundColor (new Color (255, 200, 0));
			        		cell.setPadding (2);
			        		cell.setBorder(PdfPCell.NO_BORDER);
			        	//	cell.setBorderColor(new Color(0, 0, 0));
			        		table.addCell(cell);
			        		
			        		cell = new PdfPCell (new Paragraph (new Chunk("Source", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
			        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
			        		cell.setVerticalAlignment(Element.ALIGN_TOP);
			        	//    cell.setBackgroundColor (new Color (255, 200, 0));
			        		cell.setPadding (2);
			        		cell.setColspan(2);
			        		cell.setBorder(PdfPCell.NO_BORDER);
			        	//	cell.setBorderColor(new Color(0, 0, 0));
			        		table.addCell(cell);
			        		
			        		cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
			        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
			        		cell.setVerticalAlignment(Element.ALIGN_TOP);
			        	//    cell.setBackgroundColor (new Color (255, 200, 0));
			        		cell.setPadding (2);
			        	
			        		cell.setBorder(PdfPCell.NO_BORDER);
			        	//	cell.setBorderColor(new Color(0, 0, 0));
			        		table.addCell(cell);

			        		if(catinst.equals("HOSPITAL")){
			        			
			        			
			        			cell = new PdfPCell(new Paragraph("(a) Number of authorized beds ", new Font(
			        					Font.TIMES_ROMAN, Font.DEFAULTSIZE  , Font.BOLD)));
			        			// cell.setColspan (2);
			        			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        			// cell.setBackgroundColor (new Color (128, 200, 128));
			        			cell.setPadding(5.0f);
			        			cell.setBorder(PdfPCell.NO_BORDER);
			        			table.addCell(cell);
			        			
			        			cell = new PdfPCell(new Paragraph(": "+noOfBeds, new Font(
			        					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        			// cell.setColspan (2);
			        			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        			// cell.setBackgroundColor (new Color (128, 200, 128));
			        			cell.setPadding(5.0f);
			        			cell.setBorder(PdfPCell.NO_BORDER);
			        			table.addCell(cell);	
			        			
			        			cell = new PdfPCell(new Paragraph("", new Font(
			        					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        			// cell.setColspan (2);
			        			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        			// cell.setBackgroundColor (new Color (128, 200, 128));
			        			cell.setPadding(5.0f);
			        			cell.setBorder(PdfPCell.NO_BORDER);
			        			table.addCell(cell);	
			        			
			        			cell = new PdfPCell(new Paragraph("(b) Number of Patients/Samples in a year.", new Font(
			        					Font.TIMES_ROMAN, Font.DEFAULTSIZE  , Font.BOLD)));
			        			// cell.setColspan (2);
			        			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        			// cell.setBackgroundColor (new Color (128, 200, 128));
			        			cell.setPadding(5.0f);
			        			cell.setBorder(PdfPCell.NO_BORDER);
			        			table.addCell(cell);
			        			
			        			cell = new PdfPCell(new Paragraph(": ", new Font(
			        					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        			// cell.setColspan (2);
			        			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        			// cell.setBackgroundColor (new Color (128, 200, 128));
			        			cell.setPadding(5.0f);
			        			cell.setBorder(PdfPCell.NO_BORDER);
			        			table.addCell(cell);	
			        			
			        			
			        			
			        			}
			        			
			        			if(catinst.equals("CLINIC")){
			        				
			        				
			        				cell = new PdfPCell(new Paragraph("(a)Average Number of Patients ", new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);
			        				
			        				cell = new PdfPCell(new Paragraph(": "+noOfPatients, new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);	
			        				
			        				
			        				
			        				
			        				}
			        			
			        			
			        			
			        			else if(catinst.equals("LAB")){
			        		
			        		
			        		cell = new PdfPCell(new Paragraph("(a)Average Number of Samples ", new Font(
			        				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
			        		// cell.setColspan (2);
			        		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        		// cell.setBackgroundColor (new Color (128, 200, 128));
			        		cell.setPadding(5.0f);
			        		cell.setBorder(PdfPCell.NO_BORDER);
			        		table.addCell(cell);
			        		
			        		cell = new PdfPCell(new Paragraph(": "+noOfsamples, new Font(
			        				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        		// cell.setColspan (2);
			        		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        		// cell.setBackgroundColor (new Color (128, 200, 128));
			        		cell.setPadding(5.0f);
			        		cell.setBorder(PdfPCell.NO_BORDER);
			        		table.addCell(cell);	
			        		
			        		
			        		
			        		}
			        			
			        			else if(catinst.equals("BLOOD BANK")){
			        				
			        				
			        				cell = new PdfPCell(new Paragraph("(a)Average Number of Samples ", new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);
			        				
			        				cell = new PdfPCell(new Paragraph(": "+noOfSamples, new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);	
			        				
			        				
			        				
			        				
			        				}
			        			
			        			
			        	else if(catinst.equals("VETERINARY")){
			        				
			        				
			        				cell = new PdfPCell(new Paragraph("(a)Average Number of Patients ", new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);
			        				
			        				cell = new PdfPCell(new Paragraph(": "+noOfpatients, new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);	
			        				
			        				
			        				
			        				
			        				}
			        		
			        		
			        			if(catinst.equals("DENTAL CLINIC")){
			        				
			        				
			        				cell = new PdfPCell(new Paragraph("(a) Number of authorized chairs ", new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);
			        				
			        				cell = new PdfPCell(new Paragraph(": "+noOfchairs, new Font(
			        						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
			        				// cell.setColspan (2);
			        				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        				// cell.setBackgroundColor (new Color (128, 200, 128));
			        				cell.setPadding(5.0f);
			        				cell.setBorder(PdfPCell.NO_BORDER);
			        				table.addCell(cell);	
			        				
			        				
			        				
			        				}
			        	       
						        		cell = new PdfPCell (new Paragraph (new Chunk("4. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
						        	//	cell.setspan (2);
						            //   cell.setRowspan(2);
						        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
						        		cell.setVerticalAlignment(Element.ALIGN_TOP);
						        	//	cell.setBackgroundColor (new Color (255, 200, 0));
						        		cell.setPadding (2);
						        		cell.setBorder(PdfPCell.NO_BORDER);
						        		//cell.setBorderColor(new Color(0, 0, 0));
						        		table.addCell(cell);
						        		
						        		cell = new PdfPCell (new Paragraph (new Chunk("Authorization valid for", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
							          //  cell.setRowspan(2);

						        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
						        		cell.setVerticalAlignment(Element.ALIGN_TOP);
						        	//    cell.setBackgroundColor (new Color (255, 200, 0));
						        		cell.setPadding (2);
						        		cell.setBorder(PdfPCell.NO_BORDER);
						        		//cell.setBorderColor(new Color(0, 0, 0));
						        		table.addCell(cell);
						        		
						                
						                
						        		cell = new PdfPCell (new Paragraph (new Chunk(": "+activityauthorizationsoughtfor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
						        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
						        		cell.setVerticalAlignment(Element.ALIGN_TOP);
						        		//cell.setBackgroundColor (new Color (255, 200, 0));
						        		cell.setPadding (2);
						        		cell.setBorder(PdfPCell.NO_BORDER);
						        		cell.setBorderColor(new Color(0, 0, 0));
						        		table.addCell(cell);
						        		
			      			              
								        		cell = new PdfPCell (new Paragraph (new Chunk("5. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
								        	//	cell.setspan (2);
								            //   cell.setRowspan(5);
								        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
								        		cell.setVerticalAlignment(Element.ALIGN_TOP);
								        	//	cell.setBackgroundColor (new Color (255, 200, 0));
								        		cell.setPadding (2);
								        		cell.setBorder(PdfPCell.NO_BORDER);
								        		cell.setBorderColor(new Color(0, 0, 0));
								        		table.addCell(cell);
								        		
								        		cell = new PdfPCell (new Paragraph (new Chunk("Total Quantity of Waste generated", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
								        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
								        		cell.setVerticalAlignment(Element.ALIGN_TOP);
								        	//    cell.setBackgroundColor (new Color (255, 200, 0));
								        		cell.setPadding (2);
								        	
								        		cell.setBorder(PdfPCell.NO_BORDER);
								        		cell.setBorderColor(new Color(0, 0, 0));
								        		table.addCell(cell);
								        		
								        		cell = new PdfPCell (new Paragraph (new Chunk(": "+sum, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
								        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
								        		cell.setVerticalAlignment(Element.ALIGN_TOP);
								        		//cell.setBackgroundColor (new Color (255, 200, 0));
								        		cell.setPadding (2);
								        		
								        		cell.setBorder(PdfPCell.NO_BORDER);
								        		cell.setBorderColor(new Color(0, 0, 0));
								        		table.addCell(cell);
								                
								        		
									                
									        		cell = new PdfPCell (new Paragraph (new Chunk("6. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
									        	//	cell.setspan (2);
									             //  cell.setRowspan(5);
									        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
									        		cell.setVerticalAlignment(Element.ALIGN_TOP);
									        	//	cell.setBackgroundColor (new Color (255, 200, 0));
									        		cell.setPadding (2);
									        		cell.setBorder(PdfPCell.NO_BORDER);
									        		cell.setBorderColor(new Color(0, 0, 0));
									        		table.addCell(cell);
									        		
									        		cell = new PdfPCell (new Paragraph (new Chunk("Facility provided for disposal of waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
									        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
									        		cell.setVerticalAlignment(Element.ALIGN_TOP);
									        	//    cell.setBackgroundColor (new Color (255, 200, 0));
									        		cell.setPadding (2);
									        		cell.setBorder(PdfPCell.NO_BORDER);
									        		cell.setBorderColor(new Color(0, 0, 0));
									        		table.addCell(cell);
									        		
									                
									                
									        		cell = new PdfPCell (new Paragraph (new Chunk(": "+facility, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
									        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
									        		cell.setVerticalAlignment(Element.ALIGN_TOP);
									        		//cell.setBackgroundColor (new Color (255, 200, 0));
									        		cell.setPadding (2);
									        		cell.setBorder(PdfPCell.NO_BORDER);
									        		cell.setBorderColor(new Color(0, 0, 0));
									        		table.addCell(cell);
									        		
				               
										        	
										        		cell = new PdfPCell (new Paragraph (new Chunk("7. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
											        	//	cell.setspan (2);
											          //     cell.setRowspan(5);
											        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
											        		cell.setVerticalAlignment(Element.ALIGN_TOP);
											        	//	cell.setBackgroundColor (new Color (255, 200, 0));
											        		cell.setPadding (2);
											        		cell.setBorder(PdfPCell.NO_BORDER);
											        		cell.setBorderColor(new Color(0, 0, 0));
											        		table.addCell(cell);
											        		
											        		cell = new PdfPCell (new Paragraph (new Chunk("Authorization extended/granted for a period of", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
											        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
											        		cell.setVerticalAlignment(Element.ALIGN_TOP);
											        	//    cell.setBackgroundColor (new Color (255, 200, 0));
											        		cell.setPadding (2);
											        		cell.setBorder(PdfPCell.NO_BORDER);
											        		cell.setBorderColor(new Color(0, 0, 0));
											        		table.addCell(cell);
											        		
											                
											                
											        		cell = new PdfPCell (new Paragraph (new Chunk(": "+noticeDate +" to "+expiryDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
											        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
											        		cell.setVerticalAlignment(Element.ALIGN_TOP);
											        		//cell.setBackgroundColor (new Color (255, 200, 0));
											        		cell.setPadding (2);
											        		cell.setBorder(PdfPCell.NO_BORDER);
											        		cell.setBorderColor(new Color(0, 0, 0));
											        		table.addCell(cell);
											        				        		
												        		
												        		cell = new PdfPCell (new Paragraph (new Chunk("8. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
													        	//	cell.setspan (2);
													          //     cell.setRowspan(5);
													        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
													        		cell.setVerticalAlignment(Element.ALIGN_TOP);
													        	//	cell.setBackgroundColor (new Color (255, 200, 0));
													        		cell.setPadding (2);
													        		cell.setBorder(PdfPCell.NO_BORDER);
													        		cell.setBorderColor(new Color(0, 0, 0));
													        		table.addCell(cell);
													        		
													        		cell = new PdfPCell (new Paragraph (new Chunk("Name & address of Service Provider with\nwhom agreement is signed by the Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
													        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
													        		cell.setVerticalAlignment(Element.ALIGN_TOP);
													        	//    cell.setBackgroundColor (new Color (255, 200, 0));
													        		cell.setPadding (2);
													        		cell.setBorder(PdfPCell.NO_BORDER);
													        		cell.setBorderColor(new Color(0, 0, 0));
													        		table.addCell(cell);
													        		
													                
													                
													        		cell = new PdfPCell (new Paragraph (new Chunk(": "+serviceProvider, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
													        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
													        		cell.setVerticalAlignment(Element.ALIGN_TOP);
													        		//cell.setBackgroundColor (new Color (255, 200, 0));
													        		cell.setPadding (2);
													        		cell.setBorder(PdfPCell.NO_BORDER);
													        		cell.setBorderColor(new Color(0, 0, 0));
													        		table.addCell(cell);
													        		
													        		
													        		cell = new PdfPCell (new Paragraph (new Chunk("9. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
														        	//	cell.setspan (2);
														          //     cell.setRowspan(5);
														        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
														        		cell.setVerticalAlignment(Element.ALIGN_TOP);
														        	//	cell.setBackgroundColor (new Color (255, 200, 0));
														        		cell.setPadding (2);
														        		cell.setBorder(PdfPCell.NO_BORDER);
														        		cell.setBorderColor(new Color(0, 0, 0));
														        		table.addCell(cell);
														        		
														        		cell = new PdfPCell (new Paragraph (new Chunk("In case of authorization of provider is cancelled then authorization of HCF would automatically stand cancelled without any further notice.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
														        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
														        		cell.setVerticalAlignment(Element.ALIGN_TOP);
														        	//    cell.setBackgroundColor (new Color (255, 200, 0));
														        		cell.setPadding (2);
														        		cell.setBorder(PdfPCell.NO_BORDER);
														        		cell.setBorderColor(new Color(0, 0, 0));
														        		table.addCell(cell);
														        		
														                
														                
														        		cell = new PdfPCell (new Paragraph (new Chunk(": ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL,new Color(0, 0, 0)))));
														        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
														        		cell.setVerticalAlignment(Element.ALIGN_TOP);
														        		//cell.setBackgroundColor (new Color (255, 200, 0));
														        		cell.setPadding (2);
														        		cell.setBorder(PdfPCell.NO_BORDER);
														        		cell.setBorderColor(new Color(0, 0, 0));
														        		table.addCell(cell);
													        		
				
															        		cell = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,new Color(0, 0, 0)))));
															        		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
															        		cell.setVerticalAlignment(Element.ALIGN_TOP);
															        		//cell.setBackgroundColor (new Color (255, 200, 0));
															        		cell.setPadding (2);
															        		cell.setColspan (2);
															        		cell.setBorder(PdfPCell.NO_BORDER);
															        		cell.setBorderColor(new Color(0, 0, 0));
															        		table.addCell(cell);
															        		
															        		
															        		
															        		document.add(table);					      
																		   
																			
																			
																			
																			
																			PdfPTable table2=new PdfPTable(2);
																				
																				float[] columnWidths2 = {7f,3.6f};
																       		    table2.setWidths(columnWidths2);
																				
																				
																				
																				PdfPCell cell2 = new PdfPCell ();
																				
																				
																				
																				
																				
																				cell2 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
																				//cell2.setColspan (2);
																				cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
																				//cell2.setBackgroundColor (new Color(0, 0, 0));
																				cell2.setVerticalAlignment(Element.ALIGN_CENTER);
																                 cell2.setBorder(PdfPCell.NO_BORDER);
																				cell2.setPadding (1.0f);
																				table2.addCell (cell2);

																				
																				cell2 = new PdfPCell (new Paragraph (new Chunk("\n\n\n"+roleName1+"\nJ&K Polution Control Committee\nRegional Office", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.NORMAL,new Color(0, 0, 0)))));
																				cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
																				//cell2.setBackgroundColor (new Color (255, 200, 0));
																				cell2.setPadding (1.0f);
																				cell2.setVerticalAlignment(Element.ALIGN_CENTER);
																				//cell2.setBorder(PdfPCell.NO_BORDER);
																				cell2.setBorder(PdfPCell.NO_BORDER);

																			  //  cell2.setBorder(PdfPCell.NO_BORDER); 
																				//cell2.setBorderColorBottom();
																				table2.addCell (cell2);
																				
																				document.add(table2);
															document.newPage();
															
															Paragraph subHeading1 = new Paragraph();
															subHeading1.add(new Chunk("                                 TERMS & CONDITIONS OF AUTHORISATION:-    ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  , Font.BOLD)));
															
															document.add(subHeading1);
																	
															Paragraph subHeading2 = new Paragraph();
															subHeading2.add(new Chunk(" "+termsco, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  , Font.BOLD)));
															
															document.add(subHeading2);
														
															
															//PdfPTable table1=new PdfPTable(1);

															PdfPTable table3=new PdfPTable(2);
															
															float[] columnWidths3 = {0.40f,8f};
											       		    table3.setWidths(columnWidths3);
															
															  
															
															PdfPCell cell3 = new PdfPCell ();
															

															cell3 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("The applicants shall comply with the provisions of Bio-Medical Waste(Management & Handling) Rules 1998 notified vide No.S.O.\n630(E) dated 20th july,1998", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															//2nd row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Bio-Medical Waste shall be treated & disposed off in Compliance with the standards prescribed in Schedule 1.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															//3rd row
															
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Every occupier where required shall setup in accordance with the time schedule-IV, requisite treatment Bio-Medical Waste treatment\nfacilities like incinerator,autoclave,microwave system for the treatment of the waste at a common waste treatment facility or any other\nwaste treatment facility. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															
															
															//4th row
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Bio-Medical Waste shall not be mixed with any other waste.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															
															
															//5th row
															
															
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Bio-Medical Waste shall be segregated into containers/bags at appoint of generation with Shedule-II prior to its storage, transportion,treatment & disposal.The containers shall be labeled according to Schedule-II", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															
													//6th row
															
															
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("If a container is transported from the premises where Bio-Medical Waste is generated to any waste treatment facility outside the premises where bio-medical waste is generated to any waste treatment facility outside the premises, the container shall apart from the label prescribed in schedule III, also carry information according to Schedule IV.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
														
															//7th row
															
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Notwithstanding anything contains in Motors Vehicle Act, 1995 or rules there under, untreated the Bio-medical Waste shall be transported\nonly in such vehicle as may be authorised for the purpose by the competent authority as specified by the Govt.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															//8th row
															
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("No untreated Bio-Medical Waste Shall be kept stored beyond a period of 48 hours.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
														   cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															//9th row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Every authorised person shall maintain records related to the generation, collection, reception, storage, transportation, treatment\ndisposal or any form of handling of Bio-medical Waste in accordance with those rules & any guideline issued.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
														 	cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															//10th row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("All records shall be subject to inspection & verifications by the prescribed authority at any time.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
														//11th row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Suitably designed pollution control devices should be installed/retrofitted with the incinerator to acheive the above emission limits, if\n necessary.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
														 	cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															
															//12 th row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Waste to be incinarated shall not be chemically treated with any chlorinated disinfectants.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															//13th row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Chlorinated plastics shall not be incinarated.Toxic metals in incinaration ash shall be limited with the regulatory quantities as defined\nunder the Hazardous Waste(Management & Handling) Rules, 1998.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															//14 th row
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("14.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Only low sulphur fuel like L.D.O/L.S.H.S/Deisel shall be used as fuel in the incinarator.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															
															
															//25 row
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("15.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("Occupier will comply all direction for generation, collection, reception, storage, transportation, treatment, disposal & handling as per\nBio-MedicalWaste(Management & Handling) Rules 1998 & will ensure that there is no adverse effect to human & Environment.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															//26 row
															cell3 = new PdfPCell (new Paragraph (new Chunk("16.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("The occupier will segregate the Bio-Medical Waste at the point of generation in accordance with the special-II of Bio-Medical Waste\n(Management & Handling) Rules, 1998.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															//27 row
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("17.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("The authorization would be subject/having proper disposal system for Bio-Medical Waste.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															//28 row
															cell3 = new PdfPCell (new Paragraph (new Chunk("18.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															cell3 = new PdfPCell (new Paragraph (new Chunk("The unit shall maintained a log Book for suggestion/collection of Bio-Medical Waste at the source (i.e.wards) and also for each\ncategory of waste i.e.incienaration, autoclaving or landfill etc. ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
													    	cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															//29 row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("19.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("The yellow Bags should be non chlorine bags.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
											cell3.setBorder(PdfPCell.NO_BORDER);
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															//30 row
															
															
															cell3 = new PdfPCell (new Paragraph (new Chunk("20.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE  , Font.BOLD,new Color(0,0,0)))));
															//cell3.setColspan (2);
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color(0, 0, 0));
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
											                 cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setPadding (1.0f);
															table3.addCell (cell3);

															
															cell3 = new PdfPCell (new Paragraph (new Chunk("The  every occupier will also submit the copy of agreement every year before 30th April from any authorised services provider.\n\n\n\n\n", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD,new Color(0, 0, 0)))));
															cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
															//cell3.setBackgroundColor (new Color (255, 200, 0));
															cell3.setPadding (1.0f);
															cell3.setVerticalAlignment(Element.ALIGN_CENTER);
															//cell3.setBorder(PdfPCell.NO_BORDER);
															cell3.setBorder(PdfPCell.NO_BORDER);

														    cell3.setBorder(PdfPCell.NO_BORDER); 
															//cell3.setBorderColorBottom();
															table3.addCell (cell3);
															
															
															document.add(table3);
															
															
															Paragraph para44 = new Paragraph();
															para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															para44.add(new Chunk("Specific Deficiencies:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
															
															para44.add(list);
															para44.setAlignment(Element.ALIGN_JUSTIFIED);
															para44.setIndentationLeft(45);
															document.add(para44);
						        		
											 		
															
																
																	document.add(table2);
										      
																
																				
															
															
															
															
															
															
															
															
															
													      
				
		
		document.close();
			
			}catch (Exception e) {
			e.printStackTrace();
			}
		
    	return tempFile;
		}
	



}

	
	
	
}