<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="https://www.w3.org/1999/xhtml">
<head>
		<%
			response.setHeader("Cache-Control","no-cache"); 
			response.setHeader("Pragma","no-cache"); 
			response.setDateHeader ("Expires", -1);
		%>
		<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Application For Authorization</title>
		<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
		<link rel="stylesheet" type="text/css"href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

		<g:javascript library="prototype" />
		
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>



		
		<style type="text/css">
			<!--
			body {
					margin-left: 0px;
					margin-top: 0px;
					margin-right: 0px;
					margin-bottom: 0px;
				 }

			.style3 {
						color: #186DB5
					}

			.style5 {
						color: #0099FF
					}

			.style6 {
						color: #33FF66;
					}

			a:link {
						text-decoration: none;
						color: #1E6BBD;
				   }

			a:visited {
						text-decoration: none;
					  }

			a:hover {
						text-decoration: none;
					}

			a:active {
						text-decoration: none;
					 }

			.qwe123 {
						background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}');
						padding-left: 23px;
						padding-right: 20px;
						padding-top: 5px;
						padding-bottom: 5px;
					}

			.qwe123:hover {
							background-image: url('${createLinkTo(dir:' images2/ gif ',file:' gray_bg.gif ')}');
						  }

			.blue {
					background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_gray.gif ')}');
					padding-left: 30px;
					padding-right: 27px;
					padding-top: 5px;
					padding-bottom: 7px;
				  }

			.blue:hover {
							background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}');
						}
			-->
		</style>
		<script type="text/javascript">
 			function random_number(min,max) {
			return(Math.round((max-min) * Math.random() + min));
			} 
		</script>

		<script type="text/javascript" src="js/tabcontent.js"></script>
		<script type="text/javascript">
			anylinkmenu.init("menuanchorclass")
		</script>

		<script language="javascript" type="text/javascript">

			function popitup(url) {
				newwindow=window.open(url,'name','height=200px,width=500px');
				if (window.focus) {newwindow.focus()
								  }
				return false;
				}

		</script>
		
		
</head>
<body>
		<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
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
									if(  (IndUser)session.getAttribute("indUser")  ){ %> 
									<g:include	controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									<% 
 									if((UserMaster)session.getAttribute("userMaster")){
 									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType = aa.accessLevel;
									if(userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal" /> <% }else{ %> 
									<g:include	controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
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
								                        <g:include controller="userMaster" action="showSpcbIndustryMenu"/><%} %>
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
													<td height="24" bgcolor="#EEEEF3">
														<table width="100%">
															<% 
																if((UserMaster)session.getAttribute("userMaster"))
																{
															%>
															<tr>
																<td class="top-lnks">
																	<table width="100%">
																		<tr height="10px">
																			<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
																			<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
																		</tr>
																	</table>
																<td>
															</tr>
															<% } 
																if(  (IndUser)session.getAttribute("indUser")  )
																{ 
															%>
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
															<% } 
															%>
															<tr>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
												</tr>
												
												<tr>
													<td height="0" align="left" valign="top">
													<tr><td align="center"><g:if test="${flash.message}">
										                                    <div ><span style="color:red;">${flash.message}</span></div>
										                                    </g:if></td></tr>
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															
															<tr>
																<td height="0" align="left" valign="top">
																	<table width="100%" border="0" cellspacing="0" cellpadding="0">
																		
																        <tr>
																			<td>&nbsp;</td>
																		</tr>
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
																										<li><a href="#country1"><span>InProgress Application</span></a></li>
																										<li><a href="#country2"><span>Completed Application</span></a></li>
																									</ol>
																								</td>
																								<td width="30%" align="right">
																								</td>
																							</tr>
																						</table>
																						<div id="country1" class="content">
																							
																							<div class="dialog">
																								<table width="76%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																									<tr>
                        																				<td valign="top" bgcolor="#FFFFFF">
                        																					<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">			
																												<thead >
																												<tr height="20" bgcolor="#A8DAF3">
																			    									<th align="center" class="headngblue" >Application No </th>
																			    									<th align="center" class="headngblue" >Application For</th>
																			    									<th align="center" class="headngblue" >Authorization Required For</th>
																			    									<th align="center" class="headngblue" >Application Date</th>
																			  									</tr>
																			  									</thead>
																			  									<tbody>
																	  									
																			  									 <%if(hazardeousWasteAuthAppInstanceInprogressList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Hazardeous Waste Application List Is Empty</td></tr><%}else{ %>
																			  									 <tr ><td colspan="6" height="25" align="center" class="txt4" >Hazardeous Waste Applications</td></tr><%}%>
																			  									<g:each in="${hazardeousWasteAuthAppInstanceInprogressList}" status="i" var="hazardeousWasteAuthAppInstance">
	                        																						<% 
																								                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate = sdfDestination.format(hazardeousWasteAuthAppInstance.dateCreated );
																							                        %>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><g:link action="showNewFormat" id="${hazardeousWasteAuthAppInstance.id}">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}</g:link></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">Hazardeous Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'authorization_Required_For')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate%></font></td>
	                        																					</tr>
	                    																						</g:each>
	                    																						<%if(municipalSolidWasteInprogressList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Municiple Solid Waste Application List Is Empty</td></tr><%}else{ %>
	                    																						<tr ><td colspan="6" height="25" align="center" class="txt4">Municiple Solid Waste Applications</td></tr><%}%>
	                    																						<g:each in="${municipalSolidWasteInprogressList}" status="i" var="municipalSolidWasteInstance">
	                        																						<% 
																								                        SimpleDateFormat sdfDestination1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate1 = sdfDestination1.format(municipalSolidWasteInstance.dateCreated );
																							                        %>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><g:link controller="municipalSolidWaste" action="show" id="${municipalSolidWasteInstance.id}">${fieldValue(bean:municipalSolidWasteInstance, field:'id')}</g:link></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">Municipal Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:municipalSolidWasteInstance, field:'authApp')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate1%></font></td>
	                        																					</tr>
	                        																					</g:each>
	                        																					
	                        																	
	                        																					<%if(bioMedicalWasteInprogressList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Bio-Medical Waste Application List Is Empty</td></tr><%} else{%>
	                        																					<tr><td colspan="6" height="25" align="center" class="txt4">Bio-Medical Waste Applications</td></tr><%}%>
	                        																					<g:each in="${bioMedicalWasteInprogressList}" status="i" var="bioMedicalWasteInstance">
	                        																						<% 
																								                        SimpleDateFormat sdfDestination2 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate2 = sdfDestination2.format(bioMedicalWasteInstance.dateCreated );
																							                        %>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><g:link controller="bioMedicalWaste"  action="showNewFormat" id="${bioMedicalWasteInstance.id}">${fieldValue(bean:bioMedicalWasteInstance, field:'id')}</g:link></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">Bio-Medical Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:bioMedicalWasteInstance, field:'activityAuthorizationSoughtFor')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate2%></font></td>
	                        																					</tr>
	                    																						</g:each>
	                    																						</tbody>
																										</table>
																									</td>
																								  </tr>
																								</table>	
																							</div>
																							
																						</div>
																						<div id="country2" class="content">
																							<div class="dialog">
																								<table table width="76%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																									<tr>
																										<td valign="top" bgcolor="#FFFFFF">
																											<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
																												<thead >
																												<tr height="20" bgcolor="#A8DAF3">
																			    									<th align="center" class="headngblue" >Application No</th>
																			    									<th align="center" class="headngblue" >Application For</th>
																			    									<th align="center" class="headngblue" >Authorization Required For</th>
																			    									<th align="center" class="headngblue" >Application Date</th>
																			    									<th align="center" class="headngblue" >Application Status</th>
																			 <!--added by shashank -->   			<th align="center" class="headngblue" >Keeping With</th>
																			  									</tr>
																			  									</thead>
																			  									<tbody>
																			  							
																			  									<%if(hazardeousWasteAuthAppInstanceCompletedList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Hazardeous Waste Application List Is Empty</td></tr><%}else{ %>
																			  									<tr><td colspan="6" height="25" align="center" class="txt4">Hazardeous Waste Applications</td></tr>
																			  									<%}%>
																			  									<g:each in="${hazardeousWasteAuthAppInstanceCompletedList}" status="i" var="hazardeousWasteAuthAppInstance">
																			  									
																			  									
	                        																						<% 
	                        																						
	                        																						def pendingWith2=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wmpd where wmpd.indRegInstance=?",[hazardeousWasteAuthAppInstance.industryRegMasterObj])           																						    
																								                       											
	                        																						
																								                        SimpleDateFormat sdfDestination3 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate3 = sdfDestination3.format(hazardeousWasteAuthAppInstance.dateCreated );
																							                        %>
																							                        <% String colorCode;
																								                         if(hazardeousWasteAuthAppInstance.applicationStatus=="approved" || hazardeousWasteAuthAppInstance.applicationStatus=="rejected"){ 
																								                        	 colorCode="green";
																								                        }else if (hazardeousWasteAuthAppInstance.applicationStatus=="Inprogress" || hazardeousWasteAuthAppInstance.applicationStatus=="unattended"){
																								                        	 colorCode="brown";
																								                        }
																								                         
																								                         def pendingFlag='false';
																									                        def aa='false';
																									                        def hwmId=(hazardeousWasteAuthAppInstance.id).toString();
																									                        def appPending = WasteManagementPendingDetails.find("from WasteManagementPendingDetails afr where afr.applicationId=? and afr.completionStatus in ('Complete','Completed') order by afr.dateCreated asc",[hwmId])
																									 						def feeAmountId = FeeBankDetailsHWM.find("from FeeBankDetailsHWM abc where abc.application.id = ?",[hwmId.toLong()])
																									 						def bankAmountId = BankTransactionDetailsHWM.find("from BankTransactionDetailsHWM abc where abc.indApplication.id = ? and abc.transactionStatus = 'S' ",[hwmId.toLong()])
																									 						System.out.println("hwmId......"+hwmId);
																									 						System.out.println("bankAmountId...pk1...."+bankAmountId);
																									 						System.out.println("feeAmountId....pk2..."+feeAmountId);
																									                        
																									                        
																									                        if(appPending)
																									 						{
																									 							pendingFlag='true';
																									 						}  
																									                        
																									                        if(feeAmountId || bankAmountId)
																									 						{
																									                        	aa='true';
																									 						}  
																									                        
																									                        
																									                        System.out.println("pendingFlag---"+pendingFlag);
																									                        System.out.println("hwmId---"+hwmId);
																						                        	%>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><%if(hazardeousWasteAuthAppInstance.isNewApplication){%><g:link action="showNewFormat" id="${hazardeousWasteAuthAppInstance.id}">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}</g:link><%}else{%><g:link action="show" id="${hazardeousWasteAuthAppInstance.id}">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}</g:link><%}%></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode%>">Hazardeous Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode%>">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'authorization_Required_For')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode%>"><%=strDate3%></font></td>
	                            																					
	                            																					<!-- Code Added by Deepak for scr   -->
	                            																					<%
	                            																					def checkInshwm = WasteManagementPendingDetails.find("from WasteManagementPendingDetails afr where afr.applicationId=? order by afr.dateCreated asc",[hwmId])
	                            																						System.out.println("aa-222--"+aa); 
	                            																					%>
	                            																					<%	if(checkInshwm){%>
	                            																						<% if(checkInshwm.applicationStatus=='rejected' && checkInshwm.completionStatus=='In-Complete'){%>
	                            																							<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Scrutiny Incompleted</font>
	                            																							 <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewScrutiny?id=${hazardeousWasteAuthAppInstance.id}&applName=HWM', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>  </td>
	                            																							<%	}else if(checkInshwm.applicationStatus=='rejected' && checkInshwm.completionStatus!='In-Complete'){%>
	                            																							
	                            																							<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Rejected</font> <br>  <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewScrutiny?id=${hazardeousWasteAuthAppInstance.id}&applName=HWM', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>
	                            																						<%}else if(checkInshwm.applicationStatus=='pending' ){ %>
	                            																						<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Pending</font>
	                            																						<%}	else if(checkInshwm.applicationStatus=='approved' ){ %>
	                            																						<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Approved</font> 
	                            																					<%	}else if(checkInshwm.applicationStatus=='returned' ){ %>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Returned</font> <br>
	                            																					  <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewReturnReasonForHWM?id=${hazardeousWasteAuthAppInstance.id}&applName=HWM', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>
	                            																				<%	}} %> 
	                            																					
	                            																				<!--	<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode%>">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'applicationStatus')}</font>
	                            																					<%if(hazardeousWasteAuthAppInstance.applicationStatus=="returned"){%>
	                            																					<br>
	                            																					   <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewReturnReasonForHWM?id=${hazardeousWasteAuthAppInstance.id}&applName=HWM', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>
	   	                            																				<%}else if(hazardeousWasteAuthAppInstance.applicationStatus=="rejected"){%>
	   	                            																				<br>
	                            																					   <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewScrutiny?id=${hazardeousWasteAuthAppInstance.id}&applName=HWM', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>
	   	                            																				<%} %>
	   	                            																				
	                            																					</td>   -->
	                            																					
	                            																					
	                            																					
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode%>"><%if (pendingWith2){%>${(pendingWith2.role).roleName}<%}%></font></td>
	                        																					<%if(hazardeousWasteAuthAppInstance.clarification){ %>
                        																							<g:def var="appForWhich1" value="HWM"/><g:def var="applicationId" value="${hazardeousWasteAuthAppInstance.id}"/>
                        																							<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="submitClarification" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'clarification', 'WIDTH=700,HEIGHT=550,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td> 
                 																						       	<%} 
                 																						       	 	
                 																						        else{
                 																						       	
                 																						         def isTrue1 = WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails apd where apd.applicationId=?  ",[hazardeousWasteAuthAppInstance.id.toString()])
                                               	                                                                                    
                                                                                                                  if(isTrue1.clarification.contains(true)){
                                                                                                                        %>
                       
                                                                                                                  <!-- <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewSubmittedClarificationForHWM/${hazardeousWasteAuthAppInstance.id}', 'Clarification', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'ClarificationReply.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION" title="Clarification Reply"></img></a></td>       -->                 		
                                                                                                                             		
                        
                                                                                                               <%
                                                                                                                 }}%>
                                                                                                                 <% 	System.out.println("pendingFlag-222--"+pendingFlag); 
                                                                                                                 		System.out.println("aa-222--"+aa); 
                                                                                                                 %>
                                                                                                                <%if(pendingFlag=="true" && aa=="false")
                                                                                                           	    {%>
                                                                                                           	    	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/${hazardeousWasteAuthAppInstance.id}', 'payment', 'WIDTH=800,HEIGHT=650,scrollbars=1');"><font face="Verdana" color="blue">Make Payment</font></a></td> 
                                                                                                           	 <% }%>
                 					
	                        																					</tr>
	                    																						</g:each>
	                    																						<%if(municipalSolidWasteCompletedList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Municiple Solid Waste Application List Is Empty</td></tr><%}else{ %>
	                    																						<tr><td colspan="6" height="25" align="center" class="txt4">Municiple Solid Waste Applications</td></tr><%}%>
	                    																						<g:each in="${municipalSolidWasteCompletedList}" status="i" var="municipalSolidWasteInstance">
	                        																						<% 
	                        																						    def pendingWith1=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wmpd where wmpd.applicationId=?",[(municipalSolidWasteInstance.id).toString()])
																								                        SimpleDateFormat sdfDestination4 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate4 = sdfDestination4.format(municipalSolidWasteInstance.dateCreated );
																							                        %>
																							                        <% String colorCode1;
																								                         if(municipalSolidWasteInstance.applicationStatus=="approved" || municipalSolidWasteInstance.applicationStatus=="rejected"){ 
																								                        	 colorCode1="green";
																								                        }else if (municipalSolidWasteInstance.applicationStatus=="Inprogress" || municipalSolidWasteInstance.applicationStatus=="unattended"){
																								                        	 colorCode1="brown";
																								                        }
																						                        	%>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																					<td align="center" height="25" class="txt4"  ><u><g:link controller="municipalSolidWaste" action="show" id="${municipalSolidWasteInstance.id}">${fieldValue(bean:municipalSolidWasteInstance, field:'id')}</g:link></u></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>">Municipal Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>">${fieldValue(bean:municipalSolidWasteInstance, field:'authApp')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>"><%=strDate4%></font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>">${fieldValue(bean:municipalSolidWasteInstance, field:'applicationStatus')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode1%>"><%if (pendingWith1){%>${(pendingWith1.role).roleName}<%}%></font></td>
	                        																					<%if(municipalSolidWasteInstance.clarification){ %>
                        																							<g:def var="appForWhich1" value="MSW"/><g:def var="applicationId" value="${municipalSolidWasteInstance.id}"/>
                        																							<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="submitClarification" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td> 
                 																						       	<%} 
                 																						       	
                 																						       	else{
                 																						       	
                 																						         def isTrue1 = WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails apd where apd.applicationId=?  ",[municipalSolidWasteInstance.id.toString()])
                                               	                                                                                    
                                                                                                                  if(isTrue1.clarification.contains(true)){
                                                                                                                        %>
                       
                                                                                                                   <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewSubmittedClarificationForMSW/${municipalSolidWasteInstance.id}', 'Clarification', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'ClarificationReply.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION" title="Clarification Reply"></img></a></td>                        		
                                                                                                                             		
                        
                                                                                                               <%
                                                                                                                 }}%>
                                                                                                               
                 																						       	
	                        																					</tr>
	                    																						</g:each>
	                    																						
	                    																
	                    																						<%if(bioMedicalWasteCompletedList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">Bio-Medical Waste Application List Is Empty</td></tr><%} else{ %>
	                    																						<tr><td colspan="6" height="25" align="center" class="txt4">Bio-Medical Waste Applications</td></tr><%}%>
	                    																						<g:each in="${bioMedicalWasteCompletedList}" status="i" var="bioMedicalWasteInstance">
	                        																						<% 
	                        																						    
	                        																						    def pendingWith=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wmpd where wmpd.indRegInstance=?",[bioMedicalWasteInstance.industryRegMasterObj])
	                        																						    
																								                        SimpleDateFormat sdfDestination5 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
																								   
																								                        String strDate5 = sdfDestination5.format(bioMedicalWasteInstance.dateCreated );
																								                        System.out.println("bioMedicalWasteInstance---"+bioMedicalWasteInstance)
																								                        
																								                        def pendingFlagbmw='false';
																									                        def aa1='false';
																									                        def bmwId=(bioMedicalWasteInstance.id).toString();
																									                        def appPendingBmw = WasteManagementPendingDetails.find("from WasteManagementPendingDetails afr where afr.applicationId=? and afr.completionStatus in ('Complete','Completed') order by afr.dateCreated asc",[bmwId])
																									 						def feeAmountId1Bmw = FeeBankDetailsBMW.find("from FeeBankDetailsBMW abc where abc.application.id = ?",[bmwId.toLong()])
																									 						def bankAmountIdBmw = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW abc where abc.bioApplication.id = ? and abc.transactionStatus = 'S' ",[bmwId.toLong()])
																									 						System.out.println("bmwId......"+bmwId);
																									 						System.out.println("feeAmountId1Bmw...pk1...."+feeAmountId1Bmw);
																									 						System.out.println("bankAmountIdBmw....pk2..."+bankAmountIdBmw);
																									                        
																									                        
																									                        if(appPendingBmw)
																									 						{
																									                        	pendingFlagbmw='true';
																									 						}  
																									                        
																									                        if(feeAmountId1Bmw || bankAmountIdBmw)
																									 						{
																									                        	aa1='true';
																									 						}  
																									                        
																									                        
																									                      
																								                        
																							                        %>
																							                        <% String colorCode2;
																								                         if(bioMedicalWasteInstance.applicationStatus=="approved" || bioMedicalWasteInstance.applicationStatus=="rejected"){ 
																								                        	 colorCode2="green";
																								                        }else if (bioMedicalWasteInstance.applicationStatus=="Inprogress" || bioMedicalWasteInstance.applicationStatus=="unattended"){
																								                        	 colorCode2="brown";
																								                        }
																						                        	%>
	                        																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                            																			<!--		<td align="center" height="25" class="txt4"  ><u><g:link controller="bioMedicalWaste" action="show" id="${bioMedicalWasteInstance.id}">${fieldValue(bean:bioMedicalWasteInstance, field:'id')}</g:link></u></td>
	                            																				-->
	                            																				<td align="center" height="25" class="txt4"  >
	                            																				<u><%if(bioMedicalWasteInstance.isNewApplication){%>
	                            																				<g:link controller="bioMedicalWaste" action="showNewFormat" id="${bioMedicalWasteInstance.id}">${fieldValue(bean:bioMedicalWasteInstance, field:'id')}</g:link>
	                            																				<%}else{%><g:link controller="bioMedicalWaste" action="show" id="${bioMedicalWasteInstance.id}">${fieldValue(bean:bioMedicalWasteInstance, field:'id')}</g:link>
	                            																				<%}%></u></td>
	                            																				<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Bio-Medical Waste</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">${fieldValue(bean:bioMedicalWasteInstance, field:'activityAuthorizationSoughtFor')}</font></td>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>"><%=strDate5%></font></td>
	                            																					<%  System.out.println("bioMedicalWasteInstance.applicationStatusonGSP-------"+bioMedicalWasteInstance.applicationStatus)
	                            																					       
	                            																					System.out.println("bmwId--GSP-------"+bmwId)
	                            																					%>
	                            																					<!-- Code Added by Deepak for scr   -->
	                            																					<%
	                            																					def checkIns = WasteManagementPendingDetails.find("from WasteManagementPendingDetails afr where afr.applicationId=? order by afr.dateCreated asc",[bmwId])
	                            																						%>
	                            																					<%	if(checkIns){%>
	                            																						<% if(checkIns.applicationStatus=='rejected' && checkIns.completionStatus=='In-Complete'){%>
	                            																							<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Scrutiny Incompleted</font>
	                            																							 <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewScrutiny?id=${bioMedicalWasteInstance.id}&applName=BMW', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>  </td>
	                            																							<%	}else if(checkIns.applicationStatus=='rejected' && checkIns.completionStatus!='In-Complete'){%>
	                            																							
	                            																							<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Rejected</font>
	                            																						<%}else if(checkIns.applicationStatus=='pending' ){ %>
	                            																						<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Pending</font>
	                            																						<%}	else if(checkIns.applicationStatus=='approved' ){ %>
	                            																						<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Approved</font>
	                            																					<%	}else if(checkIns.applicationStatus=='returned' ){ %>
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Returned</font> <br>
	                            																					 <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewReturnReason?id=${bioMedicalWasteInstance.id}&applName=BMW', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>  </td>
	                            																				<%	}} %>   																			
	                            																					
	                            																					
	                            																				<!--	<g:if test="${bioMedicalWasteInstance.applicationStatus=='Completed'}" >
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">In-Progress</font>
	                            																					</g:if><g:elseif test="${bioMedicalWasteInstance.applicationStatus=='approved'}">
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Approved</font>
	                            																					</g:elseif>
	                            																					<g:elseif test="${bioMedicalWasteInstance.applicationStatus=='rejected'}">
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Rejected</font>
	                            																					</g:elseif>
	                            																					<g:elseif test="${bioMedicalWasteInstance.applicationStatus=='returned'}">
	                            																					<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>">Returned</font>
	                            																					</g:elseif>
	                            																					<%if(bioMedicalWasteInstance.applicationStatus=="returned"){%>
	                            																					<br>
	                            																					   <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewReturnReason?id=${bioMedicalWasteInstance.id}&applName=BMW', 'scrutinyStatus','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Reason</font></a>
	   	                            																				<%}%>
	                            																					</td>   -->
<!--added by shashank for check pending with which spcb employee--> 											<td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode2%>"><%if (pendingWith){%>${(pendingWith.role).roleName}<%}%></font></td>
	                        																					<%if(bioMedicalWasteInstance.clarification){ %>
	                        																					    <g:def var="appForWhich1" value="BMW"/><g:def var="applicationId" value="${bioMedicalWasteInstance.id}"/>
 <!--added by shashank for adding a green c window-->                        										<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="submitClarification" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION" title="Clarification Raised"></img></a></td> 
                 																						       	<%}								       	
                 																						       	
                																						       	
                 																						        else{
                 																						       	
                 																						         def isTrue = WasteManagementProcessingDetails.findAll("from WasteManagementProcessingDetails apd where apd.applicationId=?  ",[bioMedicalWasteInstance.id.toString()])
                                               	                                                                                    
                                                                                                                  if(isTrue.clarification.contains(true)){
                                                                                                                        %>
                       
                                                                                                                  <!-- <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/viewSubmittedClarification/${bioMedicalWasteInstance.id}', 'Clarification', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'ClarificationReply.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION" title="Clarification Reply"></img></a></td>    -->                    		
                                                                                                                             		
                        
                                                                                                               <%
                                                                                                                 }}%>
                 		                                                                                           
                                                                                                                 <%
                                                                                                                 if(pendingFlagbmw=="true" && aa1=="false")
                                                                                                             	  {%>
                                                                                                            	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/payment/${bioMedicalWasteInstance.id}', 'payment', 'WIDTH=800,HEIGHT=650,scrollbars=1');"><font face="Verdana" color="blue">Make Payment</font></a></td> 
                                                                                                             	 <% }%>
                 																						       	
  <!--end by shashank-->               																						       	
	                        																					</tr>
	                    																						</g:each>
	                    																						</tbody>
	                    																					<table width="75%"  align="left">
																								  <tr><td>&nbsp;</td></tr>
																								  <tr><td width="8px"  bgcolor="brown"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application is Inprogress or Unattended .</font></td></tr>
																						          <tr><td width="8px"  bgcolor="green"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application is Approved or Rejected .</font></td></tr>
																						          <tr><td width="8px"> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Observation is raised on these application.</font></td></tr>
                                                                                                   <tr><td width="8px"  ><img src="${createLinkTo(dir:'images',file:'ClarificationReply.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;reply to observation raised on application has been made .</font></td></tr>
																						          	
																											</table>
																												
																										</td>
																									</tr>
																								
																					          <table>
																								</table>
																								
																							</div>
																					
																						</div>
																						          
																					</div>
																				</div>
																			</td>
																		</tr>
																		
																	</table>
																	 <tr><td>&nbsp;</td></tr>
																								
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
						<g:include controller="userMaster" action="showSpcbFooter"/>
					</table>
				</td>
			</tr>
			
		</table>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
