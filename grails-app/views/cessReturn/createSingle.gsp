<%@ page import="java.util.Calendar;"%>
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





<script type="text/javascript">
function enablingDisabling()
{
	<% List sourceMaster11=CessSourceConsumptionMaster.list(); %>
	<g:if test="${sourceMaster}"> 
    
		<g:each in="${sourceMaster}" status="i" var="sourceMaster">
	
		var a= document.getElementById("<%=sourceMaster.source %>");

if(a.checked){

	//alert((document.getElementById("startReading_<%=sourceMaster.source %>")).disabled.value);
	(document.getElementById("meterWorking_<%=sourceMaster.source %>")).disabled = false;
	(document.getElementById("startReading_<%=sourceMaster.source %>")).disabled = false;
	(document.getElementById("endReading_<%=sourceMaster.source %>")).disabled = false;
	(document.getElementById("quantity_<%=sourceMaster.source %>")).disabled = false;
	(document.getElementById("threeMonthQuantity_<%=sourceMaster.source %>")).disabled = false;
	(document.getElementById("rebateQuantity_<%=sourceMaster.source %>")).disabled = false;


}else{
	(document.getElementById("meterWorking_<%=sourceMaster.source %>")).disabled = true;
	(document.getElementById("startReading_<%=sourceMaster.source %>")).disabled = true;
	(document.getElementById("endReading_<%=sourceMaster.source %>")).disabled = true;
	(document.getElementById("quantity_<%=sourceMaster.source %>")).disabled = true;
	(document.getElementById("threeMonthQuantity_<%=sourceMaster.source %>")).disabled = true;
	(document.getElementById("rebateQuantity_<%=sourceMaster.source %>")).disabled = true;

}
</g:each></g:if>
}

</script>
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
			<!-- code for menuAdmin-->
			
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
		
		
		
		<g:form name="myform" action="saveCreateSingle" id="1">
		 <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
               
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
			
			
				<tr>
                  <td width="15%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Cess Applied From :</td>
				  <td width="35%" align="left" bgcolor="#E8F6F9"  class="headngblue"><g:select name="FromMonth" from="${['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August','September', 'October', 'November', 'December']}" class="txt4" />
				  
				
				<%Calendar cal = Calendar.getInstance(); 
				  int yearVal = cal.get(Calendar.YEAR);
				%>
					<select name="FromYear">
					
					<% for (int i=1995;i<= yearVal;i++){ %>
  						<option value=<%=i%>><%=i%></option>
  						<%} %>
					</select>
					</td>
					
					 <td width="15%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Cess Applied To :</td>
				  <td width="35%" align="left" bgcolor="#E8F6F9"  class="headngblue"><g:select name="ToMonth" from="${['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August','September', 'October', 'November', 'December']}" class="txt4" />
				  
				
				<%Calendar cal1 = Calendar.getInstance(); 
				  int yearVal1 = cal1.get(Calendar.YEAR);
				%>
					<select name="ToYear">
					
					<% for (int i=1995;i<= yearVal1;i++){ %>
  						<option value=<%=i%>><%=i%></option>
  						<%} %>
					</select>
					</td>
				 
			  </tr> 
				
				<!--
					<tr>
                  <td width="15%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">From Date</td>
				  <td width="35%" align="left" bgcolor="#E8F6F9"  class="headngblue">
				  	<calendar:datePicker name="cessAppliedFromDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
						</td>
					
					 <td width="15%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">To Date</td>
				  <td width="35%" align="left" bgcolor="#E8F6F9"  class="headngblue">
				  	<calendar:datePicker name="cessAppliedToDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
				  	</td>
				 
			  </tr>   
				-->
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="indName" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indName }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue txt4"><textarea name="address"  readonly="readonly"  style="width:160px">${indRegInstance?.indAddress }</textarea></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Plot No./Khata * : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="plotNo" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.plotNo }" AUTOCOMPLETE=OFF maxlength="50" />
                    </td>
                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input name="indCity" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indCity }" AUTOCOMPLETE=OFF maxlength="50" />
					</span></td>
				</tr>        
				    
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input name="indDistrict" type="text" class="txt4" size="30" readonly="readonly" value="${district }" AUTOCOMPLETE=OFF maxlength="50" />
					</span></td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<input name="indPin" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance?.indPin }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
				</tr>        
				<!--
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reading for First Day of Calender month : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<input name="firstDay" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="9" />
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reading for Last Day of Calender month  : </td>
				    <td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<input name="lastDay" type="text" class="txt4" size="30"  AUTOCOMPLETE=OFF maxlength="9" />
					</td>
				</tr>        
				
				-->
				
			
			
	</table>
	
	
	
  <div > <div id="AjaxPanel"></div></div>
  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >	
               <tr>
               
			<td align="center" colspan="7"><input type="submit"  value="Next"  class="actionbutton" />
			
			<input type="reset" name="reset" value="Reset" class="actionbutton"/></td>			
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
    </table>
 </g:form>
 <!--
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myform");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("firstDay","req","Please enter Reading for First Day of Calender month");
  frmvalidator.addValidation("firstDay","numeric","Reading for First Day of Calender month should be numeric");
  frmvalidator.addValidation("lastDay","req","Please enter Reading for Last Day of Calender month");
  frmvalidator.addValidation("lastDay","numeric","Reading for Last Day of Calender month should be numeric");
 </script> 
 -->
  </body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD> 
  </html>