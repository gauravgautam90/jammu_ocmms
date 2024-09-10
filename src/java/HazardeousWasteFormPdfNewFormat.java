import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class HazardeousWasteFormPdfNewFormat {
	public  File appFormHWM(String applicantName,String applicantDesignation,String factoryPostalAddress,String districtOffice,String indName,String occupierName,String occupierDesignation,String occupierMobile,String occupierEmail,String isRenew,String authorizationRequiredFor,ArrayList<ArrayList<String>> hwPreviousAuthDetails,ArrayList<ArrayList<String>> hazardousWasteDetailsList,String yearOfCommencement,String industrywork,
			String isGeneratorHWA, String prodManufactured,
			String prodsManufactured, String genWastes, String isTSDFOper,
			String generatedWast, String strgeCapacity, String trtmntProcesses,
			String secdLandfills, String detailOfIncine, String trtmntSystem,
			String fireFightSystems, String environmentalMgtPlan,
			String transp, String otherActvs, String isRecyclerOrUsr,
			String securedStrge, String endUsrs, String pollutionContrlSys,
			String saftyMeasures, String complianceWithLines,
			String transportationUsrs,
			ArrayList<ArrayList<String>> hwmCharachterDetails,
			ArrayList<ArrayList<String>> recyclableHazardousWasteHWMList,
			String copyErp, String underTaking, String manufacture, String layoutMapA,
			String copyPrior, String furnishInstall, String processDescription, String safeGuardDetails	
			,String facilitySet,String detailsPollution,String detailsEnd,String detailSecured,String detailOther,String renewal
	)
	{
		File tempFile = new File("HWM.pdf");
		
    try{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		Phrase headerPhrase = new Phrase("");
		HeaderFooter header = new HeaderFooter(headerPhrase, true);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(header);

		Phrase footerPhrase = new Phrase(
				"----This is computer generated application ---- \n http://jkocmms.nic.in/ - (JKSPCB)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2));
		HeaderFooter footer = new HeaderFooter(footerPhrase, false);

		footer.setAlignment(HeaderFooter.ALIGN_CENTER);
		footer.setBorder(Rectangle.NO_BORDER);
		document.setFooter(footer);

		document.open();

		Image image = Image.getInstance("images2/JHK_Logo.jpg");
		image.scalePercent(40.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);

		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ",
				new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD)));
		space.setAlignment(Element.ALIGN_CENTER);
		document.add(space);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("Jammu & Kashmir Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		
		document.add(space);
		
		heading = new Paragraph();
		heading.add(new Chunk("FORM 1", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		
		heading = new Paragraph();
		heading.add(new Chunk("[See Rules 6(1)]", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Application Required For Grant/Renewal Of Authorisation For Generation Or Collection Or Storage Or Transport Or Reception Or Recycling Or Reuse Or Recovery Or Pre Processing Or Co- Processing Or Utilisation Or Treatment Or Disposal Of Hazardous And Other Waste",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);

		document.add(space);

		/*heading = new Paragraph();
		heading.add(new Chunk("From", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk(applicantName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk(applicantDesignation, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk(factoryPostalAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("To", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading.add(new Chunk(
				"Member Secretary,\n Jharkhand State Pollution Control Committee,",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		// heading= new Paragraph();
		// heading.add(new Chunk(districtOffice+"(District Office).", new
		// Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		// heading.setAlignment(Element.ALIGN_LEFT);
		// document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading.add(new Chunk("Sir", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"      I/We hereby apply for authorisation/renewal of authorisation under the Sub-rule (1) of Rule 6 of the Hazardous and Other Wastes (Management and Transboundary Movement) Rules, 2016.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
*/
		
		heading = new Paragraph();
		heading.add(new Chunk("Part A: General(to be filled by all)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table = new PdfPTable(3);
		float[] columnWidths = new float[] { 1f, 10f, 8f };
		table.setWidths(columnWidths);
		table.setWidthPercentage(100);

		heading = new Paragraph("1. (a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Name and address of the unit and location of facility:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(indName + "\n" + factoryPostalAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("(b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Name of the Occupier of the facility or operator of disposal facility with designation,Tel,Fax and e-mail:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(occupierName+"/"+occupierDesignation+"/"+occupierMobile+"/"+occupierEmail, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

	

		heading = new Paragraph("(c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph("Authorisation required for(Please tick mark appropriate activity or activities:) ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(authorizationRequiredFor, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		
		heading = new Paragraph("(d)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph("In case of renewal of authorization previous authorization numbers and dates and provide copies of annual returns of last three including the compliance reports with respect to the conditions of Prior Environmental Clearance, wherever applicable:) ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(renewal, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);
		// starts===========nested table for hwa previous authorisation
		// order====
		if (isRenew.equals("Renew") && hwPreviousAuthDetails.size() > 0) {

			heading = new Paragraph("h)", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE));
			cell = new PdfPCell(heading);
			cell.setPadding(3.0f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			heading = new Paragraph(
					"In case of renewal of authorization, provide previous authorization number, Issue Date, Valid date ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
			cell = new PdfPCell(heading);
			cell.setPadding(3.0f);
			cell.setColspan(2);
			table.addCell(cell);

			PdfPTable nestedTable = new PdfPTable(5);
			cell = new PdfPCell();
			float[] columnWidthscc = new float[] { 3f, 3f, 3f, 3f, 3f };
			nestedTable.setWidths(columnWidthscc);
			nestedTable.setWidthPercentage(100);

			cell = new PdfPCell(new Paragraph(new Chunk(
					"Date of Application for HWA", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(3.0f);
			nestedTable.addCell(cell);

			cell = new PdfPCell(new Paragraph(new Chunk("HWA Type",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(3.0f);
			nestedTable.addCell(cell);

			cell = new PdfPCell(new Paragraph(new Chunk("Authorisation No",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(3.0f);
			nestedTable.addCell(cell);

			cell = new PdfPCell(new Paragraph(new Chunk("Issued date",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(3.0f);
			nestedTable.addCell(cell);

			cell = new PdfPCell(new Paragraph(new Chunk("Valid date",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(3.0f);
			nestedTable.addCell(cell);

			for (int var21 = 0; var21 < hwPreviousAuthDetails.size(); var21++) {
				ArrayList<String> al = hwPreviousAuthDetails.get(var21);
				for (int var31 = 0; var31 < al.size(); var31++) {
					String a = al.get(var31);
					Paragraph paragraph = new Paragraph(
							new Chunk(a, new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE - 1)));
					cell = new PdfPCell(paragraph);
					cell.setPadding(3.0f);
					nestedTable.addCell(cell);
				}
			}

			cell = new PdfPCell();
			cell.setPadding(3.0f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(heading);
			cell.addElement(nestedTable);
			cell.setPadding(3.0f);
			cell.setColspan(2);
			table.addCell(cell);
		}
		// ends===========nested table for hwa previous authorisation
		// order====

		heading = new Paragraph("2", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Nature and quantity of Hazardous waste handled in T/Annum (or) KL/Annum ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table.addCell(cell);

		// starts===========nested table for hwa waste details====

		PdfPTable nestedTable = new PdfPTable(10);
		cell = new PdfPCell();
		float[] columnWidthscc = new float[] { 4f, 3f, 3f, 3f, 3f, 3f, 3f,
				3f, 3f, 3f };
		nestedTable.setWidths(columnWidthscc);
		nestedTable.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk("Name of Process",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Name of Hazardous Waste (Category No)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Quantity", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Waste Type", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Waste Storage",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Waste Disposal",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Source of generation of waste", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Physical status ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Quantity stored at any time", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Quantity accumulated as on 31st March", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable.addCell(cell);

		for (int var21 = 0; var21 < hazardousWasteDetailsList.size(); var21++) {
			ArrayList<String> al = hazardousWasteDetailsList.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(new Chunk(a, new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable.addCell(cell);
			}
		}

		cell = new PdfPCell();
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		cell = new PdfPCell(heading);
		cell.addElement(nestedTable);
		cell.setPadding(3.0f);
		cell.setColspan(2);
		table.addCell(cell);

		// ends===========nested table for hwa waste details====

		heading = new Paragraph("3 a)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Year of commissioning and commencement of Production? ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(yearOfCommencement, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("  b)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Whether the industry works 1 shift/2 shifts/round the clock?",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(industrywork, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("4", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		String text = "Provide copy of the Emergency Response Plan (ERP) which should address procedures for dealing with emergency situations (viz. Spillage or release or fire) as specified in the guidelines of Central Pollution Control Committee. Such ERP shall comprise the following, but not limited to:  "
				+ "\n•	Containing and controlling incidents so as to minimise the effects and to limit danger to the persons, environment and property;"
				+ "\n•	Implementing the measures necessary to protect persons and the environment;"
				+ "\n•	Description of the actions which should be taken to control the conditions at events and to limit their consequences, including a description of the safety equipment and resources available;"
				+ "\n•	Arrangements for training staff in the duties  which they are expected to perform;"
				+ "\n•	Arrangements for informing concerned authorities and emergency services; and "
				+ "\n•	Arrangements for providing assistance with off-site mitigatory action."
				+ "\n(To be attached separately)";
		heading = new Paragraph(text, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(copyErp, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph("5", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);

		heading = new Paragraph(
				"Provide undertaking or declaration to comply with all provisions including the scope of submitting bank guarantee in the event of spillage, leakage or fire while handling the hazardous and other waste\n(To be attached separately)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		heading = new Paragraph(underTaking, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell = new PdfPCell(heading);
		cell.setPadding(3.0f);
		table.addCell(cell);

		document.add(table);
		document.add(space);
		document.add(space);

		

		
		
		heading = new Paragraph();
		heading.add(new Chunk("Part B: To be filled by hazardous waste generators", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table1 = new PdfPTable(3);
		float[] columnWidths1 = new float[] { 1f, 10f, 8f };
		table1.setWidths(columnWidths1);
		table1.setWidthPercentage(100);

	

		heading = new Paragraph("a", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell1 = new PdfPCell(heading);
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(cell1);

		heading = new Paragraph("Products and by-products manufactured (names and product wise quantity per annum): ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		table1.addCell(cell1);

		heading = new Paragraph(prodsManufactured, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		table1.addCell(cell1);

		heading = new Paragraph("b", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(cell1);

		heading = new Paragraph(
				"Process description including process flow sheet indicating Inputs and Outputs (raw materials, chemicals, products, by-products,wastes, emissions, wastewater etc.) Please attach separate sheets: )",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		table1.addCell(cell1);

		heading = new Paragraph(manufacture, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		table1.addCell(cell1);

		// //////////////////////////////////////////
		heading = new Paragraph("c)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(cell1);

		heading = new Paragraph(
				"Characterstics(waste-wise) and Quantic of waste generation per annum: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		table1.addCell(cell1);

		PdfPTable nestedTable115A = new PdfPTable(9);
		cell = new PdfPCell();
		float[] columnWidthscc158A = new float[] { 3f, 3f, 3f, 3f, 3f,
				4f, 4f, 4f, 4f };
		nestedTable115A.setWidths(columnWidthscc158A);
		nestedTable115A.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk("Schedule",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Name of Process",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Name of Hazardous Waste (Category No)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Quantity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Characterisitics of each waste", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(
				new Paragraph(
						new Chunk(
								"The details of utilization with in the plants such as Reuse/ Recycling/ Recovery/Reprocessing etc",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(
				new Paragraph(
						new Chunk(
								"If not utilised within the plant, provide details of what is done with this waste",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(
				new Paragraph(
						new Chunk(
								"Details of arrangements for transportation to actual users/ TSDF",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		cell = new PdfPCell(
				new Paragraph(
						new Chunk(
								"Details of the environmental safeguards and environmental facilities provided for safe handling ",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable115A.addCell(cell);

		for (int var211 = 0; var211 < hwmCharachterDetails.size(); var211++) {
			ArrayList<String> al = hwmCharachterDetails.get(var211);
			for (int var311 = 0; var311 < al.size(); var311++) {
				String a = al.get(var311);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable115A.addCell(cell);
			}
		}
		cell1 = new PdfPCell();
		cell1.setPadding(3.0f);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(cell1);

		cell1 = new PdfPCell(heading);
		cell1.addElement(nestedTable115A);
		cell1.setPadding(3.0f);
		cell1.setColspan(2);
		table1.addCell(cell1);

		// /////////////////////////////////////////

		
		heading = new Paragraph("d)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(cell1);

		heading = new Paragraph(
				"Hazardous and other wastes generated from storage of hazardous chemicals as defined under the Manufacture, Storage and Import of Hazardous Chemicals Rules, 1989.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		table1.addCell(cell1);

		heading = new Paragraph(genWastes, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell1 = new PdfPCell(heading);
		cell1.setPadding(3.0f);
		table1.addCell(cell1);
		
		
		
		document.add(table1);
		document.add(space);
		document.add(space);
		
		
		
		


		heading = new Paragraph();
		heading.add(new Chunk("Part C: To be filled by Treatment, storage and disposal facility operators", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table2 = new PdfPTable(3);
		float[] columnWidths2 = new float[] { 1f, 10f, 8f };
		table2.setWidths(columnWidths2);
		table2.setWidthPercentage(100);

		heading = new Paragraph("1 )", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell2 = new PdfPCell(heading);
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Provide details of the facility including: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setColspan(2);
		table2.addCell(cell2);

		heading = new Paragraph("i)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Location of site with layout map: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(prodManufactured, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("ii)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Safe storage of the waste and storage capacity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(strgeCapacity, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("iii)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"The treatment processes and their capacities ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(trtmntProcesses, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("iv)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Secured Landfills ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(secdLandfills, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("v)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Incineration, if any ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(detailOfIncine, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("vi)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Leachate Collection and Treatment System ", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(trtmntSystem, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("vii)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph("Fire Fighting Systems ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(fireFightSystems, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("viii)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				" Environmental management plan including monitoring ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(environmentalMgtPlan, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph("ix)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				" Arrangement for transportation of waste from generators ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(transp, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(" 2)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				" Provide details of Any other activities undertaken at the Treatment, storage and disposal facility site. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(detailOther, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);


		heading = new Paragraph("3)", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell2);

		heading = new Paragraph(
				"Attach a Copy of prior Environmental Clearance", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);

		heading = new Paragraph(copyPrior, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell2 = new PdfPCell(heading);
		cell2.setPadding(3.0f);
		table2.addCell(cell2);
		
		
		document.add(table2);
		document.add(space);
		document.add(space);
	
		


		
		heading = new Paragraph();
		heading.add(new Chunk("Part D: To be filled by recyclers or pre-processors or co-processors or users of hazardous or other wastes", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE,Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
	
		
		PdfPTable table3 = new PdfPTable(3);
		float[] columnWidths3 = new float[] { 1f, 10f, 8f };
		table3.setWidths(columnWidths3);
		table3.setWidthPercentage(100);


		heading = new Paragraph("1.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		PdfPCell cell3 = new PdfPCell(heading);
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Nature and quantity of different wastes received per annum from domestic sources or imported or both: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setColspan(2);
		table3.addCell(cell3);

		PdfPTable nestedTable11 = new PdfPTable(3);
		cell = new PdfPCell();
		float[] columnWidthscc1 = new float[] { 4f, 3f, 3f };
		nestedTable11.setWidths(columnWidthscc1);
		nestedTable11.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Hazardous Wastes Type", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11.addCell(cell);

		// cell = new PdfPCell(new Paragraph(new Chunk("Passbook Type",
		// new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-1))));
		// cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		// cell.setPadding(3.0f);
		// nestedTable11.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Quantity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Source (Domestic/Imported)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1))));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(3.0f);
		nestedTable11.addCell(cell);

		for (int var21 = 0; var21 < recyclableHazardousWasteHWMList
				.size(); var21++) {
			ArrayList<String> al = recyclableHazardousWasteHWMList
					.get(var21);
			for (int var31 = 0; var31 < al.size(); var31++) {
				String a = al.get(var31);
				Paragraph paragraph = new Paragraph(
						new Chunk(a, new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE - 1)));
				cell = new PdfPCell(paragraph);
				cell.setPadding(3.0f);
				nestedTable11.addCell(cell);
			}
		}

		cell3 = new PdfPCell();
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		cell3 = new PdfPCell(heading);
		cell3.addElement(nestedTable11);
		cell3.setPadding(3.0f);
		cell3.setColspan(2);
		table3.addCell(cell3);

		// ==

		heading = new Paragraph("2.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Installed capacity as per registration issued by the District Industries Centre or any other authorised Government agency. Provide copy:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(furnishInstall, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("3.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Provide details of secured storage of wastes including the storage capacity",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(detailSecured, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("4.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Process description including process flow sheet indicating equipment details, inputs and outputs (input wastes, chemicals, products, by-products, waste generated, emissions, waste water, etc.) Attach separate sheets:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(processDescription, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("5.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Provide details of end users of products or by-products",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(detailsEnd, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("6.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Provide details of pollution control systems such as Effluent Treatment Plant, scrubbers, etc. including mode of disposal of waste",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(detailsPollution, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("7.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Provide details of occupational health and safety measures",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(saftyMeasures, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("8.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Has the facility been set up as per Central Pollution Control Committee guidelines? If yes, provide a report on the compliance with the guidelines:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(complianceWithLines+"\n\n"+facilitySet, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph("9.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3.addCell(cell3);

		heading = new Paragraph(
				"Arrangements for transportation of waste to the facility",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);

		heading = new Paragraph(transportationUsrs, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE));
		cell3 = new PdfPCell(heading);
		cell3.setPadding(3.0f);
		table3.addCell(cell3);
		
		
		document.add(table3);
		document.add(space);
		document.add(space);
		
	
		
		table = new PdfPTable(2);
		table.setWidthPercentage(100);

		cell = new PdfPCell(new Paragraph(new Chunk("Place:", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPadding(3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk(
				"Signature of the Applicant", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE, Font.BOLD))));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setPadding(3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Date: ", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell.setPadding(3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph(new Chunk("Name and Designation",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
		cell.setPadding(3.0f);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);

		document.add(table);
		document.add(space);
		

		document.close();
	}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		return tempFile;
   }	
}
