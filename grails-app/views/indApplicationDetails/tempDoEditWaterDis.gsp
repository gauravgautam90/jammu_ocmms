<table width="100%" cellpadding="0" cellspacing="0">
<tr bgcolor="#F4F7FB" align="left">
  <td height="26" align="center" ><span class="style30">
  <span class="style30 style4 style1">
  <g:select optionKey="id"  from="${WaterDisTypeMaster.list()}" name="waterDisType"></g:select>
  </span> </span></td>
  <td height="26" align="center" ><input name="maxEffGen" type="text" size="14" class="txt4" /></td>
  <td height="26" align="center" ><span class="style30">
  <span class="style30 style4 style1">
  <input name="effRecycle" type="text" size="14" class="txt4" />
  </span> </span></td>
  <td height="26" align="center" ><span class="style30">
  <input name="effDisposed" type="text" size="14"  class="txt4"/>
  </span></td>
  <td height="26" align="center" ><span class="style30"><span class="style30 style4 style1">
  <g:select optionKey="id"  from="${WaterDisModeMaster.list()}" name="waterDisMode"></g:select>
  </span></span></td>
  <td align="center" ><a href="javascript:createRowWaterDis()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
</tr>
</table>