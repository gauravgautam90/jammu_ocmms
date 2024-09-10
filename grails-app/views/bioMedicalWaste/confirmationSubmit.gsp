<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
%>
<%
String consentAppNo=indApplicationDetailsInstance.id.toString();
String cafNo=indApplicationDetailsInstance.cafUniqueNo
String serviceId=indApplicationDetailsInstance.serviceId

String applicationty="BMW"
String applicationFr=""
	if(indApplicationDetailsInstance.authorisationAppliedFor=="fresh"){
		applicationFr="Fresh"
	}else if(indApplicationDetailsInstance.authorisationAppliedFor=="renew")
		{
			applicationFr="Renew"
		}
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
printAppUrl="https://jkocmms.nic.in/bioMedicalWaste/viewBmwPdf?appliLoc="+consentAppNo
}
if(indApplicationDetailsInstance.singleWin==true){
Response responsePush= new Response();
responsePush.sendStatus(consentAppNo,cafNo,serviceId,applicationty,applicationFr,statusCode,appRemarks,pendingWith,pendingRoleName,printAppUrl,revertedUrl,certificateUrl)
}               
		    	
%>
</head>

<body>
	<table id="" width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="91" align="left" valign="top" class="bgtop">
								<!-- code for spcbHeader  -->
								<g:include controller="userMaster" action="showSpcbHeader" />
							</td>
						</tr>
						<tr>
							<td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
								<!-- code for menuAdminHorizontal-->
								<% 
									if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									<% 
 									if((UserMaster)session.getAttribute("userMaster")){
 									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType = aa.accessLevel;
									if(userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
									controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
									<% 
									if( (!(IndUser)session.getAttribute("indUser") ) && 
		      						(! (UserMaster)session.getAttribute("userMaster") )  )   {
		      						%> 
		      						<g:include controller="userMaster" action="showIndexMenuHorizontal" />
		      			 			<% 
		      			 			} 
		      					%>
							</td>
						</tr>
						<tr>
							<td align="left" valign="top">
								<table width="1003" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="224" align="left" valign="top" bgcolor="#DEEED0">
											<!-- code for menuAdmin-->
											<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="eWasteEmpMenuVertical"/> 
					                        <%    }
						                  		} %>
								         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
								               	<g:include controller="userMaster" action="showIndexMenu"/>            
								         	<% } %>
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
						//IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 //indname=ind.indName;
								indname="fdf"
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
							
							
							<tr><td height="0" align="center" valign="top">
												<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
										</span>
										</td></tr>
							<tr>
						
								<td height="0" align="center" valign="top">
								
								<!--  start confirmation by Pradeep -->
								<div align="center">
	<table border="0" width="90%" cellspacing="0" style="border-style: ridge; border-width: 0px; padding: 0" cellpadding="2">
		<tr>
			<td bgcolor="#3366CC" colspan="3">
			<font color="#FFFFFF" face="Verdana" size="2"><b>BioMedical-Waste Application Details</b></font></td>
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
			
			<font face="Verdana" size="2" color="red"><b>Congratulations! Application submitted successfully.</b></font><br>
			
			</td>
		</tr>
		
		<tr>
			<td align="left" width="100%" colspan="3" bgcolor="">
			<font face="Verdana" size="1">
			To view the submitted application form click onto "View Application Form" and To print the application form click onto "Print Application Form"<br>
</font></td>
		</tr>

		<tr>
			<td width="100%" bgcolor="" align="center" >
				<table  width="100%" >
					<tr >
					<hr>
						<td style="border-style: ridge; border-width: 0px; padding: 0">
						<font size="1" face="Verdana">
							<g:link action="showNewFormat" controller="bioMedicalWaste" id="${indApplicationDetailsInstance.id}"><u>View Application Form</u></g:link>
						</font></td>
						<td width="50%" bgcolor="" align="right" style="border-style: ridge; border-width: 0px; padding: 0"><font size="1" face="Verdana">
							<% System.out.println("kkkkkkkkkkk"+indApplicationDetailsInstance?.completionStatus)%>
							
								 <g:if test="${bioMedicalWasteInstance?.completionStatus!='Inprogress'}">
				  <td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/bioMedicalWaste/viewBmwPdf?appliLoc=<%=indApplicationDetailsInstance?.id%>"><span class="headngblue">Print Application</span></a></td>
				</g:if>
								
						</td>
						
					</tr>
				</table><hr>
			</td>

					
		
			
		</tr>
		<tr>
			<td width="100%" colspan="3" bgcolor="">&nbsp;</td>
		</tr>
		<tr>
			<td width="100%" colspan="3" bgcolor="" style="border-bottom-style: none; border-bottom-width: medium">
			<p align="left">
			
			<hr></td>
		</tr>
		
		
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


