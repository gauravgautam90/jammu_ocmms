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
<body>
<g:form name="waterSourceUses" method="post" action="saveConsentCertAirQualityParam" >
<table>

<tr align="center" class="error" >  <td> <g:if test="${flash.message}">
												<div class="message">${flash.message}</div>
												</g:if>
												</td></tr>



<tr>
<td>

		<table width="90%"  border="1" bordercolor="black" align="center" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Air Quality Parameter Details </td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
              <td width="15%" align="center" class="headngblue">Quality Parameter</td>
                <td width="15%" align="center" class="headngblue">Range</td>
                 <td width="15%" align="center" class="headngblue">Standard Value(in mg/Nm3)</td>
    		</tr>
			  
 			
			  
			  
		  
		  	<tr>
                
                
                <td   align="center" class="headngblue">
                
                <input maxlength="250" type="hidden" name="appId" value="<%=appDetId%>">
                 
                 
                  <g:select   class="txt4" from="${['PM','So2','No2']}" name="qualityParameter" ></g:select>
               <br> <span class="sidetxt">(select quality parameter)</span></td>
              
              
              
             
             
             
                <td  align="center" class="headngblue">                         
              
                
                  <g:select   class="txt4" from="${['Between','Not to be exceeded']}" name="range" ></g:select>
                <br><span class="sidetxt">(select the range)</span>
                </td>
              
              
              <td  align="center" class="headngblue">
                  <input type="text"  name="standardValue" size="10" class="txt4" />
                  <br><span class="sidetxt">(in mg/Nm3)</span>
                </td>
              
              
              
              
              
              
              
              
              
              </tr>
              
               
           
          
		  </table>
		 
</td>
</tr>

<tr><td align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
<tr><td>&nbsp;</td></tr>

<tr><td>
<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px; align:center" >
 <table width="90%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Quality of treated effluent added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				
                <td width="15%" align="center" class="headngblue">Quality Parameter</td>
                <td width="15%" align="center" class="headngblue">Range</td>
                 <td width="15%" align="center" class="headngblue">Standard Value</td>
               
              	</tr>
              	
 <g:each in="${prameterDetailsList}" status="i" var="productDetails">
  	<tr align="center" >
  				
                        <td ><span class="txt style6">${productDetails.qualityParameter}
                        </span></td>
                        <td ><span class="txt style6">${productDetails.range}
                        </span></td>
                      <td ><span class="txt style6">${productDetails.standardValue}
                        </span></td>         
    </tr>		
 </g:each>		
 				
 			<!--		
 		<tr><td ><span class="txt style6">Licencesed Annual Capacity Of the Factory
                        </span></td>
                        <td><input class="txt4" type="text" value="${d}" readonly name="annualProdCap"/></td>			
 					</tr>
 			-->		
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
  //frmvalidator.addValidation("product","req","Please enter Product Name");
  //frmvalidator.addValidation("product","maxlength=50","Product Name should be upto 50 characters");
  frmvalidator.addValidation("standardValue","req","Please enter  Quantity");
  frmvalidator.addValidation("standardValue","decimal","standard Value should be numeric or decimal");
  //frmvalidator.addValidation("modeUseWasteGeneration","numeric","Waste Water Generated should be numeric");
 </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>