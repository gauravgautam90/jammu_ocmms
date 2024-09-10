<%@ page import="java.text.SimpleDateFormat"%>
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
<table width="50%" align="center" class="print">
	<tr>
	
		<td  class="headngblue" align="right" width="75%"><font size="4"><b>Cess Application Details</b></font>
		</td>
		
		<td width="25%" align="right" class="txt4">
			<a href="#" onclick="window.print();" ><img  height="25" width="25" src="${createLinkTo(dir:'images',file:'Print3.gif')}" border="0" align="center" alt="Print this Form" >Print</a>
		</td>
		
		
		
	</tr>
	
	<tr><!-- Div area for errors-->
                      <td align="center" colspan="2"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${cessReport}">
										<div class="errors">
											<g:renderErrors bean="${cessReport}" as="popConsentReport" />
										</div>
										</g:hasErrors>

                      </span></div></td>
    </tr>
		
</table>	

<table width="80%" align="center" class="print" >
	<tr>
	
		<td  class="headngblue" align="left" width="18%"><font size="2">Industry Name  :</font>
		</td>
		
		<td align="left" width="50%"><font size="3" color="#7D1B7E"><b>${fieldValue(bean:industryName, field:'indName')}</b></font>
		</td>
		
		<td  class="headngblue" align="right" width="22%"><font size="2">Total Applications  :</font>
		</td>
		
		<td align="left" width="4%" ><font size="3" color="#7D1B7E"><b>${cessReport.size()}</b></font>
		</td>
	</tr>
		
</table>	

<table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="print tab-txt" style="border-collapse:collapse;">

             <tr height="20" bgcolor="#A8DAF3">

                 
                   	        
                   	        <th align="center" class="headngblue" >Application No.</th>
                   	        <th align="center" class="headngblue" >Application Date</th>
                   	        <th align="center" class="headngblue" >Cess Applied From</th>
                   	        <th align="center" class="headngblue" >Cess Applied To</th>
                   	     		</tr>
 			
                    <g:each in="${cessReport}" status="i" var="cessReport">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:cessReport, field:'id')}</td>
                        
                            <td align="center" height="25" class="txt4"  ><%=asd1.get(i)%></td>
                        
                            <td align="center" height="25" class="txt4" ><%=asd.get(i)%></td>
                        
                            <td align="center" height="25" class="txt4"  ><%=asd2.get(i)%></td>
                        
                         
                        </tr>
				 </g:each>

                </table>
               
		
            <br />
            <br />
         
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
     
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter" class="print"/>
   
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


