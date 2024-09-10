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

<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />







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

  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>


<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<Script Language=JavaScript>
	function getStats(control){
		var fName = control.value;
		// alert(control.name);
		var hContName = control.name+"extn";
		// alert(hContName);
		var hCont = document.getElementsByName(hContName);
		// alert('size '+hCont)
		fullName = fName;
		shortName = fullName.match(/[^\/\\.]+$/);
		//document.forms.Form1.dispName.value = shortName
		// alert(shortName);
		var a = hCont[0];
		a.value = shortName;
		//alert(a.value);
	}
</Script>


<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF>

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
		
		<!-- Start of menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
        <%} %>
     <% if((UserMaster)session.getAttribute("userMaster")){
			UserMaster aa = (UserMaster)session.getAttribute("userMaster");
			String userType = aa.accessLevel
				if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      
			<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
				<%}
		} %>
     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
			<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
	  <% } %>
	  <!-- END of menuAdminHorizontal-->
	  
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
				<g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenu"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenu"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
			<!-- End of menuAdmin-->
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
						 <tr height="10px" width="100%">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;
                            %{--bhanu commented code start; date: 01-08-2017--}%
                            %{--Role : ${roleHeader}--}%
                            %{--bhanu commented code ends --}%

                            %{--bhanu code start; date: 01-08-2017 --}%
                            <%if(roleHeader){%>
                            Role : ${roleHeader}
                            <%}%>
                            %{--bhanu code ends  --}%
                            </td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					<tr>
							
				
							<td class="txt4" style="font-size: 13px;">List of Application of Raised Inspection</td>
							
							
							
							
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
            <g:hasErrors bean="${certificateRecordInstance}">
            <div class="errors">
                <g:renderErrors bean="${certificateRecordInstance}" as="list" />
            </div>
            </g:hasErrors>  
            
                

                      </span></div></td>
                    </tr>
                     <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="center" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    
    
		  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                            <th width="10%" align="center" class="headngblue" >Application No</th>
                            <th width="10%" align="center" class="headngblue" >Industry</th>
							<th width="18%" align="center" class="headngblue" >Notice sent Date</th>
							<th width="40%" align="center" class="headngblue" >Inspection Note</th>
							<th width="10%" align="center" class="headngblue" >No of Days</th> 
                   	        <th width="10%" align="center" class="headngblue" >Role</th>
                   	        <th width="12%" align="center" class="headngblue" >Reason</th>
                   	        <g:if test="${noticeType=='FWD MS'}">
                   	        <th width="12%" align="center" class="headngblue" ></th>
                   	        </g:if>
							<g:if test="${noticeType != 'FWD MS'}">
                   	        <!-- <th width="12%" align="center" class="headngblue" >View Inspection Format</th> -->
                   	        </g:if>
                   	    </tr>
                    </thead>
                    <tbody>
                    <%if(inspectionFwdNoticeList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${inspectionFwdNoticeList}" status="i" var="inspectionFwdNoticeInstance">
                         <% 
                        java.text.SimpleDateFormat sdfDestination = new java.text.SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(inspectionFwdNoticeInstance.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          
                            <td align="center" height="25" class="txt4"  ><u><a href="#" onclick="window.open('../applicationProcessingDetails/openApplicationDetails/${inspectionFwdNoticeInstance.application.id}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">${inspectionFwdNoticeInstance.application.id}</span></a></u></td>
                            <td align="center" height="25" class="txt4"  ><u><a href="#" onclick="window.open('../industryRegMaster/showOnlyIndustryDetail?ospcbOfficerView=true&id=${inspectionFwdNoticeInstance.application.indUser.id}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">${inspectionFwdNoticeInstance.application.indUser.indName}</span></a></u></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" ><%=strDate%></font></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" >${fieldValue(bean:inspectionFwdNoticeInstance, field:'inspectionNote')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:inspectionFwdNoticeInstance, field:'noOfDays')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" >${fieldValue(bean:inspectionFwdNoticeInstance, field:'role')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" >${fieldValue(bean:inspectionFwdNoticeInstance, field:'reasonToChooseOfficer')}</font></td>
                            <g:if test="${noticeType=='FWD MS'}">
                   	        <td align="center" height="25" class="txt4" ><g:link action="forwardInspectionOrder" controller="applicationProcessingDetails" params="[appliId:inspectionFwdNoticeInstance.application.id,typeOfInspection:inspectionFwdNoticeInstance.typeOfInspection]"><font face="Verdana" color="red">Assign</font></g:link></td>
                   	        </g:if>
							<g:if test="${noticeType != 'FWD MS'}">
                   	   <!--     <td align="center" height="25" class="txt4" > <a href="<%=request.getContextPath()%>/SPCB_DOCUMENTS/INSPECTION REPORT FOR ALL UNITS.pdf" target="_blank"><font  font="BOLD" size="2" style="color:blue;">Download</font></a></td> -->
                   	        
                   	        </g:if>
                        </tr>
                    </g:each>
                    </tbody>
      </table>

      </td>
                            
                          </tr>
                      </table>
					  
					  <br>
					  
					  
			
		  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
			  <td width="100%"><b style="color:#1F6FB7">Surprise Inspection</b></td>
			</tr>
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                            <th width="10%" align="center" class="headngblue" >Industry Name</th>
							<th width="18%" align="center" class="headngblue" >Notice sent Date</th>
							<th width="40%" align="center" class="headngblue" >Inspection Note</th>
							<th width="10%" align="center" class="headngblue" >No of Days</th> 
                   	        <th width="10%" align="center" class="headngblue" >Role</th>
                   	        <th width="12%" align="center" class="headngblue" >Reason</th>
                   	        <g:if test="${noticeType=='FWD MS'}">
                   	        <th width="12%" align="center" class="headngblue" >Assign</th>
                   	        </g:if>
                   	    </tr>
                    </thead>
                    <tbody>
                    <%if(surpriseInspectionFwdNoticeList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${surpriseInspectionFwdNoticeList}" status="i" var="surpriseInspectionFwdNoticeList">
                         <% 
                        java.text.SimpleDateFormat sdfDestination = new java.text.SimpleDateFormat("dd-MM-yyyy hh:mm");
   
                        String strDate = sdfDestination.format(surpriseInspectionFwdNoticeList.dateCreated );
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          
                            <td align="center" height="25" class="txt4"  ><u><a href="#" onclick="window.open('../industryRegMaster/showOnlyIndustryDetail?ospcbOfficerView=true&id=${surpriseInspectionFwdNoticeList.industry.id}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">${surpriseInspectionFwdNoticeList.industry.indName}</span></a></u></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" ><%=strDate%></font></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" >${fieldValue(bean:surpriseInspectionFwdNoticeList, field:'inspectionNote')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:surpriseInspectionFwdNoticeList, field:'noOfDays')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" >${fieldValue(bean:surpriseInspectionFwdNoticeList, field:'role')}</font></td>
                           <td align="center" height="25" class="txt4" ><font face="Verdana" >${fieldValue(bean:surpriseInspectionFwdNoticeList, field:'reasonToChooseOfficer')}</font></td>
                            <g:if test="${noticeType=='FWD MS'}">
                   	        <td align="center" height="25" class="txt4" ><g:link action="forwardSurpriseInspectionOrder" controller="applicationProcessingDetails" params="[industryId:surpriseInspectionFwdNoticeList.industry.id]"><font face="Verdana" color="red">Assign</font></g:link></td>
                   	        </g:if>
                        </tr>
                    </g:each>
                    </tbody>
      </table>

      </td>
                            
                          </tr>
                      </table>
					  
					  
					  
					  </td>
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

