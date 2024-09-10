<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
                     <td height="26" align="center" ><span class="style30">
                       <input name="stackPlant" type="text" size="12"  class="txt4"/>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <input name="sourceCapacity" type="text" size="12" class="txt4" />
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <g:select optionKey="id" from="${AirEmmisionUnitMaster.list()}" name="sourceUnit"></g:select>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <g:select optionKey="id" from="${AirEmmisionParameter.list()}" name="stackPresPara"></g:select>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <input name="presStand" type="text" size="12" class="txt4" />
                     </span></td>
                     <td height="26" align="center" ><a href="javascript:createAirEmmStack()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
                  </tr>
</table>