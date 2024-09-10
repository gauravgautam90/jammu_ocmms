import java.io.File;
import java.io.FileOutputStream;

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


public class FeeDefaulterNotice {
public File feeDefaulterNoticeFunction(String offDistrict,String dateNotice,String officeAddress,String industryName,String industryPlot,String industryAddress,String industryTehsil,String industryDistrict,String noticeNum,String assessmentPeriodFrom,String assessmentPeriodTo,String assessmentOrderNo,String assessmentOrdeDate,String serialNo,String dueDate,String paidOnDate,String assessmentAmount,String balanceAmount,String interest,String toatalPayable, String amountDueDate,String copyTo, String fromDate1, String toDate1, String endtNumber) throws Exception {
		
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
		asses.add(new Chunk("Interest payable for delay in payment of water cess under section-10 of  Water (Prevention and Control of Pollution) Cess Act, 1977.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		asses.setIndentationLeft(20);
		asses.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(asses);
		
		Paragraph ref = new Paragraph();
		ref.add(new Chunk("Ref :- ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		ref.add(new Chunk("Assessment Order No.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		ref.add(new Chunk(assessmentOrderNo, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		ref.add(new Chunk(" Date : ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		ref.add(new Chunk(assessmentOrdeDate, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		
		ref.setIndentationLeft(20);
		ref.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(ref);
		
		document.add(space12);
		
		Paragraph noticeBody1 = new Paragraph();
		noticeBody1.add(new Chunk("Board has issued Water Cess Assessment Order vide letter under reference, where in you have been asked to deposit the water cess within the time period as specified in the Assessment Order. But you have failed to deposit the water cess amount within the given time period. ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE )));
		noticeBody1.setFirstLineIndent(20);
		noticeBody1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody1);
		
		Paragraph noticeBody11 = new Paragraph();
		noticeBody11.add(new Chunk("Now therefore as per the provisions under section 10 of the Water (Prevention and Control of Pollution) Cess Act, 1977, you are required to pay interest at the rate of two percent for every month or part of a month comprised in the period from the date on which such payment is due till such amount is actually paid. The interest and total amount liable for payment up to ------------is as per the following:- ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE )));
		noticeBody11.setFirstLineIndent(20);
		noticeBody11.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody11);
		
		document.add(space12);
		
		
		 
		document.add(space12);
		
		/////////
		PdfPTable table1=new PdfPTable(1);
		table1.setWidthPercentage(100);
		
		PdfPCell cell1 = new PdfPCell ();
		
		cell1 = new PdfPCell (new Paragraph ("Assessment Period"));
		cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table1.addCell (cell1);
		
		PdfPTable table11=new PdfPTable(2);
		table11.setWidthPercentage(100);
		
		PdfPCell cell11= new PdfPCell ();
		
		cell11 = new PdfPCell (new Paragraph ("From"));
		cell11.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table11.addCell (cell11);
		cell11 = new PdfPCell (new Paragraph ("To"));
		cell11.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table11.addCell (cell11);
		
		
		
		PdfPTable table111=new PdfPTable(1);
		table111.setWidthPercentage(100);
		
		PdfPCell cell111 = new PdfPCell ();
		
		cell111 = new PdfPCell (table1);
		cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table111.addCell (cell111);
		cell111 = new PdfPCell (table11);
		cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table111.addCell (cell111);
		
		
		
		PdfPTable table1112=new PdfPTable(2);
		table1112.setWidthPercentage(100);
		
		PdfPCell cell1112 = new PdfPCell ();
		
		cell1112 = new PdfPCell (new Paragraph(assessmentPeriodFrom));
		cell1112.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table1112.addCell (cell1112);
		cell1112 = new PdfPCell (new Paragraph(assessmentPeriodTo));
		cell1112.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table1112.addCell (cell1112);
		///////////
		
		PdfPTable table=new PdfPTable(8);
		table.setWidthPercentage(100);
		
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph ("S.No"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (table111);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Due date"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Paid on date"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Assessment Amount(In Rs.)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Balance Amount (In Rs.)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Interest (In Rs.)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Total payable Amount (In Rs.) "));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (serialNo));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (table1112);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (dueDate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (paidOnDate));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (assessmentAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (balanceAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (interest));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		cell = new PdfPCell (new Paragraph (toatalPayable));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		document.add(table);
		
		document.add(space12);
		
		Paragraph noticeBody4 = new Paragraph();
		noticeBody4.add(new Chunk("Amount pending, as above, shall be deposited on or before Dated  " +amountDueDate + " in CECB, Raipur in the form of Demand Draft in favors of the Member Secretary (Water Cess), C.G. Environment Conservation Board, Raipur, failing which CECB may take action as per the provision given under section 11,12 and 14 of Water (Prevention and Control of Pollution) Cess Act, 1977 against the industry. ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody4.setFirstLineIndent(20);
		noticeBody4.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(noticeBody4); 
		
		document.add(space12);
		
		
		
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
		mem1.add(new Chunk("J & K Pollution Control Committee",
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
