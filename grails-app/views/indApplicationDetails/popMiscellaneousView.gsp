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
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Miscellaneous Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
</table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr><td><table class="tblbdr">
 					<tr bgcolor="#A8DAF3">
                          <td width="12.5%" class="headngblue" ><div  class="style3">Pollution Control Equipments(For Water pollution control</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Total Cost on pollution control</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Is DG Set installed</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">D.G Set capacity</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Acostic enclosure</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Noise Pollution</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Measure to contain noise pollution taken</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Prescribed parameters achieved for noise</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Hazardeous Substance Used</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Name of the substance</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Quantity(in KLD)</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Hazardeous waste being produced</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Name of hazardeous waste</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Quantity(in KLD)</div></td>
                     </tr>
 <g:each in="${miscelleneousList}" status="i" var="miscelleneousList">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.controlMeasures} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.totalCost} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.dgStInstalled} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.dgSetCapacity} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.AcausticEnclosure} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.noisePollution} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.noiseMeasures} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.presParameters} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.hazardeousSubs} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.nameOfHazardeous} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.quatityOfHazard} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.isHazarSubstanceProduced} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.nameOfHazardWaste} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.quatityOfWaste} </span></td>
                        
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