<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=popMonitoringDetailBmwOfficerWiseExc.xls");
%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


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

<body>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >

<tr>
<td colspan="9" align="center" >
<span class="headngblue">
<span style="color:red;font-size:13px;">Pending applications monitoring in days</span> <span><br><%if(appFor) {%><br>Application Type :- <font color="red"  style="font-size: large;">  <%=appFor%></font><%}%>
</span>
</td>
</tr>                  
</table>




	  
<div style="overflow: auto;height: 600px; width: 1000px;">

	    
<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
		<tr width="100%" bgcolor="#CCFFCC"  >
                   	       <th align="center" width=18% class="headngblue" >District Office</th>
                   	        <th align="center" width="26%" class="headngblue" >Name Of Officer</th>
                   	        <th align="center" class="headngblue" >Pending beyond 120 days</th>
                   	         <th align="center" class="headngblue" >Pending between 90 and 120 days</th> 
                   	     <th align="center" class="headngblue" >Pending between 60 and 90 days</th> 
                   	      <th align="center" class="headngblue" >Pending between 30 and 60 days</th> 
                   	   <th align="center" class="headngblue" >Pending upto 30 days</th>
                   	<th align="center" class="headngblue" >Total</th>
                   	     
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
                %>
                  	
    <g:each in="${groupList}" status="i" var="groupMasterInstance">
            
             <tr width="100%" bgcolor="${(i % 2) == 0 ? '#CCFFCC' : '#A3CCA3'}"> 
              

                
                    
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
                   	       
                   	       
                   	       <td align="center" width="18.2%">
                   	   
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
               
                
              for(int ieei=0;ieei<roles.size();ieei++){
             
             
              def diffArray = new ArrayList()
     
           
     			def var1 = roles[ieei].id
     			   	
     			def totalApplicationList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where abc.applicationStatus = 'pending' and abc.applicationFor = ? and abc.roleId=? ",[appFor,var1.toString()]) 
                for(int ip =0; ip<totalApplicationList.size(); ip++)
                {
                    def newArray = new ArrayList()
        			def appRecieveDate=totalApplicationList.get(ip).recieptDate
        			Date today = new Date();
                 	diff = today.getTime() - appRecieveDate.getTime();
    				diffDays=diff / (1000*60*60*24) +1
    				if(diffDays>=120)
    				{
    				   diffArray.add(diffDays)
    				}			
                }
        %>
             
                
                 
                
                     <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${var1}&days1=120&a=a&reportType=type1&appFor=${appFor}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
                    <font size="2%"><%=diffArray.size()%></font></a></td>
            
           
<%
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
     			   
     			   def totalApplicationList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where abc.applicationStatus = 'pending' and abc.applicationFor = ? and abc.roleId=? order by id",[appFor,var1.toString()]) 
                   for(int ip =0; ip<totalApplicationList.size(); ip++)
                   {
                       def newArray = new ArrayList()
           			def appRecieveDate=totalApplicationList.get(ip).recieptDate
           			Date today = new Date();
                    	diff = today.getTime() - appRecieveDate.getTime();
       				diffDays=diff / (1000*60*60*24) +1
       				if(diffDays < 120  && diffDays> 89)
       				{
       				   diffArray.add(diffDays)
       				}			
                   }
     	   %>
             
                
                 
                
                    <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${var1}&days=120&days1=90&a=b&reportType=type2&appFor=${appFor}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
                    <font size="2%"><%=diffArray.size()%></font></a></td>
            
           
<% 
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
            def total23 = 0
                       def  total13 = 0
              for(int ieei=0;ieei<roles.size();ieei++){
              def diffArray = new ArrayList()
              
     			   	def var1 = roles[ieei].id
     			   
     			   def totalApplicationList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where abc.applicationStatus = 'pending' and abc.applicationFor = ? and abc.roleId=? order by id",[appFor,var1.toString()]) 
                   for(int ip =0; ip<totalApplicationList.size(); ip++)
                   {
                       def newArray = new ArrayList()
           			def appRecieveDate=totalApplicationList.get(ip).recieptDate
           			Date today = new Date();
                    	diff = today.getTime() - appRecieveDate.getTime();
       				diffDays=diff / (1000*60*60*24) +1
       				if(diffDays < 90 && diffDays > 59 )
       				{
       				   diffArray.add(diffDays)
       				}			
                   }
               %>
             
                
                 
                
                   <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${var1}&days=90&days1=60&a=c&&reportType=type3&appFor=${appFor}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
                    <font size="2%"><%=diffArray.size()%></font></a></td>
            
           
<% 

total13 = diffArray.size()	
	
    total23 = 	total23 +		total13		
}

gt4 =  total23 + gt4
%>
                </tr> 
                 
                  
             
                  
               <tr bgcolor="white"><td><%=total23%></td></tr>   
                
               
                 </table>
            
               
                </td>
               
                 <td>
                  
                   <table cellspacing="1" width="100%" >
                
                 <%   
          def total24 = 0
                       def  total14 = 0
              for(int ieei=0;ieei<roles.size();ieei++){
              def diffArray = new ArrayList()
            
     			   	def var1 = roles[ieei].id
     			   	
     			   def totalApplicationList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where abc.applicationStatus = 'pending' and abc.applicationFor = ? and abc.roleId=? order by id",[appFor,var1.toString()]) 
                   for(int ip =0; ip<totalApplicationList.size(); ip++)
                   {
                       def newArray = new ArrayList()
           			def appRecieveDate=totalApplicationList.get(ip).recieptDate
           			Date today = new Date();
                    	diff = today.getTime() - appRecieveDate.getTime();
       				diffDays=diff / (1000*60*60*24) +1
       				if(diffDays> 29 && diffDays<60)
       				{
       				   diffArray.add(diffDays)
       				}			
                   }
     		   %>
             
                
                 
                
                   <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${var1}&days=60&days1=30&a=d&reportType=type4&appFor=${appFor}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
                    <font size="2%"><%=diffArray.size()%></font></a></td>
            
           
<%
total14 = diffArray.size()	
	
    total24 = 	total24 +		total14	

 }
 
 gt5 =  total24 + gt5
 %>
                </tr> 
                 
                  
             
                  <tr bgcolor="white"><td><%=total24%></td></tr>
                  
                
               
                 </table>
            
                </td>
                
         <!-- =====================================================================================  -->
         
         <td >
         
         
         <table cellspacing="1" width="100%" >
               
                <%   
              
               def total229 = 0
               def  total219 = 0
              
             for(int ieei=0;ieei<roles.size();ieei++){
             def diffArray = new ArrayList()
            
    			   	def var1 = roles[ieei].id
    			   
    			   	def totalApplicationList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where abc.applicationStatus = 'pending' and abc.applicationFor = ? and abc.roleId=? order by id",[appFor,var1.toString()]) 
                    for(int ip =0; ip<totalApplicationList.size(); ip++)
                    {
                        def newArray = new ArrayList()
            			def appRecieveDate=totalApplicationList.get(ip).recieptDate
            			Date today = new Date();
                     	diff = today.getTime() - appRecieveDate.getTime();
        				diffDays=diff / (1000*60*60*24) +1
        				if(diffDays < 31)
        				{
        				   diffArray.add(diffDays)
        				}			
                    }
       		 %>
            
               
                
               
                   <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
               
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${var1}&days1=30&a=b&reportType=type5&appFor=${appFor}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


               
                   <font size="2%"><%=diffArray.size()%></font></a></td>
           
          
<% 
total219 = diffArray.size()	
total229 = 	total229 +		total219		

}

gt39 =  total229 + gt39
%>
               </tr> 
                
                 
            <tr bgcolor="white"><td><%=total229%></td></tr>
                 
                 
               
              
                </table>
           
               </td>

               <td>
               <table  cellspacing="1" width="100%" >
               <%
               int totalSum=0;
               for(int ieeii=0;ieeii<roles.size();ieeii++)
               {
            	 def roleId=(roles.get(ieeii).id).toString()
                 def totalApplicationList = AllSummaryReportWMS.findAll("from AllSummaryReportWMS  as abc where abc.applicationStatus = 'pending' and abc.applicationFor = ? and abc.roleId=? order by id",[appFor,roleId]) 
       		    %>
                  <tr width="100%" bgcolor="${(ieeii % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                   <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${roleId}&days1=30&a=b&reportType=type6&appFor=${appFor}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                         <font size="2%"><%=totalApplicationList.size()%></font></a></td></tr>
                
                 <% 
                  totalSum += totalApplicationList.size()	
               }
               sumPending+=totalSum
               %>
               <tr><td bgcolor="white"><%=totalSum%></td></tr>
               </table>
               </td>
               
         <!-- =====================================================================================  -->
                
                
                
                 </tr> 
               </g:each>	  
              
              <tr bgcolor="#CCFFCC">
              <td></td>
              <td><font color="RED">Grand Total:</font></td>
             
                <td><font color="purple"><%=gt2%></font></td>
                 <td><font color="purple"><%=gt3%></font></td>
                   <td><font color="purple"><%=gt4%></font></td>
                   <td><font color="purple"><%=gt5%></font></td>
                   <td><font color="purple"><%=gt39%></font></td>
                   <td><font color="purple"><%=sumPending%></font></td>
              </tr>
                
                
                </table>
		

		

		
            <br />
            <br />
          </div> 
		  
		  </form>
		  
	 
          </div>
</body>
</html>