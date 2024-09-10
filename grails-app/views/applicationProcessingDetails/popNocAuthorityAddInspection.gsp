<%@ page import="java.util.Calendar;"%>

<head>
<g:javascript library="prototype" />
<g:javascript>

function select1()
{
	var selectmenu1=document.getElementById("hazardeousSubs")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp").style.display = 'none';
		}
	}
} 

function select2()
{
	var selectmenu1=document.getElementById("noisePollution")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp1").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp1").style.display = 'none';
		}
	}
} 

function select3()
{
	var selectmenu1=document.getElementById("status")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp2").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp2").style.display = 'none';
		}
	}
} 




function select4()
{
	var selectmenu1=document.getElementById("isHazarSubstanceProduced")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp4").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp4").style.display = 'none';
		}
	}
} 
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


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
<g:form name="saveHazardousChemical" method="post" action="saveNOCAuthorityInspection" >
<input type="hidden" value="<%=type%>" name="type"/>
<table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td width="80%" align="center" valign="middle"  class="headngblue">NOC Details</td>
					<input name="appId" type="hidden" value="<%=appDetId%>" />
					</tr>
 					<tr><td>
 					
 					<table width="100%" border="0" >
						 
						 
						 <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="20%" align="left" >Issuing Authority</td>
							  <td width="40%" bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <g:select class="txt4"  from="${NocAuthorityMaster.list()}" name="authorityDetails"></g:select>
							<span class="sidetxt">(select Authority)</span></span></td>
							  
						
							  
							  
							  <td width="20%" align="left" >Status</td>
							 
							 
							  <td  bgcolor="#E8F6F9" align="left" class="headngblue"><span class="style30 style4 style1">
							  <select name="status" id="status" onclick="javascript:select3()" class="txt4">
								<option value="No">No</option>
								<option value="Yes">Yes</option>
					   		  </select>
							<span class="sidetxt"></span></span></td>
							</tr>
							
						 <tr class="headngblue" bgcolor="#A8DAF3">
								 <td width="100%" colspan=4>
								 <div style="display:none; border:0;"  id="selectTemp2"  >
									<table width="90%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									<tr class="headngblue" bgcolor="#A8DAF3">				 
										  <td width="20%" align="left" >Number</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										   
										   
										   
										   <input name="number"  id ="number" type="text" maxlength="100" size="12"class="txt4" /></td>
									
									
									
									
									 <td width="20%" align="left" >Date</td>
										  <td bgcolor="#E8F6F9" align="left" class="headngblue">
										
						<calendar:datePicker name="date"  size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
			
									 
									 
									
									</td>
									</tr></table>
								</div></td>
						  </tr>
						  
						
                   <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b><br></span>
		<td width="100%" colspan="4" align="center"><span style="color:red">*Please enter details for all issuing authority</span><br><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
		
 				  
						</table></td></tr>
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
					<tr>
					<td align="left"><span class="txt" style="color: navy"><b>List of  NOC Authority Details added.</b></span><br>
					<table width="90%"  border="0" align="left" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td width="100%" ><table class="tblbdr">
 				
 					<tr bgcolor="#A8DAF3">
 					     <td width="20%" class="headngblue" ><div  class="style3">Issuing Authority</div></td>
                         <td width="20%" class="headngblue" ><div  class="style3">Status</div></td>
                         <td width="20%" class="headngblue" ><div  class="style3">Number</div></td>
                         <td width="20%" class="headngblue" ><div  class="style3">Date</div></td>
                     </tr>
                     
            
 <g:each in="${nocAuthorityDetailsInst}" status="i" var="nocAuthorityDetailsInst">
 
 
 
  <tr align="center" >
                   <td width="50%" bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.authorityDetails} </span></td>
  					<td width="50%" bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.status} </span></td>
  					<td width="50%" bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.number} </span></td>
  					<td width="50%" bgcolor="#E8F6F9"><span class="txt style6">${nocAuthorityDetailsInst.date} </span></td>
                    
                        
        </tr>		
      </g:each>		
 					
 					</table></td></tr>
  </table>
					</td>
					</tr>	
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
</script>  
</body>