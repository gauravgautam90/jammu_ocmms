<table width="100%" cellpadding="0" cellspacing="0">
 	<tr bgcolor="#F4F7FB" >
		<td class="headngblue" align="center">Can Forward To</td>
	</tr>
	<tr bgcolor="#F4F7FB">
		<td>
			<table>
				<tr >
				<%for(int i=0;i<fwdRoleList.size();i=i+2){%>    
					  	<td width="10%" align="left"><input class="txt4" type="checkbox" name='<%=(fwdRoleList.get(i)).roleName%>' <%if(fwdRoleList.get(i+1)==true){%>checked="checked"<%}%>><span class="style1"><%=(fwdRoleList.get(i)).roleName%></span> </td>
				<%} %>					  	
			   </tr>
			</table>
		</td>
	</tr>	
	<tr>
		<td colspan="100%" align="center"><input type="hidden" name="roleSize" id="roleSize" value="<%=fwdRoleList.size()/2 %>"></td>
	</tr>
</table>
