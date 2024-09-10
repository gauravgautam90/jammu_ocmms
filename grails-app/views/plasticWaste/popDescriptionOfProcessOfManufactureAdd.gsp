<head>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">


</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
<g:form name="waterSourceUses" method="post" action="saveProcessOfManufacturing" >
<table>
<tr>
<td>

		<table width="90%" class="tblbdr" border="01" bordercolor="black" align="center" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Description of process of manufacture for each of the products (showing input, output, quality and quantity of solid, liquid and gaseous wastes, if any from each unit process)
					(To be supported by flow sheet and/or water balance	sheet)</td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="15%" align="center" class="headngblue">Flow of manufacturing process </td>
                <td width="15%" align="center" class="headngblue">Description of manufacturing process</td>
                
              	</tr>
			  
 			
			  
		  
		  	<tr>
                <td   align="center" class="headngblue">
                  <input maxlength="500" type="text" size="100" name="flow" class="txt4"/>
                <span class="sidetxt"><br>(max. 500 chars)</span></td>
                <td  align="center" class="headngblue"><input maxlength="500" type="hidden" name="appDetId" value="<%=app%>">
                  <input type="text"  name="description" size="100" class="txt4" />
                  <span class="sidetxt">&nbsp;</span>
                </td>
               
              </tr>
             
             
             
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
 					
 				<tr><td align="center"> <span class="txt" style="color: navy"><b>List of manufacturing process Details added.</b></span>
 				<table width="90%" align="center" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
                <td  width="15%" align="center" class="headngblue">Flow of manufacturing process </td>
                <td width="15%" align="center" class="headngblue">Description of manufacturing process</td>
                
              	</tr>
 <g:each in="${productDetails}" status="i" var="productDetails">
  	<tr align="center" >
  					<td ><span class="txt style6">${productDetails.flow}
                        </span></td>
                        <td ><span class="txt style6">${productDetails.description}
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
  frmvalidator.addValidation("description","req","Please enter Description");
  frmvalidator.addValidation("flow","req","Please enter Flow of manufacturing process");
  frmvalidator.addValidation("flow","maxlength=50","Flow of manufacturing process should be upto 50 characters");
  //frmvalidator.addValidation("quantity","req","Please enter Product Quantity");
  frmvalidator.addValidation("byProduct","req","Please enter By Products & Quantity");
  frmvalidator.addValidation("rawMaterials","req","Please enter Raw Materials");
  frmvalidator.addValidation("intermediateProd","req","Please enter Intermediate Product");
  frmvalidator.addValidation("processingChem","req","Please enter Processing Chemicals");
 // frmvalidator.addValidation("principalUse","req","Please enter Principal Use");
 //  frmvalidator.addValidation("processingChem","dec","processing chemical should be numeric or decimal");
 
 // frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
  //frmvalidator.addValidation("modeUseWasteGeneration","dec","Waste Water Generated should be numeric or decimal");
 </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>