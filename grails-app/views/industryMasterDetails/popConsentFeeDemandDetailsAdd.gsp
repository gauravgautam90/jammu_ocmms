<head>
<%@ page import="java.text.*"%>
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

function fillEntry()
{
var a=document.getElementById('feeApplicableWaterAct').value
var b=document.getElementById('feeApplicableAirAct').value
document.getElementById('feeApplicableBothAct').value=eval(a)+eval(b)
document.getElementById('feeApplicableBothAct1').value=eval(a)+eval(b)
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

<g:form  method="post" action="saveConsentFeeDemandDetails" name="myForm" enctype="multipart/form-data">
  
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Consent Fee Demand Details</td>
					</tr>
					<tr>
<td>
<table align="center" cellpadding="0"
cellspacing="0" class="tblbdr"  border="1">
 					
 					<tr bgcolor="#A8DAF3">
 	
 	<td width="150px" align="center" class="txt">Financial Year</td>
 	<td width="10%" align="center" class="txt">Consent Fee Type</td>
   	<td width="150px" align="center" class="txt">Water Act</td>
	<td width="150px" align="center" class="txt">Air Act</td>
 	<td width="150px" align="center"  class="txt" >Total</td>
    <td width="150px" align="center"  class="txt" >Total Gross Fixed Assets in Lakhs</td>
	<td width="150px" align="center" class="txt">As on</td>
                      </tr>

        <tr align="center">
        
        <% 
        def indApplInst=IndApplicationDetails.get(appliId);
		def indUser=IndustryRegMaster.get(indApplInst.indUser.id)
		def gfa=indUser.indCapInvt
		def sdfh = new SimpleDateFormat("dd/MM/yyyy");    
	    def asOn = sdfh.format(indUser.indCapInvtAsOn)
        
         %>
        
        <input name="applicationId" type="hidden" maxlength="15" size="6"class="txt4" value="<%=appliId%>" />
  					   
						<td bgcolor="#E8F6F9"><span class="txt style6">
						<input name="financialYear" type="text" maxlength="15" size="15"class="txt4"  />
						</span>
						</td>
						 <td bgcolor="#E8F6F9"><span class="txt style6"> 
  					     <g:select from="${['Arrears','Current']}"  name="consentFeeType" class="txt4" id = "consentFeeType"></g:select>  					   
  					     </span></td>
						<td bgcolor="#E8F6F9"><span class="txt style6"><input name="feeApplicableWaterAct" id="feeApplicableWaterAct" type="text" maxlength="250" size="15" class="txt4" value="0" oninput="fillEntry()" />
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input name="feeApplicableAirAct" id="feeApplicableAirAct" type="text" size="15" maxlength="250" class="txt4" value="0" oninput="fillEntry()"/>
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input name="feeApplicableBothAct" id="feeApplicableBothAct" type="hidden" maxlength="25" size="15" class="txt4" value="0"/>
                        <input name="feeApplicableBothAct1" id="feeApplicableBothAct1" type="text" maxlength="25" size="8" class="txt4" disabled/>
                      
                        </span></td>
                      <td bgcolor="#E8F6F9"><span class="txt style6"><input name="gfa" id="gfa" type="text" maxlength="25" size="15" class="txt4" value="<%=gfa%>"/>
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6"><input name="gfaAsOn" id="gfaAsOn" type="text" maxlength="25" size="15" class="txt4" value="<%=asOn%>"/>
                        </span></td>
                        
        </tr></table></td></tr>
 					<tr>
 					<td align="center"  ><input type="submit" name="Add" value="Add" class="actionbutton"></td>
 					</tr>
 					
 					</g:form>
 					
 					<tr align="center">
  <td><div style="width: 500px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}.</div>
										</g:if>
										</span></div></td></tr>
 					
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
<td width="580" valign="bottom"><img
src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
width="11" height="27" /></td>
<td width="220">&nbsp;</td>
</tr>
</table>
<div >
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
 	

                      </tr>
 <g:each in="${consentFeeDemandStatusList}" status="i" var="consentFeeDemandStatusInst">
  <tr align="center" >
   
   <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.financialYear}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.consentFeeType}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableWaterAct}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableAirAct}</span></td>                        
  						<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableBothAct}</span></td>
  						<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.gfa}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.gfaAsOn}</span></td>
  						         
        </tr>	
      </g:each>	
      <tr align="center">
      <td bgcolor="#E8F6F9" colspan="7" align="center"><span class="txt style6">Total    : ${totalDemandfee}</span></td>
      </tr>	
 	
</table>
</td>
</tr>



</table>

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

<script language="JavaScript" type="text/javascript">


 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 frmvalidator.addValidation("financialYear","req","Please enter financial year."); 
 frmvalidator.addValidation("feeApplicableWaterAct","req","Please enter Water act amount."); 
 frmvalidator.addValidation("feeApplicableAirAct","req","Please enter Air act amount."); 
 frmvalidator.addValidation("feeApplicableWaterAct","numeric","Water act amount must be numeric.");
 frmvalidator.addValidation("feeApplicableAirAct","numeric","Air act amount must be numeric.");
 frmvalidator.addValidation("gfa","req","Please enter GFA.");
 frmvalidator.addValidation("gfa","decimal","GFA must be numeric.");
 

</script>
<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->

</body>