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
       
			<FORM id="myForm" name="myForm" action="searchAllBMWApplication" method="post">  
	   
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
               <span style="color:red;font-size:13px;">BIO-MEDICAL application details:</span> 
               <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
         </span>
         </td>
         </tr> 
        <tr><td></td></tr>               
	  <tr>
<td  align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popListOfApplicationsReport', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue" align="right"></span></a>
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popListOfBMWApplicationsReportExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue" align="right">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		
		
         
	
<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                  
				<tr width="200%" bgcolor="#A8DAF3"  >
                   
                   	    <th align="center" rowspan="2"  style="width:15%;border-bottom:3px solid green;" class="headngblue" >Sr No</th>
                   	    <th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application No</th>
                   	    <th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Name of HCF</th> 
                   	    <th align="center" rowspan="2"	style="width:15%;border-bottom:3px solid green;" class="headngblue" >Location</th> 
                   	    <th align="center" rowspan="2"	style="width:15%;border-bottom:3px solid green;" class="headngblue" >Contacts</th> 
                   	    <th align="center" rowspan="2"	style="width:15%;border-bottom:3px solid green;" class="headngblue" >NO of beds</th>
                   	    <th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Non bed capacity</th>
                   	    <th align="center" colspan="3" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Catagory</th>  
                  		<th align="center" rowspan="2"	style="width:35%;border-bottom:3px solid green;" class="headngblue" >Applicationnnn Date</th>
                  		<th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Authorization For</th>
                  		<th align="center" rowspan="2"	style="width:15%;border-bottom:3px solid green;" class="headngblue" >Authorization Granted</th>
                  		<th align="center" rowspan="2"	style="width:15%;border-bottom:3px solid green;" class="headngblue" >Authorization Date of issue</th>
                  		<th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Authorization Valid upto</th>
                  		<th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Status</th>
                  		<th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Pending With</th>
                  		<th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Pending With</th>
                  </tr>
                  
                  <tr>
                 
                
                  <td align="center"   style="width:15%;border-bottom:3px solid green;" class="headngblue">Red</td>
                  <td align="center"   style="width:15%;border-bottom:3px solid green;" class="headngblue">Orange</td>
                  <td align="center"   style="width:15%;border-bottom:3px solid green;" class="headngblue">Green</td>
                 
                  
                  </tr>
                 
                  
                  <% 	
            	    def grandTotTC =0 
            		def grandTotPTC =0 
            		def grandTotGTC = 0
            		def grandTotRTC = 0
            		
            		def abbb=""
            		
            		
            		def appliedR = 0 
            		def appliedO =  0
            		def appliedG =  0
            		def appliedW = 0
            		def appliedT =  0
            		
            		def issuedR =  0
            		def issuedO =  0
            		def issuedG = 0
            		def issuedW =  0
            		def issuedT =  0
            		
            		def rejectedR = 0 
            		def rejectedO = 0
            		def rejectedG = 0
            		def rejectedW =  0
            		def rejectedT =  0
            		
            		def pendingR =  0
            		def pendingO = 0 
            		def pendingG = 0
            		def pendingW = 0
            		def pendingT = 0
            		
            		def redCount=0
            		def orangeCount=0
            		def greenCount=0
            		def redName=""
            		def orangeName=""
            		def greenName=""
            		
            		
            	%>
                  
                  
           <g:each in="${allSummaryReport}" status="i" var="GroupMasterInstance">
           
           <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">   

                
                    
               <%
                   	def roleArray = new ArrayList()
        		    
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
        			
        		def application
        		if(GroupMasterInstance.applicationFor=='BMW'){
        		application=BioMedicalWaste.get(GroupMasterInstance.applicationId.toLong())
        		
        		System.out.println("-------Bio Application ----"+application)
        		}

				    		
              %>
                   	       
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=++i%>
                   	    
                   	       </td>
                 
 
                   	       
                <td>  
              	      <table cellspacing="1" >
               	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
                  	    
                       <%=GroupMasterInstance.applicationId%>
                    	    </a>
                    	      </td></tr> 
                    	      </table>
         	     </td>
      	       
                   <td>
                <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
          	<%=application.industryRegMasterObj.indName%>
              </a>
                 </td></tr>
                 </table>
                </td>
               
                  <td>
                  <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
            
               <%=application.industryRegMasterObj.indAddress%>
                 </td></tr> 
                 </table>
                </td>
                 	     
                 
                  <td>
                 <table cellspacing="1"  >
                <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
            
                <%=application.industryRegMasterObj.indPhoneNo%>
              
                 </td></tr> 
               </table>
                </td>
                
                
                <td>
                <table cellspacing="1"  >
               <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
              <%=application.noofbeds%>
             
                </td></tr> 
              </table>
               </td>
               
                <td>  
     	      <table cellspacing="1" >
      	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
         	   <%=application.noOfNonBeds%>
           	    
           	      </td></tr> 
           	      </table>
	     </td>
               
               
               
               
               <%if(GroupMasterInstance.categoryName=='RED') {
               redName="RED"
               orangeName=""
               greenName=""
               redCount++
               }else if(GroupMasterInstance.categoryName=='ORANGE'){
               orangeName="ORANGE"
               redName=""
               greenName=""
               orangeCount++
               }else if(GroupMasterInstance.categoryName=='GREEN'){
               greenName="GREEN"
               redName=""
               orangeName=""
               greenCount++
               }
               %>
            <td>  
     	      <table cellspacing="1" >
      	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
         	   <%=redName%>
           	    </a>
           	      </td></tr> 
           	      </table>
	     </td>
	       
          <td>
       <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
			<%=orangeName%>
     
        </td></tr>
        </table>
       </td>
      
         <td>
         <table cellspacing="1"  >
       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
   		<%=greenName%>
        </td></tr> 
        </table>
       </td>
        	     
        
         <td>
        <table cellspacing="1"  >
       <tr width="150%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    
    	<g:formatDate format="yyyy-MM-dd" date="${GroupMasterInstance.authDate}"/>
     </td></tr> 
      </table>
       </td>
       
       
       <td>
       <table cellspacing="1"  >
      <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
   <%=GroupMasterInstance.authorizationtype%>
   </td></tr> 
     </table>
      </td>
      
      <% def certificateId
      def authCertiDate
      def validCertiDate
      if(GroupMasterInstance.applicationStatus=='approved'){
      certificateId=WasteManagementCertificates.find("from WasteManagementCertificates wc where wc.applicationId=? and applicationFor='BMW' and typeOfFile='uploaded'",[application.id])
      authCertiDate=GroupMasterInstance.dateOfIssue
      validCertiDate=GroupMasterInstance.dateOfExpaire
      }
      %>
      
      
      
     
      <td>  
	      <table cellspacing="1" >
	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}"> 
	       <%    if(GroupMasterInstance.applicationStatus=='approved' && certificateId!=null){ %>  
  	     <g:def var="fooVar" value="${certificateId.id}"/><g:def var="appForWhich" value="${GroupMasterInstance.applicationFor}"/><g:link action="viewUploadedCerti" controller="allReports" params="[appliLoc:fooVar,docName:'uploaded',docType:'doc',appliFor:appForWhich]"><span class="innerlink">&nbsp;View Certificate&nbsp;</span></g:link>
     <% }%>
    	     </td></tr> 
    	      </table>
  </td>
 
   <td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  


<g:formatDate format="dd-MM-yyyy" date="${authCertiDate}"/>
 </td></tr>
 </table>
</td>

  <td>
  <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
<g:formatDate format="dd-MM-yyyy" date="${validCertiDate}"/>

 </td></tr> 
 </table>
</td>
 	     
 
  <td>
 <table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  

<%=GroupMasterInstance.applicationStatus%>

 </td></tr> 
</table>
</td>


<td>
<table cellspacing="1"  >
<tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  

<%=GroupMasterInstance.pendingWith%>

</td></tr> 
</table>
</td>
               
         










<td>  
<table cellspacing="1" >
 <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  
<%=GroupMasterInstance.roleName%>
  
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
               
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                
                 <td><%=abbb%></td>
                <td><%=redCount%></td>
                <td><%=orangeCount%></td>
                <td><%=greenCount%></td>
                <td><%=abbb%></td>
                
                 <td><%=abbb%></td>
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                <td><%=abbb%></td>
                
                 <td><%=abbb%></td>
                <td><%=abbb%></td>
               
                
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


