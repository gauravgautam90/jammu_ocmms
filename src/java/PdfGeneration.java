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

public class PdfGeneration {
	private String applfor;

	public File pdfFunction(String indAddress,String draftDate,String occName,String 
			occAddress,String applFor,String indusName,String endDate1,String category,
			String id,String dateCreated ,String indNewCapInvt,ArrayList productDetailsList,
			String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
			String regId,String regDate,String officeAddress,String indCity,String indPin,String tehsil1 
			,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
			ArrayList qualityParameterDetailsList1,
			ArrayList qualityParameterDetailsList2,
			ArrayList solidWasteDisposalDetailsList1,ArrayList airParameterQualityDetailsList1,
			ArrayList stackDetailsList,ArrayList fuelDetailsList) throws Exception {
		
File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		if (applType.equals("CTE")) {
		
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J & K Pollution Control Committee \n" +
				officeAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(100);
		PdfPCell cell11 = new PdfPCell();
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Application Number :"+id, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell11.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setColspan(2);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setBorderColor(new Color(0, 0, 0));
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Number :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setBorderColor(new Color(0, 0, 0));
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Date :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setVerticalAlignment(Element.ALIGN_RIGHT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setBorderColor(new Color(0, 0, 0));
		table11.addCell(cell11);
		
		document.add(table11);
		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space4);
				
		Paragraph heading2 = new Paragraph();
		heading2.add(new Chunk("Consent Order",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL)));
		heading2.setAlignment(Element.ALIGN_CENTER);
		document.add(heading2);
		
		Paragraph heading3 = new Paragraph();
		heading3.add(new Chunk("Schedule III",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		heading3.setAlignment(Element.ALIGN_CENTER);
		document.add(heading3);
		
		document.add(space4);
		
		Paragraph heading4 = new Paragraph();
		heading4.add(new Chunk("Consent Order No.: "+fileNumberIn,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		heading4.setAlignment(Element.ALIGN_LEFT);
		document.add(heading4);
		
		document.add(space4);
		
		if(applFor.equals("NEW")){
			applFor="Fresh";
		}
		
		Paragraph paraA = new Paragraph();
		paraA.add(new Chunk("Consent to Establish " ,	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraA.add(new Chunk("("+ applFor+")" ,	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));

		paraA.setAlignment(Element.ALIGN_LEFT);
		document.add(paraA);
		document.add(space4);

		
		Paragraph paraB = new Paragraph();
		paraB.add(new Chunk(". Under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, as amended.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraB.setAlignment(Element.ALIGN_LEFT);
		document.add(paraB);
		document.add(space4);
		
		
			
		Paragraph paraD = new Paragraph();
		paraD.add(new Chunk(". Under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraD.setAlignment(Element.ALIGN_LEFT);
		document.add(paraD);
		document.add(space4);
		
		Paragraph paraE = new Paragraph();
		paraE.add(new Chunk("Name of the unit holder with address: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraE.add(new Chunk(occName+","+occAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		
		paraE.setAlignment(Element.ALIGN_LEFT);
		document.add(paraE);
		document.add(space4);
		
		Paragraph paraF = new Paragraph();
		paraF.add(new Chunk("Consent is granted to: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraF.add(new Chunk(indusName ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraF.add(new Chunk("\n Address:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
	
		paraF.add(new Chunk(indAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraF.add(new Chunk("\n City: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraF.add(new Chunk(indCity,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraF.add(new Chunk( "\n Pin: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraF.add(new Chunk(indPin,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
	
		
		paraF.add(new Chunk("\n Tehsil: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraF.add(new Chunk(tehsil1,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraF.add(new Chunk(" \n District: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		
		paraF.add(new Chunk(district,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		
		
		
		
		paraF.setAlignment(Element.ALIGN_LEFT);
		document.add(paraF);
		document.add(space4);
	
		
		Paragraph paraG = new Paragraph();
		paraG.add(new Chunk("Located in the area declared under the provisions of the Water Act/Air Act, subject to the provisions of the Act and the Orders that may be made further and subject to the following terms and conditions:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraG.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraG);
		document.add(space4);
		
			
		Paragraph paraP1 = new Paragraph();
		paraP1.add(new Chunk("1. The Consent to Establish",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
	
		paraP1.add(new Chunk("(" +applFor+ ")",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
	
		paraP1.add(new Chunk(" is granted for a period  .",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
	
		paraP1.add(new Chunk( startDate1+" - "+endDate1,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
	
	
		
		paraP1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP1);
		document.add(space4);
		
	
		
		
		Paragraph paraP2 = new Paragraph();
		paraP2.add(new Chunk("2.The Consent granted by the Board is restricted to Prevention and Control of Pollution only and shall not be treated as substitute of permission required under other laws of the land.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP2.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP2);
		document.add(space4);
		

		Paragraph paraP3 = new Paragraph();
		paraP3.add(new Chunk("3. Category of the unit as per UCM Guidelines: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP3.add(new Chunk(category,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		paraP3.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP3);
		document.add(space4);
		
		Paragraph paraP4 = new Paragraph();
		paraP4.add(new Chunk("4. The Consent is valid for the manufacture of the following products/by-products with capital investment(Land, Plant and machinery) of : "+indNewCapInvt+" Lacs",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP4.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP4);
		document.add(space4);
		
		Paragraph paraP5 = new Paragraph();
		paraP5.add(new Chunk("5. The unit is registered with DIC vide registration No: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP5.add(new Chunk(regId ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraP5.add(new Chunk(" date: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP5.add(new Chunk(regDate,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		
		paraP5.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP5);
		document.add(space4);
	
		
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidthPercentage(100);
		PdfPCell cell1 = new PdfPCell();
		
		
			
							cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_LEFT);
					cell1.setPadding(3.0f);
					//cell1.setBorder(PdfPCell.NO_BORDER);
					cell1.setBorderColor(new Color(0, 0, 0));
					table1.addCell(cell1);
					
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1.setPadding(3.0f);
		//cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		

		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1.setPadding(3.0f);
		//cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1.setPadding(3.0f);
		//cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		
		table1.addCell(cell1);
		
		
		
		for(int var2=0;var2<productDetailsList1.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsList1.get(var2);
			
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell1 = new PdfPCell (new Paragraph(a));
				//cell.setColspan (2);
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell.setBackgroundColor (new Color (128, 200, 128));
				cell1.setPadding (5.0f);
			//	cell1.setBorder(PdfPCell.NO_BORDER);
				table1.addCell (cell1);
				
			}
			}
		
		document.add(table1);
	
		
		document.add(space4);
				
		Paragraph paraP6 = new Paragraph();
		paraP6.add(new Chunk("Conditions under Water Act:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP6.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP6);
		document.add(space4);
		
		Paragraph paraP7 = new Paragraph();
		paraP7.add(new Chunk("(i) The daily quantity of trade effluent from the unit shall not exceed the permissible quantity approved.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP7.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP7);
		document.add(space4);
		
		
		Paragraph paraP8 = new Paragraph();
		paraP8.add(new Chunk("(ii) The daily quantity of sewage effluent from the unit shall not exceed the permissible quantity approved.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP8.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP8);
		document.add(space4);
		
						
		Paragraph paraP10 = new Paragraph();
		paraP10.add(new Chunk("(iii) The daily quantity of water consumption shall not exceed ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP10.add(new Chunk(maxQuantity,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		paraP10.add(new Chunk(" KLD.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP10.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP10);
		document.add(space4);
		
		Paragraph paraP11 = new Paragraph();
		paraP11.add(new Chunk("Treatment: The application has to operate and maintain a comprehensive treatment system consisting of Primary/Secondary and/ or Tertiary treatment as is warranted with reference to influent quality and operate and maintain the same continuously so as to achieve the quality of the treated effluent to the following standards before disposal.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP11.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP11);
		document.add(space4);
		
		PdfPTable table2 = new PdfPTable(3);
		table2.setWidthPercentage(100);
		PdfPCell cell111 = new PdfPCell();
		
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Quality Parameter", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		//cell111.setBorder(PdfPCell.NO_BORDER);
		cell111.setBorderColor(new Color(0, 0, 0));
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		//cell111.setBorder(PdfPCell.NO_BORDER);
		cell111.setBorderColor(new Color(0, 0, 0));
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Standard Value (in mg/l)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		//cell111.setBorder(PdfPCell.NO_BORDER);
		cell111.setBorderColor(new Color(0, 0, 0));
		table2.addCell(cell111);
		
		
		for(int var2=0;var2<qualityParameterDetailsList1.size();var2++)
		{
		ArrayList al=(ArrayList) qualityParameterDetailsList1.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{

		String a=(String) al.get(var3);
		
		cell111 = new PdfPCell (new Paragraph(a));
		cell111.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell111.setPadding (5.0f);
	//	cell111.setBorder(PdfPCell.NO_BORDER);
		table2.addCell (cell111);

		}
		}

	
		document.add(table2);
		
		document.add(space4);
		
		Paragraph paraP12 = new Paragraph();
		paraP12.add(new Chunk("(iv) Trade Effluent Disposal Outlet Conditions:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP12.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP12);
		
		
		
		Paragraph paraP13 = new Paragraph();
		paraP13.add(new Chunk("The unit holder must ensure the safe disposal of effluent by adopting the Pollution Control measures and installation of required pollution control devices as per the water(Prevention & Control of Pollution)Act, 1974 and amendments made thereafter.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP13.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP13);
		document.add(space4);
		
		
		Paragraph paraP15 = new Paragraph();
		paraP15.add(new Chunk("(v) Sewage treatment:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP15.setAlignment(Element.ALIGN_LEFT);
		
		document.add(paraP15);
		
		document.add(space4);
				
		Paragraph paraP16 = new Paragraph();
		paraP16.add(new Chunk("The applicant has to install a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continously so as to achieve the quality of treated effluent to the following standards before disposal:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP16.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP16);
		document.add(space4);
//////////////////////sawage treatment details//////////////////
		
		PdfPTable table221 = new PdfPTable(3);
		table221.setWidthPercentage(100);
		PdfPCell cell11191 = new PdfPCell();
	
	
		cell11191 = new PdfPCell(new Paragraph(new Chunk("Quality Parameter", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11191.setPadding(3.0f);
		//cell11191.setBorder(PdfPCell.NO_BORDER);
		cell11191.setBorderColor(new Color(0, 0, 0));
		table221.addCell(cell11191);
		
		
		cell11191 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11191.setPadding(3.0f);
		//cell11191.setBorder(PdfPCell.NO_BORDER);
		cell11191.setBorderColor(new Color(0, 0, 0));
		table221.addCell(cell11191);
		
		
		cell11191 = new PdfPCell(new Paragraph(new Chunk("Standard Value (in mg/l)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11191.setPadding(3.0f);
		//cell11191.setBorder(PdfPCell.NO_BORDER);
		cell11191.setBorderColor(new Color(0, 0, 0));
		table221.addCell(cell11191);
		

		for(int var2=0;var2<qualityParameterDetailsList2.size();var2++)
		{
			ArrayList al=(ArrayList) qualityParameterDetailsList2.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell11191 = new PdfPCell (new Paragraph(a));
				cell11191.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell11191.setPadding (5.0f);
			//	cell11191.setBorder(PdfPCell.NO_BORDER);
				table221.addCell (cell11191);
				
			}
			}
		
				
		document.add(table221);
		

		document.add(space4);
				
		Paragraph paraP17 = new Paragraph();
		paraP17.add(new Chunk("(vi) Sewage Disposal Outlet Conditions:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP17.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP17);
		
		
		
		Paragraph paraP18 = new Paragraph();
		paraP18.add(new Chunk("All the domestic waste water shall be collected in the Septic tank and soakage pit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP18.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP18);
		document.add(space4);
		
		
		Paragraph paraP19 = new Paragraph();
		paraP19.add(new Chunk("(vii) Non Hazardous Solid Waste:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP19.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP19);
		
		
		
		Paragraph paraP20 = new Paragraph();
		paraP20.add(new Chunk("The non-hazardous solid waste has to be handled and disposed as per the guidelines of municipal Solid Waste Rules, 2000.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP20.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP20);
		document.add(space4);
				
		Paragraph paraP21 = new Paragraph();
		paraP21.add(new Chunk("(viii) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP21.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP21);		
		
		Paragraph paraP22 = new Paragraph();
		paraP22.add(new Chunk("The unit shall comply with any  laid down or directions issued in due course by the Board from time to time under the provision of the Water(Prevention and Control)Act, 1974.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP22.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP22);
		document.add(space4);
		
		PdfPTable table211 = new PdfPTable(4);
		table211.setWidthPercentage(100);
		PdfPCell cell1118 = new PdfPCell();
		
		
		cell1118 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1118.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1118.setPadding(3.0f);
		//cell1118.setBorder(PdfPCell.NO_BORDER);
		cell1118.setBorderColor(new Color(0, 0, 0));
		table211.addCell(cell1118);
		
		
		cell1118 = new PdfPCell(new Paragraph(new Chunk("Type of Waste", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1118.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1118.setPadding(3.0f);
		//cell1118.setBorder(PdfPCell.NO_BORDER);
		cell1118.setBorderColor(new Color(0, 0, 0));
		table211.addCell(cell1118);
		
		cell1118 = new PdfPCell(new Paragraph(new Chunk("Quantity (in TPA)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1118.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1118.setPadding(3.0f);
		//cell1118.setBorder(PdfPCell.NO_BORDER);
		cell1118.setBorderColor(new Color(0, 0, 0));
		table211.addCell(cell1118);
		
		
		cell1118 = new PdfPCell(new Paragraph(new Chunk("Mode of Disposal", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1118.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1118.setPadding(3.0f);
		//cell1118.setBorder(PdfPCell.NO_BORDER);
		cell1118.setBorderColor(new Color(0, 0, 0));
		table211.addCell(cell1118);
		
		
		for(int var2=0;var2<solidWasteDisposalDetailsList1.size();var2++)
		{
			ArrayList al=(ArrayList) solidWasteDisposalDetailsList1.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
			
				cell1118 = new PdfPCell (new Paragraph(a));
				cell1118.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1118.setPadding (5.0f);
				//cell1118.setBorder(PdfPCell.NO_BORDER);
				table211.addCell (cell1118);
				
			}
			}
				
		document.add(table211);
		
		Paragraph paraP23 = new Paragraph();
		paraP23.add(new Chunk("Conditions under Air Act:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP23.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP23);
		
		Paragraph paraP24 = new Paragraph();
		paraP24.add(new Chunk("(I) The applicant has to operate stack(s) of the following specifications:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP24.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP24);
		document.add(space4);
				
		PdfPTable table3 = new PdfPTable(6);
		table3.setWidthPercentage(100);
		PdfPCell cell2 = new PdfPCell();
				
		cell2 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Volume Nm^3/hr", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Height in mtr", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Top Diameter in mtrs", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		
		for(int var2=0;var2<stackDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) stackDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell2 = new PdfPCell (new Paragraph(a));
				cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell2.setPadding (5.0f);
				//cell2.setBorder(PdfPCell.NO_BORDER);
				table3.addCell (cell2);
				
			}
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		document.add(table3);
		document.add(space4);
		
		
		
		
		
		Paragraph paraP25 = new Paragraph();
		paraP25.add(new Chunk("(II) The applicant has to operate and maintain a comprehensive air pollution control system consisting of control equipment as detailed below to control the emissions continuosly so as to achieve the level of pollutants to the following standards:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP25.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP25);
		document.add(space4);
		
		
//		PdfPTable table4 = new PdfPTable(2);
//		table4.setWidthPercentage(100);
//		PdfPCell cell3 = new PdfPCell();
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("Pollution Control equipments & measures:-", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("Bag house filter", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		document.add(table4);
//		
		Paragraph paraP251 = new Paragraph();
		paraP251.add(new Chunk("Standards for emissions of Air pollution as per MOEF notification under EP Act 1986:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP251.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP251);
		document.add(space4);
		
		
		PdfPTable table5 = new PdfPTable(4);
		table5.setWidthPercentage(100);
		PdfPCell cell4 = new PdfPCell();
		
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("Quality Parameter", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("Standard Value (in mg/Nm3)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		
		
		for(int var2=0;var2<airParameterQualityDetailsList1.size();var2++)
		{
		ArrayList al=(ArrayList) airParameterQualityDetailsList1.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{

		String a=(String) al.get(var3);
		
		cell4 = new PdfPCell (new Paragraph(a));
		cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell4.setPadding (5.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		table5.addCell (cell4);

		}
		}


		document.add(table5);
		
		
		Paragraph paraP26 = new Paragraph();
		paraP26.add(new Chunk("(III) The applicant is consuming the following fuel",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP26.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP26);
		document.add(space4);
		
		PdfPTable table6 = new PdfPTable(4);
		table6.setWidthPercentage(100);
		PdfPCell cell5 = new PdfPCell();
		
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Type of fuel and consumption", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		for(int var2=0;var2<fuelDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) fuelDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell5 = new PdfPCell (new Paragraph(a));
				cell5.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell5.setPadding (5.0f);
				//cell5.setBorder(PdfPCell.NO_BORDER);
				table6.addCell (cell5);
				
			}
			}
		
		document.add(table6);
		
		
		Paragraph paraP27 = new Paragraph();
		paraP27.add(new Chunk("Other Conditions:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP27.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP27);
		document.add(space4);
				
		Paragraph paraP28 = new Paragraph();
		paraP28.add(new Chunk("(a) The entrepreneur shall ensure that no Air pollution problem or any nuisance is created in the area due to discharge of emissions from the unit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP28.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP28);
		document.add(space4);
		
		
		Paragraph paraP29 = new Paragraph();
		paraP29.add(new Chunk("(b) The unit shall not discharge any fugitive emissions from the unit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP29.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP29);
		document.add(space4);
		
		
//		PdfPTable table2111 = new PdfPTable(4);
//		table2111.setWidthPercentage(100);
//		PdfPCell cell11181 = new PdfPCell();
//		
//		
//		cell11181 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
//		cell11181.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell11181.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell11181.setPadding(3.0f);
//		//cell1118.setBorder(PdfPCell.NO_BORDER);
//		cell11181.setBorderColor(new Color(0, 0, 0));
//		table2111.addCell(cell11181);
//		
//		
//		cell11181 = new PdfPCell(new Paragraph(new Chunk("Type of Waste", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
//		cell11181.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell11181.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell11181.setPadding(3.0f);
//		//cell1118.setBorder(PdfPCell.NO_BORDER);
//		cell11181.setBorderColor(new Color(0, 0, 0));
//		table2111.addCell(cell11181);
//		
//		cell11181 = new PdfPCell(new Paragraph(new Chunk("Quantity (in TPA)", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
//		cell11181.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell11181.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell11181.setPadding(3.0f);
//		//cell1118.setBorder(PdfPCell.NO_BORDER);
//		cell11181.setBorderColor(new Color(0, 0, 0));
//		table2111.addCell(cell11181);
//		
//		
//		cell11181 = new PdfPCell(new Paragraph(new Chunk("Mode of Disposal", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
//		cell11181.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell11181.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell11181.setPadding(3.0f);
//		//cell1118.setBorder(PdfPCell.NO_BORDER);
//		cell11181.setBorderColor(new Color(0, 0, 0));
//		table2111.addCell(cell11181);
//		
//		
//		for(int var2=0;var2<solidWasteDisposalDetailsList1.size();var2++)
//		{
//			ArrayList al=(ArrayList) solidWasteDisposalDetailsList1.get(var2);
//			for(int var3=0;var3<al.size();var3++)
//			{
//				
//				String a=(String) al.get(var3);
//				
//				cell11181 = new PdfPCell (new Paragraph(a));
//				cell11181.setHorizontalAlignment (Element.ALIGN_LEFT);
//				cell11181.setPadding (5.0f);
//				//cell1118.setBorder(PdfPCell.NO_BORDER);
//				table2111.addCell (cell11181);
//				
//			}
//			}
//		
//		
//		
//		document.add(table2111);
//		
//		
		
		Paragraph paraP30 = new Paragraph();
		paraP30.add(new Chunk("(c) The entrepreneur shall comply with any other conditions laid down or directions issued in due course by the J&K Pollution Control Committee under the provisions of Air(Prevention and Control of Pollution)Act, 1981.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP30.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP30);
		document.add(space4);
		
		
		Paragraph paraP31 = new Paragraph();
		paraP31.add(new Chunk("Conditions for Noise Pollution:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP31.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP31);
		document.add(space4);
		
		Paragraph paraP32 = new Paragraph();
		paraP32.add(new Chunk("The entrepreneur shall take measures for control of noise from its own sources within the premises so as to maintain ambient air quality standards in respect of noise to less than 75 db(A) during day time and 70 db(A) during night. Daytime is reckoned in between 6am to 10pm and night time is 10pm to 6am. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP32.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP32);
		document.add(space4);
		
		Paragraph paraP33 = new Paragraph();
		paraP33.add(new Chunk("Self Monitoring Schedule:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP33.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP33);
		
		
		Paragraph paraP34 = new Paragraph();
		paraP34.add(new Chunk("Application shall get the samples of treated emissions analysed from the laboratory recognized by the SPCB/PCC/CPCB/MOEF, New Delhi and conform to the limits stipulated. Test report shall be sent to the Pollution Control Committee(Analysis frequency could be different foe various sources as may be specified by the Board/Committee). ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP34.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP34);
		document.add(space4);
		
		
		Paragraph paraP35 = new Paragraph();
		paraP35.add(new Chunk("The applicant shall comply with the additional conditions as stipulated below:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP35.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP35);
		
		
		Paragraph paraP36 = new Paragraph();
		paraP36.add(new Chunk("(i). The Consent is valid for the CTE "+applFor+" of unit only. The unit holder can only maufacture products, at rate of production as mentioned in consent order. Any change in production capacity, process, raw materials, use etc. shall have to be intimated to the Board. For any enhancement of theabove, fresh consent has to be obtained from J & K Pollution Control Committee. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP36.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP36);
		document.add(space4);
		
		Paragraph paraP37 = new Paragraph();
		paraP37.add(new Chunk("(ii) Pollution Control Devices(ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed, shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J&K Pollution Control Committee.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP37.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP37);
		document.add(space4);
		
		Paragraph paraP38 = new Paragraph();
		paraP38.add(new Chunk("(iii) The entrepreneur shall liable to pay compensation in case any damage is caused to the environmet.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP38.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP38);
		document.add(space4);
		
		Paragraph paraP39 = new Paragraph();
		paraP39.add(new Chunk("(iv) The entrepreneur shall abide by the directions of the Board which will be issued from time to time. Any infringent/violation or transgression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP39.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP39);
		document.add(space4);
		
		Paragraph paraP40 = new Paragraph();
		paraP40.add(new Chunk("(vi) Any further construction/expansion/renovation/ in the unit premises shall be subject to the clearance from the J&K Pollution Control Committee.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP40.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP40);
		document.add(space4);
		
		Paragraph paraP41 = new Paragraph();
		paraP41.add(new Chunk("(vii) The entrepreneur shall provide adequate arrangement for fighting the accidental leakage/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP41.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP41);
		document.add(space4);
		
		Paragraph paraP42 = new Paragraph();
		paraP42.add(new Chunk("(ix) Good House keeping prctices shall be adopted by the entrprenuer.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP42.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP42);
		document.add(space4);
		
		Paragraph paraP43 = new Paragraph();
		paraP43.add(new Chunk("(x) It shall be responsibility of the entrepreneur to ensure that there are so complaints from the surrounding areas due to pollution caused by the unit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP43.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP43);
		document.add(space4);
		
		
		Paragraph paraP44 = new Paragraph();
		paraP44.add(new Chunk("(xi) The entrepreneur will submit two self monitoring reports during the period of consent. First during first six months and second during last six months, to know the efficiency of pollution control devices installed.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP44.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP44);
		document.add(space4);
		
		Paragraph paraP45 = new Paragraph();
		paraP45.add(new Chunk("(xii) In case of violation of above mentioned conditions or any public complaint, the consent shall be withdrawn.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP45.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP45);
		document.add(space4);
		
		Paragraph paraP549 = new Paragraph();
		paraP549.add(new Chunk("General Conditions \n"+gCondition+"\n Specific Conditions \n"+sCondition,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP549.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP549);
		document.add(space4);
		
		document.newPage();
		
		Paragraph paraP46 = new Paragraph();
		paraP46.add(new Chunk("Asstt. Environment Engineer",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP46.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP46);
		document.add(space4);
		
		Paragraph paraP47 = new Paragraph();
		paraP47.add(new Chunk("Member Secretary \n" + officeAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP47.setAlignment(Element.ALIGN_RIGHT);
		document.add(paraP47);
		document.add(space4);
		
		
		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("To",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space4);
		
		Paragraph paraP49 = new Paragraph();
		 paraP49.add(new Chunk(indusName + "\n Address:"+indAddress+"\n City: "+indCity+"\n Pin: "+indPin+"\n Tehsil: "+tehsil1+" \n District: "+ district,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		 paraP49.setAlignment(Element.ALIGN_LEFT);
		document.add( paraP49);
		document.add(space4);
		
		Paragraph paraP50 = new Paragraph();
		paraP50.add(new Chunk("Copy to the:  \n"+copyTo,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP50.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP50);
		document.add(space4);
		
		
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		
		
		Paragraph paraP55 = new Paragraph();
		 paraP55.add(new Chunk("Jammu Address: Parivesh Bhawan, Gladni Transport Nagar,(Narwal), Jammu(ph, 2476925, 26,27)\n Srinagar Address: Sheikh-ul-Alam Campus, Raj Bagh, Behind Govt. Silk Factory, Srinagar(Kashmir)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -3, Font.NORMAL)));
		 paraP55.setAlignment(Element.ALIGN_CENTER);
		 document.add(paraP55);

				
		
		document.close();
		return tempFile;
	}else {
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J & K Pollution Control Committee \n" +
				officeAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(100);
		PdfPCell cell11 = new PdfPCell();
		
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Application Number :" +id, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setBorderColor(new Color(0, 0, 0));
		table11.addCell(cell11);
		
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Number :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setBorderColor(new Color(0, 0, 0));
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Date :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell11.setVerticalAlignment(Element.ALIGN_RIGHT);
		cell11.setPadding(3.0f);
		cell11.setBorder(PdfPCell.NO_BORDER);
		cell11.setBorderColor(new Color(0, 0, 0));
		table11.addCell(cell11);
		
		document.add(table11);
		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space4);
		
		
		Paragraph heading2 = new Paragraph();
		heading2.add(new Chunk("Consent Order",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.NORMAL)));
		heading2.setAlignment(Element.ALIGN_CENTER);
		document.add(heading2);
		
		Paragraph heading3 = new Paragraph();
		heading3.add(new Chunk("Schedule III",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		heading3.setAlignment(Element.ALIGN_CENTER);
		document.add(heading3);
		
		document.add(space4);
		
		Paragraph heading4 = new Paragraph();
		heading4.add(new Chunk("Consent Order No.: "+fileNumberIn,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		heading4.setAlignment(Element.ALIGN_LEFT);
		document.add(heading4);
		
		document.add(space4);
		
		
		if(applFor.equals("NEW")){
			applFor="Fresh";
		}
		
		Paragraph paraA = new Paragraph();
		paraA.add(new Chunk("Consent to Operate " ,	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraA.add(new Chunk("("+applFor+")" ,	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));

		paraA.setAlignment(Element.ALIGN_LEFT);
		document.add(paraA);
		document.add(space4);
		
		Paragraph paraB = new Paragraph();
		paraB.add(new Chunk(". Under Section 25/26 of the Water(Prevention & Control Pollution)Act, 1974, as amended.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraB.setAlignment(Element.ALIGN_LEFT);
		document.add(paraB);
		document.add(space4);
		
		
			
		Paragraph paraD = new Paragraph();
		paraD.add(new Chunk(". Under Section 21 of the Air(Prevention & Control of Pollution)Act, 1981, as amended",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraD.setAlignment(Element.ALIGN_LEFT);
		document.add(paraD);
		document.add(space4);
		
		Paragraph paraE = new Paragraph();
		paraE.add(new Chunk("Name of the unit holder with address: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraE.add(new Chunk(occName+","+occAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		
		paraE.setAlignment(Element.ALIGN_LEFT);
		document.add(paraE);
		document.add(space4);
		
		Paragraph paraF = new Paragraph();
		paraF.add(new Chunk("Consent is granted to: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraF.add(new Chunk(indusName ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraF.add(new Chunk("\n Address:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
	
		paraF.add(new Chunk(indAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraF.add(new Chunk("\n City: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraF.add(new Chunk(indCity,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraF.add(new Chunk( "\n Pin: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraF.add(new Chunk(indPin,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
	
		
		paraF.add(new Chunk("\n Tehsil: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraF.add(new Chunk(tehsil1,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraF.add(new Chunk(" \n District: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		
		paraF.add(new Chunk(district,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		paraF.setAlignment(Element.ALIGN_LEFT);
		document.add(paraF);
		document.add(space4);
		
		Paragraph paraG = new Paragraph();
		paraG.add(new Chunk("Located in the area declared under the provisions of the Water Act/Air Act, subject to the provisions of the Act and the Orders that may be made further and subject to the following terms and conditions:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraG.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraG);
		document.add(space4);
		
			
		Paragraph paraP1 = new Paragraph();
		paraP1.add(new Chunk("1. The Consent to Operate   ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
	
		paraP1.add(new Chunk("(" +applFor+ ")",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
	
		paraP1.add(new Chunk(" is granted for a period  .",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
	
		paraP1.add(new Chunk( startDate1+" - "+endDate1,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
	
		paraP1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP1);
		document.add(space4);
		
		
		Paragraph paraP2 = new Paragraph();
		paraP2.add(new Chunk("2.The Consent granted by the Board is restricted to Prevention and Control of Pollution only and shall not be treated as substitute of permission required under other laws of the land.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP2.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP2);
		document.add(space4);
		
		Paragraph paraP3 = new Paragraph();
		paraP3.add(new Chunk("3. Category of the unit as per UCM Guidelines: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP3.add(new Chunk(category,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		paraP3.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP3);
		document.add(space4);
		
		Paragraph paraP4 = new Paragraph();
		paraP4.add(new Chunk("4. The Consent is valid for the manufacture of the following products/by-products with capital investment(Land, Plant and machinery) of : "+indNewCapInvt,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP4.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP4);
		document.add(space4);
		
		Paragraph paraP5 = new Paragraph();
		paraP5.add(new Chunk("5. The unit is registered with DIC vide registration No: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP5.add(new Chunk(regId ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		paraP5.add(new Chunk(" date: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP5.add(new Chunk(regDate,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		
		paraP5.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP5);
		document.add(space4);
		
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidthPercentage(100);
		PdfPCell cell1 = new PdfPCell();
		
		
			
							cell1 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
				cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1.setVerticalAlignment(Element.ALIGN_LEFT);
					cell1.setPadding(3.0f);
					//cell1.setBorder(PdfPCell.NO_BORDER);
					cell1.setBorderColor(new Color(0, 0, 0));
					table1.addCell(cell1);
					
		
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Products/BY-Products Name", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1.setPadding(3.0f);
		//cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1.setPadding(3.0f);
		//cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		table1.addCell(cell1);
		
		cell1 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setVerticalAlignment(Element.ALIGN_LEFT);
		cell1.setPadding(3.0f);
		//cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setBorderColor(new Color(0, 0, 0));
		
		table1.addCell(cell1);
		
		
		for(int var2=0;var2<productDetailsList1.size();var2++)
		{
			ArrayList al=(ArrayList) productDetailsList1.get(var2);
		
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell1 = new PdfPCell (new Paragraph(a));
				//cell.setColspan (2);
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell.setBackgroundColor (new Color (128, 200, 128));
				cell1.setPadding (5.0f);
			//	cell1.setBorder(PdfPCell.NO_BORDER);
				table1.addCell (cell1);
				
			}
			}
		
		document.add(table1);
	
		
		document.add(space4);
		
		
		
		Paragraph paraP6 = new Paragraph();
		paraP6.add(new Chunk("Conditions under Water Act:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP6.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP6);
		document.add(space4);
		
		Paragraph paraP7 = new Paragraph();
		paraP7.add(new Chunk("(i) The daily quantity of trade effluent from the unit shall not exceed the permissible quantity approved.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP7.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP7);
		document.add(space4);
		
		
		Paragraph paraP8 = new Paragraph();
		paraP8.add(new Chunk("(ii) The daily quantity of sewage effluent from the unit shall not exceed the permissible quantity approved.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP8.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP8);
		document.add(space4);
		
						
		Paragraph paraP10 = new Paragraph();
		paraP10.add(new Chunk("(iii) The daily quantity of water consumption shall not exceed ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		paraP10.add(new Chunk(maxQuantity,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		
		
		paraP10.add(new Chunk(" KLD.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		
		
		paraP10.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP10);
		document.add(space4);
		
		
		Paragraph paraP11 = new Paragraph();
		paraP11.add(new Chunk("Treatment: The application has to operate and maintain a comprehensive treatment system consisting of Primary/Secondary and/ or Tertiary treatment as is warranted with reference to influent quality and operate and maintain the same continuously so as to achieve the quality of the treated effluent to the following standards before disposal.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP11.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP11);
		document.add(space4);
		
		PdfPTable table2 = new PdfPTable(3);
		table2.setWidthPercentage(100);
		PdfPCell cell111 = new PdfPCell();
		
		
//		cell111 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell111.setPadding(3.0f);
//		//cell111.setBorder(PdfPCell.NO_BORDER);
//		cell111.setBorderColor(new Color(0, 0, 0));
//		table2.addCell(cell111);
		
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Quality Parameter", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		//cell111.setBorder(PdfPCell.NO_BORDER);
		cell111.setBorderColor(new Color(0, 0, 0));
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		//cell111.setBorder(PdfPCell.NO_BORDER);
		cell111.setBorderColor(new Color(0, 0, 0));
		table2.addCell(cell111);
		
		cell111 = new PdfPCell(new Paragraph(new Chunk("Standard Value (in mg/l)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell111.setVerticalAlignment(Element.ALIGN_LEFT);
		cell111.setPadding(3.0f);
		//cell111.setBorder(PdfPCell.NO_BORDER);
		cell111.setBorderColor(new Color(0, 0, 0));
		table2.addCell(cell111);
		
		for(int var2=0;var2<qualityParameterDetailsList1.size();var2++)
		{
		ArrayList al=(ArrayList) qualityParameterDetailsList1.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{

		String a=(String) al.get(var3);
		
		cell111 = new PdfPCell (new Paragraph(a));
		cell111.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell111.setPadding (5.0f);
	//	cell111.setBorder(PdfPCell.NO_BORDER);
		table2.addCell (cell111);

		}
		}

	
		document.add(table2);

		document.add(space4);
		
		Paragraph paraP12 = new Paragraph();
		paraP12.add(new Chunk("(iv) Trade Effluent Disposal Outlet Conditions:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP12.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP12);
		
		
		
		Paragraph paraP13 = new Paragraph();
		paraP13.add(new Chunk("The unit holder must ensure the safe disposal of effluent by adopting the Pollution Control measures and installation of required pollution control devices as per the water(Prevention & Control of Pollution)Act, 1974 and amendments made thereafter.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP13.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP13);
		document.add(space4);
		
		
		Paragraph paraP15 = new Paragraph();
		paraP15.add(new Chunk("(v) Sewage treatment:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP15.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP15);
		document.add(space4);
		
		Paragraph paraP16 = new Paragraph();
		paraP16.add(new Chunk("The applicant has to install a comprehensive treatment system as is warranted with reference to effluent quality and operate and maintain the same continously so as to achieve the quality of treated effluent to the following standards before disposal:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP16.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP16);
		document.add(space4);
		
		PdfPTable table221 = new PdfPTable(3);
		table221.setWidthPercentage(100);
		PdfPCell cell11191 = new PdfPCell();
		
//		cell11191 = new PdfPCell(new Paragraph(new Chunk("SNo. ", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell11191.setPadding(3.0f);
//	//	cell11191.setBorder(PdfPCell.NO_BORDER);
//		cell11191.setBorderColor(new Color(0, 0, 0));
//		table221.addCell(cell11191);
//		
//		
		cell11191 = new PdfPCell(new Paragraph(new Chunk("Quality Parameter", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11191.setPadding(3.0f);
		//cell11191.setBorder(PdfPCell.NO_BORDER);
		cell11191.setBorderColor(new Color(0, 0, 0));
		table221.addCell(cell11191);
		
		
		cell11191 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11191.setPadding(3.0f);
		//cell11191.setBorder(PdfPCell.NO_BORDER);
		cell11191.setBorderColor(new Color(0, 0, 0));
		table221.addCell(cell11191);
		
		
		cell11191 = new PdfPCell(new Paragraph(new Chunk("Standard Value (in mg/l)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell11191.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11191.setVerticalAlignment(Element.ALIGN_LEFT);
		cell11191.setPadding(3.0f);
		//cell11191.setBorder(PdfPCell.NO_BORDER);
		cell11191.setBorderColor(new Color(0, 0, 0));
		table221.addCell(cell11191);
		

		for(int var2=0;var2<qualityParameterDetailsList2.size();var2++)
		{
			ArrayList al=(ArrayList) qualityParameterDetailsList2.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell11191 = new PdfPCell (new Paragraph(a));
				cell11191.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell11191.setPadding (5.0f);
			//	cell11191.setBorder(PdfPCell.NO_BORDER);
				table221.addCell (cell11191);
				
			}
			}
		
		document.add(table221);
		
		Paragraph paraP17 = new Paragraph();
		paraP17.add(new Chunk("(vi) Sewage Disposal Outlet Conditions:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP17.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP17);
		
		
		
		Paragraph paraP18 = new Paragraph();
		paraP18.add(new Chunk("All the domestic waste water shall be collected in the Septic tank and soakage pit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP18.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP18);
		document.add(space4);
		
		
		Paragraph paraP19 = new Paragraph();
		paraP19.add(new Chunk("(vii) Non Hazardous Solid Waste:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP19.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP19);
		
		
		
		Paragraph paraP20 = new Paragraph();
		paraP20.add(new Chunk("The non-hazardous solid waste has to be handled and disposed as per the guidelines of municipal Solid Waste Rules, 2000.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP20.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP20);
		document.add(space4);
		
		
		Paragraph paraP21 = new Paragraph();
		paraP21.add(new Chunk("(viii) :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP21.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP21);
		
		
		Paragraph paraP22 = new Paragraph();
		paraP22.add(new Chunk("The unit shall comply with any  laid down or directions issued in due course by the Board from time to time under the provision of the Water(Prevention and Control)Act,  1974.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP22.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP22);
		document.add(space4);
		
		
		Paragraph paraP23 = new Paragraph();
		paraP23.add(new Chunk("Conditions under Air Act:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP23.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP23);
		
		
		Paragraph paraP24 = new Paragraph();
		paraP24.add(new Chunk("(I) The applicant has to operate stack(s) of the following specifications:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP24.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP24);
		document.add(space4);
		
		PdfPTable table3 = new PdfPTable(6);
		table3.setWidthPercentage(100);
		PdfPCell cell2 = new PdfPCell();
		
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Stack attached to", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Volume Nm^3/hr", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Height in mtr", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Top Diameter in mtrs", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		cell2 = new PdfPCell(new Paragraph(new Chunk("Velocity of gas emission m/sec", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2.setPadding(3.0f);
		//cell2.setBorder(PdfPCell.NO_BORDER);
		cell2.setBorderColor(new Color(0, 0, 0));
		table3.addCell(cell2);
		
		
		for(int var2=0;var2<stackDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) stackDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell2 = new PdfPCell (new Paragraph(a));
				cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell2.setPadding (5.0f);
				//cell2.setBorder(PdfPCell.NO_BORDER);
				table3.addCell (cell2);
				
			}
			}
		
		
		document.add(table3);
	document.add(space4);
		
		Paragraph paraP25 = new Paragraph();
		paraP25.add(new Chunk("(II) The applicant has to operate and maintain a comprehensive air pollution control system consisting of control equipment as detailed below to control the emissions continuosly so as to achieve the level of pollutants to the following standards:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP25.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP25);
		document.add(space4);
		
		
//		PdfPTable table4 = new PdfPTable(2);
//		table4.setWidthPercentage(100);
//		PdfPCell cell3 = new PdfPCell();
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("Pollution Control equipments & measures:-", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		
//		cell3 = new PdfPCell(new Paragraph(new Chunk("Bag house filter", new Font(
//				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
//		cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//		cell3.setVerticalAlignment(Element.ALIGN_LEFT);
//		cell3.setPadding(3.0f);
//		cell3.setBorder(PdfPCell.NO_BORDER);
//		cell3.setBorderColor(new Color(0, 0, 0));
//		table4.addCell(cell3);
//		
//		document.add(table4);
//		
		Paragraph paraP251 = new Paragraph();
		paraP251.add(new Chunk("Standards for emissions of Air pollution as per MOEF notification under EP Act 1986:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP251.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP251);
		document.add(space4);
		
		
		PdfPTable table5 = new PdfPTable(4);
		table5.setWidthPercentage(100);
		PdfPCell cell4 = new PdfPCell();
		
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("S No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("Quality Parameter", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("Range", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		
		cell4 = new PdfPCell(new Paragraph(new Chunk("Standard Value (in mg/Nm3)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell4.setVerticalAlignment(Element.ALIGN_LEFT);
		cell4.setPadding(3.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setBorderColor(new Color(0, 0, 0));
		table5.addCell(cell4);
		
		
		
		for(int var2=0;var2<airParameterQualityDetailsList1.size();var2++)
		{
		ArrayList al=(ArrayList) airParameterQualityDetailsList1.get(var2);
		for(int var3=0;var3<al.size();var3++)
		{

		String a=(String) al.get(var3);
		
		cell4 = new PdfPCell (new Paragraph(a));
		cell4.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell4.setPadding (5.0f);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		table5.addCell (cell4);

		}
		}


		document.add(table5);
	
		Paragraph paraP26 = new Paragraph();
		paraP26.add(new Chunk("(III) The applicant is consuming the following fuel",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP26.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP26);
		document.add(space4);
		
		PdfPTable table6 = new PdfPTable(4);
		table6.setWidthPercentage(100);
		PdfPCell cell5 = new PdfPCell();
		
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("S.No.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Type of fuel and consumption", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Maximum Quantity", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		cell5 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
		cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell5.setVerticalAlignment(Element.ALIGN_LEFT);
		cell5.setPadding(3.0f);
		//cell5.setBorder(PdfPCell.NO_BORDER);
		cell5.setBorderColor(new Color(0, 0, 0));
		table6.addCell(cell5);
		
		for(int var2=0;var2<fuelDetailsList.size();var2++)
		{
			ArrayList al=(ArrayList) fuelDetailsList.get(var2);
			for(int var3=0;var3<al.size();var3++)
			{
				
				String a=(String) al.get(var3);
				
				cell5 = new PdfPCell (new Paragraph(a));
				cell5.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell5.setPadding (5.0f);
				//cell5.setBorder(PdfPCell.NO_BORDER);
				table6.addCell (cell5);
				
			}
			}
		
		
		document.add(table6);
			
		
		Paragraph paraP27 = new Paragraph();
		paraP27.add(new Chunk("Other Conditions:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP27.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP27);
		document.add(space4);
				
		Paragraph paraP28 = new Paragraph();
		paraP28.add(new Chunk("(a) The entrepreneur shall ensure that no Air pollution problem or any nuisance is created in the area due to discharge of emissions from the unit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP28.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP28);
		document.add(space4);
		
		
		Paragraph paraP29 = new Paragraph();
		paraP29.add(new Chunk("(b) The unit shall not discharge any fugitive emissions from the unit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP29.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP29);
		document.add(space4);
		
		Paragraph paraP30 = new Paragraph();
		paraP30.add(new Chunk("(c) The entrepreneur shall comply with any other conditions laid down or directions issued in due course by the J&K Pollution Control Committee under the provisions of Air(Prevention and Control of Pollution)Act, 1981.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP30.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP30);
		document.add(space4);
		
		
		Paragraph paraP31 = new Paragraph();
		paraP31.add(new Chunk("Conditions for Noise Pollution:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP31.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP31);
		document.add(space4);
		
		Paragraph paraP32 = new Paragraph();
		paraP32.add(new Chunk("The entrepreneur shall take measures for control of noise from its own sources within the premises so as to maintain ambient air quality standards in respect of noise to less than 75 db(A) during day time and 70 db(A) during night. Daytime is reckoned in between 6am to 10pm and night time is 10pm to 6am. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP32.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP32);
		document.add(space4);
		
		Paragraph paraP33 = new Paragraph();
		paraP33.add(new Chunk("Self Monitoring Schedule:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP33.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP33);
		
		
		Paragraph paraP34 = new Paragraph();
		paraP34.add(new Chunk("Application shall get the samples of treated emissions analysed from the laboratory recognized by the SPCB/PCC/CPCB/MOEF, New Delhi and conform to the limits stipulated. Test report shall be sent to the Pollution Control Committee(Analysis frequency could be different foe various sources as may be specified by the Board/Committee). ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP34.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP34);
		document.add(space4);
		
		
		Paragraph paraP35 = new Paragraph();
		paraP35.add(new Chunk("The applicant shall comply with the additional conditions as stipulated below:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP35.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP35);
		
		
		Paragraph paraP36 = new Paragraph();
		paraP36.add(new Chunk("(i). The Consent is valid for the CTO  "+applFor+" of unit only. The unit holder can only maufacture products, at rate of production as mentioned in consent order. Any change in production capacity, process, raw materials, use etc. shall have to be intimated to the Board. For any enhancement of theabove, fresh consent has to be obtained from J & K Pollution Control Committee. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP36.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP36);
		document.add(space4);
		
		Paragraph paraP37 = new Paragraph();
		paraP37.add(new Chunk("(ii) Pollution Control Devices(ETP/ECD) as contemplated to achieve the quality of effluent emission within the tolerance limits prescribed, shall have to be operational during the course of production. The effluent/emission shall not contain constituents in excess of the tolerance limits as laid down by J&K Pollution Control Committee.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP37.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP37);
		document.add(space4);
		
		Paragraph paraP38 = new Paragraph();
		paraP38.add(new Chunk("(iii) The entrepreneur shall liable to pay compensation in case any damage is caused to the environmet.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP38.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP38);
		document.add(space4);
		
		Paragraph paraP39 = new Paragraph();
		paraP39.add(new Chunk("(iv) The entrepreneur shall abide by the directions of the Board which will be issued from time to time. Any infringent/violation or transgression of the statutory enactments of pollution control acts by the unit, shall be sufficient cause to prosecute the violator in conformity with relevant section of Air/Water Acts and Environment Protection Act in force.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP39.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP39);
		document.add(space4);
		
		Paragraph paraP40 = new Paragraph();
		paraP40.add(new Chunk("(vi) Any further construction/expansion/renovation/ in the unit premises shall be subject to the clearance from the J&K Pollution Control Committee.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP40.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP40);
		document.add(space4);
		
		Paragraph paraP41 = new Paragraph();
		paraP41.add(new Chunk("(vii) The entrepreneur shall provide adequate arrangement for fighting the accidental leakage/discharge of any air pollutant/gas/liquid from the vessel, machinery etc. which are likely to cause fire hazard including environmental pollution.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP41.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP41);
		document.add(space4);
		
		Paragraph paraP42 = new Paragraph();
		paraP42.add(new Chunk("(Viii) Good House keeping prctices shall be adopted by the entrprenuer.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP42.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP42);
		document.add(space4);
		
		Paragraph paraP43 = new Paragraph();
		paraP43.add(new Chunk("(ix) It shall be responsibility of the entrepreneur to ensure that there are so complaints from the surrounding areas due to pollution caused by the unit.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP43.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP43);
		document.add(space4);
		
		
		Paragraph paraP44 = new Paragraph();
		paraP44.add(new Chunk("(x) The entrepreneur will submit two self monitoring reports during the period of consent. First during first six months and second during last six months, to know the efficiency of pollution control devices installed.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP44.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP44);
		document.add(space4);
		
		Paragraph paraP45 = new Paragraph();
		paraP45.add(new Chunk("(xi) In case of violation of above mentioned conditions or any public complaint, the consent shall be withdrawn.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP45.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paraP45);
		document.add(space4);
		
		
		Paragraph paraP548 = new Paragraph();
		paraP548.add(new Chunk("General Conditions \n"+gCondition+"\n Specific Conditions \n"+sCondition,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP548.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP548);
		document.add(space4);
			
		document.newPage();
		
		Paragraph paraP46 = new Paragraph();
		paraP46.add(new Chunk("Asstt. Environment Engineer",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP46.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP46);
		document.add(space4);
		
		Paragraph paraP47 = new Paragraph();
		paraP47.add(new Chunk("Member Secretary \n" + officeAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
		paraP47.setAlignment(Element.ALIGN_RIGHT);
		document.add(paraP47);
		document.add(space4);
		
		
		Paragraph paraP48 = new Paragraph();
		paraP48.add(new Chunk("To",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP48.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP48);
		document.add(space4);
		
		Paragraph paraP49 = new Paragraph();
		 paraP49.add(new Chunk(indusName + "\n Address:"+indAddress+"\n City: "+indCity+"\n Pin: "+indPin+"\n Tehsil: "+tehsil1+" \n District: "+ district,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		 paraP49.setAlignment(Element.ALIGN_LEFT);
		document.add( paraP49);
		document.add(space4);
		
		Paragraph paraP50 = new Paragraph();
		paraP50.add(new Chunk("Copy to the:  \n"+copyTo,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
		paraP50.setAlignment(Element.ALIGN_LEFT);
		document.add(paraP50);
		document.add(space4);
		
		
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		document.add(space4);
		
		
		
		Paragraph paraP55 = new Paragraph();
		 paraP55.add(new Chunk("Jammu Address: Parivesh Bhawan, Gladni Transport Nagar,(Narwal), Jammu(ph, 2476925, 26,27)\n Srinagar Address: Sheikh-ul-Alam Campus, Raj Bagh, Behind Govt. Silk Factory, Srinagar(Kashmir)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -3, Font.NORMAL)));
		 paraP55.setAlignment(Element.ALIGN_LEFT);
		 document.add(paraP55);

				

			Paragraph subHeading2 = new Paragraph();
			subHeading2.add(new Chunk("**This is computer generated receipt**", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2 , Font.BOLD)));
			subHeading2.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading2);
			
			
			
		document.close();
		return tempFile;
		
		
	}
		
	}

}
