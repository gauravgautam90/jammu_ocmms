 
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
  <g:form  method="post" action="saveAuthorisationDetails" name="myForm" enctype="multipart/form-data">
 
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Previous Authorisation Details</td>
					</tr>
 					<tr><td><table 	class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="150px" align="center"  class="txt" >Date of Application for BMWA</td>
                        <td width="150px" align="center"  class="txt" > BMWA Type  </td>
							<td width="150px" align="center" class="txt">Authorisation No</td>
							  <td width="150px" align="center" class="txt">Issued date                </td>
							  <td width="150px" align="center" class="txt">Valid date</td>
							  
                      </tr>



  <tr align="center" >
                     <% System.out.println("22222222222")%>
  					<td bgcolor="#E8F6F9"><span class="txt style6">
  					<!-- #####  Added by sharvan start-->
					<!--<input type="text" name="BMWApplication_Date" placeholder="dd/mm/yyyy"> --> 
					<calendar:resources lang="en" theme="aqua"/><calendar:datePicker id="bmwAppDate" name="bmwAppDate"  years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>                                                
					 </td>
  					
  					 <td bgcolor="#E8F6F9"><span class="txt style6">
  
	         <g:select name="BMWAType" id="HWAType"  from="${['Fresh','Renewal','Amendment']}" ></g:select>
  						<br ><span class="sidetxt"></span></span></td>
  					
  					<td bgcolor="#E8F6F9"><span class="txt style6"> <input name="AuthorisationNo" type="text" maxlength="20" size="15" class="txt4"  />
  						<br ><span class="sidetxt"></span></span></td>
                    
                    <td bgcolor="#E8F6F9"><span class="txt style6">
					<!--	<input type="text" name="Issued_date" placeholder="dd/mm/yyyy"> -->
						 <calendar:datePicker name="Issued_date" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>                                                
					
						</td>
						
				<td bgcolor="#E8F6F9"><span class="txt style6">
						
			<!--<input type="text" name="Valid_date" placeholder="dd/mm/yyyy">-->
			 <calendar:datePicker name="Valid_date" years="1900,2500" dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>                                                
					
			</td>	    
						
						
                      
        </tr>		
        <input name="appDetId" type="hidden" value="<%=app%>" />
        <input name="appId1" type="hidden" value="<%=app%>" />
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					<tr bgcolor="#A8DAF3">
 					<td class="txt style6" colspan="6" align="center">Please Attach Previous Authorisation<input type="file" name="bmwAuthAttach" id="authattach"></td>
 					
 					</tr>
 					</table></td></tr>
 					<tr>
 					<td align="center"  ><input type="submit" name="Add" value="Add" class="actionbutton"></td>
 					</tr>
 					
 					</g:form>
 					
 					
 					
 					
 					<tr align="center">
  <td><div style="width: 500px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}.</div>
										</g:if>
										<g:hasErrors bean="${unitMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${unitMasterInstance}" as="list" />
										</div>
										</g:hasErrors></span></div></td></tr>
 					
 				<!--	<g:form  method="post" action="saveChequeAttach" name="myForm1" enctype="multipart/form-data">
 					<input name="appId1" type="hidden" value="<%=app%>" />
 					 <% System.out.println("4444444444 "+app)%>
 					<tr bgcolor="#A8DAF3">
 					<td class="txt style6" colspan="6">Please Attach Scan Copy Of all Drafts <input type="file" name="draftattach" id="draftattach"> <input type="submit" name="Attach" value="Attach" class="actionbutton"></td>
 					
 					</tr>
 					</g:form>-->
 					
 					
 					<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					<tr>
					<td align="left"> 
					<span class="txt" style="color: navy"><b>List of previus issued Authorisation.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					 <% System.out.println("3333333333")%>
 					<td width="20%" align="center"  class="txt" >Date of Application for BMW</td>
                        <td width="20%" align="center"  class="txt" >BMWA Type </td>
							  <td width="150px" align="center" class="txt">Authorisation No</td>
							  <td width="150px" align="center" class="txt">Issued date</td>
							  <td width="150px" align="center" class="txt">Valid date</td>
							   
							  <td width="150px" align="center" class="txt">Authorisation copy</td>
                      </tr>
 <g:each in="${previousAuthorisationInstance}" status="i" var="previousAuthDetailsInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.BMWApplication_Date}
                        </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.BMWAType}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.AuthorisationNo} 
                        </span></td>
                        <td bgcolor="#E8F6F9">
                        	<g:if test="${previousAuthDetailsInst.Issued_date!='31/12/2999'}">
                                <span class="txt style6">${previousAuthDetailsInst.Issued_date}</span>
                          	</g:if>
                          	<g:else>
                               <span class="txt style6"></span>
                          	</g:else></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${previousAuthDetailsInst.Valid_date}
                        </span></td>
                 		<td bgcolor="#E8F6F9"><span class="txt style6">
                 		<g:if test="${previousAuthDetailsInst.wasteManagementFileId!=''}">
                 		<g:def var="fooVar" value="${previousAuthDetailsInst.wasteManagementFileId}"/><g:link action="viewAuthorisationAttached" controller="bioMedicalWaste" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
                 		</g:if>
                 		<g:if test="${session.userMaster && previousAuthDetailsInst.wasteManagementFileId=='' && previousAuthDetailsInst.AuthorisationNo!='' && previousAuthDetailsInst.Valid_date!='' }">
                 		<g:def var="id" value="${previousAuthDetailsInst.id}"/>
                 		<g:link action="addAuthorisationAttachment" controller="bioMedicalWaste" params="[id:id]"><span class="innerlink"><u>Add Scaned Copy Of previous Certificates</u></span></g:link>
                 		</g:if>
                        </span></td>
                   
                        
                         
        </tr>		
      </g:each>		
 				<!--	<tr bgcolor="#F4F7FB" >
 					<td class="txt style6" align="right" colspan="3">Scaned Copy of Drafts     &nbsp;: </td>
 					<td class="txt style6" align="left" colspan="3"><%if(feeCheque){%>	<g:def var="fooVar" value="${appDetId}"/><g:link action="viewChequeAttached" controller="indApplicationDetails" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
<%}%></td>
 					</tr>-->
 					
 	<!--	<td class="txt style6" align="right" colspan="3">Scaned Copy of Drafts     &nbsp;: </td>
 					<td class="txt style6" align="left" colspan="3"><%if(docList8){%>	<g:def var="fooVar" value="${appDetId}"/><g:link action="viewAuthorisationAttached" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
    <%}%></td>
 					</tr>		 -->
 					
 					
 					
 					
 						
 					
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>
  
  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("authattach","req","Please Attach a file");
  frmvalidator.addValidation("ddNo","numeric","DD number should be numeric");
//  frmvalidator.addValidation("ddNo","minlength=6","DD number should be 6 digits");
//  frmvalidator.addValidation("ddNo","maxlength=6","DD number should be 6 digits");
  frmvalidator.addValidation("date","req","Please enter DD issue Date");
  frmvalidator.addValidation("bankName","req","Please enter Bank Name");
  frmvalidator.addValidation("bankName","maxlength=25","Bank Name should be upto 25 characters");
  frmvalidator.addValidation("branchName","req","Please enter Branch Name/Address");
  frmvalidator.addValidation("bankName","maxlength=50","Branch Name/Address should be upto 50 characters");
  frmvalidator.addValidation("ddAmount","req","Please enter DD Amount");
  frmvalidator.addValidation("ddAmount","numeric","DD Amount should be numeric or decimal");
 </script> 
  </body>