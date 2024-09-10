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
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<% UserMaster aa = (UserMaster)session.getAttribute("userMaster");
					String userType =	 aa.accessLevel;
					if(userType.equals("admin")) { %>	
						<g:include controller="userMaster" action="reportAdminMenuVertical"/> 
				<%} else{ %>
						<g:include controller="userMaster" action="reportAdminMenuVertical"/> 
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
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${abc}">
										<div class="errors">
											<g:renderErrors bean="${abc}" as="conReport" />
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
       
			<FORM id="myForm" name=myForm action="conReport" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
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
			                       
                 <tr bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Expiry Date (From):*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">Expiry Date (To):*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
                     <tr bgcolor="#E8F6F9">
                              <td  align="left"  class="headngblue">Application Type:</td>
                        <td align="left" >
                        <g:select
						 from="${['NotSelected','CTE','CTO']}"
						 
						name="status"
						
						onchange="${remoteFunction(controller:'allReports', action:'myAjax',update:'updateSelect', params:'\'cont=\' + this.value' )}"
						class="txt4"></g:select>
                        </td>
                        
                        <td  align="left"  class="headngblue">Application For:</td>
                        <td align="left" >
                        <div id="updateSelect"><g:select 
						from="${list}" name="appFor" id="appFor"
						noSelection="${[NotSelected:'NotSelected']}"
						class="txt4"></g:select>
                        </td>
                     </tr>
                     <tr bgcolor="#E8F6F9">   
                        <td  align="left"  class="headngblue">Consent For:</td>
                        <td align="left">
                        <select class="txt4" name="consentFor"><option value="ashu">NotSelected</option>
                        <option value="air">Air</option>
                        <option value="water">Water</option>
                        <option value="both">Both</option>
                        </td>
                        <td  align="left"  class="headngblue"></td>
                        <td align="left">
                        
                        </td>
                      </tr>
      
	  </table>
	  
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
		  </tr>
 
		</table>
		<div align="left" class="txt" style="color: navy">
			   <hr><b>* Instructions:</b><br><br>
			  There are multiple criteria for the application search.
			  
			  <ul> 
			  	<li>Enter Start Date and End Date to search the application granted/consent certified within the given date <b>and/or</b></li>
				<li>Select Application Type <b>and/or</b></li>
				<li>Select Application For <b>and/or</b></li>
				<li>Select Consent For <b>and/or</b></li>
				<li>You can combine the criteria given.</li>
				<li>Click search button to seach the selected application</li>
				<li>Once found, click application ID to view the application deails</li>
			  </ul>
			  
		</div>		
		<g:if test="${abc}">
     
     
     
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr>
<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popPageReport', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print Preview</span></a>
</td>
</tr>
                 
     </table>
    
<g:if test="${session.startDate1!=null}">       
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr height="20" bgcolor="#2B547E">
<td align="left" >
<b><font color="yellow" size="2">Consent Order Details From </font><font color="skyblue" size="2"><%=session.startDate1%></font><font color="yellow" size="2"> To </font><font color="skyblue" size="2"><%=session.endDate1%></font></b>
</td>
</tr>
</table>
</g:if>   
<div style="overflow: auto;height: 300px; width: 650px;">

<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
 <tr height="20" bgcolor="#A8DAF3">

                     
                   	        
                   	        <th align="center" class="headngblue" >Application ID</th>
                   	        <th align="center" class="headngblue" >Industry Name</th>
                   	        <th align="center" class="headngblue" >Application Type</th>
                   	        <th align="center" class="headngblue" >Consent For</th>
                   	        <th align="center" class="headngblue" >Application Date</th>
                   	        <th align="center" class="headngblue" >Consent Order Granted (From)</th>
                   	        <th align="center" class="headngblue" >Consent Order Granted (To)</th>
                   	        <th align="center" class="headngblue" >Application For</th>
                   	     
                  </tr>
                    <g:each in="${abc}" status="i" var="abc">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  ><%if(userType.equals("admin")) { %><g:link action="doGetShow" controller="indApplicationDetails" id="${abc.id}">${fieldValue(bean:abc, field:'id')}</g:link><%}else { %>${fieldValue(bean:abc, field:'id')}<%} %></td>
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'indUser')}</td>
                        
                            <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'applicationType')}</td>
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationFor')}</td>
                        
                            <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'applicationDate')}</td>
                        
                            <td align="center" height="25" class="txt4"  ><g:formatDate format="yyyy-MM-dd" date="${stdate.get(i)}"/></td>
                            
                            <td align="center" height="25" class="txt4"  ><g:formatDate format="yyyy-MM-dd" date="${eddate.get(i)}"/></td>
                        
                            <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'certificateFor')}</td>
                        	</tr>
                    </g:each>
					
				<!--	 <tr><td colspan="7">
				 <g:paginate 
						 controller="allReports"
						action="conReport" total="${total}" params="${paramList}"/> 
				</td></tr>		
-->

                </table>
		
		</div>
		
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr height="20" bgcolor="#2B547E">
<td align="left" >
<font color="yellow" size="2"><b>Total Consent Order: <%=abc.size()%></b></font>
</td>
</tr>
</table>
		</g:if>
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
	  <% session.endDate1=null
       	  session.startDate1=null
       %>
		  
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


