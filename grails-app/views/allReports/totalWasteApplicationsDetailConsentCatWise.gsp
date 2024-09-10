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
       
			<FORM id="myForm" name="myForm" action="searchBMWMonitoringReportConsentCat" method="post">  
	   
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
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th>
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th> 
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th> 
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th>
                   	    <th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th> 
                  </tr>
                  
                  
                  <tr width="200%" bgcolor="#A8DAF3"  >
                  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTE(F)</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTE(R)</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTO(F)</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTO(R)</th>
            	 
            	  
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTE(F)</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTE(R)</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTO(F)</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTO(R)</th>
            	  
            	  
            	  
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTE(F)</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTE(R)</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTO(F)</th> 
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >CTO(R)</th>
            	 
            	 
            	 
            	 
             	      
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
               def indApplicationDetailsRed= new ArrayList();
               def indApplicationDetailsOrange= new ArrayList();
               def indApplicationDetailsGreen=new ArrayList();
               def indList = new ArrayList()
        			def appPendGrantedList 
        			def appProcessingGrantedList
        			def appPendRejectedList 
        			def appProcessingRejectedList
        			def appPendList 
        			def appReceivedList
        			def newVar
        			
        			allSummaryReportReceivedListRed = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and categoryName='RED' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			allSummaryReportReceivedListOrange = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and categoryName='ORANGE' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			allSummaryReportReceivedListGreen = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and categoryName='GREEN' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			for(int k=0;k<allSummaryReportReceivedListRed.size();k++){
        			
        			 //System.out.println("------------0--"+allSummaryReportReceivedListRed[k].indRegMasterId.toLong()+"----group------"+groupId) 
        			 def regMaster=IndustryRegMaster.get(allSummaryReportReceivedListRed[k].indRegMasterId.toLong()) 		
        			//System.out.println("------- regMaster---"+regMaster)
        			def indAppDetails=IndApplicationDetails.findAll("from IndApplicationDetails i where i.indUser=?",[regMaster])
        			System.out.println("------indAppDetails--------"+indAppDetails+"------Group-----"+groupId)
        			 indApplicationDetailsRed.add(indAppDetails)
        			}
        			
        			for(int k=0;k<allSummaryReportReceivedListOrange.size();k++){
        			
        			 //System.out.println("------------0--"+allSummaryReportReceivedListOrange[k].indRegMasterId.toLong()+"----group------"+groupId) 
        			 def regMaster=IndustryRegMaster.get(allSummaryReportReceivedListOrange[k].indRegMasterId.toLong()) 		
        			//System.out.println("------- regMaster---"+regMaster)
        			def indAppDetails=IndApplicationDetails.findAll("from IndApplicationDetails i where i.indUser=?",[regMaster])
        			//System.out.println("------indAppDetails--------"+indAppDetails+"------Group-----"+groupId)
        			 indApplicationDetailsOrange.add(indAppDetails)
        			}
        			
        			for(int k=0;k<allSummaryReportReceivedListGreen.size();k++){
        			
        			 //System.out.println("------------0--"+allSummaryReportReceivedListGreen[k].indRegMasterId.toLong()+"----group------"+groupId) 
        			 def regMaster=IndustryRegMaster.get(allSummaryReportReceivedListGreen[k].indRegMasterId.toLong()) 		
        			//System.out.println("------- regMaster---"+regMaster)
        			def indAppDetails=IndApplicationDetails.findAll("from IndApplicationDetails i where i.indUser=?",[regMaster])
        			//System.out.println("------indAppDetails--------"+indAppDetails+"------Group-----"+groupId)
        			 indApplicationDetailsGreen.add(indAppDetails)
        			}
        			
        			
        			//System.out.println("--------allSummaryReportReceivedList---------"+allSummaryReportReceivedListRed.size())        			

  %>
                   	       
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=GroupMasterInstance%>
                   	    
                   	       </td>
                 
 
                   	       
                <td>  <% //System.out.println("----ind Application Details----"+indApplicationDetailsRed.size()+"--indApplicationDetails---"+indApplicationDetailsRed.toString()+"----group------"+groupId) 
                def countCTEFRESH=0;
                def countCTERenew=0;
                def countCTOFresh=0;
                def countCTORenew=0;
                def listOfApplicationFresh=new ArrayList()
                def listOfApplicationCTERenew=new ArrayList()
               def listOfApplicationCTOFresh=new ArrayList()
               	def	listOfApplicationCTORenew=new ArrayList()
                for(int iw=0; iw<indApplicationDetailsRed.size();iw++){
                def appList=(ArrayList)indApplicationDetailsRed.get(iw)
                for(int yqq=0;yqq<appList.size();yqq++){
                
                
                if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
                countCTEFRESH++
                listOfApplicationFresh.add(appList[yqq].indUser)
                }
                else if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTERenew++
                listOfApplicationCTERenew.add(appList[yqq].indUser)
                }
                 
				else if(appList[yqq].applicationType=='CTO' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
              	countCTOFresh++
                listOfApplicationCTOFresh.add(appList[yqq].indUser)
                }
                else if(appList[yqq].applicationType=='CTO' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTORenew++
                listOfApplicationCTORenew.add(appList[yqq].indUser)
              
              } 
              
                }
               }
               System.out.println("---------countCTERenew--------"+countCTERenew)
                def totalReceivedCTEFreshApp=0
                def totalReceivedCTOFreshApp=0
                def totalReceivedCTORenewApp=0
               	def totalReceivedCTERenewApp=0
               def uniqueListOfReg=listOfApplicationFresh.unique()
               //System.out.println("-------uniqueListOfReg---- "+uniqueListOfReg.toString())
               for(int kl=0;kl<uniqueListOfReg.size();kl++){
               System.out.println("---regmatsre-"+uniqueListOfReg[kl].id)
               def AllSummary=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfReg[kl].id.toString()])
               //System.out.println("-------AllSummary---- "+AllSummary)
               if(AllSummary.size()>0){
               totalReceivedCTEFreshApp=totalReceivedCTEFreshApp+AllSummary.size()
               }
               }
               
               	def uniqueListOfCTERenewReg=listOfApplicationCTERenew.unique()
                for(int kl=0;kl<uniqueListOfCTERenewReg.size();kl++){
                def AllSummaryCTERenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTERenewReg[kl].id.toString()])
               // System.out.println("=-AllSummaryCTERenew----"+AllSummaryCTERenew.size())
                if(AllSummaryCTERenew.size()>0){
                totalReceivedCTERenewApp=totalReceivedCTERenewApp+AllSummaryCTERenew.size()
                }
                }
               
                def uniqueListOfCTOFreshReg=listOfApplicationCTOFresh.unique()
                for(int kl=0;kl<uniqueListOfCTOFreshReg.size();kl++){
                def AllSummaryCTOFresh=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTOFreshReg[kl].id.toString()])
                if(AllSummaryCTOFresh.size()>0){
                totalReceivedCTOFreshApp=totalReceivedCTOFreshApp+AllSummaryCTOFresh.size()
                }
                
                } 
                
                def uniqueListOfCTORenewReg = listOfApplicationCTORenew.unique()
                for(int kl=0;kl<uniqueListOfCTORenewReg.size();kl++){
                def AllSummaryCTORenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTORenewReg[kl].id.toString()])
                if(AllSummaryCTORenew.size()>0){
                totalReceivedCTORenewApp=totalReceivedCTORenewApp+AllSummaryCTORenew.size()
                }
                }
                    %>
              	      <table cellspacing="1" >
               	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
                  	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                       <%=totalReceivedCTEFreshApp%>
                    	    </a>
                    	      </td></tr> 
                    	      </table>
         	     </td>
      	       
                   <td>
                <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
         <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                 <%=totalReceivedCTERenewApp%>
              </a>
                 </td></tr>
                 </table>
                </td>
               
                  <td>
                  
                  
                  
                  <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
               <%=totalReceivedCTOFreshApp%></a>
                 </td></tr> 
                 </table>
                </td>
                 	     
                 
                  <td>
                 <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
               <%=totalReceivedCTORenewApp%>
              </a>
                 </td></tr> 
               </table>
                </td>
                
                
                <td>
                <% //System.out.println("----ind Application Details-ORANGE---"+indApplicationDetailsOrange.size()+"--indApplicationDetails---"+indApplicationDetailsOrange.toString()+"----group------"+groupId) 
                def countCTEFRESHORANGE=0;
                def countCTERenewORANGE=0;
                def countCTOFreshORANGE=0;
                def countCTORenewORANGE=0;
                def listOfApplicationFreshORANGE=new ArrayList()
                def listOfApplicationCTERenewORANGE=new ArrayList()
               def listOfApplicationCTOFreshORANGE=new ArrayList()
               	def	listOfApplicationCTORenewORANGE=new ArrayList()
                for(int iw=0; iw<indApplicationDetailsOrange.size();iw++){
                def appList=(ArrayList)indApplicationDetailsOrange.get(iw)
                for(int yqq=0;yqq<appList.size();yqq++){
                
                
                if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
                countCTEFRESHORANGE++
                listOfApplicationFreshORANGE.add(appList[yqq].indUser)
                }
                else if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTERenewORANGE++
                listOfApplicationCTERenewORANGE.add(appList[yqq].indUser)
                }
                 
				else if(appList[yqq].applicationType=='CTO' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
              	countCTOFresh++
                listOfApplicationCTOFreshORANGE.add(appList[yqq].indUser)
                }
                else if(appList[yqq].applicationType=='CTO' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTORenew++
                listOfApplicationCTORenewORANGE.add(appList[yqq].indUser)
              
              } 
              
                }
               }
               System.out.println("---------countCTERenew--------"+countCTEFRESHORANGE)
                def totalReceivedCTEFreshAppORANGE=0
                def totalReceivedCTOFreshAppORANGE=0
                def totalReceivedCTORenewAppORANGE=0
               	def totalReceivedCTERenewAppORANGE=0
               def uniqueListOfRegORANGE=listOfApplicationFreshORANGE.unique()
               //System.out.println("-------uniqueListOfRegORANGE---- "+uniqueListOfRegORANGE.toString())
               for(int kl=0;kl<uniqueListOfRegORANGE.size();kl++){
               System.out.println("---regmatsre-"+uniqueListOfRegORANGE[kl].id)
               def AllSummaryORANGE=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfRegORANGE[kl].id.toString()])
               //System.out.println("-------AllSummary---- "+AllSummary)
               if(AllSummaryORANGE.size()>0){
               totalReceivedCTEFreshAppORANGE=totalReceivedCTEFreshAppORANGE+AllSummaryORANGE.size()
               }
               }
               
               	def uniqueListOfCTERenewRegORANGE=listOfApplicationCTERenewORANGE.unique()
                for(int kl=0;kl<uniqueListOfCTERenewRegORANGE.size();kl++){
                def AllSummaryCTERenewORANGE=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTERenewRegORANGE[kl].id.toString()])
               // System.out.println("=-AllSummaryCTERenew----"+AllSummaryCTERenewORANGE.size())
                if(AllSummaryCTERenewORANGE.size()>0){
                totalReceivedCTERenewAppORANGE=totalReceivedCTERenewAppORANGE+AllSummaryCTERenewORANGE.size()
                }
                }
               
                def uniqueListOfCTOFreshRegORANGE=listOfApplicationCTOFreshORANGE.unique()
                for(int kl=0;kl<uniqueListOfCTOFreshRegORANGE.size();kl++){
                def AllSummaryCTOFreshORANGE=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTOFreshRegORANGE[kl].id.toString()])
                if(AllSummaryCTOFreshORANGE.size()>0){
                totalReceivedCTOFreshAppORANGE=totalReceivedCTOFreshAppORANGE+AllSummaryCTOFreshORANGE.size()
                }
                
                } 
                
                def uniqueListOfCTORenewRegORANGE = listOfApplicationCTORenewORANGE.unique()
                for(int kl=0;kl<uniqueListOfCTORenewRegORANGE.size();kl++){
                def AllSummaryCTORenewORANGE=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTORenewRegORANGE[kl].id.toString()])
                if(AllSummaryCTORenewORANGE.size()>0){
                totalReceivedCTORenewAppORANGE=totalReceivedCTORenewAppORANGE+AllSummaryCTORenewORANGE.size()
                }
                }
                    %>
                
                
                <table cellspacing="1"  >
               <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=totalReceivedCTEFreshAppORANGE%>
             </a>
                </td></tr> 
              </table>
               </td>
               
               
               
               
               
               
               
               
            <td>  
     	      <table cellspacing="1" >
      	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
         	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=totalReceivedCTERenewAppORANGE%>
           	    </a>
           	      </td></tr> 
           	      </table>
	     </td>
	       
          <td>
       <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
        <%=totalReceivedCTOFreshAppORANGE%>
     </a>
        </td></tr>
        </table>
       </td>
      
         <td>
         <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
      <%=totalReceivedCTORenewAppORANGE%></a>
        </td></tr> 
        </table>
       </td>
        	     
        
         <td><%
          //System.out.println("----ind Application Details-GREEN---"+indApplicationDetailsGreen.size()+"--indApplicationDetails---"+indApplicationDetailsGreen.toString()+"----group------"+groupId) 
                def countCTEFRESHGREEN=0;
                def countCTERenewGREEN=0;
                def countCTOFreshGREEN=0;
                def countCTORenewGREEN=0;
                def listOfApplicationFreshGREEN=new ArrayList()
                def listOfApplicationCTERenewGREEN=new ArrayList()
               def listOfApplicationCTOFreshGREEN=new ArrayList()
               	def	listOfApplicationCTORenewGREEN=new ArrayList()
                for(int iw=0; iw<indApplicationDetailsGreen.size();iw++){
                def appList=(ArrayList)indApplicationDetailsGreen.get(iw)
                for(int yqq=0;yqq<appList.size();yqq++){
                
                
                if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
                countCTEFRESHGREEN++
                listOfApplicationFreshGREEN.add(appList[yqq].indUser)
                }
                else if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTERenewGREEN++
                listOfApplicationCTERenewGREEN.add(appList[yqq].indUser)
                }
                 
				else if(appList[yqq].applicationType=='CTO' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
              	countCTOFreshGREEN++
                listOfApplicationCTOFreshGREEN.add(appList[yqq].indUser)
                }
                else if(appList[yqq].applicationType=='CTO' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTORenewGREEN++
                listOfApplicationCTORenewGREEN.add(appList[yqq].indUser)
              
              } 
              
                }
               }
               System.out.println("---------countCTERenew--------"+countCTORenewGREEN)
                def totalReceivedCTEFreshAppGREEN=0
                def totalReceivedCTOFreshAppGREEN=0
                def totalReceivedCTORenewAppGREEN=0
               	def totalReceivedCTERenewAppGREEN=0
               def uniqueListOfRegGREEN=listOfApplicationFreshGREEN.unique()
               //System.out.println("-------uniqueListOfReg---- "+uniqueListOfRegGREEN.toString())
               for(int kl=0;kl<uniqueListOfRegGREEN.size();kl++){
               System.out.println("---regmatsre-"+uniqueListOfRegGREEN[kl].id)
               def AllSummaryGREEN=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfRegGREEN[kl].id.toString()])
               //System.out.println("-------AllSummary---- "+AllSummary)
               if(AllSummaryGREEN.size()>0){
               totalReceivedCTEFreshAppGREEN=totalReceivedCTEFreshAppGREEN+AllSummaryGREEN.size()
               }
               }
               
               	def uniqueListOfCTERenewRegGREEN=listOfApplicationCTERenewGREEN.unique()
                for(int kl=0;kl<uniqueListOfCTERenewRegGREEN.size();kl++){
                def AllSummaryCTERenewGREEN=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTERenewRegGREEN[kl].id.toString()])
               // System.out.println("=-AllSummaryCTERenew----"+AllSummaryCTERenewGREEN.size())
                if(AllSummaryCTERenewGREEN.size()>0){
                totalReceivedCTERenewAppGREEN=totalReceivedCTERenewAppGREEN+AllSummaryCTERenewGREEN.size()
                }
                }
               
                def uniqueListOfCTOFreshRegGREEN=listOfApplicationCTOFreshGREEN.unique()
                for(int kl=0;kl<uniqueListOfCTOFreshRegGREEN.size();kl++){
                def AllSummaryCTOFreshGREEN=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTOFreshRegGREEN[kl].id.toString()])
                if(uniqueListOfCTOFreshRegGREEN.size()>0){
                totalReceivedCTOFreshAppGREEN=totalReceivedCTOFreshAppGREEN+uniqueListOfCTOFreshRegGREEN.size()
                }
                
                } 
                
                def uniqueListOfCTORenewRegGREEN = listOfApplicationCTORenewGREEN.unique()
                for(int kl=0;kl<uniqueListOfCTORenewRegGREEN.size();kl++){
                def AllSummaryCTORenewGREEN=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfCTORenewRegGREEN[kl].id.toString()])
                if(AllSummaryCTORenewGREEN.size()>0){
                totalReceivedCTORenewAppGREEN=totalReceivedCTORenewAppGREEN+AllSummaryCTORenewGREEN.size()
                }
                }
                    %>
              	
         
         
         
        <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
      <%=totalReceivedCTEFreshAppGREEN%>
     </a>
        </td></tr> 
      </table>
       </td>
       
       
       <td>
       <table cellspacing="1"  >
      <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
   <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
     <%=totalReceivedCTERenewAppGREEN%>
    </a>
       </td></tr> 
     </table>
      </td>
      
      
      
      
      
     
      <td>  
	      <table cellspacing="1" >
	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
       <%=totalReceivedCTOFreshAppGREEN%>
    	    </a>
    	      </td></tr> 
    	      </table>
  </td>
 
   <td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 <%=totalReceivedCTORenewAppGREEN%>
</a>
 </td></tr>
 </table>
</td>

  <td>
  <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=allSummaryReportRejectedListG.size()%></a>
 </td></tr> 
 </table>
</td>
 	     



               
         
























			<%

					
           			
           			appliedR=appliedR+totalReceivedCTEFreshApp;
           			appliedO=appliedO+totalReceivedCTERenewApp; 
           			appliedG=appliedG+totalReceivedCTOFreshApp; 
           			appliedW=appliedW+totalReceivedCTORenewApp; 
           			
           			
           			
           			issuedR=issuedR+totalReceivedCTEFreshAppORANGE;
           			issuedO=issuedO+totalReceivedCTERenewAppORANGE; 
           			issuedG=issuedG+totalReceivedCTOFreshAppORANGE; 
           			issuedW=issuedW+totalReceivedCTORenewAppORANGE; 
           			
           			
           			
           			rejectedR=rejectedR+totalReceivedCTEFreshAppGREEN;
           			rejectedO=rejectedO+totalReceivedCTERenewAppGREEN; 
           			rejectedG=rejectedG+totalReceivedCTOFreshAppGREEN; 
           			rejectedW=rejectedW+totalReceivedCTORenewAppGREEN; 
           			
           			
           			
           			
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
                
                
                <td><%=issuedR%></td>
                <td><%=issuedO%></td>
                <td><%=issuedG%></td>
                <td><%=issuedW%></td>
                
                
                <td><%=rejectedR%></td>
                <td><%=rejectedO%></td>
                <td><%=rejectedG%></td>
                <td><%=rejectedW%></td>
                
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


