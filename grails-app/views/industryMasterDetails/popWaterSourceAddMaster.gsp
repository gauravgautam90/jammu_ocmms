<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

</g:javascript>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body>
<div align="center">
<table width="90%" cellpadding="1" cellspacing="1" class="tblbdr">
<g:form name="waterSource" method="post" action="saveWaterSourceMaster" >
<tr><td colspan="2" class="headngblue" align="center" bgcolor="#B8DAF3">Water Source Details</td></tr>
<tr>
                        <td width="25%" bgcolor="#A8DAF3" class="headngblue" ><div align="left" class="style3">Source Type</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                                   <g:select optionKey="id"  from="${WaterSourceMaster.list()}" class="txt4" name="waterSource"></g:select>
                                   <span class="sidetxt">(select source of water)</span></td>
                      </tr>
 	<tr>
                              <td width="150px" align="left" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="left" class="style3">Source Name</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left"><input name="sourceName" type="text" maxlength="100" size="30"class="txt4" /><span class="sidetxt"> (Enter Source Name)</span>
</div>                        </td>
        </tr>	
  <tr>
                              <td width="150px" align="left" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="left" class="style3">Quantity (Kl/D)</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left"><input name="sourceQuantity" type="text" size="8"class="txt4" />&nbsp;<span class="sidetxt">(quantity of water intake, only decimal or numeric)</span></div>
                        </td>
        </tr>		
        <tr><td><input name="indAppId" type="hidden" value="<%=appDetId%>" /></td></tr>	
		<tr>
		<span class="txt" style="color: navy"><b>click next to enter further details</b></span>
		<td colspan="2" align="center"><input type="submit" name="Next" value="NEXT >>" class="actionbutton"></td>
		</tr>	 
                      
 </g:form>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSource");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("sourceQuantity","req","Please enter Quantity");
  frmvalidator.addValidation("sourceQuantity","decimal","Quantity should be decimal or numeric");
  
 </script>                     
</table>
</div>
</body>