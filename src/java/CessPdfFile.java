
import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
//import com.sun.java_cup.internal.internal_error;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class CessPdfFile {

    public File cessPdfFunction(String industryName,String indcity,String inddistrict,String indaddress,String indpin,String indplot,String fromDate,String toDate,ArrayList cessDetails ) throws Exception
    {
        File tempFile = new File("CessRecord.pdf");
        
        	
        	
        	
        	java.util.Date date = new java.util.Date();
        	int  year=date.getYear();
        	 if (year < 1000)
                year+=1900;
          	int day=date.getDate();
          	int month=(date.getMonth()) + 1;
          
           


            Document document = new Document(PageSize.LEDGER);


            PdfWriter.getInstance(document,
                    new FileOutputStream(tempFile));
            document.open();
            
            Paragraph space = new Paragraph();
            space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
            space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));

            space.setAlignment(Element.ALIGN_CENTER);

            
            Image image = Image.getInstance("images2/ChhattisgarhECB.jpg");
    		
    		image.scalePercent(50.0f);
    		image.setAlignment(Image.MIDDLE | Image.TEXTWRAP);
    		document.add(image);
    		
    		Paragraph heading = new Paragraph();
    		heading.add(new Chunk("CHHATTISGARH ENVIRONMENT CONSERVATION BOARD",
    				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 7, Font.BOLD)));
    		heading.setAlignment(Element.ALIGN_CENTER);

    		document.add(heading);
    		
            Paragraph subheading = new Paragraph();
            subheading.add(new Chunk("1-Tilak Nagar, Shiv Mandir Chowk, Main Road, Avanti Vihar, Raipur (C.G.)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 6,Font.BOLD)));
            subheading.setAlignment(Element.ALIGN_CENTER);

            document.add(subheading);
            document.add(space);
            
            Paragraph line = new Paragraph();
            line.add(new Chunk("Cess Rules 1978 GOI (Ministry of Works & Housing) See rule 4 / Return regarding Water Consumption from "+fromDate+" to "+toDate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4,Font.BOLD)));
            line.setAlignment(Element.ALIGN_LEFT);

            document.add(line);

            document.add(space);
            PdfPCell cell = new PdfPCell();
          
            
           
            PdfPTable table1 = new PdfPTable(8);
            
            table1.setWidthPercentage(100);
          
            cell = new PdfPCell(new Paragraph(new Chunk("Purpose of which Water Consumed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
            //cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            table1.addCell(cell);
           

            cell = new PdfPCell(new Paragraph(new Chunk("Source", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            table1.addCell(cell);
            
            
            cell = new PdfPCell(new Paragraph(new Chunk("Reading at the beginning of the first day of the calendar month", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD ))));
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
           // cell.setBorderWidth(2f);
            cell.setBorderColor(new Color(0, 0, 0));
            table1.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("Reading at the end of the last day of the calendar month", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorderWidth(2f);
           // cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
            table1.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("Quantity of water consumed in Kilo liters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
           // cell.setBorderWidth(2f);
            cell.setBorderColor(new Color(0, 0, 0));
            table1.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("If the meter was out of order the monthly average consumptions of water for the previous 3 months of the working period", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
          //  cell.setBorderWidth(2f);
            cell.setBorderColor(new Color(0, 0, 0));
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Chunk("Quantity of water qualifying for rebate according to the assesse", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
          //  cell.setBorderWidth(2f);
            cell.setBorderColor(new Color(0, 0, 0));
            table1.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
          //  cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
          
          //  cell.setBorderWidth(2f);
           // cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
            table1.addCell(cell);
            
            
            for (int i = 2; i <= 9; i++) {
            cell = new PdfPCell(new Paragraph(new Chunk(""+i, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
            //cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            table1.addCell(cell);
            }
            for (int var6 = 0; var6 < cessDetails.size(); var6++) {
				ArrayList al3 = (ArrayList) cessDetails.get(var6);
				
			  
				for (int var7 = 0; var7 < al3.size(); var7++) {
					
					String d = (String) al3.get(var7);
						
						cell = new PdfPCell(new Paragraph(d));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			            cell.setVerticalAlignment(Element.ALIGN_CENTER);
			            cell.setBorder(PdfPCell.NO_BORDER);
			         
			           // cell.setBackgroundColor (new Color (206, 232, 234));
			           // cell.setBorder(PdfPCell.NO_BORDER);
			            cell.setPadding(3.0f);
			           // cell.addElement(space);
			            table1.addCell(cell);
				}
				}
            PdfPTable table2 = new PdfPTable(1);
            
            table2.setWidthPercentage(100);
           
            cell = new PdfPCell(new Paragraph(new Chunk("Name and Address of the consumer                                                            --                                                                                         --                                                                                             --                                                                                   --                                                                                      --                                                                                                                                                                                                    --", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
            //cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            table2.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("1", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
            //cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            table2.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk(""+industryName+"\n"+indaddress+",Plot no. "+indplot+",\n"+indcity+",\n"+inddistrict+"\n"+indpin)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
            cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            table2.addCell(cell);
            
            float[] widths = {1,8};
            
            PdfPTable table3 = new PdfPTable(widths);
            
            table3.setWidthPercentage(100);
          
            cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            cell.addElement(table2);
            table3.addCell(cell);
            
            cell = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,Font.BOLD))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
           // cell.setBackgroundColor (new Color (102, 183, 189));
            cell.setPadding(3.0f);
           // cell.setBorder(PdfPCell.NO_BORDER);
            cell.setBorderColor(new Color(0, 0, 0));
           // cell.setBorderWidth(2f);
            cell.addElement(table1);
            table3.addCell(cell);
            
            document.add(table3);
            
            document.add(space);
            Paragraph line1 = new Paragraph();
            line1.add(new Chunk("( ) for claiming rebate col the assessee shall indicate in this column the analytical and other reports annexed to this return in support of this claim.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4,Font.BOLD)));
            line1.setAlignment(Element.ALIGN_LEFT);

            document.add(line1);
            
            document.add(space);
            document.add(space);
            
            Paragraph ending = new Paragraph();
            ending.add(new Chunk("Address:\n\nDate:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE+ 4,Font.BOLD  )));
            ending.setAlignment(Element.ALIGN_LEFT);
            document.add(ending);
         
            Paragraph signature = new Paragraph();
            signature.add(new Chunk("Signature of consumer:.............\n\nName:.....................................", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE+ 4,Font.BOLD  )));
            signature.setAlignment(Element.ALIGN_RIGHT);
            document.add(signature);
           
            document.close();

        
        return tempFile;
    }
}
