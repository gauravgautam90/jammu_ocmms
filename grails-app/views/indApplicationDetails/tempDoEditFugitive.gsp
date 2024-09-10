<table width="100%" cellpadding="0" cellspacing="0">
<tr>
							  <td height="26" align="center" ><span class="style30">
							    <input name="sourceFugitiveEmmision" type="text" size="12" />
							  </span></td>
							  <td height="26" align="center" ><span class="style30">
							    <g:select optionKey="id" from="${AirEmmisionParameter.list()}" name="fugitivePresPara"></g:select>
							  </span></td>
							  <td height="26" align="center" ><span class="style30">
							    <input name="fugPresStand" type="text" size="12" />
							  </span></td>
							  <td height="26" align="center" ><a href="javascript:createAirEmmFugitive()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
							</tr>
							</table>