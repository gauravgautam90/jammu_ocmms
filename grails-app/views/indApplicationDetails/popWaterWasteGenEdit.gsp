
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

  <g:form name="watertreat" method="post" action="editWaterWasteGen" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Waste Water Generation Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr"> 
 					
 					<tr bgcolor="#A8DAF3">
                        
                         <td width="20%" align="center" valign="middle"  class="headngblue">Type of Effluent</td>
                        <td width="150px" class="headngblue" ><div  class="style3">Maximum Generation Quantity of Effluent(KL/D)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Effluent to be Recycle(KL/D)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Effluent to be Disposal/Discharge Quantity(KL/D)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Mode of Disposal (with name)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Delete</div></td>
                      </tr>
 <g:each in="${wasteWaterGenDetInstList}" status="i" var="wasteWaterGenDetInst">
  <tr align="center" >
  					
  					     <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.typeOfEffluent}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.maxGeneration}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.effRecycle}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.effDischarge}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.disposalMode}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=wasteWaterGenDetInst.id%>"/>
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