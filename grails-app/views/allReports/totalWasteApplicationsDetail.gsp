<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

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

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>

<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

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
     
              
                <%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aab=(UserProfile)session.getAttribute("userprof");
             		  firstname=aab.employeeFirstName;
           		  lastName=aab.employeeLastName;
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
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%">
	




         
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
			<FORM id="myForm" name="myForm" action="searchWasteMonitoringReport" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			                       
                 <tr bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">End Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr></table>
		
		 <table width="95%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
		  </tr>
 
		</table>
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
        <tr>
         
         <%
         String dd1;
         String dd2;
         String dd3;
         if(sqlDate)
         {
         java.util.Date utilDate1 = new java.util.Date(sqlDate.getTime());
         java.util.Date utilDate2 = new java.util.Date(sqlDate2.getTime());
java.util.Date utilDate3 = new java.util.Date(sqlDate3.getTime());

         SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

         dd1=dmyFormat.format(utilDate1);
         dd2=dmyFormat.format(utilDate2);
         dd3=dmyFormat.format(utilDate3);
         }
         %>
         
         <td colspan="9" align="center" >
         <span class="headngblue">
               <span style="color:red;font-size:13px;">Consent application wise status: Office wise</span> 
               <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
         </span>
         </td>
         </tr> 
        <tr><td></td></tr>               
	  <tr>
<td  align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popListOfApplicationsReport', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue" align="right"></span></a>
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popListOfApplicationsReportExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue" align="right">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		
		
         
	
<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                  
				<tr width="200%" bgcolor="#A8DAF3"  >
                   
                   	    <th align="center"  rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >District Office</th>
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th>
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Consent Issued</th> 
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance to be issued</th> 
                   	      
                  </tr>
                  
                  
                  <tr width="200%" bgcolor="#A8DAF3"  >
                  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
            	  
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
            	  
            	  
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
            	 
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
           	  	<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
           	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
             	      
            </tr>
                  
                  <% 	
            	    def grandTotTC = 0 
            		def grandTotPTC = 0
            		def grandTotGTC = 0
            		def grandTotRTC = 0
            		
            		
            		
            		
            		def appliedR = 0 
            		def appliedO = 0 
            		def appliedG = 0 
            		def appliedW = 0 
            		def appliedT = 0 
            		
            		def issuedR = 0 
            		def issuedO = 0 
            		def issuedG = 0 
            		def issuedW = 0 
            		def issuedT = 0 
            		
            		def rejectedR = 0 
            		def rejectedO = 0 
            		def rejectedG = 0 
            		def rejectedW = 0 
            		def rejectedT = 0 
            		
            		def pendingR = 0 
            		def pendingO = 0 
            		def pendingG = 0 
            		def pendingW = 0 
            		def pendingT = 0 
            		
            		
            		
            		
            		
            		
            	%>
                  
                  
           <g:each in="${groupList}" status="i" var="GroupMasterInstance">
           
           <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">   

                
                    
               <%
                   	def roleArray = new ArrayList()
        		    def groupId = (GroupMasterInstance.id).toString()
        			def allSummaryReportReceivedList = new ArrayList()
        			def allSummaryReportGrantedList = new ArrayList()
        			def allSummaryReportRejectedList = new ArrayList()
        			def allSummaryReportPendingList = new ArrayList();
               
               
               
               def allSummaryReportReceivedListR = new ArrayList();
               def allSummaryReportReceivedListO = new ArrayList();
               def allSummaryReportReceivedListG = new ArrayList();
               def allSummaryReportReceivedListW = new ArrayList();
               
               def allSummaryReportPendingListR = new ArrayList();
               def allSummaryReportPendingListO = new ArrayList();
               def allSummaryReportPendingListG = new ArrayList();
               def allSummaryReportPendingListW = new ArrayList();
               
               def allSummaryReportGrantedListR = new ArrayList();
               def allSummaryReportGrantedListO = new ArrayList();
               def allSummaryReportGrantedListG = new ArrayList();
               def allSummaryReportGrantedListW = new ArrayList();
               
               
               def allSummaryReportRejectedListR = new ArrayList();
               def allSummaryReportRejectedListO = new ArrayList();
               def allSummaryReportRejectedListG = new ArrayList();
               def allSummaryReportRejectedListW = new ArrayList();
               
               
               def indList = new ArrayList()
        			def appPendGrantedList 
        			def appProcessingGrantedList
        			def appPendRejectedList 
        			def appProcessingRejectedList
        			def appPendList 
        			def appReceivedList
        			def newVar
        			
        			allSummaryReportReceivedList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])        			
					allSummaryReportReceivedListR = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportReceivedListO = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportReceivedListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='GREEN'  and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportReceivedListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='WHITE'  and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			allSummaryReportPendingList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])     			
					allSummaryReportPendingListR= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportPendingListO= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportPendingListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='GREEN' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportPendingListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='WHITE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			allSummaryReportGrantedList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])			
					allSummaryReportGrantedListR= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportGrantedListO= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportGrantedListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='GREEN' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportGrantedListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='WHITE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			allSummaryReportRejectedList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportRejectedListR= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportRejectedListO= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportRejectedListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='GREEN' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					allSummaryReportRejectedListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.categoryName='WHITE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])

				allSummaryReportRejectedListReturned= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where  abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='returned' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
				System.out.println("----Returned applications------"+allSummaryReportRejectedListReturned)	
			        		
              %>
                   	       
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=GroupMasterInstance%>
                   	    
                   	       </td>
                 
 
                   	       
                <td>  
              	      <table cellspacing="1" >
               	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
               	       <g:if test="${allSummaryReportReceivedListR.size()==0}">
               	        <%=allSummaryReportReceivedListR.size()%>
               	       </g:if><g:else>  
                  	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                       <%=allSummaryReportReceivedListR.size()%>
                    	    </a></g:else> 
                    	      </td></tr> 
                    	      </table>
         	     </td>
      	       
                   <td>
                <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
                <g:if test="${allSummaryReportReceivedListO.size()==0}">
               	        <%=allSummaryReportReceivedListO.size()%>
               	       </g:if><g:else>
         <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                 <%=allSummaryReportReceivedListO.size()%>
              </a></g:else>
                 </td></tr>
                 </table>
                </td>
               
                  <td>
                  <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
                <g:if test="${allSummaryReportReceivedListG.size()==0}">
               	        <%=allSummaryReportReceivedListG.size()%>
               	       </g:if>   <g:else> 
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
               <%=allSummaryReportReceivedListG.size()%></a></g:else>
                 </td></tr> 
                 </table>
                </td>
                 	     
                 
                  <td>
                 <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
                <g:if test="${allSummaryReportReceivedListW.size()==0}">
               	        <%=allSummaryReportReceivedListW.size()%>
               	       </g:if> <g:else>       
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=WHITE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
               <%=allSummaryReportReceivedListW.size()%>
              </a></g:else>
                 </td></tr> 
               </table>
                </td>
                
                
                <td>
                <table cellspacing="1"  >
               <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
               <g:if test="${allSummaryReportReceivedList.size()==0}">
               	        <%=allSummaryReportReceivedList.size()%>
               	       </g:if><g:else>         
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=allSummaryReportReceivedList.size()%>
             </a></g:else>
                </td></tr> 
              </table>
               </td>
               
               
               
               
               
               
               
               
            <td>  
     	      <table cellspacing="1" >
      	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
      	        <g:if test="${allSummaryReportGrantedListR.size()==0}">
               	        <%=allSummaryReportGrantedListR.size()%>
               	       </g:if> <g:else>         
         	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=allSummaryReportGrantedListR.size()%>
           	    </a></g:else>
           	      </td></tr> 
           	      </table>
	     </td>
	       
          <td>
       <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
          <g:if test="${allSummaryReportGrantedListO.size()==0}">
               	        <%=allSummaryReportGrantedListO.size()%>
               	       </g:if>    <g:else> 
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
        <%=allSummaryReportGrantedListO.size()%>
     </a></g:else> 
        </td></tr>
        </table>
       </td>
      
         <td>
         <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
       <g:if test="${allSummaryReportGrantedListG.size()==0}">
               	        <%=allSummaryReportGrantedListG.size()%>
               	       </g:if>  <g:else>      
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
      <%=allSummaryReportGrantedListG.size()%></a></g:else> 
        </td></tr> 
        </table>
       </td>
        	     
        
         <td>
        <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
         <g:if test="${allSummaryReportGrantedListW.size()==0}">
               	        <%=allSummaryReportGrantedListW.size()%>
               	       </g:if>     <g:else>    
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=WHITE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
      <%=allSummaryReportGrantedListW.size()%>
     </a></g:else> 
        </td></tr> 
      </table>
       </td>
       
       
       <td>
       <table cellspacing="1"  >
      <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
      <g:if test="${allSummaryReportGrantedList.size()==0}">
               	        <%=allSummaryReportGrantedList.size()%>
               	       </g:if> <g:else>     
   <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
     <%=allSummaryReportGrantedList.size()%>
    </a></g:else> 
       </td></tr> 
     </table>
      </td>
      
      
      
      
      
     
      <td>  
	      <table cellspacing="1" >
	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
	       <g:if test="${allSummaryReportRejectedListR.size()==0}">
               	        <%=allSummaryReportRejectedListR.size()%>
               	       </g:if>   <g:else>    
  	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
       <%=allSummaryReportRejectedListR.size()%>
    	    </a></g:else>    
    	      </td></tr> 
    	      </table>
  </td>
 
   <td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
 <g:if test="${allSummaryReportRejectedListO.size()==0}">
               	        <%=allSummaryReportRejectedListO.size()%>
               	       </g:if>   <g:else>      
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 <%=allSummaryReportRejectedListO.size()%>
</a></g:else>    
 </td></tr>
 </table>
</td>

  <td>
  <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
 <g:if test="${allSummaryReportRejectedListG.size()==0}">
               	        <%=allSummaryReportRejectedListG.size()%>
               	       </g:if><g:else>         
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportRejectedListG.size()%></a></g:else>    
 </td></tr> 
 </table>
</td>
 	     
 
  <td>
 <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}"> 
<g:if test="${allSummaryReportRejectedListW.size()==0}">
               	        <%=allSummaryReportRejectedListW.size()%>
               	       </g:if> <g:else>         
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=WHITE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportRejectedListW.size()%>
</a></g:else>    
 </td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}"> 
<g:if test="${allSummaryReportRejectedList.size()==0}">
               	        <%=allSummaryReportRejectedList.size()%>
               	       </g:if><g:else>       
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportRejectedList.size()%>
</a></g:else>    
</td></tr> 
</table>
</td>
               
         










<td>  
<table cellspacing="1" >
 <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
 <g:if test="${allSummaryReportPendingListR.size()==0}">
               	        <%=allSummaryReportPendingListR.size()%>
               	       </g:if> <g:else>        
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportPendingListR.size()%>
  </a></g:else>    
    </td></tr> 
    </table>
</td>

<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
<g:if test="${allSummaryReportPendingListO.size()==0}">
               	        <%=allSummaryReportPendingListO.size()%>
               	       </g:if><g:else>           
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportPendingListO.size()%>
</a></g:else>    
</td></tr>
</table>
</td>

<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
<g:if test="${allSummaryReportPendingListG.size()==0}">
               	        <%=allSummaryReportPendingListG.size()%>
               	       </g:if><g:else>           
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportPendingListG.size()%></a></g:else>    
</td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">
<g:if test="${allSummaryReportPendingListW.size()==0}">
               	        <%=allSummaryReportPendingListW.size()%>
               	       </g:if>  <g:else>       
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=WHITE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportPendingListW.size()%>
</a></g:else>    
</td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}"> 
<g:if test="${allSummaryReportPendingList.size()==0}">
               	        <%=allSummaryReportPendingList.size()%>
               	       </g:if> <g:else>       
<a href="#" onclick="window.open('<%=request.getContextPath()%>/wasteManagementProcessingDetails/getTotAppBMW?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportPendingList.size()%>
</a></g:else>    
</td></tr> 
</table>
</td>












			<%

					
           			
           			appliedR=appliedR+allSummaryReportReceivedListR.size();
           			appliedO=appliedO+allSummaryReportReceivedListO.size(); 
           			appliedG=appliedG+allSummaryReportReceivedListG.size(); 
           			appliedW=appliedW+allSummaryReportReceivedListW.size(); 
           			appliedT=appliedT+allSummaryReportReceivedList.size();
           			
           			
           			issuedR=issuedR+allSummaryReportGrantedListR.size();
           			issuedO=issuedO+allSummaryReportGrantedListO.size(); 
           			issuedG=issuedG+allSummaryReportGrantedListG.size(); 
           			issuedW=issuedW+allSummaryReportGrantedListW.size(); 
           			issuedT=issuedT+allSummaryReportGrantedList.size();
           			
           			
           			rejectedR=rejectedR+allSummaryReportRejectedListR.size();
           			rejectedO=rejectedO+allSummaryReportRejectedListO.size(); 
           			rejectedG=rejectedG+allSummaryReportRejectedListG.size(); 
           			rejectedW=rejectedW+allSummaryReportRejectedListW.size(); 
           			rejectedT=rejectedT+allSummaryReportRejectedList.size(); 
           			
           			
           			
           			pendingR=pendingR+allSummaryReportPendingListR.size();
           			pendingO=pendingO+allSummaryReportPendingListO.size(); 
           			pendingG=pendingG+allSummaryReportPendingListG.size(); 
           			pendingW=pendingW+allSummaryReportPendingListW.size(); 
           			pendingT=pendingT+allSummaryReportPendingList.size(); 
           			
           			
           			
           			
               %>
               
                </g:each>	 
                <tr>
                <td>Grand Total</td>
               
                <td><%=appliedR%></td>
                <td><%=appliedO%></td>
                <td><%=appliedG%></td>
                <td><%=appliedW%></td>
                <td><%=appliedT%></td>
                
                <td><%=issuedR%></td>
                <td><%=issuedO%></td>
                <td><%=issuedG%></td>
                <td><%=issuedW%></td>
                <td><%=issuedT%></td>
                
                <td><%=rejectedR%></td>
                <td><%=rejectedO%></td>
                <td><%=rejectedG%></td>
                <td><%=rejectedW%></td>
                <td><%=rejectedT%></td>
                
                
                <td><%=pendingR%></td>
                <td><%=pendingO%></td>
                <td><%=pendingG%></td>
                <td><%=pendingW%></td>
                <td><%=pendingT%></td>
                
                </tr>
              </tr>
             
                
                </table>
		

		
		
		
            <br />
            <br />
          
		  </form>
		  
	  <% session.endDate1=null
       	  session.startDate1=null
       %>
		  
          </div>
	  
	  
      </div></td>
                            <td width="82" align="left" valign="top">&nbsp;</td>
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
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


