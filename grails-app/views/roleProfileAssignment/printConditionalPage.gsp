<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
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
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
			 }
</g:javascript>


<script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
	}
</script>


<% 
	String cont2=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont2+"/index.gsp")	;	
	 } %>



</head>

<body >
<table width="70%" align="center" >
	<tr>
		<td  class=" print headngblue" align="right" width="70%" ><font size="5"><b>Summary Report</b></font>
		</td>
		<td width="30%" align="right" class="txt4">
			<a href="#" onclick="window.print();return false;" ><img  height="25" width="25" src="${createLinkTo(dir:'images',file:'Print3.gif')}" border="0" align="center" alt="Print this Form" >Print</a>
		</td>
	</tr>
		
</table>

<table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="print tab-txt" style="border-collapse:collapse;">
				
				 <tr><td colspan="7" class="headngblue" align="left">${levlPrint}</td></tr>
                  <tr height="20" bgcolor="#A8DAF3">

                        
                   	        <th align="center" class="headngblue" >Id</th>
                        
                   	        <th align="center" class="headngblue" >Application Name</th>
                   	        <th align="center" class="headngblue" >Application Type</th>
                   	        <th align="center" class="headngblue" >Application For</th>
                   	        <th align="center" class="headngblue" >Application Date</th>
                   	        
                   	        <th align="center" class="headngblue" >Certificate For</th>
                   	     <th align="center" class="headngblue">District</th>
							<th align="center" class="headngblue">Category</th>
							<th align="center" class="headngblue">Details of applicant</th>
                   	     	<th align="center" class="headngblue">Pending Since</th>
                        
                        
                   	        </tr>

                    <g:each in="${listVal}" status="i" var="abc">
                    	
<%	String consentFor = abc.certificateFor
                    
                    if(consentFor.equals("new")){
                    consentFor="Fresh"
                    }
                    if(consentFor.equals("Modern")){
                    consentFor = "Modernization "
                    }
                    if(consentFor.equals("expan")){
                    consentFor = "Expansion"
                    }
                    if(consentFor.equals("reNew")){
                     consentFor = "Renew"
                    } %>
                    	
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}" >
                       
                            <td align="center" width="10%" height="25" class="txt4"  >${fieldValue(bean:abc, field:'id')}</td>
                        
                            <td align="left" width="20%" height="25" class="txt4"  >&nbsp;${fieldValue(bean:abc,
																field:'applicationName')}</td>
                        
                            <td align="center" width="10%" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationType')}</td>
                        
                            <td align="center" width="10%" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationFor')}</td>
                        
                            <td align="center" width="10%" height="25" class="txt4"  >${fieldValue(bean:abc, field:'applicationDate')}</td>
                        	<td align="center" width="10%" height="25" class="txt4"  ><%=consentFor%></td>
                        	<td align="center" width="10%" height="25" class="txt4"  >${fieldValue(bean:abc, field:'indUser.district.districtName')}</td>
                        	<td align="center" width="10%" height="25" class="txt4"  >${fieldValue(bean:abc, field:'indUser.category.name')}</td>
                        	<td align="center" width="10%" height="25" class="txt4"  >Address:- ${fieldValue(bean:abc,field:'indUser.occAddress')}<br>
							Email ID:- ${fieldValue(bean:abc,field:'indUser.occEmail')}<br>
							Phone No:- ${fieldValue(bean:abc,field:'indUser.occPhoneNo')}</td>
                        	<td align="center" width="10%" height="25" class="txt4"  >${diffList.get(i)
																} &nbsp;Days</td>
                        	
                        	
                    </g:each>
					
					

                </table>
		
		
		


													  <br />
            <br />
         
	  

     
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
   
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


													