<head>




<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />

<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

</g:javascript>

<g:javascript>
function createMyRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'myPanel'},'tempWaterTreatmentAdd.gsp', { insertion: Insertion.Bottom });
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


 <g:javascript>
    
function check1()
    {
   
   			var selectmenu1=document.getElementById('fuel').value;

  		
		if(selectmenu1 == "Others")
		{
			document.getElementById('selectTemp').style.display = 'block';
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
				
		}

       
    }
    
 </g:javascript>











<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
</head>
<body>
<g:form name="waterSourceUses" method="post" action="saveHwmGenInspection" >
<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Hazardeous Waste Details </td>
		</tr> 
				<tr align="center" class="error" >  <td> <g:if test="${flash.message}">
												<div class="message">${flash.message}</div>
												</g:if>
												<g:hasErrors bean="${airClimateMetrological}">
												<div class="errors">
													<g:renderErrors bean="${airClimateMetrological}" as="list" />
												</div>
												</g:hasErrors></td></tr>
				<tr >
			<tr><td>
				<table class="tblbdr" width="100%"  border="0" >
					<tr bgcolor="#A8DAF3">
					<input type="hidden" name="appId" value="<%=appDetId%>">
						<td width="20%" align="center" valign="middle"  class="headngblue">Name of HWM<span style="color:red">*</span></td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Category<span style="color:red">*</span></td> 
						<td width="20%" align="center" valign="middle"  class="headngblue">Quantity<span style="color:red">*</span></td> 
						<td width="20%" align="center" valign="middle"  class="headngblue">Unit<span style="color:red">*</span></td> 
						<td width="20%" align="center" valign="middle"  class="headngblue">Mode of Treatment<span style="color:red">*</span></td> 
					</tr>
					
					<tr>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="nameHwm" type="text" size="15"class="txt4" /></td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="catgeory" type="text" size="15"class="txt4" />	</td>					
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="quantity" type="text" size="15"class="txt4" />	</td>					
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><g:select from="${UnitMaster.list()}" name="unit" optionKey="id"/></td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="modeOfTreatment" type="text" size="15"class="txt4" />	</td>
					</tr>
					
					
					<tr>
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr>
					
			  	</table>
						
				</td></tr>
				<tr>
				<td align="center"><span class="txt" style="color: navy"><b>Hazardeous Waste Details.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%"  border="0">
 					
 					<tr bgcolor="#A8DAF3">
 					     <td width="20%" align="center" valign="middle"  class="headngblue">Sr</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Name of HWM</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Category</td>
						<td width="40%" align="center" valign="middle"  class="headngblue">Quantity</td>
						<td width="40%" align="center" valign="middle"  class="headngblue">Mode of Treatment</td>
					</tr>
 <g:each in="${listof}" status="i" var="listof">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${++i}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.nameHWM}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.category}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.quantity}/  ${listof.unit.unitName}</span></td> 
                        
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.modeoftreatment}</span></td> 
                        </tr>			
    </g:each>
 					
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
				</td>
				</tr>
				</table>
				</div>
				</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("consumption","req","please enter Consumption ");
 // frmvalidator.addValidation("use","req","please enter Use");
  frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
 frmvalidator.addValidation("mscb","req","please enter Minimum sizes of carry bags");
  frmvalidator.addValidation("mscb","dec","Minimum sizes of carry bags  should be numeric or decimal");
  frmvalidator.addValidation("rules","req","please enter Status of compliance ");
  //frmvalidator.addValidation("effDischarge","dec","Effluent Discharged should be numeric");
  
 </script>   
 
			
</body>