import groovy.sql.*
import java.lang.Exception
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File
import java.io.FileInputStream
import java.lang.NumberFormatException
import java.util.*;
import java.text.*;
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile

class CessReturnController {
	
	def dataSource
	
	def index = { 
			 try {
	    			redirect(action:createSingle,params:params)
		 }catch(Exception e) {
	            e.printStackTrace();
				 flash.message = "Server Busy ..Please try after some time....";
				if(session.indUser){
			redirect(controller:'indUser',action:'openIndustryHome')
	 }
	 else if(session.userMaster){
	  redirect(controller:'userMaster',action:'openSpcbHome');
	 }else{
	        session.invalidate()
	        redirect(uri:'/index.gsp');
	 }
	   }
	}
	
	// the delete, save and update actions only accept POST requests
	static allowedMethods = [delete:'POST', save:'POST', update:'POST']
	
	def list = {
		 try {
			 params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
					[ cessReturnInstanceList: CessReturn.list( params ), cessReturnInstanceTotal: CessReturn.count() ]
				 }catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
					redirect(controller:'indUser',action:'openIndustryHome')
			 }
			 else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
			   }
	}
	
	def show = {
		 try {
				def cessReturnInstance = CessReturn.get( params.id )
					def industryRegId=cessReturnInstance.industryReg
					def checkFeesView=false
					if(cessReturnInstance.fees){
						checkFeesView=true
					}
					def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
					def check=true
					if(!cessReturnInstance) {
						flash.message = "CessReturn not found with id ${params.id}"
						redirect(action:createSingle)
					}
					else { return [ checkFeesView:checkFeesView,cessReturnInstance : cessReturnInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList,check:check]
					}
				
				 }catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
					redirect(controller:'indUser',action:'openIndustryHome')
			 }
			 else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
			   }
	}
	
def showComplete = {
		 try {
				
				def cessReturnInstance = CessReturn.get( params.id )
				def industryRegId=cessReturnInstance.industryReg
				def checkFeesView=false
				if(cessReturnInstance.fees){
					checkFeesView=true
				}
				def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
				if(!cessReturnInstance) {
					flash.message = "CessReturn not found with id ${params.id}"
					redirect(action:createSingle)
				}
				else { 
					flash.message = "Click Submit to send the Application"
					return [ checkFeesView:checkFeesView,cessReturnInstance : cessReturnInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList]
				
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def showCessSpcb = {
		 try {
				def feeCheck=false
				def check=false
				def forEdit=params.checkEdit
				if(forEdit=="true"){
					check=true
				}
				def cessReturnInstance = CessReturn.get( (params.id).toLong() )
				if(cessReturnInstance.assessmentOrder){
					feeCheck=true
				}
				def checkFeesView=false
				if(cessReturnInstance.fees){
					checkFeesView=true
				}
				def industryRegId=cessReturnInstance.industryReg
				def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
				if(!cessReturnInstance) {
					flash.message = "CessReturn not found with id ${params.id}"
					redirect(action:createSingle)
				}
				else { 
					render(view:'show',model:[ feeCheck:feeCheck,cessReturnInstance : cessReturnInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList,check:check,checkFeesView:checkFeesView])
				}
			}catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}

	def viewCessReturnPdf={
		 try {
				def cessReturnInstance = CessReturn.get(( params.appliLoc).toLong())
				def application1
				application1 = CessReturnFileRecord.findAll(" from CessReturnFileRecord as crf where crf.cessReturn=? and crf.typeOfFile='CessReturnDetails' order by crf.id desc",[cessReturnInstance],[max:1])
				if(application1){
					def application=application1[0]
					def applicationInstance = application
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationInstance.data )
				}
				else {
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def delete = {
		def cessReturnInstance = CessReturn.get( params.id )
		if(cessReturnInstance) {
			try {
				cessReturnInstance.delete()
				flash.message = "CessReturn ${params.id} deleted"
				redirect(action:list)
			}
			catch(org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "CessReturn ${params.id} could not be deleted"
				redirect(action:show,id:params.id)
			}
		}
		else {
			flash.message = "CessReturn not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit = {
		 try {
				def cessReturnInstance = CessReturn.get( params.id )
				if(!cessReturnInstance) {
					flash.message = "CessReturn not found with id ${params.id}"
					redirect(action:list)
				}
				else {
					return [ cessReturnInstance : cessReturnInstance ]
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def update = {
		 try {
				def cessReturnInstance = CessReturn.get( params.id )
				if(cessReturnInstance) {
					if(params.version) {
						def version = params.version.toLong()
						if(cessReturnInstance.version > version) {
							
							cessReturnInstance.errors.rejectValue("version", "cessReturn.optimistic.locking.failure", "Another user has updated this CessReturn while you were editing.")
							render(view:'edit',model:[cessReturnInstance:cessReturnInstance])
							return
						}
					}
					cessReturnInstance.properties = params
					if(!cessReturnInstance.hasErrors() && cessReturnInstance.save()) {
						flash.message = "CessReturn ${params.id} updated"
						redirect(action:show,id:cessReturnInstance.id)
					}
					else {
						render(view:'edit',model:[cessReturnInstance:cessReturnInstance])
					}
				}
				else {
					flash.message = "CessReturn not found with id ${params.id}"
					redirect(action:edit,id:params.id)
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }	
	}
	
	def create = {
		 try {
				def cessReturnInstance = new CessReturn()
				IndUser indUserInstance=(IndUser)session.indUser
				def induserQuery=IndUser.get(indUserInstance.id)
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def district=indRegInstanceGet.district.districtName
				cessReturnInstance.properties = params
				def sourceMaster = CessSourceConsumptionMaster.list()
				return ['cessReturnInstance':cessReturnInstance,indRegInstance:indRegInstance,district:district,sourceMaster:sourceMaster]
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
}
	
	def save = {
		 try {
				def cessReturnInstance = new CessReturn(params)
				if(!cessReturnInstance.hasErrors() && cessReturnInstance.save()) {
					flash.message = "CessReturn ${cessReturnInstance.id} created"
					redirect(action:show,id:cessReturnInstance.id)
				}
				else {
					render(view:'create',model:[cessReturnInstance:cessReturnInstance])
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def createSingle = {
		 try {
				def cessReturnInstance = new CessReturn()
				IndUser indUserInstance=(IndUser)session.indUser
				def induserQuery=IndUser.get(indUserInstance.id)
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def district=indRegInstanceGet.district.districtName
				cessReturnInstance.properties = params
				return ['cessReturnInstance':cessReturnInstance,indRegInstance:indRegInstance,district:district]
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
}
	
	def saveCreateSingle={
		 try {
				def checkingMonth=false
				def indID=(params.indRegId).toLong()
				def indRegInstance=IndustryRegMaster.get(indID)
				def cessReturnInstance = new CessReturn()
				def fromDate = "01"
					def fromMonth = params.FromMonth
					
					if (fromMonth=="January"){
						fromMonth = "01"
					}else if(fromMonth=="February"){
						fromMonth = "02"
					}else if(fromMonth=="March"){
						fromMonth = "03"
					}else if(fromMonth=="April"){
						fromMonth = "04"
					}else if(fromMonth=="May"){
						fromMonth = "05"
					}else if(fromMonth=="June"){
						fromMonth = "06"
					}else if(fromMonth=="July"){
						fromMonth = "07"
					}else if(fromMonth=="August"){
						fromMonth = "08"
					}else if(fromMonth=="September"){
						fromMonth = "09"
					}else if(fromMonth=="October"){
						fromMonth = "10"
					}else if(fromMonth=="November"){
						fromMonth = "11"
					}else if(fromMonth=="December"){
						fromMonth = "12"
					}
								
					def fromYear = params.FromYear
					String appliedFromDate = fromYear+"/"+fromMonth+"/"+fromDate
					def toMonth = params.ToMonth
					
					if (toMonth=="January"){
						toMonth = "01"
					}else if(toMonth=="February"){
						toMonth = "02"
					}else if(toMonth=="March"){
						toMonth = "03"
					}else if(toMonth=="April"){
						toMonth = "04"
					}else if(toMonth=="May"){
						toMonth = "05"
					}else if(toMonth=="June"){
						toMonth = "06"
					}else if(toMonth=="July"){
						toMonth = "07"
					}else if(toMonth=="August"){
						toMonth = "08"
					}else if(toMonth=="September"){
						toMonth = "09"
					}else if(toMonth=="October"){
						toMonth = "10"
					}else if(toMonth=="November"){
						toMonth = "11"
					}else if(toMonth=="December"){
						toMonth = "12"
					}
				def toYear = params.ToYear.toInteger()
					def toDate

					if(toMonth=="01"||toMonth=="03"||toMonth=="05"||toMonth=="07"||toMonth=="08"||toMonth=="10"||toMonth=="12"){
						toDate = "31"
					}else if (toMonth=="04"||toMonth=="06"||toMonth=="09"||toMonth=="11"){
						toDate = "30"
					}else if (toMonth=="02"){
						boolean isLeapYear = ((toYear % 4 == 0) && (toYear % 100 != 0) || (toYear % 400 == 0));

				        if (isLeapYear)
				        {
				        	toDate = "29"
				        } else
				        	toDate = "28"
					}
					String appliedToDate = toYear+"/"+toMonth+"/"+toDate
			def startDate1=appliedFromDate
			def endDate1=appliedToDate
			String monthYear
			def x
			def y
			def a
			def b
			def mon
			def mon1
			def yea
			def yea1
			def upperDisplay
			java.sql.Date upperDate
			java.sql.Date leastDate
				def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
				x = sdfh.parse(startDate1); //Date
				y = sdfh.parse(endDate1);
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				session.sqlDate=sqlDate
				session.sqlDate2=sqlDate2
				
				def abcd = (indRegInstance.id).toLong()
				def db = new Sql(dataSource) // Create a new instance of groovy.sql.Sql with the DB of the Grails app
				def checkFromDate = db.rows("SELECT cessdatecheck FROM cessReturnView where industry_reg_id='"+abcd+"' ORDER BY cessdatecheck DESC LIMIT 1");
		       def checkFromDate1 = db.rows("SELECT cessdatecheck FROM cessReturnView where industry_reg_id='"+abcd+"' ORDER BY cessdatecheck ASC LIMIT 1");
		       if(checkFromDate||checkFromDate1)
				{
		        String cessdatecheckSmall = checkFromDate1.cessdatecheck.toString()
				String year = cessdatecheckSmall.substring(1,5);
		        String month = cessdatecheckSmall.substring(6,8);
		        String day = cessdatecheckSmall.substring(9,11);
		        
				String lD = year+"/"+month+"/"+day
		        
		        def leastDate1 = lD
		        b = sdfh.parse(leastDate1)
				
				leastDate = new java.sql.Date(b.getTime())
				String cessdatecheckLarge = checkFromDate.cessdatecheck.toString()
				String year1 = cessdatecheckLarge.substring(1,5);
		        String month1 = cessdatecheckLarge.substring(6,8);
		        String day1 = cessdatecheckLarge.substring(9,11);
		        
				String uD = year1+"/"+month1+"/"+day1
		        
		        def upperDate1 = uD
		        a = sdfh.parse(upperDate1)
				upperDate = new java.sql.Date(a.getTime())
		       def upperMonth = month1
				
				if (upperMonth=="01"){
					upperMonth = "January"
				}else if(upperMonth=="02"){
					upperMonth = "February"
				}else if(upperMonth=="03"){
					upperMonth = "March"
				}else if(upperMonth=="04"){
					upperMonth = "April"
				}else if(upperMonth=="05"){
					upperMonth = "May"
				}else if(upperMonth=="06"){
					upperMonth = "June"
				}else if(upperMonth=="07"){
					upperMonth = "July"
				}else if(upperMonth=="08"){
					upperMonth = "August"
				}else if(upperMonth=="09"){
					upperMonth = "September"
				}else if(upperMonth=="10"){
					upperMonth = "October"
				}else if(upperMonth=="11"){
					upperMonth = "November"
				}else if(upperMonth=="12"){
					upperMonth = "December"
				}
				monthYear = upperMonth+"/"+year1
		       }
		       if(sqlDate>sqlDate2) {
					flash.message="Cess Applied From Month & Year should be Greater than Cess Applied To Month & Year"
									cessReturnInstance = new CessReturn()
								IndUser indUserInstance=(IndUser)session.indUser
								def induserQuery=IndUser.get(indUserInstance.id)
								def district=indRegInstance.district.districtName
								
								cessReturnInstance.properties = params
						render(view:'createSingle',model:['cessReturnInstance':cessReturnInstance,indRegInstance:indRegInstance,district:district])
					
				}
					else if(sqlDate <= upperDate || sqlDate2 <= upperDate || sqlDate <= leastDate){
					flash.message="You have already applied upto ${monthYear}"
						cessReturnInstance = new CessReturn()
					IndUser indUserInstance=(IndUser)session.indUser
					def induserQuery=IndUser.get(indUserInstance.id)
					def district=indRegInstance.district.districtName
					
					cessReturnInstance.properties = params
			render(view:'createSingle',model:['cessReturnInstance':cessReturnInstance,indRegInstance:indRegInstance,district:district])
					}
					else {
					cessReturnInstance.cessAppliedFromDate=sqlDate
					cessReturnInstance.cessAppliedToDate=sqlDate2
					def firstDayInteger=0
					def lastDayInteger=11
					if(params.firstDay){
						firstDayInteger=(params.firstDay).toInteger()
					}
					if(params.lastDay){
						lastDayInteger=(params.lastDay).toInteger()
					}
					if(firstDayInteger<lastDayInteger){
						cessReturnInstance.industryReg=indRegInstance
						IndUser indUserInstance=(IndUser)session.indUser
						cessReturnInstance.createdBy=(indUserInstance.id).toString()
						cessReturnInstance.updatedBy=(indUserInstance.id).toString()
						cessReturnInstance.completionStatus="Pending"
						cessReturnInstance.applicationStatus="In Progress"
						cessReturnInstance.assessmentIssue=false
						cessReturnInstance.assessmentOrder=false
						cessReturnInstance.fees=false
						cessReturnInstance.feesNotice=false
						cessReturnInstance.inspection=false
						cessReturnInstance.inspectionClose=false
						def checking=CessReturn.findAllByIndustryReg(indRegInstance)
						
						if(!checkingMonth){
							if(!cessReturnInstance.hasErrors() && cessReturnInstance.save()) {
								redirect(action:createPurposePage,id:cessReturnInstance.id)
							}
							else {
								render(view:'createSingle',model:[cessReturnInstance:cessReturnInstance])
							}
						}
					}else{
						flash.message="First Day reading cannot be more than Last Day reading."
						redirect(action:createSingle)
					}
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def createPurposePage={
		 try {
				IndUser indUserInstance =(IndUser)session.indUser
				def induserQuery=IndUser.get(indUserInstance.id)
				def indRegInstance=indUserInstance.industryRegMaster
				def indRegInstanceId=indRegInstance.id
				def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
				def sourceMaster = CessSourceConsumptionMaster.list()
				def cessReturnInstance=(params.id).toLong()
				def cessInstance=CessReturn.get(cessReturnInstance)
				def cessReturnDetailsInstance = new CessReturnDetails()
				cessReturnDetailsInstance.properties = params
				return ['cessReturnDetailsInstance':cessReturnDetailsInstance,sourceMaster:sourceMaster,cessInstance:cessInstance,indRegInstance:indRegInstance]
		 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def singleSavePurpose={
		 try {
				IndUser indUserInstance =(IndUser)session.indUser
				def industryReg=IndustryRegMaster.get((params.indRegId).toLong())
				def varCheck=false
				def varCheck2=false
				def cessReturnDetailsInstanceCOPY = new CessReturnDetails()
				def cessReturnInstanceValue=(params.cessInstanceId).toLong()
				def cessInstance=CessReturn.get(cessReturnInstanceValue)
				def indInstance=cessInstance.industryReg
				
				def sourceMaster = CessSourceConsumptionMaster.list()
				def start1
				def purposeParam=CessWaterConsumptionPurposeMaster.get((params.purpose).toLong())
				def cessReturnDetailsGLOBInstance = new CessReturnDetails()
				def waterSourceConsumptionMasterVariable
				for (int i=0;i<sourceMaster.size();i++){
					
					if(params[(sourceMaster.get(i)).source]=="on"){
						def cessReturnDetailsInstance = new CessReturnDetails()
						cessReturnDetailsInstance.cessReturn=cessInstance
						cessReturnDetailsInstance.waterConsumptionPurposeMaster=purposeParam
						cessReturnDetailsInstance.waterSourceConsumptionMaster=sourceMaster.get(i)
						def meter="meterWorking_"+sourceMaster.get(i).source
						def startRead="startReading_"+sourceMaster.get(i).source
						def endRead="endReading_"+sourceMaster.get(i).source
						def quant="quantity_"+sourceMaster.get(i).source
						def threeAvg="threeMonthQuantity_"+sourceMaster.get(i).source
						def rebateQt="rebateQuantity_"+sourceMaster.get(i).source
						
						def startReadingValue
						def endReadingValue
						def quantityValue
						def threeMonthQuantityValue
						def rebateQuantityValue
						
						if(params[startRead]!=null && params[startRead]!="" ){
							startReadingValue=params[startRead].toInteger()
						}else{
							startReadingValue=0
						}
						
						if(params[endRead]!=null && params[endRead]!="" ){
							endReadingValue=params[endRead].toInteger()
						}else{
							endReadingValue=0
						}
						
						if(params[quant]!=null && params[quant]!="" ){
							quantityValue=params[quant].toInteger()
						}else{
							quantityValue=0
						}
						
						if(params[threeAvg]!=null && params[threeAvg]!="" ){
							threeMonthQuantityValue=params[threeAvg].toInteger()
						}else{
							threeMonthQuantityValue=0
						}
						
						if(params[rebateQt]!=null && params[rebateQt]!="" ){
							rebateQuantityValue=params[rebateQt].toInteger()
						}else{
							rebateQuantityValue=0
						}
						cessReturnDetailsInstance.meterWorking=params[meter]
						cessReturnDetailsInstance.startReading=startReadingValue
						cessReturnDetailsInstance.endReading=endReadingValue
						cessReturnDetailsInstance.quantity=quantityValue
						cessReturnDetailsInstance.threeMonthWaterQtyAvg=threeMonthQuantityValue
						cessReturnDetailsInstance.qtyForWaterRebate=rebateQuantityValue
						cessReturnDetailsInstance.remarks=params.remarks
						
						def creatBy=(session.indUser).toString()
						cessReturnDetailsInstance.createdBy=creatBy
						cessReturnDetailsInstance.updatedBy=creatBy
						
						start1 = cessReturnDetailsInstance.startReading
						def remarks = cessReturnDetailsInstance.remarks				
						
						cessReturnDetailsGLOBInstance=cessReturnDetailsInstance
						if(!cessReturnDetailsInstance.hasErrors() && cessReturnDetailsInstance.save()) {
							cessReturnDetailsInstanceCOPY=cessReturnDetailsInstance
							varCheck2=true
							
							def unitOfWaterCon=cessInstance.totunitOfWaterConsumption
							cessInstance.totunitOfWaterConsumption=unitOfWaterCon+(endReadingValue-startReadingValue)
							def threeMonthWaterQty=cessInstance.threeMonthsAvgWaterConsumption
							cessInstance.threeMonthsAvgWaterConsumption=threeMonthWaterQty+threeMonthQuantityValue
							
							def quantOfWaterCon=cessInstance.totQuantityOfWaterConsumed
							cessInstance.totQuantityOfWaterConsumed=quantOfWaterCon+quantityValue
							def waterReb=cessInstance.totQuantityOfWaterRebate
							cessInstance.totQuantityOfWaterRebate=waterReb+rebateQuantityValue
							cessInstance.completionStatus=params.appStatus
							
							if(!cessInstance.hasErrors() && cessInstance.save()) {
								
							}
							else {
								render(view:'createSingle',model:[cessInstance:cessInstance])
							}
						}
						else {
							varCheck2=true
						}
						varCheck=true
						def cessDetailList=CessReturnDetails.findAll("from CessReturnDetails as cr where cr.cessReturn=?",[cessInstance])
					}
				}
				if(varCheck==false){
					def cessReturnDetailsInstance1 = new CessReturnDetails()
					cessReturnDetailsInstance1.properties = params
					flash.message="Please Select the source of water."
					render(view:'createPurposePage',model:['cessReturnDetailsInstance':cessReturnDetailsInstance1,sourceMaster:sourceMaster,cessInstance:cessInstance])
				}
				if(varCheck2==true){			
					
					if(params.appStatus=="completed"){
						
						redirect(action:showComplete,id:cessInstance.id)
					}else{
						def check = true
						flash.message="Your Application No. ${cessInstance?.id} is saved and available for future update..."
						redirect(action:show,id:cessInstance.id,params:[idCessDetails:cessReturnDetailsGLOBInstance.id,,check:check] )    
					}
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def savePurpose={
		 try {
				def varCheck=false
				def varCheck2=false
				def cessReturnDetailsInstanceCOPY = new CessReturnDetails()
				def cessReturnInstanceValue=(params.cessInstanceId).toLong()
				def cessInstance=CessReturn.get(cessReturnInstanceValue)
				def sourceMaster = CessSourceConsumptionMaster.list()
				def purposeParam=CessWaterConsumptionPurposeMaster.get((params.purpose).toLong())
				def waterSourceConsumptionMasterVariable
				for (int i=0;i<sourceMaster.size();i++){
					if(params[(sourceMaster.get(i)).source]=="on"){
						def cessReturnDetailsInstance = new CessReturnDetails()
						cessReturnDetailsInstance.cessReturn=cessInstance
						cessReturnDetailsInstance.waterConsumptionPurposeMaster=purposeParam
						cessReturnDetailsInstance.waterSourceConsumptionMaster=sourceMaster.get(i)
						def meter="meterWorking_"+sourceMaster.get(i).source
						def startRead="startReading_"+sourceMaster.get(i).source
						def endRead="endReading_"+sourceMaster.get(i).source
						def quant="quantity_"+sourceMaster.get(i).source
						def threeAvg="threeMonthQuantity_"+sourceMaster.get(i).source
						def rebateQt="rebateQuantity_"+sourceMaster.get(i).source
						def startReadingValue
						def endReadingValue
						def quantityValue
						def threeMonthQuantityValue
						def rebateQuantityValue
						
						if(params[startRead]!=null && params[startRead]!="" ){
							startReadingValue=params[startRead].toInteger()
						}else{
							startReadingValue=0
						}
						if(params[endRead]!=null && params[endRead]!="" ){
							endReadingValue=params[endRead].toInteger()
						}else{
							endReadingValue=0
						}
						if(params[quant]!=null && params[quant]!="" ){
							quantityValue=params[quant].toInteger()
						}else{
							quantityValue=0
						}
						
						if(params[threeAvg]!=null && params[threeAvg]!="" ){
							threeMonthQuantityValue=params[threeAvg].toInteger()
						}else{
							threeMonthQuantityValue=0
						}
						if(params[rebateQt]!=null && params[rebateQt]!="" ){
							rebateQuantityValue=params[rebateQt].toInteger()
						}else{
							rebateQuantityValue=0
						}
						cessReturnDetailsInstance.meterWorking=params[meter]
						cessReturnDetailsInstance.startReading=startReadingValue
						cessReturnDetailsInstance.endReading=endReadingValue
						cessReturnDetailsInstance.quantity=quantityValue
						cessReturnDetailsInstance.threeMonthWaterQtyAvg=threeMonthQuantityValue
						cessReturnDetailsInstance.qtyForWaterRebate=rebateQuantityValue
						cessReturnDetailsInstance.remarks=params.remarks
						
						cessReturnDetailsInstance.remarks=params.remarks
						def creatBy=(session.indUser).toString()
						cessReturnDetailsInstance.createdBy=creatBy
						cessReturnDetailsInstance.updatedBy=creatBy
						
						if(!cessReturnDetailsInstance.hasErrors() && cessReturnDetailsInstance.save()) {
							cessReturnDetailsInstanceCOPY=cessReturnDetailsInstance
							varCheck2=true
							def unitOfWaterCon=cessInstance.totunitOfWaterConsumption
							cessInstance.totunitOfWaterConsumption=unitOfWaterCon+(endReadingValue-startReadingValue)
							def threeMonthWaterQty=cessInstance.threeMonthsAvgWaterConsumption
							cessInstance.threeMonthsAvgWaterConsumption=threeMonthWaterQty+threeMonthQuantityValue
							
							def quantOfWaterCon=cessInstance.totQuantityOfWaterConsumed
							cessInstance.totQuantityOfWaterConsumed=quantOfWaterCon+quantityValue
							
							def waterReb=cessInstance.totQuantityOfWaterRebate
							cessInstance.totQuantityOfWaterRebate=waterReb+rebateQuantityValue
							
							if(!cessInstance.hasErrors() && cessInstance.save()) {
							}
							else {
								render(view:'createSingle',model:[cessInstance:cessInstance])
							}
						}
						else {
							varCheck2=true
						}
						varCheck=true
					}
				}
				if(varCheck==false){
					flash.message="Please Select the source of water."
					render (view:createPurposePage,model:['cessReturnDetailsInstance':cessReturnDetailsInstanceCOPY,sourceMaster:sourceMaster,cessInstance:cessInstance])
				}
				if(varCheck2==true){
					redirect(action:createPurposePage,,id:cessInstance.id)
				}
			}
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	def cessIndustryCompletedList={
		 try {
				if(session.indUser){
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=indUserInstance.industryRegMaster
					def indRegFinalInstanceId=indRegInstance.id
					def indRegFinalInstance=IndustryRegMaster.get(indRegFinalInstanceId)
					def cessList=CessReturn.findAll("from CessReturn as cr where cr.industryReg=? and cr.completionStatus='Pending' order by cr.id desc",[indRegFinalInstance])
					def cessListCompleted=CessReturn.findAll("from CessReturn as cr where cr.industryReg=? and cr.completionStatus='completed' order by cr.id desc",[indRegFinalInstance])
				return ['cessList':cessList,cessListCompleted:cessListCompleted]
				}else{
					flash.message="Session Expires! Please Login Again"
					redirect(uri:"/index.gsp")
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def cessNotices={
		 try {
				if(session.indUser){
					IndUser indUserInstance=(IndUser)session.indUser
					def indRegInstance=indUserInstance.industryRegMaster
					def indRegFinalInstanceId=indRegInstance.id
					def indRegFinalInstance=IndustryRegMaster.get(indRegFinalInstanceId)
					def noticeList=CessFileRecord.findAllByIndreg(indRegFinalInstance,[ sort:"dateCreated", order:"desc"])
					return ['noticeList':noticeList]
				}else{
					flash.message="Session Expires! Please Login Again"
					redirect(uri:"/index.gsp")
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
}
	
	def editPageCessReturn={
		 try {
				def cessReturnId=(params.cessReturnId).toLong()
				def cessReturnInstance=CessReturn.get(cessReturnId)
				def cessReturnDetailsList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
				cessReturnInstance.totunitOfWaterConsumption=0
				cessReturnInstance.threeMonthsAvgWaterConsumption=0
				cessReturnInstance.totQuantityOfWaterConsumed=0
				cessReturnInstance.totQuantityOfWaterRebate=0
				cessReturnInstance.save()
				if(cessReturnDetailsList){
					for(int i=0;i<cessReturnDetailsList.size();i++){
						cessReturnDetailsList[i].delete()
					}
				}
				redirect(action:createPurposePage,id:cessReturnInstance.id)
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def submitReturn={
		 try {
				CessReturnFileRecord file=new CessReturnFileRecord()
				File certFile
				CessPdfFile pdf = new CessPdfFile()
				def cessReturnId=(params.cessReturnId).toLong()
				def cessReturnInstance=CessReturn.get(cessReturnId)
				def cess = new CessReturn()
				IndUser indUserInstance =(IndUser)session.indUser
				def industryReg=IndustryRegMaster.get((params.indRegId).toLong())
				cessReturnInstance.completionStatus="completed"
				
				if(cessReturnInstance.save()){
					def routeCess= new RouteCess()
					def isRouted=routeCess.routeCessApp(cessReturnInstance)
					def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
					def indname = cessReturnInstance.industryReg.indName
					def indcity = cessReturnInstance.industryReg.indCity
					def indaddress = cessReturnInstance.industryReg.indAddress
					def indpin = cessReturnInstance.industryReg.indPin
					def indplot = cessReturnInstance.industryReg.plotNo
					def inddistrict = cessReturnInstance.industryReg.district.districtName
					def firstRead = cessReturnInstance.firstDayReading
					def LastRead = cessReturnInstance.lastDayReading
					def yr=((cessReturnInstance.cessAppliedFromDate).getYear()+1900).toString()
					def mon=((cessReturnInstance.cessAppliedFromDate).getMonth()+1).toString()
					
					if (mon=="1"){
						mon = "January"
					}else if(mon=="2"){
						mon = "February"
					}else if(mon=="3"){
						mon = "March"
					}else if(mon=="4"){
						mon = "April"
					}else if(mon=="5"){
						mon = "May"
					}else if(mon=="6"){
						mon = "June"
					}else if(mon=="7"){
						mon = "July"
					}else if(mon=="8"){
						mon = "August"
					}else if(mon=="9"){
						mon = "September"
					}else if(mon=="10"){
						mon = "October"
					}else if(mon=="11"){
						mon = "November"
					}else if(mon=="12"){
						mon = "December"
					}
					
					def fromDate=mon+"/"+yr
					def yr1=((cessReturnInstance.cessAppliedToDate).getYear()+1900).toString()
					def mon1=((cessReturnInstance.cessAppliedToDate).getMonth()+1).toString()
					
					if (mon1=="1"){
						mon1 = "January"
					}else if(mon1=="2"){
						mon1 = "February"
					}else if(mon1=="3"){
						mon1 = "March"
					}else if(mon1=="4"){
						mon1 = "April"
					}else if(mon1=="5"){
						mon1 = "May"
					}else if(mon1=="6"){
						mon1 = "June"
					}else if(mon1=="7"){
						mon1 = "July"
					}else if(mon1=="8"){
						mon1 = "August"
					}else if(mon1=="9"){
						mon1 = "September"
					}else if(mon1=="10"){
						mon1 = "October"
					}else if(mon1=="11"){
						mon1 = "November"
					}else if(mon1=="12"){
						mon1 = "December"
					}
					def toDate=mon1+"/"+yr1
					def totunitOfWaterConsumption = cessReturnInstance.totunitOfWaterConsumption
					def threeMonthsAvgWaterConsumption = cessReturnInstance.threeMonthsAvgWaterConsumption
					def totQuantityOfWaterConsumed = cessReturnInstance.totQuantityOfWaterConsumed
					def totQuantityOfWaterRebate = cessReturnInstance.totQuantityOfWaterRebate
					def details = new ArrayList()
					def cessDetails = new ArrayList()
					for(int var=0;var<cessDetailList.size();var++) {
						details.add((cessDetailList.get(var)).waterConsumptionPurposeMaster.purpose)
						details.add((cessDetailList.get(var)).waterSourceConsumptionMaster.source)
						details.add((cessDetailList.get(var)).startReading.toString())
						details.add((cessDetailList.get(var)).endReading.toString())
						details.add((cessDetailList.get(var)).quantity.toString())
						details.add((cessDetailList.get(var)).threeMonthWaterQtyAvg.toString())
						details.add((cessDetailList.get(var)).qtyForWaterRebate.toString())
						details.add((cessDetailList.get(var)).remarks)
					}
					cessDetails.add(details)
					certFile = pdf.cessPdfFunction(indname,indcity,inddistrict,indaddress,indpin,indplot,fromDate,toDate,cessDetails)
					byte[] b = new byte[(int) certFile.length()]
					FileInputStream fileInputStream = new FileInputStream(certFile)
					fileInputStream.read(b)
					def fileLength=certFile.length()
					file.size = fileLength / 1024  //f.getSize() 
					
					file.extension ="pdf"//extractExtension( f )
					file.data=b;
					file.description="Cess_Return_Details  Saved"
					file.name="CessForm.pdf"
					file.createdBy=session.indUser
					file.updatedBy=session.indUser
					file.typeOfFile="CessReturnDetails"
					file.indreg=industryReg
					file.cessReturn=cessReturnInstance
					file.cessAppliedFromDate=session.sqlDate
					file.cessAppliedToDate=session.sqlDate2
					if(file.save()) {
						flash.message = "Water Cess Pay in slip is generated properly."
					}
					else{
						flash.message = "Water Cess Pay in slip is not generated properly."
					}
					
				}
				def industryRegId=cessReturnInstance.industryReg
				def checkFeesView=false
				if(cessReturnInstance.fees){
					checkFeesView=true
				}
				def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
				def check = false
				flash.message="Congratulations! Application No. ${cessReturnInstance} submitted successfully."
				render(view:'show',model:[ checkFeesView:checkFeesView,cessReturnInstance : cessReturnInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList,check:check] )
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}

	def viewAssessOrder={
		 try {
				def cessReturnInstance=CessReturn.get((params.appliId).toLong())
				def application1 = CessReturnFileRecord.findAll(" from CessReturnFileRecord as crf where crf.cessReturn=? and crf.typeOfFile='AssessmentOrder' order by crf.id desc",[cessReturnInstance],[max:1])
				if(application1){
					def application=application1[0]
					def applicationFileSingleInstance=application
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				}else{
				}
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def viewAssessIssue={
		 try {
				def cessReturnInstance=CessReturn.get((params.appliId).toLong())
				def application1 = CessReturnFileRecord.findAll(" from CessReturnFileRecord as crf where crf.cessReturn=? and crf.typeOfFile='AssessmentIssue' order by crf.id desc",[cessReturnInstance],[max:1])
				if(application1){
					def application=application1[0]
					def applicationFileSingleInstance=application
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				}else{
				}	
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def viewFeesDefauterNotice={
		 try {
				def cessReturnInstance=CessReturn.get((params.appliId).toLong())
				def application1 = CessReturnFileRecord.findAll(" from CessReturnFileRecord as crf where crf.cessReturn=? and crf.typeOfFile='feeDefaulterNotice' order by crf.id desc",[cessReturnInstance],[max:1])
				if(application1){
					def application=application1[0]
					def applicationFileSingleInstance=application
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
				}else{
				}	
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def sendingFeeDetails={
		 try {
				def idAppl= (params.appliId).toLong()
				def cessReturnInstance=CessReturn.get(idAppl)
				def industryReg=cessReturnInstance.industryReg
				return ['industryReg':industryReg,cessReturnInstance:cessReturnInstance]
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def generateFeeDetails={
		 try {
				CessFeeDetails cessfee=new CessFeeDetails()
				CessPaySlipDetails cessPaySlipInstance = new CessPaySlipDetails()
				
				File certFile
				CessReturnFileRecord file=new CessReturnFileRecord()
				
				def industryReg=IndustryRegMaster.get((params.idIndReg).toLong())
				def idCessReturn=(params.idCessreturn).toLong()
				def cessInstance=CessReturn.get(idCessReturn)
				def grantedFromDateCheck=params.waterCessAssessmentOrderFrom_value+""
				def grantedToDateCheck=params.waterCessAssessmentOrderTo_value+""
				def waterCessDateCheck=params.waterCessDate_value+""
				def demandDraftDateCheck=params.draftChequeDate_value+""
				def checkDate
				def x
				def y
				def p
				def q
				try {
					def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
					x = sdfh.parse(grantedFromDateCheck); //Date
					y = sdfh.parse(grantedToDateCheck);
					p = sdfh.parse(waterCessDateCheck);
					q = sdfh.parse(demandDraftDateCheck);
					
					checkDate="checked"
				}
				catch(Exception e) {
				}
				java.sql.Date sqlDate = new java.sql.Date(x.getTime())
				java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())	
				java.sql.Date sqlDatep = new java.sql.Date(p.getTime())
				java.sql.Date sqlDateq = new java.sql.Date(q.getTime())
				
				if(sqlDate>sqlDate2) {
					flash.message="Assesment Order To Date should be Greater than Assesment Order From Date"
					redirect(action:"sendingFeeDetails", params:[appliId:idCessReturn])
					
				}else if(sqlDate2 > new Date()){
					flash.message="Assesment Order To Date should be less than current date."
					redirect(action:"sendingFeeDetails", params:[appliId:idCessReturn])
					
				}else if(sqlDatep > new Date()){
					flash.message="Cess Pay in slip Date cannot be greater than current date."
					redirect(action:"sendingFeeDetails", params:[appliId:idCessReturn])
					
				}else if(sqlDateq > new Date()){
					flash.message="Demand Draft Date cannot be greater than current date."
					redirect(action:"sendingFeeDetails", params:[appliId:idCessReturn])
					
				}
				else{
					def feeCheck=false
					def checkForEdit=false
					def forEdit=params.checkEdit
					if(forEdit=="true"){
						checkForEdit=true
					}
					if(cessInstance.assessmentOrder){
						feeCheck=true
					}
					def industryRegId=cessInstance.industryReg
					def cessDetailList=CessReturnDetails.findAllByCessReturn(cessInstance)
					def checkFeesView=false
					if(cessInstance.fees){
						checkFeesView=true
						flash.message = "Water Cess Pay in slip is already submitted."
						render(view:'show',model:[ checkFeesView:checkFeesView,feeCheck:feeCheck,cessReturnInstance : cessInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList,checkForEdit:checkForEdit])
					}else{
						def industryName=industryReg.indName+""
						def industryPlot=industryReg.plotNo+""
						def industryAddress=industryReg.indAddress+""
						def industryTehsil=industryReg.tehsil.tehsilName+""
						def industryDistrict=industryReg.district.districtName+""
						def nameOfDistrict=params.nameOfDistrict
						def waterCessDate=params.waterCessDate_value
						def fromDate1=params.fromDate
						def toDate1=params.toDate
						def offAddres=params.offAddres
						def codeNumber=params.codeNumber
						def demandDraftRupees=params.demandDraftRupees
						def demandDraftDate=params.draftChequeDate_value
						def demandDraftNo=params.demandDraftNo
						def cessFeeDate=params.waterCessDate_value
						
						def waterCessAssessmentOrderNo=params.waterCessAssessmentOrderNo
						def waterCessAssessmentOrderDate=params.waterCessAssessmentOrderDate_value
						def waterCessAssessmentOrderFrom=params.waterCessAssessmentOrderFrom_value
						def waterCessAssessmentOrderTo=params.waterCessAssessmentOrderTo_value
						def waterCessAssessmentOrderAmount=params.waterCessAssessmentOrderAmount
						def waterCessAssessmentOrderRemarks=params.waterCessAssessmentOrderRemarks
						
						def interestAssessmentOrderNo=params.interestAssessmentOrderNo
						def interestAssessmentOrderDate=params.interestAssessmentOrderDate_value
						def interestAssessmentOrderFrom=params.interestAssessmentOrderFrom_value
						def interestAssessmentOrderTo=params.interestAssessmentOrderTo_value
						def interestAssessmentOrderAmount=params.interestAssessmentOrderAmount
						def interestAssessmentOrderRemarks=params.interestAssessmentOrderRemarks
						
						def penaltyAssessmentOrderNo=params.penaltyAssessmentOrderNo
						def penaltyAssessmentOrderDate=params.penaltyAssessmentOrderDate_value
						def PenaltyAssessmentOrderFrom=params.PenaltyAssessmentOrderFrom_value
						def penaltyAssessmentOrderTo=params.penaltyAssessmentOrderTo_value
						def penaltyAssessmentOrderAmount=params.penaltyAssessmentOrderAmount
						def penaltyAssessmentOrderRemarks=params.penaltyAssessmentOrderRemarks
						
						def otherMiscAssessmentOrderNo=params.otherMiscAssessmentOrderNo
						def otherMiscAssessmentOrderDate=params.otherMiscAssessmentOrderDate_value
						def otherMiscAssessmentOrderFrom=params.otherMiscAssessmentOrderFrom_value
						def otherMiscAssessmentOrderTo=params.otherMiscAssessmentOrderTo_value
						def otherMiscAssessmentOrderAmount=params.otherMiscAssessmentOrderAmount
						def otherMiscAssessmentOrderRemarks=params.otherMiscAssessmentOrderRemarks
						
						def totalMoney=params.totalMoney
						def rupeesInWords=params.rupeesInWords 
						def cessStartDate=params.cessFromDate
			       		def cessEndDate=params.cessToDate
			       		def sdfh = new SimpleDateFormat("yyyy/MM/dd"); 
			    		def a
			    		def b1
			    		java.sql.Date upperDate
			    		java.sql.Date leastDate
			    		
			    		String year = cessStartDate.substring(0,4);
			            String month = cessStartDate.substring(5,7);
			            String day = cessStartDate.substring(8,10);
			         		
			    		String lD = year+"/"+month+"/"+day
			            
			            def leastDate1 = lD
			            b1 = sdfh.parse(leastDate1)
			    		        
			    		leastDate = new java.sql.Date(b1.getTime())
			    		
			    		String year1 = cessEndDate.substring(0,4);
			            String month1 = cessEndDate.substring(5,7);
			            String day1 = cessEndDate.substring(8,10);
			              		
			    		String uD = year1+"/"+month1+"/"+day1
			           
			            def upperDate1 = uD
			            a = sdfh.parse(upperDate1)
			    		        
			    		upperDate = new java.sql.Date(a.getTime())
			    						
						def totRupeesNum=waterCessAssessmentOrderAmount.toLong()+interestAssessmentOrderAmount.toLong()+penaltyAssessmentOrderAmount.toLong()+otherMiscAssessmentOrderAmount.toLong()
						def totRupees=totalMoney+""	
						def cessFeeDate1
				    	def demandDraftDate1 
				    	def waterCessAssessmentDate1 
				    	def waterCessAssessmentFrom1 
				    	def waterCessAssessmentTo1
				    	
				    	try{
				    		def sdfh1 = new SimpleDateFormat("dd/MM/yyyy")
				    		cessFeeDate1 = sdfh1.parse(cessFeeDate)
				    		demandDraftDate1 = sdfh1.parse(demandDraftDate)
				    		waterCessAssessmentDate1 = sdfh1.parse(waterCessAssessmentOrderDate)
				    		waterCessAssessmentFrom1 = sdfh1.parse(waterCessAssessmentOrderFrom)
				    		waterCessAssessmentTo1 = sdfh1.parse(waterCessAssessmentOrderTo)
				    		
				    	}
						catch(Exception e)
						{
							
						}
				    	java.sql.Date cessPaySlipDate = new java.sql.Date(cessFeeDate1.getTime())
				    	java.sql.Date ddDate = new java.sql.Date(demandDraftDate1.getTime())
				    	java.sql.Date waterCessAssessmentOrderDate1 = new java.sql.Date(waterCessAssessmentDate1.getTime())
				    	java.sql.Date waterCessAssessmentOrderFrom1 = new java.sql.Date(waterCessAssessmentFrom1.getTime())
				    	java.sql.Date waterCessAssessmentOrderTo1 = new java.sql.Date(waterCessAssessmentTo1.getTime())
				    	 cessPaySlipInstance.cessPaySlipDate = cessPaySlipDate
				       cessPaySlipInstance.ddDate = ddDate
				       cessPaySlipInstance.indreg = industryReg
				       cessPaySlipInstance.cessReturn = cessInstance
				       cessPaySlipInstance.ddNo = demandDraftNo
				       cessPaySlipInstance.ddAmount = demandDraftRupees
				       cessPaySlipInstance.waterCessAssesmentNo = waterCessAssessmentOrderNo
					   cessPaySlipInstance.interestAssesmentNo = interestAssessmentOrderNo
					   cessPaySlipInstance.penalityAssesmentNo = penaltyAssessmentOrderNo
					   cessPaySlipInstance.otherAssesmentNo = otherMiscAssessmentOrderNo
					   cessPaySlipInstance.waterCessAssesmentDate = waterCessAssessmentOrderDate1
					   cessPaySlipInstance.interestAssesmentDate = waterCessAssessmentOrderDate1
					   cessPaySlipInstance.penalityAssesmentDate = waterCessAssessmentOrderDate1
					   cessPaySlipInstance.otherAssesmentDate = waterCessAssessmentOrderDate1
					   cessPaySlipInstance.waterCessAssesmentFromDate = waterCessAssessmentOrderFrom1
					   cessPaySlipInstance.interestAssesmentFromDate =waterCessAssessmentOrderFrom1
					   cessPaySlipInstance.penalityAssesmentFromDate = waterCessAssessmentOrderFrom1
					   cessPaySlipInstance.otherAssesmentFromDate = waterCessAssessmentOrderFrom1
					   cessPaySlipInstance.waterCessAssesmentToDate = waterCessAssessmentOrderTo1
					   cessPaySlipInstance.interestAssesmentToDate =waterCessAssessmentOrderTo1
					   cessPaySlipInstance.penalityAssesmentToDate =waterCessAssessmentOrderTo1
					   cessPaySlipInstance.otherAssesmentToDate = waterCessAssessmentOrderTo1
					   cessPaySlipInstance.waterCessAssesmentAmount =waterCessAssessmentOrderAmount.toFloat()
					   cessPaySlipInstance.interestAssesmentAmount =interestAssessmentOrderAmount.toFloat()
					   cessPaySlipInstance.penalityAssesmentAmount =penaltyAssessmentOrderAmount.toFloat()
					   cessPaySlipInstance.otherAssesmentAmount = otherMiscAssessmentOrderAmount.toFloat()
					   cessPaySlipInstance.totalAmount = totalMoney.toFloat()
					   cessPaySlipInstance.waterCessAssesmentRemarks = waterCessAssessmentOrderRemarks
					   cessPaySlipInstance.interestAssesmentRemarks = interestAssessmentOrderRemarks
					   cessPaySlipInstance.penalityAssesmentRemarks = penaltyAssessmentOrderRemarks
					   cessPaySlipInstance.otherAssesmentRemarks = otherMiscAssessmentOrderRemarks
				    	cessPaySlipInstance.save()
					  certFile=cessfee.cessFeeDetails_Function( nameOfDistrict, offAddres, industryName, industryPlot, industryAddress, industryTehsil, industryDistrict,  waterCessAssessmentOrderNo,  waterCessAssessmentOrderDate,  waterCessAssessmentOrderFrom,  waterCessAssessmentOrderTo,  interestAssessmentOrderNo,  interestAssessmentOrderDate,  interestAssessmentOrderFrom,  interestAssessmentOrderTo,  penaltyAssessmentOrderNo,  penaltyAssessmentOrderDate,  PenaltyAssessmentOrderFrom,  penaltyAssessmentOrderTo,  otherMiscAssessmentOrderNo,  otherMiscAssessmentOrderDate, otherMiscAssessmentOrderFrom, otherMiscAssessmentOrderTo, waterCessAssessmentOrderAmount, waterCessAssessmentOrderRemarks, interestAssessmentOrderAmount, interestAssessmentOrderRemarks, penaltyAssessmentOrderAmount, penaltyAssessmentOrderRemarks, otherMiscAssessmentOrderAmount, otherMiscAssessmentOrderRemarks, codeNumber, totRupees, demandDraftRupees, demandDraftDate, demandDraftNo, cessFeeDate, rupeesInWords, fromDate1, toDate1)
						
						byte[] b = new byte[(int) certFile.length()];
						
						FileInputStream fileInputStream = new FileInputStream(certFile);
						fileInputStream.read(b);
						
						def fileLength=certFile.length()
						file.size = fileLength / 1024  //f.getSize() 
						file.extension ="pdf"//extractExtension( f )
						file.data=b;
						file.name="FeeDetails.pdf"
						file.description="Cess pay slip Generation Record"
						file.createdBy=session.indUser
						file.updatedBy=session.indUser
						file.typeOfFile="FeesDetail"
						file.indreg=industryReg
						file.cessReturn=cessInstance
						file.cessAppliedFromDate=leastDate
						file.cessAppliedToDate=upperDate
						if(file.save()) {
							flash.message = "Water Cess Pay in slip is generated properly."
							cessInstance.fees=true
							cessInstance.save()
						}else{
							flash.message = "Water Cess Pay in slip is not generated properly."
						}
						if(cessInstance.fees){
							checkFeesView=true
						}
						render(view:'show',model:[ feeCheck:feeCheck,cessReturnInstance : cessInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList,checkForEdit:checkForEdit,checkFeesView:checkFeesView])
					}
				}
			}
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def viewFeePaySlip={
		 try {
				def cessInstance = CessReturn.get((params.appliId).toLong())
				def applicationList= CessReturnFileRecord.findAll("From CessReturnFileRecord as crf where crf.cessReturn=? and crf.typeOfFile='FeesDetail' order by crf.id desc",[cessInstance],[max:1])
				def application=applicationList[0]
				def applicationFileSingleInstance=application
				response.setContentType( "application-xdownload")
				response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
				response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
			}
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def submitClarification = {
		 try {
				def application = CessReturn.get((params.id).toLong())
				def applicationProcessingDetailsInstanceList =  CessProcessingDetails.findAllByCessreturn(application,[sort:'dateCreated',order:'desc',offset:0]) 
				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
					if((applicationProcessingDetailsInstanceList.get(i)).assessmentIssue){
						return[appClarification:applicationProcessingDetailsInstanceList.get(i),app:application]
					}
				}
			 }catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def submittedClarification = {
		 try {
				def noteHistiryFile=new CessReturnFileRecord()
				def application = CessReturn.get((params.appId).toLong())
				def appProcessing = new CessProcessingDetails()
				def f = request.getFile('indClarificationIssueFile')
				MultipartFile multi = request.getFile('indClarificationIssueFile')
				if(!f.empty) {
					appProcessing.clarificationReplyAttachedFile=true
					def applicationFileRecordInstance=CessReturnFileRecord.findAll("from CessReturnFileRecord afr where afr.cessReturn=? and afr.typeOfFile='indClarificationIssueFile' order by afr.id desc",[application],[max:1])
					if(applicationFileRecordInstance){
						noteHistiryFile.version =applicationFileRecordInstance[0].version+1
					}
					noteHistiryFile.size = multi.getSize() / 1024
					noteHistiryFile.name =multi.getOriginalFilename()
					noteHistiryFile.data=multi.getBytes() 
					noteHistiryFile.extension = extractExtension( multi )
					noteHistiryFile.description="Application Cess issue Clarification Report File"
					if(session.userMaster){
						noteHistiryFile.createdBy=session.userMaster
						noteHistiryFile.updatedBy=session.userMaster
					}else {
						noteHistiryFile.createdBy=session.indUser
						noteHistiryFile.updatedBy=session.indUser
					}
					noteHistiryFile.typeOfFile="indClarificationIssueFile"
					noteHistiryFile.cessReturn=application  
					
					noteHistiryFile.cessAppliedFromDate=new Date()
					noteHistiryFile.cessAppliedToDate=new Date()
					noteHistiryFile.indreg=application.industryReg  
					if(noteHistiryFile.save()) {
						
					} else {
						
					}
				}
				application.assessmentIssue = false
				application.save()
				def cessPend=CessPendingDetails.findAllByCessReturn(application)
				def cessPendInstance=cessPend[0]
				appProcessing.role=cessPendInstance.role
				appProcessing.officer=""
				appProcessing.roleFwd=cessPendInstance.role
				appProcessing.officerFwd=""
				appProcessing.fileNote=""
				appProcessing.cessreturn = application
				appProcessing.assessmentIssue=false
				appProcessing.assessmentIssueNote=""
				appProcessing.assessmentIssueClose=true
				appProcessing.assessmentIssueCloseNote=params.indClarificationNote
				appProcessing.assessmentOrder=false
				appProcessing.assessmentOrderNote=""
				appProcessing.feeDefaulterNotice=false
				appProcessing.feeDefaulterNoticeNote=""
				appProcessing.inspection=false
				appProcessing.inspectionNote=""
				appProcessing.inspectionClose=false		
				appProcessing.inspectionCloseNote=""
				appProcessing.finish=false
				appProcessing.finishNote=""
				appProcessing.save()
				flash.message = "Clarification Submitted"
				redirect(controller:"applicationProcessingDetails",action:"popClose")
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def extractExtension( MultipartFile file ) {
		 try {
				String filename = file.getOriginalFilename()
				return filename.substring(filename.lastIndexOf( "." ) + 1 )
			 }
		 catch(Exception e) {
		            e.printStackTrace();
					 flash.message = "Server Busy ..Please try after some time....";
					if(session.indUser){
				redirect(controller:'indUser',action:'openIndustryHome')
		 }
		 else if(session.userMaster){
		  redirect(controller:'userMaster',action:'openSpcbHome');
		 }else{
		        session.invalidate()
		        redirect(uri:'/index.gsp');
		 }
		   }
	}
	
	def printCessReturn={
			 try {
					def cessReturnInstance = CessReturn.get( params.id )
					def industryRegId=cessReturnInstance.industryReg
					def checkFeesView=false
					if(cessReturnInstance.fees){
						checkFeesView=true
					}
					def cessDetailList=CessReturnDetails.findAllByCessReturn(cessReturnInstance)
					if(!cessReturnInstance) {
						flash.message = "CessReturn not found with id ${params.id}"
						redirect(action:createSingle)
					}
					else { return [ checkFeesView:checkFeesView,cessReturnInstance : cessReturnInstance ,industryRegId:industryRegId,cessDetailList:cessDetailList]
					}
				}
			 catch(Exception e) {
			            e.printStackTrace();
						 flash.message = "Server Busy ..Please try after some time....";
						if(session.indUser){
					redirect(controller:'indUser',action:'openIndustryHome')
			 }
			 else if(session.userMaster){
			  redirect(controller:'userMaster',action:'openSpcbHome');
			 }else{
			        session.invalidate()
			        redirect(uri:'/index.gsp');
			 }
			   }
	}
	
	
}