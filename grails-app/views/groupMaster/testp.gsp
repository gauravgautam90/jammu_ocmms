<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>

	<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>



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
			<g:include controller="userMaster" action="showAdminMenu"/>
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
							
							<td width="16%" align="left"><span class="leftlink"><g:link controller="groupMaster" action="updateGroup" >UPDATE</g:link></span></td>
							<td width="16%" align="left"><g:link controller="groupMaster" action="del" >DELETE </g:link></td>
							<td width="68%">&nbsp;</td>
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
         <FORM id="myForm" name=myForm action="search" method="post">
				
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Industry Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr>
						<td colspan="4" align="left"><input type=radio name=searchOp value="ApplId" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> >By Application Id</td></tr>
						
                      <tr  >
                        <td width="13%" class="headngblue"  align="center" >Application Id:</div></td>
                        <td align="center">
                        <g:select optionKey="id" from="${IndApplicationDetails.list()}" id="autocomplete" name="autocomplete_parameter" noSelection="${['xyz':'Not Selected']}" ></g:select>
						
						
                        </td>
                      </tr>
                      <div id="autocomplete_choices" class="autocomplete" ></div>
                      <tr><td colspan="4">&nbsp;</td></tr>
                       <tr align="center">
                       
						<tr>
						<td colspan="4" align="left"><input type=radio  name=searchOp value=Others >By Other Criteria</td></tr>
                      
                 <tr width="100%">
                              <td width="17%" align="left" class="headngblue" ><div align="center">Start Date:*</div></td>
                        <td width="31%" align="left" >
						<input type="text" id="start_date" name="start_date"  class="txt4" />
						<script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'myForm',
		// input name
		'controlname': 'start_date'
	});

	</script>

						
                   </td>
                      
                      
                      
                              <td  width="17%" align="right" valign="middle" class="headngblue"><div align="right" class="style3">
                                <div align="center">Ending Date:*</div>
                              </div></td>
                        <td align="left" width="35%"  >
						<input type="text" id="end_date" name="end_date" class="txt4" />
						<script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'myForm',
		// input name
		'controlname': 'end_date'
	});

	</script>
                   </td>
  </tr>
                      
                      
                       <tr align="center" >
                              <td  align="right" valign="middle" class="headngblue"><div align="right" class="style3">
                                <div align="center">Category:</div>
                              </div></td>
                        <td align="left" >
						
						<g:select optionKey="id" from="${IndCatMaster.list()}" name="category" noSelection="${['xyz':'Not Selected']}" ></g:select>
                        </td>
                      
                      
                      
                              <td  align="right" valign="middle" class="headngblue"><div align="right" class="style3">
                                <div align="center">Status:</div>
                              </div></td>
                        <td align="left" >
						<g:select  from="${['pending','completed']}" name="status" noSelection="${['xyz':'Not Selected']}" ></g:select>
						
                        </td>
                      </tr>
                     
	  </table></td>
        </tr>
       
       
      </table>
    </div>
    </td></tr></table>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="save" value="Save" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
		</table>
		<g:if test="${abc}">
            
           

<table width="85%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                    <thead>
                       <tr height="30" bgcolor="#F4F7FB">
                        
                   	        <td> Id </td>
                        
                   	        <td>Industry User </td>
                   	        <td>Application Type</td>
                   	        <td>Application For</td>
                   	        <td>Application Date</td>
                   	        <td>Application Name</td>
                   	        <td>Certificate For</td>
                        
                   	        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${abc}" status="i" var="abc">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td><g:link controller="indApplicationDetails" action="show" id="${abc.id}">${fieldValue(bean:abc, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:abc, field:'indUser')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationType')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationFor')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationDate')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationName')}</td>
                            
                           
                        
                            <td>${fieldValue(bean:abc, field:'certificateFor')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <center>
     <g:paginate 
             controller="groupMaster"
            action="search" total="${total}" params="${paramList}"/>
			 </g:if></center>
            </div>
           </form>
        </div>
   </td>
        </tr>
  			
            <br />
            <br />
          </div>
		  <tr><td>
		  </td></tr>
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
</body>
</html>

