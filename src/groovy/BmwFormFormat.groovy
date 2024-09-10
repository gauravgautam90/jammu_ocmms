/**
 * 
 */

 import java.util.*
 import java.text.*

/**
 * @author Atul
 *
 */
public class BmwFormFormat{

	public void getBmwPdf(long bmwWasteId,String user){
		
		def bioMedicalWasteInstance=BioMedicalWaste.get(bmwWasteId)

		def investCap1 =  bioMedicalWasteInstance.industryRegMasterObj.indCapInvt

		def indSize
		String office
		def roleNameForpdf
		def grp
	
		
		def roleVsActList = RoleVsActivity.findAllByActivity(RoleActivityMaster.findByActivityCode("001"))
		
			for(int i=0;i<roleVsActList.size();i++){
    	if(((roleVsActList.get(i)).role).group == grp){
    		roleNameForpdf = (roleVsActList.get(i)).role.roleName
    	}
			}

	
		
						///////////////////////////////////////  Code for generating File Number /////////////////////////
def indApplInst=bioMedicalWasteInstance

def indRegInstance=IndustryRegMaster.get(indApplInst.industryRegMasterObj.id)

def districtOfiiceMasterInstance= ""



//added by sharvan start
def jurisdictionOfficeName=""
def sdfh = new SimpleDateFormat("dd/MM/yyyy");   
def fileNoArrayList=new ArrayList()
def fileNoString
def fileNoSize
def fileNoValue
def fileNo

		 

def activityAuthorizationSoughtFor = bioMedicalWasteInstance.activityAuthorizationSoughtFor
def phnCodeOfOccupier = indRegInstance.occPhoneCode
def phnOfOccupier = indRegInstance.occPhoneNo
def faxCodeOfOccupier = indRegInstance.occFaxCode
def faxOfOccupier = indRegInstance.occFaxNo
def emailOfOccupier = indRegInstance.occEmail
def applicantName = indRegInstance.occName


def applicantDesignation
if(indRegInstance.occDesignation=="Others"){
applicantDesignation=indRegInstance.otherOccDesignation
}else{
applicantDesignation=indRegInstance.occDesignation
}
def instutionName = indRegInstance.indName

def addressOfInd = indRegInstance.indAddress

def phnCodeOfInd = indRegInstance.indPhoneCode

def phnOfInd = indRegInstance.indPhoneNo

def faxCodeOfInd = indRegInstance.indFaxCode

def faxOfInd = indRegInstance.indFaxNo

def emailOfInd = indRegInstance.occEmail

//added by sharvan for mobile no 
def mobileNo=indRegInstance.occMobile

def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
def district = cat.district.districtName
def applFor12
def authorisationFor =bioMedicalWasteInstance.activityAuthorizationSoughtFor
def appliedFor=bioMedicalWasteInstance.authorisationAppliedFor
if(bioMedicalWasteInstance.authorisationAppliedFor=="renew"){
appliedFor="Renewal"
applFor12="BMW Renew"
}else{
appliedFor="Fresh"
applFor12="BMW Fresh"
}

def hcfType=bioMedicalWasteInstance.hcfType
def wasteFacilityStatus=bioMedicalWasteInstance.bmwfacility
def officeAddress=bioMedicalWasteInstance.bmwstatus
def wasteLocationAddress=bioMedicalWasteInstance.wastelocationaddress
def placeOfTreatment=""
def placeOfDisposal=""

 // new changes made by sharvan start from here
 def appNo=bioMedicalWasteInstance.id
def statusCteCto=bioMedicalWasteInstance.statusCteCto
def lat=bioMedicalWasteInstance.latitude
def longt=bioMedicalWasteInstance.longtitude
def detailsOfDirections=bioMedicalWasteInstance.detailsOfDirections
//Details Of HCF added by sharvan as per new rules
def outpatientsFacility=bioMedicalWasteInstance.outpatientsFacility
def inpatientsFacility=bioMedicalWasteInstance.inpatientsFacility
def noofbeds=bioMedicalWasteInstance.noofbeds
def noOfNonBeds=bioMedicalWasteInstance.noOfNonBeds
def noOfInOutPatients=bioMedicalWasteInstance.noOfInOutPatients
// Details Of CBMWTF added by sharvan as per new rules
def NoofHCF=bioMedicalWasteInstance.NoofHCF
def noOfBedsCbmwtf=bioMedicalWasteInstance.noOfBedsCbmwtf
def treatmentAndDisposal=bioMedicalWasteInstance.treatmentAndDisposal
def qtyOfBmwTreated=bioMedicalWasteInstance.qtyOfBmwTreated
def Jurisdictionalarea=bioMedicalWasteInstance.Jurisdictionalarea
def contingencyPlan=bioMedicalWasteInstance.contingencyPlan
//new changes ends here

//////////////// Table in PdF /////////////////
def anatomicalwaste=bioMedicalWasteInstance.anatomicalwaste
def animalwaste=bioMedicalWasteInstance.animalwaste
def biowaste=""
def wastesharp=""
def discardedwaste=bioMedicalWasteInstance.discardedwaste
def soiledwaste=bioMedicalWasteInstance.soiledwaste
def solidwaste=""

def chemicalSolidWaste=bioMedicalWasteInstance.chemicalSolidWaste
def chemicalLiquidWaste=bioMedicalWasteInstance.chemicalLiquidWaste
def discardedLinen=bioMedicalWasteInstance.discardedLinen
def otherClininLabWaste=bioMedicalWasteInstance.otherClininLabWaste
def contaminatedwaste=bioMedicalWasteInstance.contaminatedwaste
def wasteSharps=bioMedicalWasteInstance.wasteSharps
def glassWare=bioMedicalWasteInstance.glassWare
def metallicBodyImplants=bioMedicalWasteInstance.metallicBodyImplants

def liquidwaste=""

def ash=""
def chemicalwaste=""
def chemicalwaste1=""
def chemicalwaste2=""
def total1=bioMedicalWasteInstance.total1
def total2=""

////added by sharvan start
//table in pdf for screen 4 added by sharvan start from here
def incinrators=bioMedicalWasteInstance.incinrators
def incinratorsType=bioMedicalWasteInstance.incinratorsType
def plasmaPyrolysis=bioMedicalWasteInstance.plasmaPyrolysis
def plasmaPyrolysisType=bioMedicalWasteInstance.plasmaPyrolysisType
def autoclaves=bioMedicalWasteInstance.autoclaves
def autoclavesType=bioMedicalWasteInstance.autoclavesType
def microwave=bioMedicalWasteInstance.microwave
def microwaveType=bioMedicalWasteInstance.microwaveType
def hydroclave=bioMedicalWasteInstance.hydroclave
def hydroclaveType=bioMedicalWasteInstance.hydroclaveType
def shredders=bioMedicalWasteInstance.shredders
def shreddersType=bioMedicalWasteInstance.shreddersType
def needleTipCutter=bioMedicalWasteInstance.needleTipCutter
def needleTipCutterType=bioMedicalWasteInstance.needleTipCutterType
def sharpEncapsulation=bioMedicalWasteInstance.sharpEncapsulation
def sharpEncapsulationType=bioMedicalWasteInstance.sharpEncapsulationType
def deepBurial=bioMedicalWasteInstance.deepBurial
def deepBurialType=bioMedicalWasteInstance.deepBurialType
def chemDisinfection=bioMedicalWasteInstance.chemDisinfection
def chemDisinfectionType=bioMedicalWasteInstance.chemDisinfectionType
def anyOtherTretmntEquip=bioMedicalWasteInstance.anyOtherTretmntEquip
def anyOtherTretmntEquipType=bioMedicalWasteInstance.anyOtherTretmntEquipType
//table in pdf for screen 4 added by sharvan end here

////added by sharvan start
SimpleDateFormat formatNowYear = new SimpleDateFormat("dd/MM/yyyy");
def BMWApplicationDate=formatNowYear.format(bioMedicalWasteInstance.dateCreated)

///////////////////////////////// Endss////////////////////////////////////

///////////////////////////////////// Previous BMW Authorisation Details Table /////////////////////////////			
def hwPreviousAuthDetails = new ArrayList()	

def hwPreviousAuthDetailsList = BMWPreviousAuthorisationDetails.findAll("from BMWPreviousAuthorisationDetails s where s.indUser.id=? and s.wasteManagementFileId!='' order by to_date(Issued_date, 'dd/mm/yyyy') ",[bioMedicalWasteInstance.industryRegMasterObj.id])

for(int var33=0;var33<hwPreviousAuthDetailsList.size();var33++)
{
	def hwmPreviousAuthorisationList= new ArrayList()
	
	
    hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).BMWApplication_Date)
	hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).BMWAType)
	hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).AuthorisationNo)
	hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Issued_date)
	hwmPreviousAuthorisationList.add(hwPreviousAuthDetailsList.get(var33).Valid_date)
	

	hwPreviousAuthDetails.add(hwmPreviousAuthorisationList)
	
}	


//-----------------fees---------------------//

def feeList= new ArrayList()
def feeDetailsList=FeeBankDetailsBMW.findAllByApplication(bioMedicalWasteInstance)
println("feeDetailsList"+feeDetailsList)
for(int var2=0;var2<feeDetailsList.size();var2++)
{
	def feeDetails= new ArrayList()
	feeDetails.add(feeDetailsList.get(var2).bankName)
	feeDetails.add(feeDetailsList.get(var2).branch)
	feeDetails.add(feeDetailsList.get(var2).ddChequeNo)
	feeDetails.add(feeDetailsList.get(var2).date)
	feeDetails.add((feeDetailsList.get(var2).amount).toString())
	feeList.add(feeDetails)

}

 def onlineFee=new ArrayList()
 def onlineFeeList=BankTransactionDetailsBMW.findAll("from BankTransactionDetailsBMW bm where bm.bioApplication=? and bm.transactionStatus='S'",[bioMedicalWasteInstance])
    for(int var88=0;var88<onlineFeeList.size();var88++){
    	def onlineFeeDetails=new ArrayList()
    	onlineFeeDetails.add((onlineFeeList.get(var88).id).toString())
    	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    	String dateCreated1=sdf1.format(onlineFeeList.get(var88).dateCreated);
    	onlineFeeDetails.add(dateCreated1)
    	onlineFeeDetails.add((onlineFeeList.get(var88).amount).toString())
    	onlineFeeDetails.add("Successful")
    	onlineFee.add(onlineFeeDetails)
    }
    
    //----------------------end code----------------//
		
///////////////////////////////////// ENDSSSSSSSSSSSSS //////////////////////////////////////////// 



	
String str3 = district.toLowerCase();
char[] c3 = str3.toCharArray();
c3[0] = Character.toUpperCase(c3[0]);
district=c3.toString()

def listDoc= new ArrayList()

def applicationDocumentInstance=WasteManagementFile.findAll(" from WasteManagementFile apd where apd.applicationId=? and apd.typeOfFile='BMW Documents' and apd.applicationFor=? order by apd.id asc",[bioMedicalWasteInstance.id,applFor12])

for(int ig=0;ig<applicationDocumentInstance.size();ig++){
def boolCheck=false

if(listDoc.size()==0){

	listDoc.add(applicationDocumentInstance.get(ig))
}

for(int intCheck=0;intCheck<listDoc.size();intCheck++){

	if(listDoc[intCheck].description==(applicationDocumentInstance.get(ig)).description){

		boolCheck=true
	}
}
if(boolCheck==false){

	listDoc.add(applicationDocumentInstance.get(ig))
}
}
def listDocuments = new ArrayList()
listDocuments.add(listDoc.description)

		
      BmwPdfFileNewFormat  pdf = new BmwPdfFileNewFormat()

		
		File certFile1

 certFile1 = pdf.bmwPdfFunction(applicantName,applicantDesignation,instutionName,addressOfInd,phnCodeOfInd,phnOfInd,mobileNo,emailOfInd,authorisationFor,appliedFor,hcfType,
         wasteFacilityStatus,officeAddress,wasteLocationAddress,placeOfDisposal,statusCteCto,lat,longt,detailsOfDirections,outpatientsFacility,inpatientsFacility,noofbeds,
         noOfNonBeds,noOfInOutPatients,NoofHCF,noOfBedsCbmwtf,treatmentAndDisposal,
         qtyOfBmwTreated,Jurisdictionalarea,contingencyPlan,anatomicalwaste,animalwaste, soiledwaste,discardedwaste,chemicalSolidWaste,
         chemicalLiquidWaste,discardedLinen,otherClininLabWaste,contaminatedwaste,wasteSharps,glassWare,metallicBodyImplants,total1
         ,incinrators,incinratorsType,plasmaPyrolysis,plasmaPyrolysisType,autoclaves,autoclavesType,microwave,microwaveType,hydroclave,hydroclaveType,
         shredders,shreddersType,needleTipCutter,needleTipCutterType,sharpEncapsulation,sharpEncapsulationType,deepBurial,deepBurialType,chemDisinfection,chemDisinfectionType,anyOtherTretmntEquip,anyOtherTretmntEquipType,roleNameForpdf,listDocuments,hwPreviousAuthDetails,BMWApplicationDate,jurisdictionOfficeName,feeList,appNo,onlineFee)

		

		byte[] b = new byte[(int) certFile1.length()];
		
		FileInputStream fileInputStream = new FileInputStream(certFile1);
		fileInputStream.read(b);
		
		
		WasteManagementFile file1=new WasteManagementFile()
		def fileLength=certFile1.length()
		file1.applicationId = bioMedicalWasteInstance.id
		file1.size = fileLength / 1024  //f.getSize() 
		file1.extension ="pdf"//extractExtension( f )
		file1.data=b;
		file1.name="BmwForm.pdf"
		file1.description="BMW Application Form"
		file1.createdBy= user
		file1.updatedBy=user
		file1.typeOfFile="BmwForm"
		file1.applicationFor="BMW"
		file1.indreg=indRegInstance

		
		if(!file1.hasErrors() && file1.save(flush:true)) {
	       		println(" BmwForm file saved")
	       } else {
			file1.errors.each {
		   }
		}	
		
	

	
	}
	
}
