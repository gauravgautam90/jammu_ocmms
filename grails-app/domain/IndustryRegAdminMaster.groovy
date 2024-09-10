

class IndustryRegAdminMaster {
	Long id
	String indName
	String dateOfComm
	String indRegNum
	Long indCapInvt
	String indAddress
	String plotNo
	String indCity
	TehsilMaster tehsil
	DistrictMaster district
	String indPin
	String indPhoneCode
	String indPhoneNo
	String indFaxCode
	String indFaxNo
	String indEmail
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	
	String toString(){
		"$indName ( $id )"
	}
	
	static mapping = {
    } 
    static def constraints = {
		indName(blank:false)
		indCapInvt(blank:false)
		indAddress(blank:false)
		indPin(blank:false)
		indPhoneCode(blank:false)
		indPhoneNo(blank:false)
		createdBy(nullable:false)
		updatedBy(nullable:false)
	}
	
	
}