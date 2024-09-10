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


 <g:javascript>
    
function check1()
    {
   
   			var selectmenu1=document.getElementById('fuel').value;

  		
		if(selectmenu1 == "Others")
		{
			document.getElementById('selectTemp').style.display = 'block';
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
				
		}

       
    }
    
 </g:javascript>











<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
</head>
<body>
<g:form name="waterSourceUses" method="post" action="saveFuelconsumptiondetails" >
<table width="100%">
<tr>
<td>

		<table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
			
			
					
				<tr bgcolor="#D1D1D1">
		
		<td  colspan="5" align="center" valign="middle"  class="headngblue">Fuel Consumption Details </td>
		</tr> 
				
				<tr bgcolor="#A8DAF3" >
					<input type="hidden" name="appId" value="<%=appDetId%>">
						<td width="20%" align="center" valign="middle"  class="headngblue">Fuel</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Quantity per day/month</td>
						
					</tr>
					
					<tr>
						
						
					
						<td align="center" class="headngblue"><input name="fuel" type="text" maxlength="5" size="15"class="txt4" />
							
						<td  align="center" class="headngblue"><input name="consumption" type="text" size="15"class="txt4" />
						
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
 			
				<tr><td align="center"><span class="txt" style="color: navy"><b>Fuel Consumption Details added.</b></span>
				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
               	
 				
 					     <td width="50%" align="center" valign="middle"  class="headngblue">Fuel</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Quantity per day/month</td>
					
					</tr>
 <g:each in="${fuelconsumptionDetails}" status="i" var="fuelconsumptionDetails">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${fuelconsumptionDetails.fuel}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${fuelconsumptionDetails.consumption}</span></td>
                        
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
  frmvalidator.addValidation("fuel","req","Please enter Fuel name");
  frmvalidator.addValidation("consumption","dec","Please enter decimal or numeric value in the quantity of fuel consumption");
   
 
  
  
 </script>  
				
 
			
</body>