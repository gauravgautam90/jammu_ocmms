<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>Industry</title>


    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabcontent.js')}"></script>

    <style type="text/css">
    <!--
    body {
        margin-left: 0px;
        margin-top: 0px;
        margin-right: 0px;
        margin-bottom: 0px;
    }

    .style3 {
        color: #186DB5
    }

    .style5 {
        color: #0099FF
    }

    .style6 {
        color: #33FF66;
    }

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

    .qwe123 {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
        padding-left: 23px;
        padding-right: 20px;
        padding-top: 5px;
        padding-bottom: 5px;

    }

    .qwe123:hover {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
    }

    .blue {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
        padding-left: 30px;
        padding-right: 27px;
        padding-top: 5px;
        padding-bottom: 7px;
    }

    .blue:hover {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
    }

    -->
    </style>

    <script type="text/javascript" src="js/tabcontent.js">
    </script>
    <script type="text/javascript">
        anylinkmenu.init("menuanchorclass")
    </script>

</head>

<body>
%{-- satish code start replaced whole file --}%
<% if (appClarification) { %>
<table>
    <%
            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
            String strDate = sdfDestination.format(appClarification.dateCreated);
    %>
    <tr>
        <td width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Date Time:</div></td>
        <td align="left" bgcolor="#E8F6F9" class="txt4">
            <%=strDate%></td>
    </tr>

    <tr>
        <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                                                  class="style3">Raised By:</div>
        </td>
        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appClarification.role}(${appClarification.officer})</div>
        </td>
    </tr>
    <tr>
        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Notice Type:</div></td>
        <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.noticeType}</td>
    </tr>

    <tr>
        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
        <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.clarificationNote}</td>
    </tr>
    %{--SATISH code starts--}%
    <% if (appClarification.noticeType == 'Show Cause') {
        def appId = appClarification.applicationId
    %>
    <tr>
        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">SCN Certificate:</div>
        </td>
        <td align="left" bgcolor="#E8F6F9" class="txt4">
            <g:link action="downLoadingCertificateForScnEwaste" id="${appId}"><span
                    class="innerlink">&nbsp; <u>View SCN(E-Waste) For Refusal</u>&nbsp;</span></g:link>
        </td></tr>
    %{--SATISH code ends--}%



</td>

</tr>
</table>
<% }
} %>
</body>