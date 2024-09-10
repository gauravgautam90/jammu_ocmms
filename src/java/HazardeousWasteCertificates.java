import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class HazardeousWasteCertificates {

	//private static final String  = null;

	public File generateRenewalCertificate(String number, String date,String indName, String indAddress,String indDistrict, String indTehsil,
			String appId,String appDate,String renewPeriod,String renewFrom,String renewTo,String authLetterNo,String authLetterDate,String endtNo,
			String endtDate,String indLocation,ArrayList authFor,ArrayList hazardousWaste,ArrayList hazardousSource,ArrayList hazardousQuantity,
			String termsAndConditions ,String copyTo, String name, String address,String officerName,String officerDes,String office,
			ArrayList authList11,String occName)throws Exception
	{
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		
		
		Image image = Image.getInstance("images2/JHK_Logo.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("Jammu/Kashmir",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		
		Paragraph subHeading1 = new Paragraph();
		subHeading1.add(new Chunk("www.jkspcb.nic.in",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		subHeading1.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading1);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.NORMAL)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space12);
		
		
		Paragraph subHeading3 = new Paragraph();
		subHeading3.add(new Chunk("FORM 2\n",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading3.add(new Chunk("[See rule 6(2)]",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		subHeading3.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading3);
		
		document.add(space12);
		
		Paragraph subHeading4 = new Paragraph();
		subHeading4.add(new Chunk("FORM FOR GRANT OR RENEWAL OF AUTHORIZATION BY  POLLUPollution Control CommitteeHE OCCUPIERS, RECYCLERS, REPROCESSORS, REUSERS, USER AND OPERATORS OF DISPOSAL FACILITIES",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading4.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading4);
		document.add(space12);

		Paragraph space121 = new Paragraph();
		space121.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space121.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		//document.add(space121);

		Paragraph videNo = new Paragraph();

		
		/*videNo.add(new Chunk("1. No. of authorization and date of issue: ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE , Font.NORMAL)));
		videNo.add(new Chunk("" +number, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " + date, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));

		

		document.add(videNo);*/

//		Paragraph toAddress = new Paragraph("To, ");
//		subHeading.setAlignment(Element.ALIGN_LEFT);
//		document.add(toAddress);
//
//		Paragraph indsName = new Paragraph(name);
//		indsName.setExtraParagraphSpace(50.0f);
//		indsName.setIndentationLeft(20);
//		document.add(indsName);
		Paragraph space123 = new Paragraph();
		space123.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.NORMAL)));
		space123.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space12);
		
		PdfPTable table1=new PdfPTable(3);
		
		float[] columnWidths1 = { 0.8f, 5f, 7f};
		table1.setWidths(columnWidths1);
		table1.setWidthPercentage(100);
			PdfPCell cell1 = new PdfPCell ();
			
			cell1 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			cell1 = new PdfPCell (new Paragraph (new Chunk("No. of authorization and date of issue: ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
			cell1 = new PdfPCell (new Paragraph (new Chunk(""+number+"  "+date, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
		
			cell1 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			cell1 = new PdfPCell (new Paragraph (new Chunk("Reference of appication(No. and date): ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
			cell1 = new PdfPCell (new Paragraph (new Chunk(""+appId+"  "+appDate, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
			cell1 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			cell1 = new PdfPCell (new Paragraph (new Chunk(""+indName+" of "+occName+" is hereby granted an authorisation based on the enclosed signed inspection report for generation, collection, reception, storage, transport, reuse, recycling, recovery, pre-processing, co-processing, utilisation, treatment, disposal or any other use of hazardous or other wastes or both on the premises situated at "+indAddress, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setColspan(2);
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			
			PdfPTable table11=new PdfPTable(4);
			
			float[] columnWidths11 = { 1.6f, 5f, 5f, 4f};
			table11.setWidths(columnWidths11);
			table11.setWidthPercentage(100);
				PdfPCell cell11 = new PdfPCell ();
				
				cell11 = new PdfPCell (new Paragraph (new Chunk("Sl.No.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
				
				cell11 = new PdfPCell (new Paragraph (new Chunk("Category of Hazardous Waste as per the Schedules I, II and III of these rules", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
			
				cell11 = new PdfPCell (new Paragraph (new Chunk("Authorised mode of disposal or recycling or utilisation or co-processing, etc.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
			
			
				cell11 = new PdfPCell (new Paragraph (new Chunk("Quantity(ton/annum)", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
			
				for(int var2=0;var2<authList11.size();var2++)
				{
					ArrayList al=(ArrayList) authList11.get(var2);
					//System.out.println(al.ge)
					for(int var3=0;var3<al.size();var3++)
					{
						
						String a=(String) al.get(var3);
						
						cell11 = new PdfPCell (new Paragraph(a));
						//cell.setColspan (2);
						cell11.setHorizontalAlignment (Element.ALIGN_CENTER);
						//cell.setBackgroundColor (new Color (128, 200, 128));
						cell11.setPadding (5.0f);
						//cell22.setBorder(PdfPCell.NO_BORDER);
						table11.addCell (cell11);
						
					}
					}
				
				
			
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Details of Authorisation", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell ();
				cell1.addElement(table11);
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("(1)  The authorisation shall be valid for a period of "+renewPeriod+" years", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("(2)  The authorisation is subject to the following general and specific conditions (Please specify any conditions that need to be imposed over and above general conditions, if any):", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
			
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(3);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);	
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("A", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("General conditions of authorisation:", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);	
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The authorised person shall comply with the provisions of the Environment (Protection) Act, 1986, and the rules made there under.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The authorisation or its renewal shall be produced for inspection at the request of an officer authorised by the Pollution Control Committee.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The person authorised shall not rent, lend, sell, transfer or otherwise transport the hazardous and other wastes except what is permitted through this authorisation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Any unauthorised change in personnel, equipment or working conditions as mentioned in the application by the person authorised shall constitute a breach of his authorisation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The person authorised shall implement Emergency Response Procedure (ERP) for which this authorisation is being granted considering all site specific possible scenarios such as spillages, leakages, fire etc. and their possible impacts and also carry out mock drill in this regard at regular interval of time.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The person authorised shall comply with the provisions outlined in the Central Pollution Control Committee guidelines on “Implementing Liabilities for Environmental Damages due to Handling and Disposal of Hazardous Waste and Penalty”", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("It is the duty of the authorised person to take prior permission of the Pollution Control Committee to close down the facility.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The imported hazardous and other wastes shall be fully insured for transit as well as for any accidental occurrence and its clean-up operation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The record of consumption and fate of the imported hazardous and other wastes shall be maintained.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The hazardous and other waste which gets generated during recycling or reuse or recovery or pre-processing or utilisation of imported hazardous or other wastes shall be treated and disposed of as per specific conditions of authorisation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The importer or exporter shall bear the cost of import or export and mitigation of damages if any.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("An application for the renewal of an authorisation shall be made as laid down under these Rules.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Any other conditions for compliance as per the Guidelines issued by the Ministry of Environment, Forest and Climate Change or Central Pollution Control Committee from time to time.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("14.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Annual return shall be filed by June 30th for the period ensuring 31st March of the year.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(3);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("B", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Specific conditions:", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);	
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk(""+termsAndConditions, new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				
			document.add(table1);
			
			document.add(space12);
			document.add(space12);
			document.add(space12);
			
			PdfPTable table31=new PdfPTable(2);
			
			PdfPCell cell31 = new PdfPCell ();
			
			float[] columnWidths31 = { 1f,1f };
			table31.setWidths(columnWidths31);
			table31.setWidthPercentage(100);
			
			cell31 = new PdfPCell (new Paragraph (new Chunk("Memo No:"+authLetterNo+"\nDate: "+date, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE ))));
			cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setPadding (5.0f);
			table31.addCell (cell31);
			
			cell31 = new PdfPCell (new Paragraph (new Chunk(""+officerName+"\n"+officerDes, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1))));
			cell31.setHorizontalAlignment (Element.ALIGN_RIGHT);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setPadding (5.0f);
			table31.addCell (cell31);
			
			
			document.add(table31);
			document.add(space12);
			
			Paragraph para44 = new Paragraph();
			para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			para44.add(new Chunk("Copy To:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			para44.add(new Chunk("\n"+copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			
//			para44.add(list);
			para44.setAlignment(Element.ALIGN_JUSTIFIED);
			para44.setIndentationLeft(45);
			document.add(para44);
			document.add(space12);
			document.add(space12);
			
			
			PdfPTable table31aa=new PdfPTable(2);
			
			PdfPCell cell31aa = new PdfPCell ();
			
			float[] columnWidths31aa = { 1f,1f };
			table31aa.setWidths(columnWidths31aa);
			table31aa.setWidthPercentage(100);
			
			cell31aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE ))));
			cell31aa.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell31aa.setBorder(PdfPCell.NO_BORDER);
			cell31aa.setPadding (5.0f);
			table31aa.addCell (cell31aa);
			
			cell31aa = new PdfPCell (new Paragraph (new Chunk(""+officerName+"\n"+officerDes, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1))));
			cell31aa.setHorizontalAlignment (Element.ALIGN_RIGHT);
			cell31aa.setBorder(PdfPCell.NO_BORDER);
			cell31aa.setPadding (5.0f);
			table31aa.addCell (cell31aa);
			
			
			document.add(table31aa);
			
			
			////////////////????????????????			
	
		document.close();
		return tempFile;
	}
	
	public File generateNewCertificate(String number, String date, String indAddress,String indDistrict, String indTehsil,
			String appId,String appDate,String renewPeriod,String authLetterNo,String authLetterDate,String endtNo, String endtDate,
			String indLocation,ArrayList authFor,ArrayList hazardousWaste,ArrayList hazardousSource,ArrayList hazardousQuantity,
			String termsAndConditions ,String copyTo,String name,String address, String formattedDate,String officerName,
			String officerDes,String office,ArrayList authList11,String indName,String occName)throws Exception
	{
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);

		
		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();

		
		
		Image image = Image.getInstance("images2/JHK_Logo.jpg");
		// document.add(image);
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J & K STATE Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);

		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("Jammu/Kashmir",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		
		Paragraph subHeading1 = new Paragraph();
		subHeading1.add(new Chunk("www.jkspcb.nic.in",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		subHeading1.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading1);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.NORMAL)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space12);
		
		
		Paragraph subHeading3 = new Paragraph();
		subHeading3.add(new Chunk("FORM 2\n",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading3.add(new Chunk("[See rule 6(2)]",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		subHeading3.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading3);
		
		document.add(space12);
		
		Paragraph subHeading4 = new Paragraph();
		subHeading4.add(new Chunk("FORM FOR GRANT OR RENEWAL OF AUTHORIZATION BY STATE Pollution Control Committee TO THE OCCUPIERS, RECYCLERS, REPROCESSORS, REUSERS, USER AND OPERATORS OF DISPOSAL FACILITIES",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading4.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading4);
		document.add(space12);

		Paragraph space121 = new Paragraph();
		space121.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space121.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		//document.add(space121);

		Paragraph videNo = new Paragraph();

		
		/*videNo.add(new Chunk("1. No. of authorization and date of issue: ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE , Font.NORMAL)));
		videNo.add(new Chunk("" +number, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " + date, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));

		

		document.add(videNo);*/

//		Paragraph toAddress = new Paragraph("To, ");
//		subHeading.setAlignment(Element.ALIGN_LEFT);
//		document.add(toAddress);
//
//		Paragraph indsName = new Paragraph(name);
//		indsName.setExtraParagraphSpace(50.0f);
//		indsName.setIndentationLeft(20);
//		document.add(indsName);
		Paragraph space123 = new Paragraph();
		space123.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.NORMAL)));
		space123.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space12);
		
		PdfPTable table1=new PdfPTable(3);
		
		float[] columnWidths1 = { 0.8f, 5f, 7f};
		table1.setWidths(columnWidths1);
		table1.setWidthPercentage(100);
			PdfPCell cell1 = new PdfPCell ();
			
			cell1 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			cell1 = new PdfPCell (new Paragraph (new Chunk("No. of authorization and date of issue: ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
			cell1 = new PdfPCell (new Paragraph (new Chunk(""+number+"  "+date, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
		
			cell1 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			cell1 = new PdfPCell (new Paragraph (new Chunk("Reference of appication(No. and date): ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
			cell1 = new PdfPCell (new Paragraph (new Chunk(""+appId+"  "+appDate, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
		
			cell1 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			cell1 = new PdfPCell (new Paragraph (new Chunk(""+indName+" of "+occName+" is hereby granted an authorisation based on the enclosed signed inspection report for generation, collection, reception, storage, transport, reuse, recycling, recovery, pre-processing, co-processing, utilisation, treatment, disposal or any other use of hazardous or other wastes or both on the premises situated at "+indAddress, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE - 1, Font.NORMAL))));
			cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setColspan(2);
			cell1.setPadding (10.0f);
			table1.addCell (cell1);
			
			
			PdfPTable table11=new PdfPTable(4);
			
			float[] columnWidths11 = { 1.6f, 5f, 5f, 4f};
			table11.setWidths(columnWidths11);
			table11.setWidthPercentage(100);
				PdfPCell cell11 = new PdfPCell ();
				
				cell11 = new PdfPCell (new Paragraph (new Chunk("Sl.No.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
				
				cell11 = new PdfPCell (new Paragraph (new Chunk("Category of Hazardous Waste as per the Schedules I, II and III of these rules", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
			
				cell11 = new PdfPCell (new Paragraph (new Chunk("Authorised mode of disposal or recycling or utilisation or co-processing, etc.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
			
			
				cell11 = new PdfPCell (new Paragraph (new Chunk("Quantity(ton/annum)", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell11.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell11.setBorder(PdfPCell.NO_BORDER);
				
				cell11.setPadding (10.0f);
				table11.addCell (cell11);
			
				for(int var2=0;var2<authList11.size();var2++)
				{
					ArrayList al=(ArrayList) authList11.get(var2);
					//System.out.println(al.ge)
					for(int var3=0;var3<al.size();var3++)
					{
						
						String a=(String) al.get(var3);
						
						cell11 = new PdfPCell (new Paragraph(a));
						//cell.setColspan (2);
						cell11.setHorizontalAlignment (Element.ALIGN_CENTER);
						//cell.setBackgroundColor (new Color (128, 200, 128));
						cell11.setPadding (5.0f);
						//cell22.setBorder(PdfPCell.NO_BORDER);
						table11.addCell (cell11);
						
					}
					}
				
				
			
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Details of Authorisation", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell ();
				cell1.addElement(table11);
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("(1)  The authorisation shall be valid for a period of "+renewPeriod+" years", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("(2)  The authorisation is subject to the following general and specific conditions (Please specify any conditions that need to be imposed over and above general conditions, if any):", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
			
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(3);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);	
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("A", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("General conditions of authorisation:", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);	
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The authorised person shall comply with the provisions of the Environment (Protection) Act, 1986, and the rules made there under.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The authorisation or its renewal shall be produced for inspection at the request of an officer authorised by the Pollution Control Committee.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The person authorised shall not rent, lend, sell, transfer or otherwise transport the hazardous and other wastes except what is permitted through this authorisation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Any unauthorised change in personnel, equipment or working conditions as mentioned in the application by the person authorised shall constitute a breach of his authorisation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The person authorised shall implement Emergency Response Procedure (ERP) for which this authorisation is being granted considering all site specific possible scenarios such as spillages, leakages, fire etc. and their possible impacts and also carry out mock drill in this regard at regular interval of time.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The person authorised shall comply with the provisions outlined in the Central Pollution Control Committee guidelines on “Implementing Liabilities for Environmental Damages due to Handling and Disposal of Hazardous Waste and Penalty”", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("It is the duty of the authorised person to take prior permission of the Pollution Control Committee to close down the facility.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The imported hazardous and other wastes shall be fully insured for transit as well as for any accidental occurrence and its clean-up operation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The record of consumption and fate of the imported hazardous and other wastes shall be maintained.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The hazardous and other waste which gets generated during recycling or reuse or recovery or pre-processing or utilisation of imported hazardous or other wastes shall be treated and disposed of as per specific conditions of authorisation.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("The importer or exporter shall bear the cost of import or export and mitigation of damages if any.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("An application for the renewal of an authorisation shall be made as laid down under these Rules.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Any other conditions for compliance as per the Guidelines issued by the Ministry of Environment, Forest and Climate Change or Central Pollution Control Committee from time to time.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("14.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Annual return shall be filed by June 30th for the period ensuring 31st March of the year.", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(3);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("B", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (10.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("Specific conditions:", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.BOLD))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (10.0f);
				table1.addCell (cell1);	
				
				cell1 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				cell1 = new PdfPCell (new Paragraph (new Chunk(""+termsAndConditions, new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1, Font.NORMAL))));
				cell1.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell1.setBorder(PdfPCell.NO_BORDER);
				cell1.setColspan(2);
				cell1.setPadding (5.0f);
				table1.addCell (cell1);
				
				
			document.add(table1);
			
			document.add(space12);
			document.add(space12);
			document.add(space12);
			
PdfPTable table31=new PdfPTable(2);
			
			PdfPCell cell31 = new PdfPCell ();
			
			float[] columnWidths31 = { 1f,1f };
			table31.setWidths(columnWidths31);
			table31.setWidthPercentage(100);
			
			cell31 = new PdfPCell (new Paragraph (new Chunk("Memo No:"+authLetterNo+"\nDate: "+date, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE ))));
			cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setPadding (5.0f);
			table31.addCell (cell31);
			
			cell31 = new PdfPCell (new Paragraph (new Chunk(""+officerName+"\n"+officerDes, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1))));
			cell31.setHorizontalAlignment (Element.ALIGN_RIGHT);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setPadding (5.0f);
			table31.addCell (cell31);
			
			
			document.add(table31);
			document.add(space12);
			
			Paragraph para44 = new Paragraph();
			para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			para44.add(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			para44.add(new Chunk("Copy To:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			para44.add(new Chunk("\n"+copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			
//			para44.add(list);
			para44.setAlignment(Element.ALIGN_JUSTIFIED);
			para44.setIndentationLeft(45);
			document.add(para44);
			document.add(space12);
			document.add(space12);
			
			
			PdfPTable table31aa=new PdfPTable(2);
			
			PdfPCell cell31aa = new PdfPCell ();
			
			float[] columnWidths31aa = { 1f,1f };
			table31aa.setWidths(columnWidths31aa);
			table31aa.setWidthPercentage(100);
			
			cell31aa = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE ))));
			cell31aa.setHorizontalAlignment (Element.ALIGN_LEFT);
			cell31aa.setBorder(PdfPCell.NO_BORDER);
			cell31aa.setPadding (5.0f);
			table31aa.addCell (cell31aa);
			
			cell31aa = new PdfPCell (new Paragraph (new Chunk(""+officerName+"\n"+officerDes, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 1))));
			cell31aa.setHorizontalAlignment (Element.ALIGN_RIGHT);
			cell31aa.setBorder(PdfPCell.NO_BORDER);
			cell31aa.setPadding (5.0f);
			table31aa.addCell (cell31aa);
			
			
			document.add(table31aa);
			
			////////////////????????????????			
		/*Paragraph text = new Paragraph();
		text.add(new Chunk("2. "+name+"   At-  " +address+"  is hereby granted authorization to operate a facility for collection reception, treatment, storage, transport and disposal of the hazardous wastes on the premises situated At- "+address,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		text.setAlignment(Element.ALIGN_LEFT);
		document.add(text);
		
		document.add(space12);
		Paragraph text1 = new Paragraph();
		text1.add(new Chunk("3.  The authorisation granted to operate a facility for generation,collection,reception treatment,storage, transport and disposal of hazardous wastes.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		text1.setAlignment(Element.ALIGN_LEFT);
		document.add(text1);
		
		document.add(space12);
		
		Paragraph text34 = new Paragraph();
		text34.add(new Chunk("4.   The authorization shall be in force for a period from   "+date+"   to  "+formattedDate+".",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		text34.setAlignment(Element.ALIGN_LEFT);
		document.add(text34);

		document.add(space12);
		
		Paragraph text45 = new Paragraph();
		text45.add(new Chunk("5.   The authorisation is subject to the conditions stated below and the such conditions as may be specified in the rules for the time being in force under the Environment (Protection) Act,1986.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		text45.setAlignment(Element.ALIGN_LEFT);
		document.add(text45);
		
		
		
//		Paragraph address1 = new Paragraph(indAddress);
//		address1.setExtraParagraphSpace(50.0f);
//		address1.setIndentationLeft(20);
//		document.add(address1);

//		Paragraph tehsil = new Paragraph();
//		tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE , Font.BOLD)));
//		tehsil.add(new Chunk(indTehsil, new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		
//		tehsil.setIndentationLeft(20);
//		document.add(tehsil);
//
//		Paragraph district = new Paragraph();
//		district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE , Font.BOLD)));
//		district.add(new Chunk(indDistrict, new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		district.setIndentationLeft(20);
//		document.add(district);

		document.add(space12);
		document.add(space12);
		
//		Paragraph sub = new Paragraph();
//		sub.add(new Chunk("Sub :- ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD)));
//		sub.add(new Chunk("Grant of authorization under the Hazardeous Waste (Management, Handling and Trans boundary Movement) Rules,2008 ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1)));
//		sub.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(sub);
//		

		Paragraph text56 = new Paragraph();
		text56.add(new Chunk("DATE:   "+ date ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		text56.setAlignment(Element.ALIGN_LEFT);
		document.add(text56);
		document.add(space12);
		document.add(space12);
		
		Paragraph text90 = new Paragraph();
		text90.add(new Chunk("Terms and Conditions of authorization:" ,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		text90.setAlignment(Element.ALIGN_LEFT);
		document.add(text90);
	
		
		Paragraph tAc= new Paragraph();
		tAc.add(new Chunk(termsAndConditions,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
		tAc.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(tAc);
		
	
		
//		Paragraph ref = new Paragraph();
//		ref.add(new Chunk("Ref :- ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1)));
//		ref.add(new Chunk("Your letter No. ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1)));
//		ref.add(new Chunk(appId, new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD)));
//		ref.add(new Chunk(" Dated ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1)));
//		ref.add(new Chunk(appDate, new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE + 1, Font.BOLD)));
//		ref.setIndentationLeft(20);
//		document.add(ref);
		document.add(space12);
		document.add(space12);
		document.add(space12);
		
//		Paragraph noticeBody1 = new Paragraph();
//		noticeBody1.add(new Chunk("The authorization under the Hazardeous Waste (Management, Handling and Trans boundary Movement) Rules [Rule 5(4)] 2008 is hereby granted for ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		noticeBody1.add(new Chunk(renewPeriod, new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		noticeBody1.add(new Chunk("years from the date of issue of this letter ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		noticeBody1.add(new Chunk("subject to the fullfillment of terms & conditions given in the enclosed authorization letter ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE)));
//		noticeBody1.setFirstLineIndent(20);
//		noticeBody1.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(noticeBody1);
//		
		document.add(space12);
		
		
		
//		Paragraph noticeBody5 = new Paragraph();
//		noticeBody5.add(new Chunk("Please acknowledge the reciept of this letter. ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		noticeBody5.setFirstLineIndent(20);
//		noticeBody5.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(noticeBody5);
//		
//		Paragraph noticeBody6 = new Paragraph();
//		noticeBody6.add(new Chunk("Encl-   as above ", new Font(Font.TIMES_ROMAN,
//				Font.DEFAULTSIZE )));
//		noticeBody6.setFirstLineIndent(20);
//		document.add(noticeBody6);
//		
			document.add(space12);
			document.add(space12);
			document.add(space12);
			document.add(space12);
			

		Paragraph mem2 = new Paragraph();
		mem2.add(new Chunk("For and on behalf of                ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		mem2.setAlignment(Element.ALIGN_RIGHT);
		//document.add(mem2);
		
		
		Paragraph mem = new Paragraph();
		//mem.add(new Chunk("Member Secretary                          ",
			//	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem.add(new Chunk(""+officerName,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		
		mem.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem);

		Paragraph mem1 = new Paragraph();
//		mem1.add(new Chunk("Jharkhand Pollution Control Committee",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem1.add(new Chunk(officerDes+" ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem1.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem1);
		
		
		document.add(space12);
		document.add(space12);
		document.add(space12);
		
		Paragraph toAddress = new Paragraph("To, ");
	subHeading.setAlignment(Element.ALIGN_LEFT);
	document.add(toAddress);
	
	Paragraph indsName = new Paragraph(name);
	indsName.setExtraParagraphSpace(50.0f);
	indsName.setIndentationLeft(20);
	document.add(indsName);
		
	Paragraph indsadd = new Paragraph(address);
	indsadd.setExtraParagraphSpace(50.0f);
	indsadd.setIndentationLeft(20);
	document.add(indsadd);
		
		Paragraph videNo1 = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo1.add(new Chunk("Memo No.:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE , Font.BOLD)));
		videNo1.add(new Chunk("  " +endtNo, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE , Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE , Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE , Font.BOLD)));
		videNo1.add(new Chunk("Dated:" + endtDate, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE )));

		

		document.add(videNo1);
		document.add(space12);
		document.add(space12);
		Paragraph toAddress1 = new Paragraph("Copy To:-");
	//	document.add(toAddress1);
		
		Paragraph copYtoo1 = new Paragraph();
		copYtoo1.add(new Chunk("Copy To:-", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		copYtoo1.add(new Chunk(copyTo, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
		
		copYtoo1.setIndentationLeft(20);
		
		document.add(copYtoo1);
		
		
		document.add(space12);
		document.add(space12);
		
		document.add(mem);

		
		document.add(mem1);
		
		document.add(space12);
		document.add(space12);
		
//		Paragraph heading2 = new Paragraph();
//		heading2.add(new Chunk("FORM-2",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
//		heading2.setAlignment(Element.ALIGN_CENTER);
//		
//		document.add(heading2);
//		
//		Paragraph heading21 = new Paragraph();
//		heading21.add(new Chunk("See rules 5(4)",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
//		heading21.setAlignment(Element.ALIGN_CENTER);
//
//		document.add(heading21);
//
//		document.add(space12);
		
//		Paragraph para1 = new Paragraph();
//		para1.add(new Chunk("[FORM FOR GRANT OF AUTHORIZATION RENEWAL BY SPCB/PCC FOR OCCUPIERS REPROCESSORS, REUSERS AND OPERATOURS OF FACILITIES FOR COLLECTIONS, RECEPTION, TREATMENT, AND DISPOSAL OF HAZARDOUS WASTES]",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1 )));
//		para1.setAlignment(Element.ALIGN_CENTER);
//
//		document.add(para1);
//		
//		document.add(space12);
//		
//		Paragraph line1 = new Paragraph();
//		line1.add(new Chunk("1.    File number of Authorization & date of issue ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE  )));
//		line1.add(new Chunk(authLetterNo,
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		line1.add(new Chunk(" dated ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		line1.add(new Chunk(authLetterDate,
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		document.add(line1);
		
//		Paragraph line2= new Paragraph();
//		line2.add(new Chunk("2.   The operator of facility i.e. occupier  ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//
//		line2.add(new Chunk(name,
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		line2.add(new Chunk(" is hereby granted an authorization to operate a facility for ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		for(int i=0;i < authFor.size();i++)
//		{
//			String tmp = authFor.get(i).toString();
//			line2.add(new Chunk(tmp,
//					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//			
//			line2.add(new Chunk(",",
//					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//			
//		}
//		
//		line2.add(new Chunk(" of hazardous wastes on its industrial premises situated  at ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		line2.add(new Chunk(indLocation,
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		document.add(line2);
		
//		Paragraph line3= new Paragraph();
//		line3.add(new Chunk("3.    This authorization is granted to operate a facility for ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		for(int i=0;i < authFor.size();i++)
//		{
//		    String tmp;
//		    tmp = authFor.get(i).toString();
//			line3.add(new Chunk(tmp,
//					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//			
//			line3.add(new Chunk(",",
//					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//			
//		}
//		
//		
//		line3.add(new Chunk(" of hazardous waste as follows - ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		
//		line3.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(line3);
//		
		document.add(space12);
		
//		PdfPTable table=new PdfPTable(4);
//		table.setWidthPercentage(100);
//		
//		PdfPCell cell = new PdfPCell ();
//		
//		cell = new PdfPCell (new Paragraph ("S.No."));
//		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//		//cell.setPadding (100);
//		table.addCell (cell);
//		
//		cell = new PdfPCell (new Paragraph ("Hazardous Waste Description "));
//		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//		//cell.setBackgroundColor (new Color (255, 200, 0));
//		//cell.setPadding (10.0f);
//		table.addCell (cell);
//		
//		cell = new PdfPCell (new Paragraph ("Hazardous Waste Source"));
//		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//		//cell.setBackgroundColor (new Color (255, 200, 0));
//		//cell.setPadding (10.0f);
//		table.addCell (cell);
//		
//		cell = new PdfPCell (new Paragraph ("Hazardous Waste Quantity KL/Year"));
//		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//		//cell.setBackgroundColor (new Color (255, 200, 0));
//		//cell.setPadding (10.0f);
//		table.addCell (cell);
//		
//		
//		
//		for(int j=0;j < hazardousWaste.size();j++)
//		{
//			String tmp = Integer.toString(j+1);
//			cell = new PdfPCell (new Paragraph (tmp));
//			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//			//cell.setBackgroundColor (new Color (255, 200, 0));
//			//cell.setPadding (10.0f);
//			table.addCell (cell);
//			
//			tmp = hazardousWaste.get(j).toString();
//			cell = new PdfPCell (new Paragraph (tmp));
//			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//			//cell.setBackgroundColor (new Color (255, 200, 0));
//			//cell.setPadding (10.0f);
//			table.addCell (cell);
//			
//			tmp = hazardousSource.get(j).toString();
//			cell = new PdfPCell (new Paragraph (tmp));
//			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//			//cell.setBackgroundColor (new Color (255, 200, 0));
//			//cell.setPadding (10.0f);
//			table.addCell (cell);
//			
//			tmp = hazardousQuantity.get(j).toString();
//			cell = new PdfPCell (new Paragraph (tmp));
//			cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//			//cell.setBackgroundColor (new Color (255, 200, 0));
//			//cell.setPadding (10.0f);
//			table.addCell (cell);
//			
//			
//			
//		}
		
//		document.add(table);
		
//		Paragraph line4= new Paragraph();
//		line4.add(new Chunk("4.    The authorization, shall be enforce for a period of ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		line4.add(new Chunk(renewPeriod,
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		line4.add(new Chunk(" years from the date of issue of the letter ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		line4.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(line4);
//		
//		Paragraph line5= new Paragraph();
//		line5.add(new Chunk("5.    The authorization is subject to the terms and conditions stated below and such conditions as may be specified in the rules for the time being in force under the Environment (Protection) Act, 1986 ",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		line5.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(line5);
//		
//		Paragraph tAc= new Paragraph();
//		tAc.add(new Chunk(termsAndConditions,
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		tAc.setAlignment(Element.ALIGN_JUSTIFIED);
//		document.add(tAc);
//		
//		Paragraph dt= new Paragraph();
//		dt.add(new Chunk("Date...........",
//				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
//		
//		document.add(dt);
//		
//		document.add(mem);
//
//		document.add(mem1);
		*/
		document.close();
		return tempFile;
	}
}
