<%@ page import="java.text.SimpleDateFormat"%>
<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script>
window.onunload = refreshParent;
  function refreshParent() {
  window.opener.location.reload(true);
                           }
</script>
</head>
<body>
<g:form action="submittedRegularClarification" enctype="multipart/form-data" name="myform" method="post" >

<g:if test="${flash.message}">
          <div>${flash.message}</div>
           	 </g:if>
<%
	int varCheckInsClarification = 0;

if(appClarification){ %>
<table>
<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
String strDate = sdfDestination.format(appClarification.dateCreated );

def appId = appClarification.application
                 
 
   def viewClarificationAttachment=ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='attachRegularClarificationReport'",[appId])
		


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
						<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Notice Type:</div></td>
						<td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.noticeType} </td>
						</tr>
					  <input type = "hidden" name="noticeType" value="${appClarification.noticeType}">
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.clarificationNote}  </td>
                      </tr>
                      
					 <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">${appClarification.noticeType} Report:</div></td>
                      	<%   if(viewClarificationAttachment){%>
						<td align="left" bgcolor="#E8F6F9" class="txt4"><g:link action="downLoadingClarificationAttachedFile"  id="${appId}" ><span class="innerlink">&nbsp; <u>View Attached File</u>&nbsp;</span></g:link></td>
	
	                     <%}%>
                       </td>
                   </tr>                	


                    
                      <tr>
                      	<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Notes:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> <textarea name="indClarificationNote" cols="35" class="txt4"></textarea> </td>
                      </tr>
                       <tr>
                      	<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Upload Document</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> <input type="file" name="indRegularClarificationFile"/><br>*Upload only non-editable files as Gif,pdf or Jpg files</td>
                      </tr>
                      <tr>
                    
                      <!--added by Gajendra for additional payment-->
                  
                      <tr>
            
                       <tr align="center">
                    	<td width="150px" class="headngblue" colspan=2 bgcolor="#A8DAF3"><div class="style3">In case of Additional Fees <g:link action="addPayment" controller="indApplicationDetails" params="[id:app.id,chk:'regIns']">Click Here</g:link></div></td>
                     </tr>  
                      <tr>
                      
                     
                      <!--end by Gajendra-->
                     
                     
                
                      <td><input type="hidden" name="appId" value="<%=app.id%>"></input></td>
                      	<td width="150px" colspan="2" class="headngblue" bgcolor="#E8F6F9" align="center"> <input type="submit" name="Save" value="Save" class="actionbutton" ></td>
                      </tr>
                     
</table>
<%}%>
</g:form>
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
 frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
frmvalidator.addValidation("indClarificationNote","req","Please enter value for Note");
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
 