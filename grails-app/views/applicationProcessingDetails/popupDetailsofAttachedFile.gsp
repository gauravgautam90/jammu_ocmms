<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
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

</head>

<body >
      <div>
			<table width="95%"  border="1" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				<tr bgcolor="#F4F7FB">
				<td width="10%" align="center" bgcolor="#A8DAF3" class="headngblue">Officer Name</td>
	              
	              <td width="30%" align="center" bgcolor="#A8DAF3" class="headngblue" >Date & Time</td>
	             <td width="30%" align="center" bgcolor="#A8DAF3" class="headngblue" >Attached Report</td>
	             <td width="30%" align="center" bgcolor="#A8DAF3" class="headngblue" >Delete Report</td>
	             
                    </tr>	
        	
        	 
        	<g:each in="${ins}" status="i" var="ins1">
        	
        	  <tr>
        	  
        	  <td height="25" align="center" class="txt4"> <%=ins1.updatedBy%></td>
        	  <td height="25" align="center" class="txt4"><%=ins1.dateCreated%></td>
        	  <td height="25" align="center" class="txt4">
        	  <g:def var="fooVar" value="${ins1.id}"/>
  			  <g:def var="docN" value="${ins1.typeOfFile}"/>
  			 <g:link action="viewOtherAttachedDocument1" params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
  			 <% System.out.println("---fdgfg---"+insForAppProcess.officerFwd)
	  			System.out.println("---rtdggdt---"+ins1.updatedBy) 
  			 if(insForAppProcess.officerFwd.equals(ins1.updatedBy)){
  				System.out.println("---in if---"+insForAppProcess.officerFwd)
	  			System.out.println("---in if---"+ins1.updatedBy) 
  				 %>
  			
  			<td height="25" align="center" class="txt4"><input type="checkbox" name="delete" value="<%=ins1.id%>"/></td>
  			<% } else{ System.out.println("---in else---"+insForAppProcess.officerFwd)
	  			System.out.println("---in else---"+ins1.updatedBy)  %>
  			<td height="25" align="center" class="txt4"></td>
  			 </tr><% }%>
  			
        	  </g:each>     </table>
						
				</div>	
				<br>
				<br>	
						
</body>

<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


