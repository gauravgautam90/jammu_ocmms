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
  <g:form name="editDGsetMaster" method="post" action="editDGsetMaster" >
 <table align="center">
<tr align="center">
<td width="100%" align="center">
<div >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">D.G. Set Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					<tr bgcolor="#A8DAF3">
                         <td width="5%" class="headngblue" ><div  class="style3">Make of D.G.Set</div></td>
                         <td width="5%" class="headngblue" ><div  class="style3">Model of D.G.Set</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Power Rating</div></td>
                     	 
                     	  <td width="5%" class="headngblue" ><div  class="style3">Fuel Quantity</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Stack Height</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Height of the building</div></td>
                     	 
                     	 
                     	 
                     	 
                     	 <td width="5%" class="headngblue" ><div  class="style3">Sound Power Level</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Location</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Used only at the time of Load Shedding</div></td>
                     	 <td width="7%" class="headngblue" ><div  class="style3">Additional information of Load Shedding</div></td>
                     	 <td width="7%" class="headngblue" ><div  class="style3">Whether noise from D.G.Set controlled</div></td>
                     	 <td width="9%" class="headngblue" ><div  class="style3">Whether D.G.Set room is treated acoustically</div></td>
                     	 <td width="10%" class="headngblue" ><div  class="style3">Whether the exhaust gases passed through a suitable exhaust maffler</div></td>
                     	 <td width="9%" class="headngblue" ><div  class="style3">Whether installation of D.G.Set is in compliance</div></td>
                     	 <td width="9%" class="headngblue" ><div  class="style3">Steps taken for minimization of vibration transmission to the neighourhood</div></td>
                     	 <td width="9%" class="headngblue" ><div  class="style3">Steps taken for minimization of exhaust gas leaks</div></td>
                      <!--	
                    	   <td width="6%" class="headngblue" ><div  class="style3">Total height of the stack</div></td> -->
                     	 
                     	 
                     	 <td  width="4%" class="headngblue" ><div  class="style3">Delete</div></td>
                    </tr>
<g:each in="${DGList}" status="i" var="dgInst">
   <tr align="center" >
 						<td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.makeDGset}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.modelDGset}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.powerRating}
                        </span></td>
                         <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.fuel}
                        </span></td>
                       <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.stackHeight}
                        </span></td>
                       <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.heightOfBuilding}
                        </span></td>
                       
                       
                       
                       
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.soundLevel}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.location}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.loadShedding}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.sheddingInfo}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.noise}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.room}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.exhaustGas}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.installation}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.minVibration}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.minLeaks}
                        </span></td>
                     <!--   
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.totalHeight}
                        </span></td> -->
                        
                        <td  bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=dgInst.id%>"/>
                        </span></td>
        </tr>		
      </g:each>		
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