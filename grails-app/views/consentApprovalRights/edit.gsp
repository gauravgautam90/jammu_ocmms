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

      String contex=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
 
 <script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
	}
</script>
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

                                          String userType = aa.accessLevel

                                          if(userType.equals("admin")) { %>   

                                                <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

                                          <% }else{ %>

                                                <g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 

                                          <%}} %>

                                                      

                                    <% if( (!(IndUser)session.getAttribute("indUser") ) && 

(! (UserMaster)session.getAttribute("userMaster") )  )   {%>

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

						if(  (IndUser)session.getAttribute("indUser")  )
										
										{ %>

                                                      <g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         

                                                <%} %>

                                                                  

                                                <% 

                                                if((UserMaster)session.getAttribute("userMaster")){

                                                      UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                                      String userType = aa.accessLevel

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
              </tr>  <%
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
					 </td></tr> <tr><td>
			<g:link controller="consentApprovalRights" action="create" ><span class="innerlink">&nbsp;Create&nbsp;|</span></g:link> 
					<g:link controller="consentApprovalRights" action="updateApproval" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link> 
					
					</td>
							
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
            <g:hasErrors bean="${consentApprovalInstance}">
            <div class="errors">
                <g:renderErrors bean="${consentApprovalInstance}" as="list" />
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
        <g:form name="myform" method="post" >
				 <input type="hidden" name="id" value="${consentApprovalInstance?.id}" />
                <input type="hidden" name="version" value="${consentApprovalInstance?.version}" />
   
   				 
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Update</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="${createLinkTo(dir:'images',file:'Help.gif')}" border="0" align="center" alt="HELP" height="27"></a></td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
						
						<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Dealing Group:</div></td>
                        
                          <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:consentApprovalInstance,field:'group','errors')}">
                            <span class="innerlink">        ${consentApprovalInstance?.group}</span>
                                </td>
                        
                      </tr>
                            <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Role Name:</div></td>
                        <td bgcolor="#E8F6F9" class="value ${hasErrors(bean:consentApprovalInstance,field:'role','errors')}"><div align="left">
                          
                                 <span class="innerlink">    ${fieldValue(bean:consentApprovalInstance,field:'role')} </span>
                        </div></td>
                      </tr>
                      <tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Category :</div></td>
                        <td align="left" bgcolor="#E8F6F9"><div align="left">
                          
                                 <span class="innerlink"><g:select class="txt4"  name="category" from="${['RED','ORANGE','GREEN','WHITE']}"></g:select>
                 				 </span> ${fieldValue(bean:consentApprovalInstance,field:'category')}
                        </div></td>
                      </tr>
           <!--           <tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Scale of Industry :</div></td>
                        <td align="left" bgcolor="#E8F6F9"><div align="left">
                          
                                 <span class="innerlink">    ${fieldValue(bean:consentApprovalInstance,field:'indScale')} </span>
                        </div></td>
                      </tr>
                      
                      <tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Capital Investment Range (In Lakhs) :</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                        
				Min : <input type="text" size="8" maxlength="4" id="min" name="min" value="${fieldValue(bean:consentApprovalInstance,field:'min')}" />	Max : <input size="8" maxlength="10" type="text" id="max" name="max" value="${fieldValue(bean:consentApprovalInstance,field:'max')}" />
                        </span></td>
                      </tr>  -->
                      
                      
                     
	  </table>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><g:actionSubmit class="actionbutton" value="Update" /></td>
			<td align="left"><g:actionSubmit class="actionbutton" onclick="return confirm('Are you sure?');" value="Delete" /></td>
			
		  </tr>
		</table>
 		<div align="left" class="txt" style="color: navy">
			   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to update the role:-
			  <ul> 
				<li>Select Category</li>
				<li>Click update button to update this role</li>
			  </ul>
		</div>  			
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
</table></g:form>

<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("roleName","req","Please enter rolename");
 frmvalidator.addValidation("roleName","alnum_s","Enter valid rolename");
 frmvalidator.addValidation("roleDesc","alnum_s","enter valid description");
 
 

 
 
</script>
</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>

</html>

