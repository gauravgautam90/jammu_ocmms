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
<g:form name="waterSourceUses" method="post" action="saveCostDetails" >
<table>
<tr>
<td>

		<table width="100%"  border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Estimeted Cost Details</td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="20%" align="center" class="headngblue">Expenditure Proposed For</td>
                <td width="15%" align="center" class="headngblue">Capital(in Rs.)</td>
                <td width="15%" align="center" class="headngblue">Recurring(in Rs.)</td>
               
              	</tr>
			  
		  	<tr>
		  	
                <td   align="center" class="headngblue">
                  <input maxlength="250" type="hidden" name="appId" value="<%=appDetId%>">
               
               	 <g:select  from="${['Not Selected','Water Pollution Control','Air Pollution Control','Disposal Arrangement','Solid Waste Handling','Hazardous Waste Disposal','Pollution Monitoring']}" name="expenditureProposed" value="" class="txt4"></g:select>
																
			      </td>
                <td  align="center" class="headngblue">
                  <input type="text"  name="capital" id="capital" class="txt4" />
                
                </td>
                <td  align="center" class="headngblue">
                  <input type="text"  name="recurring" id="recurring" class="txt4"/>
               
                </td>
               
              </tr>
           
		
		  </table>
		 
</td>
</tr>
<tr><td align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
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
 <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Estimeted Cost Details added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
               <td  width="20%" align="center" class="headngblue">Expenditure Proposed For</td>
                <td width="15%" align="center" class="headngblue">Capital(in Rs.)</td>
                <td width="15%" align="center" class="headngblue">Recurring(in Rs.)</td>
               
              	</tr>
 <g:each in="${costDetailsList}" status="i" var="costDetails">
  	<tr align="center" >
  					<td ><span class="txt style6">${costDetails.expenditureProposed}
                        </span></td>
                        <td ><span class="txt style6">${costDetails.capital}
                        </span></td>
                        <td ><span class="txt style6">${costDetails.recurring}
                        </span></td>
                                                     
    </tr>		
 </g:each>		
 					
 				
 		
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>

</td></tr>
</table>
 </g:form>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 
  frmvalidator.addValidation("capital","req","Please enter Total Capital (in Rs.)");
    frmvalidator.addValidation("capital","decimal","Total Capital should be numeric or decimal");
    frmvalidator.addValidation("recurring","decimal","Recurring should be numeric or decimal");
         
 
 </script> 
		
		  	 
</body>