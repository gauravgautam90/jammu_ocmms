
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

  <g:form name="editWaterSolidDispos" method="post" action="editHotelWaterConsumptionMaster" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Hotel Water Consumption Detail</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 
 					
 					<tr><td><table class="tblbdr"> 
 					
 					<tr bgcolor="#A8DAF3">
                        
                        <td width="150px" class="headngblue" ><div  class="style3">Consumption Type</div></td>
                                   <td width="150px" class="headngblue" ><div  class="style3">Quantiy</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Delete</div></td>
                             </tr>
 <g:each in="${hotelWaterConsumptionlist}" status="i" var="hotelWaterConsumptionInst">
  <tr align="center" >
  					
                        <td bgcolor="#E8F6F9"><span class="txt style6">${hotelWaterConsumptionInst.type} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelWaterConsumptionInst.quantity} </span></td>
  					 <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=hotelWaterConsumptionInst.id%>"/>
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

<script language="JavaScript" type="text/javascript">
  
  
 </script>   
 

</body>
</html>