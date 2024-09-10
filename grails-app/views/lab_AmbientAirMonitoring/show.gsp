
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

      String contex=request.getContextPath();

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
					<g:def var="appForWhich11" value="AIR"/>
							<g:def var="applicationId" value="${lab_AmbientAirMonitoringInstance.id}"/>
							
					<g:if test="${viewR}">
					<g:link action="viewReport" controller="labProcessingDetails" params="[docName:appForWhich11,appliId:applicationId]"><span class="innerlink">View Test Report</span></g:link>
							
					</g:if>
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
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<g:form>
                    <input type="hidden" name="id" value="${lab_AmbientAirMonitoringInstance?.id}" />
                   <input type="hidden" name="type" value="AmbientAirMonitoring" />
                   <%if(noEdit=="yes"){
		  
	  }else {%>
                   <td align="right"><g:actionSubmit class="actionbutton" value="Edit" /></td>
                    <td align="left"><g:actionSubmit class="actionbutton" onclick="return confirm('Lab Sample created with sample Id ${lab_AmbientAirMonitoringInstance?.id}?');" value="Next" action="labHandOver" /></td>
               <%} %>
                </g:form>
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
</table>



</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
</HEAD>
</html>

    