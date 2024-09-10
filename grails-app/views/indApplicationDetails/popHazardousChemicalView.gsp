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
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Hazardous Chemical Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
</table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr><td><table class="tblbdr">
 					<tr bgcolor="#A8DAF3">
                         <td width="12.5%" class="headngblue" ><div  class="style3">Is the Unit a Major Accident Hazard unit as per MSIHC Rules?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Is the unit an isolated storage?</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Indicate the status of Compliance</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Has approval of site been obtained from concerned authority?</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Has the unit prepared an Off-site Emergency Plan?</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Is it updated?</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Has the information on imports of chemicals been provided to the concerned authority?</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Does the unit process a policy under the PLI act?</div></td>
                     	 <td width="12.5%" class="headngblue" ><div  class="style3">Whether unit is generating hazardeous waste?</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Category No</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Present Treatment of Hazardeous Waste</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Area</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Location</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Methodology</div></td>
                     	
                     	 </tr>
 <g:each in="${hazList}" status="i" var="stackDetInst">
  <tr align="center" >
  						<td bgcolor="#E8F6F9" ><span class="txt ">${stackDetInst.accident}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.isolatedStorage}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.compStatus}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${stackDetInst.siteApproval}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.emergency}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.isUpdated}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.importChem}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.pliAct}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.hwmGenerating}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${stackDetInst.categoryNo}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.presentTreatment}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.area}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.location}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${stackDetInst.methodology}
                        </span></td>
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