<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Online Consent Management System</title>
<title>Untitled Document</title>

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

<g:javascript library="prototype" />



<g:javascript>
document.observe('dom:loaded', function() {
	
   $("officeSelected").observe("change", respondToSelect);
   });

   
 function respondToSelect(event)
 {
       new Ajax.Updater("GroupSelected",
          "/SPCB/groupMaster/updateSelect",
          {method:'get', parameters: {selectedValue : $F("officeSelected")} }
         );
 }
 



</g:javascript>








</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="707" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'logo.gif')}" alt="Online Consent Management System" width="707" height="91" /></td>
            <td width="296" align="left" valign="top"><table width="296" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="61" height="91" valign="top">&nbsp;</td>
                <td width="229" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="left" valign="top"><table width="229" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="9" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_corner.gif')}" width="9" height="24" /></td>
                        <td width="211" valign="top" bgcolor="#50A4C8"><table width="211" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="31"><img src="${createLinkTo(dir:'images2/gif',file:'gtalk.gif')}" width="24" height="16" /></td>
                            <td width="44"><a href="#" class="gtalk"><span class="top-lnks">GTalk</span></a></td>
                            <td width="17">&nbsp;</td>
                            <td width="16"><img src="${createLinkTo(dir:'images2/gif',file:'contact.gif')}" width="14" height="14" /></td>
                            <td width="49"><a href="#" class="gtalk"><span class="top-lnks">Contact</span></a></td>
                            <td width="12">&nbsp;</td>
                            <td width="22"><img src="${createLinkTo(dir:'images2/gif',file:'email.gif')}" width="16" height="16" /></td>
                            <td width="20"><a href="#" class="gtalk"><span class="top-lnks">Email</span></a></td>
                          </tr>
                        </table></td>
                        <td width="9" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'right_corner.gif')}" width="9" height="24" /></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5" align="left" valign="top"></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'tree.gif')}" width="60" height="62" /></td>
                  </tr>
                </table></td>
                <td width="6" valign="top">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" ><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
        <td width="63" height="32" align="center" valign="middle" ><a href="#" ><span class="top-lnks">Home</span></a></td>
            
		<td width="2" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        <td width="117" align="center" valign="middle"><a href="#" class="menuanchorclass" rel="anylinkmenu7"><span class="top-lnks">Apply for Consent</span></a></td>
            
		<td width="2" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu8"><span class="top-lnks">Search Application</span></a></td>
           
	   <td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu9"><span class="top-lnks">Application Status</span></a></td>
           
	   <td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu10"><span class="top-lnks">Test Report</span></a></td>
           
	   <td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu10"><span class="top-lnks">Industry Profile</span></a></td>
           
	   <td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu10"><span class="top-lnks"><span class="top-lnks">Change Password</span></a></td>
        
	   <td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#"><span class="top-lnks">Feedback/Query</span></a></td>
        
	<!--<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
            <td align="center" valign="middle" ><a href="#"><span class="top-lnks">Public Grievance</span></a></td>-->
        
		<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        <td align="center" valign="middle" ><a href="#" ><span class="top-lnks">Logout</span></a></td>
		<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        
		  </tr>
        </table></td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="31" valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}"><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><a href="#" class="menuanchorclass" rel="anylinkmenu13"><span class="leftlink">Register Here</span></a></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="3" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><a href="#" class="menuanchorclass" rel="anylinkmenu13"><span class="leftlink">Update Registration Form</span></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="3" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><a href="#" class="leftlink">Feedback/Query</a></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="150" align="left" valign="middle" bgcolor="#E8F1F3" class="pollution">The Pollution Control Board has<br />
                  been established as a regulatory
                  authority for implementing variious pollution
                  control laws. <span class="pollution2">The board is committed to provide polloution free environment to the people of state. The Board has undertaken various studies of underground water, solil and air to take remedial steps to control pollution.</span></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'feedback.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'query.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'grad.gif')}" width="224" height="296" /></td>
              </tr>
            </table></td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="5" valign="top"></td>
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
                <td height="24" bgcolor="#EEEEF3"><table>
<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr></table></td>
              </tr>
              <tr>
                <td height="557" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                       <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${groupMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${groupMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
         
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="454" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br />
    <g:form action="edit" method="post" >
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Update Group</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Office Name:</div></td>
                        <td align="left"><span class="txt style6">
                        
                       
    
                   
                        
                     <g:select optionKey="id" from="${OfficeMaster.list()}" id="officeSelected" name="officeId" noSelection="${['xyz':'Not Selected']}"  value="${groupMasterInstance?.officeId?.id}" ></g:select>   
                        
                    </span></td>
                      </tr>
                            <tr >
                        <td width="150px" class="headngblue" ><div align="right" class="style3">Group:</div></td>
                        <td align="left"><span class="txt style6">
                        
                         <div id ="GroupSelected">
				<g:select optionKey="id" name="grp" from="${roleList}"></g:select>
				</div>
                        </span></td>
                      </tr>
					  
                      
                      
                      
                      
                     
	  </table></td></tr>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="center"><input type="submit" name="save" value="Save" class="actionbutton" ></td>
			<td align="center"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
		</table>
		</g:form>
  			
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
                    <!--<tr>
                      <td width="195" height="72" align="left" valign="middle"></td>
                    </tr>-->
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="1" align="right" valign="middle" bgcolor="#ADBFCB"></td>
      </tr>
      <tr>
        <td height="31" align="right" valign="middle" bgcolor="#E1E3E2"><span class="foot-text">Pollution Control  Board, Copyright &copy; 2009All Rights Reserved NIC India</span></td>
      </tr>
      <tr>
        <td align="right" valign="middle">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

  			