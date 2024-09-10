
class SampleHandoverController {
	def sessionFactory
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
       try{
    	params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ sampleHandoverInstanceList: SampleHandover.list( params ), sampleHandoverInstanceTotal: SampleHandover.count() ]
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }

    def show = {
    	try{
    	def sampleHandoverInstance = SampleHandover.get( params.id )

        if(!sampleHandoverInstance) {
            flash.message = "SampleHandover not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ sampleHandoverInstance : sampleHandoverInstance ] }
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }

    def delete = {
    	try{
    	def sampleHandoverInstance = SampleHandover.get( params.id )
        if(sampleHandoverInstance) {
            try {
                sampleHandoverInstance.delete()
                flash.message = "SampleHandover ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "SampleHandover ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "SampleHandover not found with id ${params.id}"
            redirect(action:list)
        }
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }

    def edit = {
    	try{
    	def sampleHandoverInstance = SampleHandover.get( params.id )

        if(!sampleHandoverInstance) {
            flash.message = "SampleHandover not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ sampleHandoverInstance : sampleHandoverInstance ]
        }
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }

    def update = {
    	try{
    	def sampleHandoverInstance = SampleHandover.get( params.id )
        if(sampleHandoverInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(sampleHandoverInstance.version > version) {
                    
                    sampleHandoverInstance.errors.rejectValue("version", "sampleHandover.optimistic.locking.failure", "Another user has updated this SampleHandover while you were editing.")
                    render(view:'edit',model:[sampleHandoverInstance:sampleHandoverInstance])
                    return
                }
            }
            sampleHandoverInstance.properties = params
            if(!sampleHandoverInstance.hasErrors() && sampleHandoverInstance.save()) {
                flash.message = "SampleHandover ${params.id} updated"
                redirect(action:show,id:sampleHandoverInstance.id)
            }
            else {
                render(view:'edit',model:[sampleHandoverInstance:sampleHandoverInstance])
            }
        }
        else {
            flash.message = "SampleHandover not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }

    def create = {
    	try{
    	def sampleHandoverInstance = new SampleHandover()
         def labList=GroupMaster.findAll("from GroupMaster as gm where gm.groupDesc='LAB' order By gm.groupName ")
        def typeOfSample=params.typeOfSample
        def sampleId=params.id
        sampleHandoverInstance.properties = params
        return ['sampleHandoverInstance':sampleHandoverInstance,labList:labList,typeOfSample:typeOfSample,sampleId:sampleId]
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }

    def save = {
    	try{
    	def sampleHandoverInstance = new SampleHandover(params)
        def sampleId=params.sampleId
        def sampleType=params.sampleType
      
        
        if(!sampleHandoverInstance.hasErrors() && sampleHandoverInstance.save()) {
            flash.message = "SampleHandover ${sampleHandoverInstance.id} created"
            	 if(sampleType=="WaterEffluent"){
                 	def waterInstance=Lab_WaterEffluentMonitoring.get(sampleId.toLong())
                 	waterInstance.completionStatus="completed"
                 		waterInstance.save()
                 }
            if(sampleType=="AmbientAirMonitoring"){
             	def airInstance=Lab_AmbientAirMonitoring.get(sampleId.toLong())
             	airInstance.completionStatus="completed"
             		airInstance.save()
             }
            def routeLab= new RouteLab()
        	def isRouted=routeLab.routeLabApp(sampleHandoverInstance)
     	 	if(sampleType=="WaterEffluent"){
    	 		flash.message = "Congrats! Your Sample Submitted successfully."
    	            
    	 		redirect(controller:'labPendingDetails',action:'labSampleDashBoard')
    	 		}else{
    	 			flash.message = "Congrats! Your Sample Submitted successfully."    
    	 			redirect(controller:'labPendingDetails',action:'labSampleDashBoard')
    	 		}
        }
        else {
            render(view:'create',model:[sampleHandoverInstance:sampleHandoverInstance])
        }
    }catch(Exception e){
        e.printStackTrace();
        flash.message = "Server is busy , please try after sometime";
           if(session.indUser){
                   redirect(controller:'indUser',action:'openIndustryHome')
               }else if(session.userMaster){
                   redirect(controller:'userMaster',action:'openSpcbHome');
               }else{
             	session.invalidate()
                   redirect(uri:'/index.gsp');
                   }
          }
    }
    
   
}