
<table width="100%" id="table12">
	<tr>
	     <td bgcolor="#A8DAF3" class="headngblue">Hazardous waste generated*:</td>
	     <td bgcolor="#E8F6F9"  align="left" class="headngblue">
				<table width="320" border="1">
				      	<tr>
				       		<td >Type</td>
				      		<td >Quantity(Tonnes/KL)</td>
				     	</tr>
				      	<tr>
				       		<td><g:select class="txt4" optionKey="type" from="${TypeOfHazardeousWaste.list()}"  name="hw_Type"  ></g:select></td>
				       		<td><input name="hw_Qty" id="hw_Qty" type="text"  size="21" maxlength="20" AUTOCOMPLETE=OFF class="txt4" /></td>
				       	</tr>
				       	<tr>
				       		<td >Waste Characteristics</td>
				       		<td >Source</td>
				       	</tr>	
				       	<tr>
				       	 	<td><g:select class="txt4" optionKey="characteristics" from="${CharacteristicsOfHazardeousWaste.list()}"  name="characteristics"  ></g:select></td>
				      	 	<td><g:select class="txt4" optionKey="sources" from="${SourcesOfHazardeousWaste.list()}"  name="hw_Source"  ></g:select></td>
				       	</tr>
				</table>	
		 </td>
	</tr>
	<tr>
	     <td bgcolor="#A8DAF3" class="headngblue">Storage and Disposal Details*:</td>
	     <td bgcolor="#E8F6F9"  align="left" class="headngblue">
	  			<table border="1">
		 	        	<tr>
			        		<td >Mode of Storage </td>
				       		<td >Method of Disposal </td>
				     	</tr>
				       	<tr>
				       		<td><g:select class="txt4" optionKey="modeOfStorage" from="${ModeOfStorageDisposalDetails.list()}"  name="mode_Of_Storage"  ></g:select></td>
				      		<td><g:select class="txt4" optionKey="methodOfDisposal" from="${MethodsOfHazardeousDisposalDetails.list()}"  name="method_Of_Disposal"  ></g:select></td>
				      	</tr>
				       	<tr>
				      		<td >Capacity(Tonnes/KL)</td>
				       		<td >Quantity Disposed</td>
				   		</tr>	
				       	<tr>
				       	 	<td><input name="capacity_Of_Disposal" type="text"  size="42" maxlength="20" AUTOCOMPLETE=OFF class="txt4" /></td>
				   			<td><input name="quantityDisposed" type="text"  size="9" maxlength="20" AUTOCOMPLETE=OFF class="txt4" /></td>
				   		</tr>
				</table>	
		 </td>  
	</tr>
	
	           																							
</table>
</form>