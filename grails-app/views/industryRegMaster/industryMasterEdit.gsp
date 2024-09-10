<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<script type="text/javascript">
 function random_number(min,max) {

		return(Math.round((max-min) * Math.random() + min));
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
					<td >
					<g:link controller="industryRegMaster" action="industryMasterCreate" ><span class="innerlink">&nbsp;Add&nbsp;|</span> </g:link></td>	
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
										<g:hasErrors bean="${industryRegMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${industryRegMasterInstance}" as="list" />
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
		
		
		
		
		<form action="industryMasterUpdate" name="myform" method="post" >
		<input type="hidden" name="id" value="${industryMasterInstance?.id}" />
                      <input type="hidden" name="version" value="${industryMasterInstance?.version}" />
		

	<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="70%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Industry Details</span></a></li>
						
					</ol>
				  </td>
				  <td  width="30%" align="center" >
				  		
				  </td>
				</tr>		
	    </table>
		
          <div id="country1"  class="content" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				

    <tr class="headngblue txt4"  >
         <td width="40%" align="left" bgcolor="#A8DAF3" >Industry Name* :</td>
         <td width="60%" align="left" bgcolor="#E8F6F9"><input name="indName" type="text" maxlength="50" value="${fieldValue(bean:industryMasterInstance,field:'indName')}"  class="txt4"/><span class="txt4"> (max 50 characters)</span></td>
                     </tr>
  



  <tr class="headngblue txt4">
    <td align="left" bgcolor="#A8DAF3">Commisioning Year*:</td>
    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'dateOfComm','errors')}">
                                    <input type="text" name="dateOfComm" value="${fieldValue(bean:industryMasterInstance,field:'dateOfComm')}" maxlength="4" class="txt4" /> <span class="txt4"> e.g. 2002</span>
                                </td>
  </tr>

  

  <tr class="headngblue txt4" >
    <td align="left" bgcolor="#A8DAF3">Indusrty Regestration No.* :</td>
    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indRegNum','errors')}">
                                    <input type="text" id="indRegNum" name="indRegNum" value="${fieldValue(bean:industryMasterInstance,field:'indRegNum')}" class="txt4"/> <span class="txt4">&nbsp;(enter registration/license no)</span>
                                </td>

  </tr>

  
   

  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Capital Investment* : </td>

   <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indCapInvt','errors')}">
                                    <input type="text" id="indCapInvt" name="indCapInvt" value="${fieldValue(bean:industryMasterInstance,field:'indCapInvt')}"  class="txt4"/><span class="txt4"> (in lakhs)</span>
                                </td>

  </tr>

  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Address* : </td>

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indAddress','errors')}">
                                    <textarea id="indAddress" name="indAddress"  class="txt4"> ${fieldValue(bean:industryMasterInstance,field:'indAddress')}</textarea><span class="txt4"> &nbsp;(enter industry address)</span
                                </td>
  </tr>
  
   
  

  

     <tr class="headngblue txt4">

    <td align="left" bgcolor="#A8DAF3">City* :</td>

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indCity','errors')}">
                                    <input type="text" id="indCity" name="indCity" value="${fieldValue(bean:industryMasterInstance,field:'indCity')}" class="txt4"/><span class="txt4"> &nbsp;(enter city of industry locality)</span>
                                </td>
  </tr>
  
  
  
  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Pin* :</td>

     <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indPin','errors')}">
                                    <input type="text" id="indPin" name="indPin" value="${fieldValue(bean:industryMasterInstance,field:'indPin')}" class="txt4"/><span class="txt4"> &nbsp;(enter PIN of industry address)</span>
                                </td>

  </tr>
  
  
  <tr class="headngblue txt4" >
      <td align="left"  bgcolor="#A8DAF3">Phone No. with STD Code*:</td>
    <td align="left"  bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indPhoneCode','errors')}">
                                    <input type="text" id="indPhoneCode" name="indPhoneCode" value="${fieldValue(bean:industryMasterInstance,field:'indPhoneCode')}" size="5" maxlength="7" class="txt4"/> 
                                    <input type="text" id="indPhoneNo" name="indPhoneNo" value="${fieldValue(bean:industryMasterInstance,field:'indPhoneNo')}" size="12" maxlength="12" class="txt4"/><span class="txt4"> &nbsp;(STD Code - Number)</span>
                                </td>
	</tr>
  
  
  
  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Fax No. with STD Code :</td>

    

    <td align="left"  bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indFaxCode','errors')}">
                                    <input type="text" id="indFaxCode" name="indFaxCode" value="${fieldValue(bean:industryMasterInstance,field:'indFaxCode')}" size="5" maxlength="7" class="txt4"/>
                                    <input type="text" id="indFaxNo" name="indFaxNo" value="${fieldValue(bean:industryMasterInstance,field:'indFaxNo')}" size="12" maxlength="12" class="txt4"/><span class="txt4"> &nbsp;(STD Code - Number)</span>
                                </td>
  </tr>
  
  
  <tr class="headngblue txt4">

    <td align="left" bgcolor="#A8DAF3">Email* : :</td>

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryMasterInstance,field:'indEmail','errors')}">
                                    <input type="text" id="indEmail" name="indEmail" value="${fieldValue(bean:industryMasterInstance,field:'indEmail')}" class="txt4"/><span class="txt4"> &nbsp;(e.g. info@abc.com)</span>
                                </td>

  </tr>
  </table>
        
          </div>

  

  
 											<table width="95%"> 
 											<tr>
													<td width="5%">&nbsp;</td>
														<td colspan="4" align="left" class="txtR">Fields marked * are mandatory</td>
													</tr>
													</table>
  
					  
					
		  
		  
		  
		  <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Update" value="Update" action="industryMasterUpdate" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		  
		  
		  
		  
		  
		  
		  
		  
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


 
 
</script>

</body>
</html>
