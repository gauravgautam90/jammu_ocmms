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

public class PdfGenerationredOrange {
	private String applfor;

	public File pdfFunctionIndustry(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
			String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
			String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
			String authno,ArrayList PollutionControlList,String wasteWater,String capInvest,String waterConsume,
			String sewageEffluent,String indName,String indRegNum,String indRegDate) throws Exception {
		
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
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space4);document.add(space4);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Consent Order ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		heading15.setAlignment(Element.ALIGN_CENTER);
		document.add(heading15);
		
		document.add(space4);document.add(space4);
		
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
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ( "+ applFor + 
				" ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
				" section 21 of the Air (Prevention & Control of Pollution) Act, 1981, as amended is granted in favour of ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		}else{
			cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Operate ( "+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
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
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
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
				"( registered with DIC vide registration No: " +
				"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
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
		
		if(applType.equals("CTE")){
			cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for the establishment of unit for manufacturing of the products / by-products consented quantity as mentioned below with capital investment of Rs."+capInvest + " lakhs:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for operation of unit for the manufacturing of the products / by-products consented quantity as " +
					"mentioned below with capital investment of Rs."+capInvest + " lakhs(as per Schedule II):", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}
		cellB = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidthPercentage(90);
		float[] columnWidths4 = {5f,20f,20f,20f};
		table1.setWidths(columnWidths4);
		PdfPCell cell1 = new PdfPCell();
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
					
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		if(productDetailsList1.size()>0){
		System.out.println("--product details List-"+productDetailsList1.size()+"---"+productDetailsList1.get(0).toString());
		}
		for(int var2=0;var2<productDetailsList1.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsList1.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setPadding(5.0f);
				table1.addCell(cell1);
			}
			}
		
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
		if(applType.equals("CTO")){	
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a) Trade Effluent: The unit holder has to install and maintain continuous operation of a comprehensive effluent treatment " +
				"system consisting of Primary / Secondary / Tertiary treatment so as to achieve the quality of the treated effluent to the following standards of discharge outlet", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Standards of Discharge for Trade Effluent: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	
			PdfPTable table22 = new PdfPTable(4);
			table22.setWidthPercentage(100);
			PdfPCell cell1112 = new PdfPCell();
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Compulsory Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setColspan(2);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);	
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("6.5-8.5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Oil & Grease", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(2);
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
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" b) Sewage Effluent - The unit holder has to install and maintain continuous operation of a comprehensive treatment system as is warranted with reference to effluent quality and " +
					"operate and maintain the same continuously so as to achieve the quality to treated effluent to the following standards before disposal :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" Standards of discharge for Sewage disposal:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("a. Standards of discharge for Sewage disposal:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" Sewage Treatment - The unit holder has to install and maintain continuous operation of a comprehensive treatment system as is warranted with reference to effluent quality and " +
					"operate and maintain the same continuously so as to achieve the quality to treated effluent to the following standards before disposal :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		if(applType.equals("CTO")){		
		cellB = new PdfPCell(new Paragraph(new Chunk(" c) Water consumption & Disposal" +
				"\n i. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD." +
				"\n ii. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD" +
				"\n iii. Waste water generated from the unit shall be disposed through "+wasteWater, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("b. All the Waste water/Trade efffluent shall be treated as per norms to meet the environment standards of EP Act 1986." +
					"\nc. Water consumption " +
					"\n i. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD." +
					"\n ii. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("4. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Complance under Air Act : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
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
				"\n b. The unit holder has to operate stack(s) of the following specifications : )", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table2 = new PdfPTable(6);
		table2.setWidthPercentage(100);
		float[] columnWidths3 = {0.3f,1f,1f,1f,1f,3f};
		table2.setWidths(columnWidths3);
		PdfPCell cell111 = new PdfPCell();
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Volume Nm3/hr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Height (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Top diameter (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		for(int var2=0;var2<stackDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) stackDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell111.setPadding (5.0f);
				table2.addCell (cell111);
			}
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" c. The unit holder has to install and maintain continuous operation of a comprehensive air pollution " +
					"control system including the following pollution control devices to achieve the quality of emissions within the tolerance limits as prescribed under the environment protection act 1986:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table2a = new PdfPTable(2);
			table2a.setWidthPercentage(100);
			float[] columnWidths3a = {0.2f,1f};
			table2a.setWidths(columnWidths3a);
			PdfPCell cell111a = new PdfPCell();
			
			cell111a = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111a.setPadding(3.0f);
			table2a.addCell(cell111a);
			
			cell111a = new PdfPCell(new Paragraph(new Chunk("Pollution Control Equipments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111a.setPadding(3.0f);
			table2a.addCell(cell111a);
			
			for(int var2=0;var2<PollutionControlList.size();var2++)
			{
				ArrayList al=(ArrayList) PollutionControlList.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
					cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell111.setPadding (5.0f);
					table2a.addCell (cell111);
				}
			}
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table2a);
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
			
			cellB = new PdfPCell(new Paragraph(new Chunk("d.  Fuel Consumption Details :- ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table6 = new PdfPTable(4);
			table6.setWidthPercentage(100);
			PdfPCell cell5 = new PdfPCell();
			
			cell5 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setPadding(3.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table6.addCell(cell5);
			
			cell5 = new PdfPCell(new Paragraph(new Chunk("Type of fuel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setPadding(3.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table6.addCell(cell5);
			
			cell5 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setPadding(3.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table6.addCell(cell5);
			
			cell5 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setPadding(3.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table6.addCell(cell5);
			
			for(int var2=0;var2<fuelDetailsList.size();var2++)
			{
				ArrayList al=(ArrayList) fuelDetailsList.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell5 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
					cell5.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell5.setPadding (5.0f);
					table6.addCell (cell5);
				}
			} 
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table6);
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
		if(applType.equals("CTE")){	
			cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
						"\nThe unit holder shall have to get the samples of emission/Effluents analysed from the laboratory of J&K " +
						"PCC or laboratories approved by J&K PCC when unit becomes operational to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
		}else{
		cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
					"\nThe unit holder shall have to get the samples of emission/Effluents analysed from the laboratory of J&K " +
					"PCC or laboratories approved by J&K PCC after every "+ subject +" months to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}
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
		if(applType.equals("CTE")){	
		cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Establishment of unit only. The unit holder can only manufacture products, at the " +
				"rate of production as mentioned in consent order. Any change in production caapcity, process, raw materials use etc, shall have to be intimated " +
				"to the Boad. For any enhancement of the above, fresh consent has to be obtained fom J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Operate of unit only. The unit holder can only manufacture products, at the " +
					"rate of production as mentioned in consent order. Any change in production caapcity, process, raw materials use etc, shall have to be intimated " +
					"to the Boad. For any enhancement of the above, fresh consent has to be obtained fom J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to keep a record of the environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP Act.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed , shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall be liable to pay compensation in case any damage is caused to the environment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time.Any infringement/ violation or trangression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance monitoring of J & K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall provide adequate arrangement for fighting the accidental leakages/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall adhere to general standards terms and conditions of Water / Air Acts and compliance of environment standards as per environment protection act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply 60 days in advance for renewal of consent before expiry the date of this Consent Order", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
			if(applType.equals("CTE")){	
				cellB = new PdfPCell(new Paragraph(new Chunk(" x. ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
				
					cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall not operate the unit unless Committee issue Consent to Operate (Fresh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
					cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
					cellB.setPadding(3.0f);
					cellB.setBorder(PdfPCell.NO_BORDER);
					tableB.addCell(cellB);	
			}
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setColspan(2);
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
			if(applType.equals("CTO")){		
			cellB = new PdfPCell(new Paragraph(new Chunk(" x. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdraw.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			}else{
				cellB = new PdfPCell(new Paragraph(new Chunk(" xi. ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
				
				cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdraw.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);
			}
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setColspan(2);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		document.add(space4);document.add(space4);
		
		PdfPTable table311 = new PdfPTable(2);
		table311.setWidthPercentage(100);
		PdfPCell cell311 = new PdfPCell();
				
		cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell311.setVerticalAlignment(Element.ALIGN_LEFT);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);	

/*		if(indCategory.equals("ORANGE") || indCategory.equals("RED")){
			cell311 = new PdfPCell(new Paragraph(new Chunk("Environmental Engineer", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		}else{
		    cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		}*/
		 cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell311.setVerticalAlignment(Element.ALIGN_CENTER);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		document.add(table311);
		document.add(space4);
		
		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("Copy to the :" +
				"\n		1. Regional Director PCC "+ endtNumberIn +" for information and ensure the implementation of conditions as above." +
				"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
				"\n		3. D.O PCC "+ offDistrict +" for the direction to monitor the conditions of the consent stated above." +
				"\n		4. P.A. to Chairman, J&K PCC for information of the Chairman" +
				"\n		5. M/s "+ indName +" , " + indAddress + " for compliance of above said conditions."+
				"\n		6. Office file",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space4);
		
		document.add(space4);
		document.add(space4);
		
		Paragraph paraP484 = new Paragraph();
		paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
				"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
		paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP484);
		document.add(space4);document.add(space4);document.add(space4);
		
		Paragraph subHeading2 = new Paragraph();
		subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
		subHeading2.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading2);
		
		document.close();
		return tempFile;
	}
/////////////////////////////////////////////////////////////////Brick Kiln/////////////////////////////////////
	public File pdfFunctionBricklin(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
			String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
			String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
			String authno,ArrayList PollutionControlList,String wasteWater,String capInvest,String waterConsume,
			String sewageEffluent,String indName,String indRegNum,String indRegDate) throws Exception {
	
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
	
	Image image = Image.getInstance("images2/jammu.jpg");
	image.scalePercent(40.0f);
	image.setAlignment(Image.LEFT | Image.TEXTWRAP);
	document.add(image);
	
	Paragraph heading1 = new Paragraph();
	heading1.add(new Chunk("J&K Pollution Control Committee" +
			"\nJammu/Kashmir (www.jkspcb.nic.in)",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	heading1.setAlignment(Element.ALIGN_CENTER);
	document.add(heading1);
	document.add(space4);document.add(space4);
	
	Paragraph heading15 = new Paragraph();
	heading15.add(new Chunk("Consent Order ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	heading15.setAlignment(Element.ALIGN_CENTER);
	document.add(heading15);
	
	document.add(space4);document.add(space4);
	
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
	cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ( "+ applFor + 
			" ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
			" section 21 of the Air (Prevention & Control of Pollution) Act, 1981, as amended is granted in favour of ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellA.setPadding(3.0f);
	cellA.setColspan(2);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);
	}else{
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Operate ( "+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
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
	cellA.setColspan(2);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);
	
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
			"( registered with DIC vide registration No: " +
			"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
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
	
	if(applType.equals("CTE")){	
	cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for the establishment of unit for manufacturing of the products / by-products consented quantity as " +
			"mentioned below with capital investment of Rs."+capInvest + " lakhs(as per Schedule II):", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	}else{
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for operation of unit for the manufacturing of the products / by-products consented quantity as " +
				"mentioned below with capital investment of Rs."+capInvest + " lakhs(as per Schedule II):", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	}
	PdfPTable table1 = new PdfPTable(4);
	table1.setWidthPercentage(90);
	float[] columnWidths4 = {0.3f,1f,1f,1f};
	table1.setWidths(columnWidths4);
	PdfPCell cell1 = new PdfPCell();
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
				
	cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
			cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell1.setPadding (5.0f);
			table1.addCell (cell1);
		}
		}
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	if(applType.equals("CTO")){	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk(" a) Trade Effluent: The unit holder has to install and maintain continuous operation of a comprehensive effluent treatment " +
			"system consisting of Primary / Secondary / Tertiary treatment so as to achieve the quality of the treated effluent to the following standards of discharge outlet", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("Standards of Discharge for Trade Effluent: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

		PdfPTable table22 = new PdfPTable(4);
		table22.setWidthPercentage(100);
		PdfPCell cell1112 = new PdfPCell();
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Compulsory Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setColspan(2);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);	
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("6.5-8.5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Oil & Grease", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		cell1112.setColspan(2);
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
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" b) Sewage Effluent - The unit holder has to install and maintain continuous operation of a comprehensive treatment system as is warranted with reference to effluent quality and " +
				"operate and maintain the same continuously so as to achieve the quality to treated effluent to the following standards before disposal :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk(" Standards of discharge for Sewage disposal:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	}else{
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("a. Standards of discharge for Sewage disposal:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD | Font.UNDERLINE))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" Sewage Treatment - The unit holder has to install and maintain continuous operation of a comprehensive treatment system as is warranted with reference to effluent quality and " +
				"operate and maintain the same continuously so as to achieve the quality to treated effluent to the following standards before disposal :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	}
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	if(applType.equals("CTO")){		
	cellB = new PdfPCell(new Paragraph(new Chunk(" c) Water consumption & Disposal" +
			"\n i. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD." +
			"\n ii. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD" +
			"\n iii. Waste water generated from the unit shall be disposed through "+wasteWater, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	}else{
		cellB = new PdfPCell(new Paragraph(new Chunk("b. All the Waste water/Trade efffluent shall be treated as per norms to meet the environment standards of EP Act 1986." +
				"\nc. Water consumption " +
				"\n i. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD." +
				"\n ii. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	}
	
	cellB = new PdfPCell(new Paragraph(new Chunk("4. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Air Act : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
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
			"\n b. The unit holder has to operate stack(s) of the following specifications : )", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	PdfPTable table2 = new PdfPTable(6);
	table2.setWidthPercentage(100);
	float[] columnWidths3 = {0.3f,1f,1f,1f,1f,3f};
	table2.setWidths(columnWidths3);
	PdfPCell cell111 = new PdfPCell();
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Volume Nm3/hr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Height (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Top diameter (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	for(int var2=0;var2<stackDetailsList.size();var2++)
	{
		ArrayList al=(ArrayList) stackDetailsList.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{
			String a=(String) al.get(var3);
			cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell111.setPadding (5.0f);
			table2.addCell (cell111);
		}
	}
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" c. The unit holder has to install and maintain continuous operation of a comprehensive air pollution " +
				"control system including the following pollution control devices to achieve the quality of emissions within the tolerance limits as prescribed under the environment protection act 1986:", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table2a = new PdfPTable(2);
		table2a.setWidthPercentage(100);
		float[] columnWidths3a = {0.2f,1f};
		table2a.setWidths(columnWidths3a);
		PdfPCell cell111a = new PdfPCell();
		
		cell111a = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
		cell111a.setPadding(3.0f);
		table2a.addCell(cell111a);
		
		cell111a = new PdfPCell(new Paragraph(new Chunk("Pollution Control Equipments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
		cell111a.setPadding(3.0f);
		table2a.addCell(cell111a);
		
		for(int var2=0;var2<PollutionControlList.size();var2++)
		{
			ArrayList al=(ArrayList) PollutionControlList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell111.setPadding (5.0f);
				table2a.addCell (cell111);
			}
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table2a);
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("d.  Fuel Consumption Details :- ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table6 = new PdfPTable(4);
		table6.setWidthPercentage(100);
		PdfPCell cell5 = new PdfPCell();
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Type of fuel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		for(int var2=0;var2<fuelDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) fuelDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell5 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell5.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell5.setPadding (5.0f);
				table6.addCell (cell5);
			}
		} 
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table6);
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
	if(applType.equals("CTE")){	
		cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
					"\nThe unit holder shall have to get the samples of emission/Effluents analysed from the laboratory of J&K " +
					"PCC or laboratories approved by J&K PCC when unit becomes operational to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
	}else{
	cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
				"\nThe unit holder shall have to get the samples of emission/Effluents analysed from the laboratory of J&K " +
				"PCC or laboratories approved by J&K PCC after every "+ subject +" months to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	}
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
	if(applType.equals("CTE")){	
	cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Establishment of unit only. The unit holder can only manufacture products, at the " +
			"rate of production as mentioned in consent order. Any change in production caapcity, process, raw materials use etc, shall have to be intimated " +
			"to the Boad. For any enhancement of the above, fresh consent has to be obtained fom J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	}else{
		cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Operate of unit only. The unit holder can only manufacture products, at the " +
				"rate of production as mentioned in consent order. Any change in production caapcity, process, raw materials use etc, shall have to be intimated " +
				"to the Boad. For any enhancement of the above, fresh consent has to be obtained fom J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to keep a record of the environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP Act.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed , shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall be liable to pay compensation in case any damage is caused to the environment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time.Any infringement/ violation or trangression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance monitoring of J & K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall provide adequate arrangement for fighting the accidental leakages/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall adhere to general standards terms and conditions of Water / Air Acts and compliance of environment standards as per environment protection act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply 60 days in advance for renewal of consent before expiry the date of this Consent Order", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);	
		if(applType.equals("CTE")){	
			cellB = new PdfPCell(new Paragraph(new Chunk(" x. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
				cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall not operate the unit unless Committee issue Consent to Operate (Fresh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cellB.setPadding(3.0f);
				cellB.setBorder(PdfPCell.NO_BORDER);
				tableB.addCell(cellB);	
		}
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
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
		if(applType.equals("CTO")){		
		cellB = new PdfPCell(new Paragraph(new Chunk(" x. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdraw.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk(" xi. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdraw.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		}
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	document.add(space4);document.add(space4);
	
	PdfPTable table311 = new PdfPTable(2);
	table311.setWidthPercentage(100);
	PdfPCell cell311 = new PdfPCell();
			
	cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell311.setVerticalAlignment(Element.ALIGN_LEFT);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);
	
	  cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell311.setVerticalAlignment(Element.ALIGN_CENTER);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);
	
	document.add(table311);
	document.add(space4);
	
	Paragraph paraP48 = new Paragraph();
	paraP48.add(new Chunk("Copy to the :" +
			"\n		1. Regional Director PCC "+ endtNumberIn +" for information and ensure the implementation of conditions as above." +
			"\n		2. Deputy Commissioner "+ offDistrict +" for information" +
			"\n		3. General Manager DIC "+ cntrlequipment +" for information." +
			"\n		4. D.O PCC "+ offDistrict +" for the direction to monitor the conditions of the consent stated above." +
			"\n		5. P.A. to Chairman, J&K PCC for information of the Chairman" +
			"\n		6. M/s "+ indName +" , " + indAddress + " for compliance of above said conditions."+
			"\n		7. Office file",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
	paraP48.setAlignment(Element.ALIGN_LEFT);
	document.add(paraP48);
	document.add(space4);
	
	document.add(space4);
	document.add(space4);
	
	Paragraph paraP484 = new Paragraph();
	paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
			"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
	paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
	document.add(paraP484);
	document.add(space4);document.add(space4);document.add(space4);
	
	Paragraph subHeading2 = new Paragraph();
	subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
	subHeading2.setAlignment(Element.ALIGN_CENTER);
	document.add(subHeading2);
	
	document.close();
	return tempFile;
}
/////////////////////////////////////////////////////////////////Cement////////////////////////////////////////////////////////////////	
public File pdfFunctionCement(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
		String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
		String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
		ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
		String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
		String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
		String authno,String capInvest,String waterConsume,String sewageEffluent,String indName,String indRegNum,String indRegDate,
		ArrayList PollutionControlList) throws Exception {

	
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
	
	Image image = Image.getInstance("images2/jammu.jpg");
	image.scalePercent(40.0f);
	image.setAlignment(Image.LEFT | Image.TEXTWRAP);
	document.add(image);
	
	Paragraph heading1 = new Paragraph();
	heading1.add(new Chunk("J&K Pollution Control Committee" +
			"\nJammu/Kashmir (www.jkspcb.nic.in)",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	heading1.setAlignment(Element.ALIGN_CENTER);
	document.add(heading1);
	document.add(space4);document.add(space4);
	
	Paragraph heading15 = new Paragraph();
	heading15.add(new Chunk("Consent Order ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
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
	cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ("+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
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
	cellA.setColspan(2);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);
	
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
			"( registered with DIC vide registration No: " +
			"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellA.setPadding(3.0f);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);
	
	cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
	cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
	cellA.setPadding(3.0f);
	cellA.setColspan(2);
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for the manufacturing of the products / by-products consented quantity as " +
			"under with capital investment (as per Schedule II) Rs."+capInvest + " lakhs . Further any change / enhancement in production capacity ,process ,raw materials " +
					"shall have to be intimated to the Committee and unit holder has to apply fresh for the same", new Font(
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
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
				
	cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
	
	cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
			cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell1.setPadding (5.0f);
			table1.addCell (cell1);
		}
		}
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("3. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The emissions or discharge of environmental pollutants from the Stone Crusher/Hot mix plants shall not exceed the relevant parameters " +
			"and the standards for the said industry ,operation or process specified under respective schedules of the Environment (Protection) Rules " +
			",1986 as amended from time to time", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply to the Noise Pollution (Regulation and Control) Rules 2000 as amended take " +
			"adequate measures for control of noise from its own sources within the premises so as to maintain ambient " +
			"air quality standards in respect of noise to less tha 75 db(A) during day time and 70 db(A) during night time. Daytime is reckoned in between 6 am to 10 pm and night time is 10 pm to 6am.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("5. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Water Act : " +
			"\n Service wastewater (without co processing) : All efforts shall be made by the industry for zero discharge of service wastewater . In case, the industry prefers to discharge service wastewater, the following norms shall be complied with ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	PdfPTable table22c = new PdfPTable(2);
	table22c.setWidthPercentage(100);
	float[] columnWidths32c = {1f,1.7f};
	table22c.setWidths(columnWidths32c);
	PdfPCell cell1112c = new PdfPCell();
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("5.5 to 9.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("Oil & Grease", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("Temperature", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cell1112c = new PdfPCell(new Paragraph(new Chunk("Not more than 5C higher than the intake water temperature ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell1112c.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112c.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112c.setPadding(3.0f);
	table22c.addCell(cell1112c);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell();
	cellB.addElement(table22c);
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk(
			"\n a. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD." +
			"\n b. Daily quantity of water consumption the unit shall not exceed "+ waterConsume +" KLD." +
			"\n c. The unit holder shall take adequate safe guards for the treatment of sewerage water by way of providing septic/soakage pit and its discharge shall confirm to the following standards.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("6-9", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("Total Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);
	
	cell1112 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	
	
	cellB = new PdfPCell(new Paragraph(new Chunk("6. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("Standards of discharge of Air emissions :" +
			"\n a. The unit holder shall comply to National Ambient Air Quality Standards as perv EP Act 1986 (refer rule 3(3B))"+
			"\n b. Emission Standards Vertical Shaft Kiln (without co processing) :- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	PdfPTable table221 = new PdfPTable(2);
	table221.setWidthPercentage(100);
	float[] columnWidths321 = {1f,1.5f};
	table221.setWidths(columnWidths321);
	PdfPCell cell11121= new PdfPCell();
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/Nm3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("Particulate Matter(PM)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("50", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("SO2", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("200", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("NO2", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
	cell11121.setPadding(3.0f);
	table221.addCell(cell11121);
	
	cell11121 = new PdfPCell(new Paragraph(new Chunk("500", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("7. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Air Act : " +
			"\na.  The unit holder has to operate  stack(s) of the following specifications : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	PdfPTable table2 = new PdfPTable(6);
	table2.setWidthPercentage(100);
	float[] columnWidths3 = {0.3f,1f,1f,1f,1f,3f};
	table2.setWidths(columnWidths3);
	PdfPCell cell111 = new PdfPCell();
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Volume Nm3/hr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Height (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Top diameter (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	cell111 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell111.setVerticalAlignment(Element.ALIGN_LEFT);
	cell111.setPadding(3.0f);
	table2.addCell(cell111);
	
	for(int var2=0;var2<stackDetailsList.size();var2++)
	{
		ArrayList al=(ArrayList) stackDetailsList.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{
			String a=(String) al.get(var3);
			cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell111.setPadding (5.0f);
			table2.addCell (cell111);
		}
	}
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("b.  The unit holder has to operate and maintain a comprehensive air pollution control system to achieve the quality of emission within the tolerance limits prescribed under environment protection act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	PdfPTable table2aw = new PdfPTable(2);
	table2aw.setWidthPercentage(100);
	float[] columnWidths3aw = {0.2f,1f};
	table2aw.setWidths(columnWidths3aw);
	PdfPCell cell111aw = new PdfPCell();
	
	cell111aw = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111aw.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell111aw.setVerticalAlignment(Element.ALIGN_CENTER);
	cell111aw.setPadding(3.0f);
	table2aw.addCell(cell111aw);
	
	cell111aw = new PdfPCell(new Paragraph(new Chunk("Pollution Control Equipments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell111aw.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell111aw.setVerticalAlignment(Element.ALIGN_CENTER);
	cell111aw.setPadding(3.0f);
	table2aw.addCell(cell111aw);
	
	for(int var2=0;var2<PollutionControlList.size();var2++)
	{
		ArrayList al=(ArrayList) PollutionControlList.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{
			String a=(String) al.get(var3);
			cell111aw = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111aw.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell111aw.setPadding (5.0f);
			table2aw.addCell (cell111aw);
		}
	}
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell();
	cellB.addElement(table2aw);
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("c.  Fuel Consumption Details :- ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	PdfPTable table6 = new PdfPTable(4);
	table6.setWidthPercentage(100);
	PdfPCell cell5 = new PdfPCell();
	
	cell5 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell5.setPadding(3.0f);
	cell5.setBorderColor(new Color(0, 0, 0));
	table6.addCell(cell5);
	
	cell5 = new PdfPCell(new Paragraph(new Chunk("Type of fuel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell5.setPadding(3.0f);
	cell5.setBorderColor(new Color(0, 0, 0));
	table6.addCell(cell5);
	
	cell5 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell5.setPadding(3.0f);
	cell5.setBorderColor(new Color(0, 0, 0));
	table6.addCell(cell5);
	
	cell5 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell5.setPadding(3.0f);
	cell5.setBorderColor(new Color(0, 0, 0));
	table6.addCell(cell5);
	
	for(int var2=0;var2<fuelDetailsList.size();var2++)
	{
		ArrayList al=(ArrayList) fuelDetailsList.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{
			String a=(String) al.get(var3);
			cell5 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell5.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell5.setPadding (5.0f);
			table6.addCell (cell5);
		}
	} 
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell();
	cellB.addElement(table6);
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall not discharge any fugitive emissions from the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply with any other condition laid down or directions issued in due course by the J & K " +
			"Pollution Control Committee under the provisions of Air (Prevention and Control of Pollution) Act, 1981.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("10. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time" +
			".Any infringement/ violation or trangression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause " +
			"to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("11. ", new Font(
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("12. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall have to get the samples of emissions/effluents analysed from the laboratory of J&K PCC or laboratories approved by J&K PCC after every "+ subject +" months to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("13. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall raise green belt of suitable plant species within the premises of unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("14. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The above conditions shall be enforced inter-alia under the provision of the Water (Prevention and Control of Pollution) Act 1974, Air (Prevention and Control of Pollution) Act 1981 and Environment (Protection) Act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("15. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall adhere to the standards terms and conditions of Water / Air Act and compliance of environment standards of EP Act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("16. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall keep on-line monitoring system functional all the time for " +
			"monitoring of emissions and effluents from the unit as per the directions of Central Pollution Control Committee , on this in case of non compliance" +
			" an action under Water ( Prevention & Control of Pollution) Act 1974 , Air ( Prevention & Control of Pollution) Act 1981 and Environment (Protection) " +
			"Act 1986 shall be taken by the  Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("17. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn and unit holder shall shift the unit to another suitable site at his own risk and responsibility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("18. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	System.out.println("ds--------cement");
	
	
	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply 60 days in advance for renewal of consent before expiry the date of this Consent Order.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("19. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk(" * This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc of the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	document.add(space4);document.add(space4);
	
	PdfPTable table311 = new PdfPTable(2);
	table311.setWidthPercentage(100);
	PdfPCell cell311 = new PdfPCell();
			
	cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell311.setVerticalAlignment(Element.ALIGN_LEFT);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);
	
/*	if(indCategory.equals("ORANGE") || indCategory.equals("RED")){
		cell311 = new PdfPCell(new Paragraph(new Chunk("Environmental Engineer", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	}else{
	    cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	}	*/
	  cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell311.setVerticalAlignment(Element.ALIGN_CENTER);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);
	
	document.add(table311);
	document.add(space4);
	
	Paragraph paraP48 = new Paragraph();
	paraP48.add(new Chunk("Copy to the :" +
			"\n		1. Regional Director PCC "+ endtNumberIn + " for information and ensure the implementation of conditions as above." +
			"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
			"\n		3. D.O PCC "+ offDistrict +" for the direction to monitor the conditions of the consent regularly and status report be furnished to RD." +
			"\n		4. P.A to Chairman J&K PCC for the information of Chairman"+
			"\n		5. M/s "+ indName +" , " + indAddress + " for compliance of above said conditions."+
			"\n		6. Office file",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
	paraP48.setAlignment(Element.ALIGN_LEFT);
	document.add(paraP48);
	document.add(space4);
	
	document.add(space4);
	document.add(space4);
	
	Paragraph paraP484 = new Paragraph();
	paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
			"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
	paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
	document.add(paraP484);
	document.add(space4);document.add(space4);document.add(space4);
	
	Paragraph subHeading2 = new Paragraph();
	subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
	subHeading2.setAlignment(Element.ALIGN_CENTER);
	document.add(subHeading2);
	
	
	document.close();
	return tempFile;	
	}
/////////////////////////////////////////////////////Stone Crusher/////////////////////////////////////////////////////////////////
public File pdfFunctionStonecrushers(String appfor, String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
		String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
		String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
		ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
		String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
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
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
	heading1.setAlignment(Element.ALIGN_CENTER);
	document.add(heading1);
	document.add(space4);document.add(space4);

	Paragraph heading15 = new Paragraph();
	heading15.add(new Chunk("Consent Order ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	heading15.setAlignment(Element.ALIGN_CENTER);
	document.add(heading15);

	document.add(space4);document.add(space4);

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
	document.add(space4);

	PdfPTable tableA = new PdfPTable(2);
	tableA.setWidthPercentage(90);
	float[] columnWidthsA1 = {1.2f,1.5f};
	tableA.setWidths(columnWidthsA1);
	PdfPCell cellA = new PdfPCell();

	if(applType.equals("CTE")){	
	cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ("+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
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
	cellA.setColspan(2);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);

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
			"( registered with DIC vide registration No: " +
			"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
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

	if(applType.equals("CTE")){	
	cellA = new PdfPCell(new Paragraph(new Chunk("for a period "+ maxQuantity + " for "+ indCategory + " category of unit as per revised " +
			"classification of industrial sector, subject to the following terms and conditions in a time bound manner-: ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellA.setPadding(3.0f);
	cellA.setColspan(2);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);
	}else{
		cellA = new PdfPCell(new Paragraph(new Chunk("for a period "+ maxQuantity + " for "+ indCategory + " category of unit as per revised classification of industrial sector subject to the compliance of following terms and conditions in a time bound manner:-", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
	}
	document.add(tableA);
	document.add(space4);

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
	cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for establishment of "+appfor+" having consented quantity as " +
			"under with capital investment (as per Schedule II) Rs."+capInvest + " lakhs . Further any change / enhancement in production capacity ,process ,raw materials " +
					"shall have to be intimated to the Committee and unit holder has to apply fresh for the same", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	}else{
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for operate of "+appfor+ " having consented quantity as " +
				"under with capital investment (as per Schedule II) Rs."+capInvest + " lakhs . Further any change / enhancement in production capacity ,process ,raw materials " +
						"shall have to be intimated to the Committee and unit holder has to apply fresh for the same", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
	}
	PdfPTable table1 = new PdfPTable(4);
	table1.setWidthPercentage(90);
	float[] columnWidths4 = {0.3f,1f,1f,1f};
	table1.setWidths(columnWidths4);
	PdfPCell cell1 = new PdfPCell();

	cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);
				
	cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);

	cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setPadding(3.0f);
	cell1.setBorderColor(new Color(0, 0, 0));
	table1.addCell(cell1);

	cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
			cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
			cell1.setPadding (5.0f);
			table1.addCell (cell1);
		}
		}

	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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

	cellB = new PdfPCell(new Paragraph(new Chunk("3. ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("The emissions or discharge of environmental pollutants from the "+applFor+" shall not exceed the relevant parameters " +
			"and the standards for the said industry ,operation or process specified under respective schedules of the Environment (Protection) Rules " +
			",1986 as amended from time to time", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply with the National Ambient Air Quality Standards as per EP Act 1986 (refer rule 3(3B).", new Font(
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

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply with the Noise Pollution (Regulation and Control) Rules 2000 as amended to maintain noise level standards less than 75 db(A) during day time and 70 db(A) during night time, Daytime is reckoned in between 6am to 10pm and night time is 10pm to 6am.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall comply with the water (Prevention and control of pollution) Act 1974 and comply to the following parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

	cellB = new PdfPCell(new Paragraph(new Chunk(" a. Daily quantity of water consumption the unit shall not exceed from "+ waterConsume +" KLD.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk(" b. The unit holder shall take adequate safe guards for the treatment of sewerage water by way of provviding septic / soakage pit and its discharge shall conform to the following standards", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
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

	cell1112 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cell1112 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cell1112 = new PdfPCell(new Paragraph(new Chunk("6-9", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cell1112 = new PdfPCell(new Paragraph(new Chunk("Total Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cell1112 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cell1112 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cell1112 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
	cell1112.setPadding(3.0f);
	table22.addCell(cell1112);

	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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


	cellB = new PdfPCell(new Paragraph(new Chunk("7. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall install comprehensive air pollution control system so as to achieve the quality of emissions within the limits " +
			"prescribed under Environment Protection Act 1986 (EP Act)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	PdfPTable table31 = new PdfPTable(2);
	table31.setWidthPercentage(100);
	float[] columnWidths413 = {0.3f,1f};
	table31.setWidths(columnWidths413);
	PdfPCell cell31 = new PdfPCell();
			
	cell31 = new PdfPCell(new Paragraph(new Chunk("A.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);



	cell31 = new PdfPCell(new Paragraph(new Chunk("Implementation of following Pollution Control Measures :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);


	cell31 = new PdfPCell(new Paragraph(new Chunk("a.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Dust containment cum suppression system for the equipment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("b.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Construction of wind breaking wall", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);


	cell31 = new PdfPCell(new Paragraph(new Chunk("c.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Construction of metalled roads within the premises.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("d.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Regular cleaning and wetting of the ground within the premises.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("e.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Growing of a green belt (Broad leave trees in three rows) along the periphery.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("B.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Quantitative standards for the SPM", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("a.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("The suspended particulate matter contribution value at a distance of 40 meters from a controlled isolated as well as from a unit located in a cluster should be less than 600 mgs/Nm3. The measurements are to be conducted at least twice a month for all the 12 months in a year.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("C.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Additional Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("a.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("All the dust emitting points like jaw / roller crushers, screeners / classifiers shall be properly enclosed / covered.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("b.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Conveyor belts shall be interlocked with the crushing operation.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("c.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("The water spray system shall be interlocked with the crushing operation.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("d.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Annual health survey of the workers permanently employed by the unit holder shall be conducted.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("e.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cell31 = new PdfPCell(new Paragraph(new Chunk("Regular water spray shall be carried out at all dust emitting points, boundaries and on road.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell31.setPadding(3.0f);
	cell31.setBorderColor(new Color(0, 0, 0));
	table31.addCell(cell31);

	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell();
	cellB.addElement(table31);
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

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall not discharge any fugitive emissions from the unit beyond the permissible limits.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time. Any infringement/violation or transgression of the statutory enactments of pollution control acts by the unit shall be sufficient cause to prosecute the violator in conformity with relevant section of Air, Water Acts and Enviroment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("10.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("The "+applFor+" shall be under surveillance monitoring of J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("11.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall have to get the samples of emissions/effluents analysed from the laboratory of J&K PCC or laboratories approved by J&K PCC after every "+ subject +" months to the check the efficacy of Pollution Control Devices (PCDs) installed in the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("12.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("Once 75% of the consented quantity has been achieved in performance of the unit, the unit holder may applu for enhanced quantity on the basis of raw material procured and inspection report of the concerned district officer PCC with regard to the stream/mine of the procurement area.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("13.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk(" No raw materials shall be extracted or purchased / used brought from river one km upstream and one km from downstream of rail/road bridge, irrigation structures and any othe government infrastructure/office.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("14.", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);


		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall carry the stone aggregates /sand in covered trucks/Tippers", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("15.", new Font(
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
		cellB = new PdfPCell(new Paragraph(new Chunk("16.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		if(applType.equals("CTE")){	
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall not operate the unit unless Committee issue Consent to Operate(Fresh). In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn and unit holder shall shift the unit to another suitable site at his own risk and responsibility", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			
			cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn and unit holder shall shift the unit to another suitable site at his own risk and responsibility", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
				
		}
		cellB = new PdfPCell(new Paragraph(new Chunk("17.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The above conditions shall be enforced inter-alia under the provision of the Water (Prevention and Control of Pollution) Act 1974, Air (Prevention and Control of Pollution) Act 1981 and Environment (Protection) Act 1986", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("18.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdrawn", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

	cellB = new PdfPCell(new Paragraph(new Chunk(" * This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc of the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);

	cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

	document.add(space4);document.add(space4);

	PdfPTable table311 = new PdfPTable(2);
	table311.setWidthPercentage(100);
	PdfPCell cell311 = new PdfPCell();
			
	cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell311.setVerticalAlignment(Element.ALIGN_LEFT);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);

/*	if(indCategory.equals("ORANGE") || indCategory.equals("RED")){
		cell311 = new PdfPCell(new Paragraph(new Chunk("Environmental Engineer", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	}else{
	    cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	}	*/
	
	  cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell311.setVerticalAlignment(Element.ALIGN_CENTER);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);

	document.add(table311);
	document.add(space4);

		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("Copy to the :" +
				"\n	1. Regional Director PCC "+ endtNumberIn +" for information." +
				"\n	2. Director Geology Mining "+ fileNumberIn +" for information & ensure compliance under EIA Notification & EP Act."+
				"\n 3. General Manager DIC "+ cntrlequipment +" for information." +
				"\n 4. D.O PCC "+ offDistrict +" for informationn & ensure compliance of the conditions of the consent." +
				"\n	5. P.A to Chairman J&K PCC for the information of Chairman" +
				"\n	6. M/s "+ indName +" , " + indAddress +
				"\n	7. Office file",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space4);

	document.add(space4);
	document.add(space4);

	Paragraph paraP484 = new Paragraph();
	paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
			"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
	paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
	document.add(paraP484);
	document.add(space4);document.add(space4);document.add(space4);

	Paragraph subHeading2 = new Paragraph();
	subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
	subHeading2.setAlignment(Element.ALIGN_CENTER);
	document.add(subHeading2);


	document.close();
	return tempFile;	
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
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	heading1.setAlignment(Element.ALIGN_CENTER);
	document.add(heading1);
	document.add(space4);document.add(space4);
	
	Paragraph heading15 = new Paragraph();
	heading15.add(new Chunk("Consent Order ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
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
	document.add(space4);
	
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
	cellA.setColspan(2);
	cellA.setBorder(PdfPCell.NO_BORDER);
	tableA.addCell(cellA);
	
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
			"( registered with Tourism Deptt. vide registration No: " +
			"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
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
				"(as per Schedule II) Rs."+capInvest + " lakhs", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
	}else
	{
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for operating the hotel / restaurant facility as under with capital investment " +
				"(as per Schedule II) Rs."+capInvest + " lakhs", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	}
	
	
	
	
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
			cell1.setPadding (5.0f);
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
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
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
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk(" b. Standards of discharge for Sewerage disposal:" +
			"\n\nSewage Treatment - The hotel owner has to install a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continuously so as to achieve " +
			"the quality to treated effluent to the following standards before disposal :- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
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
		cellB.setPadding(5.0f);
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
	cellB.setPadding(5.0f);
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
	cellB.setPadding(5.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	

	cellB = new PdfPCell(new Paragraph(new Chunk(" a. The hotel owner shall comply to National Ambient Air Quality Standards as per EP Act " +
			"1986 (refer rule 3(3B)). ", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		

		cellB = new PdfPCell(new Paragraph(new Chunk("   b. Pollution Control Equipments : The hotel owner has to operate and maintain a comprehensive air pollution control system  i.e. Exhaust fans , Suction hoods and stack of 2 meters height higher that the height of building to vent out fumes to achieve the quality of emission within the tolerance limits prescribed under environment protection act 1986", new Font(
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The Consent is valid for the Establish of hotel only." , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
	}else
	{
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cellB.setPadding(3.0f);
	cellB.setColspan(2);
	cellB.setBorder(PdfPCell.NO_BORDER);
	tableB.addCell(cellB);
	
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
	
	cellB = new PdfPCell(new Paragraph(new Chunk(" * This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc of the hotel / guest house / banquet.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
	
	document.add(space4);document.add(space4);
	
	PdfPTable table311 = new PdfPTable(2);
	table311.setWidthPercentage(100);
	PdfPCell cell311 = new PdfPCell();
			
	cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell311.setVerticalAlignment(Element.ALIGN_LEFT);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);
	
/*	if(indCategory.equals("ORANGE") || indCategory.equals("RED")){
		cell311 = new PdfPCell(new Paragraph(new Chunk("Environmental Engineer", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	}else{
	    cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	}	*/
	  cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
	cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell311.setVerticalAlignment(Element.ALIGN_CENTER);
	cell311.setPadding(3.0f);
	cell311.setBorder(PdfPCell.NO_BORDER);
	table311.addCell(cell311);
	
	document.add(table311);
	document.add(space4);
	
	Paragraph paraP48 = new Paragraph();
	paraP48.add(new Chunk("Copy to the :" +
			"\n		1. Regional Director PCC "+ endtNumberIn + " for information." +
			"\n		2. Director Tourism "+ fileNumberIn +" for information." +
			"\n		3. D.O PCC "+ offDistrict +" for information & ensure compliance of the conditions of the consent." +
			"\n		4. P.A to Chairman J&K PCC for the information of Chairman."+
			"\n		5. M/s "+ indName +" , " + indAddress + " ."+
			"\n		6. Office file",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
	paraP48.setAlignment(Element.ALIGN_LEFT);
	document.add(paraP48);
	document.add(space4);
	
	document.add(space4);
	document.add(space4);
	
	Paragraph paraP484 = new Paragraph();
	paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
			"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
	paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
	document.add(paraP484);
	document.add(space4);document.add(space4);document.add(space4);
	
	Paragraph subHeading2 = new Paragraph();
	subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
	subHeading2.setAlignment(Element.ALIGN_CENTER);
	document.add(subHeading2);
	
	
	document.close();
	return tempFile;
}
//////////////////////////////////////////////////////////////Pharma/////////////////////////////////////////////////////////////////////////
public File pdfFunctionPharma(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
			String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
			String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
			String authno,String capInvest,String waterConsume,String sewageEffluent,String indName,String indRegNum,String indRegDate,
			ArrayList PollutionControlList) throws Exception {
		
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
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space4);document.add(space4);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Consent Order ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		heading15.setAlignment(Element.ALIGN_CENTER);
		document.add(heading15);
		
		document.add(space4);
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(100);
		float[] columnWidthsA = {3f,1f};
		table11.setWidths(columnWidthsA);
		PdfPCell cell11 = new PdfPCell();
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Consent No.:- PCC/digital/"+yearString+issuingConsentTypeNo+appID+" of "+currentYear, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Date:- "+ draftDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		document.add(table11);
		document.add(space4);
		
		PdfPTable tableA = new PdfPTable(2);
		tableA.setWidthPercentage(90);
		float[] columnWidthsA1 = {1.2f,1.5f};
		tableA.setWidths(columnWidthsA1);
		PdfPCell cellA = new PdfPCell();
		
		if(applType.equals("CTE")){	
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ("+ applFor + " ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
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
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
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
				"( registered with DIC vide registration No: " +
				"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent granted is valid for the manufacturing of the products / by-products consented quantity as " +
				"mentioned below with capital investment of Rs. "+capInvest + " lakhs .Further any change / enhancement in production capacity ,process ,raw materials etc" +
						"shall have to be intimated to the Committee and the unit holder has to apply fresh for the same", new Font(
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
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
					
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
				cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
			}
			}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The emissions or discharge of environmental pollutants from the unit / establishment shall not exceed the relevant parameters " +
				"and the standards for the said industry ,operation or process specified under respective schedules of the Environment (Protection) Rules " +
				",1986 as amended from time to time", new Font(
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Water Act :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a. Standards of Discharge for Trade Effluent: " +
				"\n\nTreatment : The unit holder has to operate and maintain a comprehensive effluent treatment system consisting of Primary / Secondary / " +
				"Tertiary treatment so as to achieve the quality of the treated effluent to the following standards of discharge outlet ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setColspan(2);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
		PdfPTable table22 = new PdfPTable(2);
		table22.setWidthPercentage(100);
		float[] columnWidths32 = {1f,1.7f};
		table22.setWidths(columnWidths32);
		PdfPCell cell1112 = new PdfPCell();
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Compulsory Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("6.0-8.5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Total Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("COD", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("250", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("Bioassay Test", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1112.setPadding(3.0f);
		table22.addCell(cell1112);
		
		cell1112 = new PdfPCell(new Paragraph(new Chunk("90% survival of fish after 96 hr. in 100% effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		PdfPTable table221a = new PdfPTable(2);
		table221a.setWidthPercentage(100);
		float[] columnWidths321 = {1f,1.7f};
		table221a.setWidths(columnWidths321);
		PdfPCell cell11121 = new PdfPCell();
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Additional Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Mercury", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Arsenic", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("0.20", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Chromium (Cr)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("0.10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Lead", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("0.10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Cyanide", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("0.10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Pheonolics (C6H5OH)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Sulphides (as S)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("2.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("Phosphate (as P)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("5.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221a.addCell(cell11121);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table221a);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" b. Standards of discharge for Sewerage disposal:" +
				"\n\nSewage Treatment - The unit holder has to install a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continuously so as to achieve " +
				"the quality to treated effluent to the following standards before disposal :- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table221 = new PdfPTable(3);
		table221.setWidthPercentage(100);
		float[] columnWidths321w = {1f,0.7f,1.7f};
		table221.setWidths(columnWidths321w);
		PdfPCell cell11121w= new PdfPCell();
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("Range", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("between", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("6-9", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("Not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("100 mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
		cell11121w = new PdfPCell(new Paragraph(new Chunk("30 mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121w.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121w.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121w.setPadding(3.0f);
		table221.addCell(cell11121w);
		
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" c. All Waste water / Trade effluent shall be treated as per norms to meet the environment standards of Environment Protection Act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" d. Water consumption" +
				"\n i. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD." +
				"\n ii. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
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
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a. The enterpreneur shall comply to National Ambient Air Quality Standards as per EP Act " +
				"1986 (refer rule 3(3B). " +
				"\n b. Standard for discharge of emission from boiler ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table24 = new PdfPTable(3);
		table24.setWidthPercentage(100);
		float[] columnWidths34 = {0.1f,1f,1f};
		table24.setWidths(columnWidths34);
		PdfPCell cell1114 = new PdfPCell();
		
		cell1114 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1114.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1114.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1114.setPadding(3.0f);
		table24.addCell(cell1114);
		
		cell1114 = new PdfPCell(new Paragraph(new Chunk("Emissions", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1114.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1114.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1114.setPadding(3.0f);
		table24.addCell(cell1114);
		
		cell1114 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/Nm3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1114.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1114.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1114.setPadding(3.0f);
		table24.addCell(cell1114);
		
		cell1114 = new PdfPCell(new Paragraph(new Chunk("1", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1114.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1114.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1114.setPadding(3.0f);
		table24.addCell(cell1114);
		
		cell1114 = new PdfPCell(new Paragraph(new Chunk("Particulate Matter", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1114.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1114.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1114.setPadding(3.0f);
		table24.addCell(cell1114);
		
		cell1114 = new PdfPCell(new Paragraph(new Chunk(" "+gCondition, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell1114.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1114.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1114.setPadding(3.0f);
		table24.addCell(cell1114);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table24);
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" c. The unit holder has to operate stack(s) of the following specifications :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table2 = new PdfPTable(6);
		table2.setWidthPercentage(100);
		float[] columnWidths3 = {0.3f,1f,1f,1f,1f,3f};
		table2.setWidths(columnWidths3);
		PdfPCell cell111 = new PdfPCell();
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Volume Nm3/hr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Height (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Top diameter (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		for(int var2=0;var2<stackDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) stackDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell111.setPadding (5.0f);
				table2.addCell (cell111);
			}
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("5. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to operate and maintain a comprehensive air pollution control system consisting of following Pollution Control Equipments to achieve the quality of emission within the tolerance limits prescribed under Environment Protection Act 1986.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table2a = new PdfPTable(2);
		table2a.setWidthPercentage(100);
		float[] columnWidths3a = {0.2f,1f};
		table2a.setWidths(columnWidths3a);
		PdfPCell cell111a = new PdfPCell();
		
		cell111a = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
		cell111a.setPadding(3.0f);
		table2a.addCell(cell111a);
		
		cell111a = new PdfPCell(new Paragraph(new Chunk("Pollution Control Equipments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
		cell111a.setPadding(3.0f);
		table2a.addCell(cell111a);
		
		for(int var2=0;var2<PollutionControlList.size();var2++)
		{
			ArrayList al=(ArrayList) PollutionControlList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell111.setPadding (5.0f);
				table2a.addCell (cell111);
			}
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table2a);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("6. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Fuel Consumption Details :- ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		PdfPTable table6 = new PdfPTable(4);
		table6.setWidthPercentage(100);
		PdfPCell cell5 = new PdfPCell();
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Type of fuel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setPadding(3.0f);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		for(int var2=0;var2<fuelDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) fuelDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell5 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell5.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell5.setPadding (5.0f);
				table6.addCell (cell5);
			}
		} 
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell();
		cellB.addElement(table6);
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("7. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" Compliance under Noise Pollution (Regulation and Control) Rules 2000 as amended " +
				"\nThe unit holder shall take adequate measures for control of noise from its own sources within the premises so as to maintain " +
				"ambient air quality standards in respect of noise to less tha 75dB(A) during day time and 70 dB(A) during night time. Daytime is reckoned in between " +
				"6 am to 10 pm and night time is 10 pm to 6 am.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("8. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Plastic Waste Management Rules 2016 dated 18-3-2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("9. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("Self Monitoring Schedule :" +
					"The Unit holder shall have to get the samples of emissions/effluents analysed from the laboratory Self Monitoring Report(SMR) get the samples of emission/effluents analysed from the laborartory of J&K PCC " +
					"or laboratories approved by J&K PCC after every "+ subject +" months to check the efficacy of Pollution Control Devices(PCDs) installed in the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("10. ", new Font(
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
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is valid for the Establish of unit only. The unit holder can only manufacture products, at the rate of production as mentioned in consent order." +
				"Any change in production capacity, process, raw materials, use etc. shall have to be intimated to the Committee. For any enhancement of the above, fresh consent has to be obtained from J &amp; K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("The consent is valid for the Operate of unit only. The unit holder can only manufacture products, at the rate of production as mentioned in consent order." +
					"Any change in production capacity, process, raw materials, use etc. shall have to be intimated to the Committee. For any enhancement of the above, fresh consent has to be obtained from J &amp; K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to keep a record of the environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP Act.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed , shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall be liable to pay compensation in case any damage is caused to the environment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time.Any infringement/ violation or trangression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance monitoring of J & K Pollution Control Committee. Any " +
				"further construction /expansion / renovation / in the unit premises shall be subject to the clearance from the J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall provide adequate arrangement for fighting the accidental leakages/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall adhere to general terms and conditions of Water/Air Act and compliance of the environment standards as per EP Act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply 60 days in advance for renewal of consent before expiry the date of this Consent Order.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
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
			
			cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdraw.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		document.add(space4);document.add(space4);
		
		PdfPTable table311 = new PdfPTable(2);
		table311.setWidthPercentage(100);
		PdfPCell cell311 = new PdfPCell();
				
		cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell311.setVerticalAlignment(Element.ALIGN_LEFT);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		

		  cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell311.setVerticalAlignment(Element.ALIGN_CENTER);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		document.add(table311);
		document.add(space4);
	
		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("Copy to the :" +
				"\n		1. Regional Director PCC "+ endtNumberIn +" for information and ensure the implementation of conditions as above." +
				"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
				"\n		3. D.O PCC "+ offDistrict +" for the direction to monitor the conditions of the consent stated above." +
				"\n		4. P.A. to Chairman, J&K PCC for information of the Chairman" +
				"\n		5. M/s "+ indName +" , " + indAddress + " for compliance of above said conditions."+
				"\n		6. Office file",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space4);
		
		document.add(space4);
		document.add(space4);
		
		Paragraph paraP484 = new Paragraph();
		paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
				"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
		paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP484);
		document.add(space4);document.add(space4);document.add(space4);
		
		Paragraph subHeading2 = new Paragraph();
		subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
		subHeading2.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading2);
		
		
		document.close();
		return tempFile;	
	}
////////////////////////////////////////////////////////Pesticide//////////////////////////////////////////////////////////////
public File pdfFunctionPesticide(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
			String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
			String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
			String authno,String capInvest,String waterConsume,String sewageEffluent,String indName,String indRegNum,String indRegDate,
			ArrayList PollutionControlList) throws Exception {
		
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
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space4);document.add(space4);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Consent Order ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
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
		cellA = new PdfPCell(new Paragraph(new Chunk("Consent To Establish ("+ applFor + " for "+industrytype12+
				" ) under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974 and under" +
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
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
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
				"( registered with DIC vide registration No: " +
				"\n"+indRegNum+" date: "+indRegDate +" )", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellA.setPadding(3.0f);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cellA.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellA.setPadding(3.0f);
		cellA.setColspan(2);
		cellA.setBorder(PdfPCell.NO_BORDER);
		tableA.addCell(cellA);
		
		cellA = new PdfPCell(new Paragraph(new Chunk("for a period "+ maxQuantity + " for "+ indCategory + " category of unit as per revised " +
				"classification of industrial sector, subject to the following terms and conditions in a time bound manner : ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is granted valid for the manufacturing of the products / by-products consented quantity as " +
				"under with capital investment as per Schedule II Rs."+capInvest + " lakhs .Any change / enhancement in production capacity ,process ,raw materials " +
						"shall have to be intimated to the Committee and unit holder has to apply fresh for the same", new Font(
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
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
					
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding(3.0f);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
				cell1 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setPadding (5.0f);
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
	
		cellB = new PdfPCell(new Paragraph(new Chunk("3. ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Water Act :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a. Standards of Discharge for Trade Effluent: " +
				"\n\nTreatment : The unit holder has to operate and maintain a comprehensive effluent treatment system consisting of Primary / Secondary / " +
				"Tertiary treatment so as to achieve the quality of the treated effluent to the following standards of discharge outlet ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
			cellB = new PdfPCell(new Paragraph(new Chunk("Effluent Standards", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setColspan(2);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table229 = new PdfPTable(4);
			table229.setWidthPercentage(100);
			PdfPCell cell11129 = new PdfPCell();
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("Compulsory Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setColspan(2);
			cell11129.setPadding(3.0f);
			table229.addCell(cell11129);	
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l except for pH ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("6.5-8.5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("Suspended Solids", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("100", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("Oil & Grease", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cell11129 = new PdfPCell(new Paragraph(new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11129.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11129.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11129.setPadding(3.0f);
			cell11129.setColspan(2);
			table229.addCell(cell11129);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table229);
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table226 = new PdfPTable(4);
			table226.setWidthPercentage(100);
			PdfPCell cell11126 = new PdfPCell();
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Additional Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			cell11126.setColspan(2);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Conc. in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			cell11126.setColspan(2);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Arsenic (as As)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.2", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Dimethoate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.45", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Copper", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("2,4D", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.4", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Manganese", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Aldrin", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.1", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Mercury", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Endosulfan", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Antimony(as Sb)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.1", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("Dieldrin", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cell11126 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell11126.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11126.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11126.setPadding(3.0f);
			table226.addCell(cell11126);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table226);
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table22 = new PdfPTable(4);
			table22.setWidthPercentage(100);
			PdfPCell cell1112 = new PdfPCell();
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Zinc", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Fenitrothion", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Cyanide(as CN)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.2", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Malathion", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Nitrate(as NO3)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("50", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Methyl Parathion", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Phospate(as P))", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("5.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Paraquat", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("2.3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Phenol & Phenolic Compd. As C6H5 OH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Phenathoate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Sulphur", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.03", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Phorate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Benzene hexchloride(BHC)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Propanil", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("7.3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Copper Sulphate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.05", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Pyrethrums", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Copper Oxychloride", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("9.6", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Ziram", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("1.0", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Carbonyl", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Other Pesticides (Individually)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("DDT", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("0.01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Nickel etc.(heavy metals individually)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Shall not exceed individually 5 times the drinking water standards as per Bureau of " +
					"Indian Standards.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setColspan(3);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("Bioassay test", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			table22.addCell(cell1112);
			
			cell1112 = new PdfPCell(new Paragraph(new Chunk("90% survival of fish after 96 hrs. in 100% effluent.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell1112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1112.setPadding(3.0f);
			cell1112.setColspan(3);
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" b. Standards of discharge for Sewerage disposal:" +
				"\n\nSewage Treatment - The unit holder has to install a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continuously so as to achieve " +
				"the quality to treated effluent to the following standards before disposal :- ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
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
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("between", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("BOD(3 days at 27 degree celsius)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("not to exceed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11121.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11121.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11121.setPadding(3.0f);
		table221.addCell(cell11121);
		
		cell11121 = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" c. All Waste water / Trade effluent shall be treated as per norms to meet the environment standards of Environment Protection Act 1986", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
			cellB = new PdfPCell(new Paragraph(new Chunk(" d. Water consumption" +
					"\n i. The daily quantity of sewage effluent from the unit shall not exceed "+ sewageEffluent +" KLD." +
					"\n ii. The daily quantity of water consumption shall not exceed "+ waterConsume +" KLD.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(5.0f);
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
		cellB.setPadding(5.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" a. The unit holder shall comply to NAtional Ambient Air Quality Standards as per EP Act " +
					"1986 (refer rule 3(3B). ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
			
			PdfPTable table2x = new PdfPTable(2);
			table2x.setWidthPercentage(100);
			float[] columnWidths3x = {0.5f,1f};
			table2x.setWidths(columnWidths3x);
			PdfPCell cell111x = new PdfPCell();
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("Emission standards", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("Limiting Conc. in mg/Nm3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("HCL", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("20", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("Cl2", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("H2S", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("P2O5 as H3PO4", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("NH3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("30", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("Pesticides compounds in form of", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("20", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("CH3Cl", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("20", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("HBr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cell111x = new PdfPCell(new Paragraph(new Chunk("5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell111x.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111x.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111x.setPadding(3.0f);
			table2x.addCell(cell111x);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("		The unit holder has to operate stack(s) of the following specifications : ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
		
		PdfPTable table2 = new PdfPTable(6);
		table2.setWidthPercentage(100);
		float[] columnWidths3 = {0.3f,1f,1f,1f,1f,3f};
		table2.setWidths(columnWidths3);
		PdfPCell cell111 = new PdfPCell();
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Volume Nm3/hr", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Height (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Top diameter (in Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		table2.addCell(cell111);
		
		for(int var2=0;var2<stackDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) stackDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				String a=(String) al.get(var3);
				cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
				cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell111.setPadding (5.0f);
				table2.addCell (cell111);
			}
		}
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to operate and maintain a comprehensive air " +
					"pollution control system to achieve the quality of emission within the tolerance limits prescribed under environment protection act 1986.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table2a = new PdfPTable(2);
			table2a.setWidthPercentage(100);
			float[] columnWidths3a = {0.2f,1f};
			table2a.setWidths(columnWidths3a);
			PdfPCell cell111a = new PdfPCell();
			
			cell111a = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111a.setPadding(3.0f);
			table2a.addCell(cell111a);
			
			cell111a = new PdfPCell(new Paragraph(new Chunk("Pollution Control Equipments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell111a.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111a.setVerticalAlignment(Element.ALIGN_CENTER);
			cell111a.setPadding(3.0f);
			table2a.addCell(cell111a);
			
			for(int var2=0;var2<PollutionControlList.size();var2++)
			{
				ArrayList al=(ArrayList) PollutionControlList.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell111 = new PdfPCell (new Paragraph(new Chunk(a, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
					cell111.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell111.setPadding (5.0f);
					table2a.addCell (cell111);
				}
			}
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table2a);
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
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" Compliance under Solid Waste Management Rules 2016 dated 8-4-2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
			
			cellB = new PdfPCell(new Paragraph(new Chunk("i. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The occupier shall segregate and store the waste generated by them in three separate streams namely bio-" +
					"degradable, non biodegradable and domestic hazardous waste in colour coded bins and handover segregated wastes to authorised waste pickers or waste collectors " +
					"as per the direction or notification by the local authorities from time to time. The following specifications may be adopted:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
			
			PdfPTable table61 = new PdfPTable(2);
			table61.setWidthPercentage(100);
			PdfPCell cell51 = new PdfPCell();
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Type of Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Colour of Bin", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Bio-degradable waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Green", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Recyclable waste (Plastic/metal canes)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("White/Blue", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Other wastes", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Black", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell51.setPadding(3.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table61.addCell(cell51);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table61);
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("ii ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The occupier shall store horticulture waste and garden waste geenrated from his premises and dispose " +
					"off as per the directions of the local body from time to time.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("iii ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The occupier shall throw, burn or bury the solid waste " +
					"generated by him, on streets, open public spaces outside his premises or in the drain or water bodies." +
					"off as per the directions of the local body from time to time.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("iv ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The occupier shall pay such user fee for solid waste management, as specified in the bye laws of the local bodies.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("v ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The occupier shall facilitate collection of segregated waste in separate streams, handover recyclable " +
					"material to either the authorised recyclers. The bio-degradable waste shall be processed, treated and disposed off through compositing or " +
					"bio-methanation within the premises as far as possible.The residual waste shall be given to the waste collectors or agency as directed " +
					"by the local body.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("vi ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("The occupier shall make his own arrangements for compositing (Bio mechanical composters / Bio methane plants) " +
					"if the concerned Urban Local Body/Panchayat does not have scientific waste processing facility, duly consented by the Committee, in place." +
					"\nNon-hazardeous Solid Waste:- Non-hazardeous Solid Waste has to be handled and disposed as per the guidelines of Solid " +
					"Waste Management Rules, 2016", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			PdfPTable table611 = new PdfPTable(3);
			table611.setWidthPercentage(100);
			PdfPCell cell511 = new PdfPCell();
			
			cell511 = new PdfPCell(new Paragraph(new Chunk("Type of Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(3.0f);
			cell511.setBorder(PdfPCell.NO_BORDER);
			table611.addCell(cell511);
			
			cell511 = new PdfPCell(new Paragraph(new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(3.0f);
			cell511.setBorder(PdfPCell.NO_BORDER);
			table611.addCell(cell511);
			
			cell511 = new PdfPCell(new Paragraph(new Chunk("Disposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(3.0f);
			cell511.setBorder(PdfPCell.NO_BORDER);
			table611.addCell(cell511);
			
			cell511 = new PdfPCell(new Paragraph(new Chunk("Empty Barrel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(3.0f);
			cell511.setBorder(PdfPCell.NO_BORDER);
			table611.addCell(cell511);
			
			cell511 = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(3.0f);
			cell511.setBorder(PdfPCell.NO_BORDER);
			table611.addCell(cell511);
			
			cell511 = new PdfPCell(new Paragraph(new Chunk("sold to recyclers", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(3.0f);
			cell511.setBorder(PdfPCell.NO_BORDER);
			table611.addCell(cell511);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell();
			cellB.addElement(table611);
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" Compliance under Noise Pollution (Regulation and Control) Rules 2000 as amended " +
				"\nThe unit holder shall take adequate measures for control of noise from its own sources within the premises so as to maintain " +
				"ambient air quality standards in respect of noise to less tha 75dB(A) during day time and 70 dB(A) during night time. Daytime is reckoned in between " +
				"6 am to 10 pm and night time is 10 pm to 6 am.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
			cellB = new PdfPCell(new Paragraph(new Chunk("Compliance under Plastic Waste Management Rules 2016 dated 18-3-2016" +
					"\nSelf Monitoring Schedule :The unit holder shall have to get the samples of emission/Effluents analysed from the laboratory of J&K " +
					"PCC or laboratories approved by J&K PCC after every "+ subject +" months to check the efficacy of Pollution Control Devices(PCDs) installed in the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		cellB = new PdfPCell(new Paragraph(new Chunk("The consent is valid for the Establish of unit only. The unit holder can only manufacture products, at the rate of production as mentioned in consent order.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		}else{
			cellB = new PdfPCell(new Paragraph(new Chunk("The consent is valid for the Operate of unit only. The unit holder can only manufacture products, at the rate of production as mentioned in consent order.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder has to keep a record of the environmental data monitored regularly with regard to operation and maintenance of pollution control devices viz Air Pollution and Water Pollution Control to achieve the desired standards notified in EP Act.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("Pollution Control Devices (ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed , shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J & K Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall be liable to pay compensation in case any damage is caused to the environment.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall abide by the directions of the Committee which will be issued from time to time.Any infringement/ violation or trangression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit shall be under surveillance monitoring of J & K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall provide adequate arrangement for fighting the accidental leakages/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder should apply 60 days in advance for renewal of consent before expiry the date of this Consent Order.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk("The unit holder shall install the latest state of art technology Air pollution control devices " +
					"for control of volatile organics emission well within permissible limit and ensure that emission shall not be vented out untreated " +
					"so as to cause any adverse environmental impact to the adjoining areas. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);	
			
			cellB = new PdfPCell(new Paragraph(new Chunk("Specific Conditions:- ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
			
			cellB = new PdfPCell(new Paragraph(new Chunk(" xi. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cellB.setPadding(3.0f);
			cellB.setBorder(PdfPCell.NO_BORDER);
			tableB.addCell(cellB);
			
			cellB = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint the consent shall be withdraw.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		cellB = new PdfPCell(new Paragraph(new Chunk(" * This consent is issued purely from environmental angle and the Committee shall not be responsible for any claim, counter claim, ownership, partnership etc of the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cellB.setPadding(3.0f);
		cellB.setColspan(2);
		cellB.setBorder(PdfPCell.NO_BORDER);
		tableB.addCell(cellB);
		
		cellB = new PdfPCell(new Paragraph(new Chunk("'By Order'", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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
		
		document.add(space4);document.add(space4);
		
		PdfPTable table311 = new PdfPTable(2);
		table311.setWidthPercentage(100);
		PdfPCell cell311 = new PdfPCell();
				
		cell311 = new PdfPCell(new Paragraph(new Chunk(copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell311.setVerticalAlignment(Element.ALIGN_LEFT);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		  cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell311.setVerticalAlignment(Element.ALIGN_CENTER);
		cell311.setPadding(3.0f);
		cell311.setBorder(PdfPCell.NO_BORDER);
		table311.addCell(cell311);
		
		document.add(table311);
		document.add(space4);
	
		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("Copy to the :" +
				"\n		1. Regional Director PCC "+ endtNumberIn +" for information and ensure the implementation of conditions as above." +
				"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
				"\n		3. D.O PCC "+ offDistrict +" for the direction to monitor the conditions of the consent stated above." +
				"\n		4. P.A. to Chairman, J&K PCC for information of the Chairman" +
				"\n		5. M/s "+ indName +" , " + indAddress + " for compliance of above said conditions."+
				"\n		6. Office file",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space4);
		
		document.add(space4);
		document.add(space4);
		
		Paragraph paraP484 = new Paragraph();
		paraP484.add(new Chunk("The unit holder shall comply to environment standards as notified under the environment protection Act 1986, read with the Water " +
				"(Prevention & Control of Pollution) Act 1974 & Air (Prevention & Control of Pollution) Act, 1981 which can also be downloaded from the website www.jkspcb.nic.in or at www.cpcb.nic.in ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 4, Font.NORMAL | Font.UNDERLINE)));
		paraP484.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP484);
		document.add(space4);document.add(space4);document.add(space4);
		
		Paragraph subHeading2 = new Paragraph();
		subHeading2.add(new Chunk(" “This is computer generated document from OCMMS by JKPCC” ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3 , Font.BOLD)));
		subHeading2.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading2);
		
		
		document.close();
		return tempFile;	
	}

}
