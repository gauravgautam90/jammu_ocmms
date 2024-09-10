import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;
import org.apache.commons.lang.WordUtils;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;


class RedBorder012 extends PdfPageEventHelper {
    int pageNum;
    PdfTemplate total;
    /**
     * Increase the page number.
     * @see com.itextpdf.text.pdf.PdfPageEventHelper#onStartPage(
     *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
     */
    public void onStartPage(PdfWriter writer, Document document) {
        pageNum++;
    }
    public void onEndPage(PdfWriter writer, Document document) {

        PdfContentByte canvas = writer.getDirectContent();
        Rectangle rect = new Rectangle(28,28,575,825);
     //   rect.setBorder(Rectangle.BOX); // left, right, top, bottom border
      //  rect.setBorderWidth(2); // a width of 5 user units
        rect.setBorderColor(new Color(0,0,0)); // a black border
        rect.setUseVariableBorders(false); // the full width will be visible
        canvas.rectangle(rect);
        /**
         * Adds the header and the footer.
         * @see com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(
         *      com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.Document)
         */
//      ColumnText.showTextAligned(writer.getDirectContent(),
//              Element.ALIGN_CENTER, new Phrase(String.format("Page %d ", writer.getPageNumber())),
//              (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);



        try
        {
            Image background = Image.getInstance("images2/watermark_final.jpg");
            background.scalePercent(-300f);
            float width = document.getPageSize().getWidth();
            float height = document.getPageSize().getHeight();
            writer.getDirectContentUnder().addImage(background, width,0,0,height,0,0);
        }
        catch(Exception e){}


    }

}


public class FormWhiteCategoryIntegration {


    public File pdfAcknowledgement(String indUserId, String intimationAppId, String dateOfApply,String industryName,String indAddress, String indCity, String indDistrict, String industryPin,String nameAddressPartners,String mobile,
    														String email,  String totalInvestment,String investmentPlant,String noOfWorkers, String occName, String indCategory, String indType,String occAddress, String[] arrRawMaterialsUsed, String[] arrOfProduct, 
    														String[] arrOfSourceofwater, String[] arrOfWaterConsumptionDetails, String[] arrOfDomesticwasteWater, String[] arrOfDGSetDetails, String[] arrOfUndertaking, String autoNumber,String regionalOffice,
    														String indTypeId,String upDate,String product, String quantity) throws Exception {
    	System.out.println("Inside java pdf pdfAcknowledgement");
        String indName=capitalizeFirstLetter(industryName);
        String industryAddress=capitalizeFirstLetter(indAddress);
        String industryCity=capitalizeFirstLetter(indCity);
        String districtName=capitalizeFirstLetter(indDistrict);

        String occupierName=capitalizeFirstLetter(occName);

        System.out.println("pdfAcknowledgement !!!! apache");


        File tempFile = new File("AUTO_ACKNOWLEDGEMENT.pdf");

        Document document = new Document(PageSize.A4);

        PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(tempFile));
     /*  Phrase footerPhrase = new Phrase ("(This is auto-generated and does not require any authentication / signature)\"                                                                  "+"\n"
                +"\n"+"Page",new Font(
                Font.TIMES_ROMAN, Font.DEFAULTSIZE -4,Font.ITALIC));

        HeaderFooter footer = new HeaderFooter(footerPhrase, false);
        footer.setAlignment(Element.ALIGN_RIGHT);
        footer.setBorder(Rectangle.NO_BORDER);
        document.setFooter(footer);*/
        document.open();


        RedBorder012 event = new RedBorder012();
        writer.setPageEvent(event);

        Paragraph space4 = new Paragraph();
        space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
                Font.DEFAULTSIZE - 2, Font.BOLD)));
        space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
                Font.DEFAULTSIZE -2)));
        document.add(space4);


        PdfPTable table1P = new PdfPTable(2);
        table1P.setWidthPercentage(100);
        PdfPCell cell1P = new PdfPCell();
        float[] columnWidths1120 = {1.0f,9.0f};
        table1P.setWidths(columnWidths1120);

        Image image1 = Image.getInstance("images2/jammu.jpg");
        image1.setAlignment(Image.LEFT | Image.TEXTWRAP);
        image1.scaleAbsolute(10,25);
       // image1.scaleToFit(10,25);
        image1.scalePercent(80.0f);
        PdfPCell cell2 = new PdfPCell(image1, true);
        cell2.setRowspan(2);
        cell2.setBorder(PdfPCell.NO_BORDER);
        table1P.addCell(cell2);



        cell1P = new PdfPCell(new Paragraph(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
        cell1P.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1P.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell1P.setBackgroundColor (new Color (232, 246, 249));
        cell1P.setPadding(3.0f);
        cell1P.setBorder(PdfPCell.NO_BORDER);
        //cell1P.setColspan(2);
        cell1P.setBorderColor(new Color(0, 0, 0));
        // cell1P.setBorderWidth(2);
        table1P.addCell(cell1P);

        cell1P = new PdfPCell(new Paragraph(new Chunk("Jammu/Kashmir\n(http://jkocmms.nic.in)\n\n WHITE CATEGORY\n (Auto-generated under Ease of doing Business)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
        cell1P.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1P.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell1P.setBackgroundColor (new Color (232, 246, 249));
        cell1P.setPadding(3.0f);
        cell1P.setBorder(PdfPCell.NO_BORDER);
        //cell1P.setColspan(2);
        cell1P.setBorderColor(new Color(0, 0, 0));
        // cell1P.setBorderWidth(2);
        table1P.addCell(cell1P);
        
        cell1P = new PdfPCell(new Paragraph(new Chunk("(Auto-generated under Ease of doing Business) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell1P.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1P.setVerticalAlignment(Element.ALIGN_CENTER);
        // cell1P.setBackgroundColor (new Color (232, 246, 249));
        cell1P.setPadding(3.0f);
        cell1P.setBorder(PdfPCell.NO_BORDER);
        //cell1P.setColspan(2);
        cell1P.setBorderColor(new Color(0, 0, 0));
        // cell1P.setBorderWidth(2);
        table1P.addCell(cell1P);
        document.add(table1P);

    
        
     PdfPCell cell2110 = new PdfPCell();
    /* Paragraph paraF = new Paragraph();
		paraF.add(new Chunk("Dated:"+dateOfApply, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE - 2, Font.NORMAL)));
		paraF.setAlignment(Element.ALIGN_RIGHT);
		document.add(paraF);
        document.add(space4);*/
     document.add(space4);
     PdfPTable table21101 = new PdfPTable(2);
     table21101.setWidthPercentage(100);
     float[] columnWidths411 = {5f,5f};
     table21101.setWidths(columnWidths411);
 
 cell2110 = new PdfPCell(new Paragraph(new Chunk("No. JKPCC/digital/White/"+intimationAppId, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
 cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
 cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
 cell2110.setPadding(3.0f);
 cell2110.setBorder(PdfPCell.NO_BORDER);
 table21101.addCell(cell2110);



 cell2110 = new PdfPCell(new Paragraph(new Chunk("Dated: "+dateOfApply+"\n", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
 cell2110.setHorizontalAlignment(Element.ALIGN_RIGHT);
 cell2110.setVerticalAlignment(Element.ALIGN_RIGHT);
 cell2110.setPadding(3.0f);
 cell2110.setBorder(PdfPCell.NO_BORDER);
 table21101.addCell(cell2110);

 
 document.add(table21101);
 //document.add(space4);
     
		Paragraph paraE = new Paragraph();
		paraE.add(new Chunk(occName
				+"\nM/s  "
				+ industryName + "\n" + indAddress +"\n", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
				Font.NORMAL)));
		paraE.setAlignment(Element.ALIGN_LEFT);
		document.add(paraE);
		document.add(space4);
        
		    PdfPTable table2110 = new PdfPTable(3);
	        table2110.setWidthPercentage(100);
	        float[] columnWidths41 = {0.5f,5f,1.5f};
	        table2110.setWidths(columnWidths41);
        
        cell2110 = new PdfPCell(new Paragraph(new Chunk("S. No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell2110.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
        cell2110.setPadding(3.0f);
        cell2110.setBorderColor(new Color(0, 0, 0));
        table2110.addCell(cell2110);

        cell2110 = new PdfPCell(new Paragraph(new Chunk("Products to be manufactured", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell2110.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
        cell2110.setPadding(3.0f);
        cell2110.setBorderColor(new Color(0, 0, 0));
        table2110.addCell(cell2110);

        cell2110 = new PdfPCell(new Paragraph(new Chunk("Quantity of Products", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell2110.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
        cell2110.setPadding(3.0f);
        cell2110.setBorderColor(new Color(0, 0, 0));
        table2110.addCell(cell2110);

        cell2110 = new PdfPCell(new Paragraph(new Chunk("1", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell2110.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
        cell2110.setPadding(3.0f);
        cell2110.setBorderColor(new Color(0, 0, 0));
        table2110.addCell(cell2110);
      
        
        cell2110 = new PdfPCell(new Paragraph(new Chunk(product, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell2110.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
        cell2110.setPadding(3.0f);
        cell2110.setBorderColor(new Color(0, 0, 0));
        table2110.addCell(cell2110);
       
        
        cell2110 = new PdfPCell(new Paragraph(new Chunk(quantity, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
        cell2110.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
        cell2110.setPadding(3.0f);
        cell2110.setBorderColor(new Color(0, 0, 0));
        table2110.addCell(cell2110);
        
        document.add(table2110);
        
     //   document.add(space4);
        
      /*  Paragraph para90 = new Paragraph();
		para90.add(new Chunk("Whereas,  as per directions issued by CPCB on 07.03.2016 u/s 18(1)(b) of Water and Air Acts for adopting Revised Classification of Industrial sectors and consequently JKPCC (earlier JKPCB) vide letter No. SPCB/Estb/CO/Gen/ICC/91/253-61 dated 29.04.2016 has adopted the revised classification of Industrial Sector in which White Category of Industries also falls.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2,Font.NORMAL)));
		para90.setAlignment(Element.ALIGN_LEFT);
		document.add(para90);
		document.add(space4);
        
		Paragraph para91 = new Paragraph();
		para91.add(new Chunk("And whereas, as per the revised classification, white category of Industries, there shall be no necessity of obtaining consent of the JKPCC/Board and an intimation to the JKPCC shall be suffice. ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2,Font.NORMAL)));
		para91.setAlignment(Element.ALIGN_LEFT);
		document.add(para91);
		document.add(space4);
		
		Paragraph para92 = new Paragraph();
		para92.add(new Chunk("And whereas, as per the undertaking given by the applicant online on jkocmms portal stating that its activity falls under white category as per revised classification of industries/activities, the exemption certificate is being generated online on the basis of undertaking provided by the unit holder which shall suffice the requirement of Consent to Establish/Consent to Operate,subject to following conditions :",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2,Font.NORMAL)));
		para92.setAlignment(Element.ALIGN_LEFT);
		document.add(para92);*/
		
		
    	
		PdfPTable table2610a = new PdfPTable(1);
		table2610a.setWidthPercentage(95);
      float[] columnWidths42a = {2f};
      table2610a.setWidths(columnWidths42a);
   PdfPCell cell2610a = new PdfPCell();
		
   cell2610a = new PdfPCell(new Paragraph(new Chunk("Whereas, as per directions issued by CPCB on 07.03.2016 u/s 18(1)(b) of Water and Air Acts for adopting Revised Classification of Industrial sectors and consequently JKPCC (earlier JKPCB) vide letter No." +
   		"SPCB/Estb/CO/Gen/ICC/91/253-61 dated 29.04.2016 has adopted the revised classification of Industrial Sector in which White Category of Industries also falls.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610a.setPadding(3.0f);
   cell2610a.setBorder(PdfPCell.NO_BORDER);
   cell2610a.setBorderColor(new Color(0, 0, 0));
   table2610a.addCell(cell2610a);

   cell2610a = new PdfPCell(new Paragraph(new Chunk("And whereas, as per the revised classification, white category of Industries, there shall be no necessity of obtaining consent of the JKPCC/Board and an intimation to the JKPCC shall be suffice. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610a.setPadding(3.0f);
   cell2610a.setBorderColor(new Color(0, 0, 0));
   cell2610a.setBorder(PdfPCell.NO_BORDER);
   table2610a.addCell(cell2610a);

   cell2610a = new PdfPCell(new Paragraph(new Chunk("And whereas, as per the undertaking given by the applicant online on jkocmms portal stating that its activity falls under white category as per revised classification of industries/activities, the exemption certificate is being generated online on the basis of undertaking provided by the unit holder which shall suffice the requirement of Consent to Establish/Consent to Operate,subject to following conditions : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610a.setPadding(3.0f);
   cell2610a.setBorderColor(new Color(0, 0, 0));
   cell2610a.setBorder(PdfPCell.NO_BORDER);
   table2610a.addCell(cell2610a);


  
		
   document.add(table2610a);	
		
		
		PdfPTable table2610 = new PdfPTable(2);
		table2610.setWidthPercentage(95);
      float[] columnWidths42 = {0.2f,5f};
      table2610.setWidths(columnWidths42);
   PdfPCell cell2610 = new PdfPCell();
		
   cell2610 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorder(PdfPCell.NO_BORDER);
   cell2610.setBorderColor(new Color(0, 0, 0));
   table2610.addCell(cell2610);

   cell2610 = new PdfPCell(new Paragraph(new Chunk("The Exemption Certificate is issued based on the undertaking on the application form ensuring that the activity is strictly as per the white category mentioned in the" +
   		" revised classification criteria of industries mentioned in UCM issued by CPCB.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);

   cell2610 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);

   cell2610 = new PdfPCell(new Paragraph(new Chunk("In case of any change in the process(es) or activity(ies) leading to change of the categorization of the activities from White Category to some other Category, application for Consent to Establish & Consent to" +
   		"Operate under the Air and Water Acts and other applicable Rules under the Environment (Protection) Act, 1986, as amended to date, shall be submitted to JKPCC online portal and such activity(ies) shall not be carried out without taking prior Consent from JKPCC.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk("The Industry / unit shall abide by the affirmations and declarations given in the undertaking / self declaration given by unit holder and shall be liable for penal action as per the provisions of Environmental laws if wrong information/declaration is found provided by the unit holder in the online application form.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk("This Certificate is being issued without any prejudice to any action liable to be taken in lieu of any violation committed by the applicant or the concealment of any fact.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk("In case of violation of above mentioned conditions or any public complaint, the exemption shall be withdrawn.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   cell2610 = new PdfPCell(new Paragraph(new Chunk(" *this exemption is issued purely from environmental angle and the JKPCC shall not be responsible for any claim, counter claim, ownership, partnership etc of the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
   cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell2610.setVerticalAlignment(Element.ALIGN_LEFT);
   cell2610.setPadding(3.0f);
   cell2610.setBorderColor(new Color(0, 0, 0));
   cell2610.setBorder(PdfPCell.NO_BORDER);
   table2610.addCell(cell2610);
   
   
        document.add(table2610);
        //document.add(space4);

    	Paragraph para98A = new Paragraph();
		para98A.add(new Chunk("(This is auto-generated and does not require any authentication / signature).",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3,Font.BOLDITALIC)));
		para98A.setAlignment(Element.ALIGN_CENTER);
		document.add(para98A);
		//document.add(space4);
		
		Paragraph para98 = new Paragraph();
		para98
				.add(new Chunk(
						"\nCopy to :-",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2,
								Font.NORMAL)));
		para98.setAlignment(Element.ALIGN_LEFT);
		document.add(para98);
	//	document.add(space4);
		
		PdfPTable table26101 = new PdfPTable(2);
		table26101.setWidthPercentage(95);
      float[] columnWidths421 = {0.2f,5f};
      table26101.setWidths(columnWidths421);
   PdfPCell cell26101 = new PdfPCell();
		
   cell26101 = new PdfPCell(new Paragraph(new Chunk("1).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorder(PdfPCell.NO_BORDER);
   cell26101.setBorderColor(new Color(0, 0, 0));
   table26101.addCell(cell26101);

   cell26101 = new PdfPCell(new Paragraph(new Chunk("Member Secretary, JKPCC for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorderColor(new Color(0, 0, 0));
   cell26101.setBorder(PdfPCell.NO_BORDER);
   table26101.addCell(cell26101);
   cell26101 = new PdfPCell(new Paragraph(new Chunk("2).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorder(PdfPCell.NO_BORDER);
   cell26101.setBorderColor(new Color(0, 0, 0));
   table26101.addCell(cell26101);

   cell26101 = new PdfPCell(new Paragraph(new Chunk("Regional Director Jammu/Kashmir for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorderColor(new Color(0, 0, 0));
   cell26101.setBorder(PdfPCell.NO_BORDER);
   table26101.addCell(cell26101);
   cell26101 = new PdfPCell(new Paragraph(new Chunk("3).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorder(PdfPCell.NO_BORDER);
   cell26101.setBorderColor(new Color(0, 0, 0));
   table26101.addCell(cell26101);

   cell26101 = new PdfPCell(new Paragraph(new Chunk("General Manager DIC "+ indDistrict +" for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorderColor(new Color(0, 0, 0));
   cell26101.setBorder(PdfPCell.NO_BORDER);
   table26101.addCell(cell26101);
   cell26101 = new PdfPCell(new Paragraph(new Chunk("4).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorder(PdfPCell.NO_BORDER);
   cell26101.setBorderColor(new Color(0, 0, 0));
   table26101.addCell(cell26101);

   cell26101 = new PdfPCell(new Paragraph(new Chunk("Divisional Officer PCC "+ indDistrict +" for information and with the directions to monitor conditions stated above.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorderColor(new Color(0, 0, 0));
   cell26101.setBorder(PdfPCell.NO_BORDER);
   table26101.addCell(cell26101);
   cell26101 = new PdfPCell(new Paragraph(new Chunk("5).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorder(PdfPCell.NO_BORDER);
   cell26101.setBorderColor(new Color(0, 0, 0));
   table26101.addCell(cell26101);

   cell26101 = new PdfPCell(new Paragraph(new Chunk("M/s "+ industryName +" for compliance of the above said conditions.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorderColor(new Color(0, 0, 0));
   cell26101.setBorder(PdfPCell.NO_BORDER);
   table26101.addCell(cell26101);
   
   cell26101 = new PdfPCell(new Paragraph(new Chunk("6).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorder(PdfPCell.NO_BORDER);
   cell26101.setBorderColor(new Color(0, 0, 0));
   table26101.addCell(cell26101);

   cell26101 = new PdfPCell(new Paragraph(new Chunk("Office file.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
   cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
   cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
   cell26101.setPadding(3.0f);
   cell26101.setBorderColor(new Color(0, 0, 0));
   cell26101.setBorder(PdfPCell.NO_BORDER);
   table26101.addCell(cell26101);
   
   document.add(table26101);
   //document.add(space4);

		Paragraph para98B = new Paragraph();
		para98B.add(new Chunk("(The unit holder shall comply to environmental standards as notified under the Environment Protection Act 1986, read with the" +
				" Water (Prevention and Control of Pollution) Act 1974 and Air (Prevention and Control of Pollution) Act 1981)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3,Font.ITALIC)));
		para98B.setAlignment(Element.ALIGN_CENTER);
		document.add(para98B);
		document.add(space4);
        document.close();
        return tempFile;
    }
    
    public File pdfAcknowledgementForSchool(String indUserId, String intimationAppId, String dateOfApply,String industryName,String indAddress, String indCity, String indDistrict, String industryPin,String nameAddressPartners,String mobile,
																		  String email,  String totalInvestment,String investmentPlant,String noOfWorkers, String occName, String indCategory, String indType,String occAddress, String[] arrRawMaterialsUsed, String[] arrOfProduct, 
																		  String[] arrOfSourceofwater, String[] arrOfWaterConsumptionDetails, String[] arrOfDomesticwasteWater, String[] arrOfDGSetDetails, String[] arrOfUndertaking, String autoNumber,String regionalOffice,
																		  String indTypeId,String upDate,String product, String quantity) throws Exception {
System.out.println("Inside java pdf pdfAcknowledgementForSchool");
 String indName=capitalizeFirstLetter(industryName);
String industryAddress=capitalizeFirstLetter(indAddress);
String industryCity=capitalizeFirstLetter(indCity);
String districtName=capitalizeFirstLetter(indDistrict);

String occupierName=capitalizeFirstLetter(occName);

System.out.println("pdfAcknowledgement !!!! apache");


File tempFile = new File("AUTO_ACKNOWLEDGEMENT.pdf");

Document document = new Document(PageSize.A4);

PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(tempFile));
/*  Phrase footerPhrase = new Phrase ("(This is auto-generated and does not require any authentication / signature)\"                                                                  "+"\n"
+"\n"+"Page",new Font(
Font.TIMES_ROMAN, Font.DEFAULTSIZE -4,Font.ITALIC));

HeaderFooter footer = new HeaderFooter(footerPhrase, false);
footer.setAlignment(Element.ALIGN_RIGHT);
footer.setBorder(Rectangle.NO_BORDER);
document.setFooter(footer);*/
document.open();


RedBorder012 event = new RedBorder012();
writer.setPageEvent(event);

Paragraph space4 = new Paragraph();
space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
Font.DEFAULTSIZE - 2, Font.BOLD)));
space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
Font.DEFAULTSIZE -2)));
document.add(space4);


PdfPTable table1P = new PdfPTable(2);
table1P.setWidthPercentage(100);
PdfPCell cell1P = new PdfPCell();
float[] columnWidths1120 = {1.0f,9.0f};
table1P.setWidths(columnWidths1120);

Image image1 = Image.getInstance("images2/jammu.jpg");
image1.setAlignment(Image.LEFT | Image.TEXTWRAP);
image1.scaleAbsolute(10,25);
// image1.scaleToFit(10,25);
image1.scalePercent(80.0f);
PdfPCell cell2 = new PdfPCell(image1, true);
cell2.setRowspan(2);
cell2.setBorder(PdfPCell.NO_BORDER);
table1P.addCell(cell2);



cell1P = new PdfPCell(new Paragraph(new Chunk("J&K Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
cell1P.setHorizontalAlignment(Element.ALIGN_CENTER);
cell1P.setVerticalAlignment(Element.ALIGN_CENTER);
// cell1P.setBackgroundColor (new Color (232, 246, 249));
cell1P.setPadding(3.0f);
cell1P.setBorder(PdfPCell.NO_BORDER);
//cell1P.setColspan(2);
cell1P.setBorderColor(new Color(0, 0, 0));
// cell1P.setBorderWidth(2);
table1P.addCell(cell1P);

cell1P = new PdfPCell(new Paragraph(new Chunk("Jammu/Kashmir\n(http://jkocmms.nic.in)\n\n WHITE CATEGORY\n (Auto-generated under Ease of doing Business)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD))));
cell1P.setHorizontalAlignment(Element.ALIGN_CENTER);
cell1P.setVerticalAlignment(Element.ALIGN_CENTER);
// cell1P.setBackgroundColor (new Color (232, 246, 249));
cell1P.setPadding(3.0f);
cell1P.setBorder(PdfPCell.NO_BORDER);
//cell1P.setColspan(2);
cell1P.setBorderColor(new Color(0, 0, 0));
// cell1P.setBorderWidth(2);
table1P.addCell(cell1P);

cell1P = new PdfPCell(new Paragraph(new Chunk("(Auto-generated under Ease of doing Business) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cell1P.setHorizontalAlignment(Element.ALIGN_CENTER);
cell1P.setVerticalAlignment(Element.ALIGN_CENTER);
// cell1P.setBackgroundColor (new Color (232, 246, 249));
cell1P.setPadding(3.0f);
cell1P.setBorder(PdfPCell.NO_BORDER);
//cell1P.setColspan(2);
cell1P.setBorderColor(new Color(0, 0, 0));
// cell1P.setBorderWidth(2);
table1P.addCell(cell1P);
document.add(table1P);



PdfPCell cell2110 = new PdfPCell();
/* Paragraph paraF = new Paragraph();
paraF.add(new Chunk("Dated:"+dateOfApply, new Font(Font.TIMES_ROMAN,
Font.DEFAULTSIZE - 2, Font.NORMAL)));
paraF.setAlignment(Element.ALIGN_RIGHT);
document.add(paraF);
document.add(space4);*/
document.add(space4);
PdfPTable table21101 = new PdfPTable(2);
table21101.setWidthPercentage(100);
float[] columnWidths411 = {5f,5f};
table21101.setWidths(columnWidths411);

cell2110 = new PdfPCell(new Paragraph(new Chunk("No. JKPCC/digital/White/"+intimationAppId, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cell2110.setHorizontalAlignment(Element.ALIGN_LEFT);
cell2110.setVerticalAlignment(Element.ALIGN_LEFT);
cell2110.setPadding(3.0f);
cell2110.setBorder(PdfPCell.NO_BORDER);
table21101.addCell(cell2110);



cell2110 = new PdfPCell(new Paragraph(new Chunk("Dated: "+dateOfApply+"\n", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
cell2110.setHorizontalAlignment(Element.ALIGN_RIGHT);
cell2110.setVerticalAlignment(Element.ALIGN_RIGHT);
cell2110.setPadding(3.0f);
cell2110.setBorder(PdfPCell.NO_BORDER);
table21101.addCell(cell2110);


document.add(table21101);
//document.add(space4);

Paragraph paraE = new Paragraph();
paraE.add(new Chunk("\nM/s  "
+ industryName + "\n" + indAddress +"\n", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1,
Font.NORMAL)));
paraE.setAlignment(Element.ALIGN_LEFT);
document.add(paraE);
document.add(space4);



	PdfPTable table2610a = new PdfPTable(2);
	table2610a.setWidthPercentage(95);
	float[] columnWidths42a = {0.2f,5f};
	table2610a.setWidths(columnWidths42a);
	PdfPCell cell2610a = new PdfPCell();

        cell2610a = new PdfPCell(new Paragraph(new Chunk("i)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2610a.setPadding(3.0f);
		cell2610a.setBorder(PdfPCell.NO_BORDER);
		cell2610a.setBorderColor(new Color(0, 0, 0));
		table2610a.addCell(cell2610a);


		cell2610a = new PdfPCell(new Paragraph(new Chunk("Whereas, as per directions issued by CPCB on 07.03.2016 u/s 18(1)(b) of Water and Air Acts for adopting Revised Classification of Industrial sectors and consequently JKPCC (earlier JKPCB) vide letter No." +
				"SPCB/Estb/CO/Gen/ICC/91/253-61 dated 29.04.2016 has adopted the revised classification of Industrial Sector in which White Category of Industries also falls.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2610a.setPadding(3.0f);
		cell2610a.setBorder(PdfPCell.NO_BORDER);
		cell2610a.setBorderColor(new Color(0, 0, 0));
		table2610a.addCell(cell2610a);

        cell2610a = new PdfPCell(new Paragraph(new Chunk("ii)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2610a.setPadding(3.0f);
		cell2610a.setBorder(PdfPCell.NO_BORDER);
		cell2610a.setBorderColor(new Color(0, 0, 0));
		table2610a.addCell(cell2610a);
		
		cell2610a = new PdfPCell(new Paragraph(new Chunk("Whereas, as per the Revised Classification of White Category of Industries, the activity of Schools is also added under White Category and there shall be no necessity of obtaining regular consent of the JKPCC/Board and an intimation to the JKPCC shall suffice.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2610a.setPadding(3.0f);
		cell2610a.setBorderColor(new Color(0, 0, 0));
		cell2610a.setBorder(PdfPCell.NO_BORDER);
		table2610a.addCell(cell2610a);
		
        cell2610a = new PdfPCell(new Paragraph(new Chunk("iii)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2610a.setPadding(3.0f);
		cell2610a.setBorder(PdfPCell.NO_BORDER);
		cell2610a.setBorderColor(new Color(0, 0, 0));
		table2610a.addCell(cell2610a);

		cell2610a = new PdfPCell(new Paragraph(new Chunk("Whereas, as per Notification No. F(Acad-C)Aff.Pvt/Insp/B/23 dated 20/01/2023, issued by Director Academics, Jammu and Kashmir Board of School Education, the condition of NOC from JK Pollution Control Board/Committee has been waived off.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
		cell2610a.setPadding(3.0f);
		cell2610a.setBorderColor(new Color(0, 0, 0));
		cell2610a.setBorder(PdfPCell.NO_BORDER);
		table2610a.addCell(cell2610a);

	     cell2610a = new PdfPCell(new Paragraph(new Chunk("iv)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
	     cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2610a.setPadding(3.0f);
			cell2610a.setBorder(PdfPCell.NO_BORDER);
			cell2610a.setBorderColor(new Color(0, 0, 0));
			table2610a.addCell(cell2610a);
			
			cell2610a = new PdfPCell(new Paragraph(new Chunk("This Exemption Certificate is being issued without any prejudice to any action liable to be taken in lieu of any violation committed by the applicant or the concealment of any fact.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2610a.setPadding(3.0f);
			cell2610a.setBorderColor(new Color(0, 0, 0));
			cell2610a.setBorder(PdfPCell.NO_BORDER);
			table2610a.addCell(cell2610a);
			
		     cell2610a = new PdfPCell(new Paragraph(new Chunk("v)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
		     cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
				cell2610a.setPadding(3.0f);
				cell2610a.setBorder(PdfPCell.NO_BORDER);
				cell2610a.setBorderColor(new Color(0, 0, 0));
				table2610a.addCell(cell2610a);
				
				cell2610a = new PdfPCell(new Paragraph(new Chunk("This Exemption is valid for establishment and operation of School that does not involves any activity which requires Consent / Environment Clearance under EIA Notification 2006.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
				cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
				cell2610a.setPadding(3.0f);
				cell2610a.setBorderColor(new Color(0, 0, 0));
				cell2610a.setBorder(PdfPCell.NO_BORDER);
				table2610a.addCell(cell2610a);
				
			     cell2610a = new PdfPCell(new Paragraph(new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -1, Font.NORMAL))));
			     cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
					cell2610a.setPadding(3.0f);
					cell2610a.setBorder(PdfPCell.NO_BORDER);
					cell2610a.setBorderColor(new Color(0, 0, 0));
					table2610a.addCell(cell2610a);
					
					cell2610a = new PdfPCell(new Paragraph(new Chunk("*this exemption is issued purely from environmental angle and the JKPCC shall not be responsible for any claim, counter claim, ownership, partnership etc of the unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.ITALIC))));
					cell2610a.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell2610a.setVerticalAlignment(Element.ALIGN_LEFT);
					cell2610a.setPadding(3.0f);
					cell2610a.setBorderColor(new Color(0, 0, 0));
					cell2610a.setBorder(PdfPCell.NO_BORDER);
					table2610a.addCell(cell2610a);




document.add(table2610a);	


//document.add(space4);

Paragraph para98A = new Paragraph();
para98A.add(new Chunk("(This is auto-generated and does not require any authentication / signature).",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3,Font.BOLDITALIC)));
para98A.setAlignment(Element.ALIGN_CENTER);
document.add(para98A);
//document.add(space4);

Paragraph para98 = new Paragraph();
para98
.add(new Chunk(
	"\nCopy to :-",
	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 2,
			Font.NORMAL)));
para98.setAlignment(Element.ALIGN_LEFT);
document.add(para98);
	document.add(space4);

PdfPTable table26101 = new PdfPTable(2);
table26101.setWidthPercentage(95);
float[] columnWidths421 = {0.2f,5f};
table26101.setWidths(columnWidths421);
PdfPCell cell26101 = new PdfPCell();

cell26101 = new PdfPCell(new Paragraph(new Chunk("1).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorder(PdfPCell.NO_BORDER);
cell26101.setBorderColor(new Color(0, 0, 0));
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("Member Secretary, JKPCC for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorderColor(new Color(0, 0, 0));
cell26101.setBorder(PdfPCell.NO_BORDER);
table26101.addCell(cell26101);
cell26101 = new PdfPCell(new Paragraph(new Chunk("2).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorder(PdfPCell.NO_BORDER);
cell26101.setBorderColor(new Color(0, 0, 0));
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("Regional Director Jammu/Kashmir for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorderColor(new Color(0, 0, 0));
cell26101.setBorder(PdfPCell.NO_BORDER);
table26101.addCell(cell26101);
cell26101 = new PdfPCell(new Paragraph(new Chunk("3).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorder(PdfPCell.NO_BORDER);
cell26101.setBorderColor(new Color(0, 0, 0));
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("Environmental Engineer (Head e-Governance) JKPCC for information. for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorderColor(new Color(0, 0, 0));
cell26101.setBorder(PdfPCell.NO_BORDER);
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("4).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorder(PdfPCell.NO_BORDER);
cell26101.setBorderColor(new Color(0, 0, 0));
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("Director, School Education Jammu/Kashmir for information for information.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorderColor(new Color(0, 0, 0));
cell26101.setBorder(PdfPCell.NO_BORDER);
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("5).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorder(PdfPCell.NO_BORDER);
cell26101.setBorderColor(new Color(0, 0, 0));
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("Divisional Officer PCC "+ indDistrict +" for information", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorderColor(new Color(0, 0, 0));
cell26101.setBorder(PdfPCell.NO_BORDER);
table26101.addCell(cell26101);


cell26101 = new PdfPCell(new Paragraph(new Chunk("6).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorder(PdfPCell.NO_BORDER);
cell26101.setBorderColor(new Color(0, 0, 0));
table26101.addCell(cell26101);

cell26101 = new PdfPCell(new Paragraph(new Chunk("Office file.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE -2, Font.NORMAL))));
cell26101.setHorizontalAlignment(Element.ALIGN_LEFT);
cell26101.setVerticalAlignment(Element.ALIGN_LEFT);
cell26101.setPadding(3.0f);
cell26101.setBorderColor(new Color(0, 0, 0));
cell26101.setBorder(PdfPCell.NO_BORDER);
table26101.addCell(cell26101);

document.add(table26101);
//document.add(space4);

Paragraph para98B = new Paragraph();
para98B.add(new Chunk("(The school shall comply to environmental standards as notified under the Environment Protection Act 1986, read with the Water \n(Prevention and Control of Pollution) Act 1974 and Air (Prevention and Control of Pollution) Act 1981)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3,Font.ITALIC)));
para98B.setAlignment(Element.ALIGN_CENTER);
document.add(para98B);
document.add(space4);
document.close();
return tempFile;
}



    private static String capitalizeFirstLetter(String str) {
        return WordUtils.capitalizeFully(str);
    
    }
}



