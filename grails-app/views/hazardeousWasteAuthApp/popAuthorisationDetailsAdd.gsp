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


 



<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
</head>
<body>
<g:form name="waterSourceUses" method="post" action="saveAuthorisationdetails" >
<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Authorisation Details </td>
		</tr> 
				<tr align="center" class="error" >  <td> <g:if test="${flash.message}">
												<div class="message">${flash.message}</div>
												</g:if>
												</td></tr>
				<tr >
			<tr><td>
				<table class="tblbdr" width="100%"  border="0" >
					<tr bgcolor="#A8DAF3">
					<input type="hidden" name="appId" value="<%=appDetId%>">
						<td width="20%" align="center" valign="middle"  class="headngblue">Category of Hazardous Waste as per the Schedules I, II and III of these rules</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Authorised mode of disposal or recycling or utilisation or co-processing, etc.<span style="color:red"></span></td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Quantity(ton/annum)<span style="color:red"></span></td>
					</tr>
					
					<tr>
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input type="text"  name="category" id="category" class="txt4" />
						</td>
						
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="mode" type="text" size="25"class="txt4" />
						<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="quantity" type="text"  size="25"class="txt4" />
						
						
					</tr>
					
					
					<tr>
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr>
					
			  	</table>
						
				</td></tr>
				<tr>
				<td align="center"><span class="txt" style="color: navy"><b>Authorisation Details added.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="20%" align="center" valign="middle"  class="headngblue">Category of Hazardous Waste as per the Schedules I, II and III of these rules</td>
					<td width="20%" align="center" valign="middle"  class="headngblue">Authorised mode of disposal or recycling or utilisation or co-processing, etc.<span style="color:red"></span></td>
					<td width="20%" align="center" valign="middle"  class="headngblue">Quantity(ton/annum)<span style="color:red"></span></td>
			</tr>
 <g:each in="${authorisationdetails}" status="i" var="authorisationdetails">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                       ${authorisationdetails.category}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${authorisationdetails.mode}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${authorisationdetails.quantity}</span></td>
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
  
  frmvalidator.addValidation("category","req","please enter category");
  //frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
 
 </script>   
 
			
</body>