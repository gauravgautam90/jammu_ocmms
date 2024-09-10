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
function disableYesapp()
{
	//alert("here in yes");
	var a= document.getElementById("clarification").checked;
	var b= document.getElementById("returned").checked;
	if(a==true && b==true){
		alert("Please Select Yes in one activity at one Time");
		return false;
	}
	return true;
}
function disableButton()
{
    //document.getElementById('Save').disabled = true;
    //document.getElementById('myForm').submit();
	document.getElementById('Save').style.display = 'none';
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
// Added by deepak for scrutiny
function alertselected()
{

var selectmenu=document.getElementById("scrutiny").value;

 if (selectmenu=='In-Complete')
 {
 
  document.getElementById('selectTemp3').style.display = 'block';
  document.getElementById('selectTemp33').style.display = 'none';
  document.getElementById('selectTemp13').style.display = 'block';
  document.getElementById('selectTemp131').style.display = 'none';
  document.getElementById('selectTemp14').style.display = 'block';
  document.getElementById('selectTemp4').style.display = 'block';

  document.getElementById('selectTempFeeee').style.display = 'none';
  document.getElementById('selectTempFee').style.display = 'none';
  document.getElementById('selectTempFee1').style.display = 'none';
  document.getElementById('selectTempFee1111').style.display = 'none';
  document.getElementById('selectTempFee2').style.display = 'none';
  document.getElementById('selectTempFee3').style.display = 'none';
  document.getElementById('selectTempFee4').style.display = 'none';
  document.getElementById('selectTempFee5').style.display = 'none';
  document.getElementById('selectTempFee6').style.display = 'none';
  document.getElementById('selectTempFee7').style.display = 'none';

}
else
{
document.getElementById('selectTemp3').style.display = 'none';
document.getElementById('selectTemp33').style.display = 'none';
document.getElementById('selectTemp14').style.display = 'block';
document.getElementById('selectTemp13').style.display = 'none';
document.getElementById('selectTemp131').style.display = 'none';
document.getElementById('selectTemp4').style.display = 'block';

document.getElementById('selectTempFee').style.display = 'block';
document.getElementById('selectTempFeeee').style.display = 'block';
document.getElementById('selectTempFee1').style.display = 'block';
document.getElementById('selectTempFee1111').style.display = 'block';
document.getElementById('selectTempFee2').style.display = 'none';
document.getElementById('selectTempFee3').style.display = 'none';
document.getElementById('selectTempFee4').style.display = 'block';
document.getElementById('selectTempFee5').style.display = 'block';
document.getElementById('selectTempFee6').style.display = 'block';
document.getElementById('selectTempFee7').style.display = 'block';


}
 
}

function checkTotal(id)
{
if (id.value == "" )
{

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
document.getElementById("totalFee").value=calVal


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
document.getElementById("totalFee").value=calVal


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
					<g:include controller="userMaster" action="showAdminMenu"/>                                          
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
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style='color:white' > Industry Name:      ${indApp.indUser.indName}</span> </td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
			<tr>		
					<td align="left">
						<a href="#" onclick="window.open('../openApplicationDetails/${indApp.id}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>

						   <%
							def scr1 = ApplicationPendingDetails.find("from ApplicationPendingDetails where scrutinyStatus='Complete' and application=?",[app.application])
							def flagShowCause = true
							%>
						   <%  if(scr1) {%>
						<g:if test="${inspectionClose==true}">
						<a href="<%=request.getContextPath()%>/industryMasterDetails/createIndustryMaster?appliId=<%=indApp.id%>"><span class="innerlink"> Prepare Master Data |</span></a>
						</g:if>
						
						   <%}%>
						<% 
						  def viewDataMaster = IndustryMasterDetailsRecord.findByApplication(indApp)
						  if(viewDataMaster){ 
						%>
							<a target="_blank" href="<%=request.getContextPath()%>/industryMasterDetails/viewIndustryMaster?id=<%=indApp.id%>"><span class="innerlink"> View Master Data |</span></a>
						<%}%>
                          
						<%
						def consentInspectionReport = ConsentInspectionReport.findByApplication(indApp)
						%>
						<%if(roleId.eeRecommendation=="Yes"){%>
						<% if(consentInspectionReport){%>
						<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDeeRecommendationsFresh?id=<%=indApp.id%>&type=DEE', 'ApplicationHistory', 'WIDTH=900,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Officer Remarks&nbsp;|</span></a>
						<%}%>
						<%}%>
						
						
						
						
						
						
						
						
						
						
						<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/${indApp.id}', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Application Form&nbsp;|</span></a> 
						<!--  <g:link  action="openApplicationDetails" id="${indApp.id}" target="_blank"><span class="innerlink">&nbsp;note history&nbsp;|</span></g:link> -->
						<!-- <g:link action="doGetShow" controller="indApplicationDetails" id="${indApp.id}" ><span class="innerlink">&nbsp;view form&nbsp;|</span></g:link> -->
						<!-- <g:link controller="#" action="#" ><span class="innerlink">&nbsp;view form&nbsp;|</span></g:link> -->
						<% System.out.println("indApp.indUser.category.name.."+indApp.indUser.category.name)
						
						def refused_ins//=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and approvalStatus='Refused' order by dateCreated desc limit 1",[indApp]);
						
						def newRefused_ins=ApplicationProcessingDetails.findAll("from ApplicationProcessingDetails where application=?  order by dateCreated desc",[indApp])
                        for(newIns in newRefused_ins){                         
                            if(newIns.approvalStatus=='Refused'){
                                refused_ins=true;
                                break;    
                            }else if(newIns.approvalStatus=='Approved'){
                                refused_ins=false;
                                break;
                            }
                            else{
                                continue;
                            }
                        }
					
						if(prepareCertificate){
						if(refused_ins){ %>
						<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadConsentOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Refusal Order&nbsp;|</span></a>
						<%}else{%>
							 <%if(scr1) {
							if(indApp.indUser.category.name=="ORANGE" || indApp.indUser.category.name=="RED"){%>
							<a href="<%=request.getContextPath()%>/applicationProcessingDetails/redOrangeCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Consent Order(Schedule-3)&nbsp;|</span></a>
							<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadConsentOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Consent Order&nbsp;|</span></a>
									<%}
							else if(indApp.indUser.category.name=="GREEN"){%>
							<a href="<%=request.getContextPath()%>/applicationProcessingDetails/greenCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Consent Order(Schedule-3)&nbsp;|</span></a>
							<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadConsentOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Consent Order&nbsp;|</span></a>
									<%}
							else if(indApp.indUser.category.name=="WHITE"){
								
								if(indApp.applicationFor == "dgset"){
									%><a href="<%=request.getContextPath()%>/applicationProcessingDetails/dgsetExempCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Exemption Certificate&nbsp;|</span></a>
									<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadExemptConsentOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Exemption Certificate&nbsp;|</span></a>
									<% } else if(indApp.applicationFor == "both"){  %>
										<a href="<%=request.getContextPath()%>/applicationProcessingDetails/indExempCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Exemption Certificate&nbsp;|</span></a>
									<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadExemptConsentOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Exemption Certificate&nbsp;|</span></a>
									<%}else{%>
									<a href="<%=request.getContextPath()%>/applicationProcessingDetails/redOrangeCertificate?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Consent Order(Schedule-3)&nbsp;|</span></a>
									<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadConsentOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Consent Order&nbsp;|</span></a>
											<%}
							}
						}
						}
						
						if(indApp.hazardeousType=="HWM"){%>
						<% if(scr1) { %>
						<a href="<%=request.getContextPath()%>/applicationProcessingDetails/uploadConsentHWMOrder?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Upload Authorization Order&nbsp;|</span></a>
						<%}}
						}%>
						
						<% def recordInstance=RecordCertificate.findByApplicationId(indApp)
						System.out.println("recordInstance.."+recordInstance)
						if(prepareCertificate && recordInstance){
							if(indApp.indUser.category.name=="ORANGE" || indApp.indUser.category.name=="RED"){%>
							<a href="<%=request.getContextPath()%>/applicationProcessingDetails/redOrangeCertificateModified?appliId=<%=indApp.id%>"><span class="innerlink">&nbsp;Prepare Modified Consent Order(Schedule-3)&nbsp;|</span></a>
								<%}}%>
						
							<% System.out.println("refused_ins..."+refused_ins)	
								System.out.println("Upload..."+Upload)
								System.out.println("viewCert..."+viewCert)
								System.out.println("viewCert1..."+viewCert1) %>
						
								<%		if(refused_ins && Upload){ %>
								<g:link action="downLoadingCertificate1"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Uploaded Refusal Order&nbsp;|</span></g:link>
								<%	}else if(viewCert && viewCert1){
									if(indApp.hazardeousType=="HWM"){%>
									<g:link action="downLoadingCertificate11"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Modified Consent Order(Schedule-3)&nbsp;|</span></g:link>
									<g:link action="downLoadingAuthorization11"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Modified Authorization&nbsp;|</span></g:link>
									<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Consent Order(Schedule-3)&nbsp;|</span></g:link>
									<g:link action="downLoadingAuthorization"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Authorization&nbsp;|</span></g:link>
									<%}else{%>
										<g:link action="downLoadingCertificate11"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Modified Consent Order(Schedule-3)&nbsp;|</span></g:link>
										<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Consent Order(Schedule-3)&nbsp;|</span></g:link>
									<%}}else if(viewCert){
								if(indApp.indUser.category.name!="WHITE"){
									if(indApp.hazardeousType=="HWM"){%>
							<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Consent Order(Schedule-3)&nbsp;|</span></g:link>
							<g:link action="downLoadingAuthorization"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Authorization&nbsp;|</span></g:link>
							<%}else{ %>
							<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Consent Order(Schedule-3)&nbsp;|</span></g:link>
							<%}}else if((indApp.indUser.category.name=="WHITE") && ((indApp.applicationFor == "dgset") || (indApp.applicationFor == "both"))){%>
							<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Exemption Certificate&nbsp;|</span></g:link>
							<% }else {
								if(indApp.hazardeousType=="HWM"){%>
							<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Consent Order(Schedule-3)&nbsp;|</span></g:link>
							<g:link action="downLoadingAuthorization"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Authorization&nbsp;|</span></g:link>
							}else{ %>
							<g:link action="downLoadingCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Consent Order(Schedule-3)&nbsp;|</span></g:link>
							<% }} }%>
							
							
							<%if(Upload){ 
									if(indApp.indUser.category.name!="WHITE"){%>
							<g:link action="downLoadingCertificate1"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Uploaded Consent Order&nbsp;|</span></g:link>
							<%}else if((indApp.indUser.category.name=="WHITE") && ((indApp.applicationFor == "dgset") || (indApp.applicationFor == "both"))){%>
							<g:link action="downLoadingCertificate1"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Uploaded Exemption Certificate&nbsp;|</span></g:link>
							<% } else { %><g:link action="downLoadingCertificate1"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Uploaded Consent Order&nbsp;|</span></g:link>
							<%}	} %>
							
							
							<%if(Upload1){ 
							if(indApp.hazardeousType=="HWM"){%>
							
							<g:link action="downLoadingConsentHWMCertificate"  id="${indApp.id}" ><span class="innerlink">&nbsp;View Uploaded Authorization Order&nbsp;|</span></g:link>
							
							<%}}%>
							
							
							
<%def inspReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Inspection Report'",[indApp])
				
						
						if(inspReport){ %>
						<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openCerificate?id=<%=indApp%>&docName=Inspection Report', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Inspection Report&nbsp;</span></a>
						<%}%>
						
				<!--		<%if(viewR_Certificate){%>
						<g:link action="viewR_CertificatePdf"  id="${indApp.id}" ><span class="innerlink">&nbsp;View R-3&nbsp;|</span></g:link>
						<%}%>
						<%if(viewR4_Certificate){%>
						<g:link action="viewR4_CertificatePdf"  id="${indApp.id}" ><span class="innerlink">&nbsp;View R-4&nbsp;|</span></g:link>
						<%}%>-->
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
			<!--  
			<tr >
				<td width="35%" bgcolor="#A8DAF3" class="headngblue" >Action :</td>
			 	<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					<g:select optionKey="id" from="${actionList}" name="action" class="txt4" ></g:select>
					   <select name="select11" class="txt4">
						<option selected="selected">Select Action</option>
					  </select> 
				</span></span></td>
						
			</tr>	
			-->
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
 
  <tr>
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Note By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})</div></td>
        </tr>			
					 <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                      
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Forward &nbsp;&nbsp; <g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:if test="${applicationProcessingDetailsInstance.role.roleName=='Industry'}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewClarificationDocument" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'indClarificationFile',docType:'doc']">View Report</g:link> </g:if></g:if></div></td>
                      </tr>
                                      
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.fileNote}  </td>
                      </tr>
                      
                      
		<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Clarification</div> <g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewClarificationDocument" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'attachedClarificationReport',docType:'doc']">View Report</g:link> </g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.clarificationNote} </td>
                      </tr>
		 </g:if>
		 <g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Inspection</div><g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewClarificationDocument" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'attachedInspectionReport',docType:'doc']">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.inspectionNote}</td>
                      </tr>
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9"><span align="left"  class="headngblue">Inspection Closed</span> <span  class="txt">&nbsp; <g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewClarificationDocument" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'Inspection Report',docType:'doc']">View Report</g:link></g:if> </span></td>
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
	
	  <g:if test="${applicationProcessingDetailsInstance.approvalStatus=='Approved' || applicationProcessingDetailsInstance.approvalStatus=='Refused'}">
                       <tr bgcolor="#F4F7FB" align="center">
                        <td bgcolor="#A8DAF3" class="headngblue"><div align="left" class="style3">Approval/Refusal Status:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">${applicationProcessingDetailsInstance.approvalStatus}</div></td>
                      </tr>   
                      </g:if> 
 					<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
 					<% System.out.println("-------Ind App id------"+indApp.id) 
 					def appId=indApp.id
 					%>
 					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Attached Letter:</div></td>
                        <td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popupDetailsofAttachedFile/${indApp.id}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View Letter</a></td>
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
				<% def capitalInvestment = 0
				 capitalInvestment=(indApp.indUser.indCapInvt).toFloat()
				 
				 
				 String cat= indApp.indUser.category.name
				 System.out.println("cat.."+cat)
				System.out.println("capitalInvestment.."+capitalInvestment)
				def applicationApprovalInstance = ConsentApplicationApprovalCriteria.find("from ConsentApplicationApprovalCriteria app where app.role=? and app.category=?",[roleId,cat]);
				System.out.println("applicationApprovalInstance..."+applicationApprovalInstance)
				def scrAppr = ApplicationPendingDetails.find("from ApplicationPendingDetails where scrutinyStatus='Complete' and application=?",[app.application])
				System.out.println("scrAppr...."+scrAppr)
        	
        	 if(scrAppr){
        		 
        	 if(applicationApprovalInstance){
        		 
        	 %>
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Approval/Refusal Status: </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <g:select from="${['','Approved','Refused']}" name="approvalStatus" class="txt4" ></g:select>
					</span></td>
			</tr>
			<%}}%>
				
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
				
				
				<%
				def roleProAssign = RoleProfileAssignment.find("from RoleProfileAssignment where primaryEmployee.id = ? ",[session.userMaster.id]);
				System.out.println("roleProAssign---"+roleProAssign)
				System.out.println("roleProAssign.role---"+roleProAssign.role)
				def rVa = RoleVsActivity.findWhere(role:roleProAssign.role, activity:RoleActivityMaster.findByActivityCode("001"))
				def scr = ApplicationPendingDetails.find("from ApplicationPendingDetails where scrutinyStatus='Complete' and application=?",[app.application])
				System.out.println("roleProAssign...."+roleProAssign)
				System.out.println("rVa...."+rVa)	
				System.out.println("scr...."+scr)
				System.out.println("roleId.returnPower==...."+roleId.returnPower)
				
				
						 if(roleId.returnPower=="Yes") { 
						 if(!(scr)){
						
						def consentFeeInst = ConsentFeeMaster.find("from ConsentFeeMaster where application=? order by id desc",[app.application])	
						System.out.println("consentFeeInst---"+consentFeeInst)
							 %>
				
				<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Scrutiny Status :</td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					 <select id="scrutiny" name="scrutiny" onChange="alertselected()">
<option value=""></option>
<option value="Complete">Complete</option>
<option value="In-Complete">In-Complete</option>
</select> 
				</span></span>				</td>
			</tr>
			
			
			
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTemp13" >Query : </div></td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					<div style="display:none; border:0;" id="selectTemp3" >	<textarea name="scrutinyDescription" id="scrutinyDescription" cols="35" class="txt4" ></textarea>	   
					</div>
					
				</span></span></td>
			</tr>
			
			<tr >
			<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTemp131" >Attach letter (If Any) : </div></td>
		 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
				<div style="display:none; border:0;" id="selectTemp33" >	
				
				<!--<input type="file" name="attachLetter"/>-->
				</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span></td>
			</tr>	
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
			
				<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFeeee" >Remarks : </div></td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					<div style="display:none; border:0;" id="selectTempFee1111" >	 
					<textarea  id="remarks" name="remarks" cols="35"  class="txt4"></textarea>
					</div>
					
				</span></span>				</td>
			</tr>
			<% if(consentFeeInst){ %>
			<% System.out.println("consentFeeInst.totalApplicableFee--"+consentFeeInst.totalApplicableFee);%>
				<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee" >Fee applicable : </div></td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					<div style="display:none; border:0;" id="selectTempFee1" >	<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value="${consentFeeInst.totalApplicableFee}" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>   
					</div>
					
				</span></span>				</td>
			</tr>
				
		<%	}else{ %>
				<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee" >Fee applicable : </div></td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					<div style="display:none; border:0;" id="selectTempFee1" >	<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value="" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>   
					</div>
					
				</span></span>				</td>
			</tr>
		<%	} %>
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
		
	<tr >
	<td  bgcolor="#A8DAF3" class="headngblue" ><div style="display:none; border:0;" id="selectTempFee6" >Total Fee: </div></td>
 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
		<div style="display:none; border:0;" id="selectTempFee7" >	<input name="totalFee" id="totalFee" type="text" class="txt4" size="10" value="" /><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/>   
		</div>
		
	</span></span>				</td>
	</tr>
	<%}}%>
				
	
	
	<%  if(scr) {%>
					
	
    <!-- code by vikas -->
    <%
    if(roleId.returnPower=="Yes"){%>
     <tr bgcolor="#A8DAF3">
 	 <td colspan="2">&nbsp;</td>
 	 </tr>
 	 <tr >
 	 <td bgcolor="#98AFC7" class="headngblue" >Do you want to return application to Unit Holder? : </td>
 	 <td align="left" bgcolor="#98AFC7" class="headngblue">
 	 <input id="returned" name="returned" type="radio" value="yes" onclick="return disableYesapp();">
  <span class="style3">Yes</span>  
  <input id="returned" name="returned" type="radio" value="no" checked="checked">
  <span class="style3">No</span> </td>
 	 </tr>
 	   <tr >
                         <td colspan="2">
                         <div  style="display:block; border:0;"  id="SelectTemp11">
                         <table width="100%" cellpadding="0" cellspacing="0">
                      
 	 
 	 <td bgcolor="#98AFC7" class="headngblue" >Return Description : </td>
 	 <td align="left" bgcolor="#98AFC7" class="headngblue"><span class="txt style6">
 	 <textarea maxlength="500" id="returnNote" name="returnNote" cols="35"  class="txt4"></textarea>
 	 </span>&nbsp;<a href="#"></a></td>
 	 </table></div>
</td>
                          </tr>
<%}%>
<!-- code ended by vikas -->
				<g:if test="${clarification==true}">
                <tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
			<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise clarification ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="clarification" id="clarification" type="radio" value="yes" onclick="return disableYesapp();"/>
                                <span class="style3">Yes</span>                              
                                <input name="clarification" type="radio" id="clarification" value="no" checked="checked" />
                                <span class="style3">No</span>				</td>
			</tr>
				
			<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Clarification Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="clarificationNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
			</tr>
			<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Reply clarification within : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					 <input type="text" name="clarificationDays" value="" size="5"/>
					</span>&nbsp;days.</td>
			</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Attach letter for Clarification Report: </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt">
					  <input type="file" name="attachClarificationReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;</td>
				</tr>	
				
				</g:if>	
				<g:if test="${indApp.inspection==false}">
				<g:if test="${inspection==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="inspection" type="radio" value="yes">
                                <span class="style3">Yes</span>                              
                                <input name="inspection" type="radio" value="no" checked="checked">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr>
				<td  bgcolor="#98AFC7" class="headngblue" >Inspection Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>	
				<tr>
				<td  bgcolor="#98AFC7" class="headngblue" >Reply inspection within : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					 <input type="text" name="inspectionDays" value="" size="5"/>
					</span>&nbsp;days.</td>
				</tr>	
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Attach letter for inspection Report: </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt">
					  <input type="file" name="attachInspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;</td>
				</tr>				
        	 </g:if></g:if>
        	 <g:if test="${indApp.inspection==true}">
        	 <g:if test="${inspectionClose==true}">
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
				<td  bgcolor="#BFBFBF" class="headngblue" >Inspection Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>
				
				
				
				
				
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" > </td>
			
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
			 	<% def indMasterDetInst1=IndustryMasterDetailsRecord.findByApplication(indApp)
			 	System.out.println("---indMasterDetInst1----"+indMasterDetInst1)
			 	System.out.println("---applicationProcessingDetailsInstance----"+applicationProcessingDetailsInstance)
				if(indMasterDetInst1 && applicationProcessingDetailsInstance){
					if(applicationProcessingDetailsInstance.application.inspection){ %>
			 <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReport/<%=indApp.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Prepare Inspection Report&nbsp; </a>
			 <%}}%> 
			 				</td></tr>				
        	 </g:if> </g:if>
        	
        	
        	
        	<%if(indApp.indUser.category.name=="GREEN"){ %>
        	<%
        	def check = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where approvalStatus IN ('Approved','Refused') and application=?",[app.application])
       
            if(applicationProcessingDetailsInstance){
            if(check)
      				{
            	 	%>
      				
                	<g:if test="${approve==true}">
     
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue">Do you want to Close Application after Approval ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input id="approve" name="approve" type="radio" value="yes" onclick="enablingDisablingapp(this.id);">
                                <span class="style3">Yes</span>                              
                                <input id="approve1" name="approve" type="radio" value="no" checked="checked" onclick="enablingDisablingapp(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Approval Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea id="approveNote" name="approveNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>				
				 </g:if>
				
	        	 <g:if test="${reject==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to close Application after Refusal ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
			 		                           
                      <input id="reject" name="reject" type="radio" value="yes" onclick="enablingDisablingrej(this.id);"/>
                      <span class="style3">Yes</span>   
                      <input id="reject1" name="reject" type="radio" value="no" checked="checked" onclick="enablingDisablingrej(this.id);">
                      <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue">Refusal Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea id="rejectNote" name="rejectNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>				
				 </g:if>
                      <%}  }%>
                      <%}else{%>
                      <%if(applicationProcessingDetailsInstance){%>
                				
                          	<g:if test="${approve==true}">
               
          				<tr bgcolor="#A8DAF3">
           					<td colspan="2">&nbsp;</td>
           				</tr>
          				<tr >
          				<td  bgcolor="#98AFC7" class="headngblue">Do you want to Close Application after Approval ? : </td>
          			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
          						<input id="approve" name="approve" type="radio" value="yes" onclick="enablingDisablingapp(this.id);">
                                          <span class="style3">Yes</span>                              
                                          <input id="approve1" name="approve" type="radio" value="no" checked="checked" onclick="enablingDisablingapp(this.id);">
                                          <span class="style3">No</span>					</td>
          				</tr>
          				
          				<tr >
          				<td  bgcolor="#98AFC7" class="headngblue" >Approval Note : </td>
          			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
          					  <textarea id="approveNote" name="approveNote" cols="35" class="txt4"></textarea>
          					</span>&nbsp;</td>
          				</tr>				
          				 </g:if>
          				
          	        	 <g:if test="${reject==true}">
          				<tr bgcolor="#A8DAF3">
           					<td colspan="2">&nbsp;</td>
           				</tr>
          				<tr >
          				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to close Application after Refusal ? : </td>
          			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
          			 		                           
                                <input id="reject" name="reject" type="radio" value="yes" onclick="enablingDisablingrej(this.id);"/>
                                <span class="style3">Yes</span>   
                                <input id="reject1" name="reject" type="radio" value="no" checked="checked" onclick="enablingDisablingrej(this.id);">
                                <span class="style3">No</span>					</td>
          				</tr>
          				
          				<tr >
          				<td  bgcolor="#BFBFBF" class="headngblue">Refusal Note : </td>
          			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
          					  <textarea id="rejectNote" name="rejectNote" cols="35" class="txt4"></textarea>
          					</span>&nbsp;</td>
          				</tr>				
          				 </g:if>
                                <%}%> 
                      
                      
                      <%}%>
                      <%}%>
                      
                        </table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td><input name="appId" type="hidden" value="${app.id}"/></td>
			<td align="right"><input type="submit" name="Save" id="Save" value="Send Application" class="draftbutton" onclick="disableButton()" ></td>
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


