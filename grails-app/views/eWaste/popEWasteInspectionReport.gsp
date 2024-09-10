
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>


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
function hidediv20() {

var selectmenu1=document.getElementById("courtCase")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp20').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp20').style.display = 'none';
   		 }
   }
}


function hidediv200() {

var selectmenu1=document.getElementById("contained")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp200').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp200').style.display = 'none';
   		 }
   }
}



function hidediv21() {

var selectmenu2=document.getElementById("complaint")
selectmenu2.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp21').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp21').style.display = 'none';
   		 }
   }
}
</g:javascript>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
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
<g:form name="waterSourceModeUses" method="post" action="saveEWasteInspectionReport" >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#3090C7">
					<td align="center" valign="middle"  class="headngblue"><font color="white">Inspection Details</font></td>
					</tr>
					<tr class="headngblue" bgcolor="#A8DAF3" >
										<!-- Div area for errors-->
										<td align="center" valign="top">
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
										</span>
										</td>
									</tr>
					
 					<tr><td>
 					
 					<table width="100%" border="0" >
						   
							 <input type="hidden"  name="appId" id = "appId" value="${appId}">
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="90" name="unitName" id = "unitName" value="${appId.industryReg.indName}">
							  </td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="90" name="unitAddress" id = "unitAddress" value="${appId.industryReg.indAddress}">
							  </td>
							</tr> 
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Date of Receipt of Application</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="dateOfReceipt"  dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>					 
							  
							
							</tr>
						
						
							
							
								 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment Cost of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="90" name="capitalInvestment" id = "capitalInvestment" >
							  </td>
							</tr> 
							
							  <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category of E-Waste to be processed (as per schedule-1)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							   <input type="text" size="90" name="eWasteCategory" id = "eWasteCategory" />
							
							  </td>
							</tr>
						
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">No. and Date of NOC (Consent to Establish)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="12" name="noOfNoc" id = "noOfNoc" ><span class="sidetxt">No.of NOC</span>
						 <calendar:datePicker name="dateOfNoc"  dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${new Date()}" class="txt4"/>	<span class="sidetxt">Date</span>				 
							  
							  </td>
							</tr> 
							
								<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Date of completion of the project</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="dateOfCompletion"  dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${appId.dateCreated}" class="txt4"/>					 
							  
							
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Date of inspection</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="dateOfInspection"  dateFormat="%d/%m/%Y" style="Size=12" defaultValue="${appId.dateCreated}" class="txt4"/>					 
							  
							
							</tr>
							
							
							
								<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Designation of the officers conducted inspection</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input type="text" size="50" name="nameDesigInspectionOff" id = "nameDesigInspectionOff" >
			
														       </td></tr> 
												 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the representative of the unit present at the time of inspection</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="repName" id = "repName" >
							  </td>
							</tr> 
									       
										 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">The Source of E-Waste to be produced</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="eWasteSource" id = "eWasteSource" >
							  </td>
							</tr> 				       
									
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td  width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity of E-Waste to be reprocessed with detail of reprocessing :<br><br> (i)Recycling <br><br>(ii)Dismantling</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><br>
							  <input type="text" size="40" name="recyclingQuantity" id = "recyclingQuantity" ><br>
							   <input type="text" size="40" name="dismantlingQty" id = "dismantlingQty" >
							  </td>
							</tr> 				
									
										 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of collection and storage facility for bag filter residue, floor cleaning dust, ETP sludge and other hazardous material.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="collectionDetail" id = "collectionDetail" >
							  </td>
							</tr> 		
										 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mode of Disposal of Hazardous Waste and No Recyclable / non recoverable components</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="modeOfDisposal" id = "modeOfDisposal" >
							  </td>
							</tr> 			
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of membership/agreement with TSDF operators for disposal of hazardous waste.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="tsdfAgreement" id = "tsdfAgreement" >
							  </td>
							</tr> 	
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Component wise detail of ETP with comments on adequacy.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="etpDetails" id = "etpDetails" >
							  </td>
							</tr> 	
								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Component wise detail of APCM with comments of adequacy as per CPCB guidelines.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="apcmDetails" id = "apcmDetails" >
							  </td>
							</tr> 	
										
								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status of Energy meter installed on PCD's:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="energyMeterStatus" id = "energyMeterStatus" >
							  </td>
							</tr> 		
										
								 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td  width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Final mode of disposal of effluent with quantity :<br><br> (i)Domestic <br><br>(ii)Trade</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><br>
							  <input type="text" size="40" name="domesticDisposalMode" id = "domesticDisposalMode" ><br>
							   <input type="text" size="40" name="tradeDisposalMode" id = "tradeDisposalMode" >
							  </td>
							</tr> 	   
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Height of Stacks/chimneys for all sources/APCM:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="stackHeight" id = "stackHeight" >
							  </td>
							</tr> 	
							
								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status of acoustic enclosures on DG sets with Stack Height:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="dgSetStatus" id = "dgSetStatus" >
							  </td>
							</tr> 	
							    
							    <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Type of operation of dismantling(Manual/ semi manual/ automatic/ mechanized):</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="operationType" id = "operationType" >
							  </td>
							</tr> 
							    
							      <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of operations involved in dismantling:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="dismantlingOperation" id = "dismantlingOperation" >
							  </td>
							</tr> 
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of segregation operations:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="segregationOperation" id = "segregationOperation" >
							  </td>
							</tr> 
							
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of gas recovery equipment and arrangement/ facilities for storage, reuse and disposal (for CFCs and HCFCs in case of refrigerator and air conditions):</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="gasRecovery" id = "gasRecovery" >
							  </td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of arrangement for handling/ storage disposal of hazardous electronic components such as Hg switches, PCBs etc.)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="disposalArrangement" id = "disposalArrangement" >
							  </td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of collection boxes with capacity for dismantled components(in case of manual dismantling.)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="collectionBoxes" id = "collectionBoxes" >
							  </td>
							</tr> 
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of equipments for use of workers to dismantle e-waste.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="equipments" id = "equipments" >
							  </td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of Hood, ducting, bag dust collector and chimney (in case of manual dismantling)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="50" name="extraDetails" id = "extraDetails" >
							  </td>
							</tr> 
							
														              	<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of bag house anf chimney on crusher (in case of mechanized dismantling)</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >	  <input type="text" size="50" name="bigHouse" id = "bigHouse" >
							  </td>
					 </tr> 
														       
				
							
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of storage facilities for dissembled spare parts with adequacy </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="spareStorage" id="spareStorage" type="text" size="15"	value="${fieldValue(bean:newInst,field:'spareStorage')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 
														       
														   <tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of containers for storage of batteries and capacitor containing PCBs or PCTs with adequacy</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="containers" type="text" size="15"	value="${fieldValue(bean:newInst,field:'containers')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr>     
			
						
				
							
											       
 <table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0" class="tblbdr" >
 			
 					<tr><td><table class="tblbdr" width="100%">
 				
					<tr >
					<td align="center" colspan=5 ><span class="txt" style="color: navy"><b>Click Add button to enter details</b></span></td>
					</tr>		
						
							
						 <tr >
						 
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
					</table></td></tr>
 					</table>
						
				
					</table>
					</td></tr></table>
					
					
					
					
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					
 					<%
 					if(newInst){%>
 					
 				
 					<tr bgcolor="#D1D1D1"><td width="100%" align="center" ><font color="red"><b> Details added</b></font></tr>
 					<%}%>
 					<tr><td>
 				<%
 					
 					
 					if(newInst) {%>
 					<table width="100%" border="0" >
 					
 					 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'unitName')}</td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'unitAddress')}</td>
							</tr> 
					 <%
 	
		
 	 String dateWithoutTime33 = new SimpleDateFormat("dd-MM-yyyy").format(newInst.receiptDate);
					
 	 	 String dateWithoutTime333 = new SimpleDateFormat("dd-MM-yyyy").format(newInst.dateOfCompletion);
			
 	  String dateWithoutTime5 = new SimpleDateFormat("dd-MM-yyyy").format(newInst.dateOfInspection);
			String dateWithoutTime56 = new SimpleDateFormat("dd-MM-yyyy").format(newInst.dateOfNoc);
		 %>	
						
						
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Date of Receipt of Application</td>
							
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><%=dateWithoutTime33%></td>
							
							</tr>
						
						
							
							
								 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment Cost of the unit</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'capitalInvestment')}</td>
							</tr> 
							
							  <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category of E-Waste to be processed (as per schedule-1)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'eWasteCategory')}</td>
							</tr>
						
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">No. and Date of NOC (Consent to Establish)</td>
							
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,field:'noOfNoc')},<%=dateWithoutTime56%></td>
							</tr> 
							
								<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Date of completion of the project</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><%=dateWithoutTime333%></td>
							
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Date of inspection</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><%=dateWithoutTime5%></td>
							
							</tr>
							
							
							
								<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Designation of the officers conducted inspection</td>
						  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'nameDesigInspectionOff')}</td>
				
				</tr> 
												 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the representative of the unit present at the time of inspection</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'repName')}</td>
							</tr> 
									       
										 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">The Source of E-Waste to be produced</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'eWasteSource')}</td>
							</tr> 				       
									
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td  width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity of E-Waste to be reprocessed with detail of reprocessing :<br><br> (i)Recycling <br><br>(ii)Dismantling</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'recyclingQuantity')}, ${fieldValue(bean:newInst,
																field:'dismantlingQty')}</td>
							</tr> 				
									
										 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of collection and storage facility for bag filter residue, floor cleaning dust, ETP sludge and other hazardous material.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'collectionDetail')}</td>
							</tr> 		
										 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mode of Disposal of Hazardous Waste and No Recyclable / non recoverable components</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'modeOfDisposal')}</td>
							</tr> 			
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of membership/agreement with TSDF operators for disposal of hazardous waste.</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'tsdfAgreement')}</td>
							</tr> 	
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Component wise detail of ETP with comments on adequacy.</td>
							    <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'etpDetails')}</td>
							</tr> 	
								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Component wise detail of APCM with comments of adequacy as per CPCB guidelines.</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'apcmDetails')}</td>
							</tr> 	
										
								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status of Energy meter installed on PCD's:</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'energyMeterStatus')}</td>
							</tr> 		
										
								 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td  width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Final mode of disposal of effluent with quantity :<br><br> (i)Domestic <br><br>(ii)Trade</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'tradeDisposalMode')}</td>
							</tr> 	   
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Height of Stacks/chimneys for all sources/APCM:</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'stackHeight')}</td>
							</tr> 	
							
								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status of acoustic enclosures on DG sets with Stack Height:</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'dgSetStatus')}</td>
							</tr> 	
							    
							    <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Type of operation of dismantling(Manual/ semi manual/ automatic/ mechanized):</td>
							    <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'operationType')}</td>
							</tr> 
							    
							      <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of operations involved in dismantling:</td>
							<td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'dismantlingOperation')}</td>
							</tr> 
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of segregation operations:</td>
							 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'segregationOperation')}</td>
							</tr> 
							
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of gas recovery equipment and arrangement/ facilities for storage, reuse and disposal (for CFCs and HCFCs in case of refrigerator and air conditions):</td>
							 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'gasRecovery')}</td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of arrangement for handling/ storage disposal of hazardous electronic components such as Hg switches, PCBs etc.)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'disposalArrangement')}</td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of collection boxes with capacity for dismantled components(in case of manual dismantling.)</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'collectionBoxes')}</td>
							</tr> 
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of equipments for use of workers to dismantle e-waste.</td>
							   <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
																field:'equipments')}</td>
							</tr> 
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of Hood, ducting, bag dust collector and chimney (in case of manual dismantling)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,field:'extraDetails')}</td>
							</tr> 
							
														              	<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of bag house anf chimney on crusher (in case of mechanized dismantling)</td>
				 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,field:'bigHouse')}</td>

					 </tr> 
														       
				
							
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of storage facilities for dissembled spare parts with adequacy </td>
									 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,field:'spareStorage')}</td>
</tr> 
														       
														   <tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of containers for storage of batteries and capacitor containing PCBs or PCTs with adequacy</td>
		 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,field:'containers')}</td>
</tr> 
 					
 					<%}%>
					</td>
					</tr>	
					
					  
  </table>

<!-- --------------------------- 

						</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("stack","req","Please enter Stack attached to plant");
   frmvalidator.addValidation("pollCntrlMeasure","req","Please enter Pollutin control Equipment");
  frmvalidator.addValidation("heightGrdLevel","req","Please enter Stack Height above Factory Room");
  frmvalidator.addValidation("heightGrdLevel","decimal","Stack height should be numeric or decimal");
  frmvalidator.addValidation("heightGrdLevel","maxlength=10","Stack height should be upto 10 digits");
  frmvalidator.addValidation("heightFacLevel","req","Please enter Stack Height above Ground Level");
  frmvalidator.addValidation("heightFacLevel","decimal","Stack height should be numeric or decimal");
    frmvalidator.addValidation("diameterTopLevel","decimal","Diameter at Top Level should be numeric or decimal");
    frmvalidator.addValidation("pollutantName","decimal","Diameter at Bottom Level should be numeric or decimal");
  
  frmvalidator.addValidation("heightFacLevel","maxlength=10","Stack height should be upto 10 digits");
  frmvalidator.addValidation("capacity","req","Please enter Capacity");
  frmvalidator.addValidation("capacity","decimal","Capacity should be numeric or decimal");
  frmvalidator.addValidation("capacity","maxlength=10","Capacity should be upto 10 digits");
  frmvalidator.addValidation("matOfCon","req","Please enter Material of Construction");
 </script>  
						
					-->	

</body>