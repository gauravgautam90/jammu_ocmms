/**
 * 
 */



/**
 * @author Richa
 *
 */
public class DisplayDocumentTagLib{

	 static namespace = "document"

		    def renderDocumentById = {
		 
		 attrs ->
			
	    	def name;
	        def documentInstance = ApplicationFileRecord.get(attrs.id)
	        if(!documentInstance){
	        	documentInstance = ApplicationDocuments.get(attrs.id)
	        }
	        if(!documentInstance){
	        	documentInstance = WasteManagementFile.get(attrs.id)
	        }
	        if(!documentInstance){
	        documentInstance = InspectionFormatReportFile.get(attrs.id)
	        }
	        if(!documentInstance){
		        documentInstance = HazardeousInspectionReportFile.get(attrs.id)
	        }
	        if(!documentInstance){
		        documentInstance = RiverMonitoringReportFile.get(attrs.id)
	        }
	        if(!documentInstance){
		        documentInstance = LabSampleDocuments.get(attrs.id)
	        }
	        
	        if(!documentInstance){
		        documentInstance = ManifestHazWasteDocuments.get(attrs.id)
	        }
	        def img = documentInstance.data
	        if(documentInstance){
	        	name=documentInstance.name
	        	if(name.length()>100){
	        		name=name.substring(0,20);
	        	}
	        }
	        if (!documentInstance.data){
	            response.sendError(404)
	            return;
	        }
	
//	        response.setContentType(documentInstance.extension)
	        response.setContentType( "application/pdf")
	        response.setHeader("Content-Disposition", "inline;filename=${name}")
	
	        OutputStream out = response.getOutputStream()
	        out << img
	        out.flush()
	        out.close()
	
	        return;
	    
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 /*attrs ->

		        def documentInstance = ApplicationFileRecord.get(attrs.id)
		
		        def img = documentInstance.data
		
		        if (!documentInstance.data || !documentInstance.description){
		            response.sendError(404)
		            return;
		        }
		
//		        response.setContentType(documentInstance.extension)
		        response.setContentType( "application/pdf")
		        response.setHeader("Content-Disposition", "inline;filename=${documentInstance.name}")
		
		        OutputStream out = response.getOutputStream()
		        out << img
		        out.flush()
		        out.close()
		
		        return;*/
		    }
	
}
