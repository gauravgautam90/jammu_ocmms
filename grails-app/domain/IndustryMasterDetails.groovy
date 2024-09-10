/**
 * @author Prashant Sharma
 *
 */
public class IndustryMasterDetails{
	
	Long id
	//IndustryRegMasterClone indUserClone  
	IndustryRegMaster indUser   // FK of IndustryRegMaster
	
	/////////////
		String indName
	IndTypeMaster indType
	IndustryTypeMaster industryType
	IndCatMaster category
	String indStatus
	String dateOfComm
	String indRegNum
	Long indCapInvt
//	Long indNewCapInvt
//	Long indCapInvtLand
//	Long indCapInvtBuilding
	String siteArea
	String indAddress
	String plotNo
	String indCity
	TehsilMaster tehsil
	DistrictMaster district
	String indPin
	String indTypeOther
	String indPhoneCode
	String indPhoneNo
	String indFaxCode
	String indFaxNo
	String indEmail
	String occName
	String occDesignation
	String occAddress
	String occCity
	String occTehsil
	String occDistrict
	String occPin
	String occPhoneCode
	String occPhoneNo
	String occFaxCode
	String occFaxNo
	String occMobile
	String occEmail
	String statusOfAppl
	String nameAddressPartners
	String noOfEmp
	String shiftsIndustry
	String monitoring
	String nationality
	String expDate
	String expNoEmp
	String waterMonitoring
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	Date regDate
	String regAuthority
	String commMonth
	String industryScale
		
	String equipWithSepMeters
	String equipDGSet
	String treePlantDev
	String wasteMinDetail
	String underPubHearing
	String nearRiver
	String riverName
	String riverDist
	String nearResidCol
	String colPopulation
	String colLocation
	String colDistance
	String nearIndEstate
	String disposalSysProv
	String utilizeSys
	String proposalDetails
	String plotArea
	String builtUpArea
	Long totalProjectCost
	Long pollutionMonitoringCost
	String nonHwmProdName
	String landArea
	String prodCapacity
	String sewage
	String sewageState
	String treatedEffCapacity
	String hotelArea
	String totalPlotArea
	
	String conclution
	public IndustryMasterDetails(){
		conclution=" "
	}
	String toString(){
          "$id"    
	}
    static def constraints = {
    }	
}
