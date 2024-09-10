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
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

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

      String contVar=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

      response.sendRedirect(contVar+"/index.gsp")  ;     

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
						
					 </td></tr>
					</table>
				</td>
              </tr>
              
	
                     
        
<td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                     <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${industry}">
										<div class="errors">
											<g:renderErrors bean="${industry}" as="search" />
										</div>
										</g:hasErrors>

                      </span></div></td>
                    </tr>
                    
                    <tr bgcolor="#4C8BC0">        
                      <td align="center" valign="top" ><font color="white"><b>Audit Trail</b></font></td>
                    </tr>
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="34" align="left" valign="top">&nbsp;</td>
                            <td width="685" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  <FORM id="myForm" name=myForm action="searchAudit" method="post">  
	      
	  
	  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
						
					 
					
                       <tr align="center">
                       

						<td colspan="4" bgcolor="#A8DAF3" align="center"><span class="headngblue">Search By Date</span></td></tr>
                      
                 <tr  bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}" />
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">Ending Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
                      
      
	  </table>      
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
		  </tr>
 
		</table>
		
		</form>
		<table width="97%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	       
                        	<td width="5%" class="headngblue" align="center">S.No</th>
							<td width="13%" class="headngblue" align="center">User ID</th>
							<td width="13%" class="headngblue" align="center">User Type</th>
							<td width="13%" class="headngblue" align="center">Ip Adreess</th>
							<td width="13%" class="headngblue" align="center">Login Status</th>
							<td width="13%" class="headngblue" align="center">Login Description</th>
                   	        <td width="13%" class="headngblue" align="center">Login Date</th>
                   	        <td width="13%" class="headngblue" align="center">Logout Date</th>
                   	    
                        </tr>
                    
                   
                    
                    
      </table></td>
		  </tr>
		  <tr><td class="txt4"></td></tr>
		  
		  
		  </table>
		
		         <div style="border:1px solid gray;overflow: auto;  width:720px; height:270px; margin-bottom: 1em; padding: 10px" >
         
	
		  
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			
                       
                   
                    <g:each in="${industry}" status="i" var="myAuditInstance">
                        
                        <tr  >
                        <td width="5%" align="center"><%=i+1%></td>
                        <td width="15%" align="center">${fieldValue(bean:myAuditInstance, field:'userID')}</td>
                            <td width="15%" align="center">${fieldValue(bean:myAuditInstance, field:'userType')}</td>
                            <td width="15%" align="center">${fieldValue(bean:myAuditInstance, field:'ipAddress')}</td>
                            <td width="15%"  align="center">${fieldValue(bean:myAuditInstance, field:'loginStatus')}</td>
                            <td width="15%" align="center">${fieldValue(bean:myAuditInstance, field:'reason')}</td>
                            <td width="15%" align="center">${fieldValue(bean:myAuditInstance, field:'loginDate')}</td>
                            <td width="15%" align="center">${fieldValue(bean:myAuditInstance, field:'logoutDate')}</td>
                            
                            
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
		  </tr>
		  <tr><td class="txt4"></td></tr>
		  
		  
		  </table>
		  <br />
          
          </div>
		
      </div></td>
                            <td width="59" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
     
    </table></td>
  </tr>
</table>
 <!-- code for spcb Footer -->
        
 <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
</body>
</html>

