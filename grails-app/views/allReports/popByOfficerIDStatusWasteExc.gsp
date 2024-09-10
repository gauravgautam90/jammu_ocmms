<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<% response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition", "inline;filename=popByOfficerIDStatusWasteExc.xls");
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

<body>
<table width=100%  align="center" border="0"  cellpadding="0" cellspacing="0"  class="tab-txt" >
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

<td  align="center" colspan="13">
<span class="headngblue">
      <span style="color:red;font-size:13px;"><br>Status on the basis of Officer ID and Date</span><br> 
      <% if(dd1 && dd1.length()>3 && officerID) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font> <br>Officer ID:- <font color="red"> <%=officerID%></font><br>Application Type :- <font color="red"> <%=appFor%></font><%}%>
</span>
</td>
</tr> 

</table>
<table width="100%"   align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">


<tr width="200%" bgcolor="#A8DAF3"  >
				<th align="center" style="width:3%;border-bottom:3px solid green;" class="headngblue" >S.No</th>
           	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application ID</th>
           	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application Name</th> 
        	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Industry Type</th>
        	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Location</th>
           	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Category</th> 
           	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application Date</th> 
           	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Date of Receipt as per Officer ID</th>     
           	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application For</th>
        	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Status</th> 
        	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Pending With/Forwarded To</th> 
        	      
        	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >District</th>
           	     <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Note History</th> 
           	      
          </tr>
          <%System.out.println("appSummary=> "+appSummary)%>
          <g:each in="${appSummary}" status="i" var="appSummaryInstance">
          <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
          
          <%
          
          SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
         // System.out.println("appSummaryInstance=> "+appSummaryInstance)
          //System.out.println("appSummaryInstance3=> "+appSummaryInstance.getClass())
         // System.out.println("appSummaryInstance4=> "+appSummaryInstance.getClass().getName())
          String strDate = sdfDestination.format(appSummaryInstance.dateCreated );
          def instancePrcessing=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails abc where abc.applicationId=?",[appSummaryInstance.id.toString()])
          String strDatebyOffiecrID = sdfDestination.format(instancePrcessing.dateCreated );
          String applicationFor = instancePrcessing.applicationFor
          String consentFor = instancePrcessing.applicationFor
          def instance=WasteManagementPendingDetails.find("from WasteManagementPendingDetails abc where abc.applicationId=?",[appSummaryInstance.id.toString()])
          
          def status=""
          def officer=""
          def  docName=""
          def industryRegMaster=null;
          
          if(instance){
        		  status=instance.applicationStatus
        		  officer=instance.pendingWith
        		  docName=instance.applicationFor
        		  System.out.println(" docName==> "+docName)
          }
         
              
            		  if(docName=="MSW"){
            			  industryRegMaster=appSummaryInstance?.indRegMasterObj
            		  }else{
            			  industryRegMaster=appSummaryInstance?.industryRegMasterObj
            		  }
        
            		 
          %>
      
          <td align="center" ><%=i+1%></td>
          <td align="center" height="25" class="txt4"  >
          
          <%if(docName=="BMW"){%>
          <a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/showNewFormat1?id=<%=appSummaryInstance.id%>&docName=<%=docName%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">${appSummaryInstance.id}</a>
         <%}%>
         
         <%if(docName=="HWM"){%>
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/showNewFormat?id=<%=appSummaryInstance.id%>&docName=<%=docName%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">${appSummaryInstance.id}</a>
         <%}%>
         
         <%if(docName=="PWM"){%>
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/showforSpcb?id=<%=appSummaryInstance.id%>&docName=<%=docName%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">${appSummaryInstance.id}</a>
         <%}%>
         
         <%if(docName=="MSW"){%>
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/spcbShowForm?appliId=<%=appSummaryInstance.id%>&docName=<%=docName%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">${appSummaryInstance.id}</a>
         <%}%>
         
           <%--  <g:link  controller="bioMedicalWaste"  action="showNewFormat1"  id="${appSummaryInstance.id}">${appSummaryInstance.id}</g:link>--%>
          </td>
          <td align="center" ><%=industryRegMaster.indName%></td>
          <td align="center" ><%=applicationFor%></td>
          <td align="center" ><%=industryRegMaster?.indAddress%></td>
          <td align="center" ><%=industryRegMaster?.category.name%></td>
          <td align="center" ><%=strDate%></td>
          <td align="center" ><%=strDatebyOffiecrID%></td>
          <td align="center" ><%=consentFor%></td>
          <td align="center" ><%=status%></td>
          <td align="center" ><%=officer%></td>
          
          <td align="center" ><%=industryRegMaster?.district.districtName%></td>
    <%if(appSummaryInstance.id){%>
          <td align="center" >
          <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/openApplicationDetails?appliId=<%=appSummaryInstance.id%>&docName=<%=docName%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">Note History</a>
		 </td>
  	<%} %>
  	
  	       </tr>
  	       </g:each>
      </tr>
        </table>
</body>