<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
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
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<g:javascript library="prototype" />
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
				<!-- code for menuAdminHorizontal--> <% 
				if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
					controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
				<% 
 		if((UserMaster)session.getAttribute("userMaster")){
 		UserMaster aa = (UserMaster)session.getAttribute("userMaster");
		String userType = aa.accessLevel
		 if(userType.equals("admin")) { %> <g:include controller="userMaster"
					action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
					controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
				<% if( (!(IndUser)session.getAttribute("indUser") ) && 
		      (! (UserMaster)session.getAttribute("userMaster") )  )   {%> <g:include
					controller="userMaster" action="showIndexMenuHorizontal" /> <% } %>
				
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
	<tr>
								<td height="24" bgcolor="#EEEEF3">
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
									<tr>
										<td>&nbsp;</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr><td align="center"><div style="width: 400px; height: 20px; vertical-align: middle"><span class="error"> <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
										</g:if></span></div>
            </td></tr>
							<tr>
								<td height="0" align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									

							
									<tr>
										<td height="0" align="left" valign="top">
										<table width="778" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="82" align="left" valign="top">&nbsp;</td>
												<td align="left" valign="top">
												<div style="padding: 0px 0px 0px 0px;"><br />
												<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
												<!-- place -->
												
												<g:form method="post" >
												<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

                  <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
							<th align="center" class="headngblue" ></th> 
                   	        
                   	       	
                        </tr>
                   	        
                   	 <g:each in="${appListB}" status="i" var="wasteManagementInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:wasteManagementInst, field:'id')}</td>
                        
                          <td align="center" height="25" class="txt4"  ><%=strDate%></td>
                          
                           <td align="center" height="25" class="txt4"  >${fieldValue(bean:wasteManagementInst, field:'industryReg')}</td>
                        
                            <td align="center" height="25" class="txt4"  >E-Waste</td>
                        
                          
                        	
                           <td align="center" height="25" class="txt4"  ><input name="routeThese" type="checkbox" value="<%=wasteManagementInst.id%>"/></td>
                          </tr>
                    </g:each>
                    
                   
                    
                    
                     <tr>
                    <td align="center" colspan="5" bgcolor="orange">
                   	<table><tr>
                    	<td  align="left" > <font face="Verdana" size="1" color="#663300">Select Office and group:</font>
                    	</td>
                    	<td  align="right">
	                    	<g:select class="txt4" optionKey="id" noSelection="${['':'Select Office']}" from="${OfficeMaster.list()}" id="officeSelected" name="officeId" onclick="${remoteFunction(controller:'eWaste', action:'updateGroups',update:'groupSelected', params:'\'cont=\' + this.value' )}">
	                    	</g:select>
	                    </td>
	                    
	                    <td  align=left>
	                    	<div id ="groupSelected">
	                    	<g:select optionKey="id"  noSelection="${['':'Select Group']}" class="txt4" id="grp" name="grp" from="">
	                    	</g:select>
	                    	</div>
                    	</td>
                    </tr>
                    </table>	
                    </td>	
                    </tr>
                  
                   	

                </table>
												<table width="95%" border="0">
													<tr>
														<td colspan="3">&nbsp;</td>
													</tr>
													<tr>
														<td align="right" width="40%"><!-- <input type="submit" name="Route" value="Route"class="actionbutton"> -->
																			<g:actionSubmit class="actionbutton" action="routeChecked" value="Route" /></td>
														
														<td align="left" width="40%"><input type="reset" name="reset"
															value="Reset" class="actionbutton" /></td>
															
													</tr>
												</table>
												</g:form>
												<!-- place -->
												</div>



												







												<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script></div>
												</td>
												<td width="132" align="left" valign="top">&nbsp;</td>
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


