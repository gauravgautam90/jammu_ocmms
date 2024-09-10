<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        String contex = request.getContextPath();
        

    %>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>SPCB Admin Home</title>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'calendar.css')}"/>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
    <script type="text/javascript" src="js/tabcontent.js"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'gen_validatorv31.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabcontent.js')}"></script>
    <script type="text/javascript">anylinkmenu.init("menuanchorclass")</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <style type="text/css">
    <g:javascript library="prototype" />
    <g:javascript library='scriptaculous'/>

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
    </style>


    <script language="javascript" type="text/javascript">
        function hidediv() {
            for (var i = 0; i < document.myForm.officerTypeRecommendation.length; i++) {
                if (document.myForm.officerTypeRecommendation[i].checked) {
                    var radiomenu = document.myForm.officerTypeRecommendation[i]

                    if (radiomenu.value == "RO") {
                        document.getElementById('recommRO1').style.display = 'block';
                        document.getElementById('recommRO2').style.display = 'block';
                        document.getElementById('recommRO3').style.display = 'block';
                        document.getElementById('recommFO1').style.display = 'none';
                        document.getElementById('recommFO2').style.display = 'none';
                        document.getElementById('recommFO3').style.display = 'none';
                    }
                    else if (radiomenu.value == "FO") {
                        document.getElementById('recommFO1').style.display = 'block';
                        document.getElementById('recommFO2').style.display = 'block';
                        document.getElementById('recommFO3').style.display = 'block';
                        document.getElementById('recommRO1').style.display = 'none';
                        document.getElementById('recommRO2').style.display = 'none';
                        document.getElementById('recommRO3').style.display = 'none';
                    }
                    else{
                        document.getElementById('recommRO1').style.display = 'none';
                        document.getElementById('recommRO2').style.display = 'none';
                        document.getElementById('recommRO3').style.display = 'none';
                        document.getElementById('recommFO1').style.display = 'none';
                        document.getElementById('recommFO2').style.display = 'none';
                        document.getElementById('recommFO3').style.display = 'none';
                    }
                }
            }
        }
        
        function hidediv1() {
            for (var i = 0; i < document.myForm.officerTypeIssueGrant.length; i++) {
                if (document.myForm.officerTypeIssueGrant[i].checked) {
                    var radiomenu = document.myForm.officerTypeIssueGrant[i]

                    if (radiomenu.value == "ro") {
                        document.getElementById('recommPSRO').style.display = 'block';
                        
                        document.getElementById('recommPSFO').style.display = 'none';
                        
                    }
                    else if (radiomenu.value == "fo") {
                    	document.getElementById('recommPSRO').style.display = 'none';
                        
                        document.getElementById('recommPSFO').style.display = 'block';
                    }
                    else{
                    	document.getElementById('recommPSRO').style.display = 'none';
                        
                        document.getElementById('recommPSFO').style.display = 'block';
                    }
                }
            }
        }
        
        function hidedivRecClo() {
            for (var i = 0; i < document.myForm.officerSubmitRecomm.length; i++) {
                if (document.myForm.officerSubmitRecomm[i].checked) {
                    var radiomenu = document.myForm.officerSubmitRecomm[i]

                    if (radiomenu.value == "ro") {
                        document.getElementById('recommCLORO').style.display = 'block';
                        
                        document.getElementById('recommCLOFO').style.display = 'none';
                        
                    }
                    else if (radiomenu.value == "fo") {
                    	document.getElementById('recommCLORO').style.display = 'none';
                        
                        document.getElementById('recommCLOFO').style.display = 'block';
                    }
                    else{
                    	document.getElementById('recommCLORO').style.display = 'none';
                        
                        document.getElementById('recommCLOFO').style.display = 'block';
                    }
                }
            }
        }
        
        function hideRecomCloSup() {
            for (var i = 0; i < document.myForm.officerSubmitRecommClo.length; i++) {
                if (document.myForm.officerSubmitRecommClo[i].checked) {
                    var radiomenu = document.myForm.officerSubmitRecommClo[i]

                    if (radiomenu.value == "ro") {
                        document.getElementById('recomCloSupRO').style.display = 'block';
                        
                        document.getElementById('recomCloSupFO').style.display = 'none';
                        
                    }
                    else if (radiomenu.value == "fo") {
                    	document.getElementById('recomCloSupRO').style.display = 'none';
                        
                        document.getElementById('recomCloSupFO').style.display = 'block';
                    }
                    else{
                    	document.getElementById('recomCloSupRO').style.display = 'none';
                        
                        document.getElementById('recomCloSupFO').style.display = 'block';
                    }
                }
            }
        }
        
        
        function hideRecomProsAct() {
            for (var i = 0; i < document.myForm.officerSubmitRecomSus.length; i++) {
                if (document.myForm.officerSubmitRecomSus[i].checked) {
                    var radiomenu = document.myForm.officerSubmitRecomSus[i]

                    if (radiomenu.value == "ro") {
                        document.getElementById('recomProsRO').style.display = 'block';
                        
                        document.getElementById('recomProsFO').style.display = 'none';
                        
                    }
                    else if (radiomenu.value == "fo") {
                    	document.getElementById('recomProsRO').style.display = 'none';
                        
                        document.getElementById('recomProsFO').style.display = 'block';
                    }
                    else{
                    	document.getElementById('recomProsRO').style.display = 'none';
                        
                        document.getElementById('recomProsFO').style.display = 'block';
                    }
                }
            }
        }
    </script>


</head>

<body>
<h1>hrocmms</h1>
<h1><%name%></h1>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                
                
                <tr>
                    <td align="left" valign="top">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="85%" align="left" valign="top">
                                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        
                                        
                                       <tr>
                                                        <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                       
                                                        <tr>
                                                                
                                                                <td align="centre" valign="top"><div style="padding:0px 0px 0px 0px;">
                                                                
                                                                    <div %{--style="border" :1px solid gray; width:720px; margin-bottom: 1em; padding: 10px"--}% >
                                                                    	<g:form name="myForm" action="generalInspectionProcessApp1" enctype="multipart/form-data" method="post">
                                                                        	<table width="70%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                                        	 <g:each in="${result}" status="i" var="abc">
                                                                        	
                                                                        	<tr>

                                                                            <td  class="headngblue" ><div align="left" class="style3"></div></td>
                                                                            <td align="centre"  class="txt4">
                                                                                <span class="headngblue" ><font color="grey">HROCMMS ID  :   </font> <%=abc.toString()%>   </span>                   </td>

                                                                        </tr>
                                                                        </g:each>
                                                                     </table>
                                                                        
                                                                        </g:form>
                                                                    </div>
                                                                    </td>
                                                               
                                                            </tr>
                                                        
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



</html>


