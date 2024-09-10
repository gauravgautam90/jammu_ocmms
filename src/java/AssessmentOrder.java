import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AssessmentOrder {
public File assessmentOrder_Function(String offDistrict,String dateNotice,String officeAddress,String industryName,String industryPlot,String industryAddress,String industryTehsil,String industryDistrict,String noticeNum,String assessmentPeriodFrom,String assessmentPeriodTo, String mineConsumption, String mineGrossAmount, String mineQuallifyingERebate, String mineRebateAllowed, String mineNetAmount, String domesticConsumption, String domesticGrossAmount, String domesticQuallifyingERebate, String domesticRebateAllowed, String domesticNetAmount, String nonToxicConsumption, String nonToxicGrossAmount, String nonToxicQuallifyingERebate, String nonToxicRebateAllowed,String nonToxicNetAmount,String toxicConsumption,String toxicGrossAmount,String toxicQuallifyingERebate,String toxicRebateAllowed,String toxicNetAmount,String totRupees,String sayRupee1,String sayRupee2,String dueDate,String remark,String rupeesInWords, String fromDate1, String toDate1, String type, String type1, String totRupees1) throws Exception {
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		
		/*Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);*/

		
		Font fontTable= new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE-1 );
		Font fontTable1= new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE,Font.BOLD );
		Paragraph heading = new Paragraph();
		heading.add(new Chunk("CHHATISGARH ENVIRONMENT CONSERVATION BOARD",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk(officeAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		
		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space12);
		
		Paragraph subHeading1 = new Paragraph();
		subHeading1.add(new Chunk("Assessment Order",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading1.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading1);
		document.add(space12);

		Paragraph videNo = new Paragraph();
		videNo.add(new Chunk("No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +noticeNum, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk(offDistrict+" ,Dated:" + dateNotice, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		document.add(videNo);

		Paragraph toAddress = new Paragraph("Name of Assessee,");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);

		Paragraph indName = new Paragraph(industryName);
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);

		Paragraph address = new Paragraph(industryPlot+" "+industryAddress);
		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(20);
		document.add(address);

		Paragraph tehsil = new Paragraph();
		tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsil.add(new Chunk(industryTehsil, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		tehsil.setIndentationLeft(20);
		document.add(tehsil);

		Paragraph district = new Paragraph();
		district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		district.add(new Chunk(industryDistrict, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		district.setIndentationLeft(20);
		document.add(district);

		document.add(space12);
		
		
		Paragraph asses = new Paragraph();
		asses.add(new Chunk("Assessment period     From  :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk(assessmentPeriodFrom, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.add(new Chunk("   To  ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk(assessmentPeriodTo, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.setIndentationLeft(20);
		document.add(asses);
		
		
		
		Paragraph noticeBody1 = new Paragraph();
		noticeBody1.add(new Chunk("Under Section 6 read with rules 2(b) of Water (Prevention & Control of Pollution) Cess Act,1977.", fontTable));
		//noticeBody1.setIndentationLeft(20);
		noticeBody1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody1);
		Paragraph noticeBody12 = new Paragraph();
		noticeBody12.add(new Chunk("I hereby assess the amount of Cess on considering the relevant documents.", fontTable));
		//noticeBody12.setIndentationLeft(20);
		noticeBody12.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody12);
		
		document.add(space12);
		
		
		
		
		
		// ---- Table ----- 
		
		PdfPTable table=new PdfPTable(8);
		table.setWidthPercentage(100);
		
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph ("S.No"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Purpose for which water consumed",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Consumption of water taken for purpose of assessment",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Gross amount of Cess Assessed (Rs)",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Qty. of water qualifying for rebate(Rs.) (in K.L)",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Rebate allowed (Rs)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Net amount of assessed & payable (Rs.)",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Remarks",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		
		
		cell = new PdfPCell (new Paragraph ("1"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Industrial Cooling Spraying in Mine Pits or Boiler Feeds",fontTable));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (mineConsumption));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (mineGrossAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (mineQuallifyingERebate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (mineRebateAllowed));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (mineNetAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (remark));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setRowspan(4);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		
		
		cell = new PdfPCell (new Paragraph ("2"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Domestic Purpose",fontTable));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (domesticConsumption));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (domesticGrossAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (domesticQuallifyingERebate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (domesticRebateAllowed));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (domesticNetAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		
		
		
		
		
		cell = new PdfPCell (new Paragraph ("3"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Proceessing whereby water gets polluted and the pollutants are- "+type,fontTable));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (nonToxicConsumption));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (nonToxicGrossAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (nonToxicQuallifyingERebate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (nonToxicRebateAllowed));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (nonToxicNetAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		
		
		
		
		
		cell = new PdfPCell (new Paragraph ("4"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Proceessing whereby water gets polluted and the pollutants are- "+type1,fontTable));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (toxicConsumption));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (toxicGrossAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (toxicQuallifyingERebate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (toxicRebateAllowed));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (toxicNetAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		document.add(table);
		
	
		Paragraph totalRs = new Paragraph();
		totalRs.setFirstLineIndent(40);
		totalRs.add(new Chunk("                                Total Rs. ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		totalRs.add(new Chunk("   ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		totalRs.add(new Chunk(totRupees1, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		totalRs.add(new Chunk("                                                         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		totalRs.add(new Chunk(totRupees, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(totalRs);
		
		
		Paragraph sayRs = new Paragraph();
		sayRs.setFirstLineIndent(40);
		sayRs.add(new Chunk("                                Say Rs. ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		sayRs.add(new Chunk("     ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		sayRs.add(new Chunk(sayRupee1, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		sayRs.add(new Chunk("                                                          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		sayRs.add(new Chunk(sayRupee2, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(sayRs);
		
		Paragraph rupeesWord = new Paragraph();
		rupeesWord.add(new Chunk("( Rs. "+rupeesInWords+ " )", fontTable));
		
		document.add(rupeesWord);
		
		
		Paragraph noticeBody2 = new Paragraph();
		noticeBody2.add(new Chunk("The amount of cess shown above please be remitted to the Chhattisgarh Environment Conservation Board in the from of a ", fontTable));
		noticeBody2.add(new Chunk("DEMAND DRAFT", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD )));
		
		noticeBody2.add(new Chunk("in favour of the Member Secretary (Water Cess), payable at Raipur within 30 days from the date of issue of this order i.e. on or before "+dueDate+" failing which you shall be liable to pay interest at the rate of 2% per month on the amount of cess to be paid from the date of which such payment is due till such amount is actually paid as per Section 10 of the said Act.", fontTable));
		//noticeBody1.setIndentationLeft(20);
		noticeBody2.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody2);
		
		
		
		document.add(space12);

		document.add(space12);

	

		document.add(space12);

		Paragraph mem = new Paragraph();
		mem.add(new Chunk("Member Secretary                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem);

		Paragraph mem1 = new Paragraph();
		mem1.add(new Chunk("Chhattisgarh Environment Conservation Board",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem1.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem1);
		
		Paragraph mem2 = new Paragraph();
		mem2.add(new Chunk("Raipur (C.G.)                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem2.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem2);
		
		
		document.close();
		return tempFile;
	}
}