<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>

<script language="javascript">
function whichButton(event)
{
 if (event.button==2)//For right click
 {
  alert("Right Click Not Allowed!");
 }
}

function noCTRL(e)
{
 var code = (document.all) ? event.keyCode:e.which;
 var msg = "Sorry, this functionality is disabled.";
 if (parseInt(code)==17) // This is the Key code for CTRL key
 {
  
  window.event.returnValue = false;
 }
}


function checkSize()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"hazardeousWasteAuthApp", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function checkSize1()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"bioMedicalWaste", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function checkSize2()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"plasticWaste", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function checkSize3()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"municipalSolidWaste", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function checkSize4()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"eWaste", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function checkSize5()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"constructionDemolitionWaste", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function checkSize6()
{
 var zopt=document.getElementById('indAppDetId').value;
 ${remoteFunction(controller:"batteryWaste", action:"updatefeeBankDetailSize", params:"'id=' + zopt", onComplete:"updateCity1(e)")};

}
function updateCity1(e)
{
document.getElementById('feeBankDetailSize1').value=e.responseText;
//alert("updateCity1(e)"+e.responseText);
var length=document.getElementById('feeBankDetailSize1').value;
//alert("size is"+length);
if(length==0)
{
//alert("ento false");
return false;
}else
{
//alert("ento true");
return true;
}
}

window.onunload = refreshParent;
function refreshParent() {
window.opener.location.reload(true);
                         }

</script>
</head>

<body ondragstart="//return false" onselectstart="//return false" onMouseDown="//whichButton(event)" onKeyDown="//return noCTRL(event)">
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
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
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
              
              <tr>
                <td height="24" bgcolor="#4C8BC0">

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>


					<table width="100%" bgcolor="#4C8BC0">
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
		
		<% } %>
</td>
              </tr>
              
              <tr><td>

</td></tr>


              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">&nbsp;</span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    
                    <tr>
										<!-- Div area for errors-->
										<td align="center" valign="top">
										<b><font
											color="#417FB2">
										Please Click on add to enter Payment Details.
										<br>Click on Back to make Changes.
										</font></b>
										<br>
										<br>
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
										</span>
										</td>
									</tr>
                    <tr>
                      <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    
         <div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
		 
		 
		<g:form name="general" method="post" enctype="multipart/form-data" action="confirmation">
           <!--     <input type="hidden" id='regMasId' name="regMasId" value="${industryRegMasterInstance?.id}" /> -->
				<input type="hidden" id='indAppDetId' name="indAppDetId" value="${indApplicationDetailsInstance?.id}" /> 
				
			
			<br>
			<%
			System.out.println("rrrrrrrrrrrrrrrrrrrrr+++++++++++++"+indApplicationDetailsInstance)
			def applicationPending = WasteManagementPendingDetails.findByApplicationId((indApplicationDetailsInstance.id).toString())
			System.out.println("shgwehgowehg+++++++++++++"+applicationPending)
	    	def appFor=applicationPending.applicationFor
	    	def hwmIns
	    	def feeBankDetailsObj
	    	def feeBankDetailSize=0
			if(appFor=="HWM"){
				hwmIns=HazardeousWasteAuthApp.get((applicationPending.applicationId).toLong())
				feeBankDetailsObj = FeeBankDetailsHWM.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}		
	    	}else if(appFor=="MSW"){
	    		hwmIns=MunicipalSolidWaste.get((applicationPending.applicationId).toLong())
	    		feeBankDetailsObj = FeeBankDetailsMSW.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}	
	    	}else if(appFor=="PWM"){
	    		hwmIns=PlasticWaste.get((applicationPending.applicationId).toLong())
				feeBankDetailsObj = FeeBankDetailsPWM.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}		
	    	}else if(appFor=="EWaste"){
	    		hwmIns=EWaste.get((applicationPending.applicationId).toLong())
				feeBankDetailsObj = FeeBankDetailsEwaste.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}		
	    	}else if(appFor=="Construction and Demolition"){
	    		hwmIns=ConstructionDemolitionWaste.get((applicationPending.applicationId).toLong())
				feeBankDetailsObj = FeeBankDetailsConsDemoli.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}		
	    	}else if(appFor=="BATTERY"){
	    		hwmIns=BatteryWasteDetails.get((applicationPending.applicationId).toLong())
				feeBankDetailsObj = BatteryFeeBankDetails.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}		
	    	}else{
	    		hwmIns=BioMedicalWaste.get((applicationPending.applicationId).toLong())
	    		feeBankDetailsObj = FeeBankDetailsBMW.findAllByApplication(hwmIns);
				if(feeBankDetailsObj){
				feeBankDetailSize=feeBankDetailsObj.size()
				}		
	    	}
			
			
//			def feeBankDetailSize=0
//			def hwmIns=HazardeousWasteAuthApp.get(indApplicationDetailsInstance.id);
//			def feeBankDetailsObj = FeeBankDetailsHWM.findAllByApplication(hwmIns);
//			if(feeBankDetailsObj){
//			feeBankDetailSize=feeBankDetailsObj.size()
//			}			
			%>
			
			
		<table width="80%" border="0" align="right" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
         <div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
			
			<table width="70%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
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
				<%if(appFor=="HWM"){%>
					<tr>
						<td colspan="2">
						<table width="100%" border="0" >
						<tr>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeDetailsAddHWM/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeDetailsViewHWM/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeDetailsEditHWM/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
						</tr>
						</table>
						</td>
					</tr> 
				    <%}else if(appFor=="BMW"){%>
				    <tr>
						<td colspan="2">
						<table width="100%" border="0" >
						<tr>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsAddBMW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsEditBMW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
						</tr>
						</table>
						</td>
					</tr> 
				    <%}else if(appFor=="PWM"){%>
				    <tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<tr>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsAddPWM/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsViewPWM/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsEditPWM/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
					</tr>
					</table>
					</td>
				</tr> 
				    <%}else if(appFor=="MSW"){%>
					<tr>
						<td colspan="2">
						<table width="100%" border="0" >
						<tr>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/municipalSolidWaste/popFeeDetailsAddMSW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/municipalSolidWaste/popFeeDetailsViewMSW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/municipalSolidWaste/popFeeDetailsEditMSW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
						</tr>
						</table>
						</td>
					</tr>
					<%}else if(appFor=="EWaste"){%>
					<tr>
						<td colspan="2">
						<table width="100%" border="0" >
						<tr>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popFeeDetailsAddEwaste/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popFeeDetailsViewEwaste/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popFeeDetailsEditEwaste/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
						</tr>
						</table>
						</td>
					</tr>
					<%}else if(appFor=="Construction and Demolition"){%>
					<tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<tr>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/constructionDemolitionWaste/popFeeDetailsAddConsDemoli/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/constructionDemolitionWaste/popFeeDetailsEditConsDemoli/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/constructionDemolitionWaste/popFeeDetailsViewConsDemoli/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
					</tr>
					</table>
					</td>
				</tr>
				<%}else if(appFor=="BATTERY"){%>
				<tr>
				<td colspan="2">
				<table width="100%" border="0" >
				<tr>
				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/batteryWaste/popFeeDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/batteryWaste/popFeeDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/batteryWaste/popFeeDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>
				</tr>
				</table>
				</td>
			</tr>
			<%}%>
				
				    <tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">&nbsp;</td>
					
			  	</tr>
			  	<%if(appFor=="HWM"){%>
			  	<tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">
					<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize();" />
					<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
					</td>
			  	</tr>  
			  	<%}else if(appFor=="BMW"){%>
			  	<tr bgcolor="#FFFFFF">
				<td colspan="2" align="center">
				<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize1();" />
				<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
				</td>
				</tr>  
			  	<%}else if(appFor=="PWM"){%>
			  	<tr bgcolor="#FFFFFF">
				<td colspan="2" align="center">
				<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize2();" />
				<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
				</td>
				</tr> 
			  	<%}else if(appFor=="MSW"){%>
			  	<tr bgcolor="#FFFFFF">
				<td colspan="2" align="center">
				<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize3();" />
				<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
				</td>
				</tr> 
			  	<%}else if(appFor=="EWaste"){%>
			  	<tr bgcolor="#FFFFFF">
				<td colspan="2" align="center">
				<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize4();" />
				<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
				</td>
				</tr> 
			  	<%}else if(appFor=="Construction and Demolition"){%>
			  	<tr bgcolor="#FFFFFF">
				<td colspan="2" align="center">
				<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize5();" />
				<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
				</td>
				</tr> 
			  	<%}else if(appFor=="BATTERY"){%>
			  	<tr bgcolor="#FFFFFF">
				<td colspan="2" align="center">
				<input type="submit" class="actionbutton" name="back" value="Proceed" onclick="return checkSize6();" />
				<a href="<%=request.getContextPath()%>/wasteManagementProcessingDetails/addPayment/<%=indApplicationDetailsInstance?.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
				</td>
				</tr> 
			  	<%}%>
				</table>
				
				</div>
		</td>
		</tr>
		
		</table>
		
											</g:form>
										<!-- </div> -->
									

      </div></td>
                            
                          </tr>
                          <tr>
                          
                          <td width="25" align="left" valign="top">&nbsp;</td>
                          
                          
                          <td width="100" align="right" colspan="2">	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  	<div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br><br>
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To enter the DD/Cheque details, use the link as follows:
			   <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; click "Add" add details, "View" to view details and "Delete" link to delete details. <br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; To update the details, first delete you want to edit and then add new one.
		</div>
		</td></tr>
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



    var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  

  //  frmvalidator.addValidation("feeBankDetailSize1","minlen=1","Please enter Bank Details");
 

  </script>
  
</body>
</html>
