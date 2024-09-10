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
<g:if test="${hazardeousAnnualReturnDetailsInstance}">
<table id="" width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="91" align="left" valign="top" class="bgtop">
								<!-- code for spcbHeader  -->
								<g:include controller="userMaster" action="showSpcbHeader" />
							</td>
						</tr>
						<tr>
							<td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
								<!-- code for menuAdminHorizontal-->
								
								 <% 

                                 if((UserMaster)session.getAttribute("userMaster")){

                                       UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                       String userType = aa.accessLevel

                                       if(userType.equals("admin")) { %>   

                                             <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

                                       <% }else{ %>

                                             <g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 

                                       <%}} %>
								<% 
									if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									
									<% 
									if( (!(IndUser)session.getAttribute("indUser") ) && 
		      						(! (UserMaster)session.getAttribute("userMaster") )  )   {
		      						%> 
		      						<g:include controller="userMaster" action="showIndexMenuHorizontal" />
		      			 			<% 
		      			 			} 
		      					%>
							</td>
						</tr>
						<tr>
							<td align="left" valign="top">
								<table width="1003" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="224" align="left" valign="top" bgcolor="#DEEED0">
											<!-- code for menuAdmin-->
											<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
					                        <%    }
						                  		} %>
								         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
								               	<g:include controller="userMaster" action="showIndexMenu"/>            
								         	<% } %>
										</td>
										<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
										<td width="778" align="left" valign="top">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td height="1" valign="top"></td>
												</tr>
												<tr>
													<td>
														<img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" />
														<%	
															boolean decVar=true;
															String firstname;
															String lastName;
															String access;
															String indname;
															if((UserMaster)session.getAttribute("userMaster")){ 
            												UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  													UserProfile aa=(UserProfile)session.getAttribute("userprof");
            												firstname=aa.employeeFirstName;
           													lastName=aa.employeeLastName;
           													access=um.accessLevel;
       														}else if((IndUser)session.getAttribute("indUser")){
															IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
           													indname=ind.indName;
															}else{
															decVar=false;
															}
             												java.util.Date dateSCR = new java.util.Date();
             												int  year=dateSCR.getYear();
             												if (year < 1000)
                     										year+=1900;
               												int date=dateSCR.getDate();
                											int month=(dateSCR.getMonth()) + 1;
             											 %>
													</td>
												</tr>
												<tr>
													<td height="24" bgcolor="">
														<table width="100%">
														<g:def var="appForWhich1" value="HWMAnnualReturn"/><g:def var="applicationId" value="${hazardeousAnnualReturnDetailsInstance.id}"/>
														
															<% 
																if((UserMaster)session.getAttribute("userMaster"))
																{
															%>
															<tr bgcolor="#4C8BC0">
																<td class="top-lnks">
																	<table width="100%">
																		<tr height="10px">
																			<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
																			<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
																		</tr>
																	</table>
																<td>
															</tr><tr> <td height="0" align="left" valign="top">
															<%  def WasteManagementPendingDetailsobj=WasteManagementPendingDetails.findWhere(applicationId:(hazardeousAnnualReturnDetailsInstance.id).toString(),applicationFor:'HWMAnnualReturn')
													        System.out.println("here in.."+WasteManagementPendingDetailsobj)    
															if(WasteManagementPendingDetailsobj){%>
													            <a href="#" onclick="window.open('<g:createLink controller="hazardeousWasteAuthApp" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
													            <%}
															
																} 
																if(  (IndUser)session.getAttribute("indUser")  )
																{ 
															%> </td> </tr>
															<tr bgcolor="#4C8BC0">
																<td class="top-lnks">
																	<table width="100%">
																		<tr height="10px">
																			<td>Welcome <%=indname %></td>
																			<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
																		</tr>
																	</table>
																</td>
															</tr>
															<% }%>
														            
															<tr>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="0" align="left" valign="top">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															<tr>
																<!-- Div area for errors-->
																<td align="center" valign="top">
																	<div style="width: 500px; height: 20px; vertical-align: middle">
																		<span class="error"> 
																			<g:if test="${flash.message}">
																				<div class="message">${flash.message}</div>
																			</g:if>
																			<g:hasErrors bean="${indUserInstance}">
																				<div class="errors">
																					<g:renderErrors	bean="${indUserInstance}" as="list" />
																				</div>
																			</g:hasErrors>
																			<g:hasErrors bean="${indRegMasterInstance}">
																				<div class="errors">
																					<g:renderErrors bean="${indRegMasterInstance}" as="list" />
																				</div>
																			</g:hasErrors>
																		</span>
																	</div>
																</td>
															</tr>
															<tr><td height="0" align="right" valign="top">
															<g:def var="fId" value="${hazardeousAnnualReturnDetailsInstance.id}"/>
										                       <g:link action="dwonloadAnnualReaturn" controller="hazardeousWasteAuthApp" params="[returnId:fId]">Download HWM Annual Return Form </g:link>&nbsp;</td>
															</tr>
															<tr>
																<td height="0" align="left" valign="top">
																	<table width="100%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																			
																			<td align="left" valign="top">
																				<div style="padding: 0px 0px 0px 0px;">
																					<div style="" :1px solidgray; width:900px; margin-bottom: 1em; padding: 10px" >
																						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
																							<tr valign="middle">
																								<td width="100%" align="center">
																									<ol id="toc">
																										<li><a href="#country1"><span>General Details</span></a></li>
																									    <li><a href="#country2"><span>Part A</span></a></li>
																										<li><a href="#country3"><span>Part B </span></a></li>
																										<li><a href="#country4"><span>Part C </span></a></li>
																										<li><a href="#country5"><span>Part D </span></a></li>
																									</ol>
																								</td>
																								<td width="30%" align="right">
																								</td>
																							</tr>
																						</table>
																						
       <div id="country1" class="content">
			<div class="dialog">
				 <table>
						<tbody>
							   <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									 <tr>
									 	 <td  align="center" colspan="2" valign="middle" bgcolor="lightgrey" class="headngblue"><b>HWM Annual Return Details</b></td>
                                     </tr> 

									<tr>
							            <td width="60%" bgcolor="#A8DAF3" align="left" class="headngblue"> </td>
							            <td width="40%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
							              <table style="width:100%;">
								             <tr>
											     </tr>
											  </table>
							             </td>
						             </tr>
									
									
									
									
								
						             <tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Period : </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.financialYear}</font>
											
										  </td>
									</tr> 
								    
								   <tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <font size="2%" face="Verdana" color="#0099FF">${indRegInstance?.indName}</font>
											
										  </td>
									</tr> 
									
									<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Address: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										 <font size="2%" face="Verdana" color="#0099FF">${indRegInstance?.indAddress}</font>
										  </td>
									</tr> 
									
								<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">UID:</td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										<%
										def userId = IndUser.find("from IndUser as gm where  gm.industryRegMaster=? ",[indRegInstance])
								     	%>
										 <font size="2%" face="Verdana" color="#0099FF">${userId}</font>
										</td>	
									</tr>
									
								
								
								<tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Authorisation No<span style="color:red">*</span>:                                              
				               </td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.authorisationNo}</font>
								  </td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of issue<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								<font size="2%" face="Verdana" color="#0099FF"><g: formatDate format="dd/MM/yyyy" date="${hazardeousAnnualReturnDetailsInstance.dateOfIssue}" /></font>
								</td>
								</tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of Expiry<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								<font size="2%" face="Verdana" color="#0099FF"><g: formatDate format="dd/MM/yyyy" date="${hazardeousAnnualReturnDetailsInstance.dateOfExpiry}" /></font>
								
								</td>
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the authorised person
								<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.authorisedPersonName}</font>
									
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation of the authorised person
								<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.authorisedPersonDesignation}</font>
									</td>
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Correspondence Address<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								 <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.address}</font>
								 </td>
								 </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile No<span style="color:red">*</span>:</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.mobileNo}</font>
                                   </td>
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Land Line No (with area code):</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.landLineNo}</font>
                                  </td>
								  
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">fax number (with area code):</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.faxNumber}</font>
                                  </td>
								 
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">e-mail<span style="color:red">*</span>:</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <font size="2%" face="Verdana" color="#0099FF">${hazardeousAnnualReturnDetailsInstance.email}</font>
                                  </td>
								 
								  </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Production during the year (product wise), wherever applicable <span style="color:red">*</span>:</td>
								
							  
							    <td width="100%" class="headngblue" align="left">
						                 <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewAnnualProduction/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a> &nbsp;&nbsp; &nbsp;                                             
						      <input type="hidden" name="returnId" value="${hazardeousAnnualReturnDetailsInstance.id}">
						                  </td>
								</tr>
								
								
						          <table style="display:none; border:4px;"  id="selectTemp2">
											<tr>
											<td width="100%" class="headngblue" align="center">
											          <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/addAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a>                                                 
									                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a>                                               
									                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >Delete</a>
									        </td>
											</tr>
									  </table>
							      </td>
							  </tr>
					
					    </table>
			        </tbody>
	             </table>
             </div>
         </div>
		
          
        <div id="country2" class="content">
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
	            <tr>
	                <td bgcolor="#FFFFFF">
		                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousAnnualReturnDetailsInstance.id%>"/>
		                <input type="hidden" id='appId' name="appId" value="${appId}" />
		                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			                   <tr>
									<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by hazardous waste generators<span style="color:red"></span></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartADetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
								</tr> 
                 	  </table>
		           </td>
		         </tr>
		   </table>		
       </div>		
       
       <div id="country3" class="content">
       <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
       <tr>
           <td bgcolor="#FFFFFF">
               <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
               <input type="hidden" id='appId' name="appId" value="${appId}" />
               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
	                   <tr>
							<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by Treatment, storage and disposal facility operators<span style="color:red"></span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartBDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					  </tr> 
        	  </table>
          </td>
        </tr>
  </table>		
       </div>																				
          
          
        <div id="country4" class="content">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
        <tr>
            <td bgcolor="#FFFFFF">
                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
                <input type="hidden" id='appId' name="appId" value="${appId}" />
                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
	                   <tr>
							<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by recyclers or co-processors or other users<span style="color:red"></span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartCDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					   </tr> 

         	  </table>
           </td>
         </tr>
   </table>		
       </div>																				
          
          
           <div id="country5" class="content">
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
           <tr>
               <td bgcolor="#FFFFFF">
	                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
	                <input type="hidden" id='appId' name="appId" value="${appId}" />
	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		                   <tr>
								<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by recyclers or co-processors or other users<span style="color:red"></span></td>
								<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartDDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
								  </tr> 
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
									  
							   
						<hr>
				           <br/>	
							</td></tr>
							
							</table>	
							
							
							
							
						  	   						</div>
																							</td>
																						</tr>
																					
																						</table>
																			  
																				
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
									 		</td>
										</tr>
									 
									</table>
								</td>
							</tr>
						</table>
						</g:if>
						<g:if test="${bmwRenew}">
						
						<body>
						<table id="" width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
						<td align="left" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="91" align="left" valign="top" class="bgtop">
										<!-- code for spcbHeader  -->
										<g:include controller="userMaster" action="showSpcbHeader" />
									</td>
								</tr>
								<tr>
									<td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
										<!-- code for menuAdminHorizontal-->
										
										 <% 

		                                 if((UserMaster)session.getAttribute("userMaster")){

		                                       UserMaster aa = (UserMaster)session.getAttribute("userMaster");

		                                       String userType = aa.accessLevel

		                                       if(userType.equals("admin")) { %>   

		                                             <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

		                                       <% }else{ %>

		                                             <g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 

		                                       <%}} %>
										<% 
											if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
											controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
											
											<% 
											if( (!(IndUser)session.getAttribute("indUser") ) && 
				      						(! (UserMaster)session.getAttribute("userMaster") )  )   {
				      						%> 
				      						<g:include controller="userMaster" action="showIndexMenuHorizontal" />
				      			 			<% 
				      			 			} 
				      					%>
									</td>
								</tr>
								<tr>
									<td align="left" valign="top">
										<table width="1003" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="224" align="left" valign="top" bgcolor="#DEEED0">
													<!-- code for menuAdmin-->
													<%
										              if(  (IndUser)session.getAttribute("indUser")  ){ %>
										                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><%} %>
										          	<%if((UserMaster)session.getAttribute("userMaster")){
										                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
										                        String userType = aa.accessLevel
										                              if(userType.equals("admin")) { %>   
										                              <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
							                        <%    }else{ %>
							                              <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
							                        <%    }
								                  		} %>
										         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
										               	<g:include controller="userMaster" action="showIndexMenu"/>            
										         	<% } %>
												</td>
												<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
												<td width="778" align="left" valign="top">
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td height="1" valign="top"></td>
														</tr>
														<tr>
															<td>
																<img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" />
																<%	
																	boolean decVar=true;
																	String firstname;
																	String lastName;
																	String access;
																	String indname;
																	if((UserMaster)session.getAttribute("userMaster")){ 
		            												UserMaster um=(UserMaster)session.getAttribute("userMaster");
		    	  													UserProfile aa=(UserProfile)session.getAttribute("userprof");
		            												firstname=aa.employeeFirstName;
		           													lastName=aa.employeeLastName;
		           													access=um.accessLevel;
		       														}else if((IndUser)session.getAttribute("indUser")){
																	IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
		           													indname=ind.indName;
																	}else{
																	decVar=false;
																	}
		             												java.util.Date dateSCR = new java.util.Date();
		             												int  year=dateSCR.getYear();
		             												if (year < 1000)
		                     										year+=1900;
		               												int date=dateSCR.getDate();
		                											int month=(dateSCR.getMonth()) + 1;
		             											 %>
															</td>
														</tr>
														<tr>
															<td height="24" bgcolor="">
																<table width="100%">
																<g:def var="appForWhich1" value="BMWAnnualReturn"/><g:def var="applicationId" value="${bmwRenew.id}"/>
																
																	<% 
																		if((UserMaster)session.getAttribute("userMaster"))
																		{
																	%>
																	<tr bgcolor="#4C8BC0">
																		<td class="top-lnks">
																			<table width="100%">
																				<tr height="10px">
																					<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
																					<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
																				</tr>
																			</table>
																		<td>
																	</tr><tr> <td height="0" align="left" valign="top">
																	<%  def WasteManagementPendingDetailsobj=WasteManagementPendingDetails.findWhere(applicationId:(bmwRenew.id).toString(),applicationFor:'BMWAnnualReturn')
															        System.out.println("here in.."+WasteManagementPendingDetailsobj)    
																	if(WasteManagementPendingDetailsobj){%>
															            <a href="#" onclick="window.open('<g:createLink controller="hazardeousWasteAuthApp" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
															            <%}
																	
																		} 
																		if(  (IndUser)session.getAttribute("indUser")  )
																		{ 
																	%> </td> </tr>
																	<tr bgcolor="#4C8BC0">
																		<td class="top-lnks">
																			<table width="100%">
																				<tr height="10px">
																					<td>Welcome <%=indname %></td>
																					<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	<% }%>
																            
																	<tr>
																		<td>&nbsp;</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td height="0" align="left" valign="top">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<!-- Div area for errors-->
																		<td align="center" valign="top">
																			<div style="width: 500px; height: 20px; vertical-align: middle">
																				<span class="error"> 
																					<g:if test="${flash.message}">
																						<div class="message">${flash.message}</div>
																					</g:if>
																					<g:hasErrors bean="${indUserInstance}">
																						<div class="errors">
																							<g:renderErrors	bean="${indUserInstance}" as="list" />
																						</div>
																					</g:hasErrors>
																					<g:hasErrors bean="${indRegMasterInstance}">
																						<div class="errors">
																							<g:renderErrors bean="${indRegMasterInstance}" as="list" />
																						</div>
																					</g:hasErrors>
																				</span>
																			</div>
																		</td>
																	</tr>
						<tr>
				        <td height="0" align="right" valign="top">
				            <span class="btn btn-primary btn-sm">
				            <g:link action="downloadCompletedApplicationPdf" controller="bioMedicalWaste" params="[bmwRenewId:bmwRenewId]">Download bmw Annual Return Form </g:link>&nbsp;</td>
				            	</span>
				            </td>
				        </tr>
						   <tr>

						                                                <table width="710" align="left" valign="top"><div
						                                                        style="padding:0px 0px 0px 0px;">
						                                                        <td align="left" valign="top">
						        												<div style="padding: 0px 0px 0px 0px;">
						        													<div style="" :1px solidgray; width:900px; margin-bottom: 1em; padding: 10px" >
						        														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
						        															<tr valign="middle">
						        																<td width="100%" align="center">
						        											<ol id="toc">
						        												<li><a href="#country1"><span>General Details</span></a></li>
						        											    <li><a href="#country2"><span>Health Care Facilities Details</span></a></li>
						        												<li><a href="#country3"><span>Quantity of Waste Generated</span></a></li>
						        												<li><a href="#country4"><span>Storage,Treatment,Transportation,Processing and Disposal Facility Details</span></a></li>
						        												<li><a href="#country5"><span>BMW Management Committee</span></a></li>
						        												<li><a href="#country6"><span>Training Conducted</span></a></li>
						        												<li><a href="#country7"><span>Accident Occurred & Other Detail</span></a></li>
						        												</ol>
						        												</td>
						        												<td width="30%" align="right">
						        												</td>
						        											</tr>
						        										</table>

						                                                    <div id="formInsideApplyBmwRenew_gsp">

						                                                        <table width="100%" border="0" align="left" cellpadding="2"
						                                                               cellspacing="0">
						                                                            <tr valign="middle">
						                                                                <td width="100%" align="center">
						                                                                 
						                                                                </td>
						                                                                <td align="right" valign="middle"
						                                                                    class="headngblue"></td>
						                                                            </tr>
						                                                        </table>
						                                                    </div>

						                                                    <div id="country1" class="content">
						        											<div class="dialog">
						        												 <table>
						        														<tbody>
						        															   <table width="120%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						        																	 <tr>
						                                                                                <td  align="center" colspan="2" valign="middle" bgcolor="lightgrey" class="headngblue">Particulars of the Occupier</td>
						                                                                            </tr>

						                                                                            <tr>
						                                                                                <td width="60%" bgcolor="#A8DAF3" align="left"
						                                                                                    class="headngblue">Name of the authorized person
						                                                                                (occupier or operator of facility)
						                                                                                </td>
						                                                                                <td width="40%" bgcolor="#E8F6F9" align="left"
						                                                                                    class="headngblue"><%=industryRegMaster.occName%>
						                                                                                </td>
						                                                                            </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Name of the authorized person
						                                                                                    (occupier or operator of facility)
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">

						                                                                                        <span>
						                                                                                            <%=industryRegMaster.occName%>
						                                                                                        </span>

						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Name of HCF or CBMWTF
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=industryRegMaster.indName%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Address for Correspondence
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=industryRegMaster.occAddress%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Address of Facility
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=industryRegMaster.indAddress%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Tel. No.
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=industryRegMaster.occMobile%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Fax. No.
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <table>
						                                                                                            <tr>
						                                                                                                <td bgcolor="#E8F6F9"
									                                                                                        align="left"
										                                                                                        class="headngblue">
						                                                                                                    <span>
						                                                                                                        <%=industryRegMaster.occFaxCode%>
						                                                                                                    </span>
						                                                                                                </td>
						                                                                                                <td bgcolor="#E8F6F9"
									                                                                                        align="left"
										                                                                                        class="headngblue">
						                                                                                                    <span>
						                                                                                                        <%=industryRegMaster.occFaxNo%>
						                                                                                                    </span>
						                                                                                                </td>
						                                                                                            </tr>
						                                                                                        </table>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">E-mail ID
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=industryRegMaster.occEmail%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">URL of Website
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=bmwRenew.occUrlWebsite%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">GPS coordinates of HCF of
						                                                                                    CBMWTF
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <span>
						                                                                                            <%=bmwRenew.occGpsCoordinate%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Ownership of HCF of CBMWTF
						                                                                                    </td>
						                                                                                    <!-- have to implement select dropdown -->
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">

						                                                                                        <span>
						                                                                                            <%=bmwRenew.occOwnershipHcf%>
						                                                                                        </span>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td rowspan="2" width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Status of Authorization under the
						                                                                                    Bio-Medical Waste (Managementand Handing) Rules
						                                                                                    </td>

						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <table>
						                                                                                            <tr>
						                                                                                                <td  bgcolor="#E8F6F9"
						    		                                                                                        align="left"
						    			                                                                                        class="headngblue">
						                                                                                                    Authorization No. &nbsp;
						                                                                                                </td>
						                                                                                                <td  bgcolor="#E8F6F9"
						    		                                                                                        align="left"
						    			                                                                                        class="headngblue">
						                                                                                                    <span>
						                                                                                                        <%=bmwRenew.occAuthorizationNoBmw%>
						                                                                                                    </span>
						                                                                                                </td>
						                                                                                            </tr>
						                                                                                        </table>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>

						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <table>
						                                                                                            <tr>
						                                                                                                <td  bgcolor="#E8F6F9"
						    		                                                                                        align="left"
						    			                                                                                        class="headngblue">
						                                                                                                    Valid Upto &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                                                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                                                                                                </td>
						                                                                                                <td  bgcolor="#E8F6F9"
						    		                                                                                        align="left"
						    			                                                                                        class="headngblue">
						                                                                                                    <% java.text.DateFormat df = new SimpleDateFormat("dd/MM/yyyy")%>
						                                                                                                    <span>
						                                                                                                    <%if(bmwRenew.occValidUptoBmw){%>
						                                                                                                        <%=df.format(bmwRenew.occValidUptoBmw)%>
						                                                                                                    <%}%>
						                                                                                                    </span>
						                                                                                                </td>
						                                                                                            </tr>
						                                                                                        </table>
						                                                                                    </td>
						                                                                                </tr>

						                                                                                <tr>
						                                                                                    <td width="40%"
						                                                                                        bgcolor="#A8DAF3"
						                                                                                        align="left"
						                                                                                        class="headngblue">Status of Consents under Water
						                                                                                    Act and Air Act.
						                                                                                    </td>
						                                                                                    <td width="60%"
						                                                                                        bgcolor="#E8F6F9"
						                                                                                        align="left"
						                                                                                        class="headngblue">
						                                                                                        <table>
						                                                                                            <tr>
						                                                                                                <td bgcolor="#E8F6F9"
							                                                                                                class="headngblue">
						                                                                                                    Valid Upto &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                                                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						                                                                                                </td>
						                                                                                                <td bgcolor="#E8F6F9"
							                                                                                                class="headngblue">
						                                                                                                    <span>
						                                                                                                        <%if(bmwRenew.occValidUptoConsent){%>
						                                                                                                        <%=df.format(bmwRenew.occValidUptoConsent)%>
						                                                                                                        <%}%>
						                                                                                                    </span>
						                                                                                                    </td>
						                                                                 									 </table>
						                                                                 									 </div>
						                                                                 							    </td>
						                                                                 							</tr>
						                                                                 					    </table>
						                                                                 			        </tbody>
						                                                                 	             </table>
						                                                                              </div>
						                                                                          </div>
						                                                                 		

						                                                                          <div id="country2" class="content">
						                                                                          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
						                                                               	            <tr>
						                                                               	                <td bgcolor="#FFFFFF">
						                                                               	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						                                                    			                   <tr>
						                                                                                       <td width="60%" align="left"
						                                                                                           bgcolor="#A8DAF3"
						                                                                                           class="headngblue">HCF/CBMWTF Type <scope
						                                                                                               style="color:red">*</scope></td>
						                                                                                               <td width="40%" align="left"
						                                                                                                   bgcolor="#E8F6F9"
						                                                                                                   class="headngblue">
						                                                                                                   <input type="text"
						                                                                                                          id="hcfType1"
						                                                                                                          value="${bmwRenew.hcfHcfCbmwtfType}"
						                                                                                                          style="display: none"/>
						                                                                                                   <span>
						                                                                                                       <%=bmwRenew.hcfHcfCbmwtfType%>
						                                                                                                   </span>
						                                                                                                   <script>
						                                                                                                       selectHcfType();
						                                                                                                   </script>

						                                                                                               </td>
						                                                                                   </tr>
						                                                                                        <% if (bmwRenew.hcfHcfCbmwtfType == 'HCF') { %>
						                                                                                        <tr id="noOfBeds_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">No. of Beds(for Bedded Hospital)
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=
						                                                                                                            bmwRenew.hcfNoOfBeds%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr id="non_bedded_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">Non-Bedded Hospital<br/>(Clinic or Blood Bank or Clinical
						                                                                                            Laboratory or Research Institute or
						                                                                                            Veterinary Hospital or any other)
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=
						                                                                                                            bmwRenew.hcfNonBedded%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr id="licenceNo_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">License Number
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.hcfLicenceNo%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr id="licenceDateOfExpiry_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">License Date of
						                                                                                            Expiry
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%if(bmwRenew.hcfLicenceDateOfExpiry){%>
						                                                                                                    <%=df.format(bmwRenew.hcfLicenceDateOfExpiry)%>
						                                                                                                    <%}%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <% } %>
						                                                                                        <% if (bmwRenew.hcfHcfCbmwtfType == 'CBMWTF') { %>
						                                                                                        <tr id="noHealthcareCBMWTF_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">Number healthcare facilities
						                                                                                            covered by CBMWTF
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=
						                                                                                                            bmwRenew.hcfCbmwtfHealthcareFacilitiesNo%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr id="noBedsCBMWTF_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">No. of beds covered by CBMWTF
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=
						                                                                                                            bmwRenew.hcfCbmwtfbedsNo%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr id="installedTreatmentCBMWTF_id">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">Installed treatment and disposal
						                                                                                            capacity of CBMWTF
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=
						                                                                                                            bmwRenew.hcfCbmwtfInstalledTreatment%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr id="quantityBiomedicalCBMWTF">
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                align="left"
						                                                                                                class="headngblue">Quantity of biomedical waste
						                                                                                            treated or disposal by CBMWTF
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                align="left"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=
						                                                                                                            bmwRenew.hcfCbmwtfQuantityBmw%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <% } %>
						                                                                                        </td>
						                                                     									 </table>
						                                                     									 </div>
						                                                     							    </td>
						                                                     							</tr>
						                                                     					    </table>
						                                                     			        </tbody>
						                                                     	             </table>
						                                                                  </div>
						                                                              </div>


						                                                              <div id="country3" class="content">
						                                                              <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
						                                                   	            <tr>
						                                                   	                <td bgcolor="#FFFFFF">
						                                                   	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						                                        			                   <tr>
						                                                                                    <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Quantity of waste generated or

						                                                                                                disposed in Kg per annum (on

						                                                                                                monthly average basis)
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <table>
						                                                                                                    <tr>
						                                                                                                        <td class="headngblue">
						                                                                                                            Yellow Category
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.qwgYellowCategory%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td class="headngblue">
						                                                                                                            Red Category
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.qwgRedCategory%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td class="headngblue">
						                                                                                                            White
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.qwgWhiteCategory%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td class="headngblue">
						                                                                                                            Blue Category
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.qwgBlueCategory%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td class="headngblue">
						                                                                                                            General Solid Waste
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.qwgGeneralSolidWaste%>
						                                                                                                            </span>
						                                                                                                            </td>
						                                                                         									 </table>
						                                                                         									 </div>
						                                                                         							    </td>
						                                                                         							</tr>
						                                                                         					    </table>
						                                                                         			        </tbody>
						                                                                         	             </table>
						                                                                                      </div>
						                                                                                  </div>


						                                                                                  <div id="country4" class="content">
						                                                                                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
						                                                                       	            <tr>
						                                                                       	                <td bgcolor="#FFFFFF">
						                                                                       	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						                                                            			                   <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Details of the on-site storage
						                                                                                                facility
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">

						                                                                                                <table>
						                                                                                                    <tr>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            Size
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.sttpdOnSiteSize%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            Capacity
						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.sttpdOnSiteCapacity%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td colspan="2">
						                                                                                                            <table>
						                                                                                                                <tr>
						                                                                                                                    <td bgcolor="#E8F6F9"
						                		                                                                                                class="headngblue">
						                                                                                                                        Provision of on-site storage
						                                                                                                                    </td>
						                                                                                                                    <td bgcolor="#E8F6F9"
						                		                                                                                                class="headngblue">
						                                                                                                                        <span>
						                                                                                                                            <%=bmwRenew.sttpdOnSiteProvision%>
						                                                                                                                        </span>
						                                                                                                                    </td>
						                                                                                                                </tr>
						                                                                                                                <tr>
						                                                                                                                    <td bgcolor="#E8F6F9"
						                		                                                                                                class="headngblue">
						                                                                                                                        (cold storage or
						                                                                                                                        any other provision)
						                                                                                                                    </td>

						                                                                                                                </tr>

						                                                                                                            </table>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                </table>

						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Disposal Facilities
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <table width="90%">
						                                                                                                    <tr>
						                                                                                                        <td>

						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <a href="#"
						                                                                                                               class="addViewDelete"
						                                                                                                               onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popDisposalFacilitiesView/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
						                                                                                                                View
						                                                                                                            </a>
						                                                                                                        </td>
						                                                                                                        <td>

						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                </table>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Quantity of recyclable wastes sold
						                                                                                                to authorized recyclers after
						                                                                                                treatment in kg per annum.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <table>
						                                                                                                    <tr>
						                                                                                                        <span>
						                                                                                                            <%=bmwRenew.sttpdQuantityRecyclableWaste%>
						                                                                                                        </span>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        Red Category (like plastic, glass etc.)
						                                                                                                    </tr>
						                                                                                                </table>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                No of vehicles used for collection
						                                                                                                and transportation of biomedical
						                                                                                                waste.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.sttpdVehiclesUsed%>
						                                                                                                </span>
						                                                                                            </td>

						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Details of incineration ash and
						                                                                                                ETP sludge generated and
						                                                                                                disposal during the treatment of
						                                                                                                wastes in Kg per annum)
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <table width="90%">
						                                                                                                    <tr>
						                                                                                                        <td>

						                                                                                                        </td>
						                                                                                                        <td bgcolor="#E8F6F9"
						    		                                                                                                class="headngblue">
						                                                                                                            <a href="#"
						                                                                                                               class="addViewDelete"
						                                                                                                               onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popWasteTreatmentView/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
						                                                                                                                View
						                                                                                                            </a>
						                                                                                                        </td>
						                                                                                                        <td>

						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                </table>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Name of the Common Bio-
						                                                                                                Medical Waste Treatment
						                                                                                                Facility Operator through which
						                                                                                                wastes are disposed of
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.sttpdCommonBmwOperator%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                List of member HCF not handed
						                                                                                                over bio-medical waste.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <g:link controller="bioMedicalWaste"
						                                                                                                    action="downloadUploadedDoc"
						                                                                                                    params="[bmwRenewId: bmwRenewId]">
						                                                                                                    download
						                                                                                                </g:link>
						                                                                                                    </td>
						                                                                 									 </table>
						                                                                 									 </div>
						                                                                 							    </td>
						                                                                 							</tr>
						                                                                 					    </table>
						                                                                 			        </tbody>
						                                                                 	             </table>
						                                                                              </div>
						                                                                          </div>
						                                                                          
						                                                                          
						                                                                          <div id="country5" class="content">
						                                                                          <table width="55%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
						                                                               	            <tr>
						                                                               	                <td bgcolor="#FFFFFF">
						                                                               	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						                                                    			                   <tr>
						                                                                                       <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Do you have bio-medical waste
						                                                                                                management committee?
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <table>
						                                                                                                    <tr>
						                                                                                                        <td bgcolor="#E8F6F9"
						                                                                                                            class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.bmwtcIsHaveCommittee%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr
						                                                                                                        <%if(bmwRenew.bmwtcIsHaveCommittee.equals("yes")){%>
						                                                                                                            style="display: block;"
						                                                                                                        <%}else{%>
						                                                                                                            style="display: none;"
						                                                                                                        <%}%>
						                                                                                                    >
						                                                                                                        <td bgcolor="#E8F6F9"
						                                                                                                            class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.bmwtcCommitteeDetails%>
						                                                                                                            </span>
						                                                                                                            &nbsp;
						                                                                                                            <span bgcolor="#E8F6F9"
						                                                                                                                  class="headngblue">
						                                                                                                            <g:link controller="bioMedicalWaste"
						                                                                                                                    action="downloadUploadedDocManagementCommittee"
						                                                                                                                    params="[bmwRenewId: bmwRenewId]">
						                                                                                                                download
						                                                                                                            </g:link>
						                                                                                                            </span>
						                                                                                                            </td>
						                                                                         									 </table>
						                                                                         									 </div>
						                                                                         							    </td>
						                                                                         							</tr>
						                                                                         					    </table>
						                                                                         			        </tbody>
						                                                                         	             </table>
						                                                                                      </div>
						                                                                                  </div>

						                                                                                  <div id="country6" class="content">
						                                                                                  <table width="55%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
						                                                                       	            <tr>
						                                                                       	                <td bgcolor="#FFFFFF">
						                                                                       	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						                                                            			                   <tr>
						                                                                                           <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Number of training conducted
						                                                                                                on BMW Management.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.tcNoOfTrainingConducted%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Number of personnel trained
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.tcNoOfPersonnelTrained%>
						                                                                                                </span>
						                                                                                            </td>

						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Number of personnel trained at
						                                                                                                the time of induction
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.tcNoOfPersonnelTrainedInduction%>
						                                                                                                </span>
						                                                                                            </td>

						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Number of personnel not
						                                                                                                undergone any training so far.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.tcPersonnelNotUndergoneTraining%>
						                                                                                                </span>
						                                                                                            </td>

						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Whether standard manual for
						                                                                                                training is available ?
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.tcIsStandardManualAvailable%>
						                                                                                                </span>
						                                                                                            </td>

						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Any other information
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.tcAnyOtherInfo%>
						                                                                                                </span>
						                                                                                                </td>
						                                                             									 </table>
						                                                             									 </div>
						                                                             							    </td>
						                                                             							</tr>
						                                                             					    </table>
						                                                             			        
						                                                                          </div>
						                                                                      </div>

						                                                                      <div id="country7" class="content">
						                                                                      <table width="55%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
						                                                           	            <tr>
						                                                           	                <td bgcolor="#FFFFFF">
						                                                           	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						                                                			                   <tr>
						                                                                                    <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Number of Accidents occurred
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.aodNoOfAccidentOccured%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Number of the persons affected
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.aodNoOfPersonAffected%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Remedial Action taken (Please
						                                                                                                attach details if any)
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.aodRemedialActionTaken%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Any Fatality occurred, details.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.aodAnyFatalities%>
						                                                                                                </span>
						                                                                                                </td>
						                                                             									
						                                                                                                <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Are you meeting the standards of air
						                                                                                                Pollution from the incinerator?. How
						                                                                                                many times in last year could not met
						                                                                                                the standards?
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.odMeetingAirStandard%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Details of Continuous online emission
						                                                                                                monitoring systems installed
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.odContinuousOnlineEmission%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Liquid waste generated and treatment
						                                                                                                methods in place. How many times
						                                                                                                you have not met the standards in a
						                                                                                                year.
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.odLiquidWasteGenerated%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                It the disinfection method or
						                                                                                                sterilization meeting the log 4
						                                                                                                standards? How many times you have
						                                                                                                not met the standards in a year?
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <span>
						                                                                                                    <%=bmwRenew.odDisinfectionMethod%>
						                                                                                                </span>
						                                                                                            </td>
						                                                                                        </tr>
						                                                                                        <tr>
						                                                                                            <td width="40%"
						                                                                                                bgcolor="#A8DAF3"
						                                                                                                class="headngblue">
						                                                                                                Any other relevant information
						                                                                                            </td>
						                                                                                            <td width="60%"
						                                                                                                bgcolor="#E8F6F9"
						                                                                                                class="headngblue">
						                                                                                                <table>
						                                                                                                    <tr>
						                                                                                                        <td width="60%"
						                                                                                                            bgcolor="#E8F6F9"
						                                                                                                            class="headngblue">
						                                                                                                            <span>
						                                                                                                                <%=bmwRenew.odAnyOtherReleventInfo%>
						                                                                                                            </span>
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                    <tr>
						                                                                                                        <td bgcolor="#E8F6F9"
						                                                                                                            class="headngblue">
						                                                                                                            (Air Pollution Control Device attached with the
						                                                                                                            incinerator)
						                                                                                                        </td>
						                                                                                                    </tr>
						                                                                                                </table>
						                                                                                            </td>
						                                                                                        </tr>

						                                                                                    </table>
						                                                                                </div>

						                                                                                <%if(bmwRenew.bmwRenewStatus == "Inprogress"){%>
						                                                                                    <tr>

						                                                                                    <td align="center">
						                                                                                        <g:link controller="bmwRenew"
						                                                                                            action="editBmwRenew"
						                                                                                            params="[bmwRenewId: bmwRenewId]">
						                                                                                            <button type="button"
						                                                                                            class="actionbutton">Edit</button>
						                                                                                        </g:link>
						                                                                                    </td>
						                                                                                    </tr>
						                                                                                <%}%>
						                                                                                </td>
						                                           									 </table>
						                                           									 </div>
						                                           							    </td>
						                                           							</tr>
						                                           					    </table>
						                                           			        </tbody>
						                                           	             </table>
						                                                        </div>
						                                                    </div>
						                                                    <!-- ############################ ENDS ########################## -->

						                                                    <td width="35" align="left" valign="top">&nbsp;</td>
						                                                </tr>
						                                                </table></td>
						                                            </tr>

						                                            <table>

						                                            </div>
						                                            </table>

						                                        </td>
						                                        </tr>
						                                        </table>

						                                        </div>

						                                </table></td>
						                            </tr>

						                        </table></td>
						                    </tr>
						                </table></td>
						            </tr>
						            
						        </table></td>
						    </tr>
						</table>	
						
						
						
						</g:if>
						</body>

						</html>