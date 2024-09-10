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
<g:form name="waterSourceModeUses" method="post" action="saveHotelWaterConsumptionMaster" >
<table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					 
 					
 					<tr bgcolor="#D1D1D1">
					
					<td align="center" valign="middle"  class="headngblue">Hotel Water Consumption Detail</td>
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
							  <td width="30%" align="left" >Consumption Type</td>
							  <td width="30%" align="left" >Quantity</td>
						</tr>
						
						<tr>	  
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" optionKey="id"  from="${HotelWaterConsumptionMaster.list()}"  name="type" ></g:select>
								<br><span class="sidetxt">(select hotel water consumption type)</span>	
						</td>
						  	 					  
						  
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="quantity" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(in litres)</span></span></td>
							
							</tr>
							
											
							
														
						  <tr>
                   <td colspan="6">
                   <div id="AjaxPanelStack">
                   
                   </div>
                   </td>
                   </tr>
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><span style="color:red">*Please enter NA where nothing is applicable</span></br><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						</table></td></tr>
 					
					<tr>
					<td><span class="txt" style="color: navy"><b>List of Hotel Water Consumption details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					             <td width="150px" class="headngblue" ><div  class="style3">Consumption Type</div></td>
                                   <td width="150px" class="headngblue" ><div  class="style3">Quantity(in litres)</div></td>
                                    
                         </tr>
                     
                     
                     
 <g:each in="${hotelWaterConsumptionlist}" status="i" var="hotelWaterConsumptionInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${hotelWaterConsumptionInst.type} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelWaterConsumptionInst.quantity} </span></td>
  					
                        
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
  frmvalidator.addValidation("type","req","Please enter details :'type'");
 <!-- frmvalidator.addValidation("quantity","dec","Please enter quantity in numeric/decimal");-->
 
  
  
 </script>  
						
						

</body>