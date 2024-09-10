<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>



	


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<style type="text/css">
<!--
body {
	background-color: #dadada;
}
-->
</style>


<style type="text/css">
<!--
body {
	background-color: #999999;
}
.style2 {color: #FFFFFF}
body,td,th {
	color: #0066FF;
}
-->
</style>

<style type="text/css">

<!--

.style1 {

            font-family: Verdana, Arial, Helvetica, sans-serif;

            font-size: 12px;

            color: #0033CC;

}

-->

</style>





</head>
<body LEFTMARGIN="0" TOPMARGIN="0" STYLE="margin:0px;" MARGINHEIGHT="0">
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#ffffff"><img src="${createLinkTo(dir:'gifs',file:'logo.gif')}" alt="Online Consent Management System" width="710" height="82" /></td>
    <td width="45" bgcolor="#ffffff"><img src="${createLinkTo(dir:'gifs',file:'tree.gif')}" width="45" height="82" hspace="15" /></td>
  </tr>
  <tr>
    <td height="30" colspan="2" valign="top" bgcolor="#ffffff" class="lnks"><img src="${createLinkTo(dir:'gifs',file:'gtalk.gif')}" alt="GTalk" width="28" height="16" align="absmiddle" /><a href="#">GTalk</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="${createLinkTo(dir:'gifs',file:'contact.gif')}" alt="GTalk" width="19" height="14" align="absmiddle" /><a href="#">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;<img  src="${createLinkTo(dir:'gifs',file:'email.gif')}" alt="GTalk" width="21" height="17" align="absmiddle" /><a href="#">Email</a></td>
  </tr>
</table>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11"><img src="${createLinkTo(dir:'gifs',file:'lft-tab.gif')}" width="11" height="30" /></td>
    <td width="100%" background="${createLinkTo(dir:'gifs',file:'top-tab-bg.gif')}" class="top-lnks"><a href="#">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu7">Apply for Consent</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu8">Search Application</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" class="menuanchorclass" rel="anylinkmenu9">Application Status</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu10">Test Report </a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu11">Industry Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu12">Change Password</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Feedback/Query</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Public Grievance</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Logout</a></td>
    <td width="11"><img src="${createLinkTo(dir:'gifs',file:'rght-tab.gif')}" width="11" height="30" /></td>
  </tr>
</table>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="225" valign="top" bgcolor="#E6E7E4"><div class="lft-bg">
       
      <div> <img  src="${createLinkTo(dir:'gifs',file:'feedback.gif')}" alt="Send us your feedback" width="225" height="64" vspace="1" border="0" /><br/>
        <img  src="${createLinkTo(dir:'gifs',file:'query.gif')}" alt="Click Here" width="225" height="64" vspace="1" border="0" /><br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
    </div></td>
    <td width="100%" valign="top" bgcolor="#FFFFFF" ><div class="path-bg">&nbsp;</div>
      <img  src="${createLinkTo(dir:'gifs',file:'img.jpg')}"width="778" height="139" border="0" /><br/>
      <br />
     <table align="center"><tr><td align="center"> 
     <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if></td></tr></table>
            <g:hasErrors bean="${roleMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${roleMasterInstance}" as="list" />
            </div>
            </g:hasErrors>    
          
         
				 
    <table align="center"  width="100%" border="0">
<tr align="center">
<td width="10%">&nbsp;</td>
<td width="90%" align="center">
    <div align="center">
    
      <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" bordercolor="#990000">
        <tr>
          <td colspan="2"><img  src="${createLinkTo(dir:'images',file:'spacer.gif')}" width="1" height="15" /></td>
        </tr>
        <tr align="left">
          <td colspan="2"  ><table width="160" border="0" cellspacing="0" cellpadding="0">
                          <tr >
                            <td width="12" bgcolor="#5A89D9"><img  src="${createLinkTo(dir:'images',file:'BlueTab_Left.jpg')}" width="10" height="20"></td>
                            <td bgcolor="#5A89D9" class="headng1" width="134">Search Application</td>
                            <td width="10" valign="bottom"><img src="${createLinkTo(dir:'images',file:'BlueTab_Right.jpg')}" width="10" height="21"></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr align="center">
                        <td width="600px" colspan="2" align="center">
                <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                    <thead>
                       <tr height="30" bgcolor="#F4F7FB">
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="indUser" title="Industry User" />
                        
                   	        <g:sortableColumn property="applicationType" title="Application Type" />
                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                        
                   	        <g:sortableColumn property="applicationDate" title="Application Date" />
                        
                   	        <g:sortableColumn property="applicationName" title="Application Name" />
                   	        
                   	      
                        
                   	        <g:sortableColumn property="certificateFor" title="Certificate For" />
                        
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
            </div>
     <div class="paginateButtons">
                <g:paginate total="${total}" />
            </div>   
        </div>
   </td>
        </tr>
        <tr>
          <td colspan="2"><img  src="${createLinkTo(dir:'images',file:'spacer.gif')}" alt="&nbsp" width="1" height="10" /></td>
        </tr>
        
       <g:paginate total="${total}" />
      </table>
    </div>
    </td></tr></table>
				 
    </div>
    
    
      
	

</form>
  <tr>
    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>
  </tr>
  <tr>
    <td height="53" colspan="2" bgcolor="#ffffff"><div class="foot-txt">Pollution Control  Board, Copyright © 2009All Rights Reserved NIC India</div></td>
  </tr>
</table>










</body>
</html>
