<%@ page import="java.util.Calendar;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<g:javascript library="prototype" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.style3 {
	color: #186DB5
}

.style5 {
	color: #0099FF
}

.style6 {
	color: #33FF66;
}

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

.qwe123 {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}')
		;
	padding-left: 23px;
	padding-right: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.qwe123:hover {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' gray_bg.gif ')}')
		;
}

.blue {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_gray.gif ')}')
		;
	padding-left: 30px;
	padding-right: 27px;
	padding-top: 5px;
	padding-bottom: 7px;
}

.blue:hover {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}')
		;
}
-->
</style>
<script type="text/javascript">
 function random_number(min,max) {

		return(Math.round((max-min) * Math.random() + min));
	} 

</script>

<script type="text/javascript" src="js/tabcontent.js"></script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>
<g:javascript>
	function updateCity1(e) {

// The response comes back as a bunch-o-JSON
var cities = eval("(" + e.responseText + ")") // evaluate JSON

if (cities) {
var rselect = document.getElementById('category.id')

// Clear all previous options
var l = rselect.length

while (l > 0) {
l--
rselect.remove(l)
}



// Rebuild the select
for (var i=0; i < cities.length; i++) {
var tehsil = cities[i]
var opt = document.createElement('option');
opt.text = tehsil.name
opt.value = tehsil.id
try {
rselect.add(opt, null) // standards compliant; doesn't work in IE
}
catch(ex) {
rselect.add(opt) // IE only
}
}
}


}






// This is called when the page loads to initialize city
var zselect = document.getElementById('industryType.id')
var zopt = zselect.options[zselect.selectedIndex]
${remoteFunction(controller:"industryRegMaster", action:"ajaxGetCities1", params:"'id=' + zopt.value", onComplete:"updateCity1(e)")}
   
</g:javascript>
<g:javascript>

function select1()
{
var selectmenu1=document.getElementById("industryType.id")
selectmenu1.onchange=function()
 {    
 
   	 var chosenoption=this.options[this.selectedIndex]
        
   	 if((chosenoption.value == "8916")||(chosenoption.value == "8917")||(chosenoption.value == "8918")||(chosenoption.value == "12895")||(chosenoption.value == "12896"))
   	 {
   	 document.getElementById('selectTemp').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp').style.display = 'none';
   		 }
   }
} 
</g:javascript>

<script>
    
    function checkField(id)
    {
        if (id.value == "" )
        {
        	alert("Capital Investment can't be blank");
        	return false;
		}
        document.getElementById("indNewCapInvt").value = eval(document.getElementById("indCapInvtLand").value)+ eval(document.getElementById("indCapInvtBuilding").value)+eval(document.getElementById("indCapInvt").value);
     }
       
     
    </script>
<script>
function calculateScale(gfa)
{
if(gfa>0 && gfa<=25){
document.getElementById("industryScale").value ="Micro"
document.getElementById("industryScale1").value ="Micro"
}
if(gfa>25 && gfa<=500){
document.getElementById("industryScale").value ="Small"
document.getElementById("industryScale1").value ="Small"

}else if(gfa>500 && gfa<=1000){
document.getElementById("industryScale").value ="Medium"
document.getElementById("industryScale1").value ="Medium"

}
else if(gfa>1000){
document.getElementById("industryScale").value ="Large"
document.getElementById("industryScale1").value ="Large"
}
}
</script>
</head>

<body>
<form action="save2" method="post" id="myform" name="myform"
	enctype="multipart/form-data">
<table width="1003" border="0" align="center" cellpadding="0"
	cellspacing="0">
	


<input type="hidden" name="possibilityOfRecovery" id ="possibilityOfRecovery"/>	
<input type="hidden" name="present" id ="present"/>
<input type="hidden" name="presentdetails" id ="presentdetails"/>
<input type="hidden" name="totalCostPoll" id ="totalCostPoll"/>

	<input type="hidden" name="builtUpArea" id ="builtUpArea"/>
	<input type="hidden" name="colDistance" id ="colDistance"/>
	<input type="hidden" name="colLocation" id ="colLocation"/>
	<input type="hidden" name="colPopulation" id ="colPopulation"/>
	<input type="hidden" name="disposalSysProv" id ="disposalSysProv"/>
	<input type="hidden" name="equipDGSet" id ="equipDGSet"/>
	<input type="hidden" name="equipWithSepMeters" id ="equipWithSepMeters"/>
	<input type="hidden" name="landArea" id ="landArea"/>
	<input type="hidden" name="nearIndEstate" id ="nearIndEstate"/>
	<input type="hidden" name="nearResidCol" id ="nearResidCol"/>
	<input type="hidden" name="nearRiver" id ="nearRiver"/>
	<input type="hidden" name="nonHwmProdName" id ="nonHwmProdName"/>
	<input type="hidden" name="plotArea" id ="plotArea" value="0"/>
	<input type="hidden" name="pollutionMonitoringCost" id ="pollutionMonitoringCost"/>
	<input type="hidden" name="prodCapacity" id ="prodCapacity"/>
	<input type="hidden" name="proposalDetails" id ="proposalDetails"/>
	<input type="hidden" name="riverDist" id ="riverDist"/>
	<input type="hidden" name="riverName" id ="riverName"/>
	<input type="hidden" name="sewage" id ="sewage"/>
	<input type="hidden" name="sewageState" id ="sewageState"/>
	<input type="hidden" name="totalProjectCost" id ="totalProjectCost"/>
	<input type="hidden" name="treatedEffCapacity" id ="treatedEffCapacity"/>
	<input type="hidden" name="treePlantDev" id ="treePlantDev"/>
	<input type="hidden" name="underPubHearing" id ="underPubHearing"/>
	<input type="hidden" name="utilizeSys" id ="utilizeSys"/>
	<input type="hidden" name="wasteMinDetail" id ="wasteMinDetail"/>
	<input type="hidden" name="sewage" id ="sewage"/>
	<input type="hidden" name="pollutionMonitoringCost" id ="pollutionMonitoringCost" value="0"/>
	<input type="hidden" name="totalProjectCost" id ="totalProjectCost" value="0"/>
	<input type="hidden" name="hotelArea" id="hotelArea"/>
	<input type="hidden" name="totalPlotArea" id="totalPlotArea"/>
	
	

	
	<tr>
		<td align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="91" align="left" valign="top" class="bgtop"><!-- code for spcbHeader  -->
				<g:include controller="userMaster" action="showSpcbHeader" /></td>
			</tr>
			<tr>
				<td height="32" align="left" valign="top"
					background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
				<!-- code for menuAdminHorizontal--> <% 
				if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
					controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
				<% 
 		if((UserMaster)session.getAttribute("userMaster")){
 		UserMaster aa = (UserMaster)session.getAttribute("userMaster");
		String userType = aa.accessLevel;
		 if(userType.equals("admin")) { %> <g:include controller="userMaster"
					action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
					controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
				<% if( (!(IndUser)session.getAttribute("indUser") ) && 
		      (! (UserMaster)session.getAttribute("userMaster") )  )   {%> <g:include
					controller="userMaster" action="showIndexMenuHorizontal" /> <% } %>
				
			</tr>
			<tr>
				<td align="left" valign="top">
				<table width="1003" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="224" align="left" valign="top" bgcolor="#DEEED0">
						<!-- code for menuAdmin--> <%
				if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
							controller="userMaster" action="showSpcbIndustryMenu" /> <%} %> <% 

                 if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                String userType = aa.accessLevel
					 if(userType.equals("admin")) { %> <g:include
							controller="userMaster" action="showAdminMenu" /> <% }else{ %> <g:include
							controller="userMaster" action="showSpcbUserMenu" /> <%}} %> <% if( (!(IndUser)session.getAttribute("indUser") ) && 
							(! (UserMaster)session.getAttribute("userMaster") )  )   {%> <g:include
							controller="userMaster" action="showIndexMenu" /> <% } %>
						</td>
						<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
						<td width="778" align="left" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="1" valign="top"></td>
							</tr>
							<tr>
								<td><img
									src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778"
									height="134" /></td>
							</tr>
							<%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster")){ 
            UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  	UserProfile aa=(UserProfile)session.getAttribute("userprof");
            firstname=aa.employeeFirstName;
           	lastName=aa.employeeLastName;
           	access=um.accessLevel;
       }else if((IndUser)session.getAttribute("indUser")){
			IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
           	indname=ind.indName;
		}else{
			decVar=false;
		}
	
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

									<% if((UserMaster)session.getAttribute("userMaster"))
{
%>

									<tr bgcolor="#4C8BC0">
										<td class="top-lnks">
										<table width="100%">
											<tr height="10px">
												<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
												<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %>
												</td>
											</tr>
										</table>
										</td>
									</tr>

									<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
									<tr bgcolor="#4C8BC0">
										<td class="top-lnks">
										<table width="100%">
											<tr height="10px">
												<td>Welcome <%=indname %></td>
												<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %>
												</td>
											</tr>
										</table>
										</td>
									</tr>

									<% } %>
									<tr>
										<td>&nbsp;</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td height="0" align="left" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<!-- Div area for errors-->
										<td align="left" valign="top">
									<span	class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
											<g:hasErrors bean="${industryRegMasterInstance}">
											<div class="errors">
												<g:renderErrors bean="${industryRegMasterInstance}" as="list" />
											</div>
											</g:hasErrors></span>
										</td>
									</tr>

									<!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
									<tr>
										<td height="0" align="left" valign="top">
										<table width="778" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="82" align="left" valign="top">&nbsp;</td>
												<td align="left" valign="top">
												<div style="padding: 0px 0px 0px 0px;"><br />
												<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
												<!--	<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Industry Information </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="1"></td>
							  <td width="11" bgcolor="#5A89D9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="110" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country2">Occupier Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  
							  <td width="299">&nbsp;</td>
							</tr>
	    </table> -->

												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr valign="middle">
														<td width="70%" align="center">

														<ol id="toc">
															<li><a href="#country1"><span>Industry/Hotel Information</span></a></li>
															<li><a href="#country2"><span>Occupier
															Details</span></a></li>
														</ol>
														</td>
														<td width="30%" align="right"></td>
													</tr>
												</table>
												<div id="country1" class="content">
												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4">

													<tr>
														<td valign="top" bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">
															<tr align="center" bgcolor="#F4F7FB">
																<td width="30%" align="right" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">
																Industry/Hotel Name<span style="color:red">*</span>:</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input
																	name="indName" type="text" class="txt4" readonly
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indName')}"
																	maxlength="50" size="25" AUTOCOMPLETE=OFF /> (max 50
																characters)</td>
															</tr>
															
																														<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Industry/Hotel Address<span style="color:red">*</span>:</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indAddress','errors')} txt">
																	<input type="text"
																	name="indAddress"readonly
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indAddress')}"
																	maxlength="200" class="txt4">&nbsp;(enter
																industry address)</td>
															</tr>

															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Plot No./Khasara NO./ Patwari Halka No.<span style="color:red"></span>:</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'plotNo','errors')} txt"><input
																	name="plotNo" type="text" class="txt4" maxlength="25"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'plotNo')}"
																	AUTOCOMPLETE=OFF /> &nbsp;(enter plot number)</td>
															</tr>


															<tr bgcolor="#F4F7FB" >
															<td align="right" bgcolor="#A8DAF3" class="headngblue">
															Village/City <span style="color:red">*</span>:</td>
															<td align="left" bgcolor="#E8F6F9"
																class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCity','errors')} txt"><input
																name="indCity" type="text"
																value="${fieldValue(bean:industryRegMasterInstance,field:'indCity')}"
																maxlength="25" class="txt4" AUTOCOMPLETE=OFF />&nbsp;(enter
															village/city of industry locality)</td>
															</tr>
															
															<!---<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																District:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'district','errors')} txt"><g:select
																	optionKey="id" from="${DistrictMaster.list(sort:'districtName')}"
																	name="district.id"
																	noSelection="${[9999:'Not Selected']}"
																	onchange="${remoteFunction(controller:'industryRegMaster', action:'myAjax',update:'updateSelect', params:'\'cont=\' + this.value' )}"
																	value=""
																	class="txt4"></g:select>&nbsp;(select district)</td>
															</tr>---->
															
															<tr >
															<td align="right" bgcolor="#A8DAF3" class="headngblue">
															District :<span style="color:red">*</span></td>
															<td align="left" bgcolor="#E8F6F9"
																class="value ${hasErrors(bean:industryRegMasterInstance,field:'district','errors')} txt"><input
																name="district" maxlength="6" type="text" 
																value="${fieldValue(bean:industryRegMasterInstance,field:'district')}"
																class="txt4" AUTOCOMPLETE=OFF readonly/>
																</td>
														</tr>
															
															
															
														
													<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Tehsil:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'tehsil','errors')} txt">
																<div id="updateSelect"><g:select optionKey="id"
																	from="${tehsilList}" name="tehsil.id" id="tehsil.id"
																	value="${industryRegMasterInstance?.tehsil?.id}"
																	class="txt4"></g:select>&nbsp;(enter industry tehsil)
																</td>
															</tr>


										


															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Pin :</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indPin','errors')} txt"><input
																	name="indPin" maxlength="6" type="text" size="8"  
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indPin')}"
																	class="txt4" AUTOCOMPLETE=OFF />&nbsp;(enter PIN of
																industry address)</td>
															</tr>
															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Phone Number<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9" 
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','indPhoneCode')} txt">

																<input name="indPhoneCode" type="text" class="txt4" 
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneCode')}"
																	size="8" maxlength="6" AUTOCOMPLETE=OFF /> <input name="indPhoneNo" 
																	type="text" class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneNo')}"
																	size="10" maxlength="8" AUTOCOMPLETE=OFF /> (STD Code - Number)</td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Fax No. With Code :</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','indFaxNo')} txt">

																<input name="indFaxCode" type="text" class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxCode')}"
																	size="8" maxlength="6" AUTOCOMPLETE=OFF /> <input name="indFaxNo"
																	maxlength="10" type="text"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxNo')}"
																	class="txt4" maxlength="8" size="10" AUTOCOMPLETE=OFF /> </td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																E-Mail Address :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indEmail','errors')} txt">
																<input name="indEmail" maxlength="100" type="text" readonly
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indEmail')}"
																	size="20" AUTOCOMPLETE=OFF /> e.g. info@abc.com</td>
															</tr>
															<tr align="center" bgcolor="#E8F6F9" >
															<td width="30%" align="right" bgcolor="#A8DAF3" class="headngblue">Capital Investment (in lakhs)<span style="color:red">*</span></td>
													<td align="left"class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCapInvt','errors')} txt">
														
																				
														<input name="indCapInvt" id="indCapInvt"   type="text" class="txt4"
																maxlength="20"
															 onblur="calculateScale(this.value);"
																AUTOCOMPLETE=OFF size="20" />
													</td>	
														</tr>
														<!--<tr bgcolor="#F4F7FB">
															
															<td align="center" bgcolor="#E8F6F9" colspan="2">
															<table>
														
														<tr><td align="center"class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCapInvt','errors')} txt">
														<span  style="color:red">*</span>
														
														<br>
														
														<input
																name="indCapInvt" id="indCapInvt" onclick="this.value=''"  onblur="checkField(this)"  type="text" class="txt4"
																maxlength="20"
																value="0"
																AUTOCOMPLETE=OFF size="20" />
													</td>
												
												<td align="center" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCapInvtLand','errors')} txt">
													(Land)
													<br>
													<input
																name="indCapInvtLand" id="indCapInvtLand" onclick="this.value=''"  onblur="checkField(this)"  type="text" class="txt4"
																maxlength="20"
																value="0"
																AUTOCOMPLETE=OFF size="13"/>
														
														</td>
													<td align="center" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCapInvtBuilding','errors')} txt">
													(Building)
													<br>
													<input
																name="indCapInvtBuilding" id="indCapInvtBuilding" onclick="this.value=''"  onblur="checkField(this)"  type="text" class="txt4"
																maxlength="20"
																value="0"
																AUTOCOMPLETE=OFF size="13"/>
														
														</td>
														<td align="center" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indNewCapInvt','errors')} txt">
													(Total)
													<br>
													<input
																name="indNewCapInvt" id="indNewCapInvt" onblur="checkField(this)"  type="text" class="txt4"
																maxlength="20" readonly
																AUTOCOMPLETE=OFF size="13"/>
														
														</td>
													
													</tr>
													
														</table>
														</td>
														
														</tr>-->
														
															<tr>
														<td align="right" bgcolor="#A8DAF3" class="headngblue">Scale of Industry
														:</td>
														<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'industryScale','errors')} txt">
													 <div style="display:block; border:0;" id="selectTemp191" > 
														<input name="industryScale1" id="industryScale1" type="text" size="8" class="txt4" disabled value="${fieldValue(bean:industryRegMasterInstance,field:'industryScale')}"
															 AUTOCOMPLETE=OFF />
															<input type="hidden" name="industryScale" id="industryScale" value="${fieldValue(bean:industryRegMasterInstance,field:'industryScale')}"/>
																			</div> </td>
														</tr>

		
													
													       </tr>
															<tr >
															<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Industry Type<span style="color:red">*</span>:</td>
															<td align="left" bgcolor="#E8F6F9"
															class="value ${hasErrors(bean:industryRegMasterInstance,field:'district','errors')} txt"><g:select optionKey="id" optionValue="industryType" noSelection="${[100:'Not Selected']}" name="industryType.id" id="industryType.id" from="${IndustryTypeMaster.list(sort:'industryType')}"
															onchange="${remoteFunction( controller:'industryRegMaster', action:'ajaxGetCities1',
														params:'\'id=\' + escape(this.value)', onComplete:'updateCity1(e)')}" value="${fieldValue(bean:industryRegMasterInstance,field:'industryType.id')}" style='width:350px;'>
																	</g:select>
																		</td>
																		
																		
																	
																	 
																		
															</tr>

														  
														<tr><td align="right" bgcolor="#A8DAF3" class="headngblue">
Category<span style="color:red">*</span>:</td>
<td width="70%" align="left" bgcolor="#E8F6F9" >
<g:select optionKey="id" optionValue="name" name="category.id" id="category.id" noSelection="${[100:'Not Selected']}"
 value="${fieldValue(bean:industryRegMasterInstance,field:'category.id')}"
>
</g:select></td>
</tr>

													
													
															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Industry
																Status:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indStatus','errors')} txt"><span
																	class="txt style6"> <select name="indStatus"
																	class="txt4">

																	<option value="operational">Operational</option>
																	<option value="proposed">Proposed</option>
																	<option value="closed">Closed</option>

																</select></span>(select current status)</td>
															</tr>
															
																<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue ">Commissioning
																Month/Year :</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'commMonth','errors')} txt"><span
																	class="txt style6"> <select name="commMonth"
																	class="txt4">

																	<option value="january">January</option>
																	<option value="February">February</option>
																	<option value="March">March</option>
																	<option value="April">April</option>
																	<option value="May">May</option>
																	<option value="June">June</option>
																	<option value="July">July</option>
																	<option value="Auguest">Auguest</option>
																	<option value="September">September</option>
																	<option value="October">October</option>
																	<option value="November">November</option>
																	<option value="December">December</option>
				
																</select></span>
																					
								 <g:select class="txt4" from="${[1925,1926,1927,1928,1929,1930,1931,1932,1933,1934,1935,1936,1937,1938,1939,1940,1941,1942,1943,1944,1945,1946,1947,1948,1949,1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025]}" name="dateOfComm" value="${fieldValue(bean:industryRegMasterInstance,field:'dateOfComm')}" > </g:select> 
                               		 					
																
																</td>
															</tr>
															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Industry Registration/
																License/DIC No/Department of tourism registration No./Date/Registered Authority : </td>
																<td align="left" bgcolor="#E8F6F9">
																	<input
																	name="indRegNum" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'indRegNum')}" size="8"
																	AUTOCOMPLETE=OFF /> 
																	
																	<calendar:datePicker name="regDate" class="value ${hasErrors(bean:industryRegMasterInstance,field:'regDate','errors')} txt" size="10" years="1900,2500" dateFormat="%m/%d/%Y" defaultValue="${new Date()}"/>
																	<input
																	name="regAuthority" maxlength="250" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'regAuthority')}" size="10"
																	AUTOCOMPLETE=OFF /> 
																</td>
															</tr>
																			
																
																			
															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Expected Date of Production :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'expDate','errors')} txt">
																	  <calendar:datePicker name="expDate" dateFormat="%d/%m/%Y" years="1900,2500" defaultValue="${new Date()}"/>
																</td>
															</tr>
															
															
															
															
															
															<input type="hidden" name="shiftsIndustry" value=""/>
															<input type="hidden" name="monitoring" value=""/>
															<input type="hidden" name="expNoEmp" value="0"/>
															<input type="hidden" name="noOfEmp" value="0"/>
															<input type="hidden" name="waterMonitoring" value=""/>
															<input type="hidden" name="siteArea" value=""/>
															
															
															
															
															<tr bgcolor="#F4F7FB">
																<g:if test="${industryRegMaster1}">


																	<td align="right" bgcolor="#A8DAF3" class="headngblue">
																	Surrounding of Site (within 500 meters):</td>


																	<td width="70%" align="left" bgcolor="#E8F6F9"
																		class="value ${hasErrors(bean:industryRegMasterInstance1,field:'indName','errors')} ">
																	<table>
																		

																		<tbody>
																		<tr>
																			
																			<td align="center" class="headngblue">Name :</td>
																			
																			<td align="center" class="headngblue">Description:</td>
																			
																			<td align="center" class="headngblue">Distance in Meters:</td>
																		</tr>
																			<g:each in="${industryRegMaster1}" status="i"
																				var="industryRegMaster">
																				<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
																				<tr>
																					<td class="txt"><input type="checkbox"
																						name="${industryRegMaster.surroundingName}"
																						id="check1" />${fieldValue(bean:industryRegMaster,
																					field:'surroundingName')}</td>
																					<td><input type="text" name="description"
																						value="" size="12" maxlength="100" class="txt4"></td>
																					<td><input type="text" name="distance"
																						value="" size="12" class="txt4"></td>
																				</tr>
																				

																			</g:each>
																		</tbody>
																		</td>
																		</tr>
																		</table>
																		</g:if>
																		
																	
															</tr>
															
															
														</table>
														</td>
													</tr>




												</table>

												</div>
												<div id="country2" class="content">
												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
													style="border-collapse: collapse;">

													<tr>
														<td bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">
															<tr align="center" bgcolor="#F4F7FB">
																<td width="30%" align="right" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">Occupier
																Name:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occName','errors')} txt"><input
																	name="occName" type="text" class="txt4" readonly
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occName')}"
																	maxlength="50" size="25" AUTOCOMPLETE=OFF /><span
																	class="txt4">(maximum 50 chars)</span></td>
															</tr>
															
															<tr align="center" bgcolor="#F4F7FB">
																<td width="30%" align="right" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">Designation
																:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occDesignation','errors')} txt"><input
																	name="occDesignation" type="text" class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occDesignation')}"
																	maxlength="25" size="25" AUTOCOMPLETE=OFF /><span
																	class="txt4">(designation of occupant)</span></td>
															</tr>
															
															
															<tr align="center" bgcolor="#F4F7FB">
																<td width="30%" align="right" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">Residential Address :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occAddress','errors')} txt"><input
																	name="occAddress" type="text" class="txt4" readonly
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occAddress')}"
																	maxlength="100" size="25" AUTOCOMPLETE=OFF /><span
																	class="txt4">(address, max 100 chars)</span></td>
															</tr>
															
															
														
															
															<tr align="center" bgcolor="#F4F7FB">
																<td width="30%" align="right" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">Village/City:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occCity','errors')} txt"><input
																	name="occCity" type="text"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occCity')}"
																	maxlength="20" class="txt4" size="25" AUTOCOMPLETE=OFF /><span
																	class="txt4">(village/city of address)</span></td>
															</tr>
															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">District :<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="txt">
																<div align="left" class="style6"><span
																	class="txt style6 value ${hasErrors(bean:industryRegMasterInstance,field:'occDistrict','errors')}">
																	
																	<input
																	name="occDistrict" type="text"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occDistrict')}"
																	maxlength="20" class="txt4" size="25" AUTOCOMPLETE=OFF />
																	
																 </span><span class="txt4">(write
																district)</span></div>
																</td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Tehsil:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="txt">
																<div align="left"><span class="style3"><span
																	class="style5"><span class="style6"><span
																	class="txt4 style6">
																<div id="updateSelect1">
																<input
																	name="occTehsil" type="text"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occTehsil')}"
																	maxlength="20" class="txt4" size="25" AUTOCOMPLETE=OFF />
																	
																
															<span class="txt4">(select
																tehsil)</span></div>
																</span></span></span></span></div>
																</td>
															</tr>

															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Pin:
																</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occPin','errors')} txt"><input
																	name="occPin" maxlength="6" type="text" class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occPin')}"
																	AUTOCOMPLETE=OFF /><span class="txt4">(PIN of
																occupant address)</span></td>
															</tr>
														<!--	<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Nationality :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'nationality','errors')} txt">
																<input name="nationality" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'nationality')}"
																	size="20" AUTOCOMPLETE=OFF /></td>
															</tr> -->
															<input name="nationality" maxlength="100" type="hidden"/>
															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Phone No. With Code:<span style="color:red"></span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occPhoneCode','errors')} txt">
																<input name="occPhoneCode" type="text" maxlength="6"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occPhoneCode')}"
																	size="8" AUTOCOMPLETE=OFF /> <input name="occPhoneNo"
																	type="text" maxlength="10" class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occPhoneNo')}"
																	size="10" AUTOCOMPLETE=OFF /> <span class="txt4">(STD
																Code - Number)</span></td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																Fax No. With Code :</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occFaxCode','errors')} txt">
																<input name="occFaxCode" type="text" maxlength="6"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occFaxCode')}"
																	size="8" AUTOCOMPLETE=OFF /> <input name="occFaxNo"
																	type="text" class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occFaxNo')}"
																	size="10" maxlength="8" AUTOCOMPLETE=OFF /> <span
																	class="txt4"> (STD Code - Number)</span></td>
															</tr>

															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Mobile
																No:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occMobile','errors')} txt"><input
																	name="occMobile" maxlength="10" type="text"
																	class="txt4" size="12" readonly
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occMobile')}"
																	AUTOCOMPLETE=OFF /><span class="txt4">(occupant
																mobile no)</span></td>
															</tr>

															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">
																E-Mail Address:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'occEmail','errors')} txt">
																<div align="left" class="style6"><input
																	name="occEmail" type="text" maxlength="100"
																	class="txt4" size="25" readonly
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occEmail')}"
																	AUTOCOMPLETE=OFF /><span class="txt4"> e.g.
																info@abc.com </span></div>
																</td>
															</tr>
															<tr align="center" bgcolor="#F4F7FB">
																<td width="30%" align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status of Applicant:</td>
																<td width="70%" align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'statusOfAppl','errors')} txt">
																<g:select  from="${['Individual','Proprietory concern','Partnership firm','Joint Family Concern','Private Limited company','Public Limited Company','State Government','Central Government','Union Territory','Foreign Company','Any other Associate or Body']}" name="statusOfAppl" value="" class="txt4"></g:select><span class="txt4"></span>
																</td>
															</tr>
															<tr align="center" bgcolor="#F4F7FB">
															<td width="30%" align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Directors/Partner/Proprietor with Contact Details :
															
															</td>
															<td width="40%" align="left" bgcolor="#E8F6F9"  class="txt">
																<textarea
																	name="nameAddressPartners" rows="5" cols="45" 
																	maxlength="1000" class="txt4">${fieldValue(bean:industryRegMasterInstance,field:'nameAddressPartners')}</textarea>
															</td>
															
															</tr>
															
																														

															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Hint
																Question:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'hintQuestion','errors')} txt">
																<div align="left" class="style6"><span
																	class="txt style6"> <select name="hintQuestion"
																	class="txt4">

																	<option value="What is your Nickname?">What is
																	your Nickname?</option>
																	<option value="What is your Birthplace?">What
																	is your Birthplace?</option>
																	<option value="What was your first mobile number?">What
																	was your first mobile number?</option>
																	<option value="What is your first school's name ?">What
																	is your first school's name ?</option>
																	<option value="What is your Spouse's name?">What
																	is your Spouse's name?</option>
																</select> </span><span class="txt4">(select question)</span></div>
																</td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Your
																Answer:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:indUserInstance,field:'hintAnswer','errors')} txt"><input
																	name="hintAnswer" maxlength="50" type="text"
																	class="txt4"
																	value="${fieldValue(bean:indUserInstance,field:'hintAnswer')}"
																	AUTOCOMPLETE=OFF /><span class="txt4">(answer
																of hint question)</span></td>
															</tr>


															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Click
																to generate Password:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input
																	name="submit" type="button" id="#" value="Generate"
																	class="txt4"
																	onclick="document.myform.passwordEncrypt.value=Math.round((99999-10000)*Math.random() +10000 )" /><span
																	class="txt4"> Click here to generate password</span></td>

															</tr>

															<tr bgcolor="#F4F7FB">
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Generated
																Password:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'password','errors')} txt"><input
																	name="password" id="password" type="hidden" readonly
																	class="txt4" value="" /><input name="passwordEncrypt"
																	id="passwordEncrypt" type="text" readonly class="txt4"
																	value="<%=Math.round((Math.random()+100000)*Math.random())%>"
																	size="20" /> <span class="txt4"> This is one
																time password</span></td>
															</tr>
															
															

														<!--	<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Nature
																of Unit:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'unitNature.id','unitNature')} txt"><g:select
																	name='unitNature.id' from="${UnitNatureMaster.list()}"
																	optionKey='id'>
																</g:select></td>
															</tr> 

															<tr>
																<td align="right" bgcolor="#A8DAF3" class="headngblue">Document,
																if any:<br>
																</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><input
																	type="file" id="payload" name="payload"
																	onkeydown="this.blur();" /> <span class="sidetxt ">(.pdf,.jpg,.jpeg,.gif
																max of 2MB in size) </span></td>
															</tr>
 																	-->
															<!----<tr class="headngblue">

																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Do you want to send login Credential in mail?</td>

																<td align="left" bgcolor="#E8F6F9"><g:radio
																	name="radiobutton" value="yes" />yes <g:radio
																	checked="true" name="radiobutton" value="no" />no <span
																	class="txt4"> (Click Yes to email registration
																details)</span></td>
															</tr>
      ---------------------->
														</table>
														</td>
													</tr>
													
												</table>



												</div>
												</div>

 											<table width="95%"> 
 											<tr>
													<td width="15%">&nbsp;</td>
														<td colspan="4" align="left" class="txtR">Fields marked <span style="color:red">*</span> are mandatory</td>
													</tr>
													</table>

												<table width="95%">
												
													
													<tr>
														<td  align="right"><input type="submit" name="save"
															onclick="industryPassEncryption()" value="Save"
															class="actionbutton"></td>
														<td align="left"><input type="reset" name="reset"
															value="Reset" class="actionbutton"></td>
													</tr>
												</table>







												<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script></div>
												</td>
												<td width="132" align="left" valign="top">&nbsp;</td>
											</tr>
										</table>
										</td>
									</tr>

								</table>
								</td>
							</tr>

						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<!-- code for spcb Footer -->
			<g:include controller="userMaster" action="showSpcbFooter" />
		</table>
		</td>
	</tr>
</table>
</form>

<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  


   
	
 frmvalidator.addValidation("indName","req","Please enter Industry Name");
  frmvalidator.addValidation("indName","alpha_s","enter valid Industry Name");
 
 frmvalidator.addValidation("indEmail","email","Enter valid Industry email-Id");
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits ");
 frmvalidator.addValidation("dateOfComm","minlen=4","year of comissioning must be 4 digits ");
 //frmvalidator.addValidation("dateOfComm","req","please enter year of commissioning");
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric"); 
 
 // frmvalidator.addValidation("indRegNum","req","please enter industry registration no.");
  
 frmvalidator.addValidation("indCapInvt","decimal","capital investment must be numeric or decimal");
  frmvalidator.addValidation("indCapInvt","req","please enter capital investment");
  frmvalidator.addValidation("indCapInvtLand","decimal","capital investment of Land  must be numeric or decimal");
 
  		 frmvalidator.addValidation("indCapInvtBuilding","decimal","capital investment of building must be numeric or decimal");
   
   
   frmvalidator.addValidation("noOfEmp","numeric","total number of workers must be numeric");
 frmvalidator.addValidation("indCity","alpha_s","check industry's city name");
 frmvalidator.addValidation("indCity","req","Please Enter Village Name");

 frmvalidator.addValidation("indPin","numeric","Industry's Detail pin number  must be numeric");
 // frmvalidator.addValidation("indPin","req","Please enter  Industry Detail pin number");
 
 frmvalidator.addValidation("indAddress","req","please enter Industry Address");
 
 frmvalidator.addValidation("indNewCapInvt","req","please enter Capital Investment");
 
 frmvalidator.addValidation("indPhoneNo","numeric","Industry's Detail phone number  must be numeric");
 frmvalidator.addValidation("indPhoneNo","req","please enter Industry's Detail phone number");
 
 frmvalidator.addValidation("indFaxNo","numeric","Industry's Detail fax number  must be numeric");
 
 frmvalidator.addValidation("occName","req","please enter occupier Name");
 frmvalidator.addValidation("occName","alpha_s","enter valid occupier name");
 
 frmvalidator.addValidation("occDesignation","req","please enter occupier designation");
  frmvalidator.addValidation("occDesignation","alnum_s","please enter valid occupier designation");

 
 
 frmvalidator.addValidation("occCity","req","please enter occupier city");
 
//frmvalidator.addValidation("occPin","req","please enter Occupier's pin number");
 frmvalidator.addValidation("occPin","numeric","Occupier's detail Pin number  must be numeric");
// frmvalidator.addValidation("occPin","minlen=6","Occupier pin must be 6 digit"); 
 frmvalidator.addValidation("occPin","maxlen=6","Occupier pin must be 6 digit");  
 //frmvalidator.addValidation("occPhoneNo","req","please enter Occupier's detail phone number");
 frmvalidator.addValidation("occPhoneNo","numeric","Occupier's detail Phone number  must be numeric");
 
 frmvalidator.addValidation("occFaxNo","numeric","Occupier's detail Fax number  must be numeric");
 
 frmvalidator.addValidation("occMobile","req","Please enter Occupier's detail mobile number");

 frmvalidator.addValidation("occMobile","numeric","Occupier's detail mobile number  must be numeric");
 frmvalidator.addValidation("occMobile","minlen=10","Occupier mobile must be 10 digit");
 frmvalidator.addValidation("occMobile","maxlen=10","Occupier mobile must be 10 digit");
 
  
  frmvalidator.addValidation("occEmail","req","please enter occupiers email-Id");
 frmvalidator.addValidation("occEmail","email","Enter valid occupiers email-Id");

 frmvalidator.addValidation("unitNature.id","req","Please enter unit nature");
 frmvalidator.addValidation("hintAnswer","req","please enter hint Answer");
 


  frmvalidator.addValidation("industryType.id","req","please enter Industry Type");
 
 frmvalidator.addValidation("district.id","req","Please enter industry District");
 frmvalidator.addValidation("district.id","dontselect=0","Please enter Industry District");

 frmvalidator.addValidation("occDistrict.id","dontselect=0","Please enter Occupier District");
 frmvalidator.addValidation("occDistrict","req","please enter occupier district");

frmvalidator.addValidation("expNoEmp","req","please enter total number of office staff");
 frmvalidator.addValidation("expNoEmp","numeric","total number of office staff must be numeric");
 
 //frmvalidator.addValidation("plotNo","req","please enter Plot No./Khata No.");


   
</script>



</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


