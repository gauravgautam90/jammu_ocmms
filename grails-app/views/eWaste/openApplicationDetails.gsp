<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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

  
 <table align="center" width="85%">

<tr align="center">

<td width="100%" align="center">

    <div >
 
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                             <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
 												<g:if test="${flash.message}">
																				<div class="message">${flash.message}</div>
																			</g:if>

</span></div></td></tr></table>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
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
 						SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
 						def industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?",[appPending.indRegInstance])
 					System.out.println("industryId=============>>>>>>>>>>>>>>>>>>"+industryId)
 				%>
 				
 							<tr>
                              <td colspan="2" class="headngblue">From  : <span class="txt4">&nbsp; M/s <span class="headngblue"><%=appPending.indRegInstance.indName%> <font color="grey">(<%=industryId%>)</font></span> </span></td>
                            </tr>
							<tr>
                              <td width="50%" class="headngblue">No  : <span class="txt4">&nbsp; <%=appPending.applicationId%></span></td>
                              
                              <td width="50%" class="headngblue" align="center" >Date : <span class="txt4">&nbsp; <%=sdfDestination.format(appPending.dateCreated)%></span></td> <%-- By Gajendra Kushwah 20/05/2015 --%>
                            </tr>


							<tr>
                              <td colspan="2" class="headngblue">Sub  : <span class="txt4">&nbsp; Application For -  <%=appPending.applicationFor%> </span></td>
                               
							</tr>
						<tr>
								 <td height="4" colspan="2" bgcolor="black"></td>
						</tr>
			
 				
 		<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="applicationProcessingDetailsInstance">
 			<tr>
 				<td colspan="2">
 					<br>
 				<table width="100%">
 					<% 
 						 String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );
	                %>
 					
 					
				  
        			
					<tr bgcolor="#F4F7FB">
                            <td  width="150px" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                            <td ><div align="left"><span class="txt style6">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}"><g:def var="versionVal1" value="${varCheckCla}"/><g:def var="foooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFileClarification" controller="eWaste" params="[appliLoc:foooVar,docName:'Clarification',docType:'pdf',verValue:versionVal1,appForWhich:appForWhich]">View Document</g:link><% varCheckCla=varCheckCla+1; %></g:if></g:if></span></div></td>
                    </tr>
                      
      			 <g:if test="${applicationProcessingDetailsInstance.attachedFile==true}">
                       <tr bgcolor="#F4F7FB">
                       		 <td  width="150px" class="headngblue"><div align="left" class="style3">Attached Letter:</div></td>
                       		<td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="versionVal11" value="${varCheckFile}"/><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewOtherAttachedFile" controller="eWaste" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',verValue:versionVal11,appForWhich:appForWhich]">View Letter</g:link><% varCheckFile=varCheckFile+1; %></td>
                      </tr>
                     
        		</g:if> 
        
                      <tr >
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.fileNote}  </span></td>
                      </tr>
                     
				<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        	<td  width="150px" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       		<td ><div align="left"><span class="txt style6">Clarification &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="versionVal" value="${varCheckCl}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile3" controller="eWaste" params="[appliLoc:fooVar,docName:'attachedClarificationReport',docType:'doc',verValue:versionVal,appForWhich:appForWhich]">View Report</g:link> <% varCheckCl=varCheckCl+1; %></g:if></span></div></td>
                      </tr>
                      
                      <tr >
                       	 <td width="150px" class="headngblue" ><div align="left" class="style3">Description:</div></td>
                       	 <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.clarificationNote} </span></td>
                      </tr>
                      
                      
                      <tr >
                       	 <td width="150px" class="headngblue" ><div align="left" class="style3">clarification  days:</div></td>
                       	 <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.clarificationDays} </span></td>
                      </tr>
                      
                     
				</g:if>
				
				<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                       	 <td  width="150px" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       	<td ><div align="left"><span class="txt style6">Inspection&nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="versionVal" value="${varCheckIns}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile2" controller="eWaste" params="[appliLoc:fooVar,docName:'attachedInspectionReport',docType:'doc',verValue:versionVal,appForWhich:appForWhich]">View Report</g:link> <% varCheckIns=varCheckIns+1; %></g:if></span></div></td>
                      </tr>
                      
                      <tr >
                       	 <td width="150px" class="headngblue" ><div align="left" class="style3">Description:</div></td>
                       	 <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionNote}  </span></td>
                      </tr>
                      
                      <tr >
                       	 <td width="150px" class="headngblue" ><div align="left" class="style3">Reply within Days</div></td>
                       	 <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionDays}  </span></td>
                      </tr>
                     
				</g:if>
				
				<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                       	 <td  width="150px" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       		<td ><div align="left"><span class="txt style6">Inspection Closed</span><span class="txt style6">&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"><g:def var="versionVal" value="${varCheck}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile" controller="eWaste" params="[appliLoc:fooVar,docName:'inspectionReport',docType:'doc',verValue:versionVal,appForWhich:appForWhich]">View Report</g:link> <% varCheck=varCheck+1; %></g:if></span></div></td>
                      </tr>
                      
                      <tr >
                       	 <td width="150px" class="headngblue" ><div align="left" class="style3">Description:</div></td>
                       	 <td align="left"><span class="txt style6">   ${applicationProcessingDetailsInstance.inspectionCloseNote}  </span></td>
                      </tr>
                     
				</g:if>
				
				<g:if test="${applicationProcessingDetailsInstance.approve==true}">
					   <tr bgcolor="#F4F7FB">
                       	 <td  width="150px" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       		<td ><div align="left"><span class="txt style6">Approve</span></div></td>
                      </tr>
                      
                      <tr >
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6"> ${applicationProcessingDetailsInstance.approveNote}    </span></td>
                     </tr>
                     
                      
				 </g:if>
				 
			  <g:if test="${applicationProcessingDetailsInstance.reject==true}">
					   <tr bgcolor="#F4F7FB">
                       	 <td  width="150px" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       	<td ><div align="left"><span class="txt style6">Reject</span></div></td>
                      </tr>
                      
                      <tr >
                        <td width="150px" class="headngblue" ><div align="left" class="style3">Description:</div></td>
                        <td align="left"><span class="txt style6">  ${applicationProcessingDetailsInstance.rejectNote}  </span></td>
                      </tr>
				</g:if>
 				
 					
 					<g:def var="appForWhich" value="${appForWhich}"/>
 					
				  		<tr align="center" >
                              <td colspan="2" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Note By:
                              <span class="txt4 style3"><g:if test="${applicationProcessingDetailsInstance.officer=='SPCB'}">Industry</g:if><g:else> ${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})  </g:else></span></div></td>
        				</tr>		
       				
       			      				
       				<tr bgcolor="#F4F7FB">
                        <td colspan="2" class="headngblue" ><div align="right" class="style3">Date Time:
                        <span class="txt4 style3"><%=strDate%>
	                      </span></div></td>
                     </tr>
       				
       				      				
       				 <tr >
                             <td width="150px" align="right" valign="middle" class="headngblue"><div align="left" class="style3">Forwarded To:</div></td>
                             <td ><div align="left"><span class="txt style6"><%if( (i+1)<applicationProcessingDetailsInstanceList.size() && applicationProcessingDetailsInstanceList.get(i+1)){out.print((applicationProcessingDetailsInstanceList.get(i+1)).role);}else{out.print(currentPending);} %></span></div></td>
        			</tr>	
 				<tr>
						<td height="2" colspan="2" bgcolor="black"></td>
				   </tr>
 					
 			</table></td></tr>
						
		</g:each>
					  
  </table>
	
  
</table>

</body>
</html>
 