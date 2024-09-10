<table  width="100%" cellpadding="0" cellspacing="0">

		
<tr>
           		<td  width="25%"  bgcolor="#A8DAF3" class="headngblue" >Usage</td>
                <td    width="25%" bgcolor="#E8F6F9" class="txt4">
                         <g:select class="txt4" optionKey="id"  from="${WaterUsesMaster.list()}" name="waterSourceUses"></g:select>
                                <span class="sidetxt">(select)</span></td>
        
                <td width="20%"   class="headngblue" bgcolor="#A8DAF3">Quantity (Kl/D)</td>
                <td  width="25%"  bgcolor="#E8F6F9" class="txt4"><input class="txt4" name="sourceUseQuantity" type="text" size="6"class="txt4" /><span class="sidetxt">(enter qty)</span></td>
       			<td><a href="javascript:createRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
    
        </tr>
</table>