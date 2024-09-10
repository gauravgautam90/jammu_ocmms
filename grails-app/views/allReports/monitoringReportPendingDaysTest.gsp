<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
       
			<FORM id="myForm" name="myForm" action="conReportPendingDaysSubmit" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         
         <tr bgcolor="#E8F6F9" >
            
         <td  align="left"  class="headngblue">District Office:</td>
                <td align="left" >
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
                
                <td  align="left"  class="headngblue"><input type="submit" name="save" value="Search" class="actionbutton"></td>
                
			</tr>
			<tr bgcolor="#E8F6F9" >
			<td colspan="3" align="left" class="headngblue" style="color:red;font-size:12px;"><span >Note : </span>For choosing Multiple District Office (Maximum 5) <b>press ctrl key<b></td>
            </tr>
            
                
                <input type="hidden" name="status" id="status">
                
                
             
           
              
             
</table>		
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
         <tr>
         <td colspan="9" align="center" >
         <span class="headngblue">
         <span style="color:red;font-size:13px;">Pending applications monitoring in days</span> 
         </span>
         </td>
         </tr>                  

         
         
   	  <tr>
   	<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popNewPagePendingReport', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
   	<span class="headngblue">Print Preview</span></a> | 
   	<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popNewPagePendingReportExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
   	<span class="headngblue">Print in Excel Format</span></a>
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
                  	<th align="center" class="headngblue" >Pending with Industry</th>
                   	     
                  </tr>
                  
                  
                  
                 <% 
                 
                  long  diff = 0
                  int diffDays = 0
                  int sumPending=0
                  int sumPendingIndustry=0
                  long clDiff = 0
                  int clDiffDays = 0
                  
                  def gt2 = 0  	
                  def gt3 = 0
                  def gt39 = 0
                  def gt4 = 0
                  def gt5 = 0
                  def totelApplication = new ArrayList()
                %>
                  	
    <g:each in="${groupList}" status="i" var="groupMasterInstance">
            
             <tr width="100%" bgcolor="${(i % 2) == 0 ? '#CCFFCC' : '#A3CCA3'}"> 
              

                
                    
                   	       <%
                   	     	
                   	 //      System.out.println("groups in gsp------------------:"+groups)
                   	   //     System.out.println("groupMasterInstance in gsp ----------------:"+groupMasterInstance.id)
                   	    def group1 = groups.toUpperCase();
                   	    def adksdklskd = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?",[groups])
                 //  	    System.out.println("adksdklskd:"+adksdklskd)
                 
                 def groupId = groupMasterInstance.id
        		def  roles = new ArrayList()
                def  rolesOfficerName=new ArrayList()  	       
        		
        		 	
        		def  roles1 = RoleMaster.findAll("from RoleMaster  as abc where abc.group.id=? ORDER BY version desc",[groupId])
       		System.out.println("roles1=======:"+roles1)
       			System.out.println("roles1=id======:"+roles1.id)
        		for(int iy=0;iy<roles1.size();iy++){
        	
        		def employeeN1 = RoleProfileAssignment.find("from RoleProfileAssignment as abc where abc.role = ? ",[roles1[iy]])
       		System.out.println("employeeN1:"+employeeN1)
        	if(employeeN1)	{
        	if(employeeN1.primaryEmployee.status=="active"){
        	
        	def var11 = (employeeN1.primaryEmployee.id).toString()
        	
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
             
           def OfficerName = rolesOfficerName[ieei].split(" ")[0]
    //          System.out.println("OfficerName =================="+OfficerName) 
            def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
            def OfficerId = userMasterInsta.id
           
     			def var1 = roles[ieei].id
     	//		System.out.println("group1===="+group1 + "OfficerId======="+OfficerId)
     		def totalApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[groups,OfficerId])
   //          System.out.println("totalApplicationList:"+totalApplicationList)
             totelApplication.add(totalApplicationList)
     		for(int ip =0; ip<totalApplicationList.size(); ip++)
                {
                	def appRecieveDate = totalApplicationList[ip].completionDate
                	
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
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${OfficerName}&days1=120&a=a&reportType=type1&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
                    <font size="2%"><%=diffArray.size()%></font></a></td>
            
           
<%
	// System.out.println("diffArray:"+diffArray)
	total1 = diffArray.size()	
  //  System.out.println("total1:"+total1)
	total2 = 	total2 + total1				
	// System.out.println("total2:"+total2)					
gt1 =  total2
 // System.out.println("gt1:"+gt1)
 } 
 
 
 gt2 =  gt1 + gt2		
  // System.out.println("gt2:"+gt2)
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
              def OfficerName = rolesOfficerName[ieei].split(" ")[0]
              def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
              def OfficerId = userMasterInsta.id
             
       			def var1 = roles[ieei].id
       			   	
       		def totalApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[groups,OfficerId])
               for(int ip =0; ip<totalApplicationList.size(); ip++)
                  {
                  	def appRecieveDate = totalApplicationList[ip].completionDate
                  	
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
                
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${OfficerName}&days=120&days1=90&a=b&reportType=type2&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
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
              def OfficerName = rolesOfficerName[ieei].split(" ")[0]
              def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
              def OfficerId = userMasterInsta.id
             
       			def var1 = roles[ieei].id
       			   	
       		def totalApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[groups,OfficerId])
               for(int ip =0; ip<totalApplicationList.size(); ip++)
                  {
                  	def appRecieveDate = totalApplicationList[ip].completionDate
                  	
                  	Date today = new Date();
                   	diff = today.getTime() - appRecieveDate.getTime();
      				diffDays=diff / (1000*60*60*24) +1
      				
      				if(diffDays < 90 && diffDays > 59)
      				{
      				   diffArray.add(diffDays)
      				}			
                  }
               %>
             
                
                 
                
                   <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${OfficerName}&days=90&days1=60&a=c&&reportType=type3&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
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
              def OfficerName = rolesOfficerName[ieei].split(" ")[0]
              def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
              def OfficerId = userMasterInsta.id
             
       			def var1 = roles[ieei].id
       			   	
       		def totalApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[groups,OfficerId])
             for(int ip =0; ip<totalApplicationList.size(); ip++)
                  {
                  	def appRecieveDate = totalApplicationList[ip].completionDate
                  	
                  	Date today = new Date();
                   	diff = today.getTime() - appRecieveDate.getTime();
      				diffDays=diff / (1000*60*60*24) +1
      				
      				if(diffDays> 30 && diffDays<60)
      				{
      				   diffArray.add(diffDays)
      				}			
                  }
     		   %>
             
                
                 
                
                   <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${OfficerName}&days=60&days1=30&a=d&reportType=type4&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


                
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
             def OfficerName = rolesOfficerName[ieei].split(" ")[0]
      //       System.out.println("OfficerName:"+OfficerName)
             def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
             def OfficerId = userMasterInsta.id
      //      System.out.println("OfficerId:"+OfficerId)
      			def var1 = roles[ieei].id
      //			System.out.println("var1:"+var1)   	
      		def totalApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[groups,OfficerId])
           //  System.out.println("if block")
           
     		for(int ip =0; ip<totalApplicationList.size(); ip++)
                 {
     //           	 System.out.println("dfhdjhdj")
                 	def appRecieveDate = totalApplicationList[ip].completionDate
           //      	System.out.println("appRecieveDate:"+appRecieveDate)
                 	Date today = new Date();
                  	diff = today.getTime() - appRecieveDate.getTime();
     				diffDays=diff / (1000*60*60*24) +1
     				
     				if(diffDays>= 0 && diffDays<31)
     				{
     				   diffArray.add(diffDays)
     				}			
                 }
       		 %>
            
               
                
               
                   <tr width="100%" bgcolor="${(ieei % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
               
<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${OfficerName}&days1=30&a=b&reportType=type5&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">


               
                   <font size="2%"><%=diffArray.size()%></font></a></td>
           
          
<% 
 //System.out.println("kkkkkkkk")
total219 = diffArray.size()	
total229 = 	total229 +		total219	
   // System.out.println("total229---"+total229)

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
        //       System.out.println("roles.size()--:"+roles.size())
               for(int ieeii=0;ieeii<roles.size();ieeii++)
               {
            	   def OfficerName = rolesOfficerName[ieeii].split(" ")[0]
            	   def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
                  def OfficerId = userMasterInsta.id
                 def totalApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and apd.applicationStatus='pending' and apd.completionStatus ='Complete' and apd.pendingWith.id =?",[groups,OfficerId])
                 
                 %>
                  <tr width="100%" bgcolor="${(ieeii % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                   <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingTest?id=${OfficerName}&days1=30&a=b&reportType=type6&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                         <font size="2%"><%=totalApplicationList.size()%></font></a></td></tr>
                
                 <% 
                  totalSum += totalApplicationList.size()
                 
               }
               sumPending+=totalSum
               %>
               <tr><td bgcolor="white"><%=totalSum%></td></tr>
               </table>
               </td>
               
         <!--   new Code added by DEEPAK MISHRA for pending application report at industry    -->       
               <td>
               <table  cellspacing="1" width="100%" >
               <%
               int totalPendingSum=0;
    //          System.out.println("roles.size()--:"+roles.size())
               for(int ieeii=0;ieeii<roles.size();ieeii++)
               {
            	   def OfficerName = rolesOfficerName[ieeii].split(" ")[0]
            	   def userMasterInsta = UserMaster.find("from UserMaster where id  =?",[OfficerName])
                  def OfficerId = userMasterInsta.id
                 def totalPendingApplicationList = ApplicationPendingDetails.executeQuery("select apd from ApplicationPendingDetails apd where apd.application.clarification='f' and apd.role.group.groupName=?  and (apd.applicationStatus= 'returned' OR apd.completionStatus in ('In-Complete','Completed') ) and apd.pendingWith.id =?",[groups,OfficerId])
                 
                 %>
                  <tr width="100%" bgcolor="${(ieeii % 2) == 0 ? '#A3CCA3' :  '#CCFFCC' }"> <td>
                   <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getAppValueForTotalPendingWithIndustryTest?id=${OfficerName}&days1=30&a=b&reportType=type6&group1=${groups}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                         <font size="2%"><%=totalPendingApplicationList.size()%></font></a></td></tr>
                
                 <% 
                 totalPendingSum += totalPendingApplicationList.size()
                 
               }
    
    
               sumPendingIndustry+=totalPendingSum
               %>
               <tr><td bgcolor="white"><%=totalPendingSum%></td></tr>
               </table>
               </td>
            <!--              end           -->   
         <!-- =====================================================================================  -->
                
                
                
                 </tr> 
               </g:each>	  
              
              <tr bgcolor="#CCFFCC">
              <td></td>
              <td><font color="RED">Grand Total:</font></td>
             <%
             def totalllll = new ArrayList()
         //    System.out.println("totelApplicationgrand:1111111111111111111 ===  "+totelApplication)
             
                for(int i=0; i< totelApplication.size(); i++) {
              //  	System.out.println("dfdfdf:")
                        for(int j=0; j< totelApplication[i].size(); j++) {
              //          	 System.out.print("  "+totelApplication[i][j]);
                        //	 totalllll.add(totelApplication[i][j])
                        }
                    //    System.out.println("");
                }
 //           System.out.println("totalllll:"+totalllll)
   //          System.out.println("totalllll:"+totalllll.size())
             session.totalllll=totalllll
             %>
             <%    // System.out.println("totelApplicationgrandSize:"+totelApplication.size())  %>
                <td><font color="purple"><%=gt2%></font></td>
                 <td><font color="purple"><%=gt3%></font></td>
                   <td><font color="purple"><%=gt4%></font></td>
                   <td><font color="purple"><%=gt5%></font></td>
                   <td><font color="purple"><%=gt39%></font></td>
                   <td><font color="purple"><%=sumPending%></font>
              <!--     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/noOfApplicationCategoryWise8', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   <font size="2%"><%=sumPending%></font></a>    --></td>
                   
                   <td><font color="purple"><%=sumPendingIndustry%></font></td>
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


