
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
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Air Stack Emission Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                         <td width="10%" class="headngblue" ><div  class="style3">Stack Attached To Plant(Boilers/Heaters/Furnaces/Junction Points/Materials Handling Section/Fugutive Emission Sources including Transfer Points etc.)</div></td>
                        <td width="15%" class="headngblue" ><div  class="style3">Fuel Name</div></td>
                        <td width="10%" class="headngblue" ><div  class="style3">Fuel Consumption</div></td>
                  
                     	<td width="15%" class="headngblue" ><div  class="style3">Unit</div></td>  
                  		
                  		<td width="7%" class="headngblue" ><div  class="style3">Calorific Value %</div></td>
                        <td width="8%" class="headngblue" ><div  class="style3">Ash Content %</div></td>
                        <td width="8%" class="headngblue" ><div  class="style3">Sulphur Content %</div></td>
 	                 	<td width="7%" class="headngblue" ><div  class="style3">Others</div></td>
                  
                  
                      	<td width="20%" class="headngblue" ><div  class="style3">Pollution Control Equipments</div></td>
					 </tr>
 <g:each in="${flueList}" status="i" var="flueInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9" ><span class="txt ">${flueInst.stack}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${flueInst.fuel}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${flueInst.consumption}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt ">${flueInst.unit}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.calorValue}
                        </span></td> 
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.ashCon}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.sulphurCon}
                        </span></td>
                  		<td bgcolor="#E8F6F9"><span class="txt style6">${flueInst.otherCon}
                        </span></td>
                  
                        
                         <td bgcolor="#E8F6F9" width="20%">
                         <%
                         ArrayList pollCntrlList = pollCntrlBList.get(i);
                         for(int j=0;j<pollCntrlList.size();j++){ %>
                         <span class="txt"><%=(pollCntrlList.get(j)).pollutionCntrlMeasure %></span>,
                         <%}%>
                         </td>
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	
<!--
 <tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="history.back()" class="actionbutton"></td>
		  
  </tr>
-->


</table>

</body>
</html>