<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="scriptaculous"/>
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
%>


<g:javascript>
		window.onload = function()   
           	 
           	   {           
			   	  new Ajax.Autocompleter("autocomplete","autocomplete_choices","<%=cont%>/userProfile/ajaxAutoComplete1",{} );             
			       new Ajax.Autocompleter("autocompleteA","autocomplete_choices1","<%=cont%>/userProfile/ajaxAutoComplete2",{} ); 
			 }
			 </g:javascript>
	<% 
String cont1=request.getContextPath()
 if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(cont1+"/index.gsp")  ;     
} %>
			
<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
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
							
					<td  align="left">
					<g:link controller="userProfile" action="create" ><span class="innerlink">&nbsp;Add&nbsp;|</span></g:link>
					  		
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
       
			<form id="myForm" name="myForm" action="userSearch" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search SPCB User</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							   <td width="432" align="right" >	</td>
							</tr>
	    </table>
		
		
		
        
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				<tr>
						<td colspan="4" bgcolor="#A8DAF3" align="left">
						<input type=radio checked="true" name="searchOp" id="searchOp" value="EmpId" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> ><span class="headngblue">By Employee Id</span></td>
						
						</tr>
						
                      <tr  >
                        <td width="10%" class="headngblue"  bgcolor="#E8F6F9"   align="left" >Employee Id:</td>
                        <td align="left" colspan="3" bgcolor="#E8F6F9">
                            <input type="text" id="autocompleteA" name="idsearch" value=""/>
                            <span class="txt">&nbsp;(Enter first character of employee id)</span>
                     <!--   <g:select optionKey="id" from="${IndApplicationDetails.list()}" id="autocomplete" name="autocomplete_parameter" noSelection="${['xyz':'Not Selected']}" ></g:select> -->
                        </td>
                      </tr>
                       <tr align="center">
						<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio   name="searchOp" id="searchOp1" value="empName" ><span class="headngblue">By Employee Name</span></td></tr>
                 <tr  bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Enter First Name:*</td>
                        <td width="35%" align="left" >
                         <div id="auto2"> 
                         <input type="text" id="autocomplete" name="autocomplete_parameter" value=""/>
                         <span class="txt">&nbsp;(Enter first character of name)</span></div>
                         
						 </td>
                      </tr>
      
	  </table>
	  
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="right"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
 
		</table>
				<div align="left" class="txt" style="color: navy">
			   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to update the  district:-
			  <ul> 
			  	<li>Select the search criteria By Employee ID/ Name</li>
			  	<li>Enter first character of employee if or name as selected, select value from the drop down list based on first character</li>
				<li>Click Search button to search the details</li>
				<li>Click on to the Id from the search result</li>
				<li>Click Edit button to open the form in edit mode</li>
				<li>Update the details as required</li>
				<li>Click update button to save the record</li>
			  </ul>
		</div>		
		 </form>
		<table ><tr><td>
		
			<div id="autocomplete_choices" class="autocomplete" ></div>
			<div id="autocomplete_choices1"  class="autocomplete" ></div>
            </td>
            </tr></table>
		
		<g:if test="${userIdSearch}">
            
           <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr  bgcolor="#A8DAF3">  
				<th align="center" class="headngblue" width="20%" >Id </th>  
				<th align="center" class="headngblue" width="40%" >Name </th>  
				<th align="center" class="headngblue" width="10%" >Department </th>  
				<th align="center" class="headngblue" width="10%" >Designation</th>  
				<th align="center" class="headngblue" width="20%" >Date Created</th>               
				
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
		
		
            <br />
            <br />
          </div>
		  
		 
		  
	  
		  
          </div>
	  

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
<script language="JavaScript" type="text/javascript">

    var frmvalidator  = new Validator("myForm");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 
   
   function checkform(){
              
    		 var frm = document.forms["myForm"];
    		 var empname1 = document.getElementById('autocomplete'); 
    		 var empid = document.getElementById('autocompleteA'); 
    		 var radio = document.getElementById('searchOp');
    		 var radio2 = document.getElementById('searchOp1');
    		
      if ((radio.checked == true) && ((document.getElementById('autocompleteA').value == "")||(document.getElementById('autocompleteA').value == " " )))
   { 
      
       sfm_show_error_msg('please enter employeeId',empid);  
       return false;
      }
      
     
      else{
      
      if ((radio2.checked == true) && ((document.getElementById('autocomplete').value == "")||(document.getElementById('autocomplete').value == " " )))
      {
      sfm_show_error_msg('please enter employee Name',empname1);  
       return false;
      }
       else { 
     
      return true;
      } 
     
    }
   }

  frmvalidator.setAddnlValidationFunction("checkform"); 
  
  
 </script>

</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


