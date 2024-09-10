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
<g:form name="waterSourceModeUses" method="post" action="saveAirMiscDetailMaster" >
<table width="100%" cellpadding="0" cellspacing="0">
<tr bgcolor="#D1D1D1">
					<td  align="center" valign="middle"  class="headngblue">Air Miscellaneous Details</td>
				</tr>
				<tr >
					<td>
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Release Of Odoriferous Compounds</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30 style4 style1">
							 <input name="appId" type="hidden" value="<%=appDetId%>" /> 
							 <input name="odorCompounds" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(e.g. Mercaptans,Phorate etc.)</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Do You Have Adequate Facility For Collection Of Samples Of Emmisions In The Form Of Port Holes, Platforms, Ladder, etc.</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <g:select class="txt4" from="${['Yes','No']}" name="facility"></g:select>
							<span class="sidetxt">(central board publication "emission regulations part III"(dec1985))</span></span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align=""left" >Quality Of Flue Gas/Process Emissions</td>
							  <td  bgcolor="#E8F6F9" align=""left" class="headngblue"><span class="style30">
							  <input name="quality" type="text" maxlength="50" size="25"class="txt4" />
							<span class="sidetxt">(enter quality of gas emissions, max 250)</span></span></td>
							</tr>
				
						  <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="6" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						 
						 </table>
					</td>
				</tr>
				<tr>
				<td>
				<!-- ------------ -->
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
				<span class="txt" style="color: navy"><b>List of air miscellaneous details added.</b></span>
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
                       <td width="33%" class="headngblue" ><div  class="style3">Release Of Odoriferous Compounds</div></td>
                        <td width="33%" class="headngblue" ><div  class="style3">Do You Have Adequate Facility For Collection Of Samples Of Emmisions In The Form Of Port Holes, Platforms, Ladder, etc.</div></td>
                        <td width="33%" class="headngblue" ><div  class="style3">Quality Of Flue Gas/Process Emissions</div></td>
                  </tr>
 <g:each in="${miscList}" status="i" var="miscInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9" ><span class="txt ">${miscInst.odorCompounds}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${miscInst.facility}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt ">${miscInst.quality}
                        </span></td>
                                  
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					</tr>
 					
 					
 				
 					
 					</table>
 					
 					<!-- ------ -->
				</td>
				</tr>
</table>
</g:form>

<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("odorCompounds","req","Please enter name of Odoriferous Compounds");
  frmvalidator.addValidation("quality","req","Please enter quality of gas emissions");
  
 </script> 
 
</body>