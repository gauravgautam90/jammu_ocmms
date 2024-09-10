import sun.misc.Request

import javax.management.relation.Role
import java.util.Calendar;
import java.lang.System
import javax.servlet.http.Cookie
import org.postgresql.util.MD5Digest
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.postgresql.core.Encoding
import java.lang.Math
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Random;
import java.security.MessageDigest;
import grails.converters.JSON
import org.apache.commons.fileupload.DiskFileUpload
import org.apache.commons.fileupload.FileItem
import org.apache.commons.io.*
import org.springframework.web.multipart.MultipartFile

/**
 * @author Akhi07t
 *
 */
public class InspectionManagementController {


    def inspectionManagementHome = {

        try {
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // below line is commented by bhanu on 25-07-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu code start; date: 25-07-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends

            return [roleHeader: roleHeader]
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

    def showSpcbInspectionManagementMenu = {

        try {
            render(view: 'spcbInspectionManagementMenu')
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

    def surpriseInspection = {
        try {
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-217
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends

            def grp = GroupMaster.findAll()
            return [grp: grp, roleHeader: roleHeader]
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

    def regularInspection = {

        try {
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends

            def grp = GroupMaster.findAll()
            return [grp: grp, roleHeader: roleHeader]
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


    def searchApplicationList = {
        try {
            def listOfApplication = []
            /*Calendar now = Calendar.getInstance();
			String currentDate =  now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR) ;
		    now = Calendar.getInstance();
		    now.add(Calendar.YEAR, - 1);
		    String oldDate =  now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR) ;
			*/
            def oldDate = params.start_date_value
            def currentDate = params.end_date_value

            java.sql.Date startDate
            java.sql.Date endDate
            try {
                def sdfh = new SimpleDateFormat("dd/MM/yyyy");
                def x = sdfh.parse(oldDate); //Date
                def y = sdfh.parse(currentDate);

                startDate = new java.sql.Date(x.getTime())
                endDate = new java.sql.Date(y.getTime())

            } catch (Exception e) {
                e.printStackTrace();
            }




            try {

                if (startDate < endDate) {
                    //	def record = []
                    //record=RecordCertificate.executeQuery(" rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND ipd.completionStatus = 'completed' AND rc.dateCreated >= ? AND rc.dateCreated <= ? ",[startDate,endDate])

                    if ((params.group == 'xyz') && (params.category == 'None') && (params.district == 'ALL')) {
                        //listOfApplication = IndApplicationDetails.findAll("from IndApplicationDetails ind where ind.completionStatus = 'completed'  order by id desc ");
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id AND rc.dateCreated >= ? AND rc.dateCreated <= ? order by ipd.indUser.category.name desc", [startDate, endDate])

                    } else if ((params.group != 'xyz') && (params.category == 'None') && (params.district == 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.completionStatus = 'completed' AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) order by ipd.indUser.category.name desc", [startDate, endDate, params.group.toLong()])


                    } else if ((params.group != 'xyz') && (params.category == 'None') && (params.district != 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.completionStatus = 'completed' AND ipd.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) order by ipd.indUser.category.name desc", [startDate, endDate, (params.district).toLong(), params.group.toLong()])


                    } else if ((params.group != 'xyz') && (params.category != 'None') && (params.district == 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id   AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed' AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? ))) order by ipd.indUser.category.name desc", [startDate, endDate, params.category, params.group.toLong()])


                    } else if ((params.group != 'xyz') && (params.category != 'None') && (params.district != 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed' AND ipd.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? ))) order by ipd.indUser.category.name desc", [startDate, endDate, params.category, (params.district).toLong(), params.group.toLong()])


                    } else if ((params.group == 'xyz') && (params.category != 'None') && (params.district == 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed'  order by ipd.indUser.category.name desc", [startDate, endDate, params.category])

                    }
                    if (listOfApplication.size() == 0) {
                        flash.message = "No application found with this combination"
                    }
                } else {
                    flash.message = "End Date should be Greater than Starting Date"
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            def grp = GroupMaster.findAll()
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends

            render(view: 'regularInspection', model: [grp: grp, listOfApplication: listOfApplication, roleHeader: roleHeader])
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

    def searchIndustryByName = {
        try {
            def list = []
            boolean showMessage = false
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends
            if (params.autocomplete_parameter1) {
                def firstInput = (params.autocomplete_parameter1).toLowerCase()
                def input = firstInput + '%'
                list = IndustryRegMaster.findAll("from IndustryRegMaster as country where lower(country.indName) like :applicationName ", [applicationName: input])
                if (list.size() == 0) {
                    flash.message = "Industry not found with this serach criteria.You can create new industry by clicking on below link"
                    showMessage = true
                }
            } else {
                flash.message = "Please write industry name"
            }
            render(view: 'surpriseInspection', model: [industryName: params.autocomplete_parameter1, abc: list, showMessage: showMessage, roleHeader: roleHeader])
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


    def generateSurpriseInspectionToNewIndustry = {
        try {
            def industryDetails = IndustryRegMaster.find("from IndustryRegMaster where id = ? ", [(params.id).toLong()])
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends
            def showCloseInspectionSection = false
            if (params.closeInspection != null && params.closeInspection == 'true') {
                showCloseInspectionSection = true
            }

            return [industryDetails: industryDetails, roleHeader: roleHeader, showCloseInspectionSection: showCloseInspectionSection]
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

    //this action is used to show close or prepare surprise inspection page on
    def closeSurpriseInspectionToNewIndustry = {
        try {
            def industryDetails = IndustryRegMaster.find("from IndustryRegMaster where id = ? ", [(params.id).toLong()])
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends
            def showCloseInspectionSection = false
            if (params.closeInspection != null && params.closeInspection == 'true') {
                showCloseInspectionSection = true
            }

            return [industryDetails: industryDetails, roleHeader: roleHeader, showCloseInspectionSection: showCloseInspectionSection]
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

    //this action is used to close surprise inspection
    def closeSurpriseInspection = {
        try {
            def industryDetails = IndustryRegMaster.find("from IndustryRegMaster where id = ? ", [(industryId).toLong()])
            //def surpriseInspectionFwdNotice = SurpriseInspectionFwdNotice.find()

            flash.message = "Surprise Inspection has been closed"
            redirect(controller: 'userMaster', action: 'openSpcbHome')
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


    def inspectionProcessing = {
        try {
            def inspPreparedRgt = false  // for show checklist prepared option only to assigned officer
            def indApp = IndApplicationDetails.get((params.id).toLong())
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends
            def regularInspectionRaised = RegularInspectionRaised.find("from RegularInspectionRaised where application=? ", [indApp]);
            if (regularInspectionRaised) {
                def userID = (regularInspectionRaised.officerId).trim()
                if (userID.equals(session.userMaster.id)) {
                    inspPreparedRgt = true
                }
            }
            def showCloseInspectionSection = true
            /* if(params.closeInspection != null && params.closeInspection == 'true'){
			    	showCloseInspectionSection = true
			    }*/



            def certificateFor
            def authFor = false

            if (indApp) {
            	if (indApp.applicationType == "CTE") {
                    certificateFor = "cte"
            	} else if (indApp.applicationFor == "air") {
					if(indApp.certificateFor=="new"){
						certificateFor="nAir"
					}else{
						certificateFor="rAir"
					}
				} else {
					if(indApp.certificateFor=="new"){
						certificateFor="nWater"
					}else{
						certificateFor="rWater"
					}
				}
                if (indApp.applicationType == "CTO") {}
             }

            def viewCert = false

            def viewCertAir = false
            def viewCertWater = false
            def viewCertHwm = false
            def viewCertAirHwm = false
            def viewCertWaterHwm = false
            def viewCertBothHwm = false
            def viewCertBoth = false

            def certInst = RecordCertificate.findByApplicationId(indApp)
            if (certInst) {
                viewCert = true
            }
            def certUp = false
            /*def certUpload = UploadCertificate.findByApplicationId(indApp)
				if(certUpload)
				{
					certUp=true
				}*/

            def viewCerAir = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForAir'", [indApp])
            if (viewCerAir) {
                viewCertAir = true
            }
            def viewCerBoth = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForBoth'", [indApp])
            if (viewCerBoth) {
                viewCertBoth = true
            }
            def viewCerWaterHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForWaterHwm'", [indApp])
            if (viewCerWaterHwm) {
                viewCertWaterHwm = true
            }
            def viewCerAirHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForAirHwm'", [indApp])
            if (viewCerAirHwm) {
                viewCertAirHwm = true
            }
            def viewCerWater = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForWater'", [indApp])
            if (viewCerWater) {
                viewCertWater = true
            }

            def viewCerHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForHwm'", [indApp])
            if (viewCerHwm) {
                viewCertHwm = true
            }

            def viewCerBothHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForBothHwm'", [indApp])
            if (viewCerBothHwm) {
                viewCertBothHwm = true
            }
            //def app = ApplicationPendingDetails.findByApplication(indApp) // By GAjendra 01/12/2016 coz it taking role from pending table while in case of inspection it is pending with other officer.
          //  def app = InspectionNoteHistory.findByApplication(indApp)
          //  def app = InspectionNoteHistory.findByApplication(indApp, [sort: 'dateCreated', order: 'desc'])
            def app = InspectionFwdNotice.find("from InspectionFwdNotice where regularInspectionAssigned='t' and active='t' and application=? order by dateCreated DESC",[indApp])
          println("app..."+app)
            //def roleActList = RoleVsActivity.findAllByRole(app.role) // By GAjendra 01/12/2016 coz it taking role from pending table while in case of inspection it is pending with other officer.
            def roleActList = InspectionRoleVsActivity.findAllByRole(app.role)
              println("roleActList..."+roleActList)
            def roleId=app.role
            def actionList = new ArrayList()
            def clarification = false
            def inspection = false
            def approve = false
            def reject = false
            def inspectionClose = false
            def regularInspectionClose = false
            def regularInspectionCloseReject = false
            def regularClarificationRaised = false
            def regularInspectionRevoked = false

            def regularInspectionCloseIndustry = false
            def regularInspectionRevokeCloseIndustry = false

            def prepareCertificate = false
            def prepareCertificateForRevoke = false
            def fwdRoleList = new ArrayList()
            def workFlowMasterList = WorkFlowMaster.findAllByRole(app.role) // app.role 22/02/2017
            def returned = false;
            for (int i = 0; i < workFlowMasterList.size(); i++) {
                fwdRoleList.add((workFlowMasterList.get(i)).canForwardTo)
            }
            actionList.add(RoleActivityMaster.findWhere(activityCode: "002"))
            for (int i = 0; i < roleActList.size(); i++) {
                if ((roleActList.get(i)).activity.activityCode == "004") {
                    actionList.add((roleActList.get(i)).activity)
                } else if ((roleActList.get(i)).activity.activityCode == "006") {
                    clarification = true
                } else if ((roleActList.get(i)).activity.activityCode == "007") {
                    inspection = true
                } else if ((roleActList.get(i)).activity.activityCode == "005") {
                    approve = true
                } else if ((roleActList.get(i)).activity.activityCode == "003") {
                    reject = true
                } else if ((roleActList.get(i)).activity.activityCode == "008") {
                    inspectionClose = true
                } else if ((roleActList.get(i)).activity.activityCode == "002") {
                    prepareCertificate = true
                } else if ((roleActList.get(i)).activity.activityCode == "009") {// for return right
                    returned = true
                } else if ((roleActList.get(i)).activity.activityCode == "011") {// for regular clarification raised
                    regularClarificationRaised = true
                } else if ((roleActList.get(i)).activity.activityCode == "012") {// for regular inspection close
                    regularInspectionClose = true
                } else if ((roleActList.get(i)).activity.activityCode == "013") {// for regular inspection close
                    regularInspectionCloseReject = true
                } else if ((roleActList.get(i)).activity.activityCode == "014") {// for regular inspection revoke
                    regularInspectionRevoked = true
                } else if ((roleActList.get(i)).activity.activityCode == "015") {
// for regular inspection close Industry
                    regularInspectionCloseIndustry = true
                } else if ((roleActList.get(i)).activity.activityCode == "016") {
// for regular inspection revoke and close Industry
                    regularInspectionRevokeCloseIndustry = true
                } else if ((roleActList.get(i)).activity.activityCode == "017") {
// for regular inspection revoke and close Industry
                    prepareCertificateForRevoke = true
                }
            }
            println("regularInspectionRevoked..."+regularInspectionRevoked)

            def applicationProcessingDetailsInstanceList = ApplicationProcessingDetails.findAllByApplication(indApp, [sort: 'dateCreated', order: 'desc', offset: 0])
            if (applicationProcessingDetailsInstanceList) {
                def applicationProcessingDetailsInstance = applicationProcessingDetailsInstanceList.get(0)
               model:
                [roleId:roleId,certificateFor: certificateFor, roleHeader: roleHeader, actionList: actionList, clarification: clarification, inspection: inspection, fwdRoleList: fwdRoleList, app: app, indApp: indApp, approve: approve, reject: reject, inspectionClose: inspectionClose, applicationProcessingDetailsInstance: applicationProcessingDetailsInstance, prepareCertificate: prepareCertificate, viewCert: viewCert, viewCertAir: viewCertAir, viewCertWater: viewCertWater, viewCertHwm: viewCertHwm, viewCertAirHwm: viewCertAirHwm, viewCertWaterHwm: viewCertWaterHwm, viewCertBothHwm: viewCertBothHwm, viewCertBoth: viewCertBoth, returned: returned, certUp: certUp, showCloseInspectionSection: showCloseInspectionSection, regularClarificationRaised: regularClarificationRaised, regularInspectionClose: regularInspectionClose, regularInspectionCloseReject: regularInspectionCloseReject, regularInspectionRevoked: regularInspectionRevoked, regularInspectionCloseIndustry: regularInspectionCloseIndustry, regularInspectionRevokeCloseIndustry: regularInspectionRevokeCloseIndustry, prepareCertificateForRevoke: prepareCertificateForRevoke, inspPreparedRgt: inspPreparedRgt]
            } else {
                model:
                [roleId:roleId,certificateFor: certificateFor, roleHeader: roleHeader, actionList: actionList, clarification: clarification, inspection: inspection, fwdRoleList: fwdRoleList, app: app, indApp: indApp, approve: approve, reject: reject, inspectionClose: inspectionClose, applicationProcessingDetailsInstance: null, prepareCertificate: prepareCertificate, viewCert: viewCert, viewCertAir: viewCertAir, viewCertWater: viewCertWater, viewCertHwm: viewCertHwm, viewCertAirHwm: viewCertAirHwm, viewCertWaterHwm: viewCertWaterHwm, viewCertBothHwm: viewCertBothHwm, viewCertBoth: viewCertBoth, returned: returned, certUp: certUp, showCloseInspectionSection: showCloseInspectionSection, regularClarificationRaised: regularClarificationRaised, regularInspectionClose: regularInspectionClose, regularInspectionCloseReject: regularInspectionCloseReject, regularInspectionRevoked: regularInspectionRevoked, regularInspectionCloseIndustry: regularInspectionCloseIndustry, regularInspectionRevokeCloseIndustry: regularInspectionRevokeCloseIndustry, prepareCertificateForRevoke: prepareCertificateForRevoke, inspPreparedRgt: inspPreparedRgt]
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


    def fwdSurpriseInspectionToMS = {
        try {
            def industryDetails = IndustryRegMaster.find("from IndustryRegMaster where id = ? ", [(params.id).toLong()])
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends

            if (params.fwdRoleName == null || params.fwdRoleName == '') {
                flash.message = "MS is not created with group"
                return
            } else {
                return [industryDetails: industryDetails, roleMS: params.fwdRoleName, roleHeader: roleHeader]
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

    def submitSurpriseInspectionNotifyToMS = {
        try {
            def industryDetails = IndustryRegMaster.find("from IndustryRegMaster where id = ? ", [(params.industryId).toLong()])
            def roleMS
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            def roleHeader = curentUserRole.role.roleName

            if (params.fwdRoleName != null) {
                roleMS = RoleMaster.findByRoleName((params.fwdRoleName).trim()) //This is forwarding role
            }

            def inspectionFwdNoticeIns = SurpriseInspectionFwdNotice.findByIndustryAndRole(industryDetails, roleMS);
            if (inspectionFwdNoticeIns) {
                inspectionFwdNoticeIns.delete();
            }

            def forwardingOfficerUserId = UserMaster.get(RoleProfileAssignment.findByRole(roleMS).primaryEmployee.id)

            inspectionFwdNoticeIns = new SurpriseInspectionFwdNotice();
            inspectionFwdNoticeIns.noticeType = "FWD MS"
            inspectionFwdNoticeIns.role = roleMS
            inspectionFwdNoticeIns.user = forwardingOfficerUserId
            inspectionFwdNoticeIns.noOfDays = (params.inspectionDays).toInteger();
            if (params.inspectionNote)
                inspectionFwdNoticeIns.inspectionNote = params.inspectionNote
            else
                inspectionFwdNoticeIns.inspectionNote = ""
            inspectionFwdNoticeIns.dateCreated = new Date();
            inspectionFwdNoticeIns.active = true
            inspectionFwdNoticeIns.industry = industryDetails
            inspectionFwdNoticeIns.isAttending = false
            inspectionFwdNoticeIns.reasonToChooseOfficer = ""
            inspectionFwdNoticeIns.surpriseInspectionAssigned = false
            //	appPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleMS)).primaryEmployee)
            if (!inspectionFwdNoticeIns.hasErrors() && inspectionFwdNoticeIns.save(flush: true)) {
                flash.message = "Surprise Inspection notify to MS Sucessfully... "

                SurpriseInspectionNoteHistroy inspectionNoteHistroy = new SurpriseInspectionNoteHistroy();

                inspectionNoteHistroy.industry = industryDetails
                inspectionNoteHistroy.role = curentUserRole.role  //current role
                inspectionNoteHistroy.roleFwd = roleMS // forwarding role
                inspectionNoteHistroy.officer = session.userMaster.id  //current officer id
                inspectionNoteHistroy.officerFwd = forwardingOfficerUserId //forwarding officer id
                inspectionNoteHistroy.inspectionNote = "Industry forwarding to " + roleMS + " for assignment of Surprise Inspection. "
                inspectionNoteHistroy.dateCreated = new Date();
                inspectionNoteHistroy.lastUpdated = new Date();
                inspectionNoteHistroy.applicationClosed = false
                inspectionNoteHistroy.save();

                redirect(action: "fwdSurpriseInspectionToMS", params: [id: params.industryId, fwdRoleName: params.fwdRoleName])
                return
            } else {
                if (inspectionFwdNoticeIns.hasErrors()) {
                    inspectionFwdNoticeIns.errors.allErrors.each {
                        println it
                    }
                }
            }
            flash.message = "Try Again... "
            redirect(action: "fwdSurpriseInspectionToMS", params: [id: params.industryId, fwdRoleName: params.fwdRoleName])
            return
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

    def showSurpriseApplicationList = {
        try {
            def appList = IndApplicationDetails.findAll("from IndApplicationDetails  where  completionStatus = 'completed' AND indUser.id =?", [(params.id).toLong()])
            return [appList: appList]
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

    def registerNewIndustry = {
        try {
            session.invalidate();
            redirect(action: "create", controller: "industryRegMaster")
            return
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

    def searchApprovedInspection = {
        try {
            def grp = GroupMaster.findAll()
            return [grp: grp]
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

    def searchApprovedApplicationList = {
        try {
            def listOfApplication = []
            def oldDate = params.start_date_value
            def currentDate = params.end_date_value

            java.sql.Date startDate
            java.sql.Date endDate
            try {
                def sdfh = new SimpleDateFormat("dd/MM/yyyy");
                def x = sdfh.parse(oldDate); //Date
                def y = sdfh.parse(currentDate);

                startDate = new java.sql.Date(x.getTime())
                endDate = new java.sql.Date(y.getTime())

            } catch (Exception e) {
                e.printStackTrace();
            }



            try {

                if (startDate < endDate) {
                    //	def record = []
                    //record=RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND ipd.completionStatus = 'completed' AND rc.dateCreated >= ? AND rc.dateCreated <= ? ",[startDate,endDate])

                    if ((params.group == 'xyz') && (params.category == 'None') && (params.district == 'ALL')) {
                        //listOfApplication = IndApplicationDetails.findAll("from IndApplicationDetails ind where ind.completionStatus = 'completed'  order by id desc ");
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id AND rc.dateCreated >= ? AND rc.dateCreated <= ? order by ipd.indUser.category.name desc", [startDate, endDate])

                    } else if ((params.group != 'xyz') && (params.category == 'None') && (params.district == 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.completionStatus = 'completed' AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) order by ipd.indUser.category.name desc", [startDate, endDate, params.group.toLong()])


                    } else if ((params.group != 'xyz') && (params.category == 'None') && (params.district != 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.completionStatus = 'completed' AND ipd.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) order by ipd.indUser.category.name desc", [startDate, endDate, (params.district).toLong(), params.group.toLong()])


                    } else if ((params.group != 'xyz') && (params.category != 'None') && (params.district == 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id   AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed' AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? ))) order by ipd.indUser.category.name desc", [startDate, endDate, params.category, params.group.toLong()])


                    } else if ((params.group != 'xyz') && (params.category != 'None') && (params.district != 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed' AND ipd.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? ))) order by ipd.indUser.category.name desc", [startDate, endDate, params.category, (params.district).toLong(), params.group.toLong()])


                    } else if ((params.group == 'xyz') && (params.category != 'None') && (params.district == 'ALL')) {
                        listOfApplication = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed'  order by ipd.indUser.category.name desc", [startDate, endDate, params.category])
                    }
                    if (listOfApplication.size() == 0) {
                        flash.message = "No application found with this combination"
                    }
                } else {
                    flash.message = "End Date should be Greater than Starting Date"
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            def grp = GroupMaster.findAll()

            render(view: 'searchApprovedInspection', model: [grp: grp, listOfApplication: listOfApplication])
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

    //admin side inspection management creation

    def createInspectionForwardCriteria = {
        try {
            def grp = GroupMaster.findAll()
            return [grp: grp]
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

    def viewInspectionForwardCriteria = {
        try {
            def insForwardInstance = InspectionForwardCriteria.list()
            if (insForwardInstance != null) {
                for (int i = 0; i < insForwardInstance.size(); i++) {
                }
            }
            return [insForwardInstance: insForwardInstance]
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

    def deleteInspectionForwarCriteria = {
        try {
            def app = InspectionForwardCriteria.find("from InspectionForwardCriteria where id=?", [(params.id).toLong()])
            if (app != null) {
                app.delete();
                flash.message = "Inspection Forward Criteria Deleted Sucessfully... "
            } else {
                flash.message = "This Inspection Forward Criteria Does not Exists... "
            }

            redirect(action: "viewInspectionForwardCriteria")
            return
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


    def saveInspectionForwardCriteria = {
        try {
            def indutryTypeList = params.industryType;
            if (params.industryType != null && indutryTypeList.getClass().getName() != "java.lang.String") {
                for (int i = 0; i < indutryTypeList.size(); i++) {
                    InspectionForwardCriteria inspectionForwardCriteriaInstance = new InspectionForwardCriteria();
                    //def indType = IndustryTypeMaster.get(indutryTypeList[i].toLong())
                    inspectionForwardCriteriaInstance.applicationType = params.applicationType
                    inspectionForwardCriteriaInstance.categoryType = params.categoryType
                    inspectionForwardCriteriaInstance.moduleType = params.moduleType
                    inspectionForwardCriteriaInstance.noOfRoOfficer = 2
                    inspectionForwardCriteriaInstance.noOfHoOfficer = 1
                    inspectionForwardCriteriaInstance.createdBy = session.userMaster
                    inspectionForwardCriteriaInstance.forwardRoleType = params.forwardRoleType
                    inspectionForwardCriteriaInstance.industryType = indutryTypeList[i].toString()
                    if (params.capitalInvestment != null && params.capitalInvestment != '') {
                        inspectionForwardCriteriaInstance.capitalInvestment = (params.capitalInvestment).toFloat();
                    } else {
                        inspectionForwardCriteriaInstance.capitalInvestment = 0.0
                    }

                    if (params.group != null && params.group != 'xyz' && params.forwardTo != 'xyz') {
                        def group = GroupMaster.get((params.group).toLong())
                        def user = UserMaster.get(params.forwardTo)
                        def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [user.id]);

                        inspectionForwardCriteriaInstance.groupMaster = group
                        inspectionForwardCriteriaInstance.userMaster = user
                        inspectionForwardCriteriaInstance.roleName = curentUserRole.role.roleName

                        // def checkForExistance =  InspectionForwardCriteria.findAll("from InspectionForwardCriteria where applicationType=? AND categoryType=? AND moduleType=? AND userMaster.id=?",[params.applicationType,params.categoryType,params.moduleType,params.forwardTo])
                        // if(checkForExistance.size == 0){
                        if (!inspectionForwardCriteriaInstance.hasErrors() && inspectionForwardCriteriaInstance.save(flush: true)) {
                            flash.message = "Inspection Forward Criteria Saved Sucessfully... "
                        } else {
                            if (inspectionForwardCriteriaInstance.hasErrors()) {
                                inspectionForwardCriteriaInstance.errors.allErrors.each {
                                    println it
                                }
                            }
                        }
                        // }//else{
                        // flash.message="This Inspection Forward Criteria Already Exists... "
                        //}
                    } else {
                        flash.message = "Please choose group and officer ... "
                    }
                }
            } else {
                InspectionForwardCriteria inspectionForwardCriteriaInstance = new InspectionForwardCriteria();
                //def indType = IndustryTypeMaster.get(indutryTypeList[i].toLong())
                inspectionForwardCriteriaInstance.applicationType = params.applicationType
                inspectionForwardCriteriaInstance.categoryType = params.categoryType
                inspectionForwardCriteriaInstance.moduleType = params.moduleType
                inspectionForwardCriteriaInstance.noOfRoOfficer = 2
                inspectionForwardCriteriaInstance.noOfHoOfficer = 1
                inspectionForwardCriteriaInstance.createdBy = session.userMaster
                inspectionForwardCriteriaInstance.forwardRoleType = params.forwardRoleType
                if (indutryTypeList == null) {
                    inspectionForwardCriteriaInstance.industryType = "ALL"
                } else {
                    inspectionForwardCriteriaInstance.industryType = indutryTypeList.toString()
                }


                if (params.capitalInvestment != null && params.capitalInvestment != '') {
                    inspectionForwardCriteriaInstance.capitalInvestment = (params.capitalInvestment).toFloat();
                } else {
                    inspectionForwardCriteriaInstance.capitalInvestment = 0.0
                }

                if (params.group != null && params.group != 'xyz' && params.forwardTo != 'xyz') {
                    def group = GroupMaster.get((params.group).toLong())
                    def user = UserMaster.get(params.forwardTo)
                    def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [user.id]);

                    inspectionForwardCriteriaInstance.groupMaster = group
                    inspectionForwardCriteriaInstance.userMaster = user
                    inspectionForwardCriteriaInstance.roleName = curentUserRole.role.roleName

                    // def checkForExistance =  InspectionForwardCriteria.findAll("from InspectionForwardCriteria where applicationType=? AND categoryType=? AND moduleType=? AND userMaster.id=?",[params.applicationType,params.categoryType,params.moduleType,params.forwardTo])
                    // if(checkForExistance.size == 0){
                    if (!inspectionForwardCriteriaInstance.hasErrors() && inspectionForwardCriteriaInstance.save(flush: true)) {
                        flash.message = "Inspection Forward Criteria Saved Sucessfully... "
                    } else {
                        if (inspectionForwardCriteriaInstance.hasErrors()) {
                            inspectionForwardCriteriaInstance.errors.allErrors.each {
                                println it
                            }
                        }
                    }
                    // }//else{
                    // flash.message="This Inspection Forward Criteria Already Exists... "
                    //}
                } else {
                    flash.message = "Please choose group and officer ... "
                }

            }

            def grp = GroupMaster.findAll()
            render(view: 'createInspectionForwardCriteria', model: [grp: grp])
            return
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


    def fwdInspectionToMS = {
        try {
            def app = IndApplicationDetails.get((params.appliId).toLong())
            def appPending = ApplicationPendingDetails.findByApplication(app);
            def roleToForward
            if (params.roleName != null) {
                roleToForward = RoleMaster.findByGroupAndRoleName(appPending.role.group, params.roleName)
            }

            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends
            def typeOfInspection
            if (params.typeOfInspection != null && params.typeOfInspection == 'REGULAR_INSPECTION') {
                typeOfInspection = "REGULAR_INSPECTION"
            } else {
                typeOfInspection = "FRESH_INSPECTION"
            }
            if (!roleToForward) {
                flash.message = roleToForward + " is not created with group"
                return
            } else {
                return [app: app, appPending: appPending, roleToForward: roleToForward, roleHeader: roleHeader, typeOfInspection: typeOfInspection]
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


    def submitNotifyMS = {
        try {
            def app = IndApplicationDetails.get((params.appNo).toLong())
            def appPending = ApplicationPendingDetails.findByApplication(app);
            def roleMS = RoleMaster.findByGroupAndRoleName(appPending.role.group, params.forwardUserRole)

            def inspectionFwdNoticeIns = InspectionFwdNotice.findByApplicationAndRole(app, roleMS);
            if (inspectionFwdNoticeIns) {
                inspectionFwdNoticeIns.delete();
            }
            def forwardingOfficerUserId = UserMaster.get(RoleProfileAssignment.findByRole(roleMS).primaryEmployee.id)
//this is forwarding officer Usr id

            inspectionFwdNoticeIns = new InspectionFwdNotice();
            inspectionFwdNoticeIns.noticeType = "FWD MS"
            inspectionFwdNoticeIns.role = roleMS
            inspectionFwdNoticeIns.user = forwardingOfficerUserId
            inspectionFwdNoticeIns.noOfDays = (params.inspectionDays).toInteger();
            if (params.inspectionNote)
                inspectionFwdNoticeIns.inspectionNote = params.inspectionNote
            else
                inspectionFwdNoticeIns.inspectionNote = ""
            inspectionFwdNoticeIns.dateCreated = new Date();
            inspectionFwdNoticeIns.active = true
            inspectionFwdNoticeIns.application = app
            inspectionFwdNoticeIns.reasonToChooseOfficer = ""
            inspectionFwdNoticeIns.typeOfInspection = params.typeOfInspection
            if (!inspectionFwdNoticeIns.hasErrors() && inspectionFwdNoticeIns.save(flush: true)) {
                roleMS.forwardCount += 1;
                roleMS.save(flush: true)
                flash.message = "Inspection notify to MS Sucessfully... "

                if (params.typeOfInspection != null && (params.typeOfInspection).trim() == "FRESH_INSPECTION") {
                    //forwarding application to MS account
                    appPending.role = roleMS
                    //appPending.isMsOfficer = true
                    appPending.pendingWith = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleMS)).primaryEmployee)
                    appPending.save(flush: true)

                }

                InspectionNoteHistory inspectionNoteHistroy = new InspectionNoteHistory();
                def currentOfficerRole = RoleMaster.findById((params.currentUserRole).trim())

                /*def inspectionType
				 * if(params. == 'FRESH_INSPECTION'){
					inspectionType = "Current"
				}*/
                inspectionNoteHistroy.application = app
                inspectionNoteHistroy.role = currentOfficerRole  //current role
                inspectionNoteHistroy.roleFwd = roleMS // forwarding role
                inspectionNoteHistroy.officer = session.userMaster.id  //current officer id
                inspectionNoteHistroy.officerFwd = forwardingOfficerUserId //forwarding officer id
                inspectionNoteHistroy.inspectionNote = "Application forwarding to " + params.forwardUserRole + " for assignment of Inspection. "
                inspectionNoteHistroy.dateCreated = new Date();
                inspectionNoteHistroy.lastUpdated = new Date();
                inspectionNoteHistroy.applicationClosed = false
                inspectionNoteHistroy.typeOfInspection = (params.typeOfInspection).trim()
                // bhanu code start; date: 15-06-2017
                // this column is added to manage file attached in regular inspection -> add previous inspection tab
                inspectionNoteHistroy.previousReportAttachedFile = false
                // bhanu code ends
                inspectionNoteHistroy.save();

                redirect(action: "fwdInspectionToMS", params: [appliId: params.appNo, roleName: roleMS, typeOfInspection: params.typeOfInspection])
                return
            } else {
                if (inspectionFwdNoticeIns.hasErrors()) {
                    inspectionFwdNoticeIns.errors.allErrors.each {
                        println it
                    }
                }
            }
            flash.message = "Try Again... "
            redirect(action: "fwdInspectionToMS", params: [appliId: params.appNo])
            return
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

    def ajaxGetDistrictByGroup = {
        try {
        	println("params in ..ajaxGetDistrictByGroup.."+params)
            def districtList = []
            if (params.id != null && params.id != 'xyz') {
                districtList = GroupDistrictMaster.executeQuery("from GroupDistrictMaster g inner join g.district d  where d.id = g.district.id and  g.group.id=? ", [(params.id).toLong()])
                //def districtList = GroupDistrictMaster.findByGroup((params.id).toLong());

            }
            def sublist = []
            districtList.each {
                sublist.add(it[1])
            }
            render sublist as JSON
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


    def ajaxGetOfficerListByGroup = {
        try {
            def officerList = []
            if (params.id != null && params.id != 'xyz') {
                officerList = RoleProfileAssignment.executeQuery("Select primaryEmployee.id ,role.roleName from RoleProfileAssignment p where p.role.id IN (Select r.id from RoleMaster r where r.group.id=?)", [(params.id).toLong()])

            }

            render officerList as JSON
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


    def inspectionNotices = {
        try {
            def noticeType = params.noticeType
            if (!noticeType)
                noticeType = ""

            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);

            // bhanu commented code start; date: 01-08-2017
            // def roleHeader = curentUserRole.role.roleName
            // bhanu commented code ends

            // bhanu code start; date: 01-08-2017
            def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            // bhanu code ends

            if (noticeType == "FWD MS") {
                /*def inspectionFwdNoticeList=InspectionFwdNotice.findAllByUserAndNoticeType(session.userMaster,"FWD MS");
				  def surpriseInspectionFwdNoticeList=SurpriseInspectionFwdNotice.findAllByUserAndNoticeType(session.userMaster,"FWD MS");
				  */
                def inspectionFwdNoticeList = InspectionFwdNotice.findAll("from InspectionFwdNotice where user=? AND noticeType = ? AND active = ? ", [session.userMaster, "FWD MS", true]);
                def surpriseInspectionFwdNoticeList = SurpriseInspectionFwdNotice.findAll("from SurpriseInspectionFwdNotice where user=? AND noticeType = ? AND active = ? ", [session.userMaster, "FWD MS", true]);

                /* for(int ii=0;ii<inspectionFwdNoticeList.size();ii++)
				  {
					  inspectionFwdNoticeList.get(ii).active=true;
				  }

				  for(int ii=0;ii<surpriseInspectionFwdNoticeList.size();ii++)
				  {
					  surpriseInspectionFwdNoticeList.get(ii).active=true;
				  }*/

                return ['inspectionFwdNoticeList': inspectionFwdNoticeList, 'noticeType': noticeType, surpriseInspectionFwdNoticeList: surpriseInspectionFwdNoticeList]
            } else {
                def inspectionFwdNoticeList = InspectionFwdNotice.findAll("from InspectionFwdNotice where user=? AND noticeType != ? AND active = ? ", [session.userMaster, "FWD MS", true]);
                def surpriseInspectionFwdNoticeList = SurpriseInspectionFwdNotice.findAll("from SurpriseInspectionFwdNotice where user=? AND noticeType != ? AND active = ? ", [session.userMaster, "FWD MS", true]);

                /*def inspectionFwdNoticeList=InspectionFwdNotice.findAllByUserAndNoticeTypeNotEqual(session.userMaster,"FWD MS");
				  def surpriseInspectionFwdNoticeList=SurpriseInspectionFwdNotice.findAllByUserAndNoticeTypeNotEqual(session.userMaster,"FWD MS");
				  */
                /*for(int ii=0;ii<inspectionFwdNoticeList.size();ii++)
				  {
					  inspectionFwdNoticeList.get(ii).active=true;
				  }

				  for(int ii=0;ii<surpriseInspectionFwdNoticeList.size();ii++)
				  {
					  surpriseInspectionFwdNoticeList.get(ii).active=true;
				  }*/
                return ['inspectionFwdNoticeList': inspectionFwdNoticeList, 'noticeType': noticeType, surpriseInspectionFwdNoticeList: surpriseInspectionFwdNoticeList, roleHeader: roleHeader]
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

    def showInspectionNoteHistroy = {
        try {
            def inspectionNoteList = InspectionNoteHistory.findAll("from InspectionNoteHistory where typeOfInspection = ? AND application.id = ? order by id asc ", [params.typeOfInspection, (params.id).toLong()])
            println("inspectionNoteList..."+inspectionNoteList)
            return [inspectionNoteList: inspectionNoteList, id: params.id]
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

    def showPrevoiusInspectionNoteHistroy = {
        try {
            def previousInspectionNoteList = InspectionNoteHistory.findAll("from InspectionNoteHistory where typeOfInspection = ? AND application.id = ? AND applicationClosed = 'true' order by id asc ", [params.typeOfInspection, (params.id).toLong()])
            return [inspectionNoteList: previousInspectionNoteList]
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

    def showSurpriseInspectionNoteHistroy = {
        try {
            def inspectionNoteList = SurpriseInspectionNoteHistroy.findAll("from SurpriseInspectionNoteHistroy where industry.id = ? order by id asc ", [(params.id).toLong()])
            return [inspectionNoteList: inspectionNoteList]
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
	  //1st

	  def popInspectionFuelAdd = {
			def list = InspectionFuelDetails.findAll("From InspectionFuelDetails where application.id = ? ",[(params.appId).toLong()])
			return[list:list,appId:params.appId]

	  }

	  def popInspectionFuelView = {
			  def app = IndApplicationDetails.get((params.appId).toInteger())

				def materialdetails = InspectionFuelDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }


	  def popInspectionFuelEdit ={
				def app = IndApplicationDetails.get((params.appId).toInteger())

				def materialdetails = InspectionFuelDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def deleteInspectionFuel = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				if((params.delete).getClass().getName()== "java.lang.String"){
					def materialdetails = InspectionFuelDetails.get((params.delete).toInteger())
					materialdetails.delete()
				}else{
					if(params.delete)
					for(int i=0;i<(params.delete).size();i++){
						def materialdetails = InspectionFuelDetails.get((params.delete[i]).toInteger())
						materialdetails.delete()
					}
				}
				redirect(action:"popInspectionFuelEdit",params: [appId:params.appId])

			}

	  def saveInspectionFuelAdd = {

			  def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
			  InspectionFuelDetails inspectionFuelDetails = new InspectionFuelDetails()
			  inspectionFuelDetails.type = params.type
			  inspectionFuelDetails.quantity = params.quantity
			  inspectionFuelDetails.application = indApplicationDetailsInstance
			  if(!inspectionFuelDetails.hasErrors() && inspectionFuelDetails.save(flush:true))
			  	{
				  flash.message="Fuel Details Saved Sucessfully... "
			  	}
			  	else
			  	{
			  		if(inspectionFuelDetails.hasErrors()){
			  			inspectionFuelDetails.errors.allErrors.each {
			        	  println it
			          }
			  		}
			  	}

			  redirect(action:"popInspectionFuelAdd",params: [appId:params.appId])
	  }

	  //2nd
	  def popInspectionStackAdd = {
			def list = InspectionStackDetail.findAll("From InspectionStackDetail where application.id = ? ",[(params.appId).toLong()])
			return[list:list,appId:params.appId]
	  }

	  def popInspectionStackView = {
			  def app = IndApplicationDetails.get((params.appId).toInteger())

				def materialdetails = InspectionStackDetail.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }


	  def popInspectionStackEdit = {
				def app = IndApplicationDetails.get((params.appId).toInteger())

				def materialdetails = InspectionStackDetail.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def deleteInspectionStack = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				if((params.delete).getClass().getName()== "java.lang.String"){
					def materialdetails = InspectionStackDetail.get((params.delete).toInteger())
					materialdetails.delete()
				}else{
					if(params.delete)
					for(int i=0;i<(params.delete).size();i++){
						def materialdetails = InspectionStackDetail.get((params.delete[i]).toInteger())
						materialdetails.delete()
					}
				}
				redirect(action:"popInspectionStackEdit",params: [appId:params.appId])

			}

	  def savePopInspectionStackAdd ={

			  def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
			  InspectionStackDetail instanceDetails = new InspectionStackDetail()
			  instanceDetails.number = params.number
			  instanceDetails.attachedTo = params.attachedTo
			  instanceDetails.height = params.height
			  instanceDetails.portHole = params.portHole
			  instanceDetails.platform = params.platform
			  instanceDetails.ladder = params.ladder
			  instanceDetails.application = indApplicationDetailsInstance
			  if(!instanceDetails.hasErrors() && instanceDetails.save(flush:true))
			  	{
				  flash.message="Stack Details Saved Sucessfully... "
			  	}
			  	else
			  	{
			  		if(instanceDetails.hasErrors()){
			  			instanceDetails.errors.allErrors.each {
			        	  println it
			          }
			  		}
			  	}
		redirect(action:"popInspectionStackAdd",params: [appId:params.appId])
	  }

	  //3rd
	  def popInspectionLastMonitoringDateAdd = {
			def list = InspectionLastMonitoringDetails.findAll("From InspectionLastMonitoringDetails where application.id = ? ",[(params.appId).toLong()])
			return[list:list,appId:params.appId]
	  }

	  def popInspectionLastMonitoringDateView = {
			  def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionLastMonitoringDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }


	  def popInspectionLastMonitoringDateEdit = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionLastMonitoringDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def deleteInspectionLastMonitoringDate = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				if((params.delete).getClass().getName()== "java.lang.String"){
					def materialdetails = InspectionLastMonitoringDetails.get((params.delete).toInteger())
					materialdetails.delete()
				}else{
					if(params.delete)
					for(int i=0;i<(params.delete).size();i++){
						def materialdetails = InspectionLastMonitoringDetails.get((params.delete[i]).toInteger())
						materialdetails.delete()
					}
				}
				redirect(action:"popInspectionLastMonitoringDateEdit",params: [appId:params.appId])

			}

	  def saveInspectionLastMonitoringDateAdd = {
			  def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
			  InspectionLastMonitoringDetails instanceDetails = new InspectionLastMonitoringDetails()
			  instanceDetails.stackEmmission = params.stackEmmission
			  instanceDetails.aaq = params.aaq
			  instanceDetails.noise = params.noise
			  instanceDetails.application = indApplicationDetailsInstance
			  if(!instanceDetails.hasErrors() && instanceDetails.save(flush:true))
			  	{
				  flash.message="Last Monitoring Details Saved Sucessfully... "
			  	}
			  	else
			  	{
			  		if(instanceDetails.hasErrors()){
			  			instanceDetails.errors.allErrors.each {
			        	  println it
			          }
			  		}
			  	}
		redirect(action:"popInspectionLastMonitoringDateAdd",params: [appId:params.appId])
	  }


	  //4th
	  def popInspectionDGSetAdd = {
			def list = InspectionDGSetsDetails.findAll("From InspectionDGSetsDetails where application.id = ? ",[(params.appId).toLong()])
			return[list:list,appId:params.appId]
	  }

	  def popInspectionDGSetView = {
			  def app = IndApplicationDetails.get((params.appId).toInteger())
					def materialdetails = InspectionDGSetsDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }


	  def popInspectionDGSetEdit = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionDGSetsDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def deleteInspectionDGSet = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				if((params.delete).getClass().getName()== "java.lang.String"){
					def materialdetails = InspectionDGSetsDetails.get((params.delete).toInteger())
					materialdetails.delete()
				}else{
					if(params.delete)
					for(int i=0;i<(params.delete).size();i++){
						def materialdetails = InspectionDGSetsDetails.get((params.delete[i]).toInteger())
						materialdetails.delete()
					}
				}
				redirect(action:"popInspectionDGSetEdit",params: [appId:params.appId])

			}

	  def saveInspectionDGSetAdd = {
			  def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
			  InspectionDGSetsDetails instanceDetails = new InspectionDGSetsDetails()
			  instanceDetails.capacity = params.capacity
			  instanceDetails.housingStatus = params.housingStatus
			  instanceDetails.height = params.height
			  instanceDetails.application = indApplicationDetailsInstance
			  if(!instanceDetails.hasErrors() && instanceDetails.save(flush:true))
			  	{
				  flash.message="DG Set Details Saved Sucessfully... "
			  	}
			  	else
			  	{
			  		if(instanceDetails.hasErrors()){
			  			instanceDetails.errors.allErrors.each {
			        	  println it
			          }
			  		}
			  	}
		redirect(action:"popInspectionDGSetAdd",params: [appId:params.appId])
	  }

	  //5th
	  def popInspectionDetailOfSolidWasteAdd = {
			def list = InspectionSolidWasteDetails.findAll("From InspectionSolidWasteDetails where application.id = ? ",[(params.appId).toLong()])
			return[list:list,appId:params.appId]
	  }

	  def popInspectionDetailOfSolidWasteView = {
			  def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionSolidWasteDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }


	  def popInspectionDetailOfSolidWasteEdit = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionSolidWasteDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def deleteInspectionDetailOfSolidWaste = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				if((params.delete).getClass().getName()== "java.lang.String"){
					def materialdetails = InspectionSolidWasteDetails.get((params.delete).toInteger())
					materialdetails.delete()
				}else{
					if(params.delete)
					for(int i=0;i<(params.delete).size();i++){
						def materialdetails = InspectionSolidWasteDetails.get((params.delete[i]).toInteger())
						materialdetails.delete()
					}
				}
				redirect(action:"popInspectionDetailOfSolidWasteEdit",params: [appId:params.appId])

			}

	  def saveInspectionDetailOfSolidWasteAdd = {
			  def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
			  InspectionSolidWasteDetails instanceDetails = new InspectionSolidWasteDetails()
			  instanceDetails.source = params.source
			  instanceDetails.type = params.type
			  instanceDetails.quantity = params.quantity
			  instanceDetails.quantityRecycle = params.quantityRecycle
			  instanceDetails.application = indApplicationDetailsInstance
			  if(!instanceDetails.hasErrors() && instanceDetails.save(flush:true))
			  	{
				  flash.message="Solid Waste Details Saved Sucessfully... "
			  	}
			  	else
			  	{
			  		if(instanceDetails.hasErrors()){
			  			instanceDetails.errors.allErrors.each {
			        	  println it
			          }
			  		}
			  	}
		redirect(action:"popInspectionDetailOfSolidWasteAdd",params: [appId:params.appId])
	  }

	  //6th
	  def popInspectionDetailOfHazardousWasteAdd = {
			def list = InspectionHazardousWasteDetails.findAll("From InspectionHazardousWasteDetails where application.id = ? ",[(params.appId).toLong()])
			return[list:list,appId:params.appId]
		  }

	  def popInspectionDetailOfHazardousWasteView = {
			  def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionHazardousWasteDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def popInspectionDetailOfHazardousWasteEdit = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				def materialdetails = InspectionHazardousWasteDetails.findAllByApplication(app)
				return [appId:params.appId,list:materialdetails]
	  }

	  def deleteInspectionDetailOfHazardousWaste = {
				def app = IndApplicationDetails.get((params.appId).toInteger())
				if((params.delete).getClass().getName()== "java.lang.String"){
					def materialdetails = InspectionHazardousWasteDetails.get((params.delete).toInteger())
					materialdetails.delete()
				}else{
					if(params.delete)
					for(int i=0;i<(params.delete).size();i++){
						def materialdetails = InspectionHazardousWasteDetails.get((params.delete[i]).toInteger())
						materialdetails.delete()
					}
				}
				redirect(action:"popInspectionDetailOfHazardousWasteEdit",params: [appId:params.appId])

			}

	  def saveInspectionDetailOfHazardousWasteAdd = {
			  def indApplicationDetailsInstance = IndApplicationDetails.get((params.appId).toLong())
			  InspectionHazardousWasteDetails instanceDetails = new InspectionHazardousWasteDetails()
			  instanceDetails.source = params.source
			  instanceDetails.type = params.type
			  instanceDetails.quantity = params.quantity
			  instanceDetails.quantityRecycle = params.quantityRecycle
			  instanceDetails.application = indApplicationDetailsInstance
			  if(!instanceDetails.hasErrors() && instanceDetails.save(flush:true))
			  	{
				  flash.message="Solid Waste Details Saved Sucessfully... "
			  	}
			  	else
			  	{
			  		if(instanceDetails.hasErrors()){
			  			instanceDetails.errors.allErrors.each {
			        	  println it
			          }
			  		}
			  	}
		redirect(action:"popInspectionDetailOfSolidWasteAdd",params: [appId:params.appId])
	  }
	  */
    //////////////?????????start
    def regularInspectionCat = {
        try {
        	println("params.in regularInspectionCat..."+params)
        	def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
        	def roleHeader
            if(curentUserRole){
                roleHeader = curentUserRole.role.roleName
            }
            def newGroupList = GroupMaster.list()
            def grp = new ArrayList()
            for (int i = 0; i < newGroupList.size(); i++) {
            	if(!(newGroupList[i].groupName=="HO CONSENT") && !(newGroupList[i].groupName=="Industry")){
                    grp.add(newGroupList[i])
                }
            }
            println("grp.."+grp)
            println("roleHeader.."+roleHeader)
            return [grp: grp, roleHeader: roleHeader]
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

    def searchApplicationCatList = {
    		println("searchApplicationCatList..params."+params)
        def listOfApplication = []
        def listOfApplication1 = []
        def listOfApplicationG = []
        // Green category not required for regular inspection so hide this @05/09/2016 By Gajendra Kushwah
        def listOfApplicationR = []
        def listOfApplicationO = []

        def listOfApplicationR111 = []  // new 03/10/2016
        def listOfApplicationR1 = []  // new 03/10/2016
        def listOfApplicationRegularR  // new 03/10/2016
        def listOfInspectionNoteHistoryRed  // new 03/10/2016

        def listOfApplicationO111 = []  // new 03/10/2016
        def listOfApplicationO1 = []  // new 03/10/2016
        def listOfApplicationRegularO  // new 03/10/2016
        def listOfInspectionNoteHistoryOrange  // new 03/10/2016

        def listOfApplicationG111 = []  // new 21/10/2016
        def listOfApplicationG1 = []  // new 21/10/2016
        def listOfApplicationRegularG  // new 21/10/2016
        def listOfInspectionNoteHistoryGreen  // new 21/10/2016


        def listOfApplicationT = new ArrayList();
        def listOfApplicationT1 = new ArrayList();
        def regularInspectionRaised = []
        def regularInspectionRaisedList = [] // By Gajendra 29/08/2016
        boolean updateMonthOfAllApplication = false;
        Set set1;
        Iterator iterator1;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        if (params.category == 'None') {
            //regularInspectionRaised = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ? And r.group.id = ? And (r.category = 'RED' OR r.category = 'GREEN' OR r.category = 'ORANGE') order by r.inspectionClosedDate asc",[params.month,params.year,params.group.toLong()])
            regularInspectionRaised = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ? And r.group.id = ? And (r.category = 'RED' OR r.category = 'ORANGE' OR r.category = 'GREEN') order by r.inspectionClosedDate asc", [params.month, params.year, params.group.toLong()])
            println("regularInspectionRaised..111111."+regularInspectionRaised)
            // remove Green Category @05/09/2016
            if (regularInspectionRaised.size() != 0) {
                updateMonthOfAllApplication = true
            }
        } else {
            regularInspectionRaised = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ? And r.group.id = ? And r.category = ? order by r.inspectionClosedDate asc", [params.month, params.year, params.group.toLong(), params.category])
            println("regularInspectionRaised.22222222.."+regularInspectionRaised)
            if (regularInspectionRaised.size() != 0) {
                updateMonthOfAllApplication = true
            }

        }
        println("regularInspectionRaised..params."+regularInspectionRaised.size())
        //	If (regularInspectionRaised.size() != 0) As per From Above result // then else condition will execute every day in a month
        // Code written in last

        // If (regularInspectionRaised.size() == 0) As per From Above result // then following process will execute once in a month
        //1. Here We are starting our Search Engine (ie. Searching all application from starting to till date and criteria wise)
        //2. Checking unique application in our New Table (ie; RegularInspectionRaised)
        //3. Filtring Data As Per Month (Monthly Basis)
        //4. Inserting to New Table (ie; RegularInspectionRaised)
        //5. Updating Month & Year in New Table (ie; RegularInspectionRaised) hence month or year is changed by user.
        //6. Fetching New Updated Application List from New Table (ie; RegularInspectionRaised) and showing in search result.
        if (regularInspectionRaised.size() == 0) {
            Calendar now = Calendar.getInstance();
            println("now..."+now)
            int currentMonth = (now.get(Calendar.MONTH) + 1);
            int currentYear = now.get(Calendar.YEAR);
            int yearToUpdate
            int monthToUpdate
            if (currentYear >= (params.year).toInteger()) {
                yearToUpdate = ((params.year).toInteger() - currentYear)
            } else {
                yearToUpdate = ((params.year).toInteger() - currentYear)
            }

            if (currentMonth >= (params.month).toInteger()) {
                monthToUpdate = ((params.month).toInteger() - currentMonth)
            } else {
                monthToUpdate = ((params.month).toInteger() - currentMonth)

            }

            String currentDate = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + (1 + monthToUpdate)) + "/" + (now.get(Calendar.YEAR) + yearToUpdate);
            println("currentDate..."+currentDate)
            now = Calendar.getInstance();
            String oldDateG = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + (1 + monthToUpdate)) + "/" + (now.get(Calendar.YEAR) + yearToUpdate);

            String oldDateG1 = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + (1 + monthToUpdate)) + "/" + (now.get(Calendar.YEAR) + yearToUpdate);

            now.add(Calendar.MONTH, +(monthToUpdate));
            now.add(Calendar.YEAR, +yearToUpdate);

            String oldDate111 = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);

            if (params.category == "RED") {
                now.add(Calendar.MONTH, -1);
            } else if (params.category == "ORANGE") {
                now.add(Calendar.MONTH, -1);
            } else if (params.category == "GREEN") {
                now.add(Calendar.MONTH, -1);
            } else {
                now.add(Calendar.MONTH, -1);
            }

            String oldDate = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);
            println("oldDate..."+oldDate)
            String oldDateR = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);
          //  now.add(Calendar.MONTH, -2);
            String oldDateR5 = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);

          //  now.add(Calendar.MONTH, -2);
            String oldDateO = now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR);

		//	    def oldDate=params.start_date_value
		//		def currentDate=params.end_date_value

            java.sql.Date startDate
            java.sql.Date endDate
            java.sql.Date startDateR
            java.sql.Date startDateR5
            java.sql.Date startDateO
            java.sql.Date startDateG


            try {
                def sdfh = new SimpleDateFormat("dd/MM/yyyy");
                def x = sdfh.parse(oldDate); //Date
                def y = sdfh.parse(currentDate);
                def z = sdfh.parse(oldDateR);
                def w = sdfh.parse(oldDateO);
                def u = sdfh.parse(oldDateG);
                def v = sdfh.parse(oldDateR5);

                startDate = new java.sql.Date(x.getTime())
                endDate = new java.sql.Date(y.getTime())
                startDateR = new java.sql.Date(z.getTime())
                startDateO = new java.sql.Date(w.getTime())
                startDateG = new java.sql.Date(u.getTime())
                startDateR5 = new java.sql.Date(v.getTime())

            } catch (Exception e) {
                e.printStackTrace();
            }



            try {
            	println("startDate..."+startDate)
            	println("endDate..."+endDate)
                if (startDate <= endDate) {
                	println("here inside...")
                    if ((params.group == 'xyz') && (params.category == 'None') && (params.district == 'ALL')) {
                    	println("here inside.1111111111111111.")
                    listOfApplicationG111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds , IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'GREEN'   AND apds.approve='t' AND apds.application.id = indapds.id ")
                    println("listOfApplicationG111..."+listOfApplicationG111)
                    //for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016
                        for (int i = 0; i < listOfApplicationG111.size(); i++) {
                            hashmap.put(listOfApplicationG111[i].indUser.id, listOfApplicationG111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationG1.add(mentry1.getValue());

                        }
                        println("listOfApplicationG1..."+listOfApplicationG1)
                        // filter applications list code ends here...


                        for (int i = 0; i < listOfApplicationG1.size(); i++) {
                            listOfApplicationRegularG = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationG1[i]]);
                            println("listOfApplicationRegularG..."+listOfApplicationRegularG)
                            if (listOfApplicationRegularG) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryGreen = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationG1[i],startDateG]);
                                listOfInspectionNoteHistoryGreen = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationG1[i], startDateG])
                                println("listOfInspectionNoteHistoryGreen..."+listOfInspectionNoteHistoryGreen)
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryGreen) {
                                    listOfApplicationG.add(listOfApplicationG1[i])
                                }
                            } else {
                                listOfApplicationG.add(listOfApplicationG1[i])
                            }
                        }
                        //

                        // ########## For Green category Ends here...

                        //By Gajendra 03/10/2016 //listOfApplicationR = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'RED'   AND apds.approve='t'  AND apds.dateCreated<=? ",[startDateR])

                        listOfApplicationR111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds , IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'RED'   AND apds.approve='t' AND apds.application.id = indapds.id ")
                        println("listOfApplicationR111..."+listOfApplicationR111)
//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016


                        for (int i = 0; i < listOfApplicationR111.size(); i++) {
                            hashmap.put(listOfApplicationR111[i].indUser.id, listOfApplicationR111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationR1.add(mentry1.getValue());
                        }

                        // filter applications list code ends here...
                        println("listOfApplicationR1..."+listOfApplicationR1)

                        for (int i = 0; i < listOfApplicationR1.size(); i++) {
                            listOfApplicationRegularR = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationR1[i]]);

                            if (listOfApplicationRegularR) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                //      listOfInspectionNoteHistoryRed = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR1[i],startDateR]);
                                listOfInspectionNoteHistoryRed = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR1[i], startDateR]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryRed) {
                                    listOfApplicationR.add(listOfApplicationR1[i])
                                }
                            } else {
                                //listOfApplicationR = listOfApplicationR1
                                listOfApplicationR.add(listOfApplicationR1[i])
                            }
                        }
                        //

                        //By Gajendra 03/10/2016 //	listOfApplicationO = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'ORANGE'  AND apds.approve='t'  AND apds.dateCreated<=? ",[startDateO])
                        //
                        listOfApplicationO111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds , IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'ORANGE'  AND apds.approve='t' AND apds.application.id = indapds.id")

//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                        //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                        for (int i = 0; i < listOfApplicationO111.size(); i++) {
                            hashmap.put(listOfApplicationO111[i].indUser.id, listOfApplicationO111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationO1.add(mentry1.getValue());

                        }

                        // filter applications list code ends here...


                        for (int i = 0; i < listOfApplicationO1.size(); i++) {
                            listOfApplicationRegularO = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationO1[i]]);
                            if (listOfApplicationRegularO) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                //    listOfInspectionNoteHistoryOrange = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationO1[i],startDateO]);
                                listOfInspectionNoteHistoryOrange = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationO1[i], startDateO]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryOrange) {
                                    listOfApplicationO.add(listOfApplicationO1[i])
                                }
                            } else {
                                // listOfApplicationO = listOfApplicationO1
                                listOfApplicationO.add(listOfApplicationO1[i])
                            }
                        }

                        //

                        int sizeR = listOfApplicationR.size()
                        int sizeRyear = sizeR
                        int sizeRmonth = sizeRyear % 12

                        for (int i = 0; i < listOfApplicationG.size(); i++) {

                            listOfApplication.add(listOfApplicationG[i])

                        }
//						for(int i=0; i<listOfApplicationR.size(); i++){
//
//							listOfApplication.add(listOfApplicationR[i])
//
//							}

                        for (int i = 0; i < listOfApplicationR.size(); i++) {
                            def indType = listOfApplicationR[i].indUser.industryType.id
                            if (indType == 27799 || indType == 27797 || indType == 27795 || indType == 27793 || indType == 27791 || indType == 27789 || indType == 27787 || indType == 27785 || indType == 27783 || indType == 27766 || indType == 27764 || indType == 27781 || indType == 27778 || indType == 27776 || indType == 27773 || indType == 27771 || indType == 28023) {
                                listOfApplication.add(listOfApplicationR[i])

                            } else {
                                //By Gajendra 03/10/2016 //def appProcessInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve='t' and abc.dateCreated<=?",[listOfApplicationR[i],startDateR5])
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // def appProcessInst = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR[i],startDateR5])
                                def appProcessInst = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR[i], startDateR5])
                                // bhanu code ends
                                if (appProcessInst) {
                                    listOfApplication.add(listOfApplicationR[i])
                                }
                            }
                        }


                        for (int i = 0; i < sizeRmonth; i++) {

                            listOfApplication.add(listOfApplicationO[i])

                        }

                        for (int i = 0; i < listOfApplication.size(); i++) {

                            def inspInst = InspectionFwdNotice.find("from InspectionFwdNotice ifn where ifn.regularInspectionAssigned='t' AND ifn.typeOfInspection='REGULAR_INSPECTION' AND ifn.application=? ", [listOfApplication[i]])

                            if (inspInst) {


                            } else {

                                listOfApplicationT.add(listOfApplication[i])

                            }
                        }


                    } else if ((params.group != 'xyz') && (params.category == 'None') && (params.district == 'ALL')) {
                    	println("here inside..222222222222.")
//						listOfApplicationT = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.completionStatus = 'completed' AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) order by ipd.indUser.category.name desc",[startDate,endDate,params.group.toLong()])

                        // By Gajendra 21/10/2016	//listOfApplicationG = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'GREEN'  AND apds.approve='t'  AND apds.dateCreated<=?  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[startDateG,params.group.toLong()])

                        //// Green Category

                        listOfApplicationG111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'GREEN'  AND apds.approve='t' AND apds.application.id = indapds.id  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.group.toLong()])
                        println("here inside..222222222222.listOfApplicationG111"+listOfApplicationG111)
//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                        for (int i = 0; i < listOfApplicationG111.size(); i++) {
                            hashmap.put(listOfApplicationG111[i].indUser.id, listOfApplicationG111[i]);
                        }
                    	println("here inside..222222222222.hashmap"+hashmap)
                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationG1.add(mentry1.getValue());

                        }
                        println("here inside..222222222222.listOfApplicationG1"+listOfApplicationG1)
                        // filter applications list code ends here...


                        for (int i = 0; i < listOfApplicationG1.size(); i++) {
                            listOfApplicationRegularG = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationG1[i]]);
                            
                            if (listOfApplicationRegularG) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryGreen = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationG1[i],startDateG]);
                                listOfInspectionNoteHistoryGreen = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationG1[i], startDateG]);
                                println("here inside..222222222222.listOfInspectionNoteHistoryGreen"+listOfInspectionNoteHistoryGreen)
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryGreen) {
                                    listOfApplicationG.add(listOfApplicationG1[i])
                                }
                            } else {
                                //listOfApplicationR = listOfApplicationR1
                                listOfApplicationG.add(listOfApplicationG1[i])
                            }
                        }
                        println("here inside..222222222222.listOfApplicationG"+listOfApplicationG)
                        ////
                        //By Gajendra 03/10/2016	//listOfApplicationR = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'RED'  AND apds.approve='t'  AND apds.dateCreated<=?  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[startDateR,params.group.toLong()])

                        //
                        listOfApplicationR111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'RED'  AND apds.approve='t' AND apds.application.id = indapds.id  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.group.toLong()])
                       println("here inside..222222222222.listOfApplicationR111"+listOfApplicationR111)
//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016


                        for (int i = 0; i < listOfApplicationR111.size(); i++) {
                            hashmap.put(listOfApplicationR111[i].indUser.id, listOfApplicationR111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationR1.add(mentry1.getValue());

                        }
                        // filter applications list code ends here...

                        println("here inside..222222222222.listOfApplicationR1"+listOfApplicationR1)
                        for (int i = 0; i < listOfApplicationR1.size(); i++) {
                            listOfApplicationRegularR = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationR1[i]]);
                            if (listOfApplicationRegularR) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryRed = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR1[i],startDateR]);
                                listOfInspectionNoteHistoryRed = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR1[i], startDateR]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryRed) {
                                    listOfApplicationR.add(listOfApplicationR1[i])
                                }
                            } else {
                                //listOfApplicationR = listOfApplicationR1
                                listOfApplicationR.add(listOfApplicationR1[i])
                            }
                        }
                        println("here inside..222222222222.listOfApplicationR"+listOfApplicationR)
                        //
                        //By Gajendra 03/10/2016//listOfApplicationO = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'ORANGE'   AND apds.approve='t'  AND apds.dateCreated<=?  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[startDateO,params.group.toLong()])

//
                        listOfApplicationO111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'ORANGE'   AND apds.approve='t' AND apds.application.id = indapds.id  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.group.toLong()])
   println("here inside..222222222222.listOfApplicationO111"+listOfApplicationO111)
//				 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                        //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                        for (int i = 0; i < listOfApplicationO111.size(); i++) {
                            hashmap.put(listOfApplicationO111[i].indUser.id, listOfApplicationO111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationO1.add(mentry1.getValue());

                        }
                       // filter applications list code ends here...

println("here inside..222222222222.listOfApplicationO1"+listOfApplicationO1)
                        for (int i = 0; i < listOfApplicationO1.size(); i++) {
                            listOfApplicationRegularO = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationO1[i]]);
                           if (listOfApplicationRegularO) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryOrange = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where  inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationO1[i],startDateO]);
                                listOfInspectionNoteHistoryOrange = InspectionNoteHistory.find("from InspectionNoteHistory inh where  inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationO1[i], startDateO]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryOrange) {
                                    listOfApplicationO.add(listOfApplicationO1[i])
                                }
                            } else {
                                // listOfApplicationO = listOfApplicationO1
                                listOfApplicationO.add(listOfApplicationO1[i])
                            }
                        }
                        //


                        for (int i = 0; i < listOfApplicationG.size(); i++) {

                            listOfApplication.add(listOfApplicationG[i])

                        }
//							for(int i=0; i<listOfApplicationR.size(); i++){
//
//								listOfApplication.add(listOfApplicationR[i])
//
//								}
					for (int i = 0; i < listOfApplicationR.size(); i++) {
                            def indType = listOfApplicationR[i].indUser.industryType.id
                            if (indType == 27799 || indType == 27797 || indType == 27795 || indType == 27793 || indType == 27791 || indType == 27789 || indType == 27787 || indType == 27785 || indType == 27783 || indType == 27766 || indType == 27764 || indType == 27781 || indType == 27778 || indType == 27776 || indType == 27773 || indType == 27771 || indType == 28023) {
                                listOfApplication.add(listOfApplicationR[i])

                            } else {
                                //By Gajendra 03/10/2016//def appProcessInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve='t' and abc.dateCreated<=?",[listOfApplicationR[i],startDateR5])
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // def appProcessInst = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR[i],startDateR5])
                                def appProcessInst = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR[i], startDateR5])
                                // bhanu code ends

                                if (appProcessInst) {

                                    listOfApplication.add(listOfApplicationR[i])
                                }
                            }


                        }



                        for (int i = 0; i < listOfApplicationO.size(); i++) {

                            listOfApplication.add(listOfApplicationO[i])

                        }

                        for (int i = 0; i < listOfApplication.size(); i++) {

                            def inspInst = InspectionFwdNotice.find("from InspectionFwdNotice ifn where ifn.regularInspectionAssigned='t' AND ifn.typeOfInspection='REGULAR_INSPECTION' AND ifn.application=? ", [listOfApplication[i]])

                            if (inspInst) {


                            } else {

                                listOfApplicationT.add(listOfApplication[i])

                            }
                        }


                    } else if ((params.group != 'xyz') && (params.category == 'None') && (params.district != 'ALL')) {
                    	println("here inside.333333333333333..")
//						listOfApplicationT = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.completionStatus = 'completed' AND ipd.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) order by ipd.indUser.category.name desc",[startDate,endDate,(params.district).toLong(),params.group.toLong()])

                        // By Gajendra 21/10/2016	//listOfApplicationG = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'GREEN'  AND apds.approve='t'  AND apds.dateCreated<=? AND apds.application.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[startDateG,(params.district).toLong(),params.group.toLong()])

                        //
                        listOfApplicationG111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'GREEN'   AND apds.approve='t' AND apds.application.indUser.district.id = ? AND apds.application.id = indapds.id AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [(params.district).toLong(), params.group.toLong()])

//					  for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016


                        for (int i = 0; i < listOfApplicationG111.size(); i++) {
                            hashmap.put(listOfApplicationG111[i].indUser.id, listOfApplicationG111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationG1.add(mentry1.getValue());

                        }

                        // filter applications list code ends here...

                        for (int i = 0; i < listOfApplicationG1.size(); i++) {
                            listOfApplicationRegularG = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationG1[i]]);
                            if (listOfApplicationRegularG) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryGreen = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationG1[i],startDateG]);
                                listOfInspectionNoteHistoryGreen = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationG1[i], startDateG]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryGreen) {
                                    listOfApplicationG.add(listOfApplicationG1[i])
                                }
                            } else {
                                //listOfApplicationR = listOfApplicationR1
                                listOfApplicationG.add(listOfApplicationG1[i])
                            }
                        }
                        //

                        //By Gajendra 03/10/2016//listOfApplicationR = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'RED'   AND apds.approve='t'  AND apds.dateCreated<=? AND apds.application.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[startDateR,(params.district).toLong(),params.group.toLong()])

                        //
                        listOfApplicationR111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'RED'   AND apds.approve='t' AND apds.application.indUser.district.id = ? AND apds.application.id = indapds.id AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [(params.district).toLong(), params.group.toLong()])

//					  for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                        //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                        for (int i = 0; i < listOfApplicationR111.size(); i++) {
                            hashmap.put(listOfApplicationR111[i].indUser.id, listOfApplicationR111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationR1.add(mentry1.getValue());

                        }

                        // filter applications list code ends here...

                        for (int i = 0; i < listOfApplicationR1.size(); i++) {
                            listOfApplicationRegularR = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationR1[i]]);
                            if (listOfApplicationRegularR) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryRed = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR1[i],startDateR]);
                                listOfInspectionNoteHistoryRed = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR1[i], startDateR]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryRed) {
                                    listOfApplicationR.add(listOfApplicationR1[i])
                                }
                            } else {
                                //listOfApplicationR = listOfApplicationR1
                                listOfApplicationR.add(listOfApplicationR1[i])
                            }
                        }
                        //

                        //By Gajendra 03/10/2016  //listOfApplicationO = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'ORANGE'  AND apds.approve='t'  AND apds.dateCreated<=? AND apds.application.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[startDateO,(params.district).toLong(),params.group.toLong()])

//
                        listOfApplicationO111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = 'ORANGE'  AND apds.approve='t' AND apds.application.indUser.district.id = ? AND apds.application.id = indapds.id AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [(params.district).toLong(), params.group.toLong()])
                        println("listOfApplicationO111..3333333333..."+listOfApplicationO111)
//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                        //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                        for (int i = 0; i < listOfApplicationO111.size(); i++) {
                            hashmap.put(listOfApplicationO111[i].indUser.id, listOfApplicationO111[i]);
                        }

                        set1 = hashmap.entrySet();
                        iterator1 = set1.iterator();
                        while (iterator1.hasNext()) {
                            Map.Entry mentry1 = (Map.Entry) iterator1.next();
                            // System.out.print("Value is: "+mentry1.getValue());
                            listOfApplicationO1.add(mentry1.getValue());

                        }

                        // filter applications list code ends here...
 println("listOfApplicationO1..3333333333..."+listOfApplicationO1)
                        for (int i = 0; i < listOfApplicationO1.size(); i++) {
                            listOfApplicationRegularO = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationO1[i]]);
                            if (listOfApplicationRegularO) {
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // listOfInspectionNoteHistoryOrange = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationO1[i],startDateO]);
                                listOfInspectionNoteHistoryOrange = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationO1[i], startDateO]);
                                // bhanu code ends
                                if (listOfInspectionNoteHistoryOrange) {
                                    listOfApplicationO.add(listOfApplicationO1[i])
                                }
                            } else {
                                // listOfApplicationO = listOfApplicationO1
                                listOfApplicationO.add(listOfApplicationO1[i])
                            }
                        }

                        println("listOfApplicationO..3333333333..."+listOfApplicationO)

                        println("listOfApplicationG..3333333333..."+listOfApplicationG)

                        for (int i = 0; i < listOfApplicationG.size(); i++) {

                            listOfApplication.add(listOfApplicationG[i])

                        }
//							for(int i=0; i<listOfApplicationR.size(); i++){
//
//								listOfApplication.add(listOfApplicationR[i])
//
//								}

println("listOfApplicationR..3333333333..."+listOfApplicationR)
                        for (int i = 0; i < listOfApplicationR.size(); i++) {
                            def indType = listOfApplicationR[i].indUser.industryType.id
                            if (indType == 27799 || indType == 27797 || indType == 27795 || indType == 27793 || indType == 27791 || indType == 27789 || indType == 27787 || indType == 27785 || indType == 27783 || indType == 27766 || indType == 27764 || indType == 27781 || indType == 27778 || indType == 27776 || indType == 27773 || indType == 27771 || indType == 28023) {
                                listOfApplication.add(listOfApplicationR[i])

                            } else {
                                //By Gajendra 03/10/2016//def appProcessInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve='t' and abc.dateCreated<=?",[listOfApplicationR[i],startDateR5])
                                // bhanu code commented; date: 21-06-2017
                                // below line is commented and replaced by another line
                                // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                // def appProcessInst = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR[i],startDateR5])
                                def appProcessInst = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR[i], startDateR5])

                                if (appProcessInst) {

                                    listOfApplication.add(listOfApplicationR[i])
                                }
                            }


                        }
                        println("listOfApplication..3333333333555555555..."+listOfApplication)

                        for (int i = 0; i < listOfApplicationO.size(); i++) {

                            listOfApplication.add(listOfApplicationO[i])

                        }
                        println("listOfApplication..3333333333..."+listOfApplication)
                        for (int i = 0; i < listOfApplication.size(); i++) {

                            def inspInst = InspectionFwdNotice.find("from InspectionFwdNotice ifn where ifn.regularInspectionAssigned='t' AND ifn.typeOfInspection='REGULAR_INSPECTION' AND ifn.application=? ", [listOfApplication[i]])
                            println("inspInst..3333333333..."+inspInst)
                            if (inspInst) {


                            } else {

                                listOfApplicationT.add(listOfApplication[i])

                            }
                        }

                        println("listOfApplicationT..3333333333..."+listOfApplicationT)
                    } else if ((params.group != 'xyz') && (params.category != 'None') && (params.district == 'ALL')) {
                    	println("here inside.4444444444444444444444444..")
//						listOfApplicationT = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id   AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed' AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? ))) order by ipd.indUser.category.name desc",[startDate,endDate,params.category,params.group.toLong()])

                        if (params.category == 'GREEN') {
                            //By Gajendra03/10/2016//listOfApplication = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t'  AND apds.dateCreated<=?  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[params.category,startDate,params.group.toLong()])
                            //
                            listOfApplicationG111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds , IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t' AND apds.application.id = indapds.id AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.category, params.group.toLong()])

//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016


                            for (int i = 0; i < listOfApplicationG111.size(); i++) {
                                hashmap.put(listOfApplicationG111[i].indUser.id, listOfApplicationG111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationG1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationG1.size(); i++) {
                                listOfApplicationRegularG = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationG1[i]]);

                                if (listOfApplicationRegularG) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryGreen = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationG1[i],startDateG]);
                                    listOfInspectionNoteHistoryGreen = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationG1[i], startDateG]);
                                    // bhanu code ends

                                    if (listOfInspectionNoteHistoryGreen) {
                                        listOfApplication.add(listOfApplicationG1[i])
                                    }
                                } else {
//                            	listOfApplication = listOfApplicationR1
                                    listOfApplicationG.add(listOfApplicationG1[i])

                                }
                            }
                            //
                            for (int i = 0; i < listOfApplicationG.size(); i++) {

                                listOfApplication.add(listOfApplicationG[i])

                            }

                        } else if (params.category == 'ORANGE') {
                            listOfApplicationO111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds , IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t' AND apds.application.id = indapds.id AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.category, params.group.toLong()])

                            //	 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            for (int i = 0; i < listOfApplicationO111.size(); i++) {
                                hashmap.put(listOfApplicationO111[i].indUser.id, listOfApplicationO111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationO1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationO1.size(); i++) {
                                listOfApplicationRegularO = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationO1[i]]);

                                if (listOfApplicationRegularO) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryOrange = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationO1[i],startDateO]);
                                    listOfInspectionNoteHistoryOrange = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationO1[i], startDateO]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryOrange) {
                                        listOfApplicationO.add(listOfApplicationO1[i])
                                    }
                                } else {
//		                            	listOfApplication = listOfApplicationR1
                                    listOfApplicationO.add(listOfApplicationO1[i])
                                }
                            }
                            //
                            for (int i = 0; i < listOfApplicationO.size(); i++) {

                                listOfApplication.add(listOfApplicationO[i])

                            }

                        } else {
                            //By Gajendra 03/10/2016 //listOfApplicationR = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t'  AND apds.dateCreated<=?  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[params.category,startDate,params.group.toLong()])

                            //
                            listOfApplicationR111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds , IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t' AND apds.application.id = indapds.id AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.category, params.group.toLong()])

                            //By Umashankar for getting unique industry for inspection //listOfApplicationR111 = RecordCertificate.executeQuery("select Max(rc.applicationId) as applicationId from RecordCertificate rc, IndApplicationDetails iad1, ApplicationProcessingDetails apds , IndCatMaster icm where apds.application.id = iad1.id AND apds.approve = 't' AND  rc.applicationId = apds.application group by rc.applicationId,iad1.indUser,iad1.applicationType,icm.name having iad1.indUser IN(select distinct iad.indUser from IndApplicationDetails iad) AND iad1.applicationType = 'CTO' AND icm.name = ? AND rc.applicationId IN (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[params.category,params.group.toLong()])

                            // for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationR111.size(); i++) {
                                hashmap.put(listOfApplicationR111[i].indUser.id, listOfApplicationR111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationR1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...

                            for (int i = 0; i < listOfApplicationR1.size(); i++) {
                                listOfApplicationRegularR = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationR1[i]]);
                                if (listOfApplicationRegularR) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryRed = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR1[i],startDateR]);
                                    listOfInspectionNoteHistoryRed = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR1[i], startDateR]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryRed) {
                                        listOfApplicationR.add(listOfApplicationR1[i])
                                    }
                                } else {
                                    //listOfApplicationR = listOfApplicationR1
                                    listOfApplicationR.add(listOfApplicationR1[i])
                                }


                            }

                            //


                            for (int i = 0; i < listOfApplicationR.size(); i++) {

                                def indType = listOfApplicationR[i].indUser.industryType.id

                                if (indType == 27799 || indType == 27797 || indType == 27795 || indType == 27793 || indType == 27791 || indType == 27789 || indType == 27787 || indType == 27785 || indType == 27783 || indType == 27766 || indType == 27764 || indType == 27781 || indType == 27778 || indType == 27776 || indType == 27773 || indType == 27771 || indType == 28023) {
                                    listOfApplication.add(listOfApplicationR[i])

                                } else {
                                    //By Gajendra 03/10/2016//def appProcessInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve='t' and abc.dateCreated<=?",[listOfApplicationR[i],startDateR5])
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // def appProcessInst = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR[i],startDateR5])
                                    def appProcessInst = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR[i], startDateR5])
                                    // bhanu code ends
                                    if (appProcessInst) {

                                        listOfApplication.add(listOfApplicationR[i])
                                    }
                                }


                            }

                        }


                        for (int i = 0; i < listOfApplication.size(); i++) {

                            def inspInst = InspectionFwdNotice.find("from InspectionFwdNotice ifn where ifn.regularInspectionAssigned='t' AND ifn.typeOfInspection='REGULAR_INSPECTION' AND ifn.application=? ", [listOfApplication[i]])

                            if (inspInst) {


                            } else {

                                listOfApplicationT.add(listOfApplication[i])

                            }
                        }


                    } else if ((params.group != 'xyz') && (params.category != 'None') && (params.district != 'ALL')) {
                    	println("here inside.555555555555555555555555..")
                    	if (params.category == 'GREEN') {
                            //By Gajendra 03/10/2016//listOfApplication = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?   AND apds.approve='t'  AND apds.dateCreated<=? AND apds.application.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[params.category,startDate,(params.district).toLong(),params.group.toLong()])

                            //
                            listOfApplicationG111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?   AND apds.approve='t' AND apds.application.indUser.district.id = ? AND apds.application.id = indapds.id  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.category, (params.district).toLong(), params.group.toLong()])

//					  for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationG111.size(); i++) {
                                hashmap.put(listOfApplicationG111[i].indUser.id, listOfApplicationG111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationG1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationG1.size(); i++) {
                                listOfApplicationRegularG = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationG1[i]]);
                                if (listOfApplicationRegularG) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryGreen = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationG1[i],startDateG]);
                                    listOfInspectionNoteHistoryGreen = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationG1[i], startDateG]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryGreen) {
                                        listOfApplicationG.add(listOfApplicationG1[i])
                                    }
                                } else {
                                    listOfApplicationG.add(listOfApplicationG1[i])
                                }
                            }
                            //
                            for (int i = 0; i < listOfApplicationG.size(); i++) {

                                listOfApplication.add(listOfApplicationG[i])

                            }


                        } else if (params.category == 'ORANGE') {
                            //By Gajendra 03/10/2016//listOfApplication = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?   AND apds.approve='t'  AND apds.dateCreated<=? AND apds.application.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[params.category,startDate,(params.district).toLong(),params.group.toLong()])

                            //
                            listOfApplicationO111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?   AND apds.approve='t' AND apds.application.indUser.district.id = ? AND apds.application.id = indapds.id  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.category, (params.district).toLong(), params.group.toLong()])

//							  for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationO111.size(); i++) {
                                hashmap.put(listOfApplicationO111[i].indUser.id, listOfApplicationO111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationO1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationO1.size(); i++) {
                                listOfApplicationRegularO = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationO1[i]]);
                                if (listOfApplicationRegularO) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryOrange = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationO1[i],startDateO]);
                                    listOfInspectionNoteHistoryOrange = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated<=? desc", [listOfApplicationO1[i], startDateO]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryOrange) {
                                        listOfApplicationO.add(listOfApplicationO1[i])
                                    }
                                } else {
                                    listOfApplicationO.add(listOfApplicationO1[i])
                                }
                            }
                            //
                            for (int i = 0; i < listOfApplicationO.size(); i++) {

                                listOfApplication.add(listOfApplicationO[i])

                            }


                        } else {
                            //By Gajendra 03/10/2016//listOfApplicationR = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?   AND apds.approve='t'  AND apds.dateCreated<=? AND apds.application.indUser.district.id = ? AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ",[params.category,startDate,(params.district).toLong(),params.group.toLong()])

                            //
                            listOfApplicationR111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?   AND apds.approve='t' AND apds.application.indUser.district.id = ? AND apds.application.id = indapds.id  AND rc.applicationId IN  (Select apd.application.id from ApplicationPendingDetails apd where apd.role.id IN ( select id from RoleMaster RM WHERE RM.group.id IN (SELECT gm.id from GroupMaster gm where gm.id = ? )) ) ", [params.category, (params.district).toLong(), params.group.toLong()])
                            println("listOfApplicationR111..."+listOfApplicationR111)
//							 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationR111.size(); i++) {
                                hashmap.put(listOfApplicationR111[i].indUser.id, listOfApplicationR111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationR1.add(mentry1.getValue());

                            }
                            println("listOfApplicationR1..."+listOfApplicationR1)
                            // filter applications list code ends here...

                            for (int i = 0; i < listOfApplicationR1.size(); i++) {
                            	
                            	 println("inside loop...")
                            	 listOfApplicationRegularR = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationR1[i]]);
                                println("listOfApplicationRegularR..."+listOfApplicationRegularR)
                                if (listOfApplicationRegularR) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryRed = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR1[i],startDateR]);
                                    listOfInspectionNoteHistoryRed = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR1[i], startDateR]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryRed) {
                                        listOfApplicationR.add(listOfApplicationR1[i])
                                    }
                                } else {
                                    //listOfApplicationR = listOfApplicationR1
                                    listOfApplicationR.add(listOfApplicationR1[i])
                                }
                            }
                            //

                            println("listOfApplicationR..."+listOfApplicationR)
                            
                            for (int i = 0; i < listOfApplicationR.size(); i++) {
                                def indType = listOfApplicationR[i].indUser.industryType.id
                                if (indType == 27799 || indType == 27797 || indType == 27795 || indType == 27793 || indType == 27791 || indType == 27789 || indType == 27787 || indType == 27785 || indType == 27783 || indType == 27766 || indType == 27764 || indType == 27781 || indType == 27778 || indType == 27776 || indType == 27773 || indType == 27771 || indType == 28023) {
                                    listOfApplication.add(listOfApplicationR[i])

                                } else {
                                    //def appProcessInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve='t' and abc.dateCreated<=?",[listOfApplicationR[i],startDateR5])
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // def appProcessInst = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR[i],startDateR5])
                                    def appProcessInst = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR[i], startDateR5])
                                    // bhanu code ends
                                    println("appProcessInst..."+appProcessInst)
                                    if (appProcessInst) {

                                        listOfApplication.add(listOfApplicationR[i])
                                    }
                                }


                            }
                            println("listOfApplication..."+listOfApplication)
                        }

                        for (int i = 0; i < listOfApplication.size(); i++) {

                            def inspInst = InspectionFwdNotice.find("from InspectionFwdNotice ifn where ifn.regularInspectionAssigned='t' AND ifn.typeOfInspection='REGULAR_INSPECTION' AND ifn.application=? ", [listOfApplication[i]])

                            if (inspInst) {

                            } else {

                                listOfApplicationT.add(listOfApplication[i])

                            }
                        }

                        println("listOfApplicationT..."+listOfApplicationT)
                    } else if ((params.group == 'xyz') && (params.category != 'None') && (params.district == 'ALL')) {
                    	println("here inside.66666666666666666666666666..")
//						listOfApplicationT = RecordCertificate.executeQuery("select rc.applicationId from RecordCertificate rc JOIN rc.applicationId ipd  Where ipd.id = rc.applicationId.id  AND rc.dateCreated >= ? AND rc.dateCreated <= ?  AND ipd.indUser.category.name = ? AND ipd.completionStatus = 'completed'  order by ipd.indUser.category.name desc",[startDate,endDate,params.category])

                        if (params.category == 'GREEN') {
                            //By Gajendra 03/10/2016	//listOfApplication = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t'  AND apds.dateCreated<=? ",[params.category,startDate])

                            //
                            listOfApplicationG111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t' AND apds.application.id = indapds.id ", [params.category])

//						 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationG111.size(); i++) {
                                hashmap.put(listOfApplicationG111[i].indUser.id, listOfApplicationG111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationG1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationG1.size(); i++) {
                                listOfApplicationRegularG = RegularInspectionRaised.findAll("select from RegularInspectionRaised rir where rir.application=?", [listOfApplicationG1[i]]);
                                if (listOfApplicationRegularG) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryGreen = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationG1[i],startDateG]);
                                    listOfInspectionNoteHistoryGreen = InspectionNoteHistory.find("from InspectionNoteHistory inh where application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationG1[i], startDateG]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryGreen) {
                                        listOfApplicationG.add(listOfApplicationG1[i])
                                    }
                                } else {
                                    //listOfApplication = listOfApplicationR1
                                    listOfApplicationG.add(listOfApplicationG1[i])
                                }
                            }
                            //
                            for (int i = 0; i < listOfApplicationG.size(); i++) {

                                listOfApplication.add(listOfApplicationG[i])

                            }
                        } else if (params.category == 'ORANGE') {
                            //By Gajendra 03/10/2016	//listOfApplication = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t'  AND apds.dateCreated<=? ",[params.category,startDate])

                            //
                            listOfApplicationO111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t' AND apds.application.id = indapds.id ", [params.category])

//								 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationO111.size(); i++) {
                                hashmap.put(listOfApplicationO111[i].indUser.id, listOfApplicationO111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationO1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationO1.size(); i++) {
                                listOfApplicationRegularO = RegularInspectionRaised.findAll("select from RegularInspectionRaised rir where rir.application=?", [listOfApplicationO1[i]]);
                                if (listOfApplicationRegularO) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryOrange = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationO1[i],startDateO]);
                                    listOfInspectionNoteHistoryOrange = InspectionNoteHistory.find("from InspectionNoteHistory inh where application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationO1[i], startDateO]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryOrange) {
                                        listOfApplicationO.add(listOfApplicationO1[i])
                                    }
                                } else {
                                    //listOfApplication = listOfApplicationR1
                                    listOfApplicationO.add(listOfApplicationO1[i])
                                }
                            }
                            //
                            for (int i = 0; i < listOfApplicationO.size(); i++) {

                                listOfApplication.add(listOfApplicationO[i])

                            }
                        } else {
                            //By GAjendra 03/10/2016//listOfApplicationR = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t'  AND apds.dateCreated<=? ",[params.category,startDate])

                            //
                            listOfApplicationR111 = RecordCertificate.executeQuery("select distinct rc.applicationId from RecordCertificate rc , ApplicationProcessingDetails apds, IndApplicationDetails indapds  Where rc.applicationId.id = apds.application.id  AND apds.application.indUser.category.name = ?  AND apds.approve='t' AND apds.application.id = indapds.id", [params.category])

//							 for filter applications list according to industry id coz  industry not allowed to inspection twice or more if they have 2 or more consent granted 20/10/2016

                            //	HashMap<Integer ,Integer> hashmap = new HashMap<Integer ,Integer>();
                            for (int i = 0; i < listOfApplicationR111.size(); i++) {
                                hashmap.put(listOfApplicationR111[i].indUser.id, listOfApplicationR111[i]);
                            }

                            set1 = hashmap.entrySet();
                            iterator1 = set1.iterator();
                            while (iterator1.hasNext()) {
                                Map.Entry mentry1 = (Map.Entry) iterator1.next();
                                // System.out.print("Value is: "+mentry1.getValue());
                                listOfApplicationR1.add(mentry1.getValue());

                            }

                            // filter applications list code ends here...


                            for (int i = 0; i < listOfApplicationR1.size(); i++) {
                                listOfApplicationRegularR = RegularInspectionRaised.findAll("from RegularInspectionRaised rir where rir.application=?", [listOfApplicationR1[i]]);
                                if (listOfApplicationRegularR) {
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // listOfInspectionNoteHistoryRed = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR1[i],startDate]);
                                    listOfInspectionNoteHistoryRed = InspectionNoteHistory.find("from InspectionNoteHistory inh where inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR1[i], startDate]);
                                    // bhanu code ends
                                    if (listOfInspectionNoteHistoryRed) {
                                        listOfApplicationR.add(listOfApplicationR1[i])
                                    }
                                } else {
                                    //listOfApplicationR = listOfApplicationR1
                                    listOfApplicationR.add(listOfApplicationR1[i])
                                }
                            }
                            //

                            //##### this code was for total list and also using in show searching result so no need to comment
                            //##### but now we required list according to monthly so we have calculating below same thing...

                            for (int i = 0; i < listOfApplicationR.size(); i++) {
                                def indType = listOfApplicationR[i].indUser.industryType.id
                                if (indType == 27799 || indType == 27797 || indType == 27795 || indType == 27793 || indType == 27791 || indType == 27789 || indType == 27787 || indType == 27785 || indType == 27783 || indType == 27766 || indType == 27764 || indType == 27781 || indType == 27778 || indType == 27776 || indType == 27773 || indType == 27771 || indType == 28023) {
                                    listOfApplication.add(listOfApplicationR[i])

                                } else {
                                    //def appProcessInst = ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=? and abc.approve='t' and abc.dateCreated<=?",[listOfApplicationR[i],startDateR5])
                                    // bhanu code commented; date: 21-06-2017
                                    // below line is commented and replaced by another line
                                    // this line is commented because before "add prev inspection" only one inspection is raised on a application but now multiple inspections can be added
                                    // def appProcessInst = InspectionNoteHistory.findAll("from InspectionNoteHistory inh where  inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? ",[listOfApplicationR[i],startDateR5])
                                    def appProcessInst = InspectionNoteHistory.find("from InspectionNoteHistory inh where  inh.application=? and inh.applicationClosed='true' and inh.dateCreated<=? order by inh.dateCreated desc", [listOfApplicationR[i], startDateR5])
                                    // bhanu code ends
                                    if (appProcessInst) {

                                        listOfApplication.add(listOfApplicationR[i])
                                    }
                                }


                            }

                        }
                        for (int i = 0; i < listOfApplication.size(); i++) {

                            def inspInst = InspectionFwdNotice.find("from InspectionFwdNotice ifn where ifn.regularInspectionAssigned='t' AND ifn.typeOfInspection='REGULAR_INSPECTION' AND ifn.application=? ", [listOfApplication[i]])

                            if (inspInst) {


                            } else {

                                listOfApplicationT.add(listOfApplication[i])

                            }
                        }


                    }
                    if (listOfApplication.size() == 0) {
                        flash.message = "No application found with this combination"
                    }
                } else {
                    flash.message = "End Date should be Greater than Starting Date"
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            def filteredListOfApplicationRED = []
            def filteredListOfApplicationGREEN = []
            def filteredListOfApplicationORANGE = []


            for (int i = 0; i < listOfApplicationR.size(); i++) {
                def checkR = RegularInspectionRaised.find("from RegularInspectionRaised r Where r.application.id = ?", [listOfApplicationR[i].id]);
                //Commented by Gajendra coz according to me its not required 22/10/2016 //if(checkR == null){
                filteredListOfApplicationRED.add(listOfApplicationR[i].id)
                //}
            }


            for (int i = 0; i < listOfApplicationG.size(); i++) {
                def checkG = RegularInspectionRaised.find("from RegularInspectionRaised r Where r.application.id = ?", [listOfApplicationG[i].id])
                //Commented by Gajendra coz according to me its not required 22/10/2016 //	if(checkG == null){
                filteredListOfApplicationGREEN.add(IndApplicationDetails.get(listOfApplicationG[i].id))
                //}
            }


            for (int i = 0; i < listOfApplicationO.size(); i++) {
                def checkO = RegularInspectionRaised.find("from RegularInspectionRaised r Where r.application.id = ?", [listOfApplicationO[i].id])
                //Commented by Gajendra coz according to me its not required 22/10/2016 //	if(checkO == null){
                filteredListOfApplicationORANGE.add(IndApplicationDetails.get(listOfApplicationO[i].id))
                //	}
            }

            /////////////////////////////////////////////////////////////////////////////////////////
            ///////////////////// CALCULATION FOR MONTLY APPLICATION TO BE SELECTED /////////////////
            /////////for monthly report /////


            if (params.category == 'RED' || params.category == 'None') {

                def redList = []
                def redList1 = []
                for (int k = 0; k < filteredListOfApplicationRED.size(); k++) {

                    def newRedList = IndApplicationDetails.find("from IndApplicationDetails r Where r.indUser.industryType.id IN ('27799','27797','27795','27793','27791','27789','27787','27785','27783','27766','27764','27781','27778','27776','27773','27771','28023') And r.id = ? ", [filteredListOfApplicationRED[k]])
                    def newRedList1 = IndApplicationDetails.find("from IndApplicationDetails r Where r.indUser.industryType.id  NOT IN ('27799','27797','27795','27793','27791','27789','27787','27785','27783','27766','27764','27781','27778','27776','27773','27771','28023') And r.id = ?  ", [filteredListOfApplicationRED[k]])
                    if (newRedList) {
                        redList.add(newRedList)
                    }
                    if (newRedList1) {
                        redList1.add(newRedList1)
                    }
                    //def redList = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where (r.industryTypeId = '27799' OR r.industryTypeId =  '27797' OR r.industryTypeId = '27795' OR r.industryTypeId =  '27793' OR r.industryTypeId = '27791' OR r.industryTypeId = '27789' OR r.industryTypeId = '27787' OR r.industryTypeId =  '27785' OR r.industryTypeId =  '27783' OR r.industryTypeId =  '27766' OR r.industryTypeId =  '27764' OR r.industryTypeId = '27781' OR r.industryTypeId = '27778' OR r.industryTypeId = '27776' OR r.industryTypeId = '27773' OR r.industryTypeId = '27771' OR r.industryTypeId = '28023') And r.category = 'RED' And r.month = ? And r.year = ? And r.application.id = ? ",[params.month,params.year,filteredListOfApplicationRED[k]])
                }

                def redListMonthly
                def numbertest
                if (redList) // 17 other RED so 3 years
                {
                    int redSize = redList.size()
                    if (redSize < 36) {
                        redListMonthly = redSize % 36
                    } else {
                        numbertest = redSize / 36

                        def num = (int) numbertest
                        def result = numbertest - num
                        if (result < 0.5) {
                            numbertest = (int) numbertest
                        } else {
                            numbertest = (int) numbertest + 1
                        }


                        redListMonthly = numbertest // Final Red list of 17 industry

                    }

                    for (int i = 0; i < redListMonthly; i++) {
                        listOfApplicationT1.add(redList[i])

                    }

                }



                def redListMonthly1
                def numbertest1
                if (redList1) //   RED so 5 years
                {
                    int redSize = redList1.size()


                    if (redSize < 60) {
                        redListMonthly1 = redSize % 60
                    } else {
                        numbertest1 = redSize / 60

                        def num = (int) numbertest1
                        def result = numbertest1 - num
                        if (result < 0.5) {
                            numbertest1 = (int) numbertest1
                        } else {
                            numbertest1 = (int) numbertest1 + 1
                        }


                        redListMonthly1 = numbertest1 // Final Red list of 17 others industry

                    }

                    for (int i = 0; i < redListMonthly1; i++) {
                        listOfApplicationT1.add(redList1[i])

                    }
                }
            }


            if (params.category == 'GREEN' || params.category == 'None') {

                def greenList = []
                for (int k = 0; k < filteredListOfApplicationGREEN.size(); k++) {
                    def newGreenList = IndApplicationDetails.get(filteredListOfApplicationGREEN[k].id)
                    if (newGreenList) {
                        greenList.add(newGreenList)
                    }

                }

                def greenListMonthly
                def numbertest2
                if (greenList) {
                    int Size = greenList.size()


                    if (Size < 180) {
                        greenListMonthly = Size % 180
                    } else {
                        numbertest2 = Size / 180

                        def num = (int) numbertest2
                        def result = numbertest2 - num
                        if (result < 0.5) {
                            numbertest2 = (int) numbertest2
                        } else {
                            numbertest2 = (int) numbertest2 + 1
                        }


                        greenListMonthly = numbertest2 // Final Green list  industry

                    }

                    for (int i = 0; i < greenListMonthly; i++) {
                        listOfApplicationT1.add(greenList[i])

                    }
                    ;
                }
            }

            if (params.category == 'ORANGE' || params.category == 'None') {
                def orangeList = []
                for (int k = 0; k < filteredListOfApplicationORANGE.size(); k++) {
                    //def orangeList = IndApplicationDetails.findAll("From IndApplicationDetails r Where r.id = ? ",[filteredListOfApplicationORANGE[k]])
                    def newOrangeList = IndApplicationDetails.get(filteredListOfApplicationORANGE[k].id)
                    if (newOrangeList) {
                        orangeList.add(newOrangeList)
                    }

                }
                def orangeListMonthly
                def numbertest3
                if (orangeList) {
                    int Size = orangeList.size()


                    if (Size < 84) {
                        orangeListMonthly = Size % 84
                    } else {
                        numbertest3 = Size / 84

                        def num = (int) numbertest3
                        def result = numbertest3 - num
                        if (result < 0.5) {
                            numbertest3 = (int) numbertest3
                        } else {
                            numbertest3 = (int) numbertest3 + 1
                        }


                        orangeListMonthly = numbertest3 // Final ORANGE list  industry

                    }

                    for (int i = 0; i < orangeListMonthly; i++) {
                        listOfApplicationT1.add(orangeList[i])
                        //// Final list of industry Per Month To Be displayed in Search Result
                    }
                }
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////// FINAL LIST OF APPLICATION FOR CURRENT MONTH TO BE DISPLAYED IN SEARCH RESULT /////////////////
            //////////////// NOW WE ARE INSERTING IN DATABASE FOR CUURENT MONTH (Ie; RegularInspectionRaised Table )////////////////////////////


            def finalApplicationList = listOfApplicationT1
//          bhanu code start; date: 18-10-2017
//          added to remove duplicate application no. in finalApplicationList
         HashSet<Integer> hashSet = new HashSet<Integer>()
         for(int i = 0; i < finalApplicationList.size(); i++){
         hashSet.add(finalApplicationList[i])
         }
         finalApplicationList.clear()
         for(Integer i: hashSet){
         finalApplicationList.add(i)
         }
//          bhanu code ends
            //////////////
            def assignedFwdRoles = new ArrayList()
            def roRoleMasterInstance

            def app
            //def pendingInstance
            def checkInspectionCriteriaExist
            //if(finalApplicationList!=null || finalApplicationList!="" )
            if (!(finalApplicationList.isEmpty())) {
                app = ApplicationPendingDetails.findByApplication(finalApplicationList[0])
               
                // bhanu temporary code start; date: 12-06-2017
                println("finalApplicationList: 1111111111111" + finalApplicationList)
				println("app: " + app)
				println("app.role.group.id: " + app.role.group.id)
                // bhanu temporary code ends
                
                	println("group.id: " + app.role.group.id)
                	roRoleMasterInstance = RoleMaster.findAll("from RoleMaster where group.id=" + app.role.group.id + " and typeoff='RO' and canDoInspection = true order by forwardCount ")
                println("roRoleMasterInstance: " + roRoleMasterInstance)
                /** bhanu code ends **/

            }
           
            def newIndInstance
            def currentApplicationId
            def appProcessDetails
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);

            if (roRoleMasterInstance) {

                for (int i = 0; i < finalApplicationList.size(); i = i + roRoleMasterInstance.size()) {
                    int abc = i;
                    for (int j = 0; j < roRoleMasterInstance.size(); j++) {
                        if ((abc + j) < finalApplicationList.size()) {

                            currentApplicationId = finalApplicationList[abc + j]
                            // added for add in ApplicationProcessingDetails table  30/06/2016

                            appProcessDetails = new ApplicationProcessingDetails()
                            appProcessDetails.application = currentApplicationId
                            appProcessDetails.dateCreated = new Date();
                            appProcessDetails.lastUpdated = new Date();
                            // bhanu commented code start; date: 01-08-2017
                            // appProcessDetails.role = curentUserRole.role  //current role
                            // bhanu code ends

                            // bhanu code start; date: 01-08-2017
                            // previous line is commented and replaced by this code because when admin who do not have role
                            // search inspection draw then currentUserRole.role result in exception
                            if(curentUserRole){
                                appProcessDetails.role = curentUserRole.role
                            }else{
                                appProcessDetails.role = roRoleMasterInstance[j]
                            }
                            // bhanu code ends
                            appProcessDetails.roleFwd = roRoleMasterInstance[j] // forwarding role
                            appProcessDetails.officer = (session.userMaster.id).toString()
                            //Application pending with now updated  officer id
                            appProcessDetails.officerFwd = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance[j]).primaryEmployee.id).toString()
                            //forwarding to officer id
                            appProcessDetails.fileNote = ""
                            appProcessDetails.clarification = false
                            appProcessDetails.clarificationNote = ""
                            appProcessDetails.inspection = true
                            appProcessDetails.inspectionNote = ""
                            appProcessDetails.inspectionClose = false
                            appProcessDetails.inspectionCloseNote = ""
                            appProcessDetails.approve
                            appProcessDetails.approveNote = ""
                            appProcessDetails.reject
                            appProcessDetails.rejectNote = ""
                            appProcessDetails.attachedFile = false
                            appProcessDetails.clarificationAttachedFile = false
                            appProcessDetails.clarificationReplyAttachedFile = false
                            appProcessDetails.inspectionCloseAttachedFile = false
                            appProcessDetails.returned = false
                            appProcessDetails.returnNote = ""
                            appProcessDetails.inspectionAttachedFile = false
                            //fields not in jharkhand
                            appProcessDetails.approvalStatus = ""
                           
                            

                            if (!appProcessDetails.hasErrors()) { // && appProcessDetails.save(flush:true)

                                //
                                //if(checkPreExistInstance == null){
                                //def newIndInstance = IndApplicationDetails.get(finalApplicationList[abc+j])
                                newIndInstance = finalApplicationList[abc + j]
                                RegularInspectionRaised regularInspectionRaisedInstance = new RegularInspectionRaised()
                                regularInspectionRaisedInstance.application = newIndInstance
                                regularInspectionRaisedInstance.group = roRoleMasterInstance[j].group
                                regularInspectionRaisedInstance.inspectionRaised = false  // before false
                                regularInspectionRaisedInstance.month = params.month
                                regularInspectionRaisedInstance.year = params.year
                                regularInspectionRaisedInstance.inspectionClosedDate = new Date();
                                regularInspectionRaisedInstance.industryTypeId = newIndInstance.indUser.industryType.id
                                regularInspectionRaisedInstance.category = newIndInstance.indUser.category.name
                                regularInspectionRaisedInstance.officerName = roRoleMasterInstance[j]
                                // assigning officer name internally
                                regularInspectionRaisedInstance.officerId = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance[j]).primaryEmployee.id).toString()
                                // assigning officer userId internally
                                regularInspectionRaisedInstance.save(flush: true);
                                //pendingInstance.pendingWith = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance[j]).primaryEmployee.id)
                                //pendingInstance.role=roRoleMasterInstance[j]
                                //pendingInstance.save(flush:true);
                                InspectionFwdNotice inspectionFwdNoticeIns = new InspectionFwdNotice();
                                inspectionFwdNoticeIns.noticeType = "FWD USER"
                                inspectionFwdNoticeIns.role = roRoleMasterInstance[j] // user assigning role
                                inspectionFwdNoticeIns.user = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance[j]).primaryEmployee.id)
                                inspectionFwdNoticeIns.noOfDays = "2";
                                inspectionFwdNoticeIns.inspectionNote = ""
                                inspectionFwdNoticeIns.dateCreated = new Date();
                                inspectionFwdNoticeIns.active = true
                                inspectionFwdNoticeIns.application = newIndInstance
                                inspectionFwdNoticeIns.typeOfInspection = "REGULAR_INSPECTION"
                                inspectionFwdNoticeIns.regularInspectionAssigned = true // before false
                                //insert reason to select this officer
                                //reasonToSelectOfficer36200
                                inspectionFwdNoticeIns.reasonToChooseOfficer = "No Reason "
                                inspectionFwdNoticeIns.save(flush: true)

                              
                              
                                //	if(!inspectionFwdNoticeIns.hasErrors() && inspectionFwdNoticeIns.save(flush:true))
                                //{
                                //def  roleMasterInsNew = RoleMaster.get(id)
                                //roleMasterInsNew.forwardCount+=1;
                                //roleMasterInsNew.save(flush:true)

                                /** *****************************************************/
                                //	 creating entry in Inspection Note Histroy for forwarding notice ***By Gajendra

                                //  def officerFwd=RoleProfileAssignment.findByRole(roRoleMasterInstance[j]); //forward officer userId

                                // def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ",[session.userMaster.id]);
                                def inspectionNoteHistoryInstance = InspectionNoteHistory.find("from InspectionNoteHistory r Where r.application = ?", [finalApplicationList[abc + j]])

                                //if(inspectionNoteHistoryInstance == null){
                                InspectionNoteHistory forwardInspectionNoteHistroy = new InspectionNoteHistory();
                                forwardInspectionNoteHistroy.application = newIndInstance
                                //forwardInspectionNoteHistroy.inspectionCloseNote = ""
                                forwardInspectionNoteHistroy.inspectionDescriptionNote = ""
                                forwardInspectionNoteHistroy.clarificationNote = ""
                                forwardInspectionNoteHistroy.clarificationDays = ""
                                forwardInspectionNoteHistroy.noticeType = ""
                                forwardInspectionNoteHistroy.fileNote = ""
                                forwardInspectionNoteHistroy.approve = false
                                forwardInspectionNoteHistroy.approveNote = ""
                                forwardInspectionNoteHistroy.approvalStatus = ""
                                forwardInspectionNoteHistroy.reject = false
                                forwardInspectionNoteHistroy.rejectNote = ""
                                forwardInspectionNoteHistroy.revoke = false
                                forwardInspectionNoteHistroy.revokeNote = ""
                                forwardInspectionNoteHistroy.closeInd = false
                                forwardInspectionNoteHistroy.closeIndNote = ""
                                forwardInspectionNoteHistroy.revokeCloseInd = false
                                forwardInspectionNoteHistroy.revokeCloseIndNote = ""
                                forwardInspectionNoteHistroy.clarification = false
                                forwardInspectionNoteHistroy.clarificationAttachedFile = false
                                forwardInspectionNoteHistroy.clarificationReplyAttachedFile = false
                                // bhanu code commented; date: 01-08-2017
                                // forwardInspectionNoteHistroy.role = curentUserRole.role  //current role
                                // bhanu code ends

                                // bhanu code start; date: 01-08-2017
                                // previous line is commented and replaced by this line because when admin who do not have role
                                // search inspection draw then currentUserRole.role result in exception
                                if(curentUserRole){
                                    forwardInspectionNoteHistroy.role = curentUserRole.role
                                }else{
                                    forwardInspectionNoteHistroy.role = roRoleMasterInstance[j]
                                }
                                // bhanu code ends
                                forwardInspectionNoteHistroy.roleFwd = roRoleMasterInstance[j] // forwarding role
                                forwardInspectionNoteHistroy.officer = (session.userMaster.id).toString()
                                //Application pending with now updated  officer id
                                forwardInspectionNoteHistroy.officerFwd = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance[j]).primaryEmployee.id).toString()
                                //forwarding to officer id
                                forwardInspectionNoteHistroy.inspectionNote = "Inspection Notice sent to " + roRoleMasterInstance[j] + " for  application. "
                                forwardInspectionNoteHistroy.dateCreated = new Date();
                                forwardInspectionNoteHistroy.lastUpdated = new Date();
                                forwardInspectionNoteHistroy.applicationClosed = false
                                forwardInspectionNoteHistroy.typeOfInspection = "REGULAR_INSPECTION"
                                //(params.typeOfInspection).trim()
                                // bhanu code start; date: 15-06-2017
                                // this column is added to manage file attached in regular inspection -> add previous inspection tab
                                forwardInspectionNoteHistroy.previousReportAttachedFile = false
                                // bhanu code ends
                                if (forwardInspectionNoteHistroy.save(flush: true)) {
                                } else {

                                    forwardInspectionNoteHistroy.errors.each {
                                        println it
                                    }


                                }
                                //}
                                //	flash.message="Inspection Forwarded Sucessfully... "

                                // ends here..

                                //}	// insForward wala
                            } // ApplicationProcessingDetails { save ends here

                        } // if check ends here..

                        else {
                            break;
                        }
                    } // IF ends here..2270

                }    // inner for loop of j closed here

            } // check for roRoleMasterInstance	 close here...
            
            ///////////////////////////////////////////////////////////////////////////////////
            ///////////// DATA TO BE SENT IN SEARCH RESULT ///////////////////////////

            regularInspectionRaisedList = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ? And r.group.id = ? order by r.inspectionClosedDate asc", [params.month, params.year, params.group.toLong()])
            listOfApplicationT = regularInspectionRaisedList;

            if (params.category != 'None') {
                regularInspectionRaisedList = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ?  And r.category = ? And r.group.id = ? order by r.inspectionClosedDate asc", [params.month, params.year, params.category, params.group.toLong()])
                listOfApplicationT = regularInspectionRaisedList;
            } else {
                regularInspectionRaisedList = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ? And r.group.id = ? order by r.inspectionClosedDate asc", [params.month, params.year, params.group.toLong()])
                listOfApplicationT = regularInspectionRaisedList;
            }


        } else {
            //this case will excecute every day if month in databse is same as per user want to search
            if (params.category != 'None') {
                regularInspectionRaisedList = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ?  And r.category = ? And r.group.id = ? order by r.inspectionClosedDate asc", [params.month, params.year, params.category, params.group.toLong()])
                //listOfApplicationT = regularInspectionRaisedList;
            } else {
                regularInspectionRaisedList = RegularInspectionRaised.findAll("From RegularInspectionRaised r Where r.month = ? And r.year = ? And r.group.id = ? order by r.inspectionClosedDate asc", [params.month, params.year, params.group.toLong()])
                //listOfApplicationT = regularInspectionRaisedList;
            }


            listOfApplicationT = regularInspectionRaisedList;

        }

       
        def grp = GroupMaster.findAll()
        def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
        // bhanu commented code start; date: 01-08-2017
        // def roleHeader = curentUserRole.role.roleName
        // bhanu commented code ends

        // bhanu code start; date: 01-08-2017
        def roleHeader
        if(curentUserRole){
            roleHeader = curentUserRole.role.roleName
        }
        // bhanu code ends


        render(view: 'regularInspectionCat', model: [grp: grp, listOfApplication: listOfApplicationT, roleHeader: roleHeader, month1: params.month, year1: params.year])

    }

    def ajaxGetIndustryTypeList = {
        try {

            def typeList = []
            if (params.categoryName != null && params.categoryName != 'xyz') {
                typeList = IndCatMaster.executeQuery("select cat.industryType from IndCatMaster cat inner join cat.industryType type where type.id = cat.industryType.id and  cat.name = ? ", [params.categoryName])
            }
            /*def sublist = []
						typeList.each {
						  sublist.add(it[1])
						}*/
            render typeList as JSON
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

    def processRegularInspection = {
        try {
        	println("params.in processRegularInspection..."+params)
       
            def roleMasterIns = RoleMaster.find("from RoleMaster where id=?", [(params.forward).toLong()])
            println("params.in roleMasterIns..."+roleMasterIns)
            def curentUserRole = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ", [session.userMaster.id]);
        	println("params.in curentUserRole..."+curentUserRole)
            def redirectBack = false

            def indApp = IndApplicationDetails.get(params.appId.toLong())
            println("params.in indApp..."+indApp)
            def appPending = ApplicationPendingDetails.find("from ApplicationPendingDetails ap where ap.application = ?", [indApp])
            //working inspection close by akhi007
            //if((params.inspectionClose).equals("yes")){
            //if((params.closeInspectionStatus).equals("true")){
            if (indApp != null) {
//									close all notices

                def fwdNoticeUpdate = InspectionFwdNotice.find("from InspectionFwdNotice where application = ? AND typeOfInspection='REGULAR_INSPECTION' ", [indApp])
                if (fwdNoticeUpdate) {

                    fwdNoticeUpdate.role = (RoleProfileAssignment.findByRole(roleMasterIns)).role
                    fwdNoticeUpdate.user = UserMaster.get(RoleProfileAssignment.findByRole(roleMasterIns).primaryEmployee.id)
                    // for close inspection
                    /*if((params.inspectionClose).equals("yes")){
								    			fwdNoticeUpdate.regularInspectionAssigned = false
								    		}*/

                    if ((params.approve).equals("yes")) {
                        fwdNoticeUpdate.regularInspectionAssigned = false
                    }
                    if ((params.reject).equals("yes")) {
                        fwdNoticeUpdate.regularInspectionAssigned = false
                    }

                    //
                    if (!fwdNoticeUpdate.hasErrors() && fwdNoticeUpdate.save(flush: true)) {
                    } else {
                        fwdNoticeUpdate.errors.each {
                            println it
                        }

                    }

                    // for inspectionNoteHistory

                    InspectionNoteHistory forwardInspectionNoteHistroy = new InspectionNoteHistory();
                    forwardInspectionNoteHistroy.application = indApp
                    forwardInspectionNoteHistroy.role = curentUserRole.role  //current role
//
                    //	attaching Regular Clarification report

                    if ((params.clarification).equals("yes")) {

                        forwardInspectionNoteHistroy.clarificationNote = params.clarificationNote
                        forwardInspectionNoteHistroy.clarificationDays = params.clarificationDays
                        forwardInspectionNoteHistroy.clarification = true
                        forwardInspectionNoteHistroy.noticeType = params.noticeType
                        forwardInspectionNoteHistroy.fileNote = ""
                        def noteHistiryFile1 = new ApplicationFileRecord()
                        def f6 = request.getFile('attachRegularClarificationReport')
                        MultipartFile multi = request.getFile('attachRegularClarificationReport')
                        if (!f6.empty) {

                            forwardInspectionNoteHistroy.clarificationAttachedFile = true
                            def applicationFileRecordInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachRegularClarificationReport' order by afr.id desc", [indApp], [max: 1])

                            if (applicationFileRecordInstance) {
                                noteHistiryFile1.version = applicationFileRecordInstance[0].version + 1
                            }

                            noteHistiryFile1.size = multi.getSize() / 1024
                            if (noteHistiryFile1.size <= 6000) {
                                noteHistiryFile1.name = multi.getOriginalFilename()
                                noteHistiryFile1.data = multi.getBytes()
                                noteHistiryFile1.extension = extractExtension(multi)
                                noteHistiryFile1.description = "Application attached Regular Clarification Report"
                                if (session.userMaster) {
                                    noteHistiryFile1.createdBy = session.userMaster
                                    noteHistiryFile1.updatedBy = session.userMaster
                                } else {
                                    noteHistiryFile1.createdBy = session.indUser
                                    noteHistiryFile1.updatedBy = session.indUser
                                }
                                noteHistiryFile1.typeOfFile = "attachRegularClarificationReport"
                                noteHistiryFile1.indApplication = indApp
                                 if (noteHistiryFile1.save()) {
                                	 println("here in print")
                                } else {
                                	noteHistiryFile1.errors.each {
                                        println it
                                    }


                                    redirect(action: 'inspectionProcessing', params: ["id": indApp.id])
                                    return;
                                }
                            } else {
                                //indApp.inspection = false
                                //if(indApp.save(flush:true)){printn("indApp saved...")}
                                flash.message = "Attachment File Size is More Then 5 Mb"
                                redirectBack = true
                            }
                        }
                        indApp.clarification = true
                        if (indApp.save(flush: true)) {

                        }
                    } else {

                        forwardInspectionNoteHistroy.clarificationNote = ""
                        //forwardInspectionNoteHistroy.inspectionCloseNote = ""
                        forwardInspectionNoteHistroy.clarification = false
                        forwardInspectionNoteHistroy.noticeType = ""
                        forwardInspectionNoteHistroy.fileNote = ""
                        forwardInspectionNoteHistroy.clarificationDays = ""
                    }
                    //close upload

                    if ((params.revoke).equals("yes")) {
                        forwardInspectionNoteHistroy.revoke = true
                        forwardInspectionNoteHistroy.revokeNote = params.revokeNote
                        appPending.applicationStatus = "rejected" // Application status to be rejected after revoked
                        appPending.save(flush: true)
                    } else {
                        forwardInspectionNoteHistroy.revoke = false
                        forwardInspectionNoteHistroy.revokeNote = ""

                    }

                    if ((params.closeInd).equals("yes")) {
                        forwardInspectionNoteHistroy.closeInd = true
                        forwardInspectionNoteHistroy.closeIndNote = params.closeIndNote
                    } else {
                        forwardInspectionNoteHistroy.closeInd = false
                        forwardInspectionNoteHistroy.closeIndNote = ""

                    }
                    //
                    if ((params.revokeCloseInd).equals("yes")) {
                        forwardInspectionNoteHistroy.revokeCloseInd = true
                        forwardInspectionNoteHistroy.revokeCloseIndNote = params.revokeCloseIndNote
                        appPending.applicationStatus = "rejected" // Application status to be rejected after revoked
                        appPending.save(flush: true)
                    } else {
                        forwardInspectionNoteHistroy.revokeCloseInd = false
                        forwardInspectionNoteHistroy.revokeCloseIndNote = ""

                    }
                    //  Code Starts here for Close after Approved/Refusal..
                    forwardInspectionNoteHistroy.applicationClosed = false
                    if ((params.approve).equals("yes")) {

                        //def indApp = applicationPending.application
                        def refusal = InspectionNoteHistory.find("from InspectionNoteHistory apd where apd.application=? and apd.approvalStatus <> '' order by apd.id desc", [indApp])
                        if (refusal) {
                            if (refusal.approvalStatus == 'Refused') {
                                flash.message = "Sorry this Regular Inspection is refused by higher authority you cannot close this as approved"
                                redirect(action: 'inspectionProcessing', params: ["id": indApp.id])
                                return;

                            } else if (indApp.clarification) {
                                flash.message = "Sorry can not Approve Clarification is Raised on this application"
                                redirect(action: 'inspectionProcessing', params: ["id": indApp.id])
                                return;
                            }

                            /*else if(!certRecord){
													  		flash.message = "Please generate certificate first."
													redirectBack = true
													}*/
                            else {

                                forwardInspectionNoteHistroy.approve = true
                                forwardInspectionNoteHistroy.approveNote = params.approveNote
                                forwardInspectionNoteHistroy.applicationClosed = true

                            }
                        } else if (indApp.clarification) {
                            flash.message = "Sorry can not Approve Clarification is Raised on this application"
                            redirect(action: 'inspectionProcessing', params: ["id": indApp.id])
                            return;
                        }

                        // code for close application only after Approved By Gajendra
                        /*else if(!refusal){  // now commented for live coz 100% not complete
												  	    	flash.message = "Sorry Regular Inspection cannot be closed without Approved."
												  	        redirect(action:'inspectionProcessing',params:["id":indApp.id])
														    return;
												  	            }*/

                        else {
                            forwardInspectionNoteHistroy.approve = true
                            forwardInspectionNoteHistroy.approveNote = params.approveNote
                            forwardInspectionNoteHistroy.applicationClosed = true
                        }

                    } else {
                        forwardInspectionNoteHistroy.approve = false
                        forwardInspectionNoteHistroy.approveNote = ""
                        //forwardInspectionNoteHistroy.inspectionCloseNote = ""


                    }
                    if ((params.reject).equals("yes")) {

                        //def certRecord = RecordCertificate.find("from RecordCertificate where applicationId=? and showCauseDays=''",[indApp])
                        def approval = InspectionNoteHistory.find("from InspectionNoteHistory apd where apd.application=? and apd.approvalStatus <> '' order by apd.id desc", [indApp])

                        if (approval) {
                            if (approval.approvalStatus == 'Approved') {
                                flash.message = "Sorry this Regular Inspection approved by higher authority you cannot close as refused"
                                redirect(action: 'inspectionProcessing', params: ["id": indApp.id])
                                return;

                            } else {
                                forwardInspectionNoteHistroy.reject = true
                                forwardInspectionNoteHistroy.rejectNote = params.rejectNote
                                forwardInspectionNoteHistroy.applicationClosed = true
                            }
                        }

                        // By Gajendra
                        else if (!approval) {
                            flash.message = "Sorry this Regular Inspection cannot be closed without Refused."
                            redirect(action: 'inspectionProcessing', params: ["id": indApp.id])
                            return;
                        }

                        //
                        else {
                            forwardInspectionNoteHistroy.reject = true
                            forwardInspectionNoteHistroy.rejectNote = params.rejectNote
                            forwardInspectionNoteHistroy.applicationClosed = true
                        }

                    } else {
                        forwardInspectionNoteHistroy.reject = false
                        forwardInspectionNoteHistroy.rejectNote = ""

                    }

                    // Code Ends here for Close after Approved/Refusal..
                    if (params.inspectionNote) {
                        forwardInspectionNoteHistroy.inspectionDescriptionNote = params.inspectionNote
                    } else {
                        forwardInspectionNoteHistroy.inspectionDescriptionNote = ""
                    }

                    forwardInspectionNoteHistroy.clarificationReplyAttachedFile = false
                    forwardInspectionNoteHistroy.roleFwd = (RoleProfileAssignment.findByRole(roleMasterIns)).role
                    // forwarding role
                    forwardInspectionNoteHistroy.officer = (session.userMaster.id).toString()
                    //Application pending with now updated  officer id
                    forwardInspectionNoteHistroy.officerFwd = UserMaster.get(RoleProfileAssignment.findByRole(roleMasterIns).primaryEmployee.id).toString()
                    //forwarding to officer id
                    forwardInspectionNoteHistroy.inspectionNote = "Inspection Notice sent to " + roleMasterIns + " for  application. "
                    forwardInspectionNoteHistroy.dateCreated = new Date();
                    forwardInspectionNoteHistroy.lastUpdated = new Date();
                    if (params.approvalStatus) {
                        forwardInspectionNoteHistroy.approvalStatus = params.approvalStatus
                        // for Approve/Refused Status
                    } else {
                        forwardInspectionNoteHistroy.approvalStatus = ""
                    }
                    //forwardInspectionNoteHistroy.applicationClosed = false
                    forwardInspectionNoteHistroy.typeOfInspection = "REGULAR_INSPECTION"
                    //(params.typeOfInspection).trim()
                    // bhanu code start; date: 15-06-2017
                    // this column is added to manage file attached in regular inspection -> add previous inspection tab
                    forwardInspectionNoteHistroy.previousReportAttachedFile = false
                    // bhanu code ends
                    
                    if (!forwardInspectionNoteHistroy.hasErrors() && forwardInspectionNoteHistroy.save(flush: true)) {
                    	def appFileRecord=ApplicationFileRecord.findAll("from ApplicationFileRecord abc where abc.indApplication=? and abc.typeOfFile='regularInspectionReportOtherDocs' and abc.appProcessId=''",[indApp])
              	       println("appFileRecord...."+appFileRecord)
              	       println("forwardInspectionNoteHistroy.id....."+forwardInspectionNoteHistroy.id)
                         if(appFileRecord){
                         	 println("insideeeeeeeeeeee....")
                         for(int i1=0;i1<appFileRecord.size();i1++){
                 		appFileRecord[i1].appProcessId=(forwardInspectionNoteHistroy.id).toString() ;
                 		appFileRecord[i1].save(flush:true)
                 	   }
              	    }
                    } else {
                        if (forwardInspectionNoteHistroy.hasErrors()) {
                            forwardInspectionNoteHistroy.errors.allErrors.each {
                                println it
                            }
                        }
                    }
                    // ends here..
                    //}
                    //indApp.clarification = true
                    //indApp.save(flush:true);
                    flash.message = "Inspection submitted sucessfully "
                } else {
                    flash.message = "Inspection not raised on this application"
                }

            }
            //	else{
            //		flash.message = "Inspection not raised on this application"
            //	}

            //	}

            redirect(controller: 'userMaster', action: 'openSpcbHome')
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

    //################## RAISED CLARIFICATION VIEW FROM OFFICER  ########################//
    def viewRegularClarification = {
        try {

            def application = IndApplicationDetails.get((params.id).toLong())

            def inspectionNoteHistoryInstanceList = InspectionNoteHistory.findAllByApplication(application, [sort: 'dateCreated', order: 'desc', offset: 0])

            for (int i = 0; i < inspectionNoteHistoryInstanceList.size(); i++) {
                if ((inspectionNoteHistoryInstanceList.get(i)).clarification) {

                    return [appClarification: inspectionNoteHistoryInstanceList.get(i)]
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

    //############### RAISED CLARIFICATION VIEW FROM OFFICER ENDS HERE...   ################//

    // ######### Code For clarification attached file view  ########//

    def downLoadingClarificationAttachedFile = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def versionValue1 = params.versionValue1
            //	def is = params.appFileInst.toLong()
            def fileDownLoad

            if (params.appFileInst) {
                fileDownLoad = ApplicationFileRecord.get(params.appFileInst)
            } else {
                fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachRegularClarificationReport' order by afr.dateCreated desc", [appId], [max: 1])

            }
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            if (fileSingle) {
                response.setHeader("Content-Disposition", "attachment;filename=\"" + fileSingle.name + "\"")
                response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
            } else {
                response.setHeader("Content-Disposition", "attachment;filename=\"" + fileDownLoad.name + "\"")
                response.getOutputStream() << new ByteArrayInputStream(fileDownLoad.data)
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

    // ######### Code For clarification attached file view ends here..  ########//

    //###############  CLARIFICATION REPLY FROM INDUSTRY SIDE...   ################//

    def submitRegularClarification = {
        try {

            def application = IndApplicationDetails.get((params.id).toLong())
            def inspectionNoteHistoryInstanceList = InspectionNoteHistory.findAllByApplication(application, [sort: 'dateCreated', order: 'desc', offset: 0])
            for (int i = 0; i < inspectionNoteHistoryInstanceList.size(); i++) {
                if ((inspectionNoteHistoryInstanceList.get(i)).clarification) {
                    return [appClarification: inspectionNoteHistoryInstanceList.get(i), app: application]
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


    def submittedRegularClarification = {
        try {

            def noteHistiryFile = new ApplicationFileRecord()
            def application = IndApplicationDetails.get((params.appId).toLong())
            String apliId = (application.id).toString()
            InspectionNoteHistory inspectionNoteHistoryInst = new InspectionNoteHistory()
            //String strDirectoy ="c:/SPCB_DOCUMENTS"
            String strDirectoy = "SPCB_DOCUMENTS"
            boolean success = (new File(strDirectoy)).mkdir();
            if (success) {

            }
            String strDir = strDirectoy + "/" + apliId
            boolean success2 = (new File(strDir)).mkdir();
            if (success2) {

            }
            def f = request.getFile('indRegularClarificationFile')
            MultipartFile multi = request.getFile('indRegularClarificationFile')
            if (!f.empty) {

                inspectionNoteHistoryInst.clarificationReplyAttachedFile = true
                //f.transferTo( new File(strDir +'/Inspection_Report.doc') )
                def applicationFileRecordInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indRegularClarificationFile' order by afr.id desc", [application], [max: 1])
                if (applicationFileRecordInstance) {
                    noteHistiryFile.version = applicationFileRecordInstance[0].version + 1
                }
                noteHistiryFile.size = multi.getSize() / 1024
                if (noteHistiryFile.size <= 6000) {
                    noteHistiryFile.name = multi.getOriginalFilename()
                    noteHistiryFile.data = multi.getBytes()
                    noteHistiryFile.extension = extractExtension(multi)
                    noteHistiryFile.description = "Regular Clarification Report File"
                    if (session.userMaster) {
                        noteHistiryFile.createdBy = session.userMaster
                        noteHistiryFile.updatedBy = session.userMaster
                    } else {
                        noteHistiryFile.createdBy = session.indUser
                        noteHistiryFile.updatedBy = session.indUser
                    }
                    //fileUpload.data=params.payload
                    noteHistiryFile.typeOfFile = "indRegularClarificationFile"
                    noteHistiryFile.indApplication = application
                    if (noteHistiryFile.save()) {

                        //def noreply = ApplicationPendingDetails.find("from ApplicationPendingDetails where application = ? and applicationStatus = 'approved'",[application])
                        //def noreply2 = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application = ? and (approvalStatus = 'Approved' or approvalStatus = 'Refused')",[application])


                        inspectionNoteHistoryInst.role = RoleMaster.findByRoleName("Industry")
                        inspectionNoteHistoryInst.application = application
                        inspectionNoteHistoryInst.approve = false
                        inspectionNoteHistoryInst.approveNote = ""
                        inspectionNoteHistoryInst.reject = false
                        inspectionNoteHistoryInst.rejectNote = ""
                        inspectionNoteHistoryInst.revoke = false
                        inspectionNoteHistoryInst.revokeNote = ""
                        inspectionNoteHistoryInst.closeInd = false
                        inspectionNoteHistoryInst.closeIndNote = ""
                        inspectionNoteHistoryInst.revokeCloseInd = false
                        inspectionNoteHistoryInst.revokeCloseIndNote = ""
                        inspectionNoteHistoryInst.typeOfInspection = "REGULAR_INSPECTION"
                        //(params.typeOfInspection).trim()

                        inspectionNoteHistoryInst.clarification = false
                        if (params.clarificationDays) {
                            inspectionNoteHistoryInst.clarificationDays = params.clarificationDays
                        } else {
                            inspectionNoteHistoryInst.clarificationDays = ""
                        }
                        if (params.indClarificationNote) {
                            inspectionNoteHistoryInst.clarificationNote = params.indClarificationNote
                            inspectionNoteHistoryInst.fileNote = params.indClarificationNote

                        } else {
                            inspectionNoteHistoryInst.clarificationNote = ""
                            inspectionNoteHistoryInst.fileNote = ""
                        }

//						def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?",[application.indUser])
                        def industryId = (IndUser) session.indUser

                        def role1 = ApplicationPendingDetails.findByApplication(application)

                        def roleFwd = RoleMaster.get((role1.role.id).toLong())

                        def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)

                        def roMobNo = empUser.userProfile.mobile


                        def noticeType = params.noticeType

                        //inspectionNoteHistoryInst.inspection=false
                        //inspectionNoteHistoryInst.inspectionClose=false
                        //inspectionNoteHistoryInst.inspectionCloseNote=""
                        inspectionNoteHistoryInst.inspectionNote = ""
                        inspectionNoteHistoryInst.noticeType = params.noticeType
                        inspectionNoteHistoryInst.roleFwd = RoleMaster.findByRoleName("Industry")
                        inspectionNoteHistoryInst.officer = industryId
                        inspectionNoteHistoryInst.officerFwd = industryId
                        // bhanu code start; date: 15-06-2017
                        // this column is added to manage file attached in regular inspection -> add previous inspection tab
                        inspectionNoteHistoryInst.previousReportAttachedFile = false
                        // bhanu code ends
                        if (!inspectionNoteHistoryInst.hasErrors() && inspectionNoteHistoryInst.save(flush: true)) {

                            //	SendSms sms = new SendSms()
                            //	sms.replyClarification(apliId,noticeType,roMobNo)
                            application.clarification = false
                            application.save(flush: true)

                            flash.message = "Regular Clarification Submitted"
                            redirect(action: popClose)
                        } else {
                            if (inspectionNoteHistoryInst.hasErrors()) {
                                inspectionNoteHistoryInst.errors.allErrors.each {
                                    println it
                                }
                            }
                            redirect(action: 'submitRegularClarification', params: ["id": application])
                        }
                    } else {

                        //redirect(controller:'inspectionClarification',action:'appProcessing',params:["id":indApp.id])
                        redirect(action: 'submitRegularClarification', params: ["id": application])
                    }
                } else {
                    flash.message = "Attachment File Size is More Then 5 Mb"
                    def indApp = application

                    redirect(action: 'submitRegularClarification', params: ["id": application])
                }

            } else {
                //def noreply = ApplicationPendingDetails.find("from ApplicationPendingDetails where application = ? and applicationStatus = 'approved'",[application])
                //def noreply1 = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application = ? and (approvalStatus = 'Approved' or approvalStatus = 'Refused') ",[application])


                application.clarification = false
                application.save()

                inspectionNoteHistoryInst.role = RoleMaster.findByRoleName("Industry")
                inspectionNoteHistoryInst.application = application
                //inspectionNoteHistoryInst.approve = false
                //inspectionNoteHistoryInst.approveNote=""
                //inspectionNoteHistoryInst.returned = false
                //inspectionNoteHistoryInst.returnNote = ""
                inspectionNoteHistoryInst.typeOfInspection = "REGULAR_INSPECTION" //(params.typeOfInspection).trim()
                inspectionNoteHistoryInst.clarification = false
                if (params.clarificationDays) {
                    inspectionNoteHistoryInst.clarificationDays = params.clarificationDays
                } else {
                    inspectionNoteHistoryInst.clarificationDays = ""
                }
                if (params.indClarificationNote) {
                    inspectionNoteHistoryInst.clarificationNote = params.indClarificationNote
                    inspectionNoteHistoryInst.fileNote = params.indClarificationNote

                } else {
                    inspectionNoteHistoryInst.clarificationNote = ""
                    inspectionNoteHistoryInst.fileNote = ""
                }

//					def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?",[application.indUser])
                def industryId = (IndUser) session.indUser

                def role1 = ApplicationPendingDetails.findByApplication(application)

                def roleFwd = RoleMaster.get((role1.role.id).toLong())

                def empUser = UserMaster.findByUserProfile((RoleProfileAssignment.findByRole(roleFwd)).primaryEmployee)

                def roMobNo = empUser.userProfile.mobile


                def noticeType = params.noticeType


                inspectionNoteHistoryInst.inspection = false
                inspectionNoteHistoryInst.inspectionClose = false
                //inspectionNoteHistoryInst.inspectionCloseNote=""
                inspectionNoteHistoryInst.inspectionNote = ""
                inspectionNoteHistoryInst.noticeType = params.noticeType
                inspectionNoteHistoryInst.roleFwd = RoleMaster.findByRoleName("Industry")
                inspectionNoteHistoryInst.officer = industryId
                inspectionNoteHistoryInst.officerFwd = industryId
                if (!inspectionNoteHistoryInst.hasErrors() && inspectionNoteHistoryInst.save(flush: true)) {
                    //	SendSms sms = new SendSms()
                    //	sms.replyClarification(apliId,noticeType,roMobNo)
                    flash.message = "Regular Clarification Submitted. Please refesh the main page once clarification reply is submitted."
                    redirect(action: popClose)
                } else {
                    if (inspectionNoteHistoryInst.hasErrors()) {
                        inspectionNoteHistoryInst.errors.allErrors.each {
                            println it
                        }
                    }
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

    def viewRegularSubmittedClarification = {
        try {

            def application = IndApplicationDetails.get((params.id).toLong())
            //	def applicationFileRecordInst=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indClarificationFile'and afr.version=? order by id",[application,fileVer],[max:1])
            def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [application.indUser])
            def inspectionNoteHistoryDownloadInst = InspectionNoteHistory.find("from InspectionNoteHistory where application=? and officer=? order by id desc ", [application, industryId.toString()])
            def inspectionNoteHistoryList = InspectionNoteHistory.findAll("from InspectionNoteHistory where application=? order by id asc", [application])

            //def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(application,[sort:'dateCreated',order:'desc',offset:0])
            //	for(int i=0;i<applicationProcessingDetailsInstanceList.size();i++){
//							if((applicationProcessingDetailsInstanceList.get(i)).clarification){
            return [applicationProcessingDetailsInstanceList: inspectionNoteHistoryList, app: application, applicationDownloadInst: inspectionNoteHistoryDownloadInst]
            //	}
            //}
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

    /* ########## For view Revoked  ######### */

    def viewRegularRevoked = {
        try {

            def application = IndApplicationDetails.get((params.id).toLong())
            def inspectionNoteHistoryList = InspectionNoteHistory.findAll("from InspectionNoteHistory where application=? order by id asc", [application])
            return [applicationProcessingDetailsInstanceList: inspectionNoteHistoryList, app: application]

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

    /* ############ Ends Here Revoked View ########### */

    /* ########## For view Closed Industry  ######### */

    def viewRegularCloseInd = {
        try {

            def application = IndApplicationDetails.get((params.id).toLong())
            def inspectionNoteHistoryList = InspectionNoteHistory.findAll("from InspectionNoteHistory where application=? order by id asc", [application])
            return [applicationProcessingDetailsInstanceList: inspectionNoteHistoryList, app: application]

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

    /* ############ Ends Here Closed Industry View ########### */

    /***** ###### Code for prepared certificate for revoke ##### *****/

    def revokeCtoAirCertificate = {
        try {
            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"
            //def viewCert = false
            //def viewCertHwm  = false
            def viewCertAir = false
            //def viewCertWater = false


            def viewCerAir = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForAir'", [indApplicationDetailsInstance])
            if (viewCerAir) {
                viewCerAir = true
            }

            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            render(view: 'revokeCtoAirCertificate', model: [viewCertAir: viewCertAir, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance])
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

    def revokeCtoWaterCertificate = {
        try {
            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"
            //def viewCert = false

            def viewCertWater = false


            def viewCerWater = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForWater'", [indApplicationDetailsInstance])
            if (viewCerWater) {
                viewCerWater = true
            }

            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            render(view: 'revokeCtoWaterCertificate', model: [viewCertWater: viewCertWater, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, fileN: fileN])
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

    def revokeCtoHwmCertificate = {
        try {
            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"
            //def viewCert = false
            def viewCertHwm = false

            def viewCerHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForHwm'", [indApplicationDetailsInstance])
            if (viewCerHwm) {
                viewCertHwm = true
            }
            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)


            render(view: 'revokeCtoHwmCertificate', model: [viewCertHwm: viewCertHwm, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, fileN: fileN])
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

    def revokeCtoAirHwmCertificate = {
        try {
            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"

            //def viewCert = false
            //def viewCertHwm  = false
            def viewCertAir = false
            //def viewCertWater = false


            def viewCerAirHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForAirHwm'", [indApplicationDetailsInstance])
            if (viewCerAirHwm) {
                viewCerAirHwm = true
            }

            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            render(view: 'revokeCtoAirHwmCertificate', model: [viewCerAirHwm: viewCerAirHwm, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance])
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

    def revokeCtoWaterHwmCertificate = {
        try {

            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"
            //def viewCert = false
            //def viewCertHwm  = false
            def viewCertAir = false
            //def viewCertWater = false


            def viewCerWaterHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForWaterHwm'", [indApplicationDetailsInstance])
            if (viewCerWaterHwm) {
                viewCerWaterHwm = true
            }

            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            render(view: 'revokeCtoWaterHwmCertificate', model: [viewCerWaterHwm: viewCerAirHwm, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance])
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
    def revokeCtoBothCertificate = {
        try {
            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"
            //def viewCert = false
            //def viewCertHwm  = false
            def viewCertAir = false
            //def viewCertWater = false


            def viewCerBoth = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForBoth'", [indApplicationDetailsInstance])
            if (viewCerBoth) {
                viewCerBoth = true
            }

            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            render(view: 'revokeCtoBothCertificate', model: [viewCerBoth: viewCerBoth, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance])
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

    def revokeCtoBothHwmCertificate = {
        try {
            def userName = (session.userMaster.id).toString()
            def idAppl = (params.appliId).toLong()
            def indApplicationDetailsInstance = IndApplicationDetails.get(idAppl)

            //def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)

            //def roRoleMasterInstance=RoleMaster.findAll("from RoleMaster where group.id="+app.role.group.id+" and typeoff='RO' order by forwardCount ");
            //def roleName = UserMaster.get(RoleProfileAssignment.findByRole(roRoleMasterInstance).primaryEmployee.id).toString() //forwarding to officer id
            def roleName = "Test Role"
            //def viewCert = false
            //def viewCertHwm  = false
            def viewCertAir = false
            //def viewCertWater = false


            def viewCerBothHwm = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForBothHwm'", [indApplicationDetailsInstance])
            if (viewCerBothHwm) {
                viewCerBothHwm = true
            }

            //def roleHeader=app.role.roleName
            def roleHeader = roleName
            def indRegInstance = indApplicationDetailsInstance.indUser
            def teh = indRegInstance.tehsil
            def dis = indRegInstance.district
            def dateSql = indApplicationDetailsInstance.applicationDate
            def abcFinal1 = dateSql
            DateCustom dd1 = new DateCustom()
            def dateCreated = (dd1.sQLdate1(abcFinal1))

            def yr = (dateCreated.getYear()).toInteger() + 1900
            def mon = (indApplicationDetailsInstance.applicationDate).getMonth()
            def dat = (indApplicationDetailsInstance.applicationDate).getDate()
            def abc = (indApplicationDetailsInstance.id).toString()
            def fileN = "F/" + abc + "/" + dat + "/" + mon + "/" + yr

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            render(view: 'revokeCtoBothHwmCertificate', model: [viewCerBothHwm: viewCerBothHwm, roleHeader: roleHeader, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance])

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

    /* **** ###### Code for prepared certificate for revoke ends here.. ##### **** */

    def pdfRevokeHwm = {
        try {
            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize]

				def referenceStore=""


				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {

				}

				*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            //String dateCreateOn = new SimpleDateFormat("yyyy-MM-dd").format(indApplicationDetailsInstance.actualApplicationDate);

            /*def dDate=new Date()
				def abcFinal=dDate

				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeHwmPdfGeneration pdfG = new RevokeHwmPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check
            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save()) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName
                // code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address
                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.hwmPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeHwmCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForHwm"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                render(view: 'revokeCtoHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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

    def pdfRevokeAir = {
        try {

            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize]

				def referenceStore=""


				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {

				}

				*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            /*def dDate=new Date()
				def abcFinal=dDate

				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeAirPdfGeneration pdfG = new RevokeAirPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check
            revokeRecordCertificateInstance.dateCreated = new Date()


            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save(flush: true)) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName

//							 code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address

                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.airPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeAirCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForAir"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoAirCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                if (revokeRecordCertificateInstance.hasErrors()) {
                    revokeRecordCertificateInstance.errors.allErrors.each {
                        println it
                    }
                }


                render(view: 'revokeCtoAirCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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

    def pdfRevokeWater = {
        try {
            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize]

				def referenceStore=""


				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
				}

				*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            //String dateCreateOn = new SimpleDateFormat("yyyy-MM-dd").format(indApplicationDetailsInstance.actualApplicationDate);

            /*def dDate=new Date()
				def abcFinal=dDate

				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeWaterPdfGeneration pdfG = new RevokeWaterPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check

            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save()) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName

//							 code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address

                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.waterPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeAirCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForWater"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoWaterCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                render(view: 'revokeCtoWaterCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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

    def pdfRevokeAirHwm = {
        try {

            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize]

				def referenceStore=""


				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
					}

				*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            /*def dDate=new Date()
				def abcFinal=dDate

				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeAirHwmPdfGeneration pdfG = new RevokeAirHwmPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check
            revokeRecordCertificateInstance.dateCreated = new Date()


            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save(flush: true)) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName

//							 code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address

                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.airHwmPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeAirHwmCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForAirHwm"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoAirHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                if (revokeRecordCertificateInstance.hasErrors()) {
                    revokeRecordCertificateInstance.errors.allErrors.each {
                        println it
                    }
                }

                render(view: 'revokeCtoAirHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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

    def pdfRevokeWaterHwm = {
        try {

            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
				def refSize=referenceCheck.size()
				def referencesArray = new String[refSize]

				def referenceStore=""

				if(referenceCheck.getClass().getName()=="java.lang.String") {
					referenceStore="1. "+referenceCheck
				}else{
					for(int varI=0; varI<referenceCheck.size();varI++) {
						int varInteger=varI+1
						referencesArray[varI]=referenceCheck[varI]
						referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
					}
				}
				for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
				}

				*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            /*def dDate=new Date()
				def abcFinal=dDate

				DateCustom dd=new DateCustom()
				def todayDate= (dd.sQLdate1(abcFinal)).toString()
				*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeWaterHwmPdfGeneration pdfG = new RevokeWaterHwmPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check
            revokeRecordCertificateInstance.dateCreated = new Date()


            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save(flush: true)) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName

//							 code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address

                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.waterHwmPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeWaterHwmCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForWaterHwm"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoWaterHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                if (revokeRecordCertificateInstance.hasErrors()) {
                    revokeRecordCertificateInstance.errors.allErrors.each {
                        println it
                    }
                }

                render(view: 'revokeCtoWaterHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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


    def pdfRevokeBoth = {
        try {

            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
		def refSize=referenceCheck.size()
		def referencesArray = new String[refSize]

		def referenceStore=""


		if(referenceCheck.getClass().getName()=="java.lang.String") {
			referenceStore="1. "+referenceCheck
		}else{
			for(int varI=0; varI<referenceCheck.size();varI++) {
				int varInteger=varI+1
				referencesArray[varI]=referenceCheck[varI]
				referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
			}
		}
		for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
		}

		*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            /*def dDate=new Date()
		def abcFinal=dDate

		DateCustom dd=new DateCustom()
		def todayDate= (dd.sQLdate1(abcFinal)).toString()
		*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeBothPdfGeneration pdfG = new RevokeBothPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check
            revokeRecordCertificateInstance.dateCreated = new Date()


            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save(flush: true)) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName

//					 code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address

                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.bothPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeBothCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForBoth"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoBothCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                if (revokeRecordCertificateInstance.hasErrors()) {
                    revokeRecordCertificateInstance.errors.allErrors.each {
                        println it
                    }
                }


                render(view: 'revokeCtoBothCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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

    def pdfRevokeBothHwm = {
        try {
            File certFile
            ApplicationFileRecord file = new ApplicationFileRecord()
            //def certificateRecordInstance = new CertificateRecord()
            def revokeRecordCertificateInstance = new RevokeRecordCertificate()
            def appID = params.idIndApp
            def fileNo = params.check
            //def indUserInstance=IndUser.get((params.id).toString())

            def indApplicationDetailsInstance = IndApplicationDetails.get((params.idIndApp).toLong())
            def indRegInstance = indApplicationDetailsInstance.indUser
            def indRegInstanceUniversal = indApplicationDetailsInstance.indUser //for category change********
            def industryUser = IndUser.find("from IndUser ind where ind.industryRegMaster=?", [indRegInstanceUniversal])
            def industryId = industryUser.id
            //def other = params.copyTo

            def industryTypeMasterInstance = indApplicationDetailsInstance.indUser.industryType
            //def id1=1
            def id2 = indApplicationDetailsInstance.applicationType
            def consentForVar = indApplicationDetailsInstance.certificateFor
            def applicationForVar = indApplicationDetailsInstance.applicationFor
            def consentFrom = indApplicationDetailsInstance.consentFrom
            def consentTo = indApplicationDetailsInstance.consentTo

            //def industryTypeMasterInstance=IndustryTypeMaster.get(id1)
            def applicationTypeMasterInstance = ApplicationTypeMaster.findWhere(consentType: id2)

            /*def referenceCheck=params.copyTo
			def refSize=referenceCheck.size()
			def referencesArray = new String[refSize]

			def referenceStore=""


			if(referenceCheck.getClass().getName()=="java.lang.String") {
				referenceStore="1. "+referenceCheck
			}else{
				for(int varI=0; varI<referenceCheck.size();varI++) {
					int varInteger=varI+1
					referencesArray[varI]=referenceCheck[varI]
					referenceStore=referenceStore+"\n"+varInteger+". "+referenceCheck[varI]
				}
			}
			for(int checkVar=0;checkVar<referencesArray.size();checkVar++) {
			}

			*/


            int ab = 1
            def dateCreatedOn = new Date()
            def dateCreateOn1 = new SimpleDateFormat("dd-MM-yyyy").format(dateCreatedOn);
            String dateCreateOn = dateCreateOn1
            /*def dDate=new Date()
			def abcFinal=dDate

			DateCustom dd=new DateCustom()
			def todayDate= (dd.sQLdate1(abcFinal)).toString()
			*/

            def indName = indRegInstance.indName
            def address = indRegInstance.indAddress
            // 			if(indRegInstance.tehsil){
            //
            def tehsil1 = indRegInstance.tehsil.toString()
            //  			}
            //def tehsil="HardCoded"

            def occupierName = (indRegInstance.applicantName).toString()
            def industryUnit = (indRegInstance.industryUnit).toString()
            def industryCity = (indRegInstance.indCity).toString()
            def industryPin = (indRegInstance.indPin).toString()
            //def appID=params.idIndApp

            def district = (indRegInstance.district).toString()
            def details = params.details
            RevokeBothHwmPdfGeneration pdfG = new RevokeBothHwmPdfGeneration()
            def certiFor = params.certiFor

            revokeRecordCertificateInstance.updatedBy = session.userMaster
            revokeRecordCertificateInstance.createdBy = session.userMaster
            if (params.details) {
                revokeRecordCertificateInstance.details = params.details
            } else {
                revokeRecordCertificateInstance.details = ""
            }
            revokeRecordCertificateInstance.applicationId = indApplicationDetailsInstance
            revokeRecordCertificateInstance.certiFor = params.certiFor
            revokeRecordCertificateInstance.recieptNo = params.check
            revokeRecordCertificateInstance.dateCreated = new Date()


            if (!revokeRecordCertificateInstance.hasErrors() && revokeRecordCertificateInstance.save(flush: true)) {
                flash.message = "Certificate Generated and Record Saved "

                //////// employee //////


                def UserMasterInstance = session.userMaster
                def userProfileInstance = UserMasterInstance.userProfile
                def roleId = RoleProfileAssignment.findByPrimaryEmployee(userProfileInstance)
                def desination = roleId.role.roleName
                def grpName = roleId.role.group.groupName

//						 code for RO office address

                def grpByRoOfficeAddress
                if (grpName == "Bahadurgarh") {
                    grpByRoOfficeAddress = "SCF No. 42 & 43, Shopping Centre,Sector-6, Huda, Bahadurgarh Ph. 01276-243077 (O)"
                } else if (grpName == "Ballabhgarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Chandigarh") {
                    grpByRoOfficeAddress = "Ballabhgarh Sec.16-A, Opp.  Hewo Apartment, Faridabad                    Ph 0129-2225314"

                } else if (grpName == "Dharuhera") {
                    grpByRoOfficeAddress = "Lala Nemi Chand Singhal Enc. Sohna Road, Near Hanuman Mandir, Dharuhera Ph. 01274-244440-41(O)"

                } else if (grpName == "Faridabad") {
                    grpByRoOfficeAddress = "Faridabad Sec.-16-A, Opp. Hewo Apartment, Faridabad                    Ph. 0129-2225315(O)"

                } else if (grpName == "Gurgaon North") {
                    grpByRoOfficeAddress = "Gurgoan North Vikas Sada, 1st Floor, Near DC Court, Gurgaon Ph.  0124-2332775 "

                } else if (grpName == "Gurgaon South") {
                    grpByRoOfficeAddress = "Haryana State Pollution Control Board, 3rd Floor, HSIIDC Office Complex, IMT Manesar, Gurugram "

                } else if (grpName == "Hissar") {
                    grpByRoOfficeAddress = "Bays B-7-8, Near Vishwas Sr. Sec. School, UE-II, Hisar Ph. 01662-250891(O)"

                } else if (grpName == "Jind") {
                    grpByRoOfficeAddress = "SCO-21, Ist floor, Improvement Trust \n near Hansi Gate Bhiwani Ph. 01664-240259 "

                } else if (grpName == "Panchkula") {
                    grpByRoOfficeAddress = "SCO-180, 2nd Floor, Sector-5, Panchkula Ph. 0172-2566286 "

                } else if (grpName == "Panipat") {
                    grpAddgrpByRoOfficeAddressress = "SCO-55, Sec.25, HUDA, Panipat Ph. 0180-2672037 "

                } else if (grpName == "Sonipat") {
                    grpByRoOfficeAddress = "Star Complex, Opp. General Hospital, Delhi Road, Sonepat Ph.  0130-2236119(O)"

                } else if (grpName == "Yamuna Nagar") {
                    grpByRoOfficeAddress = "SCO-131 Sector-17, HUDA Jagadhari Ph.01732-200137 "

                }

                // ends here code for RO office address

                def empName = userProfileInstance.employeeFirstName
                def empName1 = userProfileInstance.employeeLastName

                certFile = pdfG.bothHwmPdfFunction(grpName, desination, industryId, occupierName, address, indName,
                        appID, fileNo, details, empName, empName1, dateCreateOn, certiFor, consentFrom, consentTo, grpByRoOfficeAddress)


                def link = "link"

                byte[] b = new byte[(int) certFile.length()];

                FileInputStream fileInputStream = new FileInputStream(certFile);
                fileInputStream.read(b);

                def fileLength = certFile.length()
                file.size = fileLength / 1024  //f.getSize()
                file.extension = "pdf"//extractExtension( f )
                file.data = b;
                file.name = "revokeBothHwmCertiFicate.pdf"
                file.description = "Revoke Certificate Generation Record"
                file.createdBy = session.userMaster
                file.updatedBy = session.userMaster
                file.typeOfFile = "RevokeCertificateForBothHwm"
                file.indApplication = indApplicationDetailsInstance
                if (file.save()) {
                    if (certFile) {
                        certFile.delete()
                    }
                } else {
                    flash.userMessage = "File [${file.name}] has NOT not been uploaded."
                    // render(view: 'create', model: [file: file])
                    render(view: 'revokeCtoBothHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
                }


                redirect(action: inspectionProcessing, params: ["id": params.idIndApp])

            } else {

                if (revokeRecordCertificateInstance.hasErrors()) {
                    revokeRecordCertificateInstance.errors.allErrors.each {
                        println it
                    }
                }

                render(view: 'revokeCtoBothHwmCertificate', model: [revokeRecordCertificateInstance: revokeRecordCertificateInstance, indRegInstance: indRegInstance, indApplicationDetailsInstance: indApplicationDetailsInstance, appID: appID])
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
    def downLoadingRevokeCtoCertificateForAir = {
        try {

            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForAir' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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
    def downLoadingRevokeCtoCertificateForWater = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForWater' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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
    def downLoadingRevokeCtoCertificateForHwm = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForHwm' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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
    def downLoadingRevokeCtoCertificateForAirHwm = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForAirHwm' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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
    def downLoadingRevokeCtoCertificateForWaterHwm = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForWaterHwm' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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
    def downLoadingRevokeCtoCertificateForBothHwm = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForBothHwm' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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
    def downLoadingRevokeCtoCertificateForBoth = {
        try {
            def appId = IndApplicationDetails.get((params.id).toLong())
            def fileDownLoad = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='RevokeCertificateForBoth' order by afr.dateCreated desc", [appId], [max: 1])
            def fileSingle = fileDownLoad.get(0);
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileSingle.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileSingle.data)
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

    def viewFile1 = {
        try {
            def fileVer = (params.varCheckInsClarifications).toLong()
            def application = IndApplicationDetails.get((params.appliLoc).toLong())
            def applicationFileInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachRegularClarificationReport' and afr.version = ?", [application, fileVer], [max: 1])
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
    
    def viewFile14= {
            try {
                println("params...."+params)
            	//def fileVer = (params.varCheckInsClarifications).toLong()
                def application = IndApplicationDetails.get((params.appliLoc).toLong())
                println("application...."+application)
                def applicationFileInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachRegularClarificationReport'", [application], [max: 1])
                println("applicationFileInstance...."+applicationFileInstance)
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

    def viewSubmittedFileClarification = {
        try {
        	println("here in viewSubmittedFileClarification..."+params)
            def fileVer = (params.varCheckInsClarification).toLong()
            def application = IndApplicationDetails.get((params.appliLoc).toLong())
            def applicationFileInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indRegularClarificationFile'  and afr.version = ?", [application, fileVer], [max: 1])
            println("here in viewSubmittedFileClarification.applicationFileInstance.."+applicationFileInstance)
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
    
    def viewSubmittedRegularClarification = {
            try {
            	println("here in viewSubmittedFileClarification..."+params)
               def application = IndApplicationDetails.get((params.appliLoc).toLong())
                def applicationFileInstance = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indRegularClarificationFile'", [application], [max: 1])
                println("here in viewSubmittedFileClarification.applicationFileInstance.."+applicationFileInstance)
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


    // bhanu code start; date: 12-06-2017
    def popPreviousInspectionAdd = {
        /*def inspectionDate
            def previousInspectionReportFile
            def multi
            def group = params.group
            def simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");*/



        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        /*def roleMasterList
            def roleProfileAssignmentList*/
        ArrayList myArrayList2 = new ArrayList()
        def empList = UserProfile.list(sort: "employeeFirstName", order: "asc")
        for (int q = 0; q < empList.size(); q++) {
            if ((empList.get(q)).status == "active") {
                myArrayList2.add((empList.get(q)))
            }

        }

        // code to filter the user profile based on group if needed in future
        /*if(group){
                roleMasterList = RoleMaster.findAll("from RoleMaster where group = ?", GroupMaster.get(Long.parseLong(group)))
                roleProfileAssignmentList = RoleProfileAssignment.findAllByRoleInList(roleMasterList)
                for(int i= 0; i < roleProfileAssignmentList.size(); i++){
                    myArrayList2.add(roleProfileAssignmentList[i].primaryEmployee)
                }
            }else{
                for(int q=0;q<empList.size();q++)
                {
                    if((empList.get(q)).status=="active")
                    {

                        myArrayList2.add((empList.get(q)))
                    }


                }
            }*/
        // println("params.id: " + params.id)
        // code to show details of application number
        def industryRegMasterInstance = IndustryRegMaster.get(Long.parseLong(params.industryRegMasterInstanceId))
        def outer = new ArrayList()
        def inner
        def allSummaryReportList = AllSummaryReport.findAll("from AllSummaryReport where indRegMasterId = ? order by id", [String.valueOf(industryRegMasterInstance.id)])
        int allSummaryReportSize = allSummaryReportList.size()
        for (int i = 0; i < allSummaryReportSize; i++) {
            inner = new ArrayList()
            def regularInspectionRaisedInstance = RegularInspectionRaised.findByApplication(IndApplicationDetails.get(allSummaryReportList[i].applicationId))
//          def inspectionNoteHistory = InspectionNoteHistory.findByApplicationAndApplicationClosed(IndApplicationDetails.get(allSummaryReportList[i].applicationId), true)
            def isRegularInspectionRaised = InspectionNoteHistory.find("from InspectionNoteHistory where " +
                    "typeOfInspection = 'REGULAR_INSPECTION' and application = ? order by id desc", [IndApplicationDetails.get(allSummaryReportList[i].applicationId)])
            def isRegularInspectionClosed = InspectionNoteHistory.find("from InspectionNoteHistory where " +
                    "typeOfInspection = 'REGULAR_INSPECTION' and application = ? and applicationClosed = ? order by id desc", [IndApplicationDetails.get(allSummaryReportList[i].applicationId), true])
            inner.add(String.valueOf(allSummaryReportList[i].applicationId))
            inner.add(allSummaryReportList[i].applicationType)
            inner.add(allSummaryReportList[i].applicationFor)
            inner.add(allSummaryReportList[i].applicationStatus)
            inner.add(df.format(allSummaryReportList[i].applicationRecieptDate))
            inner.add(df.format(allSummaryReportList[i].pendingSince))
            if (regularInspectionRaisedInstance) {
                inner.add("YES")
            } else {
                inner.add("NO")
            }

            /*if (inspectionNoteHistory) {
                inner.add("closed")
            } else if (regularInspectionRaisedInstance) {
                inner.add("In-progress")
            } else {
                inner.add("")
            }*/
            if (isRegularInspectionRaised) {
                if(isRegularInspectionClosed){
                    inner.add("closed")
                }else{
                    inner.add("In-progress")
                }
            } else {
                inner.add("")
            }

            outer.add(inner)
        }
        println("params.flashMessage: " + params.flashMessage)
        println("group: " + params.group)
        if (params.flashMessage) {
            flash.message = params.flashMessage
        }
        [industryRegMasterInstanceId: params.industryRegMasterInstanceId, indUser: params.indUser, myArrayList2: myArrayList2, outer: outer, group: params.group]
    }


    def savePopPreviousInspectionAdd = {
        def inspectionDate
        def previousInspectionReportFile
        def multi
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        println("inside save popPreviousInspectionAdd")
        inspectionDate = params.inspectionDate
        if (!inspectionDate) {
            flash.message = "Please Select the Inspection Date"
            redirect(action: 'popPreviousInspectionAdd', params: [industryRegMasterInstanceId: params.industryRegMasterInstanceId, flashMessage: flash.message, group: params.group])
            return
        }
        println("inspectionDate: " + inspectionDate)
        previousInspectionReportFile = request.getFile('previousInspectionReportFile')
        def applicationNumber = params.applicationNo
        if (applicationNumber) {
            println("applicationNumber: " + applicationNumber)
            def indAppInstance = IndApplicationDetails.get(Long.parseLong(applicationNumber))

            // code to save file start
            if (previousInspectionReportFile) {
                def applicationFileRecord = new ApplicationFileRecord()
                multi = request.getFile('previousInspectionReportFile')
                if (!previousInspectionReportFile.empty) {
                    // code to get the set the version start
                    def applicationFileRecordForVersion = ApplicationFileRecord.findAll("from ApplicationFileRecord where indApplication = ? and typeOfFile = 'previousInspectionReport' order by id desc", [indAppInstance])[0]
                    if (applicationFileRecordForVersion) {
                        applicationFileRecord.version = applicationFileRecordForVersion.version + 1
                    }
                    // code to get the set the version ends
                    applicationFileRecord.size = multi.getSize() / 1024
                    if (applicationFileRecord.size > 2048) {
                        flash.message = "Inspection file size should not be more than 2MB"
                        redirect(action: 'popPreviousInspectionAdd', params: [industryRegMasterInstanceId: params.industryRegMasterInstanceId, flashMessage: flash.message, group: params.group])
                        return
                    }
                    applicationFileRecord.name = multi.getOriginalFilename()
                    applicationFileRecord.data = multi.getBytes()
                    applicationFileRecord.extension = extractExtension(multi)
                    applicationFileRecord.description = "Previous Regular Inspection Report File"
                    if (session.userMaster) {
                        applicationFileRecord.createdBy = session.userMaster
                        applicationFileRecord.updatedBy = session.userMaster
                    } else {
                        applicationFileRecord.createdBy = session.indUser
                        applicationFileRecord.updatedBy = session.indUser
                    }
                    applicationFileRecord.typeOfFile = "previousInspectionReport"
                    applicationFileRecord.indApplication = indAppInstance
                    applicationFileRecord.dateCreated = new Date()
                    applicationFileRecord.lastUpdated = new Date()
                    applicationFileRecord.indApplication = indAppInstance
                    if (applicationFileRecord.save(flush: true)) {

                    } else {
                        applicationFileRecord.errors.each {
                            println it
                        }
                    }
                } else {
                    flash.message = "Please Choose Previous Inspection Report File"
                    redirect(action: 'popPreviousInspectionAdd', params: [industryRegMasterInstanceId: params.industryRegMasterInstanceId, flashMessage: flash.message, group: params.group])
                    return
                }
            } else {
                flash.message = "Please Choose Previous Inspection Report File"
                redirect(action: 'popPreviousInspectionAdd', params: [industryRegMasterInstanceId: params.industryRegMasterInstanceId, flashMessage: flash.message, group: params.group])
                return
            }
            // code to save file ends
            println("before saving regular inspection raised")
            println("params.group: " + params.group)
            // code to save RegularInspectionRaised start
            def regularInspectionRaised = new RegularInspectionRaised()
            regularInspectionRaised.application = indAppInstance
            regularInspectionRaised.group = GroupMaster.get(Long.parseLong(params.group))
            regularInspectionRaised.inspectionRaised = false
            println("inspectionDate: " + inspectionDate)
            def dateInstance = df.parse(inspectionDate)
            Calendar cal = Calendar.getInstance()
            cal.setTime(dateInstance)
            int year = cal.get(Calendar.YEAR)
            int month = cal.get(Calendar.MONTH) // returns zero based index i.e. for january = 0
            regularInspectionRaised.month = Integer.toString(month + 1)
            regularInspectionRaised.year = Integer.toString(year)
            regularInspectionRaised.inspectionClosedDate = new Date()
            regularInspectionRaised.industryTypeId = Long.parseLong(params.industryRegMasterInstanceId)
            regularInspectionRaised.category = IndustryRegMaster.get(Long.parseLong(params.industryRegMasterInstanceId)).category.name
            regularInspectionRaised.officerName = RoleProfileAssignment.findByPrimaryEmployee(UserMaster.findById(params.officer).userProfile).role.roleName
            regularInspectionRaised.officerId = params.officer
            println("params.officer: " + params.officer + " its class: " + params.officer.getClass())
            if (regularInspectionRaised.save(flush: true)) {

            } else {
                regularInspectionRaised.errors.each {
                    println it
                }
            }
            // code to save RegularInspectionRaised ends

            // code to save InspectionNoteHistory start
            def inspectionNoteHistory = new InspectionNoteHistory()
            inspectionNoteHistory.application = indAppInstance
            UserMaster userMaster = (UserMaster) session.userMaster
            UserProfile userProfile = userMaster.userProfile
            RoleProfileAssignment roleProfileAssignment = RoleProfileAssignment.findByPrimaryEmployee(userProfile)
            inspectionNoteHistory.role = roleProfileAssignment.role
            inspectionNoteHistory.roleFwd = RoleProfileAssignment.findByPrimaryEmployee(UserMaster.findById(params.officer).userProfile).role
            inspectionNoteHistory.officer = userMaster.id
            inspectionNoteHistory.officerFwd = params.officer
            inspectionNoteHistory.inspectionNote = "Previous inspection submitted by " + RoleProfileAssignment.findByPrimaryEmployee(userProfile).role.roleName
            inspectionNoteHistory.inspectionDescriptionNote = String.valueOf(regularInspectionRaised.id)
            // in other cases it is blank string but i want to store the inspection number
            inspectionNoteHistory.fileNote = ""
            inspectionNoteHistory.noticeType = ""
            inspectionNoteHistory.clarification = false
            inspectionNoteHistory.clarificationNote = ""
            inspectionNoteHistory.clarificationDays = ""
            inspectionNoteHistory.clarificationAttachedFile = false
            inspectionNoteHistory.clarificationReplyAttachedFile = false
            if (params.approveOrReject.equals('Approved')) {
                inspectionNoteHistory.approve = true // to be filled
                if (params.approveOrRejectNote) {
                    inspectionNoteHistory.approveNote = params.approveOrRejectNote
                } else {
                    inspectionNoteHistory.approveNote = ""
                }
                inspectionNoteHistory.reject = false // to be filled
                inspectionNoteHistory.rejectNote = "" // to be filled
                inspectionNoteHistory.approvalStatus = "Approved" // to be filled - Approved or Refused
            } else {
                inspectionNoteHistory.approve = false // to be filled
                inspectionNoteHistory.approveNote = "" // to be filled
                inspectionNoteHistory.reject = true // to be filled
                if (params.approveOrRejectNote) {
                    inspectionNoteHistory.rejectNote = params.approveOrRejectNote
                } else {
                    inspectionNoteHistory.rejectNote = ""
                }
                inspectionNoteHistory.approvalStatus = "Refused" // to be filled - Approved or Refused
            }
            inspectionNoteHistory.revokeNote = ""
            inspectionNoteHistory.revoke = false
            inspectionNoteHistory.closeIndNote = ""
            inspectionNoteHistory.closeInd = false
            inspectionNoteHistory.revokeCloseIndNote = ""
            inspectionNoteHistory.revokeCloseInd = false
            inspectionNoteHistory.dateCreated = (Date) df.parse(params.inspectionDate)
            // new inspection is created based on this date
            inspectionNoteHistory.lastUpdated = new Date()
            inspectionNoteHistory.applicationClosed = true
            inspectionNoteHistory.typeOfInspection = "PREVIOUS_INSPECTION"
            inspectionNoteHistory.previousReportAttachedFile = true
            if (inspectionNoteHistory.save()) {
                inspectionNoteHistory.dateCreated = (Date) df.parse(params.inspectionDate)
                // dateCreated by default store today date thats why is is updated afetr instance is saved for the first time
                if (inspectionNoteHistory.save()) {

                } else {
                    inspectionNoteHistory.errors.each {
                        println it
                    }
                }
            } else {
                inspectionNoteHistory.errors.each {
                    println it
                }
            }
            // code to save InspectionNoteHistory ends
        } else {
            flash.message = "Please Choose Application Number"
            redirect(action: 'popPreviousInspectionAdd', params: [industryRegMasterInstanceId: params.industryRegMasterInstanceId, flashMessage: flash.message, group: params.group])
            return
        }

        flash.message = "Record Saved Successfully"
        // render (view: 'popPreviousInspectionAdd')
        redirect(action: 'popPreviousInspectionAdd', params: [industryRegMasterInstanceId: params.industryRegMasterInstanceId, flashMessage: flash.message, group: params.group])

    }
    // bhanu code ends

    // bhanu code start; date: 15-06-2017


    def downloadPreviousReport = {
        try {
            println("action: downloadPreviousReport")
            println("\tparams.id: " + params.id)
            println("\tparams.version: " + params.version)
            def indApplicationDetailsInstance = IndApplicationDetails.get((params.id).toLong())
            println("\tindApplicationDetailsInstance: " + indApplicationDetailsInstance + " its class: " + indApplicationDetailsInstance.getClass())
            def fileDownload = ApplicationFileRecord.find("from ApplicationFileRecord abc where abc.indApplication = ? and version = ? order by dateCreated Desc", [indApplicationDetailsInstance, Long.parseLong(params.version)])
            response.setContentType("application-xdownload")
            response.setHeader("Content-Disposition", "attachment;filename=${fileDownload.name}")
            response.getOutputStream() << new ByteArrayInputStream(fileDownload.data)
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
    // bhanu code ends


    // bhanu code start; date: 23-06-2017
    def deleteAddedPreviousInspection = {
        try {
            def applicationId = params.applicationId
            def inspectionNoteHistoryId = params.inspectionNoteHistoryId
            def fileVersion = params.fileVersion
            def inspectionNoteHistoryInstance = InspectionNoteHistory.get(Long.parseLong(inspectionNoteHistoryId))
            def regularInspectionRaisedInstance = RegularInspectionRaised.get(Long.parseLong(inspectionNoteHistoryInstance.inspectionDescriptionNote))
            def applicationFileRecordList = ApplicationFileRecord.findAll("from ApplicationFileRecord where indApplication = ? and typeOfFile = 'previousInspectionReport' and version > ? order by id desc", [inspectionNoteHistoryInstance.application, Long.parseLong(fileVersion)])
            def applicationFileRecordToDelete = ApplicationFileRecord.find("from ApplicationFileRecord where indApplication = ? and typeOfFile = 'previousInspectionReport' and version = ? order by id desc", [inspectionNoteHistoryInstance.application, Long.parseLong(fileVersion)])
            if(applicationFileRecordToDelete.delete()){

            }else{
                applicationFileRecordToDelete.errors.each {
                    println it
                }
            }
            for(int i = 0; i < applicationFileRecordList.size(); i++){
                // we cannot change  chnage the version therefore i have to create another instance with updated version and delete original instance
                def newApplicationFileRecordInstance = new ApplicationFileRecord()
                newApplicationFileRecordInstance.version = applicationFileRecordList[i].version - 1
                newApplicationFileRecordInstance.data = applicationFileRecordList[i].data
                newApplicationFileRecordInstance.name = applicationFileRecordList[i].name
                newApplicationFileRecordInstance.description = applicationFileRecordList[i].description
                newApplicationFileRecordInstance.size = applicationFileRecordList[i].size
                newApplicationFileRecordInstance.extension = applicationFileRecordList[i].extension
                newApplicationFileRecordInstance.dateCreated = applicationFileRecordList[i].dateCreated
                newApplicationFileRecordInstance.lastUpdated = applicationFileRecordList[i].lastUpdated
                newApplicationFileRecordInstance.createdBy = applicationFileRecordList[i].createdBy                
                newApplicationFileRecordInstance.updatedBy = applicationFileRecordList[i].updatedBy      
                newApplicationFileRecordInstance.typeOfFile = applicationFileRecordList[i].typeOfFile                          
                newApplicationFileRecordInstance.indApplication = applicationFileRecordList[i].indApplication
                if(newApplicationFileRecordInstance.save()){
                    
                }else{
                    newApplicationFileRecordInstance.errors.each {
                        println it
                    }
                }

                if(applicationFileRecordList[i].delete()){
                    
                }else{
                    applicationFileRecordList[i].errors.each {
                        println it
                    }
                }
            }
            if(inspectionNoteHistoryInstance.delete()){

            }else{
                inspectionNoteHistoryInstance.errors.each {
                    println it
                }
            }
            if(regularInspectionRaisedInstance.delete()){

            }else{
                regularInspectionRaisedInstance.errors.each {
                    println it
                }
            }
            flash.message = "Record successfully deleted"
            redirect(action: "showInspectionNoteHistroy",  params: [typeOfInspection: "PREVIOUS_INSPECTION", id: applicationId])
            return

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
    // bhanu code ends

    // Satish code starts Dated:03/07/2017
    def regularInspectionCatMis= {
        try{

            //def grp = GroupMaster.findAll()
            def  newGroupList = GroupMaster.list()
            def grp = new ArrayList()
            for(int i = 0 ; i < newGroupList.size(); i++ ){
                if((newGroupList[i].groupDesc=="CONSENT")){
                    grp.add(newGroupList[i])
                }
            }
            return[grp:grp]
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

    def searchIndustriesBasedOnDistrictMis = {
        def districtId = params.district
        def districtMasterInstance
        def industryRegMasterInstanceList
        def group = null
        if(districtId.equals("ALL")){

            industryRegMasterInstanceList = IndustryRegMaster.executeQuery("select irm.id from IndustryRegMaster as irm, AllSummaryReport as asr where " +
                    " irm.category.name in ('RED', 'ORANGE', 'GREEN') and cast(irm.id as string)  = asr.indRegMasterId  " +
                    " order by irm.id desc")
        }else{
            districtMasterInstance = DistrictMaster.get(Long.parseLong(districtId))
            def groupDistrictMaster = GroupDistrictMaster.find("from GroupDistrictMaster where district = ? order by id asc ", [districtMasterInstance])
            if(groupDistrictMaster){
                group = groupDistrictMaster.group.id
            }
            industryRegMasterInstanceList = IndustryRegMaster.executeQuery("select irm.id from IndustryRegMaster as irm, AllSummaryReport as asr where " +
                    " irm.category.name in ('RED', 'ORANGE', 'GREEN') and cast(irm.id as string)  = asr.indRegMasterId  " +
                    " and irm.district = ? order by irm.id desc", [districtMasterInstance])
        }


        def finalIndustryRegMasterList = new ArrayList()
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < industryRegMasterInstanceList.size(); i++){
            def industryRegMasterInstance = IndustryRegMaster.get(industryRegMasterInstanceList[i])
            def isIndUser = IndUser.findByIndustryRegMaster(industryRegMasterInstance)
            if(isIndUser){
                if(!set.contains(isIndUser.id.toString())){
                    // code to take out only those industries whose consent is approved
                    /*def allSummaryReport = AllSummaryReport.find("from AllSummaryReport where " +
                            " applicationStatus = 'approved' and indRegMasterId = ?", [String.valueOf(industryRegMasterInstanceList[i])])*/
//                        if(allSummaryReport){
                    finalIndustryRegMasterList.add(industryRegMasterInstance)
                    set.add(isIndUser.id.toString())
//                        }
                }

            }else{
                // try to find universal industryRegMaster instance in indApplicationDdetails
                def indApplicationInstance = IndApplicationDetails.findByIndUser(industryRegMasterInstance)
                if(indApplicationInstance){
                    def indUser = IndUser.findByIndustryRegMaster(indApplicationInstance.indUser)
                    if(indUser){
                        if(!set.contains(indUser.id.toString())){
                            /*def allSummaryReport = AllSummaryReport.find("from AllSummaryReport where " +
                                    "applicationType = 'CTO' and applicationStatus = 'approved' and indRegMasterId = ?", [String.valueOf(industryRegMasterInstanceList[i])])
                            if(allSummaryReport){*/
                            finalIndustryRegMasterList.add(industryRegMasterInstance)
                            set.add(indUser.id.toString())
//                                }
                        }

                    }
                }
            }
        }
        def inspectionNoList = new ArrayList(finalIndustryRegMasterList.size())



        for(int i = 0; i < finalIndustryRegMasterList.size(); i++){
            def inner = new ArrayList()
            def applicationList = IndApplicationDetails.findAllByIndUserUniversal(finalIndustryRegMasterList[i])

            for(int j= 0; j<applicationList.size(); j++){
                def regularInspectionRaisedInstance = RegularInspectionRaised.findAllByApplication(applicationList[j])

                for (int k=0; k<regularInspectionRaisedInstance.size(); k++) {
                    if(regularInspectionRaisedInstance){
                        inner.add(regularInspectionRaisedInstance[k].id)
                    }

                }
            }
            inspectionNoList.add(inner)

        }
        if(finalIndustryRegMasterList.isEmpty()){
            flash.message = "No result found"
        }
        render(view: 'regularInspectionCatMis', model: [finalIndustryRegMasterList: finalIndustryRegMasterList,
                                                        addPreviousInspection: true, searchedDistrict: districtId, group: group, inspectionNoList: inspectionNoList])
    }
    // satish code ends


    //  satish code starts Dated: 13/07/17
    def openIndustryHomeInspection = {
        try{
            if(!session.indUser)
            {
                redirect(uri:"/index.gsp")
            }
            else{
                def industryId = session.indUser
                def indUserID = industryId.industryRegMaster
                def pendinglist = new ArrayList()
                def completedlist = new ArrayList()
                def compStatusList = new ArrayList();
                def completionStatus = new ArrayList();
                def approvalList = new ArrayList();
                def completionDate = new ArrayList();
                def pendingWith = new ArrayList();
                def file = new ArrayList();
                def fileDownLoad
                def indApplicationDetailsList = IndApplicationDetails.findAllWhere(indUser:indUserID , appDel:false)// change indUser to indUser
                for(int i=0; i<indApplicationDetailsList.size; i++)
                {



                    if((indApplicationDetailsList.get(i)).completionStatus.equals('pending')){
                        pendinglist.add((indApplicationDetailsList.get(i)))
                    }else{
                        completedlist.add((indApplicationDetailsList.get(i)))
                        def status = ApplicationPendingDetails.findByApplication(indApplicationDetailsList.get(i))
                        if(status){


                            def returnStatus = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by id desc",[indApplicationDetailsList.get(i)])

                            if(status.applicationStatus=="pending"){
                                compStatusList.add("In-Progress")
                            }else if(status.applicationStatus=="approved"){
                                compStatusList.add("Granted")
                            }
                            else if(status.scrutinyStatus=="In-Complete"){
                                compStatusList.add("Returned")
                            }


                            else if(returnStatus.returned==true){
                                compStatusList.add("Returned")
                            }


                            else{
                                compStatusList.add("Refused")
                            }
                            completionStatus.add(status.completionStatus)
                            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm");

                            String strDate = sdfDestination.format(status.completionDate);

                            if(status.completionStatus.equals("Complete") || status.completionStatus.equals("In-Complete"))
                            {
                                completionDate.add(strDate)
                            }
                            else
                            {
                                completionDate.add("")
                            }
                            pendingWith.add(status.role.roleName)
                        }else{
                            compStatusList.add("In-Progress")
                            completionStatus.add("In-Process")
                            completionDate.add("")
                            pendingWith.add("")
                        }



                    }
                }
                for(int j=0; j<pendinglist.size; j++)
                {
                    def dateWithTime =(pendinglist.get(j)).applicationDate
                    DateCustom dd=new DateCustom()
                    def xyz= dd.toDate(dateWithTime)
                    (pendinglist.get(j)).applicationDate=xyz
                }

                for(int k=0; k<completedlist.size; k++)
                {
                    def dateWithTime1 =(completedlist.get(k)).applicationDate
                    DateCustom dd1=new DateCustom()
                    def xyz1= dd1.toDate(dateWithTime1)
                    (completedlist.get(k)).applicationDate=xyz1
                }


                //code added for environment clearence

                def evcList = EnvironmentalClearenceDetails.findAll("from EnvironmentalClearenceDetails s where s.indUser.id=? ",[industryId.industryRegMaster.id])

                //code added for Environmental Clearance  Details end here
                render(view:'indUser/industryhomeInspection',model:[completedIndApplicationDetailsInstanceList:completedlist,pendingIndApplicationDetailsInstanceList:pendinglist,compStatusList:compStatusList,completionStatus:completionStatus,completionDate:completionDate,pendingWith:pendingWith,evcList:evcList])

            }
            //render(view:'industryhome')
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
        
    def submitClarification = {
   		 try { 
   			println("here in submitclarification.."+params)	
   			 def application = IndApplicationDetails.get((params.id).toLong())
   			 println("here in submitclarification.application."+application)	
   			def applicationProcessingDetailsInstanceList1 = InspectionNoteHistory.findAllByApplication(application, [sort: 'dateCreated', order: 'desc', offset: 0])
               for (int i = 0; i < applicationProcessingDetailsInstanceList1.size(); i++) {
                   if ((applicationProcessingDetailsInstanceList1.get(i)).clarification) {
                       return [appClarification: applicationProcessingDetailsInstanceList1.get(i), app: application]
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
   		
   def submittedClarification = {
   		 try {
   			 def noteHistiryFile=new ApplicationFileRecord()
   				def application = IndApplicationDetails.get((params.appId).toLong())
   				String apliId = (application.id).toString()
   				def appProcessing = new InspectionNoteHistory()
   				def f = request.getFile('indRegularClarificationFile')
   				MultipartFile multi = request.getFile('indRegularClarificationFile')
   				if(!f.empty) {
   					appProcessing.clarificationReplyAttachedFile=true
   					def applicationFileRecordInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='indRegularClarificationFile' order by afr.id desc",[application],[max:1])
   					if(applicationFileRecordInstance){
   						noteHistiryFile.version =applicationFileRecordInstance[0].version+1
   					}
   					noteHistiryFile.size = multi.getSize() / 1024
   					if(noteHistiryFile.size<=6000){
   					noteHistiryFile.name =multi.getOriginalFilename()
   					noteHistiryFile.data=multi.getBytes() 
   					noteHistiryFile.extension = extractExtension( multi )
   					noteHistiryFile.description="Application Clarification Report File"
   					if(session.userMaster){
   						noteHistiryFile.createdBy=session.userMaster
   						noteHistiryFile.updatedBy=session.userMaster
   					}else {
   						noteHistiryFile.createdBy=session.indUser
   						noteHistiryFile.updatedBy=session.indUser
   					}
   					noteHistiryFile.typeOfFile="indRegularClarificationFile"
   					noteHistiryFile.indApplication=application  
   					if(noteHistiryFile.save()) {
   					} else {
   						redirect(action:'appProcessing',params:["id":indApp.id])
   					}
   				}
   				else {
   					flash.message = "Attachment File Size is More Then 5 Mb"
   				    redirectBack = true
   				}
   				}
   				application.clarification = false
   				application.save()
   				appProcessing.role = RoleMaster.findByRoleName("Industry")
   				appProcessing.application = application
   				appProcessing.approve = false
   				appProcessing.approveNote=""
   				appProcessing.clarification=false
   				if(params.indClarificationNote){
   					appProcessing.clarificationNote= params.indClarificationNote
   					appProcessing.fileNote = params.indClarificationNote
   				}else{
   					appProcessing.clarificationNote = ""
   					appProcessing.fileNote=""
   				}
   				appProcessing.inspectionNote=""
   				appProcessing.roleFwd = RoleMaster.findByRoleName("Industry")
   				println("appProcessing.roleFwd...."+appProcessing.roleFwd)
   				appProcessing.officer = "SPCB"
   				appProcessing.officerFwd = "SPCB"
   				appProcessing.reject = false
   				appProcessing.rejectNote = ""
   				appProcessing.approvalStatus = ""
   				appProcessing.clarificationDays = ""
   				appProcessing.closeIndNote = ""
   				appProcessing.inspectionDescriptionNote = ""
   				appProcessing.noticeType = "Clarification Reply"
   				appProcessing.revokeCloseIndNote = ""
   				appProcessing.revokeNote = ""
   				appProcessing.typeOfInspection = "REGULAR_INSPECTION"
   										
   				if(appProcessing.save())
   					{ println("here in app...")
   					}
   					else{
   						appProcessing.errors.each {
   					        println it
   						}
   						println("In Else")
   					}
   				def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
   				def AllSummaryReportInstance=AllSummaryReport.find("from AllSummaryReport where applicationId = ?",[apliId]);
   				if(AllSummaryReportInstance)
   				{
   					AllSummaryReportInstance.lastClarificationDate = sdfh.format(new Date());
   					AllSummaryReportInstance.clarificationSubmitDt = new Date();
   					AllSummaryReportInstance.pendingSince = new Date();
   					AllSummaryReportInstance.save();
   				}
   				flash.message = "Clarification Submitted"
   				redirect(action:popClose)
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
def viewClarificationReportIndustry={
			 try {
				 println("params..viewClarificationReportIndustry."+params)
			 def application = IndApplicationDetails.get((params.appliLoc).toLong())
					def type=params.docName
					def applicationFileInstance=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile=? order by afr.dateCreated desc",[application,type],[max:1])
					println("params..applicationFileInstance."+applicationFileInstance)
					def applicationFileSingleInstance=applicationFileInstance[0]
					response.setContentType( "application-xdownload")
					response.setHeader("Content-Disposition","attachment;filename=\""+applicationFileSingleInstance.name+"\"" )
					response.getOutputStream() << new ByteArrayInputStream( applicationFileSingleInstance.data )
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
}

