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
<g:form name="waterSourceModeUses" method="post" action="saveHotelFacilityDetailInpsection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					 
 					
 					<tr bgcolor="#D1D1D1">
					
					<td align="center" valign="middle"  class="headngblue">Hotel Facility Details</td>
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
						<td  bgcolor="#E8F6F9" align="left" 
						class="value ${hasErrors(bean:hotelFacilityInst,field:'hotelFacilityType','errors')} txt"><g:select
						optionKey="id" from="${districtList}"
						name="hotelFacilityType.id"
						noSelection="${[9999:'Not Selected']}"
						onchange="${remoteFunction(controller:'indApplicationDetails', action:'myAjax12',update:'updateSelect', params:'\'cont=\' + this.value' )}"
						value=""
						class="txt4"></g:select>&nbsp;(select Facility Type)</td>
						</tr>											
						 						
							
						
				  
				  <tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="30%" align="left" >Facility</td>
					<td bgcolor="#E8F6F9" align="left"> 
					
					<div id="updateSelect">
					
					<g:select optionKey="id"
					from="${facilityTypeList}" name="facility.id" 
					
					class="txt4"></g:select>&nbsp;(enter facility)
					</td>
					</tr>
				  
				  
				  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Capacity</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							   <input name="capacity" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"><span class="sidetxt">(seating capacity/vehicle parking capacity etc.)</span>	
						</td>
							  
				  </tr>	
						  
						   <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Facility Detail</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="facilityDetail" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(write facility detail max 50 chrs)</span></span></td>
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
					<td><span class="txt" style="color: navy"><b>List of Hotel Facility details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					             <td width="150px" class="headngblue" ><div  class="style3">Type</div></td>
                                   <td width="150px" class="headngblue" ><div  class="style3">Facility</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">capacity</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Facility Detail</div></td>
                         </tr>
                     
                     
                     
 <g:each in="${hotelFacilitylist}" status="i" var="hotelFacilityInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${hotelFacilityInst.hotelFacilityType}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelFacilityInst.facility}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelFacilityInst.capacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelFacilityInst.facilityDetail}</span></td>
  					
                        
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
 					<tr><td olspan="6" align="center">
 					<% if(type=="REGULAR"){
 	           			System.out.println("type...."+type)
 	           			%>
 	           		
 	           		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

 	           			()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
 	           				
 	           		<%}else{%>
 	                  
 						<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

 	()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
 		
 					<%}%></td></tr>			  
 					  </tr>
					  
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
 // frmvalidator.addValidation("type","req","Please enter details :'type'");
  frmvalidator.addValidation("facility.id","req","Please select details :'type and facility'");
  frmvalidator.addValidation("facilityDetail","req","Please enter details :'facility Detail'");
  
  
 </script>  
						
						

</body>