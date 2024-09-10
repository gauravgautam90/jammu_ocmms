<%@ page import="java.text.SimpleDateFormat"%>
<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
</head>
<body>
<g:form action="submittedClarification" enctype="multipart/form-data" name="myform" method="post" >
   <%	int versionVal1=0;
                    def var = 0;  	
 				int varCheckInsClarification = 0;
 				int varCheckInsClarifications = 0;
 				    int varCheck=0; 
 				    int varCheckIns = 0;
 					int varCheckCla=0;
 					int varCheckFile=0;
 					int varCheckCl=0;
 					int varCheckCl1=0;
                      def versionValue1=1 
     def applicationFileInstanceNotZero=ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=?  and afr.version!=0 and afr.name='ScnCertiFicate.pdf' order by afr.id desc",[app])
      if(applicationFileInstanceNotZero){
     }
     else{
     versionValue1=0 
     }
                      
                      %>
<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="appClarification">

<%


if(appClarification){ %>
<table width="60%" align= "center">
<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
String strDate = sdfDestination.format(appClarification.dateCreated );
if(appClarification.clarification == true){

%>

 <tr  >
                              <td width="150px" align="center" valign="middle" colspan =2 class="headngblue" bgcolor="#A8DAF3"><div align="center" class="style3">Clarification Raised Details :</div></td>
        </tr>
        <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>

  <tr  >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Raised By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appClarification.role}(${appClarification.officer})</div></td>
        </tr>			
					 <tr >
						<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Notice Type:</div></td>
						<td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.noticeType} </td>
						</tr>
					 
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.clarificationNote}  </td>
                      </tr>
        
        <%}else if((appClarification.clarificationNote)|| (appClarification.clarificationReplyAttachedFile) ){%>
        	
        	
        	
        	<tr  >
                              <td width="150px" colspan = 2 align="centre"  class="headngblue" bgcolor="#A8DAF3"><div align="center" class="style3">Clarification Reply Details :</div></td>
        </tr>
          <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>
        	   <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.clarificationNote}  </td>
                      </tr>
					 
        <%}%>

 <%if(appClarification.clarification == true){%>
                      <g:if test="${appClarification.clarificationAttachedFile==true}">
					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">${appClarification.noticeType} Report:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue">
                     <g:def var="fooVar" value="${appClarification.application.id}"/>
                   <g:def var="varCheckInstance" value="${varCheckInsClarifications}"/>
              <g:link action="viewFile1" controller="inspectionManagement" params="[appliLoc:app.id,docName:'Attach_Regular_Clarification_Report',docType:'doc', varCheckInsClarifications:varCheckInsClarifications]">View Report</g:link>
          
                     
                     <%varCheckInsClarifications =varCheckInsClarifications +1%>
                      </tr>
                      </g:if>
                
                       <%if(appClarification.noticeType == 'Show Cause'){%>

 <tr bgcolor="#F4F7FB">
 <td class="headngblue"align="right"  bgcolor="#A8DAF3">SCN Certificate</td>
                        <td  class="headngblue" bgcolor="#E8F6F9" align="left" >
                    <%
                    def appId = appClarification.application
                   
		 def viewCertScnAir
                 def viewCertScnWater
                 def viewCertScnHwm
                 def viewCertScnNoc
		 def appFileRecord1 = ApplicationFileRecord.findAll("from ApplicationFileRecord where indApplication = ? and name = 'ScnCertiFicate.pdf' and version !=0 and appFor ='old'",[appClarification.application],[sort:'id',order:'asc'])
				 def appFileRecord = ApplicationFileRecord.findAll("from ApplicationFileRecord where indApplication = ? and name = 'ScnCertiFicate.pdf' and version !=0 and appFor!='old'",[appClarification.application],[sort:'id',order:'asc'])
	
		
		 if(applicationFileInstanceNotZero){
		 
		  viewCertScnAir=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnAir' and version=? order by id desc",[appId,versionValue1.toLong()])
		
		
		 viewCertScnWater=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnWater' and version=? order by id desc",[appId,versionValue1.toLong()])
		
		 viewCertScnHwm=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnHwm' and version=? order by id desc",[appId,versionValue1.toLong()])
		
		 viewCertScnNoc=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnNoc' and version=? order by id desc",[appId,versionValue1.toLong()])
	
		
		
                   }else{
                   
         viewCertScnAir=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnAir' and version=0 order by id desc",[appId])
		
		
		 viewCertScnWater=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnWater' and version=0 order by id desc",[appId])
		
		 viewCertScnHwm=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnHwm' and version=0 order by id desc",[appId])
	
		 viewCertScnNoc=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='CertificateForScnNoc' and version=0 order by id desc",[appId])
		
                   }
                  
		if(appClarification.application.applicationFor == "air" || appClarification.application.applicationFor == "air/HWM"){  
		                    if(appFileRecord){
                              	for(int u=0;u<appFileRecord.size();u++)
                                 		{   
                                 		if( ((appFileRecord[u].appFor).toString())==(appClarification.toString())){
                                 	if(appFileRecord[u].typeOfFile=="CertificateForScnAir" ){%>
                                 	
                                 		<g:link action="downLoadingCertificateForScnAir"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN Air For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                
                                 else if(appFileRecord[u].typeOfFile=="CertificateForScnWater"){%>
                                 		<g:link action="downLoadingCertificateForScnWater"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN Water For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 else if(appFileRecord[u].typeOfFile=="CertificateForScnWaterHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnWaterHWM"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN (Water/HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord[u].typeOfFile=="CertificateForScnHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnHWM"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:aappFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN (HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord[u].typeOfFile=="CertificateForScnAirHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnAirHWM"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN (Air/HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord[u].typeOfFile=="CertificateForScnBoth"){%>
                                 		<g:link action="downLoadingCertificateForScnBoth"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN (both) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord[u].typeOfFile=="CertificateForScnBothHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnBothHWM"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN (both/HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	 else{%>
                                 		<g:link action="downLoadingCertificateForScnNoc"  id="${appId}" params="[versionValue1:versionValue1,appFileInst:appFileRecord[u].id]"><span class="innerlink">&nbsp; <u>View SCN (NOC) For Refusal</u>&nbsp;</span></g:link>
                                 		<%}}}}
                                 	if(appFileRecord1[var]){
                        
                                 	if(appFileRecord1[var].typeOfFile=="CertificateForScnAir"){%>
                                 	<g:link action="downLoadingCertificateForScnAir"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN Air For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	
                                 else if(appFileRecord1[var].typeOfFile=="CertificateForScnWater"){%>
                                 
                                 		<g:link action="downLoadingCertificateForScnWater"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp;<u>View SCN Water For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	
                                 else if(appFileRecord1[var].typeOfFile=="CertificateForScnWaterHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnWaterHWM"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN (Water/HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord1[var].typeOfFile=="CertificateForScnHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnHWM"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN (HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord1[var].typeOfFile=="CertificateForScnAirHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnAirHWM"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN (Air/HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord1[var].typeOfFile=="CertificateForScnBoth"){%>
                                 		<g:link action="downLoadingCertificateForScnBoth"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN (both) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	  else if(appFileRecord1[var].typeOfFile=="CertificateForScnBothHWM"){%>
                                 		<g:link action="downLoadingCertificateForScnBothHWM"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN (both/HWM) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}
                                 	 else{%>
                                 		<g:link action="downLoadingCertificateForScnNoc"  id="${appId}" params="[versionValue1:versionValue1]"><span class="innerlink">&nbsp; <u>View SCN (NOC) For Refusal</u>&nbsp;</span></g:link>
                                 	<%}	
                          
							var=var+1;
							
                                 	}%>
		
		
                          	<%}
						if(applicationFileInstanceNotZero){
						if(viewCertScnAir||viewCertScnWater||viewCertScnHwm||viewCertScnNoc)
                   {
                   versionValue1=versionValue1+1;
                   }}}
						%>	
		            
		</td>
                    
                      </tr>
    
             <%}else if((appClarification.clarificationNote)|| (appClarification.clarificationReplyAttachedFile)){%>
                     
                   
                <g:if test="${appClarification.clarificationReplyAttachedFile==true}">
                       <tr>
                      
                     <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Uploaded Document</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue">
                       <g:def var="versionVal" value="${varCheckCl}"/>
                   <g:def var="fooVar" value="${appClarification.application.id}"/>
                   <g:def var="varCheckInstance" value="${varCheckInsClarification}"/>
                   <g:link action="viewSubmittedFileClarification" controller="inspectionManagement" params="[appliLoc:fooVar,docName:'Attached_Clarification_Report',docType:'doc',verValue:versionVal , varCheckInsClarification:varCheckInsClarification]">View Clarification Reply Attachment</g:link> 
                  
                       </td> 
                               
                     
                    <% varCheckInsClarification = varCheckInsClarification+1;
                  
                     %>
                       </g:if>
                           <tr>
                      
                     <td  width="150px" colspan = 2 class="headngblue" bgcolor="grey"><div align="right" class="style3"></div></td>
                         </tr>
                  
                           <%}%>
                    
                  
                               
</table>
    
<%}%>
  </g:each>
</g:form>
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("general");
 frmvalidator.EnableFocusOnError(false); 
   // frmvalidator.EnableMsgsTogether();  

 function Checkfiles()
 {
    var frm = document.forms["myform"];  
    var fupp = document.getElementsByName('indClarificationFile');
    var fup = fupp[0];
    var fileName = fup.value;
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
    
    if(ext == "pdf" || fileName =="" )
  	   return true;
    else
	{
    	sfm_show_error_msg('Please upload non editable files as Gif,pdf or Jpg files',fupp);
		 	
	     return false;
	}
  }
	frmvalidator.setAddnlValidationFunction("Checkfiles"); 
</script>
</body>
 