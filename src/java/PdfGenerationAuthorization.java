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

public class PdfGenerationAuthorization {
	private String applfor;

	
///////////////////////////////////////////////////////Authorization/////////////////////////////////////////////

public File pdfFunctionAuthorization(String indAddress,String draftDate,String occName,String occAddress,String applFor,String indusName,String endDate1,String category,
		String id,String dateCreated ,String indNewCapInvt,String gCondition,String sCondition,String copyTo,String fileNumberIn,String startDate1,
		String regId,String regDate,String indCity,String indPin,String tehsil1,String district,String applType,String maxQuantity,ArrayList productDetailsList1,
		ArrayList solidWasteDisposalDetailsList1,ArrayList stackDetailsList,String cntrlequipment,ArrayList fuelDetailsList,String industrytype12,
		String indCategory,String offDistrict,String currentYear,String endtNumberIn,String subject,
		String appID,String yearString,String issuingConsentTypeNo,String waterConsumption,String effluentGeneration,
		String authno,ArrayList PollutionControlList,String wasteWater,String capInvest,String waterConsume,
		String sewageEffluent,String indName,String indRegNum,String indRegDate,String specificConditionsforAuth,ArrayList hazardousWasteGenDetailsList) throws Exception {	
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
System.out.println("Here in pdf.pdfFunctionAuthorization.");
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
document.add(space4);

Paragraph heading15 = new Paragraph();
heading15.add(new Chunk("Authorization is granted under rule 6(2) of the Hazardous & Other Wastes" +
		"\n(Management & Transboundary Movement) Rules 2016",
		new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
heading15.setAlignment(Element.ALIGN_CENTER);
document.add(heading15);

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

cellB = new PdfPCell(new Paragraph(new Chunk("Number of Authorization:- PCC/digital/"+authno+yearString+issuingConsentTypeNo+appID+" of "+currentYear + " 				Date:- "+ draftDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("Sh. "+ occName + " of M/s "+ indName + " is hereby granted" +
		" an authorization based on the enclosed signed inspection " +
		"report for generation,collection, reception,storage or any other use of hazardous or other wastes or both on the premises situated at "+ indAddress , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("Details of Authorization", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
cellB.setHorizontalAlignment(Element.ALIGN_CENTER);
cellB.setPadding(3.0f);
cellB.setBorder(PdfPCell.NO_BORDER);
tableB.addCell(cellB);

PdfPTable table2 = new PdfPTable(4);
table2.setWidthPercentage(100);
float[] columnWidths3 = {1f,1f,1f,1f};
table2.setWidths(columnWidths3);
PdfPCell cell111 = new PdfPCell();

cell111 = new PdfPCell(new Paragraph(new Chunk("Authorization Required For", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
cell111.setVerticalAlignment(Element.ALIGN_LEFT);
cell111.setPadding(3.0f);
table2.addCell(cell111);

cell111 = new PdfPCell(new Paragraph(new Chunk("Source of Generation Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
cell111.setVerticalAlignment(Element.ALIGN_LEFT);
cell111.setPadding(3.0f);
table2.addCell(cell111);

/*cell111 = new PdfPCell(new Paragraph(new Chunk("Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
cell111.setVerticalAlignment(Element.ALIGN_LEFT);
cell111.setPadding(3.0f);
table2.addCell(cell111);*/

cell111 = new PdfPCell(new Paragraph(new Chunk("Category Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
cell111.setVerticalAlignment(Element.ALIGN_LEFT);
cell111.setPadding(3.0f);
table2.addCell(cell111);

cell111 = new PdfPCell(new Paragraph(new Chunk("Qunatity (per day in TPD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
cell111.setVerticalAlignment(Element.ALIGN_LEFT);
cell111.setPadding(3.0f);
table2.addCell(cell111);

for(int var2=0;var2<hazardousWasteGenDetailsList.size();var2++)
{
	ArrayList al=(ArrayList) hazardousWasteGenDetailsList.get(var2);
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

cellB = new PdfPCell(new Paragraph(new Chunk("(1) ", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
cellB.setPadding(3.0f);
cellB.setBorder(PdfPCell.NO_BORDER);
tableB.addCell(cellB);

cellB = new PdfPCell(new Paragraph(new Chunk("The authorization shall be valid for a period "+ maxQuantity, new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
cellB.setPadding(3.0f);
cellB.setBorder(PdfPCell.NO_BORDER);
tableB.addCell(cellB);

cellB = new PdfPCell(new Paragraph(new Chunk("(2) ", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
cellB.setPadding(3.0f);
cellB.setBorder(PdfPCell.NO_BORDER);
tableB.addCell(cellB);

cellB = new PdfPCell(new Paragraph(new Chunk("The authorization is subject to the following general & specific conditions:-", new Font(
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

cellB = new PdfPCell(new Paragraph(new Chunk("General Conditions of Authorization", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The authorized person shall comply with the provisions of the Environment " +
		"(Protection) Act, 1986, and the rules made there under.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
cellB.setPadding(3.0f);
cellB.setBorder(PdfPCell.NO_BORDER);
tableB.addCell(cellB);

cellB = new PdfPCell(new Paragraph(new Chunk("2. ", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
cellB.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
cellB.setPadding(3.0f);
cellB.setBorder(PdfPCell.NO_BORDER);
tableB.addCell(cellB);

cellB = new PdfPCell(new Paragraph(new Chunk("The authorization or its renewal shall be produced for inspection at the request of an Officer authorized by the Pollution Control Committee.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The person authorized shall not rent, lend, sell transfer or otherwise transport the hazardous and other wastes expect what is permitted through this authorization.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("Any unauthorized change in personnel equipment as working conditions as mentioned in the application " +
		"by the person authorized shall constitute a breach of his authorization", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The person authorized shall implement Emergency Response Procedure (ERP) for which this " +
		"authorization is being granted considering all site specific possible scenarios such as spillages, Leakages, fire etc. and their possible impacts and also carry out mock drill in this regard at regular interval of time. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The person authorized shall comply with the provisions outlines in the Central Pollution Control Committee guidelines on " +
		"'implementing Liabilities for Environmental Damages due to Handling and Disposal of Hazardous Waste and Penalty", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("It is the duty of the authorized person to take prior permission of the Pollution Control Committee to close down the facility.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The imported hazardous and other wastes shall be fully insured for transmit as well for any accidental occurence and its cleanup operation.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The record of consumption and fate of the imported hazardous and other wastes shall be maintained.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The hazardous and other waste which gets geenrated during recycling or reuse or recovery or pre-processing or " +
		"utilization of imported hazardous or other wastes shall be treated and disposed of as specific conditions of authorization.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The importer or exporter shall bear the cost of import or export and mitigation of damages, if any.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("An application for the renewal of an authorization shall be made as laid down under these Rules.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("The person authorized shall also comply with other conditions as per the Guidelines issued by the " +
		"Ministry of Environment, Forest and Climate Change or Central Pollution Control Committee from time to time.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cellB = new PdfPCell(new Paragraph(new Chunk("Annual return shall be filed by June, 30th for the period ensuring 31st March of the year.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
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
	cellB = new PdfPCell(new Paragraph(new Chunk(specificConditionsforAuth, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
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

cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
cell311.setVerticalAlignment(Element.ALIGN_CENTER);
cell311.setPadding(3.0f);
cell311.setBorder(PdfPCell.NO_BORDER);
table311.addCell(cell311);

/*if(indCategory.equals("ORANGE") || indCategory.equals("RED")){
	cell311 = new PdfPCell(new Paragraph(new Chunk("Environmental Engineer", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
}else{
    cell311 = new PdfPCell(new Paragraph(new Chunk("Member Secretary", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
}	
cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
cell311.setVerticalAlignment(Element.ALIGN_CENTER);
cell311.setPadding(3.0f);
cell311.setBorder(PdfPCell.NO_BORDER);
table311.addCell(cell311);*/

document.add(table311);
document.add(space4);

Paragraph paraP48 = new Paragraph();
paraP48.add(new Chunk("Copy to the :" +
		"\n		1. Regional Director J&K PCC "+ endtNumberIn +" for information" +
		"\n		2. General Manager DIC "+ cntrlequipment +" for information." +
		"\n		3. I/c D.O PCC "+ offDistrict +" with direction to monitor and to get compliance the conditions of Hazardous and Other Wastes " +
				"(Management and Transboundary Movement) Rules 2016, Dated: 4-4-2016" +
		"\n		4. P.A. to Chairman, J&K PCC for information of the Chairman" +
		"\n		5. Record file",
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
