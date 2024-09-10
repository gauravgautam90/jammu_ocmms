<% System.out.println("111111111111111111111"); %>
<%@ page import="java.text.DateFormat; java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>SPCB Industry Home</title>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'bootstrap.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabcontent.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'md5.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'gen_validatorv31.js')}"></script>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'design.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabs.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'calendar.css')}"/>


    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'calendar_us.js')}"></script>


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

    a.addViewDelete:hover {
        text-decoration: underline;
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


    <script type="text/javascript">
        anylinkmenu.init("menuanchorclass")
        function changeOtherCheckBox() {


            if (document.getElementById('checkboxGeneration').checked == true) {
                document.getElementById('checkboxCollection').checked = true;
                document.getElementById('checkboxReception').checked = true;
                document.getElementById('checkboxStorage').checked = true;
            }
        }
        function enablingDisabling() {
            var a = document.getElementById("radiobuttonfresh").value;
            if (a == "FreshApplication") {
                document.getElementById("prevauthNo").disabled = false;
                document.getElementById("prevauthDate").disabled = false;
            }
        }


        function check1() {

            // var selectmenu1 = document.getElementById('addrPlaceDisposalOfWaste.id').value;


            if (selectmenu1 == "Other") {

                document.getElementById('selectTemp').style.display = 'block';
                document.getElementById('selectTemp1').style.display = 'block';
            }
            else {
                document.getElementById('selectTemp').style.display = 'none';
                document.getElementById('selectTemp1').style.display = 'none';

            }


        }


        function enablingDisablingAgain() {
            document.getElementById('selectTemp919').style.display = 'none';
            document.getElementById('selectTemp199').style.display = 'none';
            document.getElementById('auth').style.display = 'none';
            document.getElementById('auth1').style.display = 'none';
            document.getElementById('auth2').style.display = 'none';
            document.getElementById('prevauthNo').disabled = true;
            document.getElementById('prevauthDate').disabled = true;
            document.getElementById('prevExpDate').disabled = true;

        }


        function enablingDisablingAgainRenew() {
            document.getElementById('selectTemp919').style.display = 'block';
            document.getElementById('selectTemp199').style.display = 'block';
            document.getElementById('auth').style.display = 'block';
            document.getElementById('auth1').style.display = 'block';
            document.getElementById('auth2').style.display = 'block';
            document.getElementById('prevauthNo').disabled = false;
            document.getElementById('prevauthDate').disabled = false;
            document.getElementById('prevExpDate').disabled = false;

        }

        /*function hidediv() {
         for (var i = 0; i < document.myform.radioIs_Renew.length; i++) {
         if (document.myform.radioIs_Renew[i].checked) {
         var radiomenu = document.myform.radioIs_Renew[i]

         if (radiomenu.value == "fresh") {

         document.getElementById('SelectTemp11').style.display = 'none';
         document.getElementById('authorization11').style.display = 'none';
         }

         if (radiomenu.value == "renew") {

         document.getElementById('SelectTemp11').style.display = 'block';
         document.getElementById('authorization11').style.display = 'block';
         }


         }
         }
         }*/


        function Calculate() {
            //alert("inside calculate");

            var indTyp;

            indTyp = document.getElementById('catVale').value;
            //alert(indTyp)
            var capitalInvestMent = document.getElementById('noOfBeds').value;
            //alert(capitalInvestMent)

            var result;

            var ValidationRequired;

            ValidationRequired = "/^.*(?=.*[0-9]).*$/";

            // Calculating applicable consent fee based on above selection
            if (indTyp == "HOSPITAL") {
                if (capitalInvestMent < 50) {
                    result = 500;
                }
                else if (capitalInvestMent > 49 && capitalInvestMent < 200) {
                    result = 3000;
                }
                else if (capitalInvestMent > 199 && capitalInvestMent < 500) {
                    result = 5000;
                }
                else if (capitalInvestMent > 499) {
                    result = 10000;

                }
            }
            else if (indTyp == "DENTAL CLINIC") {
                if (capitalInvestMent < 50) {
                    result = 500;
                }
                else if (capitalInvestMent > 49 && capitalInvestMent < 200) {
                    result = 3000;
                }
                else if (capitalInvestMent > 199 && capitalInvestMent < 500) {
                    result = 5000;
                }
                else if (capitalInvestMent > 499) {
                    result = 10000;

                }
            }
            else if (indTyp == "CBWTF") {
                if (capitalInvestMent < 50) {
                    result = 500;
                }
                else if (capitalInvestMent > 49 && capitalInvestMent < 200) {
                    result = 3000;
                }
                else if (capitalInvestMent > 199 && capitalInvestMent < 500) {
                    result = 5000;
                }
                else if (capitalInvestMent > 499) {
                    result = 10000;

                }
            }
            else if (indTyp == "CLINIC") {

                result = 250;

            }
            else if (indTyp == "LAB" || indTyp == "BLOOD BANK" || indTyp == "VETERINARY") {
                if (capitalInvestMent <= 5000) {
                    result = 500;
                }
                else if (capitalInvestMent > 5000 && capitalInvestMent <= 10000) {
                    result = 1000;
                }
                else if (capitalInvestMent > 10000 && capitalInvestMent <= 20000) {
                    result = 2000;
                }
                else if (capitalInvestMent > 20000) {
                    result = 4000;
                }

            }


            var feeApp = document.getElementsByName('feeApplicable');
            //alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);

            if (feeApp != null) {

                //alert("asas");
                feeApp[0].value = result * ((document.getElementsByName('yearsApplied')[0]).value);

                //alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
            }
            return true;
        }


        function selectHcfType() {
            //window.alert("inside select hcf type");
            var choosenOption = document.getElementById('hcfType1');
            if (choosenOption.value == "HCF") {
                //window.alert("hcf type");
                if (document.getElementById('noOfBeds_id'))
                    document.getElementById('noOfBeds_id').style.display = 'block';
                if (document.getElementById('licenceNo_id'))
                    document.getElementById('licenceNo_id').style.display = 'block';
                if (document.getElementById('licenceDateOfExpiry_id'))
                    document.getElementById('licenceDateOfExpiry_id').style.display = 'block';

                if (document.getElementById('noHealthcareCBMWTF_id'))
                    document.getElementById('noHealthcareCBMWTF_id').style.display = 'none';
                if (document.getElementById('noBedsCBMWTF_id'))
                    document.getElementById('noBedsCBMWTF_id').style.display = 'none';
                if (document.getElementById('installedTreatmentCBMWTF_id'))
                    document.getElementById('installedTreatmentCBMWTF_id').style.display = 'none';
                if (document.getElementById('quantityBiomedicalCBMWTF'))
                    document.getElementById('quantityBiomedicalCBMWTF').style.display = 'none';

            }
            else if (choosenOption.value == "CBMWTF") {
                //window.alert("cbmwtf type")
                if (document.getElementById('noOfBeds_id'))
                    document.getElementById('noOfBeds_id').style.display = 'none';
                if (document.getElementById('licenceNo_id'))
                    document.getElementById('licenceNo_id').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id'))
                    document.getElementById('licenceDateOfExpiry_id').style.display = 'none';

                if (document.getElementById('noHealthcareCBMWTF_id'))
                    document.getElementById('noHealthcareCBMWTF_id').style.display = 'block';
                if (document.getElementById('noBedsCBMWTF_id'))
                    document.getElementById('noBedsCBMWTF_id').style.display = 'block';
                if (document.getElementById('installedTreatmentCBMWTF_id'))
                    document.getElementById('installedTreatmentCBMWTF_id').style.display = 'block';
                if (document.getElementById('quantityBiomedicalCBMWTF'))
                    document.getElementById('quantityBiomedicalCBMWTF').style.display = 'block';
            }

        }

        function bmwManagementCommitteeRadio() {
            if (document.getElementById('bmwManagementCommitteeNo').checked) {
                document.getElementById('bmwManagementCommitteeDetail').style.display = 'none';
            }
            if (document.getElementById('bmwManagementCommitteeYes').checked) {
                document.getElementById('bmwManagementCommitteeDetail').style.display = 'block';
            }
        }



    </script>


    <script>

        function checkField(id) {
            // alert('Inside checkfield function'+id)
            if (id.value == "") {

                id.value = "0";
            }
            var total = 0;
            var a = eval(document.getElementById("anatomicalwaste").value);


            var a1 = a.toFixed(2);
            //alert("a1111111111 "+a1);
            var b = eval(document.getElementById("animalwaste").value);
            var c = eval(document.getElementById("soiledwaste").value);
            var d = eval(document.getElementById("discardedwaste").value);
            var e = eval(document.getElementById("chemicalSolidWaste").value);
            var f = eval(document.getElementById("chemicalLiquidWaste").value);
            var g = eval(document.getElementById("discardedLinen").value);
            var h = eval(document.getElementById("otherClinicLabWaste").value);
            var i = eval(document.getElementById("contaminatedWaste").value);

            var j = eval(document.getElementById("wasteSharps").value);
            var k = eval(document.getElementById("glassWare").value);
            var l = eval(document.getElementById("metallicBodyImplants").value);

            if (a != '' && a != null) {
                total = total + a;
            }
            if (b != '' && b != null) {
                total = total + b;
            }

            if (c != '' && c != null) {
                total = total + c;
            }
            if (d != '' && d != null) {
                total = total + d;
            }
            if (e != '' && e != null) {
                total = total + e;
            }
            if (f != '' && f != null) {
                total = total + f;
            }

            if (g != '' && g != null) {
                total = total + g;
            }

            if (h != '' && h != null) {
                total = total + h;
            }
            if (i != '' && i != null) {
                total = total + i;
            }


            if (j != '' && j != null) {
                total = total + j;
            }

            if (k != '' && k != null) {
                total = total + k;
            }

            if (l != '' && l != null) {
                total = total + l;
            }


            //alert("Sum" +total)
            //document.getElementById("total1").value = eval(document.getElementById("anatomicalwaste").value)+eval(document.getElementById("animalwaste").value)+eval(document.getElementById("biowaste").value)+eval(document.getElementById("wastesharp").value)+eval(document.getElementById("discardedwaste").value)+eval(document.getElementById("soiledwaste").value)+eval(document.getElementById("solidwaste").value)+eval(document.getElementById("ash").value)+eval(document.getElementById("chemicalwaste").value);
            document.getElementById("total1").value = total;
        }


        function checkField2(id) {

            if (id.value == "") {

                id.value = "0";
            }

            var total = 0;
            var a = eval(document.getElementById("anatomicalwaste1").value);
            var b = eval(document.getElementById("animalwaste1").value);
            var c = eval(document.getElementById("biowaste1").value);
            var d = eval(document.getElementById("wastesharp1").value);
            var e = eval(document.getElementById("discardedwaste1").value);
            var f = eval(document.getElementById("soiledwaste1").value);
            var g = eval(document.getElementById("solidwaste1").value);
            var h = eval(document.getElementById("ash1").value);
            var i = eval(document.getElementById("chemicalwaste1").value);
            if (a != '' && a != null) {
                total = total + a;
            }
            if (b != '' && b != null) {
                total = total + b;
            }

            if (c != '' && c != null) {
                total = total + c;
            }
            if (d != '' && d != null) {
                total = total + d;
            }
            if (e != '' && e != null) {
                total = total + e;
            }
            if (f != '' && f != null) {
                total = total + f;
            }
            if (g != '' && g != null) {
                total = total + g;
            }
            if (h != '' && h != null) {
                total = total + h;
            }
            if (i != '' && i != null) {
                total = total + i;
            }

            //document.getElementById("total2").value = eval(document.getElementById("").value)+eval(document.getElementById("animalwaste1").value)+eval(document.getElementById("biowaste1").value)+eval(document.getElementById("wastesharp1").value)+eval(document.getElementById("discardedwaste1").value)+eval(document.getElementById("soiledwaste1").value)+eval(document.getElementById("solidwaste1").value)+eval(document.getElementById("ash1").value)+eval(document.getElementById("chemicalwaste1").value);
            //document.getElementById("total2").value =total;
        }

    </script>

</head>

<body>
<%
    IndustryRegMaster industryRegMaster = IndustryRegMaster.get(industryRegMasterId)
    BmwRenew bmwRenew = BmwRenew.get(bmwRenewId)
%>
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
                <td height="32" align="left" valign="top"
                    background="${createLinkTo(dir: 'images2/gif', file: 'button_BG.gif')}">
                    <!-- code for menuIndustryHorizontal-->
                    <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
                </td>
            </tr>
            <tr>
            <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                        <!-- code for menuSpcbUser-->
                        <%
                            if ((IndUser) session.getAttribute("indUser")) { %>
                            <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><% } %>
                        <% if ((UserMaster) session.getAttribute("userMaster")) {
                            UserMaster aa = (UserMaster) session.getAttribute("userMaster");
                            String userType = aa.accessLevel;
                            if (userType.equals("admin")) { %>
                        <g:include controller="userMaster" action="wasteManagementAdminVertical"/>
                        <% } else { %>
                        <g:include controller="userMaster" action="wasteManagementEmpVertical"/>
                        <% }
                        } %>
                        <% if ((!(IndUser) session.getAttribute("indUser")) && (!(UserMaster) session.getAttribute("userMaster"))) { %>
                        <g:include controller="userMaster" action="showIndexMenu"/>
                        <% } %>
                    </td>
                    <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                    <td width="778" align="left"
                        valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td height="1" valign="top"></td>
                        </tr>
                            <tr>
                                <td><img src="${createLinkTo(dir: 'images2', file: 'img.jpg')}" width="778"
                                         height="134"/></td>
                            </tr>
                            <%
                                IndustryRegMaster ind = (IndustryRegMaster) session.getAttribute("indregName")
                                String indname = ind.indName;

                                java.util.Date dateSCR = new java.util.Date();
                                int year = dateSCR.getYear();
                                if (year < 1000)
                                    year += 1900;
                                int date = dateSCR.getDate();
                                int month = (dateSCR.getMonth()) + 1;


                            %>

                            <tr>
                                <td height="24" bgcolor="#EEEEF3">

                                    <table width="100%" bgcolor="#4C8BC0">
                                        <tr bgcolor="#4C8BC0">
                                            <td class="top-lnks">Welcome <%=indname%></td>
                                            <td class="top-lnks"
                                                align="right">Date :&nbsp;<%=date%>-<%=month%>-<%=year%></td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                            <tr>
                                <td height="0" align="left"
                                    valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr><!-- Div area for errors-->  <td align="center" valign="top">
                                        <div
                                                style="width:400px;  vertical-align:middle">
                                            <span class="error">
                                                <g:if test="${flash.message}">
                                                    <div class="message">${flash.message}</div>
                                                </g:if>
                                                <g:hasErrors bean="${bioMedicalWasteInstance}">
                                                    <div class="errors">
                                                        <g:renderErrors bean="${bioMedicalWasteInstance}" as="list"/>
                                                    </div>
                                                </g:hasErrors>
                                            </span>
                                    </td>
                                    </tr>
                                    <!--<tr>
                      <td align="center" valign="top">Row for Page Heading</td>

                    </tr>-->
                    <% System.out.println("bmwRenew.bmwRenewStatus.1111111.."+bmwRenew.bmwRenewStatus) %>
                                    <% def instancebmw=bmwRenew.bmwRenewStatus
                                    if (instancebmw.equals("Completed")) {
                                    	System.out.println("bmwRenew.bmwRenewStatus..."+bmwRenew.bmwRenewStatus)%>
                                    <tr>
                                    <td height="0" align="right" valign="top">
                                        <span class="btn btn-primary btn-sm">
                                        <g:link action="downloadCompletedApplicationPdf" controller="bioMedicalWaste" params="[bmwRenewId:bmwRenewId]">Download bmw Annual Return Form </g:link>&nbsp;</td>
                                        	</span>
                                        </td>
                                    </tr>
                                    <%}%>
                                    <tr>
                                        <td height="0" align="left" valign="top"><table width="778" border="0"
                                                                                        cellspacing="0" cellpadding="0">
                                            <tr>

                                                <table width="710" align="left" valign="top"><div
                                                        style="padding:0px 0px 0px 0px;">
                                                        <td align="left" valign="top">
        												<div style="padding: 0px 0px 0px 0px;">
        													<div style="" :1px solidgray; width:900px; margin-bottom: 1em; padding: 10px" >
        														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        															<tr valign="middle">
        																<td width="100%" align="center">
        											<ol id="toc">
        												<li><a href="#country1"><span>General Details</span></a></li>
        											    <li><a href="#country2"><span>Health Care Facilities Details</span></a></li>
        												<li><a href="#country3"><span>Quantity of Waste Generated</span></a></li>
        												<li><a href="#country4"><span>Storage,Treatment,Transportation,Processing and Disposal Facility Details</span></a></li>
        												<li><a href="#country5"><span>BMW Management Committee</span></a></li>
        												<li><a href="#country6"><span>Training Conducted</span></a></li>
        												<li><a href="#country7"><span>Accident Occurred & Other Detail</span></a></li>
        												</ol>
        												</td>
        												<td width="30%" align="right">
        												</td>
        											</tr>
        										</table>

                                                    <div id="formInsideApplyBmwRenew_gsp">

                                                        <table width="100%" border="0" align="left" cellpadding="2"
                                                               cellspacing="0">
                                                            <tr valign="middle">
                                                                <td width="100%" align="center">
                                                                 
                                                                </td>
                                                                <td align="right" valign="middle"
                                                                    class="headngblue"></td>
                                                            </tr>
                                                        </table>
                                                    </div>

                                                    <div id="country1" class="content">
        											<div class="dialog">
        												 <table>
        														<tbody>
        															   <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
        																	 <tr>
                                                                                <td  align="center" colspan="2" valign="middle" bgcolor="lightgrey" class="headngblue">Particulars of the Occupier</td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="60%" bgcolor="#A8DAF3" align="left"
                                                                                    class="headngblue">Name of the authorized person
                                                                                (occupier or operator of facility)
                                                                                </td>
                                                                                <td width="40%" bgcolor="#E8F6F9" align="left"
                                                                                    class="headngblue"><%=industryRegMaster.occName%>
                                                                                </td>
                                                                            </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Name of the authorized person
                                                                                    (occupier or operator of facility)
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">

                                                                                        <span>
                                                                                            <%=industryRegMaster.occName%>
                                                                                        </span>

                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Name of HCF or CBMWTF
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=industryRegMaster.indName%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Address for Correspondence
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=industryRegMaster.occAddress%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Address of Facility
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=industryRegMaster.indAddress%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Tel. No.
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=industryRegMaster.occMobile%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Fax. No.
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <table>
                                                                                            <tr>
                                                                                                <td>
                                                                                                    <span>
                                                                                                        <%=industryRegMaster.occFaxCode%>
                                                                                                    </span>
                                                                                                </td>
                                                                                                <td>
                                                                                                    <span>
                                                                                                        <%=industryRegMaster.occFaxNo%>
                                                                                                    </span>
                                                                                                </td>
                                                                                            </tr>
                                                                                        </table>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">E-mail ID
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=industryRegMaster.occEmail%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">URL of Website
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=bmwRenew.occUrlWebsite%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">GPS coordinates of HCF of
                                                                                    CBMWTF
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <span>
                                                                                            <%=bmwRenew.occGpsCoordinate%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Ownership of HCF of CBMWTF
                                                                                    </td>
                                                                                    <!-- have to implement select dropdown -->
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">

                                                                                        <span>
                                                                                            <%=bmwRenew.occOwnershipHcf%>
                                                                                        </span>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td rowspan="2" width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Status of Authorization under the
                                                                                    Bio-Medical Waste (Managementand Handing) Rules
                                                                                    </td>

                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <table>
                                                                                            <tr>
                                                                                                <td>
                                                                                                    Authorization No. &nbsp;
                                                                                                </td>
                                                                                                <td>
                                                                                                    <span>
                                                                                                        <%=bmwRenew.occAuthorizationNoBmw%>
                                                                                                    </span>
                                                                                                </td>
                                                                                            </tr>
                                                                                        </table>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>

                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <table>
                                                                                            <tr>
                                                                                                <td>
                                                                                                    Valid Upto &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                </td>
                                                                                                <td>
                                                                                                    <% java.text.DateFormat df = new SimpleDateFormat("dd/MM/yyyy")%>
                                                                                                    <span>
                                                                                                    <%if(bmwRenew.occValidUptoBmw){%>
                                                                                                        <%=df.format(bmwRenew.occValidUptoBmw)%>
                                                                                                    <%}%>
                                                                                                    </span>
                                                                                                </td>
                                                                                            </tr>
                                                                                        </table>
                                                                                    </td>
                                                                                </tr>

                                                                                <tr>
                                                                                    <td width="40%"
                                                                                        bgcolor="#A8DAF3"
                                                                                        align="left"
                                                                                        class="headngblue">Status of Consents under Water
                                                                                    Act and Air Act.
                                                                                    </td>
                                                                                    <td width="60%"
                                                                                        bgcolor="#E8F6F9"
                                                                                        align="left"
                                                                                        class="headngblue">
                                                                                        <table>
                                                                                            <tr>
                                                                                                <td>
                                                                                                    Valid Upto &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                </td>
                                                                                                <td>
                                                                                                    <span>
                                                                                                        <%if(bmwRenew.occValidUptoConsent){%>
                                                                                                        <%=df.format(bmwRenew.occValidUptoConsent)%>
                                                                                                        <%}%>
                                                                                                    </span>
                                                                                                    </td>
                                                                 									 </table>
                                                                 									 </div>
                                                                 							    </td>
                                                                 							</tr>
                                                                 					    </table>
                                                                 			        </tbody>
                                                                 	             </table>
                                                                              </div>
                                                                          </div>
                                                                 		

                                                                          <div id="country2" class="content">
                                                                          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                               	            <tr>
                                                               	                <td bgcolor="#FFFFFF">
                                                               	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                    			                   <tr>
                                                                                       <td width="60%" align="left"
                                                                                           bgcolor="#A8DAF3"
                                                                                           class="headngblue">HCF/CBMWTF Type <scope
                                                                                               style="color:red">*</scope></td>
                                                                                               <td width="40%" align="left"
                                                                                                   bgcolor="#E8F6F9"
                                                                                                   class="headngblue">
                                                                                                   <input type="text"
                                                                                                          id="hcfType1"
                                                                                                          value="${bmwRenew.hcfHcfCbmwtfType}"
                                                                                                          style="display: none"/>
                                                                                                   <span>
                                                                                                       <%=bmwRenew.hcfHcfCbmwtfType%>
                                                                                                   </span>
                                                                                                   <script>
                                                                                                       selectHcfType();
                                                                                                   </script>

                                                                                               </td>
                                                                                   </tr>
                                                                                        <% if (bmwRenew.hcfHcfCbmwtfType == 'HCF') { %>
                                                                                        <tr id="noOfBeds_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">No. of Beds(for Bedded Hospital)
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=
                                                                                                            bmwRenew.hcfNoOfBeds%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr id="non_bedded_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">Non-Bedded Hospital<br/>(Clinic or Blood Bank or Clinical
                                                                                            Laboratory or Research Institute or
                                                                                            Veterinary Hospital or any other)
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=
                                                                                                            bmwRenew.hcfNonBedded%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr id="licenceNo_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">License Number
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.hcfLicenceNo%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr id="licenceDateOfExpiry_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">License Date of
                                                                                            Expiry
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%if(bmwRenew.hcfLicenceDateOfExpiry){%>
                                                                                                    <%=df.format(bmwRenew.hcfLicenceDateOfExpiry)%>
                                                                                                    <%}%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <% } %>
                                                                                        <% if (bmwRenew.hcfHcfCbmwtfType == 'CBMWTF') { %>
                                                                                        <tr id="noHealthcareCBMWTF_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">Number healthcare facilities
                                                                                            covered by CBMWTF
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=
                                                                                                            bmwRenew.hcfCbmwtfHealthcareFacilitiesNo%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr id="noBedsCBMWTF_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">No. of beds covered by CBMWTF
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=
                                                                                                            bmwRenew.hcfCbmwtfbedsNo%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr id="installedTreatmentCBMWTF_id">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">Installed treatment and disposal
                                                                                            capacity of CBMWTF
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=
                                                                                                            bmwRenew.hcfCbmwtfInstalledTreatment%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr id="quantityBiomedicalCBMWTF">
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                align="left"
                                                                                                class="headngblue">Quantity of biomedical waste
                                                                                            treated or disposal by CBMWTF
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                align="left"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=
                                                                                                            bmwRenew.hcfCbmwtfQuantityBmw%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <% } %>
                                                                                        </td>
                                                     									 </table>
                                                     									 </div>
                                                     							    </td>
                                                     							</tr>
                                                     					    </table>
                                                     			        </tbody>
                                                     	             </table>
                                                                  </div>
                                                              </div>


                                                              <div id="country3" class="content">
                                                              <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                   	            <tr>
                                                   	                <td bgcolor="#FFFFFF">
                                                   	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                        			                   <tr>
                                                                                    <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Quantity of waste generated or

                                                                                                disposed in Kg per annum (on

                                                                                                monthly average basis)
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <table>
                                                                                                    <tr>
                                                                                                        <td class="headngblue">
                                                                                                            Yellow Category
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.qwgYellowCategory%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="headngblue">
                                                                                                            Red Category
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.qwgRedCategory%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="headngblue">
                                                                                                            White
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.qwgWhiteCategory%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="headngblue">
                                                                                                            Blue Category
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.qwgBlueCategory%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="headngblue">
                                                                                                            General Solid Waste
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.qwgGeneralSolidWaste%>
                                                                                                            </span>
                                                                                                            </td>
                                                                         									 </table>
                                                                         									 </div>
                                                                         							    </td>
                                                                         							</tr>
                                                                         					    </table>
                                                                         			        </tbody>
                                                                         	             </table>
                                                                                      </div>
                                                                                  </div>


                                                                                  <div id="country4" class="content">
                                                                                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                                       	            <tr>
                                                                       	                <td bgcolor="#FFFFFF">
                                                                       	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                            			                   <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Details of the on-site storage
                                                                                                facility
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">

                                                                                                <table>
                                                                                                    <tr>
                                                                                                        <td>
                                                                                                            Size
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.sttpdOnSiteSize%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>
                                                                                                            Capacity
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.sttpdOnSiteCapacity%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td colspan="2">
                                                                                                            <table>
                                                                                                                <tr>
                                                                                                                    <td>
                                                                                                                        Provision of on-site storage
                                                                                                                    </td>
                                                                                                                    <td>
                                                                                                                        <span>
                                                                                                                            <%=bmwRenew.sttpdOnSiteProvision%>
                                                                                                                        </span>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                    <td>
                                                                                                                        (cold storage or
                                                                                                                        any other provision)
                                                                                                                    </td>

                                                                                                                </tr>

                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                </table>

                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Disposal Facilities
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <table width="90%">
                                                                                                    <tr>
                                                                                                        <td>

                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <a href="#"
                                                                                                               class="addViewDelete"
                                                                                                               onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popDisposalFacilitiesView/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                                View
                                                                                                            </a>
                                                                                                        </td>
                                                                                                        <td>

                                                                                                        </td>
                                                                                                    </tr>
                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>

                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Quantity of recyclable wastes sold
                                                                                                to authorized recyclers after
                                                                                                treatment in kg per annum.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <table>
                                                                                                    <tr>
                                                                                                        <span>
                                                                                                            <%=bmwRenew.sttpdQuantityRecyclableWaste%>
                                                                                                        </span>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        Red Category (like plastic, glass etc.)
                                                                                                    </tr>
                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                No of vehicles used for collection
                                                                                                and transportation of biomedical
                                                                                                waste.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.sttpdVehiclesUsed%>
                                                                                                </span>
                                                                                            </td>

                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Details of incineration ash and
                                                                                                ETP sludge generated and
                                                                                                disposal during the treatment of
                                                                                                wastes in Kg per annum)
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <table width="90%">
                                                                                                    <tr>
                                                                                                        <td>

                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <a href="#"
                                                                                                               class="addViewDelete"
                                                                                                               onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popWasteTreatmentView/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                                View
                                                                                                            </a>
                                                                                                        </td>
                                                                                                        <td>

                                                                                                        </td>
                                                                                                    </tr>
                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Name of the Common Bio-
                                                                                                Medical Waste Treatment
                                                                                                Facility Operator through which
                                                                                                wastes are disposed of
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.sttpdCommonBmwOperator%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                List of member HCF not handed
                                                                                                over bio-medical waste.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <g:link controller="bioMedicalWaste"
                                                                                                    action="downloadUploadedDoc"
                                                                                                    params="[bmwRenewId: bmwRenewId]">
                                                                                                    download
                                                                                                </g:link>
                                                                                                    </td>
                                                                 									 </table>
                                                                 									 </div>
                                                                 							    </td>
                                                                 							</tr>
                                                                 					    </table>
                                                                 			        </tbody>
                                                                 	             </table>
                                                                              </div>
                                                                          </div>
                                                                          
                                                                          
                                                                          <div id="country5" class="content">
                                                                          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                               	            <tr>
                                                               	                <td bgcolor="#FFFFFF">
                                                               	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                    			                   <tr>
                                                                                       <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Do you have bio-medical waste
                                                                                                management committee?
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <table>
                                                                                                    <tr>
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.bmwtcIsHaveCommittee%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr
                                                                                                        <%if(bmwRenew.bmwtcIsHaveCommittee.equals("yes")){%>
                                                                                                            style="display: block;"
                                                                                                        <%}else{%>
                                                                                                            style="display: none;"
                                                                                                        <%}%>
                                                                                                    >
                                                                                                        <td>
                                                                                                            <span>
                                                                                                                <%=bmwRenew.bmwtcCommitteeDetails%>
                                                                                                            </span>
                                                                                                            &nbsp;
                                                                                                            <span bgcolor="#E8F6F9"
                                                                                                                  class="headngblue">
                                                                                                            <g:link controller="bioMedicalWaste"
                                                                                                                    action="downloadUploadedDocManagementCommittee"
                                                                                                                    params="[bmwRenewId: bmwRenewId]">
                                                                                                                download
                                                                                                            </g:link>
                                                                                                            </span>
                                                                                                            </td>
                                                                         									 </table>
                                                                         									 </div>
                                                                         							    </td>
                                                                         							</tr>
                                                                         					    </table>
                                                                         			        </tbody>
                                                                         	             </table>
                                                                                      </div>
                                                                                  </div>

                                                                                  <div id="country6" class="content">
                                                                                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                                       	            <tr>
                                                                       	                <td bgcolor="#FFFFFF">
                                                                       	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                            			                   <tr>
                                                                                           <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Number of training conducted
                                                                                                on BMW Management.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.tcNoOfTrainingConducted%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Number of personnel trained
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.tcNoOfPersonnelTrained%>
                                                                                                </span>
                                                                                            </td>

                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Number of personnel trained at
                                                                                                the time of induction
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.tcNoOfPersonnelTrainedInduction%>
                                                                                                </span>
                                                                                            </td>

                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Number of personnel not
                                                                                                undergone any training so far.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.tcPersonnelNotUndergoneTraining%>
                                                                                                </span>
                                                                                            </td>

                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Whether standard manual for
                                                                                                training is available ?
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.tcIsStandardManualAvailable%>
                                                                                                </span>
                                                                                            </td>

                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Any other information
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.tcAnyOtherInfo%>
                                                                                                </span>
                                                                                                </td>
                                                             									 </table>
                                                             									 </div>
                                                             							    </td>
                                                             							</tr>
                                                             					    </table>
                                                             			        
                                                                          </div>
                                                                      </div>

                                                                      <div id="country7" class="content">
                                                                      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                           	            <tr>
                                                           	                <td bgcolor="#FFFFFF">
                                                           	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                			                   <tr>
                                                                                    <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Number of Accidents occurred
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.aodNoOfAccidentOccured%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Number of the persons affected
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.aodNoOfPersonAffected%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Remedial Action taken (Please
                                                                                                attach details if any)
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.aodRemedialActionTaken%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Any Fatality occurred, details.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.aodAnyFatalities%>
                                                                                                </span>
                                                                                                </td>
                                                             									
                                                                                                <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Are you meeting the standards of air
                                                                                                Pollution from the incinerator?. How
                                                                                                many times in last year could not met
                                                                                                the standards?
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.odMeetingAirStandard%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Details of Continuous online emission
                                                                                                monitoring systems installed
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.odContinuousOnlineEmission%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Liquid waste generated and treatment
                                                                                                methods in place. How many times
                                                                                                you have not met the standards in a
                                                                                                year.
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.odLiquidWasteGenerated%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                It the disinfection method or
                                                                                                sterilization meeting the log 4
                                                                                                standards? How many times you have
                                                                                                not met the standards in a year?
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <span>
                                                                                                    <%=bmwRenew.odDisinfectionMethod%>
                                                                                                </span>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td width="40%"
                                                                                                bgcolor="#A8DAF3"
                                                                                                class="headngblue">
                                                                                                Any other relevant information
                                                                                            </td>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <table>
                                                                                                    <tr>
                                                                                                        <td width="60%"
                                                                                                            bgcolor="#E8F6F9"
                                                                                                            class="headngblue">
                                                                                                            <span>
                                                                                                                <%=bmwRenew.odAnyOtherReleventInfo%>
                                                                                                            </span>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>
                                                                                                            (Air Pollution Control Device attached with the
                                                                                                            incinerator)
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>

                                                                                    </table>
                                                                                </div>

                                                                                <%if(bmwRenew.bmwRenewStatus == "Inprogress"){%>
                                                                                    <tr>

                                                                                    <td align="center">
                                                                                        <g:link controller="bmwRenew"
                                                                                            action="editBmwRenew"
                                                                                            params="[bmwRenewId: bmwRenewId]">
                                                                                            <button type="button"
                                                                                            class="actionbutton">Edit</button>
                                                                                        </g:link>
                                                                                    </td>
                                                                                    </tr>
                                                                                <%}%>
                                                                                </td>
                                           									 </table>
                                           									 </div>
                                           							    </td>
                                           							</tr>
                                           					    </table>
                                           			        </tbody>
                                           	             </table>
                                                        </div>
                                                    </div>
                                                    <!-- ############################ ENDS ########################## -->

                                                    <td width="35" align="left" valign="top">&nbsp;</td>
                                                </tr>
                                                </table></td>
                                            </tr>

                                            <table>

                                            </div>
                                            </table>

                                        </td>
                                        </tr>
                                        </table>

                                        </div>

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



    //    var frmvalidator = new Validator("myform");
    frmvalidator.EnableFocusOnError(false);
    frmvalidator.EnableMsgsTogether();


    function tosubmit() {

        //alert("Inside function toSubmit");
        if (!(document.getElementById("checkboxGeneration").checked) && !(document.getElementById("checkboxCollection").checked) && !(document.getElementById("checkboxReception").checked) && !(document.getElementById("checkboxStorage").checked) && !(document.getElementById("checkboxTransportation").checked) && !(document.getElementById("checkboxTreatment").checked) && !(document.getElementById("checkboxDisposal").checked) && !(document.getElementById("checkboxAnyother").checked) && !(document.getElementById("checkboxOffering").checked) && !(document.getElementById("checkboxRecycling").checked) && !(document.getElementById("checkboxPackaging").checked)) {

            alert("Please Check Atleast one Authorization Required For Check Box");
            return false;
        }

        else {

            //if(!(document.getElementById("checkboxHAW").checked) &&!(document.getElementById("checkboxAW").checked) && !(document.getElementById("checkboxMBW").checked) && !(document.getElementById("checkboxWS").checked) && !(document.getElementById("checkboxDMCD").checked) && !(document.getElementById("checkboxSW6").checked) && !(document.getElementById("checkboxSW7").checked) && !(document.getElementById("checkboxLW").checked) && !(document.getElementById("checkboxIA").checked) && !(document.getElementById("checkboxCW").checked))
            //{
            //alert("Please Check Atleast one Category Check Box");
            //return false;
            //}
            //else
            //{
//if(document.getElementById("checkboxHAW").checked)
            //{
            //frmvalidator.addValidation("categHAW","req","Please enter value for Category no. 1 ");
            //frmvalidator.addValidation("categHAW","dec","enter valid value for Category no. 1 " );
            // frmvalidator.addValidation("categHAWUnit","req","Please enter value for unit of Category no. 1 " );

            //}

            //if(document.getElementById("checkboxAW").checked)
            //{
            //frmvalidator.addValidation("categAW","req","Please enter value for Category no. 2 ");
            //frmvalidator.addValidation("categAW","dec","enter valid value for Category no. 2 ");
            //frmvalidator.addValidation("categAWUnit","req","Please enter value for unit of Category no. 2 " );

            //}

            //if(document.getElementById("checkboxMBW").checked)
            //{
            //frmvalidator.addValidation("categMBW","req","Please enter value for Category no. 3 ");
            //frmvalidator.addValidation("categMBW","dec","enter valid value for Category no. 3 ");
            //frmvalidator.addValidation("categMBWUnit","req","Please enter value for unit of Category no. 3 " );

            //}

            //if(document.getElementById("checkboxWS").checked)
            //{
            //frmvalidator.addValidation("categWS","req","Please enter value for Category no. 4 ");
            //frmvalidator.addValidation("categWS","dec","enter valid value for Category no. 4 ");
            //frmvalidator.addValidation("categWSUnit","req","Please enter value for Unit of Category no. 4 ");

            //}

            //if(document.getElementById("checkboxDMCD").checked)
            //{
            //frmvalidator.addValidation("categDMCD","req","Please enter value for Category no. 5 ");
            //frmvalidator.addValidation("categDMCD","dec","enter valid value for Category no. 5 ");
            //frmvalidator.addValidation("categDMCDUnit","req","Please enter value for unit of Category no. 5 ");


            //}

            //if(document.getElementById("checkboxSW6").checked)
            //{
            //frmvalidator.addValidation("categSW6","req","Please enter value for Category no. 6 ");
//frmvalidator.addValidation("categSW6","dec","enter valid value for Category no. 6 ");
            //frmvalidator.addValidation("categSW6Unit","req","Please enter value for unit of  Category no. 6 ");


// }

            //if(document.getElementById("checkboxSW7").checked)
            //{
            //frmvalidator.addValidation("categSW7","req","Please enter value for Category no. 7 ");
            //frmvalidator.addValidation("categSW7","dec","enter valid value for Category no. 7 ");
            //frmvalidator.addValidation("categSW7Unit","req","Please enter value for unit of Category no. 7 ");


// }

            //if(document.getElementById("checkboxLW").checked)
            //{
            //frmvalidator.addValidation("categLW","req","Please enter value for Category no. 8 ");
            //frmvalidator.addValidation("categLW","dec","enter valid value for Category no. 8 ");
            //frmvalidator.addValidation("categLWUnit","req","Please enter value for Unit of Category no. 8 ");


            //}

            //if(document.getElementById("checkboxIA").checked)
            //{
            //frmvalidator.addValidation("categIA","req","Please enter value for Category no. 9 " );
            //frmvalidator.addValidation("categIA","dec","enter valid value for Category no. 9 ");
            //frmvalidator.addValidation("categIAUnit","req","Please enter value for Unit of Category no. 9 " );


// }

            //if(document.getElementById("checkboxCW").checked)
            //{
            //frmvalidator.addValidation("categCW","req","Please enter value for Category no. 10 ");
            //frmvalidator.addValidation("categCW","dec","enter valid value for Category no. 10 ");
            //frmvalidator.addValidation("categCWUnit","req","Please enter value for unit of Category no. 10 ");


            //}

            frmvalidator.addValidation("authorizationType", "selone_radio", "Please Select any one of the Authorization Type");


            //if(document.getElementById("radiobuttonRenew").checked)
            //{

            //frmvalidator.addValidation("prevauthNo","req","Please Enter Authorization Renew Number ");
            //frmvalidator.addValidation("addrPlaceDisposalOfWaste","req","Please Select Address of Place of Treatment/Disposal ");
            //frmvalidator.addValidation("prevauthDate","req","Please Enter Authorization Renew Date ");
            //frmvalidator.addValidation("prevexpDate","req","Please Enter Authorization Expiry Date ");
            //}


            //if(document.getElementById("addrPlaceDisposalOfWaste.id").value == 100){
            //alert("Please select Address of Place Disposal Of Waste");
            //return false;
// }

// if(document.getElementById("addrPlaceDisposalOfWaste.id").value == "Other"){

            //frmvalidator.addValidation("addrTreatmentFacility","req","Please enter Address of Treatment Facility");

// }

            //frmvalidator.addValidation("createdBy","req","Please enter createdBy");
            //frmvalidator.addValidation("createdBy","alpha_s","enter valid Entry for createdBy");

            //frmvalidator.addValidation("descrip","req","Please enter Description");


// frmvalidator.addValidation("modeTrans","req","Please enter Mode of Transportation");
            //frmvalidator.addValidation("modeTrans","alpha_s","enter valid Entry for Mode of Transportation");

            //frmvalidator.addValidation("modeTreat","req","Please enter Mode of Treatment");
            //frmvalidator.addValidation("modeTreat","alpha_s","enter valid Entry for Mode of Treatment");


            frmvalidator.addValidation("appStatus", "selone_radio", "Please select any one of the Application Status ");
//}

            /* ############## validaton for country2 start##################*/
            var lat = document.getElementById("latitude").value

            if (lat.length > 0) {
                if (lat.length > 9 || lat.length < 9) {
                    alert("Latitude Value must be of 9 digits with 6 Decimal digits like as(12.123456)");
                    return false;
                }
            }
            var longt = document.getElementById("longtitude").value
            if (longt.length > 0) {
                if (longt.length > 9 || longt.length < 9) {
                    alert("Longtitude Value must be of 9 digits with 6 Decimal digits like as(12.123456)");
                    return false;
                }
            }
            frmvalidator.addValidation("latitude", "decimal", "Plese Enter the Latitude in Decimal Degrees with 6 Decimals");
            frmvalidator.addValidation("longtitude", "decimal", "Plese Enter the Longitude in Decimal Degrees with 6 Decimals");
            frmvalidator.addValidation("outpatientsFacility", "decimal", "Medical treatment Facility provided to Outpatients must be Numeric ");
            frmvalidator.addValidation("inpatientsFacility", "decimal", "Medical treatment Facility provided to Inpatients must be Numeric ");
            frmvalidator.addValidation("noofbeds", "decimal", "No of Beds of HCF must be Numeric ");
            frmvalidator.addValidation("noOfInOutPatients", "decimal", "Total number of inpatients & outpatients treated per month in the HCF must be Numeric");
            frmvalidator.addValidation("NoofHCF", "decimal", "No of HCFs covered by the CBMWTF must be numeric ");
            frmvalidator.addValidation("NoofBedsCbmwtf", "decimal", "No of beds covered by the CBMWTF must be numeric ");
            frmvalidator.addValidation("treatmentAndDisposal", "decimal", "Installed treatment and disposal capacity of CBMWTF must be numeric ");
            frmvalidator.addValidation("qtyOfBmwTreated", "decimal", "Quantity of BMW treated or disposed by CBMWTF must be numeric ");

            /* ############## validaton for country2 End##################*/

            /* ############## validaton for country3 start##################*/

            frmvalidator.addValidation("incinrators", "decimal", "Incinerators No of Units must be numeric ");
            frmvalidator.addValidation("plasmaPyrolysis", "decimal", "Plasma Pyrolysis No of Units must be numeric ");
            frmvalidator.addValidation("autoclaves", "decimal", "Autoclaves must No of Units be numeric ");
            frmvalidator.addValidation("microwave", "decimal", "Microwave must No of Units be numeric ");
            frmvalidator.addValidation("hydroclave", "decimal", "Hydroclave No of Units must be numeric ");
            frmvalidator.addValidation("shredders", "decimal", "Shredders No of Units must be numeric ");
            frmvalidator.addValidation("needleTipCutter", "decimal", "Needle tip cutter or destroyer No of Units must be numeric ");
            frmvalidator.addValidation("sharpEncapsulation", "decimal", "Sharp encapsulation or Concrete pit No of Units must be numeric ");
            frmvalidator.addValidation("deepBurial", "decimal", "Deep burial pits No of Units must be numeric ");
            frmvalidator.addValidation("chemDisinfection", "decimal", "Chemical disinfection No of Units must be numeric ");
            frmvalidator.addValidation("anyOtherTreatmentEquip", "decimal", "Any other treatment equipment must be numeric ");
            /* ############## validaton for country3 End##################*/

            /* ############## validaton for country5 Start ##################*/
            frmvalidator.addValidation("anatomicalwaste", "decimal", "Human Anatomical Waste per day Quantity must be numeric");
            frmvalidator.addValidation("animalwaste", "decimal", "Animal Waste per day Quantity must be numeric");
            frmvalidator.addValidation("soiledwaste", "decimal", "Soiled Waste per day Quantity must be numeric");
            frmvalidator.addValidation("discardedwaste", "decimal", "Expired or Discarded Medicines per day Quantity must be numeric");
            frmvalidator.addValidation("chemicalSolidWaste", "decimal", "Chemical Solid Waste per day Quantity must be numeric");
            frmvalidator.addValidation("chemicalLiquidWaste", "decimal", "Chemical Liquid Waste per day Quantity must be numeric");
            frmvalidator.addValidation("discardedLinen", "decimal", "Discarded linen, mattresses, beddings contaminated with blood or body fluid per day Quantity must be numeric");
            frmvalidator.addValidation("otherClinicLabWaste", "decimal", "Microbiology,Biotechnology and other clinical laboratory waste per day Quantity must be numeric");
            frmvalidator.addValidation("contaminatedWaste", "decimal", "Contaminated waste (Recyclable) per day Quantity must be numeric");
            frmvalidator.addValidation("wasteSharps", "decimal", "Waste sharps including Metals per day Quantity must be numeric");
            frmvalidator.addValidation("glassWare", "decimal", "Glassware per day Quantity must be numeric");
            frmvalidator.addValidation("metallicBodyImplants", "decimal", "Metallic Body Implants per day Quantity must be numeric");

            /* ############## validaton for country5 End ##################*/
            //frmvalidator.addValidation("bmwfacility","dontselect=0","Please Select Bio-Medical Waste Facility Status");
            //frmvalidator.addValidation("bmwstatus","req","Please Select Office address of the common facility handling BMW");
            //frmvalidator.addValidation("locfacility","req","Please Select Address of the location of the common facility");

        }

        // frmvalidator.addValidation("bmwfacility","dontselect=0","Please Select Bio-Medical Waste Facility Status");
        //frmvalidator.addValidation("bmwstatus","req","Please Select Office address of the common facility handling BMW");
        //frmvalidator.addValidation("locfacility","req","Please Select Address of the location of the common facility");
//   frmvalidator.addValidation("wastedisposalplace","req","Please Select Address of the place of disposal of wastes");
        //frmvalidator.addValidation("hcfType1","dontselect=0","Please Select HCF/CBMWTF Type");
        //frmvalidator.addValidation("hcfTypeMenu1","dontselect=0","Please Select HCF/CBMWTF Type");


        //frmvalidator.addValidation("anatomicalwaste","decimal","Human Anatomical Waste per day Quantity must be numeric");
        //frmvalidator.addValidation("animalwaste","decimal","Animal Waste per day Quantity must be numeric");
        //frmvalidator.addValidation("discardedwaste","decimal","Discarded Medicines & Cytotoxic drugs per day Quantity must be numeric");
        //frmvalidator.addValidation("soiledwaste","decimal","Soiled Waste per day Quantity must be numeric");
        //frmvalidator.addValidation("total1","decimal","Total Quantity handled Per Day Must Be Numeric");


        //frmvalidator.addValidation("anatomicalwaste","req","please enter Human Anatomical Waste per day Quantity ");
        //frmvalidator.addValidation("animalwaste","req","please enter Animal Waste per day Quantity");
        //frmvalidator.addValidation("biowaste","req","please enter Microbiology & Biotechnology Waste per day Quantity");
        //frmvalidator.addValidation("wastesharp","req","please enter Waste Sharps Needles, syringes, scalpels, blades, glass etc. that may cause puncture and cuts per day Quantity");
        //frmvalidator.addValidation("discardedwaste","req","please enter Discarded Medicines & Cytotoxic drugs per day Quantity");
        //frmvalidator.addValidation("soiledwaste","req","please enter Soiled Waste per day Quantity");
        //frmvalidator.addValidation("solidwaste","req","please enter Solid Waste per day Quantity");
        //frmvalidator.addValidation("liquidwaste","req","please enter Liquid Waste per day Quantity");
        //frmvalidator.addValidation("ash","req","please enter Incineration Ash per day Quantity");
        //frmvalidator.addValidation("chemicalwaste","req","please enter Chemical Waste per day Quantity");
        //frmvalidator.addValidation("total1","req","please enter Total Quantity handled Per day Quantity");


    }

    select1();
    hidediv();
</script>

</body>
</html>


