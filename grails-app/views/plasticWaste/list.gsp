<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Application For Authorization</title>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet"
type="text/css"href="${createLinkTo(dir:'css',file:'tabcontent.css')}"
/>
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
<script type="text/javascript"src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript"src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<g:javascript library="prototype" />
<link rel="stylesheet" type="text/css"
href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<script type="text/javascript"
src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow-x:hidden; 
	overflow-y:auto;
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
span.smallfont {color:#ffffff;font-weight:bold;font-size:11px;}


-->
</style>
<script type="text/javascript">
  function random_number(min,max) {
return(Math.round((max-min) * Math.random() + min));
}
</script>

<script type="text/javascript" src="js/tabcontent.js"></script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<script language="javascript" type="text/javascript">

function popitup(url) {
newwindow=window.open(url,'name','height=200px,width=500px');
if (window.focus) {newwindow.focus()
 }
return false;
}

</script>
</head>
<body>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
<td align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="91" align="left" valign="top" class="bgtop">
<!-- code for spcbHeader  -->
<g:include controller="userMaster" action="showSpcbHeader" />
</td>
</tr>
<tr>
<td height="32" align="left" valign="top"
background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
<!-- code for menuAdminHorizontal-->
<%
if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
<%
  if((UserMaster)session.getAttribute("userMaster")){
  UserMaster aa = (UserMaster)session.getAttribute("userMaster");
String userType = aa.accessLevel;
if(userType.equals("admin")) { %> <g:include controller="userMaster"
action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
<%
if( (!(IndUser)session.getAttribute("indUser") ) &&
      (! (UserMaster)session.getAttribute("userMaster") )  )   {
      %>
      <g:include controller="userMaster" action="showIndexMenuHorizontal" />
      <%
      }
      %>
</td>
</tr>
<tr>
<td align="left" valign="top">
<table width="1003" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width="224" align="left" valign="top" bgcolor="#DEEED0">
<!-- code for menuAdmin-->
 
 <%if(  (IndUser)session.getAttribute("indUser")  ){ %>
                       
                       <g:include controller="userMaster" action="pwmIndustryMenuVertical"/><%} %>
          
          <%if((UserMaster)session.getAttribute("userMaster")){
                       UserMaster aa =(UserMaster)session.getAttribute("userMaster");
                       String userType = aa.accessLevel
                             
      if(userType.equals("admin")) { %>
                             <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>
                       <%    }else{ %>
                             <g:include controller="userMaster" action="eWasteEmpMenuVertical"/>
                       <%    }
                  } %>
        
        <% if( (!(IndUser)session.getAttribute("indUser") ) && (!(UserMaster)session.getAttribute("userMaster")))  {%>
              <g:include controller="userMaster" action="showIndexMenu"/>
        <% } %>
</td>
<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
<td width="778" align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="1" valign="top"></td>
</tr>
<tr>
<td>
<img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778"
height="134" />
<%
boolean decVar=true;
String firstname;
String lastName;
String access;
String indname;
if((UserMaster)session.getAttribute("userMaster")){
            UserMaster um=(UserMaster)session.getAttribute("userMaster");
      UserProfile aa=(UserProfile)session.getAttribute("userprof");
            firstname=aa.employeeFirstName;
            lastName=aa.employeeLastName;
            access=um.accessLevel;
        }else if((IndUser)session.getAttribute("indUser")){
IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            indname=ind.indName;
}else{
decVar=false;
}
              java.util.Date dateSCR = new java.util.Date();
              int  year=dateSCR.getYear();
              if (year < 1000)
                      year+=1900;
                int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
              %>
</td>
</tr>
<tr>
<td height="24" bgcolor="#EEEEF3">
<table width="100%">
<%
if((UserMaster)session.getAttribute("userMaster"))
{
%>
<tr>
<td class="top-lnks">
<table width="100%">
<tr height="10px">
<td>Welcome <%=firstname %>&nbsp;<%=lastName %>(<%=access %>)</td>
<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month
%>-<%=year %></td>
</tr>
</table>
<td>
</tr>
<% }
if(  (IndUser)session.getAttribute("indUser")  )
{
%>
<tr bgcolor="#4C8BC0">
<td class="top-lnks">
<table width="100%">
<tr height="10px">
<td>Welcome <%=indname %></td>
<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month
%>-<%=year %></td>
</tr>
</table>
</td>
</tr>
<% }
%>
<tr>
<td>&nbsp;</td>
</tr>
</table>
</td>
</tr>
<tr>
<td height="0" align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
<td height="0" align="left" valign="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
<td>&nbsp;</td>
</tr>
<tr>
<td width="82" align="left" valign="top">
&nbsp;
</td>
<td align="left" valign="top">
<div style="padding: 0px 0px 0px 0px;">
<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
<tr valign="middle">
<td width="78%" align="center">
<ol id="toc">
<li><a href="#country1"><span>InProgress Application</span></a></li>
<li><a href="#country2"><span>Completed Application</span></a></li>
</ol>
</td>
<td width="30%" align="right">
</td>
</tr>
</table>
<div id="country1" class="content">
<div class="dialog">
<table width="76%"  border="0" align="left" cellpadding="2"
cellspacing="1" class="tblbdr">
<tr>
                        <td valign="top" bgcolor="#FFFFFF">
                        <table width="100%" border="1" align="center"
cellpadding="0" cellspacing="0" class="tblbdr"
style="border-collapse:collapse;">
<thead >
<tr height="20" bgcolor="#A8DAF3">
    <th align="center" class="headngblue" >Application No</th>
    <th align="center" class="headngblue" >Application For</th>
   <th align="center" class="headngblue" >Authorization Required For</th> 
   <th align="center" class="headngblue" >Application Date</th> 
  </tr>
  </thead>
  <tbody>
<%if(municipalSolidWasteInprogressList1.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Plastic Waste Application List Is Empty</td></tr><%}else{ %>
	                    																						<%}%>
	                    																						<g:each in="${municipalSolidWasteInprogressList1}" status="i" var="municipalSolidWasteInstance">
	                        																						<% 
																								                        SimpleDateFormat sdfDestination1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate1 = sdfDestination1.format(municipalSolidWasteInstance.dateCreated );
																							                        %>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><g:link controller="plasticWaste" action="show" id="${municipalSolidWasteInstance.id}">${fieldValue(bean:municipalSolidWasteInstance, field:'id')}</g:link></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">Plastic Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:municipalSolidWasteInstance, field:'activityAuthorizationSoughtFor')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate1%></font></td>
	                        																					</tr>
	                        																					</g:each>


																					</tbody>

  



  </tbody>
</table>
</td>
 </tr>
</table>






</div>
</div>
<div id="country2" class="content">
<div class="dialog">
<table width="76%"  border="0" align="left" cellpadding="2"
cellspacing="1" class="tblbdr">
<tr>
                        <td valign="top" bgcolor="#FFFFFF">
                        <table width="100%" border="1" align="center"
cellpadding="0" cellspacing="0" class="tblbdr"
style="border-collapse:collapse;">
<thead >
<tr height="20" bgcolor="#A8DAF3">
    <th align="center" class="headngblue" >Application No</th>
    <th align="center" class="headngblue" >Application For</th>
    <th align="center" class="headngblue" >Authorization Required For</th>
    <th align="center" class="headngblue" >Application Date</th>
    <th align="center" class="headngblue" >Application Status</th>
    <th align="center" class="headngblue" >Scrutiny Status</th>
   <th align="center" class="headngblue" >Pending With</th>
  </tr>
  </thead>
  <tbody>

<%if(municipalSolidWasteCompletedList1.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Plastic Waste Application List Is Empty</td></tr><%}else{ %>
	                    																						<%}%>
	                    																						<g:each in="${municipalSolidWasteCompletedList1}" status="i" var="municipalSolidWasteInstance">
	                        																						<% 
	                        																						    def pendingWith1=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wmpd where wmpd.applicationId=?",[(municipalSolidWasteInstance.id).toString()])
																								                        SimpleDateFormat sdfDestination4 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate4 = sdfDestination4.format(municipalSolidWasteInstance.dateCreated );
																							                        %>
																							                        <% String colorCode1;
																								                         if(municipalSolidWasteInstance.applicationStatus=="approved" || municipalSolidWasteInstance.applicationStatus=="rejected"){ 
																								                        	 colorCode1="green";
																								                        }else if (municipalSolidWasteInstance.applicationStatus=="Inprogress" || municipalSolidWasteInstance.applicationStatus=="unattended"){
																								                        	 colorCode1="brown";
																								                        }
																						                        	%>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><g:link controller="plasticWaste" action="show" id="${municipalSolidWasteInstance.id}">${fieldValue(bean:municipalSolidWasteInstance, field:'id')}</g:link></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>">Plastic Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>">${fieldValue(bean:municipalSolidWasteInstance, field:'activityAuthorizationSoughtFor')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>"><%=strDate4%></font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>">${fieldValue(bean:municipalSolidWasteInstance, field:'applicationStatus')}</font>
	                            																					<%if(municipalSolidWasteInstance.applicationStatus=="returned"){%>
	                            																					<br>
	                            																					   <a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/viewReturnReasonForPWaste?id=${municipalSolidWasteInstance.id}&applName=pWaste', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>
	   	                            																				<%}%></td>
	                            																					<% if(municipalSolidWasteInstance.scrutinyStatus=="In-Complete"){%>
	                            																					
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Returned being In-Complete</font>
	                            																					<%}else{%>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>"></font>
	                            																					<%}%>
	                            																					</td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>"><%if (pendingWith1){%>${(pendingWith1.role).roleName}<%}%></font></td>
	                        																					<%if(municipalSolidWasteInstance.clarification){ %>
                        																							<g:def var="appForWhich1" value="PWM"/><g:def var="applicationId" value="${municipalSolidWasteInstance.id}"/>
                        																							<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="submitClarification" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td> 
                 																						       	<%}%>       																						       	
                 																						       	
                                                                                                                 <%if(municipalSolidWasteInstance.showCause){ %>
                                                                                                                 <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/submitShowCause/${municipalSolidWasteInstance.id}', 'showCause', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'ShowCause.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td> 
                                                                                                                 <%} %>
	                        																					</tr>
	                    																						</g:each>																					</tbody>



  



  </tbody>
                    <table width="75%"  align="left">
 <tr><td>&nbsp;</td></tr>
 <tr><td width="8px"  bgcolor="brown"></td><td><font face="Verdana"
class="txt4">&nbsp;&nbsp;&nbsp;Application is Inprogress or Unattended
.</font></td></tr>
         <tr><td width="8px"  bgcolor="green"></td><td><font
face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application is Approved
or Rejected .</font></td></tr>

</table>
</td>
</tr>
         <table>
</table>
</div>
</div>

</div>
</div>
</td>
</tr>
</table>
<tr><td>&nbsp;</td></tr>
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
</table>
</td>
</tr>
<g:include controller="userMaster" action="showSpcbFooter"/>
</table>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>