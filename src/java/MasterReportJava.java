import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.Color;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class MasterReportJava {
	
	public File freshInspectionPdf(String applicationType,String certificateFor,ArrayList feeList,String applicationFor,ArrayList AirStackDetailsList,ArrayList IndProductDetailsList
			,ArrayList airFlueGasEmissionDetailsList,ArrayList airMiscDetailsList,ArrayList waterSourceDetailsList,ArrayList treatmentDetailsList
			,ArrayList wasteWaterGenerationDetailsFinalList1,ArrayList waterSolidWasteGenDetailsInstanceFinalList
			,String indName,String indAddress,long indNewCapInvt,String dateOfComm,String indEmail,String expDate,String shiftsIndustry,String monitoring
			,String expNoEmp,String noOfEmp,String waterMonitoring,String siteArea,String nearRiver
			,String riverName,String riverDist,String nearResidCol,String colPopulation,String colLocation,String colDistance,String nearIndEstate
			,String disposalSysProv,String utilizeSys,String proposalDetails,String totalPlotArea,String plotArea,String builtUpArea,ArrayList stoneCrusherList
			,ArrayList stoneCrusherControlList,ArrayList NocAuthorityList,ArrayList StoneCrusherWaterList,ArrayList WaterConsumptionList,ArrayList BrickSittingList
			,ArrayList BrickKilnList,ArrayList HotelGeneralList,ArrayList hotelFacilityDetail,ArrayList hotelWasteEmissionDetail,ArrayList hotelWaterConsumptionDetail
			,ArrayList SetDetails,ArrayList emissionDetailsList,ArrayList parameterDetailsList,ArrayList HazardousWasteGenDetailsList,String hazardeousType)	throws Exception {
		File tempFile = new File("Inspection Report.pdf");
		try{
			
		
				Document document = new Document(PageSize.A4);
				PdfWriter.getInstance(document, new FileOutputStream(tempFile));
				
				Phrase headerPhrase = new Phrase ("");
				HeaderFooter header = new HeaderFooter(headerPhrase, true);
				header.setAlignment(Element.ALIGN_CENTER);
				document.setFooter(header);
				
				document.open();
				Paragraph space = new Paragraph();
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
				space.add(new Chunk("                                          ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 4, Font.BOLD)));
				
				space.setAlignment(Element.ALIGN_CENTER);
				
				Image image = Image.getInstance("images2/ChhattisgarhECB.JPG");
				image.scalePercent(50.0f);
				image.setAlignment(Image.LEFT | Image.TEXTWRAP);
				document.add(image);
				document.add(space);
				
				
					
				Paragraph partCb = new Paragraph();
				partCb.add(new Chunk("J&K Pollution Control Committee Jammu",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				partCb.setAlignment(Element.ALIGN_CENTER);
				document.add(partCb);
				
				Paragraph partCb1 = new Paragraph();
				partCb1.add(new Chunk("INDUSTRY MASTER DATA",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
				partCb1.setAlignment(Element.ALIGN_CENTER);
				document.add(partCb1);
				
				document.add(space);
				
				PdfPTable tablez=new PdfPTable(3);
				PdfPCell cellz = new PdfPCell ();
				float[] columnWidthz = new float[] {3f,20f,25f};
				tablez.setWidths(columnWidthz);
				tablez.setWidthPercentage(100);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Name and Location of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Correspondence Address ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
			
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+indAddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+indNewCapInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Establish/Operate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Fresh/Renewal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+certificateFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
			
				
				cellz = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of Factory", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+dateOfComm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				
				
				cellz = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("E-Mail Address", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+indEmail, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				
				
				cellz = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Shifts in Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+shiftsIndustry, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Monitoring is being ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+monitoring, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Total number of Workers", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+monitoring, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Total number of office Staff", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+noOfEmp, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("What monitoring arrangement is currently there or proposed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+waterMonitoring, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Site Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+siteArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				
				cellz = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Site Is Located Near River Bank/Water Bodies", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+nearRiver, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+riverName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Distance in meters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+riverDist, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("14", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Site Is Located Near Residential Colony", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+nearResidCol, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+colPopulation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+colLocation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Distance in Meters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+colDistance, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("15", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Is Site Located Near Industrial Estate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+nearIndEstate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("16", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether Collection, Treatment & Disposal System Provided", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+disposalSysProv, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("17", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Will Applicant Utilize The System", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+utilizeSys, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("18", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details Of Proposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+proposalDetails, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("19", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Total Plot Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+totalPlotArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("20", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Build-up Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+plotArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("21", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Area used for Treated Sewage/Trade Effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+builtUpArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				
				document.add(tablez);	
				document.add(space);
				
				Paragraph partCb1a17 = new Paragraph();
				partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
						"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb1a17.setAlignment(Element.ALIGN_LEFT);
				document.add(partCb1a17);
				document.add(space);
				
				PdfPTable tableFees = new PdfPTable(5);
				PdfPCell cellFees = new PdfPCell();
				tableFees.setWidthPercentage(100);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk(
						"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);

				for (int var2 = 0; var2 < feeList.size(); var2++) {
					ArrayList feeList1 = (ArrayList) feeList.get(var2);

					for (int var3 = 0; var3 < feeList1.size(); var3++) {

						String feeInner = (String) feeList1.get(var3);
						cellFees = new PdfPCell(new Paragraph(feeInner));
						cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees.setPadding(5.0f);
						tableFees.addCell(cellFees);
					}}		
				document.add(tableFees);
				document.add(space);
				
			if(applicationFor.equals("stonecrusher") || applicationFor.equals("brickkilns") || applicationFor.equals("both") || 
					applicationFor.equals("stonecrusher and hotmixplants") || applicationFor.equals("hotmixplants"))	
			{	
			Paragraph partCbbc = new Paragraph();
			partCbbc.add(new Chunk("PRODUCT DETAILS",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbbc.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbbc);
			document.add(space);
				
			PdfPTable tableQ27=new PdfPTable(6);
			PdfPCell cellQ27 = new PdfPCell ();
			float[] columnWidthQ27 = new float[] {1f,1f,1f,1f,1f,1f};
			tableQ27.setWidths(columnWidthQ27);
			tableQ27.setWidthPercentage(100);
									
			cellQ27 = new PdfPCell (new Paragraph (new Chunk("Raw Material", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27.addCell (cellQ27);
					
			cellQ27 = new PdfPCell (new Paragraph (new Chunk("Product manufactured", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27.addCell (cellQ27);
			
			cellQ27 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27.addCell (cellQ27);
			
			cellQ27 = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27.addCell (cellQ27);
			
			cellQ27 = new PdfPCell (new Paragraph (new Chunk("By-product", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27.addCell (cellQ27);
			
			cellQ27 = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27.addCell (cellQ27);
		
			for(int var3=0;var3<IndProductDetailsList.size();var3++)
			{
				ArrayList al2=(ArrayList) IndProductDetailsList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ27 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
				cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellQ27.setPadding (5.0f);
					tableQ27.addCell (cellQ27);
				}
				}	
				
			document.add(tableQ27);
			}
			document.add(space);
			
			if(applicationFor.equals("stonecrusher") || applicationFor.equals("stonecrusher and hotmixplants") || applicationFor.equals("hotmixplants")){
				
				Paragraph partCbc5 = new Paragraph();
				partCbc5.add(new Chunk("Stone Crusher/Hot mix plants Siting Criteria Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc5.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc5);
				document.add(space);
				
				
				PdfPTable tableQ275=new PdfPTable(2);
				PdfPCell cellQ275 = new PdfPCell ();
				float[] columnWidthQ275 = new float[] {1f,1f};
				tableQ275.setWidths(columnWidthQ275);
				tableQ275.setWidthPercentage(100);
										
				cellQ275 = new PdfPCell (new Paragraph (new Chunk("Parameter", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ275.addCell (cellQ275);

				cellQ275 = new PdfPCell (new Paragraph (new Chunk("Distance fron Unit/Proposed site", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ275.addCell (cellQ275);
				
				
				
				for(int var3=0;var3<stoneCrusherList.size();var3++)
				{
					ArrayList al2=(ArrayList) stoneCrusherList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ275 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ275.setPadding (5.0f);
						tableQ275.addCell (cellQ275);
					}
					}	
					
				document.add(tableQ275);
				document.add(space);
				
				
				Paragraph partCbc6 = new Paragraph();
				partCbc6.add(new Chunk("Stone Crusher/Hot mix plants Pollution Control Devices Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc6.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc6);
				document.add(space);
				
				
				PdfPTable tableQ276=new PdfPTable(3);
				PdfPCell cellQ276 = new PdfPCell ();
				float[] columnWidthQ276 = new float[] {1f,1f,1f};
				tableQ276.setWidths(columnWidthQ276);
				tableQ276.setWidthPercentage(100);
										
				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Pollution Control Devices", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);

				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);
				
				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Status", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);
				
				
				
				for(int var3=0;var3<stoneCrusherControlList.size();var3++)
				{
					ArrayList al2=(ArrayList) stoneCrusherControlList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ276 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ276.setPadding (5.0f);
						tableQ276.addCell (cellQ276);
					}
					}	
					
				document.add(tableQ276);
				document.add(space);
				
				
				Paragraph partCbc7 = new Paragraph();
				partCbc7.add(new Chunk("NOC Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc7.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc7);
				document.add(space);
				
					
				PdfPTable tableQ277=new PdfPTable(4);
				PdfPCell cellQ277 = new PdfPCell ();
				float[] columnWidthQ277 = new float[] {1f,1f,1f,1f};
				tableQ277.setWidths(columnWidthQ277);
				tableQ277.setWidthPercentage(100);
										
				cellQ277 = new PdfPCell (new Paragraph (new Chunk("Issuing Authority", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ277.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ277.addCell (cellQ277);

				cellQ277 = new PdfPCell (new Paragraph (new Chunk("Status", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ277.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ277.addCell (cellQ277);
				
				cellQ277 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ277.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ277.addCell (cellQ277);
				
				cellQ277 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ277.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ277.addCell (cellQ277);
				
				
				
				for(int var3=0;var3<NocAuthorityList.size();var3++)
				{
					ArrayList al2=(ArrayList) NocAuthorityList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ277 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ277.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ277.setPadding (5.0f);
						tableQ277.addCell (cellQ277);
					}
					}	
					
				document.add(tableQ277);
				document.add(space);
				
				
				
				Paragraph partCbc8 = new Paragraph();
				partCbc8.add(new Chunk("Water Source Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc8.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc8);
				document.add(space);
				
				
				PdfPTable tableQ278=new PdfPTable(2);
				PdfPCell cellQ278 = new PdfPCell ();
				float[] columnWidthQ278 = new float[] {1f,1f};
				tableQ278.setWidths(columnWidthQ278);
				tableQ278.setWidthPercentage(100);
										
				cellQ278 = new PdfPCell (new Paragraph (new Chunk("Source of water supply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ278.addCell (cellQ278);
				
				cellQ278 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ278.addCell (cellQ278);
				
				for(int var3=0;var3<StoneCrusherWaterList.size();var3++)
				{
					ArrayList al2=(ArrayList) StoneCrusherWaterList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ278 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ278.setPadding (5.0f);
						tableQ278.addCell (cellQ278);
					}
					}	
					
				document.add(tableQ278);
				document.add(space);
				
				Paragraph partCbc9 = new Paragraph();
				partCbc9.add(new Chunk("Water Consumption Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc9.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc9);
				document.add(space);
				
				PdfPTable tableQ279=new PdfPTable(3);
				PdfPCell cellQ279 = new PdfPCell ();
				float[] columnWidthQ279 = new float[] {1f,1f,1f};
				tableQ279.setWidths(columnWidthQ279);
				tableQ279.setWidthPercentage(100);
										
				cellQ279 = new PdfPCell (new Paragraph (new Chunk("Water Consumtion Supply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ279.addCell (cellQ279);
				
				cellQ279 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ279.addCell (cellQ279);
				
				cellQ279 = new PdfPCell (new Paragraph (new Chunk("Storage Facility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ279.addCell (cellQ279);
				
				for(int var3=0;var3<WaterConsumptionList.size();var3++)
				{
					ArrayList al2=(ArrayList) WaterConsumptionList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ279 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ279.setPadding (5.0f);
						tableQ279.addCell (cellQ279);
					}
					}	
					
				document.add(tableQ279);
				document.add(space);
				
				
			}
			else if(applicationFor.equals("brickkilns")){
				
				Paragraph partCbc5 = new Paragraph();
				partCbc5.add(new Chunk("Brick Siting Criteria Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc5.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc5);
				document.add(space);
				
				
				PdfPTable tableQ275=new PdfPTable(2);
				PdfPCell cellQ275 = new PdfPCell ();
				float[] columnWidthQ275 = new float[] {1f,1f};
				tableQ275.setWidths(columnWidthQ275);
				tableQ275.setWidthPercentage(100);
										
				cellQ275 = new PdfPCell (new Paragraph (new Chunk("Parameter", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ275.addCell (cellQ275);

				cellQ275 = new PdfPCell (new Paragraph (new Chunk("Distance fron Unit/Proposed site", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ275.addCell (cellQ275);
				
				
				
				for(int var3=0;var3<BrickSittingList.size();var3++)
				{
					ArrayList al2=(ArrayList) BrickSittingList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ275 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ275.setPadding (5.0f);
						tableQ275.addCell (cellQ275);
					}
					}	
					
				document.add(tableQ275);
				document.add(space);
				
				
				Paragraph partCbc6 = new Paragraph();
				partCbc6.add(new Chunk("Brick Kilns Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc6.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc6);
				document.add(space);
				
				
				PdfPTable tableQ276=new PdfPTable(6);
				PdfPCell cellQ276 = new PdfPCell ();
				float[] columnWidthQ276 = new float[] {1f,1f,1f,1f,1f,1f};
				tableQ276.setWidths(columnWidthQ276);
				tableQ276.setWidthPercentage(100);
										
				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Capacity of the Kiln", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);

				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Trench Size", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);
				
				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Chimeny Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);
				
				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Height of Chimeny ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);

				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Any ECD installed along with the Chimeny", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);
				
				cellQ276 = new PdfPCell (new Paragraph (new Chunk("Kiln Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ276.addCell (cellQ276);
				
				
				
				for(int var3=0;var3<BrickKilnList.size();var3++)
				{
					ArrayList al2=(ArrayList) BrickKilnList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ276 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ276.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ276.setPadding (5.0f);
						tableQ276.addCell (cellQ276);
					}
					}	
					
				document.add(tableQ276);
				document.add(space);
				
				Paragraph partCbc8 = new Paragraph();
				partCbc8.add(new Chunk("Water Source Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc8.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc8);
				document.add(space);
				
				
				PdfPTable tableQ278=new PdfPTable(2);
				PdfPCell cellQ278 = new PdfPCell ();
				float[] columnWidthQ278 = new float[] {1f,1f};
				tableQ278.setWidths(columnWidthQ278);
				tableQ278.setWidthPercentage(100);
										
				cellQ278 = new PdfPCell (new Paragraph (new Chunk("Source of water supply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ278.addCell (cellQ278);
				
				cellQ278 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ278.addCell (cellQ278);
				
				for(int var3=0;var3<StoneCrusherWaterList.size();var3++)
				{
					ArrayList al2=(ArrayList) StoneCrusherWaterList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ278 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ278.setPadding (5.0f);
						tableQ278.addCell (cellQ278);
					}
					}	
					
				document.add(tableQ278);
				document.add(space);
				
				Paragraph partCbc9 = new Paragraph();
				partCbc9.add(new Chunk("Water Consumption Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc9.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc9);
				document.add(space);
				
				PdfPTable tableQ279=new PdfPTable(3);
				PdfPCell cellQ279 = new PdfPCell ();
				float[] columnWidthQ279 = new float[] {1f,1f,1f};
				tableQ279.setWidths(columnWidthQ279);
				tableQ279.setWidthPercentage(100);
										
				cellQ279 = new PdfPCell (new Paragraph (new Chunk("Water Consumtion Supply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ279.addCell (cellQ279);
				
				cellQ279 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ279.addCell (cellQ279);
				
				cellQ279 = new PdfPCell (new Paragraph (new Chunk("Storage Facility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ279.addCell (cellQ279);
				
				for(int var3=0;var3<WaterConsumptionList.size();var3++)
				{
					ArrayList al2=(ArrayList) WaterConsumptionList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ279 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ279.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ279.setPadding (5.0f);
						tableQ279.addCell (cellQ279);
					}
					}	
					
				document.add(tableQ279);
				document.add(space);
				
				
			}else if(applicationFor.equals("hotel")){
			
				Paragraph partCbb = new Paragraph();
				partCbb.add(new Chunk("Hotel/Restaurant General Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbb.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbb);
				document.add(space);
				
				PdfPTable table9=new PdfPTable(5);
				PdfPCell cell9 = new PdfPCell ();
				float[] columnWidth9 = new float[] {1f,1f,1f,1f,1f};
				table9.setWidths(columnWidth9);
				table9.setWidthPercentage(100);
							
				cell9 = new PdfPCell (new Paragraph (new Chunk("Name of Hotel/Lodge/Guest House", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Room Capacity of Hotel/Lodge/Guest House", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Total Project Cost(Rs.)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Distance from Major Water Bodies (In Meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				
				
			for(int var323=0;var323<HotelGeneralList.size();var323++)
				{
				ArrayList al2=(ArrayList) HotelGeneralList.get(var323);
					
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cell9 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell9.setPadding (5.0f);
					table9.addCell (cell9);
					}
				}
				
			document.add(table9);
			document.add(space);	
				
				
			
			Paragraph partCbc = new Paragraph();
			partCbc.add(new Chunk("Hotel/Restaurant Facility Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc);
			document.add(space);	
				
				
			PdfPTable tableQ27a=new PdfPTable(4);
			PdfPCell cellQ27a = new PdfPCell ();
			float[] columnWidthQ27a = new float[] {1f,1f,1f,1f};
			tableQ27a.setWidths(columnWidthQ27a);
			tableQ27a.setWidthPercentage(100);
									
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Facility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Facility Detail", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			
				
				
			for(int var3=0;var3<hotelFacilityDetail.size();var3++)
			{
				ArrayList al2=(ArrayList) hotelFacilityDetail.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ27a = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
				cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellQ27a.setPadding (5.0f);
					tableQ27a.addCell (cellQ27a);
				}
				}	
				
			document.add(tableQ27a);
			document.add(space);
			
			Paragraph partCbc1 = new Paragraph();
			partCbc1.add(new Chunk("Hotel/Restaurant Waste Emmission Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc1.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc1);
			document.add(space);		
				
				
			PdfPTable tableQ271=new PdfPTable(4);
			PdfPCell cellQ271 = new PdfPCell ();
			float[] columnWidthQ271 = new float[] {1f,1f,1f,1f};
			tableQ271.setWidths(columnWidthQ271);
			tableQ271.setWidthPercentage(100);
									
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Nature", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Method of Disposal/Treatment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			
			for(int var3=0;var3<hotelWasteEmissionDetail.size();var3++)
			{
				ArrayList al2=(ArrayList) hotelWasteEmissionDetail.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ271 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ271.setPadding (5.0f);
					tableQ271.addCell (cellQ271);
				}
				}	
				
			document.add(tableQ271);
			document.add(space);
			
			
			Paragraph partCbc8 = new Paragraph();
			partCbc8.add(new Chunk("Water Source Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc8.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc8);
			document.add(space);
			
			
			PdfPTable tableQ278=new PdfPTable(2);
			PdfPCell cellQ278 = new PdfPCell ();
			float[] columnWidthQ278 = new float[] {1f,1f};
			tableQ278.setWidths(columnWidthQ278);
			tableQ278.setWidthPercentage(100);
									
			cellQ278 = new PdfPCell (new Paragraph (new Chunk("Source of water supply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ278.addCell (cellQ278);
			
			cellQ278 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ278.addCell (cellQ278);
			
			for(int var3=0;var3<StoneCrusherWaterList.size();var3++)
			{
				ArrayList al2=(ArrayList) StoneCrusherWaterList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ278 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ278.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ278.setPadding (5.0f);
					tableQ278.addCell (cellQ278);
				}
				}	
				
			document.add(tableQ278);
			document.add(space);
			
			Paragraph partCbc9 = new Paragraph();
			partCbc9.add(new Chunk("Water Consumption Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc9.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc9);
			document.add(space);
			
			PdfPTable tableQ278a=new PdfPTable(2);
			PdfPCell cellQ278a = new PdfPCell ();
			float[] columnWidthQ278a = new float[] {1f,1f};
			tableQ278a.setWidths(columnWidthQ278a);
			tableQ278a.setWidthPercentage(100);
									
			cellQ278a = new PdfPCell (new Paragraph (new Chunk("Consumption Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ278a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ278a.addCell (cellQ278a);
			
			cellQ278a = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ278a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ278a.addCell (cellQ278a);
			
			for(int var3=0;var3<hotelWaterConsumptionDetail.size();var3++)
			{
				ArrayList al2=(ArrayList) hotelWaterConsumptionDetail.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ278a = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ278a.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ278a.setPadding (5.0f);
					tableQ278a.addCell (cellQ278a);
				}
				}	
				
			document.add(tableQ278a);
			document.add(space);
			
				
			}else if(applicationFor.equals("dgset")){
			
				Paragraph partCbb = new Paragraph();
				partCbb.add(new Chunk("D.G. Set Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbb.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbb);
				document.add(space);
				
				
			
				PdfPTable tableQ27v=new PdfPTable(8);
				PdfPCell cellQ27v = new PdfPCell ();
				float[] columnWidthQ27v = new float[] {1f,1f,1f,1f,1f,1f,1f,1f};
				tableQ27v.setWidths(columnWidthQ27v);
				tableQ27v.setWidthPercentage(100);
										
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Make of D.G.Set", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Model of D.G.Set", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Power Rating(in KVA)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Fuel Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Stack Height", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Height of the building", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Sound Power Level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				cellQ27v = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
				tableQ27v.addCell (cellQ27v);
				
				for(int var3=0;var3<SetDetails.size();var3++)
				{
					ArrayList al2=(ArrayList) SetDetails.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						String a=(String) al2.get(var341);
						cellQ27v = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ27v.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ27v.setPadding (5.0f);
						tableQ27v.addCell (cellQ27v);
					}
					}	
					
				document.add(tableQ27v);
				document.add(space);
			
			
				Paragraph partCbc = new Paragraph();
				partCbc.add(new Chunk("D.G. Set Emission Source Details",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc);
				document.add(space);
				
				PdfPTable table9=new PdfPTable(9);
				PdfPCell cell9 = new PdfPCell ();
				float[] columnWidth9 = new float[] {10f,10f,10f,10f,10f,10f,10f,10f,10f};
				table9.setWidths(columnWidth9);
				table9.setWidthPercentage(100);
							
				cell9 = new PdfPCell (new Paragraph (new Chunk("Sources of Emission ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Horse Power of the engine", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Engine RPM No Load ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Engine RPM Full Load", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Fuel used and quantity per hour", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Capacity of D.G.Set", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Height of Building where D.G.Set is installed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
				cell9 = new PdfPCell (new Paragraph (new Chunk("Height of the Stack above building", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				

				cell9 = new PdfPCell (new Paragraph (new Chunk("Total of a+b in meters ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9.setBorder(PdfPCell.NO_BORDER);
				table9.addCell (cell9);
				
			for(int var323=0;var323<emissionDetailsList.size();var323++)
				{
				ArrayList al2=(ArrayList) emissionDetailsList.get(var323);
					
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cell9 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell9.setPadding (5.0f);
					table9.addCell (cell9);
					}
				}
				
			document.add(table9);
			document.add(space);
				
			Paragraph partCbc1 = new Paragraph();
			partCbc1.add(new Chunk("D.G. Set Parameter Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc1.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc1);
			document.add(space);		
				
				
			PdfPTable tableQ271=new PdfPTable(3);
			PdfPCell cellQ271 = new PdfPCell ();
			float[] columnWidthQ271 = new float[] {1f,1f,1f};
			tableQ271.setWidths(columnWidthQ271);
			tableQ271.setWidthPercentage(100);
									
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("No Load Condition", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Full Load Condition", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			
			for(int var3=0;var3<parameterDetailsList.size();var3++)
			{
				ArrayList al2=(ArrayList) parameterDetailsList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ271 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ271.setPadding (5.0f);
					tableQ271.addCell (cellQ271);
				}
				}	
				
			document.add(tableQ271);
			document.add(space);	
				
			
			}else{
				
			Paragraph partCbb = new Paragraph();
			partCbb.add(new Chunk("AIR STACK DETAILS",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbb.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbb);
			document.add(space);
			
			PdfPTable table9=new PdfPTable(9);
			PdfPCell cell9 = new PdfPCell ();
			float[] columnWidth9 = new float[] {10f,10f,10f,10f,10f,10f,10f,10f,10f};
			table9.setWidths(columnWidth9);
			table9.setWidthPercentage(100);
						
			cell9 = new PdfPCell (new Paragraph (new Chunk("Stack No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Height(m) above Ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Diameter ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Stack attached to", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Type of fuel(KLD/tpd)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Volume of gas", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Velocity of gas m/s", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
			cell9 = new PdfPCell (new Paragraph (new Chunk("Air pollution control measures", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			

			cell9 = new PdfPCell (new Paragraph (new Chunk("Parameter ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell9.setBorder(PdfPCell.NO_BORDER);
			table9.addCell (cell9);
			
		for(int var323=0;var323<AirStackDetailsList.size();var323++)
			{
			ArrayList al2=(ArrayList) AirStackDetailsList.get(var323);
				
			for(int var341=0;var341<al2.size();var341++)
			{
				String a=(String) al2.get(var341);
				cell9 = new PdfPCell (new Paragraph(a,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
				cell9.setHorizontalAlignment (Element.ALIGN_CENTER);
				cell9.setPadding (5.0f);
				table9.addCell (cell9);
				}
			}
			
		document.add(table9);
		document.add(space);
			
			
			
			
				
			Paragraph partCbc = new Paragraph();
			partCbc.add(new Chunk("Flue Gas Emission Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc);
			document.add(space);	
				
				
			PdfPTable tableQ27a=new PdfPTable(7);
			PdfPCell cellQ27a = new PdfPCell ();
			float[] columnWidthQ27a = new float[] {1f,1f,1f,1f,1f,1f,1f};
			tableQ27a.setWidths(columnWidthQ27a);
			tableQ27a.setWidthPercentage(100);
									
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Fuel Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Fuel Consumption", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Calorific Value %", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Ash Content %", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Sulphur Content %", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
			
			cellQ27a = new PdfPCell (new Paragraph (new Chunk("Others", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ27a.addCell (cellQ27a);
				
				
			for(int var3=0;var3<airFlueGasEmissionDetailsList.size();var3++)
			{
				ArrayList al2=(ArrayList) airFlueGasEmissionDetailsList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ27a = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
				cellQ27a.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellQ27a.setPadding (5.0f);
					tableQ27a.addCell (cellQ27a);
				}
				}	
				
			document.add(tableQ27a);
			document.add(space);
				
			Paragraph partCbc1 = new Paragraph();
			partCbc1.add(new Chunk("Air Miscellaneous Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc1.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc1);
			document.add(space);		
				
				
			PdfPTable tableQ271=new PdfPTable(3);
			PdfPCell cellQ271 = new PdfPCell ();
			float[] columnWidthQ271 = new float[] {1f,1f,1f};
			tableQ271.setWidths(columnWidthQ271);
			tableQ271.setWidthPercentage(100);
									
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Release Of Odoriferous Compounds", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Do You Have Adequate Facility For Collection Of Samples Of Emmisions In The Form Of Port Holes, Platforms, Ladder, etc.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			cellQ271 = new PdfPCell (new Paragraph (new Chunk("Quality Of Flue Gas/Process Emissions", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ271.addCell (cellQ271);
			
			
			for(int var3=0;var3<airMiscDetailsList.size();var3++)
			{
				ArrayList al2=(ArrayList) airMiscDetailsList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ271 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ271.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ271.setPadding (5.0f);
					tableQ271.addCell (cellQ271);
				}
				}	
				
			document.add(tableQ271);
			document.add(space);
			
			Paragraph partCbc2 = new Paragraph();
			partCbc2.add(new Chunk("Source of Water, Use and Consumption Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc2.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc2);
			document.add(space);	
			
			
			PdfPTable tableQ272=new PdfPTable(3);
			PdfPCell cellQ272 = new PdfPCell ();
			float[] columnWidthQ272 = new float[] {1f,1f,1f};
			tableQ272.setWidths(columnWidthQ272);
			tableQ272.setWidthPercentage(100);
									
			cellQ272 = new PdfPCell (new Paragraph (new Chunk("Source type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ272.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ272.addCell (cellQ272);
			
			cellQ272 = new PdfPCell (new Paragraph (new Chunk("Source Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ272.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ272.addCell (cellQ272);
			
			cellQ272 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ272.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ272.addCell (cellQ272);
			
			
			for(int var3=0;var3<airMiscDetailsList.size();var3++)
			{
				ArrayList al2=(ArrayList) airMiscDetailsList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ272 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ272.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ272.setPadding (5.0f);
					tableQ272.addCell (cellQ272);
				}
				}	
				
			document.add(tableQ272);
			document.add(space);
			
			
			Paragraph partCbc3 = new Paragraph();
			partCbc3.add(new Chunk("Waste Water Treatment Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc3.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc3);
			document.add(space);
			
			
			PdfPTable tableQ273=new PdfPTable(5);
			PdfPCell cellQ273 = new PdfPCell ();
			float[] columnWidthQ273 = new float[] {1f,1f,1f,1f,1f};
			tableQ273.setWidths(columnWidthQ273);
			tableQ273.setWidthPercentage(100);
									
			cellQ273 = new PdfPCell (new Paragraph (new Chunk("Uses", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ273.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ273.addCell (cellQ273);
			
			cellQ273 = new PdfPCell (new Paragraph (new Chunk("Treatment Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ273.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ273.addCell (cellQ273);
			
			cellQ273 = new PdfPCell (new Paragraph (new Chunk("Name of Treatment Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ273.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ273.addCell (cellQ273);
			
			cellQ273 = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ273.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ273.addCell (cellQ273);
			
			cellQ273 = new PdfPCell (new Paragraph (new Chunk("Investment in Treatment Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ273.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ273.addCell (cellQ273);
			
			
			for(int var3=0;var3<treatmentDetailsList.size();var3++)
			{
				ArrayList al2=(ArrayList) treatmentDetailsList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ273 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ273.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ273.setPadding (5.0f);
					tableQ273.addCell (cellQ273);
				}
				}	
				
			document.add(tableQ273);
			document.add(space);
			
			
			Paragraph partCbc4 = new Paragraph();
			partCbc4.add(new Chunk("Waste Water Discharge",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc4.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc4);
			document.add(space);
			
			
			PdfPTable tableQ274=new PdfPTable(5);
			PdfPCell cellQ274 = new PdfPCell ();
			float[] columnWidthQ274 = new float[] {1f,1f,1f,1f,1f};
			tableQ274.setWidths(columnWidthQ274);
			tableQ274.setWidthPercentage(100);
									
			cellQ274 = new PdfPCell (new Paragraph (new Chunk("Type of Effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ274.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ274.addCell (cellQ274);
			
			cellQ274 = new PdfPCell (new Paragraph (new Chunk("Maximum Generation Quantity of Effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ274.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ274.addCell (cellQ274);
			
			cellQ274 = new PdfPCell (new Paragraph (new Chunk("Effulent to be Recycle", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ274.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ274.addCell (cellQ274);
			
			cellQ274 = new PdfPCell (new Paragraph (new Chunk("Mode of Disposal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ274.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ274.addCell (cellQ274);
			
			cellQ274 = new PdfPCell (new Paragraph (new Chunk("Effulent to be Disposal/Discharge Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ274.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ274.addCell (cellQ274);
			
			for(int var3=0;var3<wasteWaterGenerationDetailsFinalList1.size();var3++)
			{
				ArrayList al2=(ArrayList) wasteWaterGenerationDetailsFinalList1.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ274 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ274.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ274.setPadding (5.0f);
					tableQ274.addCell (cellQ274);
				}
				}	
				
			document.add(tableQ274);
			document.add(space);
			
			
			Paragraph partCbc5 = new Paragraph();
			partCbc5.add(new Chunk("Solid Wastes Generation Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
			partCbc5.setAlignment(Element.ALIGN_LEFT);
			document.add(partCbc5);
			document.add(space);
			
			
			PdfPTable tableQ275=new PdfPTable(4);
			PdfPCell cellQ275 = new PdfPCell ();
			float[] columnWidthQ275 = new float[] {1f,1f,1f,1f};
			tableQ275.setWidths(columnWidthQ275);
			tableQ275.setWidthPercentage(100);
									
			cellQ275 = new PdfPCell (new Paragraph (new Chunk("Description", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ275.addCell (cellQ275);

			cellQ275 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ275.addCell (cellQ275);
			
			cellQ275 = new PdfPCell (new Paragraph (new Chunk("Method of Treatment/Collection", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ275.addCell (cellQ275);
			
			cellQ275 = new PdfPCell (new Paragraph (new Chunk("Method of Disposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
			tableQ275.addCell (cellQ275);
			
			for(int var3=0;var3<waterSolidWasteGenDetailsInstanceFinalList.size();var3++)
			{
				ArrayList al2=(ArrayList) waterSolidWasteGenDetailsInstanceFinalList.get(var3);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					String a=(String) al2.get(var341);
					cellQ275 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellQ275.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellQ275.setPadding (5.0f);
					tableQ275.addCell (cellQ275);
				}
				}	
				
			document.add(tableQ275);
			document.add(space);
			
			}
			if(hazardeousType.equals("HWM")){
				
				Paragraph partCbc51 = new Paragraph();
				partCbc51.add(new Chunk(" Hazardous Waste Details :-",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 1, Font.BOLD)));
				partCbc51.setAlignment(Element.ALIGN_LEFT);
				document.add(partCbc51);
				document.add(space);
				
			PdfPTable table261=new PdfPTable(5);
			PdfPCell cell261 = new PdfPCell ();
			float[] columnWidth261 = new float[] {20f,20f,20f,20f,20f};
			table261.setWidths(columnWidth261);
			table261.setWidthPercentage(100);
			
			cell261 = new PdfPCell (new Paragraph (new Chunk("Activity For", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell261.setHorizontalAlignment (Element.ALIGN_LEFT);
			table261.addCell (cell261);
					
			cell261 = new PdfPCell (new Paragraph (new Chunk("Source of Generation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell261.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell26.setBorder(PdfPCell.NO_BORDER);
			table261.addCell (cell261);
		
			cell261 = new PdfPCell (new Paragraph (new Chunk("Name", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell261.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell26.setBorder(PdfPCell.NO_BORDER);
			table261.addCell (cell261);
				
			cell261 = new PdfPCell (new Paragraph (new Chunk("Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell261.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell26.setBorder(PdfPCell.NO_BORDER);
			table261.addCell (cell261);
					
			cell261 = new PdfPCell (new Paragraph (new Chunk("Quantity(per day in TPD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cell261.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cell26.setBorder(PdfPCell.NO_BORDER);
			table261.addCell (cell261);
		
			for(int var323=0;var323<HazardousWasteGenDetailsList.size();var323++)
			{
				ArrayList al2=(ArrayList) HazardousWasteGenDetailsList.get(var323);
				
				for(int var341=0;var341<al2.size();var341++)
				{
					
					String a=(String) al2.get(var341);
				
					cell261 = new PdfPCell (new Paragraph(a,new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cell261.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell261.setPadding (5.0f);
					table261.addCell (cell261);
					
				}
				}
			document.add(table261);
	
		}		
		document.close();
			
			
			
		}catch (Exception e) {
						e.printStackTrace();
						
					}
			    	return tempFile;
					
			
		}
	
	

	
	
	
	
	

	
	
	
	
	

}







