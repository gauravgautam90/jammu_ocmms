<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>
<calendar:resources lang="en" theme="aqua"/>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>


<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
a:link {
	text-decoration: none;
	color: #1E6BBD;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>


<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
function changeOtherCheckBox(){

if(document.getElementById('checkboxGeneration').checked==true){
document.getElementById('checkboxCollection').checked=true;
document.getElementById('checkboxReception').checked=true;
document.getElementById('checkboxStorage').checked=true;
}
}
function enablingDisabling()
{
var a= document.getElementById("radiobuttonfresh").value;
if(a=="FreshApplication")
	{
	document.getElementById("prevauthNo").disabled = false;
	document.getElementById("prevauthDate").disabled = false;
	}
}

function enablingDisablingAgain()
{

document.getElementById('auth').style.display = 'none';
document.getElementById('auth1').style.display = 'none';
document.getElementById('auth2').style.display = 'none';
document.getElementById('prevauthNo').disabled = true;

}


function enablingDisablingAgainRenew()
{

document.getElementById('auth').style.display = 'block';
document.getElementById('auth1').style.display = 'block';
document.getElementById('auth2').style.display = 'block';
document.getElementById('prevauthNo').disabled = false;

}


function Calculate()
{	
	//alert("inside calculate");
	
	var indTyp;
	
		indTyp=document.getElementById('catVale').value;
	//alert(indTyp)
	var capitalInvestMent=document.getElementById('noOfBeds').value;
	//alert(capitalInvestMent)
	
	var result;
	
	var ValidationRequired;
	
	ValidationRequired="/^.*(?=.*[0-9]).*$/";

	// Calculating applicable consent fee based on above selection	
			if(indTyp=="HOSPITAL" || indType=="CBWTF")
   		{
   			if(capitalInvestMent < 50)
    		{
    			result=500;
    		}
    		else if(  capitalInvestMent > 49 && capitalInvestMent < 200)
    		{
    			result=3000;
    		}
    		else if(capitalInvestMent > 199 && capitalInvestMent < 500)
    		{
    			result=5000;
    		}
    		else if(capitalInvestMent > 499)
    		{
    			result=10000;
    			
    		}
    	}
		else if(indTyp=="CLINIC")
   		{
   			
    			result=250;
    		
    	}
		else if(indTyp=="LAB"||indTyp=="BLOOD BANK"||indTyp=="VETERINARY")
   		{
   			if(capitalInvestMent <= 5000)
    		{
    			result=500;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=1000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 20000)
    		{
    			result=2000;
    		}
    		else if(capitalInvestMent > 20000)
    		{
    			result=4000;
    		}
    		
    	}		
    	
    	
    	
		var feeApp = document.getElementsByName('feeApplicable');
		//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
		
			if( feeApp != null){
				
				//alert("asas");
				feeApp[0].value=result*((document.getElementsByName('yearsApplied')[0]).value);
				
				//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
			}
	return true;
}

</script>
</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- code for menuIndustryHorizontal-->
		<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<%
              if(  (IndUser)session.getAttribute("indUser")  ){ %>
                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><%} %>
          	<%if((UserMaster)session.getAttribute("userMaster")){
                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                        String userType = aa.accessLevel;
                              if(userType.equals("admin")) { %>   
                              <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
            <%    }else{ %>
                  <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
            <%    }
          		} %>
         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               	<g:include controller="userMaster" action="showIndexMenu"/>            
         	<% } %>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>
<%
  IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            	String indname=ind.indName;
             
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					
					<table width="100%" bgcolor="#4C8BC0">
						 <tr >
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->  <td align="center" valign="top"><div style="width:400px;  vertical-align:middle">
                    <span class="error"> 
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${bioMedicalWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${bioMedicalWasteInstance}" as="list" />
            </div>
            </g:hasErrors>
            </span>
            </td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="33" align="left" valign="top">&nbsp;</td>
                            <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
			 
    <br/>
    <g:form name="myform" action="save" method="post" >
    <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
   		<table width="90%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td>
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Bio-Medical</span></a></li>
						<li><a href="#country3"><span>Fee</span></a></li>
							<li><a href="#country4"><span>Detail files</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
         																	
         <div class="content" id="country2" >
         
		  <table class="tblbdr" width="90%" align="center">
                        <tbody>
                        
				<input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=bioMedicalWasteInstance.id%>"/>
				 
			<input type="hidden" name="nameAddressInstitution" id="nameAddressInstitution" value="">
				<input type="hidden" name="nameOfApplicant" id="nameOfApplicant" value="">
								<input type="hidden" name="nameOfInstitution" id="nameOfInstitution" 
					 
					   
                            <tr class="prop">
                                <td colspan="2" valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"> 
                                    <label for="activityAuthorizationSoughtFor">Activity For Which Authorization Is Sought :*</label>
                                </td>
                            </tr>
                            <tr class="prop">
                               <td colspan="2" width="100%" bgcolor="#E8F6F9"  class="headngblue">
								      <p>
								      	<input type="checkbox" name="checkboxGeneration" id="checkboxGeneration" onClick="changeOtherCheckBox();"/>
								  			Generation 
								  			&nbsp; &nbsp; &nbsp;  
								        <input type="checkbox" name="checkboxCollection" id="checkboxCollection" />
								  			Collection 
								  			&nbsp; 
								   		<input type="checkbox" name="checkboxReception" id="checkboxReception"/>
											Reception 
											&nbsp; &nbsp; 
								        <input type="checkbox" name="checkboxStorage" id="checkboxStorage"/>
								        	Storage 
								        	<br/>   
								        <input type="checkbox" name="checkboxTransportation" id="checkboxTransportation"/>
								    		Transportation
								    	<input type="checkbox" name="checkboxTreatment" id="checkboxTreatment"/>
											Treatment 
											
										<input type="checkbox" name="checkboxDisposal" id="checkboxDisposal"/> 
											Disposal
											&nbsp; &nbsp; &nbsp; 
										<input type="checkbox" name="checkboxAnyother" id="checkboxAnyother" /> 
											Any other form of Handling 
											<br/>	
									 </p>
							   </td>

                           </tr> 
                            
                                                     <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authorizationType">Authorization Type:*</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                     <input name="authorizationType" type="radio" id="radiobuttonfresh" value="FreshApplication" checked="checked" onclick="enablingDisablingAgain();" />
							    		fresh application  
							        <input name="authorizationType" type="radio" id="radiobuttonRenew" value="RenewalApplication" onclick="enablingDisablingAgainRenew();"/>
										Renewal application
                                </td>
                            </tr> 
                          
						   <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">  <div style="display:none; border:0;"  id="auth"  >In case of renewal please mention previous authorization number and Date*</div> </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    <div style="display:none; border:0;"  id="auth1"  >
								    <table width="293" border="1">
								      <tr >
								        <td><div style="display:block; border:0;"  id="auth2"  >Number : </div></td>
								        <td><div style="display:block; border:0;"  id="auth2"  >Date(dd/mm/yyyy):</div> </td>
								      <td><div style="display:block; border:0;"  id="auth2"  >Expiry Date(dd/mm/yyyy):</div> </td>
								     
								      </tr>
								      <tr >
								     
								        <td>  <input name="prevauthNo" id="prevauthNo" type="text" disabled="disabled"  size="10" maxlength="6" AUTOCOMPLETE=OFF class="txt4" /></td>
								        <td>  <calendar:datePicker name="prevauthDate" id="prevauthDate" dateFormat="%d/%m/%Y" disabled="disabled"  /></td>
								   		<td>  <calendar:datePicker name="prevexpDate" id="prevexpDate" dateFormat="%d/%m/%Y" disabled="disabled"  /></td>
								      </tr>
								
								    
								    </table>
								    </div>      
								</td>
			  				</tr>
                           
                        
                            
						  
                           
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="addrPlaceDisposalOfWaste">Address of Place Disposal Of Waste :*</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:bioMedicalWasteInstance,field:'addrPlaceDisposalOfWaste','errors')}">
                                    <input type="text" id="addrPlaceDisposalOfWaste" name="addrPlaceDisposalOfWaste" value="${fieldValue(bean:bioMedicalWasteInstance,field:'addrPlaceDisposalOfWaste')}"/>
                                </td>
                            </tr> 
                       
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="addrTreatmentFacility">Address of  Treatment Facility:*</label>
                                </td>
                                <td valign="top"  bgcolor="#E8F6F9" class="value ${hasErrors(bean:bioMedicalWasteInstance,field:'addrTreatmentFacility','errors')}">
                                    <input type="text" id="addrTreatmentFacility" name="addrTreatmentFacility" value="${fieldValue(bean:bioMedicalWasteInstance,field:'addrTreatmentFacility')}"/>
                                </td>
                            </tr> 
                        
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="descrip">Description:*</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:bioMedicalWasteInstance,field:'descrip','errors')}">
                                    <input type="text" id="descrip" name="descrip" value="${fieldValue(bean:bioMedicalWasteInstance,field:'descrip')}"/>
                                </td>
                            </tr> 
                            <tr >
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Category of waste* </td>
							    <td width="60%" bgcolor="#A8DAF3"  align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">
							    	Quantity of waste & Unit (In KL/Month / Liter/Month)
							    </td>
							</tr>
							
                     <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    
								<input type="checkbox" name="checkboxHAW" id="checkboxHAW"/>
								  			Category 1 (Human Anatomical Waste)
							    </td>
							    <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categHAW" />
								<input type="text" name="categHAWUnit" /></td>
							</tr>
                            
                             <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxAW" id="checkboxAW" />
							    
								  			Category 2 (Animal Waste) 
							    </td>
							    <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categAW" />
							<input type="text" name="categAWUnit" /></td>
							</tr>
							
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxMBW" id="checkboxMBW" />
								  			Category 3 (Microbiology & Biotechnology Waste)
							    </td>
							    <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categMBW" />
								<input type="text" name="categMBWUnit" /></td>
							</tr>
							
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxWS" id="checkboxWS" />
								  			Category 4 (Waste sharps)
							    </td>
							    <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categWS" />
								<input type="text" name="categWSUnit" /></td>
							</tr>

							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxDMCD" id="checkboxDMCD" />
								  			Category 5 (Discarded Medicines and Cytotoxic drugs)
							    </td>
							    <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categDMCD" />
								<input type="text" name="categDMCDUnit" /></td>
							</tr>

							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxSW6" id="checkboxSW6" />
								  			Category 6 (Soiled Waste)
							    </td> 
							  <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categSW6" />
							   <input type="text" name="categSW6Unit" /></td>
							</tr>
							
							
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxSW7" id="checkboxSW7" />
								  			Category 7 (Solid Waste disposal generated)
							    </td>
							    <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categSW7" />
								<input type="text" name="categSW7Unit" /></td>
							</tr>
							
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxLW" id="checkboxLW" />
								  			Category 8 (Liquid Waste)
							    </td>
							   <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categLW" />
						<input type="text" name="categLWUnit" /></td>

							    </tr>
							
								<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxIA" id="checkboxIA" />
								  			Category 9 (Incineration Ash) 
							    </td>
							   <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categIA" />
							    <input type="text" name="categIAUnit" /></td>

							</tr>
							
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    <input type="checkbox" name="checkboxCW" id="checkboxCW" />
								  			Category 10 (Chemical Waste) 
							    </td>
							   <td width="60%" colspan="2" bgcolor="#E8F6F9"  align="left" class="headngblue"><input type="text" name="categCW" />
							    <input type="text" name="categCWUnit" /></td>

							</tr>
                        

                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="modeTrans">Mode of Transportation :*</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:bioMedicalWasteInstance,field:'modeTrans','errors')}">
                                    <input type="text" id="modeTrans" name="modeTrans" value="${fieldValue(bean:bioMedicalWasteInstance,field:'modeTrans')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="modeTreat">Mode of Treatment :*</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:bioMedicalWasteInstance,field:'modeTreat','errors')}">
                                    <input type="text" id="modeTreat" name="modeTreat" value="${fieldValue(bean:bioMedicalWasteInstance,field:'modeTreat')}"/>
                                </td>
                            </tr> 
                        
                            
                            
                        </tbody>
                    </table>
                    
                   
                   
                    
		   </div>
		      <div class="content" id="country3">
		  
		  <table width="90%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">	
		  
		   <%
	def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
	%>									
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue" > ${cat.category}</td>
				</tr> 
				
				<input type="hidden" id="catVale" value="${cat.category}">
				<input type="hidden" id="noOfBeds" value="${indRegInstance?.indCapInvt}">
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">No of Beds: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${indRegInstance?.indCapInvt}<span class="txt style6"></span>
				</tr>
				
				 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><input name="yearsApplied" id="yearsApplied" type="text" class="txt4" maxlength="4" size="10" value=''/>
					&nbsp;<span class="sidetxt">(Enter no of yrs)</span></span></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value='' /><a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
					&nbsp;<span class="sidetxt">(Click to calculate fee for new industry)</span></span></td>
				</tr>  
			  
			</td></tr>
	
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<tr>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsAddBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsEditBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
					</tr>
					</table>
					</td>
				</tr>  
	
	
			</table>	
			
  
  
  
          </div>
		  
		   
		   
			 <div class="content" id="country4">
               <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="90%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
				
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Documents Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<!-- <td colspan="4"  align="center" valign="middle"  class="headngblue">Do You Want To Submit Documents Manually ? &nbsp; &nbsp; &nbsp; <input type="radio" name="doc" id="consent" onclick="${remoteFunction(controller:'indApplicationDetails', action:'docSel',update:'docPanel', params:'\'cont=\' + this.value' )}" value="yes"  checked="checked" />Yes &nbsp;&nbsp;<input type="radio" name="doc" id="consent" onclick="${remoteFunction(controller:'indApplicationDetails', action:'docSel',update:'docPanel', params:'\'cont=\' + this.value' )}" value="no" />No</td>-->
				<td colspan="4"  align="center" valign="middle"  class="headngblue">Do You Want To Submit Documents Manually ? &nbsp; &nbsp; &nbsp; <input onclick="javascript:hidediv();" type="radio" name="doc" id="consent"  value="yes"   />Yes &nbsp;&nbsp;<input type="radio" name="doc" id="consent"  value="no" onclick="javascript:showdiv();" checked="checked" />No</td>
				</tr> 
				<tr>
				<td colspan="4"><div id="hideShow">
					<table width="100%" cellpadding="0" cellspacing="0">
				<tr bgcolor="#A8DAF3">
					<td width="35%" align="center" class="headngblue" valign="top">Upload Required Documents</td>
				
					<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popUploadDoc/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Upload </a></td>
				</tr> 
				</table>
				</div></td>
				</tr>
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  	   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  Please select "Yes" if you want to send the documents By Post/ By Hand and "No" to upload the required document online.<br>For Online Document Upload:
			  &nbsp;<ul> 
				<li>Click link "Upload" to upload the document</li>
				<li>Click "Browse" to select the document</li>
				<li>You can select multiple documents at the same time</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Click "Save" button to upload the document</li>
				<li>Message "Document successfully uploaded" will be displayed</li>
			  </ul>
		</div>
		<hr>
           <br/>									</div>
           
            
		   <div class="content" id="country1" >
		   <table width="90%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   
		    <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="indname" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indName }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Addr" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indAddress }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			    
	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Addr" type="text" class="txt4" size="30" readonly="readonly" value="${cat.district}" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Code:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="PhoneNoCode" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indPhoneCode }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
				
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="PhoneNo" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indPhoneNo }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="FaxNoCode" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indFaxCode }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
		   
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="FaxNo" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indFaxNo }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
		   
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email id:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="emailid" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indEmail }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
		   
		  		   
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the Applicant :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="app" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.occName }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
		
		   
		    <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of the Applicant :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="address" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.occAddress }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
			
			
			
			
		    <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Code :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="phonenoOcc" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.occPhoneCode }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Number :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="phonenoOccc" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.occPhoneNo }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
		   
		   
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number Code :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="faxnoOCode" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance.occFaxCode }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
			
			 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number No. :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="faxnoO" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance.occFaxNo }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
		    <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email id:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="emailId" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.occEmail }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr>
			
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Addr" type="text" class="txt4" size="30" readonly="readonly" value="${cat.category}" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">No of Beds :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indCapInvt }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
		
			
		
		
		
		   </table>
		   
         
		   
		   </div>
		    <table width="90%"  border="0" align="center" class="tblbdr"  >
               		<tbody>
		               <tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Do You Want To Save The Application as
							<input name="appStatus" type="radio" value="Completed" />  <span class="style3">Completed</span> 
							&nbsp;
							<input name="appStatus" type="radio" value="Inprogress" checked="checked"/>  <span class="style3">In Progress</span>
		                	</td>
						</tr>
					</tbody>	
               		</table>
                    
                    <table width="95%"> 
						<tr>
							<td width="15%">&nbsp;</td>
							<td colspan="4" align="center" class="txtR">Fields marked * are mandatory</td>
						</tr>
					</table>   
                    
		   <table width="75%" align="center">
	                     <tbody>
						        <tr class="prop">
	                                <td valign="top" align="center">
	                                <span class="button"><input class="actionbutton" type="submit" value="Save" onclick="return tosubmit();"/></span>
	                                </td>
	                            </tr> 
	                    </tbody>
	                    
                    </table>
		      </g:form>


      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>
 <script language="JavaScript" type="text/javascript">

 

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 

function tosubmit()
{
	  	
					  	
	if(!(document.getElementById("checkboxGeneration").checked) && !(document.getElementById("checkboxCollection").checked) && !(document.getElementById("checkboxReception").checked) && !(document.getElementById("checkboxStorage").checked) && !(document.getElementById("checkboxTransportation").checked) && !(document.getElementById("checkboxTreatment").checked)&& !(document.getElementById("checkboxDisposal").checked)&& !(document.getElementById("checkboxAnyother").checked))
 			{ 
 				alert("Please Check Atleast one Authorization Reqired For Check Box");
 				return false;
 			}
 			else
	{
	
	if(!(document.getElementById("checkboxHAW").checked) &&!(document.getElementById("checkboxAW").checked) && !(document.getElementById("checkboxMBW").checked) && !(document.getElementById("checkboxWS").checked) && !(document.getElementById("checkboxDMCD").checked) && !(document.getElementById("checkboxSW6").checked) && !(document.getElementById("checkboxSW7").checked) && !(document.getElementById("checkboxLW").checked) && !(document.getElementById("checkboxIA").checked) && !(document.getElementById("checkboxCW").checked))
	{
	alert("Please Check Atleast one Category Check Box");
	return false;
 	}
 	else
 	{				  	
if(document.getElementById("checkboxHAW").checked)
 { 
 frmvalidator.addValidation("categHAW","req","Please enter value for Category no. 1 ");
 frmvalidator.addValidation("categHAW","numeric","enter valid value for Category no. 1 " );
  frmvalidator.addValidation("categHAWUnit","req","Please enter value for unit of Category no. 1 " );
 }
 
 if(document.getElementById("checkboxAW").checked)
 { 
 frmvalidator.addValidation("categAW","req","Please enter value for Category no. 2 ");
 frmvalidator.addValidation("categAW","numeric","enter valid value for Category no. 2 ");
 frmvalidator.addValidation("categAWUnit","req","Please enter value for unit of Category no. 2 " );
 } 
  
 if(document.getElementById("checkboxMBW").checked)
 { 
 frmvalidator.addValidation("categMBW","req","Please enter value for Category no. 3 ");
 frmvalidator.addValidation("categMBW","numeric","enter valid value for Category no. 3 ");
 frmvalidator.addValidation("categMBWUnit","req","Please enter value for unit of Category no. 3 " );
 } 
  
 if(document.getElementById("checkboxWS").checked)
 { 
 frmvalidator.addValidation("categWS","req","Please enter value for Category no. 4 ");
 frmvalidator.addValidation("categWS","numeric","enter valid value for Category no. 4 ");
  frmvalidator.addValidation("categWSUnit","req","Please enter value for Unit of Category no. 4 ");
 } 
 
 if(document.getElementById("checkboxDMCD").checked)
 { 
 frmvalidator.addValidation("categDMCD","req","Please enter value for Category no. 5 ");
 frmvalidator.addValidation("categDMCD","numeric","enter valid value for Category no. 5 ");
  frmvalidator.addValidation("categDMCDUnit","req","Please enter value for unit of Category no. 5 ");
 
 } 
 
 if(document.getElementById("checkboxSW6").checked)
 { 
 frmvalidator.addValidation("categSW6","req","Please enter value for Category no. 6 ");
frmvalidator.addValidation("categSW6","numeric","enter valid value for Category no. 6 ");
 frmvalidator.addValidation("categSW6Unit","req","Please enter value for unit of  Category no. 6 ");

 }
 
 if(document.getElementById("checkboxSW7").checked)
 { 
 frmvalidator.addValidation("categSW7","req","Please enter value for Category no. 7 ");
 frmvalidator.addValidation("categSW7","numeric","enter valid value for Category no. 7 ");
  frmvalidator.addValidation("categSW7Unit","req","Please enter value for unit of Category no. 7 ");
 

 }
 
 if(document.getElementById("checkboxLW").checked)
 { 
 frmvalidator.addValidation("categLW","req","Please enter value for Category no. 8 ");
 frmvalidator.addValidation("categLW","numeric","enter valid value for Category no. 8 ");
  frmvalidator.addValidation("categLWUnit","req","Please enter value for Unit of Category no. 8 ");
 
 }
 
 if(document.getElementById("checkboxIA").checked)
 { 
 frmvalidator.addValidation("categIA","req","Please enter value for Category no. 9 " );
 frmvalidator.addValidation("categIA","numeric","enter valid value for Category no. 9 ");
  frmvalidator.addValidation("categIAUnit","req","Please enter value for Unit of Category no. 9 " );
 
 
 }
 
 if(document.getElementById("checkboxCW").checked)
 { 
 frmvalidator.addValidation("categCW","req","Please enter value for Category no. 10 ");
 frmvalidator.addValidation("categCW","numeric","enter valid value for Category no. 10 ");
  frmvalidator.addValidation("categCWUnit","req","Please enter value for unit of Category no. 10 ");
 
 
 }
  
 frmvalidator.addValidation("authorizationType","selone_radio","Please Select any one of the Authorization Type");
 
 
 	if(document.getElementById("radiobuttonRenew").checked)
	{
	
	frmvalidator.addValidation("prevauthNo","req","Please Enter Authorization Renew Number ");
	frmvalidator.addValidation("prevauthDate","req","Please Enter Authorization Renew Date ");
	frmvalidator.addValidation("prevexpDate","req","Please Enter Authorization Expiry Date ");
	frmvalidator.addValidation("prevauthNo","numeric","Enter Numeric value for Authorization Renew Number");
	}
 

	
 frmvalidator.addValidation("addrPlaceDisposalOfWaste","req","Please enter Address of Place Disposal Of Waste:");
 frmvalidator.addValidation("addrPlaceDisposalOfWaste","alpha_s","enter valid Address of Place Disposal Of Waste");
 
 frmvalidator.addValidation("addrTreatmentFacility","req","Please enter Address of  Treatment Facility");
 frmvalidator.addValidation("addrTreatmentFacility","alpha_s","enter valid Address of  Treatment Facility");
 
 frmvalidator.addValidation("createdBy","req","Please enter createdBy");
 frmvalidator.addValidation("createdBy","alpha_s","enter valid Entry for createdBy");
 
 frmvalidator.addValidation("descrip","req","Please enter Description");
 frmvalidator.addValidation("descrip","alpha_s","enter valid Entry for Description");
 
 frmvalidator.addValidation("modeTrans","req","Please enter Mode of Transportation");
 frmvalidator.addValidation("modeTrans","alpha_s","enter valid Entry for Mode of Transportation");
 
 frmvalidator.addValidation("modeTreat","req","Please enter Mode of Treatment");
 frmvalidator.addValidation("modeTreat","alpha_s","enter valid Entry for Mode of Treatment");
 
 
 frmvalidator.addValidation("appStatus","selone_radio","Please select any one of the Application Status ");
}
 }
}
 
</script>

</body>
</html>


