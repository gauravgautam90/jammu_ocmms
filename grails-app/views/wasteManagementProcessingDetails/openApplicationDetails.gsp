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
                             <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
 												<g:if test="${flash.message}">
																				<div class="message">${flash.message}</div>
																			</g:if>

</span></div></td></tr></table>
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
 				
 				<%		int varCheck=0; 
 						int varCheckIns = 0;
 						int varCheckCla=0;
 						int varCheckFile=0;
 						int varCheckCl=0;
 						
 						def application
 						def applicationNo=appId
 						def indUser
 						if(appForWhich=='BMW'){
 						application=BioMedicalWaste.get(applicationNo.toLong())
 						indUser=IndUser.findByIndustryRegMaster(application.industryRegMasterObj)
 						}else if(appForWhich=='HWM'){
 						application=HazardeousWasteAuthApp.get(applicationNo.toLong())
 						indUser=IndUser.findByIndustryRegMaster(application.industryRegMasterObj)
 						}else if(appForWhich=='PWM'){
 						application=PlasticWaste.get(applicationNo.toLong())
 						indUser=IndUser.findByIndustryRegMaster(application.industryRegMasterObj)
 						}
 						System.out.println("indUser--------"+indUser)
 						
 				%>
 						<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="left" class="style3">From:</div></td>
                        <td align="left"><span class="txt style6">
                         <%=application.industryRegMasterObj.indName%>(<%=indUser.id.toString()%>)
                       </span> </td>
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Category:</div></td>
                        <td align="left"><span class="txt style6">
                        <%=application.industryRegMasterObj.category.name%></span> 
                        </td>
                        
                      	</tr>
                      	
                      	<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Application No:</div></td>
                        <td align="left"><span class="txt style6">
                          <%=application.id%></span>
                        </td>
                      		</tr>
                      		<tr bgcolor="#F4F7FB">
                      		<%if(appForWhich=='BMW'){ %>
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Sub:</div></td>
                        <td align="left">
                        <span class="txt style6"> Application for-<%=application.authorisationAppliedFor%></span> 
                        </td>
                        <% }else if(appForWhich=='HWM'){ %>
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Sub:</div></td>
                        <td align="left">
                        <span class="txt style6"> Application for-<%=application.is_Renew%></span> 
                        </td>
                        <% }%>
                      		</tr>
 				</table>
 				
 					<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="applicationProcessingDetailsInstance">
 					<tr><td><table>
 					<% 
 					
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );
%>
 					
 					<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" colspan="1"><div align="right" class="style3">Date Time:</div></td>
                        <td align="left"><span class="txt style6">
                         <%=strDate%>
                        </span></td>
                      </tr>
  <g:def var="appForWhich1" value="${appForWhich}"/>
  <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Note By:</div></td>
                        <td ><div align="left"><span class="txt style6"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}">Industry</g:if><g:else> ${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})  </g:else></div></td>
        </tr>		
        <tr >
                         <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Forwarded To:</div></td>
                        <td ><div align="left"><span class="txt style6"><%if( (i+1)<applicationProcessingDetailsInstanceList.size() && applicationProcessingDetailsInstanceList.get(i+1)){out.print((applicationProcessingDetailsInstanceList.get(i+1)).role);}else{out.print(currentPending);} %></span></div></td>
        </tr>	
					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}"><g:def var="versionVal1" value="${varCheckCla}"/><g:def var="foooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFileClarification" controller="wasteManagementProcessingDetails" params="[appliLoc:foooVar,docName:'Clarification',docType:'pdf',verValue:versionVal1,appForWhich:appForWhich1]">View Document</g:link><% varCheckCla=varCheckCla+1; %></g:if></g:if></span></div></td>
                      </tr>
                      
                      <tr >
                      <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                      <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.fileNote}  </span></td>
                    </tr> 
                      
                      <%if((applicationProcessingDetailsInstance.scrutinyStatus=="In-Complete") || (applicationProcessingDetailsInstance.scrutinyStatus=="Complete")){%>
                      <tr bgcolor="#F4F7FB" align="center">
                       <td width="20%" class="headngblue"><div align="left" class="style3">Scrutiny Status:</div></td>
                      <td width="80%" ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.scrutinyStatus}</span>&nbsp;&nbsp;<%if(scrutinyAttach) {%> <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='In-Complete'}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appFor" value="${appPending.applicationFor}"/><g:link action="viewFile3" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docType:'doc',appFor1:appFor]">View Scrutiny Report</g:link> </g:if><%}%></div></td>
                     </tr>
                     <tr bgcolor="" align="center">
                     <%if(applicationProcessingDetailsInstance.scrutinyStatus!="Complete"){%>
                       <td width="20%" class="headngblue"><div align="left" class="style3">Scrutiny Description</div></td>
                       <%}else{%>
                       <td width="20%" class="headngblue"><div align="left" class="style3">Remarks</div></td>
                       <%}%>
                      <td width="80%" ><div align="left"><span class="txt style6">   <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='Complete'}">${appPending?.recieptNo}${applicationProcessingDetailsInstance.scrutinyDescription}</g:if> 
                      <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='In-Complete'}">${applicationProcessingDetailsInstance.scrutinyDescription}</g:if></span></div></td>
                     </tr>
                    
				<%}%> 
                      
       <g:if test="${applicationProcessingDetailsInstance.attachedFile==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Attached Letter:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="versionVal11" value="${varCheckFile}"/><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewOtherAttachedFile" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',verValue:versionVal11,appForWhich:appForWhich1]">View Letter</g:link><% varCheckFile=varCheckFile+1; %></td>
                      </tr>
                     
        </g:if> 
        
                    
                     
		<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Clarification &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="versionVal" value="${varCheckCl}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile1" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'Attached_Clarification_Report',docType:'doc',verValue:versionVal,appForWhich:appForWhich1]">View Report</g:link> <% varCheckCl=varCheckCl+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.clarificationNote} </span></td>
                      </tr>
                     
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Inspection&nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="versionVal" value="${varCheckIns}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile2" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'Attached_Inspection_Report',docType:'doc',verValue:versionVal,appForWhich:appForWhich1]">View Report</g:link> <% varCheckIns=varCheckIns+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionNote}  </span></td>
                      </tr>
                     
		</g:if>
		<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Inspection Closed</span><span class="txt style6">&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"><g:def var="versionVal" value="${varCheck}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'Inspection_Report',docType:'doc',verValue:versionVal,appForWhich:appForWhich1]">View Report</g:link> <% varCheck=varCheck+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionCloseNote}  </span></td>
                      </tr>
                     
		</g:if>
		<!--  -----------------------------------------------------------------Return Application  ------------------------------------------------------- -->                  
		
		<g:if test="${applicationProcessingDetailsInstance.returned==true}">
        <tr bgcolor="#F4F7FB">
          <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
          <td ><div align="left"><span class="txt style6">Return Application</span></div></td>
        </tr>
        <tr >
          <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
          <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.returnNote}  </span></td>
        </tr>
       
</g:if>
		<!--  --------------------------------------------------------------------End  ------------------------------------------------------------------------------   -->      
<!--  -----------------------------------------------------------------Resubmit Application  -------------------------------------------------------                 -->
		
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

<%if(applicationProcessingDetailsInstance.scrutinyStatus=="In-Complete"){%>
<tr bgcolor="#F4F7FB">
<td  width="150px" class="headngblue"><div align="left" class="style3">Scrutiny Reply :</div></td>
<td ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.fileNote}</span></div></td>
</tr>
<%}else{%>
<tr bgcolor="#F4F7FB">
<td  width="150px" class="headngblue"><div align="left" class="style3">Returned Reply :</div></td>
<td ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.returnNote}</span></div></td>
</tr>
<%}%>
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
<!--	  --------------------------------------------------------------------End  ------------------------------------------------------------------------------   -->        
		
					<g:if test="${applicationProcessingDetailsInstance.approve==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Approve</span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.approveNote}    </span></td>
                      </tr>
					  </g:if>
					  <g:if test="${applicationProcessingDetailsInstance.reject==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"><span class="txt style6">Reject</span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">  ${applicationProcessingDetailsInstance.rejectNote}  </span></td>
                      </tr>
					  </g:if>
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
 