<%@ page import="java.text.SimpleDateFormat"%>
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
<g:form name="sewageDetailsEdit" method="post" action="deleteSewageDetails" >
<input type="hidden" value="<%=type%>" name="type"/>
<table align="center">

	<tr align="center">

		<td width="100%" align="center">

		<div>





		<table width="95%" border="0" align="center" cellpadding="0"
			cellspacing="0" id="countrytabs">
			<tr>
				<td width="11"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"
					width="11" height="27" /></td>
				<td width="110" align="center"
					background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}"
					class="top-lnks"><a href="#" rel="country1">Sewage Details</a></td>
				<td width="11" valign="bottom"><img
					src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"
					width="11" height="27" /></td>
				<td width="432">&nbsp;</td>
			</tr>
		</table>
		<div >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3" >
 					<td  width="25%" align="center" class="headngblue">Date of Sampling and Sample collected</td>
 	                <td width="25%" align="center" class="headngblue">pH</td>
 	                <td width="25%" align="center" class="headngblue">TSS in(mg/l)</td>
 	                <td width="25%" align="center" class="headngblue">B.D.O in(mg/l)</td>
 	               <td align="center" class="headngblue">Delete</td>
				
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
                                                <td ><span class="txt style6"><input type="checkbox" name="delete" value="<%=sewageDetailsList.id%>" />
                                    </span></td>   
                                          
                </tr>		
             </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td align="center" colspan="6"><input type="hidden" name="appid" value="${appDetId}"><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
 					</tr>
 					</table>
 				</td></tr>
 				
 				

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
 				
  </table>
  <div align="left" class="txt" style="color: navy">
  </br></br>
  &nbsp;<b>* Instructions:</b>
  &nbsp;<ul> 
  <li>Please select the checkbox to delete the Sewage details and click "Delete" button</li>
  <li>Select multiple check box and click "Delete" button to delete multiple records</li>
  <li>To edit the Sewage details, delete the Sewage details and then add new one</li>
  </ul>
  

</div>
		</div>
		</div>
		</td>
	</tr>

	<tr>



	</tr>



</table>
<!-- - -->

  		</g:form>
</body>