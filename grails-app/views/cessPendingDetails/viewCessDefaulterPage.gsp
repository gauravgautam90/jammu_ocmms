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
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'calendar_us.js')}"></script>


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
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" action="cessIndustryMenuVertical"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="cessAdminMenuVertical"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="cessEmpMenuVertical"/> 
				<%	}
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

												<FORM id="myForm" name=myForm action="viewCessDefaulter" method="post">

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
														<td align="left" class="headngblue">Month:</td>
														<td align="left"><g:select name="monthValue" from="${['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August','September', 'October', 'November', 'December']}" value="${monthVal}" class="txt4" />
														</td>


														<td align="left" class="headngblue">Year:</td>
														<td align="left">
														 <%Calendar cal1 = Calendar.getInstance(); 
															  int yearVal = cal1.get(Calendar.YEAR);
															%>
																<select name="yearValue">
																
																<% for (int i=1995;i<= yearVal;i++){ %>
											  						<option value=<%=i%>><%=i%></option>
											  						<%} %>
																</select>
														</td>
													</tr>

												</table>
												<table width="95%" align="center">
		  <tr >
			<td align="right" colspan="2"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
		  </tr>
		</table>
												<br />
												
												</div>
												</form>
									
									<g:if test="${noticeList}">
													 <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" >
			<tr height="20" bgcolor="white">


															<th colspan="3" align="Right" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/cessPendingDetails/popViewCessDefaulter', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
																										<span class="headngblue">Print Preview</span></a>
															</th>
				
															
														</tr>
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
															
			<thead >
                        
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	        <th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Notice sent Date</th>
							<th align="center" class="headngblue" >Description</th>
							<th align="center" class="headngblue" >Month</th> 
                   	        <th align="center" class="headngblue" >Year</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(noticeList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${noticeList}" status="i" var="cessPendingInstance">
                         <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(cessPendingInstance.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          
                            <td align="center" height="25" class="txt4"  ><u><g:link action="downLoadNotice" controller="cessPendingDetails" id="${cessPendingInstance.id}">${fieldValue(bean:cessPendingInstance, field:'indreg.indName')}</g:link></u></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate%></font></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:cessPendingInstance, field:'description')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:cessPendingInstance, field:'month')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:cessPendingInstance, field:'year')}</font></td>
                           
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
                      </tr>	  
	  </table></g:if>
												</div>

												<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
												
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


