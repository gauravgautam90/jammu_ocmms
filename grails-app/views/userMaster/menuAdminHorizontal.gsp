<table width="1003" border="0" cellspacing="0" cellpadding="0">
<% String cont=request.getContextPath();%>
          <tr>
        <td height="32" align="center" valign="middle" ><g:link controller="userMaster" action="recentAppl"><span class="top-lnks">Home</span></g:link></td>
            
		<td width="2" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        <td align="center" valign="middle">
        <g:link controller="userMaster" action="recentAppl"><span class="top-lnks">Consent Management</span></g:link>
        <!--<a href="#" class="menuanchorclass" rel="consentManagement"><span class="top-lnks">Consent Management</span></a>-->
        </td>
            
		<td width="1" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><span class="top-lnks">Laboratory Management</span></td>
           
		 <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
			<td align="center" valign="middle" ><g:link controller="wasteManagementPendingDetails" action="pendingList"><span class="top-lnks">HWM/BMW/MSW</span></g:link></td>
			
			<td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
			<td align="center" valign="middle" ><g:link controller="eWaste" action="pendingList"><span class="top-lnks">EWaste</span></g:link></td>
	       
           <!--
	   <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><g:link controller="cessPendingDetails" action="cessPendingReturn"><span class="top-lnks">CESS Management</span></g:link></td>
        -->  
        <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><g:link controller="userMaster" action="auditSearch"><span class="top-lnks">Audit Trail</span></g:link></td>
      
		<!-- Code-->
		 <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					 <td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		            <td align="center" valign="middle" ><a href="<%=cont%>/inspectionManagement/inspectionManagementHome" ><span class="top-lnks">Inspection Management</span></a></td>
                                            
				<% 	}else{ %>
					
					<td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
					<td align="center" valign="middle" ><a href="<%=cont%>/inspectionManagement/inspectionManagementHome" ><span class="top-lnks">Inspection Management</span></a></td>
					
				<%	}
			} %>
			<!-- code -->
			
          <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="<%=cont%>/userMaster/reportAdminPage.gsp" ><span class="top-lnks">Reports</span></a></td>
        
	   <td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" ><span class="top-lnks">Knowledge Base</span></a></td>
           
	   <!--<td width="2" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu10"><span class="top-lnks"><span class="top-lnks">Change Password</span></a></td>
        
	   <td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><a href="#"><span class="top-lnks">Feedback/Query</span></a></td>
        
	<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
            <td align="center" valign="middle" ><a href="#"><span class="top-lnks">Public Grievance</span></a></td>-->
        
		<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        <td align="center" valign="middle" ><g:link controller="userMaster" action="logout"><span class="top-lnks">Logout</span></g:link></td>
		<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        
		  </tr>
        </table>
