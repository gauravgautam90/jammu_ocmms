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
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                       
                        <tr>
                         <td height="25" colspan= "3" align="center" class="headngblue" >Industry Name : <font face="Verdana" color="green">${indId}</font></td>
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
							<th align="center" class="headngblue" >Application Type</th>
                   	        <th align="center" class="headngblue" >Certificate For</th>
                   	        <th align="center" class="headngblue" >Status</th>
                   	        <th align="center" class="headngblue" >Application Form</th>
                   	        <th align="center" class="headngblue" >Attachments</th>
                    	    
                        </tr>
                    </thead>
                    <tbody>
                 
						
                
                    <g:each in="${app}" status="i" var="grantApplicationInstance">
                       <%if(grantApplicationInstance){%>
                       
                       <% 
                       
                          def certInstOther = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate for Air'",[grantApplicationInstance.application])
                          if(certInstOther){
         			      viewCertOther = true
                          }
    		              def certInst = ApplicationFileRecord.find("from ApplicationFileRecord afr where afr.indApplication=? and afr.typeOfFile='Certificate for Refusal'",[grantApplicationInstance.application])
                          if(certInst){
  			              viewCert = true
                          }
			            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(grantApplicationInstance.application.actualApplicationDate );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td height="25" align="center" class="txt4"><font face="Verdana" color="red"> 
                        	<a target="_blank" href="<%=request.getContextPath()%>/applicationProcessingDetails/openApplicationDetails/<%=grantApplicationInstance.application.id%>" target="_blank">	
								${grantApplicationInstance.application.id}
                        	</a></font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${strDate}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:grantApplicationInstance, field:'application.applicationType')}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:grantApplicationInstance, field:'application.certificateFor')}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:grantApplicationInstance, field:'applicationStatus')}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><a href="<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/<%=grantApplicationInstance.application.id%>" target="_blank">
							View Application Form</a></font></td>
							<td height="25" align="center" class="txt4" ><font face="Verdana" color="green">
								%{--<%if(viewCertOther  ){
							     %>
							        <g:link style="text-decoration: none"  controller="applicationProcessingDetails" action="downLoadingCertificateAirGranted"  id="${grantApplicationInstance.application.id}" ><span class="innerlink">&nbsp;Certificate For Air&nbsp;|</span></g:link>
							        <g:link style="text-decoration: none"  controller="applicationProcessingDetails" action="downLoadingCertificateWaterGranted"  id="${grantApplicationInstance.application.id}" ><span class="innerlink">&nbsp;Certificate For Water&nbsp;</span></g:link>
							      <%}%>
							      <%if(viewCert  ){
						            %>
							           <g:link style="text-decoration: none" controller="applicationProcessingDetails" action="downLoadingCertificateRefusal"  id="${grantApplicationInstance.application.id}" ><span class="innerlink">&nbsp;Refusal Letter&nbsp;</span></g:link>
							        <%}%>--}%
                                <g:link style="text-decoration: none" controller="applicationProcessingDetails" action="openCerificate12"  id="${grantApplicationInstance.application.id}" ><span class="innerlink">&nbsp;Download Certificate&nbsp;</span></g:link>
						   </font></td>
                        </tr>
                        <%}%>
                    </g:each>
                     
                    </tbody>
      </table></td>
		  </tr></table>
		 
         
</body>		
		  
		  
		  
		  
		  
          