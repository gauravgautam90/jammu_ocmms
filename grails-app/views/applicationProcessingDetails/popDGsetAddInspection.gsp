<head>
<g:javascript library="prototype" />
<g:javascript>



function limit(){


if(document.getElementById("powerRating").value>300){
alert("please enter power rating less then 300");
document.getElementById("powerRating").value="";
}





}


function calculate()
{
var y,z;
if(document.getElementById("powerRating").value==""){
alert("Please enter power rating & height of the building to calculate");

}else{
var x=document.getElementById("powerRating").value;


document.getElementById('userInput').value=x;

if(x<50){
z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+1.5;

document.getElementById('totalHeight').value=y;


}
else if(x>50 && x<=100){

z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+2.0;

document.getElementById('totalHeight').value=y;




}

else if(x>100 && x<=150){

z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+2.5;

document.getElementById('totalHeight').value=y;




}

else if(x>150 && x<=200){

z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+3.0;

document.getElementById('totalHeight').value=y;




}

else if(x>200 && x<=250){

z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+3.5;

document.getElementById('totalHeight').value=y;




}

else if(x>250 && x<=300){

z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+3.5;

document.getElementById('totalHeight').value=y;

}

else if(x>300 && x<=350){

z=document.getElementById('heightOfBuilding').value;

var a =parseFloat(z);
y=a+3.5;

document.getElementById('totalHeight').value=y;

}



}


}




function select1()
{
	var selectmenu1=document.getElementById("loadShedding")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "No")
		{
			document.getElementById("selectTemp").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp").style.display = 'none';
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
<g:form name="saveDGsetMaster" method="post" action="saveDGsetInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">D.G. Set Details </td>
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						 	
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Make of D.G.Set</td>
							  <input name="appId" type="hidden" value="<%=appDetId%>" /> 
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="makeDGset" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(enter make of D.G.Set)</span></span></td>
							  
						  </tr>	  
						 						
							
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Model of D.G.Set</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="modelDGset" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(enter model of D.G.Set)</span></span></td>
							  
						  </tr>	
						  
						   <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Power Rating(in KVA)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input id="powerRating" name="powerRating" type="text" onblur="limit()" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(enter power rating )</span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Fuel Quantity</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="fuel" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(KL/day)</span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Stack Height</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="stackHeight" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(in meters)</span></span></td>
							</tr>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Height of the building</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input id="heightOfBuilding" name="heightOfBuilding" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(in meters)</span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Sound Power Level</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="soundLevel" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(at the manufacturing location)</span></span></td>
							  
						  </tr>
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Location</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="location" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(enter location of D.G.Set)</span></span></td>
							  
						  </tr>	
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Used only at the time of Load Shedding</td>
							  <td  bgcolkor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="loadShedding" id="loadShedding" onclick="javascript:select1()" class="txt4">
								<option value="Yes">Yes</option>
								<option value="No">No</option>
							  </select>
							<span class="sidetxt">(if not, give additional details)</span></span></td>
							</tr>
							
						  <tr class="headngblue" bgcolor="#A8DAF3">
								 <td colspan=2>
								 <div style="display:none; border:0;"  id="selectTemp"  >
									<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="30%" align="left" >Additional information of Load Shedding</td>
										    <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  				<input name="sheddingInfo" type="text" maxlength="100" size="12"class="txt4" />
									</tr></table>
								</div></td>
						  </tr>
																	  
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Whether noise from D.G.Set controlled by providing standard</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="noise"></g:select>
							<span class="sidetxt">(minimum 25dB(A) Insertion loss)</span></span></td>
							</tr> 
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Whether D.G.Set room is treated acoustically</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="room"></g:select>
							<span class="sidetxt">(minimum 25dB(A) Insertion loss)</span></span></td>
							</tr> 
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Whether the exhaust gases passed through a suitable exhaust maffler</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="exhaustGas"></g:select>
							<span class="sidetxt">(minimum 25dB(A) Insertion loss)</span></span></td>
							</tr> 
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Whether installation of D.G.Set is in compliance</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="installation"></g:select>
							<span class="sidetxt">(with the recommendations of D.G.Set manufacturer)</span></span></td>
							</tr> 
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Steps taken for minimization of vibration transmission to the neighourhood</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="minVibration"></g:select>
							<span class="sidetxt"></span></span></td>
							</tr> 
						  
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Steps taken for minimization of exhaust gas leaks</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4" from="${['No','Yes']}" name="minLeaks"></g:select>
							<span class="sidetxt"></span></span></td>
							</tr> 
						  
						
						
							
							<!--	
							  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Minimum height of stack</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="minHeight" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt">(calculated using formula H = h + 2&Pi;&radic;KVA)</span></span></td>
							</tr> 
							
							
								
					
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Total height of stack (in meters)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue">
							 
							  <span class="style30">
							 
							 
							 <a href="javascript:{}" onclick="return calculate();"  class="bulletinside"><b>Calculate</b></a>
							</span>
							
							
							
							
							</td>
							</tr> 
						   
	
						   
						   
						    <tr class="headngblue" bgcolor="#A8DAF3">
							<div style="display:none"  id="selectTemp5"  >
							
							<table>
							<tr>
							 <td>
							  <td width="30%" align="left" ></td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">User input:
							  <input id="userInput" name="userInput" type="text" maxlength="100" size="12" class="txt4" readonly="readonly"/>Total Height:
							  <input id="totalHeight" name="totalHeight" type="text" maxlength="100" size="12" class="txt4" readonly="readonly"/><span class="sidetxt">(in meters)</span>
							  
							<span class="sidetxt"></span></span>
							
							</td>
							</tr>
							</table>
							</div>
							
							</td>
							</tr>
						
						-->
						
						
						
						
						
						</div>	
							
						  <tr>
						  
						  </tr>
                   <td colspan="6">
                   <div id="AjaxPanelStack">
                   
                   </div>
                   </td>
                   </tr>
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter details</b></span>
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
					<td><span style="color:red">*Please enter N/A where nothing is applicable</span><br><span class="txt" style="color: navy"><b>List of Hazardous Chemical details added.</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					<tr bgcolor="#A8DAF3">
                         <td width="5%" class="headngblue" ><div  class="style3">Make of D.G.Set</div></td>
                         <td width="5%" class="headngblue" ><div  class="style3">Model of D.G.Set</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Power Rating</div></td>
                     	 
                     	 <td width="5%" class="headngblue" ><div  class="style3">Fuel Quantity</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Stack Height</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Height of the building</div></td>
                     	 
                     	 
                     	 
                     	 <td width="5%" class="headngblue" ><div  class="style3">Sound Power Level</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Location</div></td>
                     	 <td width="5%" class="headngblue" ><div  class="style3">Used only at the time of Load Shedding</div></td>
                     	 <td width="7%" class="headngblue" ><div  class="style3">Additional information of Load Shedding</div></td>
                     	 <td width="7%" class="headngblue" ><div  class="style3">Whether noise from D.G.Set controlled by providing standard</div></td>
                     	 <td width="9%" class="headngblue" ><div  class="style3">Whether D.G.Set room is treated acoustically</div></td>
                     	 <td width="11%" class="headngblue" ><div  class="style3">Whether the exhaust gases passed through a suitable exhaust maffler</div></td>
                     	 <td width="10%" class="headngblue" ><div  class="style3">Whether installation of D.G.Set is in compliance</div></td>
                     	 <td width="11%" class="headngblue" ><div  class="style3">Steps taken for minimization of vibration transmission to the neighourhood</div></td>
                     	 <td width="9%" class="headngblue" ><div  class="style3">Steps taken for minimization of exhaust gas leaks</div></td>
                  <!--  	 <td width="6%" class="headngblue" ><div  class="style3">Minimum height of stack</div></td> 
                <td width="6%" class="headngblue" ><div  class="style3">Total height of the stack</div></td> -->
                     	
                     	
                     	 </tr>
                     
                     
 <g:each in="${DGList}" status="i" var="dgInst">
  <tr align="center" >
  						<td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.makeDGset}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.modelDGset}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.powerRating}
                        </span></td>
                     
                     
                       <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.fuel}
                        </span></td>
                       <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.stackHeight}
                        </span></td>
                       <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.heightOfBuilding}
                        </span></td>
                       
                       
                       
                       
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.soundLevel}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.location}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.loadShedding}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.sheddingInfo}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.noise}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.room}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.exhaustGas}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.installation}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.minVibration}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.minLeaks}
                        </span></td>
                      <!--   
                       <td bgcolor="#E8F6F9" ><span class="txt ">${dgInst.totalHeight}
                        </span></td> -->
                        
      	</g:each>	
 					
 					</table></td></tr>
  </table>
					</td>
					</tr>
					 <tr><td align="center">
					 <% if(type=="REGULAR"){
	 	           			System.out.println("type...."+type)
	 	           			%>
	 	           		
	 	           		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

	 	           			()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
	 	           				
	 	           		<%}else{%>
	 	                  
	 						<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

	 	()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
	 		
	 					<%}%></td></tr>
  </table>
</g:form>
<script language="JavaScript" type="text/javascript">
</script>  
</body>