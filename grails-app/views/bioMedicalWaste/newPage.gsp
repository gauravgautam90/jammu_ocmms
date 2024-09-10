<head>
<%@ page import="java.text.*"%>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
</head>
<body>
<%
System.out.println("in new jsppppppppppppppppp")%>
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                       
                        <tr>
                         <td height="25" colspan= "3" align="center" class="headngblue" >Hospital Name : <font face="Verdana" color="green">${indId}</font></td>
                        </tr>
                        <br>
                            <tr>
                              <td width="10"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="0" height="27" /></td>
                              <td width="94%" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Previous Applications Details </a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
						
							</tr>
      </table>

      
 <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
							
							<th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Application For</th>
							<th align="center" class="headngblue" >Status</th>
                   	    </tr>
                    </thead>
                    		
                    		<tbody>
                 
						
                
                    <g:each in="${app}" status="i" var="grantApplicationInstance">
                       <%if(grantApplicationInstance){%>
                       
                       <% 
                       
                       
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(grantApplicationInstance.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td height="25" align="center" class="txt4" ><u><g:link action="popPreviousApp" controller="bioMedicalWaste" id="${grantApplicationInstance.applicationId}"> <%=grantApplicationInstance.applicationId%> </g:link></u></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${strDate}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:grantApplicationInstance, field:'applicationFor')}</font></td>
                        <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:grantApplicationInstance, field:'applicationStatus')}</font></td>
                        </tr>
                        <%}%>
                    </g:each>
                     
                    </tbody>
      </table></td>
		  </tr></table>
		 
         
</body>		
		  
		  
		  
		  
		  
          