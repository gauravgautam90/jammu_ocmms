
import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AutoRenewPdf {
	
public File autoRenewpdf_Function(String roGroupName,String consentOrderNo,String consentValidDate,String validDate,String upTODate,String industryProfile,String capInvestment,String oldApplication,String oldApplicationDate,String occupierName,String designation,String phoneNo, String emailId,String indAddress,String dist,String pin,String oldIndApplicationNo,String noIncreaseProduction,String noSewageTradeEffluent,String noIncreaseStacksEmission,String noChangeManagementOwnership,String noIncreaseProductionOverconsented,String noCasePending,String devicesInstalled, String consentConditions,String failure,String abide,String noOfYear,String indCapInvt) throws Exception {
		
		File tempFile = new File("autoRenewConsent.pdf");
		
		Document document = new Document(PageSize.A4);

		
		
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		
		document.open();
		
		Image image = Image.getInstance("images2/jammu.jpg");
		image.scalePercent(50.0f);
		image.setAlignment(Image.LEFT | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		

		Font fontTable= new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE-1 );
				
		
				
	//	document.add(space12);//used for space	
	//	document.add(space12);//used for space	
		
		Paragraph heading1 = new Paragraph();
		heading1.add(new Chunk("J&K Pollution Control Committee" +
				"\nJammu/Kashmir (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading1.setAlignment(Element.ALIGN_CENTER);
		document.add(heading1);
		document.add(space12);
		
		Paragraph heading15 = new Paragraph();
		heading15.add(new Chunk("Schedule-I (Application Form)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading15.setAlignment(Element.ALIGN_CENTER);
		document.add(heading15);
		
		Paragraph heading16 = new Paragraph();
		heading16.add(new Chunk("(Auto renewal of Consent to Operate for Green Category except hazardous waste generating units)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD)));
		heading16.setAlignment(Element.ALIGN_CENTER);
		document.add(heading16);
		
		document.add(space12);//used for space	
			document.add(space12);//used for space
		//Commented by DEEPAK FOR NEW AUTORENEW FORMAT
	/*	Paragraph subHeading3a = new Paragraph();
		subHeading3a.add(new Chunk("Auto Renewal Form Cum Self Certification",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading3a.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading3a);*/
		
		/* if(roGroupName.equals("SE I")){
			 
		Paragraph paragraph4z = new Paragraph();
		paragraph4z.add(new Chunk("\n                 From \n                 ,"+industryProfile+", "+indAddress+", "+dist+", "+pin));
		paragraph4z.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph4z);
		document.add(space12);
			 
		Paragraph paragraph1 = new Paragraph();
		paragraph1.add(new Chunk("\n    To,"));
		paragraph1.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph1);
		 
		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(new Chunk("                The Member Secretary "));
		paragraph2.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph2);
		 
		Paragraph paragraph3 = new Paragraph();
		paragraph3.add(new Chunk("                 J&K Pollution Control Committee.  "));
		paragraph3.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph3);
		
		 }else{
		
		
		Paragraph paragraph4z = new Paragraph();
		paragraph4z.add(new Chunk("\n                 From \n                 ,"+indAddress));
		paragraph4z.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph4z);
	
			 
		Paragraph paragraph4 = new Paragraph();
		paragraph4.add(new Chunk("\n                 To \n                 J&K Pollution Control Committee,"));
		paragraph4.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph4);
		
		 } */
		
		
		
		PdfPTable table11 = new PdfPTable(2);
		table11.setWidthPercentage(100);
		float[] columnWidthsA = {3f,1f};
		table11.setWidths(columnWidthsA);
		PdfPCell cell11 = new PdfPCell();
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Name of the Proprietor / Partner :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(industryProfile, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Name and Address of the Industry :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(industryProfile+" , "+indAddress, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("i)   Email :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(emailId, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("ii)  Contact No. :", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(phoneNo, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("SELF CERTIFICATION / UNDERTAKING", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setColspan(2);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		

		cell11 = new PdfPCell(new Paragraph(new Chunk("i.   that there is no increase in production over the consented quantity.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noIncreaseProduction, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("ii.   that there is no increase in quantity of sewage and trade effluent over the consented quantity.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noSewageTradeEffluent, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("iii.   that there is no increase in the number of stacks and in emission over the consented quantity.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noIncreaseStacksEmission, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("iv.   that there is no change in the management or ownership of the company.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noChangeManagementOwnership, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("v.   that no court case is pending in respect of our unit against the Board/JK PCC in High Court/Supreme Court/NGT/Appellate Authority or any other courts (as applicable).", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noCasePending, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("vi.   that adequate Pollution Control Devices are installed / pollution control measures have been adopted in our unit efficiently as per norms.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(devicesInstalled, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("vii.   I/we certify that the information / data provided above are true to the best of my/our knowledge and submission of false information or suppression of any factual information in the above self certification form would attract an action under environmental laws.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noIncreaseProductionOverconsented, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("Self Declaration / Compliance", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		cell11.setColspan(2);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
	
		cell11 = new PdfPCell(new Paragraph(new Chunk("viii.   that the consent conditions stipulated in the earlier consent issued by the Board / JK PCC have been complied.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(consentConditions, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("ix.   I understand that failure on my part to comply with the prescribed standards or conditions of consent is liable to attract action as warranted under extant environmental laws.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(failure, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("x.   that I hereby agree to abide by all the conditions mentioned in the self declaration / certification / undertaking.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(abide, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		//cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk("Bank details", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.BOLD))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
		
		cell11.setColspan(2);
//		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		

		cell11 = new PdfPCell(new Paragraph(new Chunk("Capital Investment :(Land & Building, Plant and Machinery) in Lakh", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
//		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(indCapInvt, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
//		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		cell11 = new PdfPCell(new Paragraph(new Chunk("Number of Years/Period for which Consent Renewal required", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
//		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		cell11 = new PdfPCell(new Paragraph(new Chunk(noOfYear, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell11.setPadding(3.0f);
//		cell11.setBorder(PdfPCell.NO_BORDER);
		table11.addCell(cell11);
		
		
		
		
		document.add(table11);
		/*Paragraph paragraph5 = new Paragraph();
		paragraph5.add(new Chunk("\nSub: Auto Renewal of Consent and / or Authorization - Submission of Self Certification-Reg    "));
		paragraph5.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph5);*/
		
		
		/*Paragraph paragraph6 = new Paragraph();
		paragraph6.add(new Chunk("\nRef: Consent issued by the Board vide letter No "+consentOrderNo+ " dated which  \n     is valid up to "+consentValidDate));
		paragraph6.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph6);*/
		
		/*Paragraph paragraph6 = new Paragraph();
		paragraph6.add(new Chunk("\nRef: Previous Consent for Operation Order and authorization issued on "+oldApplicationDate+"  \n     is valid up to "+validDate));
		paragraph6.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph6);
		
		Paragraph paragraph7 = new Paragraph();
		paragraph7.add(new Chunk("\nIt is to submit that the Board has issued Consent for Operation and Authorisation under Water(Prevention and Control of Pollution)Act, 1974 and Air(Prevention and Control of Pollution)Act, 1981 and Authorisation under Hazarous Waste(Management, Handling and Transboundary Movement)Rules, 2008 to our industry/ project vide order No "+oldIndApplicationNo+" with validity period upto "+validDate));
		paragraph7.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph7);
		
		Paragraph paragraph8 = new Paragraph();
		paragraph8.add(new Chunk("    \nWe are here certify that"));
		paragraph8.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph8);
		
		Paragraph paragraph9 = new Paragraph();
		paragraph9.add(new Chunk("    \n1. We have compiled with the conditions and standards stipulated in the consent order and Authorisation issued vide order date "+consentValidDate));
		paragraph9.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph9);*/
		
		/*Paragraph paragraph10 = new Paragraph();
		paragraph10.add(new Chunk("   \n2. The manufacturing process, raw material and product quality remains the same  as submitted vide our application No "+ oldApplication +" dated  "+oldApplicationDate ));
		paragraph10.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph10);*/
		
	/*	Paragraph paragraph10 = new Paragraph();
		paragraph10.add(new Chunk("   \n2. There is no change in information provide in the prescribed consent and Authorisation Application submitted for obtaining earlier Consent and Authorisation." ));
		paragraph10.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph10);*/
		
		/*Paragraph paragraph11 = new Paragraph();
		paragraph11.add(new Chunk("   \n3. The capital investment of the industry, as SPCB, Andhra vide above  referred consent was "+ industryProfile +"  (Rupees "+amountWords+" ). The Capitallnvestment for the proposed consent auto -renewal is  "+capInvestment +" (The change in capital investment,  if any, is only due to investments  in infrastructure development, clean technology, pollution control systems and better production management). "));
		paragraph11.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph11);*/
		
		/*Paragraph paragraph11 = new Paragraph();
		paragraph11.add(new Chunk("   \n3. There is no increase in production and / or pollution load."));
		paragraph11.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph11);*/
		
		/*Paragraph paragraph12 = new Paragraph();
		paragraph12.add(new Chunk("   \n4. There is no increase in production or pollution load than as referred in the  earlier consent granted vide letter no. "+consentOrderNo+" dated "+consentValidDate));
		paragraph12.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph12);*/
		
	/*	Paragraph paragraph12 = new Paragraph();
		paragraph12.add(new Chunk("   \n4. There are no fresh directions under 33 (A) of water (Prevention and Control of Pollution) Act and 31(A) of Air (Prevention and Control of Pollution) Act since last 3 months. "));
		paragraph12.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph12);
		
		Paragraph paragraph12a = new Paragraph();
		paragraph12a.add(new Chunk("   \n5. There are no pending directions from Courts/ Appellate Authority/ National Green Tribunal/ and Judicial Authority and there are no pending fresh cases from last 3 months."));
		paragraph12a.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph12a);
		
		Paragraph paragraph13 = new Paragraph();
		paragraph13.add(new Chunk("   \n6. There is no increase in Capital Investment / Except marginal increse of Rs. "+consentOrderNo+" (Which is less than 10%) for investment on Pollution Control System/ cleaner Production Technologies / Good Manufacturing Practices / Safety System. We are paying additional CFE and CFO fee on increased investment."));
		paragraph13.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph13);
				
		
		//new page starts here 
//		document.newPage();
		
		Paragraph paragraph16 = new Paragraph();
		paragraph16.add(new Chunk("   \n7. We undertake to comply with the conditions and standard stipulated in consent and Authorisation order and with any further conditions/ directions which may be stipulated by the Board in future and we may also pay fees / charges in future as demanded by the Board.\n\nIn view of fullfiling of the board conditions for Auto Renewal as certified by the above, we request to renew our Consent Order and Authorisation under Auto Reneal scheme for the period upto "+upTODate+" for which we are herewith paying consent fee of Rs. "+consentOrderNo+" as per latest Annual Report or audited balance sheet certified by the charted Accountant which was enclosed. "));
		paragraph16.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph16);*/
		
		
		
		
		
	/*	Paragraph paragraph19 = new Paragraph();
		paragraph19.add(new Chunk("      \nEncl: \n1. Fee details.\n2. Balance Sheet.\n3. Form-I (HW Authorization) "));
		paragraph19.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph19); */
		
	/*	Paragraph paragraph19a = new Paragraph();
		paragraph19a.add(new Chunk("      \nYours faithfully, "));
		paragraph19a.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph19a);
		
		Paragraph paragraph19aa = new Paragraph();
		paragraph19aa.add(new Chunk("      \nPlace: "));
		paragraph19aa.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph19aa);
		
		Paragraph paragraph19as = new Paragraph();
		paragraph19as.add(new Chunk(" Date: "));
		paragraph19as.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph19as); */
	
		document.add(space12);//used for space
		document.add(space12);//used for space
		
		/*Paragraph paragraph20 = new Paragraph();
		//paragraph20.add(new Chunk("\nSignature of occupier, Name \n and designation With phone \n and email address And Seal \n of the Company", new Font(Font.BOLD, Font.DEFAULTSIZE)));
		paragraph20.add(new Chunk("\n Name : "+occupierName+"\n Designation : "+designation+"   \n ", new Font(Font.BOLD, Font.DEFAULTSIZE)));
	//	paragraph19.add(new Font(Font.BOLD, Font.DEFAULTSIZE));
		paragraph20.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph20);
		
		document.add(space12);//used for space
		
		Paragraph paragraph19ac = new Paragraph();
		paragraph19ac.add(new Chunk("Note: In case of quantity applied exceeds the previous consented quantity, the application shall not be accepted. The applicant shall get a message that it is a case of enhancement and he may apply afresh."));
		paragraph19ac.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph19ac); */
		
		document.add(space12);//used for space
		
	/*	Paragraph paragraph19av = new Paragraph();
		paragraph19av.add(new Chunk("      ** In the case of Increse in the Capital Investment. "));
		paragraph19av.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph19av);*/
		
		
		
		
		document.close();
		return tempFile;
	}
}