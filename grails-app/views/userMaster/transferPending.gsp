<%@ page import="java.text.SimpleDateFormat"%>
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
<g:javascript library="prototype" />
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
response.sendRedirect(cont+"/index.gsp")  ;     
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
				<td  class="top-lnks" width="100%">
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr></table>

				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                     <g:if test="${flash.message}">
									<div class="message">${flash.message}</div>
									</g:if>
									<g:hasErrors bean="${districtMasterInstance}">
									<div class="errors">
										<g:renderErrors bean="${districtMasterInstance}" as="list" />
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
		
		
		
		
		<g:form action="searchByOfficerTransfer" name="myform" method="post" >
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Select Officer</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
					   
                      
                      <tr align="center" >
                              <td width="30%" bgcolor="#A8DAF3" align="right" valign="middle" class="headngblue">Forward From :</td>
                        <td  bgcolor="#E8F6F9" width="60%" align="left" class="">
                        <input name="transferFrom" type="text" value="" size="30" class="txt4"/> &nbsp;<span class="sidetxt"><br>(Enter Officer ID From which You want to Transfer)</span>
    					 </td>
    					 <td width="30%" bgcolor="#A8DAF3" align="left" valign="middle" class="headngblue">Application For :</td>
    					 <td  bgcolor="#E8F6F9" width="60%" align="left" class="">
                         <select name="applicationFor">
                         <option value="-1">Select Application</option>
                         <option value="Consent">CTE/CTO</option>
                         <option value="wastemanagement">BMW/HWM/PWM</option>
                         </select>
     					 </td>
                        </tr>
                        
                      </tr>
                          
	  </table>
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="center" colspan="2"><input type="submit" name="Search" value="Search" class="actionbutton" ></td>
		 </tr>
		</table></g:form>
		<g:form action="processMultipleAppPending" name="myform" method="post" >
		<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
<%
if(listAbc){%>
        <tr height="20" bgcolor="#A8DAF3">

              
         	        <th align="center" class="headngblue" >Application ID</th>
         	        <th align="center" class="headngblue" >Application Date</th>
         	        <th align="center" class="headngblue" >Consent For</th>
         	       <th align="center" class="headngblue" >Industry Name</th>
         	       <th align="center" class="headngblue" >Industry Type</th>
         	       <th align="center" class="headngblue" >Status</th>
         	       <th align="center" class="headngblue" >Group</th>
         	      <th align="center" class="headngblue" >Role</th>
         	        <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
         	       <th align="center" class="headngblue" >Select to Transfer</th> 
         	        </tr>	
         	       <g:each in="${listAbc}" status="i" var="listInstance">
         	       <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
         	       
         	       <% SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
         	       String strDate = sdfDestination.format(listInstance.application.actualApplicationDate); 
         	       String consentFor = listInstance.application.certificateFor
         	        int count=1
         	       if(consentFor.equals("new")){
         	       consentFor="Fresh"
         	       }
         	       if(consentFor.equals("Modern")){
         	       consentFor = "Modernization "
         	       }
         	       if(consentFor.equals("expan")){
         	       consentFor = "Expansion"
         	       }
         	       if(consentFor.equals("reNew")){
         	        consentFor = "Renew"
         	       }
         	      String applicationFor = listInstance.application.applicationFor
         	    
         	       if(applicationFor.equals("brickkilns")){
         	       applicationFor="Brick Kilns"
         	       }
         	       if(applicationFor.equals("both")){
         	       applicationFor = "Industry "
         	       }
         	       if(applicationFor.equals("stonecrusher")){
         	       applicationFor = "Stone Crusher"
         	       }
         	      if(applicationFor.equals("hotmixplants")){
                      applicationFor = "Hot mix plants"
                      }
                  if(applicationFor.equals("stonecrusher and hotmixplants")){
                      applicationFor = "Stone Crusher and Hot mix plants"
                      }
         	       if(applicationFor.equals("hotel")){
         	        applicationFor = "Hotel"
         	       }
         	        if(applicationFor.equals("dgset")){
         	        applicationFor = "DGSet"
         	       }
         	       
         	       %>
         	       <td align="center" height="25" class="txt4"  ><%=++i%></td>
         	       <td align="center" height="25" class="txt4"  ><%=listInstance.application%></td>
         	      <td align="center" height="25" class="txt4"  ><%=listInstance.application.actualApplicationDate%></td>
         	     <td align="center" height="25" class="txt4"  >${listInstance.application.applicationType}</td>
         	      <td align="center" height="25" class="txt4"  >${listInstance.application.applicationName}<br>( <%=consentFor%> )</td>
         	      <td align="center" height="25" class="txt4"  ><%=applicationFor%></td>
         	       <td align="center" height="25" class="txt4"  ><%=listInstance.applicationStatus%></td>
         	      <td align="center" height="25" class="txt4"  ><%=listInstance.role.group.groupName%></td>
         	     <td align="center" height="25" class="txt4"  ><%=listInstance.role.roleName%></td>
         	       <td align="center" height="25" class="txt4"  ><%=listInstance.pendingWith%></td>
         	       <td align="center" height="25" class="txt4"  >
         	      <input type="checkbox" name="multipleForwardApp" value="${listInstance.application.id}"></font> </td>  
                  </td>
         	   </tr>
         	</g:each>
         	
         	<%} else if(listWaste){%>
         	 <tr height="20" bgcolor="#A8DAF3">

             
  	        <th align="center" class="headngblue" >Application ID</th>
  	        <th align="center" class="headngblue" >Application Date</th>
  	        <th align="center" class="headngblue" >Application For</th>
  	       <th align="center" class="headngblue" >Industry Name</th>
  	       
  	       <th align="center" class="headngblue" >Status</th>
  	       <th align="center" class="headngblue" >Group</th>
  	      <th align="center" class="headngblue" >Role</th>
  	        <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
  	       <th align="center" class="headngblue" >Select to Transfer</th> 
  	        </tr>	
  	       <g:each in="${listWaste}" status="i" var="listInstance">
  	       <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
  	       
  	       <% SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
  	       String strDate
  	       String nameOfIns
  	       String consentFor = listInstance.applicationFor
  	       String authorisationAppliedFor
  	       def appInstance
  	       if(consentFor=='BMW'){
  	    	  appInstance=BioMedicalWaste.find("from BioMedicalWaste bm where bm.id=?",[listInstance.applicationId.toLong()])
  	    	  strDate = sdfDestination.format(appInstance.dateCreated);
  	    	  nameOfIns=appInstance.industryRegMasterObj.indName
  	    	 authorisationAppliedFor=appInstance.authorisationAppliedFor
  	    	}else if(consentFor=='HWM'){
  	    		appInstance=HazardeousWasteAuthApp.find("from HazardeousWasteAuthApp bm where bm.id=?",[listInstance.applicationId.toLong()])
  	    		strDate=sdfDestination.format(appInstance.dateCreated);
  	    		nameOfIns=appInstance.industryRegMasterObj.indName
  	    		authorisationAppliedFor=appInstance.is_Renew
  	    	}
  	        %>
  	       
  	       <td align="center" height="25" class="txt4"  ><%=listInstance.applicationId%></td>
  	      <td align="center" height="25" class="txt4"  ><%=strDate%></td>
  	     <td align="center" height="25" class="txt4"  >${listInstance.applicationFor} <br><%=authorisationAppliedFor %></td>
  	      <td align="center" height="25" class="txt4"  ><%=nameOfIns%></td>
  	      <td align="center" height="25" class="txt4"  ><%=listInstance.applicationStatus%></td>
  	      <td align="center" height="25" class="txt4"  ><%=listInstance.role.group.groupName%></td>
  	     <td align="center" height="25" class="txt4"  ><%=listInstance.role.roleName%></td>
  	       <td align="center" height="25" class="txt4"  ><%=listInstance.pendingWith%></td>
  	       <td align="center" height="25" class="txt4"  >
  	      <input type="checkbox" name="multipleForwardWasteApp" value="${listInstance.applicationId}"></font> </td>  
           </td>
  	   </tr>
  	</g:each><% }%>
          </div> </table>
          
          <table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">	<tr >
			<td  bgcolor="#A8DAF3" align="right" class="headngblue" >Assign To : </td>
		 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
		 	<g:select
			optionKey="id" from="${GroupMaster.list(sort:'groupName')}"
			name="group.id"
			noSelection="${[9999:'Not Selected']}"
			onchange="${remoteFunction(controller:'userMaster', action:'myOfficers',update:'updateSelect', params:'\'cont=\' + this.value' )}"
			value=""
			class="txt4"></g:select>
			<div id="updateSelect"><g:select optionKey="id"
				from="${dist}" name="forward" id="forward"
				value=""
				class="txt4"></g:select>
			</div>	 
			</span></span>				</td>
		</tr></table>
		  <table width="95%" align="center">
 		<tr>
 		<td colspan="3">&nbsp;</td>
 		</tr>
	  <tr>
	  <td><input name="appId" type="hidden" value=""/></td>
		<td align="center"><input type="submit" name="Save" value="Save" class="actionbutton" ></td>
				
	  </tr>
	</table></g:form>
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


<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("districtCode","req","Please enter code");
 frmvalidator.addValidation("districtCode","numeric","Please enter valid code");
 
 frmvalidator.addValidation("districtName","alpha_s","enter valid districtName");
 frmvalidator.addValidation("districtName","req","Please enter district name");
 
 
 
 
</script>  
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


