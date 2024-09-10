<%@ page import="java.text.SimpleDateFormat"%>
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
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}');
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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
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
var rselect = document.getElementById('industryType.id')

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
opt.text = tehsil.industryType
opt.value = tehsil.id
try {
if((opt.text)!="Mining and Ore beneficiation")
rselect.add(opt, null) // standards compliant; doesn't work in IE
}
catch(ex) {
if((opt.text)!="Mining and Ore beneficiation")
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
var zselect = document.getElementById('category.id')
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

if((chosenoption.value == "1234")||(chosenoption.value == "1235")||(chosenoption.value == "1236"))
{
document.getElementById('selectTemp').style.display = 'block';
}
else{
document.getElementById('selectTemp').style.display = 'none';
}
}
}
</g:javascript>

<g:javascript>
function updateCity(e) {
//alert("hhhhhhh");

//alert("e.responseText   ::"+e.responseText);
// The response comes back as a bunch-o-JSON
var cities = eval("(" + e.responseText + ")") // evaluate JSON
//alert("cities   "+cities);
if (cities) {
var rselect = document.getElementById('pendingWith')

// Clear all previous options
var l = rselect.length
//rselect.sort();
while (l > 0) {
l--
rselect.remove(l)
}
var opt1 = document.createElement('option');
opt1.text = "None"
opt1.value = "None"
opt1.selected = "selected"
for (var i=0; i < cities.length; i++) {
var pendingWith = cities[i]
var opt = document.createElement('option');
opt.text = pendingWith.roleDesc+" ("+pendingWith.roleName+")"
opt.value = pendingWith.id

try {
rselect.add(opt1, null)
rselect.add(opt, null) // standards compliant; doesn't work in IE
}
catch(ex) {
rselect.add(opt1)
rselect.add(opt) // IE only
}}}}

</g:javascript>








<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF >
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
		<g:include controller="userMaster" action="showMenu"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			
							<g:include controller="userMaster" action="showIndexMenu"/>            

                            
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>  
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" width="100%">
					<table width="100%" border="0" >
						 <tr height="10px" width="100%">
						 	<td></td>
						 	<td class="top-lnks" align="right">  </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
							
							<!--<td width="20%" align="left"><g:link controller="officeMaster" action="updateoffice" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link></td> -->
							<td width="80%">&nbsp;</td>
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
									<g:hasErrors bean="${officeMasterInstance}">
									<div class="errors">
										<g:renderErrors bean="${officeMasterInstance}" as="list" />
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
		
		
		
		
		<g:form action="saveinspectApplicationSearch" name="myform" method="post" >
		
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search Application</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
						
              
                              <td width="15%" align="left"  class="headngblue" >From Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="frmDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">To Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="toDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
                   
      
	  </table>
	  
	  
	   <table width="100%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
			
		  </tr>
 
		</table>
 			
		
		  
		
		
		</g:form>
          

          </div>	  
          </div>
          <%if(indList){%>
          <table width="110%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
          <tr ><td bgcolor="#FFFFFF" align="right">
          <a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printInspectionlPage" params="[indList:indList]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a> </td>
          </tr>
          </table>
          <%}%>
          
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">

		  <tr>
		    <td bgcolor="#FFFFFF"><table width="110%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	       
							<th class="headngblue" align="center">SI. No.</th>
							<th class="headngblue" align="center">Application No.</th>
							<th class="headngblue" align="center">Application Name</th>
							<th class="headngblue" align="center">Application Type</th>
							<th class="headngblue" align="center">Application Date</th>
							<th class="headngblue" align="center">Inspection Generated Date</th>
							<th class="headngblue" align="center">Application For</th>
							<th class="headngblue" align="center">Certificate For</th>
							<th class="headngblue" align="center">Inspection Report</th>
						 	
						 	
                   	   
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    
                    
                    
                   <%if(!indList){ %><tr><td colspan="9" height="25" align="center" class="txt4"></td></tr><%} 
                   else{
                    
                   %>
                    <g:each in="${indList}" status="i" var="aa">
                        <% 
                        
                        def appProcess = ApplicationProcessingDetails.findByApplication(aa.indApplication,[sort:'id',order:'desc'])
                        
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
                         straDate = sdfDestination.format(aa.indApplication.applicationDate);
                         String strDate=""
   						if(appProcess){
                         strDate = sdfDestination.format(appProcess.lastUpdated);
                        
                          }else{
                          	//strDate = sdfDestination.format(aa.indApplication.applicationDate);
                          
                          	strDate = "Not Forwarded"
                          }
                         	
                         	
                         String classToPick="#CD5B45";
                        
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        	<td height="25" align="center" class="txt4"><b>${i+1}.</b></td>
                        	
                           <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.indApplication%></font></b></td>
                           <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.indApplication.applicationName%></font></b></td>
                           	 <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.indApplication.applicationType%></font></b></td>
                          <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=straDate%></font></b></td>
                           	 <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=sdfDestination.format(aa.dateCreated)%></font></b></td>
                            <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.indApplication.applicationFor%></font></b></td>
                           	<td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.indApplication.certificateFor%></font></b></td>
                        	<td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>">
                        	<g:def var="fooVar" value="${aa.indApplication.id}"/><g:link action="printInspectionNote" controller="applicationProcessingDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink">View Inspection Report</span></g:link>
                        	</font></b></td>
                          	
                            
                            
                            
                        </tr>
                    </g:each>
                    <%}%>
                    </tbody>
     
     <% session.indList=indList
     System.out.println("indList.."+indList) %>
     
      </table>
      
      
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>
 
