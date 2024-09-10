<head>
<g:javascript library="prototype" />

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
<g:form name="waterSourceUses" method="post" action="" >
<table align="center" width="100%">

	<tr align="center">

		<td width="100%" align="center">

		<div>





		
		<div >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
		<td   align="center" valign="middle"  class="headngblue">Water Consumption Details</td>
		</tr> 
 					<tr><td><table width="100%">
 					
 					<tr bgcolor="#A8DAF3" >
                <td  width="50%" align="center" class="headngblue">Source Consumption</td>
                <td width="50%" align="center" class="headngblue">Quantity (m3/day))</td>
               
              	</tr>
 <g:each in="${waterGenarationList}" status="i" var="powerDetails">
  	<tr align="center" >
  					<td bgcolor="#E8F6F9"><span class="txt style6">${powerDetails.use.useType}  ${powerDetails.otherSource}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">${powerDetails.quantity}
                        </span></td>
                       
                       
                        
                              
    </tr>		
 </g:each>		
 				
 					
 					</table>
 				</td></tr>
 				
  </table>
  
		</div>
		</div>
		</td>
	</tr>

	

<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
	
	%>
<!--<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/eEWaste/spcbShowForm?appliId=<%=appDetId%>#country3', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>-->
<%}}%>

</table>
<!-- - -->

  		</g:form>
</body>