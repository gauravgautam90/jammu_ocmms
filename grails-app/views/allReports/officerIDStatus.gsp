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
       
			<FORM id="myForm" name="myForm" action="searchByOfficerIDStatus" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			                       
                 <tr bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">End Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
  				<% UserMaster um11=(UserMaster)session.getAttribute("userMaster");
  				def checkAdmin = um11.accessLevel
  				
  				 %>
  		<tr bgcolor="#E8F6F9">
         <td width="15%" align="left"  class="headngblue" >Officer ID:*</td>
         <% if(checkAdmin.equals('employee')){ %>
           <td width="33%" align="left" >
			<input type="text" name="officerID" value="${officerId}" readonly/>
      </td><% } else{%>
      
      <td width="33%" align="left" >
			<input type="text" name="officerID" value=""/>
			<%} %>
      <td> </td>
      <td> </td>
         
  				</table>
		
		 <table width="95%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
		  </tr>
 
		</table>
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
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
               <span style="color:red;font-size:13px;">Status on the basis of Officer ID and Date</span><br> 
               <% if(dd1 && dd1.length()>3 && officerID) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font> <br>Officer ID:- <font color="red"> <%=officerID%></font><%}%>
         </span>
         </td>
         </tr> 
        <tr><td></td></tr>               
	  <tr>
<td  align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popByOfficerIDStatus', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue" align="right">Print Preview</span></a> | 
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popByOfficerIDStatusExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue" align="right">Print in Excel Format</span></a>
</td>
</tr> 

<tr>
<td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr><!-- Div area for errors-->
      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
      <g:if test="${flash.message}">
           				 <div>${flash.message}</div>
            			</g:if>
            			<g:hasErrors bean="${groupMasterInstance}">
            			
              			  <g:renderErrors bean="${groupMasterInstance}" as="list" />
            			
            		</g:hasErrors>
      
      </span></div></td>
    </tr>
	  
	    </table>
		
		
		
         
	    <div style="overflow: auto;height: 600px; width: 1000px;">	
<table width=140% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                  
		<tr width="200%" bgcolor="#A8DAF3"  >
						<th align="center" style="width:3%;border-bottom:3px solid green;" class="headngblue" >S.No</th>
                   	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application ID</th>
                   	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application Name</th> 
                	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Industry Type</th>
                	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Location</th>
                   	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Category</th> 
                   	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Application Date</th> 
                   	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Date of Receipt as per Officer ID</th>     
                   	 <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Consent For</th>
                	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Status</th> 
                	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Pending With/Forwarded To</th> 
                	      
                	    <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >District</th>
                   	     <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Note History</th> 
                   	      
                  </tr>
                  <g:each in="${appSummary}" status="i" var="appSummaryInstance">
                  <%SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                  
                  String strDate = sdfDestination.format(appSummaryInstance.applicationDate );
                  def instancePrcessing=ApplicationProcessingDetails.find("from ApplicationProcessingDetails abc where abc.application=?",[appSummaryInstance])
                   String strDatebyOffiecrID = sdfDestination.format(instancePrcessing.dateCreated );
                  String applicationFor = appSummaryInstance.applicationFor
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
                  String consentFor = appSummaryInstance.certificateFor
                  
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
                  }%>
                  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
                  <td align="center" ><%=i+1%></td>
                  <td align="center" height="25" class="txt4"  ><g:link action="doGetShow" controller="indApplicationDetails" id="${appSummaryInstance.id}">${appSummaryInstance.id}</g:link></td>
                  <td align="center" ><%=appSummaryInstance.indUser.indName%></td>
                  <td align="center" ><%=applicationFor%></td>
                  <td align="center" ><%=appSummaryInstance.indUser.indAddress%></td>
                  <td align="center" ><%=appSummaryInstance.indUser.category.name%></td>
                  <td align="center" ><%=strDate%></td>
                  <td align="center" ><%=strDatebyOffiecrID%></td>
                  <td align="center" > ${appSummaryInstance.applicationType} ( <%=consentFor%> )</td>
                  <% def instance=ApplicationPendingDetails.find("from ApplicationPendingDetails abc where abc.application=?",[appSummaryInstance])
                  def status=""
                  def officer=""
                	  if(instance){
                		  status=instance.applicationStatus
                		  officer=instance.pendingWith
                   }%>
                  <td align="center" ><%=status%></td>
                  <td align="center" ><%=officer%></td>
                  
                  <td align="center" ><%=appSummaryInstance.indUser.district.districtName%></td>
                   <%if(appSummaryInstance.id){%>
                  <td align="center" >
                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openApplicationDetails?id=<%=appSummaryInstance.id%>', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');">Note History</a>
				 </td>
          	       <%} %>
          	       </tr>
          	       </g:each>
                  
   
               
              </tr>
             
                
                </table>
		

		</div>
		
		
            <br />
            <br />
          
		  </form>
		  
	  <% session.endDate1=null
       	  session.startDate1=null
       %>
		  
          </div>
	  
	  
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


