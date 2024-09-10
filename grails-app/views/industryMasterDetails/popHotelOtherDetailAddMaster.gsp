<head>
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
  </g:javascript>
 <g:javascript>

function select10()
{
var selectmenu1=document.getElementById("dgSet")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp10').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp10').style.display = 'none';
   		 }
   }
} 


function select11()
{
var selectmenu1=document.getElementById("indpendentRestaurant")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp11').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp11').style.display = 'none';
   		 }
   }
} 


function select12()
{
var selectmenu1=document.getElementById("deptTourism")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp12').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp12').style.display = 'none';
   		 }
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
<g:form name="waterSourceModeUses" method="post" action="saveHotelOtherDetailMaster" >
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					 
 					
 					<tr bgcolor="#D1D1D1">
					
					<td align="center" valign="middle"  class="headngblue">Hotel/Restaurant/Lodge/Guest House Other Details</td>
					</tr>
 				 <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                   <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>

                      </span></div></td>
                    </tr>
 					<tr><td>
 					<input type="hidden" name="appId" value="<%=appDetId%>">
 					<table width="100%" border="0" >
						 	
						<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Name of Hotel/Lodge/Guest House</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="hotelName" type="text" maxlength="300" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Room Capacity of Hotel/Lodge/Guest House</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="roomCapacity" type="text" maxlength="300" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Restaurants Independent of Hotel</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <select name="indpendentRestaurant" id="indpendentRestaurant"    onclick="javascript:select11();" class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						  </select></td>
							</tr>
							
							
							<tr>
										<td bgcolor="#E8F6F9" colspan="2">
										<div style="display:none; border:0;" id="selectTemp11" colspan="2">
										<table cellpadding="0" cellspacing="0" >
										<tr>
										   <td class="headngblue" bgcolor="#A8DAF3" align="center">
												Name & Style of Restaurant
												<br>
												<input	name="restaurantN" id="restaurantN"  type="text"    class="txt4"	maxlength="300"	AUTOCOMPLETE=OFF size="20"/>
													
											</td>
											<td class="headngblue" bgcolor="#A8DAF3" align="center" >
												 Seating Capacity
												<br>
												<input	name="capacity" id="capacity" type="text" class="txt4"  maxlength="300"	AUTOCOMPLETE=OFF size="20"/>
													
											</td>
											
											
											<td class="headngblue" bgcolor="#A8DAF3" align="center" >
												Year of Establishment
												<br>
												<input	name="year" id="year" type="text" class="txt4"  maxlength="300"	AUTOCOMPLETE=OFF size="20"/>
													
											</td>
											
											</tr></table>
													</div>			
										         </td>          
										    </tr>		
						  
						 
							
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Total Project Cost(Rs.)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="investment" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Location</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							<g:select class="txt4" from="${['Residential','Commercial','Silence Zone','Sensitive Zone']}" name="location"></g:select>
							<span class="sidetxt"></span></span></td>
							  
						  </tr>	 
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Distance from Major Water Bodies (In Meters)</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="distance" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Is DG set used</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							 <select name="dgSet" id="dgSet"    onclick="javascript:select10();" class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						  </select>
						  </td>
						  </tr>
						
						 		 <tr>
										<td bgcolor="#E8F6F9" colspan="2">
										<div style="display:none; border:0;" id="selectTemp10">
										<table cellpadding="0" cellspacing="0" >
										<tr>
										   <td class="headngblue" bgcolor="#A8DAF3" align="center">
												Make
												<br>
												<input	name="make" id="make"  type="text"    class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="25"/>
													
											</td>
											<td class="headngblue" bgcolor="#A8DAF3" align="center" >
												Capacity(in KVA)
												<br>
												<input	name="dgcapacity" id="dgcapacity" type="text" class="txt4"  maxlength="20"	AUTOCOMPLETE=OFF size="25"/>
													
											</td>
											
											</tr></table>
													</div>			
										         </td>          
										    </tr>		
						  		
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Other Pollution Prevention Measures</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="prevention" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Are You Registered with Department of Tourism?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							   <select name="deptTourism" id="deptTourism"    onclick="javascript:select12();" class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						             </select>
						             
						             			    		  
										<div style="display:none; border:0;" id="selectTemp12">
										Provide Details
												<br>
												<input	name="tourismDetails" id="tourismDetails"  type="text"    class="txt4"	maxlength="300"	AUTOCOMPLETE=OFF size="20"/>
													
											</td>
							</tr>	
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Whether N.O.C from Fire Department obtained?</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							   <select name="nocObtained" id="nocObtained"  class="txt4">
							            <option value="Yes">Yes</option>
						   				<option value="No">No</option>
							    		
						             </select>	
						             </tr>
							
							
							
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Other Relevent Information</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <input name="relInfo" type="text" maxlength="100" size="12"class="txt4" />
							<span class="sidetxt"></span></span></td>
							</tr>
						  
						  						 						
							
						<tr class="headngblue" bgcolor="#D1D1D1" >
							  <td width="30%" align="center">Pollution Control Measures </td>
							  
							</tr>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
										<td bgcolor="#E8F6F9" >
										<table cellpadding="0" cellspacing="0" >
										
										<tr class="headngblue" bgcolor="#A8DAF3">
										
										
							  <td width="10%" align="left" >Septic Tank Provided</td>
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
							  <select name="septicTank" id="septicTank"    class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
							  </td>
										   
											 
											 <td width="10%" align="left" >
												Soakage Pit
												</td>
										<td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
										<select name="soakagePit" id="soakagePit"    class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
											</td>
											
											
											<td width="10%" align="left" >
												Sewage Treatment Plant
												</td>
												<td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
												<select name="sewagePlant" id="sewagePlant"  class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
											</td>
											
											
											<td width="10%" align="left" >
												Chimeny With Hoods
											</td>
												<td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
												<select name="hotelchimeny" id="hotelchimeny"  class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
											</td>
											
											</tr></table>
													</div>			
										         </td>          
										    </tr>		
											
											
											<tr class="headngblue" bgcolor="#A8DAF3">
										<td bgcolor="#E8F6F9" >
										<table cellpadding="0" cellspacing="0" >
										
										
											
											<tr class="headngblue" bgcolor="#A8DAF3">
											
													
											<td width="10%" align="left" >
												Exhaust Fans
												</td>
												<td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
												<select name="exhaustFans" id="exhaustFans"  class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
											</td>
											
											<td width="10%" align="left" >
												Solid Waste Management
												</td>
												<td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
												<select name="solidWaste" id="solidWaste"  class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
											</td>
											
											<td width="10%" align="left" >
												Greenery/Plantation
												</td>
												<td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30">
												<select name="greenery" id="greenery"  class="txt4">
						   				<option value="No">No</option>
							    		<option value="Yes">Yes</option>
						                  </select>
											</td>
											
											</tr></table>
													</div>			
										         </td>          
										    </tr>		
						  
						  
							
											
							
														
						  <tr>
                   <td colspan="6">
                   <div id="AjaxPanelStack">
                   
                   </div>
                   </td>
                   </tr>
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						</table></td></tr>
 					
					<tr>
					<td><span class="txt" style="color: navy"><b>List of Hotel/Restaurant/Lodge /Guest House General Detail</b></span>
					<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					             <td width="150px" class="headngblue" ><div  class="style3">Name of Hotel/Lodge/Guest house</div></td>
                                   <td width="150px" class="headngblue" ><div  class="style3">Room Capacity Hotel/Lodge/Guest house</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Restaurants Independent of Hotel</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Name & Style of Restaurant</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Seating Capacity </div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Year of Establishment</div></td>
                                       <td width="150px" class="headngblue" ><div  class="style3">Total Project Cost(Rs.)</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Location</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Distance from Major Water Bodies (In Meters)</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Is DG sets used</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Make</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Capacity(in KVA)</div></td>
                                      <td width="150px" class="headngblue" ><div  class="style3">Other Pollution Prevention Measures</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Are You Registered with Department of Tourism?</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Provide Details</div></td>
                                      
                         </tr>
                         
                         
                         
                     
                     
 <g:each in="${hotelOtherDetailList}" status="i" var="hotelOtherDetailInst">
  <tr align="center" >
                     <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.hotelName}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.roomCapacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.indpendentRestaurant}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.restaurantN}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.capacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.year}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.investment}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.location}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.distance}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.dgSet}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.make}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.dgcapacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.prevention}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.deptTourism}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.tourismDetails}</span></td>
  					
  					
                        
        </tr>
        </g:each>			
        
        
                   <tr bgcolor="#A8DAF3">
                   <td width="150px" class="headngblue" ><div  class="style3">Whether N.O.C from Fire Department obtained?</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Other Relevent Information</div></td> 
                          <td width="150px" class="headngblue" ><div  class="style3">Septic Tank Provided</div></td> 
 					       <td width="150px" class="headngblue" ><div  class="style3">Soakage Pit</div></td>  
 					        <td width="150px" class="headngblue" ><div  class="style3">Sewage Treatment Plant</div></td>
 					        <td width="150px" class="headngblue" ><div  class="style3">Chimeny With Hoods</div></td>  
 					        <td width="150px" class="headngblue" ><div  class="style3">Exhaust Fans</div></td> 
 					         <td width="150px" class="headngblue" ><div  class="style3">Solid Waste Management</div></td> 
 					         <td width="150px" class="headngblue" ><div class="style3">Greenery/Plantation</div></td>        
                         </tr>
                         
                          <g:each in="${hotelOtherDetailList}" status="i" var="hotelOtherDetailInst">
                          <tr align="center" >
                          <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.nocObtained}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.relInfo}</span></td>
                  <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.septicTank}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.soakagePit}</span></td> 
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.sewagePlant}</span></td>  
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.hotelchimeny}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.exhaustFans}</span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.solidWaste}</span></td> 
                    <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.greenery}</span></td>   
                    
        </tr>	
             
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>

<!-- --------------------------- -->

						</g:form>
<script language="JavaScript" type="text/javascript">
 var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("roomCapacity","numeric","Capacity should be numeric");
  frmvalidator.addValidation("distance","dec","distance should be numeric or decimal");
  frmvalidator.addValidation("investment","dec","Project Cost should be numeric");
   frmvalidator.addValidation("tmethod","req","Enter method of Hotel Waste Emission");
  
  
 </script>  
						
						

</body>