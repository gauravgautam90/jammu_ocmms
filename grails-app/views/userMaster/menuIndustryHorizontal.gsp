<table width="1003" border="0" cellspacing="0" cellpadding="0">
      <%
def svvv=session.cafUniqueNo
 %>
 <% if(!svvv){%>
          <tr>
        <td height="32" align="center" valign="middle" ><g:link controller="indUser" action="openIndustryHome"><span class="top-lnks">Home</span></g:link></td>
            
		<td width="2" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
        <td align="center" valign="middle">
        <g:link controller="indUser" action="openIndustryHome"><span class="top-lnks">Consent Management</span></g:link>
        <!--<a href="#" class="menuanchorclass" rel="consentManagement"><span class="top-lnks">Consent Management</span></a>-->
        </td>    
		<td width="1" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><span class="top-lnks">Laboratory Management</span></td>
           
	   <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><g:link controller="hazardeousWasteAuthApp" action="list"><span class="top-lnks">HWM /BMW / MSW </span></g:link></td>
       <!--   
	    <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" valign="middle" ><g:link controller="cessReturn" action="cessIndustryCompletedList"><span class="top-lnks">CESS Management</span></g:link></td>
        --> 
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
		  <% }else{%>
		  <tr>
		  <%if(session.serviceId=='36' || session.serviceId=='37' || session.serviceId=='38' || session.serviceId=='39' || session.serviceId=='40' || session.serviceId=='41' || session.serviceId=='46'){%>
		  <td height="32" align="center" valign="middle" ><g:link controller="indUser" action="openIndustryHome"><span class="top-lnks">Home</span></g:link></td>
            
		<td width="2" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td> 
		<%}else if(session.serviceId=='42'){%>
			<td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
			<td height="32"  align="center" valign="middle" ><g:link controller="hazardeousWasteAuthApp" action="list"><span class="top-lnks">Hazardeous Waste Management</span></g:link></td>	
			
		<%} else if(session.serviceId=='45'){%>
		<td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" height="32" valign="middle" ><g:link controller="hazardeousWasteAuthApp" action="list"><span class="top-lnks">Bio-Medical Waste Management</span></g:link></td>	
		<%}else if(session.serviceId=='44'){%>
		<td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		<td align="center" height="32" valign="middle" ><g:link controller="plasticWaste" action="list"><span class="top-lnks">Plastic Waste Management</span></g:link></td>	
		<% }else if(session.serviceId=='43'){%>
		  <td width="1" align="center" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
			<td align="center" height="32" valign="middle" ><g:link controller="eWaste" action="list"><span class="top-lnks">E-Waste Management</span></g:link></td>	
		  <% }%>
		  <td align="center" valign="middle" ><g:link controller="userMaster" action="logout"><span class="top-lnks">Logout</span></g:link></td>
		<td width="2" align="center" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'button_spacer.gif')}"></td>
		 </tr>
		  <% }%>
        </table>
