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
					class="top-lnks"><a href="#" rel="country1">Clearances Details</a></td>
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
 					<td width="150px" align="center" class="txt">Clearance Type</td>
	   		  <td width="150px" align="center" class="txt">Issued date</td>
			 <td width="150px" align="center" class="txt">Valid date</td>
 				<td width="150px" align="center"  class="txt" > Issued by Authority </td>
                 <td width="150px" align="center"  class="txt" > Proc. No and date</td>

                      </tr>
 <g:each in="${gOClearanceDetailsList}" status="i" var="inspectionGOClearanceDetailsInst">
  <tr align="center" >
  
   <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionGOClearanceDetailsInst.type}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionGOClearanceDetailsInst.issuedDate}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionGOClearanceDetailsInst.validDate}
                        </span></td>
                        
  <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionGOClearanceDetailsInst.issuedBy}
                        </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${inspectionGOClearanceDetailsInst.number}
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
								%>
	<tr>
	 
  </tr>
  <%}}%>
</table>
<!-- ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg -->

</body>