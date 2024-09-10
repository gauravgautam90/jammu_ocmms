<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<calendar:resources lang="en" theme="aqua"/>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'calendar.css')}" />





<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print2.css' )}" media="print2" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print3.css' )}" media="print3" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>

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
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}')
		;
	padding-left: 23px;
	padding-right: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.qwe123:hover {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' gray_bg.gif ')}')
		;
}

.blue {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_gray.gif ')}')
		;
	padding-left: 30px;
	padding-right: 27px;
	padding-top: 5px;
	padding-bottom: 7px;
}

.blue:hover {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}')
		;
}
-->
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();%>

<g:javascript library='scriptaculous' />
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
			 }
</g:javascript>





<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=500px,width=800px,scrollbars=1');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>




<% 
	String cont2=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont2+"/index.gsp")	;	
	 } %>


 <script type="text/javascript">
function show_menu(id)
{
	if(document.getElementById(id).style.display=="block")
	{
		//hide_menu(id);
	}
	else
	{
		document.getElementById(id).style.display="block";
	}
}
function hide_menu(id)
{
document.getElementById(id).style.display="none";
}
</script>



</head>

<body>
<table width="1003" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="91" align="left" valign="top" class="bgtop"><!-- code for spcbHeader  -->
				<g:include controller="userMaster" action="showSpcbHeader" /></td>
			</tr>
			<tr>
				<td height="32" align="left" valign="top"
					background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
				<!-- code for menuAdminHorizontal--> <g:include
					controller="userMaster" action="showAdminMenuHorizontal" /></td>
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
								<td><img
									src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778"
									height="134" /></td>
							</tr>

							<%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aab=(UserProfile)session.getAttribute("userprof");
             		  firstname=aab.employeeFirstName;
           		  lastName=aab.employeeLastName;
           		  access=um.accessLevel;

		}	

		else
			{
				if(  (IndUser)session.getAttribute("indUser")  )

					{
						IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 indname=ind.indName;

					}	
				else
					{
						decVar=false;
						
					}
			}




						
				
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>

							<tr>
								<td height="24" bgcolor="#EEEEF3">
								<table width="100%">
									<tr bgcolor="#4C8BC0">
										<td class="top-lnks">
										<table width="100%">

											<% if((UserMaster)session.getAttribute("userMaster"))
{
%>

											<tr bgcolor="#4C8BC0">
												<td class="top-lnks">
												<table width="100%">
													<tr height="10px">
														<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
														<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %>
														</td>
													</tr>
												</table>
												</td>
											</tr>

											<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
											<tr bgcolor="#4C8BC0">
												<td class="top-lnks">
												<table width="100%">
													<tr height="10px">
														<td>Welcome <%=indname %></td>
														<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %>
														</td>
													</tr>
												</table>
												</td>
											</tr>

											<% } %>

										</table>
										</td>
									</tr>
								<tr>


<td>
<FONT SIZE="4" FACE="courier" COLOR=red><MARQUEE WIDTH=100% BEHAVIOR=left onmouseover="this.stop();" onmouseout="this.start();" >Note: Summarized E-Waste Application Details are Visible only of last 90 days. For more details please search by below Application Search Criteria.</MARQUEE></FONT>

</td>
</tr>								</table>
								</td>
							</tr>
							<tr>
								<td height="0" align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<!-- Div area for errors-->
										<td align="center" valign="top">
										<div
											style="width: 400px; height: 20px; vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
										</g:if> <g:hasErrors bean="${groupMasterInstance}">
											<div class="errors"><g:renderErrors
												bean="${groupMasterInstance}" as="list" /></div>
										</g:hasErrors> </span></div>
										</td>
									</tr>
									<!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
									<tr>
										<td height="0" align="left" valign="top">
										<table width="778" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="82" align="left" valign="top">&nbsp;</td>
												<td align="left" valign="top">
												<div style="padding: 0px 0px 0px 0px;"><br />

												<FORM id="myForm" name=myForm action="search" method="post">

												<div style="" :1pxsolidgray; width:720px; margin-bottom: 1em; padding: 10px" >





												<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
												<table width="95%" border="0" align="center" cellpadding="0"
													cellspacing="0" id="countrytabs">
													<tr>
														<td width="11"><img
															src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
															width="11" height="27" /></td>
														<td width="" align="left"
															background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
															class="top-lnks"><a href="#" rel="country1">Search</a></td>
														<td width="11" valign="bottom"><img
															src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
															width="11" height="27" /></td>
														<td width="479" align="right"></td>
													</tr>
												</table>


															




												<div id="country1">




												<table width="95%" border="0" align="center" cellpadding="2"
													cellspacing="1" class="tblbdr">




													<tr bgcolor="#E8F6F9">
														<td width="15%" align="left" class="headngblue">Start
														Date:*</td>
														<td width="35%" align="left">
														 <calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
														
												<!-- 		<input type="text"
															id="start_date" name="start_date" class="txt4" /> <script
															language="JavaScript">
									new tcal ({
										// form name
										'formname': 'myForm',
										// input name
										'controlname': 'start_date'
									});
								
									</script>  -->
									
									</td>



														<td width="15%" align="left" class="headngblue">Ending
														Date:*</td>
														<td align="left" width="35%">
															<calendar:datePicker name="end_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
													<!-- 	<input type="text"
															id="end_date" name="end_date" class="txt4" /> <script
															language="JavaScript">
							new tcal ({
								// form name
								'formname': 'myForm',
								// input name
								'controlname': 'end_date'
							});
						
							</script>  -->
							
							</td>
													</tr>


													<tr bgcolor="#E8F6F9">
														<td align="left" class="headngblue">Category:</td>
														<td align="left"><g:select class="txt4"
															from="${['RED','ORANGE','GREEN']}"
															name="category" noSelection="${['xyz':'Not Selected']}"></g:select>
														</td>



														<td align="left" class="headngblue">Status:</td>
														<td align="left"><select class="txt4" name="status">
															<option value="xyz">Not Selected</option>
															<option value="Inprogress">In-Complete</option>
															<option value="approved">E-Waste Granted</option>
															<option value="rejected">E-Waste Rejected</option>
															<option value="unattended">Unattended</option>
															
														</select> 
														</td>
													</tr>
													
													<tr bgcolor="#E8F6F9">
														
													<td align="left" class="headngblue" colspan="1" >Application Type:</td>
														<td align="left" colspan="3" ><select class="txt4" name="statusType">
															<option value="xyz">Not Selected</option>
															<option value="EWaste">E-Waste</option>
															
															
															
														</select> 
														</td>
														
													</tr>

												</table>
												<table width="95%" align="center">
		  <tr >
			<td align="right" colspan="2"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
		  </tr>
		</table>
		</form>
		<g:if test="${linksch}">
		<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="eWaste"
																action="eWasteSummary" params="[checkVar: 'received']">${receivedCount}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="eWaste"
																action="eWasteSummary" params="[checkVar: 'completed']">${completedCount}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="eWaste"
																action="eWasteSummary" params="[checkVar: 'pending']"> ${pendingCount}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="eWaste"
																action="eWasteSummary" params="[checkVar: 'orphan']"> ${unattendedCount}</g:link></td>
														</tr>
														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														
													</table>
													</g:if>

																<%		
																	String fontColor="blue";
																 if(params.checkVar=="pending"){
																
																   	 fontColor="red";
																   		
																 }else if(params.checkVar=="completed"){
																	 fontColor="green";
																 }
																 
																 else
																 {
																 fontColor="purple";
																 }
       															%>



							<g:if test="${checkVariable}">
									<table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:finalListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
									<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                 						<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	        <th align="center" class="headngblue" >Status</th>
                   	       	 <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
                   	    
                        </tr>
                    </thead>

                    <g:each in="${applicationPendingCountB}" status="i" var="wasteManagementInst" >
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><g:link controller="eWaste"  action="show" id="${wasteManagementInst.id}"><u><b>${fieldValue(bean:wasteManagementInst, field:'id')}</g:link></td>
                        
                          <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=strDate%></font></td>
                          
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${fieldValue(bean:wasteManagementInst, field:'industryReg')}</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">E-Waste</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=statusListB.get(i)%></font></td>
                        	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${pendingWithRoleB.get(i) }(${pendingWithB.get(i) })</font></td>
                       
                           
                          </tr>
                    </g:each>
					
                   
					
                </table>
		
		
		</g:if>
		<g:if test="${checkVariableUn}">
									<table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:finalListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
									<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                 						<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	        <th align="center" class="headngblue" >Status</th>
                   	       	
                        </tr>
                    </thead>

                    <g:each in="${applicationUnattendedCountB}" status="i" var="wasteManagementInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><g:link controller="eWaste"  action="show" id="${wasteManagementInst.id}"><b><u>${fieldValue(bean:wasteManagementInst, field:'id')}</u></b></g:link></td>
                        
                          <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=strDate%></font></td>
                          
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${fieldValue(bean:wasteManagementInst, field:'industryReg')}</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">E-Waste</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=statusListB.get(i)%></font></td>
                        	
                           
                          </tr>
                    </g:each>
					
                   
					
                </table>
		<table width="95%" align="center">
																<tr>
																	<td align="center" colspan="0"><g:link
																		action="routeUnattended">
																		<font face="Verdana" size="1" color="red"><b><u>Please
																		click here to route the applications</u></b></font>
																	</g:link></td>
																</tr>
															</table>
		
		</g:if>
		<g:if test="${checkVariableCom}">
									<table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:finalListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
									<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                 						<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	        <th align="center" class="headngblue" >Status</th>
                   	       	 <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
                   	    
                        </tr>
                    </thead>

                    <g:each in="${applicationCompletedCountB}" status="i" var="wasteManagementInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><g:link controller="eWaste"  action="show" id="${wasteManagementInst.id}"><b><u>${fieldValue(bean:wasteManagementInst, field:'id')}</u></b></g:link></td>
                        
                          <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=strDate%></td>
                          
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${fieldValue(bean:wasteManagementInst, field:'industryReg')}</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">E-Waste</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=statusListB.get(i)%></font></td>
                        	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${pendingWithRoleB.get(i) }(${pendingWithB.get(i) })</font></td>
                       
                           
                          </tr>
                    </g:each>
					
                   
					
                </table>
		
		
		</g:if>
		<g:if test="${checkVariableRec}">
									<table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:finalListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
									<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                 						<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	        <th align="center" class="headngblue" >Status</th>
                   	       	 <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
                   	    
                        </tr>
                    </thead>
					
                    <g:each in="${applicationReceivedCountB}" status="i" var="wasteManagementInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        <%
                       String fontColor1="blue";
                       if(statusListB.get(i)=="pending")
                       {
                       	fontColor1 = "red";
                       }
                       else if(statusListB.get(i)=="approved")
                       {
                       	fontColor1 = "green";
                       }
                       else
                       {
                       fontColor1 = "purple";
                       }
                       %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><g:link controller="eWaste"  action="show" id="${wasteManagementInst.id}"><b><u>${fieldValue(bean:wasteManagementInst, field:'id')}</u></b></g:link></td>
                        
                          <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>"><%=strDate%></font></td>
                          
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>">${fieldValue(bean:wasteManagementInst, field:'industryReg')}</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>">E-Waste</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>"><%=statusListB.get(i)%></font></td>
                        	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>">${pendingWithRoleB.get(i) }(${pendingWithB.get(i) })</font></td>
                       
                           
                          </tr>
                    </g:each>
					
                  
                </table>
		
		
		</g:if>

<g:if test="${checkBio}">
								<table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:finalListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
									<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                 						<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	         <%if(status!="unattended"){ %>
                   	        <th align="center" class="headngblue" >Status</th>
                   	       	 <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
                   	    <%} %>
                        </tr>
                    </thead>

                    <g:each in="${bioList}" status="i" var="wasteManagementInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        
                        <%
                       String fontColor1="blue";
                       if(statusListB.get(i)=="pending")
                       {
                       	fontColor1 = "red";
                       }
                       else if(statusListB.get(i)=="approved")
                       {
                       	fontColor1 = "green";
                       }
                       else
                       {
                       fontColor1 = "purple";
                       }
                       %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><g:link controller="eWaste"  action="show" id="${wasteManagementInst.id}"><b><u>${fieldValue(bean:wasteManagementInst, field:'id')}</u></b></g:link></td>
                        
                          <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>"><%=strDate%></font></td>
                          
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>">${fieldValue(bean:wasteManagementInst, field:'industryReg')}</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>">E-Waste</font></td>
                        
                            <%if(status!="unattended"){ %>
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>"><%=statusListB.get(i)%></font></td>
                        	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor1%>">${pendingWithRoleB.get(i) }(${pendingWithB.get(i) })</font></td>
                       <%} %>
                           
                          </tr>
                    </g:each>
					
                   
					
                </table>
		
		
		</g:if>


												 <br />
												<br />
												</div>
												



												</div>

												<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
												</div>
												</td>
												<td width="82" align="left" valign="top">&nbsp;</td>
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
			<!-- code for spcb Footer -->
			<g:include controller="userMaster" action="showSpcbFooter" />
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


