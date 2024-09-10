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
				<td width="" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">By-Product Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="">&nbsp;</td>
			</tr>
		</table>
		<div >
		<table width="95%" border="0" align="center" cellpadding="0"
	cellspacing="0" bordercolor="black">

	<tr>
		<td>
		<table border="1" align="center" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

								
 			<tr bgcolor="#A8DAF3" >
               <td  width="10%" align="center" class="headngblue">Products (Name)</td>
                <td  width="10%" align="center" class="headngblue">Unit Type</td>
                <td width="10%" align="center" class="headngblue">Quantity 
                (in selected Unit Type)</td>
              <td width="10%" align="center" class="headngblue">Maximum Installed Production Capacity 
              (Same Unit)</td>
				
				</tr>		
 		<g:each in="${productDetails}" status="i" var="byProductDetailsInst">
  	<tr align="center" >
  					<td ><span class="txt style6">${byProductDetailsInst.product}
  					</span></td>
  					<td ><span class="txt style6">${byProductDetailsInst.quantity}
  					</span></td>
  					<td ><span class="txt style6">${byProductDetailsInst.unit}
  					</span></td>
  					<td ><span class="txt style6">${byProductDetailsInst.installedCapacity}
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
<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
									if(session.check==true){
								%>
<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popPreviousApp/<%=appDetId%>#country2', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>
<%

}else{%>
	<tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" class="actionbutton" value="Back" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/spcbShowForm?docName=PWM&appliId=<%=appDetId%>#country3', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>
  <%}}}%>
</table>
<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->

</body>