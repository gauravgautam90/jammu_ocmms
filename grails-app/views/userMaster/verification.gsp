<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", -1);
    %>
    <g:javascript>
         function updateCity1(e) {
         // The response comes back as a bunch-o-JSON
         var cities = eval("(" + e.responseText + ")") // evaluate JSON
         if (cities) {
         var rselect = document.getElementById('industryType.id')
         // Clear all previous options
         var l = rselect.length
         while (l > 0) {
         l--
         rselect.remove(l)
         }
         var opt1 = document.createElement('option');
         opt1.text = 'Not Selected'
         opt1.value = '111'
         try {
         rselect.add(opt1, null) // standards compliant; doesn't work in IE
         }
         catch(ex) {
         rselect.add(opt1) // IE only
         }
         // Rebuild the select
         for (var i=0; i < cities.length; i++) {
         var tehsil = cities[i]
         var opt = document.createElement('option');
         opt.text = tehsil.industryType
         opt.value = tehsil.id
         try {
         rselect.add(opt, null) // standards compliant; doesn't work in IE
         }
         catch(ex) {
         rselect.add(opt) // IE only
         }
         }
         }
         var selectmenu1=document.getElementById("industryType.id").value;
         if(selectmenu1 == "1234" || selectmenu1 == "1235" || selectmenu1 == "1236")
         {
         document.getElementById('selectTemp').style.display = 'block';
         }
         else{
         document.getElementById('selectTemp').style.display = 'none';
         }
         }
         // This is called when the page loads to initialize city
         var zselect = document.getElementById('category.id')
         var zopt = zselect.options[zselect.selectedIndex]
         ${remoteFunction(controller:"industryRegMaster", action:"ajaxGetCities1", params:"'id=' + zopt.value", onComplete:"updateCity1(e)")}
    </g:javascript>
    <calendar:resources lang="en" theme="aqua"/>
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
    <script type="text/javascript" src="js/tabcontent.js"></script>
    <script type="text/javascript">
        var popupWindow=null;
        function child_open(url) {
            popupWindow =window.open(url,"_blank","directories=no, status=no, menubar=no, scrollbars=yes, resizable=no,width=600, height=280,top=200,left=200");
        }
    </script>
    <script type="text/javascript">
        anylinkmenu.init("menuanchorclass")
    </script>
    <% String cont=request.getContextPath();
    %>
    <g:javascript library='scriptaculous'/>
    <g:javascript>
         window.onload = function()
         {
         new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );
         }
    </g:javascript>
    <%
        String cont1=request.getContextPath();
        if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
            response.sendRedirect(cont1+"/index.gsp")	;
        } %>
</head>
<body >
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
                <tr>
                    <td align="left" valign="top">
                        <table width="1003" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                                    <!-- code for menuAdmin-->
                                    <% UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                                    String userType =	 aa.accessLevel;
                                    if(userType.equals("admin")) { %>
                                    <g:include controller="userMaster" action="showAdminMenu"/>
                                    <%} else{ %>
                                    <g:include controller="userMaster" action="showSpcbUserMenu"/>
                                    <% } %>
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
                                            boolean decVar=true;
                                            String firstname;
                                            String lastName;
                                            String access;
                                            String indname;
                                            ArrayList indApplicationListForChallan = new ArrayList()

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
                                                    <% if((UserMaster)session.getAttribute("userMaster"))
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
                                                        </td>
                                                    </tr>
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
                                                        </td>
                                                    </tr>
                                                    <% } %>
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
                                                                    <g:hasErrors bean="${industry1}">
                                                                        <div class="errors">
                                                                            <g:renderErrors bean="${industry1}" as="search" />
                                                                        </div>
                                                                    </g:hasErrors>
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
                                                                            <FORM id="myForm" name=myForm action="verifyAllByDate" method="post">

                                                                                <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                                                                                <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                                                    <tr>
                                                                                        <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                                                                                        <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Verification</a></td>
                                                                                        <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                                                                                        <td width="1200" align="right"></td>
                                                                                    </tr>
                                                                                </table>
                                                                                <div id="country1" >
                                                                                    <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                                                                        <tr align="center">
                                                                                            <td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio  name=searchOp value=Others checked="checked"><span class="headngblue">By Date</span></td>
                                                                                        </tr>
                                                                                        <tr  bgcolor="#E8F6F9">
                                                                                            <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                                                                                            <td width="33%" align="left" >
                                                                                                <calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}" />
                                                                                            </td>
                                                                                            <td  width="15%" align="left"  class="headngblue">Ending Date:*</td>
                                                                                            <td align="left" width="37%"  >
                                                                                                <calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                                                                                            </td>
                                                                                        </tr>

                                                                                    </table>
                                                                                    <table width="95%" align="center">
                                                                                        <tr>
                                                                                            <td align="center"><input type="submit" name="save" value="Verify" class="actionbutton" ></td>
                                                                                        </tr>
                                                                                    </table>
                                                                                    <div align="left" class="txt" style="color: navy">
                                                                                        <hr>

                                                                                    </div>

                                                                                    <br />
                                                                                    <br />
                                                                                </div>
                                                                                <%
                                                                                    session.indApplicationListForChallan = indApplicationListForChallan;
                                                                                %>
                                                                            </form>
                                                                            <script type="text/javascript">
                                                                                var countries=new ddtabcontent("countrytabs")
                                                                                countries.setpersist(true)
                                                                                countries.setselectedClassTarget("link") //"link" or "linkparent"
                                                                                countries.init()

                                                                            </script>
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
            </table>
        </td>
    </tr>
</table>
</body>
<HEAD>
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>