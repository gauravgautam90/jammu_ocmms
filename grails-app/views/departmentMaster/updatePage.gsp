<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

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
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% 
	String cont=request.getContextPath()
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont+"/index.gsp")	;	
	 } %>

</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- code for menuAdminHorizontal-->
		
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
		
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			
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
			
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>

  <%
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
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
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
					<td width="100%" align="left">
						<g:link controller="departmentMaster" action="create" ><span class="innerlink">&nbsp;Add&nbsp;|</span></g:link> 				</td>							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                     <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${departmentMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${departmentMasterInstance}" as="list" />
										</div>
										</g:hasErrors>

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		<g:form action="edit" method="post" name="myform">
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="160" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks">Update Department Name</td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="420">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				<tr bgcolor="#F4F7FB">
                <td width="40%" bgcolor="#A8DAF3" class="headngblue" >Department Name:</td>
                      
                          <td bgcolor="#E8F6F9"  width="60%" align="left"  class="txt4">
                           <g:select class="txt4" optionKey="id" from="${DepartmentMaster.list()}" id="deptMasterList_Id" name="deptMasterList_Id"    ></g:select>   
                                <span class="txt4">(select details)</span></td>
                            
								</tr>	
        	 
                        </table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Update" value="Update" class="actionbutton" ></td>
		<!-- 	<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td> -->				
		  </tr>
		</table>
		<div align="left" class="txt" style="color: navy">
			  <br>
			   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to update Department name:-
			  <ul> 
			  	<li>Select details from drop down list </li>
			  	<li>Click update button to update the details</li>
			  	<li>Enter Department (max 10 Characters)</li>
				<li>Click update button to update the details</li>
			  </ul>
		</div>		
		
  			</g:form>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          </div>

      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>

<script language="JavaScript" type="text/javascript">
 	var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 	frmvalidator.addValidation("sourceName","req","Please enter Source Name...");
</script>

</body>

<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


