<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=popConsentExpireExc.xls");
%>
<%@ page import="java.text.*" %>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



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
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >

<tr>
 <td colspan="9" align="center" >
 <span class="headngblue">
 <span style="color:red;font-size:13px;">Status of Consent Expiry</span> 
 </span>
 </td>
</tr>                  
</table>



      	<div style="overflow: auto;height: 600px; width: 1000px;">
         

<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
                  
                  
		<tr width="100%" bgcolor="#FFFFCC"  >
   	       <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='5%'>S.No</th>
   	       <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='18%'>Industry Name</th>
   	       <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Category</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Classification</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Consent Type</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Application Id</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Issue Date</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Valid Date</th>
       	   <th align="center" style="border-bottom:3px solid green;" class="headngblue" width='7%'>Expiry(Days)</th>
        </tr>
        
        <%
        if(!allSummaryReportList)
        {
      	 %>
      	    <tr><td colspan="11" >No Records Found...</td></tr>
      	 <%
        }
        %>
        
        <g:each in="${allSummaryReportList}" status="i" var="allSummaryReportInstance">
          
           <tr>
              <%
                   def indRegMaster=IndustryRegMaster.get((allSummaryReportInstance.indRegMasterId).toLong())
                   def recordCertificateInstance=RecordCertificate.find("from RecordCertificate rc where rc.applicationId.id=? ",[(allSummaryReportInstance.applicationId).toLong()]);
                   String dateWithoutTimeS = new SimpleDateFormat("dd-MM-yyyy").format(recordCertificateInstance.dateCreated);
			       String dateWithoutTimeE = new SimpleDateFormat("dd-MM-yyyy").format(recordCertificateInstance.endDate);
		                                   
              %>
                  <td align="center" height="25">  <font size="2%"><%=(i+1)%></font></td>
                  <td align="center" height="25">  <font size="2%">${allSummaryReportInstance.applicationName}</font></td>
                  <td align="center" height="25">  <font size="2%">${indRegMaster.category.name}</font></td>
                  <td align="center" height="25">  <font size="2%">${indRegMaster.industryScale}</font></td>
                  <td align="center" height="25">  <font size="2%">${allSummaryReportInstance.applicationType}</font></td>
                  <td align="center" height="25">  <font size="2%">${allSummaryReportInstance.applicationId}</font></td>
                  <td align="center" height="25">  <font size="2%">${dateWithoutTimeS}</font></td>
                  <td align="center" height="25">  <font size="2%">${dateWithoutTimeE}</font></td>
                  <td align="center" height="25">  <font size="2%">${(expiryDaysList.get(i)).toInteger()}</font></td>
           </tr>
        </g:each>	  
              </tr>
             
                
                
                </table>
		

		
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
          </div>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>