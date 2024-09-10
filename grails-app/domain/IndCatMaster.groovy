class IndCatMaster{
Long id
	String name
String description


static belongsTo = [industryType:IndustryTypeMaster]
String toString(){

"$name"
}
static def constraints = {
	
}
}