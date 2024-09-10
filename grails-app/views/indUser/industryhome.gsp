<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>


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

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
a:link {
	text-decoration: none;
	color: #1E6BBD;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>

</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- code for menuIndustryHorizontal-->
		<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<g:include controller="userMaster" action="showSpcbIndustryMenu"/>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>
<%
  IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            	String indname=ind.indName;
             
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					
					<table width="100%" bgcolor="#4C8BC0">
						 <tr >
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle">&nbsp;</div></td>
                      
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="33" align="left" valign="top">&nbsp;</td>
                            <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
    
    <td align="center" valign="top">
        <div class="message">
        <span style="color:green">${flash.message}
        </span>
        </div>
        </td>
        </tr>
        </table>
   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
         
        <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
        
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>In-progress Application</span></a></li>
						<li><a href="#country2"><span>Completed Application</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
          <div class="content" id="country1" >
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        <!--<g:sortableColumn property="id" title="Application No" />
                   	        <g:sortableColumn property="applicationDate" title="Application Date" />
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                   	        <g:sortableColumn property="applicationName" title="Application Name" />-->
                        
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Category</th>
							<th align="center" class="headngblue" >Industry Type</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Consent For</th>
                   	     <% if(evcList){ %>
                	        <th align="center" class="headngblue" >Environmental Clearance Details</th>
                	    	<% } %>
                   	        
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(pendingIndApplicationDetailsInstanceList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${pendingIndApplicationDetailsInstanceList}" status="i" var="indApplicationDetailsInstance">
                        <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

                        String strDate = sdfDestination.format(indApplicationDetailsInstance.actualApplicationDate);
                     
                       String consentFor = indApplicationDetailsInstance.certificateFor
                     
                        if(consentFor.equals("new")){
                        consentFor="Fresh"
                        }
                        if(consentFor.equals("Modern")){
                        consentFor = "Modernization "
                        }
                        if(consentFor.equals("expan")){
                        consentFor = "Expansion"
                        }
                        if(consentFor.equals("reNew")){
                         consentFor = "Renew"
                        }
                       String applicationFor = indApplicationDetailsInstance.applicationFor
                     
                        if(applicationFor.equals("brickkilns")){
                        applicationFor="Brick Kilns"
                        }
                        if(applicationFor.equals("both")){
                        applicationFor = "Industry "
                        }
                        if(applicationFor.equals("stonecrusher")){
                        applicationFor = "Stone Crusher"
                        }
                        if(applicationFor.equals("hotmixplants")){
                            applicationFor = "Hot mix plants"
                            }
                        if(applicationFor.equals("stonecrusher and hotmixplants")){
                            applicationFor = "Stone Crusher and Hot mix plants"
                            }
                        if(applicationFor.equals("hotel")){
                         applicationFor = "Hotel"
                        }
                         if(applicationFor.equals("dgset")){
                         applicationFor = "DGSet"
                        }
                        
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                           
                            <%if(indApplicationDetailsInstance.certificateFor=="autoReNew"){%>
                            <td height="25" align="center" class="txt4" > <u><g:link action="viewAutoRenewConsent" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td>
                            <%}else{%>
                            <td align="center" height="25" class="txt4"  ><u><g:link action="doGetShow" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td>
                            <%}%>
                            </td><td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate%></font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="red">${indApplicationDetailsInstance.indUser.category.name}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red"><%=applicationFor%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="red">${indApplicationDetailsInstance.applicationType} ( <%=consentFor%> )</font></td>
                            <% if(evcList){ %>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEnvironmentalClearenceDetails/<%=indApplicationDetailsInstance.indUser.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
				 			</font></td>
                            
                            <% } %>
                            </tr>
                    </g:each>
                    </tbody>
      </table></td>
                      </tr>	  
	  </table>
	  <table width="95%">
		  <tr><td>&nbsp;</td></tr>
		  
		  <tr><td width="8px"  bgcolor="red"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application available for edit.</font></td></tr>
        
          <tr><td width="8px"  bgcolor="green"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application submitted to JKSPCB office.</font></td></tr>
          
           <tr><td> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Clarification raised on this application.</font></td></tr>
         
          </table>
            <br />
            <br />
          </div>
          <div class="content" id="country2">
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF">
			
             <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        <!--<g:sortableColumn property="id" title="Application No" />                        
                   	        <g:sortableColumn property="applicationDate" title="Application Date" />                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />                       
                   	        <g:sortableColumn property="applicationName" title="Application Name" />                     
                   	        <th>Application Type</th>
                   	        <th>Category</th>-->
							
							<th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Type</th>
							<th align="center" class="headngblue" >Category</th>
							<th align="center" class="headngblue" >Application Name</th>
							 <th align="center" class="headngblue" >Consent For</th>
                   	    	<th align="center" class="headngblue" >Status</th>
                   	    	  <th align="center" class="headngblue" >Keeping With</th>
                   	    	 <% if(evcList){ %>
                    	        <th align="center" class="headngblue" >Environmental Clearance Details</th>
                    	    	<% } %> 
                        </tr>
                    </thead>
                    <tbody>
 

                    <%if(completedIndApplicationDetailsInstanceList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${completedIndApplicationDetailsInstanceList}" status="i" var="indApplicationDetailsInstance">
                        <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(indApplicationDetailsInstance.applicationDate );
                        
                        String consentFor = indApplicationDetailsInstance.certificateFor
                     
                        if(consentFor.equals("new")){
                        consentFor="Fresh"
                        }
                        if(consentFor.equals("Modern")){
                        consentFor = "Modernization "
                        }
                        if(consentFor.equals("expan")){
                        consentFor = "Expansion"
                        }
                        if(consentFor.equals("reNew")){
                         consentFor = "Renew"
                        }
                        
                        String applicationFor = indApplicationDetailsInstance.applicationFor
                     
                        if(applicationFor.equals("brickkilns")){
                        applicationFor="Brick Kilns"
                        }
                        if(applicationFor.equals("both")){
                        applicationFor = "Industry "
                        }
                        if(applicationFor.equals("stonecrusher")){
                        applicationFor = "Stone Crusher"
                        }
                        if(applicationFor.equals("hotmixplants")){
                            applicationFor = "Hot mix plants"
                            }
                        if(applicationFor.equals("stonecrusher and hotmixplants")){
                            applicationFor = "Stone Crusher and Hot mix plants"
                            }
                        if(applicationFor.equals("hotel")){
                         applicationFor = "Hotel"
                        }
                        if(applicationFor.equals("dgset")){
                         applicationFor = "DGSet"
                        }
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <%if(indApplicationDetailsInstance.certificateFor=="autoReNew"){%>
                        <td height="25" align="center" class="txt4" > <u><g:link action="viewAutoRenewConsentCom" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td>
                        <%}else{%>
                        <td align="center" height="25" class="txt4"  ><u><g:link action="doGetShow" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td>
                        <%}%>
                       <!--     <td height="25" align="center" class="txt4" ><u><g:link action="doGetShow" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td> -->
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><%=strDate%></font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><%=applicationFor%></font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${indApplicationDetailsInstance.indUser.category.name}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${indApplicationDetailsInstance.applicationType} ( <%=consentFor%> )</font></td>
                        	<td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><%=compStatusList.get(i)%></font>
                        	<br>
                        	<!--code by Vikas Rathore -->
                        	<%
                        	
                        	if(compStatusList.get(i)=="Returned")
                        	 {%><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/viewReturnReason/${indApplicationDetailsInstance.id}', 'returned','WIDTH=500,HEIGHT=200,scrollbars=1');"><font face="Verdana" color="blue">View Return Reason</font></a><%}%>
                        	  <%if(compStatusList.get(i)=="Scrutiny In-Complete")
                        	  {
                        		  System.out.println("incomplete.id:")  
                        		  %>
                        	  <br>
                        	  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/viewScrutiny/${indApplicationDetailsInstance.id}', 'returned','WIDTH=500,HEIGHT=200,scrollbars=1');">
                        	  <font face="Verdana" color="blue">
                        	  View Reason
                        	  </font>
                        	  </a><%}%>
                        	 </td>
                        	 <!--code ended by Vikas Rathore -->
                        	
                        	
                        	<td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><%=pendingWith.get(i)%></font></td>
                        	
                        	<%if(indApplicationDetailsInstance.clarification){ 
                        	def instance=ApplicationPendingDetails.find("from ApplicationPendingDetails where application=? and applicationStatus='approved'",[indApplicationDetailsInstance])
                        	System.out.println("instance.."+instance)
                        	if(instance){
                        		%>
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/submitClarification/${indApplicationDetailsInstance.id}', 'clarification', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td> 
                        	<%}else{ %>
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/submitClarification/${indApplicationDetailsInstance.id}', 'clarification', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td> 
                        <% } }%>
                        	 <% if(evcList){ %>
                             <td align="center" height="25" class="txt4" ><font face="Verdana" color="red"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEnvironmentalClearenceDetails/<%=indApplicationDetailsInstance.indUser.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>
      			 			</font></td>
                             
                             <% } %>
                             
                             <%if(compStatusList.get(i)=="Scrutiny Complete")
                          	  {%>
                         	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/addPaymentNew/${indApplicationDetailsInstance.id}', 'payment', 'WIDTH=800,HEIGHT=650,scrollbars=1');"><font face="Verdana" color="blue">Deposit Consent Fee</font></a></td> 
                          	 <% }%>
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
		  </tr></table>
		  
            <br />
            <br />
          </div>
          </div>
		  
		  

      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>
</body>
</html>


