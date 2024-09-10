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
<g:form name="waterSourceUses" method="post" action="deleteStorageDisposalDetails" >
<table align="center">

	<tr align="center">

		<td width="100%" align="center">

		<div>





		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0" id="countrytabs">
			<tr>
				<td width="11"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
					width="11" height="27" /></td>
				<td width="210" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">Storage/Disposal Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="220">&nbsp;</td>
			</tr>
		</table>
		<div >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3" >
               		<td width="20%" align="center" class="headngblue">Hazardous Waste Generated</td>
                <td width="10%" align="center" class="headngblue">Category</td>
                <td width="20%" align="center" class="headngblue">Nature of Hazardous Waste</td>
                <td width="10%" align="center" class="headngblue">Total Quantity<br>(in TPA)</td>
             
<td align="center" class="headngblue">Delete</td>
				
              	</tr>
<g:each in="${hazardousWasteStorDisDetailsList}" status="i" var="hazardousWasteStorDisDetailsList">
  	<tr align="center" >
  					<td ><span class="txt style6">${hazardousWasteStorDisDetailsList.hazardName}
                        </span></td>
                        <td ><span class="txt style6">${hazardousWasteStorDisDetailsList.categoryName}
                        </span></td>
                        <td><span class="txt style6">${hazardousWasteStorDisDetailsList.nature}
                        </span></td>
                        <td ><span class="txt style6">${hazardousWasteStorDisDetailsList.totalQuantity}
                        </span></td>
                           <td ><span class="txt style6"><input type="checkbox" name="delete" value="<%=hazardousWasteStorDisDetailsList.id%>" />
                        </span></td>    
    </tr>		
 </g:each>			
<tr>
                <td colspan="3"  bgcolor="lightgrey" align="center" class="headngblue">
                  Mode of Disposal (in TPA)
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
                	<tr bgcolor="#F4F7FB">
 					<td align="center" colspan="6"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
 					</tr>
 					</table>
 				</td></tr>
 				
  </table>
  
		</div>
		</div>
		</td>
	</tr>

	<tr>



	</tr>



</table>
<!-- - -->

  		</g:form>
</body>