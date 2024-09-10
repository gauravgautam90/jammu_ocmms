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
<g:form name="AddWaterBudget" method="post" action="saveWaterBudget" >
<input type="hidden" value="<%=type%>" name="type"/>
<table>
<tr>
<td>

		<table width="100%"  border="1" bordercolor="black" align="center" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Water Pollution</td>
				</tr> 
				<tr bgcolor="#A8DAF3">
				<td></td>
				
				<td>Water Consumption(in KLD)</td>
				
				<td></td>
				<td>Effluent Generation(in KLD)</td>
				<td></td>
				</tr>
				<tr bgcolor="#A8DAF3" >
                <td  width="35%" align="center" class="headngblue">Type</td>
                
                <td width="15%" align="center" class="headngblue">Present</td>
                <td width="15%" align="center" class="headngblue">Previous</td>
                <td width="15%" align="center" class="headngblue">Present</td>
                <td width="15%" align="center" class="headngblue">Previous</td>
                
                </tr>
			  
 			
			  
			  
		  
		  	<tr bgcolor="#A8DAF3">
		  	<td  align="center">Domestic
		  	<input type="hidden" name="appid" value="${appDetId}">
		  </td>
          
                <td  align="center" class="headngblue">
                  <input type="text"  name="wcpresent" size="4" class="txt4" />
                  <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="wcprevious" size="4" class="txt4" />
                <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="egpresent" size="4" class="txt4" />
                <br>
              </td>
              <td  align="center" class="headngblue">
              <input type="text"  name="egprevious" size="4" class="txt4" />
              <br>
            </td> </tr>
             
            <tr bgcolor="#A8DAF3">
            <td  align="center">Industrial process generating biodegradable waste water
		  </td>
          
                <td  align="center" class="headngblue">
                  <input type="text"  name="wcpresent2" size="4" class="txt4" />
                  <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="wcprevious2" size="4" class="txt4" />
                <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="egpresent2" size="4" class="txt4" />
                <br>
              </td>
              <td  align="center" class="headngblue">
              <input type="text"  name="egprevious2" size="4" class="txt4" />
              <br>
            </td>
              </tr>
              
              <tr bgcolor="#A8DAF3">
              <td  align="center">Industrial process generating non-biodegradable waste water
  		  </td>
            
                  <td  align="center" class="headngblue">
                    <input type="text"  name="wcpresent3" size="4" class="txt4" />
                    <br>
                  </td>
                  <td  align="center" class="headngblue">
                  <input type="text"  name="wcprevious3" size="4" class="txt4" />
                  <br>
                  </td>
                  <td  align="center" class="headngblue">
                  <input type="text"  name="egpresent3" size="4" class="txt4" />
                  <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="egprevious3" size="4" class="txt4" />
                <br>
              </td>
                </tr>
                
                <tr bgcolor="#A8DAF3">
                <td  align="center">Industrial cooling boiler feed,D.M.Plant,etc.
    		  </td>
              
                    <td  align="center" class="headngblue">
                      <input type="text"  name="wcpresent4" size="4" class="txt4" />
                      <br>
                    </td>
                    <td  align="center" class="headngblue">
                    <input type="text"  name="wcprevious4" size="4" class="txt4" />
                    <br>
                    </td>
                    <td  align="center" class="headngblue">
                    <input type="text"  name="egpresent4" size="4" class="txt4" />
                    <br>
                  </td>
                  <td  align="center" class="headngblue">
                  <input type="text"  name="egprevious4" size="4" class="txt4" />
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
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Water Budget Details added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3">
				<td></td>
				<td></td>
				<td>Water Consumption(in KLD)</td>
				
				<td></td>
				<td>Effluent Generation(in KLD)</td>
				<td></td>
				</tr>
				
				<tr bgcolor="#A8DAF3" >
				<td  width="35%" align="center" class="headngblue" >S.No.</td>
                <td  width="35%" align="center" class="headngblue">Type</td>
                
                <td width="15%" align="center" class="headngblue">Present</td>
                <td width="15%" align="center" class="headngblue">Previous</td>
                <td width="15%" align="center" class="headngblue">Present</td>
                <td width="15%" align="center" class="headngblue">Previous</td>
                
                </tr>
			  
 <g:each in="${waterBudgetList}" status="i" var="waterBudgetList">
  	<tr align="center" >
  	<td rowspan="4"><span class="txt style6">
	<%=i+1%></span></td>
  	
  	<td ><span class="txt style6">
		${waterBudgetList.waterbudgettype}</span></td>
                        <td ><span class="txt style6">${waterBudgetList.wcpresent}
                        </span></td>
                        <td ><span class="txt style6">${waterBudgetList.wcprevious}
                        </span></td>
                        <td ><span class="txt style6">${waterBudgetList.egpresent}
                        </span></td>
                        <td ><span class="txt style6">${waterBudgetList.egprevious}
                        </span></td> </tr>
                    <tr align="center">   <td ><span class="txt style6">
  					${waterBudgetList.waterbudgettype2}</span></td>
                            <td ><span class="txt style6">${waterBudgetList.wcpresent2}
                            </span></td>
                            <td ><span class="txt style6">${waterBudgetList.wcprevious2}
                            </span></td>
                            <td ><span class="txt style6">${waterBudgetList.egpresent2}
                            </span></td>
                            <td ><span class="txt style6">${waterBudgetList.egprevious2}
                            </span></td> </tr>
                          <tr align="center">  <td ><span class="txt style6">
        					${waterBudgetList.waterbudgettype3}</span></td>
                                <td ><span class="txt style6">${waterBudgetList.wcpresent3}
                                </span></td>
                                <td ><span class="txt style6">${waterBudgetList.wcprevious3}
                                </span></td>
                                <td ><span class="txt style6">${waterBudgetList.egpresent3}
                                </span></td>
                                <td ><span class="txt style6">${waterBudgetList.egprevious3}
                                </span></td> </tr>
                             <tr align="center">   <td ><span class="txt style6">
              					${waterBudgetList.waterbudgettype4}</span></td>
                                    <td ><span class="txt style6">${waterBudgetList.wcpresent4}
                                    </span></td>
                                    <td ><span class="txt style6">${waterBudgetList.wcprevious4}
                                    </span></td>
                                    <td ><span class="txt style6">${waterBudgetList.egpresent4}
                                    </span></td>
                                    <td ><span class="txt style6">${waterBudgetList.egprevious4}
                                    </span></td>
                        
                              
    </tr>		
 </g:each>		
 					
 				
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>

<tr>
<td align="center">
<% if(type=="REGULAR"){
		System.out.println("type...."+type)
		%>
	
	<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

		()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
			
	<%}else{%>
   
		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

	<%}%></td></tr>	
</td></tr>
</table>
 </g:form>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("AddWaterBudget");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
// frmvalidator.addValidation("product","req","Please enter Product Name");
// frmvalidator.addValidation("product","maxlength=50","Product Name should be upto 50 characters");
//frmvalidator.addValidation("quantity","req","Please enter Product Quantity");
  frmvalidator.addValidation("ph","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("tss","decimal","Quantity should be numeric or decimal");
  frmvalidator.addValidation("bdo","decimal","Quantity should be numeric or decimal");
  
  
  </script> 
		    <!-- ------ -->
		 
		  
		  
		  
		
		  
		  <!-- ------ -->
		  	 
</body>