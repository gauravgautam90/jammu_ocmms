
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class BioMedicalInspection
{ public File getDetails(String indName
		,String indAddress
		,String occName
		,String occPhone
		,String hcfName
		,String correspondenceAddress
		,String yearOfEstablishment
		,String monthofEstablishment
		,String hcfType
		,String hcfTypeMenu
		,String authorizationSought 
		,String authunderbiomed
		,String consentunderwateract
		 , String noOfyear
		 , String avgOccupancy
		 , String noOfBeds
		 , String ctectoStatus
		 , String authorizationFor 
		 , String annualReport
		 , String noOfPersoninBmw
		 , String sourceBioWasteGen
		 , String wasteGenQuantity
		 , String colorCodingBins
		 , String waterProofLabels
		 , String postersSegregation
		 , String intraRuralTrans
		 , String awayHCF
		 , String withinHCF
		 , String lightingAndVentilation
		 , String leachateProvided
		 , String accessRestricted
		 , String modeofDisposal
		 , String onSite
		 , String throughCBWTF
		 , String adequateOnSite
		 , String untreatedWaste
		 , String treatedWaste
		 , String trolleysProvided
		 , String plantProvided
		 , String incinerationQuant
		 , String autoclavingQuant
		 , String shreddingQuant
		 , String chemicaldisQuant
		 , String deepBurialQuant
		 , String sharpPit
		 , String othermodeTreatment
		 , String capacityofAutoclave
		 , String capacityofShredder
		 , String conditionsofAutoclave
		 , String trolleywastefeeding
		 , String recordingDeviceAttached
		 , String stripsporeTest
		 , String performanceofAutoclaving
		 , String workingofshredder
		 , String quantityofWater
		 , String quantityofWastewater
		 , String vehicleWashing
		 , String containerWashing
		 , String effluentTreatmentPlant
		 , String neutralization
		 , String smrConducted
		 , String reusedorRecycled
		 , String dischargethroughdrain
		 , String etpSludge 
		 , String plasticTreatment
		 , String treatedWasteSharps
		 , String mercurywastedisposal
		 , String outdatedCytotoxicDrugs
		 , String hyposolutiongenerated
		 , String segregationofwaste
		 , String wardsmaintains
		 , String CBMWTFoperator
		 , String firesafetymeasures
		 , String logbookOperation
		 , String awarenessprogrammes
		 , String statusWaste
		 , String officerRecom
		 , String officerRemark
		 , String officerName
		 , String officerDesignation
		 ,ArrayList feeList){
	File tempFile = new File("inspection.pdf");
	try{

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase headerPhrase = new Phrase("");
		HeaderFooter header = new HeaderFooter(headerPhrase, true);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(header);

		/*Phrase footerPhrase = new Phrase(
				"----This is computer generated application ---- \n https://upocmms.nic.in/ - (UPPCB)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2));
		HeaderFooter footer = new HeaderFooter(footerPhrase, false);

		footer.setAlignment(HeaderFooter.ALIGN_CENTER);
		footer.setBorder(Rectangle.NO_BORDER);
		document.setFooter(footer);
	*/
		document.open();
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.ALIGN_MIDDLE | Image.TEXTWRAP);
		document.add(image);

		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ",
				new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD)));
		space.setAlignment(Element.ALIGN_CENTER);
		document.add(space);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J&K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		
		document.add(space);
		
		
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Bio-Medical Waste Insepction Report",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		document.add(space);

		PdfPTable table = new PdfPTable(3);
		float[] columnWidths = new float[] { 1.5f, 10f, 8f };
		table.setWidths(columnWidths);
		table.setWidthPercentage(100);

		heading = new Paragraph("I. General Information:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD));
		PdfPCell cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD));
		//PdfPCell cell = new PdfPCell(heading);
		cell= new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Name & Address of the Health Care Facilities (HCFs)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph( indName+ "\n"+indAddress ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Correspondence address i.e. Contact Person & Telephone No.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("address:-"+correspondenceAddress+",  Contact Person: "+occName+",   Telephone No: "+occPhone, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);



		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph("Date, Month & Year of Establishment of HCF", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(monthofEstablishment+"/"+yearOfEstablishment, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		
		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph("Total no. of beds and average occupancy", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("beds:"+noOfBeds+",   occupancy:"+avgOccupancy, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		

		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Consent under Water Act, 1974&Air Act, 1981",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+consentunderwateract, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Authorization under Bio-medical Waste Management Rules, 2016",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(" "+authunderbiomed, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);


		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Period Applied for (validity upto)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+noOfyear+" Year", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("8.(a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Authorization Sought for",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+authorizationSought, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("8.(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Bedded / Non Bedded ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(hcfType+"/"+hcfTypeMenu, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		/*
		heading = new Paragraph("8.(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Bedded / Non Bedded Fee ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		*/
		heading = new Paragraph("8.(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Fresh/Renewal",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+authorizationFor, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("9.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Annual Report submitted for the preceding year",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+annualReport, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("10.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Staff involvement in BMW Management (no. of persons)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+noOfPersoninBmw, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		heading = new Paragraph(
				"II. Bio-medical Waste (Sources, Segregation, transportation and Temporary  Storage)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Sources of Biomedical Waste Generation ( indicate warddetails)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+sourceBioWasteGen, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Categories of  bio-medical waste generation and its quantity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+wasteGenQuantity, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Are specified color coding bins /containers and bags followed at source of generation of waste",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+colorCodingBins, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Are  water proof bio-hazard labels pasted on bins or containers used for segregation of bio-medical waste?",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+waterProofLabels, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Are posters regarding segregation of waste provided in wards?",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+postersSegregation, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Mode of intra-mural transportation of wastes within HCF and for transportation of waste from wards to the temporary waste storage area",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+intraRuralTrans, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Waste Storage area ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("Away from the HCF:			"+awayHCF+"\n"+"\n"+"Within the HCF:         "+withinHCF+"\n"+"\n"+"Provided with lighting and ventilation: 			"+lightingAndVentilation+"\n"+"\n"+"Leachate and wash water from waste storage area connected to ETP provided:		 "+leachateProvided, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("8.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Mode of disposal of BMW generated:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+modeofDisposal, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph(
				"III. Infrastructure for on-site treatment /disposal through CBMWTF",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Is Bio-medical waste treated  by on-site or through a Common Bio-medical Waste Treatment Facility (CBMWTF)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("On-site: "+onSite+"\n"+"\n"+"Through CBWTF: "+throughCBWTF, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Adequate On-site Treatment rooms provided (If applicable)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(" "+adequateOnSite, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Untreated waste storage room provided",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(" "+untreatedWaste, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		

		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Treated waste storage room provided",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(" "+treatedWaste , new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Is Washing room /platform for waste containers, trolleys or vehicles provided",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+trolleysProvided, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Effluent Treatment Plant provided",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+effluentTreatmentPlant, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph(
				"IV.   On-site Treatment of Bio-medical Waste by HCF : (If applicable)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Total quantity of bio-medical waste treated within HCF (in kg  per day)	",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("Incineration: 			"+incinerationQuant+"\n"+"Autoclaving: 			"+autoclavingQuant+"\n"+"Shredding:			"+shreddingQuant+"\n"+"Chemical Disinfection: "+chemicaldisQuant+"\n"+"DeepBurial: 		"+deepBurialQuant+"\n"+"Sharp pit: 			"+sharpPit+"\n"+"Any other mode of treatment/ND: 		"+othermodeTreatment, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph(
				"2. On-site Treatment Provision By Autoclaving/Microwavingand shredder(if applicable):",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
       heading = new Paragraph(
				"Capacity of autoclave/microwave",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+capacityofAutoclave, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Capacity of shredder ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+capacityofShredder, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Operating conditions of autoclave as observed during the visit",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+conditionsofAutoclave, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Provision made for the autoclave ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("Trolley for waste feeding: "+trolleywastefeeding +"\n"+"Graphic or computer recording device attached: "+recordingDeviceAttached, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Strip test / Spore test conducted regularly",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+stripsporeTest, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Performance of autoclaving by spore testing or routine test ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+performanceofAutoclaving, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
	
		
		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Working of  shredder",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+workingofshredder, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph(
				"3.  On-site Wastewater Treatment:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Quantity of Water Consumption ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+quantityofWater+" KL/Day", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Quantity of Waste water generation",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+quantityofWastewater+" KL/Day", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Dedicated vehicle and container washing facility  available",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+vehicleWashing, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		

		
		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"•	Effluent Treatment Plant provided for treatment of wastewater (enclose flow chart of ETP)"+"\n"+"(or)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+effluentTreatmentPlant, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("4.a", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"•	Any other provision (Neutralization)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"SMR conducted",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+smrConducted, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Final mode of disposal of treated wastewater",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("Reused or recycled :"+reusedorRecycled+"\n"+"Discharge through drain: "+dischargethroughdrain, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Is ETP sludge collection, storage& drying provision provided",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+etpSludge, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph(
				"4. Type of wastes generated and its final mode of disposal  :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Plastic wastes after treatment (if applicable)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+plasticTreatment, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Treated waste sharps/glass waste",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(" "+treatedWasteSharps, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Mercury waste disposal",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+mercurywastedisposal, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Outdated cytotoxic drugs",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+outdatedCytotoxicDrugs, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Hypo-solution generated from X-ray ward",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+hyposolutiongenerated, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph(
				"5. Check for the following :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD));
		heading.setAlignment(Element.ALIGN_CENTER);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		
		heading = new Paragraph("  (a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Segregation of waste practiced in accordance with BMWM Rules at the source of generation",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+segregationofwaste, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("  (b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Whether a record of waste generation as well as the person who collects BMW from wards maintains a register?",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+wardsmaintains, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("  (c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Does the CBMWTF operator collect waste daily or alternate day and whether the criterion of 48 hours is complied?(if applicable)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+CBMWTFoperator, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("  (d)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Fire safety measures adopted",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+firesafetymeasures, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		

		heading = new Paragraph("  (e)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Log book for operation of the treatment equipment/s is maintained as per BMW Rules?   ( if applicable)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+logbookOperation, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		

		heading = new Paragraph("  (f)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Whether awareness programmes conducted for the hospital staff/doctors w.r.t BMWMRules?",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+awarenessprogrammes, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		heading = new Paragraph("  (g)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Overall status of waste segregation, storage, treatment and its disposal ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(""+statusWaste, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		
		document.add(table);
		document.add(space);
		document.add(space);
	//-----------------------------------------------------------------------------------------------------------------//	
		table = new PdfPTable(2);
		table.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE, Font.BOLD))));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPadding(3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		table.addCell(cell);
		
		cell = new PdfPCell(new Paragraph(new Chunk(
				"Signature of the Inspecting Officer", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE, Font.BOLD))));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPadding(3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		table.addCell(cell);

		
		document.add(table);
		document.add(space);
		
		//-----------------------------------------------------------------------------------------------------------------//
		
		
		PdfPTable table5 = new PdfPTable(2);
		float[] columnWidths43 = new float[] { 3f, 10f};
		table5.setWidths(columnWidths43);
		table5.setWidthPercentage(100);


		heading = new Paragraph("Inspection Officer Recommendation", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell311 = new PdfPCell(heading);
		cell311 = new PdfPCell(heading);
		cell311.setPadding(3.0f);
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell311);

		heading = new Paragraph(""+officerRecom, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		
		cell311 = new PdfPCell(heading);
		cell311.setPadding(3.0f);
		cell311.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5.addCell(cell311);



		// ==

		document.add(table5);
		document.add(space);
		document.add(space);
		
//-----------------------------------------------------------------------------------------------------------------//
		Paragraph partCb1a17 = new Paragraph();
		partCb1a17.add(new Chunk("Details of the Bio-Medical authorization Fee Paid: "+ "" +
				"\nType of Authorization :- ",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		partCb1a17.setAlignment(Element.ALIGN_LEFT);
		document.add(partCb1a17);
		document.add(space);
		
		PdfPTable tableFees = new PdfPTable(7);
		PdfPCell cellFees = new PdfPCell();
		tableFees.setWidthPercentage(100);
		
		cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		cellFees.setColspan(2);
		tableFees.addCell(cellFees);

		cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		cellFees.setRowspan(2);
		tableFees.addCell(cellFees);

		cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		cellFees.setRowspan(2);
		tableFees.addCell(cellFees);

		cellFees = new PdfPCell(new Paragraph(new Chunk(
				"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		cellFees.setRowspan(2);
		tableFees.addCell(cellFees);

		cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		cellFees.setRowspan(2);
		tableFees.addCell(cellFees);

		cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		cellFees.setRowspan(2);
		tableFees.addCell(cellFees);
		
		cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		tableFees.addCell(cellFees);
		
		cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees.setPadding(5.0f);
		tableFees.addCell(cellFees);

		for (int var2 = 0; var2 < feeList.size(); var2++) {
			ArrayList feeList1 = (ArrayList) feeList.get(var2);

			for (int var3 = 0; var3 < feeList1.size(); var3++) {

				String feeInner = (String) feeList1.get(var3);
				cellFees = new PdfPCell(new Paragraph(feeInner));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);
			}}		
		document.add(tableFees);
		document.add(space);
		
		
		//--------------------------------------------------------------------------------------------------------------------//
		if(officerRemark!=null){
		PdfPTable table6 = new PdfPTable(2);
		float[] columnWidths493 = new float[] { 3f, 10f};
		table6.setWidths(columnWidths493);
		
		table6.setWidthPercentage(100);


		heading = new Paragraph("Officer Remark :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell2311 = new PdfPCell(heading);
		cell2311 = new PdfPCell(heading);
		cell2311.setPadding(3.0f);
		
		cell2311.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6.addCell(cell2311);

		heading = new Paragraph("Name and Designation", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		
		cell2311 = new PdfPCell(heading);
		
		cell2311.setPadding(3.0f);
		cell2311.setHorizontalAlignment(Element.ALIGN_LEFT);
		table6.addCell(cell2311);


		heading = new Paragraph(""+officerRemark, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		 
		cell2311 = new PdfPCell(heading);
		
		cell2311.setPadding(3.0f);
		cell2311.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6.addCell(cell2311);
		heading = new Paragraph(""+officerName+"      "+officerDesignation, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		
		cell2311 = new PdfPCell(heading);
		cell2311.setPadding(3.0f);
		cell2311.setHorizontalAlignment(Element.ALIGN_LEFT);
		table6.addCell(cell2311);


		// ==

		document.add(table6);
		document.add(space);
		document.add(space);
		}
		//-------------------------------------------------------------------------------------------------------------------//
		document.close();

	}
		
	catch (Exception e) {
		e.printStackTrace();
	}
	return tempFile;
}
/*public  static void main(String[]args){
	BioMedicalInspection b= new BioMedicalInspection();
	b.getDetails();
}*/
} 

