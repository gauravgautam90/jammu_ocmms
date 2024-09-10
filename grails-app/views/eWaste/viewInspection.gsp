<%@ page import="java.text.SimpleDateFormat"%>
<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
</head>
<%if(appInspection){ %>
<table>
<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

String strDate = sdfDestination.format(appInspection.dateCreated );
%>
<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                     	</tr>
 
  <tr  >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Raised By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appInspection.role}(${appInspection.officer})</div></td>
        </tr>			
					 
                      	<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Inspection Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appInspection.inspectionNote}  </td>
                      	</tr>
                     
</table>
<%}%>
 