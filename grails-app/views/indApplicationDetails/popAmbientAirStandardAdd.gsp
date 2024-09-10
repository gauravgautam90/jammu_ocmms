<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />
<g:javascript>
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
<g:form name="waterSourceModeUses" method="post" action="saveAmbientAirStandard" >
<table>
<tr bgcolor="#D1D1D1"><td align="center" colspan="2" class="headngblue">Ambient Air Quality Standards</td></tr>
				
				<tr>
					<td colspan="2">
						<table width="100%" border="0"  class="tblbdr">
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  
							  <td width="5%" align="center" >Selected Option</td>
							  <td width="65%" align="center" >Area Category</td>
							  <td width="5%" align="center" >SPM</td>
							  <td width="5%" align="center" >SO2</td>
							  <td width="5%" align="center" >CO</td>
							  <td width="5%" align="center" >NOx<input name="appId" type="hidden" value="<%=appDetId%>" /></td>
							  <td width="5%" align="center" >Noise Day</td>
							  <td width="5%" align="center" >Noise Night</td>
							  <td width="5%" align="center" >RSPM</td>
						    </tr>
						  <g:each in="${AmbientAirQualityStandardMaster.list()}" var="ambAir">
							<tr>
							
							  <td bgcolor="#E8F6F9" height="20" align="center" >
							    <input class="txt" type="checkbox" name="${ambAir.areaCategory}" value="${ambAir.id}" />
						      </td>
							  <td bgcolor="#E8F6F9" height="20" class="txt" align="center" ><div align="left">${ambAir.areaCategory} </div></td>
							  <td bgcolor="#E8F6F9" align="center" class="txt" >${ambAir.spm}</td>
							  <td bgcolor="#E8F6F9" align="center" class="txt" >${ambAir.so2}</td>
							  <td bgcolor="#E8F6F9" height="20" align="center" class="txt" >${ambAir.co}</td>
							  <td bgcolor="#E8F6F9" height="20" align="center" class="txt">${ambAir.nox}</td>
							  <td bgcolor="#E8F6F9" height="20" align="center" class="txt">${ambAir.noiseDay}</td>
							  <td bgcolor="#E8F6F9" height="20" align="center" class="txt">${ambAir.noiseNight}</td>
							  <td bgcolor="#E8F6F9" height="20" align="center" class="txt">${ambAir.rspm}</td>
						    </tr>
						    </g:each>
						    <tr><span class="txt" style="color: navy"><b>Check multiple record to add at once</b></span>
						    <td colspan="8" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
							</tr>
						</table>
					</td>
				</tr>
				<!--  -->
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<span class="txt" style="color: navy"><b>List of ambient standard details added.</b></span>
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="150px" class="headngblue" ><div  class="style3">Area Category</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">SPM</div></td>
                        <td width="150px" class="headngblue" ><div  class="style3">SO2</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">CO</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">NOx</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Noise Day</div></td>
                      	<td width="150px" class="headngblue" ><div  class="style3">Noise Night</div></td>
                     	<td width="150px" class="headngblue" ><div  class="style3">RSPM</div></td>
                      </tr>
 <g:each in="${ambientAirQualityStadDetList}" status="i" var="ambientAirInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.areaCategory}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.spm}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.so2}
                        </span></td>
                         <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.co}
                        </span></td>
                         <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.nox}
                        </span></td>
                         <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.noiseDay}
                        </span></td>
                         <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.noiseNight}
                        </span></td>
                         <td bgcolor="#E8F6F9" ><span class="txt style6">${ambientAirInst.ambient.rspm}
                        </span></td>
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
				
				
				</table>
				</g:form>
				
				</body>