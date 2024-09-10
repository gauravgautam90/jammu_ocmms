
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>


<head>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}





</g:javascript>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body onload="removeSpacesfromTextarea()">
<g:form name="waterSourceModeUses" method="post" action="saveDeeRecommendationsRegular" enctype="multipart/form-data">
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
			
				<% 
				def inspReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Fresh Inspection Report'",[appId])
				%>
				
 					<tr bgcolor="#3090C7">
					<td align="center" valign="middle"  class="headngblue"><font color="white">Recommendations Details</font></td>
					</tr>
					
					<tr class="headngblue" bgcolor="#A8DAF3" >
										<!-- Div area for errors-->
										<td align="center" valign="top">
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if> 
										</span>
										</td>
									</tr>
					
 					<tr><td>
 					
 					<table width="100%" border="0" >
 					
 					<tr>							  
					<%if(inspReport){%>
					<td  width="65%" align="left" bgcolor="" class="headngblue"></td>
					<td width="45%" align="center" valign="middle" bgcolor="white" class="headngblue"><g:def var="fooVar" value="${appId.id}"/><g:link action="printFreshInspectionReport" controller="applicationProcessingDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink">Print Fresh Inspection Report</span></g:link></td>
					<%}%>
					
							</tr>
						   
				<tr>							  
				 <td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Address of the unit:</td>
				 <td  width="65%" align="left" bgcolor="#E8F6F9" class="headngblue" colSpan=3> ${appId?.indUser?.indName},${appId?.indUser?.indAddress},${appId?.indUser?.indPin}</td>
				</tr> 
						
				<tr >
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"><%=params?.type%> recommendations</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
				<input type="hidden" name="appId" value="<%=appId%>">
				<%if(params?.type=="DEE"){%>
				<textarea rows="5" cols="45" name="deeRecommendations" class="txt4" id = "deeRecommendations" >${consentInspectionReportInst?.deeRecommendations}</textarea>
				<%}else{%>
				<textarea rows="5" cols="45" name="deeRecommendations" class="txt4" id = "deeRecommendations" ></textarea>
				<%}%>
				
				</td>
				</tr>
				
												       
										       
		
			<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0" class="tblbdr" >
 			
 					<tr><td>
 					
 					<table class="tblbdr" width="100%">
						 <tr >
						 
		<td colspan="5" align="center">
		<input type="hidden" name="type" id="type" value="${params.type}">
		<input type="submit" name="Add" value="Submit" class="actionbutton"></td>
		</tr> 
					</table>   </td></tr>
 					</table> 
				
			
						
						
				
							
											       
 
					
					
					
					
					


						</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
   frmvalidator.addValidation("deeRecommendations","req","Please enter DEE Recommendations");
 </script>  
						
				

</body>