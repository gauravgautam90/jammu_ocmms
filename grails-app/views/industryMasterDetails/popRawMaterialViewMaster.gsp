
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
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Raw-Material Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 <input type="hidden" name="appId" value="<%=appDetId%>">
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					<tr align="center" bgcolor="#A8DAF3">
 					           <%if(appFor=="productMix"){
						      %> 
						       
						       <td width="10%" class="headngblue" ><div  class="style3">Name of the Raw-Material</td>
						       <td width="10%" class="headngblue" ><div  class="style3">Existing capacity</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Proposed Quantity</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Total Quantity after change of Product mix</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Units</td>
							   
							   <%}
							   
							   else if(appFor=="expansion") {%>
							   
							   <td width="10%" class="headngblue" ><div  class="style3">Description</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Existing Quantity</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Expansion Quantity</td>
							   <td width="10%" class="headngblue" ><div  class="style3" >Total Quantity after Expansion</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Units</td>
						
						       <%}else {%>
						
							   <td width="40%" class="headngblue" ><div  class="style3">Description</td>
							   <td width="40%" class="headngblue" ><div  class="style3" >Quantity</td>
							   <td width="20%" class="headngblue" ><div  class="style3">Units</td>
							  
							   <%}%>
                                    
                         </tr>
  <g:each in="${rawMaterialDetailList}" status="i" var="rawMaterialDetailInst">
  <tr align="center" >
  
  
                <%if(appFor=="productMix"){
					 %> 
  
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.totalQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}    </span></td>
                
  
                     <%}
							   
				 else if(appFor=="expansion") {%>
							   
				<td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.totalQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}    </span></td>
                
                 <%}else {%>
   
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit} </span></td>
                    <%}%>
   
                    
                        
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	




</table>

</body>

</html>