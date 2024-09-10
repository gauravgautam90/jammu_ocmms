import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class Rpdf4 {

	public File pdfGenerationS(String conditions,String emiRate,String pollEmitted,String emiSourceNumber,String equipmentStandard,String operationDate,String orderNumber,String ownerShipCh,String locationCh,String modification,String nowOperating,String proposed,String identificationNumber,String nameOperationProcess,String identificationArea,String locationInd,String latitude,String longitude,String indDistrict,String indCity,String finalPostalAddress,String consentIssuedTo)throws Exception{
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		//tempFile = File.createTempFile("certificate.pdf", ".tmp" );
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("Form VIII",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		
		Paragraph sub = new Paragraph();
		sub.add(new Chunk("See Rule 25",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		sub.setAlignment(Element.ALIGN_CENTER);
		document.add(sub);
		
		Paragraph r4 = new Paragraph();
		r4.add(new Chunk("R-4",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		r4.setAlignment(Element.ALIGN_RIGHT);
		document.add(r4);
		
		Paragraph lHead = new Paragraph();
		lHead.add(new Chunk("Under rule 25 the folowing shall be the form of the register to be maintained in respect of consents to be issued under section 21 of the Air (Prevention and Control of Pollution) Act, 1981.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		lHead.setAlignment(Element.ALIGN_LEFT);
		lHead.setFirstLineIndent(20);
		document.add(lHead);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);
		
		Paragraph general = new Paragraph();
		general.add(new Chunk("I. General :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		general.setAlignment(Element.ALIGN_LEFT);
		
		document.add(general);
		document.add(space12);
		Paragraph conIssued = new Paragraph();
		conIssued.add(new Chunk("(a) Consent is issued to :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		conIssued.add(new Chunk(consentIssuedTo,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		conIssued.setAlignment(Element.ALIGN_LEFT);
		
		document.add(conIssued);
		document.add(space12);
		Paragraph hCode = new Paragraph();
		hCode.add(new Chunk("(Corporation, Company, Govt, Agency, Firm etc)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		hCode.setAlignment(Element.ALIGN_LEFT);
		
		document.add(hCode);
		document.add(space12);
		Paragraph postAdd = new Paragraph();
		postAdd.add(new Chunk("(b) Postal Address :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		postAdd.add(new Chunk(finalPostalAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		postAdd.setAlignment(Element.ALIGN_LEFT);
		
		document.add(postAdd);
		document.add(space12);
		Paragraph locOfPlant = new Paragraph();
		locOfPlant.add(new Chunk("II. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		locOfPlant.add(new Chunk("Location of Plant or facilities (Latitude and Longitude must be to the nearest of 15 seconds):",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		locOfPlant.setAlignment(Element.ALIGN_LEFT);
		
		document.add(locOfPlant);
		document.add(space12);
		Paragraph ncity = new Paragraph();
		ncity.add(new Chunk("(a) Nearest City :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		ncity.add(new Chunk(indCity ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		ncity.add(new Chunk("   District:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		ncity.add(new Chunk(indDistrict,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		ncity.setAlignment(Element.ALIGN_LEFT);
		document.add(ncity);
		document.add(space12);
		Paragraph lonLat = new Paragraph();
		lonLat.add(new Chunk("(b) Latitude :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lonLat.add(new Chunk(latitude,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		lonLat.add(new Chunk("   Longitude :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lonLat.add(new Chunk(longitude,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		lonLat.setAlignment(Element.ALIGN_LEFT);
		document.add(lonLat);
		document.add(space12);
		Paragraph locatedAirPollution = new Paragraph();
		locatedAirPollution.add(new Chunk("(c) Is it located in air pollution control area :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		locatedAirPollution.add(new Chunk(locationInd,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		locatedAirPollution.setAlignment(Element.ALIGN_LEFT);
		
		document.add(locatedAirPollution);
		document.add(space12);
		
		Paragraph locatedAirPollutionIdentification = new Paragraph();
		locatedAirPollutionIdentification.add(new Chunk("    If yes, Identification of Air Pollution area :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		locatedAirPollutionIdentification.add(new Chunk(identificationArea,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		locatedAirPollutionIdentification.setAlignment(Element.ALIGN_LEFT);
		
		document.add(locatedAirPollutionIdentification);
		document.add(space12);
		
		Paragraph typeOperations = new Paragraph();
		typeOperations.add(new Chunk("III. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		typeOperations.add(new Chunk("Type Operation or process",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		typeOperations.setAlignment(Element.ALIGN_LEFT);
		document.add(typeOperations);
		document.add(space12);
		Paragraph nOperation = new Paragraph();
		nOperation.add(new Chunk("(a) Name of the operation process :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		nOperation.add(new Chunk(nameOperationProcess,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		nOperation.setAlignment(Element.ALIGN_LEFT);
		
		document.add(nOperation);
		document.add(space12);
		Paragraph identNo = new Paragraph();
		identNo.add(new Chunk("(b) Schedule identification number :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		identNo.add(new Chunk(identificationNumber,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		identNo.setAlignment(Element.ALIGN_LEFT);
		
		document.add(identNo);
		document.add(space12);
		Paragraph conClass = new Paragraph();
		conClass.add(new Chunk("IV. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		conClass.add(new Chunk("Consent Classification :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		conClass.setAlignment(Element.ALIGN_LEFT);
		document.add(conClass);
		document.add(space12);
		Paragraph prop = new Paragraph();
		
		prop.add(new Chunk("(a) Proposed :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		/*prop.add(new Chunk(proposed,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		prop.setAlignment(Element.ALIGN_LEFT);
		//document.add(prop);
		
		Paragraph propAns = new Paragraph();
		propAns.add(new Chunk(" : "+proposed,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		propAns.setAlignment(Element.ALIGN_LEFT);
		
		//document.add(space12);
		Paragraph operating = new Paragraph();
		
		operating.add(new Chunk("(b) Now Operating :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		/*operating.add(new Chunk(nowOperating,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		operating.setAlignment(Element.ALIGN_LEFT);
		//document.add(operating);
		
		Paragraph operatingAns = new Paragraph();
				
		/*operatingAns.add(new Chunk("(b) Now Operating :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		operatingAns.add(new Chunk(" : "+nowOperating,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		operatingAns.setAlignment(Element.ALIGN_LEFT);
	//	document.add(operatingAns);
		
		//document.add(space12);
		Paragraph mod = new Paragraph();
				
		mod.add(new Chunk("(c) Modification of the existing emission source :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*mod.add(new Chunk(modification,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		mod.setAlignment(Element.ALIGN_LEFT);
		//document.add(mod);
		Paragraph modAns = new Paragraph();
		
		/*modAns.add(new Chunk("(c) Modification of the existing emission source :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		modAns.add(new Chunk(" : "+modification,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		modAns.setAlignment(Element.ALIGN_LEFT);
		//document.add(space12);
		Paragraph locChange = new Paragraph();
		
		locChange.add(new Chunk("(d) Location Change :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*locChange.add(new Chunk(locationCh,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		locChange.setAlignment(Element.ALIGN_LEFT);
		//document.add(locChange);
		Paragraph locChangeAns = new Paragraph();
		
		/*locChangeAns.add(new Chunk("(d) Location Change :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		locChangeAns.add(new Chunk(" : "+locationCh,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		locChangeAns.setAlignment(Element.ALIGN_LEFT);
		//document.add(space12);
		Paragraph ownerChange = new Paragraph();
		
		ownerChange.add(new Chunk("(e) Ownership change :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*ownerChange.add(new Chunk(ownerShipCh,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		ownerChange.setAlignment(Element.ALIGN_LEFT);
		//document.add(ownerChange);
		Paragraph ownerChangeAns = new Paragraph();
				
		/*ownerChangeAns.add(new Chunk("(e) Ownership change :",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
						*/
		ownerChangeAns.add(new Chunk(" : "+ownerShipCh,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		ownerChangeAns.setAlignment(Element.ALIGN_LEFT);
		//document.add(space12);
		Paragraph pConsent = new Paragraph();
		
		pConsent.add(new Chunk("(f) Present Consent order Number if any :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*pConsent.add(new Chunk(orderNumber,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		pConsent.setAlignment(Element.ALIGN_LEFT);
		//document.add(pConsent);
		Paragraph pConsentAns = new Paragraph();
		
		/*pConsentAns.add(new Chunk("(f) Present Consent order Number if any :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		pConsentAns.add(new Chunk(" : "+orderNumber,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		pConsentAns.setAlignment(Element.ALIGN_LEFT);
		
		/// table /////
		
		PdfPTable table1=new PdfPTable(2);
		table1.setWidthPercentage(95);
		
		PdfPCell cell1 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		
		cell1 = new PdfPCell (prop);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		
		cell1 = new PdfPCell (propAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		
		cell1 = new PdfPCell (operating);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		
		cell1 = new PdfPCell (operatingAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (mod);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (modAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (locChange);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (locChangeAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (ownerChange);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (ownerChangeAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (pConsent);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (pConsentAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		document.add(table1);
		//////////////
		
		
		
		
		document.add(space12);
		Paragraph impDates = new Paragraph();
		impDates.add(new Chunk("V. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		impDates.add(new Chunk("Implementation Dates :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		impDates.setAlignment(Element.ALIGN_LEFT);
		document.add(impDates);
		document.add(space12);
		Paragraph proposedDate = new Paragraph();
		
		proposedDate.add(new Chunk("(a) In the case of proposed industries Operation to begin:",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		proposedDate.add(new Chunk(operationDate,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		proposedDate.setAlignment(Element.ALIGN_LEFT);
		document.add(proposedDate);
		document.add(space12);
		Paragraph standardAcheived  = new Paragraph();
		
		standardAcheived.add(new Chunk("(b) Air Pollution control equipment and emission to be installed standards achieved by : ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		standardAcheived.add(new Chunk(equipmentStandard,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		standardAcheived.setAlignment(Element.ALIGN_LEFT);
		document.add(standardAcheived);
		document.add(space12);
		Paragraph emiStand = new Paragraph();
		emiStand.add(new Chunk("VI. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		emiStand.add(new Chunk("Emission Standards :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		emiStand.setAlignment(Element.ALIGN_LEFT);
		document.add(emiStand);
		
		document.add(space12);
		PdfPTable table4=new PdfPTable(3);
		table4.setWidthPercentage(95);
		
		PdfPCell cell4 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell4 = new PdfPCell (new Paragraph (new Chunk("Emission Source Number (from plot plan)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (5.0f);
		table4.addCell (cell4);

		
		cell4 = new PdfPCell (new Paragraph (new Chunk("Air Pollutant emitted", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (5.0f);
		table4.addCell (cell4);
		
		cell4 = new PdfPCell (new Paragraph (new Chunk("Emission rate Kg/hour or Standard/Sec.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (5.0f);
		table4.addCell (cell4);
		
		
		
		
		cell4 = new PdfPCell (new Paragraph (new Chunk(emiSourceNumber, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (1.0f);
		table4.addCell (cell4);

		
		cell4 = new PdfPCell (new Paragraph (new Chunk(pollEmitted, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (1.0f);
		table4.addCell (cell4);
		
		cell4 = new PdfPCell (new Paragraph (new Chunk(emiRate, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (1.0f);
		table4.addCell (cell4);
		document.add(space12);
		document.add(table4);
		Paragraph consentCondition = new Paragraph();
		consentCondition.add(new Chunk("VII. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		consentCondition.add(new Chunk("Consent Conditions, if any :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		consentCondition.setAlignment(Element.ALIGN_LEFT);
		document.add(consentCondition);
		document.add(space12);
		Paragraph cCondition = new Paragraph();
		cCondition.add(new Chunk(conditions,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		cCondition.setAlignment(Element.ALIGN_LEFT);
		cCondition.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(cCondition);
		document.add(space12);document.add(space12);document.add(space12);
		document.close();
		return tempFile;
	}
	
	public File pdfGenerationArray(String conditions,String [] emiRateArray,String [] pollEmittedArray,String [] emiSourceNumberArray,String equipmentStandard,String operationDate,String orderNumber,String ownerShipCh,String locationCh,String modification,String nowOperating,String proposed,String identificationNumber,String nameOperationProcess,String identificationArea,String locationInd,String latitude,String longitude,String indDistrict,String indCity,String finalPostalAddress,String consentIssuedTo)throws Exception{
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		//tempFile = File.createTempFile("certificate.pdf", ".tmp" );
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("Form VIII",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		
		Paragraph sub = new Paragraph();
		sub.add(new Chunk("See Rule 25",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		sub.setAlignment(Element.ALIGN_CENTER);
		document.add(sub);
		
		Paragraph r4 = new Paragraph();
		r4.add(new Chunk("R-4",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		r4.setAlignment(Element.ALIGN_RIGHT);
		document.add(r4);
		
		Paragraph lHead = new Paragraph();
		lHead.add(new Chunk("Under rule 25 the folowing shall be the form of the register to be maintained in respect of consents to be issued under section 21 of the Air (Prevention and Control of Pollution) Act, 1981.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		lHead.setAlignment(Element.ALIGN_LEFT);
		lHead.setFirstLineIndent(20);
		document.add(lHead);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
		// Font.DEFAULTSIZE + 2, Font.BOLD)));
		document.add(space12);
		
		Paragraph general = new Paragraph();
		general.add(new Chunk("I. General :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		general.setAlignment(Element.ALIGN_LEFT);
		
		document.add(general);
		document.add(space12);
		Paragraph conIssued = new Paragraph();
		conIssued.add(new Chunk("(a) Consent is issued to :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		conIssued.add(new Chunk(consentIssuedTo,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		conIssued.setAlignment(Element.ALIGN_LEFT);
		
		document.add(conIssued);
		document.add(space12);
		Paragraph hCode = new Paragraph();
		hCode.add(new Chunk("(Corporation, Company, Govt, Agency, Firm etc)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		hCode.setAlignment(Element.ALIGN_LEFT);
		
		document.add(hCode);
		document.add(space12);
		Paragraph postAdd = new Paragraph();
		postAdd.add(new Chunk("(b) Postal Address :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		postAdd.add(new Chunk(finalPostalAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		postAdd.setAlignment(Element.ALIGN_LEFT);
		
		document.add(postAdd);
		document.add(space12);
		Paragraph locOfPlant = new Paragraph();
		locOfPlant.add(new Chunk("II. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		locOfPlant.add(new Chunk("Location of Plant or facilities (Latitude and Longitude must be to the nearest of 15 seconds):",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		locOfPlant.setAlignment(Element.ALIGN_LEFT);
		
		document.add(locOfPlant);
		document.add(space12);
		Paragraph ncity = new Paragraph();
		ncity.add(new Chunk("(a) Nearest City :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		ncity.add(new Chunk(indCity ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		ncity.add(new Chunk("   District:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		ncity.add(new Chunk(indDistrict,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		ncity.setAlignment(Element.ALIGN_LEFT);
		document.add(ncity);
		document.add(space12);
		Paragraph lonLat = new Paragraph();
		lonLat.add(new Chunk("(b) Latitude :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lonLat.add(new Chunk(latitude,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		lonLat.add(new Chunk("   Longitude :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		lonLat.add(new Chunk(longitude,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		lonLat.setAlignment(Element.ALIGN_LEFT);
		document.add(lonLat);
		document.add(space12);
		Paragraph locatedAirPollution = new Paragraph();
		locatedAirPollution.add(new Chunk("(c) Is it located in air pollution control area :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		locatedAirPollution.add(new Chunk(locationInd,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		locatedAirPollution.setAlignment(Element.ALIGN_LEFT);
		
		document.add(locatedAirPollution);
		document.add(space12);
		
		Paragraph locatedAirPollutionIdentification = new Paragraph();
		locatedAirPollutionIdentification.add(new Chunk("    If yes, Identification of Air Pollution area :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		locatedAirPollutionIdentification.add(new Chunk(identificationArea,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		locatedAirPollutionIdentification.setAlignment(Element.ALIGN_LEFT);
		
		document.add(locatedAirPollutionIdentification);
		document.add(space12);
		
		Paragraph typeOperations = new Paragraph();
		typeOperations.add(new Chunk("III. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		typeOperations.add(new Chunk("Type Operation or process",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		typeOperations.setAlignment(Element.ALIGN_LEFT);
		document.add(typeOperations);
		document.add(space12);
		Paragraph nOperation = new Paragraph();
		nOperation.add(new Chunk("(a) Name of the operation process :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		nOperation.add(new Chunk(nameOperationProcess,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		nOperation.setAlignment(Element.ALIGN_LEFT);
		
		document.add(nOperation);
		document.add(space12);
		Paragraph identNo = new Paragraph();
		identNo.add(new Chunk("(b) Schedule identification number :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		identNo.add(new Chunk(identificationNumber,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		identNo.setAlignment(Element.ALIGN_LEFT);
		
		document.add(identNo);
		document.add(space12);
		Paragraph conClass = new Paragraph();
		conClass.add(new Chunk("IV. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		conClass.add(new Chunk("Consent Classification :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		conClass.setAlignment(Element.ALIGN_LEFT);
		document.add(conClass);
		document.add(space12);
Paragraph prop = new Paragraph();
		
		prop.add(new Chunk("(a) Proposed :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		/*prop.add(new Chunk(proposed,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		prop.setAlignment(Element.ALIGN_LEFT);
		//document.add(prop);
		
		Paragraph propAns = new Paragraph();
		propAns.add(new Chunk(" : "+proposed,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		propAns.setAlignment(Element.ALIGN_LEFT);
		
		//document.add(space12);
		Paragraph operating = new Paragraph();
		
		operating.add(new Chunk("(b) Now Operating :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		/*operating.add(new Chunk(nowOperating,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		operating.setAlignment(Element.ALIGN_LEFT);
		//document.add(operating);
		
		Paragraph operatingAns = new Paragraph();
				
		/*operatingAns.add(new Chunk("(b) Now Operating :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		operatingAns.add(new Chunk(" : "+nowOperating,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		operatingAns.setAlignment(Element.ALIGN_LEFT);
	//	document.add(operatingAns);
		
		//document.add(space12);
		Paragraph mod = new Paragraph();
				
		mod.add(new Chunk("(c) Modification of the existing emission source :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*mod.add(new Chunk(modification,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		mod.setAlignment(Element.ALIGN_LEFT);
		//document.add(mod);
		Paragraph modAns = new Paragraph();
		
		/*modAns.add(new Chunk("(c) Modification of the existing emission source :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		modAns.add(new Chunk(" : "+modification,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		modAns.setAlignment(Element.ALIGN_LEFT);
		//document.add(space12);
		Paragraph locChange = new Paragraph();
		
		locChange.add(new Chunk("(d) Location Change :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*locChange.add(new Chunk(locationCh,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		locChange.setAlignment(Element.ALIGN_LEFT);
		//document.add(locChange);
		Paragraph locChangeAns = new Paragraph();
		
		/*locChangeAns.add(new Chunk("(d) Location Change :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		locChangeAns.add(new Chunk(" : "+locationCh,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		locChangeAns.setAlignment(Element.ALIGN_LEFT);
		//document.add(space12);
		Paragraph ownerChange = new Paragraph();
		
		ownerChange.add(new Chunk("(e) Ownership change :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*ownerChange.add(new Chunk(ownerShipCh,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		ownerChange.setAlignment(Element.ALIGN_LEFT);
		//document.add(ownerChange);
		Paragraph ownerChangeAns = new Paragraph();
				
		/*ownerChangeAns.add(new Chunk("(e) Ownership change :",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
						*/
		ownerChangeAns.add(new Chunk(" : "+ownerShipCh,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		ownerChangeAns.setAlignment(Element.ALIGN_LEFT);
		//document.add(space12);
		Paragraph pConsent = new Paragraph();
		
		pConsent.add(new Chunk("(f) Present Consent order Number if any :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		/*pConsent.add(new Chunk(orderNumber,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));*/
		pConsent.setAlignment(Element.ALIGN_LEFT);
		//document.add(pConsent);
		Paragraph pConsentAns = new Paragraph();
		
		/*pConsentAns.add(new Chunk("(f) Present Consent order Number if any :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				*/
		pConsentAns.add(new Chunk(" : "+orderNumber,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		pConsentAns.setAlignment(Element.ALIGN_LEFT);
		
		/// table /////
		
		PdfPTable table1=new PdfPTable(2);
		table1.setWidthPercentage(95);
		
		PdfPCell cell1 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell1 = new PdfPCell (prop);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (propAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (operating);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		
		
		
		cell1 = new PdfPCell (operatingAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);

		
		cell1 = new PdfPCell (mod);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (modAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (locChange);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (locChangeAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (ownerChange);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (ownerChangeAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (pConsent);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		cell1 = new PdfPCell (pConsentAns);
		cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell1.setBorder(PdfPCell.NO_BORDER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setPadding (5.0f);
		table1.addCell (cell1);
		
		document.add(table1);
		//////////////
		document.add(space12);
		Paragraph impDates = new Paragraph();
		impDates.add(new Chunk("V. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		impDates.add(new Chunk("Implementation Dates :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		impDates.setAlignment(Element.ALIGN_LEFT);
		document.add(impDates);
		document.add(space12);
		Paragraph proposedDate = new Paragraph();
		
		proposedDate.add(new Chunk("(a) In the case of proposed industries Operation to begin:",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		proposedDate.add(new Chunk(operationDate,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		proposedDate.setAlignment(Element.ALIGN_LEFT);
		document.add(proposedDate);
		document.add(space12);
		Paragraph standardAcheived  = new Paragraph();
		
		standardAcheived.add(new Chunk("(b) Air Pollution control equipment and emission to be installed standards achieved by : ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				
		standardAcheived.add(new Chunk(equipmentStandard,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		standardAcheived.setAlignment(Element.ALIGN_LEFT);
		document.add(standardAcheived);
		document.add(space12);
		Paragraph emiStand = new Paragraph();
		emiStand.add(new Chunk("VI. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		emiStand.add(new Chunk("Emission Standards :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		emiStand.setAlignment(Element.ALIGN_LEFT);
		document.add(emiStand);
		
		document.add(space12);
		PdfPTable table4=new PdfPTable(3);
		table4.setWidthPercentage(95);
		
		PdfPCell cell4 = new PdfPCell ();
		//cell.setColspan (2);
		////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		////cell.setBackgroundColor (new Color (128, 200, 128));
		////cell.setPadding (10.0f);
		//table.addCell (cell);

		cell4 = new PdfPCell (new Paragraph (new Chunk("Emission Source Number (from plot plan)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (5.0f);
		table4.addCell (cell4);

		
		cell4 = new PdfPCell (new Paragraph (new Chunk("Air Pollutant emitted", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (5.0f);
		table4.addCell (cell4);
		
		cell4 = new PdfPCell (new Paragraph (new Chunk("Emission rate Kg/hour or Standard/Sec.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE , Font.BOLD))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (5.0f);
		table4.addCell (cell4);
		
		
		for(int i=0;i<emiSourceNumberArray.length;i++){
		
		cell4 = new PdfPCell (new Paragraph (new Chunk(emiSourceNumberArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (1.0f);
		table4.addCell (cell4);

		
		cell4 = new PdfPCell (new Paragraph (new Chunk(pollEmittedArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE ))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (1.0f);
		table4.addCell (cell4);
		
		cell4 = new PdfPCell (new Paragraph (new Chunk(emiRateArray[i], new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
		cell4.setHorizontalAlignment (Element.ALIGN_CENTER);
		//cell4.setBorder(PdfPCell.NO_BORDER);
		cell4.setVerticalAlignment(Element.ALIGN_CENTER);
		cell4.setPadding (1.0f);
		table4.addCell (cell4);
		
		}
		document.add(space12);
		document.add(table4);
		Paragraph consentCondition = new Paragraph();
		consentCondition.add(new Chunk("VII. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		consentCondition.add(new Chunk("Consent Conditions, if any :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		consentCondition.setAlignment(Element.ALIGN_LEFT);
		document.add(consentCondition);
		document.add(space12);
		Paragraph cCondition = new Paragraph();
		cCondition.add(new Chunk(conditions,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		cCondition.setAlignment(Element.ALIGN_LEFT);
		document.add(cCondition);
		
		document.add(space12);document.add(space12);document.add(space12);
		document.close();
		
		return tempFile;
	}
	
}
