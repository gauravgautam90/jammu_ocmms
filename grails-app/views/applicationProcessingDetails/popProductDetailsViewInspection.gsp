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
					class="top-lnks"><a href="#" rel="country1">Product Details</a></td>
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
				<td width="30%" align="center" class="headngblue">Product Name
				</td>
				<td  width="15%" align="center" class="headngblue">Qty</td>
				<td  width="15%" align="center" class="headngblue">Unit</td>
				<td  width="25%" align="center" class="headngblue">By Products & Quantity</td>
				<td  width="15%" align="center" class="headngblue">Unit</td>
				<td  align="center" class="headngblue">Raw Materials(Consumption per month)</td>

			</tr>
			<g:each in="${productDetailsList}" status="i" var="productDetails">
				<tr align="center">
					<td><span class="txt style6">${productDetails.product}
					</span></td>
					<td><span class="txt style6">${productDetails.quantity}
					</span></td>
					<td><span class="txt style6">${productDetails.unit} </span></td>
					<td><span class="txt style6">${productDetails.byProduct}
					</span></td>
					<td><span class="txt style6">${productDetails.unitbyProduct} </span></td>
					<td><span class="txt style6">${productDetails.rawMaterials}
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

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"> 					<% if(type=="REGULAR"){
			System.out.println("type...."+type)
    			%>
    		
    		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

    			()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
    				
    		<%}else{%>
           
				<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

			<%}%> </td>
		  
  </tr>

</table>
<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->

</body>