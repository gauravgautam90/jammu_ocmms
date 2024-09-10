<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
a:link {
	text-decoration: none;
	color: #1E6BBD;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
<script type="text/javascript">
function enablingDisablingapp(id)
{
	
		var a= document.getElementById(id).value;
		if(a=="yes"){
			
			
			if(document.getElementById("reject")){
				document.getElementById("reject").disabled=true;
				document.getElementById("reject1").disabled=true;
				document.getElementById("rejectNote").disabled=true;
				}
			
			}
		if(a=="no"){
			
			
			if(document.getElementById("reject")){
				document.getElementById("reject").disabled=false;
				document.getElementById("reject1").disabled=false;
				document.getElementById("rejectNote").disabled=false;
				}
			
			}
		
				
}


function enablingDisablingrej(id)
{
	
		var a= document.getElementById(id).value;
		if(a=="yes"){
			
			
			if(document.getElementById("approve")){
			document.getElementById("approve").disabled=true;
			document.getElementById("approve1").disabled=true;
			document.getElementById("approveNote").disabled=true;
			}
			
			}
		if(a=="no"){
			
			
			if(document.getElementById("approve")){
			document.getElementById("approve").disabled=false;
			document.getElementById("approve1").disabled=false;
			document.getElementById("approveNote").disabled=false;
			}
			
			}
		
				
}
     <!--------ADDED BY DEEPAK -------------->
function alertselected()
{

	var selectmenu=document.getElementById("scrutiny").value;

	 if (selectmenu=='In-Complete')
	 {
//	 alert("hello")
	  document.getElementById('selectTemp13131').style.display = 'none';
	  document.getElementById('selectTemp131311').style.display = 'none';
	  document.getElementById('selectTemp3').style.display = 'block';
	//  document.getElementById('selectTemp33').style.display = 'block';
	  document.getElementById('selectTemp13').style.display = 'block';
	//  document.getElementById('selectTemp131').style.display = 'block';
	  document.getElementById('selectTemp14').style.display = 'block';
	  document.getElementById('selectTemp4').style.display = 'block';


	  
	  document.getElementById('selectTempFee').style.display = 'none';
	  document.getElementById('selectTempFee1').style.display = 'none';
	  document.getElementById('selectTempFee2').style.display = 'none';
	  document.getElementById('selectTempFee3').style.display = 'none';
	  document.getElementById('selectTempFee4').style.display = 'none';
	  document.getElementById('selectTempFee5').style.display = 'none';
	  document.getElementById('selectTempFee6').style.display = 'none';
	  document.getElementById('selectTempFee7').style.display = 'none';
	  

	}
	else
	{
//		alert("hiiiiiiiiiiiiiiii")
		document.getElementById('selectTemp13131').style.display = 'block';
	document.getElementById('selectTemp131311').style.display = 'block';
	document.getElementById('selectTemp3').style.display = 'block';
//	document.getElementById('selectTemp33').style.display = 'block';
	document.getElementById('selectTemp14').style.display = 'none';
	document.getElementById('selectTemp13').style.display = 'block';
	//document.getElementById('selectTemp131').style.display = 'block';

	document.getElementById('selectTemp4').style.display = 'none';

	document.getElementById('selectTempFee').style.display = 'block';
	document.getElementById('selectTempFee1').style.display = 'block';
	document.getElementById('selectTempFee2').style.display = 'none';
	document.getElementById('selectTempFee3').style.display = 'none';
	document.getElementById('selectTempFee4').style.display = 'block';
	document.getElementById('selectTempFee5').style.display = 'block';
	document.getElementById('selectTempFee6').style.display = 'block';
	document.getElementById('selectTempFee7').style.display = 'block';


	}
	 
}

function addLateFee()
{

var feeLate
var lateFees
if(document.getElementById('lateFeeN').checked==true)
{
	feeLate=document.getElementById('lateFeeN').value;

}

else
{
	feeLate=document.getElementById('lateFeeY').value;

}

if(feeLate=="Yes")
{
	lateFees = eval(document.getElementById("feeApplicable").value)/2;
	
}
else{
	
	lateFees = 0;
}
document.getElementById("lateFee1").value = lateFees;
//alert("lateFees----"+lateFees);

var feeAdd = document.getElementById('addFee')

if (feeAdd.value == "" )
{

	feeAdd.value = "0";
}

if (feeAdd.value <0 )
{
alert("Please enter correct value");
feeAdd.value = "0";
}


var calVal = eval(document.getElementById("feeApplicable").value)+ eval(document.getElementById("addFee").value) + lateFees;
document.getElementById("totalFee").value=calVal.toFixed(2)


}


function checkTotal(id)
{
if (id.value == "" )
{

id.value = "0";
}

if (id.value <0 )
{
alert("Please enter correct value");
id.value = "0";
}
var feeLate
var lateFees
if(document.getElementById('lateFeeN').checked==true)
{
	feeLate=document.getElementById('lateFeeN').value;

}

else
{
	feeLate=document.getElementById('lateFeeY').value;

}

if(feeLate=="Yes")
{
	lateFees = eval(document.getElementById("feeApplicable").value)/2;
}
else{
	
	lateFees = 0;
}
//alert("lateFees----"+lateFees);
document.getElementById("lateFee1").value = lateFees;
var calVal = eval(document.getElementById("feeApplicable").value)+ eval(document.getElementById("addFee").value) + lateFees;
document.getElementById("totalFee").value=calVal.toFixed(2)


}
<!--------ADDED BY DEEPAK -------------->
</script>

</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- Start of menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
        <%} %>
     <% if((UserMaster)session.getAttribute("userMaster")){
			UserMaster aa = (UserMaster)session.getAttribute("userMaster");
			String userType = aa.accessLevel
				if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      
			<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
				<%}
		} %>
     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
			<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
	  <% } %>
	  <!-- END of menuAdminHorizontal-->
            		
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- Start of menuAdmin-->
			<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				 <g:include controller="userMaster" action="wasteManagementIndustryVertical"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					  <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
			<!-- End of menuAdmin-->

			
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>
               <%
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
			<table width="100%" > 
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 <% if(appFor=="MSW"){ %>
						 <td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader} &nbsp;&nbsp;&nbsp;&nbsp;Industry Name: ${appl.indRegMasterObj.indName}</td>
						 <%}else{ %>
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader} &nbsp;&nbsp;&nbsp;&nbsp;Industry Name: ${appl.industryRegMasterObj.indName}</td>
						 <% }%>
						 <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
			<tr>		
					<td align="left"><g:def var="appForWhich1" value="${appFor}"/><g:def var="applicationId" value="${appIdStr}"/>
						
						<a href="#" onclick="window.open('<g:createLink action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
						<%if(appFor=='BMW'){ %>
						<g:if test="${inspectionClose==true}">
						<a href="<%=request.getContextPath()%>/industryMasterDetails/createWasteMasterData?appliId=<%=applicationId%>"><span class="innerlink"> Prepare Master Data |</span></a>
						</g:if>
						<% }%>
						
						<% 
						System.out.println("------------applicationId.toLong()-----"+applicationId.toLong())
						  def viewDataMaster = WasteManagementFile.findAll("from WasteManagementFile im where im.applicationId=? and im.typeOfFile='Master Report BMW' order by im.id desc",[applicationId.toLong()])
						  if(viewDataMaster.size()>0){
						def fileId=viewDataMaster[0].id
						%>
						<g:link controller="bioMedicalWaste" action="viewMasterPdf"  id="${fileId}" ><span class="innerlink">&nbsp;View MasterData&nbsp;|</span></g:link>
						<%}%>
						
						<%if(appFor=='HWM'){%>
						
						<a href="#" onclick="window.open('<g:createLink  action="spcbShowFormNewFormat" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View FormN&nbsp;|</span></a> 
					   	
						<%}else if(appFor=='BMW'){%>
						
						<a href="#" onclick="window.open('<g:createLink  action="spcbShowFormNewFormat1" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View FormN&nbsp;|</span></a> 
						
						<%}else if(appFor=='MSW'){%>
						<a href="#" onclick="window.open('<g:createLink action="spcbShowForm" params="[docName:'MSW',appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a>
						
						<%}
						else if(appFor=='PWM'){%>
						<a href="#" onclick="window.open('<g:createLink controller="plasticWaste" action="showforSpcb" params="[docName:'PWM',id:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a>
						
						<%}%>
						
						<%
						//def scr123 = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where scrutinyStatus='Complete' and applicationId=?",[appId.toString()])
						def scr123 = WasteManagementPendingDetails.find("from WasteManagementPendingDetails where scrutinyStatus='Complete' and applicationId=?",[appId.toString()])
						System.out.println("scr123----"+scr123);
						%>
						<%
						def consentFeeMasterInst
						
						if(appFor=="BMW"){
							consentFeeMasterInst = ConsentFeeMasterBMW.find("from ConsentFeeMasterBMW afr where afr.application.id=?",[appId.toLong()])
							}else if(appFor=="HWM"){
								consentFeeMasterInst = ConsentFeeMasterHWM.find("from ConsentFeeMasterHWM afr where afr.application.id=?",[appId.toLong()])
							}
						
						%>
						<%
						   if(scr123) {
						  if(prepareCertificate){
							if(appFor=='HWM')
							{
									 def hazInst = HazardeousWasteAuthApp.get(app.applicationId.toLong())
									 def recordCertificatehmw = RecordCertificateHWM.findByApplication(hazInst)
							
							
									if(isRenew=='Yes')
									{
									
									if(!recordCertificatehmw){
										%>		<g:link controller="hazardeousWasteAuthApp" action="insrtCertificateDetailsForRenewal" id="${appId}"><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link>
												<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderHWM?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
												<g:link controller="hazardeousWasteAuthApp" action="refusalDraft" id="${appId}"><span class="innerlink">&nbsp;Prepared Refusal Draft&nbsp;|</span></g:link>
				
										<%
									}
									else{
									
									%>		<g:link controller="hazardeousWasteAuthApp" action="insrtCertificateDetailsForRenewal" id="${appId}"><span class="innerlink">&nbsp;Modify Prepared Certificate&nbsp;|</span></g:link>
											<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderHWM?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
											<g:link controller="hazardeousWasteAuthApp" action="refusalDraft" id="${appId}"><span class="innerlink">&nbsp;Modify Refusal Draft&nbsp;|</span></g:link>
				
									
									<%
									}
									}
									else
									{
									
									if(!recordCertificatehmw){
										%><g:link controller="hazardeousWasteAuthApp" action="insrtCertificateDetailsForNew" id="${appId}"><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link>
											<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderHWM?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
											<g:link controller="hazardeousWasteAuthApp" action="refusalDraft" id="${appId}"><span class="innerlink">&nbsp;Prepared Refusal Draft&nbsp;|</span></g:link>
				
										<%	
									}
									else{
									
									%>	<g:link controller="hazardeousWasteAuthApp" action="insrtCertificateDetailsForNew" id="${appId}"><span class="innerlink">&nbsp;Modify Prepared Certificate&nbsp;|</span></g:link>
										<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderHWM?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
										<g:link controller="hazardeousWasteAuthApp" action="refusalDraft" id="${appId}"><span class="innerlink">&nbsp;Modify Refusal Draft&nbsp;|</span></g:link>
				
									<%	
									}
									}
					        }	
					        
					        else if(appFor=='BMW')
							{
							
							def bioInst = BioMedicalWaste.get(app.applicationId.toLong())
									 def recordCertificate = RecordCertificateBMW.findByApplication(bioInst)
									if(isRenew=='Yes')
									{
									
										 if(!recordCertificate)
						 {
							
						 
						
										%><g:link controller="bioMedicalWaste" action="showForGenRenew"  id="${appId}"><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link>
											<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderBMW?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
				
										<%
									}
									else{
								 System.out.println("recordCertificate......: "+recordCertificate.id);
								 %>
								<g:link controller="bioMedicalWaste" action="showForGenRenew" id="${appId}" ><span class="innerlink">&nbsp;Modify Prepared Certificate&nbsp;|</span></g:link>
								
									<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderBMW?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
				
							<%}
									}
									else
									{  
									
						 if(!recordCertificate)
						 {
							
						 %><g:link controller="bioMedicalWaste" action="showForGen" params="[id:appId]" ><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link>
											<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderBMW?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
						<%
								}
								else{
								 System.out.println("recordCertificate......: "+recordCertificate.id);
								 %>
								<g:link controller="bioMedicalWaste" action="showForGen" params="[id:appId]" ><span class="innerlink">&nbsp;Modify Prepared Certificate&nbsp;|</span></g:link>
								<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderBMW?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
				
							<%	}	}
					        }						
						}
						   }
						%>
						<% if(appFor=='PWM'){ System.out.println("-PWM-"+appId)%>
						<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/uploadConsentOrderPWM?appliId=<%=appId%>"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></a>
										
				       <% }else if(appFor=='MSW')
						{
							if(isRenew=='No')
							{
								%><g:link controller="municipalSolidWaste" action="genCertMunicipalNew" id="${appId}"><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link><%
							}
							else
							{
								%><g:link controller="municipalSolidWaste" action="genCertMunicipalReNew" id="${appId}"><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link><%
							}
			        } %>
						<br>	
						<% 
						def inspReport = WasteManagementFile.find("from WasteManagementFile afd where afd.applicationId=? and afd.typeOfFile='Inspection Report BMW'",[appId.toLong()])
						def inspReportHWM = WasteManagementFile.find("from WasteManagementFile afd where afd.applicationId=? and afd.typeOfFile='Inspection Report HWM'",[appId.toLong()])
						
						%>
								<%if(inspReport){%>
							
							<g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'Inspection Report BMW',docType:'doc',appliFor:appForWhich]"><span class="innerlink">&nbsp;View Inspection Report&nbsp;|</span></g:link>
							<%}%>
		<%if(inspReportHWM){%>
							
							<g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'Inspection Report HWM',docType:'doc',appliFor:appForWhich]"><span class="innerlink">&nbsp;View Inspection Report&nbsp;|</span></g:link>
							<%}%>
						
						
						<%if(appFor=='HWM'){%>
						
						<%if(viewCert){%>
						<g:link controller="hazardeousWasteAuthApp" action="viewHazCert"  id="${fileId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}else if(chk)
						{
						int id=appId;%>
						<g:link controller="hazardeousWasteAuthApp" action="viewHazCert1"  id="${id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}%>
						
						<%}else if(appFor=='BMW'){%>
						
							<%if(viewCert){%>
							<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${fileId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
							<%}
							else if(chk)
							{
								int id=appId;%>
								<g:link controller="bioMedicalWaste" action="viewBioCert1"  id="${id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
							<%}%>
							<%
						//def inspectionReport = BioMedicalInspectionReport.findByApplication(bioInst)
						def inspectionReport=BioMedicalInspectionReport.find("from BioMedicalInspectionReport a where a.application=?",[appl])
						%>
						<%if(app.role.eeRecommendation=="Yes"){%>
						<% if(inspectionReport){%>
						<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popDeeRecommendationsBMWFresh?id=<%=appl.id%>&type=DEE', 'ApplicationHistory', 'WIDTH=900,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Officer Remarks&nbsp;|</span></a>
						<%}%>
						<%}%>
							
							
						<%}else if(appFor=='MSW'){%>
							
							
						<%if(viewCert){%>
						<g:link controller="municipalSolidWaste" action="viewMunCert"  id="${fileId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}
						else if(chk)
						{
						int id=appId;%>
						<g:link controller="municipalSolidWaste" action="viewMunCert1"  id="${id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}%>
						
						
						<%}%>
						
						
						
						
						
						
<%
						
						def certUp11 = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='BMW' and afr.typeOfFile='uploaded' order by afr.id desc",[appId.toLong()])
						System.out.println("view certiiiiii"+certUp11);
						if(certUp11){ %>
						<g:link action="viewUploadedBioCert"  id="${appId}" ><span class="innerlink">&nbsp;View Uploaded Certificate&nbsp;|</span></g:link>
						<%}
						def certUpHWM = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='HWM' and afr.typeOfFile='uploaded' order by afr.id desc",[appId.toLong()])
						System.out.println("view certUpHWM"+certUpHWM);
						if(certUpHWM){
						%>
						<g:link action="viewUploadedHazCert"  id="${appId}" ><span class="innerlink">&nbsp;View Uploaded Certificate&nbsp;|</span></g:link>
						<%}
						def certiPWM=WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='PWM' and afr.typeOfFile='uploaded' order by afr.id desc",[appId.toLong()])
						if(certiPWM){
						%>
						<g:link action="viewUploadedPWMCert"  id="${appId}" ><span class="innerlink">&nbsp;View Uploaded Certificate&nbsp;|</span></g:link>
						<%}%>
						
						
						
						
						
						
						</td>	
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                      <g:if test="${flash.message}">
				           				 <div>${flash.message}</div>
				            			</g:if>
				            			<g:hasErrors bean="${groupMasterInstance}">
				            			
				              			  <g:renderErrors bean="${groupMasterInstance}" as="list" />
				            			
				            		</g:hasErrors>
                      
                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		<g:form action="processApp" enctype="multipart/form-data" method="post" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"  /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">File Noting/Action</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"  /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#A8DAF3">
 					<td colspan="2" class="headngblue" align="center">Last Comments</td>
 					</tr>
 					
				<%if(applicationProcessingDetailsInstance){%>
				<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );
%>
			<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>
 
  <tr  >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Note By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}">Industry</g:if><g:else> ${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})  </g:else></div></td>
        </tr>			
					 <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'indClarificationFile',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></g:if></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.fileNote}  </td>
                      </tr>
		<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Clarification</div> <g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'attachedClarificationReport',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.clarificationNote} </td>
                      </tr>
	   </g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Inspection</div><g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'attachedInspectionReport',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.inspectionNote}</td>
                      </tr>
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9"><span align="left"  class="headngblue">Inspection Closed</span> <span  class="txt">&nbsp; <g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'inspectionReport',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></span></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.inspectionCloseNote}</td>
                      </tr>
		</g:if>
				 <g:if test="${applicationProcessingDetailsInstance.approve==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left" >Approve</div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">${applicationProcessingDetailsInstance.approveNote}   </td>
                      </tr>
				</g:if>
				<g:if test="${applicationProcessingDetailsInstance.reject==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left" bgcolor="#E8F6F9" class="headngblue">Reject</div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">${applicationProcessingDetailsInstance.rejectNote}  </td>
                      </tr>
				</g:if>
				
				
 					<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
 					
 					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Attached Letter:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="appId1" value="${app.id}"/><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewOtherAttachedDocument" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',appliFor:appForWhich, appId2:appId1]">View Letter</g:link></td>
                      </tr>
             
 					<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
					<%}%>
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Forward To : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					  <g:select optionKey="id" from="${fwdRoleList}" name="forward" class="txt4" ></g:select>
					 
				</span></span>				</td>
			</tr>	
			
			<%
			System.out.println("applicationDetails.applicationId----"+applicationDetails.applicationId)
			def roleProAssign = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ",[session.userMaster.id]);
			def rVa = RoleVsActivity.findWhere(role:roleProAssign.role, activity:RoleActivityMaster.findByActivityCode("001"))
			//def scr = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where scrutinyStatus='Complete' and applicationId=?",[applicationDetails.applicationId])
			def scr = WasteManagementPendingDetails.find("from WasteManagementPendingDetails where scrutinyStatus='Complete' and applicationId=?",[applicationDetails.applicationId])
					
				System.out.println("scr.scr----"+scr)	
				System.out.println("appFor.----"+appFor)	
				if(appFor=="HWM" || appFor=="BMW"){
					 
					 if(!(scr)){
						 System.out.println("Inside Scrutiny Not Completed----")	
					//def consentFeeInst = AuthorizationFeeMaster.find("from AuthorizationFeeMaster where application=? order by id desc",[applicationDetails.applicationId])	 
						 %>
					
						 <tr >
							<td  bgcolor="#A8DAF3" class="headngblue" >File Note : </td>
						 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <textarea name="fileNote" cols="40" class="txt4"></textarea>
								</span></td>
							</tr>
							
							<tr >
							<td  bgcolor="#A8DAF3" class="headngblue" >Attach letter (If Any): </td>
						 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
								  <input type="file" name="attachLetter"/>
								</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span></td>
							</tr>	 
					<tr >
						<td  bgcolor="#A8DAF3" class="headngblue" >Scrutiny Status : </td>
					 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
							 <select id="scrutiny" name="scrutiny" onChange="alertselected()">
		<option value=""></option>
		<option value="Complete">Complete</option>
		<option value="In-Complete">In-Complete</option>
		</select> 
						</span></span>				</td>
					</tr>
					
					
					
					
					
					<tr >
						<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTemp13" >Description : </div></td>
					 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
							<div style="display:none; border:0;" id="selectTemp3" >	<textarea name="scrutinyDescription" id="scrutinyDescription" cols="35" class="txt4" ></textarea>	   
							</div>
							
						</span></span></td>
					</tr>
					
					<!--<tr >
					<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTemp131" >Attach letter (If Any) :</div></td>
				 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
						<div style="display:none; border:0;" id="selectTemp33" >	
						
						<input type="file" name="attachLetter"/>
						</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span></td>
					</tr>	-->
					
						</div>
						
					
					<tr >
						<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTemp14" >Attach letter for Scrutiny:</div> </td>
					 	<td  align="left" bgcolor="#A8DAF3"  class="headngblue">
					 	<div style="display:none; border:0;" id="selectTemp4" >
					 	<span class="txt">
							  <input type="file" name="attachScrutinyReport"/>
							</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>
							</div>
							</td>
						</tr>
					
						<%
						if(appFor=="PWM"){}else{
						if(consentFeeMasterInst){%>
						<tr >
						<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee" >Fee applicable : </div></td>
					 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
							<div style="display:none; border:0;" id="selectTempFee1" >	<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value="${consentFeeMasterInst.calculatedFee}" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>   
							</div>
							
						</span></span>				</td>
					</tr>
					<%}else{%>
					<tr >
					<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee" >Fee applicable : </div></td>
				 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
						<div style="display:none; border:0;" id="selectTempFee1" >	<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value="0" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>   
						</div>
						
					</span></span>				</td>
				</tr>
				<%}%>
				
					<tr >
					<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee2" >Late Fees : </div></td>
				 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
						<div style="display:none; border:0;" id="selectTempFee3" >	

						<span class="txt4">
						 <input id="lateFeeN" name="lateFee" type="radio" value="No" checked onClick="addLateFee();" />No
						<input  id="lateFeeY" name="lateFee" type="radio" value="Yes" onClick="addLateFee();" />Yes</span>
					
						<input name="lateFee1" id="lateFee1" type="hidden" value="0" />
						</div>
						
					</span></span>				</td>
				</tr>
					
				
				<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee4" >Additional Fees: </div></td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					<div style="display:none; border:0;" id="selectTempFee5" >	<input name="addFee" id="addFee" type="number" class="txt4" size="10" value="0" onblur="checkTotal(this)" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>   
					</div>
					
				</span></span>				</td>
			</tr>
				
			<tr>
			
			<td align="left" valign="middle" bgcolor="#A8DAF3"
				class="headngblue"><div style="display:none; border:0;" id="selectTemp13131" >Total Fee Applied </td>
			<td align="left" bgcolor="#E8F6F9" class="headngblue"><div style="display:none; border:0;" id="selectTemp131311" >
			<input name="totalFee" id="totalFee" type="text" class="txt4"  size="10" value="${fieldValue(bean:consentFeeMasterInst,field:'totalFees')}" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
			</tr>
			
					<%}}%>
					
					
					<%  if(scr) {%>
				<%	System.out.println("Inside Scrutiny Completed----")	%>
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >File Note : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <textarea name="fileNote" cols="40" class="txt4"></textarea>
					</span></td>
				</tr>
				
				<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Attach letter (If Any): </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input type="file" name="attachLetter"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span></td>
				</tr>	
			
				<g:if test="${clarification==true}">
			<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
			<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise clarification ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="clarification" id="clarification" type="radio" value="yes" onclick="enablingDisabling(this.id);"/>
                                <span class="style3">Yes</span>                              
                                <input name="clarification" id="clarification1" type="radio" value="no" checked="checked" onclick="enablingDisabling(this.id);"/>
                                <span class="style3">No</span>				</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Clarification Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="clarificationNote" id="clarificationNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Reply clarification within : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					 <input type="text" name="clarificationDays" id="clarificationDays" value="" size="5"/>
					</span>&nbsp;days.</td>
				</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Attach letter for Clarification Report: </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt">
					  <input type="file" name="attachClarificationReport" id="attachClarificationReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
				</tr>	
				
				</g:if>	
				<g:if test="${inspection==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="inspection" id="inspection" type="radio" value="yes" onclick="enablingDisablingins(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="inspection" id="inspection1" type="radio" value="no" checked="checked" onclick="enablingDisablingins(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Inspection Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionNote" id="inspectionNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>	
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Reply inspection within : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					 <input type="text" name="inspectionDays" id="inspectionDays" value="" size="5"/>
					</span>&nbsp;days.</td>
				</tr>	
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Attach letter for inspection Report: </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt">
					  <input type="file" name="attachInspectionReport" id="attachInspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
				</tr>				
        	 </g:if>
        	 <% if(appFor=='BMW' || appFor=='HWM'){ %>
        	 <g:if test="${appl.inspection==true}">
        	 <g:if test="${inspectionClose==true}">
        	
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="inspectionClose" id="inspectionClose" type="radio" value="yes" onclick="enablingDisablinginscl(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="inspectionClose" id="inspectionClose1" type="radio" value="no" checked="checked" onclick="enablingDisablinginscl(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
				<% def bioMedicalMaster= WasteMasterDataDetails.find("from WasteMasterDataDetails wm where wm.applicationId=?",[applicationProcessingDetailsInstance.applicationId])
				System.out.println("-----fgf----"+bioMedicalMaster)
				if(viewDataMaster.size()>0 && bioMedicalMaster){
				System.out.println("-----invoked---")
				%>
				 <td><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popBMWInspectionReport/<%=applicationProcessingDetailsInstance.applicationId%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Prepare Inspection Report&nbsp; </a><% }
				 
				else if(appFor=='HWM'){ %>
				<td><g:link action="popHWMInspectionReport" id="${fieldValue(bean:applicationProcessingDetailsInstance, field: "applicationId")}" target="_blank" params="[id:applicationProcessingDetailsInstance.applicationId]"> <span class="innerlink">&nbsp;Prepare Inspection Report&nbsp;|</span></g:link>
				
				<% }%>
				</td>
				</tr>				
        	 </g:if>  </g:if><%} else{ %>
        	 
        	 
        	  <g:if test="${appl.inspection==true}">
        	 <g:if test="${inspectionClose==true}">
        	
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="inspectionClose" id="inspectionClose" type="radio" value="yes" onclick="enablingDisablinginscl(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="inspectionClose" id="inspectionClose1" type="radio" value="no" checked="checked" onclick="enablingDisablinginscl(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>
				
					<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <input type="file" name="inspectionReport" id="inspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
				</tr>				
        	 </g:if>  </g:if>
        	 
        	 
        	 <% }%>
        	 <g:if test="${approve==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to Approve Application ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="approve" id="approve" type="radio" value="yes" onclick="enablingDisablingapp(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="approve" id="approve1"  type="radio" value="no" checked="checked" onclick="enablingDisablingapp(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Approval Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea name="approveNote" id="approveNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>				
        	 </g:if>
        	 <g:if test="${reject==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Reject
				  Application ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
			 		                           
                      <input name="reject" id="reject"  type="radio" value="yes" onclick="enablingDisablingrej(this.id);"/>
                      <span class="style3">Yes</span>   
                      <input name="reject" id="reject1" type="radio" value="no" checked="checked" onclick="enablingDisablingrej(this.id);">
                      <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="rejectNote" id="rejectNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>				
        	 </g:if>
<% 
def abb=RoleMaster.get(app.role.id.toLong())
System.out.println("--return power------"+abb.returnPower)
if(abb.returnPower=='Yes'){
%>
				
			 	 <tr bgcolor="#A8DAF3">
			 	 <td colspan="2">&nbsp;</td>
			 	 </tr>
			 	 <tr >
			 	 <td bgcolor="#98AFC7" class="headngblue" >Do you want to return application? : </td>
			 	 <td align="left" bgcolor="#98AFC7" class="headngblue">
			 	 <input id="returned" name="returned" type="radio" value="yes" ">
				Yes 
			  <input id="returned" name="returned" type="radio" value="no" checked="checked" ">
			  No</td>
			 	 </tr>
			 	  
			 	
			 	  <tr >
			                         
			                      
			 	 
			 	 <td bgcolor="#98AFC7" class="headngblue" >Return Description : </td>
			 	 <td align="left" bgcolor="#98AFC7" class="headngblue">
			 	 <textarea maxlength="500" id="returnNote" name="returnNote" cols="35"  class="txt4"></textarea>
			 	 &nbsp;
			 	<span class="sidetxt ">(Can not contain special characters or reserve words)</span>
			    </td>
			    </tr>	  
			  <% }%>
                        </table>
						
                        <%}}else{%>
                        <!------------------------------  Added By DEEPAK end-------------------------->
                        <%	System.out.println("Inside for Other Application----")	%>
                        <tr >
        				<td  bgcolor="#A8DAF3" class="headngblue" >File Note : </td>
        			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
        					  <textarea name="fileNote" cols="40" class="txt4"></textarea>
        					</span></td>
        				</tr>
        				
        				<!--<tr >
        				<td  bgcolor="#A8DAF3" class="headngblue" >Attach letter (If Any): </td>
        			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
        					  <input type="file" name="attachLetter"/>
        					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span></td>
        				</tr>	 -->
        			
        				<g:if test="${clarification==true}">
        			<tr bgcolor="#A8DAF3">
         						<td colspan="2">&nbsp;</td>
         					</tr>
        			<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise clarification ? : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
        						<input name="clarification" id="clarification" type="radio" value="yes" onclick="enablingDisabling(this.id);"/>
                                        <span class="style3">Yes</span>                              
                                        <input name="clarification" id="clarification1" type="radio" value="no" checked="checked" onclick="enablingDisabling(this.id);"/>
                                        <span class="style3">No</span>				</td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Clarification Note : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
        					  <textarea name="clarificationNote" id="clarificationNote" cols="35" class="txt4"></textarea>
        					</span>&nbsp;<a href="#">Copy To</a></td>
        				</tr>
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Reply clarification within : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
        					 <input type="text" name="clarificationDays" id="clarificationDays" value="" size="5"/>
        					</span>&nbsp;days.</td>
        				</tr>
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Attach letter for Clarification Report: </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt">
        					  <input type="file" name="attachClarificationReport" id="attachClarificationReport"/>
        					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
        				</tr>	
        				
        				</g:if>	
        				<g:if test="${inspection==true}">
        				<tr bgcolor="#A8DAF3">
         						<td colspan="2">&nbsp;</td>
         					</tr>
        				<tr >
        				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
        			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
        						<input name="inspection" id="inspection" type="radio" value="yes" onclick="enablingDisablingins(this.id);">
                                        <span class="style3">Yes</span>                              
                                        <input name="inspection" id="inspection1" type="radio" value="no" checked="checked" onclick="enablingDisablingins(this.id);">
                                        <span class="style3">No</span>					</td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#98AFC7" class="headngblue" >Inspection Note : </td>
        			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
        					  <textarea name="inspectionNote" id="inspectionNote" cols="35" class="txt4"></textarea>
        					</span>&nbsp;<a href="#">Copy To</a></td>
        				</tr>	
        				<tr >
        				<td  bgcolor="#98AFC7" class="headngblue" >Reply inspection within : </td>
        			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
        					 <input type="text" name="inspectionDays" id="inspectionDays" value="" size="5"/>
        					</span>&nbsp;days.</td>
        				</tr>	
        				<tr >
        				<td  bgcolor="#98AFC7" class="headngblue" >Attach letter for inspection Report: </td>
        			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt">
        					  <input type="file" name="attachInspectionReport" id="attachInspectionReport"/>
        					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
        				</tr>				
                	 </g:if>
                	 <% if(appFor=='BMW' || appFor=='HWM'){ %>
                	 <g:if test="${appl.inspection==true}">
                	 <g:if test="${inspectionClose==true}">
                	
        				<tr bgcolor="#A8DAF3">
         						<td colspan="2">&nbsp;</td>
         					</tr>
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
        						<input name="inspectionClose" id="inspectionClose" type="radio" value="yes" onclick="enablingDisablinginscl(this.id);">
                                        <span class="style3">Yes</span>                              
                                        <input name="inspectionClose" id="inspectionClose1" type="radio" value="no" checked="checked" onclick="enablingDisablinginscl(this.id);">
                                        <span class="style3">No</span>					</td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
        					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
        					</span>&nbsp;<a href="#">Copy To</a></td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
        				<% def bioMedicalMaster= WasteMasterDataDetails.find("from WasteMasterDataDetails wm where wm.applicationId=?",[applicationProcessingDetailsInstance.applicationId])
        				System.out.println("-----fgf----"+bioMedicalMaster)
        				if(viewDataMaster.size()>0 && bioMedicalMaster){
        				System.out.println("-----invoked---")
        				%>
        				 <td><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popBMWInspectionReport/<%=applicationProcessingDetailsInstance.applicationId%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Prepare Inspection Report&nbsp; </a><% }
        				 
        				else if(appFor=='HWM'){ %>
        				<td><g:link action="popHWMInspectionReport" id="${fieldValue(bean:applicationProcessingDetailsInstance, field: "applicationId")}" target="_blank" params="[id:applicationProcessingDetailsInstance.applicationId]"> <span class="innerlink">&nbsp;Prepare Inspection Report&nbsp;|</span></g:link>
        				
        				<% }%>
        				</td>
        				</tr>				
                	 </g:if>  </g:if><%} else{ %>
                	 
                	 
                	  <g:if test="${appl.inspection==true}">
                	 <g:if test="${inspectionClose==true}">
                	
        				<tr bgcolor="#A8DAF3">
         						<td colspan="2">&nbsp;</td>
         					</tr>
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
        						<input name="inspectionClose" id="inspectionClose" type="radio" value="yes" onclick="enablingDisablinginscl(this.id);">
                                        <span class="style3">Yes</span>                              
                                        <input name="inspectionClose" id="inspectionClose1" type="radio" value="no" checked="checked" onclick="enablingDisablinginscl(this.id);">
                                        <span class="style3">No</span>					</td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
        					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
        					</span>&nbsp;<a href="#">Copy To</a></td>
        				</tr>
        				
        					<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
        					  <input type="file" name="inspectionReport" id="inspectionReport"/>
        					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
        				</tr>				
                	 </g:if>  </g:if>
                	 
                	 
                	 <% }%>
                	 <g:if test="${approve==true}">
        				<tr bgcolor="#A8DAF3">
         						<td colspan="2">&nbsp;</td>
         					</tr>
        				<tr >
        				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to Approve Application ? : </td>
        			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
        						<input name="approve" id="approve" type="radio" value="yes" onclick="enablingDisablingapp(this.id);">
                                        <span class="style3">Yes</span>                              
                                        <input name="approve" id="approve1"  type="radio" value="no" checked="checked" onclick="enablingDisablingapp(this.id);">
                                        <span class="style3">No</span>					</td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#98AFC7" class="headngblue" >Approval Note : </td>
        			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
        					  <textarea name="approveNote" id="approveNote" cols="35" class="txt4"></textarea>
        					</span>&nbsp;<a href="#">Copy To</a></td>
        				</tr>				
                	 </g:if>
                	 <g:if test="${reject==true}">
        				<tr bgcolor="#A8DAF3">
         						<td colspan="2">&nbsp;</td>
         					</tr>
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Reject
        				  Application ? : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
        			 		                           
                              <input name="reject" id="reject"  type="radio" value="yes" onclick="enablingDisablingrej(this.id);"/>
                              <span class="style3">Yes</span>   
                              <input name="reject" id="reject1" type="radio" value="no" checked="checked" onclick="enablingDisablingrej(this.id);">
                              <span class="style3">No</span>					</td>
        				</tr>
        				
        				<tr >
        				<td  bgcolor="#BFBFBF" class="headngblue" >Note : </td>
        			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
        					  <textarea name="rejectNote" id="rejectNote" cols="35" class="txt4"></textarea>
        					</span>&nbsp;<a href="#">Copy To</a></td>
        				</tr>				
                	 </g:if>
        <% 
        def abb=RoleMaster.get(app.role.id.toLong())
        System.out.println("--return power------"+abb.returnPower)
        if(abb.returnPower=='Yes'){
        %>
        				
        			 	 <tr bgcolor="#A8DAF3">
        			 	 <td colspan="2">&nbsp;</td>
        			 	 </tr>
        			 	 <tr >
        			 	 <td bgcolor="#98AFC7" class="headngblue" >Do you want to return application? : </td>
        			 	 <td align="left" bgcolor="#98AFC7" class="headngblue">
        			 	 <input id="returned" name="returned" type="radio" value="yes" ">
        				Yes 
        			  <input id="returned" name="returned" type="radio" value="no" checked="checked" ">
        			  No</td>
        			 	 </tr>
        			 	  
        			 	
        			 	  <tr >
        			                         
        			                      
        			 	 
        			 	 <td bgcolor="#98AFC7" class="headngblue" >Return Description : </td>
        			 	 <td align="left" bgcolor="#98AFC7" class="headngblue">
        			 	 <textarea maxlength="500" id="returnNote" name="returnNote" cols="35"  class="txt4"></textarea>
        			 	 &nbsp;
        			 	<span class="sidetxt ">(Can not contain special characters or reserve words)</span>
        			    </td>
        			    </tr>	  
        			  <% }%>
                        <%}%>
						<!------------------------------  Added By DEEPAK end-------------------------->
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td><input name="appId" type="hidden" value="${app.id}"/></td>
			<td align="right"><input type="submit" name="Save" value="Send Application" class="draftbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          </div>
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>
</body>
</html>


