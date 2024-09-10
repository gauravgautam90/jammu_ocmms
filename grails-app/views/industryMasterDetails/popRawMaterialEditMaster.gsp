
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

  <g:form name="editWaterSolidDispos" method="post" action="editRawMaterialDetailsMaster" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Raw-Material Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 
 			<input type="hidden"  name="page" value="<%=page%>" />		
 					<tr><td><table class="tblbdr" width="100%"> 
 					
 					<tr bgcolor="#A8DAF3" align="center">
                        <%if(appFor=="productMix"){
						      %> 
						       
						       <td width="10%" class="headngblue" ><div  class="style3">Name of the Raw-Material</td>
						       <td width="10%" class="headngblue" ><div  class="style3">Existing capacity</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Proposed Quantity</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Total Quantity after change of Product mix</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Units</td>
							    <td width="150px" class="headngblue" ><div  class="style3">Delete</div></td>
							   <%}
							   
							   else if(appFor=="expansion") {%>
							   
							   <td width="10%" class="headngblue" ><div  class="style3">Description</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Existing Quantity</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Expansion Quantity</td>
							   <td width="10%" class="headngblue" ><div  class="style3" >Total Quantity after Expansion</td>
							   <td width="10%" class="headngblue" ><div  class="style3">Units</td>
						 <td width="150px" class="headngblue" ><div  class="style3">Delete</div></td>
						       <%}else {%>
						
							   <td width="40%" class="headngblue" ><div  class="style3">Description</td>
							   <td width="40%" class="headngblue" ><div  class="style3" >Quantity</td>
							   <td width="20%" class="headngblue" ><div  class="style3">Units</td>
							   <td width="150px" class="headngblue" ><div  class="style3">Delete</div></td>
							   <%}%>
                                    
                                           
                    
                             </tr>
 <g:each in="${rawMaterialDetailList}" status="i" var="rawMaterialDetailInst">
  <tr align="center" align="center">
  					
                <%if(appFor=="productMix"){
					 %> 
  
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.totalQuant} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}    </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=rawMaterialDetailInst.id%>"/>
                     </span></td>
  
                     <%}
							   
				 else if(appFor=="expansion") {%>
							   
				<td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.totalQuant} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}    </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=rawMaterialDetailInst.id%>"/>
                     </span></td>
                 <%}else {%>
   
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                  <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}    </span></td>
                   <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=rawMaterialDetailInst.id%>"/>
                     </span></td>
                    <%}%>
  					
  					
  				
                        
                              
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

 <%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
								%>
	<tr>
	<%if(page=="freshAdd"){%>
    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReportFresh/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
	<%}else if(page=="renewalAdd"){%>
	<td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReportRenewal/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
	<%}else if(page=="interAdd"){%>  
	<td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReportInter/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
	<%}%>
  </tr>
  <%}}%>

</table>
<div align="left" class="txt" style="color: navy">
  </br></br>
  &nbsp;<b>* Instructions:</b>
  &nbsp;<ul> 
  <li>Please select the checkbox to delete the raw-material details and click "Delete" button</li>
  <li>Select multiple check box and click "Delete" button to delete multiple records</li>
  <li>To edit the raw-material details, delete the raw-material details and then add new one</li>
  </ul>
  

</div>
		</div>
		</div>
		
		
		</td>
	</tr>

	<tr>



	</tr>



</table>
<!-- - -->

  		</g:form>
</body>