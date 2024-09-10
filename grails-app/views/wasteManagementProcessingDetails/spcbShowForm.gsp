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
		
<g:if test="${hazardeousWasteAuthAppInstance}">
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
																										<li><a href="#country1"><span>General Details</span></a></li>
																										<li><a href="#country2"><span>Product Details</span></a></li>
																										<li><a href="#country3"><span>Hazardous Waste Details</span></a></li>
																										<li><a href="#country4"><span>Details Files</span></a></li>
																									</ol>
																								</td>
																								<td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewFormPdf?appliLoc=<%=hazardeousWasteAuthAppInstance?.id%>"><span class="headngblue">Print Preview</span></a></td>
																							</tr>
																						</table>
																						<div id="country1" class="content">
																							
																							<div class="dialog">
																								<table>
																									<tbody>
																										<table width="76%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																											
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Name of the Unit:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'indName')}
																												</td>
																		 									 </tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Address:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'indAddress')}
																												</td>
																		 								 	</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">City:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'indCity')}
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">District:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		        									${district}
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Tehsil:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		        									${tehsil}
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Pin:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																													${fieldValue(bean:indRegInstance,field:'indPin')}
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Location of Activity:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																													${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'location_Of_Activity')}
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization Required for: </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
																											  		<p>
																											  			<% int b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Collection'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkCollection" id="chkCollection" disabled="disabled" checked="checked"/>
																												  			Collection 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkCollection" id="chkCollection" disabled="disabled" />
																				  											Collection
																											  			</g:else>
																				        								 
																				        								<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Reception'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkReception" id="chkReception" disabled="disabled" checked="checked"/>
																												  			Reception 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkReception" id="chkReception" disabled="disabled" />
																															Reception
																											  			</g:else>
																				   										
																				   										<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Treatment'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkTreatment" id="chkTreatment" disabled="disabled" checked="checked"/>
																												  			Treatment 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkTreatment" id="chkTreatment" disabled="disabled" />
																				        									Treatment
																											  			</g:else> 
																				        								      
																				      								</p>
																			      									<p>
																			      										<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Transport'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkTransport" id="chkTransport" disabled="disabled" checked="checked"/>
																												  			Transport 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkTransport" id="chkTransport" disabled="disabled" />
																			    											Transport 
																											  			</g:else>
																			        									
																			        									<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Storage'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkStorage" id="chkStorage" disabled="disabled" checked="checked"/>
																												  			Storage 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkStorage" id="chkStorage" disabled="disabled" />
																															Storage 
																											  			</g:else>
																			    										
																			    										<% b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Disposal'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkDisposal" id="chkDisposal" disabled="disabled" checked="checked"/>
																												  			Disposal 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkDisposal" id="chkDisposal" disabled="disabled" /> 
																															Disposal 
																											  			</g:else>
																														
																				 									</p>
																		     									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Is Authorization Renew? </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'is_Renew')}
																												</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">In case of renewal , please mention authorization number and Date </td>
																											    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    <table width="293" border="1">
																												      <tr class="headngblue">
																												        <td>Number : </td>
																												        <td>Date(dd/mm/yyyy): </td>
																												      </tr>
																												      <g:if test="${hazardeousWasteAuthAppInstance?.auth_Renew_Date!= null}">
																												      	<% 
																								                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy ");
																								   
																								                        String strDate = sdfDestination.format(hazardeousWasteAuthAppInstance.auth_Renew_Date);
																							                          %>
																												      <tr class="headngblue">
																												        <td class="headngblue">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'auth_Renew_No')}</td>
																												        <td class="headngblue"><%=strDate%></td>
																												      </tr>
																												      </g:if>
																												    </table>      
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Whether the unit is generating hazardous waste as defined in the rules?</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		      										${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'hw_Defined')}
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Total Capital Investment on Project(in Rs. Lacs): </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'indCapInvt')}
																												</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Expexted Return(in Rs. Lacs): </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'expectedReturn')}
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Year of Commencement of Production:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																													${fieldValue(bean:indRegInstance,field:'dateOfComm')}
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Industry Working Shift: </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'shiftsIndustry')}
																		    									</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Status Of Application</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		      										${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'completionStatus')}
																												</td>
																		  									</tr>
																										</table>
																									</tbody>
																								</table>
																							</div>
																						</div>
																						<div id="country2" class="content">
																							
																							<div class="dialog">
																								<table width="79%" align="center" border="0" cellpadding="0" cellspacing="0">
																									<tr>
																										<td>
																											<table width="87%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																												<g:each in="${hwProductDetailsList}" status="i" var="indHWProductDetailsInstance">
																												<tr>
																				    								<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Product Details: </td>
																				    								<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																						    							<table width="293" border="1">
																						      								<tr class="headngblue">
																						        								<td>Product</td>
																						        								<td>Quantity(Tonnes/KL)</td>
																						        								<td>By Products </td>
																						        								<td>Quantity(Tonnes/KL)</td>
																						      								</tr>
																															<tr class="headngblue">
																				        										<td>
																				        											${fieldValue(bean:indHWProductDetailsInstance,field:'product_Name')}
																																</td>
																				        										<td>
																				        											${fieldValue(bean:indHWProductDetailsInstance,field:'product_Qty')}
																				        										</td>
																				        										<td>
																				        											${fieldValue(bean:indHWProductDetailsInstance,field:'by_Product_Name')}
																																</td>
																														        <td>
																														        	${fieldValue(bean:indHWProductDetailsInstance,field:'by_Product_Qty')}
																														        </td>
																				      										</tr>
																														</table>
																													</td>
																												</tr>
																												<tr>
																			    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Raw Material Details: </td>
																			    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																														<table  border="1">
																													      <tr class="headngblue">
																													        <td >Product</td>
																													        <td >Quantity(Tonnes/KL)</td>
																													      </tr>
																													      <tr class="headngblue">
																													        <td>
																													        	${fieldValue(bean:indHWProductDetailsInstance,field:'raw_Material_Name')}
																													        </td>
																													        <td>
																													        	${fieldValue(bean:indHWProductDetailsInstance,field:'raw_Material_Qty')}
																														    </td>
																													      </tr>
																				    									</table>
																													</td>
																												</tr>
																												</g:each>
																											</table>
																										</td>
																									</tr>
																								</table>
																							</div>
																						</div>
																						<div id="country3" class="content">
																							
																							<div class="dialog">
																								<table width="79%" align="center" border="0" cellpadding="0" cellspacing="0">
																									<tr>
																										<td>
																											<table width="87%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																											<g:each in="${hazardeousWasteDetailsList}" status="i" var="indHazardeousWasteDetailsInstance">
																												<tr>
															    													<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Hazardous waste generated:</td>
															    													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																    													<table width="293" border="1">
																														      <tr class="headngblue">
																														        <td >Type</td>
																														        <td >Quantity(Tonnes/KL)</td>
																														        <td >Source</td>
																														        <td >Waste Characteristics</td>
																														      </tr>
																														      <tr class="headngblue">
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Type')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Qty')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Source')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'waste_Characteristics')}</td>
																														      </tr>
																    													</table>
																  													</td>
															  													</tr>
																												<tr>
															    													<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Storage and Disposal Details: </td>
															    													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																    													<table width="293" border="1">
																														      <tr class="headngblue">
																														        <td >Mode of Storage </td>
																														        <td >Method of Disposal </td>
																														        <td >Capacity(Tonnes/KL)</td>
																														        <td >Quantity Disposed</td>
																														      </tr>
																														      <tr class="headngblue">
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'mode_Of_Storage')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'method_Of_Disposal')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'capacity_Of_Disposal')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'quantityDisposed')}</td>
																														      </tr>
																    													</table>
																													</td>
															  													</tr>
															  												</g:each>
																											</table>
																										</td>
																									</tr>
																								</table>
																							</div>
																						</div>
																						<div id="country4" class="content">
																							
																							<div class="dialog">
																								<table width="79%" align="center" border="0" cellpadding="0" cellspacing="0">
																									<tr>
																										<td>
																											<table width="87%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																												<g:if test="${wasteManagementFileList.size() > 0}">
																												<tr>
																			    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">Name Of File</td>
																			    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">File Description</td>
																			    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue"></td>
																			  									</tr>
																			  									<g:each in="${wasteManagementFileList}" status="i" var="wasteManagementFileInstance">
		                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
		                            																					<td class="headngblue">${fieldValue(bean:wasteManagementFileInstance, field:'name')}</td>
		                            																					<td class="headngblue">${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
		                            																					<td class="headngblue">
		                            																					<g:def var="fooVar" value="${wasteManagementFileInstance.id}"/><g:def var="docN" value="${wasteManagementFileInstance.applicationFor}"/> 
		                            																					<g:link action="viewFile11" params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >View</g:link></td>
		                        																					</tr>
	                    																						</g:each>
	                    																						</g:if>
	                    																						<g:else>
	                    																							<tr>
	                    																								<td width="25%" bgcolor="#A8DAF3" align="center" class="headngblue">No Files Added</td>
	                    																							</tr>
	                    																						</g:else>
																											</table>
																										</td>
																									</tr>
																								</table>
																							</div>
																						</div>
																				</div>
																			</td>
																		</tr>
																	</table>
</g:if>
<g:if test="${municipalSolidWasteInstance}">
<g:form name="myform" action="Edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="indRegId" value="${indRegInstanceId}" />
    <input type="hidden" name="muId" value="${municipalSolidWasteInstance?.id}" />
   		<table width="75%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td>
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Municiple Solid Waste</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				  
				   <td  align="right" class="headngblue"><!--<a href="#" onclick="window.open('../printMunicipalSolidWaste?id=<%=municipalSolidWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1');">--><a href="<%=request.getContextPath()%>/municipalSolidWaste/viewMswPdf?appliLoc=<%=municipalSolidWasteInstance?.id%>"><span class="headngblue">Print Preview</span></a></td>
				</tr>		
	    </table>
         
         <div class="content" id="country2" >
         
		  <table class="tblbdr" width="75%" align="center">
                        <tbody>
                        	
                       	  <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameNodal">Name of Nodal officer:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'nameNodal')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="desigNodal">Designation of Nodal officer:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'desigNodal')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authApp">Authorization Applied for:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'authApp')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authApp">Authorization Type :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'authorizationType')}
                                </td>
                            </tr> 
                            
                            <tr >
							    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Processing of waste </td>
							</tr>
                        	
					        <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="locationSite">Location of Site:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'locationSite')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="qtyProcessed">Quantity of waste to be processed per day: :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'qtyProcessed')} 
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'unitMasterobjqtyPro')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures to be taken for prevention and control of environmental pollution:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresPrevention')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures to be taken for safety of workers working in the plant:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresSafety')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="invenstment">Investme on Project (In Lakhs) : </label>
                                </td>
                                <td valign="top"  bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'invenstment')} 
                                </td>
                            </tr> 
                            
                             <tr class="prop">
                               <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="expectedReturn">Expected Return from Project (In Laks): </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'expectedReturn')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameWasteProcessingTech">Name of Waste Processing Technology: </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'nameWasteProcessingTech')}
                                </td>
                            </tr> 
                            
                           
							
							<g:each var="doc" in="${listDoc}">
							<tr>
								<td width="60%" align="left" valign="middle"
									bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
								<td width="40%" align="left" bgcolor="#E8F6F9"
									class="headngblue"><g:def var="fooVar"
									value="${doc.id}"/><g:def var="docN" value="${doc.applicationFor}"/> <g:link
									action="viewFile11"
									params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
							</tr>
							</g:each>
							
							<tr >
							    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Disposal of Water </td>
							</tr>
                            
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="numSites">Number of sites indentified:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'numSites')} 
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="qtyDisposed">Quantity of waste to be disposed per day:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'qtyDisposed')}
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'unitMasterobjqtyDis')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="natureWaste">Nature of waste:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'natureWaste')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="compWaste">Composition of waste:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'compWaste')}
                                </td>
                            </tr> 
                            
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures taken to check enviornmental pollution::</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresPollution')}
                                </td>
                            </tr> 
							
                            
                        </tbody>
                    </table>
                    
                   <table width="75%"  border="0" align="center" class="tblbdr"  >
               		<tbody>
		               <tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Application Status
		                	</td>
		                	<td valign="top" bgcolor="#E8F6F9" class="headngblue">
							${fieldValue(bean:municipalSolidWasteInstance,field:'completionStatus')}  
		                	</td>
						</tr>
					</tbody>	
               		</table>
                    
                    <table width="75%" align="center">
	                     <tbody>
						        <tr class="prop">
	                                <td valign="top" >
	                                <g:if test="${municipalSolidWasteInstance?.completionStatus=='Inprogress'}">
	                                 <div class="buttons">
						                <g:form>
						                    <input type="hidden" name="id" value="${municipalSolidWasteInstance?.id}" />
						                    <span class="button"><g:actionSubmit class="edit" value="Edit" class="actionbutton"/></span>
						                </g:form>
						            </div>
						            </g:if>

	                                </td>
	                            </tr> 
	                    </tbody>
	                    
                    </table>
                    
		   </div>
		
		   <div class="content" id="country1" >
		   <table width="75%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Municipal Authority/ Name of the agency appoined by the Municipal Authority  :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indName }
					</td>
				</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Corrospondence Address :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indAddress }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occCity } 
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occDistrict }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Tehsil :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occTehsil }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indPin }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Telephone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indPhoneNo }
					</td>
			</tr> 
		   
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstanceGet?.indFaxNo }
					</td>
			</tr> 
			
		 	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occMobile }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-mail Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstanceGet?.indEmail }
					</td>
			</tr> 
		   
		   </table>
		   
         
		   
		   </div>
		      </g:form>
</g:if>
<g:if test="${bioMedicalWasteInstance}">
<g:form name="myform"  method="post" >
    <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
    
    
   <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Bio-Medical</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				     <td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/bioMedicalWaste/viewBmwPdf?appliLoc=<%=bioMedicalWasteInstance?.id%>"><span class="headngblue">Print Preview</span></a></td>
				
				</tr>		
	    </table>
         
         <div class="content" id="country2" >
         
		  <table class="tblbdr">
                        <tbody>
                        
					        <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="nameOfApplicant">Name Of Applicant:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'nameOfApplicant')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="nameOfInstitution">Name Of Institution:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'nameOfInstitution')}
                                </td>
                            </tr> 	
							
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"> 
                                    <label for="activityAuthorizationSoughtFor">Activity Authorization Sought For:</label>
                                </td>
                               	<td width="100%" bgcolor="#E8F6F9"  class="headngblue">
							   		${fieldValue(bean:bioMedicalWasteInstance,field:'activityAuthorizationSoughtFor')}
							   	</td>

                           </tr> 
                           
                        
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authorizationType">Authorization Type:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                	${fieldValue(bean:bioMedicalWasteInstance,field:'authorizationType')}
                                </td>
                            </tr> 
						    <%
                            int z=0;
                            %>
                            <g:if test="${bioMedicalWasteInstance?.authorizationType =='RenewalApplication'}">
                            <%z=1;%>
                             </g:if>
						   <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">In case of renewal , please mention previous authorization number and Date </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
								    <table width="293" border="1">
								      <tr >
								        <td class="headngblue">Number : </td>
								        <td class="headngblue">Date(dd/mm/yyyy): </td>
								      </tr>
								      <tr >
								       <g:if test="${z==1}">
								        <td class="headngblue">${fieldValue(bean:bioMedicalWasteInstance, field:'previousAuthNo')}</td>
								        <td class="headngblue">${fieldValue(bean:bioMedicalWasteInstance, field:'previousAuthDate')}</td>
								      </g:if>
								      <g:else>
								        <td class="headngblue">NA</td>
								        <td class="headngblue">NA</td>
								      </g:else>
								      </tr>
								    </table>      
								</td>
			  				</tr>
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="addrPlaceDisposalOfWaste">Address of Place Disposal Of Waste :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'addrPlaceDisposalOfWaste')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="addrTreatmentFacility">Address of  Treatment Facility:</label>
                                </td>
                                <td valign="top"  bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'addrTreatmentFacility')}
                                </td>
                            </tr> 
                        
                         
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="descrip">Description:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'descrip')}
                                </td>
                            </tr> 
                            
                           <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="noOfBed">No.of beds:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'noOfBed')}
                                </td>
                            </tr> 
                           
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="noOfPatient">No.of Patients:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'noOfPatient')}
                                </td>
                            </tr> 
                              
                            
                            
                            
                            
                            
                            
                            <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Category of waste </td>
							    <td width="60%" bgcolor="#A8DAF3"  align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">
							    	Quantity of waste (per month)/Method of Treatment
							    </td>
							</tr>
							<g:if test="${bioWasteCategQuantList}"> 
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Human Anatomical Waste'}"> 								
							<tr>
							   <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 1 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
                            
                            <g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Animal Waste'}"> 								
                             <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    
								  			Category no. 2 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Microbiology & Biotechnology Waste'}"> 								
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 3 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Waste sharps'}"> 								
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 4 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Discarded Medicines and Cytotoxic drugs'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 5 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 6 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste disposal generated'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 7 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Liquid Waste'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 8 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Incineration Ash'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 9 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Chemical Waste'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category no. 10 (${bioWasteCategQuantinst?.category})
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity},${bioWasteCategQuantinst?.method}</td>
							</tr>
							</g:if>
							</g:each>
							
							</g:if>
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="modeTrans">Mode Trans:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'modeTrans')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="modeTreat">Mode Treat:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'modeTreat')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameAddressInstitution">Name Address Institution:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'nameAddressInstitution')}
                                </td>
                            </tr> 
                        
		              	 <tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Application Status
							&nbsp;
		                	</td>
		                	<td valign="top" bgcolor="#E8F6F9" class="headngblue">
							${fieldValue(bean:bioMedicalWasteInstance,field:'completionStatus')}  
							&nbsp;
		                	</td>
						</tr>
							
                        </tbody>
                    </table>
            
            <div class="buttons">
            <g:if test="${bioMedicalWasteInstance?.completionStatus=='Inprogress'}">
                    <input type="hidden" name="id" value="${bioMedicalWasteInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
             </g:if> 
            </div>
		   </div>
		
		   <div class="content" id="country1" >
		   <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indAddress}
					</td>
			</tr> 
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Telephone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indPhoneNo}
					</td>
			</tr> 
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indFaxNo}
					</td>
			</tr> 
		   
		   </table>
		   
         
		   
		   </div>
		   
		      
		
 </g:form>
</g:if>
</body>

</html>


