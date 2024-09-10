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
<g:form name="waterSourceUses" method="post" action="saveHazardGenDetailsInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table width="100%" border="0" align="center">
<tr>
<td>

		<table width="110%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Activity/Hazardous Waste Generation Details</td>
				</tr>
				<%if(!hazarWasteGenDetailsList) {%> 
				<tr>
                
              	<td  bgcolor="#A8DAF3"  align="center"  class="headngblue">Authorization Required For</td>
                
               	<td   align="left" class="txt4" colspan="3">
                  <input type="checkbox" name="chkCollection" id="chkCollection" />
					Collection 
				<input type="checkbox" name="chkReception" id="chkReception" />
					Reception 
				<input type="checkbox" name="chkTreatment" id="chkTreatment" />
				Treatment 
				<input type="checkbox" name="chkTransport" id="chkTransport" />
				Transport 
				<input type="checkbox" name="chkStorage" id="chkStorage" />
				Storage    
				<input type="checkbox" name="chkDisposal" id="chkDisposal" /> 
				Disposal
				
				</td>
              	</tr>
              	<%}%>
				<tr bgcolor="#A8DAF3" >
                <td  width="35%" align="center" class="headngblue">Source of Generation</td>
                <td width="40%" align="center" class="headngblue">Name</td>
                <td width="25%" align="center" class="headngblue">Quantity(per day in TPD)</td>
				</tr>
			  
 			
			  
		  	<tr>
                <td   align="center" class="headngblue">
                  <g:select
					optionKey="id" from="${HazardousSourceGenMaster.list()}"
					name="sourceName.id" 
					noSelection="${[9999:'Not Selected']}"
					onchange="${remoteFunction(controller:'indApplicationDetails', action:'myAjax',update:'updateSelect', params:'\'cont=\' + this.value' )}"
					class="txt4">
					</g:select>
				</td>
					
                <td  align="center" class="headngblue"><input name="appId" type="hidden" value="<%=appDetId%>" />
                 <div id="updateSelect"><g:select optionKey="id"
					from="${hazardNameList}" name="categoryName.id"
					onchange="${remoteFunction(controller:'indApplicationDetails', action:'myAjax1',update:'updateSelect1', params:'\'cont=\' + this.value' )}"
					class="txt4"></g:select>
                </td>
                
                <td  align="center" class="headngblue">
                  <input type="text"  name="quantity" id="quantity" maxlength="250" class="txt4" />
                
                </td>
               
              </tr>
              
             
       
             <tr>
             	<td>
          
             	</td>
             </tr>
			
		  </table>
		 
</td>
</tr>
<tr><td align="center"><input type="submit" name="Add" value="Add" onclick="return tosubmit();" class="actionbutton"></td></tr>
<tr><td>&nbsp;</td></tr>
										<tr>
										<!-- Div area for errors-->
										<td align="center" valign="middle">
										<span
											class="error">
											 <g:if test="${flash.message}">
											<div class="message">${flash.message}</div>
											</g:if>
											</span>
										</td>
									</tr>				
 				  
<tr><td>


<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="110%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Details added.</b></span>
 				<table width="100%" border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				
 				<td  width="20%" align="center" class="headngblue">Activity For</td>
                <td  width="30%" align="center" class="headngblue">Source of Generation</td>
                <td width="20%" align="center" class="headngblue">Name</td>
                <td width="20%" align="center" class="headngblue">Category</td>
                <td width="20%" align="center" class="headngblue">Quantity(per day in TPD)</td>
				
              	</tr>
 <g:each in="${hazarWasteGenDetailsList}" status="i" var="hazarWasteGenDetailsList">
  	<tr align="center" >
  					<td ><span class="txt style6">${hazarWasteGenDetailsList.authFor}
                        </span></td>
                        <td ><span class="txt style6">${hazarWasteGenDetailsList.sourceName.name}
                        </span></td>
                        <td ><span class="txt style6">${hazarWasteGenDetailsList.categoryName.name}
                        </span></td>
                        <td ><span class="txt style6">${hazarWasteGenDetailsList.categoryName.category}
                        </span></td>
                        <td ><span class="txt style6">${hazarWasteGenDetailsList.quantity}
                        </span></td>
                              
    </tr>		
 </g:each>		
 				
 					
 					</table></td></tr>
						
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
	  
  		</div>

</td></tr>
</table>
 </g:form>
 <script language="JavaScript" type="text/javascript">
 function tosubmit()
 {
 if(!(document.getElementById("chkCollection").checked) && !(document.getElementById("chkReception").checked) && !(document.getElementById("chkTreatment").checked) && !(document.getElementById("chkTransport").checked) && !(document.getElementById("chkStorage").checked) && !(document.getElementById("chkDisposal").checked))
 			{ 
 				alert("Please Check Atleast one Authorization Reqired For Check Box");
 				return false;
 			}
 }
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("quantity","req","Please enter Quantity");
  frmvalidator.addValidation("quantity","decimal","Quantity should be numeric or decimal");
  //frmvalidator.addValidation("modeUseWasteGeneration","numeric","Waste Water Generated should be numeric");
 </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>