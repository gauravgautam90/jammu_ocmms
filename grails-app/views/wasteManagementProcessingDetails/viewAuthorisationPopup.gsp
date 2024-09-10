 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Add Fee Details</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
<g:javascript library="prototype" />
<script language="javascript" type="text/javascript" src="${createLinkTo(dir:'js',file:'datetimepicker.js')}">


</script>

<script language="javascript" type="text/javascript">

function select4()
{

var selectmenu1=document.getElementById("feeFor")
selectmenu1.onchange=function()
 {    
 
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Application Form")
   	 {
   	 
   	 document.getElementById('ddAmount').value = '500';
	 }
else{
 
    document.getElementById('ddAmount').value = '';
   		 }
   }
}
</script>
</head>
  <body>
  
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Previous Authorisation Details</td>
					</tr>
 					<tr><td><table 	class="tblbdr">
 		
 	<!--	<input name="appDetId" type="hidden" value="<%=appDetId%>" />
        <input name="appId1" type="hidden" value="<%=indAppDetId%>" />  -->
 					 
 					
 					</table></td></tr>
 					
 				<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"><b>List of previus issued Authorisation.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="20%" align="center"  class="txt" >Date of Application for BMW</td>
                        <td width="20%" align="center"  class="txt" >BMWA Type </td>
							  <td width="150px" align="center" class="txt">Authorisation No</td>
							  <td width="150px" align="center" class="txt">Issued date</td>
							  <td width="150px" align="center" class="txt">Valid date</td>
							   
							  <td width="150px" align="center" class="txt">Previous Authorisation</td>
                      </tr>
 <g:each in="${previousAuthList}" status="i" var="previousAuthListInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthListInst.BMWApplication_Date}
                        </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthListInst.BMWAType}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthListInst.AuthorisationNo}
                        </span></td>
                        <td bgcolor="#E8F6F9">
                        <g:if test="${previousAuthListInst.Issued_date!='31/12/2999'}">
                        <span class="txt style6">${previousAuthListInst.Issued_date}
                        </span>
                        </g:if>
                        <g:else>
                               <span class="txt style6"></span>
                          </g:else>
                        </td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthListInst.Valid_date}
                        </span></td>
                 		<td bgcolor="#E8F6F9"><span class="txt style6">
                 		<g:if test="${previousAuthListInst.wasteManagementFileId}">
                 		<g:def var="fooVar" value="${previousAuthListInst.wasteManagementFileId}"/><g:link action="viewAuthorisationAttached" controller="bioMedicalWaste" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
                 		</g:if>
                        </span></td>
                   
     </tr>		
      </g:each>		
 				
 					
 			</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>
  
 
  </body>
  </html>