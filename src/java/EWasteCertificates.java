	
	import java.awt.Color;
	import java.io.File;
	import java.io.FileOutputStream;
	import java.sql.Date;
	import java.util.ArrayList;
	//import java.util.Date ;
	import com.lowagie.text.Chunk;
	import com.lowagie.text.Document;
	import com.lowagie.text.Element;
	import com.lowagie.text.Font;
	import com.lowagie.text.HeaderFooter;
	import com.lowagie.text.Image;
	import com.lowagie.text.List;
	import com.lowagie.text.ListItem;
	import com.lowagie.text.PageSize;
	import com.lowagie.text.Paragraph;
	import com.lowagie.text.Phrase;
	import com.lowagie.text.pdf.PdfPCell;
	import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


	public class EWasteCertificates {
	
		public File generateNewCertificate(String indName,String indAddress,String indDistrict,String authNo,String draftDate,String issueDate,String expiryDate,String text21,String text22,String text23,String text24,String text41,String text42,String indId,String appId,String termsco,String copyTo)throws Exception
		{	File tempFile = new File("EWasteCertificate.pdf");
			try{
				
				Document document = new Document(PageSize.A4);
				document.setMargins(100, 36, 54, 36);
			    
				PdfWriter.getInstance(document,
						new FileOutputStream(tempFile));
						document.open();
						
					
						
						Image image = Image.getInstance("images2/jammu.jpg");
						image.scalePercent(50.0f);
						image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
						
						Image image1 = Image.getInstance("images2/jammu.jpg");
						image1.scalePercent(50.0f);
						image1.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
						document.add(image1);
						

						Paragraph space = new Paragraph();
						space.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 3, Font.BOLD)));
						space.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 1)));

						

					
						
						Paragraph heading51 = new Paragraph();
						heading51.add(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
						heading51.setAlignment(Element.ALIGN_CENTER);
						document.add(heading51);
						document.add(space);
						
						Paragraph heading5 = new Paragraph();
						heading5.add(new Chunk("AUTHORIZATION FOR GENERATION OR STORAGE OR TREATMENT OR REFURBISHING OR DISPOSAL OF E-WASTE BYMANUFACTUREER OR REFURBISHER", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
						heading5.setAlignment(Element.ALIGN_CENTER);
						document.add(heading5);
						document.add(space);
						
						Paragraph heading6 = new Paragraph();
						heading6.add(new Chunk("Ref: Your application for grant of authorisation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
						heading6.setAlignment(Element.ALIGN_CENTER);
						document.add(heading6);
						document.add(space);

						
						
						Paragraph partcc = new Paragraph();
						partcc.add(new Chunk("1.(a) Authorisation no. "+authNo+" and (b) date of issue "+draftDate+" .",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
						partcc.setAlignment(Element.ALIGN_LEFT);
						document.add(partcc);
						document.add(space);
						
						Paragraph partdd = new Paragraph();
						partdd.add(new Chunk("2. "+indName+" of "+indDistrict+" is hereby granted an authorisation for generation, storage, treatment, disposal of e-waste on the premises situated at "+indAddress+", "+indDistrict+" for the following:",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						partdd.setAlignment(Element.ALIGN_LEFT);
						document.add(partdd);
						
						Paragraph partdd1 = new Paragraph();
						partdd1.add(new Chunk("  a. quantity of e-waste" +text23,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						partdd1.setAlignment(Element.ALIGN_LEFT);
						document.add(partdd1);
						
						Paragraph partdd11 = new Paragraph();
						partdd11.add(new Chunk("  b. nature of e-waste" +text24,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						partdd11.setAlignment(Element.ALIGN_LEFT);
						document.add(partdd11);
						
						document.add(space);
						
						Paragraph partee = new Paragraph();
						partee.add(new Chunk("3. The authorisation shall be valid for a period from "+issueDate+" to "+expiryDate+" .",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
						
						partee.setAlignment(Element.ALIGN_LEFT);
						document.add(partee);
						document.add(space);
						
					
						
						Paragraph partff = new Paragraph();
						partff.add(new Chunk("4. The e-waste mentioned above shall be treated/disposed off in a manner "+text41+" at "+text42+" .",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
						partff.setAlignment(Element.ALIGN_LEFT);
						document.add(partff);
						document.add(space);
						
						
						Paragraph part1 = new Paragraph();
						part1.add(new Chunk("5. The authorisation is subject to the conditions stated below and such conditions as may be specified in the rules for the time being in force under the Environment(Protection) Act, 1986.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part1.setAlignment(Element.ALIGN_LEFT);
						document.add(part1);
						document.add(space);
						
						Paragraph part11 = new Paragraph();
						part11.add(new Chunk("Member Secretary" +
								"\n J&K Pollution Control Committee",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part11.setAlignment(Element.ALIGN_RIGHT);
						document.add(part11);
						document.add(space);
						
						Paragraph part11451 = new Paragraph();
						part11451.add(new Chunk("Date: "+draftDate,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part11451.setAlignment(Element.ALIGN_RIGHT);
						document.add(part11451);
						document.add(space);
						
						Paragraph part22 = new Paragraph();
						part22.add(new Chunk("Terms and conditions of authorisation",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part22.setAlignment(Element.ALIGN_CENTER);
						document.add(part22);
						document.add(space);
						
						Paragraph part222 = new Paragraph();
						part222.add(new Chunk("1. The authorisation shall comply with the provisions of the environment (protection) Act, 1986, and the rules made thereunder.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part222.setAlignment(Element.ALIGN_LEFT);
						document.add(part222);
						document.add(space);
						
						Paragraph part33 = new Paragraph();
						part33.add(new Chunk("2. The authorisation or its renewal shall be produced for inspection at the request of an officer authorized by the concerned State Pollution Control Committee.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part33.setAlignment(Element.ALIGN_LEFT);
						document.add(part33);
						document.add(space);
						
						Paragraph part44 = new Paragraph();
						part44.add(new Chunk("3. Any unauthorised change in personnel, equipment as working conditions as mentioned in the application by the person authorised shall constitute a breach of his authorisation.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part44.setAlignment(Element.ALIGN_LEFT);
						document.add(part44);
						document.add(space);
						
						Paragraph part55 = new Paragraph();
						part55.add(new Chunk("4. It is the duty of the authorised person to take prior permission of the concerned State Pollution Control Committee to close down the operations.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part55.setAlignment(Element.ALIGN_LEFT);
						document.add(part55);
						document.add(space);
						
						
						Paragraph part66 = new Paragraph();
						part66.add(new Chunk("5. An application for the renewal of an authorisation shall be made as laid down in sub-rule(vi) of rule 13(2).",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part66.setAlignment(Element.ALIGN_LEFT);
						document.add(part66);
						document.add(space);
						
						Paragraph part663 = new Paragraph();
						part663.add(new Chunk("Specific Condition:",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part663.setAlignment(Element.ALIGN_LEFT);
						document.add(part663);
						document.add(space);
						
						Paragraph part6683 = new Paragraph();
						part6683.add(new Chunk(" "+termsco,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6683.setAlignment(Element.ALIGN_JUSTIFIED);
						document.add(part6683);
						document.add(space);
						document.add(space);
						
						Paragraph part666ee7s1e = new Paragraph();
						part666ee7s1e.add(new Chunk("Copy To: ",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part666ee7s1e.setAlignment(Element.ALIGN_LEFT);
						document.add(part666ee7s1e);
						Paragraph part6ee7s1e = new Paragraph();
						part6ee7s1e.add(new Chunk(" "+copyTo,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part6ee7s1e.setAlignment(Element.ALIGN_LEFT);
						document.add(part6ee7s1e);
						document.add(space);
						document.add(space);
						Paragraph part666711 = new Paragraph();
						part666711.add(new Chunk("Member Secretary",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part666711.setAlignment(Element.ALIGN_RIGHT);
						document.add(part666711);
						Paragraph part6667113 = new Paragraph();
						part6667113.add(new Chunk("J&K Pollution Control Committee",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part6667113.setAlignment(Element.ALIGN_RIGHT);
						document.add(part6667113);
						document.add(space);
						Paragraph part66671313 = new Paragraph();
						part66671313.add(new Chunk("Dated "+draftDate,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part66671313.setAlignment(Element.ALIGN_RIGHT);
						document.add(part66671313);
						
						
						
						
						
						System.out.println("done................");
						document.close();
						
					
				
		    	}catch (Exception e) {
			e.printStackTrace();
			
		}
    	return tempFile;
		}
		
		public File generateNewCertificate1(String indName,String indAddress,String indDistrict,String authNo,String draftDate,String issueDate,String expiryDate, String text2,String text4,String indId,String appId,String termsco,String copyTo)throws Exception
		{	File tempFile = new File("EWasteCertificate.pdf");
			try{
				
				Document document = new Document(PageSize.A4);
				document.setMargins(100, 36, 54, 36);
			    
				PdfWriter.getInstance(document,
						new FileOutputStream(tempFile));
						document.open();
						
					
						
						Image image = Image.getInstance("images2/check.png");
						image.scalePercent(50.0f);
						image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
						
						
						Image image1 = Image.getInstance("images2/telanganalogo.png");
						image1.scalePercent(50.0f);
						image1.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
						document.add(image1);
						

						Paragraph space = new Paragraph();
						space.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 3, Font.BOLD)));
						space.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 1)));

						

					
						Paragraph heading51 = new Paragraph();
						heading51.add(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
						heading51.setAlignment(Element.ALIGN_CENTER);
						document.add(heading51);
						document.add(space);
						
						Paragraph heading5 = new Paragraph();
						heading5.add(new Chunk("Authorization for Collection, Storage and dismantling of E-Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
						heading5.setAlignment(Element.ALIGN_CENTER);
						document.add(heading5);
						document.add(space);
						
						Paragraph heading6 = new Paragraph();
						heading6.add(new Chunk("(Under rule 13(3)(VI) of e-Waste(Management) Rules, 2016)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
						heading6.setAlignment(Element.ALIGN_CENTER);
						document.add(heading6);
						document.add(space);

						
						
						Paragraph partcc = new Paragraph();
						partcc.add(new Chunk("Authorisation no:"+authNo+"            "+"   date of issue : "+draftDate,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
						partcc.setAlignment(Element.ALIGN_LEFT);
						document.add(partcc);
						document.add(space);
						Paragraph part78 = new Paragraph();
						part78.add(new Chunk("To\n"+indName+"\n"+indDistrict,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part78.setAlignment(Element.ALIGN_LEFT);
						document.add(part78);
						document.add(space);
						
						Paragraph partdd = new Paragraph();
						partdd.add(new Chunk("1. M/s "+indName+" is hereby granted Authorization as a collection cum dismantling/recycling facility for collection, storage and dismantling of e-waste at the premises situated at "+indAddress+", "+indDistrict,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						partdd.setAlignment(Element.ALIGN_LEFT);
						document.add(partdd);
						document.add(space);
						
						Paragraph partdd1 = new Paragraph();
						partdd1.add(new Chunk("2. The Authorisation is granted for collection, storage and Dismantling/Recycling of "+text2+".",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						partdd1.setAlignment(Element.ALIGN_LEFT);
						document.add(partdd1);
						document.add(space);
						
						Paragraph partee = new Paragraph();
						partee.add(new Chunk("3. The authorisation shall be valid for a period from "+issueDate+" to "+expiryDate+".",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
						
						partee.setAlignment(Element.ALIGN_LEFT);
						document.add(partee);
						document.add(space);
						
					
						
						Paragraph partff = new Paragraph();
						partff.add(new Chunk("4. The Authorisation is granted for collection off e-Waste from "+text4+" Districts. The authorisation shall not be treated exclusive right alone of the industry to collect e-Waste from above locations.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
						partff.setAlignment(Element.ALIGN_LEFT);
						document.add(partff);
						document.add(space);
						
						
						Paragraph part1 = new Paragraph();
						part1.add(new Chunk("5. The authorisation is granted for collection, storage and dismantling/recycling of e-Waste as prescribed under schedule-I of e-Waste rules 2016.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part1.setAlignment(Element.ALIGN_LEFT);
						document.add(part1);
						document.add(space);
						
						Paragraph part13 = new Paragraph();
						part13.add(new Chunk("6. The authorisation is subject to the conditions stipulated at Annexure-A and such conditions as may be specified in the rules for the time being in force under the Environment (Protection) Act, 1986.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part13.setAlignment(Element.ALIGN_LEFT);
						document.add(part13);
						document.add(space);
						
						Paragraph part11 = new Paragraph();
						
						part11.add(new Chunk("Member Secretary." +
								"\n J&K Pollution Control Committee",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part11.setAlignment(Element.ALIGN_RIGHT);
						document.add(part11);
						document.add(space);
		                
						Paragraph part11451 = new Paragraph();
						part11451.add(new Chunk("Dated: "+issueDate,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part11451.setAlignment(Element.ALIGN_RIGHT);
						document.add(part11451);
						document.add(space);
						
						document.newPage();
						Paragraph part22 = new Paragraph();
						part22.add(new Chunk("Terms and conditions of authorisation",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part22.setAlignment(Element.ALIGN_CENTER);
						document.add(part22);
						document.add(space);
						
						Paragraph part222 = new Paragraph();
						part222.add(new Chunk(" 1. The e-waste collection centre shall comply with the provisions of the Environment (Protection) Act, 1986, and E-Waste (Management) Rules, 2016.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part222.setAlignment(Element.ALIGN_LEFT);
						document.add(part222);
						document.add(space);
						
						Paragraph part33 = new Paragraph();
						part33.add(new Chunk(" 2. The application of this e-waste centre is processed based on the report submitted by Environmental Engineer, Regional Office, "+indDistrict+" and the information furnished by the proponent.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part33.setAlignment(Element.ALIGN_LEFT);
						document.add(part33);
						document.add(space);
						
						Paragraph part44 = new Paragraph();
						part44.add(new Chunk(" 3. The authorization shall be produced for inspection at the request of an officer authorized by the Uttar Pradesh Pollution Control Committee while storage, transport and dismantling of e-waste.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part44.setAlignment(Element.ALIGN_LEFT);
						document.add(part44);
						document.add(space);
						
						Paragraph part55 = new Paragraph();
						part55.add(new Chunk(" 4. The person/ collection centre authorized shall not rent, lend, sell, transfer or otherwise transport the ewastes without obtaining prior permission of the Committee.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part55.setAlignment(Element.ALIGN_LEFT);
						document.add(part55);
						document.add(space);
						
						
						Paragraph part66 = new Paragraph();
						part66.add(new Chunk(" 5. Any unauthorized change in personnel, equipment, working conditions as mentioned in the application by the person authorized shall constitute a breach of this authorization.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part66.setAlignment(Element.ALIGN_LEFT);
						document.add(part66);
						document.add(space);
						
						
						
						Paragraph part660 = new Paragraph();
						part660.add(new Chunk(" 6. It is the duty of the authorized person to take prior permission of the Committee to close down the operations.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part660.setAlignment(Element.ALIGN_LEFT);
						document.add(part660);
						document.add(space);
						
						Paragraph part661 = new Paragraph();
						part661.add(new Chunk(" 7. An application for the renewal of this authorization shall be made, as laid down in sub-rule (VI) of rule 13(3), i.e. 120 days before the expiry of this authorization.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part661.setAlignment(Element.ALIGN_LEFT);
						document.add(part661);
						document.add(space);
						
						Paragraph part662 = new Paragraph();
						part662.add(new Chunk(" 8. The collection centre shall provide / publish details such as address, telephone number/ helpline number, e-mail, etc.of the collection centre to the general public.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part662.setAlignment(Element.ALIGN_LEFT);
						document.add(part662);
						document.add(space);
						
						Paragraph part663 = new Paragraph();
						part663.add(new Chunk(" 9. The collection centre shall ensure that the e-waste collected by them is stored in a secured manner in the authorised premises till it is dismantled mechanically and to send residual waste to recycler.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part663.setAlignment(Element.ALIGN_LEFT);
						document.add(part663);
						document.add(space);
						
						Paragraph part664 = new Paragraph();
						part664.add(new Chunk("10. The applicant shall take all necessary steps to avoid inconvenience to the neighbors.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part664.setAlignment(Element.ALIGN_LEFT);
						document.add(part664);
						document.add(space);
						
						Paragraph part665 = new Paragraph();
						part665.add(new Chunk("11. The collection cum dismantling centre shall not carry out any recycling activity of e-waste.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part665.setAlignment(Element.ALIGN_LEFT);
						document.add(part665);
						document.add(space);
						
						Paragraph part666 = new Paragraph();
						part666.add(new Chunk("12. The collectioncentre cum dismantling shall ensure that the collected waste is not stored for more than 180 days. The collection centre shall not collect any waste other than e-waste as mentioned at Schedule-I.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part666.setAlignment(Element.ALIGN_LEFT);
						document.add(part666);
						document.add(space);
						
						Paragraph part667 = new Paragraph();
						part667.add(new Chunk("13. The collection cum dismantling centre shall ensure that no damage is causeed to the environment during storage and dismentling of e-waste.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part667.setAlignment(Element.ALIGN_LEFT);
						document.add(part667);
						document.add(space);
						
						
						Paragraph part668 = new Paragraph();
						part668.add(new Chunk("14. The collection centre cum dismantling shall preferably segregate e-waste into categories of IT & TE and Consumer electrical and electronics and shall store it in suitable racks / containers / bins. Height of the containers should be limited to 7 feet. Containers of appropriate size and shape shall be used for segragation of e-waste items to facilaitate effective handling operations.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part668.setAlignment(Element.ALIGN_LEFT);
						document.add(part668);
						document.add(space);
						
						Paragraph part6611 = new Paragraph();
						part6611.add(new Chunk("15. The shed area shall be covered and with impervious flooring.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6611.setAlignment(Element.ALIGN_LEFT);
						document.add(part6611);
						document.add(space);
						
						Paragraph part6622 = new Paragraph();
						part6622.add(new Chunk("16. The centre shall provide adequate facilities for handling / arresting leakages of compressor oils, CFCs / HCFCs in case of collection, storage and dismantling of goods like refrigerators and air conditioners.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6622.setAlignment(Element.ALIGN_LEFT);
						document.add(part6622);
						document.add(space);
						
						Paragraph part6633 = new Paragraph();
						part6633.add(new Chunk("17. The collection centre shall take care for proper packing of broken e-waste equipment during the storage, transportation and dismantling.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6633.setAlignment(Element.ALIGN_LEFT);
						document.add(part6633);
						document.add(space);
						
						Paragraph part6612 = new Paragraph();
						part6612.add(new Chunk("18. The collection centre shall be secured with boundary wall and security personnel.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6612.setAlignment(Element.ALIGN_LEFT);
						document.add(part6612);
						document.add(space);
						
						Paragraph part6666 = new Paragraph();
						part6666.add(new Chunk("19. The proponent shall fallow Rule No. 19 of E-Waste (Management) Rules, 2016 for transportation of e-waste.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6666.setAlignment(Element.ALIGN_LEFT);
						document.add(part6666);
						document.add(space);
						
						Paragraph part66333 = new Paragraph();
						part66333.add(new Chunk("20. The colletion centre shall send the residual e-waste to M/s. Eco Recycling Limited, Mumbai (recycler) through authorized transporter as per the e-waste rules.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part66333.setAlignment(Element.ALIGN_LEFT);
						document.add(part66333);
						document.add(space);
						
						Paragraph part6677 = new Paragraph();
						part6677.add(new Chunk("21. The colletion centre shall maintain records of the e-waste handled in Form - 2 and make such records available for scrutiny by the Committee.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6677.setAlignment(Element.ALIGN_LEFT);
						document.add(part6677);
						document.add(space);
						
						Paragraph part6699 = new Paragraph();
						part6699.add(new Chunk("22. The colletion centre shall file annual returns in Form - 3 to the Committee on or Before the 30th day of June following the financial year to which that return relates.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6699.setAlignment(Element.ALIGN_LEFT);
						document.add(part6699);
						document.add(space);
						
						
						Paragraph part6655 = new Paragraph();
						part6655.add(new Chunk("23. This authorisation is issued subject to obtaining required permissions from local authority / Fire safety Department and other relevant government departments, which are statutory requirement for carrying out the above activity.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6655.setAlignment(Element.ALIGN_LEFT);
						document.add(part6655);
						document.add(space);
						
						Paragraph part6688 = new Paragraph();
						part6688.add(new Chunk("24. The proponent shall comply with all the the directions issued by the Committee from time to time.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6688.setAlignment(Element.ALIGN_LEFT);
						document.add(part6688);
						document.add(space);
						
						Paragraph part6634 = new Paragraph();
						part6634.add(new Chunk("25. Concealing the factual data, submission of false information/ fabricated data and failure to comply with any of the conditions mentioned in this authorization may result in withdrawal of this authorization and attract action under the provisions of relevant pollution control Acts.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6634.setAlignment(Element.ALIGN_LEFT);
						document.add(part6634);
						document.add(space);
						
						
						Paragraph part6645 = new Paragraph();
						part6645.add(new Chunk("26. The Committee reserves its ightto modify above conditions or stipulate any further conditions in the interest of environmental protection.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6645.setAlignment(Element.ALIGN_LEFT);
						document.add(part6645);
						document.add(space);
						
						
						Paragraph part6667 = new Paragraph();
						part6667.add(new Chunk("27. The Committee is empowered to suspend or cancel the authorization in case of non compliance of conditions of the authorisation or with any provisions of Environment (Protection) Act or e-waste Rules.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6667.setAlignment(Element.ALIGN_LEFT);
						document.add(part6667);
						document.add(space);
						
						Paragraph part66671 = new Paragraph();
						part66671.add(new Chunk("28. This order is issued without prejudice to the rights of the rights of this Committee in any court of law.",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part66671.setAlignment(Element.ALIGN_LEFT);
						document.add(part66671);
						document.add(space);
						
						
						Paragraph part66671e = new Paragraph();
						part66671e.add(new Chunk("Specific Condition: ",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part66671e.setAlignment(Element.ALIGN_LEFT);
						document.add(part66671e);
						document.add(space);
						
						Paragraph part6667s1e = new Paragraph();
						part6667s1e.add(new Chunk(" "+termsco,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6667s1e.setAlignment(Element.ALIGN_JUSTIFIED);
						document.add(part6667s1e);
						document.add(space);
						document.add(space);
						
						Paragraph part666ee7s1e = new Paragraph();
						part666ee7s1e.add(new Chunk("Copy To: ",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part666ee7s1e.setAlignment(Element.ALIGN_LEFT);
						document.add(part666ee7s1e);
						Paragraph part6ee7s1e = new Paragraph();
						part6ee7s1e.add(new Chunk(" "+copyTo,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
						part6ee7s1e.setAlignment(Element.ALIGN_LEFT);
						document.add(part6ee7s1e);
						document.add(space);
						document.add(space);
						
						Paragraph part666711 = new Paragraph();
						part666711.add(new Chunk("Member Secretary",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part666711.setAlignment(Element.ALIGN_RIGHT);
						document.add(part666711);
						Paragraph part6667113 = new Paragraph();
						part6667113.add(new Chunk("J&K Pollution Control Committee",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part6667113.setAlignment(Element.ALIGN_RIGHT);
						document.add(part6667113);
						document.add(space);
						Paragraph part66671313 = new Paragraph();
						part66671313.add(new Chunk("Dated "+issueDate,
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
						part66671313.setAlignment(Element.ALIGN_RIGHT);
						document.add(part66671313);
						
						
						
						System.out.println("done................");
						document.close();
						
					
				
		    	}catch (Exception e) {
			e.printStackTrace();
			
		}
    	return tempFile;
		}
}
	