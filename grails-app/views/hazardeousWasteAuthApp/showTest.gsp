<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="https://www.w3.org/1999/xhtml">
<head>
		<%
		System.out.println("jIIIIIIIJA");
			response.setHeader("Cache-Control","no-cache"); 
			response.setHeader("Pragma","no-cache"); 
			response.setDateHeader ("Expires", -1);
		%>
		<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Application For Authorization</title>
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
		<script language="javascript" type="text/javascript">
			
			
			function enablingDisabling()
			{
				
				var a= document.getElementById("radioIs_RenewYes").value;
				if(a=="Yes")
					{
						document.getElementById("auth_Renew_No").disabled = true;
						document.getElementById("auth_Renew_Date").disabled = true;
					}
			}
			
			function enablingDisablingAgain()
			{
				
				var a= document.getElementById("radioIs_RenewYes").value;
				if(a=="Yes")
					{
						document.getElementById("auth_Renew_No").disabled = false;
						document.getElementById("auth_Renew_Date").disabled = false;
					}
			}
		</script>
		<g:javascript>
			function createRow(){

  			try{
      			var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'addProduct1.gsp', { insertion: Insertion.Bottom });
  				}catch(e){
      		alert('Failed to call Ajax');
  					}
			}
			
			function createNewRow(){

  			try{
      			var oAjax=new Ajax.Updater({success: 'AjaxPanel1'},'addWaste.gsp', { insertion: Insertion.Bottom });
  				}catch(e){
      		alert('Failed to call Ajax');
  					}
			}
		</g:javascript>
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
									if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									<% 
 									if((UserMaster)session.getAttribute("userMaster")){
 									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType = aa.accessLevel;
									if(userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
									controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
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
													<td height="24" bgcolor="#EEEEF3">
														<table width="100%">
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
																</td>
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
															
														</table>
													</td>
												</tr>
												<tr><td>
												<g:def var="appForWhich1" value="HWM"/><g:def var="applicationId" value="${hazardeousWasteAuthAppInstance.id}"/>
              
												<%if(hazardeousWasteAuthAppInstance.applicationStatus=="approved") {%>
              
               <%

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ 
		}else {
               } %>  &nbsp;<g:link controller="hazardeousWasteAuthApp" action="viewHazCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|&nbsp;</span></g:link>
              <%} 
              if(  (IndUser)session.getAttribute("indUser")  )
		
		{ 
		}else {%>
		 <a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a><% } %>
					</td></tr>							
												<tr>
													<td height="0" align="center" valign="top">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															<tr>
																<!-- Div area for errors-->
																<td align="center" valign="top" >
																	<div style="width: 400px; height: 20px; vertical-align: middle">
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
																<td>&nbsp</td>
															</tr>
															<tr>
																<td height="0" align="left" valign="top">
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
																										<li><a href="#country5"><span>Fee</span></a></li>
																										<li><a href="#country3"><span>Hazardous Waste Details</span></a></li>
																										<li><a href="#country4"><span>Details Files</span></a></li>
																									</ol>
																								</td>
																								 <g:if test="${hazardeousWasteAuthAppInstance?.completionStatus=='Completed'}">
																								<td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewFormPdf?appliLoc=<%=hazardeousWasteAuthAppInstance?.id%>"><span class="headngblue">Print Preview</span></a></td>
																							<!--<td  align="center" class="headngblue"><a href="#" onclick="window.open('<g:createLink controller="hazardeousWasteAuthApp" action="printHazardeousWaste" id="${hazardeousWasteAuthAppInstance.id}" />', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1');"><span class="headngblue">Print Preview</span></a></td>-->
																							
																							</g:if>
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
																												      <tr >
																												        <td>Number : </td>
																												        <td>Date(dd/mm/yyyy): </td>
																												      </tr>
																												      <g:if test="${hazardeousWasteAuthAppInstance?.auth_Renew_Date!= null}">
																												      	<% 
																								                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy ");
																								   
																								                        String strDate = sdfDestination.format(hazardeousWasteAuthAppInstance.auth_Renew_Date);
																							                          %>
																												      <tr >
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
																											<%if(indRegInstance.typeOfIndustry !="bmw"){%>
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
																		  									<%}%>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Year of Commencement of Production:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																													${fieldValue(bean:indRegInstance,field:'dateOfComm')}
																												</td>
																		  									</tr>
																												<%if(indRegInstance.typeOfIndustry !="bmw"){%>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Industry Working Shift: </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										${fieldValue(bean:indRegInstance,field:'shiftsIndustry')}
																		    									</td>
																		  									</tr>
																		  									<%}%>
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
																						      								<tr >
																						        								<td>Product</td>
																						        								<td>Quantity(Tonnes/KL)</td>
																						        								<td>By Products </td>
																						        								<td>Quantity(Tonnes/KL)</td>
																						      								</tr>
																															<tr >
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
																													      <tr>
																													        <td >Product</td>
																													        <td >Quantity(Tonnes/KL)</td>
																													      </tr>
																													      <tr >
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
																						
																						
																						
																						  <div class="content" id="country5">
																						
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
def cate = IndustryRegMaster.findById(indRegInstance.id.toLong())
def noOfMaterial = indRegInstance.plotNo 
%>

                                                         <tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Investment:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>	
															
															
															<%
															def consentFeeMasterInst = ConsentFeeMasterHWM.findByApplication(hazardeousWasteAuthAppInstance)
															
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
									
								def feesOnline = FeeBankOtherDetailsHWM.find("from FeeBankOtherDetailsHWM fee where fee.application=?",[hazardeousWasteAuthAppInstance])
							def feesBank = FeeBankDetailsHWM.find("from FeeBankDetailsHWM fee where fee.application=?",[hazardeousWasteAuthAppInstance])
									
									
									def feesBankOnline = BankTransactionDetailsHWM.find("from BankTransactionDetailsHWM fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[hazardeousWasteAuthAppInstance])


%>
												

	<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeOtherDetailsViewHWM/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
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
																			onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeDetailsHWMView/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
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
																			onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popChallan/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View Challan </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
																				
																						
																				
										</table>
										</table>
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
																														      <tr >
																														        <td >Type</td>
																														        <td >Quantity(Tonnes/KL)</td>
																														        <td >Source</td>
																														        <td >Waste Characteristics</td>
																														      </tr>
																														      <tr>
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
																														      <tr >
																														        <td >Mode of Storage </td>
																														        <td >Method of Disposal </td>
																														        <td >Capacity(Tonnes/KL)</td>
																														        <td >Quantity Disposed</td>
																														      </tr>
																														      <tr >
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
		                            																					<td class="headngblue"><g:link action="viewFile1" id="${wasteManagementFileInstance.id}">View</g:link></td>
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
																	<g:form  action="edit" name="myform" method="post" >
																	  <input type="hidden" name="id" value="${hazardeousWasteAuthAppInstance?.id}" />
																	
																	<table width="95%">
																	<g:if test="${hazardeousWasteAuthAppInstance?.completionStatus=='Inprogress'}">
																		<td  align="center"><input type="submit" value="Edit"
																				 class="actionbutton" /></td>
																	</g:if>			 
																	</table>
																	</g:form>

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