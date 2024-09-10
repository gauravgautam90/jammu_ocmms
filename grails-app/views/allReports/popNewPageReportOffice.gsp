<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.*" %>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">
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
<!--
<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
			 }
</g:javascript>
-->

<script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
	}
</script>


<% 
	String cont2=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont2+"/index.gsp")	;	
	 } %>



</head>

<body>		
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

</body>
</html>

