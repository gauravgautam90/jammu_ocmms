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
<table align="center">
<tr align="center">
<td width="100%" align="center">
<div >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">NOC Authority Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
</table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr><td><table class="tblbdr">
 					<tr bgcolor="#A8DAF3">
                       <td width="12.5%" class="headngblue" ><div  class="style3">Issuing Authority</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Status</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Number</div></td>
                          <td width="12.5%" class="headngblue" ><div  class="style3">Date</div></td>
                     </tr>
 <g:each in="${nocAuthorityDetailsInst}" status="i" var="nocAuthorityDetailsInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.authorityDetails} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.status} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.number} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.date} </span></td>
                        
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					</tr>
 					</table></td></tr>
  		</table>
  		</div></div></td></tr>	
  		 <tr><td align="center">
  		<% if(type=="REGULAR"){
    			System.out.println("type...."+type)
    			%>
    		
    		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

    			()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
    				
    		<%}else{%>
           
				<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

			<%}%></td></tr>
</table>
</body>
</html>