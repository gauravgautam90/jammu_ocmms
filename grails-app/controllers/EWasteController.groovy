import groovy.sql.*

import javax.swing.plaf.basic.BasicHTML
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

//import acm.program.*;
//import org.apache.commons.fileupload.DiskFileUpload
import org.apache.commons.fileupload.FileItem

import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile

class EWasteController {

    String findGrpAddress(String grpName){
        def grpAddress = ""
        if (grpName == "Bahadurgarh") {
            grpAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
        } else if (grpName == "Ballabhgarh") {
            grpAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

        } else if (grpName == "Chandigarh") {
            grpAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

        } else if (grpName == "Dharuhera") {
            grpAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

        } else if (grpName == "Faridabad") {
            grpAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

        } else if (grpName == "Gurgaon North") {
            grpAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

        } else if (grpName == "Gurgaon South") {
            grpAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

        } else if (grpName == "Hissar") {
            grpAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

        } else if (grpName == "Jind") {
            grpAddress = "SCF-32, sector 13, HUDA, Bhiwani Ph. 01664-240259 "

        } else if (grpName == "Panchkula") {
            grpAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

        } else if (grpName == "Panipat") {
            grpAddress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

        } else if (grpName == "Sonipat") {
            grpAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

        } else if (grpName == "Yamuna Nagar") {
            grpAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

        }
        return grpAddress
    }

    def dataSource

    def index = {
        try {

            redirect(action: createSingle, params: params)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']

    def list = {
        try {
            def industryId = session.indUser
            def indUserID12 = industryId.industryRegMaster

            if (industryId == null || industryId == "") {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")

            }

            def indUserID = industryId.industryRegMaster

            def status1 = "inProgress"
            def status2 = "completed"
            /*coding  start by saroj	for getting pending with */
            def pendingWithList = new ArrayList();
            def eWasteInst = EWaste.findAllWhere(industryReg: indUserID, completionStatus: status1)
            def ewasteinstance = EWaste.findAllWhere(industryReg: indUserID, completionStatus: status2)
            println("ewasteinstance: " + ewasteinstance)

            for (int i = 0; i < ewasteinstance.size(); i++) {
                println("ewasteinstance["+i+"]: " + ewasteinstance[i])
                def eWasteManagementPendingDetailsInstance = EWasteManagementPendingDetails.findByApplicationId(ewasteinstance[i].toString())
                println("eWasteManagementPendingDetailsInstance: " + eWasteManagementPendingDetailsInstance)
                def pendingWith = "Unattended"
                if (eWasteManagementPendingDetailsInstance)
                    pendingWith = eWasteManagementPendingDetailsInstance.role.roleName
                println("pendingWith: " + pendingWith)
                pendingWithList.add(pendingWith)


            }//end coding
            println("pendingWithList: " + pendingWithList)





            params.max = Math.min(params.max ? params.max.toInteger() : 10, 100)
            [eWasteInst: eWasteInst, eWasteInstance: ewasteinstance, industryName: indUserID12, pendingWithList: pendingWithList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def show = {
        try {
            def industryId = session.indUser
            def eWasteInst = EWaste.get(params.id)
            def indRegInstance = eWasteInst.industryReg
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)
            def occName = indRegInstanceGet.occName
            def listDoc = new ArrayList()
            def appId = (params.id).toLong()
            boolean chk;
            def list = EWasteManagementCertificates.findAllWhere(applicationId: appId)
            if (list.size() > 0) {
                chk = true
            }

            def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [eWasteInst])
            if (applicationDocumentInstance) {
                for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                    def boolCheck = false
                    if (listDoc.size() == 0) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }
                    for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                        if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                            boolCheck = true
                        }
                    }
                    if (boolCheck == false) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }

                }

            }
            if (!eWasteInst) {
                flash.message = "eWasteInst not found with id ${params.id}"
                redirect(action: list)
            } else {
                render(view: 'show', model: [eWasteInstance: eWasteInst, eWasteInst: eWasteInst, indRegInstance: indRegInstance, listDoc: listDoc, chk: chk, appId: appId])
                //return [ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1]
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    //by saroj
    def viewSubmittedClarificationDemo = {
        try {
            def application = EWaste.get((params.id).toLong())
            //	def applicationFileRecordInst=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indClarificationFile'and afr.version=? order by id",[application,fileVer],[max:1])
            def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [application.industryReg])
            //def applicationDownloadInst = EWasteProcessingDetails.find("from EWasteProcessingDetails where applicationId=? and officer=? order by id desc ",[application.id.toString(),industryId.toString()])
            def applicationProcessingDetailsInstanceList = EWasteProcessingDetails.findAllByApplicationId(application.id.toString(), [sort: 'dateCreated', order: 'asc', offset: 0])


            return [applicationProcessingDetailsInstanceList: applicationProcessingDetailsInstanceList, app: application]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }


    def edit = {
        try {
            def industryId = session.indUser
            if (industryId == null || industryId == "") {
                redirect(controller: "userMaster", action: "logout")
            }
 
            def eWasteInstance = EWaste.get(params.appId)
            def testValue=""
if(params.testValue.equals("true")){
	testValue="true"
}else{
testValue="false"	
}

            IndUser indUserInstance = (IndUser) session.indUser
            def induserQuery = IndUser.get(indUserInstance.id)


            def indRegInstance = indUserInstance.industryRegMaster
            if (!eWasteInstance) {


                flash.message = "eWasteInstance not found with id ${params.id}"
                redirect(action: list)
            } else {

                return [eWasteInstance: eWasteInstance, indRegInstance: indRegInstance, id: eWasteInstance,testValue:testValue]
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def update = {
        try {
            def eWasteInstance = EWaste.get(params.id)
            if (eWasteInstance) {
                if (params.version) {
                    def version = params.version.toLong()
                    if (eWasteInstance.version > version) {

                        eWasteInstance.errors.rejectValue("version", "EWaste.optimistic.locking.failure", "Another user has updated this CessReturn while you were editing.")
                        render(view: 'edit', model: [eWasteInstance: eWasteInstance])
                        return
                    }
                }
                eWasteInstance.properties = params
                if (!eWasteInstance.hasErrors() && eWasteInstance.save()) {
                    redirect(action: show, id: eWasteInstance.id)
                } else {


                    render(view: 'edit', model: [eWasteInstance: eWasteInstance])
                }
            } else {
                flash.message = "eWasteInstance not found with id ${params.id}"
                redirect(action: edit, id: params.id)
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def create = {
    	println("print..params..: "+params)
        try {

        	def wasteType
        	if(params.chkManufacture && params.chkDismantlerOrRecycler){
        		wasteType = "Both"
        	}else if(params.chkManufacture){
        		wasteType = params.chkManufacture	
        	}else{
        		wasteType = params.chkDismantlerOrRecycler
        	}
            boolean chkManufacture=false
            boolean chkRefurbisher=false
            boolean chkDismantlerOrRecycler=false
            if(params.chkManufacture)
            {
                chkManufacture = true
            }
            if(params.chkRefurbisher)
            {
                chkRefurbisher = true
            }
            if(params.chkDismantlerOrRecycler)
            {
                chkDismantlerOrRecycler = true
            }


            IndUser indUserInstance = (IndUser) session.indUser
            def induserQuery = IndUser.get(indUserInstance.id)
            def indRegInstance = indUserInstance.industryRegMaster
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)
            def eWasteInstance = new EWaste()
            def eWasteInstanceOld = EWaste.find("from EWaste abc where abc.industryReg=? and abc.completionStatus='Completed' order by abc.id desc ", [indRegInstanceGet])
            String checkBoxButton=""
            if(params['chkManufacture']=="on") {
                checkBoxButton=checkBoxButton.concat("Manufacturer")
                checkBoxButton=checkBoxButton.concat(",")
            }
            if(params['chkRefurbisher']=="on") {
                checkBoxButton=checkBoxButton.concat("Refurbisher")
                checkBoxButton=checkBoxButton.concat(",")
            }
            if(params['chkDismantlerOrRecycler']=="on") {
                checkBoxButton=checkBoxButton.concat("DismantlerOrRecycler")
                checkBoxButton=checkBoxButton.concat(",")
            }
            if(checkBoxButton.length()>0)
            {
                checkBoxButton = checkBoxButton.substring(0, checkBoxButton.length() - 1);
            }
            
            
            if (eWasteInstanceOld) {
            	eWasteInstance.authorisationType = wasteType
                eWasteInstance.industryReg = indRegInstanceGet

                eWasteInstance.adequatePoll = eWasteInstanceOld.adequatePoll

                eWasteInstance.completionStatus = "inProgress"

                eWasteInstance.applicationStatus = "Inprogress"
                eWasteInstance.clarification = false
                eWasteInstance.inspection = false

                
                eWasteInstance.dateCreated=new Date()
               
                if(session.cafUniqueNo){
                	eWasteInstance.cafUniqueNo=session.cafUniqueNo
                }else{
                	eWasteInstance.cafUniqueNo=""
                }	
            	if(session.serviceId){
            		eWasteInstance.serviceId=session.serviceId
            	}else{
            		eWasteInstance.serviceId=""
            	}	
            	if(session.cafUniqueNo && session.serviceId){
            		eWasteInstance.singleWin=true
            	}else{
            		eWasteInstance.singleWin=false
            	}	
            	 eWasteInstance.properties = params
                eWasteInstance.save()


                return ['eWasteInstance': eWasteInstance, eWasteInstanceOld: eWasteInstanceOld, indRegInstance: indRegInstance,chkManufacture:chkManufacture,chkRefurbisher:chkRefurbisher,chkDismantlerOrRecycler:chkDismantlerOrRecycler,wasteType:wasteType]

            } else {
            	println("---incase of New Instance---")
                Date todayDate = new Date()
                
                eWasteInstance.industryReg = indRegInstanceGet
                eWasteInstance.waterConsFrom = todayDate
                eWasteInstance.waterConsTo = todayDate
                eWasteInstance.airConsFrom = todayDate
                eWasteInstance.airConsTo = todayDate
                eWasteInstance.authorizationFrom = todayDate
                eWasteInstance.authorizationTo = todayDate
                eWasteInstance.regDate = todayDate
                eWasteInstance.completionStatus = "inProgress"
                eWasteInstance.fugEmission = ""
                eWasteInstance.healthAspects = ""
                eWasteInstance.adequatePoll = ""
                eWasteInstance.indCompliance = ""
                eWasteInstance.relInfo = ""
                eWasteInstance.authorisationType =""
                

                eWasteInstance.dateCreated = new Date()

                eWasteInstance.applicationStatus = "Inprogress"
                eWasteInstance.clarification = false
                eWasteInstance.inspection = false

                eWasteInstance.disposal = ""
                if(session.cafUniqueNo){
                 eWasteInstance.cafUniqueNo=session.cafUniqueNo
                 }else{
                  	eWasteInstance.cafUniqueNo=""
                 }	
                   	if(session.serviceId){
                   		eWasteInstance.serviceId=session.serviceId
                   	}else{
                   		eWasteInstance.serviceId=""
                   	}	
                   	if(session.cafUniqueNo && session.serviceId){
                   		eWasteInstance.singleWin=true
                   	}else{
                   		eWasteInstance.singleWin=false
                   	}	
                eWasteInstance.properties = params
                if (eWasteInstance.save()) {


                } else {


                    eWasteInstance.errors.allErrors.each {
                        println it
                    }
                }
            }


            return ['eWasteInstance': eWasteInstance, indRegInstance: indRegInstance, chkManufacture:chkManufacture,chkRefurbisher:chkRefurbisher,chkDismantlerOrRecycler:chkDismantlerOrRecycler,wasteType:wasteType]
           }catch(Exception e){
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser){
                redirect(controller: 'indUser', action: 'openIndustryHome')
            }else if(session.userMaster){
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            }else{
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    // satish code start;
    // action save is replaced
    def save = {

        println("params..save..: "+params)
        def industryId = session.indUser
        if (industryId == null || industryId == "") {
            redirect(controller: "userMaster", action: "logout")
        }
        def eWasteInstance = EWaste.get((params.indAppDetId).toLong())
        
        def industryInstance = IndustryRegMaster.get((params.indRegId).toString())



        eWasteInstance.industryReg = industryInstance
        IndUser indUserInstance = (IndUser) session.indUser
        def indRegInstance = indUserInstance.industryRegMaster

        
        def sdfh = new SimpleDateFormat("dd/MM/yyyy");
        println("sdfh" + params.indRegId)

        def a = sdfh.parse(params.waterConsFrom_value); //Date

        def x = sdfh.parse(params.waterConsTo_value); //Date

        def c = sdfh.parse(params.airConsFrom_value); //Date

        def y = sdfh.parse(params.airConsTo_value); //Date

        def e = sdfh.parse(params.authorizationFrom_value); //Date

        def f = sdfh.parse(params.authorizationTo_value); //Date
        def g = sdfh.parse(params.regDate_value); //Date

        println("sdfh.parse" + params.indRegId)
        java.sql.Date sqlDate1 = new java.sql.Date(a.getTime())
        java.sql.Date sqlDate2 = new java.sql.Date(x.getTime())
        java.sql.Date sqlDate3 = new java.sql.Date(c.getTime())
        java.sql.Date sqlDate4 = new java.sql.Date(y.getTime())
        java.sql.Date sqlDate5 = new java.sql.Date(e.getTime())
        java.sql.Date sqlDate6 = new java.sql.Date(f.getTime())
        java.sql.Date sqlDate7 = new java.sql.Date(g.getTime())
        



        eWasteInstance.waterConsFrom = sqlDate1
        eWasteInstance.waterConsTo = sqlDate2
        eWasteInstance.airConsFrom = sqlDate3
        eWasteInstance.airConsTo = sqlDate4
        eWasteInstance.authorizationFrom = sqlDate5
        eWasteInstance.authorizationTo = sqlDate6
        eWasteInstance.regDate = sqlDate7

        eWasteInstance.disposal = params.disposal
        eWasteInstance.fugEmission = params.fugEmission
        eWasteInstance.healthAspects = params.healthAspects
        eWasteInstance.adequatePoll = params.adequatePoll
        eWasteInstance.indCompliance = params.indCompliance
        eWasteInstance.relInfo = params.relInfo
        eWasteInstance.authorisationType = params.wasteType


        eWasteInstance.completionStatus = "inProgress"
        eWasteInstance.industryReg = indRegInstance
        eWasteInstance.clarification = false
        eWasteInstance.inspection = false
        //eWasteInstance.ewasteManufactureOrRefurbisher = params.ewasteManufactureOrRefurbisher
        if (params.ewasteManufactureOrRefurbisher) {
            eWasteInstance.ewasteIsManufacturerOrRefurbisher = params.ewasteManufactureOrRefurbisher
        } else {
            eWasteInstance.ewasteIsManufacturerOrRefurbisher = ""
        }

        if(params.chkConsent)
        {
            eWasteInstance.chkConsent = params.chkConsent
        }else {
            eWasteInstance.chkConsent = ""
        }

        if(params.chkBMW)
        {
            eWasteInstance.chkBMW = params.chkBMW
        }else {
            eWasteInstance.chkBMW = ""
        }

        if(params.chkHWM)
        {
            eWasteInstance.chkHWM = params.chkHWM
        }else {
            eWasteInstance.chkHWM = ""
        }

        if(params.chkSWM)
        {
            eWasteInstance.chkSWM = params.chkSWM
        }else {
            eWasteInstance.chkSWM = ""
        }

        if(params.facilityDetail)
        {
            eWasteInstance.facilityDetail = params.facilityDetail
        }else{
            eWasteInstance.facilityDetail = ""
        }

        if(params.renewalAuth)
        {
            eWasteInstance.renewalAuth = params.renewalAuth
        }else{
            eWasteInstance.renewalAuth = ""
        }
       

        def f2 = request.getFile('eWasteFacilityDetails')
        def file2 = new ApplicationDocumentsEW()
        if(!f2.empty) {
            MultipartFile multi = request.getFile('eWasteFacilityDetails')
            file2.size = multi.getSize() / 1024
            file2.level="Facility Details"
            file2.data=multi.getBytes()
            file2.extension = extractExtension( multi )
            def ab = "Facility Details"
            def bcd = ab+"."+extractExtension( multi )
            file2.name =bcd
            file2.indApplication = eWasteInstance
           
            file2.save()
        }


        def f3 = request.getFile('eWasteRenewal')
        def file3 = new ApplicationDocumentsEW()
        if(!f3.empty) {
            MultipartFile multi = request.getFile('eWasteRenewal')
            file3.size = multi.getSize() / 1024
            file3.level="Renewal Details"
            file3.data=multi.getBytes()
            file3.extension = extractExtension( multi )
            def ab = "Renewal Details"
            def bcd = ab+"."+extractExtension( multi )
            file3.name =bcd
            file3.indApplication = eWasteInstance
            
            file3.save()
        }

        def f4 = request.getFile('eWasteOccupationalSafetyDetails')
        def file4 = new ApplicationDocumentsEW()
        if(!f4.empty){
            MultipartFile multi = request.getFile('eWasteOccupationalSafetyDetails')
            file4.size = multi.getSize() / 1024
            file4.level="Occupational Safety Details"
            file4.data=multi.getBytes()
            file4.extension = extractExtension( multi )
            def ab = "Occupational Safety Details"
            def bcd = ab+"."+extractExtension( multi )
            file4.name =bcd
            file4.indApplication = eWasteInstance
            file4.save()
        }

       


        eWasteInstance.applicationStatus = "Inprogress"

        if (params.appStatus == "inProgress") {
        	if((eWasteInstance.cafUniqueNo!=null) && (eWasteInstance.cafUniqueNo!="")){

    	    	Response responsePush=new Response();
    	    	String consentAppNo=eWasteInstance.id.toString();
    	    	String cafNo=eWasteInstance.cafUniqueNo
    	    	String applicationType="EWaste"
    	    	String applicationFor1="Fresh"
    	    	String statusCode="I"
    	    	String appRemarks="Application saved as a draft"
    	    	String pendingWith=""
    	    	String pendingWithRole=""
    	    	String printAppUrl=""
    	    	String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+eWasteInstance.industryReg.indName+"&indDistrict="+eWasteInstance.industryReg.district.districtName+"&serviceCode="+eWasteInstance.serviceId+"&cafUniqueNo="+eWasteInstance.cafUniqueNo
    	    	String certificateUrl=""
    	    	String serviceId=eWasteInstance.serviceId
    	    	
    	    	responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationType,applicationFor1,statusCode,appRemarks,pendingWith,pendingWithRole,printAppUrl,revertedUrl,certificateUrl)
    	    	
        	
        	}
            flash.message = "E-Waste Application No ${eWasteInstance.id} is Available for Future modification."
            def listDoc = new ArrayList()

            def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [eWasteInstance])

            for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                def boolCheck = false
                println(ig + "ig")
                if (listDoc.size() == 0) {
                   listDoc.add(applicationDocumentInstance.get(ig))
                }
              
                for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                   
                    if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                        boolCheck = true
                    }
                }
                if (boolCheck == false) {
                    listDoc.add(applicationDocumentInstance.get(ig))
                }

            }
            
            render(view: 'show', model: [eWasteInstance: eWasteInstance, indRegInstance: indRegInstance, listDoc: listDoc])
            //,chkManufacture:chkManufacture,chkRefurbisher:chkRefurbisher,chkDismantlerOrRecycler:chkDismantlerOrRecycler
            return


        } else {

            def ewasteId = eWasteInstance.id



            def ewasteIdInstance = EWaste.get(ewasteId)
            //flash.message = "E-Waste Application No ${eWasteInstance.id} is Submitted Successfully";
            
            def indName = industryInstance.indName
            def indAddress = industryInstance.indAddress
            def occName = industryInstance.occName
           
            def occDesignation = industryInstance.occDesignation
           
            def occPhoneCode = industryInstance.occPhoneCode
            def occPhoneNo = industryInstance.occPhoneNo
            def occFaxCode = industryInstance.occFaxCode
            def occFaxNo = industryInstance.occFaxNo
            def dateOfComm = industryInstance.dateOfComm
            def noOfEmp = industryInstance.noOfEmp
            def comDate = eWasteInstance.regDate
            def ewasteIsManufacturerOrRefurbisher = eWasteInstance.ewasteIsManufacturerOrRefurbisher
            def chkConsent = eWasteInstance.chkConsent
            def chkBMW = eWasteInstance.chkBMW
            def chkHWM = eWasteInstance.chkHWM
            def chkSWM = eWasteInstance.chkSWM
            def facilityDetail = eWasteInstance.facilityDetail
            def renewalAuth = eWasteInstance.renewalAuth
            def checkBoxButton = eWasteInstance.checkBoxButton
            
            def productionDetails = new ArrayList()

            def productionDetailsInstance = EWasteIndProductionDetails.findAllByApplication(eWasteInstance)
            for (int var12 = 0; var12 < productionDetailsInstance.size(); var12++) {
                def productionDetailsInstanceList = new ArrayList()



                productionDetailsInstanceList.add(productionDetailsInstance.get(var12).product)
                productionDetailsInstanceList.add(productionDetailsInstance.get(var12).capacity)

                productionDetails.add(productionDetailsInstanceList)

            }

            def productDetails = new ArrayList()

            def productDetailsInstance = EWasteIndProductDetails.findAllByApplication(eWasteInstance)
            for (int var12 = 0; var12 < productDetailsInstance.size(); var12++) {
                def productDetailsInstanceList = new ArrayList()


                productDetailsInstanceList.add(productDetailsInstance.get(var12).year)
                productDetailsInstanceList.add(productDetailsInstance.get(var12).product)
                productDetailsInstanceList.add(productDetailsInstance.get(var12).quantity + " " + productDetailsInstance.get(var12).unit.unitName)


                productDetails.add(productDetailsInstanceList)

            }


            def rawMaterialsDetails = new ArrayList()

            def rawMaterialsDetailsInstance = EWasteRawMaterialDetails.findAllByApplication(eWasteInstance)
            for (int var121 = 0; var121 < rawMaterialsDetailsInstance.size(); var121++) {
                def rawMaterialsDetailsInstanceList = new ArrayList()


                rawMaterialsDetailsInstanceList.add(rawMaterialsDetailsInstance.get(var121).year)
                rawMaterialsDetailsInstanceList.add(rawMaterialsDetailsInstance.get(var121).rawMaterialName)
                rawMaterialsDetailsInstanceList.add(rawMaterialsDetailsInstance.get(var121).quantity + " " + rawMaterialsDetailsInstance.get(var121).unit.unitName)


                rawMaterialsDetails.add(rawMaterialsDetailsInstanceList)

            }


            def waterConsumptionDetails = new ArrayList()

            def waterConsumptionDetailsInstance = EWasteWaterUsesDetails.findAllByApplication(eWasteInstance)
            for (int var1212 = 0; var1212 < waterConsumptionDetailsInstance.size(); var1212++) {
                def waterConsumptionDetailsInstanceList = new ArrayList()


                waterConsumptionDetailsInstanceList.add(waterConsumptionDetailsInstance.get(var1212).use.useType + " " + waterConsumptionDetailsInstance.get(var1212).otherSource)
                waterConsumptionDetailsInstanceList.add((waterConsumptionDetailsInstance.get(var1212).quantity).toString())

                waterConsumptionDetails.add(waterConsumptionDetailsInstanceList)

            }


            def regDate = params.regDate_value
            
            def waterGenerationDetails = new ArrayList()

            def waterGenerationDetailsInstance = EWasteWaterModeUseDetails.findAllByApplication(eWasteInstance)
            for (int var123 = 0; var123 < waterGenerationDetailsInstance.size(); var123++) {
                def waterGenerationDetailsInstanceList = new ArrayList()


                waterGenerationDetailsInstanceList.add(waterGenerationDetailsInstance.get(var123).modeUse + " " + waterGenerationDetailsInstance.get(var123).otherSource)
                waterGenerationDetailsInstanceList.add((waterGenerationDetailsInstance.get(var123).quantity).toString())
                
                waterGenerationDetails.add(waterGenerationDetailsInstanceList)

            }

            def waterTreatmentDetails = new ArrayList()

            def waterTreatmentDetailsInstance = EWasteWaterTreatmentDetails.findAllByApplication(eWasteInstance)
            for (int var123 = 0; var123 < waterTreatmentDetailsInstance.size(); var123++) {
                def waterTreatmentDetailsInstanceList = new ArrayList()


                waterTreatmentDetailsInstanceList.add(waterTreatmentDetailsInstance.get(var123).use.useType + " " + waterTreatmentDetailsInstance.get(var123).otherSource)
                waterTreatmentDetailsInstanceList.add((waterTreatmentDetailsInstance.get(var123).quantity).toString())



                waterTreatmentDetails.add(waterTreatmentDetailsInstanceList)

            }


            def waterDischargeDetails = new ArrayList()

            def waterDischargeDetailsInstance = EWasteWaterDischargeDetails.findAllByApplication(eWasteInstance)
            for (int var123 = 0; var123 < waterDischargeDetailsInstance.size(); var123++) {
                def waterDischargeDetailsInstanceList = new ArrayList()



                waterDischargeDetailsInstanceList.add(waterDischargeDetailsInstance.get(var123).location)
                waterDischargeDetailsInstanceList.add((waterDischargeDetailsInstance.get(var123).quantity).toString())

                waterDischargeDetailsInstanceList.add(waterDischargeDetailsInstance.get(var123).parameter + " " + waterDischargeDetailsInstance.get(var123).otherParameter)

                waterDischargeDetails.add(waterDischargeDetailsInstanceList)

            }
       

            def totalQuantityDetails = new ArrayList()
            int tot1 = 1
            def totalQuantityDetailsInstance = EwasteTotalQuantityDetails.findAllByApplication(eWasteInstance)
            for(int var123=0; var123<totalQuantityDetailsInstance.size(); var123++)
            {
                def totalQuantityDetailsInstanceList = new ArrayList()
                String s = Integer.toString(tot1)
                totalQuantityDetailsInstanceList.add(s)

                totalQuantityDetailsInstanceList.add(totalQuantityDetailsInstance.get(var123).eWasteName)
                totalQuantityDetailsInstanceList.add(totalQuantityDetailsInstance.get(var123).quantity+" "+totalQuantityDetailsInstance.get(var123).unit.unitName)
                
                totalQuantityDetailsInstanceList.add(totalQuantityDetailsInstance.get(var123).conventionNo)
                totalQuantityDetailsInstanceList.add(totalQuantityDetailsInstance.get(var123).nature)

                totalQuantityDetails.add(totalQuantityDetailsInstanceList)
                tot1++
            }

            def refurbishedQuantityDetails = new ArrayList()
            int tot2 = 1
            def refurbishedQuantityDetailsInstance = EwasteRefurbishedQuantityDetails.findAllByApplication(eWasteInstance)
            for(int var123=0; var123<refurbishedQuantityDetailsInstance.size(); var123++)
            {
                def refurbishedQuantityDetailsInstanceList = new ArrayList()
                String s = Integer.toString(tot2)
                refurbishedQuantityDetailsInstanceList.add(s)

                refurbishedQuantityDetailsInstanceList.add(refurbishedQuantityDetailsInstance.get(var123).eWasteName)
                refurbishedQuantityDetailsInstanceList.add(refurbishedQuantityDetailsInstance.get(var123).quantity+" "+refurbishedQuantityDetailsInstance.get(var123).unit.unitName)
               
                refurbishedQuantityDetails.add(refurbishedQuantityDetailsInstanceList)
                tot2++
            }

            def recycleQuantityDetails = new ArrayList()
            int tot3 = 1
            def recycleQuantityDetailsInstance = EwasteRecycleQuantityDetails.findAllByApplication(eWasteInstance)
            for(int var123=0; var123<recycleQuantityDetailsInstance.size();var123++)
            {
                def recycleQuantityDetailsInstanceList = new ArrayList()
                String s = Integer.toString(tot3)
                recycleQuantityDetailsInstanceList.add(s)

                recycleQuantityDetailsInstanceList.add(recycleQuantityDetailsInstance.get(var123).eWasteName)
                recycleQuantityDetailsInstanceList.add(recycleQuantityDetailsInstance.get(var123).quantity+" "+recycleQuantityDetailsInstance.get(var123).unit.unitName)
                
                recycleQuantityDetails.add(recycleQuantityDetailsInstanceList)
                tot3++
            }

            def disposalQuantityDetails = new ArrayList()
            int tot4 = 1
            def disposalQuantityDetailsInstance = EwasteDisposalQuantityDetails.findAllByApplication(eWasteInstance)
            for(int var123=0; var123<disposalQuantityDetailsInstance.size(); var123++)
            {
                def disposalQuantityDetailsInstanceList = new ArrayList()
                String s = Integer.toString(tot4)
                disposalQuantityDetailsInstanceList.add(s)

                disposalQuantityDetailsInstanceList.add(disposalQuantityDetailsInstance.get(var123).eWasteName)
                disposalQuantityDetailsInstanceList.add(disposalQuantityDetailsInstance.get(var123).quantity + " "+disposalQuantityDetailsInstance.get(var123).unit.unitName)
                
                disposalQuantityDetails.add(disposalQuantityDetailsInstanceList)
                tot4++
            }


        



            def fuelConsumptionDetails = new ArrayList()

            def fuelConsumptionDetailsInstance = EWasteFuelConsumptionDetails.findAllByApplication(eWasteInstance)
            for (int var123 = 0; var123 < fuelConsumptionDetailsInstance.size(); var123++) {
                def fuelConsumptionDetailsInstanceList = new ArrayList()

                fuelConsumptionDetailsInstanceList.add(fuelConsumptionDetailsInstance.get(var123).fuel)
                fuelConsumptionDetailsInstanceList.add(fuelConsumptionDetailsInstance.get(var123).consumption)

                fuelConsumptionDetails.add(fuelConsumptionDetailsInstanceList)

            }



            def stackEmissionDetails = new ArrayList()

            def stackEmissionDetailsInstance = EWasteStackEmissionMonitoring.findAllByApplication(eWasteInstance)
            for (int var1231 = 0; var1231 < stackEmissionDetailsInstance.size(); var1231++) {
                def stackEmissionDetailsInstanceList = new ArrayList()



                stackEmissionDetailsInstanceList.add(stackEmissionDetailsInstance.get(var1231).stack)
                stackEmissionDetailsInstanceList.add(stackEmissionDetailsInstance.get(var1231).spm)
                stackEmissionDetailsInstanceList.add(stackEmissionDetailsInstance.get(var1231).so2)
                stackEmissionDetailsInstanceList.add(stackEmissionDetailsInstance.get(var1231).nox)
                stackEmissionDetailsInstanceList.add(stackEmissionDetailsInstance.get(var1231).pb)
                stackEmissionDetailsInstanceList.add(stackEmissionDetailsInstance.get(var1231).others)

                stackEmissionDetails.add(stackEmissionDetailsInstanceList)

            }

            def ambientDetails = new ArrayList()

            def ambientDetailsInstance = EWasteAmbientAirQualityStandardDetails.findAllByApplication(eWasteInstance)
            for (int var1299 = 0; var1299 < ambientDetailsInstance.size(); var1299++) {
                def ambientDetailsInstanceList = new ArrayList()



                ambientDetailsInstanceList.add(ambientDetailsInstance.get(var1299).location)
                ambientDetailsInstanceList.add(ambientDetailsInstance.get(var1299).spm)
                ambientDetailsInstanceList.add(ambientDetailsInstance.get(var1299).so2)
                ambientDetailsInstanceList.add(ambientDetailsInstance.get(var1299).nox)
                ambientDetailsInstanceList.add(ambientDetailsInstance.get(var1299).pb)

                ambientDetailsInstanceList.add(ambientDetailsInstance.get(var1299).others)

                ambientDetails.add(ambientDetailsInstanceList)

            }

            

            def disposal = eWasteInstance.disposal
            def fugEmission = eWasteInstance.fugEmission
            def healthAspects = eWasteInstance.healthAspects
            def adequatePoll = eWasteInstance.adequatePoll
            def indCompliance = eWasteInstance.indCompliance
            def relInfo = eWasteInstance.relInfo

            def wasteGenerationDetails = new ArrayList()

            def wasteGenerationDetailsInstance = EWasteGenDetails.findAllByApplication(eWasteInstance)
            int d = 1

            for (int var123 = 0; var123 < wasteGenerationDetailsInstance.size(); var123++) {
                def wasteGenerationDetailsInstanceList = new ArrayList()

                String s = Integer.toString(d)
                wasteGenerationDetailsInstanceList.add(s)


                wasteGenerationDetailsInstanceList.add(wasteGenerationDetailsInstance.get(var123).type)
                wasteGenerationDetailsInstanceList.add(wasteGenerationDetailsInstance.get(var123).category)

                wasteGenerationDetailsInstanceList.add(wasteGenerationDetailsInstance.get(var123).quantity + " " + wasteGenerationDetailsInstance.get(var123).unit.unitName)

                wasteGenerationDetails.add(wasteGenerationDetailsInstanceList)
                d++
            }



            def wasteDisposalDetails = new ArrayList()

            def wasteDisposalDetailsInstance = EWasteDisposalDetails.findAllByApplication(eWasteInstance)
            int h = 1

            for (int var123 = 0; var123 < wasteDisposalDetailsInstance.size(); var123++) {
                def wasteDisposalDetailsInstanceList = new ArrayList()

                String s = Integer.toString(h)
                wasteDisposalDetailsInstanceList.add(s)


                wasteDisposalDetailsInstanceList.add(wasteDisposalDetailsInstance.get(var123).type)
                wasteDisposalDetailsInstanceList.add(wasteDisposalDetailsInstance.get(var123).category)

                wasteDisposalDetailsInstanceList.add(wasteDisposalDetailsInstance.get(var123).quantity + " " + wasteDisposalDetailsInstance.get(var123).unit.unitName)



                wasteDisposalDetails.add(wasteDisposalDetailsInstanceList)
                h++
            }



            def ewasteDetails = new ArrayList()

            def ewasteDetailsInstance = EWasteDetails.findAllByApplication(eWasteInstance)
            int v = 1

            for (int var123 = 0; var123 < ewasteDetailsInstance.size(); var123++) {
                def ewasteDetailsInstanceList = new ArrayList()

                String s = Integer.toString(v)
                ewasteDetailsInstanceList.add(s)


                ewasteDetailsInstanceList.add(ewasteDetailsInstance.get(var123).name)
                ewasteDetailsInstanceList.add(ewasteDetailsInstance.get(var123).quantity)

                ewasteDetailsInstanceList.add(ewasteDetailsInstance.get(var123).conventionNo)



                ewasteDetails.add(ewasteDetailsInstanceList)
                v++
            }

////////////uploaded docssss///////////////////////////////////////////////////////////////////////////

            def listDoc = new ArrayList()

            def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [eWasteInstance])

            for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                def boolCheck = false
               
                if (listDoc.size() == 0) {
                    println(applicationDocumentInstance.get(ig))
                    listDoc.add(applicationDocumentInstance.get(ig))
                }
               
                for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                    
                    if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                        boolCheck = true

                    }

                   

                }
                if (boolCheck == false) {
                    listDoc.add(applicationDocumentInstance.get(ig))
                }
            }
            def listDocuments = new ArrayList()
            listDocuments.add(listDoc.level)
           


            SimpleDateFormat sdf111 = new SimpleDateFormat("dd/MM/yyyy");
            def abcDate = sdf111.format(eWasteInstance.regDate)
            def waterConsFrom = sdf111.format(eWasteInstance.waterConsFrom)
            def waterConsTo = sdf111.format(eWasteInstance.waterConsTo)
            def airConsFrom = sdf111.format(eWasteInstance.airConsFrom)
            def airConsTo = sdf111.format(eWasteInstance.airConsTo)
            def authorizationFrom = sdf111.format(eWasteInstance.authorizationFrom)
            def authorizationTo = sdf111.format(eWasteInstance.authorizationTo)
            def dateOfCom = sdf111.format(industryInstance.indRegNumDate)
            
            
            

///////////////////////////////////////////////////

 //===========================Document mandatory Code by Deepak=================================//
            def dcCkeck
			    def applicationFordoc
				ArrayList strList = new ArrayList()				
			def appId

				dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor= 'eWaste' ")
				println("dcCkeck---eWaste--"+dcCkeck)
			
		//	dcCkeck = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.consentFor='BMW' and doc.isMandatory='Yes' and doc.isNewApplication='true'")
		for(int i=0;i<dcCkeck.size();i++)
		{
			if(((dcCkeck.get(i)).isMandatory).equalsIgnoreCase("Yes"))
			{
				def isOrNot = ApplicationDocumentsEW.find("from ApplicationDocumentsEW abc where abc.level=? and abc.indApplication=?",[(dcCkeck.get(i)).document,eWasteInstance])
				if(!isOrNot)
				  strList.add(dcCkeck.get(i).document+"\n")
			}
		}
	   if(strList)
		{
		     println("strList---eWaste--"+strList)
			def strr = "Please Upload following documents:\n"
	        for(int i=0;i<strList.size();i++)
	    		{
	        		strr += ("("+(i+1)+"). "+strList.get(i)).toString()+"\n"
	    		}
	        flash.message = strr
	        eWasteInstance.completionStatus = "inProgress"
	        	eWasteInstance.save(flush:true)	
	        	 render(view: 'edit', model: [eWasteInstance: eWasteInstance, indRegInstance:indRegInstance])
			//redirect(action:edit,appId:eWasteInstance)
			return ;
		}
	   //============================================================//

           
            //flash.message = "E-Waste Application No ${eWasteInstance.id} is Submitted Successfully"
            
            def facilityDetailsIns
            def renewalDetailsIns	
            
            def applicationDocumentInstance12 = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [eWasteInstance])
            println("applicationDocumentInstance12..: "+applicationDocumentInstance12)
            if(applicationDocumentInstance12.level=='Facility Details'){
            	facilityDetailsIns="Attached"
            }else{
            	facilityDetailsIns="Not Attached"
            }
            
            
            if(applicationDocumentInstance12.level=='Renewal Details'){
            	renewalDetailsIns="Attached"
            }else{
            	renewalDetailsIns="Not Attached"
            }
            
            def document1
            if(applicationDocumentInstance12.level=='Copy of agreement with Collection Centre'){
            	document1="Attached"
            }else{
            	document1="Not Attached"
            }
            
            def document2
            if(applicationDocumentInstance12.level=='Copy of agreement with Producer'){
            	document2="Attached"
            }else{
            	document2="Not Attached"
            }
            def document3
            if(applicationDocumentInstance12.level=='Details of storage for dismantled e-waste'){
            	document3="Attached"
            }else{
            	document3="Not Attached"
            }
            
            def document4
            if(applicationDocumentInstance12.level=='Copy of agreement with Recycler'){
            	document4="Attached"
            }else{
            	document4="Not Attached"
            }
            
            def document5
            if(applicationDocumentInstance12.level=='Details of Facilities for Recycler'){
            	document5="Attached"
            }else{
            	document5="Not Attached"
            }
            
            def document6
            if(applicationDocumentInstance12.level=='Copy agreement with Producer1'){
            	document6="Attached"
            }else{
            	document6="Not Attached"
            }
            
            def document7
            if(applicationDocumentInstance12.level=='Copy of agreement with Collection Centre1'){
            	document7="Attached"
            }else{
            	document7="Not Attached"
            }

            def detailsOfFacilities = "13"
            def detailsOfStorage = "21"
            
            
            EWasteManagementFile file1 = new EWasteManagementFile()
            File certFile

            //code start by saroj find current date on pdf file

            def date = new Date()
            def sdf = new SimpleDateFormat("dd-MMM-yy")

            def currentDate = sdf.format(date)
            
            EWastePdfFile pdfG = new EWastePdfFile()
           
            def login = (indUserInstance.id).toString()
            def applicationId = eWasteInstance.toString()
            
def wasteType =params.wasteType
if(wasteType=='chkManufactureOrRefurbisher'){
            certFile = pdfG.EWastePdfFunction(abcDate, login, applicationId, occName, currentDate, waterConsFrom, waterConsTo, airConsFrom,
                    airConsTo, authorizationFrom, authorizationTo, dateOfCom, indName, indAddress, occDesignation, occPhoneCode, occPhoneNo,
                    occFaxCode, occFaxNo, noOfEmp, productionDetails, productDetails, rawMaterialsDetails, waterConsumptionDetails,
                    waterGenerationDetails, waterTreatmentDetails, waterDischargeDetails, fuelConsumptionDetails, stackEmissionDetails,
                    ambientDetails, wasteGenerationDetails, wasteDisposalDetails, ewasteDetails, disposal, fugEmission, healthAspects,
                    adequatePoll, indCompliance, relInfo, listDocuments, disposalQuantityDetails, recycleQuantityDetails, refurbishedQuantityDetails,           /*new fields added here*/
                    totalQuantityDetails, ewasteIsManufacturerOrRefurbisher, chkConsent, chkBMW, chkHWM, chkSWM, facilityDetail, 
                    renewalAuth, checkBoxButton,facilityDetailsIns, 
                    renewalDetailsIns)    /*new fields added here*/
            
}else{
	certFile = pdfG.EWastePdfFunction1(abcDate, login, applicationId, occName, currentDate, waterConsFrom, waterConsTo, airConsFrom,
            airConsTo, authorizationFrom, authorizationTo, dateOfCom, indName, indAddress, occDesignation, occPhoneCode, occPhoneNo,
            occFaxCode, occFaxNo, noOfEmp, productionDetails, productDetails, rawMaterialsDetails, waterConsumptionDetails,
            waterGenerationDetails, waterTreatmentDetails, waterDischargeDetails, fuelConsumptionDetails, stackEmissionDetails,
            ambientDetails, wasteGenerationDetails, wasteDisposalDetails, ewasteDetails, disposal, fugEmission, healthAspects,
            adequatePoll, indCompliance, relInfo, listDocuments, disposalQuantityDetails, recycleQuantityDetails, refurbishedQuantityDetails,           /*new fields added here*/
            totalQuantityDetails, ewasteIsManufacturerOrRefurbisher, chkConsent, chkBMW, chkHWM, chkSWM, facilityDetail, 
            renewalAuth, checkBoxButton, document1, document2, document3, document4, document5, document6, document7)    /*new fields added here*/
   
}
            

            
            byte[] b = new byte[(int) certFile.length()];

            


            FileInputStream fileInputStream = new FileInputStream(certFile);
            fileInputStream.read(b);

            def industryReg1 = IndustryRegMaster.get((params.indRegId).toLong())
            println("asasas222222222:::" + industryReg1);

            def fileLength = certFile.length()
            file1.applicationId = ewasteId
            println("file1.applicationId" + file1.applicationId)
            file1.size = fileLength / 1024  //f.getSize()
            file1.extension = "pdf"//extractExtension( f )
            file1.data = b;
            file1.name = "EWasteForm.pdf"

            file1.description = "EWaste Application Form"
            file1.createdBy = session.indUser
            println("file1.createdBy" + file1.createdBy)
            file1.updatedBy = session.indUser
            file1.typeOfFile = "EWasteForm"
            file1.applicationFor = "EWaste"
            file1.indreg = industryReg1
            println("link22222" + file1.indreg)
            def appFile=EWasteManagementFile.findAll("from EWasteManagementFile ew where ew.applicationId=? and typeOfFile='EWasteForm'",[eWasteInstance.id])
           if(appFile){
        	for(int i=0;i<appFile.size();i++){
        		appFile[i].delete();
           }
           }
            if (file1.save()) {
                println("saved")
                
               
		    	def feeaa=0.0
		    	render(view:'Payment',model:[feesPaid:feeaa,eWasteInstance:eWasteInstance])
		    	//render(view: 'confirmationSubmit', model: [eWasteInstance: eWasteInstance, indRegInstance: indRegInstance])
            } else {

            }
            file1.errors.allErrors.each {
                println it


            }

        }






        println("Params---------------------> " + params)
        println("hie m here---")

        if (eWasteInstance.save()) {
            println("saved")
        } else {
            eWasteInstance.errors.allErrors.each {
                println it
                render(view: 'create', model: [eWasteInstance: eWasteInstance])


            }
        }


    }
    // satish code ends

//****************************************************************************************************************************

    def viewEEWPdf = {
        try {
            println("PARAMS in viewEEWPdf----------"+params);
        	def application1
            application1 = EWasteManagementFile.findAll(" from EWasteManagementFile as crf where crf.applicationId=? and crf.typeOfFile='EWasteForm'", [(params.appliLoc.toLong())])
            if (application1) {
                def application = application1[0]
                def applicationInstance = application
                response.setContentType("application-xdownload")
                response.setHeader("Content-Disposition", "attachment;filename=${applicationInstance.name}")
                response.getOutputStream() << new ByteArrayInputStream(applicationInstance.data)
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    /* def viewInspectionPdf*/

//************************************************************************************************************************************8


    def viewEEWCert = {
        try {
            def industryId = session.indUser
            def userId = session.userMaster
            if ((userId == null || userId == "") && (industryId == null || industryId == "")) {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }

            def application = EWasteManagementCertificates.get((params.id).toLong())
            def applicationFileSingleInstance = application
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def confirmationSubmit = {}
    def confirmationShow = {
        try {
            if (!params.edit || params.edit == "") {

                def eWasteInstance = EWaste.get((params.id).toLong())
                def indRegInstance = eWasteInstance.industryReg
                def indRegInstanceId = indRegInstance.id
                def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)
                def listDoc = new ArrayList()

                def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [eWasteInstance])

                for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                    def boolCheck = false
                    if (listDoc.size() == 0) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }
                    for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                        if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                            boolCheck = true
                        }
                    }
                    if (boolCheck == false) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }

                }

                render(view: 'show', model: [listDoc: listDoc, eWasteInstance: eWasteInstance, indRegInstance: indRegInstance])

            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def createSingle = {
        try {
            def eeWasteInstance = new EWaste()
            IndUser indUserInstance = (IndUser) session.indUser
            def induserQuery = IndUser.get(indUserInstance.id)


            def indRegInstance = indUserInstance.industryReg
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

            eeWasteInstance.properties = params

            return ['eeWasteInstance': eeWasteInstance, indRegInstance: indRegInstance]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def goToShow = {
        try {
            def cessReturnInstanceValue = (params.cessInstanceId).toLong()
            def cessInstance = CessReturn.get(cessReturnInstanceValue)

            redirect(action: show, id: cessInstance.id)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveCreateSingle = {
        try {
            def redirectBack = false
            def checkingMonth = false
            def indID = (params.indRegId).toLong()
            def indRegInstance = IndustryRegMaster.get(indID)


            def cessReturnInstance = new CessReturn()
            def fromDate = params.FromDate

            def fromMonth = params.FromMonth

            if (fromMonth == "January") {
                fromMonth = "01"
            } else if (fromMonth == "February") {
                fromMonth = "02"
            } else if (fromMonth == "March") {
                fromMonth = "03"
            } else if (fromMonth == "April") {
                fromMonth = "04"
            } else if (fromMonth == "May") {
                fromMonth = "05"
            } else if (fromMonth == "June") {
                fromMonth = "06"
            } else if (fromMonth == "July") {
                fromMonth = "07"
            } else if (fromMonth == "August") {
                fromMonth = "08"
            } else if (fromMonth == "September") {
                fromMonth = "09"
            } else if (fromMonth == "October") {
                fromMonth = "10"
            } else if (fromMonth == "November") {
                fromMonth = "11"
            } else if (fromMonth == "December") {
                fromMonth = "12"
            }

            def fromYear = params.FromYear
            String appliedFromDate = fromYear + "/" + fromMonth + "/" + fromDate

            //session.fromMonth = fromMonth
            //session.fromYear = fromYear
            def toMonth = params.ToMonth

            if (toMonth == "January") {
                toMonth = "01"
            } else if (toMonth == "February") {
                toMonth = "02"
            } else if (toMonth == "March") {
                toMonth = "03"
            } else if (toMonth == "April") {
                toMonth = "04"
            } else if (toMonth == "May") {
                toMonth = "05"
            } else if (toMonth == "June") {
                toMonth = "06"
            } else if (toMonth == "July") {
                toMonth = "07"
            } else if (toMonth == "August") {
                toMonth = "08"
            } else if (toMonth == "September") {
                toMonth = "09"
            } else if (toMonth == "October") {
                toMonth = "10"
            } else if (toMonth == "November") {
                toMonth = "11"
            } else if (toMonth == "December") {
                toMonth = "12"
            }

            def toYear = params.ToYear.toInteger()
            //session.toYear = toYear
            //session.toMonth = toMonth
            def toDate = params.ToDate


            String appliedToDate = toYear + "/" + toMonth + "/" + toDate


            def startDate1 = appliedFromDate
            def endDate1 = appliedToDate
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
            session.sqlDate = sqlDate
            session.sqlDate2 = sqlDate2

            def abcd = (indRegInstance.id).toLong()
            def db = new Sql(dataSource) // Create a new instance of groovy.sql.Sql with the DB of the Grails app


            def allApplicationInstance = CessReturn.findAll("from CessReturn abc where abc.industryReg.id=?", [abcd])

            if (allApplicationInstance) {
                for (int i = 0; i < allApplicationInstance.size(); i++) {

                    def rejectInstance = CessReturn.find("from CessReturn abc where abc.applicationStatus = 'rejected' and abc.id = ?  order by id desc", [allApplicationInstance.get(i).id])

                    def checkFromDate = db.rows("SELECT cessdatecheck FROM cessReturnView where industry_reg_id='" + abcd + "' and id='" + allApplicationInstance[i] + "' ORDER BY cessdatecheck DESC LIMIT 1");

                    def checkFromDate1 = db.rows("SELECT cessdatecheck FROM cessReturnView where industry_reg_id='" + abcd + "' and id='" + allApplicationInstance[i] + "' ORDER BY cessdatecheck ASC LIMIT 1");

                    if (checkFromDate || checkFromDate1) {
                        String cessdatecheckSmall = checkFromDate1.cessdatecheck.toString()
                        String year = cessdatecheckSmall.substring(1, 5);
                        String month = cessdatecheckSmall.substring(6, 8);
                        String day = cessdatecheckSmall.substring(9, 11);

                        String lD = year + "/" + month + "/" + day

                        def leastDate1 = lD
                        b = sdfh.parse(leastDate1)



                        leastDate = new java.sql.Date(b.getTime())


                        String cessdatecheckLarge = checkFromDate.cessdatecheck.toString()
                        String year1 = cessdatecheckLarge.substring(1, 5);
                        String month1 = cessdatecheckLarge.substring(6, 8);
                        String day1 = cessdatecheckLarge.substring(9, 11);
                        String uD = year1 + "/" + month1 + "/" + day1

                        def upperDate1 = uD
                        a = sdfh.parse(upperDate1)


                        upperDate = new java.sql.Date(a.getTime())


                        def upperMonth = month1

                        if (upperMonth == "01") {
                            upperMonth = "January"
                        } else if (upperMonth == "02") {
                            upperMonth = "February"
                        } else if (upperMonth == "03") {
                            upperMonth = "March"
                        } else if (upperMonth == "04") {
                            upperMonth = "April"
                        } else if (upperMonth == "05") {
                            upperMonth = "May"
                        } else if (upperMonth == "06") {
                            upperMonth = "June"
                        } else if (upperMonth == "07") {
                            upperMonth = "July"
                        } else if (upperMonth == "08") {
                            upperMonth = "August"
                        } else if (upperMonth == "09") {
                            upperMonth = "September"
                        } else if (upperMonth == "10") {
                            upperMonth = "October"
                        } else if (upperMonth == "11") {
                            upperMonth = "November"
                        } else if (upperMonth == "12") {
                            upperMonth = "December"
                        }

                        monthYear = upperMonth + "/" + year1
                    }


                    if ((sqlDate >= leastDate && sqlDate <= upperDate) || (sqlDate2 <= upperDate && sqlDate2 >= leastDate)) {
                        if (!rejectInstance) {
                            redirectBack = true
                        }
                    }


                }


            }

            if (sqlDate > new Date() || sqlDate > new Date()) {

                flash.message = "You cannot apply CESS Return for future period. "
                cessReturnInstance = new CessReturn()
                IndUser indUserInstance = (IndUser) session.indUser
                def induserQuery = IndUser.get(indUserInstance.id)
                def district = indRegInstance.district.districtName
                def tehsil = indRegInstance.tehsil.tehsilName
                cessReturnInstance.properties = params
                render(view: 'createSingle', model: ['cessReturnInstance': cessReturnInstance, indRegInstance: indRegInstance, district: district, tehsil: tehsil])

            } else if (redirectBack) {
                flash.message = "You cannot apply CESS Return for the period ${appliedFromDate} to ${appliedToDate} "
                cessReturnInstance = new CessReturn()
                IndUser indUserInstance = (IndUser) session.indUser
                def induserQuery = IndUser.get(indUserInstance.id)
                def district = indRegInstance.district.districtName
                def tehsil = indRegInstance.tehsil.tehsilName
                cessReturnInstance.properties = params
                render(view: 'createSingle', model: ['cessReturnInstance': cessReturnInstance, indRegInstance: indRegInstance, district: district, tehsil: tehsil])

            } else if (sqlDate > sqlDate2) {

                flash.message = "Cess Applied From Month & Year should be Greater than Cess Applied To Month & Year"
                cessReturnInstance = new CessReturn()
                IndUser indUserInstance = (IndUser) session.indUser
                def induserQuery = IndUser.get(indUserInstance.id)
                def district = indRegInstance.district.districtName
                def tehsil = indRegInstance.tehsil.tehsilName
                cessReturnInstance.properties = params
                render(view: 'createSingle', model: ['cessReturnInstance': cessReturnInstance, indRegInstance: indRegInstance, district: district, tehsil: tehsil])

            } else {

                cessReturnInstance.cessAppliedFromDate = sqlDate
                cessReturnInstance.cessAppliedToDate = sqlDate2
                def firstDayInteger = 0
                def lastDayInteger = 11
                if (params.firstDay) {
                    firstDayInteger = (params.firstDay).toInteger()
                }
                if (params.lastDay) {
                    lastDayInteger = (params.lastDay).toInteger()
                }
                if (firstDayInteger < lastDayInteger) {
                    //cessReturnInstance.firstDayReading=firstDayInteger
                    //cessReturnInstance.lastDayReading=lastDayInteger
                    cessReturnInstance.industryReg = indRegInstance
                    IndUser indUserInstance = (IndUser) session.indUser
                    cessReturnInstance.createdBy = (indUserInstance.id).toString()
                    cessReturnInstance.updatedBy = (indUserInstance.id).toString()
                    cessReturnInstance.completionStatus = "Pending"
                    cessReturnInstance.applicationStatus = "In Progress"
                    cessReturnInstance.assessmentIssue = false
                    cessReturnInstance.assessmentOrder = false
                    cessReturnInstance.fees = false
                    cessReturnInstance.feesNotice = false
                    cessReturnInstance.inspection = false
                    cessReturnInstance.inspectionClose = false
                    def checking = CessReturn.findAllByIndustryReg(indRegInstance)

                    if (!checkingMonth) {
                        if (!cessReturnInstance.hasErrors() && cessReturnInstance.save()) {
                            redirect(action: createNewPageForPurpose, id: cessReturnInstance.id)
                        } else {
                            render(view: 'createSingle', model: [cessReturnInstance: cessReturnInstance])
                        }
                    }
                } else {
                    flash.message = "First Day reading cannot be more than Last Day reading."
                    redirect(action: createSingle)
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def createPurposePage = {
        try {
            IndUser indUserInstance = (IndUser) session.indUser
            def induserQuery = IndUser.get(indUserInstance.id)

            def indRegInstance = indUserInstance.industryRegMaster
            def indRegInstanceId = indRegInstance.id

            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

            def sourceMaster = CessSourceConsumptionMaster.list()
            def cessReturnInstance = (params.id).toLong()
            def cessInstance = CessReturn.get(cessReturnInstance)

            def cessPurposeDetailInstance = CessPurposeDetails.findAll("from CessPurposeDetails where cessreturn=? order by purpose.id asc", [cessInstance])

            def purpose = cessPurposeDetailInstance.purpose.purpose
            def sourceInstance = CessSourceDetails.findAll("from CessSourceDetails where cessreturn=? order by source.id asc", [cessInstance])
            def source = sourceInstance.source
            def cessReturnDetailsInstance = new CessReturnDetails()
            cessReturnDetailsInstance.properties = params
            return ['cessReturnDetailsInstance': cessReturnDetailsInstance, source: source, cessPurposeDetailInstance: cessPurposeDetailInstance, sourceMaster: sourceMaster, cessInstance: cessInstance, indRegInstance: indRegInstance]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def createNewPageForPurpose = {
        try {
            def sourceMaster = CessSourceConsumptionMaster.list()
            return ['sourceMaster': sourceMaster]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def createNewPageForPurpose1 = {
        try {
            def flag
            def newInstancePurpose = new CessPurposeDetails()
            def newInstancePurpose1 = new CessPurposeDetails()
            def newInstancePurpose2 = new CessPurposeDetails()
            def newInstancePurpose3 = new CessPurposeDetails()
            def newInstancePurpose4 = new CessPurposeDetails()
            def newInstancePurpose5 = new CessPurposeDetails()
            def newInstancePurpose6 = new CessPurposeDetails()
            def newInstancePurpose7 = new CessPurposeDetails()

            def newInstanceSource = new CessSourceDetails()
            def newInstanceSource1 = new CessSourceDetails()
            def newInstanceSource2 = new CessSourceDetails()
            def newInstanceSource3 = new CessSourceDetails()
            def newInstanceSource4 = new CessSourceDetails()

            def redirectBack = false
            def redirectBack1 = false
            def cessReturnInstance = (params.id).toLong()
            def cessInstance = CessReturn.get(cessReturnInstance)


            def purpose = CessPurposeDetails.findAllByCessreturn(cessInstance)
            def purpose1 = purpose.purpose

            def source = CessSourceDetails.findAllByCessreturn(cessInstance)
            def source1 = source.source
            if (params['2. Domestic Purpose'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(2)

                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose.purpose = domId

                    newInstancePurpose.cessreturn = cessInstance
                    newInstancePurpose.save()
                }
            }

            if (params['1. Industrial Cooling,Spraying in Mine Pits or Boiler Feeds'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(1)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose1.purpose = domId
                    newInstancePurpose1.cessreturn = cessInstance
                    newInstancePurpose1.save()
                }
            }
            if (params['3.(a) Processing whereby water gets polluted and the Pollutants are easily bio-degradable'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(3)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose2.purpose = domId
                    newInstancePurpose2.cessreturn = cessInstance
                    newInstancePurpose2.save()
                }
            }
            if (params['3.(b) Processing whereby water gets polluted & the pollutants are non Toxic'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(4)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose3.purpose = domId
                    newInstancePurpose3.cessreturn = cessInstance
                    newInstancePurpose3.save()
                }
            }

            if (params['3.(c) Processing whereby water gets polluted & the pollutants are both non Toxic and easily bio-degradable'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(5)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose4.purpose = domId
                    newInstancePurpose4.cessreturn = cessInstance
                    newInstancePurpose4.save()
                }
            }

            if (params['4.(a) Processing whereby water gets polluted & the pollutants are  not easily bio-degradable  '] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(6)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose5.purpose = domId
                    newInstancePurpose5.cessreturn = cessInstance
                    newInstancePurpose5.save()
                }
            }
            if (params['4.(b) Processing whereby water gets polluted & the pollutants are Toxic'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(7)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose6.purpose = domId
                    newInstancePurpose6.cessreturn = cessInstance
                    newInstancePurpose6.save()
                }
            }
            if (params['4.(c) Processing whereby water gets polluted & the pollutants are both Toxic and not easily bio-degradable'] == "on") {
                def domId = CessWaterConsumptionPurposeMaster.get(8)
                if (purpose1.contains(domId)) {
                    flash.message = "This Purpose is already selected.Please select some other purpose.!!"
                    redirectBack = true
                } else {
                    newInstancePurpose7.purpose = domId
                    newInstancePurpose7.cessreturn = cessInstance
                    newInstancePurpose7.save()
                }
            }
            if (params['Muncipal Water Supply Mains'] == "on") {
                def domId = CessSourceConsumptionMaster.get(1)
                if (source1.contains(domId)) {
                    flash.message = "This Source is already selected.Please select some other source.!!"
                    redirectBack = true
                } else {
                    newInstanceSource.source = domId
                    newInstanceSource.cessreturn = cessInstance
                    newInstanceSource.save()
                }
            }
            if (params['Well Tubewell'] == "on") {
                def domId = CessSourceConsumptionMaster.get(2)
                if (source1.contains(domId)) {
                    flash.message = "This Source is already selected.Please select some other source.!!"
                    redirectBack = true
                } else {
                    newInstanceSource1.source = domId
                    newInstanceSource1.cessreturn = cessInstance
                    newInstanceSource1.save()
                }
            }
            if (params['Canal'] == "on") {
                def domId = CessSourceConsumptionMaster.get(3)
                if (source1.contains(domId)) {
                    flash.message = "This Source is already selected.Please select some other source.!!"
                    redirectBack = true
                } else {
                    newInstanceSource2.source = domId
                    newInstanceSource2.cessreturn = cessInstance
                    newInstanceSource2.save()
                }
            }
            if (params['River'] == "on") {
                def domId = CessSourceConsumptionMaster.get(4)
                if (source1.contains(domId)) {
                    flash.message = "This Source is already selected.Please select some other source.!!"
                    redirectBack = true
                } else {
                    newInstanceSource3.source = domId
                    newInstanceSource3.cessreturn = cessInstance
                    newInstanceSource3.save()
                }
            }
            if (params['Other'] == "on") {
                def domId = CessSourceConsumptionMaster.get(5)
                if (source1.contains(domId)) {
                    flash.message = "This Source is already selected.Please select some other source.!!"
                    redirectBack = true
                } else {
                    newInstanceSource4.source = domId
                    newInstanceSource4.cessreturn = cessInstance
                    newInstanceSource4.save()
                }
            }


            if (redirectBack) {
                redirect(action: createNewPageForPurpose, id: cessInstance)

            } else {


                IndUser indUserInstance = (IndUser) session.indUser
                def induserQuery = IndUser.get(indUserInstance.id)

                def indRegInstance = indUserInstance.industryRegMaster
                def indRegInstanceId = indRegInstance.id

                def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

                def sourceMaster = CessSourceConsumptionMaster.list()

                def cessReturnDetailsInstance = new CessReturnDetails()
                cessReturnDetailsInstance.properties = params
                redirect(action: createPurposePage, id: cessInstance)
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def singleDeletePurpose = {
        try {
            def industryId = params.indRegId
            IndUser indUserInstance = (IndUser) session.indUser
            def industryReg = IndustryRegMaster.get(params.indRegId)

            def cessReturnInstanceValue = (params.cessInstanceId).toLong()
            def cessInstance = CessReturn.get(cessReturnInstanceValue)
            def cessDetailList = CessReturnDetails.findAll("from CessReturnDetails as cr where cr.cessReturn=?", [cessInstance])
            if (params.delete1 == "checked") {
                // def cessFile = CessFileRecord.get((params.delete1).toInteger())
                def cessFile = CessFileRecord.find("from CessFileRecord as cr where cr.cessReturn=?", [cessInstance])

                if (cessFile) {


                    cessFile.delete()
                }

            }
            //def app = IndApplicationDetails.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                cessDetailList = CessReturnDetails.get((params.delete).toInteger())

                cessDetailList.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        cessDetailList = CessReturnDetails.get((params.delete[i]).toInteger())

                        cessDetailList.delete()
                    }
            }
            flash.message = "Entry Has been deleted!!"
            //render(view:'deletePurposePage',model:[cessReturnDetailsInstance:cessReturnDetailsInstance,source:source,cessPurposeDetailInstance:cessPurposeDetailInstance,sourceMaster:sourceMaster,cessInstance:cessInstance,indRegInstance:indRegInstance])

            render(view: 'deletePurposePage', model: [cessInstance: cessInstance])
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def extractExtension(MultipartFile file) {
        try {
            String filename = file.getOriginalFilename()
            return filename.substring(filename.lastIndexOf(".") + 1)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewFileClarification = {
        try {
            def application = params.appliLoc.toLong()
            def type = params.docName
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile afr where afr.applicationId=? and afr.typeOfFile='indClarificationFile' order by afr.dateCreated desc", [application], [max: 1])
            def applicationFileSingleInstance = applicationFileInstance[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=\"" + applicationFileSingleInstance.name + "\"")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    ///////for add view deletes////////////


    def EWpopProductionDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def productDetailsList = EWasteIndProductionDetails.findAllByApplication(app)

            return [appDetId: params.id, productDetailsList: productDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopProductionDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def productDetailsList = EWasteIndProductionDetails.findAllByApplication(app)
            return [appDetId: params.id, productDetailsList: productDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopProductionDetailsedit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def productDetailsList = EWasteIndProductionDetails.findAllByApplication(app)
            return [appDetId: params.id, productDetailsList: productDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def deleteEWProductionDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indProdDetInst = EWasteIndProductionDetails.get((params.delete).toInteger())
                indProdDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indProdDetInst = EWasteIndProductionDetails.get((params.delete[i]).toInteger())
                        indProdDetInst.delete()
                    }
            }
            redirect(action: EWpopProductionDetailsedit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWProductionDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def indProductDetailsInstanceList = new ArrayList()

            def indProductDetailsInstance = new EWasteIndProductionDetails()
            indProductDetailsInstance.application = app
            indProductDetailsInstance.product = params.product
            indProductDetailsInstance.capacity = params.capacity


            indProductDetailsInstance.save()
            indProductDetailsInstanceList.add(indProductDetailsInstance)


            flash.message = "Details Saved"
            redirect(action: EWpopProductionDetailsAdd, id: app)
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////	//


    def EWpopProductDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def productDetailsList = EWasteIndProductDetails.findAllByApplication(app)

            return [appDetId: params.id, productDetailsList: productDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopProductDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def productDetailsList = EWasteIndProductDetails.findAllByApplication(app)
            return [appDetId: params.id, productDetailsList: productDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopProductDetailsedit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def productDetailsList = EWasteIndProductDetails.findAllByApplication(app)
            return [appDetId: params.id, productDetailsList: productDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def deleteEWProductDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indProdDetInst = EWasteIndProductDetails.get((params.delete).toInteger())
                indProdDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indProdDetInst = EWasteIndProductDetails.get((params.delete[i]).toInteger())
                        indProdDetInst.delete()
                    }
            }
            redirect(action: EWpopProductDetailsedit, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWProductDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def indProductDetailsInstanceList = new ArrayList()

            def indProductDetailsInstance = new EWasteIndProductDetails()
            indProductDetailsInstance.application = app
            indProductDetailsInstance.product = params.product
            indProductDetailsInstance.quantity = params.quantity
            indProductDetailsInstance.year = params.year

            def unit = UnitMaster.get((params.unit).toInteger())
            indProductDetailsInstance.unit = unit
            indProductDetailsInstance.save()
            indProductDetailsInstanceList.add(indProductDetailsInstance)


            flash.message = "Details Saved"
            redirect(action: EWpopProductDetailsAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////	//


    def EWpopWasteGenDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def wasteGenList = EWasteGenDetails.findAllByApplication(app)

            return [appDetId: params.id, wasteGenList: wasteGenList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWasteGenDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def wasteGenList = EWasteGenDetails.findAllByApplication(app)
            return [appDetId: params.id, wasteGenList: wasteGenList]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def EWpopWasteGenDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def wasteGenList = EWasteGenDetails.findAllByApplication(app)
            return [appDetId: params.id, wasteGenList: wasteGenList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def deleteEWasteGenDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indProdDetInst = EWasteGenDetails.get((params.delete).toInteger())
                indProdDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indProdDetInst = EWasteGenDetails.get((params.delete[i]).toInteger())
                        indProdDetInst.delete()
                    }
            }
            redirect(action: EWpopWasteGenDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWasteGenDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def wasteGenDetailsInstanceList = new ArrayList()
            def wasteGenDetailsInstance = new EWasteGenDetails()
            wasteGenDetailsInstance.application = app
            wasteGenDetailsInstance.type = params.type
            wasteGenDetailsInstance.category = params.category
            wasteGenDetailsInstance.quantity = params.quantity
            def unit = UnitMaster.get((params.unit).toInteger())
            wasteGenDetailsInstance.unit = unit
            wasteGenDetailsInstance.save()
            wasteGenDetailsInstanceList.add(wasteGenDetailsInstance)


            flash.message = "Details Saved"
            redirect(action: EWpopWasteGenDetailsAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////	//


    def EWpopWasteDisposalDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def wasteDisposalList = EWasteDisposalDetails.findAllByApplication(app)

            return [appDetId: params.id, wasteDisposalList: wasteDisposalList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWasteDisposalDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def wasteDisposalList = EWasteDisposalDetails.findAllByApplication(app)
            return [appDetId: params.id, wasteDisposalList: wasteDisposalList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWasteDisposalDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def wasteDisposalList = EWasteDisposalDetails.findAllByApplication(app)
            return [appDetId: params.id, wasteDisposalList: wasteDisposalList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def deleteEWasteDisposalDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indProdDetInst = EWasteDisposalDetails.get((params.delete).toInteger())
                indProdDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indProdDetInst = EWasteDisposalDetails.get((params.delete[i]).toInteger())
                        indProdDetInst.delete()
                    }
            }
            redirect(action: EWpopWasteDisposalDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWasteDisposalDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def wasteDisposalDetailsInstanceList = new ArrayList()
            def wasteDisposalDetailsInstance = new EWasteDisposalDetails()
            wasteDisposalDetailsInstance.application = app
            wasteDisposalDetailsInstance.type = params.type
            wasteDisposalDetailsInstance.category = params.category
            wasteDisposalDetailsInstance.quantity = params.quantity
            def unit = UnitMaster.get((params.unit).toInteger())
            wasteDisposalDetailsInstance.unit = unit
            wasteDisposalDetailsInstance.save()
            wasteDisposalDetailsInstanceList.add(wasteDisposalDetailsInstance)

            flash.message = "Details Saved"
            redirect(action: EWpopWasteDisposalDetailsAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////	//


    def EWpopRawMaterialsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app for raw material"+app)
            def rawMaterialDetailList = EWasteRawMaterialDetails.findAllByApplication(app)
            System.out.println("rawMaterialDetailList......."+rawMaterialDetailList)
            return [appDetId: params.id, rawMaterialDetailList: rawMaterialDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWRawMaterialDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def rawMaterialDetailInst = new EWasteRawMaterialDetails(params)
            rawMaterialDetailInst.application = app
            rawMaterialDetailInst.year = params.year
            rawMaterialDetailInst.rawMaterialName = params.rawMaterialName
            rawMaterialDetailInst.quantity = params.quantity
            def unit = UnitMaster.get((params.unit).toInteger())
            rawMaterialDetailInst.unit = unit
            rawMaterialDetailInst.save()
            flash.message = "Details Saved"
            redirect(action: EWpopRawMaterialsAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopRawMaterialsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def rawMaterialDetailList = EWasteRawMaterialDetails.findAllByApplication(app)

            return [appDetId: params.id, rawMaterialDetailList: rawMaterialDetailList]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def EWpopRawMaterialsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def rawMaterialDetailList = EWasteRawMaterialDetails.findAllByApplication(app)
            return [appDetId: params.id, rawMaterialDetailList: rawMaterialDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def editEWRawMaterialDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {

                def rawMaterialDetails = EWasteRawMaterialDetails.get((params.delete).toInteger())
                rawMaterialDetails.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def rawMaterialDetails = EWasteRawMaterialDetails.get((params.delete[i]).toInteger())
                        rawMaterialDetails.delete()
                    }
            }
            redirect(action: EWpopRawMaterialsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

/////////////////////////for water avd///


    def EWpopWaterConsumptionDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterUsesDetails.findAllByApplication(app)

            return [appDetId: params.id, waterGenarationList: waterGenarationList]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWaterConsumptionDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterUsesDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def deleteEWWaterConsumptionDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indPowerDetInst = EWasteWaterUsesDetails.get((params.delete).toInteger())
                indPowerDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indPowerDetInst = EWasteWaterUsesDetails.get((params.delete[i]).toInteger())
                        indPowerDetInst.delete()
                    }
            }
            redirect(action: EWpopWaterConsumptionDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def EWpopWaterConsumptionDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterUsesDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def saveEWWaterSourceUses = {
        try {

            def waterUsesDetails = new EWasteWaterUsesDetails(params)
            waterUsesDetails.use = WaterUsesMaster.get((params.waterSourceUses.id).toInteger())

            Float f = new Float(params.sourceUseQuantity)
            waterUsesDetails.quantity = f
            waterUsesDetails.application = EWaste.get((params.app).toInteger())

            waterUsesDetails.save()

            flash.message = "Details Saved"
            redirect(action: EWpopWaterConsumptionDetailsAdd, id: params.app, model: [app: params.app])
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		/


    def EWpopWaterTreatmentDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterTreatmentDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWaterTreatmentDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterTreatmentDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    // *********By Gajendra 03/07/2015*************
    def deleteEWWaterTreatmentDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indPowerDetInst = EWasteWaterTreatmentDetails.get((params.delete).toInteger())
                indPowerDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indPowerDetInst = EWasteWaterTreatmentDetails.get((params.delete[i]).toInteger())
                        indPowerDetInst.delete()
                    }
            }
            redirect(action: EWpopWaterTreatmentDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    // *****************Ends**************
    def deleteEWasteWaterTreatmentDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indPowerDetInst = EWasteWaterTreatmentDetails.get((params.delete).toInteger())
                indPowerDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indPowerDetInst = EWasteWaterTreatmentDetails.get((params.delete[i]).toInteger())
                        indPowerDetInst.delete()
                    }
            }
            redirect(action: EWpopWaterTreatmentDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def EWpopWaterTreatmentDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterTreatmentDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def saveEWWaterTreatmentDetails = {
        try {
            def waterUsesDetails = new EWasteWaterTreatmentDetails(params)
            waterUsesDetails.use = WaterUsesMaster.get((params.waterSourceUses.id).toInteger())

            Float f = new Float(params.quantity)
            waterUsesDetails.quantity = f
            waterUsesDetails.application = EWaste.get((params.app).toInteger())

            waterUsesDetails.save()

            flash.message = "Details Saved"
            redirect(action: EWpopWaterTreatmentDetailsAdd, id: params.app, model: [app: params.app])
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		/


    def EWpopWaterDischargeDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterDischargeDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWaterDischargeDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterDischargeDetails.findAllByApplication(app)

            def appid = (params.id).toLong()

            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def deleteEWWaterDischargeDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indPowerDetInst = EWasteWaterDischargeDetails.get((params.delete).toInteger())
                indPowerDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indPowerDetInst = EWasteWaterDischargeDetails.get((params.delete[i]).toInteger())
                        indPowerDetInst.delete()
                    }


            }
            redirect(action: EWpopWaterDischargeDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def EWpopWaterDischargeDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())

            def waterGenarationList = EWasteWaterDischargeDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWWaterSourcedetails = {
        try {
            def waterUsesDetails = new EWasteWaterDischargeDetails(params)
            Float hh = new Float(params.quantity)
            waterUsesDetails.quantity = hh
            waterUsesDetails.location = params.location
            waterUsesDetails.application = EWaste.get((params.app).toInteger())

            waterUsesDetails.save()
            flash.message = "Details Saved"
            redirect(action: EWpopWaterDischargeDetailsAdd, id: params.app, model: [app: params.app])
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////		//


    def EWpopWaterGenerationDetailsAdd = {
        try {
            def d = params.d
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterModeUseDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def EWpopWaterGenerationDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterModeUseDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopWaterGenerationDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def waterGenarationList = EWasteWaterModeUseDetails.findAllByApplication(app)
            return [appDetId: params.id, waterGenarationList: waterGenarationList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def deleteEWWaterGenerationDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indPowerDetInst = EWasteWaterModeUseDetails.get((params.delete).toInteger())
                indPowerDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indPowerDetInst = EWasteWaterModeUseDetails.get((params.delete[i]).toInteger())
                        indPowerDetInst.delete()
                    }
            }
            redirect(action: EWpopWaterGenerationDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWWaterSourceModeUse = {
        try {
            def waterModeUseDetailsInst = new EWasteWaterModeUseDetails(params)
            //waterModeUseDetailsInst.source = sourceDetIns.source

            waterModeUseDetailsInst.modeUse = WaterUsesMaster.get((params.waterSourceUses.id).toInteger())

            Float f = new Float(params.quantity)

            waterModeUseDetailsInst.quantity = f

            waterModeUseDetailsInst.application = EWaste.get((params.app).toInteger())
            waterModeUseDetailsInst.save()



            flash.message = "Details Saved"
            redirect(action: EWpopWaterGenerationDetailsAdd, id: params.app, model: [app: params.app])

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    def EWpopAmbientAirStandardAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def ambientairqualitydetails = EWasteAmbientAirQualityStandardDetails.findAllByApplication(app)

            return [appDetId: params.id, ambientairqualitydetails: ambientairqualitydetails]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }
    def saveEWAmbientairqualitydetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def list = new ArrayList()

            def ambientairqualitydetails = new EWasteAmbientAirQualityStandardDetails()

            ambientairqualitydetails.location = params.location
            ambientairqualitydetails.spm = params.spm
            ambientairqualitydetails.so2 = params.so2
            ambientairqualitydetails.nox = params.nox
            ambientairqualitydetails.pb = params.pb

            ambientairqualitydetails.others = params.others



            ambientairqualitydetails.application = app

            ambientairqualitydetails.save()

            flash.message = "Details Saved"
            redirect(action: EWpopAmbientAirStandardAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopAmbientAirStandardView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def ambientairqualitydetails = EWasteAmbientAirQualityStandardDetails.findAllByApplication(app)

            return [appDetId: params.id, ambientairqualitydetails: ambientairqualitydetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopAmbientAirStandardEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def ambientairqualitydetails = EWasteAmbientAirQualityStandardDetails.findAllByApplication(app)

            return [appDetId: params.id, ambientairqualitydetails: ambientairqualitydetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def editEWambientairquality = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def ambientairqualitydetails = EWasteAmbientAirQualityStandardDetails.get((params.delete).toInteger())
                ambientairqualitydetails.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def ambientairqualitydetails = EWasteAmbientAirQualityStandardDetails.get((params.delete[i]).toInteger())
                        ambientairqualitydetails.delete()
                    }
            }
            redirect(action: EWpopAmbientAirStandardEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    def EWpopFuelconsumptionAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def fuelconsumptionDetails = EWasteFuelConsumptionDetails.findAllByApplication(app)

            return [appDetId: params.id, fuelconsumptionDetails: fuelconsumptionDetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveFuelconsumptiondetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def list = new ArrayList()

            def fuelconsumptionDetails = new EWasteFuelConsumptionDetails()

            fuelconsumptionDetails.fuel = params.fuel
            fuelconsumptionDetails.consumption = params.consumption


            fuelconsumptionDetails.application = app

            fuelconsumptionDetails.save()

            flash.message = "Details Saved"
            redirect(action: EWpopFuelconsumptionAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopFuelconsumptionView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def fuelconsumptionDetails = EWasteFuelConsumptionDetails.findAllByApplication(app)

            return [appDetId: params.id, fuelconsumptionDetails: fuelconsumptionDetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopFuelconsumptionEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def fuelconsumptionDetails = EWasteFuelConsumptionDetails.findAllByApplication(app)

            return [appDetId: params.id, fuelconsumptionDetails: fuelconsumptionDetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def editfuelconsumptiondetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def fuelconsumptionDetails = EWasteFuelConsumptionDetails.get((params.delete).toInteger())
                fuelconsumptionDetails.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def fuelconsumptionDetails = EWasteFuelConsumptionDetails.get((params.delete[i]).toInteger())
                        fuelconsumptionDetails.delete()
                    }
            }
            redirect(action: EWpopFuelconsumptionEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////

    def EWpopStackEmissionMonitoringAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def stackemissiondetails = EWasteStackEmissionMonitoring.findAllByApplication(app)

            return [appDetId: params.id, stackemissiondetails: stackemissiondetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWStackEmissionMonitoringdetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())

            //def list = new ArrayList()

            def stackemissiondetails = new EWasteStackEmissionMonitoring()

            stackemissiondetails.stack = params.stack
            stackemissiondetails.spm = params.spm
            stackemissiondetails.so2 = params.so2
            stackemissiondetails.nox = params.nox
            stackemissiondetails.pb = params.pb

            stackemissiondetails.others = params.others


            stackemissiondetails.application = app

            stackemissiondetails.save()

            flash.message = "Details Saved"
            redirect(action: EWpopStackEmissionMonitoringAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def EWpopStackEmissionMonitoringView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def stackemissiondetails = EWasteStackEmissionMonitoring.findAllByApplication(app)

            return [appDetId: params.id, stackemissiondetails: stackemissiondetails]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def EWpopStackEmissionMonitoringEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def stackemissiondetails = EWasteStackEmissionMonitoring.findAllByApplication(app)
            return [appDetId: params.id, stackemissiondetails: stackemissiondetails]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def editEWstackemissionmonitoring = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def stackemissiondetails = EWasteStackEmissionMonitoring.get((params.delete).toInteger())
                stackemissiondetails.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def stackemissiondetails = EWasteStackEmissionMonitoring.get((params.delete[i]).toInteger())
                        stackemissiondetails.delete()
                    }
            }
            redirect(action: EWpopStackEmissionMonitoringEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    def EWpopEWasteDetailsAdd = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def ewasteDetailsList = EWasteDetails.findAllByApplication(app)

            return [appDetId: params.id, ewasteDetailsList: ewasteDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopEWasteDetailsView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def ewasteDetailsList = EWasteDetails.findAllByApplication(app)
            return [appDetId: params.id, ewasteDetailsList: ewasteDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def EWpopEWasteDetailsEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def ewasteDetailsList = EWasteDetails.findAllByApplication(app)
            return [appDetId: params.id, ewasteDetailsList: ewasteDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def deleteEWasteDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {
                def indProdDetInst = EWasteDetails.get((params.delete).toInteger())
                indProdDetInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def indProdDetInst = EWasteDetails.get((params.delete[i]).toInteger())
                        indProdDetInst.delete()
                    }
            }
            redirect(action: EWpopEWasteDetailsEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEWasteDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def ewasteDetailsInstanceList = new ArrayList()

            def ewasteDetailsInstance = new EWasteDetails()
            ewasteDetailsInstance.application = app
            ewasteDetailsInstance.name = params.name
            ewasteDetailsInstance.quantity = params.quantity
            ewasteDetailsInstance.conventionNo = params.conventionNo

            ewasteDetailsInstance.save()
            ewasteDetailsInstanceList.add(ewasteDetailsInstance)


            flash.message = "Details Saved"
            redirect(action: EWpopEWasteDetailsAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////	//

///////////////////////////////////////code for docs//////////////////////////////////////////////////

    def popUploadDoc = {

        try {
        	println("--params.id-"+params.id)
            def app = EWaste.get((params.id).toInteger())
           // def docList = DocumentChecklistMaster.list()
           
           def certFor="eWaste"  
           
           def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor=?  order by abc.id asc",[certFor])
	  	    	
            println("docList"+docList)
            
            
            //def feeDetailsList = FeeBankDetails.findAllByApplication(app)
            def listDoc = new ArrayList()
            def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [app])
            if (applicationDocumentInstance) {
                for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                    def boolCheck = false
                    if (listDoc.size() == 0) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }
                    for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                        if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                            boolCheck = true
                        }
                    }
                    if (boolCheck == false) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }

                }


            }


            return [appDetId: params.id, docList: docList, app: app, listDoc: listDoc]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }


    def popDeleteDoc = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def docList = DocumentChecklistMaster.list()
            //def feeDetailsList = FeeBankDetails.findAllByApplication(app)
            def listDoc = new ArrayList()

            def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [app])

            if (applicationDocumentInstance) {
                for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                    def boolCheck = false
                    if (listDoc.size() == 0) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }
                    for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                        if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                            boolCheck = true
                        }
                    }
                    if (boolCheck == false) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }

                }

            }


            return [appDetId: params.id, docList: docList, app: app, listDoc: listDoc]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def deleteDocs = {
        try {

            def app = EWaste.get((params.indAppId).toInteger())

            if ((params.delete).getClass().getName() == "java.lang.String") {
                def applicationDocumentInstance = ApplicationDocumentsEW.get((params.delete).toInteger())

                applicationDocumentInstance.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def applicationDocumentInstance = ApplicationDocumentsEW.get((params.delete[i]).toInteger())

                        applicationDocumentInstance.delete()
                    }
            }
            redirect(action: popDeleteDoc, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }


    }

    def saveDocs = {
        try {
             println("pramsas..: "+params)
            def app = EWaste.get((params.indAppId).toInteger())
            String apliId = (app.id).toString()
            def extn

            def apptype = "eWaste"




            def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor=? ", [apptype])
            MultipartFile multi
            for (int i = 0; i < docList.size(); i++) {
                def fileUpload = new ApplicationDocumentsEW()
                def f = request.getFile((docList.get(i)).document)
                if (!f.empty) {

                    multi = request.getFile((docList.get(i)).documentType)
                    fileUpload.size = multi.getSize() / 1024
                    fileUpload.level = docList.get(i)

                    fileUpload.data = multi.getBytes()
                    fileUpload.extension = extractExtension(multi)
                    def abc = ((docList.get(i)).document).replace(" ", "_")
                    def b = abc + "." + extractExtension(multi)
                    fileUpload.name = b


                    fileUpload.indApplication = app

                    if (fileUpload.save()) {
                        render(view: 'saveDocs', model: [app: app])
                    } else {


                        fileUpload.errors.each {
                            println it
                        }
                    }
                    // end //
                }
            }
            render(view: 'saveDocs', model: [app: app])
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveMoreDocs = {
        try {
            def app = EWaste.get((params.app).toInteger())
            String apliId = (app.id).toString()
            def extn

            def apptype = "E-Waste"


            def docList = DocumentChecklistMaster.findAll("from DocumentChecklistMaster doc where doc.applicationFor=? ", [apptype])
            def other1 = params.other
            def other = params.otherDoc
            MultipartFile multi
            def otherDoc = request.getFile("otherDoc")

            //        def applicationDocumentL=ApplicationDocuments.findAll("from ApplicationDocuments apd where apd.indApplication=? and apd.level=?",[app,docName],[max:1] )
            def fileUpload = new ApplicationDocumentsEW()

            //	def otherDoc = request.getFile("otherDoc")
            if (!otherDoc.empty) {

                multi = request.getFile("otherDoc")

                //   multi = request.getFile( (docList.get(i)).document)
                fileUpload.size = multi.getSize() / 1024
                fileUpload.level = other1

                fileUpload.data = multi.getBytes()
                fileUpload.extension = extractExtension(multi)
                fileUpload.name = multi.getOriginalFilename()


                fileUpload.indApplication = app

                if (fileUpload.save()) {

                    flash.message = "Document Uploaded Successfully"

                    render(view: 'saveDocs', model: [app: app])


                } else {
                    render(view: 'create', model: [fileUpload: fileUpload])
                }


            } else {

                flash.message = "Please Upload document"
                render(view: 'saveDocs', model: [app: app, other: params.other])
            }

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def viewFile1 = {
        try {
            def docType = params.docType
            def application = params.appliLoc
            def indApplInstance = EWaste.get((params.appliLoc).toInteger())
            def docName = params.docName
            def fileLoc
            def file
            def docFName = docName.replace(" ", "_")
            def applicationDocumentL = ApplicationDocumentsEW.findAll("from ApplicationDocumentsEW apd where apd.indApplication=? and apd.level=? order by apd.id desc", [indApplInstance, docName], [max: 1])
            def singleInstanceOfApplicationDocument = applicationDocumentL[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=\"" + singleInstanceOfApplicationDocument.name + "\"")
            response.getOutputStream() << new ByteArrayInputStream(singleInstanceOfApplicationDocument.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def viewFileShow = {
        try {
            def docType = params.docType
            def application = params.appliLoc
            def indApplInstance = EWaste.get((params.appliLoc).toInteger())
            def docName = params.docName
            def fileLoc
            def file
            def docFName = docName.replace(" ", "_")
            def applicationDocumentL = ApplicationDocumentsEW.findAll("from ApplicationDocumentsEW apd where apd.indApplication=? and apd.level=? order by apd.id desc", [indApplInstance, docName], [max: 1])
            System.out.println("applicationDocumentL.."+applicationDocumentL)

            def singleInstanceOfApplicationDocument = applicationDocumentL[0]
            System.out.println("singleInstanceOfApplicationDocument.."+singleInstanceOfApplicationDocument)
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=\"" + singleInstanceOfApplicationDocument.name + "\"")
            response.getOutputStream() << new ByteArrayInputStream(singleInstanceOfApplicationDocument.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

//////////////////////////////spcb pending list//////////////////////////////////////////////////////////////////////////	 //


    def pendingList = {
        try {
            def userProfileInstance = (UserMaster) session.userMaster
            def application
            def isClarList = new ArrayList()
            def isInspecList = new ArrayList()

            def appId

            def eWasteManagementPendingDetails = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wpd where wpd.pendingWith=? and wpd.applicationStatus='pending' order by wpd.dateCreated desc", [userProfileInstance])
            if (eWasteManagementPendingDetails) {
                for (int i = 0; i < eWasteManagementPendingDetails.size(); i++) {
                    def instancePend = eWasteManagementPendingDetails[i]
                    def appFor = instancePend.applicationFor
                    def appIdStr = instancePend.applicationId
                    appId = (instancePend.applicationId).toLong()
                    if (appFor == "EWaste") {
                        application = EWaste.get(appId)
                        isClarList.add(application.clarification)
                        isInspecList.add(application.inspection)
                    }

                }
            }
            
            def eWasteManagementCompletedDetails = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wpd where wpd.pendingWith=? and wpd.applicationStatus!='pending' order by wpd.dateCreated desc", [userProfileInstance])
           
            // ********** no uses coz completed application Tab is removed ********** By Gajendra 13/07/2015
            return [eWasteManagementCompletedDetails:eWasteManagementCompletedDetails,wasteManagementPendingList: eWasteManagementPendingDetails, isClarList: isClarList, isInspecList: isInspecList, appId: appId]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
/////////////////////////////////////////////////////////search application from spcb side//////////////////////////////////////////////////////////////////////
    def searchApp = {
        try {
            def userProfileInstance1 = (UserMaster) session.userMaster

            def userId = session.userMaster
            if (userId == null || userId == "") {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }

            def appIdListHazard = EWaste.findAll(" from EWaste cr where cr.completionStatus='completed' order by cr.id desc")
            //def appIdListHazard = HazardeousWasteAuthApp.findAllWhere(completionStatus : "Completed")


            List appIdList = new ArrayList()

            if (appIdListHazard.size() > 0) {

                for (EWaste EEW : appIdListHazard)
                    appIdList += EEW
            }



            return ['appIdList': appIdList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def viewSearchResult = {
        try {
            def userId = session.userMaster

            def accessLevelAdEm = userId.accessLevel
            if (userId == null || userId == "") {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }
            def appIdListHazard = EWaste.findAll(" from EWaste cr where cr.completionStatus='completed' order by cr.id desc")


            List appIdList = new ArrayList()

            if (appIdListHazard.size() > 0) {
                for (HazardeousWasteAuthApp EEW : appIdListHazard)
                    appIdList += EEW
            }



            def EWStatusList = new ArrayList()
            def EWPendingWith = new ArrayList()
            def EWPendingWithRole = new ArrayList()


            def EWInst

            if (params.searchOp == "ApplId") {
                if (params.idList == null || params.idList == "xyz") {
                    flash.message = "Please Select the Application Id"
                    redirect(action: searchApp)
                } else {


                    def appId = (params.idList).toLong()
                    if (params.appTypeName == "xyz") {
                        EWInst = EWaste.findAllWhere(id: appId)
                        if (EWInst.size() > 0) {
                            for (EWaste EEW : EWInst) {
                                def checkInst = EWasteManagementPendingDetails.findByapplicationId((EEW.id).toString())
                                if (checkInst) {

                                    EWStatusList.add(checkInst.applicationStatus)
                                    EWPendingWith.add(checkInst.pendingWith)
                                    EWPendingWithRole.add(checkInst.role)
                                } else {
                                    EWStatusList.add("Unattended")
                                    EWPendingWith.add("Unknown")
                                    EWPendingWithRole.add("Unknown")
                                }
                            }

                        }


                        render(view: 'searchApp', model: [accessLevelAdEm: accessLevelAdEm, EWInst: EWInst, appIdList: appIdList, EWStatusList: EWStatusList, EWPendingWith: EWPendingWith, EWPendingWithRole: EWPendingWithRole])

                    } else {

                        if (params.appTypeName == "EWaste") {
                            EWInst = EWaste.findAllWhere(id: appId)
                            if (EWInst.size() > 0) {
                                for (EWaste EEW : EWInst) {
                                    def checkInst = EWasteManagementPendingDetails.findByapplicationId((EEW.id).toString())
                                    if (checkInst) {
                                        EWStatusList.add(checkInst.applicationStatus)
                                        EWPendingWith.add(checkInst.pendingWith)
                                        EWPendingWithRole.add(checkInst.role)
                                    } else {
                                        EWStatusList.add("Unattended")
                                        EWPendingWith.add("Unknown")
                                        EWPendingWithRole.add("Unknown")
                                    }
                                }

                            }
                        }

                        render(view: 'searchApp', model: [accessLevelAdEm: accessLevelAdEm, EWInst: EWInst, appIdList: appIdList, EWStatusList: EWStatusList, EWPendingWith: EWPendingWith, EWPendingWithRole: EWPendingWithRole])

                    }


                }
            } else if (params.searchOp == "ApplName") {
                if (params.autocomplete_parameter1 == null || params.autocomplete_parameter1 == "") {
                    flash.message = "Please Select the Industry Name"
                    redirect(action: searchApp)
                } else {
                    def firstInput = (params.autocomplete_parameter1).toLowerCase()

                    def input1 = firstInput + '%'
                    if (params.autocomplete_parameter1 == null || params.autocomplete_parameter1 == "") {
                        flash.message = "Please Write The Name Of Industry To Search"
                        redirect(action: searchApp)
                    } else {
                        def appIndName = params.autocomplete_parameter1

                        def indRegInstanceGet = IndustryRegMaster.findAll("from IndustryRegMaster as wmc where wmc.indName=? ", [appIndName])
                        if (indRegInstanceGet.size() <= 0) {
                            flash.message = "No industry of that name found"
                            redirect(action: searchApp)
                        } else {
                            def indId = (indRegInstanceGet[0].id).toLong()
                            if (params.appTypeName == "xyz") {
                                EWInst = EWaste.findAll("from EWaste as wmc where wmc.industryReg.id=? and wmc.completionStatus='completed' order by wmc.id desc ", [indId])
                                if (EWInst.size() > 0) {
                                    for (EWaste EEW : EWInst) {
                                        def checkInst = EWasteManagementPendingDetails.findByapplicationId((EEW.id).toString())
                                        if (checkInst) {
                                            EWStatusList.add(checkInst.applicationStatus)
                                            EWPendingWith.add(checkInst.pendingWith)
                                            EWPendingWithRole.add(checkInst.role)
                                        } else {
                                            EWStatusList.add("Unattended")
                                            EWPendingWith.add("Unknown")
                                            EWPendingWithRole.add("Unknown")
                                        }
                                    }

                                }



                                render(view: 'searchApp', model: [accessLevelAdEm: accessLevelAdEm, EWInst: EWInst, appIdList: appIdList, EWStatusList: EWStatusList, EWPendingWith: EWPendingWith, EWPendingWithRole: EWPendingWithRole])

                            } else {
                                if (params.appTypeName == "EWaste") {
                                    EWInst = EWaste.findAll("from EWaste as wmc where wmc.industryReg.id=? and wmc.completionStatus='completed' order by wmc.id desc", [indId])
                                    if (EWInst.size() > 0) {
                                        for (EWaste EEW : EWInst) {
                                            def checkInst = EWasteManagementPendingDetails.findByapplicationId((EEW.id).toString())
                                            if (checkInst) {
                                                EWStatusList.add(checkInst.applicationStatus)
                                                EWPendingWith.add(checkInst.pendingWith)
                                                EWPendingWithRole.add(checkInst.role)
                                            } else {
                                                EWStatusList.add("Unattended")
                                                EWPendingWith.add("Unknown")
                                                EWPendingWithRole.add("Unknown")
                                            }
                                        }

                                    }
                                }

                                render(view: 'searchApp', model: [accessLevelAdEm: accessLevelAdEm, EWInst: EWInst, appIdList: appIdList, EWStatusList: EWStatusList, EWPendingWith: EWPendingWith, EWPendingWithRole: EWPendingWithRole])

                            }


                        }
                    }
                }
            } else if (params.searchOp == "ApplDate") {
                def checkDate
                Date today = new Date();
                def x
                def y
                def startDate1 = params.start_date_value
                def endDate1 = params.end_date_value

                def finalListToPrint = new ArrayList()


                def statusType = params.statusType



                def hazardeousList
                def allFourH = new ArrayList()
                def appListH = new ArrayList()
                def statusListH = new ArrayList()
                def pendingWithH = new ArrayList()
                def pendingWithRoleH = new ArrayList()

                def checkBio = false
                try {
                    def sdfh = new SimpleDateFormat("dd/MM/yyyy");
                    x = sdfh.parse(startDate1); //Date
                    y = sdfh.parse(endDate1);  //Date
                    checkDate = "checked"
                }
                catch (Exception e) {
                    flash.message = "Enter Both The Dates in Correct Format "
                    redirect(action: wasteSummary)
                }
                if (checkDate) {
                    java.sql.Date sqlDate = new java.sql.Date(x.getTime())
                    java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())
                    sqlDate2.setDate((sqlDate2.getDate() + 1))
                    if (startDate1 && endDate1 && statusType == "xyz") {

                        hazardeousList = EWaste.findAll("from EWaste as EWa where EWa.completionStatus='completed' and EWa.applicationStatus != 'unattended' and EWa.dateCreated>=? and EWa.dateCreated<=? order by EWa.id desc", [sqlDate, sqlDate2])
                        if (hazardeousList) {
                            for (int a = 0; a < hazardeousList.size(); a++) {
                                allFourH = hazardeousList.get(a)
                                if (allFourH) {
                                    checkBio = true
                                    appListH.add((allFourH))
                                    def appliFor = "EWaste"
                                    def appliIdStr = (allFourH.id).toString()
                                    def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                    def checkInst = checkInstList[0]
                                    if (checkInst) {
                                        statusListH.add(checkInst.applicationStatus)
                                        pendingWithH.add(checkInst.pendingWith)
                                        pendingWithRoleH.add(checkInst.role)
                                    } else {
                                        statusListH.add("Unattended")
                                        pendingWithH.add("Unknown")
                                        pendingWithRoleH.add("Unknown")
                                    }
                                }
                            }
                        }


                    } else if (startDate1 && endDate1 && statusType != "xyz") {
                        if (statusType == "EWaste") {
                            hazardeousList = EWaste.findAll("from EWaste as EWa where EWa.completionStatus='completed' and EWa.applicationStatus != 'unattended' and EWa.dateCreated>=? and EWa.dateCreated<=? order by EWa.id desc", [sqlDate, sqlDate2])
                            if (hazardeousList) {
                                for (int a = 0; a < hazardeousList.size(); a++) {
                                    allFourH = hazardeousList.get(a)
                                    if (allFourH) {
                                        checkBio = true
                                        appListH.add((allFourH))
                                        def appliFor = "EWaste"
                                        def appliIdStr = (allFourH.id).toString()
                                        def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                        def checkInst = checkInstList[0]
                                        if (checkInst) {
                                            statusListH.add(checkInst.applicationStatus)
                                            pendingWithH.add(checkInst.pendingWith)
                                            pendingWithRoleH.add(checkInst.role)
                                        } else {
                                            statusListH.add("Unattended")
                                            pendingWithH.add("Unknown")
                                            pendingWithRoleH.add("Unknown")
                                        }
                                    }
                                }
                            }


                        }

                    }
                }

                if (hazardeousList) {
                    finalListToPrint = hazardeousList
                }

                render(view: 'searchApp', model: [accessLevelAdEm: accessLevelAdEm, appIdList: appIdList, finalListToPrint: finalListToPrint, checkBio: checkBio, hazardeousList: hazardeousList, statusListH: statusListH, pendingWithH: pendingWithH, pendingWithRoleH: pendingWithRoleH])

            } else {
                flash.message = "Please select search criteria first"
                redirect(action: searchApp)
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

/////////////////////////////app Processing/////////////////////////////////////////////////////////////////////////////////////////////////////

    def appProcessing = {
        try {
            try {
                def fileId = null
                if (params.fileid != null) {
                    fileId = params.fileid
                }
                boolean viewCert
                if (params.checkForView != null) {
                    if (params.checkForView == 'true') {
                        viewCert = true
                    }
                }
                println("PARAMS i n appProcessing--------"+params);
                def indApp = EWaste.get((params.id).toLong())
                System.out.println("11111111111111111: "+params.id)
                def applicationDetails = EWasteManagementPendingDetails.findByApplicationId(params.id)
                println("applicationDetails..: "+applicationDetails)
                def appFor = applicationDetails.applicationFor
                def appIdStr = applicationDetails.applicationId
                System.out.println("appIdStr123456789: "+appIdStr)
                def appId = (applicationDetails.applicationId).toLong()
                  println("Test..: "+appId)
                def application
                def isRenew
                boolean chk
                def list = EWasteManagementCertificates.findAllWhere(applicationId: appId)
                 println("list..: "+list)
                if (list.size() > 0) {
                    chk = true
                }
                if (appFor == "EWaste") {
                    application = EWaste.get(appId)

                }
                // By Gajendra Kushwah
                def viewCerScnEWaste = EWasteManagementCertificates.findAll("from EWasteManagementCertificates ewmc where ewmc.applicationId=? and ewmc.typeOfFile='EWasteScnCertificate'", [appId])
                if (viewCerScnEWaste) {
                    viewCerScnEWaste = true
                }
                def viewCere = EWasteManagementCertificates.findAll("from EWasteManagementCertificates ewmc where ewmc.applicationId=? and ewmc.typeOfFile='EWasteNew'", [appId])
                if (viewCere) {
                	viewCert = true
                }else{
                	viewCert=false
                }
                println("boolean viewCerScnEWaste =  "+viewCerScnEWaste)
                // Ends here..
                def canApprove = false

                def app = EWasteManagementPendingDetails.findByApplicationId(appIdStr)
                 println("app..: "+app)
                def roleHeader = app.role.roleName
                def roleHeaderId = app.role.id
                def roleActList = RoleVsActivity.findAllByRole(app.role)
                def actionList = new ArrayList()
                def clarification = false
                def inspection = false
                def approve = false
                def reject = false
                def inspectionClose = false
                def prepareCertificate = false
                def prepareCertificateScn = false 
                def fwdRoleList = new ArrayList()
                def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role)
            	for(int i=0;i<workFlowMasterList.size();i++){ 
            		fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
            	}
            	actionList.add(RoleActivityMaster.findWhere(activityCode:"002"))
            	println("SIE__________"+roleActList.size());
            	for(int i=0;i<roleActList.size();i++){
            		
            		
            		if((roleActList.get(i)).activity.activityCode == "004" ){
            			actionList.add((roleActList.get(i)).activity)
            		}else if((roleActList.get(i)).activity.activityCode == "006"){
            			clarification = true
            		}else if((roleActList.get(i)).activity.activityCode == "007"){
            			inspection = true
            		}else if((roleActList.get(i)).activity.activityCode == "005"){
            			approve = true
            		}else if((roleActList.get(i)).activity.activityCode == "003"){
            			reject = true
            		}else if((roleActList.get(i)).activity.activityCode == "008"){
            			inspectionClose = true
            		}else if((roleActList.get(i)).activity.activityCode == "002"){
            			prepareCertificate = true
            		}
            	}

                def applicationProcessingDetailsInstanceList = EWasteProcessingDetails.findAllByApplicationId(appIdStr, [sort: 'dateCreated', order: 'desc', offset: 0])
               
                if (applicationProcessingDetailsInstanceList) {
                    def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
                    println("applicationProcessingDetailsInstance:....: "+applicationProcessingDetailsInstance)
                    model:
                    [roleHeader: roleHeader, actionList: actionList, clarification: clarification, inspection: inspection,
                     fwdRoleList: fwdRoleList, app: app, approve: approve, reject: reject, inspectionClose: inspectionClose,
                     applicationProcessingDetailsInstance: applicationProcessingDetailsInstance, prepareCertificate: prepareCertificate,
                     appIdStr: appIdStr, appFor: appFor, isRenew: isRenew, appId: appId, viewCert: viewCert, fileId: fileId, chk: chk,
                     roleHeaderId: roleHeaderId, prepareCertificateScn: prepareCertificateScn, indApp: indApp, viewCerScnEWaste: viewCerScnEWaste]
                } else {
                    model:
                    [roleHeader: roleHeader, actionList: actionList, clarification: clarification, inspection: inspection,
                     fwdRoleList: fwdRoleList, app: app, approve: approve, reject: reject, inspectionClose: inspectionClose,
                     applicationProcessingDetailsInstance: applicationProcessingDetailsInstanceList, prepareCertificate: prepareCertificate,
                     appIdStr: appIdStr, appFor: appFor, isRenew: isRenew, appId: appId, viewCert: viewCert, fileId: fileId, chk: chk,
                     roleHeaderId: roleHeaderId, prepareCertificateScn: prepareCertificateScn, indApp: indApp, viewCerScnEWaste: viewCerScnEWaste]
                }
            } catch (Exception e) {
                e.printStackTrace();
                flash.message = "Server is busy , please try after sometime";
                if (session.indUser) {
                    redirect(controller: 'indUser', action: 'openIndustryHome')
                } else if (session.userMaster) {
                    redirect(controller: 'userMaster', action: 'openSpcbHome');
                } else {
                    session.invalidate()
                    redirect(uri: '/index.gsp');
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }


    def processApp = {
        try {
            def redirectBack = false

            def applicationPending = EWasteManagementPendingDetails.get(params.appId)

            def roleHeaderId = RoleMaster.get(params.roleHeaderId)
            def appFor = applicationPending.applicationFor
            def appIdStr = applicationPending.applicationId
            def appId = (applicationPending.applicationId).toLong()
            def checkCertificate = EWasteManagementCertificates.findAll("from EWasteManagementCertificates as wmc where wmc.applicationId=? and wmc.applicationFor=?", [appId, appFor])
            SendSms sms = new SendSms();
            def application
            def indRegInstance
            if (appFor == "EWaste") {
                application = EWaste.get(appId)
                indRegInstance = application.industryReg
            }
            def rVa = EWasteRoleVsActivity.findWhere(role: applicationPending.role, activity: EWasteActivityMaster.findByActivityCode("001"))
            if (rVa) {
                def list = EWasteManagementPendingDetails.findAllByApplicationId(applicationPending.applicationId)
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != applicationPending) {
                        (list.get(i)).delete()
                    }
                }
            }
            def roleFwd = RoleMaster.get((params.forward).toLong())
            def applicationProcessingDetails = new EWasteProcessingDetails()
            applicationProcessingDetails.role = applicationPending.role
            def user = session.userMaster
            user.refresh()
            applicationProcessingDetails.officer = user.userProfile.id
            if(params.fileNote){
                applicationProcessingDetails.fileNote = params.fileNote
                }else{
                	applicationProcessingDetails.fileNote =""; 	
                }

                if(params.inspectionDays){
                applicationProcessingDetails.inspectionDays = params.inspectionDays;
                }else
                {
                	applicationProcessingDetails.inspectionDays=""
                }
                //applicationProcessingDetails.inspectionDays=params.noticeType;
                if(params.noticeType){
                applicationProcessingDetails.noticeType = params.noticeType;
                }else{
                	applicationProcessingDetails.noticeType=""
                }
                if(params.clarificationDays){
                applicationProcessingDetails.clarificationDays = params.clarificationDays;
                }else{
                	applicationProcessingDetails.clarificationDays=""
                }


            if (params.forward != '0') {
                applicationProcessingDetails.roleFwd = roleFwd
                applicationProcessingDetails.officerFwd = (RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee.id
            } else {
                applicationProcessingDetails.roleFwd = roleHeaderId
                applicationProcessingDetails.officerFwd = (RoleProfileAssignment.findByRole(roleHeaderId)).primaryEmployee.id
            }
            ////////////////////Start///////////////Vivek///////////////////////////
            //attaching Clarification report
            def noteHistiryFile11 = new EWasteFile()
            def f11 = request.getFile('attachLetter')
            MultipartFile multi11 = request.getFile('attachLetter')
            if (!f11.empty) {

                applicationProcessingDetails.attachedFile = true
                def applicationFileRecordInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachLetter' order by wmf.id desc", [appId, appFor], [max: 1])
                if (applicationFileRecordInstance) {
                    noteHistiryFile11.version = applicationFileRecordInstance[0].version + 1
                }
                noteHistiryFile11.size = multi11.getSize() / 1024
                if (noteHistiryFile11.size <= 6000) {
                    noteHistiryFile11.name = multi11.getOriginalFilename()
                    noteHistiryFile11.data = multi11.getBytes()
                    noteHistiryFile11.extension = extractExtension(multi11)
                    noteHistiryFile11.description = "Attach other file if any"
                    if (session.userMaster) {
                        noteHistiryFile11.createdBy = session.userMaster
                        noteHistiryFile11.updatedBy = session.userMaster
                    } else {
                        noteHistiryFile11.createdBy = session.indUser
                        noteHistiryFile11.updatedBy = session.indUser
                    }
                    noteHistiryFile11.typeOfFile = "attachLetter"
                    noteHistiryFile11.applicationId = appId
                    noteHistiryFile11.applicationFor = appFor

                    if (appFor == "EWaste") {
                        noteHistiryFile11.indreg = application.industryReg
                    }

                    if (noteHistiryFile11.save()) {
                    } else {
                        redirect(action: 'appProcessing', params: ["id": appIdStr])
                    }
                } else {
                    flash.message = "Attachment File Size is More Then 5 Mb"
                    redirectBack = true
                }
            }

            //close upload

            /////////////////End///////////////Vivek///////////////////////////

            if ((params.clarification).equals("yes")) {
                if (application.clarification) {
                    // flash.message = "Clarification already Raised on this application"
                    def indApp = applicationPending.applicationId
                    def EWasteProcessingDetails obj = new EWasteProcessingDetails()

                    obj.clarificationNote = params.clarificationNote
                    def checkInstance = EWasteProcessingDetails.find("from EWasteProcessingDetails where applicationId=? and clarification= 't' order by id desc", [indApp])
                    if (checkInstance) {
                        def clarificationNote = checkInstance.clarificationNote = params.clarificationNote;
                        checkInstance.clarificationDays = params.clarificationDays

                        checkInstance.save();
                        //redirect(action:'appProcessing',params:["id":indApp.id]);
                        //redirect(action:"/another/action", )
                        //     redirectBack = true
                    }
                } else {

                    application.clarification = true
                    application.save()
                    applicationProcessingDetails.clarification = true
                    applicationProcessingDetails.clarificationNote = params.clarificationNote
                    //attaching Clarification report
                    def noteHistiryFile1 = new EWasteFile()
                    def f = request.getFile('attachClarificationReport')
                    MultipartFile multi = request.getFile('attachClarificationReport')
                    if (!f.empty) {

                        applicationProcessingDetails.clarificationAttachedFile = true
                        def applicationFileRecordInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedClarificationReport'", [appId, appFor], [max: 1])
                        if (applicationFileRecordInstance) {
                            noteHistiryFile1.version = applicationFileRecordInstance[0].version + 1
                        }
                        noteHistiryFile1.size = multi.getSize() / 1024
                        if (noteHistiryFile1.size <= 6000) {
                            noteHistiryFile1.name = multi.getOriginalFilename()
                            noteHistiryFile1.data = multi.getBytes()
                            noteHistiryFile1.extension = extractExtension(multi)
                            noteHistiryFile1.description = "Application attached Clarification Report"
                            if (session.userMaster) {
                                noteHistiryFile1.createdBy = session.userMaster
                                noteHistiryFile1.updatedBy = session.userMaster
                            } else {
                                noteHistiryFile1.createdBy = session.indUser
                                noteHistiryFile1.updatedBy = session.indUser
                            }
                            noteHistiryFile1.typeOfFile = "attachedClarificationReport"
                            noteHistiryFile1.applicationId = appId
                            noteHistiryFile1.applicationFor = appFor


                            noteHistiryFile1.indreg = application.industryReg


                            if (noteHistiryFile1.save()) {
                            } else {
                                redirect(action: 'appProcessing', params: ["id": appIdStr])
                            }
                        } else {

                            flash.message = "Attachment File Size is More Then 5 Mb"
                            redirectBack = true
                        }
                    }

                    //close upload
                }


            } else {
                applicationProcessingDetails.clarification = false
                applicationProcessingDetails.clarificationNote = ""
            }
            if ((params.inspection).equals("yes")) {


                if (application.inspection) {
                    flash.message = "Inspection already Raised on this application"
                    //redirect(action:'appProcessing',params:["id":indApp.id])
                    redirectBack = true
                } else {
                    application.inspection = true
                    application.save()
                    applicationProcessingDetails.inspection = true
                    applicationProcessingDetails.inspectionNote = params.inspectionNote
                    //anamika...srtt  here
                    def noteHistiryFile2 = new EWasteFile()
                    def f = request.getFile('attachInspectionReport')
                    MultipartFile multi = request.getFile('attachInspectionReport')
                    if (!f.empty) {

                        applicationProcessingDetails.inspectionAttachedFile = true
                        def applicationFileRecordInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedInspectionReport' order by wmf.id desc", [appId, appFor], [max: 1])
                        if (applicationFileRecordInstance) {
                            noteHistiryFile2.version = applicationFileRecordInstance[0].version + 1
                        }
                        noteHistiryFile2.size = multi.getSize() / 1024
                        if (noteHistiryFile2.size <= 6000) {
                            noteHistiryFile2.name = multi.getOriginalFilename()
                            noteHistiryFile2.data = multi.getBytes()
                            noteHistiryFile2.extension = extractExtension(multi)
                            noteHistiryFile2.description = "Application attached Inspection Report"
                            if (session.userMaster) {
                                noteHistiryFile2.createdBy = session.userMaster
                                noteHistiryFile2.updatedBy = session.userMaster
                            } else {
                                noteHistiryFile2.createdBy = session.indUser
                                noteHistiryFile2.updatedBy = session.indUser
                            }
                            noteHistiryFile2.typeOfFile = "attachedInspectionReport"
                            noteHistiryFile2.applicationId = appId
                            noteHistiryFile2.applicationFor = appFor

                            if (appFor == "EWaste") {
                                noteHistiryFile2.indreg = application.industryReg
                            }
                            if (noteHistiryFile2.save()) {
                            } else {

                                redirect(action: 'appProcessing', params: ["id": appIdStr])
                            }
                        } else {
                            flash.message = "Attachment File Size is More Then 5 Mb"
                            redirectBack = true
                        }
                    }

                    //anamika.....end
                }

            } else {
                applicationProcessingDetails.inspection = false
                applicationProcessingDetails.inspectionNote = ""
            }

            if ((params.inspectionClose).equals("yes")) {
                def noteHistiryFile = new EWasteFile()

                if (!application.inspection) {
                    flash.message = "Inspection not Raised on this application"
                    redirect(action: 'appProcessing', params: ["id": appIdStr])
                } else {


                    def f = request.getFile('inspectionReport')
                    MultipartFile multi = request.getFile('inspectionReport')
                    if (!f.empty) {

                        applicationProcessingDetails.inspectionCloseAttachedFile = true
                        //f.transferTo( new File(strDir +'/Inspection_Report.doc') )
                        def applicationFileRecordInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='inspectionReport' order by wmf.id desc", [appId, appFor], [max: 1])
                        if (applicationFileRecordInstance) {
                            noteHistiryFile.version = applicationFileRecordInstance[0].version + 1
                        }
                        noteHistiryFile.size = multi.getSize() / 1024
                        if (noteHistiryFile.size <= 6000) {
                            noteHistiryFile.name = multi.getOriginalFilename()
                            noteHistiryFile.data = multi.getBytes()
                            noteHistiryFile.extension = extractExtension(multi)
                            noteHistiryFile.description = "Application Inspection Report File"
                            if (session.userMaster) {
                                noteHistiryFile.createdBy = session.userMaster
                                noteHistiryFile.updatedBy = session.userMaster
                            } else {
                                noteHistiryFile.createdBy = session.indUser
                                noteHistiryFile.updatedBy = session.indUser
                            }
                            //fileUpload.data=params.payload
                            noteHistiryFile.typeOfFile = "inspectionReport"
                            noteHistiryFile.applicationId = appId
                            noteHistiryFile.applicationFor = appFor

                            if (appFor == "EWaste") {
                                noteHistiryFile.indreg = application.industryReg
                            }
                            if (noteHistiryFile.save()) {
                            } else {
                                redirect(action: 'appProcessing', params: ["id": appIdStr])
                            }
                        } else {
                            flash.message = "Attachment File Size is More Then 5 Mb"
                            redirectBack = true
                        }
                    }


                    application.inspection = false
                    application.save()
                    applicationProcessingDetails.inspectionClose = true
                    applicationProcessingDetails.inspectionCloseNote =
                            params.inspectionCloseNote
                }

            } else {
                applicationProcessingDetails.inspectionClose = false
                applicationProcessingDetails.inspectionCloseNote = ""
            }
            if ((params.approve).equals("yes")) {

                if (application.inspection) {
                    flash.message = "Sorry can not Approve Inspection is Raised on this application"
                    //redirect(action:'appProcessing',params:["id":indApp.id])
                    redirectBack = true

                } else if (application.clarification) {
                    flash.message = "Sorry can not Approve Clarification is Raised on this application"
                    //redirect(action:'appProcessing',params:["id":indApp.id])
                    redirectBack = true
                } else if (!checkCertificate) {
                    flash.message = "Please Upload Certificate first."
                    redirectBack = true
                }
                //Code for CTO granted Check//////////Start//////Vivek/////
                //else if(!checkCto){
                // flash.message = "Cannot approved .CTO is not granted."
                // redirectBack = true
                //}
                ///////End////////////Vivek//////////
                else {
                    applicationPending.applicationStatus = "approved"
                    applicationPending.save()
                    application.applicationStatus = "approved"
                    application.save()
                    applicationProcessingDetails.approve = true
                    applicationProcessingDetails.approveNote = params.approveNote
                    def oMobNoABB = indRegInstance.occMobile
        			
                    def oEmailAABB = indRegInstance.occEmail;
					def oNameAABB = indRegInstance.occName;
                    
                    if(oMobNoABB!=null && oMobNoABB!="")
        			{
        				//sms.sendeWasteGranted(appId.toString(),oMobNoABB,"eWaste")
            			
        			}
                    SendMail mail = new SendMail()
	                if(oEmailAABB!=null && oEmailAABB!="")
	                {
	                	//mail.sendRejected(appIdBCD,oEmailAABB,"eWaste",oNameAABB)
           
	                }
                }


            } else {
                applicationProcessingDetails.approve = false
                applicationProcessingDetails.approveNote = ""
            }
            if ((params.reject).equals("yes")) {
                applicationPending.applicationStatus = "rejected"
                applicationPending.save()
                application.applicationStatus = "rejected"
                application.save()
                applicationProcessingDetails.reject = true
                applicationProcessingDetails.rejectNote = params.rejectNote;
                def oMobNoABBAA = indRegInstance.occMobile
    			if(oMobNoABBAA!=null && oMobNoABBAA!="")
    			{
    				//sms.sendeWasteRejected(appId.toString(),oMobNoABBAA,"eWaste")
        			
    			}
            } else {
                applicationProcessingDetails.reject = false
                applicationProcessingDetails.rejectNote = ""
            }
//          ------------return code---------------//
	    	if((params.returned).equals("yes")){
	    		def approval = EWasteProcessingDetails.findAll("from EWasteProcessingDetails apd where apd.applicationId=?  order by apd.id desc",[String.valueOf(application.id)])
	    		//def refusal=EWasteProcessingDetails.find("from EWasteProcessingDetails apd where apd.applicationId=? and apd.rejectNote <> '' order by apd.id desc",[String.valueOf(application.id)])
	    		if(approval.size()>0){
	    		if(approval[0].returned==true && approval[0].resubmitStatus==false){
					flash.message = "Sorry this Application is already returned to Industry"
						redirectBack = true
					}
	    		}
				
	    		def appIdReturn = (application.id).toString()
	    		def applicationSubmitDate;
					//def appDateNew = indApp.applicationDate;
					//Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
					//applicationSubmitDate= formatter3.format(appDateNew)
				def oMobNoReturn;
				def emailIdReturn;
			    def occName;
				
					oMobNoReturn=application.industryReg.occMobile;
					emailIdReturn = application.industryReg.occEmail
					def appDateNew = application.dateCreated
					Format formatter3 = new SimpleDateFormat("dd/MM/yyyy")
					applicationSubmitDate= formatter3.format(appDateNew)
					occName=application.industryReg.occName
				println("---applicationPending.applicationStatus---"+applicationPending.applicationStatus)
	    		applicationPending.applicationStatus = "returned"
	        	applicationPending.save()
	        	application.applicationStatus = "returned"
		    	application.save()
	    		applicationProcessingDetails.returned = true
	    		applicationProcessingDetails.returnNote = params.returnNote
	    		if(emailIdReturn!=null && emailIdReturn!="")
	    		{
					SendMail mail = new SendMail()
					mail.sendReturned(appIdReturn,emailIdReturn,appFor,occName,applicationSubmitDate)
				}
	    		
	    		println("Returned Mail has been Sent to industry ")
		      
				sms.sendReturned(appIdReturn,oMobNoReturn,appFor)
				println("Returned SMS has been Sent to industry ")
	    	}
	    	else{
	    		applicationProcessingDetails.returned = false
	    		applicationProcessingDetails.returnNote = ""
	    	}
            
            
            if (redirectBack) {

                redirect(action: 'appProcessing', params: ["id": applicationPending.applicationId])
            } else {
                applicationProcessingDetails.applicationId = applicationPending.applicationId
                applicationProcessingDetails.applicationFor = applicationPending.applicationFor
                if (applicationProcessingDetails.save()) {
                } else {
                    applicationProcessingDetails.errors.each {
                        println it
                    }
                }


                if (params.forward != '0') {

                    applicationPending.role = roleFwd
                    applicationPending.pendingWith =
                            UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)
                } else {
                    applicationPending.role = roleHeaderId
                    applicationPending.pendingWith =
                            UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleHeaderId)).primaryEmployee)

                }
                applicationPending.save()

                redirect(controller: 'eWaste', action: 'pendingList')
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

///////////////////////////////note history///////////////////////////////
    def openApplicationDetails = {
        try {
            def application = params.id
            def appForWhich = params.docName
            println("application: " + application)
            def applicationProcessingDetailsInstanceList = EWasteProcessingDetails.findAll("from EWasteProcessingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [application])
            def appPending = EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [application])

            //ApplicationProcessingDetails.findAllByApplication(application)
            model:
            [applicationProcessingDetailsInstanceList: applicationProcessingDetailsInstanceList, currentPending: appPending.role, appPending: appPending, appForWhich: appForWhich]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

////////////////////////SPCB FORM VIEW/////////////////////////////////////////////

    def spcbShowForm = {
        try {

            //def appFor=params.docName
            def appliId = params.appliId
            def appId = appliId.toLong()
            def application



            def eWasteInst = EWaste.get(appId)

            def indRegInstance = eWasteInst.industryReg
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

            def listDoc = new ArrayList()

            def applicationDocumentInstance = ApplicationDocumentsEW.findAll(" from ApplicationDocumentsEW apd where apd.indApplication=? order by apd.id desc", [eWasteInst])

            if (applicationDocumentInstance) {
                for (int ig = 0; ig < applicationDocumentInstance.size(); ig++) {
                    def boolCheck = false
                    if (listDoc.size() == 0) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }
                    for (int intCheck = 0; intCheck < listDoc.size(); intCheck++) {
                        if (listDoc[intCheck].level == (applicationDocumentInstance.get(ig)).level) {
                            boolCheck = true
                        }
                    }
                    if (boolCheck == false) {
                        listDoc.add(applicationDocumentInstance.get(ig))
                    }

                }

            }


            return [eWasteInstance: eWasteInst, indRegInstance: indRegInstance, listDoc: listDoc]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }


    def viewOtherAttachedDocument = {
        try {
            def appFor = params.appliFor
            def appIdStr = params.appliLoc
            def appId = (params.appliLoc).toLong()
            def application

            application = EWaste.get(appId)

            def type = params.docName
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachLetter' order by wmf.id desc", [appId, appFor], [max: 1])
            def applicationFileSingleInstance = applicationFileInstance[0]
            if (applicationFileSingleInstance == null) {
                flash.message = "File not Attached by SPCB Officer"
                redirect(action: appProcessing, id: params.appliLoc)
            } else {
                response.setContentType("application-xdownload")
                response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
                response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
////////////////////////////////////clarification code//////////////////////////////////////////////
    def submitClarification = {
        try {
            def appliId = params.id
            def appId = appliId
            def application

            application = EWaste.get(appId)
            def indClarificationNote = params.indClarificationNote;

            def applicationProcessingDetailsInstanceList = EWasteProcessingDetails.findAll("from EWasteProcessingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste' order by wmpd.id desc", [appliId.toString()])
            for (int i = 0; i < applicationProcessingDetailsInstanceList.size(); i++) {
                if ((applicationProcessingDetailsInstanceList.get(i)).clarification) {
                    return [appClarification: applicationProcessingDetailsInstanceList.get(i), app: application, appFor: 'EWaste', appliId: appliId]
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
// by saroj for view ispection
    def viewInspection = {
        try {
            def paramsid = params.id;

            def appId = paramsid

            def application = EWaste.get(paramsid.toLong())
            def eWasteProcessingDetailsInstanceList = EWasteProcessingDetails.findAllByApplicationId(application.toString())
            for (int i = 0; i < eWasteProcessingDetailsInstanceList.size(); i++) {
                if ((eWasteProcessingDetailsInstanceList.get(i)).inspection) {
                    return [appInspection: eWasteProcessingDetailsInstanceList.get(i)]
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
//by saroj for view Clarification
    def viewClarification = {
        try {
            def paramsid = params.id;
            def appId = paramsid
            def applicationid = EWaste.get(appId.toLong())
            def eWasteProcessingDetailsInstanceList = EWasteProcessingDetails.findAllByApplicationId(applicationid.toString())

            for (int i = 0; i < eWasteProcessingDetailsInstanceList.size(); i++) {
                if ((eWasteProcessingDetailsInstanceList.get(i)).clarification) {
                    return [appClarification: eWasteProcessingDetailsInstanceList.get(i)]
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def submittedClarification = {
        try {
            def noteHistiryFile = new EWasteFile()
            def appProcessing = new EWasteProcessingDetails()
            def appFor1 = "EWaste"
            def appliId1 = params.appId
            def appId = appliId1
            def application
            //by saroj

            def applicationProcessingDetailsInstanceList = EWasteProcessingDetails.findAll("from EWasteProcessingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste' order by wmpd.id desc", [appliId1.toString()])

            def wastemanagementPendingInstance = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste' order by wmpd.id desc ", [appliId1], [max: 1])


            def pendingInstance = wastemanagementPendingInstance[0]

            application = EWaste.get(appId)

            def f = request.getFile('indClarificationIssueFile')
            MultipartFile multi = request.getFile('indClarificationIssueFile')
            if (!f.empty) {

                appProcessing.clarificationReplyAttachedFile = true
                //f.transferTo( new File(strDir +'/Inspection_Report.doc') )
                def applicationFileRecordInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor='EWaste' and wmf.typeOfFile='indClarificationIssueFile' order by wmf.id desc", [appliId1.toLong()], [max: 1])



                if (applicationFileRecordInstance) {
                    noteHistiryFile.version = applicationFileRecordInstance[0].version + 1
                }
                noteHistiryFile.size = multi.getSize() / 1024
                if (noteHistiryFile.size <= 6000) {
                    noteHistiryFile.name = multi.getOriginalFilename()
                    noteHistiryFile.data = multi.getBytes()
                    noteHistiryFile.extension = extractExtension(multi)
                    noteHistiryFile.description = "Application Clarification Report File"
                    if (session.userMaster) {
                        noteHistiryFile.createdBy = session.userMaster
                        noteHistiryFile.updatedBy = session.userMaster
                    } else {
                        noteHistiryFile.createdBy = session.indUser
                        noteHistiryFile.updatedBy = session.indUser
                    }
                    //fileUpload.data=params.payload
                    noteHistiryFile.typeOfFile = "indClarificationFile"
                    noteHistiryFile.applicationId = appId.toLong()
                    noteHistiryFile.applicationFor = appFor1

                    noteHistiryFile.indreg = application.industryReg

                    if (noteHistiryFile.save()) {
                    } else {
                        redirect(action: 'appProcessing', params: ["id": pendingInstance.id])
                    }
                } else {
                    flash.message = "Attachment File Size is More Then 5 Mb"
                    redirectBack = true
                }
            }

            application.clarification = false
            application.save()

            // robin
            //
            //
            appProcessing.role = pendingInstance.role

            //appProcessing.fileNote = params.indClarificationNote
            appProcessing.roleFwd = pendingInstance.role



            appProcessing.clarification = false
            if (params.indClarificationNote) {
                appProcessing.clarificationNote = params.indClarificationNote
                appProcessing.fileNote = params.indClarificationNote
                //by saroj for save clrarification reply data
                appProcessing.clarificationDays = ""
                appProcessing.inspectionDays = ""
                appProcessing.noticeType = ""
                //end

            } else {
                appProcessing.clarificationNote = ""
                appProcessing.fileNote = ""
            }
            //by saroj start for saving officer ,officer frd in ewasteprocessing details table.
            def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [application.industryReg])

            def role1 = EWasteManagementPendingDetails.findByApplicationId(application.id.toString())

            def roleFwd = RoleMaster.get((role1.role.id).toLong())

            def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)

            def roMobNo = empUser.userProfile.mobile

            //def noticeType = params.noticeType
            appProcessing.officer = industryId
            appProcessing.officerFwd = industryId

            appProcessing.inspection = false
            appProcessing.inspectionNote = ""

            appProcessing.inspectionClose = false
            appProcessing.inspectionCloseNote = ""


            appProcessing.approve = false
            appProcessing.approveNote = ""

            appProcessing.reject = false
            appProcessing.rejectNote = ""

            appProcessing.applicationId = appliId1
            appProcessing.applicationFor = appFor1

            //
            //
            //


            if (appProcessing.save()) {
            } else {
                appProcessing.errors.each {
                    println it
                }
            }

            flash.message = "Clarification Submitted"
            redirect(action: popClose)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def popClose = {

    }

    def viewClarificationReportIndustry = {
		//println("params.view.. : "+params)
        try {
            def application = params.appliLoc.toLong()
            def type = params.docName
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile afr where afr.applicationId=? and afr.typeOfFile='attachedClarificationReport' order by afr.dateCreated desc", [application], [max: 1])
            def applicationFileSingleInstance = applicationFileInstance[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=\"" + applicationFileSingleInstance.name + "\"")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

/////////////////////////////inspection report/////////////////////////////////////////////////////////	//

    def popEWasteInspectionReport = {
        try {
            System.out.println("params.id..11:  "+params.id)
            def app = EWaste.get((params.id).toInteger())
            System.out.println("params.id..22:  "+app)
            def newInst = EWasteInspectionReport.findByApplication(app)
            System.out.println("params.id..33:  "+newInst)
            /*def newInst2 = EWaste.find("from EWaste from id = ?",app)
            System.out.println("params.id..44:  "+newInst2)*/


            return [appId: app, newInst: newInst, newInst2:newInst2]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def popEWasteInspectionReportShow = {
        try {
            def app = EWaste.get((params.id).toInteger())

            def newInst = EWasteInspectionReport.findByApplication(app)


            return [appId: app, newInst: newInst]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def saveEWasteInspectionReport = {
        try {
            //def idApp= (params.id).toLong()
            def indApplicationDetailsInstance = EWaste.get(params.appId)
            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            def check = EWasteInspectionReport.findByApplication(indApplicationDetailsInstance)

            if (check) {
                check.delete()
            }
            def eWasteInspInst = new EWasteInspectionReport(params)

            def capitalInvestment = params.capitalInvestment;
            eWasteInspInst.eWasteCategory = params.eWasteCategory
            eWasteInspInst.noOfNoc = params.noOfNoc
//			eWasteInspInst.dateOfCompletion=	params.dateOfCompletion
//			eWasteInspInst.dateOfInspection=params.dateOfInspection
            eWasteInspInst.nameDesigInspectionOff = params.nameDesigInspectionOff
            eWasteInspInst.repName = params.repName
            eWasteInspInst.eWasteSource = params.eWasteSource
            eWasteInspInst.recyclingQuantity = params.recyclingQuantity
            eWasteInspInst.collectionDetail = params.collectionDetail
            eWasteInspInst.modeOfDisposal = params.modeOfDisposal
            eWasteInspInst.tsdfAgreement = params.tsdfAgreement
            eWasteInspInst.etpDetails = params.etpDetails
            eWasteInspInst.apcmDetails = params.apcmDetails
            eWasteInspInst.energyMeterStatus = params.energyMeterStatus
            eWasteInspInst.tradeDisposalMode = params.tradeDisposalMode
            eWasteInspInst.stackHeight = params.stackHeight
            eWasteInspInst.dgSetStatus = params.dgSetStatus
            eWasteInspInst.operationType = params.operationType
            eWasteInspInst.dismantlingOperation = params.dismantlingOperation
            eWasteInspInst.segregationOperation = params.segregationOperation
            eWasteInspInst.gasRecovery = params.gasRecovery
            eWasteInspInst.disposalArrangement = params.disposalArrangement
            eWasteInspInst.collectionBoxes = params.collectionBoxes
            eWasteInspInst.equipments = params.equipments
            eWasteInspInst.extraDetails = params.extraDetails
            eWasteInspInst.bigHouse = params.bigHouse
            eWasteInspInst.spareStorage = params.spareStorage
            eWasteInspInst.containers = params.containers
            eWasteInspInst.unitName = params.unitName
            eWasteInspInst.unitAddress = params.unitAddress




            def sdfh = new SimpleDateFormat("dd/MM/yyyy");


            def dateOfReceipt = params.dateOfReceipt_value

            def x1 = sdfh.parse(dateOfReceipt); //Date


            java.sql.Date sqlDate66 = new java.sql.Date(x1.getTime())

            def dateOfInspection = params.dateOfInspection_value

            def x11 = sdfh.parse(dateOfInspection); //Date

            java.sql.Date sqlDate666 = new java.sql.Date(x11.getTime())


            def dateOfCompletion = params.dateOfCompletion_value

            def x111 = sdfh.parse(dateOfCompletion); //Date

            def dateOfNoc = params.dateOfNoc_value
            def x10 = sdfh.parse(dateOfNoc); //Date


            java.sql.Date sqlDate10 = new java.sql.Date(x10.getTime())
            eWasteInspInst.dateOfNoc = x10
            eWasteInspInst.receiptDate = x1
            eWasteInspInst.dateOfCompletion = x11
            eWasteInspInst.dateOfInspection = x111
            eWasteInspInst.application = indApplicationDetailsInstance

            if (eWasteInspInst.save()) {

            } else {
                if (eWasteInspInst.hasErrors()) {
                    eWasteInspInst.errors.allErrors.each {
                        println it
                    }
                }
            }

            redirect(action: popEWasteInspectionReport, id: indApplicationDetailsInstance)
        }

        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def eWasteSummary = {
        try {

            def applicationReceivedCountB = EWaste.findAll("From EWaste as bmw WHERE bmw.applicationStatus!='unattended' and  bmw.completionStatus='completed' order by bmw.id desc ")
            def applicationCompletedCountB = EWaste.findAll("From EWaste as bmw WHERE bmw.applicationStatus!='unattended' and bmw.applicationStatus!='Inprogress' and  bmw.completionStatus='completed' order by bmw.id desc ")
            def applicationPendingCountB = EWaste.findAll("From EWaste as bmw WHERE  bmw.applicationStatus='Inprogress' and  bmw.completionStatus='completed'  order by bmw.id desc ")
            def applicationUnattendedCountB = EWaste.findAll("From EWaste as bmw WHERE  bmw.applicationStatus='unattended' and  bmw.completionStatus='completed' order by bmw.id desc  ")
            def receivedCount = applicationReceivedCountB.size()
            def completedCount = applicationCompletedCountB.size()
            def pendingCount = applicationPendingCountB.size()
            def unattendedCount = applicationUnattendedCountB.size()

            def fullListToPrintB = new ArrayList()
            def allFourB = new ArrayList()
            def appListB = new ArrayList()
            def statusListB = new ArrayList()
            def pendingWithB = new ArrayList()
            def pendingWithRoleB = new ArrayList()

            def appList = new ArrayList()



            def wasteManagementListB

            def finalListToPrint = new ArrayList()

            def checkVariableRec = false
            def checkVariableCom = false
            def checkVariable = false
            def checkVariableUn = false

            def linksch = "true"

            if (params.checkVar) {
                if (params.checkVar == "received") {
                    if (applicationReceivedCountB) {
                        for (int a = 0; a < applicationReceivedCountB.size(); a++) {
                            allFourB = applicationReceivedCountB.get(a)
                            if (allFourB) {
                                checkVariableRec = true

                                appListB.add((allFourB))
                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                    wasteManagementListB = appListB


                } else if (params.checkVar == "completed") {
                    if (applicationCompletedCountB) {
                        for (int a = 0; a < applicationCompletedCountB.size(); a++) {
                            allFourB = applicationCompletedCountB.get(a)
                            if (allFourB) {
                                checkVariableCom = true
                                appListB.add((allFourB))
                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithM.add("Unknown")
                                    pendingWithRoleM.add("Unknown")
                                }
                            }
                        }

                    }


                    wasteManagementListB = appListB
                    //cessReturnInstanceList=appList
                } else if (params.checkVar == "pending") {
                    if (applicationPendingCountB) {
                        for (int a = 0; a < applicationPendingCountB.size(); a++) {
                            allFourB = applicationPendingCountB.get(a)
                            if (allFourB) {
                                checkVariable = true
                                appListB.add((allFourB))

                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                    wasteManagementListB = appListB
                    //	cessReturnInstanceList=appList
                } else {
                    if (applicationUnattendedCountB) {
                        for (int variable1 = 0; variable1 < applicationUnattendedCountB.size(); variable1++)

                        {
                            allFourB = applicationUnattendedCountB.get(variable1)
                            if (allFourB) {
                                checkVariableUn = true
                                appListB.add((allFourB))

                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                    wasteManagementListB = appListB

                }

            } else {


            }

            fullListToPrintB = wasteManagementListB







            if (checkVariableRec) {
                finalListToPrint = applicationReceivedCountB
            } else if (checkVariableCom) {
                finalListToPrint = applicationCompletedCountB
            } else if (checkVariable) {
                finalListToPrint = applicationPendingCountB
            } else if (checkVariableUn) {
                finalListToPrint = applicationUnattendedCountB
            }
            render(view: 'searchPage', model: [finalListToPrint: finalListToPrint, linksch: linksch, applicationUnattendedCountB: applicationUnattendedCountB, applicationReceivedCountB: applicationReceivedCountB, checkVariableUn: checkVariableUn, checkVariableCom: checkVariableCom, checkVariableRec: checkVariableRec, applicationPendingCountB: applicationPendingCountB, fullListToPrintB: fullListToPrintB, statusListB: statusListB, pendingWithB: pendingWithB, pendingWithRoleB: pendingWithRoleB, receivedCount: receivedCount, completedCount: completedCount, pendingCount: pendingCount, unattendedCount: unattendedCount, checkVariable: checkVariable, applicationCompletedCountB: applicationCompletedCountB])
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }



    def popEWasteSCNReport = {
        try{

            boolean viewCerScnEWaste = false
            def app = EWaste.get((params.appliId).toLong())
            System.out.println("2222222: "+(params.appliId))
            String appId = params.appliId
            //def indApp = EWaste.get((params.id).toLong())
            /*def allPending = EWasteManagementPendingDetails.list()
            def ewaste1 = EWasteManagementPendingDetails.get(154946l)
            println("ewaste1: " + ewaste1)
            def ewaste2 = EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails where id = ?", [154946l])
            println("ewaste2: " + ewaste2)*/
            def ewaste3 = EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails where applicationId = ?", [appId])
            println("ewaste3: " + ewaste3)
            /*println("allPending: " + allPending)*/
            //def applicationDetails = EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails where applicationId=? ",[appId])
            /*def appFor = ewaste3.applicationFor
            def appIdStr = ewaste3.applicationId*/

            /*def appId = (applicationDetails.applicationId).toLong()
            def app = EWasteManagementPendingDetails.findByApplicationId(appIdStr)
            def roleHeader = app.role.roleName
            def roleHeaderId = app.role.id*/


           // def appmanage = EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails where applicationId ")
            def roleHeader = ewaste3.role.roleName
            def roleHeaderId = ewaste3.role.id
                def newInst = EWaste.find(app)
            SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
            java.util.Date nowDate = new java.util.Date();
            String currentYear = formatNowYear.format(nowDate);

                return [appId: app, newInst: newInst,currentYear:currentYear,roleHeader:roleHeader]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def saveEwasteScn = {

    }

    def saveEWasteSCNReport = {
        try {
            //def idApp= (params.id).toLong()
            def indApplicationDetailsInstance = EWaste.get(params.appId)
            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            def check = EWasteInspectionReport.findByApplication(indApplicationDetailsInstance)

            if (check) {
                check.delete()
            }
            def eWasteInspInst = new EWasteSCNReport(params)

            def capitalInvestment = params.capitalInvestment;
            eWasteInspInst.eWasteCategory = params.eWasteCategory
            eWasteInspInst.noOfNoc = params.noOfNoc
//			eWasteInspInst.dateOfCompletion=	params.dateOfCompletion
//			eWasteInspInst.dateOfInspection=params.dateOfInspection
            eWasteInspInst.nameDesigInspectionOff = params.nameDesigInspectionOff
            eWasteInspInst.repName = params.repName
            eWasteInspInst.eWasteSource = params.eWasteSource
            eWasteInspInst.recyclingQuantity = params.recyclingQuantity
            eWasteInspInst.collectionDetail = params.collectionDetail
            eWasteInspInst.modeOfDisposal = params.modeOfDisposal
            eWasteInspInst.tsdfAgreement = params.tsdfAgreement
            eWasteInspInst.etpDetails = params.etpDetails
            eWasteInspInst.apcmDetails = params.apcmDetails
            eWasteInspInst.energyMeterStatus = params.energyMeterStatus
            eWasteInspInst.tradeDisposalMode = params.tradeDisposalMode
            eWasteInspInst.stackHeight = params.stackHeight
            eWasteInspInst.dgSetStatus = params.dgSetStatus
            eWasteInspInst.operationType = params.operationType
            eWasteInspInst.dismantlingOperation = params.dismantlingOperation
            eWasteInspInst.segregationOperation = params.segregationOperation
            eWasteInspInst.gasRecovery = params.gasRecovery
            eWasteInspInst.disposalArrangement = params.disposalArrangement
            eWasteInspInst.collectionBoxes = params.collectionBoxes
            eWasteInspInst.equipments = params.equipments
            eWasteInspInst.extraDetails = params.extraDetails
            eWasteInspInst.bigHouse = params.bigHouse
            eWasteInspInst.spareStorage = params.spareStorage
            eWasteInspInst.containers = params.containers
            eWasteInspInst.unitName = params.unitName
            eWasteInspInst.unitAddress = params.unitAddress




            def sdfh = new SimpleDateFormat("dd/MM/yyyy");


            def dateOfReceipt = params.dateOfReceipt_value

            def x1 = sdfh.parse(dateOfReceipt); //Date


            java.sql.Date sqlDate66 = new java.sql.Date(x1.getTime())

            def dateOfInspection = params.dateOfInspection_value

            def x11 = sdfh.parse(dateOfInspection); //Date

            java.sql.Date sqlDate666 = new java.sql.Date(x11.getTime())


            def dateOfCompletion = params.dateOfCompletion_value

            def x111 = sdfh.parse(dateOfCompletion); //Date

            def dateOfNoc = params.dateOfNoc_value
            def x10 = sdfh.parse(dateOfNoc); //Date


            java.sql.Date sqlDate10 = new java.sql.Date(x10.getTime())
            eWasteInspInst.dateOfNoc = x10
            eWasteInspInst.receiptDate = x1
            eWasteInspInst.dateOfCompletion = x11
            eWasteInspInst.dateOfInspection = x111
            eWasteInspInst.application = indApplicationDetailsInstance

            if (eWasteInspInst.save()) {

            } else {
                if (eWasteInspInst.hasErrors()) {
                    eWasteInspInst.errors.allErrors.each {
                        println it
                    }
                }
            }

            redirect(action: popEWasteInspectionReport, id: indApplicationDetailsInstance)
        }

        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }


    //////******************For SCN E-WasteCertificate*****By saroj 22/12/2015*************//////

    def scnCertificate = {
        try {
            def idAppl = (params.appliId).toLong()

            boolean viewCerScnEWaste = false
            def hazardeousWasteAuthAppInstance = EWaste.get(idAppl)
            def eWasteProcessingDetailsInstance = EWasteProcessingDetails.findByApplicationId(idAppl)
            /*	def appId=(params.id).toLong()*/

            def app = EWasteManagementPendingDetails.findByApplicationId(idAppl)
            def roleHeader = app.role.roleName
            def appId = (app.applicationId).toLong()
            def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

            def district = indRegInstanceGet.district.districtName
            //	def tehsil=indRegInstanceGet.tehsil.tehsilName

            boolean chk
            def list = EWasteManagementCertificates.findAllWhere(applicationId: idAppl)
            if (list.size() > 0) {
                chk = true
            }


            def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)


            if (!hazardeousWasteAuthAppInstance) {
                flash.message = "Not found with id ${params.id}"
                redirect(action: list)
            } else {
                render(view: 'Ewaste_scnCertificate', model: [hazardeousWasteAuthAppInstance: hazardeousWasteAuthAppInstance, indRegInstance: indRegInstance, district: district, wasteManagementFileList: wasteManagementFileList, chk: chk, roleHeader: roleHeader, viewCerScnEWaste: viewCerScnEWaste])
                //return [ hazardeousWasteAuthAppInstance : hazardeousWasteAuthAppInstance,indRegInstance:indRegInstance,district:district,tehsil:tehsil,hwProductDetailsList : hwProductDetailsList,hazardeousWasteDetailsList:hazardeousWasteDetailsList , wasteManagementFileList:wasteManagementFileList, tmp1:tmp1]
            }

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    // satish code start
    // below action is replaced
    def downLoadingCertificateForScnEwaste = {
        try{
            def fileVer=(params.fileVer).toLong()
            def applicatioFor=params.appForWhich
            def appId=(params.applicationId).toLong()
            def applicationFileInstance = EWasteManagementCertificates.findAll("from EWasteFile ewf where ewf.applicationId=? " +
                    "and ewf.applicationFor=? and ewf.typeOfFile=? and ewf.version=? order by ewf.id desc",[appId,'EWaste','attachedClarificationReport',fileVer],[max:1])
            def applicationFileSingleInstance=applicationFileInstance[0]
            response.setContentType( "application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )

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
    // below action is created
    def viewClarificationReplyAttachment={

        try{
            def fileVer=(params.fileVerReply).toLong()
            def applicatioFor=params.appForWhich
            def appId=(params.applicationId).toLong()
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile ewf where ewf.applicationId=? " +
                    "and ewf.applicationFor=? and ewf.typeOfFile=? and ewf.version=? order by ewf.id desc",[appId,'EWaste','indClarificationFile',fileVer],[max:1])
            def applicationFileSingleInstance=applicationFileInstance[0]
            response.setContentType( "application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )

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
    // satish code ends

    ////////// Ends Here...

    def search = {
        try {
            def checkDate
            Date today = new Date();
            def x
            def y
            def startDate1 = params.start_date_value
            def endDate1 = params.end_date_value
            def category = (params.category)
            def categoryLong
            def finalListToPrint = new ArrayList()
            if (params.category != "xyz") {
                categoryLong = (params.category)
            }
            def status = params.status
            def statusType = params.statusType
            def bioList

            def allFourB = new ArrayList()
            def appListB = new ArrayList()
            def statusListB = new ArrayList()
            def pendingWithB = new ArrayList()
            def pendingWithRoleB = new ArrayList()



            def checkBio = false

            try {
                def sdfh = new SimpleDateFormat("dd/MM/yyyy");
                x = sdfh.parse(startDate1); //Date
                y = sdfh.parse(endDate1);  //Date
                checkDate = "checked"
            }
            catch (Exception e) {

                flash.message = "Enter Both The Dates in Correct Format "
                redirect(action: wasteSummary)
            }
            if (checkDate) {
                java.sql.Date sqlDate = new java.sql.Date(x.getTime())
                java.sql.Date sqlDate2 = new java.sql.Date(y.getTime())
                sqlDate2.setDate((sqlDate2.getDate() + 1))

                if (startDate1 && endDate1 && category == "xyz" && status == "xyz" && statusType == "xyz") {

                    bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and  bmw.dateCreated>=? and bmw.dateCreated<=? order by bmw.id desc", [sqlDate, sqlDate2])
                    if (bioList) {
                        for (int a = 0; a < bioList.size(); a++) {
                            allFourB = bioList.get(a)
                            if (allFourB) {
                                checkBio = true

                                appListB.add((allFourB))
                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                } else if (startDate1 && endDate1 && category != "xyz" && status == "xyz" && statusType == "xyz") {

                    bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.industryReg.category.name=? ", [sqlDate, sqlDate2, categoryLong])
                    if (bioList) {
                        for (int a = 0; a < bioList.size(); a++) {
                            allFourB = bioList.get(a)
                            if (allFourB) {
                                checkBio = true

                                appListB.add((allFourB))
                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                } else if (startDate1 && endDate1 && category == "xyz" && status != "xyz" && statusType == "xyz") {
                    bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=?", [status, sqlDate, sqlDate2])
                    if (bioList) {
                        for (int a = 0; a < bioList.size(); a++) {
                            allFourB = bioList.get(a)
                            if (allFourB) {
                                checkBio = true

                                appListB.add((allFourB))
                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                } else if (startDate1 && endDate1 && category != "xyz" && status != "xyz" && statusType == "xyz") {
                    bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.industryReg.category.name=? ", [status, sqlDate, sqlDate2, categoryLong])
                    if (bioList) {
                        for (int a = 0; a < bioList.size(); a++) {
                            allFourB = bioList.get(a)
                            if (allFourB) {
                                checkBio = true

                                appListB.add((allFourB))
                                def appliFor = "EWaste"
                                def appliIdStr = (allFourB.id).toString()
                                def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                def checkInst = checkInstList[0]
                                if (checkInst) {
                                    statusListB.add(checkInst.applicationStatus)
                                    pendingWithB.add(checkInst.pendingWith)
                                    pendingWithRoleB.add(checkInst.role)
                                } else {
                                    statusListB.add("Unattended")
                                    pendingWithB.add("Unknown")
                                    pendingWithRoleB.add("Unknown")
                                }
                            }
                        }
                    }


                } else if (startDate1 && endDate1 && category == "xyz" && status == "xyz" && statusType != "xyz") {
                    if (statusType == "EWaste") {
                        bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=?", [sqlDate, sqlDate2])

                        if (bioList) {
                            for (int a = 0; a < bioList.size(); a++) {
                                allFourB = bioList.get(a)
                                if (allFourB) {
                                    checkBio = true

                                    appListB.add((allFourB))
                                    def appliFor = "EWaste"
                                    def appliIdStr = (allFourB.id).toString()
                                    def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                    def checkInst = checkInstList[0]
                                    if (checkInst) {
                                        statusListB.add(checkInst.applicationStatus)
                                        pendingWithB.add(checkInst.pendingWith)
                                        pendingWithRoleB.add(checkInst.role)
                                    } else {
                                        statusListB.add("Unattended")
                                        pendingWithB.add("Unknown")
                                        pendingWithRoleB.add("Unknown")
                                    }
                                }
                            }
                        }
                    }


                } else if (startDate1 && endDate1 && category != "xyz" && status == "xyz" && statusType != "xyz") {
                    if (statusType == "EWaste") {
                        bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus != 'unattended' and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.industryReg.category.name=? ", [sqlDate, sqlDate2, categoryLong])
                        if (bioList) {
                            for (int a = 0; a < bioList.size(); a++) {
                                allFourB = bioList.get(a)
                                if (allFourB) {
                                    checkBio = true

                                    appListB.add((allFourB))
                                    def appliFor = "EWaste"
                                    def appliIdStr = (allFourB.id).toString()
                                    def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                    def checkInst = checkInstList[0]
                                    if (checkInst) {
                                        statusListB.add(checkInst.applicationStatus)
                                        pendingWithB.add(checkInst.pendingWith)
                                        pendingWithRoleB.add(checkInst.role)
                                    } else {
                                        statusListB.add("Unattended")
                                        pendingWithB.add("Unknown")
                                        pendingWithRoleB.add("Unknown")
                                    }
                                }
                            }
                        }
                    }

                } else if (startDate1 && endDate1 && category == "xyz" && status != "xyz" && statusType != "xyz") {
                    if (statusType == "EWaste") {
                        bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=?", [status, sqlDate, sqlDate2])
                        if (bioList) {
                            for (int a = 0; a < bioList.size(); a++) {
                                allFourB = bioList.get(a)
                                if (allFourB) {
                                    checkBio = true

                                    appListB.add((allFourB))
                                    def appliFor = "EWaste"
                                    def appliIdStr = (allFourB.id).toString()
                                    def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                    def checkInst = checkInstList[0]
                                    if (checkInst) {
                                        statusListB.add(checkInst.applicationStatus)
                                        pendingWithB.add(checkInst.pendingWith)
                                        pendingWithRoleB.add(checkInst.role)
                                    } else {
                                        statusListB.add("Unattended")
                                        pendingWithB.add("Unknown")
                                        pendingWithRoleB.add("Unknown")
                                    }
                                }
                            }
                        }
                    }


                } else if (startDate1 && endDate1 && category != "xyz" && status != "xyz" && statusType != "xyz") {
                    if (statusType == "EWaste") {
                        bioList = EWaste.findAll("from EWaste as bmw where bmw.completionStatus='completed' and bmw.applicationStatus = ? and bmw.dateCreated>=? and bmw.dateCreated<=? and bmw.industryReg.category.name=? ", [status, sqlDate, sqlDate2, categoryLong])
                        if (bioList) {
                            for (int a = 0; a < bioList.size(); a++) {
                                allFourB = bioList.get(a)
                                if (allFourB) {
                                    checkBio = true

                                    appListB.add((allFourB))
                                    def appliFor = "EWaste"
                                    def appliIdStr = (allFourB.id).toString()
                                    def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                                    def checkInst = checkInstList[0]
                                    if (checkInst) {
                                        statusListB.add(checkInst.applicationStatus)
                                        pendingWithB.add(checkInst.pendingWith)
                                        pendingWithRoleB.add(checkInst.role)
                                    } else {
                                        statusListB.add("Unattended")
                                        pendingWithB.add("Unknown")
                                        pendingWithRoleB.add("Unknown")
                                    }
                                }
                            }
                        }
                    }


                }

            }

            finalListToPrint = bioList

            render(view: 'searchPage', model: [finalListToPrint: finalListToPrint, status: status, checkBio: checkBio, bioList: bioList, statusListB: statusListB, pendingWithB: pendingWithB, pendingWithRoleB: pendingWithRoleB])
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def routeUnattended = {
        try {
            def applicationUnattendedCountB = EWaste.findAll("From EWaste as bmw WHERE  bmw.applicationStatus='unattended' and  bmw.completionStatus='completed' ")

            def allFourB = new ArrayList()
            def appListB = new ArrayList()


            if (applicationUnattendedCountB) {
                for (int variable1 = 0; variable1 < applicationUnattendedCountB.size(); variable1++) {
                    allFourB = applicationUnattendedCountB.get(variable1)
                    if (allFourB) {

                        appListB.add((allFourB))

                    }
                }
            }

            return [appListB: appListB]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def updateGroups = {
        try {
            if (params.cont != "") {
                //List grpList = GroupMaster.findAllWhere(office:OfficeMaster.get(params.cont),groupDesc:'CESS')
                List grpList = GroupMaster.findAll("from GroupMaster gp where gp.office=? and (gp.groupDesc='EWaste')", [OfficeMaster.get(params.cont)])
                render g.select(width: '10', optionKey: 'id', id: 'grp', name: 'grp', from: grpList, class: 'txt4')
            } else {
                render g.select(width: '10', optionKey: 'id', id: 'grp', name: 'grp', from: '', class: 'txt4', noSelection: ['': 'Select Group'])
            }

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def routeChecked = {
        try {

            if (params.routeThese != null && params.grp != "" && params.grp != null && params.officeId != "" && params.officeId != null) {


                def offIns = OfficeMaster.findByPriority(1)


                def groupPresentHaz = GroupMaster.get((params.grp).toInteger())


                def checkMessage = false
                def checkMessageList = false
                def indregInstance
                def routed

                def hazGroup
                def groupName
                if (groupPresentHaz) {
                    hazGroup = groupPresentHaz

                }
                def applicationObject

                def checkingClass = params.routeThese
                if (checkingClass.getClass().getName() == "java.lang.String") {
                    def appId = checkingClass.toLong()
                    if (EWaste.get(appId)) {
                        applicationObject = EWaste.get(appId)
                        indregInstance = applicationObject.industryReg
                        if (!hazGroup) {
                            flash.message = " E-Waste Group not created .  "
                        } else {
                            def group = hazGroup
                            def roleVsActList = EWasteRoleVsActivity.findAllByActivity(EWasteActivityMaster.findByActivityCode("001"))

                            groupName = hazGroup.groupName


                            for (int i = 0; i < roleVsActList.size(); i++) {


                                if (((roleVsActList.get(i)).role).group == group) {
                                    def appPendDetails = new EWasteManagementPendingDetails()
                                    appPendDetails.applicationId = appId + ""
                                    appPendDetails.applicationFor = "EWaste"
                                    appPendDetails.applicationStatus = "pending"
                                    appPendDetails.indRegInstance = indregInstance

                                    checkMessage = true
                                    appPendDetails.role = (roleVsActList.get(i)).role
                                    appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)

                                    if (appPendDetails.save(flush: true)) {
                                        routed = true
                                        applicationObject.applicationStatus = "Inprogress"
                                        applicationObject.save()
                                    } else {
                                        appPendDetails.errors.each {
                                            println it
                                        }
                                    }


                                } else {


                                }

                            }
                            if (!checkMessage) {
                                flash.message = "E-Waste Group workflow not set.  "
                            }
                        }
                    }

                } else {
                    for (int vari = 0; vari < checkingClass.size(); vari++) {
                        def appId = checkingClass[vari].toLong()
                        if (EWaste.get(appId)) {
                            applicationObject = EWaste.get(appId)
                            indregInstance = applicationObject.industryReg
                            if (!hazGroup) {
                                flash.message = "E-Waste Group not created .  "
                            } else {
                                def group = hazGroup
                                def roleVsActList = EWasteRoleVsActivity.findAllByActivity(EWasteActivityMaster.findByActivityCode("001"))
                                groupName = hazGroup.groupName
                                for (int i = 0; i < roleVsActList.size(); i++) {
                                    if (((roleVsActList.get(i)).role).group == group) {
                                        def appPendDetails = new EWasteManagementPendingDetails()
                                        appPendDetails.applicationId = appId + ""
                                        appPendDetails.applicationFor = "EWaste"
                                        appPendDetails.applicationStatus = "pending"
                                        appPendDetails.indRegInstance = indregInstance
                                        checkMessageList = true

                                        appPendDetails.role = (roleVsActList.get(i)).role
                                        appPendDetails.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole((roleVsActList.get(i)).role)).primaryEmployee)

                                        if (appPendDetails.save(flush: true)) {
                                            routed = true
                                            applicationObject.applicationStatus = "Inprogress"
                                            applicationObject.save()
                                        } else {
                                            appPendDetails.errors.each {
                                                println it
                                            }
                                        }


                                    } else {

                                    }


                                }
                                if (!checkMessageList) {
                                    flash.message = "E-Waste workflow not set.  "
                                }
                            }
                        }
                    }
                }
            } else if (params.routeThese == null) {
                flash.message = "Please Select The Checkbox"
            } else if (params.officeId == "" || params.officeId == null) {
                flash.message = "Please Select The Office to route"
            } else {
                flash.message = "Please Select The Group to route"
            }
            redirect(action: routeUnattended)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    /////


    def printAllCriteriasList = {
        try {
            def applicationObject
            def finalList = new ArrayList()
            def statusList = new ArrayList()
            def pendingWith = new ArrayList()
            def pendingWithRole = new ArrayList()
            def applicationFor = new ArrayList()
            def checkingClass = params.listVal
            if (checkingClass.getClass().getName() == "java.lang.String") {
                def appId = checkingClass.toLong()
                if (EWaste.get(appId)) {
                    applicationObject = EWaste.get(appId)
                    finalList.add(applicationObject)
                    applicationFor.add("EWaste")
                    def appliFor = "EWaste"
                    def appliIdStr = (appId).toString()
                    def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                    def checkInst = checkInstList[0]
                    if (checkInst) {
                        statusList.add(checkInst.applicationStatus)
                        pendingWith.add(checkInst.pendingWith)
                        pendingWithRole.add(checkInst.role)
                    } else {
                        statusList.add("Unattended")
                        pendingWith.add("Unknown")
                        pendingWithRole.add("Unknown")

                    }
                }

            } else {
                for (int i = 0; i < checkingClass.size(); i++) {
                    def appId = checkingClass[i].toLong()
                    if (EWaste.get(appId)) {
                        applicationObject = EWaste.get(appId)
                        finalList.add(applicationObject)
                        applicationFor.add("EWaste")
                        def appliFor = "EWaste"
                        def appliIdStr = (appId).toString()
                        def checkInstList = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'", [appliIdStr], [max: 1])
                        def checkInst = checkInstList[0]
                        if (checkInst) {
                            statusList.add(checkInst.applicationStatus)
                            pendingWith.add(checkInst.pendingWith)
                            pendingWithRole.add(checkInst.role)
                        } else {
                            statusList.add("Unattended")
                            pendingWith.add("Unknown")
                            pendingWithRole.add("Unknown")

                        }


                    }
                }
            }
            return [finalList: finalList, statusList: statusList, pendingWith: pendingWith, pendingWithRole: pendingWithRole, applicationFor: applicationFor]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewClarificationDocument = {
        try {
            def docType = params.docType
            def application = params.appliLoc
            def indApplInstance = EWaste.get((params.appliLoc).toInteger())
            def docName = params.docName
            def fileLoc
            def file
            def docFName = docName.replace(" ", "_")


            def applicationDocumentL = EWasteFile.findAll("from EWasteFile apd where apd.applicationId=? and apd.typeOfFile=? order by apd.id desc", [indApplInstance.id, docName], [max: 1])


            def singleInstanceOfApplicationDocument = applicationDocumentL[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=\"" + singleInstanceOfApplicationDocument.name + "\"")
            response.getOutputStream() << new ByteArrayInputStream(singleInstanceOfApplicationDocument.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewFile = {
        try {
            def fileVer = (params.verValue).toLong()
            def applicatioFor = params.appForWhich
            def appId = (params.appliLoc).toLong()
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='inspectionReport' and wmf.version=? order by wmf.id desc", [appId, applicatioFor, fileVer], [max: 1])
            def applicationFileSingleInstance = applicationFileInstance[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewFile2 = {
        try {
            def fileVer = (params.verValue).toLong()
            def applicatioFor = params.appForWhich
            def appId = (params.appliLoc).toLong()
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedInspectionReport' and wmf.version=? order by wmf.id desc", [appId, applicatioFor, fileVer], [max: 1])
            def applicationFileSingleInstance = applicationFileInstance[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def viewFile3 = {
        try {
            def fileVer = (params.verValue).toLong()
            def applicatioFor = params.appForWhich
            def appId = (params.appliLoc).toLong()
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachedClarificationReport' and wmf.version=? order by wmf.id desc", [appId, applicatioFor, fileVer], [max: 1])
            def applicationFileSingleInstance = applicationFileInstance[0]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewOtherAttachedFile = {
        try {
            def fileVer = (params.verValue).toLong()
            def applicatioFor = params.appForWhich
            def appId = (params.appliLoc).toLong()
            def applicationFileInstance = EWasteFile.findAll("from EWasteFile wmf where wmf.applicationId=? and wmf.applicationFor=? and wmf.typeOfFile='attachLetter' and wmf.version=? order by wmf.id desc", [appId, applicatioFor, fileVer], [max: 1])
            if (!applicationFileInstance) {
                flash.message = "Document not uploaded correctly"
                redirect(action: "openApplicationDetails", params: [appliId: appId, docName: applicatioFor])

            } else {
                def applicationFileSingleInstance = applicationFileInstance[0]
                response.setContentType("application-xdownload")
                response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
                response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    /*def insrtCertificateDetailsForNew = {
        try {
            def userId = session.userMaster
            if (userId == null || userId == "") {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }
            def hazardeousWasteAuthAppInstance = EWaste.get(params.id.toLong())
            def eWasteProcessingDetailsInstance = EWasteProcessingDetails.findByApplicationId(params.id)
            def appId = (params.id).toLong()

            def app = EWasteManagementPendingDetails.findByApplicationId(params.id)
            def roleHeader = app.role.roleName

            def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

            def district = indRegInstanceGet.district.districtName
            //	def tehsil=indRegInstanceGet.tehsil.tehsilName

            boolean chk
            def list = EWasteManagementCertificates.findAllWhere(applicationId: appId)
            if (list.size() > 0) {
                chk = true
            }

            def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)


            if (!hazardeousWasteAuthAppInstance) {
                flash.message = "Not found with id ${params.id}"
                redirect(action: list)
            } else {
                render(view: 'insrtCertDetailsForNew', model: [hazardeousWasteAuthAppInstance: hazardeousWasteAuthAppInstance, indRegInstance: indRegInstance, district: district, wasteManagementFileList: wasteManagementFileList, chk: chk, roleHeader: roleHeader])
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }*/
    def popConditionsAdd = {
        try {
            def check = "Ewaste"

            def app = EWaste.get(params.id)
            println("params.id..app..: "+app)

            def saveconditionsInstance
            def ConditionsList


            def checkAir = "Ewaste"
            if (check) {


                ConditionsList = ConditionsMaster.findAll("from ConditionsMaster abc where  abc.consentType='Ewaste'")
                saveconditionsInstance = SaveConditionsEwaste.findAll(" from SaveConditionsEwaste apd where apd.application=? and apd.consentType='Ewaste'  order by apd.id desc", [app])
println("saveconditionsInstance:  "+saveconditionsInstance)
            }



            return [checkAir: checkAir, check: params.check, appId: params.id, ConditionsList: ConditionsList, saveconditionsInstance: saveconditionsInstance]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    def saveconditions = {
        try {
            def indApplicationDetailsInstance = EWaste.get(params.appId)


            def check

            def alreadyExistedConditionsEwaste
            def alreadyExistedOtherthanEwaste
            if ((params.conditionType).getClass().getName() == "java.lang.String") {

                def savecondinstance = new SaveConditionsEwaste()

                savecondinstance.application = indApplicationDetailsInstance

                savecondinstance.conditions = params.conditionType
                def paramsConsent = params.conditionType

                def save = savecondinstance.consentType = 'Ewaste'


                alreadyExistedConditionsEwaste = SaveConditionsEwaste.findAll("from SaveConditionsEwaste where consentType = 'Ewaste' and conditions = ? and application = ?", [params.conditionType, indApplicationDetailsInstance])

                alreadyExistedOtherthanEwaste = SaveConditionsEwaste.findAll("from SaveConditionsEwaste where consentType != 'Ewaste' and conditions = ? and application = ?", [params.conditionType, indApplicationDetailsInstance])



                if (alreadyExistedConditionsEwaste || alreadyExistedOtherthanEwaste) {
                    flash.message = "This value already exists"

                } else {
                    savecondinstance.save()
                }
            } else {
                //satish code start; for select multiple conditions
                for(int i=0;i<params.conditionType.size();i++)
                {
                    def savecondinstance= new SaveConditionsEwaste()

                    savecondinstance.application=indApplicationDetailsInstance

                    savecondinstance.conditions = params.conditionType[i]
                    def paramsConsent=params.conditionType[i]

                    def save=savecondinstance.consentType = 'Ewaste'


                    alreadyExistedConditionsEwaste = SaveConditionsEwaste.findAll("from SaveConditionsEwaste where consentType = 'Ewaste' and conditions = ? and application = ?",[params.conditionType[i],indApplicationDetailsInstance],[max:1])

                    alreadyExistedOtherthanEwaste = SaveConditionsEwaste.findAll("from SaveConditionsEwaste where consentType != 'Ewaste' and conditions = ? and application = ?",[params.conditionType[i],indApplicationDetailsInstance], [max:1])



                    if(alreadyExistedConditionsEwaste || alreadyExistedOtherthanEwaste){
                        flash.message="This value already exists"

                    }else{
                        savecondinstance.save()
                    }
                }
                // satish code ends
            }
            def checkAir = "Ewaste"

            redirect(action: popConditionsAdd, id: indApplicationDetailsInstance, params: [checkAir: checkAir])

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def createEwaste_SCN_Certificate = {
        try {

            def userId = session.userMaster
            if (userId == null || userId == "") {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }

            def showCauseDays = params.showCauseDays
            println("showCauseDays....: "+showCauseDays)
            def hazardeousWasteAuthAppInstance = EWaste.get(params.hazardeousWasteAuthAppInstanceid)




            def checkForView = false
            def app = EWasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString())

            def id = app.id

            def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
            println("indRegInstance.. :"+indRegInstance)
            def indRegInstanceId = indRegInstance.id
            println("indRegInstanceId,.. :"+indRegInstanceId)
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)
            println("indRegInstanceGet.. : "+indRegInstanceGet)

            def district = indRegInstanceGet.district.districtName
            println("district.... : "+district)

            def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            def dateToday = new Date();

            //String number = params.authNumber
            String date = dateFormat.format(dateToday)
            String indName = indRegInstanceGet.indName
            String indAddress = indRegInstanceGet.indAddress
            String indCity = indRegInstanceGet.indCity
            String indDistrict = district
            //String indTehsil = tehsil
            String appId = hazardeousWasteAuthAppInstance.id

            def a = IndustryRegMaster.find("from IndustryRegMaster where id = ?",indRegInstanceId)
            println("a....."+a.district.id)
            def groupId = GroupDistrictMaster.find("from GroupDistrictMaster gdm where gdm.district.id = ? order by gdm.id desc",[a.district.id])

            def groupName = groupId.group.groupName
            String grpAddress = findGrpAddress(groupName)

            def region = params.region

            def t = dateFormat.format(hazardeousWasteAuthAppInstance.dateCreated)
            String appDate = t

            //String certiFor = params.certiFor

            //String authorizationFrom = params.authorizationFrom_value
            //String authorizationTo = params.authorizationTo_value
            //String termsAndConditions = params.termsConditions
            //String regNo = params.regNo


            String draftLetterDate = params.LetterDatedOn
            String role = params.role

            //Start save conditions

            def dataforsaveConditionEwaste = SaveConditionsEwaste.findAll("from SaveConditionsEwaste scb where scb.application=?", [hazardeousWasteAuthAppInstance])
            def size1 = dataforsaveConditionEwaste.size();
            def conditionsforEwaste = new String[size1];
            for (int i = 0; i < size1; i++) {
                conditionsforEwaste[i] = (String) (dataforsaveConditionEwaste[i].conditions);

            }

//start coding for general Deficiencies

            def referenceCheck = params.otherDetails
            def refSize = referenceCheck.size()
            def referencesArray = new String[refSize]

            def referenceStore = ""
            if (referenceCheck.getClass().getName() == "java.lang.String") {
                referenceStore = "1. " + referenceCheck
            } else {
                for (int varI = 0; varI < referenceCheck.size(); varI++) {
                    int varInteger = varI + 1
                    referencesArray[varI] = referenceCheck[varI]
                    referenceStore = referenceStore + "\n" + varInteger + ". " + referenceCheck[varI]
                }
            }
            for (int checkVar = 0; checkVar < referencesArray.size(); checkVar++) {
            }
            //end

            EWasteManagementCertificates file = new EWasteManagementCertificates()
            EwasteScncCertificate hwCert = new EwasteScncCertificate()
            File certificate;

            certificate = hwCert.pdfgenerationSCNEwaste(date, indName, indAddress, indCity, indDistrict, appId, appDate, draftLetterDate, role, conditionsforEwaste, referencesArray, showCauseDays,grpAddress, region)

            byte[] b = new byte[(int) certificate.length()];

            FileInputStream fileInputStream = new FileInputStream(certificate);
            fileInputStream.read(b);

            def fileLength = certificate.length()
            file.size = fileLength / 1024  //f.getSize()
            file.extension = "pdf"//extractExtension( f )
            file.data = b;
            //String fileName = appId.concat("New").concat(".pdf")//saroj
            String fileName = ("EWasteScnCertificate").concat(".pdf")
            file.name = fileName
            file.description = "EWasteNew"
            file.createdBy = indRegInstance.indName
            file.updatedBy = indRegInstance.indName
            file.typeOfFile = "EWasteScnCertificate"

            file.indreg = indRegInstance
            file.applicationId = hazardeousWasteAuthAppInstance.id
            file.applicationFor = "EWaste"
            def fileid = null
            if (file.save()) {
                fileid = file.id
                // response.setContentType( "application-xdownload")
                //response.setHeader("Content-Disposition", "attachment;filename=${file.name}")
                //response.getOutputStream() << new ByteArrayInputStream( file.data )
                flash.userMessage = "E-Waste - New Certificate is generated properly."
                checkForView = true
                redirect(controller: "eWaste", action: "appProcessing", params: [id: hazardeousWasteAuthAppInstance.id, checkForView: checkForView, fileid: fileid])
                /////return [ bioMedicalWasteInstance : bioMedicalWasteInstance , indRegInstanceGet:indRegInstanceGet ,checkForView:checkForView]
            }

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    /*def createNewCertificate = {
        try {
            def userId = session.userMaster
            if (userId == null || userId == "") {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }

            def hazardeousWasteAuthAppInstance = EWaste.get(params.hazardeousWasteAuthAppInstanceid)
          
            println("params1121321: "+params)
            def checkForView = false
            def app = EWasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString())

            def id = app.id

            def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
            def indRegInstanceId = indRegInstance.id
            def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

            def district = indRegInstanceGet.district.districtName

            String region = ""
            println("region:.... "+ region)
            def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            def dateToday = new Date();

            
            String date = dateFormat.format(dateToday)
            String indName = hazardeousWasteAuthAppInstance.industryReg.indName
            String indAddress = hazardeousWasteAuthAppInstance.industryReg.indAddress
            String indCity = ""
            String indDistrict = hazardeousWasteAuthAppInstance.industryReg.district.districtName

           
            String appId = hazardeousWasteAuthAppInstance.id
            def t = dateFormat.format(hazardeousWasteAuthAppInstance.dateCreated)
           


            

          //paramsssss
          
          def authNo = params.authNo
          String t11 = params.draftDate_value
          String t12 = params.issueDate_value
          String t13 = params.expiryDate_value
          
          def draftDate = t11
          def issueDate = t12
          def expiryDate = t13
          
          
          def text21 = params.text21
          def text22 = params.text22
          def text23 = params.text23
          def text24 = params.text24
          def text41 = params.text41
          def text42 = params.text42
          def text2 = params.text2
          def text4 = params.text4

            EWasteManagementCertificates file = new EWasteManagementCertificates()
            EWasteCertificates hwCert = new EWasteCertificates()
            File certificate;
            if(hazardeousWasteAuthAppInstance.authorisationType=='chkManufactureOrRefurbisher'){
            certificate = hwCert.generateNewCertificate(indName,indAddress,indDistrict,authNo,draftDate,issueDate,expiryDate,text21,text22,text23,text24,text41,text42)
            }else{
            certificate = hwCert.generateNewCertificate1(indName,indAddress,indDistrict,authNo,draftDate,issueDate,expiryDate,text2,text4)	
            }
            byte[] b = new byte[(int) certificate.length()];

            FileInputStream fileInputStream = new FileInputStream(certificate);
            fileInputStream.read(b);

            def fileLength = certificate.length()
            file.size = fileLength / 1024  //f.getSize()
            file.extension = "pdf"
            file.data = b;
            String fileName = appId.concat("New").concat(".pdf")
            file.name = fileName
            file.description = "EWasteNew"
            file.createdBy = indRegInstance.indName
            file.updatedBy = indRegInstance.indName
            file.typeOfFile = "EWasteNew"

            

            file.indreg = indRegInstance
            file.applicationId = hazardeousWasteAuthAppInstance.id
            file.applicationFor = "EWaste"
            def fileid = null
            if (file.save()) {
                fileid = file.id
                
                flash.userMessage = "E-Waste - New Certificate is generated properly."
                checkForView = true
                redirect(controller: "eWaste", action: "appProcessing", params: [id: hazardeousWasteAuthAppInstance.id, checkForView: checkForView, fileid: fileid])
                }
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

   
    */
    
    def popConditionsView = {
        try {


            def app = EWaste.get((params.id).toInteger())

            def val = "Ewaste";

            def saveconditionsInstance = SaveConditionsEwaste.findAll(" from SaveConditionsEwaste apd where apd.application=? and apd.consentType=? order by apd.id desc", [app, val])


            def check = "Ewaste"

            return [checkAir: check, app: app, saveconditionsInst: saveconditionsInstance, val: val]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def popConditionsEdit = {
        try {
            def check = "Ewaste"

            def app = EWaste.get(params.id)


            def saveconditionsInstance
            def ConditionsList



            def checkAir = "Ewaste"
            if (check) {

                // ConditionsList = ConditionsMaster.findAll("from ConditionsMaster abc where  abc.consentType='Ewaste'")
                saveconditionsInstance = SaveConditionsEwaste.findAll(" from SaveConditionsEwaste apd where apd.application=? and apd.consentType='Ewaste'  order by apd.id desc", [app])

            } else {

            }
            return [checkAir: checkAir, appId: app, saveconditionsInst: saveconditionsInstance, check: params.check]

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def deleteconditionsDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())

            if ((params.delete).getClass().getName() == "java.lang.String") {
                def newInst = SaveConditionsEwaste.get((params.delete).toInteger())
                newInst.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def newInst = SaveConditionsEwaste.get((params.delete[i]).toInteger())
                        newInst.delete()


                    }
            }
            redirect(action: popConditionsEdit, id: app, params: [check: params.check, checkAir: params.checkAir])

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewEWasteCert = {
        try {
        	println("params..ll..: "+params)
            def industryId = session.indUser
            def userId = session.userMaster
            if ((userId == null || userId == "") && (industryId == null || industryId == "")) {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }

            //def application = EWasteManagementCertificates.get((params.id).toLong())
            def application = EWasteManagementCertificates.findByApplicationId((params.id).toString())
            
            println("application..ll..: "+application)
            //def application1=application.id
            def applicationFileSingleInstance = application
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def viewEWasteCert1 = {
        try {
            def industryId = session.indUser
            def userId = session.userMaster
            if ((userId == null || userId == "") && (industryId == null || industryId == "")) {
                flash.message = "Your session has been expired ! Please login again."
                redirect(controller: "userMaster", action: "logout")
            }
            def temp = (params.id).toLong()
            //def application = EWasteManagementCertificates.get((params.id).toLong())
            def application = EWasteManagementCertificates.findAllWhere(applicationId: temp)
            def applicationFileSingleInstance = application[(application.size) -1]
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${applicationFileSingleInstance.name}")
            response.getOutputStream() << new ByteArrayInputStream(applicationFileSingleInstance.data)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def delApp = {

    }


    def deleteApp = {
        try {
            def indId = params.surroundingName

////////////////////////////////////////////////////////////			//
            def getApplicationID



            getApplicationID = EWaste.findAll("from EWaste abc where abc.id=? ", [indId.toLong()])
            getApplicationID = getApplicationID.id
            def app = EWaste.find("from EWaste abc where abc.id=? ", [indId.toLong()])

//////////////////////			/deleting application id from all e-waste tables/////////////////////////////

            if (getApplicationID) {

                UserMaster um = (UserMaster) session.getAttribute("userMaster");

                def deletedAppInstance = new EWasteDeletedApplication()

                deletedAppInstance.application = app.id
                deletedAppInstance.ipAddress = request.getRemoteAddr()
                deletedAppInstance.deletionDate = new Date()
                deletedAppInstance.userID = um

                deletedAppInstance.save()
                //

                for (int ui = 0; ui < getApplicationID.size(); ui++) {

                    def deletionFromEWasteWaterUsesDetails = EWasteWaterUsesDetails.findAll("from EWasteWaterUsesDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteWaterUsesDetails) {

                        for (int i = 0; i < deletionFromEWasteWaterUsesDetails.size(); i++) {


                            deletionFromEWasteWaterUsesDetails.get(i).delete()

                        }

                    }


                    def deletionFromEWasteWaterTreatmentDetails = EWasteWaterTreatmentDetails.findAll("from EWasteWaterTreatmentDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteWaterTreatmentDetails) {

                        for (int i = 0; i < deletionFromEWasteWaterTreatmentDetails.size(); i++) {


                            deletionFromEWasteWaterTreatmentDetails.get(i).delete()

                        }

                    }


                    def deletionFromEWasteWaterModeUseDetails = EWasteWaterModeUseDetails.findAll("from EWasteWaterModeUseDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteWaterModeUseDetails) {

                        for (int i = 0; i < deletionFromEWasteWaterModeUseDetails.size(); i++) {


                            deletionFromEWasteWaterModeUseDetails.get(i).delete()

                        }

                    }


                    def deletionFromEWasteStackEmissionMonitoring = EWasteStackEmissionMonitoring.findAll("from EWasteStackEmissionMonitoring abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteStackEmissionMonitoring) {

                        for (int i = 0; i < deletionFromEWasteStackEmissionMonitoring.size(); i++) {


                            deletionFromEWasteStackEmissionMonitoring.get(i).delete()

                        }

                    }



                    def deletionFromEWasteRawMaterialDetails = EWasteRawMaterialDetails.findAll("from EWasteRawMaterialDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteRawMaterialDetails) {

                        for (int i = 0; i < deletionFromEWasteRawMaterialDetails.size(); i++) {


                            deletionFromEWasteRawMaterialDetails.get(i).delete()

                        }

                    }



                    def deletionFromEWasteProcessingDetails = EWasteProcessingDetails.findAll("from EWasteProcessingDetails abc where abc.applicationId=?", [getApplicationID.get(ui).toString()])



                    if (deletionFromEWasteProcessingDetails) {

                        for (int i = 0; i < deletionFromEWasteProcessingDetails.size(); i++) {


                            deletionFromEWasteProcessingDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteWaterDischargeDetails = EWasteWaterDischargeDetails.findAll("from EWasteWaterDischargeDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteWaterDischargeDetails) {

                        for (int i = 0; i < deletionFromEWasteWaterDischargeDetails.size(); i++) {


                            deletionFromEWasteWaterDischargeDetails.get(i).delete()

                        }

                    }


                    def deletionFromApplicationDocumentsEW = ApplicationDocumentsEW.findAll("from ApplicationDocumentsEW abc where abc.indApplication.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromApplicationDocumentsEW) {

                        for (int i = 0; i < deletionFromApplicationDocumentsEW.size(); i++) {


                            deletionFromApplicationDocumentsEW.get(i).delete()

                        }

                    }

                    def deletionFromEWasteAmbientAirQualityStandardDetails = EWasteAmbientAirQualityStandardDetails.findAll("from EWasteAmbientAirQualityStandardDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteAmbientAirQualityStandardDetails) {

                        for (int i = 0; i < deletionFromEWasteAmbientAirQualityStandardDetails.size(); i++) {


                            deletionFromEWasteAmbientAirQualityStandardDetails.get(i).delete()

                        }

                    }



                    def deletionFromEWasteDetails = EWasteDetails.findAll("from EWasteDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteDetails) {

                        for (int i = 0; i < deletionFromEWasteDetails.size(); i++) {


                            deletionFromEWasteDetails.get(i).delete()

                        }

                    }


                    def deletionFromEWasteDisposalDetails = EWasteDisposalDetails.findAll("from EWasteDisposalDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteDisposalDetails) {

                        for (int i = 0; i < deletionFromEWasteDisposalDetails.size(); i++) {


                            deletionFromEWasteDisposalDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteFile = EWasteFile.findAll("from EWasteFile abc where abc.applicationId=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteFile) {

                        for (int i = 0; i < deletionFromEWasteFile.size(); i++) {


                            deletionFromEWasteFile.get(i).delete()

                        }

                    }

                    def deletionFromEWasteFuelConsumptionDetails = EWasteFuelConsumptionDetails.findAll("from EWasteFuelConsumptionDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteFuelConsumptionDetails) {

                        for (int i = 0; i < deletionFromEWasteFuelConsumptionDetails.size(); i++) {


                            deletionFromEWasteFuelConsumptionDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteGenDetails = EWasteGenDetails.findAll("from EWasteGenDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteGenDetails) {

                        for (int i = 0; i < deletionFromEWasteGenDetails.size(); i++) {


                            deletionFromEWasteGenDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteIndProductDetails = EWasteIndProductDetails.findAll("from EWasteIndProductDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteIndProductDetails) {

                        for (int i = 0; i < deletionFromEWasteIndProductDetails.size(); i++) {


                            deletionFromEWasteIndProductDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteIndProductionDetails = EWasteIndProductionDetails.findAll("from EWasteIndProductionDetails abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWasteIndProductionDetails) {

                        for (int i = 0; i < deletionFromEWasteIndProductionDetails.size(); i++) {


                            deletionFromEWasteIndProductionDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteInspectionReport = EWasteInspectionReport.findAll("from EWasteInspectionReport abc where abc.application.id=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteInspectionReport) {

                        for (int i = 0; i < deletionFromEWasteInspectionReport.size(); i++) {


                            deletionFromEWasteInspectionReport.get(i).delete()

                        }

                    }


                    def deletionFromEWasteManagementCertificates = EWasteManagementCertificates.findAll("from EWasteManagementCertificates abc where abc.applicationId=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteManagementCertificates) {

                        for (int i = 0; i < deletionFromEWasteManagementCertificates.size(); i++) {


                            deletionFromEWasteManagementCertificates.get(i).delete()

                        }

                    }


                    def deletionFromEWasteManagementFile = EWasteManagementFile.findAll("from EWasteManagementFile abc where abc.applicationId=?", [getApplicationID.get(ui).toLong()])



                    if (deletionFromEWasteManagementFile) {

                        for (int i = 0; i < deletionFromEWasteManagementFile.size(); i++) {


                            deletionFromEWasteManagementFile.get(i).delete()

                        }

                    }

                    def deletionFromEWasteManagementPendingDetails = EWasteManagementPendingDetails.findAll("from EWasteManagementPendingDetails abc where abc.applicationId=?", [getApplicationID.get(ui).toString()])



                    if (deletionFromEWasteManagementPendingDetails) {

                        for (int i = 0; i < deletionFromEWasteManagementPendingDetails.size(); i++) {


                            deletionFromEWasteManagementPendingDetails.get(i).delete()

                        }

                    }

                    def deletionFromEWasteManagementUnattendedApplication = EWasteManagementUnattendedApplication.findAll("from EWasteManagementUnattendedApplication abc where abc.applicationId=?", [getApplicationID.get(ui).toString()])

                    if (deletionFromEWasteManagementUnattendedApplication) {

                        for (int i = 0; i < deletionFromEWasteManagementUnattendedApplication.size(); i++) {


                            deletionFromEWasteManagementUnattendedApplication.get(i).delete()

                        }

                    }


                    def deletionFromEWaste = EWaste.findAll("from EWaste abc where abc.id=? ", [getApplicationID.get(ui).toLong()])


                    if (deletionFromEWaste) {

                        for (int i = 0; i < deletionFromEWaste.size(); i++) {
                            deletionFromEWaste.get(i).delete()
                        }
                        flash.message = "Application  Deleted !! "
                        render(view: 'delApp')

                    }


                }

            } else {
                flash.message = "Enter valid application ID!! "
                render(view: 'delApp')

            }

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }


    }

    def eWasteCheckBox = {
        try {
            System.out.println("Hey.. this is inside eWasteCheckBox")

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

/*//------------------- total quantity start here*/

    def EWpopTotalQuantityAdd = {
        try {
            println("params...."+params.id)
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.."+app)
            System.out.println("app.getClass()..."+app.getClass().getName())
            def totalQualityDetailList = EwasteTotalQuantityDetails.findAllByApplication(app)
           // def rawMaterialDetailList = EWasteRawMaterialDetails.findAllByApplication(app)
            //def totalQualityDetailList = EwasteTotalQuantityDetails.findAll("from EwasteTotalQuantityDetails where application.id=?",[app.id.toLong()])
           // System.out.println("totalQualityDetailList.."+totalQualityDetailList)
            return [appDetId: params.id, totalQualityDetailList: totalQualityDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopTotalQuantityView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.. in view "+app)
            def totalQualityDetailList = EwasteTotalQuantityDetails.findAllByApplication(app)
            System.out.println("totalQualityDetailList.. in view"+totalQualityDetailList)

            return [appDetId: params.id, totalQualityDetailList: totalQualityDetailList]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopTotalQuantityEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def totalQualityDetailList = EwasteTotalQuantityDetails.findAllByApplication(app)
            return [appDetId: params.id, totalQualityDetailList: totalQualityDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def editEWasteTotalQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {

                def totalQualityDetail = EwasteTotalQuantityDetails.get((params.delete).toInteger())
                totalQualityDetail.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def totalQualityDetail = EwasteTotalQuantityDetails.get((params.delete[i]).toInteger())
                        totalQualityDetail.delete()
                    }
            }
            redirect(action: EWpopTotalQuantityEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def saveEWasteTotalQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def totalQualityDetailList = new EwasteTotalQuantityDetails(params)
            totalQualityDetailList.application = app
            totalQualityDetailList.conventionNo = params.conventionNo
            totalQualityDetailList.eWasteName = params.eWasteName
            totalQualityDetailList.quantity = params.quantity
            totalQualityDetailList.nature = params.nature
            def unit = UnitMaster.get((params.unit).toInteger())
            totalQualityDetailList.unit = unit
            totalQualityDetailList.save()
            flash.message = "Details Saved"
            redirect(action: EWpopTotalQuantityAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

/*
//========= total quantity end here

//--------------- refurbished quantity start here
*/


    def EWpopRefurbishedQuantityAdd = {
        try {
            println("params...."+params)
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.."+app)
            System.out.println("app.getClass()..."+app.getClass().getName())
            def refurbishedQuantityDetailList = EwasteRefurbishedQuantityDetails.findAllByApplication(app)

            return [appDetId: params.id, refurbishedQuantityDetailList: refurbishedQuantityDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopRefurbishedQuantityView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.. in view "+app)
            def refurbishedQuantityDetailList = EwasteRefurbishedQuantityDetails.findAllByApplication(app)
            System.out.println("refurbishedQuantityDetailList.. in view"+refurbishedQuantityDetailList)

            return [appDetId: params.id, refurbishedQuantityDetailList: refurbishedQuantityDetailList]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopRefurbishedQuantityEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def refurbishedQuantityDetailList = EwasteRefurbishedQuantityDetails.findAllByApplication(app)
            return [appDetId: params.id, refurbishedQuantityDetailList: refurbishedQuantityDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def editEWasteRefurbishedQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {

                def refurbishedQuantityDetail = EwasteRefurbishedQuantityDetails.get((params.delete).toInteger())
                refurbishedQuantityDetail.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def refurbishedQuantityDetail = EwasteRefurbishedQuantityDetails.get((params.delete[i]).toInteger())
                        refurbishedQuantityDetail.delete()
                    }
            }
            redirect(action: EWpopRefurbishedQuantityEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def saveEWasteRefurbishedQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def refurbishedQuantityDetailList = new EwasteRefurbishedQuantityDetails(params)
            refurbishedQuantityDetailList.application = app
            refurbishedQuantityDetailList.eWasteName = params.eWasteName
            refurbishedQuantityDetailList.quantity = params.quantity
            def unit = UnitMaster.get((params.unit).toInteger())
            refurbishedQuantityDetailList.unit = unit
            refurbishedQuantityDetailList.save()
            flash.message = "Details Saved"
            redirect(action: EWpopRefurbishedQuantityAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

 /*   //========= refursbished end here

    // --------------------------- recycling quantity start here
*/
    def EWpopRecycleQuantityAdd = {
        try {
            println("params...."+params)
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.."+app)
            System.out.println("app.getClass()..."+app.getClass().getName())
            def recycleQuantityDetailList = EwasteRecycleQuantityDetails.findAllByApplication(app)

            return [appDetId: params.id, recycleQuantityDetailList: recycleQuantityDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopRecycleQuantityView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.. in view "+app)
            def recycleQuantityDetailList = EwasteRecycleQuantityDetails.findAllByApplication(app)
            System.out.println("recycleQuantityDetailList.. in view"+recycleQuantityDetailList)

            return [appDetId: params.id, recycleQuantityDetailList: recycleQuantityDetailList]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopRecycleQuantityEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def recycleQuantityDetailList = EwasteRecycleQuantityDetails.findAllByApplication(app)
            return [appDetId: params.id, recycleQuantityDetailList: recycleQuantityDetailList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def editEWasteRecycleQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {

                def recycleQuantityDetail = EwasteRecycleQuantityDetails.get((params.delete).toInteger())
                recycleQuantityDetail.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def recycleQuantityDetail = EwasteRecycleQuantityDetails.get((params.delete[i]).toInteger())
                        recycleQuantityDetail.delete()
                    }
            }
            redirect(action: EWpopRecycleQuantityEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def saveEWasteRecycleQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def recycleQuantityDetailList = new EwasteRecycleQuantityDetails(params)
            recycleQuantityDetailList.application = app
            recycleQuantityDetailList.eWasteName = params.eWasteName
            recycleQuantityDetailList.quantity = params.quantity
            def unit = UnitMaster.get((params.unit).toInteger())
            recycleQuantityDetailList.unit = unit
            recycleQuantityDetailList.save()
            flash.message = "Details Saved"
            redirect(action: EWpopRecycleQuantityAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }


    def EWpopDisposalQuantityAdd = {
        try {
            println("params...."+params)
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.."+app)
            System.out.println("app.getClass()..."+app.getClass().getName())
            def disposalQuantityDetailsList = EwasteDisposalQuantityDetails.findAllByApplication(app)

            return [appDetId: params.id, disposalQuantityDetailsList: disposalQuantityDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopDisposalQuantityView = {
        try {
            def app = EWaste.get((params.id).toInteger())
            System.out.println("app.. in view "+app)
            def disposalQuantityDetailsList = EwasteDisposalQuantityDetails.findAllByApplication(app)
            System.out.println("disposalQuantityDetailsList.. in view"+disposalQuantityDetailsList)

            return [appDetId: params.id, disposalQuantityDetailsList: disposalQuantityDetailsList]
        }
        catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def EWpopDisposalQuantityEdit = {
        try {
            def app = EWaste.get((params.id).toInteger())
            def disposalQuantityDetailsList = EwasteDisposalQuantityDetails.findAllByApplication(app)
            return [appDetId: params.id, disposalQuantityDetailsList: disposalQuantityDetailsList]
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }

    }

    def editEWasteDisposalQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            if ((params.delete).getClass().getName() == "java.lang.String") {

                def disposalQuantityDetail = EwasteDisposalQuantityDetails.get((params.delete).toInteger())
                disposalQuantityDetail.delete()
            } else {
                if (params.delete)
                    for (int i = 0; i < (params.delete).size(); i++) {
                        def disposalQuantityDetail = EwasteDisposalQuantityDetails.get((params.delete[i]).toInteger())
                        disposalQuantityDetail.delete()
                    }
            }
            redirect(action: EWpopDisposalQuantityEdit, id: app)

        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }

    def saveEWasteDisposalQuantityDetails = {
        try {
            def app = EWaste.get((params.appId).toInteger())
            def disposalQuantityDetailsList = new EwasteDisposalQuantityDetails(params)
            disposalQuantityDetailsList.application = app
            disposalQuantityDetailsList.eWasteName = params.eWasteName
            disposalQuantityDetailsList.quantity = params.quantity
            def unit = UnitMaster.get((params.unit).toInteger())
            disposalQuantityDetailsList.unit = unit
            disposalQuantityDetailsList.save()
            flash.message = "Details Saved"
            redirect(action: EWpopDisposalQuantityAdd, id: app)
        } catch (Exception e) {
            e.printStackTrace();
            flash.message = "Server is busy , please try after sometime";
            if (session.indUser) {
                redirect(controller: 'indUser', action: 'openIndustryHome')
            } else if (session.userMaster) {
                redirect(controller: 'userMaster', action: 'openSpcbHome');
            } else {
                session.invalidate()
                redirect(uri: '/index.gsp');
            }
        }
    }
    
    def uploadeWasteCertificate = {
        	
        	def userId = session.userMaster
        	if(userId==null || userId=="")
        	{
        		flash.message="Your session has been expired ! Please login again."
        		redirect(controller:"userMaster",action:"logout")
        	}
    	println("System.out.println111111111111"+params)
    	println("session"+session)
    		def bioMedicalWasteInstance = EWaste.get( (params.id).toLong())
        	def bioid=bioMedicalWasteInstance.id
        	println("bioid------------------------------------"+bioMedicalWasteInstance)
        	def app = EWasteManagementPendingDetails.findByApplicationId(bioid.toString())
    	
        	println("app---------------"+app)
        	def id=app.id
        	
    		
    		def checkForView = false
    		/*def certInst = EWasteManagementCertificates.findByApplicationId(bioMedicalWasteInstance)
    		if(certInst)
    		{
    			checkForView = true
    		}*/
    		def roleHeader=app.role.roleName
        	return [appDetId:params.id,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,checkForView:checkForView]
        }
    
    
    def saveConsentOrder= {
	    	println("Params---------------------------------"+params)
			def idAppl= (params.idIndApp).toLong()
			def bioMedicalWasteInstance=EWaste.get(idAppl)
				def bioid=bioMedicalWasteInstance.id
			def app = EWasteManagementPendingDetails.findByapplicationId(bioMedicalWasteInstance.toString())
			println("Params---------------------------------"+params)
			def id=app.id
			def checkForView = false
			checkForView = true
			
			def roleHeader=app.role.roleName
			def indRegInstance=bioMedicalWasteInstance.industryReg
			def indRegInstanceId=indRegInstance.id
			def indRegInstanceGet=IndustryRegMaster.get(indRegInstanceId)
			
			
			
			

			def referenceDate=params.referenceDate_value

			def checkDate
			def x
			def y
			def zz

	try {
				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 

				zz = sdfh.parse(referenceDate);
				checkDate="checked"
			}
			catch(Exception e) {
				flash.message="Enter Both The BMW Granted Dates "
				render(view:'uploadeWasteCertificate',model:[appDetId:params.idIndApp,bioMedicalWasteInstance:bioMedicalWasteInstance,roleHeader:roleHeader,viewCert:viewCert])
			}

	if(checkDate) {
				
				java.sql.Date refDate = new java.sql.Date(zz.getTime())
				
				

				
	if(session.userMaster==null)
			    	{
						flash.message="Your session has been expired ! Please login again."
			    		redirect(uri:'/index.gsp')
			    		return
			    	}
				
				def recordCheck=RecordCertificateEW.findByApplication(bioMedicalWasteInstance)
				println("recordCheck------"+recordCheck)
				if(recordCheck){
					recordCheck.referenceNo=params.referenceNo
					recordCheck.referenceDate=refDate
					recordCheck.save();
	            def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: app.id)

	            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            def dateToday = new Date();

	            String date = dateFormat.format(dateToday)
	            
	            def t = dateFormat.format(app.dateCreated)
	            String appDate = t

	            

	                    EWasteManagementCertificates file = new EWasteManagementCertificates()
			            EWasteCertificates hwCert = new EWasteCertificates()
			            File certificate;
	                    
	            MultipartFile multi = request.getFile('BioMedicalWasteCertificate')
	             def  ddd = request.getFile('BioMedicalWasteCertificate')
				 println("multi.."+multi)        
	            file.size = multi.getSize() / 1024
	            file.data=multi.getBytes()   
	                def abc = "EWasteCertificate"
		            def b = abc+"."+extractExtension( multi )
			           def regMasterIdB=indRegInstance.id
			           def c = bioMedicalWasteInstance.id.toString()+"_EWasteNew Uploaded.pdf";
						
				        file.extension = "pdf"//extractExtension( f )
			            
	                    file.name =b
			            file.description = "EWasteNew"
			            file.createdBy = (session.userMaster).id
			            file.updatedBy = (session.userMaster).id
			            file.typeOfFile = "EWasteNew Uploaded"

			            

			            file.indreg = indRegInstance
			            file.applicationId = bioMedicalWasteInstance.id
			            file.applicationFor = "EWaste"
			            	println("multi.."+app.id)
			            	  def refusalcertiq=EWasteManagementCertificates.findAll("from EWasteManagementCertificates ew where ew.applicationId=? and ew.typeOfFile='EWasteNew Uploaded'",[bioMedicalWasteInstance.id])
					            if(refusalcertiq){
					            for(int iu=0;iu<refusalcertiq.size();iu++){
					            	refusalcertiq[iu].delete();
					            }
					            }
			            if (file.save()) {
			              
			                println("save file upload")
			                flash.message = "E-Waste - New Certificate is uploaded properly."
			                checkForView = true
			                redirect(controller: "eWaste", action: "appProcessing", params: [id:bioMedicalWasteInstance, checkForView: checkForView])
			                }else {


			                	file.errors.allErrors.each {
			                        println it
			                    }
			                }
			            }
				else{

					println("--se--exitring --")	
						flash.message = "Please generate certificate first."
						checkForView = true
			            redirect(controller: "eWaste", action: "appProcessing", params: [id:bioMedicalWasteInstance, checkForView: checkForView])
				}
	}
	//redirect(controller:'wasteManagementProcessingDetails', action:'appProcessing',params:[id:id,checkForView:checkForView])
								//return;

	
				
			
	}

    def viewReturnReasonForEwaste={
		


    		try {
    			println("--invoked---"+params.id)
    				def application = EWaste.get((params.id).toLong())
    				println("--invoked---"+application)
    				def applicationProcessingDetailsInstanceList =  EWasteProcessingDetails.findAll("from EWasteProcessingDetails w where w.applicationId=? order by w.id desc",[String.valueOf(application.id)]) 
    				println("--invoked---"+applicationProcessingDetailsInstanceList.size())
    				for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
    					if((applicationProcessingDetailsInstanceList.get(i)).returned==true){
    						return[appReturn:applicationProcessingDetailsInstanceList.get(i),app:application]
    					}
    				}
    		}
    		catch(Exception e) {
    		       e.printStackTrace();
    				 flash.message = "Server Busy ..Please try after some time....";
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
    def paymentOption={

			println("====params="+params)
			IndUser indUserInstance=(IndUser)session.indUser
			def indRegInstance=indUserInstance.industryRegMaster
			 
			def	indApplicationDetailsInstance = EWaste.get(params.indAppDetId)
	    	Random random = new Random(new Date().getTime());
	    	int randomInt = random.nextInt(1000000000);
	    	if(params.radio=="online")
	    	{
	    		 println("ABCS---B");    	
	    		render(view:'paymentOption',model:[indApplicationDetailsInstance:indApplicationDetailsInstance,randomInt:randomInt])
	    	}
	    	else if (params.radio=="offline")
	    	{
	    		redirect(action:bankPaymentMode,id:indApplicationDetailsInstance)
	    	}else if (params.radio=="noPaymentNow")
	    	{
	    		println("===inside in bloeck=")
	    		def appFor="EWaste"
	    		indApplicationDetailsInstance.completionStatus="completed"
	    		indApplicationDetailsInstance.save();
	    		RouteOfEWaste routeWaste = new RouteOfEWaste()
	    		if(params.testValue=="true"){
	            	def pending=EWasteManagementPendingDetails.find("from EWasteManagementPendingDetails w where w.applicationId=?",[indApplicationDetailsInstance.id.toString()])
	            	def processInst=EWasteProcessingDetails.find("from EWasteProcessingDetails w where w.applicationId=? order by dateCreated desc",[indApplicationDetailsInstance.id.toString()])
	            	if(pending && processInst.returned==true && processInst.resubmitStatus==false){
	            		pending.applicationStatus="pending"
	            		pending.save()
	            		processInst.returned=false
	            		processInst.resubmitStatus=true
	            		processInst.save()
	            	}else{
	            		 routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id, appFor, indRegInstance)
	            	}
	            	
	            }else{
	          
	            routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id, appFor, indRegInstance)
	            }
	            //routeWaste.routeWasteManagementApp(indApplicationDetailsInstance.id, appFor, indRegInstance)
				SendSms sms = new SendSms();
	    		def appNoEWaste=(indApplicationDetailsInstance.id).toString();
	    		def occupierMobile=indApplicationDetailsInstance.industryReg.occMobile;
		    	if(occupierMobile!=null && occupierMobile!="")
		    	{
		    		sms.sendeeWastepplicationSubmitted(appNoEWaste,occupierMobile,"E-Waste");
		    	}
				
		    	render(view: 'confirmationSubmit', model: [eWasteInstance: indApplicationDetailsInstance, indRegInstance: indApplicationDetailsInstance])
		    	return;
	    	}
	    	
	    	
}
    
    def insrtCertificateDetailsForNew = {
            try {
                def userId = session.userMaster
                if (userId == null || userId == "") {
                    flash.message = "Your session has been expired ! Please login again."
                    redirect(controller: "userMaster", action: "logout")
                }
                def hazardeousWasteAuthAppInstance = EWaste.get(params.id.toLong())
                def eWasteProcessingDetailsInstance = EWasteProcessingDetails.findByApplicationId(params.id)
                def appId = (params.id).toLong()

                def app = EWasteManagementPendingDetails.findByApplicationId(params.id)
                def roleHeader = app.role.roleName

                def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
                def indRegInstanceId = indRegInstance.id
                def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

                def district = indRegInstanceGet.district.districtName
                //	def tehsil=indRegInstanceGet.tehsil.tehsilName

                boolean chk
                def list = EWasteManagementCertificates.findAllWhere(applicationId: appId)
                if (list.size() > 0) {
                    chk = true
                }

                def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)


                if (!hazardeousWasteAuthAppInstance) {
                    flash.message = "Not found with id ${params.id}"
                    redirect(action: list)
                } else {
                    render(view: 'insrtCertDetailsForNew', model: [hazardeousWasteAuthAppInstance: hazardeousWasteAuthAppInstance, indRegInstance: indRegInstance, district: district, wasteManagementFileList: wasteManagementFileList, chk: chk, roleHeader: roleHeader])
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
                flash.message = "Server is busy , please try after sometime";
                if (session.indUser) {
                    redirect(controller: 'indUser', action: 'openIndustryHome')
                } else if (session.userMaster) {
                    redirect(controller: 'userMaster', action: 'openSpcbHome');
                } else {
                    session.invalidate()
                    redirect(uri: '/index.gsp');
                }
            }
        }
    
    def createNewCertificate = {
            try {
                def userId = session.userMaster
                if (userId == null || userId == "") {
                    flash.message = "Your session has been expired ! Please login again."
                    redirect(controller: "userMaster", action: "logout")
                }

                def hazardeousWasteAuthAppInstance = EWaste.get(params.hazardeousWasteAuthAppInstanceid)
              
                println("params1121321: "+params)
                def checkForView = false
                def app = EWasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString())

                def id = app.id

                def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
                def indRegInstanceId = indRegInstance.id
                def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

                def district = indRegInstanceGet.district.districtName

                String region = ""
                println("region:.... "+ region)
                def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                def dateToday = new Date();

                
                String date = dateFormat.format(dateToday)
                String indName = hazardeousWasteAuthAppInstance.industryReg.indName
                String indAddress = hazardeousWasteAuthAppInstance.industryReg.indAddress
                String indCity = ""
                String indDistrict = hazardeousWasteAuthAppInstance.industryReg.district.districtName

               
                String appId = hazardeousWasteAuthAppInstance.id
                def t = dateFormat.format(hazardeousWasteAuthAppInstance.dateCreated)
               


                

              //paramsssss
              
              def authNo = params.authNo
              String t11 = params.draftDate_value
              String t12 = params.issueDate_value
              String t13 = params.expiryDate_value
              
              def draftDate = t11
              def issueDate = t12
              def expiryDate = t13
              
              
              def date1=new SimpleDateFormat("dd/MM/yyyy")
              def datee=  date1.parse(t12)
               println("sfqfg----"+datee)
              def text21 = params.text21
              def text22 = params.text22
              def text23 = params.text23
              def text24 = params.text24
              def text41 = params.text41
              def text42 = params.text42
              def text2 = params.text2
              def text4 = params.text4
              def termsco=params.termsco
              def copyTo=params.copyTo
              def recordCerti
               def indRegId=(hazardeousWasteAuthAppInstance.industryReg.id).toString()
               def appIdA=(hazardeousWasteAuthAppInstance.id).toString();
                 recordCerti=RecordCertificateEW.findByApplication(hazardeousWasteAuthAppInstance)
                if(recordCerti){
                 
                }else{
                 recordCerti= new RecordCertificateEW();
                }
                 recordCerti.application=hazardeousWasteAuthAppInstance
                 recordCerti.updatedBy=session.userMaster
                 recordCerti.createdBy=session.userMaster
                 recordCerti.issueDate =date1.parse(t12)
                 recordCerti.expiryDate=date1.parse(t13)
                 recordCerti.letterNo =authNo
                 recordCerti.letterFor="Granted"
                 recordCerti.issueLetterDate=date1.parse(t12)
                 recordCerti.draftLetterDate =date1.parse(t11)
                 recordCerti.certiFor ="EWaste"
                 if(params.copyTo!=null){
                	 recordCerti.copyTo=params.copyTo
                 }else{
                 recordCerti.copyTo =""
                 }
                 recordCerti.subject ="Granted"
                 recordCerti.authorizationNo =authNo
                 recordCerti.draftLetterFor  =""
                 recordCerti.offAddres =""
                 recordCerti.authorizationFor =""
                 recordCerti.facility =""
                 recordCerti.serviceProvider =""
                 if(params.text2!=null){
                 recordCerti.collected =params.text2
                 }else{
                 recordCerti.collected=""
                 }
                 recordCerti.authCancelled =""
                 recordCerti.referenceNo =authNo
                 recordCerti.referenceDate=new Date()
                 recordCerti.authorizationFrom= new Date()
                 recordCerti.authorizationTo=new Date()
                 recordCerti.showCauseDays=""
                 if(params.termsco!=null){
                 recordCerti.termsco=params.termsco
                 }else{
                  recordCerti.termsco=""
                 }
                 if(params.text21!=null){
                 recordCerti.text21 = params.text21
                 }else{
                	 recordCerti.text21=""
                 }
                 if(params.text22!=null){
                	 recordCerti.text22 = params.text22
                 }
                 else{
                	 recordCerti.text22="" 
                 }	
                 if(params.text23!=null){
                	 recordCerti.text23 = params.text23
                 }
                 else{
                	 recordCerti.text23="" 
                 }
                 if(params.text24!=null){
                	 recordCerti.text24 = params.text24
                 }
                 else{
                	 recordCerti.text24="" 
                 }	
                 if(params.text25!=null){
                	 recordCerti.text25 = params.text25
                 }
                 else{
                	 recordCerti.text25="" 
                 }	
                 if(params.text41!=null){
                	 recordCerti.text41 = params.text41
                 }
                 else{
                	 recordCerti.text41="" 
                 }
                 if(params.text42!=null){
                	 recordCerti.text42 = params.text42
                 }
                 else{
                	 recordCerti.text42="" 
                 }
                 if(params.text2!=null){
                	 recordCerti.text2 = params.text2
                 }
                 else{
                	 recordCerti.text2="" 
                 }
                 if(params.text4!=null){
                	 recordCerti.text4 = params.text4
                 }
                 else{
                	 recordCerti.text4="" 
                 }
                
                	 if(!recordCerti.hasErrors() && recordCerti.save(flush:true)){
                EWasteManagementCertificates file = new EWasteManagementCertificates()
                EWasteCertificates hwCert = new EWasteCertificates()
                File certificate;
                if(hazardeousWasteAuthAppInstance.authorisationType=='chkManufactureOrRefurbisher'){
                certificate = hwCert.generateNewCertificate(indName,indAddress,indDistrict,authNo,draftDate,issueDate,expiryDate,text21,text22,text23,text24,text41,text42,indRegId,appIdA,termsco,copyTo)
                }else{
                certificate = hwCert.generateNewCertificate1(indName,indAddress,indDistrict,authNo,draftDate,issueDate,expiryDate,text2,text4,indRegId,appIdA,termsco,copyTo)	
                }
                byte[] b = new byte[(int) certificate.length()];

                FileInputStream fileInputStream = new FileInputStream(certificate);
                fileInputStream.read(b);

                def fileLength = certificate.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"
                file.data = b;
                String fileName = appId.concat("New").concat(".pdf")
                file.name = fileName
                file.description = "EWasteNew"
                file.createdBy = indRegInstance.indName
                file.updatedBy = indRegInstance.indName
                file.typeOfFile = "EWasteNew"

                

                file.indreg = indRegInstance
                file.applicationId = hazardeousWasteAuthAppInstance.id
                file.applicationFor = "EWaste"
                	def refusalcerti=EWasteManagementCertificates.findAll("from EWasteManagementCertificates ew where ew.applicationId=? and ew.typeOfFile='EWasteNew'",[hazardeousWasteAuthAppInstance.id])
    	            if(refusalcerti){
    	            for(int iu=0;iu<refusalcerti.size();iu++){
    	            	refusalcerti[iu].delete();
    	            }
    	            }
                def fileid = null
                if (file.save()) {
                    fileid = file.id
                    
                    flash.message = "E-Waste - New Certificate is generated properly."
                    checkForView = true
                    redirect(controller: "eWaste", action: "appProcessing", params: [id: hazardeousWasteAuthAppInstance.id, checkForView: checkForView, fileid: fileid])
                    }
            } 
            else{
            	recordCerti.errors.each {
    		    	println it
    		  }
            	flash.userMessage = "not Generetad."
            		 checkForView = true
                     redirect(controller: "eWaste", action: "appProcessing", params: [id: hazardeousWasteAuthAppInstance.id, checkForView: checkForView, fileid: fileid])
            }}
                 catch (Exception e) {
                e.printStackTrace();
                flash.message = "Server is busy , please try after sometime";
                if (session.indUser) {
                    redirect(controller: 'indUser', action: 'openIndustryHome')
                } else if (session.userMaster) {
                    redirect(controller: 'userMaster', action: 'openSpcbHome');
                } else {
                    session.invalidate()
                    redirect(uri: '/index.gsp');
                }
            }
        }

    def refusalCerti={
    		
    		def userId = session.userMaster
                if (userId == null || userId == "") {
                    flash.message = "Your session has been expired ! Please login again."
                    redirect(controller: "userMaster", action: "logout")
                }
                def hazardeousWasteAuthAppInstance = EWaste.get(params.id.toLong())
                def eWasteProcessingDetailsInstance = EWasteProcessingDetails.findByApplicationId(params.id)
                def appId = (params.id).toLong()

                def app = EWasteManagementPendingDetails.findByApplicationId(params.id)
                def roleHeader = app.role.roleName

                def indRegInstance = hazardeousWasteAuthAppInstance.industryReg
                def indRegInstanceId = indRegInstance.id
                def indRegInstanceGet = IndustryRegMaster.get(indRegInstanceId)

                def district = indRegInstanceGet.district.districtName
                //	def tehsil=indRegInstanceGet.tehsil.tehsilName

                boolean chk
                def list = EWasteManagementCertificates.findAllWhere(applicationId: appId)
                if (list.size() > 0) {
                    chk = true
                }

                def wasteManagementFileList = EWasteFile.findAllWhere(applicationId: hazardeousWasteAuthAppInstance.id)


                if (!hazardeousWasteAuthAppInstance) {
                    flash.message = "Not found with id ${params.id}"
                    redirect(action: list)
                } else {
                    return [hazardeousWasteAuthAppInstance: hazardeousWasteAuthAppInstance, indRegInstance: indRegInstance, district: district, wasteManagementFileList: wasteManagementFileList, chk: chk, roleHeader: roleHeader]
                    
                }
    }
    def saveRefusalCerti={
        	try{	
        	File certFile;
        	println("-------params-----"+params)
        	def application=EWaste.get(params.hazardeousWasteAuthAppInstanceid.toLong())
        	String industryName=application.industryReg.indName
        	String industryAddress=application.industryReg.indAddress
    		String industryDistrict=application.industryReg.district.districtName
    		String dateOfIssue=params.draftDate_value
    		String indRegMasId=application.industryReg.id.toString();
    		String indApplId=application.id.toString()
    		String number=params.authNo
    		 def date1=new SimpleDateFormat("dd/MM/yyyy")
    		String copyTo=""
    		String termsco=params.termsco
    		def recordCerti
    		recordCerti=RecordCertificateEW.findByApplication(application)
            if(recordCerti){
             
            }else{
             recordCerti= new RecordCertificateEW();
            }
             recordCerti.application=application
             recordCerti.updatedBy=session.userMaster
             recordCerti.createdBy=session.userMaster
             recordCerti.issueDate =new Date()
             recordCerti.expiryDate=new Date()
             recordCerti.letterNo =params.authNo
             recordCerti.letterFor="Refused"
             recordCerti.issueLetterDate=date1.parse(dateOfIssue)
             recordCerti.draftLetterDate =date1.parse(dateOfIssue)
             recordCerti.certiFor ="EWaste"
             recordCerti.copyTo =""
             recordCerti.subject ="Refused"
             recordCerti.authorizationNo =params.authNo
             recordCerti.draftLetterFor  =""
             recordCerti.offAddres =""
             recordCerti.authorizationFor =""
             recordCerti.facility =""
             recordCerti.serviceProvider ="" 
             recordCerti.collected =""
             recordCerti.authCancelled =""
             recordCerti.referenceNo =params.authNo
             recordCerti.referenceDate=new Date()
             recordCerti.authorizationFrom= new Date()
             recordCerti.authorizationTo=new Date()
             recordCerti.showCauseDays=""
             if(termsco!=null){
            recordCerti.termsco=termsco.trim()
             }else{ 
            	 recordCerti.termsco=""
            	 
             }
             recordCerti.text21=""
             recordCerti.text22=""
             recordCerti.text23=""
             recordCerti.text24 =""
             recordCerti.text25=""
             recordCerti.text41=""
             recordCerti.text42=""
             recordCerti.text2=""
             recordCerti.text4=""
            	 if(!recordCerti.hasErrors() && recordCerti.save(flush:true)){
        	EwasteRefusal refusal= new EwasteRefusal();
        	certFile=refusal.ewasteCertRefusal( industryName, industryAddress,
        				 industryDistrict, dateOfIssue, indRegMasId, indApplId, number, copyTo, termsco)
        				EWasteManagementCertificates file = new EWasteManagementCertificates()
        				
    				    byte[] b1 = new byte[(int) certFile.length()];
    				    FileInputStream fileInputStream1 = new FileInputStream(certFile);
    				    fileInputStream1.read(b1);
    				    def fileLength = certFile.length()
    					file.size = fileLength / 1024  //f.getSize()
    					file.data=b1
    		            file.extension = "pdf"
    		            file.data = b1
    		            file.name = application.id+"_RefusalCertificate.pdf"
    		            file.description = "ERefusalCertificate Generation Record"
    		            file.createdBy = session.userMaster
    		            file.updatedBy = session.userMaster
    		            file.typeOfFile = "RefusalCertificate"
    		            file.indreg = application.industryReg
    		            file.applicationId = application.id
    		            file.applicationFor = "EWaste"
    		            def refusalcerti=EWasteManagementCertificates.findAll("from EWasteManagementCertificates ew where ew.applicationId=? and ew.typeOfFile='RefusalCertificate'",[application.id])
    		            if(refusalcerti){
    		            for(int iu=0;iu<refusalcerti.size();iu++){
    		            	refusalcerti[iu].delete();
    		            }
    		            }
    					if(file.save()) {
    						flash.message = "Refusal Certificate Generated"
    					} else {
    						flash.message = "File [${file.name}] has NOT not been uploaded."
    						
    						//render(view:'certificate',model:[recordCertificateInstance:recordCertificateInstance,indRegInstance:indRegInstance,indApplicationDetailsInstance:indApplicationDetailsInstance,fileN:fileN,appID:appID])
    					}		
    		            
        				
        	}else{
        		recordCerti.errors.allErrors.each {
                    println it
                }
        		flash.message = "File  has NOT not been uploaded."
        	}
             redirect(action:appProcessing,id:application.id)
        	}
             catch(Exception e){
        	e.printStackTrace();	
        		
    		
    }
    }
    def viewRefusalEWasteCert={
    		def application = EWasteManagementCertificates.get(params.id.toLong())
	    	def applicationFileSingleInstance=application
		   response.setContentType( "application-xdownload")
		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
}
    def viewDisEWasteCert={
    		def application = EWasteManagementCertificates.get(params.id.toLong())
	    	def applicationFileSingleInstance=application
		   response.setContentType( "application-xdownload")
		   response.setHeader("Content-Disposition", "attachment;filename=\""+applicationFileSingleInstance.name+"\"")
		response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
/*} by me*/




