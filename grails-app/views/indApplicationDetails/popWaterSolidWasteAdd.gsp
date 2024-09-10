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
<g:form name="waterSolidWasteGen" method="post" action="saveWaterSolidWasteGen" >
<div align="center" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px">
<table class="tblbdr">
<tr bgcolor="#D1D1D1">
			<td   align="center" valign="middle"  class="headngblue">Solid Waste Generation</td>
		</tr> 
				
			<tr><td>
				<table width="90%"  border="0" cellpadding="1" cellspacing="1" class="tblbdr">
					<tr bgcolor="#A8DAF3">
						<td width="20%" align="center" valign="middle"  class="headngblue">Description</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Quantity (in Metric Tonnes/Month)/Quality</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Method of Treatment/Collection</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Method of Disposal</td>
						<!-- <td width="20%" align="center" valign="middle"  class="headngblue">Action</td>  -->
					</tr>
					<tr>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input type="hidden" name="appId" value="<%=appDetId%>">
								<input name="description" type="text" size="15" maxlength="20" class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="quantity" type="text" size="15" maxlength="50" class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="methodCollection" type="text" size="18" maxlength="100" class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<g:select optionKey="id" from="${WaterDisposalModeMaster.list()}" name="methodDisposal" class="txt4" ></g:select>
						
						</td>
						<!--  <td  align="center" class="headngblue"><a href="javascript:createNewRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td> -->
						
					</tr>
					<tr>
					<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
					</tr>
				<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					
						
					
			  	</table>
						
				
				<tr align="left">
				<td align="left"><span class="txt" style="color: navy"><b>List of Solid Waste Generation added.</b></span>
				<!--  -->
				
				<div align="left" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table  class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="150px" class="headngblue" ><div  class="style3">Description</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Quantity(Metric Tonnes/Month)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Method of Treatment/Collection</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Method of Disposal</div></td>
                      </tr>
 
 <g:each in="${waterSolidWasteGenList}" status="i" var="waterSolidWasteGenInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.description}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.quantQual}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.meathodCollection}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.meathodDisposal}
                        </span></td>
                              
        </tr>		
      </g:each>		
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
				
				<!--  -->
				</td>
				</tr>
</table>
</div>
</g:form>
<!--<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSolidWasteGen");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("treatUnits","alpha_s","Treatment unit can only have alphabetic characters and space");
  frmvalidator.addValidation("capacity","decimal","Capacity should be numeric or decimal");

 </script>-->
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSolidWasteGen");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("description","req","please enter Description");
  frmvalidator.addValidation("quantity","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("methodCollection","req","please enter Method of Collection");
   frmvalidator.addValidation("methodDisposal","req","please enter Mode of Disposal");
 
  
 </script>   
 
</body>
