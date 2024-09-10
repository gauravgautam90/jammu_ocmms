<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%@ page contentType = "application/vnd.ms-excel" %>
<% response.setContentType("application/vnd.ms-excel"); 
response.setHeader("Content-Disposition", "inline;filename=pendingApplicationList.xls");
%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF>
          <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
     <tr>
     	<b><font face="Verdana" color="green">Consent Applications Under Process</b></font>
     	
     	
     </tr>
     
	    </table>
  			<table width="110%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">

		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	      <th class="headngblue" align="center">SI. No.</th>
							<th class="headngblue" align="center">Application No.</th>
							<th class="headngblue" align="center">Application Name</th>
							<th class="headngblue" align="center">Application Type</th>
							<th class="headngblue" align="center">Application Date</th>
							 <th align="center" class="headngblue" >Last Submission Date(Clarification)</th>
							<th class="headngblue" align="center">Last Forwarded  Date</th>
							<th class="headngblue" align="center">Application For</th>
							<th class="headngblue" align="center">Certificate For</th>
						 	<!--<th class="headngblue" align="center">Pending With</th>-->
						 	<th class="headngblue" align="center">Dealing Group</th>
                   	  
                        </tr>
                    </thead>
                    <tbody>
                    
                   <%System.out.println("indList..."+indList)
                   if(!indList){ %><tr><td colspan="9" height="25" align="center" class="txt4"></td></tr><%} 
                   else{
                    
                   %>
                   <g:each in="${indList}" status="i" var="aa">
                   <% 
                   def indAppInst = IndApplicationDetails.get(aa.applicationId.toLong())
                   
                   SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");
                    straDate = sdfDestination.format(aa.applicationRecieptDate);
                
                    String classToPick="#CD5B45";
                   
                   %>
                   <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                   	<td height="25" align="center" class="txt4"><b>${i+1}.</b></td>
                   	
                      <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationId%></font></b></td>
                      <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationName%></font></b></td>
                      	 <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationType%></font></b></td>
                     <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=straDate%></font></b></td>
                     
                      <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.lastClarificationDate%></font></b></td>
                     
                      	 <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.lastForward%></font></b></td>
                       <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationFor%></font></b></td>
                      	<td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.certificateFor%></font></b></td>
                     	<td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.groupName%></font></b></td>
                       <%if(indAppInst.clarification){ %>
                       <td align="center" height="25" class="txt4"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img></a></td>
                        <%} %>
                       
                       
                       
                   </tr>
               </g:each>
                    <%}%>
                    </tbody>
      </table>
  	
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            
                         
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>
 
