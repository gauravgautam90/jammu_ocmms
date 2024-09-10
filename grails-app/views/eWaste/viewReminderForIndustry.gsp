<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


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



</head>
<body>




<g:form name="myform" method="post" action="send" >

<table width="95%">
												
			<input type="hidden" id="application" name="application" value="<%=appClarification.application%>"  />										
													
											<tr>
					<td><span class="txt" style="color: navy"><b>List of Reminders.</b></span>
					<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr" width="100%">
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="10%" align="center" class="headngblue" ><div  class="style3">Date Time</div></td>
                                               <td width="10%" align="center" class="headngblue" ><div  class="style3">Notice Type</div></td>
                        
                       <td width="10%" align="center" class="headngblue" ><div  class="style3">Clarification/Show Cause Notice Details:</div></td>
                                             <td width="10%" align="center" class="headngblue" ><div  class="style3">Download Clarification Attachment:</div></td>
                      
                      </tr>
 <%
 def rInstance = ClarificationReminderDetails.findAllByApplication(appClarification.application)

 if(rInstance){%>
 <g:each in="${rInstance}" status="i" var="stackDetInst">
  <tr align="center" >
  					<% 
                       
                      
                        SimpleDateFormat sdfDestination1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate1 = sdfDestination1.format(stackDetInst.dateCreated );
                        %>
                        <td bgcolor="#E8F6F9"><span class="txt4">${strDate1}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt4"> ${appClarification.noticeType}
                        </span></td>
                        <td bgcolor="#E8F6F9"><span class="txt4">${stackDetInst.reminderMessage}
                        </span></td>
                      
                      
                 <td bgcolor="#E8F6F9" colspan="5" class="headngblue">		    
                        
                         <%           
                   def applicationDocumentL=ReminderDocuments.find("from ReminderDocuments apd where apd.reminder.id=? and apd.level='reminderAttachment' ",[stackDetInst.id.toLong()])

 
  if (applicationDocumentL){%>
													
						<g:def var="fooVar1" value="${applicationDocumentL.id}"/>
						 <g:link action="viewNewFile"	params="[appliLoc:fooVar1,docType:'pdf']" >&nbsp;&nbsp;&nbsp;<i><u>Download</g:link>
					
							
						<%}%> </td>
                     
                       
                              
        </tr>	
        	
				</g:each>							
											
								<%}%>			
												</table>
												
												
												
												
												
												
												
</g:form>


 </body>