<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<% 
	String conte=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(conte+"/index.gsp")	;	
	 } 
%>
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
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<style type="text/css">

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

</style>







<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<% 
String cont=request.getContextPath();

String consentAppNo=indApplicationDetailsInstance.id.toString();
String cafNo=indApplicationDetailsInstance.cafUniqueNo
String serviceId=indApplicationDetailsInstance.serviceId
String applicationty="HMW"
String applicationFr="Fresh"
String appRemarks=""
String statusCode="I"
String pendingWith=""
String pendingRoleName=""
String applicationRemarks=""
String certificateUrl=""
String printAppUrl=""
String revertedUrl="https://jkocmms.nic.in/industryRegMaster/doLoginWithDetails?"+"indName="+indApplicationDetailsInstance.industryRegMasterObj.indName+"&indDistrict="+indApplicationDetailsInstance.industryRegMasterObj.district.districtName+"&serviceCode="+indApplicationDetailsInstance.serviceId+"&cafUniqueNo="+indApplicationDetailsInstance.cafUniqueNo
def appPending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=?",[indApplicationDetailsInstance.id.toString()])
if(appPending){
pendingWith=appPending.pendingWith.userProfile.employeeFirstName+" "+appPending.pendingWith.userProfile.employeeLastName
pendingRoleName=appPending.role.roleName
statusCode="P"
appRemarks="Application has been submitted"
printAppUrl="https://jkocmms.nic.in/hazardeousWasteAuthApp/viewFormPdf?appliLoc="+consentAppNo
}
if(indApplicationDetailsInstance.singleWin==true){
Response responsePush= new Response();
responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)

}



%>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF>
<table width="1003" border="0" align="center" cellpadding="0"
	cellspacing="0">
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
				<!-- code for menuIndustryHorizontal--> <% 

					if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
					controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>

				<% 

                                    if((UserMaster)session.getAttribute("userMaster")){

                                          UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                          String userType = aa.accessLevel

                                          if(userType.equals("admin")) { %>

				<g:include controller="userMaster" action="showAdminMenuHorizontal" />

				<% }else{ %> <g:include controller="userMaster"
					action="showSpcbUserMenuHorizontal" /> <%}} %> <% if( (!(IndUser)session.getAttribute("indUser") ) && 

(! (UserMaster)session.getAttribute("userMaster") )  )   {%> <g:include
					controller="userMaster" action="showIndexMenuHorizontal" /> <% } %>
				</td>
			</tr>
			<tr>
				<td align="left" valign="top">
				<table width="1003" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="224" align="left" valign="top" bgcolor="#DEEED0">
						<!-- code for menuSpcbUser--> <%

						if(  (IndUser)session.getAttribute("indUser")  )
										
										{ %> <g:include controller="userMaster" action="wasteManagementIndustryVertical"/> <%} %> <% 

                                                if((UserMaster)session.getAttribute("userMaster")){

                                                      UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                                      String userType = aa.accessLevel

                                                      if(userType.equals("admin")) { %>

						<g:include controller="userMaster" action="showAdminMenu" /> <% }else{ %>

						<g:include controller="userMaster" action="showSpcbUserMenu" /> <%}} %>
						<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
						<g:include controller="userMaster" action="showIndexMenu" /> <% } %>
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
							</tr> <%	
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
							

	<% if((UserMaster)session.getAttribute("userMaster"))
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
								
								<td height="24">
								<%if(session.getAttribute("userMaster")){%>
									<a href="#" onclick="window.open('<%=cont%>/applicationProcessingDetails/openApplicationDetails/${indApplicationDetailsInstance.id}', 'ApplicationHistory', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
								<%}%>
								<%if(viewCert){%>
									<a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=certificate&docType=pdf"><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></a>
								<%}%>
								</td>
								
								
								<td height="24">
									
								</td>
								
							</tr>
							<tr>
								<td height="0" align="center" valign="top">
								
								<!--  start confirmation by Pradeep -->
								<div align="center">
	<table border="0" width="90%" cellspacing="0" style="border-style: ridge; border-width: 0px; padding: 0" cellpadding="2">
		<tr>
			<td bgcolor="#3366CC" colspan="3">
			<font color="#FFFFFF" face="Verdana" size="2"><b>Hazardeous Application Details</b></font></td>
		</tr>
		<tr>
			<td bgcolor="#1CC7FF" colspan="3">
			<p align="center"><b><font face="Arial" size="2">Application No : 
			<font color="red"> ${fieldValue(bean:indApplicationDetailsInstance, field:'id')}  
			
			</font></font></b></td>
		</tr>
		<tr>
			<td colspan="3" bgcolor="">&nbsp;</td>
		</tr>
		<tr>
			<td align="left" width="100%" colspan="3" bgcolor="">
		<!--	<font face="Verdana" size="2" color="red"><b>Congratulations! Application submitted successfully.</b></font>   -->  </td>
		</tr>
		<tr>
			<td align="left" width="100%" colspan="3" bgcolor="">
			<span id="ctl00_ctl00_MainContent_MainCongratulation_lblCongratulationText">
			<font size="3" face="Verdana">1. Your Hazardeous Application application has been submitted for SRCUTINY of requisite documents with the Application Number </font></span>
			<font size="3" face="Verdana"><b> ${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</b>.
		<!--	<font color="#800000"><i>(Note this number for future communication 
			and know the online status of the application submitted)</i></font></font> --></td>
		</tr>
	<!--	<tr>
			<td width="100%" colspan="3" bgcolor="" align="left" >
			<font face="Verdana" size="1">Submitted application is under processing. Please send the following documents by post/by hand. You may ignore sending the documents which have been uploaded online.<br>
&nbsp;</font></td>
		</tr>
		<tr>
			<td width="100%" colspan="3" bgcolor="" height="20">
					<table width="100%" >
						<% int counter=1; %>
						<g:def var="dList" value="${DocumentChecklistMaster.list()}" />
						<g:each var="doc" in="${DocumentChecklistMaster.list()}">
						<tr>
							<width="100%" colspan="3" bgcolor="" height="20"><font face="Verdana" size="1"><%=counter%>)&nbsp;&nbsp;${doc.document}</font></td>
						</tr>
						<% counter=counter+1; %>
						</g:each>
					</table>
		</td>
	</tr>  -->
	
	<tr>
	<td align="left" width="100%" colspan="3" bgcolor="">
	<font face="Verdana" size="3">
	2. After SCRUTINY of documents is complete, you can pay the fee and re-submit the application  <br>
</font></td>
</tr>
	
	<tr>
	<td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewFormPdf?appliLoc=<%=indApplicationDetailsInstance?.id%>"><span class="headngblue">Download Form</span></a></td>
    </tr>
		

		<tr>
			<td width="100%" bgcolor="" align="center" >
				<table  width="100%" >
					<tr >
					<hr>
						<td style="border-style: ridge; border-width: 0px; padding: 0">
						<font size="1" face="Verdana">
						
							<!--added by shashank-->	
			              
						</font></td>
						<td width="50%" bgcolor="" align="center" style="border-style: ridge; border-width: 0px; padding: 0"><font size="1" face="Verdana">
					
						
						</td>
						
					</tr>
				</table><hr>
			</td>
						
		
								
		<tr>
			<td width="100%" colspan="3" bgcolor="">&nbsp;</td>
		</tr>
		<tr>
			<td width="100%" colspan="3" bgcolor="" style="border-bottom-style: none; border-bottom-width: medium">
			<p align="left"><i><b>
			<font face="Verdana" size="1" color="#663300">In case  documents have not been submitted online, kindly send the above 
			documents at the earliest to start application processing on the below address or at corresponding regional office:</font></b></i>
			<hr></td>
		</tr>
		<!--
		<tr>
			<td width="100%" colspan="3" bgcolor="" style="border-style: none; border-width: medium" height="103">
			<p align="center"><font face="Verdana" size="1"><b>
			Head Office Address<br>
			Member Secretary<br>
			State Pollution Control Board, Odisha<br>
			A//118 , Nilakantha Nagar<br>
			Unit -8, Bhubaneswar -751012</a></b></font><br><br></td>
		</tr>
		-->
	</table>
</div>
								<!--  end confirmation by Pradeep -->
								
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
</body>
</html>


