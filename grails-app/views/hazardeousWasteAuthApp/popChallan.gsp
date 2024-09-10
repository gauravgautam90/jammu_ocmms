
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

  
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="150" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">On-line Payment Receipt</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td>
 					
 					
 					
 				<table width="70%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
				
				<%if(check==true){%>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">UTR/Reference No.</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${neftTransInstance.refNo}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Depositor Name</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${indApplicationDetailsInstance.industryRegMasterObj.occName}</span></td>
				</tr> 
				
							
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Application No.</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${indApplicationDetailsInstance}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Address of Industry</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${indApplicationDetailsInstance.industryRegMasterObj.indName}, ${indApplicationDetailsInstance.industryRegMasterObj.indAddress}, ${indApplicationDetailsInstance.industryRegMasterObj.tehsil.tehsilName}, ${indApplicationDetailsInstance.industryRegMasterObj.district.districtName}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Regional Office</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${group}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Applied For</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					HWM				</span></td>
				</tr>
				
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Payment Date</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">${neftTransInstance.dateOfTransaction}
				</span></td>

				</tr>
				
				
				<tr>
				<td width="50%" colspan="2" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Payment Details </td>
					
					
				</tr> 
				
				<g:each in="${feeDetailsList}" status="i" var="feeDetailsList">
                      
                        
                        
                        <tr >
                            <td bgcolor="#A8DAF3" height="25" align="left" class="headngblue" >${feeDetailsList.feeFor} (Rs.)</td>
                             <td align="left" bgcolor="#E8F6F9" height="25" class="txt4" >${feeDetailsList.amount}</td>
                        	 
                        
                        </tr>
                    </g:each>
				
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Amount Paid (Rs.)</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${neftTransInstance.amount}</span></td>
					
				</tr> 
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Transaction Status</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">Successfully Completed</span></td>
				</tr>
				
				
				<%}else{%>
				
				 <g:each in="${feesBankOnlineInstance}" status="f" var="feesBankOnlineInstance">
					
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Receipt No.</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${feesBankOnlineInstance.id}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Depositor Name</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${indApplicationDetailsInstance.industryRegMasterObj.occName}</span></td>
				</tr> 
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Bank Name.</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${feesBankOnlineInstance.bankName}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Bank Id.</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${feesBankOnlineInstance.bankId}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Application No.</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${indApplicationDetailsInstance}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Address of Industry</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${indApplicationDetailsInstance.industryRegMasterObj.indName}, ${indApplicationDetailsInstance.industryRegMasterObj.indAddress}, ${indApplicationDetailsInstance.industryRegMasterObj.tehsil.tehsilName}, ${indApplicationDetailsInstance.industryRegMasterObj.district.districtName}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Regional Office</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${group}</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Applied For</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					HWM
					</span></td>
				</tr>
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Payment Date</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
				${feesBankOnlineInstance.dateCreated}</span></td>

				</tr>
				
				
				
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Amount Paid (Rs.)</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${feesBankOnlineInstance.amount}</span></td>
					
				</tr> 
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Transaction Status</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					<%
					def status = feesBankOnlineInstance.transactionStatus
					if(status=="S")
					{
					println("Successfully Completed")
					}
					
					%></span></td>
				</tr>
				
				</g:each>
				<tr>
				<td width="50%" colspan="2" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Payment Details </td>
					
					
				</tr> 
				<%
				float total = 0;
				%>
				<g:each in="${feesBankOnlineInstance}" status="i" var="feeDetailsList">
                      
                      
                        
                        <tr >
                            <td bgcolor="#A8DAF3" height="25" align="left" class="headngblue" >HWM (Rs.)</td>
                             <td align="left" bgcolor="#E8F6F9" height="25" class="txt4" >${feeDetailsList.amount}</td>
                        	 <%
                        	 total = total + (feeDetailsList.amount).toFloat()
                        	 %>
                        
                        </tr>
                    </g:each>
                    <tr >
                    <td bgcolor="#A8DAF3" height="25" align="left" class="headngblue" >Total (Rs.)</td>
                     <td align="left" bgcolor="#E8F6F9" height="25" class="txt4" ><%=total%></td>
                	 
                
                </tr>
				
				
				<%}%>    
				    <tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">&nbsp;</td>
					
			  	</tr>
		
									
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	
  		
  		
 <%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
							if(session.check==true){
								%>
<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/spcbShowForm?docName=HWM&appliId=<%=appDetId%>#country3', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
	  
  </tr>
<%

}else{%>
 <tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/spcbShowForm?docName=HWM&appliId=<%=appDetId%>#country3', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>
<%}}}%>
  		
  		



</table>

</body>
</html>