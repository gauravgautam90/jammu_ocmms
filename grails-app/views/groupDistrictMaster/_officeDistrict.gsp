  
                           <table width="100%">
						<tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Group:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                        
                      
    				<g:select optionKey="id" from="${roleList}"  class="txt4"  onclick="${remoteFunction(controller:'groupDistrictMaster', action:'updateSelectSHOW',update:'roleSelected', params:'\'cont=\' + this.value' )}" name="group_id" value="${groupDistrictMasterInstance?.group?.id}" ><span class="txt4">(select group)</span></g:select>
                   
                        
                     
                        
                    </span></td>
                      </tr>
                            <tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">District To Attach:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                        
                         <div id ="roleSelected1">
                         
						 <g:select optionKey="id" from="${finalDistrictList}"   class="txt4"  size="5" multiple="multiple" name="district_id"  ></g:select>
				</div>
                        </span></td>
                      </tr>
					  </table>