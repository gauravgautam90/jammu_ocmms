<%@ page import="java.text.SimpleDateFormat"%>
<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
</head>
<body>
		

<table width="100%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																			<td width="82" align="left" valign="top">
																				&nbsp;
																			</td>
																			<td align="left" valign="top">
																				<div style="padding: 0px 0px 0px 0px;">
																					<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
																						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
																							<tr valign="middle">
																								<td width="78%" align="center">
																								<ol id="toc">
																										<li><a href="#country1"><span>General </span></a></li>
																										<li><a href="#country7"><span>Other</span></a></li>
																										<li><a href="#country2"><span>Product</span></a></li>
																										
																										<li><a href="#country3"><span>Water Consumption</span></a></li>
																										<li><a href="#country6"><span>Air Pollution Control</span></a></li>
																										<li><a href="#country5"><span>Waste Management</span></a></li>
																										
																										<li><a href="#country4"><span>Documents</span></a></li>
																										
																									</ol>
																										
																								</td>
																								<td width="17%" align="left">
										                			
																<%
																
																if( eWasteInstance.completionStatus != "inProgress"){ %>
																
																
																
																<font size="1" face="Verdana">
			<a href="<%=request.getContextPath()%>/eWaste/viewEEWPdf?appliLoc=<%=eWasteInstance?.id%>"><span class="headngblue">Print Form</span></a>
																<%
																}%>
																		
															
															</td>
															
																							</tr>
																						</table>
																						<div id="country1" class="content">
													
																							<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  
			
			
			 <tr><td bgcolor="#FFFFFF">
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Industry Details </span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>  
			
		
																		
																											<tr>
																		    									<td  width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the Unit :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance, field:'indName')}</td>
				</td>
																		 									 </tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Address :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance, field:'indAddress')}</td>
				</td>
																		 									 </tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Name of the occupier :</td>
																		    									<td valign="top"  bgcolor="#E8F6F9"  class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'occName')}</td>
																		    								
																		    								
																		    								
																		    								
																		    								<input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=eWasteInstance%>"/>
						                                                                            <input type="hidden" id="indRegId" name="indRegId"  value="${indRegInstance?.id}"/>
			 	
																		    									
																		    									
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Designation of the occupier :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance, field:'occDesignation')}</td>
				</td>
																		 									 </tr>
																		 									 
																		 									 <tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Phone No. With Code :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance, field:'occPhoneCode')}-${fieldValue(bean:indRegInstance, field:'occPhoneNo')}</td>
				</td>
																		 									 </tr>
											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Fax No. With Code :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance, field:'occFaxCode')}-${fieldValue(bean:indRegInstance, field:'occFaxNo')}</td>
				</td>
																		 									 </tr>
																		 									 <%
																		 									 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   	                                                                                                         def dateOfComm = sdf.format(indRegInstance.indRegNumDate)
																		 									 %>
																		 									 <tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Date of commissioning of the unit :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${dateOfComm}</td>
				</td>
																		 									 </tr>
											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >No. of workers(including contract labour):</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance, field:'noOfEmp')}</td>
				</td>
																		 									 </tr>
																		 									  <%
																		 									 
   	                                                                                                         def waterConsFrom = sdf.format(eWasteInstance.waterConsFrom)
   	                                                                                                          def waterConsTo = sdf.format(eWasteInstance.waterConsTo)
   	                                                                                                           def airConsFrom = sdf.format(eWasteInstance.airConsFrom)
   	                                                                                                            def airConsTo = sdf.format(eWasteInstance.airConsTo)
   	                                                                                                             def authorizationFrom = sdf.format(eWasteInstance.authorizationFrom)
   	                                                                                                              def authorizationTo = sdf.format(eWasteInstance.authorizationTo)
																		 									 %>
																		 									 <tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Water Consent From :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${waterConsFrom}</td>
				</td>
																		 									 </tr>
											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Water Consent To :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${waterConsTo}</td>
				</td>
																		 									 </tr>
																		 									 
																		 									 <tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Air Consent From :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${airConsFrom}</td>
				</td>
																		 									 </tr>
											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Air Consent To :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${airConsTo}</td>
				</td>
																		 									 </tr>
																		 									 
																		 									 <tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Authorization From :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${authorizationFrom}</td>
				</td>
																		 									 </tr>
											
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Authorization To :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${authorizationTo}</td>
				</td>
																		 									 </tr>
																		 									 
																		 									
																										
																								</table>	  
		
					  
			</td></tr>
			</table>		  
					                  
                     

				
          
          </div>
          	<div id="country2" class="content">
																							
																							<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Product Details</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Production Details</td>
					<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
								<td align="center"  ><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductionDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
								</tr>	
				</td>
				</table>
							</tr>

<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Product Details</td>
					<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
								</tr>	
				</td>
				</table>
							</tr>
			
				

						<tr bgcolor="#E8F6F9">
			
							<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Raw material Details</td>
							<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
		
								<td align="center"  ><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRawMaterialsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" ><span style="color: black">View</span> </a></td>
							</tr>	
				</td>
				</table>
							</tr>
													</table>
													</td></tr>
			</table>		
		  
		  
		
          </div>
          
          <div id="country5" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Waste Generation/Disposal</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Treatment Storage and Disposal Facility Details :</td>
					
			<td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'disposal')}</td>									
																</td>
															</tr>	
<tr  bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste generation Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#"   onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteGenDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>


<tr  bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Disposal Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#"  onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteDisposalDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>
								
												
								
				




</table>
</td></tr>
</table>

           <br/> 

           <%//}else{ %>
           <div class="headngblue" align="center"></div>
           
           <%//}%>
  		            
          </div>
          
          
          <div id="country3" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Water Consumption/Discharge</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			<%
    
  
  
   	def abcDate = sdf.format(eWasteInstance.regDate)
  	
  
  
    %>			
								
								
									<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Water Cess paid Upto:</td>
					
				<td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">
				${abcDate}
																	
																</td>
															</tr>									
				
<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Water Consumption Details</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterConsumptionDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>




<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste Water Generation Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterGenerationDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>
</tr>



<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste Water Treatment Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterTreatmentDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td></tr>


<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste Water Discharge Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterDischargeDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td></tr>


</table>
</td></tr>
</table>

          
		</div>
		      
          </div>
          
          
          
          <div class="content" id="country4">
												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
													style="border-collapse: collapse;">
													<tr>
														<td bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">

															<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Documents Details</td>
															</tr>
															<g:def var="dList" value="${DocumentChecklistMaster.list()}" />
															
														
															<g:each var="doc" in="${listDoc}">
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">${doc.level}</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue"><g:def var="fooVar"
																	value="${eWasteInstance.id}"/><g:def var="docN" value="${doc.level}"/> <g:link
																	action="viewFile1"
																	params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
															</tr>
															</g:each>
															
														</table>


														</td>
													</tr>
												</table>

												<br />
												</div>
          
       <div id="country6" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Air Pollution Control</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			
			<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details for facilities provided for control of fugitive emission due to material handling, process, utilities etc :</td>
					
			<td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'fugEmission')}</td>									
																</td>
															</tr>	
															
<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Fuel Consumption Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopFuelconsumptionView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>
</tr>

<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Stack Emission Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopStackEmissionMonitoringView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td></tr>


<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Ambient Air Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopAmbientAirStandardView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>
</tr>




</table>
</td></tr>
</table>

           <br/> 

        
          
		         
          </div>
			
			
																
																	
				  <div id="country7" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Other Details</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			
			
			<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Details of e-waste proposed to be procured through sale, contract or import, as the case may be, for use as raw material :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopEWasteDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>
</tr>

															<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether the industry has provided adequate pollution control system/equipment to meet the standards of emission/effluent : </td>
				 <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'adequatePoll')}</td>
				</td>
				</tr>
				
				
				
																			
	
															<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether industry is in compliance with conditions laid down in the Authorization :  </td>
					
					 <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'indCompliance')}</td>
				</td>
				</tr>
				
				
				
											
	
															<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Occupational safety and health aspects Details : </td>
					<td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'healthAspects')}</td>
				</td>
					
				</td>
				</tr>
				
				
															<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Any other Information of relevance : </td>
					<td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'relInfo')}</td>
				</td>
				</td>
				</tr>
																				
																									
																									
													</table>
													</table>
																							
																							
																						
																							
																							
																							
																							
																							
																							</div>
																																		
																									   
		      
		


</body>

</html>


