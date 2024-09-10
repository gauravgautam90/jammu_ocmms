<table width="100%" cellpadding="0" cellspacing="0">
<tr bgcolor="#F4F7FB">
  	<td height="26" align="center" ><span class="style30">
  	<span class="style30 style4 style1">
  	<g:select optionKey="id"  from="${WaterConModeMaster.list()}" name="waterConMode"></g:select>
  	</span> </span></td>
	<td height="26" align="center" ><input name="conQuantity" type="text" size="14"class="txt4" /></td>
	<td height="26" align="center" ><span class="style30">
	<span class="style30 style4 style1">
	<g:select optionKey="id"  from="${WaterGenModeMaster.list()}" name="waterGenMode"></g:select>
  	</span> </span></td>
  	<td height="26" align="center" ><span class="style30">
    <input name="genQuantity" type="text" size="14"class="txt4" />
 	</span></td>
 	<td height="26" align="center" ><a href="javascript:createRowWaterCon()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
</tr>
</table>