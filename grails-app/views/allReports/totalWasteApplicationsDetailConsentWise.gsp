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
	System.out.println("--In Total waste report consent Wise----")	
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
       
			<FORM id="myForm" name="myForm" action="searchMonitoringWasteReportConsentWise" method="post">  
	   
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
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Establish (Fresh)</th>
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Establish (Renewal)</th> 
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Operate (Fresh)</th> 
                   	    <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Operate (Renewal)</th> 
                   	      
                  </tr>
                  
                  
                  <tr width="200%" bgcolor="#A8DAF3"  >
                  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Issued</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance</th>
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Returned</th>
            	  
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Issued</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance</th>
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
            	  
            	  
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th> 
             	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Issued</th>
             	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance</th>
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
            	 
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th> 
            	  <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Issued</th>
            	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
           	  	<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance</th>
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
               def indApplicationDetails= new ArrayList();
               def countForFresh=0
               def countForRenew=0
               
               def indList = new ArrayList()
        			def appPendGrantedList 
        			def appProcessingGrantedList
        			def appPendRejectedList 
        			def appProcessingRejectedList
        			def appPendList 
        			def appReceivedList
        			def newVar
        			
        			allSummaryReportReceivedList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and abc.authDate>= ? and  abc.authDate<= ?   order by abc.id desc ",[groupId,sqlDate,sqlDate2]).unique{it.indRegMasterId}
        			//System.out.println("----allSummaryReportReceivedList----"+allSummaryReportReceivedList.size())
        			for(int k=0;k<allSummaryReportReceivedList.size();k++){
        			
        			 //System.out.println("------------0--"+allSummaryReportReceivedList[k].indRegMasterId.toLong()+"----group------"+groupId) 
        			 def regMaster=IndustryRegMaster.get(allSummaryReportReceivedList[k].indRegMasterId.toLong()) 		
        			//System.out.println("------- regMaster---"+regMaster)
        			def indAppDetails=IndApplicationDetails.findAll("from IndApplicationDetails i where i.indUser=?",[regMaster])
        			//System.out.println("------indAppDetails--------"+indAppDetails+"------Group-----"+groupId)
        			 indApplicationDetails.add(indAppDetails)
        			}
        			  //System.out.println("-------Total Count---"+countForRenew+"---------ff---0--"+indApplicationDetails.size())  			
					//allSummaryReportReceivedListR = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportReceivedListO = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportReceivedListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='GREEN'  and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportReceivedListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='WHITE'  and abc.groupId=? and authDate>= ? and  authDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			//allSummaryReportPendingList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])     			
					//allSummaryReportPendingListR= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportPendingListO= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportPendingListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='GREEN' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportPendingListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='WHITE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			//allSummaryReportGrantedList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])			
					//allSummaryReportGrantedListR= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportGrantedListO= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportGrantedListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='GREEN' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportGrantedListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='WHITE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
        			
        			//allSummaryReportRejectedList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportRejectedListR= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='RED' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportRejectedListO= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportRejectedListG= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='GREEN' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
					//allSummaryReportRejectedListW= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where abc.indCategoryName='WHITE' and abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])

				allSummaryReportRejectedListReturned= AllSummaryReportWMS.findAll("from AllSummaryReportWMS as abc where  abc.groupId=? and authDate>= ? and  authDate<= ? and abc.applicationStatus ='returned' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
				//System.out.println("----Returned applications------"+allSummaryReportRejectedListReturned)	
			        		
              %>
                   	       
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=GroupMasterInstance%>
                   	    
                   	       </td>
                 
 
                   	       
                <td>  <% System.out.println("----ind Application Details----"+indApplicationDetails.size()+"--indApplicationDetails---"+indApplicationDetails.toString()+"----group------"+groupId) 
                def countCTEFRESH=0;
                def listOfApplicationFresh=new ArrayList()
                for(int iw=0; iw<indApplicationDetails.size();iw++){
                def appList=(ArrayList)indApplicationDetails.get(iw)
                for(int yqq=0;yqq<appList.size();yqq++){
                //System.out.println("---------appList------"+appList[yqq].certificateFor)
                if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='new' && appList[yqq].completionStatus=='completed'){
                countCTEFRESH++
                //System.out.println("-----appList--loop--------"+appList[yqq].indUser)
                listOfApplicationFresh.add(appList[yqq].indUser)
                }
                
                
                }
                
                }
                System.out.println(countCTEFRESH)
                def totalReceivedCTEFreshApp=0
                def totalApprovedCTEFresh=0
                def totalPendingCTEFresh=0
                def totalRejectedCTEFresh=0
                def totalReturnedCTEFresh=0
               def uniqueListOfReg=listOfApplicationFresh.unique()
               System.out.println("-------uniqueListOfReg---- "+uniqueListOfReg.toString())
               for(int kl=0;kl<uniqueListOfReg.size();kl++){
               System.out.println("---regmatsre-"+uniqueListOfReg[kl].id)
               def AllSummary=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfReg[kl].id.toString()])
               def AllSummaryApproved=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='approved' and abc.indRegMasterId=? ",[uniqueListOfReg[kl].id.toString()])
               def AllSummaryPending=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='pending' and abc.indRegMasterId=? ",[uniqueListOfReg[kl].id.toString()])
               def AllSummaryRejected=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='rejected' and abc.indRegMasterId=? ",[uniqueListOfReg[kl].id.toString()])
               def AllSummaryReturned=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='returned' and abc.indRegMasterId=? ",[uniqueListOfReg[kl].id.toString()])
                System.out.println("-------AllSummary---- "+AllSummary)
                if(AllSummary.size()>0){
               totalReceivedCTEFreshApp=totalReceivedCTEFreshApp+AllSummary.size()
               }
               if(AllSummaryApproved.size()>0){
               totalApprovedCTEFresh=totalApprovedCTEFresh+AllSummaryApproved.size()
               }
               
               if(AllSummaryPending.size()>0){
               totalPendingCTEFresh=totalPendingCTEFresh+AllSummaryPending.size()
               }
               if(AllSummaryRejected.size()>0){
               totalRejectedCTEFresh=totalRejectedCTEFresh+AllSummaryRejected.size()
               }
               if(AllSummaryReturned.size()>0){
               totalReturnedCTEFresh=totalReturnedCTEFresh+AllSummaryReturned.size()
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
                 <%=totalApprovedCTEFresh%>
              </a>
                 </td></tr>
                 </table>
                </td>
               
                  <td>
                  <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
               <%=totalRejectedCTEFresh%></a>
                 </td></tr> 
                 </table>
                </td>
                 	     
                 
                  <td>
                 <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
               <%=totalPendingCTEFresh%>
              </a>
                 </td></tr> 
               </table>
                </td>
                
                
                <td>
                <table cellspacing="1"  >
               <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=totalReturnedCTEFresh%>
             </a>
                </td></tr> 
              </table>
               </td>
               
               
               
               
               
               
               
               
            <td><% System.out.println("----ind Application Details----"+indApplicationDetails.size()+"--indApplicationDetails---"+indApplicationDetails.toString()+"----group------"+groupId) 
                def countCTERenew=0;
                def listOfApplicationRenew=new ArrayList()
                for(int iw=0; iw<indApplicationDetails.size();iw++){
                def appList=(ArrayList)indApplicationDetails.get(iw)
                for(int yqq=0;yqq<appList.size();yqq++){
                //System.out.println("---------appList------"+appList[yqq].certificateFor)
                if(appList[yqq].applicationType=='CTE' && appList[yqq].certificateFor=='reNew' && appList[yqq].completionStatus=='completed'){
                countCTERenew++
                System.out.println("-----appList--loop--------"+appList[yqq].indUser)
                listOfApplicationRenew.add(appList[yqq].indUser)
                }
                
                
                }
                
                }
                System.out.println(countCTERenew)
                def totalReceivedCTERenewApp=0
                def totalApprovedCTERenew=0
                def totalPendingCTERenew=0
                def totalRejectedCTERenew=0
                def totalReturnedCTERenew=0
               def uniqueListOfRegCTERenew=listOfApplicationRenew.unique()
               System.out.println("-------uniqueListOfReg---- "+uniqueListOfRegCTERenew.toString())
               for(int kll=0;kll<uniqueListOfRegCTERenew.size();kll++){
               System.out.println("---regmatsre-"+uniqueListOfRegCTERenew[kll].id)
               def AllSummaryCTErenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfRegCTERenew[kll].id.toString()])
               def AllSummaryApprovedCTErenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='approved' and abc.indRegMasterId=? ",[uniqueListOfRegCTERenew[kll].id.toString()])
               def AllSummaryPendingCTERenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='pending' and abc.indRegMasterId=? ",[uniqueListOfRegCTERenew[kll].id.toString()])
               def AllSummaryRejectedCTERenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='rejected' and abc.indRegMasterId=? ",[uniqueListOfRegCTERenew[kll].id.toString()])
               def AllSummaryReturnedCTERenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='returned' and abc.indRegMasterId=? ",[uniqueListOfRegCTERenew[kll].id.toString()])
                System.out.println("-------AllSummary---- "+AllSummary)
                if(AllSummaryCTErenew.size()>0){
               totalReceivedCTERenewApp=totalReceivedCTERenewApp+AllSummaryCTErenew.size()
               }
               if(AllSummaryApprovedCTErenew.size()>0){
               totalApprovedCTERenew=totalApprovedCTERenew+AllSummaryApprovedCTErenew.size()
               }
               
               if(AllSummaryPendingCTERenew.size()>0){
               totalPendingCTERenew=totalPendingCTERenew+AllSummaryPendingCTERenew.size()
               }
               if(AllSummaryRejectedCTERenew.size()>0){
               totalRejectedCTERenew=totalRejectedCTERenew+AllSummaryRejectedCTERenew.size()
               }
               if(AllSummaryReturnedCTERenew.size()>0){
               totalReturnedCTERenew=totalReturnedCTERenew+AllSummaryReturnedCTERenew.size()
               }
               } 
               %>
     	      <table cellspacing="1" >
      	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
         	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=totalReceivedCTERenewApp%>
           	    </a>
           	      </td></tr> 
           	      </table>
	     </td>
	       
          <td>
       <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
        <%=totalApprovedCTERenew%>
     </a>
        </td></tr>
        </table>
       </td>
      
         <td>
         <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
      <%=totalRejectedCTERenew%></a>
        </td></tr> 
        </table>
       </td>
        	     
        
         <td>
        <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
      <%=totalRejectedCTERenew%>
     </a>
        </td></tr> 
      </table>
       </td>
       
       
       <td>
       <table cellspacing="1"  >
      <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
   <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
     <%=totalReturnedCTERenew%>
    </a>
       </td></tr> 
     </table>
      </td>
      
      
      
      
      
     
      <td>
      <% System.out.println("----ind Application Details----"+indApplicationDetails.size()+"--indApplicationDetails---"+indApplicationDetails.toString()+"----group------"+groupId) 
                def countCTOFresh=0;
                def listOfApplicationCTOFresh=new ArrayList()
               for(int iiw=0; iiw<indApplicationDetails.size();iiw++){
                def appList=(ArrayList)indApplicationDetails.get(iiw)
                for(int yqqq=0;yqqq<appList.size();yqqq++){
                //System.out.println("---------appList------"+appList[yqqq].certificateFor)
                if(appList[yqqq].applicationType=='CTO' && appList[yqqq].certificateFor=='new' && appList[yqqq].completionStatus=='completed'){
                countCTOFresh++
                System.out.println("-----appList--loop--------"+appList[yqqq].indUser)
                listOfApplicationCTOFresh.add(appList[yqqq].indUser)
                }
                
                
                }
                
                }
               
               
               
               
                System.out.println(countCTOFresh)
                def totalReceivedCTOFreshApp=0
                def totalApprovedCTOFresh=0
                def totalPendingCTOFresh=0
                def totalRejectedCTOFresh=0
                def totalReturnedCTOFresh=0
              
              
 			def uniqueListOfRegCTOFresh=listOfApplicationCTOFresh.unique()
               System.out.println("-------uniqueListOfReg---- "+listOfApplicationCTOFresh.toString())
              for(int klll=0;klll<uniqueListOfRegCTOFresh.size();klll++){
               System.out.println("---regmatsre-"+uniqueListOfRegCTOFresh[klll].id)
              def AllSummaryCTOFresh=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfRegCTOFresh[klll].id.toString()])
               def AllSummaryApprovedCTOFresh=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='approved' and abc.indRegMasterId=? ",[uniqueListOfRegCTOFresh[klll].id.toString()])
               def AllSummaryPendingCTOFresh=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='pending' and abc.indRegMasterId=? ",[uniqueListOfRegCTOFresh[klll].id.toString()])
               def AllSummaryRejectedCTOFresh=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='rejected' and abc.indRegMasterId=? ",[uniqueListOfRegCTOFresh[klll].id.toString()])
               def AllSummaryReturnedCTOFresh=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='returned' and abc.indRegMasterId=? ",[uniqueListOfRegCTOFresh[klll].id.toString()])
               System.out.println("-------AllSummaryCTOFresh---- "+AllSummaryCTOFresh)
                if(AllSummaryCTOFresh.size()>0){
               totalReceivedCTOFreshApp=totalReceivedCTOFreshApp+AllSummaryCTOFresh.size()
               }
               if(AllSummaryApprovedCTOFresh.size()>0){
               totalApprovedCTOFresh=totalApprovedCTOFresh+AllSummaryApprovedCTOFresh.size()
               }
               
               if(AllSummaryPendingCTOFresh.size()>0){
               totalPendingCTOFresh=totalPendingCTOFresh+AllSummaryPendingCTOFresh.size()
               }
               if(AllSummaryRejectedCTOFresh.size()>0){
               totalRejectedCTOFresh=totalRejectedCTOFresh+AllSummaryReturnedCTOFresh.size()
               }
               if(AllSummaryReturnedCTOFresh.size()>0){
               totalReturnedCTOFresh=totalReturnedCTOFresh+AllSummaryReturnedCTOFresh.size()
               }
               } 
              
              
               %>  
      
      
	      <table cellspacing="1" >
	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
       <%=totalReceivedCTOFreshApp%>
    	    </a>
    	      </td></tr> 
    	      </table>
  </td>
 
   <td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 <%=totalApprovedCTOFresh%>
</a>
 </td></tr>
 </table>
</td>

  <td>
  <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalRejectedCTOFresh%></a>
 </td></tr> 
 </table>
</td>
 	     
 
  <td>
 <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalPendingCTOFresh%>
</a>
 </td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalReturnedCTOFresh%>
</a>
</td></tr> 
</table>
</td>
               
         










<td> 
 <% System.out.println("----ind Application Details----"+indApplicationDetails.size()+"--indApplicationDetails---"+indApplicationDetails.toString()+"----group------"+groupId) 
                def countCTORenew=0;
                def listOfApplicationCTORenew=new ArrayList()
               for(int m=0; m<indApplicationDetails.size();m++){
                def appList=(ArrayList)indApplicationDetails.get(m)
                for(int z=0;z<appList.size();z++){
                //System.out.println("---------appList------"+appList[z].certificateFor)
                if(appList[z].applicationType=='CTO' && appList[z].certificateFor=='reNew' && appList[z].completionStatus=='completed'){
                countCTORenew++
                System.out.println("-----appList--loop--------"+appList[z].indUser)
                listOfApplicationCTORenew.add(appList[z].indUser)
                }
                
                
                }
                
                }
               
               
               
               
                System.out.println(countCTORenew)
                def totalReceivedCTORenewApp=0
                def totalApprovedCTORenew=0
                def totalPendingCTORenew=0
                def totalRejectedCTORenew=0
                def totalReturnedCTORenew=0
              
              
 			def uniqueListOfRegCTORenew=listOfApplicationCTORenew.unique()
               System.out.println("-------uniqueListOfReg---- "+listOfApplicationCTOFresh.toString())
              for(int l=0;l<uniqueListOfRegCTORenew.size();l++){
               System.out.println("---regmatsre-"+uniqueListOfRegCTORenew[l].id)
              def AllSummaryCTORenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.indRegMasterId=? ",[uniqueListOfRegCTORenew[l].id.toString()])
               def AllSummaryApprovedCTORenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='approved' and abc.indRegMasterId=? ",[uniqueListOfRegCTORenew[l].id.toString()])
               def AllSummaryPendingCTORenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='pending' and abc.indRegMasterId=? ",[uniqueListOfRegCTORenew[l].id.toString()])
               def AllSummaryRejectedCTORenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='rejected' and abc.indRegMasterId=? ",[uniqueListOfRegCTORenew[l].id.toString()])
               def AllSummaryReturnedCTORenew=AllSummaryReportWMS.findAll(" from AllSummaryReportWMS abc where abc.applicationStatus='returned' and abc.indRegMasterId=? ",[uniqueListOfRegCTORenew[l].id.toString()])
               System.out.println("-------AllSummaryCTORenew---- "+AllSummaryCTORenew)
                if(AllSummaryCTORenew.size()>0){
               totalReceivedCTORenewApp=totalReceivedCTORenewApp+AllSummaryCTORenew.size()
               }
               if(AllSummaryApprovedCTORenew.size()>0){
               totalApprovedCTORenew=totalApprovedCTORenew+AllSummaryApprovedCTORenew.size()
               }
               
               if(AllSummaryPendingCTORenew.size()>0){
               totalPendingCTORenew=totalPendingCTORenew+AllSummaryPendingCTORenew.size()
               }
               if(AllSummaryRejectedCTORenew.size()>0){
               totalRejectedCTORenew=totalRejectedCTORenew+AllSummaryRejectedCTORenew.size()
               }
               if(AllSummaryReturnedCTORenew.size()>0){
               totalReturnedCTORenew=totalReturnedCTORenew+AllSummaryReturnedCTORenew.size()
               }
               } 
              
              
               %>  

 
<table cellspacing="1" >
 <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalReceivedCTORenewApp%>
  </a>
    </td></tr> 
    </table>
</td>

<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%= totalApprovedCTORenew%>
</a>
</td></tr>
</table>
</td>

<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalRejectedCTORenew%></a>
</td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalPendingCTORenew%>
</a>
</td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
<%=totalReturnedCTORenew%>
</a>
</td></tr> 
</table>
</td>












			<%

					
           			
           			appliedR=appliedR+totalReceivedCTEFreshApp;
           			appliedO=appliedO+totalApprovedCTEFresh; 
           			appliedG=appliedG+totalRejectedCTEFresh; 
           			appliedW=appliedW+totalPendingCTEFresh ;
           			appliedT=appliedT+totalReturnedCTEFresh;
           			
           			
           			issuedR=issuedR+totalReceivedCTERenewApp;
           			issuedO=issuedO+totalApprovedCTERenew; 
           			issuedG=issuedG+totalRejectedCTERenew; 
           			issuedW=issuedW+totalPendingCTERenew; 
           			issuedT=issuedT+totalReturnedCTERenew;
           			
           			
           			rejectedR=rejectedR+totalReceivedCTOFreshApp;
           			rejectedO=rejectedO+totalApprovedCTOFresh; 
           			rejectedG=rejectedG+totalRejectedCTOFresh; 
           			rejectedW=rejectedW+totalPendingCTOFresh; 
           			rejectedT=rejectedT+totalReturnedCTOFresh; 
           			
           			
           			
           			pendingR=pendingR+totalReceivedCTORenewApp;
           			pendingO=pendingO+totalApprovedCTORenew; 
           			pendingG=pendingG+totalRejectedCTORenew; 
           			pendingW=pendingW+totalPendingCTORenew; 
           			pendingT=pendingT+totalReturnedCTORenew; 
           			
           			
           			
           			
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


