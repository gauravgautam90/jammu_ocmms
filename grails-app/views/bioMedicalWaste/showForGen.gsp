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
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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

<g:javascript library="prototype" />
<g:javascript>
function createRow(){

  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}


function select10()
{
  	
var selectmenu1=document.getElementById("draftLetterFor")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
        
   	 if(chosenoption.value == "Granted")
   	 {
   	
   	 document.getElementById('selectTemp101').style.display = 'none';
   	  document.getElementById('selectTemp102').style.display = 'block';
	 }
else{
   
    
     document.getElementById('selectTemp101').style.display = 'block';
      document.getElementById('selectTemp102').style.display = 'none';
   }
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
			UserMaster ac = (UserMaster)session.getAttribute("userMaster");
			String userType = ac.accessLevel
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
			<!-- code for menuAdmin-->
			
					<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" action="wasteManagementIndustryVertical"/>                                       
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					  <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                        
				<% 	}else{ %>
					 <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
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
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" />
                	<%	
					boolean decVar=true;
					String firstname;
					String lastName;
					String access;
					String indname;
					if((UserMaster)session.getAttribute("userMaster")){ 
					UserMaster um=(UserMaster)session.getAttribute("userMaster");
					UserProfile aa=(UserProfile)session.getAttribute("userprof");
					firstname=aa.employeeFirstName;
					lastName=aa.employeeLastName;
					access=um.accessLevel;
					}else if((IndUser)session.getAttribute("indUser")){
					IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
 													indname=ind.indName;
					}else{
					decVar=false;
					}
					java.util.Date dateSCR = new java.util.Date();
					int  year=dateSCR.getYear();
					if (year < 1000)
 										year+=1900;
							int date=dateSCR.getDate();
							int month=(dateSCR.getMonth()) + 1;
				 	%>
                </td>
              </tr>
             
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> 
					<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
					<% 
						if((UserMaster)session.getAttribute("userMaster"))
						{
					%>
						 <tr height="10px" width="100%">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleName}</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					 <% }%>
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
            <g:hasErrors bean="${bioMedicalWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${bioMedicalWasteInstance}" as="list" />
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
    <g:form  name="myForm" action="generateBioNew"  method="post" >
          <input type="hidden" name="idIndReg" value="${indRegInstance?.id}" />
           <input type="hidden" name="id" value="${bioMedicalWasteInstance?.id}" />
           
          
         	<% 	
         
         		def recordCertificateInstance = RecordCertificateBMW.find("from RecordCertificateBMW apd where apd.application=? order by id desc",[bioMedicalWasteInstance])
	//println(recordCertificateInstance.authorizationNo)
         	
 %>
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="7"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="120" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Generate Notice</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="464">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Industry Details:</div></td>
                        
                      </tr>
                      
                     
                       
                      
						
                          
                      <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Occupier Name:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
                    <g:textArea name="name" value="${fieldValue(bean:indRegInstanceGet, field:'occName')}"  id="name" rows="2" cols="35"/>
                    
                    
                     
                        </span></div></td>
                      </tr>
                      
                       <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Industry Name:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
                    <g:textArea name="nameind" value="${fieldValue(bean:indRegInstanceGet, field:'indName')}"  id="nameind" rows="2" cols="35"/>
                    
                    
                     
                        </span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Address::</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         <g:textArea name="address" value="${fieldValue(bean:indRegInstanceGet, field:'indAddress')}" id="address" rows="2" cols="35"/>
                    
                  
                        </span></td>
                      </tr>
					  <tr bgcolor="#E8F6F9"><td colspan="2"><span class="style8"></span>
					  </td>
					  </tr>
					<!--  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">District:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         ${fieldValue(bean:indRegInstanceGet, field:'district')} 
                        </span></td>
                      </tr>
                      
                        <tr align="center" >
                              <td width="150px" bgcolor="#A8DAF3" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Tehsil:</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
    ${fieldValue(bean:indRegInstanceGet, field:'tehsil')}                    
                       </span> </div></td>
                      </tr>-->
					  
					  
					  <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Notice details:</div></td>
                        
                      </tr>
					  
  
                       <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Draft Letter For:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                        
		   
			  
			<%if(recordCertificateInstance){
				System.out.println("recordCertificateInstance.draftLetterFor-----"+recordCertificateInstance.draftLetterFor);
				if(recordCertificateInstance.draftLetterFor=="Granted"){
					
				%>
			       <select class="txt4" name="draftLetterFor" id="draftLetterFor"  value="${recordCertificateInstance.draftLetterFor}" onClick="select10()" >
                    	
                    	<option value="Granted">Granted</option>
                   <!-- 	<option value="Rejected">Other</option>
                   --> 
                   </select>   
                    
                <%}
				else{
					System.out.println("recordCertificateInstance.draftLetterFor---rrrrrrrrrrr--");
					
				%>
				 <select class="txt4" name="draftLetterFor" id="draftLetterFor"  value="${recordCertificateInstance.draftLetterFor}" onClick="select10()" >
				<!-- <option value="Rejected">Other</option>
             	-->
				<option value="Granted">Granted</option>
             	
             </select>   
				
			<%
				}
			}
			else{
			%>
			 <select class="txt4" name="draftLetterFor" id="draftLetterFor"  onClick="select10()">
         <!--	<option value="Rejected">Other</option>
         	--> <option value="Granted">Granted</option>
         </select>   <%}%>
                     
                    <div class="txt4" style="display:block; border:0;"  id="selectTemp222">
                     
                    </div>
                    
			   
			      </td>
                      </tr> 
                 <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Office Name:</div></td>
                        
                      </tr>
                    
                      <%def abc=""
                      if(recordCertificateInstance){
                    	abc=recordCertificateInstance.offAddres
                    	  }
                      %> 
                      
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="offAddres" >${abc}</textarea></td>
                        
                      </tr>
                      
                  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Terms & Conditions of Authorization:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4"><textarea rows="5" cols="40" name="termsco"><%if(recordCertificateInstance)
                        {println(recordCertificateInstance.termsco.trim())}%></textarea></span></td> 
                        </tr>
                      
                      
                        
                              
                      
                      
             <!--               
                  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Memo No:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                          <input type="text" id="offname" name="offname" value="<%if(recordCertificateInstance){println(recordCertificateInstance.offname)}%>">
                       </span></td>
                  </tr>    
             -->
                  
                   <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Officer Name:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         <input type="text" id="officername" name="officername" value="<%if(recordCertificateInstance){println(recordCertificateInstance.officername)}%>">
                      </span></td>
                  </tr>  
                      
                       <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Officer Designation:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                          <input type="text" id="offdesg" name="offdesg" value="<%if(recordCertificateInstance){println(recordCertificateInstance.offdesg)}%>">
                    
                      
                   
                          
                        </span></td>
                      </tr>   
                      
                      <tr >
                      <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Type of Officer:</div></td>
                      <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                      
                       <g:select from="${['Not-Selected','HO','RO']}" name="typeOfOfficer" value="${fieldValue(bean:recordCertificateInstance, field:'typeOfOfficer')}" class="txt4" ></g:select>
                     
                      </span></td>
                    </tr>
                      
                    
                    <tr >
                    <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Office:</div></td>
                    <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                    
                         <g:select from="${['JAMMU','KASHMIR','LEH']}" name="RegionalOffice" value="${fieldValue(bean:recordCertificateInstance, field:'RegionalOffice')}" class="txt4" ></g:select>
                
                    </span></td>
                  </tr>
                    <!--  
                      <tr>
									    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> </td>
																		    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																			    <table width="293" border="1">
																			      <tr >
																			        <td>From(dd/mm/yyyy)*: </td>
																			        <td>To(dd/mm/yyyy)*: </td>
																			      </tr>
																			      <%if(!recordCertificateInstance){%>
																			      <tr >
																			        <td><calendar:datePicker  id="auth_Renew_Date_From" name="auth_Renew_Date_From"  dateFormat="%d/%m/%Y"  disabled="disabled"/></td>
																			        <td><calendar:datePicker  id="auth_Renew_Date_To" name="auth_Renew_Date_To"  dateFormat="%d/%m/%Y"  disabled="disabled"/></td>
																			      </tr>
																			      <%}else{%>
																			      <tr >
																			        <td><calendar:datePicker  id="auth_Renew_Date_From" name="auth_Renew_Date_From"  dateFormat="%d/%m/%Y"  disabled="disabled"/></td>
																			        <td><calendar:datePicker  id="auth_Renew_Date_To" name="auth_Renew_Date_To"  dateFormat="%d/%m/%Y"  disabled="disabled"/></td>
																			      </tr>
																			      <%}%>
																			      
																			    </table>      
																			</td>
									  									</tr>
                      
                      
                      
                       <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Authorization No:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                          <input type="text" id="authNo" name="authNo" value="<%if(recordCertificateInstance){println(recordCertificateInstance.authorizationNo)}%>">
                    
                      
                   
                          
                        </span></td>
                      </tr>
                      
                     --> 
                     
                     <input type="hidden" id="authNo" name="authNo" value="">
                     
                     
                     
                       <tr class="headngblue txt4"  >
                      <td colspan="2">
                      <div style="display:block; border:0;"  id="selectTemp101"  >
						<table cellpadding="0" cellspacing="0" width="100%" >
                     
                   <!--   <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Subject:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                          <input type="text" id="subject" name="subject" value="<%if(recordCertificateInstance){println(recordCertificateInstance.subject)}%>">
                    
                        </span></td>
                      </tr>
                    
                       <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Details:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                                            
                                            
                          <textarea rows="5" cols="40" name="authPer">
                          <%if(recordCertificateInstance){println(recordCertificateInstance.authPeriod.trim())}%>  
                          </textarea>
                                                </span></td>
                      </tr>
                        -->
                    
                      
                      </table></div>
                </td>
					</tr>
                    
                   <tr class="headngblue txt4"  >
                      <td colspan="2">
                      <div style="display:none; border:0;"  id="selectTemp102"  >
						<table cellpadding="0" cellspacing="0" width="100%" >
                      
                   <% def cate = IndustryRegMaster.getfindById(indRegInstanceGet.id.toLong())
					 def capInv = indRegInstanceGet.indCapInvt.toInteger()
				
					 %>
                   <tr>
					<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
						class="headngblue">No of Beds:</td>
					<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue"> <input type="text" name="collected" id="collected" value="<%if(recordCertificateInstance){print(recordCertificateInstance.collected)}%>" /></td>
					</tr>
                    <!-- 
                     <%if(cate.category.name.equals("HOSPITAL")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">No of Beds:</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${indRegInstanceGet.indCapInvt}</td>
															</tr>
															
															<%}%>
															
															
															
																
																<%if(cate.category.name.equals("LAB")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("CLINIC")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per year :</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("VETERINARY")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Patients per year :</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}</td>
															</tr>
															<%}%>
															
															
																<%if(cate.category.name.equals("BLOOD BANK")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Samples per year :</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}</td>
															</tr>
															<%}%>
                      <%if(cate.category.name.equals("DENTAL CLINIC")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}</td>
															</tr>
															<%}%>

															<%if(cate.category.name.equals("CBWTF")) {%>
																
																
																
															<tr>
																<td width="250px" align="right" valign="middle" bgcolor="#A8DAF3"
																	class="headngblue">Average Number of Chairs :</td>
																<td width="250px" align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}</td>
															</tr>
					
					
															<%}
															%>
														
															-->		
															<%
															if(recordCertificateInstance){
																System.out.println("iiiiiiii");
															%>
                      <tr style="display:none">
                      
                      <td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Date of Issue :</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="noticeDate"  dateFormat="%d/%m/%Y" value="${recordCertificateInstance?.issueDate}" /></td></tr>
                       </tr>
                        <%}
						else{	
						%>
					   <tr style="display:none">
						  <td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Date of Issue :</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
	                         <calendar:datePicker name="noticeDate"  dateFormat="%d/%m/%Y" /></td></tr>
	                       </tr>
	                      
						
						<%}%>
						
						<%
						
						if(recordCertificateInstance){
							System.out.println("iiiiiiii");
						%>
						
						
                      <tr style="display:none"><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Date of Expiry :</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="expiryDate"  dateFormat="%d/%m/%Y" value="${recordCertificateInstance?.expiryDate}" /></td></tr>
                       </tr>
                      
                       <%}
						else{	System.out.println("eeeeeeeeeee");
						%>
						  <tr style="display:none"><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Date of Expiry :</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
	                         <calendar:datePicker name="expiryDate"  dateFormat="%d/%m/%Y"  /></td></tr>
	                       </tr>
	                      
						<%}%>
						 
						
						
				              <tr><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Number healthcare facilities covered by CBMWTF :</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
				              <input type="text" name="facility" id="facility" value="<%if(recordCertificateInstance){print(recordCertificateInstance.facility)}%>" /></td></tr>
		                       </tr>	              
		                       <tr><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Installed treatment and disposal capacity:</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
					              <input type="text" name="authCancelled" id="authCancelled" value="<%if(recordCertificateInstance){print(recordCertificateInstance.authCancelled)}%>" /></td></tr>
			                       </tr>	 
			                       <tr><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Area or distance covered by CBMWTF:</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
						              <input type="text" name="serviceProvider" id="serviceProvider" value="<%if(recordCertificateInstance){print(recordCertificateInstance.serviceProvider)}%>" /></td></tr>
				                       </tr>	
				                       <tr><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Quantity of Biomedical waste handled, treated or disposed :</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
							              <input type="text" name="offname" id="offname" value="<%if(recordCertificateInstance){print(recordCertificateInstance.offname)}%>" /></td></tr>
					                       </tr>	 
					                       
					                       <tr><td width="250px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Period Of Authorization(In Year):</div></td><td width="250px" align="left" bgcolor="#E8F6F9"><span class="txt style6">
								              <input type="text" name="letterNo" id="letterNo" value="<%if(recordCertificateInstance){print(recordCertificateInstance.letterNo)}%>" /></td></tr>
						                       </tr>  
             <!--      
                <tr bgcolor="#D1D1D1">
					<td width="40%"  class="headngblue" colspan="2"><div align="left" class="style3">Category & Quantity of BioMedical Wastes:</div></td>
																			
																			
																		</tr>
               	 <tr  >
         <td width="90px" class="headngblue" colspan="2" >
         <textarea rows="10" cols="70" name="categoryQty">
         
         
         
<%
for(int i=0;i<bioWasteCategQuantList.size();i++){
 
 println(bioWasteCategQuantList.category.get(i)+" "+bioWasteCategQuantList.quantity.get(i))
      				}	%>
         </textarea>
         </td>
         </tr>	-->
        
         <tr>
			<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization Required for*: </td>
			<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
			   <table style="width:100%;">
			       <tr><th><b style="color:black;">i.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Generation, segregation</td><td><input title="Generation" type="checkbox" name="chkGeneration" id="chkGeneration" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Generation(.*)')}">checked</g:if></g:if>/></td>
				       <th><b style="color:black;">ii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Collection</td><td><input title="Collection" type="checkbox" name="chkCollection" id="chkCollection" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Collection(.*)')}">checked</g:if></g:if>/></td></tr>
				   <tr><th><b style="color:black;">iii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Storage</td><td><input title="Storage" type="checkbox" name="chkStorage" id="chkStorage" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Storage(.*)')}">checked</g:if></g:if>/></td>
				       <th><b style="color:black;">iv.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Transportation</td><td><input title="Transportation"  type="checkbox" name="chkTransportation" id="chkTransportation"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Transportation(.*)')}">checked</g:if></g:if>/></td></tr>
				   <tr><th><b style="color:black;">v.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Reception</td><td><input title="Reception" type="checkbox" name="chkReception" id="chkReception" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Reception(.*)')}">checked</g:if></g:if>/></td>
				       <th><b style="color:black;">vi.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Use</td><td><input title="Reuse" type="checkbox" name="chkReuse" id="chkReuse" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Reuse(.*)')}">checked</g:if></g:if>/></td></tr>
				   <tr><th><b style="color:black;">vii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Recycling</td><td><input title="Recycling" type="checkbox" name="chkRecycling" id="chkRecycling"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Recycling(.*)')}">checked</g:if></g:if>/></td>
				       <th><b style="color:black;">viii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Offering for sale</td><td><input title="Recovery" type="checkbox" name="chkRecovery" id="chkRecovery" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Recovery(.*)')}">checked</g:if></g:if>/></td></tr>
				   <tr><th><b style="color:black;">ix.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Packaging</td><td><input title="Pre-processing" type="checkbox" name="chkPre-processing" id="chkPre-processing" <g:if test="${recordCertificateInstance}"><g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Pre-processing(.*)')}">checked</g:if></g:if>/></td>
				       <th><b style="color:black;">x.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Transfer</td><td><input title="Co-processing" type="checkbox" name="chkCo-processing" id="chkCo-processing"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Co-processing(.*)')}">checked</g:if></g:if>/></td></tr>
				   <tr ><th><b style="color:black;">xi.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Disposal or destruction</td><td><input title="Disposal" type="checkbox" name="chkDisposal" id="chkDisposal"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Disposal(.*)')}">checked</g:if></g:if>/></td>
				       <th><b style="color:black;">xii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Treatment or Processing or Conversion</td><td><input title="Treatment" type="checkbox" name="chkTreatment" id="chkTreatment"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Treatment(.*)')}">checked</g:if></g:if>/></td></tr>
				   <tr><th><b style="color:black;">xiii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Any other form of handling</td><td><input title="Incineration" type="checkbox" name="chkIncineration" id="chkIncineration"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Incineration(.*)')}">checked</g:if></g:if>/></td></tr>
				   <th style="display:none;"><b style="color:black;">xi.</b></th><td style="cursor:pointer;display:none;"  onclick="checkThis(this)">Utilisation</td><td><input title="Utilisation" type="hidden" name="chkUtilisation" id="chkUtilisation"<g:if test="${recordCertificateInstance}"> <g:if test="${recordCertificateInstance.authorizationFor.matches('(.*)Utilisation(.*)')}"></g:if></g:if>/></td>
				   </table>
			</td>
		  </tr>
        </div>
               
               
               
               
               
               
               
                </table>
               
               
               
               
                </td>
					</tr>
                    
					<%
					def abc1=""
					if(recordCertificateInstance)
                    {
                    abc1=recordCertificateInstance?.copyTo
                    }%>
                    <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Copy To:</div></td>
                   </tr>
                   <tr >
                     <td width="150px" class="headngblue" colspan="2" ><textarea rows="2" cols="70" name="copyTo">${abc1}</textarea>
					 </td>
                   </tr>   
                     
                  
        </table>
        
      
	   <table width="96%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
	   		
		  <tr>
			<td width="46%" align="right"><input type="submit"  value="Generate" class="actionbutton" ></td>
			
					
		  </tr>
		</table>
  			</g:form>
  			
            <br />
            <br />
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

<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myForm");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 
	
    frmvalidator.addValidation("typeOfOfficer","dontselect=0","please select type Of Officer");
 
</script>



<script language="JavaScript" type="text/javascript">
	
var selectmenu1=document.getElementById("draftLetterFor").value;
    
   	//  alert("selectmenu1--"+selectmenu1);
   	 if(selectmenu1 == "Granted")
   	 {
   	
   	 document.getElementById('selectTemp101').style.display = 'none';
   	  document.getElementById('selectTemp102').style.display = 'block';
	 }
else{
   
    
     document.getElementById('selectTemp101').style.display = 'block';
      document.getElementById('selectTemp102').style.display = 'none';
   }


</script>

</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

