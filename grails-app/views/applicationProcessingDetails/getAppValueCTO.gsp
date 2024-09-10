<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
SimpleDateFormat sdfDestination1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>

<script>if (top != self) top.location=location</script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

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

<g:javascript library="prototype" />
<g:javascript>
function createRow(){

alert("hi");
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'templateCess.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>






<%
String cont=request.getContextPath();
 if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(cont+"/index.gsp")  ;     
} %>

</head>

<body >

              
              <tr>
              
                <td height="0" align="center" valign="top" ><table align="center" width="100%" border="0" cellspacing="0" cellpadding="0">
                 
                 
                 
                    <tr>
					
					<!-- Div area for errors-->
                      
					  <td align="center" valign="top"><div style="width:400px;  vertical-align:middle">
					  <span class="error">
						<g:if test="${flash.message}">
						<div class="message">${flash.message}</div>
						</g:if>
						<g:hasErrors bean="${cessReturnInstance}">
						<div class="errors">
						<g:renderErrors bean="${cessReturnInstance}" as="list" />
						</div>
						<
						</g:hasErrors>

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="center" valign="top" class="middlespacer"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="center" valign="top">&nbsp;</td>
                            <td align="center" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
			<br/>
       
         <div align="center" style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="950" border="0" align="center" cellpadding="0" cellspacing="0">
   
             
					 <tr>
        <td  align="center">
        
              
             <%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
                               
 
  	
 }%>
  
 
					
					</td>
							
							
					   </tr>
        </table>
		
		
		<g:form name="myform"  id="1">
		 
		 
		
	
  			
  			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				    <tr> 
				   <% if(allSummaryReportList.size() != 0){ %>
				    <td  align="left"><font color="red"><%=allSummaryReportList[0].officerName%> </font></td>
				   <%}%>
				    <td  align="center"><span class="headingblue"><font color="red">Application Details</font></span></td>
				     <td  align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:window.print()">Print</a></td>
				    </tr>                  
                      <tr>
                       
                       
                        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                            <th class="headngblue" align="center">S.No</th>
							<th class="headngblue" align="center">Industry Name</th>
							<th class="headngblue" align="center">Category</th>
							<th class="headngblue" align="center">Classification</th>
							<th class="headngblue" align="center">Application Id</th>
							<th class="headngblue" align="center">Application Type</th>
							<th class="headngblue" align="center">Certificate For</th>
							<th class="headngblue" align="center">Officer Name</th>
                   	      	<th class="headngblue" align="center">View Application Form</th>
                   	    	   
                        </tr>
                    </thead>
                    <tbody>
                    <%
                   	if(allSummaryReportList.size()==0){ %><tr><td colspan="10" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${allSummaryReportList}" status="i" var="allSummaryReportInstance">
                         <%
                        def indRegMaster=IndustryRegMaster.get((allSummaryReportInstance.indRegMasterId).toLong())
                   
                         %>
                    
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td align="center" height="25" class="txt4" >${(i+1)}</td>
                            <td align="center" height="25" class="txt4" >${allSummaryReportInstance.applicationName}</td>
                            <td align="center" height="25" class="txt4" >${indRegMaster.category.name}</td>
                            <td align="center" height="25" class="txt4" >${indRegMaster.industryScale}</td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">
                        	 <a href="<%=request.getContextPath()%>/applicationProcessingDetails/openApplicationDetails/<%=allSummaryReportInstance.applicationId%>" target="_blank">	
								${allSummaryReportInstance.applicationId}
                        	</a></font></td>
                            <td align="center" height="25" class="txt4" >${allSummaryReportInstance.applicationType}</td>
                            <td align="center" height="25" class="txt4" >${allSummaryReportInstance.certificateFor}</td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.officerName} </font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red"> 
                        	<a href="<%=request.getContextPath()%>/indApplicationDetails/doGetShowPop/<%=allSummaryReportInstance.applicationId%>" target="_blank">	
								View Application Form
                        	</a></font></td>
                        	
                         
                        </tr>
                    </g:each>
                
                    </tbody>
      </table>
     </td>
							
						</tr>
	   
		</table>
		
		
      </td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
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
	
    </table></td>
  </tr>
</table>
 </g:form>
<!-- </form> -->



</body>
 <!-- <HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD> -->
</html>


