<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<script>if (top != self) top.location=location</script>
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
	




         
                    <tr>        
             <!--         <td align="center" valign="top" class="headngblue">Consent Type : 
                      
                      <g:select class="txt4" from="${['CTO','CTE']}" name="conType" id="conType"  > </g:select></td>
                -->    </tr>
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
			<FORM id="myForm" name="myForm" action="consentCTODetail1" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			                       
              <!--   <tr bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">End Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr> -->
  				
  				</table>
		
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
         <tr>
         <td colspan="9" align="center" >
         <span class="headngblue">
         <span style="color:red;font-size:13px;">Status of CTO Decided</span> 
         </span>
         </td>
         </tr>                  
	  <tr>
<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popConsentCTODetail1', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print Preview</span></a> | 
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popConsentCTODetail1Exc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		
    	<div style="overflow: auto;height: 600px; width: 1000px;">

<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
		<tr width="100%" bgcolor="#CCFFCC" style="border-bottom:3px solid green;" >
                   
                   	       <th align="center" style="width:30%;border-bottom:3px solid green;" width=18% class="headngblue" >District Office</th>
                   	        <th align="center" style="width:10%;border-bottom:3px solid green;" width="26%" class="headngblue" >CTO Applications Received</th>
                   	        <th align="center" style="width:10%;border-bottom:3px solid green;" width="26%" class="headngblue" >Total CTO Applications Decided</th>
                   	        <th align="center" style="width:10%;background-color: darkseagreen;" class="headngblue" >Decided within 30 Days</th>
                   	         <th align="center" style="width:10%;background-color: darkseagreen;" class="headngblue" >Decided within 30-60 Days</th> 
                   	     <th align="center" style="width:10%;background-color: darkseagreen;" class="headngblue" >Decided within 60-90 Days</th> 
                   	      <th align="center" style="width:10%;background-color: darkseagreen;" class="headngblue" >Decided within 90-120 Days</th> 
                   	       <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue" >Total Within 120 days</th> 
                   	        <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue" >Decided after 120 Days</th> 
                   	      
                   	    
                   	        
                   	     
                  </tr>
                  
                  
                  
                  	<% 	
                  	long  diff = 0
                  	int diffDays = 0
                  	 def pendDetails
                  	
                
                   def pendingLists = new ArrayList()
              def  pendingDetails1 
              def applicationProcessingDetailsInstance
                   def pendingLists1 = new ArrayList()
                  	
                  def totalCount=0
                  def totalCountDecided=0
                  def gt2 = 0  	
                  def gt3 = 0
                  def gt4 = 0
                  def gt5 = 0
                  def gt6 = 0
                  def gt7 = 0
                  
                  
                  	%>
    <g:each in="${groupList}" status="i" var="groupMasterInstance">
              <tr width="100%" bgcolor="#CCFFCC">

                
                    
                   	       <%
                   	      def groupId = (groupMasterInstance.id).toString()
        			      %>
                   	       
                   	       <td align="center">
                   	       <%=groupMasterInstance%>
                   	       </td>
                   	
                  
                
                 <td  >
                   	     
                   	  <%  
                   	      def ctorecievedCount = 0
                	      def ctorecieved = AllSummaryReport.findAll("from AllSummaryReport abc where abc.groupId =? and abc.applicationType ='CTO'",[groupId])
                   	      ctorecievedCount =  ctorecieved.size() 
                   	      totalCount+=ctorecievedCount;
        			  
        			 %>  
                   	      
                       <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days1=-1&a=z', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">              	      
                      <font size="2%"><%=ctorecievedCount%></font>
                   	    </a>   
                   	    
                </td>
                
                 <td  >
                   	     
                   	  <%  
                   	      def ctoDecidedCount = 0
                	      def ctoDecided = AllSummaryReport.findAll("from AllSummaryReport abc where abc.groupId =? and abc.applicationType ='CTO' and applicationStatus!='pending'",[groupId])
                   	      ctoDecidedCount =  ctoDecided.size() 
                   	      totalCountDecided+=ctoDecidedCount;
        			  
        			 %>  
                   	      
                       <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days1=-1&a=d', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">              	      
                      <font size="2%"><%=ctoDecidedCount%></font>
                   	    </a>   
                   	    
                </td>
                   	     
                 
                
                   
                   <td style="width:10%;background-color: darkseagreen;">
       <%  
        
        def gt1 = 0
        def total2 = 0
        def  total1 = 0
        ArrayList a =  new ArrayList()
        def diffArray11 = new ArrayList()
        def ctorecieved11 = AllSummaryReport.findAll("from AllSummaryReport where groupId =? and applicationType ='CTO' and applicationStatus!='pending'",[groupId])   
        
        for(int ip =0; ip<ctorecieved11.size(); ip++)
        {
         def appRecieveDate=ctorecieved11.get(ip).applicationRecieptDate
         if(appRecieveDate)
          	{
                 Date today = new Date();
        	     diff = today.getTime() - appRecieveDate.getTime();
    			 diffDays=diff / (1000*60*60*24) +1
    			 if(diffDays<=30)
    			 {
    				diffArray11.add(diffDays)
    			 }
    		}
         }
         %>
                       <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days=30&days1=-1&a=a', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                    <font size="2%"><%=diffArray11.size()%></font></a>
<%
	total1 = diffArray11.size()	
    total2 = 	total2 + total1				
    gt1 =  total2
    gt2 =  gt1 + gt2		
%>
               </td>
               
               <td style="width:10%;background-color: darkseagreen;">
               <%   
                def total22 = 0
                def  total11 = 0
                def diffArray12 = new ArrayList()
                def ctorecieved12 = AllSummaryReport.findAll("from AllSummaryReport where groupId =? and applicationType ='CTO' and applicationStatus!='pending'",[groupId])
                for(int ip =0; ip<ctorecieved12.size(); ip++)
                {
                    def appRecieveDate=ctorecieved12.get(ip).applicationRecieptDate
                    if(appRecieveDate)
                  	{
                        Date today = new Date();
                 		diff = today.getTime() - appRecieveDate.getTime();
    					diffDays = diff / (1000*60*60*24) +1
    					if(diffDays <=60  && diffDays> 30)
    					{
    					   diffArray12.add(diffDays)
    					}
    				}
                 }
        		%>
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days=60&days1=30&a=b', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                    <font size="2%"><%=diffArray12.size()%></font></a>
<% 
total11 = diffArray12.size()	
total22 = 	total22 +		total11		
gt3 =  total22 + gt3
%>
</td>

         <td style="width:10%;background-color: darkseagreen;">
          <%   
             def total23 = 0
             def  total13 = 0
             def diffArray13 = new ArrayList()
             def ctorecieved13 = AllSummaryReport.findAll("from AllSummaryReport where groupId =? and applicationType ='CTO' and applicationStatus!='pending'",[groupId])   
             for(int ip =0; ip<ctorecieved13.size(); ip++)
             {
            	 def appRecieveDate=ctorecieved13.get(ip).applicationRecieptDate
                 if(appRecieveDate)
                  	{
                        Date today = new Date();
               			diff = today.getTime() - appRecieveDate.getTime();
    					diffDays=diff / (1000*60*60*24) +1
    					if(diffDays <= 90 && diffDays > 60 )
    		    		{
    						diffArray13.add(diffDays)
    					}
    			    }
             }
           %>
                    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days=90&days1=60&a=c', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                    <font size="2%"><%=diffArray13.size()%></font></a>
            
           
<% 
total13 = diffArray13.size()	
total23 = 	total23 +		total13		
gt4 =  total23 + gt4
%>
                </td>
               
                <td style="width:10%;background-color: darkseagreen;">
                 <%   
                      def total24 = 0
                      def  total14 = 0
                      def diffArray14 = new ArrayList()
                      def ctorecieved14 = AllSummaryReport.findAll("from AllSummaryReport where groupId =? and applicationType ='CTO' and applicationStatus!='pending'",[groupId])   
                      for(int ip =0; ip<ctorecieved14.size(); ip++)
                      {
                    	  def appRecieveDate=ctorecieved14.get(ip).applicationRecieptDate
                          if(appRecieveDate)
                  	        {
                                 Date today = new Date();
                 			     diff = today.getTime() - appRecieveDate.getTime();
    							 diffDays=diff / (1000*60*60*24) +1
    							 if(diffDays<= 120 && diffDays>90)
    							 {
    								diffArray14.add(diffDays)
    							 }
    				         }
        			  }
        		 %>
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days=120&days1=90&a=d', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                    <font size="2%"><%=diffArray14.size()%></font></a>
<%
total14 = diffArray14.size()	
total24 = 	total24 +		total14	
gt5 =  total24 + gt5
 %>
</td>
                
                <td >
                 <%   
                     def total25 = 0
                     def  total15 = 0
                     def diffArray15 = new ArrayList()
                     def ctorecieved15 = AllSummaryReport.findAll("from AllSummaryReport where groupId =? and applicationType ='CTO' and applicationStatus!='pending'",[groupId])   
                     for(int ip =0; ip<ctorecieved15.size(); ip++)
                     {
                    	 def appRecieveDate=ctorecieved15.get(ip).applicationRecieptDate
                         if(appRecieveDate)
  		                 {
                             Date today = new Date();
                 			 diff = today.getTime() - appRecieveDate.getTime();
    						 diffDays=diff / (1000*60*60*24) +1
    						 if(diffDays<= 120)
    						 {
    								diffArray15.add(diffDays)
    						 }
    				      }
        			  }
        		  %>
                        <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days=120&days1=-1&a=e', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                    <font size="2%"><%=diffArray15.size()%></font></a>
<%
total15 = diffArray15.size()	
total25 = 	total25 +		total15	
gt6 =  total25 + gt6
 %>
</td>
                
                
                <td>
                 <%   
                 def total26 = 0
                 def  total16 = 0
                 def diffArray16 = new ArrayList()
              	 def ctorecieved16 = AllSummaryReport.findAll("from AllSummaryReport where groupId =? and applicationType ='CTO' and applicationStatus!='pending'",[groupId])   
                 for(int ip =0; ip<ctorecieved16.size(); ip++)
                 {
                	def appRecieveDate=ctorecieved16.get(ip).applicationRecieptDate
                    if(appRecieveDate)
                  	{
                        Date today = new Date();
               			diff = today.getTime() - appRecieveDate.getTime();
    					diffDays=diff / (1000*60*60*24) +1
    					if(diffDays> 120)
    					{
    						diffArray16.add(diffDays)
    					}
       			    }
        	     }
        		%>
                 <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForCTOTotal?id=${groupId}&days1=121&a=f', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                    <font size="2%"><%=diffArray16.size()%></font></a>
<%
total16 = diffArray16.size()	
total26 = 	total26 +		total16	
gt7 =  total26 + gt7
%>
                </td>
                
                
                
               </g:each>	  
              </tr>
            <tr bgcolor="#CCFFCC">
              <td><font color="RED">Grand Total:</font></td>
              <td><font color="purple"><%=totalCount%></font></td>
               <td><font color="purple"><%=totalCountDecided%></font></td>
                <td style="width:10%;background-color: darkseagreen;"><font color="purple"><%=gt2%></font></td>
                 <td style="width:10%;background-color: darkseagreen;"><font color="purple"><%=gt3%></font></td>
                   <td style="width:10%;background-color: darkseagreen;"><font color="purple"><%=gt4%></font></td>
                    <td style="width:10%;background-color: darkseagreen;"><font color="purple"><%=gt5%></font></td>
                    <td><font color="purple"><%=gt6%></font></td>
                    <td><font color="purple"><%=gt7%></font></td>
              </tr>
                </table>
            <br />
            <br />
          </div> 
		  
		  </form>
		  
	 
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
</html>