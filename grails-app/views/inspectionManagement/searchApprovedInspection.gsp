<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
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
      <script type="text/javascript" src="js/tabcontent.js"></script>
      <script type="text/javascript">
         anylinkmenu.init("menuanchorclass")
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
      
      <script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
      <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
     
	  <script>
		function hitAjaxCall(e){
		var url = 'ajaxGetDistrictByGroup?id='+e.value; 
		if(e != null ){
		    //${remoteFunction( controller:'inspectionManagement', action:'ajaxGetDistrictByGroup', params:'\'id=\' + escape(this.value)', onComplete:'updateDistrict(e)')}
			$.ajax({
			url : url,
			type : 'GET',
		    dataType : 'json',
		    crossDomain : true,
			//success : function(data, status, xhr){
				success: function(result){
				 if(result != null){
					console.log("data 11 >> "+result );
					updateDistrict(result);
					
				}else{
					alert("Result not found from server plese refresh your page and then try !! ");
				}
			}
		});
			   }
			}
	  
	  
	  </script>
	  
	  
	  <script>
         function updateDistrict(result){
         //	console.log("e >> "+result);
         
         if (result != null ) {
         var rselect = document.getElementById('districtId')
         
         // Clear all previous options
         var l = rselect.length
         
         while (l > 0) {
         l--
         rselect.remove(l)
         }
         
		 var opt = document.createElement('option');
         opt.text = 'ALL'
		opt.value = 'ALL'
		rselect.add(opt)
					
		 
         // Rebuild the select
         for (var i=0; i < result.length; i++) {
         var tehsil = result[i]
         var opt = document.createElement('option');
         opt.text = tehsil.districtName
         opt.value = tehsil.id
         try {
         rselect.add(opt, null) // standards compliant; doesn't work in IE
         }
         catch(ex) {
         rselect.add(opt) // IE only
         }
         }
         }
         
         
         }
         
         
         
      </script>
   <% 
         String contex=request.getContextPath();
         
         if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
         
                     response.sendRedirect(contex+"/index.gsp")  ;     
         
         } %>
   </head>
   <body AUTOCOMPLETE=OFF>
      <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
         <tr>
            <td align="left" valign="top">
               <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
                  <%	
                     boolean decVar=true;
                     String firstname;
                     String lastName;
                     String access;
                     String indname;
                     	
                     if((UserMaster)session.getAttribute("userMaster"))
                     	{ 
                     
                     
                                  		UserMaster um=(UserMaster)session.getAttribute("userMaster");
                        	  		 UserProfile aab=(UserProfile)session.getAttribute("userprof");
                                 		  firstname=aab.employeeFirstName;
                               		  lastName=aab.employeeLastName;
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
                        <table width="100%">
                           <!--<tr>        
                              <td align="center" valign="top">Row for Page Heading</td>
                              </tr>-->
                           <tr>
                              <td height="0" align="left" valign="top">
                                 <table width="778" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                       <td width="82" align="left" valign="top">&nbsp;</td>
                                       <td align="left" valign="top">
                                          <div style="padding:0px 0px 0px 0px;" >
                                             <br/>
                                             <g:form action="searchApprovedApplicationList" name="myform" method="post" >
                                                      <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                                          <tr  bgcolor="#E8F6F9">
                                                            <td width="15%" align="left"  class="headngblue" >Start Date :</td>
                                                            <td width="33%" align="left" >
																<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
															</td>
															
															
                                                            <td  width="15%" align="left"  class="headngblue">End Date:</td>
                                                            <td width="33%" align="left"   >
                                                               <calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                                                            </td>
                                                         </tr>
                                                         
                                                         <tr  bgcolor="#E8F6F9">
                                                            <td width="15%" align="left"  class="headngblue" >Group :</td>
                                                            <td width="33%" align="left" >
																<g:select class="txt4" optionKey="id" from="${grp}" name="group" noSelection="${['xyz':'Not Selected']}" 
																		onchange="hitAjaxCall(this);"   ></g:select>
															</td>
															
															
                                                            <td  width="15%" align="left"  class="headngblue">District :</td>
                                                            <td width="33%" align="left"   >
                                                               <g:select optionKey="id" optionValue="name" name="district" noSelection="${['ALL':'ALL']}"  id="districtId"  value="" > </g:select>
                                                            </td>
                                                         </tr>
														  <tr  bgcolor="#E8F6F9">
                                                         <td width="30%" align="left"  class="headngblue" >Category:</td>
                                                         <td  align="left" class="headngblue">
                                                            <select  name="category">
                                                               <option value="None">None</option>
                                                               <option value="RED">RED</option>
                                                               <option value="GREEN">GREEN</option>
                                                               <option value="ORANGE">ORANGE</option>
                                                            </select>
                                                         </td>
														 <td>&nbsp;</td>
														  <td>&nbsp;</td>
                                                         </tr>
                                                         </tr>
                                                      </table>
                                                      <table width="100%"  border="0" align="center" class="tblbdr">
                                                         <tr>
                                                            <td width="33%" align="center"><input type="submit" name="Search" value="Search" class="actionbutton"></td>
                                                         </tr>
                                                      </table>
                                                   </g:form>
                                                
                                                <!--<FORM id="myForm" name='myForm' action="search" method="post">-->
                                                <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                   <tr>
                                                      <td colspan="9" align="center" >		
                                                         <span class="headngblue">
                                                         <span style="color:red;font-size:13px;">Approved Inspection Report </span> 
                                                         </span>
                                                      </td>
                                                   </tr>
                                                  
                                                </table>
                                                <div style="overflow: auto;height: 600px; width: 1000px;">
                                                   
													<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="white" class="tab-txt" style="border-collapse:collapse;">
                                                      <tr>
                                                         <td bgcolor="#FFFFFF">
                                                            <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                                                               <thead>
                                                                  <tr height="40" bgcolor="#A8DAF3">
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">SI. No.</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Application No.</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Application Name</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Application Type</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Application Date</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Category</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Application For</th>
                                                                     <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Certificate For</th>
																	 <th class="headngblue" style="width:5%;border-bottom:3px solid green;" align="center">Status</th>
                                                                  </tr>
                                                               </thead>
                                                               <tbody>
                                                                  <%if(!listOfApplication){ %>
                                                                  <tr>
                                                                     <td colspan="8" height="25" align="center" class="txt4"></td>
                                                                  </tr>
                                                                  <%} 
                                                                     else{
                                                                      
                                                                     %>
                                                                  <g:each in="${listOfApplication}" status="i" var="indList">
                                                                     <% 
                                                                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
                                                                        
                                                                         String strDate = sdfDestination.format(indList.actualApplicationDate);
                                                                         String classToPick="#1F6FB7";
                                                                        
                                                                        %>
                                                                     <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                                                    	<td height="25" align="center" class="txt4"><b>${i+1}.</b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>">
                                                                         <u>
                                                                            <g:link action="inspectionProcessing" controller="inspectionManagement" id="${indList}">${indList}</g:link>
                                                                         </u>
                                                                        </a></font></b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.applicationName%></font></b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.applicationType%></font></b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=strDate%></font></b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.indUser.category.name%></font></b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.applicationFor%></font></b></td>
                                                                        <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.certificateFor%></font></b></td>
																		<td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.certificateFor%></font></b></td>
                                                                     </tr>
                                                                  </g:each>
                                                                  <%}%>
                                                               </tbody>
                                                            </table>
                                                   <br />
                                                   <br />
                                                </div>
                                             </form>
                                          </div>
                                          </div>
                                       </td>
                                       <td width="82" align="left" valign="top">&nbsp;</td>
                                    </tr>
                                 </table>
                              </td>
                           </tr>
                        </table>
                     </td>
                  </tr>
               </table>
            </td>
         </tr>
      </table>
      </td>
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