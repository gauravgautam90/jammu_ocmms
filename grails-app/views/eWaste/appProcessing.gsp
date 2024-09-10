<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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



function hidedivEWaste1() {

for(var i = 0; i<document.general.clarification.length; i++){

 if(document.general.clarification[i].checked){
 
 var radiomenu = document.general.clarification[i]

   	 if (radiomenu.value == "yes") { 
   	 
   	    document.getElementById('inspection1').checked=true;
 		document.getElementById('inspectionClose1').checked=true;
 		document.getElementById('approve1').checked=true;
 		document.getElementById('reject1').checked=true;
 		
   	 
   	 
 			     	
 					document.getElementById('SelectTempEWaste12').style.display = 'block';
 					document.getElementById('SelectTempEWaste14').style.display = 'none';
			       document.getElementById('SelectTempEWaste15').style.display = 'none';
			       document.getElementById('SelectTempEWaste13').style.display = 'none';
			       document.getElementById('SelectTempEWaste16').style.display = 'none';
			
			
		} 
		
			
		
		else if (radiomenu.value == "no") { 
 			
 		document.getElementById('SelectTempEWaste12').style.display = 'none';
 			
		} 
		
		

	
			} 
	} 
}

function hideEWaste00() {

for(var i = 0; i<document.general.noticeType.length; i++){

 if(document.general.noticeType){
 
 var radiomenu = document.general.noticeType

   	 if (radiomenu.value == "Show Cause") { 
 			<%System.out.println("working 1");%>
 			document.getElementById('SelectTempEWaste001').style.display = 'none';
         <%System.out.println("working 2");%>
			document.getElementById('SelEWaste007').style.display = 'block';
         <%System.out.println("working 3");%>
 		
		} 
		else{
         <%System.out.println("working 11");%>
	document.getElementById('SelectTempEWaste001').style.display = 'block';
         <%System.out.println("working 22");%>
		document.getElementById('SelEWaste007').style.display = 'none';
         <%System.out.println("working 33");%>
		
		}
		
			} 
	} 
}

function hidedivEWaste2() {

for(var i = 0; i<document.general.inspection.length; i++){

 if(document.general.inspection[i].checked){
 
 var radiomenu = document.general.inspection[i]

   	 if (radiomenu.value == "yes") { 
 			
 		document.getElementById('clarification1').checked=true;
 		document.getElementById('inspectionClose1').checked=true;
 		document.getElementById('approve1').checked=true;
 		document.getElementById('reject1').checked=true;
 		
 		
 		
			document.getElementById('SelectTempEWaste13').style.display = 'block';
			document.getElementById('SelectTempEWaste14').style.display = 'none';
			document.getElementById('SelectTempEWaste15').style.display = 'none';
			document.getElementById('SelectTempEWaste12').style.display = 'none';
			document.getElementById('SelectTempEWaste16').style.display = 'none';
 		
		} 
		
		else if (radiomenu.value == "no") { 
 			
 		document.getElementById('SelectTempEWaste13').style.display = 'none';
 			
		} 
			} 
	} 
}

function hidedivEWaste3() {

for(var i = 0; i<document.general.inspectionClose.length; i++){

 if(document.general.inspectionClose[i].checked){
 
 var radiomenu = document.general.inspectionClose[i]

   	 if (radiomenu.value == "yes") { 
   	 
   	 
   	     document.getElementById('inspection1').checked=true;
 		document.getElementById('clarification1').checked=true;
 		document.getElementById('approve1').checked=true;
 		document.getElementById('reject1').checked=true;
 			
 			document.getElementById('SelectTempEWaste14').style.display = 'block'; 
 		    document.getElementById('SelectTempEWaste12').style.display = 'none'; 
 		    document.getElementById('SelectTempEWaste13').style.display = 'none'; 
 		    document.getElementById('SelectTempEWaste15').style.display = 'none';
 		    document.getElementById('SelectTempEWaste16').style.display = 'none'; 
		} 
			
		
		else if (radiomenu.value == "no") { 
 			
 		document.getElementById('SelectTempEWaste14').style.display = 'none';
 			
		} 
	
			} 
	} 
}



function hidedivEWaste4() {

for(var i = 0; i<document.general.approve.length; i++){

 if(document.general.approve[i].checked){
 
 var radiomenu = document.general.approve[i]

   	 if (radiomenu.value == "yes") { 
 			document.getElementById('inspection1').checked=true;
 		document.getElementById('clarification1').checked=true;
 		document.getElementById('inspectionClose1').checked=true;
 		document.getElementById('reject1').checked=true;
 		
 		
			document.getElementById('SelectTempEWaste15').style.display = 'block';
 		    document.getElementById('SelectTempEWaste12').style.display = 'none';
 		    document.getElementById('SelectTempEWaste13').style.display = 'none';
 		    document.getElementById('SelectTempEWaste14').style.display = 'none';
 		    document.getElementById('SelectTempEWaste16').style.display = 'none';
		} 
		
		else if (radiomenu.value == "no") { 
 		
 		document.getElementById('SelectTempEWaste15').style.display = 'none';
 			
		 } 
		} 
	} 
}


function hidedivEWaste5() {

for(var i = 0; i<document.general.reject.length; i++){

 if(document.general.reject[i].checked){
 
 var radiomenu = document.general.reject[i]

   	 if (radiomenu.value == "yes") { 
   	 		document.getElementById('inspection1').checked=true;
 		document.getElementById('clarification1').checked=true;
 		document.getElementById('inspectionClose1').checked=true;
 		document.getElementById('approve1').checked=true;
 		
			document.getElementById('SelectTempEWaste16').style.display = 'block';
			document.getElementById('SelectTempEWaste15').style.display = 'none';
			document.getElementById('SelectTempEWaste14').style.display = 'none';
			document.getElementById('SelectTempEWaste13').style.display = 'none';
			document.getElementById('SelectTempEWaste12').style.display = 'none';
 		
		} 
		
		else if (radiomenu.value == "no") { 
 			
 		document.getElementById('SelectTempEWaste16').style.display = 'none';
 			
		} 
		
			} 
	} 
}



function hidedivEWaste() {

for(var i = 0; i<document.myForm.returned.length; i++){

 if(document.myForm.returned[i].checked){
 
 var radiomenu = document.myForm.returned[i]

   	 if (radiomenu.value == "yes") { 
 			
 			
			document.getElementById('SelectTempEWaste11').style.display = 'block';
 		
		}else if (radiomenu.value == "no") { 
 			
 		    document.getElementById('SelectTempEWaste11').style.display = 'none';
 			
		} 
		} 
	} 
}






function disableButton(){
document.getElementById('Save').style.display = 'none';

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
			document.getElementById('mycontainer013').style.display="block";
			}
		if(a=="no"){
			
			
			if(document.getElementById("approve")){
			document.getElementById("approve").disabled=false;
			document.getElementById("approve1").disabled=false;
			document.getElementById("approveNote").disabled=false;
			}
			document.getElementById('mycontainer013').style.display="none";
			}
		
				
}
</script>
    <g:javascript>



        // A $( document ).ready() block.
        jQuery( document ).ready(function() {
            jQuery('.scn_show_hide').hide();
        });


        function select10() {
            console.log("select10: ");
            var selectedValue = jQuery("#noticeType option:selected").text();
            console.log("selectedValue: " + selectedValue);
            if (selectedValue == "Clarification") {

                console.log("0");
                jQuery('.reply_days').show();
                console.log("1");
                jQuery('.scn_show_hide').hide();
                console.log("2");


            }
            else {
                console.log("00");
                jQuery('.reply_days').hide();
                console.log("4");
                jQuery('.scn_show_hide').show();
                console.log("5");


            }


        }
    </g:javascript>
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
											<!-- code for menuAdmin-->
											<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="eWasteEmpMenuVertical"/> 
					                        <%    }
						                  		} %>
								         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
								               	<g:include controller="userMaster" action="showIndexMenu"/>            
								         	<% } %>
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
                <%System.out.println("appIdStr... on gsp page : " +appIdStr)
                def refusalCerti=EWasteManagementCertificates.find("from EWasteManagementCertificates ew where ew.applicationId=? and typeOfFile='RefusalCertificate'",[appId])
                 def uploadedCerti=EWasteManagementCertificates.find("from EWasteManagementCertificates ew where ew.applicationId=? and typeOfFile='EWasteNew Uploaded'",[appId])
                 def recordCertiRefusal=RecordCertificateEW.find("from RecordCertificateEW rc where rc.application.id=? and rc.subject='Refused'",[appId])
                %>
					<td align="left"><g:def var="appForWhich1" value="${appFor}"/><g:def var="applicationId" value="${appIdStr}"/>
						
						<a href="#" onclick="window.open('<g:createLink action="openApplicationDetails" params="[docName:appForWhich1,id:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
						<a href="#" onclick="window.open('<g:createLink action="spcbShowForm" params="[appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a> 
						<%if(prepareCertificate){
						if(viewCert!=true){
						%>
						<g:link controller="eWaste" action="insrtCertificateDetailsForNew" id="${appId}"><span class="innerlink">&nbsp;Generate Certificate&nbsp;|</span></g:link>
						<%}else {%>
						<g:link controller="eWaste" action="insrtCertificateDetailsForNew" id="${appId}"><span class="innerlink">&nbsp;Modify Certificate&nbsp;|</span></g:link>
						<%}}%>
                        <g:link controller="eWaste" action="uploadeWasteCertificate"  id="${appId}"><span class="innerlink">&nbsp;Upload Certificate&nbsp;|</span></g:link>
						<%if(viewCert){%>
						<g:link controller="eWaste" action="viewEWasteCert1"  id="${appId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}
						 if(uploadedCerti)
						{
						int id=appId;%>
						<g:link controller="eWaste" action="viewRefusalEWasteCert"  id="${uploadedCerti.id}" ><span class="innerlink">&nbsp;View Upload Certificate&nbsp;|</span></g:link>
						<%} %>
						<% if(prepareCertificate){ 
						if(recordCertiRefusal){
						%>
						<g:link controller="eWaste" action="refusalCerti" id="${appId}"><span class="innerlink">&nbsp;Modify Refusal certificate&nbsp;|</span></g:link>
					<%}	else{%>
					<g:link controller="eWaste" action="refusalCerti" id="${appId}"><span class="innerlink">&nbsp;Generate Refusal certificate&nbsp;|</span></g:link>
					<%} }%>
					<% if(refusalCerti){ %>
						<g:link controller="eWaste" action="viewRefusalEWasteCert" id="${refusalCerti.id}"><span class="innerlink">&nbsp;View Refusal certificate&nbsp;|</span></g:link>
						
					<%}	%>
						
<% System.out.println("hey 101")
    def inspFindAll=EWasteProcessingDetails.findAll("from EWasteProcessingDetails afg where  afg.applicationId=? " ,[applicationId])
System.out.println("hey 102")
			
			def inspecValu
			
        	def inspecValList = new ArrayList()
        	for(int j=0 ; j<inspFindAll.size();j++){
        	
        	def instance = inspFindAll.get(j)
        	
        	 inspecValu = instance.inspectionClose
        		
        	inspecValList.add(inspecValu)
        	}
        	
			%>
			
				<%
			
			 if((inspecValList.contains(true))){
			 
			%>
							
					<g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="eWaste" params="[appliLoc:fooVar,docName:'inspectionReport',docType:'doc',appliFor:appForWhich]"><span class="innerlink">View Inspection Report</span></g:link>
			
<% } %>	
						
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
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px>
		
		
		
		
		<g:form action="processApp" name="general" enctype="multipart/form-data" method="post" >
		<input type="hidden" name="roleHeaderId" id="roleHeaderId" value="${roleHeaderId}"/>
		<%if(chk == true){%>
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            
                       <tr>
	
                          <td width="150px"  class="headngblue" ><div align="left" class="style3"></div></td>
                          <td align="right"  class="txt4">
                          <span class="headngblue" ><font color="grey">Industry Name  :   </font> <%=indApp.industryReg%>  </span>                   </td>
                 
	                    </tr>
	
	
	                   <tr>
	
                        <td width="150px"  class="headngblue" ><div align="left" class="style3"></div></td>
                        <td align="right"  class="txt4">
                            <%System.out.println("hey 103")%>
                         <span class="headngblue" ><font color="grey">Application Id  :   </font> <%= applicationProcessingDetailsInstance.applicationId%>   </span>                   </td>
                           <%System.out.println("hey 104")%>
	                  </tr>
                            
                   <%}%>         
                            
             <!--    <tr>
                              <td width="9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"  /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">File Noting/Action</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"  /></td>
							  <td width="432">&nbsp;</td>
							</tr>  -->         
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#A8DAF3">
 					<td colspan="2" class="headngblue" align="center">Last Comments</td>
 					</tr>
 					
				<%if(applicationProcessingDetailsInstance){%>
				<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm");

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
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="eWaste" params="[appliLoc:fooVar,docName:'indClarificationFile',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></g:if></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.fileNote}  </td>
                      </tr>
		<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity Action:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Clarification</div> <g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="eWaste" params="[appliLoc:fooVar,docName:'attachedClarificationReport',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Activity Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.clarificationNote} </td>
                      </tr>
	   </g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Inspection</div><g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="eWaste" params="[appliLoc:fooVar,docName:'attachedInspectionReport',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.inspectionNote}</td>
                      </tr>
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9"><span align="left"  class="headngblue">Inspection Closed</span> <span  class="txt">&nbsp; <g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewClarificationDocument" controller="eWaste" params="[appliLoc:fooVar,docName:'inspectionReport',docType:'doc',appliFor:appForWhich]">View Report</g:link></g:if></span></td>
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
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="appId1" value="${app.id}"/><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appForWhich" value="${appFor}"/><g:link action="viewOtherAttachedDocument" controller="eWaste" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',appliFor:appForWhich, appId2:appId1]">View Letter</g:link></td>
                      </tr>
             
 					<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
					<%}%>
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Assign To : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					  <g:select optionKey="id" from="${fwdRoleList}" name="forward" class="txt4"  ></g:select>
					 
				</span></span>				</td>
			</tr>
            <%if(canApprove){%>
                <tr >
                    <td  bgcolor="#A8DAF3" class="headngblue" >Grant/Refuse Status : </td>
                    <td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
                        <g:select optionKey="id" from="${['Approve','Refuse']}" name="status" class="txt4"  ></g:select>

                    </span></span>				</td>
                </tr>
            <%}%>
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
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise clarification? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="clarification" id="clarification" type="radio" value="yes" />
                                <span class="style3">Yes</span>                              
                                <input name="clarification" id="clarification1" type="radio" value="no" checked="checked" />
                                <span class="style3">No</span>				</td>
				</tr>
				
				<tr >
                       <td colspan="2">
                       <div  style="display:block; border:0;"  id="SelectTempEWaste12">
                       <table width="100%" cellpadding="0" cellspacing="0">
                         
				                    <tr>

										 <td  bgcolor="#BFBFBF" class="headngblue" >Notice Type : </td>
									 	 <td  align="left" bgcolor="#BFBFBF"  class="headngblue">
									 	<span class="txt style6">
										 <g:select from="${['Clarification']}" name="noticeType" class="txt4" onchange="select10();"></g:select>
                    
                                        </span>&nbsp;</td>
									</tr>
							<%

							    if( noticeType=="Show Cause")
								{
									System.out.println("notitype showcause")
								}
							else
								{
									System.out.println("noticetype clarification")
								}%>
						
								   <tr>
									  <td  bgcolor="#BFBFBF" class="headngblue" >Clarification Note : </td>
							 		  <td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
									 	 <textarea name="clarificationNote" id="clarificationNote" cols="35" class="txt4"></textarea>
										 </span>&nbsp;<a href="#">Copy To</a></td>
								  	</tr>
                                        %{--<td align="center" bgcolor="#BFBFBF"  class="headngblue" colspan="2">
                                            <a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popEWasteInspectionReport/<%=appIdStr%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Prepare SCN(E-waste) for Refusal </a>
										</td>--}%

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
						
						<tr >
                         <td colspan="2">
                         <div id="SelEWaste007">
                         	<table width="100%" cellpadding="0" cellspacing="0">
                				<%if(!prepareCertificateScn){%>
									
								<tr class = "scn_show_hide">
			         				<td colspan =2 align="center" bgcolor="#BFBFBF"  >
										<% if(appFor=="EWaste" ){
											
										%>
										<a href="<%=request.getContextPath()%>/eWaste/popEWasteSCNReport?appliId=<%=appIdStr%>"><span class="innerlink">&nbsp;<u>Prepare SCN(EWaste) For Refusal</u>&nbsp;</span></a>

										<%	if(viewCerScnEWaste){%>
										<g:link action="downLoadingCertificateForScnEwaste"  id="${appIdStr}" ><span class="innerlink">&nbsp; <u>View SCN(EWaste) For Refusal</u>&nbsp;</span></g:link>
									</td>
								</tr>
								<%}}}%></table></div></td></tr>
				</g:if>
				 </table></div>
</td>
       </tr>	
							
							
							
				<g:if test="${inspection==true}">
					<tr bgcolor="#A8DAF3">
			 		   <td colspan="2">&nbsp;</td>
			 		</tr>
			 		
					 <tr >
							<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise inspection ? : </td>
						 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
									<input name="inspection" id="inspection" type="radio" value="yes" >
	                                <span class="style3">Yes</span>                              
	                                <input name="inspection" id="inspection1" type="radio" value="no" checked="checked">
	                                <span class="style3">No</span>					</td>
					</tr>
				
				<tr >
                       <td colspan="2">
                       <div  style="display:block; border:0;"  id="SelectTempEWaste13">
                       <table width="100%" cellpadding="0" cellspacing="0">
				
				
							<tr >
								<td  bgcolor="#98AFC7" class="headngblue" >Inspection Note : </td>
							 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
									  <textarea name="inspectionNote" id="inspectionNote" cols="35" class="txt4"></textarea>
								</span>&nbsp;<a href="#">Copy To</a></td>
							</tr>	
							<tr >
								<td  bgcolor="#98AFC7" class="headngblue" >Reply Inspection within : </td>
							 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
								 <input type="text" name="inspectionDays" id="inspectionDays" value="" size="5"/>
								</span>&nbsp;days.</td>
							</tr>	
							<tr >
								<td  bgcolor="#98AFC7" class="headngblue" >Attach letter for Inspection Report: </td>
							 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt">
								  <input type="file" name="attachInspectionReport" id="attachInspectionReport"/>
								</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
							</tr>
							 </table></div></td>
							
				</tr>				
        	 </g:if>
        	 <g:if test="${inspectionClose==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="inspectionClose" id="inspectionClose" type="radio" value="yes" >
                                <span class="style3">Yes</span>                              
                                <input name="inspectionClose" id="inspectionClose1" type="radio" value="no" checked="checked">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
                         <td colspan="2">
                         <div  style="display:block; border:0;"  id="SelectTempEWaste14">
                         <table width="100%" cellpadding="0" cellspacing="0">
				
				
				<tr >
					<td  bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
				 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>

							 <tr style="display:none">
								 <td  bgcolor="#BFBFBF" class="headngblue" >Click to submit Inspection Report: </td>
								 <td align="left" bgcolor="#BFBFBF"  class="headngblue">
									 <a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popEWasteInspectionReport/<%=appIdStr%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Click to submit Inspection Report </a>
								 </td>

							 </tr>
				<tr >
					<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>



					<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  	<input type="file" name="inspectionReport" id="inspectionReport"/>
						</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;
					</td>
				</tr>	
			</table></div></td></tr>				
        	 </g:if>
        	 
        	 <g:if test="${approve==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
 					
							<tr >
								<td  bgcolor="#98AFC7" class="headngblue" >Do you want to Approve Application ? : </td>
							 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
									<input name="approve" id="approve" type="radio" value="yes" >
			                                <span class="style3">Yes</span>                              
			                                <input name="approve" id="approve1"  type="radio" value="no" checked="checked" >
			                                <span class="style3">No</span>					</td>
							</tr>
				<tr >
                       <td colspan="2">
                       <div  style="display:block; border:0;"  id="SelectTempEWaste15">
                       <table width="100%" cellpadding="0" cellspacing="0">
				
						<tr >
							<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
						 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
								  <textarea name="approveNote" id="approveNote" cols="35" class="txt4"></textarea>
							</span>&nbsp;<a href="#">Copy To</a></td>
						</tr>
					</table></div></td></tr>				
        	 </g:if>
        	 
        	 <g:if test="${reject==true}">
				<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
 					
 			  
							<tr >
								<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Reject
							  	Application ? : </td>
						 		<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						 		                           
			                      <input name="reject" id="reject"  type="radio" value="yes"  onclick="enablingDisablingrej(this.id);">
			                      <span class="style3">Yes</span>   
			                      <input name="reject" id="reject1" type="radio" value="no" checked="checked" onclick="enablingDisablingrej(this.id);">
			                      <span class="style3">No</span>					</td>
							</tr>
				
				<tr >
                     <td colspan="2">
                     <div  style="display:block; border:0;"  id="SelectTempEWaste16">
                     <table width="100%" cellpadding="0" cellspacing="0">
				
				
						  <tr >
							  <td  bgcolor="#BFBFBF" class="headngblue" >Note : </td>
					 		  <td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
							  <textarea name="rejectNote" id="rejectNote" cols="35" class="txt4"></textarea>
							  </span>&nbsp;<a href="#">Copy To</a></td>
						 </tr>
						 <tr >
							  <td  bgcolor="#BFBFBF" class="headngblue" >rej : </td>
					 		  <td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
							  	<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Rejection reason : </td>
			 	<td  align="left" id="mycontainer013" style="display:none" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <select name="rejectionCode" id="rejectionCode">
					  <option value="1196">Others</option>
                      <option value="1195">User no more Interested</option>
                      <option value="1194">Wrong Application submitted</option>
                      <option value="1193">Demo / Trial Form</option>
                      <option value="1192">Duplicate Form (License/NOC/Clearance Already Granted)</option>
                      <option value="1191">Not Feasible</option>
                      <option value="1190">Not Eligible as per Eligibility Criteria</option>
                      <option value="1189">Fee not Submitted</option>
                      <option value="1188">Proper information not submitted</option>
                      <option value="1187"> Proper document not submitted</option>	
            </td>
						 </tr>		
					</table></div></td></tr>			
        	 </g:if>
                        </table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td><input name="appId" type="hidden" value="${app.id}"/></td>
			<td align="right"><input type="submit" name="Save" value="Save" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          </div>
	  
<script type="text/javascript">



 var frmvalidator  = new Validator("general");
 frmvalidator.EnableFocusOnError(false); 
 frmvalidator.EnableMsgsTogether();
 
 
 function Checkfiles()
 {	
   alert("hello");
    var fupp = document.getElementsByName('attachLetter');
    var fup = fupp;
    var fileName = fup.value;
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
   
    if(ext != "pdf" && ext != "jpg" && ext != "bmp" &&  fileName !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
    
    return true;
	
  }

frmvalidator.setAddnlValidationFunction("Checkfiles");







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