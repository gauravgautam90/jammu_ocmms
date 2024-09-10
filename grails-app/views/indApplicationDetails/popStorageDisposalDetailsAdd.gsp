<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<g:form name="waterSourceUses" method="post" action="saveStorageDisposalDetails" >
<table>
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Storage/Disposal Details</td>
				</tr> 
				<tr>
                
              	<td  bgcolor="#A8DAF3"  align="center"  class="headngblue">Hazardous Waste Generated</td>
                
               	<td   align="left" class="txt4" colspan="4">
                  <g:select
					from="${hazarWasteGenDetailsList.categoryName}"
					name="hazardName" id="hazardName"
					
					class="txt4">
					</g:select>
				</td>
              	</tr>
              	 <tr>
                <td bgcolor="#A8DAF3" width="25%" align="center" class="headngblue" >Total Quantity(in TPA)</td>
				<td  align="left" colspan="4">
                
				<input type="text"  name="totalQuantity" id="totalQuantity" maxlength="250" class="txt4" />
                </td>
				</tr>
				<tr >
                <td  bgcolor="#A8DAF3" width="35%" align="center" class="headngblue">Nature of Hazardous Waste</td>
                <td   align="left" class="txt4" colspan="4">
                  <g:select
					from="${CharacteristicsOfHazardeousWaste.list()}"
					name="nature" id="nature" 
					class="txt4">
					</g:select>
				</td>
                </tr>
                
               
			  	  
			
		  	<tr>
                <td colspan="3"  bgcolor="lightgrey" align="center" class="headngblue">
                  Mode of Disposal (in TPA)
				</td>
				<td colspan="2" bgcolor="lightgrey" width="25%" align="center" class="headngblue" >Storage Details</td>
				
			</tr>	
			<tr>
				
                <td width="10%" align="center" class="headngblue"><input name="appId" type="hidden" value="<%=appDetId%>" />
               Quantity of Hazardous Waste<br> <input type="text"  name="quantityTSDF" id="quantityTSDF" maxlength="250" class="txt4" />
                <br>
                <span class="sidetxt">(shifted/to be shifted to common TSDF)</span>
                </td>
                
                <td width="30%"  align="center" class="headngblue">
               Quantity of Hazardous Waste<br>   <input type="text"  name="quantityRecycler" id="quantityRecycler" maxlength="250" class="txt4" />
                <br>
                <span class="sidetxt">(given/to be given to regd. Recycler)</span>
                </td>
                
               <td width="33%"  align="center" class="headngblue">
                Quantity of Hazardous Waste<br>  <input type="text"  name="quantityPremises" id="quantityPremises" maxlength="250" class="txt4" />
                <br>
                <span class="sidetxt">(being/to be managed in the premises)</span>
                </td>
                
                <td width="20%"  align="center" class="headngblue">
                Storage Capacity<br>
				<input type="text"  name="storageCapacity" id="storageCapacity" maxlength="250" class="txt4" />
                <br><span class="sidetxt">(in months.)</span>
                
                </td>
                <td width="20%"  align="center" class="headngblue">
                Size of Room/Shed<br>
				<input type="text"  name="roomSize" id="roomSize" maxlength="250" class="txt4" />
                <br><span class="sidetxt">(in mts.)</span>
                </td>
              </tr>
              
             
              
             <tr>
             	<td>
          
             	</td>
             </tr>
		
		  </table>
		 
</td>
</tr>
<tr><td align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
<tr><td>&nbsp;</td></tr>

<tr><td>


<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Details added.</b></span>
 				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				
 				<td colspan="2" width="20%" align="center" class="headngblue">Hazardous Waste Generated</td>
                <td width="10%" align="center" class="headngblue">Category</td>
                <td width="20%" align="center" class="headngblue">Nature of Hazardous Waste</td>
                <td width="10%" align="center" class="headngblue">Total Quantity<br>(in TPA)</td>
               
              	</tr>
              <%if(hazardousWasteStorDisDetailsList!=null) {%>
 <g:each in="${hazardousWasteStorDisDetailsList}" status="i" var="hazardousWasteStorDisDetailsList">
  	<tr align="center" >
  					<td colspan="2" ><span class="txt style6">${hazardousWasteStorDisDetailsList.hazardName}
                        </span></td>
                        <td ><span class="txt style6">${hazardousWasteStorDisDetailsList.categoryName}
                        </span></td>
                        <td><span class="txt style6">${hazardousWasteStorDisDetailsList.nature}
                        </span></td>
                        <td ><span class="txt style6">${hazardousWasteStorDisDetailsList.totalQuantity}
                        </span></td>
                        
    </tr>		
 </g:each>		
 					<%}%>
 					<tr>
                <td colspan="3"  bgcolor="lightgrey" align="center" class="headngblue">
                  Mode of Disposal
				</td>
				<td colspan="2" bgcolor="lightgrey" width="25%" align="center" class="headngblue" >Storage Details</td>
				
				</tr>
 				<tr bgcolor="#A8DAF3" class="headngblue">
 					<td width="20%" align="center" class="headngblue">Quantity of Hazardous Waste
 					<br>
                <span class="sidetxt">(shifted/to be shifted to common TSDF)</span>
                
 					</td>
                	
                	<td width="20%" align="center" class="headngblue">Quantity of Hazardous Waste
                	<br>
                <span class="sidetxt">(given/to be given to regd. Recycler)</span>
                
                	</td>
                	<td width="20%" align="center" class="headngblue">Quantity of Hazardous Waste
                	<br>
                <span class="sidetxt">(being/to be managed in the premises)</span>
                
                	</td>
                	<td width="20%"  align="center" class="headngblue">
                Storage Capacity
				<br><span class="sidetxt">(in months.)</span>
                
                </td>
                <td width="20%"  align="center" class="headngblue">
                Size of Room/Shed
				 <br><span class="sidetxt">(in mts.)</span>
                </td>
                </tr>	
             <g:each in="${hazardousWasteStorDisDetailsList}" status="i" var="hazardousWasteStorDisDetailsList">
    
                <tr align="center">
                
                <td><span class="txt style6">${hazardousWasteStorDisDetailsList.quantityTSDF}
                        </span></td>
                        <td><span class="txt style6">${hazardousWasteStorDisDetailsList.quantityRecycler}
                        </span></td>
                        <td><span class="txt style6">${hazardousWasteStorDisDetailsList.quantityPremises}
                        </span></td>
                        <td ><span class="txt style6">${hazardousWasteStorDisDetailsList.storageCapacity}
                        </span></td>
                        <td ><span class="txt style6">${hazardousWasteStorDisDetailsList.roomSize}
                        </span></td>
                </tr>
                
                </g:each>
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>

</td></tr>
</table>
 </g:form>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("quantity","req","Please enter Quantity");
  frmvalidator.addValidation("quantity","decimal","Quantity should be numeric or decimal");
  //frmvalidator.addValidation("modeUseWasteGeneration","numeric","Waste Water Generated should be numeric");
 </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>