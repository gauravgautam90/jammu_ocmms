<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.*" %>
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
       
			<FORM id="myForm" name="myForm" action="conReport1Office" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			                       
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
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
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
         <span style="color:red;font-size:13px;">Consent wise CTE/CTO status of applied Industries: Office wise</span> 
         <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
         </span>
         </td>
         </tr>                  
	  <tr>
<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popNewPageReportOffice', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print Preview</span></a> | 
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popNewPageReportOfficeExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		
		
         
	<div style="overflow: auto;height: 600px; width: 1000px;">

<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                 <tr width="100%" bgcolor="#A8DAF3">
                			<td align="center" class="headngblue" ></td>
                   	        <td align="center"  colspan="4" ><font color="green" >CTE</font></td>
                   	        <td align="center"  colspan="4" ><font color="green">CTO</font></td>
                 </tr>
                  
		<tr width="200%" bgcolor="#A8DAF3"  >
                   
                   	       <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue" >District Office</th>
                   	         <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Received</th>
                   	     <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Issued</th> 
                   	      <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
                   	         <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Pending</th> 
                   	                        	      
                   	         <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Received</th>
                   	         <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Issued</th> 
                   	     <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
                   	      <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Pending</th> 
                   	      
          </tr>
                  
                  	<% 	def grandTotCTE = 0 
                  		def grandTotPCTE = 0
                  		def grandTotGCTE = 0
                  		def grandTotRCTE = 0
                  		
                  		def grandTotCTO = 0 
                  		def grandTotPCTO = 0
                  		def grandTotGCTO = 0
                  		def grandTotRCTO = 0
                  	
                  	%>
    <g:each in="${groupList}" status="i" var="groupMasterInstance">
              <tr width="100%" bgcolor="#A8DAF3">
       	       <%
                   	     	
       	     	def roleArray = new ArrayList()
        		def pArray = new ArrayList()
        		def pendingList = new ArrayList()
        	  def grantList = new ArrayList()
        	   def totalList = new ArrayList()
        		def groupId = (groupMasterInstance.id).toString()
        		def rejectedList = new ArrayList()
        			def totCtoList = new ArrayList()
        			def pendingCtoList = new ArrayList()
        			def grantedCtoList = new ArrayList()
        			def rejectedCtoList = new ArrayList()
        			        			
        		def  roles = new ArrayList()
        		 %>
                   	       
                   	       
                <td align="left" >
                    <%=groupMasterInstance%>
                </td>
                   	
                <td>
                 <%   
                totalList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and abc.groupId=?",[sqlDate,sqlDate2,groupId])
        		grandTotCTE = grandTotCTE + totalList.size()
        		 %>
                <%if(totalList.size()==0){%>
                <%=totalList.size()%>
                <%}else if(totalList.size()>=5){ %>			 
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=received&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=totalList.size()%></font>
				</a>
                <%}else{ %>
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=received&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=totalList.size()%>
                </a>
                <%}%>
                </td>
                 	     
                 
               <td>
               <% 
                grantList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and abc.applicationStatus='approved' and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
     			grandTotGCTE = grandTotGCTE + grantList.size()
        	   %>
               <%if(grantList.size()==0){%>
                <%=grantList.size()%>
                <%}else if(grantList.size()>=5){ %>			 
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=issued&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=grantList.size()%></font>
 				</a>
                <%}else{ %>
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=issued&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=grantList.size()%>
                </a>
                <%}%> 
                </td>
               
                 <td>
                 <%  
        			rejectedList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?   and abc.applicationStatus='rejected' and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
            		grandTotRCTE = grandTotRCTE + rejectedList.size()
       			 %>
               <%if(rejectedList.size()==0){%>
               <%=rejectedList.size()%>
               <%}else if(rejectedList.size()>=5){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=rejected&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=rejectedList.size()%></font>
				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=rejected&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=rejectedList.size()%>
               </a>
               <%}%>
               </td>
               
               
               <td>
                <% 
     			pendingList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.applicationStatus='pending' and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
     			grandTotPCTE = grandTotPCTE + pendingList.size()
        		%>
               <%if(pendingList.size()==0){%>
               <%=pendingList.size()%>
               <%}else if(pendingList.size()>=5){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=pending&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=pendingList.size()%></font>
				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTE&status=pending&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=pendingList.size()%>
               </a>
               <%}%> 
               </td>
                               
                
                 <td>
                   <%
        			totCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
            		grandTotCTO = grandTotCTO + totCtoList.size()
        		   %>
              <%if(totCtoList.size()==0){%>
              <%=totCtoList.size()%>
              <%}else if(totCtoList.size()>=5){ %>			 
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=received&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=totCtoList.size()%></font>
				</a>
              <%}else{ %>
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=received&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=totCtoList.size()%>
              </a>
              <%}%>
              </td>
                 
               
              <td>
                 <%
                 grantedCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationStatus='approved'  and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
        		 grandTotGCTO = grandTotGCTO + grantedCtoList.size()
       			 %>
              <%if(grantedCtoList.size()==0){%>
              <%=grantedCtoList.size()%>
              <%}else if(grantedCtoList.size()>=5){ %>			 
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=issued&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=grantedCtoList.size()%></font>
				</a>
              <%}else{ %>
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=issued&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=grantedCtoList.size()%>
              </a>
              <%}%> 
              </td>
                
               
              <td>
                 <%
                 rejectedCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and  abc.applicationStatus='rejected'  and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
       			 grandTotRCTO = grandTotRCTO + rejectedCtoList.size()
       			 %>
               <%if(rejectedCtoList.size()==0){%>
               <%=rejectedCtoList.size()%>
               <%}else if(rejectedCtoList.size()>=5){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=rejected&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=rejectedCtoList.size()%></font>
 				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=rejected&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=rejectedCtoList.size()%>
               </a>
               <%}%>
                </td>
                
                
                 <td>
                <%
         			pendingCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.applicationStatus='pending'  and  abc.groupId=?",[sqlDate,sqlDate2,groupId])
        			grandTotPCTO = grandTotPCTO + pendingCtoList.size()
       			 %>
               <%if(pendingCtoList.size()==0){%>
               <%=pendingCtoList.size()%>
               <%}else if(pendingCtoList.size()>=5){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=pending&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=pendingCtoList.size()%></font>
 				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotOffice?id=${groupId}&applicationType=CTO&status=pending&date=${sqlDate}&date1=${sqlDate3}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=pendingCtoList.size()%>
               </a>
               <%}%>
               </td>
               
                
                </tr>
                </g:each>	  
              
              <tr>
              <td><font color="RED">Grand Total:</font></td>
                <td><font color="purple"><%=grandTotCTE%></font></td>
                 <td><font color="purple"><%=grandTotGCTE%></font></td>
                    <td><font color="purple"><%=grandTotRCTE%></font></td>
                     <td><font color="purple"><%=grandTotPCTE%></font></td>
                    
                    
                      <td><font color="purple"><%=grandTotCTO%></font></td>
                    <td><font color="purple"><%=grandTotGCTO%></font></td>
                    <td><font color="purple"><%=grandTotRCTO%></font></td>
                    <td><font color="purple"><%=grandTotPCTO%></font></td>
                    
              </tr>
                
                
                
                </table>
		

		
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
	  <% session.endDate1=null
       	  session.startDate1=null
       %>
		  
          </div>
	  
	  
	  <script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script> 
	
	
	<script language="JavaScript" type="text/javascript">
 

 
 
 var frmvalidator  = new Validator("myForm");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    
    
     function check()
 {	
 
 
    var frm = document.getElementById('consentType').value;
    
       var frm1 = document.getElementById('status').value;
   
   if(frm1=='NotSelected'){
        alert("Please Select Application Type");
  	 	return false;
  	}
  	
    if(frm=='NotSelected'){
        alert("Please Select Consent Type");
  	 	return false;
  	}
  	 
   
    return true;
	
  }

frmvalidator.setAddnlValidationFunction("check");


</script>
	
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
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


