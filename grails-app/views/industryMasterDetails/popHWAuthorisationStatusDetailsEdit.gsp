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
<g:form name="waterSourceUses" method="post" action="deleteAuthorisationDetails" >
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
				<td width="210" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">Hazardous Wastes Authorisation Status Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="220">&nbsp;</td>
			</tr>
		</table>
		<div >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3" >
               		<td width="20%" align="center"  class="txt" >HW generation</td>
                        <td width="20%" align="center"  class="txt" >Applied for Authorisation</td>
							  <td width="150px" align="center" class="txt">Date of Application for HWA</td>
							  <td width="150px" align="center" class="txt">HWA Type</td>
							  <td width="150px" align="center" class="txt">Issued date</td>
							  <td width="150px" align="center" class="txt">Valid date</td>
				
<td align="center" class="headngblue">Delete</td>
				
              	</tr>
<g:each in="${hWAuthorisationStatusDetailsList}" status="i" var="inspectionHWAuthorisationStatusDetailsInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.generation}
                        </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.appliedFor}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.date}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.type}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.issuedDate}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${inspectionHWAuthorisationStatusDetailsInst.validDate}
                        </span></td>
                         
                           <td ><span class="txt style6"><input type="checkbox" name="delete" value="<%=inspectionHWAuthorisationStatusDetailsInst.id%>" />
                        </span></td>    
    </tr>		
 </g:each>			

                	<tr bgcolor="#F4F7FB">
                	<input type="hidden" name="page" value="${page}">
 					<td align="center" colspan="6"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
 					</tr>
 					</table>
 				</td></tr>
 				
  </table>
  
		</div>
		</div>
		</td>
	</tr>

	<tr>



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
<!-- - -->

  		</g:form>
</body>