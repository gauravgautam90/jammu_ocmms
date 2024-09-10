
import java.awt.Color;
import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class DevImg{
public  void insImg(String date1,String date2,String name,String address1,String tehsilName,String districtName,String val1,String fileNo ,String order)throws Exception
{
//	Rectangle pageSize = new Rectangle(PageSize.A4);
////	pageSize.setBackgroundColor
//	//	(new java.awt.Color(0xaa, 0xaa, 0xDE));
    Document document = new Document(PageSize.A4);


PdfWriter.getInstance(document,
new FileOutputStream("imagesWrapPDF.pdf"));
document.open();

Image image = Image.getInstance ("web-app/images2/images.jpeg");
//document.add(image); 
image.scalePercent (50.0f);
image.setAlignment(Image.LEFT | Image.TEXTWRAP);
document.add(image);

Paragraph p = new Paragraph();
Chunk ch=new Chunk("State Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD));
//ch.setHorizontalScaling(20);
p.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p.add(ch);
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 

document.add(p);


Paragraph p1 = new Paragraph();
Chunk ch1=new Chunk("Industrial Area, India", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1));
//ch.setHorizontalScaling(20);
p1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p1.add(ch1);
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 

document.add(p1);

Paragraph p2 = new Paragraph();

//ch.setHorizontalScaling(20);
p2.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p2.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
p2.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 

document.add(p2);




Paragraph date = new Paragraph();
date.add(new Chunk("Dispatch Date :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
date.add(new Chunk(date1, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
date.setAlignment(Element.ALIGN_RIGHT);
document.add(date);

Paragraph file = new Paragraph();
file.add(new Chunk("File No :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
file.add(new Chunk(fileNo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(file);

Paragraph orderNo = new Paragraph();
orderNo.add(new Chunk("Order No :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
orderNo.add(new Chunk(order, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(orderNo);



Paragraph indName = new Paragraph(name);

document.add(indName);

Paragraph address = new Paragraph(address1);

document.add(address);

Paragraph tehsil = new Paragraph();
tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
tehsil.add(new Chunk(tehsilName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(tehsil);

Paragraph district = new Paragraph();
district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
district.add(new Chunk(districtName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(district);

Paragraph subject = new Paragraph();
Chunk ch2= new Chunk("Consent To Establish under section 21(4) of the Air(Prevention & Control of Pollution Act, 1981.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE ));
//ch2.setHorizontalScaling(20);
subject.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
subject.add(ch2);
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(subject);
Paragraph reference = new Paragraph();
reference.add(new Chunk("Ref:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
reference.add(new Chunk("Your application(s) for Consent to Establish dated "+date1+"and subsequent correspondence.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(reference);

Paragraph sir = new Paragraph();
sir.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
document.add(sir);

Paragraph paragraph1=new Paragraph();


//PdfPTable table=new PdfPTable(2);

Paragraph para=new Paragraph();
para.add(new Chunk("Consent to Establish under the provisions of section 21/(4)of the Air(Prevention &Control of Pollution) Act, 1981,(hereinafter to be referred as the Air Act)as amended to date and rules & the orders issued thereunder, is hereby granted for your Industry situated at", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
para.add(new Chunk(address1, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
para.add(new Chunk("  Tehsil "+tehsilName+", District "+districtName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
para.add(new Chunk(" Rajasthan under the provisions of the said Act(s). This consent is granted on the basis of examination of the information furnished by you in consent application (s) and the documents submitted therewith, subject to the following conditions:-"));
para.add(new Chunk("                         "));

para.setFirstLineIndent(40);//setIndentationLeft(50);

document.add(para);
//para.setSpacingBefore(150);
//para.setExtraParagraphSpace(20.0f);

//para.setAlignment(Element.ALIGN_LEFT);

//PdfPCell cell = new PdfPCell (new Paragraph ());
/*PdfPCell cell = new PdfPCell ();
cell.setColspan (2);
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell.setPadding (10.0f);
cell.addElement(para);
table.addCell (cell);
PdfPCell cell1 = new PdfPCell ();
cell1.addElement(para11);
table.addCell("Dispatch Date:");
table.addCell(cell1);
table.addCell("");*/


//Chunk chunk=new Chunk("Welecome To INFOG.");
//chunk.setUnderline(+1f,-2f);
//Chunk chunk1=new Chunk("SPCB");
//chunk1.setUnderline(+4f,-2f);
//chunk1.setBackground(Color.red);
//document.add(chunk);
//document.add(chunk1);

//Phrase phrase0 = new Phrase(val1);
//
//Phrase phrase1 = new Phrase(val2);
//Phrase phrase2 = new Phrase(25,val3);
//Phrase phrase3 = new Phrase(val3,    FontFactory.getFont(FontFactory.COURIER, 20,Font.NORMAL,new Color(255, 0, 0)));

//Chapter chapter=new Chapter(new Paragraph("Chapter1"),1);
//Section section1=chapter.addSection(new Paragraph("Section1"));
//
//section1.add(new Paragraph("Rose India"));
//Section section2=chapter.addSection(new Paragraph("section2"));
//section2.add(new Paragraph("roseinia.net"));
//document.add(chapter);
Paragraph para6=new Paragraph("");
//Phrase phrase4 = new Phrase(25,val1);
//Paragraph para=new Paragraph(val1);
//para.setFirstLineIndent(50);//setIndentationLeft(50);

//para.setSpacingBefore(150);
//para.setExtraParagraphSpace(20.0f);

//para.setAlignment(Element.ALIGN_LEFT);
//document.add(new Paragraph("Margin--->>roseinia.net"));
//document.setMargins(180,50,71,10);
//document.add(new Paragraph("You can visit roseindia.net for more java tutorials"));
//for (int i = 0; i < 10; i++) {                
//paragraph.add("Hello roseindia.net.");
//}
//document.setMarginMirroring(true);
//document.add(new Paragraph("Starting on the next page,."));  
//document.add(paragraph);
//Paragraph para4=new Paragraph("");
//Paragraph para2=new Paragraph(val2);
//para2.setExtraParagraphSpace(50.0f);
//Paragraph para5=new Paragraph("");
//Paragraph para3=new Paragraph(val3);
//para3.setAlignment(Element.ALIGN_CENTER);

/////////table////////////////////

PdfPTable table=new PdfPTable(3);

PdfPCell cell = new PdfPCell ();
//cell.setColspan (2);
////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
////cell.setBackgroundColor (new Color (128, 200, 128));
////cell.setPadding (10.0f);
//table.addCell (cell);
cell = new PdfPCell (new Paragraph ("Particulars"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);
cell = new PdfPCell (new Paragraph ("Type"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("Quantity with Unit"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("STONE DUST"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("ByProduct"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("345 TPD"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("STONE GRIT"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("Product"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("1955 TPD"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

List list=new List(true,30);
list.add(new ListItem(val1));
//list.add(new ListItem(val2));
//
////list.add(new chunm);
//
//
//List list1=new List(true,30);
//list1.setFirst(3);
//list1.add(new ListItem(val1));
//list1.add(new ListItem(val2));
//
//list1.add(new ListItem(val2));

Paragraph pgh=new Paragraph();
pgh.add(new Chunk("                     "));

//Paragraph para5=new Paragraph();
//para.add(new Chunk("1. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +1, Font.BOLD )));
//para.add(new Chunk(val1, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//para.add(new Chunk("  Tehsil "+tehsilName+", District "+districtName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
//para.add(new Chunk(" Rajasthan under the provisions of the said Act(s). This consent is granted on the basis of examination of the information furnished by you in consent application (s) and the documents submitted therewith, subject to the following conditions:-"));
//para.add(new Chunk("                         "));
//
//para.setFirstLineIndent(40);//setIndentationLeft(50);
//
//document.add(para);

//table.addCell("Name");
//table.addCell("Place");
//table.addCell("RoseIndia");
//table.addCell("Delhi");

//document.add(phrase0);
//document.add(phrase1);
//document.add(phrase2);
//document.add(phrase3);
//document.add(para4); 
//
////document.add(phrase4); 
//document.add(para5); 
//document.add(para2);
document.add(para6); 
//document.add(para3); 
document.add(list); 
document.add(pgh);
document.add(table);
//document.add(list1); 
document.close();
}

public  void insImg1(String date1,String date2,String name,String address1,String tehsilName,String districtName,String [] val1,String fileNo ,String order)throws Exception
{
//	Rectangle pageSize = new Rectangle(PageSize.A4);
////	pageSize.setBackgroundColor
//	//	(new java.awt.Color(0xaa, 0xaa, 0xDE));
	
	
	
	
	
    Document document = new Document(PageSize.A4);

    PdfWriter.getInstance(document,
    new FileOutputStream("imagesWrapPDF.pdf"));
    document.open();

    Image image = Image.getInstance ("web-app/images2/images.jpeg");
    //document.add(image); 
    image.scalePercent (50.0f);
    image.setAlignment(Image.LEFT | Image.TEXTWRAP);
    document.add(image);

    Paragraph p = new Paragraph();
    Chunk ch=new Chunk("State Pollution Control Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD));
    //ch.setHorizontalScaling(20);
    p.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p.add(ch);
    //p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 

    document.add(p);


    Paragraph p1 = new Paragraph();
    Chunk ch1=new Chunk("Industrial Area, India", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1));
    //ch.setHorizontalScaling(20);
    p1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p1.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p1.add(ch1);
    //p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 

    document.add(p1);

    Paragraph p2 = new Paragraph();

    //ch.setHorizontalScaling(20);
    p2.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p2.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));
    p2.add(new Chunk("           ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 3, Font.BOLD)));

    //p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 

    document.add(p2);

Paragraph date = new Paragraph();
date.add(new Chunk("Dispatch Date :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
date.add(new Chunk(date1, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
date.setAlignment(Element.ALIGN_RIGHT);
document.add(date);

Paragraph file = new Paragraph();
file.add(new Chunk("File No :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
file.add(new Chunk(fileNo, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(file);

Paragraph orderNo = new Paragraph();
orderNo.add(new Chunk("Order No :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
orderNo.add(new Chunk(order, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(orderNo);
List list=new List(true,30);
for(int i=0;i<val1.length;i++)
{
	list.add(new ListItem(val1[i]));
}

Paragraph indName = new Paragraph(name);

document.add(indName);

Paragraph address = new Paragraph(address1);

document.add(address);

Paragraph tehsil = new Paragraph();
tehsil.add(new Chunk("Tehsil :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
tehsil.add(new Chunk(tehsilName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(tehsil);

Paragraph district = new Paragraph();
district.add(new Chunk("District :", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
district.add(new Chunk(districtName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(district);

Paragraph subject = new Paragraph();
Chunk ch2= new Chunk("Consent To Establish under section 21(4) of the Air(Prevention & Control of Pollution Act, 1981.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE ));
//ch2.setHorizontalScaling(20);
subject.add(new Chunk("Sub:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
subject.add(ch2);
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(subject);
Paragraph reference = new Paragraph();
reference.add(new Chunk("Ref:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
reference.add(new Chunk("Your application(s) for Consent to Establish dated "+date1+"and subsequent correspondence.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
//p.add(new Chunk("something3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD))); 
document.add(reference);

Paragraph sir = new Paragraph();
sir.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
document.add(sir);

Paragraph paragraph1=new Paragraph();


//PdfPTable table=new PdfPTable(2);

Paragraph para=new Paragraph();
para.add(new Chunk("Consent to Establish under the provisions of section 21/(4)of the Air(Prevention &Control of Pollution) Act, 1981,(hereinafter to be referred as the Air Act)as amended to date and rules & the orders issued thereunder, is hereby granted for your Industry situated at", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE )));
para.add(new Chunk(address1, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
para.add(new Chunk("  Tehsil "+tehsilName+", District "+districtName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
para.add(new Chunk(" Rajasthan under the provisions of the said Act(s). This consent is granted on the basis of examination of the information furnished by you in consent application (s) and the documents submitted therewith, subject to the following conditions:-"));
para.add(new Chunk("                         "));

para.setFirstLineIndent(40);//setIndentationLeft(50);

document.add(para);
//para.setSpacingBefore(150);
//para.setExtraParagraphSpace(20.0f);

//para.setAlignment(Element.ALIGN_LEFT);

//PdfPCell cell = new PdfPCell (new Paragraph ());
/*PdfPCell cell = new PdfPCell ();
cell.setColspan (2);
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (128, 200, 128));
cell.setPadding (10.0f);
cell.addElement(para);
table.addCell (cell);
PdfPCell cell1 = new PdfPCell ();
cell1.addElement(para11);
table.addCell("Dispatch Date:");
table.addCell(cell1);
table.addCell("");*/


//Chunk chunk=new Chunk("Welecome To INFOG.");
//chunk.setUnderline(+1f,-2f);
//Chunk chunk1=new Chunk("SPCB");
//chunk1.setUnderline(+4f,-2f);
//chunk1.setBackground(Color.red);
//document.add(chunk);
//document.add(chunk1);

//Phrase phrase0 = new Phrase(val1);
//
//Phrase phrase1 = new Phrase(val2);
//Phrase phrase2 = new Phrase(25,val3);
//Phrase phrase3 = new Phrase(val3,    FontFactory.getFont(FontFactory.COURIER, 20,Font.NORMAL,new Color(255, 0, 0)));

//Chapter chapter=new Chapter(new Paragraph("Chapter1"),1);
//Section section1=chapter.addSection(new Paragraph("Section1"));
//
//section1.add(new Paragraph("Rose India"));
//Section section2=chapter.addSection(new Paragraph("section2"));
//section2.add(new Paragraph("roseinia.net"));
//document.add(chapter);
Paragraph para6=new Paragraph("");
//Phrase phrase4 = new Phrase(25,val1);
//Paragraph para=new Paragraph(val1);
//para.setFirstLineIndent(50);//setIndentationLeft(50);

//para.setSpacingBefore(150);
//para.setExtraParagraphSpace(20.0f);

//para.setAlignment(Element.ALIGN_LEFT);
//document.add(new Paragraph("Margin--->>roseinia.net"));
//document.setMargins(180,50,71,10);
//document.add(new Paragraph("You can visit roseindia.net for more java tutorials"));
//for (int i = 0; i < 10; i++) {                
//paragraph.add("Hello roseindia.net.");
//}
//document.setMarginMirroring(true);
//document.add(new Paragraph("Starting on the next page,."));  
//document.add(paragraph);
//Paragraph para4=new Paragraph("");
//Paragraph para2=new Paragraph(val2);
//para2.setExtraParagraphSpace(50.0f);
//Paragraph para5=new Paragraph("");
//Paragraph para3=new Paragraph(val3);
//para3.setAlignment(Element.ALIGN_CENTER);

/////////table////////////////////

PdfPTable table=new PdfPTable(3);

PdfPCell cell = new PdfPCell ();
//cell.setColspan (2);
////cell.setHorizontalAlignment (Element.ALIGN_CENTER);
////cell.setBackgroundColor (new Color (128, 200, 128));
////cell.setPadding (10.0f);
//table.addCell (cell);
cell = new PdfPCell (new Paragraph ("Particulars"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);
cell = new PdfPCell (new Paragraph ("Type"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("Quantity with Unit"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("STONE DUST"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("ByProduct"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("345 TPD"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("STONE GRIT"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("Product"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

cell = new PdfPCell (new Paragraph ("1955 TPD"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
//cell.setBackgroundColor (new Color (255, 200, 0));
cell.setPadding (10.0f);
table.addCell (cell);

//List list=new List(true,30);
//list.add(new ListItem(val1));
//list.add(new ListItem(val2));
//
////list.add(new chunm);
//
//
//List list1=new List(true,30);
//list1.setFirst(3);
//list1.add(new ListItem(val1));
//list1.add(new ListItem(val2));
//
//list1.add(new ListItem(val2));

Paragraph pgh=new Paragraph();
pgh.add(new Chunk("                     "));

//Paragraph para5=new Paragraph();
//para.add(new Chunk("1. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +1, Font.BOLD )));
//para.add(new Chunk(val1, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1)));
//para.add(new Chunk("  Tehsil "+tehsilName+", District "+districtName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
//para.add(new Chunk(" Rajasthan under the provisions of the said Act(s). This consent is granted on the basis of examination of the information furnished by you in consent application (s) and the documents submitted therewith, subject to the following conditions:-"));
//para.add(new Chunk("                         "));
//
//para.setFirstLineIndent(40);//setIndentationLeft(50);
//
//document.add(para);

//table.addCell("Name");
//table.addCell("Place");
//table.addCell("RoseIndia");
//table.addCell("Delhi");

//document.add(phrase0);
//document.add(phrase1);
//document.add(phrase2);
//document.add(phrase3);
//document.add(para4); 
//
////document.add(phrase4); 
//document.add(para5); 
//document.add(para2);
document.add(para6); 
//document.add(para3); 
document.add(list); 
document.add(pgh);
document.add(table);
//document.add(list1); 
document.close();
}

}