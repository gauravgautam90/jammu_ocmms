<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

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



</head>

<body >
		
		<g:form action="edit" method="post" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks">Sample Detail </td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
			<g:if test="${checkAir}">
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr><td width="100%" class="headngblue1" colspan="2" >A) Suspended Particulate Matter (8 hour sampling):</td></tr>
						<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sampling Station: *</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9" class=" headngblue">
                             <div align="left">
                             ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'samplingStation')}
                                </div></td>
                      </tr>
                      <tr >
                        <td width="150px" class=" headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sample Date: *</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9">
                             <span class="txt "> 
                             ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'dateOfSample')}   
                             
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Total sampling time (in min): *</div></td>
                        <td bgcolor="#E8F6F9"  class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'totalSamplingTime')}
                               </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Power Failure (in min): *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'powerFailure')}
                              </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Initial Flow rate of manometer: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'initialFlowRateOfManometer')}
                               </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Final Flow rate of manometer: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						     ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'finalFlowRateOfManometer')}
                               </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Average Flow Rate Of manometer: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						     ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'averageFlowRateOfManometer')}
                               </div></td>
                      </tr>
                      
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Atmosphereic pressure (Initial): *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'initialAtmosphericPressure')}
                                </div><span class="txt4">m.m. of Hg</span></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Atmosphereic pressure (Final): *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						   ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'finalAtmosphericPressure')}   </div><span class="txt4">m.m. of Hg</span></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Average Atmospheric pressure : *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						   ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'averageAtmosphericPressure')}    </div><span class="txt4">m.m. of Hg</span></td>
                      </tr>
                      <tr><td class="headngblue1">Ambient temperature (*C):</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                              <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr class="headngblue">
                                   
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureFirstHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureSecondHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureThirdHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureFourthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureFifthHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureSixthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureSeventhHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureEighthHour')}</td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wt. Of blank filter paper : *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						 ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'wtOfBlankFilterPaper')}
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wt. filter+Sample: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						   ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'wtOfFilterAndSample')}    </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wt. Of particulate matter: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'wtOfParticulateMatter')}   </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Pariculate matter concentration: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'particulateMatterConcentration')}   </div></td>
                      </tr>
                      <tr><td class="headngblue1">B) Gases (4 hourly sampling):</td></tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Flow rate of rotameter (1 PM): *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						  ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'flowRateOfRotameter')}    </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Net sampling time (in min): *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						 ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'netSamplingTime')}       </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Total volume in Its: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						 ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'totalVolumeInIts')}      </div></td>
                      </tr>
                        <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Horizons : *</div></td>
                        <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">horizons

						     ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'horizons')}   </div></td>
                      </tr>
                      <tr><td class="headngblue1">Concentration of Gases:</td></tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >I four hourly SO2: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						    ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'oneSO')}
                                 </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >II four hourly SO2: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						   ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'twoSO')}    </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >I four hourly Nox: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						  ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'oneNox')}         </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >II four hourly NOx: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						   ${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'twoNox')}    </div></td>
                      </tr>
                      
                     <tr><td class="headngblue1">Relative humidity (%):</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                              <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td width="100px" class="headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumOneHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumTwoHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td width="100px" class="headngblue" >${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumThirdHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumFourthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td width="100px" class="headngblue" >${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumFifthHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumSixthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td width="100px" class="headngblue" >${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumSeventhHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'relativeHumEighthHour')}</td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                      <tr><td class="headngblue1">Wind speed (Km/hr):</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                              <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr>
                                      <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedOneHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedTwoHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedThirdHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td  class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedFourthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedFifthHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedSixthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedSeventhHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'windSpeedEighthHour')}</td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                      <tr><td class="headngblue1">Wind Direction :</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                             <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionOneHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionTwoHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionThirdHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionFourthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionFifthHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td class=" headngblue"> ${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionSixthHour')}</td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionSeventhHour')}</td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td class=" headngblue">${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionEighthHour')}</td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Remarks: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						  ${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'remarks')}
                                 </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wind Pattern: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						     ${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windPattern')}
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Variations: *</div></td>
                       <td bgcolor="#E8F6F9" class=" headngblue"><div align="left">

						      ${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'variations')}
                                 </div></td>
                      </tr>
    
	  </table>
	  </g:if>
		<g:if test="${checkWater}">
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sample Date: *</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9">
                             <span class="txt  headngblue"> 
                             ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'sampleDate')}
                             
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sampler's Name: *</div></td>
                        <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'samplerName')}
                        <span class="txt4">(max 20 chars )</span></div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Other Field People: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						   ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'otherFieldPeople')}
                        <span class="txt4">(max 30 chars )</span></div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Sample Location: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						  ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'location')} </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Sample Type: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						  ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'sampleType')} </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Sub Sample Volume (mls): *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'subSampleVolume')} </div></td>
                      </tr>
                      <tr><td class="headngblue1">Sample Details:</td></tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >pH: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'pH')}
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >T C/cm: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'TC')}
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Conductivity  (umhos): *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'conductivity')}  </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >DO (ppm): *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'dO_ppm')} </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >CL (ppm): *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'CL')}  </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Comment: *</div></td>
                       <td bgcolor="#E8F6F9"  class="headngblue"><div align="left">

						${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'comment')}  </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Field Conditions: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						  ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'fieldConditions')} </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >pH check: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						  ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'pHCheck')} </div></td> 
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Additional preservative used: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'additionalPreservativeUsed')}  </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Other Observations: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						     ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'otherObservations')}   </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Remarks: *</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">

						 ${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'remarks')}   </div></td>
                      </tr>
                     
    
	  </table>
		</g:if>				
						
			<!-- <table width="95%" align="center">
	   		<tr>
	   		<td >&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="center"><input type="submit" name="Edit" value="Edit" class="actionbutton" ></td>			
		  </tr>
		</table> -->
						
						
						
	   
		
		
  			</g:form>
</body>


</html>



