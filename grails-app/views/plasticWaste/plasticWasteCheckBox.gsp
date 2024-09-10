<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader ("Expires", -1);
    %>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'calendar.css')}" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title>Application For Authorization</title>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
    <link rel="stylesheet"
          type="text/css"href="${createLinkTo(dir:'css',file:'tabcontent.css')}"
    />
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'style.css')}" />
    <script type="text/javascript"
            src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
    <script type="text/javascript"
            src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
    <script type="text/javascript"
            src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
    <script type="text/javascript"src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
    <script type="text/javascript"src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'design.css')}" />
    <script type="text/javascript"
            src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

    <g:javascript library="prototype" />
    <link rel="stylesheet" type="text/css"
          href="${createLinkTo(dir:'css',file:'calendar.css')}" />
    <script type="text/javascript"
            src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>



    <style type="text/css">

    </style>
    <script type="text/javascript">
        function random_number(min,max) {
            return(Math.round((max-min) * Math.random() + min));
        }
    </script>

    <script type="text/javascript" src="js/tabcontent.js"></script>
    <script type="text/javascript">
        anylinkmenu.init("menuanchorclass")
    </script>

    <script language="javascript" type="text/javascript">

        function popitup(url) {
            newwindow=window.open(url,'name','height=200px,width=500px');
            if (window.focus) {newwindow.focus()
            }
            return false;
        }

    </script>
    <script language="javascript" type="text/javascript">

    function tosubmit()
 {
    	if(!(document.getElementById("chkProducers").checked) && !(document.getElementById("chkRecycling").checked) &&  !(document.getElementById("chkManufacturer").checked))
		{ 
		
			alert("Please Check Atleast one Authorization Required For Check Box");
			return false;
		}
}
 </script>
</head>
<body>
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td height="91" align="left" valign="top" class="bgtop">
                        <!-- code for spcbHeader  -->
                        <g:include controller="userMaster" action="showSpcbHeader" />
                    </td>
                </tr>
                <tr>
                    <td height="32" align="left" valign="top"
                        background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
                        <!-- code for menuAdminHorizontal-->
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
                    <td align="left" valign="top">
                        <table width="1003" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                                    <!-- code for menuAdmin-->
                                    <%
                                        if(  (IndUser)session.getAttribute("indUser")  ){ %>
                                    <g:include controller="userMaster"
                                               action="pwmIndustryMenuVertical"/><%} %>
                                    <%if((UserMaster)session.getAttribute("userMaster")){
                                        UserMaster aa =
                                                (UserMaster)session.getAttribute("userMaster");
                                        String userType = aa.accessLevel
                                        if(userType.equals("admin")) { %>
                                    <g:include controller="userMaster"
                                               action="eWasteAdminMenuVertical"/>
                                    <%    }else{ %>
                                    <g:include controller="userMaster"
                                               action="eWasteEmpMenuVertical"/>
                                    <%    }
                                    } %>
                                    <% if( (!(IndUser)session.getAttribute("indUser") ) && (!
                                            (UserMaster)session.getAttribute("userMaster")))  {%>
                                    <g:include controller="userMaster"
                                               action="showIndexMenu"/>
                                    <% } %>
                                </td>
                                <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                                <td width="778" align="left" valign="top">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td height="1" valign="top"></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778"
                                                     height="134" />
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
                                                    <%
                                                        if((UserMaster)session.getAttribute("userMastHey.. this is inside eWasteCheckBoxer"))
                                                        {
                                                    %>
                                                    <tr>
                                                        <td class="top-lnks">
                                                            <table width="100%">
                                                                <tr height="10px">
                                                                    <td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
                                                                    <td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month
                                                                    %>-<%=year %></td>
                                                                </tr>
                                                            </table>
                                                        <td>
                                                    </tr>
                                                    <% }
                                                    if(  (IndUser)session.getAttribute("indUser")  )
                                                    {
                                                    %>
                                                    <tr bgcolor="#4C8BC0">
                                                        <td class="top-lnks">
                                                            <table width="100%">
                                                                <tr height="10px">
                                                                    <td>Welcome <%=indname %></td>
                                                                    <td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month
                                                                    %>-<%=year %></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <% }
                                                    %>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="0" align="left" valign="top">
                                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                    <tr>
                                                        <td height="0" align="left" valign="top">
                                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                <tr>
                                                                    <td>&nbsp;</td>
                                                                </tr>
                                                                <tr>

                                                                    <td align="left" valign="top">

                                                                        <g:form action="create" >
                                                                        <% System.out.println("PlasticWasteCheckBox.gsp")%>
                                                                            <table width="70%" border="0" cellspacing="1" cellpadding="2" align="center" class="headngblue">
                                                                                <tr>
                                                                                <td align="center" class="headngblue">
                                                                                    <span style="font-weight: bold">Select PWM for: </span>
                                                                                    <span style="color:red">*</span>
                                                                                </td>

                                                                                <td align="left" bgcolor="#F4F7FB">
                                                                                    <input type="checkbox" name="chkProducers" id="chkProducers" checked>Producers of Carry Bags and Containers
                                                                                    <br>
                                                                                    <input type="checkbox" name="chkRecycling" id="chkRecycling" >Recycling or Processing waste
                                                                                    <br>
                                                                                    <input type="checkbox" name="chkManufacturer" id="chkManufacturer">Manufacturer of Plastic to be used as raw material
                                                                                    <br>
                                                                                </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td align="center" colspan="2" >
                                                                                        <input type="submit" name="Search" onclick="return tosubmit();" value="SUBMIT" class="actionbutton">
                                                                                    </td>
                                                                                </tr>
                                                                                <% System.out.println("End here in .gsp")%>
                                                                            </table>
                                                                        </g:form>

                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
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
    <g:include controller="userMaster" action="showSpcbFooter"/>
</table>
</body>
<HEAD>
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>