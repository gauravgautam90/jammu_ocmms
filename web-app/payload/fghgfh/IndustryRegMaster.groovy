
class IndustryRegMaster {
	String indName
	IndTypeMaster indType
	IndCatMaster category
	String indStatus
	Date dateOfComm	String indRegNum	Long indCapInvt	String indAddress	Long indArea	String indCity	TehsilMaster tehsil	DistrictMaster district	String indPin	String indPhoneCode	String indPhoneNo	String indFaxCode	String indFaxNo	String indEmail	String occName	String occDesignation	String occAddress	String occCity	TehsilMaster occTehsil	DistrictMaster occDistrict	String occPin	String occPhoneCode	String occPhoneNo	String occFaxCode	String occFaxNo	String occMobile	String occEmail	Date dateCreated	String createdBy	Date lastUpdated	String updatedBy		String toString(){		"$indName : $id"	}		static mapping = {       id generator:'assigned'    }     	static def constrains = {			}		
}