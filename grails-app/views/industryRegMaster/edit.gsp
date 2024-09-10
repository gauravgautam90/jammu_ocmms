<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.util.Calendar;"%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<g:javascript library="prototype" />



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
<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
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


var selectmenu1=document.getElementById("industryType.id").value;

if(selectmenu1 == "1234" || selectmenu1 == "1235" || selectmenu1 == "1236")
{
document.getElementById('selectTemp').style.display = 'block';
}
else{
document.getElementById('selectTemp').style.display = 'none';
}
}






// This is called when the page loads to initialize city
//var zselect = document.getElementById('category.id')
//var zopt = zselect.options[zselect.selectedIndex]
//${remoteFunction(controller:"industryRegMaster", action:"ajaxGetCities1", params:"'id=' + zopt.value", onComplete:"updateCity1(e)")}


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
		String userType = aa.accessLevel
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
                String userType = aa.accessLevel
					 if(userType.equals("admin")) { %>   

                 <g:include controller="userMaster" action="showAdminMenu"/>                                          

                 <% }else{ %>
					 <g:include controller="userMaster" action="showSpcbUserMenu"/> 
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
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aa=(UserProfile)session.getAttribute("userprof");
             		  firstname=aa.employeeFirstName;
           		  lastName=aa.employeeLastName;
           		  access=um.accessLevel;

		}	

		else
			{
				if(  (IndUser)session.getAttribute("indUser")  )

					{
						IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 indname=ind.indName;

					}	
				else
					{
						decVar=false;
						
					}
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
					<table width="100%"> <% if((UserMaster)session.getAttribute("userMaster"))
{
%>

<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
		
		<% } %>
<tr>
						<td class = "headngblue1" align="center">&nbsp;</td>
					   </tr></table>
				</td>
              </tr> 
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                     <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${industryRegMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${industryRegMasterInstance}" as="list" />
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
		
		
		
		
		<g:form action="update" name="myform"
		method="post" >
		<input type="hidden" name="id" value="${industryRegMasterInstance?.id}" />
                      <input type="hidden" name="version" value="${industryRegMasterInstance?.version}" />
		
	<!--	<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" class="print">
                           <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Industry Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="1"></td>
							  <td width="11" bgcolor="#5A89D9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="110" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country2">Occupier Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  
							  <td width="299">&nbsp;</td>
							</tr>
	    </table>
		
	-->	
	<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="70%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Industry/Hotel Information</span></a></li>
						<li><a href="#country2"><span>Occupier Details</span></a></li>
					</ol>
				  </td>
				  <td  width="30%" align="right" >
				  			
				  </td>
				</tr>		
	    </table>
		
          <div id="country1"  class="content" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				

    <tr class="headngblue txt4"  >
         <td width="40%" align="left" bgcolor="#A8DAF3" >Industry/Hotel Name:<span style="color:red">*</span></td>
         <td width="60%" align="left" bgcolor="#E8F6F9"><input name="indName" type="text" maxlength="50" value="${industryRegMasterInstance?.indName}"  class="txt4"/><span class="txt4">(max 50 characters)</span></td>
                     </tr>
  
 	  <tr>
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Industry Type:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'district','errors')} txt"><g:select optionKey="id" optionValue="industryType" noSelection="${[100:'Not Selected']}" name="industryType.id" id="industryType.id" from="${IndustryTypeMaster.list(sort:'industryType')}"
																onchange="${remoteFunction( controller:'industryRegMaster', action:'ajaxGetCities1',
																params:'\'id=\' + escape(this.value)', onComplete:'updateCity1(e)')}" value="${fieldValue(bean:industryRegMasterInstance,field:'industryType.id')}">
																	</g:select>
																		</td>
															</tr>
															
  <tr><td align="left" bgcolor="#A8DAF3" class="headngblue">
Category:<span style="color:red">*</span></td>
<td width="70%" align="left" bgcolor="#E8F6F9" >
<g:select optionKey="id" optionValue="name" name="category.id" id="category.id" 
onchange="${remoteFunction( controller:'industryRegMaster', action:'ajaxGetCities1',
params:'\'id=\' + escape(this.value)', onComplete:'updateCity1(e)')}" value="${fieldValue(bean:industryRegMasterInstance,field:'category.name')}"
>
</g:select><span class="txt4">Selected Value:-</span>
<span style="color:blue">
${fieldValue(bean:industryRegMasterInstance,field:'category.name')}</span>
</td>
</tr>

																  <tr >
																
																 
																    <td align="left" bgcolor="#A8DAF3" class="headngblue" >Commissioning Month/Year:<span style="color:red">*</span></td>
																    <td align="left" bgcolor="#E8F6F9"
																		class="value ${hasErrors(bean:industryRegMasterInstance,field:'commMonth','errors')} txt"><span
																		class="txt style6"> 
																		       <g:select class="txt4" from="${['January','Febuary','March','April','May','June','July','August','September','October','November','December']}" name="commMonth" value="${fieldValue(bean:industryRegMasterInstance,field:'commMonth')}" > </g:select> 
																</span>
																   	  <g:select class="txt4" from="${[1925,1926,1927,1928,1929,1930,1931,1932,1933,1934,1935,1936,1937,1938,1939,1940,1941,1942,1943,1944,1945,1946,1947,1948,1949,1950,1951,1952,1953,1954,1955,1956,1957,1958,1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025]}" name="dateOfComm" value="${fieldValue(bean:industryRegMasterInstance,field:'dateOfComm')}" > </g:select> 
																                               	
																       </td>
																  
																
																  
																  </tr>
  															
                                                          
  <tr class="headngblue txt4" >
    <td align="left" bgcolor="#A8DAF3">Industry Registration/License/DIC No/Department of tourism registration No./Date/Registered Authority:<span style="color:red">*</span></td>
    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indRegNum','errors')} txt4">
     
   <input
			name="indRegNum" maxlength="40" type="text"
class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'indRegNum')}" size="8"
AUTOCOMPLETE=OFF /> 
																	
<calendar:datePicker name="regDate" value="${industryRegMasterInstance.regDate}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
<input name="regAuthority" maxlength="40" type="text"
				class="txt4"
						value="${fieldValue(bean:industryRegMasterInstance,field:'regAuthority')}" size="15"
			AUTOCOMPLETE=OFF /> 
		
</td>
 </tr>

																													
	
															
			
			
			<tr class="headngblue txt4" >
           <td align="left" bgcolor="#A8DAF3">Industry Status:<span style="color:red">*</span></td>
           <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indStatus','errors')} txt4">
                                   <g:select class="txt4" from="${['operational','proposed','temporary']}" name="indStatus" value="${fieldValue(bean:industryRegMasterInstance,field:'indStatus')}" > </g:select> 
                                   <!-- <input type="text" id="indStatus" name="indStatus" value="${fieldValue(bean:industryRegMasterInstance,field:'indStatus')}" class="txt4"/> -->
                                (select current status)</td>
		

  </tr>
<tr>

    <td align="left" bgcolor="#A8DAF3" class="headngblue">Capital Investment:<span style="color:red">*</span> </td>

   <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCapInvt','errors')} txt4">
                                    <input type="text" id="indCapInvt"  onblur="calculateScale(this.value);"  name="indCapInvt" value="${fieldValue(bean:industryRegMasterInstance,field:'indCapInvt')}"  class="txt4"/>
                   (in lakhs)              </td>

  </tr>
  <tr>
	<td align="left" bgcolor="#A8DAF3" class="headngblue">Scale of Industry
	:</td>
	<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'industryScale','errors')} txt">
<div style="display:block; border:0;" id="selectTemp191" > 
	<input name="industryScale1" id="industryScale1" type="text" size="8" class="txt4" disabled value="${fieldValue(bean:industryRegMasterInstance,field:'industryScale')}"
		 AUTOCOMPLETE=OFF />
		<input type="hidden" name="industryScale" id="industryScale" value="${fieldValue(bean:industryRegMasterInstance,field:'industryScale')}"/>
						</div> </td>
	</tr>
  
  
  <!--
  <tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Capital Investment:</td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${} txt"><input
																	name="indNewCapInvt" type="text" class="txt4"
																	maxlength="25"
																	value=""
																	AUTOCOMPLETE=OFF /> (in lakhs)</td>
															</tr>
  -->

  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Address:<span style="color:red">*</span> </td>

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indAddress','errors')}">
                                    <input type="text" id="indAddress" name="indAddress" value="${fieldValue(bean:industryRegMasterInstance,field:'indAddress')}" class="txt4"/>
                                <span class="txt4">&nbsp;(enter industry address)</span></td>
  </tr>
       <tr bgcolor="#F4F7FB">
                            <td align="left" bgcolor="#A8DAF3"  class="headngblue"> Plot No./Khasara NO./ Patwari Halka No.:<span style="color:red">*</span> </td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'plotNo','errors')} txt"><input name="plotNo" type="text" class="txt4"  maxlength="25" value="${fieldValue(bean:industryRegMasterInstance,field:'plotNo')}" /><span class="txt4">&nbsp;(enter plot number)</span> </td>
                          </tr>
  
     <tr class="headngblue txt4">

    <td align="left" bgcolor="#A8DAF3">City :</td>

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indCity','errors')}">
                                    <input type="text" id="indCity" name="indCity" value="${fieldValue(bean:industryRegMasterInstance,field:'indCity')}" class="txt4"/>
                                <span class="txt4">&nbsp;(enter city of industry locality)</span></td>
  </tr>
<tr >
                            <td align="left" bgcolor="#A8DAF3"  class="headngblue"> District:<span style="color:red">*</span></td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><g:select optionKey="id" from="${districtList}" name="district.id" noSelection="${['9999':'Not Selected']}"  onclick="${remoteFunction(controller:'industryRegMaster', action:'myAjax',update:'updateSelect', params:'\'cont=\' + this.value' )}" value="${industryRegMasterInstance?.district?.id}" class="txt4" ></g:select><span class="txt4">&nbsp;(select district)</span></td>
                          </tr>
                          <tr bgcolor="#F4F7FB" >
                            <td align="left" bgcolor="#A8DAF3"  class="headngblue"> Tehsil:<span style="color:red">*</span></td>
                            <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'indName','errors')} txt"><div id="updateSelect">
							<g:select optionKey="id" from="${TehsilMaster.list()}" name="tehsil.id" id="tehsil.id" value="${industryRegMasterInstance?.tehsil?.id}"  class="txt4"></g:select><span class="txt4">&nbsp;(select tehsil)</span></td>
                          </tr>
  <tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Pin :</td>

     <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indPin','errors')}">
                                    <input type="text" id="indPin" name="indPin" value="${fieldValue(bean:industryRegMasterInstance,field:'indPin')}" class="txt4"/>
                                <span class="txt4">&nbsp;(enter PIN of industry address)</span></td>

  </tr>
  
  
  <tr   >
      <td align="left" class="headngblue"  bgcolor="#A8DAF3">Phone No. with STD Code:<span style="color:red">*</span></td>
    <td align="left"  bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indPhoneCode','errors')} txt4">
                                    <input type="text" id="indPhoneCode" name="indPhoneCode" value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneCode')}" size="10" class="txt4"/><input type="text" id="indPhoneNo" name="indPhoneNo" value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneNo')}" size="15" class="txt4"/>
              (STD Code - Number)    </td>
	</tr>
  
  
  
  <tr   >

    <td align="left" bgcolor="#A8DAF3" class="headngblue">Fax No.with Area Code :</td>

    

    <td align="left"  bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indFaxCode','errors')} txt4">
                                    <input type="text" id="indFaxCode" name="indFaxCode" size="10" value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxCode')}" class="txt4"/><input type="text" size="15" id="indFaxNo" name="indFaxNo" value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxNo')}" class="txt4"/>
                  (STD Code - Number)              </td>
  </tr>
 
  
  <tr  >

    <td align="left" class="headngblue" bgcolor="#A8DAF3">Email :</td>

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'indEmail','errors')} txt4">
                                    <input type="text" id="indEmail" name="indEmail" value="${fieldValue(bean:industryRegMasterInstance,field:'indEmail')}" class="txt4"/>
           e.g. info@abc.com                     </td>

  </tr>
  
  
  <input type="hidden" name="shiftsIndustry" value=""/>
  <input type="hidden" name="monitoring" value=""/>
  <input type="hidden" name="expNoEmp" value="0"/>
  <input type="hidden" name="noOfEmp" value="0"/>
  
  		
  
  </table>
        
          </div>

  

  
					  
					 <div id="country2" class="content print">
					 
					  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">	
						
					    <tr>
		    <td bgcolor="#FFFFFF"><table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					   
                          <tr class="headngblue txt4"  >
							   <td width="40%" align="left" bgcolor="#A8DAF3">Occupier Name:<span style="color:red">*</span></td>

							   <td align="left" width="60%" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occName','errors')}">
                                    <input type="text" id="occName" maxlength="50" name="occName" value="${fieldValue(bean:industryRegMasterInstance,field:'occName')}" class="txt4"/>
                                <span class="txt4">(maximum 50 chars)</span></td>

						</tr>

						<tr class="headngblue txt4">

								<td align="left" bgcolor="#A8DAF3">Designation:<span style="color:red">*</span> </td>

								 <td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occDesignation','errors')}">
                                    <input type="text" maxlength="25" id="occDesignation" name="occDesignation" value="${fieldValue(bean:industryRegMasterInstance,field:'occDesignation')}" class="txt4"/>
                                <span class="txt4">(designation of occupant)</span></td>

						</tr>
						
						<tr class="headngblue txt4" >

								<td align="left" bgcolor="#A8DAF3">Address : </td>

								<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occAddress','errors')}">
                                    <input type="text" id="occAddress" name="occAddress" maxlength="100" value="${fieldValue(bean:industryRegMasterInstance,field:'occAddress')}" class="txt4"/>
                                <span class="txt4">(address, max 100 chars)</span></td>

						</tr>
						
						<tr align="left" bgcolor="#F4F7FB">
																<td width="30%" bgcolor="#A8DAF3" class="headngblue">Status of Applicant:</td>
																<td width="70%" align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'statusOfAppl','errors')} txt">
																<g:select  from="${['Individual','Proprietory concern','Partnership firm','Joint Family Concern','Private Limited company','Public Limited Company','State Government','Central Government','Union Territory','Foreign Company','Any other Associate or Body']}" name="statusOfAppl" value="" class="txt4"></g:select><span class="txt4"></span></td>
															</tr>
															
														
						<tr class="headngblue txt4">
						

								<td align="left" bgcolor="#A8DAF3">City:<span style="color:red">*</span></td>

								<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occCity','errors')}">
                                    <input type="text" id="occCity" maxlength="20" name="occCity" value="${fieldValue(bean:industryRegMasterInstance,field:'occCity')}" class="txt4"/>
                                <span class="txt4">(city of address)</span></td>

						</tr>
						
				 <tr >
                <td align="left" bgcolor="#A8DAF3" class="headngblue">District:<span style="color:red">*</span></td>
                <td width="70%" align="left" bgcolor="#E8F6F9" class="txt"><div align="left" class="style6"><span class="txt style6 value ${hasErrors(bean:industryRegMasterInstance,field:'occDistrict','errors')}">
                    <input
																	name="occDistrict" type="text"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occDistrict')}"
																	maxlength="20" class="txt4" size="25" AUTOCOMPLETE=OFF />
                 </span><span class="txt4">(select district)</span></div></td>
              </tr>
              <tr bgcolor="#F4F7FB">
                <td align="left" bgcolor="#A8DAF3" class="headngblue">Tehsil:<span style="color:red">*</span></td>
                <td width="70%" align="left" bgcolor="#E8F6F9"class="txt"><div align="left"><span class="style3"><span class="style5"><span class="style6"><span class="txt4 style6">
                    <div id="updateSelect1">
                    <input
																	name="occTehsil" type="text"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'occTehsil')}"
																	maxlength="20" class="txt4" size="25" AUTOCOMPLETE=OFF />
				</span></span></span></span></div></td>
              </tr>		
						
		
  
						<tr class="headngblue txt4" >

								<td align="left" bgcolor="#A8DAF3">Pin : </td>

								<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occPin','errors')}">
                                    <input type="text" maxlength="10" id="occPin" name="occPin" value="${fieldValue(bean:industryRegMasterInstance,field:'occPin')}" class="txt4"/>
                                <span class="txt4">(PIN of occupant address)</span></td>

						</tr>
						
						

<tr class="headngblue txt4" >

    <td align="left" bgcolor="#A8DAF3">Phone No. with Area Code:<span style="color:red">*</span></td>

    

    <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occPhoneCode','errors')}">
                                    <input type="text" size="10"  id="occPhoneCode" name="occPhoneCode" value="${fieldValue(bean:industryRegMasterInstance,field:'occPhoneCode')}" class="txt4"/> <input type="text" id="occPhoneNo" name="occPhoneNo" value="${fieldValue(bean:industryRegMasterInstance,field:'occPhoneNo')}"  size="10" class="txt4"/>
     <span class="txt4">(STD Code - Number)</span></td>
	
	
 
  </tr>
						
						
						
						<tr class="headngblue txt4" >

    		<td align="left" bgcolor="#A8DAF3">Fax No. With Area Code :</td>

   				 <td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occFaxCode','errors')}">
                                    <input type="text" id="occFaxCode" name="occFaxCode" value="${fieldValue(bean:industryRegMasterInstance,field:'occFaxCode')}" size="10" class="txt4"/><input type="text" id="occFaxNo" name="occFaxNo" value="${fieldValue(bean:industryRegMasterInstance,field:'occFaxNo')}" size="10" class="txt4"/>
                <span class="txt4">(STD Code - Number)</span>                 </td>
  </tr>
						
						
						
						<tr class="headngblue txt4">

								<td align="left" bgcolor="#A8DAF3">Mobile No : </td>

								<td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occMobile','errors')}">
                                    <input maxlength="12" type="text" id="occMobile" name="occMobile" value="${fieldValue(bean:industryRegMasterInstance,field:'occMobile')}" class="txt4"/>
                                <span class="txt4">(occupant mobile no)</span></td>

						</tr>
						
						<tr class="headngblue txt4" >

								<td align="left" bgcolor="#A8DAF3">E-Mail Address:<span style="color:red">*</span> </td>

								<td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occEmail','errors')}">
                                    <input type="text" id="occEmail" name="occEmail" value="${fieldValue(bean:industryRegMasterInstance,field:'occEmail')}" class="txt4"/>
                         <span class="txt4">  e.g. info@abc.com </span></td>

						</tr>
						
						<!--
						<tr class="headngblue txt4" >

								<td align="left" bgcolor="#A8DAF3">Nationality : </td>

								<td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:industryRegMasterInstance,field:'nationality','errors')}">
                                    <input type="text" id="nationality" name="nationality" value="${fieldValue(bean:industryRegMasterInstance,field:'nationality')}" class="txt4"/>
                         </td>

						</tr>
						
						-->
						<tr align="center" bgcolor="#F4F7FB">
															<td width="30%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Directors/Partner/Proprietor with Contact Details :
															
															</td>
															<td width="40%" align="left" bgcolor="#E8F6F9"  class="txt">
																<textarea	name="nameAddressPartners" rows="5" cols="40"
																	maxlength="1000" class="txt4">${fieldValue(bean:industryRegMasterInstance,field:'nameAddressPartners')}</textarea>
															</td>
															
											
						<tr class="headngblue txt4" >

								<td align="left" bgcolor="#A8DAF3">What monitoring arrangement is currently there or proposed :</td>

								<td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:industryRegMasterInstance,field:'waterMonitoring','errors')}">
                                    <input type="text" id="waterMonitoring" name="waterMonitoring" value="${fieldValue(bean:industryRegMasterInstance,field:'waterMonitoring')}" class="txt4"/>
                         </td>

						</tr>
						
					 <tr>	 
				<td align="left" bgcolor="#A8DAF3" class="headngblue">Hint Question:<span style="color:red">*</span></td>
                <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:industryRegMasterInstance,field:'hintQuestion','errors')} txt"><div align="left" class="style6"><span class="txt style6">
                    
         <g:select from="${['What is your Nickname?','What is your Birthplace?','What was your first mobile number?','What is your first school s name?','What is your Spouse s name?']}" name="hintQuestion" value ="${fieldValue(bean:indUserInstance,field:'hintQuestion')}" class="txt4" /><span class="txt4"></span>
                    
                    
                </span></div></td>
              </tr>

        	 <tr bgcolor="#F4F7FB">
                <td align="left" bgcolor="#A8DAF3"  class="headngblue">Your Answer:<span style="color:red">*</span> </td>
                <td align="left" bgcolor="#E8F6F9"  class="value ${hasErrors(bean:indUserInstance,field:'hintAnswer','errors')} txt"><input name="hintAnswer"  maxlength="50" type="text" class="txt4" value="${fieldValue(bean:indUserInstance,field:'hintAnswer')}" /><span class="txt4">(answer of hint question)</span></td>
              </tr>
                        </table>
						</table>
          </div>
		  
		 										 <table width="95%"> <tr>
													<td width="3%">&nbsp;</td>
														<td colspan="4" align="left" class="txtR">Fields marked <span style="color:red">*</span> are mandatory</td>
													</tr>
													</table>
		  
		  
		  <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Update" value="Update" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		  
		  
		  
		  
		  
		  
		  
		  
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
    
    
    function Checkfiles(){
  
    var frm = document.forms["myform"];  
     var tehsil = document.getElementById('tehsil.id');
   	var occtehsil = document.getElementById('occTehsil');

    if((tehsil.value == "")||(tehsil.value == " "))
    {
         
   		 sfm_show_error_msg('Tehsil for Industry is not Specified',tehsil);
    	 return false;
     }
      else {
      if ((occtehsil.value == " ")||(occtehsil.value == "")){
        	sfm_show_error_msg('Tehsil for Occupier is not Specified',occtehsil);
        	return false;
 	  }          
         else{ 
		 	   return true;
			   } 
	    
	}	
	
   }
	frmvalidator.setAddnlValidationFunction("Checkfiles"); 
   frmvalidator.addValidation("indName","req","Please enter Industry Name");
 frmvalidator.addValidation("indEmail","email","Enter valid Industry email-Id");
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits");
 frmvalidator.addValidation("dateOfComm","minlen=4","year of comissioning must be 4 digits");
 frmvalidator.addValidation("dateOfComm","req","please enter year of commissioning");
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric"); 
 
  frmvalidator.addValidation("indRegNum","req","please enter industry registration no.");
  
 frmvalidator.addValidation("indCapInvt","numeric","Capital Investment of Plant & Machinery must be numeric");
  frmvalidator.addValidation("indCapInvt","req","please enter capital investment");
  
 frmvalidator.addValidation("indCity","alpha_s","check industry's city name");
 frmvalidator.addValidation("indPin","numeric","Industry's detail pin number  must be numeric");
 
  
 frmvalidator.addValidation("indPhoneNo","numeric","Industry's detail phone number  must be numeric");
 frmvalidator.addValidation("indPhoneNo","req","please enter industry's detail  phone number");
 
 frmvalidator.addValidation("indFaxNo","numeric","industry's detail fax number  must be numeric");
 
 frmvalidator.addValidation("occName","req","enter occupier Name");
 frmvalidator.addValidation("occName","alpha_s","enter valid occupier name");
 
 frmvalidator.addValidation("occDesignation","req","please enter occupier designation");
  frmvalidator.addValidation("occDesignation","alnum_s","please enter valid occupier designation");

 
 
 frmvalidator.addValidation("occCity","req","please enter occupier city");
 

 frmvalidator.addValidation("occPin","numeric","Occupier's detail pin number must be numeric");
 
 frmvalidator.addValidation("occPhoneNo","req","please enter Occupier's detail phone number");
 frmvalidator.addValidation("occPhoneNo","numeric","Occupier's detail Phone number  must be numeric");
 
 
 frmvalidator.addValidation("occFaxNo","numeric","Occupier's detail Fax number  must be numeric");
 

 frmvalidator.addValidation("occMobile","numeric","mobile number  must be numeric");
 frmvalidator.addValidation("occMobile","maxlen=11","mobile number is not valid");
 
   frmvalidator.addValidation("hintAnswer","req","please enter hint Answer");
  frmvalidator.addValidation("occEmail","req","please enter occupiers email-Id");
 frmvalidator.addValidation("occEmail","email","Enter valid occupiers email-Id");

 frmvalidator.addValidation("unitNature.id","req","Please enter unit nature");



 frmvalidator.addValidation("district.id","req","Please enter industry District");
 frmvalidator.addValidation("district.id","dontselect=0","Please enter Industry District");

 
 frmvalidator.addValidation("occDistrict","req","please enter occupier district");

 
 
 frmvalidator.addValidation("plotNo","req","please enter Plot No./Khata No.");
   
 
</script>

</body>

<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
