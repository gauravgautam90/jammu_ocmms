
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

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

<g:javascript library="prototype" />


 </head>
  <body>
<g:form name="waterSourceUses" method="post" action="deleteFeeOtherBankDetailsHWM" >
  
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="150" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Consent Fee Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="20%" align="center"  class="txt" >Fee For</td>
                       	  
							  <td width="150px" align="center" class="txt">Amount(In Rs.)</td>
							   <td width="150px" align="center" class="txt">Delete</td>
                      </tr>
 <g:each in="${feeDetailsHWMList}" status="i" var="feeDetailsHWMList">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsHWMList.feeFor}
                        </span></td>
  					      <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsHWMList.amount}
                        </span></td>
                       
                          <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=feeDetailsHWMList.id%>"/>
                        </span></td>
                              
        </tr>		
      </g:each>		
 					
 				<tr align="center" >
  
                        <td colspan="3" align="center"
                       bgcolor="#A8DAF3"><span class="txt style6"><b>Total Fee :   ${totalfee} </b>
                        </span><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
                         
                              
        </tr>		
        <!--
        <tr bgcolor="#F4F7FB" align="center">
 					<td colspan="2" class="txt style6" align="right" colspan="4">Scaned Copy of Drafts/Cheques     &nbsp;: </td>
 					<td class="txt style6" align="left" colspan="2"><%if(feeCheque){%>	<g:def var="fooVar" value="${appDetId}"/><g:link action="viewChequeAttachedFee" controller="indApplicationDetails" params="[appliLoc:fooVar]"><span class="innerlink"><u>Download</u></span></g:link>
<%}%></td><td class="txt style6" align="center"><%if(feeCheque){  %>  <g:each in="${feeCheque}" status="i" var="feeCheque"><input type="hidden" name="delete1" value="<%=feeCheque.id%>"/></g:each>	
<%}%></td>
 					</tr>
 					-->
 					</table></td></tr>
						
					
					<tr align="center">
  <td><div style="width: 500px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										</span></div></td></tr>  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

    <td height="1" colspan="2" bgcolor="" align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>



</table>
</g:form>
</body>
</html>