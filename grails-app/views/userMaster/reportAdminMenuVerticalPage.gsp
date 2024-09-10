<head>
<% String cont=request.getContextPath();%>
<script type="text/javascript">
<% UserMaster um=(UserMaster)session.getAttribute("userMaster");
System.out.println("um..."+um)
System.out.println("um..."+um.userProfile.designation)%>
var consentManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
consentManagement.items=[
<%--   <%if((um.accessLevel=="admin") || (um.userProfile.designation=="Chairman") || (um.userProfile.designation=="MS") || (um.userProfile.designation=="EE")){%>  --%>
	["<b>1.</b>Search by Industry Name","<%=cont%>/allReports/searchByIndustryName"],
	["<b>2.</b>Revenue District Summary", "<%=cont%>/allReports/noOfIndustriesDistrict11"],
	["<b>3.</b>Consent wise status of applied Industries: Office wise", "<%=cont%>/allReports/consentCertificateDetail1"],
	["<b>4.</b>Consent wise CTE/CTO status of applied Industries: Officer wise", "<%=cont%>/allReports/monitoringDetail"],
	["<b>5.</b>Consent wise CTE/CTO status of applied Industries: Office wise", "<%=cont%>/allReports/monitoringDetailOffice"],
	["<b>6.</b>Consent application wise status: Office wise", "<%=cont%>/allReports/totalApplicationsDetail"],
	["<b>7.</b>Pending applications monitoring in days", "<%=cont%>/allReports/conReportPendingDaysTest"],
	["<b>8.</b>Sector-Type wise Summary", "<%=cont%>/allReports/sectorTypeWiseSummary"],
	["<b>9.</b>Status of Consent Expiry", "<%=cont%>/allReports/consentExpire"],
	["<b>10.</b>Status of CTO Decided", "<%=cont%>/allReports/consentCTODetail1"], 
	["<b>11.</b>Status of CTE Decided", "<%=cont%>/allReports/consentCTEDetail1"],
	["<b>12.</b>List Of Industries", "<%=cont%>/allReports/consentCertificateDetail2"], 
	["<b>13.</b>Pending applications monitoring days wise", "<%=cont%>/allReports/conReportPendingDaysWise"],
	["<b>14.</b>Complete Status", "<%=cont%>/allReports/completeStatus"],
	["<b>15.</b>Processing Status of Application OfficerID Wise", "<%=cont%>/allReports/officerIDStatus"],
	["<b>16.</b>Status of Consent Category Wise", "<%=cont%>/allReports/consentCategoryWise"],
	["<b>17.</b>Product Details Report", "<%=cont%>/allReports/searchByIndustryTypeWithProductNew"],
	["<b>18.</b>Auto-Renewal Report", "<%=cont%>/allReports/consentAutoRenewalDetails"]
	<%-- <%}%>  --%>
]



var ePayment={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
ePayment.items=[
<%-- <%if(um.accessLevel=="admin"){%>  --%>
["Payment Report for Consent", "<%=cont%>/allReports/paymentReport"],
["Payment Report for BMW", "<%=cont%>/allReports/paymentReportBMW"],
["Payment Report for HWM", "<%=cont%>/allReports/paymentReportHWM"],
["Reconcile Report for Consent", "<%=cont%>/allReports/misReport"]
<!--["Reconcile Report for BMW", "<%=cont%>/allReports/misReportBMW"]-->

<%-- <%}%>  --%>
]

var cessManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
cessManagement.items=[
	["Under Progress", ""]
	
]

var wasteManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
wasteManagement.items=[
	["Authorization BMW cases for Red,Orange,Green", "<%=cont%>/allReports/monitoringDetailBMW"],
	["Authorization BMW cases for CTE/CTO Status", "<%=cont%>/allReports/monitoringDetailBMWAllDistrict"],
	["Authorization BMW cases for CTE/CTO Status of Applied Industries", "<%=cont%>/allReports/monitoringDetailBMWConsentWise"],
	["Progress Report of Authorization", "<%=cont%>/allReports/monitoringDetailBMWConsentCatWise"],
	["Information of BMW", "<%=cont%>/allReports/monitoringDetailBMWAllApplication"],
	["HWM Authorization with Consent", "<%=cont%>/allReports/hwmWithConsent"],
	["Waste Authorization Pending applications monitoring in days", "<%=cont%>/allReports/monitoringDetailBmwOfficerWise"],
	["Processing Status of Application Officer ID Wise", "<%=cont%>/allReports/officerIDStatusWaste"],
	["Status of Waste Authorization Category Wise", "<%=cont%>/allReports/wasteAuthorizationCateWise"],
]

var labManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
labManagement.items=[
	["Under Progress", ""]
]

var singleWindowStatus={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
singleWindowStatus.items=[
<%if(um.accessLevel=="admin"){%>
["Send Status for Consent Applicaton", "<%=cont%>/industryRegMaster/lKsingleWindowConsentApplicationStatus"],
["Send Status for Waste Applicaton", "<%=cont%>/industryRegMaster/lKsingleWindowWasteApplicationStatus"]

<%}%>
]


</script>
</head>



<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
              
               <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><g:link controller="allReports" action="searchIndustryPage"><span class="leftlink">Industry Management</span></g:link></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
			 
              
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><a href="#" class="menuanchorclass" rel="consentManagement"><span class="leftlink">Consent Management</span></a></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                         <td><a href="#" class="menuanchorclass" rel="ePayment"><span class="leftlink">E-Payment Management</span></a></td>
                      
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>

			 <!--
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><span class="leftlink">Cess Management</span></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              -->
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                         <td><a href="#" class="menuanchorclass" rel="wasteManagement"><span class="leftlink">Waste Management</span></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
			  
		       <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><span class="leftlink">Laboratory Management</span></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              
              <tr>
              <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                  <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                       <td><a href="#" class="menuanchorclass" rel="singleWindowStatus"><span class="leftlink">Single Window Status</span></a></td>
                    
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>

			 
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'feedback.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'query.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'grad.gif')}" width="224" height="70" /></td>
              </tr>
            </table>
</body>





