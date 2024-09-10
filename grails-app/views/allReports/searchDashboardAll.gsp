<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
	<head>
		<!-- groovy code start; mainly query -->
		%{--<%
			def ApplicationCountAllModuleCto = ApplicationCountAllModule.findByTypeOfModule('CTO')
			def ApplicationCountAllModuleBmw = ApplicationCountAllModule.findByTypeOfModule('BMW')
			def ApplicationCountAllModuleAnnualReport = ApplicationCountAllModule.findByTypeOfModule('Annual Report')
			def ApplicationCountAllModuleHmw = ApplicationCountAllModule.findByTypeOfModule('HWM')
		%>--}%
		<!-- groovy code ends -->
		<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>
		%{--bhanu code start; date: 08-06-2017--}%
		%{--code to show pie chart--}%
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			google.charts.load("current", {packages:["corechart"]});
			google.charts.setOnLoadCallback(drawChart);
			function drawChart() {
				
				var data1 = google.visualization.arrayToDataTable([
				
                ['Applications', 'count'],
                ['Granted Within Time',     <%= ctoGrantedWithinTime %>],
                ['Granted Beyond Time',      <%= ctoGrantedBeyondTime %>],
                ['Rejected Within Time',     <%= ctoRejectedWithinTime %>],
                ['Rejected Beyond Time',      <%= ctoRejectedBeyondTime %>],
                ['Pending Within Time',  <%= ctoPendingWithinTime %>],
                ['Pending Beyond Time',  <%= ctoPendingBeyondTime %>]
				
				
				]);
				
				var options1 = {
				
                legend: 'none',
				};
				
				
				var data2 = google.visualization.arrayToDataTable([
				
                ['Applications', 'count'],
                ['Granted Within Time', <%= hwmGrantedWithinTime %>],
                ['Granted Beyond Time', <%= hwmGrantedBeyondTime %>],
                ['Rejected Within Time', <%= hwmRejectedWithinTime %>],
                ['Rejected Beyond Time', <%= hwmRejectedBeyondTime %>],
                ['Pending Within Time', <%= hwmPendingWithinTime %>],
                ['Pending Beyond Time',  <%= hwmPendingBeyondTime %>]
				
				]);
				
				
				var options2 = {
				
                legend: 'none',
				};
				
				var data3 = google.visualization.arrayToDataTable([
				
                ['Applications', 'count'],
                ['Granted Within Time', <%= cteGrantedWithinTime %>],
                ['Granted Beyond Time', <%= cteGrantedBeyondTime %>],
                ['Rejected Within Time', <%= cteRejectedWithinTime %>],
                ['Rejected Beyond Time', <%= cteRejectedBeyondTime %>],
                ['Pending Within Time', <%= ctePendingWithinTime %>],
                ['Pending Beyond Time',  <%= ctePendingBeyondTime %>]
				
				
				]);
				
				
				var options3 = {
                legend: 'none',
				};
				var chart1 = new google.visualization.PieChart(document.getElementById('donutchart1'));
				chart1.draw(data1, options1);
				var chart2 = new google.visualization.PieChart(document.getElementById('donutchart2'));
				chart2.draw(data2, options2);
				var chart3 = new google.visualization.PieChart(document.getElementById('donutchart3'));
				chart3.draw(data3, options3);
				}
			</script>
			%{--bhanu code ends--}%
			
			<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
			<title>SPCB Admin Home</title>
			<link rel="stylesheet" type="text/css"
			href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
			<link rel="stylesheet" type="text/css"
			href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
			<link rel="stylesheet" type="text/css"
			href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
			<link rel="stylesheet" type="text/css"
			href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
			<link rel="stylesheet" type="text/css"
			href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
			<script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>
			<script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>
			<script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'tabcontent.js')}"></script>
			<script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'gen_validatorv31.js')}"></script>
			<script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'md5.js')}"></script>
			<link rel="stylesheet" type="text/css"
			href="${createLinkTo(dir: 'css', file: 'design.css')}"/>
			<script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'tabs.js')}"></script>
             <link rel="stylesheet" type="text/css"
    			href="${createLinkTo(dir: 'css', file: 'dashboard.css')}"/>
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
					
					.capcha {
					background-image: url(../images/globe.jpg);
					border: 1px solid #000;
					
					height: 33px;
					width: 102px;
					font-size: 25px;
					color: indigo;
					text-align: center;
					margin-left: 68px;
					margin-top: 8px;
					margin-bottom: 8px;
					font-style: italic;
					
					}
					
					.blue:hover {
					background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}');
					}
					
				-->
				
				
				/*bhanu code start*/
				input[type=number]::-webkit-inner-spin-button,
				input[type=number]::-webkit-outer-spin-button {
				-webkit-appearance: none;
				-moz-appearance: none;
				appearance: none;
				margin: 0;
				}
				/*bhanu code ends*/
			</style>
			
			
			
			
		</head>
		
		<body>
			
			<table width="1003" border="0" align="center" cellpadding="0"
			cellspacing="0">
				<tr>
					<td align="left" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="91" align="left" valign="top" class="bgtop"><!-- code for spcbHeader  -->
								<g:include controller="userMaster" action="showSpcbHeader"/></td>
							</tr>
							<tr>
								<td height="32" align="left" valign="top"
								background="${createLinkTo(dir: 'images2/gif', file: 'button_BG.gif')}">
									<!-- code for menuAdminHorizontal--> <%
									if ((IndUser) session.getAttribute("indUser")) { %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal"/> <% } %>
									<%
										if ((UserMaster) session.getAttribute("userMaster")) {
										UserMaster aa = (UserMaster) session.getAttribute("userMaster");
										String userType = aa.accessLevel;
									if (userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal"/> <%
									} else { %> <g:include
									controller="userMaster" action="showSpcbUserMenuHorizontal"/> <% }
									} %>
									<% if ((!(IndUser) session.getAttribute("indUser")) &&
									(!(UserMaster) session.getAttribute("userMaster"))) { %> <g:include
									controller="userMaster" action="showMenu"/> <% } %>
									
								</tr>
								<tr>
									<td align="left" valign="top">
										<table width="1003" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="224" align="left" valign="top" bgcolor="#DEEED0">
													<!-- code for menuAdmin--> <%
													if ((IndUser) session.getAttribute("indUser")) { %> <g:include
													controller="userMaster" action="showSpcbIndustryMenu"/> <% } %> <%
														
														if ((UserMaster) session.getAttribute("userMaster")) {
														UserMaster aa = (UserMaster) session.getAttribute("userMaster");
														String userType = aa.accessLevel
													if (userType.equals("admin")) { %> <g:include
													controller="userMaster" action="showAdminMenu"/> <%
													} else { %> <g:include
													controller="userMaster" action="showSpcbUserMenu"/> <% }
														} %> <% if ((!(IndUser) session.getAttribute("indUser")) &&
													(!(UserMaster) session.getAttribute("userMaster"))) { %> <g:include
													controller="userMaster" action="showIndexMenu"/> <% } %>
												</td>
												<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
												<td width="778" align="left" valign="top">
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td height="1" valign="top"></td>
														</tr>
														<tr>
															<td><img
																src="${createLinkTo(dir: 'images2', file: 'img.jpg')}"
																width="778"
															height="134"/></td>
														</tr>
														<%
															boolean decVar = true;
															String firstname;
															String lastName;
															String access;
															String indname;
															
															if ((UserMaster) session.getAttribute("userMaster")) {
															UserMaster um = (UserMaster) session.getAttribute("userMaster");
															UserProfile aa = (UserProfile) session.getAttribute("userprof");
															firstname = aa.employeeFirstName;
															lastName = aa.employeeLastName;
															access = um.accessLevel;
															} else if ((IndUser) session.getAttribute("indUser")) {
															IndustryRegMaster ind = (IndustryRegMaster) session.getAttribute("indregName");
															indname = ind.indName;
															} else {
															decVar = false;
															}
															
															java.util.Date dateSCR = new java.util.Date();
															int year = dateSCR.getYear();
															if (year < 1000)
															year += 1900;
															int date = dateSCR.getDate();
															int month = (dateSCR.getMonth()) + 1;
															
															
														%>
														
														<tr>
															<td height="24" bgcolor="#EEEEF3">
																<table width="100%">
																	
																	<% if ((UserMaster) session.getAttribute("userMaster")) {
																	%>
																	
																	<tr bgcolor="#4C8BC0">
																		<td class="top-lnks">
																			<table width="100%">
																				<tr height="10px">
																					<td>Welcome <%=firstname%><%=lastName%>(<%=
																					access%>)</td>
																					<td class="top-lnks"
																					align="right">Date :&nbsp;<%=date%>/<%=
																					month%>/<%=year%>
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	
																	<% }
																		
																		if ((IndUser) session.getAttribute("indUser"))
																		
																	{ %>
																	<tr bgcolor="#4C8BC0">
																		<td class="top-lnks">
																			<table width="100%">
																				<tr height="10px">
																					<td>Welcome <%=indname%></td>
																					<td class="top-lnks"
																					align="right">Date :&nbsp;<%=date%>/<%=
																					month%>/<%=year%>
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																	
																	<% } %>
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
																			<span
																			class="error">
																				<g:if test="${flash.message}">
																					<div class="message">${flash.message}</div>
																				</g:if>
																				<g:hasErrors bean="${industryRegMasterInstance}">
																					<div class="errors">
																						<g:renderErrors
																						bean="${industryRegMasterInstance}"
																						as="list"/>
																					</div>
																				</g:hasErrors></span>
																		</td>
																	</tr>
																	
																	<tr>
																		<td>
																			
																			<div class="row">
																				<div class="col-md-12 text-center" style="font-size: large; color: blue;">
																					<br>
																					Summarized Application Status
																				</div>
																			</div>
																			
																		</td>
																	</tr>
																	
																	<!-- bhanu code start; date: 10-07-2017 -->
																	
																	<%
														             def newGroupList=GroupMaster.findAll("from GroupMaster gm where gm.office.priority=1 order by gm.groupName asc")
														                def groupList = new ArrayList()
														                for(int i = 0 ; i < newGroupList.size(); i++ )
														                {
															                if(!(newGroupList[i].groupName=="Industry"))
															                {
															    	        groupList.add(newGroupList[i])
															                }
														                }
														            %>
																	<tr>
																		<td>
																			<div class="row">
																				<div class="col-md-12 text-center" >
																					<form method="post" action="searchDashboard" target="_blank">
																						
																					 <br>
																						<div class="row">
																							<div class="col-md-4"><font color="black"><b>From Date<b>:</font> <input type="date" name="fromDate"/></div>
																							<div class="col-md-4"><font color="black"><b>To Date</b>:</font> <input type="date" name="toDate"/></div>
																							<div class="col-md-4"><font color="black"><b>Regional Office</b>:</font> 
																							<select name="region" id="region" class="txt4">
																							<option value="NotSelected">NotSelected</option>
																							<option value="All">All</option>
																							<%
																							for(int i=0;i<groupList.size();i++)
																							{
																								String groupName = groupList[i].groupName 
																							%>
																								<option value="<%=groupName %>"><%=groupName %></option>
																							<%
																							}
																							%>
																							</select>
																						  </div>
																						</div>
																						</br>
																						<div class="row">
																							<div class="col-md-12">
																								<input type="submit" class="btn btn-primary" name="searchDashboard" value="Search"/>
																							</div>
																						</div>
																					</form>
																				</div>
																			</div>
																		</td>
																	</tr>
																	<!-- bhanu code ends -->
																	
																	<tr>
																		<td>
																			
																		</td>
																	</tr>
																	
																	<tr><td>
																		<br><br>
																		
																		<!-- bhanu code start; date: 13-07-2017 -->
																		<%
																			def sdf1 = new SimpleDateFormat("yyyy-MM-dd")
																			def sdf2 = new SimpleDateFormat("dd/MM/yyyy")
																			def fDate, tDate
																			def fDateStr = ""
																			def tDateStr = ""
																			if(fromDateStr && toDateStr){
																			fDate = sdf1.parse(fromDateStr)
																			tDate = sdf1.parse(toDateStr)
																			}else if(fromDate && toDate){
																			fDate = sdf1.parse(fromDate)
																			tDate = sdf1.parse(toDate)
																			}
																			if(fDate && tDate){
																			fDateStr = sdf2.format(fDate)
																			tDateStr = sdf2.format(tDate)
																			}
																		%>
																		<div class="row">
																			<div class="col-md-12 text-center">
																				<table width="100%" height="30px" style="background-color: #f1f1f1">
																					<tr>
																						<td>
																							From : <%= fDateStr %>
																						</td>
																						<td>
																							To : <%= tDateStr %>
																						</td>
																						<td>
																						Regional Office : <%= regionalOffice %>
																						</td>
																						
																						
																					</tr>
																				</table>
																			</div>
																		</div>
																		<br>
																		<!-- bhanu code ends -->
																		
																		
																		<!-- bhanu code start; date: 29-05-2017  column 2-->
																		
																		<div class="row text-center" >
																			
																			<div class="col-md-12 ">
																				<div class="panel panel-primary blank">
																					<table class="txt" width="100%" border="1">
																						<tr><td>
																							<table border="1" width="100%" style="border-bottom: none; border-top: none; border-left: none; border-right: none;">
																								
																								<tr>
																									<td width="11%" style="font-size: x-large; color: black; background-color:#E5B7B7">CTO</td>
																									<td>
																										<table border="1" width="100%">
																											<tr>
																												<td rowspan="2" style="font-size: large; color: black; background-color:#bf900c4a">Category</td>
																												<td colspan="2" rowspan="2" style="font-size: large; color: black; background-color: #8EB3E5">No. of Received Application </td>
																												<td colspan="2"
																												style="font-size: large; color: black; background-color: #C0D497">
																													No. of Granted
																													Applications
																												</td>
																												<td colspan="2"
																												style="font-size: large; color: black; background-color: #DCEDF4">
																													No. of Rejected
																													Applications
																												</td>
																												<td colspan="2"
																												style="font-size: large; color: black; background-color: #B0A2C6">
																													No. of Pending
																													Applications
																												</td>
																											</tr>
																											<tr>
																												
																												<td style="font-size: large; color: black; background-color: #92C8D9">
																													Within
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #BBC097">
																													Beyond
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #92C8D9">
																													Within
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #BBC097">
																													Beyond
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #92C8D9">
																													Within
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #BBC097">
																													Beyond
																													Time
																												</td>
																											</tr>
																											
																											<tr>
																												
																												<td  style="font-size: large; color: black; background-color:
																												#bf900c4a">Red (L&M)
																												</td>
																												<td colspan="2" style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMReceivedCount%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMGrantedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMGrantedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMRejectedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMPendingWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=redLM&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedLMPendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																											<td  style="font-size: large; color: black; background-color:
																											#bf900c4a">Red (S)
																											</td>
																											<td colspan="2" style="font-size: large; color: blue">
																												<a
																												href="#" class="ApplicationCountAllModule"
																												onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																													<%=ctoRedReceivedCount%>
																												</a>
																											</td>
																											<td style="font-size: large; color: blue">
																												<a
																												href="#" class="ApplicationCountAllModule"
																												onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																													<%=ctoRedGrantedWithinTime%>
																												</a>
																											</td>
																											<td style="font-size: large; color: blue">
																												<a
																												href="#" class="ApplicationCountAllModule"
																												onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																													<%=ctoRedGrantedBeyondTime%>
																												</a>
																											</td>
																											<td style="font-size: large; color: blue">
																												<a
																												href="#" class="ApplicationCountAllModule"
																												onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=4&&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																													<%=ctoRedRejectedWithinTime%>
																												</a>
																											</td>
																											<td style="font-size: large; color: blue">
																												<a
																												href="#" class="ApplicationCountAllModule"
																												onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																													<%=ctoRedRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedPendingWithinTime%>
																													</a>
																													</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=red&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoRedPendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																											
																											<tr>
																												<td  style="font-size: large; color: black; background-color:
																												#bf900c4a">Orange
																												</td>
																												<td colspan="2" style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangeReceivedCount%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangeGrantedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangeGrantedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangeRejectedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangeRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangePendingWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=orange&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoOrangePendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																											<tr>
																												<td  style="font-size: large; color: black; background-color:
																												#bf900c4a">Green
																												</td>
																												<td colspan="2" style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenReceivedCount%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenGrantedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenGrantedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenRejectedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenPendingWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cto&cat=green&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=ctoGreenPendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																										</table>
																									</td>
																								</tr>
																								
																							</table>
																						</td>
																						</tr>
																						
																						<tr><td>
																							<table border="1" width="100%" style="border-bottom: none; border-top: none; border-left: none; border-right: none;">
																								
																								<tr>
																									
																									
																									<td width="11%" style="font-size: x-large; color: black; background-color:#7dd37c87">
																										CTE
																									</td>
																									<td>
																										<table border="1" width="100%"
																										>
																											<tr>
																												<td rowspan="2" style="font-size: large; color: black; background-color:
																												#bf900c4a">
																													Category
																												</td>
																												<td colspan="2" rowspan="2" style="font-size: large; color: black; background-color:
																												#8EB3E5">No. of Received
																													Application
																												</td>
																												<td colspan="2"
																												style="font-size: large; color: black; background-color: #C0D497">
																													No. of Granted
																													Applications
																												</td>
																												<td colspan="2"
																												style="font-size: large; color: black; background-color: #DCEDF4">
																													No. of Rejected
																													Applications
																												</td>
																												<td colspan="2"
																												style="font-size: large; color: black; background-color: #B0A2C6">
																													No. of Pending
																													Applications
																												</td>
																											</tr>
																											<tr>
																												
																												<td style="font-size: large; color: black; background-color: #92C8D9">
																													Within
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #BBC097">
																													Beyond
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #92C8D9">
																													Within
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #BBC097">
																													Beyond
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #92C8D9">
																													Within
																													Time
																												</td>
																												<td style="font-size: large; color: black; background-color: #BBC097">
																													Beyond
																													Time
																												</td>
																											</tr>
																											
																											<tr>
																												<td  style="font-size: large; color: black; background-color:
																												#bf900c4a">Red
																												</td>
																												<td colspan="2" style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedReceivedCount%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedGrantedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedGrantedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedRejectedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedPendingWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=red&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteRedPendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																											
																											<tr>
																												<td  style="font-size: large; color: black; background-color:
																												#bf900c4a">Orange
																												</td>
																												<td colspan="2" style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangeReceivedCount%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangeGrantedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangeGrantedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangeRejectedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangeRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangePendingWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=orange&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteOrangePendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																											<tr>
																												<td  style="font-size: large; color: black; background-color:
																												#bf900c4a">Green
																												</td>
																												<td colspan="2" style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenReceivedCount%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenGrantedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenGrantedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenRejectedWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenRejectedBeyondTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenPendingWithinTime%>
																													</a>
																												</td>
																												<td style="font-size: large; color: blue">
																													<a
																													href="#" class="ApplicationCountAllModule"
																													onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=cte&cat=green&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																														<%=cteGreenPendingBeyondTime%>
																													</a>
																												</td>
																											</tr>
																											
																										</table>
																									</td>
																								</tr>
																								
																							</table>
																						</td>
																						</tr>
																						
																						<tr>
																							<td  style="background-color: #f1f1f1">
																								<table border="1" width="100%" style="border-bottom: none; border-left: none; border-right: none; ">
																									<tr>
																										<td width="11%" style="font-size: x-large; color: black; background-color:#A6A6A6">
																										HWM</td>
																										<td>
																											<table border="1" width="100%">
																												<tr>
																													<td colspan="2" style="font-size: large; color: black; background-color: #8BB4E6">No. of Received
																													Application</td>
																													<td colspan="2" style="font-size: large; color: black; background-color: #D0E3AB">No. of Granted
																													Applications</td>
																													<td colspan="2" style="font-size: large; color: black; background-color: #DFEDF2">No. of Rejected
																													Applications</td>
																													<td colspan="2" style="font-size: large; color: black; background-color: #B3A1C3">No. of Pending
																													Applications</td>
																												</tr>
																												<tr>
																													<td colspan="2" rowspan="2" style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=1&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmReceivedCount%>
																														</a>
																														
																														
																														
																													</td>
																													<td style="font-size: large; color: black; background-color: #95CEE3">
																														Within
																														Time
																													</td>
																													<td style="font-size: large; color: black; background-color: #C4BD94">
																														Beyond
																														Time
																													</td>
																													<td style="font-size: large; color: black; background-color: #95CEE3">
																														Within
																														Time
																													</td>
																													<td style="font-size: large; color: black; background-color: #C4BD94">
																														Beyond
																														Time
																													</td>
																													<td style="font-size: large; color: black; background-color: #95CEE3">
																														Within
																														Time
																													</td>
																													<td style="font-size: large; color: black; background-color: #C4BD94">
																														Beyond
																														Time
																													</td>
																												</tr>
																												<tr>
																													
																													<td style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=2&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmGrantedWithinTime%>
																														</a>
																														
																														
																													</td>
																													<td style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=3&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmGrantedBeyondTime%>
																														</a>
																														
																														
																													</td>
																													<td style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=4&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmRejectedWithinTime%>
																														</a>
																														
																														
																													</td>
																													<td style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=5&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmRejectedBeyondTime%>
																														</a>
																														
																														
																													</td>
																													<td style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=6&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmPendingWithinTime%>
																														</a>
																														
																														
																													</td>
																													<td style="font-size: large; color: blue">
																														
																														<a
																														href="#" class="ApplicationCountAllModule"
																														onclick="window.open('<%=request.getContextPath()%>/allReports/popApplicationCountAllModuleCto?type=hwm&cat=green&number=7&fromDateStr=<%= fromDateStr %>&toDateStr=<%= toDateStr %>&groupId=<%= groupId %>'  , 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
																															<%=hwmPendingBeyondTime%>
																														</a>
																														
																														
																													</td>
																												</tr>
																											</table>
																										</td>
																									</tr>
																								</table>
																							</td>
																						</tr>
																					</table>
																					
																				</div>
																				
																			</div>
																			
																			
																		</div>
																		
																		
																		
																		
																		<!-- bhanu code ends; -->
																	</td></tr>
																	<tr height="15px">
																	</tr>
																	
																	
																</table>
																
																
															</div>
														</div>
														
													</div>
													
													
												</td>
											</tr>
										</table>
										
										
										
									</div>
									
								</div>
							</td>
							<td width="132" align="left" valign="top">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
			
		</table>
		
	</td>
</tr>
<!-- code for spcb Footer -->
<g:include controller="userMaster" action="showSpcbFooter"/>
</table>
</td>
</tr>
</table>
</td>
</tr>
<!-- code for spcb Footer -->
%{--<g:include controller="userMaster" action="showSpcbFooter"/>--}%
</table>
</td>
</tr>
</table>