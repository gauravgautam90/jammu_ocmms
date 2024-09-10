import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class BmwPdfFile {

	public File bmwPdfFunction(String addressOfInd,String phnCodeOfInd,String phnOfInd,String faxCodeOfInd,
			String faxOfInd,String emailOfInd,String addressOfOccupier,String phnCodeOfOccupier,String phnOfOccupier,String faxCodeOfOccupier,
			String faxOfOccupier, String emailOfOccupier ,String applicantName,
			String instutionName,String authorizationType,String nameAddressInstitution,
			String addrTreatmentFacility,String addrPlaceDisposalOfWaste,String modeTrans,
			String modeTreat,String descrip,String humanAnatomicalWaste,String animalWaste,
			String microbiologyBiotechnologyWaste,String wasteSharps,
			String discardedMedicinesAndCytotoxicdrugs,String solidWaste,
			String solidWasteDisposalGenerated,String liquidWaste,
			String incinerationAsh,String chemicalWaste,String humanAnatomicalWasteUnit,String animalWasteUnit,
			String microbiologyBiotechnologyWasteUnit,String wasteSharpsUnit,
			String discardedMedicinesAndCytotoxicdrugsUnit,String solidWasteUnit,
			String solidWasteDisposalGeneratedUnit,String liquidWasteUnit,
			String incinerationAshUnit,String chemicalWasteUnit,String previousAuthNo,
			String previousAuthDate, String activityAuthorizationSoughtFor,ArrayList listDocuments,
			String prevExpDate,String applicantAddress, String occDesignation, String applicantTehsil,
			String applicantDistrict,String district,String condImposedRenew) throws Exception {

		java.util.Date date = new java.util.Date();
		int year = date.getYear();
		if (year < 1000)
			year += 1900;
		int day = date.getDate();
		int month = (date.getMonth()) + 1;

		File tempFile = new File("BmwForm.pdf");

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase headerPhrase = new Phrase (instutionName+", "+addressOfInd+",\n "+district,new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.ITALIC));
		HeaderFooter header = new HeaderFooter(headerPhrase, false);
		header.setAlignment(Element.ALIGN_RIGHT);
		document.setHeader(header);
		
		Phrase footerPhrase = new Phrase ("",new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -2));
		HeaderFooter footer = new HeaderFooter(footerPhrase, true);
		footer.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(footer);
		document.open();

		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		
		Paragraph Firstheading = new Paragraph();
		Firstheading.add(new Chunk("J & K Pollution Control Committee \n", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 4, Font.BOLD, new Color(0, 0, 0))));
		Firstheading.add(new Chunk("Jammu/Kashmir", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 2, Font.BOLD, new Color(0, 0, 0))));
		Firstheading.setAlignment(Element.ALIGN_CENTER);

		document.add(Firstheading);
		
		
		
		Paragraph heading = new Paragraph();
		heading.add(new Chunk("FORM I", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 4, Font.BOLD, new Color(0, 0, 0))));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		space.add(new Chunk("                                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));

		space.setAlignment(Element.ALIGN_CENTER);

		Paragraph heading2 = new Paragraph();
		heading2.add(new Chunk("         (See Rule 8)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 2, Font.BOLD, new Color(0, 0, 0))));
		heading2.setAlignment(Element.ALIGN_CENTER);
		document.add(heading2);

		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("      APPLICATION FOR AUTHORISATION", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD, new Color(0,
						0, 0))));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);

		Paragraph heading3 = new Paragraph();
		heading3.add(new Chunk("   (To be submitted in duplicate.)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD, new Color(0,
						0, 0))));
		heading3.setAlignment(Element.ALIGN_CENTER);

		document.add(heading3);
//
//		Paragraph dated = new Paragraph();
//		dated.add(new Chunk("Date: " + day + "-" + month + "-" + year + "",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD,
//						new Color(0, 0, 0))));
//		dated.setAlignment(Element.ALIGN_RIGHT);
//		document.add(dated);
		
		Paragraph headingline = new Paragraph();
		headingline
				.add(new Chunk(
						"__________________________________________________________________________",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,
								Font.BOLD)));
		headingline.setAlignment(Element.ALIGN_CENTER);
		document.add(headingline);
		
		Paragraph heading4 = new Paragraph();
		heading4.add(new Chunk("To", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
		heading4.setAlignment(Element.ALIGN_LEFT);
		//document.add(heading4);

		Paragraph heading5 = new Paragraph();
		heading5.add(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
		heading5.setAlignment(Element.ALIGN_LEFT);
		//document.add(heading5);
		
		Paragraph heading6 = new Paragraph();
		heading6.add(new Chunk("JAMMU & KASHMIR  Pollution Control Committee.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
		heading6.setAlignment(Element.ALIGN_LEFT);
		//document.add(heading6);
		//document.add(space);
		

		float[] width1 = {0.5f,1f,1f,1f};
		
		PdfPTable table1 = new PdfPTable(width1);
		
		table1.setWidthPercentage(100);
		PdfPCell cell1 = new PdfPCell();

		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Particulars of the Applicant", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setColspan(3);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		

		cell1 = new PdfPCell(new Paragraph(new Chunk("(i)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Name of the Applicant (occupier/operator):", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(applicantName, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Address :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(applicantAddress+", "+applicantTehsil+", "+applicantDistrict, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Phone :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(phnCodeOfOccupier+ "-" +phnOfOccupier, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		 
		cell1 = new PdfPCell(new Paragraph(new Chunk("Fax :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(faxCodeOfOccupier+ "-" +faxOfOccupier, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Email :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
			
		cell1 = new PdfPCell(new Paragraph(new Chunk(emailOfOccupier, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		

		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("(ii)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Name of the Institution :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);


		cell1 = new PdfPCell(new Paragraph(new Chunk(instutionName, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Address :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(addressOfInd+", "+district, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Phone :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(phnCodeOfInd+"-"+phnOfInd, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
	

		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Fax :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(faxCodeOfInd+"-"+faxOfInd, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		 
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Email :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(emailOfInd, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		


		cell1 = new PdfPCell(new Paragraph(new Chunk("Activity For which authorization is sought:", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(activityAuthorizationSoughtFor, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		

		cell1 = new PdfPCell(new Paragraph(new Chunk("3.",new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 1, Font.BOLD,new Color(0, 0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Please state whether applying for fresh authorization "
				+"or for renewal:", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		if(authorizationType.equals("RenewalApplication")){
		cell1 = new PdfPCell(new Paragraph(new Chunk("Renewal", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		else{
			cell1 = new PdfPCell(new Paragraph(new Chunk("Fresh", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
							0, 0)))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// setBackgroundColor (new Color (102, 183, 189));
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			cell1.setPadding(3.0f);
			// cell.setBorderWidth(2);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
		}
		
		
		
		
	if(authorizationType.equals("FreshApplication")){
		cell1 = new PdfPCell(
				new Paragraph(
						new Chunk("",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setColspan(4);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
	
	}
	else{
		
		cell1= new PdfPCell(
				new Paragraph(
						new Chunk("",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1); 
		cell1= new PdfPCell(
			new Paragraph(
					new Chunk("Previous Authorization Number",
							new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0,Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	// cell.setBackgroundColor (new Color (102, 183, 189));
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	//cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);

	cell1 = new PdfPCell(new Paragraph(new Chunk("Previous Authorization Date", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	// cell.setBackgroundColor (new Color (206, 232, 234));
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	//cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("Expiry Date", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	// cell.setBackgroundColor (new Color (206, 232, 234));
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	//cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1= new PdfPCell(
			new Paragraph(
					new Chunk("",
							new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	// cell.setBackgroundColor (new Color (102, 183, 189));
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1); 
	
	cell1= new PdfPCell(
			new Paragraph(
					new Chunk(previousAuthNo,
							new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0,Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	// cell.setBackgroundColor (new Color (102, 183, 189));
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	//cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);

	cell1 = new PdfPCell(new Paragraph(new Chunk(previousAuthDate, new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	// cell.setBackgroundColor (new Color (206, 232, 234));
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	//cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1 = new PdfPCell(new Paragraph(new Chunk(prevExpDate, new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	// cell.setBackgroundColor (new Color (206, 232, 234));
	cell1.setPadding(3.0f);
	// cell.setBorderWidth(2);
	//cell1.setBorder(PdfPCell.NO_BORDER);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	
	}
	//		document.add(space);
			
			
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("4.     1)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		

		cell1 = new PdfPCell(new Paragraph(new Chunk(
				"Address of the place of treatment/disposal facility : ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (168, 218, 243));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
 if(addrPlaceDisposalOfWaste.equals("Other")){

		cell1 = new PdfPCell(new Paragraph(new Chunk(addrTreatmentFacility, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		//cell.setColspan(2);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		document.add(space);
		document.add(space);
	}else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(addrPlaceDisposalOfWaste, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		//cell.setColspan(2);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		document.add(space);
		document.add(space);}
		cell1 = new PdfPCell(new Paragraph(new Chunk("5.     1)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		

		cell1 = new PdfPCell(new Paragraph(new Chunk("Mode of transportation(in any) of bio-medical waste:", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk(modeTrans, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("        2)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Mode of Treatment", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(modeTreat, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("6.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		// setBackgroundColor (new Color (102, 183, 189));
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		// cell.setBorderWidth(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"Brief description of method of treatment and disposal(attach details):",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 1, Font.BOLD,
										new Color(0, 0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
if(listDocuments.contains("Method of Treatment and Disposal"))
{
		cell1 = new PdfPCell(new Paragraph(new Chunk(descrip+"\n  refer to Attached Documents" , new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.ITALIC))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
}	else{
	{
		cell1 = new PdfPCell(new Paragraph(new Chunk(descrip , new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.ITALIC))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
}	
}
		document.add(space);
		
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("7.      1)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk("Category(see schedule I) of waste to be handled", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk("2)Quantity of waste to be handled per month", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 1(Human Anatomical Waste):",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
if(humanAnatomicalWaste.equals("NA") && humanAnatomicalWasteUnit.equals("NA")){
		cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
}
else{
	cell1 = new PdfPCell(new Paragraph(new Chunk(humanAnatomicalWaste+" "+humanAnatomicalWasteUnit, new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
	cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1.setVerticalAlignment(Element.ALIGN_CENTER);
	// cell.setBackgroundColor (new Color (206, 232, 234));
	cell1.setPadding(3.0f);
	
	cell1.setBorder(PdfPCell.NO_BORDER);
	// cell.setBorderWidth(2);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cel.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 2 (Animal Waste) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setColspan(2);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(animalWaste.equals("NA") && animalWasteUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		
		else{
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(animalWaste+" "+animalWasteUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		//cell.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 3 (Microbiology & Biotechnology Waste) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(microbiologyBiotechnologyWaste.equals("NA") && microbiologyBiotechnologyWasteUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(microbiologyBiotechnologyWaste+" "+microbiologyBiotechnologyWasteUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 4 (Waste sharps) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cel.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(wasteSharps.equals("NA") && wasteSharpsUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(wasteSharps+" "+wasteSharpsUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);

		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 5 (Discarded Medicines and Cytotoxic drugs) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		
		if(discardedMedicinesAndCytotoxicdrugs.equals("NA") && discardedMedicinesAndCytotoxicdrugs.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(discardedMedicinesAndCytotoxicdrugs+" "+discardedMedicinesAndCytotoxicdrugs, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
//		cell.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 6 (Soiled Waste) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(solidWaste.equals("NA") && solidWasteUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		
		cell1 = new PdfPCell(new Paragraph(new Chunk(solidWaste+" "+solidWasteUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
//		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 7 (Solid Waste disposal generated) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(solidWasteDisposalGenerated.equals("NA") && solidWasteDisposalGeneratedUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(solidWasteDisposalGenerated+" "+solidWasteDisposalGeneratedUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		//cell.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 8 (Liquid Waste) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(liquidWaste.equals("NA") && liquidWasteUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(liquidWaste+" "+liquidWasteUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 9 (Incineration Ash) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(incinerationAsh.equals("NA") && incinerationAshUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(incinerationAsh+" "+incinerationAshUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Category 10 (Chemical Waste) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		if(chemicalWaste.equals("NA") && chemicalWasteUnit.equals("NA")){
			cell1 = new PdfPCell(new Paragraph(new Chunk("NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (206, 232, 234));
			cell1.setPadding(3.0f);
			
			cell1.setBorder(PdfPCell.NO_BORDER);
			// cell.setBorderWidth(2);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);
	}	
		else{
		cell1 = new PdfPCell(new Paragraph(new Chunk(chemicalWaste+" "+chemicalWasteUnit, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell1.setPadding(3.0f);
		//cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		}
		cell1 = new PdfPCell(new Paragraph(new Chunk("8.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		
		
		if(authorizationType.equals("RenewalApplication")){
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Is HCE complying with all the conditions imposed at the time of earlier authorization? :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);

		cell1 = new PdfPCell(new Paragraph(new Chunk(condImposedRenew, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0,
						0, 0)))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (102, 183, 189));
		cell1.setPadding(3.0f);
		
		cell1.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		//document.add(table);
		}
		document.add(table1);
		
		//document.add(table11);
		
		
		
//		Paragraph LastDetails = new Paragraph();
//		LastDetails.add(new Chunk("Signature of the Applicant:                    \n", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
//		LastDetails.add(new Chunk("Name  :   ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
//		LastDetails.add(new Chunk( applicantName+"\n", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0, 0, 0))));
//		LastDetails.add(new Chunk("Designation   :  ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
//		LastDetails.add(new Chunk(occDesignation+"\n", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0, 0, 0))));
//		LastDetails.add(new Chunk("Address   :  ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD, new Color(0, 0, 0))));
//		LastDetails.add(new Chunk( applicantAddress+",\n"+applicantTehsil+",\n"+applicantDistrict, new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.NORMAL, new Color(0, 0, 0))));
//		
//		LastDetails.setAlignment(Element.ALIGN_RIGHT);
//
//		document.add(LastDetails);
		
		
		
		PdfPTable table21 = new PdfPTable(2);
		table21.setWidthPercentage(50);
		table21.setHorizontalAlignment(Element.ALIGN_RIGHT);
				PdfPCell cell21 = new PdfPCell();

		

		cell21 = new PdfPCell(new Paragraph(new Chunk(
				"Signature of the Applicant:  ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		cell21.setColspan(2);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		document.add(space);

		

		cell21 = new PdfPCell(new Paragraph(new Chunk(
				"Name  :   ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,Font.BOLD))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		
		
		cell21 = new PdfPCell(new Paragraph(new Chunk( applicantName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		
		
		
		
		
		cell21 = new PdfPCell(new Paragraph(new Chunk(
				"Designation   :  ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		
		cell21 = new PdfPCell(new Paragraph(new Chunk(
				 occDesignation, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		
		
		
		
		cell21 = new PdfPCell(new Paragraph(new Chunk(
				"Address   :  ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		

		cell21 = new PdfPCell(new Paragraph(new Chunk(
				 applicantAddress+", "+applicantTehsil+", "+applicantDistrict, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1))));
		cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell21.setVerticalAlignment(Element.ALIGN_CENTER);
		// cell.setBackgroundColor (new Color (206, 232, 234));
		cell21.setPadding(3.0f);
		cell21.setBorder(PdfPCell.NO_BORDER);
		// cell.setBorderWidth(2);
		cell21.setBorderColor(new Color(0, 0, 0));
		table21.addCell(cell21);
		
		
		
		document.add(table21);

		
		
		
		float[] widths1 = {1f,0.5f,1f,1f};
		PdfPTable table28 = new PdfPTable(widths1);
		table28.setWidthPercentage(100);
		PdfPCell cell28 = new PdfPCell();
		
		cell28 = new PdfPCell(new Paragraph(new Chunk(" ",
				new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 3, Font.BOLD))));
		cell28.setHorizontalAlignment(Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (206, 232, 234));
		cell28.setVerticalAlignment(Element.ALIGN_LEFT);
		cell28.setColspan(4);
		cell28.setVerticalAlignment(Element.ALIGN_LEFT);                                                                                                                              
		cell28.setBorder(PdfPCell.NO_BORDER);
		table28.addCell(cell28);
		
		cell28 = new PdfPCell(new Paragraph(new Chunk("Attached Documents :  ",
				new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 3, Font.BOLD))));
		cell28.setHorizontalAlignment(Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (206, 232, 234));
		cell28.setVerticalAlignment(Element.ALIGN_LEFT);
		cell28.setColspan(4);
		cell28.setVerticalAlignment(Element.ALIGN_LEFT);                                                                                                                              
		cell28.setBorder(PdfPCell.NO_BORDER);

		cell28.setBorderColor(new Color(0, 0, 0));
		table28.addCell(cell28);
		document.add(table28);
		

		int count = 1;
		for(int var2=0;var2<listDocuments.size();var2++)
		{
		ArrayList al=(ArrayList) listDocuments.get(var2);
		//System.out.println(al.ge)
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

		return tempFile;
	}
}
