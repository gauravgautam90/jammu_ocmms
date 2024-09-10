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
<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=500px,width=800px,scrollbars=1');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>
<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
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
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<!-- code for menuAdmin-->
			
					<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" action="cessIndustryMenuVertical"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="cessAdminMenuVertical"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="cessEmpMenuVertical"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
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
	

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>

<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
		
		<% } %>
	
					 </table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${groupMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${groupMasterInstance}" as="list" />
										</div>
										</g:hasErrors>

                      </span></div></td>
                    </tr>
                    
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
			<FORM id="myForm" name=myForm action="searchSummaryApplication" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search Application</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				                      <tr  bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">Ending Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
                      
                       <tr  bgcolor="#E8F6F9" >
                          
                        <td  align="left"  class="headngblue">Status:</td>
                        <td align="left" >
                        <select class="txt4" name="status"><option value="xyz">Not Selected</option>
                        <option value="In Progress">In-Progress</option>
                        <option value="Completed">Completed</option>
                        
                        </select> 
					
                        </td>
                        <td align="left" class="headngblue">Category:</td>
														<td align="left"><g:select class="txt4"
															optionKey="id" from="${IndCatMaster.list()}"
															name="category" noSelection="${['xyz':'Not Selected']}"></g:select>
														</td>
                      </tr>
      
	  </table>
	  
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="right"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
 <tr><td>&nbsp;</td></tr>
		</table>
 			 </form>
		
		
		<table width="95%" border="0" align="center"
														cellpadding="0" cellspacing="0" bordercolor="#cbcbcd"
														class="tab-txt" style="border-collapse: collapse;">
														<tr>
															<td align="left" class="headngblue">Application
															Received: <g:link controller="cessReturnDetails"
																action="summaryCess" params="[checkVar: 'received']">${receivedCount}</g:link></td>
															<td align="left" class="greenTxt">Application
															Completed:<g:link controller="cessReturnDetails"
																action="summaryCess" params="[checkVar: 'completed']">${completedCount}</g:link></td>
														</tr>
														<tr>
															<td align="left" class="redTxt">Application Pending:<g:link
																controller="cessReturnDetails"
																action="summaryCess" params="[checkVar: 'pending']"> ${pendingCount}</g:link></td>
															<td align="left" class="purpleTxt">Unattended
															Application:<g:link controller="cessReturnDetails"
																action="summaryCess" params="[checkVar: 'orphan']"> ${unattendedCount}</g:link></td>
														</tr>
														<tr>
															<td colspan="2">&nbsp;</td>
														</tr>
														
													</table>
		
								<g:if test="${cessReturnInstanceList}">
								<table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:fullListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
									<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                 						 <tr height="20" bgcolor="#A8DAF3">
                   	      					  <th align="center" class="headngblue" >Application ID</th>
                   	    			    	  <th align="center" class="headngblue" >Industry User </th>
                   	  					      <th align="center" class="headngblue" >Cess Applied From</th>
                   	                          <th align="center" class="headngblue" >Cess Applied To</th>
                   	   						  <th align="center" class="headngblue" >Application Date</th>
                   	 					      <th align="center" class="headngblue" >Status</th>
                   	       					  <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
                   	      				  </tr>

                    <g:each in="${cessReturnInstanceList}" status="i" var="cessReturnInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(cessReturnInst.dateCreated );
                        
                         def yr=((cessReturnInst.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessReturnInst.cessAppliedFromDate).getMonth()+1).toString()
						
			if (mon=="1"){
				mon = "January"
			}else if(mon=="2"){
				mon = "February"
			}else if(mon=="3"){
				mon = "March"
			}else if(mon=="4"){
				mon = "April"
			}else if(mon=="5"){
				mon = "May"
			}else if(mon=="6"){
				mon = "June"
			}else if(mon=="7"){
				mon = "July"
			}else if(mon=="8"){
				mon = "August"
			}else if(mon=="9"){
				mon = "September"
			}else if(mon=="10"){
				mon = "October"
			}else if(mon=="11"){
				mon = "November"
			}else if(mon=="12"){
				mon = "December"
			}
			
			def fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessReturnInst.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessReturnInst.cessAppliedToDate).getMonth()+1).toString()
							
			if (mon1=="1"){
				mon1 = "January"
			}else if(mon1=="2"){
				mon1 = "February"
			}else if(mon1=="3"){
				mon1 = "March"
			}else if(mon1=="4"){
				mon1 = "April"
			}else if(mon1=="5"){
				mon1 = "May"
			}else if(mon1=="6"){
				mon1 = "June"
			}else if(mon1=="7"){
				mon1 = "July"
			}else if(mon1=="8"){
				mon1 = "August"
			}else if(mon1=="9"){
				mon1 = "September"
			}else if(mon1=="10"){
				mon1 = "October"
			}else if(mon1=="11"){
				mon1 = "November"
			}else if(mon1=="12"){
				mon1 = "December"
			}
			def toDate=mon1+"/"+yr1
                       
							
                        %>
                        
                        <%
                       String fontColor;
                       if(statusList.get(i)=="pending")
                       {
                       	fontColor = "red";
                       }
                       else if(statusList.get(i)=="completed")
                       {
                       	fontColor = "green";
                       }
                       else
                       {
                       fontColor = "purple";
                       }
                       %>
                       
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><%if(access.equals("admin")) { %><g:link action="showCessSpcb" controller="cessReturn" id="${cessReturnInst.id}"><b><u>${fieldValue(bean:cessReturnInst, field:'id')}</u></b></g:link><%}else { %>${fieldValue(bean:cessReturnInst, field:'id')}<%} %></td>
                        
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${fieldValue(bean:cessReturnInst, field:'industryReg')}</font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=fromDate%></font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=toDate%></font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=strDate%></font></td>
                           
                           	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=statusList.get(i)%></font></td>
                        	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${pendingWithRole.get(i) }(${pendingWith.get(i) })</font></td>
                       
                           
                          </tr>
                    </g:each>
					
					
                </table>
		<%
if(params.checkVar=="orphan")
{
%>
<table width="95%" align="center">
<tr>
<td align="center" colspan="0"><g:link
action="routeUnattended">
<font face="Verdana" size="1" color="red"><b><u>Please
click here to route the applications</u></b></font>
</g:link></td>
</tr>
</table>
<%}%>

		
		
		</g:if>
		<g:if test="${cessReturnInstList}">
            <table width="100%"  ><tr align="right"><td><a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printAllCriteriasList" params="[listVal:fullListToPrint]" ></g:createLink> ')"><span
																class="headngblue">Print Preview</span></a></td></tr></table>
           

<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

                  <tr height="20" bgcolor="#A8DAF3">

                        
                   	        <th align="center" class="headngblue" >Application ID</th>
                   	        <th align="center" class="headngblue" >Industry User </th>
                   	            <th align="center" class="headngblue" >Cess Applied From</th>
                   	        <th align="center" class="headngblue" >Cess Applied To</th>
                   	    <th align="center" class="headngblue" >Application Date</th>
                   	        <th align="center" class="headngblue" >Status</th>
                   	        <th align="center" class="headngblue" >Pending With/Forwarded To</th> 
                   	        </tr>

                    <g:each in="${cessReturnInstList}" status="i" var="cessReturnInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(cessReturnInst.dateCreated );
                        
                        def yr=((cessReturnInst.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessReturnInst.cessAppliedFromDate).getMonth()+1).toString()
						
			if (mon=="1"){
				mon = "January"
			}else if(mon=="2"){
				mon = "February"
			}else if(mon=="3"){
				mon = "March"
			}else if(mon=="4"){
				mon = "April"
			}else if(mon=="5"){
				mon = "May"
			}else if(mon=="6"){
				mon = "June"
			}else if(mon=="7"){
				mon = "July"
			}else if(mon=="8"){
				mon = "August"
			}else if(mon=="9"){
				mon = "September"
			}else if(mon=="10"){
				mon = "October"
			}else if(mon=="11"){
				mon = "November"
			}else if(mon=="12"){
				mon = "December"
			}
			
			def fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessReturnInst.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessReturnInst.cessAppliedToDate).getMonth()+1).toString()
							
			if (mon1=="1"){
				mon1 = "January"
			}else if(mon1=="2"){
				mon1 = "February"
			}else if(mon1=="3"){
				mon1 = "March"
			}else if(mon1=="4"){
				mon1 = "April"
			}else if(mon1=="5"){
				mon1 = "May"
			}else if(mon1=="6"){
				mon1 = "June"
			}else if(mon1=="7"){
				mon1 = "July"
			}else if(mon1=="8"){
				mon1 = "August"
			}else if(mon1=="9"){
				mon1 = "September"
			}else if(mon1=="10"){
				mon1 = "October"
			}else if(mon1=="11"){
				mon1 = "November"
			}else if(mon1=="12"){
				mon1 = "December"
			}
			def toDate=mon1+"/"+yr1
                       
							
               
                        %>
                        
                        <%
                       String fontColor;
                       if(statusList.get(i)=="pending")
                       {
                       	fontColor = "red";
                       }
                       else if(statusList.get(i)=="completed")
                       {
                       	fontColor = "green";
                       }
                       else
                       {
                       fontColor = "purple";
                       }
                       %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><%if(access.equals("admin")) { %><g:link action="showCessSpcb" controller="cessReturn" id="${cessReturnInst.id}"><b><u>${fieldValue(bean:cessReturnInst, field:'id')}</u></b></g:link><%}else { %>${fieldValue(bean:cessReturnInst, field:'id')}<%} %></td>
                        
                           <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${fieldValue(bean:cessReturnInst, field:'industryReg')}</font></td>
                        
                          <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=fromDate%></font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=toDate%></font></td>
                        
                            <td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=strDate%></font></td>
                           
                           	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>"><%=statusList.get(i)%></font></td>
                        	<td align="center" height="25" class="txt4"  ><font color="<%=fontColor%>">${pendingWithRole.get(i) }(${pendingWith.get(i) })</font></td>
                       
                           
                          </tr>
                    </g:each>
					
					
                </table>
		
		
		</g:if>
		
            <br />
            <br />
          </div>
		  
		 
		  
	  
		  
          </div>
	  
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


