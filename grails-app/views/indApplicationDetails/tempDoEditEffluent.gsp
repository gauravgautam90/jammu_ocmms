<table width="100%" cellpadding="0" cellspacing="0">
<tr class="headngblue1">
	 <td height="36" align="center" class="style30" >
	 <span class="style30 style4 style1">
	 <g:select optionKey="id"  from="${EffluentTypeMaster.list()}" name="effType"></g:select>
	 </span> </td>
	 <td height="36" align="center" class="style30 style4 style1" >
	 <g:select optionKey="id"  from="${EffluentStandardMaster.list()}" name="effStand"></g:select>
	 </td>
	 <td height="36" align="center" class="style30" >
	 <span class="style30 style4 style1">
	 <g:select optionKey="id"  from="${EffluentParameterMaster.list()}" name="effParameter"></g:select>
	 </span> </td>
	 <td height="36" align="center" class="style30" >
	 <input name="parameterStandard" type="text" size="25" class="txt4" />
	 </td>
	 <td height="36" align="center" ><a href="javascript:createEffStand()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
</tr>
</table>