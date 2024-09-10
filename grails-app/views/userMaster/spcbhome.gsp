<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


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

.yellow-bg {
	  background-color: yellow;
	}
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
		<!-- code for menuSpcbUserHorizontal-->
		<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<g:include controller="userMaster" action="showSpcbUserMenu"/>
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
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               
                
            //  Code Added By Deepak  Start       
                System.out.println("umumumumumum ==========="+um)
                
                def employeeN1 = RoleProfileAssignment.findAll("from RoleProfileAssignment as abc where abc.primaryEmployee = ? ",[aa])
               System.out.println("employeeN1 ==========="+employeeN1)
               int Flag =0; 
                for(i=0; i<employeeN1.size(); i++){
                	 System.out.println("employeeN1.role.roleName ==========="+employeeN1.role.roleName)
                if(employeeN1[i].role.roleName=="MS"){
                	Flag =1;
                }
                }
                System.out.println("Flag ==========="+Flag)
                %>
    <!---   Code Added By Deepak  end -->
    

 
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> 
						
<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
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
                            <td width="706" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
     <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  align="left" class= "headngblue" >
				  	<% String cont=request.getContextPath(); %>
					<input type="radio" id="recent" name="recent"   value="" onclick=window.location="<%=cont%>/userMaster/recentAppl1" > Recent Applications 
				&nbsp;&nbsp;	<input type="radio" id="app" name="app"  value="" checked > All Applications
				  </td>
				</tr>		
	    </table>
	     <br/>
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		 
		 
		 
		 
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Pending Application</span></a></li>
						<li><a href="#country3"><span>Completed Application</span></a></li>
						<li><a href="#country2"><span>Regular Inspection Application</span></a></li>
					</ol>
				  </td>
				</tr>		
	    </table>

		
		
		
		
		
		
		
		
          <div class="content" id="country1" >
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				                      
                      <tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        <!--<g:sortableColumn property="id" title="Application No" />
                        
                   	        <g:sortableColumn property="applicationDate" title="Application Date" />
                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                        
                   	        <g:sortableColumn property="applicationName" title="Application Name" />-->
                        
                   	        <th class="headngblue" align="center">Application No</th>
							<th class="headngblue" align="center">Application Date</th>
							<th class="headngblue" align="center">Industry Type</th>
							<th class="headngblue" align="center">Application Name</th>
							<th class="headngblue" align="center">Category</th>
							<th class="headngblue" align="center">District</th>
						 <th class="headngblue" align="center">Consent For</th>
                   	    <th class="headngblue" align="center">Role</th>
                   	    
                    	   <% if (Flag==1){%>
                  	        <th class="headngblue" align="center">Processed By Chairman at</th>
                  	   <% }else{ %>
                  	  <th class="headngblue" align="center"></th>
                  	<%   }  %>
                   	  
                        </tr>
                    </thead>
                    <tbody>
                    <%if(newIndApplicationDetailsInstanceList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${newIndApplicationDetailsInstanceList}" status="i" var="indApplicationDetailsInstance">
                        <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                       def pendingRole=ApplicationPendingDetails.findByApplication(indApplicationDetailsInstance).role.roleName
                        String strDate = sdfDestination.format(indApplicationDetailsInstance.applicationDate );
                       
                       String roleChairman
                       def appProcessing=ApplicationProcessingDetails.find("from ApplicationProcessingDetails ap where ap.application=? order by dateCreated desc",[indApplicationDetailsInstance])
                      if(appProcessing){
                                dateUp=appProcessing.lastUpdated
                                roleChairman=appProcessing.role
                                }else{
                                dateUp=indApplicationDetailsInstance.applicationDate
                                roleChairman=""
                                }   
                             
                       String strDate1 = sdfDestination.format(dateUp );

                        String consentFor = indApplicationDetailsInstance.certificateFor
                      
                         if(consentFor.equals("new")){
                         consentFor="Fresh"
                         }
                         if(consentFor.equals("expan")){
                         consentFor = "Expansion"
                         }
                         if(consentFor.equals("Modern")){
                             consentFor = "Modernization"
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
                            <td align="center" height="25" class="txt4" ><u><g:link action="appProcessing" controller="applicationProcessingDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td>
                            <td align="center" height="25"  class="txt4"><font face="Verdana" color="red"><%=strDate%></font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red"><%=applicationFor%></font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${indApplicationDetailsInstance.indUser.category.name}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="red">${indApplicationDetailsInstance.indUser.district.districtName}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${indApplicationDetailsInstance.applicationType} ( <%=consentFor%> )</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${pendingRole}</font></td>
                            <%  
                            //    System.out.println("roleChairman -54544----"+roleChairman)               
                            //        System.out.println("pendingRole -54544----"+pendingRole)                
                                    if (roleChairman.equals("Chairman") && pendingRole.equals("MS")) {	%>
                                              
                                              <td height="25" align="center" class="txt4 yellow-bg"><b><font face="Verdana" color="<%=classToPick%>"><%=strDate1%> </font></b></td>
                                          
                                              <%}else{ %>
                                              
                                              <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"></font></b></td>
                                              
                                              <%}%>
                                             
                                         
                        	<%if(indApplicationDetailsInstance.clarification){ %>
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/viewClarification/${indApplicationDetailsInstance.id}', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></a></td> 
                        	<%} %>
                        	<%if(indApplicationDetailsInstance.inspection){ %>
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/viewInspection/${indApplicationDetailsInstance.id}', 'inspection', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Inspection.gif')}" border="0" align="center" alt="VIEW INSPECTION" ></img></a></td> 
                        	<%}%>
                        </tr>
                        
                        
                    </g:each>
                    <tr><td></td></tr>
                    </tbody>
      </table></td>
                      </tr>	
                      
                        
	  </table>
	  				<table width="95%">
		  <tr><td>&nbsp;</td></tr>
		  
		  <tr><td width="8px"  bgcolor="red"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Applications Still in progress.</font></td></tr>
        
          <tr><td width="8px"  bgcolor="green"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Completed Applications.</font></td></tr>
         
          <tr><td> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Clarification raised on this application.</font></td></tr>
         
          <tr><td> <img src="${createLinkTo(dir:'images',file:'Inspection.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Inspection raised on this application.</font></td></tr>
         
         
        
          </table>
            <br />
            <br />
          </div>
		  
		  
		  
		  <!--  
          <div id="country2">
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	       
							
							<th class="headngblue" align="center">Application No</th>
							<th class="headngblue" align="center">Application Date</th>
							<th class="headngblue" align="center">Application For</th>
							<th class="headngblue" align="center">Application Name</th>
							<th class="headngblue" align="center">Type</th>
                   	        <th class="headngblue" align="center">Consent For</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(pendingIndApplicationDetailsInstanceList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${pendingIndApplicationDetailsInstanceList}" status="i" var="indApplicationDetailsInstance">
                       <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(indApplicationDetailsInstance.actualApplicationDate );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td height="25" align="center" class="txt4"><g:link action="doGetShow" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></td>
                        
                            <td height="25" align="center" class="txt4"><%=strDate%></td>
                        
                            <td height="25" align="center" class="txt4">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationFor')}</td>
                        
                            <td height="25" align="center" class="txt4">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</td>
                        
                            <td height="25" align="center" class="txt4">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationType')}</td>
                        
                            <td height="25" align="center" class="txt4">${fieldValue(bean:indApplicationDetailsInstance, field:'certificateFor')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
		  </tr></table>
		  
            <br />
            <br />
          </div>
		  -->
		  
		  
		  
		  
		  
		  <div class="content" id="country3">
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
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
							<th align="center" class="headngblue" >Application Name</th>
							<th align="center" class="headngblue" >Category</th>
							<th align="center" class="headngblue" >District</th>
							<th align="center" class="headngblue" >Consent For</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(completedIndApplicationDetailsInstanceList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${completedIndApplicationDetailsInstanceList}" status="i" var="indApplicationDetailsInstance">
                        <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(indApplicationDetailsInstance.actualApplicationDate );
                        String consentFor = indApplicationDetailsInstance.certificateFor
                        
                        if(consentFor.equals("new")){
                        consentFor="Fresh"
                        }
                        if(consentFor.equals("Modern")){
                            consentFor = "Modernization"
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
                            <td height="25" align="center" class="txt4" ><u><g:link action="doGetShow" controller="indApplicationDetails" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></u></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><%=strDate%></font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green"><%=applicationFor%></font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${indApplicationDetailsInstance.indUser.category.name}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${indApplicationDetailsInstance.indUser.district.districtName}</font></td>
                            <td height="25" align="center" class="txt4" ><font face="Verdana" color="green">${indApplicationDetailsInstance.applicationType} ( <%=consentFor%> )</font></td>
                        </tr>
                    </g:each>
                     
                    </tbody>
      </table></td>
		  </tr></table>
		  <table width="95%">
		  <tr><td>&nbsp;</td></tr>
		  
		  <tr><td width="8px"  bgcolor="red"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Applications Still in progress.</font></td></tr>
        
          <tr><td width="8px"  bgcolor="green"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Completed Applications.</font></td></tr>
           <tr><td> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Clarification raised on this application.</font></td></tr>
         
          <tr><td> <img src="${createLinkTo(dir:'images',file:'Inspection.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Inspection raised on this application.</font></td></tr>
        
          </table>
            <br />
            <br />
          </div>  </div>
          
 <!-- for #country2 new tab regular inspection raised -->
		  
		  <div class="content" id="country2" >
  			
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				                      
                      <tr>
                        <td valign="top" bgcolor="#FFFFFF">
                        
                        <div style="height: 400px; overflow: auto;">
                        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        <th class="headngblue" align="center">Inspection No.</th>
                   	        <th class="headngblue" align="center">Inspection Month/Year</th>
							<!--<th class="headngblue" align="center">Application Date</th>
							<th class="headngblue" align="center">Update Date</th> -->
							<th class="headngblue" align="center">Application No</th>
							<th class="headngblue" align="center">Application For</th>
							<th class="headngblue" align="center">Industry Name</th>
							<th class="headngblue" align="center">Industry Address</th>
							<th class="headngblue" align="center">Type</th> 
                   	        <th class="headngblue" align="center">Forwarded By</th>
             	     
                   	    
                        </tr>
                    </thead>
                    <tbody>
                   
                   <!--################ Regular Inspection Starts Here ###################-->
                 
                  <% def inspectionForwardNotic = InspectionFwdNotice.findAll("from InspectionFwdNotice where user.id=? AND typeOfInspection = 'REGULAR_INSPECTION' order by dateCreated desc",[um.id]);
                  System.out.println("inspectionForwardNotic..."+inspectionForwardNotic)
                  def isRegularInspectionRaised
				   %>
                    <%if(inspectionForwardNotic.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${inspectionForwardNotic}" status="i" var="inspectionForwardNoticInstance">
                    <% 
                     isRegularInspectionRaised = RegularInspectionRaised.find("from RegularInspectionRaised apd where apd.application=?  ",[inspectionForwardNoticInstance.application])
                   System.out.println("isRegularInspectionRaised..."+isRegularInspectionRaised)
                    SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                                                                                    
                    String strDate = sdfDestination.format(inspectionForwardNoticInstance.dateCreated );
                    %>
                                                                                   
                                                                                   
                    <g:if test="${inspectionForwardNoticInstance.regularInspectionAssigned}" >   
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    	<td align="center" height="25" class="txt4" >
							<u>
                    			<g:link action="inspectionProcessing" controller="inspectionManagement" id="${inspectionForwardNoticInstance.application}"   >${isRegularInspectionRaised.id}</g:link>
                    		</u>																					</td>
                    	  <td align="center" height="25"  class="txt4"><font face="Verdana" color="red"><%=isRegularInspectionRaised.month%>/<%=isRegularInspectionRaised.year%></font></td>
                    		
                    	<!--	<td align="center" height="25"  class="txt4"><font face="Verdana" color="red"><%=strDate%></font></td>
                    		<td align="center" height="25"  class="txt4"><font face="Verdana" color="red"><%=strDate%></font></td> -->
                    		<td align="center" height="25" class="txt4"><font face="Verdana" color="red">${inspectionForwardNoticInstance.application.id}</font></td>
                    		<td align="center" height="25" class="txt4"><font face="Verdana" color="red">${inspectionForwardNoticInstance.application.applicationFor}</font></td>
                    		<td align="center" height="25" class="txt4"><font face="Verdana" color="red">${inspectionForwardNoticInstance.application.indUser.indName}</font></td>
                    		<td align="center" height="25" class="txt4"><font face="Verdana" color="red">${inspectionForwardNoticInstance.application.indUser.indAddress}</font></td>
                    		<td align="center" height="25" class="txt4"><font face="Verdana" color="red">${inspectionForwardNoticInstance.application.applicationType}</font></td>
                    		<td>-</td>
                    		<td align="center" height="25" class="txt4"><font face="Verdana" color="red">${inspectionForwardNoticInstance.typeOfInspection}</font></td>
                    	
                    	   <%  
                    	    
                    	    def inspectionNoteHistoryInstance = InspectionNoteHistory.find("from InspectionNoteHistory apd where apd.application=? and apd.clarification='true'",[inspectionForwardNoticInstance.application])
                      		 def inspectionNoteHistoryInstanceRevoked = InspectionNoteHistory.find("from InspectionNoteHistory apd where apd.application=? and apd.revoke='true'",[inspectionForwardNoticInstance.application])
                      		def inspectionNoteHistoryInstanceClosedInd = InspectionNoteHistory.find("from InspectionNoteHistory apd where apd.application=? and apd.closeInd='true'",[inspectionForwardNoticInstance.application])
                      		
                    	    
                    	    if(inspectionNoteHistoryInstance){
                        	
                        	  if(inspectionNoteHistoryInstance.application.clarification){ %>

							     <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/viewRegularClarification/${inspectionForwardNoticInstance.application.id}', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img><%=inspectionNoteHistoryInstance.clarification%></a></td> 
                        
                        	 <%}
                        	 else{
	                        	    if(inspectionNoteHistoryInstance.clarification){ %>
	                                     <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/viewRegularSubmittedClarification/${inspectionNoteHistoryInstance.application.id}', 'Clarification', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'ClarificationReply.gif')}" border="0" align="center" alt="SUBMIT CLARIFICATION"></img></a></td>                        		
	                                <%}
                        	     }
                        	
                        	}
                        	 if(inspectionNoteHistoryInstanceRevoked){ %>
                        	     <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/viewRegularRevoked/${inspectionNoteHistoryInstanceRevoked.application.id}', 'Revoked', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Revoked.gif')}" border="0" align="center" alt="View Revoked"></img></a></td>                        		
	                             
                          <%}%>
                         <%  if(inspectionNoteHistoryInstanceClosedInd){%>
                                   <td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/viewRegularCloseInd/${inspectionNoteHistoryInstanceClosedInd.application.id}', 'Revoked', 'WIDTH=500,HEIGHT=350,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'ClosedInd.gif')}" border="0" align="center" alt="View Closed Industry"></img></a></td>                        		
	                             
                             
                        <%}%>
                        	     
                        
                        	
            	
                        	
                    	
                    	</tr>
                    	</g:if>   
                    </g:each>
																			 
                   
                   
                   </tbody>
                   </table>
                   </div>
                   
                   </td>
                                   </tr>	
                                   
                                     
             	  </table>
             	  				<table width="95%">
             <tr><td>&nbsp;</td></tr>

             <tr><td width="8px" bgcolor="red"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Applications Still in progress.</font></td></tr>

             <tr><td width="8px" bgcolor="green"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Completed Applications.</font></td></tr>

             <tr><td width="8px"> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Observation raised on this application.</font></td></tr>
             <tr><td> <img src="${createLinkTo(dir:'images',file:'ClarificationReply.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Reply to Observation raised on this application has been made.</font></td></tr>

             <tr><td width="8px"> <img src="${createLinkTo(dir:'images',file:'Inspection.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Inspection raised on this application.</font></td></tr>
             <tr><td width="8px"> <img src="${createLinkTo(dir:'images',file:'Revoked.gif')}" border="0" align="center" alt="Revoked" ></img></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Revokation has been made on this application.</font></td></tr>


             </table>
             </div>
                        </div>
             		  
             	
		  <!--Code end here--->
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

      </div></td>
                            <td width="39" align="left" valign="top">&nbsp;</td>
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

