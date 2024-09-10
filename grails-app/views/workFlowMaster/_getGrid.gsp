

<table width="100%" height="100%" cellspacing="0">
			
    <tr>
	<td bgcolor="#F4F7FB" valign="top">
	<table width="100%" height="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td height="35" align="center" ><a href="popupex.html" onclick="return popitup('../roleMaster/pop1')"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROLE" ></a></td>
		</tr>
		<%
		if(roleList!=null){
			
		for(int i=0;i<roleList.size();i++){%>
		<tr>
		<td height="24" align="center"><%=(roleList.get(i)).roleName%></td>
		</tr>
		<%}
		}
		%>
							
	</table>
	</td>			
	<td  bgcolor="#F4F7FB" valign="top">
	<table width="100%" height="100%" cellpadding="0" cellspacing="0">
	<tr bgcolor="#F4F7FB"  valign="top">
                        	<%
                        	if(roleList!=null){
                        	for(int i=0;i<roleList.size();i++){%>
                   	        <td height="33" align="center" class="headngblue"><%=(roleList.get(i)).roleName%></td>
							 <%}
							 }%>
		</tr>			<% if(roleList!=null){
                        	for(int i=0;i<roleList.size();i++){%>
						<tr>
						<% for(int j=0;j<roleList.size();j++){%>
						<td height="25" align="center"><input class="txt4" type="checkbox"></td>
						<%} %>
						</tr>
						<%}
							 }%>
	</table>
	</td>
	</tr>
                       
						
						
							
</table>
