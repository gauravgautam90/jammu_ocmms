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
<g:form name="waterSourceModeUses" method="post" action="saveHotelWasteEmissionDetail" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					 
 					
 					<tr bgcolor="#D1D1D1">
					
					<td align="center" valign="middle"  class="headngblue">Hotel Waste Generation and Emission Details</td>
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
 					<table width="100%" border="0" >
						 	
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Type</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" optionKey="id"  from="${HotelWasteEmissionGenerationMaster.list()}"  name="type" ></g:select>
								<br><span class="sidetxt">(select type)</span>	
						</td>
							  
				  </tr>	
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Quantity</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="quantity" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(quantity of waste generation)</span></span></td>
							</tr>
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Nature</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="nature" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Method of Disposal/Treatment</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="tmethod" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
						  
						  					
							
														
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
					<td><span class="txt" style="color: navy"><b>List of Hotel Waste & Emission Details.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					             <td width="20%" class="headngblue" ><div  class="style3">Type</div></td>
                                   <td width="20%" class="headngblue" ><div  class="style3">Quantity</div></td>
                                    <td width="20%" class="headngblue" ><div  class="style3">Nature</div></td>
                                    <td width="20%" class="headngblue" ><div  class="style3">Method of Disposal/Treatment</div></td>
                                    
                         </tr>
                     
                     
                     
 <g:each in="${hotelWasteEmissionList}" status="i" var="hotelWasteEmissionInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${hotelWasteEmissionInst.type}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelWasteEmissionInst.quantity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelWasteEmissionInst.nature}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelWasteEmissionInst.tmethod}</span></td>
  					
                        
        </tr>		
      </g:each>		
 				
 					
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
 
  frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
 
  
  
 </script>  
						
						

</body>