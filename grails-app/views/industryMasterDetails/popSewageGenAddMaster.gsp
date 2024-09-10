<head>
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
		
 function checkEmptyField(){
		if((document.getElementById('source').value).trim()== ''){
				alert("Please enter Source Name");
				return false;
		}
		if((document.getElementById('quantity').value).trim()== ''){
				alert("Please enter quantity");
				return false;
		}else if((document.getElementById('quantity').value).trim()!= ''){
				var distance=  document.getElementById('quantity').value
				 if(Number(distance) >= 0){      
		       
		         if(distance.indexOf('.')!=-1){  
		         var d1=  distance.split(".")[0].length
		         var d2=  distance.split(".")[1].length
		           if(d2 > 2){                
		               alert("Quantity should be numeric or 2 decimals");
		               return false;  
		            }  
		         }  
		        
		        }else{
		      		alert("Quantity should be numeric or 2 decimals");
		            return false;
		       }
		}
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
   
   			var selectmenu1=document.getElementById('source').value;

  		
		if(selectmenu1 == "Others")
		{
			document.getElementById('selectTemp').style.display = 'block';
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
				
		}

       
    }
    
 </g:javascript>
</head>
<body onLoad="updateCity1();">
<g:form name="waterSourceUses" method="post" action="saveSewageGenerationDetMaster" >
<div align="center">
<table cellpadding="1" cellspacing="1" width="90%" class="tblbdr">
<input type="hidden"  name="page" value="<%=page%>" />
<% 
  def applicationObj=IndApplicationDetails.get((appDetId).toInteger())
  def sourceGen = WaterUsesDetails.findAllByApplication(applicationObj)%>

<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Average Daily consumption of Water Details</td>
		</tr> 
		
			<tr><td>
				<table class="tblbdr" width="100%"  border="0" >
				
				<input name="appId" type="hidden" value="<%=appDetId%>" />
				
					<tr bgcolor="#A8DAF3">	
					
					<%if(appFor=="productMix"){
						      %> 				
						<td width="50%" align="center" valign="middle"  class="headngblue">Purpose</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Existing Quantity</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Proposed Quantity</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Total Quantity after changes of Product Mix</td>
						<td width="20%" align="center" >Units</td>
					
					
					  <%}
							   
							   else if(appFor=="expansion") {%>
					
					    <td width="50%" align="center" valign="middle"  class="headngblue">Purpose</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Existing Quantity</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Expansion Quantity</td>
						<td width="50%" align="center" valign="middle"  class="headngblue">Total Quantity after Expansion</td>
						<td width="20%" align="center" >Units</td>
					 <%}else {%>
					
					 <td width="50%" align="center" valign="middle"  class="headngblue">Purpose</td>
					  <td width="50%" align="center" valign="middle"  class="headngblue">Quantity</td>
					  <td width="20%" align="center" >Units</td>
					  
					    <%}%>
					  
					</tr>
					
					
					
					<tr>
					<%if(appFor=="productMix"){
						      %> 
					
					
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<g:select class="txt4" from="${['Process','Washing','Boiler','Cooling','Scrubbers','DM plant','Greenbelt','Domestic','RO Plant','Others']}" name="source" id="source" value="${fieldValue(bean:indApplicationDetailsInstance,field:'source')}" onchange="javascript:check1();"> </g:select>
						<div style="display:none; border:0;"  id="selectTemp"  >  <input type="text"  name="otherSource" id="otherSource" class="txt4" /> </div>
						
						
						</td>
						
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="quantity" id="quantity" type="text" size="20" class="txt4" maxlength="100"/>
						<br><span class="sidetxt"></span></td>
						
						<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="proposedQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="totalQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select name="unit" id="unit" from="${['KLD']}" class="txt4"  ></g:select><br>
							<span class="sidetxt"></span></span></td>
						
						  <%}
							   
							   else if(appFor=="expansion") {%>
							   
							   
							   <td bgcolor="#E8F6F9" align="center" class="headngblue">
						<g:select class="txt4" from="${['Process','Washing','Boiler','Cooling','Scrubbers','DM plant','Greenbelt','Domestic','RO Plant','Others']}" name="source" id="source" value="${fieldValue(bean:indApplicationDetailsInstance,field:'source')}" onchange="javascript:check1();"> </g:select>
						<div style="display:none; border:0;"  id="selectTemp"  >  <input type="text"  name="otherSource" id="otherSource" class="txt4" /> </div>
						
						
						</td>
						
						
						<td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="quantity" id="quantity" type="text" size="20" class="txt4" maxlength="100"/>
						<br><span class="sidetxt"></span></td>
						
						<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="proposedQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <input name="totalQuant" type="text" maxlength="250" size="50" class="txt4" />
							<span class="sidetxt"></span></span></td>
							
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select name="unit" id="unit" from="${['KLD']}" class="txt4"  ></g:select><br>
							<span class="sidetxt"></span></span></td>
							   
							   
							    <%}else {%>
							   
							   
							   
							   	   
							   <td bgcolor="#E8F6F9" align="center" class="headngblue">
						<g:select class="txt4" from="${['Process','Washing','Boiler','Cooling','Scrubbers','DM plant','Greenbelt','Domestic','RO Plant','Others']}" name="source" id="source" value="${fieldValue(bean:indApplicationDetailsInstance,field:'source')}" onchange="javascript:check1();"> </g:select>
						<div style="display:none; border:0;"  id="selectTemp"  >  <input type="text"  name="otherSource" id="otherSource" class="txt4" /> </div>
						
						
						</td>
							   
							 <td bgcolor="#E8F6F9" align="center" class="headngblue">
						<input name="quantity" id="quantity" type="text" size="20" class="txt4" maxlength="100"/>
						<br><span class="sidetxt"></span></td>  
							   
							   
							<td  bgcolor="#E8F6F9" align="center" class="headngblue"><span class="style30">
							  <g:select name="unit" id="unit" from="${['KLD']}" class="txt4"  ></g:select><br>
							<span class="sidetxt"></span></span></td>
							      
							   
							    <%}%>
							 
							   
							   
							   
					</tr>
					
					
					<tr>
		<td colspan="5" align="center"><input type="submit" name="Add" value="Add" onclick="return checkEmptyField()" class="actionbutton"></td>
		</tr>
					
			  	</table>
						
				</td></tr>
				<tr>
				<td><span class="txt" style="color: navy"><b> Details	 added.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
               <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" align="center" width="100%">
 					
 					<tr bgcolor="#A8DAF3" align="center">
 					
 					<%if(appFor=="productMix"){
						      %> 
 					
 					
 					
 					   
 					    <td width="50%"  class="headngblue">Purpose</td>
						<td width="50%"  class="headngblue">Existing Quantity</td>
						<td width="50%" class="headngblue">Proposed Quantity</td>
						<td width="50%"  class="headngblue">Total Quantity after changes of Product Mix</td>
						<td width="20%" align="center" >Units</td>
                        
                       <%}
							   
							   else if(appFor=="expansion") {%>
							   
							   
							   
							    <td width="50%"  class="headngblue">Purpose</td>
						<td width="50%"  class="headngblue">Existing Quantity</td>
						<td width="50%"  class="headngblue">Expansion Quantity</td>
						<td width="50%"  class="headngblue">Total Quantity after Expansion</td>
						<td width="20%" align="center" >Units</td>
							   
							     <%}else {%>
							    <td width="50%"  class="headngblue">Purpose</td>
						<td width="50%"  class="headngblue">Quantity</td>
							  <td width="20%" align="center" >Units</td> 
							   
							      <%}%>
                      </tr>
 <g:each in="${sewageGenDetInstList}" status="i" var="sewageGenDetInst">
  <tr align="center" >
  
  
   <%if(appFor=="productMix"){
						      %> 
  
  
  
  					     <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.source}  ${sewageGenDetInst.otherSource}
                        </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.quantity} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.totalQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.unit} </span></td>
                        
                          <%}
							   
				 else if(appFor=="expansion") {%>
                        
                          <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.source}  ${sewageGenDetInst.otherSource}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.quantity} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.proposedQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.totalQuant} </span></td>
                <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.unit} </span></td>
                         <%}else {%>
                        
                        <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.source}  ${sewageGenDetInst.otherSource}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.quantity} </span></td>
                        
                         <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.unit} </span></td>
                        
                          <%}%>
                        
                        
         </tr>		
        
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					</table></td></tr>
 					
 					 <tr >
		<td   align="center" valign="middle"  class="headngblue">Total Water Details Quantity : ${totQyantity} KLD</td>
		</tr>
					  
  </table>
	  
  		</div>
  		 <%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
								%>
	<tr>
	<%if(page=="freshAdd"){%>
    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReportFresh/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
	<%}else if(page=="renewalAdd"){%>
	<td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReportRenewal/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
	<%}else if(page=="interAdd"){%>  
	<td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popConsentInspectionReportInter/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" class="actionbutton"></td>
	<%}%>
  </tr>
  <%}}%>
				</td>
				</tr>
				</table>
				</div>
				</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether(); 
  /*
  frmvalidator.addValidation("source","req","please enter Source Name.");
  frmvalidator.addValidation("quantity","req","please enter Quantity.");
  frmvalidator.addValidation("quantity","dec","Quantity should be Numeric/Decimal.");*/
  
 </script>   
 
			
</body>