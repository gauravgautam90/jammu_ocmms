<head>
<%@ page import="java.text.*"%>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
</head>
<body>
<%
System.out.println("in this pop previous app------------------>>>>>>>>>>>>")%>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
							 <tr>
                         <td height="25" colspan= "3" align="center" class="headngblue" >Hospital Name : <font face="Verdana" color="green">${indName}</font></td>
                        </tr>
		<tr>
                              <td align="left" class="headngblue"> 
						<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:'BMW',appliId:params.id]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=900,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
 			
			<%
			
			if(viewCert){%>
						
						<g:link controller="bioMedicalWaste" action="viewBioCert2"  id="${bioMedicalWasteInstance}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}%>
								</td></tr>		
					
					<br><input name="grantApplicationInstance" type="hidden" value="${grantApplicationInstance}"/></td>
							</table>
							
							
							<g:if test="${bioMedicalWasteInstance}">
    
   <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Bio-Medical</span></a></li>
								<li><a href="#country3"><span>Fee</span></a></li>
						<li><a href="#country4"><span>Detail Files</span></a></li>
					</ol>
				  </td>
				   <g:if test="${bioMedicalWasteInstance?.completionStatus=='Completed'}">
				  <td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/bioMedicalWaste/viewBmwPdf?appliLoc=<%=bioMedicalWasteInstance?.id%>"><span class="headngblue">Print Preview</span></a></td>
				</g:if>
				</tr>	
	    </table>
         
       <div class="content" id="country2" >
         
		  <table class="tblbdr">
                        <tbody>
                        	<input type="hidden" name="nameAddressInstitution" id="nameAddressInstitution" value="">
				<input type="hidden" name="nameOfApplicant" id="nameOfApplicant" value="">
								<input type="hidden" name="nameOfInstitution" id="nameOfInstitution" 
					 
			
					      							
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"> 
                                    <label for="activityAuthorizationSoughtFor">Activity For Which Authorization Is Sought:</label>
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
                          
						 <g:if test="${bioMedicalWasteInstance?.authorizationType =='RenewalApplication'}">
						   <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">In case of renewal , please mention previous authorization number and Date </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
								    <table width="293" border="1">
								      <tr >
								        <td>Number : </td>
								        <td>Date(dd/mm/yyyy): </td>
								         <td>Expiry Date(dd/mm/yyyy): </td>
								      
								      </tr>
								      <tr >
								       
								        <%
			                            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
				                        String strDate = sdfDestination.format(bioMedicalWasteInstance.previousAuthDate);
				
				                        %>
								        <td>${fieldValue(bean:bioMedicalWasteInstance, field:'previousAuthNo')}</td>
								        <td class="headngblue"><%=strDate%></td>
								        <%
			                            SimpleDateFormat sdfDestination2 = new SimpleDateFormat("dd-MM-yyyy");
				                        String strDate2 = sdfDestination2.format(bioMedicalWasteInstance.prevExpDate);
				
				                        %>
								     <td class="headngblue"><%=strDate2%></td>
								      
								      </tr>
								      
								    </table>      
								</td>
			  				</tr>
                        </g:if>
                        
                        
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
                            <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Category of waste </td>
							    <td width="60%" bgcolor="#A8DAF3"  align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">
							    Quantity of waste & Unit (In KL/Month / Liter/Month)
							    </td>
							</tr>
							<g:if test="${bioWasteCategQuantList}"> 
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Human Anatomical Waste'}"> 								
							<tr>
							   <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 1 (Human Anatomical Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
                            
                            <g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Animal Waste'}"> 								
                             <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    
								  		Category 2 (Animal Waste) 
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Microbiology & Biotechnology Waste'}"> 								
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 3 (Microbiology & Biotechnology Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Waste sharps'}"> 								
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 4 (Waste sharps)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Discarded Medicines and Cytotoxic drugs'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 5 (Discarded Medicines and Cytotoxic drugs)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Soiled Waste'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  				Category 6 (Soiled Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste disposal generated'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  		Category 7 (Solid Waste disposal generated)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Liquid Waste'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 8 (Liquid Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Incineration Ash'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 9 (Incineration Ash) 
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Chemical Waste'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  		Category 10 (Chemical Waste) 
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
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
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Application Status</td>
		                	<td valign="top" bgcolor="#E8F6F9" class="headngblue">
							${fieldValue(bean:bioMedicalWasteInstance,field:'completionStatus')}  
		                	</td>
						</tr>
							
                        </tbody>
                    </table>
            
           
		   </div>
		   
		   <div class="content" id="country3">

												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
													style="border-collapse: collapse;">
													<tr>
														<td bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">

															<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Fee Details</td>
															</tr>
															<%
def cate = IndustryRegMaster.findById(indName.id.toLong())%>
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">Category:</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${cate.category}</td>
															</tr>
																<%if(cate.category.name.equals("HOSPITAL")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">No of Beds:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indName,
																field:'indCapInvt')}</td>
															</tr>
															
															<%}%>
															
															
															
																
																<%if(cate.category.name.equals("LAB")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indName,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indName,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("VETERINARY")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indName,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("BLOOD BANK")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indName,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															<%if(cate.category.name.equals("DENTAL CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>

															<%if(cate.category.name.equals("CBWTF")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															<%
															def consentFeeMasterInst = ConsentFeeMasterBMW.findByApplication(bioMedicalWasteInstance)
															%>
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Number of Years:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'noOfYears')}</td>
															</tr>
															<tr>
															
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Total Fee Applied </td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'calculatedFee')}<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
															</tr>
										
																						<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Bank Details</td>
															</tr>

														<%
									
								def feesOnline = FeeBankOtherDetailsBMW.find("from FeeBankOtherDetailsBMW fee where fee.application=?",[bioMedicalWasteInstance])
def feesBank = FeeBankDetailsBMW.find("from FeeBankDetailsBMW fee where fee.application=?",[bioMedicalWasteInstance])
									
									
									def feesBankOnline = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[bioMedicalWasteInstance])


%>
															

															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeOtherDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>
<%if(feesBank) {%>
														
														
															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																	<td width="10%" class="headngblue" align="center">Bank Draft Details</td>
																		
																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
														
														<%if(feesBankOnline) {%>
															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																	<td width="10%" class="headngblue" align="center">Online Payment Details</td>
																		
																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popChallan/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View Challan </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
										








														</table>


														</td>
													</tr>
												</table>



												<br />
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
															<%
															System.out.println("bioMedicalWasteInstance.id--------------------------------->"+bioMedicalWasteInstance.id);
															def docList = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='BMW' and abc.typeOfFile='BMW Documents' and abc.applicationId=? ",[bioMedicalWasteInstance.id])
															System.out.println("docList.id--------------------------------->"+docList);
															
															//def doc1 = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor='BioMediccalWaste' ")
			
															
															%>
														
															
															<g:each var="doc" in="${docList}">
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue"><g:def var="fooVar"
																	value="${bioMedicalWasteInstance.id}"/><g:def var="docN" value="${doc.description}"/> <g:link
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



		   <div class="content" id="country1" >
		   <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName}
					</td>
			</tr> 
			
			
		  
		
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.indAddress}
					</td>
			</tr> 
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.indPhoneNo}
					</td>
			</tr> 
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.indFaxNo}
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email id:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.indEmail}
					</td>
			</tr> 
		   
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Applicant :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occName}
					</td>
			</tr> 
			
			
			
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of Applicant :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occAddress}
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Code:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occPhoneCode}
					</td>
			</tr>
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occPhoneNo}
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax code:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occFaxCode}
					</td>
			</tr>
			
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occFaxNo}
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email id:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indName?.occEmail}
					</td>
			</tr>
		   
		   
		   	   
		   <%
	def cat = IndustryRegMaster.findById(indName.id.toLong())
	def district = cat.district
	//println(indRegInstance.indCapInvt)
	%>
	
	
			
			
	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${cat.category}
					</td>
			</tr>
	
	
	
	
	
	
		<%if(cat.category.name.equals("HOSPITAL")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">No of Beds:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:cat,
																field:'indCapInvt')}</td>
															</tr>
															
															<%}%>
															
															
															
																
																<%if(cat.category.name.equals("LAB")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:cat,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															
																<%if(cat.category.name.equals("CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:cat,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															
																<%if(cat.category.name.equals("VETERINARY")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:cat,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															
																<%if(cat.category.name.equals("BLOOD BANKk")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:cat,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
	
	<%if(cat.category.name.equals("DENTAL CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>

															<%if(cat.category.name.equals("CBWTF")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
		 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${district}
					</td>
			</tr>
	
	
		   </table>
		   
         
		   
		   </div></g:if>
							
							
</body>		
		  
		  
		  
		  
		  
          