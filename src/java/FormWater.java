import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.util.*;
import java.text.*;
public class FormWater {
	public File formWaterPdf(String appID,String dateOfSubmission,String industryName,String industryPlot,String industryAddress,
			String industryTehsil,String industryDistrict, String industryTelephone,String occupierName, String occupierDesignation,
			String occupierAddress,String occupierTehsil,String occupierDistrict,String occupierTelephone,String dtOfCommissioning,
			String registrationNumber,Integer capitalInvestment,String categoryIndustry, String rawMaterialString,
			ArrayList wasteWaterGenerationDetailsFinalList, ArrayList fee,String nameAddressPartners,ArrayList productDetailsList,
			ArrayList treatmentDetails, ArrayList treatedEffluent,ArrayList listDocuments,String industryCity, String occCity,
			String consentFor,	String regAuthority, String regDate, String nearRiver, String riverName,String riverDist,
			String disposalSysProv, String utilizeSys,String proposalDetails, String plotArea, String builtUpArea,
			String commMonth, String expNoEmp, String noOfEmp,String nearResidCol, String colPopulation, String colLocation,
			String colDistance,Long totalProjectCost,Long pollutionMonitoringCost, String equipWithSepMeters,String equipDGSet,
			String nonHwmProdName, String landArea,String prodCapacity, String accident, String isolatedStorage,
			String compStatus,String siteApproval, String emergency,String isUpdated, String importChem, String pliAct,
			String treePlantDev, String wasteMinDetail,String underPubHearing,ArrayList waterSourceDetailsList, ArrayList waterModeUseDetailList,
			Integer waterModeQuantity, Integer totaleffluentGenerated,ArrayList wasteWaterGenerationDetailsFinalList1,
			ArrayList indExpenditureCostDetailsInstanceFinalList,ArrayList hazardousStorageDetails,
			String activity,ArrayList hazardousGenDetails,String hwmGenerating,String categoryNo,String presentTreatment, 
			String area,String location,String methodology,String numberStacks,
			String stack,String capacity,String fuelTyp,String fuelQty,String naturaldraft,String materialConstruction,
			String shape,String aboveGroundHeight, String aboveFactHeight, String diamSize,String gasQty,String gasTemp, String gasVel,
			ArrayList plantEquipmentDetails,String monitoring,String odorCompounds, String facility, String quality,String sewage,
			String sewageState, String treatedEffCapacity,ArrayList airFlueGasEmissionDetails, String totalPlotArea,
			ArrayList stoneCrusherSittingCriteriaDetail,ArrayList stoneCrusherControlDevicesDetail,ArrayList brickKilnsSittingCriteriaDetail, 
			String hotelArea,String capacity1,String trenchSize,String chimeny,String height9, String ecd,String cluster,String makeDGset,
			String modelDGset, String powerRating,String soundLevel,String locationDg, String loadShedding, String sheddingInfo,String noise, 
			String room, String exhaustGas, String installation,String minVibration, String minLeaks,ArrayList emissionDetailsList, ArrayList parameterDetailsList,
			String industryScale, String hotelNameValue, String roomCapacity,String restaurantN, String capacityN,String yearN,
			String investmentN, String locationN, String distanceN,String prevention,String relInfo, String dgSetN,String makeN,
			String dgcapacity, ArrayList hotelWaterConsumptionDetail, ArrayList hotelFacilityDetail,ArrayList hotelFacilityDetailRestaurent,
			ArrayList hotelWasteEmissionDetail, ArrayList greenWaterUsesDetail,ArrayList wasteDischargeDetail,
			ArrayList stoneCrusherWaterReq,ArrayList waterConsumptionDetail,ArrayList nocDetailsList,String fuel,String stackHeight,String heightOfBuilding,
			String totalHeight,String dgStInstalled, String dgSetCapacity,String AcausticEnclosure, ArrayList boilerDetailsList, ArrayList furnaceDetailsList,
			String noisePollution,String noiseMeasures,String presParameters,String totalCost, String controlMeasures,String deptTourism,String tourismDetails,
			String septicTank,String soakagePit,String sewagePlant,String hotelchimeny,String exhaustFans,String greenery,String indpendentRestaurant,String nocObtained,
			String b2,String possibilityOfRecovery,String authForList,ArrayList hazardousStorageDetails1,String present,String presentdetails,ArrayList hazardousDisposalDetails1,
			ArrayList HazsubList,ArrayList HazwasteList,String totalCostPoll,ArrayList waterSolidWasteGenDetailsInstanceFinalList,String feeType,String certificateFor) throws Exception {
		File tempFile = new File("FormWater.pdf");
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(tempFile));		
		document.open();		
		Paragraph space4 = new Paragraph();
		space4.add(new Chunk("         ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 3, Font.BOLD)));
		space4.add(new Chunk("          ", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 1)));
		document.add(space4);		
		//PdfPTable tableFees1;
		PdfPTable tableFees = new PdfPTable(5);
		PdfPTable tableFees1=new PdfPTable(4);
		if(feeType.equals("Offline")){
			
		tableFees = new PdfPTable(5);
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

		for (int var2 = 0; var2 < fee.size(); var2++) {
			ArrayList feeList = (ArrayList) fee.get(var2);

			for (int var3 = 0; var3 < feeList.size(); var3++) {

				String feeInner = (String) feeList.get(var3);
				cellFees = new PdfPCell(new Paragraph(feeInner));
				cellFees.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees.setPadding(5.0f);
				tableFees.addCell(cellFees);
			}}
		}
    else {
	   System.out.println("in Online fee table");
	tableFees1=new PdfPTable(4);
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

      cellFees1 = new PdfPCell(new Paragraph(new Chunk("Transaction Status", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees1.setPadding(5.0f);
		tableFees1.addCell(cellFees1);
		
		cellFees1 = new PdfPCell(new Paragraph(new Chunk(
				"Ammount", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellFees1.setPadding(5.0f);
		tableFees1.addCell(cellFees1);

		//System.out.println("--online feee list --"+onlineFee11.size()+"-----------------"+onlineFee11.get(0).toString());

		for (int var22 = 0; var22 < fee.size(); var22++) {
			ArrayList feeList11 = (ArrayList)fee.get(var22);

			for (int var33 = 0; var33 < feeList11.size(); var33++) {

				String feeInner1 = (String)feeList11.get(var33);
				System.out.println("------------"+feeInner1);
				cellFees1 = new PdfPCell(new Paragraph(feeInner1));
				cellFees1.setHorizontalAlignment(Element.ALIGN_LEFT);
				cellFees1.setPadding(5.0f);
				tableFees1.addCell(cellFees1);
			}}			
     }		
		PdfPTable table23 = new PdfPTable(4);
		PdfPCell cell23 = new PdfPCell();
		table23.setWidthPercentage(100);
		cell23 = new PdfPCell(new Paragraph(
				new Chunk("Product Name", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell23.setPadding(5.0f);
		table23.addCell(cell23);

		cell23 = new PdfPCell(new Paragraph(new Chunk("Capacity", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));

		cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell23.setPadding(5.0f);
		table23.addCell(cell23);

		cell23 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell23.setPadding(5.0f);
		table23.addCell(cell23);

		cell23 = new PdfPCell(new Paragraph(new Chunk("By Products & Quantity", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.BOLD))));
		cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell23.setPadding(5.0f);
		table23.addCell(cell23);		
		
		for (int var2 = 0; var2 < productDetailsList.size(); var2++) {
			ArrayList al = (ArrayList) productDetailsList.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cell23 = new PdfPCell(new Paragraph(a));
				cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell23.setPadding(5.0f);
				table23.addCell(cell23);

			}
		}	
		PdfPTable tableGreenUsage = new PdfPTable(2);
		PdfPCell cellGreenUsage = new PdfPCell();
		tableGreenUsage.setWidthPercentage(100);
		cellGreenUsage = new PdfPCell(new Paragraph(new Chunk("Water Uses Type", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellGreenUsage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellGreenUsage.setPadding(5.0f);
		tableGreenUsage.addCell(cellGreenUsage);

		cellGreenUsage = new PdfPCell(new Paragraph(new Chunk("Quantity (KLD)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellGreenUsage.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellGreenUsage.setPadding(5.0f);
		tableGreenUsage.addCell(cellGreenUsage);		
		
		for (int var2 = 0; var2 < greenWaterUsesDetail.size(); var2++) {
			ArrayList al = (ArrayList) greenWaterUsesDetail.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cellGreenUsage = new PdfPCell(new Paragraph(a));
				cellGreenUsage.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellGreenUsage.setPadding(5.0f);
				tableGreenUsage.addCell(cellGreenUsage);

			}
		}	
		
		PdfPTable tableGreenDischarge = new PdfPTable(2);
		PdfPCell cellGreenDischarge = new PdfPCell();

		tableGreenDischarge.setWidthPercentage(100);

		cellGreenDischarge = new PdfPCell(new Paragraph(new Chunk("Water Discharge Type", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellGreenDischarge.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellGreenDischarge.setPadding(5.0f);
		tableGreenDischarge.addCell(cellGreenDischarge);

		cellGreenDischarge = new PdfPCell(new Paragraph(new Chunk("Quantity (KLD)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellGreenDischarge.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellGreenDischarge.setPadding(5.0f);
		tableGreenDischarge.addCell(cellGreenDischarge);
		

		for (int var2 = 0; var2 < wasteDischargeDetail.size(); var2++) {
			ArrayList al = (ArrayList) wasteDischargeDetail.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cellGreenDischarge = new PdfPCell(new Paragraph(a));
				cellGreenDischarge.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellGreenDischarge.setPadding(5.0f);
				tableGreenDischarge.addCell(cellGreenDischarge);

			}
		}		
		PdfPTable tableBrickStoneWaterReq = new PdfPTable(2);
		PdfPCell cellBrickStoneWaterReq = new PdfPCell();

		tableBrickStoneWaterReq.setWidthPercentage(100);

		cellBrickStoneWaterReq = new PdfPCell(new Paragraph(new Chunk("Water Source Type", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellBrickStoneWaterReq.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellBrickStoneWaterReq.setPadding(5.0f);
		tableBrickStoneWaterReq.addCell(cellBrickStoneWaterReq);

		cellBrickStoneWaterReq = new PdfPCell(new Paragraph(new Chunk("Quantity (KLD)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellBrickStoneWaterReq.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellBrickStoneWaterReq.setPadding(5.0f);
		tableBrickStoneWaterReq.addCell(cellBrickStoneWaterReq);
		
		
		for (int var2 = 0; var2 < stoneCrusherWaterReq.size(); var2++) {
			ArrayList al = (ArrayList) stoneCrusherWaterReq.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cellBrickStoneWaterReq = new PdfPCell(new Paragraph(a));
				cellBrickStoneWaterReq.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellBrickStoneWaterReq.setPadding(5.0f);
				tableBrickStoneWaterReq.addCell(cellBrickStoneWaterReq);

			}
		}
		
		
		PdfPTable tableBrickStoneWaterConsu = new PdfPTable(3);
		PdfPCell cellBrickStoneWaterConsu = new PdfPCell();

		tableBrickStoneWaterConsu.setWidthPercentage(100);

		cellBrickStoneWaterConsu = new PdfPCell(new Paragraph(new Chunk("Water Consumption Type", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellBrickStoneWaterConsu.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellBrickStoneWaterConsu.setPadding(5.0f);
		tableBrickStoneWaterConsu.addCell(cellBrickStoneWaterConsu);

		cellBrickStoneWaterConsu = new PdfPCell(new Paragraph(new Chunk("Quantity (KLD)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellBrickStoneWaterConsu.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellBrickStoneWaterConsu.setPadding(5.0f);
		tableBrickStoneWaterConsu.addCell(cellBrickStoneWaterConsu);
		
		cellBrickStoneWaterConsu = new PdfPCell(new Paragraph(new Chunk("Storage Facility",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
		cellBrickStoneWaterConsu.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellBrickStoneWaterConsu.setPadding(5.0f);
		tableBrickStoneWaterConsu.addCell(cellBrickStoneWaterConsu);		
		
		String check2119 = null;
		check2119 = waterConsumptionDetail.toString();

		if (check2119 == null || check2119 == "[]" || check2119.equals("[]")) {
			cellBrickStoneWaterConsu = new PdfPCell(new Paragraph(
					"-----------------NIL-----------------"));
			cellBrickStoneWaterConsu.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellBrickStoneWaterConsu.setPadding(5.0f);
			cellBrickStoneWaterConsu.setColspan(3);

			tableBrickStoneWaterConsu.addCell(cellBrickStoneWaterConsu);
		} else {
		for (int var2 = 0; var2 < waterConsumptionDetail.size(); var2++) {
			ArrayList al = (ArrayList) waterConsumptionDetail.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cellBrickStoneWaterConsu = new PdfPCell(new Paragraph(a));
				cellBrickStoneWaterConsu.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellBrickStoneWaterConsu.setPadding(5.0f);
				tableBrickStoneWaterConsu.addCell(cellBrickStoneWaterConsu);

			}
		}		
		}
		if (consentFor.equals("both") || consentFor.equals("stonecrusher")
				|| consentFor.equals("brickkilns") || consentFor.equals("hotmixplants") || consentFor.equals("stonecrusher and hotmixplants")) {

			Paragraph scheduleI = new Paragraph();
			scheduleI.add(new Chunk("SCHEDULE-I", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
			scheduleI.setAlignment(Element.ALIGN_CENTER);
			document.add(scheduleI);
			document.add(space4);

			Paragraph schedule12 = new Paragraph();
			schedule12.add(new Chunk("(Consent to Establish/Fresh)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,Font.BOLD)));
			schedule12.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule12);
			
			Paragraph schedule13 = new Paragraph();
			schedule13.add(new Chunk("(System generated as per application form)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			schedule13.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule13);			
			document.add(space4);
			
			Paragraph schedule1 = new Paragraph();
			schedule1.add(new Chunk("Common Application for Consent under", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			schedule1.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule1);

			Paragraph schedule2 = new Paragraph();
			schedule2.add(new Chunk("Water(Prevention and Control of pollution)Act,1974,", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,	Font.BOLD)));
			schedule2.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule2);

			Paragraph schedule3 = new Paragraph();
			schedule3.add(new Chunk("Air (Prevention and Control of pollution)Act,1981.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			schedule3.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule3);
			
			document.add(space4);

			Paragraph schedule4 = new Paragraph();
			schedule4.add(new Chunk("Application No. "+appID, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD)));
			schedule4.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule4);
			
			Paragraph schedule5 = new Paragraph();
			schedule5.add(new Chunk("Application For "+categoryIndustry+" Category", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			schedule5.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule5);
			
			Paragraph schedule6 = new Paragraph();
			schedule6.add(new Chunk("Line of Activity Applied for :"+certificateFor, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			schedule6.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule6);
			document.add(space4);

			Paragraph schedule31 = new Paragraph();
			schedule31.add(new Chunk("Explanatory note for filling in the e-application form for \n Consent/Authorization",	new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,Font.BOLD)));
			schedule31.setAlignment(Element.ALIGN_CENTER);
			document.add(schedule31);
			document.add(space4);

			PdfPTable table351 = new PdfPTable(2);
			table351.setWidthPercentage(100);
			float[] columnWidthsA = {0.5f,8f};
			table351.setWidths(columnWidthsA);
			PdfPCell cell351 = new PdfPCell();

			cell351 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("Any applicant knowingly giving incorrect information or suppressing any information pertaining to any of the items of the application shall be liable for punishment as per provisions under the relevant Act." ,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);		
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("The application form shall be submitted at the district offices of the Board at the address given on the first page of the application form under whose jurisdiction the applicant's activity falls. ", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("3.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("The application shall be filled online through Single Window portal https://singlewindow.jk.gov.in/ which will be further directed to jkocmms.nic.in for scrutiny and processing. The fee shall be paid once the e-application with all the requisite documents as per check list are uploaded and verified by JK PCC scrutiny section and the date of processing of application shall be considered after submission of form.The application shall be filled online through Single Window portal https://singlewindow.jk.gov.in/ which will be further directed to jkocmms.nic.in for scrutiny and processing. The fee shall be paid once the e-application with all the requisite documents as per check list are uploaded and verified by JK PCC scrutiny section and the date of processing of application shall be considered after submission of form.", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("4.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("The consent fee shall be deposited only through online mode after checking / scrutiny of documents.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);
			
			cell351 = new PdfPCell(new Paragraph(new Chunk("5.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("If any of the items is not relevant to the activity of the applicant please state Not Applicable (NA).",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);
			cell351 = new PdfPCell(new Paragraph(new Chunk("6.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("The application form shall be accompanied by relevant documents and in case of submission of online application without requisite documents, the application form shall be returned to applicant for rectification and resubmission.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);
			
			cell351 = new PdfPCell(new Paragraph(new Chunk("7.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("The applicant shall choose the Line of Activity (LOA) as per UCM strictly in accordance with the manufacturing products. In case, it is found that LOA is not matching with the Products to be manufactured, the application shall be rejected.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			
			table351.addCell(cell351);
			
			cell351 = new PdfPCell(new Paragraph(new Chunk("8.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk(capitalInvestment+" Consent fee is to be paid based on gross fixed capital investment of the unit without depreciation till the date of application. The gross capital investment shall include cost of land, building, plant and machinery without depreciation.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);
			
			cell351 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("DISCLAIMER : The mere submission of application form does not confer any right of the unit	holder for processing his case till the complete case with requisite documents as per the defined check list of Board / JK PCC shall be uploaded. Only after the scrutiny of complete form, duly verified by the JK PCC and thereafter submission of fees, the application form shall be processed as per the Environmental laws.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);			
			table351.addCell(cell351);
			
			document.add(table351);
			
			document.newPage();

			Paragraph appform = new Paragraph();
			appform.add(new Chunk("Application form ",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,
									Font.BOLD)));
			appform.setAlignment(Element.ALIGN_CENTER);
			document.add(appform);
			document.add(space4);		
			
			Paragraph from = new Paragraph();
			from.add(new Chunk("From", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			
			document.add(from);
			
			
			
			Paragraph videNo = new Paragraph();
			videNo.setAlignment(Element.ALIGN_LEFT);
			videNo.setIndentationLeft(20);
			videNo.add(new Chunk(" Industry Name:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			
			videNo.add(new Chunk(industryName + ",\n ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			
			videNo.add(new Chunk("Address:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			
			videNo.add(new Chunk(industryAddress + ",\n ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			
			videNo.add(new Chunk("Plot:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			
			videNo.add(new Chunk("District:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			videNo.add(new Chunk(industryDistrict + ", \n", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			
			videNo.add(new Chunk(industryPlot+ ", \n", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			
		
			
			videNo.add(new Chunk("Mobile::", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			videNo.add(new Chunk(industryTelephone + "\n", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			videNo.add(new Chunk("Email:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD)));
			videNo.add(new Chunk(" " + "\n", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));

			document.add(videNo);			
			
			Paragraph app11 = new Paragraph();
			app11.add(new Chunk("To", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			app11.setAlignment(Element.ALIGN_LEFT);
			document.add(app11);

			Paragraph memberS1a = new Paragraph();
			memberS1a.add(new Chunk("Member Secretary,", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			memberS1a.setIndentationLeft(20);
			document.add(memberS1a);

			Paragraph member1a = new Paragraph();
			member1a.add(new Chunk("J&K Pollution Control Committee,",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			member1a.setIndentationLeft(20);
			document.add(member1a);

			Paragraph memberc1a = new Paragraph();
			memberc1a.add(new Chunk("Jammu/Kashmir", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			memberc1a.setIndentationLeft(20);
			document.add(memberc1a);

			Paragraph sir1 = new Paragraph();
			sir1.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			sir1.setAlignment(Element.ALIGN_LEFT);
			document.add(sir1);
			document.add(space4);

			Paragraph sir = new Paragraph();
			sir.add(new Chunk("I/We hereby, apply for obtaining,", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			sir.setAlignment(Element.ALIGN_LEFT);
			document.add(sir);
			document.add(space4);

			Paragraph sir11 = new Paragraph();
			sir11.add(new Chunk("I. Consent to establish/operate/Renewal of consent under section 25 and 26 of the water (Prevention and Control of pollution)Act,1974, as amended.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			sir11.setAlignment(Element.ALIGN_LEFT);
			document.add(sir11);
			document.add(space4);

			Paragraph sira11 = new Paragraph();
			sira11.add(new Chunk("II. Consent to establish/operate/Renewal of consent under section 21 of the Air (Prevention and Control of pollution)Act,1981, as amended.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			sira11.setAlignment(Element.ALIGN_LEFT);
			document.add(sira11);
			document.add(space4);

			Paragraph sirb11 = new Paragraph();
			sirb11.add(new Chunk("III. Authorization/renewal of authorization under rule 5 of the Hazardous Wastes (management and Handling)Rules, 1989, as amended in connection with my/our existing/proposed/altered/additional manufacturing/processing activity from the premises as per the details given below. ", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			sirb11.setAlignment(Element.ALIGN_LEFT);
			document.add(sirb11);

			document.add(space4);

			if ((categoryIndustry.equals("RED") ||categoryIndustry.equals("ORANGE")) && (consentFor.equals("both")))
					{			
			Paragraph tick12 = new Paragraph();
			tick12.add(new Chunk("PART-A: GENERAL:", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 2, Font.BOLD)));
			tick12.setAlignment(Element.ALIGN_LEFT);
			document.add(tick12);
			document.add(space4);

			PdfPTable table11 = new PdfPTable(2);
			table11.setWidthPercentage(100);
			PdfPCell cell11 = new PdfPCell();

			cell11 = new PdfPCell(
					new Paragraph(new Chunk("1.  (a) Name and location of the industrial unit."	+ "", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);		
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":" + industryName
					+ ",\n Address:" +industryAddress  + ",\n Plot: " + industryPlot + ",\n City: "
					+ industryCity + ",\n Block: " + industryTehsil + ",\n District "
					+ industryDistrict + ",\n Telephone: " + industryTelephone, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);
			
			cell11 = new PdfPCell(
					new Paragraph(new Chunk("   (b) Name of Directors/Partners with contact details.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":"
					+ nameAddressPartners, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);		
			table11.addCell(cell11);
					
			cell11 = new PdfPCell(
					new Paragraph(new Chunk("  (c) Name & Address of the Occupier/Applicant.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":" + occupierName
					+ ",\n Designation: " + occupierDesignation + ",\n Address: " + occupierAddress
					+ ",\n City: " + occCity + ",\n Block: " + occupierTehsil + ",\n District: "
					+ occupierDistrict + ", \n Telephone: " + occupierTelephone, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);
			
			cell11 = new PdfPCell(new Paragraph(new Chunk("2. Details of the planning permission/Licenced issuing authority obtained from the local body/Town Planning Department, Srinagar/Jammu, Development Authority, Srinagar/Jammu, Municipality/Town Area Committee/Notified Area Committee/Block/Revenue Authority, Valid license from Concerned Tehsildar etc.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":" + regAuthority,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("3. (a) Are you registered as a Small/Medium/Large Scale industrial unit.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": " + industryScale,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"   (b) If yes, give the number and date of registration.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": "
					+ registrationNumber + ", " + b2, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("4. Gross capital investment of the unit without Depreciation till the date of application(Cost of building, land, plant and machinery).", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					": Cost of Project = "
							+ capitalInvestment + "Lakhs)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("(To be supported by Affidavit, Project/Annual Report or certificate from a Charted Accountant. For proposed unit(s), give estimsted figure):", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("5. If the site is located near river bank/other water bodies: indicate the distance and the name of the water body, if any.", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":" + nearRiver
					+ "\n" + riverName + "\n" + riverDist + " Meters",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);			
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("6. Does the location satisfy the requirments under relevant Central/State Govt. notifications such as Notification on Ecologically Fragile/Sensitive Areas (Reserved Areas), Indusrial location policy, etc. if so,give details.", new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"7. If the unit is situated in notified industrial estate,",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (a) Whether effluent collection, treatment and disposal system has been provided by the authority.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					":" + disposalSysProv, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (b) Will the applicant utilize the system, if provided:",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":" + utilizeSys,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"   (c) If not provided, details of proposed arrangement:",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					":" + proposalDetails, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"8. Total plot area, building area and area available for the use of treated sewage/trade effluent.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									": Total Plot Area= "
											+ totalPlotArea
											+ " square meter, Build-up Area= "
											+ plotArea
											+ " square meter & Area used for Treated Sewage/Trade Effluent= "
											+ builtUpArea + "square meter",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"9. Month and year of proposed commissioning the unit:",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": " + commMonth
					+ "/" + dtOfCommissioning, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"10. Number of workers and office staff:",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					": Number of workers= " + expNoEmp
							+ " & Number of Office Staff= " + noOfEmp,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"11. (a) Do you have a residential colony within the permises in respect of which the present application is made:",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": " + nearResidCol,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"   (b) if yes, please state population staying",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": " + colPopulation,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (c) Indicate its location and distance with reference to plant site.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": " + colLocation
					+ " " + colDistance, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			
			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"12. List of raw material and process chemicals with annual consumption corresponding to above stated production figures, in tones/month or Kl/month or numbers/month.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": "
					+ rawMaterialString, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"13. List of products and by-products manufactured with installed production capacity & unit).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setColspan(2);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			cell11.addElement(table23);
			table11.addCell(cell11);

			
			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"14. Description of process of manufacture for each of the products showing input, output, quality and quantity of solid, liquid and gaseous wastes, if any from each unit process.(To be supported by flow sheet and/or material balance and water balance sheet)",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(": (See enclousers)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
			cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell11.setPadding(3.0f);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);
			
			document.add(table11);

			}
		}

		/***********************GARIMA CODE*************START*****/
				
		if (((categoryIndustry.equals("GREEN"))&&(consentFor.equals("brickkilns")||consentFor.equals("stonecrusher")||consentFor.equals("both")||consentFor.equals("hotmixplants")||consentFor.equals("stonecrusher and hotmixplants"))) || 
				((categoryIndustry.equals("RED"))&&(consentFor.equals("brickkilns")||consentFor.equals("stonecrusher")||consentFor.equals("hotmixplants")||consentFor.equals("stonecrusher and hotmixplants"))) || 
				((categoryIndustry.equals("ORANGE"))&&(consentFor.equals("brickkilns")||consentFor.equals("stonecrusher")||consentFor.equals("hotmixplants")||consentFor.equals("stonecrusher and hotmixplants")))) {
		
		Paragraph tick12 = new Paragraph();
		tick12.add(new Chunk("PART-A: GENERAL:", new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 2, Font.BOLD)));
		tick12.setAlignment(Element.ALIGN_LEFT);
		document.add(tick12);
		document.add(space4);

		PdfPTable table119 = new PdfPTable(2);
		table119.setWidthPercentage(100);
	
	
	
		PdfPCell cell119 = new PdfPCell();
		
	
	
		
		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"1.(a) Name and location of the industrial unit."
										+ "", new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);
		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(":" + industryName
								+ ",\n Address:" +industryAddress  + ",\n Plot: " + industryPlot + ",\n City: "
								+ industryCity + ",\n Block: " + industryTehsil + ",\n District "
								+ industryDistrict + ",\n Telephone: " + industryTelephone, new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"   (b) Name of Directors/Partners with contact details.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(":"
				+ nameAddressPartners, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);
				
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"   (c) Name & Address of the Occupier/Applicant.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(":" + occupierName
				+ ",\n Designation: " + occupierDesignation + ",\n Address: " + occupierAddress
				+ ",\n City: " + occCity + ",\n Block: " + occupierTehsil + ",\n District: "
				+ occupierDistrict + ", \n Telephone: " + occupierTelephone, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);
		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"   (d) If the unit is situated in notified industrial estate or outside industrial estate",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"2. Details of the planning permission/Licenced issuing authority obtained from the local body/Town Planning Department, Srinagar/Jammu, Development Authority, Srinagar/Jammu, Municipality/Town Area Committee/Notified Area Committee/Block/Revenue Authority, Valid license from Concerned Tehsildar etc.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(":" + regAuthority,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"3. (a) Are you registered as a Small/Medium/Large Scale industrial unit.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": " + industryScale,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(
				"   (b) If yes, give the number and date of registration.",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": "
				+ registrationNumber + ", " + b2, new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"4. Gross capital investment of the unit without Depreciation till the date of application(Cost of building, land, plant and machinery).",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(
				"Cost of Project = "
						+ capitalInvestment + "Lakhs)", new Font(
						Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"(To be supported by Affidavit, Project/Annual Report or certificate from a Charted Accountant. For proposed unit(s), give estimsted figure):",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);
		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"5. Total plot area, building area and area available for the use of treated sewage/trade effluent.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								": Total Plot Area= "
										+ totalPlotArea
										+ " square meter, Build-up Area= "
										+ plotArea
										+ " square meter & Area used for Treated Sewage/Trade Effluent= "
										+ builtUpArea + "square meter",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(
				"6. Month and year of proposed commissioning the unit:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": " + commMonth
				+ "/" + dtOfCommissioning, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(
				"7. Number of workers and office staff:",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(
				": Number of workers= " + expNoEmp
						+ " & Number of Office Staff= " + noOfEmp,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"8. (a) Do you have a residential colony within the permises in respect of which the present application is made:",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": " + nearResidCol,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(
				"   (b) if yes, please state population staying",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": " + colPopulation,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"   (c) Indicate its location and distance with reference to plant site.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": " + colLocation
				+ " " + colDistance, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);
		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"9. List of raw material and process chemicals with annual consumption corresponding to above stated production figures, in tones/month or Kl/month or numbers/month.",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": "
				+ rawMaterialString, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"10. List of products and by-products manufactured with installed production capacity & unit).",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		
		cell119 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setColspan(2);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		cell119.addElement(table23);
		table119.addCell(cell119);

		
		cell119 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"11. Description of process of manufacture for each of the ptoducts showing input, output, quality and quantity of solid, liquid and gaseous wastes, if any from each unit process.(To be supported by flow sheet and/or material balance and water balance sheet)",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);

		cell119 = new PdfPCell(new Paragraph(new Chunk(": (See enclousers)",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell119.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell119.setVerticalAlignment(Element.ALIGN_CENTER);
		cell119.setPadding(3.0f);
		cell119.setBorder(PdfPCell.NO_BORDER);
		cell119.setBorderColor(new Color(0, 0, 0));
		table119.addCell(cell119);
		
		document.add(table119);
		
		}
		
		if (categoryIndustry.equals("GREEN") && consentFor.equals("both")){
			
			PdfPTable table110 = new PdfPTable(2);
			table110.setWidthPercentage(100);
			PdfPCell cell110 = new PdfPCell();
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"12. Water Uses Requirment",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(" ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		cell110.addElement(tableGreenUsage);
		table110.addCell(cell110);
			
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"13. Waste Water Discharge",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(" ",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.addElement(tableGreenDischarge);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"14. Pollution Control Measures (For Water Pollution Control)",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(": "+controlMeasures,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);		
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"15. D.G set installed",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(": "+dgStInstalled,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"(a) D.G. set Capacity (in KVA)",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(": "+dgSetCapacity,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"(b) Acoastic Enclosure",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(": "+AcausticEnclosure,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
				
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"16. Boiler Details",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		PdfPTable table26 = new PdfPTable(6);

		PdfPCell cell26 = new PdfPCell();

		table26.setWidthPercentage(100);

		cell26 = new PdfPCell(new Paragraph(
				new Chunk("(a) Boiler Installed", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell26.setPadding(5.0f);
		table26.addCell(cell26);

		cell26 = new PdfPCell(new Paragraph(
				new Chunk("(b) Boiler Name", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell26.setPadding(5.0f);
		table26.addCell(cell26);

		cell26 = new PdfPCell(new Paragraph(
				new Chunk("(c) Steam Generation Capacity (in Ton/hr)", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell26.setPadding(5.0f);
		table26.addCell(cell26);

		cell26 = new PdfPCell(new Paragraph(
				new Chunk("(d) Air Pollution Control Device installed with Boiler", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell26.setPadding(5.0f);
		table26.addCell(cell26);
		
		cell26 = new PdfPCell(new Paragraph(
				new Chunk("(e) Stack Height above Ground Level", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell26.setPadding(5.0f);
		table26.addCell(cell26);
		
		cell26 = new PdfPCell(new Paragraph(
				new Chunk("(f) Sampling Platform provided", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell26.setPadding(5.0f);
		table26.addCell(cell26);

		for (int var2 = 0; var2 < boilerDetailsList.size(); var2++) {
			ArrayList al = (ArrayList) boilerDetailsList.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cell26 = new PdfPCell(new Paragraph(a));
				cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell26.setPadding(5.0f);
				table26.addCell(cell26);

			}
		}

		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.addElement(table26);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"17. Furnace Details :",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		PdfPTable table260 = new PdfPTable(8);

		PdfPCell cell260 = new PdfPCell();

		table260.setWidthPercentage(100);

		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(a) Furnace Installed", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);

		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(b) Furnace Name", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);

		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(c) Air Pollution Control Device installed with Furnace", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);

		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(d) Prescribed parameter achieved", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);
		
		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(e) Stack Height above Ground Level", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);
		
		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(f) Type of fuel", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);
		
		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(g) Quantity", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);
		
		cell260 = new PdfPCell(new Paragraph(
				new Chunk("(h) Unit", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260.setPadding(5.0f);
		table260.addCell(cell260);

		for (int var2 = 0; var2 < furnaceDetailsList.size(); var2++) {
			ArrayList al = (ArrayList) furnaceDetailsList.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cell260 = new PdfPCell(new Paragraph(a));
				cell260.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell260.setPadding(5.0f);
				table260.addCell(cell260);

			}
		}

		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.addElement(table260);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);		
				
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"18. Noise Pollution Generated             :"+noisePollution,
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

		cell110 = new PdfPCell(new Paragraph(new Chunk(" (a) Measures to contain noise pollution taken : "+ noiseMeasures+"\n (b) Prescribed parameters achieved for noise : "+presParameters,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		//		cell110 = new PdfPCell(
//				new Paragraph(
//						new Chunk(
//								"19. Hazardous substances used                :",
//								new Font(Font.TIMES_ROMAN,
//										Font.DEFAULTSIZE + 0, Font.NORMAL))));
//		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
//		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
//		cell110.setPadding(3.0f);
//		cell110.setColspan(2);
//		cell110.setBorder(PdfPCell.NO_BORDER);
//		cell110.setBorderColor(new Color(0, 0, 0));
//		table110.addCell(cell110);;

		
		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"19. Hazardous substances used :",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		
		
		PdfPTable table260a = new PdfPTable(2);

		PdfPCell cell260a = new PdfPCell();

		table260a.setWidthPercentage(100);

		cell260a = new PdfPCell(new Paragraph(
				new Chunk("Name of substances ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260a.setPadding(5.0f);
		table260a.addCell(cell260a);
		
		
		cell260a = new PdfPCell(new Paragraph(
				new Chunk("Quantity (in Tons/day) ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260a.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260a.setPadding(5.0f);
		table260a.addCell(cell260a);
		
		
		
		for (int var2 = 0; var2 < HazsubList.size(); var2++) {
			ArrayList al = (ArrayList) HazsubList.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cell260a = new PdfPCell(new Paragraph(a));
				cell260a.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell260a.setPadding(5.0f);
				table260a.addCell(cell260a);

			}
		}

		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.addElement(table260a);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);	
		
		//		cell110 = new PdfPCell(
//				new Paragraph(
//						new Chunk(
//								"20. Hazardous waste is being produced             :",
//								new Font(Font.TIMES_ROMAN,
//										Font.DEFAULTSIZE + 0, Font.NORMAL))));
//		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
//		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
//		cell110.setPadding(3.0f);
//		cell110.setColspan(2);
//		cell110.setBorder(PdfPCell.NO_BORDER);
//		cell110.setBorderColor(new Color(0, 0, 0));
//		table110.addCell(cell110);;

		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"20. Hazardous waste is being produced  :",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		
		
		PdfPTable table260ab = new PdfPTable(2);

		PdfPCell cell260ab = new PdfPCell();

		table260ab.setWidthPercentage(100);

		cell260ab = new PdfPCell(new Paragraph(
				new Chunk("Name of hazardous waste  ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260ab.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260ab.setPadding(5.0f);
		table260ab.addCell(cell260ab);
		
		
		cell260ab = new PdfPCell(new Paragraph(
				new Chunk("Quantity (in Tons/day) ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260ab.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260ab.setPadding(5.0f);
		table260ab.addCell(cell260ab);
		
		
		
		for (int var2 = 0; var2 < HazwasteList.size(); var2++) {
			ArrayList al = (ArrayList) HazwasteList.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cell260ab = new PdfPCell(new Paragraph(a));
				cell260ab.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell260ab.setPadding(5.0f);
				table260ab.addCell(cell260ab);

			}
		}

		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.addElement(table260ab);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);	
						
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"21. Total cost on pollution control (in Rupees)       :"+totalCostPoll,
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);

						

		
		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"22. Solid Waste Details :",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);
		
		
		

		PdfPTable table260ac = new PdfPTable(4);

		PdfPCell cell260ac = new PdfPCell();

		table260ac.setWidthPercentage(100);

		cell260ac = new PdfPCell(new Paragraph(
				new Chunk("Description ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260ac.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260ac.setPadding(5.0f);
		table260ac.addCell(cell260ac);
		
		
		cell260ac = new PdfPCell(new Paragraph(
				new Chunk("Quantity (in Metric Tonnes/Month)/Quality ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260ac.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260ac.setPadding(5.0f);
		table260ac.addCell(cell260ac);
		
		cell260ac = new PdfPCell(new Paragraph(
				new Chunk("Method of Treatment/Collection", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260ac.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260ac.setPadding(5.0f);
		table260ac.addCell(cell260ac);
		
		cell260ac = new PdfPCell(new Paragraph(
				new Chunk("Method of Disposal ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 2, Font.BOLD))));
		cell260ac.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell260ac.setPadding(5.0f);
		table260ac.addCell(cell260ac);
		
		
		
		for (int var2 = 0; var2 < waterSolidWasteGenDetailsInstanceFinalList.size(); var2++) {
			ArrayList al = (ArrayList) waterSolidWasteGenDetailsInstanceFinalList.get(var2);
			for (int var3 = 0; var3 < al.size(); var3++) {

				String a = (String) al.get(var3);
				cell260ac = new PdfPCell(new Paragraph(a));
				cell260ac.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell260ac.setPadding(5.0f);
				table260ac.addCell(cell260ac);

			}
		}

		cell110 = new PdfPCell(
				new Paragraph(
						new Chunk(
								"",
								new Font(Font.TIMES_ROMAN,
										Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell110.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell110.setVerticalAlignment(Element.ALIGN_CENTER);
		cell110.setPadding(3.0f);
		cell110.setColspan(2);
		cell110.addElement(table260ac);
		cell110.setBorder(PdfPCell.NO_BORDER);
		cell110.setBorderColor(new Color(0, 0, 0));
		table110.addCell(cell110);	
		
		document.add(table110);
		
				
		}
		/***********************GARIMA CODE*************END*****/
		
		if (consentFor.equals("both") && (categoryIndustry.equals("RED")||categoryIndustry.equals("ORANGE"))) {

			Paragraph partB = new Paragraph();
			partB.add(new Chunk("PART-B: Waste Water Aspects:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
			partB.setAlignment(Element.ALIGN_LEFT);
			document.add(partB);

			document.add(space4);

			PdfPTable table26 = new PdfPTable(4);

			PdfPCell cell26 = new PdfPCell();

			table26.setWidthPercentage(100);

			cell26 = new PdfPCell(new Paragraph(
					new Chunk("Type of Effluent", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell26.setPadding(5.0f);
			table26.addCell(cell26);

			cell26 = new PdfPCell(new Paragraph(
					new Chunk("Quality Parameters", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell26.setPadding(5.0f);
			table26.addCell(cell26);

			cell26 = new PdfPCell(new Paragraph(
					new Chunk("Treated Value", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell26.setPadding(5.0f);
			table26.addCell(cell26);

			cell26 = new PdfPCell(new Paragraph(
					new Chunk("Untreated Value", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell26.setPadding(5.0f);
			table26.addCell(cell26);

			
			
			
			
			
			
			
			

			String check2 = null;
			check2 = treatedEffluent.toString();
		
			if (check2 == null || check2 == "[]" || check2.equals("[]")) {
				
				cell26 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));				
				cell26.setHorizontalAlignment(Element.ALIGN_CENTER);				
				cell26.setPadding(5.0f);
				cell26.setColspan(5);

				table26.addCell(cell26);
			} else {
				
			
			for (int var2 = 0; var2 < treatedEffluent.size(); var2++) {
				ArrayList al = (ArrayList) treatedEffluent.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell26 = new PdfPCell(new Paragraph(a));
					cell26.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell26.setPadding(5.0f);
					table26.addCell(cell26);

				}
			}

			}
			PdfPTable table31 = new PdfPTable(2);
			table31.setWidthPercentage(100);
			PdfPCell cell31 = new PdfPCell();

			cell31 = new PdfPCell(new Paragraph(new Chunk(
					"15. Water Consumption for different uses(m^3/day)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			PdfPTable table1102 = new PdfPTable(3);
			PdfPCell cell1102 = new PdfPCell();
			table1102.setWidthPercentage(100);
			cell1102 = new PdfPCell(new Paragraph(
					new Chunk("Source Type", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1102.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1102.setPadding(5.0f);
			table1102.addCell(cell1102);

			cell1102 = new PdfPCell(new Paragraph(new Chunk("Uses", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1102.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1102.setPadding(5.0f);
			table1102.addCell(cell1102);

			cell1102 = new PdfPCell(new Paragraph(
					new Chunk("Quantity (KLD)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1102.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1102.setPadding(5.0f);
			table1102.addCell(cell1102);

			
			
			String check6666 = null;
			check6666 = waterModeUseDetailList.toString();

			if (check6666 == null || check6666 == "[]" || check6666.equals("[]")) {
				cell1102 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));
				cell1102.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1102.setPadding(5.0f);
				cell1102.setColspan(3);

				table1102.addCell(cell1102);
			} else {
			
			
			
			for (int var2 = 0; var2 < waterModeUseDetailList.size(); var2++) {
				ArrayList al = (ArrayList) waterModeUseDetailList.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell1102 = new PdfPCell(new Paragraph(a));
					cell1102.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1102.setPadding(5.0f);
					table1102.addCell(cell1102);

				}
			}

			}
			
			
			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setColspan(2);
			cell31.addElement(table1102);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk("Total : "
					+ waterModeQuantity + " KLD ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"16. Sources of water supply, Name of authority granting permission if applicable and quantity permitted : ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setColspan(2);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			PdfPTable table11021 = new PdfPTable(3);
			PdfPCell cell11021 = new PdfPCell();
			table11021.setWidthPercentage(100);

			cell11021 = new PdfPCell(new Paragraph(
					new Chunk("Source Type", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell11021.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11021.setPadding(5.0f);
			table11021.addCell(cell11021);

			cell11021 = new PdfPCell(new Paragraph(
					new Chunk("Source Name", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell11021.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11021.setPadding(5.0f);
			table11021.addCell(cell11021);

			cell11021 = new PdfPCell(new Paragraph(
					new Chunk("Quantity (KLD)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell11021.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11021.setPadding(5.0f);
			table11021.addCell(cell11021);

			for (int var2 = 0; var2 < waterSourceDetailsList.size(); var2++) {
				ArrayList al = (ArrayList) waterSourceDetailsList.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell11021 = new PdfPCell(new Paragraph(a));
					cell11021.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell11021.setPadding(5.0f);
					table11021.addCell(cell11021);

				}
			}

			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setColspan(2);
			cell31.addElement(table11021);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk("17. Quantity of waste (effluent) generated(m^3/day) : ",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setColspan(2);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);
			
			PdfPTable table1119 = new PdfPTable(2);
			PdfPCell cell1119 = new PdfPCell();
			table1119.setWidthPercentage(100);

			cell1119 = new PdfPCell(new Paragraph(
					new Chunk("Type of Effluent", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1119.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1119.setPadding(5.0f);
			table1119.addCell(cell1119);

			cell1119 = new PdfPCell(
					new Paragraph(new Chunk(
							"Maximum Generation Quantity of Effluent(KLD)",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));
			cell1119.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1119.setPadding(5.0f);
			table1119.addCell(cell1119);

			for (int var2 = 0; var2 < wasteWaterGenerationDetailsFinalList
					.size(); var2++) {
				ArrayList al = (ArrayList) wasteWaterGenerationDetailsFinalList
						.get(var2);
				for (int var7 = 0; var7 < al.size(); var7++) {

					String a = (String) al.get(var7);
					cell1119 = new PdfPCell(new Paragraph(a));
					cell1119.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1119.setPadding(5.0f);
					table1119.addCell(cell1119);

				}
			}
			
			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setColspan(2);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.addElement(table1119);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"18. Water budgets calculations acounting for difference between water Consumption and effluent:   ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			int difference = waterModeQuantity - totaleffluentGenerated;

			cell31 = new PdfPCell(new Paragraph(new Chunk(": " + difference
					+ " KLD ", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"19. Present treatment of sewage/canteen effluent(Give sizes/capacities of treatmenmt units) : ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setColspan(2);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			PdfPTable table25 = new PdfPTable(5);

			PdfPCell cell25 = new PdfPCell();

			table25.setWidthPercentage(100);

			cell25 = new PdfPCell(new Paragraph(
					new Chunk("Type of Effluent", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell25.setPadding(5.0f);
			table25.addCell(cell25);

			cell25 = new PdfPCell(new Paragraph(
					new Chunk("Treatment Type", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell25.setPadding(5.0f);
			table25.addCell(cell25);

			cell25 = new PdfPCell(new Paragraph(new Chunk(
					"Name of Treatment Units", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell25.setPadding(5.0f);
			table25.addCell(cell25);

			cell25 = new PdfPCell(new Paragraph(
					new Chunk("Capacity (KL)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell25.setPadding(5.0f);
			table25.addCell(cell25);

			cell25 = new PdfPCell(
					new Paragraph(new Chunk(
							"Investment in Treatment Unit (in Rs.)", new Font(
									Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));
			cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell25.setPadding(5.0f);
			table25.addCell(cell25);

			
			
			String check4112 = null;
			check4112 = treatmentDetails.toString();

			if (check4112 == null || check4112 == "[]" || check4112.equals("[]")) {
				cell25 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));
				cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell25.setPadding(5.0f);
				cell25.setColspan(5);

				table25.addCell(cell25);
			} else {
			
			
			for (int var2 = 0; var2 < treatmentDetails.size(); var2++) {
				ArrayList al = (ArrayList) treatmentDetails.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell25 = new PdfPCell(new Paragraph(a));
					cell25.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell25.setPadding(5.0f);
					table25.addCell(cell25);

				}
			}
			}
			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setColspan(2);
			cell31.addElement(table25);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"20. Present treatment of trade effluent (Give sizes/capacities of treatment units). (A schematic diagram of the treatment scheme with inlet/outlet characteristyics of each unit operation/process is to be provided. Include details of residue management system(ETP sludges).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setColspan(2);
			cell31.addElement(table25);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(
					"21. (a) Are sewages and trade effluents mixed together?",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(": " + sewage,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (b) If yes, state at which stage whether before, intermittenly or after treatment",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(": " + sewageState,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(
					"22. Capacity of treated effluent sump, Gaurd Pond if any",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(": "
					+ treatedEffCapacity, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk("23. Mode of Disposal of treated effluents, with effective quantity, m^3/day : ",new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setColspan(2);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			PdfPTable table111 = new PdfPTable(5);
			PdfPCell cell111 = new PdfPCell();
			table111.setWidthPercentage(100);

			cell111 = new PdfPCell(new Paragraph(
					new Chunk("Type of Effluent", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111.setPadding(5.0f);
			table111.addCell(cell111);

			cell111 = new PdfPCell(new Paragraph(new Chunk("Maximum Generation Quantity of Effluent(KLD)",new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));
			cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111.setPadding(5.0f);
			table111.addCell(cell111);

			cell111 = new PdfPCell(new Paragraph(new Chunk(
					"Effluent Recycle(KLD)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111.setPadding(5.0f);
			table111.addCell(cell111);

			cell111 = new PdfPCell(new Paragraph(
					new Chunk("Mode of Disposal", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111.setPadding(4.0f);
			table111.addCell(cell111);

			cell111 = new PdfPCell(
					new Paragraph(new Chunk(
							"Effluent Disposal/Discharge Quantity (KLD)",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));
			cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111.setPadding(5.0f);
			table111.addCell(cell111);

			String check41 = null;
			check41 = wasteWaterGenerationDetailsFinalList1.toString();

			if (check41 == null || check41 == "[]" || check41.equals("[]")) {
				cell111 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));
				cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell111.setPadding(5.0f);
				cell111.setColspan(5);
				table111.addCell(cell111);
			} else { 
			for (int var2 = 0; var2 < wasteWaterGenerationDetailsFinalList1.size(); var2++) {
				ArrayList al = (ArrayList) wasteWaterGenerationDetailsFinalList1.get(var2);
				for (int var7 = 0; var7 < al.size(); var7++) {
					String a = (String) al.get(var7);
					cell111 = new PdfPCell(new Paragraph(a));
					cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell111.setPadding(5.0f);
					table111.addCell(cell111);
				}
			}
			}
			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setColspan(2);
			cell31.addElement(table111);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Provide, a location map of disposal arrangement indicating the outlets for sampling.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(": (See Enclosures)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"24. (a) Quality of untreated/treated effluents specify pH and concentration of SS, BOD, COD and specific pollutants relevant to the industry. (TDS to be reported for disposal on land or into stream/river) : ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setColspan(2);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setColspan(2);
			cell31.setBorderColor(new Color(0, 0, 0));
			cell31.addElement(table26);
			table31.addCell(cell31);

			cell31 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (b) Enclose a copy of the latest report of analysis from the laboratory approved by the state Board/Committee/Central Board/Central Government in the Ministry of Environment & Forests. For proposed unit untreated/treated effluent.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			cell31 = new PdfPCell(new Paragraph(new Chunk(": (See Enclosures)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell31.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell31.setPadding(3.0f);
			cell31.setVerticalAlignment(Element.ALIGN_CENTER);
			cell31.setBorder(PdfPCell.NO_BORDER);
			cell31.setBorderColor(new Color(0, 0, 0));
			table31.addCell(cell31);

			document.add(table31);

			document.newPage();

			Paragraph partC = new Paragraph();
			partC.add(new Chunk("PART-C: Air Emission Aspects:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
			partC.setAlignment(Element.ALIGN_LEFT);
			document.add(partC);
			document.add(space4);

			PdfPTable table30 = new PdfPTable(2);
			table30.setWidthPercentage(100);
			PdfPCell cell30 = new PdfPCell();

			cell30 = new PdfPCell(new Paragraph(new Chunk(
					"25. Fuel Consumption : ", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.NORMAL, new Color(0, 0,
									0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setColspan(2);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			PdfPTable table2610 = new PdfPTable(7);
			PdfPCell cell2610 = new PdfPCell();
			table2610.setWidthPercentage(100);

			cell2610 = new PdfPCell(new Paragraph(
					new Chunk("Fuel Name", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);

			cell2610 = new PdfPCell(new Paragraph(
					new Chunk("Fuel Consumption", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);

			cell2610 = new PdfPCell(new Paragraph(new Chunk("Unit", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);

			cell2610 = new PdfPCell(new Paragraph(
					new Chunk("Calorific Value", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);

			cell2610 = new PdfPCell(new Paragraph(
					new Chunk("Ash Content %", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);

			cell2610 = new PdfPCell(new Paragraph(new Chunk(
					"Sulphur Content %", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);

			cell2610 = new PdfPCell(new Paragraph(new Chunk("Other", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2610.setPadding(5.0f);
			table2610.addCell(cell2610);
			
			String check411 = null;
			check411 = airFlueGasEmissionDetails.toString();

			if (check411 == null || check411 == "[]" || check411.equals("[]")) {
				cell2610 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));
				cell2610.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2610.setPadding(5.0f);
				cell2610.setColspan(7);

				table2610.addCell(cell2610);
			} else {
			for (int var2 = 0; var2 < airFlueGasEmissionDetails.size(); var2++) {
				ArrayList al = (ArrayList) airFlueGasEmissionDetails.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell2610 = new PdfPCell(new Paragraph(a));
					cell2610.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell2610.setPadding(5.0f);
					table2610.addCell(cell2610);
				}
			}
			}
			cell30 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setColspan(2);
			cell30.addElement(table2610);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(new Paragraph(new Chunk(
					"26. (A) Details of stacks(process & fuel stacks) : ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setColspan(2);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			Paragraph stack1 = new Paragraph();
			stack1.add(new Chunk("     a) Stack numbers:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph attach = new Paragraph();
			attach.add(new Chunk("     b) Attached to:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph capa = new Paragraph();
			capa.add(new Chunk("     c) Capacity:", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));

			Paragraph fue = new Paragraph();
			fue.add(new Chunk("     d) Fuel type:", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE)));

			Paragraph fueQuan = new Paragraph();
			fueQuan.add(new Chunk("     e) Fuel quantity (TP/KLD) :", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph mate = new Paragraph();
			mate.add(new Chunk("     f) Material of construction :", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph shape1 = new Paragraph();
			shape1.add(new Chunk("     g) Shape (round/rectangular) :",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph height = new Paragraph();
			height.add(new Chunk("     h) Height (In Meters):", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph height1 = new Paragraph();
			height1.add(new Chunk(
					"         i) Above Ground Level(In Meters) :", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph height2 = new Paragraph();
			height2.add(new Chunk(
					"        ii) Above Factory Room(In Meters) :", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph dia = new Paragraph();
			dia.add(new Chunk("     i) Diameter/Size, (In Meters) :", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph gasQuan = new Paragraph();
			gasQuan.add(new Chunk("     j) Gas quantity, Nm3/hr :", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph gasTemp1 = new Paragraph();
			gasTemp1.add(new Chunk("     k) Gas temperature, *C :", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE)));

			Paragraph exitGas = new Paragraph();
			exitGas.add(new Chunk("     l) Exit gas velocity, m/sec :",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE)));
			document.add(space4);

			PdfPTable table = new PdfPTable(2);
			PdfPCell cell = new PdfPCell();
			table.setWidthPercentage(100);

			cell = new PdfPCell(stack1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + numberStacks));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(attach);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + stack));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(capa);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + capacity));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(fue);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + fuelTyp));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(fueQuan);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + fuelQty));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(mate);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + materialConstruction));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(shape1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + shape));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(height);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph());
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(height1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + aboveGroundHeight));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(height2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + aboveFactHeight));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(dia);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + diamSize));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(gasQuan);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + gasQty));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(gasTemp1);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + gasTemp));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(exitGas);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(" " + gasVel));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(
					"    (m) Control equipment preceding the stack "));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph(":"));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			PdfPTable table2 = new PdfPTable(2);
			PdfPCell cell2 = new PdfPCell();
			table2.setWidthPercentage(100);

			cell2 = new PdfPCell(new Paragraph(
					new Chunk("Plant Name", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(5.0f);
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(
					new Chunk("Control Equipment", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(5.0f);
			table2.addCell(cell2);
			
			for (int var2 = 0; var2 < plantEquipmentDetails.size(); var2++) {
				ArrayList al = (ArrayList) plantEquipmentDetails.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell2 = new PdfPCell(new Paragraph(a));
					cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell2.setPadding(5.0f);
					table2.addCell(cell2);

				}
			}

			cell = new PdfPCell(new Paragraph(":"));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPadding(5.0f);
			cell.setColspan(2);
			cell.addElement(table2);
			cell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(cell);

			cell30 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setColspan(2);
			cell30.addElement(table);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"(Attach specifications including residue management systems of each of the control equipment indicating inlet/outlet concentrations of relevent pollutants).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(new Paragraph(new Chunk(": (See Enclosures)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (B) Whether any release of odoriferous compounds such as Mercaptans, Phorate etc. are coming out. ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(new Paragraph(new Chunk(": " + odorCompounds,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"27. Do you have adeqate facility for collection of samples of emissions in the form of port holes, platform, ladder etc. as per Central Board Publication Emission Regulations part-III(December 1985)",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(new Paragraph(new Chunk(": " + facility,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"28. Quality of treated flue gas emissions and process emissions and process emissions(Specify concentration of criteria pollutants and industry/process-specific pollutants stack-wise. Enclose a copy of the latest report of analysis from the approved laboratory by State Board/Central Board/Central Government in the Ministry of Environment and Forests. For proposed units furnish the expected characteristics of the emissions.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			cell30 = new PdfPCell(new Paragraph(new Chunk(": " + quality
					+ "\n\n  (See Enclosures)", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL, new Color(0, 0, 0)))));
			cell30.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell30.setPadding(3.0f);
			cell30.setVerticalAlignment(Element.ALIGN_CENTER);
			cell30.setBorder(PdfPCell.NO_BORDER);
			cell30.setBorderColor(new Color(0, 0, 0));
			table30.addCell(cell30);

			document.add(table30);

			document.newPage();

			Paragraph partD = new Paragraph();
			partD.add(new Chunk("PART-D: Hazardous Waste Aspects:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
			partD.setAlignment(Element.ALIGN_LEFT);
			document.add(partD);
			document.add(space4);

			PdfPTable table32 = new PdfPTable(2);
			table32.setWidthPercentage(100);
			PdfPCell cell32 = new PdfPCell();

			cell32 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"29. Whether the unit is generating hazardous waste as defined in the Hazardous Waste(Management and handling)Rules, 1989, as amended.  ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(": " + possibilityOfRecovery,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"30. Quantity of hazardous waste generated(kg/day) or (mt/month).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(":  ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			PdfPTable table125 = new PdfPTable(4);
			table125.setWidthPercentage(100);
			PdfPCell cell125 = new PdfPCell();

			cell125 = new PdfPCell(
					new Paragraph(new Chunk(
							"Source of Generation of Hazardous Waste",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));
			cell125.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);

			cell125.setBorderColor(new Color(0, 0, 0));
			table125.addCell(cell125);

			cell125 = new PdfPCell(new Paragraph(new Chunk(
					"Name of Hazardous Waste", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell125.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);

			cell125.setBorderColor(new Color(0, 0, 0));
			table125.addCell(cell125);

			cell125 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Category under which the Hazardous Waste is covered",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell125.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);

			cell125.setBorderColor(new Color(0, 0, 0));
			table125.addCell(cell125);

			cell125 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Quantity of Hazardous Waste generate/to be generated per day(in TPD)",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell125.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell125.setVerticalAlignment(Element.ALIGN_CENTER);
			cell125.setBorderColor(new Color(0, 0, 0));
			table125.addCell(cell125);
			
			String check39 = null;
			check39 = hazardousGenDetails.toString();	
			System.out.println("zzzzzzzzzzzz"+check39);
			if (check39 == null || check39 == "[]" || check39.equals("[]")) {				
				cell125 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));				
				cell125.setHorizontalAlignment(Element.ALIGN_CENTER);				
				cell125.setPadding(5.0f);
				cell125.setColspan(4);

				table125.addCell(cell125);
			} 
			else{				
			for (int var2 = 0; var2 < hazardousGenDetails.size(); var2++) {				
				ArrayList al = (ArrayList) hazardousGenDetails.get(var2);				
				for (int var7 = 0; var7 < al.size(); var7++) {
					String a = (String) al.get(var7);					
					cell125 = new PdfPCell(new Paragraph(a));									
					cell125.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell125.setPadding(5.0f);
					table125.addCell(cell125);
				}}}

			cell32 = new PdfPCell(new Paragraph(new Chunk(":  ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setColspan(2);
			cell32.addElement(table125);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(
					"31. Authorization required for", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell32.setPadding(3.0f);			
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(": " +authForList,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			
			
			table32.addCell(cell32);
			
			
			
			
			cell32 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"32. Characteristics of the hazardous waste(s).(Specify concentration of relevent pollutants. Enclose a copy of the latest report of analysis from the laboratory approved by state Board/Central Board/Central Government in the Ministry of Environment and Forest). For proposed units furnish expected characteristics.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(": (See Enclosures)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"33. Mode of storage (intermediate or final)(describe area, location and methodology).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(":  ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			PdfPTable table27 = new PdfPTable(4);
			table27.setWidthPercentage(100);
			PdfPCell cell27 = new PdfPCell();

			cell27 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Name of the Hazardous Waste generated/to be ganerated",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell27.setHorizontalAlignment(Element.ALIGN_LEFT);		
			cell27.setVerticalAlignment(Element.ALIGN_CENTER);
			cell27.setBorderColor(new Color(0, 0, 0));
			table27.addCell(cell27);

			cell27 = new PdfPCell(new Paragraph(new Chunk(
					"Catogary of Hazardous Waste", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell27.setVerticalAlignment(Element.ALIGN_CENTER);	
			cell27.setBorderColor(new Color(0, 0, 0));
			table27.addCell(cell27);

			cell27 = new PdfPCell(
					new Paragraph(new Chunk("Size of the Room/shed(in mts.)",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));
			cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell27.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell27.setBorderColor(new Color(0, 0, 0));
			table27.addCell(cell27);

			cell27 = new PdfPCell(new Paragraph(new Chunk("Storage Capacity(in terms of months)", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,Font.BOLD))));
			cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell27.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell27.setBorderColor(new Color(0, 0, 0));
			table27.addCell(cell27);
			
			String check351 = null;
			check351 = hazardousStorageDetails1.toString();			
			if (check351 == null || check351 == "[]" || check351.equals("[]")) {				
				cell27 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));				
				cell27.setHorizontalAlignment(Element.ALIGN_CENTER);				
				cell27.setPadding(5.0f);
				cell27.setColspan(4);
				table27.addCell(cell27);
			} else {
			for (int var2 = 0; var2 < hazardousStorageDetails1.size(); var2++) {
				ArrayList al = (ArrayList) hazardousStorageDetails1.get(var2);
				for (int var7 = 0; var7 < al.size(); var7++) {
					String a = (String) al.get(var7);					
					cell27 = new PdfPCell(new Paragraph(a));
					cell27.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell27.setPadding(5.0f);				
					table27.addCell(cell27);
				}}}
			cell32 = new PdfPCell(new Paragraph(new Chunk("", new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setColspan(2);
			cell32.addElement(table27);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk("34. Present treatment of hazardous Waste, if any(give type and capacity of treatment units).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL,
											new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(": "+present+"\n\n"+presentdetails, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL, new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(
					"35. Quantity of Hazardous wate disposed", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL, new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			cell32 = new PdfPCell(new Paragraph(new Chunk(":  ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);

			
			PdfPTable table2619 = new PdfPTable(3);
			table2619.setWidthPercentage(100);
			PdfPCell cell2619 = new PdfPCell();
			
			
			cell2619 = new PdfPCell(new Paragraph(new Chunk("Mode of Disposal",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2619.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2619.setVerticalAlignment(Element.ALIGN_CENTER);		
			cell2619.setBorder(PdfPCell.NO_BORDER);
			cell2619.setBorderColor(new Color(0, 0, 0));
			cell2619.setColspan(3);
			table2619.addCell(cell2619);
			
			cell2619 = new PdfPCell(new Paragraph(new Chunk("Quantity of hazardous waste shifted/to be shifted to common TSDF",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2619.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell2619.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell2619.setBorderColor(new Color(0, 0, 0));
			table2619.addCell(cell2619);

			cell2619 = new PdfPCell(new Paragraph(new Chunk("Quantity of hazardous waste given/to be given to regd. Recycler",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2619.setHorizontalAlignment(Element.ALIGN_LEFT);			
			cell2619.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell2619.setBorderColor(new Color(0, 0, 0));
			table2619.addCell(cell2619);

			cell2619 = new PdfPCell(new Paragraph(new Chunk("Quantity of hazardous waste being/to be managed in the premises",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2619.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2619.setVerticalAlignment(Element.ALIGN_CENTER);		
			cell2619.setBorderColor(new Color(0, 0, 0));
			table2619.addCell(cell2619);				
			
			PdfPTable table261 = new PdfPTable(7);
			table261.setWidthPercentage(100);
			PdfPCell cell261 = new PdfPCell();

			cell261 = new PdfPCell(new Paragraph(new Chunk("Name of the Hazardous Waste generated/to be generated",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell261.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell261.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell261.setBorderColor(new Color(0, 0, 0));
			table261.addCell(cell261);

			cell261 = new PdfPCell(new Paragraph(new Chunk("Nature of Hazardous Waste(recyclable/incinerable/storagable)",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell261.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell261.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell261.setBorderColor(new Color(0, 0, 0));
			table261.addCell(cell261);

			cell261 = new PdfPCell(new Paragraph(new Chunk("Category of Hazardous Waste", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell261.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell261.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell261.setBorderColor(new Color(0, 0, 0));
			table261.addCell(cell261);

			cell261 = new PdfPCell(new Paragraph(new Chunk("Total Quantity of Hazardous Waste generated/to be generated(in tones/annum)",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell261.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell261.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell261.setBorderColor(new Color(0, 0, 0));
			table261.addCell(cell261);

			cell261 = new PdfPCell(new Paragraph(
					new Chunk("", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell261.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell261.setVerticalAlignment(Element.ALIGN_CENTER);			
			cell261.setColspan(3);
			cell261.addElement(table2619);
			cell261.setBorderColor(new Color(0, 0, 0));
			table261.addCell(cell261);
			
			String check35 = null;
			check35 = hazardousDisposalDetails1.toString();			
			if (check35 == null || check35 == "[]" || check35.equals("[]")) {				
				cell261 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));				
				cell261.setHorizontalAlignment(Element.ALIGN_CENTER);				
				cell261.setPadding(5.0f);
				cell261.setColspan(7);
				table261.addCell(cell261);
			} else {
			for (int var2 = 0; var2 < hazardousDisposalDetails1.size(); var2++) {
				ArrayList al = (ArrayList) hazardousDisposalDetails1.get(var2);
				for (int var7 = 0; var7 < al.size(); var7++) {

					String a = (String) al.get(var7);
					cell261 = new PdfPCell(new Paragraph(a));
					cell261.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell261.setPadding(5.0f);
					table261.addCell(cell261);
				}}}
			
			cell32 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL,
					new Color(0, 0, 0)))));
			cell32.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell32.setPadding(3.0f);
			cell32.setVerticalAlignment(Element.ALIGN_CENTER);
			cell32.setColspan(2);
			cell32.addElement(table261);
			cell32.setBorder(PdfPCell.NO_BORDER);
			cell32.setBorderColor(new Color(0, 0, 0));
			table32.addCell(cell32);
			document.add(table32);
			document.newPage();
			Paragraph partE = new Paragraph();
			partE.add(new Chunk("PART-E: Additional Information:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2, Font.BOLD)));
			partE.setAlignment(Element.ALIGN_LEFT);
			document.add(partE);
			document.add(space4);

			PdfPTable table33 = new PdfPTable(2);
			table33.setWidthPercentage(100);
			PdfPCell cell33 = new PdfPCell();

			cell33 = new PdfPCell(new Paragraph(new Chunk("36. (a) Do you have any proposals to upgrade the present system for treatment and disposal of effluent/emissions and/or hazardous waste.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk("    (b) If yes, give the details with time-schedule for the implementation and approximate expenditure to be incurred on it.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(
					"37. Estimated Cost of Pollution Control:--",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);		
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(
					"   (1) Total Project Cost", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": "
					+ totalProjectCost + " Rs.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(
					"   (2) Expenditure Details", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			PdfPTable table1118 = new PdfPTable(3);
			PdfPCell cell1118 = new PdfPCell();
			table1118.setWidthPercentage(100);

			cell1118 = new PdfPCell(new Paragraph(new Chunk(
					"Expenditure Proposed For", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1118.setPadding(5.0f);
			table1118.addCell(cell1118);

			cell1118 = new PdfPCell(new Paragraph(
					new Chunk("Capital (Rs.)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1118.setPadding(4.0f);
			table1118.addCell(cell1118);

			cell1118 = new PdfPCell(new Paragraph(
					new Chunk("Recurring (Rs.)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1118.setPadding(5.0f);
			table1118.addCell(cell1118);

			String check11 = null;
			check11 = indExpenditureCostDetailsInstanceFinalList.toString();
		
			if (check11 == null || check11 == "[]" || check11.equals("[]")) {
				
				cell1118 = new PdfPCell(new Paragraph(
						"-----------------NIL-----------------"));
				cell1118.setHorizontalAlignment(Element.ALIGN_CENTER);				
				cell1118.setPadding(5.0f);
				cell1118.setColspan(3);
				table1118.addCell(cell1118);
			} else {
			
			for (int var2 = 0; var2 < indExpenditureCostDetailsInstanceFinalList
					.size(); var2++) {
				ArrayList al = (ArrayList) indExpenditureCostDetailsInstanceFinalList
						.get(var2);
				for (int var7 = 0; var7 < al.size(); var7++) {

					String a = (String) al.get(var7);
					cell1118 = new PdfPCell(new Paragraph(a));
					cell1118.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell1118.setPadding(5.0f);
					table1118.addCell(cell1118);

				}
			}

			}
			cell33 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);			
			cell33.setColspan(2);
			cell33.addElement(table1118);
			cell33.setBorder(PdfPCell.NO_BORDER);
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk("   (3) Total Capital Investment proposed on Pollution/Env. Protection as a %age of total Investment of Industry",new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": "
					+ pollutionMonitoringCost + " Rs.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk("38. To which of the pollution control Equipments, separate meters for recording consumption of electric energy are installed?",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": "
					+ equipWithSepMeters, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk("39. Which of the pollution control items are connected to D.G set(capative power source) to ensure their running inthe event of normal failure?",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + equipDGSet,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk("40. Nature, quantity and method of disposal of non-hazardous solid waste generated separately from the process of manufacture and waste treatment.(Give details of area/capacity available in applicants land).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": Name: "
					+ nonHwmProdName + ", Area (in meters): " + landArea
					+ ", Capacity: " + prodCapacity, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"41. Hazardous Chemicals-Give details of Chemicals and Quantities handled and stored.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (i) Is the unit a Major Acident Hazard unit as per MSIHC Rules ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + accident,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(
					"   (ii) Is the unit an isolated storage as defined  ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": "
					+ isolatedStorage, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (iii) Indicate status of compliance of rules 5,7,10,11,12,13 and 18 of the MSIHC Rules.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + compStatus,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (iv) Has approval of site been obtained from the concerned authority?",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + siteApproval,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (v) Has the unit prepared an off-site Emergency Plan? Is it updated?",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + emergency
					+ "\n  " + isUpdated, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (vi) Has information on imports of chemicals been provided to the concerned authority. ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + importChem,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (vii) Does the unit posses a policy under the PLI Act? ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + pliAct,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"42. Brief details of tree plantation/greeen belt development within applicants permises(in hectres) ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": " + treePlantDev,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"43. Information of schemes for waste reunification, resource recovery and recycling-implemented and to be implemented and to be implemented, separately. ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(
					": " + wasteMinDetail, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"44. (a) The applicant shall indicate whether industry comes under Public Hearing, if so, the relevant documents such as PLA,EMP,RISK Analysis etc, shall be submitted, if so, the relevant documents enclosed shall be indicated accordingly. ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": "
					+ underPubHearing, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (b) Any other aditional information that the applicant desires to give.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(": NA", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"   (b) Any other additional information that the applicant desires to give.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));
			table33.addCell(cell33);

			cell33 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell33.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setPadding(3.0f);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setBorder(PdfPCell.NO_BORDER);
			cell33.setBorderColor(new Color(0, 0, 0));

			document.add(table33);

		}

		if (consentFor.equals("stonecrusher")||consentFor.equals("hotmixplants")||consentFor.equals("stonecrusher and hotmixplants")) {

			Paragraph subject = new Paragraph();
			subject.add(new Chunk("PART-B", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject.setIndentationLeft(180);
			document.add(subject);

			document.add(space4);

			Paragraph subject1 = new Paragraph();
			subject1
					.add(new Chunk("12. Location Details",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,
									Font.BOLD)));
			subject1.setIndentationRight(20);
			document.add(subject1);
			document.add(space4);
			PdfPTable table239 = new PdfPTable(2);

			PdfPCell cell239 = new PdfPCell();

			table239.setWidthPercentage(100);

			cell239 = new PdfPCell(new Paragraph(
					new Chunk("Parameter", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell239.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell239.setPadding(5.0f);
			table239.addCell(cell239);

			cell239 = new PdfPCell(
					new Paragraph(new Chunk(
							"Distance from Proposed/Unit Site (In Meters) ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));

			cell239.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell239.setPadding(5.0f);
			table239.addCell(cell239);

			for (int var2 = 0; var2 < stoneCrusherSittingCriteriaDetail.size(); var2++) {
				ArrayList al = (ArrayList) stoneCrusherSittingCriteriaDetail
						.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell239 = new PdfPCell(new Paragraph(a));
					cell239.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell239.setPadding(5.0f);
					table239.addCell(cell239);

				}
			}

			document.add(table239);

			document.add(space4);

			Paragraph subject11 = new Paragraph();
			subject11.add(new Chunk("15. Other Details", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject11.setIndentationRight(20);
			document.add(subject11);

			document.add(space4);

			Paragraph subject111 = new Paragraph();
			subject111.add(new Chunk("Area: " + hotelArea, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			subject111.setIndentationRight(20);
			document.add(subject111);

			document.add(space4);

			Paragraph subject1111 = new Paragraph();
			subject1111
					.add(new Chunk(
							"16. Pollution Control Devices Proposed/Installed: ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,
									Font.BOLD)));
			subject1111.setIndentationRight(20);
			document.add(subject1111);

			document.add(space4);

			PdfPTable table231 = new PdfPTable(3);

			PdfPCell cell231 = new PdfPCell();

			table231.setWidthPercentage(100);

			cell231 = new PdfPCell(new Paragraph(new Chunk(
					"Pollution Control Device", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell231.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell231.setPadding(5.0f);
			table231.addCell(cell231);

			cell231 = new PdfPCell(new Paragraph(
					new Chunk("Device Name", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));

			cell231.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell231.setPadding(5.0f);
			table231.addCell(cell231);

			cell231 = new PdfPCell(new Paragraph(new Chunk("Status", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));

			cell231.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell231.setPadding(5.0f);
			table231.addCell(cell231);

			for (int var2 = 0; var2 < stoneCrusherControlDevicesDetail.size(); var2++) {
				ArrayList al = (ArrayList) stoneCrusherControlDevicesDetail
						.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell231 = new PdfPCell(new Paragraph(a));
					cell231.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell231.setPadding(5.0f);
					table231.addCell(cell231);

				}
			}

			document.add(table231);
			
			document.add(space4);
			
			Paragraph subject11110 = new Paragraph();
			subject11110.add(new Chunk("17. Water Source Details: ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject11110.setIndentationRight(20);
			document.add(subject11110);

			document.add(space4);
			
			document.add(tableBrickStoneWaterReq);
			
			document.add(space4);
			
			Paragraph subject111103 = new Paragraph();
			subject111103.add(new Chunk("18. Water Consumption & Storage Details: ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject111103.setIndentationRight(20);
			document.add(subject111103);

			document.add(space4);
			
			document.add(tableBrickStoneWaterConsu);
			
			document.add(space4);
			
			Paragraph subject1111031 = new Paragraph();
			subject1111031.add(new Chunk("19. Whether NOC's from following obtained: ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject1111031.setIndentationRight(20);
			document.add(subject1111031);
			
			document.add(space4);
			
			PdfPTable table2318 = new PdfPTable(4);

			PdfPCell cell2318 = new PdfPCell();

			table2318.setWidthPercentage(100);

			cell2318 = new PdfPCell(new Paragraph(new Chunk(
					"Name of Authority", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell2318.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2318.setPadding(5.0f);
			table2318.addCell(cell2318);

			cell2318 = new PdfPCell(new Paragraph(
					new Chunk("Whether NOC obtained", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));

			cell2318.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2318.setPadding(5.0f);
			table2318.addCell(cell231);

			cell2318 = new PdfPCell(new Paragraph(new Chunk("Number", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));

			cell2318.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2318.setPadding(5.0f);
			table2318.addCell(cell2318);
			
			cell2318 = new PdfPCell(new Paragraph(new Chunk("Date", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.BOLD))));

			cell2318.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2318.setPadding(5.0f);
			table2318.addCell(cell2318);

			for (int var2 = 0; var2 < nocDetailsList.size(); var2++) {
				ArrayList al = (ArrayList) nocDetailsList
						.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell2318 = new PdfPCell(new Paragraph(a));
					cell2318.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell2318.setPadding(5.0f);
					table2318.addCell(cell2318);

				}
			}

			document.add(table2318);
			
			document.add(space4);

		}

		if (consentFor.equals("brickkilns")) {

			Paragraph subject = new Paragraph();
			subject.add(new Chunk("PART-B", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject.setIndentationLeft(180);
			document.add(subject);

			document.add(space4);

			Paragraph subject1 = new Paragraph();
			subject1
					.add(new Chunk("12. Give Details of the siting Criteria: ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1,
									Font.BOLD)));
			subject1.setIndentationRight(20);
			document.add(subject1);

			document.add(space4);

			PdfPTable table239 = new PdfPTable(2);

			PdfPCell cell239 = new PdfPCell();

			table239.setWidthPercentage(100);

			cell239 = new PdfPCell(new Paragraph(
					new Chunk("Parameter", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.BOLD))));
			cell239.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell239.setPadding(5.0f);
			table239.addCell(cell239);

			cell239 = new PdfPCell(
					new Paragraph(new Chunk(
							"Distance from Proposed/Unit Site (In Meters) ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD))));

			cell239.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell239.setPadding(5.0f);
			table239.addCell(cell239);

			for (int var2 = 0; var2 < brickKilnsSittingCriteriaDetail.size(); var2++) {
				ArrayList al = (ArrayList) brickKilnsSittingCriteriaDetail
						.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell239 = new PdfPCell(new Paragraph(a));
					cell239.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell239.setPadding(5.0f);
					table239.addCell(cell239);

				}
			}

			document.add(table239);

			document.add(space4);

			Paragraph subject21 = new Paragraph();
			subject21.add(new Chunk("PART-C", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject21.setIndentationLeft(180);
			document.add(subject21);
			
			Paragraph subject1111 = new Paragraph();
			subject1111.add(new Chunk("13. Other Details: ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject1111.setIndentationRight(20);
			document.add(subject1111);

			document.add(space4);

			Paragraph subject111 = new Paragraph();
			subject111.add(new Chunk("Capacity of the Kiln: " + capacity1,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			subject111.setIndentationRight(20);
			document.add(subject111);

			document.add(space4);

			Paragraph subject11111 = new Paragraph();
			subject11111.add(new Chunk("Trench Size: " + trenchSize, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			subject11111.setIndentationRight(20);
			document.add(subject11111);

			document.add(space4);

			Paragraph subject111111 = new Paragraph();
			subject111111.add(new Chunk("Chimney flexed/moving: " + chimeny,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			subject111111.setIndentationRight(20);
			document.add(subject111111);

			document.add(space4);

			Paragraph subject1111111 = new Paragraph();
			subject1111111.add(new Chunk("Height of Chimney (In Meters): "
					+ height9, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
					Font.NORMAL)));
			subject1111111.setIndentationRight(20);
			document.add(subject1111111);

			document.add(space4);

			Paragraph subject1111112 = new Paragraph();
			subject1111112.add(new Chunk(
					"Any ECD installed alongwith the Chimney: " + ecd,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			subject1111112.setIndentationRight(20);
			document.add(subject1111112);

			document.add(space4);

			Paragraph subject1111113 = new Paragraph();
			subject1111113.add(new Chunk("Cluster/Isolated: " + cluster,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			subject1111113.setIndentationRight(20);
			document.add(subject1111113);

			document.add(space4);
			
			Paragraph subject11110 = new Paragraph();
			subject11110.add(new Chunk("14. Water Source Details: ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject11110.setIndentationRight(20);
			document.add(subject11110);

			document.add(space4);
			
			document.add(tableBrickStoneWaterReq);
			
			document.add(space4);
			
			Paragraph subject111103 = new Paragraph();
			subject111103.add(new Chunk("15. Water Consumption & Storage Details: ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 1, Font.BOLD)));
			subject111103.setIndentationRight(20);
			document.add(subject111103);

			document.add(space4);
			
			document.add(tableBrickStoneWaterConsu);
			
			document.add(space4);
			
			

		}

		if (consentFor.equals("dgset")) {


			Paragraph heading1 = new Paragraph();
			heading1.add(new Chunk("RGPJ-1187(DTP)/08-1000 sets of 2Ivs.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3,
							Font.NORMAL)));
			heading1.setAlignment(Element.ALIGN_RIGHT);
			document.add(heading1);

			Paragraph heading = new Paragraph();
			heading
					.add(new Chunk(
							"APPLICATION FOR CONSENT TO OPERATE FOR DIESEL GENERATOR SETS",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,
									Font.BOLD)));
			heading.setAlignment(Element.ALIGN_CENTER);
			document.add(heading);
			document.add(space4);

			Paragraph subHeading = new Paragraph();
			subHeading
					.add(new Chunk(
							"Application for Consent for emission/continuation of emission under section 21 of the ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD)));
			subHeading.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading);

			Paragraph subHeading1 = new Paragraph();
			subHeading1
					.add(new Chunk(
							"Air(Prevention and Control of Pollution) Act, 1981.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.BOLD)));
			subHeading1.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading1);

			document.add(space4);

			Paragraph date = new Paragraph();
			date.add(new Chunk("Date of submission: " + dateOfSubmission,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			date.setAlignment(Element.ALIGN_RIGHT);
			document.add(date);
			document.add(space4);

			Paragraph from = new Paragraph();
			from.add(new Chunk("From : \n \n", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			from.setAlignment(Element.ALIGN_LEFT);
			document.add(from);

			Paragraph from9 = new Paragraph();
			from9.add(new Chunk(" " + industryName + ",\n Industry Address: " + industryAddress
					+ ", " + industryPlot + ",\n City: " + industryCity
					+ ",\n Tehsil: " + industryTehsil + " , District: "
					+ industryDistrict + ",\n Telephone:" + industryTelephone,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
							Font.NORMAL)));
			from9.setAlignment(Element.ALIGN_LEFT);
			document.add(from9);

			Paragraph name = new Paragraph();
			name.add(new Chunk("(Name and address of the applicant)", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE - 3, Font.NORMAL)));
			name.setAlignment(Element.ALIGN_LEFT);
			document.add(name);
			document.add(space4);

			Paragraph paraB = new Paragraph();
			paraB.add(new Chunk("To", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraB.setAlignment(Element.ALIGN_LEFT);
			document.add(paraB);
			document.add(space4);

			Paragraph paraB1 = new Paragraph();
			paraB1.add(new Chunk("The", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraB1.setAlignment(Element.ALIGN_LEFT);
			document.add(paraB1);
			document.add(space4);

			Paragraph memberS1 = new Paragraph();
			memberS1.add(new Chunk("Regional Director", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			memberS1.setIndentationLeft(20);
			document.add(memberS1);

			Paragraph member1 = new Paragraph();
			member1.add(new Chunk("J&K Pollution Control Committee,",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			member1.setIndentationLeft(20);
			document.add(member1);

			Paragraph memberc1 = new Paragraph();
			memberc1.add(new Chunk("Jammu/Kashmir", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			memberc1.setIndentationLeft(20);
			document.add(memberc1);

			document.add(space4);

			Paragraph Sir = new Paragraph();
			Sir.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			Sir.setAlignment(Element.ALIGN_LEFT);
			document.add(Sir);
			document.add(space4);

			Paragraph paraC = new Paragraph();
			paraC
					.add(new Chunk(
							"1. I/We hereby apply for consent to operate(Fresh/Renewal) under the sub-section(2) of section 21 of the Air(Prevention and Control Pollution)Act, 1981 to make emission from Diesel Generator Set at our Premises/Industrial Plant/Shop/Residential house owned by "
									+ occupierName + " for a period up to.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraC.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraC);
			document.add(space4);

			Paragraph paraD = new Paragraph();
			paraD
					.add(new Chunk(
							"2. The annexure, Appendices, other particulars are attached.  ",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraD.setAlignment(Element.ALIGN_LEFT);
			document.add(paraD);
			document.add(space4);

			Paragraph paraE = new Paragraph();
			paraE
					.add(new Chunk(
							"3. I/We hereby submit that in case of a change in the capacity of D.G Set or the quantity of emission, a fresh application shall be made and untill such consent is granted no change shall be made.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraE.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraE);
			document.add(space4);

			Paragraph paraE1 = new Paragraph();
			paraE1
					.add(new Chunk(
							"4. I/We hereby agree to submit to the Board, application for renewal of consent two months in advance of the date of expiry of the consent period, if to be continued therafter.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraE1.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraE1);
			document.add(space4);

			Paragraph paraE2 = new Paragraph();
			paraE2
					.add(new Chunk(
							"5. I/We undertake to furnish any other information within seven days of its being called for the Pollution Control Committee.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraE2.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraE2);
			document.add(space4);

			Paragraph paraE3 = new Paragraph();
			paraE3
					.add(new Chunk(
							"6. I/We enclose here with demand draft of Rs....in  favour of Member Seceretary , J&K Pollution Control Committee, Jammu/Srinagar payable at Branch.......as 'consent to operate application fee'.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraE3.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paraE3);
			
			document.add(tableFees);
			document.add(tableFees1);
			document.add(space4);

			String day = dateOfSubmission.substring(1,2);
			Paragraph paraE51 = new Paragraph();
			paraE51.add(new Chunk("Date: " + dateOfSubmission, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraE51.setAlignment(Element.ALIGN_LEFT);
			document.add(paraE51);

			Paragraph paraE4 = new Paragraph();
			paraE4.add(new Chunk(" " + occupierName + "\n"
					+ "(Signature of Applicant) \n", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraE4.setAlignment(Element.ALIGN_RIGHT);
			document.add(paraE4);

			Paragraph paraE41 = new Paragraph();
			paraE41.add(new Chunk("Seal", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraE41.setAlignment(Element.ALIGN_RIGHT);
			document.add(paraE41);

			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100);
			PdfPCell cell1 = new PdfPCell();

			cell1 = new PdfPCell(new Paragraph(new Chunk(
					"Name of the applicant :" + occupierName, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk("Designation :"
					+ occupierDesignation, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk(
					"Application on behalf of :" + industryName, new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk(
					"Address of applicant :" + occupierAddress
							+ ",\n     City: " + occCity + " , District: "
							+ occupierDistrict + ",\n     Tehsil: "
							+ occupierTehsil + ",\n    Telephone: "
							+ occupierTelephone, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			cell1 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			document.add(table1);
			document.newPage();

			Paragraph partA = new Paragraph();
			partA.add(new Chunk("PART-A: GENERAL INFORMATION", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			partA.setAlignment(Element.ALIGN_LEFT);
			document.add(partA);
			document.add(space4);

			PdfPTable table2 = new PdfPTable(3);
			table2.setWidthPercentage(100);
			float[] columnWidths = { 0.1f, 1f, 1f };
			table2.setWidths(columnWidths);
			PdfPCell cell2 = new PdfPCell();

			cell2 = new PdfPCell(new Paragraph(new Chunk("1. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(1.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Full address of the premises where Diesel Generator Set installed. (mentioning Post Office, Police Station, Local Body with Ward No. etc).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(": ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("Telephone :"
					+ industryTelephone, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("Fax :"
					+ industryTelephone, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("City :"
					+ industryCity, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("District :"
					+ industryDistrict, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("Tehsil :"
					+ industryTehsil, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("Ward No :", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("Plot No :"
					+ industryPlot, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk("2. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(
					"Year of commsioning of the D.G. Set", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			cell2 = new PdfPCell(new Paragraph(new Chunk(": " + commMonth + "/"
					+ dtOfCommissioning, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell2.setVerticalAlignment(Element.ALIGN_LEFT);
			cell2.setPadding(3.0f);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setBorderColor(new Color(0, 0, 0));
			table2.addCell(cell2);

			document.add(table2);
			document.add(space4);

			Paragraph partB = new Paragraph();
			partB
					.add(new Chunk(
							"PART-B: INFORMATION REQUIRED IN CONNECTION WITH DIESEL, GENERATOR SET OF CAPACITY",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			partB.setAlignment(Element.ALIGN_LEFT);
			document.add(partB);

			document.add(space4);

			PdfPTable table3 = new PdfPTable(3);
			table3.setWidthPercentage(100);
			float[] columnWidths1 = { 0.1f, 1f, 1f };
			table3.setWidths(columnWidths1);
			PdfPCell cell3 = new PdfPCell();

			cell3 = new PdfPCell(new Paragraph(new Chunk("3.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"Make and Model of diesel Generator Set", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + makeDGset + "/"
					+ modelDGset, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
					Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("4.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"(i)Power of D.G. Set (in KVA)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + powerRating,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

		
			cell3 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"(ii)Fuel Quantity(KL/day)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + fuel,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"(iii)Stack Height (in meters)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + stackHeight,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);


			cell3 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"(iv)Height of the building (in meters)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + heightOfBuilding,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			
			
			cell3 = new PdfPCell(new Paragraph(new Chunk("5.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Sound Power level of D.G. Set at the manufacturing stage location of D.G. sets",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + soundLevel,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("6.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"Location of D.G. Set.", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + locationDg,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("7.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"Used only at the time of load Shedding", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + loadShedding,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("8.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Whether noise from D.G Set controlled by providing standard acoustic enclosure of minimum 25 dB(A) Insertion loss \n OR \n whether D.G. Set is treated acoustically to get minimum 25 db(A) Insertion loss.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + noise + "\n\n"
					+ room, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
					Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("9.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Whether the exhaust gases passed through a suitable exhaust maffler with insertion loss of minimum 15 dB(A).",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + exhaustGas,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("10.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Whether installation of D.G Set is in compliance with the recommendations of D.G Set manufacturer.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + installation,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("11.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Steps taken for minimization of vibration transmission to the neighbourhood",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + minVibration,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("12.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"Steps taken for minmization of exhaust gas leaks.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk(": " + minLeaks,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);

			cell3 = new PdfPCell(new Paragraph(new Chunk("13.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);
			
			cell3 = new PdfPCell(new Paragraph(new Chunk(
					"The mimimum height of stack has been worked out by using folmula",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_LEFT);
			cell3.setPadding(1.0f);
			cell3.setColspan(2);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBorderColor(new Color(0, 0, 0));
			table3.addCell(cell3);
			
			document.add(table3);
						
			Image image = Image.getInstance("images2/formulaPic.jpg");
			image.setAlignment(Image.LEFT | Image.TEXTWRAP);
			document.add(image);
						
			Paragraph partB1 = new Paragraph();
			partB1
					.add(new Chunk(
							"[H= Total height of stack in meters, h=Height of building in metres where D.G, Set is installed, KVA = Total generator capacity of the DG set in KVA]",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			partB1.setAlignment(Element.ALIGN_LEFT);
			document.add(partB1);

			document.add(space4);

			PdfPTable table4 = new PdfPTable(3);
			table4.setWidthPercentage(100);
			float[] columnWidths3 = { 0.1f, 1f, 1f };
			table4.setWidths(columnWidths3);
			PdfPCell cell4 = new PdfPCell();

			cell4 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("For Generator Sets",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(
					"Total height of stack (in meters)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("Up to 50 KVA",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(
					"Height of building+1.5 meters", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("1) 50-100 KVA",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("do.	+2.0 metres",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("2) 100-150 KVA",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("do.	+2.5 metres",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("3) 150-200 KVA",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("do.	+3.0 metres",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("4) 200-250 KVA",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("do.	+3.5 metres",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("5) 250-300 KVA",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk("do.	+3.5 metres",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			
			cell4 = new PdfPCell(new Paragraph(new Chunk("Applicant Input", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setColspan(3);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);
			
			cell4 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(" Generator set power rating (in KVA) ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(" Minimum height of stack (in meters)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(""+powerRating,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);

			cell4 = new PdfPCell(new Paragraph(new Chunk(""+totalHeight,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell4.setVerticalAlignment(Element.ALIGN_LEFT);
			cell4.setPadding(1.0f);
			cell4.setBorder(PdfPCell.NO_BORDER);
			cell4.setBorderColor(new Color(0, 0, 0));
			table4.addCell(cell4);
			
			document.add(table4);
			document.add(space4);

			Paragraph paraP1 = new Paragraph();
			paraP1
					.add(new Chunk(
							"PART-C: INFORMATION REQUIRED IN CONNECTION WITH PREVENTION AND CONTROL OF AIR POLLUTION",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraP1.setAlignment(Element.ALIGN_LEFT);
			document.add(paraP1);
			document.add(space4);

			Paragraph paraP11 = new Paragraph();
			paraP11.add(new Chunk("14. Emission Sources:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraP11.setAlignment(Element.ALIGN_LEFT);
			document.add(paraP11);
			document.add(space4);

			PdfPTable table11 = new PdfPTable(9);
			table11.setWidthPercentage(100);
			PdfPCell cell11 = new PdfPCell();

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"Sources of Emissions", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"Horse Power of the engine", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("Engine RPM",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setColspan(2);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"Fuel used and Quantity per hour", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"Capacity of D.G. Set(in KVA)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Height of Building where D.G. Set is installed in metres a",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"Height of the stack above building in metres b", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk(
					"Total of a+b in metres", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("No Load", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("Full load",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			cell11 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(1.0f);
			cell11.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11);

			for (int var2 = 0; var2 < emissionDetailsList.size(); var2++) {
				ArrayList al = (ArrayList) emissionDetailsList.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell11 = new PdfPCell(new Paragraph(a));
					cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell11.setPadding(5.0f);
					table11.addCell(cell11);

				}
			}

			document.add(table11);

			document.add(space4);

			PdfPTable table5 = new PdfPTable(3);
			table5.setWidthPercentage(100);
			PdfPCell cell5 = new PdfPCell();

			cell5 = new PdfPCell(new Paragraph(new Chunk("Parameters",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell5.setVerticalAlignment(Element.ALIGN_LEFT);
			cell5.setPadding(1.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table5.addCell(cell5);

			cell5 = new PdfPCell(new Paragraph(new Chunk("No. Load Condition",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell5.setVerticalAlignment(Element.ALIGN_LEFT);
			cell5.setPadding(1.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table5.addCell(cell5);

			cell5 = new PdfPCell(new Paragraph(new Chunk("Full Load Condition",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell5.setVerticalAlignment(Element.ALIGN_LEFT);
			cell5.setPadding(1.0f);
			cell5.setBorderColor(new Color(0, 0, 0));
			table5.addCell(cell5);

			for (int var2 = 0; var2 < parameterDetailsList.size(); var2++) {
				ArrayList al = (ArrayList) parameterDetailsList.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell5 = new PdfPCell(new Paragraph(a));
					cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell5.setPadding(5.0f);
					table5.addCell(cell5);

				}
			}

			document.add(table5);

			document.add(space4);

			Paragraph partD = new Paragraph();
			partD.add(new Chunk("PART-D: OTHER INFORMATION:", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			partD.setAlignment(Element.ALIGN_LEFT);
			document.add(partD);
			document.add(space4);

			PdfPTable table41 = new PdfPTable(3);
			table41.setWidthPercentage(100);
			float[] columnWidths31 = { 0.1f, 1f, 1f };
			table41.setWidths(columnWidths3);
			PdfPCell cell41 = new PdfPCell();

			cell41 = new PdfPCell(new Paragraph(new Chunk("15.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(1.0f);
			cell41.setBorder(PdfPCell.NO_BORDER);
			cell41.setBorderColor(new Color(0, 0, 0));
			table41.addCell(cell41);

			cell41 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Other relevent information, if any. Please attach separate sheet, if required.",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(1.0f);
			cell41.setBorder(PdfPCell.NO_BORDER);
			cell41.setBorderColor(new Color(0, 0, 0));
			table41.addCell(cell41);

			cell41 = new PdfPCell(new Paragraph(new Chunk(":", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell41.setVerticalAlignment(Element.ALIGN_LEFT);
			cell41.setPadding(1.0f);
			cell41.setBorder(PdfPCell.NO_BORDER);
			cell41.setBorderColor(new Color(0, 0, 0));
			table41.addCell(cell41);

			document.add(table41);
			document.add(space4);

			Paragraph paraPa = new Paragraph();
			paraPa.add(new Chunk("Signature of applicant with seal", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraPa.setAlignment(Element.ALIGN_RIGHT);
			document.add(paraPa);
			document.add(space4);

			Paragraph paraPe = new Paragraph();
			paraPe.add(new Chunk("NOTE:", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			paraPe.setAlignment(Element.ALIGN_LEFT);
			document.add(paraPe);

			document.add(space4);
			document.add(space4);
			Paragraph paraP = new Paragraph();
			paraP
					.add(new Chunk(
							"* All enclosures, documents and analysis reports of Committee's recognised laboratories must be signed/countersigned by the applicant with official seal.",
							new Font(Font.ITALIC, Font.DEFAULTSIZE - 1,
									Font.NORMAL)));
			paraP.setAlignment(Element.ALIGN_LEFT);
			document.add(paraP);
			document.add(space4);

			Paragraph paraPb = new Paragraph();
			paraPb
					.add(new Chunk(
							"* All subsequent correction in the application form and enclosures should be signed by the applicant or any person authorized by the applicant.",
							new Font(Font.ITALIC, Font.DEFAULTSIZE - 1,
									Font.NORMAL)));
			paraPb.setAlignment(Element.ALIGN_LEFT);
			document.add(paraPb);
			document.add(space4);

			Paragraph paraPc = new Paragraph();
			paraPc
					.add(new Chunk(
							"* The form is to be filled preferably in by typewriting or legible hand writing.",
							new Font(Font.ITALIC, Font.DEFAULTSIZE - 1,
									Font.NORMAL)));
			paraPc.setAlignment(Element.ALIGN_LEFT);
			document.add(paraPc);
			document.add(space4);
}
		
		if (consentFor.equals("hotel")) {

			Paragraph heading = new Paragraph();
			heading
					.add(new Chunk("J&K Pollution Control Committee",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 2,
									Font.BOLD)));
			heading.setAlignment(Element.ALIGN_CENTER);
			document.add(heading);

			Paragraph subHeading = new Paragraph();
			subHeading
					.add(new Chunk(
							"Application for Consent to Establish/Operate for Hotel/Restaurant",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			subHeading.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading);

			Paragraph subHeading1 = new Paragraph();
			subHeading1.add(new Chunk("(For Existing Hotels/Restaurants)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
							Font.NORMAL)));
			subHeading1.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading1);

			Paragraph subHeading11 = new Paragraph();
			subHeading11.add(new Chunk("(Schedule  I)", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL)));
			subHeading11.setAlignment(Element.ALIGN_CENTER);
			document.add(subHeading11);

			document.add(space4);
			
			PdfPTable table351 = new PdfPTable(2);
			table351.setWidthPercentage(100);
			PdfPCell cell351 = new PdfPCell();

			cell351 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_LEFT);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("Application No." + appID,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_CENTER);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_LEFT);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk(
					"Acompanying form in triplicate to be submitted", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_CENTER);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_LEFT);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk(
					"By the applicant, one copy may be retained by", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_CENTER);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_LEFT);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			cell351 = new PdfPCell(new Paragraph(new Chunk("The applicant",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell351.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell351.setVerticalAlignment(Element.ALIGN_CENTER);
			cell351.setPadding(3.0f);
			cell351.setBorder(PdfPCell.NO_BORDER);
			cell351.setBorderColor(new Color(0, 0, 0));
			table351.addCell(cell351);

			document.add(table351);
			document.add(space4);
			

			PdfPTable table1 = new PdfPTable(2);
			table1.setWidthPercentage(100);
			PdfPCell cell1 = new PdfPCell();

			cell1 = new PdfPCell(new Paragraph(new Chunk("From: \n\n "+industryName + "\n Address: " + industryAddress+ "\n City: " + industryCity + ", Tehsil: "+ industryTehsil + "\n District: " + industryDistrict+ "\n Phone: " + industryTelephone, new Font(	Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1.setPadding(3.0f);
			cell1.setColspan(2);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell1);

			document.add(space4);

			document.add(space4);

			PdfPCell cell11 = new PdfPCell();
			cell11 = new PdfPCell(new Paragraph(new Chunk("To ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11.setPadding(3.0f);
			cell11.setColspan(2);
			cell11.setBorder(PdfPCell.NO_BORDER);
			cell11.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell11);

			PdfPCell cell111 = new PdfPCell();
			cell111 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"The \n Member Secretary \n J & K Pollution Control Committee",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111.setPadding(3.0f);
			cell11.setColspan(2);
			cell111.setBorder(PdfPCell.NO_BORDER);
			cell111.setBorderColor(new Color(0, 0, 0));
			table1.addCell(cell111);

			document.add(table1);

			document.add(space4);

			Paragraph Sir = new Paragraph();
			Sir.add(new Chunk("Sir,", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			Sir.setAlignment(Element.ALIGN_LEFT);
			document.add(Sir);
			document.add(space4);

			Paragraph paraC = new Paragraph();
			paraC
					.add(new Chunk(
							"I/We hereby apply for consent to Establish/operate/Renewal of Consent to Establish/Operate a Hotel /Restaurant under section 25 of the Water (Prevention & Control of Pollution )Act 1974 and submit following information to facilitate the process for its issuance.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			paraC.setAlignment(Element.ALIGN_LEFT);
			
			document.add(paraC);

			PdfPTable table11 = new PdfPTable(3);
			table11.setWidthPercentage(100);
			float[] columnWidths = { 0.1f, 1f, 1f };
			table11.setWidths(columnWidths);

			PdfPCell cell1111 = new PdfPCell();

			cell1111 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111.setPadding(3.0f);
			cell1111.setBorder(PdfPCell.NO_BORDER);
			cell1111.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111);

			cell1111 = new PdfPCell(new Paragraph(new Chunk("A. General. ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell1111.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111.setPadding(3.0f);
			cell1111.setColspan(2);
			cell1111.setBorder(PdfPCell.NO_BORDER);
			cell1111.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111);

			PdfPCell cell11112 = new PdfPCell();

			cell11112 = new PdfPCell(new Paragraph(new Chunk(" ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11112.setPadding(3.0f);
			cell11112.setBorder(PdfPCell.NO_BORDER);
			cell11112.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11112);

			cell11112 = new PdfPCell(new Paragraph(new Chunk("(HOTELS/RESTAURANT/ LODGES/GUEST HOUSE) ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell11112.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11112.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11112.setPadding(3.0f);
			cell11112.setColspan(2);
			cell11112.setBorder(PdfPCell.NO_BORDER);
			cell11112.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11112);

			PdfPCell cell11113 = new PdfPCell();

			cell11113 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11113.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11113.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11113.setPadding(3.0f);
			cell11113.setBorder(PdfPCell.NO_BORDER);
			cell11113.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11113);

			cell11113 = new PdfPCell(new Paragraph(new Chunk(
					"Name of the Establishment Hotel/Restaurant/ " +
					"Lodge/ Guest House", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11113.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11113.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11113.setPadding(3.0f);
			cell11113.setBorder(PdfPCell.NO_BORDER);
			cell11113.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11113);

			cell11113 = new PdfPCell(new Paragraph(new Chunk(": "
					+ hotelNameValue, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell11113.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11113.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11113.setPadding(3.0f);
			cell11113.setBorder(PdfPCell.NO_BORDER);
			cell11113.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11113);

			PdfPCell cell11114 = new PdfPCell();

			cell11114 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11114.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11114.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11114.setPadding(3.0f);
			cell11114.setBorder(PdfPCell.NO_BORDER);
			cell11114.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11114);

			cell11114 = new PdfPCell(new Paragraph(new Chunk(
					"Name & Designation of the applicant", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11114.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11114.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11114.setPadding(3.0f);
			cell11114.setBorder(PdfPCell.NO_BORDER);
			cell11114.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11114);

			cell11114 = new PdfPCell(new Paragraph(new Chunk(": "
					+ occupierName + ","+ occupierDesignation, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell11114.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11114.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11114.setPadding(3.0f);
			cell11114.setBorder(PdfPCell.NO_BORDER);
			cell11114.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11114);

			PdfPCell cell11115 = new PdfPCell();

			cell11115 = new PdfPCell(new Paragraph(new Chunk("3.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11115.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11115.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11115.setPadding(3.0f);
			cell11115.setBorder(PdfPCell.NO_BORDER);
			cell11115.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11115);

			cell11115 = new PdfPCell(new Paragraph(new Chunk(
					"Location of the Hotel/Restaurant/Lodge/Guest House with Telephone no./Fax No./email.", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11115.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11115.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11115.setPadding(3.0f);
			cell11115.setBorder(PdfPCell.NO_BORDER);
			cell11115.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11115);

			cell11115 = new PdfPCell(new Paragraph(new Chunk(": "+ industryAddress + "\n City: " + industryCity	+ ", Tehsil: " + industryTehsil + "\n District: "+ industryDistrict, new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE, Font.NORMAL))));
			cell11115.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11115.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11115.setPadding(3.0f);
			cell11115.setBorder(PdfPCell.NO_BORDER);
			cell11115.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11115);

			PdfPCell cell11116 = new PdfPCell();

			cell11116 = new PdfPCell(new Paragraph(new Chunk("4.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell11116.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11116.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11116.setPadding(3.0f);
			cell11116.setBorder(PdfPCell.NO_BORDER);
			cell11116.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11116);

			cell11116 = new PdfPCell(new Paragraph(new Chunk(
					"Room capacity of the Hotel", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell11116.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11116.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11116.setPadding(3.0f);
			cell11116.setBorder(PdfPCell.NO_BORDER);
			cell11116.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11116);

			cell11116 = new PdfPCell(new Paragraph(new Chunk(": "
					+ roomCapacity, new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.NORMAL))));
			cell11116.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11116.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11116.setPadding(3.0f);
			cell11116.setBorder(PdfPCell.NO_BORDER);
			cell11116.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11116);			
			
			PdfPCell cell111169 = new PdfPCell();

			cell111169 = new PdfPCell(new Paragraph(new Chunk("5.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111169.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111169.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111169.setPadding(3.0f);
			cell111169.setBorder(PdfPCell.NO_BORDER);
			cell111169.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111169);
			
			cell111169 = new PdfPCell(new Paragraph(new Chunk("Are You Registered with Department of Tourism, if yes, provide details.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111169.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111169.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111169.setPadding(3.0f);
			cell111169.setBorder(PdfPCell.NO_BORDER);
			cell111169.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111169);
			
			cell111169 = new PdfPCell(new Paragraph(new Chunk(": "+deptTourism + " "+tourismDetails, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111169.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111169.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111169.setPadding(3.0f);
			cell111169.setBorder(PdfPCell.NO_BORDER);
			cell111169.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111169);

			PdfPCell cell111161 = new PdfPCell();

			cell111161 = new PdfPCell(new Paragraph(new Chunk("6.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111161.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111161.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111161.setPadding(3.0f);
			cell111161.setBorder(PdfPCell.NO_BORDER);
			cell111161.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111161);

			cell111161 = new PdfPCell(new Paragraph(new Chunk(
					"Facilities available with capacity of each    :", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111161.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111161.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111161.setPadding(3.0f);
			cell111161.setColspan(2);
			cell111161.setBorder(PdfPCell.NO_BORDER);
			cell111161.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111161);
			
			PdfPTable table151 = new PdfPTable(4);
			table151.setWidthPercentage(100);
			PdfPCell cell151 = new PdfPCell();

			cell151 = new PdfPCell(new Paragraph(new Chunk("Facility For",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell151.setVerticalAlignment(Element.ALIGN_CENTER);
			cell151.setPadding(1.0f);
			cell151.setBorderColor(new Color(0, 0, 0));
			table151.addCell(cell151);

			cell151 = new PdfPCell(new Paragraph(new Chunk("Facility Type",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell151.setVerticalAlignment(Element.ALIGN_CENTER);
			cell151.setPadding(1.0f);
			cell151.setBorderColor(new Color(0, 0, 0));
			table151.addCell(cell151);
			
			cell151 = new PdfPCell(new Paragraph(new Chunk("Capacity(Room capacity, seating capacity, vehicle parking etc)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell151.setVerticalAlignment(Element.ALIGN_CENTER);
			cell151.setPadding(1.0f);
			cell151.setBorderColor(new Color(0, 0, 0));
			table151.addCell(cell151);
			
			cell151 = new PdfPCell(new Paragraph(new Chunk("Facility Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell151.setVerticalAlignment(Element.ALIGN_CENTER);
			cell151.setPadding(1.0f);
			cell151.setBorderColor(new Color(0, 0, 0));
			table151.addCell(cell151);

			for (int var2 = 0; var2 < hotelFacilityDetail.size(); var2++) {
				ArrayList al = (ArrayList) hotelFacilityDetail.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell151 = new PdfPCell(new Paragraph(a));
					cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell151.setPadding(5.0f);
					table151.addCell(cell151);

				}
			}			
						
			cell111161 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111161.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111161.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111161.setPadding(3.0f);
			cell111161.setColspan(3);
			cell111161.setBorder(PdfPCell.NO_BORDER);
			cell111161.addElement(table151);
			cell111161.setBorderColor(new Color(0, 0, 0));
			
			table11.addCell(cell111161);			
			
			PdfPCell cell1111611 = new PdfPCell();			
			
			cell1111611 = new PdfPCell(new Paragraph(new Chunk("7.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111611.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111611.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111611.setPadding(3.0f);
			cell1111611.setBorder(PdfPCell.NO_BORDER);
			cell1111611.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111611);

			cell1111611 = new PdfPCell(new Paragraph(new Chunk(
					"Total Project Cost(in Rs.)", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111611.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111611.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111611.setPadding(3.0f);
			cell1111611.setBorder(PdfPCell.NO_BORDER);
			cell1111611.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111611);

			cell1111611 = new PdfPCell(new Paragraph(new Chunk(": "
					+ investmentN, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
					Font.NORMAL))));
			cell1111611.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111611.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111611.setPadding(3.0f);
			cell1111611.setBorder(PdfPCell.NO_BORDER);
			cell1111611.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111611);			

			PdfPCell cell111162 = new PdfPCell();			
			
			cell111162 = new PdfPCell(new Paragraph(new Chunk("8.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111162.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111162.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111162.setPadding(3.0f);
			cell111162.setBorder(PdfPCell.NO_BORDER);
			cell111162.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111162);

			cell111162 = new PdfPCell(new Paragraph(new Chunk(
					"Restaurant independent of the hotels?", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111162.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111162.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111162.setPadding(3.0f);
			cell111162.setBorder(PdfPCell.NO_BORDER);
			cell111162.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111162);

			cell111162 = new PdfPCell(new Paragraph(new Chunk(": "+indpendentRestaurant, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111162.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111162.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111162.setPadding(3.0f);
			cell111162.setBorder(PdfPCell.NO_BORDER);
			cell111162.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111162);
			

			cell111162 = new PdfPCell(new Paragraph(new Chunk("9.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111162.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111162.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111162.setPadding(3.0f);
			cell111162.setBorder(PdfPCell.NO_BORDER);
			cell111162.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111162);

			cell111162 = new PdfPCell(new Paragraph(new Chunk(
					"Name & Style of the Restaurant ", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111162.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111162.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111162.setPadding(3.0f);
			cell111162.setBorder(PdfPCell.NO_BORDER);
			cell111162.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111162);

			cell111162 = new PdfPCell(new Paragraph(new Chunk(": "
					+ restaurantN, new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE,
					Font.NORMAL))));
			cell111162.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111162.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111162.setPadding(3.0f);
			cell111162.setBorder(PdfPCell.NO_BORDER);
			cell111162.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111162);

			PdfPCell cell111163 = new PdfPCell();

			cell111163 = new PdfPCell(new Paragraph(new Chunk("10.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111163.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111163.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111163.setPadding(3.0f);
			cell111163.setBorder(PdfPCell.NO_BORDER);
			cell111163.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111163);

			cell111163 = new PdfPCell(new Paragraph(new Chunk("Seating Capacity ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111163.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111163.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111163.setPadding(3.0f);
			cell111163.setBorder(PdfPCell.NO_BORDER);
			cell111163.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111163);

			cell111163 = new PdfPCell(new Paragraph(new Chunk(": " + capacityN,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111163.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111163.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111163.setPadding(3.0f);
			cell111163.setBorder(PdfPCell.NO_BORDER);
			cell111163.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111163);

			PdfPCell cell1111631 = new PdfPCell();

			cell1111631 = new PdfPCell(new Paragraph(new Chunk("11.",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			cell1111631 = new PdfPCell(new Paragraph(new Chunk(
					"Facilities available       :", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setColspan(2);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			
			PdfPTable table51 = new PdfPTable(4);
			table51.setWidthPercentage(100);
			PdfPCell cell51 = new PdfPCell();

			cell51 = new PdfPCell(new Paragraph(new Chunk("Facility For",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell51.setVerticalAlignment(Element.ALIGN_CENTER);
			cell51.setPadding(1.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table51.addCell(cell51);

			cell51 = new PdfPCell(new Paragraph(new Chunk("Facility Type",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell51.setVerticalAlignment(Element.ALIGN_CENTER);
			cell51.setPadding(1.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table51.addCell(cell51);	
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Capacity (seating capacity, Vehicle parking capcity etc)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell51.setVerticalAlignment(Element.ALIGN_CENTER);
			cell51.setPadding(1.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table51.addCell(cell51);			
			
			cell51 = new PdfPCell(new Paragraph(new Chunk("Facility Details",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell51.setVerticalAlignment(Element.ALIGN_CENTER);
			cell51.setPadding(1.0f);
			cell51.setBorderColor(new Color(0, 0, 0));
			table51.addCell(cell51);

			for (int var2 = 0; var2 < hotelFacilityDetailRestaurent.size(); var2++) {
				ArrayList al = (ArrayList) hotelFacilityDetailRestaurent.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell51 = new PdfPCell(new Paragraph(a));
					cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell51.setPadding(5.0f);
					table51.addCell(cell51);

				}
			}			
						
			cell1111631 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setColspan(3);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.addElement(table51);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			
			table11.addCell(cell1111631);	

			cell1111631 = new PdfPCell(new Paragraph(new Chunk("12.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			cell1111631 = new PdfPCell(new Paragraph(new Chunk(
					"Year of Establishment/Commisioning", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			cell1111631 = new PdfPCell(new Paragraph(new Chunk(": " + yearN,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			cell1111631 = new PdfPCell(new Paragraph(new Chunk("13.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			cell1111631 = new PdfPCell(new Paragraph(new Chunk(
					"Capacity of the Restaurant (not having lodging facility)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			cell1111631 = new PdfPCell(new Paragraph(new Chunk(
					": " + capacityN, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111631.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111631.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111631.setPadding(3.0f);
			cell1111631.setBorder(PdfPCell.NO_BORDER);
			cell1111631.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111631);

			document.add(space4);
			
			PdfPCell cell11119 = new PdfPCell();

			cell11119 = new PdfPCell(new Paragraph(new Chunk("B.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell11119.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11119.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11119.setPadding(3.0f);
			cell11119.setBorder(PdfPCell.NO_BORDER);
			cell11119.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11119);

			cell11119 = new PdfPCell(new Paragraph(new Chunk("Site Details ",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell11119.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11119.setVerticalAlignment(Element.ALIGN_LEFT);
			cell11119.setPadding(3.0f);
			cell11119.setColspan(2);
			cell11119.setBorder(PdfPCell.NO_BORDER);
			cell11119.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell11119);

			PdfPCell cell111191 = new PdfPCell();

			cell111191 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111191.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111191.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111191.setPadding(3.0f);
			cell111191.setBorder(PdfPCell.NO_BORDER);
			cell111191.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111191);

			cell111191 = new PdfPCell(
					new Paragraph(
							new Chunk(
									"Description of the location Residential/Commercial/Silence Zone/Sensitive Zone/Mixed category of any of the above (nme the category in case of mixed category) ",
									new Font(Font.TIMES_ROMAN,
											Font.DEFAULTSIZE, Font.NORMAL))));
			cell111191.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111191.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111191.setPadding(3.0f);
			cell111191.setBorder(PdfPCell.NO_BORDER);
			cell111191.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111191);

			cell111191 = new PdfPCell(new Paragraph(new Chunk(":" + locationN,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111191.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111191.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111191.setPadding(3.0f);
			cell111191.setBorder(PdfPCell.NO_BORDER);
			cell111191.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111191);

			PdfPCell cell111121 = new PdfPCell();

			cell111121 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111121.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111121.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111121.setPadding(3.0f);
			cell111121.setBorder(PdfPCell.NO_BORDER);
			cell111121.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111121);

			cell111121 = new PdfPCell(new Paragraph(new Chunk(
					"Distance from major water body (in meters)", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111121.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111121.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111121.setPadding(3.0f);
			cell111121.setBorder(PdfPCell.NO_BORDER);
			cell111121.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111121);

			cell111121 = new PdfPCell(new Paragraph(new Chunk(": " + distanceN,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111121.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111121.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111121.setPadding(3.0f);
			cell111121.setBorder(PdfPCell.NO_BORDER);
			cell111121.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111121);

			document.add(space4);
			
			PdfPCell cell1111921 = new PdfPCell();

			cell1111921 = new PdfPCell(new Paragraph(new Chunk("C.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell1111921.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111921.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111921.setPadding(3.0f);
			cell1111921.setBorder(PdfPCell.NO_BORDER);
			cell1111921.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111921);
			
			
			cell1111921 = new PdfPCell(new Paragraph(new Chunk("Water Aspects", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell1111921.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111921.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111921.setPadding(3.0f);
			cell1111921.setColspan(2);
			cell1111921.setBorder(PdfPCell.NO_BORDER);
			cell1111921.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111921);
						
			PdfPCell cell1111923 = new PdfPCell();

			cell1111923 = new PdfPCell(new Paragraph(new Chunk("1.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell1111923.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111923.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111923.setPadding(3.0f);
			cell1111923.setBorder(PdfPCell.NO_BORDER);
			cell1111923.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111923);
			
			cell1111923 = new PdfPCell(new Paragraph(new Chunk("Source of Water Supply", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111923.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111923.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111923.setPadding(3.0f);
			cell1111923.setColspan(2);
			cell1111923.setBorder(PdfPCell.NO_BORDER);
			cell1111923.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111923);
			
			cell1111923 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111923.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111923.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111923.setPadding(3.0f);
			cell1111923.setColspan(3);
			cell1111923.addElement(tableBrickStoneWaterReq);   
			cell1111923.setBorder(PdfPCell.NO_BORDER);
			cell1111923.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111923);
			
			PdfPCell cell111192 = new PdfPCell();

			cell111192 = new PdfPCell(new Paragraph(new Chunk("2.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111192.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111192.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111192.setPadding(3.0f);
			cell111192.setBorder(PdfPCell.NO_BORDER);
			cell111192.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111192);

			cell111192 = new PdfPCell(new Paragraph(new Chunk(
					"Daily Water Consumption(in litres) ", new Font(
							Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111192.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111192.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111192.setPadding(3.0f);
			cell111192.setColspan(2);
			cell111192.setBorder(PdfPCell.NO_BORDER);
			cell111192.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111192);
			
			PdfPTable table511 = new PdfPTable(2);
			table511.setWidthPercentage(100);
			PdfPCell cell511 = new PdfPCell();

			cell511 = new PdfPCell(new Paragraph(new Chunk("Consumption Type",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setVerticalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(1.0f);			
			cell511.setBorderColor(new Color(0, 0, 0));
			table511.addCell(cell511);

			cell511 = new PdfPCell(new Paragraph(new Chunk("Quantity (In Liters)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell511.setVerticalAlignment(Element.ALIGN_CENTER);
			cell511.setPadding(1.0f);			
			cell511.setBorderColor(new Color(0, 0, 0));
			table511.addCell(cell511);			
		
			for (int var2 = 0; var2 < hotelWaterConsumptionDetail.size(); var2++) {
				ArrayList al = (ArrayList) hotelWaterConsumptionDetail.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell511 = new PdfPCell(new Paragraph(a));
					cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell511.setPadding(5.0f);
					table511.addCell(cell511);

				}
			}			
						
			cell111192 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111192.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111192.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111192.setPadding(3.0f);
			cell111192.setColspan(3);
			cell111192.setBorder(PdfPCell.NO_BORDER);
			cell111192.addElement(table511);
			cell111192.setBorderColor(new Color(0, 0, 0));			
			table11.addCell(cell111192);				
			document.add(space4);			
			PdfPCell cell111193 = new PdfPCell();

			cell111193 = new PdfPCell(new Paragraph(new Chunk("D.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111193.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111193.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111193.setPadding(3.0f);
			cell111193.setBorder(PdfPCell.NO_BORDER);
			cell111193.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111193);

			cell111193 = new PdfPCell(new Paragraph(new Chunk(
					"Liquid/Solid Waste Generation details. ", new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.BOLD))));
			cell111193.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111193.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111193.setPadding(3.0f);
			cell111193.setColspan(2);
			cell111193.setBorder(PdfPCell.NO_BORDER);
			cell111193.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111193);

				
			PdfPTable table512 = new PdfPTable(4);
			table512.setWidthPercentage(100);
			PdfPCell cell512 = new PdfPCell();

			cell512 = new PdfPCell(new Paragraph(new Chunk("Type of Waste Generation",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell512.setVerticalAlignment(Element.ALIGN_CENTER);
			cell512.setPadding(1.0f);			
			cell512.setBorderColor(new Color(0, 0, 0));
			table512.addCell(cell512);

			cell512 = new PdfPCell(new Paragraph(new Chunk("Quantity of Waste(in TPA)",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell512.setVerticalAlignment(Element.ALIGN_CENTER);
			cell512.setPadding(1.0f);			
			cell512.setBorderColor(new Color(0, 0, 0));
			table512.addCell(cell512);
			
			cell512 = new PdfPCell(new Paragraph(new Chunk("Nature of Emission Generated",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell512.setVerticalAlignment(Element.ALIGN_CENTER);
			cell512.setPadding(1.0f);			
			cell512.setBorderColor(new Color(0, 0, 0));
			table512.addCell(cell512);
			
			cell512 = new PdfPCell(new Paragraph(new Chunk("Method of Disposal/Treatment",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell512.setVerticalAlignment(Element.ALIGN_CENTER);
			cell512.setPadding(1.0f);			
			cell512.setBorderColor(new Color(0, 0, 0));
			table512.addCell(cell512);

			for (int var2 = 0; var2 < hotelWasteEmissionDetail.size(); var2++) {
				ArrayList al = (ArrayList) hotelWasteEmissionDetail.get(var2);
				for (int var3 = 0; var3 < al.size(); var3++) {

					String a = (String) al.get(var3);
					cell512 = new PdfPCell(new Paragraph(a));
					cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell512.setPadding(5.0f);
					table512.addCell(cell512);

				}
			}		
			
			PdfPCell cell111197 = new PdfPCell();		
			
			cell111197 = new PdfPCell(new Paragraph(new Chunk("", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111197.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111197.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111197.setPadding(3.0f);
			cell111197.setColspan(3);
			cell111197.setBorder(PdfPCell.NO_BORDER);
			cell111197.addElement(table512);
			cell111197.setBorderColor(new Color(0, 0, 0));
			
			table11.addCell(cell111197);

			document.add(space4);			
			
			PdfPCell cell111181 = new PdfPCell();

			cell111181 = new PdfPCell(new Paragraph(new Chunk("E.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);

			cell111181 = new PdfPCell(new Paragraph(new Chunk("D.G Set Use",
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);

			cell111181 = new PdfPCell(new Paragraph(new Chunk(": " + dgSetN	+ "\n Capacity (in KVA): " + dgcapacity +  "   , Make: " + makeN,new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);						
			
			cell111181 = new PdfPCell(new Paragraph(new Chunk("F. ", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);
			
			cell111181 = new PdfPCell(new Paragraph(new Chunk("Whether N.O.C from Fire Department", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);
			
			cell111181 = new PdfPCell(new Paragraph(new Chunk(":"+nocObtained, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);			
			
			PdfPCell cell1111812 = new PdfPCell();

			cell1111812 = new PdfPCell(new Paragraph(new Chunk("G.", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
			
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("Pollution Control Measures", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("(a). If Septic Tank Provided?", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk(": "+septicTank, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
			
			
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("(b). If Soakage Pit Provided?", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk(": "+soakagePit, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
			
			
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("(c). If Sewage Treatment Plant Provided?", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk(": "+sewagePlant, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
			
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("(d). If Chimeny With Hoods Provided?", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk(": "+hotelchimeny, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
			
			
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("(e). If Exhaust Fans Provided?", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk(": "+exhaustFans, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk("(f). If Greenery/Plantation Provided?", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setColspan(2);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
						
			cell1111812 = new PdfPCell(new Paragraph(new Chunk(": "+greenery, new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell1111812.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1111812.setVerticalAlignment(Element.ALIGN_LEFT);
			cell1111812.setPadding(3.0f);
			cell1111812.setBorder(PdfPCell.NO_BORDER);
			cell1111812.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell1111812);
			
			cell111181 = new PdfPCell(new Paragraph(new Chunk("H. Other Pollution Prevention measures", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setColspan(2);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);

			cell111181 = new PdfPCell(new Paragraph(new Chunk(
					": " + prevention, new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.NORMAL))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);

			document.add(space4);
			
			cell111181 = new PdfPCell(new Paragraph(new Chunk("I. Any other relevent information(if any)", new Font(
					Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setColspan(2);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);

			cell111181 = new PdfPCell(new Paragraph(new Chunk(": " + relInfo,
					new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL))));
			cell111181.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell111181.setVerticalAlignment(Element.ALIGN_LEFT);
			cell111181.setPadding(3.0f);
			cell111181.setBorder(PdfPCell.NO_BORDER);
			cell111181.setBorderColor(new Color(0, 0, 0));
			table11.addCell(cell111181);

			document.add(space4);
			document.add(space4);
			document.add(table11);			

			Paragraph para1 = new Paragraph();
			para1.add(new Chunk("Declaration.", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			para1.setAlignment(Element.ALIGN_LEFT);
			document.add(para1);

			Paragraph para2 = new Paragraph();
			para2.add(new Chunk(
							"I/We "+ occupierName+ " do hereby declare that information given is true and correct. In case any information turns out to be false. I/We shall be liable to be treated as defaulters.",
							new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
									Font.NORMAL)));
			para2.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(para2);

			Paragraph para3 = new Paragraph();
			para3.add(new Chunk("Signature", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE + 0, Font.NORMAL)));
			para3.setAlignment(Element.ALIGN_RIGHT);
			document.add(para3);			
			document.add(space4);
			document.add(space4);
	}
		Paragraph partE1 = new Paragraph();
		partE1
				.add(new Chunk(
						"I. I/We further declare that the information furnished above is correct to the best of my/our knowledge.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
								Font.NORMAL)));
		partE1.setAlignment(Element.ALIGN_LEFT);
		document.add(partE1);
		document.add(space4);

		Paragraph partE12 = new Paragraph();
		partE12
				.add(new Chunk(
						"II. I/We hereby submit that in case of any change from is stated in this application in respect of raw materials products, process of manufacture and treatment and/or disposal of effluent, emissions, hazardous wastes etc. in quality and quantity; a fresh application for consent Authorization no change shall be made. ",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
								Font.NORMAL)));
		partE12.setAlignment(Element.ALIGN_LEFT);
		document.add(partE12);
		document.add(space4);

		Paragraph partE13 = new Paragraph();
		partE13.add(new Chunk(
						"III. I/We understand to furnish any other Information within given time of its being called by the Board/Committee.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
								Font.NORMAL)));
		partE13.setAlignment(Element.ALIGN_LEFT);
		document.add(partE13);
		document.add(space4);

		Paragraph partE14 = new Paragraph();
		partE14.add(new Chunk(
						"IV. I/We agree to the Board an application for renewal of consent/authorization in two months (60 days) in advance before the date of expiry of the consent/authorization validity period.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
								Font.NORMAL)));
		partE14.setAlignment(Element.ALIGN_LEFT);
		document.add(partE14);
		document.add(space4);
		java.util.List list= new ArrayList();
		String feeValue="Rs..";
		if(fee.size()>0){
		ArrayList feeList = (ArrayList) fee.get(0);
		feeValue=feeList.get(feeList.size() -1).toString();
		System.out.println("--fee size----"+ feeList.get(feeList.size() -1));
		}
				
		Paragraph partE15 = new Paragraph();
		partE15
				.add(new Chunk(
						"V. I/We enclose herewith a Demand Draft for Rs..."+feeValue+" drawn in favour of Member Secretary Jammu & Kashmir Pollution Control Committee as the fee for consent to establish/operate (fresh/renew/modernization/expansion)/DG Set/Hotel/Stone Crusher/Hot mix plants/Brick Kiln for a period upto....",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
								Font.NORMAL)));
		partE15.setAlignment(Element.ALIGN_LEFT);
		document.add(partE15);
		document.add(space4);
		
		document.add(tableFees);
		
		
		document.add(tableFees1);
		
		document.add(space4);
		
	/*	Paragraph partE146 = new Paragraph();
		partE146.add(new Chunk(
						"VI. The items left blank shall deemed to be considered as not applicable in the application form.",
						new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
								Font.NORMAL)));
		partE146.setAlignment(Element.ALIGN_LEFT);
		document.add(partE146);*/
		document.add(space4);

		PdfPTable table331 = new PdfPTable(2);
		table331.setWidthPercentage(100);
		PdfPCell cell331 = new PdfPCell();

		cell331 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("Yours faithfully,",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_LEFT);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("Place :" + occCity,
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("Signature :",
				new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0,
						Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("Dated :"
				+ dateOfSubmission, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("Name :"
				+ occupierName, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("Designation :"
				+ occupierDesignation, new Font(Font.TIMES_ROMAN,
				Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk(
				"Enclosures :", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		cell331 = new PdfPCell(new Paragraph(new Chunk("", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE + 0, Font.NORMAL))));
		cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setPadding(3.0f);
		cell331.setVerticalAlignment(Element.ALIGN_CENTER);
		cell331.setBorder(PdfPCell.NO_BORDER);
		cell331.setBorderColor(new Color(0, 0, 0));
		table331.addCell(cell331);

		document.add(table331);

		document.add(space4);

		Paragraph sp = new Paragraph();
		sp.add(new Chunk(" ", new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE)));
		document.add(sp);

		// ////////////////////////////////////////////////////////////////////////////////////////////

		for (int var2 = 0; var2 < listDocuments.size(); var2++) {
			ArrayList al = (ArrayList) listDocuments.get(var2);
			int count = 1;
			for (int var3 = 0; var3 < al.size(); var3++) {
				String a = (String) al.get(var3);
				Paragraph documents = new Paragraph();
				documents.add(new Chunk(+count + ".  " + a
						+ "     (As Attached)"));
				documents.add(new Chunk("  ", new Font(Font.TIMES_ROMAN,
						Font.DEFAULTSIZE - 1)));
				count = count + 1;

				document.add(documents);

			}
		}				
	document.close();
		

		return tempFile;
	}

}
