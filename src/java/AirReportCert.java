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


public class AirReportCert {

	
	public File airReportCert(String InitialTimerReading,String FinalTimerReading,String TimeInMin,String MeanFlowRate,String FilterPaperno,String FilterPaperInitialWeight,String FilterPaperPlusDustWeight,String DustInCupWeight,String RSPM,String NRD,String TSPM,String SO2,String NO, String currentDate,String remark) throws Exception {
		
		File tempFile = new File("certificate.pdf");
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));
		document.open();
		
		Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
		
		image.scalePercent(50.0f);
		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
		document.add(image);
		
		Paragraph heading = new Paragraph();
		heading.add(new Chunk("J & K Pollution Control Committee",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
		heading.setAlignment(Element.ALIGN_CENTER);

		document.add(heading);
		
		Paragraph subHeading = new Paragraph();
		subHeading.add(new Chunk("NAMP : Sampling Cum Analysis Sheet",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
		subHeading.setAlignment(Element.ALIGN_CENTER);
		document.add(subHeading);
		
		Paragraph space12 = new Paragraph();
		space12.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space12.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		
		
		document.add(space12);

		Paragraph videNo = new Paragraph();
		
		videNo.add(new Chunk("     Sampling Date :", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		videNo.add(new Chunk("  " +currentDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		videNo.add(new Chunk("           ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 3, Font.BOLD)));
		document.add(videNo);
		
		Paragraph toAddress = new Paragraph("     NAMP STATION AT CETP , GovindPura/Hamidia Road/Paryavaran Parisar");
		subHeading.setAlignment(Element.ALIGN_LEFT);
		document.add(toAddress);
		
		
		Paragraph indName1 = new Paragraph("Timer Reading: Initial"+InitialTimerReading+"        Final"+FinalTimerReading+"          Time In Min"+TimeInMin);
		indName1.setExtraParagraphSpace(50.0f);
		indName1.setIndentationLeft(20);
		document.add(indName1);
		
		Paragraph address = new Paragraph("Remark :  "+remark);
		address.setExtraParagraphSpace(50.0f);
		address.setIndentationLeft(20);
		document.add(address);
		
		
		document.add(space12);
		
		Paragraph subject = new Paragraph("-------------------------------------------------------------------------------------------------------------------------------");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject);
		
		Paragraph sub = new Paragraph();
		//sub.add(new Chunk("Sub :- ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		sub.add(new Chunk("                                                       Draft Analysis Report",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		//sub.setIndentationLeft(20);
		document.add(sub);
		
		document.add(space12);
		
		Paragraph subject1 = new Paragraph("          Mean Flow Rate=  "+MeanFlowRate+"  (M3/Min) ");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          Filter Paper Number  "+FilterPaperno);
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          Filter Paper Initial Weight...W1=  "+FilterPaperInitialWeight+"  g");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          Filter Paper + Dust Weight...W2=  "+FilterPaperPlusDustWeight+"  g");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          Dust In Cup...W3=  "+DustInCupWeight+"  g");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          RSPM=  "+RSPM+"  ug/m3");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          NRD=  "+NRD+"  ug/m3");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          TSPM=  "+TSPM+"  ug/m3");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          SO2=  "+SO2+"  ug/m3");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		
		subject1 = new Paragraph("          NOx1=  "+NO+"  ug/m3");
		subHeading.setAlignment(Element.ALIGN_RIGHT);
		document.add(subject1);
		

		
		document.add(space12);
		document.add(space12);
		
		document.add(space12);
		
		Paragraph encl = new Paragraph();
		encl.add(new Chunk("Name of The Analyst                              Signaure      ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1, Font.BOLD)));
		document.add(space12);
		document.add(space12);
		encl.add(new Chunk("                              Signature of the Attendant/Sampler ",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 1)));
		sub.setIndentationLeft(20);
		document.add(encl);
		
		document.add(space12);
		
		
		document.add(space12);
		document.add(space12);
		document.add(space12);
		
		
		document.add(space12);
		
		document.close();
		
		return tempFile;
	}
	
}
