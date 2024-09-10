
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

public class BmwMasterReportJava {
	
	public File freshInspectionPdf(ArrayList feeList,
			String indName,String indAddress,long indNewCapInvt,String dateOfComm,String indEmail,String expDate,String shiftsIndustry,String monitoring
			,String expNoEmp,String noOfEmp,String waterMonitoring,String siteArea,String nearRiver
			,String riverName,String riverDist,String nearResidCol,String colPopulation,String colLocation,String colDistance,String nearIndEstate
			,String disposalSysProv,String utilizeSys,String proposalDetails,String totalPlotArea,String plotArea,
			String nameOfApplicant,
			String nameOfInstitution,
			String activityAuthorizationSoughtFor,
			String authorizationType,
			String previousAuthNo,
			String prevAuthDate,
			String nameAddressInstitution,
			String addrTreatmentFacility,
			String addrPlaceDisposalOfWaste,
			String completionStatus,
			String modeTrans,
			String modeTreat,
			String descrip,
			String dateCreatedVar,
			String createdBy,
			String lastUpdatedVar,
			String updatedBy,
			String applicationStatus,
			String condImposedRenew,
			String categHAW,
			String categAW,
			String categMBW,
			String categWS,
			String categDMCD,
			String categSW6,
			String categSW7,
			String categLW,
			String categIA,
			String categCW,
			String categHAWUnit,
			String categAWUnit,
			String categMBWUnit,
			String categWSUnit,
			String categDMCDUnit,
			String categSW6Unit,
			String categSW7Unit,
			String categLWUnit,
			String categIAUnit,
			String categCWUnit,
			String prevExpDateVar,
			String authorisationAppliedFor,
			String hcfType,
			String bmwfacility,
			String bmwstatus,
			String wastelocationaddress,
			String wastedisposalplace,
			String outpatientsFacility, 
			String inpatientsFacility,
			String noofbeds,
			String other1,
			String other2,
			String patientspermonth,
			String destroyer,
			String bmwrules1,
			String NoofHCF,
			String Jurisdictionalarea,
			String authorisationDay,
			String authorisationMonth,
			String detailapc,
			String detailetp,
			String quantityperDay,
			String quantityperMonth,
			String quantityperDay1,
			String quantityperMonth1,
			String authapply,
			String hcfTypeMenu,
			String anatomicalwaste,
		    String animalwaste,
		    String biowaste,
		    String wastesharp,
		    String discardedwaste,
		    String soiledwaste,
		    String solidwaste,
		    String liquidwaste,
		    String ash,
		    String chemicalwaste,
		    String total1,
			String paymentDeviation,
			String remittedFees,
			String statusCteCto,
			String latitude,
			String longtitude,
			String detailsOfDirections,
			String noOfNonBeds,
			String noOfNonBeds1,
			String noOfInOutPatients,
			String colorCodedBags,
			String noOfBedsCbmwtf,
			String treatmentAndDisposal,
			String qtyOfBmwTreated,
			String contingencyPlan,
			String detailsOfTraining,
			String incinrators,
			String incinratorsType,
			String plasmaPyrolysis,
			String plasmaPyrolysisType,
			String autoclaves,
			String autoclavesType,
			String microwave,
			String microwaveType,
			String hydroclave,
			String hydroclaveType,
			String shredders,
			String shreddersType,
			String needleTipCutter,
			String needleTipCutterType,
			String sharpEncapsulation,
			String sharpEncapsulationType,
			String deepBurial,
			String deepBurialType,
			String chemDisinfection,
			String chemDisinfectionType,
			String anyOtherTretmntEquip,
			String anyOtherTretmntEquipType,
			String chemicalSolidWaste,
			String chemicalLiquidWaste,
			String discardedLinen,
			String otherClininLabWaste,
			String contaminatedwaste,
			String wasteSharps,
			String glassWare,
			String metallicBodyImplants,
			boolean isNewApplication,ArrayList onlinefeeDetailsList	
) throws Exception	{
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
				
				Image image = Image.getInstance("images2/jammu.jpg");
				image.scalePercent(40.0f);
				image.setAlignment(Image.LEFT | Image.TEXTWRAP);
				document.add(image);
				document.add(space);
				
				
					
				Paragraph partCb = new Paragraph();
				partCb.add(new Chunk("J&K Pollution Control Committee",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
				partCb.setAlignment(Element.ALIGN_CENTER);
				document.add(partCb);
				
				Paragraph partCb1 = new Paragraph();
				partCb1.add(new Chunk("BIO-MEDICAL WASTE MASTER DATA",
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
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
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
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+authorisationAppliedFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
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
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				//----------------//
				
				//---------------close-----------------//
				
				
				document.add(space);
				
				
				document.add(space);
				document.add(space);
				document.add(space);
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of Activity & Facility-For HCF only", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz.setColspan(3);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("1", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("HCF/CBMWTF Type", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+hcfType+"/"+hcfTypeMenu, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("2", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Bio-Medical Waste Facility Status ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+bmwfacility, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("3", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("CBMWTF-location and Office address of treatment and disposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+wastedisposalplace+" address:   	"+wastelocationaddress, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("4", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Mode of Transportation of BMW", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Common Facility Vehicle", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("5", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Status of CTE/CTO-latest consent type, issued date and validity date", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+statusCteCto, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("6", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("GPS Coordinates -Lat/Lon of the location", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+latitude+"                 "+longtitude, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("6", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of directions or notices or legal actions if any during the period of earlier authorisation (Attach documents if any)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+detailsOfDirections, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("7", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Medical treatment Facility provided to Outpatients", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+outpatientsFacility, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("8", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Medical treatment Facility provided to Inpatients", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+inpatientsFacility, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("9", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("No of Beds of HCF", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+noofbeds, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("For Non bedded Hospital (Specify)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+noOfNonBeds, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("11", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Whether the colour coded bags or containers has been provided for collection and segregation of BMW as prescribed in BMW rules", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+colorCodedBags, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("12", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Details of training conducted to the paramedical staff/sanitary workers in the BMW management", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" "+detailsOfTraining, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				cellz = new PdfPCell (new Paragraph (new Chunk("13", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Others (specify)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
			//	cellz.setColspan(2);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.NORMAL ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				
				cellz = new PdfPCell (new Paragraph (new Chunk("Quantity of BMW handled, treated or disposal", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellz.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellz.setColspan(3);
			//	cellz.setBorder(PdfPCell.NO_BORDER);
				tablez.addCell (cellz);
				document.add(tablez);
				
				
				PdfPTable tablez12=new PdfPTable(4);
				PdfPCell cellzz = new PdfPCell ();
				float[] columnWidthzz = new float[] {15f,20f,20f,25f};
				tablez12.setWidths(columnWidthzz);
				tablez12.setWidthPercentage(100);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Type of Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Quantity Generated or collected in Kg/day", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Method of Treatment and Disposal as per Schedule-I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
			
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Yellow", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellzz.setRowspan(8);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("a) Human Anatomical Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+anatomicalwaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("b) Animal Anatomical Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+animalwaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("c)	 Soiled Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+soiledwaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("d) Expired or Discarded Medicines", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+discardedwaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("e) Chemical Solid Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+chemicalSolidWaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("f) Chemical Liquid Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+chemicalLiquidWaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Onsite ETP to treat and conform to the discharge standards", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("g)Discarded linen, mattresses, beddings contaminated with blood or body fluid", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+discardedLinen, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Disinfection followed by Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("h)Microbiology, Biotechnology and other clinical laboratory waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Sterilisation followed by Incineration", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Red", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Contaminated waste (Recyclable)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+contaminatedwaste, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Autoclaving followed by shredding. Treated waste to be sent to Authorised recyclers or for energy recovery or plastic to Diesel or fuel oil or for road making", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("White( Translucent", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Waste sharps including Metals", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+wasteSharps, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Autoclaving followed by shredding. Treated waste to be sent to Iron foundries or sanitary landfill or designated concrete waste sharp pit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Blue", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellzz.setRowspan(2);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Glassware", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+glassWare, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Disinfection or Autoclaving or microwaving or hydroclaving and then sent for recycling", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Metallic Body Implants", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_LEFT);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk(" "+metallicBodyImplants, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				cellzz = new PdfPCell (new Paragraph (new Chunk("Details of Treatment Equiments available for treatment of Bio-Medical Waste", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz.setHorizontalAlignment (Element.ALIGN_CENTER);
				cellzz.setColspan(4);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez12.addCell (cellzz);
				
				document.add(tablez12);
			    //------------open----------------//		
			
				PdfPTable tablez13=new PdfPTable(4);
				PdfPCell cellzz13 = new PdfPCell ();
				float[] columnWidthzz13 = new float[] {4f,20f,20f,25f};
				tablez13.setWidths(columnWidthzz13);
				tablez13.setWidthPercentage(100);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("SI No.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Treatment equipment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("No of Units", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Type and capacity of each unit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("01", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Incinerators", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+incinrators, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+incinratorsType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("02", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Plasma Pyrolysis", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+plasmaPyrolysis, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+plasmaPyrolysisType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("03", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Autoclaves", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+autoclaves, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+autoclavesType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("04", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Microwave", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+microwave, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+microwaveType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("05", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Hydroclave", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+hydroclave, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+hydroclaveType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("06", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Shredders", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+shredders, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+shreddersType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("07", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Needle tip cutter or destroyer", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+needleTipCutter, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+needleTipCutterType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("08", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Sharp encapsulation or Concrete pit", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+sharpEncapsulation, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+sharpEncapsulationType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("09", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Deep burial pits", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+deepBurial, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+deepBurialType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("10", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Chemical disinfection", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+chemDisinfection, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+chemDisinfectionType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("11", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk("Any other treatment equipment", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+anyOtherTretmntEquip, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				
				cellzz13 = new PdfPCell (new Paragraph (new Chunk(" "+anyOtherTretmntEquipType, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,Font.BOLD ,new Color(0, 0, 0) ))));
				cellzz13.setHorizontalAlignment (Element.ALIGN_CENTER);
				//cellz.setBorder(PdfPCell.NO_BORDER);
				tablez13.addCell (cellzz13);
				document.add(tablez13);
				//--------------------close------------------//
				
				
				Paragraph partCb1a17 = new Paragraph();
				partCb1a17.add(new Chunk("Details of the Consent Fee Paid: ",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE , Font.BOLD)));
				partCb1a17.setAlignment(Element.ALIGN_LEFT);
				document.add(partCb1a17);
				document.add(space);
				if(feeList.size()>0){
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
				}else if(onlinefeeDetailsList.size()>0){

						PdfPTable tableFees1 = new PdfPTable(4);
						PdfPCell cellFees1 = new PdfPCell();
						tableFees1.setWidthPercentage(100);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Id", new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk("Payment Date",
								new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk(
								"Ammount", new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Status", new Font(
								Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
						cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
						cellFees1.setPadding(5.0f);
						tableFees1.addCell(cellFees1);

						System.out.println("--online feee list --"+onlinefeeDetailsList.size()+"-----------------"+onlinefeeDetailsList.get(0).toString());

						for (int var22 = 0; var22 < onlinefeeDetailsList.size(); var22++) {
							ArrayList feeList11 = (ArrayList)onlinefeeDetailsList.get(var22);

							for (int var33 = 0; var33 < feeList11.size(); var33++) {

								String feeInner1 = (String)feeList11.get(var33);
								System.out.println("------------"+feeInner1);
								cellFees1 = new PdfPCell(new Paragraph(feeInner1));
								cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
								cellFees1.setPadding(5.0f);
								tableFees1.addCell(cellFees1);
							}}		
						document.add(tableFees1);
				  
				}
			
		document.close();
			
			
			
		}catch (Exception e) {
						e.printStackTrace();
						
					}
			    	
				return tempFile;	
			
		}
	/*public static void main(String...args){
		BmwMasterReportJava mh= new BmwMasterReportJava();
		String applicationType="";
	
		//Arranew ArrayList();
		String applicationFor="";
		String indName="";
		String indAddress="";
		long indNewCapInvt=55;
		String dateOfComm="";
		String indEmail="";
		String expDate="";
		String shiftsIndustry="";
		String monitoring="";
		String expNoEmp="";
		String noOfEmp="";
		String waterMonitoring="";
		String siteArea="";
		String nearRiver="";
		String riverName="";
		String riverDist="";
		String nearResidCol="";
		String colPopulation="";
		String colLocation="";
		String colDistance="";
		String nearIndEstate="";
		String disposalSysProv="";
		String utilizeSys="";
		String proposalDetails="";
		String totalPlotArea="";
		String plotArea="";
		//mh.freshInspectionPdf(applicationType, , feeList, applicationFor,indName, indAddress, indNewCapInvt, dateOfComm, indEmail, expDate, shiftsIndustry, monitoring, expNoEmp, noOfEmp, waterMonitoring, siteArea, nearRiver, riverName, riverDist, nearResidCol, colPopulation, colLocation, colDistance, nearIndEstate, disposalSysProv, utilizeSys, proposalDetails, totalPlotArea, plotArea);
		
	}
	*/
	

	
	
	
	
	

	
	
	
	
	

}







