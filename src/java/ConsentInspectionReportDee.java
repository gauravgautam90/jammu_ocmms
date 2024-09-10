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

public class ConsentInspectionReportDee {
	
	public File freshInspectionPdf(String indName,String capInvt,String dateOfReceipt,String dateOfReceiptdistrict,String  dateOfReceiptcentral,String  periodapplied,String industrialArea,String papersub,String senstiveArea,String distanceRiver,String distanceNational,String districtRoad,String distanceHabitat,String touristComplex,String forest,String hospital,
			String controlledArea,String nationalPark,String agriculture,String chamber,String plantation,String others,String sewageEffluent,String enviorment,String shed,
			String groundLevel,String stackHeight,String fuel,String boilerType,String pollutionSystem,String controlMeasure,String fugitiveEmission,String noiseLevels,String typeofNonHaz,String nonHazQty,String treatmentArrang,String disposalArrange,String quantityrecycler,String methodOfDisposal,String methodOftreatment,
			String saleName,String closeShed,String storedOrDisposed,String leachate,String chemicalStorage,String management,String publicLiability,String separateElectric,String legal,String acoustic,String adequacy,String recieveEnviroment,String publicComplain,String hotelRest,Long number
	,String expansionPlant,String capacityUtili,String modernization,ArrayList ConsentDetailsList,ArrayList IndProductDetailsList,ArrayList AirStackDetailsList
	,ArrayList hotelFacilityDetailList,ArrayList hotelWaterConsumptionList,ArrayList waterBudgetList,ArrayList sewageDetailsList,ArrayList tradeEffluentList,String categoryHaz	,
	String leachateCollect,String chemicalQty,String applicationFor,String commYear,String inspecRepCategory,String inspecRepScale,String brickTiles,String waterSupply,
	String educationalInstituion,String metallingRoads,String windBreaking,String jacketing,String waterSprinkle,String greenBelt,String chimney,String roadsWall,String costPCD,String applicationType
,String certificateFor,String roomCapacity,String authorityName,String indAddressConReport,String standards,ArrayList feeList,String specificArea,
String areaSpecific,String areaSenstive,String incSewage,String areaincSewage,String addSewagereq,String location,String propermi,String oprmain,String prestan,String aircomm,String incwxam,String pubcom,String enviclea,String reinspoff,String redistoff,String reregioff,ArrayList deeRecommendationsListbb,
ArrayList HotelGeneralDetailsInspectionList,String resArea,String spmLevel,ArrayList HazardousWasteGenDetailsList,String indType,String regNo
	)	throws Exception {
		File tempFile = new File("Inspection Report.pdf");
		try{
			
		        System.out.println("---Inside in inspection report pdf--11");
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
				
				Image image = Image.getInstance("images2/jammu.JPG");
				image.scalePercent(40.0f);
				image.setAlignment(Image.LEFT | Image.TEXTWRAP);
				document.add(image);
				document.add(space);
				
				if((applicationFor.equals("both")) && (!indType.equals("Hot mix plants"))){	
					
					Paragraph partCb = new Paragraph();
					partCb.add(new Chunk("J&K POLLUTION CONTROL COMMITTEE JAMMU",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
					partCb.setAlignment(Element.ALIGN_CENTER);
					document.add(partCb);
					
					Paragraph partCb1 = new Paragraph();
					partCb1.add(new Chunk("SCHEDULE-II",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
					partCb1.setAlignment(Element.ALIGN_CENTER);
					document.add(partCb1);
					
					document.add(space);
					
					Paragraph partCb1a = new Paragraph();
					partCb1a.add(new Chunk("Format for processing of application for consent and/ or authorization",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a.setAlignment(Element.ALIGN_CENTER);
					document.add(partCb1a);
					
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
					
					cellz = new PdfPCell (new Paragraph (new Chunk("File No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("SPCB|"+number, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Name and Location of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Correspondence Address ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+indAddressConReport, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Period Applied for(validity up to) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+periodapplied, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
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
				
					
					cellz = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of Factory", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Pollution Category of Industry as per:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Classification Approved by the Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setColspan(2);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Classification of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
				//	cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Category as per specific notification ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
				//	cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Location ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setColspan(2);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("In an approved Industrial area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+industrialArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setColspan(2);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("whether land paper submitted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+papersub, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("In sensitive area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					if(senstiveArea.equals("YES")){
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+senstiveArea+
							"\n "+areaSenstive, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					}else{
						cellz = new PdfPCell (new Paragraph (new Chunk(" "+senstiveArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//	cellzz.setBorder(PdfPCell.NO_BORDER);
						tablez.addCell (cellz);	
					}
					cellz = new PdfPCell (new Paragraph (new Chunk("(d)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("In case of any other specific area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					if(specificArea.equals("YES")){
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+specificArea+
							"\n "+areaSpecific, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					}else{
						cellz = new PdfPCell (new Paragraph (new Chunk(" "+specificArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//	cellzz.setBorder(PdfPCell.NO_BORDER);
						tablez.addCell (cellz);	
					}
					cellz = new PdfPCell (new Paragraph (new Chunk("(e)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Distance from river / stream", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+distanceRiver, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					

					cellz = new PdfPCell (new Paragraph (new Chunk("(f)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Distance from National/State Highway", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+distanceNational, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(g)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Distance from nearest habitation and its population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+distanceHabitat, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
						
					cellz = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Status of Consent granted earlier ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					PdfPTable tableQ2=new PdfPTable(3);
					PdfPCell cellQ2 = new PdfPCell ();
					float[] columnWidthQ2 = new float[] {2f,2f,2f};
					tableQ2.setWidths(columnWidthQ2);
					tableQ2.setWidthPercentage(100);
					
					cellQ2 = new PdfPCell (new Paragraph (new Chunk("Consent  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellQ2.setBorder(PdfPCell.NO_BORDER);
					tableQ2.addCell (cellQ2);
					cellQ2 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellQ2.setBorder(PdfPCell.NO_BORDER);
					tableQ2.addCell (cellQ2);
					cellQ2 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellQ2.setBorder(PdfPCell.NO_BORDER);
					tableQ2.addCell (cellQ2);
					
					for(int var323=0;var323<ConsentDetailsList.size();var323++)
					{
						ArrayList al2=(ArrayList) ConsentDetailsList.get(var323);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							
							String a=(String) al2.get(var341);
							cellQ2 = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
							cellQ2.setPadding (5.0f);
							tableQ2.addCell (cellQ2);
							
						}
						}
					
					cellz.addElement(tableQ2);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
				 						
					cellz = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					
					PdfPTable tableQ27=new PdfPTable(6);
					PdfPCell cellQ27 = new PdfPCell ();
					float[] columnWidthQ27 = new float[] {1f,1f,1f,1f,1f,1f};
					tableQ27.setWidths(columnWidthQ27);
					tableQ27.setWidthPercentage(100);
											
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Raw Material", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
							
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Product manufactured", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("By-product", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
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
					
					cellz.addElement(tableQ27);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
									
					cellz = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("In case of expansions please mention whether expansion is due to :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Expansion in plants and machinery", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+expansionPlant, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Capacity Utilization", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+capacityUtili, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
						
					cellz = new PdfPCell (new Paragraph (new Chunk("Modernization or de-bottle necking", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
						
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+modernization, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("14.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Water Pollution Control", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Water Budget", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					 
					
					PdfPTable table26=new PdfPTable(5);
					PdfPCell cell26 = new PdfPCell ();
					float[] columnWidth26 = new float[] {20f,20f,20f,20f,20f};
					table26.setWidths(columnWidth26);
					table26.setWidthPercentage(100);
					
					cell26 = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell26.setRowspan(2);
					table26.addCell (cell26);
							
					cell26 = new PdfPCell (new Paragraph (new Chunk("Water Consumption(in KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell26.setColspan(2);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
				
					cell26 = new PdfPCell (new Paragraph (new Chunk("Effluent Generation(in KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell26.setColspan(2);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
							
					
					cell26 = new PdfPCell (new Paragraph (new Chunk("Present", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
							
					cell26 = new PdfPCell (new Paragraph (new Chunk("Previous", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
				
					cell26 = new PdfPCell (new Paragraph (new Chunk("Present", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
								
					cell26 = new PdfPCell (new Paragraph (new Chunk("Previous", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
					
					for(int var323=0;var323<waterBudgetList.size();var323++)
					{
						ArrayList al2=(ArrayList) waterBudgetList.get(var323);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							
							String a=(String) al2.get(var341);
						
							cell26 = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
							cell26.setPadding (5.0f);
							table26.addCell (cell26);
							
						}
						}
					
					cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
			
					cellz.addElement(table26);
					cellz.setColspan(2);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
			
					cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Is there any increase in sewage/trade effluent quantity generated, and if so, indicate the quantity(KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
				
					if(incSewage.equals("Yes")){
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+incSewage+
							"\n "+areaincSewage, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					}else{
						cellz = new PdfPCell (new Paragraph (new Chunk(" "+incSewage, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
						tablez.addCell (cellz);
					}
					
					cellz = new PdfPCell (new Paragraph (new Chunk("15.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Details of sewage/trade effluent treatment arrangement provided." +
							"Sewage and trade effluent and treated combinedly indicate the details and are these adequate/inadequate and comply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+sewageEffluent, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("16.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Details of sewage/trade effluent disposal arrangement provided.An examination of impact on environmental waters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+enviorment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("17.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Details of any additional sewage/trade effluent treatment and disposal of arrangements proposed to be provided.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+addSewagereq, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("18.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Analysis report of treated waste water: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Trade Effluent or combined Effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					PdfPTable table2=new PdfPTable(8);
					PdfPCell cell2 = new PdfPCell ();
					float[] columnWidth2 = new float[] {10f,10f,10f,10f,10f,10f,10f,10f};
					table2.setWidths(columnWidth2);
					table2.setWidthPercentage(100);
								
					cell2 = new PdfPCell (new Paragraph (new Chunk("Date of Sampling and Sample collected by ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("PH between ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("D.O in mg/I ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("BOD in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("C.O.D in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("SS in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("O & G in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("Other Relevant Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					for(int var323=0;var323<tradeEffluentList.size();var323++)
					{
						ArrayList al2=(ArrayList) tradeEffluentList.get(var323);
					
						for(int var341=0;var341<al2.size();var341++)
						{
							
							String a=(String) al2.get(var341);
							
							cell2 = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
							cell2.setPadding (5.0f);
							table2.addCell (cell2);
							
						}
						}
					
					cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz.addElement(table2);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Sewage", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					PdfPTable tableW=new PdfPTable(4);
					PdfPCell cellW = new PdfPCell ();
					float[] columnWidthW = new float[] {10f,10f,10f,10f};
					tableW.setWidths(columnWidthW);
					tableW.setWidthPercentage(100);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("Date of Sampling and Sample collected ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("TSS in mg/I ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("BOD in mg/I ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
		for(int var12=0;var12<sewageDetailsList.size();var12++)
					{
					ArrayList al2=(ArrayList) sewageDetailsList.get(var12);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellW = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellW.setPadding (5.0f);
						tableW.addCell (cellW);
						
					}
					}
		
		cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
		tablez.addCell (cellz);
		
		cellz.addElement(tableW);
		cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
		cellz.setColspan(2);
		tablez.addCell (cellz);
		
		cellz = new PdfPCell (new Paragraph (new Chunk("Note:- In case of industries having effluent more than 500m3/day, latest analysis results of Joint Vigilance Sample should be mentioned.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
		cellz.setColspan(3);
		tablez.addCell (cellz);
		
		cellz = new PdfPCell (new Paragraph (new Chunk("19.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
		tablez.addCell (cellz);
		
		cellz = new PdfPCell (new Paragraph (new Chunk("(a) Air Pollution Control ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
		cellz.setColspan(2);
		tablez.addCell (cellz);
		
		
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
					
				cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz.addElement(table9);
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("20.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("D.G set with capacity in KVA:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+categoryHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Fuel K/L per day ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+fuel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Stack height ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+stackHeight, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("From ground level ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+groundLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Above the shed / roof ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+shed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("21.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details with the name ,Type boiler,steam generation capacity(t/hr) and quantity of fuel used in each boiler", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+boilerType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("22.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of air pollution control equipment installed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+pollutionSystem, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("23.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Additional air pollution control measure, proposed to be provided if any", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+controlMeasure, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("24.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Fugitive emission an assessment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+fugitiveEmission, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("25.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Noice levels-an assessment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+noiseLevels, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("26.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" a) Hazardous Waste Details :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
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
				
				cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
		
				cellz.addElement(table261);
				cellz.setColspan(2);
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
		
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for treatment hazardous waste ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+methodOftreatment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for disposal of hazardous waste ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+methodOfDisposal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("In case of waste being disposed by sale name of party to whom the hazardous waste is solid", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+saleName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("In case of waste being stored in closed sheds/container, indicate the details", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+closeShed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(f) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("In case of waste being stored/disposed off in landfills, the details of landfills sites,locations,dimensions,lining,capacity etc", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+storedOrDisposed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(g) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether leachate collection arrangements have being provided for landfill site", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+leachate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(h) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether leachate are connected to treatment facility, details of treatment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+leachateCollect, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("27.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Non Hazardous solid waste : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+typeofNonHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Quantity(TPD/TPM)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+nonHazQty, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for Treatments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+treatmentArrang, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for Disposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+disposalArrange, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("28.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Hazardous Chemicals", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of storage", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+chemicalStorage, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether permission from concerned authorities like Directorate of Industrial Safety and Health,Local body Explosive Department is taken", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+chemicalQty, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether onsite disaster management plan is prepared and mock drill is conducted periodically", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+management, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(d)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Is public liability insurance obtained as per Public Liability Insurance Act, 1991", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+publicLiability, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("29.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether separate electric meter is installed for pollution control System(s)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+separateElectric, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("30.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Legal record of unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+legal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("31.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether any legal action has been taken against the unit , if so the details thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+authorityName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Remarks : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(3);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("32.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+location, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("33.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether product is permissible or not", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+propermi, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("34.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Operation and maintenance of Pollution Control System ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+oprmain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("35.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Adequacy of Pollution Control System", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("36.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("What are the standards to be prescribed and reason for the proposed standards", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+standards, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				
				
				cellz = new PdfPCell (new Paragraph (new Chunk("37.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Impact on the receiving environment:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("--wate and air-and comments thereof ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("--including examination of nearby industries ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+incwxam, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("38.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Have any public complaints being received, if so, details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("39.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether environmental clearance required", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+enviclea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				
					document.add(tablez);	
					document.add(space);
					
					Paragraph partCb11a1 = new Paragraph();
					partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb11a1.setAlignment(Element.ALIGN_RIGHT);
					document.add(partCb11a1);
					document.add(space);
					
					
					PdfPTable tablez1=new PdfPTable(2);
					PdfPCell cellz1 = new PdfPCell ();
					float[] columnWidthz1 = new float[] {1f,1f};
					tablez1.setWidths(columnWidthz1);
					tablez1.setWidthPercentage(100);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					document.add(tablez1);	
					document.add(space);
					
					Paragraph partCb1a17 = new Paragraph();
					partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
							"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a17.setAlignment(Element.ALIGN_LEFT);
					document.add(partCb1a17);
					document.add(space);
					
					PdfPTable tableFees = new PdfPTable(7);
					PdfPCell cellFees = new PdfPCell();
					tableFees.setWidthPercentage(100);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setColspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk(
							"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
					
							
				PdfPTable tablee=new PdfPTable(2); 
				float[] columnWidthss = new float[] {4f,4f};
				tablee.setWidths(columnWidthss);					
				PdfPCell celll = new PdfPCell ();
				
				celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
				celll.setHorizontalAlignment (Element.ALIGN_CENTER);
				celll.setBorder(PdfPCell.NO_BORDER);
				tablee.addCell (celll);
					
					celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
					celll.setHorizontalAlignment (Element.ALIGN_CENTER);
					celll.setColspan(4);
					celll.setBorder(PdfPCell.NO_BORDER);
					tablee.addCell (celll);
					

					for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
					{
						ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							String a=(String) al2.get(var341);
							celll = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setPadding (5.0f);
							tablee.addCell (celll);
						}
						}	
					document.add(tablee);
				
		}
if((applicationFor.equals("brickkilns")) && (!indType.equals("Hot mix plants"))){
	
	Paragraph partCb12 = new Paragraph();
	partCb12.add(new Chunk("J&K POLLUTION CONTROL COMMITTEE JAMMU",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
	partCb12.setAlignment(Element.ALIGN_CENTER);
	document.add(partCb12);
	
	Paragraph partCb11 = new Paragraph();
	partCb11.add(new Chunk("SCHEDULE-II",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
	partCb11.setAlignment(Element.ALIGN_CENTER);
	document.add(partCb11);
	
	document.add(space);
	
	Paragraph partCb1a1 = new Paragraph();
	partCb1a1.add(new Chunk("Format For Reports on Processing of Application For Grant/Renewal Of Consent For Brick Kilns",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	partCb1a1.setAlignment(Element.ALIGN_CENTER);
	document.add(partCb1a1);
	
	document.add(space);
		
	PdfPTable table0=new PdfPTable(3);
	PdfPCell cellz0 = new PdfPCell ();
	float[] columnWidthz0 = new float[] {3f,20f,25f};
	table0.setWidths(columnWidthz0);
	table0.setWidthPercentage(100);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Name of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment Verified From", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+prestan, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);	
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) Category of unit as per general classification approved  by the Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);		
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) Classification of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Product manufactured Bricks and tiles qty:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+brickTiles, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Location :- Distance of proposed site from following features(as per sitting criteria)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("National Highway/State Highway", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+distanceNational, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Distt/Other/Road", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Municipal Limits", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+areaSpecific, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Distt. Headquarters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+areaSenstive, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Residential Area/Abadi", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+distanceHabitat, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(f) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Tourist Complex/Resort", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+touristComplex, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(g) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Forest Land", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+forest, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(h) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Controlled Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+controlledArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(i) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Approved water supply of 20 kg", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+waterSupply, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(j) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Hospital/Nursing Home/Health Centre", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+hospital, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(k) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Notified Bird Sancturay/National Park/Wildlife Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+nationalPark, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(l) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Agricultural Land/Orchard except Dry/Banjar Kadeem ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+agriculture, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(m) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Nearest Educational Institution or other similar Institution", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+educationalInstituion, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
    //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(A) Proposed/installed PCDs ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Chimney", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+chimney, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
    //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Setting chamber with Baffle", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+chamber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
    //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Metalled walls road", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+roadsWall, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Plantation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+plantation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Others", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+others, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(B)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Total proposed cost for installing the PCDs", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+costPCD, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Status of Consent granted earlier ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	PdfPTable tableQ2=new PdfPTable(3);
	PdfPCell cellQ2 = new PdfPCell ();
	float[] columnWidthQ2 = new float[] {2f,2f,2f};
	tableQ2.setWidths(columnWidthQ2);
	tableQ2.setWidthPercentage(100);
	
	cellQ2 = new PdfPCell (new Paragraph (new Chunk("Consent  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellQ2.setBorder(PdfPCell.NO_BORDER);
	tableQ2.addCell (cellQ2);
	cellQ2 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellQ2.setBorder(PdfPCell.NO_BORDER);
	tableQ2.addCell (cellQ2);
	cellQ2 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellQ2.setBorder(PdfPCell.NO_BORDER);
	tableQ2.addCell (cellQ2);
	
	for(int var323=0;var323<ConsentDetailsList.size();var323++)
	{
		ArrayList al2=(ArrayList) ConsentDetailsList.get(var323);
		for(int var341=0;var341<al2.size();var341++)
		{
			String a=(String) al2.get(var341);
			cellQ2 = new PdfPCell (new Paragraph(a,new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
			cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
			cellQ2.setPadding (5.0f);
			tableQ2.addCell (cellQ2);	
		}
		}
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0.addElement(tableQ2);
	cellz0.setColspan(2);
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Remark ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Adequacy of Pollution control Control System Installed/proposed ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//  cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b)  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	  //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Emission Level(SPM/SOx/NOx/10/HC or as applicable under rules)with in stds or not", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+acoustic, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(c)  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Impact on the receiving environment water and air-and comments thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Have any complains been received, if so details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Area under plantation and No. of trees planted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+recieveEnviroment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(f) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Other informations", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+publicComplain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//  cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	document.add(table0);
    document.add(space);
    
    Paragraph partCb11a1 = new Paragraph();
	partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	partCb11a1.setAlignment(Element.ALIGN_RIGHT);
	document.add(partCb11a1);
	document.add(space);

	PdfPTable tablez1=new PdfPTable(2);
	PdfPCell cellz1 = new PdfPCell ();
	float[] columnWidthz1 = new float[] {1f,1f};
	tablez1.setWidths(columnWidthz1);
	tablez1.setWidthPercentage(100);
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk("Whether Consent may be Granted : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reinspoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	if(reinspoff.equals("Yes")){
		cellz1 = new PdfPCell (new Paragraph (new Chunk("If yes, Validity period of Consent and conditions if any,applicable", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
		
		cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
	}else{
		cellz1 = new PdfPCell (new Paragraph (new Chunk("If no, further action recommended", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
		
		cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
	}
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	document.add(tablez1);	
	document.add(space);
	
	Paragraph partCb1a17 = new Paragraph();
	partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
			"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	partCb1a17.setAlignment(Element.ALIGN_LEFT);
	document.add(partCb1a17);
	document.add(space);
	
	PdfPTable tableFees = new PdfPTable(7);
	PdfPCell cellFees = new PdfPCell();
	tableFees.setWidthPercentage(100);
	
	cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setColspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk(
			"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);
	
	cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	tableFees.addCell(cellFees);
	
	cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
	
			
				PdfPTable tablee=new PdfPTable(2); 
				float[] columnWidthss = new float[] {4f,4f};
				tablee.setWidths(columnWidthss);					
				PdfPCell celll = new PdfPCell ();
				
				celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
				celll.setHorizontalAlignment (Element.ALIGN_CENTER);
				celll.setBorder(PdfPCell.NO_BORDER);
				tablee.addCell (celll);
					
					celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
					celll.setHorizontalAlignment (Element.ALIGN_CENTER);
					celll.setColspan(4);
					celll.setBorder(PdfPCell.NO_BORDER);
					tablee.addCell (celll);
					

					for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
					{
						ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							String a=(String) al2.get(var341);
							celll = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setPadding (5.0f);
							tablee.addCell (celll);
						}
						}	
					document.add(tablee);
				
				
				
			}
				
			if((applicationFor.equals("hotel")) && (!indType.equals("Hot mix plants"))){
				

				Paragraph ppppoooo = new Paragraph();
				ppppoooo.add(new Chunk("J&K Pollution Control Committee",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo);
				
				Paragraph ppppoooo1 = new Paragraph();
				ppppoooo1.add(new Chunk("Schedule-II",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo1.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo1);
				
				document.add(space);
				
				Paragraph ppppoooo11 = new Paragraph();
				ppppoooo11.add(new Chunk("Format For Processing Of Application For Consent And/Or Authorization For Hotels/Restaurant",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo11.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo11);
				
				document.add(space);
				
				Paragraph ppppoooo111 = new Paragraph();
				ppppoooo111.add(new Chunk("(Under Water(P&CP) Act 1974, Air(P&CP) Act 1981 and EPA 1986 & Rules thereof)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo111.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo111);
				document.add(space);
				
				PdfPTable tablezz111=new PdfPTable(3);
				PdfPCell cellzz111 = new PdfPCell ();
				float[] columnWidthzz111 = new float[] {3f,20f,25f};
				tablezz111.setWidths(columnWidthzz111);
				tablezz111.setWidthPercentage(100);

				cellzz111 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("File Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("SPCB|"+number, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Name and Address of Establishment/Hotel/Restaurant", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Address for correspondence of contact person with Phone No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+indAddressConReport, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Period Applied for(validity up to) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+periodapplied, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Establish/Operate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Fresh/Renewal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+certificateFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellzz111.setRowspan(2);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" (a) Year of Establishment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" (b) Tourism Departments Registration. No.& Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+regNo + " , " + inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Year of commissioning", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Classification of establishment of Hotel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Hotel with / without Restaurant ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
								
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+hotelRest, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Room Capacity ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
			    tablezz111.addCell (cellzz111);
				
			    cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+roomCapacity, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
			    tablezz111.addCell (cellzz111);
							    
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Location: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				cellzz111.setColspan(2);
				tablezz111.addCell (cellzz111);
				
				PdfPTable tableQ21=new PdfPTable(4);
				PdfPCell cellQ21 = new PdfPCell ();
				float[] columnWidthQ21 = new float[] {2f,2f,2f,2f};
				tableQ21.setWidths(columnWidthQ21);
				tableQ21.setWidthPercentage(100);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("In Residential/Commercial/Sensitive/Silent/Mixed Category (Name of Area) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("Distance from nearest Water body(in meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("Distance from major Water body(in meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("Distance from the nearest habitation and its Population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				for(int var323=0;var323<HotelGeneralDetailsInspectionList.size();var323++)
				{
					ArrayList al2=(ArrayList) HotelGeneralDetailsInspectionList.get(var323);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellQ21 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ21.setPadding (5.0f);
						tableQ21.addCell (cellQ21);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tableQ21);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("13 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Status of Consent granted earlier ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				PdfPTable tableQ2=new PdfPTable(3);
				PdfPCell cellQ2 = new PdfPCell ();
				float[] columnWidthQ2 = new float[] {2f,2f,2f};
				tableQ2.setWidths(columnWidthQ2);
				tableQ2.setWidthPercentage(100);
				
				cellQ2 = new PdfPCell (new Paragraph (new Chunk("Consent  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ2.addCell (cellQ2);
				cellQ2 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ2.addCell (cellQ2);
				cellQ2 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ2.addCell (cellQ2);
				
				for(int var323=0;var323<ConsentDetailsList.size();var323++)
				{
					ArrayList al2=(ArrayList) ConsentDetailsList.get(var323);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellQ2 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ2.setPadding (5.0f);
						tableQ2.addCell (cellQ2);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tableQ2);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("14 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Facilities available with Capacity of each", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				PdfPTable table494=new PdfPTable(4);
				PdfPCell cellzz494 = new PdfPCell ();
				float[] columnWidth494 = new float[] {20f,20f,20f,20f};
				table494.setWidths(columnWidth494);
				table494.setWidthPercentage(100);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Type ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Facility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Facility Detail ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				 
				for(int var3=0;var3<hotelFacilityDetailList.size();var3++)
				{
					ArrayList al2=(ArrayList) hotelFacilityDetailList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellzz494 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellzz494.setPadding (5.0f);
						table494.addCell (cellzz494);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(table494);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("15 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Water Pollution Control ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				PdfPTable tablezz8=new PdfPTable(2);
				PdfPCell cellzz8 = new PdfPCell ();
				float[] columnWidthzz8 = new float[] {10f,20f};
				tablezz8.setWidths(columnWidthzz8);
				tablezz8.setWidthPercentage(100);
								
				
				cellzz8 = new PdfPCell (new Paragraph (new Chunk("Item", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz8.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz8.setRowspan(2);
				//cellzz8.setBorder(PdfPCell.NO_BORDER);
				tablezz8.addCell (cellzz8);
				
				cellzz8 = new PdfPCell (new Paragraph (new Chunk("Quantity(KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz8.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz8.setRowspan(2);
				//cellzz8.setBorder(PdfPCell.NO_BORDER);
				tablezz8.addCell (cellzz8);
				
				for(int var35=0;var35<hotelWaterConsumptionList.size();var35++)
				{
					ArrayList al2=(ArrayList) hotelWaterConsumptionList.get(var35);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellzz8 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellzz8.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellzz8.setPadding (5.0f);
						tablezz8.addCell (cellzz8);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tablezz8);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("16 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Analysis report of treated waste water", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(a) Trade effluent or combined effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				

				PdfPTable tablezz899=new PdfPTable(7);
				PdfPCell cellzz899 = new PdfPCell ();
				float[] columnWidthzz899 = new float[] {20f,20f,20f,20f,20f,20f,20f};
				tablezz899.setWidths(columnWidthzz899);
				tablezz899.setWidthPercentage(100);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("Date of sampling & sample collected by", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setRowspan(2);
			//	cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
							
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("pH between---to---", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("T.D.S in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("BOD in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setColspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("COD in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("T.S.S in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("O&G in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setColspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);


			for(int var323=0;var323<tradeEffluentList.size();var323++)
			{
					ArrayList al2=(ArrayList) tradeEffluentList.get(var323);
			
				for(int var341=0;var341<al2.size();var341++)
				{
					
					String a=(String) al2.get(var341);
					
					cellzz899 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellzz899.setPadding (5.0f);
						tablezz899.addCell (cellzz899);
											}
					}
			cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);
		 
			cellzz111.addElement(tablezz899);
			cellzz111.setColspan(2);
			cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);	
			
			cellzz111 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);
			
			cellzz111 = new PdfPCell (new Paragraph (new Chunk("(b) Sewage", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellzz111.setColspan(2);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);
			
			
				PdfPTable tablezzpp=new PdfPTable(4);
				PdfPCell cellzzpp = new PdfPCell ();
				float[] columnWidthzzpp = new float[] {20f,20f,20f,20f};
				tablezzpp.setWidths(columnWidthzzpp);
				tablezzpp.setWidthPercentage(100);
					
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("Date of sampling & sample collected by ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
			   // cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("pH between---to---", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("T.S.S in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
			   // cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("BOD", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				
				for(int var323=0;var323<sewageDetailsList.size();var323++)
				{
						ArrayList al2=(ArrayList) sewageDetailsList.get(var323);
						
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellzzpp = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellzzpp.setPadding (5.0f);
						tablezzpp.addCell (cellzzpp);
												}
						}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tablezzpp);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);	
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("17 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("D.G Set with capacity in KVA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+categoryHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Fuel (KL/day)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+fuel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Stack height", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+stackHeight, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("From ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+groundLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Above the shed/roof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+shed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("18 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Details with the name,type of Boiler, stream generated capacity(t/hr) & quantity of fuel used in each boiler.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+boilerType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("19 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Details of air pollution control equipment installed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+pollutionSystem, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("20 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Legal record of unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+legal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("21 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Whether any legal action has been taken against the Hotel/Restaurant, if so, the details thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+authorityName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
					
				document.add(tablezz111);
			    document.add(space);
			    
			    Paragraph part2 = new Paragraph();
				part2.add(new Chunk("Remarks",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD )));
				part2.setAlignment(Element.ALIGN_LEFT);
				document.add(part2);
				
				PdfPTable table9090=new PdfPTable(3);
				PdfPCell cell9090 = new PdfPCell ();
				float[] columnWidth9090 = new float[] {3f,20f,20f};
				table9090.setWidths(columnWidth9090);
				table9090.setWidthPercentage(100);
	
				cell9090 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Location ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+location, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Operation & maintenance of pollution control system ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+oprmain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Adequacy of pollution control system ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("What are the standards to be prescribed and reason for the proposed standards ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+standards, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Impact on receiving environment  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell9090.setColspan(2);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("-water and air-and comments thereof  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("-including examination of nearby industries ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+incwxam, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Have any public complaints being received.If so, details thereof and comments. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
								
				cell9090 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Whether environmental clearance required ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+enviclea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
			
				document.add(table9090);
				document.add(space);
				
				Paragraph partCb11a1 = new Paragraph();
				partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb11a1.setAlignment(Element.ALIGN_RIGHT);
				document.add(partCb11a1);
				document.add(space);
				
					PdfPTable tablez1=new PdfPTable(2);
					PdfPCell cellz1 = new PdfPCell ();
					float[] columnWidthz1 = new float[] {1f,1f};
					tablez1.setWidths(columnWidthz1);
					tablez1.setWidthPercentage(100);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					document.add(tablez1);	
					document.add(space);
					
					Paragraph partCb1a17 = new Paragraph();
					partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
							"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a17.setAlignment(Element.ALIGN_LEFT);
					document.add(partCb1a17);
					document.add(space);
					
					PdfPTable tableFees = new PdfPTable(7);
					PdfPCell cellFees = new PdfPCell();
					tableFees.setWidthPercentage(100);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setColspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk(
							"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
					
					
					PdfPTable tablee=new PdfPTable(2); 
					float[] columnWidthss = new float[] {4f,4f};
					tablee.setWidths(columnWidthss);					
					PdfPCell celll = new PdfPCell ();
					
					celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
					celll.setHorizontalAlignment (Element.ALIGN_CENTER);
					celll.setBorder(PdfPCell.NO_BORDER);
					tablee.addCell (celll);
						
						celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
						celll.setHorizontalAlignment (Element.ALIGN_CENTER);
						celll.setColspan(4);
						celll.setBorder(PdfPCell.NO_BORDER);
						tablee.addCell (celll);
						

						for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
						{
							ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
							
							for(int var341=0;var341<al2.size();var341++)
							{
								String a=(String) al2.get(var341);
								celll = new PdfPCell (new Paragraph(a,new Font(
										Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
								celll.setHorizontalAlignment (Element.ALIGN_CENTER);
								celll.setPadding (5.0f);
								tablee.addCell (celll);
							}
							}	
						document.add(tablee);
			
			
			
			}	
				
			if((applicationFor.equals("dgset")) && (!indType.equals("Hot mix plants"))){
				
				Paragraph ppA = new Paragraph();
				ppA.add(new Chunk("SCHEDULE-II",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppA.setAlignment(Element.ALIGN_CENTER);
				document.add(ppA);
				
				Paragraph partCb15 = new Paragraph();
				partCb15.add(new Chunk("Format for processing of application for D.G Set Authorization",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
				partCb15.setAlignment(Element.ALIGN_CENTER);
				document.add(partCb15);
				document.add(space);
				
				PdfPTable table33=new PdfPTable(3);
				PdfPCell cellz33 = new PdfPCell ();
				float[] columnWidth33 = new float[] {3f,20f,25f};
				table33.setWidths(columnWidth33);
				table33.setWidthPercentage(100);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("File No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("SPCB|"+number, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				

				cellz33 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Name and Location of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Correspondence Address ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
			
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+indAddressConReport, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Period Applied for(validity up to) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+periodapplied, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(a) Establish/Operate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(b)Fresh/Renewal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+certificateFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Location ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setColspan(2);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz.setColspan(2);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("In an approved Industrial area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+industrialArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz.setColspan(2);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("whether land paper submitted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+papersub, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("In sensitive area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+senstiveArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(d)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("In case of any other specific area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				if(specificArea.equals("YES")){
					cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+specificArea+
							"\n "+areaSpecific, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz33.setBorder(PdfPCell.NO_BORDER);
					table33.addCell (cellz33);
					}else{
						cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+specificArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz33.setBorder(PdfPCell.NO_BORDER);
						table33.addCell (cellz33);	
					}

				cellz33 = new PdfPCell (new Paragraph (new Chunk("(g)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Distance from nearest habitation and its population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+distanceHabitat, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Capacity of D.G Set-------KVA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(a) Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+categoryHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(b) Fuel(KL/day)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+fuel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(c) Stack Height", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+stackHeight, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("  From ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+groundLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("  Above the ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+shed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Acousitic enclosure/Sound proof system installed or not ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+acoustic, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Adequacy of pollution control system", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Standard prescribed under Air(P&C) Act, 1981 & EP Act(D.G Set Noise Level Rules)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+standards, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Impact on receiving environment water and air and comments thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Have any public complaints being received. if so, details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				document.add(table33);
				document.add(space);
				
				Paragraph partCb11a1 = new Paragraph();
				partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb11a1.setAlignment(Element.ALIGN_RIGHT);
				document.add(partCb11a1);
				document.add(space);
				
				PdfPTable tablez1=new PdfPTable(2);
				PdfPCell cellz1 = new PdfPCell ();
				float[] columnWidthz1 = new float[] {1f,1f};
				tablez1.setWidths(columnWidthz1);
				tablez1.setWidthPercentage(100);
				
				cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez1.addCell (cellz1);
				
				cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez1.addCell (cellz1);
				
				document.add(tablez1);	
				document.add(space);
				
				Paragraph partCb1a17 = new Paragraph();
				partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
						"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb1a17.setAlignment(Element.ALIGN_LEFT);
				document.add(partCb1a17);
				document.add(space);
				
				PdfPTable tableFees = new PdfPTable(7);
				PdfPCell cellFees = new PdfPCell();
				tableFees.setWidthPercentage(100);
				
				cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setColspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk(
						"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);
				
				cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);
				
				cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
				
				
						PdfPTable tablee=new PdfPTable(2); 
						float[] columnWidthss = new float[] {4f,4f};
						tablee.setWidths(columnWidthss);					
						PdfPCell celll = new PdfPCell ();
						
						celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
						celll.setHorizontalAlignment (Element.ALIGN_CENTER);
						celll.setBorder(PdfPCell.NO_BORDER);
						tablee.addCell (celll);
							
							celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setColspan(4);
							celll.setBorder(PdfPCell.NO_BORDER);
							tablee.addCell (celll);
							

							for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
							{
								ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
								
								for(int var341=0;var341<al2.size();var341++)
								{
									String a=(String) al2.get(var341);
									celll = new PdfPCell (new Paragraph(a,new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
									celll.setHorizontalAlignment (Element.ALIGN_CENTER);
									celll.setPadding (5.0f);
									tablee.addCell (celll);
								}
								}	
							document.add(tablee);
						
						
						
				}
				
					if((applicationFor.equals("stonecrusher")) || (indType.equals("Hot mix plants")) ||
							(applicationFor.equals("hotmixplants")) || (applicationFor.equals("stonecrusher and hotmixplants"))){	//stone crusher
						
						Paragraph partCb12 = new Paragraph();
						partCb12.add(new Chunk("J&K POLLUTION CONTROL COMMITTEE JAMMU",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
						partCb12.setAlignment(Element.ALIGN_CENTER);
						document.add(partCb12);
						
						Paragraph partCb11 = new Paragraph();
						partCb11.add(new Chunk("SCHEDULE-II",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +1, Font.BOLD)));
						partCb11.setAlignment(Element.ALIGN_CENTER);
						document.add(partCb11);
						
						Paragraph partCb19a = new Paragraph();
						partCb19a.add(new Chunk("Format For Report On Processing of Application For Grant/Renewal Of Consent For Stone Crushers/Hot mix plants",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
						partCb19a.setAlignment(Element.ALIGN_CENTER);
						document.add(partCb19a);
						
						document.add(space);

						PdfPTable table0=new PdfPTable(3);
						PdfPCell cellz0 = new PdfPCell ();
						float[] columnWidthz0 = new float[] {3f,20f,25f};
						table0.setWidths(columnWidthz0);
						table0.setWidthPercentage(100);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Name of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment Verified From", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+prestan, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);	
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) Category of unit as per general classification approved  by the Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);		
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) Classification of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Product manufactured qty:" +
					"\nIndicate Consented Quantity TPD/TPM", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+brickTiles, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Distance of proposed site from following features(as per sitting criteria)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setColspan(2);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) National Highway/State Highway", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+distanceNational, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) Distt/Other/Road", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) Municipal Limits", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) Distt. Headquarters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) Residential Area/Abadi", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+resArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(f) Tourist Complex/Resort", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+touristComplex, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(g) Forest Land", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+forest, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(h) Controlled Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+controlledArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(i) Approved water supply of 20 KL", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+waterSupply, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(j) Hospital/Nursing Home/Health Centre", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+hospital, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(k) Notified Bird Sancturay/National Park/Wildlife Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+nationalPark, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(l) Agricultural Land/Orchard except Dry/Banjar Kadeem ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+agriculture, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(m) Nearest Educational Institution or other similar Institution", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+educationalInstituion, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
					    cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						document.add(table0);
						document.add(space);
									
									PdfPTable table89=new PdfPTable(3);
									PdfPCell cellz89 = new PdfPCell ();
									float[] columnWidth89 = new float[] {3f,20f,25f};
									table89.setWidths(columnWidth89);
									table89.setWidthPercentage(100);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" (a) Proposed /Installed PCDS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									cellz89.setColspan(2);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(i) Green Belt proposed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+greenBelt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
								
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(ii) Water Sprinkling System", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+waterSprinkle, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(iii) Jacketing/Enclosures at different sections viz crushing point at Screens points etc", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+jacketing, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(iv) Wind breaking wall", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+windBreaking, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(v) Metalling of roads", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+metallingRoads, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" (b) Total proposed cost for installing the PCDs", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+costPCD, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setRowspan(7);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("Remarks:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									cellz89.setColspan(2);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(a) Adequacy of Pollution Control System Installed/Proposed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(b) SPM level(within prescribed standard or not)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+spmLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(c) Impact on receiving environment water and air and comments hereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(d) Have any complaints been receied if so, details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(e) Area under plantation and No. of trees planted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+recieveEnviroment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(f) Other information", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+publicComplain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									document.add(table89);
									document.add(space);
									

									PdfPTable tablez1=new PdfPTable(2);
									PdfPCell cellz1 = new PdfPCell ();
									float[] columnWidthz1 = new float[] {1f,1f};
									tablez1.setWidths(columnWidthz1);
									tablez1.setWidthPercentage(100);
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk("Whether Consent may be Granted : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reinspoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									if(reinspoff.equals("Yes")){
										cellz1 = new PdfPCell (new Paragraph (new Chunk("If yes, Validity period of Consent and conditions if any,applicable", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
										
										cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
									}else{
										cellz1 = new PdfPCell (new Paragraph (new Chunk("If no, further action recommended", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
										
										cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
									}
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									
									document.add(tablez1);	
									document.add(space);
									
									Paragraph partCb1a17 = new Paragraph();
									partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
											"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
									partCb1a17.setAlignment(Element.ALIGN_LEFT);
									document.add(partCb1a17);
									document.add(space);
									
									PdfPTable tableFees = new PdfPTable(7);
									PdfPCell cellFees = new PdfPCell();
									tableFees.setWidthPercentage(100);
									
									cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setColspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
											new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk(
											"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
													Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);
									
									cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									tableFees.addCell(cellFees);
									
									cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
									
									
								
						PdfPTable tablee=new PdfPTable(2); 
						float[] columnWidthss = new float[] {4f,4f};
						tablee.setWidths(columnWidthss);					
						PdfPCell celll = new PdfPCell ();
						
						celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
						celll.setHorizontalAlignment (Element.ALIGN_CENTER);
						celll.setBorder(PdfPCell.NO_BORDER);
						tablee.addCell (celll);
							
							celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setColspan(4);
							celll.setBorder(PdfPCell.NO_BORDER);
							tablee.addCell (celll);
							

							for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
							{
								ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
								
								for(int var341=0;var341<al2.size();var341++)
								{
									String a=(String) al2.get(var341);
									celll = new PdfPCell (new Paragraph(a,new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
									celll.setHorizontalAlignment (Element.ALIGN_CENTER);
									celll.setPadding (5.0f);
									tablee.addCell (celll);
								}
								}	
							document.add(tablee);
					
					}
				
		document.close();
			
			
			
		}catch (Exception e) {
						e.printStackTrace();
						
					}
			    	return tempFile;
					
			
		}
	
	
///////////////////////////////Regular inspection Report///////////////////////////////////////////////////
	
	
	public File regularInspectionPdf(String indName,String capInvt,String dateOfReceipt,String dateOfReceiptdistrict,String  dateOfReceiptcentral,String  periodapplied,String industrialArea,String papersub,String senstiveArea,String distanceRiver,String distanceNational,String districtRoad,String distanceHabitat,String touristComplex,String forest,String hospital,
			String controlledArea,String nationalPark,String agriculture,String chamber,String plantation,String others,String sewageEffluent,String enviorment,String shed,
			String groundLevel,String stackHeight,String fuel,String boilerType,String pollutionSystem,String controlMeasure,String fugitiveEmission,String noiseLevels,String typeofNonHaz,String nonHazQty,String treatmentArrang,String disposalArrange,String quantityrecycler,String methodOfDisposal,String methodOftreatment,
			String saleName,String closeShed,String storedOrDisposed,String leachate,String chemicalStorage,String management,String publicLiability,String separateElectric,String legal,String acoustic,String adequacy,String recieveEnviroment,String publicComplain,String hotelRest,Long number
	,String expansionPlant,String capacityUtili,String modernization,ArrayList ConsentDetailsList,ArrayList IndProductDetailsList,ArrayList AirStackDetailsList
	,ArrayList hotelFacilityDetailList,ArrayList hotelWaterConsumptionList,ArrayList waterBudgetList,ArrayList sewageDetailsList,ArrayList tradeEffluentList,String categoryHaz	,
	String leachateCollect,String chemicalQty,String applicationFor,String commYear,String inspecRepCategory,String inspecRepScale,String brickTiles,String waterSupply,
	String educationalInstituion,String metallingRoads,String windBreaking,String jacketing,String waterSprinkle,String greenBelt,String chimney,String roadsWall,String costPCD,String applicationType
,String certificateFor,String roomCapacity,String authorityName,String indAddressConReport,String standards,ArrayList feeList,String specificArea,
String areaSpecific,String areaSenstive,String incSewage,String areaincSewage,String addSewagereq,String location,String propermi,String oprmain,String prestan,String aircomm,String incwxam,String pubcom,String enviclea,String reinspoff,String redistoff,String reregioff,ArrayList deeRecommendationsListbb,
ArrayList HotelGeneralDetailsInspectionList,String resArea,String spmLevel,ArrayList HazardousWasteGenDetailsList,String indType,String regNo
	)	throws Exception {
		File tempFile = new File("Regular Inspection Report.pdf");
		try{
			    
			
			System.out.println("---inside in pdf report 988--");
		
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
				
				if((applicationFor.equals("both")) && (!indType.equals("Hot mix plants"))){	
					
					Paragraph partCb = new Paragraph();
					partCb.add(new Chunk("J&K POLLUTION CONTROL COMMITTEE JAMMU",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
					partCb.setAlignment(Element.ALIGN_CENTER);
					document.add(partCb);
					
					Paragraph partCb1 = new Paragraph();
					partCb1.add(new Chunk("SCHEDULE-II",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
					partCb1.setAlignment(Element.ALIGN_CENTER);
					document.add(partCb1);
					
					document.add(space);
					
					Paragraph partCb1a = new Paragraph();
					partCb1a.add(new Chunk("Format for processing of application for consent and/ or authorization",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a.setAlignment(Element.ALIGN_CENTER);
					document.add(partCb1a);
					
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
					
					cellz = new PdfPCell (new Paragraph (new Chunk("File No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("SPCB|"+number, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Name and Location of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Correspondence Address ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+indAddressConReport, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Period Applied for(validity up to) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+periodapplied, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
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
				
					
					cellz = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of Factory", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Pollution Category of Industry as per:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Classification Approved by the Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setColspan(2);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Classification of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
				//	cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Category as per specific notification ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellz.setBorder(PdfPCell.NO_BORDER);
				//	cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Location ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setColspan(2);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("In an approved Industrial area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+industrialArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setColspan(2);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("whether land paper submitted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+papersub, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("In sensitive area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					if(senstiveArea.equals("YES")){
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+senstiveArea+
							"\n "+areaSenstive, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					}else{
						cellz = new PdfPCell (new Paragraph (new Chunk(" "+senstiveArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//	cellzz.setBorder(PdfPCell.NO_BORDER);
						tablez.addCell (cellz);	
					}
					cellz = new PdfPCell (new Paragraph (new Chunk("(d)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("In case of any other specific area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					if(specificArea.equals("YES")){
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+specificArea+
							"\n "+areaSpecific, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					}else{
						cellz = new PdfPCell (new Paragraph (new Chunk(" "+specificArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//	cellzz.setBorder(PdfPCell.NO_BORDER);
						tablez.addCell (cellz);	
					}
					cellz = new PdfPCell (new Paragraph (new Chunk("(e)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Distance from river / stream", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+distanceRiver, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					

					cellz = new PdfPCell (new Paragraph (new Chunk("(f)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Distance from National/State Highway", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+distanceNational, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(g)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Distance from nearest habitation and its population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+distanceHabitat, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//	cellzz.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
						
					cellz = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Status of Consent granted earlier ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					PdfPTable tableQ2=new PdfPTable(3);
					PdfPCell cellQ2 = new PdfPCell ();
					float[] columnWidthQ2 = new float[] {2f,2f,2f};
					tableQ2.setWidths(columnWidthQ2);
					tableQ2.setWidthPercentage(100);
					
					cellQ2 = new PdfPCell (new Paragraph (new Chunk("Consent  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellQ2.setBorder(PdfPCell.NO_BORDER);
					tableQ2.addCell (cellQ2);
					cellQ2 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellQ2.setBorder(PdfPCell.NO_BORDER);
					tableQ2.addCell (cellQ2);
					cellQ2 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellQ2.setBorder(PdfPCell.NO_BORDER);
					tableQ2.addCell (cellQ2);
					
					for(int var323=0;var323<ConsentDetailsList.size();var323++)
					{
						ArrayList al2=(ArrayList) ConsentDetailsList.get(var323);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							
							String a=(String) al2.get(var341);
							cellQ2 = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
							cellQ2.setPadding (5.0f);
							tableQ2.addCell (cellQ2);
							
						}
						}
					
					cellz.addElement(tableQ2);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
				 						
					cellz = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					
					PdfPTable tableQ27=new PdfPTable(6);
					PdfPCell cellQ27 = new PdfPCell ();
					float[] columnWidthQ27 = new float[] {1f,1f,1f,1f,1f,1f};
					tableQ27.setWidths(columnWidthQ27);
					tableQ27.setWidthPercentage(100);
											
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Raw Material", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
							
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Product manufactured", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Quantity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("By-product", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellQ27.setHorizontalAlignment (Element.ALIGN_CENTER);
					tableQ27.addCell (cellQ27);
					
					cellQ27 = new PdfPCell (new Paragraph (new Chunk("Unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
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
					
					cellz.addElement(tableQ27);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
									
					cellz = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("In case of expansions please mention whether expansion is due to :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Expansion in plants and machinery", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+expansionPlant, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Capacity Utilization", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+capacityUtili, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
						
					cellz = new PdfPCell (new Paragraph (new Chunk("Modernization or de-bottle necking", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
						
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+modernization, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("14.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Water Pollution Control", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Water Budget", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					 
					
					PdfPTable table26=new PdfPTable(5);
					PdfPCell cell26 = new PdfPCell ();
					float[] columnWidth26 = new float[] {20f,20f,20f,20f,20f};
					table26.setWidths(columnWidth26);
					table26.setWidthPercentage(100);
					
					cell26 = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_LEFT);
					cell26.setRowspan(2);
					table26.addCell (cell26);
							
					cell26 = new PdfPCell (new Paragraph (new Chunk("Water Consumption(in KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell26.setColspan(2);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
				
					cell26 = new PdfPCell (new Paragraph (new Chunk("Effluent Generation(in KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					cell26.setColspan(2);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
							
					
					cell26 = new PdfPCell (new Paragraph (new Chunk("Present", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
							
					cell26 = new PdfPCell (new Paragraph (new Chunk("Previous", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
				
					cell26 = new PdfPCell (new Paragraph (new Chunk("Present", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
								
					cell26 = new PdfPCell (new Paragraph (new Chunk("Previous", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell26.setBorder(PdfPCell.NO_BORDER);
					table26.addCell (cell26);
					
					for(int var323=0;var323<waterBudgetList.size();var323++)
					{
						ArrayList al2=(ArrayList) waterBudgetList.get(var323);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							
							String a=(String) al2.get(var341);
						
							cell26 = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							cell26.setHorizontalAlignment (Element.ALIGN_CENTER);
							cell26.setPadding (5.0f);
							table26.addCell (cell26);
							
						}
						}
					
					cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
			
					cellz.addElement(table26);
					cellz.setColspan(2);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
			
					cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Is there any increase in sewage/trade effluent quantity generated, and if so, indicate the quantity(KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
				
					if(incSewage.equals("Yes")){
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+incSewage+
							"\n "+areaincSewage, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					tablez.addCell (cellz);
					}else{
						cellz = new PdfPCell (new Paragraph (new Chunk(" "+incSewage, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
						tablez.addCell (cellz);
					}
					
					cellz = new PdfPCell (new Paragraph (new Chunk("15.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Details of sewage/trade effluent treatment arrangement provided." +
							"Sewage and trade effluent and treated combinedly indicate the details and are these adequate/inadequate and comply", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+sewageEffluent, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("16.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Details of sewage/trade effluent disposal arrangement provided.An examination of impact on environmental waters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+enviorment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("17.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
							
					cellz = new PdfPCell (new Paragraph (new Chunk("Details of any additional sewage/trade effluent treatment and disposal of arrangements proposed to be provided.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
				
					cellz = new PdfPCell (new Paragraph (new Chunk(" "+addSewagereq, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("18.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Analysis report of treated waste water: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Trade Effluent or combined Effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					PdfPTable table2=new PdfPTable(8);
					PdfPCell cell2 = new PdfPCell ();
					float[] columnWidth2 = new float[] {10f,10f,10f,10f,10f,10f,10f,10f};
					table2.setWidths(columnWidth2);
					table2.setWidthPercentage(100);
								
					cell2 = new PdfPCell (new Paragraph (new Chunk("Date of Sampling and Sample collected by ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("PH between ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("D.O in mg/I ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("BOD in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("C.O.D in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("SS in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("O & G in mg/I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					cell2 = new PdfPCell (new Paragraph (new Chunk("Other Relevant Parameters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell2.setBorder(PdfPCell.NO_BORDER);
					table2.addCell (cell2);
					
					for(int var323=0;var323<tradeEffluentList.size();var323++)
					{
						ArrayList al2=(ArrayList) tradeEffluentList.get(var323);
					
						for(int var341=0;var341<al2.size();var341++)
						{
							
							String a=(String) al2.get(var341);
							
							cell2 = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							cell2.setHorizontalAlignment (Element.ALIGN_CENTER);
							cell2.setPadding (5.0f);
							table2.addCell (cell2);
							
						}
						}
					
					cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cell264.setBorder(PdfPCell.NO_BORDER);
					tablez.addCell (cellz);
					
					cellz.addElement(table2);
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
					tablez.addCell (cellz);
					
					cellz = new PdfPCell (new Paragraph (new Chunk("Sewage", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz.setColspan(2);
					tablez.addCell (cellz);
					
					PdfPTable tableW=new PdfPTable(4);
					PdfPCell cellW = new PdfPCell ();
					float[] columnWidthW = new float[] {10f,10f,10f,10f};
					tableW.setWidths(columnWidthW);
					tableW.setWidthPercentage(100);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("Date of Sampling and Sample collected ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("pH", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("TSS in mg/I ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
					cellW = new PdfPCell (new Paragraph (new Chunk("BOD in mg/I ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
					//cellW.setBorder(PdfPCell.NO_BORDER);
					tableW.addCell (cellW);
					
		for(int var12=0;var12<sewageDetailsList.size();var12++)
					{
					ArrayList al2=(ArrayList) sewageDetailsList.get(var12);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellW = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellW.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellW.setPadding (5.0f);
						tableW.addCell (cellW);
						
					}
					}
		
		cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
		tablez.addCell (cellz);
		
		cellz.addElement(tableW);
		cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
		cellz.setColspan(2);
		tablez.addCell (cellz);
		
		cellz = new PdfPCell (new Paragraph (new Chunk("Note:- In case of industries having effluent more than 500m3/day, latest analysis results of Joint Vigilance Sample should be mentioned.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_JUSTIFIED);
		cellz.setColspan(3);
		tablez.addCell (cellz);
		
		cellz = new PdfPCell (new Paragraph (new Chunk("19.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
		tablez.addCell (cellz);
		
		cellz = new PdfPCell (new Paragraph (new Chunk("(a) Air Pollution Control ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
		cellz.setColspan(2);
		tablez.addCell (cellz);
		
		
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
					
				cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz.addElement(table9);
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("20.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("D.G set with capacity in KVA:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+categoryHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Fuel K/L per day ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+fuel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Stack height ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+stackHeight, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("From ground level ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+groundLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Above the shed / roof ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+shed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("21.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details with the name ,Type boiler,steam generation capacity(t/hr) and quantity of fuel used in each boiler", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+boilerType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("22.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of air pollution control equipment installed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+pollutionSystem, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("23.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Additional air pollution control measure, proposed to be provided if any", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+controlMeasure, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("24.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Fugitive emission an assessment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+fugitiveEmission, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("25.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Noice levels-an assessment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+noiseLevels, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("26.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" a) Hazardous Waste Details :-", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
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
				
				cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
		
				cellz.addElement(table261);
				cellz.setColspan(2);
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
		
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for treatment hazardous waste ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+methodOftreatment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for disposal of hazardous waste ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+methodOfDisposal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("In case of waste being disposed by sale name of party to whom the hazardous waste is solid", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+saleName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("In case of waste being stored in closed sheds/container, indicate the details", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+closeShed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(f) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("In case of waste being stored/disposed off in landfills, the details of landfills sites,locations,dimensions,lining,capacity etc", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+storedOrDisposed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(g) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether leachate collection arrangements have being provided for landfill site", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+leachate, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(h) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether leachate are connected to treatment facility, details of treatment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+leachateCollect, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("27.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Non Hazardous solid waste : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+typeofNonHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Quantity(TPD/TPM)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+nonHazQty, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for Treatments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+treatmentArrang, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Arrangement for Disposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+disposalArrange, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("28.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Hazardous Chemicals", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of storage", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+chemicalStorage, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether permission from concerned authorities like Directorate of Industrial Safety and Health,Local body Explosive Department is taken", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+chemicalQty, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether onsite disaster management plan is prepared and mock drill is conducted periodically", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+management, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(d)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Is public liability insurance obtained as per Public Liability Insurance Act, 1991", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+publicLiability, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("29.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether separate electric meter is installed for pollution control System(s)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+separateElectric, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("30.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Legal record of unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+legal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("31.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether any legal action has been taken against the unit , if so the details thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+authorityName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Remarks : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz.setColspan(3);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("32.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+location, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("33.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether product is permissible or not", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+propermi, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("34.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Operation and maintenance of Pollution Control System ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+oprmain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("35.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Adequacy of Pollution Control System", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("36.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("What are the standards to be prescribed and reason for the proposed standards", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+standards, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				
				
				cellz = new PdfPCell (new Paragraph (new Chunk("37.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Impact on the receiving environment:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("--wate and air-and comments thereof ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("--including examination of nearby industries ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+incwxam, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("38.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Have any public complaints being received, if so, details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("39.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether environmental clearance required", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(""+enviclea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				tablez.addCell (cellz);
				
				
					document.add(tablez);	
					document.add(space);
					
					Paragraph partCb11a1 = new Paragraph();
					partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb11a1.setAlignment(Element.ALIGN_RIGHT);
					document.add(partCb11a1);
					document.add(space);
					
					
					PdfPTable tablez1=new PdfPTable(2);
					PdfPCell cellz1 = new PdfPCell ();
					float[] columnWidthz1 = new float[] {1f,1f};
					tablez1.setWidths(columnWidthz1);
					tablez1.setWidthPercentage(100);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					document.add(tablez1);	
					document.add(space);
					
					Paragraph partCb1a17 = new Paragraph();
					partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
							"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a17.setAlignment(Element.ALIGN_LEFT);
					document.add(partCb1a17);
					document.add(space);
					
					PdfPTable tableFees = new PdfPTable(7);
					PdfPCell cellFees = new PdfPCell();
					tableFees.setWidthPercentage(100);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setColspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk(
							"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
					
							
				PdfPTable tablee=new PdfPTable(2); 
				float[] columnWidthss = new float[] {4f,4f};
				tablee.setWidths(columnWidthss);					
				PdfPCell celll = new PdfPCell ();
				
				celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
				celll.setHorizontalAlignment (Element.ALIGN_CENTER);
				celll.setBorder(PdfPCell.NO_BORDER);
				tablee.addCell (celll);
					
					celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
					celll.setHorizontalAlignment (Element.ALIGN_CENTER);
					celll.setColspan(4);
					celll.setBorder(PdfPCell.NO_BORDER);
					tablee.addCell (celll);
					

					for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
					{
						ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							String a=(String) al2.get(var341);
							celll = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setPadding (5.0f);
							tablee.addCell (celll);
						}
						}	
					document.add(tablee);
				
		}
if((applicationFor.equals("brickkilns")) && (!indType.equals("Hot mix plants"))){
	
	Paragraph partCb12 = new Paragraph();
	partCb12.add(new Chunk("J&K POLLUTION CONTROL COMMITTEE JAMMU",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
	partCb12.setAlignment(Element.ALIGN_CENTER);
	document.add(partCb12);
	
	Paragraph partCb11 = new Paragraph();
	partCb11.add(new Chunk("SCHEDULE-II",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
	partCb11.setAlignment(Element.ALIGN_CENTER);
	document.add(partCb11);
	
	document.add(space);
	
	Paragraph partCb1a1 = new Paragraph();
	partCb1a1.add(new Chunk("Format For Reports on Processing of Application For Grant/Renewal Of Consent For Brick Kilns",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	partCb1a1.setAlignment(Element.ALIGN_CENTER);
	document.add(partCb1a1);
	
	document.add(space);
		
	PdfPTable table0=new PdfPTable(3);
	PdfPCell cellz0 = new PdfPCell ();
	float[] columnWidthz0 = new float[] {3f,20f,25f};
	table0.setWidths(columnWidthz0);
	table0.setWidthPercentage(100);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Name of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment Verified From", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+prestan, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);	
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) Category of unit as per general classification approved  by the Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);		
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) Classification of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Product manufactured Bricks and tiles qty:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+brickTiles, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Location :- Distance of proposed site from following features(as per sitting criteria)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("National Highway/State Highway", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+distanceNational, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Distt/Other/Road", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Municipal Limits", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+areaSpecific, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Distt. Headquarters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+areaSenstive, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Residential Area/Abadi", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+distanceHabitat, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(f) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Tourist Complex/Resort", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+touristComplex, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(g) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Forest Land", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+forest, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(h) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Controlled Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+controlledArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(i) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Approved water supply of 20 kg", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+waterSupply, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(j) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Hospital/Nursing Home/Health Centre", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+hospital, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(k) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Notified Bird Sancturay/National Park/Wildlife Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+nationalPark, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);

	cellz0 = new PdfPCell (new Paragraph (new Chunk("(l) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Agricultural Land/Orchard except Dry/Banjar Kadeem ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+agriculture, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(m) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Nearest Educational Institution or other similar Institution", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+educationalInstituion, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
    //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(A) Proposed/installed PCDs ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Chimney", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+chimney, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
    //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Setting chamber with Baffle", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+chamber, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
    //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Metalled walls road", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+roadsWall, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Plantation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+plantation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Others", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+others, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(B)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Total proposed cost for installing the PCDs", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+costPCD, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Status of Consent granted earlier ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	PdfPTable tableQ2=new PdfPTable(3);
	PdfPCell cellQ2 = new PdfPCell ();
	float[] columnWidthQ2 = new float[] {2f,2f,2f};
	tableQ2.setWidths(columnWidthQ2);
	tableQ2.setWidthPercentage(100);
	
	cellQ2 = new PdfPCell (new Paragraph (new Chunk("Consent  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellQ2.setBorder(PdfPCell.NO_BORDER);
	tableQ2.addCell (cellQ2);
	cellQ2 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellQ2.setBorder(PdfPCell.NO_BORDER);
	tableQ2.addCell (cellQ2);
	cellQ2 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
	//cellQ2.setBorder(PdfPCell.NO_BORDER);
	tableQ2.addCell (cellQ2);
	
	for(int var323=0;var323<ConsentDetailsList.size();var323++)
	{
		ArrayList al2=(ArrayList) ConsentDetailsList.get(var323);
		for(int var341=0;var341<al2.size();var341++)
		{
			String a=(String) al2.get(var341);
			cellQ2 = new PdfPCell (new Paragraph(a,new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
			cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
			cellQ2.setPadding (5.0f);
			tableQ2.addCell (cellQ2);	
		}
		}
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0.addElement(tableQ2);
	cellz0.setColspan(2);
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Remark ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	cellz0.setColspan(2);
	//cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
		
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Adequacy of Pollution control Control System Installed/proposed ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//  cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(b)  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	  //cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Emission Level(SPM/SOx/NOx/10/HC or as applicable under rules)with in stds or not", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+acoustic, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(c)  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Impact on the receiving environment water and air-and comments thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Have any complains been received, if so details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Area under plantation and No. of trees planted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+recieveEnviroment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("(f) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk("Other informations", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	 // cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+publicComplain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
	//  cellz0.setBorder(PdfPCell.NO_BORDER);
	table0.addCell (cellz0);
	
	document.add(table0);
    document.add(space);
    
    Paragraph partCb11a1 = new Paragraph();
	partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	partCb11a1.setAlignment(Element.ALIGN_RIGHT);
	document.add(partCb11a1);
	document.add(space);

	PdfPTable tablez1=new PdfPTable(2);
	PdfPCell cellz1 = new PdfPCell ();
	float[] columnWidthz1 = new float[] {1f,1f};
	tablez1.setWidths(columnWidthz1);
	tablez1.setWidthPercentage(100);
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk("Whether Consent may be Granted : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reinspoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	if(reinspoff.equals("Yes")){
		cellz1 = new PdfPCell (new Paragraph (new Chunk("If yes, Validity period of Consent and conditions if any,applicable", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
		
		cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
	}else{
		cellz1 = new PdfPCell (new Paragraph (new Chunk("If no, further action recommended", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
		
		cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
		cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
		//cellz.setBorder(PdfPCell.NO_BORDER);
		tablez1.addCell (cellz1);
	}
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
	cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
	//cellz.setBorder(PdfPCell.NO_BORDER);
	tablez1.addCell (cellz1);
	
	document.add(tablez1);	
	document.add(space);
	
	Paragraph partCb1a17 = new Paragraph();
	partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
			"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
	partCb1a17.setAlignment(Element.ALIGN_LEFT);
	document.add(partCb1a17);
	document.add(space);
	
	PdfPTable tableFees = new PdfPTable(7);
	PdfPCell cellFees = new PdfPCell();
	tableFees.setWidthPercentage(100);
	
	cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setColspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
			new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk(
			"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);

	cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	cellFees.setRowspan(2);
	tableFees.addCell(cellFees);
	
	cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
			Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
	cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
	cellFees.setPadding(5.0f);
	tableFees.addCell(cellFees);
	
	cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
	
			
				PdfPTable tablee=new PdfPTable(2); 
				float[] columnWidthss = new float[] {4f,4f};
				tablee.setWidths(columnWidthss);					
				PdfPCell celll = new PdfPCell ();
				
				celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
				celll.setHorizontalAlignment (Element.ALIGN_CENTER);
				celll.setBorder(PdfPCell.NO_BORDER);
				tablee.addCell (celll);
					
					celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
					celll.setHorizontalAlignment (Element.ALIGN_CENTER);
					celll.setColspan(4);
					celll.setBorder(PdfPCell.NO_BORDER);
					tablee.addCell (celll);
					

					for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
					{
						ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
						
						for(int var341=0;var341<al2.size();var341++)
						{
							String a=(String) al2.get(var341);
							celll = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setPadding (5.0f);
							tablee.addCell (celll);
						}
						}	
					document.add(tablee);
				
				
				
			}
				
			if((applicationFor.equals("hotel")) && (!indType.equals("Hot mix plants"))){
				

				Paragraph ppppoooo = new Paragraph();
				ppppoooo.add(new Chunk("J&K Pollution Control Committee",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo);
				
				Paragraph ppppoooo1 = new Paragraph();
				ppppoooo1.add(new Chunk("Schedule-II",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo1.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo1);
				
				document.add(space);
				
				Paragraph ppppoooo11 = new Paragraph();
				ppppoooo11.add(new Chunk("Format For Processing Of Application For Consent And/Or Authorization For Hotels/Restaurant",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo11.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo11);
				
				document.add(space);
				
				Paragraph ppppoooo111 = new Paragraph();
				ppppoooo111.add(new Chunk("(Under Water(P&CP) Act 1974, Air(P&CP) Act 1981 and EPA 1986 & Rules thereof)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppppoooo111.setAlignment(Element.ALIGN_CENTER);
				document.add(ppppoooo111);
				document.add(space);
				
				PdfPTable tablezz111=new PdfPTable(3);
				PdfPCell cellzz111 = new PdfPCell ();
				float[] columnWidthzz111 = new float[] {3f,20f,25f};
				tablezz111.setWidths(columnWidthzz111);
				tablezz111.setWidthPercentage(100);

				cellzz111 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("File Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("SPCB|"+number, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Name and Address of Establishment/Hotel/Restaurant", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Address for correspondence of contact person with Phone No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+indAddressConReport, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Period Applied for(validity up to) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+periodapplied, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Establish/Operate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Fresh/Renewal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+certificateFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellzz111.setRowspan(2);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" (a) Year of Establishment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" (b) Tourism Departments Registration. No.& Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+regNo + " , " + inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Year of commissioning", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Classification of establishment of Hotel", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Hotel with / without Restaurant ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
								
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+hotelRest, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Room Capacity ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
			    tablezz111.addCell (cellzz111);
				
			    cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+roomCapacity, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz111.setBorder(PdfPCell.NO_BORDER);
			    tablezz111.addCell (cellzz111);
							    
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Location: ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				cellzz111.setColspan(2);
				tablezz111.addCell (cellzz111);
				
				PdfPTable tableQ21=new PdfPTable(4);
				PdfPCell cellQ21 = new PdfPCell ();
				float[] columnWidthQ21 = new float[] {2f,2f,2f,2f};
				tableQ21.setWidths(columnWidthQ21);
				tableQ21.setWidthPercentage(100);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("In Residential/Commercial/Sensitive/Silent/Mixed Category (Name of Area) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("Distance from nearest Water body(in meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("Distance from major Water body(in meters)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				cellQ21 = new PdfPCell (new Paragraph (new Chunk("Distance from the nearest habitation and its Population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ21.addCell (cellQ21);
				
				for(int var323=0;var323<HotelGeneralDetailsInspectionList.size();var323++)
				{
					ArrayList al2=(ArrayList) HotelGeneralDetailsInspectionList.get(var323);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellQ21 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ21.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ21.setPadding (5.0f);
						tableQ21.addCell (cellQ21);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tableQ21);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("13 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Status of Consent granted earlier ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				PdfPTable tableQ2=new PdfPTable(3);
				PdfPCell cellQ2 = new PdfPCell ();
				float[] columnWidthQ2 = new float[] {2f,2f,2f};
				tableQ2.setWidths(columnWidthQ2);
				tableQ2.setWidthPercentage(100);
				
				cellQ2 = new PdfPCell (new Paragraph (new Chunk("Consent  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ2.addCell (cellQ2);
				cellQ2 = new PdfPCell (new Paragraph (new Chunk("Date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ2.addCell (cellQ2);
				cellQ2 = new PdfPCell (new Paragraph (new Chunk("Number", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellQ2.setBorder(PdfPCell.NO_BORDER);
				tableQ2.addCell (cellQ2);
				
				for(int var323=0;var323<ConsentDetailsList.size();var323++)
				{
					ArrayList al2=(ArrayList) ConsentDetailsList.get(var323);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellQ2 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellQ2.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellQ2.setPadding (5.0f);
						tableQ2.addCell (cellQ2);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tableQ2);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("14 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Facilities available with Capacity of each", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				PdfPTable table494=new PdfPTable(4);
				PdfPCell cellzz494 = new PdfPCell ();
				float[] columnWidth494 = new float[] {20f,20f,20f,20f};
				table494.setWidths(columnWidth494);
				table494.setWidthPercentage(100);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Type ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Facility", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				
				cellzz494 = new PdfPCell (new Paragraph (new Chunk("Facility Detail ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz494.setBorder(PdfPCell.NO_BORDER);
				table494.addCell (cellzz494);
				 
				for(int var3=0;var3<hotelFacilityDetailList.size();var3++)
				{
					ArrayList al2=(ArrayList) hotelFacilityDetailList.get(var3);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellzz494 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellzz494.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellzz494.setPadding (5.0f);
						table494.addCell (cellzz494);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(table494);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("15 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Water Pollution Control ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				PdfPTable tablezz8=new PdfPTable(2);
				PdfPCell cellzz8 = new PdfPCell ();
				float[] columnWidthzz8 = new float[] {10f,20f};
				tablezz8.setWidths(columnWidthzz8);
				tablezz8.setWidthPercentage(100);
								
				
				cellzz8 = new PdfPCell (new Paragraph (new Chunk("Item", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz8.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz8.setRowspan(2);
				//cellzz8.setBorder(PdfPCell.NO_BORDER);
				tablezz8.addCell (cellzz8);
				
				cellzz8 = new PdfPCell (new Paragraph (new Chunk("Quantity(KLD)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz8.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz8.setRowspan(2);
				//cellzz8.setBorder(PdfPCell.NO_BORDER);
				tablezz8.addCell (cellzz8);
				
				for(int var35=0;var35<hotelWaterConsumptionList.size();var35++)
				{
					ArrayList al2=(ArrayList) hotelWaterConsumptionList.get(var35);
					
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellzz8 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellzz8.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellzz8.setPadding (5.0f);
						tablezz8.addCell (cellzz8);
						
					}
					}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tablezz8);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("16 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Analysis report of treated waste water", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(a) Trade effluent or combined effluent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				

				PdfPTable tablezz899=new PdfPTable(7);
				PdfPCell cellzz899 = new PdfPCell ();
				float[] columnWidthzz899 = new float[] {20f,20f,20f,20f,20f,20f,20f};
				tablezz899.setWidths(columnWidthzz899);
				tablezz899.setWidthPercentage(100);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("Date of sampling & sample collected by", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setRowspan(2);
			//	cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
							
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("pH between---to---", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("T.D.S in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("BOD in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setColspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("COD in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("T.S.S in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz899.setRowspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);
				
				cellzz899 = new PdfPCell (new Paragraph (new Chunk("O&G in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz899.setColspan(2);
				//cellzz899.setBorder(PdfPCell.NO_BORDER);
				tablezz899.addCell (cellzz899);


			for(int var323=0;var323<tradeEffluentList.size();var323++)
			{
					ArrayList al2=(ArrayList) tradeEffluentList.get(var323);
			
				for(int var341=0;var341<al2.size();var341++)
				{
					
					String a=(String) al2.get(var341);
					
					cellzz899 = new PdfPCell (new Paragraph(a,new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
					cellzz899.setHorizontalAlignment (Element.ALIGN_CENTER);
					cellzz899.setPadding (5.0f);
						tablezz899.addCell (cellzz899);
											}
					}
			cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);
		 
			cellzz111.addElement(tablezz899);
			cellzz111.setColspan(2);
			cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);	
			
			cellzz111 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);
			
			cellzz111 = new PdfPCell (new Paragraph (new Chunk("(b) Sewage", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
			cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellzz111.setColspan(2);
			//cellzz111.setBorder(PdfPCell.NO_BORDER);
			tablezz111.addCell (cellzz111);
			
			
				PdfPTable tablezzpp=new PdfPTable(4);
				PdfPCell cellzzpp = new PdfPCell ();
				float[] columnWidthzzpp = new float[] {20f,20f,20f,20f};
				tablezzpp.setWidths(columnWidthzzpp);
				tablezzpp.setWidthPercentage(100);
					
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("Date of sampling & sample collected by ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
			   // cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("pH between---to---", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("T.S.S in mg/l", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
			   // cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				cellzzpp = new PdfPCell (new Paragraph (new Chunk("BOD", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzzpp.setBorder(PdfPCell.NO_BORDER);
				tablezzpp.addCell (cellzzpp);
				
				
				for(int var323=0;var323<sewageDetailsList.size();var323++)
				{
						ArrayList al2=(ArrayList) sewageDetailsList.get(var323);
						
					for(int var341=0;var341<al2.size();var341++)
					{
						
						String a=(String) al2.get(var341);
						
						cellzzpp = new PdfPCell (new Paragraph(a,new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
						cellzzpp.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellzzpp.setPadding (5.0f);
						tablezzpp.addCell (cellzzpp);
												}
						}
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
			 
				cellzz111.addElement(tablezzpp);
				cellzz111.setColspan(2);
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);	
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("17 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("D.G Set with capacity in KVA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellzz111.setColspan(2);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(a) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+categoryHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(b) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Fuel (KL/day)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+fuel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(c) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Stack height", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+stackHeight, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(d) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("From ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+groundLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("(e) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Above the shed/roof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+shed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("18 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Details with the name,type of Boiler, stream generated capacity(t/hr) & quantity of fuel used in each boiler.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+boilerType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("19 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Details of air pollution control equipment installed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+pollutionSystem, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("20 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Legal record of unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+legal, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("21 ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk("Whether any legal action has been taken against the Hotel/Restaurant, if so, the details thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
				
				cellzz111 = new PdfPCell (new Paragraph (new Chunk(" "+authorityName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellzz111.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellzz111.setBorder(PdfPCell.NO_BORDER);
				tablezz111.addCell (cellzz111);
					
				document.add(tablezz111);
			    document.add(space);
			    
			    Paragraph part2 = new Paragraph();
				part2.add(new Chunk("Remarks",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD )));
				part2.setAlignment(Element.ALIGN_LEFT);
				document.add(part2);
				
				PdfPTable table9090=new PdfPTable(3);
				PdfPCell cell9090 = new PdfPCell ();
				float[] columnWidth9090 = new float[] {3f,20f,20f};
				table9090.setWidths(columnWidth9090);
				table9090.setWidthPercentage(100);
	
				cell9090 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Location ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+location, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Operation & maintenance of pollution control system ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+oprmain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Adequacy of pollution control system ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("What are the standards to be prescribed and reason for the proposed standards ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+standards, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Impact on receiving environment  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
				cell9090.setColspan(2);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("-water and air-and comments thereof  ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("-including examination of nearby industries ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+incwxam, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Have any public complaints being received.If so, details thereof and comments. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
								
				cell9090 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk("Whether environmental clearance required ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
				
				cell9090 = new PdfPCell (new Paragraph (new Chunk(" "+enviclea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cell9090.setHorizontalAlignment (Element.ALIGN_LEFT);
			   // cell9090.setBorder(PdfPCell.NO_BORDER);
				table9090.addCell (cell9090);
			
				document.add(table9090);
				document.add(space);
				
				Paragraph partCb11a1 = new Paragraph();
				partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb11a1.setAlignment(Element.ALIGN_RIGHT);
				document.add(partCb11a1);
				document.add(space);
				
					PdfPTable tablez1=new PdfPTable(2);
					PdfPCell cellz1 = new PdfPCell ();
					float[] columnWidthz1 = new float[] {1f,1f};
					tablez1.setWidths(columnWidthz1);
					tablez1.setWidthPercentage(100);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
					//cellz.setBorder(PdfPCell.NO_BORDER);
					tablez1.addCell (cellz1);
					
					document.add(tablez1);	
					document.add(space);
					
					Paragraph partCb1a17 = new Paragraph();
					partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
							"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
					partCb1a17.setAlignment(Element.ALIGN_LEFT);
					document.add(partCb1a17);
					document.add(space);
					
					PdfPTable tableFees = new PdfPTable(7);
					PdfPCell cellFees = new PdfPCell();
					tableFees.setWidthPercentage(100);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setColspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk(
							"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
									Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);

					cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					cellFees.setRowspan(2);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
					cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
					cellFees.setPadding(5.0f);
					tableFees.addCell(cellFees);
					
					cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
					
					
					PdfPTable tablee=new PdfPTable(2); 
					float[] columnWidthss = new float[] {4f,4f};
					tablee.setWidths(columnWidthss);					
					PdfPCell celll = new PdfPCell ();
					
					celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
					celll.setHorizontalAlignment (Element.ALIGN_CENTER);
					celll.setBorder(PdfPCell.NO_BORDER);
					tablee.addCell (celll);
						
						celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
						celll.setHorizontalAlignment (Element.ALIGN_CENTER);
						celll.setColspan(4);
						celll.setBorder(PdfPCell.NO_BORDER);
						tablee.addCell (celll);
						

						for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
						{
							ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
							
							for(int var341=0;var341<al2.size();var341++)
							{
								String a=(String) al2.get(var341);
								celll = new PdfPCell (new Paragraph(a,new Font(
										Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
								celll.setHorizontalAlignment (Element.ALIGN_CENTER);
								celll.setPadding (5.0f);
								tablee.addCell (celll);
							}
							}	
						document.add(tablee);
			
			
			
			}	
				
			if((applicationFor.equals("dgset")) && (!indType.equals("Hot mix plants"))){
				
				Paragraph ppA = new Paragraph();
				ppA.add(new Chunk("SCHEDULE-II",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				ppA.setAlignment(Element.ALIGN_CENTER);
				document.add(ppA);
				
				Paragraph partCb15 = new Paragraph();
				partCb15.add(new Chunk("Format for processing of application for D.G Set Authorization",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +0, Font.BOLD)));
				partCb15.setAlignment(Element.ALIGN_CENTER);
				document.add(partCb15);
				document.add(space);
				
				PdfPTable table33=new PdfPTable(3);
				PdfPCell cellz33 = new PdfPCell ();
				float[] columnWidth33 = new float[] {3f,20f,25f};
				table33.setWidths(columnWidth33);
				table33.setWidthPercentage(100);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("File No", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("SPCB|"+number, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				

				cellz33 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Name and Location of Industry", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Correspondence Address ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
			
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+indAddressConReport, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Capital Investment(Rs. in Lakh) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Period Applied for(validity up to) ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+periodapplied, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(a) Establish/Operate", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(b)Fresh/Renewal ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+certificateFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Location ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setColspan(2);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(a)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellzz.setColspan(2);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("In an approved Industrial area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+industrialArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellzz.setColspan(2);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(b)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("whether land paper submitted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+papersub, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(c)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("In sensitive area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+senstiveArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(d)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("In case of any other specific area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				if(specificArea.equals("YES")){
					cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+specificArea+
							"\n "+areaSpecific, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
					cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
					cellz33.setBorder(PdfPCell.NO_BORDER);
					table33.addCell (cellz33);
					}else{
						cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+specificArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz33.setBorder(PdfPCell.NO_BORDER);
						table33.addCell (cellz33);	
					}

				cellz33 = new PdfPCell (new Paragraph (new Chunk("(g)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
			cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Distance from nearest habitation and its population", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+distanceHabitat, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Capacity of D.G Set-------KVA", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(a) Capacity", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+categoryHaz, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(b) Fuel(KL/day)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+fuel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("(c) Stack Height", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+stackHeight, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("  From ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+groundLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("  Above the ground level", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+shed, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Acousitic enclosure/Sound proof system installed or not ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+acoustic, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("10.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Adequacy of pollution control system", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("11.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Standard prescribed under Air(P&C) Act, 1981 & EP Act(D.G Set Noise Level Rules)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+standards, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("12.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Impact on receiving environment water and air and comments thereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("13.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk("Have any public complaints being received. if so, details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				
				cellz33 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz33.setHorizontalAlignment (Element.ALIGN_LEFT);
				cellz33.setBorder(PdfPCell.NO_BORDER);
				table33.addCell (cellz33);
				document.add(table33);
				document.add(space);
				
				Paragraph partCb11a1 = new Paragraph();
				partCb11a1.add(new Chunk("(Signature of inspecting officer) ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb11a1.setAlignment(Element.ALIGN_RIGHT);
				document.add(partCb11a1);
				document.add(space);
				
				PdfPTable tablez1=new PdfPTable(2);
				PdfPCell cellz1 = new PdfPCell ();
				float[] columnWidthz1 = new float[] {1f,1f};
				tablez1.setWidths(columnWidthz1);
				tablez1.setWidthPercentage(100);
				
				cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez1.addCell (cellz1);
				
				cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez1.addCell (cellz1);
				
				document.add(tablez1);	
				document.add(space);
				
				Paragraph partCb1a17 = new Paragraph();
				partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
						"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb1a17.setAlignment(Element.ALIGN_LEFT);
				document.add(partCb1a17);
				document.add(space);
				
				PdfPTable tableFees = new PdfPTable(7);
				PdfPCell cellFees = new PdfPCell();
				tableFees.setWidthPercentage(100);
				
				cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setColspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk(
						"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
								Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);

				cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				cellFees.setRowspan(2);
				tableFees.addCell(cellFees);
				
				cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);
				
				cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
				
				
						PdfPTable tablee=new PdfPTable(2); 
						float[] columnWidthss = new float[] {4f,4f};
						tablee.setWidths(columnWidthss);					
						PdfPCell celll = new PdfPCell ();
						
						celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
						celll.setHorizontalAlignment (Element.ALIGN_CENTER);
						celll.setBorder(PdfPCell.NO_BORDER);
						tablee.addCell (celll);
							
							celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setColspan(4);
							celll.setBorder(PdfPCell.NO_BORDER);
							tablee.addCell (celll);
							

							for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
							{
								ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
								
								for(int var341=0;var341<al2.size();var341++)
								{
									String a=(String) al2.get(var341);
									celll = new PdfPCell (new Paragraph(a,new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
									celll.setHorizontalAlignment (Element.ALIGN_CENTER);
									celll.setPadding (5.0f);
									tablee.addCell (celll);
								}
								}	
							document.add(tablee);
						
						
						
				}
				
					if((applicationFor.equals("stonecrusher")) || (indType.equals("Hot mix plants"))){	//stone crusher
						
						Paragraph partCb12 = new Paragraph();
						partCb12.add(new Chunk("J&K POLLUTION CONTROL COMMITTEE JAMMU",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
						partCb12.setAlignment(Element.ALIGN_CENTER);
						document.add(partCb12);
						
						Paragraph partCb11 = new Paragraph();
						partCb11.add(new Chunk("SCHEDULE-II",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE +1, Font.BOLD)));
						partCb11.setAlignment(Element.ALIGN_CENTER);
						document.add(partCb11);
						
						if(applicationFor.equals("stonecrusher")){
							Paragraph partCb19a = new Paragraph();
							partCb19a.add(new Chunk("Format For Report On Processing of Application For Grant/Renewal Of Consent For Stone Crushers",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
							partCb19a.setAlignment(Element.ALIGN_CENTER);
							document.add(partCb19a);
							}else if(applicationFor.equals("hotmixplants")){
								Paragraph partCb19a = new Paragraph();
								partCb19a.add(new Chunk("Format For Report On Processing of Application For Grant/Renewal Of Consent For Hot mix plants",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
								partCb19a.setAlignment(Element.ALIGN_CENTER);
								document.add(partCb19a);
							}else{
								Paragraph partCb19a = new Paragraph();
								partCb19a.add(new Chunk("Format For Report On Processing of Application For Grant/Renewal Of Consent For Stone Crushers and Hot mix plants",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.NORMAL)));
								partCb19a.setAlignment(Element.ALIGN_CENTER);
								document.add(partCb19a);
							}
						document.add(space);

						PdfPTable table0=new PdfPTable(3);
						PdfPCell cellz0 = new PdfPCell ();
						float[] columnWidthz0 = new float[] {3f,20f,25f};
						table0.setWidths(columnWidthz0);
						table0.setWidthPercentage(100);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("1.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Name of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+indName, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("2.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+capInvt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("3.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Capital Investment Verified From", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+prestan, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);	
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("4.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Year of Commissioning of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+commYear, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("5.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) Type of Consent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+applicationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) Category of unit as per general classification approved  by the Committee", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepCategory, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);		
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) Classification of the unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+inspecRepScale, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("6.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Product manufactured qty:" +
					"\nIndicate Consented Quantity TPD/TPM", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+brickTiles, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("7.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_CENTER);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk("Distance of proposed site from following features(as per sitting criteria)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setColspan(2);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(a) National Highway/State Highway", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+distanceNational, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(b) Distt/Other/Road", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(c) Municipal Limits", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(d) Distt. Headquarters", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+districtRoad, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(e) Residential Area/Abadi", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+resArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(f) Tourist Complex/Resort", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+touristComplex, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(g) Forest Land", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+forest, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(h) Controlled Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+controlledArea, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(i) Approved water supply of 20 KL", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+waterSupply, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(j) Hospital/Nursing Home/Health Centre", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+hospital, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(k) Notified Bird Sancturay/National Park/Wildlife Area", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+nationalPark, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
					
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(l) Agricultural Land/Orchard except Dry/Banjar Kadeem ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+agriculture, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						
						cellz0 = new PdfPCell (new Paragraph (new Chunk("(m) Nearest Educational Institution or other similar Institution", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
						cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
							
						cellz0 = new PdfPCell (new Paragraph (new Chunk(" "+educationalInstituion, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
						cellz0.setHorizontalAlignment (Element.ALIGN_LEFT);
					    cellz0.setBorder(PdfPCell.NO_BORDER);
						table0.addCell (cellz0);
						document.add(table0);
						document.add(space);
									
									PdfPTable table89=new PdfPTable(3);
									PdfPCell cellz89 = new PdfPCell ();
									float[] columnWidth89 = new float[] {3f,20f,25f};
									table89.setWidths(columnWidth89);
									table89.setWidthPercentage(100);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("8.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" (a) Proposed /Installed PCDS", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									cellz89.setColspan(2);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(i) Green Belt proposed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+greenBelt, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
								
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(ii) Water Sprinkling System", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+waterSprinkle, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(iii) Jacketing/Enclosures at different sections viz crushing point at Screens points etc", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+jacketing, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(iv) Wind breaking wall", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+windBreaking, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(v) Metalling of roads", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+metallingRoads, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" (b) Total proposed cost for installing the PCDs", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+costPCD, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("9.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_CENTER);
									cellz89.setRowspan(7);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("Remarks:", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									cellz89.setColspan(2);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(a) Adequacy of Pollution Control System Installed/Proposed", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+adequacy, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(b) SPM level(within prescribed standard or not)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+spmLevel, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(c) Impact on receiving environment water and air and comments hereof", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+aircomm, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(d) Have any complaints been receied if so, details thereof and comments", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+pubcom, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(e) Area under plantation and No. of trees planted", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+recieveEnviroment, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk("(f) Other information", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									cellz89 = new PdfPCell (new Paragraph (new Chunk(" "+publicComplain, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz89.setHorizontalAlignment (Element.ALIGN_LEFT);
									cellz89.setBorder(PdfPCell.NO_BORDER);
									table89.addCell (cellz89);
									
									document.add(table89);
									document.add(space);
									

									PdfPTable tablez1=new PdfPTable(2);
									PdfPCell cellz1 = new PdfPCell ();
									float[] columnWidthz1 = new float[] {1f,1f};
									tablez1.setWidths(columnWidthz1);
									tablez1.setWidthPercentage(100);
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk("Whether Consent may be Granted : ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reinspoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									if(reinspoff.equals("Yes")){
										cellz1 = new PdfPCell (new Paragraph (new Chunk("If yes, Validity period of Consent and conditions if any,applicable", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
										
										cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
									}else{
										cellz1 = new PdfPCell (new Paragraph (new Chunk("If no, further action recommended", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
										
										cellz1 = new PdfPCell (new Paragraph (new Chunk(""+reregioff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
										cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
										//cellz.setBorder(PdfPCell.NO_BORDER);
										tablez1.addCell (cellz1);
									}
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk("Officer Recommendation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									cellz1 = new PdfPCell (new Paragraph (new Chunk(""+redistoff, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
									cellz1.setHorizontalAlignment (Element.ALIGN_LEFT);
									//cellz.setBorder(PdfPCell.NO_BORDER);
									tablez1.addCell (cellz1);
									
									
									document.add(tablez1);	
									document.add(space);
									
									Paragraph partCb1a17 = new Paragraph();
									partCb1a17.add(new Chunk("Details of the Consent Fee Paid: "+ "" +
											"\nType of Consent:- "+applicationType,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
									partCb1a17.setAlignment(Element.ALIGN_LEFT);
									document.add(partCb1a17);
									document.add(space);
									
									PdfPTable tableFees = new PdfPTable(7);
									PdfPCell cellFees = new PdfPCell();
									tableFees.setWidthPercentage(100);
									
									cellFees = new PdfPCell(new Paragraph(new Chunk("For the Year", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setColspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Bank Name", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Branch Name",
											new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk(
											"Draft No./Money Receipt No.", new Font(Font.TIMES_ROMAN,
													Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);

									cellFees = new PdfPCell(new Paragraph(new Chunk("Amount (In Rupees)", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									cellFees.setRowspan(2);
									tableFees.addCell(cellFees);
									
									cellFees = new PdfPCell(new Paragraph(new Chunk("From", new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
									cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
									cellFees.setPadding(5.0f);
									tableFees.addCell(cellFees);
									
									cellFees = new PdfPCell(new Paragraph(new Chunk("To", new Font(
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
									
									
								
						PdfPTable tablee=new PdfPTable(2); 
						float[] columnWidthss = new float[] {4f,4f};
						tablee.setWidths(columnWidthss);					
						PdfPCell celll = new PdfPCell ();
						
						celll = new PdfPCell (new Paragraph (new Chunk("Officers Remarks", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2, Font.BOLD  ))));
						celll.setHorizontalAlignment (Element.ALIGN_CENTER);
						celll.setBorder(PdfPCell.NO_BORDER);
						tablee.addCell (celll);
							
							celll = new PdfPCell (new Paragraph (new Chunk("Name and Designation", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE-2  , Font.BOLD))));
							celll.setHorizontalAlignment (Element.ALIGN_CENTER);
							celll.setColspan(4);
							celll.setBorder(PdfPCell.NO_BORDER);
							tablee.addCell (celll);
							

							for(int var3=0;var3<deeRecommendationsListbb.size();var3++)
							{
								ArrayList al2=(ArrayList) deeRecommendationsListbb.get(var3);
								
								for(int var341=0;var341<al2.size();var341++)
								{
									String a=(String) al2.get(var341);
									celll = new PdfPCell (new Paragraph(a,new Font(
											Font.TIMES_ROMAN, Font.DEFAULTSIZE - 0 , Font.NORMAL)));
									celll.setHorizontalAlignment (Element.ALIGN_CENTER);
									celll.setPadding (5.0f);
									tablee.addCell (celll);
								}
								}	
							document.add(tablee);
					
					}
				
		document.close();
			
			
			
		}catch (Exception e) {
						e.printStackTrace();
						
					}
			    	return tempFile;
					
			
		}	
	
	

	
	
	
	
	

}







