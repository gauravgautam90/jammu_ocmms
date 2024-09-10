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


<table align="center" width="85%">

<tr align="center">

<td width="100%" align="center">

    <div >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Application Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="500"><a href="javascript:window.print()">print</a></td>
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
 					def industryId=0;
 					def d
 					
 					SimpleDateFormat f = new SimpleDateFormat('dd-MM-yyyy hh:mm');
 					if(appPending){
 					 d = f.format(applicationDate); 					
 					industryId = IndUser.find("from IndUser ind where ind.industryRegMaster=?",[appPending.indRegInstance])
 					}
 					
 				%>
 				
 				<tr>
                              <td colspan="2" class="headngblue">From  : <span class="txt4">&nbsp; M/s <span class="headngblue"><%if(appPending){%><%=appPending.indRegInstance%> <%}%><font color="grey">(<%=industryId%>)</font></span> </span></td>
                              
                             
</tr>
<tr>
                              <td colspan="2" class="headngblue"><span class="txt4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=""><%if(appPending){%><%=appPending.indRegInstance.indAddress%>, <%=appPending.indRegInstance.indCity%>, <%=appPending.indRegInstance.district.districtName%><%}%><font color="grey"></font></span> </span></td>
                              
                             
</tr>
<tr>
                              <td width="50%" class="headngblue">No  : <span class="txt4">&nbsp;<%if(appPending){%> <%=appPending.applicationId%><%}%></span></td>
                              
                              <td width="50%" class="headngblue" align="center" >Date : <span class="txt4">&nbsp; <%= d %></span></td>
                             
</tr>

<tr>
                              <td colspan="2" class="headngblue">Sub  : <span class="txt4">&nbsp; Application For - <b><%if(appPending){%><%=appPending.applicationFor%><%}%></span></td>
                              
                              
                             
</tr>
<tr>

    <td height="4" colspan="2" bgcolor="black"></td>

  </tr>
 <!--if condition added by shashank by shashank for test applicationprocessingdetails object is empy or not-->
  <g:if test="${applicationProcessingDetailsInstanceList}">
  
 					<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="applicationProcessingDetailsInstance">
 					
 					
 					<% 
 					
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );

def scrutinyAttach=WasteManagementFile.findAll("from WasteManagementFile wmf where wmf.applicationId=? and wmf.typeOfFile='scrutinyReport' order by wmf.id desc",[params.appliId.toLong()])

//def scrutinyAttach = ApplicationFileRecord.find("from ApplicationFileRecord where indApplication=? and typeOfFile='scrutinyReport'",[params.appliId])

%>
 					<tr><td colspan="2">
 					<br>
 					<table width="100%">
 					
 						<tr bgcolor="#F4F7FB" align="center">
                        <td width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                  
                       <td width="80%" ><div align="left"><span class="txt style6">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:if test="${applicationProcessingDetailsInstance.role.roleName=='Industry'}">
                       <tr bgcolor="#F4F7FB">
                       <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                      <td width="80%"><div align="left"><span class="txt style6">Clarification Reply&nbsp;&nbsp;
                       <g:def var="versionVal1" value="${varCheckCla}"/><g:def var="foooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFileClarification" controller="wasteManagementProcessingDetails" params="[appliLoc:foooVar,docName:'Clarification',docType:'pdf',verValue:versionVal1]">View Document</g:link><% varCheckCla=varCheckCla+1; %></g:if></g:if></span></div></td>
                      
                      </tr>
                      <g:if test="${applicationProcessingDetailsInstance.approvalStatus=='Approved' || applicationProcessingDetailsInstance.approvalStatus=='Refused'}">
                       <tr bgcolor="#F4F7FB" align="center">
                        <td width="20%" class="headngblue"><div align="left" class="style3">Approval/Refusal Status:</div></td>
                       <td width="80%" ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.approvalStatus}</span></div></td>
                      </tr>
                     
				</g:if>
				
 					<tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                    </tr>
                    
                    <tr>    <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.fileNote}  </span></td>
                      </tr> 
                      
                     
                   <%if((applicationProcessingDetailsInstance.scrutinyStatus=="In-Complete") || (applicationProcessingDetailsInstance.scrutinyStatus=="Complete")){%>
                       <tr bgcolor="#F4F7FB" align="center">
                        <td width="20%" class="headngblue"><div align="left" class="style3">Scrutiny Status:</div></td>
                       <td width="80%" ><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.scrutinyStatus}</span>&nbsp;&nbsp;<%if(scrutinyAttach) {%> <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='In-Complete'}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appFor" value="${appPending.applicationFor}"/><g:link action="viewFile3" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docType:'doc',appFor1:appFor]">View Scrutiny Report</g:link> </g:if><%}%></div></td>
                      </tr>
                      <tr bgcolor="" align="center">
                        <td width="20%" class="headngblue"><div align="left" class="style3">Scrutiny Description</div></td>
                       <td width="80%" ><div align="left"><span class="txt style6"><g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='Complete'}">${appPending.recieptNo}</g:if>
                       <g:if test="${applicationProcessingDetailsInstance.scrutinyStatus=='In-Complete'}">${applicationProcessingDetailsInstance.scrutinyDescription}</g:if></span></div></td>
                      </tr>
                     
				<%}%>    
                      					 
                      
  <g:if test="${applicationProcessingDetailsInstance.attachedFile==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="left" class="style3">Attached Letter:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="versionVal11" value="${varCheckFile}"/><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appFor" value="${appPending.applicationFor}"/><g:link action="viewOtherAttachedFile" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc',verValue:versionVal11,,appFor1:appFor]">View Letter</g:link><% varCheckFile=varCheckFile+1; %></td>
                      </tr>
                     
        </g:if> 
       				              
		<g:if test="${applicationProcessingDetailsInstance.clarification==true}">
                       <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">Clarification&nbsp;&nbsp;<b>(Send To Industry)</b><g:if test="${applicationProcessingDetailsInstance.clarificationAttachedFile==true}"><g:def var="versionVal" value="${varCheckCl}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appFor" value="${appPending.applicationFor}"/><g:link action="viewFile1" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,appFor1:appFor,docName:'Application attached Clarification Report',docType:'doc',verValue:versionVal]">View Report</g:link> <% varCheckCl=varCheckCl+1; %></g:if></span></div></td>
                   
                      </tr>
                 
                       <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Reply Within:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">${applicationProcessingDetailsInstance.clarificationDays} &nbsp</span></div></td>
                      </tr>
                      <tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                    </tr>
                      <tr >
                        <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.clarificationNote} </span></td>
                      </tr>
                     
		</g:if>


		<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
		

                      <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">Inspection&nbsp;&nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="versionVal" value="${varCheckIns}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:link action="viewFile1" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,docName:'Application attached Inspection Report',docType:'doc',verValue:versionVal]">View Report</g:link> <% varCheckIns=varCheckIns+1; %></g:if></span></div></td>
                      </tr>
                      <tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                     </tr>
                      <tr >
                        <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.inspectionNote} </span></td>
                      </tr>
                      
                      
		</g:if>
		
		
		<g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
		
		
<!--code for inspection view link added by shashank start-->	

              <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
   <td width="80%"><div align="left"><span class="txt style6">Inspection Closed&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<g:def var="versionVal" value="${varCheckCl}"/> <g:def var="fooVar" value="${applicationProcessingDetailsInstance.applicationId}"/><g:def var="appFor" value="${appPending.applicationFor}"/><g:link action="viewFile1" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,appFor1:appFor,docName:'Application Inspection Report File',docType:'doc',verValue:versionVal]">View Inspection Report</g:link> <% varCheckIns=varCheckIns+1; %></span></div></td>
                     </tr>
                      <tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                    </tr>
                      <tr >
                        <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.inspectionCloseNote} </span></td>
                      </tr>
                      
  <!--end code by shashank-->	                    
		</g:if>
		
		
		<g:if test="${applicationProcessingDetailsInstance.approve==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">Close After Approval</span></div></td>
                      </tr>
                      <tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                    </tr>
                      <tr >
                        <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.approveNote} </span></td>
                      </tr>
                     
		</g:if>
		
		
		
				
		
		
		
		
		
		
		<g:if test="${applicationProcessingDetailsInstance.reject==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">Close After Refusal</span></div></td>
                      </tr>
                      <tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                    </tr>
                     
                      <tr >
                        <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.rejectNote} </span></td>
                      </tr>
                      
		</g:if>
		
		<g:if test="${applicationProcessingDetailsInstance.returned==true}">
					   <tr bgcolor="#F4F7FB">
                        <td  width="20%" class="headngblue"><div align="left" class="style3">Activity:</div></td>
                       <td width="80%"><div align="left"><span class="txt style6">Application Return</span></div></td>
                      </tr>
                      <tr >
                        <td  colspan="2" class="headngblue" ><div align="left" class="style3">Description</div></td>
                    </tr>
                     
                      <tr >
                        <td colspan="2" align="justify"><span class="txt style6"> ${applicationProcessingDetailsInstance.returnNote} </span></td>
                      </tr>
                      
		</g:if>
		
		<% def officer = UserMaster.find("from UserMaster user where user.id=?",[applicationProcessingDetailsInstance.officer]) 
		def officerName
		if(officer){
		officerName =  officer.userProfile.employeeFirstName +" "+ officer.userProfile.employeeLastName
		}
		else
		{
		officerName = applicationProcessingDetailsInstance.officer
		}
		%> 
                      <tr align="center" >
                              <td colspan="2" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Note By:
                        <span class="txt4 style3">${officerName}(${applicationProcessingDetailsInstance.role})</span></div></td>
        </tr>
 					
 					<tr bgcolor="#F4F7FB">
                        <td colspan="2" class="headngblue" ><div align="right" class="style3">Date Time:
                        <span class="txt4 style3">
                         <%=strDate%>
                        </span></div></td>
                      </tr>
 
       		
        
        <tr >
                         <td colspan="2" align="left" valign="middle" class="headngblue"><div align="left" class="style3">Forwarded To:
                        <span class="txt4 style6"><%if( (i+1)<applicationProcessingDetailsInstanceList.size() && applicationProcessingDetailsInstanceList.get(i+1)){out.print((applicationProcessingDetailsInstanceList.get(i+1)).role);}else{out.print(currentPending);} %></span></div></td>
        </tr>	
       

 					<tr >
 					<td height="0" bgcolor="black" colspan="2"></td>
 					</tr>
 					
 					</table></td></tr>
						
					</g:each>
					
					</g:if>
					  
  
  </table>
	

  

</table>
</body>
</html>
 