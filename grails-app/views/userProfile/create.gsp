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
<calendar:resources lang="en" theme="aqua"/>
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
<Style>
BODY, P,TD{ font-family: Arial,Verdana,Helvetica, sans-serif; font-size: 10pt }
A{font-family: Arial,Verdana,Helvetica, sans-serif;}
B {	font-family : Arial, Helvetica, sans-serif;	font-size : 12px;	font-weight : bold;}
.error_strings{ font-family:Verdana; font-size:10px; color:#660000;}
</Style>

<script type="text/javascript">
 
	function random_number(min,max) {
     return(Math.round((max-min) * Math.random() + min));
	} 

</script>
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



<g:javascript>
document.observe('dom:loaded', function() {
	
   $("grpSelected").observe("click", respondToSelect);
   });

   
 function respondToSelect(event)
 {
       new Ajax.Updater("des",
          "<%=cont%>/userProfile/myAjax3",
          {method:'get', parameters: {selectedValue : $F("grpSelected")} }
         );
 }
 
  function respondToSelectRole(event)
 {
       new Ajax.Updater("grpSel",
          "/SPCB/RoleMaster/updateGrpSel",
          {method:'get', parameters: {selectedValue : $F("grp")} }
         );
 }

</g:javascript>
<g:javascript>

function select1()
{
var selectmenu1=document.getElementById("type")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if((chosenoption.value == "Temporary") || (chosenoption.value == "Contractor"))
   	 {
   	 document.getElementById('selectTemp').style.display = 'block';
	 }
else{
    if (chosenoption.value == "Permanent")
    	{
    document.getElementById('selectTemp').style.display = 'none';
   		 }
    }
 }
} 
</g:javascript>



<% 
String cont1=request.getContextPath()
 if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(cont1+"/index.gsp")  ;     
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
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
					<td  align="left">
					<g:link controller="userProfile" action="list1" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link>  		
					</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px;  vertical-align:middle"><span class="error">

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
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Add User</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right" ></td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			   <tr class="headngblue txt4" >
		    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >First Name*</td>
		    <td width="60%" bgcolor="#E8F6F9"  align="left" class="value ${hasErrors(bean:userProfileInstance,field:'employeeFirstname','errors')}">
		    <input name="employeeFirstName" type="text" maxlength="50" id="employeeFirstName"  value="${fieldValue(bean:userProfileInstance,field:'employeeFirstName')}" size="30" AUTOCOMPLETE=OFF class="txt4"/><span class="txt">(Max 50 characters)</span></td>
			   </tr>

  <tr class="headngblue txt4">
	    <td align="left"  bgcolor="#A8DAF3" class="headngblue">Last Name* </td>
	    <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:userProfileInstance,field:'employeeLastName','errors')}"><input name="employeeLastName" type="text" id="#" size="30" maxlength="50" class="txt4" value="${fieldValue(bean:userProfileInstance,field:'employeeLastName')}" AUTOCOMPLETE=OFF /><span class="txt">(Max 50 characters)</span></td>
  </tr>
  
   <tr class="headngblue txt4">
	    <td align="left" bgcolor="#A8DAF3" class="headngblue">Access Level*: </td>
	    <td align="left" bgcolor="#E8F6F9" class=value${hasErrors(bean:userProfileInstance,field:'acessLevel','errors')}">
	    <select name="accessLevel"  class="txt4">
      				<option value="admin">admin</option>
      				<option value="employee">employee</option>
	  				
      </select><span class="txt">&nbsp;(Select access level)</span></td>
  </tr>

  <tr class="headngblue txt4" >
	    <td align="left" bgcolor="#A8DAF3" class="headngblue" >Employee ID*:</td>
	    <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:userMasterInstance,field:'id','errors')}">
	    <input name="id" type="text" size="15" maxlength="15" value="${fieldValue(bean:userMasterInstance,field:'id')}" class="txt4" AUTOCOMPLETE=OFF /> <span class="txt">(Max 15 characters)</span></td>
  </tr>


  <tr class="headngblue txt4">
	    <td align="left" bgcolor="#A8DAF3" class="headngblue">Department*:</td>
	   <td  bgcolor="#E8F6F9"align="left"  class="value ${hasErrors(bean:userProfileInstance,field:'department','errors')}"> 
	   <g:select optionKey="id" from="${DepartmentMaster.list()}" id="grpSelected" name="department_id" class="txt4" ></g:select>
	   <span class="txt">&nbsp;(Select department)</span> </td>
  </tr>

  

  <tr class="headngblue txt4" >
	    <td align="left" bgcolor="#A8DAF3" class="headngblue">Designation*:</td>
	    <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:userProfileInstance,field:'designation','errors')}">
			<div id="des">
				<g:select optionKey="id" from="${DesignationMaster.list()}" id="designation_id" name="designation_id" class="txt4"></g:select> 
			<span class="txt">&nbsp;(Select designation)</span></div>    	</td>
  </tr>
  
 	<tr class="headngblue txt4" >
	    <td align="left" bgcolor="#A8DAF3" class="headngblue">Employee Type*:</td>
	    <td align="left" bgcolor="#E8F6F9" >
			<select name="type" id="type" onclick="javascript:select1()" class="txt4">
      				<option value="Permanent">Permanent</option>
      				<option value="Temporary">Temporary</option>
	  				<option value="Contractor">Contractor</option>
      </select><span class="txt">&nbsp;(Select Employee type)</span></td>
  </tr>
  
   						

<tr class="headngblue txt4"  >
<td colspan="2">
<div style="display:none; border:0;"  id="selectTemp"  >
<table cellpadding="0" cellspacing="0" ><tr class="headngblue txt4" >
   <td align="left" width="40%" bgcolor="#A8DAF3" class="headngblue">Enter Start_Date and End_Date of Service:</td>
   <td align="left" bgcolor="#E8F6F9"><table cellpadding="0" cellspacing="0"><tr><td  class="txt4" width="30%">Start Date:</td><td align="left"  >
 
 <calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
 <!--   <input type="text" id="start_date" name="start_date" readonly class="txt4" size="12" />
						<script language="JavaScript">
									new tcal ({
										// form name
										'formname': 'myform',
										// input name
										'controlname': 'start_date'
									});
								
									</script> -->
									<span class="txt">&nbsp;(Select start date)</span></td></tr>
  

    
                        
						<tr><td class="txt4">End Date:</td><td align="left">
						<!-- <input type="text" readonly id="end_date" name="end_date" class="txt4" size="12"/>
						<script language="JavaScript">
							new tcal ({
								// form name
								'formname': 'myform',
								// input name
								'controlname': 'end_date'
							});
						
							</script> -->
							<calendar:datePicker name="end_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							<span class="txt">&nbsp;(Select end date)</span></td></tr></tr></table></td>
							</tr></table>
							 </div>
         </td>          
    </tr>

      <tr class="headngblue txt4" >
	    <td align="left" bgcolor="#A8DAF3" class="headngblue">Status*:</td>
	    <td align="left" bgcolor="#E8F6F9"  >
			<select name="status"  class="txt4">
      			<option value="inactive">inactive</option>
		      <option value="active">active</option>
    		</select><span class="txt">&nbsp;(Select employment status)</span></td>
  </tr>

  <tr class="headngblue txt4">
    <td align="left" bgcolor="#A8DAF3" class="headngblue">Mobile No.* </td>
    <td align="left" bgcolor="#E8F6F9"  class="value${hasErrors(bean:userProfileInstance,field:'mobile','errors')}">
    <input name="mobile"  type="text" maxlength="12" id="#" size="12" class="txt4" value="${fieldValue(bean:userProfileInstance,field:'mobile')}" AUTOCOMPLETE=OFF /><span class="txt">(Max 12 digits with country code)</span></td>
  </tr>

  <tr class="headngblue txt4">
    <td align="left"  bgcolor="#A8DAF3" class="headngblue">Contact No_office* </td>
    <td align="left" bgcolor="#E8F6F9"  class="value${hasErrors(bean:userProfileInstance,field:'officePhone','errors')}">
    <input name="officePhone" maxlength="11" size="12" type="text" id="#" size="30" class="txt4" value="${fieldValue(bean:userProfileInstance,field:'officePhone')}" AUTOCOMPLETE=OFF /><span class="txt">(Max 12 digits with country code)</span></td>
  </tr>
  <tr class="headngblue txt4">
    <td align="left" bgcolor="#A8DAF3" class="headngblue">EMail-ID* :</td>
    <td align="left" bgcolor="#E8F6F9"  class="value${hasErrors(bean:userProfileInstance,field:'email','errors')}">
    <input name="email" type="text" id="#"  size="20" class="txt4"  value="${fieldValue(bean:userProfileInstance,field:'email')}" AUTOCOMPLETE=OFF /><span class="txt">(e.g. info@abc.com)</span></td>
  </tr>

    <tr class="headngblue txt4" >
    	<td align="left" bgcolor="#A8DAF3" class="headngblue"> Hint Question* : </td>
    	<td align="left" bgcolor="#E8F6F9"  ><select name="hintQuestion"  class="txt4">

			<option value="What is your Nickname?">What is your Nickname?</option>
			<option value="What is your Birthplace?" >What is your Birthplace?</option>
			<option value="What was your first mobile number?">What was your first mobile number?</option>
			<option value="What is your first school's name ?">What is your first school's name ?</option>
			<option value="What is your Spouse's name?">What is your Spouse's name?</option>

	    </select></td>
  </tr>

  

      <tr class="headngblue txt4">
    		<td align="left" bgcolor="#A8DAF3" class="headngblue">your Answer* :</td>
		    <td align="left" bgcolor="#E8F6F9"  class="value${hasErrors(bean:userMasterInstance,field:'hintAnswer','errors')}"><input name="hintAnswer" type="text"  size="15" maxlength="15" class="txt4" value="${fieldValue(bean:userMasterInstance,field:'hintAnswer')}" AUTOCOMPLETE=OFF /><span class="txt">(Max 15 characters )</span></td>
  </tr>
  
   
  

  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3" colspan="1" class="headngblue">Click to Generate Password* :</td>

    <td align="left" bgcolor="#E8F6F9"  ><input name="submit" type="button" value="generate" onclick="document.myform.passwordEncrypt.value=Math.round((99999-10000)*Math.random() +10000 )"></td>
  </tr>

    <tr class="headngblue" >

    <td align="left" bgcolor="#A8DAF3" class="headngblue"> Generated Password* : </td>

    <td align="left" bgcolor="#E8F6F9"  class="value${hasErrors(bean:userMasterInstance,field:'password','errors')}"><INPUT type="hidden" name="password"  id="password" readonly  size="30" class="txt4" value="${fieldValue(bean:userMasterInstance,field:'password')}" /><INPUT type="text" name="passwordEncrypt"  id="passwordEncrypt" readonly  size="20" class="txt4" value="<%=Math.round((Math.random()+100000)*Math.random())%>" /></td>
  </tr>
  
   <tr class="headngblue" >

    <td align="left" bgcolor="#A8DAF3" class="headngblue"> Do you want to send login Credential in mail? </td>

    <td align="left" bgcolor="#E8F6F9"><g:radio name="radiobutton" value="yes"/>yes
    <g:radio checked="true" name="radiobutton" value="no"/>no
    <span class="txt">(click yes to receive details)</span></td>
  </tr>
</table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Save" value="Save" onclick="userPassEncryption()" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
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



<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    
     function Checkfiles(){
  
    var frm = document.forms["myform"];  
    var startDate = document.getElementById('start_date');
      var endDate = document.getElementById('end_date');
      
      if (startDate.value > endDate.value){
      sfm_show_error_msg('Please check the date range',startDate);
    	 return false;
      }
      else{
      return true;
      }
    }
    
    frmvalidator.setAddnlValidationFunction("Checkfiles");  
 
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


</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


