<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
                     <td height="26" align="center" ><span class="style30">
                       <g:select optionKey="id" from="${AirEmmisionFuelTypeMaster.list()}" name="fuelType" ></g:select>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                        <g:select optionKey="id" from="${AirEmmisionFuelMaster.list()}" name="fuelName" ></g:select>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <input name="fuelQuantity" type="text" size="12" class="txt4" />
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <g:select optionKey="id" from="${AirEmmisionUnitMaster.list()}" name="fuelQuantityUnit" ></g:select>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                       <input name="fuelCapacity" type="text" size="12"  class="txt4"/>
                     </span></td>
                     <td height="26" align="center" ><span class="style30">
                        <g:select optionKey="id" from="${AirEmmisionUnitMaster.list()}" name="fuelCapacityUnit" ></g:select>
                     </span></td>
                     <td height="26" align="center" ><a href="javascript:createAirEmmFuel()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
                  </tr>
                  </table>