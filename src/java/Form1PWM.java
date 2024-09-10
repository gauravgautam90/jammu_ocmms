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


public class Form1PWM {
	
	
	public File form1PWMPdfFunction(String unitName,String applicantName,String applicantDesignation,String factoryPostalAddress,String occupierTel
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
		heading.add(new Chunk("FORM - II",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk("[See Rules 13(3)]", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"APPLICATION FORM  FOR REGISTRATION OF UNITS ENGAGED IN PROCESSING OR RECYCLING OF PLASTIC WASTE",
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

		heading = new Paragraph("Name and Address of the unit ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(unitName+","+factoryPostalAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Contact person with designation, Tel/Fax/Email",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(applicantName+", "+applicantDesignation+","+occupierTelCode+"-"+occupierTel, new Font(
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

		heading = new Paragraph(
				"Date of commencement ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
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

		heading = new Paragraph(
				"No of workers (including contract labour)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(numOfEmployee, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Consents Validity ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("a. Water (Prevention & Control of Pollution) Act, 1974;\n Valid up to "+dateOfWater+".\n" +
				"b. Air (Prevention & Control of Pollution) Act, 1981;\n Valid up to "+dateOfAir+".\n" +
				"c. Authorization; valid up to "+dateOfAuthorization, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Manufacturing Process", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(Manufacturing1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(4.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Products and installed capacity of production (MTA)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		PdfPTable table9 = new PdfPTable(2);
		table9.setWidthPercentage(100);

		PdfPCell cell99 = new PdfPCell(heading);
		heading = new Paragraph("Products", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell99 = new PdfPCell(heading);
		cell99.setPadding(3.0f);
		cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9.addCell(cell99);
		
		heading = new Paragraph("Installed Capacity", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell99 = new PdfPCell(heading);
		cell99.setPadding(3.0f);
		cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9.addCell(cell99);
	
		
		for(int var2=0;var2<productDetailsInstance1.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsInstance1.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell99 = new PdfPCell (new Paragraph(a));
				cell99.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell99.setPadding (5.0f);
				table9.addCell (cell99);
			}
		}

		cell2.addElement(table9);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("8.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Waste Management:\n" +
				"a. Waste generation in processing plastic waste", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		PdfPTable table2a = new PdfPTable(3);
		table2a.setWidthPercentage(100);

		PdfPCell cell2a = new PdfPCell(heading);
		heading = new Paragraph("Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2a = new PdfPCell(heading);
		cell2a.setPadding(3.0f);
		cell2a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2a.addCell(cell2a);
		
		heading = new Paragraph("Category", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2a = new PdfPCell(heading);
		cell2a.setPadding(3.0f);
		cell2a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2a.addCell(cell2a);
		
		heading = new Paragraph("Qty.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2a = new PdfPCell(heading);
		cell2a.setPadding(3.0f);
		cell2a.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2a.addCell(cell2a);
		
		for(int var2=0;var2<generationDetails.size();var2++)
		{
			ArrayList al=(ArrayList) generationDetails.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2a = new PdfPCell (new Paragraph(a));
				cell2a.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2a.setPadding (5.0f);
				table2a.addCell (cell2a);
			}
		}

		cell2.addElement(table2a);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("b. Waste Collection and transportation (attach details)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(Collection1, new Font(
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

		heading = new Paragraph("c. Waste disposal details", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		PdfPTable table2ab = new PdfPTable(3);
		table2ab.setWidthPercentage(100);

		PdfPCell cell2ab = new PdfPCell(heading);
		
		heading = new Paragraph("Type", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
		cell2ab.setPadding(3.0f);
		cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		heading = new Paragraph("Category", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
		cell2ab.setPadding(3.0f);
		cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		heading = new Paragraph("Qty.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2ab = new PdfPCell(heading);
		cell2ab.setPadding(3.0f);
		cell2ab.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ab.addCell(cell2ab);
		
		for(int var2=0;var2<disposalDetails.size();var2++)
		{
			ArrayList al=(ArrayList) disposalDetails.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell2ab = new PdfPCell (new Paragraph(a));
				cell2ab.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell2ab.setPadding (5.0f);
				table2ab.addCell (cell2ab);
			}
		}

		

		cell2.addElement(table2ab);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("d. Provide details of the disposal facility, whether the facility is authorized by SPCB or PCC", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(detailsDisposalFacility, new Font(
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

		heading = new Paragraph("e. Please attach analysis report of characterization of waste generated (including leachate test if applicable)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(analysis1, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		
		
		heading = new Paragraph("9.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Details of plastic waster proposed to be acquired through sale, auction, contract or import, as the case may be, for use as raw materials ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("(i) Name - " +namePlastic +"\n"+
				"(ii) Quantity required/Year  - "+quantityPlastic, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("10.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Occupational safety and health aspects  ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(occupationalFacilities, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("11.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		//cell2.setRowspan(5);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Pollution Control Measures", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("Whether the unit has adequate pollution control systems or equipment to met, as standards of emission or effluent.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(emmisionEffulant+", "+emmisionEffulantDetails, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("Whether unit is  in compliance with the condition laid down in the said rules", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(unitCompliance, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("Whether conditions exist or are likely to exist of the material being handled or processed posing adverse immediate or delayed impact on the environment.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(materialProceed, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		heading = new Paragraph("Whether conditions exist (or are likely to exist) of the material being handled or processed by any means capable of yeilding another material (e.g leachate) which many possess exo-toxicity.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(materialHandled, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		
		
		heading = new Paragraph("12.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Any other relevant information including fire or accident mitigative measures", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(otherInfor, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
				
		
		heading = new Paragraph("13.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("List of enclosures as per rule", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(enclosure1, new Font(
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
