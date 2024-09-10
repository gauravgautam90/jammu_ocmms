<head>
<g:javascript library="prototype" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<g:form name="saveBrickKilnDetail" method="post" action="saveBrickKilnDetailInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table width="100%" cellpadding="0" cellspacing="0">
<tr bgcolor="#D1D1D1">
					<td  align="center" valign="middle"  class="headngblue">Brick Kiln Details</td>
				</tr>
				<tr >
					<td>
						<table width="100%" border="0" >
						  	<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Capacity of the Kiln</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							  <input name="appId" type="hidden" value="<%=appDetId%>" /> 
							  <input name="capacity" type="text" maxlength="50" size="25"class="txt4" />
							  <span class="sidetxt">(enter capacity)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Trench Size</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="trenchSize" type="text" maxlength="50" size="25"class="txt4" />
							  <span class="sidetxt">(enter trench size)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Chimeny Type</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							 
							<g:select  from="${['Fixed','Moving']}" name="chimeny"></g:select>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Height of Chimeny (In Meters)</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="height" type="text" maxlength="50" size="25"class="txt4" />
							  <span class="sidetxt">(enter height of cheminy)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Any ECD installed along with the Chimeny</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="ecd" type="text" maxlength="50" size="25"class="txt4" />
							  <span class="sidetxt">(enter ECD detail)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Kiln Type</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							
							<g:select  from="${['Cluster','Isolated']}" name="cluster"></g:select>
							</tr>
				
						  <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						 
						 </table>
					</td>
				</tr>
				
				<tr>
						<!-- Div area for errors-->
						<td align="center" valign="middle">
						<span
							class="error">
							 <g:if test="${flash.message}">
							<div class="message">${flash.message}</div>
							</g:if>
						</span>
						</td>
				</tr>				
 				
				<tr>
				<td>
				<!-- ------------ -->
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
				<span class="txt" style="color: navy"><b>List of brick kiln details added.</b></span>
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="17%" class="headngblue" ><div  class="style3">Capacity of the Kiln</div></td>
                        <td width="17%" class="headngblue" ><div  class="style3">Trench Size</div></td>
                        <td width="17%" class="headngblue" ><div  class="style3">Chimeny Type</div></td>
                  		<td width="17%" class="headngblue" ><div  class="style3">Height of Chimeny (In Meters)</div></td>
                        <td width="16%" class="headngblue" ><div  class="style3">Any ECD installed along with the Chimeny</div></td>
                        <td width="16%" class="headngblue" ><div  class="style3">Kiln Type</div></td>
                   	</tr>
 <g:each in="${brickList}" status="i" var="brickInst">
  <tr align="center" >
  						<td bgcolor="#E8F6F9" ><span class="txt ">${brickInst.capacity}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${brickInst.trenchSize}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${brickInst.chimeny}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt ">${brickInst.height}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${brickInst.ecd}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${brickInst.cluster}
                        </span></td>
                                  
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					</tr>
 					
 					
 				
 					
 					</table>
 					
 					<!-- ------ -->
				</td>
				</tr>
				<tr><td align="center">
				<% if(type=="REGULAR"){
	           			System.out.println("type...."+type)
	           			%>
	           		
	           		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

	           			()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
	           				
	           		<%}else{%>
	                  
						<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

	()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
		
					<%}%></td></tr>	
</table>
</g:form>

<!--=========== VALIDATION
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("odorCompounds","req","Please enter name of Odoriferous Compounds");
  frmvalidator.addValidation("quality","req","Please enter quality of gas emissions");
</script> 
 -->
  
</body>