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
<g:form name="waterSourceUses" method="post" action="saveEWAmbientairqualitydetails" >
<table width="100%">
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
			
				<tr bgcolor="#D1D1D1">
		<td   colspan="7" align="center" valign="middle"  class="headngblue">Ambient Air Quality Details </td>
		</tr> 
				
				<tr bgcolor="#A8DAF3" >
					<input type="hidden" name="appId" value="<%=appDetId%>">
						<td width="20%" align="center" valign="middle"  class="headngblue">Location</td>
						<td colspan="6" width="40%" align="center" class="headngblue" ><div>Quality (mg/m3)</div></td>
						
						
					</tr>
					
					<tr>
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="location" type="text" size="15"class="txt4" />
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						SPM<input name="spm" type="text" size="8"class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						SO2<input name="so2" type="text" size="8"class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						NOx<input name="nox" type="text" size="8"class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						Pb<input name="pb" type="text" size="8"class="txt4" />
						</td>
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						Others<input name="others" type="text" size="8"class="txt4" />
						</td>
						
						
						
					</tr>
					
					</table>
		 
</td>
</tr>
					<tr>
		<td colspan="10" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr>
					
			  <tr>
					
					<!-- Div area for errors-->
                      
					  <td align="center" valign="top"><div style="width:500px;  vertical-align:middle">
					  <span class="error">
						<g:if test="${flash.message}">
						<div class="message">${flash.message}</div>
						</g:if>
						

                      </span></div></td>
                    </tr>
<tr><td>


<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
				<tr><td> <span class="txt" style="color: navy"><b>Ambient Air Quality Details added.</b></span>
				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 					     <td width="20%" align="center" valign="middle"  class="headngblue">Location</td>
						<td colspan="6" width="40%" align="center" class="headngblue" ><div>Quality, mg/m3<br>&nbsp;&nbsp;&nbsp;SPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SO2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Others</div></td></div></td>
						
						</tr>
 <g:each in="${ambientairqualitydetails}" status="i" var="ambientairqualitydetails">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${ambientairqualitydetails.location}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${ambientairqualitydetails.spm}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${ambientairqualitydetails.so2}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${ambientairqualitydetails.nox}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${ambientairqualitydetails.pb}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${ambientairqualitydetails.others}</span></td>
                       
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
 
  frmvalidator.addValidation("location","req","Please enter Location");
  
  frmvalidator.addValidation("spm","dec","Please enter valid spm");
   frmvalidator.addValidation("so2","dec","Please enter valid so2");
   frmvalidator.addValidation("nox","dec","Please enter valid nox");
   frmvalidator.addValidation("pb","dec","Please enter valid pb");
   
    
    
     
       frmvalidator.addValidation("others","dec","Please enter valid other");
 </script> 
</body>