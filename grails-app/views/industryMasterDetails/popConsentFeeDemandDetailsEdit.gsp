<head>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    alert('hello')
        window.opener.hello();
    }

function createRow(){
try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</g:javascript>
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
</head>
<body>
<table align="center">

<tr align="center">

<td width="100%" align="center">

<div>





<table width="100%" border="0" align="center" cellpadding="0"
cellspacing="0" id="countrytabs">
<tr>
<td width="11"><img
src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
width="11" height="27" /></td>
<td width="210" align="center"
background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
class="top-lnks"><a href="#" rel="country1">Consent Fee Demand Details</a></td>
<td width="11" valign="bottom"><img
src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
width="11" height="27" /></td>
<td width="220">&nbsp;</td>
</tr>
</table>
<div >
<g:form name="waterSourceUses" method="post" action="deleteConsentFeeDemandDetails" >
<table width="100%" border="0" align="center" cellpadding="0"
cellspacing="0" bordercolor="black">

<tr>
<td>
<table border="1" align="left" cellpadding="0"
cellspacing="0" class="tblbdr" bordercolor="black">

 	<tr bgcolor="#A8DAF3">
 	
 	<td width="150px" align="center" class="txt">Financial Year</td>
 	<td width="150px" align="center" class="txt">Consent Fee Type</td>
   	<td width="150px" align="center" class="txt">Water Act</td>
	<td width="150px" align="center" class="txt">Air Act</td>
 	<td width="150px" align="center"  class="txt" >Total</td>
    <td width="150px" align="center"  class="txt" >Total Gross Fixed Assets in Lakhs</td>
	<td width="150px" align="center" class="txt">As on</td>
	 <td width="150px" align="center" class="txt">Delete</td>

                      </tr>
                       <input name="applicationId" type="hidden" maxlength="15" size="6"class="txt4" value="<%=appliId%>" />
 <g:each in="${consentFeeDemandStatusList}" status="i" var="consentFeeDemandStatusInst">
  <tr align="center" >
   <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.financialYear}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.consentFeeType}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableWaterAct}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableAirAct}</span></td>                        
  						<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableBothAct}</span></td>
  						<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.gfa}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.gfaAsOn}</span></td>     
                         <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=consentFeeDemandStatusInst.id%>"/>
                        </span></td>
                           
        </tr>	
      </g:each>	
      <tr align="center">
      <td bgcolor="#E8F6F9" colspan="8" align="center"><span class="txt style6">Total    : ${totalDemandfee}</span></td>
      </tr>	
 	
</table>
</td>
</tr>

					<tr align="center">
  <td><div style="width: 500px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										</span></div></td></tr>  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

    <td height="1" colspan="2" bgcolor="" align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>

</table>
</g:form>
</div>
</div>
</td>
</tr>
<%if(session.getAttribute("userMaster")){
UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
if(userType.equals("admin") || userType.equals("employee")) { 
%>
<tr>
 
  </tr>
  <%}}%>
</table>
<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->

</body>