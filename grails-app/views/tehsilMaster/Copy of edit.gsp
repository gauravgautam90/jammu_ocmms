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
<g:javascript library="prototype" />

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
     
        <div class="lft-lnks"><img src="${createLinkTo(dir:'gifs',file:'dot.gif')}" /><g:link action="create" >Add Tehsil</g:link></div>
      </div>
      <div class="lft-bg">
        <div class="lft-lnks"><img src="${createLinkTo(dir:'gifs',file:'dot.gif')}" /><g:link action="updatetehsil" >Update Tehsil</g:link></div>
      </div>
      
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
      
    <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${groupMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${groupMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
           <g:form  method="post" >
           
           <input type="hidden" name="id" value="${tehsilMasterInstance?.id}" />
                <input type="hidden" name="version" value="${tehsilMasterInstance?.version}" />
				 
    <table align="center">
<tr align="center">
<td width="100%" align="center">
    <div >
      <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" bordercolor="#990000">
        <tr>
          <td colspan="2"><img  src="${createLinkTo(dir:'images',file:'spacer.gif')}" width="1" height="15" /></td>
        </tr>
        <tr align="left">
          <td colspan="2" ><table width="110" border="0" cellspacing="0" cellpadding="0">
                          <tr >
                            <td width="12" bgcolor="#5A89D9"><img  src="${createLinkTo(dir:'images',file:'BlueTab_Left.jpg')}" width="10" height="20"></td>
                            <td bgcolor="#5A89D9" class="headng1" width="134">Update Tehsil</td>
                            <td width="10" valign="bottom"><img src="${createLinkTo(dir:'images',file:'BlueTab_Right.jpg')}" width="10" height="21"></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr align="center">
                        <td width="400px" colspan="2"><table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr bgcolor="#F4F7FB">
                        <td width="150px" class="headngblue" ><div align="right" class="style3">District* :</div></td>
                      
                          <td align="left"  class="value ${hasErrors(bean:tehsilMasterInstance,field:'district','errors')}">
                                    <g:select optionKey="id" from="${DistrictMaster.list()}" name="district.id" value="${tehsilMasterInstance?.district?.id}" ></g:select>
                                </td>
                            
                      </tr>
                            <tr align="center" class="headngblue1" >
                              <td width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Enter Tehsil :</div></td>
                        <td align="left" class="value ${hasErrors(bean:tehsilMasterInstance,field:'tehsilName','errors')}">
                                    <input type="text" id="tehsilName" name="tehsilName" value="${fieldValue(bean:tehsilMasterInstance,field:'tehsilName')}"/>
                                </td>
                      </tr>
                      
                      
                      
                      

	  </table></td>
        </tr>
        <tr>
          <td colspan="2"><img  src="${createLinkTo(dir:'images',file:'spacer.gif')}" alt="&nbsp" width="1" height="10" /></td>
        </tr>
        
       
      </table>
    </div>
    </td></tr></table>
				 
    </div>
    
    
  <div align="center" >
<g:actionSubmit class="headngblue" value="Update" style="width: 120px;

  height: 25px;

  margin: 0;

  font-weight:bold;
 
  padding: 0;

  border: 0;

background: url('${createLinkTo(dir:'gifs',file:'button.gif')}')  no-repeat  " />

 <input type="reset" value="Reset" class="headngblue" style="width: 120px;

  height: 25px;

  margin: 0;

  font-weight:bold;
 
  padding: 0;

  border: 0;

background: url('${createLinkTo(dir:'gifs',file:'button.gif')}')  no-repeat  " />



<g:submitButton name="cancel" value="Cancel"  class="headngblue" style="width: 120px;

  height: 25px;

  margin: 0;

  font-weight:bold;
 
  padding: 0;

  border: 0;

background: url('${createLinkTo(dir:'gifs',file:'button.gif')}')  no-repeat  "/>


</div>
    </td>
  </tr>
  </g:form>
  <tr>
    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>
  </tr>
  <tr>
    <td height="53" colspan="2" bgcolor="#ffffff"><div class="foot-txt">Pollution Control  Board, Copyright � 2009All Rights Reserved NIC India</div></td>
  </tr>
</table>
</body>
</html>
