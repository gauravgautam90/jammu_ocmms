

<table width="100%" cellpadding="0" cellspacing="0">
			
                    <thead>
                        <tr bgcolor="#F4F7FB" >
                        
                   	        <td class="headngblue">Role Name
							<a href="popupex.html" onclick="return popitup('../roleMaster/pop1')"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROLE" ></a></td>
							<td></td>
							<td class="headngblue">Can Forward To</td>
							
						</tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleMasterInstanceList}" status="i" var="roleMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}" >
                        	
                            <td><input type="radio" name="abc" value='${fieldValue(bean:roleMasterInstance, field:'id')}'><span class="style1">${fieldValue(bean:roleMasterInstance, field:'roleName')}</span></td>
                            <td>&nbsp;</td>
                        	<td><input type="checkbox" name='${fieldValue(bean:roleMasterInstance, field:'roleName')}'><span class="style1">${fieldValue(bean:roleMasterInstance, field:'roleName')}</span></td>
                        </tr>
                    </g:each>
					<tr bgcolor="#F4F7FB">
					<td class="headngblue" colspan="3" align="left">Activity Rights</td>
					</tr>
					<g:each in="${roleActivityMasterInstanceList}" status="i" var="roleActivityMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td align="left" colspan="3"><input type="checkbox" name='${fieldValue(bean:roleActivityMasterInstance, field:'activityName')}'><span class="style1">${fieldValue(bean:roleActivityMasterInstance, field:'activityName')}</span> </td>
                            
                    </tr>
                    </g:each>
					<input type="hidden" name="roleSize" id="roleSize" value="${roleMasterInstanceList.size()}">
                    </tbody>
					<tr><td colspan="100%" align="center"></td></tr>
					<tr></tr>
</table>
