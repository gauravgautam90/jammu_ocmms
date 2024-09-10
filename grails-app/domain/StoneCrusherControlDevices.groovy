class StoneCrusherControlDevices
{
	Long id
	IndApplicationDetails application
	StoneCrusherControlDevicesMaster device
	String name
	String status
		
	String toString()
	{
		"$id"    
    }
	static def constraints = {}
}