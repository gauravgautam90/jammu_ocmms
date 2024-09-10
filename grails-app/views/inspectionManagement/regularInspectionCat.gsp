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
                     <g:include controller="inspectionManagement" action="showSpcbInspectionManagementMenu"/>    
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
                                             <!-- bhanu commented code start; date: 26-07-2017 -->
                                             %{--Role : ${roleHeader}--}%
                                             <!-- bhanu commented code ends -->

                                             <!-- bhanu code start; date: 26-07-2017 -->
                                             <%if(roleHeader){ %>
                                                 Role : ${roleHeader}
                                             <% } %>
                                             <!-- bhanu code ends -->
                                             </td>
                                             <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
                                          </tr>
                                       </table>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td  align="left">
                                       &nbsp;<!--kk-->
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

                                                      <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                          <!-- bhanu commented code start; date: 30-05-2017 -->
                                                          <!-- this code is commneted to make new style tabs -->
                                                         %{--<tr>
                                                            <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Regular Inspection</a></td>
                                                            <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                                                            <td width="432" align="right"></td>

                                                         </tr>--}%
                                                          <!-- bhanu commented code ends -->

                                                          <!-- bhanu code start; date: 20-05-2017 -->
                                                          <td width="60%" align="center">
                                                              <ol id="toc">
                                                                  <li>


                                                                      <%if(isAdmin){%>
                                                                      <!-- bhanu code ends -->

                                                                      <a href="#country1"
                                                                         onclick="hideShow1()"><span id="regularInspection"
                                                                                                     style="color: #fff">Regular Inspection</span>

                                                                      <!-- bhanu code start; date: 20-06-2017 -->
                                                                      <% } %>
                                                                      <!-- bhanu code ends -->


                                                                  </a>
                                                                  </li>
                                                                  

                                                              </ol>
                                                          </td>
                                                          <!-- bhanu code ends -->


                                                      </table>




                                                    <div id="country1">
                                                    <!-- bhanu code start; date: 20-06-2017 -->
                                                        <%if(isAdmin) { %>
                                                    <!-- bhanu code ends -->
                                                        <g:form action="searchApplicationCatList" name="myform" method="post" >
                                                            <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">

                                                               <tr  bgcolor="#E8F6F9">
                                                                  <td width="10%" align="left"  class="headngblue" >Group :</td>
                                                                  <td width="40%" align="left" >
                                                            <g:select class="txt4" optionKey="id" from="${grp}" name="group" id="group" noSelection="${['xyz':'Not Selected']}"
                                                                      onchange="hitAjaxCall(this);"   ></g:select>
                                                            </td>


                                                            <td  width="10%" align="left"  class="headngblue">District :</td>
                                                            <td width="40%" align="left"   >
                                                                <g:select optionKey="id" optionValue="name" name="district" noSelection="${['ALL':'ALL']}"  id="districtId"  value="" > </g:select>
                                                            </td>
                                                            </tr>
                                                            <td width="10%" align="left"  class="headngblue" >Category:</td>
                                                            <td  width="40%" align="left" class="headngblue">
                                                                <select  name="category">
                                                                    <option value="None">None</option>
                                                                    <option value="RED">RED</option>
                                                                    <option value="GREEN">GREEN</option>
                                                                    <option value="ORANGE">ORANGE</option>
                                                                </select>
                                                            </td>
                                                            <td width="10%" align="left"  class="headngblue" >Month/Year:</td>
                                                            <td width="40%" align="left" class="headngblue">
                                                                <select  name="month">
                                                                    <option value="1">JANUARY</option>
                                                                    <option value="2">FEBRUARY</option>
                                                                    <option value="3">MARCH</option>
                                                                    <option value="4">APRIL</option>
                                                                    <option value="5">MAY</option>
                                                                    <option value="6">JUNE</option>
                                                                    <option value="7">JULY</option>
                                                                    <option value="8">AUGUST</option>
                                                                    <option value="9">SEPTEMBER</option>
                                                                    <option value="10">OCTOBER</option>
                                                                    <option value="11">NOVEMBER</option>
                                                                    <option value="12">DECEMBER</option>
                                                                </select>
                                                                <select name="year" >
                                                                    <option value="2028">2028</option>
                                                                    <option value="2027">2027</option>
                                                                    <option value="2026">2026</option>
                                                                    <option value="2025">2025</option>
                                                                    <option value="2024">2024</option>
                                                                    <option value="2023">2023</option>
                                                                    <option value="2022">2022</option>
                                                                    <option value="2021">2021</option>
                                                                    <option value="2020">2020</option>
                                                                    <option value="2019">2019</option>
                                                                    <option value="2018">2018</option>
                                                                    <option value="2017">2017</option>
                                                                    <option value="2016">2016</option>
                                                                    <option value="2015">2015</option>
                                                                    <option value="2014">2014</option>
                                                                    <option value="2013">2013</option>
                                                                    <option value="2012">2012</option>
                                                                    <option value="2011">2011</option>
                                                                    <option value="2010">2010</option>
                                                                    <option value="2009">2009</option>
                                                                    <option value="2008">2008</option>
                                                                    <option value="2007">2007</option>
                                                                    <option value="2006">2006</option>
                                                                    <option value="2005">2005</option>
                                                                    <option value="2004">2004</option>



                                                            </td>
                                                            </tr>
                                                            </tr>
                                                         </table>
                                                            <table width="100%"  border="0" align="center" class="tblbdr">
                                                                <tr>
                                                                    <td width="33%" align="center"><input type="submit" name="Search" value="Search" class="actionbutton" onclick="return checkGroupSelect()"></td>
                                                                </tr>
                                                            </table>
                                                        </g:form>
                                                    <!-- bhanu code start; date: 20-06-2017 -->
                                                        <% } %>
                                                    <!-- bhanu code ends -->

                                                        <br />
                                                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="white" class="tab-txt" style="border-collapse:collapse;">
                                                            <%if(month1){%>
                                                            <tr>
                                                                <td colspan="9" align="center" ><span class="headngblue">Regular Inspection List For Month : 
                                                                			<% if(month1=="1"){%> JANUARY 
                                                                		<% }else if(month1=="2"){ %> FEBRUARY 
                                                                		<% }else if(month1=="3"){ %> MARCH
                                                                		<% }else if(month1=="4"){ %> APRIL
                                                                		<% }else if(month1=="5"){ %> MAY
                                                                		<% }else if(month1=="6"){ %> JUNE	
                                                                		<% }else if(month1=="7"){ %> JULY	
                                                                		<% }else if(month1=="8"){ %> AUGUST
                                                                		<% }else if(month1=="9"){ %> SEPTEMBER
                                                                		<% }else if(month1=="10"){ %> OCTOBER
                                                                		<% }else if(month1=="11"){ %> NOVEMBER
                                                                		<% }else if(month1=="12"){ %> DECEMBER
                                                                			<%}%>
                                                                			&nbsp;&nbsp;And Year : <%=year1%></span>
                                                                	
                                                                </td>
                                                            </tr>
                                                            <%}%>
                                                            <tr>
                                                                <td bgcolor="#FFFFFF">
                                                                    <%if(isAdmin){%>
                                                                    <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                                                                        <thead>
                                                                        <tr height="20" bgcolor="#A8DAF3">
                                                                            <th class="headngblue" align="center">SI. No.</th>
                                                                            <th class="headngblue" align="center">Inspection No.</th>
                                                                            <th class="headngblue" align="center">IndustryId </th>
                                                                            <th class="headngblue" align="center">Industry Name </th>
                                                                            <th class="headngblue" align="center">Application No</th>
                                                                            <!-- <th class="headngblue" align="center">Application Type</th> -->
                                                                            <!--  <th class="headngblue" align="center">Application Date</th> -->
                                                                            <th class="headngblue" align="center">Category</th>
                                                                            <th class="headngblue" align="center">Industry Type</th>
                                                                            <!--   <th class="headngblue" align="center">Application For</th>  -->
                                                                            <th class="headngblue" align="center">Officer Name</th>
                                                                            <!-- <th class="headngblue" align="center">Certificate For</th> -->
                                                                            <th class="headngblue" align="center">Officer Id</th>
                                                                        </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                        <%if(!listOfApplication){ %>
                                                                        <tr>
                                                                            <td colspan="9" height="25" align="center" class="txt4"></td>
                                                                        </tr>
                                                                        <%}
                                                                        else{

                                                                        %>
                                                                        <g:each in="${listOfApplication}" status="i" var="indList">
                                                                            <%
                                                                                    SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
                                                                                    String strDate = sdfDestination.format(indList.application.actualApplicationDate);
                                                                                    String classToPick="#1F6FB7";


                                                                                    def industryRegMasterInstance = IndustryRegMaster.get(indList.application.indUser.id)

                                                                                    def indUserInstance = IndUser.findAll("from IndUser ir where ir.industryRegMaster = ?",[industryRegMasterInstance])


                                                                                    def certInst = RecordCertificate.executeQuery("select dateCreated from RecordCertificate where applicationId.id=? order by id desc",[indList.application.id]);
                                                                                    String certDate = sdfDestination.format(certInst[0]);
                                                                                    if(indList.inspectionRaised == false){
                                                                            %>
                                                                            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                                                                <td height="25" align="center" class="txt4"><b>${i+1}.</b></td>
                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>">${indList.id}

                                                                                </font></b></td>

                                                                                <!--  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>">${indList.application}</font></b></td> -->


                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indUserInstance[0]%></font></b></td>
                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.applicationName%>,<%=indList.application.indUser.indAddress%></font></b></td>
                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.id%></font></b></td> 
                                                                                <!--   <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.applicationType%></font></b></td> -->
                                                                                <!--   <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=strDate%></font></b></td> -->
                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.indUser.category.name%></font></b></td>

                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.indUser.industryType.industryType%></font></b></td>

                                                                                <!--   <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.applicationFor%></font></b></td> -->
                                                                                <!--   <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=certDate%></font></b></td> -->
                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.officerName%></font></b></td>

                                                                                <!--  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.application.certificateFor%></font></b></td>  -->
                                                                                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=indList.officerId%></font></b></td>
                                                                            </tr>
                                                                            <%}%>
                                                                        </g:each>
                                                                        <%}%>

                                                                        </tbody>

                                                                    </table>
                                                                    <%}%>
                                                    </div>


                                                <!-- CONTENT CHANGE----------------------------------------    -->
                                                <!--cONTENT cHANGE---------------------------------   -->



                                                <br />
                                                <br />
                                                </div>


                                             </td>
                                                </tr>
                                                </table>
                                                </div>

                                      
                                             </td>
                                          </tr>

                                       </table>
                                    </td>
                                 </tr>
                              </table>
                           </td>
                        </tr>
                        %{--<!-- code for spcb Footer -->
                        <g:include controller="userMaster" action="showSpcbFooter"/>--}%
                     </table>

                  </td>

               </tr>

            </table>
             <!-- code for spcb Footer -->
             <g:include controller="userMaster" action="showSpcbFooter"/>
   </body>


</html>