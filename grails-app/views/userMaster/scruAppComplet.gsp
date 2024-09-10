<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

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
		
		
									
					
		
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			
			
		
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
 
              
               //System.out.println("USER1----"+um)
               // System.out.println("USER2----"+aa)
                // System.out.println("IndUser----"+ind)
              String user
              String firstname
               String lastName
               String access
               if(ind){
 
 //System.out.println("IndUser----"+ind)
   user = ind.industryRegMaster.indName
  //System.out.println("user---newwwwwww-"+user)
  }
  else{
  if(um){
 //System.out.println("herre========"+um+"======"+aa)
               firstname=aa.employeeFirstName;
               lastName=aa.employeeLastName;
               access=um.accessLevel;
             // System.out.println("herre=====555==="+firstname+"======"+lastName+"----------"+access)
              }}
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
						
						 <%if(ind) {%>
						 	<td>Welcome <%=user%></td>
						 	<%}else{
						 	if(um){
						 	//System.out.println("herre777777777000000000000====="+firstname+lastName+access)
						 	
						 	%>
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<%}
						 	//System.out.println("herre777777777000000000000====="+firstname+lastName+access)
						 	}%>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr> <tr>
							
					<td width="100%" align="left">
									</td>							
					   </tr></table>
				</td>
              </tr>
              <tr>
             
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
											<g:hasErrors bean="${surroundingMasterInstance}">
											<div class="errors">
												<g:renderErrors bean="${surroundingMasterInstance}" as="list" />
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
		
		
		
		
		<form action="updateScruAppComplet" method="post" name="myform" id="myform">
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="157" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks">Industry Details</td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="422">&nbsp;</td>
							</tr>
	    </table>

		
		
          <div id="country1" >
	
		
			
			
			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
			<tr bgcolor="#F4F7FB">
           
            <td width="8%" align="center" bgcolor="#A8DAF3" class="headngblue"> Application Id.</td>         
            <td width="10%" align="center" bgcolor="#A8DAF3" class="headngblue" >Application Status</td>
            <td width="10%" align="center" bgcolor="#A8DAF3" class="headngblue" >Pending with</td>
            <td width="10%" align="center" bgcolor="#A8DAF3" class="headngblue" >Role id</td>
            <td width="30%" align="center" bgcolor="#A8DAF3" class="headngblue" >Completion Date</td>
            <td width="30%" align="center" bgcolor="#A8DAF3" class="headngblue" >Completion Status </td>
           <td width="10%" align="center" bgcolor="#A8DAF3" class="headngblue" >Scrutiny Status</td> 
                  
								</tr>	
      		  
      		    <tr bgcolor="#F4F7FB">
                                   
                 <!--   <td class="txt4" align="center" bgcolor="#E8F6F9" class="headngblue"><g:link action="show" id="${applcationPendingDetails.application.id}">${fieldValue(bean:applcationPendingDetails, field:'id')}</g:link></td> -->
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">
                    <a href="../industryRegMaster/UpdateScruAppComplet/${applcationPendingDetails.application.id}" target="_blank">${applcationPendingDetails.application.id}</a></td>
                    <input type="hidden" name="surroundingName" id="surroundingName" value="${applcationPendingDetails.application.id}"> 
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">${applcationPendingDetails?.applicationStatus}</td>
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">${applcationPendingDetails?.pendingWith.id}</td>
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">${applcationPendingDetails?.role.id}</td>
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">${applcationPendingDetails?.completionDate}</td>
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">${applcationPendingDetails?.completionStatus}</td> 
                    <td width="25%" align="center" bgcolor="#E8F6F9" class="headngblue">${applcationPendingDetails?.scrutinyStatus}</td> 
                   
                 </tr>
             </table>
						
						
						
	   <table width="5%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Update" value="Update" class="actionbutton"></td>
			<!-- <td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>	-->			
		  </tr>
		</table>
		
  			</form>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
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

<script language="JavaScript" type="text/javascript">
 	var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 	frmvalidator.addValidation("surroundingName","req","Please enter Industry ID");
 	frmvalidator.addValidation("surroundingName","num","Please enter valid Industry ID");

function confirmationDelete()
{
	 var a= confirm("Are you sure to delete the Industry ?");
	 if(a==true)
	 {
		 document.getElementById("myform").submit();
	 }	
}
</script>

</body>

<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


