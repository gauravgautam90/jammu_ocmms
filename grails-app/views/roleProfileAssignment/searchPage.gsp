<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<calendar:resources lang="en" theme="aqua"/>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>CPCC</title>

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
						<!-- code for menuAdmin--> <% UserMaster aa = (UserMaster)session.getAttribute("userMaster");
					String userType =	 aa.accessLevel;
					if(userType.equals("admin")) { %> <g:include
							controller="userMaster" action="showAdminMenu" /> <%} else{ %> <g:include
							controller="userMaster" action="showSpcbUserMenu" /> <% } %>
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
<FONT SIZE="4" FACE="courier" COLOR=red><MARQUEE WIDTH=100% BEHAVIOR=left onmouseover="this.stop();" onmouseout="this.start();" >Note: Summarized Consent Application Details are Visible only of last 90 days. For more details please search by below Application Search Criteria.</MARQUEE></FONT>

</td>
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
														 <calendar:datePicker name="start_date" years="1900,${Calendar.instance.get(Calendar.YEAR)}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
														
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
															<calendar:datePicker name="end_date" years="1900,${Calendar.instance.get(Calendar.YEAR)}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
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
															 from="${['RED','ORANGE','GREEN','WHITE']}"
															name="category"  noSelection="${['xyz':'Not Selected']}"></g:select>
														</td>



														<td align="left" class="headngblue">Status:</td>
														<td align="left"><select class="txt4" name="status">
															<option value="xyz">Not Selected</option>
															<option value="pending">In-Progress</option>
															<option value="approved">Consent Granted</option>
															<option value="rejected">Consent Rejected</option>
															<option value="orphan">Unattended</option>
															
														</select> <!-- 	<g:select  from="${['pending','completed']}" name="status" noSelection="${['xyz':'Not Selected']}" ></g:select>  -->
														</td>
													</tr>

												</table>
												<table width="95%" align="center">
		  <tr >
			<td align="right" colspan="2"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
		  </tr>
		</table>
												<g:if test="${abc}">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'received']">${recTotal}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'completed']">${compTotal}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'pending']"> ${pendTotal}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'orphan']"> ${orphTotal}</g:link></td>
														</tr>
														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<%
       
       if(level=="Received Applications" || level=="Completed Applications"){%>
															<th align="center" class="headngblue">Status</th>
															<%} %>
															<%
       
       if(level=="Pending Applications"){%>
															<th align="center" class="headngblue">Pending With</th>
															<%} 
															
															if(level=="Completed Applications"){%>
															<th align="center" class="headngblue">Forwarded To</th>
															<%} %>

															<%
       
       if(level=="Pending Applications"){%>
															<th align="center" class="headngblue">Pending Since</th>
															<%} %>

															<%
       
       if(level=="Unattended Applications"){%>
															<th align="center" class="headngblue">Unattended
															Since</th>
															<%} %>

															<%
       
       if(level=="Completed Applications"){%>
															<th align="center" class="headngblue">Pending Since</th>
															<%} %>

														</tr>

														<g:each in="${abc}" status="i" var="abc">
													<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        }
								                        %>


															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="black";
																 if(level!="Completed Applications"){
																		int valPendingSince=(diffList.get(i)).toInteger();
																   		if(valPendingSince<=7)
																   		{
																   			fontColor="green";
																   		}
																   		if(valPendingSince>=7 && valPendingSince<=15)
																   		{
																   			fontColor="brown";
																   		}
																   		if(valPendingSince>15)
																   		{
																   			fontColor="red";
																   		}
																 }else{
																	 fontColor="green";
																 }
       															%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>
 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
                          

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																			Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																			Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}<br>
																			Mobile No:- ${fieldValue(bean:abc,field:'indUser.occMobile')}</font></td>
																	
																<%
       
       if(level=="Received Applications" ){%>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationStatus')}</font></td>
																<%} %>

<%
       
       if(level=="Completed Applications" ){
       
       String status=(pendingWithList.get(i)).applicationStatus;
       %>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=status %></font></td>
																<%} %>
																<%
       
       if(level=="Pending Applications"){
       
    	
   		String str=(pendingWithList.get(i)).pendingWith;
   		String str1=(rolependingWithList.get(i)).roleName;
   		
       %>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=str1 %>(<%=str %>)</font></td>
																<%} %>

																<%
       
       if(level=="Completed Applications"){
       
    	
   		String strC=(pendingWithList.get(i)).pendingWith;
   		String str1C=(rolependingWithList.get(i)).roleName;
   		
       %>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=str1C %>(<%=strC %>)</font></td>
																<%} %>

																<%
       
       if(level=="Pending Applications"){
       
    	
   		String strPendingSince=(diffList.get(i));
   		
       %>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=strPendingSince %>
																&nbsp;Days</font></td>
																<%} %>

																<%
       
       if(level=="Unattended Applications"){
       
    
   		String strPendingSince=(diffList.get(i));
   	%>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=strPendingSince %>
																&nbsp;Days</font></td>
																<%} %>

																<%
       
       if(level=="Completed Applications"){
       
    	
   		String strPendingSince=(diffList.get(i));
   		
       %>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>0 &nbsp;Days</font></td>
																<%} %>

															</tr>
														</g:each>

														<tr>
															<td colspan="7"><g:paginate
																controller="roleProfileAssignment"
																action="searchUtility" total="${total}"
																params="${paramList}" /></td>
														</tr>
														<tr>
															<!-- @varun -->
															<td colspan="7">
															<%if(level.equals("Unattended Applications")){%>

															<table width="95%" align="center">
																<tr>
																	<td align="center" colspan="0"><g:link
																		action="routeUnattended">
																		<font face="Verdana" size="1" color="red"><b><u>Please
																		click here to route the applications</u></b></font>
																	</g:link></td>
																</tr>
															</table>

															<%}%>
															</td>
														</tr>

													</table>


												</g:if> <g:if test="${viewLevels}">
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'received']">${recTotal}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'completed']">${compTotal}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'pending']"> ${pendTotal}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'orphan']"> ${orphTotal}</g:link></td>
														</tr>
														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<!-- 	<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}else
{
out.print("class=headngblue");
}
%>
																>${level}</td>
														 <td align="right"><% if(level.equals("Received Applications")){ %><a href="popupex.html" onclick="return popitup('../roleProfileAssignment/received')"><span class="headngblue">Print Preview</span></a><% }else { %><a href="popupex.html" onclick="return popitup('../roleProfileAssignment/popListSummary')"><span class="headngblue">Print Preview</span> </a><%} %></td></tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Id
															</th>

															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															Name</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															Type</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															For</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															Date</th>

															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Certificate
															For</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">District</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Category</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Details of applicant</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Status</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Forwarded To/Pending With</th>
														</tr>

														<g:each in="${abc3}" status="i" var="instance">
													<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        }
								                        %>
															<%String classs=null;
                    	if(instance.applicationStatus=="pending"){ ;%>
															<tr bgcolor="#FF4A85">

																<% }else if(instance.applicationStatus=="orphan"){ ;%>
															
															<tr bgcolor="purple">
																<%} else { ;%>
															
															<tr bgcolor="green">
																<%}%>
																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}"><b><u>${instance?.application.id}</u></b></g:link></td>

																<td align="center" height="25" class="reportTxt">${instance?.application.applicationName}</td>

																<td align="center" height="25" class="reportTxt">${instance?.application.applicationType}</td>
  <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="reportTxt" >Air/Water</td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="reportTxt" >Air/Water/HWM</td>
                            
                             <%}%>
															

																<td align="center" height="25" class="reportTxt">${instance?.application.actualApplicationDate}</td>
																<td align="center" height="25" class="reportTxt"><%=consentFor%></td>

																<td align="center" height="25" class="reportTxt">${instance?.application.indUser.district.districtName}</td>
																<td align="center" height="25" class="reportTxt">${instance?.application.indUser.category.name}</td>
																<td align="center" height="25" class="reportTxt">Address:- ${instance?.application.indUser.occAddress}<br>
																Email ID:- ${instance?.application.indUser.occEmail}<br>
																Phone No:- ${instance?.application.indUser.occPhoneNo}<br>
																Mobile No:- ${instance?.application.indUser.occMobile}
																</font></td>
																
																
																<td align="center" height="25" class="reportTxt">${instance?.applicationStatus}</td>
																<td align="center" height="25" class="reportTxt">${instance?.role?.roleName}(${instance?.pendingWith})</td>


															</tr>
														</g:each>

														

														<tr>
															<td colspan="7"><g:paginate
																controller="roleProfileAssignment"
																action="searchUtility" total="${total}"
																params="${paramList}" /></td>
																
														</tr> -->


													</table>


												</g:if> <g:if test="${abc3}">
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'received']">${recTotal}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'completed']">${compTotal}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'pending']"> ${pendTotal}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'orphan']"> ${orphTotal}</g:link></td>
														</tr>
														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}else
{
out.print("class=headngblue");
}
%>>${level}</td>
															<td align="right">
															<% if(level.equals("Received Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/received')"><span
																class="headngblue">Print Preview</span></a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Id
															</th>

															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															Name</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															Type</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															For</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Application
															Date</th>

															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Certificate
															For</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">District</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Category</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Details of applicant</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Status</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Forwarded
															To /Pending With</th>
															<th bgcolor="#1F6FB7" align="center" class="reportHeader">Completed
															Since/ Pending Since</th>
														</tr>

														<g:each in="${abc3}" status="i" var="instance">
												<%		String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        }
								                        %>

															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="black";
																int valPendingSince=(diffList.get(i)).toInteger();
																	
																if(instance?.applicationStatus!="pending"){ 
																	fontColor="green";
																}else{
																if(valPendingSince<7)
																   		{
																   			fontColor="green";
																   		}
																   		if(valPendingSince>=7 && valPendingSince<=15)
																   		{
																   			fontColor="brown";
																   		}
																   		if(valPendingSince>15)
																   		{
																   			fontColor="red";
																   		}
																}
       															%>

																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>
												 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}<br>
																	Mobile No:- ${instance?.application.indUser.occMobile}</font></td>
																	
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>


																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>> <% if(instance.applicationStatus!="pending"){%>0<%}else{ %>${diffList.get(i)
																}<%} %> &nbsp;Days</font></td>


															</tr>

														</g:each>



														<tr>
															<td colspan="7"><g:paginate
																controller="roleProfileAssignment"
																action="searchUtility" total="${total}"
																params="${paramList}" /></td>

														</tr>


													</table>


												</g:if> <g:if test="${abc1}">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:fullListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${abc1}" status="i" var="instance">
													<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="black";
																int valPendingSince=(diffList.get(i)).toInteger();
																	
																if(instance?.applicationStatus!="pending"){ 
																	fontColor="green";
																}else{
																if(valPendingSince<7)
																   		{
																   			fontColor="green";
																   		}
																   		if(valPendingSince>=7 && valPendingSince<=15)
																   		{
																   			fontColor="brown";
																   		}
																   		if(valPendingSince>15)
																   		{
																   			fontColor="red";
																   		}
																}
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

															 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}<br>
																	Mobile No:-${instance?.application.indUser.occMobile}</font></td>
																	
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>
																<% if(instance.applicationStatus!="pending"){%>0<%}else{ %>${diffList.get(i)
																}<%} %> &nbsp;Days</font></td>

															</tr>
														</g:each>

														<tr>
															<td colspan="7"><g:paginate
																controller="roleProfileAssignment" action="search"
																total="${total}" params="${paramList}" /></td>
														</tr>

													</table>


												</g:if> <!-- code for colapse of unattended --> <g:if
													test="${pendCheck}">

													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'received']">${recTotal}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'completed']">${compTotal}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'pending']"> ${pendTotal}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'orphan']"> ${orphTotal}</g:link></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application not attended since 15 days or more]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main3" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_more15');">[+]
															</span><span
																id="span_hide_main3" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_more15');">&nbsp;[-]
															</span>
															</td>
														</tr>
													</table>
													<div id="div_hide_more15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPageUnattended" params="[listVal:after15List,level:'after15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>




														</tr>

														<g:each in="${after15List}" status="i" var="abc">

														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>


															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="red";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>


															 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}<br>
																	Mobile No:- ${fieldValue(bean:abc,field:'indUser.occMobile')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbetmore15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															not attended with in limit from 7 to 15 days]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main2" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_bet7to15');"> [+]</span><span
																id="span_hide_main2" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_bet7to15');"> &nbsp;[-]</span></td>
														</tr>
													</table>

													<div id="div_hide_bet7to15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
														<!-- 	<% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															 <a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPageUnattended" params="[listVal:bet7To15List,level:'bet7to15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>




														</tr>

														<g:each in="${bet7To15List}" status="i" var="abc">

														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>


															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="brown";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}<br>
																	Mobile No:- ${fieldValue(bean:abc,field:'indUser.occMobile')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbet7To15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															not attended since from 7 days or less]&nbsp;&nbsp;&nbsp;</span> <span
																id="span_show_main1" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_less7');">[+]</span><span
																id="span_hide_main1" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_less7');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_less7" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
														<!-- 	<% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															  <a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPageUnattended" params="[listVal:lessThan7List,level:'less7']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>


														</tr>

														<g:each in="${lessThan7List}" status="i" var="abc">

														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>


															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="green";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}<br>
																	Mobile No:- ${fieldValue(bean:abc,field:'indUser.occMobile')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListless7.get(i) }
																&nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>
												<table width="95%" align="center">
																<tr>
																	<td align="center" colspan="0"><g:link
																		action="routeUnattended">
																		<font face="Verdana" size="1" color="red"><b><u>Please
																		click here to route the applications</u></b></font>
																	</g:link></td>
																</tr>
															</table>

												</g:if> <!-- code for colapse of pending --> <g:if
													test="${pendvariabCheck}">

													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'received']">${recTotal}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'completed']">${compTotal}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'pending']"> ${pendTotal}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="roleProfileAssignment"
																action="searchUtility" params="[checkVar: 'orphan']"> ${orphTotal}</g:link></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending since 15 days or more]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main4" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_morePend15');">[+]</span><span
																id="span_hide_main4" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_morePend15');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_morePend15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %>  
															<g:createLink action="show" params="[foo: 'bar', boo: 'far']"/>
															-->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPage" params="[listVal:after15List,level:'after15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															 <!-- <a href="#" onclick="window.print();return false;" ><img  height="25" width="25" src="${createLinkTo(dir:'images',file:'Print3.gif')}" border="0" align="center" alt="Print this Form" >Print</a> -->
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="print tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>




														</tr>

														<g:each in="${after15List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>



															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="red";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${after15ListRole.get(i)
																} &nbsp;(${after15ListRoleEmployee.get(i) })</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbetmore15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending with in limit from 7 to 15 days]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_mainpend" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_Pendbet7to15');"> [+]</span><span
																id="span_hide_mainpend" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_Pendbet7to15');"> &nbsp;[-]</span></td>
														</tr>
													</table>

													<div id="div_hide_Pendbet7to15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPage" params="[listVal: bet7To15List ,level:'bet7to15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															<!--  <a href="#" onclick="window.print();return false;" ><img  height="25" width="25" src="${createLinkTo(dir:'images',file:'Print3.gif')}" border="0" align="center" alt="Print this Form" >Print</a> -->
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="print2 tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>




														</tr>

														<g:each in="${bet7To15List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>



															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="brown";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${bet7To15ListRole.get(i) }
																&nbsp;(${bet7To15ListRoleEmployee.get(i) })</font></td>
																
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbet7To15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending since from 7 days or less]&nbsp;&nbsp;&nbsp; </span><span
																id="span_show_main7less" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_Pendless7');">[+]</span><span
																id="span_hide_main7less" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_Pendless7');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_Pendless7" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!--  <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPage" params="[listVal:lessThan7List,level:'less7']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															<!-- <a href="#" onclick="window.print();return false;" ><img  height="25" width="25" src="${createLinkTo(dir:'images',file:'Print3.gif')}" border="0" align="center" alt="Print this Form" >Print</a> -->
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="print3 tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>


														</tr>

														<g:each in="${lessThan7List}" status="i" var="abc">

														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>


															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="green";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${lessThan7ListRole.get(i) }
																&nbsp;(${lessThan7ListRoleEmployee.get(i) })</font></td>
																
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListless7.get(i) }
																&nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>


												</g:if> <!-- code for searching through criteria Pending without category -->

												<g:if test="${searchCriteriaOne}">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending since 15 days or more]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main15" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_SearchPendmore15');">[+]</span><span
																id="span_hide_main15" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_SearchPendmore15');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_SearchPendmore15" style="display: none;">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="searchPrintPending" params="[listVal:after15List,level:'after15',startDate1:${startDate1},endDate1:{endDate1}]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${after15List}" status="i" var="instance">
														<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="red";
																
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

																 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbetmore15.get(i)
																} &nbsp;Days</font></td>

															</tr>
														</g:each>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending between 7 To 15 days ]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main7to15" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_SearchPendbet7to15');">[+]</span><span
																id="span_hide_main7to15" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_SearchPendbet7to15');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_SearchPendbet7to15"
														style="display: none;">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="searchPrintPending" params="[listVal:bet7To15List,level:'bet7to15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${bet7To15List}" status="i" var="instance">
														<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="brown";
																
																
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

																 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbet7To15
																.get(i) } &nbsp;Days</font></td>

															</tr>
														</g:each>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending since from 7 days or less]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main6" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_SearchPendless7');"> [+]</span><span
																id="span_hide_main6" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_SearchPendless7');">&nbsp; [-]</span></td>
														</tr>
													</table>
													<div id="div_hide_SearchPendless7" style="display: none;">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="searchPrintPending" params="[listVal:lessThan7List,level:'less7']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${lessThan7List}" status="i" var="instance">
														<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="green";
															
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

															 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListless7.get(i) }
																&nbsp;Days</font></td>

															</tr>
														</g:each>
													</table>
													</div>

												</g:if> <!-- closed --> <!-- code for searching through criteria Pending -->

												<g:if test="${searchCriteriaPending}">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending since 15 days or more]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show8_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_SearchPendmore15');"> [+]</span><span
																id="span_hide8_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_SearchPendmore15');">&nbsp; [-]</span></td>
														</tr>
													</table>
													<div id="div_hide_SearchPendmore15" style="display: none;">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="searchPrintPending" params="[listVal:after15List,level:'after15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${after15List}" status="i" var="instance">
														<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="red";
																
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

																 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbetmore15.get(i)
																} &nbsp;Days</font></td>

															</tr>
														</g:each>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending between 7 To 15 days]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_main11" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_SearchPendbet7to15');">[+]</span><span
																id="span_hide_main11" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_SearchPendbet7to15');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_SearchPendbet7to15"
														style="display: none;">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="searchPrintPending" params="[listVal:bet7To15List,level:'bet7to15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${bet7To15List}" status="i" var="instance">
														<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="brown";
																
																
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

																 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbet7To15
																.get(i) } &nbsp;Days</font></td>

															</tr>
														</g:each>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Pending since from 7 days or less ]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show_mainless7" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_SearchPendless7');">[+]</span><span
																id="span_hide_mainless7" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_SearchPendless7');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_SearchPendless7" style="display: none;">

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="8" align="right"><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="searchPrintPending" params="[listVal:lessThan7List,level:'less7']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td>
														</tr>


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Status</th>
															<th align="center" class="headngblue">Forwarded To
															/Pending With</th>
															<th align="center" class="headngblue">Pending Since</th>

														</tr>

														<g:each in="${lessThan7List}" status="i" var="instance">
														<%	String consentFor = instance.application.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>
															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

																<%		
																	String fontColor="green";
															
       															%>


																<td align="center" height="25" class="reportTxt"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${instance?.application.id}">
																	<b><u>${instance?.application.id}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationName}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.applicationType}</font></td>

																 <%if(instance?.application.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(instance?.application.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.actualApplicationDate}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.district.districtName}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.application.indUser.category.name}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${instance?.application.indUser.occAddress}<br>
																	Email ID:- ${instance?.application.indUser.occEmail}<br>
																	Phone No:- ${instance?.application.indUser.occPhoneNo}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${instance?.applicationStatus}</font></td>
																<td align="center" height="25" class=txt4><font
																	color=<%=fontColor %>>${instance?.role?.roleName}(${instance?.pendingWith})</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListless7.get(i) }
																&nbsp;Days</font></td>

															</tr>
														</g:each>
													</table>
													</div>

												</g:if> <!-- closed --> <!--  --> <g:if
													test="${searchCriteriaPendingNoStatus}">



													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Not attended since 15 days or more]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show15_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_more15');">[+]</span><span
																id="span_hide15_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_more15');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_more15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
														<!-- 	<% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printCondUnattended" params="[listVal:after15List,level:'after15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>




														</tr>

														<g:each in="${after15List}" status="i" var="abc">

														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>


															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="red";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>
 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbetmore15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Not attended with in limit from 7 to 15 days ]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show11_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_bet7to15');">[+]</span><span
																id="span_hide11_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_bet7to15');">&nbsp;[-]</span></td>
														</tr>
													</table>

													<div id="div_hide_bet7to15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															 <a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printCondUnattended" params="[listVal:bet7To15List,level:'bet7to15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>




														</tr>

														<g:each in="${bet7To15List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>



															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="brown";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>
 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbet7To15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Not attended since from 7 days or less ]&nbsp;&nbsp;&nbsp;</span><span
																id="span_hide_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_less7');">[+]</span><span
																id="span_hide_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_less7');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_less7" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
														<!-- 	<% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															 <a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printCondUnattended" params="[listVal:lessThan7List,level:'less7']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>


														</tr>

														<g:each in="${lessThan7List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>




															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="green";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

															 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListless7.get(i) }
																&nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>


												</g:if> <!--  --> <g:if
													test="${searchCriteriaOneUnattended}">



													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Not attended since 15 days or more]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show155_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_more15');">[+]</span><span
																id="span_hide155_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_more15');">&nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_more15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printCondUnattended" params="[listVal:after15List,level:'after15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>




														</tr>

														<g:each in="${after15List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>



															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="red";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbetmore15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>

													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Not attended with in limit from 7 to 15 days]&nbsp;&nbsp;&nbsp;</span><span
																id="span_hide_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_bet7to15');">[+] </span><span
																id="span_hide_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_bet7to15');">&nbsp;[-] </span></td>
														</tr>
													</table>

													<div id="div_hide_bet7to15" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
															<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printCondUnattended" params="[listVal:bet7To15List,level:'bet7to15']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>




														</tr>

														<g:each in="${bet7To15List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>



															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="brown";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListbet7To15.get(i)
																} &nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td><span
																style="font: normal 12px verdana; color: #1F6FB7;">[Application
															Not attended since from 7 days or less]&nbsp;&nbsp;&nbsp;</span><span
																id="span_show12_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:show_menu('div_hide_less7');">[+] </span><span
																id="span_hide12_main" style="font: normal 12px verdana; color: #1F6FB7;cursor: pointer;"
																onclick="javascript:hide_menu('div_hide_less7');"> &nbsp;[-]</span></td>
														</tr>
													</table>
													<div id="div_hide_less7" style="display: none;">
													<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">

														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														<tr>
															<td align="left"
																<%
       
       if(level.equals("Unattended Applications")){
	out.print("class=purpleTxt");
}else if(level.equals("Pending Applications")){
	out.print("class=redTxt");
}else if(level.equals("Completed Applications")){
	out.print("class=greenTxt");
}
else
{
out.print("class=headngblue");
}%>>${level}</td>
															<td align="right">
														<!-- <% if(level.equals("Unattended Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/orphan')"><span
																class="headngblue">Print Preview</span></a>
															<%}else if(level.equals("Pending Applications")){%><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/pending')"><span
																class="headngblue">Print Preview</span> </a>
															<%}else if(level.equals("Completed Applications")){ %><a
																href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/completed')">
															<span class="headngblue">Print Preview</span> </a>
															<% }else { %><a href="popupex.html"
																onclick="return popitup('../roleProfileAssignment/popListSummary')"><span
																class="headngblue">Print Preview</span> </a>
															<%} %> -->	
															<a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printCondUnattended" params="[listVal:lessThan7List,level:'less7']" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a>
															</td>
														</tr>
													</table>
													<table width="95%" border="0" align="center"
														cellpadding="1" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">


														<tr height="20" bgcolor="#A8DAF3">


															<th align="center" class="headngblue">Id</th>

															<th align="center" class="headngblue">Application
															Name</th>
															<th align="center" class="headngblue">Application
															Type</th>
															<th align="center" class="headngblue">Application
															For</th>
															<th align="center" class="headngblue">Application
															Date</th>

															<th align="center" class="headngblue">Certificate
															For</th>
															<th align="center" class="headngblue">District</th>
															<th align="center" class="headngblue">Category</th>
															<th align="center" class="headngblue">Details of applicant</th>
															<th align="center" class="headngblue">Unattended
															Since</th>


														</tr>

														<g:each in="${lessThan7List}" status="i" var="abc">
														<%	String consentFor = abc.certificateFor
									                     
								                        if(consentFor.equals("new")){
								                        consentFor="Fresh"
								                        }
								                        if(consentFor.equals("Modern")){
								                        consentFor = "Modernization "
								                        }
								                        if(consentFor.equals("expan")){
								                        consentFor = "Expansion"
								                        }
								                        if(consentFor.equals("reNew")){
								                         consentFor = "Renew"
								                        } %>



															<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																<%		
																	String fontColor="green";
																%>

																<td align="center" height="25" class="txt4"><g:link
																	action="doGetShow" controller="indApplicationDetails"
																	id="${abc.id}">
																	<b><u>${fieldValue(bean:abc, field:'id')}</u></b>
																</g:link></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationName')}</font></td>

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'applicationType')}</font></td>

																 <%if(abc.applicationType=="CTO"){ %>
                               
                            
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water</font></td>
                            
                             <%}%>
                             
                              <%if(abc.applicationType=="CTE"){ %>
                            <td align="center" height="25" class="txt4" ><font
																	color=<%=fontColor %>>Air/Water/HWM</font></td>
                            
                             <%}%>
												

																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																field:'actualApplicationDate')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>><%=consentFor%></font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.district.districtName')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${fieldValue(bean:abc,
																			field:'indUser.category.name')}</font></td>
																	<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
																	Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
																	Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</font></td>
																<td align="center" height="25" class="txt4"><font
																	color=<%=fontColor %>>${diffListless7.get(i) }
																&nbsp;Days</font></td>




															</tr>
														</g:each>
														<tr>
															<td>&nbsp;</td>
														</tr>
													</table>
													</div>


												</g:if> <br />
												<br />
												</div>
												</form>



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


