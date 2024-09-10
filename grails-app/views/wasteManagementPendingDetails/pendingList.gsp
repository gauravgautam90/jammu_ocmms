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
</style>

<script type="text/javascript" src="js/tabcontent.js">
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
		<!-- code for menuAdminHorizontal-->
		<g:include controller="userMaster" action="showAdminMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin--><!-- code for menuAdmin-->
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
               

              %>

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
                            <td width="34" align="left" valign="top">&nbsp;</td>
                            <td width="685" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
                            <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
            				<tr valign="middle" >
                              <td  align="left" class= "headngblue" >
            				  	<% String cont=request.getContextPath() %>
            					<input type="radio" id="recent" name="recent"   value="" checked> HWM,BMW,MSW Applications  &nbsp;&nbsp;&nbsp;&nbsp;
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
					</ol>
				  </td>
				</tr>		
	    </table>
		
		
		
          <div class="content" id="country1" >
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	        <th align="center" class="headngblue" >Role</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(wasteManagementPendingList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${wasteManagementPendingList}" status="i" var="wasteManagementPendingInstance">
                         <% 
                        def aapId=wasteManagementPendingInstance.applicationId
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementPendingInstance.dateCreated );
                        
                        String classToPick="red";
                        
                        def appProcessInstApprove = WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails afr where afr.applicationId=? and afr.approvalStatus in ('Approved','Refused') order by afr.dateCreated asc",[aapId])
						if(appProcessInstApprove){
                        if(appProcessInstApprove.approvalStatus=="Approved")
							{
									classToPick="black";
							}
						else if(appProcessInstApprove.approvalStatus=="Refused")
						{
							classToPick="blue";
					}
						}
                        
                        def enable='false';
                        def pendingFlag='false';
                        def feeAmountId
                        def feeAmountId1
                        def appPending = WasteManagementPendingDetails.find("from WasteManagementPendingDetails afr where afr.applicationId=? and afr.scrutinyStatus = '' order by afr.dateCreated asc",[aapId])
						//System.out.println("aapId--"+aapId)
                        if(appPending)
						{
							pendingFlag='true';
						}
                        if(wasteManagementPendingInstance.applicationFor=="HWM"){
                        feeAmountId1 = BankTransactionDetailsHWM.find("from BankTransactionDetailsHWM abc where abc.indApplication.id = ? and abc.transactionStatus = 'S' ",[aapId.toLong()])
                        feeAmountId = FeeBankDetailsHWM.find("from FeeBankDetailsHWM abc where abc.application.id = ?",[aapId.toLong()])
                        if(feeAmountId || feeAmountId1)
        		    	{
        		    		enable='true';
        		    	}
                        }else if(wasteManagementPendingInstance.applicationFor=="BMW"){
                            feeAmountId = BankTransactionDetailsBMW.find("from BankTransactionDetailsBMW abc where abc.bioApplication.id = ? and abc.transactionStatus = 'S' ",[aapId.toLong()])
                            feeAmountId1 = FeeBankDetailsBMW.find("from FeeBankDetailsBMW abc where abc.application.id = ?",[aapId.toLong()])
                            if(feeAmountId || feeAmountId1)
            		    	{
            		    		enable='true';
            		    	}
                        }else if(wasteManagementPendingInstance.applicationFor=="EWaste"){
                        	feeAmountId1 = BankTransactionDetailsEWaste.find("from BankTransactionDetailsEWaste abc where abc.indApplication.id = ? and abc.transactionStatus = 'S' ",[aapId.toLong()])
                            feeAmountId = FeeBankDetailsEwaste.find("from FeeBankDetailsEwaste abc where abc.application.id = ?",[aapId.toLong()])
                            if(feeAmountId || feeAmountId1)
            		    	{
            		    		enable='true';
            		    	}
                        }
                        
                          %>
                        
                          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          <%   
                          	if(enable=="true" || pendingFlag=="true"){
                          %>
                          <td align="center" height="25" class="txt4" ><g:link action="appProcessing" controller="wasteManagementProcessingDetails" id="${wasteManagementPendingInstance.id}"><u>${fieldValue(bean:wasteManagementPendingInstance, field:'applicationId')}</u></g:link></td>
                          <td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=classToPick%>"><%=strDate%></font></td>
                          <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=classToPick%>">${fieldValue(bean:wasteManagementPendingInstance, field:'indRegInstance')}</font></td>
                          <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=classToPick%>">${fieldValue(bean:wasteManagementPendingInstance, field:'applicationFor')}</font></td>
                          <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=classToPick%>">${fieldValue(bean:wasteManagementPendingInstance, field:'role')}</font></td>
                          <%   
                         }else{
                               %>
                     
                               <%   
                              	}
                              	%>
                          
                            
<!--added by shashank-->    <%if(isClarList.get(i)) { 
                            %>
                          
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementPendingDetails/viewClarification?appliId=<%=aapId%>&appFor=${wasteManagementPendingInstance.applicationFor}', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" align="center" alt="SUBMIT CLARIFICATION"  title="Clarification Raised"></img></a></td> 
                        	<%}%>
                        	<%if(isInspecList.get(i)){ %>
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementPendingDetails/viewInspection?appliId=<%=aapId%>&appFor=${wasteManagementPendingInstance.applicationFor}', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Inspection.gif')}" border="0" align="center" alt="INSPECTION" title="Inspection Raised"></img></td> 
                        	<%}%>
  <!--end code by shashank-->                      	
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
                      </tr>	  
	  </table>
            <br />
            <br />
            
            <table width="95%">
            <tr>
               <td>&nbsp;</td>
            </tr>
            <tr>
               <td width="8px" bgcolor="red"></td>
               <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Applications Still in progress.</font></td>
            </tr>
            <tr>
               <td width="8px" bgcolor="green"></td>
               <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Completed Applications.</font></td>
            </tr>
            
            <tr>
               <td width="8px" bgcolor="black"></td>
               <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Approved Applications.</font></td>
            </tr>
            
            <tr>
            <td width="8px" bgcolor="blue"></td>
            <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Refused Applications.</font></td>
         </tr>
            
            <tr>
               <td> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td>
               <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Clarification raised on this application.</font></td>
            </tr>
            <tr>
               <td> <img src="${createLinkTo(dir:'images',file:'Inspection.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></td>
               <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Inspection raised on this application.</font></td>
            </tr>
         </table>
          </div>
		  
		 
		  
		  
		  
		  <div class="content" id="country3">
           <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	     
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Application For</th> 
                   	        <th align="center" class="headngblue" >Role</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(wasteManagementCompletedList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${wasteManagementCompletedList}" status="i" var="wasteManagementCompletedInstance">
                         <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                         
                         
                        String strDate = sdfDestination.format(wasteManagementCompletedInstance.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          <td align="center" height="25" class="txt4"  ><u>
                          <% if(wasteManagementCompletedInstance.applicationFor=="HWM") { 
                        	 def hazInst =  HazardeousWasteAuthApp.get((wasteManagementCompletedInstance.applicationId).toInteger())
                        	/// System.out.println("hazInst=="+hazInst);
                        	  if(hazInst.isNewApplication){
                        	  %>
                        	  
                        	  <g:link controller="hazardeousWasteAuthApp" action="showNewFormat" id="${wasteManagementCompletedInstance.applicationId}">
                        	  ${fieldValue(bean:wasteManagementCompletedInstance, field:'applicationId')} 
                        	  
                        	  </g:link>
                        	  <%}
                        	  else{%> 
                          
                        	  <g:link controller="hazardeousWasteAuthApp" action="show1" id="${wasteManagementCompletedInstance.applicationId}">
                        	  ${fieldValue(bean:wasteManagementCompletedInstance, field:'applicationId')} 
                        	  
                        	  </g:link>
                          
                        <%}  }%>
                          <% if(wasteManagementCompletedInstance.applicationFor=="BMW") {
                        	  def bioInst =  BioMedicalWaste.get((wasteManagementCompletedInstance.applicationId).toInteger())
                        	  // System.out.println("bioInst=="+bioInst);
                        	  if(bioInst?.isNewApplication){
                        		  System.out.println("inside isNewApplication=="+bioInst);
                        	  %>
                          <g:link controller="bioMedicalWaste"  action="showNewFormat1" id="${wasteManagementCompletedInstance.applicationId}">
                          ${fieldValue(bean:wasteManagementCompletedInstance, field:'applicationId')} 
                          </g:link>
                          <%}
                        	  else{%> 
                        	  System.out.println("out isNewApplication=="+bioInst);
                        	  <g:link controller="bioMedicalWaste"  action="showforSpcb" id="${wasteManagementCompletedInstance.applicationId}">
                              ${fieldValue(bean:wasteManagementCompletedInstance, field:'applicationId')} 
                              </g:link>
                             
                        	  
                          <%} }%>
                          <% if(wasteManagementCompletedInstance.applicationFor=="MSW") {%><g:link controller="municipalSolidWaste" action="showforSpcb" id="${wasteManagementCompletedInstance.applicationId}"> ${fieldValue(bean:wasteManagementCompletedInstance, field:'applicationId')}</g:link><%} %>
	                         </u></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" color="green"><%=strDate%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:wasteManagementCompletedInstance, field:'indRegInstance')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:wasteManagementCompletedInstance, field:'applicationFor')}</font></td>
                           
                            <%if(wasteManagementCompletedInstance.completionStatus=="In-Complete" && wasteManagementCompletedInstance.scrutinyStatus=="In-Complete"){%>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:wasteManagementCompletedInstance, field:'role')} Pending with industry for Resubmit Application </font></td>                         
                            <%}else{%>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="green">${fieldValue(bean:wasteManagementCompletedInstance, field:'role')}</font></td>
                            <%}%>
                         
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
                      </tr>	  
	  </table>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		
		  
          </div>
		  
		  
		  
		  
		  

      </div></td>
                            <td width="59" align="left" valign="top">&nbsp;</td>
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

