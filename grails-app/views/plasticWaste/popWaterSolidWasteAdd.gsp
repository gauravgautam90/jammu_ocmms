<head>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">


</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
<g:form name="waterSolidWasteGen" method="post" action="saveWaterSolidWaste" >
<div align="center" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px">
<table class="tblbdr" align="center">

<tr bgcolor="#D1D1D1">
			<td   align="center" valign="middle"  class="headngblue">Solid Waste Generation</td>
		</tr> 
			<tr><td colspan="5" align="center">
				<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span></td>
				</tr>	
			<tr><td>
				<table width="90%" align="center"  border="0" cellpadding="1" cellspacing="1" class="tblbdr">
					<tr bgcolor="#A8DAF3">
						<td width="20%" align="center" valign="middle"  class="headngblue">Total quantum of waste generated</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Unit Type</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Mode of storage within the plant</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Provision made for disposal of wastes</td>
					</tr>
					<tr>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="totalQuantum" type="text" size="18" maxlength="100" class="txt4" />
						</td>
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<g:select optionKey="id"  class="txt4" from="${UnitMaster.list()}" name="unit" ></g:select>
						<br><span class="sidetxt"></span>
						</td>
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input type="hidden" name="appDetId" value="<%=app%>">
								<input name="storageMode" type="text" size="15" maxlength="20" class="txt4" />
						</td>
						
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="disposalProvision" type="text" size="18" maxlength="100" class="txt4" />
						</td>
						
						
					</tr>
					<tr>
					<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
						
						
					
			  	</table>
						
				
				<tr align="left">
				<td align="center"><span class="txt" style="color: navy"><b>List of Solid Waste Generation added.</b></span>
				<!--  -->
				
				<div align="left" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td>
 					
 					<table  class="tblbdr" width="100%">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="20%" align="center" valign="middle"  class="headngblue">Total quantum of waste generated</td>
					<td width="20%" align="center" valign="middle"  class="headngblue">Unit Type</td>
					<td width="20%" align="center" valign="middle"  class="headngblue">Mode of storage within the plant</td>
					<td width="20%" align="center" valign="middle"  class="headngblue">Provision made for disposal of wastes</td>
                      </tr>
 
 <g:each in="${productDetails}" status="i" var="waterSolidWasteGenInst">
  <tr align="center" >
  						<td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.totalQuantum}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.unit}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.storageMode}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${waterSolidWasteGenInst.disposalProvision}
                        </span></td>
                              
        </tr>		
      </g:each>	
      
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
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
  frmvalidator.addValidation("capacity","numeric","Capacity should be numeric");

 </script>-->
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSolidWasteGen");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("storageMode","req","please enter Mode of storage within the plant");
  frmvalidator.addValidation("totalQuantum","req","please enter quantity");
  frmvalidator.addValidation("totalQuantum","dec","Quantity should be numeric or decimal");
  frmvalidator.addValidation("disposalProvision","req","please enter Provision made for disposal of wastes");
   frmvalidator.addValidation("methodDisposal","req","please enter Mode of Disposal");
 
  
 </script>   
 
</body>
