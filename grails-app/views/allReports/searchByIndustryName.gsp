<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.*" %>
<%
java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
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

<style type="text/css">
		.tooltip {
			color: #000000; outline: none;
			cursor: default; text-decoration: none;
			position: relative;
		}
		.tooltip span {
			margin-left: -999em;
			position: absolute;
		}
		.tooltip:hover span {
			border-radius: 5px 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; 
			box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.1); -webkit-box-shadow: 5px 5px rgba(0, 0, 0, 0.1); -moz-box-shadow: 5px 5px rgba(0, 0, 0, 0.1);
			font-family: Calibri, Tahoma, Geneva, sans-serif;
			position: absolute; left: 1em; top: 2em; z-index: 99;
			margin-left: 0; width: 250px;
		}
		.tooltip:hover img {
			border: 0; margin: -10px 0 0 -55px;
			float: left; position: absolute;
		}
		.tooltip:hover em {
			font-family: Candara, Tahoma, Geneva, sans-serif; font-size: 1.2em; font-weight: bold;
			display: block; padding: 0.2em 0 0.6em 0;
		}
		.classic { padding: 0.8em 1em; }
		.classic {background: #FFFFAA; border: 1px solid #FFAD33; }
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>

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
       
			<FORM id="myForm" name="myForm" action="searchByIndNameSubmit" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         <tr bgcolor="#E8F6F9">
        	<td width="15%" align="center"  style="color:red;font-size:13px;" class="headngblue" >Search By Industry Name</td>
        </tr>
        </table>

        
		
         <br>
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
        <tr bgcolor="#E8F6F9">
        	<td  align="right"  style="width:50%" class="headngblue">Industry Name:</td>
            <td align="left" >
            <input type="text" class="txt4" id="autocomplete1" size="30" name="autocomplete_parameter1"/>
                        <span class="txt4">(Enter first 3 characters of Industry Name)</span>
            </td>
        </tr>
            <div id="autocomplete_choices" class="autocomplete1" ></div>
        <tr>
             
            <td align="center" colspan="2"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
		</tr>
	</table>		
		<br>
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >             
	  <tr>
	  <td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popSearchByIndustryNameExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
	  <span class="headngblue">Print in Excel Format</span></a>
	  </td>
</tr> 
	  
	    </table>
		
		
		
         
	
<!--  tables for records start-->		

<div style="overflow: auto;height: 600px; width: 1000px;">
<table width=100% align="center" border="2" style="font-weight: inherit;border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr width="100%" bgcolor="#A8DAF3"  >
           
           	       <th align="center" style="width:5%;" class="headngblue" >S.No.</th>
           	       <th align="left" style="width:15%;" class="headngblue" >Office</th>
    	           <th align="left" style="width:20%;" class="headngblue" >Name Of the Unit</th>
    	           <th align="left" style="width:40%;" class="headngblue" >Industry Type<br>Category-Classification</th>
    	           <th align="center" style="width:20%;" class="headngblue" >Action</th>
</tr>
          
            <%if(!allSummaryReportList || allSummaryReportList.size()==0){%>
            <td align="left" colspan="5">No Record Founds..</td>
            <%}%>
           	<g:each in="${allSummaryReportList}" status="i" var="allSummaryReportListInstance">
           	<%
           	    def industryRegMasterListInstance=IndustryRegMaster.get((allSummaryReportListInstance.indRegMasterId).toLong());
           	%>
           	<tr>
           	          <td align="center"><%=(i+1)%></td>
           	          <td align="left"><%=allSummaryReportListInstance.districtName%></td>
           	          <td align="left"><span style="color:blue;"></span><br><%=allSummaryReportListInstance.applicationName%></td>
           	          <td align="left"><%=industryRegMasterListInstance.industryType%><br><i>${industryRegMasterListInstance?.category.name}-${industryRegMasterListInstance?.industryScale}</i></td>
           	          <td align="center">
           	             <%
           	                  def grantApplicationInstance = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.indUser.id=? and applicationStatus!='pending' order by id desc",[industryRegMasterListInstance.id])
	                          if(grantApplicationInstance){%>
		                      <a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/newPage/${industryRegMasterListInstance.id}', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Previous Application Details&nbsp; </span></a>
	                     <%}%>
           	                         	              
           	       <!--        <a target="_blank" href="<%=request.getContextPath()%>/industryMasterDetails/createIndustryMaster?indUserId=<%=industryRegMasterListInstance.id%>"><span class="innerlink"> Prepare Industry Master Data </span></a>
           	              -->
           	          </td>
           	          
           	          
           	</tr>
           	</g:each>
           	       
           	       
        
</table>

</div>
		
            <br />
            <br />
          
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
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTestApplied",{} );             
			 }
</g:javascript>
</html>