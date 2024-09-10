//import java.awt.Color;
	import java.awt.Color;
	import java.io.*;
import java.util.ArrayList;

	import com.lowagie.text.*;
import com.lowagie.text.pdf.*;



public class EwasteScncCertificate {

		public File pdfgenerationSCNEwaste(String date,String indName, String indAddress,String indCity,
		String indDistrict, String appId,String appDate, String draftLetterDate,String role,
		String[] conditionsforEwaste,String[] referencesArray,String showCauseDays, String grpAddress, String region)throws Exception
				{
			File tempFile = new File("EwasteScnCerificate.pdf");

			try
			{
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, new FileOutputStream(tempFile));
			
			/*String headerStr = "Application no."*/
			Phrase headerPhrase = new Phrase ("");
			HeaderFooter header = new HeaderFooter(headerPhrase, true);
			header.setAlignment(Element.ALIGN_CENTER);
			document.setFooter(header);
			
			document.open();
			
			// For Space	    
		    Paragraph space = new Paragraph();
			space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
			space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
			space.setAlignment(Element.ALIGN_CENTER);
			
	        
	        
	        Image image1 = Image.getInstance("images2/ChhattisgarhECB.jpg");
			image1.scalePercent(80.0f);
			image1.setAlignment(Image.LEFT | Image.TEXTWRAP);
			document.add(image1);

			Image image2 = Image.getInstance("images2/SwarnajyantiLogo.jpg");
			image2.scalePercent(70.0f);
			image2.setAlignment(Image.RIGHT | Image.TEXTWRAP);
			image2.setIndentationRight(22);
			document.add(image2);

			document.add(space); 
	        
	      //For New Heading
			Paragraph heading1 = new Paragraph();
			heading1.add(new Chunk("HARYANA STATE POLLUTION CONTROL Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD,new Color(0,0,0))));
			heading1.setAlignment(Element.ALIGN_CENTER);
		    document.add(heading1);
			
		  //For New Heading
			Paragraph heading2 = new Paragraph();
			heading2.add(new Chunk(""+grpAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading2.setAlignment(Element.ALIGN_CENTER);
		    document.add(heading2);
		    
		    /*Paragraph partC11 = new Paragraph();
			partC11.add(new Chunk("PHONE:-0172-2577870-73,FAX-NO-2581201",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			partC11.setAlignment(Element.ALIGN_CENTER);
			document.add(partC11);*/
		    
		    
		    
		    document.add(space);
		    
		    Paragraph heading3 = new Paragraph();
			heading3.add(new Chunk("Application No. " +appId+
					"                                                                         Dated  "+draftLetterDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
			heading3.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading3);
		    
		    document.add(space);
		    
		    Paragraph heading5 = new Paragraph();
			heading5.add(new Chunk("To", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading5.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading5);
		    
		    document.add(space);
		    
		    Paragraph heading6 = new Paragraph();
			heading6.add(new Chunk("						M/s  "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading6.add(new Chunk("\n						Address "+indAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading6.add(new Chunk("\n						District  "+indDistrict, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading6.setAlignment(Element.ALIGN_JUSTIFIED);
		    document.add(heading6);
		    
		    document.add(space);
		    
		    Paragraph heading7 = new Paragraph();
			heading7.add(new Chunk("Subject: Show cause notice for refusal of authorization under E-Waste(Management) Rules, 2016.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
			heading7.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading7);
		    
		    document.add(space);
		    
		    Paragraph heading8 = new Paragraph();
			heading8.add(new Chunk("						Please refer to your application dated" + appDate+ " received on the Committee for Authorization under " +
					"E-Waste (Management) Rules, 2016", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading8.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading8);
		    
		    document.add(space);
		    
		    Paragraph heading9 = new Paragraph();
			heading9.add(new Chunk("						Accordingly, Show Cause Notice for refusal of authorization under above said Rules is issued for submitting " +
					"reply or to taking corrective measure for the deficiencies and incompletion in your application as per details given below:-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading9.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading9);
		    
	        /*document.add(space);*/
		    
		    /*Paragraph heading10 = new Paragraph();
			heading10.add(new Chunk("						Accordingly, Show Cause Notice for refusal of registration under above said rules is issued to reply or" +
					" to take corrective measures for the deficiencies and incompletion in your application as per details given below:-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading10.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading10);*/
		    
	        /*document.add(space);
		 // coding for save Conditios by saroj start
	        
	        Paragraph head291 = new Paragraph();
	    	head291.add(new Chunk(" Conditions For Ewaste: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	    	head291.setAlignment(Element.ALIGN_JUSTIFIED);
	    	head291.setAlignment(Element.ALIGN_LEFT);
	    	document.add(head291);
		    
		    document.add(space);
			
			
			List list11 = new List(true, 30);

			for (int refVar = 0; refVar < conditionsforEwaste.length; refVar++) {
				list11.add(new ListItem(conditionsforEwaste[refVar], new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			}

			document.add(list11);*/
			
			document.add(space);// code end......
		    
//start coding for general Deficiencies 		    
		    Paragraph heading15 = new Paragraph();
			heading15.add(new Chunk("General Deficiencies :"  
					, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading15.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading15);
		    
		    
		    List list = new List(true, 30);

			for (int refVar = 0; refVar < referencesArray.length; refVar++) {
				list.add(new ListItem(referencesArray[refVar], new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,Font.BOLD)));
			}
System.out.println("list"+list);
		    document.add(list);
		    document.add(space);// end code.........
		    
		    Paragraph heading12 = new Paragraph();
			heading12.add(new Chunk("						In case, you fail to submit reply or submit compliance of the deficiencies within " +showCauseDays+ " days then authorization under " +
					"rule 13 of E-Waste(Management) Rules, 2016 sought vide your above referred application, shall be refused due to the above deficiencies/incompletion in your application.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading12.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading12);
		    
		    document.add(space);

		    Paragraph heading10 = new Paragraph();
			heading10.add(new Chunk("						In future your unit/industry would be disposing the E-Waste at your own risk in violation of the above " +
					"said rules and rendering your unit liable for closure/legal action section 5/15 of Environment (Prevention) Act, 1986.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
			heading10.setAlignment(Element.ALIGN_LEFT);
		    document.add(heading10);

		    document.add(space);
		    
		    Paragraph heading13 = new Paragraph();
			heading13.add(new Chunk("Regional Officer " +region+
					"\nFor Haryana State Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD,new Color(0,0,0))));
			heading13.setAlignment(Element.ALIGN_RIGHT);
		    document.add(heading13);
		    
		    document.add(space);
		    
//		    Paragraph heading14 = new Paragraph();
//			heading14.add(new Chunk("---It is system generated certificate no signature is required---", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0,0,0))));
//			heading14.setAlignment(Element.ALIGN_CENTER);
//		    document.add(heading14);
//		 		    
			document.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
			}
	    	return tempFile;

		}	
	}
	
	
	
	
	
	
	
	
	
	


