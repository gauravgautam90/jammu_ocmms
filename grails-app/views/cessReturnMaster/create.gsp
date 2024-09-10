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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
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
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

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

<% String cont=request.getContextPath()

%>


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
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
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
			<% if( (!(IndUser)session.getAttribute("indUser") ) && 
				(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
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
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr>
							
					<td  align="left">
					<!-- <g:link controller="userProfile" action="list1" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link>  -->		
					</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
					
					<!-- Div area for errors-->
                      
					  <td align="center" valign="top"><div style="width:400px;  vertical-align:middle">
					  <span class="error">
						<g:if test="${flash.message}">
						<div class="message">${flash.message}</div>
						</g:if>
						<g:hasErrors bean="${userProfileInstance}">
						<div class="errors">
						<g:renderErrors bean="${userProfileInstance}" as="list" />
						</div>
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
		
		
		
		
		<form action="save" method="post" name="myform" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="157" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Cess Return Form</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="422" align="right" ></td>
							</tr>
	    </table>
		
		
		
       <div id="country1" >
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
			
				<tr>
                  <td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Month</td>
				  <td width="25%" align="left" bgcolor="#E8F6F9"  class="headngblue"><g:select name="#" from="${['select year', 'T', 'F']}" class="txt4" /><g:select name="#" from="${['select month', 'T', 'F']}" class="txt4" />
				  <td  width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Ind/ ULB ID :</td>
					<td width="25%"  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="textfield2" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</td>
				 
			  </tr> 
				   
				
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="textfield2" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><textarea name="address"  style="width:160px"></textarea></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Plot No./Khata * : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="plotNo" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
                    </td>
                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input name="textfield3" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</span></td>
				</tr>        
				    
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input name="textfield4" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</span></td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<input name="textfield5" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reading for First Day of Calender month : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<input name="" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reading for Last Day of Calender month  : </td>
				    <td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<input name="" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="50" />
					</td>
				</tr>        
				
				
				
			<tr bgcolor="#D1D1D1">
	<td   align="left"  colspan="9" valign="middle" height="2"  class="headngblue tblbdr">&nbsp;</td>
	</tr> 
			
			
	</table>
	<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >	
	  	<tr bgcolor="#A8DAF3" >
					<td  align="left" colspan="2" valign="middle"  class="headngblue">Purpose of which Water Consumed  </td>
					<td  align="left" colspan="5" valign="middle"  class="txt"><g:select name="purpose" optionValue="purpose" from="${CessWaterConsumptionPurposeMaster.list()}" class="txt4" /></td>
			</tr>
		 <tr width="100%" >
	<td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Source of Consumption </td>
	<td width="8%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Meter Reading </td>
	<td width="11%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Start Reading </td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >End Reading</td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Quantity (KL) </td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" > Water Qty (3 Month Avg.)</td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Quantity of water for rebate </td>
			</tr>
	<tr>
 	 <g:if test="${sourceMaster}"> 
    <tbody>
		<g:each in="${sourceMaster}" status="i" var="sourceMaster">
		<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
		<tr>
			<td class="txt"><input type="checkbox" name="" id="check1" />${fieldValue(bean:sourceMaster,field:'source')}</td>
			<td  align="left" valign="middle"  class="headngblue"><div ><g:select class="txt4" name="" from="${['yes', 'no']}"  />
                    </div></td>
			<td  align="left" valign="middle"  class="txt4"><div><input name="Input2" type="text" class="txt4" size="8" maxlength="10" /> </div></td>
            <td  align="left" valign="middle"  class="txt4"><div ><input name="Input2" type="text" class="txt4"  size="8" maxlength="10" /> </div></td>
            <td  align="left" valign="middle"  class=" txt4"><div ><input name="Input2" type="text" class="txt4" size="8" maxlength="10" /></div></td>
            <td  align="left" valign="middle"  class=" txt4"><div ><input name="Input2" type="text" class="txt4" size="8" maxlength="10" /></div></td>
            <td  align="left" valign="middle"  class=" txt4"><div ><input name="Input2" type="text" class="txt4"  size="8" maxlength="10" /></div></td>
		</tr>
						</g:each>
						</tbody>
					
				</g:if>
  </tr>
 
    <!--  <td  align="left" valign="middle"  class="headngblue"><input type="checkbox" name="checkbox" value="checkbox" /> Muncipal Water Supply Mains</td>
    <td  align="left" valign="middle"  class="headngblue"><div ><g:select class="txt4" name="" from="${['yes', 'no']}"  />
                    </div></td>
    <td  align="left" valign="middle"  class="txt4"><div>
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="txt4"><div >
                    <input name="Input2" type="text" class="txt4"  size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class=" txt4"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class=" txt4"><div >
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                   </div></td>
                    <td  align="left" valign="middle"  class=" txt4"><div >
                       <input name="Input2" type="text" class="txt4"  size="8" maxlength="10" />
                    </div></td>
                  </tr>
        <tr>
           <td  align="left" valign="middle" bgcolor="#FFFFFF"  class="headngblue"><label>
          <input type="checkbox" name="checkbox22" value="checkbox" class="txt4" />Well Tubewell </label>
                        <label> </label>
                        <label></label></td>
                    <td  align="left" valign="middle"  class="headngblue "><div ><g:select class="txt4" name="" from="${['yes', 'no']}"  />
                    </div></td>
    <td  align="left" valign="middle"  class="headngblue txt"><div>
                        <input name="Input2" class="txt4" type="text"  size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue txt"><div >
                    <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                        <input name="Input2" type="text" class="txt4"  size="8" maxlength="10" />
                   </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                  </tr>
                  <tr>
                    <td height="2"  align="left" valign="middle"  class="headngblue "><label>
                      <input type="checkbox" name="checkbox32" class="txt4" value="checkbox" />
      Canal </label>
                        <label> </label>
                        <label></label></td>
                   <td  align="left" valign="middle"  class="headngblue "><div ><g:select class="txt4" name="" from="${['yes', 'no']}"  />
                    </div></td>
    <td  align="left" valign="middle"  class="headngblue txt"><div>
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue txt"><div >
                    <input name="Input2" type="text" class="txt4"  size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                   </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                  </tr>
                  <tr>
                    <td height="4"  align="left" valign="middle" bgcolor="#FFFFFF"  class="headngblue"><label>
                      <input type="checkbox" name="checkbox42" class="txt4" value="checkbox" />
      River </label>
                        <label> </label></td>
                   <td  align="left" valign="middle"  class="headngblue "><div ><g:select class="txt4" name="" from="${['yes', 'no']}"  />
                    </div></td>
    <td  align="left" valign="middle"  class="headngblue txt"><div>
                        <input name="Input2" class="txt4" type="text"  size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue txt"><div >
                    <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                   </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                  </tr>
       <tr>
                    <td height="10"  align="left" valign="middle"  class="headngblue"><input type="checkbox" name="checkbox52" value="checkbox" />
      Other Source </td>
                    <td  align="left" valign="middle"  class="headngblue "><div><g:select  class="txt4" name="" from="${['yes', 'no']}"  />
                    </div></td>
    <td  align="left" valign="middle"  class="headngblue txt"><div>
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue txt"><div >
                    <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                        <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                   </div></td>
                    <td  align="left" valign="middle"  class="headngblue"><div >
                       <input name="Input2" type="text" class="txt4" size="8" maxlength="10" />
                    </div></td>
                  </tr> -->
      <tr>
                    <td height="20"align="center" valign="middle"   class="headngblue">
                    	<div align="left">Remarks, if any:</div>
                    	<div align="left"><span class="headngblue txt"></span></div></td>
                    <td height="20" colspan="6"align="center" valign="middle"   class="headngblue">
                    	<div align="left">
                        <textarea name="Input792" class="txt4" cols="60" ></textarea>
                    	</div></td>
     </tr>
               <tr>
               
			<td align="center" colspan="7"><input type="submit" name="Save" value="Save"  class="actionbutton" >
			
			<input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
  </table>
  
  <g:if test="${k}">
            
           <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr  bgcolor="#A8DAF3">  
				<th align="center" class="headngblue" width="20%" >Source of consumption</th>  
				<th align="center" class="headngblue" width="40%" >Meter Reading </th>  
				<th align="center" class="headngblue" width="10%" >Start Reading</th>  
				<th align="center" class="headngblue" width="10%" >End Reading</th>  
				<th align="center" class="headngblue" width="20%" >Quantity (KL) </th> 
				<th align="center" class="headngblue" width="20%" >Water Qty (3 Month Avg.)</th>          
				<th align="center" class="headngblue" width="20%" >Quantity of water for rebate </th>          
				                        
				
        		</tr>

			  <g:each in="${userIdSearch}" status="i" var="userIdSearch">
				 <tr class="${(i % 2) == 0 ? 'odd' : 'even'}"   >
				  <td  align="center" class="txt4" ><g:link action="show" id="${userIdSearch.id}">${fieldValue(bean:userIdSearch, field:'id')}</g:link></td>
				 <td align="left" class="txt4"  ><g:link action="show" id="${userIdSearch.id}">${fieldValue(bean:userIdSearch, field:'employeeFirstName')}  ${fieldValue(bean:userIdSearch, field:'employeeLastName')}</g:link></td>
				 <td  align="center" class="txt4" >${fieldValue(bean:userIdSearch, field:'department')}</td>
				 <td  align="center" class="txt4" >${fieldValue(bean:userIdSearch, field:'designation')}</td>
				 <td align="center" class="txt4" >${fieldValue(bean:userIdSearch, field:'dateCreated')}</td>
								
								</tr>
							</g:each>  
							
				<tr >
				<td width="80" class="tab-txt">
				
				<g:paginate 
						 controller="userProfile"
						action="userSearch" total="${total}"  params="${paramList}"  />
				
				</td>	
            
            </tr>	
        	 					                             
	

			</table> 


		
		
		</g:if>
  
  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >	
  
  <tr bgcolor="#D1D1D1">
	<td   align="left"  colspan="9" valign="middle" height="10"  class="headngblue tblbdr">&nbsp;</td>
	</tr>            
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Unit of water consumption:</td>
      <td align="center" class="headngblue" width="25%" height="20" ><input name="Input79322" class="txt4" type="text" value="&lt;Sum of total Quantity Col-4&gt;" size="15" maxlength="10" /></td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water Consumed:</td>
      <td align="center" class="headngblue" width="25%" height="20" ><input name="Input793222" type="text" class="txt4"  value="&lt;Sum of total Quantity Col-5&gt;" size="15" maxlength="10" /></td>
      </tr>
      
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >3 Months Avg. Water Consumption, if meter not working: </td>
      <td align="center" class="headngblue" width="25%" height="20" ><input name="Input79322" type="text" class="txt4" value="&lt;Sum of total Quantity Col-4&gt;" size="15" maxlength="10" /></td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water qualifying for rebate according to the Assesee :</td>
      <td align="center" class="headngblue" width="25%" height="20" ><input name="Input793222" type="text" class="txt4" value="&lt;Sum of total Quantity Col-5&gt;" size="15" maxlength="10" /></td>
      </tr>
    </table> 		
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		 
		</table>
		
	</table>	
  			
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
</form>


<!--
<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("id","req","Please enter userId");
 frmvalidator.addValidation("id","emp_valid","Enter valid userId");
 frmvalidator.addValidation("employeeFirstName","alpha_s","enter valid firstname");
 frmvalidator.addValidation("employeeFirstName","req","Please enter first name");
 
 frmvalidator.addValidation("employeeLastName","alpha_s","enter valid lastname");
 frmvalidator.addValidation("employeeLastName","req","Please enter last name");
 
 frmvalidator.addValidation("email","email","Enter valid email");
  frmvalidator.addValidation("email","req","please enter email-id");


 
  frmvalidator.addValidation("officePhone","numeric","phone number must be numeric");
  frmvalidator.addValidation("officePhone","req","Please enter phone number"); 
  frmvalidator.addValidation("officePhone","minlen=5","phone number must be less than or equal to 11 digits"); 
  
   frmvalidator.addValidation("mobile","req","please enter Mobile no.");
 frmvalidator.addValidation("mobile","numeric","Mobile no. must be numeric");
 frmvalidator.addValidation("mobile","minlen=10","Please enter valid mobile number");

   frmvalidator.addValidation("designation","req","Please enter designation");
 frmvalidator.addValidation("password","req","please press generate button for password");
 
 frmvalidator.addValidation("hintAnswer","req","enter hintAnswer");
 
  frmvalidator.addValidation("radiobutton","selone_radio","plz select whether you want to sendMail or not");
 
 function ignoreSpace(String){
 
  var temp = "";
  string = '' + string;
	splitstring = string.split(" ");
	for(i = 0; i < splitstring.length; i++)
	temp += splitstring[i];
	return temp;
 }
 
</script> 
-->

</body>
 <!-- <HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD> -->
</html>


