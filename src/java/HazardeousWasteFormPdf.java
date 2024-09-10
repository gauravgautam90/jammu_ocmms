import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
class HazardeousWasteFormPdf {
	public  File hazaFunction(String txtIndName,String txtIndCity,String txtIndTehsil,
			String txtIndDistrict,String txtIndAddress,
			String txtIndPin,String location_Of_Activity,
			String authReqFor,String auth_Renew_No,
			String auth_Renew_Date,String hw_Defined,
			String totalCapitalInves,String yearofcommision,
			String expectedReturn,String flowDiagramManufactureProcess,
			String locationSite,String detailsOfProcessing,
			String siteClearance,String utilizationProgramme,
			String methodOfDisposal,String compositionWaste,
			String detailsOfLandfilling,String environmentalPollution,
			String safetyWorkers,String industryShift,ArrayList productDetailsList,ArrayList rawMaterialDetailsList,ArrayList hazarWasteDetailsList,ArrayList hazarWasteDetailsList1)throws Exception

	{

                File tempFile = new File("Industryhazaredeous.pdf");
		try{

	Document document = new Document(PageSize.A4);

	
	Font font = new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD);

	PdfWriter.getInstance(document,
			new FileOutputStream(tempFile));
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

			Paragraph space5 = new Paragraph();
			space5.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 3, Font.BOLD)));
			
			Paragraph rule = new Paragraph();
			rule.add(new Chunk("[See rules 5(3) and (7)]", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 2, Font.BOLD)));
			rule.setAlignment(Element.ALIGN_CENTER);
			document.add(rule);

			document.add(space4);
			

			Paragraph para = new Paragraph();
			para.add(new Chunk("APPLICATION FOR OBTAINING AUTHORIZATION FOR COLLECTION/ RECEPTION/ TREATMENT/ TRANSPORT/ STORAGE/ DISPOSAL OF HAZARDOUS WASTE",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			para.setAlignment(Element.ALIGN_CENTER);
			para.setFirstLineIndent(20);
			document.add(para);

			document.add(space4);
			
			Paragraph videNo = new Paragraph();

			// ch.setHorizontalScaling(20);
			videNo.add(new Chunk("From: ", new Font(Font.TIMES_ROMAN,
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
			
			document.add(videNo);
			
			document.add(space4);
			

			Paragraph location = new Paragraph("Location of Activity: "+location_Of_Activity);
			location.setExtraParagraphSpace(50.0f);
			location.setIndentationLeft(20);
			
			Paragraph indName = new Paragraph(txtIndName);
			indName.setExtraParagraphSpace(50.0f);
			indName.setIndentationLeft(20);
			document.add(indName);

			// Paragraph address = new Paragraph(address1);
			Paragraph address = new Paragraph(txtIndAddress);
			address.setExtraParagraphSpace(50.0f);
			address.setIndentationLeft(20);
			document.add(address);

			Paragraph city = new Paragraph(txtIndCity);
			city.setExtraParagraphSpace(50.0f);
			city.setIndentationLeft(20);
			document.add(city);
			
			Paragraph district = new Paragraph("District: "+txtIndDistrict);
			district.setExtraParagraphSpace(50.0f);
			district.setIndentationLeft(20);
			document.add(district);
			
			Paragraph tehsil = new Paragraph("Tehsil: "+txtIndTehsil);
			tehsil.setExtraParagraphSpace(50.0f);
			tehsil.setIndentationLeft(20);
			document.add(tehsil);
			
			Paragraph pin = new Paragraph("Pin: "+txtIndPin);
			pin.setExtraParagraphSpace(50.0f);
			pin.setIndentationLeft(20);
			document.add(pin);
			
			document.add(space4);
			
			Paragraph toAddress = new Paragraph((new Chunk("To", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			toAddress.setAlignment(Element.ALIGN_LEFT);
			document.add(toAddress);

			document.add(space4);


			Paragraph memberS = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			memberS.add(new Chunk("The Member Secretary,", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			memberS.setIndentationLeft(20);
			document.add(memberS);

			Paragraph member = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			member.add(new Chunk("J&K Pollution Control Committee,",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			member.setIndentationLeft(20);
			document.add(member);

			Paragraph memberc = new Paragraph();
			// district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 1, Font.BOLD)));
			memberc.add(new Chunk("RANCHI", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));
			// p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN,
			// Font.DEFAULTSIZE + 2, Font.BOLD)));
			memberc.setIndentationLeft(20);
			document.add(memberc);

			
			document.add(space4);
			
			Paragraph sir = new Paragraph();
			sir.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.BOLD)));
			sir.setAlignment(Element.ALIGN_LEFT);
			document.add(sir);
			
			
			Paragraph paraS = new Paragraph(
					"I/We hereby apply for authorization under sub-rule(3) of Rule 5 of the Hazardous Waste(Management, Handling and Transboundry Movement) Rules,2008 for "+authReqFor+" of hazardous wastes.");
			paraS.setFirstLineIndent(40);
			paraS.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraS);

			document.add(space5);
			
			PdfPTable table1 = new PdfPTable(1);

			PdfPCell cell1 = new PdfPCell();
			
			table1.setWidthPercentage(100);

			cell1 = new PdfPCell(new Paragraph("For Office Use Only", font));
			// cell.setColspan (2);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			//cell1.setPadding(5.0f);
			cell1.setBorderWidth(0.3f);
			table1.addCell(cell1);

			document.add(table1);
			
			Paragraph para1 = new Paragraph(
					"1. Code No.");
			para1.setAlignment(Element.ALIGN_LEFT);
			document.add(para1);


			Paragraph para2 = new Paragraph(
					"2. Whether the unit is situated in a critically polluted area as identified by Ministry of Environment and Forests.");
			para2.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(para2);
			
			document.add(space5);
			
			PdfPTable table2 = new PdfPTable(1);

			PdfPCell cell2 = new PdfPCell();
			
			table2.setWidthPercentage(100);

			cell2 = new PdfPCell(new Paragraph("Filled In By Applicant", font));
			// cell.setColspan (2);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			//cell2.setPadding(5.0f);
			cell2.setBorderWidth(0.3f);
			table2.addCell(cell2);

			document.add(table2);
			
			document.add(space5);
			

			PdfPTable table3 = new PdfPTable(1);

			PdfPCell cell3 = new PdfPCell();
			
			table2.setWidthPercentage(50);

			cell3 = new PdfPCell(new Paragraph("Part A: General", font));
			// cell.setColspan (2);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			//cell2.setPadding(5.0f);
			cell3.setBorder(Rectangle.NO_BORDER);
			table3.addCell(cell3);

			document.add(table3);
			

			Paragraph para3 = new Paragraph("3. (a) Name and address of the unit and location of activity :");
			para3.setAlignment(Element.ALIGN_LEFT);
			document.add(para3);

			document.add(indName);
			document.add(address);
			document.add(city);
			document.add(district);
			document.add(tehsil);
			document.add(pin);
			document.add(location);
			
			Paragraph para4 = new Paragraph("   (b) Authorization required for: "+authReqFor);
			para4.setAlignment(Element.ALIGN_LEFT);
			document.add(para4);

			String auth;
			if(auth_Renew_No!=null)
			{
				 auth = auth_Renew_No+" and "+auth_Renew_Date;
			}
			else
			{
				auth = "NA";
			}
			Paragraph para5 = new Paragraph("   (c) In case of renewal of authorization previous authorization number and date : "+auth);
			para5.setAlignment(Element.ALIGN_LEFT);
			document.add(para5);
			
			Paragraph para6 = new Paragraph("4. (a) Whether the unit is generating hazardous waste as defined in these Rules : "+hw_Defined);
			para6.setAlignment(Element.ALIGN_LEFT);
			document.add(para6);
			
			Paragraph para7 = new Paragraph("    (b) If so the type and quantity of wastes (in Tonnes/Kl)");
			para7.setAlignment(Element.ALIGN_LEFT);
			document.add(para7);

///////// Hazar /////////Type

			PdfPTable table25=new PdfPTable(2);

			PdfPCell cell25 = new PdfPCell ();

			table25.setWidthPercentage(100);

			cell25 = new PdfPCell (new Paragraph("Type",font));
			//cell.setColspan (2);
			cell25.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell25.setPadding (5.0f);
			cell25.setBorder(PdfPCell.NO_BORDER);
			table25.addCell (cell25);

			cell25 = new PdfPCell (new Paragraph("Quantity(Tonnes/KL)",font));
			//cell.setColspan (2);
			cell25.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell25.setPadding (5.0f);
			cell25.setBorder(PdfPCell.NO_BORDER);
			table25.addCell (cell25);

			for(int var2=0;var2<hazarWasteDetailsList.size();var2++)
			{
			ArrayList al=(ArrayList) hazarWasteDetailsList.get(var2);
			//System.out.println(al.ge)
			for(int var3=0;var3<al.size();var3++)
			{

			String a=(String) al.get(var3);
			System.out.println("iiiii"+"  :-   "+var3);
			System.out.println(a);
			cell25 = new PdfPCell (new Paragraph(a));
			//cell.setColspan (2);
			cell25.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell25.setPadding (5.0f);
			cell25.setBorder(PdfPCell.NO_BORDER);
			table25.addCell (cell25);

			}
			}
			document.add(table25);
//////////////
			
			///////////////////////////// Source /////////Details/////////////////
		
			PdfPTable table26=new PdfPTable(6);

			PdfPCell cell26 = new PdfPCell ();

			table26.setWidthPercentage(100);

			cell26 = new PdfPCell (new Paragraph("Type",font));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);

			cell26 = new PdfPCell (new Paragraph("Quantity(Tonnes/KL)",font));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);

			cell26 = new PdfPCell (new Paragraph("Source",font));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);
			
			cell26 = new PdfPCell (new Paragraph("Mode of Storage",font));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);
			
			cell26 = new PdfPCell (new Paragraph("Method of Disposal",font));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);
			
			cell26 = new PdfPCell (new Paragraph("Capacity(Tonnes/KL)",font));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);
			
			
			for(int var2=0;var2<hazarWasteDetailsList1.size();var2++)
			{
			ArrayList al=(ArrayList) hazarWasteDetailsList1.get(var2);
			//System.out.println(al.ge)
			for(int var3=0;var3<al.size();var3++)
			{

			String a=(String) al.get(var3);
			System.out.println("iiiii"+"  :-   "+var3);
			System.out.println(a);
			cell26 = new PdfPCell (new Paragraph(a));
			//cell.setColspan (2);
			cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
			//cell.setBackgroundColor (new Color (128, 200, 128));
			cell26.setPadding (5.0f);
			cell26.setBorder(PdfPCell.NO_BORDER);
			table26.addCell (cell26);

			}
			}
			
			
		///////END/////////       /////////////////////	
			
			
			Paragraph para8 = new Paragraph("5. (a) Total capital invested on the project : "+totalCapitalInves);
			para8.setAlignment(Element.ALIGN_LEFT);
			document.add(para8);
			
			Paragraph para9 = new Paragraph("    (b) Year of commencement of production : "+yearofcommision);
			para9.setAlignment(Element.ALIGN_LEFT);
			document.add(para9);
			
			Paragraph para10 = new Paragraph("    (c) Whether the industry works general/2 shifts/round the clock : "+industryShift);
			para10.setAlignment(Element.ALIGN_LEFT);
			document.add(para10);
			
			Paragraph para11 = new Paragraph("6. (a) List and quantum of products and by-products(in Tonnes/KL)");
			para11.setAlignment(Element.ALIGN_LEFT);
			document.add(para11);
			
			
			
			
////////////////////////////////////////////Product Details	/////////////////////////////////



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

cell23 = new PdfPCell (new Paragraph("Quantity(Tonnes/KL)",font));
//cell.setColspan (2);
cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell23.setPadding (5.0f);
cell23.setBorder(PdfPCell.NO_BORDER);
table23.addCell (cell23);

cell23 = new PdfPCell (new Paragraph("By Product Name",font));
//cell.setColspan (2);
cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell23.setPadding (5.0f);
cell23.setBorder(PdfPCell.NO_BORDER);
table23.addCell (cell23);

cell23 = new PdfPCell (new Paragraph("By Product Quantity(Tonnes/KL)",font));
//cell.setColspan (2);
cell23.setHorizontalAlignment (Element.ALIGN_LEFT);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell23.setPadding (5.0f);
cell23.setBorder(PdfPCell.NO_BORDER);
table23.addCell (cell23);

for(int var2=0;var2<productDetailsList.size();var2++)
{
ArrayList al=(ArrayList) productDetailsList.get(var2);
//System.out.println(al.ge)
for(int var3=0;var3<al.size();var3++)
{

String a=(String) al.get(var3);
System.out.println("iiiii"+"  :-   "+var3);
System.out.println(a);
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


PdfPTable table24=new PdfPTable(2);

PdfPCell cell24 = new PdfPCell ();

table24.setWidthPercentage(100);

cell24 = new PdfPCell (new Paragraph("Raw Material",font));
//cell.setColspan (2);
cell24.setHorizontalAlignment (Element.ALIGN_LEFT);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell24.setPadding (5.0f);
cell24.setBorder(PdfPCell.NO_BORDER);
table24.addCell (cell24);

cell24 = new PdfPCell (new Paragraph("Quantity(Tonnes/KL)",font));
//cell.setColspan (2);
cell24.setHorizontalAlignment (Element.ALIGN_LEFT);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell24.setPadding (5.0f);
cell24.setBorder(PdfPCell.NO_BORDER);
table24.addCell (cell24);

for(int var2=0;var2<rawMaterialDetailsList.size();var2++)
{
ArrayList al=(ArrayList) rawMaterialDetailsList.get(var2);
//System.out.println(al.ge)
for(int var3=0;var3<al.size();var3++)
{

String a=(String) al.get(var3);
System.out.println("iiiii"+"  :-   "+var3);
System.out.println(a);
cell24 = new PdfPCell (new Paragraph(a));
//cell.setColspan (2);
cell24.setHorizontalAlignment (Element.ALIGN_LEFT);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell24.setPadding (5.0f);
cell24.setBorder(PdfPCell.NO_BORDER);
table24.addCell (cell24);

}
}





///////////////////////////////////////////			

			
			
			Paragraph para12 = new Paragraph("    (b) List and quantum of raw material used(in Tonnes/KL)");
			para12.setAlignment(Element.ALIGN_LEFT);
			document.add(para12);
			
			document.add(table24);
			
			Paragraph para13 = new Paragraph("7.  Furnish a flow diagram of manufacturing process showing input and output in terms of products,waste generated including for captive generation and demineralised water. ");
			para13.setAlignment(Element.ALIGN_LEFT);
			document.add(para13);
			
			Paragraph para40 = new Paragraph(flowDiagramManufactureProcess);
			para40.setAlignment(Element.ALIGN_LEFT);
			document.add(para40);
		
			PdfPTable table4 = new PdfPTable(1);

			PdfPCell cell4 = new PdfPCell();
			
			table2.setWidthPercentage(50);

			cell4 = new PdfPCell(new Paragraph("Part B: Hazardous Waste", font));
			// cell.setColspan (2);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			//cell2.setPadding(5.0f);
			cell4.setBorder(Rectangle.NO_BORDER);
			table4.addCell(cell4);

			document.add(table4);
			
			document.add(space5);
			
			Paragraph para14 = new Paragraph("8. (a) Type of hazardous wastes generated as defined under these Rules.");
			para14.setAlignment(Element.ALIGN_LEFT);
			document.add(para14);
			Paragraph para15 = new Paragraph("    (b) Quantum of hazardous waste generated.");
			para15.setAlignment(Element.ALIGN_LEFT);
			document.add(para15);
			Paragraph para16 = new Paragraph("    (c) Sources and waste characteristics.");
			para16.setAlignment(Element.ALIGN_LEFT);
			document.add(para16);
			Paragraph para17 = new Paragraph("    (d) Mode of storage within the plant, method of disposal and capacity.");
			para17.setAlignment(Element.ALIGN_LEFT);
			document.add(para17);
			
			document.add(table26);
			
			Paragraph para18 = new Paragraph("9. Hazardous Wastes generated as per these Rules from storage of hazardous chemicals as defined under the Manufacture,Storage and Import of Hazardous Chemicals Rules 1989.");
			para18.setAlignment(Element.ALIGN_LEFT);
			document.add(para18);
			
			

			document.add(space5);
			
			PdfPTable table5 = new PdfPTable(1);

			PdfPCell cell5 = new PdfPCell();
			
			table2.setWidthPercentage(50);

			cell5 = new PdfPCell(new Paragraph("Part C: Treatment, Storage and Disposal Facility", font));
			// cell.setColspan (2);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell.setBackgroundColor (new Color (128, 200, 128));
			//cell2.setPadding(5.0f);
			cell5.setBorder(Rectangle.NO_BORDER);
			table5.addCell(cell5);

			document.add(table5);
			
			document.add(space5);
			
			Paragraph para19 = new Paragraph("10. Detailed proposal of the facility(to be attaced) to include");
			para19.setAlignment(Element.ALIGN_LEFT);
			document.add(para19);
			
			Paragraph para20 = new Paragraph(" (a)Location of sit(provide map):");
			para20.setAlignment(Element.ALIGN_LEFT);
			document.add(para20);
			
			Paragraph para21 = new Paragraph(locationSite);
			para21.setAlignment(Element.ALIGN_LEFT);
			document.add(para21);
			
			Paragraph para22 = new Paragraph(" (b)Name and Details of waste processing technology:");
			para22.setAlignment(Element.ALIGN_LEFT);
			document.add(para22);
			
			Paragraph para23 = new Paragraph(detailsOfProcessing);
			para23.setAlignment(Element.ALIGN_LEFT);
			document.add(para23);
			
			Paragraph para24 = new Paragraph(" (c)Site Clearance(from local authority,if any):");
			para24.setAlignment(Element.ALIGN_LEFT);
			document.add(para24);
			
			Paragraph para25 = new Paragraph(siteClearance);
			para25.setAlignment(Element.ALIGN_LEFT);
			document.add(para25);
			
			Paragraph para26 = new Paragraph(" (d)Utilization Programme for waste processed(Product Utilization):");
			para26.setAlignment(Element.ALIGN_LEFT);
			document.add(para26);
			
			Paragraph para27 = new Paragraph(utilizationProgramme);
			para27.setAlignment(Element.ALIGN_LEFT);
			document.add(para27);
			
			Paragraph para28 = new Paragraph(" (e)Method Of disposal(details in brief be given):");
			para28.setAlignment(Element.ALIGN_LEFT);
			document.add(para28);
			
			Paragraph para29 = new Paragraph(methodOfDisposal);
			para29.setAlignment(Element.ALIGN_LEFT);
			document.add(para29);
			
			Paragraph para30 = new Paragraph(" (f)Nature and composition of waste:");
			para30.setAlignment(Element.ALIGN_LEFT);
			document.add(para30);
			
			Paragraph para31 = new Paragraph(compositionWaste);
			para31.setAlignment(Element.ALIGN_LEFT);
			document.add(para31);
			
			Paragraph para32 = new Paragraph(" (g)Methodology and operational details of landfilling/incineration:");
			para32.setAlignment(Element.ALIGN_LEFT);
			document.add(para32);
			
			Paragraph para33 = new Paragraph(detailsOfLandfilling);
			para33.setAlignment(Element.ALIGN_LEFT);
			document.add(para33);
			
			Paragraph para34 = new Paragraph(" (h)Measures to be taken for prevention and control of environmental pollution including treatment of leachate:");
			para34.setAlignment(Element.ALIGN_LEFT);
			document.add(para34);
			
			Paragraph para35 = new Paragraph(environmentalPollution);
			para35.setAlignment(Element.ALIGN_LEFT);
			document.add(para35);
			
			Paragraph para36 = new Paragraph(" (i)Measures to be taken for safety of workers working in the plant:");
			para36.setAlignment(Element.ALIGN_LEFT);
			document.add(para36);
			
			Paragraph para37 = new Paragraph(safetyWorkers);
			para37.setAlignment(Element.ALIGN_LEFT);
			document.add(para37);
			

			document.add(space5);
			
            Paragraph ending = new Paragraph();
            ending.add(new Chunk("Place:\nDate:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD  )));
            ending.setAlignment(Element.ALIGN_LEFT);
            document.add(ending);
         
            Paragraph signature = new Paragraph();
            signature.add(new Chunk("Signature:.............\nDesignation:...........", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD  )));
            signature.setAlignment(Element.ALIGN_RIGHT);
            document.add(signature);
         
            document.close();

			
    	}catch (Exception e) {


		}
    	return tempFile;
		}
}
