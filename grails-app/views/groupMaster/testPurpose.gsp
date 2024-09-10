<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>


<g:javascript library='scriptaculous'/>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" >
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" language="javaScript" src="${createLinkTo(dir:'js',file:'calendar.js')}" ></script>
<script type="text/javascript"  language="javascript" src="${createLinkTo(dir:'js',file:'caldatetime.js')}" ></script>
<script> //verify for netscape/mozilla
      var isNS4 = (navigator.appName=="Netscape")?1:0;
</script>

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




<g:javascript src="prototype/scriptaculous.js?load=effects"/>

<g:javascript>
window.onload = function()
						{
						 new Ajax.Autocompleter("autocomplete",
						                        "autocomplete_choices",
						                        "/SPCB/groupMaster/ajaxAutoComplete",
						                          {} 
						                          ); 
						                          }
</g:javascript>







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
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="11"><img src="${createLinkTo(dir:'gifs',file:'lft-tab.gif')}" width="11" height="30" /></td>
    <td width="100%" background="${createLinkTo(dir:'gifs',file:'top-tab-bg.gif')}" class="top-lnks"><a href="#">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu7">Apply for Consent</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu8">Search Application</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" class="menuanchorclass" rel="anylinkmenu9">Application Status</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu10">Test Report </a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu11">Industry Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="menuanchorclass" rel="anylinkmenu12">Change Password</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Feedback/Query</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Public Grievance</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Logout</a></td>
    <td width="11"><img src="${createLinkTo(dir:'gifs',file:'rght-tab.gif')}" width="11" height="30" /></td>
  </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
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
            <g:form action="search" method="post" >
				 
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
                        <td width="600px" colspan="2" align="center"><table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr>
						<td colspan="4" align="left"><input type=radio name=searchOp value=ApplId>By Application Id</td></tr>
						
                      <tr  >
                        <td width="13%" class="headngblue"  align="center" >Application Id:</div></td>
                        <td align="center">
                        <g:select optionKey="id" from="${IndApplicationDetails.list()}" id="autocomplete" name="autocomplete_parameter"  ></g:select>
						
						
                        </td>
                      </tr>
                      <div id="autocomplete_choices" class="autocomplete" ></div>
                      <tr><td colspan="4">&nbsp;</td></tr>
                       <tr align="center">
                       
						<tr>
						<td colspan="4" align="left"><input type=radio  name=searchOp value=Others>By Other Criteria</td></tr>
                      
                 <tr width="100%">
                              <td width="13%" align="left" class="headngblue" ><div align="center">Start Date:</div></td>
                        <td width="35%" align="left" >
						<input name="dateFrom" size="10" readonly="readonly" maxlength="10" value="${dateFrom}"   

onKeyPress="if(! isNS4){if((event.keyCode < 48)||(event.keyCode>57))event.returnValue=false;}else{if( (event.which < 

8)||(event.which > 8) && (event.which < 48)||(event.which >57)) return false;}"  style="float: left" />
                <img name="" src="images/CGHS_CALENDAR.GIF" width="32" height="19" alt="Click to get Calendar"  

style="cursor:pointer;" onClick="popUpCalendar(this, document.forms[0].dateFrom,'dd-mm-yyyy',-16,-26)" /></td>
       
      
      </a>
						
						
                   </td>
                      
                      
                      
                              <td  width="17%" align="right" valign="middle" class="headngblue"><div align="right" class="style3">
                                <div align="center">Ending Date:</div>
                              </div></td>
                        <td align="left" width="35%"  >
						<input type="text" id="end_date" name="end_date" class="txt4"/>
						
						<a href="#" onClick="setYears(1947, 2090);
       showCalender(this, 'end_date');">
       
       <img  src="${createLinkTo(dir:'gifs',file:'calender.png')}" alt="Calendar"  />
      </a>
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
        <tr>
          <td colspan="2"><img  src="${createLinkTo(dir:'images',file:'spacer.gif')}" alt="&nbsp" width="1" height="10" /></td>
        </tr>
        
       
      </table>
    </div>
    </td></tr></table>
				 
    </div>
    
    
      
	  <div align="center">
	  <input type="submit" value="Search" style="width: 120px;

  height: 25px;

  margin: 0;

  font-weight:bold;
 
  padding: 0;

  border: 0;

background: url('${createLinkTo(dir:'gifs',file:'button.gif')}')  no-repeat  " />

<input type="reset" value="Reset" style="width: 120px;

  height: 25px;

  margin: 0;

  font-weight:bold;
 
  padding: 0;

  border: 0;

background: url('${createLinkTo(dir:'gifs',file:'button.gif')}')  no-repeat  " /><input type="button" value="Cancel" style="width: 120px;

  height: 25px;

  margin: 0;

  font-weight:bold;
 
  padding: 0;

  border: 0;

background: url('${createLinkTo(dir:'gifs',file:'button.gif')}')  no-repeat  " /></div>
    </td>
  </tr>
  </g:form>
  <tr>
    <td height="1" colspan="2" bgcolor="#d0d1d0"></td>
  </tr>
  <tr>
    <td height="53" colspan="2" bgcolor="#ffffff"><div class="foot-txt">Pollution Control  Board, Copyright © 2009All Rights Reserved NIC India</div></td>
  </tr>
</table>





<table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
	          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));" id="selectMonth">
	              <option value="0">Jan</option>
	              <option value="1">Feb</option>
	              <option value="2">Mar</option>
	              <option value="3">Apr</option>
	              <option value="4">May</option>
	              <option value="5">Jun</option>
	              <option value="6">Jul</option>
	              <option value="7">Aug</option>
	              <option value="8">Sep</option>
	              <option value="9">Oct</option>
	              <option value="10">Nov</option>
	              <option value="11">Dec</option>
	          </select>
            </td>
            <td colspan="2" align="center">
			    <select onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
				</select>
			</td>
            <td align="center">
			    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>
</body>
</html>
