<head>
<% String cont=request.getContextPath();%>
<script type="text/javascript">

var consentManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
consentManagement.items=[
	["Apply For Concent", "#"]
]
<!--
var user_management_link={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
user_management_link.items=[
	["Hazardeous Waste", "<g:createLink controller="hazardeousWasteAuthApp" action="create" />"],
	["Bio-Medical Waste", "<g:createLink controller="bioMedicalWaste" action="create" />"],
	["Municipal Solid Waste", "<%=cont%>/municipalSolidWaste/create"]
] -->

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
                      <td> <a href="#" class="menuanchorclass" rel="user_management_link"></a></td>
                     <td>  <g:link controller="eWaste" action="create"><span class="leftlink">Apply For Recycler-HW</span></g:link>
                     </td>
                     
                     
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
			 
			 
			 
			  
           <!--   <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><g:link controller="hazardeousWasteAuthApp" action="list"><span class="leftlink">Waste Management Authorization Applications</span></g:link></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>-->
              
             
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