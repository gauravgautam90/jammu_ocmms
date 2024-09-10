<%@ page import="java.text.SimpleDateFormat"%>
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
                
               
                
                if(!noOfDays)
                {
                   noOfDays=5;
                }
                
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
       
			<FORM id="myForm" name="myForm" action="conReportPendingDaysWiseSubmit" method="post">  
	   
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
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         
         <tr >
            
             <td  align="right"  class="headngblue">District Office:</td>
                <td align="left" >
               <%
                
                if(!noOfDays)
                {
                   noOfDays=5;
                }
               	def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
def groupListChoose = new ArrayList()
for(int i = 0 ; i < newGroupList.size(); i++ ){
if(!(newGroupList[i].groupName=="HO CONSENT")){
		groupListChoose.add(newGroupList[i])
}}
               
               
               %>
               
               <g:select from="${groupListChoose.groupName}" name="groupName" id="groupName" value="${groupMasterInstance?.groupName}" class="txt4"></g:select>
				 
                </td>
                
                <td  align="right"  class="headngblue">Choose Number of Days:</td>
                <td  align="left"  class="headngblue" style="color:black;">
                     <g:select from="${[5,10,30,60,120]}" name="noOfDays" value="${noOfDays}" id="noOfDays" class="txt4"></g:select> Days
                </td>
                <td align="center"  class="headngblue"><input type="submit" name="save" value="Search" class="actionbutton"></td>
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


