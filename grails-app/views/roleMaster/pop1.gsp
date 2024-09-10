<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >

<head>
<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Untitled Document</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script> 

 

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<g:javascript library="prototype" />


 </head>
  <body>

  
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 

<g:form controller="roleMaster" action="popsave"  method="post" name="myform" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Add Role </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 
 
						<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Dealing Group:</div></td>
                        <td align="left"><span class="txt style6">
                          <g:select optionKey="id" from="${GroupMaster.list()}" name="group.id"  ></g:select>
                        </span></td>
                      </tr>
 
  <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Role Name:</div></td>
                        <td ><div align="left">
                          <input name="roleName" type="text" class="txt4" >
                        </div></td>
                      </tr>
                       <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue"><div align="right" class="style3">Description:</div></td>
                       <td ><div align="left">
                          <input name="roleDesc" type="text" class="txt4" >
                        </div></td>
                      </tr>
                      <tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Primary Officer:</div></td>
                        <td align="left"><span class="txt style6">
                        
                       
    
                  <g:select optionKey="id" from="${myArrayList2}" id="primaryEmployee.id" name="primaryEmployee.id"  ></g:select>
                        
                        
                        
                    </span></td>
                      </tr>
                       <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Link Officer:</div></td>
                        <td align="left"><span class="txt style6">
                        
                       
    
                   <g:select optionKey="id" from="${myArrayList2}" name="linkEmployee.id" value="${roleProfileAssignmentInstance?.linkEmployee?.id}" ></g:select>
                        
                        
                        
                    </span></td>
                      </tr>
					  
  </table>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="save" value="Save" controller="roleMaster" action="popsave" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
		</table>
  			</g:form>

  <tr>

    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>

  </tr>

  

</table>
</td></tr></table>
<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("roleName","req","Please enter rolename");
 frmvalidator.addValidation("roleName","alnum_s","Enter valid rolename");
 frmvalidator.addValidation("roleDesc","alnum_s","enter valid description");
 
 

 
 
</script>
</body>
</html>
 