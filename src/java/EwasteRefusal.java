import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

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


public class EwasteRefusal {


public File ewasteCertRefusal(String industryName,String industryAddress,
		String industryDistrict,String date,String indRegMasId,String indApplId,String number,String copyTo,String termsco) throws Exception {
	{	
		
		//File tempFile = new File("certificate.pdf");
		//String cont = "/home1/Documents/UP_Documents/" +indRegMasId+"/";
		File tempFile = new File("_ERefusalCertificate.pdf");
		try{
		
	Document document = new Document(PageSize.A4);

    
	PdfWriter.getInstance(document,
			new FileOutputStream(tempFile));
		

			
			Phrase footerPhrase = new Phrase ("",new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE-2));
			HeaderFooter footer = new HeaderFooter(footerPhrase, true);
			footer.setAlignment(Element.ALIGN_CENTER);
			document.setFooter(footer);
			document.open();
                                                 
			//SAURAV CODE FOR BIO MEDICAL WASTE
			
		
			


			
            Paragraph space1 = new Paragraph();
    		space1.add(new Chunk("\n", new Font(Font.TIMES_ROMAN,
    				Font.DEFAULTSIZE + 1)));
    		document.add(space1);//used for space
    		
    		
    		
    		document.add(space1);
    		
    		
    		Paragraph space = new Paragraph();
    		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
    		space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
    		space.setAlignment(Element.ALIGN_CENTER);
    		
    		
    		Image image1 = Image.getInstance("images2/telanganalogo.png");
			image1.scalePercent(30.0f);
			image1.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
			document.add(image1);
    		
    		
    		///============Air===========
    		
    		document.add(space1);
    		document.add(space1);
    		
    		Paragraph partCb = new Paragraph();
    		partCb.add(new Chunk("J&K Pollution Control Committee",
    				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
    		partCb.setAlignment(Element.ALIGN_CENTER);
    		document.add(partCb);
    		document.add(space1);
    		document.add(space1);

    		Paragraph videNo = new Paragraph();

    		
    		videNo.add(new Chunk("1.Ref No :", new Font(Font.TIMES_ROMAN,
    				Font.DEFAULTSIZE , Font.BOLD)));
    		videNo.add(new Chunk("" +number, new Font(
    				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    		videNo.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
    				Font.DEFAULTSIZE , Font.BOLD)));
    		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
    				Font.DEFAULTSIZE , Font.BOLD)));
    		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
    				Font.DEFAULTSIZE , Font.BOLD)));
    		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
    				Font.DEFAULTSIZE + 1, Font.BOLD)));
    		videNo.add(new Chunk("Dated: " + date, new Font(
    				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));

    		

    		document.add(videNo);
    		
    		
    		document.add(space1);
    		
    		Paragraph formName1 = new Paragraph();		
    		formName1.add(new Chunk("To,", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE ,Font.BOLD)));
    		formName1.setAlignment(Element.ALIGN_LEFT);	
    		document.add(formName1);
    		
    		Paragraph formName2 = new Paragraph();		
    		formName2.add(new Chunk("        M/S "+industryName +
    				"\n        " +
    				"\n        ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
    		formName2.setAlignment(Element.ALIGN_LEFT);	
    		document.add(formName2);
    		document.add(space1);
    				
    		
    		Paragraph a = new Paragraph();		
    		a.add(new Chunk("Sub :      Authorization under the provisions of E-Waste Management Rules, 2016 as " +
    				"\n                amended", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
    		a.setAlignment(Element.ALIGN_LEFT);	
    		document.add(a);
    		document.add(space1);
    		
    		Paragraph a1 = new Paragraph();		
    		a1.add(new Chunk("Reference of application(Number and Date) : "+indApplId+", "+date, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
    		a1.setAlignment(Element.ALIGN_LEFT);	
    		document.add(a1);
    		document.add(space1);
    		
    		Paragraph a3 = new Paragraph();		
    		a3.add(new Chunk("Sir, " +
    				"\n      with reference to your application as mentioned above of M/s "+industryName+" is hereby refused Authorization based on the following grounds:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0)));
    		a3.setAlignment(Element.ALIGN_LEFT);	
    		document.add(a3);
    		document.add(space1);
    		
    		Paragraph a4 = new Paragraph();		
    		a4.add(new Chunk("Reasons:-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD)));
    		a4.setAlignment(Element.ALIGN_LEFT);	
    		document.add(a4);
    		document.add(space1);
    	    
    		Paragraph a5 = new Paragraph();		
    		a5.add(new Chunk(termsco, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0)));
    		a5.setAlignment(Element.ALIGN_LEFT);	
    		document.add(a5);
    		document.add(space1);
    		
    		Paragraph a6 = new Paragraph();		
    		a6.add(new Chunk("(Authorized Signatory)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,Font.BOLD)));
    		a6.setAlignment(Element.ALIGN_RIGHT);	
    		document.add(a6);
    		document.add(space1);
    		
    		Paragraph mem = new Paragraph();
    		mem.add(new Chunk("      ( Authorized Signatory )",
    				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
    		mem.setAlignment(Element.ALIGN_RIGHT);
    		document.add(mem);
    		
    		document.add(space1);
    		document.add(space1);
    		
    		Paragraph mem1 = new Paragraph();
    		mem1.add(new Chunk("J&K Pollution Control Committee ",
    				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
    		mem1.setAlignment(Element.ALIGN_RIGHT);
    		document.add(mem1);
    		
    		document.add(space1);
    		document.add(space1);
    		
    		Paragraph toAddress1 = new Paragraph("Copy to: To the Regional Officer, J&K Pollution Control Committee, "+copyTo+" for information and  necessary action .");
    		document.add(toAddress1);
    		
    		Paragraph copYtoo1 = new Paragraph();
    		copYtoo1.add(new Chunk("", new Font(
    				Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
    		copYtoo1.setIndentationLeft(20);
    		
    		document.add(copYtoo1);
    		document.add(space1);

														
												      
			
	
	document.close();
		
		}catch (Exception e) {
		e.printStackTrace();
		}
	
	return tempFile;
	}




}
}
