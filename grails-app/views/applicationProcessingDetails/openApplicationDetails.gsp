<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Note History</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

 
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<g:javascript library="prototype" />


 </head>
  <body>

  
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Application Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432"><a href="javascript:window.print()">print</a></td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
	<% 
	    int varCheck=0; 
	    int varCheckIns = 0;
		int varCheckCla=0;
		int varCheckFile=0;
		int varCheckCl=0;
		SimpleDateFormat f = new SimpleDateFormat('dd-MM-yyyy hh:mm');
		def d = f.format(applicationDate);
		def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?",[appPending.application.indUser])
	%>
	
	<tr>
              <td width="50%"  class="headngblue">From  : <span class="txt4">&nbsp; M/s <span class="headngblue"><%=appPending.application.indUser%> <font color="grey">(<%=industryId%>)</font></span> </span></td>
              
              <td width="50%" class="headngblue" align="center" >Category : <span class="txt4">&nbsp; <%=appPending.application.indUser.category.name%></span></td>
</tr>
<tr>
              <td width="50%" class="headngblue">No  : <span class="txt4">&nbsp; <%=appPending.application%></span></td>
              
              <td width="50%" class="headngblue" align="center" >Date : <span class="txt4">&nbsp; <%= d %></span></td>
             
</tr>

<tr>
              <td colspan="2" class="headngblue">Sub  : <span class="txt4">&nbsp; Application For - <b><%=appPending.application.applicationType%> /  <%=appPending.application.applicationFor%> /  <%=appPending.application.certificateFor%></span></td>
              
              
             
</tr>
<tr>

<td height="4" colspan="2" bgcolor="black"></td>

</tr>		
 		<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="applicationProcessingDetailsInstance">
 					<tr><td><table>
 					<% 
 					
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );
def scrutinyAttach = ApplicationFileRecord.find("from ApplicationFileRecord where indApplication=? and typeOfFile='scrutinyReport'",[appPending.application])
%>
 					
 					<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left"><span class="txt style6">
                         <%=strDate%>
                        </span></td>
                      </tr>
 
       <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Note By:</div></td>
                        <td ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})</span></div></td>
        </tr>		
        
        <tr >
                         <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Forwarded To:</div></td>
                        <td ><div align="left"><span class="txt style6"><%if( (i+1)<applicationProcessingDetailsInstanceList.size() && applicationProcessingDetailsInstanceList.get(i+1)){out.print((applicationProcessingDetailsInstanceList.get(i+1)).role);}else{out.print(currentPending);} %></span></div></td>
        </tr>	
       
				
	<tr bgcolor="#F4F7FB" align="center">
                        <td width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%" ><div align="left"><span class="txt style6">Forward &nbsp;&nbsp;</span></div></td></tr>
                         <g:if test="${applicationProcessingDetailsInstance.role.roleName=='Industry'}"> 
                          <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">Clarification Reply&nbsp;&nbsp;
                       <g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}">                     
                       <g:def var="versionVal1" value="${varCheckCla}"/>
                       <g:def var="foooVar" value="${applicationProcessingDetailsInstance.application.id}"/>
                       <g:link action="viewFileClarification" controller="applicationProcessingDetails" params="[appliLoc:foooVar,docName:'Clarification',docType:'pdf',verValue:versionVal1]">View Document</g:link>
                       <% if(feeChequeAdditional){%>
                       <g:link action="viewChequeAttachedAdditional" controller="indApplicationDetails" params="[appliLoc:foooVar]"><br>View Scaned Copy of Additional Drafts/Cheques</g:link>
                      <% } %>
                       </td></tr>
                       <% varCheckCla=varCheckCla+1; %></g:if></g:if></span>
                      
        <g:if test="${applicationProcessingDetailsInstance.attachedFile==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="left" class="style3">Attached Letter:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div>
                       <g:def var="versionVal11" value="${varCheckFile}"/>
                       <g:def var="fooVar1" value="${applicationProcessingDetailsInstance.application.id}"/>
                       <g:link action="viewOtherAttachedFile" controller="applicationProcessingDetails" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',verValue:versionVal11]">View Letter</g:link><% varCheckFile=varCheckFile+1; %></td>
                      </tr>
                     
        </g:if> 
        
        <%if((applicationProcessingDetailsInstance.scrutinyStatus=="In-Complete") || (applicationProcessingDetailsInstance.scrutinyStatus=="Complete")){%>
       <%if(applicationProcessingDetailsInstance.scrutinyStatus!="Complete"){%>
        <tr >
        <td width="150px" class="headngblue" ><div align="right" class="style3">Scrutiny Query:</div></td>
        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.scrutinyDescription}  </span></td>
      </tr>
      <%}
       def scrutinyAttach12121 = ApplicationFileRecord.find("from ApplicationFileRecord where indApplication=? and typeOfFile='CompleteScrutinyReport'",[applicationProcessingDetailsInstance.application])
       if(scrutinyAttach12121){
      %>
      <tr bgcolor="#F4F7FB">
      <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Scrutiny Report:</div></td>
      <td bgcolor="#E8F6F9" class="headngblue"><g:link action="viewScrutinyReportIndustry" controller="applicationProcessingDetails" params="[appliLoc:applicationProcessingDetailsInstance.application,docName:'CompleteScrutinyReport',docType:'doc']">View Report</g:link></td>
      </tr>
      <%}%>
        <tr bgcolor="#F4F7FB" align="center">
         <td width="150px"class="headngblue"><div align="right" class="style3">Scrutiny Status:</div></td>
        <td align="left" ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.scrutinyStatus}</span>&nbsp;&nbsp;
        <%if(scrutinyAttach) {%> <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='In-Complete'}">
        <g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/>
        <g:link action="viewFile3" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docType:'doc']">View Scrutiny Report</g:link> 
        </g:if><%}%></div></td>
       </tr>
       <tr bgcolor="" align="center">
       <%if(applicationProcessingDetailsInstance.scrutinyStatus!="Complete"){%>
         <td width="150px" class="headngblue"><div align="right" class="style3">Scrutiny Description</div></td>
         <%}else{%>
         <td width="150px" class="headngblue"><div align="right" class="style3">Remarks</div></td>
         <%}%>
        <td align="left" ><div align="left"><span class="txt style6">
        <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='Complete'}">${applicationProcessingDetailsInstance.scrutinyDescription}</g:if>
        <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='In-Complete'}">${applicationProcessingDetailsInstance.scrutinyDescription}</g:if></span></div></td>
       </tr>
      
	<%}%>
				
				
	
	
		<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Clarification &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="versionVal" value="${varCheckCl}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewFile1" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'Attached_Clarification_Report',docType:'doc',verValue:versionVal]">View Report</g:link> <% varCheckCl=varCheckCl+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.clarificationNote} </span></td>
                      </tr>
                     
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Inspection&nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="versionVal" value="${varCheckIns}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewFile2" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'Attached_Inspection_Report',docType:'doc',verValue:versionVal]">View Report</g:link> <% varCheckIns=varCheckIns+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionNote}  </span></td>
                      </tr>
                      
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Inspection Closed &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"></span><span class="txt style6">&nbsp;<g:def var="versionVal" value="${varCheck}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.application.id}"/><g:link action="viewFile" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'Inspection_Report',docType:'doc',verValue:versionVal]">View Report</g:link><% varCheck=varCheck+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionCloseNote}  </span></td>
                      </tr>
                      
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.approve==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Close after Approval</span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.approveNote}    </span></td>
                      </tr>
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.reject==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Close after Rejection</span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">  ${applicationProcessingDetailsInstance.rejectNote}  </span></td>
                      </tr>
		</g:if>
		 <g:if test="${applicationProcessingDetailsInstance.approvalStatus=='Approved' || applicationProcessingDetailsInstance.approvalStatus=='Refused'}">
         <tr bgcolor="#F4F7FB">
          <td width="150px" class="headngblue"><div align="right" class="style3">Approval/Refusal Status:</div></td>
         <td width="80%" ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.approvalStatus}</span></div></td>
        </tr>
       
	</g:if>
		<tr >
          <td width="150px" class="headngblue" ><div align="right" class="style3">Description</div></td>
          <td align="left"><span class="txt style6"><font size='3'> ${applicationProcessingDetailsInstance.fileNote} </font> </span></td>
      </tr>
      
		<!--code by vikas rathore-->
		<g:if test="${applicationProcessingDetailsInstance.returned==true}">
		   <tr bgcolor="#F4F7FB">
         <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
        <td ><div align="left"><span class="txt style6">Return</span></div></td>
       </tr>
       <tr >
         <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
         <td align="left"><span class="txt style6">  ${applicationProcessingDetailsInstance.returnNote}  </span></td>
       </tr>
</g:if>


	<g:if test="${applicationProcessingDetailsInstance.resubmitStatus==true}"> 
 <tr><td colspan="2">
<br>
<table width="60%">
<tr bgcolor="#F4F7FB" align="center">
<td width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
<td  ><div align="left"><span class="txt style6">Forward &nbsp;&nbsp;</div></td></tr>
<tr bgcolor="#F4F7FB">
<td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
<td ><div align="left"><span class="txt style6">Application Re-Submitted</span></div></td>
</tr>
<tr bgcolor="#F4F7FB">
<td  width="150px" class="headngblue"><div align="right" class="style3">Query Reply:</div></td>
<td ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.fileNote}</span></div></td>
</tr>
<tr align="center" >
<td width="150px" class="headngblue"><div align="right" class="style3">Note By:</div></td>
<td  ><div align="left"><span class="txt style6">${indUserInst}(Industry)</span></div></td>
</tr>

<%
String strDateUpdate = sdfDestination.format(applicationProcessingDetailsInstance.lastUpdated );
%>


<tr bgcolor="#F4F7FB">
<td width="150px" class="headngblue"><div align="right" class="style3">Date Time:</div></td>
<td  ><div align="left"><span class="txt style6">
<%=strDateUpdate%>
</span></div></td>
</tr>
<tr >
<td width="150px" class="headngblue"><div align="right" class="style3">Forwarded To:</div></td>
<td  ><div align="left"><span class="txt style6"><%if( (i+1)<applicationProcessingDetailsInstanceList.size() && applicationProcessingDetailsInstanceList.get(i+1)){out.print((applicationProcessingDetailsInstanceList.get(i+1)).role);}else{out.print(currentPending);} %></span></div></td>
</tr>	

<tr >
<td height="1"  colspan="2"></td>
</tr>

<tr >
<td height="0"  colspan="2"></td>
</tr>
</table></td></tr>
</g:if>

<!--code ended by vikas rathore-->
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					</table></td></tr>
						
					</g:each>
					  
  </table>
	
  <tr>

    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>

  </tr>

  

</table>

</body>
</html>
 