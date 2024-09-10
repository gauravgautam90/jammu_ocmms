<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>
<calendar:resources lang="en" theme="aqua"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title> Report</title>
    <title>Untitled Document</title>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>





    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

    <script>
        function validateForm() {

            var x = document.forms["myform"]["showCauseDays"].value;
            if (x == null || x == "") {
                alert("Please enter Number of Show Cause Days.");
                return false;
            }
        }
    </script>

   %{-- <g:javascript library="prototype" />--}%
    <script type="text/javascript">
        $( document ).ready(function() {
            console.log("dom ready");
            window.addRowCounter = 0;
            $('#button_addRow').click(function(){
                console.log("button_addRow clicked");
                window.addRowCounter += 1;
                var styleBgColor ="";
                if(window.addRowCounter % 2 == 0){
                    styleBgColor = "bgColor=\"#A8DAF3\"";
                }else{
                    styleBgColor = " bgcolor=\"#E8F6F9\" "
                }
                var addRowHtml = "<tr " + styleBgColor +" >" +
                "<td colspan=\"2\">"+
                "<textarea rows=\"1\" cols=\"70\" style=\"margin: 4px\" name=\"otherDetails\"></textarea>" +
                "</td>" +
                "</tr>";
                $('#row_addRow_button').before(addRowHtml);
            });
        });
    </script>


</head>

<body>
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
                <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                            <!-- code for menuAdmin-->
                            <%
                                if(  (IndUser)session.getAttribute("indUser")  ){ %>
                            <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
                            <%if((UserMaster)session.getAttribute("userMaster")){
                                UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                                String userType = aa.accessLevel
                                if(userType.equals("admin")) { %>
                            <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>
                            <%    }else{ %>
                            <g:include controller="userMaster" action="eWasteEmpMenuVertical"/>
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
                                    <table width="100%" >
                                        <tr bgcolor="#4C8BC0">
                                            <td  class="top-lnks" >
                                                <table width="100%" >
                                                    <tr height="10px">
                                                        <td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}</td>
                                                        <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr><!-- Div area for errors-->
                                        <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                                            <g:if test="${flash.message}">
                                                <div>${flash.message}</div>
                                            </g:if>
                                            <g:hasErrors bean="${groupMasterInstance}">

                                                <g:renderErrors bean="${groupMasterInstance}" as="list" />

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

                                                    <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px>



<table align="center">

    <tr align="center">

        <td width="100%" align="center">

        <g:form  action="createEwaste_SCN_Certificate" name="myform" method="post" >
            <input type="hidden" name="hazardeousWasteAuthAppInstanceid"
                   value="${newInst?.id}"/>
            <input type="hidden" id="role" name="role" value="${roleHeader}" />
            <%System.out.println("newInst.id_111111... :"+newInst.id);%>

            <div >
                <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                    <tr>
                        <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                        <td width="350" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">SCN for Refusal</a></td>
                        <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                        <td width="432">&nbsp;</td>
                    </tr>

                    %{--<tr>
                        <!--      <td colspan="4" align="right"><a href="<%=request.getContextPath()%>/eWaste/viewInspectionPdf?appliLoc=<%=eWasteInstance?.id%>"><span class="headngblue">Print</span></a></td> -->
                        <td colspan="4" align="right"> <td width="432"><a href="javascript:window.print()">print</a></td>
                    </tr>--}%
                </table>

                <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
                    <input type="hidden" name="appId" value="<%=appId%>">
                    <tr><td>

                        <%if(newInst) {%>
                        <table width="100%" border="0" >

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="30%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Industry Details</td>
                            </tr>
                            <%System.out.println("inside industry details1")%>
                            <tr class="headngblue" bgcolor="#A8DAF3">
                            <%System.out.println("inside industry details2")%>
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
                                        field:'industryReg.district.districtName')}</td>
                            <%System.out.println("inside industry details3")%>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Regional Office:</td>
                                <% def aaa = newInst.industryReg.district.id
                                    System.out.println("aaa...."+aaa)
                                    def abc = GroupDistrictMaster.find("from GroupDistrictMaster as gdm where gdm.district.id = ? order by gdm.id asc",[aaa])
                                    System.out.println("abc...."+abc.group.groupName)%>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:abc,
                                        field:'group.groupName')}</td>
                                <input type="hidden" id="region" name="region" value="${abc.group.groupName}" />
                            </tr>
                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
                                        field:'industryReg.indName')}</td>
                            </tr>
                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Address:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
                                        field:'industryReg.indAddress')}</td>
                            </tr>
                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="30%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Consent Letter Details</td>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Letter Sent To:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
                                        field:'industryReg.occName')}</td>
                            </tr>
                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:newInst,
                                        field:'industryReg.occDesignation')}</td>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reply show cause within:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
                                    <input type="text" name="inspectionDays" id="showCauseDays" value="" size="5"/>
                                    </span>&nbsp;days.
                                </td>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Region vide letter no:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
                                    <input id="authNumber" name="authNumber"
                                           type="text" size="30"
                                           value="EW/<%=newInst.industryReg.district.districtCode%>/<%=currentYear%>/<%=newInst.id%>"
                                           maxlength="50" AUTOCOMPLETE=OFF
                                           class="txt4" readonly/>
                                </td>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Letter Dated on:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
                                    <calendar:datePicker name="LetterDatedOn"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                                </td>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="45%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Conditions:</td>
                                <td width="65%" align="left" bgcolor="#E8F6F9" class="headngblue">
                                    <table width="100%" align="center">
                                        <tr>
                                            <td width="20%" align="center">
                                                <span class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popConditionsAdd/${newInst.id}','WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></span>
                                            </td>
                                            <td width="10%" align="center" class="txt4">
                                                |
                                            </td>
                                            <td width="15%" align="center">
                                                <span class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popConditionsView/${newInst.id}','WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a></span>
                                            </td>
                                            <td width="10%" align="center" class="txt4">
                                                |
                                            </td>
                                            <td width="15%" align="center">
                                                <span class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popConditionsEdit/${newInst.id}','WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a></span>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>


                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="30%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">Details</td>
                            </tr>

                            <tr class="headngblue" bgcolor="#A8DAF3">
                                <td width="30%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2">
                                    <textarea rows="1" cols="70" name="otherDetails"></textarea>
                                </td>
                            </tr>
                            <tr id = "row_addRow_button">
                                <td colspan="2"><input type="button" id = "button_addRow" value="Add Row" /></td>
                            </tr>

                    </table>
                            <%}%>
                        </td>
                    </tr>
                </table>
                <table width="96%" align="center">
                    <tr>
                        <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                        <td width="75%" align="right"><input type="submit"  value="Generate" class="draftbutton" /></td>


                        <!-- onclick="window.open('../openCertificate', 'windowname1', 'width=810, height=650, scrollbars=1'); return false;" name="save" -->

                    </tr>
                </table>
            </div>
        </g:form>
        </td>
    </tr>


</table>
                                                    </div>
                                                </td>
                                                <td width="132" align="left" valign="top">&nbsp;</td>
                                            </tr>
                                        </table></td>
                                    </tr>

                                </table></td></tr></table></td></tr></table></td></tr>
        </table></td></tr></table>

</body>

</html>