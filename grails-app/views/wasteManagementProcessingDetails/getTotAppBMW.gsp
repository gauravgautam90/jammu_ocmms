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
<title>SPCB Admin Home</title>


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
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
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
				    <%if(allSummaryReportList.size()>=0){%>
				    <td  align="left"><font color="red"><%=allSummaryReportList[0].officerName%></font></td>
				   <%}%>
				    <td  align="center"><span class="headingblue"><font color="red">Application Details</font></span></td>
				     <td  align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:window.print()">Print</a></td>
				    </tr>                  
                      <tr>
                       
                       
                        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                            <th class="headngblue" align="center">S.No</th>
							<th class="headngblue" align="center">Application No</th>
							<th class="headngblue" align="center">Application Date</th>
							<th class="headngblue" align="center">Industry Name</th>
							<th class="headngblue" align="center">Application Type</th> 
							<th class="headngblue" align="center">Certificates for</th>
							<th class="headngblue" align="center">Officer Name</th>
							<%if(!params.status || params.status=="received"){
	                       %><th class="headngblue" align="center">Status</th><% 
	                       }else if(params.status=="approved" || params.status=="issued" ){
	                        %><th class="headngblue" align="center">Issue Date & Valid Date </th><%
	                       }else if(params.status=="rejected"){
	                        %><th class="headngblue" align="center">Rejected Date </th><%
	                       }else if( params.status=="pending"){
	                        %><th class="headngblue" align="center">Pending With Officer Since</th>
                   	    	 <th class="headngblue" align="center">Pending With Board Since</th><%
	                       }%>
							<th class="headngblue" align="center">View Application Form</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%
                   		SimpleDateFormat sdfDestination1 = new SimpleDateFormat("dd-MM-yyyy hh:mm");

					
                    if(allSummaryReportList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${allSummaryReportList}" status="i" var="allSummaryReportInstance">
                        <% 
                            int pendingWithOfficer=0;
                            int pendingWithBoard=0;
                            Date today = new Date();
                            def  appRecieveDate = allSummaryReportInstance.authDate
                            def  appRecieveDate1 = allSummaryReportInstance.pendingSince
                            def diff = today.getTime() - appRecieveDate1.getTime();
                            pendingWithOfficer=diff / (1000*60*60*24)
                            diff = today.getTime() - appRecieveDate.getTime();
                            pendingWithBoard=diff / (1000*60*60*24)  
                            
                            
                            def status="" 
                            
		                       if(!params.status || params.status=="received")
							   {
			                       if(allSummaryReportInstance.applicationStatus=="approved")
			                       {
			                          status="Granted"
			                       }
			                       else if(allSummaryReportInstance.applicationStatus=="rejected")
			                       {
			                          status="Refused"
			                       }
			                       else
			                       {
			                          status=allSummaryReportInstance.applicationStatus 
			                       }
			                       
			                   }
							  
							   else if(params.status=="rejected")
							   {
			                        def ApplicationProcessingDetailsInstances= ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application.id = ? and reject=true order by dateCreated desc",[(allSummaryReportInstance.applicationId).toLong()])             
									   
									   if(ApplicationProcessingDetailsInstances)
									   {
									     
										 status=sdfDestination1.format(ApplicationProcessingDetailsInstances.dateCreated)
									   }
									   
			                    }                        
                        %>
                        
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${(i+1)}</font></td>
                           <td align="center" height="25" class="txt4"><font face="Verdana" color="red"> 
                        	<a target="_blank" href="<%=request.getContextPath()%>/applicationProcessingDetails/openApplicationDetails/<%=allSummaryReportInstance.applicationId%>" target="_blank">	
								${allSummaryReportInstance.applicationId}
                        	</a></font></td>
                            <td align="center" height="25"  class="txt4"><font face="Verdana" color="red"><%=sdfDestination.format(allSummaryReportInstance.authDate)%></font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.applicationName}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.applicationFor}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.authorizationtype}</font></td>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red">${allSummaryReportInstance.officerName} ${roleName}</font></td>
                            <%if(!params.status || params.status=="received" || params.status=="issued" || params.status=="rejected" || params.status=="approved" ||params.status=="returned"){%>
                            <td align="center" height="25" class="txt4"><font face="Verdana" color="red"> ${status}</font></td>
                        	<%}else{%>
                        	<td align="center" height="25" class="txt4"><font face="Verdana" color="red"> ${pendingWithOfficer} Days</font></td>
                        	<td align="center" height="25" class="txt4"><font face="Verdana" color="red"> ${pendingWithBoard} Days</font></td>
                        	<%}%>
                        	<td align="center" height="25" class="txt4"><font face="Verdana" color="red"> 
                        	<a href="<%=request.getContextPath()%>/bioMedicalWaste/showNewFormat1/<%=allSummaryReportInstance.applicationId%>" target="_blank">	
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


<!--
<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("id","req","Please enter userId");
 frmvalidator.addValidation("id","emp_valid","Enter valid userId");
 frmvalidator.addValidation("employeeFirstName","alpha_s","enter valid firstname");
 frmvalidator.addValidation("employeeFirstName","req","Please enter first name");
 
 frmvalidator.addValidation("employeeLastName","alpha_s","enter valid lastname");
 frmvalidator.addValidation("employeeLastName","req","Please enter last name");
 
 frmvalidator.addValidation("email","email","Enter valid email");
  frmvalidator.addValidation("email","req","please enter email-id");


 
  frmvalidator.addValidation("officePhone","numeric","phone number must be numeric");
  frmvalidator.addValidation("officePhone","req","Please enter phone number"); 
  frmvalidator.addValidation("officePhone","minlen=5","phone number must be less than or equal to 11 digits"); 
  
   frmvalidator.addValidation("mobile","req","please enter Mobile no.");
 frmvalidator.addValidation("mobile","numeric","Mobile no. must be numeric");
 frmvalidator.addValidation("mobile","minlen=10","Please enter valid mobile number");

   frmvalidator.addValidation("designation","req","Please enter designation");
 frmvalidator.addValidation("password","req","please press generate button for password");
 
 frmvalidator.addValidation("hintAnswer","req","enter hintAnswer");
 
  frmvalidator.addValidation("radiobutton","selone_radio","plz select whether you want to sendMail or not");
 
 function ignoreSpace(String){
 
  var temp = "";
  string = '' + string;
	splitstring = string.split(" ");
	for(i = 0; i < splitstring.length; i++)
	temp += splitstring[i];
	return temp;
 }
 
</script> 
-->

</body>
 <!-- <HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD> -->
</html>


