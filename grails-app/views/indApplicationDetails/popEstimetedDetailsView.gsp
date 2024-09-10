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
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body>
<g:form name="waterSourceUses" method="post" action="" >
<table align="center">

	<tr align="center">

		<td width="100%" align="center">

		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0" id="countrytabs">
			<tr>
				<td width="11"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
					width="11" height="27" /></td>
				<td width="110" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">Cost Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="270">&nbsp;</td>
			</tr>
		</table>
		<div >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3" >
                  <td  width="30%" align="center" class="headngblue">Expenditure Proposed For</td>
                <td width="25%" align="center" class="headngblue">Capital(in Rs.)</td>
                <td width="25%" align="center" class="headngblue">Recurring(in Rs.)</td>
              	</tr>
 <g:each in="${costDetailsList}" status="i" var="costDetails">
  	<tr align="center" >
  					<td ><span class="txt style6">${costDetails.expenditureProposed}
                        </span></td>
                        <td ><span class="txt style6">${costDetails.capital}
                        </span></td>
                        <td ><span class="txt style6">${costDetails.recurring}
                        </span></td>
                        
                              
    </tr>		
 </g:each>		
 				
 					
 					</table>
 				</td></tr>
 				
  </table>
  
		</div>
		
		</td>
	</tr>

	

<tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="history.back()" class="actionbutton"></td>
		  
  </tr>

</table>
<!-- - -->

  		</g:form>
</body>