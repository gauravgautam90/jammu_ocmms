

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





public class CtoWaterPdfGeneration {
	public File pdfFunction(String endtNumberIn,String productD,String productQ,String certData,String fileNum,String offDistrict,String draftDate,String officeAddress,String reference,
			String name, String address1, String tehsilName,
			String districtName,  String gCondition,
			String sCondition,String copyTo) throws Exception {
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

		

		Paragraph space = new Paragraph();
		space.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space);
		document.add(space);
		Paragraph subj = new Paragraph();
		subj.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		subj.add(new Chunk("Consent of the Committee Under Section 25/26 of the Water (Prevention and Control of Pollution) Act, 1974. ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		subj.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(subj);

		List list = new List(true, 30);

		list.add(new ListItem(reference));

		
		document.add(space);

		Paragraph refr = new Paragraph();
		refr.add(new Chunk("Ref :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(refr);

		Paragraph refrence = new Paragraph();

		refrence.add(list);
		refrence.setIndentationLeft(20);
		document.add(refrence);

		document.add(space);

		Paragraph para = new Paragraph(certData);
		para.setFirstLineIndent(40);
		document.add(para);

		
		document.add(space);
		
		
		Paragraph specificString1 = new Paragraph("This consent is valid for following products & production capacity:-");
		specificString1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(specificString1);
		
		document.add(space);
		
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
		
		Paragraph ackn = new Paragraph("Please acknowledge the receipt of this letter.");
		document.add(ackn);
		
		document.add(space);

		Paragraph behalf = new Paragraph();
		behalf.add(new Chunk("For & on behalf of                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		behalf.setAlignment(Element.ALIGN_RIGHT);
		document.add(behalf);

		Paragraph sigNat = new Paragraph();
		sigNat.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		sigNat.setAlignment(Element.ALIGN_RIGHT);
		document.add(sigNat);
		
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);

		Paragraph memBer = new Paragraph();
		memBer.add(new Chunk("Member Secretary                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		memBer.setAlignment(Element.ALIGN_RIGHT);
		document.add(memBer);

		Paragraph memCh = new Paragraph();
		memCh.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		memCh.setAlignment(Element.ALIGN_RIGHT);
		document.add(memCh);
		
		
		Paragraph videNoFirst = new Paragraph();

		videNoFirst.add(new Chunk("Endt No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNoFirst.add(new Chunk("  " +endtNumberIn, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk(offDistrict+" ,Dated:" + draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNoFirst);
		
		Paragraph toCopyFirst = new Paragraph("Copy To:-");
		
		document.add(toCopyFirst);
		
		document.add(space);
		
		Paragraph copYtoFirst = new Paragraph(copyTo);
		copYtoFirst.setIndentationLeft(20);
		document.add(copYtoFirst);
		
		document.add(space);
		
		List listCopy = new List(true, 30);

		listCopy.add(new ListItem("Regional Officer,Regional Office,J & K Pollution Control Committee, "+offDistrict+" .Please ensure compliance and report if any condition/conditions are violated by the industry."));
		listCopy.add(new ListItem("Cess Section,J & K Pollution Control Committee"));

		document.add(listCopy);
		
		document.add(space);
		document.add(space);
		document.add(space);
		
		document.add(memBer);
		document.add(memCh);
		
		document.newPage();
		// Consent letter //
		
		document.add(image);

		document.add(heading);

		document.add(subHeading);

		document.add(space);
		
		Paragraph subHeadingConsent = new Paragraph();
		subHeadingConsent.add(new Chunk("Consent Letter",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeadingConsent.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeadingConsent);

		document.add(videNo);
		
		Paragraph subjConsent = new Paragraph();
		subjConsent.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		subjConsent.add(new Chunk("Consent to Operate for the discharge of effluent under section 25/26 of the Water (Prevention & Control of Pollution) Act, 1974.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		subjConsent.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(subjConsent);
		
		document.add(refr);
		
		List listConsent = new List(true, 30);

		listConsent.add(new ListItem("Your Application letter no. -------------------- dated --------------- and subsequent correspondence ending dated -----------------. (Expiry date after a period of ……………. from the date of the commissioning of the plant)."));
		listConsent.add(new ListItem("With reference to the above application for consent to discharge effluent into the natural water courses under the Water (Prevention & Control of Pollution) Act, 1974, here-in-after referred to as the Act --------------------------- is authorized by the State Committee to discharge its industrial and other effluents arising out of their premises into the local stream/river/well in accordance with the general and special conditions as mentioned in the Annexure."));
		listConsent.add(new ListItem("This consent shall be valid for a period of …………… from the date of the commissioning of the plant with expanded capacity."));
		document.add(listCopy);
		
		document.add(space);
		document.add(specificString1);
		document.add(space);
		document.add(table);
		document.add(space);
		document.add(ackn);
		document.add(space);
		
		document.add(behalf);
		
		document.add(sigNat);
		
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		
		document.add(memBer);
		document.add(memCh);
		// ******************//
		
		document.newPage();
		
		Paragraph annexHeading = new Paragraph();
		annexHeading.add(new Chunk("(I)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		annexHeading.setAlignment(Element.ALIGN_CENTER);

		document.add(annexHeading);
		
		Paragraph annex = new Paragraph();
		annex.add(new Chunk("ANNEXURE",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		annex.setAlignment(Element.ALIGN_CENTER);
		document.add(annex);
		
		Paragraph indNameAnnex = new Paragraph(name);
		indNameAnnex.setExtraParagraphSpace(50.0f);
		indNameAnnex.setIndentationLeft(20);
		document.add(indNameAnnex);

		Paragraph addressAnnex = new Paragraph(address1);

		addressAnnex.setExtraParagraphSpace(50.0f);
		addressAnnex.setIndentationLeft(20);
		document.add(addressAnnex);

		Paragraph tehsilAnnex = new Paragraph();
		tehsilAnnex.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsilAnnex.add(new Chunk(tehsilName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		tehsilAnnex.setIndentationLeft(20);
		document.add(tehsilAnnex);

		Paragraph districtAnnex = new Paragraph();
		districtAnnex.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		districtAnnex.add(new Chunk(districtName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		districtAnnex.setIndentationLeft(20);
		document.add(districtAnnex);
		
		document.add(space);
		
		document.add(videNoFirst);
		
		Paragraph termsCondition = new Paragraph();
		termsCondition.add(new Chunk("Terms & Conditions:-", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(termsCondition);

		Paragraph space20 = new Paragraph();
		space20.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space20.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space20);

		Chunk chunk = new Chunk("Specific Conditions ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		chunk.setUnderline(0.2f, -2f);

		Paragraph specific = new Paragraph();
		specific.add(chunk);
		specific.setAlignment(Element.ALIGN_LEFT);
		document.add(specific);

		
		Paragraph specificString = new Paragraph(sCondition);
		specificString.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(specificString);
		
		document.add(space);

		Chunk chunk1 = new Chunk("General Conditions ", new Font(
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
		"        This consent and the authorization to discharge shall expire on midnight after a period of three months from the date of the commissioning of the plant with expanded capacity.  The applicant shall not discharge after the date of expiration. The applicant shall submit an application for extension of the validity of consent prior to expiry of this consent. ");
		paraLast.setFirstLineIndent(40);
		paraLast.setAlignment(Element.ALIGN_JUSTIFIED);

		document.add(paraLast);
		
		Paragraph paraLast1 = new Paragraph(
		"  The applicant shall submit such information forms and fees as required by the Committee not latter than 180 days prior to the date of expiry for annual renewals.");
		paraLast1.setFirstLineIndent(40);
		paraLast1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraLast1);

		
		document.add(space);

		document.add(behalf);
		document.add(sigNat);
		
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		
		document.add(memBer);
		document.add(memCh);

		

		document.close();
		return tempFile;
	}

	public File pdfFunctionArray(String endtNumberIn,String productD,String productQ,String certData,String fileNum,String offDistrict,String draftDate,String officeAddress,String[] referencearray,
			 String name, String address1, String tehsilName,
			String districtName,
			   String gCondition,
			String sCondition,String copyTo) throws Exception {
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
		toAddress.setAlignment(Element.ALIGN_LEFT);
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
		subj.add(new Chunk("Consent of the Committee Under Section 25/26 of the Water (Prevention and Control of Pollution) Act, 1974. ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		subj.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(subj);


		List list = new List(true, 30);
		for (int refVar = 0; refVar < referencearray.length; refVar++) {
			list.add(new ListItem(referencearray[refVar]));
		}

		document.add(space);

		Paragraph refr = new Paragraph();
		refr.add(new Chunk("Ref :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(refr);

		Paragraph refrence = new Paragraph();

		refrence.add(list);
		refrence.setIndentationLeft(20);
		document.add(refrence);
		document.add(space);

		Paragraph para = new Paragraph(certData);
		para.setFirstLineIndent(40);
		document.add(para);

		
		document.add(space);
		
		
		Paragraph specificString1 = new Paragraph("This consent is valid for following products & production capacity:-");
		specificString1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(specificString1);
		
		document.add(space);
		
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
		
		Paragraph ackn = new Paragraph("Please acknowledge the receipt of this letter.");
		document.add(ackn);
		
		document.add(space);

		Paragraph behalf = new Paragraph();
		behalf.add(new Chunk("For & on behalf of                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		behalf.setAlignment(Element.ALIGN_RIGHT);
		document.add(behalf);

		Paragraph sigNat = new Paragraph();
		sigNat.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		sigNat.setAlignment(Element.ALIGN_RIGHT);
		document.add(sigNat);
		
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);

		Paragraph memBer = new Paragraph();
		memBer.add(new Chunk("Member Secretary                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		memBer.setAlignment(Element.ALIGN_RIGHT);
		document.add(memBer);

		Paragraph memCh = new Paragraph();
		memCh.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		memCh.setAlignment(Element.ALIGN_RIGHT);
		document.add(memCh);
		
		
		Paragraph videNoFirst = new Paragraph();

		videNoFirst.add(new Chunk("Endt No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNoFirst.add(new Chunk("  " +endtNumberIn, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNoFirst.add(new Chunk(offDistrict+" ,Dated:" + draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNoFirst);
		
		Paragraph toCopyFirst = new Paragraph("Copy To:-");
		
		document.add(toCopyFirst);
		
		document.add(space);
		
		Paragraph copYtoFirst = new Paragraph(copyTo);
		copYtoFirst.setIndentationLeft(20);
		document.add(copYtoFirst);
		
		document.add(space);
		
		List listCopy = new List(true, 30);

		listCopy.add(new ListItem("Regional Officer,Regional Office,J & K Pollution Control Committee, "+offDistrict+" .Please ensure compliance and report if any condition/conditions are violated by the industry."));
		listCopy.add(new ListItem("Cess Section,J & K Pollution Control Committee"));
		document.add(listCopy);
		
		
		
		document.add(space);
		document.add(space);
		document.add(space);
		
		document.add(memBer);
		document.add(memCh);
		
		document.newPage();
// Consent letter //
		
		document.add(image);

		document.add(heading);

		
		document.add(subHeading);

		document.add(space);
		
		Paragraph subHeadingConsent = new Paragraph();
		subHeadingConsent.add(new Chunk("Consent Letter",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeadingConsent.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeadingConsent);

		document.add(videNo);
		
		Paragraph subjConsent = new Paragraph();
		subjConsent.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		subjConsent.add(new Chunk("Consent to Operate for the discharge of effluent under section 25/26 of the Water (Prevention & Control of Pollution) Act, 1974.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		subjConsent.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(subjConsent);
		
		document.add(refr);
		
		List listConsent = new List(true, 30);

		listConsent.add(new ListItem("Your Application letter no. -------------------- dated --------------- and subsequent correspondence ending dated -----------------. (Expiry date after a period of ……………. from the date of the commissioning of the plant)."));
		listConsent.add(new ListItem("With reference to the above application for consent to discharge effluent into the natural water courses under the Water (Prevention & Control of Pollution) Act, 1974, here-in-after referred to as the Act --------------------------- is authorized by the State Committee to discharge its industrial and other effluents arising out of their premises into the local stream/river/well in accordance with the general and special conditions as mentioned in the Annexure."));
		listConsent.add(new ListItem("This consent shall be valid for a period of …………… from the date of the commissioning of the plant with expanded capacity."));
		document.add(listCopy);
		
		document.add(space);
		document.add(specificString1);
		document.add(space);
		document.add(table);
		document.add(space);
		document.add(ackn);
		document.add(space);
		
		document.add(behalf);
		
		document.add(sigNat);
		
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		
		document.add(memBer);
		document.add(memCh);
		// ******************//
		
		document.newPage();
		
		Paragraph annexHeading = new Paragraph();
		annexHeading.add(new Chunk("(I)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		annexHeading.setAlignment(Element.ALIGN_CENTER);

		document.add(annexHeading);
		
		Paragraph annex = new Paragraph();
		annex.add(new Chunk("ANNEXURE",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		annex.setAlignment(Element.ALIGN_CENTER);
		document.add(annex);
		
		Paragraph indNameAnnex = new Paragraph(name);
		indNameAnnex.setExtraParagraphSpace(50.0f);
		indNameAnnex.setIndentationLeft(20);
		document.add(indNameAnnex);

		Paragraph addressAnnex = new Paragraph(address1);

		addressAnnex.setExtraParagraphSpace(50.0f);
		addressAnnex.setIndentationLeft(20);
		document.add(addressAnnex);

		Paragraph tehsilAnnex = new Paragraph();
		tehsilAnnex.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsilAnnex.add(new Chunk(tehsilName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		tehsilAnnex.setIndentationLeft(20);
		document.add(tehsilAnnex);

		Paragraph districtAnnex = new Paragraph();
		districtAnnex.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		districtAnnex.add(new Chunk(districtName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		districtAnnex.setIndentationLeft(20);
		document.add(districtAnnex);
		
		document.add(space);
		
		document.add(videNoFirst);
		
		Paragraph termsCondition = new Paragraph();
		termsCondition.add(new Chunk("Terms & Conditions:-", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(termsCondition);

		Paragraph space20 = new Paragraph();
		space20.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space20.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space20);

		Chunk chunk = new Chunk("Specific Conditions ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		chunk.setUnderline(0.2f, -2f);

		Paragraph specific = new Paragraph();
		specific.add(chunk);
		specific.setAlignment(Element.ALIGN_LEFT);
		document.add(specific);

		
		Paragraph specificString = new Paragraph(sCondition);
		specificString.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(specificString);

		document.add(space);

		Chunk chunk1 = new Chunk("General Conditions ", new Font(
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
		"        This consent and the authorization to discharge shall expire on midnight after a period of three months from the date of the commissioning of the plant with expanded capacity.  The applicant shall not discharge after the date of expiration. The applicant shall submit an application for extension of the validity of consent prior to expiry of this consent. ");
		paraLast.setFirstLineIndent(40);
		paraLast.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraLast);
		
		Paragraph paraLast1 = new Paragraph(
		"  The applicant shall submit such information forms and fees as required by the Committee not latter than 180 days prior to the date of expiry for annual renewals.");
		paraLast1.setFirstLineIndent(40);
		paraLast1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraLast1);

		
		document.add(space);

		document.add(behalf);
		document.add(sigNat);
		
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(space);
		
		document.add(memBer);
		document.add(memCh);

		

		document.close();
		return tempFile;
	}

}
