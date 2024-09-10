<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.*;"%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>


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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
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

                 <g:include controller="userMaster" action="showAdminMenu"/>                                          

                 <% }else{ %>
					 <g:include controller="userMaster" action="showSpcbUserMenu"/> 
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
              </tr> <%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aa=(UserProfile)session.getAttribute("userprof");
             		  firstname=aa.employeeFirstName;
           		  lastName=aa.employeeLastName;
           		  access=um.accessLevel;

		}	

		else
			{
				if(  (IndUser)session.getAttribute("indUser")  )

					{
						IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 indname=ind.indName;

					}	
				else
					{
						decVar=false;
						
					}
			}




						
				
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <% if((UserMaster)session.getAttribute("userMaster"))
{
%>

<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
		
		<% } %>
</table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px;  vertical-align:middle"><span class="error">

				                     <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>

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
	
		
		
		
		<g:form action="save" method="post">
	    <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="70%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Industry/Hotel Information</span></a></li>
						<li><a href="#country2"><span>Occupier Details</span></a></li>
					</ol>
				  </td>
				  <td  width="30%" align="right" >
				  		<!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=profile&docName=<%=industryRegMasterInstance.indRegNum%>&docType=pdf"> <img  src="${createLinkTo(dir:'images',file:'print.png')}" border="0" align="center" alt="Print preview" ><span class="txtHyperlink">Print preview</span></a> -->
				 	<g:link action="downLoadingCertificate"  id="${industryRegMasterInstance.id}" ><span class="innerlink">&nbsp;Print&nbsp;</span></g:link>
				  </td>
				</tr>		
	    </table>
		
		
		
          <div  id="country1" class="content print">
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print">
			 
				
			
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" >Industry/Hotel name:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indName')}</td>
  					</tr>
  					  <tr class="headngblue txt4" >
   	 <td align="left"class="headngblue" bgcolor="#A8DAF3">Industry/Hotel Address</td>
      <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indAddress')}</td>
    </tr>
		
<tr class="headngblue txt4" >
         <td align="left"class="headngblue" bgcolor="#A8DAF3">Plot No./Khasara NO./ Patwari Halka No:</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'plotNo')}</td>
  </tr>
  
  <tr class="headngblue txt4" >

    <td align="left" class="headngblue" bgcolor="#A8DAF3">Village/City :</td>

    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indCity')}</td>

  </tr>

  <tr class="headngblue txt4">

    <td align="left" class="headngblue" bgcolor="#A8DAF3">District</td>

     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'district')}</td>

  </tr>
     <tr class="headngblue txt4">
     <td align="left" class="headngblue" bgcolor="#A8DAF3">Tehsil</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'tehsil')}</td>
                            
</tr>
    

      <tr class="headngblue txt4">
      <td align="left" class="headngblue" bgcolor="#A8DAF3" >Pin</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indPin')}</td>
                            
   </tr>

<tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3">Phone no. with code</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indPhoneCode')} - ${fieldValue(bean:industryRegMasterInstance, field:'indPhoneNo')}</td>
                            
</tr>

<tr class="headngblue txt4">
  <td align="left" class="headngblue"  bgcolor="#A8DAF3">Fax No. with code</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indFaxCode')} - ${fieldValue(bean:industryRegMasterInstance, field:'indFaxNo')}</td>
                            
</tr>
<tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3" >Email </td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indEmail')}</td>
                            
</tr>
  	 <tr class="headngblue txt4" >
    <td align="left"class="headngblue" bgcolor="#A8DAF3">Capital Investment (In Lakhs)</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indCapInvt')}</td>
  </tr>
  		
  		<tr class="headngblue txt4">
          <td align="left" class="headngblue" bgcolor="#A8DAF3">Scale of Industry</td>                           
           <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'industryScale')}</td>
  		</tr>
 		
  
       <tr class="headngblue txt4"  >
       <td  align="left" class="headngblue" bgcolor="#A8DAF3" >Industry Type</td>
      <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'industryType')}</td>
       </tr>
     
     
     
     <tr class="headngblue txt4">
          <td align="left" class="headngblue" bgcolor="#A8DAF3">Category</td>                           
           <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'category')}</td>
  		</tr>
     
     
       <tr class="headngblue txt4"  >
       <td  align="left" class="headngblue" bgcolor="#A8DAF3" >Other Industry Type Detail</td>
      <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indTypeOther')}</td>
       </tr>
     
  
         
  
     <tr class="headngblue txt4" >
         <td align="left"class="headngblue" bgcolor="#A8DAF3">Month/Year Of Commissioning</td>
                <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'commMonth')}
        
       / ${fieldValue(bean:industryRegMasterInstance, field:'dateOfComm')}</td>
      </tr>
  
 

  <%Format formatter = new SimpleDateFormat("dd/MM/yyyy");
	String regDate = formatter.format(industryRegMasterInstance.regDate);
	%>
	
  <tr class="headngblue txt4" >
         <td align="left"class="headngblue" bgcolor="#A8DAF3">Industry Registration/License/DIC No/Department of tourism registration No./Date/Registered Authority</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indRegNum')}
 /(<%=regDate%>)/${fieldValue(bean:industryRegMasterInstance, field:'regAuthority')}
     
     </td>
  </tr>
  
  <tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3" >Expected Date of Production</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'expDate')}</td>
                            
</tr>
  
   <tr class="headngblue txt4">
      <td align="left"class="headngblue" bgcolor="#A8DAF3">Industry Status</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indStatus')}</td>
  </tr>

  
 

 
  <!--<tr class="headngblue txt4" >
    <td align="left"class="headngblue" bgcolor="#A8DAF3">Capital Investment of Land (In Lakhs)</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9"></td>
  </tr>
  <tr class="headngblue txt4" >
    <td align="left"class="headngblue" bgcolor="#A8DAF3">Capital Investment of Building (In Lakhs)</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9"></td>
  </tr>
 <tr class="headngblue txt4" >
    <td align="left"class="headngblue" bgcolor="#A8DAF3">Total Capital Investment (In Lakhs)</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9"></td>
  </tr>

    -->

 </table>


 

       

                        <!--  <tr >

                            <td width="12" bgcolor="#5A89D9"><img  src="${createLinkTo(dir:'images',file:'BlueTab_Left.jpg')}" width="10" height="20"></td>

                            <td bgcolor="#5A89D9" class="headng1" width="160">Occupier Details</td>

                            <td width="10" valign="bottom"><img src="${createLinkTo(dir:'images',file:'BlueTab_Right.jpg')}" width="10" height="21"></td>

                          </tr>-->
         
          </div>
          <div id="country2" class="content print">
           
          
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                      
					   
					    <tr>
		    <td bgcolor="#FFFFFF"><table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					   
                          <tr class="headngblue txt4"  >

							   <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3">Occupier Name :</td>

							   <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occName')}</td>

						</tr>

						<tr class="headngblue txt4">

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Designation : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occDesignation')}</td>

						</tr>
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Residential Address : </td>

								<td align="left"class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occAddress')}</td>

						</tr>
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Status of Applicant : </td>

								<td align="left"class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'statusOfAppl')}</td>

						</tr>
						
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Name of Directors/Partner/Proprietor with Contact Details :</td>

								<td align="left"class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance,field:'nameAddressPartners')}</td>

						</tr>
						
						
						<tr class="headngblue txt4">

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Village/City : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occCity')}</td>

						</tr>
						 <tr class="headngblue txt4"  >

							<td align="left" class="headngblue" bgcolor="#A8DAF3">District :</td>

							<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occDistrict','errors')} headngblue1">
                                   ${fieldValue(bean:industryRegMasterInstance, field:'occDistrict')}
                                </td>

						</tr>
						
						 <tr class="headngblue txt4" >

							<td align="left" class="headngblue" bgcolor="#A8DAF3">Tehsil :</td>

							<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'occTehsil','errors')} headngblue1"><div id="updateSelect1">
							 ${fieldValue(bean:industryRegMasterInstance, field:'occTehsil')}
							</td>

						</tr>
  
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Pin : </td>

								<td align="left" bgcolor="#E8F6F9"  class="headngblue1">${fieldValue(bean:industryRegMasterInstance, field:'occPin')}</td>

						</tr>
						
						
 
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Phone No. with code : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occPhoneCode')} - ${fieldValue(bean:industryRegMasterInstance, field:'occPhoneNo')}</td>

						</tr>
						
				
						
						<tr class="headngblue txt4" >

								<td align="left"class="headngblue" bgcolor="#A8DAF3">Fax No.with code : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occFaxCode')} - ${fieldValue(bean:industryRegMasterInstance, field:'occFaxNo')}</td>

						</tr>
						
						<tr class="headngblue txt4">

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Mobile No : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occMobile')}</td>

						</tr>
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">E-Mail : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9" >${fieldValue(bean:industryRegMasterInstance, field:'occEmail')}</td>

						</tr>
						
						

    <tr class="headngblue txt4" >

    <td align="left" class="headngblue" bgcolor="#A8DAF3"> Hint Question (optional) :</td>

    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:abc,field:'hintQuestion')}</td>

  </tr>
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Your Answer : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:abc, field:'hintAnswer')}</td>

						</tr>
						
        	 </table>
                        </table>
						
						</g:form>
		
		
  			
            
          </div>
		  
		  <g:form action="edit">				
	   <table width="95%" align="center" valign="top">
	         <input type="hidden" id="id" name="id" value="${abc?.id}" />
			 <input type="hidden" id="password" name="password" value="${abc?.password}" />
			<input type="hidden" id="occEmail" name="occEmail" value="${industryRegMasterInstance?.occEmail}" />
			 <input type="hidden" id="id1" name="id1" value="${industryRegMasterInstance?.id}" />
			 
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
	   		<%if((IndUser)session.getAttribute("indUser")||(UserMaster)session.getAttribute("userMaster")){ %>
		  <tr>
			<td align="center"><g:actionSubmit  value="Edit" class="actionbutton" /></td>
			
			

		  </tr> <%} %>
		</table>
		
			</g:form>

		   </div>
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


