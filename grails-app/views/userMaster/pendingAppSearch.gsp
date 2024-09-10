<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<g:javascript library="prototype" />
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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>




<script type="text/javascript" src="js/tabcontent.js"></script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>





<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF >
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
		<g:include controller="userMaster" action="showMenu"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			
							<g:include controller="userMaster" action="showIndexMenu"/>            

                            
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>  
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" width="100%">
					<table width="100%" border="0" >
						 <tr height="10px" width="100%">
						 	<td></td>
						 	<td class="top-lnks" align="right">  </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
							
							<td width="80%">&nbsp;</td>
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
				                     <g:if test="${flash.message}">
									<div class="message">${flash.message}</div>
									</g:if>
									<g:hasErrors bean="${officeMasterInstance}">
									<div class="errors">
										<g:renderErrors bean="${officeMasterInstance}" as="list" />
									</div>
									</g:hasErrors>

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		<g:form action="search" name="myform" method="post" >
		
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search Application</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
			
			<tr>
			<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio name=searchOp value="ApplId" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> ><span class="headngblue">By Application Id</span></td>
			
			</tr>
			
          <tr  >
            <td width="20%" class="headngblue"  bgcolor="#E8F6F9"   align="left" >Application Id:</td>
            <td align="left" colspan="3" bgcolor="#E8F6F9">
          
            <input type="text" class="txt4" id="autocomplete" size="30" name="autocomplete_parameter"/>
           
            <span class="txt4">(Enter application ID)</span></td>
			
          </tr>
          <tr align="center">
          

			<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio  name=searchOp value=Others checked="checked"><span class="headngblue">By Other Criteria</span></td>
			</tr>
       
			<tr  bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >From Date:*</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="frmDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">To Date:*</td>
                        <td align="left" width="37%"  >
					
							
							<calendar:datePicker name="toDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
              
                      <input type="hidden" id="pendingWith" name="pendingWith" value="None">
                      <input type="hidden" id="group" name="group" value="None">
	  </table>
	  
	  
	   <table width="100%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
			
			
		  </tr>
 
		</table>
 			
		
		
		
		
            <br />
           
          </div>
		  
		
		
		</g:form>
          

          </div>	  
          </div>
          <%if(indList){%>
          <table width="110%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
          <tr ><td bgcolor="#FFFFFF" align="right">
          <a href="popupex.html" onclick="return popitup('<g:createLink action="printConditionalPage" params="[indList:indList]" ></g:createLink> ')"><span
																class="headngblue">Print in Excel</span></a> </td>
          </tr>
          </table>
          <%}%>
          
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">

		  <tr>
		    <td bgcolor="#FFFFFF"><table width="110%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	       
							<th class="headngblue" align="center">SI. No.</th>
							<th class="headngblue" align="center">Application No.</th>
							<th class="headngblue" align="center">Application Name</th>
							<th class="headngblue" align="center">Application Type</th>
							<th class="headngblue" align="center">District</th>
							<th class="headngblue" align="center">Application Date</th>
							 <th align="center" class="headngblue" >Last Submission Date(Clarification)</th>
							<th class="headngblue" align="center">Last Forwarded  Date</th>
							<th class="headngblue" align="center">Application For</th>
							<th class="headngblue" align="center">Certificate For</th>
						 	
						 	<th class="headngblue" align="center">Dealing Group</th>
						 	
						 	
                   	   
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    
                    
                    
                   <%if(!indList){ %><tr><td colspan="10" height="25" align="center" class="txt4"></td></tr><%} 
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
                       	 <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.districtName%></font></b></td>
                         
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
                            
                          </tr>
                      </table></td>
                    </tr>
                     <tr>
                         <td> <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="right" alt="ADD OFFICE" ></img></td>
                        <td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Clarification raised on this application.</font></td>
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
</table>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>
 
