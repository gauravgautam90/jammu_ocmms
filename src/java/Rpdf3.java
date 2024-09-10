import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Rpdf3 {
	public File pdfGenerationS (String codeNumber,String waterWasteRaw,String waterConsumptionRaw,String productCapacityRaw,String productRaw,String specialCondition,String dateStartProduction,String sourceWater,String otherAfter,String otherBefore,String ssAfter,String ssBefore,String codAfter,String codBefore,String bodAfter,String bodBefore,String phAfter,String phBefore,String grantedTo,String grantedFrom,String draftLetterDate,String applicationNumber,String applicationRecieptDate,String industryName,String industryAddress,String industryLocation,String industryInvest)throws Exception{
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		//tempFile = File.createTempFile("certificate.pdf", ".tmp" );
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		//Image image = Image.getInstance("resources/ChhattisgarhECB.jpg");
		/*Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		//Image image = Image.getInstance("ChhattisgarhECB.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);*/

	/*	Paragraph date = new Paragraph();
		date.add(new Chunk("Date :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		date.add(new Chunk(draftDate, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));

		date.setAlignment(Element.ALIGN_RIGHT);
		document.add(date);*/

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("For Consent under Water(Prevention and Control of Pollution)Act 1974.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("Code No. "+ codeNumber,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.add(new Chunk("        ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.add(new Chunk("        ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.add(new Chunk("R-3",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);

	/*	Paragraph videNo = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo.add(new Chunk("No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +fileNum, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk(offDistrict+" ,Dated:" + draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));

		document.add(videNo);*/

		Paragraph industry = new Paragraph();
		industry.add(new Chunk("Name of Industry              : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		industry.add(new Chunk(industryName, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		industry.setAlignment(Element.ALIGN_LEFT);
		document.add(industry);
		
		document.add(space12);
		Paragraph toAddress = new Paragraph();
		toAddress.add(new Chunk("Office Address                  : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		toAddress.add(new Chunk(industryAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		toAddress.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);
		document.add(space12);
		Paragraph location = new Paragraph();
		location.add(new Chunk("Location                           : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		location.add(new Chunk(industryLocation, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		location.setAlignment(Element.ALIGN_LEFT);
		document.add(location);
		document.add(space12);
		Paragraph investment = new Paragraph();
		investment.add(new Chunk("Investment                      : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		investment.add(new Chunk(industryInvest, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		investment.setAlignment(Element.ALIGN_LEFT);
		document.add(investment);
		document.add(space12);
		document.add(space12);
		// table 1 //
		PdfPTable table1=new PdfPTable(3);
		table1.setWidthPercentage(95);
		
		PdfPCell cell1 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell1 = new PdfPCell (new Paragraph (new Chunk("No. & Date of Receipt of Application", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (new Paragraph (new Chunk("Consent period", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (new Paragraph (new Chunk("No. & Draft Letter Date", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		
		
		
		cell1 = new PdfPCell (new Paragraph (new Chunk("No. : "+applicationNumber+" Date : "+applicationRecieptDate, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (1.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (new Paragraph (new Chunk("From "+grantedFrom+" to "+grantedTo+" or 12 months from first day of the month of commissioning", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (1.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (new Paragraph (new Chunk(" Date : "+draftLetterDate, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (1.0f);
		table1.addCell (cell1);
		
		document.add(table1);
		// ####### //
		document.add(space12);
		document.add(space12);
		
		PdfPTable table=new PdfPTable(4);
		table.setWidthPercentage(95);
		
		PdfPCell cell = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Product", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);

		
		cell = new PdfPCell (new Paragraph (new Chunk("Production Capacity", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Water Consumption Lit/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Waste Water Lit/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		
		cell = new PdfPCell (new Paragraph (new Chunk(productRaw, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);

		
		cell = new PdfPCell (new Paragraph (new Chunk(productCapacityRaw, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(waterConsumptionRaw, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(waterWasteRaw, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);
		document.add(table);
		// Table 3 //
		document.add(space12);
		document.add(space12);
		
		PdfPTable table3=new PdfPTable(6);
		table3.setWidthPercentage(95);
		
		PdfPCell cell3 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell3 = new PdfPCell (new Paragraph (new Chunk("Parameters", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);

		
		cell3 = new PdfPCell (new Paragraph (new Chunk("pH", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("BOD", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("COD", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("S.S", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("Other", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("Before Treatment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);

		
		cell3 = new PdfPCell (new Paragraph (new Chunk(phBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(bodBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(codBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(ssBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(otherBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("After Treatment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);

		
		cell3 = new PdfPCell (new Paragraph (new Chunk(phAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(bodAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(codAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(ssAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(otherAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		document.add(table3);
		// ######## //
		document.add(space12);
		document.add(space12);
		
		Paragraph source = new Paragraph();
		source.add(new Chunk("Source of Water                      : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		source.add(new Chunk(sourceWater, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		source.setAlignment(Element.ALIGN_LEFT);
		document.add(source);
		document.add(space12);
		
		Paragraph dateOfStarting  = new Paragraph();
		dateOfStarting.add(new Chunk("Date of Starting Production   : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		dateOfStarting.add(new Chunk(dateStartProduction, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		dateOfStarting.setAlignment(Element.ALIGN_LEFT);
		document.add(dateOfStarting);
		document.add(space12);
		Paragraph sCondition  = new Paragraph();
		sCondition.add(new Chunk("Special Conditions               : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		sCondition.add(new Chunk(specialCondition, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		sCondition.setAlignment(Element.ALIGN_LEFT);
		document.add(sCondition);
		
		document.close();
		return tempFile;
	}
	public File pdfGenerationArray(String codeNumber,String [] wasteWaterArray,String [] waterConsumptionArray,String [] productCapacityArray,String [] productArray,String specialCondition,String dateStartProduction,String sourceWater,String otherAfter,String otherBefore,String ssAfter,String ssBefore,String codAfter,String codBefore,String bodAfter,String bodBefore,String phAfter,String phBefore,String grantedTo,String grantedFrom,String draftLetterDate,String applicationNumber,String applicationRecieptDate,String industryName,String industryAddress,String industryLocation,String industryInvest)throws Exception{
File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		//tempFile = File.createTempFile("certificate.pdf", ".tmp" );
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		
		//Image image = Image.getInstance("resources/ChhattisgarhECB.jpg");
		/*Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		//Image image = Image.getInstance("ChhattisgarhECB.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);*/

	/*	Paragraph date = new Paragraph();
		date.add(new Chunk("Date :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		date.add(new Chunk(draftDate, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));

		date.setAlignment(Element.ALIGN_RIGHT);
		document.add(date);*/

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("For Consent under Water(Prevention and Control of Pollution)Act 1974.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("Code No. "+ codeNumber,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.add(new Chunk("        ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.add(new Chunk("        ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.add(new Chunk("R-3",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);

	/*	Paragraph videNo = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo.add(new Chunk("No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +fileNum, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk(offDistrict+" ,Dated:" + draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));

		document.add(videNo);*/

		Paragraph industry = new Paragraph();
		industry.add(new Chunk("Name of Industry              : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		industry.add(new Chunk(industryName, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		industry.setAlignment(Element.ALIGN_LEFT);
		document.add(industry);
		
		document.add(space12);
		Paragraph toAddress = new Paragraph();
		toAddress.add(new Chunk("Office Address                  : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		toAddress.add(new Chunk(industryAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		toAddress.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);
		document.add(space12);
		Paragraph location = new Paragraph();
		location.add(new Chunk("Location                           : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		location.add(new Chunk(industryLocation, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		location.setAlignment(Element.ALIGN_LEFT);
		document.add(location);
		document.add(space12);
		Paragraph investment = new Paragraph();
		investment.add(new Chunk("Investment                      : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		investment.add(new Chunk(industryInvest, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		investment.setAlignment(Element.ALIGN_LEFT);
		document.add(investment);
		document.add(space12);
		document.add(space12);
		// table 1 //
		PdfPTable table1=new PdfPTable(3);
		table1.setWidthPercentage(95);
		
		PdfPCell cell1 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell1 = new PdfPCell (new Paragraph (new Chunk("No. & Date of Receipt of Application", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (new Paragraph (new Chunk("Consent period", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (new Paragraph (new Chunk("No. & Date of Despatch", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		
		
		
		cell1 = new PdfPCell (new Paragraph (new Chunk("No. : "+applicationNumber+" Date : "+applicationRecieptDate, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (1.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (new Paragraph (new Chunk("From "+grantedFrom+" to "+grantedTo+" or 12 months from first day of the month of commissioning", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (1.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (new Paragraph (new Chunk(" Date : "+draftLetterDate, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (1.0f);
		table1.addCell (cell1);
		
		document.add(table1);
		// ####### //
		document.add(space12);
		document.add(space12);
		
		PdfPTable table=new PdfPTable(4);
		table.setWidthPercentage(95);
		
		PdfPCell cell = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell = new PdfPCell (new Paragraph (new Chunk("Product", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);

		
		cell = new PdfPCell (new Paragraph (new Chunk("Production Capacity", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Water Consumption Lit/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Waste Water Lit/day", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (5.0f);
		table.addCell (cell);
		
		for(int i=0;i<productArray.length;i++){
			
		
		
		cell = new PdfPCell (new Paragraph (new Chunk(productArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);

		
		cell = new PdfPCell (new Paragraph (new Chunk(productCapacityArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(waterConsumptionArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk(wasteWaterArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPadding (1.0f);
		table.addCell (cell);
		}
		document.add(table);
		// Table 3 //
		document.add(space12);
		document.add(space12);
		
		PdfPTable table3=new PdfPTable(6);
		table3.setWidthPercentage(95);
		
		PdfPCell cell3 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell3 = new PdfPCell (new Paragraph (new Chunk("Parameters", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);

		
		cell3 = new PdfPCell (new Paragraph (new Chunk("pH", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("BOD", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("COD", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("S.S", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("Other", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (5.0f);
		table3.addCell (cell3);
		
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("Before Treatment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);

		
		cell3 = new PdfPCell (new Paragraph (new Chunk(phBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(bodBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(codBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(ssBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(otherBefore, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk("After Treatment", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);

		
		cell3 = new PdfPCell (new Paragraph (new Chunk(phAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(bodAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(codAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(ssAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (new Chunk(otherAfter, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell3.setBorder(PdfPCell.NO_BORDER);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		cell3.setPadding (1.0f);
		table3.addCell (cell3);
		document.add(table3);
		// ######## //
		document.add(space12);
		document.add(space12);
		
		Paragraph source = new Paragraph();
		source.add(new Chunk("Source of Water                      : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		source.add(new Chunk(sourceWater, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		source.setAlignment(Element.ALIGN_LEFT);
		document.add(source);
		document.add(space12);
		
		Paragraph dateOfStarting  = new Paragraph();
		dateOfStarting.add(new Chunk("Date of Starting Production   : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		dateOfStarting.add(new Chunk(dateStartProduction, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		dateOfStarting.setAlignment(Element.ALIGN_LEFT);
		document.add(dateOfStarting);
		document.add(space12);
		Paragraph sCondition  = new Paragraph();
		sCondition.add(new Chunk("Special Conditions               : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		sCondition.add(new Chunk(specialCondition, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		sCondition.setAlignment(Element.ALIGN_LEFT);
		sCondition.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(sCondition);
		
		document.close();
		return tempFile;
	}

}
