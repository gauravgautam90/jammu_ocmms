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
<g:form name="waterSourceUses" method="post" action="deleteHwmGeneralInspection" >
<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Name and Categories of HWM generated and their respective quantity</td>
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
					
					
					
					
					
					
			  	</table>
						
				</td></tr>
				<tr>
				<td align="center"><span class="txt" style="color: navy"><b>Name and Categories of HWM generated and their respective quantity</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%"  border="0">
 					
 					<tr bgcolor="#A8DAF3">
					
					<td width="2%" rowspan="3" align="center" valign="middle"  class="headngblue">Sr<span style="color:red">*</span></td>
						<td width="20%" rowspan="3" align="center" valign="middle"  class="headngblue">Various production plant/process at facility <span style="color:red">*</span></td>
						<td width="20%" rowspan="3"align="center" valign="middle"  class="headngblue">Name of HWM (with category) generated in Tonne and half quantity per tonne of input<span style="color:red">*</span></td> 
						<td width="20%" rowspan="3" align="center" valign="middle"  class="headngblue">HWM Generation(in tonne) per tonne of the consented product<span style="color:red">*</span></td> 
						<td width="20%" rowspan="3" align="center" valign="middle"  class="headngblue">HWM Generation as per the consented capecity of product(Tonne per day or month or annum)<span style="color:red">*</span></td> 
						<td width="20%" colspan="4" align="center" valign="middle"  class="headngblue">Actual Quantity of products produce of input used<span style="color:red">*</span></td> 
						<td width="20%" colspan="2" align="center" valign="middle"  class="headngblue">Actual quantity of generated<span style="color:red">*</span></td> 
					</tr>
					<tr bgcolor="#A8DAF3">
					
						
						<td width="20%" colspan="2" align="center" valign="middle"  class="headngblue">During current fincial year(as on date of inspection)<span style="color:red">*</span></td> 
						<td width="20%" colspan="2" align="center" valign="middle"  class="headngblue">During Previous Finicial year<span style="color:red">*</span></td> 
						<td width="20%" rowspan="2" align="center" valign="middle"  class="headngblue">During current fincial year(as on date of inspection)<span style="color:red">*</span></td> 
						<td width="20%" rowspan="2" align="center" valign="middle"  class="headngblue">During Previous Finicial year<span style="color:red">*</span></td> 
					</tr>
					<tr bgcolor="#A8DAF3">
					
						
						<td width="20%" align="center" valign="middle"  class="headngblue">Production<span style="color:red">*</span></td> 
						<td width="20%" align="center" valign="middle"  class="headngblue">Input<span style="color:red">*</span></td> 
						<td width="20%" align="center" valign="middle"  class="headngblue">Production<span style="color:red">*</span></td> 
						<td width="20%" align="center" valign="middle"  class="headngblue">Input<span style="color:red">*</span></td> 
					</tr>
 <g:each in="${listof}" status="i" var="listof">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${++i}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.productionPlant}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.hmwName}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.quantityHWMGen}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.quantityConsentedCap}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.production1}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.input1}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.production2}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.input2}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.quantityCurrentFinYear}</span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.quantityPrevFinYear}</span></td>
                        <td  bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=listof.id%>"/>
                        </span></td>
                       
                        </tr>			
    </g:each>
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
 					<tr>

  				   <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  				  </tr>
					
					  
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