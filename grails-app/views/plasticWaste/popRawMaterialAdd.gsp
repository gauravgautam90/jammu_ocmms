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
</head>
<body>
<g:form name="waterSourceModeUses" method="post" action="saveRawMaterialDetails" >
<table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					 
 					
 					<tr bgcolor="#D1D1D1">
					
					<td align="left" width="100%"valign="middle"  class="headngblue">Raw-Material Details</td>
					</tr>
 				 <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                   <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>

                      </span></div></td>
                    </tr>
 					<tr><td>
 					<input type="hidden" name="appDetId" value="<%=app%>">
 					<table width="100%" border="0" align="center">
						 	
						
						 						
							
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="50%" align="center" >Raw Materials / Process chemicals (Name)</td>
							  <td width="50%" align="center" >Unit Type</td>
							  <td width="100%" align="center" >Quantity 
							  (in selected Unit Type)</td>
							  
						</tr>
						
						   		
						
						<tr>
						      <td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="rawMaterialName" type="text" maxlength="250" size="50"class="txt4" />
							  <span class="sidetxt"></span></span></td>
							  
							  <td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select optionKey="id"  class="txt4" from="${UnitMaster.list()}" name="unit" ></g:select>
							  <span class="sidetxt"></span></span></td>
							
								
							  <td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="quantity" type="text" maxlength="250" size="50"class="txt4" />
							  <span class="sidetxt"></span></span></td>
							 
                  
															
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
 					             <td width="20%" class="headngblue" ><div  class="style3">Raw Materials / Process chemicals (Name)</div></td>
                                 <td width="30%" class="headngblue" ><div  class="style3">Unit Type</div></td>
                                 <td width="30%" class="headngblue" ><div  class="style3">Quantity 
   							  (in selected Unit Type)</div></td>
                                 
                    </tr>
                                       
 <g:each in="${productDetails}" status="i" var="rawMaterialDetailInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.rawMaterial} </span></td>
                     <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.unit} </span></td>
  					 <td bgcolor="#E8F6F9"><span class="txt style6">${rawMaterialDetailInst.quantity} </span></td>
  					 
  					
                        
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>

<!-- --------------------------- -->

						</g:form>
<script language="JavaScript" type="text/javascript">
 var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("rawMaterialName","req","Please enter raw-material name");
  frmvalidator.addValidation("rawMaterialquantity","dec","Please enter decimal or numeric value in raw-material Quantity");
  frmvalidator.addValidation("rawMaterialprev","dec","Please enter decimal or numeric value in raw-material previous Quantity");
  frmvalidator.addValidation("rawMaterialcurr","dec","Please enter decimal or numeric value in raw-material current Quantity");
  frmvalidator.addValidation("quantity","req","please enter quantity");
  frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
 
  
  
 </script>  
						
						

</body>