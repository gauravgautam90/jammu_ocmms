<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
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
						 	<td class="top-lnks">Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
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
              							<g:def var="appForWhich1" value="MSW"/><g:def var="applicationId" value="${municipalSolidWasteInstance.id}"/>
              <tr><td>
              <%if(municipalSolidWasteInstance.applicationStatus=="approved") {%>
              				
              <%

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ 
		}else {
               } %> &nbsp;<g:link controller="bioMedicalWaste" action="viewBioCert"  id="${certInstanceId}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
            	  <%} 
            	  if(  (IndUser)session.getAttribute("indUser")  )
		
		{ 
		}else {%>
              <a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a> <% } %> 
                        </td></tr>
                          
                          
                          
                            <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                    <span class="error"> 
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${municipalSolidWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${municipalSolidWasteInstance}" as="list" />
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
    <input type="hidden" name="muId" value="${municipalSolidWasteInstance?.id}" />
   		<table width="75%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td>
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Municipal Solid Waste</span></a></li>
					</ol>
				  </td>
				 <g:if test="${municipalSolidWasteInstance?.completionStatus=='Completed'}">
	                                                
				  <td  align="right" class="headngblue"><!--<a href="#" onclick="window.open('../printMunicipalSolidWaste?id=<%=municipalSolidWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1');">--><a href="<%=request.getContextPath()%>/municipalSolidWaste/viewMswPdf?appliLoc=<%=municipalSolidWasteInstance?.id%>"><span class="headngblue">Print Preview</span></a></td>
				</g:if></tr>	
	    </table>
         
         <div class="content" id="country2" >
         
		  <table class="tblbdr" width="75%" align="center">
                        <tbody>
                        	
                        <tr >
						    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Nodal Officer Details ( Officer authorised by the municipal authority or </td>
						</tr>
                        	<tr >
						    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">agency responsible for operation of processing or disposal facility):</td>
						</tr>
                       	   <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameNodal">Name of Nodal officer:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'nameNodal')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="desigNodal">Designation of Nodal officer:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'desigNodal')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authApp">Authorization Applied for:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'authApp')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td valign="top"  bgcolor="#A8DAF3" class="headngblue">
                                    <label for="authApp">Authorization Type :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'authorizationType')}
                                </td>
                            </tr> 
                            
                            <tr >
							    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Processing of waste </td>
							</tr>
                        	
					        <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="locationSite">Location of Site:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'locationSite')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="qtyProcessed">Quantity of waste to be processed per day: :</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'qtyProcessed')} 
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'unitMasterobjqtyPro')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures to be taken for prevention and control of environmental pollution:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresPrevention')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures to be taken for safety of workers working in the plant:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresSafety')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="invenstment">Investme on Project (In Lakhs) : </label>
                                </td>
                                <td valign="top"  bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'invenstment')} 
                                </td>
                            </tr> 
                            
                             <tr class="prop">
                               <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="expectedReturn">Expected Return from Project (In Laks): </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'expectedReturn')} 
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="nameWasteProcessingTech">Name of Waste Processing Technology: </label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'nameWasteProcessingTech')}
                                </td>
                            </tr> 
                            
                           
							
							<g:each var="doc" in="${listDoc}">
							<tr>
								<td width="60%" align="left" valign="middle"
									bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
								<td width="40%" align="left" bgcolor="#E8F6F9"
									class="headngblue"><g:def var="fooVar"
									value="${doc.id}"/><g:def var="docN" value="${doc.applicationFor}"/> <g:link
									action="viewFile1"
									params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
							</tr>
							</g:each>
							
							<tr >
							    <td colspan="2" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}">Disposal of Waste </td>
							</tr>
                            
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="numSites">Number of sites indentified:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'numSites')} 
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="qtyDisposed">Quantity of waste to be disposed per day:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'qtyDisposed')}
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'unitMasterobjqtyDis')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="natureWaste">Nature of waste:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'natureWaste')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label for="compWaste">Composition of waste:</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'compWaste')}
                                </td>
                            </tr> 
                            
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
                                    <label >Measures taken to check enviornmental pollution::</label>
                                </td>
                                <td valign="top" bgcolor="#E8F6F9" class="headngblue">
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresPollution')}
                                </td>
                            </tr> 
							
                        <tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Application Status
		                	</td>
		                	<td valign="top" bgcolor="#E8F6F9" class="headngblue">
							${fieldValue(bean:municipalSolidWasteInstance,field:'completionStatus')}  
		                	</td>
						</tr>
						
                        </tbody>
                    </table>
                    
                    <table width="75%" align="center">
	                     <tbody>
						        <tr class="prop">
	                                <td valign="top" align="center">
	                                <g:if test="${municipalSolidWasteInstance?.completionStatus=='Inprogress'}">
	                                 <div class="buttons">
						                <g:form>
						                    <input type="hidden" name="id" value="${municipalSolidWasteInstance?.id}" />
						                    <span class="button"><g:actionSubmit class="edit" value="Edit" class="actionbutton"/></span>
						                </g:form>
						            </div>
						            </g:if>

	                                </td>
	                            </tr> 
	                    </tbody>
	                    
                    </table>
                    
		   </div>
		
		   <div class="content" id="country1" >
		   <table width="75%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Municipal Authority/ Name of the agency appoined by the Municipal Authority  :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indName }
					</td>
				</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Corrospondence Address :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indAddress }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occCity } 
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occDistrict }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Tehsil :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occTehsil }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indPin }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Telephone Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.indPhoneNo }
					</td>
			</tr> 
		   
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Number:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstanceGet?.indFaxNo }
					</td>
			</tr> 
			
		 	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstanceGet?.occMobile }
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-mail Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstanceGet?.indEmail }
					</td>
			</tr> 
		   
		   </table>
		   
         
		   
		   </div>
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


