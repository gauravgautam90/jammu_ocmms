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
String cont=request.getContextPath();
 if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(cont+"/index.gsp")  ;     
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
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
	    <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
		<%} %>
        <% 
 		if((UserMaster)session.getAttribute("userMaster")){
 		UserMaster aa = (UserMaster)session.getAttribute("userMaster");
		String userType = aa.accessLevel
		if(userType.equals("admin")) { %>   

	    <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

        <% }else{ %>
		<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
		<%}} %>
		<% if( (!(IndUser)session.getAttribute("indUser") ) && 
		(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
		<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
		<% } %>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
          <!-- Start of menuAdmin-->
					<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" action="cessIndustryMenuVertical"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="cessAdminMenuVertical"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="cessEmpMenuVertical"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>
                          <%
  IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            	String indname=ind.indName;
             
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               
              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					
					<table width="100%" bgcolor="#4C8BC0">
						 <tr >
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
				</td>
              </tr>
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr>
							
					<td  align="left">
					  <% if((UserMaster)session.getAttribute("userMaster")){
						  
					  } else {%>
					<g:if test="${feeCheck}">
					<a href="<%=request.getContextPath()%>/cessReturn/sendingFeeDetails?appliId=<%=cessReturnInstance.id%>"><span class="innerlink">&nbsp;Send Fee Details&nbsp;|</span></a>
					</g:if>
					<%} %>
					<g:if test="${checkFeesView}">
					<a href="<%=request.getContextPath()%>/cessReturn/viewFeePaySlip?appliId=<%=cessReturnInstance.id%>"><span class="innerlink">&nbsp;View Water Cess Pay in slip&nbsp;</span></a>
					</g:if>
					<%if(cessReturnInstance.assessmentIssue){ %>
					<a href="<%=request.getContextPath()%>/cessReturn/viewAssessIssue?appliId=<%=cessReturnInstance.id%>"><span class="innerlink">&nbsp;View Pre Assessment Notice&nbsp;</span></a>
					<%} %>
					<%if(cessReturnInstance.assessmentOrder){ %>
					<a href="<%=request.getContextPath()%>/cessReturn/viewAssessOrder?appliId=<%=cessReturnInstance.id%>"><span class="innerlink">&nbsp;View Assessment Order&nbsp;</span></a>
					<%} %>
					<%if(cessReturnInstance.feesNotice){ %>
					<a href="<%=request.getContextPath()%>/cessReturn/viewFeesDefauterNotice?appliId=<%=cessReturnInstance.id%>"><span class="innerlink">&nbsp;View Fee Defaulter Notice&nbsp;</span></a>
					<%} %>
					</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
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
                      <td height="0" align="left" valign="top" class="middlespacer"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
			<br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		<g:form name="myform"  id="1">
		 
		 
		 <input type="hidden" name="indRegId" value="${industryRegId?.id}" />
		 <input type="hidden" name="cessReturnId" value="${cessReturnInstance?.id}" />
               
	<!-- <form action="save" method="post" name="myform" > -->	
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="110" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Cess Return</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="490" align="right"></td>
							
						</tr>
	  
		</table>
       <div id="country1" >
       
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
			 <% 
                       
   						 def yr=((cessReturnInstance.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessReturnInstance.cessAppliedFromDate).getMonth()+1).toString()
						
			if (mon=="1"){
				mon = "January"
			}else if(mon=="2"){
				mon = "February"
			}else if(mon=="3"){
				mon = "March"
			}else if(mon=="4"){
				mon = "April"
			}else if(mon=="5"){
				mon = "May"
			}else if(mon=="6"){
				mon = "June"
			}else if(mon=="7"){
				mon = "July"
			}else if(mon=="8"){
				mon = "August"
			}else if(mon=="9"){
				mon = "September"
			}else if(mon=="10"){
				mon = "October"
			}else if(mon=="11"){
				mon = "November"
			}else if(mon=="12"){
				mon = "December"
			}
			
			def fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessReturnInstance.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessReturnInstance.cessAppliedToDate).getMonth()+1).toString()
							
			if (mon1=="1"){
				mon1 = "January"
			}else if(mon1=="2"){
				mon1 = "February"
			}else if(mon1=="3"){
				mon1 = "March"
			}else if(mon1=="4"){
				mon1 = "April"
			}else if(mon1=="5"){
				mon1 = "May"
			}else if(mon1=="6"){
				mon1 = "June"
			}else if(mon1=="7"){
				mon1 = "July"
			}else if(mon1=="8"){
				mon1 = "August"
			}else if(mon1=="9"){
				mon1 = "September"
			}else if(mon1=="10"){
				mon1 = "October"
			}else if(mon1=="11"){
				mon1 = "November"
			}else if(mon1=="12"){
				mon1 = "December"
			}
			def toDate=mon1+"/"+yr1
                        
                        %>
				<tr>
                  <td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Cess Applied From :</td>
				  <td width="25%" align="left" bgcolor="#E8F6F9"  class="headngblue"><%=fromDate%></td>
				  	  <td  width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Cess Applied To :</td>
					<td width="25%"  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<%=toDate%>
					</td>
				 
			  </tr> 
				   
				
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'indName')}
					 
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue txt4">${fieldValue(bean:industryRegId, field:'indAddress')}</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Plot No./Khata * : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'plotNo')}
					 
                    </td>
                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${fieldValue(bean:industryRegId, field:'indCity')} 
					  
					</td>
				</tr>        
				    
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${fieldValue(bean:industryRegId, field:'district')}
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'indPin')}
					
					</td>
				</tr>        
				
			
	</table>
	<g:if test="${cessDetailList}"> 
	
	<g:each in="${cessDetailList}" status="i" var="cessDetailInstance">
	<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
	<tr>
		<td  align="left" valign="middle" bgcolor="#A8DAF3" colspan="2" class="headngblue">Purpose of which Water Consumed   :</td>
					<td  align="left" bgcolor="#E8F6F9" colspan="5" class="headngblue">
					  ${cessDetailInstance?.waterConsumptionPurposeMaster?.purpose }
					</td>
	</tr>
	<tr bgcolor="#A8DAF3" class="headngblue"><td >Source Of Consumption</td><td>Meter Reading</td><td>Start Reading</td><td>End Reading</td><td>Quantity (Kl)</td><td>Water Quantity(3 Month Avg.)</td><td>Quantity of water for rebate</td></tr>
	<tr class="headngblue" bgcolor="#E8F6F9"><td>${cessDetailInstance?.waterSourceConsumptionMaster?.source }</td><td>${fieldValue(bean:cessDetailInstance, field:'meterWorking')}</td><td>${fieldValue(bean:cessDetailInstance, field:'startReading')}</td><td>${fieldValue(bean:cessDetailInstance, field:'endReading')}</td><td>${fieldValue(bean:cessDetailInstance, field:'quantity')}</td><td>${fieldValue(bean:cessDetailInstance, field:'threeMonthWaterQtyAvg')}</td><td>${fieldValue(bean:cessDetailInstance, field:'qtyForWaterRebate')}</td></tr>
	<tr><td colspan="2" class="headngblue">Remarks: </td><td bgcolor="#E8F6F9" colspan="5" class="headngblue">${fieldValue(bean:cessDetailInstance, field:'remarks')}</td></tr>
	</table>
	</g:each>
 </g:if>
  
  
  
  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >	
  
  <tr bgcolor="#D1D1D1">
	<td   align="left"  colspan="9" valign="middle" height="10"  class="headngblue tblbdr">&nbsp;</td>
	</tr>            
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Unit of water consumption:</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totunitOfWaterConsumption')}</td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water Consumed:</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totQuantityOfWaterConsumed')}</td>
      </tr>
      
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >3 Months Avg. Water Consumption, if meter not working: </td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'threeMonthsAvgWaterConsumption')}</td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water qualifying for rebate according to the Assesee :</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totQuantityOfWaterRebate')}</td>
      </tr>
    </table> 		
					
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3" align="center"><g:actionSubmit class="actionbutton" onclick="return confirm('Are you sure? This will submit the application to SPCB Officer');" value="Submit" action="submitReturn"/></td>
	   		</tr>
		 
		</table>
		
	</table>	
  			
            <br />
            <br />
          
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
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
	  <g:include controller="userMaster" action="showSpcbFooter"/>
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


