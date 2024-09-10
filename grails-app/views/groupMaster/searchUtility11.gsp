<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
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


</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
		<% 
						if(  (IndUser)session.getAttribute("indUser")  ){ %>
							<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>							
						<%} %>
						<% 
								UserMaster abcd1=session.userMaster
								System.out.println(abcd)
							if(abcd1.flag ==0){ %>	
							<g:include controller="userMaster" action="showIndexMenuHorizontal"/>			
						<% } else{
						if((UserMaster)session.getAttribute("userMaster")){
							UserMaster aa = (UserMaster)session.getAttribute("userMaster");
							String userType =	 aa.accessLevel
							if(userType.equals("admin")) { %>	
								<g:include controller="userMaster" action="showAdminMenuHorizontal"/> 							
							<% }else{ %>
								<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
							<%}} }%>
									
						<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
							<g:include controller="userMaster" action="showIndexMenuHorizontal"/>		
						<% } %>
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
						<g:include controller="userMaster" action="showAdminMenu"/>
				<%} else{ %>
						<g:include controller="userMaster" action="showSpcbUserMenu"/>	
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
       
			<FORM id="myForm" name=myForm action="search122" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		<!--<FORM id="myForm" name='myForm' action="search122" method="post">-->
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
			 
				
					  
					   <tr align="center">
                       

						<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio  name=searchOp value=Others checked="checked"><span class="headngblue">By Date Criteria</span></td></tr>
                      
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
                      
                      
                       
      
	  </table>
	  
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="right"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			
		  </tr>
 
		</table>
 		<div align="left" class="txt" style="color: navy">
			   <hr><b>* Instructions:</b><br><br>
			
			 
			  <ul> <b><u>By Date Criteria:</U></b>
			  	<li>Enter Start Date and End Date to search the application submitted within the given date </li>
				<li>Click search button to seach the selected application</li>
				<li>Once found, click application ID to view the application details</li>
			  </ul>
			  
		</div>		
		
		
		<g:if test="${abc}">
		 <table width="95%" align="center">
	   		
		  <tr>
			<td align="right"><a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popPrintProcessedStatus', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
			<span class="headngblue" align="right">Print Preview</span></a> </td>
			
		  </tr>

		</table>
	
<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

                  <tr height="20" bgcolor="#A8DAF3">

                  <th align="center" class="headngblue" >S.No.</th>
                   	        <th align="center" class="headngblue" >Application ID</th>
                   	        <th align="center" class="headngblue" >Application Name </th>
                   	        <th align="center" class="headngblue" >Industry Type</th>
                   	        <th align="center" class="headngblue" >Location</th>
                   	        <th align="center" class="headngblue" >Category</th>
                   	        <th align="center" class="headngblue" >Application Date</th>
                   	        <th align="center" class="headngblue" >District</th>  
                 	       <th align="center" class="headngblue" >Consent For</th>
                   	        <th align="center" class="headngblue" >Status</th>
                   	        
                          </tr>

     
                    
                    
                    
                    <g:each in="${arr11}" status="i" var="abc11">
                                       <%
                                     //  System.out.println("abc11-----"+abc11);
                                     //  System.out.println("abc11--111---"+abc11.getClass());
                                    //   System.out.println("abc11---222--"+abc11.getClass().getName());
                            String status = ""
                            	String pending = ""
                            		String offName = ""
                            def appProcess = ApplicationPendingDetails.findByApplication(abc11);
                            if(appProcess){
                            	
                            	status = appProcess.applicationStatus
                            		pending = (appProcess.role).toString()
                            		System.out.println("pending-----"+pending);
                            		
                            }
                            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                            String strDate = sdfDestination.format(abc11.actualApplicationDate );
                            
                            String applicationFor = abc11.applicationFor
                            if(applicationFor.equals("brickkilns")){
                            applicationFor="Brick Kilns"
                            }
                            if(applicationFor.equals("both")){
                            applicationFor = "Industry "
                            }
                            if(applicationFor.equals("stonecrusher")){
                            applicationFor = "Stone Crusher"
                            }
                            if(applicationFor.equals("hotmixplants")){
                                applicationFor = "Hot mix plants"
                                }
                            if(applicationFor.equals("stonecrusher and hotmixplants")){
                                applicationFor = "Stone Crusher and Hot mix plants"
                                }
                            if(applicationFor.equals("hotel")){
                             applicationFor = "Hotel"
                            }
                            if(applicationFor.equals("dgset")){
                             applicationFor = "DGSet"
                            }
                            String consentFor = abc11.certificateFor
                            
                            if(consentFor.equals("new")){
                            consentFor="Fresh"
                            }
                            if(consentFor.equals("expan")){
                                consentFor = "Expansion"
                                }
                            if(consentFor.equals("Modern")){
                            consentFor = "Modernization"
                            }
                            if(consentFor.equals("reNew")){
                             consentFor = "Renew"
                            }
                                       %> 	
                                            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                            <td align="center" height="25" class="txt4"  >${i+1}</td>
                                            
                                                <td align="center" height="25" class="txt4"  ><g:link action="doGetShow" controller="indApplicationDetails" id="${abc11.id}">${fieldValue(bean:abc11, field:'id')}</g:link></td>
                                                <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.indName')}</td>
                                                <td align="center" height="25" class="txt4"  ><%=applicationFor%></td>
                                            
                                                <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.indAddress')}</td>
                                            
                                                <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.category.name')}</td>
                                            
                                                <td align="center" height="25" class="txt4"  ><%=strDate%></td>
                                                <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.district.districtName')}</td>
                                                <td align="center" height="25" class="txt4"  >${abc11.applicationType} ( <%=consentFor%> )</td>
                                                <td align="center" height="25" class="txt4"  ><%=status%></td>
                                              
                                            
                                               
                                            </tr>
                                        </g:each>
                </table>
		
		
		</g:if>
		
		
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


