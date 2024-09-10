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

<script type="text/javascript">

</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
 
      String context=request.getContextPath();

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

function hidediv1() {

for(var i = 0; i<document.myForm.clarification.length; i++){

 if(document.myForm.clarification[i].checked){
 
 var radiomenu = document.myForm.clarification[i]

   	 if (radiomenu.value == "yes") { 
 			
			document.getElementById('SelectTemp12').style.display = 'block';
			//document.getElementById('inspectionClose').disabled = true;
			
			document.getElementById('revoke').disabled = true;
			document.getElementById('closeInd').disabled = true;
			document.getElementById('revokeCloseInd').disabled = true;
			document.getElementById('approve').disabled = true; 
			document.getElementById('reject').disabled = true;
			
 		
		} 
		
		else if (radiomenu.value == "no") { 
 			
	 		document.getElementById('SelectTemp12').style.display = 'none';
	 		//document.getElementById('inspectionClose').disabled = false;
	        document.getElementById('revoke').disabled = false;
	        document.getElementById('closeInd').disabled = false;
	        document.getElementById('revokeCloseInd').disabled = false;
	        document.getElementById('approve').disabled = false;
	        document.getElementById('reject').disabled = false;
	
		} 
		
			} 
	} 
}

function hidediv3() {

for(var i = 0; i<document.myForm.inspectionClose.length; i++){

 if(document.myForm.inspectionClose[i].checked){
 
 var radiomenu = document.myForm.inspectionClose[i]

   	 if (radiomenu.value == "yes") { 
 			document.getElementById('SelectTemp14').style.display = 'block';
			document.getElementById('clarification').disabled = true;
 		
		} 
		
		else if (radiomenu.value == "no") { 
 			
 		document.getElementById('SelectTemp14').style.display = 'none';
 		document.getElementById('clarification').disabled = false;
 			
		} 
		
			} 
	} 
}
function hidediv4() {

for(var i = 0; i<document.myForm.approve.length; i++){

 if(document.myForm.approve[i].checked){
 
 var radiomenu = document.myForm.approve[i]

   	 if (radiomenu.value == "yes") { 
 			
			document.getElementById('SelectTemp15').style.display = 'block';
 		    document.getElementById('clarification').disabled = true;
 		    document.getElementById('revoke').disabled = true;
 		   	document.getElementById('closeInd').disabled = true;
			document.getElementById('revokeCloseInd').disabled = true;
			document.getElementById('reject').disabled = true;
		} 
		
		else if (radiomenu.value == "no") { 
 			
	 		document.getElementById('SelectTemp15').style.display = 'none';
	 		document.getElementById('clarification').disabled = false;
 		    document.getElementById('revoke').disabled = false;
 		   	document.getElementById('closeInd').disabled = false;
			document.getElementById('revokeCloseInd').disabled = false;
			document.getElementById('reject').disabled = false;	
		} 
		
			} 
	} 
}

function hidediv6() {

for(var i = 0; i<document.myForm.revoke.length; i++){

 if(document.myForm.revoke[i].checked){
 
 var radiomenu = document.myForm.revoke[i]

   	 if (radiomenu.value == "yes") { 
 			
			document.getElementById('SelectTemp155').style.display = 'block';
 		    document.getElementById('clarification').disabled = true;
 		   	document.getElementById('closeInd').disabled = true;
			document.getElementById('revokeCloseInd').disabled = true;
			document.getElementById('approve').disabled = true; 
			document.getElementById('reject').disabled = true;
		} 
		
		else if (radiomenu.value == "no") { 
	 		document.getElementById('SelectTemp155').style.display = 'none';
	 		document.getElementById('clarification').disabled = false;
 		   	document.getElementById('closeInd').disabled = false;
			document.getElementById('revokeCloseInd').disabled = false;
			document.getElementById('approve').disabled = false; 
			document.getElementById('reject').disabled = false;	
		} 
		
			} 
	} 
}
function hidediv7() {

for(var i = 0; i<document.myForm.closeInd.length; i++){

 if(document.myForm.closeInd[i].checked){
 
 var radiomenu = document.myForm.closeInd[i]

   	 if (radiomenu.value == "yes") { 
 			
			document.getElementById('SelectTemp1555').style.display = 'block';
 		    document.getElementById('clarification').disabled = true;
 		    document.getElementById('revoke').disabled = true;
 		   	document.getElementById('revokeCloseInd').disabled = true;
			document.getElementById('approve').disabled = true; 
			document.getElementById('reject').disabled = true;
		} 
		
		else if (radiomenu.value == "no") { 
 			
	 		document.getElementById('SelectTemp1555').style.display = 'none';
	 		document.getElementById('clarification').disabled = false;	
 		    document.getElementById('revoke').disabled = false;
 		   	document.getElementById('revokeCloseInd').disabled = false;
			document.getElementById('approve').disabled = false; 
			document.getElementById('reject').disabled = false;
		} 
		
			} 
	} 
}
function hidediv8() {

for(var i = 0; i<document.myForm.revokeCloseInd.length; i++){

 if(document.myForm.revokeCloseInd[i].checked){
 
 var radiomenu = document.myForm.revokeCloseInd[i]

   	 if (radiomenu.value == "yes") { 
 			
			document.getElementById('SelectTemp15555').style.display = 'block';
 		    document.getElementById('clarification').disabled = true;
 		    document.getElementById('closeInd').disabled = true;
 		    document.getElementById('revoke').disabled = true;
 		   	document.getElementById('approve').disabled = true; 
			document.getElementById('reject').disabled = true;
		} 
		
		else if (radiomenu.value == "no") { 
 			
	 		document.getElementById('SelectTemp15555').style.display = 'none';
	 		document.getElementById('clarification').disabled = false;	
 		    document.getElementById('closeInd').disabled = false;
 		    document.getElementById('revoke').disabled = false;
 		   	document.getElementById('approve').disabled = false; 
			document.getElementById('reject').disabled = false;
		} 
		
			} 
	} 
}

function hidediv5() {

for(var i = 0; i<document.myForm.reject.length; i++){

 if(document.myForm.reject[i].checked){
 
 var radiomenu = document.myForm.reject[i]

   	 if (radiomenu.value == "yes") { 
 			
			document.getElementById('SelectTemp16').style.display = 'block';
			document.getElementById('clarification').disabled = true;
			document.getElementById('revoke').disabled = true;
			document.getElementById('closeInd').disabled = true;
			document.getElementById('revokeCloseInd').disabled = true;
			document.getElementById('approve').disabled = true;
			
 			} 
		
		else if (radiomenu.value == "no") { 
 					document.getElementById('SelectTemp16').style.display = 'none';
 			        document.getElementById('clarification').disabled = false;
 			        document.getElementById('revoke').disabled = false;
 			        document.getElementById('closeInd').disabled = false;
 			        document.getElementById('revokeCloseInd').disabled = false;
 			        document.getElementById('approve').disabled = false;
 			        
		      } 
			} 
	  } 

   }

function disableButton()
{
    //document.getElementById('Save').disabled = true;
    //document.getElementById('myForm').submit();
	document.getElementById('Save').style.display = 'none';
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
				<g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="inspectionManagement" action="showSpcbInspectionManagementMenu"/>                                            
				<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenu"/>
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
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;
                            %{--bhanu commented code start; date: 01-08-2017--}%
                            %{--Role : ${roleHeader}--}%
                            %{--bhanu commented code ends --}%

                            %{--bhanu code start; date: 01-08-2017 --}%
                            <%if(roleHeader){%>
                            Role : ${roleHeader}
                            <%}%>
							</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
			<tr>		
					<td align="left">
					<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/${indApp.id}', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a> 
						
							<a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/showInspectionNoteHistroy?typeOfInspection=REGULAR_INSPECTION&id=${indApp.id}', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Inspection Note Histroy&nbsp;|</span></a>	 
                        <!--    <a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/showPrevoiusInspectionNoteHistroy?typeOfInspection=REGULAR_INSPECTION&id=${indApp.id}', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Previous Inspection Note Histroy&nbsp;|</span></a>  -->	 
			 						
						<!-- Checklist link in regular inspection -->
					   <%
					   System.out.println("indApp.on gsp.."+indApp)
						   def inspectionReport = IndustryInspectionReport.findByApplication(indApp)
						   def inspectionReport1 = ConsentRegularInspectionEERecommendations.findByApplication(indApp)
						   System.out.println("inspectionReport.on gsp.."+inspectionReport)
						   def appFileRecordForCheckList = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Regular Inspection Report'",[indApp])
						  if((inspectionReport || inspectionReport1) && appFileRecordForCheckList){%>
						  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openCerificate?id=<%=indApp%>&docName=Regular Inspection Report', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Regular Inspection Report&nbsp;|</span></a>
							
					       <%}%>
					       
					      <%System.out.println("roleId...."+roleId)  %>
					      <%if(roleId.eeRecommendation=="Yes"){%>
							<% if(inspectionReport){%>
							<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDeeRecommendationsRegular?id=<%=indApp.id%>&type=DEE', 'ApplicationHistory', 'WIDTH=900,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Officer Remarks&nbsp;|</span></a>
							<%}%>
							<%}%>
							
						<%
						   def consentInspectionReport = ConsentInspectionReport.findByApplication(indApp)
						   def inspReportFresh = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Inspection Report'",[indApp])
						   
						  //Code For Prepare Revoke Certificate 
						   
						   def inspFindAll=InspectionNoteHistory.findAll("From InspectionNoteHistory afg where  afg.application=? " ,[indApp])
						   System.out.println("indApp.applicationFor/.inspFindAll."+inspFindAll)
						   def inspecValu
				           def inspecValList = new ArrayList()
				           for(int j=0 ; j<inspFindAll.size();j++){
				        	
				           def instance = inspFindAll.get(j)
				           inspecValu = instance.revoke
				           inspecValList.add(inspecValu)
				        	}
						System.out.println("indApp.applicationFor/.inspecValList."+inspecValList)	
				       if((prepareCertificateForRevoke)){
				          System.out.println("indApp.applicationFor/.."+indApp.applicationFor)
							 if((inspecValList.contains(true))){	
							     if(certificateFor == "HWM"){ %>
								    <a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoHwmCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate For Hwm &nbsp;|</span></a>
							       <%}
			             }    }%>
			
			
				      <% if(prepareCertificateForRevoke){
	    					 if((inspecValList.contains(true)) && (indApp.certificateFor == "exten")){%>
								<a href="<%=request.getContextPath()%>/inspectionManagement/extensionCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate For CTE-Extension &nbsp;|</span></a>
								<!--<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadConsentOrderExten?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Certificate For CTE-Extension&nbsp;|</span></a>-->
							   <%}
					  }%>
			
			       <%if((inspecValList.contains(true)) && (indApp.applicationType.equals("CTO"))){%>
				      	 <% if(prepareCertificateForRevoke){
								if(indApp.applicationFor =="air/HWM"){%>
										<a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoAirHwmCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate for Air/HWM&nbsp;|</span></a>
										
								<%}
								
								if(indApp.applicationFor == "air"){%>
								       <a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoAirCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate for Air&nbsp;|</span></a>
							 	<%} 
							   	
							   if(indApp.applicationFor =="water/HWM"){%>
							           <a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoWaterHwmCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate for Water/HWM&nbsp;|</span></a>
									  
			                   <%}
			                   
			                  if(indApp.applicationFor == "water"){%>
								      <a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoWaterCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate for Water&nbsp;|</span></a>
							  <%}%>
								
							  <%if(indApp.applicationFor == "both"){%>
									  <a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoBothCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate for Both&nbsp;|</span></a>
							 		  
							  <%}%>
						
							  <%if(indApp.applicationFor == "both/HWM" ){%>
							          <a href="<%=request.getContextPath()%>/inspectionManagement/revokeCtoBothHwmCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate for Air&nbsp;|</span></a>
							  <%}%>
					<%}  }
				
					if((inspecValList.contains(true)) && (indApp.applicationType.equals("CTE"))){%>
				      	 <% if(prepareCertificateForRevoke){ %>
								<!--<a href="<%=request.getContextPath()%>/applicationProcessingDetails/certificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Certificate For CTE&nbsp;|</span></a> -->
					     <%}
					 }
				// Code For Prepare Revoke Certificate Ends Here
						
					if(viewCertAir){ %>
							<g:link action="downLoadingRevokeCtoCertificateForAir"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Air&nbsp;|</span></g:link>
						
						<%}
						
					if(viewCertWater){ %>
						     <g:link action="downLoadingRevokeCtoCertificateForWater"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Water&nbsp;|</span></g:link>
												    
					    <%}
					if(viewCertHwm){ %>
						   <g:link action="downLoadingRevokeCtoCertificateForHwm"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Hwm&nbsp;|</span></g:link>
						
					<%}
					if(viewCertAirHwm){%>
					       <g:link action="downLoadingRevokeCtoCertificateForAirHwm"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Air/Hwm&nbsp;|</span></g:link>
						
					<%}
					if(viewCertWaterHwm){ %>
						   <g:link action="downLoadingRevokeCtoCertificateForWaterHwm"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Water/Hwm&nbsp;|</span></g:link>
					
					<%}
						
					if(viewCertBothHwm){ %>
							<g:link action="downLoadingRevokeCtoCertificateForBothHwm"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Both/Hwm&nbsp;|</span></g:link>
						
					<%}
						
					 if(viewCertBoth){ %>
					          <g:link action="downLoadingRevokeCtoCertificateForBoth"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Certificate For Both&nbsp;|</span></g:link>
						
					<%}%>
						 
						</td>	
				  </tr>
					  </table>
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
		
		<g:form id="myForm" name="myForm" action="processRegularInspection"  enctype="multipart/form-data" method="post" >
		<input type="hidden" id="closeInspectionStatus" name="closeInspectionStatus" value="${showCloseInspectionSection}" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"  /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1" style="color:#1E6BBD">Assign Inspection</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"  /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
          <div id="country1" >
	
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
				
						<!--  end -->
				
				<g:if test="${inspection==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
			<!--	<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
			 	
						<input name="inspection" type="radio" onclick="redirectPage()" value="yes">
			
			<% 
		     	def forwardCriteria = InspectionForwardCriteria.find("from InspectionForwardCriteria where categoryType=? AND applicationType=? AND (industryType=? OR capitalInvestment >= ?)",[indApp.indUser.category.name,indApp.applicationType,(indApp.indUser.industryType.id).toString(),(indApp.indUser.indCapInvt).toFloat()])
			    //def forwardCriteria = InspectionForwardCriteria.find("from InspectionForwardCriteria where categoryType=? AND applicationType=? AND forwardRoleType = 'MS' ",[indApp.indUser.category.name,indApp.applicationType]);
			   
			%>
						
             <g:if test="${forwardCriteria != null  }">                 
                 <a id="redirectAnchor" href="<%=request.getContextPath()%>/inspectionManagement/fwdInspectionToMS?appliId=<%=indApp.id%>&roleName=${forwardCriteria.roleName}&userId=${forwardCriteria.userMaster.id}&typeOfInspection=REGULAR_INSPECTION"></a>
             </g:if>
             <g:else>
                 <a id="redirectAnchor" href="<%=request.getContextPath()%>/applicationProcessingDetails/forwardInspectionOrderDEFAULT?appliId=<%=indApp.id%>&typeOfInspection=REGULAR_INSPECTION"></a>
             </g:else>                    <span class="style3">Yes</span>
                                <input name="inspection" type="radio" value="no" checked="checked">
                                <span class="style3">No</span>					
                                </td>
				</tr>
				
			 </g:if>	
			 
		 <!-- CODE FOR REGULAR INSPECTION Approved/Refused ## BY GAJENDRA 03/08/2016 -->
			 
		<%	
		System.out.println("indApp.......11111111..."+indApp)
		def indApplicationDetailsInstance = indApp
		System.out.println("indApplicationDetailsInstance.......11111111..."+indApplicationDetailsInstance)
		def app = ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance)
	
		def roleHeader=app.role.roleName
		def roleId = app.role
		
		def capitalInvestment = 0.0
        	 
		 if(indApp.applicationType=="CTE")
		 {
		 capitalInvestment=indApp.indUser.indCapInvt
		 }
		 else
		 {
		  capitalInvestment=indApp.indUser.indCapInvt
		 }
        def grp = app.role.group
        
        def indstryTypeId = indApp.indUser.category.industryType.id
        	 
        def indType = IndApplicationDetails.get(indApp.toString());
        def  applicationApprovalInstance
        def consentApplicationCheckInstance 
      //  consentApplicationCheckInstance = ConsentApplicationCheck.find("from ConsentApplicationCheck cap where cap.indApp=?",[indType]);  
 			
         if(consentApplicationCheckInstance){
        		     applicationApprovalInstance = RegularInspectionApplicationApprovalCriteria.find("from RegularInspectionApplicationApprovalCriteria app where app.role=? and app.category=? and app.group = ? and app.min <= ? and app.max >= ?",[roleId,indApp.indUser.category.name,grp,capitalInvestment,capitalInvestment]);
             }
        
          
         if(1){
        	 %>
			<tr >
			 	<td  bgcolor="#A8DAF3" class="headngblue" >Grant/Refusal Status: </td>
			 	<td  align="left"  >
			 	<select name="approvalStatus" >
			 	<option selected="selected" ></option>
						<option  >Approved</option>
					<option disabled></option>
						<option >Refused</option>
					  </select> 
					  
					</td>
			</tr> 
			
			<%}%>
        	
		 <!-- CODE FOR REGULAR INSPECTION Approved Ends here.. ## BY GAJENDRA 03/08/2016 -->
			 
			 <!-- CODE FOR REGULAR INSPECTION CLOSE ## BY GAJENDRA 14/07/2016 -->
			
			<g:if test="${showCloseInspectionSection}" >	
			<!--	<input name="inspectionClose" type="hidden" value="yes" > -->
				
 					<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Assign To : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					  <g:select optionKey="id" from="${fwdRoleList}" name="forward" class="txt4" ></g:select>
					 
				</span></span>				</td>
			</tr>
	  
			<!-- CODE FOR CLARIFICATION RAISED ## BY GAJENDRA -->
			
			<g:if test="${regularClarificationRaised==true}">
                <tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
			    <tr >
					  <td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise clarification? : </td>
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
									<g:select from="${['Clarification']}" name="noticeType" class="txt4" ></g:select></span>&nbsp;</td>
							</tr>	
						    <tr >
									<td  bgcolor="#BFBFBF" class="headngblue" >Clarification Note: </td>
								 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
										  <textarea name="clarificationNote" cols="35" class="txt4"></textarea>
										</span>&nbsp;<a href="#"></a></td>
							</tr>
							<tr >
		                           <td colspan="2">
		                           <div  id="SelectTemp001">
		                           <table width="100%" cellpadding="0" cellspacing="0">
							
										<tr >
											<td  bgcolor="#BFBFBF" class="headngblue" >Reply clarification : </td>
										 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
												 <input type="text" name="clarificationDays"  size="5"/>
												</span>&nbsp;days.</td>
										</tr> </table></div></td>
							</tr>
							<tr >
								<td  bgcolor="#BFBFBF" class="headngblue" >Attach letter for Clarification : </td>
							 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt">
									  <input type="file" name="attachRegularClarificationReport"/>
									</span><span class="sidetxt ">(.doc,.txt  max of 5MB in size)</span>	&nbsp;<a href="#"></a></td>
							</tr>
	
				 </table></div></td></tr>
		  </g:if>
			
			<!--  CODE FOR REVOKED STARTS HERE.. -->
			
			<g:if test="${regularInspectionRevoked==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
 				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to revoked? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input id="revoke" name="revoke" type="radio" value="yes" onclick="hidediv6();">
                                <span class="style3">Yes</span>                              
                                <input id="revoke1" name="revoke" type="radio" value="no" checked="checked" onclick="hidediv6();">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp155">
                         <table width="100%" cellpadding="0" cellspacing="0">
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea id="revokeNote" name="revokeNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				 </table></div>
</td>
       </tr>	
        	 </g:if>
			
			<!-- CODE FOR REVOKED ENDS HERE.. -->
			
			<!--  CODE FOR CLOSED INDUSTRY STARTS HERE.. -->
			
			<g:if test="${regularInspectionCloseIndustry==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
 				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to close industry? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input id="closeInd" name="closeInd" type="radio" value="yes" onclick="hidediv7();">
                                <span class="style3">Yes</span>                              
                                <input id="closeInd1" name="closeInd" type="radio" value="no" checked="checked" onclick="hidediv7();">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp1555">
                         <table width="100%" cellpadding="0" cellspacing="0">
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea id="closeIndNote" name="closeIndNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				 </table></div>
</td>
       </tr>	
        	 </g:if>
			
			<!-- CODE FOR CLOSED INDUSTRY ENDS HERE.. -->
			
			<!--  CODE FOR REVOKE AND CLOSED INDUSTRY STARTS HERE.. -->
			
			<g:if test="${regularInspectionRevokeCloseIndustry==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
 				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to revoke and close industry? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input id="revokeCloseInd" name="revokeCloseInd" type="radio" value="yes" onclick="hidediv8();">
                                <span class="style3">Yes</span>                              
                                <input id="revokeCloseInd1" name="revokeCloseInd" type="radio" value="no" checked="checked" onclick="hidediv8();">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp15555">
                         <table width="100%" cellpadding="0" cellspacing="0">
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea id="revokeCloseIndNote" name="revokeCloseIndNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				 </table></div>
</td>
       </tr>	
        	 </g:if>
			
			<!-- CODE FOR REVOKE AND CLOSED INDUSTRY ENDS HERE.. -->
			
			<!-- CODE FOR CLARIFICATION  ENDS HERE..-->
	  
	  <g:if test="${regularInspectionClose==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
 				
 			
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to close inspection after Prepared Inspection Report? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input id="approve" name="approve" type="radio" value="yes" onclick="hidediv4();">
                                <span class="style3">Yes</span>                              
                                <input id="approve1" name="approve" type="radio" value="no" checked="checked" onclick="hidediv4();">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp15">
                         <table width="100%" cellpadding="0" cellspacing="0">
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea id="approveNote" name="approveNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				 </table></div>
</td>
       </tr>	
        	 </g:if>
        	
        	 <g:if test="${regularInspectionCloseReject==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
 			
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to close inspection after Refusal? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
			 		                           
                      <input id="reject" name="reject" type="radio" value="yes" onclick="hidediv5();"/>
                      <span class="style3">Yes</span>   
                      <input id="reject1" name="reject" type="radio" value="no" checked="checked" onclick="hidediv5();">
                      <span class="style3">No</span>					</td>
				</tr>
			
				<tr >
                         <td colspan="2">
                         <div  style="display:none; border:0;"  id="SelectTemp16">
                         <table width="100%" cellpadding="0" cellspacing="0">
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea id="rejectNote" name="rejectNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
			 </table></div>
</td>
       </tr>				
        	 </g:if>
<% System.out.println("inspPreparedRgt...."+inspPreparedRgt)	%>
			 <!-- INSPECTION CLOSE CODE  END HERE  -->
			
				 <% if(inspPreparedRgt){%>
 				<tr >
					<td colspan="2" bgcolor="#BFBFBF" class="headngblue" >Prepare Inspection Report : </td>
			 	</tr>
				
			<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
			
				<tr >
                    <td colspan="2">
                        <div >
                          <table width="100%" cellpadding="0" cellspacing="0">
				               <tr >
									<td width="33%" bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
									<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
										<textarea name="inspectionNote" cols="35" class="txt4"></textarea></span>
									</td>
				               </tr>
				
				               <tr>
									<td  bgcolor="#BFBFBF" class="headngblue" ></td>
				                    <td bgcolor="#BFBFBF" class="headngblue" align="left">
									   <!-- <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReport/<%=indApp.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" >Prepare Inspection Report with Recommendation </a><br> -->
									    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/inspectionPage/<%=indApp.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Prepare Inspection Report</a>
				                    </td>
			 	               </tr>
			 	               
							   <tr >
									<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
									<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="style6">
					 				     <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popUploadMoreInspectionDoc/<%=indApp.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" >Upload additional documents if any</a>
					                     <br>
				                         <a href="#" style="color:red;" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDeleteInspectionDoc/<%=indApp.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete additional documents</a>
				                          </span>	
					                 </td>
				               </tr>	
				          </table>
						</div>
					</td>
				</tr>			
        	 
        	 <%}%>
        	           </table>
        	 <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td><input name="appId" type="hidden" value="${indApp.id}"/></td>
			<td align="center"><input type="submit" name="Save" id="Save" value="Save" class="actionbutton"  ></td>
		<td align="left"></td>			
		  </tr>
		</table>
		          
        	   </g:if>        
						
			</g:form>
            <br />
            <br />
          </div>
		  
          </div>
	  
<script type="text/javascript">

function showdiv() {

for(var i = 0; i<document.myForm.inspectionClose.length; i++){
 if(document.myForm.inspectionClose[i].checked){

 var radiomenu = document.myForm.inspectionClose[i]

   	 if (radiomenu.value == "no") { 
 			document.getElementById('SelectTemp7').style.display = 'none';
 		
		} 
	else { 
		if (radiomenu.value == "yes") { 
		
		//document.myForm.consent[2].checked = true;
	document.getElementById('SelectTemp7').style.display = 'block';
		
					}
			} 
		} 
	} 
}

function redirectPage()
{
   //redirectAnchor
   var anchorObj=document.getElementById("redirectAnchor");
   anchorObj.click()
}

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
<!--
<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="inspectionClose" type="radio" value="yes">
                                <span class="style3">Yes</span>                              
                                <input name="inspectionClose" type="radio" value="no" checked="checked">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <input type="file" name="inspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	</td>
				</tr>
-->

