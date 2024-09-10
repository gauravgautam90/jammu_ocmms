<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">

<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>

<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



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

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>

<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

</head>

<body >
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr>

<%
String dd1;
String dd2;
String dd3;
if(sqlDate)
{
java.util.Date utilDate1 = new java.util.Date(sqlDate.getTime());
java.util.Date utilDate2 = new java.util.Date(sqlDate2.getTime());
java.util.Date utilDate3 = new java.util.Date(sqlDate3.getTime());

SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

dd1=dmyFormat.format(utilDate1);
dd2=dmyFormat.format(utilDate2);
dd3=dmyFormat.format(utilDate3);
}
%>
<td colspan="9" align="center" >
<span class="headngblue">
      <span style="color:red;font-size:13px;">Complete Status</span> 
      <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
</span>
</td>
</tr>
</table>


<table width=100% align="center" cellpadding="0" border="2" style="border:3px solid green;" cellspacing="0"  class="tab-txt">
<tr width="200%" bgcolor="#A8DAF3"  >
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >S.No</th>
   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application ID</th>
   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application Name</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Industry Type</th>
   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Category</th> 
   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application Date</th> 
     
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Consent For</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Status</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Pending With/Forwarded To</th> 
  
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >District</th>
   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Pending Officer</th> 
   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Note History</th> 
     
</tr>
<g:each in="${appSummary}" status="i" var="appSummaryInstance">
<%String applicationFor = appSummaryInstance.applicationFor

if(applicationFor.equals("brickkilns")){
applicationFor="Brick Kilns"
}
if(applicationFor.equals("both")){
applicationFor = "Industry "
}
if(applicationFor.equals("stonecrusher")){
applicationFor = "Stone Crusher"
}
if(applicationFor.equals("hotmixplants")){
    applicationFor = "Hot mix plants"
    }
if(applicationFor.equals("stonecrusher and hotmixplants")){
    applicationFor = "Stone Crusher and Hot mix plants"
    }
if(applicationFor.equals("hotel")){
 applicationFor = "Hotel"
}
if(applicationFor.equals("dgset")){
 applicationFor = "DGSet"
}
String consentFor = appSummaryInstance.certificateFor

if(consentFor.equals("new")){
consentFor="Fresh"
}
if(consentFor.equals("expan")){
    consentFor = "Expansion"
    }
if(consentFor.equals("Modern")){
consentFor = "Modernization"
}
if(consentFor.equals("reNew")){
 consentFor = "Renew"
}%>
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<td align="center" ><%=i+1%></td>
<td align="center" ><%=appSummaryInstance.applicationId%></td>
<td align="center" ><%=appSummaryInstance.applicationName%></td>
<td align="center" ><%=applicationFor%></td>
<% def cat=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application.id=?",[(appSummaryInstance.applicationId).toLong()])
String category="" 
if(cat){
category=cat.application.indUser.category.name
category=category.replace("[","")
category=category.replace("]","") }%>
<td align="center" ><%=category%></td>

<td align="center" ><%=appSummaryInstance.applicationRecieptDate%></td>
<td align="center" > ${appSummaryInstance.applicationType} ( <%=consentFor%> )</td>
<td align="center" ><%=appSummaryInstance.applicationStatus%></td>
<td align="center" ><%=appSummaryInstance.pendingWith%></td>

<td align="center" ><%=appSummaryInstance.districtName%></td>
<td align="center" ><%=appSummaryInstance.officerName%></td>
<%if(appSummaryInstance.applicationId){%>
<td align="center" >
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openApplicationDetails?id=<%=appSummaryInstance.applicationId%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">Note History</a>
</td>
   <%} %>
   </tr>
   </g:each>

                </table>
		
		</div>
	

</body>
</html>