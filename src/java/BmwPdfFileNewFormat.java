import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class BmwPdfFileNewFormat {

     
	 public File bmwPdfFunction(String applicantName,String applicantDesignation,String instutionName,String addressOfInd,String phnCodeOfInd,String phnOfInd,String mobileNo,String emailOfInd,String authorisationFor,String appliedFor,
			String hcfType,String wasteFacilityStatus,String officeAddress,String wasteLocationAddress,String placeOfDisposal,String statusCteCto,String lat,String longt,String detailsOfDirections,String outpatientsFacility,String inpatientsFacility,String noofbeds,
			String noOfNonBeds,String noOfInOutPatients,String NoofHCF,String noOfBedsCbmwtf,String treatmentAndDisposal,
			String qtyOfBmwTreated,String Jurisdictionalarea,String contingencyPlan,String anatomicalwaste,String animalwaste,String soiledwaste,String discardedwaste,String chemicalSolidWaste,String chemicalLiquidWaste,
			String discardedLinen,String otherClininLabWaste,String contaminatedwaste,String wasteSharps,String glassWare,String metallicBodyImplants,String total1
			,String incinrators,String incinratorsType,String plasmaPyrolysis,String plasmaPyrolysisType,String autoclaves,String autoclavesType,String microwave,String microwaveType,String hydroclave,String hydroclaveType,String shredders,String shreddersType,String needleTipCutter
			,String needleTipCutterType,String sharpEncapsulation,String sharpEncapsulationType,String deepBurial,String deepBurialType,String chemDisinfection,String chemDisinfectionType,String anyOtherTretmntEquip,String anyOtherTretmntEquipType,String roleNameForpdf,ArrayList listDocuments,ArrayList hwPreviousAuthDetails,String BMWApplicationDate, String jurisdictionOfficeName ,ArrayList feeList,long ApplicationNo,ArrayList onlineFee)
	{

		java.util.Date date = new java.util.Date();
		int year = date.getYear();
		if (year < 1000)
			year += 1900;
		int day = date.getDate();
		int month = (date.getMonth()) + 1;

		File tempFile = new File("BmwForm.pdf");
	  {
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
		       
		      //For New Heading
				Paragraph heading1 = new Paragraph();
				heading1.add(new Chunk("FORM II", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
				heading1.setAlignment(Element.ALIGN_CENTER);
			    document.add(heading1);
				
			  //For New Heading
				Paragraph heading2 = new Paragraph();
				heading2.add(new Chunk("(See Rule 10)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
				heading2.setAlignment(Element.ALIGN_CENTER);
			    document.add(heading2);
			    
			  //For New Heading
				Paragraph heading3 = new Paragraph();
				heading3.add(new Chunk("APPLICATION FOR AUTHORIZATION OR RENEWEL OF AUTHORISATION ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
				heading3.setAlignment(Element.ALIGN_CENTER);
			    document.add(heading3);
			    
			    Paragraph heading4 = new Paragraph();
				heading4.add(new Chunk("(To be submitted by occupier of Health Care Facility or Common Bio-Medical Waste Treatment Facility)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
				heading4.setAlignment(Element.ALIGN_CENTER);
			    document.add(heading4);
			    
			    document.add(space);
			    
			    Paragraph heading5 = new Paragraph();
				heading5.add(new Chunk("To", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
				heading5.setAlignment(Element.ALIGN_LEFT);
			    document.add(heading5);
			    
			    Paragraph heading6 = new Paragraph();
				heading6.add(new Chunk("The Regional Director,\n Pollution Control Committee,JAMMU & KASHMIR "+jurisdictionOfficeName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
				heading6.setAlignment(Element.ALIGN_LEFT);
			    document.add(heading6);

			    document.add(space);
			    Paragraph sir1 = new Paragraph();
				sir1.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.NORMAL)));
				sir1.setAlignment(Element.ALIGN_LEFT);
				document.add(sir1);
				document.add(space);

				Paragraph sir = new Paragraph();
				sir.add(new Chunk("I/We hereby, apply for obtaining,", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
				sir.setAlignment(Element.ALIGN_LEFT);
				document.add(sir);
				document.add(space);
			    
				Paragraph sirb11 = new Paragraph();
				sirb11
						.add(new Chunk(
								"I. Authorization/renewal of authorization under BioMedical Wastes Rules,2016-EoDB reg.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
										Font.NORMAL)));
				sirb11.setAlignment(Element.ALIGN_LEFT);
				document.add(sirb11);

				document.add(space);
//			    Paragraph heading7 = new Paragraph();
//			    heading7.add(new Chunk(jurisdictionOfficeName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
//			    heading7.setAlignment(Element.ALIGN_LEFT);
//			    document.add(heading7);
			    
			   /* Paragraph heading7 = new Paragraph();
				heading7.add(new Chunk("Xxxxx  (Office address)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
				heading7.setAlignment(Element.ALIGN_LEFT);
			    document.add(heading7);*/
			    
			    document.add(space);
			    
			    PdfPTable table=new PdfPTable(4);
			    // To define width of table
			    float[] columnWidths = {0.3f,2f,0.1f,2f};
				table.setWidths(columnWidths);
				table.setWidthPercentage(100);		
				PdfPCell cell = new PdfPCell ();
				
				cell = new PdfPCell (new Paragraph (new Chunk("1", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Particulars of the applicant:", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				cell.setColspan(3);
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("i)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Name of the applicant", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(applicantName, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0, 0, 0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Designation", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(applicantDesignation, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("ii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Name of the Institution", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(instutionName, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Address for correspondence", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(addressOfInd, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Landline phone No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(phnCodeOfInd+"-"+phnOfInd, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				// added by sharvan for mobile no. start from here
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Mobile No.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(mobileNo, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				//ends here 
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("E-mail Id", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(emailOfInd, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Application No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(String.valueOf(ApplicationNo), new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("2", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Activity for which authorisation is sought:", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				cell.setColspan(3);
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(authorisationFor, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				cell.setColspan(3);
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("3 i)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Authorization now Applied For :", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(appliedFor, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
	
	
				// added by sharvan start
				cell = new PdfPCell (new Paragraph (new Chunk("3 ii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Previous Authorization Details :", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				if(appliedFor.equalsIgnoreCase("Renewal"))
				{
					
				PdfPTable table691 = new PdfPTable(5);
		        PdfPCell cell691 = new PdfPCell();
				float[] columnWidths911 = new float[] {3f, 3f, 3f, 3f, 3f};
				table691.setWidths(columnWidths911);
				table691.setWidthPercentage(100);
					
				
				cell691 = new PdfPCell(new Paragraph(new Chunk("Date of Application for BMWA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
				cell691.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell691.setPadding(3.0f);
				table691.addCell(cell691);
		        
				cell691 = new PdfPCell(new Paragraph(new Chunk("BMWA Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
				cell691.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell691.setPadding(3.0f);
				table691.addCell(cell691);
				
				cell691 = new PdfPCell(new Paragraph(new Chunk("Authorisation No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
				cell691.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell691.setPadding(3.0f);
				table691.addCell(cell691);
				
				cell691 = new PdfPCell(new Paragraph(new Chunk("Issued date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
				cell691.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell691.setPadding(3.0f);
				table691.addCell(cell691);
				
				cell691 = new PdfPCell(new Paragraph(new Chunk("Valid date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
				cell691.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell691.setPadding(3.0f);
				table691.addCell(cell691);
				
				for(int var34=0;var34<hwPreviousAuthDetails.size();var34++)
				{
					ArrayList al=(ArrayList) hwPreviousAuthDetails.get(var34);
					for(int var35=0;var35<al.size();var35++)
					{
						String a=(String) al.get(var35);
						cell691 = new PdfPCell (new Paragraph(new Chunk(" "+a, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 1, Font.NORMAL,new Color(0,0,0)))));
						cell691.setPadding (3.0f);
						table691.addCell (cell691);
				}
				}

		        cell =  new PdfPCell();
				cell.addElement(table691);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setColspan(4);
				cell.setBorder(PdfPCell.NO_BORDER);
				table.addCell(cell);
				
				}

				
				//added by sharvan end
				
				// added by sharvan start for new changes
				cell = new PdfPCell (new Paragraph (new Chunk("iii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Status of CTE/CTO-latest consent type, issued date and validity date ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(statusCteCto, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				
				cell = new PdfPCell (new Paragraph (new Chunk("iv)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				cell.setRowspan(2);
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("GPS Coordinates- Lat/Lon of the location of applicant facility(In decimal degress with 6 decimals) ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setRowspan(2);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Latitude:  "+lat+" (N Decimal degrees)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Longitude:  "+longt+" (E Decimal degrees)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("4 i)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("BMW Facility Type ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(hcfType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				
				
				////////////////////////
				
				
				cell = new PdfPCell (new Paragraph (new Chunk(" ii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("BMW Facility Status ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(wasteFacilityStatus, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("iii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Address of the location of Health Care Facility or CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(addressOfInd, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("iv)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(" CBMWTF-Office and location address of treatment and disposal ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(officeAddress+" /\n "+wasteLocationAddress, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				if(hcfType.equalsIgnoreCase("HCF")){
				
				cell = new PdfPCell (new Paragraph (new Chunk("5)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Details of HCF ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setColspan(3);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("i)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Medical Treatment Facility provided to Outpatients", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
		
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(outpatientsFacility, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("ii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Medical Treatment Facility provided to Inpatients", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
		
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(inpatientsFacility, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("iii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("No of Beds", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
		
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(noofbeds, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("iv)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("For Non bedded Hospital (Specify)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
		
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(noOfNonBeds, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("v)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Total number of inpatients & outpatients treated per month in the HCF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
		
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(noOfInOutPatients, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				}else{
					
					cell = new PdfPCell (new Paragraph (new Chunk("5)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("Details of CBMWTF: ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setColspan(3);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("i)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("No of HCFs covered by the CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(NoofHCF, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("ii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("No of beds covered by the CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(noOfBedsCbmwtf, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("iii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("Installed treatment and disposal capacity of CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(treatmentAndDisposal+" Kg/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("iv)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("Quantity of BMW treated or disposed by CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(qtyOfBmwTreated+" Kg/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					
					cell = new PdfPCell (new Paragraph (new Chunk("v)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("Jurisdictional area and distance covered by the CBMWTF ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(Jurisdictionalarea, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("vi)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("Contingency (future upgradation) plan of CBMWTF ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(contingencyPlan, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
			
					
				}
				
				
				//screen 3 table start from here added by sharvan for new changes 
				
				cell = new PdfPCell (new Paragraph (new Chunk("vii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Quantity of BMW handled, treated or disposed:", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setColspan(3);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				
				 PdfPTable table3=new PdfPTable(4);	
				 table3.setWidthPercentage(95);
				 float[] columnWidths11 = {0.5f,1.5f,1f,2f};
					table3.setWidths(columnWidths11);
					PdfPCell cell3 = new PdfPCell();
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Category", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Type of Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Quantity Generated or collected in Kg/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Method of Treatment and Disposal as per Schedule-I", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Yellow", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setRowspan(8);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("a) Human Anatomical Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(anatomicalwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("b) Animal Anatomical Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(animalwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("c) Soiled Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(soiledwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("d)Expired or Discarded Medicines", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(discardedwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("e)Chemical Solid Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(chemicalSolidWaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);

					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("f) Chemical Liquid Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(chemicalLiquidWaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Onsite ETP to treat and conform to the discharge standards", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("g)Discarded linen, mattresses, beddings contaminated with blood or body fluid ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(discardedLinen, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Disinfection followed by  Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("h) Microbiology,  Biotechnology and other clinical laboratory waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(otherClininLabWaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Sterilisation followed by  Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					////////////table 3 ended here
					
//					PdfPTable tableRed=new PdfPTable(4);	
//					tableRed.setWidthPercentage(95);
//					 float[] columnWidths11Red = {0.5f,1.5f,1f,2f};
//						table3.setWidths(columnWidths11Red);
//						PdfPCell cell3Red = new PdfPCell();
					
					
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Red", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Contaminated waste (Recyclable)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(contaminatedwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Autoclaving followed by shredding. Treated waste to be sent to Authorised recyclers or for energy recovery or plastic to Diesel or fuel oil or for road making", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("White(Translucent)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Waste sharps including Metals", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk(wasteSharps, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
					cell3 = new PdfPCell (new Paragraph (new Chunk("Autoclaving followed by shredding. Treated waste to be sent to Iron foundries or sanitary landfill or designated concrete waste sharp pit.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3.setPadding (3.0f);
					cell3.setBorderColor(new Color(0,0,0));
					table3.addCell (cell3);
					
					
//					PdfPTable table4=new PdfPTable(6);	
//					 table4.setWidthPercentage(95);
//					 float[] columnWidths111 = {0.2f,1.6f,0.6f,0.6f,0.4f,0.6f};
//						table4.setWidths(columnWidths111);
//						PdfPCell cell4 = new PdfPCell();
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("7", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Solid Waste*(Waste generated from disposable items other than sharps such as tubings catheters, intravenous sets, etc.)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk(solidwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Chemical Disinfection,Autoclaving and shredding", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
					
					PdfPTable tableRed=new PdfPTable(4);	
					tableRed.setWidthPercentage(95);
					 float[] columnWidths11Red = {0.5f,1.5f,1f,2f};
					 tableRed.setWidths(columnWidths11Red);
						PdfPCell cell3Red = new PdfPCell();
					
					
					
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("Blue", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setRowspan(2);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("Glassware", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk(glassWare, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("Disinfection or  Autoclaving or microwaving or hydroclaving and then sent for recycling", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("Metallic Body Implants", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk(metallicBodyImplants, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);

					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("Total", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk(total1+" Kg/Day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					cell3Red = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell3Red.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell3Red.setPadding (3.0f);
					cell3Red.setBorderColor(new Color(0,0,0));
					tableRed.addCell (cell3Red);
					
					cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell =  new PdfPCell();
			        cell.addElement(table3);
			        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        cell.setColspan(3);
			        cell.setBorderColor(new Color(0,0,0));
					table.addCell(cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell =  new PdfPCell();
			        cell.addElement(tableRed);
			        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        cell.setColspan(3);
			        cell.setBorderColor(new Color(0,0,0));
					table.addCell(cell);
					
//					cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//					cell.setPadding (3.0f);
//					cell.setVerticalAlignment(Element.ALIGN_CENTER);
//					cell.setBorderColor(new Color(0,0,0));
//					table.addCell (cell);
				
				
				//////////////////////////////////screen 3 table ends here
				
				
				cell = new PdfPCell (new Paragraph (new Chunk("6i)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Mode of Transportation of BMW ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Common Facility Vehicle", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("ii)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Details of Treatment equipments available for treatment of BMW: ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setColspan(3);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				
				PdfPTable table31=new PdfPTable(4);	
				table31.setWidthPercentage(95);
				 float[] columnWidths113 = {0.3f,1.2f,0.6f,2f};
				 table31.setWidths(columnWidths113);
					PdfPCell cell31 = new PdfPCell();
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Sl No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Treatment equipment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("No of units", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Type and capacity of each unit", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("1", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Incinerators", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(incinrators, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(incinratorsType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);

				

					cell31 = new PdfPCell (new Paragraph (new Chunk("2", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Plasma Pyrolysis", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(plasmaPyrolysis, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(plasmaPyrolysisType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("3", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Autoclaves", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(autoclaves, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(autoclavesType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("4", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Microwave", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(microwave, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(microwaveType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("5", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Hydroclave", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(hydroclave, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(hydroclaveType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("5", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Hydroclave", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(hydroclave, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(hydroclaveType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("6", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Shredders", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(shredders, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(shreddersType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("7", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Needle tip cutter or destroyer", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(needleTipCutter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(needleTipCutterType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("8", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Sharp encapsulation or Concrete pit", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(sharpEncapsulation, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(sharpEncapsulationType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
				
					cell31 = new PdfPCell (new Paragraph (new Chunk("9", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Deep burial pits", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(deepBurial, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(deepBurialType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);	
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("10", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Chemical disinfection", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(chemDisinfection, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(chemDisinfectionType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);	
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("11", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk("Any other treatment equipment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(anyOtherTretmntEquip, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell31 = new PdfPCell (new Paragraph (new Chunk(anyOtherTretmntEquipType, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell31.setPadding (3.0f);
					cell31.setBorderColor(new Color(0,0,0));
					table31.addCell (cell31);
					
					cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
				
					cell =  new PdfPCell();
			        cell.addElement(table31);
			        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			        cell.setBorderColor(new Color(0,0,0));
			        cell.setColspan(3);
					table.addCell(cell);
				
					
					
					
					
//				 PdfPTable table33=new PdfPTable(4);	
//				 table3.setWidthPercentage(95);
//				 float[] columnWidths111 = {0.2f,1.6f,0.6f,0.6f,0.4f,0.6f};
//					table3.setWidths(columnWidths111);
//					PdfPCell cell33 = new PdfPCell();
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Category", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Type of Waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Quantity handled in Kg/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Quantity handled in Kg/Month", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Treatment and Disposal", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Treatment and Disposal options as per BMW Rules", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("1", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Human Anatomical Waste*(Human tissues, organs, body parts)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk(anatomicalwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("2", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Animal Waste*(Animal tissues,organs,body parts carcasses,bleeding parts,fluid,blood and experimental animals used in research,waste generated by veterinary hospitals colleges,discharge from hospitals, animals houses).", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk(animalwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("3", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Microbiology & Biotechnology Waste*(Wastes from lab. Cultures,stocks of specimens of micro-organisms live or attenuated vaccines,human and animal incineration* cell culture used in research and infectious agents from research and industrial laboratories, wastes from production of biologicals, toxins, dishes and devices sued for transfer of cultures)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Chemical disinfection/ Autoclaving followed by Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("4", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Waste Sharps *Needles,syringes,scalpels,blades,glass etc. that may cause puncture and cuts.This includes both used and unused sharps)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Chemical disinfection/Autoclaving followed by shredding", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("5", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Discarded Medicines & Cytotoxic drugs*(Wastes comprising of outdated contaminated and discarded medicines)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk(discardedwaste, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration and dedicated SLF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("6", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Soiled Waste*(Items contaminated with blood,and body fluids including cotton, dressing,soiled plaster casts,lines,beddings,other material contaminated with blood)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					cell3 = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell3.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell3.setPadding (3.0f);
//					cell3.setBorderColor(new Color(0,0,0));
//					table3.addCell (cell3);
//					
//					PdfPTable table4=new PdfPTable(4);	
//					 table4.setWidthPercentage(95);
//					 float[] columnWidths112 = {0.2f,1f,0.6f,2f,0.4f,0.6f};
//						table4.setWidths(columnWidths112);
//						PdfPCell cell4 = new PdfPCell();
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("7", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Solid Waste*(Waste generated from disposable items other than sharps such as tubings catheters, intravenous sets, etc.)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("CBMWTF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Chemical Disinfection,Autoclaving and shredding", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("8", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Liquid Waste*(Waste generated from laboratory and washing,cleaning house-keeping and disinfecting activities) in KLD", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					/*cell4 = new PdfPCell (new Paragraph (new Chunk(liquidwaste1, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);*/
//					
//					
//					/////////////added by sharvan start//////////////
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					///////////////////////////////////////////
//					
//
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Onsite ETP/Chemical treatment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("9", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Incineration Ash*(Ash from incineration of any bio-medical waste)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Does not arise", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Dedicated SLF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("10", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Chemical Waste*(Chemical used in production of biological, chemicals used in insecticides etc.)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Onsite ETP/Chemical treatment/Dedicated SLF", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("Total", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk(total1+" Kg/Day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk(""+" Kg/Month", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell4 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell4.setPadding (3.0f);
//					cell4.setBorderColor(new Color(0,0,0));
//					table4.addCell (cell4);
//					
//					cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//					cell.setPadding (3.0f);
//					cell.setVerticalAlignment(Element.ALIGN_CENTER);
//					cell.setBorderColor(new Color(0,0,0));
//					table.addCell (cell);
//					
//					cell =  new PdfPCell();
//			        cell.addElement(table3);
//			        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			        cell.setColspan(3);
//			        cell.setBorderColor(new Color(0,0,0));
//					table.addCell(cell);
//					
//					cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
//					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//					cell.setPadding (3.0f);
//					cell.setVerticalAlignment(Element.ALIGN_CENTER);
//					cell.setBorderColor(new Color(0,0,0));
//					table.addCell (cell);
//				
//					cell =  new PdfPCell();
//			        cell.addElement(table4);
//			        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			        cell.setBorderColor(new Color(0,0,0));
//			        cell.setColspan(3);
//					table.addCell(cell);
				
				
					cell = new PdfPCell (new Paragraph (new Chunk("7", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk("Details of directions or notices or legal actions if any during the period of earlier authorisation", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setBorderColor(new Color(0,0,0));
					//cell.setColspan(3);
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(":", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
					cell.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell.setPadding (3.0f);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					cell = new PdfPCell (new Paragraph (new Chunk(detailsOfDirections, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
					cell.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell.setPadding (3.0f);
					cell.setColspan(3);
					cell.setBorderColor(new Color(0,0,0));
					table.addCell (cell);
					
					
				
				cell = new PdfPCell (new Paragraph (new Chunk("8", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("Declaration", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setBorderColor(new Color(0,0,0));
				cell.setColspan(3);
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0)))));
				cell.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell.setPadding (3.0f);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
				cell = new PdfPCell (new Paragraph (new Chunk("     I do hereby declare that the statements made and information given above is true to the best of my knowledge and belief and that I have not concealed any information.\n  \t  I do also hereby undertake to provide any further information sought by the prescribed Authority in relation to these rules and to fulfil any conditions stipulated by the prescribed Authority.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0) ))));
				cell.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell.setPadding (3.0f);
				cell.setColspan(3);
				cell.setBorderColor(new Color(0,0,0));
				table.addCell (cell);
				
								
				document.add(table);
			    
				  document.add(space); 
				  if(feeList.size()>0){
				  Paragraph partCb1a17 = new Paragraph();
					partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
							"\nType of Consent:-",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a17.setAlignment(Element.ALIGN_LEFT);
					document.add(partCb1a17);
					document.add(space);
					
					PdfPTable tableFees = new PdfPTable(5);
					PdfPCell cellFees = new PdfPCell();
					tableFees.setWidthPercentage(100);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk(
							"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);
					System.out.println("--feee list --"+feeList.size());

					for (int var2 = 0; var2 < feeList.size(); var2++) {
						ArrayList feeList1 = (ArrayList) feeList.get(var2);

						for (int var3 = 0; var3 < feeList1.size(); var3++) {

							String feeInner = (String) feeList1.get(var3);
							cellFees = new PdfPCell(new Paragraph(feeInner));
							cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
							cellFees.setPadding(5.0f);
							tableFees.addCell(cellFees);
						}}		
					document.add(tableFees);
				  } else if(onlineFee.size()>0){
					 System.out.println("--in online pdf--");
					  Paragraph partCb1a00223 = new Paragraph();
					  partCb1a00223.add(new Chunk("Details of the Consent Online Fee Paid: "
								,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					  	partCb1a00223.setAlignment(Element.ALIGN_LEFT);
						document.add(partCb1a00223);
						document.add(space);
						
						PdfPTable tableFees1 = new PdfPTable(4);
						PdfPCell cellFees1 = new PdfPCell();
						tableFees1.setWidthPercentage(100);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Id", new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk("Payment Date",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk(
								"Ammount", new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Status", new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						System.out.println("--online feee list --"+onlineFee.size()+"-----------------"+onlineFee.get(0).toString());

						for (int var22 = 0; var22 < onlineFee.size(); var22++) {
							ArrayList feeList11 = (ArrayList)onlineFee.get(var22);

							for (int var33 = 0; var33 < feeList11.size(); var33++) {

								String feeInner1 = (String)feeList11.get(var33);
								System.out.println("------------"+feeInner1);
								cellFees1 = new PdfPCell(new Paragraph(feeInner1));
								cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
								cellFees1.setPadding(5.0f);
								tableFees1.addCell(cellFees1);
							}}		
						document.add(tableFees1);
				  }
					document.add(space);

					Paragraph heading19 = new Paragraph();
					heading19.add(new Chunk(" Date: "+BMWApplicationDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
					heading19.setAlignment(Element.ALIGN_LEFT);
					document.add(heading19);
				  
					PdfPTable table1=new PdfPTable(2);
					table.setWidthPercentage(100);		
					PdfPCell cell1 = new PdfPCell();
					
					cell1 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell1.setPadding (3.0f);
					cell1.setBorder(PdfPCell.NO_BORDER);
					table1.addCell (cell1);
					
//
//					cell1 = new PdfPCell (new Paragraph (new Chunk(BMWApplicationDate, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
//					cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
//					cell1.setPadding (3.0f);
//					cell1.setBorder(PdfPCell.NO_BORDER);
//					table1.addCell (cell1);
					
					cell1 = new PdfPCell (new Paragraph (new Chunk("Signature of the applicant", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
					cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell1.setPadding (3.0f);
					cell1.setBorder(PdfPCell.NO_BORDER);
					table1.addCell (cell1);
				  
					cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell1.setPadding (3.0f);
					cell1.setBorder(PdfPCell.NO_BORDER);
					table1.addCell (cell1);
					
					cell1 = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
					cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell1.setPadding (3.0f);
					cell1.setBorder(PdfPCell.NO_BORDER);
					table1.addCell (cell1);
				  
					cell1 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0)))));
					//cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell1.setPadding (3.0f);
					cell1.setBorder(PdfPCell.NO_BORDER);
					table1.addCell (cell1);
					
					cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0) ))));
					cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell1.setPadding (3.0f);
					cell1.setBorder(PdfPCell.NO_BORDER);
					table1.addCell (cell1);
					
					document.add(table1);
					
					/*Paragraph heading8 = new Paragraph();
					heading8.add(new Chunk("List of attachments made in the document tab has to come here as enclosures.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
					heading8.setAlignment(Element.ALIGN_LEFT);
				    document.add(heading8);*/
					
					
					
					 Paragraph heading9 = new Paragraph();
					 heading9.add(new Chunk(" Enclosures:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
					 heading9.setAlignment(Element.ALIGN_LEFT);
					 document.add(heading9);
					    
					int count = 1;
					for(int var2=0;var2<listDocuments.size();var2++)
					{
					ArrayList al=(ArrayList) listDocuments.get(var2);
					
					for(int var3=0;var3<al.size();var3++)
					{
						String a=(String) al.get(var3);
						System.out.println("iiiii"+"  :-   "+var3);
						System.out.println(count+" "+a);
						
						Paragraph documents = new Paragraph();
						documents.add(new Chunk(+count+".  "+a+"     ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1)));
						documents.add(new Chunk("  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1)));
						count = count + 1;

					
					document.add(documents);

					}
					
					}	
					
					
					
				document.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
					
				}
		    	return tempFile;

			}	
		}
}

		