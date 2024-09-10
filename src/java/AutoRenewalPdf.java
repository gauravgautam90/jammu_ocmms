import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.lowagie.text.Element;





public class AutoRenewalPdf {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public File generateLabSampleBill(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated,String capInvest,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,String regId,String regDate,String indCity,String indPin,String tehsil1 
			,String district,String applType,String maxQuantity,ArrayList productDetailsList1,ArrayList solidWasteDisposalDetailsList1,	ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String currentYear,String industrytype12,
			String offDistrict,String endtNumberIn,String subject,String appID,String yearString,String issuingConsentTypeNo,String nameOfDistrict,
			String waterConsume,String authno,String sewageEffluent,String indName,String indRegNum,String indRegDate,ArrayList PollutionControlList,String indCategory,String DownloadDateAndTime,ArrayList hotelFacilityDetail,String applicationFor) {
		// TODO Auto-generated method stub

		File tempFile = new File("certificate.pdf");
		Document document = new Document(PageSize.A4,10, 10, 10, 80);
		document.setMargins(50, 45, 55, 60); //22-09-2021
		System.out.println("TestingPdfGenerated--tempFile--" + tempFile);

		try {
			System.out.println("totalCharges-pdf--" + "");
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(tempFile));
			
			

			Phrase footerPhrase = new Phrase("“This is computer generated document from OCMMS by JKPCC”"+"\n"+"This is a computer generated consent order (AUTO-RENEWAL) from JKPCC – issued under EoDB and does not require any signature",
					new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 4,
							Font.ITALIC));
            
			// Paragraph footerPhrase = new Paragraph ();
			// footerPhrase.add(tableB1I);

			/*
			 * HeaderFooter footer = new HeaderFooter(footerPhrase, true);
			 * footer.setAlignment(Element.ALIGN_LEFT);
			 * footer.setBorder(Rectangle.NO_BORDER);
			 * 
			 * document.setFooter(footer);
			 */
			// document.setFooter(footer);
		/*	HeaderFooterPageEventNew event = new HeaderFooterPageEventNew();
			writer.setPageEvent(event);*/
			document.open();

			// Add watermark .. DateCreated: 24-02-2021....
			// writer.setPageEvent(new WatermarkPageEvent());

			
			// Start Adding QR code on the top of signature...
			PdfContentByte cb2 = writer.getDirectContent();
			BarcodeQRCode barcodeQRCode2 = new BarcodeQRCode("JKPCB - PCC/digital/"+yearString+issuingConsentTypeNo+appID, 500, 500,
					null);
			Image codeQrImage2 = barcodeQRCode2.getImage();
			codeQrImage2.scaleAbsolute(50, 50);
			codeQrImage2.setAlignment(Element.ALIGN_CENTER);
			
			document.add(codeQrImage2);
			// END Adding QR code ...
			
			Image image = Image.getInstance("images2/jammu.jpg");
			image.scalePercent(50.0f);
			image.setAlignment(Image.LEFT | Image.TEXTWRAP);
			document.add(image);
			
		/*	Image background = Image.getInstance("images2/watermark_final1.jpg");
			background.scalePercent(50f);
			float width = document.getPageSize().getWidth();
	        float height = document.getPageSize().getHeight();
	        writer.getDirectContentUnder().addImage(background, width,50,50,height,50,50);
			background.scalePercent(100.0f);
			background.setAlignment(Element.ALIGN_CENTER);
	        document.add(background);*/
	        
	        
			Paragraph heading4 = new Paragraph();
			heading4.add(new Chunk("Government of Jammu and Kashmir                \nJ&K Pollution Control Committee               " +
				"\nJammu/Kashmir (www.jkocmms.nic.in)         ",
					new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE + 2,
							Font.BOLD)));
			heading4.setAlignment(Element.ALIGN_CENTER);
			
			document.add(heading4);

			
			Paragraph heading5 = new Paragraph();
			heading5.add(new Chunk("Consent Order         ", new Font(
							FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
							Font.BOLD)));
			heading5.setAlignment(Element.ALIGN_CENTER);
			document.add(heading5);
			
			Paragraph heading15 = new Paragraph();
			heading15.add(new Chunk("(AUTO RENEWAL (GREEN) under Ease of Doing Business)", new Font(
							FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
							Font.BOLD)));
			heading15.setAlignment(Element.ALIGN_CENTER);
			document.add(heading15);
			// Start Adding QR code on the top of signature...
			/*PdfContentByte cb2 = writer.getDirectContent();
			BarcodeQRCode barcodeQRCode2 = new BarcodeQRCode(endtNumberIn, 500, 500,
					null);
			Image codeQrImage2 = barcodeQRCode2.getImage();
			codeQrImage2.scaleAbsolute(40, 40);
			codeQrImage2.setAlignment(Element.ALIGN_RIGHT);
			document.add(codeQrImage2);*/
			// END Adding QR code ...
			Paragraph space4 = new Paragraph();
			space4.add(new Chunk("\n", new Font(FontFamily.HELVETICA,
					Font.DEFAULTSIZE)));
			document.add(space4);// used for space4

			PdfPTable table2 = new PdfPTable(3);
			table2.setWidthPercentage(100);
			PdfPCell cell22 = new PdfPCell();
			float[] columnWidths2 = {0.2f,3f,1f};
			table2.setWidths(columnWidths2);
			
			cell22 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell22.setVerticalAlignment(Element.ALIGN_LEFT);
			cell22.setPadding(3.0f);
			cell22.setBorder(PdfPCell.NO_BORDER);
//			cell22.setBorder(Rectangle.TOP);
//			cell22.setBorder(Rectangle.BOTTOM);
			
			
			table2.addCell(cell22);
			
			cell22 = new PdfPCell(new Paragraph(new Chunk(" Consent No.:- PCC/digital/"+yearString+issuingConsentTypeNo+appID+" of "+currentYear, new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell22.setVerticalAlignment(Element.ALIGN_LEFT);
			cell22.setPadding(3.0f);
			cell22.setBorder(PdfPCell.NO_BORDER);
//			cell22.setBorder(Rectangle.TOP);
//			cell22.setBorder(Rectangle.BOTTOM);
			
			
			table2.addCell(cell22);
			
			cell22 = new PdfPCell(new Paragraph(new Chunk("Date:- "+ draftDate, new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell22.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell22.setVerticalAlignment(Element.ALIGN_CENTER);
			cell22.setPadding(3.0f);
			cell22.setBorder(PdfPCell.NO_BORDER);
		//	cell22.setBorder(Rectangle.TOP);
//			cell22.setBorder(Rectangle.BOTTOM);
			table2.addCell(cell22);
			
			
			
				document.add(table2);
			
		//	document.add(space4);
			
			
		
	
			
			
		/*	cell41 = new PdfPCell(new Paragraph(new Chunk("To,", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(3.0f);
			cell41.setBorder(PdfPCell.NO_BORDER);
			//cell41.setBorderColor(new Color(0, 0, 0));
			table41.addCell(cell41); */
			
			
			
			/*PdfPTable tableA = new PdfPTable(2);
			tableA.setWidthPercentage(90);
			float[] columnWidthsA1 = {1.2f,1.5f};
			tableA.setWidths(columnWidthsA1);
			PdfPCell cellA = new PdfPCell(); */
			
			PdfPCell cell41= new PdfPCell();
			
			PdfPTable table41 = new PdfPTable(2);
			 table41.setWidthPercentage(100);
			float[] columnWidths11 = {0.1f,1.8f};
			 table41.setWidths(columnWidths11);
			 

			 cell41 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
						FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
				cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell41.setVerticalAlignment(Element.ALIGN_LEFT);
				cell41.setPadding(3.0f);
				cell41.setBorder(PdfPCell.NO_BORDER);
				table41.addCell(cell41);
			
				
			
			
			cell41 = new PdfPCell(new Paragraph(new Chunk("Consent To Operate ( AUTO-RENEWAL ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, and " +
				"under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended is granted in favour of ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(3.0f);
			cell41.setColspan(2);
			cell41.setBorder(PdfPCell.NO_BORDER);
			table41.addCell(cell41);
			
			cell41 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(3.0f);
			cell41.setBorder(PdfPCell.NO_BORDER);
			table41.addCell(cell41);
			
			cell41 = new PdfPCell(new Paragraph(new Chunk("Sh. "+occName+
					"\nM/s "+ indName +
					"\n" + indAddress +
					"\n" + district +", "+tehsil1 +
					"( registered with DIC vide registration No: "+indRegNum+" date: "+draftDate +" )", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(3.0f);
			cell41.setBorder(PdfPCell.NO_BORDER);
			table41.addCell(cell41);
			
			document.add(table41);
			
				
			
			
			//document.add(space4);
			
			/*Paragraph heading16 = new Paragraph();
			heading16.add(new Chunk("for a period from "+ startDate1 + " to "+endDate1+ " for "+ indCategory + " category of unit as per revised " +
				"classification of industrial sector.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
					Font.BOLD)));
			heading16.setAlignment(Element.ALIGN_LEFT);
	        document.add(heading16);
			
	    	Paragraph heading17 = new Paragraph();
	    	heading17.add(new Chunk("Terms and conditions applied in previous Consent Order shall remain unchanged and unit holder has to follow the already stipulated conditions in the previous consent order and unit holder shall also follow the additional conditions, if any, prescribed by the Board / JKPCC from time to time.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
					Font.BOLD)));
	    	heading17.setAlignment(Element.ALIGN_LEFT);
	        document.add(heading17);
	        
	        Paragraph heading18 = new Paragraph();
	        heading18.add(new Chunk("The consent is granted valid for the manufacturing of the products / by-products of consented quantity as" +
				"mentioned below based on the previous consent only with capital investment of Rs. "+capInvest + " lakhs :", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
					Font.NORMAL)));
	        heading18.setAlignment(Element.ALIGN_LEFT);
	        document.add(heading18);*/
	     //   document.add(space4);
			
			PdfPTable table2110 = new PdfPTable(2);
			table2110.setWidthPercentage(100);
			float[] columnWidths41 = {0.1f,1.8f};
			table2110.setWidths(columnWidths41);
			PdfPCell cell2110 = new PdfPCell();
			
			cell2110 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setPadding(3.0f);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
			
					
			
			cell2110 = new PdfPCell(new Paragraph(new Chunk("for a period upto  "+endDate1+ " for "+ indCategory + " category of unit as per revised " +
				"classification of industrial sector.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell2110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		//	cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setPadding(3.0f);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
			cell2110 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.ITALIC))));
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			cell2110.setPadding(3.0f);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
		
		
			cell2110 = new PdfPCell(new Paragraph(new Chunk("Terms and conditions applied in previous Consent Order shall remain unchanged and unit holder has to follow the already stipulated conditions in the previous consent order and unit holder shall also follow the additional conditions, if any, prescribed by the Board / JKPCC from time to time.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			cell2110.setPadding(3.0f);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
			cell2110 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.ITALIC))));
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			cell2110.setPadding(3.0f);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
			cell2110 = new PdfPCell(new Paragraph(new Chunk("The consent granted by the JK PCC is restricted to Prevention and Control of Pollution only and shall not be treated as substitute of permission required under other laws of the land.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			cell2110.setPadding(3.0f);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
			cell2110 = new PdfPCell(new Paragraph(new Chunk("1. ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			cell2110.setPadding(3.0f);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
		
			
			Paragraph p = new Paragraph();
			p.add(new Chunk("The consent granted is valid for the manufacturing of the products / by-products of consented quantity as mentioned below based on the ",new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL)));
			p.add(new Chunk(" Auto Renewal ",new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD)));
			p.add(new Chunk(" only with capital investment of Rs. "+capInvest+" Lakhs :",new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL)));

		
	       
			
			cell2110 = new PdfPCell(p);
			cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2110.setBorder(PdfPCell.NO_BORDER);
			cell2110.setPadding(3.0f);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2110.addCell(cell2110);
			
			
			document.add(table2110);
		//	document.add(space4);
			
			PdfPTable table2111 = new PdfPTable(4);
			table2111.setWidthPercentage(85);
			float[] columnWidths42 = {0.5f,2f,2f,2f};
			table2111.setWidths(columnWidths42);
			PdfPCell cell211 = new PdfPCell();
			
			cell211 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell211.setVerticalAlignment(Element.ALIGN_LEFT);
			cell211.setPadding(3.0f);
//			cell211.setBorder(PdfPCell.NO_BORDER);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2111.addCell(cell211);
			
			cell211 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name"+"\n"+"(As per previous consent)", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell211.setVerticalAlignment(Element.ALIGN_LEFT);
			cell211.setPadding(3.0f);
//			cell211.setBorder(PdfPCell.NO_BORDER);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2111.addCell(cell211);
			
			cell211 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity"+"\n"+"(As per previous consent)", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell211.setVerticalAlignment(Element.ALIGN_LEFT);
			cell211.setPadding(3.0f);
//			cell211.setBorder(PdfPCell.NO_BORDER);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2111.addCell(cell211);

			cell211 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell211.setVerticalAlignment(Element.ALIGN_LEFT);
			cell211.setPadding(3.0f);
//			cell211.setBorder(PdfPCell.NO_BORDER);
			//cell2110.setBorderColor(new Color(0, 0, 0));
			table2111.addCell(cell211);
			
			for(int var233=0;var233<productDetailsList1.size();var233++){
				
				ArrayList al3=(ArrayList) productDetailsList1.get(var233);
				for(int var333=0;var333<al3.size();var333++){
					String aaa=(String) al3.get(var333);
					//cell211 = new PdfPCell (new Paragraph(a));
					cell211 = new PdfPCell(new Paragraph(new Chunk(aaa, new Font(
							FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
					cell211.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell211.setPadding (3.0f);
					table2111.addCell (cell211);
				}
			}
			
			document.add(table2111);
	/*	Paragraph para16 = new Paragraph();
		para16.add(new Chunk("2. Particulars of the Industry",
				new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD)));
		para16.setAlignment(Element.ALIGN_LEFT);
		document.add(para16); */
			
		document.add(space4);
			
			
			   if(applicationFor.equals("HOTEL")){
				System.out.println("IN AutoRenew facilty details  ==="+hotelFacilityDetail);
				PdfPTable table2111333 = new PdfPTable(4);
				table2111333.setWidthPercentage(85);
				float[] columnWidths4233 = {2f,2f,2f,2f};
				table2111333.setWidths(columnWidths4233);
				PdfPCell cell21133 = new PdfPCell();
				
				cell21133 = new PdfPCell(new Paragraph(new Chunk("Facility For"+"\n"+"(As per previous consent)", new Font(
						FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
				cell21133.setHorizontalAlignment(Element.ALIGN_CENTER);
			//	cell21133.setVerticalAlignment(Element.ALIGN_LEFT);
				cell21133.setPadding(3.0f);
//				cell21133.setBorder(PdfPCell.NO_BORDER);
				//cell2110.setBorderColor(new Color(0, 0, 0));
				table2111333.addCell(cell21133);
				
				cell21133 = new PdfPCell(new Paragraph(new Chunk("Facility Type"+"\n"+"(As per previous consent)", new Font(
						FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
				cell21133.setHorizontalAlignment(Element.ALIGN_CENTER);
			//	cell21133.setVerticalAlignment(Element.ALIGN_LEFT);
				cell21133.setPadding(3.0f);
//				cell21133.setBorder(PdfPCell.NO_BORDER);
				//cell2110.setBorderColor(new Color(0, 0, 0));
				table2111333.addCell(cell21133);

				cell21133 = new PdfPCell(new Paragraph(new Chunk("Capacity(Room capacity, seating capacity, vehicle parking etc)", new Font(
						FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
				cell21133.setHorizontalAlignment(Element.ALIGN_CENTER);
			//	cell21133.setVerticalAlignment(Element.ALIGN_LEFT);
				cell21133.setPadding(3.0f);
//				cell21133.setBorder(PdfPCell.NO_BORDER);
				//cell2110.setBorderColor(new Color(0, 0, 0));
				table2111333.addCell(cell21133);
				
				cell21133 = new PdfPCell(new Paragraph(new Chunk("Facility Details", new Font(
						FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
				cell21133.setHorizontalAlignment(Element.ALIGN_CENTER);
			//	cell21133.setVerticalAlignment(Element.ALIGN_LEFT);
				cell21133.setPadding(3.0f);
//				cell21133.setBorder(PdfPCell.NO_BORDER);
				//cell2110.setBorderColor(new Color(0, 0, 0));
				table2111333.addCell(cell21133);
				
				for(int var2=0;var2<hotelFacilityDetail.size();var2++){
					
					ArrayList al=(ArrayList) hotelFacilityDetail.get(var2);
					for(int var3=0;var3<al.size();var3++){
						String a=(String) al.get(var3);
						//cell21133 = new PdfPCell (new Paragraph(a));
						cell21133 = new PdfPCell(new Paragraph(new Chunk(a, new Font(
								FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
						cell21133.setHorizontalAlignment (Element.ALIGN_CENTER);
						cell21133.setPadding (3.0f);
						table2111333.addCell (cell21133);
					}
				}
				
				document.add(table2111333);
			}
			
		
		PdfPTable table17= new PdfPTable(2);
		table17.setWidthPercentage(100);
		float[] columnWidths4 = {0.1f,1.8f};
		table17.setWidths(columnWidths4);
		
		PdfPCell cell7 = new PdfPCell();
		cell7 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
	//	cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
				
		cell7 = new PdfPCell(new Paragraph(new Chunk("This consent is not applicable for the unit which has undergone substantial expansion or change of quantity of products or any additional line of activity.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("3.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("Any change / enhancement in production capacity, process, raw materials etc. shall have to be intimated to the JK PCC and the unit holder has to apply afresh for the same in routine online mode in the jkocmms.nic.in portal.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		
			
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("4.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance / monitoring of JK PCC as per the environmental laws.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("5.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
	
		
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("The Auto Renewal of consent to operate will not prevent the JKPCC / Board for taking action as warranted under environmental laws, in case unit fails to comply with the prescribed standards or conditions of consent granted through auto renewal mode.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("6.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("Compliance under Water Act :", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("(a)", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("Sewage Effluent : The unit holder shall maintain continuous operation of a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continuously so as to achieve the quality of treated effluent to the following standards before disposal", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		table17.addCell(cell7);
		
		cell7 = new PdfPCell(new Paragraph(new Chunk("Standards of Discharge for Sewage Disposal:", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		cell7.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table17.addCell(cell7);
		
		/*cell7 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.ITALIC))));
		cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell7.setVerticalAlignment(Element.ALIGN_LEFT);
		cell7.setPadding(3.0f);
		table17.addCell(cell7);*/
		
		
		
/////////////////////////////////////////////////////////////////-------Adding sub table ends-------////////////////////////////////////////////////////////////////////////
	
		

		document.add(table17);
	//	document.add(space4);
	//	document.add(space4);
		
		PdfPTable table171= new PdfPTable(3);
		table171.setWidthPercentage(80);
		float[] columnWidths52 = {1.8f,1.0f,1.8f};
		table171.setWidths(columnWidths52);
		
		PdfPCell cell71 = new PdfPCell();
		cell71 = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
		//cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				FontFamily.TIMES_ROMAN,Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
		//cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
		//cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("between", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("6-9", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("Not to exceed", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
		//cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("100", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("BOD (3 days at 27 degreeCelsius)", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("Not to exceed", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		cell71 = new PdfPCell(new Paragraph(new Chunk("30", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell71.setVerticalAlignment(Element.ALIGN_LEFT);
		cell71.setPadding(3.0f);
		//cell71.setBorder(PdfPCell.NO_BORDER);
		table171.addCell(cell71);
		
		document.add(table171);
		
	//	document.add(space4);
		
		PdfPTable table172= new PdfPTable(2);
		table172.setWidthPercentage(100);
		float[] columnWidths53 = {0.1f,1.8f};
		table172.setWidths(columnWidths53);
		
		PdfPCell cell72 = new PdfPCell();
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("7", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("Compliance under Air Act :", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("• The unit holder shall comply to National Ambient Air Quality Standards as per EP Act 1986 (refer rule 3(3B).", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("• The unit holder shall take adequate measures to treat the emissions generated, if any, during the process and comply to Environment Protection standards specific to Industry", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("8.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("Unit holder shall follow the Noise Pollution (Regulation and Control) Rules 2000.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("9.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply to the Solid Waste Management Rules 2016.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("10.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply to the Plastic Waste Management Rules 2016.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("11.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("Unit holder shall follow the Noise Pollution (Regulation and Control) Rules 2000.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("12.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		Paragraph p1 = new Paragraph();
		p1.add(new Chunk("Additional Conditions :",new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD)));
		p1.add(new Chunk(" The unit holder shall comply with the additional conditions as stipulated below:-",new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL)));
		
		cell72 = new PdfPCell(p1);
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setBorder(PdfPCell.NO_BORDER);
		cell72.setPadding(3.0f);
		//cell2110.setBorderColor(new Color(0, 0, 0));
		table172.addCell(cell72);
		
		
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("i.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder has to keep a record of the environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP Act.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("ii.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed, shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("iii.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder shall be liable to pay compensation in case any damage is caused to the environment.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("iv.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time. Any infringement / violation or transgression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		

		
		cell72 = new PdfPCell(new Paragraph(new Chunk("v.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder shall provide adequate arrangement for fighting the accidental leakages/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("vi.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("Necessary No Objection Certificate with regard to extraction of ground water shall be obtained from concerned Chief Engineer, Jal Shakti Department.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("vii.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder shall adhere to general standards terms and conditions of Water / Air Acts and compliance of environment standards as per environment protection act 1986", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("viii.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply for renewal within 60 days before expiry of the consent order.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("ix.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		table172.addCell(cell72);
		
		cell72 = new PdfPCell(new Paragraph(new Chunk("This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc. of the unit.", new Font(
				FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLDITALIC))));
		cell72.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell72.setVerticalAlignment(Element.ALIGN_LEFT);
		cell72.setPadding(3.0f);
		cell72.setBorder(PdfPCell.NO_BORDER);
		//cell7.setColspan(2);
		table172.addCell(cell72);
		
	    document.add(table172);
		
		document.add(space4);
		
		
		Paragraph para16 = new Paragraph();
		para16.add(new Chunk("(Regional Director)      \nAuto-Renewal issuing Authority",
				new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.BOLD)));
		para16.setAlignment(Element.ALIGN_RIGHT);
		document.add(para16); 
	//	document.add(space4);
		
		Paragraph para17 = new Paragraph();
		para17.add(new Chunk("Copy to the :",
				new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL)));
		para17.setAlignment(Element.ALIGN_LEFT);
		document.add(para17); 
		document.add(space4);
		
		
		
		PdfPTable tablejjjjj = new PdfPTable(2);
			tablejjjjj.setWidthPercentage(100);
			float[] columnWidthsjjj = { 0.1f, 1.8f};
			tablejjjjj.setWidths(columnWidthsjjj);
			PdfPCell celljjjj = new PdfPCell();

			celljjjj = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk("1. Member Secretary J&K PCC Jammu for information.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
		
			celljjjj = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk("2. Secretary, J&K Water Resources Regulatory Authority, Jammu / Kashmir for information.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk("3. Chief Engineer, Jal Shakti Department, Jammu/Kashmir for information.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk("4. General Manager DIC concerned district for information.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk("5. D.O. PCC concerned for information & ensure compliance of the conditions of the consent.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			celljjjj = new PdfPCell(new Paragraph(new Chunk("6. P.A. to Chairman, J&K PCC for the information of Chairman.", new Font(
					FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE - 2, Font.NORMAL))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_LEFT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);
			
			document.add(tablejjjjj);
			
			document.add(space4);
		//	document.add(space4);
			
			Paragraph para18 = new Paragraph();
			para18.add(new Chunk("(The unit holder shall comply to environment standards as notified under the Environment Protection Act, 1986, read with the Water (Prevention & Control of Pollution) Act, 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website of www.jkspcb.nic.in or www.cpcb.nic.in)",
					new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -4, Font.ITALIC)));
			para18.setAlignment(Element.ALIGN_CENTER);
			
			document.add(para18); 
			document.add(space4);
			
			Paragraph para19 = new Paragraph();
			para19.add(new Chunk("This is a computer generated consent order (AUTO-RENEWAL) from JKPCC – issued under EoDB"+"\n"+" and does not require any signature",
					new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -3, Font.BOLD)));
			para19.setAlignment(Element.ALIGN_CENTER);
			document.add(para19); 
			
			Paragraph para20 = new Paragraph();
			para20.add(new Chunk("Eliminate Single Use Plastic to make this planet a better place to live",
					new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -3, Font.ITALIC|Font.UNDERLINE )));
			para20.setAlignment(Element.ALIGN_CENTER);
			document.add(para20);
			
			Paragraph para21 = new Paragraph();
			para21.add(new Chunk("Downloaded from "+"(www.jkocmms.nic.in) on " +DownloadDateAndTime, 
					new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -3, Font.ITALIC )));
			para21.setAlignment(Element.ALIGN_CENTER);
			document.add(para21);

			// Start Adding QR code on the top of signature...
		/*	PdfContentByte cb1 = writer.getDirectContent();
			BarcodeQRCode barcodeQRCode1 = new BarcodeQRCode("endtNumberIn", 1000, 1000,
					null);
			Image codeQrImage1 = barcodeQRCode1.getImage();
			codeQrImage1.scaleAbsolute(70, 70);
			codeQrImage1.setAlignment(Element.ALIGN_RIGHT);
			document.add(codeQrImage1);*/
			// END Adding QR code ...

		/*	celljjjj = new PdfPCell(new Paragraph(new Chunk(
					"" + "\n"
							+ "For & on Behalf of HPPCB" + "\n", new Font(
							FontFamily.HELVETICA, Font.DEFAULTSIZE - 1,
							Font.BOLD))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_RIGHT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj);

			celljjjj = new PdfPCell(new Paragraph(new Chunk(
					 " ", new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE - 1,
					Font.BOLD))));
			celljjjj.setHorizontalAlignment(Element.ALIGN_RIGHT);
			celljjjj.setPadding(3.0f);
			celljjjj.setBorder(0);
			tablejjjjj.addCell(celljjjj); */

		//	document.add(tablejjjjj);
		
			/*
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		PdfPTable table091 = new PdfPTable(1);
		table091.setWidthPercentage(100);
		float[] columnWidths44311 = {2f};
		table091.setWidths(columnWidths44311);
		table091.setWidthPercentage(100);
		PdfPCell cell091 = new PdfPCell();
		
        Font font12341 = new Font(FontFamily.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD);
		
        cell091 = new PdfPCell (new Paragraph(  offName+"\n"+  offDes +"\n    For & on behalf of \n( H. P. State Pollution Control Board)",font12341));
		cell091.setHorizontalAlignment (Element.ALIGN_RIGHT);
		cell091.setPadding (5.0f);
		cell091.setPadding (5.0f);
		cell091.setBorder(0);
		table091.addCell (cell091);
	    document.add(table091);	
		
	
		
		
		document.add(space4);
		 document.add(space4);
		 document.add(space4);
		 document.add(space4);
		 document.add(space4);
		 document.add(space4);
		 document.add(space4);
		document.add(table091);*/
	//	document.newPage();
		
		
		
	

		//	document.add(space4);
		//	document.add(space4);
		//	document.add(space4);

		/*	PdfPTable tableKKKKKKK = new PdfPTable(4);
			tableKKKKKKK.setWidthPercentage(100);
			float[] columnWidthsAK1KKq = { 2f, 2f, 2f, 10f };
			tableKKKKKKK.setWidths(columnWidthsAK1KKq);
			PdfPCell cellBKKKzKK = new PdfPCell();

			cellBKKKzKK = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.HELVETICA, Font.DEFAULTSIZE - 1, Font.BOLD))));
			cellBKKKzKK.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBKKKzKK.setPadding(2.0f);
			cellBKKKzKK.setBorder(0);
			tableKKKKKKK.addCell(cellBKKKzKK);

			cellBKKKzKK = new PdfPCell(new Paragraph(new Chunk(" " + "",
					new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE - 1,
							Font.NORMAL))));
			cellBKKKzKK.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellBKKKzKK.setPadding(3.0f);
			cellBKKKzKK.setBorder(0);
			tableKKKKKKK.addCell(cellBKKKzKK);

			cellBKKKzKK = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					FontFamily.HELVETICA, Font.DEFAULTSIZE - 1, Font.BOLD))));
			cellBKKKzKK.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellBKKKzKK.setPadding(3.0f);
			cellBKKKzKK.setBorder(0);
			tableKKKKKKK.addCell(cellBKKKzKK);

			// Start Adding QR code on the top of signature...
			PdfContentByte cb = writer.getDirectContent();
			BarcodeQRCode barcodeQRCode = new BarcodeQRCode("gfjfjf", 1000, 1000,
					null);
			Image codeQrImage = barcodeQRCode.getImage();
			codeQrImage.scaleAbsolute(70, 70);
			codeQrImage.setAlignment(Element.ALIGN_RIGHT);
			document.add(codeQrImage);
			// END Adding QR code ...

			cellBKKKzKK = new PdfPCell(new Paragraph(new Chunk(
					"" + "\n"
							+ "For & on Behalf of HPPCB" + "\n", new Font(
							FontFamily.HELVETICA, Font.DEFAULTSIZE - 1,
							Font.BOLD))));
			cellBKKKzKK.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellBKKKzKK.setPadding(3.0f);
			cellBKKKzKK.setBorder(0);
			tableKKKKKKK.addCell(cellBKKKzKK);

			cellBKKKzKK = new PdfPCell(new Paragraph(new Chunk(
					 " ", new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE - 1,
					Font.BOLD))));
			cellBKKKzKK.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellBKKKzKK.setPadding(3.0f);
			cellBKKKzKK.setBorder(0);
			tableKKKKKKK.addCell(cellBKKKzKK);

			document.add(tableKKKKKKK); */

			System.out.println("PDF..GENERATED...11111........");
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempFile;

	}

}
