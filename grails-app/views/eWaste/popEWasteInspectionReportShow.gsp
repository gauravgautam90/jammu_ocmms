<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title> Report</title>
<title>Untitled Document</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

 

 

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<g:javascript library="prototype" />


 </head>
 
  <body>

  
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="350" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Inspection Report</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
							
							  <tr>
                        <!--      <td colspan="4" align="right"><a href="<%=request.getContextPath()%>/eWaste/viewInspectionPdf?appliLoc=<%=eWasteInstance?.id%>"><span class="headngblue">Print</span></a></td> -->
                             <td colspan="4" align="right"> <td width="432"><a href="javascript:window.print()">print</a></td>
							</tr>
      </table>
      
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 <input type="hidden" name="appId" value="<%=appId%>">	
 <tr><td>
 
 				<%
 					
 					
 					if(newInst) {%>
 					<table width="100%" border="0" >
 					
 					 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the unit</td>
                                <%System.out.println("Heyo....   " +newInst2.industryReg.district.districtName)%>
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
					
					  
  </table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	



</table>

</body>

</html>