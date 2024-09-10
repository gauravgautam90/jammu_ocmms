<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Inspection Forward Criteria Admin Home</title>


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


<% String cont=request.getContextPath()

%>


<g:javascript library="prototype" />



<g:javascript>
document.observe('dom:loaded', function() {
	
   $("officeSelected").observe("change", respondToSelect);
   });

   
 function respondToSelect(event)
 {
       new Ajax.Updater("GroupSelected",
          "<%=cont%>/roleMaster/updateSelect1",
          {method:'get', parameters: {selectedValue : $F("officeSelected")} }
         );
 }

</g:javascript>

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
	
	
 frmvalidator.addValidation("applicationType","req","Please choose application type");
 frmvalidator.addValidation("categoryType","req","Please choose category");
 frmvalidator.addValidation("moduleType","req","Please choose module type");
 frmvalidator.addValidation("forwardTo","req","Please choose forword to");
	
	function checkForm(){
	    var applicationType = document.getElementById('applicationType').value;
		var categoryType = document.getElementById('categoryType').value;
		var moduleType = document.getElementById('moduleType').value;
		var forwardTo = document.getElementById('forwardTo').value;
	if(applicationType == null || applicationType == 'None' ){
		alert("Please choose application type");
		return false;
	}if(categoryType == null || categoryType == 'None' ){
		alert("Please choose category type");
		return false;
	}if(moduleType == null || moduleType == 'None' ){
		alert("Please choose module type");
		return false;
	}if(forwardTo == null || forwardTo == 'None' ){
		alert("Please choose Forward To ");
		return false;
	}
	return true;
	
	}
	
</script>
<% 

      String contex=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

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
					<g:link controller="inspectionManagement" action="createInspectionForwardCriteria" ><span class="innerlink">&nbsp;Create&nbsp;|</span></g:link> 
							
							</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${inspectionForwardCriteriaInstance}">
            <div class="errors">
                <g:renderErrors bean="${inspectionForwardCriteriaInstance}" as="list" />
            </div>
            </g:hasErrors>  
             <g:hasErrors bean="${inspectionForwardCriteriaInstance}">
            <div class="errors">
                <g:renderErrors bean="${inspectionForwardCriteriaInstance}" as="list" />
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
         <g:form action="saveInspectionForwardCriteria" name="myform" method="post" >
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
          <div id="country1" >
  			
<table width="110%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

                  <tr height="20" bgcolor="#A8DAF3">

							<th align="center" class="headngblue" width="10%">Sno</th>
                            <th align="center" class="headngblue" width="10%">Application Type.</th>
                            <th align="center" class="headngblue"width="10%" >Category Type.</th>
                   	        <th align="center" class="headngblue" width="20%">Module Type</th>
                   	        <th align="center" class="headngblue" width="20%">Group</th>
                   	        <th align="center" class="headngblue" width="20%">Forward To</th>
                   	        <th align="center" class="headngblue" width="20%">Role Type</th>
                   	        <th align="center" class="headngblue" width="20%">Industry Type</th>
                   	        <th align="center" class="headngblue" width="20%">Capital Investment(In Lakhs)</th>
                   	        <!--<th align="center" class="headngblue" width="10%">No Of RO Officer</th>
                   	        <th align="center" class="headngblue" width="10%">No Of HO Officer</th>-->
                   	        <th align="center" class="headngblue" width="10%">Delete</th>
                   	       </tr>
				
<%
       System.out.println("insForwardInstance gsp >> "+insForwardInstance);
       

%>
                    <g:each in="${insForwardInstance}" status="i" var="abc">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       		<td align="center" height="25" class="txt4"  >${i+1}</td>
                       		
                       		<td align="center" height="25" class="txt4"  >${abc.applicationType}</td>
                       		
                            <td align="center" height="25" class="txt4"  >${abc.categoryType}</td>
                        
                            <td align="center" height="25" class="txt4"  >${abc.moduleType}</td>
							
							<td align="center" height="25" class="txt4"  >${abc.groupMaster}</td>
							
							<td align="center" height="25" class="txt4"  >${abc.userMaster} - ${abc.roleName}</td>
							
							<td align="center" height="25" class="txt4"  >${abc.forwardRoleType}</td>
							
							<td align="center" height="25" class="txt4"  >  
							   <g:if test="${abc.industryType != 'ALL'}" >
							       ${IndustryTypeMaster.get(abc.industryType.toLong()) }    
							   </g:if>
							   <g:else> ALL</g:else>
							</td>
							
							<td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'capitalInvestment')}</td>
							
                        	<td align="center" height="25" class="txt4"  ><g:link controller="inspectionManagement" action="deleteInspectionForwarCriteria" params="[id:abc.id]"><span class="innerlink"><u>Delete</u></span></g:link></td>
                        	
                        </tr>
                    </g:each>
					
					
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
</table></g:form>

<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("applicationType","req","Please choose application type");
 frmvalidator.addValidation("categoryType","req","Please choose category");
 frmvalidator.addValidation("moduleType","req","Please choose module type");
 frmvalidator.addValidation("forwardTo","req","Please choose forword to");
 //frmvalidator.addValidation("roleName","alnum_s","Enter valid rolename");
// frmvalidator.addValidation("roleDesc","alnum_s","enter valid description");
 
 

 
 
</script>
</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

