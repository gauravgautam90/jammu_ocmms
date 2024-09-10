<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />

<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

</g:javascript>

<g:javascript>
function createMyRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'myPanel'},'tempWaterTreatmentAdd.gsp', { insertion: Insertion.Bottom });
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
<g:form name="waterSourceUses" method="post" action="saveWaterWasteGen" >
<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Waste Water Discharge</td>
		</tr> 
				
			<tr><td>
				<table class="tblbdr" width="100%"  border="0" >
					<tr bgcolor="#A8DAF3">
						<td width="20%" align="center" valign="middle"  class="headngblue">Type of Effluent</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Maximum Generation Quantity of Effluent(KL/D)</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Effulent to be Recycle(KL/D)</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Effulent to be Disposal/Discharge Quantity(KL/D)</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Mode of Disposal (with name)</td>
					</tr>
					<%
					def app = IndApplicationDetails.get((params.id).toInteger())
    				def sourceList = WaterSourceDetails.findAllByApplication(app)
    				def usesList1 = WaterUsesDetails.findAllWhere(application:app)
    				def a = usesList1.use
    				def usesList2 = a.unique() %>
					<tr>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><g:select  class="txt4" from="${usesList2}" name="typeOfEffluent"></g:select>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input type="hidden" name="appId" value="<%=appDetId%>"><input name="maxGeneration" type="text" size="20"class="txt4" />
						<br><span class="sidetxt">(enter qty)</span></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="effRecycle" type="text" size="20"class="txt4" />
						<br><span class="sidetxt">(enter qty)</span></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="effDischarge" type="text" size="20"class="txt4" />
						<br><span class="sidetxt">(enter qty)</span></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input type="text" class="txt4" maxlength=100 name="waterDisposalMode" />
						<br><span class="sidetxt">(e.g: strem,river,creek,estuary etc. max 100 char)</span></td>
						<!-- <td  align="center" class="headngblue"><a href="javascript:createMyRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td> -->
						
					</tr>
					
					
					<tr>
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr>
					
			  	</table>
						
				</td></tr>
				<tr>
				<td><span class="txt" style="color: navy"><b>List of Waste Water Discharge details	 added.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					    <td width="20%" align="center" valign="middle"  class="headngblue">Type of Effluent</td>
                        <td width="150px" class="headngblue" ><div  class="style3">Maximum Generation Quantity of Effluent(KL/D)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Effluent to be Recycle (KL/D)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Effluent to be Disposal/Discharge Quantity (KL/D)</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Mode of Disposal (with name)</div></td>
                      </tr>
 <g:each in="${wasteWaterGenDetInstList}" status="i" var="wasteWaterGenDetInst">
  <tr align="center" >
  					     <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.typeOfEffluent}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.maxGeneration}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.effRecycle}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.effDischarge}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${wasteWaterGenDetInst.disposalMode}
                        </span></td>
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
				</td>
				</tr>
				</table>
				</div>
				</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("maxGeneration","req","please enter Maximum Generation");
  frmvalidator.addValidation("waterDisposalMode","req","please enter Water Disposal mode");
  frmvalidator.addValidation("maxGeneration","decimal","Maximum Generation should be decimal or numeric");
  frmvalidator.addValidation("effRecycle","req","please enter Effluent Recycled");
  frmvalidator.addValidation("effRecycle","decimal","Maximum Generation number should be decimal or numeric");
  frmvalidator.addValidation("effDischarge","req","please enter Effluent Discharged ");
  frmvalidator.addValidation("effDischarge","decimal","Effluent Discharged should be decimal or numeric");
  
 </script>   
 
			
</body>