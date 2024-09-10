<head>
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
<g:form >
<table align="center">

	<tr align="center">

		<td width="100%" align="center">

		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0" id="countrytabs">
			<tr>
				<td width="11"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
					width="11" height="27" /></td>
				<td  align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country6">D.G. Set Parameter Details </a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
			</tr>
		</table>
		<div >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3" >
                  <td  width="50%" align="center" class="headngblue">Parameters</td>
	                <td width="25%" align="center" class="headngblue">No Load Condition</td>
	                <td width="25%" align="center" class="headngblue">Full Load Condition</td>
	              </tr>
 <g:each in="${dgList}" status="i" var="dgInst">
  	<tr align="center" >
  					<td bgcolor="#E8F6F9" ><span class="txt style6">${dgInst.parameters}
                        </span></td>
                        <td bgcolor="#E8F6F9" ><span class="txt style6">${dgInst.noLoad}
                        </span></td>
                        <td bgcolor="#E8F6F9"  ><span class="txt style6">${dgInst.fullLoad}
                        </span></td>
                        
                              
    </tr>		
 </g:each>		
 				
 					
 					</table>
 				</td></tr>
 				
  </table>
  
		</div>
		
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
<!-- - -->

  		</g:form>
</body>