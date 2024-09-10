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

       <!-- bhanu code start; date: 20-06-2017 -->
       <%

           def isAdmin = false
           if((UserMaster)session.getAttribute("userMaster")){
               UserMaster aa1 = (UserMaster)session.getAttribute("userMaster");
               String userType1 = aa1.accessLevel
               if(userType1.equals("admin")) {
                   isAdmin = true
               }
           }

       %>
       <!-- bhanu code ends -->


       <!-- bhanu code start; date: 30-05-2017 -->
       <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'design.css')}"/>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       <script type="text/javascript">
           $(document).ready(function() {
               $('#country2').hide();
               // bhanu code start; date: 12-06-2017
               <%if(addPreviousInspection){%>
               $('#addPreviousInspection').click();
               <%}%>
               // bhanu code ends

               function groupNotFoundAlert() {
                   alert("Please add previous inspection report on this industry by searching industry district")
               }

               <%if(!isAdmin){%>
               $('#addPreviousInspection').click();
               <%}%>
           });
       </script>
       <!-- bhanu code ends -->
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
         
         
         
      function checkGroupSelect()
      { 
       var selGroup=document.getElementById("group").value;
       if (selGroup=='xyz') 
		  {
		    alert("Please select Group");
		    return false;
		  }
	   else
		  {
		     return true;
		  }
       
      }


//      bhanu code start; date: 30-05-2017
        function  hideShow1() {

            document.getElementById('addPreviousInspection').style.color = '#008';
            $('#country2').hide();
            $('#country1').show();
            document.getElementById('regularInspection').style.color = '#fff';

        }

       function  hideShow2() {

           document.getElementById('addPreviousInspection').style.color = '#fff';
           $('#country2').show();
           $('#country1').hide();
           document.getElementById('regularInspection').style.color = '#008';


       }
         //      bhanu code ends
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
      <!-- <tr>
         <td align="left" valign="top">
            <table width="1003" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  
                  <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                  <td width="778" align="left" valign="top">
                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                           <td height="1" valign="top"></td>
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
                                       <table width="100%" border="0" cellspacing="0" cellpadding="0"><!-- bhanu date: 04-07-2017 change width from 1000 to "100%" -->
                                          <tr>
                                             %{--<td width="82" align="left" valign="top">&nbsp;</td>--}%
                                             <td align="left" valign="top">
                                                <div style="padding:0px 0px 0px 0px;" >
                                                   <br/>
                                                   <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >

                                                      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs">
                                                          

                                                          
                                                     
                                                            
                                                                 
                                                                  <tr>
                                                                         <td width="100%" bgcolor="#a8daf3" class="headngblue" align="center" style="border: 1px solid #A9A9A9">Previous inspection Monitoring</td>
                                                                 
                                                                  </tr>

                                                             
                                                          
                                                      


                                                      </table>



                                      

                                        <!-- bhanu code start; date: 30-05-2017 -->

                                        
                                        <g:form action="searchIndustriesBasedOnDistrictMis">
                                            <%
                                                def districtMasterList = DistrictMaster.findAll("from DistrictMaster where districtFlag = true")
                                            %>
                                            <table width="100%" style="border: 1px solid #A9A9A9">
                                                <tr  bgcolor="#E8F6F9">
                                                    <td  width="10%" align="right"  class="headngblue">District :</td>
                                                    <td width="40%" align="left" >
                                                        <g:select class="txt4" optionKey="id" from="${districtMasterList}"
                                                                  optionValue="districtName" name="district" noSelection="${['ALL':'ALL']}"  id="districtId"  value="" > </g:select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2" width="10%" align="center">
                                                        <br>
                                                        <input type="submit" name="" value="Search" class="actionbutton"/>
                                                    </td>
                                                </tr>

                                            </table>

                                            <!-- bhanu code start; date: 05-06-2017 -->
                                            <!-- code to show the industries based on district -->
                                            <br>
                                            <%if(finalIndustryRegMasterList){%>
                                            <table width="100%">
                                                <tr style="height: 25px; background-color: #ededed" align="center">
                                                    <%if(searchedDistrict.equals('ALL')){%>
                                                    <td class="headngblue"> District: ALL</td>
                                                    <%}else{%>
                                                    <td class="headngblue"> District: <%=DistrictMaster.get(Long.parseLong(searchedDistrict)).districtName%></td>
                                                    <%}%>
                                                </tr>

                                            </table>
                                            <br>
                                            <div style='overflow-x:auto; height:500px;'>

                                           <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt text-center" style="border-collapse:collapse;" >
                                            <tr bgcolor="#A8DAF3" class="headngblue" align="center" height="20">
                                                <td width="5%">
                                                    S. No.
                                                </td>
                                                <td>
                                                    Industry Id
                                                </td>
                                                <td>
                                                    Industry Name
                                                </td>
                                                <td>
                                                    Category
                                                </td>
                                                <td>
                                                Inspection No
                                                </td>
                                            </tr>
                                                <%for(int i = 0; i < finalIndustryRegMasterList.size(); i++){%>
                                                <tr bgcolor="<%if(i%2){%>#a8daf3<%}else{%>#ffffff<%}%>" class="txt4" align="center" height="25">
                                                    <td width="5%">
                                                        <%= (i+1) %>
                                                    </td>
                                                    <td>
                                                        <%
                                                        def indUser = IndUser.findByIndustryRegMaster(finalIndustryRegMasterList[i])
                                                        if(indUser){
                                                        %>
                                                            <%=indUser.id.toString()%>
                                                        <%}else{
                                                            // try to find universal industryRegMaster insatnce in indApplicationDdetails
                                                            def indApplicationInstance = IndApplicationDetails.findByIndUser(finalIndustryRegMasterList[i])
                                                            if(indApplicationInstance){
                                                                indUser = IndUser.findByIndustryRegMaster(indApplicationInstance.indUserUniversal)
                                                                if(indUser){ %>
                                                                <%=indUser.id.toString()%>
                                                                <%
                                                                }
                                                            }
                                                        }%>
                                                    </td>
                                                    <td>
                                                        <%=finalIndustryRegMasterList[i].indName%>
                                                        <br>
                                                        <%=finalIndustryRegMasterList[i].indAddress%>
                                                    </td>
                                                    <td>
                                                        <%=finalIndustryRegMasterList[i].category.name%>
                                                    </td>
                                                    <td>

                                                        <%for(int j = 0; j < inspectionNoList[i].size(); j++){%>
                                                        <!--<%= inspectionNoList[i][j]%><br>-->
                                                        <%
                                                        def regularInspectionRaisedInstance = RegularInspectionRaised.get(inspectionNoList[i][j])
                                          
                                                        def typeOfInspection = ""
                                                        def inspectionNoteHistoryToTestPreviousInspection = InspectionNoteHistory.executeQuery("select inh.id from InspectionNoteHistory as inh where inh.inspectionDescriptionNote = '"+ inspectionNoList[i][j] + "'")
                                                        if(inspectionNoteHistoryToTestPreviousInspection){
                                                        	typeOfInspection = "PREVIOUS_INSPECTION"
                                                        }else{
                                                        	typeOfInspection = "REGULAR_INSPECTION"
                                                        }
                                                        %>
                                                        <a class="txt4"
                                                            href="#"
                                                            style="color: #0645AD"
                                                            onclick="window.open('<%=request.getContextPath()%>/inspectionManagement/showInspectionNoteHistroy?typeOfInspection=<%=typeOfInspection%>&id=<%= regularInspectionRaisedInstance.application.id %>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                            <%= inspectionNoList[i][j]%><br>
                                                         </a>
                                                       <% }%>
                                                       
                                                  </td>
                                                </tr>
                                                <%}}%>
                                            </table>
                                            </div>
                                        </g:form>
                                        

                                        <!-- bhanu code ends -->
                                             </td>
                                          </tr>
                                          
                                       </table>
                                    </td>
                                 </tr>
                <g:include controller="userMaster" action="showSpcbFooter"/>
                              </table>
                           </td>
                        </tr>
                      
                        <!-- code for spcb Footer -->
                  
                        %{--<g:include controller="userMaster" action="showSpcbFooter"/>--}%
                       
                     </table>

                  </td>

               </tr>
               
            </table>
             <!-- code for spcb Footer -->
             
   </body>


</html>