class GroupMaster{
	Long id
	String groupName
	String groupDesc
	OfficeMaster office
	Date dateCreated
	String createdBy
	Date lastUpdated
	String updatedBy
	String toString(){
		"$groupName($office)"
	}
	static def constraints = {
		groupName(unique:'office',blank:false)
		office(blank:false)
		createdBy(nullable:false)
		updatedBy(nullable:false)
	}
	static belongsTo = [office:OfficeMaster]
    static mapping = {
           //id generator:'assigned'
               office lazy : false
        }
}