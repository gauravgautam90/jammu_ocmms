<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
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
					<table width="100%"> <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
					<td width="100%" align="left">
						<g:link controller="conditionMaster" action="create" ><span class="innerlink">&nbsp;Add&nbsp;|</span></g:link> </td>							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:15px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${conditionMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${conditionMasterInstance}" as="list" />
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
		
		
		
		
		<g:form action="search" method="post" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="110" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks">Search Condition</td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="469" align="right"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="${createLinkTo(dir:'images',file:'Help.gif')}" border="0" align="center" alt="HELP" height="27"></a></td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						
						<tr >
                        <td width="170px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Condition Type:</div></td>
                        <td align="left" valign="center" bgcolor="#E8F6F9"><span class="txt" >
                        <input type="radio" class="txt4" name="conditionType" value="General" checked="checked"><span valign="center" class="txt4">General</span></input>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="conditionType" value="Specific"><span align="left" class="txt4">Specific</span></input>
                       <!--   <g:select  from="${['General','Specific']}"    ></g:select>   -->
                        </span></td>
                      </tr>
						
						
						<tr >
                        <td width="170px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Consent For:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
						 <div id ="GroupSelected">
						 <input type="radio" name="consentFor" value="new" checked="checked"><span valign="center" class="txt4">New</span></input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="consentFor" value="reNew"><span align="left" class="txt4">Renew</span></input>
			<!--	<g:select  from="${['New','Renewal']}" id="consentFor" name="consentFor"   ></g:select>  -->
                        	</div>
						</span></td>
                      </tr>
                            <tr align="center" >
                              <td width="170px" bgcolor="#A8DAF3" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Consent Type:</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left">
                          <g:select class="txt4" optionKey="id" from="${ApplicationTypeMaster.list()}" name="applicationTypeMaster_id" value="${conditionMasterInstance?.applicationTypeMaster?.id}" ></g:select>
                        </div></td>
                      </tr>
                      <tr >
                        <td  width="170px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Application For: </div></td>
                       <td bgcolor="#E8F6F9" ><div align="left">
                          <g:select  class="txt4" from="${['air','water','both']}" id="applicationFor" name="applicationFor"   ></g:select>
                        </div></td>
                      </tr>
                      <tr >
                        <td width="170px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Industry Type:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                        
                       
    
                   <g:select class="txt4" optionKey="id" from="${IndustryTypeMaster.list()}" name="industryTypeMaster_id" value="${conditionMasterInstance?.industryTypeMaster?.id}" ></g:select>
                        
                    </span></td>
                      </tr>
					  
					
					  
                      
                      
                      
                      
                      
                     
	  </table>

						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Save" value="Search" class="actionbutton" ></td>
						
		  </tr>
		</table>
		<div align="left" class="txt" style="color: navy">
			  <br>
			   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to add Air Terms & Conditions to generate Consent Certificate:-
			  <ul> 
			  	<li>Select <b>Condition Type</b> (General/Specific)</li>
			  	<li>Select <b>Consent For</b> (New/Renew) for which terms & conditions needs to be added</li>
			  	<li>Select <b>Consent Type</b> (CTE/CTO) for which terms & conditions needs to be added</li>
			  	<li>Select <b>Application For</b> (Air/Water/Both) for which terms & conditions needs to be added</li>
			  	<li>Select <b>Industry Type</b>, Same conditions may not be applicable for all type of industry</li>
			  	<li>Click search button to search the details</li>
			  	<li>Click ID to  edit the content</li>
			  	<li>Enter Terms & Conditions (max 300 Characters)</li>
				<li>Click update button to update the details or delete to delete the same</li>
			  </ul>
		</div>		
		
  			</g:form>
            
          </div>
		 
		  <g:if test="${conditionMasterList}">
          
         
           
               <table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                    <thead align="center" class="headngblue" >
                        <tr>
                        
                   	        <th align="center" class="headngblue">ID</th>
                        
                   	        <th align="center" class="headngblue">Industry Type Master</th>
                   	    
                   	        <th align="center" class="headngblue">Consent Type</th>
                   	        
                   	        <th align="center" class="headngblue">Consent For</th>
                   	        
                   	        <th align="center" class="headngblue">Condition Type</th>
                   	        
                   	        <th align="center" class="headngblue">Application For</th>
 
                        	<th align="center" class="headngblue">Condition</th>
                       
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${conditionMasterList}" status="i" var="conditionMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}" >
                        
                            <td align="center" height="25" class="txt4"><g:link action="edit" id="${conditionMasterInstance.id}">${fieldValue(bean:conditionMasterInstance, field:'id')}</g:link></td>
                        
                            <td align="center" height="25" class="txt4">${fieldValue(bean:conditionMasterInstance, field:'industryTypeMaster')}</td>
                        
                            <td align="center" height="25" class="txt4">${fieldValue(bean:conditionMasterInstance, field:'applicationTypeMaster')}</td>
                        
                            <td align="center" height="25" class="txt4">${fieldValue(bean:conditionMasterInstance, field:'consentFor')}</td>
                        
                            <td align="center" height="25" class="txt4">${fieldValue(bean:conditionMasterInstance, field:'conditionType')}</td>
                        
                            <td align="center" height="25" class="txt4">${fieldValue(bean:conditionMasterInstance, field:'applicationFor')}</td>
                            <td align="left" height="25" class="txt4" ><span STYLE="word-wrap:  break-word; width: 100px;" >${fieldValue(bean:conditionMasterInstance, field:'condition')}</span></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                    <table><tr><td>&nbsp;</td></tr>
                </table>
            </div>
            <div class="paginateButtons">
          
                <g:paginate  controller="conditionMaster"
						action="search" total="${total}"  params="${paramList}"/>
            </div>
		  
		  
		     </g:if>
		  
		  
		  
		  
		  
		  
		  
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
</body>

<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


