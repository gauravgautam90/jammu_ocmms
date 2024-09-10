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


public class Form2PWM {

	public File form2PWMPdfFunction(String unitName,String applicantName,String applicantDesignation,String factoryPostalAddress,String occupierTel
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
		heading.add(new Chunk("FORM - I",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk("[See Rules 13(2)]", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"APPLICATION FOR REGISTRATION FOR PRODUCERS OR BRAND OWNERS",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.UNDERLINE)));
		heading.setAlignment(Element.ALIGN_CENTER);
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

		// heading= new Paragraph();
		// heading.add(new Chunk(districtOffice+"(District Office).", new
		// Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		// heading.setAlignment(Element.ALIGN_LEFT);
		// document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"      I/We hereby apply for registration under Rule 9 of the Plastic Waste Management Rules, 2016.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);

		


		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("I. Producers", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_LEFT);
		document.add(heading1);
		document.add(space);
		
		heading1.add(new Chunk("Part - A\n GENERAL", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space);
	
		
		PdfPTable table2 = new PdfPTable(3);
		float[] columnWidths2 = new float[] { 1f, 10f, 8f };
		table2.setWidths(columnWidths2);
		table2.setWidthPercentage(100);

		

		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell2 = new PdfPCell(heading);
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("(a).Name and location of the unit ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(unitName+", "+unitLocation, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"(b).Address of the unit",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(factoryPostalAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"(c).Registration required for manufacturing of:\n " +
				"    (i) Carry bags: \n" +
				"      (a) Petro-based\n" +
				"      (b) Compostable\n" +
				"    (ii) Multilayered plastics",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(authorizationRequiredFor, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"(d).Manufacturing capacity ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(manuCapacity, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"(e).In case of renewal, previous registration number and date of registration ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setColspan(2);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
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
		cell2.setColspan(2);
		table2.addCell(cell2);

		
		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Is the unit registered with the District Industries Centre of the State Government or Union Territory? If yes, attach a copy", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(isUnitRegistered+"\n"+DistrictPlan1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("(a).Total capital invested on the project", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(capitalInvestment, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"(b).Year of commencement of production", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(yearOfCommencement, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("(a).List and quantum of products and by-products", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setColspan(2);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		PdfPTable table2ab12 = new PdfPTable(4);
		table2ab12.setWidthPercentage(100);

		PdfPCell cell2ab12 = new PdfPCell(heading);
		
		heading = new Paragraph("Products (Name)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12 = new PdfPCell(heading);
		cell2ab12.setPadding(3.0f);
		cell2ab12.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12.addCell(cell2ab12);
		
		heading = new Paragraph("Quantity (in selected Unit Type)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12 = new PdfPCell(heading);
		cell2ab12.setPadding(3.0f);
		cell2ab12.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12.addCell(cell2ab12);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12 = new PdfPCell(heading);
		cell2ab12.setPadding(3.0f);
		cell2ab12.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12.addCell(cell2ab12);
		
		heading = new Paragraph("Maximum Installed Production Capacity (Same Unit)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12 = new PdfPCell(heading);
		cell2ab12.setPadding(3.0f);
		cell2ab12.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12.addCell(cell2ab12);
	
		
		for(int var2=0;var2<productDetailsInstance.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsInstance.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab12 = new PdfPCell (new Paragraph(a));
				cell2ab12.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab12.setPadding (5.0f);
				table2ab12.addCell (cell2ab12);
			}
		}
		
		
		
		cell2.addElement(table2ab12);
		cell2.setColspan(2);
		table2.addCell(cell2);
		
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);
		
		
		PdfPTable table2ab12a = new PdfPTable(4);
		table2ab12a.setWidthPercentage(100);

		PdfPCell cell2ab12a = new PdfPCell(heading);
		
		heading = new Paragraph("Products (Name)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12a = new PdfPCell(heading);
		cell2ab12a.setPadding(3.0f);
		cell2ab12a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12a.addCell(cell2ab12a);
		
		heading = new Paragraph("Quantity (in selected Unit Type)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12a = new PdfPCell(heading);
		cell2ab12a.setPadding(3.0f);
		cell2ab12a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12a.addCell(cell2ab12a);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12a = new PdfPCell(heading);
		cell2ab12a.setPadding(3.0f);
		cell2ab12a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12a.addCell(cell2ab12a);
		
		heading = new Paragraph("Maximum Installed Production Capacity (Same Unit)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab12a = new PdfPCell(heading);
		cell2ab12a.setPadding(3.0f);
		cell2ab12a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab12a.addCell(cell2ab12a);
	
		
		for(int var2=0;var2<byProductDetails.size();var2++)
		{
			ArrayList al=(ArrayList) byProductDetails.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab12a = new PdfPCell (new Paragraph(a));
				cell2ab12a.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab12a.setPadding (5.0f);
				table2ab12a.addCell(cell2ab12a);
			}
		}
		
		
		
		cell2.addElement(table2ab12a);
		cell2.setColspan(2);
		table2.addCell(cell2);
		
		
		
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("(b).List and quantum of raw material used ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setColspan(2);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);
		
		PdfPTable table2ab13 = new PdfPTable(3);
		table2ab13.setWidthPercentage(100);

		PdfPCell cell2ab13 = new PdfPCell(heading);
		
		heading = new Paragraph("Raw Materials / Process chemicals (Name)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab13 = new PdfPCell(heading);
		cell2ab13.setPadding(3.0f);
		cell2ab13.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab13.addCell(cell2ab13);
		
		heading = new Paragraph("Quantity (in selected Unit Type)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab13 = new PdfPCell(heading);
		cell2ab13.setPadding(3.0f);
		cell2ab13.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab13.addCell(cell2ab13);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab13 = new PdfPCell(heading);
		cell2ab13.setPadding(3.0f);
		cell2ab13.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab13.addCell(cell2ab13);
		
		

		
		for(int var2=0;var2<rawMaterials.size();var2++)
		{
			ArrayList al=(ArrayList) rawMaterials.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab13 = new PdfPCell (new Paragraph(a));
				cell2ab13.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab13.setPadding (5.0f);
				table2ab13.addCell (cell2ab13);
			}
		}
		
		
		cell2.addElement(table2ab13);
		cell2.setColspan(2);
		table2.addCell(cell2);
		
		
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Furnish a flow diagram of manufacturing process showing input and output in terms of products and waste generated including for captive power generation and water. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setColspan(2);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		PdfPTable table2ab13a = new PdfPTable(2);
		table2ab13a.setWidthPercentage(100);

		PdfPCell cell2ab13a = new PdfPCell(heading);
		
		heading = new Paragraph("Flow of manufacturing process", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab13a = new PdfPCell(heading);
		cell2ab13a.setPadding(3.0f);
		cell2ab13a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab13a.addCell(cell2ab13a);
		
		heading = new Paragraph("Description of manufacturing process", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab13a = new PdfPCell(heading);
		cell2ab13a.setPadding(3.0f);
		cell2ab13a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab13a.addCell(cell2ab13a);
		
		
		for(int var2=0;var2<manufactureProcess.size();var2++)
		{
			ArrayList al=(ArrayList) manufactureProcess.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab13a = new PdfPCell (new Paragraph(a));
				cell2ab13a.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab13a.setPadding (5.0f);
				table2ab13a.addCell (cell2ab13a);
			}
		}
		
		
		cell2.addElement(table2ab13a);
		
		cell2.setColspan(2);
		table2.addCell(cell2);
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Status of compliance with these rules- Thickness- fifty micron (Yes/No)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(thiknessRulz, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
				
		
		document.add(table2);
		document.add(space);
		document.add(space);

		
		heading = new Paragraph();
		heading.add(new Chunk("Part - B\n PERTAINING TO LIQUID EFFLUENT AND GASEOUS EMISSIONS ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table3 = new PdfPTable(3);
		float[] columnWidths3 = new float[] { 1f, 10f, 8f };
		table3.setWidths(columnWidths3);
		table3.setWidthPercentage(100);


		


		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3 = new PdfPCell(heading);
		cell3 = new PdfPCell(heading);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"(a).Does the unit have a valid consent under the Water (Prevention and control of Pollution)Act, 1974(6 of 1974)? If yes, attach a copy ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);


		heading = new Paragraph(waterAct+", "+consentWater1, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);
		
		heading = new Paragraph(
				"(b).Does the unit have a valid consent under the Air (Prevention and control of Pollution)Act, 1981(14 of 1981)? If yes, attach a copy ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(airAct+", "+consentAir1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		
		
		
		document.add(table3);
		document.add(space);
		document.add(space);
		
		
		heading = new Paragraph();
		heading.add(new Chunk("Part - C\n PERTAINING TO WASTE ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table4 = new PdfPTable(3);
		float[] columnWidths4 = new float[] { 1f, 10f, 8f };
		table4.setWidths(columnWidths4);
		table4.setWidthPercentage(100);


		


		heading = new Paragraph("8.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell4 = new PdfPCell(heading);
		cell4 = new PdfPCell(heading);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell4);

		heading = new Paragraph("Solid Wastes or rejects:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		
		cell4.setColspan(2);
		table4.addCell(cell4);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell4);
		
		PdfPTable table2ab = new PdfPTable(4);
		float[] columnWidths41 = new float[] { 2f, 2f, 2f, 2f };
		table2ab.setWidths(columnWidths41);
		table2ab.setWidthPercentage(100);

		PdfPCell cell2ab = new PdfPCell(heading);
		
		heading = new Paragraph("Total quantum of waste generated", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
		
		cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
		
		cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		heading = new Paragraph("Mode of storage within the plant", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
		cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		heading = new Paragraph("Provision made for disposal of wastes", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
	    cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		for(int var2=0;var2<solidWasteReject.size();var2++)
		{
			ArrayList al=(ArrayList) solidWasteReject.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab = new PdfPCell (new Paragraph(a));
				cell2ab.setHorizontalAlignment (Element.ALIGN_CENTER);
				table2ab.addCell (cell2ab);
			}
		}

		cell4.addElement(table2ab);
		cell4.setPadding(3.0f);
		cell4.setColspan(2);
		table4.addCell(cell4);
		
		
		

		heading = new Paragraph("9.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell4);

		heading = new Paragraph(
				"Attach or provide list of person supplying plastic to be used as raw material to manufacture carry bags or plastic sheet of like or multilayered packaging ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		
		table4.addCell(cell4);

		heading = new Paragraph(supplyingPlastic1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		table4.addCell(cell4);

		heading = new Paragraph("10.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell4);

		heading = new Paragraph(
				"Attach or provide list of personnel or Brand Owners to whom the products will be supplied ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		table4.addCell(cell4);

		heading = new Paragraph(personalBrand1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		table4.addCell(cell4);
		
		heading = new Paragraph("11.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4.addCell(cell4);

		heading = new Paragraph(
				"Action plan on collecting back the plastic wastes",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		table4.addCell(cell4);

		heading = new Paragraph(actionPlan, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell4 = new PdfPCell(heading);
		cell4.setPadding(3.0f);
		table4.addCell(cell4);
		
		
		
		document.add(table4);
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

		cell2 = new PdfPCell(new Paragraph(new Chunk("Name and Designation",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell2.setPadding(3.0f);
		cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table2.addCell(cell2);

		document.add(table2);
		document.add(space);
		
		heading = new Paragraph();
		heading.add(new Chunk("II Brand Owners:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading.add(new Chunk("Part - A\n GENERAL", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table5 = new PdfPTable(3);
		float[] columnWidths5 = new float[] { 1f, 10f, 8f };
		table5.setWidths(columnWidths5);
		table5.setWidthPercentage(100);

		

		heading = new Paragraph("1", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell5 = new PdfPCell(heading);
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph("Name, Address and Contact number ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		heading = new Paragraph(applicantName+"\n"+"", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph(
				"In case of renewal, previous registration number and date of registration",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		PdfPTable table69 = new PdfPTable(5);
        PdfPCell cell69 = new PdfPCell();
		float[] columnWidths91 = new float[] {3f, 3f, 3f, 3f, 3f};
		table69.setWidths(columnWidths91);
		table69.setWidthPercentage(100);
			
		
		cell69 = new PdfPCell(new Paragraph(new Chunk("Date of Application for PWMA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell69.setPadding(3.0f);
		table69.addCell(cell69);
        
		cell69 = new PdfPCell(new Paragraph(new Chunk("PWMA Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell69.setPadding(3.0f);
		table69.addCell(cell69);
		
		cell69 = new PdfPCell(new Paragraph(new Chunk("Authorisation No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell69.setPadding(3.0f);
		table69.addCell(cell69);
		
		cell69 = new PdfPCell(new Paragraph(new Chunk("Issued date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell69.setPadding(3.0f);
		table69.addCell(cell69);
		
		cell69 = new PdfPCell(new Paragraph(new Chunk("Valid date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell69.setPadding(3.0f);
		table69.addCell(cell69);
		
		for(int var34=0;var34<PWMPreviousAuthorisationDetailsInstance.size();var34++)
		{
			ArrayList al=(ArrayList) PWMPreviousAuthorisationDetailsInstance.get(var34);
			for(int var35=0;var35<al.size();var35++)
			{
				String a=(String) al.get(var35);
				cell69 = new PdfPCell (new Paragraph(new Chunk(" "+a, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE - 1, Font.NORMAL,new Color(0,0,0)))));
				cell69.setPadding (3.0f);
				table69.addCell (cell69);
		}
		}

		cell5 =  new PdfPCell();
		cell5.addElement(table69);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setColspan(4);
		cell5.setBorder(PdfPCell.NO_BORDER);
		table5.addCell(cell5);
		
		
		

		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph(
				"Is the unit registered with the District Industries Centre of the State Government or Union Territory? If yes, attach a copy. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		heading = new Paragraph(isUnitRegistered+"\n"+DistrictPlan1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		heading = new Paragraph("4(a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph(
				"Total capital invested on the project",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		heading = new Paragraph(capitalInvestment, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);
		
		heading = new Paragraph("(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph(
				"Year of commencement of production ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		heading = new Paragraph(yearOfCommencement, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);
		
		heading = new Paragraph("5(a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph("List of quantum of products and by-products", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		PdfPTable table2ab125 = new PdfPTable(4);
		table2ab125.setWidthPercentage(100);

		PdfPCell cell2ab125 = new PdfPCell(heading);
		
		heading = new Paragraph("Product (Names)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125 = new PdfPCell(heading);
		cell2ab125.setPadding(3.0f);
		cell2ab125.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125.addCell(cell2ab125);
		
		heading = new Paragraph("Quantity (in selected Unit Type)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125 = new PdfPCell(heading);
		cell2ab125.setPadding(3.0f);
		cell2ab125.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125.addCell(cell2ab125);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125 = new PdfPCell(heading);
		cell2ab125.setPadding(3.0f);
		cell2ab125.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125.addCell(cell2ab125);
		
		heading = new Paragraph("Maximum Installed Production Capacity (Same Unit)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125 = new PdfPCell(heading);
		cell2ab125.setPadding(3.0f);
		cell2ab125.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125.addCell(cell2ab125);
		
		
		
		
		
		for(int var2=0;var2<productDetailsInstance.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsInstance.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab125 = new PdfPCell (new Paragraph(a));
				cell2ab125.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab125.setPadding (5.0f);
				table2ab125.addCell (cell2ab125);
			}
		}
		
		
		
		cell5.addElement(table2ab125);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph("By-Product", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		PdfPTable table2ab125a = new PdfPTable(4);
		table2ab125a.setWidthPercentage(100);

		PdfPCell cell2ab125a = new PdfPCell(heading);
		
		heading = new Paragraph("By-Product (Names)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125a = new PdfPCell(heading);
		cell2ab125a.setPadding(3.0f);
		cell2ab125a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125a.addCell(cell2ab125a);
		
		heading = new Paragraph("Quantity (in selected Unit Type)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125a = new PdfPCell(heading);
		cell2ab125a.setPadding(3.0f);
		cell2ab125a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125a.addCell(cell2ab125a);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125a = new PdfPCell(heading);
		cell2ab125a.setPadding(3.0f);
		cell2ab125a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125a.addCell(cell2ab125a);
		
		heading = new Paragraph("Maximum Installed Production Capacity (Same Unit)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab125a = new PdfPCell(heading);
		cell2ab125a.setPadding(3.0f);
		cell2ab125a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab125a.addCell(cell2ab125a);
		
		
		
		
		
		for(int var2=0;var2<byProductDetails.size();var2++)
		{
			ArrayList al=(ArrayList) byProductDetails.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab125a = new PdfPCell (new Paragraph(a));
				cell2ab125a.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab125a.setPadding (5.0f);
				table2ab125a.addCell (cell2ab125a);
			}
		}
		
		
		
		cell5.addElement(table2ab125a);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);
		
		

		heading = new Paragraph("(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell5);

		heading = new Paragraph("List and quantum of raw materials used", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell5 = new PdfPCell(heading);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		PdfPTable table2ab134 = new PdfPTable(3);
		table2ab134.setWidthPercentage(100);

		PdfPCell cell2ab134 = new PdfPCell(heading);
		
		heading = new Paragraph("Raw Materials / Process chemicals (Name)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab134 = new PdfPCell(heading);
		cell2ab134.setPadding(3.0f);
		cell2ab134.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab134.addCell(cell2ab134);
		
		heading = new Paragraph("Unit Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab134 = new PdfPCell(heading);
		cell2ab134.setPadding(3.0f);
		cell2ab134.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab134.addCell(cell2ab134);
		
		heading = new Paragraph("Quantity (in selected Unit Type)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab134 = new PdfPCell(heading);
		cell2ab134.setPadding(3.0f);
		cell2ab134.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab134.addCell(cell2ab134);
		
		

		
		for(int var2=0;var2<rawMaterials.size();var2++)
		{
			ArrayList al=(ArrayList) rawMaterials.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab134 = new PdfPCell (new Paragraph(a));
				cell2ab134.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab134.setPadding (5.0f);
				table2ab134.addCell (cell2ab134);
			}
		}
		
		
		cell5.addElement(table2ab134);
		cell5.setPadding(3.0f);
		table5.addCell(cell5);

		
		
		document.add(table5);
		document.add(space);
		document.add(space);

		
		heading = new Paragraph();
		heading.add(new Chunk("Part - B\n PERTAINING TO LIQUID EFFLUENT AND GASEOUS EMISSIONS ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table6 = new PdfPTable(3);
		float[] columnWidths6 = new float[] { 1f, 10f, 8f };
		table6.setWidths(columnWidths6);
		table6.setWidthPercentage(100);


		


		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell6 = new PdfPCell(heading);
		cell6 = new PdfPCell(heading);
		cell6.setPadding(3.0f);
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6.addCell(cell6);

		heading = new Paragraph(
				"(a)  Does the unit have a valid consent under the Water (Prevention and control of Pollution)Act, 1974(6 of 1974)? If yes, attach a copy ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell6 = new PdfPCell(heading);
		cell6.setPadding(3.0f);
		table6.addCell(cell6);

		heading = new Paragraph(waterAct+", "+consentWater1, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell6 = new PdfPCell(heading);
		cell6.setPadding(3.0f);
		table6.addCell(cell6);

		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell6 = new PdfPCell(heading);
		cell6.setPadding(3.0f);
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6.addCell(cell6);

		heading = new Paragraph(
				"(b)  Does the unit have a valid consent under the Air (Prevention and control of Pollution)Act, 1981(14 of 1981)? If yes, attach a copy ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell6 = new PdfPCell(heading);
		cell6.setPadding(3.0f);
		table6.addCell(cell6);

		heading = new Paragraph(airAct+", "+consentAir1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell6 = new PdfPCell(heading);
		cell6.setPadding(3.0f);
		table6.addCell(cell6);

		
		
		
		document.add(table6);
		document.add(space);
		document.add(space);
		
		
		heading = new Paragraph();
		heading.add(new Chunk("Part - C\n PERTAINING TO WASTE ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table7 = new PdfPTable(3);
		float[] columnWidths7 = new float[] { 1f, 10f, 8f };
		table7.setWidths(columnWidths7);
		table7.setWidthPercentage(100);


		


		heading = new Paragraph("8.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell7 = new PdfPCell(heading);
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7.addCell(cell7);
		
		heading = new Paragraph("Solid Wastes or rejects:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7.addCell(cell7);

		PdfPTable table2ab1 = new PdfPTable(3);
		table2ab1.setWidthPercentage(100);

		PdfPCell cell2ab1 = new PdfPCell(heading);
		
		heading = new Paragraph("Total quantum of waste generated", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab1 = new PdfPCell(heading);
		cell2ab1.setPadding(3.0f);
		cell2ab1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab1.addCell(cell2ab1);
		
		heading = new Paragraph("Mode of storage within the plant", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab1 = new PdfPCell(heading);
		cell2ab1.setPadding(3.0f);
		cell2ab1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab1.addCell(cell2ab1);
		
		heading = new Paragraph("Provision made for disposal of wastes", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab1 = new PdfPCell(heading);
		cell2ab1.setPadding(3.0f);
		cell2ab1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab1.addCell(cell2ab1);
		
		for(int var2=0;var2<solidWasteReject.size();var2++)
		{
			ArrayList al=(ArrayList) solidWasteReject.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab1 = new PdfPCell (new Paragraph(a));
				cell2ab1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab1.setPadding (5.0f);
				table2ab1.addCell (cell2ab1);
			}
		}

		cell7.addElement(table2ab1);
		cell7.setPadding(3.0f);
		table7.addCell(cell7);
		

		heading = new Paragraph("9.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7.addCell(cell7);

		heading = new Paragraph(
				"Attach or Provide list of persons applying plastic material",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		table7.addCell(cell7);

		heading = new Paragraph(supplyingPlastic1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		table7.addCell(cell7);

		heading = new Paragraph("10.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7.addCell(cell7);

		heading = new Paragraph(
				"Action plan on collecting back the plastic wastes ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		table7.addCell(cell7);

		heading = new Paragraph(actionPlan, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell7 = new PdfPCell(heading);
		cell7.setPadding(3.0f);
		table7.addCell(cell7);
		
		
		
		document.add(table7);
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
