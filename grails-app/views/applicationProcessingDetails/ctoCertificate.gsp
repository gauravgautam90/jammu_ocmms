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

<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

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
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					<tr>
							
				
							<td  align="left"><%if(viewCert){%>
						<g:link action="downLoadingCertificate"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}%>
						<%if(viewR_Certificate){%>
						<g:link action="viewR_CertificatePdf"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View R-3&nbsp;|</span></g:link>
						<%}%>
						<%if(viewR4_Certificate){%>
						<g:link action="viewR4_CertificatePdf"  id="${indApplicationDetailsInstance.id}" ><span class="innerlink">&nbsp;View R-4&nbsp;|</span></g:link>
						<%}%></td>
							<td >&nbsp;</td>
							
							
							
							
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
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
    <g:form  name="myForm" action="pdfCto" method="post" >
         <!-- <form  name="myForm" action="pdf" method="post" > --> 
        <!--  <form  name="myForm" action="#" method="post" > -->
          <input type="hidden" name="idIndApp" value="${indApplicationDetailsInstance?.id}" />
          <input type="hidden" name="fileNo" value="${fileN}" />
               
   
   				
         
         
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Draft Letter</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Industry Details:</div></td>
                        
                      </tr>
						<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">District::</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                         ${fieldValue(bean:indRegInstance, field:'district')}
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" bgcolor="#A8DAF3" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Tehsil:</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
    ${fieldValue(bean:indRegInstance, field:'tehsil')}                    
                       </span> </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Industry Name:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
                         ${fieldValue(bean:indRegInstance, field:'indName')}
                        </span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Address::</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                        
                       
    
                 
                        
                        
                        
                   ${fieldValue(bean:indRegInstance, field:'indAddress')}
                        </span></td>
                      </tr>
					  <tr bgcolor="#E8F6F9"><td colspan="2"><span class="style8"></span>
					  </td>
					  </tr>
					  
					  <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Consent letter details:</div></td>
                        
                      </tr>
					  
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Letter Sent To:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                          
                          ${fieldValue(bean:indRegInstance, field:'occName')}
                        </span></td>
                      </tr>
					  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Designation:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                          ${fieldValue(bean:indRegInstance, field:'occDesignation')}
                        </span></td>
                      </tr>
					
					  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Letter No:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         <input type="text" id="fileNumber" name="fileNumber" value="" class="txt4" />
                          
                        </span></td>
                      </tr>
                       <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Endt No:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         <input type="text" id="endtNumber" name="endtNumber" value="" class="txt4" />
                          
                        </span></td>
                      </tr>
					<!--  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Letter For:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                          
                        <input type="radio" name="searchOp" value="grant" checked="checked"/>
                        <span class="style3">Grant</span>  &nbsp; 
                        <input type="radio" name="searchOp" value="refusal"/>
                        <span class="style3">Refusal</span></span></td>
                      </tr> -->
					  <tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  ><div align="right" class="style3">Office District:</div></td> <td align="left" bgcolor="#E8F6F9"><input type="text" id="nameOfDistrict" name="nameOfDistrict"  class="txt4" /></td></tr>
                      <tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Draft Letter Date :</div></td><td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="draftLetterDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr>
                       <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Consent Granted From:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="grantedFrom"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                      <!--     <input name="grantedFrom" type="text" class="txt4" />
                          <script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'myForm',
		// input name
		'controlname': 'grantedFrom'
	});

	</script> --></span>
                                &nbsp;
                          <span class="style3">To</span> &nbsp;  
                            <calendar:datePicker name="grantedTo"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                         <!--  <input name="grantedTo" type="text" class="txt4" />
                          <script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'myForm',
		// input name
		'controlname': 'grantedTo'
	});

	</script> -->
                          	
                          </td>
                      </tr> 
					   <tr bgcolor="#E8F6F9"><td colspan="2"><span class="style8"></span>
					  </td>
					  </tr>
					  
					    <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Office Address:</div></td>
                        
                      </tr>
                    
                      
                      
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="offAddres"></textarea>

</td>
                        
                      </tr>
					      
					    <!--    <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Subject:</div></td>
                        
                      </tr>
                    
                      
                      
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="subject"></textarea>

</td>
                        
                      </tr> -->
                      
                      
                      <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Reference:</div></td>
                        
                      </tr>
                    
                      
                      
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="references"></textarea>

</td>
                        
                      </tr>
                      <tr><td colspan="2"><input type="button" onclick="createRow();" value="Add Row"></td></tr>
                     <tr><td colspan="2"> <div id="AjaxPanel"></div></td></tr>
                     
                     
                      <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Certificate Body:</div></td>
                        
                      </tr>
                       <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="6" cols="70" name="certificateBody"></textarea>

</td>
                        
                      </tr>
                      
                       <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Product:</div></td>
                        
                      </tr>
                       <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="product"></textarea>

</td>
                        
                      </tr>
                      <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Product Capacity:</div></td>
                        
                      </tr>
                       <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="productCapacity"></textarea>

</td>
                        
                      </tr>
                      
                      <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">General Conditions:</div></td>
                        
                      </tr>
                      
                       <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="10" cols="70" name="generalConditions">${conditionArrayG}</textarea>

</td>
                        
                      </tr>
                      <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Specific Conditions:</div></td>
                        
                      </tr>
                       <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="10" cols="70" name="specificConditions">${conditionArray}</textarea>

</td>
                        
                      </tr>
                      
                       <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Copy To:</div></td>
                        
                      </tr>
                    
                      
                      
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="2" cols="70" name="copyTo"></textarea>

</td>
                        
                      </tr>
                     
                      
                      
	  </table>
	   <table width="96%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td width="46%" align="right"><input type="submit"  value="Generate Certificate" class="draftbutton" ></td>
			
				<!-- onclick="window.open('../openCertificate', 'windowname1', 'width=810, height=650, scrollbars=1'); return false;" name="save" -->
					
		  </tr>
		</table>
  			</g:form>
  			
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
</table>
</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

