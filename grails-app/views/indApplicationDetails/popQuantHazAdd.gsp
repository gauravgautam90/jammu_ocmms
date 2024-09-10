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
<g:form name="waterSourceUses" method="post" action="saveStoreModedetails" >

<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Quantity of Hazardeous waste </td>
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
					<input type="hidden" name="app8" value="<%=appDetId%>">
					<td width="10%" align="center" valign="middle"  class="headngblue">Name of the Hazardous Waste generated/to be generated<span style="color:red">*</span></td>
					<td width="10%" align="center" valign="middle"  class="headngblue">Nature of Hazardous Waste(recyclable/incinerable/storagable)<span style="color:red">*</span></td>
					<td width="10%" align="center" valign="middle"  class="headngblue">Category of Hazardous Waste<span style="color:red">*</span></td>
					<td width="10%" align="center" valign="middle"  class="headngblue">Total Quantity of Hazardous Waste generated/to be generated(in tones/annum)<span style="color:red">*</span></td>
					<td colspan="3" width="40%" align="center" class="headngblue" ><div>Mode of Disposal</div></td>
					
					
					</tr>
					
					
					
					<tr>
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="name" type="text" size="15"class="txt4" />
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="nature" type="text" size="15"class="txt4" />
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="category" type="text" size="15"class="txt4" />
					<td bgcolor="#E8F6F9" align="center" class="headngblue"><input name="totalquant" type="text" size="15"class="txt4" />
					
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
					Quantity of hazardous waste shifted/to be shifted to common TSDF<span style="color:red">*</span><input name="quantTSDF" type="text" size="8"class="txt4" />
					</td>
				    <td bgcolor="#E8F6F9" align="center" class="headngblue">
				    Quantity of hazardous waste given/to be given to regd. Recycler<span style="color:red">*</span><input name="quantRec" type="text" size="8"class="txt4" />
					</td>
					<td bgcolor="#E8F6F9" align="center" class="headngblue">
					Quantity of hazardous waste being/to be managed in the premises<span style="color:red">*</span><input name="quantPre" type="text" size="8"class="txt4" />
					</td>
					
				
				</tr>
					<tr>
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr>
		
		</table>
						
				</td></tr>
				<tr>
				<td align="center"><span class="txt" style="color: navy"><b>Details added.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
				<table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1" class="tblbdr" >
 
 
				<tr><td><table class="tblbdr" width="100%"  border="0">
 					
				<tr bgcolor="#A8DAF3">
		        <td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Name of the Hazardous Waste generated/to be generated</td>
				<td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Nature of Hazardous Waste(recyclable/incinerable/storagable)</td>
				<td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Category of Hazardous Waste</td>
				<td rowspan="2" width="10%" align="center" valign="middle"  class="headngblue">Total Quantity of Hazardous Waste generated/to be generated(in tones/annum)</td>
				<td colspan="3" width="40%" align="center" class="headngblue" ><div>Mode of Disposal</div></td>
				</tr><tr bgcolor="#A8DAF3">
				<td width="10%" align="center" class="headngblue" >Quantity of hazardous waste shifted/to be shifted to common TSDF</td>
				<td width="10%" align="center" class="headngblue" >Quantity of hazardous waste given/to be given to regd. Recycler</td>
				<td width="10%" align="center" class="headngblue" >Quantity of hazardous waste being/to be managed in the premises</td>
				
		</tr>
					
		<g:each in="${soliddetails1}" status="i" var="soliddetails1">
		<tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${soliddetails1.name}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${soliddetails1.nature}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${soliddetails1.category}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${soliddetails1.totalquant}</span></td>
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        <br>${soliddetails1.quantTSDF}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        <br>${soliddetails1.quantRec}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        <br>${soliddetails1.quantPre}</span></td>
                     	
                        
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
				var frmvalidator = new Validator("waterSourceUses");
				frmvalidator.EnableFocusOnError(false);
				frmvalidator.EnableMsgsTogether();
				frmvalidator.addValidation("nature","req","please enter Nature");
				
				</script>
				</body>