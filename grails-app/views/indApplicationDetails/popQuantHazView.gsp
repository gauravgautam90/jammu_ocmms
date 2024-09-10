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
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Mode of Storage</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="">&nbsp;</td>
							</tr>
</table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 <tr><td><table class="tblbdr" width="100%"  border="0">
	
	<tr bgcolor="#A8DAF3">
 <td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Name of the Hazardous Waste generated/to be generated</td>
	<td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Nature of Hazardous Waste(recyclable/incinerable/storagable)</td>
	<td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Category of Hazardous Waste</td>
	<td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Total Quantity of Hazardous Waste generated/to be generated(in tones/annum)</td>
	<td colspan="3" width="40%" align="center" class="headngblue" ><div>Mode of Disposal</div></td>
	</tr><tr bgcolor="#A8DAF3">
	<td width="10%" align="center" class="headngblue" >Quantity of hazardous waste shifted/to be shifted to common TSDF</td>
	<td width="10%" align="center" class="headngblue" >Quantity of hazardous waste given/to be given to regd. Recycler</td>
	<td width="10%" align="center" class="headngblue" >Quantity of hazardous waste being/to be managed in the premises</td>
	
</tr>
		
					
 			<g:each in="${soliddetails1}" status="i" var="soliddetails1">
 			<tr align="center" >
 	  					    
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        ${soliddetails1.name}</span></td>
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        ${soliddetails1.nature}</span></td>
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        ${soliddetails1.category}</span></td>
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        ${soliddetails1.totalquant}</span></td>
 	                        
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        <br>${soliddetails1.quantTSDF}</span></td>
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        <br>${soliddetails1.quantRec}</span></td>
 	                        <td bgcolor="#E8F6F9"><span class="txt style6">
 	                        <br>${soliddetails1.quantPre}</span></td>
 	                     	
 	                        
 	    </g:each>
 			
 	
 	<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
								if(session.check==true){
								%>
<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popPreviousApp/<%=appDetId%>#country8', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>
<%

}else{%>
	<tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/<%=appDetId%>#country8', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
		  
  </tr>
  <%}}}%>		
 					
</table>
</body>
</html>