
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
<g:form  name="waterSourceModeUses" method="post" action="saveHWMInspectionReport" >
<table width="70%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<% 
				def inspReport = WasteManagementFile.find("from WasteManagementFile afd where afd.applicationId=? and afd.typeOfFile='Inspection Report HWM'",[insData.id.toLong()])
				
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
						   
							
					<tr>							  
					<%if(inspReport){%>
					<td  width="65%" align="left" bgcolor="" class="headngblue"></td>
					<td width="45%" align="center" valign="middle" bgcolor="white" class="headngblue"><g:def var="fooVar" value="${inspReport.id}"/><g:link action="printFreshInspectionReport" controller="wasteManagementProcessingDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink">Print Inspection Report</span></g:link></td>
					<%}%>
							
						</tr>	
							
						
						<tr>
						<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Industry<span style="color:red">*</span>: </td>
						
						<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
						
						
					
						  ${insData.industryRegMasterObj?.indName}<input type="hidden" name="indName" value="${insData.industryRegMasterObj?.indName}"/><input type="hidden" name="hcfName" value="${insData.industryRegMasterObj.indName}"/>
						</td>
					
					</tr>     
							
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Postal Address of Industry</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					${insData.industryRegMasterObj?.indAddress}
					</td>
					
				</tr>     
					
								
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Telephone no & Fax no</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Phone:
					${insData.industryRegMasterObj?.indPhoneCode}-${insData.industryRegMasterObj?.indPhoneNo} , Fax- ${insData.industryRegMasterObj?.indFaxCode}-${insData.industryRegMasterObj?.indFaxNo}
					</td>
					
				</tr>   
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					${insData.industryRegMasterObj?.indEmail}
					</td>
					
				</tr>  
				</tr>   
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of visit :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<span class="txt style6">
                     <calendar:datePicker   dateFormat="%d/%m/%Y" name='dateofvisit' value="${inspection.dateofvisit}"/>
                     <br><span class="sidetxt">(select date)</span>
					</td>
				    </tr> 	
				
				
				
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Contact Person Name,Telephone No.& Designation</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Name-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><input type="text" name="contactperson" value="${inspection?.contactperson}" size="30" class="txt4"></td>
					</tr>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Contact-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><input type="text" name="contact" value="${inspection?.contact}" maxlength='10' size="10" class="txt4"></td>
					
					</tr>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Designation-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><input type="text" name="desigantion" value="${inspection?.desigantion}" size="10" class="txt4"></td>
					
					</tr>
					
					</table>
					</td>
					
				</tr>     
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Designation of the offical visiting the unit</td>
					<td   align="center" bgcolor="#E8F6F9"  class="headngblue">
					<table width="50%">
					<tr>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popAddOfficerDesigHWM/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popViewOfficerDesigHWM/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popEditOfficerDesigHWM/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete</a></td>
					</tr>
					</table>
					</td>
				</tr>  
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Process description in brief.for each Product.Also attach Process Flow Diagram indicating raw materials and sources of hazardouswaste generation along with mass balance.</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<textarea rows="5" cols="50" name="processDesc"  maxlength="250" class="txt4" size="25" />
					${inspection.processDesc}</textarea>
					</td>
					
				</tr>     
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Year of Commissioning.</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<calendar:datePicker   dateFormat="%d/%m/%Y" name="yearCommission" value="${inspection?.yearCommission}"/>
		         </textarea>
					</td>
					
				</tr>      
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Production in MT or KL/day</td>
				    <td   align="center" bgcolor="#E8F6F9"  class="headngblue">
					<table width="50%">
					<tr>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popProductDetailsHWM/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popProductDetailsHWMView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popProductDetailsHWMEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
					</tr>
					</table>
					</td>
					
				</tr>  
				
				
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status oc consent under the water act,1974</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Date of issue-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><calendar:datePicker name="dateIssueWater"  dateFormat="%d/%m/%Y" size="10" value="${inspection?.dateIssueWater}"/></td>
					</tr>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Validity-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><calendar:datePicker name="dateValWater"  dateFormat="%d/%m/%Y" size="10" value="${inspection?.dateValWater}" /></td>
					
					</tr>
					
					</table>
					</td>
					
				</tr>  
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status oc consent under the air act,1981</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Date of issue-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><calendar:datePicker name="dateIssueAir"  dateFormat="%d/%m/%Y" size="10" value="${inspection?.dateIssueAir}" /></td>
					</tr>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Validity-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><calendar:datePicker name="dateValAir"  dateFormat="%d/%m/%Y" size="10" value="${inspection?.dateValAir}"/></td>
					
					</tr>
					
					</table>
					</td>
					
				</tr> 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status of Auhtrization under HazardeousWaste</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 <Table>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Date of issue-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><calendar:datePicker name="dateIssueHwm"  dateFormat="%d/%m/%Y" size="10" value="${inspection?.dateIssueHwm}" /></td>
					</tr>
					<tr>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Validity-</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><calendar:datePicker name="dateValHwm"  dateFormat="%d/%m/%Y" size="10" value="${inspection?.dateValHwm}" /></td>
					
					</tr>
					<tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmGenInspectionAdd/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add</a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmGenInspectionView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmGenInspectionEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
					</tr>
					</table>
					</td>
					
				</tr> 
				 <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Categories of HWM generated and their respective quantity</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table width="100%" align="center">
					<tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmGeneralInsDetailsAdd/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmGeneralInsDetailsView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmGeneralInsDetailsEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
					</tr>
					</table>
					</td>
					
				</tr>     
				 
				 <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capitive recycling utilization Incrination Secured Landfilling facility details</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<textarea rows="5" cols="50" name="caprecyDesc"  maxlength="250"  class="txt4" size="25"/>
					${inspection?.caprecyDesc}</textarea>
		</td>
				</tr>   
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of HW Storage,Qanitity of HW Stored and period of storage</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table width="100%" align="center">
					<tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmStorageAdd/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmStorageView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHwmStorageEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
					</tr>
					</table>
					</td>
					
				</tr> 
	 <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Categories and quantity of HW sent to authorized actual user/Common TSDF</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table width="100%" align="center">
					<tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHWMActualUserAuthAdd/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHWMActualUserAuthView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHWMActualUserAuthEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
					</tr>
					</table>
					</td>
					
				</tr> 

 <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Safety Facelities provided at storage facility11</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<Table width="100%" align="center">
					<tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHWMsafetyInsAdd/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHWMsafetyInsView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				        <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popHWMsafetyInsEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
					</tr>
					</table>
					</td>
					
				</tr> 
				
				 <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Environment Monitoring</td>
					
					</td>
					
				</tr>
		
		         <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of HW contaminated sites if any within and outside the industry primise</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><textarea rows="5" cols="50" name="HWcontaminated"   maxlength="250" class="txt4" size="25"/>
					
					${fieldValue(bean:inspection,field:'contaminatedRemark')}</textarea>
					</td>
					
				</tr>
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Remark:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					<textarea rows="5" cols="50" name="remarks"   maxlength="250" class="txt4" size="25"/>
					${fieldValue(bean:inspection,field:'remarks')}</textarea>
		
					</td>
					
				</tr>
				<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Inspecting officer :</td>
				<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				<input type="text" name="inspectionOfficer" value="${inspection.officerName}" size="30" class="txt4">
	
				</td>
				
			</tr>
  </table>
  
					</td>
					</tr>	
					<table width="96%" align="center">
			   		<tr>
			   		<td colspan="3">&nbsp;</td>
			   		</tr>
				  <tr>
					<td width="75%" align="center"><input type="submit"  value="Save" class="actionbutton" ><input type="hidden" name="appId" value="${insData.id}" class="actionbutton" ></td>
					
						
							
				  </tr>
				</table>
					  
  </table>


						</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("indNameConReport","req","Please Enter Name and Address of the unit.");

 frmvalidator.addValidation("methodOfDisposal","req","Arrangement for Disposal of Hazardeous Waste");
 
 
 function checkonButton(){
	 var v=document.getElementById('withinHCF').value;
	 console.log("-----v---"+v)
	 if(v=="yes"){
		 document.getElementById('withinHCFNo').checked=false
	 }else if(v=="no"){
		 document.getElementById('withinHCF').checked=false
	 }else{
		 
	 }
 }
 /*
 function showDiv(){
 
 
 for(var k=0;k<document.waterSourceModeUses.adequateOnSite.length;k++){
 console.log("----inside in for loop-----"+document.waterSourceModeUses.adequateOnSite[k].value)
 if(document.waterSourceModeUses.adequateOnSite[k].checked){
 console.log("------fg---")
 if(document.waterSourceModeUses.adequateOnSite[k].value=="yes"){
 console.log("------fg-in yes--")
 document.getElementById('mycontainer01').style.display="block";
 
 }
 else if(document.waterSourceModeUses.adequateOnSite[k].value=="no") {
 console.log("------fg-in no--")
 document.getElementById('mycontainer01').style.display="none";
 
 }
 else{
 document.getElementById('mycontainer01').style.display="none";
 }
 }else{
 document.getElementById('mycontainer01').style.display="none";
 document.waterSourceModeUses.adequateOnSite[k].checked=false;
 }
 }
 }
 */
 
 function showDiv(){
 var v= document.getElementById('cteSelect').value
 var v1=document.getElementById('temp01').value
 var v2=document.getElementById('temp02').value
 console.log("-----v1---"+v2)
 if(v){
 if(v=="yes"){
 document.getElementById('mycontainer01').style.display="block";
 }else if(v=="no"){
 document.getElementById('mycontainer01').style.display="none";
 }else{
 document.getElementById('mycontainer01').style.display="none";
 }
 }
 if(v1){
 if(v1=="yes"){
  document.getElementById('mycontainer02').style.display="block";
 }else if(v1=="no"){
  document.getElementById('mycontainer02').style.display="none";
 }else{
  document.getElementById('mycontainer02').style.display="none";
 }
 }
 if(v2){
 if(v2=="yes"){
  document.getElementById('mycontainer03').style.display="block";
 }else if(v2=="no"){
  document.getElementById('mycontainer03').style.display="none";
 }else{
  document.getElementById('mycontainer03').style.display="none";
 }
 }
 }
 
 function cbclick(e){
   e = e || event;
   var adequateOnSite = e.srcElement || e.target;
   if (adequateOnSite.type !== 'checkbox') {return true;}
   var cbxs = document.getElementById('radiocb').getElementsByTagName('input'), i=cbxs.length;
    while(i--) {
        if (cbxs[i].type && cbxs[i].type == 'checkbox' && cbxs[i].id !== adequateOnSite.id) {
         cbxs[i].checked = false;
        }
    }
    // if the click should always result in a checked checkbox 
    // unconmment this:
    // cb.checked = true;
}
 

 function calculateForBMW(){
 console.log("------Invoking calculate---")
 	 var radiomenu
 	 var results
 	var indCatType
 	radiomenu=document.getElementById('authorisationAppliedFor').value;
 
  	var hcfTypeMenu1=document.getElementById('hcfTypeMenu').value;
  	var noofYears = document.getElementById('noOfyear').value;
  	var noofbeds=document.getElementById('noofbeds').value;
  	 if(radiomenu=="fresh") {
  		//alert("-----"+radiomenu)
  			if(hcfTypeMenu1=="Private Hospital (Bedded)" ||hcfTypeMenu1== "Govt Hospital (Bedded)" ||hcfTypeMenu1=="Bedded Any Other")
     		{   if(!noofbeds){
     			alert(" please enter no of Beds")
     		}
  				if(noofbeds<30 && noofbeds>=1){
  					if(noofYears<=8 && noofYears>=1){
  					results=2500
  					indCatType="Orange"
  					}else{
  						alert(" Not applicable for more than 8 Years ")
  					}
  				}else if(noofbeds>=30 && noofbeds<50){
  					if(noofYears<=8 && noofYears>=1){
  					results=3000
  					indCatType="Orange"
  					}else{
  						alert(" Not applicable for more than 8 Years ")
  					}
  				}else if(noofbeds>=50 && noofbeds<100 ){
  					if(noofYears<=8 && noofYears>=1){
  					results=3500
  					indCatType="Orange"
  					}else{
  						alert(" Not applicable for more than 8 Years ")
  					}
  				}else if(noofbeds>=100 && noofbeds<200){
  					if(noofYears<=5 && noofYears>=1){
  					results=4500
  					indCatType="Red"
  					}else{
  						alert(" Not applicable for more than 5 Years ")
  					}
  				} else if(noofbeds>=200 && noofbeds<500){
  					if(noofYears<=5 && noofYears>=1){
  					results=5200
  					indCatType="Red"
  					}else{
  						alert(" Not applicable for more than 5 Years ")
  					}
  				}else if(noofbeds>=500){
  					if(noofYears<=5 && noofYears>=1){
  					results=6500;
  					indCatType="Red"
  					}else{
  						alert(" Not applicable for more than 5 Years ")
  					}
  				}
     		}
  			if(hcfTypeMenu1=="Clinic (Non-Bedded)" ||hcfTypeMenu1== "Dispensary (Non-Bedded)"){
  				if(noofYears<=12 && noofYears>=1){
  				console.log("---Clinic---")
  				results=1250;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Blood Bank (Non-Bedded)"||hcfTypeMenu1=="Clinical Laboratory (Non-Bedded)"){
  				if(noofYears<=12 && noofYears>=1){
  				results=2100;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Forensic Laboratory"||hcfTypeMenu1=="Research Laboratory"){
  				if(noofYears<=12 && noofYears>=1){
  				results=2000;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Educations Institutions"||hcfTypeMenu1=="Research Institute (Non-Bedded)"){
  				if(noofYears<=12 && noofYears>=1){
  				results=1250;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Health Camps/Medical Camps/Vaccinaton/Blood Donation"){
  				if(noofYears<=12 && noofYears>=1){
  				results=850;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Veterinary Institutions"){
  				if(noofYears<=12 && noofYears>=1){
  				results=1250;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Veterinary Hospital (Non-Bedded)"||hcfTypeMenu1=="Animal House (Non-Bedded)"){
  				if(noofYears<=12 && noofYears>=1){
  				results=450;
  				indCatType="Green"
  			}
  				else{
  					alert(" Not applicable for more than 12 Years ")
  				}
 }}
       if(radiomenu=="renew"){
       	  
  			if(hcfTypeMenu1=="Private Hospital (Bedded)" || hcfTypeMenu1== "Govt Hospital (Bedded)" ||hcfTypeMenu1=="Bedded Any Other")
     		{  if(!noofbeds){
     			alert(" please enter no of Beds")
     			
     		}
  				if(noofbeds<=30 && noofbeds>=1){
  					if(noofYears<=8 && noofYears>=1){
  					results=1250
  					indCatType="Orange"
  					}else{
  						alert(" Not applicable for more than 8 Years ")
  					}
  				}else if(noofbeds>=30 && noofbeds<50){
  					if(noofYears<=8 && noofYears>=1){
  				   results=1500
  				  indCatType="Orange"
  					}else{
  						alert(" Not applicable for more than 8 Years ")
  					}
  				}else if(noofbeds>=50 && noofbeds<100){
  					if(noofYears<=8 && noofYears>=1)
  					{
  					results=1750
  					indCatType="Orange"
  					}else{
  						alert(" Not applicable for more than 8 Years ")
  					}
  				}else if(noofbeds>=100 && noofbeds<200){
  					if(noofYears<=5 && noofYears>=1){
  				    results=2250
  				   indCatType="Red"
  					}else{
  						alert(" Not applicable for more than 5 Years ")
  					}
  				}else if(noofbeds>=200 &&  noofbeds<500){
  					if(noofYears<=5 && noofYears>=1){	
  				    results=2600
  				   indCatType="Red"
  					}else{
  						alert(" Not applicable for more than 5 Years ")	
  					}
  				}
  				else if(noofbeds>=500){
  					if(noofYears<=5 && noofYears>=1){
  				   results=3200;
  				  indCatType="Red"
  					}else{
  						alert(" Not applicable for more than 5 Years ")
  					}
  				}
     		}
  			if(hcfTypeMenu1=="Clinic (Non-Bedded)" ||hcfTypeMenu1== "Dispensary (Non-Bedded)"){
  				if(noofYears<=12 && noofYears>=1){
  			  results=625;
  			 indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Blood Bank (Non-Bedded)"||hcfTypeMenu1=="Clinical Laboratory (Non-Bedded)"){
  				if(noofYears<=12 && noofYears>=1){
  				results=1050;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=='Forensic Laboratory'||hcfTypeMenu1=='Research Laboratory'){
  				if(noofYears<=12 && noofYears>=1){
  				results=1000;
  				indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=='Educations Institutions'||hcfTypeMenu1=='Research Institute (Non-Bedded)'){
  				if(noofYears<=12 && noofYears>=1){	
  			results=625;
  			indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=='Health Camps/Medical Camps/Vaccinaton/Blood Donation'){
  				if(noofYears<=12 && noofYears>=1){
  			  results=425;
  			 indCatType="Green"
  				}else{
  					alert(" Not applicable for more than 12 Years ")
  				}
  			}
  			if(hcfTypeMenu1=="Veterinary Institutions"){
  				if(noofYears<=12 && noofYears>=1)
  				{
  				results=625;
  				indCatType="Green"
  			}else{
  				alert(" Not applicable for more than 12 Years ")
  			}
  				}
  			if(hcfTypeMenu1=='Veterinary Hospital (Non-Bedded)'||hcfTypeMenu1=='Animal House (Non-Bedded)'){
  				if(noofYears<=12 && noofYears>=1)
  				{
  				results=225;
  				indCatType="Green"
  			}else{alert(" Not applicable for more than 12 Years ")
  				}
  			}

       }
       var feeApp = document.getElementsByName('feeApplicable');
 	   		//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
 	   		
 	   			if( feeApp != null){
 	   				
 	   				feeApp[0].value=results*noofYears;
 	   				
 	   				//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
 	   			}
 	return true;
       

 } 
 
 </script>  
						
				

</body>