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
			function funDateTo(dateText){
				alert("Date is :"+dateText);
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
								                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/>
								            <%} %>
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
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															<tr>
																<!-- Div area for errors-->
																<td align="left" valign="top">
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
															
															<% 	
         
         		def recordCertificateInstance = RecordCertificateHWM.find("from RecordCertificateHWM apd where apd.application=? order by id desc",[hazardeousWasteAuthAppInstance])
	//print(recordCertificateInstance)
         	
 %>
															<tr>
																<td height="0" align="left" valign="top">
																	<g:form  action="createRenewalCertificate" name="myform" method="post" >
																	  <input type="hidden" id="hazardeousWasteAuthAppInstanceid" name="hazardeousWasteAuthAppInstanceid" value="${hazardeousWasteAuthAppInstance?.id}" />
																	<table align="center" width="76%" border="0" cellspacing="1" cellpadding="2" class="tblbdr">
																	<input id="authNumber" name="authNumber" type="hidden" value="" />
																	
																	<!--
																	<tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization Number*:</td>
									    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																						<input id="authNumber" name="authNumber" type="text" size="30"  maxlength="50" AUTOCOMPLETE=OFF class="txt4" value="<%if(recordCertificateInstance){print(recordCertificateInstance.authorizationNo)}%>" />
																		</td>
									  									</tr>
									  									-->
																			<tr>
																			<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Name of the Unit:</td>
																			<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
																				
																				<textarea name="name" id="name" rows="2" cols="35"><%if(recordCertificateInstance){print(recordCertificateInstance.name)}%></textarea>
																			<!--${fieldValue(bean:indRegInstance,field:'indName')}-->
																			</td>
																		</tr>
																		<tr>
																			<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Address:</td>
																			<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																			<textarea name="address" id="address" rows="2" cols="35"><%if(recordCertificateInstance){print(recordCertificateInstance.address)}%></textarea>
																				<!--${fieldValue(bean:indRegInstance,field:'indAddress')}-->
																			</td>
																		</tr>
																	<!--
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
																		</tr>-->
																		<tr>
																			<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Application Number</td>
																			<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																				${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}
																			</td>
																		</tr>
																		<tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Period Of Authorization(In Year)*</td>
									    									<td width="50%" bgcolor="#E8F6F9"  align="left">
																				<input id="period_of_Auth" name="period_of_Auth" type="text" size="20"  maxlength="50" AUTOCOMPLETE=OFF class="txt4" value="<%if(recordCertificateInstance){print(recordCertificateInstance.valid)}else{print(5)}%>" />
																			</td>
																			
									  									</tr>
									  									
									  										<tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Office</td>
									    									<td width="50%" bgcolor="#E8F6F9"  align="left">
																				<input id="office" name="office" type="text" size="20"  maxlength="50" AUTOCOMPLETE=OFF class="txt4"  value="<%if(recordCertificateInstance){print(recordCertificateInstance.office)}%>" />
																			</td>
																			
									  									</tr>
									  									
									  									<tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Name</td>
									    									<td width="50%" bgcolor="#E8F6F9"  align="left">
																				<input id="officerName" name="officerName" type="text" size="20"  maxlength="50" AUTOCOMPLETE=OFF class="txt4"  value="<%if(recordCertificateInstance){print(recordCertificateInstance.officerName)}%>" />
																			</td>
																			
									  									</tr>
									  									
									  									<tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Designation</td>
									    									<td width="50%" bgcolor="#E8F6F9"  align="left">
																				<input id="officerDes" name="officerDes" type="text" size="20"  maxlength="50" AUTOCOMPLETE=OFF class="txt4"  value="<%if(recordCertificateInstance){print(recordCertificateInstance.officerDes)}%>" />
																			</td>
																			
									  									</tr>
									  									 <tr >
										  									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Type of Officer:</td>
										  									<td width="50%" bgcolor="#E8F6F9"  align="left"><span class="txt4">
										  				                      
										  				                       <g:select from="${['Not-Selected','HO','RO']}" name="typeOfOfficer" value="${fieldValue(bean:recordCertificateInstance, field:'typeOfOfficer')}" class="txt4" ></g:select>
										  				                     
										  				                      </span></td>
										  				                    </tr>
										  				                      
										  				                    
										  				                    <tr >
										  				                  <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Office:</td>
										  				                <td width="50%" bgcolor="#E8F6F9"  align="left"><span class="txt4">
										  				                    
										  				                         <g:select from="${['RNC','HZB','JSR','DHN','DMK']}" name="RegionalOffice" value="${fieldValue(bean:recordCertificateInstance, field:'RegionalOffice')}" class="txt4" ></g:select>
										  				                
										  				                    </span></td>
										  				                  </tr>
									  									
										  				                <tr >
										  				                  <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Details of Authorisation:</td>
										  				                <td width="50%" bgcolor="#E8F6F9"  align="left"><span class="txt4">
										  				                    
										  				              <table width="100%">
																	  <tr>
																		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popAuthorisationDetailsAdd/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
																		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popAuthorisationDetailsView/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
																		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popAuthorisationDetailsEdit/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
																	  </tr>
																	</table>
										  				                    </span></td>
										  				                  </tr>	
										  				                  
									  									<tr style="display:none">
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> </td>
																		    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																			    <table width="293" border="1">
																			      <tr >
																			        <td>From(dd/mm/yyyy)*: </td>
																			        <td>To(dd/mm/yyyy)*: </td>
																			      </tr>
																			      <tr >
																			        <td>
																			        <%if(recordCertificateInstance){%>
																			        <calendar:datePicker  id="auth_Renew_Date_From" name="auth_Renew_Date_From"  dateFormat="%d/%m/%Y" value="${recordCertificateInstance.issueDate}" />
																			        <%} else{%>
																			        
																			        <calendar:datePicker  id="auth_Renew_Date_From" name="auth_Renew_Date_From"  dateFormat="%d/%m/%Y"  disabled="disabled"/>
																				      <%}%> 
																			        </td>
																			        
																			        
																			        
																			        <td>
																			        <%if(recordCertificateInstance){%>
																			        <calendar:datePicker  id="auth_Renew_Date_To" name="auth_Renew_Date_To"  dateFormat="%d/%m/%Y"  value="${recordCertificateInstance.expiryDate}"/>
																			        
																			        <%} else{%>
																			        <calendar:datePicker  id="auth_Renew_Date_To" name="auth_Renew_Date_To"  dateFormat="%d/%m/%Y"  disabled="disabled"/>
																			        <%}%>  
																			        
																			        </td>
																			      </tr>
																			    </table>      
																			</td>
									  									</tr>
									  								<!--	<tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization for*: </td>
									    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
											      								<p>
																		  			<% int b=0;%>
																					<%for(int i=0;i<tmp1.size();i++){%>
																					<g:if test="${tmp1[i]=='Collection'}">
																			     	<%b=1;%>
																			     	</g:if>
																			     	<%}%>
																					<g:if test="${b==1}">
																					<input type="checkbox" name="chkCollection" id="chkCollection"  checked="checked"/>
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
																					<input type="checkbox" name="chkReception" id="chkReception"  checked="checked"/>
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
																					<input type="checkbox" name="chkTreatment" id="chkTreatment"  checked="checked"/>
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
																					<input type="checkbox" name="chkTransport" id="chkTransport"  checked="checked"/>
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
																					<input type="checkbox" name="chkStorage" id="chkStorage"  checked="checked"/>
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
																					<input type="checkbox" name="chkDisposal" id="chkDisposal"  checked="checked"/>
																			  			Disposal 
																		  			</g:if>
																		  			<g:else>
																		  				<input type="checkbox" name="chkDisposal" id="chkDisposal" disabled="disabled" /> 
																						Disposal 
																		  			</g:else>
																					
											 									</p>
									     									</td>
									  									</tr>-->
									  									<!--<tr>
									  										<td width="20%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization for Wastes*: </td>
									  										<td width="80%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																				<table width="87%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																					<tr>
												    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">S.No</td>
												    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">Hazardeous Waste</td>
												    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">Source</td>
												    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">Quantity(KL)/Year</td>
												    									<td width="25%" bgcolor="#A8DAF3" align="left" class="headngblue">Remarks</td>
												  									</tr>
												  									<g:each in="${hazardeousWasteDetailsList}" status="i" var="indHazardeousWasteDetailsInstance">
    																					<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
        																					<td class="headngblue">${i+1}</td>
        																					<td class="headngblue">${fieldValue(bean:indHazardeousWasteDetailsInstance, field:'hw_Type')}</td>
        																					<td class="headngblue">${fieldValue(bean:indHazardeousWasteDetailsInstance, field:'hw_Source')}</td>
        																					<td class="headngblue">${fieldValue(bean:indHazardeousWasteDetailsInstance, field:'hw_Qty')}</td>
        																					<td class="headngblue">
        																						<input id="remarks" name="remarks" type="text" size="20"  maxlength="50" AUTOCOMPLETE=OFF class="txt4" />
    																						</td>
    																					</tr>
																					</g:each>
																				</table>
																			</td>
									  									</tr>-->
									  									<tr>
									  										<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Specific Conditions*: </td>
									  										<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
									  										<textarea name="termsConditions" id="termsConditions" rows="5" cols="35"><%if(recordCertificateInstance){print(recordCertificateInstance.termsConditions)}%></textarea>
									  										</td>
									  									</tr>
									  									<tr>
									  										<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Copy To* : </td>
									  										<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue"><textarea name="copyTo" id="copyTo" rows="5" cols="35"><%if(recordCertificateInstance){print(recordCertificateInstance.copyTo)}%></textarea></td>
									  									</tr>
																	</table>
																	<table width="95%"> 
																		<tr>
																			<td width="15%">&nbsp;</td>
																			<td colspan="4" align="center" class="txtR">Fields marked * are mandatory</td>
																		</tr>
																	</table>
																	<table width="95%">
																		<td  align="center"><input type="submit" value="Generate"
																			onclick="return tosubmit();" class="actionbutton" /></td>
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
		
		<script language="JavaScript" type="text/javascript">

		 var frmvalidator  = new Validator("myform");
		    frmvalidator.EnableFocusOnError(false); 
		    frmvalidator.EnableMsgsTogether(); 
			
		    frmvalidator.addValidation("typeOfOfficer","dontselect=0","please select type Of Officer");
		 
		</script>
		
		<script language="JavaScript" type="text/javascript">
		
		var frmvalidator  = new Validator("myform");
    	frmvalidator.EnableFocusOnError(false); 
    	frmvalidator.EnableMsgsTogether(); 
    	
    	function tosubmit()
    	{
    		
    		
    		if(!(document.getElementById("chkCollection").checked) && !(document.getElementById("chkReception").checked) && !(document.getElementById("chkTreatment").checked) && !(document.getElementById("chkTransport").checked) && !(document.getElementById("chkStorage").checked) && !(document.getElementById("chkDisposal").checked))
 			{ 
 				alert("Please Check Atleast one Authorization Reqired For Check Box");
 				return false;
 			}
 			else
 			{
 				
 				frmvalidator.addValidation("period_of_Auth","req","Please enter Period of Authorization");
 				frmvalidator.addValidation("period_of_Auth","numeric","Enter Numeric value for Period of Authorization");
	 			
	 			frmvalidator.addValidation("auth_Renew_Date_From","req","Please enter Date From");
	    		frmvalidator.addValidation("auth_Renew_Date_To","req","Please enter Date To");
	    		
	    	//	frmvalidator.addValidation("authNumber","req","Please enter Authorization Number");
	    		
	    		frmvalidator.addValidation("termsConditions","req","Please enter Specific Conditions");
	    	//	frmvalidator.addValidation("copyTo","req","Please enter Copy To");
	    	}
 			
    	}
	</script>
	</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>