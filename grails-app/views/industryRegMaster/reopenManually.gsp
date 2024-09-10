<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">

<!----------------------added by saroj---for audit issue--resolved------------------>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="X-Frame-Options" content="deny">

<style id="antiClickjack">body{display:none !important;}</style>

<script type="text/javascript">
if (self === top) {
    var antiClickjack = document.getElementById("antiClickjack");
    antiClickjack.parentNode.removeChild(antiClickjack);
} else {
    top.location = self.location;
}
</script>
<!-------------------------end------------------------------>


<!--start by shashank-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
    body { font-size: 62.5%; }
    label, input { display:block; }
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eeea; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>
  <script>
  $(function() {
    var dialog, form,
 
      // From https://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
     // emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
      name = $( "#name" ),
     
      allFields = $( [] ).add( name )
      tips = $( ".validateTips" );
 
    function updateTips( t ) {
      tips
        .text( t )
        .addClass( "ui-state-highlight" );
        setTimeout(function() {
        tips.removeClass( "ui-state-highlight", 1500 );
      }, 500 );
    }
 
    function checkLength( o, n, min, max ) {
      if ( o.val().length > max || o.val().length < min ) {
        o.addClass( "ui-state-error" );
        updateTips( "Length of " + n + " must be between " +
          min + " and " + max + "." );
        return false;
      } else {
        return true;
      }
    }
 
    function checkRegexp( o, regexp, n ) {
      if ( !( regexp.test( o.val() ) ) ) {
        o.addClass( "ui-state-error" );
        updateTips( n );
        return false;
      } else {
        return true;
      }
    }
 
    function addUser() {
     var valid = true;
      allFields.removeClass( "ui-state-error" );
 
      valid = valid && checkLength( name, "Text", 0, 200 );
     
 
      valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Text may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
     
      if ( valid ) {
      // alert("true")
      dialog.dialog( "close" );
      //window.location.href="changStatus";
      document.getElementById("myform1").submit();
      return valid;
      }
      else
      {
     // alert("false")
      return false;
      }
   
    }
 
    dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 250,
      width: 400,
      modal: true,
      buttons: {"Continue": addUser,Cancel: function() {
          dialog.dialog( "close" );
        }
      },
       close: function() {
         allFields.removeClass( "ui-state-error" );
        }
      
    });    
 
    $( "#create-user" ).button().on( "click", function() {
      dialog.dialog( "open" );
    });
  });
  </script>
<!--end by shashank-->

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
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

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

function validateform(){
	
var x11 = document.forms["myform1"]["otpValue"].value;
var x = document.forms["myform1"]["name"].value;
var y= document.forms["myform1"]["otp"].value;



if(y==""){
	
   	alert("Please enter OTP");
       return false;
   }



if (x == "") {
   alert("Reason of Re-Open  must be filled out");
   return false;
}

if(y==x11){
	
}else{
	alert("Please Enter correct OTP.")
	return false;
}



}
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();
   String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF>
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
       
			 
	 
 		
		<g:if test="${checkInst}">
            
           

<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

                  <tr height="20" bgcolor="#A8DAF3">

                        
                   	        <th align="center" class="headngblue" >Application ID</th>
                   	        <th align="center" class="headngblue" >Industry User </th>
                   	        <th align="center" class="headngblue" >Application Type</th>
                   	        <th align="center" class="headngblue" >Application For</th>
                   	        <th align="center" class="headngblue" >Application Date</th>
                   	        <th align="center" class="headngblue" >Application Name</th>
                   	        <th align="center" class="headngblue" >Certificate For</th>
                   	        <th align="center" class="headngblue" >Status</th>
                   	       
                   	        <th align="center" class="headngblue" >Last Pending With</th> 
                   	        </tr>

                    <g:each in="${abc}" status="i" var="abc">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       		
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'id')}</td>
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'indUser')}</td>
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationType')}</td>
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationFor')}</td>
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationDate')}</td>
                        
                            <td align="center" height="25"  class="txt4"  >${fieldValue(bean:abc, field:'applicationName')}</td>
                            
                           
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'certificateFor')}</td>
                        	<td align="center" height="25" class="txt4"  ><%=statusList.get(i)%></td>
                        	
                        	<td align="center" height="25" class="txt4"  width="30">${pendingWithRole.get(i) }(${pendingWith.get(i) })</td>
                        </tr>
                    </g:each>
					
					
                </table>
         <table width="100%" align="center" cellpadding="0" cellspacing="0" class="tab-txt" >
	<!--	<tr align="center"><td><a href="<%=request.getContextPath()%>/completedToInprogress/moveApplication?appliId=<%=abc.id%>"><font size="2" color="red" face="verdana"><b><u>Move Application from Completed to Inprogress</u></b></font></a></td></tr> -->
		</tr><td>&nbsp;</td><tr>
<div  title="Submmit Details for Move application">
<p class="validateTips"></p>
   <g:form id="myform1" name="myform1" enctype="multipart/form-data" action="changStatus"  onsubmit="return validateform();">
   
   <td align="center" height="25" class="txt4" width="30" >
    <label for="name">Enter OTP<span style="color:red">*</span></label>
    <input name="otp" id="otp" maxlength="200" class="txt4" class="text ui-widget-content ui-corner-all"/>

      <label for="name">Reason For Re-Open Application<span style="color:red">*</span></label>
      <textarea name="name" id="name" rows="5" cols="59" maxlength="200" class="txt4" class="text ui-widget-content ui-corner-all"></textarea>
     
      <label for="name">Upload document for Re-Open<span style="color:red"></span></label>
      <input type="file" name="documentGrievance" id="documentGrievance"/><span class="sidetxt ">(.pdf max of 2MB in size) </span>
      <br><br>
   <%
   def completedToInprogressRecordObj11=ReopenApplicationRecord.find("from ReopenApplicationRecord abc where abc.application.id=? and appReopenStatus=false",[(abc.id).toLong()])
  
   if(completedToInprogressRecordObj11.otp){
   
   %>
   <input type="hidden" name="otpValue" value="${completedToInprogressRecordObj11.otp}"/></td>
      <%}%>
      <input type="hidden" name="applicationId" value="${abc.id}"/></td>
      <tr align="center">
      <td>


      <b><u><font size="10" color="red" face="verdana"><input  type="submit" value="Re-Open Application"</u></b></font>
     </td></tr>
    
  </g:form>
</div>
<tr align="center">
<td> <form><g:actionSubmit value="Back" action="reOpenApp"/></form></td></tr>

 
		</table>
		
		</g:if>
		
		
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>


