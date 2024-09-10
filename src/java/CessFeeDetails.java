import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CessFeeDetails {
public File cessFeeDetails_Function(String offDistrict,String officeAddress,String industryName,String industryPlot,String industryAddress,String industryTehsil,String industryDistrict, String waterCessAssessmentOrderNo, String waterCessAssessmentOrderDate, String waterCessAssessmentOrderFrom, String waterCessAssessmentOrderTo, String interestAssessmentOrderNo, String interestAssessmentOrderDate, String interestAssessmentOrderFrom, String interestAssessmentOrderTo, String penaltyAssessmentOrderNo, String penaltyAssessmentOrderDate, String PenaltyAssessmentOrderFrom, String penaltyAssessmentOrderTo, String otherMiscAssessmentOrderNo, String otherMiscAssessmentOrderDate,String otherMiscAssessmentOrderFrom,String otherMiscAssessmentOrderTo,String waterCessAssessmentOrderAmount,String waterCessAssessmentOrderRemarks,String interestAssessmentOrderAmount,String interestAssessmentOrderRemarks,String penaltyAssessmentOrderAmount,String penaltyAssessmentOrderRemarks,String otherMiscAssessmentOrderAmount,String otherMiscAssessmentOrderRemarks,String codeNumber,String totRupees,String demandDraftRupees,String demandDraftDate,String demandDraftNo,String cessFeeDate,String rupeesInWords, String fromDate1, String toDate1) throws Exception {
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		
		/*Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);*/

		
		Font fontTable= new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE );
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

		
		
		Paragraph body1 = new Paragraph();
		body1.add(new Chunk("Water Cess Pay in slip", fontTable1));
		//noticeBody1.setIndentationLeft(20);
		document.add(body1);
		document.add(space12);
		PdfPTable table1=new PdfPTable(1);
		table1.setWidthPercentage(70);
		table1.setHorizontalAlignment (Element.ALIGN_LEFT);
		
		PdfPCell cell1 = new PdfPCell ();
		
		cell1 = new PdfPCell (new Paragraph ("Attention \n Please fill up this water cess pay in slop and send alongwith payment."));
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setPadding (100);
		table1.addCell (cell1);
		
		document.add(table1);
		

		Paragraph toAddress = new Paragraph("Name & Address of Consumer :");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);

		Paragraph indName = new Paragraph(industryName);
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(30);
		document.add(indName);

		Paragraph address = new Paragraph(industryPlot+" "+industryAddress);
		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(30);
		document.add(address);

		Paragraph tehsil = new Paragraph();
		tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsil.add(new Chunk(industryTehsil, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		tehsil.setIndentationLeft(30);
		document.add(tehsil);

		Paragraph district = new Paragraph();
		district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		district.add(new Chunk(industryDistrict, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		district.setIndentationLeft(30);
		document.add(district);

		document.add(space12);
		
		
		Paragraph asses = new Paragraph();
		asses.add(new Chunk("Code No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk("  "+codeNumber, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		asses.setIndentationLeft(20);
		document.add(asses);
		
		
		
		
		
		document.add(space12);
		
		
		// ---- Table 1 ----
		
		PdfPTable table2=new PdfPTable(2);
		table2.setWidthPercentage(100);
		
		PdfPCell cell2 = new PdfPCell ();
		
		cell2 = new PdfPCell (new Paragraph ("Assessment Order"));
		cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		cell2.setColspan(2);
		table2.addCell (cell2);
		
		cell2 = new PdfPCell (new Paragraph ("No."));
		cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table2.addCell (cell2);
		
		cell2 = new PdfPCell (new Paragraph ("Date"));
		cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell.setColspan(2);
		table2.addCell (cell2);
		// -----
		
		PdfPTable table3=new PdfPTable(2);
		table3.setWidthPercentage(100);
		
		PdfPCell cell3 = new PdfPCell ();
		
		cell3 = new PdfPCell (new Paragraph (" Period "));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		cell3.setColspan(2);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (" From "));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table3.addCell (cell3);
		
		cell3 = new PdfPCell (new Paragraph (" To "));
		cell3.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell.setColspan(2);
		table3.addCell (cell3);
		
		//  ---------------- table 4
		
		PdfPTable table4=new PdfPTable(2);
		table4.setWidthPercentage(100);
		
		PdfPCell cell4 = new PdfPCell ();
		
		cell4 = new PdfPCell (new Paragraph (waterCessAssessmentOrderNo));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table4.addCell (cell4);
		
		cell4 = new PdfPCell (new Paragraph (waterCessAssessmentOrderDate));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table4.addCell (cell4);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table44=new PdfPTable(2);
		table44.setWidthPercentage(100);
		
		PdfPCell cell44 = new PdfPCell ();
		
		cell44 = new PdfPCell (new Paragraph (waterCessAssessmentOrderFrom));
		cell44.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table44.addCell (cell44);
		
		cell44 = new PdfPCell (new Paragraph (waterCessAssessmentOrderTo));
		cell44.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table44.addCell (cell44);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table5=new PdfPTable(2);
		table5.setWidthPercentage(100);
		
		PdfPCell cell5 = new PdfPCell ();
		
		cell5 = new PdfPCell (new Paragraph (interestAssessmentOrderNo));
		cell5.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table5.addCell (cell5);
		
		cell5 = new PdfPCell (new Paragraph (interestAssessmentOrderDate));
		cell5.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table5.addCell (cell5);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table55=new PdfPTable(2);
		table55.setWidthPercentage(100);
		
		PdfPCell cell55 = new PdfPCell ();
		
		cell55 = new PdfPCell (new Paragraph (interestAssessmentOrderFrom));
		cell55.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table55.addCell (cell55);
		
		cell55 = new PdfPCell (new Paragraph (interestAssessmentOrderTo));
		cell55.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table55.addCell (cell55);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table6=new PdfPTable(2);
		table6.setWidthPercentage(100);
		
		PdfPCell cell6 = new PdfPCell ();
		
		cell6 = new PdfPCell (new Paragraph (penaltyAssessmentOrderNo));
		cell6.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell6.setColspan(2);
		table6.addCell (cell6);
		
		cell6 = new PdfPCell (new Paragraph (penaltyAssessmentOrderDate));
		cell6.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table6.addCell (cell6);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table66=new PdfPTable(2);
		table66.setWidthPercentage(100);
		
		PdfPCell cell66 = new PdfPCell ();
		
		cell66 = new PdfPCell (new Paragraph (PenaltyAssessmentOrderFrom));
		cell66.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table66.addCell (cell66);
		
		cell66 = new PdfPCell (new Paragraph (penaltyAssessmentOrderTo));
		cell66.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table66.addCell (cell66);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table7=new PdfPTable(2);
		table7.setWidthPercentage(100);
		
		PdfPCell cell7 = new PdfPCell ();
		
		cell7 = new PdfPCell (new Paragraph (otherMiscAssessmentOrderNo));
		cell7.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table7.addCell (cell7);
		
		cell7 = new PdfPCell (new Paragraph (otherMiscAssessmentOrderDate));
		cell7.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table7.addCell (cell7);
		
		
		
		//
//  ---------------- table 4
		
		PdfPTable table77=new PdfPTable(2);
		table77.setWidthPercentage(100);
		
		PdfPCell cell77 = new PdfPCell ();
		
		cell77 = new PdfPCell (new Paragraph (otherMiscAssessmentOrderFrom));
		cell77.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell4.setColspan(2);
		table77.addCell (cell77);
		
		cell77 = new PdfPCell (new Paragraph (otherMiscAssessmentOrderTo));
		cell77.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		//cell2.setColspan(2);
		table77.addCell (cell77);
		
		
		
		//
		
		// ---- Table ----- 
		
		PdfPTable table=new PdfPTable(6);
		table.setWidthPercentage(100);
		
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph ("S.No"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (100);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Details",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (table2);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell ((table3));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Amount",fontTable1));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("Remarks"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph ("1"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Water Cess (U/s 6)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell ((table4));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell ((table44));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (waterCessAssessmentOrderAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (waterCessAssessmentOrderRemarks));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		
		// ------2222 --------
		cell = new PdfPCell (new Paragraph ("2"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Interest (U/s 10)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell ((table5));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell ((table55));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (interestAssessmentOrderAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (interestAssessmentOrderRemarks));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		// -----------------
		
		// -----33333-----
		cell = new PdfPCell (new Paragraph ("3"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph ("Penalty (U/s 11)"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell ((table6));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell ((table66));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (penaltyAssessmentOrderAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (penaltyAssessmentOrderRemarks));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		// ---

		// ----44444----
		cell = new PdfPCell (new Paragraph ("4"));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (" Other Misc-Payment "));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setPadding (5.0f);
		table.addCell (cell);
		
		cell = new PdfPCell ((table7));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell ((table77));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (otherMiscAssessmentOrderAmount));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (otherMiscAssessmentOrderRemarks));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		//cell.setPadding (10.0f);
		table.addCell (cell);
		// -------
		
		cell = new PdfPCell (new Paragraph (" Total Amount : Rs. "+ totRupees));
		cell.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setColspan(6);
		table.addCell (cell);
		
		document.add(table);
		
	
		document.add(space12);
		document.add(space12);
		
		Paragraph noticeBody2 = new Paragraph();
		noticeBody2.add(new Chunk("Payment deposit as per above details through demand draft. No. "+demandDraftNo+"   date : "+ demandDraftDate+" Rs. "+demandDraftRupees+" (In words) "+rupeesInWords, fontTable));
		document.add(noticeBody2);
		
		document.add(space12);

		Paragraph noticeBody3 = new Paragraph();
		noticeBody3.add(new Chunk("Date :- "+cessFeeDate, fontTable));
		document.add(noticeBody3);

		Paragraph mem = new Paragraph();
		mem.add(new Chunk(" Signature of the depositor ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem);

		
		
		
		
		document.close();
		return tempFile;
	}

}
