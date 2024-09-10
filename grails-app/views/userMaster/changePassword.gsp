<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript">

//disabling browser back button for mozila

function noBack(){window.history.forward()}

noBack();

window.onload=noBack;

window.onpageshow=function(evt){if(evt.persisted)noBack()}

window.onunload=function(){void(0)}

</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF >
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
								UserMaster abcd1=session.userMaster
								
							if(abcd1.flag ==0){ %>	
							<g:include controller="userMaster" action="showIndexMenuHorizontal"/>			
						<% } else{
						if((UserMaster)session.getAttribute("userMaster")){
							UserMaster aa = (UserMaster)session.getAttribute("userMaster");
							String userType =	 aa.accessLevel
							if(userType.equals("admin")) { %>	
								<g:include controller="userMaster" action="showAdminMenuHorizontal"/> 							
							<% }else{ %>
								<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
							<%}} }%>
									
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
								UserMaster abcd=session.userMaster
								
							if(abcd.flag ==0){ %>
							<g:include controller="userMaster" action="showIndexMenu"/>	
						<%	}
							else{	
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
								<% }} %>
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
					<table width="100%"> <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							<td width="80%">&nbsp;</td>
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
							            <g:hasErrors bean="${userMasterInstance}">
							            <div class="errors">
							                <g:renderErrors bean="${userMasterInstance}" as="list" />
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
		
		
		
		
		<g:form action="changePassword" name="myform" method="post" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Change Password</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				 <tr bgcolor="#F4F7FB">
                            
                   <%         
                           if((UserMaster)session.getAttribute("userMaster")){
							UserMaster abc = (UserMaster)session.getAttribute("userMaster");
							String userlevel =	 abc.accessLevel
								if(userlevel.equals("employee")) { %>
								<td width="40%" align="right" bgcolor="#A8DAF3"  class="headngblue"> Username *: </td>
                            <td width="60%" align="left" bgcolor="#E8F6F9" style="color:black" class="txt style6"><%=abc%><input name="id" type="hidden" class="txt4"  value=<%=abc%> /></td>
                         
                         <%} else{ %>
                         
                               <td width="40%" align="right" bgcolor="#A8DAF3"  class="headngblue">Enter Username *: </td>
								
								<td width="60%" align="left" bgcolor="#E8F6F9"  class="txt style6"><input maxlength="25" name="id" id="id" type="text" class="txt4"  value="" AUTOCOMPLETE=OFF />
								<span class="txt4">(enter user name)</span></td>
 							 <% }} %>
                          </tr>
                         
                          <tr align="center" bgcolor="#F4F7FB">
                            <td  align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue">Old Password*:</td>
                            <td  align="left" bgcolor="#E8F6F9"  class="txt"><input maxlength="25" name="old" type="password" id="old" class="txt4"  />
                            <span class="txt4">(enter old password)</span></td>
                          </tr>
                         
                         
                         
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue">Enter New Password *: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="txt style6">
                            <input name="newPass1" id="newPass1" type="password" class="txt4" />
                            <span class="txt4">(enter new password)</span></td>
                          </tr>
                          
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Re-type New Password*: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="txt style6">
                            <input name="newPass2" id="newPass2" type="password" class="txt4" />
                            <span class="txt4">(re-enter password)</span></td>
                          </tr>
                          <tr >
        	 
                        </table>
						<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" >
              <tr align="center" >
                     <td align="left" valign="middle" class="txt"> <font color="red">*Please follow the password format as (1 Special character(only @,#,$), 1 number and min 8 character in length and maximum 15 character in length)</font></td>
               </tr>
       </table>   
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Update" value="Update" onclick="javascript:return changePassEncryption()" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
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
<!--
<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("id","req","Please enter UserName");
 frmvalidator.addValidation("old","req","Please enter old password");
 frmvalidator.addValidation("newPass1","req","Please enter new password");
 frmvalidator.addValidation("newPass2","req","Please enter Re-Enter Password field");
</script> 
-->
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>



