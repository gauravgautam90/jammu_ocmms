<head>
<% String cont=request.getContextPath(); %>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createNewRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel1'},'temp.gsp', { insertion: Insertion.Bottom });
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
<g:form name="saveBrickSittingCriteria" id="saveBrickSittingCriteria" method="post" action="saveBrickSittingCriteriaMaster" >
<div align="center" style="border":1px solid gray;  margin-bottom: 1em; padding: 10px">
<table class="tblbdr" width="70%">
<tr bgcolor="#D1D1D1">
			<td   align="center" valign="middle"  class="headngblue">Brick Kiln Siting Criteria Details</td>
		</tr> 
				
			<tr><td>
				<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="tblbdr">
					<tr bgcolor="#A8DAF3">
					    <td width="150px" align="center" class="headngblue" ><div  class="style3">Parameter</div></td>
                        <td width="150px" align="center" class="headngblue" ><div  class="style3">Distance fron Unit/Proposed site (In Meters)</div></td>
                    </tr>
					<tr>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
							<g:select optionKey="id" from="${StoneCrusherParameterMaster.list()}" name="parameter" class="txt4" ></g:select>
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input type="hidden" name="appId" value="<%=appDetId%>">
							<input name="distance" type="text" size="15" maxlength="50" class="txt4" />
						</td>
						
					</tr>
					<tr>
					<td colspan="5" align="center"><span style="color:red">*Please enter NA where nothing is applicable</span></br><input type="submit" name="Add" value="Add" class="actionbutton"></td>
					</tr>
				<span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a target="_blank" href="<%=cont%>/SPCB_DOCUMENTS/JK BrickKiln Regulation Act2010.pdf">View BrickKiln Regulation Act2010</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a target="_blank" href="<%=cont%>/SPCB_DOCUMENTS/brickkilnguidelines0001.pdf">View Siting Criteria</a></span>
					
						
					
			  	</table>
				
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
 				  
 				<tr align="left">
				<td align="left"><span class="txt" style="color: navy"><b>List of Brick Kiln Siting Criteria Details added.</b></span>
				<!--  -->
				
				<div align="left" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table  class="tblbdr" width="100%">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="150px" align="center" class="headngblue" ><div  class="style3">Parameter</div></td>
                        <td width="150px" align="center" class="headngblue" ><div  class="style3">Distance fron Unit/Proposed site (In Meters)</div></td>
                    </tr>
 
 <g:each in="${brickSittingCriteriaList}" status="i" var="brickSittingCriteriaInst">
  <tr align="center" >
  						<td bgcolor="#E8F6F9"><span class="txt style6">${brickSittingCriteriaInst.parameter}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${brickSittingCriteriaInst.distance}
                        </span></td>
                              
        </tr>		
      </g:each>		
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
				
				<!--  -->
				</td>
				</tr>
</table>
</div>
</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("saveBrickSittingCriteria");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 <!-- frmvalidator.addValidation("distance","numeric","Distance should be numeric or decimal");-->

 </script>
 <!--
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSolidWasteGen");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("description","req","please enter Description");
  frmvalidator.addValidation("quantity","numeric","Quantity should be numeric");
  frmvalidator.addValidation("methodCollection","req","please enter Method of Collection");
   frmvalidator.addValidation("methodDisposal","req","please enter Mode of Disposal");
 -->
  
 </script>   
 
</body>
