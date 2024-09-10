<table width="100%">
<tr>
                <td   align="center" class="headngblue"><span class="style30">
                  <input type="text"  name="product" />
                </span></td>
                <td  align="center" class="headngblue"><span class="style30">
                  <input type="text"  name="quantity"  />
                </span></td>
                <td  align="center" class="headngblue"><span class="style30">
                  <g:select optionKey="id"  from="${UnitMaster.list()}" name="unit" ></g:select>
                </span></td>
                <td  align="center" class="headngblue"><span class="style30">
                  <input type="text"  name="byProduct"  />
                </span></td>
                <td  align="center" class="headngblue"><span class="style30">
                  <input name="rawMaterials" type="text" size="12"class="txt4"/>
                </span></td>
				<td  align="center" class="headngblue"><a  href="javascript:createRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
              </tr>
</table>