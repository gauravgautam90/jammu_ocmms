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



<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>





<script type="text/javascript">


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

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>
<g:javascript>
document.observe('dom:loaded', function() {
<!--	$("grp").observe("change", respondToSelectGrp); -->
   $("officeSelected").observe("change", respondToSelect);
   });

   
 function respondToSelect(event)
 {
       new Ajax.Updater("groupSelected",
          "<%=cont%>/workFlowMaster/updateSelectForRoleName",
          {method:'get', parameters: {selectedValue : $F("officeSelected")} }
         );
 }
 
 
</g:javascript> 
<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
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
		<g:include controller="userMaster" action="showAdminMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<% UserMaster aa = (UserMaster)session.getAttribute("userMaster");
					String userType =	 aa.accessLevel;
					if(userType.equals("admin")) { %>	
						<g:include controller="userMaster" action="showAdminMenu"/>
				<%} else{ %>
						<g:include controller="userMaster" action="showSpcbUserMenu"/>	
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
	

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>

<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
		
		<% } %>
	
					 </table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${groupMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${groupMasterInstance}" as="list" />
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
       
		<FORM id="myForm" name=myForm action="searchRoleNameList" method="post">  
	   
         <div style="border":1px solid gray; width:auto; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		
		
		
          
	
		
			
			<div id="country1" >
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				                      
                      <tr>
          <td colspan="2"><table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
              <tr align="center" bgcolor="#F4F7FB" >
               
                <td width="15%"   align="center" valign="middle"     class="headngblue">Select Office</td>
				<td width="25%"   align="center" valign="middle"   >
				<%
				def officeList = OfficeMaster.findAll("from OfficeMaster where priority !='9'")
				%>
				
				
				<g:select class="txt4" optionKey="id" noSelection="${['':'Select Office']}" from="${officeList}" id="officeSelected" name="officeId" value="${off}"></g:select>
				
				</td>
				
				  <td width="15%"  align="center" valign="middle"   class="headngblue">Select Group</td>
				<td width="25%"   align="center" valign="middle">
				
				<div id ="groupSelected">
				<g:select optionKey="id"  noSelection="${['':'Select Group']}" class="txt4" id="grp" name="grp" from="" onchange="${remoteFunction(controller:'workFlowMaster', action:'updateGrpSel',update:'roleDiv', params:'\'cont=\' + this.value' )}" value="${g}"></g:select>
				</div>
				 
				  </div></td>
				  
				
				
              </tr>
              <!--<tr><td>&nbsp;</td></tr>-->
			  <tr>
			  <td colspan="9"><div id="fwdRights">
			  
			  </div></td>
			  </tr>
              
             <!--<tr>
          <td colspan="2"><img src="images/spacer.gif"  width="1" height="10" /></td>
        </tr>-->
          </table></td>
        </table>
        </div>
	   <table width="100%" align="center">
	   		
		  <tr>
			<td align="right"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
 
		
		 
		
	<g:if test="${roleMaster}">
     
     
     <table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr>
  <td  align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/workFlowMaster/popRoleUser', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
  <span class="headngblue" align="right">Print Excell</span></a></span></a>
 </td>
</tr>
                 
     </table>

      
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr height="20" bgcolor="#2B547E">
<td align="left" >
<b><font color="yellow" size="2">User Role Details</font></b>
</td>
</tr>
</table>

<div style="overflow: auto;height: 300px; width: 700px;">

	<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt" border="1">
 				<tr height="20" bgcolor="#A8DAF3">

                     
                            <th align="center" class="headngblue" >S.No</th>
                             <th align="center" class="headngblue" >Group Name</th>
                            <th align="center" class="headngblue" >Role Name</th>
                   	        <th align="center" class="headngblue" >Role Id </th>
                   	        <th align="center" class="headngblue" >User Id</th>
                   	        <th align="center" class="headngblue" >User Name</th>
                   	        <th align="center" class="headngblue" >Mobile</th>
                   	        <th align="center" class="headngblue" >Email</th>
                   	        <th align="center" class="headngblue" >Active/InActive</th>
                   	      
                   	        
                   	       
                   	        
                   	        
                 </tr>
                 <g:each in="${roleMaster}" status="i" var="abc">
                 <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                 <%def roleUserInstance=RoleProfileAssignment.findByRole(abc)
                  %>
                    <td align="center" height="25"> <font size="2%"><%=(i+1)%></font></td>
                           <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'group.groupName')}</td>
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'roleName')}</td>
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'id')}</td>
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:roleUserInstance, field:'primaryEmployee.id')}</td>
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:roleUserInstance, field:'primaryEmployee.employeeFirstName')} ${fieldValue(bean:roleUserInstance, field:'primaryEmployee.employeeLastName')}</td>
                        	<td align="center" height="25" class="txt4"  >${fieldValue(bean:roleUserInstance, field:'primaryEmployee.mobile')}</td>
                        	<td align="center" height="25" class="txt4"  >${fieldValue(bean:roleUserInstance, field:'primaryEmployee.email')} </td>
                        	<td align="center" height="25" class="txt4"  >${fieldValue(bean:roleUserInstance, field:'primaryEmployee.status')}</td>
                        	
  </tr>
                 </g:each>
			</table>
			<br/>
			<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
			<tr height="20" bgcolor="#2B547E">
			<td align="left" >
			<font color="yellow" size="2"><b>Total Role: <%=roleMaster.size()%></b></font>
			</td>
			</tr>
			</table>
		 </div>
		
		
		</g:if>
		<br />
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
      </div></td>
                            <td width="82" align="left" valign="top">&nbsp;</td>
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
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


