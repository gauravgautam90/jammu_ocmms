
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
<g:form name="waterSourceModeUses" method="post" action="saveBMWInspectionReport" >
<table width="70%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<% 
				def inspReport = WasteManagementFile.find("from WasteManagementFile afd where afd.applicationId=? and afd.typeOfFile='Inspection Report BMW'",[insData.id.toLong()])
				
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
						<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name & Address of the Health Care Facilities (HCFs)<span style="color:red">*</span>: </td>
						
						<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
						<input type="checkbox" name="hcfBmwType" id="hcfBmwType" value="Govt" <g:if test="${inspectionData?.hcfBmwType.matches('(.*)Govt(.*)')}">checked</g:if>/>
						Govt &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="hcfBmwType" id="hcfBmwType" value="Private" <g:if test="${inspectionData?.hcfBmwType.matches('(.*)Private(.*)')}">checked</g:if>/>
						Private &nbsp; <input type="checkbox" name="hcfBmwType" id="hcfBmwType" value="Trust" <g:if test="${inspectionData?.hcfBmwType.matches('(.*)Trust(.*)')}">checked</g:if> />
						Trust
					<table width="100%">
					<tr>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
						  ${insData.industryRegMasterObj?.indName}<input type="hidden" name="indName" value="${insData.industryRegMasterObj?.indName}"/><input type="hidden" name="hcfName" value="${insData.nameOfInstitution}"/>
						</td>
					</tr>
						<tr>
						<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
							  ${insData.industryRegMasterObj?.indAddress}<input type="hidden" name="indAddress" value="${insData.industryRegMasterObj?.indAddress}"/>
							</td>
						</tr>
					</table>
					</td>
					</tr>     
							
					
					
					
					
					
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Correspondence address i.e. Contact Person & Telephone No.</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 Address: ${insData.industryRegMasterObj?.occAddress}, Contact Person: ${insData.industryRegMasterObj?.occName},Phone No:${insData.industryRegMasterObj?.occPhoneNo}
					 <input type="hidden" name="correspondenceAddress" value="${insData.industryRegMasterObj?.occAddress}"/><input type="hidden" name="occName" value="${insData.industryRegMasterObj?.occName}"/><input type="hidden" name="occPhone" value="${insData.industryRegMasterObj?.occPhoneNo}"/>
					</td>
					
				</tr>     
				
				<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date, Month & Year of Establishment of HCF</td>
				<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				${insData.industryRegMasterObj?.commMonth} /${insData.industryRegMasterObj?.dateOfComm}<input type="hidden" name="monthofEstablishment" value="${insData.industryRegMasterObj?.commMonth}"/><input type="hidden" name="yearOfEstablishment" value="${insData.industryRegMasterObj?.dateOfComm}"/>
				</td>
				
			</tr>   
				
			<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total no. of beds and average occupancy </td>
			<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
			<font size="2"  color="red"> Beds</font>: <input type="text" size="10" class="txt4" id="noofbeds" name="noOfBeds" value="${fieldValue(bean:insData,field:'noofbeds')}"/>
			&nbsp;  <font size="2" color="red"> Occupancy</font>: <input type="text" size="10" class="txt4" id="avgOccupancy" name="avgOccupancy" value="${fieldValue(bean:insData,field:'noOfInOutPatients')}"/>
			</td>
		</tr>   
				
				
		
		<tr>
		<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent under Water Act, 1974 & Air Act, 1981</td>
		<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Consent Status:
		${insData?.statusCteCto}
		<table width="100%">
		<tr>
		<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
		<input type="checkbox" name="consentunderwateract" id="consentunderwateract" value="Applied" <g:if test="${inspectionData?.consentunderwateract.matches('(.*)Applied(.*)')}">checked</g:if>/>
			Applied &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="consentunderwateract" id="consentunderwateract" value="Possess Valid Consent" <g:if test="${inspectionData?.consentunderwateract.matches('(.*)Possess Valid Consent(.*)')}">checked</g:if>/>
			Possess Valid Consent  
			</td>
		</tr>
		<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
		<input type="checkbox" name="consentunderwateract" id="consentunderwateract" value="Not renewed"/>
		Not renewed &nbsp; <input type="checkbox" name="consentunderwateract" id="consentunderwateract" value="Not applicable" <g:if test="${inspectionData?.consentunderwateract.matches('(.*)Not applicable(.*)')}">checked</g:if>/>
		Not applicable 
		</td>
		</table>
		</td>
	</tr>   
				
				
	<tr>
	<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Authorization under Bio-medical Waste Management Rules, 2016</td>
	<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	
	<table width="100%">
	<tr>
	<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	<input type="checkbox" name="authunderbiomed" id="authunderbiomed" value="Applied"  <g:if test="${inspectionData?.authunderbiomed.matches('(.*)Applied(.*)')}">checked</g:if>/>
	Applied &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="authunderbiomed" id="authunderbiomed" value="Not Applied" <g:if test="${inspectionData?.authunderbiomed.matches('(.*)Not Applied(.*)')}">checked</g:if> />
	Not Applied                                
		</td>
	</tr>
	<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
	<input type="checkbox" name="authunderbiomed" id="authunderbiomed" value="Valid Authorization"  <g:if test="${inspectionData?.authunderbiomed.matches('(.*)Valid Authorization(.*)')}">checked</g:if>/>
	Valid Authorization  &nbsp; <input type="checkbox" name="authunderbiomed" id="authunderbiomed" value="Not Renewed" <g:if test="${inspectionData?.authunderbiomed.matches('(.*)Not Renewed(.*)')}">checked</g:if>/>
	Not Renewed 
	</td>
	</table>
	</td>
</tr>   
			<% 
		 def ConsentFeeMasterBMW=ConsentFeeMasterBMW.findByApplication(insData)
		  def noOfYear=ConsentFeeMasterBMW.noOfYears;
		  def calFee=ConsentFeeMasterBMW.calculatedFee.toString();
		%>
<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Period Applied for (validity upto)  </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${noOfYear} year
</td>
</tr>  			
<tr>
<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Type of Authorization  </td>

</tr> 	

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Authorization Sought for</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
${insData?.activityAuthorizationSoughtFor} <input type="hidden" name="authorizationSought"  id="authorizationSought" value='${insData?.activityAuthorizationSoughtFor}'/>
</td>
</tr>  
<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Bedded/Non Bedded</td>

<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
${insData?.hcfType} / ${insData?.hcfTypeMenu} <input type="hidden" name="hcfTypeMenu"  id="hcfTypeMenu" value='${insData?.hcfTypeMenu}'/><input type="hidden" name="hcfType"  id="hcfType" value='${insData?.hcfType}'/>
</td>
</tr> 
		
<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Bedded/Non Bedded Fee Calculator </td>

<td  align="left" bgcolor="#E8F6F9"  class="headngblue">No of Year

<input name="noOfyear" id="noOfyear" type="text" class="txt4" size="10" value='${noOfYear}' />

<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value='${calFee}' />
<a href="javascript:{}" onclick="return calculateForBMW();"  class="bulletinside"><b>Calculate</b></a>
&nbsp;<span class="sidetxt">(Click to calculate fee for new industry)</span></span>
</td>
</tr> 

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Establish / Operate </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
${insData?.statusCteCto}<input type="hidden" name="ctectoStatus" id="ctectoStatus"  value='${insData?.statusCteCto}'/>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fresh/Renewal </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
${insData?.authorisationAppliedFor}<input type="hidden" name="authorizationFor" id="authorisationAppliedFor"  value='${insData?.authorisationAppliedFor}'/>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Annual Report submitted for the preceding year </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="annualReport" id="annualReport" value="Submitted" <g:if test="${inspectionData?.annualReport.matches('(.*)Submitted(.*)')}">checked</g:if>/>
Submitted(Copy Attached) &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	</td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="annualReport" id="annualReport" value="Not submitted" <g:if test="${inspectionData?.annualReport.matches('(.*)Not submitted(.*)')}">checked</g:if>/>
Not submitted&nbsp;
</td>
</table>
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Staff involvement in BMW Management(no. of persons)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="noOfPersoninBmw" id="noOfPersoninBmw" value="Separate BMW Cell exist" <g:if test="${inspectionData?.noOfPersoninBmw.matches('(.*)Separate BMW Cell exist(.*)')}">checked</g:if>/>
Separate BMW Cell exist &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	</td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="noOfPersoninBmw" id="noOfPersoninBmw" value="No identified cell or person" <g:if test="${inspectionData?.noOfPersoninBmw.matches('(.*)No identified cell or person(.*)')}">checked</g:if>/>
No identified cell or person&nbsp;
</td>
</table>
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Sources of Biomedical Waste Generation ( indicate ward details)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<textarea rows="2" cols="50"
	name="sourceBioWasteGen"  maxlength="250"
		class="txt4" size="25"
		/>${(inspectionData.sourceBioWasteGen)}
		</textarea>
</td>
</tr>
<%
def yellow=""
def blue=""
def white=""
def red=""
System.out.println("----wasteGenQuantityYellow---"+inspectionData.wasteGenQuantity)
String CSV=inspectionData.wasteGenQuantity;
System.out.println(CSV);
String[] values = CSV.split("\\s*,\\s*");
System.out.println("--------"+values.toString());
for(int i=0;i<values.size();i++){
String str=values[i]
String[] arrOfStr = str.split("-", 2);
System.out.println("-arrOfStr---"+arrOfStr.toString()) 

if("YELLOW".equals(arrOfStr[0])){
yellow=arrOfStr[1];
System.out.println("-yellow---"+yellow) 
}else if("BLUE".equals(arrOfStr[0])){
blue=arrOfStr[1];
System.out.println("-blue---"+blue) 
}else if("RED".equals(arrOfStr[0])){
red=arrOfStr[1];
System.out.println("-green---"+green) 
}else if("WHITE".equals(arrOfStr[0])){
white=arrOfStr[1];
System.out.println("-arrOfStr---"+arrOfStr) 
}


//boolean matches = Pattern.matches(pattern, text)

}
%>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Categories of  bio-medical waste generation and its quantity</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%" border="1%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Waste Categories generated</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Total Quantity generated kg per month</td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">Yellow</td>
<td><input type="text" class="txt4" id="wasteGenQuantity" name="wasteGenQuantityYellow" value="${yellow}"/></td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">Red</td>
<td><input type="text" class="txt4" id="wasteGenQuantity" name="wasteGenQuantityRed" value="${red}"/></td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">Blue</td>
<td><input type="text" class="txt4" id="wasteGenQuantity" name="wasteGenQuantityBlue" value="${blue}"/></td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">White</td>
<td><input type="text" class="txt4" id="wasteGenQuantity" name="wasteGenQuantityWhite"  value="${white}"/></td>
</tr>

</table>
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are specified color coding bins /containers and bags followed at source of generation of waste</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="colorCodingBins" id="colorCodingBins" value="yes" <g:if test="${inspectionData?.colorCodingBins.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="colorCodingBins" id="colorCodingBins" value="no" <g:if test="${inspectionData?.colorCodingBins.matches('(.*)no(.*)')}">checked</g:if>/>
No                               
	</td>
</tr>

</table>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are  water proof bio-hazard labels pasted on bins or containers used for segregation of bio-medical waste?</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="waterProofLabels" id="waterProofLabels" value="yes" <g:if test="${inspectionData?.waterProofLabels.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="waterProofLabels" id="waterProofLabels" value="no" <g:if test="${inspectionData?.waterProofLabels.matches('(.*)no(.*)')}">checked</g:if> />
No                               
	</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are posters regarding segregation of waste provided in wards?</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="postersSegregation" id="postersSegregation" value="yes" <g:if test="${inspectionData?.postersSegregation.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="postersSegregation" id="postersSegregation" value="no" <g:if test="${inspectionData?.postersSegregation.matches('(.*)no(.*)')}">checked</g:if>/>
No                               
	</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mode of intra-rural transportation of wastes within HCF and for transportation of waste from wards to the temporary waste storage area</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="intraRuralTrans" id="intraRuralTrans" value="Closed Trolley/Pull Cart with bio-hazard symbol"  <g:if test="${inspectionData?.intraRuralTrans.matches('(.*)Closed Trolley/Pull Cart with bio-hazard symbol(.*)')}">checked</g:if>/>
Closed Trolley/Pull Cart with bio-hazard symbol &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	</td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="intraRuralTrans" id="intraRuralTrans" value="notclosedTrolley"  <g:if test="${inspectionData?.intraRuralTrans.matches('(.*)notclosedTrolley(.*)')}">checked</g:if>/>
No Closed Trolley/Pull cart &nbsp;
</td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="intraRuralTrans" id="intraRuralTrans" value="others" <g:if test="${inspectionData?.intraRuralTrans.matches('(.*)others(.*)')}">checked</g:if>/>
Others like&nbsp;
</td>
</tr>
</table>

</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Waste Storage area</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Away from the HCF    :
<input type="checkbox" name="awayHCF" id="awayHCF" value="yes" <g:if test="${inspectionData?.awayHCF.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="awayHCF" id="awayHCF" value="no"  <g:if test="${inspectionData?.awayHCF.matches('(.*)no(.*)')}">checked</g:if>/>
No
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Within the HCF    :
<input type="checkbox" name="withinHCF" id="withinHCF" value="yes"  <g:if test="${inspectionData?.withinHCF.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="withinHCF" id="withinHCF" value="no" onclick="checkonButton()" <g:if test="${inspectionData?.withinHCF.matches('(.*)no(.*)')}">checked</g:if>/>
No
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Provided with lighting and ventilation   :
<input type="checkbox" name="lightingAndVentilation" id="lightingAndVentilation" value="yes" <g:if test="${inspectionData?.lightingAndVentilation.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="lightingAndVentilation" id="lightingAndVentilation" value="no" <g:if test="${inspectionData?.lightingAndVentilation.matches('(.*)no(.*)')}">checked</g:if>/>
No
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Leachate and wash water from waste storage area connected to ETP provided      :
<input type="checkbox" name="leachateProvided" id="leachateProvided" value="yes"  <g:if test="${inspectionData?.leachateProvided.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="leachateProvided" id="leachateProvided" value="no"  <g:if test="${inspectionData?.leachateProvided.matches('(.*)yes(.*)')}">checked</g:if>/>
No
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Access is restricted       :
<input type="checkbox" name="accessRestricted" id="accessRestricted" value="yes" <g:if test="${inspectionData?.accessRestricted.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="accessRestricted" id="accessRestricted" value="no" <g:if test="${inspectionData?.accessRestricted.matches('(.*)no(.*)')}">checked</g:if>/>
No
	</td>
</tr>
</table>
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mode of disposal of BMW generated</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="modeofDisposal" id="modeofDisposal" value="CBMWTF" <g:if test="${inspectionData?.modeofDisposal.matches('(.*)CBMWTF(.*)')}">checked</g:if>/>
CBMWTF &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="modeofDisposal" id="modeofDisposal" value="DeepBurial" <g:if test="${inspectionData?.modeofDisposal.matches('(.*)DeepBurial Pit(.*)')}">checked</g:if>/>
Deep Burial 
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="modeofDisposal" id="modeofDisposal" value="Encapsulation Pit" <g:if test="${inspectionData?.modeofDisposal.matches('(.*)Encapsulation Pit(.*)')}">checked</g:if>/>
Encapsulation Pit&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="checkbox" name="modeofDisposal" id="modeofDisposal" value="Other" <g:if test="${inspectionData?.modeofDisposal.matches('(.*)Other(.*)')}">checked</g:if>/>
Others, Specify
	</td>
</tr>
</table>
</td>
</tr>


<tr>
<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Infrastructure for on-site treatment /disposal through CBMWTF</td>

</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is Bio-medical waste treated  by on-site or through a Common Bio-medical Waste Treatment Facility (CBMWTF)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">On-site :
<input type="checkbox" name="onSite" id="onSite" value="yes" <g:if test="${inspectionData?.onSite.matches('(.*)yes(.*)')}">checked</g:if> />
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="onSite" id="onSite" value="no" <g:if test="${inspectionData?.onSite.matches('(.*)no(.*)')}">checked</g:if> />
No                               
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Through CBWTF  :
<input type="checkbox" name="throughCBWTF" id="throughCBWTF" value="yes" value="no" <g:if test="${inspectionData?.throughCBWTF.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="throughCBWTF" id="throughCBWTF"  value="no" <g:if test="${inspectionData?.throughCBWTF.matches('(.*)no(.*)')}">checked</g:if>/>
No                               
	</td>
</tr>
</table>
</td>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Adequate On-site Treatment rooms provided (If applicable)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<select id="cteSelect" name="adequateOnSite" onchange="showDiv()">
<option value="no">No</option>
<option value="yes">Yes</option>
</select>                              
<div id="mycontainer01" style="display:none">	
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">If,Yes :
<input type="checkbox" name="adequateOnSite" id="adequateOnSite" value="Satisfactory"  <g:if test="${inspectionData?.adequateOnSite.matches('(.*)Satisfactory(.*)')}">checked</g:if>/>
Satisfactory &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="adequateOnSite" id="adequateOnSite" value="Not Satisfactory" <g:if test="${inspectionData?.adequateOnSite.matches('(.*)Not Satisfactory(.*)')}">checked</g:if> />
Not Satisfactory                               
	</td>
</tr>

</table>
</div>
</td>

</tr>



<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Untreated waste storage room provided</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
                            
<select id="temp01" name="untreatedWaste" onchange="showDiv()">
<option value="no">No</option>
<option value="yes">Yes</option>
</select>
<div id="mycontainer02" style="display:none">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">If,Yes :
<input type="checkbox" name="untreatedWaste" id="untreatedWaste" value="Satisfactory"  <g:if test="${inspectionData?.untreatedWaste.matches('(.*)Satisfactory(.*)')}">checked</g:if>/>
Satisfactory &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="untreatedWaste" id="untreatedWaste" value="Not Satisfactory" <g:if test="${inspectionData?.untreatedWaste.matches('(.*)Not Satisfactory(.*)')}">checked</g:if>/>
Not Satisfactory                              
</td>
</tr>

</table>
</div>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Treated waste storage room provided</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="treatedWaste" id="treatedWaste" value="yes" <g:if test="${inspectionData?.treatedWaste.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="treatedWaste" id="treatedWaste" value="no" <g:if test="${inspectionData?.treatedWaste.matches('(.*)no(.*)')}">checked</g:if> />
No
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Is Washing room /platform for waste containers,trolleys or vehicles provided</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="trolleysProvided" id="trolleysProvided" value="yes" <g:if test="${inspectionData?.trolleysProvided.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="trolleysProvided" id="trolleysProvided"  value="no" <g:if test="${inspectionData?.trolleysProvided.matches('(.*)no(.*)')}">checked</g:if>/>
No
</td>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Effluent Treatment Plant provided</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="plantProvided" id="plantProvided" value="yes" <g:if test="${inspectionData?.plantProvided.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	&nbsp;	&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="plantProvided" id="plantProvided" value="no" <g:if test="${inspectionData?.plantProvided.matches('(.*)no(.*)')}">checked</g:if>/>
No
</td>
</tr>



<tr>
<td  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">IV.On-site Treatment of Bio-medical Waste by HCF : (If applicable)</td>

</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total quantity of bio-medical waste treated within HCF (in kg  per day)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%" border="1">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Type of treatment</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Pl. tick whichever is applicable</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Quantity of waste treated in kg/day</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Incineration</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied"/></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="incinerationQuant" id="incinerationQuant" value="${inspectionData?.incinerationQuant}"/></td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Autoclaving</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied"/></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="autoclavingQuant" id="autoclavingQuant" value="${inspectionData?.autoclavingQuant}"/></td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Shredding</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied"/></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="shreddingQuant" id="shreddingQuant" value="${inspectionData?.shreddingQuant}"/></td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Chemical disinfection</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied"/></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="chemicaldisQuant" id="chemicaldisQuant" value="${inspectionData?.chemicaldisQuant}"/></td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">DeepBurial</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied"/></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="deepBurialQuant" id="deepBurialQuant" value="${inspectionData?.deepBurialQuant}"/></td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Sharp pit</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied"/></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="sharpPit" id="sharpPit" value="${inspectionData?.sharpPit}"/></td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Any other  mode of treatment/NDU</td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentApplied" id="consentApplied" /></td>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="text" name="othermodeTreatment" id="othermodeTreatment" value="${inspectionData?.othermodeTreatment}"/></td>
</tr>


</table>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">2.On-site Treatment  Provision By  Autoclaving/Microwaving and shredder(if applicable)</td>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity of autoclave/microwave</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<input type="text" name="capacityofAutoclave" id="capacityofAutoclave" value="${inspectionData?.capacityofAutoclave}"/>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Capacity of shredder </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<input type="text" name="capacityofShredder" id="capacityofShredder" value="${inspectionData?.capacityofShredder}" />
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Operating conditions of autoclave as observed during the visit</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="conditionsofAutoclave" id="conditionsofAutoclave" value="Temperature" <g:if test="${inspectionData?.conditionsofAutoclave.matches('(.*)Temperature(.*)')}">checked</g:if>/>
Temperature &nbsp;	<input type="checkbox" name="conditionsofAutoclave" id="conditionsofAutoclave" value="Duration" <g:if test="${inspectionData?.conditionsofAutoclave.matches('(.*)Duration(.*)')}">checked</g:if>/>
Duration                               
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="conditionsofAutoclave" id="conditionsofAutoclave" value="Pressure" <g:if test="${inspectionData?.conditionsofAutoclave.matches('(.*)Pressure(.*)')}">checked</g:if>/>
Pressure                           
	</td>
</tr>
</table>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Provision made for the autoclave </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Trolley for waste feeding :
<input type="checkbox" name="trolleywastefeeding" id="trolleywastefeeding" value="yes" <g:if test="${inspectionData?.trolleywastefeeding.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	<input type="checkbox" name="trolleywastefeeding" id="trolleywastefeeding"  value="no" <g:if test="${inspectionData?.trolleywastefeeding.matches('(.*)no(.*)')}">checked</g:if>/>
No                               
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Graphic or computer recording device attached :
<input type="checkbox" name="recordingDeviceAttached" id="recordingDeviceAttached" value="yes" <g:if test="${inspectionData?.recordingDeviceAttached.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="recordingDeviceAttached" id="recordingDeviceAttached" value="no" <g:if test="${inspectionData?.recordingDeviceAttached.matches('(.*)no(.*)')}">checked</g:if>/>
No                          
	</td>
</tr>
</table>
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Strip test / Spore test conducted regularly </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="stripsporeTest" id="stripsporeTest" value="yes" <g:if test="${inspectionData?.stripsporeTest.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="stripsporeTest" id="stripsporeTest" value="no" <g:if test="${inspectionData?.stripsporeTest.matches('(.*)no(.*)')}">checked</g:if>/>
No   
</td>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Performance of autoclaving by spore testing or routine test </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="performanceofAutoclaving" id="performanceofAutoclaving" value="satisfactory"  <g:if test="${inspectionData?.performanceofAutoclaving.matches('(.*)satisfactory(.*)')}">checked</g:if>/>
Satisfactory &nbsp;  <input type="checkbox" name="performanceofAutoclaving" id="performanceofAutoclaving" value="Not Satisfactory " <g:if test="${inspectionData?.performanceofAutoclaving.matches('(.*)Not Satisfactory(.*)')}">checked</g:if> />
Not satisfactory 
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Working of  shredder</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="workingofshredder" id="workingofshredder" value="satisfactory" <g:if test="${inspectionData?.workingofshredder.matches('(.*)satisfactory(.*)')}">checked</g:if>/>
Satisfactory &nbsp;  <input type="checkbox" name="workingofshredder" id="workingofshredder"  value="Not satisfactory" <g:if test="${inspectionData?.workingofshredder.matches('(.*)Not satisfactory(.*)')}">checked</g:if>/>
Not satisfactory 
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">On-site Wastewater Treatment:</td>

</tr>



<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Quantity of Water Consumption  </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="text" name="quantityofWater" id="quantityofWater" size="10%" value="${inspectionData.quantityofWater}"/> KL/Day
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Quantity of Waste water generation </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="text" name="quantityofWastewater" id="quantityofWastewater" size="10%" value="${inspectionData.quantityofWastewater}"/> KL/Day
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Dedicated vehicle and container washing facility  available</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Vehicle washing platform:
<input type="checkbox" name="vehicleWashing" id="vehicleWashing" value="yes"  <g:if test="${inspectionData?.vehicleWashing.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	<input type="checkbox" name="vehicleWashing" id="vehicleWashing" value="no"  <g:if test="${inspectionData?.vehicleWashing.matches('(.*)no(.*)')}">checked</g:if>/>
No                               
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Container washing facility :
<input type="checkbox" name="containerWashing" id="containerWashing" value="yes"  <g:if test="${inspectionData?.containerWashing.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="containerWashing" id="containerWashing" value="no"  <g:if test="${inspectionData?.containerWashing.matches('(.*)no(.*)')}">checked</g:if>/>
No                          
	</td>
</tr>
</table>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Effluent Treatment Plant provided for treatment of wastewater (enclose flow chart of ETP)(or) </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="effluentTreatmentPlant" id="effluentTreatmentPlant" value="yes"  <g:if test="${inspectionData?.effluentTreatmentPlant.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="effluentTreatmentPlant" id="effluentTreatmentPlant" value="no"  <g:if test="${inspectionData?.effluentTreatmentPlant.matches('(.*)no(.*)')}">checked</g:if>/>
No  
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Any other provision (Neutralization)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•SMR conducted</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Copy submitted 
<input type="checkbox" name="smrConducted" id="smrConducted" value="yes" <g:if test="${inspectionData?.smrConducted.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="smrConducted" id="smrConducted" value="no" <g:if test="${inspectionData?.smrConducted.matches('(.*)no(.*)')}">checked</g:if>/>
No
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Final mode of disposal of treated wastewater</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<table width="100%">
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Reused or recycled :
<input type="checkbox" name="reusedorRecycled" id="reusedorRecycled" value="yes" <g:if test="${inspectionData?.reusedorRecycled.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;	<input type="checkbox" name="reusedorRecycled" id="reusedorRecycled" value="no" <g:if test="${inspectionData?.reusedorRecycled.matches('(.*)no(.*)')}">checked</g:if>/>
No                               
	</td>
</tr>
<tr>
<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Discharge through drain:
<input type="checkbox" name="dischargethroughdrain" id="dischargethroughdrain" value="yes"  <g:if test="${inspectionData?.dischargethroughdrain.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="dischargethroughdrain" id="dischargethroughdrain" value="no" <g:if test="${inspectionData?.dischargethroughdrain.matches('(.*)no(.*)')}">checked</g:if>/>
No                          
	</td>
</tr>
</table>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Is ETP sludge collection, storage & drying provision provided</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="etpSludge" id="etpSludge" value="yes" <g:if test="${inspectionData?.etpSludge.matches('(.*)yes(.*)')}">checked</g:if>/>
Yes &nbsp;  <input type="checkbox" name="etpSludge" id="etpSludge" value="no" <g:if test="${inspectionData?.etpSludge.matches('(.*)no(.*)')}">checked</g:if>/>
No  
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Type of wastes generated and its final mode of disposal  :</td>

</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Plastic wastes after treatment (if applicable)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<input type="text" name="plasticTreatment" id="plasticTreatment" value="${inspectionData.plasticTreatment}"/>
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Treated waste sharps/glass waste</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="treatedWasteSharps" id="treatedWasteSharps" value="Satisfactory" <g:if test="${inspectionData?.treatedWasteSharps.matches('(.*)Satisfactory(.*)')}">checked</g:if>/>
Satisfactory &nbsp;  <input type="checkbox" name="treatedWasteSharps" id="treatedWasteSharps" value="Not Satisfactory" <g:if test="${inspectionData?.treatedWasteSharps.matches('(.*)Not Satisfactory(.*)')}">checked</g:if>/>
Not Satisfactory
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Mercury waste disposal</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="mercurywastedisposal" id="mercurywastedisposal" value="Satisfactory"/>
Satisfactory &nbsp;  <input type="checkbox" name="mercurywastedisposal" id="mercurywastedisposal"  value="Not Satisfactory" <g:if test="${inspectionData?.mercurywastedisposal.matches('(.*)Not Satisfactory(.*)')}">checked</g:if>/>
Not Satisfactory &nbsp;  <input type="checkbox" name="mercurywastedisposal" id="mercurywastedisposal" value="Not Applicable" <g:if test="${inspectionData?.mercurywastedisposal.matches('(.*)Not Applicable(.*)')}">checked</g:if>/>
Not Applicable
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Outdated cytotoxic drugs</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="outdatedCytotoxicDrugs" id="outdatedCytotoxicDrugs" value="Applicable" <g:if test="${inspectionData?.outdatedCytotoxicDrugs.matches('(.*)Applicable(.*)')}">checked</g:if>/>
Applicable   &nbsp;  <input type="checkbox" name="outdatedCytotoxicDrugs" id="outdatedCytotoxicDrugs" value="Not applicable" <g:if test="${inspectionData?.outdatedCytotoxicDrugs.matches('(.*)Not applicable(.*)')}">checked</g:if> />
Not applicable&nbsp;
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Hypo-solution generated from X-ray ward</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Mode of disposal to Reg. Recycler:
<input type="text" name="hyposolutiongenerated" id="hyposolutiongenerated"  value="${inspectionData?.hyposolutiongenerated}"/>
<table width="100%">
<tr>
<td align="left" bgcolor="#E8F6F9"  class="headngblue">Not applicable:<input type="checkbox" name="hyposolutiongenerated" id="hyposolutiongenerated" value="no"  <g:if test="${inspectionData?.hyposolutiongenerated.matches('(.*)no(.*)')}">checked</g:if>/>No
</td>

</tr>

</table
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Check for the following</td>

</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Segregation of waste practiced in accordance with BMWM Rules at the source of generation</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="segregationofwaste" id="segregationofwaste" value="Yes" <g:if test="${inspectionData?.segregationofwaste.matches('(.*)Yes(.*)')}">checked</g:if>/>
Yes   &nbsp;  <input type="checkbox" name="segregationofwaste" id="segregationofwaste" value="No" <g:if test="${inspectionData?.segregationofwaste.matches('(.*)No(.*)')}">checked</g:if>/>
No&nbsp;
</td>
</tr>


<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Whether a record of waste generation as well as the person who collects BMW from wards maintains a register?</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">

<select id="temp02" name="wardsmaintains"  <g:if test="${inspectionData?.wardsmaintains.matches('(.*)Yes(.*)')}">checked</g:if> onchange="showDiv()">
<option value="no">No</option>
<option value="yes">Yes</option>
</select>
<div id="mycontainer03" style="display:none">
<table witdh="100%">
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="wardsmaintains" id="wardsmaintains" value="Satisfactory" <g:if test="${inspectionData?.wardsmaintains.matches('(.*)Satisfactory(.*)')}">checked</g:if>/>
Satisfactory &nbsp;  <input type="checkbox" name="wardsmaintains" id="wardsmaintains" value="Not Satisfactory" <g:if test="${inspectionData?.wardsmaintains.matches('(.*)Not Satisfactory(.*)')}">checked</g:if>/>
Not Satisfactory
</td>
</tr>
</table>
</div>
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Does the CBMWTF operator collect waste daily or alternate day and whether the criterion of 48 hours is complied?(if applicable)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="CBMWTFoperator" id="CBMWTFoperator" value="Yes" <g:if test="${inspectionData?.CBMWTFoperator.matches('(.*)Yes(.*)')}">checked</g:if>/>
Yes   &nbsp;  <input type="checkbox" name="CBMWTFoperator" id="CBMWTFoperator" value="No" <g:if test="${inspectionData?.CBMWTFoperator.matches('(.*)No(.*)')}">checked</g:if>/>
No&nbsp;
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Fire safety measures adopted</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="firesafetymeasures" id="firesafetymeasures" value="Yes" <g:if test="${inspectionData?.firesafetymeasures.matches('(.*)Yes(.*)')}">checked</g:if>/>
Yes   &nbsp;  <input type="checkbox" name="firesafetymeasures" id="firesafetymeasures" value="No" <g:if test="${inspectionData?.firesafetymeasures.matches('(.*)No(.*)')}">checked</g:if>/>
No&nbsp;
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Log book for operation of the treatment equipment/s is maintained as per BMW Rules? ( if applicable)</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="logbookOperation" id="logbookOperation" value="Yes" <g:if test="${inspectionData?.logbookOperation.matches('(.*)Yes(.*)')}">checked</g:if>/>
Yes   &nbsp;  <input type="checkbox" name="logbookOperation" id="logbookOperation" value="No" <g:if test="${inspectionData?.logbookOperation.matches('(.*)No(.*)')}">checked</g:if>/>
No&nbsp;
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•Whether awareness programmes conducted for the hospital staff/doctors w.r.t BMWM Rules?</td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="awarenessprogrammes" id="awarenessprogrammes" value="Yes" <g:if test="${inspectionData?.awarenessprogrammes.matches('(.*)Yes(.*)')}">checked</g:if>/>
Yes   &nbsp;  <input type="checkbox" name="awarenessprogrammes" id="awarenessprogrammes" value="No" <g:if test="${inspectionData?.awarenessprogrammes.matches('(.*)No(.*)')}">checked</g:if>/>
No&nbsp;
</td>
</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">•	Overall status of waste segregation, storage, treatment and its disposal </td>
<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
<table witdh="100%">
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="statusWaste" id="statusWaste" value="Excellent" <g:if test="${inspectionData?.statusWaste.matches('(.*)Excellent(.*)')}">checked</g:if>/>
Excellent  &nbsp;  <input type="checkbox" name="statusWaste" id="statusWaste" value="Very Good" <g:if test="${inspectionData?.statusWaste.matches('(.*)Very Good(.*)')}">checked</g:if>/>
Very Good&nbsp;
</td>
</tr>
<tr><td align="left" bgcolor="#E8F6F9"  class="headngblue">
<input type="checkbox" name="statusWaste" id="statusWaste" value="Good" <g:if test="${inspectionData?.statusWaste.matches('(.*)Good(.*)')}">checked</g:if>/>
Good  &nbsp;  <input type="checkbox" name="statusWaste" id="statusWaste" value="Not Satisfactory" <g:if test="${inspectionData?.statusWaste.matches('(.*)Not Satisfactory(.*)')}">checked</g:if>/>
Not Satisfactory&nbsp;
</td>
</tr>
</table>
</td>
</tr>
  </table>
  <br>
  <br>
  <table width="100%">
  <tr><td align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Inspection Officer Recommendation</td>
  <td  align="center" bgcolor="#E8F6F9"  class="headngblue"><textarea rows="4" cols="50"
		name="officerRecom"  maxlength="250"
			class="txt4" size="25"
			/>${inspectionData?.officerRecom}
			</textarea>
  </td>
  
  </tr>
  <tr>
		<td align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of Consent Fee Paid </td>
		<td   align="center" bgcolor="#E8F6F9"  class="headngblue">
			<table width="50%">
			 <tr>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popFeesfromOfficerAdd/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Add </a></td>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popFeesfromOfficerView/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');"> View </a></td>
				<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/popFeesfromOfficerEdit/<%=insData.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=200,scrollbars=1,resizable=yes');" > Delete </a></td>
			  </tr>
  </table>
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