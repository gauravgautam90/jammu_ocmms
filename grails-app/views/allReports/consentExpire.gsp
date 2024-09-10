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
       
			<FORM id="myForm" name="myForm" action="conReportExpiry" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			                       
                 <tr bgcolor="#E8F6F9">
                          
                      <td  align="right"  class="headngblue">Please select District Office:</td>
                        <td align="left" >
                       <%
                       	def  newGroupList = GroupMaster.list( sort:"groupName", order:"asc")
		def groupList = new ArrayList()
		for(int i = 0 ; i < newGroupList.size(); i++ ){
			if(!(newGroupList[i].groupName=="HO CONSENT")){
				groupList.add(newGroupList[i])
		}
		}
                       
                       
                       %>
                       
                       <g:select 
						from="${groupList.groupName}" name="group" id="group"
						noSelection="${[NotSelected:'NotSelected']}"
						class="txt4"></g:select>
                        </td>
  				</tr></table>
		
		 <table width="100%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
		  </tr>
 
		</table>
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
         <tr>
          <td colspan="9" align="center" >
          <span class="headngblue">
          <span style="color:red;font-size:13px;">Status of Consent Expiry</span> 
          </span>
          </td>
         </tr>                  
	  <tr>
<td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popConsentExpire', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print Preview</span></a> | 
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popConsentExpireExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		
		
		
      	<div style="overflow: auto;height: 600px; width: 1000px;">
         

<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
                  
                  
		<tr width="100%" bgcolor="#FFFFCC"  >
   	       <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='5%'>S.No</th>
   	       <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='18%'>Industry Name</th>
   	       <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Category</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Classification</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Consent Type</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Application Id</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Issue Date</th>
       	   <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Valid Date</th>
       	   <th align="center" style="border-bottom:3px solid green;" class="headngblue" width='7%'>Expiry(Days)</th>
        </tr>
        
        <%
        if(!allSummaryReportList)
        {
      	 %>
      	    <tr><td colspan="11" >No Records Found...</td></tr>
      	 <%
        }
        %>
        
        <g:each in="${allSummaryReportList}" status="i" var="allSummaryReportInstance">
          
           <tr>
              <%
                   def indRegMaster=IndustryRegMaster.get((allSummaryReportInstance.indRegMasterId).toLong())
                   def recordCertificateInstance=RecordCertificate.find("from RecordCertificate rc where rc.applicationId.id=? ",[(allSummaryReportInstance.applicationId).toLong()]);
                   String dateWithoutTimeS = new SimpleDateFormat("dd-MM-yyyy").format(recordCertificateInstance.dateCreated);
			       String dateWithoutTimeE = new SimpleDateFormat("dd-MM-yyyy").format(recordCertificateInstance.endDate);
		                                   
              %>
                  <td align="center" height="25">  <font size="2%"><%=(i+1)%></font></td>
                  <td align="center" height="25">  <font size="2%">${allSummaryReportInstance.applicationName}</font></td>
                  <td align="center" height="25">  <font size="2%">${indRegMaster.category.name}</font></td>
                  <td align="center" height="25">  <font size="2%">${indRegMaster.industryScale}</font></td>
                  <td align="center" height="25">  <font size="2%">${allSummaryReportInstance.applicationType}</font></td>
                  <td align="center" height="25">  <font size="2%">${allSummaryReportInstance.applicationId}</font></td>
                  <td align="center" height="25">  <font size="2%">${dateWithoutTimeS}</font></td>
                  <td align="center" height="25">  <font size="2%">${dateWithoutTimeE}</font></td>
                  <td align="center" height="25">  <font size="2%">${(expiryDaysList.get(i)).toInteger()}</font></td>
           </tr>
        </g:each>	  
              </tr>
             
                
                
                </table>
		

		
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
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