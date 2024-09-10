<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>
<calendar:resources lang="en" theme="aqua"/>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
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

</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")

function enablingDisabling()
{
var a= document.getElementById("radiobuttonfresh").value;
if(a=="FreshApplication")
	{
	document.getElementById("prevauthNo").disabled = false;
	document.getElementById("prevauthDate").disabled = false;
	}
}

function enablingDisablingAgain()
{
var a= document.getElementById("radiobuttonfresh").value;
if(a=="FreshApplication")
	{
	document.getElementById("prevauthNo").disabled = true;
	document.getElementById("prevauthDate").disabled = true;
	}
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
		<!-- code for menuIndustryHorizontal-->
		<% 
									if(  (IndUser)session.getAttribute("indUser")  ){ %> <g:include
									controller="userMaster" action="showIndustryMenuHorizontal" /> <%} %>
									<% 
 									if((UserMaster)session.getAttribute("userMaster")){
 									UserMaster aa = (UserMaster)session.getAttribute("userMaster");
									String userType = aa.accessLevel;
									if(userType.equals("admin")) { %> <g:include controller="userMaster"
									action="showAdminMenuHorizontal" /> <% }else{ %> <g:include
									controller="userMaster" action="showSpcbUserMenuHorizontal" /> <%}} %>
									<% 
									if( (!(IndUser)session.getAttribute("indUser") ) && 
		      						(! (UserMaster)session.getAttribute("userMaster") )  )   {
		      						%> 
		      						<g:include controller="userMaster" action="showIndexMenuHorizontal" />
		      			 			<% 
		      			 			} 
		      					%>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
					                        <%    }
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
                <td height="24" bgcolor="#4C8BC0">

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>


					<table width="100%" bgcolor="#4C8BC0">
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=firstname %>&nbsp;<%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
		
		<% } %>
					 
				</td>
              </tr>
              							<g:def var="appForWhich1" value="PWM"/><g:def var="applicationId" value="${plasticWasteInstance.id}"/>
              <tr><td>
              <%if(plasticWasteInstance.applicationStatus=="approved") {%>
              				
              <%

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ 
		}else {
               } %> &nbsp;<g:link controller="plasticWaste" action="viewPwmCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
            	  <%} 
            	  if(  (IndUser)session.getAttribute("indUser")  )
		
		{ 
		}else {%>
              <a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a> <% } %> 
                        </td></tr>
                          
                          
                          
                            <tr>
                <td height="0" align="center" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                    <span class="error"> 
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${plasticWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${plasticWasteInstance}" as="list" />
            </div>
            </g:hasErrors>
            </span>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="33" align="left" valign="top">&nbsp;</td>
                            <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
			 
    <br/>
    <g:form name="myform" action="Edit" method="post" enctype="multipart/form-data">
    <input type="hidden" name="indRegId" value="${indRegInstanceId}" />
    <input type="hidden" name="muId" value="${plasticWasteInstance?.id}" />
   		<table width="75%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td>
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Plastic Waste</span></a></li>
						<li><a href="#country3"><span>Product/Raw Material</span></a></li>
						<li><a href="#country4"><span>Solid Waste Details</span></a></li>
						<li><a href="#country6"><span>Documents</span></a></li>
					</ol>
				  </td>
				 <g:if test="${plasticWasteInstance?.completionStatus=='Completed'}">
	               <%def wasteManaFileIns = WasteManagementFile.findAll("from WasteManagementFile where applicationId=?",[plasticWasteInstance.id])                              
				  System.out.println("wasteManaFileIns"+wasteManaFileIns)%>
				  <%
				   for(int i=0;i<wasteManaFileIns.size();i++){
				  
				  
				  if(wasteManaFileIns[i].typeOfFile=='PwmForm1'){%>
				  <td  align="right" class="headngblue"><a href="<%=request.getContextPath()%>/plasticWaste/viewMswPdf?appliLoc=<%=plasticWasteInstance?.id%>"><span class="headngblue">Form I</span></a></td>
				  <%}
				   
				  if(wasteManaFileIns[i].typeOfFile=='PwmForm3'){%>
				  <td  align="right" class="headngblue"><a href="<%=request.getContextPath()%>/plasticWaste/viewMswPdf3?appliLoc=<%=plasticWasteInstance?.id%>"><span class="headngblue">Form II</span></a></td>
				  <%}
				  
				  
                    if(wasteManaFileIns[i].typeOfFile=='PwmForm2'){%>
				  <td  align="right" class="headngblue"><a href="<%=request.getContextPath()%>/plasticWaste/viewMswPdf2?appliLoc=<%=plasticWasteInstance?.id%>"><span class="headngblue">Form III</span></a></td>
				  <%}}%>
				</g:if></tr>	
	    </table>
	    
	    
	    <div class="content" id="country1" >
		   <table width="75%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the unit :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indusrtyInstance?.indName }
					</td>
				</tr> 
			
				<tr>
				<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Location of unit :<span style="color:red"></span></td>
				<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				  ${plasticWasteInstance?.unitLocation }
				</td>
																
				</tr>
				
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of the unit :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indusrtyInstance?.indAddress }
					</td>
			</tr> 
			
			
			<tr bgcolor="#F4F7FB">
			<td align="left" bgcolor="#A8DAF3" class="headngblue ">Year of Commencement of Production
			:<span style="color:red">*</span></td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			  ${indusrtyInstance?.dateOfComm }
			</td>
		</tr>
			
		<tr>
		<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Invested on the Project <span style="color:red">*</span>: </td>
		<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
		${indusrtyInstance?.indCapInvt }
		</td>
	</tr>
	
	<tr>
	<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Applicant Name :</td>
	<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	  ${indusrtyInstance?.occName }
	</td>
	</tr>

		<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation : </td>
			<%  def occupierDesignation
			if(indusrtyInstance.occDesignation.equals("Others")){
			occupierDesignation=(indusrtyInstance.otherOccDesignation).toString()
			}else{
			occupierDesignation=(indusrtyInstance.occDesignation).toString()
			}
		 %>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			${occupierDesignation}
			</td>
			</tr> 
		
		
			
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indusrtyInstance?.indPin }
					</td>
			</tr> 
			
			
			
			<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No. With Code :</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			  ${indusrtyInstance?.indPhoneCode} -
			  ${indusrtyInstance?.indPhoneNo}
			  </td>
		   </tr>
		   
			<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. With Code:</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			  ${indusrtyInstance?.indFaxCode} -
			  ${indusrtyInstance?.indFaxNo}
			  </td>
		   </tr> 
			
			
			
		 	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indusrtyInstance?.occMobile }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-mail Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indusrtyInstance?.indEmail }
					</td>
			</tr> 
			
			
			<tr>
		    <td align="left" bgcolor="#A8DAF3" class="headngblue">No. of workers (including Contract Labour) :</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			${indusrtyInstance?.expNoEmp}
			</td>
			</tr>
			
			<tr>
			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Manufacturing Capacity :</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			${plasticWasteInstance?.manufactoringCapacity}
			</td>
			</tr> 
		
		
			<tr>
			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> PWM Authorization now Applied For <span style="color:red">*</span> :</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			<g:if test="${plasticWasteInstance?.authorisationAppliedFor =='fresh'}">
			Fresh
			</g:if>
			<g:else>
			Renewal
			</g:else>
			</td>
			</tr> 
			<g:if test="${plasticWasteInstance?.authorisationAppliedFor=='renew'}">
			<tr>
		 	<td  align="right" class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/viewAuthorisationPopup/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"><span class="headngblue">View</span></a></td> 
	
		</tr> 
		</g:if>
		
		<tr>
		  <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
			 <label for="activityAuthorizationSoughtFor">
			 Registration required for manufacturing of<span style="color:red">*</span>:</label>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">${plasticWasteInstance?.activityAuthorizationSoughtFor}
		</td>
			</tr> 
			
			
		   </table>
		   
      
		   
		   </div>
	    
	    
	    
         
         <div class="content" id="country2" >
         
		  <table class="tblbdr" width="75%" align="center">
                        <tbody>
                        	
                        
	                        <tr bgcolor="#A8DAF3">
							<td width="30%" align="left" valign="middle"  class="headngblue">Consent Validity for Water : </td>
							<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
							<fmt:formatDate value="${plasticWasteInstance.waterValidity}" pattern="dd/MM/yyyy" />
							</td>
							</tr>
							
							<tr bgcolor="#A8DAF3">
							<td width="30%" align="left" valign="middle"  class="headngblue">Consent Validity for Air : </td>
							<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
							<fmt:formatDate value="${plasticWasteInstance?.airValidity}" pattern="dd/MM/yyyy" />
							</td>
							</tr>
							
							<tr bgcolor="#A8DAF3">
							<td width="30%" align="left" valign="middle"  class="headngblue">Consent Validity for Authorization : </td>
							<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
							<fmt:formatDate value="${plasticWasteInstance?.authorizationValidity}" pattern="dd/MM/yyyy" />
							</td></tr>
							
							
							<%
                            def applicationDocs = WasteManagementFile.find("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachDistrictPlan' and abc.description='registered with District Industries Centre' and abc.applicationId=?",[plasticWasteInstance.id]);
                            %>
                            <tr class="headngblue" bgcolor="#A8DAF3">
                            <td width="30%" align="left" >Is the unit registered with District Industries Centre of the State Goverment or Union Territory ? if yes ,attatch a copy :</td>
                            <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
								${plasticWasteInstance?.districtIndustriesCenter}</br>
								<%if(applicationDocs){%>
							     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
				                 <g:link action="viewDocumentRecy_111" controller="plasticWaste" params="[appliLoc:fooVar8]">
			                     <span class="innerlink"><u>View Attachment</u></span>
			               </g:link>
						    <%}%>
							 </td>
							 </tr>
	                            
						
				   
				  
				   <%
				   def Manufacturing = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProcessManufacturing' and abc.description='Manufacturing Process' and abc.applicationId=?",[plasticWasteInstance.id]);
				   %>
				  
				  <tr class="headngblue" bgcolor="#A8DAF3">
				   <td width="30%" align="left" valign="middle"  class="headngblue">Manufacturing Process :</td>
				   <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				 	 <%if(Manufacturing){%>
				     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
	                 <g:link action="viewDocumentRecy_112" controller="plasticWaste" params="[appliLoc:fooVar8]">
                     <span class="innerlink"><u>View Attachment</u></span>
                     </g:link>
                     <%}else{%>Not Attached<%}%>
				 	      </td>
				 	     </tr> 
				  
				 	     <%
				 	    def collectionDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachWasteCollection' and abc.description='Waste Collection and transportation details' and abc.applicationId=?",[plasticWasteInstance.id]);
				 	     %>
				  <tr class="headngblue" bgcolor="#A8DAF3">
				   <td width="30%" align="left" valign="middle"  class="headngblue">Waste Collection and transportation details .:</td>
				   <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				 	 <%if(collectionDetails){%>
				     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
	                 <g:link action="viewDocumentRecy_113" controller="plasticWaste" params="[appliLoc:fooVar8]">
                     <span class="innerlink"><u>View Attachment</u></span>
                     </g:link>
                     <%}%>
				 	      </td>
				 	     </tr>    
				 	     
				 	    <tr class="headngblue" bgcolor="#A8DAF3">
						<td width="30%" align="left" >Provide details of the disposal facility, whether the facility is authorized by SPCB or PCC :</td>
						<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
						${plasticWasteInstance.detailsDisposalFacility}
						 </td>
						</tr>   
				 	     
						
						<%
						def analysisDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachAnalysisReport' and abc.description='analysis report' and abc.applicationId=?",[plasticWasteInstance.id]);
						%>
				 	    <tr class="headngblue" bgcolor="#A8DAF3">
				 	    <td width="30%" align="left" valign="middle"  class="headngblue">Please attach analysis report of characterization of waste generated(including leachate test if applicable) .:</td>
				 	   <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 	 <%if(analysisDetails){%>
					     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
		                 <g:link action="viewDocumentRecy_114" controller="plasticWaste" params="[appliLoc:fooVar8]">
	                     <span class="innerlink"><u>View Attachment</u></span>
	                     </g:link>
	                     <%}%> 
				 	   </td>
				 	    </tr>
				  
					 	<tr class="headngblue" bgcolor="#A8DAF3">
						<td width="30%" align="left" >Details of plastic waste proposed to be acquired through sale, auction, contract or import, as the case may be, for use as raw material :</td>
						<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Name 
						${plasticWasteInstance.namePlastic}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						Quantity : ${plasticWasteInstance.quantityPlastic}
						 </td>
						</tr>	     
					 	     
					 	     
					 	    <tr class="headngblue" bgcolor="#A8DAF3">
					        <td width="70%" align="left" valign="middle"  class="headngblue"><div>Details of Occupational Safety and health aspects :</div> </td>
					        <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
							${plasticWasteInstance.occupationalFacilities}
							</td>
					    </tr>
					 	     
				  <tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="30%" align="left" >Wheather the unit has adequate pollution control system or equipment to meet as standards of emission or effulant.:</td>
					 <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${plasticWasteInstance.emmisionEffulant}</br>		
					 ${plasticWasteInstance.emmisionEffulantDetails}
						</td>
				 </tr>
						
				 <tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="30%" align="left" >Wheather the unit is in compliance with condition laid down in said rules.:</td>
				 <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				 ${plasticWasteInstance.unitCompliance}</td>
										     
			  </tr>
			  <tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="30%" align="left" >Wheather conditions exists or are likely to exits of the material being handled or proccess posing adverse immediate or delayed impacts on the environment:</td>
				 <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				 ${plasticWasteInstance.materialProceed}</td>
			</tr>
			  <tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="30%" align="left" >Wheather conditions exists or are likely to exits of the material being handled or proccessed by any means capable of yielding another material (e.g leachate whicjh many posses eco toxicity):</td>
				 <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
				 ${plasticWasteInstance.materialHandled}</td>
			</tr>
				 
			<tr class="headngblue" bgcolor="#A8DAF3">
			 <td width="30%" align="left" >Any Other relative information including fire or accident mitigative measures :</td>
			 <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			 ${plasticWasteInstance.otherInfor}</td>
		</tr>
		<%
		def enclosureDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachEnclosure' and abc.description='List of enclosure as per rule' and abc.applicationId=?",[plasticWasteInstance.id]);
		%>
		  <tr class="headngblue" bgcolor="#A8DAF3">
			 <td width="30%" align="left" >List of enclosure as per rule:</td>
			 <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			 ${plasticWasteInstance.enclosure}
			 <%if(enclosureDetails){%>
		     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
             <g:link action="viewDocumentRecy_115" controller="plasticWaste" params="[appliLoc:fooVar8]">
             <span class="innerlink"><u>View Attachment</u></span>
             </g:link>
             <%}%></td>
									     
		  </tr>
						
                        </tbody>
                    </table>
                    
		   </div>
		   
		   <div class="content" id="country3" >
	        
			  <table class="tblbdr" width="75%" align="center">
	                      <tbody>
	                      
	  				<tr bgcolor="#A8DAF3">
						<td width="70%" align="center" valign="middle"  class="headngblue">Product Details</td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popProductDetailsView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					</tr>
	  				
	  			    <tr bgcolor="#A8DAF3">
	  					<td width="70%" align="center" valign="middle"  class="headngblue">By Product Details</td>
	  					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popByProductDetailsView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
	  				</tr>
	  				
	  				<tr bgcolor="#A8DAF3" >
						<td width="70%" align="center" valign="middle"  class="headngblue">Raw-Material Details</td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popRawMaterialView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					</tr>
					
					<tr bgcolor="#A8DAF3" >
					<td width="70%" align="center" valign="middle"  class="headngblue">Furnish a flow diagram of manufacturing process showing input and output in terms of products and waste generated including for captive power generation and water</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDescriptionOfProcessOfManufactureView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					</tr>
				
					
	                      
	                      </tbody>
	                      </table>
	             </div>
		   
	             <div class="content" id="country4" >
	             
	   		  <table class="tblbdr" width="75%" align="center">
	                       <tbody>
	                       
	                       <tr bgcolor="#A8DAF3">
	       				<td width="70%" align="center" valign="middle"  class="headngblue">Solid Waste or Rejects</td>
	       				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popWaterSolidWasteView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
	       			  </tr>
	       				
	       			  <tr bgcolor="#A8DAF3">
	     				<td width="70%" align="center" valign="middle"  class="headngblue">Waste Disposal Details</td>
	     				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDisposalView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
	     			  </tr>
	     			  
	     			<tr bgcolor="#A8DAF3">
	   				<td width="70%" align="center" valign="middle"  class="headngblue">Waste Generation Details</td>
	   				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popGenerationView/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
	   			  </tr>
	       			  
	       				<tr bgcolor="#A8DAF3">
	       					<td width="70%" align="center" valign="middle"  class="headngblue">Status of compliance with these rules-Thickness-fifty micron ?</td>
	       					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	       					${plasticWasteInstance.thiknessRulz}</td>
	       				</tr>
	       				
	       				
	       				<%
	       				def consentWaterDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentWater' and abc.description='consent under the Water' and abc.applicationId=?",[plasticWasteInstance.id]);
	       				%>
	       				<tr bgcolor="#A8DAF3">
	       				 <td width="70%" align="center" valign="middle"  class="headngblue" >Does the unit have a valid consent under the Water (Prevention and control of pollution) Act,1974 (6 of 1974)? if yes ,attatch a copy.:</td>
	       				<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	       				${plasticWasteInstance.waterAct}	
	       					<%if(consentWaterDetails){%>
				   		     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
				                <g:link action="viewDocumentRecy_116" controller="plasticWaste" params="[appliLoc:fooVar8]">
				                <span class="innerlink"><u>View Attachment</u></span>
				                </g:link>
				                <%}%></td>
	       			  </tr>
	       			  
	       			  
	       			  <%
	       			def consentAirDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachConsentAir' and abc.description='consent under the Air' and abc.applicationId=?",[plasticWasteInstance.id]);
	       			  %>
	       			  <tr bgcolor="#A8DAF3" >
	       				 <td width="70%" align="center" valign="middle"  class="headngblue"  >Does the unit have a valid consent under the Air (Prevention and control of pollution) Act,1981 (14 of 1981)? if yes ,attatch a copy.:</td>
	       				<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	       				${plasticWasteInstance.airAct}	       				  	 
	       				<%if(consentAirDetails){%>
			   		     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
			                <g:link action="viewDocumentRecy_117" controller="plasticWaste" params="[appliLoc:fooVar8]">
			                <span class="innerlink"><u>View Attachment</u></span>
			                </g:link>
			                <%}%></td>
	       										     
	       			  </tr>
	       			  
	       			  <%
	       			def personalBrandDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachPersonalBrand' and abc.description='list of personal or Brand owners' and abc.applicationId=?",[plasticWasteInstance.id]);
	       			  %>
	       			  <tr class="headngblue" bgcolor="#A8DAF3">
	       		      <td width="30%" align="left"  class="headngblue">Attach or provide list of personal or Brand owners to whom the products will be supplied.:</td>
	       		   <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	       		   <%if(personalBrandDetails){%>
		   		     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
		                <g:link action="viewDocumentRecy_118" controller="plasticWaste" params="[appliLoc:fooVar8]">
		                <span class="innerlink"><u>View Attachment</u></span>
		                </g:link>
		                <%}else{%>Not Attached<%}%>
	       			      </td>
	       			 </tr>
	       			 
	       			 
	       			 <%
	       			def supplyingPlasticDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachSupplyingPlastic' and abc.description='list of person supplying plastic' and abc.applicationId=?",[plasticWasteInstance.id]);
	       			 %>
	       			 <tr class="headngblue" bgcolor="#A8DAF3">
	       		     <td width="30%" align="left"  class="headngblue">Attach or provide list of person supplying plastic to be used as raw material to manufacture carry bags or plastic sheet of like or multilayered packaging.:</td>
	       		  <td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	       		   <%if(supplyingPlasticDetails){%>
		   		     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
		                <g:link action="viewDocumentRecy_119" controller="plasticWaste" params="[appliLoc:fooVar8]">
		                <span class="innerlink"><u>View Attachment</u></span>
		                </g:link>
		                <%}else{%>Not Attached<%}%>
	       		     </td>
	       		    </tr>
	       		    
	       		    <%
	       		    def producersQuantumDetails = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='attachProducersQuantum' and abc.description='List of producers and quantum' and abc.applicationId=?",[plasticWasteInstance.id]);
	       		    %>
	       		    
	       			<tr class="headngblue" bgcolor="#A8DAF3">
	       			<td width="30%" align="left" valign="middle"  class="headngblue">List of producers and quantum of raw materials supplied to producers :</td>
	       			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
	       			<%if(producersQuantumDetails){%>
	   		     <g:def var="fooVar8" value="${plasticWasteInstance.id}"/>
	                <g:link action="viewDocumentRecy_120" controller="plasticWaste" params="[appliLoc:fooVar8]">
	                <span class="innerlink"><u>View Attachment</u></span>
	                </g:link>
	                <%}else{%>Not Attached<%}%></td>
	       	    </tr>
	       			
	       	    
	       		    <tr class="headngblue" bgcolor="#A8DAF3">
	       			<td width="30%" align="left" valign="middle"  class="headngblue">Action Plan on collecting back the plastic waste :</td>
	       			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${plasticWasteInstance.actionPlan}</td>
	       	    </tr>
	       	    
	                       </tbody>
	                       </table>
	              </div>
	              
	              
	              
	              <div class="content" id="country5" >
		   	        
	   			  <table class="tblbdr" width="75%" align="center">
	   	                      <tbody>
	   	                      
	   	  				<%
	   			 def cat = IndustryRegMaster.findById(indusrtyInstance.id.toLong())
	   			 def capInv = indusrtyInstance.indCapInvt.toInteger()
	   			 def noOfMaterials = indusrtyInstance.plotNo
	   			%>									
	   						<tr>
	   							<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
	   							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue" > ${cat.category.name}</td>
	   						</tr> 
	   						
	   						<input type="hidden" id="catVale" value="${cat.category.name}">
	   						<input type="hidden" id="noOfBeds" value="${capInv}">
	   						<input type="hidden" id="noOfMaterials" value="${noOfMaterials}">
	   						<!--by shashank-->
	   						<!--<input type="hidden" id="typeHce" value="cat.other">-->
	   						<input type="hidden" id="bedNo" value="${cat.plotNo}">
	   						
	   					
	   						
	   						
	   				
	   				
	   				
	   						<%
							def consentFeeMasterInst = ConsentFeeMasterPWM.findByApplication(plasticWasteInstance)
							%>
							<tr>
								<td align="left" valign="middle" bgcolor="#A8DAF3"
									class="headngblue">Number of Years:</td>
								<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'noOfYears')}</td>
							</tr>
	   						
							<tr>
							
							<td align="left" valign="middle" bgcolor="#A8DAF3"
								class="headngblue">Total Fee Applied </td>
							<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInst,field:'calculatedFee')}<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
						</tr>  
	   					  
	   					</td></tr>
	   			
	   						<tr bgcolor="#417FB2">
	   							<td colspan="2">
	   							<table width="100%" cellpadding="0" cellspacing="0">
	   								<tr>
	   								<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
	   								<td  align="right" valign="middle"  class="headngblue"></td>
	   								</tr>
	   							</table>
	   							</td>
	   						</tr>
	   						
	   						<tr>
	   							<td colspan="2">
	   							<table width="100%" border="0" >
	   							<tr>
	   							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsViewPWM/<%=plasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
	   							</tr>
	   							</table>
	   							</td>
	   						</tr>  
	   			
	   	                            
	   	                        </tbody>
	   	                    </table>
	   	                    
	   			   </div>
	   	    
	   			<div class="content" id="country6" >
   		        
 				  <table class="tblbdr" width="75%" align="center">
 		                      <tbody>
 		                      
 		                     <tr>
 							<td bgcolor="#FFFFFF">
 							<table width="100%" border="0" align="left"
 								cellpadding="2" cellspacing="1" class="tblbdr">

 								<tr bgcolor="#D1D1D1">
 									<td colspan="2" align="center" valign="middle"
 										class="headngblue">Documents Details</td>
 								</tr>
 								
 							<%
 								def docList = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='PWM' and abc.typeOfFile='PWM Documents' and  abc.applicationId=? order by abc.id asc",[plasticWasteInstance.id])
 								System.out.println("docList.id--------------------------------->"+docList);
 								%>
 								<g:def var="dList" value="${DocumentChecklistMaster.list()}" />
 								<g:each var="doc" in="${docList}">
 								<tr>
 									<td width="60%" align="left" valign="middle"
 										bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
 									<td width="40%" align="left" bgcolor="#E8F6F9"
 										class="headngblue"><g:def var="fooVar"
 										value="${plasticWasteInstance.id}"/><g:def var="docN" value="${doc.description}"/> <g:link
 										action="viewFile1"
 										params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
 								</tr>
 								</g:each>
 								
 							</table>


 							</td>
 						</tr>
 		                        </tbody>
 		                    </table>
 		                    <div align="center" class="txt" style="color: navy">
 		   <br>
 		   &nbsp;<b>* Instructions:</b> <br>
 		   Please select "Yes" if you want to send the documents By Post/ By Hand and "No" to upload the required document online.<br>For Online Document Upload:
 		   &nbsp;
 		   <ul>
 		      <li>Click link "Upload" to upload the document</li>
 		      <li>Click "Browse" to select the document</li>
 		      <li>You can select multiple documents at the same time</li>
 		      <li>Select all the documents by clicking "Browse" button</li>
 		      <li>Select all the documents by clicking "Browse" button</li>
 		      <li>Click "Save" button to upload the document</li>
 		      <li>Message "Document successfully uploaded" will be displayed</li>
 		   </ul>
 		</div>
 				   </div>
	   		   
 					<%
 					def editableMode=false
 					def scrutinyReturn=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId= ? order by id desc",[plasticWasteInstance.id.toString()])
 					System.out.println("scrutinyReturn+++++"+scrutinyReturn);
 					def returnAppProcess=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails w where w.applicationId=? order by dateCreated desc",[plasticWasteInstance.id.toString()])
 					System.out.println("returnAppProcess+++++"+returnAppProcess);
 																	 		
 			%>	
	   		   
	             
	             
		   
 			<%
 			//System.out.println("VINEET COMPLETION STATUS---A"+plasticWasteInstance.completionStatus);
 			//System.out.println("VINEET COMPLETION STATUS---B"+plasticWasteInstance.completionStatus);
 			%>	
 			
		   <table width="75%" align="center">
           <tbody>
			        <tr class="prop">
                      <td valign="top" align="center">
                      <g:if test="${plasticWasteInstance?.completionStatus=='Inprogress'}">
                       <div class="buttons">
			                <g:form>
			                    <input type="hidden" name="id" value="${plasticWasteInstance?.id}" />
			                    <span class="button"><g:actionSubmit class="edit" value="Edit" class="actionbutton"/></span>
			                </g:form>
			            </div>
			            </g:if>
                      </td>
                  </tr> 
          </tbody>
          
      </table>
      
      <%  if(returnAppProcess) { if(returnAppProcess.returned==true && returnAppProcess.resubmitStatus==false){ testVal=true%>
      <div class="buttons">
              <input type="hidden" name="id" value="${plasticWasteInstance?.id}" />
               <input type="hidden" name="testValue" value="<%=testVal%>" />
              <table width="75%" align="center">
                   <tbody>
					        <tr class="prop" >
                              <td valign="top" align="center">
              					<span class="button"><g:actionSubmit class="edit" value="Edit" class="actionbutton"/></span>
              					</td>
                          </tr> 
                  </tbody>
        		</table>
        		
      </div><% }}
      else{
			%>
	       <div class="buttons">
             
              <table width="75%" align="center">
                   <tbody>
					        <tr class="prop" >
                               
             					
             					
              					
              					
              					
              					
              					
              					
              					
              					
              					
                          </tr> 
                  </tbody>
        		</table>
        		
        		
      </div>
      <%}%>
		      </g:form>


      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
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
 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 

function tosubmit()
{
 
 frmvalidator.addValidation("nameNodal","req","Please enter Name of Nodal officer");
 frmvalidator.addValidation("nameNodal","alpha_s","enter valid Name of Nodal officer");

 frmvalidator.addValidation("desigNodal","req","Please enter Designation of Nodal officer");
 frmvalidator.addValidation("desigNodal","alpha_s","enter valid Designation of Nodal officer");
	
 frmvalidator.addValidation("authApp","req","Please enter Authorization Applied for");
 frmvalidator.addValidation("authApp","alpha_s","enter valid Authorization Applied for");
 
 frmvalidator.addValidation("locationSite","req","Please enter Location of Site");
 frmvalidator.addValidation("locationSite","alpha_s","enter valid Location of Site");
 
 frmvalidator.addValidation("qtyProcessed","req","Please enter Quantity Processed");
 frmvalidator.addValidation("qtyProcessed","numeric","enter valid Quantity Processed");
 
 frmvalidator.addValidation("invenstment","req","Please enter Invenstment");
 frmvalidator.addValidation("invenstment","numeric","enter valid Entry for Invenstment");

 frmvalidator.addValidation("expectedReturn","req","Please enter Expected Return");
 frmvalidator.addValidation("expectedReturn","numeric","enter valid Entry Expected Return");
 
 frmvalidator.addValidation("nameWasteProcessingTech","req","Please enter Name of Waste Processing Technology");
 frmvalidator.addValidation("nameWasteProcessingTech","alpha_s","enter valid Name of Waste Processing Technology");
 
 frmvalidator.addValidation("numSites","req","Please enter Number of sites indentified:");
 frmvalidator.addValidation("numSites","numeric","enter valid Number of sites indentified:");
 
 frmvalidator.addValidation("qtyDisposed","req","Please enter Quantity of waste to be disposed per day");
 frmvalidator.addValidation("qtyDisposed","numeric","enter valid Quantity of waste to be disposed per day");
 
 frmvalidator.addValidation("natureWaste","req","Please enter Nature of waste");
 frmvalidator.addValidation("natureWaste","alpha_s","enter valid Nature of waste");
 
 frmvalidator.addValidation("compWaste","req","Please enter Composition of waste:");
 frmvalidator.addValidation("compWaste","alpha_s","enter valid Composition of waste:");
 
 frmvalidator.addValidation("processingTechnology","req","Please Attach File for Details of Processing Technology");
	    		
frmvalidator.addValidation("siteclearence","req","Please Attach File for Site clearence (from Local Authority)");

frmvalidator.addValidation("detail","req","Please Attach File for Details of agreement between municipal authority and operating agency");

frmvalidator.addValidation("utilizationprogramme","req","Please Attach File for Utilization programme for waste processed (Product utilization)");

frmvalidator.addValidation("methodology","req","Please Attach File of Methodology for disposal of waste processing rejects (quantity and quality)");

frmvalidator.addValidation("detailsexistingsite","req","Please Attach File for Details of Existing Site under Operation");

frmvalidator.addValidation("layoutmaps","req","Please Attach File for Layout maps of site");

frmvalidator.addValidation("detailmethodologyorcriteria","req","Please Attach File for Details of methodology or criteria followed for site selection");

frmvalidator.addValidation("methodologyoperationaldetails","req","Please Attach File for Methodology and operational details of landfilling");


 return true;
}
 
</script>

</body>
</html>


