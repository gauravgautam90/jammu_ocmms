 <table width="100%">
						<tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Dealing Group:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                        
                      
    				<g:select optionKey="id"  id="groupId" name="groupId" from="${roleList1}" onclick="${remoteFunction(controller:'roleMaster', action:'updateGrpSel',update:'roleSelected', params:'\'cont=\' + this.value' )}" value=""></g:select>
                   
                        
                     
                        
                    </span></td>
                      </tr>
                            <tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Role :</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                        
                         <div id ="roleSelected">
				<g:select optionKey="id"  name="grp" from="${roleList5}"></g:select>
				</div>
                        </span></td>
                      </tr>
					  </table>