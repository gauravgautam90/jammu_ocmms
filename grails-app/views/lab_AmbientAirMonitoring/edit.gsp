
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
	<META HTTP-EQUIV="EXPIRES"
CONTENT="0">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% 

      String contex=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>

<script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
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
		<!-- code for menuAdminHorizontal-->
		<% 
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
						  <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
				<%} %>
 <% 
 		if((UserMaster)session.getAttribute("userMaster")){
 		UserMaster aa = (UserMaster)session.getAttribute("userMaster");
		String userType = aa.accessLevel;
		 if(userType.equals("admin")) { %>   

                    <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

                <% }else{ %>

                    <g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 

                  <%}} %>
			<% if( (!(IndUser)session.getAttribute("indUser") ) && 
		      (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
					<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        

                <% } %>

		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<%
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
					 <g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         

                           <%} %>
				 <% 

                 if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                String userType = aa.accessLevel;
					 if(userType.equals("admin")) { %>   

                 <g:include controller="userMaster" action="labAdmin"/>                                          

                 <% }else{ %>
					 <g:include controller="userMaster" action="labEmployee"/> 
							 <%}} %>
						<% if( (!(IndUser)session.getAttribute("indUser") ) && 
							(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
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
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> 
<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
					<td width="100%" align="left">
					
					
							</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
				            			 <g:hasErrors bean="${lab_WaterEffluentMonitoringInstance}">
            <div class="errors">
                <g:renderErrors bean="${lab_WaterEffluentMonitoringInstance}" as="list" />
            </div>
            </g:hasErrors>

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
        <g:form method="post" >
                <input type="hidden" name="id" value="${lab_AmbientAirMonitoringInstance?.id}" />
                <input type="hidden" name="version" value="${lab_AmbientAirMonitoringInstance?.version}" />
                <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Water/Effluent Sheet</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr><td width="100%" class="headngblue1" colspan="2" >A) Suspended Particulate Matter (8 hour sampling):</td></tr>
						<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sampling Station: *</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9">
                             <div align="left">
                             <input type="text" id="samplingStation" name="samplingStation" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'samplingStation')}"/>
                                </div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sample Date: *</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9">
                             <span class="txt style6"> 
                             <calendar:datePicker name="dateOfSample" value="${lab_AmbientAirMonitoringInstance?.dateOfSample}" />   
                             
                                
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Total sampling time (in min): *</div></td>
                        <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="totalSamplingTime" name="totalSamplingTime" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'totalSamplingTime')}" />
                               </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Power Failure (in min): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="powerFailure" name="powerFailure" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'powerFailure')}" />
                              </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Initial Flow rate of manometer: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="initialFlowRateOfManometer" name="initialFlowRateOfManometer" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'initialFlowRateOfManometer')}" />
                               </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Final Flow rate of manometer: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="finalFlowRateOfManometer" name="finalFlowRateOfManometer" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'finalFlowRateOfManometer')}" />
                               </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Average Flow Rate Of manometer: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="averageFlowRateOfManometer" name="averageFlowRateOfManometer" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'averageFlowRateOfManometer')}" />
                               </div></td>
                      </tr>
                      <tr><td class="headngblue1">Sample Details:</td></tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Atmosphereic pressure (Initial): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="initialAtmosphericPressure" name="initialAtmosphericPressure" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'initialAtmosphericPressure')}" />
                                </div><span class="txt4">m.m. of Hg</span></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Atmosphereic pressure (Final): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						   <input type="text" id="finalAtmosphericPressure" name="finalAtmosphericPressure" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'finalAtmosphericPressure')}" />
                                </div><span class="txt4">m.m. of Hg</span></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Average Atmospheric pressure : *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="averageAtmosphericPressure" name="averageAtmosphericPressure" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'averageAtmosphericPressure')}" />
                                </div><span class="txt4">m.m. of Hg</span></td>
                      </tr>
                      <tr><td class="headngblue1">Ambient temperature (*C):</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                              <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr class="headngblue">
                                   
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td><input type="text" id="ambientTemperatureFirstHour" name="ambientTemperatureFirstHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureFirstHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td><input type="text" id="ambientTemperatureSecondHour" name="ambientTemperatureSecondHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureSecondHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td><input type="text" id="ambientTemperatureThirdHour" name="ambientTemperatureThirdHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureThirdHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td><input type="text" id="ambientTemperatureFourthHour" name="ambientTemperatureFourthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureFourthHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td><input type="text" id="ambientTemperatureFifthHour" name="ambientTemperatureFifthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureFifthHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td><input type="text" id="ambientTemperatureSixthHour" name="ambientTemperatureSixthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureSixthHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td><input type="text" id="ambientTemperatureSeventhHour" name="ambientTemperatureSeventhHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureSeventhHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td><input type="text" id="ambientTemperatureEighthHour" name="ambientTemperatureEighthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'ambientTemperatureEighthHour')}" /></td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wt. Of blank filter paper : *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						 <input type="text" id="wtOfBlankFilterPaper" name="wtOfBlankFilterPaper" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'wtOfBlankFilterPaper')}" />
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wt. filter+Sample: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						   <input type="text" id="wtOfFilterAndSample" name="wtOfFilterAndSample" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'wtOfFilterAndSample')}" />
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wt. Of particulate matter: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="wtOfParticulateMatter" name="wtOfParticulateMatter" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'wtOfParticulateMatter')}" />
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Pariculate matter concentration: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="particulateMatterConcentration" name="particulateMatterConcentration" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'particulateMatterConcentration')}" />
                                </div></td>
                      </tr>
                      <tr><td class="headngblue1">B) Gases (4 hourly sampling):</td></tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Flow rate of rotameter (1 PM): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="flowRateOfRotameter" name="flowRateOfRotameter" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'flowRateOfRotameter')}" />
                                </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Net sampling time (in min): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="netSamplingTime" name="netSamplingTime" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'netSamplingTime')}" />
                                </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Total volume in Its: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						 <input type="text" id="totalVolumeInIts" name="totalVolumeInIts" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'totalVolumeInIts')}" />
                                </div></td>
                      </tr>
                        <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Horizons : *</div></td>
                        <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="horizons" name="horizons" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'horizons')}" />
                               </div></td>
                      </tr>
                      <tr><td class="headngblue1">Concentration of Gases:</td></tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >I four hourly SO2: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="oneSO" name="oneSO" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'oneSO')}" />
                                 </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >II four hourly SO2: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="twoSO" name="twoSO" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'twoSO')}" />
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >I four hourly Nox: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						    <input type="text" id="oneNox" name="oneNox" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'oneNox')}" />
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >II four hourly NOx: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						      <input type="text" id="twoNox" name="twoNox" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'twoNox')}" />
                               </div></td>
                      </tr>
                      
                     <tr><td class="headngblue1">Relative humidity (%):</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                              <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td width="100px" class="headngblue" bgcolor="#A8DAF3"><input type="text" id="relativeHumOneHour" name="relativeHumOneHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumOneHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td><input type="text" id="relativeHumTwoHour" name="relativeHumTwoHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumTwoHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td width="100px" class="headngblue" bgcolor="#A8DAF3"><input type="text" id="relativeHumThirdHour" name="relativeHumThirdHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumThirdHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td><input type="text" id="relativeHumFourthHour" name="relativeHumFourthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumFourthHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td width="100px" class="headngblue" bgcolor="#A8DAF3"><input type="text" id="relativeHumFifthHour" name="relativeHumFifthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumFifthHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td><input type="text" id="relativeHumSixthHour" name="relativeHumSixthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumSixthHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td width="100px" class="headngblue" bgcolor="#A8DAF3"><input type="text" id="relativeHumSeventhHour" name="relativeHumSeventhHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumSeventhHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td><input type="text" id="relativeHumEighthHour" name="relativeHumEighthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'relativeHumEighthHour')}" /></td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                      <tr><td class="headngblue1">Wind speed (Km/hr):</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                              <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr>
                                      <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td><input type="text" id="windSpeedOneHour" name="windSpeedOneHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedOneHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td> <input type="text" id="windSpeedTwoHour" name="windSpeedTwoHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedTwoHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td><input type="text" id="windSpeedThirdHour" name="windSpeedThirdHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedThirdHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td ><input type="text" id="windSpeedFourthHour" name="windSpeedFourthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedFourthHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td><input type="text" id="windSpeedFifthHour" name="windSpeedFifthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedFifthHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td><input type="text" id="windSpeedSixthHour" name="windSpeedSixthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedSixthHour')}" /></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td><input type="text" id="windSpeedSeventhHour" name="windSpeedSeventhHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedSeventhHour')}" /></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td><input type="text" id="windSpeedEighthHour" name="windSpeedEighthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windSpeedEighthHour')}" /></td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                      <tr><td class="headngblue1">Wind Direction :</td></tr>
                       <tr >
                        <td  width="100%" colspan="2" >
                             <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">I hr</td><td><input type="text" id="windDirectionOneHour" name="windDirectionOneHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionOneHour')}"/></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">II hr</td><td><input type="text" id="windDirectionTwoHour" name="windDirectionTwoHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionTwoHour')}"/></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">III hr</td><td><input type="text" id="windDirectionThirdHour" name="windDirectionThirdHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionThirdHour')}"/></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">IV hr</td><td><input type="text" id="windDirectionFourthHour" name="windDirectionFourthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionFourthHour')}"/></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">V hr</td><td><input type="text" id="windDirectionFifthHour" name="windDirectionFifthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionFifthHour')}"/></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VI hr</td><td> <input type="text" id="windDirectionSixthHour" name="windDirectionSixthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionSixthHour')}"/></td>
                                   </tr>
                                   <tr>
                                       <td width="100px" class="headngblue" bgcolor="#A8DAF3">VII hr</td><td><input type="text" id="windDirectionSeventhHour" name="windDirectionSeventhHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionSeventhHour')}"/></td><td width="100px" class="headngblue" bgcolor="#A8DAF3">VIII hr</td><td><input type="text" id="windDirectionEighthHour" name="windDirectionEighthHour" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windDirectionEighthHour')}"/></td>
                                   </tr>
                             </table>
                        </td>
                       
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Remarks: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						   <input type="text" id="remarks" name="remarks" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'remarks')}"/>
                                 </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Wind Pattern: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="windPattern" name="windPattern" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'windPattern')}"/>
                                </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Variations: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						       <input type="text" id="variations" name="variations" value="${fieldValue(bean:lab_AmbientAirMonitoringInstance,field:'variations')}"/>
                                 </div></td>
                      </tr>
    
	  </table>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><g:actionSubmit class="actionbutton" value="Update" /></td>
			<td align="left"><g:actionSubmit class="actionbutton" onclick="return confirm('Are you sure?');" value="Delete" /></td>
			
		  </tr>
		</table>
 			 			
            <br />
            <br />
          </div>
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
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
</table></g:form>

<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  


    frmvalidator.addValidation("totalSamplingTime","numeric","Total Sampling Time must be numeric");
    frmvalidator.addValidation("powerFailure","numeric","Power Failure must be numeric");

    frmvalidator.addValidation("initialFlowRateOfManometer","numeric","FlowRate Of Manometer initial must be numeric");
    frmvalidator.addValidation("finalFlowRateOfManometer","numeric","FlowRate Of Manometer final must be numeric");
    frmvalidator.addValidation("averageFlowRateOfManometer","numeric","FlowRate Of Manometer average must be numeric");
    frmvalidator.addValidation("initialAtmosphericPressure","numeric","Atmospheric Pressure initial must be numeric");

    frmvalidator.addValidation("finalAtmosphericPressure","numeric","Atmospheric Pressure final must be numeric");
    frmvalidator.addValidation("averageAtmosphericPressure","numeric","Atmospheric Pressure  must be numeric");
    frmvalidator.addValidation("ambientTemperatureFirstHour","numeric","Ambient Temperature I Hour must be numeric");
    frmvalidator.addValidation("ambientTemperatureSecondHour","numeric","Ambient Temperature II Hour must be numeric");

    frmvalidator.addValidation("ambientTemperatureThirdHour","numeric","Ambient Temperature III Hour Conditions must be numeric");
    frmvalidator.addValidation("ambientTemperatureFourthHour","numeric","Ambient Temperature IV Hour must be numeric");
    frmvalidator.addValidation("ambientTemperatureFifthHour","numeric","Ambient Temperature V Hour Used must be numeric");
    frmvalidator.addValidation("ambientTemperatureSixthHour","numeric","Ambient Temperature VI Hour must be numeric");

    frmvalidator.addValidation("ambientTemperatureSeventhHour","numeric","Ambient Temperature VII Hour must be numeric");
   
    frmvalidator.addValidation("ambientTemperatureEighthHour","numeric","Ambient Temperature VIII Hour must be numeric");
    frmvalidator.addValidation("wtOfBlankFilterPaper","numeric","wt Of Blank FilterPaper must be numeric");
    frmvalidator.addValidation("wtOfFilterAndSample","numeric","wt Of Filter And Sample must be numeric");
    frmvalidator.addValidation("wtOfParticulateMatter","numeric","wt Of Particulate Matter must be numeric");

    frmvalidator.addValidation("particulateMatterConcentration","numeric","Particulate Matter Concentration must be numeric");
    frmvalidator.addValidation("flowRateOfRotameter","numeric","FlowRate Of Rotameter must be numeric");
    frmvalidator.addValidation("netSamplingTime","numeric","Net Sampling Time must be numeric");
    frmvalidator.addValidation("totalVolumeInIts","numeric","Total Volume In Its must be numeric");

    frmvalidator.addValidation("horizons","req","Horizons must be numeric");
    frmvalidator.addValidation("oneSO","numeric","I hour SO2 must be numeric");
    frmvalidator.addValidation("twoSO","numeric","II hour SO2 must be numeric");
    frmvalidator.addValidation("oneNox","numeric","I hour Nox must be numeric");

    frmvalidator.addValidation("twoNox","numeric","II hour Nox Conditions must be numeric");
    frmvalidator.addValidation("relativeHumOneHour","numeric","Relative Humidity I Hour must be numeric");
    frmvalidator.addValidation("relativeHumTwoHour","numeric","Relative Humidity II Hour must be numeric");
    frmvalidator.addValidation("relativeHumThirdHour","numeric","Relative Humidity III Hour must be numeric");

    frmvalidator.addValidation("relativeHumFourthHour","numeric","Relative Humidity IV Hour must be numeric");

    frmvalidator.addValidation("relativeHumFifthHour","numeric","Relative Humidity V Hour must be numeric");
    frmvalidator.addValidation("relativeHumSixthHour","numeric","Relative Humidity VI Hour must be numeric");
    frmvalidator.addValidation("relativeHumSeventhHour","numeric","Relative Humidity VII Hour must be numeric");
    frmvalidator.addValidation("relativeHumEighthHour","numeric","Relative Humidity VIII Hour must be numeric");

    frmvalidator.addValidation("windSpeedOneHour","numeric","Wind Speed I Hr must be numeric");
    frmvalidator.addValidation("windSpeedTwoHour","numeric","Wind Speed II Hr must be numeric");
    frmvalidator.addValidation("windSpeedThirdHour","numeric","Wind Speed III Hr must be numeric");
    frmvalidator.addValidation("windSpeedFourthHour","numeric","Wind Speed IV Hr must be numeric");

    frmvalidator.addValidation("windSpeedFifthHour","numeric","Wind Speed V Hr must be numeric");
    frmvalidator.addValidation("windSpeedSixthHour","numeric","Wind Speed VI Hr must be numeric");
    frmvalidator.addValidation("windSpeedSeventhHour","numeric","Wind Speed VII Hr must be numeric");
    frmvalidator.addValidation("windSpeedEighthHour","numeric","Wind Speed VIII Hr must be numeric");


  
    frmvalidator.addValidation("dateOfSample","req","Sample Date is required");
    frmvalidator.addValidation("samplingStation","req","Sampling Station is required");
    frmvalidator.addValidation("totalSamplingTime","req","Total Sampling Time is required");
    frmvalidator.addValidation("powerFailure","req","Power Failure is required");

    frmvalidator.addValidation("initialFlowRateOfManometer","req","FlowRate Of Manometer initial is required");
    frmvalidator.addValidation("finalFlowRateOfManometer","req","FlowRate Of Manometer final"is required");
    frmvalidator.addValidation("averageFlowRateOfManometer","req","FlowRate Of Manometer average is required");
    frmvalidator.addValidation("initialAtmosphericPressure","req","Atmospheric Pressure initial is required");

    frmvalidator.addValidation("finalAtmosphericPressure","req","Atmospheric Pressure final is required");
    frmvalidator.addValidation("averageAtmosphericPressure","req","Atmospheric Pressure  is required");
    frmvalidator.addValidation("ambientTemperatureFirstHour","req","Ambient Temperature I Hour is required");
    frmvalidator.addValidation("ambientTemperatureSecondHour","req","Ambient Temperature II Hour is required");

    frmvalidator.addValidation("ambientTemperatureThirdHour","req","Ambient Temperature III Hour Conditions is required");
    frmvalidator.addValidation("ambientTemperatureFourthHour","req","Ambient Temperature IV Hour is required");
    frmvalidator.addValidation("ambientTemperatureFifthHour","req","Ambient Temperature V Hour Used is required");
    frmvalidator.addValidation("ambientTemperatureSixthHour","req","Ambient Temperature VI Hour is required");

    frmvalidator.addValidation("ambientTemperatureSeventhHour","req","Ambient Temperature VII Hour is required");
   
    frmvalidator.addValidation("ambientTemperatureEighthHour","req","Ambient Temperature VIII Hour is required");
    frmvalidator.addValidation("wtOfBlankFilterPaper","req","wt Of Blank FilterPaper is required");
    frmvalidator.addValidation("wtOfFilterAndSample","req","wt Of Filter And Sample is required");
    frmvalidator.addValidation("wtOfParticulateMatter","req","wt Of Particulate Matter is required");

    frmvalidator.addValidation("particulateMatterConcentration","req","Particulate Matter Concentration is required");
    frmvalidator.addValidation("flowRateOfRotameter","req","FlowRate Of Rotameter is required");
    frmvalidator.addValidation("netSamplingTime","req","Net Sampling Time is required");
    frmvalidator.addValidation("totalVolumeInIts","req","Total Volume In Its is required");

    frmvalidator.addValidation("horizons","req","Horizons is required");
    frmvalidator.addValidation("oneSO","req","I hour SO2 is required");
    frmvalidator.addValidation("twoSO","req","II hour SO2 is required");
    frmvalidator.addValidation("oneNox","req","I hour Nox is required");

    frmvalidator.addValidation("twoNox","req","II hour Nox Conditions is required");
    frmvalidator.addValidation("relativeHumOneHour","req","Relative Humidity I Hour is required");
    frmvalidator.addValidation("relativeHumTwoHour","req","Relative Humidity II Hour is required");
    frmvalidator.addValidation("relativeHumThirdHour","req","Relative Humidity III Hour is required");

    frmvalidator.addValidation("relativeHumFourthHour","req","Relative Humidity IV Hour is required");

    frmvalidator.addValidation("relativeHumFifthHour","req","Relative Humidity V Hour is required");
    frmvalidator.addValidation("relativeHumSixthHour","req","Relative Humidity VI Hour is required");
    frmvalidator.addValidation("relativeHumSeventhHour","req","Relative Humidity VII Hour is required");
    frmvalidator.addValidation("relativeHumEighthHour","req","Relative Humidity VIII Hour is required");

    frmvalidator.addValidation("windSpeedOneHour","req","Wind Speed I Hr is required");
    frmvalidator.addValidation("windSpeedTwoHour","req","Wind Speed II Hr is required");
    frmvalidator.addValidation("windSpeedThirdHour","req","Wind Speed III Hr is required");
    frmvalidator.addValidation("windSpeedFourthHour","req","Wind Speed IV Hr is required");

    frmvalidator.addValidation("windSpeedFifthHour","req","Wind Speed V Hr is required");
    frmvalidator.addValidation("windSpeedSixthHour","req","Wind Speed VI Hr is required");
    frmvalidator.addValidation("windSpeedSeventhHour","req","Wind Speed VII Hr is required");
    frmvalidator.addValidation("windSpeedEighthHour","req","Wind Speed VIII Hr is required");

    frmvalidator.addValidation("windDirectionOneHour","req","Wind Direction I Hour Conditions is required");
    frmvalidator.addValidation("windDirectionTwoHour","req","Wind Direction II Hour is required");
    frmvalidator.addValidation("windDirectionThirdHour","req","Wind Direction III Hour Used is required");
    frmvalidator.addValidation("windDirectionFourthHour","req","Wind Direction IV Hour is required");

    frmvalidator.addValidation("windDirectionFifthHour","req","Wind Direction V Hour is required");
    frmvalidator.addValidation("windDirectionSixthHour","req","Wind Direction VI Hour Conditions is required");
    frmvalidator.addValidation("windDirectionSeventhHour","req","Wind Direction VII Hour is required");
    frmvalidator.addValidation("windDirectionEighthHour","req","Wind Direction VIII Hour is required");
    frmvalidator.addValidation("remarks","req","remarks is required");

    frmvalidator.addValidation("windPattern","req","Wind Pattern is required");
    frmvalidator.addValidation("variations","req","Variations is required");
   </script>

</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
</HEAD>
</html>

    