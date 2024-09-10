<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<g:javascript library="prototype" />
		
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
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





</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
//window.onload = function() {
 //alert("coucou"); 
//}
</script>
</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
     
     
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
           
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              

				</td>
              </tr>
           
             <%def scru = WasteManagementPendingDetails.find("from WasteManagementPendingDetails apd where apd.applicationId=?",[bioMedicalWasteInstance.toString()])
					String cont=request.getContextPath();			
						def certInst = RecordCertificateBMW.find("from RecordCertificateBMW afr where afr.application=?",[bioMedicalWasteInstance])
		if(certInst){

			viewCert = true
		}%>
		<g:def var="appForWhich1" value="BMW"/><g:def var="applicationId" value="${bioMedicalWasteInstance.id}"/>
		
             	<td height="24">
								<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
                                
if(userType.equals("admin")) { 
System.out.println("Inside admin");
%>
 
              <a href="#" onclick="window.open('<g:createLink controller="bmwWasteProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>  
             
          
                <% 
						   
						   def bmwirr=BMWInspectionReport.find("from BMWInspectionReport  where application.id=? order by id desc",[bioMedicalWasteInstance.id])
						   
						   if(bmwirr){
						%>
						<a href="<%=request.getContextPath()%>/bmwWasteProcessingDetails/downloadInspectionReport?appliId=<%=bioMedicalWasteInstance.id%>"><span class="innerlink">&nbsp;View Inspecion Report&nbsp;|</span></a> 
						<%}%>
	
<%
if(viewCert){%>
<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
<%}%>
 <% if(scru){
		if(scru.scrutinyStatus=="In-Complete") {%>
				<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="viewScrutiny" params="[id:bioMedicalWasteInstance.id,applName:'BMW']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=200,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Scrutiny Incomplete Reason&nbsp;</span></a>
  <%}}}							
				
	if(userType.equals("employee") && scru.applicationStatus!='pending') { 	
	System.out.println("Inside employee");
	%>
          <a href="#" onclick="window.open('<g:createLink controller="bmwWasteProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
        
           <% 
						   
						   def bmwirr=BMWInspectionReport.find("from BMWInspectionReport  where application.id=? order by id desc",[bioMedicalWasteInstance.id])
						   
						   if(bmwirr){
						%>
						<a href="<%=request.getContextPath()%>/bmwWasteProcessingDetails/downloadInspectionReport?appliId=<%=bioMedicalWasteInstance.id%>"><span class="innerlink">&nbsp;View Inspecion Report&nbsp;|</span></a> 
						<%}%>
						
		<%if(bioMedicalWasteInstance.applicationStatus!="Inprogress"){
				
						// added by sharvan start
						
						def instanceForApprovalInstance1=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails  where applicationId=? and (approvalStatus= 'Approved' or approvalStatus= 'Refused') order by id desc",[(bioMedicalWasteInstance.id).toString()])
	                  	System.out.println("instanceForApprovalInstance1============"+instanceForApprovalInstance1);
	                  	System.out.println("instanceForApprovalInstance1============"+instanceForApprovalInstance1);
	                   	if(instanceForApprovalInstance1){
	                  	if(instanceForApprovalInstance1.approvalStatus=="Approved"){
	                  		System.out.println("Inside approvalStatus============"+instanceForApprovalInstance1.approvalStatus);
	                  		def RecordCertificateBMWObj = RecordCertificateBMW.find("from RecordCertificateBMW abc where abc.application=?",[bioMedicalWasteInstance])
                        if(RecordCertificateBMWObj){  
                        %>	
                        <g:link controller="bmwWasteProcessingDetails" params="[docName:appForWhich1,appliId:applicationId]" action="downloadAuthorisationOrder"  id="${bioMedicalWasteInstance.id}" ><span class="innerlink">&nbsp;View Authorization certificate&nbsp;|</span></g:link>
                        <%
                       
	                  }}else{%>
	                  <g:link controller="bmwWasteProcessingDetails" params="[docName:appForWhich1,appliId:applicationId]" action="downloadRefusalOrder"  id="${bioMedicalWasteInstance.id}" ><span class="innerlink">&nbsp;View Refusal Certificate&nbsp;|</span></g:link>
	                  <%}}}%>
						
		           
		              <% //def RecordCertificateBMWObj = RecordCertificateBMW.find("from RecordCertificateBMW abc where abc.application=?",[bioMedicalWasteInstance])
                        //if(RecordCertificateBMWObj){  %>
                        	
                        <!--<g:link controller="bmwWasteProcessingDetails" params="[docName:appForWhich1,appliId:applicationId]" action="downloadAuthorisationOrder"  id="${bioMedicalWasteInstance.id}" ><span class="innerlink">&nbsp;View Authorization certificate&nbsp;|</span></g:link>-->
                             
		           
		           <%//}%> 
					
						
	
<%
if(viewCert){%>
<!--<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>-->
<%}%>
 <% if(scru){
		if(scru.scrutinyStatus=="In-Complete") {%>
				<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="viewScrutiny" params="[id:bioMedicalWasteInstance.id,applName:'BMW']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=200,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Scrutiny Incomplete Reason&nbsp;</span></a>
  <%}}}}%>     
           <%if((IndUser)session.getAttribute("indUser")) { %>
  
 <%if(bioMedicalWasteInstance.applicationStatus!="Inprogress"){
		           
		               // added by sharvan start
						
						def instanceForApprovalInstance1=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails  where applicationId=? and (approvalStatus= 'Approved' or approvalStatus= 'Refused') order by id desc",[(bioMedicalWasteInstance.id).toString()])
	                  	System.out.println("instanceForApprovalInstance1============"+instanceForApprovalInstance1);
	                  	System.out.println("instanceForApprovalInstance1============"+instanceForApprovalInstance1);
	                   	if(instanceForApprovalInstance1){
	                  	if(instanceForApprovalInstance1.approvalStatus=="Approved"){
	                  		System.out.println("Inside approvalStatus============"+instanceForApprovalInstance1.approvalStatus);
	                  		def RecordCertificateBMWObj = RecordCertificateBMW.find("from RecordCertificateBMW abc where abc.application=?",[bioMedicalWasteInstance])
                        if(RecordCertificateBMWObj){  
                        %>	
                        <g:link controller="bmwWasteProcessingDetails" params="[docName:appForWhich1,appliId:applicationId]" action="downloadAuthorisationOrder"  id="${bioMedicalWasteInstance.id}" ><span class="innerlink">&nbsp;View Authorization certificate&nbsp;|</span></g:link>
                        <%
                       
	                  }}else{%>
	                  <g:link controller="bmwWasteProcessingDetails" params="[docName:appForWhich1,appliId:applicationId]" action="downloadRefusalOrder"  id="${bioMedicalWasteInstance.id}" ><span class="innerlink">&nbsp;View Refusal Certificate&nbsp;|</span></g:link>
	                  <%}}}%>
						
 
		         
<%if(viewCert){%>
<!--<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>-->
<%}%>
 <% if(scru){
		if(scru.scrutinyStatus=="In-Complete") {%>
				<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="viewScrutiny" params="[id:bioMedicalWasteInstance.id,applName:'BMW']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=200,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Scrutiny Incomplete Reason&nbsp;</span></a>
  <%}}}%>   
        
        
           
              <tr>
                <td height="0" align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                    <span class="error"> 
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${bioMedicalWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${bioMedicalWasteInstance}" as="list" />
            </div>
            </g:hasErrors>
            </span>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="33" align="left" valign="top">&nbsp;</td>
                            <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
			 
    <br/>
    <g:form name="myform" action="editNewFormat"  method="post" >
    <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
    <input type="hidden" name="bioMedId" value="${bioMedicalWasteInstance?.id}" />
    
   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>General Details</span></a></li>
						<li><a href="#country2"><span>Bio-Medical Waste Generation Details</span></a></li>
						<li><a href="#country5"><span>Bio-Medical Waste Management Details</span></a></li>
						<li><a href="#country3"><span>BMW Treatment Equipments details</span></a></li>
						<li><a href="#country7"><span>Fee</span></a></li>
						<li><a href="#country4"><span>Documents</span></a></li>
					</ol>
				  </td>
				   <g:if test="${bioMedicalWasteInstance?.completionStatus=='Completed'}">
				  <td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/bioMedicalWaste/viewBmwPdf?appliLoc=<%=bioMedicalWasteInstance?.id%>"><span class="headngblue">Print Form</span></a></td>
				</g:if>
				</tr>	
	    </table>
     
          <% System.out.println("Insideeeee jsp block"+bioMedicalWasteInstance) 
      def bioMedicalWasteInst =BioMedicalWaste.find("from BioMedicalWaste where id=?",[bioMedicalWasteInstance.id]) 
           System.out.println("Query Executedddd>>>"+bioMedicalWasteInst)%>
         
    <!--+++++++++++++++++++++++++++++++++++ ////-->
    
     <div class="content" id="country1" >
		   <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   <!- added by sharvan as per new bmw rules 2016 -->
		   <!--<tr>
					<td   align="center" valign="middle" bgcolor="#D1D1D1" colspan=2 class="headngblue">Applicant Details</td>
					
			</tr>
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Applicant Name <span style="color:red">*</span>: </td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstance?.occName} 
					
					</td>
				</tr> 
			
		      <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation<span style="color:red">*</span>: </td>
					<%  def occupierDesignation=indRegInstance.occDesignation
                  		System.out.println("Industry reg master iddddd issss>>>"+occupierDesignation)
                  		if(occupierDesignation.equalsIgnoreCase("Others")){
                 	 %>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstance?.otherOccDesignation}
					</td>
					<%} 
				  else {%>
				  <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstance?.occDesignation}
					 </td>
					 <%}%>
					
			</tr> 
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name: </td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indName}
					</td>
			</tr> 
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indAddress}
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.category}
					</td>
			</tr> 
		       
		   
		 
			
			<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Type: </td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.industryType}
					</td>
				</tr> -->
				<!-- added by sharvan for new bmw rules 2016 end here -->
			
          <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Wheather your HCF/CBMWTF generates/handles Bio-Medical Wastes</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Yes
					  
					</td>
			</tr> 
			
		<tr>
			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> BMW Authorization now Applied For <span style="color:red">*</span> :</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			<g:if test="${bioMedicalWasteInst?.authorisationAppliedFor =='fresh'}">
			Fresh
			</g:if>
			<g:else>
			Renewal
			</g:else>
					  
		</td>
			</tr> 
	<!-- ################## For previous Authorisation Table ################ -->	
		<g:if test="${bioMedicalWasteInst?.authorisationAppliedFor=='renew'}">
		    <tr>
		 	<td  align="right" class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"><span class="headngblue">View</span></a></td> 
		 	</tr>
		 </g:if>
		
			
		  <tr>
		  <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
			 <label for="activityAuthorizationSoughtFor">Activity for which Authorization is required for<span style="color:red">*</span>:</label>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.activityAuthorizationSoughtFor}
					  
		</td>
			</tr> 
			
	
	
		   </table>
		   
         
		   
		   </div>
    <!--#############country1 end here ################-->
   
   <!-- ################## div country 2 starts from here ################-->
         <div class="content" id="country2" >
         
		  <table class="tblbdr">
                        <tbody>
                        	<input type="hidden" name="nameAddressInstitution" id="nameAddressInstitution" value="">
				<input type="hidden" name="nameOfApplicant" id="nameOfApplicant" value="">
								<input type="hidden" name="nameOfInstitution" id="nameOfInstitution"> 
					 
	  <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">HCF/CBMWTF Type <scope style="color:red">*</scope></td>
        <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.hcfType}
        
      </td>                             
       </tr>
      <% if(bioMedicalWasteInst.hcfType.equals("HCF")){%>    
     <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td>
       <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.hcfTypeMenu}
        
      </td>                             
       </tr>
      <%}%>
   <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Bio-Medical Waste Facility Status <scope style="color:red">*</scope></td>
       <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.bmwfacility}
       
     </td> 
   </tr>
   
   <!-- added by sharvan as per new bmw rules start from here-->
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue" rowspan="2">CBMWTF- location and Office address of  treatment and disposal <scope style="color:red">*</scope></td></td>
        <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.wastelocationaddress}
        
     </td> 
   </tr>
   
   
   <tr>  
        <!--<td align="left" bgcolor="#A8DAF3" class="headngblue">Address of the location of the common  facility <scope style="color:red">*</scope></td></td>-->
       <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.bmwstatus}
      </td>
   </tr>
 
   <!-- code commented by sharvan as per new bmw rules
   <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Address of the place of disposal of wastes <scope style="color:red">*</scope></td></td>
         <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
        </td> 
   </tr>-->
   
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Mode of Transportation of BMW </td></td>
        <td   align="left" bgcolor="#E8F6F9"  class="headngblue">Common Facility Vehicle</td>
   </tr> 
   
   <!--Added by sharvan start from here-->
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of CTE/CTO-latest consent type, issued date and validity date </td>
      	<td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.statusCteCto}</td>
   </tr> 
    
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">GPS Coordinates -Lat/Lon of the location of applicant facility (in Decimal degrees with 6 decimals):
		</br>Ex: Latitude: 8.123456 N, 12.236544 N, etc
		</br>
		Longitude: 77.235648 E, 78.253674 E,etc
		 </td>
        <td  bgcolor="#E8F6F9" bgcolor="#E8F6F9" class="headngblue">Latitude &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioMedicalWasteInst?.latitude}&nbsp;&nbsp;N Decimal Degrees&nbsp;&nbsp;</br>
        Longitude  &nbsp;&nbsp;&nbsp; ${bioMedicalWasteInst?.longtitude} &nbsp;&nbsp;E Decimal Degrees
   </tr> 
   
   <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Details of directions or notices or legal actions if any during the period of earlier authorisation (Attach documents if any) </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.detailsOfDirections}</td>
   </tr>
   
   
    
   <!-- added by sharvan end here-->     
 
         
     </td> 
   </tr>
   <!-###########################added by sharvan start-->
   <% if(bioMedicalWasteInst.hcfType.equals("HCF")){%>
      <table class="tblbdr" width="100%" align="center">
   <tr>  
        <td colspan="3" align="center" bgcolor="#A8DAF3" class="headngblue">Details of Activity & Facility status-For HCF only </td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
        
     <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">a).	Medical treatment Facility provided to Outpatients</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.outpatientsFacility}   </td>
      <td align="left" class="headngblue"  bgcolor="#E8F6F9">Nos./Day</td>
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">b).	Medical treatment Facility provided to Inpatients</td>
     <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.inpatientsFacility} </td>
      <td align="left" class="headngblue"  bgcolor="#E8F6F9">Nos./Day</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">c).	No of Beds of HCF</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue"> ${bioMedicalWasteInst?.noofbeds} </td>
      <td align="left" class="headngblue"  bgcolor="#E8F6F9">Nos.</td>
   </tr> 
 <!-- code commented by sharvan as per new bmw rules start from here 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d).	Others (specify)</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue"> ${bioMedicalWasteInst?.other1}</td><td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.other2}</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e).	Total number of inpatients & outpatients treated per month in the HCF</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.patientspermonth}</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f).	No of Needle destroyers/cutters in the HCF</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue"> ${bioMedicalWasteInst?.destroyer}</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">g). Whether the Colour coded bins has provided (ward wise) as prescribed in BMW rules</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.bmwrules1}</td>
   </tr>-->
   
   <!-- code changed by sharvan as per new bmw rules -->
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d).	For Non bedded Hospital (Specify)</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue"> ${bioMedicalWasteInst?.noOfNonBeds}</td><td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.noOfNonBeds1}</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e).	Total number of inpatients & outpatients treated per month in the HCF</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.noOfInOutPatients}</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f).	Whether the colour coded bags or containers has been provided for collection and segregation of BMW as prescribed in BMW rules?</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue"> ${bioMedicalWasteInst?.colorCodedBags}</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">g). Details of training conducted to the paramedical staff/sanitary workers in the BMW management</td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.detailsOfTraining}</td>
   </tr>
    
 </table>
 <%
 
 %>
 <table class="tblbdr" width="100%" align="center">
 <%
 }
 if(bioMedicalWasteInst.hcfType.equals("CBMWTF")){
 %>
  <tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">Details of Facility status-For CBMWTF Only</td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
    
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">a). No of HCFs covered by the CBMWTF </td>
     <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.NoofHCF}</td>
   </tr>     
 <!-- code changed by sharvan as per new BMW rules -->
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">b). No of beds covered by the CBMWTF </td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.noOfBedsCbmwtf}</td>
   </tr>
   
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">c). Installed treatment and disposal capacity of CBMWTF <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.treatmentAndDisposal}</td>
   		<td align="left" bgcolor="#E8F6F9" class="headngblue">Kg/day</td>
   </tr>	
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d). Quantity of BMW treated or disposed by CBMWTF <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.qtyOfBmwTreated}</td>
   		<td align="left" bgcolor="#E8F6F9" class="headngblue">Kg/day</td>
   </tr>
 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e). Jurisdictional area and distance covered by the CBMWTF  <scope style="color:red">*</scope></td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.Jurisdictionalarea}</td>
   </tr>
   
   <!-- code added by sharvan for new bmw changes as pre new rules -->
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f). Contingency (future upgradation) plan of CBMWTF(Attach documents if any)  <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.contingencyPlan}</td>
   </tr>
   
  
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">g). Details of training conducted to the paramedical staff/sanitary workers in the BMW management  <scope style="color:red"></scope></td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.detailsOfTraining}</td>
   </tr>
  
   <!--<tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">c)  Total quantity for which Authorisation is required to handle the BMW in CBMWTF  <scope style="color:red"></scope></td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue">${bioMedicalWasteInst?.detailsOfTraining}</td></tr>-->

   <!--<tr>
		<td colspan="3">														
	<div id="authorization" >
		
		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="50%" align="center" class="headngblue">T/Day</td>
             <td  width="50%" align="center" class="headngblue">T/Month</td>
              </tr>
             <tr>
          <td  align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.authorisationDay}</td>
              <td align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.authorisationMonth}</td>
            
               
                             </table>
														    									
	</br>	
			</div>													
			    </td>
              	</tr>-->
      
       
     
   <!--</tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d)  No of Shredders in CBMWTF <scope style="color:red">*</scope></td>
     <td   align="left" bgcolor="#E8F6F9"  class="headngblue">  
      </td>
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e) Onsite APC measures provided for Incinerators and other emission sources in CBMWTF <scope style="color:red">*</scope></td>
      <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
      </td>
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f) Onsite ETP for liquid wastes in CBMWTF <scope style="color:red">*</scope></td>
     <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
      </td>
   </tr>
   
    <tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">g) Status of treated BMW disposal quantity in CBMWTF <scope style="color:red">*</scope></td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>-->
  
     <!-- <tr>
		<td colspan="3">	
		
		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="15%" align="center" class="headngblue">Waste Category Description</td>
             <td  width="15%" align="center" class="headngblue">Disposal Method </td>
             <td  width="15%" align="center" class="headngblue">Quantity in T/day</td>
              <td  width="15%" align="center" class="headngblue">Quantity in T/Month</td> 
              </tr>
             <tr>
           <td align="left" bgcolor="#E8F6F9"  class="headngblue">Incineration Ash from Cat.1,2,3,5,6& 10.</td>
              <td align="left" bgcolor="#E8F6F9"  class="headngblue">Dedicated SLF</td>
             <td align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.quantityperDay} </td>
            <td align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.quantityperMonth}  </td>
           
               </tr>
               
               <tr>
          <td align="left" bgcolor="#E8F6F9"  class="headngblue">Shredder Solid Watses from Cat.4 & 7</td>
           <td align="left" bgcolor="#E8F6F9"  class="headngblue">Sold to recyclers</td>
           <td align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.quantityperDay1}   </td>
          <td align="left" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.quantityperMonth1}  </td>
           
               </tr>
               
              </table>
		</br>													
			    </td>
              	</tr>-->
   <%
 }
 %>
  
  <!--<tr> <td align="center" bgcolor="#A8DAF3" class="headngblue">Whether all the paramedical staff/sanitary workers are trained in the Bio Medical Waste Management?</td>
       <td   align="center" bgcolor="#E8F6F9"  class="headngblue">${bioMedicalWasteInst?.authapply}</td>
      </tr>-->
  
  
  <!--<tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">Status of issue of Consent under Water and Air Acts Please enter the details of issued consents:(Attach copies  of Consents)</td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
   
     <tr>
		<td colspan="3">														
	<div id="authorization" >
		
		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="15%" align="center" class="headngblue">Date of Application for Consent</td>
             <td  width="15%" align="center" class="headngblue">Consent Type </td>
              <td  width="15%" align="center" class="headngblue">Issued date</td> 
              <td  width="15%" align="center" class="headngblue">Valid date</td>  
              </tr>
            
             <tr>
           <td><input type="text" name="consentDate" placeholder="dd/mm/yyyy"></td>
              <td><span class="headngblue"><select name="HWAType" id="menu" class="txt4" onchange="change1();">
			<option  value="Fresh">Fresh</option>
			<option  value="Renewal">Renewal</option>
			</select></span>
			</td>
             <td><input type="text" name="Issued_date" placeholder="dd/mm/yyyy"></td>
            <td><input type="text" name="Valid_date" placeholder="dd/mm/yyyy"></td>
               </tr>
                             </table>
														    									
	</br>	
			</div>													
			    </td>
              	</tr>
    
    -->
     
      </td>
       </tbody>
          </table>    
                  </div>
		   
		
		   <!-- ################### Country2 Ends here ################# -->
		   <!-- ################### New Div Added By Sharvan This is Country3 ################# -->
		   
		    <div class="content" id="country3">
		    <!-- added by sharvan start from here -->
		    <table width="50%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#A5CAF4" class="center">
    		<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#A5CAF4" class="center" >
    		
    		<tr bgcolor="#A8DAF3" align="left" class="headngblue">
			<td align="left" colspan="4" bgcolor="#E8F6F9" class="headngblue">	Details of Treatment Equiments available for treatment of Bio-Medical Waste</td>
			</tr>
  			
  			<tr align="left" bgcolor="#FFFFFF" >
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue" >SI No.</th>
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Treatment equipment</th> 
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">No of Units</th>
      		<!--<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Quantity handled in Kg/Month</th>
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Treatment and Disposal</th>-->
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Type and capacity of each unit</th>
      		</tr> 
      		
      		<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>1</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Incinerators </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.incinrators}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.incinratorsType}</td>
   			</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>2</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Plasma Pyrolysis </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.plasmaPyrolysis}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.plasmaPyrolysisType}</td>
   			</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>3</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Autoclaves </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.autoclaves}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.autoclavesType}</td>
   			</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>4</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Microwave </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.microwave}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.microwaveType}</td>
   			</tr>   
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>5</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Hydroclave </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.hydroclave}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.hydroclaveType}</td>
   			</tr>                          
            
            <tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>6</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Shredders </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.shredders}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.shreddersType}</td>
   			</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>7</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Needle tip cutter or destroyer </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.needleTipCutter}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.needleTipCutterType}</td>
   			</tr>  
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>8</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Sharp encapsulation or Concrete pit </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.sharpEncapsulation}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.sharpEncapsulationType}</td>
   			</tr>  
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>9</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Deep burial pits </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.deepBurial}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.deepBurialType}</td>
   			</tr>  
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>10</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Chemical disinfection </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.chemDisinfection}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.chemDisinfectionType}</td>
   			</tr>  
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>11</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Any other treatment equipment </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.anyOtherTretmntEquip}</td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.anyOtherTretmntEquipType}</td>
   			</tr>              
		    
		    
		    <!-- added  y sharvan ends here -->
		  
		 <!-- <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">	
		  <tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">BMW Authorisation Fee Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hospitals/Common Facility Located in area within </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">BMWA fee(Rs)
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Municipal Corporations </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1500
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Selection Grade & Special Grade Muncipalities</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1000
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Other Muncipalities</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">750
				  </td>
				</tr> 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Town Panchayats,Panchayat Unions and other local bodies if any</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">500
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"></td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
				  </td>
				</tr> 
				
				<% // def industryRegId=bioMedicalWasteInstance.industryRegMasterObj
                  //System.out.println("Industry reg master iddddd issss>>>"+industryRegId)
                 //def localBodyType1 =industryRegId.localBodyType.localBodyTypeName
				   // System.out.println("localBodyType issss>>>"+localBodyType1) %>
				
				<!-- Added by sharvan
				<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">BMW Authorisation Fee Applicable Rs.</td>
					
					<% //if(localBodyType1.equalsIgnoreCase("Municipality")){%>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1500
				  </td>
				  <% //} else if((localBodyType1.equalsIgnoreCase("Others")) || (localBodyType1.equalsIgnoreCase("Corporation"))){%> 
				
			        <td  align="left" bgcolor="#E8F6F9"  class="headngblue">1000
				  </td>
				  
				  <%// }else{%> 
				      <td  align="left" bgcolor="#E8F6F9"  class="headngblue">500
				  </td>
				   <% //}%>
				
				 </tr>--> 
				
				
				<!--<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reason for deviation in payment</td>
				   <td><span style="color: white">	</span> </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">BMW Authorisation Fee Remitted now </td>
					 <td><span style="color: white"></span>  </td>
				  
				</tr>--> 
				
				</table>
				
					
				
				
	
			  
			
				<!--<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>-->
				
				<!--<tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<tr>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
				   </tr>
					</table>
					</td>
				</tr>-->  
	      </table>
	
			</table>
		</div>
		  <div class="content" id="country7">


			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
				style="border-collapse: collapse;">
				<tr>
					<td bgcolor="#FFFFFF">
					<table width="100%" border="0" align="left"
						cellpadding="2" cellspacing="1" class="tblbdr">

						<tr bgcolor="#D1D1D1">
							<td colspan="2" align="center" valign="middle"
								class="headngblue">Fee Details</td>
						</tr>
						<%
def cate = IndustryRegMaster.findById(indRegInstance.id.toLong())
def value = indRegInstance.indCapInvt.toInteger()
def pattii=indRegInstance.indCapInvt.toInteger()
def etc=indRegInstance.extraFacilities
%>
						<tr>
							<td width="60%" align="left" valign="middle"
								bgcolor="#A8DAF3" class="headngblue">Category:</td>
							<td width="40%" align="left" bgcolor="#E8F6F9"
								class="headngblue">${cate.category.name}</td>
						</tr>
							
							
	
							<%if(cate.category.name.equals("HOSPITAL")) {%>
							
							<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Extra Facilities If Any:</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
							field:'extraFacilities')}-
							<%if(etc){%>
							
							${fieldValue(bean:indRegInstance,
							field:'anyOther')}
							
							<%}%>
							</td>
						</tr>
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">No of Beds:</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
						</tr>
						
						
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Patients per month::</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${pattii}</td>
						</tr>
							
						<%}%>
						
						
						
							
							<%if(cate.category.name.equals("LAB")) {%>
							
							
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Samples per year :</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
						</tr>
						<%}%>
						
						
							<%if(cate.category.name.equals("CLINIC")) {%>
							
							
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Patients:</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
						</tr>
						<%}%>
						
						
							<%if(cate.category.name.equals("VETERINARY")) {%>
							
							
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Patients  :</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
						</tr>
						<%}%>
						
						
							<%if(cate.category.name.equals("BLOOD BANK")) {%>
							
							
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Samples :</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
						</tr>
						<%}%>
						
						<%if(cate.category.name.equals("DENTAL CLINIC")) {%>
							
							
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Patients :</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
						</tr>
						<%}%>

						<%if(cate.category.name.equals("CBWTF")) {%>
							
							
							
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Average Number of Chairs :</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
							field:'indCapInvt')}</td>
						</tr>
						<%}%>
						
						<%
						def consentFeeMasterInst = ConsentFeeMasterBMW.findByApplication(bioMedicalWasteInstance)
						%>
						<tr>
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Number of Years:</td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'noOfYears')}</td>
						</tr>
						<tr>
						
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Total Fee Applied </td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'calculatedFee')}<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
						</tr>
	
	
	
													<tr bgcolor="#D1D1D1">
							<td colspan="2" align="center" valign="middle"
								class="headngblue">Bank Details</td>
						</tr>


<%

def feesOnline = FeeBankOtherDetailsBMW.find("from FeeBankOtherDetailsBMW fee where fee.application=?",[bioMedicalWasteInstance])
def feesBank = FeeBankDetailsBMW.find("from FeeBankDetailsBMW fee where fee.application=?",[bioMedicalWasteInstance])


def feesBankOnline = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW fee where fee.bioApplication=? and fee.transactionStatus='S' order by id desc",[bioMedicalWasteInstance])
//def feesBankOnline;


%>





						<tr>
							<td colspan="2">
							<table width="100%" border="0">
								<tr>

									<td width="10%" class="headngblue" align="center"><a
										href="#"
										onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeOtherDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
									View </a></td>

								</tr>
							</table>
							</td>
						</tr>
<%if(feesBank) {%>
					
					
						<tr>
							<td colspan="2">
							<table width="100%" border="0">
								<tr>

								<td width="10%" class="headngblue" align="center">Bank Draft Details</td>
									
									<td width="10%" class="headngblue" align="center"><a
										href="#"
										onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
									View </a></td>

								</tr>
							</table>
							</td>
						</tr>

					<%}%>
					
					<%if(feesBankOnline) {%>
						<tr>
							<td colspan="2">
							<table width="100%" border="0">
								<tr>

								<td width="10%" class="headngblue" align="center">Online Payment Details</td>
									
									<td width="10%" class="headngblue" align="center"><a
										href="#"
										onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popChallan/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
									View Challan </a></td>

								</tr>
							</table>
							</td>
						</tr>

					<%}%>
	




					


					</table>


					</td>
				</tr>
			</table>



			<br />
												</div>
												
												
		   <!-- ############### ENDSSSSSSSSSSSSSSSSSSSSSS ######################### -->
		   <!-- ############### DIV COUNTRY 5 STARTS FROM HERE ######################### -->
		   <!-- changes made by sharvan as per new bmw rules -->
		   <div id="country5" class="content">
     <table width="50%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center" >
    <tr bgcolor="#A8DAF3" align="left" class="headngblue">
			<td align="left" colspan="4" bgcolor="#E8F6F9" class="headngblue">	Quantity of BMW handled, treated or disposal</td>
	</tr>
  <tr align="left" bgcolor="#FFFFFF" >
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue" >Category</th>
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Type of Waste</th> 
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Quantity Generated or collected in Kg/day</th>
      <!--<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Quantity handled in Kg/Month</th>
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Treatment and Disposal</th>-->
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Method of Treatment and Disposal as per Schedule-I</th>
      </tr>                           
      
      
      <tr> 
      <td align="left"  bgcolor="#E8F6F9" rowspan="8" class="headngblue"><b>Yellow</b></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>a) Human Anatomical Waste <scope style="color:red"></scope></b></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.anatomicalwaste}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>CBMWTF</b></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>Incineration</b></td>
    </tr>
    
     <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>2</b></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>b) Animal Waste <scope style="color:red"></scope></b></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.animalwaste}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>CBMWTF</b></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>c) Soiled Waste </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.soiledwaste}</td>
    <!-- <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span ><b>4</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span ><b>d) Expired or Discarded Medicines </b> <scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.discardedwaste}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span ><b>5</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>e) Chemical Solid Waste </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.discardedwaste}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration </b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>6</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>f) Chemical Liquid Waste </b> <scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.chemicalLiquidWaste}</td>
    <!-- <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Onsite ETP to treat and conform to the discharge standards</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>7</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>g)Discarded linen, mattresses, beddings contaminated with blood or body fluid </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.discardedLinen}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Disinfection followed by  Incineration</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>8</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>h)Microbiology,  Biotechnology and other clinical laboratory waste </b><scope style="color:red"></scope> </span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.otherClininLabWaste} </td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Sterilisation followed by  Incineration</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Red</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Contaminated waste (Recyclable) </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.contaminatedwaste}</td>
    <!-- <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Does not arise</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Autoclaving followed by shredding. Treated waste to be sent to Authorised recyclers or for energy recovery or plastic to Diesel or fuel oil or for road making</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>White( Translucent)</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Waste sharps including Metals </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.wasteSharps}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>-->
     
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Autoclaving followed by shredding. Treated waste to be sent to Iron foundries or sanitary landfill or designated concrete waste sharp pit.</b></span></td>
    </tr>
    
    <tr> 
      <td rowspan="2" align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Blue</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Glassware </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.glassWare}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Autoclaving followed by shredding. Treated waste to be sent to Iron foundries or sanitary landfill or designated concrete waste sharp pit.</b></span></td>
    </tr>
    
    
    <tr> 
      <!--<td rowspan="2" align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Blue</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Metallic Body Implants </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.metallicBodyImplants}</td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b></b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b></b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Total</b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue">${bioMedicalWasteInst?.total1}</td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     </tr>
    
    </table>
 
  </table>
</div> 
		   
		   
		   
		   <div class="content" id="country4">
												<table width="90%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
													style="border-collapse: collapse;">
													<tr>
														<td bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">

															<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Documents Details</td>
															</tr>
														
														<%
														System.out.println("bioMedicalWasteInstance.id--------------------------------->"+bioMedicalWasteInstance.id+"--"+bmwAppFor);
														def docList = WasteManagementFile.findAll("from WasteManagementFile abc where abc.typeOfFile='BMW Documents' and  abc.applicationId=? and abc.resubmittedDoc=false and (abc.applicationFor='BMW Fresh' OR abc.applicationFor='BMW Renew' OR abc.applicationFor='BMW')order by abc.id asc",[bioMedicalWasteInstance.id])
														System.out.println("docList.id--------------------------------->"+docList);
														def docList1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='BMW' and abc.typeOfFile='BMW Documents' and  abc.applicationId=? and abc.resubmittedDoc=true order by abc.id asc",[bioMedicalWasteInstance.id])
														System.out.println("docList1.id--------------------------------->"+docList1);
														
															//def doc1 = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor='CTO' ")
			
															
															%>
															<g:def var="dList" value="${DocumentChecklistMaster.list()}" />
															<g:each var="doc" in="${docList}">
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue"><g:def var="fooVar"
																	value="${bioMedicalWasteInstance.id}"/><g:def var="docN" value="${doc.description}"/> <g:link
																	action="viewFile1" controller="bioMedicalWaste"
																	params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
															</tr>
															</g:each>
													
															<%if(docList1){%>
															<tr bgcolor="#D1D1D1">
															<td colspan="2" align="center" valign="middle"
																class="headngblue">Resubmitted Documents Details</td>
														</tr>
															<%}%>
															<g:each var="doc" in="${docList1}">
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue"><g:def var="fooVar"
																	value="${bioMedicalWasteInstance.id}"/><g:def var="docN" value="${doc.description}"/> <g:link
																	controller="bioMedicalWaste" action="viewFile2"
																	params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
															</tr>
															</g:each>
														</table>


														</td>
													</tr>
												</table>

												<br />
												</div>



		  
<!-- ################################### DIV 1 ENdsss ############### -->
	<%System.out.println("bioMedicalWasteInstance.completionStatus+++++"+bioMedicalWasteInstance.completionStatus);
	
			def editableMode=false
			def scrutinyReturn=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId= ? order by id desc",[bioMedicalWasteInstance.id.toString()])
			if(session.indUser && scrutinyReturn && scrutinyReturn.scrutinyStatus=="In-Complete" && scrutinyReturn.resubmitStatus==false)
			{
			  editableMode=true
			}
			
																	
	%>		   
			<%if(bioMedicalWasteInstance.completionStatus=="Inprogress" || editableMode ){%>
		       <div class="buttons">
                    <input type="hidden" name="id" value="${bioMedicalWasteInstance?.id}" />
                    <table width="75%" align="center">
	                     <tbody>
						        <tr class="prop" >
	                                <td valign="top" align="center">
                    					<span class="button"><input type="submit" name="edit"  value="Edit" class="actionbutton"/></span>
                    					</td>
	                            </tr> 
	                    </tbody>
              		</table>
              		
            </div>
            <%}%>
		
 </g:form>
      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
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


