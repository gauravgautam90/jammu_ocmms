
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
	<META HTTP-EQUIV="EXPIRES"
CONTENT="0">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>


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

<% 

      String contex=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>

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
		String userType = aa.accessLevel;
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
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
					 <g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         

                           <%} %>
				 <% 

                 if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                String userType = aa.accessLevel;
					 if(userType.equals("admin")) { %>   

                 <g:include controller="userMaster" action="labAdmin"/>                                          

                 <% }else{ %>
					 <g:include controller="userMaster" action="labEmployee"/> 
							 <%}} %>
						<% if( (!(IndUser)session.getAttribute("indUser") ) && 
							(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
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
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> 
<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
					<td width="100%" align="left">
					
					
							</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
				            			 <g:hasErrors bean="${lab_WaterEffluentMonitoringInstance}">
            <div class="errors">
                <g:renderErrors bean="${lab_WaterEffluentMonitoringInstance}" as="list" />
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
         <g:form name="myform" method="post" >
                <input type="hidden" name="id" value="${lab_WaterEffluentMonitoringInstance?.id}" />
                <input type="hidden" name="version" value="${lab_WaterEffluentMonitoringInstance?.version}" />
               <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Water/Effluent Sheet</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						<tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sample Date: *</div></td>
                      
                          <td align="left" bgcolor="#E8F6F9">
                             <span class="txt style6"> 
                             <calendar:datePicker name="sampleDate" value="${lab_WaterEffluentMonitoringInstance?.sampleDate}" />   
                             
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Sampler's Name: *</div></td>
                        <td bgcolor="#E8F6F9"><div align="left">

						 <input type="text" id="samplerName" name="samplerName" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'samplerName')}"/>
                        <span class="txt4">(max 20 chars )</span></div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Other Field People: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						   <input type="text" id="otherFieldPeople" name="otherFieldPeople" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'otherFieldPeople')}"/>
                        <span class="txt4">(max 30 chars )</span></div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Sample Location: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						   <input type="text" id="location" name="location" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'location')}"/>
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Sample Type: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="sampleType" name="sampleType" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'sampleType')}"/>
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Sub Sample Volume (mls): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="subSampleVolume" name="subSampleVolume" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'subSampleVolume')}" />
                        </div></td>
                      </tr>
                      <tr><td class="headngblue1">Sample Details:</td></tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >pH: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="pH" name="pH" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'pH')}" />
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >T C/cm: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="TC" name="TC" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'TC')}" />
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Conductivity  (umhos): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						 <input type="text" id="conductivity" name="conductivity"  value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'conductivity')}" />
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >DO (ppm): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="dO_ppm" name="dO_ppm" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'dO_ppm')}" />
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >CL (ppm): *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="CL" name="CL" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'CL')}" />
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Comment: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="comment" name="comment" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'comment')}"/>
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Field Conditions: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="fieldConditions" name="fieldConditions" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'fieldConditions')}"/>
                        </div></td>
                      </tr>
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >pH check: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="pHCheck" name="pHCheck" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'pHCheck')}"/>
                        </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Additional preservative used: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="additionalPreservativeUsed" name="additionalPreservativeUsed" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'additionalPreservativeUsed')}"/>
                        </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Other Observations: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						     <input type="text" id="otherObservations" name="otherObservations" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'otherObservations')}"/>
                        </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3" >Remarks: *</div></td>
                       <td bgcolor="#E8F6F9"><div align="left">

						  <input type="text" id="remarks" name="remarks" value="${fieldValue(bean:lab_WaterEffluentMonitoringInstance,field:'remarks')}"/>
                        </div></td>
                      </tr>
                     
    
	  </table>
	   <table width="95%">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><g:actionSubmit class="actionbutton" value="Update" /></td>
			<td align="left"><g:actionSubmit class="actionbutton" onclick="return confirm('Are you sure?');" value="Delete" /></td>
			
		  </tr>
		</table>
 			 			
            <br />
            <br />
          </div>
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
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
</table></g:form>

<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
   
    frmvalidator.addValidation("subSampleVolume","numeric","sub Sample Volume must be numeric");
    frmvalidator.addValidation("pH","numeric","pH must be numeric");
    frmvalidator.addValidation("TC","numeric","TC must be numeric");
    frmvalidator.addValidation("conductivity","numeric","conductivity must be numeric");
    frmvalidator.addValidation("dO_ppm","numeric","DO must be numeric");
    frmvalidator.addValidation("CL","numeric","CL must be numeric");
  
    
    frmvalidator.addValidation("samplerName","req","sampler Name is required");
    frmvalidator.addValidation("otherFieldPeople","req","other Field People is required");
    frmvalidator.addValidation("location","req","location is required");

    frmvalidator.addValidation("sampleType","req","sample Type is required");
    frmvalidator.addValidation("subSampleVolume","sub Sample Volume req","is required");
    frmvalidator.addValidation("pH","req","pH is required");
    frmvalidator.addValidation("TC","req","TC is required");

    frmvalidator.addValidation("conductivity","req","conductivity is required");
    frmvalidator.addValidation("dO_ppm","req","DO is required");
    frmvalidator.addValidation("CL","req","CL is required");
    frmvalidator.addValidation("comment","req","comment is required");

    frmvalidator.addValidation("fieldConditions","req","field Conditions is required");
    frmvalidator.addValidation("pHCheck","req","pHCheck is required");
    frmvalidator.addValidation("additionalPreservativeUsed","req","additional Preservative Used is required");
    frmvalidator.addValidation("otherObservations","req","other Observations is required");

    frmvalidator.addValidation("remarks","req","remarks is required");
   

     
   </script>

</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
</HEAD>
</html>

    