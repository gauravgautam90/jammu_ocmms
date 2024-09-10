dataSource {   
	pooled = true
	GenXmlParser parser = new GenXmlParser()
	driverClassName = "org.postgresql.Driver"
	username="postgres"
//    password="postgres"  
  password="NIC" 
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
environments {
	development {
		dataSource {
			dbCreate = "update"
			
			   	url="jdbc:postgresql://localhost:5432/JKPCB_Scrutiny" // Deepak local
//			  	url="jdbc:postgresql://10.25.121.208:5432/Jammu_OCMMS"    //LIVE  old
//			    url="jdbc:postgresql://10.25.121.245:5432/JAMMU_TODAY" // test server
//              url="jdbc:postgresql://10.25.121.212:5432/Jammu_OCMMS" // Live now server   // DEEPAK  //new server shift
		}
	}
	
	production {
		dataSource {
		GenXmlParser parser = new GenXmlParser()
			dbCreate = "update"

		   
		          url="jdbc:postgresql://localhost:5432/JKPCB_Scrutiny" // Deepak local
//		    	  url="jdbc:postgresql://10.25.121.208:5432/Jammu_OCMMS" //live  old
//			      url="jdbc:postgresql://10.25.121.245:5432/JAMMU_TODAY" // test server
//                url="jdbc:postgresql://10.25.121.212:5432/Jammu_OCMMS" // Live now server   // DEEPAK  //new server shift
		
		}
	}
}