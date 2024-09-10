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
<g:form name="waterSourceUses" method="post" action="saveProductDetails" >
<table>
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
						               
              <tr bgcolor="#D1D1D1">
					<td colspan="8"  align="center" valign="middle"  class="headngblue">Product Details </td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="10%" align="center" class="headngblue">Products (Name)<span style="color:red">*</span></td>
                <td  width="10%" align="center" class="headngblue">Unit Type</td>
                <td width="10%" align="center" class="headngblue">Quantity
                (in selected Unit Type)</td>
                <td width="10%" align="center" class="headngblue">Maximum Installed Production Capacity 
                (Same Unit)</td>
				
				</tr>
			  
			  
		  
		  	<tr>
                <td   align="center" class="headngblue">
                  
                  <input type="text"  name="Product" class="txt4"/><input maxlength="250" type="hidden" name="appDetId" value="<%=app%>">
               
               <br> <span class="sidetxt">(max. 250 chars)</span></td>
               
                <td  align="center" class="headngblue">
                 
                  <g:select optionKey="id"  class="txt4" from="${UnitMaster.list()}" name="unit" ></g:select>
            
                </td>
                
                <td  align="center" class="headngblue">
                 
                  <input type="text"  name="quantity" size="20" class="txt4" />
                  <span class="sidetxt">&nbsp;</span>
                
                </td>
               
                <td  align="center" class="headngblue">
                
                  <input type="text"  name="installedProductCapacity" maxlength="250" size="20" class="txt4" />
                
                </td>
                
				
                
                
              </tr>
              
             
              
              
             <tr>
             	<td>
          
             	</td>
             </tr>
		
		  </table>
		 
</td>
</tr>
<tr><td align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
<tr><td>&nbsp;</td></tr>

<tr><td>


<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of By-Product Details added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				
 					
 			<tr bgcolor="#A8DAF3" >
                <td  width="10%" align="center" class="headngblue">Products (Name)</td>
                <td  width="10%" align="center" class="headngblue">Unit Type</td>
                <td width="10%" align="center" class="headngblue">Quantity 
                (in selected Unit Type)</td>
              <td width="10%" align="center" class="headngblue">Maximum Installed Production Capacity 
              (Same Unit)</td>
				
				</tr>
						
 		<g:each in="${productDetails}" status="i" var="byProductDetailsInst">
  	<tr align="center" >
  					<td ><span class="txt style6">${byProductDetailsInst.product}
                        </span></td>
                        
                        <td ><span class="txt style6">${byProductDetailsInst.unit}
                        </span></td>
                        <td ><span class="txt style6">${byProductDetailsInst.quantity}
                        </span></td>
                        <td ><span class="txt style6">${byProductDetailsInst.installedCapacity}
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
  frmvalidator.addValidation("byProduct","req","Please enter Product Name");
  frmvalidator.addValidation("byProduct","maxlength=50","Product Name should be upto 50 characters");
  frmvalidator.addValidation("installedProductCapacity","req","Please enter Installed Production Capacity");
  
  frmvalidator.addValidation("licencedProductCapacity","decimal","Licenced Capacity should be numeric or decimal");
  frmvalidator.addValidation("installedProductCapacity","decimal","Installed Production Capacity should be numeric or decimal");
  frmvalidator.addValidation("byProductAvgProduction","decimal","Avg. Actual Production should be numeric or decimal");
  frmvalidator.addValidation("byProductAvgSoughtProduction","decimal","Production for which consent is sought for be numeric or decimal");
  frmvalidator.addValidation("quantity","req","please enter quantity");
  frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
  </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>