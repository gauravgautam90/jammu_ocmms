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
   
   			var selectmenu1=document.getElementById('metalsnalloy').value;

  		
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
<g:form name="waterSourceUses" method="post" action="saveInspectionDGSetAdd" >
<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Date Of last monitoring Detail </td>
		</tr> 
				<tr align="center" class="error" >  <td> <g:if test="${flash.message}">
												<div class="message">${flash.message}</div>
												</g:if>
												<g:hasErrors bean="${instanceDetails}">
												<div class="errors">
													<g:renderErrors bean="${instanceDetails}" as="list" />
												</div>
												</g:hasErrors></td></tr>
				<tr >
			<tr><td>
				<table class="tblbdr" width="100%"  border="0" >
					<tr bgcolor="#A8DAF3">
					<input type="hidden" name="appId" value="<%=appId%>">
						<td width="20%" align="center" valign="middle"  class="headngblue">Capacity (K.V)</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Housing Proper Improper</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Height of exhausted pipe from roof in meter(m)</td>
					</tr>
					
					<tr>
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue"> <input type="text"  name="capacity" id="capacity" class="txt4" /> </td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"> <input type="text"  name="housingStatus" id="housingStatus" class="txt4" /> </td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue"> <input type="text"  name="height" id="height" class="txt4" /> </td>
						
					</tr>
					
					
					<tr>
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr>
					
			  	</table>
						
				</td></tr>
				<tr>
				<td align="center"><span class="txt" style="color: navy"><b>DG Set Details added.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					    <td width="20%" align="center" valign="middle"  class="headngblue">Capacity (K.V)</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Housing Proper Improper</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Height of exhausted pipe from roof in meter(m)</td>
					</tr>
 <g:each in="${list}" status="i" var="list">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9">${list.capacity}</td>
						<td bgcolor="#E8F6F9">${list.housingStatus}</td>
						<td bgcolor="#E8F6F9">${list.height}</td>
						
                        </tr>		
    </g:each>
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
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
  frmvalidator.addValidation("name","req","please enter Use");
  frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
 frmvalidator.addValidation("weight","req","please enter Weight");
  frmvalidator.addValidation("mscb","dec","Minimum sizes of carry bags  should be numeric or decimal");
  frmvalidator.addValidation("rules","req","please enter Status of compliance ");
  //frmvalidator.addValidation("effDischarge","dec","Effluent Discharged should be numeric");
  
 </script>   
 
			
</body>