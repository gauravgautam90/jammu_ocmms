<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="https://www.w3.org/1999/xhtml">

<head>

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
 

 

<g:form action="popsave" name="myform" method="post" >
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Create Group </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Office Name:</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9">
                             <span class="txt style6">    
                                <g:select optionKey="id" from="${OfficeMaster.list()}" name="office.id"  ></g:select>
                                
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Group Name:</div></td>
                        <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="groupName" name="groupName" class="txt4"  value="${fieldValue(bean:groupMasterInstance,field:'groupName')}"/>
                        </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Description:</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="groupDesc" class="txt4" name="groupDesc" value="${fieldValue(bean:groupMasterInstance,field:'groupDesc')}"/>
                        </div></td>
                      </tr>
                      
    
	  </table>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="save" value="Save" class="actionbutton" action="popsave" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
		</table>
  			

  <tr>

    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>

  </tr>

  

</table>
</td></tr></table>
</g:form>
<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("groupName","req","Please enter group Name");
 frmvalidator.addValidation("groupName","alnum_s","Enter valid groupName");
 frmvalidator.addValidation("groupDesc","alnum_s","enter valid groupDesc");
 
 
 
 
 
</script> 
</body>
</html>
