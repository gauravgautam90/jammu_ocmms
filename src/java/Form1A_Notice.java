import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Form1A_Notice {
	public File Form1A_Notice_Function(String offDistrict,String dateNotice,String officeAddress,String industryName,String industryPlot,String industryAddress,String industryTehsil,String industryDistrict,String noticeNum,String assessmentPeriodFrom,String assessmentPeriodTo, String month,String copyTo, String fileNumber) throws Exception {
		
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
		subHeading.add(new Chunk(officeAddress,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);

		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space12);

		Paragraph videNo = new Paragraph();

		
		videNo.add(new Chunk("No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +noticeNum, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk(offDistrict+" ,Dated:" + dateNotice, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNo);

		Paragraph subHeading1 = new Paragraph();
		subHeading1.add(new Chunk("Form 1A",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading1.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading1);
		
		Paragraph subHeading11 = new Paragraph();
		subHeading11.add(new Chunk("[ See Rules 4(2)]",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
		subHeading11.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading11);
		
		Paragraph subHeading111 = new Paragraph();
		subHeading111.add(new Chunk("Notice under section 5(2) of Water (Prevention and Control of Pollution) Cess Act, 1977 (36 of 1977)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
		subHeading111.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading111);
		
		Paragraph toAddress = new Paragraph("To,");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);

		Paragraph indName = new Paragraph(industryName);
		indName.setExtraParagraphSpace(50.0f);
		indName.setIndentationLeft(20);
		document.add(indName);

		Paragraph address = new Paragraph(industryPlot+" "+industryAddress);
		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(20);
		document.add(address);

		Paragraph tehsil = new Paragraph();
		tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		tehsil.add(new Chunk(industryTehsil, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		tehsil.setIndentationLeft(20);
		document.add(tehsil);

		Paragraph district = new Paragraph();
		district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		district.add(new Chunk(industryDistrict, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		district.setIndentationLeft(20);
		document.add(district);

		document.add(space12);
		document.add(space12);
		
		Paragraph asses = new Paragraph();
		asses.add(new Chunk("Assessment period     From  :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk(assessmentPeriodFrom, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.add(new Chunk("   To  ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		asses.add(new Chunk(assessmentPeriodTo, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		asses.setIndentationLeft(20);
		document.add(asses);
		
		document.add(space12);
		
		Paragraph noticeBody1 = new Paragraph();
		noticeBody1.add(new Chunk("Whereas your were required to furnish a return as provided under sub-section(1) section 5 ot the Water(Prevention and Control of Pollution) Cess Act,(36 of 1977) read with the sub-rule(1) of rule 4 of the Water(Prevention and Control of Pollution) Cess Rules,1978 by the 5th of the month of "+month, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody1.setIndentationLeft(20);
		document.add(noticeBody1);
		
		document.add(space12);
		Paragraph noticeBody2 = new Paragraph();
		noticeBody2.add(new Chunk("And where you have failed to furnish the return by the said date.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody2.setIndentationLeft(20);
		document.add(noticeBody2);
		document.add(space12);
		Paragraph noticeBody3 = new Paragraph();
		noticeBody3.add(new Chunk("Now therefore, you are hereby called upon to furnish the return within 7 days from the date of receipt of this notice.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody3.setIndentationLeft(20);
		document.add(noticeBody3);
		document.add(space12);
		Paragraph noticeBody4 = new Paragraph();
		noticeBody4.add(new Chunk("In case no return is received within the said period of 7 days,action will be taken for making assessment as per sub-action(1A) of section 6 of the aforesaid Act ,ex-prate, besides initiating any other legal action as per law against You.", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE )));
		noticeBody4.setIndentationLeft(20);
		document.add(noticeBody4);
		document.add(space12);
		
		Paragraph place = new Paragraph();
		place.add(new Chunk("Place :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		place.add(new Chunk(offDistrict, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(place);
		
		Paragraph dateLas = new Paragraph();
		dateLas.add(new Chunk("Date :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		dateLas.add(new Chunk(dateNotice, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(dateLas);
		
		Paragraph space7 = new Paragraph();
		space7.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space7.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space7);

		Paragraph space = new Paragraph();
		space.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space);

	

		Paragraph space2 = new Paragraph();
		space2.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space2.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space2);

		

		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space4);

		Paragraph space5 = new Paragraph();
		space5.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space5.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space5);

		Paragraph space6 = new Paragraph();
		space6.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space6.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		document.add(space6);

		Paragraph mem = new Paragraph();
		mem.add(new Chunk("Member Secretary                          ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem);

		Paragraph mem1 = new Paragraph();
		mem1.add(new Chunk("J & K State Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
		mem1.setAlignment(Element.ALIGN_RIGHT);
		document.add(mem1);
		document.add(space6);
		document.add(space6);
		document.add(space6);
		
		Paragraph videNo1 = new Paragraph();

		// ch.setHorizontalScaling(20);
		videNo1.add(new Chunk("Endt No :", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo1.add(new Chunk("  " +fileNumber, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo1.add(new Chunk(offDistrict+" ,Dated:" + dateNotice, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

		

		document.add(videNo1);
		
		Paragraph toAddress1 = new Paragraph("Copy To:-");
		
		document.add(toAddress1);
		
		document.add(space6);
		
		
		document.add(space6);
		
		Paragraph copYtoo1 = new Paragraph(copyTo);

		
		copYtoo1.setIndentationLeft(20);
		
		document.add(copYtoo1);
		
		
		document.add(space6);
		document.add(space6);
		document.add(space6);
		
		document.add(mem);

		
		document.add(mem1);

		document.close();
		return tempFile;
	}

	

}


