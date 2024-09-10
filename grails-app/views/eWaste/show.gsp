<%@ page import="java.text.SimpleDateFormat;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
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
			
			
			function enablingDisabling()
			{
				
				var a= document.getElementById("radioIs_RenewYes").value;
				if(a=="Yes")
					{
						document.getElementById("auth_Renew_No").disabled = true;
						document.getElementById("auth_Renew_No").value="";
						document.getElementById("auth_Renew_Date").disabled = true;
						document.getElementById("auth_Renew_Date").value="";
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
      			var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'addProduct.gsp', {evalScripts: true, insertion: Insertion.Bottom });
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
		
		<script language="javascript">
function deleteTable()
{
var table = document.getElementById("table1");

for(var i = table.rows.length - 1; i > 2; i--)
{
    table.deleteRow(i);
}

var tbody = document.getElementById("table1").tBodies[0]; 
var row = document.createElement("TR"); 
var cell1 = document.createElement("TD");
cell1.setAttribute("width","100%");
cell1.setAttribute("colspan","2");
var div = document.createElement("DIV"); 
div.setAttribute("id","AjaxPanel1");
cell1.appendChild(div);
row.appendChild(cell1);
tbody.appendChild(row);
}
</script>
</head>
<body>
<% SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm"); %>
<%System.out.println("on gsp show page.."+params)%>
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
								                        <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="eWasteEmpMenuVertical"/> 
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
													<td height="24" bgcolor="#EEEEF3" >
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
															<%
															
															if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin")||userType.equals("employee")) { 
								
								        	def appunattended = EWasteManagementUnattendedApplication.find("from EWasteManagementUnattendedApplication as wmpd where wmpd.applicationId=? and wmpd.applicationFor='EWaste'",[(eWasteInstance.id).toString()]) 
								def wasteCert = EWasteManagementCertificates.find("from EWasteManagementCertificates as wmpd where wmpd.applicationId=? and wmpd.typeOfFile='EWasteNew Uploaded'",[(eWasteInstance.id).toLong()])
								if(!appunattended){
									%>
									<a href="#" onclick="window.open('<g:createLink action="openApplicationDetails" params="[id:eWasteInstance.id,docName:'EWaste']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
									
									<%}
									if(wasteCert){ %>
									
									<a href="#" onclick="window.open('<g:createLink action="viewDisEWasteCert" params="[id:wasteCert.id,docName:'EWaste']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Certificate &nbsp;|</span></a>
									
										
									<%}%>	
									
									
									
									
									<%}}%>
																<td height="0" align="left" valign="top">
																	<table width="100%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																			<td width="82" align="left" valign="top">
																				&nbsp;
																			</td>
																			<td align="left" valign="top">
																				<div style="padding: 0px 0px 0px 0px;">
																					<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
																					<table width="764"  border="0" align="center" cellpadding="0" cellspacing="0"  >
																				<% if(  (IndUser)session.getAttribute("indUser")  ){	%>	
																				<tr valign="middle" width="100%">
																								<td width="17%" align="left">		
																						
																		<%if(chk)
						{
						int id=appId;%>
						<g:link controller="eWaste" action="viewEWasteCert1"  id="${id}" ><span class="innerlink">&nbsp;View Certificate</span></g:link>
						<%}
						%>		
						</td>		<% }%>
																						
																						<tr valign="middle" width="100%">
																								<td width="17%" align="right">
										                			
																<%
																System.out.println("eWasteInstance.completionStatus.."+eWasteInstance.completionStatus)
																if( eWasteInstance.completionStatus != "inProgress"){ %>
																
																
																
																<font size="1" face="Verdana">
			<a href="<%=request.getContextPath()%>/eWaste/viewEEWPdf?appliLoc=<%=eWasteInstance?.id%>"><span class="headngblue">Print Form</span></a>
																<%
																}%>
																		
															
															</td>
															
																							</tr>
																							
																							<tr><td>&nbsp;&nbsp;</td></tr>
																						
																						<tr valign="middle" width="100%">
                 																							 <td  width="100%" align="left" >
																									<ol id="toc">
																										<%  System.out.println("eWasteInstance.checkBoxButton........  "+eWasteInstance.checkBoxButton)
																											ArrayList temp = new ArrayList()
                                                                                                            def temp1= eWasteInstance.checkBoxButton
                                                                                                            temp = temp1.split(",")
																											System.out.println("tempppp... "+temp)

																										if(eWasteInstance.authorisationType=='chkManufactureOrRefurbisher'){
                                                                                                        
                                                                                                        
                                                                                                        %>
                                                                                                            <li><a href="#country1"><span>General Details</span></a></li>
                                                                                                            <li><a href="#country8"><span>Manufacture/Refurbisher</span></a></li>
                                                                                                            <li><a href="#country4"><span>Documents</span></a></li>
																										<%}else if(eWasteInstance.authorisationType=='chkDismantlerOrRecycler'){%>
                                                                                                            <li><a href="#country1"><span>General</span></a></li>
                                                                                                            <li><a href="#country2"><span>Product</span></a></li>
                                                                                                            <li><a href="#country5"><span>Waste Management</span></a></li>
                                                                                                            <li><a href="#country7"><span>Other</span></a></li>
                                                                                                            <li><a href="#country4"><span>Documents</span></a></li>
                                                                                                        <%}else{%>
                                                                                                            <li><a href="#country1"><span>General</span></a></li>
                                                                                                            <li><a href="#country2"><span>Product</span></a></li>
                                                                                                            <!--<li><a href="#country3"><span>Water Consumption</span></a></li>
                                                                                                            <li><a href="#country6"><span>Air Pollution Control</span></a></li>-->
                                                                                                            <li><a href="#country5"><span>Waste Management</span></a></li>
                                                                                                            <li><a href="#country8"><span>Manufacture/Refurbisher</span></a></li>
                                                                                                            <li><a href="#country7"><span>Other</span></a></li>
                                                                                                            <li><a href="#country4"><span>Documents</span></a></li>
                                                                                                        <%}%>
																									</ol>
																										
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
																		 									 
																		 									 <% if(eWasteInstance.authorisationType=='chkDismantlerOrRecycler'){%>
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
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >E-Waste Authorization From :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${authorizationFrom}</td>
				</td>
																		 									 </tr>
											
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >E-Waste Authorization To :</td>
																		    									<td valign="top" bgcolor="#E8F6F9" class="headngblue">${authorizationTo}</td>
				</td>
																		 									 </tr>
																		 									 
																		 									<%}%>
																										
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
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Production Details : Installed Capacity in MT/Year</td>
					<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
								<td align="center"  ><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductionDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
								</tr>	
				</td>
				</table>
							</tr>

<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">E-Waste Processed during last three years :</td>
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
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste generation Details in processing E-Waste:</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#"   onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteGenDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
</tr>
</table>
</td>


<tr  bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Disposal Details of residue:</td>
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


                                                                                <div id="country8" class="content">

                                                                                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                                                        <tr><td bgcolor="#FFFFFF">
                                                                                            <table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                                                                <tr bgcolor="#417FB2">
                                                                                                    <td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Manufacture/Refurbisher Details</span></td>
                                                                                                    <td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td>
                                                                                                </tr>
                                                                                                <tr bgcolor="#E8F6F9">
                                                                                                    <td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Are you a Manufacture or Refurbisher :</td>
                                                                                                    <%if(ewasteIsManufacturerOrRefurbisher){%>
                                                                                                        <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">YES</td>
                                                                                                    <%}else{%>
                                                                                                        <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">NO</td>
                                                                                                    <%}%>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Authorization Required for :</td>
                                                                                                    <td valign="top" bgcolor="#E8F6F9"  align="left">
                                                                                                        <%if(eWasteInstance.chkConsent!="")
                                                                                                        {%>
                                                                                                        Generation during Manufacturing or Refurbishing<br>
                                                                                                        <%}%>
                                                                                                        <%if(eWasteInstance.chkBMW!=""){%>
                                                                                                        Treatment(if any)<br>
                                                                                                        <%}%>
                                                                                                        <%if(eWasteInstance.chkHWM!=""){%>
                                                                                                        Collection, Transportation, Storage<br>
                                                                                                        <%}%>
                                                                                                        <%if(eWasteInstance.chkSWM!=""){%>
                                                                                                        Refurbishing
                                                                                                        <%}%>
                                                                                                    </td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total quantity E waste Generated in MT/A :</td>
                                                                                                    <td align="center" bgcolor="#E8F6F9"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopTotalQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity Refurbished : </td>
                                                                                                    <td align="center" bgcolor="#E8F6F9"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRefurbishedQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity send for Recycling : </td>
                                                                                                    <td align="center" bgcolor="#E8F6F9"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRecycleQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity send for Disposal :</td>
                                                                                                    <td align="center" bgcolor="#E8F6F9"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopDisposalQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of facilities for Storage/ Handling/ Treatment/ Refurbishing :</td>
                                                                                                    <td align="center" bgcolor="#E8F6F9"><span style="color: black">
                                                                                                        <%if(eWasteInstance.facilityDetail){%>
                                                                                                            <%= eWasteInstance.facilityDetail%>
                                                                                                            <g:def var="fooVar" value="${eWasteInstance.id}"/>
                                                                                                            <g:def var="docN" value="Facility Details"/>
                                                                                                            <g:link action="viewFileShow" params="[appliLoc:fooVar,docName:docN,docType:'pdf']">Download</g:link>
                                                                                                        <%}%>
                                                                                                    </td>
                                                                                                </tr>
                                                                                                <tr>
                                                                                                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">In case of renewal of authorization previous authorization number and date and details of annual returns :</td>

                                                                                                    <td align="center" bgcolor="#E8F6F9"><span style="color: black">
                                                                                                        <%if(eWasteInstance.renewalAuth){%>
                                                                                                            <%= eWasteInstance.renewalAuth%>
                                                                                                            <g:def var="fooVar1" value="${eWasteInstance.id}"/>
                                                                                                            <g:def var="docN1" value="Renewal Details"/>
                                                                                                            <g:link action="viewFileShow" params="[appliLoc:fooVar1,docName:docN1,docType:'pdf']">Download</g:link>
                                                                                                        <%}%>
                                                                                                    </td>
                                                                                                </tr>

                                                                                            </table>
                                                                                        </td></tr>
                                                                                    </table>
                                                                                </div>





















			
																
																	
				  <div id="country7" class="content">
																							
	    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		    <tr><td bgcolor="#FFFFFF">
			    <table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		            <tr bgcolor="#417FB2">
					    <td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Other Details</span></td>
					    <td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td>
			        </tr>
			        <tr bgcolor="#E8F6F9">
					    <td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Details of e-waste proposed to be procured from reprocessing :</td>
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
				    </tr>
				    <tr>
					    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether industry is in compliance with conditions laid down in the Authorization :  </td>
                        <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">${fieldValue(bean:eWasteInstance, field:'indCompliance')}</td>
				    </tr>
                    <tr>
					    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Occupational safety and health aspects Details : </td>
					    <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">
                            <%if(eWasteInstance.healthAspects){%>
                            <%= eWasteInstance.healthAspects%>
                            <g:def var="fooVar" value="${eWasteInstance.id}"/>
                            <g:def var="docN" value="Occupational Safety Details"/>
                            <g:link action="viewFileShow" params="[appliLoc:fooVar,docName:docN,docType:'pdf']">Download</g:link>
                            <%}%>
                        </td>
				    </tr>
                    <tr>
					    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Any other Information of relevance : </td>
					    <td valign="top" bgcolor="#E8F6F9" class="headngblue" align="center">
                            <%if(eWasteInstance.relInfo){%>
                            <%= eWasteInstance.relInfo%>
                            <g:def var="fooVar" value="${eWasteInstance.id}"/>
                            <g:def var="docN1" value="Relevant Information"/>
                            <g:link action="viewFileShow" params="[appliLoc:fooVar,docName:docN1,docType:'pdf']">Download</g:link>
                            <%}%>
                            %{--${fieldValue(bean:eWasteInstance, field:'relevantInformation')}--}%
                        </td>
                    </tr>
                </table>
            </td></tr>
        </table>
                  </div>
																							
                                                                          						
																	                           <% def ewasteProcessing=EWasteProcessingDetails.findAll("from EWasteProcessingDetails  e where e.applicationId=? order by dateCreated desc",[eWasteInstance.id.toString()] )
																	                           if(ewasteProcessing.size()>0){
																	                            if(ewasteProcessing[0].returned ==true && ewasteProcessing[0].resubmitStatus==false){ testVal=true %>
												        <table width="100%">
													<g:form name="myform" method="post" action="edit">

														<%System.out.println("eWasteInstance.completionStatus123466.."+eWasteInstance.completionStatus)%>
														<tr>
															<input type="hidden" name="edit" value="1" />
															<input type="hidden" name="testValue" value="<%=testVal%>" />
															<input type="hidden" name="appId"
																value="<%=eWasteInstance.id%>" />
															<td align="center"><input type="submit" name="Edit"
																value="Edit" class="actionbutton"></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</g:form>
												</table>
																			
															      <%  } }else if(eWasteInstance.completionStatus == "inProgress"){ %>
												        <table width="100%">
													<g:form name="myform" method="post" action="edit">

														<%System.out.println("eWasteInstance.completionStatus123466.."+eWasteInstance.completionStatus)%>
														<tr>
															<input type="hidden" name="edit" value="1" />
															<input type="hidden" name="appId"
																value="<%=eWasteInstance.id%>" />
															<td align="center"><input type="submit" name="Edit"
																value="Edit" class="actionbutton"></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</g:form>
												</table>
												<%} %>							
																							
																						</div>
																						
																
																				</div>
																			</td>
																		</tr>
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
					 <g:include controller="userMaster" action="showSpcbFooter"/>
					</table>
				</td>
			</tr>
		</table>
		
	<script language="JavaScript" type="text/javascript">
		
		
					
    	
	</script>
	<script language="JavaScript" type="text/javascript">
	
	
		
	
	</script>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
          
          
		  		  