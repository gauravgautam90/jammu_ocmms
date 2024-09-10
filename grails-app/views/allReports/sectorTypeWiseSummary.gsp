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
.mytable
{
font-size:15px;
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
       
			<FORM id="myForm" name="myForm" action="sectorTypeSubmit" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         <tr bgcolor="#E8F6F9">
        	<td width="15%" align="center"  style="color:black;font-size:15px;" class="headngblue">Sector Type-wise List of Industry Profiles <%if(today){%> as on <font color="#800000"><i><%=today%></i></font><%}
        	if(districtOfficeMasterInstance){
        	%><br><font color="#000080">Office : ${districtOfficeMasterInstance}</font>
        	<br><i><font face="Verdana" size="2" color="#800000">(Click on <b>No. of Units</b> to view more details)</font></i>
        	<%
        	}
        	%>
        	</td>
        </tr>
        </table>

        
		
         <br>
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         <tr bgcolor="#E8F6F9">
        	<td  align="right"  class="headngblue">District Office:</td>
            <td align="left" >
           <%
           	def  districtOfficeMasterList = DistrictMaster.list( sort:"districtName", order:"asc")
           %>
           <g:select from="${districtOfficeMasterList}" name="region" id="region" noSelection="${[NotSelected:'NotSelected']}" class="txt4"></g:select>
            </td>
            
            <td align="left"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
        </tr>
	</table>		
		<br>
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
                       
	  <tr>
	  <td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popSectorTypeWiseSummaryExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
	  <span class="headngblue">Print in Excel Format</span></a>
	  </td>
</tr> 
	  
	    </table>

<div style="overflow: auto;height: 600px; width: 1000px;">
<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0" class="mytable">
<tr width="100%" bgcolor="#A8DAF3"  >
           
           	       <th align="center" style="width:5%" class="headngblue" >S.No.</th>
           	       <th align="center" style="width:10%" class="headngblue" >Category</th>
    	           <th align="center" style="width:70%" class="headngblue" >Industry Type</th>
    	           <th align="center" style="width:10%" class="headngblue" >Classification</th>
    	           <th align="center" style="width:5%" class="headngblue" >No. of Units</th>
</tr>
          
           	       <%
           	       def count=0;
           	       def rowCount=0;
           	       def recordCount=0;
           	       
           	       if(districtOfficeMasterInstance)
           	       {
           	           def applicationPendingDetailsRecord=ApplicationPendingDetails.executeQuery("select distinct apd.application.indUser.category.name,apd.application.indUser.industryType.industryType,apd.application.indUser.industryScale,apd.application.indUser.industryType.id from ApplicationPendingDetails apd  where apd.applicationStatus='approved' and  apd.application.indUser.district.id=? order by apd.application.indUser.category.name ,apd.application.indUser.industryScale ,apd.application.indUser.industryType.industryType ",[districtOfficeMasterInstance.id])
                       def industryType=""
                       def industryTypeCaption=""
                       def categoryCaption=""
                       def sNoCaption=""
                       def rowColorString=""
                       for(int kk=0;kk<applicationPendingDetailsRecord.size();kk++)
                       {
                        
	                          def indCount=ApplicationPendingDetails.executeQuery("select count(distinct apd.application.indUser.id ) from ApplicationPendingDetails apd  where apd.applicationStatus='approved' and apd.application.indUser.district.id=? and apd.application.indUser.industryScale=? and apd.application.indUser.category.name=? and apd.application.indUser.industryType.industryType=? ",[districtOfficeMasterInstance.id,applicationPendingDetailsRecord[kk][2],applicationPendingDetailsRecord[kk][0],applicationPendingDetailsRecord[kk][1]])
	                          if(industryType==applicationPendingDetailsRecord[kk][1])
	                          {
	                             industryTypeCaption=""
	                             categoryCaption=""
	                             sNoCaption=""
	                             rowColorString="#DDEEFF"
	                          }
	                          else
	                          {
	                            rowCount++;
	                            industryType=applicationPendingDetailsRecord[kk][1]
	                            industryTypeCaption=applicationPendingDetailsRecord[kk][1]
	                            categoryCaption=applicationPendingDetailsRecord[kk][0]
	                            sNoCaption=""+rowCount
	                            rowColorString="#FFFFFF"
	                          }
	                          
	                       
	                          %>
	                           <tr width="200%" bgcolor="${rowColorString}">
		              	           <td align="center"><%=sNoCaption%></td>
		              	           <td align="left"><%=categoryCaption%></td>
		              	           <td align="left"><%=industryTypeCaption%></td>
		              	           <td align="left"><%=applicationPendingDetailsRecord[kk][2]%></td>
		              	           <td align="center">
		              	                <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/industrySectorTypeWise?districtOfficeId=${districtOfficeMasterInstance.id}&category=${applicationPendingDetailsRecord[kk][0]}&industryTypeId=${applicationPendingDetailsRecord[kk][3]}&classification=${applicationPendingDetailsRecord[kk][2]}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
					                       <font color="blue"><%=indCount[0]%></font>
					                    </a>
		              	           </td>
	              	           </tr>
                              <% 
	                          recordCount+=indCount[0]
                       }
           	       }
           	       if(rowCount==0)
           	       {
            	    	  %> <tr><td colspan="5">No Records...</td></tr> <%   
            	   }
            	   else
            	   {
            	          %> <tr bgcolor="#A8DAF3"><td align="center" colspan="4">Total</td><td align="center"><%=recordCount%></td></tr> <%   
            	   }
           	       %>
           	       
           	       
        
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
</html>