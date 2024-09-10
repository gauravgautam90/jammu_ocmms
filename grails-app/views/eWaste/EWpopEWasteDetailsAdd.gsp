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
<g:form name="waterSourceUses" method="post" action="saveEWasteDetails" >
<table width="100%">
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="7"  align="center" valign="middle"  class="headngblue">E-Waste Details</td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
				<td width="10%" align="center" class="headngblue">Name</td>
				 <td width="10%" align="center" class="headngblue">Quantity required/year</td>
                <td  width="10%" align="center" class="headngblue">Basel Convention Number</td>
              	</tr>
			  
			  
		  	<tr>
                <td  align="center" class="headngblue">
                  <input type="text"  name="name" size="20" class="txt4" />
                  <span class="sidetxt">&nbsp;</span>
                </td>
                <td   align="center" class="headngblue">
                  <input type="text"  name="quantity" class="txt4"/><input maxlength="250" type="hidden" name="appId" value="<%=appDetId%>">
             
               </td>
                
                
              
                
                <td  align="center" class="headngblue">
                 
                  <input type="text"  name="conventionNo" size="20" class="txt4" />
                  <span class="sidetxt">&nbsp;</span>
                
                </td>
             
              </tr>
              
             
              
            
          
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
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of E-Waste Details added.</b></span>
 				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				 <td width="10%" align="center" class="headngblue">Name</td>
                <td  width="10%" align="center" class="headngblue">Quantity required/year</td>
              
                                <td width="10%" align="center" class="headngblue">Basel Convention Number</td>
                                
             
              	</tr>
 <g:each in="${ewasteDetailsList}" status="i" var="ewasteDetails">
  	<tr align="center" >
  	<td ><span class="txt style6">${ewasteDetails.name}
                        </span></td>
  					<td ><span class="txt style6">${ewasteDetails.quantity}
                        </span></td>
                      
                        <td ><span class="txt style6">${ewasteDetails.conventionNo}
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
   frmvalidator.addValidation("name","req","please enter the name");
   frmvalidator.addValidation("quantity","dec","Please enter decimal or numeric value in Quantity");
  
  </script>
 
  
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>