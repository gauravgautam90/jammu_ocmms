<%@page import="java.util.ArrayList"%>
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
   
   			var selectmenu1=document.getElementById('parameter').value;

  		
		if(selectmenu1 == "other")
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
<g:form name="waterSourceUses" method="post" action="saveEWWaterSourcedetails" >
<table width="100%">
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
			
			
					
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Waste Water Discharge Details</td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                
                <td  width="30%" align="center" class="headngblue">Location</td>
                <td width="30%" align="center" class="headngblue">Quantity (m3/day)</td>
                	
                	 <td width="30%" align="center" class="headngblue">Parameter</td>
                	
              	</tr>
			<input maxlength="250" type="hidden" name="app" value="<%=appDetId%>">
             	
				
						
		  	<tr>
		  	
		  		<td  align="center" class="headngblue">
                  <input type="text"  name="location" id="location" class="txt4"/>
               
                </td>		  	   
		  	 <td  align="center" class="headngblue">
                  <input type="text"  name="quantity" id="quantity" class="txt4"/>
               
                </td>
		  	
		  
                <td  align="center" class="headngblue">
                 
                                 <g:select class="txt4" from="${['pH','BOD','COD','SS O&G','other']}" name="parameter" id="parameter" onchange="javascript:check1();" > </g:select> 
								
								<div style="display:none; border:0;"  id="selectTemp"  >  <input type="text"  name="otherParameter" id="otherParameter" class="txt4" /> </div>
																</span></td>
                </td>
                
               
                              
				
              </tr>
          
           		
		  </table>
		
</td>
</tr>



 					
 					 </g:form>
 					 
 					
 					
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
 					
 				<tr><td> <span class="txt" style="color: navy"><b>Waste Water Discharge Details added.</b></span>
 				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
                <td  width="30%" align="center" class="headngblue"> Location</td>
                <td width="30%" align="center" class="headngblue">Quantity (m3/day)</td>
                
                  <td  width="30%" align="center" class="headngblue"> Parameter</td>
              	</tr>
               <g:each in="${waterGenarationList}" status="i" var="waterDetails">
  	
                             <tr>
                             
                        		<td width="30%" align="center" valign="middle"  bgcolor="#E8F6F9" ><span class="txt style6">${waterDetails.location}</span></td>
                        			<td width="30%" align="center" valign="middle"  bgcolor="#E8F6F9" ><span class="txt style6">${waterDetails.quantity} </span></td>
                        		<td width="30%" align="center" valign="middle"  bgcolor="#E8F6F9" ><span class="txt style6">${waterDetails.parameter} ${waterDetails.otherParameter}</span></td>
                        			  </tr>
                        		 
 								</g:each>		
 		
 				
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>

</td></tr>
</table>

 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 frmvalidator.addValidation("quantity","req","Please enter quantity");
  
  frmvalidator.addValidation("quantity","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("location","req","Please enter location");
      
 
 </script> 

		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>