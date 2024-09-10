<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<head>
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

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
<script type="text/javascript">
 function random_number(min,max) {

		return(Math.round((max-min) * Math.random() + min));
	} 

</script>
 
<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

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
 <form action="industryMasterSave" method="post" id="myform" name="myform" enctype="multipart/form-data">
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
		<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
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
				<% }} %>
				
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
              </tr> <%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aa=(UserProfile)session.getAttribute("userprof");
             		  firstname=aa.employeeFirstName;
           		  lastName=aa.employeeLastName;
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
					<tr>
							<td ><g:link controller="industryRegMaster" action="industryMasterList" ><span class="innerlink">&nbsp;Update&nbsp;|</span> </g:link></td>
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div   style="width:400px; height:20px; vertical-align:middle"><span class="error"><g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indUserInstance}">
            <div class="errors">
                <g:renderErrors bean="${indUserInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:hasErrors bean="${indRegMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${indRegMasterInstance}" as="list" />
            </div>
            </g:hasErrors></span></div></td>
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
	
	    
	     <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="70%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Industry Details</span></a></li>
						
					</ol>
				  </td>
				  <td  width="30%" align="right" >
				  </td>
				</tr>		
	    </table>
          <div id="country1" class="content" >
  			<table width="90%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				                      
                      <tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                          <tr align="center" bgcolor="#F4F7FB">
                            <td width="30%" align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name*:</td>
                            <td width="70%" align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input name="indName" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indName')}" maxlength="50" size="25" /><span class="txt4"> (max 50 characters)</span></td>
                          </tr>
                     
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue ">Commisioning Year*: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input name="dateOfComm" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'dateOfComm')}"  maxlength="4" class="txt4" /> <span class="txt4"> e.g. 2002</span></td>
                          </tr>
                          <tr >
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue">Registeration/License No.*:</td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input name="indRegNum"  maxlength="50" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indRegNum')}" /><span class="txt4"> &nbsp;(enter registration/license no)</span></td>
                          </tr>
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Capital Investment*: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input name="indCapInvt" type="text" class="txt4"  maxlength="25" value="${fieldValue(bean:industryRegMasterInstance,field:'indCapInvt')}" /><span class="txt4"> (in lakhs)</span></td>
                          </tr>
                          <tr >
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Address*: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><textarea name="indAddress" cols="40" value="${fieldValue(bean:industryRegMasterInstance,field:'indAddress')}"  maxlength="200" class="txt4"></textarea><span class="txt4"> &nbsp;(enter industry address)</span></td>
                          </tr>
                          
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Plot No./Khata*: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'plotNo','errors')} txt"><input name="plotNo" type="text" class="txt4"  maxlength="25" value="${fieldValue(bean:industryRegMasterInstance,field:'plotNo')}" /><span class="txt4"> &nbsp;(enter plot no.)</span> </td>
                          </tr>
                          
                          
                          <trbgcolor="#F4F7FB" >
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> City: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input name="indCity" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'indCity')}"  maxlength="25" class="txt4" /><span class="txt4"> &nbsp;(enter city of industry locality)</span></td>
                          </tr>
                          <tr >
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> District:* </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><g:select optionKey="id" from="${DistrictMaster.list()}" name="district.id" noSelection="${['9999':'Not Selected']}"  onclick="${remoteFunction(controller:'industryRegMaster', action:'myAjax',update:'updateSelect', params:'\'cont=\' + this.value' )}" value="${industryRegMasterInstance?.district?.id}" class="txt4" ></g:select><span class="txt4"> &nbsp;(select district)</span></td>
                          </tr>
                          <tr bgcolor="#F4F7FB" >
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Tehsil: * </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><div id="updateSelect">
							<g:select noSelection="${['null':'Not Selected']}" optionKey="id" from="${tehsilList}" name="tehsil.id" value="${industryRegMasterInstance?.tehsil?.id}"  class="txt4"></g:select><span class="txt4"> &nbsp;(select tehsil)</span></td>
                          </tr>
                          
                          
                          
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Pin: </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input name="indPin"  maxlength="10" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'indPin')}" class="txt4" /><span class="txt4"> &nbsp;(enter PIN of industry address)</span></td>
                          </tr>
                          <tr >
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Phone No. With Code :* </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt">
								
                                <input name="indPhoneCode" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneCode')}" size="10" />
                                <input name="indPhoneNo" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneNo')}" size="15"  /><span class="txt4"> &nbsp;(STD Code - Number)</span></td>
                          </tr>
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> Fax No. With Code : </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt">
								
				 				<input name="indFaxCode" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxCode')}" size="10" />
                                <input name="indFaxNo"  maxlength="15" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxNo')}" class="txt4" size="15" /><span class="txt4"> &nbsp;(STD Code - Number)</span></td></div>
                          </tr>
                          <tr bgcolor="#F4F7FB">
                            <td align="right" bgcolor="#A8DAF3"  class="headngblue"> E-Mail Address: </td>
                            <td width="70%" align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"> <input name="indEmail"  maxlength="100" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indEmail')}" size="20" /><span class="txt4"> &nbsp;(e.g. info@abc.com)</span> </td>
                          </tr>
           
						  
                        </table></td>
                      </tr>
                     
                      
                      
                      
	  </table>
	  		
	  		
          </div>
      
          </div>
          
          
          
 											<table width="95%"> 
 											<tr>
													<td width="9%">&nbsp;</td>
														<td colspan="4" align="left" class="txtR">Fields marked * are mandatory</td>
													</tr>
													</table>
          
		  
		  
		  
		  	<table width="95%">
				  <tr ><td colspan="2">&nbsp;</td></tr>
					  <tr >
						<td align="right"><input type="submit" name="save"  value="Save" action="industryMasterSave" class="actionbutton"></td>
						<td align="left"><input type="reset" name="reset" value="reset" class="actionbutton"></td>
					  </tr>
				</table>
		  
		  
		  
		  
		  
		  
		  
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
    var tehsil = document.getElementById('tehsil.id');
  
    if((tehsil.value == "")||(tehsil.value == " "))
    {  
   		 sfm_show_error_msg('Tehsil for Industry is not Specified',tehsil);
    	 return false;
     }
      else {
        	return true;
 	  } 

   }
   
   
	frmvalidator.setAddnlValidationFunction("Checkfiles"); 
	

 

 frmvalidator.addValidation("indName","req","Please enter Industry Name");
  frmvalidator.addValidation("indName","alnum_sr","Please enter Valid Industry Name");
 
 frmvalidator.addValidation("indEmail","email","Enter valid Industry email-Id");
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits");
 frmvalidator.addValidation("dateOfComm","req","please enter year of commissioning");
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric"); 
 
 frmvalidator.addValidation("indRegNum","alnum_sr","industry registration no. must be alphanumeric");
  frmvalidator.addValidation("indRegNum","req","please enter industry registration no.");
  
 frmvalidator.addValidation("indCapInvt","numeric","capital investment must be numeric");
  frmvalidator.addValidation("indCapInvt","req","please enter capital investment");
  
 frmvalidator.addValidation("indCity","alpha_s","check industry's city name");
 
 frmvalidator.addValidation("indPin","numeric","pin number  must be numeric");
  
 frmvalidator.addValidation("indPhoneNo","numeric","phone number  must be numeric");
 frmvalidator.addValidation("indPhoneNo","req","please enter phone number");
 
 frmvalidator.addValidation("indFaxNo","numeric","fax number  must be numeric");

frmvalidator.addValidation("district.id","dontselect=0","Please enter industry District");
 frmvalidator.addValidation("district.id","req","Please enter industry District");
 
 
</script>


</body>
</html>


