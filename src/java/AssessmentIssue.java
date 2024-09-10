import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class AssessmentIssue {
	public File assessmentIssueFunction(String offDistrict,String dateNotice,String officeAddress,String industryName,String industryPlot,String industryAddress,String industryTehsil,String industryDistrict,String noticeNum,String assessmentPeriodFrom,String assessmentPeriodTo, String fromDate1, String toDate1 ,String waterConsumptionClass1,String waterConsumptionClass2,String waterConsumptionClass3,String waterConsumptionClass4,String remarks1,String remarks2,String remarks3,String remarks4,String issueDateHearing,String cessRupees,String copyTo, String endtNumber) throws Exception {
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);

		

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

		Paragraph toAddress = new Paragraph("To,");
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
		document.add(space12);
		
		Paragraph asses = new Paragraph();
		asses.add(new Chunk("Sub :- ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk("Water cess assessment for the period from  ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.add(new Chunk(assessmentPeriodFrom, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk(" to ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.add(new Chunk(assessmentPeriodTo, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk(" under Water (Prevention & Control of Pollution) Cess Act, 1977 - pre-assessment notice there of. ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.setIndentationLeft(20);
		asses.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(asses);
		
		document.add(space12);
		
		Paragraph noticeBody1 = new Paragraph();
		noticeBody1.add(new Chunk("You have submitted/not submitted monthly returns for the aforesaid assessment period. The monthly returns submitted by the company have been found to be less as compared to the water consumption verification report submitted by the Regional Officer for the above assessment period.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody1.setFirstLineIndent(20);
		noticeBody1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody1);
		
		document.add(space12);
		
		Paragraph noticeBody2 = new Paragraph();
		noticeBody2.add(new Chunk("You are required to affix water meters for the measurement of the water consumption in different categories under section 4 of water (Prevention &Control of Pollution) Cess Act 1977. You have not provided the metering arrangements and also not submitting the Water meter readings of the desired categories of water consumption.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody2.setFirstLineIndent(20);
		noticeBody2.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody2);
		 
		document.add(space12);
		
		Paragraph noticeBody3 = new Paragraph();
		noticeBody3.add(new Chunk("Based on the verification report received from the Regional Office of the Board and the materials in record, Chhattisgarh Environment Conservation Board proposes to assess the water cess for the period from ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody3.add(new Chunk(assessmentPeriodFrom, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD )));
		noticeBody3.add(new Chunk(" to ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody3.add(new Chunk(assessmentPeriodTo, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD )));
		noticeBody3.add(new Chunk(" as per following:-", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody3.setFirstLineIndent(20);
		noticeBody3.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody3);
		
		document.add(space12);
		
		PdfPTable table=new PdfPTable(3);
		table.setWidthPercentage(100);
		
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph ("Category"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Water Consumption (Kiloliters per Day/Month)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Remarks"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Class- I"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (waterConsumptionClass1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (remarks1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Class- II"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (waterConsumptionClass2));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (remarks2));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Class- III"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (waterConsumptionClass3));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (remarks3));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Class- IV"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (waterConsumptionClass4));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (remarks4));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		document.add(table);
		
		document.add(space12);
		
		Paragraph noticeBody4 = new Paragraph();
		noticeBody4.add(new Chunk("Accordingly, you are required to deposit water cess of Rs "+cessRupees+" for the period from "+assessmentPeriodFrom+" to "+assessmentPeriodTo+" . In case you do not agree with the above water cess assessment, you or through your authorized representative may present the case in the Head Office personally along with water meter readings and other relevant documents on or before dated. "+issueDateHearing+" In case you fail, to present the case within the given time period, final assessment will be done by the Board without any further notice.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody4.setFirstLineIndent(20);
		noticeBody4.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody4); 
		
		document.add(space12);
		
		Paragraph noticeBody5 = new Paragraph();
		noticeBody5.add(new Chunk("This notice may therefore be treated as the last opportunity for hearing if any before issue of the final assessment order", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody5.setFirstLineIndent(20);
		noticeBody5.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody5);
		
			document.add(space12);
			document.add(space12);
			document.add(space12);
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
		document.add(space12);
		document.add(space12);
		document.add(space12);
		
		Paragraph videNo1 = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo1.add(new Chunk("Endt No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo1.add(new Chunk("  " +endtNumber, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk(offDistrict+" ,Dated:" + dateNotice, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		

		document.add(videNo1);
		
		Paragraph toAddress1 = new Paragraph("Copy To:-");
		document.add(toAddress1);
		
		Paragraph copYtoo1 = new Paragraph(copyTo);

		
		copYtoo1.setIndentationLeft(20);
		
		document.add(copYtoo1);
		
		
		document.add(space12);
		document.add(space12);
		document.add(space12);
		
		document.add(mem);

		
		document.add(mem1);

		document.close();
		return tempFile;
	}
}