import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class FormAir {

	public File formAirPdf(String generalShift,ArrayList pollInstall,String [] monitoring,String [] quality,String [] quantity,String [] reductionEff,String [] nameEquipment,String aboveFactHeight,String aboveGroundHeight,String materialConstruction,String naturaldraft,String licAnnualCap,String totEmployees,String appID, String dateOfSubmission,
			String industryName, String industryPlot, String industryAddress,
			String industryTehsil, String industryDistrict,
			String industryTelephone, String occupierName,
			String occupierDesignation, String occupierAddress,
			String occupierTehsil, String occupierDistrict,
			String occupierTelephone, String dateOfCommissioning,
			String capitalInvestment, ArrayList arrayListStack,
		   ArrayList fee,String nameAddressPartners,ArrayList productDetailsList,ArrayList plantEquipmentDetails,ArrayList plantQuantityDetails,ArrayList listDocuments,ArrayList stackMonitor,ArrayList reductionEfficieDetails ,ArrayList onlineFee) throws Exception {
		
			Document document = new Document(PageSize.A4);

			
			File tempFile = new File("FormAir.pdf");
			PdfWriter.getInstance(document, new FileOutputStream(tempFile));
			document.open();

			Paragraph heading = new Paragraph();
			heading.add(new Chunk("Form-1", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 6, Font.BOLD)));
			heading.setAlignment(Element.ALIGN_CENTER);
			document.add(heading);

			Paragraph space4 = new Paragraph();
			space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(space4);

			Paragraph rule = new Paragraph();
			rule.add(new Chunk("(See Rule 13)", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			rule.setAlignment(Element.ALIGN_CENTER);
			document.add(rule);

			document.add(space4);

			Paragraph subHeading = new Paragraph();
			subHeading
					.add(new Chunk("(To be Submitted in Duplicate)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
			subHeading.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading);

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

			Paragraph para = new Paragraph(
					"APPLICATION FOR CONSENT FOR EMISSION/CONTINUATION OF EMISSION UNDER SECTION 21 OF THE AIR(PREVENTION AND CONTROL OF POLLUTION)ACT, 1981 ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
			para.setFirstLineIndent(40);
			document.add(para);

			Paragraph space7 = new Paragraph();
			space7.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			space7.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(space7);

			Paragraph videNo = new Paragraph();

			// ch.setHorizontalScaling(20);
			videNo.add(new Chunk("From:", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));
			videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk("                        ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk("                          ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk("Date:", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			videNo.add(new Chunk(dateOfSubmission, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 2, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(videNo);

			Paragraph space20 = new Paragraph();
			space20.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			space20.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(space20);

			// Paragraph indName = new Paragraph(name);
			Paragraph indName = new Paragraph(industryName);
			indName.setExtraParagraphSpace(50.0f);
			indName.setIndentationLeft(20);
			document.add(indName);

			// Paragraph address = new Paragraph(address1);
			Paragraph address = new Paragraph(industryAddress);
			address.setExtraParagraphSpace(50.0f);
			address.setIndentationLeft(20);
			document.add(address);

			Paragraph tehsil = new Paragraph();
			// tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			tehsil.add(new Chunk(industryTehsil, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			tehsil.setIndentationLeft(20);
			document.add(tehsil);

			Paragraph district = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			district.add(new Chunk(industryDistrict, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			district.setIndentationLeft(20);
			document.add(district);

			Paragraph space24 = new Paragraph();
			space24.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			space24.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(space24);

			Paragraph toAddress = new Paragraph((new Chunk("To", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			toAddress.setAlignment(Element.ALIGN_LEFT);
			document.add(toAddress);

			Paragraph space34 = new Paragraph();
			space34.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			space34.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(space34);

			Paragraph memberS = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			memberS.add(new Chunk("Member Secretary,", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			memberS.setIndentationLeft(20);
			document.add(memberS);

			Paragraph member = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			member.add(new Chunk("Chhattisgarh Environment Conservation Committee",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			member.setIndentationLeft(20);
			document.add(member);

			Paragraph memberc = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			memberc.add(new Chunk("Raipur(C.G.)", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			memberc.setIndentationLeft(20);
			document.add(memberc);

			Paragraph space44 = new Paragraph();
			space44.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			space44.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			document.add(space44);

			Paragraph sir = new Paragraph();
			sir.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));
			sir.setAlignment(Element.ALIGN_LEFT);
			document.add(sir);

			Paragraph paraS = new Paragraph(
					"I/We hereby apply for Consent/Renewal of Consent under Section 21 of the Air (Prevention and Control of Pollution)Act, 1981 *No.14 of 1981) to bring in to use a new/altered 'Stack for the discharge of emission/to begin to make new Discharge of Emission/to Continue to Discharge Emission' from Stack in Industry Owned by "
							+ occupierName + " the relevant details are below:");
			paraS.setFirstLineIndent(40);
			paraS.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraS);

			document.add(space4);

			Paragraph fName = new Paragraph();
			fName
					.add(new Chunk(
							"1. Full name of Applicant,Designation with Address and Telephone No.:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			// fName.setExtraParagraphSpace(100.0f);
			document.add(fName);
			document.add(space4);

			Paragraph occNameAns = new Paragraph();
			occNameAns.add(new Chunk("    Name : ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));
			occNameAns.add(new Chunk(occupierName, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			occNameAns.setExtraParagraphSpace(100.0f);
			document.add(occNameAns);

			Paragraph occNameDes = new Paragraph();
			occNameDes.add(new Chunk("    Designation : ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			occNameDes.add(new Chunk(occupierDesignation, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			occNameDes.setExtraParagraphSpace(100.0f);
			document.add(occNameDes);

			Paragraph fNameAnsAdd = new Paragraph();
			fNameAnsAdd.add(new Chunk("    Address : ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			fNameAnsAdd.add(new Chunk(occupierAddress, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			fNameAnsAdd.setExtraParagraphSpace(100.0f);
			document.add(fNameAnsAdd);

			Paragraph fNameAnsT = new Paragraph();
			fNameAnsT.add(new Chunk("    " + occupierTehsil + "  "
					+ occupierDistrict, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(fNameAnsT);
			Paragraph fNameAnsTel = new Paragraph();
			fNameAnsTel.add(new Chunk("   " + occupierTelephone, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(fNameAnsTel);

			Paragraph partners = new Paragraph();
			partners.add(new Chunk("   " + nameAddressPartners, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(space4);

			Paragraph directorName = new Paragraph();
			directorName
					.add(new Chunk(
							"2. Name of Full Time Directors with Address and Telephone No.:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(directorName);
			document.add(space4);
			
			document.add(partners);
			
			document.add(space4);

			Paragraph facName = new Paragraph();
			facName
					.add(new Chunk(
							"3. Full Factory Address(with Name of Plot/Premises) and Telephone No.:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(facName);
			document.add(space4);
			Paragraph fNameAnsInd = new Paragraph();
			fNameAnsInd.add(new Chunk("    Name : ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));

			fNameAnsInd.add(new Chunk(industryName, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			fNameAnsInd.add(new Chunk("   Plot No : ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			fNameAnsInd.add(new Chunk(industryPlot, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(fNameAnsInd);

			Paragraph indNameAnsDirAdd = new Paragraph();
			indNameAnsDirAdd.add(new Chunk("    Address : ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			indNameAnsDirAdd.add(new Chunk(industryAddress, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			// fNameAnsDirAdd.setExtraParagraphSpace(100.0f);
			document.add(indNameAnsDirAdd);

			Paragraph indNameAnsTDir = new Paragraph();
			indNameAnsTDir.add(new Chunk("     " + industryTehsil + "  "
					+ industryDistrict, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(indNameAnsTDir);

			Paragraph indNameAnsTDirTel = new Paragraph();
			indNameAnsTDirTel.add(new Chunk("    " + industryTelephone,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(indNameAnsTDirTel);

			document.add(space4);

			Paragraph dtOfCommissioning = new Paragraph();
			dtOfCommissioning
					.add(new Chunk(
							"4. Date of Commissioning of Factory or Proposed Date of Commissioning of Factory:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(dtOfCommissioning);
			document.add(space4);
			Paragraph dtOfCommissioningAns = new Paragraph();
			dtOfCommissioningAns.add(new Chunk(" Year: " + dateOfCommissioning,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(dtOfCommissioningAns);

			document.add(space4);

			Paragraph capInvest = new Paragraph();
			capInvest.add(new Chunk(
					"5. Capital Investment Made (in Rs.): ", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(capInvest);
			document.add(space4);
			Paragraph capInvestAns = new Paragraph();
			capInvestAns.add(new Chunk("    Rs. " + capitalInvestment
					+ "  (in Lakhs)", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(capInvestAns);

			document.add(space4);
//
//			Paragraph capInvestNew = new Paragraph();
//			capInvestNew.add(new Chunk(
//					"Capital Investment of Plant & Machinery (in Rs.): ", new Font(
//							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
//			// directorName.setExtraParagraphSpace(100.0f);
//			document.add(capInvestNew);
//			document.add(space4);
//			Paragraph capInvestAnsNew = new Paragraph();
//			capInvestAnsNew.add(new Chunk("    Rs. " + capitalInvestment 
//					+ "  (in Lakhs)", new Font(Font.TIMES_ROMAN,
//					Font.DEFAULTSIZE)));
//			// relevant.setExtraParagraphSpace(100.0f);
//			document.add(capInvestAnsNew);
//
//			document.add(space4);

			Paragraph employeeNo = new Paragraph();
			employeeNo.add(new Chunk("6. Total No. of Employees:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(employeeNo);
			document.add(space4);
			Paragraph employeeNoAns = new Paragraph();
			employeeNoAns.add(new Chunk(" "+
					totEmployees,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(employeeNoAns);

			document.add(space4);

			Paragraph licenseAnnualCapacity = new Paragraph();
			licenseAnnualCapacity.add(new Chunk(
					"7. (A) Licensed Annual Capacity of the Factory ", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(licenseAnnualCapacity);
			document.add(space4);
			
////////////////////////////////////////////	Product Details	/////////////////////////////////
			
			Font font = new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD);


			PdfPTable table23=new PdfPTable(4);

			PdfPCell cell23 = new PdfPCell ();

			table23.setWidthPercentage(100);

			cell23 = new PdfPCell (new Paragraph("Product Name",font));
			//cell.setColspan (2);
			cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell23.setPadding (5.0f);
			cell23.setBorder(PdfPCell.NO_BORDER);
			table23.addCell (cell23);

			cell23 = new PdfPCell (new Paragraph("Capacity",font));
			//cell.setColspan (2);
			cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell23.setPadding (5.0f);
			cell23.setBorder(PdfPCell.NO_BORDER);
			table23.addCell (cell23);

			cell23 = new PdfPCell (new Paragraph("Unit",font));
			//cell.setColspan (2);
			cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell23.setPadding (5.0f);
			cell23.setBorder(PdfPCell.NO_BORDER);
			table23.addCell (cell23);

			cell23 = new PdfPCell (new Paragraph("By Product & Quantity",font));
			//cell.setColspan (2);
			cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell23.setPadding (5.0f);
			cell23.setBorder(PdfPCell.NO_BORDER);
			table23.addCell (cell23);

			for(int var2=0;var2<productDetailsList.size();var2++)
			{
				ArrayList al=(ArrayList) productDetailsList.get(var2);
				
				for(int var3=0;var3<al.size();var3++)
				{
					
					String a=(String) al.get(var3);
					
					cell23 = new PdfPCell (new Paragraph(a));
					//cell.setColspan (2);
					cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell.setBackgroundColor (new Color (128, 200, 128));
					cell23.setPadding (5.0f);
					cell23.setBorder(PdfPCell.NO_BORDER);
					table23.addCell (cell23);
					
				}
				}
			document.add(table23);

///////////////////////////////////////////			
			
			Chunk chunk1 = new Chunk(
					"   (B)  Attached a Brief Description of the Manufacturing Process Along with a Flow Diagram ",
					font);
			Chunk chunk2 = new Chunk(
					"         and the Position of Corresponding Stack on the Plot Plan:",
					font);

			Phrase p1 = new Phrase();
			p1.add(chunk1);
			p1.add("\n");
			p1.add(chunk2);
			// document.add(p1);

			document.add(space4);

			Paragraph manufacturingProcess = new Paragraph(p1);
		
			document.add(manufacturingProcess);
			document.add(space4);
			Paragraph manufacturingProcessAns = new Paragraph();
			manufacturingProcessAns.add(new Chunk(
					"As Attached",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// relevant.setExtraParagraphSpace(100.0f);
			document.add(manufacturingProcessAns);

			Chunk chunk11 = new Chunk(
					"8. State the Number of Boilers ,Heaters, Furnaces Installed in the Factory Along",
					font);
			Chunk chunk22 = new Chunk(
					"   with their Capacity, Type/Quantity of Fuel Used, and Emission From the Stacks:",
					font);

			Phrase p11 = new Phrase();
			p11.add(chunk11);
			p11.add("\n");
			p11.add(chunk22);
			// document.add(p1);

			document.add(space4);

			Paragraph boilersNumber = new Paragraph(p11);
			document.add(boilersNumber);
			document.add(space4);
			
/////////////////////////////////////// Start code Ashish //////////////
			
			PdfPTable table1 = new PdfPTable(5);

			PdfPCell cell1 = new PdfPCell();
			
			table1.setWidthPercentage(100);

			cell1 = new PdfPCell(new Paragraph("Plant Name", font));
			// cell.setColspan (2);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell1.setPadding(5.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph("Stack Height(In Meters)", font));
			// cell.setColspan (2);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell1.setPadding(5.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph("Capacity", font));
			// cell.setColspan (2);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell1.setPadding(5.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			table1.addCell(cell1);
			
			cell1 = new PdfPCell(new Paragraph("Unit", font));
			// cell.setColspan (2);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell1.setPadding(5.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph("Fuel Type & Consumption Quantity", font));
			// cell.setColspan (2);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell1.setPadding(5.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			table1.addCell(cell1);

//			cell1 = new PdfPCell(new Paragraph("Fuel Consumption", font));
//			// cell.setColspan (2);
//			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
//			// cell.setBackgroundColor (new Color (128, 200, 128));
//			cell1.setPadding(5.0f);
//			cell1.setBorder(PdfPCell.NO_BORDER);
//			table1.addCell(cell1);

			for (int var2 = 0; var2 < arrayListStack.size(); var2++) {
				ArrayList al = (ArrayList) arrayListStack.get(var2);
			
				for (int var3 = 0; var3 < al.size(); var3++) {
					
					if (var3 != 4) {
						String a = (String) al.get(var3);
						
						cell1 = new PdfPCell(new Paragraph(a));
						// cell.setColspan (2);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						// cell.setBackgroundColor (new Color (128, 200, 128));
						cell1.setPadding(5.0f);
						cell1.setBorder(PdfPCell.NO_BORDER);
						table1.addCell(cell1);
					} else {
						ArrayList al1 = (ArrayList) al.get(var3);
						String str1 = "";
						for (int var4 = 0; var4 < al1.size(); var4++) {
							String str = (String) al1.get(var4);
							str1 = str1 + str;
						}

						cell1 = new PdfPCell(new Paragraph(str1));
						// cell.setColspan (2);
						cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
						// cell.setBackgroundColor (new Color (128, 200, 128));
						cell1.setPadding(5.0f);
						cell1.setBorder(PdfPCell.NO_BORDER);
						table1.addCell(cell1);
					}
				}
			}
						
			document.add(table1);
			
////////////////////////////////////////// End Code Ashish ///////////////////////////
			
			Paragraph stackDetails = new Paragraph();
			stackDetails.add(new Chunk("9. Stack's Details:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			
			Paragraph ind = new Paragraph();
			ind.add(new Chunk("     a) Number of Stacks:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		
			Paragraph prop = new Paragraph();
			prop.add(new Chunk("     b) Natural Draft/ID Fan/FD Fan:",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			
			Paragraph partnership = new Paragraph();
			partnership.add(new Chunk(
					"     c) Material of Construction of Stack:", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			
			Paragraph joint = new Paragraph();
			joint.add(new Chunk("     d) Height of Stack:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			
			Paragraph priv = new Paragraph();
			priv.add(new Chunk("         i) Above Ground Level(In Meters):",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		
			Paragraph priv1 = new Paragraph();
			priv1.add(new Chunk("         ii) Above Factory Room(In Meters):", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(space4);

			PdfPTable table = new PdfPTable(2);

			PdfPCell cell = new PdfPCell();
			
			table.setWidthPercentage(100);

			cell = new PdfPCell(stackDetails);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(""));
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(ind);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph());
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(prop);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(naturaldraft));
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(partnership);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(materialConstruction));
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(joint);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph());
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(priv);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(aboveGroundHeight));
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(priv1);
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(aboveFactHeight));
			// cell.setColspan (2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			document.add(table);

			document.add(space4);
			Paragraph equipmentInf = new Paragraph();
			equipmentInf
					.add(new Chunk(
							"10. Attach Information on Air Pollution Control Equipment in Respect of each of the Stacks Listed in the Item 9 Above.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			// directorName.setExtraParagraphSpace(100.0f);
			document.add(equipmentInf);
			String nameOfEquip;
			
				 nameOfEquip="";
			
			
			for(int i=0;i<nameEquipment.length;i++){
				nameOfEquip=nameOfEquip+" , "+nameEquipment[i];
			}
			
			String efficiency;
			
			
				efficiency="";
			
			
			for(int i=0;i<reductionEff.length;i++){
				efficiency=efficiency+" , "+reductionEff[i];
			}
			
			String quantityL=" Quantity (Kg/D)[ "+quantity[0];
			
			for(int i=0;i<quantity.length;i++){
				quantityL=quantityL+" , "+quantity[i];
			}
			
			quantityL=quantityL+ " ] ";
			
			String qualityL=" Quality (mg/NCum)[ "+quality[0];
			
			for(int i=0;i<quantity.length;i++){
				qualityL=qualityL+" , "+quality[i];
			}
			
			qualityL=qualityL+" ]";
			
			String finalQuan_Qual=quantityL+ " , "+qualityL;
			
			String monitor=monitoring[0];
			
			
				monitor="";
			
			
			for(int i=0;i<monitoring.length;i++){
				monitor=monitor+" , "+monitoring[i];
			}
			
			Paragraph equipmentInfName = new Paragraph();
			equipmentInfName.add(new Chunk("     a) Name of the Equipment",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfName);
			document.add(space4);
//			Paragraph equipmentInfNameAns = new Paragraph();
//			equipmentInfNameAns
//					.add(new Chunk(nameOfEquip,
//							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE
//									)));
//			// relevant.setExtraParagraphSpace(100.0f);
//			document.add(equipmentInfNameAns);
			
			PdfPTable table2 = new PdfPTable(2);

			PdfPCell cell2 = new PdfPCell();
			
			table2.setWidthPercentage(100);

			cell2 = new PdfPCell(new Paragraph("Plant Name", font));
			// cell.setColspan (2);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell2.setPadding(5.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph("Control Equipment", font));
			// cell.setColspan (2);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell2.setPadding(5.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			table2.addCell(cell2);


			for(int var2=0;var2<plantEquipmentDetails.size();var2++)
			{
				ArrayList al=(ArrayList) plantEquipmentDetails.get(var2);
				
				for(int var3=0;var3<al.size();var3++)
				{
					
					String a=(String) al.get(var3);
					
					cell2 = new PdfPCell (new Paragraph(a));
					//cell.setColspan (2);
					cell2.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell.setBackgroundColor (new Color (128, 200, 128));
					cell2.setPadding (5.0f);
					cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
				}
				}
			document.add(table2);
			
			document.add(space4);

			Paragraph equipmentInfEP = new Paragraph();
			equipmentInfEP
					.add(new Chunk(
							"     b) Existing or Proposed and for Which Pollutant and Date of Installation:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfEP);
			document.add(space4);
			
			PdfPTable tablePoll = new PdfPTable(5);

			PdfPCell cellPoll = new PdfPCell();
			
			tablePoll.setWidthPercentage(100);


			cellPoll = new PdfPCell(new Paragraph("Plant Name", font));
			// cell.setColspan (2);
			cellPoll.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll.setPadding(5.0f);
			cellPoll.setBorder(PdfPCell.NO_BORDER);
			tablePoll.addCell(cellPoll);

			cellPoll = new PdfPCell(new Paragraph("Control Equipment", font));
			// cell.setColspan (2);
			cellPoll.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll.setPadding(5.0f);
			cellPoll.setBorder(PdfPCell.NO_BORDER);
			tablePoll.addCell(cellPoll);

			cellPoll = new PdfPCell(new Paragraph("Pollutant Name", font));
			// cell.setColspan (2);
			cellPoll.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll.setPadding(5.0f);
			cellPoll.setBorder(PdfPCell.NO_BORDER);
			tablePoll.addCell(cellPoll);

			cellPoll = new PdfPCell(new Paragraph("Existing/Proposed", font));
			// cell.setColspan (2);
			cellPoll.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll.setPadding(5.0f);
			cellPoll.setBorder(PdfPCell.NO_BORDER);
			tablePoll.addCell(cellPoll);

			cellPoll = new PdfPCell(new Paragraph("Date Of Installation", font));
			// cell.setColspan (2);
			cellPoll.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll.setPadding(5.0f);
			cellPoll.setBorder(PdfPCell.NO_BORDER);
			tablePoll.addCell(cellPoll);

			

			for (int var2 = 0; var2 < pollInstall.size(); var2++) {
				ArrayList pollIns = (ArrayList) pollInstall.get(var2);

				for (int var3 = 0; var3 < pollIns.size(); var3++) {

					String feeInner = (String) pollIns.get(var3);

					cellPoll = new PdfPCell(new Paragraph(feeInner));
					// cell.setColspan (2);
					cellPoll.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setBackgroundColor (new Color (128, 200, 128));
					cellPoll.setPadding(5.0f);
					cellPoll.setBorder(PdfPCell.NO_BORDER);
					tablePoll.addCell(cellPoll);

				}
			}
			
			
			document.add(tablePoll);

			document.add(space4);

			Paragraph equipmentInfEfficiency = new Paragraph();
			equipmentInfEfficiency
					.add(new Chunk(
							"     c) Reduction Efficiency Guaranteed by the Manufacturer:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfEfficiency);
			document.add(space4);
			
			PdfPTable tablePoll9 = new PdfPTable(3);

			PdfPCell cellPoll9 = new PdfPCell();
			
			tablePoll.setWidthPercentage(100);


			cellPoll9 = new PdfPCell(new Paragraph("Plant Name", font));
			// cell.setColspan (2);
			cellPoll9.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll9.setPadding(5.0f);
			cellPoll9.setBorder(PdfPCell.NO_BORDER);
			tablePoll9.addCell(cellPoll9);

			cellPoll9 = new PdfPCell(new Paragraph("Control Equipment", font));
			// cell.setColspan (2);
			cellPoll9.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll9.setPadding(5.0f);
			cellPoll9.setBorder(PdfPCell.NO_BORDER);
			tablePoll9.addCell(cellPoll9);

			cellPoll9 = new PdfPCell(new Paragraph("Guaranteed Reduction Efficiency", font));
			// cell.setColspan (2);
			cellPoll9.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellPoll9.setPadding(5.0f);
			cellPoll9.setBorder(PdfPCell.NO_BORDER);
			tablePoll9.addCell(cellPoll9);
			

			for (int var2 = 0; var2 < reductionEfficieDetails.size(); var2++) {
				ArrayList reductionEffie = (ArrayList) reductionEfficieDetails.get(var2);

				for (int var3 = 0; var3 < reductionEffie.size(); var3++) {

					String feeInner = (String) reductionEffie.get(var3);

					cellPoll9 = new PdfPCell(new Paragraph(feeInner));
					// cell.setColspan (2);
					cellPoll9.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setBackgroundColor (new Color (128, 200, 128));
					cellPoll9.setPadding(5.0f);
					cellPoll9.setBorder(PdfPCell.NO_BORDER);
					tablePoll9.addCell(cellPoll9);

				}
			}
			
			
			document.add(tablePoll9);
			
//			Paragraph equipmentInfEPAns1 = new Paragraph();
//			equipmentInfEPAns1
//					.add(new Chunk(efficiency,
//							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE
//									)));
//			// relevant.setExtraParagraphSpace(100.0f);
//			document.add(equipmentInfEPAns1);

			document.add(space4);

			Paragraph equipmentInfQuality = new Paragraph();
			equipmentInfQuality
					.add(new Chunk(
							"     d) Quantity & Quality of Current/Expected Emission:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfQuality);
			document.add(space4);
//			Paragraph equipmentInfEPAns2 = new Paragraph();
//			equipmentInfEPAns2
//					.add(new Chunk(finalQuan_Qual,
//							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE
//									)));
//			// relevant.setExtraParagraphSpace(100.0f);
//			document.add(equipmentInfEPAns2);

			/////////////////////////////////////////////////////////
			
			PdfPTable table3 = new PdfPTable(3);

			PdfPCell cell3 = new PdfPCell();
			
			table3.setWidthPercentage(100);


			cell3 = new PdfPCell(new Paragraph("Plant Name", font));
			// cell.setColspan (2);
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell3.setPadding(5.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph("Quantity of Current/Expected Emission of Pollutants(Kg/D)", font));
			// cell.setColspan (2);
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell3.setPadding(5.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph("Quality of Current/Expected Emission of Pollutants(mg/NCum)", font));
			// cell.setColspan (2);
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell3.setPadding(5.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			table3.addCell(cell3);

			
			

			for (int var2 = 0; var2 < plantQuantityDetails.size(); var2++) {
				ArrayList pollIns = (ArrayList) plantQuantityDetails.get(var2);

				for (int var3 = 0; var3 < pollIns.size(); var3++) {

					String feeInner = (String) pollIns.get(var3);

					cell3 = new PdfPCell(new Paragraph(feeInner));
					// cell.setColspan (2);
					cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setBackgroundColor (new Color (128, 200, 128));
					cell3.setPadding(5.0f);
					cell3.setBorder(PdfPCell.NO_BORDER);
					table3.addCell(cell3);

				}
			}
			
			
			document.add(table3);

			///////////////////////////////////////////////
			document.add(space4);

			Paragraph equipmentInfShift = new Paragraph();
		equipmentInfShift
					.add(new Chunk(
							"     e) Whether the Industry Works in General Shift or Two Shifts or Round the Clock:",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfShift);
			document.add(space4);
			String generalShiftF;
			if(generalShift==null){
				 generalShiftF="Day";
			}else{
				generalShiftF=generalShift;
			}
			Paragraph equipmentInfEPAns3 = new Paragraph();
			equipmentInfEPAns3
					.add(new Chunk(generalShiftF,
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfEPAns3);

			document.add(space4);

			Paragraph equipmentInfMon = new Paragraph();
			equipmentInfMon.add(new Chunk(
					"     f) Whether Monitoring is being Done or Proposed:",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(equipmentInfMon);
			document.add(space4);
//			Paragraph equipmentInfEPAns4 = new Paragraph();
//			equipmentInfEPAns4
//					.add(new Chunk(monitor,
//							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//			// relevant.setExtraParagraphSpace(100.0f);
//			document.add(equipmentInfEPAns4);

			
			PdfPTable table13 = new PdfPTable(2);

			PdfPCell cell13 = new PdfPCell();
			
			table13.setWidthPercentage(100);


			cell13 = new PdfPCell(new Paragraph("Plant Name", font));
			// cell.setColspan (2);
			cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell13.setPadding(5.0f);
			cell13.setBorder(PdfPCell.NO_BORDER);
			table13.addCell(cell13);

			cell13 = new PdfPCell(new Paragraph("Monitoring Status", font));
			// cell.setColspan (2);
			cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cell13.setPadding(5.0f);
			cell13.setBorder(PdfPCell.NO_BORDER);
			table13.addCell(cell13);

			

			
			

			for (int var2 = 0; var2 < stackMonitor.size(); var2++) {
				ArrayList pollIns = (ArrayList) stackMonitor.get(var2);

				for (int var3 = 0; var3 < pollIns.size(); var3++) {

					String feeInner = (String) pollIns.get(var3);

					cell13 = new PdfPCell(new Paragraph(feeInner));
					// cell.setColspan (2);
					cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setBackgroundColor (new Color (128, 200, 128));
					cell13.setPadding(5.0f);
					cell13.setBorder(PdfPCell.NO_BORDER);
					table13.addCell(cell13);

				}
			}
			
			
			document.add(table13);

			
			document.add(space4);

			List list1 = new List(true, 30);
			list1.setFirst(11);
			list1
					.add(new ListItem(
							"Attach information on compliance of emission with respect to the standard.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			list1
					.add(new ListItem(
							"I/We declare that the information furnished above is correct to the best of my/our knowledge.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			list1
					.add(new ListItem(
							"I/We hereby submit that in case of change either of the point of the emission or its quality, a fresh application for consent shall be made untill such consent is granted no emissions shall be made.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			list1
					.add(new ListItem(
							"I/We hereby agree to submit the State Committee an application for renewal of consent one Month in advance of the date of expiry of the consented period for stack fmission if to be continued thereafter.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			list1
					.add(new ListItem(
							"I/We undertake to furnish any information within one month of its being called by the State Committee.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			list1
					.add(new ListItem(
							"I/We Enclose herewith cash Receipt No./Bank Draft No. in Favour of J & K Pollution Control Committee as has been payable under section 21 of the Act.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));

			document.add(list1);
			if(fee.size()>0){

			PdfPTable tableFees = new PdfPTable(5);

			PdfPCell cellFees = new PdfPCell();
			
			tableFees.setWidthPercentage(100);

			cellFees = new PdfPCell(new Paragraph("Bank Name", font));
			// cell.setColspan (2);
			cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellFees.setPadding(5.0f);
			cellFees.setBorder(PdfPCell.NO_BORDER);
			tableFees.addCell(cellFees);
			
			cellFees = new PdfPCell(new Paragraph("Branch Name", font));
			// cell.setColspan (2);
			cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellFees.setPadding(5.0f);
			cellFees.setBorder(PdfPCell.NO_BORDER);
			tableFees.addCell(cellFees);

			cellFees = new PdfPCell(new Paragraph("Draft No./Money Receipt No.", font));
			// cell.setColspan (2);
			cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellFees.setPadding(5.0f);
			cellFees.setBorder(PdfPCell.NO_BORDER);
			tableFees.addCell(cellFees);

			cellFees = new PdfPCell(new Paragraph("Date", font));
			// cell.setColspan (2);
			cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellFees.setPadding(5.0f);
			cellFees.setBorder(PdfPCell.NO_BORDER);
			tableFees.addCell(cellFees);

			cellFees = new PdfPCell(new Paragraph("Rupees", font));
			// cell.setColspan (2);
			cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			cellFees.setPadding(5.0f);
			cellFees.setBorder(PdfPCell.NO_BORDER);
			tableFees.addCell(cellFees);

			for (int var2 = 0; var2 < fee.size(); var2++) {
				ArrayList feeList = (ArrayList) fee.get(var2);

				for (int var3 = 0; var3 < feeList.size(); var3++) {

					String feeInner = (String) feeList.get(var3);

					cellFees = new PdfPCell(new Paragraph(feeInner));
					// cell.setColspan (2);
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setBackgroundColor (new Color (128, 200, 128));
					cellFees.setPadding(5.0f);
					cellFees.setBorder(PdfPCell.NO_BORDER);
					tableFees.addCell(cellFees);

				}
			}
			document.add(space4);
			document.add(space4);
			document.add(tableFees);
			}
			else if(onlineFee.size()>0){
				PdfPTable tableFees1 = new PdfPTable(4);
					PdfPCell cellFees1 = new PdfPCell();
					tableFees1.setWidthPercentage(100);

					cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Id", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees1.setPadding(5.0f);
					tableFees1.addCell(cellFees1);

					cellFees1 = new PdfPCell(new Paragraph(new Chunk("Payment Date",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees1.setPadding(5.0f);
					tableFees1.addCell(cellFees1);

					cellFees1 = new PdfPCell(new Paragraph(new Chunk(
							"Ammount", new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees1.setPadding(5.0f);
					tableFees1.addCell(cellFees1);

					cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Status", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees1.setPadding(5.0f);
					tableFees1.addCell(cellFees1);

					System.out.println("--online feee list --"+onlineFee.size()+"-----------------"+onlineFee.get(0).toString());

					for (int var22 = 0; var22 < onlineFee.size(); var22++) {
						ArrayList feeList11 = (ArrayList)onlineFee.get(var22);

						for (int var33 = 0; var33 < feeList11.size(); var33++) {

							String feeInner1 = (String)feeList11.get(var33);
							System.out.println("------------"+feeInner1);
							cellFees1 = new PdfPCell(new Paragraph(feeInner1));
							cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
							cellFees1.setPadding(5.0f);
							tableFees1.addCell(cellFees1);
						}}		
					document.add(tableFees1);
			  
			}
			document.add(space4);
			document.add(space4);
			Paragraph mem = new Paragraph();
			mem.add(new Chunk("Yours Faithfully             ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			mem.setAlignment(Element.ALIGN_RIGHT);
			document.add(mem);

			document.add(space4);

			document.add(space4);

			document.add(space4);

			document.add(space4);

			document.add(space4);

			Paragraph mem1 = new Paragraph();
			mem1.add(new Chunk("Signature of the Applicant", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			mem1.setAlignment(Element.ALIGN_RIGHT);
			document.add(mem1);
			document.add(space4);
			document.add(space4);
			Paragraph accomp = new Paragraph();
			accomp.add(new Chunk("ACCOMPANIMENTS:-", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1, Font.BOLD)));
			accomp.setAlignment(Element.ALIGN_LEFT);
			document.add(accomp);


//////////////////////////////////////////////////////////////////////////////////////////////
			document.add(space4);

for(int var2=0;var2<listDocuments.size();var2++)
{
ArrayList al=(ArrayList) listDocuments.get(var2);

int count = 1;
for(int var3=0;var3<al.size();var3++)
{
String a=(String) al.get(var3);

Paragraph documents = new Paragraph();
documents.add(new Chunk(+count+".  "+a+"     (Attached)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1)));
documents.add(new Chunk("  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1)));
count = count + 1;

document.add(documents);

}
}




////////////////////////////////////////////////////////////////////////////////////////////

			document.add(space4);

			Paragraph note = new Paragraph();
			note.add(new Chunk("Note :", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1, Font.BOLD)));
			note.setAlignment(Element.ALIGN_LEFT);
			document.add(note);
			document.add(space4);
			List list111 = new List(true, 30);
			// list11.setFirst(11);
			list111
					.add(new ListItem(
							"Any applicant knowingly giving incorrect information or suppressing any information pertaining there to shall liable to be punished under the Act.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
									Font.BOLD)));
			list111.add(new ListItem(" 'Strike out which is not relevant'",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));

			document.add(list111);

			document.close();
			
			return tempFile;
			
	}

	
	

}
