
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

  <g:form name="waterSource" method="post" action="deleteWaterSourceMaster" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="220" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Water Source Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<g:each in="${sourceList}" status="i" var="sourceInstance">
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="150px" class="headngblue" ><div  class="style3">Source Type</div></td>
                        <td ><span class="txt style6">${sourceInstance.source}
                        </span></td>
                        <td width="150px" class="headngblue" ><div  class="style3">Source Name</div></td>
                        <td ><span class="txt style6">${sourceInstance.sourceName}
                        </span></td>
                        <td width="150px"  valign="middle" class="headngblue"><div  class="style3">Quantity</div></td>
                        <td ><div ><span class="txt style6">${sourceInstance.quantity}</span></div></td>
                      	 <td width="150px" class="headngblue" ><div  class="style3">Delete ?</div></td>
                        <td ><span class="txt style6"><input type="checkbox" name="source" value="<%=sourceInstance.id%>" />
                        </span></td>
                      </tr>
 
  <tr align="center" >
  					<td colspan="3" class="headngblue" ><div class="style3">Use</div></td>
                    <td colspan="3"  valign="middle" class="headngblue"><div  class="style3">Quantity Used</div></td>				
                              
        </tr>		
        			<%ArrayList usesList = usesBList.get(i) ;
        			ArrayList modeUseList = modeUseBlist.get(i);
        			%>
        			<%for(int j=0;j<usesList.size();j++){ %>
        			<tr bgcolor="#F4F7FB">
                      <td colspan="3" align="center"><span class="txt style6"><%=(usesList.get(j)).use %>
                        </span></td>
                       <td colspan="3" align="center"><div ><span class="txt style6"><%=(usesList.get(j)).quantity %></span></div></td>
                      </tr>
                      
        <%} %>
        
        <tr align="center" >
  					<td colspan="2" class="headngblue" ><div  class="style3">Mode of Use</div></td>
                    <td colspan="2"  valign="middle" class="headngblue"><div  class="style3">Quantity </div></td>				
                    <td colspan="2" class="headngblue" ><div  class="style3">Waste Water Generated</div></td>          
        </tr>
        <%for(int j=0;j<modeUseList.size();j++){ %>
        			<tr bgcolor="#F4F7FB">
                      <td colspan="2" align="center"><span class="txt style6"><%=(modeUseList.get(j)).modeUse %>
                        </span></td>
                       <td colspan="2" align="center"><div ><span class="txt style6"><%=(modeUseList.get(j)).quantity %></span></div></td>
                       <td colspan="2" align="center"><div ><span class="txt style6"><%=(modeUseList.get(j)).wasteWaterGenerated %></span></div></td>
                      </tr>
                      
        <%}%>
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					</table></td></tr>
					</g:each>
					  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

	<td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
  </tr>



</table>
</g:form>
</body>
</html>