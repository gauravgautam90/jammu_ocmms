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





		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0" id="countrytabs">
			<tr>
				<td width="11"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
					width="11" height="27" /></td>
				<td width="110" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">Air Quality Parameter Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="432">&nbsp;</td>
			</tr>
		</table>
		<div >
		<table width="95%" border="0" align="center" cellpadding="0"
	cellspacing="0" bordercolor="black">

	<tr>
		<td>
		<table border="1" align="center" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3">
			   <td width="15%" align="center" class="headngblue">Quality Parameter</td>
                <td width="15%" align="center" class="headngblue">Range</td>
                 <td width="15%" align="center" class="headngblue">Standard Value(in mg/Nm3)</td>
    	
			</tr>
			<g:each in="${prameterDetailsList}" status="i" var="productDetails">
				<tr align="center">
				 <td ><span class="txt style6">${productDetails.qualityParameter}
                        </span></td>
                        <td ><span class="txt style6">${productDetails.range}
                        </span></td>
                      <td ><span class="txt style6">${productDetails.standardValue}
                        </span></td>  
                        	
				</tr>
			</g:each>
			




		</table>
		</td>
	</tr>



</table>

		</div>
		</div>
		</td>
	</tr>

	<tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="history.back()" class="actionbutton"></td>
		  
  </tr>
</table>
<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->

</body>