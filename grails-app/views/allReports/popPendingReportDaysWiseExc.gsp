<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=popPendingReportExc.xls");
%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
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

<body>
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
         
         <table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr" >
         <tr bgcolor="#E8F6F9">
         <td colspan="9" align="center" >
         <span class="headngblue">
         <span style="color:red;font-size:13px;">Status of consent applications pending with Officer more than ${noOfDays} days:Officer wise as on <br> ${(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date()))} </span> 
         </span>
         </td>
         </tr> 
         </table>
		<br>
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
                          
	  <tr>
	     <g:if test="${groupMasterInstance}">
	     <td colspan="9" align="left"><span class="headngblue">District Office: ${groupMasterInstance?.groupName}</span></td>
	     </g:if>
<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popPendingReportDaysWiseExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		

	  
<div style="overflow: auto;height: 600px; width: 1000px;">

	    
<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
		    <tr width="100%" bgcolor="#CCFFCC"  >
                 <th align="center" rowspan="2" width=18% class="headngblue" >District Office</th>
                 <th align="center" rowspan="2" width="26%" class="headngblue" >Name Of Officer</th>
                 <th align="center" class="headngblue" >CTE</th>
                 <th align="center" class="headngblue" >CTO</th> 
                 <th align="center" rowspan="2" class="headngblue" >Total</th>
           </tr>      
           <tr width="100%" bgcolor="#CCFFCC"  >      
                 <th align="center" class="headngblue" >Pending with Officer more than ${noOfDays} days</th> 
                 <th align="center" class="headngblue" >Pending with Officer more than ${noOfDays} days</th> 
            </tr>
                  
                  
                  
                 <% 	
                  long  diff = 0
                  int diffDays = 0
                  int sumPending=0
                  
                  def gt2 = 0  	
                  def gt3 = 0
                  def gt39 = 0
                  def gt4 = 0
                  def gt5 = 0
                  
                  if(groupMasterInstance)
                  {
                %>
                  	
         
            
             <tr width="100%""> 
              

                
                    
                   	       <%
                   	     	
                   	     	
        		def groupId = groupMasterInstance.id
        		def  roles = new ArrayList()
                def  rolesOfficerName=new ArrayList()  	       
        		
        			 	
        				def  roles1 = RoleMaster.findAll("from RoleMaster  as abc where abc.group.id=? ORDER BY version desc",[groupId])
        	for(int iy=0;iy<roles1.size();iy++){
        	
        		def employeeN1 = RoleProfileAssignment.find("from RoleProfileAssignment as abc where abc.role = ? ",[roles1[iy]])
        			
        			if(employeeN1){
        	if(employeeN1.primaryEmployee.status=="active"){
        	def var11 = roles1[iy].roleName
        	if(var11=="Senior Environmental Engineer I"){
       		var11 = "SEE-I"
       		}
       		if(var11=="Senior Environmental Engineer II"){
       		var11 = "SEE-II"
       		}
       		def name=employeeN1.primaryEmployee.employeeFirstName+" "+employeeN1.primaryEmployee.employeeLastName
        	name = var11+" "+name
        	roles.add(roles1[iy])
        	rolesOfficerName.add(name)
        
        	}
        	
        	}
        		}	 
        	
        			      %>
                   	       
                   	       
                   	       <td align="center" style="vertical-align: text-top;" width="18.2%">
                   	   
                   	       <%=groupMasterInstance%>
                   	    
                   	       </td>
                   	
                  
                
                 <td  nonwrap style="white-space:nowrap;">
                   	     
                   	    
                   	  <table cellspacing="1" width="100%" >
                   	      
                   	       
                   	       <%   
                   	       
                   	       for(int iei=0;iei<roles.size();iei++){
        				  
        			 %>  
                   	         <tr width="100%" bgcolor="${(iei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> 
                   	         <td nonwrap><font size="2%"><%=rolesOfficerName.get(iei)%></font> </td></tr> 
                   	    
                   	      <%}%> 
                   	      
                   	        <tr width="100%" bgcolor="white"> <td nonwrap>
                   <font color="red"> Total</font>
                   	      </td></tr> 
                   	      
                   	      </table>
                   	        
                   	  
                   	     </td>
                   	     
                 
                
                   
                   <td >
                  
                 
                  
                  
                  
         <table cellspacing="1" width="100%" >
                
                 <%  
                  def gt1 = 0
                  def total2 = 0
                       def  total1 = 0
                ArrayList a =  new ArrayList()
               int[] sumRow=new int[roles.size()];
               
                
              for(int ieei=0;ieei<roles.size();ieei++){
             
             
              def diffArray = new ArrayList()
     
           
     			def var1 = roles[ieei].id
     			   	
     			def totalApplicationList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTE' and abc.applicationStatus = 'pending' and abc.roleId=?",[var1.toString()]) 
                for(int ip =0; ip<totalApplicationList.size(); ip++)
                {
                    def newArray = new ArrayList()
        			def appRecieveDate=totalApplicationList.get(ip).pendingSince
        			Date today = new Date();
                 	diff = today.getTime() - appRecieveDate.getTime();
    				diffDays=diff / (1000*60*60*24) +1
    				if(diffDays>=noOfDays.toLong())
    				{
    				   diffArray.add(diffDays)
    				}			
                }
        %>
             
                
                 
                
                     <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> 
                     <td>
                        <g:if test="${diffArray.size()==0}">
                           <span style="font-weight:normal"><font size="2%">0</font></span>
                        </g:if>
                        <g:else>   
                           <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueDaysWise?id=${var1}&applicationType=CTE&noOfDays=<%=noOfDays%>&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                              <font size="2%"><%=diffArray.size()%></font>
                           </a>
                        </g:else>   
                     </td>
            
           
<%
	sumRow[ieei]=diffArray.size();
	total1 = diffArray.size()	
    total2 = 	total2 + total1				
    					
gt1 =  total2
 } 
 
 
 gt2 =  gt1 + gt2		
 
 		 %>
                </tr> 
               
<tr bgcolor="white"><td><%=total2%></td></tr>
             
                  
                  
                
               
                 </table>
            
               
               
                </td>
               
                  <td >
                  
                              
          <table cellspacing="1" width="100%" >
                
                 <%   
               
                def total22 = 0
                       def  total21 = 0
              for(int ieei=0;ieei<roles.size();ieei++){
              def diffArray = new ArrayList()
             
     			   	def var1 = roles[ieei].id
     			   
     			   def totalApplicationList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.applicationType='CTO' and abc.applicationStatus = 'pending' and abc.roleId=? order by id",[var1.toString()]) 
                   for(int ip =0; ip<totalApplicationList.size(); ip++)
                   {
                       def newArray = new ArrayList()
           			def appRecieveDate=totalApplicationList.get(ip).pendingSince
           			Date today = new Date();
                    	diff = today.getTime() - appRecieveDate.getTime();
       				diffDays=diff / (1000*60*60*24) +1
       				if(diffDays >= noOfDays.toLong())
       				{
       				   diffArray.add(diffDays)
       				}			
                   }
     	   %>
             
                
                 
                
                    <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> 
                     <td>
                        <g:if test="${diffArray.size()==0}">
                           <span style="font-weight:normal"><font size="2%">0</font></span>
                        </g:if>
                        <g:else>   
                           <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueDaysWise?id=${var1}&applicationType=CTO&noOfDays=<%=noOfDays%>&status=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                              <font size="2%"><%=diffArray.size()%></font>
                           </a>
                        </g:else>   
                     </td>
            
           
<% 
     sumRow[ieei]+=diffArray.size();
total11 = diffArray.size()	
	
    total22 = 	total22 +		total11		



}

gt3 =  total22 + gt3
%>
                </tr> 
                 
                  
             <tr bgcolor="white"><td><%=total22%></td></tr>
                  
                  
                
               
                 </table>
            
                </td>
                
        <td >
         <table cellspacing="1" width="100%" >
                 <%  
              for(int ieei=0;ieei<roles.size();ieei++)
              {
             
        %>
             
                     <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> 
                     <td>
                      <span style="font-weight:normal"><font size="2%"><%=sumRow[ieei]%></font></span>
                     </td>
            
           
<%
 } 
%>
                </tr> 
<tr bgcolor="white"><td> <font size="2%"><%=(total22+total2)%></font></td></tr>
            </table>
 </td>
                
                
                
                 </tr> 
                 
                 
                 
              <%}
              else
              {
                 %><tr><td colspan="5">No records found.. </td></tr><%
              }
              %>
              
              
                
                
                </table>
		

		

		
            <br />
            <br />
          </div> 
</body>
</html>