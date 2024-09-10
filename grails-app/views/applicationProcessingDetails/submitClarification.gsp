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
<%if(appClarification){ %>
<table>
<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
String strDate = sdfDestination.format(appClarification.dateCreated );
%>
<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>
					<!-- 
  					<tr>				
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Raised By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appClarification.role}(${appClarification.officer})</div></td>
        			</tr>			
					  -->
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Clarification Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.clarificationNote}  </td>
                      </tr>
                      <g:if test="${appClarification.clarificationAttachedFile==true}">
					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Clarification Report:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><g:link action="viewClarificationReportIndustry" controller="applicationProcessingDetails" params="[appliLoc:app.id,docName:'attachedClarificationReport',docType:'doc']">View Report</g:link></td>
                      </tr>
                      </g:if>
                      <tr>
                      	<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Notes:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> <textarea name="indClarificationNote" cols="35" class="txt4"></textarea> </td>
                      </tr>
                       <tr>
                      	<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Upload Document</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> <input type="file" name="indClarificationFile"/><br>*Upload only non-editable files as Gif,pdf or Jpg files</td>
                      </tr>
                      
                      <!--added for additional payment-->
                      
                      <tr>
            
                       <tr align="center">
                      	<td width="150px" class="headngblue" colspan=2 bgcolor="#A8DAF3"><div class="style3">In case of Additional Fees <g:link action="addPayment" controller="indApplicationDetails" params="[id:app.id]">Click Here</g:link></div></td>
                      </tr>  
                      <tr>
                      
                     
                      <!--end here-->      
                      
                      
                      <tr>
                     
                      <td><input type="hidden" name="appId" value="<%=app.id%>"></input></td>
                      	<td width="150px" colspan="2" class="headngblue" bgcolor="#E8F6F9" align="center"> <input type="submit" name="Save" value="Save" class="actionbutton" ></td>
                      </tr>
                     
</table>
<%}%>
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
 