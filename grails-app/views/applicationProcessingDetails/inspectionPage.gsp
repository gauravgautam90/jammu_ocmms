
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>


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
}
function hidediv20() {

var selectmenu1=document.getElementById("courtCase")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp20').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp20').style.display = 'none';
   		 }
   }
}

function sensDiv(){
var selectmenu1=document.getElementById("senstiveArea")
selectmenu1.onchange=function()
{
	 var chosenoption=this.options[this.selectedIndex]
	    	 if(chosenoption.value == "YES"){
	    	 document.getElementById('ting1').style.display = 'block';
}else{
document.getElementById('ting1').style.display = 'none';
}
}
}

function sensDiv23(){
	var selectmenu1=document.getElementById("specificArea")
	selectmenu1.onchange=function()
	{
		 var chosenoption=this.options[this.selectedIndex]
		    	 if(chosenoption.value == "YES"){
		    	 document.getElementById('ting11').style.display = 'block';
	}else{
	document.getElementById('ting11').style.display = 'none';
	}
	}
	}

function sensDiv2345(){
	var selectmenu1=document.getElementById("incSewage")
	selectmenu1.onchange=function()
	{
		 var chosenoption=this.options[this.selectedIndex]
		    	 if(chosenoption.value == "YES"){
		    	 document.getElementById('ting1145').style.display = 'block';
	}else{
	document.getElementById('ting1145').style.display = 'none';
	}
	}
	}

function select10()
{
var selectmenu1=document.getElementById("reinspoff")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp10').style.display = 'block';
   	document.getElementById('selectTemp11').style.display = 'none';
   }
else{
    document.getElementById('selectTemp10').style.display = 'none';
    document.getElementById('selectTemp11').style.display = 'block';
  		 }
   }
} 

function hidediv200() {

var selectmenu1=document.getElementById("contained")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp200').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp200').style.display = 'none';
   		 }
   }
}

function hidediv800() {

var selectmenu1=document.getElementById("hazardousChemical")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp800').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp800').style.display = 'none';
   		 }
   }
}


function hidediv8000() {

var selectmenu1=document.getElementById("eia")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp8000').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp8000').style.display = 'none';
   		 }
   }
}

function hidediv7() {

var selectmenu1=document.getElementById("pli")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp7').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp7').style.display = 'none';
   		 }
   }
}

function hidediv21() {

var selectmenu2=document.getElementById("complaint")
selectmenu2.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp21').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp21').style.display = 'none';
   		 }
   }
}


function hidediv81() {

var selectmenu1=document.getElementById("grantOrRefuse")
selectmenu1.onchange=function()
 {    
 
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp81').style.display = 'block';
	 }
else{
	
    document.getElementById('selectTemp81').style.display = 'none';
  
	
   		 }
   }
}
</g:javascript>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>


<script type="text/javascript">

var popupWindow=null;

function child_open(url)
{ 

popupWindow =window.open(url,"_blank","directories=no, status=no, menubar=no, scrollbars=yes, resizable=no,width=600, height=280,top=200,left=200");

}

</script

</head>
<body>
<g:form name="waterSourceModeUses" method="post" action="saveInspection" >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<% 
				def inspReport = ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='Regular Inspection Report'",[appId])
				
				%>
 					
 					<tr bgcolor="#3090C7">
					<td align="center" valign="middle"  class="headngblue"><font color="white">Inspection Details</font></td>
					</tr>
					<tr class="headngblue" bgcolor="#A8DAF3" >
										<!-- Div area for errors-->
										<td align="center" valign="top">
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
										</span>
										</td>
									</tr>
					
 					<tr><td>
 					
 					<table width="100%" border="0" >
					<%System.out.println("inspReport..on gsp.."+inspReport)	
					System.out.println("consentInspInst..on gsp....."+consentInspInst) %>
							
					<tr>							  
					<%if(inspReport){%>
					<td  width="65%" align="left" bgcolor="" class="headngblue"></td>
					<td width="45%" align="center" valign="middle" bgcolor="white" class="headngblue"><g:def var="fooVar" value="${appId.id}"/><g:link action="printRegularInspectionReport" controller="applicationProcessingDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink">Print Regular Inspection Report</span></g:link></td>
					<%}%>
							
							
							
							<%if(consentInspInst){%>
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F0F8FF" class="headngblue">Name and Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="90" name="indNameConReport" id = "indNameConReport" value="${fieldValue(bean:consentInspInst,field:'indNameConReport')}">
							  </td>
							</tr> 
							<%}else{
							String name =appId.indUser.indName
							String address=appId.indUser.indAddress
							String regNo=appId.indUser.indRegNum
							String nameAddress= name+','+address
							
							
							%>
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F0F8FF" class="headngblue">Name and Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="90" name="indNameConReport" id = "indNameConReport" value="${nameAddress}">
							  </td>
							</tr> 
							
								<%}%>
	
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F0F8FF" class="headngblue">Correspondence Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text" size="90" name="indAddressConReport" id = "indAddressConReport" value="${fieldValue(bean:consentInspInst,field:'indAddressConReport')}">
							  </td>
							</tr> 
							<%if(consentInspInst){%>
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Capital Investment</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text"  name="totalCap" id = "totalCap" value="${fieldValue(bean:consentInspInst,field:'totalCap')}">
							  </td>
							</tr>
					<%}else{
					
					
					
					%>
								 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Capital Investment</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text"  name="totalCap" id = "totalCap" value="${appId.indUser.indCapInvt}">
							  </td>
							</tr>
					<%}%>
					<%if((appId.applicationFor=='stonecrusher') || (appId.applicationFor=='brickkilns') || (appId.indUser.industryType.industryType=='Hot mix plants')){%>
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Capital Investment Verified</td>
					  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  <input type="text"  name="prestan" id = "prestan" value="${fieldValue(bean:consentInspInst,field:'prestan')}">
					  </td>
					</tr> 
					
					<% } %>
					<!--	<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left"  bgcolor="#FF7F50">Date of Receipt at regional office</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="dateOfReceipt"  dateFormat="%d/%m/%Y" style="Size=12"  defaultValue="${new Date()}" class="txt4"/>					 
							  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left"  bgcolor="#FF7F58">Date of Receipt  at District office</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="dateOfReceiptdistrict"  dateFormat="%d/%m/%Y" style="Size=12"  defaultValue="${new Date()}" class="txt4"/>					 
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left"  bgcolor="#FF7F59">Date of Receipt  at Central office</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="dateOfReceiptcentral"  dateFormat="%d/%m/%Y" style="Size=12"  defaultValue="${new Date()}"  class="txt4"/>					 
							
						
							</tr> -->
							
									<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left"  bgcolor="#FF7F59">Period Applied for(Valid Upto)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					 <calendar:datePicker name="periodapplied"  dateFormat="%d/%m/%Y" style="Size=12"  defaultValue="${new Date()}"  class="txt4"/>					 
							
						
							</tr>			 
 
							<input type="hidden" name="appId" value="<%=appId%>">
								<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#FF7P89" class="headngblue ">
																Type of Consent :
																<br>
																a. Establish/Operate<br>
																b.Fresh/Renewal
																<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9">
															${appId.applicationType}<br>
															${appId.certificateFor}
																</td>
															</tr>
															
															
							
							
									<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue ">
																 Year of Commissioning of Unit:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9">
																 <input type="text"  name="commYear" id = "commYear" value="${fieldValue(bean:consentInspInst,field:'commYear')}">
																</td>
															</tr>					       
														              
									
									
														       
							
							
							  <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#FAFAD2" class="headngblue">Category</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <g:select from="${['RED','ORANGE','GREEN','WHITE']}"  name="inspecRepCategory" id = "inspecRepCategory" value="${appId.indUser.category.name}"/>
							<span>Category Selected By Industry:<font color="red">  <%=appId.indUser.category.name%></font></span>
							  </td>
							</tr>
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#FAFAD2" class="headngblue">Classification Of Industry/Hotel/Unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <g:select from="${['Small','Medium','Large']}"  name="inspecRepScale" id = "inspecRepScale" value="${appId.indUser.industryScale}"/>
							<span>Category Selected By Industry:<font color="red">  <%=appId.indUser.industryScale%></font></span>
							  </td>
							</tr>
							<%
							if(appId.applicationFor=='hotel'){
							
							%>
							<tr bgcolor="#F4F7FB">
							<td align="left" bgcolor="#A8DAF3" class="headngblue ">
						Tourism Department Registration No. :<span style="color:red"></span></td>
							<td align="left" bgcolor="#E8F6F9">
							${appId.indUser.indRegNum}</td>
						</tr>	
							<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue ">
															Hotel with or without Restaurant:<span style="color:red"></span></td>
																<td align="left" bgcolor="#E8F6F9">
																 <input type="text"  name="hotelRest" id = "hotelRest" value="${fieldValue(bean:consentInspInst,field:'hotelRest')}">
																</td>
															</tr>	
															
															
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue ">
															Room Capacity:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9">
																 <input type="text"  name="roomCapacity" id = "roomCapacity" value="${fieldValue(bean:consentInspInst,field:'roomCapacity')}">
																</td>
															</tr>	
							
							<%}%>
							<%if((appId.applicationFor=='stonecrusher') || (appId.applicationFor=='brickkilns') || (appId.indUser.industryType.industryType=='Hot mix plants')){%>
							
							
							<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A7BB03" class="headngblue ">
																Products Manufactured :
																</td>
																<td align="left" bgcolor="#E8F6F9">
																 <table width="100%">
														 <tr><td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Brick and Tiles/Stone Crusher/Hot mix plants quantity</td>	
															
														</tr>
														 
														  <tr><td  align="left">  <input	name="brickTiles" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'brickTiles')}"
														
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																</td>
																
															
														
															</tr>	</table>
																</td>
															</tr>	
															
							<%}%>
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Location  </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
																
							
														       </td></tr> 
														       
							
							  <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">In an Appoved Industrial area</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="industrialArea" id="industrialArea"  from="${['NO','YES']}"  class="txt4" value="">
					</g:select>
							  </td>
							</tr> 
					  <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Whether land paper submitted</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="papersub" id="papersub"  from="${['NO','YES']}"  class="txt4" value="">
					</g:select>
							  </td>
							</tr> 
							<%if((appId.applicationFor=='stonecrusher') || (appId.applicationFor=='brickkilns') || (appId.indUser.industryType.industryType=='Hot mix plants') || (appId.applicationFor=='hotmixplants') || (appId.applicationFor=='stonecrusher and hotmixplants')){%>
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Distance from Municipal Limits</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text"  name="areaSpecific" id = "areaSpecific" value="${fieldValue(bean:consentInspInst,field:'areaSpecific')}">
							  </td>
							</tr> 
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Distance from Distt. Headquarters</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text"  name="areaSenstive" id = "areaSenstive" value="${fieldValue(bean:consentInspInst,field:'areaSenstive')}">
							  </td>
							</tr> 
							<%}else{%>
							  <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">In Sensitive Area</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <select name="senstiveArea" id="senstiveArea" onclick="javascript:sensDiv()" class="txt4">
													      				<option value="NO">NO</option>
													      				<option value="YES">YES</option> 
														       </select>
							 
 <div style="display:none; border:0;"  id="ting1"  >
														    <input	name="areaSenstive" type="text" size="15"	value=""
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
																</div>
</td>
							</tr> 
							
							 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">In case of any other specific area</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <select name="specificArea" id="specificArea" onclick="javascript:sensDiv23()" class="txt4">
													      				<option value="NO">NO</option>
													      				<option value="YES">YES</option> 
														       </select>
							 
 <div style="display:none; border:0;"  id="ting11"  >
														    <input	name="areaSpecific" type="text" size="15"	value=""
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
																</div>
</td>
							</tr> 
							
							<% } %>
								
								 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Distance from river/Stream</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text"  name="distanceRiver" id = "distanceRiver" value="${fieldValue(bean:consentInspInst,field:'distanceRiver')}">
							  </td>
							</tr> 
									
					 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#BFFFBF" class="headngblue">Distance from National/state Highway</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
							  <input type="text"  name="distanceNational" id = "distanceNational" value="${fieldValue(bean:consentInspInst,field:'distanceNational')}">
							  </td>
							</tr> 
								
							<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9A9A9"  class="headngblue">Distance from Nearest habitation and its population </td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="distanceHabitat" id = "distanceHabitat" value="${fieldValue(bean:consentInspInst,field:'distanceHabitat')}"></td> 
			</tr>
									      
					<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9A9A9"  class="headngblue">District/Other Roads </td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="districtRoad" id = "districtRoad" value="${fieldValue(bean:consentInspInst,field:'districtRoad')}"></td> 
			</tr>									      
							<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9A9A9"  class="headngblue">Tourist complex/resorts </td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="touristComplex" id = "touristComplex" value="${fieldValue(bean:consentInspInst,field:'touristComplex')}"></td> 
			</tr>									      
														      
			       						      
							<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9A9A9"  class="headngblue">Forest</td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="forest" id = "forest" value="${fieldValue(bean:consentInspInst,field:'forest')}"></td> 
			</tr>	
			<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9ABBB"  class="headngblue">Controlled Area</td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="controlledArea" id = "controlledArea" value="${fieldValue(bean:consentInspInst,field:'controlledArea')}"></td> 
			</tr>	
			
			
			<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9A900"  class="headngblue">Approved water supply of 20 KL</td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="waterSupply" id = "waterSupply" value="${fieldValue(bean:consentInspInst,field:'waterSupply')}"></td> 
			</tr>
			<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#B90100"  class="headngblue">Hospital/Nursing home/Health center</td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="hospital" id = "hospital" value="${fieldValue(bean:consentInspInst,field:'hospital')}"></td> 
			</tr>
			<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9ABBB"  class="headngblue">Notified Bird sancuatry/national Park/Wildlife Area </td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="nationalPark" id = "nationalPark" value="${fieldValue(bean:consentInspInst,field:'nationalPark')}"></td> 
			</tr>
			<tr>
			
			<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9ABBB"  class="headngblue">Agriculture land/orchard except Dry /Banjar Kadeem</td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="agriculture" id = "agriculture" value="${fieldValue(bean:consentInspInst,field:'agriculture')}"></td> 
			</tr>
			<tr>
						<tr>
			<td width="45%"   align="left" valign="middle"  bgcolor="#A9ABBB"  class="headngblue">Nearest educational instituion or other similar Insitution</td>
			<td width="30%" align="left" valign="middle" colspan="3" bgcolor="#E8F6F9"  class="headngblue"><input type="text"  name="educationalInstituion" id = "educationalInstituion" value="${fieldValue(bean:consentInspInst,field:'educationalInstituion')}"></td> 
			</tr>
					
					
					<%if((appId.applicationFor=='stonecrusher') || (appId.indUser.industryType.industryType=='Hot mix plants')){%>
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Residential Area/Abadi </td>
					  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  <input type="text"  name="resArea" id = "resArea" value="${fieldValue(bean:consentInspInst,field:'resArea')}">
					  </td>
					</tr> 
					
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">SPM level(with prescribed standard or not)</td>
					  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  <input type="text"  name="spmLevel" id = "spmLevel" value="${fieldValue(bean:consentInspInst,field:'spmLevel')}">
					  </td>
					</tr> 
					
					<tr>

					<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Proposed /Installed PCDS</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Green Belt proposed</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Water Sprinkling System</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Jacketing/Enclosure at different section viz Crushing at Scren points </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Wind Breaking walls </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Metalling of Roads </td>
														  </tr>
														 	<tr><td  align="center">  <input	name="greenBelt" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'greenBelt')}"
														
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																</td>
																<td  align="center"> <input	name="waterSprinkle" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'waterSprinkle')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
															<td  align="center"> <input	name="jacketing" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'jacketing')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="windBreaking" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'windBreaking')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="metallingRoads" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'metallingRoads')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
															</td>	</table>
																</tr> 	
																<tr>
																<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Total proposed cost for installing the PCDs</td>
																	  <td align="left" bgcolor="#E8F6F9" colspan="3" >
																 <input	name="costPCD" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'costPCD')}"
																	maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
															       </td></tr> 
							
							<%}%>
							<%if((appId.applicationFor=='brickkilns')){%>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Proposed /Installed PCDS</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Chimney</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Setting Chamber with baffle</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mettaled Wall roads</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Plantation </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Others </td></tr>
														 
														  <tr><td  align="center">  <input	name="chimney" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'chimney')}"
														
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																</td>
																<td  align="center"> <input	name="chamber" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'chamber')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="roadsWall" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'roadsWall')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
															<td  align="center"> <input	name="plantation" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'plantation')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="others" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'others')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														
															</tr>	</table>
																</tr> 
															
															<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Total proposed cost for installing the PCDs</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="costPCD" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'costPCD')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
															
												<%}%>				
													<%if((appId.applicationFor=='both')){%>			 		       
						<td width="45%" align="left" valign="middle" bgcolor="#A8DRF3" class="headngblue">In case of expansion </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
																
							
														       </td></tr> 
														       
					
					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Expansion in plants and machinery</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="expansionPlant" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'expansionPlant')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
					
					
					

					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Capacity Utilization</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="capacityUtili" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'capacityUtili')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
					
					
					
					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Modernization or de-bottle necking</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="modernization" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'modernization')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
			       <%if((appId.applicationFor=='both')){%>    	       
			       <tr>
					<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Is there any increase in sewage/trade effluent quantity generated, 
					and if so, indicate the quantity(KLD)</td>
					<td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  <select name="incSewage" id="incSewage" onclick="javascript:sensDiv2345()" class="txt4">
											      				<option value="NO">NO</option>
											      				<option value="YES">YES</option> 
												       </select>
					 <div style="display:none; border:0;"  id="ting1145"  >
												    <input	name="areaincSewage" type="text" size="15"	value=""
														maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
												</div>
										</td>
									</tr> 
					<% } %>
					
					
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Details of sewage/trade effluent treatment. arrangements provided .Sewage and trade effluent are treated combinedly,Indicate the details and are these adequate/inadequate and comply</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="sewageEffluent" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'sewageEffluent')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
					
					
									       
									
									  	<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08080" class="headngblue">Detail of Sewage/trade effluent disposal arrangements provided- an examination of impact on enviorment waters</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="enviorment" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'enviorment')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 
														       
				  <tr>
					<td width="45%" align="left" valign="middle" bgcolor="#F08080" class="headngblue">Detail of any additional sewage/trade effluent treatment 
					and disposal of arrangements proposed to be provided.</td>
						 <td align="left" bgcolor="#E8F6F9" colspan="3" >
						<input	name="addSewagereq" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'addSewagereq')}"
							maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
						  </td></tr> 
								
			  <%}%>
					   													       
			  <tr>
		       
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">DG set with Capacity </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity</td>
														 <td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fuel (Kl/day)</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Stack height</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> From Ground Level </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Above the Shed/Roof </td></tr>
														 
														  <tr><td  align="center">  <input	name="categoryHaz" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'categoryHaz')}"
																
																maxlength="250" size="25" AUTOCOMPLETE=OFF /></td>
														  <td  align="center">  <input	name="fuel" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'fuel')}"
														
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																</td>
																<td  align="center"> <input	name="stackHeight" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'stackHeight')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
															<td  align="center"> <input	name="groundLevel" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'groundLevel')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="shed" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'shed')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														
															</tr>	</table>
																</tr> 
						
												
													<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08845" class="headngblue">Details with name ,type boiler,stream generation capacity(t/h quantity of fuel)</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="boilerType" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'boilerType')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 
												<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08787" class="headngblue">Details of Air pollution Control equipment installed</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="pollutionSystem" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'pollutionSystem')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 
							
							
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08678" class="headngblue">Additional Air pollution control measures proposed to be provided,If any</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="controlMeasure" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'controlMeasure')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 
														       
														       <tr>
				<td width="45%" align="left" valign="middle" bgcolor="#B07790" class="headngblue">Fugitive Emission an assessment </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="fugitiveEmission" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'fugitiveEmission')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr>
														       
														       <tr>
				<td width="45%" align="left" valign="middle" bgcolor="#B07790" class="headngblue">Noise levels-an assessment </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="noiseLevels" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'noiseLevels')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr>
														     <tr>
														   
														   <%if((appId.applicationFor=='both')){%>    
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Non-Hazardeous Solid waste </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Type</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Arrangements for Treatment </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Arrangements for disposal </td></tr>
														 
														  <tr><td  align="center">  <input	name="typeofNonHaz" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'typeofNonHaz')}"
														
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																</td>
																<td  align="center"> <input	name="nonHazQty" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'nonHazQty')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
															<td  align="center"> <input	name="treatmentArrang" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'treatmentArrang')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="disposalArrange" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'disposalArrange')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														
															</tr>	</table>
																</tr>   
														        
													       
									<%
									}
									def feeApplicable = ConsentFeeMaster.findAllByApplication(appId)
									
									
									def totalfeeAppli = feeApplicable.totalApplicableFee
									
									
									
									%>				       
														       
				
							
							
							
							
														
									<%if((appId.applicationFor=='both')){%>					       
														       
										

				 <input	name="quantityrecycler" type="hidden" size="15" value=""/>
				<tr>
				<td width="45%" align="left" valign="middle" bgcolor="##87CEEB" class="headngblue">Arrangement for Disposal of Hazardeous Waste:<span style="color:red">*</span></td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="methodOfDisposal" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'methodOfDisposal')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="##87CEEB" class="headngblue">Arrangement for treatment of Hazardeous Waste </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="methodOftreatment" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'methodOftreatment')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																
							
														       </td></tr> 							      
							
				<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#D2B48C" class="headngblue">Incase of waste being disposed by sale name of the party to whom the hazardeous waste is solid  </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 <input	name="saleName" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'saleName')}"
					maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
														       <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Incase of waste being stored in closed sheds/container, indicate details </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
				<textarea	name="closeShed" 
				maxlength="1500" col="10" row="10" >${fieldValue(bean:consentInspInst,field:'closeShed')}</textarea><span class="txt style6"><span class="sidetxt"></span></span>
				</td></tr> 
				
				
				
				  <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Incase of waste being stored/disposed off in landfill,the details of the landfill site,location dimensions,lining,capacity etc </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
				<textarea	name="storedOrDisposed" 
				maxlength="1500" col="10" row="10" >${fieldValue(bean:consentInspInst,field:'storedOrDisposed')}</textarea><span class="txt style6"><span class="sidetxt">Maximum Char 1500</span></span>
				</td></tr> 
				
				
				
				  <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Whether leachate collection arrangements have been provided  for the landfill site</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
				<textarea	name="leachate" 
				maxlength="1500" col="10" row="10" >${fieldValue(bean:consentInspInst,field:'leachate')}</textarea><span class="txt style6"><span class="sidetxt">Maximum Char 1500</span></span>
				</td></tr> 
				
							  <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Whether leachate are collected to treatement facility details of treatment</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
				<textarea	name="leachateCollect" 
				maxlength="1500" col="10" row="10" >${fieldValue(bean:consentInspInst,field:'leachateCollect')}</textarea><span class="txt style6"><span class="sidetxt">Maximum Char 1500</span></span>
				</td></tr> 							       
		  <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Hazardous chemical detail </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of Storage of Chemical</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether permission from concerned authpotiies like directorate of industrial safety and Health ,Localbody or explosive department is taken</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Whether on-site disaster management plan is prepared and mock drill conducted periodically </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is public liablity insuramce obtained as per public liability Act 1991  </td></tr>
														 
														  <tr><td  align="center">  <input	name="chemicalStorage" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'chemicalStorage')}"
														
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
																</td>
																<td  align="center"> <input	name="chemicalQty" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'chemicalQty')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
															<td  align="center"> <input	name="management" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'management')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														<td  align="center"> <input	name="publicLiability" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'publicLiability')}"
																maxlength="250" size="25" AUTOCOMPLETE=OFF /><span class="txt style6"><span class="sidetxt"></span></span>
														</td>
														
															</tr>	</table>
																</tr> 
														       								       
							      
									
							  <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Whether separate electric meter is installed for pollution control systems   </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="separateElectric" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'separateElectric')}"
																
														</td>
														
															
															</tr> 
											        <tr>
											        
											        
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Legal record of unit   </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="legal" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'legal')}"
																
														</td>
														
															
															</tr> 
											       
											        <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">whether any legal action has been taken agaianst the unit, if so the details thereof </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="authorityName" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'authorityName')}"
																
														</td>
														
															
															</tr> 
														<%}%>	
															
														<%if((appId.applicationFor=='hotel')){%>			
																									       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Legal record of unit   </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="legal" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'legal')}"
																
														</td>
														
															
															</tr> 
											       
											        <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">whether any legal action has been taken agaianst the unit, if so the details thereof </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="authorityName" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'authorityName')}"
																
														</td>	
															<tr>
															<%}%>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Acoustic enclosure/Sound proof system installeed or not(canopy)</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="acoustic" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'acoustic')}"
																
														</td>
														
															
															</tr> 
											       
											       
											       
											       
											       
											       
											       <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Adequacy of Pollution control system </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												<input	name="adequacy" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'adequacy')}"
																
														</td>
														
															
															</tr> 
															<tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BA5F" class="headngblue">
				<%if(applicationfor=='dgset'){%>
				Standards prescribed under Air(P&C) act 1981 7 EP act (D.G set noise level rules)
			<%}else{	%>
				
				What are the standards to be prescribed and reason for the proposed standards 
				<%}%>
				
				 </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
											<input	name="standards" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'standards')}"
														</td>
														</tr> 
											
						
		<!--RITESH CODE START-->
		<tr>
	       
		<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Location</td>
		<td align="left" bgcolor="#E8F6F9" colspan="3" >
					<input	name="location" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'location')}"
				</td></tr> 
				
				
			<tr class="headngblue" bgcolor="#A8DAF3">
						 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Whether product is permissible or not</td>
						  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="propermi" id="propermi"  from="${['NO','YES']}"  class="txt4" value="">
				</g:select>
					 </td>
						</tr> 					
						
			<tr>
					       
						<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Operation and maintenance of Pollution Control System </td>
						<td align="left" bgcolor="#E8F6F9" colspan="3" >
									<input	name="oprmain" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'oprmain')}"
								</td></tr> 				
						
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Impact on the receiving environment : </td>
					  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  </td>
					</tr> 	
					
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">(a) water and air-and comments thereof</td>
					 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="aircomm" id="aircomm"  from="${['NO','YES']}"  class="txt4" value="">
						</g:select>
					  </td>
					</tr>
					
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">(b) including examination of nearby industries</td>
					 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="incwxam" id="incwxam"  from="${['NO','YES']}"  class="txt4" value="">
						</g:select>
					  </td>
					</tr>
					
					
					
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Have any public complaints being received, if so, details thereof and comments</td>
					 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="pubcom" id="pubcom"  from="${['NO','YES']}"  class="txt4" value="">
						</g:select>
					  </td>
					</tr>
					
					
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#F4A460" class="headngblue">Whether environmental clearance required</td>
					 <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue"><g:select name="enviclea" id="enviclea"  from="${['NO','YES']}"  class="txt4" value="">
						</g:select>
					  </td>
					</tr>

					<%
					if((appId.applicationFor=='stonecrusher') || (appId.applicationFor=='brickkilns') || (appId.indUser.industryType.industryType=='Hot mix plants')){ %>
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Area under Plantation and No. of trees planted</td>
					  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  <input type="text"  name="recieveEnviroment" id = "prestan" value="${fieldValue(bean:consentInspInst,field:'recieveEnviroment')}">
					  </td>
					</tr> 
					
					<tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="45%" align="left" valign="middle" bgcolor="#A6A6DB" class="headngblue">Other Informations</td>
					  <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
					  <input type="text"  name="publicComplain" id = "publicComplain" value="${fieldValue(bean:consentInspInst,field:'publicComplain')}">
					  </td>
					</tr> 
					<tr>
															       
					<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Whether Consent may be granted</td>
					<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
					<g:select class="txt4" from="${['No','Yes']}" name="reinspoff" id="reinspoff" onclick="javascript:select10()" value="" ></g:select>
																										 
					</td>
					</tr>
					
					<tr>
					<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">
					<div style="display:none; border:0;"  id="selectTemp10" >
					If yes, Validity period of Consent and conditions if any,applicable </div>
					<div id="selectTemp11" >
					If no, further action recommended </div></td> 
					<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
					<input	name="reregioff" type="text" size="15"	value="${fieldValue(bean:consentInspInst,field:'reregioff')}"
					</td> 
					</tr> 

					
					<%} %>		
				
				       <tr>
						<td width="45%" align="left" valign="middle" bgcolor="#D2B48C" class="headngblue">Officer Recommendation </td>
						 <td align="left" bgcolor="#E8F6F9" colspan="3" >
							<textarea	name="redistoff" 
							maxlength="1500" col="10" row="10" >${fieldValue(bean:consentInspInst,field:'redistoff')}</textarea><span class="txt style6"><span class="sidetxt"></span></span>
							</td></tr> 
					
		
		<!--RITESH CODE ENDS-->
  
				
 
 <table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0" class="tblbdr" >
 			
 					<tr><td>
 					
 					<table class="tblbdr" width="100%">
 					
						 <tr >
						 
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
					</table>   </td></tr>
 					</table> 
 					
 					
 					
						<tr bgcolor="#3090C7">
					<td align="center" valign="middle"  class="headngblue" colspan="2"><font color="white">Details</font></td>
					
					
					<table width="100%">
					
					<%
					def applicationFor=appId.applicationFor
					if(applicationFor=="hotel"){%>
					<tr>
					<td   align="left" valign="middle"bgcolor="#E8F6F9"   class="headngblue">Hotel/Restaurant General Details</td>
					<td   align="center" valign="middle"  class="headngblue">
						<table width="100%">
						
						 <tr>
							<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelOtherDetailAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
							<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelOtherDetailViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
							<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelOtherDetailEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
						  </tr>
						</table>
					</td>
				</tr>
				<tr>
				<td   align="left" valign="middle"bgcolor="#E8F6F9"   class="headngblue">Hotel/Restaurant Facility Details</td>
				<td   align="center" valign="middle"  class="headngblue">
					<table width="100%">
					
					 <tr>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelFacilityAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelFacilityViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelFacilityEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
					  </tr>
					</table>
				</td>
			</tr>
		
			<tr>
			<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Water Consumption Details (Water Pollution Control)</td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				 <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
				  </tr>
				</table>
			</td>
			</tr>
			
			<tr>
			<td   align="left" valign="middle" bgcolor="#F0FFFF"  class="headngblue">Consent Details</td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				  <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailAdd?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailView?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailEdit?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
				  </tr>
				</table>
			</td>
		</tr>
		
		
		<tr>
		<td  align="left" valign="middle" bgcolor="#F0FFFF"  class="headngblue">Trade Effluent</td>
		<td  colSpan=3 bgcolor="#E8F6F9"  align="center">
		<table width="100%"><tr><td  align="center" >
		<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAddTradeEffluent?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a>
		<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popViewTradeEffluent?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
		<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popTradeEffluentEdit?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a>
		</td></tr></table></td>
		</tr>
		
		<tr>
		<td  align="left" valign="middle" bgcolor="#9ACD32"  class="headngblue">Primary Treatment Details Of Effluent</td>
		<td  colSpan=3 bgcolor="#E8F6F9"  align="center">
		<table width="100%"><tr><td  align="left" >
		<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAddSewageDetails?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a>
		<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popViewSewageDetails?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
		<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popSewageDetailsEdit?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a>
		</td></tr></table></td>
		</tr>
		
			
		<!--------------------------------------end------------------------------------------>		
	<%}else if(applicationFor=="dgset"){%>		
	
	<tr>
	<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">D.G. Set Details</td>
	<td   align="center" valign="middle"  class="headngblue">
		<table width="100%">
		
		<tr>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGsetAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGsetViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGsetEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
	  </tr>
		</table>
	</td>
</tr>	

<tr>
<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">D.G. Set Emission Source Details</td>
<td   align="center" valign="middle"  class="headngblue">
	<table width="100%">
	 <tr>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGSourceAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGSourceViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGSourceEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
	  </tr>
	</table>
</td>
</tr>	
<tr>
<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">D.G. Set Parameter Details</td>
<td   align="center" valign="middle"  class="headngblue">
	<table width="100%">
	 <tr>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGParameterAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGParameterViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popDGParameterEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
	  </tr>
	</table>
</td>
</tr>
	
	<%}else if((applicationFor=="stonecrusher") || (appId.indUser.industryType.industryType=='Hot mix plants')){%>
	

	<tr>
	<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Stone Crusher/Hot mix plants Siting Criteria Details</td>
	<td   align="center" valign="middle"  class="headngblue">
		<table width="100%">
		<tr>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popStoneSittingCriteriaAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popStoneSittingCriteriaViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popStoneSittingCriteriaEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
	  </tr>
		</table>
	</td>
	</tr>
	<tr>
	<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Stone Crusher/Hot mix plants Pollution Control Devices Details</td>
	<td   align="center" valign="middle"  class="headngblue">
		<table width="100%">
		<tr>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popStoneCrusherControlDevicesAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popStoneCrusherControlDevicesViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
		<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popStoneCrusherControlDevicesEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
	  </tr>
		</table>
	</td>
	</tr>
	<tr>
	<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">NOC Details</td>
	<td   align="center" valign="middle"  class="headngblue">
		<table width="100%">
		 <tr>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popNocAuthorityAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popNocAuthorityViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popNocAuthorityEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
		  </tr>
		</table>
	</td>
	</tr>
	<tr>
	<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Water Source Details</td>
	<td   align="center" valign="middle"  class="headngblue">
		<table width="100%">
		 <tr>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterConsumptionDetailAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterConsumptionDetailViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterConsumptionDetailEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
		  </tr>
		</table>
	</td>
	</tr>
	<tr>
	<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Water Consumption Details </td>
	<td   align="center" valign="middle"  class="headngblue">
		<table width="100%">
		 <tr>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
			<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
		  </tr>
		</table>
	</td>
	</tr>
		
			<%}else if(applicationFor=="brickkilns"){%>
			
			<tr>
			<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Brick Siting Criteria Details </td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				 <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popBrickSittingCriteriaAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popBrickSittingCriteriaViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popBrickSittingCriteriaEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
				  </tr>
				</table>
			</td>
			</tr>
			<tr>
			<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Brick Kilns Details </td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				<tr>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popBrickKilnAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popBrickKilnViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popBrickKilnEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
			  </tr>
				</table>
			</td>
			</tr>
			<tr>
			<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Water Source Details</td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				 <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterConsumptionDetailAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterConsumptionDetailViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterConsumptionDetailEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
				  </tr>
				</table>
			</td>
			</tr>
			<tr>
			<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Water Consumption Details </td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				 <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHotelWaterConsumptionEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
				  </tr>
				</table>
			</td>
			</tr>
			
			<tr>
			<td   align="left" valign="middle" bgcolor="#F0FFFF"  class="headngblue">Consent Details</td>
			<td   align="center" valign="middle"  class="headngblue">
				<table width="100%">
				  <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailAdd?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailView?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailEdit?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
				  </tr>
				</table>
			</td>
		</tr>
			
			<%}else{%>
			
				<!-----------end------------>
			
					<tr>
						<td   align="left" valign="middle"  class="headngblue">Products Details</td>
						<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popProductDetailsAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popProductDetailsViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popProductDetailsEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
						</td>
					</tr>
					<%if(appId.hazardeousType=="HWM"){%>
					<tr>
					<td  align="left" valign="middle"  class="headngblue">Activity/Hazardous Waste Generation Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHazardActivityGenDetailsAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHazardActivityGenDetailsViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popHazardActivityGenDetailsEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
					<%}%>
					<tr>
						<td   align="left" valign="middle" bgcolor="#F0FFFF"  class="headngblue">Consent Details</td>
						<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailAdd?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailView?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentDetailEdit?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
						</td>
					</tr>
					
					
					<tr>
					<td  align="left" valign="middle" bgcolor="#F0FFFF"  class="headngblue">Trade Effluent</td>
					<td  colSpan=3 bgcolor="#E8F6F9"  align="center">
					<table width="100%"><tr><td  align="center" >
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAddTradeEffluent?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popViewTradeEffluent?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popTradeEffluentEdit?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a>
					</td></tr></table></td>
					</tr>
					
					<tr>
					<td  align="left" valign="middle" bgcolor="#9ACD32"  class="headngblue">Primary Treatment Details Of Effluent</td>
					<td  colSpan=3 bgcolor="#E8F6F9"  align="center">
					<table width="100%"><tr><td  align="left" >
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAddSewageDetails?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popViewSewageDetails?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popSewageDetailsEdit?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a>
					</td></tr></table></td>
					</tr>
					
					<tr>
					<td  align="left" valign="middle" bgcolor="#FFB6C1"  class="headngblue">Air Pollution Detail</td>
					<td  colSpan=3 bgcolor="#E8F6F9"  align="center">
					<table width="100%"><tr><td  align="left" >
					
					
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAirStackAddInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAirStackViewInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAirStackEditInspection?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a>
					
					</td></tr></table></td>
					
					</tr>
					
					<tr>
					<td  align="left" valign="middle" bgcolor="#BDB76B"  class="headngblue"> Water Budget </td>
					<td  colSpan=3 bgcolor="#E8F6F9"  align="center">
					<table width="100%"><tr><td  align="left" >
					
					
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popAddWaterBudget?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popViewWaterBudgetDetails?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
					<td  bgcolor="#E8F6F9"  align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popWaterBudgetDetailsEdit?appId=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a>
					
					</td></tr></table></td>
					
					</tr>
				
		<%}%>			
					
		<tr>
		<td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">Details of Consent Fee Paid </td>
		<td   colSpan=3 align="center" valign="middle"  class="headngblue">
			<table width="100%">
			 <tr>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popFeesfromOfficerAdd?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popFeesfromOfficerView?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popFeesfromOfficerEdit?id=<%=appId%>&type=REGULAR', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
			  </tr>
			</table>
		</td>
		</tr>			  
						 
							
					
		
				
					</table>
					</td></tr></table>
					
					
					
					
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<%
 					System.out.println("newInst....on gsp..."+newInst)
 					
 					
 					if(newInst) {%>
 					<tr bgcolor="#D1D1D1"><td width="100%" align="center" ><font color="red"><b> Details added</b></font></tr><%}%>
 					<tr><td>
 					<%
 				
 					
 					
 					if(newInst) {%>
 					<table width="100%" border="0" >
						   <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'indNameConReport')}</td>
																
																
																
																 <tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Correspondance Address of the unit</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'indAddressConReport')}</td>
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital investment</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'totalCap')}</td>
																
														</tr>
	 <%
 	
		 String dateWithoutTime33 	
		String dateWithoutTime = new SimpleDateFormat("dd-MM-yyyy").format(newInst.dateOfReceipt);
		
 	dateWithoutTime33=new SimpleDateFormat("dd-MM-yyyy").format(newInst.dateOfReceiptdistrict);
 String datewithouttime11=new SimpleDateFormat("dd-MM-yyyy").format(newInst.dateOfReceiptcentral);
 
 String periodDate=new SimpleDateFormat("dd-MM-yyyy").format(newInst.periodapplied);
 	 %>
	
			
											
								<!--								<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of Receipt at regional office</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${dateWithoutTime}</td>
											
														</tr>
	
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of Receipt  at District office</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${dateWithoutTime33}</td>
																					
														</tr>
	
																
																<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of Receipt  at Central office</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${datewithouttime11}</td>
							
		</tr>
						-->
											
 						<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Period Applied for(Valid Upto)</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${periodDate}</td>
							
		</tr>
						
												
 						<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Year of Commissioning of Unit:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'commYear')}</td>
							
		</tr>
						
							
							
						
												
 						<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Category:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'inspecRepCategory')}</td>
							
		</tr>
							
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Classification Of Industry/Hotel/Unit:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'inspecRepScale')}</td>
							
		</tr>
							
					<%
							if(appId.applicationFor=='hotel'){
							
							%>		
							
						
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hotel with or without Restaurant</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'hotelRest')}</td>
							
		</tr>
							
						
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Room Capacity:</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'roomCapacity')}</td>
							
		</tr>
							
 					<%}%>	
							
							<%if((appId.applicationFor=='stonecrusher') || (appId.applicationFor=='brickkilns') || (appId.indUser.industryType.industryType=='Hot mix plants')){%>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Birck and Tiles/Stone Crusher/Hot mix plants quantity</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'brickTiles')}</td>
							
		</tr>
						<%}%>	
						
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Whether land paper submitted</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'papersub')}</td>
							
		</tr>
							
							
	
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Distance from river/Stream</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'distanceRiver')}</td>
							
		</tr>
							
							
						
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Distance from National/state Highway</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'distanceNational')}</td>
							
		</tr>
							
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Distance from Nearest habitation and its population </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'distanceHabitat')}</td>
							
		</tr>
							
							
 					<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Distance from Nearest habitation and its population </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'distanceHabitat')}</td>
							
		</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Tourist complex/resorts </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'touristComplex')}</td>
							
		</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> District/Other Roads </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'districtRoad')}</td>
							
		</tr>
							
						<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Forest </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'forest')}</td>
							
		</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Controlled Area </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'controlledArea')}</td>
							
		</tr>
							
				
					<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Approved water supply of 20KL </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'waterSupply')}</td>
							
		</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hospital/Nursing home/Health center </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'hospital')}</td>
							
		</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Notified Bird sancuatry/national Park/Wildlife Area </td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'nationalPark')}</td>
							
		</tr>
							
						
				
				
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Agriculture land/orchard except Dry /Banjar Kadeem</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'agriculture')}</td>
							
		</tr>
							
							<tr class="headngblue" bgcolor="#A8DAF3">
							 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Nearest educational instituion or other similar Insitution</td>
							  <td width="65%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${fieldValue(bean:newInst,
																field:'educationalInstituion')}</td>
							
		</tr>
							
						
				
				<%if((appId.applicationFor=='stonecrusher') || (appId.indUser.industryType.industryType=='Hot mix plants')){%>
					 <tr>
							
							
							<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Details</td>
							<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Green Belt proposed</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Water Sprinkling System</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Jacketing/Enclosure at different section viz Crushing at Scren points </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Wind Breaking walls </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Metalling of Roads </td>
														 	
														 	<tr>
														  <td  width="25%" align="center" bgcolor="#E8F6F9"> ${fieldValue(bean:newInst,field:'greenBelt')}
														
															
																</td>
																 <td width="35%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'waterSprinkle')}
																
														</td>
															 <td width="35%" align="center" bgcolor="#E8F6F9"
																	class="headngblue">  ${fieldValue(bean:newInst,field:'jacketing')}
																
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'windBreaking')}
																
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue">  ${fieldValue(bean:newInst,field:'metallingRoads')}
																
														</td>
														
															</tr>	</table>
																</tr>  	
							
							
							<%}%>
							<%if((appId.applicationFor=='brickkilns')){%>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Proposed /Installed PCDS</td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Chimney</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Setting Chamber with baffle</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mettaled Wall roads</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Plantation </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Others </td></tr>
														 
														  <tr> <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'chimney')}
														
																
																</td>
																 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'chamber')}
																
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'roadsWall')}
																
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue">  ${fieldValue(bean:newInst,field:'plantation')}
															
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'others')}
																
														</td>
														
															</tr>	</table>
																</tr> 
															
															<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Total proposed cost for installing the PCDs</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'costPCD')}
					
			       </td></tr> 
			       
			       
			      
															
												<%}%>		
												
												
												
												<%if((appId.applicationFor=='both')){%>			 		       
						<td width="45%" align="left" valign="middle" bgcolor="#A8DRF3" class="headngblue">In case of expansion </td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
																
							
														       </td></tr> 
														       
					
					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Expansion in plants and machinery</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'expansionPlant')}
					
			       </td></tr> 
					
					
					

					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Capacity Utilization</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'capacityUtili')}
				
			       </td></tr> 
					
					
					
					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Modernization or de-bottle necking</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 ${fieldValue(bean:newInst,field:'modernization')}
					<span class="txt style6"><span class="sidetxt"></span></span>
			       </td></tr> 
					
					<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#ADFF2F" class="headngblue">Details of sewage/trade effluent treatment. arrangements provided .Sewage and trade effluent are treated combinedly,Indicate the details and are these adequate/inadequate and comply</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'sewageEffluent')}
					
			       </td></tr> 
					
					
									       
									
									  	<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08080" class="headngblue">Detail of Sewage/trade effluent disposal arrangements provided- an examination of impact on enviorment waters</td>
					  <td align="left" bgcolor="#E8F6F9" colspan="3" >
				 ${fieldValue(bean:newInst,field:'enviorment')}
					
																
							
														       </td></tr> 
														       
							
			  <%}%>
					   													       		
			  <tr>
		       
				<td width="45%" align="left" valign="middle" bgcolor="#73EBFF" class="headngblue">DG set with Capacity </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity</td>
														 <td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fuel (Kl/day)</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Stack height</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> From Ground Level </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Above the Shed/Roof </td></tr>
														 
														  <tr> 
														  <td width="65%" align="center" bgcolor="#E8F6F9"
																class="headngblue">  ${fieldValue(bean:newInst,field:'categoryHaz')}
																</td>
														  <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue">  ${fieldValue(bean:newInst,field:'fuel')}
																	</td>
																 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'stackHeight')}
															</td>
															 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'groundLevel')}
																
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'shed')}
																
														</td>
														
															</tr>	</table>
																</tr> 
						
				
				
				
				
													<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08845" class="headngblue">Details with name ,type boiler,stream generation capacity(t/h quantity of fuel)</td>
					  <td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
					${fieldValue(bean:newInst,field:'boilerType')}
																
							
														       </td></tr> 
												<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08787" class="headngblue">Details of Air pollution Control equipment installed</td>
					  <td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
					${fieldValue(bean:newInst,field:'pollutionSystem')}
					
																
							
														       </td></tr> 
							
							
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#F08678" class="headngblue">Additional Air pollution control measures proposed to be provided,If any</td>
					  <td align="left" class="headngblue"bgcolor="#E8F6F9" colspan="3" >
					${fieldValue(bean:newInst,field:'controlMeasure')}
					
																
							
														       </td></tr> 
														       
														       <tr>
				<td width="45%" align="left" valign="middle" bgcolor="#B07790" class="headngblue">Fugitive Emission an assessment </td>
					  <td align="left"class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'fugitiveEmission')}
					
																
							
														       </td></tr>
														       
														       <tr>
				<td width="45%" align="left" valign="middle" bgcolor="#B07790" class="headngblue">Noise levels-an assessment </td>
					  <td align="left" class="headngblue"bgcolor="#E8F6F9" colspan="3" >
					${fieldValue(bean:newInst,field:'noiseLevels')}
				
																
							
														       </td></tr>
														     <tr>
														   
														   <%if((appId.applicationFor=='both')){%>    
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Non-Hazardeous Solid waste </td>
				<td align="left" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Type</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Arrangements for Treatment </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Arrangements for disposal </td></tr>
														 
														  <tr> <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'typeofNonHaz')}
														
																
																</td>
															 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> 	${fieldValue(bean:newInst,field:'nonHazQty')}
																
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'treatmentArrang')}
															
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'disposalArrange')}
																
														</td>
														
															</tr>	</table>
																</tr>   
														        
													       
									<%
									}															
									
									%>				       
														       
				
							
							
							
							
														
									<%if((appId.applicationFor=='both')){%>					       
														       
										
			
				
				<tr>
				<td width="45%" align="left" valign="middle" bgcolor="##87CEEB" class="headngblue">Arrangement for Disposal of Hazardeous Waste </td>
					  <td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
			${fieldValue(bean:newInst,field:'methodOfDisposal')}
				
																
							
														       </td></tr> 
							<tr>
				<td width="45%" align="left" valign="middle" bgcolor="##87CEEB" class="headngblue">Arrangement for treatment of Hazardeous Waste </td>
					  <td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'methodOftreatment')}
				
																
							
														       </td></tr> 							      
							
				<tr>
				<td width="45%" align="left" valign="middle" bgcolor="#D2B48C" class="headngblue">Incase of waste being disposed by sale name of the party to whom the hazardeous waste is solid  </td>
					  <td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'saleName')}
					
			       </td></tr> 
					
			       <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Incase of waste being stored in closed sheds/container, indicate details </td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'closeShed')} 
				
				</td></tr> 
				
				
				
				  <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Incase of waste being stored/disposed off in landfill,the details of the landfill site,location dimensions,lining,capacity etc </td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
				 ${fieldValue(bean:newInst,field:'storedOrDisposed')} 
				
				</td></tr> 
				
				
				
				  <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Whether leachate collection arrangements have been provided  for the landfill site</td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
				
				 ${fieldValue(bean:newInst,field:'leachate')} 
				
				
				</td></tr> 
				
							  <tr>
														       
														       
				<td width="45%" align="left" valign="middle" bgcolor="#9ACD32" class="headngblue">Whether leachate are collected to treatement facility details of treatment</td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'leachateCollect')} 
				
				
				
				</td></tr> 							       
		  <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#73ABFF" class="headngblue">Hazardous chemical detail </td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														      
														
														 <table width="100%">
														 <tr><td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Detail of Storage of Chemical</td>	
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether permission from concerned authpotiies like directorate of industrial safety and Health ,Localbody or explosive department is taken</td>
															<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Whether on-site disaster management plan is prepared and mock drill conducted periodically </td>
														 	<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is public liablity insuramce obtained as per public liability Act 1991  </td></tr>
														 
														  <tr> <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue">   ${fieldValue(bean:newInst,field:'chemicalStorage')}
														
																
																</td>
																 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'chemicalQty')}
																
														</td>
															 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'management')}
															
														</td>
														 <td width="65%" align="center" bgcolor="#E8F6F9"
																	class="headngblue"> ${fieldValue(bean:newInst,field:'publicLiability')}
															
														</td>
														
															</tr>	</table>
																</tr> 
														       								       
							      
									
							  <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Whether separate electric meter is installed for pollution control systems   </td>
				<td align="left" class="headngblue" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												${fieldValue(bean:newInst,field:'separateElectric')}
																
														</td>
														
															
															</tr> 
											        <tr>
											        
											        
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Legal record of unit   </td>
				<td align="left"  class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												${fieldValue(bean:newInst,field:'legal')}
																
														</td>
														
															
															</tr> 
											       
											        <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">whether any legal action has been taken agaianst the unit, if so the details thereof </td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												${fieldValue(bean:newInst,field:'authorityName')}
																
														</td>
														
															
															</tr> 
														<%}%>	
															
														<%if((appId.applicationFor=='hotel')){%>			
																									       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Legal record of unit   </td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
												${fieldValue(bean:newInst,field:'legal')}
																
														</td>
														
															
															</tr> 
											       
											        <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">whether any legal action has been taken agaianst the unit, if so the details thereof </td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 
														 
														 
												${fieldValue(bean:newInst,field:'authorityName')}
																
														</td>	
															<tr>
															<%}%>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BAFF" class="headngblue">Acoustic enclosure/Sound proof system installeed or not(canopy)</td>
				<td align="left" class="headngblue" bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														 ${fieldValue(bean:newInst,field:'acoustic')}
														 
												
																
														</td>
														
															
															</tr> 
											       
											       <tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BA5F" class="headngblue">
				<%if(applicationfor=='dgset'){%>
				Standards prescribed under Air(P&C) act 1981 7 EP act (D.G set noise level rules)
			<%}else{	%>
				
				What are the standards to be prescribed and reason for the proposed standards 
				<%}%>
				
				 </td>
				<td align="left" class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
												     
														       														
														       														
														  ${fieldValue(bean:newInst,field:'standards')}
														 
														 
												
																
														</td>
														
															
															</tr> 
															
															
														
				<tr>
														       
				<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Location</td>
				<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
				${fieldValue(bean:newInst,field:'location')}  														
																									 
				</td>
				</tr> 
				
				<tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Whether product is permissible or not</td>
				  <td width="65%" align="left" bgcolor="#E8F6F9"
														class="headngblue">${fieldValue(bean:newInst,
													field:'propermi')}</td>
				
</tr>
				
<tr>

<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Operation and maintenance of Pollution Control System </td>
<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
${fieldValue(bean:newInst,field:'oprmain')}  														
																					 
</td>
</tr> 	
				
<tr class="headngblue" bgcolor="#A8DAF3">
<td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Whether product is permissible or not</td>
 <td width="65%" align="left" bgcolor="#E8F6F9"
										</td>

</tr>	


<tr class="headngblue" bgcolor="#A8DAF3">
 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> (a) wate and air-and comments thereof</td>
  <td width="65%" align="left" bgcolor="#E8F6F9"
										class="headngblue">${fieldValue(bean:newInst,
									field:'aircomm')}</td>

</tr>



<tr class="headngblue" bgcolor="#A8DAF3">
 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">(b) including examination of nearby industries</td>
  <td width="65%" align="left" bgcolor="#E8F6F9"
										class="headngblue">${fieldValue(bean:newInst,
									field:'incwxam')}</td>

</tr>


<tr class="headngblue" bgcolor="#A8DAF3">
 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Have any public complaints being received, if so, details thereof and comments</td>
  <td width="65%" align="left" bgcolor="#E8F6F9"
										class="headngblue">${fieldValue(bean:newInst,
									field:'pubcom')}</td>

</tr>


<tr class="headngblue" bgcolor="#A8DAF3">
 <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether environmental clearance required</td>
  <td width="65%" align="left" bgcolor="#E8F6F9"
										class="headngblue">${fieldValue(bean:newInst,
									field:'enviclea')}</td>

</tr>

<%
if((appId.applicationFor=='stonecrusher') || (appId.applicationFor=='brickkilns') || (appId.indUser.industryType.industryType=='Hot mix plants')){ %>
<tr>
										       
<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Whether Consent may be granted</td>
<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
${fieldValue(bean:newInst,field:'reinspoff')}  																						 
</td>
</tr> 
<tr>
<div style="display:none; border:0;"  id="selectTemp10" >
<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">If yes, Validity period of Consent and conditions if any,applicable</td>
<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
${fieldValue(bean:newInst,field:'reregioff')}  														
																					 
</td> </div>
</tr> 

<tr>
<div style="display:none; border:0;"  id="selectTemp11" >
<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">If no, further action recommended</td>
<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
${fieldValue(bean:newInst,field:'reregioff')}  														
																					 
</td> </div>
</tr> 
<%} %>
<tr>
										       
<td width="45%" align="left" valign="middle" bgcolor="#D1BA0F" class="headngblue">Officer Recommendation</td>
<td align="left"  class="headngblue"  bgcolor="#E8F6F9" colspan="3" >
${fieldValue(bean:newInst,field:'redistoff')}  														
																					 
</td>
</tr> 




				
						
 					<%}%>
 					
 					
 					</td></tr>
						
					
					  
  </table>
					</td>
					</tr>	
					
					  
  </table>


						</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("indNameConReport","req","Please Enter Name and Address of the unit.");

 frmvalidator.addValidation("methodOfDisposal","req","Arrangement for Disposal of Hazardeous Waste");
 
 </script>  
						
				

</body>