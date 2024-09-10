import java.awt.Color;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.io.File;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class EWastePdfFile {

	
	
				
	public File EWastePdfFunction(String abcDate, String login,String applicationId,String occName,String currentDate,String waterConsFrom,String waterConsTo,
								  String airConsFrom,String airConsTo,String authorizationFrom,String authorizationTo,String dateOfCom,String indName,String indAddress,
								  String occDesignation,String occPhoneCode,String occPhoneNo,String occFaxCode,String occFaxNo,String noOfEmp,ArrayList productionDetails,
								  ArrayList productDetails,ArrayList rawMaterialsDetails,ArrayList waterConsumptionDetails, ArrayList waterGenerationDetails,
								  ArrayList waterTreatmentDetails,ArrayList waterDischargeDetails,ArrayList fuelConsumptionDetails,ArrayList stackEmissionDetails,
								  ArrayList ambientDetails,ArrayList wasteGenerationDetails,ArrayList wasteDisposalDetails,ArrayList ewasteDetails,String disposal,
								  String fugEmission, String healthAspects,String adequatePoll,String indCompliance,String relInfo,ArrayList listDocuments,
								  ArrayList disposalQuantityDetails,ArrayList recycleQuantityDetails,ArrayList refurbishedQuantityDetails, ArrayList totalQuantityDetails,
								  String ewasteIsManufacturerOrRefurbisher,String chkConsent,String chkBMW, String chkHWM,String chkSWM,String facilityDetail,
								  String renewalAuth, String checkBoxButton, String facilityDetailsIns, String renewalDetailsIns) throws Exception {
		
	
	
	

	
				File tempFile = new File("EWasteForm.pdf");
		try{
			
			Document document = new Document(PageSize.A4);

	    
		        PdfWriter.getInstance(document, new FileOutputStream(tempFile));
			

				
				Phrase footerPhrase = new Phrase ("",new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -2));
				HeaderFooter footer = new HeaderFooter(footerPhrase, true);
				footer.setAlignment(Element.ALIGN_CENTER);
				document.setFooter(footer);
				document.open();
				
				Image image = Image.getInstance("images2/jammu.jpg");
				
				image.scalePercent(50.0f);
				image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
				document.add(image);

				
				
				Paragraph space = new Paragraph();
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
				
				space.setAlignment(Element.ALIGN_CENTER);
			
				document.add(space);
				Paragraph heading51 = new Paragraph();
				
				heading51.add(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				heading51.setAlignment(Element.ALIGN_CENTER);
				document.add(heading51);
				
				document.add(space);
				
				Paragraph login12 = new Paragraph();
				login12.add(new Chunk(" USER ID: "+login, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLDITALIC,new Color(0xFF, 0x00, 0x00))));
				login12.add(new Chunk("                                                               ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				login12.setAlignment(Element.ALIGN_LEFT);
				login12.add(new Chunk(" Applicaton No: "+ applicationId , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLDITALIC,new Color(0xFF, 0x00, 0x00))));
				
				document.add(login12);
				
				document.add(space);
				
				
		Paragraph formName = new Paragraph();		
		formName.add(new Chunk("FORM-1(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		formName.setAlignment(Element.ALIGN_CENTER);	
		document.add(formName);
		
		Paragraph rule11 = new Paragraph();		
		rule11.add(new Chunk("[see rules 4(2), 8(2), 13(2)(ii), 13(2)(vi) and 13(4)(i)]", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		rule11.setAlignment(Element.ALIGN_CENTER);	
		document.add(rule11);
		
		
		document.add(space);
		
		Paragraph infor = new Paragraph();		
		infor.add(new Chunk("APPLICATION FOR OBTAINING AUTHORISATION FOR GENERATION OR STORAGE OR TREATMENT OR DISPOSAL OF E-WASTE BY MANUFACTURER OR REFURBISHER", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		infor.setAlignment(Element.ALIGN_CENTER);
		document.add(infor);
		
		Paragraph rule1 = new Paragraph();		
		rule1.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		rule1.setAlignment(Element.ALIGN_CENTER);	
		document.add(rule1);
		
		document.add(space);
		
		Paragraph partC12 = new Paragraph();
		partC12.add(new Chunk("      From",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC12.setAlignment(Element.ALIGN_LEFT);
		document.add(partC12);
		
		
		Paragraph partC13 = new Paragraph();
		partC13.add(new Chunk("                   M/s. "+indName,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC13.setAlignment(Element.ALIGN_LEFT);
		document.add(partC13);
		
		Paragraph partC131 = new Paragraph();
		partC131.add(new Chunk("                   "+indAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC131.setAlignment(Element.ALIGN_LEFT);
		document.add(partC131);
		document.add(space);
		
		Paragraph partC14 = new Paragraph();
		partC14.add(new Chunk("      To,",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC14.setAlignment(Element.ALIGN_LEFT);
		document.add(partC14);
	
		
		Paragraph partC15 = new Paragraph();
		partC15.add(new Chunk("                   The Member Secretary,",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC15.setAlignment(Element.ALIGN_LEFT);
		document.add(partC15);
		
		
		Paragraph partC16 = new Paragraph();
		partC16.add(new Chunk("                   J&K Pollution Control Committee,",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC16.setAlignment(Element.ALIGN_LEFT);
		document.add(partC16);
		
		document.add(space);
		
		Paragraph partC18 = new Paragraph();
		partC18.add(new Chunk("      Sir,",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC18.setAlignment(Element.ALIGN_LEFT);
		document.add(partC18);

		
		Paragraph partC19 = new Paragraph();
		partC19.add(new Chunk("                      I/We hereby apply for authorisation/renewal of authorisation under rule 13(2)(i) to 13(2)(viii) and/or 13(4)(i) of the E-Waste (Management) Rules, 2016 for collection/ storage/ transportation/ treatment/ refurbishing/ disposal of e-wastes.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
		partC19.setAlignment(Element.ALIGN_LEFT);
		document.add(partC19);
		document.add(space);
		
		
		PdfPTable table=new PdfPTable(3);
		
		float[] columnWidths = new float[] {5f, 30f, 30f};
		table.setWidths(columnWidths);


		

            PdfPCell cell = new PdfPCell();

            cell = new PdfPCell(new Paragraph(new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Name and full address", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk(indName + "," + indAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Contact person with designation and contact details such as telephone Nos, Fax. No. and E-mail", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk(occName + " - " + occDesignation + "\nTel - " + occPhoneCode + "-" + occPhoneNo + "\nFax - " + occFaxCode + "-" + occFaxNo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            
            cell = new PdfPCell(new Paragraph(new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

           
            cell = new PdfPCell(new Paragraph(new Chunk("Authorization Required for: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            table.addCell(cell);
            String SS ="";
            if(chkConsent != "") {
            	//cell = new PdfPCell(new Paragraph(new Chunk("Generation during Manufacturing or Refurbishing", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            	SS += "Generation during Manufacturing or Refurbishing | ";
            }
            if(chkBMW != "")
            {
            	//cell = new PdfPCell(new Paragraph(new Chunk("Treatment(if any)", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            	SS += "Treatment(if any) | ";
            }
            if(chkHWM !="")
            {
            	//cell = new PdfPCell(new Paragraph(new Chunk("Collection, Transportation, Storage", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
                //table.addCell(cell);
            	SS += "Collection, Transportation, Storage | ";
            }
            if(chkSWM !="")
            {
            	//cell = new PdfPCell(new Paragraph(new Chunk("Refurbishing", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
                //table.addCell(cell);
            	SS += "Refurbishing";
            }
            cell = new PdfPCell(new Paragraph(new Chunk(SS, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell(cell);
           
            cell = new PdfPCell(new Paragraph(new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("E-waste details:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan (2);
            table.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("a. Total Quantity of e-waste generated in MT/A", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            cell.setColspan (2);
			table.addCell (cell);
			
			cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
            
			PdfPTable table14=new PdfPTable(5);
			table14.setWidthPercentage(100);
			float[] columnWidths1 = new float[] {1f,2f,2f,2f,2f};
			table14.setWidths(columnWidths1);
			
			PdfPCell cell14 = new PdfPCell ();
			cell14 = new PdfPCell (new Paragraph (new Chunk("S No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table14.addCell (cell14);
			cell14 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table14.addCell (cell14);
			cell14 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table14.addCell (cell14);
			cell14 = new PdfPCell (new Paragraph (new Chunk("Basel Convention No.", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table14.addCell (cell14);
			cell14 = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table14.addCell (cell14);
			for(int var2=0;var2<totalQuantityDetails.size();var2++)
			{
				ArrayList al=(ArrayList) totalQuantityDetails.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell14 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE)));
					cell14.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell14.setPadding (5.0f);
					table14.addCell (cell14);

				}
			}
			
			cell.setColspan (2);
			cell.setPadding (0);
			cell.addElement(table14);
			table.addCell (cell);

			 cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
	         cell.setHorizontalAlignment(Element.ALIGN_CENTER);

	         table.addCell(cell);

			cell = new PdfPCell (new Paragraph (new Chunk("b. Quantity Refurbished", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell.setColspan (2);
			table.addCell (cell);

			cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
            
			PdfPTable table13=new PdfPTable(3);
			float[] columnWidths11 = new float[] {1f,2f,2f};
			table13.setWidths(columnWidths11);
			
			table13.setWidthPercentage(100);
			PdfPCell cell13 = new PdfPCell ();
			cell13 = new PdfPCell (new Paragraph (new Chunk("S No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table13.addCell (cell13);
			cell13 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table13.addCell (cell13);
			cell13 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table13.addCell (cell13);

			for(int var2=0;var2<refurbishedQuantityDetails.size();var2++)
			{
				ArrayList al=(ArrayList)refurbishedQuantityDetails.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell13 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE)));
					cell13.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell13.setPadding (5.0f);
					table13.addCell (cell13);

				}
			}

			cell = new PdfPCell();
			cell.setColspan (2);
			cell.setPadding(0);
			cell.addElement(table13);
			table.addCell (cell);

			 cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
	         cell.setHorizontalAlignment(Element.ALIGN_CENTER);

	        table.addCell(cell);
	            
			cell = new PdfPCell (new Paragraph (new Chunk("c. Quantity send for Recycling", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell.setColspan (2);
			table.addCell (cell);
			
			cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
			
            PdfPTable table16=new PdfPTable(3);
            float[] columnWidths111 = new float[] {1f,2f,2f};
			table16.setWidths(columnWidths111);
			table16.setWidthPercentage(100);
			PdfPCell cell16 = new PdfPCell ();
			cell16 = new PdfPCell (new Paragraph (new Chunk("S No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table16.addCell (cell16);
			cell16 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table16.addCell (cell16);
			cell16 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table16.addCell (cell16);


			for(int var2=0;var2<recycleQuantityDetails.size();var2++)
			{
				ArrayList al=(ArrayList) recycleQuantityDetails.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell16 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE)));
					cell16.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell16.setPadding (5.0f);
					table16.addCell (cell16);

				}
			}

			cell = new PdfPCell();
			cell.setColspan (2);
			cell.setPadding(0);
			cell.addElement(table16);
			table.addCell (cell);

			 cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

	            table.addCell(cell);
	            
			cell = new PdfPCell (new Paragraph (new Chunk("d. Quantity send for Disposal", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell.setColspan (2);
			table.addCell (cell);

			cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
			
			PdfPTable table17=new PdfPTable(3);
			float[] columnWidths112 = new float[] {1f,2f,2f};
			table17.setWidths(columnWidths112);
			table17.setWidthPercentage(100);
			PdfPCell cell17 = new PdfPCell ();
			cell17 = new PdfPCell (new Paragraph (new Chunk("S No", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table17.addCell (cell17);
			cell17 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table17.addCell (cell17);
			cell17 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table17.addCell (cell17);


			for(int var2=0;var2<disposalQuantityDetails.size();var2++)
			{
				ArrayList al=(ArrayList) disposalQuantityDetails.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell17 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE)));
					cell17.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell17.setPadding (5.0f);
					table17.addCell (cell17);

				}
			}

			cell = new PdfPCell();
			cell.setColspan (2);
			cell.setPadding(0);
			cell.addElement(table17);
			table.addCell (cell);

			cell = new PdfPCell(new Paragraph(new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Details of facilities for Storage/ handling/ treatment/ refurbishing: ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table.addCell (cell);
			cell = new PdfPCell (new Paragraph (new Chunk(facilityDetail+" , "+facilityDetailsIns, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table.addCell (cell);
			
			cell = new PdfPCell(new Paragraph(new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);
            
			cell = new PdfPCell (new Paragraph (new Chunk("In case of renewal of authorization, previous auth number and date and details of annual returns: ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table.addCell (cell);
			cell = new PdfPCell (new Paragraph (new Chunk(renewalAuth+" , "+renewalDetailsIns, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			table.addCell (cell);



			

			document.add(table);

			document.add(space);



		


		Paragraph declare = new Paragraph();
		declare.add(new Chunk("I hereby declare that the above statements / information are true and correct to the best of my knowledge and belief.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		document.add(declare);
		
		Paragraph signature = new Paragraph();
		signature.add(new Chunk("Signature", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		signature.setAlignment(Element.ALIGN_RIGHT);
		document.add(signature);
		
		Paragraph date1 = new Paragraph();
		date1.add(new Chunk("Date: "+currentDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		date1.setAlignment(Element.ALIGN_LEFT);
		document.add(date1);
		
		Paragraph name = new Paragraph();
		name.add(new Chunk("Name:  "+occName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		name.setAlignment(Element.ALIGN_RIGHT);
		
		document.add(name);
		
		Paragraph place = new Paragraph();
		place.add(new Chunk("Place:  "+indAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		place.setAlignment(Element.ALIGN_LEFT);
		document.add(place);
		
		Paragraph designation = new Paragraph();
		designation.add(new Chunk("Designation: "+occDesignation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		designation.setAlignment(Element.ALIGN_RIGHT);
		document.add(designation);
	
		
		document.close();
		
    	}catch (Exception e) {
			e.printStackTrace();
			
		}
    	return tempFile;
		}
	



	
	
	
	public File EWastePdfFunction1(String abcDate, String login,String applicationId,String occName,String currentDate,String waterConsFrom,String waterConsTo,
								  String airConsFrom,String airConsTo,String authorizationFrom,String authorizationTo,String dateOfCom,String indName,String indAddress,
								  String occDesignation,String occPhoneCode,String occPhoneNo,String occFaxCode,String occFaxNo,String noOfEmp,ArrayList productionDetails,
								  ArrayList productDetails,ArrayList rawMaterialsDetails,ArrayList waterConsumptionDetails, ArrayList waterGenerationDetails,
								  ArrayList waterTreatmentDetails,ArrayList waterDischargeDetails,ArrayList fuelConsumptionDetails,ArrayList stackEmissionDetails,
								  ArrayList ambientDetails,ArrayList wasteGenerationDetails,ArrayList wasteDisposalDetails,ArrayList ewasteDetails,String disposal,
								  String fugEmission, String healthAspects,String adequatePoll,String indCompliance,String relInfo,ArrayList listDocuments,
								  ArrayList disposalQuantityDetails,ArrayList recycleQuantityDetails,ArrayList refurbishedQuantityDetails, ArrayList totalQuantityDetails,
								  String ewasteIsManufacturerOrRefurbisher,String chkConsent,String chkBMW, String chkHWM,String chkSWM,String facilityDetail,
								  String renewalAuth, String checkBoxButton,String document1,String document2,String document3,String document4,
								  String document5,String document6,String document7) throws Exception {
		
	
	
	

	File tempFile = new File("EWasteForm.pdf");
		try{
  
			Document document = new Document(PageSize.A4);

	    
		PdfWriter.getInstance(document,
				new FileOutputStream(tempFile));
			

				
				Phrase footerPhrase = new Phrase ("",new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE -2));
				HeaderFooter footer = new HeaderFooter(footerPhrase, true);
				footer.setAlignment(Element.ALIGN_CENTER);
				document.setFooter(footer);
				document.open();
				/*changes by saroj showing logo on pdf*/
				Image image = Image.getInstance("images2/jammu.jpg");
				
				image.scalePercent(50.0f);
				image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
				document.add(image);//end

				
				
				Paragraph space = new Paragraph();
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
				
				space.setAlignment(Element.ALIGN_CENTER);
			
				document.add(space);
				
				Paragraph heading51 = new Paragraph();
				heading51.add(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				heading51.setAlignment(Element.ALIGN_CENTER);
				document.add(heading51);
				
				document.add(space);
				Paragraph login12 = new Paragraph();
				login12.add(new Chunk(" USER ID: "+login, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLDITALIC,new Color(0xFF, 0x00, 0x00))));
				login12.add(new Chunk("                                                               ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				login12.setAlignment(Element.ALIGN_LEFT);
				login12.add(new Chunk(" Applicaton No: "+ applicationId , new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLDITALIC,new Color(0xFF, 0x00, 0x00))));
				
				document.add(login12);
				
				document.add(space);
				
				
			
				
			
	
		
		Paragraph formName = new Paragraph();		
		formName.add(new Chunk("FORM-4", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		formName.setAlignment(Element.ALIGN_CENTER);	
		document.add(formName);
		
		Paragraph rule11 = new Paragraph();		
		rule11.add(new Chunk("[see rule 13(3)(i) and 13(3)(vi)]", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		rule11.setAlignment(Element.ALIGN_CENTER);	
		document.add(rule11);
		
		
		document.add(space);
		
		Paragraph infor = new Paragraph();		
		infor.add(new Chunk("APPLICATION FORM FOR AUTHORISATION OF FACILITIES POSSESSING ENVIRONMENTALLY SOUND MANAGEMENT PRACTICE FOR DISMANTLING OR RECYCLING OF E-WASTE", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		infor.setAlignment(Element.ALIGN_CENTER);
		document.add(infor);
		
		Paragraph rule1 = new Paragraph();		
		rule1.add(new Chunk("(To be submitted in triplicate)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		rule1.setAlignment(Element.ALIGN_CENTER);	
		document.add(rule1);
		
		document.add(space);
		
		

		PdfPTable table=new PdfPTable(3);
		
		float[] columnWidths = new float[] {5f, 30f, 30f};
		table.setWidths(columnWidths);


		

            PdfPCell cell = new PdfPCell();

            cell = new PdfPCell(new Paragraph(new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Name and Address of the unit ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk(indName + " " + indAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Contact person with designation, Tel./Fax", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk(occName + " - " + occDesignation + "\nTel - " + occPhoneCode + "-" + occPhoneNo + "\nFax - " + occFaxCode + "-" + occFaxNo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Date of Commissioning ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk(dateOfCom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("No. of workers (including contract labour)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk(noOfEmp, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Consents Validity ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("a. Water(Prevention & Control of Pollution) Act 1974; \nFrom - " + waterConsFrom + " To - " + waterConsTo + "\n b. Air(Prevention & Control of Pollution) Act, 1981;\nFrom - " + airConsFrom + " To - " + airConsTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Validity of current authorisation if any ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("e-waste (Management and Handling) Rules 2011; \nFrom - " + authorizationFrom + " To - " + authorizationTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);


            cell = new PdfPCell(new Paragraph(new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Dismantling or Recyling Process", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("As Attached", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            PdfPTable table1 = new PdfPTable(2);
            table1.setWidthPercentage(100);
            PdfPCell cell1 = new PdfPCell();
            cell1 = new PdfPCell(new Paragraph(new Chunk("Installed capacity in MT/year: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell1.setColspan(2);
            table1.addCell(cell1);

           


            cell1 = new PdfPCell(new Paragraph(new Chunk("Products", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.addCell(cell1);
            cell1 = new PdfPCell(new Paragraph(new Chunk("Installed capacity(MTA)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.addCell(cell1);
            for (int var2 = 0; var2 < productionDetails.size(); var2++) {
                ArrayList al = (ArrayList) productionDetails.get(var2);
                for (int var3 = 0; var3 < al.size(); var3++) {
                    String a = (String) al.get(var3);
                    cell1 = new PdfPCell(new Paragraph(a));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setPadding(5.0f);
                    table1.addCell(cell1);

                }
            }


            cell = new PdfPCell();
            cell.setColspan(2);
            cell.setPadding(0);
            cell.setPadding(0);
            cell.addElement(table1);

            table.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            PdfPTable table2 = new PdfPTable(3);
            table2.setWidthPercentage(100);
            PdfPCell cell2 = new PdfPCell();
            cell2 = new PdfPCell(new Paragraph(new Chunk("E-Waste processed during the last three years (as applicable): ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell2.setColspan(3);
            table2.addCell(cell2);


            cell2 = new PdfPCell(new Paragraph(new Chunk("Year", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(cell2);
            cell2 = new PdfPCell(new Paragraph(new Chunk("Product", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(cell2);
            cell2 = new PdfPCell(new Paragraph(new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.addCell(cell2);


            for (int var2 = 0; var2 < productDetails.size(); var2++) {
                ArrayList al = (ArrayList) productDetails.get(var2);
                for (int var3 = 0; var3 < al.size(); var3++) {
                    String a = (String) al.get(var3);
                    cell2 = new PdfPCell(new Paragraph(a));
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell2.setPadding(5.0f);
                    table2.addCell(cell2);

                }
            }


            //cell = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            //table.addCell (cell);

            cell = new PdfPCell();
            cell.setColspan(2);
            cell.setPadding(0);
            cell.addElement(table2);

            table.addCell(cell);

          

            


            cell = new PdfPCell(new Paragraph(new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell);

            PdfPTable table9 = new PdfPTable(2);
            table9.setWidthPercentage(100);
            PdfPCell cell9 = new PdfPCell();
            cell9 = new PdfPCell(new Paragraph(new Chunk("Waste Management:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell9.setColspan(2);
            table9.addCell(cell9);
            
            cell9 = new PdfPCell(new Paragraph(new Chunk("a. Waste generation in processing e-waste: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell9.setColspan(2);
            table9.addCell(cell9);

            PdfPTable table10 = new PdfPTable(4);
            table10.setWidthPercentage(100);
            PdfPCell cell10 = new PdfPCell();
            cell10 = new PdfPCell(new Paragraph(new Chunk("S No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            table10.addCell(cell10);
            cell10 = new PdfPCell(new Paragraph(new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            table10.addCell(cell10);
            cell10 = new PdfPCell(new Paragraph(new Chunk("Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            table10.addCell(cell10);
            cell10 = new PdfPCell(new Paragraph(new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            table10.addCell(cell10);


            for (int var2 = 0; var2 < wasteGenerationDetails.size(); var2++) {
                ArrayList al = (ArrayList) wasteGenerationDetails.get(var2);
                for (int var3 = 0; var3 < al.size(); var3++) {
                    String a = (String) al.get(var3);
                    cell10 = new PdfPCell(new Paragraph(a));
                    cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell10.setPadding(5.0f);
                    table10.addCell(cell10);

                }
            }




            cell9 = new PdfPCell();
            cell9.setColspan(2);
            cell9.setPadding(0);
            cell9.addElement(table10);
            table9.addCell(cell9);

           
            cell9 = new PdfPCell(new Paragraph(new Chunk("b. Details of disposal of residue: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell9.setColspan(2);
            table9.addCell(cell9);

            PdfPTable table11 = new PdfPTable(4);
            table11.setWidthPercentage(100);
            PdfPCell cell11 = new PdfPCell();
            cell11 = new PdfPCell(new Paragraph(new Chunk("S No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            table11.addCell(cell11);
            cell11 = new PdfPCell(new Paragraph(new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            table11.addCell(cell11);
            cell11 = new PdfPCell(new Paragraph(new Chunk("Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            table11.addCell(cell11);
            cell11 = new PdfPCell(new Paragraph(new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            table11.addCell(cell11);


            for (int var2 = 0; var2 < wasteDisposalDetails.size(); var2++) {
                ArrayList al = (ArrayList) wasteDisposalDetails.get(var2);
                for (int var3 = 0; var3 < al.size(); var3++) {
                    String a = (String) al.get(var3);
                    cell11 = new PdfPCell(new Paragraph(a));
                    cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell11.setPadding(5.0f);
                    table11.addCell(cell11);

                }
            }

					


            cell9 = new PdfPCell();
            cell9.setColspan(2);
            cell9.setPadding(0);
            cell9.addElement(table11);
            table9.addCell(cell9);

            cell9 = new PdfPCell(new Paragraph(new Chunk("c. Name of Treatment Storage and Disposal Facility utilized for", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            table9.addCell(cell9);
            cell9 = new PdfPCell(new Paragraph(new Chunk(disposal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE))));
            table9.addCell(cell9);
            


            cell = new PdfPCell();
            cell.setColspan(2);
            cell.setPadding(0);
            cell.addElement(table9);

            table.addCell(cell);


            



			cell = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);

			table.addCell (cell);

			PdfPTable table21=new PdfPTable(3);
			table21.setWidthPercentage(100);
			PdfPCell cell21 = new PdfPCell ();
			cell21 = new PdfPCell (new Paragraph (new Chunk("Details of e-waste proposed to be procured from re-processing ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell21.setColspan (3);
			table21.addCell (cell21);

			//cell = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			//table.addCell (cell);


			cell21 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell21.setHorizontalAlignment (Element.ALIGN_CENTER);
			table21.addCell (cell21);
			cell21 = new PdfPCell (new Paragraph (new Chunk("Quantity required/year", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell21.setHorizontalAlignment (Element.ALIGN_CENTER);
			table21.addCell (cell21);
			cell21 = new PdfPCell (new Paragraph (new Chunk("Basel Convention Number", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
			cell21.setHorizontalAlignment (Element.ALIGN_CENTER);
			table21.addCell (cell21);


			for(int var2=0;var2<ewasteDetails.size();var2++)
			{
				ArrayList al=(ArrayList) ewasteDetails.get(var2);
				for(int var3=0;var3<al.size();var3++)
				{
					String a=(String) al.get(var3);
					cell21 = new PdfPCell (new Paragraph(a));
					cell21.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell21.setPadding (5.0f);
					table21.addCell (cell21);

				}
			}




			cell = new PdfPCell();
			cell.setColspan (2);
			cell.setPadding (0); cell.addElement(table21);

			table.addCell (cell);

					/*cell = new PdfPCell (new Paragraph (new Chunk("1) Name \n2) Quantity required/year \n3) Basel Convention Number ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
					table.addCell (cell);*/

			cell = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);

			table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Occupational safety and health aspects ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));

			table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk(healthAspects, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));

			table.addCell (cell);


			

			cell = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Details of facilities for dismantling both manual as well as mechanised ", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk(adequatePoll, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
			
			cell = new PdfPCell (new Paragraph (new Chunk("14.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Copy of agreement with Collection Centre", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document1, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("15.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Copy of agreement with Producer", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document2, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("16.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Details of storage for dismantled e-waste", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document3, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("17.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Copy of agreement with Recycler", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document4, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("18.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Details of Facilities for Recycler", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document5, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("19.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Copy of agreement with Collection Centre", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document6, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            
            cell = new PdfPCell (new Paragraph (new Chunk("20.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Copy agreement with Producer", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(document7, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph (new Chunk("21.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("Details of storage for raw materials and recovered materials", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(indCompliance, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            
            
            cell = new PdfPCell (new Paragraph (new Chunk("II", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  ))));
			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            table.addCell (cell);

			cell = new PdfPCell (new Paragraph (new Chunk("In case of renewal of authorisation, previous registration or authorisation no. and date", new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);
            cell = new PdfPCell (new Paragraph (new Chunk(relInfo, new Font(Font.TIMES_ROMAN , Font.DEFAULTSIZE))));
            table.addCell (cell);


			document.add(table);

			document.add(space);



		


		Paragraph declare = new Paragraph();
		declare.add(new Chunk("I hereby declare that the above statements / information are true and correct to the best of my knowledge and belief.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		document.add(declare);
		
		Paragraph signature = new Paragraph();
		signature.add(new Chunk("Signature", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		signature.setAlignment(Element.ALIGN_RIGHT);
		document.add(signature);
		
		Paragraph date1 = new Paragraph();
		date1.add(new Chunk("Date: "+currentDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		date1.setAlignment(Element.ALIGN_LEFT);
		document.add(date1);
		
		Paragraph name = new Paragraph();
		name.add(new Chunk("Name:  "+occName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		name.setAlignment(Element.ALIGN_RIGHT);
		
		document.add(name);
		
		Paragraph place = new Paragraph();
		place.add(new Chunk("Place:  "+indAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		place.setAlignment(Element.ALIGN_LEFT);
		document.add(place);
		
		Paragraph designation = new Paragraph();
		designation.add(new Chunk("Designation: "+occDesignation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		designation.setAlignment(Element.ALIGN_RIGHT);
		document.add(designation);
	
		
		document.close();
		
    	}catch (Exception e) {
			e.printStackTrace();
			
		}
    	return tempFile;
		}
	





}
	