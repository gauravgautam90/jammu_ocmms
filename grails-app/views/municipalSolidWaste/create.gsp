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

</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")

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
var a= document.getElementById("radiobuttonfresh").value;
if(a=="FreshApplication")
	{
	document.getElementById("prevauthNo").disabled = true;
	document.getElementById("prevauthDate").disabled = true;
	}
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
								                        <g:include controller="userMaster" action="showSpcbIndustryMenu"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
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
                    <tr><!-- Div area for errors--><td>
<span class="error">
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${municipalSolidWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${municipalSolidWasteInstance}" as="list" />
            </div>
            </g:hasErrors></span></td>
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
    <g:form name="myform" action="save" method="post" enctype="multipart/form-data">
    <input type="hidden" name="indRegId" value="${indRegInstanceId}" />
   		<table width="75%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td>
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Municipal Solid Waste</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
         
         <div class="content" id="country2" >
         
		  <table class="tblbdr" width="75%" align="center">
                        <tbody>
                       	<tr >
						    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Nodal Officer Details ( Officer authorised by the municipal authority or </td>
						</tr>
						<tr >
						    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">agency responsible for operation of processing or disposal facility):</td>
						</tr>
                       	   <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameNodal">Name of Nodal officer*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'nameNodal','errors')}">
                                    <input type="text" id="nameNodal" name="nameNodal" value="${fieldValue(bean:municipalSolidWasteInstance,field:'nameNodal')}"/>
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="desigNodal">Designation of Nodal officer*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'desigNodal','errors')}">
                                    <input type="text" id="desigNodal" name="desigNodal" value="${fieldValue(bean:municipalSolidWasteInstance,field:'desigNodal')}"/>
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authApp">Authorization Applied for*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                     <input name="authApp" type="radio" id="processing" value="Settingup&operationofwasteprocessingfacility" onclick="enablingDisablingAgain();" checked="checked" />
							    		Setting up & operation of waste processing facility 
							    		<br/>
							        <input name="authApp" type="radio" id="disposal" value="Settingup&operationofdisposalfacility" onclick="enablingDisabling();"/>
										Setting up & operation of disposal facility
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authorizationType">Authorization Type:*</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                     <input name="authorizationType" type="radio" id="radiobuttonfresh" value="FreshApplication" onclick="enablingDisablingAgain();" checked="checked"/>
							    		fresh application  
							        <input name="authorizationType" type="radio" id="radiobuttonrenew" value="RenewalApplication" onclick="enablingDisabling();"/>
										Renewal application
                                </td>
                            </tr> 
                            
                            <tr >
							    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Processing of waste </td>
							</tr>
                        	
					        <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="locationSite">Location of Site*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'locationSite','errors')}">
                                    <input type="text" id="locationSite" name="locationSite" value="${fieldValue(bean:municipalSolidWasteInstance,field:'locationSite')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="qtyProcessed">Quantity of waste to be processed per day*: </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'qtyProcessed','errors')}">
                                	<label >Quantity :</label>
                                    <input type="text" id="qtyProcessed" name="qtyProcessed" value="${fieldValue(bean:municipalSolidWasteInstance,field:'qtyProcessed')}" />
                                    <label >Unit :</label>
                                    <g:select optionKey="id" from="${UnitMaster.list()}" name="unitMasterobjqtyProd" value="${municipalSolidWasteInstance?.unitMasterobjqtyPro?.id}" ></g:select>
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures to be taken for prevention and control of environmental pollution*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'indRegMasterObj','errors')}">
                                    <g:select optionKey="measureName" multiple="yes" from="${MeasureMaster.list()}" name="measuresPrevention" value="${measureMasterInstance?.id}" ></g:select>
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures to be taken for safety of workers working in the plant*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'indRegMasterObj','errors')}">
                                    <g:select optionKey="measureName" multiple="yes" from="${MeasureMaster.list()}" name="measureSafety" value="${measureMasterInstance?.id}" ></g:select>
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="invenstment">Investme on Project (In Lakhs)*: </label>
                                </td>
                                <td valign="top"  bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'invenstment','errors')}">
                                    <input type="text" id="invenstment" name="invenstment" value="${fieldValue(bean:municipalSolidWasteInstance,field:'invenstment')}" />
                                </td>
                            </tr> 
                            
                             <tr class="prop">
                               <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="expectedReturn">Expected Return from Project (In Laks)*: </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'expectedReturn','errors')}">
                                    <input type="text" id="expectedReturn" name="expectedReturn" value="${fieldValue(bean:municipalSolidWasteInstance,field:'expectedReturn')}" />
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameWasteProcessingTech">Name of Waste Processing Technology*: </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'nameWasteProcessingTech','errors')}">
                                    <input type="text" id="nameWasteProcessingTech" name="nameWasteProcessingTech" value="${fieldValue(bean:municipalSolidWasteInstance,field:'nameWasteProcessingTech')}"/>
                                </td>
                            </tr> 
                            
                            <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Details of Processing Technology:</td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="processingTechnology" id="processingTechnology" />
							    </td>
							</tr>
							
						    <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Site clearence (from Local Authority):</td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="siteclearence" id="siteclearence" />
							    </td>
							</tr>
							
						   <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Details of agreement between municipal authority and operating agency:</td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="detail" id="detail" />
							    </td>
							</tr>
							
						    <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Utilization programme for waste processed (Product utilization):</td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="utilizationprogramme" id="utilizationprogramme" />
							    </td>
							</tr>
							
						    <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Methodology for disposal of waste processing rejects (quantity and quality):</td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="methodology" id="methodology" />
							    </td>
							</tr>
							
							<tr >
							    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Disposal of Waste </td>
							</tr>
                            
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="numSites">Number of sites indentified:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'numSites','errors')}">
                                    <input type="text" id="numSites" name="numSites" value="${fieldValue(bean:municipalSolidWasteInstance,field:'numSites')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="qtyDisposed">Quantity of waste to be disposed per day:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'qtyDisposed','errors')}">
                                	<label>Quantity :</label>
                                    <input type="text" id="qtyDisposed" name="qtyDisposed" value="${fieldValue(bean:municipalSolidWasteInstance,field:'qtyDisposed')}" />
                                    <label>Unit :</label>
                                    <g:select optionKey="id" from="${UnitMaster.list()}" name="unitMasterobjqtyDiss" value="${municipalSolidWasteInstance?.unitMasterobjqtyDis?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="natureWaste">Nature of waste:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'natureWaste','errors')}">
                                    <input type="text" id="natureWaste" name="natureWaste" value="${fieldValue(bean:municipalSolidWasteInstance,field:'natureWaste')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="compWaste">Composition of waste:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'compWaste','errors')}">
                                    <input type="text" id="compWaste" name="compWaste" value="${fieldValue(bean:municipalSolidWasteInstance,field:'compWaste')}"/>
                                </td>
                            </tr> 
                            
                            <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Details of Existing Site under Operation: </td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="detailsexistingsite" id="detailsexistingsite" />
							    </td>
							</tr>
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures taken to check enviornmental pollution*:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="value ${hasErrors(bean:municipalSolidWasteInstance,field:'indRegMasterObj','errors')}">
                                    <g:select optionKey="measureName" multiple="yes" from="${MeasureMaster.list()}" name="measurePollution" value="${measureMasterInstance?.id}" ></g:select>
                                </td>
                            </tr> 
							
						    <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Layout maps of site: </td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="layoutmaps" id="layoutmaps" />
							    </td>
							</tr>
							
							
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Details of methodology or criteria followed for site selection: </td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="detailmethodologyorcriteria" id="detailmethodologyorcriteria" />
							    </td>
							</tr>
							
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Methodology and operational details of landfilling: </td> 
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
							    	<input type="file" name="methodologyoperationaldetails" id="methodologyoperationaldetails" />
							    </td>
							</tr>
                            
                        </tbody>
                    </table>
                    
                    <table width="75%"  border="0" align="center" class="tblbdr"  >
               		<tbody>
		               <tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Do You Want To Save The Application as
							<input name="appStatus" type="radio" value="Completed" />  <span class="style3">Completed</span> 
							&nbsp;
							<input name="appStatus" type="radio" value="Inprogress" checked="checked" />  <span class="style3">In Progress</span>
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
	                                <span class="button"><input class="actionbutton" type="submit" value="Save" onclick="return tosubmit();" /></span>
	                                </td>
	                            </tr> 
	                    </tbody>
	                    
                    </table>
                    
		   </div>
		
		   <div class="content" id="country1" >
		   <table width="75%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Municipal Authority/ Name of the agency appoined by the Municipal Authority  :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Nameins" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indName }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
				</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Corrospondence Address :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Addr" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indAddress }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="City" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.occCity }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="District" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.occDistrict }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Tehsil :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Tehsil" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.occTehsil }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Pin" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indPin }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Telephone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="PhoneNo" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indPhoneNo }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
		   
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="FaxNo" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indFaxNo }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
		 	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Mobile" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.occMobile }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-mail Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Email" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indEmail }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
		   
		   </table>
		   
         
		   
		   </div>
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

 frmvalidator.setAddnlValidationFunction("Checkfiles");
 frmvalidator.addValidation("nameNodal","req","Please enter Name of Nodal officer");
 frmvalidator.addValidation("nameNodal","alpha_s","enter valid Name of Nodal officer");

 frmvalidator.addValidation("desigNodal","req","Please enter Designation of Nodal officer");
 frmvalidator.addValidation("desigNodal","alpha_s","enter valid Designation of Nodal officer");
	
 frmvalidator.addValidation("authApp","req","Please enter Authorization Applied for");
 frmvalidator.addValidation("authApp","alpha_s","enter valid Authorization Applied for");
 
 frmvalidator.addValidation("locationSite","req","Please enter Location of Site");
 frmvalidator.addValidation("locationSite","alpha_s","enter valid Location of Site");
 
 frmvalidator.addValidation("qtyProcessed","req","Please enter Quantity Processed");
 frmvalidator.addValidation("qtyProcessed","numeric","enter valid Quantity Processed");
 
 frmvalidator.addValidation("invenstment","req","Please enter Invenstment");
 frmvalidator.addValidation("invenstment","numeric","enter valid Entry for Invenstment");

 frmvalidator.addValidation("expectedReturn","req","Please enter Expected Return");
 frmvalidator.addValidation("expectedReturn","numeric","enter valid Entry Expected Return");
 
 frmvalidator.addValidation("numSites","numeric","enter valid Entry for Number of Sites");
 frmvalidator.addValidation("qtyDisposed","numeric","enter valid Quantity of waste to be disposed per day");
  frmvalidator.addValidation("natureWaste","alpha_s","enter valid Nature of waste");
   frmvalidator.addValidation("compWaste","alpha_s","enter valid Composition of waste:");
   
 frmvalidator.addValidation("nameWasteProcessingTech","req","Please enter Name of Waste Processing Technology");
 frmvalidator.addValidation("nameWasteProcessingTech","alpha_s","enter valid Name of Waste Processing Technology");
 
 frmvalidator.addValidation("authApp","selone_radio","Please select any one of the Authorizations ");
 
 frmvalidator.addValidation("unitMasterobjqtyProd","req","Please select type of unit for Quantity Processed");
 
 
 
frmvalidator.addValidation("measuresPrevention","req","Please select measures for prevention");
frmvalidator.addValidation("measureSafety","req","Please select measures for Safety");
frmvalidator.addValidation("measurePollution","req","Please select measures for Pollution");
 

 return true;
}
 
 function Checkfiles()
 {
   if(document.getElementById('processingTechnology') != null)
    {
    	var fup = document.getElementById('processingTechnology');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Processing Technology');
		   	 	return false;
			}
    }
   
   if(document.getElementById('siteclearence') != null)
    {
    	var fup = document.getElementById('siteclearence');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for for Site Clearence');
		   	 	return false;
			}
    }
   
	if(document.getElementById('detail') != null)
    {
    	var fup = document.getElementById('detail');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Details of agreement between municipal authority and operating agency');
		   	 	return false;
			}
    }
	
	
	if(document.getElementById('utilizationprogramme') != null)
    {
    	var fup = document.getElementById('utilizationprogramme');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Utilization Programme');
		   	 	return false;
			}
    }
	
	
	if(document.getElementById('methodology') != null)
    {
    	var fup = document.getElementById('methodology');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Methodology for disposal of waste processing rejects ');
		   	 	return false;
			}
    }
	
	
	if(document.getElementById('detailsexistingsite') != null)
    {
    	var fup = document.getElementById('detailsexistingsite');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Details of Existing Site under Operation ');
		   	 	return false;
			}
    }
	
	if(document.getElementById('layoutmaps') != null)
    {
    	var fup = document.getElementById('layoutmaps');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Layout Maps');
		   	 	return false;
			}
    }
	
	
	if(document.getElementById('detailmethodologyorcriteria') != null)
    {
    	var fup = document.getElementById('detailmethodologyorcriteria');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Details of methodology or criteria followed for site selection');
		   	 	return false;
			}
    }
	
	
	
	if(document.getElementById('methodologyoperationaldetails') != null)
    {
    	var fup = document.getElementById('methodologyoperationaldetails');
  
  
	    var fileName = fup.value;
	    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
	    
	      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
				  {
	      	    	
				   } 
		     else
			 {
		    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Methodology and operational details of landfilling');
		   	 	return false;
			}
    }
	
	
	
	
	return true;
 }
 
 
</script>

</body>
</html>


