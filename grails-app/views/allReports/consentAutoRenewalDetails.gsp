<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.SimpleDateFormat" %>

<%
java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
       
			<FORM id="myForm" name="myForm" action="consentAutoRenewalRecord" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         <tr bgcolor="#E8F6F9">
        	<td width="15%" align="center"  style="color:red;font-size:13px;" class="headngblue" >Consent Auto-Renewal Report List </td>
        </tr>
        </table>

        
		
         <br>
         <table width="100%"  border="0" align="center" cellpadding="5" cellspacing="1" class="tblbdr">
       	
        <tr align="center">
		    <td colspan="4" bgcolor="#A8DAF3" align="left">
		        <input type=radio  name=searchOp value=Others checked="checked">
		             <span class="headngblue">By Date Criteria</span>
		    </td>
		</tr>
      
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
	<table width="100%" align="center">
    <tr>
     <td  width="100%" align="center" >
       <div width="100%" align="center" ><br>
            <input type="submit" name="save" value="Search" class="actionbutton" >
       </div>
      </td>
    </tr>
    </table>
		<br>
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

         def  dmyFormat = new SimpleDateFormat("dd/MM/yyyy");

         dd1=dmyFormat.format(utilDate1);
         dd2=dmyFormat.format(utilDate2);
         dd3=dmyFormat.format(utilDate3);
         }
         %>
         
         <td colspan="9" align="center"><span class="headngblue"> 
         <% if(indTypeInstance) {%>
                 Industry Type: <font color="red"> <%=indTypeInstance%></font>&nbsp;&nbsp;&nbsp;&nbsp;
         <% }else if(sqlDate || sqlDate2){%>
                From   Date: <font color="red"> <%=dd1%></font> To &nbsp;&nbsp;Date: <font color="red"> <%=dd3%></font>&nbsp;&nbsp;&nbsp;&nbsp;
         <%}%>
         </span>

         </td>
         </tr> 
        <tr><td></td></tr>      
     
	  <tr>
	  <td colspan="9" align="right" >
	    <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/consentAutoRenewalRecord/?type=Preview&start_date_value=<%=dd1%>&end_date_value=<%=dd3%>', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" ><span class="headngblue">Print Preview</span></a> | 
	    <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/consentAutoRenewalRecord/?type=Excel&start_date_value=<%=dd1%>&end_date_value=<%=dd3%>', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" ><span class="headngblue">Print In Excel</span></a>
	  
	  </td>
	  </tr> 
	    </table>
		
		
		
         
	
<!--  tables for records start-->		

<div style="overflow: auto;height: 600px; width: 1000px;">
<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr width="100%" bgcolor="#A8DAF3"  >
           
<th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >S.No.</th>
	<th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Application Date</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Application Id</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Name of Unit/Industry</th>
    
    <!---kripal---->
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Address</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >District</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Block</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Application for</th>
    
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Category</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Industry Type</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Date of Auto-Renewal</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Valid upto date of auto renewal</th>      
    <%--
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">insppection status</th>--%>
    	       
</tr>
          
<% 
   
   
   def count=0;
if(sqlDate){
     	 System.out.println("dhgsdfger1 "+sqlDate)
     	 System.out.println("dhgsdfger2 "+sqlDate2)
     	 def indApplicationDetailsIs=IndApplicationDetails.findAll("from IndApplicationDetails abc where abc.applicationDate>= ? and abc.applicationDate<= ? and completionStatus='completed' and applicationType='CTO' and certificateFor='autoReNew'",[sqlDate,sqlDate2])
	     def endDate
	     def approveDate
	     def productDetailsList
	     def airStackEquipmentInst
	     def fuelName
	     def etp
         for(int kk=0; kk<indApplicationDetailsIs.size();kk++){
    	  endDate = AutoRenewDetails.find("from AutoRenewDetails where application.id=?",[(indApplicationDetailsIs.id.get(kk).toLong())]);
          if(endDate){ %>
  
          <tr width="200%" style="color:black">
            <td align="center"><%=(++count)%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).applicationDate%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).id%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).indUser.indName%></td>
            
            <td align="center"><%=indApplicationDetailsIs.get(kk).indUser.indAddress%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).indUser.district.districtName%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).indUser.tehsil.tehsilName%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).applicationFor%></td>
            
            
            
            <td align="center"><%=indApplicationDetailsIs.get(kk).indUser.category.name%></td>
            <td align="center"><%=indApplicationDetailsIs.get(kk).indUser.industryType%></td>
            <td align="center"><%=endDate.startDate%></td>
            <td align="center"><%=endDate.endDate%></td>
     <%--
            <%if(indApplicationDetailsIs.get(kk).inspection){%>
            <td align="center">Inspection Raised</td>
         <%}else{%>
            <td align="center">Inspection Closed</td>
         <%}%> --%>
         </tr>
       <%}
       }
  }else{%>
           	    <tr><td colspan="12">No Records...</td></tr>
           	       <%}%>
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

<script language="JavaScript" type="text/javascript">

var frmvalidator  = new Validator("myForm");
frmvalidator.EnableFocusOnError(false); 
frmvalidator.EnableMsgsTogether();  




//frmvalidator.addValidation("region","dontselect=0","Please select industry Type");

</script>
</body>
</html>