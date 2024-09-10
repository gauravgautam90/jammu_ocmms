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
<g:form name="AddSewageDetails" method="post" action="saveSewageDetails" >
<input type="hidden" value="<%=type%>" name="type"/>
<table>
<tr>
<td>

		<table width="100%"  border="1" bordercolor="black" align="center" cellpadding="2" cellspacing="0" class="">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="5"  align="center" valign="middle"  class="headngblue">Sewage</td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="35%" align="center" class="headngblue">Date of Sampling and Sample collected</td>
                <td width="15%" align="center" class="headngblue">pH</td>
                <td width="15%" align="center" class="headngblue">TSS in(mg/l)</td>
                <td width="15%" align="center" class="headngblue">BDO in(3 days,27C)</td>
                
                </tr>
			  
 			
			  
			  
		  
		  	<tr>
		  	<td  align="center" class="headngblue">
		  	<input type="hidden" name="appid" value="${appDetId}">
		  	<calendar:datePicker name="dossc" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
            <br>
          </td>
          
                <td  align="center" class="headngblue">
                  <input type="text"  name="ph" size="4" class="txt4" />
                  <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="tss" size="4" class="txt4" />
                <br>
                </td>
                <td  align="center" class="headngblue">
                <input type="text"  name="bdo" size="4" class="txt4" />
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
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Sewage Details added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				
                <td  width="25%" align="center" class="headngblue">Date of Sampling and Sample collected by</td>
                <td width="25%" align="center" class="headngblue">pH</td>
                <td width="25%" align="center" class="headngblue">TSS in(mg/l)</td>
                <td width="25%" align="center" class="headngblue">BDO in(3 days,27C)</td>
               
              	</tr>
 <g:each in="${sewageDetailsList}" status="i" var="sewageDetailsList">
  	<tr align="center" >
  	<%def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
  	def x=sewageDetailsList.dossc
  	def date2=sdfh.format(x)
  	
  	%>
  	
  	
  					<td ><span class="txt style6">${date2}
                        </span></td>
                        <td ><span class="txt style6">${sewageDetailsList.ph}
                        </span></td>
                        <td ><span class="txt style6">${sewageDetailsList.tss}
                        </span></td>
                        <td ><span class="txt style6">${sewageDetailsList.bdo}
                        </span></td>
                        
                              
    </tr>		
 </g:each>		
 					
 				
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
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
</td></tr>
</table>
 </g:form>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("AddSewageDetails");
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