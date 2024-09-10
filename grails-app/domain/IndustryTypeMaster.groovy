class IndustryTypeMaster{
Long id
String industryType

int dashboard


static hasMany = [cities:IndCatMaster]
String toString(){
"$industryType"
}
static def constrains = {

}
}