
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>




<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

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














<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>


 </head>
  <body>

  <g:form name="AirStackEdit" method="post" action="editEWstackemissionmonitoring" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                               <td width=""><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="480" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Stack Emission Monitoring Details</a></td>
                              
                              <td width="0" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="10">&nbsp;</td>
                              </tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					<tr bgcolor="#A8DAF3">
                       
						<td width="30%" align="center" valign="middle"  class="headngblue">Stack Attached to the Plant</td>
						<td colspan="5" width="65%" align="center" class="headngblue" ><div>Emission (mg/Nm3)<br>SPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SO2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Others</div></td></div></td>
						
						
                      		<td class="headngblue" ><div  class="style3">Delete</div></td>
                      	
                      </tr>
 <g:each in="${stackemissiondetails}" status="i" var="stackemissiondetails">
 <tr align="center" >
  					 <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.stack}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6" width="25%">
                        ${stackemissiondetails.spm}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6" width="25%">
                        ${stackemissiondetails.so2}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6" width="25%">
                        ${stackemissiondetails.nox}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6" width="25%">
                        ${stackemissiondetails.pb}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6" width="25%">
                        ${stackemissiondetails.others}</span></td>
                       
                         
                           <td  bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=stackemissiondetails.id%>"/>
                          
                        </span></td>
                              
        </tr>		
      </g:each>		
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

   <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>



</table>

<div align="left" class="txt" style="color: navy">
  </br></br>
  &nbsp;<b>* Instructions:</b>
  &nbsp;<ul> 
  <li>Please select the checkbox to delete the stack emission monitoring details and click "Delete" button</li>
  <li>Select multiple check box and click "Delete" button to delete multiple records</li>
  <li>To edit the stack emission monitoring details, delete the stack emission monitoring details and then add new one</li>
  </ul>
  

</div>
</g:form>
</body>
</html>