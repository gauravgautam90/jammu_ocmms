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

<script type="text/javascript">

function setMaximumSelected(amount,element) {
	var itemsSelected = [];
	for (var i=0;i<element.options.length;i++) {
		if (element.options[i].selected) itemsSelected[itemsSelected.length]=i;
	}
	if (itemsSelected.length>5) {
		itemsSelected = element.getAttribute("itemsSelected").split(",");
		for (i=0;i<element.options.length;i++) {
			element.options[i].selected = false;
		}
		for (i=0;i<itemsSelected.length;i++) {
			element.options[itemsSelected[i]].selected = true;
		}			
	} else {
		element.setAttribute("itemsSelected",itemsSelected.toString());	
	}
}
</script>

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
    
       
			<FORM id="myForm" name="myForm" action="searchMonitoringDetails" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		
        <tr bgcolor="#E8F6F9" class="tblbdr">
        <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
  <td width="33%" align="left" >


	<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
</td>



        <td  width="15%" align="left"  class="headngblue">End Date:*</td>
  <td align="left" width="37%"  >

		
		<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
		
</td>
</tr>
		
        <tr bgcolor="#E8F6F9" >
        <td  align="left"  class="headngblue">District Office:</td>
           <td align="left" colspan="3">
          <%
          	def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
def groupListChoose = new ArrayList()
for(int i = 0 ; i < newGroupList.size(); i++ ){
if(!(newGroupList[i].groupName=="HO CONSENT")){
	groupListChoose.add(newGroupList[i])
}
}
          
          
          %>
          
          <g:select 
			from="${groupListChoose.groupName}" onchange="setMaximumSelected(3,this)" multiple="multiple"  name="groupName" size="9" id="groupName"
			class="txt4"></g:select>
			 
           </td>
           
		</tr>
		<tr bgcolor="#E8F6F9" >
		<td colspan="4" align="left" class="headngblue" style="color:red;font-size:12px;"><span >Note : </span>For choosing Multiple District Office (Maximum 5) <b>press ctrl key<b></td>
       </tr>
		
       </table>
		
		 <table width="95%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
		  </tr>
 
		</table>
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
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
         <span style="color:red;font-size:13px;">Authorization BMW cases for Red, Orange and  Green  status (Applied /Issued/Rejected)  of applied industries office</span> 
         <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
         </span>
         </td>
         </tr>                  
	  <tr>
<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popNewPageReport', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print Preview</span></a> | 
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popNewPageReportExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		
		
         
	<div style="overflow: auto;height: 600px; width: 1000px;">

<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

 <tr width="100%" bgcolor="#A8DAF3">

                 			 <td align="center" class="headngblue" ></td>
                   	     	<td align="center"  colspan="3" style="width:2%;"><font color="green" >Applied</font></td>
                   	        <td align="center"  colspan="3" ><font color="green">Issued</font></td>
                   	      	<td align="center"  colspan="3" ><font color="green">Rejected</font></td>
                   	      	<td align="center"  colspan="3" ><font color="green">Balance to be issued</font></td>
                   	      	<td align="center" class="headngblue" ></td>
                   	      	
                  </tr>
                  
		           <tr width="100%" bgcolor="#A8DAF3"  >
                   	       <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >District Office</th>
                   	        
                   	        <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Red</th>
                   	        <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Orange</th> 
                   	        <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Green</th> 
                   	        <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Red</th>
                   	        <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Orange</th>
                   	        <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Green</th> 
                   	     	<th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Red</th> 
                   	     	<th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Orange</th>
                   	     	<th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Green</th>
                   	     <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Red</th> 
                   	     	<th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Orange</th>
                   	     	<th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Green</th>
                   	     <th align="center" style="width:1%;border-bottom:3px solid green;" class="headngblue" >Return Application</th>
                   </tr>
                  
                  	<% 	def grandTotCTE = 0 
                  		def grandTotPCTE = 0
                  		def grandTotGCTE = 0
                  		def grandTotRCTE = 0
                  		
                  		def grandTotCTO = 0 
                  		def grandTotPCTO = 0
                  		def grandTotGCTO = 0
                  		def grandTotRCTO = 0
                  		def grandTotPCTO1 = 0
                  		def grandTotGCTO1 = 0
                  		def grandTotRCTO1 = 0
                  		
                  	%>
    <g:each in="${groupList}" status="i" var="GroupMasterInstance">
              <tr width="100%" bgcolor="#A8DAF3">

                
                    
                   	       <%
                   	     	
                def pendingList = new ArrayList()
        	  def grantList = new ArrayList()
        	   def totalList = new ArrayList()
        		def groupId = GroupMasterInstance.id
        		def rejectedList = new ArrayList()
        			def totCtoList = new ArrayList()
        			def pendingCtoList = new ArrayList()
        			def grantedCtoList = new ArrayList()
        			def rejectedCtoList = new ArrayList()
        			
        			
        		def  roles = new ArrayList()
        		
        			 
        				def  roles1 = RoleMaster.findAll("from RoleMaster  as abc where abc.group.id=? ORDER BY version desc",[groupId])
        	for(int iy=0;iy<roles1.size();iy++){
        		def employeeN1 = RoleProfileAssignment.find("from RoleProfileAssignment as abc where abc.role = ? ",[roles1[iy]])
        			if(employeeN1){
        	if(employeeN1.primaryEmployee.status=="active"){
        	roles.add(roles1[iy])
        	
        	}
        	
        	}
        		}	 
        	
        			 
        			
        		
        		
        		
        		
        		
        		
                   	       
                   	       
                   	       %>
                   	       
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=GroupMasterInstance%>
                   	    
                   	       </td>
                   	
                  
                  
                  
                    
         
                 
                
                 <td  nowrap>
                   	     
                   	    
                   	      <table cellspacing="1" >
                   	      
                   	       
                   	       <%   for(int iei=0;iei<roles.size();iei++){
        			def var11 = roles[iei].roleName
        			def employeeFName =""
        			def employeeLName=""
        			
        			def employeeN = RoleProfileAssignment.find("from RoleProfileAssignment as abc where abc.role = ? ",[roles[iei]])
        			if(employeeN){
        			 employeeFName = employeeN.primaryEmployee.employeeFirstName
        			 employeeLName = employeeN.primaryEmployee.employeeLastName
        			}
        			 if(var11=="Senior Environmental Engineer I"){
        			 var11 = "SEE-I"
        			 
        			 }
        			 if(var11=="Senior Environmental Engineer II"){
        			 var11 = "SEE-II"
        			 
        			 }
        			 
        			 %>  
                   	      <tr  ><td nowrap>
                   	  <%=var11%> <font color="brown">(<%=employeeFName%>  <%=employeeLName%>)</font>
                   	      </td></tr> 
                   	      
                   	      <%}%> 
                   	      
                   	      <tr  ><td>
                   <font color="red"> Total</font>
                   	      </td></tr> 
                   	      
                   	      </table>
                   	        
                   	  
                   	     </td>
                   	     
                 
                
               
                  
                  
                   
                   <td>
                  
                 
                  
                  
                  
                <table cellspacing="1"  >
                <%   
                def  total1 = 0
                for(int ieei=0;ieei<roles.size();ieei++){
        		totalList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and abc.roleId=?",[sqlDate,sqlDate2,(roles[ieei].id).toString()])
     			total1=total1+totalList.size()
        		grandTotCTE = grandTotCTE + totalList.size()
     			%>
                <tr ><td>
                <%if(totalList.size()==0){%>
                <%=totalList.size()%>
                <%}else if(totalList.size()==0){ %>			 
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[ieei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=received', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=totalList.size()%></font>
				</a>
                <%}else{ %>
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[ieei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=received', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=totalList.size()%>
                </a>
                <%}%>
   
   </td></tr> 
                 
                  <%}%> 
                 <tr><td>
               
               
                 <%=total1%>
                 
                 </td></tr>
                 </table>
               
               
               
                </td>
               
                                 	     
                 
                  <td>
                  
                 <table cellspacing="1"  >
                  
                   <% 
                   def tot3 = 0
                     for(int iiei=0;iiei<roles.size();iiei++){
        			
     			grantList = AllSummaryReport.findAll("from AllSummaryReport abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and abc.applicationStatus='approved' and  abc.roleId=?",[sqlDate,sqlDate2,(roles[iiei].id).toString()])
     			tot3 = tot3 + grantList.size()
        				grandTotGCTE = grandTotGCTE + grantList.size()
        			
        			 %>
                  
                <tr ><td>
                <%if(grantList.size()==0){%>
                <%=grantList.size()%>
                <%}else if(grantList.size()==0){ %>			 
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[iiei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=approved', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=grantList.size()%></font>
 				</a>
                <%}else{ %>
                <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[iiei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=approved', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=grantList.size()%>
                </a>
                <%}%>
                </td></tr> 
                <%}%> 
                <tr><td><%=tot3%></td></tr>
               </table>
               
                </td>
               
                 <td>
                  
                  <table cellspacing="1" >
                  
                   <%  
                   def tot4 = 0
                    for(int ei=0;ei<roles.size();ei++){
        			
        		rejectedList = AllSummaryReport.findAll("from AllSummaryReport abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?   and abc.applicationStatus='rejected' and  abc.roleId=?",[sqlDate,sqlDate2,(roles[ei].id).toString()])
     			tot4 = tot4 + rejectedList.size()
        		grandTotRCTE = grandTotRCTE + rejectedList.size()
        			 %>
                  
               <tr ><td>
               <%if(rejectedList.size()==0){%>
               <%=rejectedList.size()%>
               <%}else if(rejectedList.size()==0){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[ei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=rejected', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=rejectedList.size()%></font>
				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[ei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=rejected', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=rejectedList.size()%>
               </a>
               <%}%>
               </td></tr> 
                <%}%> 
                <tr><td><%=tot4%></td></tr>
               </table>
                </td>
                
                 <td>
                  
                  <table cellspacing="1"  >
                  
                   <% 
                   def total2 = 0
                     for(int iiiei=0;iiiei<roles.size();iiiei++){
        			
        			
     			pendingList = AllSummaryReport.findAll("from AllSummaryReport abc where abc.applicationType='CTE' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and abc.applicationStatus='pending' and  abc.roleId=?",[sqlDate,sqlDate2,(roles[iiiei].id).toString()])
     			total2=total2+pendingList.size()
        		
        		grandTotPCTE = grandTotPCTE + pendingList.size()
        			 %>
                  
               <tr ><td>
               <%if(pendingList.size()==0){%>
               <%=pendingList.size()%>
               <%}else if(pendingList.size()==0){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[iiiei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=pendingList.size()%></font>
				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[iiiei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTE&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=pendingList.size()%>
               </a>
               <%}%>
               </td></tr> 
                <%}%> 
                  <tr><td><%=total2%></td></tr>
               </table>
                </td>
                
                
                 <td>
                  
                   <table cellspacing="1" >
                  
                   <%  def tot5 = 0 
                   
                    for(int eei=0;eei<roles.size();eei++){
        			
     			totCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.roleId=?",[sqlDate,sqlDate2,(roles[eei].id).toString()])
     			tot5 = tot5 + totCtoList.size()
        		grandTotCTO = grandTotCTO + totCtoList.size()
        		
        			
        			 %>
                  
              <tr ><td>
              <%if(totCtoList.size()==0){%>
              <%=totCtoList.size()%>
              <%}else if(totCtoList.size()==0){ %>			 
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[eei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=received', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=totCtoList.size()%></font>
				</a>
              <%}else{ %>
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[eei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=received', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=totCtoList.size()%>
              </a>
              <%}%>
              </td></tr> 
                <%}%> 
                <tr><td><%=tot5%></td></tr>
               </table>
                </td>
                 
                
                   
               
                 <td>
                    <table cellspacing="1"  >
                  
                   <%   def tot7 = 0
                   for(int rei=0;rei<roles.size();rei++){
        			
     			grantedCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationStatus='approved'  and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.roleId=?",[sqlDate,sqlDate2,(roles[rei].id).toString()])
     			tot7 = tot7 + grantedCtoList.size()
        			grandTotGCTO = grandTotGCTO + grantedCtoList.size()
        	
        			 %>
                  
              <tr ><td>
              <%if(grantedCtoList.size()==0){%>
              <%=grantedCtoList.size()%>
              <%}else if(grantedCtoList.size()==0){ %>			 
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[rei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=approved', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <font color="red"><%=grantedCtoList.size()%></font>
				</a>
              <%}else{ %>
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[rei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=approved', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
				   <%=grantedCtoList.size()%>
              </a>
              <%}%>
              </td></tr>
                <%}%> 
                <tr><td><%=tot7%></td></tr>
                </table>
                </td>
                
               
                 <td>
                   <table cellspacing="1"  >
                  
                   <% 
                   def tot8 = 0
                     for(int rrei=0;rrei<roles.size();rrei++){
        			
     			rejectedCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and  abc.applicationStatus='rejected'  and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.roleId=?",[sqlDate,sqlDate2,(roles[rrei].id).toString()])
     			tot8 = tot8 + rejectedCtoList.size()
        			        			grandTotRCTO = grandTotRCTO + rejectedCtoList.size()
        			
        			 %>
                  
               <tr ><td>
               <%if(rejectedCtoList.size()==0){%>
               <%=rejectedCtoList.size()%>
               <%}else if(rejectedCtoList.size()==0){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[rrei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=rejected', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=rejectedCtoList.size()%></font>
 				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[rrei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=rejected', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=rejectedCtoList.size()%>
               </a>
               <%}%>
               </td></tr>
                <%}%> 
                <tr><td><%=tot8%></td></tr>
                </table>
                </td>
                
                <td>
                   <table cellspacing="1"  >
                  
                   <%  
                   def tot6 = 0
                    for(int eeei=0;eeei<roles.size();eeei++){
        		pendingCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.applicationStatus='pending'  and  abc.roleId=?",[sqlDate,sqlDate2,(roles[eeei].id).toString()])
     			
        			tot6 = tot6 + pendingCtoList.size()
        			grandTotPCTO = grandTotPCTO + pendingCtoList.size()
        	
        		
        			 %>
                  
               <tr ><td>
               <%if(pendingCtoList.size()==0){%>
               <%=pendingCtoList.size()%>
               <%}else if(pendingCtoList.size()==0){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[eeei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=pendingCtoList.size()%></font>
 				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[eeei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=pendingCtoList.size()%>
               </a>
               <%}%>
               </td></tr> 
                <%}%> 
                <tr><td><%=tot6%></td></tr>
                
               </table>
                </td>
              
  <td>
                   <table cellspacing="1"  >
                  
                   <%  
                   def tot63 = 0
                    for(int eeei=0;eeei<roles.size();eeei++){
        		pendingCtoList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ?  and  abc.applicationStatus='pending'  and  abc.roleId=?",[sqlDate,sqlDate2,(roles[eeei].id).toString()])
     			
        			tot63 = tot63 + pendingCtoList.size()
        			grandTotPCTO = grandTotPCTO + pendingCtoList.size()
        	
        		
        			 %>
                  
               <tr ><td>
               <%if(pendingCtoList.size()==0){%>
               <%=pendingCtoList.size()%>
               <%}else if(pendingCtoList.size()==0){ %>			 
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[eeei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <font color="red"><%=pendingCtoList.size()%></font>
 				</a>
               <%}else{ %>
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTot?id=${roles[eeei].id}&date=${sqlDate}&date1=${sqlDate3}&applicationType=CTO&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
 				   <%=pendingCtoList.size()%>
               </a>
               <%}%>
               </td></tr> 
                <%}%> 
                <tr><td><%=tot63%></td></tr>
                
               </table>
                </td>
                
                </g:each>	  
              </tr>
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
                 
                       <td><font color="purple"><%=grandTotCTO%></font></td>
                   <td><font color="purple"><%=grandTotGCTO%></font></td>
                    <td><font color="purple"><%=grandTotRCTO%></font></td>
                    <td><font color="purple"><%=grandTotPCTO%></font></td>
                    <td><font color="purple"><%=grandTotPCTO%></font></td>
              </tr>
                
                </table>
		

		
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
	  
		  
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


