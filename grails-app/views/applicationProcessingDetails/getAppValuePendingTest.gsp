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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

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

<g:javascript library="prototype" />



</head>

<body >

              
       
        <div align="center" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
  			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				     
				   <% if(applicationTotalInstance.size() != 0){ %>
				   <tr><td  align="left"><font color="red"><%=applicationTotalInstance[0]%></font></td></tr>
				   <%}%>
				   <tr><td  align="center"><span class="headingblue"><font color="red">Pending Application details</font></span></td></tr>
                    <tr>
                      <td >
                        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
     			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                   	        <th class="headngblue" align="center">S.No</th>
							<th class="headngblue" align="center">Application No</th>
							<th class="headngblue" align="center">Application Date</th>
							<th class="headngblue" align="center">Industry Name</th>
							<th class="headngblue" align="center">Application Type</th> 
                   	        <th class="headngblue" align="center">Certificate for</th>
							<th class="headngblue" align="center">Officer Name</th>
                   	      	<th class="headngblue" align="center">Pending With Officer Since</th>
                 	    	<th class="headngblue" align="center">Pending With Board Since</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
               		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                    if(applicationTotalInstance.size()==0){%>
                    <tr><td colspan="8" height="25" align="center" class="txt4">List Is Empty</td></tr>
                    <%}%>
                    <g:each in="${applicationTotalInstance}" status="i" var="allSummaryReportInstance">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <%
                               int pendingWithOfficer=0;
                               int pendingWithBoard=0;
                              Date today = new Date();
                               def  appRecieveDate = allSummaryReportInstance.completionDate
                               def  appRecieveDate1 = allSummaryReportInstance.application.applicationDate
                               def diff = today.getTime() - appRecieveDate1.getTime();
                               def diff1 = today.getTime() - appRecieveDate.getTime();
                               pendingWithOfficer=diff1 / (1000*60*60*24)
                          //     diff = today.getTime() - appRecieveDate.getTime();
                               pendingWithBoard=diff / (1000*60*60*24)     
                               
                               
                               
                            %>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${(i+1)}</font></td>
                           <td align="center" height="25" class="txt4" ><u><b><g:link action="openApplicationDetails" controller="applicationProcessingDetails" id="${allSummaryReportInstance.applicationId}"><u>${fieldValue(bean:allSummaryReportInstance, field:'applicationId')}</u></g:link></b></u></td>
                            <td align="center" height="25"  class="txt4"><font face="Verdana" color="red"><%=sdfDestination.format(allSummaryReportInstance.completionDate)%></font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.application.applicationName}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.application.applicationType}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.application.certificateFor}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.pendingWith.userProfile.employeeFirstName +" "+ allSummaryReportInstance.pendingWith.userProfile.employeeLastName} ${allSummaryReportInstance.role.roleName}</font></td>
                        	<td align="center" height="25" class="txt4"><font face="Verdana" color="red"> ${pendingWithOfficer} Days</font></td>
                        	<td align="center" height="25" class="txt4"><font face="Verdana" color="red"> ${pendingWithBoard} Days</font></td>
                     </tr>
                    </g:each>
                
                    </tbody>
      </table>
     </td>
	</tr>
	</table>
</body>
</html>