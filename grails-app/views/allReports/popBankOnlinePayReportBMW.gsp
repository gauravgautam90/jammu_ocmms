<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!----------------------added by saroj---for audit issue--resolved------------------>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="X-Frame-Options" content="deny">

<style id="antiClickjack">body{display:none !important;}</style>

<script type="text/javascript">
if (self === top) {
    var antiClickjack = document.getElementById("antiClickjack");
    antiClickjack.parentNode.removeChild(antiClickjack);
} else {
    top.location = self.location;
}
</script>
<!-------------------------end------------------------------>
<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=BMW MIS Report(Online).xls");
%>
<%@ page import="java.text.*" %>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



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
<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

</head>


<body >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >

<tr>
 <td colspan="8" align="center" >
 <span class="headngblue">
 <span style="color:red;font-size:15px;">MIS Report(Online)</span> 
 </span>
 </td>
</tr> 

<tr>
 <td colspan="8" align="center" >
 <span class="headngblue">
 <span style="color:red;font-size:15px;">Date:${date1} - ${date2}</span> 
 </span>
 </td>

 
</tr>                    
</table>



<div>


<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">


         
         
<tr width="100%" bgcolor="#FFFFCC"  >
     <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='5%'>S.No</th>
     <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Application No</th>
     
     <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Transiction Id</th>
     <th align="center" style="border-bottom:3px solid green;"  class="headngblue" width='10.5%'>Transiction Type</th>
     <th align="center" style="border-bottom:3px solid green;" class="headngblue" width='18%'>Amount</th>
     <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='50%'>Transiction Date</th>
	 <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='18%'>Application Name</th>
	 <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='18%'>Application For</th>
	 <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='18%'>Distric Name</th>
	 <th align="center" style="border-bottom:3px solid green;"  class="headngblue"  width='18%'>Group Nmae</th>
	 

   
<% float amount=0.0f
                  
                  %>
<%
if(!bankTransaction)
{
	 %>
	    <tr><td colspan="6" >No Records Found...</td></tr>
	 <%
}
%>

<g:each in="${bankTransaction}" status="i" var="abc">
<%
amount=amount+Float.valueOf(abc.amount)

def pendingApp=WasteManagementPendingDetails.find("from WasteManagementPendingDetails wm where wm.applicationId=?",[(abc.bioApplication.id).toString()])
%>

<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
   
 		 <td align="center" height="25" class="txt4" ><%=(i+1)%></td>
 		 <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'bioApplication.id')}</td>
 		
 		 <td align="center" height="25" class="txt4" ><%=abc.id%></td>
 		 <td align="center" height="25" class="txt4" ><%=abc.paymentType%></td>
         <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'amount')}</td>
         <td align="center" height="25" class="txt4" ><%=abc.dateCreated%></td>
         <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'bioApplication.industryRegMasterObj.indName')}</td>
         <td align="center" height="25" class="txt4" >${fieldValue(bean:pendingApp, field:'applicationFor')}</td>
         <td align="center" height="25" class="txt4" >${fieldValue(bean:abc, field:'bioApplication.industryRegMasterObj.district.districtName')}</td>
         <td align="center" height="25" class="txt4" >${fieldValue(bean:pendingApp, field:'role.group.groupName')}</td>
        
    	</tr>
</g:each>
     <tr>
     <td align="center" height="25" class="txt4" colspan='10'>Total Amount-<%if(amount>=100000){%><%=amount/100000%>Lakh<%} else{ %><%=amount%><% }%></td>
     </tr>
</table>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>