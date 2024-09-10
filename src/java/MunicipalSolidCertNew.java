import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class MunicipalSolidCertNew {

	public File municipalCert(String industryPhone,String industryName,String industryAddress,String industryTehsil,String industryDistrict,String authorizationNumber,String letternumber,String noticeDate,String terms,String copyTo,String id) throws Exception {
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading = new Paragraph();
		heading.add(new Chunk("CHHATISGARH ENVIRONMENT CONSERVATION BOARD",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);
		
		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("1-Tilak Nagar , Shiv Mandir Chowk , Main Road , Avanti Vihar , Raipur(C.G)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		
		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		
		document.add(space12);

		Paragraph videNo = new Paragraph();
		
		videNo.add(new Chunk("No :", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +letternumber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk(industryDistrict+" ,Dated:" + noticeDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNo);
		
		Paragraph toAddress = new Paragraph("To,");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);
		
		document.add(space12);
		
		Paragraph indName = new Paragraph("Commissioner /Chief Municipal Officer ");
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);
		
		indName = new Paragraph("Municipal Corporation/ Council, ");
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);
		
		indName = new Paragraph("District-  "+industryDistrict);
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);
		
		document.add(space12);
		
		Paragraph subject = new Paragraph("Sub :-");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(subject);
		
		Paragraph sub = new Paragraph();
		sub.add(new Chunk("Grant of the Authorization under rule 6 (3) of the Municipal soild wastes (Management and Handling) Rules 2000. ",
				new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		
		sub.setIndentationLeft(20);
		sub.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(sub);
		
		document.add(space12);
		
		Paragraph ref = new Paragraph();
		ref.add(new Chunk("Ref :- ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		ref.add(new Chunk("Your Application no.",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		ref.add(new Chunk("  " +id, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		ref.add(new Chunk(" Dated ",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		ref.add(new Chunk(noticeDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		
		ref.setIndentationLeft(20);
		ref.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(ref);
		
		document.add(space12);
		document.add(space12);
		
		Paragraph Body = new Paragraph();
		Body.add(new Chunk("The Chhattisgarh Environment Conservation Board after examining the proposal hereby authorizes Municipal Corporation/Council District " +industryDistrict+ " having their administrative office at "+ industryName +" "+ industryAddress+ " District " +industryDistrict + "(C.G.) to set up and operate waste processing/waste disposal facility at Village , P.H. "+industryPhone+" Khasara No.-Rakba- Tehsil " +industryTehsil+" District " + industryDistrict+"(C.G.), from the date of issue of this authorization letter on the terms and conditions (including the standards to comply) attached to this authorization letter.  ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE )));
		Body.setFirstLineIndent(20);
		Body.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(Body);
		 
		document.add(space12);
		
		Paragraph one = new Paragraph();
		one.add(new Chunk("1.	The validity of this authorization will be one year from the date of issue. After the validity the renewal of this authorization is to be sought.",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD)));
		// fName.setExtraParagraphSpace(100.0f);
		one.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(one);
		document.add(space12);
		
		one = new Paragraph();
		one.add(new Chunk("2.	The Chhattisgarh Environment Conservation Board may at any time revoke any of the conditions application under the authorization and shall communicate the same in writing.",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD)));
		// fName.setExtraParagraphSpace(100.0f);
		one.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(one);
		document.add(space12);
		
		one = new Paragraph();
		one.add(new Chunk("3.	Any violation of the provision of the Municipal Soild Wastes (Management and Handling) Rules, 2000 will attract the penal provision of the environment (protection) Act. 1986 (29 of 1986)	",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD)));
		// fName.setExtraParagraphSpace(100.0f);
		one.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(one);
		document.add(space12);
		
		
		Paragraph encl = new Paragraph();
		encl.add(new Chunk("Encl :- ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		encl.add(new Chunk("As Above. ",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		sub.setIndentationLeft(20);
		document.add(encl);
		
		document.add(space12);
		
		encl = new Paragraph();
		encl.add(new Chunk("(Terms & Conditions)", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		sub.setIndentationLeft(20);
		document.add(encl);
		
		document.add(space12);
		
		encl = new Paragraph();
		encl.add(new Chunk("Date", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		encl.add(new Chunk(" "+noticeDate,new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		encl.add(new Chunk("Place", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		encl.add(new Chunk(" Raipur",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		sub.setIndentationLeft(20);
		document.add(encl);
		
		document.add(space12);
		
		Paragraph mem = new Paragraph();
		mem.add(new Chunk("Member Secretary                          ",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem);
		
		
		Paragraph mem1 = new Paragraph();
		mem1.add(new Chunk("Chhattisgarh Environment Conservation Board ,",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem1.add(new Chunk(" Raipur  (C.G.)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem1.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem1);
		document.add(space12);
		
		videNo = new Paragraph();
		
		videNo.add(new Chunk("Endi. No :", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +letternumber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk(industryDistrict+" ,Dated:" + noticeDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNo);
		
		document.add(space12);
		
		Paragraph body2 = new Paragraph();
		
		body2.add(new Chunk("Copy To. :", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		body2.add(new Chunk("  " +copyTo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(body2);
		
		document.add(space12);
		
		Paragraph p1 = new Paragraph();
		p1.add(new Chunk("1.	MSW Cell, C.G. Environment Conservation Board, Raipur.",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD)));
		// fName.setExtraParagraphSpace(100.0f);
		document.add(p1);
		document.add(space12);
		
		p1 = new Paragraph();
		p1.add(new Chunk("2.	Regional Officer, Chhattisgarh  Environment Conservation Board,"+ industryDistrict,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD)));
		// fName.setExtraParagraphSpace(100.0f);
		p1.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(p1);
		document.add(space12);
		document.add(space12);
		document.add(space12);
		
		document.add(mem);
		
		
		document.add(mem1);
		
		document.add(space12);
		document.add(space12);
		
		Paragraph heading3 = new Paragraph();
		heading3.add(new Chunk("TERMS & CONDITIONS OF AUTHORIZATION", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 6, Font.BOLD)));
		heading3.setAlignment(Element.ALIGN_CENTER);
		document.add(heading3);	
		
		document.add(space12);
		document.add(space12);
		
		Paragraph tnc = new Paragraph();
		tnc.add(new Chunk(terms,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD)));
		// fName.setExtraParagraphSpace(100.0f);
		document.add(tnc);
		document.add(space12);
		
		document.close();
		
		return tempFile;
	}
	

	
}
