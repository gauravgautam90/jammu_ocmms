<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

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
		<g:include controller="userMaster" action="showAdminMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin -->
				
				<% 
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
						<g:include controller="userMaster" action="showSpcbIndustryMenu"/>
							
				<%} %>
				
				<% 
				if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType =	 aa.accessLevel
					if(userType.equals("admin")) { %>	
						<g:include controller="userMaster" action="showAdminMenu"/> 							
				<% }} %>
				
				<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
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
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr>
						<td class = "headngblue1" align="center">hii...${fieldValue(bean:industryRegMasterInstance, field:'occName')} your Username is :${fieldValue(bean:abc, field:'id')} and Password is :${pass2}</td>
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
		
		
		
		
		<g:form action="save" method="post" >
		
		
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Industry Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Industry Details </td>
				</tr>
			
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" >Industry name:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indName')}</td>
  					</tr>
  					
  					

       <tr class="headngblue txt4"  >
       <td  align="left" class="headngblue" bgcolor="#A8DAF3" >Type</td>
      <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indType')}</td>
       </tr>
     
  
          <tr class="headngblue txt4">
          <td align="left" class="headngblue" bgcolor="#A8DAF3">Category</td>                           
           <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'category')}</td>
  		</tr>
  
  
     <tr class="headngblue txt4" >
         <td align="left"class="headngblue" bgcolor="#A8DAF3">Date Of Commissioning</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'dateOfComm')}</td>
  </tr>

 

   <tr class="headngblue txt4">
      <td align="left"class="headngblue" bgcolor="#A8DAF3">Industry Status<span style="color:red">*</span>:</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indStatus')}</td>
  </tr>

  

  <tr class="headngblue txt4" >
    <td align="left"class="headngblue" bgcolor="#A8DAF3">Capital Investment (In Lakhs)</td>
    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indCapInvt')}</td>
  </tr>

  
      <tr class="headngblue txt4" >
   	 <td align="left"class="headngblue" bgcolor="#A8DAF3">Address</td>
      <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indAddress')}</td>
    </tr>

  <tr class="headngblue txt4">

    <td align="left" class="headngblue" bgcolor="#A8DAF3">Area </td>

    <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indArea')}</td>

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
  <td align="left" class="headngblue" bgcolor="#A8DAF3">Area Code</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indPhoneCode')}</td>
                            
</tr>
<tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3">Phone no.</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indPhoneNo')}</td>
                            
</tr>
<tr class="headngblue txt4">
  <td align="left" class="headngblue"  bgcolor="#A8DAF3">Area Code</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indFaxCode')}</td>
                            
</tr>
<tr class="headngblue txt4">
  <td align="left" class="headngblue"  bgcolor="#A8DAF3">Fax No.</td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indFaxNo')}</td>
                            
</tr>
<tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3" >Email </td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'indEmail')}</td>
                            
</tr>

 <!--<tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3">created by </td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'createdBy')}</td>
                            
</tr>
 <tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3">datecreated </td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'dateCreated')}</td>
                            
</tr>
 <tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3">lastUpdated </td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'lastUpdated')}</td>
                            
</tr>
 <tr class="headngblue txt4">
  <td align="left" class="headngblue" bgcolor="#A8DAF3">updatedBy </td>
                            
     <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'updatedBy')}</td>
                            
</tr>-->
 

  

 

       

                        <!--  <tr >

                            <td width="12" bgcolor="#5A89D9"><img  src="${createLinkTo(dir:'images',file:'BlueTab_Left.jpg')}" width="10" height="20"></td>

                            <td bgcolor="#5A89D9" class="headng1" width="160">Occupier Details</td>

                            <td width="10" valign="bottom"><img src="${createLinkTo(dir:'images',file:'BlueTab_Right.jpg')}" width="10" height="21"></td>

                          </tr>-->

                       <tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Occupier Details</td>
				</tr>
					   
					   
					   
                          <tr class="headngblue txt4"  >

							   <td  align="left" class="headngblue" bgcolor="#A8DAF3">Occupier Name<span style="color:red">*</span>:</td>

							   <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occName')}</td>

						</tr>

						<tr class="headngblue txt4">

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Designation : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occName')}</td>

						</tr>
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Address : </td>

								<td align="left"class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occAddress')}</td>

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

   						 <td align="left" class="headngblue" bgcolor="#A8DAF3">Area Code :</td>

    

   							 <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occPhoneCode')}</td>
 							 </tr>
 
						
						<tr class="headngblue txt4" >

								<td align="left" class="headngblue" bgcolor="#A8DAF3">Phone No. : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occPhoneNo')}</td>

						</tr>
						
				<tr class="headngblue txt4" >

    		           <td align="left" class="headngblue" bgcolor="#A8DAF3">Area Code :</td>
  					
  					 <td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occFaxCode')}</td>
     				 
			  </tr>
						
						<tr class="headngblue txt4" >

								<td align="left"class="headngblue" bgcolor="#A8DAF3">Fax No. : </td>

								<td align="left" class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance, field:'occFaxNo')}</td>

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
						
						</g:form>
		<g:form>				
	   <table width="95%" align="center">
	         <input type="hidden" id="id" name="id" value="${abc?.id}" />
			<input type="hidden" id="password" name="password" value="${abc?.password}" />
			<input type="hidden" id="occEmail" name="occEmail" value="${industryRegMasterInstance?.occEmail}" />
			 <input type="hidden" id="id1" name="id1" value="${industryRegMasterInstance?.id}" />
			 
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><g:actionSubmit  value="Edit" class="actionbutton" /></td>
			<td align="left"><g:actionSubmit  action="sendMail" value="Send Mail"  class="actionbutton" /></td>			
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
</html>


