<head>
<g:javascript library="prototype" />
<g:javascript>

function select1()
{
	var selectmenu1=document.getElementById("boilerInstalled")
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
<g:form name="saveHazardousChemical" method="post" action="saveBoilerDetail" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Boiler Details</td>
					<input name="appId" type="hidden" value="<%=appDetId%>" />
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						 
						 					 <tr class="headngblue" bgcolor="#A8DAF3">
							  
							  
							  <td width="30%" align="left" >Boiler Installed</td>
							 
							 
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="boilerInstalled" id="boilerInstalled" onclick="javascript:select1()" class="txt4">
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
				
				<td width="30%" align="left" >Boiler Name</td>
			
				<td bgcolor="#E8F6F9" align="left" class="headngblue">
			
			   <input name="boilerName"  id ="boilerName" type="text" maxlength="100" size="12"class="txt4" /><span class="sidetxt"></span></td>
</tr>
				
				
				
				<tr class="headngblue" >				 
				
				<td width="30%" align="left" >Stream give capacity</td>
			
				<td bgcolor="#E8F6F9" align="left" class="headngblue">
			
			   <input name="streamCapacity"  id ="streamCapacity" type="text" maxlength="100" size="12"class="txt4" /><span class="sidetxt">(tons per hour)</span></td>
</tr>

<tr class="headngblue" >	
						<td width="30%" align="left" >Air pollution control device installed with boiler</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
  <g:select class="txt4" multiple="multiple" from="${AirEmiControlMeasureMaster.list()}" name="airPollControlDeviceBoiler"></g:select>

									</tr>
									
			<tr class="headngblue" >	
						<td width="30%" align="left" >Stack height above ground level </td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
			   <input name="stackHeight"  id ="stackHeight" type="text" maxlength="100" size="12"class="txt4" /><span class="sidetxt">(in meters)</span></td>

									</tr>						
									
									
									
				<tr class="headngblue" >	
						<td width="30%" align="left" >Sampling platform provider</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
 <select name="samplingPlatform" id="samplingPlatform"  class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
									</tr>						
														
									
									
									
									
									
									
									</table>
								</div></td>
						  </tr>
																	  
							
							
						  
						
						
						
						
						
						
						
						
						   
							
						  
							
											 
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b><br></span>
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
					<td><span class="txt" style="color: navy"><b>List of  Boiler Details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 				
 					<tr bgcolor="#A8DAF3">
 					     <td width="12.5%" class="headngblue" ><div  class="style3">Is Boiler installed</div></td>
                     <td width="12.5%" class="headngblue" ><div  class="style3"> Boiler Name</div></td>
                      
                      
                         <td width="12.5%" class="headngblue" ><div  class="style3">Stream gives capacity</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Air pollution control device installed with boiler</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">Stack height above ground level</div></td>
                         <td width="12.5%" class="headngblue" ><div  class="style3">sampling platform provider</div></td>

                     </tr>
                     
                     
 <g:each in="${boilerDetailsList}" status="i" var="miscelleneousList">
 
 
 
  <tr align="center" >
                   <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.boilerInstalled} </span></td>
  				 <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.boilerName} </span></td>
  					
  					
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.streamCapacity} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.airPollControlDeviceBoiler} </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.stackHeight} </span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${miscelleneousList.samplingPlatform} </span></td>
     
                        
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