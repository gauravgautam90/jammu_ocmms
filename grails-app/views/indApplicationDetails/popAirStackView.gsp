
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Air Stack Emission Details</title>

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

    <div>
 

 


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
                        <td width="150px" class="headngblue" ><div  class="style3">Stack Attached To Plant</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Shape</div></td>
  			            <td width="150px" class="headngblue" ><div  class="style3">Stack Height above ground level(meters)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Stack Height above factory room(meters)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Plant Capacity</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Unit</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Pollution Control Equipments</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Draft Type</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Material Of Construction</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Fuel Type</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Fuel Quantity(TP/KLD)</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Gas Quantity(Nm<sup>3</sup>/hr)</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Diameter Size(meters)</div></td>
                     	<td width="150px" class="headngblue" ><div  class="style3">Gas Temperature (&deg C)</div></td>
                     	<td width="150px" class="headngblue" ><div  class="style3">Exit Gas Velocity(m/sec)</div></td>
                     
                      	  
                      </tr>
 <g:each in="${stackList}" status="i" var="stackDetInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.stack}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.shape}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.heightGrdLevel}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.heightFacLevel}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.capacity}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.unit}
                        </span></td>
                         <td align="left" bgcolor="#E8F6F9">
                         <%
                         ArrayList pollCntrlList = pollCntrlBList.get(i);
                         for(int j=0;j<pollCntrlList.size();j++){ %>
                         <span class="txt style6"><%=(pollCntrlList.get(j)).pollutionCntrlMeasure %></span>,
                         <%}%>
                        </td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.draftType}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.matOfCon}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.fuelTyp}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.fuelQty}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.gasQty}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.diamSize}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.gasTemp}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stackDetInst.gasVel}
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

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0">  <input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/<%=appDetId%>#country6', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"></td>
		  
  </tr>

</table>

</body>
</html>