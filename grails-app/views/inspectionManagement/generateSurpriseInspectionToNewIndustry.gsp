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
            if(e != null ){
         		//${remoteFunction( controller:'inspectionManagement', action:'ajaxGetDistrictByGroup', params:'\'id=\' + escape(this.value)', onComplete:'updateDistrict(e)')}
         		$.ajax({
         url : '/OCMMS/inspectionManagement/ajaxGetDistrictByGroup?id='+e.value,
         //data : data,
         //contentType : 'application/json',
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
      			
function redirectPage()
{
   //redirectAnchor
   var anchorObj=document.getElementById("redirectAnchor");
   anchorObj.click()
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
      <% String cont=request.getContextPath();%>
      <g:javascript library='scriptaculous'/>
      <g:javascript>
         window.onload = function()   
         {              
         new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
         }
      </g:javascript>
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
         <td align="left" valign="top">
            <table width="1003" border="0" cellspacing="0" cellpadding="0">
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
                     <g:include controller="inspectionManagement" action="showSpcbInspectionManagementMenu"/>
                     <%	}
                        } %>
                     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
                     <g:include controller="userMaster" action="showIndexMenu"/>
                     <% } %>
                     <!-- End of menuAdmin-->
                  </td>
                  <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                  <td width="778" align="left" valign="top">
                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
                                             %{--bhanu code ends --}%
                                             </td>
                                             <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
                                          </tr>
                                       </table>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td  align="left">
                                       <a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/showSurpriseApplicationList?id=${industryDetails.id}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Application&nbsp;|</span></a>
                                       &nbsp; <a href="#" onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/showSurpriseInspectionNoteHistroy?id=${industryDetails.id}', 'ApplicationHistory', 'WIDTH=690,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Surprise Inspection Note Histroy&nbsp;|</span></a>	 
										
                                    </td>
                                    <td >&nbsp;</td>
                                 </tr>
                              </table>
                           </td>
                        </tr>
                        <tr>
                           <td height="0" align="left" valign="top" >
                              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                 <tr>
                                    <!-- Div area for errors-->
                                    <td align="center" valign="top">
                                       <div style="width:400px; height:20px; vertical-align:middle">
                                          <span class="error">
                                             <g:if test="${flash.message}">
                                                <div class="message">${flash.message}</div>
                                             </g:if>
                                          </span>
                                       </div>
                                    </td>
                                 </tr>
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
                                                <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                                                <g:form action="searchIndustryByName" name="myform" method="post" >
                                                   <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                      <tr>
                                                         <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Generate Surprise Inspection</a></td>
                                                         <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                                                         <td width="432" align="right"></td>
                                                      </tr>
                                                   </table>
                                                   <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                                      <tr  bgcolor="#E8F6F9">
                                                         <td width="15%" align="left"  class="headngblue" >Industry Name :</td>
                                                         <td width="33%" align="left" >${industryDetails.indName} </td>
                                                      </tr>
                                                      <tr  bgcolor="#E8F6F9">
                                                         <td width="15%" align="left"  class="headngblue" >Registerd Date :</td>
                                                         <td width="33%" align="left" >${industryDetails.dateCreated} </td>
                                                      </tr>
                                                      <tr  bgcolor="#E8F6F9">
                                                         <td width="15%" align="left"  class="headngblue" >Category:</td>
                                                         <td width="33%" align="left" >${industryDetails.category.name} </td>
                                                      </tr>
                                                      <tr  bgcolor="#E8F6F9">
                                                         <td width="15%" align="left"  class="headngblue" >Industry Type:</td>
                                                         <td width="33%" align="left" >${industryDetails.indType.name} </td>
                                                      </tr>
                                                      
                                                      
                                                      </tr>
                                                   </table>
                                                   <table width="100%"  border="0" align="center" class="tblbdr">
                                                      <tr >
															<td  width="50%" bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
			 												<td  width="50%" align="left" bgcolor="#98AFC7"  class="headngblue">
			 	
																<input name="inspection" type="radio" onclick="redirectPage()" value="yes">
			
															<% 
			    											def forwardCriteria = InspectionForwardCriteria.find("from InspectionForwardCriteria where categoryType=? AND forwardRoleType = 'MS' ",[industryDetails.category.name])
			    											System.out.println("forwardCriteria >> "+forwardCriteria);
															%>
						
             												<g:if test="${forwardCriteria != null }">                 
                												 <a id="redirectAnchor" href="<%=request.getContextPath()%>/inspectionManagement/fwdSurpriseInspectionToMS?id=<%=industryDetails.id%>&fwdRoleName=${forwardCriteria.roleName}"></a>
            												 </g:if>
            												 <g:else>
                												 <a id="redirectAnchor" href="<%=request.getContextPath()%>/applicationProcessingDetails/forwardSurpriseInspectionOrderDEFAULT?industryId=<%=industryDetails.id%>"></a>
            												 </g:else>                    <span class="style3">Yes</span>
                              										  <input name="inspection" type="radio" value="no" checked="checked">
                               														 <span class="style3">No</span>					
                             							   </td>
														</tr>
														
	
			<g:if test="${showCloseInspectionSection}" >	
				
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
 				
				<tr >
					<td colspan="2" bgcolor="#BFBFBF" class="headngblue" >Do you want to Prepare Surprise Inspection Report? : </td>
			 	</tr>
				
				
				<tr >
                    <td colspan="2">
                        <div >
                          <table width="100%" cellpadding="0" cellspacing="0">
				               <tr >
									<td width="33%" bgcolor="#BFBFBF" class="headngblue" >Surprise Inspection Note : </td>
									<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
										<textarea name="inspectionCloseNote" cols="35" class="txt4"></textarea></span>
									</td>
				               </tr>
				
				<!--
				               <tr>
									<td  bgcolor="#BFBFBF" class="headngblue" ></td>
				                    <td bgcolor="#BFBFBF" class="headngblue" align="left">
									    <a href="#" onclick="window.open('<%=request.getContextPath()%>#/applicationProcessingDetails/popConsentInspectionReport/', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" >Prepare Surprise Inspection Report with Recommendation </a><br>
				                    </td>
			 	               </tr> -->
			 	               
			 	               <tr>
									<td  bgcolor="#BFBFBF" class="headngblue" ></td>
				                    <td bgcolor="#BFBFBF" class="headngblue" align="left">
									   <!-- <a href="<%=request.getContextPath()%>/SPCB_DOCUMENTS/INSPECTION REPORT FOR ALL UNITS.pdf" target="_blank">Download Inspection Format</a> 
                   	        			&nbsp; | <a href="<%=request.getContextPath()%>/SPCB_DOCUMENTS/Check List for CTE.docx" target="_blank">Download Check List Format</a>
                   	        			<br> -->
				                    </td>
			 	               </tr>
							   <tr >
									<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
									<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="style6">
					 				       <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/popUploadMoreSurpriseInspectionDoc?industryId=${industryDetails.id}', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" >Upload Surprise Inspection Report</a>
				                          </span>	
					                 </td>
				               </tr>	
				          </table>
						</div>
					</td>
				</tr>			
        	 
        	
														
			                                       </table>
			                                       
			                                       
        	           </table>
        	 <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td></td>
			<td align="center"><input type="submit" name="Save" id="Save" value="Save" class="actionbutton"  ></td>
		<td align="left"></td>			
		  </tr>
		</table>
		   </g:if>       
			                                       
                                                </g:form>
                                                <br />
                                                <g:if test="${abc}">
                                                   <table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                                                      <tr height="20" bgcolor="#A8DAF3">
                                                         <th align="center" class="headngblue" >SI. No.</th>
                                                         <th align="center" class="headngblue" >Industry Name</th>
                                                         <th align="center" class="headngblue" >Type</th>
                                                         <th align="center" class="headngblue" >Category</th>
                                                         <th align="center" class="headngblue" >Registerd Date</th>
                                                         <th align="center" class="headngblue" >Status</th>
                                                      </tr>
                                                      <g:each in="${abc}" status="i" var="abc">
                                                         <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                                            <td align="center" height="25" class="txt4"  >${i+1}</td>
                                                            <td align="center" height="25" class="txt4"  >
															<g:link action="generateSurpriseInspectionToNewIndustry" controller="inspectionManagement" id="${abc.id}"><u>${abc.indName}</u></g:link></td>
															<td align="center" height="25" class="txt4"  >${abc.indType.name}</td>
															<td align="center" height="25" class="txt4"  >${abc.category.name}</td>
															<td align="center" height="25" class="txt4"  >${abc.dateCreated}</td>
															<td align="center" height="25" class="txt4"  >${abc.indStatus}</td>
														</tr>
                                                      </g:each>
                                                      
                                                   </table>
                                                </g:if>
												<br><br>
												<g:if test="${showMessage == true}">
													<span style="color="red;">Note*- <g:link action="create" controller="industryRegMaster" id="${abc.id}" target="_blank" >Click here </g:link>   to register new industry with this name .</span>
													<br><br>
												</g:if>
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
                     </table>
                  </td>
               </tr>
            </table>
   </body>
   <script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 
	
 frmvalidator.addValidation("autocomplete1","req","Please enter Industry Name");
 </script>
</html>