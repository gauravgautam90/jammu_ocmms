<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createNewRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel1'},'temp.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<script>
    
    function checkField(id)
    {
        if (id.value == "" )
        {
    
            id.value = "0";
        }
          
        
        document.getElementById("totalHeight").value = eval(document.getElementById("buildingHeight").value)+ eval(document.getElementById("stackHeight").value);
      
    }
       
     
    </script>
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
<g:form name="saveDGSourceMaster" method="post" action="saveDGSourceInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<div align="center" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px">
<table class="tblbdr">
<tr bgcolor="#D1D1D1">
			<td   align="center" valign="middle"  class="headngblue">D.G. Set Emission Source Details</td>
		</tr> 
				
			<tr><td>
				<table width="100%"  border="0" class="tblbdr">
					<tr bgcolor="#A8DAF3">
						<td width="12%" align="center" class="headngblue" ><div>Sources of Emission (D.G.Sets)</div></td>
 						<td width="12%" align="center" class="headngblue" ><div>Horse Power of the engine</div></td>
 						<td colspan="2" width="26%" align="center" class="headngblue" ><div>Engine RPM</div></td>
                        <td width="12%" align="center" class="headngblue" ><div>Fuel used and quantity per hour</div></td>
                        <td width="12%" align="center" class="headngblue" ><div>Capacity of D.G.Set</div></td>
                        <td width="14%" align="center" class="headngblue" ><div>Height of Building where D.G.Set is installed</div></td>
                        <td width="12%" align="center" class="headngblue" ><div>Height of the Stack above building</div></td>
             	      <td width="12%" align="center" class="headngblue" ><div>Total of a+b in meters</div></td>
                   
                    </tr>
					
				<tr>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="source" type="text" size="18" maxlength="50" class="txt4" />
							<input name="appId" type="hidden" value="<%=appDetId%>" /> 
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="horsePower" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(enter horse power)</span>	
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
						No Load<input name="noLoadRPM" type="text" size="8"class="txt4" />
						<br><span class="sidetxt">(enter No Load)</span>
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
						Full Load<input name="fullLoadRPM" type="text" size="8" class="txt4" />
						<br><span class="sidetxt">(enter Full Load)</span>
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="fuelQuantity" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(enter fuel qty.)</span>	
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="capacity" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(in KVA)</span>	
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="buildingHeight" id="buildingHeight" onclick="this.value=''"  onblur="checkField(this)" value="0" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(in metres)</span>	
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="stackHeight" id="stackHeight" onclick="this.value=''"  onblur="checkField(this)" value="0" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(in metres)</span>	
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="totalHeight" id="totalHeight" onclick="this.value=''"  onblur="checkField(this)" value="0" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(in metres)</span>	
					</td>
					
				</tr>
						
					<tr>
					<td colspan="8" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
					</tr>
					<span class="txt" style="color: navy"><b>Click Add button to enter details</b></span>
					
						
					
			  	</table>
				
				<tr>
					<!-- Div area for errors-->
					<td align="center" valign="middle">
					<span
						class="error">
		  		 		<g:if test="${flash.message}">
						<div class="message">${flash.message}</div>
						</g:if>	
					</span>
					</td>
				</tr>				
 				  
				<tr align="left">
				<td align="left"><span class="txt" style="color: navy"><b>List of D.G. Set Emission Source Details Added</b></span>
				<!--  -->
				
<div align="left" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3"><td width="12%" align="center" class="headngblue" ><div>Sources of Emission</div></td>
 						<td width="12%" align="center" class="headngblue" ><div>Horse Power of the engine</div></td>
 						<td colspan="2" width="24%" align="center" class="headngblue" ><div>Engine RPM<br>No Load&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Full Load</div></td>
                        <td width="12%" align="center" class="headngblue" ><div>Fuel used and quantity per hour</div></td>
                        <td width="12%" align="center" class="headngblue" ><div>Capacity of D.G.Set</div></td>
                        <td width="14%" align="center" class="headngblue" ><div>Height of Building where D.G.Set is installed</div></td>
                        <td width="14%" align="center" class="headngblue" ><div>Height of the Stack above building</div></td>
                   		<td width="14%" align="center" class="headngblue" ><div>Total of a+b in meters</div></td>
                   
                   
                    </tr>
                    
<g:each in="${DGList}" status="i" var="dgInst">
  <tr align="center" >						
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.source}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.horsePower}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.noLoadRPM}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.fullLoadRPM}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.fuelQuantity}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.capacity}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.buildingHeight}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.stackHeight}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${dgInst.totalHeight}
                        </span></td>
                                        
        </tr>		
      </g:each>		
 				
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
				
				<!--  -->
				</td>
				</tr>
				 <tr><td align="center">
				 <% if(type=="REGULAR"){
	           			System.out.println("type...."+type)
	           			%>
	           		
	           		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

	           			()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
	           				
	           		<%}else{%>
	                  
						<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

	()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
		
					<%}%></td></tr>
</table>
</div>
</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("saveDGSourceMaster");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("uses","req","Please enter details :'Source of Water, Use and Consumption Details'");
  frmvalidator.addValidation("treatUnits","alpha_s","Treatment unit can only have alphabetic characters and space");
  frmvalidator.addValidation("capacity","numeric","Capacity should be numeric");
  frmvalidator.addValidation("effluentGen","numeric","Effluent Generation should be numeric");

 </script>
 
</body>
