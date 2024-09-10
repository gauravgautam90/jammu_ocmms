<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<g:javascript library="prototype" />
		
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		
		<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
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
		<% 
									if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									<% 
 									if((UserMaster)session.getAttribute("userMaster")){
 									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType = aa.accessLevel;
									if(userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
									controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
									<% 
									if( (!(IndUser)session.getAttribute("indUser") ) && 
		      						(! (UserMaster)session.getAttribute("userMaster") )  )   {
		      						%> 
		      						<g:include controller="userMaster" action="showIndexMenuHorizontal" />
		      			 			<% 
		      			 			} 
		      					%>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
					                        <%    }
						                  		} %>
								         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
								               	<g:include controller="userMaster" action="showIndexMenu"/>            
								         	<% } %>
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
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aa=(UserProfile)session.getAttribute("userprof");
             		  firstname=aa.employeeFirstName;
           		  lastName=aa.employeeLastName;
           		  access=um.accessLevel;

		}	

		else
			{
				if(  (IndUser)session.getAttribute("indUser")  )

					{
						IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 indname=ind.indName;

					}	
				else
					{
						decVar=false;
						
					}
			}




						
				
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              
              <tr>
                <td height="24" bgcolor="#4C8BC0">

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>


					<table width="100%" bgcolor="#4C8BC0">
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
		
		<% } %>
				</td>
              </tr>
           
             <%def scru = WasteManagementPendingDetails.find("from WasteManagementPendingDetails apd where apd.applicationId=?",[bioMedicalWasteInstance.toString()])
					String cont=request.getContextPath();			
						def certInst = RecordCertificateBMW.find("from RecordCertificateBMW afr where afr.application=?",[bioMedicalWasteInstance])
		if(certInst){

			viewCert = true
		}%>
		<g:def var="appForWhich1" value="BMW"/><g:def var="applicationId" value="${bioMedicalWasteInstance.id}"/>
		
             	<td height="24">
								<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
                                
if(userType.equals("admin")) { %>
 
              <a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>  
<%
if(viewCert){%>
<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
<%}%>
 <% if(scru){
		if(scru.scrutinyStatus=="In-Complete") {%>
				<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="viewScrutiny" params="[id:bioMedicalWasteInstance.id,applName:'BMW']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=200,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Scrutiny Incomplete Reason&nbsp;</span></a>
  <%}}}							
				
	if(userType.equals("employee") && scru.applicationStatus!='pending') { 	%>
          <a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>  
<%
if(viewCert){%>
<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
<%}%>
 <% if(scru){
		if(scru.scrutinyStatus=="In-Complete") {%>
				<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="viewScrutiny" params="[id:bioMedicalWasteInstance.id,applName:'BMW']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=200,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Scrutiny Incomplete Reason&nbsp;</span></a>
  <%}}}}%>     
           <%if((IndUser)session.getAttribute("indUser")) { %>
          
<%if(viewCert){%>
<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
<%}%>
 <% if(scru){
		if(scru.scrutinyStatus=="In-Complete") {%>
				<a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="viewScrutiny" params="[id:bioMedicalWasteInstance.id,applName:'BMW']" ></g:createLink>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=200,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Scrutiny Incomplete Reason&nbsp;</span></a>
  <%}}}%>   
        
        
           
              <tr>
                <td height="0" align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                    <span class="error"> 
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${bioMedicalWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${bioMedicalWasteInstance}" as="list" />
            </div>
            </g:hasErrors>
            </span>
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
    <g:form name="myform"  method="post" >
    <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
    <input type="hidden" name="bioMedId" value="${bioMedicalWasteInstance?.id}" />
    
   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Bio-Medical</span></a></li>
							<li><a href="#country3"><span>Fee</span></a></li>
						<li><a href="#country4"><span>Detail Files</span></a></li>
					</ol>
				  </td>
				   <g:if test="${bioMedicalWasteInstance?.completionStatus=='Completed'}">
				   
				   
				   
				   
				  <td  align="center" class="headngblue"><a href="<%=request.getContextPath()%>/bioMedicalWaste/viewBmwPdf?appliLoc=<%=bioMedicalWasteInstance?.id%>"><span class="headngblue">Print Form</span></a></td>
				</g:if>
				</tr>	
	    </table>
         
         <div class="content" id="country2" >
         
		  <table class="tblbdr">
                        <tbody>
                        	<input type="hidden" name="nameAddressInstitution" id="nameAddressInstitution" value="">
				<input type="hidden" name="nameOfApplicant" id="nameOfApplicant" value="">
								<input type="hidden" name="nameOfInstitution" id="nameOfInstitution" 
					 
	<%		System.out.println("gfdgfdgfdgfdgfdgdfg--------- in gsp"+bioMedicalWasteInstance)%>
					      							
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"> 
                                    <label for="activityAuthorizationSoughtFor">Activity For Which Authorization Is Sought:</label>
                                </td>
                               	<td width="100%" bgcolor="#E8F6F9"  class="headngblue">
							   		${fieldValue(bean:bioMedicalWasteInstance,field:'activityAuthorizationSoughtFor')}
							   	</td>

                           </tr> 
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authorizationType">Authorization Type:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                	${fieldValue(bean:bioMedicalWasteInstance,field:'authorizationType')}
                                </td>
                            </tr> 
                          
						   <g:if test="${bioMedicalWasteInstance?.authorizationType =='RenewalApplication'}">
						   <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">In case of renewal , please mention previous authorization number and Date </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
								    <table width="293" border="1">
								      <tr >
								        <td>Number : </td>
								        <td>Date(dd/mm/yyyy): </td>
								     <td>Expiry Date(dd/mm/yyyy): </td>
								      </tr>
								      <tr >
								     
								        <%
			                            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
				                        String strDate = sdfDestination.format(bioMedicalWasteInstance.previousAuthDate);
				
				                        %>
								        <td>${fieldValue(bean:bioMedicalWasteInstance, field:'previousAuthNo')}</td>
								        <td class="headngblue"><%=strDate%></td>
								        
								        
								      <%
			                            SimpleDateFormat sdfDestination2 = new SimpleDateFormat("dd-MM-yyyy");
				                        String strDate2 = sdfDestination2.format(bioMedicalWasteInstance.prevExpDate);
				
				                        %>
								     <td class="headngblue"><%=strDate2%></td>
								      
								      </tr>
								      
								    </table>      
								</td>
			  				</tr>
			  				   <tr>
				
				<td align="left" bgcolor="#A8DAF3" class="headngblue">Is HCE complying with all the conditions imposed at the time of earlier authorization?</div></td>
				 
				<td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:bioMedicalWasteInstance,field:'condImposedRenew')}   

				</td>														
			</tr>
			  				
                        </g:if>
                        

                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="addrPlaceDisposalOfWaste">Address of Place of Treatment/Disposal of Waste :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'addrPlaceDisposalOfWaste')}  
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="addrTreatmentFacility">Address of  Treatment Facility:</label>
                                </td>
                                <td valign="top"  bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'addrTreatmentFacility')}
                                </td>
                            </tr> 
                        	
														
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" align="left" class="headngblue">
                                    <label for="descrip">Brief Description of method of Treatment and Disposal :</label>
                                </td>
                                <td rows="1" cols="50" valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'descrip')}
                            
                       <%           	def applicationDocumentL=WasteManagementFile.findAll("from WasteManagementFile apd where apd.applicationId=? and apd.description= 'Method of Treatment and Disposal' order by apd.id desc",[bioMedicalWasteInstance.id],[max:1] )
  if (applicationDocumentL){%>
															
						<g:def var="fooVar1" value="${bioMedicalWasteInstance.id}"/>
						 <g:link action="viewNewFile"	params="[appliLoc:fooVar1,docType:'pdf']" >&nbsp;&nbsp;&nbsp;<i><u>Download</g:link>
						<%}%></td>	</tr>
									  <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="modeTrans">Mode of Transportation :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'modeTrans')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="modeTreat">Mode of Treatment :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:bioMedicalWasteInstance,field:'modeTreat')}
                                </td>
                            </tr> 					
                            <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Category of waste </td>
							    <td width="60%" bgcolor="#A8DAF3"  align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">
							 Quantity of waste & Unit (In KG/Month / Liter/Month)
							    </td>
							</tr>
							<g:if test="${bioWasteCategQuantList}"> 
							
								
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Human Anatomical Waste'}"> 								
							<tr>
							   <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 1 (Human Anatomical Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							    
							</tr>
							</g:if>
							</g:each>
                            
                            <g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Animal Waste'}"> 								
                             <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
							    
								  		Category 2 (Animal Waste) 
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Microbiology & Biotechnology Waste'}"> 								
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 3 (Microbiology & Biotechnology Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Waste sharps'}"> 								
							 <tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 4 (Waste sharps)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Discarded Medicines and Cytotoxic drugs'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 5 (Discarded Medicines and Cytotoxic drugs)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Soiled Waste'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  				Category 6 (Soiled Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>

							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste disposal generated'}"> 								
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  		Category 7 (Solid Waste disposal generated)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Liquid Waste'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 8 (Liquid Waste)
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Incineration Ash'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  			Category 9 (Incineration Ash) 
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Chemical Waste'}">
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> 
								  		Category 10 (Chemical Waste) 
							    </td>
							    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">${bioWasteCategQuantinst?.quantity}
							    ${bioWasteCategQuantinst?.unit}</td>
							</tr>
							</g:if>
							</g:each>
							
							
							</g:if>
                        
                          
                        
                           
		              	 <tr class="prop">
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Application Status</td>
		                	<td valign="top" bgcolor="#E8F6F9" class="headngblue">
							${fieldValue(bean:bioMedicalWasteInstance,field:'completionStatus')}  
		                	</td>
						</tr>
							
                        </tbody>
                    </table>
            
           
		   </div>
		   
		   <div class="content" id="country3">

												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
													style="border-collapse: collapse;">
													<tr>
														<td bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">

															<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Fee Details</td>
															</tr>
															<%
def cate = IndustryRegMaster.findById(indRegInstance.id.toLong())
def value = indRegInstance.indCapInvt.toInteger()
def pattii=indRegInstance.indNewCapInvt.toInteger()
def etc=indRegInstance.extraFacilities
%>
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">Category:</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue">${cate.category.name}</td>
															</tr>
																
																
										
																<%if(cate.category.name.equals("HOSPITAL")) {%>
																
																<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Extra Facilities If Any:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'extraFacilities')}-
																<%if(etc){%>
																
																${fieldValue(bean:indRegInstance,
																field:'anyOther')}
																
																<%}%>
																</td>
															</tr>
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">No of Beds:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
															</tr>
															
															
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per month::</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${pattii}</td>
															</tr>
																
															<%}%>
															
															
															
																
																<%if(cate.category.name.equals("LAB")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("VETERINARY")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients  :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("BLOOD BANK")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
															</tr>
															<%}%>
															
															<%if(cate.category.name.equals("DENTAL CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${value}</td>
															</tr>
															<%}%>

															<%if(cate.category.name.equals("CBWTF")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
															
															<%
															def consentFeeMasterInst = ConsentFeeMasterBMW.findByApplication(bioMedicalWasteInstance)
															%>
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Number of Years:</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'noOfYears')}</td>
															</tr>
															<tr>
															
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Total Fee Applied </td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'calculatedFee')}<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
															</tr>
										
										
										
																						<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Bank Details</td>
															</tr>


<%
									
								def feesOnline = FeeBankOtherDetailsBMW.find("from FeeBankOtherDetailsBMW fee where fee.application=?",[indApplicationDetailsInstance])
def feesBank = FeeBankDetailsBMW.find("from FeeBankDetailsBMW fee where fee.application=?",[indApplicationDetailsInstance])
									
									
									def feesBankOnline = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])


%>





															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeOtherDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>
<%if(feesBank) {%>
														
														
															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																	<td width="10%" class="headngblue" align="center">Bank Draft Details</td>
																		
																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
														
														<%if(feesBankOnline) {%>
															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																	<td width="10%" class="headngblue" align="center">Online Payment Details</td>
																		
																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popChallan/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View Challan </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
										




														


														</table>


														</td>
													</tr>
												</table>



												<br />
												</div>
		   
		   
		
					<div class="content" id="country4">
												<table width="100%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
													style="border-collapse: collapse;">
													<tr>
														<td bgcolor="#FFFFFF">
														<table width="100%" border="0" align="left"
															cellpadding="2" cellspacing="1" class="tblbdr">

															<tr bgcolor="#D1D1D1">
																<td colspan="2" align="center" valign="middle"
																	class="headngblue">Documents Details</td>
															</tr>
															
														<%
															System.out.println("bioMedicalWasteInstance.id--------------------------------->"+bioMedicalWasteInstance.id);
															def docList = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='BMW' and abc.typeOfFile='BMW Documents' and  abc.applicationId=?  and abc.description != 'Method of Treatment and Disposal'",[bioMedicalWasteInstance.id])
															System.out.println("docList.id--------------------------------->"+docList);
															
															//def doc1 = DocumentChecklistMaster.findAll("from DocumentChecklistMaster abc where abc.applicationFor='BioMediccalWaste' ")
			
															
															%>
															<g:def var="dList" value="${DocumentChecklistMaster.list()}" />
															<g:each var="doc" in="${docList}">
															<tr>
																<td width="60%" align="left" valign="middle"
																	bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
																<td width="40%" align="left" bgcolor="#E8F6F9"
																	class="headngblue"><g:def var="fooVar"
																	value="${bioMedicalWasteInstance.id}"/><g:def var="docN" value="${doc.description}"/> <g:link
																	action="viewFile1"
																	params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
															</tr>
															</g:each>
															
														</table>


														</td>
													</tr>
												</table>

												<br />
												</div>



		   <div class="content" id="country1" >
		   <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indName}
					</td>
			</tr> 
			
			
		  
		
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of Institution :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indAddress}
					</td>
			</tr> 
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indPhoneNo}
					</td>
			</tr> 
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indFaxNo}
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email id:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indEmail}
					</td>
			</tr> 
		    <tr>
					<td   align="center" valign="middle" bgcolor="#D1D1D1" colspan=2 class="headngblue">Applicant Details</td>
					
			</tr>   
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Applicant :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occName}
					</td>
			</tr> 
			
			
			
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of Applicant :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occAddress}
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Code:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occPhoneCode}
					</td>
			</tr>
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occPhoneNo}
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax code:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occFaxCode}
					</td>
			</tr>
			
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occFaxNo}
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email id:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.occEmail}
					</td>
			</tr>
		   
		   
		   <%
	def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
	def district = cat.district
	
	%>
	
	
			
			
			 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${cat.category.name}
					</td>
			</tr>
	
	
	<% if(cat.category.name.equals("VETERINARY")) {%>
	
	
	 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average number of Patients per year :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indCapInvt}
					</td>
			</tr>
			
			
			<%}%>
			
			<% if(cat.category.name.equals("HOSPITAL")) {%>
	
	
	 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">No of Beds :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.plotNo}
					</td>
			</tr>
			
			
			<%}%>
			
			
			<% if(cat.category.name.equals("CLINIC")) {%>
	
	
	 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average number of Patients per year :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indCapInvt}
					</td>
			</tr>
			
			
			<%}%>
			
			<% if(cat.category.name.equals("BLOOD BANK")) {%>
	
	
	 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average number of Samples per year :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indCapInvt}
					</td>
			</tr>
			
			
			<%}%>
			
			<% if(cat.category.name.equals("LAB")) {%>
	
	
	 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average number of Patients per year :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indCapInvt}
					</td>
			</tr>
			
			
			<%}%>
			
			
	<%if(cat.category.name.equals("DENTAL CLINIC")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>

															<%if(cat.category.name.equals("CBWTF")) {%>
																
																
																
															<tr>
																<td align="left" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indRegInstance,
																field:'indCapInvt')}</td>
															</tr>
															<%}%>
	
	
	
		 <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${district}
					</td>
			</tr>
	
	
		   </table>
		   
         
		   
		   </div>
		   
		       <div class="buttons">
            <g:if test="${bioMedicalWasteInstance?.completionStatus=='Inprogress'}">
                    <input type="hidden" name="id" value="${bioMedicalWasteInstance?.id}" />
                    <table width="75%" align="center">
	                     <tbody>
						        <tr class="prop" >
	                                <td valign="top" align="center">
                    					<span class="button"><g:actionSubmit class="edit" value="Edit" class="actionbutton"/></span>
                    					</td>
	                            </tr> 
	                    </tbody>
              		</table>
             </g:if> 
            </div>
		
 </g:form>
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


