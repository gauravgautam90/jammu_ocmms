import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;



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
public class GenerateBMWAuth {
	public File bioCertRenew(String draftLetterFor, ArrayList catListDetails,String industryName,String industryAddress,String industryTehsil,
			String industryDistrict,String nameOfDistrict,String authorizationNumber,String letternumber,
			String noticeDate,String copyTo,ArrayList chk,String authPer, String noOfBeds,
			String noOfsamples,String noOfSamples,String noOfpatients,String noOfPatients,
			String expiryDate,String activityauthorizationsoughtfor, String subject,String appDate, 
	       String catinst,String noOfchairs,String noOfbeds,String occName,String offAddres,
			String addrPlaceDisposalOfWaste,String termsco, String draftLetterDate,
			 String reference,String roleName1,String appId,String dateofsubmition, String name,
			 String nameind,String address,String date,String offname,String offdesg,String renewFrom,
			 String renewTo,String officername,Boolean generation,Boolean collection,Boolean storage,Boolean transportation,Boolean reception,
				Boolean reuse,Boolean recycling,Boolean recovery,Boolean preprocessing,Boolean coprocessing,
				Boolean treatment,Boolean disposal,Boolean incineration,Boolean utilisation, String facility,String serviceProvider,
				String collected,String authCancelled,ArrayList inspectionDataList,String authorisationAppliedFor)throws Exception {
				{	File tempFile = new File("certificate.pdf");
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

		
		ArrayList<AbcData> ee= new ArrayList<AbcData>();
		ee.add(new AbcData("pH","6.5 to 9.0"));
		ee.add(new AbcData("Suspended Solids","100 mg/l."));
		ee.add(new AbcData("Oil & Grease","10 mg/l"));
		ee.add(new AbcData("BOD","30 mg/l"));
		ee.add(new AbcData("COD	","250 mg/l"));
		ee.add(new AbcData("Bio-assay test","90%survival of fish after 96 hours in 100% effluent"));
		
		String hcftypee="";
		if(inspectionDataList.get(1).toString().equals("HCF")){
			hcftypee=inspectionDataList.get(2).toString();
			System.out.println("--HCF menu-"+hcftypee);
		}else{
			System.out.println("--HCF 3 menu-"+hcftypee);
			hcftypee="";
		}
		
		
		Paragraph space = new Paragraph();
		space.add(new Chunk("                                          ",
				new Font(Font.NORMAL, Font.DEFAULTSIZE, Font.BOLD)));
		space.setAlignment(Element.ALIGN_CENTER);
		document.add(space);

		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J&K Pollution Control Committee JAMMU",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		
		 heading = new Paragraph();
		heading.add(new Chunk("JAMMU/SRINAGAR (www.jkspcb.nic.in)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Bio-Medical Waste Authorization",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Authorization No-" +authorizationNumber+"                                                																								Date- "+date,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.BOLD)));
		heading.setAlignment(Element.ALIGN_LEFT);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"1.	Authorization is granted under Rule 10 of the Bio-medical Waste Management Rules, 2016. ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);

		document.add(space);
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"2.	Sh./Smt.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));
		heading
		.add(new Chunk(
				" "+occName,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading
		.add(new Chunk(
				" of M/s ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading
		.add(new Chunk(
				""+industryName,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading
		.add(new Chunk(
				" is hereby granted an authorization based on the enclosed signed inspection report  for  ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading
		.add(new Chunk(
				" "+inspectionDataList.get(1).toString()+"/"+hcftypee,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading
		.add(new Chunk(
				" (Type of Health C are facility as per order dt.  17/12/2018) on the premises situated at village ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);

		document.add(space);

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Detail of Authorization",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
		
		PdfPTable table01= new PdfPTable(3);
		table01.setWidthPercentage(70);
		
		float[] widths = new float[] {40f, 40f,40f};
		table01.setWidths(widths);
		
		PdfPCell celltable = new PdfPCell();
		celltable = new PdfPCell(new Paragraph(new Chunk("Authorization Required for ", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		celltable.setHorizontalAlignment(Element.ALIGN_LEFT);
		celltable.setVerticalAlignment(Element.ALIGN_LEFT);
		celltable.setPadding(3.0f);
		celltable.setBorderColor((Color.BLUE));
		table01.addCell(celltable);
		
		
		 celltable = new PdfPCell();
		celltable = new PdfPCell(new Paragraph(new Chunk("Type of Health Care Facility", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		celltable.setHorizontalAlignment(Element.ALIGN_LEFT);
		celltable.setVerticalAlignment(Element.ALIGN_LEFT);
		celltable.setPadding(3.0f);
		celltable.setBorderColor((Color.BLUE));
		table01.addCell(celltable);
		
		
		
		 celltable = new PdfPCell();
		celltable = new PdfPCell(new Paragraph(new Chunk("Category/Quantity (Per day )", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		celltable.setHorizontalAlignment(Element.ALIGN_LEFT);
		celltable.setVerticalAlignment(Element.ALIGN_LEFT);
		celltable.setPadding(3.0f);
		celltable.setBorderColor((Color.BLUE));
		table01.addCell(celltable);
		System.out.println("--inspectionDataList---"+inspectionDataList.toString());
	
			celltable = new PdfPCell(new Paragraph(new Chunk(""+inspectionDataList.get(0).toString(), new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
					celltable.setHorizontalAlignment(Element.ALIGN_LEFT);
					celltable.setVerticalAlignment(Element.ALIGN_LEFT);
					celltable.setPadding(3.0f);
					celltable.setBorderColor((Color.BLUE));
					table01.addCell(celltable);
					celltable = new PdfPCell(new Paragraph(new Chunk(""+inspectionDataList.get(1).toString()+"/"+hcftypee, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
							celltable.setHorizontalAlignment(Element.ALIGN_LEFT);
							celltable.setVerticalAlignment(Element.ALIGN_LEFT);
							celltable.setPadding(3.0f);
							celltable.setBorderColor((Color.BLUE));
							table01.addCell(celltable);
							
									String CSV=inspectionDataList.get(3).toString();
									System.out.println(CSV);
									String[] values = CSV.split("\\s*,\\s*");
									System.out.println("--------"+values.toString());
									PdfPTable ss= new PdfPTable(1);
									PdfPCell cell009= new PdfPCell();
									for(int i=0;i<values.length;i++ )
									{
										
										cell009 = new PdfPCell(new Paragraph(new Chunk(""+values[i], new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
										cell009.setHorizontalAlignment(Element.ALIGN_LEFT);
										cell009.setVerticalAlignment(Element.ALIGN_LEFT);
										cell009.setPadding(3.0f);
										cell009.setBorderColor((Color.BLUE));
											ss.addCell(cell009);
			
									}
									table01.addCell(ss);
		
		document.add(table01);
		
		
		
		document.add(space);
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"3.	The authorization shall be valid for a period upto "+expiryDate,
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		

		heading = new Paragraph();
		heading
				.add(new Chunk(
						"4.	The authorization is subject to the following general and specific conditions:-  ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"The Board has scrutinized the information furnished by you and the proposal for management & handling of 	Bio-Medical Waste generated at your location mentioned below.  After a careful consideration, it has been 	decided to grant authorization "+authorisationAppliedFor+" under the Bio-medical Waste 	Management Rules, 2016 (herein after to be called as BMWM Rules) for a period and premises mentioned 	in this authorization ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.NORMAL)));
		heading
		.add(new Chunk(
				" "+authorisationAppliedFor,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading
		.add(new Chunk(
				" under the Bio-medical Waste 	Management Rules, 2016 (herein after to be called as BMWM Rules) for a period and premises mentioned 	in this authorization.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
				.add(new Chunk(
						"Terms and Conditions of Authorization:- ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
								Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"i)	The authorization shall comply with the provisions of the Environment (Protection) Act, 1986, and the rules made there under.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"ii)	The authorization or its renewals shall be produced for inspection at the request of an officer 	authorised by the prescribed authority",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iii)	The person authorized shall not rent, lend, sell, transfer or otherwise transport the bio-medical 	wastes 	without obtaining prior permission of the prescribed authority.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iv)	Any unauthorized change in personnel, equipment or working conditions as mentioned in the 	application by the person authorized shall constitute a breach of this authorization.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"v)	It is the duty of the authorized person to take prior permission of the prescribed authority to close 	down the facility",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"Additional Terms and Conditions of Authorization ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		document.add(space);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"6.	Treatment & Disposal of Bio-Medical Waste ((herein after to be called as BMW).",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"i)	Waste shall be treated & disposed off in accordance with specified Schedule- I of the rules and in compliance with the standards prescribed in Schedule- II.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"ii) The applicant where required,  shall set up requisite Bio-Medical Waste pre- treatment facilities 	like autoclave / microwave system, shredder & Sewage / Effluent treatment plant  for treatment 	of waste and ensure treatment of waste at a Common  Bio- Medical  Waste Treatment Facility 	(herein after to be called as CBMWTF). ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iii)	The chemical liquid waste as defined in Schedule- I, after resource recovery (wherever required) 	shall be pre-treated before mixing with other wastewater. The combined discharge shall conform to the 	discharge norms given in Schedule-II.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iv)	Standards for incinerator / plasma pyrolysis or gasification / autoclaving / microwaving / deep burial / chemical disinfection etc., are as specified in Schedule-II of the BMWM Rules, 2016.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"7.     Effluent Standards:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"The effluent generated or treated from the premises of occupier or operator of a common bio-medical waste treatment and disposal facility, before discharge into the sewer, should conform to the following limits: ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		document.add(space);
		
		PdfPTable kk= new PdfPTable(2);
		PdfPCell cell003=  new PdfPCell();
		
		kk.setWidthPercentage(70);
		
		float[] widthss = new float[] {40f, 40f};
		kk.setWidths(widthss);
		
		
		cell003 = new PdfPCell(new Paragraph(new Chunk("Parameters ", new Font(
		Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
		cell003.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell003.setVerticalAlignment(Element.ALIGN_LEFT);
		cell003.setPadding(3.0f);
		cell003.setBorderColor((Color.BLUE));
		kk.addCell(cell003);
		
		  cell003 = new PdfPCell(new Paragraph(new Chunk("Maximum Permissible Ltd.", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
				cell003.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell003.setVerticalAlignment(Element.ALIGN_LEFT);
				cell003.setPadding(3.0f);
				cell003.setBorderColor((Color.BLUE));
				kk.addCell(cell003);
		
				for(int i=0;i<ee.size();i++){
					  cell003 = new PdfPCell(new Paragraph(new Chunk(""+ee.get(i).col1, new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
								cell003.setHorizontalAlignment(Element.ALIGN_LEFT);
								cell003.setVerticalAlignment(Element.ALIGN_LEFT);
								cell003.setPadding(3.0f);
								cell003.setBorderColor((Color.BLUE));
								kk.addCell(cell003);
								  cell003 = new PdfPCell(new Paragraph(new Chunk(""+ee.get(i).col2, new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
											cell003.setHorizontalAlignment(Element.ALIGN_LEFT);
											cell003.setVerticalAlignment(Element.ALIGN_LEFT);
											cell003.setPadding(3.0f);
											cell003.setBorderColor((Color.BLUE));
											kk.addCell(cell003);
					
				}
		document.add(kk);
		
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"i.	Sludge from Effluent Treatment Plant shall be given to common bio-medical waste treatment facility for incineration or to hazardous treatment, storage and disposal facility for disposal.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"ii.	For discharge into public sewers with terminal facilities, the general standards as notified under the E(P) Act, 1986 (29 of 1986) shall be applicable",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"8.Segregation & Storage of Bio-Medical Wastes",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"i)		 BMW treated/untreated shall not be mixed with other wastes and shall not be disposed off with 	Municipal Solid Waste. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"ii)		BMW shall be segregated into containers/bags at the point of generation in accordance with the 	specified Schedule-I, prior to its storage, transportation, treatment and disposal. The 	containers/bags shall be labeled as specified in Schedule-IV. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iii)		Provision within the premises shall be made for a safe, ventilated and secured  location for storage 	of segregated biomedical waste in colored bags or containers in the manner as specified above, to 	ensure that there shall be no secondary handling, pilferage of recyclables or inadvertent scattering 	or spillage by animals and the BMW from such place or premises shall be directly transported in 	the manner as prescribed in these rules to the CBMWTF or for the appropriate treatment and 	disposal, as the case may be, in the manner as prescribed in Schedule ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iv)    At the storage site “Bio-Medical Waste Storage Site” & “Danger” signboards shall be 	prominently     displayed.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"v)       The applicant shall take all steps to ensure that such BMW is handled without any adverse effect to 	human health and the environment ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"vi)			The containers for storing segregated wastes shall be clearly identifiable. Colour coding of waste 	categories with multiple treatment options as defined in Schedule I (Part-1), shall be selected 	depending on treatment option chosen. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"vii)   	No untreated BMW shall be kept stored beyond a period of 48 hours provided that if for any reason 	it becomes necessary to store the waste beyond such period, the authorised person must take 	permission of the prescribed authority and take measures to ensure that the waste does not 	adversely affect human health and the environment and in this regard shall designate a cold 	storage space.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"9.          	 	Transportation of Bio-Medical Waste:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"i)			If a container is transported from the premises where BMW is generated to any waste treatment facility outside the premises, the container shall, apart from the label prescribed in Schedule IV (Part - A) of the rules, also carry information prescribed in Schedule IV of the rules.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"ii)	Untreated BMW shall be transported only in such vehicles as may be authorised for the purpose by the competent authority. The transport vehicles shall be prominently labeled as per symbols shown in Schedule IV (Part - B) of the rules.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"10.    General Conditions:-",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"1)	Provide training to all its health care workers and others, involved in handling of BMW at the time of induction and there after at least once in every year and the details of training programmes conducted, number of personnel trained and number of personnel not undergone any training, shall be provided in the Annual Report. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"2)	Immunize all the health care workers and others, involved in handling of BMW for protection against diseases including hepatitis B and tetanus in the manner as prescribed in the National Immunisation Policy or the guidelines of the Ministry of Health and Family Welfare, issued from time to time.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"3)	Ensure occupational safety of all health care workers and others involved in handling of BMW by providing appropriate and adequate Personnel Protective Equipments (PPE).",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"4)	Conduct health check up at the time of induction and at least once in a year for all its health care workers and others involved in handling of BMW and maintain the record for the same.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"5)	Maintain an update on day to day basis  the BMW register and display the monthly record on its website according to the BMW generated in terms of  category and color coding, as specified in Schedule I.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"6)	Establish a system to review and monitor the activities related to BMWM,  either through an existing committee or by forming a new committee and the committee shall meet once in every six months and the record of the minutes of the meeting of this committee shall be submitted along with the annual report to the prescribed authority and the health care facilities having less than thirty beds shall designate a qualified person to review and monitor activities relating to BMWM within that facility and submit the annual report.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"7)	When any accident occurs at any institution or facility or any other site where BMW is handled or during transportation of such waste, the authorised person shall report the accident in Form I of the rules to the Board forthwith.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"8)	Every applicant shall maintain records related to the generation, collection, reception, storage, transportation, treatment, disposal and/or any form of handling of BMW in accordance with these rules and any guidelines issued.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"9)	All records shall be subject to inspection and verification by the Board at any time.  ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"10)	Every applicant shall submit an annual report in Form – IV on or before 30th June every year for the period from January to December, which shall include information about the categories & quantities, of BMW handled during the preceding year.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"11)  The applicant shall be required to obtain the following from the Board (which ever is applicable)  ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"i) 	The Hazardous & Other waste (Management & Trans boundary Movement) Rules,2016",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"ii)  To return used batteries to authorized dealers, as per the Batteries (Management   & Handling) 	Rules, 2001 and amendments thereof. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"iii) The authorization granted shall lapse at any time, if the facility does not demonstrate the 	parameters, as required under rules or any condition of this authorisation order is not complied 	with.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"11. Specific Conditions:- ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"1.	To make a provision within the premises for a safe, ventilated and secured location for storage of segregated bio-medical waste in colored bags or containers in the manner as specified in Schedule I",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"2.	To establish a Bar-Code System for bags or containers containing bio-medical waste to be sent out of the premises or place  for any purpose ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"3. 	Not to use chlorinated plastic bags, gloves, (excluding blood bags) and mercury equipments such as thermometer, B.P apparatus etc.  ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"4.  	Not to dispose off treated bio- medical waste with municipal solid waste.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"5.    To pre-treatment the Laboratory Waste, Microbiological Waste, Blood samples and Blood bags through disinfection or sterilization on site in the manner as prescribed by the World Health Organization (WHO) guidelines on safe management of wastes from Health Care activities and WHO Blue Book, 2004 and then sent to the CBMWTF for final disposal. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"6.    To install Autoclave / Microwave for pre-treatment of Laboratory Waste, Microbiological Waste, blood samples, plastic tubes & glassware before disposal and submit photographic proof within three months.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"7.   		To ensure treatment and disposal of liquid waste in accordance with the Water (Prevention 			and Control of Pollution) Act, 1974.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
	
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"8. 	The Proprietor should apply 60 days in advance for renewal of authorization before the  expiry of same.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(
				"Terms & Conditions of Authorization :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		heading = new Paragraph();
		heading
		.add(new Chunk(
				""+termsco,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk("”This Authorization is issued purely from environmental angle and the Board shall not be responsible for any claim, ownership, proprietorship etc. of the facility”.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		
		heading = new Paragraph();
		heading
		.add(new Chunk(" “By Order” ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);
		document.add(heading);
		document.add(space);
		
		PdfPTable table31=new PdfPTable(2);
		
		PdfPCell cell31 = new PdfPCell ();
		
		float[] columnWidths31 = { 1f,1f };
		table31.setWidths(columnWidths31);
		table31.setWidthPercentage(100);
		
		cell31 = new PdfPCell (new Paragraph (new Chunk("Date: "+date+"\nPlace: "+offAddres, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE ))));
		cell31.setHorizontalAlignment (Element.ALIGN_LEFT);
		cell31.setBorder(PdfPCell.NO_BORDER);
		cell31.setPadding (5.0f);
		table31.addCell (cell31);
		
		cell31 = new PdfPCell (new Paragraph (new Chunk(""+officername+"\n"+"Regional Director" +
				"", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1))));
		cell31.setHorizontalAlignment (Element.ALIGN_RIGHT);
		cell31.setBorder(PdfPCell.NO_BORDER);
		cell31.setPadding (5.0f);
		table31.addCell (cell31);
		
		
		document.add(table31);
		
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk("										If the applicant fails to comply with the terms and conditions and other directives issued by this Board as laid down in this order, the applicant is liable for prosecution under Section 15 of the Environment (Protection) Act 1986 and other penal provisions of the Act and shall on conviction be liable for punishment and imprisonment as provided in the said Act.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk("Copy to the:- ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.BOLD)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk(" "+copyTo,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		/*heading = new Paragraph();
		heading
		.add(new Chunk("1.Regional Director, J&K SPCB "+officername +" for information. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk("2.	Director, Health Service(J&K)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk("3.  Divisional Officer, J&K SPCB, with the direction to monitor the compliance as specified is the Authorization issued, under the BMW Rules, 2016. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		
		heading = new Paragraph();
		heading
		.add(new Chunk("4. P. A to Chairman, J&K SPCB for information of the Chairman. ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
						Font.NORMAL)));
		heading.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(heading);
		document.add(space);
		*/
		
		
		document.add(space);
		document.close();
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("-----Exception Occured---------");
			e.printStackTrace();
		}
		return tempFile;
		
	}
	
	
	

	}
	
	class AbcData{
		String col1;
		String col2;
		public String getCol1() {
			return col1;
		}
		public void setCol1(String col1) {
			this.col1 = col1;
		}
		public String getCol2() {
			return col2;
		}
		public void setCol2(String col2) {
			this.col2 = col2;
		}
		public AbcData(String col1, String col2) {
			super();
			this.col1 = col1;
			this.col2 = col2;
		}
		
		
	}

}
