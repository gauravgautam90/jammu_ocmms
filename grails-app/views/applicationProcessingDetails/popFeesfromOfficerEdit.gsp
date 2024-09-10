
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Untitled Document</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

 

 

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<g:javascript library="prototype" />


 </head>
  <body>
<g:form name="waterSourceUses" method="post" action="deleteFeeBankDetails" >
<input type="hidden" value="<%=type%>" name="type"/> 
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="150" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Fee Bank Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					<td width="15%" colspan="2" align="center"  class="txt" > For the year</td>
 					
                        <td rowspan="2" width="15%" align="center"  class="txt" > DD No./Cheque No. </td>
							  <td rowspan="2" width="380px" align="center" class="txt">Date</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Bank Name</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Branch Name</td>
							  <td rowspan="2" width="140px" align="center" class="txt">Amount(In Rs.)</td>
                      </tr>
                      <tr bgcolor="#A8DAF3">
   					<td width="380px%" align="center"  class="txt" > From </td>
  							  <td width="380px" align="center" class="txt"> To </td>
  						</tr>
 <g:each in="${feeDetailsList}" status="i" var="feeDetailsListInst">
  <tr align="center" >
  <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.fromDate}
  </span></td>
  <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.toDate}
  </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.ddChequeNo}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.date}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.bankName}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${feeDetailsListInst.branch}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${feeDetailsListInst.amount}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=feeDetailsListInst.id%>"/>
                        </span></td>
                         
                              
        </tr>		
      </g:each>		
      
      		</table></td></tr>
						
					
					<tr align="center">
  <td><div style="width: 500px;  vertical-align: middle"><span
											class="error"> <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										</span></div></td></tr>  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

    <td height="1" colspan="2" bgcolor="" align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>
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

	<%}%> </td></tr>		


</table>
</g:form>
</body>
</html>