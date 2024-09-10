
<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >
<tr bgcolor="#A8DAF3" >
					<td  align="left" colspan="2" valign="middle"  class="headngblue">Purpose of which Water Consumed  </td>
					<td  align="left" colspan="5" valign="middle"  class="txt"><g:select name="purpose" optionValue="purpose" from="${CessWaterConsumptionPurposeMaster.list()}" class="txt4" /></td>
			</tr>
		 <tr width="100%" >
	<td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Source of Consumption </td>
	<td width="8%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Meter Reading </td>
	<td width="11%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Start Reading </td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >End Reading</td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Quantity (KL) </td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" > Water Qty (3 Month Avg.)</td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Quantity of water for rebate </td>
			</tr>
	<tr>
	<% List sourceMaster1=CessSourceConsumptionMaster.list(); %>
 	 <g:if test="${sourceMaster1}"> 
    <tbody>
		<g:each in="${sourceMaster1}" status="i" var="sourceMaster">
		<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
		<tr>
			<td class="txt"><input type="checkbox" name="<%=sourceMaster.source %>1" id="<%=sourceMaster.source %>1" onclick="enablingDisabling1();"/>${fieldValue(bean:sourceMaster,field:'source')}</td>
			<td  align="left" valign="middle"  class="headngblue"><div >
			<select name="meterWorking_<%=sourceMaster.source %>" id="meterWorking_<%=sourceMaster.source %>1" disabled>
					
  						<option value="yes">Yes</option>
  						<option value="no">No</option>
  						
					</select>
                    </div></td>
			<td  align="left" valign="middle"  class="txt4"><div><input name="startReading_<%=sourceMaster.source %>1" id="startReading_<%=sourceMaster.source %>1" type="text" class="txt4" size="8" maxlength="10" disabled/> </div></td>
            <td  align="left" valign="middle"  class="txt4"><div ><input name="endReading_<%=sourceMaster.source %>1" id="endReading_<%=sourceMaster.source %>1" type="text" class="txt4"  size="8" maxlength="10" disabled/> </div></td>
            <td  align="left" valign="middle"  class=" txt4"><div ><input name="quantity_<%=sourceMaster.source %>1" id="quantity_<%=sourceMaster.source %>1" type="text" class="txt4" size="8" maxlength="10" disabled/></div></td>
            <td  align="left" valign="middle"  class=" txt4"><div ><input name="threeMonthQuantity_<%=sourceMaster.source %>1" id="threeMonthQuantity_<%=sourceMaster.source %>1" type="text" class="txt4" size="8" maxlength="10" disabled/></div></td>
            <td  align="left" valign="middle"  class=" txt4"><div ><input name="rebateQuantity_<%=sourceMaster.source %>1"  id="rebateQuantity_<%=sourceMaster.source %>1" type="text" class="txt4"  size="8" maxlength="10" disabled/></div></td>
		</tr>
						</g:each>
						</tbody>
					
				</g:if>
  </tr>
  <tr>
                    <td height="20"align="center" valign="middle"   class="headngblue">
                    	<div align="left">Remarks, if any:</div>
                    	<div align="left"><span class="headngblue txt"></span></div></td>
                    <td height="20" colspan="6"align="center" valign="middle"   class="headngblue">
                    	<div align="left">
                        <textarea name="remarks" class="txt4" cols="60" ></textarea>
                    	</div></td>
     </tr>
  </table>
