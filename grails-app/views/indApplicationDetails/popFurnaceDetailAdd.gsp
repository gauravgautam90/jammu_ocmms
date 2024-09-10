<head>
<g:javascript library="prototype" />
<g:javascript>

function select1()
{
	var selectmenu1=document.getElementById("furnaceInstalled")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp").style.display = 'none';
		}
	}
} 

function select2()
{
	var selectmenu1=document.getElementById("noisePollution")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp1").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp1").style.display = 'none';
		}
	}
} 

function select3()
{
	var selectmenu1=document.getElementById("dgStInstalled")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp2").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp2").style.display = 'none';
		}
	}
} 




function select4()
{
	var selectmenu1=document.getElementById("isHazarSubstanceProduced")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp4").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp4").style.display = 'none';
		}
	}
} 
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</g:javascript>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body>
<g:form name="saveHazardousChemical" method="post" action="saveFurnaceDetail" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Furnace Details</td>
					<input name="appId" type="hidden" value="<%=appDetId%>" />
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						 
						 					 <tr class="headngblue" bgcolor="#A8DAF3">
							  
							  
							  <td width="30%" align="left" >Furnace Installed</td>
							 
							 
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="furnaceInstalled" id="furnaceInstalled" onclick="javascript:select1()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
					
						 
						  <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
							
							
								 <div style="display:none; border:0;"  id="selectTemp"  >
				
				<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
	 <tr class="headngblue" >				 
				
				<td width="30%" align="left" >Furnace Name</td>
			
				<td bgcolor="#E8F6F9" align="left" class="headngblue">
			
			   <input name="furnaceName"  id ="furnaceName" type="text" maxlength="100" size="12"class="txt4" /><span class="sidetxt">(max. 100 chars)</span></td>
</tr>
			
<tr class="headngblue" >	
						<td width="30%" align="left" >Air pollution control device installed with Furnace</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
  <g:select class="txt4" multiple="multiple" from="${AirEmiControlMeasureMaster.list()}" name="airPollControlDevicefurnace"></g:select>

									</tr>
									
			
			<tr class="headngblue" >				 
				
				<td width="30%" align="left" >Prescribed parameters achieved</td>
			
				<td bgcolor="#E8F6F9" align="left" class="headngblue">
			
			   <input name="prescribedParameters"  id ="prescribedParameters" type="text" maxlength="250" size="12"class="txt4" /><span class="sidetxt">(max. 250 chars)</span></td>
</tr>
			
			
			
			
			
			<tr class="headngblue" >	
						<td width="30%" align="left" >Stack height above ground level(in meters)</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
			   <input name="stackHeight"  id ="stackHeight" type="text" maxlength="100" size="12"class="txt4" /> <span class="sidetxt">(max. 100 chars)</span></td>

									</tr>						
									
									
									
				<tr class="headngblue" >	
						<td width="30%" align="left" >Type of fuel</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
 
					   <input name="typeOfFuel"  id ="typeOfFuel" type="text" maxlength="250" size="12"class="txt4" /><span class="sidetxt">(e.g coal, max. 250 chars)</span>
					   
					   </td>
									</tr>						
														
									
											
				<tr class="headngblue" >	
						<td width="30%" align="left" >Quantity</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
 
					   <input name="quantity"  id ="quantity" type="text" maxlength="100" size="12"class="txt4" /><span class="sidetxt">(max. 100 chars)</span>
					   
					   </td>
									</tr>	
									
															
				<tr class="headngblue" >	
						<td width="30%" align="left" >Unit</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
 
							  <g:select class="txt4" from="${UnitMaster.list()}" name="unit"></g:select>
					   
					   </td>
									</tr>					
									
									
									
									
									</table>
								</div></td>
						  </tr>
																	  
							
							
						  
						
						
						
						
						
						
						
						
						   
							
						  
							
											 
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
		
 				  
						</table></td></tr>
 					<tr>
										<!-- Div area for errors-->
										<td align="center" valign="middle">
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
											</span>
										</td>
									</tr>				
					<tr>
					<td><span class="txt" style="color: navy"><b>List of  Furnace Details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 				
 					<tr bgcolor="#A8DAF3">
 					     
 					     
 					     
 					     
 					     
 					     
 					     
 					    
 					     
                         
                       
                         
                     <td width="12.5%" class="headngblue" ><div  class="style3">Is Furnace installed</div></td>
                       <td width="12.5%" class="headngblue" ><div  class="style3">Furnace Name</div></td>
                         
                         <td width="12.5%" class="headngblue" ><div  class="style3">Prescribed parameters achieved</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Air pollution control device installed with furnace</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Stack height above ground level (in meters)</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Type of fuel</div></td>
						 <td width="12.5%" class="headngblue" ><div  class="style3">Quantity</div></td>
						  <td width="12.5%" class="headngblue" ><div  class="style3">Unit</div></td>
                     
                    
                     
                     </tr>
                     
                     
 <g:each in="${furnaceDetailList}" status="i" var="miscelleneousList">
 
 
 
  <tr align="center" >
                     
                   
  					
  					
  					                   <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.furnaceInstalled} </span></td>
  					  	<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.furnaceName} </span></td>
  					
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.prescribedParameters} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.airPollControlDevicefurnace} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.stackHeight} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.typeOfFuel} </span></td>
                     
                     <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.quantity} </span></td>
                      <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.unit} </span></td>
                      
  
                        
        </tr>		
      </g:each>		
 					
 					</table></td></tr>
  </table>
					</td>
					</tr>	
  </table>
</g:form>
<script language="JavaScript" type="text/javascript">
</script>  
</body>