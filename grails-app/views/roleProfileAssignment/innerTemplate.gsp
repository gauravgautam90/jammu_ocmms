<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Online Consent Management System</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
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

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>
<script type="text/javascript" src="js/tabcontent.js">
</script>
<% 
	String cont=request.getContextPath()
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont+"/index.gsp")	;	
	 } %>
</head>
<body>
		
<table width="99%" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left" valign="top"
					background="${createLinkTo(dir:'images2',file:'top_header_bg.jpg')}">
								
					<!--Start :  code for spcbHeader  -->
					<g:include controller="userMaster" action="showSpcbHeader"/>
				
					<!--Start :  code for spcbHeader  -->
				</td>
			</tr>
			<tr>
				<td align="left" valign="top" width = "100%"
					background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
					<!-- Start: code for Horizontal  Menu -->
					
					
					<% 
						if(  (IndUser)session.getAttribute("indUser")  ){ %>
							<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>							
						<%} %>
									
						<% 
						if((UserMaster)session.getAttribute("userMaster")){
							UserMaster aa = (UserMaster)session.getAttribute("userMaster");
							String userType =	 aa.accessLevel
							if(userType.equals("admin")) { %>	
								<g:include controller="userMaster" action="showAdminMenuHorizontal"/> 							
							<% }else{ %>
								<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
							<%}} %>
									
						<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
							<g:include controller="userMaster" action="showIndexMenuHorizontal"/>		
						<% } %>
				
				
				
					<!-- End: code for Horizontal  Menu -->				
				</td>
			</tr>
			<tr>
				<td align="left" valign="top" width = "100%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td width="224" align="left" valign="top" bgcolor="#DEEED0">
						
						<!-- Start : code for side menu-->
								<% 
								if(  (IndUser)session.getAttribute("indUser")  ){ %>
									<g:include controller="userMaster" action="showSpcbIndustryMenu"/>							
								<%} %>
											
								<% 
								if((UserMaster)session.getAttribute("userMaster")){
									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType =	 aa.accessLevel
									if(userType.equals("admin")) { %>	
										<g:include controller="userMaster" action="showAdminMenu"/> 							
									<% }else{ %>
										<g:include controller="userMaster" action="showSpcbUserMenu"/> 
									<%}} %>
											
								<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
									<g:include controller="userMaster" action="showIndexMenu"/>		
								<% } %>
						
						<!-- End : code for side menu-->
						
						</td>
						<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
						<td  align="left" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="1" valign="top"></td>
							</tr>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0" background="${createLinkTo(dir:'images2',file:'img-filler.gif')}">
							<tr >
								<td  ><img src="${createLinkTo(dir:'images2',file:'img.gif')}" height="134"  /></td>
							</tr>
						</table>
						
						<table width="100%" border="1" bordercolor="red" cellspacing="0" cellpadding="0">
							<tr>
								<!-- START: Place holder for sub menu option-->
								<td height="24" bgcolor="#EEEEF3"></td>
								
								<!-- END: Place holder for sub menu option-->															
							</tr>
							
							
							<!-- START: Place holder for page content-->
							
							
							<tr >
								<td height="0" align="left" valign="top" >
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<!-- Div area for errors-->
										<td align="center" valign="top"> Error Message Here
										</td>
									</tr>
									<tr>
										<td height="0" align="left" valign="top">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="15%" align="left" valign="top">&nbsp;</td>
												<td width = "70%" align="left" valign="top">
												

											<div style="border":1px solid gray; width:100%; margin-bottom: 1em; padding: 10px" >
												
												
												
												
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
					<tr>
						<td width="2%"><img src="${createLinkTo(dir:'images2/gif',file:'BlueTab_Left.jpg')}" width="11" height="27" /></td>
						<td width="26%" align="center" bgcolor="#5A89D9" class="top-lnks">Search </td>
						<td width="2%" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'BlueTab_Right.jpg')}" width="11" height="27" /></td>
						<td width="70%"></td>
						
						
						<!--<td width="11" bgcolor="#5A89D9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
						<td width="110" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country2">Product</a></td>
						<td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>-->
						
						
						
					</tr>
				</table>
												
									<table width="100%" border="0" align="left" cellpadding="0"
										cellspacing="0" bgcolor="#A5CAF4">
										<tr>
											<td valign="top" bgcolor="#FFFFFF">
											<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				
                      
                 <tr  bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                        <td width="35%" align="left" >
						<input type="text" id="start_date" name="start_date"  class="txt4" />
						<script language="JavaScript">
									new tcal ({
										// form name
										'formname': 'myForm',
										// input name
										'controlname': 'start_date'
									});
								
									</script>

						
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">Ending Date:*</td>
                        <td align="left" width="35%"  >
						<input type="text" id="end_date" name="end_date" class="txt4" />
						<script language="JavaScript">
							new tcal ({
								// form name
								'formname': 'myForm',
								// input name
								'controlname': 'end_date'
							});
						
							</script>
                   </td>
  				</tr>
                      
                      
                       <tr  bgcolor="#E8F6F9" >
                              <td align="left"  class="headngblue">Category:</td>
                        <td align="left" >
						
						<g:select optionKey="id" from="${IndCatMaster.list()}" name="category" noSelection="${['xyz':'Not Selected']}" ></g:select>
                        </td>
                      
                      
                      
                              <td  align="left"  class="headngblue">Status:</td>
                        <td align="left" >
						<g:select  from="${['pending','completed']}" name="status" noSelection="${['xyz':'Not Selected']}" ></g:select>
                        </td>
                      </tr>
      
	  </table>
	  
	  <table width="95%" align="center">
	   		
		  <tr>
			<td align="right"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
 
		</table>
											</td>
										</tr>
									</table>
									<br />
									<br />
							
							
							
											</div>
							
							
							
							
												</td>
												<td align="left" width="15%" valign="top">&nbsp;</td>
											</tr>
										</table>
										</td>
									</tr>
									<!--<tr>
<td width="195" height="72" align="left" valign="middle"></td>
</tr>-->
								</table>

							<!-- END: Place holder for page content-->




								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<!-- Start : code for spcb Footer -->
	  				<g:include controller="userMaster" action="showSpcbFooter"/>
			<!-- End : code for spcb Footer -->
		</table>
		</td>
	</tr>
</table>
</body>
</html>

