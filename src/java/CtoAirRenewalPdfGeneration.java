

import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;





public class CtoAirRenewalPdfGeneration {
	public File pdfFunction(String endtNumberIn,String dateFrom, String dateTo,String productD,String productQ,String certData,String fileNum,String offDistrict,String draftDate,String officeAddress,String reference,
			String name, String address1, String tehsilName,
			String districtName,  String gCondition,
			String copyTo) throws Exception {
		// Rectangle pageSize = new Rectangle(PageSize.A4);
		// // pageSize.setBackgroundColor
		// // (new java.awt.Color(0xaa, 0xaa, 0xDE));
		 //File tempFile = null;
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		//tempFile = File.createTempFile("certificate.pdf", ".tmp" );
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);

		Paragraph date = new Paragraph();
		date.add(new Chunk("Date :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		date.add(new Chunk(draftDate, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));

		date.setAlignment(Element.ALIGN_RIGHT);
		document.add(date);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J & K Pollution Control Committee",
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
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);

		Paragraph videNo = new Paragraph();

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

		document.add(videNo);

		Paragraph toAddress = new Paragraph("To,");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);

		Paragraph indName = new Paragraph(name);
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);

		Paragraph address = new Paragraph(address1);

		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(20);
		document.add(address);

		Paragraph tehsil = new Paragraph();
		tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsil.add(new Chunk(tehsilName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		tehsil.setIndentationLeft(20);
		document.add(tehsil);

		Paragraph district = new Paragraph();
		district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		district.add(new Chunk(districtName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));

		district.setIndentationLeft(20);
		document.add(district);

		Paragraph space7 = new Paragraph();
		space7.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space7.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space7);

		Paragraph space = new Paragraph();
		space.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space);

		Paragraph subj = new Paragraph();
		subj.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		subj.add(new Chunk("Renewal of consent Under Section 21 of the Air (Prevention and Control of Pollution) Act,1981.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		subj.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(subj);

		List list = new List(true, 30);

		list.add(new ListItem(reference));

		Paragraph space8 = new Paragraph();
		space8.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space8.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space8);

		Paragraph refr = new Paragraph();
		refr.add(new Chunk("Ref :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));

		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(refr);

		Paragraph refrence = new Paragraph();

		refrence.add(list);
		refrence.setIndentationLeft(20);
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(refrence);

		Paragraph space1 = new Paragraph();
		space1.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space1.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space1);

		Paragraph para = new Paragraph("With reference to your above application consent is hereby renewed for a period from"+dateFrom +" to "+dateTo+" , subject to the fulfillment of the terms and conditions incorporated in the consent letter no. "+fileNum+" "+offDistrict+" , dated :"+draftDate+" , issued by the Committee and additional conditions mentioned below:");
		para.setFirstLineIndent(40);
		para.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(para);

		
		Paragraph space9 = new Paragraph();
		space9.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space9.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space9);
		
		
		Paragraph specificString1 = new Paragraph("This renewal of consent is valid for production capacity of:-");
		specificString1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(specificString1);
		
		document.add(space9);
		
		PdfPTable table=new PdfPTable(2);
		
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph (new Chunk("Product", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Production Capacity", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (productD));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (productQ));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		document.add(table);

		document.add(space);
		
		Paragraph termsCondition = new Paragraph();
		termsCondition.add(new Chunk("Terms & Conditions:-", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(termsCondition);

		

		
		

		Paragraph space19 = new Paragraph();
		space19.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space19.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space19);

		Chunk chunk1 = new Chunk("Additional Conditions ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		chunk1.setUnderline(0.2f, -2f);

		Paragraph general = new Paragraph();

		general.setAlignment(Element.ALIGN_LEFT);
		general.add(chunk1);
		document.add(general);

		Paragraph generalString = new Paragraph(gCondition);
		generalString.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(generalString);
		Paragraph paraLast = new Paragraph(
		"        Please acknowledge the receipt of this letter.");
		paraLast.setFirstLineIndent(40);
		
		document.add(paraLast);
		
		Paragraph paraLast1 = new Paragraph(
		"  For & on behalf of J & K Pollution Control Committee ");
		paraLast1.setFirstLineIndent(40);
		paraLast1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraLast1);

		Paragraph space11 = new Paragraph();
		space11.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space11.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space11);

		Paragraph lastS = new Paragraph();
		lastS.add(new Chunk("For & on behalf of                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lastS.setAlignment(Element.ALIGN_RIGHT);
		document.add(lastS);

		Paragraph lastSign = new Paragraph();
		lastSign.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lastSign.setAlignment(Element.ALIGN_RIGHT);
		document.add(lastSign);

		Paragraph space2 = new Paragraph();
		space2.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space2.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space2);

		Paragraph space3 = new Paragraph();
		space3.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space3.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space3);

		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space4);

		Paragraph space5 = new Paragraph();
		space5.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space5.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space5);

		Paragraph space6 = new Paragraph();
		space6.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space6.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space6);

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
		document.add(space6);
		document.add(space6);
		document.add(space6);
		
		Paragraph videNo1 = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo1.add(new Chunk("Endt No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo1.add(new Chunk("  " +endtNumberIn, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk(offDistrict+" ,Dated:" + draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));

		document.add(videNo1);
		
		Paragraph toAddress1 = new Paragraph("Copy To:-");
		
		document.add(toAddress1);
		
		document.add(space6);
		
		Paragraph copYtoo = new Paragraph(copyTo);

		
		copYtoo.setIndentationLeft(20);
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(copYtoo);
		
		document.add(space6);
		
		Paragraph copYtoo1 = new Paragraph("Regional Officer,Regional Office,J & K Pollution Control Committee, "+offDistrict+" .Please ensure compliance and report if any condition/conditions are violated by the industry.");

		
		copYtoo1.setIndentationLeft(20);
		copYtoo1.setAlignment(Element.ALIGN_JUSTIFIED);
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(copYtoo1);
		
		
		document.add(space6);
		document.add(space6);
		document.add(space6);
		
		document.add(mem);

		
		document.add(mem1);

		document.close();
		return tempFile;
	}

	public File pdfFunctionArray(String endtNumberIn,String dateFrom, String dateTo,String productD,String productQ,String certData,String fileNum,String offDistrict,String draftDate,String officeAddress,String[] referencearray,
			 String name, String address1, String tehsilName,
			String districtName,
			   String gCondition,
			String copyTo) throws Exception {
		// Rectangle pageSize = new Rectangle(PageSize.A4);
		// // pageSize.setBackgroundColor
		// // (new java.awt.Color(0xaa, 0xaa, 0xDE));
		File tempFile = new File("certificate.pdf");
		Document document = new Document(PageSize.A4);

		
		//tempFile = File.createTempFile("certificate.pdf", ".tmp" );
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);

		Paragraph date = new Paragraph();
		date.add(new Chunk("Date :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		date.add(new Chunk(draftDate, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));

		date.setAlignment(Element.ALIGN_RIGHT);
		document.add(date);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J & K Pollution Control Committee",
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
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);

		Paragraph videNo = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo.add(new Chunk("No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " + fileNum, new Font(
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

		document.add(videNo);

		Paragraph toAddress = new Paragraph("To,");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);

		Paragraph indName = new Paragraph(name);
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);

		Paragraph address = new Paragraph(address1);

		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(20);
		document.add(address);

		Paragraph tehsil = new Paragraph();
		tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsil.add(new Chunk(tehsilName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		tehsil.setIndentationLeft(20);
		document.add(tehsil);

		Paragraph district = new Paragraph();
		district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		district.add(new Chunk(districtName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));

		district.setIndentationLeft(20);
		document.add(district);

		Paragraph space7 = new Paragraph();
		space7.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space7.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space7);

		Paragraph space = new Paragraph();
		space.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space);

		Paragraph subj = new Paragraph();
		subj.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		subj.add(new Chunk("Renewal of consent Under Section 21 of the Air (Prevention and Control of Pollution) Act,1981.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		subj.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(subj);

		List list = new List(true, 30);
		for (int refVar = 0; refVar < referencearray.length; refVar++) {
			list.add(new ListItem(referencearray[refVar]));
		}

		Paragraph space8 = new Paragraph();
		space8.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space8.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space8);

		Paragraph refr = new Paragraph();
		refr.add(new Chunk("Ref :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));

		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(refr);

		Paragraph refrence = new Paragraph();

		refrence.add(list);
		refrence.setIndentationLeft(20);
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(refrence);

		Paragraph space1 = new Paragraph();
		space1.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space1.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space1);

		Paragraph para = new Paragraph("With reference to your above application consent is hereby renewed for a period from"+dateFrom +" to "+dateTo+" , subject to the fulfillment of the terms and conditions incorporated in the consent letter no. "+fileNum+" "+offDistrict+" , dated :"+draftDate+" , issued by the Committee and additional conditions mentioned below:");
		para.setFirstLineIndent(40);
		para.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(para);

		
		Paragraph space9 = new Paragraph();
		space9.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space9.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space9);

document.add(space9);
		
		
		Paragraph specificString1 = new Paragraph("This consent is valid for following products & production capacity:-");
		document.add(specificString1);
		specificString1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(space9);
		
		PdfPTable table=new PdfPTable(2);
		
		PdfPCell cell = new PdfPCell ();
		
		cell = new PdfPCell (new Paragraph (new Chunk("Product", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);
		
		cell = new PdfPCell (new Paragraph (new Chunk("Production Capacity", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (productD));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		cell = new PdfPCell (new Paragraph (productQ));
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell.setBackgroundColor (new Color (255, 200, 0));
		cell.setPadding (10.0f);
		table.addCell (cell);

		document.add(table);

		document.add(space);
		
		Paragraph termsCondition = new Paragraph();
		termsCondition.add(new Chunk("Terms & Conditions:-", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(termsCondition);

		

		Paragraph space19 = new Paragraph();
		space19.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space19.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space19);

		Chunk chunk1 = new Chunk("Additional Conditions ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		chunk1.setUnderline(0.2f, -2f);

		Paragraph general = new Paragraph();

		general.setAlignment(Element.ALIGN_LEFT);
		general.add(chunk1);
		document.add(general);

		

		Paragraph generalString = new Paragraph(gCondition);
		generalString.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(generalString);

		Paragraph paraLast = new Paragraph(
				"        This consent is valid for the stated period. The applicant shall make an application for extension of validity of consent prior to expiry of the consent. ");
		paraLast.setFirstLineIndent(40);
		paraLast.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraLast);

		Paragraph paraLast1 = new Paragraph(
		"  For annual renewal application with annual license fee in this regard shall reach the office 3 months before the expiry of this consent.");
		paraLast1.setFirstLineIndent(40);
		paraLast1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraLast1);
		
		
		
		Paragraph space11 = new Paragraph();
		space11.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space11.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space11);

		Paragraph lastS = new Paragraph();
		lastS.add(new Chunk("For & on behalf of                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lastS.setAlignment(Element.ALIGN_RIGHT);
		document.add(lastS);

		Paragraph lastSign = new Paragraph();
		lastSign.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lastSign.setAlignment(Element.ALIGN_RIGHT);
		document.add(lastSign);

		Paragraph space2 = new Paragraph();
		space2.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space2.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space2);

		Paragraph space3 = new Paragraph();
		space3.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space3.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space3);

		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space4);

		Paragraph space5 = new Paragraph();
		space5.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space5.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space5);

		Paragraph space6 = new Paragraph();
		space6.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space6.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space6);

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
		
		document.add(space6);
		document.add(space6);
		document.add(space6);
		
		Paragraph videNo1 = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo1.add(new Chunk("Endt No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo1.add(new Chunk("  " +endtNumberIn, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk(offDistrict+" ,Dated:" + draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));

		document.add(videNo1);
		document.add(space6);
		document.add(space6);
		
Paragraph toAddress1 = new Paragraph("Copy To:-");
		
		document.add(toAddress1);
		document.add(space6);
		
		
		Paragraph copYtoo = new Paragraph(copyTo);

		
		copYtoo.setIndentationLeft(20);
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(copYtoo);
		
		document.add(space6);
Paragraph copYtoo1 = new Paragraph("Regional Officer,Regional Office,J & K Pollution Control Committee, "+offDistrict+" .Please ensure compliance and report if any condition/conditions are violated by the industry.");

		
		copYtoo1.setIndentationLeft(20);
		copYtoo1.setAlignment(Element.ALIGN_JUSTIFIED);
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(copYtoo1);
		
		
		document.add(space6);
		document.add(space6);
		document.add(space6);

		
		document.add(mem);

		
		document.add(mem1);
		
		document.close();
		return tempFile;
	}

}
