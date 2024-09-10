<%@ page import="java.text.SimpleDateFormat"%>
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
							<td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
								<!-- code for menuAdminHorizontal-->
								<% 
									if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									<% 
 									if((UserMaster)session.getAttribute("userMaster")){
 									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType = aa.accessLevel;
									if(userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
									controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
									<% 
									if( (!(IndUser)session.getAttribute("indUser") ) && 
		      						(! (UserMaster)session.getAttribute("userMaster") )  )   {
		      						%> 
		      						<g:include controller="userMaster" action="showIndexMenuHorizontal" />
		      			 			<% 
		      			 			} 
		      					%>
							</td>
						</tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
											<!-- code for menuAdmin-->
											<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="eWasteEmpMenuVertical"/> 
					                        <%    }
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
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
			<FORM id="myForm" name=myForm action="viewSearchResult" method="post">  
	   
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
			 
					  <tr>
						<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio name=searchOp value="ApplId" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> ><span class="headngblue">By Application Id</span></td>
						
					  </tr>
						<input type="hidden" name="appIdList" value="${appIdList}" />
                      <tr  >
                        <td width="20%" class="headngblue"  bgcolor="#E8F6F9"   align="left" >Application Id:</td>
                        <td align="left" colspan="3" bgcolor="#E8F6F9">
                        <g:select class="txt4" optionKey="id" from="${appIdList}" id="idList" name="idList" noSelection="${['xyz':'Not Selected']}" ></g:select>
                        <span class="txt4">(select application ID)</span></td>
						
                      </tr>
					  
					  <tr>
						<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio name=searchOp value="ApplName"  <%if(paramList != null && (paramList.searchOp).equals("ApplName")){%>checked="checked"<%}%> ><span class="headngblue">By Industry Name</span></td>
						
						</tr>
						
                      <tr  >
                        <td width="20%" class="headngblue"  bgcolor="#E8F6F9"   align="left" >Industry Name:</td>
                        <td align="left" colspan="3" bgcolor="#E8F6F9">
                        <input type="text" class="txt4" id="autocomplete1" size="30" name="autocomplete_parameter1"/>
                        <span class="txt4">(Enter first letter of Industry Name)</span></td>
                      </tr>
                     <div id="autocomplete_choices" class="autocomplete1" ></div>
                      <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#E8F6F9" class="headngblue">
                                    Select Application Type:
                                </td>
                                <td align="left" colspan="3" bgcolor="#E8F6F9">
                                    <g:select class="txt4" noSelection="${['xyz':'Not Selected']}"   from="${['EWaste']}" name="appTypeName" id="appTypeName" ></g:select>
                                </td>
                            </tr>
                            <tr>
						<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio name=searchOp value="ApplDate"  <%if(paramList != null && (paramList.searchOp).equals("ApplName")){%>checked="checked"<%}%> ><span class="headngblue">By Date</span></td>
						
						</tr>
						<tr bgcolor="#E8F6F9">
														<td width="15%" align="left" class="headngblue">Start
														Date:*</td>
														<td width="35%" align="left">
														 <calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
														
												<!-- 		<input type="text"
															id="start_date" name="start_date" class="txt4" /> <script
															language="JavaScript">
									new tcal ({
										// form name
										'formname': 'myForm',
										// input name
										'controlname': 'start_date'
									});
								
									</script>  -->
									
									</td>



														<td width="15%" align="left" class="headngblue">Ending
														Date:*</td>
														<td align="left" width="35%">
															<calendar:datePicker name="end_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
													<!-- 	<input type="text"
															id="end_date" name="end_date" class="txt4" /> <script
															language="JavaScript">
							new tcal ({
								// form name
								'formname': 'myForm',
								// input name
								'controlname': 'end_date'
							});
						
							</script>  -->
							
							</td>
													</tr>
													<tr bgcolor="#E8F6F9">
														
													<td align="left" class="headngblue" colspan="1" >Application Type:</td>
														<td align="left" colspan="3" ><select class="txt4" name="statusType">
															<option value="xyz">Not Selected</option>
															<option value="EWaste">EWaste</option>
															
															
														</select> 
														</td>
														
													</tr>
	  </table>
	  
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="right"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
 
		</table>
 		<div align="left" class="txt" style="color: navy">
			   <hr><b>* Instructions:</b><br><br>
			  There are multiple criteria for the application search; By Application ID and By Industry Name. Please select one of them ,select any one of the Application Type and follow the given steps to seach the application.
			  <ul> <b><u>By Application ID:</U></b>
			  	<li>Select Application ID from the drop down list</li>
				<li>Click search button to seach the selected application</li>
				<li>Once found, click application ID to view the application deails</li>
			  </ul>
			  <ul> <b><u>By Industry Name:</U></b>
			  	<li>Enter first letter of Industry name and select Industry name from drop down list </li>
				<li>Click search button to seach the selected application</li>
				<li>Once found, click application ID to view the application deails</li>
			  </ul>
		</div>		
		
		
		<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			<tr>
				<td valign="top" bgcolor="#FFFFFF">
					<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">			
						<thead >
						<tr height="20" bgcolor="#A8DAF3">
 									<th align="center" class="headngblue" >Application No</th>
 									<th align="center" class="headngblue" >Application For</th>
 									<th align="center" class="headngblue" >Application Date</th>
 									<th align="center" class="headngblue" >Industry Name</th>
 									<th align="center" class="headngblue" >Status</th>
                   	       			<th align="center" class="headngblue" >Pending With/Forwarded To</th>
						</tr>
						</thead>
						<tbody>
						<g:each in="${EWInst}" status="i" var="hazardeousWasteAuthAppInstance">
 																						<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
   
                        String strDate = sdfDestination.format(hazardeousWasteAuthAppInstance.dateCreated );
                        %>
						<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
										<!-- <td align="center" height="25" class="txt4"  ><u><g:if test="${accessLevelAdEm=='employee'}"><g:link controller="eWaste" action="show" id="${hazardeousWasteAuthAppInstance.id}">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}</g:link></g:if><g:else>${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}</g:else></u></td>
									-->
								 <td align="center" height="25" class="txt4"  ><u><g:link controller="eWaste" action="show" id="${hazardeousWasteAuthAppInstance.id}">${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'id')}</g:link></u></td>
									
										<td align="center" height="25"  class="txt4" >E-Waste</td>
										<td align="center" height="25"  class="txt4" ><%=strDate%></td>
										<td align="center" height="25" class="txt4"  >${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'industryReg')}</td>
										<td align="center" height="25" class="txt4"  ><%=EWStatusList.get(i)%></td>
                        				<td align="center" height="25" class="txt4"  >${EWPendingWithRole.get(i) }(${EWPendingWith.get(i) })</td>
                       
						</tr>
						</g:each>
						
						
						
					
                    <g:each in="${hazardeousList}" status="i" var="wasteManagementInst">
                    	<% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(wasteManagementInst.dateCreated );
                        %>
                        
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                      
                       
                          <!--  <td align="center" height="25" class="txt4"  ><g:if test="${accessLevelAdEm=='employee'}"><g:link controller="eWaste" action="show" id="${wasteManagementInst.id}">${fieldValue(bean:wasteManagementInst, field:'id')}</g:link></g:if><g:else>${fieldValue(bean:wasteManagementInst, field:'id')}</g:else></td>
                        
                        -->
                    <td align="center" height="25" class="txt4"  ><g:link controller="eWaste" action="show" id="${wasteManagementInst.id}"><u>${fieldValue(bean:wasteManagementInst, field:'id')}</u></g:link></td>
                        
                          <td align="center" height="25" class="txt4"  >E-Waste</td>
                          <td align="center" height="25" class="txt4"  ><%=strDate%></td>
                          
                           <td align="center" height="25" class="txt4"  >${fieldValue(bean:wasteManagementInst, field:'industryReg')}</td>
                        
                           
                        <%if(status!="unattended"){ %>
                            <td align="center" height="25" class="txt4"  ><%=statusListH.get(i)%></td>
                        	<td align="center" height="25" class="txt4"  >${pendingWithRoleH.get(i) }(${pendingWithH.get(i) })</td>
                       <%} %>
                           
                          </tr>
                    </g:each>
						</tbody>
				</table>
			</td>
		  </tr>
		</table>
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
	  
		  
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


