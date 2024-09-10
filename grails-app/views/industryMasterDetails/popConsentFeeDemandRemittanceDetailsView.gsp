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
<table width="100%" border="0" align="center" cellpadding="0"
cellspacing="0" bordercolor="black">

<tr>
<td>
<table border="1" align="left" cellpadding="0"
cellspacing="0" class="tblbdr" bordercolor="black">

 	<tr bgcolor="#A8DAF3">
 	<% if(showAppli=="Yes") { %>   
 	<td width="150px" align="center" class="txt">Application Id</td>
    <% } %>
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
 <% if(showAppli=="Yes") { %>
 	<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.application.id}</span></td>
 	<% } %>
   <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.financialYear}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.consentFeeType}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableWaterAct}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableAirAct}</span></td>                        
  						<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.feeApplicableBothAct}</span></td>
  						<td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.gfa}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${consentFeeDemandStatusInst.gfaAsOn}</span></td>
      </g:each>	
      <tr align="center">
      <td bgcolor="#E8F6F9" colspan="8" align="center"><span class="txt style6">Total    : ${totalDemandfee}</span></td>
      </tr>	
 	
</table>
</td>
</tr>



</table>

</div>
</div>
</td>
</tr>
</table>

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
class="top-lnks"><a href="#" rel="country1">Consent Fee Remittance Details</a></td>
<td width="11" valign="bottom"><img
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
 	<% if(showAppli=="Yes") { %>
 	<td width="150px" align="center" class="txt">Application Id</td>
 	<% } %>
 	<td width="150px" align="center" class="txt">Date</td>
   	<td width="150px" align="center" class="txt">CR No/Bank Ref No</td> 	
 	<td width="150px" align="center" class="txt">Amount</td>
 	<td width="150px" align="center" class="txt">Reason/Remarks on rising the demand</td>
 	<td width="150px" align="center" class="txt">District Office of TNPCB</td>
                      </tr>
                      
    <g:each in="${consentRemittanceFeeStatusList}" status="i" var="consentRemittanceFeeStatusInst">
  	   <tr align="center" >  
  	  <% if(showAppli=="Yes") { %>
 	<td bgcolor="#E8F6F9"><span class="txt style6">${consentRemittanceFeeStatusInst.application.id}</span></td>
 	<% } %>
   		<td bgcolor="#E8F6F9"><span class="txt style6">${consentRemittanceFeeStatusInst.submitionDate}</span></td>
        <td bgcolor="#E8F6F9"><span class="txt style6">${consentRemittanceFeeStatusInst.crNo}</span></td>
        <td bgcolor="#E8F6F9"><span class="txt style6">${consentRemittanceFeeStatusInst.totalAmount}</span></td>   
          <td bgcolor="#E8F6F9"><span class="txt style6">${consentRemittanceFeeStatusInst.remarksRaisingDemand}</span></td>                        
  	    <td bgcolor="#E8F6F9"><span class="txt style6">${consentRemittanceFeeStatusInst.districtOffice.districtOfficeName}</span></td>
		</tr>
      </g:each>	
      <tr align="center">
      <td bgcolor="#E8F6F9" colspan="6" align="center"><span class="txt style6">Total    : ${totalRemittanceFee}</span></td>
      </tr>	
</table>
</td>
</tr>
</table>
<div>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
</div>
<div>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
</div>

<table border="1" width="90%" align="center" cellpadding="0" cellspacing="0" class="tblbdr" bordercolor="black">

 	<tr align="left">
 		<td width="70%" bgcolor="#A8DAF3" align="left" class="txt">Total consent fee Demand          Rs.</td>
 		<td width="30%" bgcolor="#E8F6F9"><span class="txt style6">${totalDemandfee}</span></td>
   	</tr>
  	<tr align="left" >
  		<td width="70%" bgcolor="#A8DAF3" align="left" class="txt">Consent fee remitted  by the industry  Rs.</td>
   		<td width="30%" bgcolor="#E8F6F9"><span class="txt style6">${totalRemittanceFee}</span></td>
	</tr>
	<tr align="left" > 
		<td width="70%" bgcolor="#A8DAF3" align="left" class="txt">Balance to be remitted                       Rs.</td> 
   		<td width="30%" bgcolor="#E8F6F9"><span class="txt style6">${balance}</span></td>
	</tr>
    
</table>

</div>
</div>
</td>
</tr>

</table>



</body>