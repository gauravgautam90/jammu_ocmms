<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!----------------------added by saroj---for audit issue--resolved------------------>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="X-Frame-Options" content="deny">

<style id="antiClickjack">body{display:none !important;}</style>

<script type="text/javascript">
if (self === top) {
    var antiClickjack = document.getElementById("antiClickjack");
    antiClickjack.parentNode.removeChild(antiClickjack);
} else {
    top.location = self.location;
}
</script>
<!-------------------------end------------------------------>
<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=SingleWindowExc.xls");
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
<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

</head>


<body >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >

<tr>
 <td colspan="11" align="center" >
 <span class="headngblue">
 <span style="color:red;font-size:15px;">Search Waste Application Report</span>
 </span>
 </td>
</tr>
  <tr>
 <td colspan="11" align="center" >
 <span class="headngblue">
 <span style="color:red;font-size:15px;">From Date ${startDateHWM} to To Date ${endDateHWM}</span>
 </span>
 </td>
</tr>               
</table>



<div>


<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt" border="1">
 				<tr height="20" bgcolor="#A8DAF3">

                     
 						 <th align="center"  class="headngblue">S.No</th>
 						 <th align="center"  class="headngblue">Application No</th>
 						 
 						 <th align="center"  class="headngblue">Application For</th>
 						 <th align="center"  class="headngblue">Category</th> 
 						 <th align="center"  class="headngblue">Industry Name</th>
 						 <th align="center"  class="headngblue">Contact no</th>
 						 <th align="center"  class="headngblue">Contact Person</th>
 						 <th align="center"  class="headngblue">Person Designation</th>
 						 <th align="center"  class="headngblue">Email</th>
                   	     <th align="center"  class="headngblue">Address</th>
                   	     <th align="center"  class="headngblue">District</th> 
                   	     <th align="center"  class="headngblue">Application Date</th> 
                   	     <th align="center"  class="headngblue">Status</th>
                   	     <th align="center"  class="headngblue">Approval/Refusal Date</th>
                   	   <th align="center"  class="headngblue">Certificate</th>
                   	       <th align="center"  class="headngblue">category</th>
                   	   	<th align="center"  class="headngblue">Quantity</th> 
                   	       
                   	        
                   	        
                 </tr>
<%Float totalQuan=0.0 %>
  <g:each in="${allSummaryReportWMSList}" status="i" var="allSummaryReportInstance">
                 <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                 <% def indReg=IndustryRegMaster.get(allSummaryReportInstance.indRegMasterId.toLong())
                 	def wasteGenDetails=HazardousWasteGenDetails.findAll("from HazardousWasteGenDetails s where s.application.id=?",[allSummaryReportInstance.applicationId.toLong()] ) 
                 def listOfWasteCat=new ArrayList()
                 def listOfWasteQuan=new ArrayList()
                   def toBePrintCat
                   def toBePrintQuan
                 if(wasteGenDetails){
                 for(int i2=0;i2<wasteGenDetails.size();i2++){
                 def quan=wasteGenDetails[i2].quantity.toFloat()
                 totalQuan=totalQuan+quan
                 listOfWasteCat.add(wasteGenDetails[i2].categoryName.name)
                 listOfWasteQuan.add(wasteGenDetails[i2].quantity)
                 }
                 }
                 if(listOfWasteCat){
                  toBePrintCat=listOfWasteCat.toString();
                 }
                 if(listOfWasteQuan){
                 toBePrintQuan=listOfWasteQuan.toString();
                 }
                  %>
                 
	                  <td align="center" class="txt4"> <%=i+1%> </td>
	                  <td align="center" class="txt4" > <%=allSummaryReportInstance.applicationId%> </td>
	                  
	                  <td align="center" class="txt4"> <%=allSummaryReportInstance.certificateFor%> </td>
	                  <td align="center" class="txt4"> <%=allSummaryReportInstance.indCategoryName%> </td>
	                  <td align="center" class="txt4"> <%=allSummaryReportInstance.applicationName%> </td>
	                  <td align="center" class="txt4"> <%=indReg.occMobile%></td>
	                  <td align="center" class="txt4"> <%=indReg.occName%></td>
	                  <td align="center" class="txt4"> <%=indReg.occDesignation%></td>
	                  <td align="center" class="txt4"> <%=indReg.occEmail%></td>
	                  <td align="center" class="txt4"> <%=indReg.indAddress%> </td>
				      <td align="center" class="txt4"> <%=allSummaryReportInstance.districtName%> </td>
				  
				  <td align="center" class="txt4"> <g:formatDate format="dd-MM-yyyy" date="${allSummaryReportInstance.applicationRecieptDate}"/></td>
	        <%
          if(allSummaryReportInstance.applicationStatus=='approved'){%>
           <td align="center" class="txt4">Granted </td>
           <td align="center" class="txt4"><g:formatDate format="dd-MM-yyyy" date="${allSummaryReportInstance.pendingSince}"/></td>
           
          
       <% } 
         
          else if(allSummaryReportInstance.applicationStatus=='rejected'){
           %>
           <td align="center" class="txt4">Rejected </td>
           <td align="center" class="txt4"><g:formatDate format="dd-MM-yyyy" date="${allSummaryReportInstance.pendingSince}"/></td>
           <td align="center" class="txt4"></td>
           
          
      <%} 
	        
         else if(allSummaryReportInstance.applicationStatus=='returned'){
              %>
              <td align="center" class="txt4">Returned </td>
              <td align="center" class="txt4"></td>
              <td align="center" class="txt4"></td>
	        
	        
           <%} 
	        
          else {%>
         
          <td align="center" class="txt4">Pending </td>
          <td align="center" class="txt4"></td>
          <td align="center" class="txt4"></td>
          <%} 
              %>
             <% if(allSummaryReportInstance.applicationStatus=='approved'){%>
               <td> <g:link controller="applicationProcessingDetails" action="downLoadingConsentHWMCertificate"  id="${allSummaryReportInstance.applicationId}" ><span class="innerlink">&nbsp;View Authorization&nbsp</span></g:link> </td>
              <%}else{ %>
   
  <%} %>
  <td align="center" class="txt4"> <%=toBePrintCat%></td>
  <td align="center" class="txt4"> <%=toBePrintQuan%></td>
  </tr>
  
  
                 </g:each>
     
     <tr>
     
     <td align="left" >
			<font color="red" size="2"><b>Total Application: <%=allSummaryReportWMSList.size()%></b></font>
			</td>
     
			 <td align="center" class="txt4"> </td>
			  <td align="center" class="txt4"> </td>
			   <td align="center" class="txt4"> </td>
			    <td align="center" class="txt4"> </td>
			     <td align="center" class="txt4"> </td>
			      <td align="center" class="txt4"> </td>
			       <td align="center" class="txt4"> </td>
			        <td align="center" class="txt4"> </td>
			         <td align="center" class="txt4"> </td>
			          <td align="center" class="txt4"> </td>
			           <td align="center" class="txt4"> </td>
			            <td align="center" class="txt4"></td>
			             <td align="center" class="txt4"> </td>
			             <td align="center" class="txt4"> </td>
			             <td align="center" class="txt4"> </td>
			              <td align="right" >
			<font color="red" size="2"><b>Total Quantity: <%=totalQuan%></b></font>
			</td>
			
			
			
			</tr>
			
</table>

</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>