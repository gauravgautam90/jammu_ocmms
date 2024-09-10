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
<g:if test="${session.startDate1!=null}">       
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr height="20" bgcolor="#2B547E">
<td align="left" >
<b><font color="yellow" size="2">List Of Indsutries From </font><font color="skyblue" size="2"><%=new SimpleDateFormat("dd MMM yyyy").format(session.startDate1)%></font><font color="yellow" size="2"> To </font><font color="skyblue" size="2"><%=new SimpleDateFormat("dd MMM yyyy").format(session.endDate1)%></font>&nbsp;&nbsp;&nbsp;<font color="yellow" size="2"> Region : </font><font color="skyblue" size="2"><%=session.groupName%></font></b>
</td>
</tr>
</table>
</g:if>   
<div style="overflow: auto;height: 400px; width: 1000px;">

<table width=100% align="center" cellpadding="0" border="2" style="border:3px solid green;" cellspacing="0"  class="tab-txt">
                 <tr height="20" bgcolor="#A8DAF3">
                   	   <td align="center" style="border-bottom:3px solid green;" width="3%" class="headngblue" >S.No.</th>
                   	  <td align="center" style="border-bottom:3px solid green;" width="35%" class="headngblue" >Industry Name & Address</th>
                   	   <td align="center" style="border-bottom:3px solid green;" width="10%" class="headngblue" >Latest Status of BOTH Consent(Approved/Rejected)</th>
                   	   <td align="center" style="border-bottom:3px solid green;" width="20%" class="headngblue" >Consent Period</th>
                  </tr>      
                  
                 
                 <%
                     if(!certificatesListAll || certificatesListAll.size()==0)
                     {%>
                     <tr class='odd'>
                          <td colspan="6" height="25" class="txt4"><b>No Records... </td>
                     </tr>
                     <%}
                 %>
				
			
                    	
                    <g:each in="${certificatesListAll}" status="i" var="recordCertificateInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <%
                        def statusList = new ArrayList()
                        def stdate = new ArrayList()
                        def eddate = new ArrayList()
                        
						def AllSummaryReportInstance=AllSummaryReport.findByApplicationId((recordCertificateInstance.applicationId.id).toString())
						def industryRegMasterInstance=recordCertificateInstance.applicationId.indUser
						String dateWithoutTimeS = new SimpleDateFormat("dd-MM-yyyy").format(recordCertificateInstance.startDate);
			            String dateWithoutTimeE = new SimpleDateFormat("dd-MM-yyyy").format(recordCertificateInstance.endDate);
		                String status
						
						if(AllSummaryReportInstance.applicationStatus.equals("approved")){
						status = "Granted"
						
						}else if(AllSummaryReportInstance.applicationStatus.equals("rejected")){
						status = "Rejected"
						
						}else{
						
						status = AllSummaryReportInstance.applicationStatus
						
						}
						
						
					     
                          %>
                          <td align="center" height="25" class="txt4">${(i+1)}</td>
                          <td align="center" height="25" class="txt4"><b>${industryRegMasterInstance.indName} </b><br>${industryRegMasterInstance.indAddress} ${industryRegMasterInstance.indPin}</td>
                          <td align="center" height="25" class="txt4"><b>${status}</b></td>
                          <td align="center" height="25" class="txt4">From :${dateWithoutTimeS} To: ${dateWithoutTimeE} </td>
                   	</tr>
                    </g:each>
					
                </table>
		
		</div>
	

</body>
</html>