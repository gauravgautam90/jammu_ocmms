<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<body onload = "javascript:select1()">
<g:form name="saveDGParameterMaster" method="post" action="saveDGParameterInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table>
<tr>
<td>

		<table width="100%"  border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">D.G. Set Parameter Details </td>
				</tr> 
				
			 <tr bgcolor="#A8DAF3" >
                  <td  width="50%" align="center" class="headngblue">Parameters</td>
                  <td width="25%" align="center" class="headngblue">No Load Condition</td>
                  <td width="25%" align="center" class="headngblue">Full Load Condition</td>
             </tr>
			  
		  	<tr>
		  	
                <td   align="center" class="headngblue">
                  <input maxlength="250" type="hidden" name="appId" value="<%=appDetId%>">
               
               	 <g:select  from="${['Not Selected','Noise level in dB(A) at 0.5 m from the acoustic enclosure','Smoke Density(specify unit)','Particulate Matter in mg/Nm3','Carbon Monoxide in %']}" name="parameters" value="" class="txt4"></g:select>
																
			      </td>
                <td  align="center" class="headngblue">
                  <input type="text"  name="noLoad" id="noLoad" class="txt4" />
                
                </td>
                <td  align="center" class="headngblue">
                  <input type="text"  name="fullLoad" id="fullLoad" class="txt4"/>
               
                </td>
               
              </tr>
           
		
		  </table>
		 
</td>
</tr>
<tr><td align="center"><span style="color:red">*Please enter NA where nothing is applicable</span><br><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
<tr><td>&nbsp;</td></tr>
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
 <table width="90%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of D.G. Set Parameter Details Added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
                	<td  width="25%" align="center" class="headngblue">Parameters</td>
	                <td width="25%" align="center" class="headngblue">No Load Condition</td>
	                <td width="25%" align="center" class="headngblue">Full Load Condition</td>
	            </tr>
 <g:each in="${dgList}" status="i" var="dgInst">
  	<tr align="center" >
  					<td   ><span class="txt style6">${dgInst.parameters}
                        </span></td>
                        <td ><span class="txt style6">${dgInst.noLoad}
                        </span></td>
                        <td ><span class="txt style6">${dgInst.fullLoad}
                        </span></td>
                                                     
    </tr>		
 </g:each>		
 					
 				
 		
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>

</td></tr>
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
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("saveDGParameterMaster");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 <!--
  frmvalidator.addValidation("capital","req","Please enter Total Capital (in Rs.)");
    frmvalidator.addValidation("capital","numeric","Total Capital should be numeric");
    frmvalidator.addValidation("recurring","numeric","Recurring should be numeric");
 -->    
 
 </script> 
		
		  	 
</body>