<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />

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
   
   			var selectmenu1=document.getElementById('waterSourceUses.id').value;

  		
		if(selectmenu1 == "6")
		{
			document.getElementById('selectTemp').style.display = 'block';
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
				
		}

       
    }
    
 </g:javascript>
    
</head>
<body>
<g:form name="waterSourceUses" method="post" action="saveEWWaterSourceUses" >
<table width="100%">
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Water Consumption Details</td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="50%" align="center" class="headngblue">Source Consumption</td>
                <td width="50%" align="center" class="headngblue">Quantity (m3/day)</td>
                	
              	</tr>
			<input maxlength="250" type="hidden" name="app" value="<%=appDetId%>">
             	
				
						
		  	<tr>		  	   
                <td  align="center" class="headngblue">
                 
                                   <g:select class="txt4" optionKey="id"  from="${WaterUsesMaster.list()}" name="waterSourceUses.id" id="waterSourceUses.id" onchange="javascript:check1();"></g:select>
                  <div style="display:none; border:0;"  id="selectTemp"  >  <input type="text"  name="otherSource" id="otherSource" class="txt4" /> </div>
                </td>
                
                </td>
                <td  align="center" class="headngblue">
                  <input type="text"  name="sourceUseQuantity" id="sourceUseQuantity" class="txt4"/>
               
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
 					
 				<tr><td> <span class="txt" style="color: navy"><b>Water Consumption Details added.</b></span>
 				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
                <td  width="50%" align="center" class="headngblue"> Source Consumption</td>
                <td width="50%" align="center" class="headngblue">Quantity (m3/day)</td>
                
              	</tr>
               <g:each in="${waterGenarationList}" status="i" var="waterDetails">
  	
                             <tr>
                             	<td width="50%" align="center" valign="middle"  bgcolor="#E8F6F9" ><span class="txt style6">${waterDetails.use.useType}  ${waterDetails.otherSource}</span></td>
                        		<td width="50%" align="center" valign="middle"  bgcolor="#E8F6F9" ><span class="txt style6">${waterDetails.quantity}</span></td>
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
 
  frmvalidator.addValidation("sourceUseQuantity","req","Please enter quantity");
  frmvalidator.addValidation("sourceUseQuantity","decimal","Quantity should be numeric or decimal");
      
 
 </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>