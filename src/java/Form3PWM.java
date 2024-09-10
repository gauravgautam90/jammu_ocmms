import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Form3PWM {

	public File form3PWMPdfFunction(String unitName,String applicantName,String applicantDesignation,String factoryPostalAddress,String occupierTel
			,String occupierTelCode,String occupierEmail,String yearOfCommencement,String capitalInvestment,String numOfEmployee,String dateOfWater,String dateOfAir,String dateOfAuthorization,String manuCapacity,String authorizationRequiredFor,
			String isUnitRegistered,String unitLocation,String thiknessRulz,String waterAct,String airAct,String actionPlan,String detailsDisposalFacility,
			String namePlastic,String quantityPlastic,String occupationalFacilities,String emmisionEffulant,String emmisionEffulantDetails,String unitCompliance,
			String materialProceed,String materialHandled,String otherInfor,String enclosureDetailing,String DistrictPlan1,
			String Manufacturing1,String Collection1,String analysis1,String enclosure1,String consentWater1,String consentAir1,
			String personalBrand1,String supplyingPlastic1,String producersQuantum1,ArrayList productDetailsInstance,ArrayList productDetailsInstance1,
			ArrayList byProductDetails,ArrayList rawMaterials,ArrayList manufactureProcess,ArrayList solidWasteReject,
			ArrayList disposalDetails,ArrayList generationDetails,ArrayList PWMPreviousAuthorisationDetailsInstance,String indTaluk,String indVillage,String indDistrict,String indPincode) throws Exception
	{
		File tempFile = new File("hi.pdf");
		System.out.println("Form1 pwm Java Class");

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase headerPhrase = new Phrase("");
		HeaderFooter header = new HeaderFooter(headerPhrase, true);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(header);

		Phrase footerPhrase = new Phrase(
				"----This is computer generated application -----",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2));
		HeaderFooter footer = new HeaderFooter(footerPhrase, false);

		footer.setAlignment(HeaderFooter.ALIGN_CENTER);
		footer.setBorder(Rectangle.NO_BORDER);
		document.setFooter(footer);

		document.open();


		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ",
				new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD)));
		space.setAlignment(Element.ALIGN_CENTER);
		document.add(space);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("FORM - III",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk("[See Rules 13(4)]", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"APPLICATION FOR REGISTRATION FOR MANUFACTURERS OF PLASTIC RAW MATERIALS",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.UNDERLINE)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("From", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk(unitName+"\n"+factoryPostalAddress+","+indTaluk+","+indVillage+"\n"+indDistrict+" - "+indPincode, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("To,", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk(
				"The Member Secretary,\n J&K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("Sir, ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"      I/We hereby apply for registration under the Plastic Waste Management Rules, 2016.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("PART - A\n GENERAL", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table2 = new PdfPTable(3);
		float[] columnWidths2 = new float[] { 1f, 10f, 8f };
		table2.setWidths(columnWidths2);
		table2.setWidthPercentage(100);

		

		heading = new Paragraph("1(a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell2 = new PdfPCell(heading);
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Name and location of the unit ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(unitName+", "+unitLocation, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Address of the unit",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(factoryPostalAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"In case of renewal, previous registration number and date of registration ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		PdfPTable table691 = new PdfPTable(5);
        PdfPCell cell691 = new PdfPCell();
		float[] columnWidths911 = new float[] {3f, 3f, 3f, 3f, 3f};
		table691.setWidths(columnWidths911);
		table691.setWidthPercentage(100);
			
		
		cell691 = new PdfPCell(new Paragraph(new Chunk("Date of Application for PWMA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		cell691.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell691.setPadding(3.0f);
		table691.addCell(cell691);
        
		cell691 = new PdfPCell(new Paragraph(new Chunk("PWMA Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
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
		
		for(int var34=0;var34<PWMPreviousAuthorisationDetailsInstance.size();var34++)
		{
			ArrayList al=(ArrayList) PWMPreviousAuthorisationDetailsInstance.get(var34);
			for(int var35=0;var35<al.size();var35++)
			{
				String a=(String) al.get(var35);
				cell691 = new PdfPCell (new Paragraph(new Chunk(" "+a, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 1, Font.NORMAL,new Color(0,0,0)))));
				cell691.setPadding (3.0f);
				table691.addCell (cell691);
		}
		}

		cell2 =  new PdfPCell();
		cell2.addElement(table691);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setColspan(4);
		cell2.setBorder(PdfPCell.NO_BORDER);
		table2.addCell(cell2);

		heading = new Paragraph("2", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Is the unit registered with the DIC or DCSSI of the State Government or Union Territory? If yes, attach a copy", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(isUnitRegistered+"\n"+DistrictPlan1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("3(a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Total capital invested on the project", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(capitalInvestment, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Year of commencement of production", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(yearOfCommencement, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("List of producers and quantum of raw materials supplied to producers ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(producersQuantum1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		document.add(table2);
		document.add(space);
		document.add(space);

		table2 = new PdfPTable(2);
		table2.setWidthPercentage(100);

		cell2 = new PdfPCell(new Paragraph(new Chunk("Place:", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		cell2.setBorder(PdfPCell.NO_BORDER);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Paragraph(new Chunk(
				"Signature of the Applicant", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE, Font.BOLD))));
		cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell2.setPadding(3.0f);
		cell2.setBorder(PdfPCell.NO_BORDER);
		table2.addCell(cell2);

		cell2 = new PdfPCell(new Paragraph(new Chunk("Date: ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell2.setPadding(3.0f);
		cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		table2.addCell(cell2);

		
		
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Name and Designation\n"+unitName+"\n"+factoryPostalAddress+","+indTaluk+""+indVillage+"\n"+indDistrict+" - "+indPincode,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell2.setPadding(3.0f);
		cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table2.addCell(cell2);

		document.add(table2);
		document.add(space);
		

		document.close();
	
		return tempFile;
	}
	
}
