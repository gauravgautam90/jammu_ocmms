<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%><html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
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
<table align="center">
<tr align="center">
<td width="100%" align="center">
<div >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Furnace Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
</table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr><td><table class="tblbdr">
 					<tr bgcolor="#A8DAF3">
                           <td width="12.5%" class="headngblue" ><div  class="style3">Is Furnace installed</div></td>
                                                                      <td width="12.5%" class="headngblue" ><div  class="style3">Furnace Name</div></td>
                       
                         <td width="12.5%" class="headngblue" ><div  class="style3">Prescribed parameters achieved</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Air pollution control device installed with furnace</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Stack height above ground level</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Type of fuel</div></td>
						 <td width="12.5%" class="headngblue" ><div  class="style3">Quantity</div></td>
						  <td width="12.5%" class="headngblue" ><div  class="style3">Unit</div></td>
                     </tr>
 <g:each in="${furnaceDetailList}" status="i" var="miscelleneousList">
  <tr align="center" >
                      <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.furnaceInstalled} </span></td>
  					  					  	<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.furnaceName} </span></td>
  					
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.prescribedParameters} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.airPollControlDevicefurnace} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.stackHeight} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.typeOfFuel} </span></td>
                     
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.quantity} </span></td>
                      <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.unit} </span></td>
                      
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					</tr>
 					</table></td></tr>
  		</table>
  		</div></div></td></tr>	
	 <tr>
    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="history.back()" class="actionbutton"></td>
  </tr>
</table>
</body>
</html>