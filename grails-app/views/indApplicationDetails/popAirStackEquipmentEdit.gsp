
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

  <g:form name="AirStackEdit" method="post" action="editAirStackEquipmentDetails" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Air Stack Emission Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="15%" class="headngblue" ><div  class="style3">Stack Attached To Plant</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">Equipment Name</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">Existing or Proposed</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">For which Pollutant</div></td>
                        <td width="20%" class="headngblue" ><div  class="style3">Date of Installation</div></td>
                        <td width="10%" class="headngblue" ><div  class="style3">Reduction Efficiency Guaranteed By Manufacturer(in %)</div></td>
                      	<td width="15%" class="headngblue" ><div  class="style3">Quantity of Current/Expected Emission(kg/D)</div></td>
                      	<td width="20%" class="headngblue" ><div  class="style3">Quality of Current/Expected Emission(mg/Nm3)</div></td>
                      	<td width="20%" class="headngblue" ><div  class="style3">Whether monitoring is being Done or Proposed</div></td>
                      		<td class="headngblue" ><div  class="style3">Delete</div></td>
                      	
                      </tr>
 <g:each in="${airStackEquipmentList}" status="i" var="stackInst">
 <tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.stack}
                        </span></td> 
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.equipment}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.state}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.pollutant}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.installation}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.redEfficiency}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackInst.quantity}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="left"><span class="txt style6">${stackInst.quality}
                        </span>
                         </td>
                               <td bgcolor="#E8F6F9" align="left"><span class="txt style6">${stackInst.monitoring}
                        </span>
                         </td>
                         
                           <td  bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=stackInst.id%>"/>
                          
                        </span></td>
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

   <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>



</table>
</g:form>
</body>
</html>