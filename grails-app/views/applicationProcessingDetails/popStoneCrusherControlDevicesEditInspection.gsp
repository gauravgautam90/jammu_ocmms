
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

  <g:form name="editStoneCrusherControl" method="post" action="editStoneCrusherControlInspection" >
  <input type="hidden" value="<%=type%>" name="type"/>
 <table align="center">

<tr align="center">

<td width="90%" align="center">

    <div >
 

 


<table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Stone Crusher/Hot mix plants Pollution Control Devices Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr"> 
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="20%" align="center" class="headngblue" ><div  class="style3">Pollution Control Devices</div></td>
                        <td width="20%" align="center"class="headngblue" ><div  class="style3">Name</div></td>
                      	<td width="20%" align="center"class="headngblue" ><div  class="style3">Status</div></td>
                        <td width="20%" align="center" class="headngblue" ><div  class="style3">Delete</div></td>
                      </tr>
 <g:each in="${stoneSittingCriteriaList}" status="i" var="stoneSittingCriteriaInst">
  <tr align="center" >
  					
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stoneSittingCriteriaInst.device}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stoneSittingCriteriaInst.name}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${stoneSittingCriteriaInst.status}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=stoneSittingCriteriaInst.id%>"/>
                        </span></td>
                              
        </tr>		
      </g:each>		
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

     <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

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
  var frmvalidator  = new Validator("waterSolidWasteGen");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("Description","req","please enter Description");
  frmvalidator.addValidation("Quantity","numeric","Quantity should be numeric");
  frmvalidator.addValidation("Method of Collection","req","please enter Method of Collection");
   frmvalidator.addValidation("Mode of Disposal","req","please enter Mode of Disposal");
 
  
 </script>   
 

</body>
</html>