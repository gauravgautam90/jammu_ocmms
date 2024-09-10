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
<!--start by ajay for text editor-->

<!--end by ajay-->
<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<script type="text/javascript">
function alertselected()
{

var selectmenu=document.getElementById("scrutiny").value;

 if (selectmenu=='In-Complete')
 {
 
  document.getElementById('selectTemp3').style.display = 'block';
  document.getElementById('selectTemp13').style.display = 'block';
  document.getElementById('selectTemp14').style.display = 'block';
  document.getElementById('selectTemp4').style.display = 'block';


}
else
{
document.getElementById('selectTemp3').style.display = 'none';
document.getElementById('selectTemp14').style.display = 'none';
document.getElementById('selectTemp13').style.display = 'none';

document.getElementById('selectTemp4').style.display = 'none';

}
 
}
</script>
<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
<script type="text/javascript">
<!--new function added by shashank-->

function enablingDisablingins(id)
{
	
		var a= document.getElementById(id).value;
		if(a=="yes"){
			
			
			if(document.getElementById("inspectionClose")){
				document.getElementById("inspectionClose").disabled=true;
				document.getElementById("inspectionClose1").disabled=true;
				document.getElementById("inspectionCloseNote").disabled=true;
				document.getElementById("copylink").disabled=true;
				document.getElementById("inspectionReport").disabled=true;
				document.getElementById("copylink1").disabled=true;
				document.getElementById("copylink2").disabled=true;
				document.getElementById('inspectionshow1').style.display = 'block';
				document.getElementById('inspectionclose2').style.display = 'none';
				}
			
			}
		if(a=="no"){
			
			
			if(document.getElementById("inspectionClose")){
				document.getElementById("inspectionClose").disabled=false;
				document.getElementById("inspectionClose1").disabled=false;
				document.getElementById("inspectionCloseNote").disabled=false;
				document.getElementById("copylink").disabled=false;
				document.getElementById("inspectionReport").disabled=false;
				document.getElementById("copylink1").disabled=false;
				document.getElementById("copylink2").disabled=false;
				document.getElementById('inspectionshow1').style.display = 'none';
				
				}
			
			}
		
				
}

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


function hidediv00() {

for(var i = 0; i<document.myForm.noticeType.length; i++){

 if(document.myForm.noticeType){
 
 var radiomenu = document.myForm.noticeType

   	 if (radiomenu.value == "Show Cause") { 
 			
 			
 			document.getElementById('SelectTemp001').style.display = 'none';
			document.getElementById('SelectTemp00').style.display = 'block';
 		
		} 
		else{
	document.getElementById('SelectTemp001').style.display = 'block';
		document.getElementById('SelectTemp00').style.display = 'none';
		
		}
			
	
			} 
	} 
}
function hidediv1() {

for(var i = 0; i<document.myForm.clarification.length; i++){

 if(document.myForm.clarification[i].checked){
 
 var radiomenu = document.myForm.clarification[i]

   	 if (radiomenu.value == "yes") { 
 			
 			
			document.getElementById('SelectTemp12').style.display = 'block';
 		
		} 
		
			
		
		else if (radiomenu.value == "no") { 
 			
 		document.getElementById('SelectTemp12').style.display = 'none';
 			
		} 	

	
		} 
	} 
}


function enablingDisablinginscl(id)
{
	
		var a= document.getElementById(id).value;
		if(a=="yes"){
			
			document.getElementById('inspectionclose2').style.display = 'block';
						
			        }
		if(a=="no") {
			
			document.getElementById('inspectionclose2').style.display = 'none';
					}				
}


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
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
			<tr>		
					<td align="left"><g:def var="appForWhich1" value="${appFor}"/><g:def var="applicationId" value="${appIdStr}"/>
						
						<a href="#" onclick="window.open('<g:createLink action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId,viewCertScn:viewCertScn,wmpappId:app.id]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
<!--code added by shashank for check the instance in bmwinspection-->					  
						<% def wmpdob=WasteManagementPendingDetails.get(params.id)
						   def bioId=wmpdob.applicationId;
						   def bioOb=BioMedicalWaste.get((bioId).toLong())
						   def bmwirr
						   if(bioOb)
						   bmwirr=BMWInspectionReport.find("from BMWInspectionReport bmwir where application=?",[bioOb])
						   if(bmwirr){
						%>
						<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popBMWInspectionReport/<%=appId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" ><span class="innerlink">&nbsp;View Inspection Report &nbsp;|</a>
						
						<%}
						%>
						
<!--code end by shashank-->						
					
						<%
						boolean isNewApplication1=false;
						def HazardeousWasteAuthAppObj=HazardeousAnnualReturnDetails.get(appId)
						def bmwObj=BmwRenew.get(appId)
						if(HazardeousWasteAuthAppObj){%>	
					   	<a href="#" onclick="window.open('<g:createLink  action="showAnnualReturnDetailsCPCC" controller="hazardeousWasteAuthApp" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a>
					   	<%}%>
					   <%	if(bmwObj){%>	
					   	<a href="#" onclick="window.open('<g:createLink  action="showAnnualReturnDetailsCPCC" controller="hazardeousWasteAuthApp" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a>
					   	<%}%>
					   	
						<%if(prepareCertificate){
								if(appFor=='HWM')
								{
									def HWMapp = WasteManagementPendingDetails.find("from WasteManagementPendingDetails apd where apd.applicationId=? and apd.completionStatus='Complete' order by apd.id desc",[appId.toString()])
		       						 if(HWMapp) {
										%><g:link controller="hazardeousWasteAuthApp" action="uploadHWM" id="${appId}"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></g:link><%
												
								        } }	
						        else if(appFor=='MSW'){
						      def refusal = WasteManagementPendingDetails.find("from WasteManagementPendingDetails apd where apd.applicationId=? and apd.completionStatus='Complete' order by apd.id desc",[appId.toString()])
       							 if(refusal) {
								
										if(isRenew=='No')
										{
											%><g:link controller="municipalSolidWaste" action="uploadMunicipalNew" id="${appId}"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></g:link><%
										}
										else
										{
											%><g:link controller="municipalSolidWaste" action="uploadMunicipalReNew" id="${appId}"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></g:link><%
										}
						        } }
						        else 
								{
								def BMWapp = WasteManagementPendingDetails.find("from WasteManagementPendingDetails apd where apd.applicationId=? and apd.completionStatus='Complete' order by apd.id desc",[appId.toString()])
		       						 if(BMWapp) {
										%><g:link controller="bioMedicalWaste" action="uploadBMW" id="${appId}"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></g:link><%
												
								        } }						
							}
						%>
		<!-- View Certificates ------------------------------------------>						
				<%def certUp11 = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='BMW' and afr.typeOfFile='Certificate1' order by afr.id desc",[appId.toLong()])
						if(certUp11){ %>
						<g:link action="viewBMWCert" controller="bioMedicalWaste" id="${appId}" ><span class="innerlink">&nbsp;View Uploaded Certificate&nbsp;|</span></g:link>
						<%}
						def certUpHWM = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='HWM' and afr.typeOfFile='Certificate1' order by afr.id desc",[appId.toLong()])
						if(certUpHWM){
						%>
						<g:link controller="hazardeousWasteAuthApp" action="viewHazCert1"  id="${appId}" ><span class="innerlink">&nbsp;View Uploaded Certificate&nbsp;|</span></g:link>
						<%
						}
						  def viewCert = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='MSW' and afr.typeOfFile='Certificate1' order by afr.id desc",[appId.toLong()])
						if(viewCert){%>
						<g:link controller="municipalSolidWaste" action="viewMunCert1"  id="${appId}" ><span class="innerlink">&nbsp;View Uploaded Certificate&nbsp;|</span></g:link>
							<%}%>
					
						
						</td>	
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                   <g:if test="${flash.userMessage}">
				           				 <div>${flash.userMessage}</div>
				            			</g:if>
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
		
		
		
		
		<g:form name="myForm" id="myForm" action="processApp" enctype="multipart/form-data" method="post" >
<!--added by shashank for industry name and industry id-->		
		      <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs"> 
		         <tr> 
		           <td align="right"  class="txt4">
                         <span class="headngblue" ><font color="grey">Industry Name  :</font><%
                         def indname
                         if(appFor=="HWMAnnualReturn")
                         {
                      indname = HazardeousAnnualReturnDetails.get(appId.toLong())
                       }
                       else if(appFor=="BMWAnnualReturn"){
                       indname = BmwRenew.get(appId.toLong())
                       }
                       
                       %><%=indname.createdBy%></span>
                    </td>
				  </tr>
			<tr>                      
                  <td align="right"  class="txt4">
                     <span class="headngblue" ><font color="grey">Application Id  :   </font> <%= appId%>   </span>                   
                   </td>                 
	        </tr>	  
				  
			 </table>
<!--end-->		
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
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="appId1" value="${app.id}"/><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewOtherAttachedDocument" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',appliFor:appForWhich, appId2:appId1]">View Letter</g:link></td>
                      </tr>
             
 					<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
					<%}%>
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Assign To : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					  <g:select optionKey="id" from="${fwdRoleList}" name="forward" class="txt4" ></g:select>
					 
				</span></span>				</td>
			</tr>	
			
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >File Note : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <textarea name="fileNote" id="fileNote1" cols="40" class="txt4"></textarea>
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
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise clarification / show cause notice ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="clarification" id="clarification" type="radio" value="yes" onclick="hidediv1();"/>
                                <span class="style3">Yes</span>                              
                                <input name="clarification" id="clarification" type="radio" value="no" checked="checked" onclick="hidediv1();"/>
                                <span class="style3">No</span>				</td>
			</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp12">
                         <table width="100%" cellpadding="0" cellspacing="0">
       <tr>
				<td  bgcolor="#BFBFBF" class="headngblue" >Notice Type : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
			<g:select from="${['Clarification','Show Cause']}" name="noticeType" class="txt4" onchange="hidediv00();"></g:select>					</span>&nbsp;</td>
			</tr>	
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Clarification / Show Cause Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="clarificationNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#"></a></td>
			</tr>
			<tr >
                         <td colspan="2">
                         <div  id="SelectTemp001">
                         <table width="100%" cellpadding="0" cellspacing="0">
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Reply clarification / show cause within : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					 <input type="text" name="clarificationDays"  size="5"/>
					</span>&nbsp;days.</td>
			</tr> </table></div></td></tr>
			<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Attach letter for Clarification / Show Cause Report: </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt">
					  <input type="file" name="attachClarificationReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 5MB in size)</span>	&nbsp;<a href="#"></a></td>
				</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp00">
                         <table width="100%" cellpadding="0" cellspacing="0">
                      <%if(prepareCertificateScn){%>
					<tr>
			         <td colspan =2 align="center" bgcolor="#BFBFBF"  > 
                                   	
                           	
                                   <%  if(appFor == "BMW" ){  %>	
                                   	
                                   			<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/scnCertificate?appliId=<%=app.id%>"><span class="innerlink">&nbsp;<u>Prepare SCN (BMW) For Refusal</u>&nbsp;</span></a>
                            <%	if(viewCertScn){%>
							<g:link action="downLoadingCertificateForScnBmw"  id="${app.id}" ><span class="innerlink">&nbsp; <u>View SCN(BMW) For Refusal</u>&nbsp;</span></g:link>
	
	</td> <td colspan =2 align="center" bgcolor="#BFBFBF"  > 
		<%}}}%>
				</table></div></td></tr>
				 </table></div>
</td>
				</g:if>
				
       </tr>	
				<g:if test="${inspection==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
	<!--start div-->		<div id="raisinspection" bgcolor="red">	<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="inspection" id="inspection" type="radio" value="yes" onclick="enablingDisablingins(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="inspection" id="inspection1" type="radio" value="no" checked="checked" onclick="enablingDisablingins(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
<!--tr strat to hide inspection-->				
				
				<tr>
				 <td colspan="2">
				 <div  style="display:none; border:0;"  id="inspectionshow1">
                  <table width="100%" cellpadding="0" cellspacing="0">
				
				
				
				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
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
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To1</a></td>
				</tr>	
	<!-- end div-->			</div>	
	
	      </table>
        	 </div>
        	 </td>
 <!--tr end-->       	 </tr>
			
        	 </g:if>
        	 
        	 
        	
        	 
        	 
        	 
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
				
<!--tr added for hide-->	<tr >
                            <td colspan="2">
                            <div  style="display:none; border:0;"  id="inspectionclose2">
                            <table width="100%" cellpadding="0" cellspacing="0">			
				
				
				
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a id="copylink" href="#">Copy To</a>
					<br>
				<a id="copylink1" href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/submitInspectionReport/<%=appId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" ></a></td>
					
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <input type="file" name="inspectionReport" id="inspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a id="copylink2" href="#">Copy To</a></td>
				</tr>	
				
				
				
				
                 	    </table>
                          </div>
                           </td>
 <!--tr end for hide-->     </tr>			
				
				
				
							
        	 </g:if>

  <g:if test="${approve==true}">
                   <tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
  
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to close Application? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="approve" id="approve" type="radio" value="yes" onclick="enablingDisablingapp(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="approve" id="approve1"  type="radio" value="no" checked="checked" onclick="enablingDisablingapp(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
  			
        	 </g:if>
          </table>						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td><input name="appId" type="hidden" value="${app.id}"/></td>
			<td align="right"><input type="submit" name="Save" value="Save" id ="save" onclick="return myFunction()" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset"  id ="reset" onclick="return myFunction()"class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          </div>
          <script>
          function myFunction() {
          document.getElementById('save').style.display = 'none';
          document.getElementById('reset').style.display = 'none';

          } 
          </script> 
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


