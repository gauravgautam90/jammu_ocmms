
class IndSurrounding {
	
	
	Long id
	SurroundingMaster surrounding
	String distance
	IndustryRegMaster industryReg   // FK  Industry_Reg_Master
	String description
	
	String toString(){
		"$id"
		}
	static def constraints = {
	
		surrounding(blank:false)
		distance(blank:false)
		industryReg(blank:false) 
	}
}