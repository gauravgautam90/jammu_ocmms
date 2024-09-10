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
<g:form name="waterSourceUses" method="post" action="saveWaterWasteTreatment" >
<div align="center" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px">
<table class="tblbdr">
<tr bgcolor="#D1D1D1">
			<td   align="center" valign="middle"  class="headngblue">Waste Water Treatment System</td>
		</tr> 
				
			<tr><td>
				<table width="100%"  border="0" class="tblbdr">
					<tr bgcolor="#A8DAF3">
						<td width="150px" align="center" class="headngblue" ><div>Uses</div></td>
 						<td width="150px" align="center" class="headngblue" ><div>Effluent Generation(Cubic Meter/Day)</div></td>
 						<td width="150px" align="center" class="headngblue" ><div>Treatment Arrangement Status</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Treatment Type</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Name of Treatment Unit</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Capacity(KL)</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Investment in Treatment Unit(in Rs.)</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Monitoring Arrangement Details</div></td>
                         <td width="150px" align="center" class="headngblue" ><div>Quality Parameters</div></td>
                        <td colspan="2" width="150px" align="center" class="headngblue" ><div>Conc. of Pollutants<br>
                        (in mg/l except pH)</div></td>
                        </tr>
					<%
					def app = IndApplicationDetails.get((params.id).toInteger())
    				def sourceList = WaterSourceDetails.findAllByApplication(app)
    				def usesList1 = WaterUsesDetails.findAllWhere(application:app)
    				def a = usesList1.use
    				def usesList2 = a.unique() %>
					
									
					
					<tr>
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><g:select  class="txt4" from="${usesList2}" name="uses"></g:select>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="effluentGen" type="text" size="18" maxlength="50" class="txt4" />
							<br><span class="sidetxt">(enter effluent)</span>	
						</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<g:select class="txt4" optionKey="id"  from="${WaterTreatmentStatusMaster.list()}"  name="treatmentStatus" id="treatmentStatus"></g:select>
								<br><span class="sidetxt">(select status)</span>	
						</td>
						
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><input type="hidden" name="appId" value="<%=appDetId%>">
								<g:select class="txt4" optionKey="id"  from="${WaterWasteTreatmentCategoryMaster.list()}" name="waterWasteTeatCat" id="waterWasteTeatCat" ></g:select>
								<br><span class="sidetxt">(select type)</span></td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<input name="treatUnits" type="text" size="15" maxlength="100" class="txt4" />
							<br><span class="sidetxt">(enter unit name)</span>	
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="capacity" id="capacity" type="text" size="14"class="txt4" />
						<br><span class="sidetxt">(enter capacity)</span></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="investmentInTreatmentUnit" id="investmentInTreatmentUnit" type="text" size="14"class="txt4" />
						<br><span class="sidetxt">(enter amount)</span></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="monitoringDetails" type="text" size="14"class="txt4" />
						<br><span class="sidetxt">(enter details)</span></td>
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<g:select class="txt4" optionKey="id"  from="${WaterTreatedEffluentQualityMaster.list()}"  name="treatmentEffluent"></g:select>
								<br><span class="sidetxt">(select quality)</span>	
						</td>
						
					    <td bgcolor="#E8F6F9" align="center" class="headngblue">Untreated<input name="parametersQuantity" id="parametersQuantity" type="text" size="8"class="txt4" />
						<br><span class="sidetxt">(enter Untreated)</span></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">Treated<input name="parametersQuantityTreated" id="parametersQuantityTreated" type="text" size="8" class="txt4" />
						<br><span class="sidetxt">(enter Treated)</span></td>
					</tr>
						
					<tr>
					<td colspan="8" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
					</tr>
					<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
					
						
					
			  	</table>
						
				
				<tr align="left">
				<td align="left"><span class="txt" style="color: navy"><b>List of Waste Water Treatment added.</b></span>
				<!--  -->
				
				<div align="left" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 						<td width="150px" align="center" class="headngblue" ><div>Uses</div></td>
 						<td width="150px" align="center" class="headngblue" ><div>Effluent Generation(Cubic Meter/Day)</div></td>
 						<td width="150px" align="center" class="headngblue" ><div>Treatment Arrangement Status</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Treatment Type</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Name of Treatment Unit</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Capacity (KL)</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Investment in Treatment Unit(in Rs.)</div></td>
                        <td width="150px" align="center" class="headngblue" ><div>Monitoring Arrangement Details</div></td>
                       <td width="100px" align="center" class="headngblue" ><div>Quality Parameters</div></td>
                        <td colspan="2" width="200px" align="center" class="headngblue" ><div>Conc. of Pollutants<br>
                        (in mg/l except pH)</div>
                        <br>
                        Untreated &nbsp;| Treated
                        </td>
                      </tr>
 <g:each in="${waterWasteTreatmentDetList}" status="i" var="waterWasteTreatment">
  <tr align="center" >
  					<td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.uses}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.effluentGeneration}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.treatmentArrangementStatus}
                        </span></td>
  					<td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.category}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.treatmentUnits}
                        </span></td>
                        <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.capacity}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.investmentInTreatmentUnit}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.monitoringArrangementDetails}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.treatedEffluentQuality}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.parametersQuantity}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="center"><span class="txt style6">${waterWasteTreatment.parametersQuantityTreated}
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
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("uses","req","Please enter details :'Source of Water, Use and Consumption Details'");
  frmvalidator.addValidation("treatUnits","alpha_s","Treatment unit can only have alphabetic characters and space");
  frmvalidator.addValidation("capacity","decimal","Capacity should be numeric or decimal");
  frmvalidator.addValidation("effluentGen","decimal","Effluent Generation should be decimal or numeric");

 </script>
 
</body>
