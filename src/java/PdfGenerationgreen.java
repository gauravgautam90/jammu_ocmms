import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PdfGenerationgreen {
	private String applfor;

	public File pdfFunction(String indAddress,String draftDate,String occName,String 
			occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String capInvest,
			String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String indCity,String indPin,String tehsil1 
			,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList solidWasteDisposalDetailsList1,
			ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String currentYear,String industrytype12,
			String offDistrict,String endtNumberIn,String subject,String appID,String yearString,String issuingConsentTypeNo,String nameOfDistrict,
			String waterConsume,String authno,String sewageEffluent,String indName,String indRegNum,String indRegDate,
			ArrayList PollutionControlList,String indCategory) throws Exception {
		System.out.println("applFor "+applFor);
		if(applFor.equals("AUTORENEW")){
			System.out.println("IN AutoRenew");
		File tempFile = new File("certificate.pdf");
		Document document = new Document(PageSize.A4);
		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		/*Phrase footerPhrase = new Phrase ("The industry can apply for Renewal/Expansion of Consent on the site www.jkocmms.nic.in directly"+"\n"+"Page",new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -3,Font.ITALIC));
		HeaderFooter footer = new HeaderFooter(footerPhrase, true);
		//footer.setBorderWidthTop(2);
		footer.setAlignment(Element.ALIGN_CENTER);
		//footer.setBorder(Rectangle.NO_BORDER); 
		document.setFooter(footer);*/
		
		
		Phrase footerPhrase = new Phrase ("This is a computer generated consent order (AUTO-RENEWAL) from JKPCC – issued under EoDB and does not require any signature"+"\n"+"Eliminate Single Use Plastic to make this planet a better place to live",new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -3,Font.ITALIC | Font.BOLD));
		HeaderFooter footer = new HeaderFooter(footerPhrase, false);
		//footer.setBorderWidthTop(2);
		footer.setAlignment(Element.ALIGN_CENTER);
		footer.setBorder(Rectangle.NO_BORDER); 
		document.setFooter(footer);
		document.open();
		

		
		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space4);
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		image.scaleAbsolute(70f, 60f);
		//image.setAbsolutePosition(50, 50);
		document.add(image);
		
		Image image1 = Image.getInstance("images2/watermark_final1.jpg");
		image1.scalePercent(80.0f);
//		image1.scaleToFit(200, 200);
	//	image1.setAlignment(Image.LEFT | Image.TEXTWRAP);
		image1.scaleAbsolute(250f, 200f);
		image.setAbsolutePosition(250, 400);
		document.add(image);
		
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk(" Government of Jammu and Kashmir\nJ&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space4);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Consent Order ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading15.setAlignment(Element.ALIGN_CENTER);
		document.add(heading15);
		
		Paragraph heading16 = new Paragraph();
		heading16.add(new Chunk("(AUTO RENEWAL under Ease of Doing Business)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading16.setAlignment(Element.ALIGN_CENTER);
		document.add(heading16);
		
		
		document.add(space4);
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(90);
		float[] columnWidthsA = {3f,1f};
		table11.setWidths(columnWidthsA);
		PdfPCell cell11 = new PdfPCell();
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Consent No.:- PCC/digital/"+yearString+issuingConsentTypeNo+appID+" of "+currentYear, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Date:- "+ draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		document.add(table11);
		
		PdfPTable tableA = new PdfPTable(2);
		tableA.setWidthPercentage(90);
		float[] columnWidthsA1 = {1.2f,1.5f};
		tableA.setWidths(columnWidthsA1);
		PdfPCell cellA = new PdfPCell();
		
		if(applType.equals("CTE")){	
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ( AUTO-RENEWAL ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, and " +
				"under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended is granted in favour of ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		}else{
			cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Operate ( "+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, and " +
				"under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended is granted in favour of ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellA.setPadding(3.0f);
			cellA.setColspan(2);
			cellA.setBorder(PdfPCell.NO_BORDER);
			tableA.addCell(cellA);
		}
		
		cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk(
				"Sh. "+occName+
				"\nM/s "+ indName +
				"\n" + indAddress +
				"\n" + district +", "+tehsil1 +
				"( registered with DIC vide registration No: "+regId+" date: "+draftDate +" )", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk("for a period from "+ startDate1 + " to "+endDate1+ " for "+ indCategory + " category of unit as per revised " +
				"classification of industrial sector.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		document.add(tableA);
		
		PdfPTable tableB = new PdfPTable(2);
		tableB.setWidthPercentage(100);
		float[] columnWidths112 = {0.1f,1.8f};
		tableB.setWidths(columnWidths112);
		PdfPCell cellB = new PdfPCell();
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Terms and conditions applied in previous Consent Order shall remain unchanged and unit holder has to follow the already stipulated conditions in the previous consent order and unit holder shall also follow the additional conditions, if any, prescribed by the Board / JKPCC from time to time.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent granted by the JK PCC is restricted to Prevention and Control of Pollution only and shall not be treated as substitute of permission required under other laws of the land.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("1. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for the manufacturing of the products / by-products of consented quantity as" +
				"mentioned below based on the previous consent only with capital investment of Rs. "+capInvest + " lakhs :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidthPercentage(90);
		float[] columnWidths4 = {0.3f,1f,1f,1f};
		table1.setWidths(columnWidths4);
		PdfPCell cell1 = new PdfPCell();
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
					
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name"+"\n"+"(As per previous consent)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity"+"\n"+"(As per previous consent)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		for(int var2=0;var2<productDetailsList1.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsList1.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell1 = new PdfPCell (new Paragraph(a));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setPadding (3.0f);
				table1.addCell (cell1);
			}
			}
	                   
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table1);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB); 
		
		/*cellB = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Any change / enhancement in production capacity, process, raw materials etc shall have to be intimated to the Committee and the unit holder has to apply afresh for the same", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);*/
		 //	Added By DEEPAK KUMAR FOR AUTORENEW   Start
		
		cellB = new PdfPCell(new Paragraph(new Chunk("2. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("This consent is not applicable for the unit which has undergone substantial expansion or change of quantity of products or any additional line of activity.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("3. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("Any change / enhancement in production capacity, process, raw materials etc shall have to be intimated to the JK PCC and the unit holder has to apply afresh for the same in routine online mode in the jkocmms.nic.in portal.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("4. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance / monitoring of JK PCC as per the environmental laws.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			
			cellB = new PdfPCell(new Paragraph(new Chunk("5. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The applicant shall apply within 60 days before expiry of the consent.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			
			cellB = new PdfPCell(new Paragraph(new Chunk("6. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The Auto Renewal of consent to operate will not prevent the JKPCC / Board for taking action as warranted under environmental laws, in case unit fails to comply with the prescribed standards or conditions of consent granted through auto renewal mode.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
//			Added By DEEPAK KUMAR FOR AUTORENEW   END
		
	
			document.add(tableB);
			
		
			
		//	Added by DEEPAK KUMAR
			document.add(space4);
			document.add(space4);
			document.add(space4);
			Paragraph subHeading2 = new Paragraph();
			subHeading2.add(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1 , Font.BOLD)));
			subHeading2.setAlignment(Element.ALIGN_RIGHT);
			document.add(subHeading2); 
			/*Paragraph subHeading3 = new Paragraph();
			subHeading3.add(new Chunk("Name  _________", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1 , Font.BOLD)));
			subHeading3.setAlignment(Element.ALIGN_RIGHT);
			document.add(subHeading3);
			Paragraph subHeading4 = new Paragraph();
			subHeading4.add(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1 , Font.BOLD)));
			subHeading4.setAlignment(Element.ALIGN_RIGHT);
			document.add(subHeading4);
			Paragraph subHeading5 = new Paragraph();
			subHeading5.add(new Chunk("Designation",  new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1 , Font.BOLD)));
			subHeading5.setAlignment(Element.ALIGN_RIGHT);
			document.add(subHeading5);*/
			/*Paragraph subHeading2 = new Paragraph();
			subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4 , Font.BOLD)));
			subHeading2.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading2); */
					
		document.close();
		return tempFile;	
	}else{

		
		File tempFile = new File("certificate.pdf");
		Document document = new Document(PageSize.A4);
		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase footerPhrase = new Phrase ("The industry can apply for Renewal/Expansion of Consent on the site www.jkocmms.nic.in directly"+"\n"+"Page",new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -3,Font.ITALIC));
		HeaderFooter footer = new HeaderFooter(footerPhrase, true);
		//footer.setBorderWidthTop(2);
		footer.setAlignment(Element.ALIGN_CENTER);
		//footer.setBorder(Rectangle.NO_BORDER); 
		document.setFooter(footer);
		document.open();
		
		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space4);
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space4);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Consent Order ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading15.setAlignment(Element.ALIGN_CENTER);
		document.add(heading15);
		
		document.add(space4);
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(90);
		float[] columnWidthsA = {3f,1f};
		table11.setWidths(columnWidthsA);
		PdfPCell cell11 = new PdfPCell();
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Consent No.:- PCC/digital/"+yearString+issuingConsentTypeNo+appID+" of "+currentYear, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Date:- "+ draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		document.add(table11);
		
		PdfPTable tableA = new PdfPTable(2);
		tableA.setWidthPercentage(90);
		float[] columnWidthsA1 = {1.2f,1.5f};
		tableA.setWidths(columnWidthsA1);
		PdfPCell cellA = new PdfPCell();
		
		if(applType.equals("CTE")){	
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ( "+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, and " +
				"under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended is granted in favour of ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		}else{
			cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Operate ( "+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, and " +
				"under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended is granted in favour of ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellA.setPadding(3.0f);
			cellA.setColspan(2);
			cellA.setBorder(PdfPCell.NO_BORDER);
			tableA.addCell(cellA);
		}
		
		cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk(
				"Sh. "+occName+
				"\nM/s "+ indName +
				"\n" + indAddress +
				"\n" + district +", "+tehsil1 +
				"( registered with DIC vide registration No: "+indRegNum+" date: "+indRegDate +" )", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk("for a period "+ maxQuantity + " for "+ indCategory + " category of unit as per revised " +
				"classification of industrial sector, subject to the following terms and conditions in a time bound manner : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		document.add(tableA);
		
		PdfPTable tableB = new PdfPTable(2);
		tableB.setWidthPercentage(100);
		float[] columnWidths112 = {0.1f,1.8f};
		tableB.setWidths(columnWidths112);
		PdfPCell cellB = new PdfPCell();
		
		cellB = new PdfPCell(new Paragraph(new Chunk("1. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent granted by the Committee is restricted to Prevention and Control of Pollution only and " +
				"shall not be treated as substitute of permission required under other laws of the land.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("2. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for the manufacturing of the products / by-products of consented quantity as " +
				"mentioned below with capital investment of Rs."+capInvest + " lakhs(as per Schedule II):", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidthPercentage(90);
		float[] columnWidths4 = {0.3f,1f,1f,1f};
		table1.setWidths(columnWidths4);
		PdfPCell cell1 = new PdfPCell();
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
					
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		for(int var2=0;var2<productDetailsList1.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsList1.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell1 = new PdfPCell (new Paragraph(a));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setPadding (3.0f);
				table1.addCell (cell1);
			}
			}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table1);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Any change / enhancement in production capacity, process, raw materials etc shall have to be intimated to the Committee and the unit holder has to apply afresh for the same", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("3. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Water Act :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("(a) ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Sewage Effluent : The unit holder has to install and maintain continuous operation of a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continuously so as to achieve the quality of treated effluent to the following standards before disposal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Standards of Discharge for Sewage Disposal: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table221 = new PdfPTable(3);
		table221.setWidthPercentage(100);
		float[] columnWidths321 = {1f,0.7f,1.7f};
		table221.setWidths(columnWidths321);
		PdfPCell cell11121= new PdfPCell();
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("between", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("6-9", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table221);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("(b) ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Water Consumption and Disposal :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" i. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" ii. The daily quantity of sewage effluent from the unit shall not exceed from "+ sewageEffluent +" KLD.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" iii. Waste water generated from the unit shall be disposed through Septic Tank, Soakage Pit or ETP as applicable", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("4. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Air Act : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a. The unit holder shall comply to National Ambient Air Quality Standards as per EP Act " +
				"1986 (refer rule 3(3B). " +
				"\n b. The unit holder shall take adequate measures to treat the emissions generated, if any, during the process and comply to Environment Protection standards specific to Industry", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("5. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" The unit holder shall comply to the Solid Waste Management Rules 2016 dated 8-4-2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("6. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" Under the Noise Pollution (Regulation and Control) Rules 2000, the unit holder shall take adequate " +
				"measures for control of noise from its own sources within the premises so as to maintain ambient air quality " +
				"standards in respect of noise to less than 75dB(A) during day time and 70 dB(A) during night time. Daytime " +
				"is reckoned in between 6 am to 10 pm and night time is 10 pm to 6 am", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("7. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply to the Plastic Waste Management Rules 2016 dated 18-3-2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("8. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
					"\nThe unit holder shall have to get the samples of emission/Effluents analysed from the laboratory of J&K " +
					"PCC or laboratories approved by J&K PCC after every "+ subject +" months to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		
			cellB = new PdfPCell(new Paragraph(new Chunk("9. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply with the additional conditions as stipulated below:- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" i. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to keep a record of the environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP Act.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" ii. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed , shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" iii. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall be liable to pay compensation in case any damage is caused to the environment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" iv. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time.Any infringement/ violation or transgression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" v. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance monitoring of J & K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" vi. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall provide adequate arrangement for fighting the accidental leakages/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" vii. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall adhere to general standards terms and conditions of Water / Air Acts and compliance of environment standards as per environment protection act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" viii. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
				cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply 60 days in advance for renewal of consent before expiry the date of this Consent Order", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
				
				cellB = new PdfPCell(new Paragraph(new Chunk(" ix. ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
				
				cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
			
				cellB = new PdfPCell(new Paragraph(new Chunk("Specific Conditions:- ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setColspan(2);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
				
				if(sCondition!=""){
					cellB = new PdfPCell(new Paragraph(new Chunk(sCondition, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
					cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
					cellB.setPadding(3.0f);
					cellB.setColspan(2);
					tableB.addCell(cellB);
				}
				
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" * This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc of the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellB.setPadding(3.0f);
			cellB.setColspan(2);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			document.add(tableB);
			
			PdfPTable table311 = new PdfPTable(2);
			table311.setWidthPercentage(100);
			PdfPCell cell311 = new PdfPCell();
					
			cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell311.setVerticalAlignment(Element.ALIGN_LEFT);
			cell311.setPadding(3.0f);
			cell311.setBorder(PdfPCell.NO_BORDER);
			table311.addCell(cell311);
			
			if(district.equals("Leh") || district.equals("Kargil"))
			{
				cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				
			}else
			{
				cell311 = new PdfPCell(new Paragraph(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
								
			}
			
			//cell311 = new PdfPCell(new Paragraph(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell311.setVerticalAlignment(Element.ALIGN_CENTER);
			cell311.setPadding(3.0f);
			cell311.setBorder(PdfPCell.NO_BORDER);
			table311.addCell(cell311);
			
			document.add(table311);
			
			
			if(district.equals("Leh") || district.equals("Kargil"))
			{
				Paragraph paraP48 = new Paragraph();
				paraP48.add(new Chunk("Copy to the :" +
						"\n		1. Nodal Officer J&K PCC "+ endtNumberIn +" for information" +
						"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
						"\n		3. D.O PCC "+ offDistrict +" for information & ensure compliance of the conditions of the consent." +
						"\n		4. P.A to Chairman J&K PCC for the information of Chairman."+
						"\n		5. M/s "+ indName +" , " + indAddress + " ."+
						"\n		6. Office file",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
				paraP48.setAlignment(Element.ALIGN_LEFT);
				document.add(paraP48);
			}else
			{
				Paragraph paraP48 = new Paragraph();
				paraP48.add(new Chunk("Copy to the :" +
						"\n		1. Member Secretary J&K PCC "+ endtNumberIn +" for information" +
						"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
						"\n		3. D.O PCC "+ offDistrict +" for information & ensure compliance of the conditions of the consent." +
						"\n		4. P.A to Chairman J&K PCC for the information of Chairman."+
						"\n		5. M/s "+ indName +" , " + indAddress + " ."+
						"\n		6. Office file",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
				paraP48.setAlignment(Element.ALIGN_LEFT);
				document.add(paraP48);
			}
			
			
			
			Paragraph paraP484 = new Paragraph();
			paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
					"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 5, Font.NORMAL | Font.UNDERLINE)));
			paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraP484);
			document.add(space4);
			
			Paragraph subHeading2 = new Paragraph();
			subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4 , Font.BOLD)));
			subHeading2.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading2);
					
		document.close();
		return tempFile;	
	
	}
	}
/////////////////////////////////////////////////For Hotels//////////////////////////////////////////////////////////////////////////////
	public File pdfFunctionHotel(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,ArrayList stackDetailsList1,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
			String indCategory,String offDistrict,ArrayList productDetailsList11,String currentYear,String endtNumberIn,String subject,
			String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
			String authno,String capInvest,String waterConsume,String sewageEffluent,String indName,String indRegNum,String indRegDate) throws Exception {
		File tempFile = new File("certificate.pdf");
		Document document = new Document(PageSize.A4);
		
		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase footerPhrase = new Phrase ("The industry can apply for Renewal/Expansion of Consent on the Site www.jkocmms.nic.in directly"+"\n"+"Page",new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -4,Font.ITALIC));
		HeaderFooter footer = new HeaderFooter(footerPhrase, true);
		//footer.setBorderWidthTop(2);
		footer.setAlignment(Element.ALIGN_CENTER);
		//footer.setBorder(Rectangle.NO_BORDER); 
		document.setFooter(footer);
		document.open();
		
		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space4);
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space4);document.add(space4);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Consent Order ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading15.setAlignment(Element.ALIGN_CENTER);
		document.add(heading15);
		
		document.add(space4);
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(100);
		float[] columnWidthsA = {3f,1f};
		table11.setWidths(columnWidthsA);
		PdfPCell cell11 = new PdfPCell();
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Consent No.:- PCC/digital/"+yearString+issuingConsentTypeNo+appID+" of "+currentYear, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Date:- "+ draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		document.add(table11);
		
		PdfPTable tableA = new PdfPTable(2);
		tableA.setWidthPercentage(90);
		float[] columnWidthsA1 = {1.2f,1.5f};
		tableA.setWidths(columnWidthsA1);
		PdfPCell cellA = new PdfPCell();
		
		if(applType.equals("CTE")){	
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ("+ applFor +" ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
				" section 21 of the Air (Prevention & Control of Pollution) Act, 1981, as amended is granted in favour of ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		}else{
			cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Operate ("+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
					" section 21 of the Air (Prevention & Control of Pollution) Act, 1981, as amended is granted in favour of ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellA.setPadding(3.0f);
			cellA.setColspan(2);
			cellA.setBorder(PdfPCell.NO_BORDER);
			tableA.addCell(cellA);	
		}
		
		cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk(
				"Sh. "+occName+
				"\nM/s "+ indName +
				"\n" + indAddress +
				"\n" + district +", "+tehsil1 +
				"\n(registered with Tourism Deptt. vide registration No: " +regId+" date: "+indRegDate +" )", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk("for a period "+ maxQuantity + " for "+ indCategory + " category of hotel as per revised " +
				"classification of industrial sector, subject to the following terms and conditions in a time bound manner : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		document.add(tableA);
		
		PdfPTable tableB = new PdfPTable(2);
		tableB.setWidthPercentage(100);
		float[] columnWidths112 = {0.1f,1.8f};
		tableB.setWidths(columnWidths112);
		PdfPCell cellB = new PdfPCell();
		
		cellB = new PdfPCell(new Paragraph(new Chunk("1. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent granted by the Committee is restricted to Prevention and Control of Pollution only and " +
				"shall not be treated as substitute of permission required under other laws of the land.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("2. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
		if(applType.equals("CTE")){	
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for establish the hotel / restaurant facility as under with capital investment " +
					"of Rs."+capInvest + " lakhs (as per Schedule II) ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		}else
		{
			cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for operating the hotel / restaurant facility as under with capital investment " +
					"of Rs."+capInvest + " lakhs (as per Schedule II) ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		}
		
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table1 = new PdfPTable(3);
		table1.setWidthPercentage(90);
		float[] columnWidths4 = {0.3f,1f,1f};
		table1.setWidths(columnWidths4);
		PdfPCell cell1 = new PdfPCell();
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
					
		cell1 = new PdfPCell(new Paragraph(new Chunk("Hotel/Restaurant Facility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		for(int var2=0;var2<productDetailsList11.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsList11.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setPadding (3.0f);
				table1.addCell (cell1);
			}
			}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table1);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The emissions or discharge of environmental pollutants from the hotel shall not exceed the relevant parameters " +
				"and the standards specified under respective schedules of the Environment (Protection) Rules " +
				",1986 as amended from time to time", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk("3. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Water Act :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a. Standards of Discharge for Trade Effluent: " +
				"\n\nTreatment : The hotel owner has to operate and maintain a comprehensive effluent treatment system consisting of Primary / Secondary and / or " +
				"Tertiary treatment so as to achieve the quality of the treated effluent to the following standards of discharge outlet ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table22 = new PdfPTable(2);
		table22.setWidthPercentage(100);
		float[] columnWidths32 = {1f,1.7f};
		table22.setWidths(columnWidths32);
		PdfPCell cell1112 = new PdfPCell();
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1 , Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("PH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("5.5-9.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Total Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("50", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Oil & Grease", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Phosphate as P", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		//cell1112.setColspan(2);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table22);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" b. Standards of discharge for Sewerage disposal:" +
				"\n\nSewage Treatment - The hotel owner has to install a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continuously so as to achieve " +
				"the quality to treated effluent to the following standards before disposal :- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table221 = new PdfPTable(3);
		table221.setWidthPercentage(100);
		float[] columnWidths321 = {1f,0.7f,1.7f};
		table221.setWidths(columnWidths321);
		PdfPCell cell11121= new PdfPCell();
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("between", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("6-9", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table221);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
			cellB = new PdfPCell(new Paragraph(new Chunk(" c. All the hotel waste shall be treated as per norms to meet the environment standards of EP Act 1986.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" d. Water consumption" +
				"\n i. The daily quantity of sewage effluent from the hotel shall not exceed from "+ sewageEffluent +" KLD." +
				"\n ii. The daily quantity of water consumption shall not exceed from "+ waterConsume +" KLD.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("4. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Air Act : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		

		cellB = new PdfPCell(new Paragraph(new Chunk(" a. The hotel owner shall comply to National Ambient Air Quality Standards as per EP Act " +
				"1986 (refer rule 3(3B)). " +
				"\n b. The unit holder has to operate stack(s) of the following specifications : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
			
			PdfPTable table2x = new PdfPTable(3);
			table2x.setWidthPercentage(100);
			float[] columnWidths3x = {0.4f,1f,1f};
			table2x.setWidths(columnWidths3x);
			PdfPCell cell111x = new PdfPCell();
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("S. No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111x.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111x.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111x.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111x.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("Height (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111x.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111x.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			for(int var2=0;var2<stackDetailsList1.size();var2++)
			{
				ArrayList al=(ArrayList) stackDetailsList1.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell111x = new PdfPCell (new Paragraph(new Chunk(a, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
					cell111x.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell111x.setPadding (3.0f);
					table2x.addCell (cell111x);
				}
			}
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table2x);
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			/*cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("		The unit holder has to operate stack(s) of the following specifications : ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);*/
		
		
		/*PdfPTable table2 = new PdfPTable(6);
		table2.setWidthPercentage(100);
		float[] columnWidths3 = {0.3f,1f,1f,1f,1f,3f};
		table2.setWidths(columnWidths3);
		PdfPCell cell111 = new PdfPCell();
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Volume Nm3/hr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Height", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Top diameter", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table2);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		*/
		
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			

			cellB = new PdfPCell(new Paragraph(new Chunk("   c. Pollution Control Equipments : The hotel owner has to operate and maintain a comprehensive air pollution control system  i.e. Exhaust fans , Suction hoods and stack of 2 meters height higher that the height of building to vent out fumes to achieve the quality of emission within the tolerance limits prescribed under environment protection act 1986", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("5. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" Compliance under Noise Pollution (Regulation and Control) Rules 2000 as amended " +
					"\nThe hotel owner shall take adequate measures for control of noise from its own sources within the premises so as to maintain " +
					"ambient air quality standards in respect of noise to less than 75dB(A) during day time and 70 dB(A) during night time. Daytime is reckoned in between " +
					"6 am to 10 pm and night time is 10 pm to 6 am.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("6. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" Compliance under Solid Waste Management Rules 2016 dated 8-4-2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
			
			cellB = new PdfPCell(new Paragraph(new Chunk("7. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Plastic Waste Management Rules 2016 dated 18-3-2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("8. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
					"The hotel owner shall have to get the samples of emissions/effluents analysed from the laboratory of J&K " +
					"PCC or laboratories approved by J&K PCC after every "+ subject +" months to check the efficacy of Pollution Control Devices(PCDs) installed in the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("9. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply with the additional conditions as stipulated below:- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" i. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		if(applType.equals("CTE")){	
		cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Establishment of hotel only." , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Operation of hotel only." , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}
		cellB = new PdfPCell(new Paragraph(new Chunk(" ii. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel owner has to keep a record of the Environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP  Act" , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" iii. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent/ emission within the tolerance limits "+
				"prescribed, shall have to be operational during the course of production. The effluent / emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" iv. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel owner shall be liable to pay compensation in case any damage is caused to the environment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" v. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel owner shall abide by the directions of the Committee which will be issued from time to time. Any infringement/violation "+
				"or transgression of the statutory enactments of pollution control acts by the hotel / guest house / banquet shall be sufficient cause to prosecute the "+
				"violator in conformity with relevant section of Air / Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" vi. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel shall be under surveillance monitoring ofJ & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" vii. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel owner shall provide adequate arrangement for fighting the accidental leakages/discharge of any air "+
				"pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" viii. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel owner should apply 60 days in advance for renewal of consent before expiry the date of this Consent order.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" ix. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The hotel owner shall install the latest state of art technology Air pollution control devices for control of volatile organics emission well within permissible limit and ensure that emission shall not be vented out untreated so as to cause any adverse environmental impact to the adjoining areas", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);

		cellB = new PdfPCell(new Paragraph(new Chunk(" x. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Specific Conditions:- ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		if(sCondition!=""){
			cellB = new PdfPCell(new Paragraph(new Chunk(sCondition, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setColspan(2);
			tableB.addCell(cellB);
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" xi. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" * This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc of the hotel / guest house / banquet hall.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		document.add(tableB);
		
		PdfPTable table311 = new PdfPTable(2);
		table311.setWidthPercentage(100);
		PdfPCell cell311 = new PdfPCell();
				
		cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell311.setVerticalAlignment(Element.ALIGN_LEFT);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		
		if(district.equals("Leh") || district.equals("Kargil"))
		{
			cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			
		}else
		{
			cell311 = new PdfPCell(new Paragraph(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
							
		}
		
		//cell311 = new PdfPCell(new Paragraph(new Chunk("Regional Director", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell311.setVerticalAlignment(Element.ALIGN_CENTER);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		document.add(table311);
		
		if(district.equals("Leh") || district.equals("Kargil"))
		{
			Paragraph paraP48 = new Paragraph();
			paraP48.add(new Chunk("Copy to the :" +
					"\n		1. Nodal Officer J&K PCC "+ endtNumberIn +" for information" +
					"\n		2. Director Tourism "+ fileNumberIn +" for information." +
					"\n		3. D.O PCC "+ offDistrict +" for information & ensure compliance of the conditions of the consent." +
					"\n		4. P.A to Chairman J&K PCC for the information of Chairman."+
					"\n		5. M/s "+ indName +" , " + indAddress + " ."+
					"\n		6. Office file",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
			paraP48.setAlignment(Element.ALIGN_LEFT);
			document.add(paraP48);
			
		}else
		{
			Paragraph paraP48 = new Paragraph();
			paraP48.add(new Chunk("Copy to the :" +
					"\n		1. Member Secretary J&K PCC "+ endtNumberIn +" for information" +
					"\n		2. Director Tourism "+ fileNumberIn +" for information." +
					"\n		3. D.O PCC "+ offDistrict +" for information & ensure compliance of the conditions of the consent." +
					"\n		4. P.A to Chairman J&K PCC for the information of Chairman."+
					"\n		5. M/s "+ indName +" , " + indAddress + " ."+
					"\n		6. Office file",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
			paraP48.setAlignment(Element.ALIGN_LEFT);
			document.add(paraP48);
		}
		
		document.add(space4);
		
		Paragraph paraP484 = new Paragraph();
		paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
				"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 5, Font.NORMAL | Font.UNDERLINE)));
		paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP484);
		document.add(space4);
		
		Paragraph subHeading2 = new Paragraph();
		subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4 , Font.BOLD)));
		subHeading2.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading2);
		
		
		document.close();
		return tempFile;
	}
}
