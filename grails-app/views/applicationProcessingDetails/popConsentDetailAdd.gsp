<%@ page import="java.text.SimpleDateFormat"%>
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
<calendar:resources lang="en" theme="aqua"/>
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
<g:form name="waterSourceUses" method="post" action="saveConsentDetails" >
<input type="hidden" value="<%=type%>" name="type"/>
<table>
<tr>
<td>

		<table width="100%"  border="1" bordercolor="black" align="center" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Status Of consent Granted earlier/td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="35%" align="center" class="headngblue">Consent </td>
                <td width="15%" align="center" class="headngblue">Number</td>
                <td width="15%" align="center" class="headngblue">Date</td>
              
               
                </tr>
			  
 			
			  
			  
		  
		  	<tr>
		  	
          
                <td  align="center" class="headngblue">
                 	<g:select class="txt4" from="${['AIR and WATER','HAZARDEOUS WASTE']}" onclick="javascript:select99()" name="consent" id="consent"  > </g:select> 
                  <br>
                </td>
              
                <td  align="center" class="headngblue">
                <input type="text"  name="number" size="4" class="txt4" />
                <br>
                </td>
              
           
            
         <td  align="center" class="headngblue">
		  	<input type="hidden" name="appid" value="${appDetId}">
		  	<calendar:datePicker name="dateConsent" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
            <br>
          </td>
        
              </tr>
              
             
           
          
		  </table>
		 
</td>
</tr>

<tr><td align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
<tr><td>&nbsp;</td></tr>

<tr><td>


<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px; align:center" >
 <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>Consent details</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				
                <td  width="25%" align="center" class="headngblue">Consent</td>
                <td width="25%" align="center" class="headngblue">Number</td>
                <td width="25%" align="center" class="headngblue">Date</td>
               
                
              	</tr>
 <g:each in="${consentDetailsList}" status="i" var="consentDetailsinst">
  	<tr align="center" >
  	<%def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
  	def x=consentDetailsinst.dateConsent
  	def date2=sdfh.format(x)
  
  	%>
  					
                        <td ><span class="txt style6">${consentDetailsinst.consent}
                        </span></td>
                        <td ><span class="txt style6">${consentDetailsinst.number}
                        </span></td>
                        
                              <td ><span class="txt style6">${date2}
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
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
// frmvalidator.addValidation("product","req","Please enter Product Name");
// frmvalidator.addValidation("product","maxlength=50","Product Name should be upto 50 characters");
//frmvalidator.addValidation("quantity","req","Please enter Product Quantity");
  frmvalidator.addValidation("ph","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("doin","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("bdo","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("cod","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("ss","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("og","decimal","Quantity should be numeric or decimal");
  
  
  </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>