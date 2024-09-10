
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

  <g:form name="watertreat" method="post" action="editSewageGenerationDetMaster" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 <input type="hidden"  name="page" value="<%=page%>" />


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Average daily consumption of water Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%"> 
 		<tr >
		<td colspan="3"  align="center" valign="middle"  class="headngblue">Total water Details Quantity : ${totQyantity} KLD</td>
		</tr>
 					<tr bgcolor="#A8DAF3" align="center">
                        
                        <td width="50%" align="center" valign="middle"  class="headngblue">Source</td>
						<td width="40%" align="center" valign="middle"  class="headngblue">Quantity</td>
                        <td width="10%" class="headngblue" ><div  class="style3">Delete</div></td>
                      </tr>
 <g:each in="${sewageGenDetInstList}" status="i" var="sewageGenDetInst">
  <tr align="center" >
  					
  					    <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.source}  ${sewageGenDetInst.otherSource}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${sewageGenDetInst.quantity}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=sewageGenDetInst.id%>"/>
                        </span></td>
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

     <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>

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

</table>
</g:form>
</body>
</html>