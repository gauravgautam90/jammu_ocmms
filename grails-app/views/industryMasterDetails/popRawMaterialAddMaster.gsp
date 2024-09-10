<head>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}



</g:javascript>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<g:javascript>
    
function check1()
    {
   
   			var selectmenu1=document.getElementById('unit').value;

  		
		if(selectmenu1 == "Others")
		{
			document.getElementById('selectTemp').style.display = 'block';
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
				
		}

       
    }
    
 </g:javascript>












</head>
<body>
<g:form name="waterSourceModeUses" method="post" action="saveRawMaterialDetailsMaster" >
<table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					 
 					<input type="hidden"  name="page" value="<%=page%>" />
 					<tr bgcolor="#D1D1D1">
					
					<td align="center" valign="middle"  class="headngblue">Raw-Material Details</td>
					</tr>
 				 <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                   <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>

                      </span></div></td>
                    </tr>
 					<tr><td>
 					<input type="hidden" name="appId" value="<%=appDetId%>">
 					<table width="100%" border="0" align="center">
						 	
						
						 						
							
						<tr class="headngblue" bgcolor="#A8DAF3">
						
						      <%if(appFor=="productMix"){
						      %> 
						       
						       <td width="40%" align="center" >Name of the Raw-Material</td>
						       <td width="40%" align="center" >Existing capacity</td>
							   <td width="40%" align="center" >Proposed capacity</td>
							   <td width="40%" align="center" >Total Capacity after change of Product mix</td>
							   <td width="20%" align="center" >Units</td>
							   
							   
							   <%}
							   
							   else if(appFor=="expansion") {%>
							   
							   <td width="40%" align="center" >Description</td>
							   <td width="40%" align="center" >Existing Quantity</td>
							   <td width="40%" align="center" >Expansion Quantity</td>
							   <td width="40%" align="center" >Total Quantity after Expansion</td>
							   <td width="20%" align="center" >Units</td>
						
						       <%}else {%>
						
							   <td width="40%" align="center" >Description</td>
							   <td width="40%" align="center" >Quantity</td>
							   <td width="20%" align="center" >Units</td>
							  
							   <%}%>
							  
							  
							  
						
						</tr>
						
						   		
						
						<tr>
						 <%if(appFor=="productMix"){
						      %> 
						      
						       <td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="product" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="existingQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="proposedQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="totalQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							
							<span class="sidetxt"></span></span></td>
						  
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select name="unit" id="unit" from="${['Kg/day','Kg/month','Tons/day','Tons/month','Kl/day','Kl/month','Nos./day','Nos./month','Tons/Annum(TPA)']}" class="txt4"  ></g:select><br>
							<span class="sidetxt"></span></span></td>
					 
							
						      
						      
						      
						       <%}
							   
							   else if(appFor=="expansion") {%>
							   
					
					       <td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="product" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="existingQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="proposedQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="totalQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<span class="sidetxt"></span></span></td>
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select name="unit" id="unit" from="${['Kg/day','Kg/month','Tons/day','Tons/month','Kl/day','Kl/month','Nos./day','Nos./month','Tons/Annum(TPA)']}" class="txt4"  ></g:select><br>
							<span class="sidetxt"></span></span></td>
					 
					         
					          <%}else {%>
					 
					        <td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="product" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="existingQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select name="unit" id="unit" from="${['Kg/day','Kg/month','Tons/day','Tons/month','Kl/day','Kl/month','Nos./day','Nos./month','Tons/Annum(TPA)']}" class="txt4"  ></g:select><br>
							<span class="sidetxt"></span></span></td>
					 
					          <%}%>
							
							  
											
							
														
						  <tr>
                   <td colspan="6">
                   <div id="AjaxPanelStack">
                   
                   </div>
                   </td>
                   </tr>
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						</table></td></tr>
 					
					<tr>
					<td><span class="txt" style="color: navy"><b>List of Raw-Materail Details added.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
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
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}   </span></td>
                
  
                     <%}
							   
				 else if(appFor=="expansion") {%>
							   
				<td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.totalQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}   </span></td>
                
                 <%}else {%>
   
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.product} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.existingQuant} </span></td>
                 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit}    </span></td>
                    <%}%>
   
                    
                        
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
				
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
					</td>
					</tr>	
					
					  
  </table>

<!-- --------------------------- -->

						</g:form>
<script language="JavaScript" type="text/javascript">
 var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("rawMaterialname","req","Please enter Item of Description");  
  frmvalidator.addValidation("rawMaterialquantity","req","Please enter Item Code(ITC/NIC)");
 <!-- frmvalidator.addValidation("rawMaterialquantity","dec","Please enter decimal or numeric value in raw-material Quantity");-->

   
 
  
  
 </script>  
						
						

</body>