<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
String conte=request.getContextPath();
if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(conte+"/index.gsp")	;
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<style type="text/css">

body {
margin-left: 0px;
margin-top: 0px;
margin-right: 0px;
margin-bottom: 0px;
}

.style3 {
color: #186DB5
}

.style5 {
color: #0099FF
}

.style6 {
color: #33FF66;
}

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

.qwe123 {
background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}')
;
padding-left: 23px;
padding-right: 20px;
padding-top: 5px;
padding-bottom: 5px;
}

.qwe123:hover {
background-image: url('${createLinkTo(dir:' images2/ gif ',file:' gray_bg.gif ')}')
;
}

.blue {
background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_gray.gif ')}')
;
padding-left: 30px;
padding-right: 27px;
padding-top: 5px;
padding-bottom: 7px;
}

.blue:hover {
background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}')
;
}

</style>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<%
String cont=request.getContextPath();
%>
</head>

<body>
<table width="1003" border="0" align="center" cellpadding="0"
cellspacing="0">
<tr>
<td align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="91" align="left" valign="top" class="bgtop"><!-- code for spcbHeader  -->
<g:include controller="userMaster" action="showSpcbHeader" /></td>
</tr>
<tr>
<td height="32" align="left" valign="top"
background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
<!-- code for menuIndustryHorizontal--> <%

if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>

<%

if((UserMaster)session.getAttribute("userMaster")){

UserMaster aa = (UserMaster)session.getAttribute("userMaster");

String userType = aa.accessLevel

if(userType.equals("admin")) { %>

<g:include controller="userMaster" action="showAdminMenuHorizontal" />

<% }else{ %> <g:include controller="userMaster"
action="showSpcbUserMenuHorizontal" /> <%}} %> <% if( (!(IndUser)session.getAttribute("indUser") ) &&

(! (UserMaster)session.getAttribute("userMaster") )  )   {%> <g:include
controller="userMaster" action="showIndexMenuHorizontal" /> <% } %>
</td>
</tr>
<tr>
<td align="left" valign="top">
<table width="1003" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="224" align="left" valign="top" bgcolor="#DEEED0">
<!-- code for menuSpcbUser--> <%

if(  (IndUser)session.getAttribute("indUser")  )

{ %> <g:include controller="userMaster"
action="showSpcbIndustryMenu" /> <%} %> <%

if((UserMaster)session.getAttribute("userMaster")){

UserMaster aa = (UserMaster)session.getAttribute("userMaster");

String userType = aa.accessLevel

if(userType.equals("admin")) { %>

<g:include controller="userMaster" action="showAdminMenu" /> <% }else{ %>

<g:include controller="userMaster" action="showSpcbUserMenu" /> <%}} %>
<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
<g:include controller="userMaster" action="showIndexMenu" /> <% } %>
</td>
<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
<td width="778" align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="1" valign="top"></td>
</tr>
<tr>
<td><img
src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778"
height="134" /></td>
</tr> <%
boolean decVar=true;
String firstname;
String lastName;
String access;
String indname;

if((UserMaster)session.getAttribute("userMaster"))
{


UserMaster um=(UserMaster)session.getAttribute("userMaster");
UserProfile aa=(UserProfile)session.getAttribute("userprof");
firstname=aa.employeeFirstName;
lastName=aa.employeeLastName;
access=um.accessLevel;

}

else
{
if(  (IndUser)session.getAttribute("indUser")  )

{
IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
indname=ind.indName;

}
else
{
decVar=false;

}
}






java.util.Date dateSCR = new java.util.Date();
int  year=dateSCR.getYear();
if (year < 1000)
year+=1900;
int date=dateSCR.getDate();
int month=(dateSCR.getMonth()) + 1;


%>




<% if((UserMaster)session.getAttribute("userMaster"))
{
%>

<tr bgcolor="#4C8BC0">
<td  class="top-lnks" >
<table width="100%" >
<tr height="10px">
<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
</tr>
</table>
</td></tr>

<% }

if(  (IndUser)session.getAttribute("indUser")  )

{ %>
<tr bgcolor="#4C8BC0">
<td  class="top-lnks" >
<table width="100%" >
<tr height="10px">
<td>Welcome <%=indname %></td>
<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
</tr>
</table>
</td></tr>

<% } %>
<% 
def viewUploaded =ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='ConsentOrder'",[indApplicationDetailsInstance])
def indMasterDetInst=IndustryMasterDetails.findByIndUser(indApplicationDetailsInstance.indUser)
def inspNote = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Inspection Report'",[indApplicationDetailsInstance])
def viewHWMUploaded =ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='ConsentHWMOrder'",[indApplicationDetailsInstance])
       
%>
<tr>

<td height="24">
<%if(session.getAttribute("userMaster")){

UserMaster aa = (UserMaster)session.getAttribute("userMaster");

String userType = aa.accessLevel
if(userType.equals("admin")||userType.equals("employee")){%>
<a href="#" onclick="window.open('<%=cont%>/applicationProcessingDetails/openApplicationDetails/${indApplicationDetailsInstance.id}', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
<%if(viewCert){%>
<g:link controller="applicationProcessingDetails" action="downLoadingCertificate"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View Consent Order&nbsp;|</span></g:link>
<%}
if(indMasterDetInst){%>
<a href="#" onclick="window.open('<%=request.getContextPath()%>/industryMasterDetails/viewIndustryMaster/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=225,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Industry Master Data&nbsp;|</span></a>
<%}}}%>


<% def refused_ins=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? and approvalStatus='Refused' order by dateCreated desc limit 1",[indApplicationDetailsInstance]);
if(viewUploaded){
	if(refused_ins){ %>
		<g:link action="downLoadingCertificate1"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View Uploaded Refusal Order&nbsp;|</span></g:link>
	<% }else{
		%>
		<g:link action="downLoadingCertificate1"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View Uploaded Consent Order&nbsp;|</span></g:link>
<%}}
if(inspNote){%>
<g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="printInspectionNote" controller="applicationProcessingDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink"></span></g:link>
<%}%>



<%if(indApplicationDetailsInstance.hazardeousType=="HWM"){%>


	<%if(viewHWMUploaded){%>
		<g:link controller="applicationProcessingDetails" action="downLoadingConsentHWMCertificate"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View Authorization Order&nbsp;|</span></g:link>
	<%}%>

<%}%>

<a href="#" onclick="window.open('<%=cont%>/inspectionManagement/showInspectionNoteHistroy?typeOfInspection=REGULAR_INSPECTION&id=${indApplicationDetailsInstance.id}', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink"></span></a>
<%def appFileRecordForCheckList = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Regular Inspection Report'",[indApplicationDetailsInstance])
	  if(appFileRecordForCheckList){%>
	  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openCerificate?id=<%=indApplicationDetailsInstance.id%>&docName=Regular Inspection Report', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink"></span></a>
		
    <%}%>
</td>


<td height="24">

</td>

</tr>
<tr>
<td height="0" align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<!-- Div area for errors-->
<td align="center" valign="top">
<div
style="width: 400px;  vertical-align: middle"><span
class="error"> <g:if test="${flash.message}">
<div class="message">${flash.message}.</div>
</g:if>
<g:hasErrors bean="${unitMasterInstance}">
<div class="errors">
<g:renderErrors bean="${unitMasterInstance}" as="list" />
</div>
</g:hasErrors></span></div>
</td>
</tr>
<!--<tr>
<td align="center" valign="top">Row for Page Heading</td>
</tr>-->
<tr>
<td height="0" align="left" valign="top">
<table width="720" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="50" align="center" valign="top">&nbsp;</td>
<td align="left" valign="top">
<div style="padding: 0px 0px 0px 0px;"><br />
<div style="border":1px solid gray; width:760px; margin-bottom: 1em; padding: 10px" >
<table width="760" border="0" align="center" cellpadding="0"
cellspacing="0" id="countrytabs">
<tr valign="middle">
<td width="90%" align="left">


<%
String appFor1 = indApplicationDetailsInstance.applicationFor ;

%>

<ol id="toc">
<li><a href="#country1"><span>General</span></a></li>
<li><a href="#country7"><span>Enclosures</span></a></li>
<%if(appFor1.equals("both")) {%>
<li><a href="#country9"><span>Other</span></a></li>
<li><a href="#country2"><span>Product/Cost</span></a></li>
<li><a href="#country4"
title="Water Emission/Discharge"><span>W Emiss./Disch.</span></a></li>

<%}
						def a4 = indApplicationDetailsInstance.indUser.category.id
			
				 if (((a4==1)||(a4==2))&& appFor1.equals("both")){ %>
<li><a href="#country10"><span>HWM</span></a></li>
<% }
						 if(appFor1.equals("both")) {
						  %>
<li><a href="#country6"><span>Air
                                                            Emission</span></a></li>

<%}%>
<% if(indApplicationDetailsInstance.hazardeousType=="HWM"){ %>
<li><a href="#country50" title="Hazardous Wastes Management"><span>Solid Waste</span></a></li>
<% } %>
<li><a href="#country3"><span>Fee</span></a></li>
<%if((appFor1.equals("stonecrusher")) || (appFor1.equals("hotmixplants")) || (appFor1.equals("stonecrusher and hotmixplants"))) {%>
<li><a href="#country2"><span>Product</span></a></li>
<li><a href="#country12"><span>Stone Crusher/Hot mix plants</span></a></li>
<%}%>
<%if(appFor1.equals("dgset")) {%>
<li><a href="#country13"><span>D.G.Set</span></a></li>
<%}%>
<%if(appFor1.equals("brickkilns")) {%>
<li><a href="#country2"><span>Product</span></a></li>
<li><a href="#country14"><span>Brick Kilns</span></a></li>
<%}%>
<%if(appFor1.equals("hotel")) {%>
<li><a href="#country15"><span>Hotel</span></a></li>
<%}%>
</ol>

</td>
<td align="left">

<%if(indApplicationDetailsInstance.completionStatus != "pending"){ %>
<% if(indApplicationDetailsInstance.applicationFor.equals("air")) { %>

<font size="1" face="Verdana">Print Form </font>
<g:def var="versionVal" value="air"/> <g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink"><u>Air</u></span></g:link>
<!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FormAir&docType=pdf"><span class="innerlink"><u>Air</u></span></a> -->
<% }else if(indApplicationDetailsInstance.applicationFor.equals("water")){%>
<font size="1" face="Verdana">Print Form </font>
<g:def var="versionVal1" value="water"/> <g:def var="fooVar1" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar1,verValue:versionVal1]"><span class="innerlink"><u>Water</u></span></g:link>
<!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FromWaterPdf&docType=pdf"><span class="innerlink"><span class="innerlink"><u>Water</u></span></span></a> -->
<%}else{ %>
<font size="1" face="Verdana">
<!--		Print(<g:def var="versionVal" value="air"/> <g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink"><u>Air</u></span></g:link>| --> Print ( <g:def var="versionVal1" value="water"/> <g:def var="fooVar1" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar1,verValue:versionVal1]"><span class="innerlink"><u>Form</u></span></g:link> <!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FormAir&docType=pdf"><span class="innerlink"><u>Air</u> </span></a>|<a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FormWater&docType=pdf"><span class="innerlink"><u>Water</u></span></a> -->)</font>
<%}
}%>


</td>

</tr>
</table>

<div class="content" id="country1">
<table width="100%" border="0" align="center" cellpadding="0"
cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
style="border-collapse: collapse;">
<tr>
<td bgcolor="#FFFFFF">



<table width="100%" border="0" align="left"
cellpadding="2" cellspacing="1" class="tblbdr">

<tr bgcolor="#D1D1D1">
<td colspan="2" align="center" valign="middle"
class="headngblue">General Details</td>
</tr>

<tr>
<td width="35%" align="left" valign="middle"
bgcolor="#A8DAF3" class="headngblue">Consent
                                                                    Type<span style="color:red">*</span>:</td>
<td width="65%" align="left" bgcolor="#E8F6F9"
class="headngblue">${fieldValue(bean:indApplicationDetailsInstance,
field:'applicationType')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Consent For<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indApplicationDetailsInstance,
field:'applicationFor')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Application For<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indApplicationDetailsInstance,
field:'certificateFor')}</td>
</tr>

<tr bgcolor="#D1D1D1">
<td colspan="2" align="center" valign="middle"
class="headngblue">Industry/Hotel Information</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry/Hotel Name<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.indName}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Category:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.category}</td>
</tr>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Scale of Industry:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.industryScale}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry Type:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.industryType}</td>
</tr>


<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Other Industry Type Detail:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.indTypeOther}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry Status:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indStatus')}</td>
</tr>
<%if(appFor1.equals("hotel")) {%>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Hotel Area:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'hotelArea')}</td>
</tr>
<%}%>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Commisioning Year:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${industryRegMasterInstance?.dateOfComm}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry Registration/ License/DIC No<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indRegNum')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Capital Investment<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indCapInvt')} &nbsp;Lakhs</td>
</tr>
<!--
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Capital Investment of Land<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
&nbsp;Lakhs</td>
</tr>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Capital Investment of Building<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
 &nbsp;Lakhs</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Investment:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">&nbsp;Lakhs</td>
</tr>
-->
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Address<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indAddress')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Village/City:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indCity')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Pin:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indPin')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">S.T.D. Code(Phone)<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indPhoneCode')}</td>
</tr>


<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Phone No<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indPhoneNo')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Fax Code :</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indFaxCode')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Fax No. :</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indFaxNo')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">E-Mail Address:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indEmail')}</td>
</tr>

<tr bgcolor="#D1D1D1">
<td colspan="2" align="center" valign="middle"
class="headngblue">Occupiers Details</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Name:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occName')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Designation:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occDesignation')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Residential Address:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occAddress')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Status Of Aplicant:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'statusOfAppl')}</td>
</tr>
<tr class="headngblue txt4" >

<td align="left" class="headngblue" bgcolor="#A8DAF3">Name of Directors/Partner/Proprietor with Contact Details :</td>

      <td align="left"class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance,field:'nameAddressPartners')}</td>

      </tr>
      

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Village/City:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occCity')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Pin:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occPin')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">S.T.D. Code(Phone)<span style="color:red">*</span>:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occPhoneCode')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Phone No<span style="color:red">*</span>:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occPhoneNo')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Fax Code :</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occFaxCode')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Fax No. :</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occFaxNo')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Mobile No:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occMobile')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Email Address:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occEmail')}</td>
      </tr>



      </table>





      </td>
      </tr>
      </table>




      <br />
      </div>

      <div class="content" id="country9">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">
              <table width="100%" border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td colspan="2" align="center" valign="middle" class="headngblue">Other Details</td>
                </tr>
                <%	
				 if ((a4==1)||(a4==2)){ %>
                <tr>
                  <td align="left" width="60%" valign="middle" bgcolor="#A8DAF3" class="headngblue">Equipments To Which Separate Meters Are Installed For Recording Consumption Of Electric Energy:</td>
                  <td align="center" width="40%" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'equipWithSepMeters')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Equipments Connected To D.G.Set:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'equipDGSet')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Tree Plantation/Green Belt Development(in hectares):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'treePlantDev')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details Of Schemes For Waste Minimization/Resource Recovery/Recycling Implementation:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'wasteMinDetail')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is Industry Comes Under Public Hearing:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'underPubHearing')}</td>
                </tr>
                <%	
				 } %>
                <tr>
                  <td align="left" width="60%" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is Site Located Near River Bank/Water Bodies:</td>
                  <td align="center" width="40%" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'nearRiver')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.nearRiver=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name Of River/Water Body:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'riverName')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Distance From River Bank/Water Body:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'riverDist')}</td>
                </tr>
<%}%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Site Located Near Residential Colony:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'nearResidCol')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.nearResidCol=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Population Of Colony:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'colPopulation')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Location Of Colony:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'colLocation')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Distance:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'colDistance')}</td>
                </tr>
<%}%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Site Located Near Industrial Estate:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'nearIndEstate')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.nearIndEstate=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether Collection, Treatment & Disposal System Provided:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'disposalSysProv')}</td>
                </tr>
<% if(industryRegMasterInstance.disposalSysProv=="Yes"){%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Will Applicant Utilize The System:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'utilizeSys')}</td>
                </tr>
<% if(industryRegMasterInstance.utilizeSys=="No"){%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details Of Proposal:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'proposalDetails')}</td>
                </tr>
<%}%>
<%}%>
<%}%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Plot Area (in square meter):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'totalPlotArea')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Build-up Area (in square meter):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'plotArea')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Area used for Treated Sewage/Trade Effluent (in square meter):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'builtUpArea')}</td>
                </tr>
<%	
				 if ((a4==1)||(a4==2)){ %>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Project Cost (in Rs.):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'totalProjectCost')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Inv. Proposed on Pollution/Env. Protection (in %):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'pollutionMonitoringCost')}</td>
                </tr>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are sewage & trade effluents mixed together ?:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'sewage')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.sewage=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">At which state ?:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'sewageState')}</td>
                </tr>

<%}%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity of Treated Effluent :</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'treatedEffCapacity')}</td>
                </tr>
                <tr align="center" bgcolor="lightgrey" rowspan="2">
                  <td width="30%" align="center" valign="middle" colspan="2"
                      class="headngblue">Non-Hazardeous Solid Waste Details<span style="color:red"></span></td>

                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Non-Hazardous Solid Waste:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'nonHwmProdName')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Area of Land:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'landArea')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'prodCapacity')}</td>
                </tr>
<%	
				 } %>

              </table>
            </td>
          </tr>
        </table>

      </div>





      <div class="content" id="country2">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Product/Estimeted Cost Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td width="90%" align="center" valign="middle"
                      class="headngblue">Product Details</td>

                  <td width="10%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popProductDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>
 <%
				 	def a2 = indApplicationDetailsInstance.indUser.category.id
			
				 if(appFor.equals("both")&&((a2==1)||(a2==2))) 
				 {%>
                <tr>
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Estimeted Cost Details</td>

                  <td width="30%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEstimetedDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>
<%}%>
              </table>

            </td>
          </tr>
        </table>


        <br />
      </div>

      
      <div class="content" id="country50">
	  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
	  <tr><td bgcolor="#FFFFFF">
		
		
		
		<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
	
		<tr bgcolor="#D1D1D1">
				<td width="70%"   align="center" valign="middle"  class="headngblue">Hazardous Waste</td>
				<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue">Action</td> 
		</tr>
		
			<tr>
				<td width="70%" align="center" valign="middle"  class="headngblue">Activity/Hazardous Waste Generation Details</td>
				<td width="30%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</a></td>
			</tr>
		
		
		
	
	 
	 <tr >
															<td align="center" valign="middle" class="headngblue">Mode of storage</td>
															<td align="center" valign="middle" class="headngblue">
															<table width="100%">
																<tr>

																	<td align="center">
																	<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoreModeView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>

																</tr>
															</table>
															</td>
														</tr>
														
														
														 <tr >
															<td align="center" valign="middle" class="headngblue">Quantity of Hazardous waste disposed</td>
															<td align="center" valign="middle" class="headngblue">
															<table width="100%">
																<tr>

																	<td align="center">
																	<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popQuantHazView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>

																</tr>
															</table>
															</td>
														</tr>
														
														
														 <tr >
															<td align="center" valign="middle" class="headngblue">Hazardous substances used</td>
															<td align="center" valign="middle" class="headngblue">
															<table width="100%">
																<tr>

																	<td align="center">
																	<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazsubView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>

																</tr>
															</table>
															</td>
														</tr>
														
														 <tr >
															<td align="center" valign="middle" class="headngblue">Hazardous waste is being produced</td>
															<td align="center" valign="middle" class="headngblue">
															<table width="100%">
																<tr>

																	<td align="center">
																	<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazwasteView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>

																</tr>
															</table>
															</td>
														</tr>
														
														 <tr>
										                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total cost on pollution control (in Rupees):</td>
										                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'totalCostPoll')}</td>
										                </tr>
	 									
												
	 
	 

		
		
		<tr bgcolor="#F4F7FB" class="headngblue">
		        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" width="70%">Whether the unit is generating hazardous waste as defined in the Hazardous Waste(Management and handling)Rules, 1989, as amended.:</td>
				<td width="65%" align="left" bgcolor="#E8F6F9"
										class="headngblue">${industryRegMasterInstance?.possibilityOfRecovery}
								<g:def var="fooVar9999" value="${indApplicationDetailsInstance.id}"/>
													
																
																
																</td>
		</tr>
	
	    		

		<tr bgcolor="#F4F7FB" class="headngblue">
		        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" width="70%">Present treatment of hazardous Waste, if any:</td>
				<td width="65%" align="left" bgcolor="#E8F6F9"
										class="headngblue">${industryRegMasterInstance?.present}
								
													
																
																
																</td>
		</tr>		
		
		<tr bgcolor="#F4F7FB" class="headngblue">
        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" width="70%">If yes, give type and capacity of treatment units:</td>
		<td width="65%" align="left" bgcolor="#E8F6F9"
								class="headngblue">${industryRegMasterInstance?.presentdetails}
						
											
														
														
														</td>
</tr>		
		
			 
			 
			
	  </table>
		</td></tr>
		</table>		
	  
	  
       <br/>
      </div>
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

      <div class="content" id="country3">

        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">
              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td colspan="2" align="center" valign="middle"
                      class="headngblue">Fee Details (Water
                                                                    Consumptions)</td>
                </tr>

                <tr>
                  <td width="60%" align="left" valign="middle"
                      bgcolor="#A8DAF3" class="headngblue">Category:</td>
                  <td width="40%" align="left" bgcolor="#E8F6F9"
                      class="headngblue">${fieldValue(bean:industryRegMasterInstance,
field:'category.name')}</td>
                </tr>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Capital Investment (In Lakhs):</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,
field:'indCapInvt')}</td>
                </tr>
<%if(indApplicationDetailsInstance.certificateFor.equals("new") ) {%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Number of Year<span style="color:red">*</span>:</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInstance,
field:'noOfYears')}</td>
                </tr>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Fee Applicable (In Rupees):</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${fieldValue(bean:consentFeeMasterInstance,
field:'totalApplicableFee')}</td>
                </tr>
<%}else if(indApplicationDetailsInstance.certificateFor.equals("reNew") || indApplicationDetailsInstance.certificateFor.equals("expan") ||indApplicationDetailsInstance.certificateFor.equals("Modern") ){%>




<td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Number of renewal Years<span style="color:red">*</span>:</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInstance,
field:'noOfYearsadditionalYears')}</td>
                </tr>


 <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Fee for Additional Year Renewal Applied(In Rupees)</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${fieldValue(bean:consentFeeMasterInstance,
field:'outstandingDueBrd')}</td>
                </tr>
                <tr>


<%}%>
                <tr bgcolor="#D1D1D1">
                  <td colspan="2" align="center" valign="middle"
                      class="headngblue">Bank Details</td>
                </tr>
<%
									
								def feesOnline = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
									
									
									def feesBank = FeeBankDetails.find("from FeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])
									
									
									def feesBankOnline = BankTransactionDetails.find("from BankTransactionDetails fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
									%>
											
             <tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1 ,resizable=yes');">
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
																			onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
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
																			onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popChallan/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
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


            </td>
          </tr>
        </table>



        <br />
      </div>


      <div class="content" id="country6">
<%if((indApplicationDetailsInstance.applicationFor).equals("air")||(indApplicationDetailsInstance.applicationFor).equals("both")) {%>
        <table width="100%" border="0" align="center"
               cellpadding="0" cellspacing="1" bgcolor="#A5CAF4"
               class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">


              <table id="22" width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Air Emission</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

<%
			
			def a1 = indApplicationDetailsInstance.indUser.category.id
			if(a1==4)
			{
			
			%>
			
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Boiler Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBoilerDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			  
			  
			  <tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Furnace Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFurnaceDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			
			  <tr>
                  <td align="center" valign="middle" class="headngblue">Miscellaneous Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popMiscellaneousView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
			
			
			<%}else{%>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Stack Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Flue Gas Emission Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFlueEmmisionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
               <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Air Miscellaneous Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirMiscDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

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



<%}else{ %>
        <div class="headngblue" align="center">Not Applicable</div>
<% } %> <br />

      </div>


      <div class="content" id="country4">
<%if((indApplicationDetailsInstance.applicationFor).equals("water")||(indApplicationDetailsInstance.applicationFor).equals("both")) {%>
        <table width="100%" border="0" align="center"
               cellpadding="0" cellspacing="1" bgcolor="#A5CAF4"
               class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">


              <table id="22" width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Water Emission/Discharge</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

<%
			def a = indApplicationDetailsInstance.indUser.category.id
			if(a==4)
			{
			
			%>
<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Water Usage Detail</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterUsageDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Waste Water Discharge</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteDischargeView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			  <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Solid Wastes Generation Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>


			
			
			<%}
			
			else
			{
			%>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Source
                                                                    of Water, Use and Consumption Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Waste
                                                                    Water Treatment Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterTreatmentView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Waste
                                                                    Water Discharge</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteGenView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

              

<%}
			
			%>
              </table>
            </td>
          </tr>
        </table>

        <br />



<%}else{ %>
        <div class="headngblue" align="center">Not Applicable</div>
<% } %> <br />

      </div>

      <div class="content" id="country10">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Hazardous Waste Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td width="90%" align="center" valign="middle"
                      class="headngblue">Activity/Hazardous Waste Generation Details</td>

                  <td width="10%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>

                <tr>
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Storage/Disposal Details</td>

                  <td width="30%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStorageDisposalDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Hazardous Chemical Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardousChemicalView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>


              </table>

            </td>
          </tr>
        </table>


        <br />
      </div>

      <div class="content" id="country13">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">D.G.Set Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">D.G. Set Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGsetView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">D.G. Set Emission Source Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGSourceView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">D.G. Set Parameter Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGParameterView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
		

              </table>
            </td>
          </tr>


        </table>

      

        <br />
      </div>

      <div class="content" id="country12">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Stone Crusher/Hot mix plants Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Stone Crusher/Hot mix plants Siting Criteria Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneSittingCriteriaView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Stone Crusher/Hot mix plants Pollution Control Devices Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneCrusherControlDevicesView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                	<tr >
                  <td align="center" valign="middle" class="headngblue">NOC Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popNocAuthorityView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

		<tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Water Source Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Water Consumption Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

              </table>
            </td>
          </tr>


        </table>

       
        <br />
      </div>




      <div class="content" id="country15">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">

              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Hotel/Restaurant Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Hotel/Restaurant General Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelOtherDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Hotel/Restaurant Facility Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelFacilityView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Hotel/Restaurant Waste Emmission Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWasteEmissionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                
                  <tr >
                  <td align="center" valign="middle" class="headngblue">Water Source Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Water Consumption Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWaterConsumptionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>


        </table>

       
        <br />
      </div>




      <div class="content" id="country7">

        <table width="100%" border="0" align="center"
               cellpadding="0" cellspacing="1" bgcolor="#A5CAF4"
               class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">


              <table id="22" width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue" colspan="2">Enclosures Details</td>

                </tr>

                <g:def var="dList" value="${DocumentChecklistMaster.list()}" />

                <g:each var="doc" in="${listDoc}">
                  <tr>
                    <td width="60%" align="left" valign="middle"
                        bgcolor="#A8DAF3" class="headngblue">${doc.level}</td>
                    <td width="40%" align="left" bgcolor="#E8F6F9"
                        class="headngblue"><g:def var="fooVar"
                                              value="${indApplicationDetailsInstance.id}"/><g:def var="docN" value="${doc.level}"/> <g:link
                                              action="viewFile1"
                                              params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
                  </tr>
                </g:each>


              </table>
            </td>
          </tr>
        </table>

        <br />


      </div>


      <div class="content" id="country14">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">

              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Brick Kiln Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Brick Siting Criteria Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickSittingCriteriaView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Brick Kilns Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickKilnView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
<tr>
                  <td align="center" valign="middle" class="headngblue">Water Source Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Water Consumption Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>


        </table>

       
        <br />
      </div>


<%		def applicationProcessingDetailsInstanceList =  ApplicationProcessingDetails.findAllByApplication(indApplicationDetailsInstance,[sort:'dateCreated',order:'desc',offset:0]) 


ArrayList rr = applicationProcessingDetailsInstanceList.clarification
def testVal =false

	def inspecValList1 = new ArrayList()
	
	
if(indApplicationDetailsInstance.clarification == true){
	testVal = true
        }




%><% 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
<!-- code by Vikas Rathore -->
<%
def returnStatus = ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application=? order by id desc",[indApplicationDetailsInstance])
System.out.println("returnStatus.on doShow."+returnStatus)
if(returnStatus)
{
	System.out.println("returnStatus.on doShow...resubmitStatus"+returnStatus.resubmitStatus)
	System.out.println("returnStatus.on doShow...returned"+returnStatus.returned)
	if(returnStatus.returned==true && returnStatus.resubmitStatus!=true){
		testVal=true%>
		<table width="100%">
        <g:form name="general" method="post" action="doGetShow">
        <input type="hidden" name="testVal" value="<%=testVal%>" />
          <tr>
            <input type="hidden" name="edit" value="1" />
            <input type="hidden" name="appId"
                   value="<%=indApplicationDetailsInstance.id%>" />
            <td align="center"><input type="submit" name="Edit"
                                      value="Edit" class="actionbutton"></td>

          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
        </g:form>
      </table>
      
		<%
		
	}
}
%>
<!-- code ended by Vikas Rathore -->


<%if(indApplicationDetailsInstance.completionStatus == "pending"){ %>
      <table width="100%">
        <g:form name="general" method="post" action="doGetShow">
        <input type="hidden" name="testVal" value="<%=testVal%>" />
          <tr>
            <input type="hidden" name="edit" value="1" />
            <input type="hidden" name="appId"
                   value="<%=indApplicationDetailsInstance.id%>" />
            <td align="center"><input type="submit" name="Edit"
                                      value="Edit" class="actionbutton"></td>
            <!--<td align="center"><input type="submit" name="cancel" value="Cancel" class="actionbutton"></td>-->
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
        </g:form>
      </table>
<%}} %>
      </div>


      </div>
      </td>
      <td width="50" align="left" valign="top">&nbsp;</td>
      </tr>
      </table>
      </td>
      </tr>

      </table>
      </td>
      </tr>

      </table>
      </td>
      </tr>
      </table>
      </td>
      </tr>
      <!-- code for spcb Footer -->
      <g:include controller="userMaster" action="showSpcbFooter" />
      </table>
      </td>
      </tr>
      </table>

      </body>
      </html>


