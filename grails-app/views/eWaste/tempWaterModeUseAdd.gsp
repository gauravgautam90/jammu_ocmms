<table width="95%" cellpadding="0" cellspacing="0">

<hr>
		<tr>
           		<td width="355" bgcolor="#A8DAF3" class="headngblue" >Mode Of Use</td>
                <td width="275" colspan="4" bgcolor="#E8F6F9" class="txt4">
                                   <g:select class="txt4" optionKey="id"  from="${WaterModeUseMaster.list()}" name="waterModeUse"></g:select>
                    <span class="sidetxt"> (select mode)</span>
                </td>
                <td>&nbsp;</td>
        </tr>
        <tr>
                <td width="355" class="headngblue" bgcolor="#A8DAF3">Quantity (Kl/D)</td>
                <td width="275" colspan="4" bgcolor="#E8F6F9" class="txt4"><input name="modeUseQuantity" type="text" size="12"class="txt4" />
                	<span class="sidetxt">(enter qty)</span>
                </td>
                <td>&nbsp;</td>
        </tr>
        
        <tr>
                <td width="355" class="headngblue" bgcolor="#A8DAF3">Waste Water Generation (Kl/D)</td>
                <td width="275" bgcolor="#E8F6F9" class="txt4"><input name="modeUseWasteGeneration" type="text" size="12"class="txt4" />
                <span class="sidetxt">(enter qty)</span></td>
       			<td  > <a href="javascript:createRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
        </tr>
</table>