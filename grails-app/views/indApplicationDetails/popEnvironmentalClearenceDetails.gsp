
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
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Environmental Clearance Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" align="center">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">Proposal No.</div></td>
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">State</div></td>
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">Proposal Name</div></td>
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">Category</div></td>
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">User Agency Name</div></td>
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">Proposal Recieved on</div></td>
                      	<td width="10%" align="center" class="headngblue" ><div  class="style3">File No</div></td>
                      	<td width="10%" align="center" class="headngblue" ><div  class="style3">Date of grant</div></td>
                        
                      </tr>
 <g:each in="${evcList}" status="i" var="evcListInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.proposalNo}
                        </span></td> 
                        <td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.stateName}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.proposalName}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.category}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.userAgencyName}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.proposalRecievedon}
                        </span></td>
                         <td bgcolor="#E8F6F9"><span class="txt style6">${evcListInst.fileNo}
                        </span></td>
                         <td bgcolor="#E8F6F9" align="left	">
                        <span class="txt style6">${evcListInst.dateOfGrant}
                        </span>
                         
                          
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
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

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popPreviousApp/<%=appDetId%>#country6', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>
<%

}else{%>
 <tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" class="actionbutton" value="Back" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/<%=appDetId%>#country6', 'ApplicationHistory');"> </td>
		  
  </tr>
<%}}}%>


</table>

</body>
</html>