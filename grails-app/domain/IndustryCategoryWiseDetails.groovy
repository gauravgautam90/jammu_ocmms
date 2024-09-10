class IndustryCategoryWiseDetails{

Long id
String industryType
String indTypeId
String indRegId
String industryName
String indAddress
String mobileNo
String category
String operational
String closed
String complying
String nonComplying
String ccaExpiry
String lastAction
String ccaValidity
String indScale
boolean certificate
Date dateCreated
Date lastUpdated
String createdBy
String updatedBy
String scnNote
boolean scnDoc

////??? new fields
String direction
String colDirection
String legal
String underProcess		

String lastActionScn
String scnNoteScn
boolean scnDocScn
String directionScn
String colDirectionScn
String legalScn
String underProcessScn	

String industryTypeNew
String indTypeIdNew

String gpi
String ganga
String waterCourse

String district
String districtId

public IndustryCategoryWiseDetails(){
	
	indRegId="";
	indTypeId="";
	ccaValidity="";
	mobileNo="";
	category="";
	indAddress="";
	certificate = false;
	dateCreated = new Date()
	lastUpdated = new Date()
	scnNote="";
	scnDoc= false;
	createdBy="";
	updatedBy="";
	
	lastAction=""
		industryType=""
			underProcess="";
		legal="";
		colDirection="";
		direction="";
		
		 lastActionScn="";
		 scnNoteScn="";
		 scnDocScn  = false;
		 directionScn="";
		 colDirectionScn="";
		 legalScn="";
		 underProcessScn="";
		
		 industryTypeNew=""
			 indTypeIdNew = ""
		 
		  gpi="";
		  ganga="";
		  waterCourse="";
		  district = ""
			  districtId = ""
	
}


String toString(){
"$id"
}



static def constraints = {
	industryName(blank:false,unique:true)
}
}