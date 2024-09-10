<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">

<!----------------------added for audit issue--resolved------------------>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="X-Frame-Options" content="deny">

    <style id="antiClickjack">body{display:none !important;}</style>

    <script type="text/javascript">
        if (self === top) {
            var antiClickjack = document.getElementById("antiClickjack");
            antiClickjack.parentNode.removeChild(antiClickjack);
        } else {
            top.location = self.location;
        }
    </script>
    <!-------------------------end------------------------------>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
    <title>Application For Authorization</title>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
    <link rel="stylesheet" type="text/css"href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'bootstrap-3-3-7/css',file:'bootstrap.min.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'bootstrap-3-3-7',file:'custom.css')}" />

    <g:javascript library="prototype" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />

    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>




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
        background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}');
        padding-left: 23px;
        padding-right: 20px;
        padding-top: 5px;
        padding-bottom: 5px;
    }

    .qwe123:hover {
        background-image: url('${createLinkTo(dir:' images2/ gif ',file:' gray_bg.gif ')}');
    }

    .blue {
        background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_gray.gif ')}');
        padding-left: 30px;
        padding-right: 27px;
        padding-top: 5px;
        padding-bottom: 7px;
    }

    .blue:hover {
        background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}');
    }
    -->

    input[type=text], select,file {

        padding: 6px 8px;
        margin: 2px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .hcfheader{
        border-top-right-radius: 8px;
        border-top-left-radius: 8px;
        border: 1px;
        padding: 5px;
        background-color: #2471A3;
        text-align: center;font-size: 12px; font-weight: bold;color: white;
    }
    .hcfheader1{
        border-bottom-right-radius: 8px;
        border-bottom-left-radius: 8px;
        border: 1px;
        padding: 5px;
        background-color: #2471A3;
        text-align: center;font-size: 12px; font-weight: bold;color: #2471A3;
    }
    .srno{
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-size: 12px;
        font-weight: bold;
        padding: 3px;
        background-color: rgb(168, 218, 243);
        color: #1F6FB7;
    }
    .srno1 {
        padding: 5px;
        color: #08486b;
        font-weight: bold;
    }
    .dataView{
        padding: 5px;
        font-weight: normal;
    }
    </style>


    <script type="text/javascript">
        anylinkmenu.init("menuanchorclass")
    </script>

</head>

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
                    <!-- code for menuIndustryHorizontal-->
                    <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
                </td>
            </tr>
            <tr>
                <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                            <!-- code for menuSpcbUser-->
                            <g:include controller="userMaster" action="showSpcbIndustryMenu"/>
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
                                IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
                                String indname=ind.indName;

                                java.util.Date dateSCR = new java.util.Date();
                                int  year=dateSCR.getYear();
                                if (year < 1000)
                                    year+=1900;
                                int date=dateSCR.getDate();
                                int month=(dateSCR.getMonth()) + 1;


                            %>
                            <tr>
                                <td height="24" bgcolor="#2471A3">

                                    <table width="100%" bgcolor="#2471A3">
                                        <tr >
                                            <td class="top-lnks">Welcome <%=indname %></td>
                                            <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                            <tr>
                                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr><!-- Div area for errors-->
                                        <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle">&nbsp;</div></td>
                                    </tr>

                                    <tr>
                                        <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td width="33" align="left" valign="top">&nbsp;</td>
                                                <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >



                                                    <br/>
                                                    <MARQUEE WIDTH=100% BEHAVIOR=left onmouseover = "this.stop()" onmouseout = "this.start()">

                                                        <FONT SIZE="3" FACE="bodonimt" COLOR=red> If you want to edit some data click on Industry Profile</font></MARQUEE>

                                                    <div align="center" style="border":1px solid gray; width:750px; margin-bottom: 1em; padding: 10px" >

                                                    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
                                                        <div id="t" align="center" >


                                                            <g:if test="${flash.message}">
                                                                <div class="style1">
                                                                    <span class="error">${flash.message}</span><br/>
                                                                </div>
                                                            </g:if>

                                                        </div>

                                                    </table>
                                                    <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="">
                                                        <tr >
                                                            <td>
                                                                <div  class="hcfheader" >Intimation (for White Category)</div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <table width="100%"  border="1" align="center" cellpadding="2" cellspacing="1" class="" style="">
                                                        <form action="doSaveWhiteCategory" method="post" name="whiteCateroy" enctype="multipart/form-data">
                                                     <!--   <input type="hidden" class="txt4" id="" size="30" name="noOfWorkers" value=""/> -->

                                                      <tr style="background-color: #F5FAFA;">
                                                            <td width="40%" class="srno" >Name of the Proprietor / Partner:<span style="color:red">*</span></td>
                                                            <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.occName}</td>
                                                      </tr>
                                                      <tr style="background-color: #F5FAFA;">
                                                        	<td width="40%" class="srno" >Name and Address of the Industry:<span style="color:red">*</span></td>
                                                        	
                                                        	<td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indName},&nbsp;${industryRegMasterInstance?.indAddress}</td>
                                                      </tr>
                                                      
                                      
                                                      <tr style="background-color: #F5FAFA;">
                                                           <td width="40%" class="srno" >Photograph showing Latitude and Longitude of the premises of
                                                           Industry/unit/establishment:<span style="color:red">*</span></td>
                                                           <td width="60%" class="dataView" colspan="3"><input type="file"  name="photoLatAndLong" id="photoLatAndLong" /><br><span class="sidetxt">*Upload  Document</span><br></td>
                                                     </tr>
                                                     
                                                     
                                                     <tr style="background-color: #F5FAFA;">
                                                         <td width="40%" class="srno" >Line of Activity:<span style="color:red">*</span></td>
                                                         <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.industryType?.industryType}</td>
                                                     </tr>
                                                     
                                                     <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Category of unit as per UCM of CPCB/JKPCC:<span style="color:red"></span></td>
                                                     <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.category?.name}</td>
                                                 </tr>
                                                 
                                                 <tr style="background-color: #F5FAFA;">
                                                 <td width="40%" class="srno" >Products to be manufactured as per DPR:<span style="color:red">*</span></td>
                                                 <td width="60%" class="dataView" colspan="3"><input type="text" class="txt4" id="product" size="30" name="product" value=""/></td>
                                                 </tr>
                                               
                                                 <tr style="background-color: #F5FAFA;">
                                                 <td width="40%" class="srno" >Quantity of Manufacturing Products as per DPR:<span style="color:red">*</span></td>
                                                 <td width="60%" class="dataView" colspan="3"><input type="text" class="txt4" id="quantity" size="30" name="quantity" value=""/></td>
                                                 </tr>
                                                 
                                                 <tr style="background-color: #F5FAFA;">
                                                 <td width="40%" class="srno" >Upload Detailed Project Report:<span style="color:red">*</span></td>
                                                 <td width="60%" class="dataView" colspan="3"><input type="file"  name="detProjectReport" id="detProjectReport" /><br><span class="sidetxt">*Upload  Document</span><br></td>
                                              </tr>
                                            
                                                   
                                                   <!--  <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >Serial No. of White Category as listed in UCM 2016 of CPCB/JKPCC:</td>
                                                        <td width="60%" class="dataView" colspan="3"><input type="hidden" class="txt4" id="serialNo" size="30" name="serialNo" value=""/></td>
                                                     </tr>  -->
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >DIC Registration / UDYAM Registration:<span style="color:red">*</span></td>
                                                        <td width="60%" class="dataView" colspan="3"><input type="file"  name="dicRegistration" id="dicRegistration" /><br><span class="sidetxt">*Upload  Document</span><br></td>
                                                     </tr>
                                                     
                                                     <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Date of Commencement of the Industry/unit/establishment: <span style="color:red">*</span></td>
                                                     <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.commMonth},&nbsp;${industryRegMasterInstance?.dateOfComm}</td>
                                                  </tr>
                                                   
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >PAN Card of Applicant:</td>
                                                        <td width="60%" class="dataView" colspan="3"><input type="file"  name="panCard" id="panCard" /><br><span class="sidetxt">*Upload  Document</span><br></td>
                                                     </tr>
                                                     
                                                    
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >Capital Investment in Rs. (Plant and Machinery):<span style="color:red">*</span></td>
                                                        <td  align="left" bgcolor="#E8F6F9" class="headngblue"><span>${industryRegMasterInstance?.indCapInvt}</span> </td>
                                                     </tr>
                                                        
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >Aadhar No. of Applicant<span style="color:red">*</span></td>
                                                        <td width="60%" class="dataView" colspan="3"><input type="text" class="txt4" id="aadharNo" size="30" name="aadharNo" value=""/></td>
                                                    
                                                     </tr>
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >No. of workers: <span style="color:red">*</span></td>
                                                        <td width="60%" class="dataView" colspan="3"><input type="text" class="txt4" id="noOfWorkers" size="30" name="noOfWorkers" value=""/></td>
                                                     </tr>
                                                     
                                                     <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Electricity load<span style="color:red"></span></td>
                                                     <td width="60%" class="dataView" colspan="3"><input type="text" class="txt4" id="electricityLoad" size="30" name="electricityLoad" value=""/></td>
                                                 
                                                  </tr>
                                                    
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >Pollution Control Measures / Green initiative / Plantation / Water harvesting / any
                                                        other:</td>
                                                        <td width="60%" class="dataView" colspan="3"><input type="text" class="txt4" id="pollutionMeasures" size="30" name="pollutionMeasures" value=""/></td>
                                                     </tr>
                                                       <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >Mobile No.:<span style="color:red">*</span></td>
                                                        <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indPhoneNo}</td>
                                                     </tr>
                                                     <tr style="background-color: #F5FAFA;">
                                                        <td width="40%" class="srno" >Email: <span style="color:red">*</span></td>
                                                        <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indEmail}</td>
                                                     </tr>


                
                                
                                                            <!--    <tr  style="background-color: #FFFAFA;">
                                                                <td width="40%" class="srno" >Raw Materials used</td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popRawMaterialDetailsAdd/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popRawMaterialDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popRawMaterialDetailsEdit/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>

                                                            </tr> -->
                                                            <!--   <tr  style="background-color: #F5FAFA;">
                                                                <td width="40%" class="srno" >Products</td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popProductDetailsAdd/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popProductDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popProductDetailsEdit/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
                                                            </tr>-->
                                                            <!--  <tr  style="background-color: #FFFAFA;">
                                                                <td width="40%" class="srno" >Source of Water</td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popSourceOfWaterAdd/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popSourceOfWaterView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popSourceOfWaterEdit/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
                                                            </tr> -->
                                                            <!--   <tr  style="background-color: #F5FAFA;">
                                                                <td width="40%" class="srno" >Water Consumption (Kl/per day)</td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popWaterConsumptionDetailsAdd/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popWaterConsumptionDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popWaterConsumptionDetailsEdit/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
                                                            </tr> -->
                                                            <!--   <tr  style="background-color: #FFFAFA;">
                                                                <td width="40%" class="srno" >Domestic Waste Water generation <br><span style="font-style: oblique;font-size: 10px;;">(Industrial waste water generation / disposal in not allowed for white category units)</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDomesticWasteWaterAdd/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDomesticWasteWaterView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDomesticWasteWaterEdit/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
                                                            </tr> -->
                                                            <!--   <tr  style="background-color: #F5FAFA;">
                                                                <td width="40%" class="srno" >DG set Details<br><span style="font-style: oblique;font-size: 10px;">(No other source of air pollution is allowed to be installed for white category units)</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDGSetDetailsAdd/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDGSetDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                                <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDGSetDetailsEdit/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
                                                            </tr> -->
                                                            
                                                            <tr style="background-color: #F5FAFA;">
                                                            
                                                            <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;">  SELF CERTIFICATION / UNDERTAKING </span>
                                                                                                         
                                                               </tr>
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                                That there is / will be no trade effluent generation and discharge from the
                                                                aforementioned Industry / Unit / Establishment and not required to install ETP / Waste Water Treatment system.
                                                                    &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking1" id="undertaking1"/></div></div></td>
                                                            </tr> 
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                                That the Industry/ Unit/ Establishment does not/ will not possess any boiler, furnace  and does not/ will not carry any activity leading to the change of the White categorization of aforementioned Industry/ Unit/ Establishment
                                                                    &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking2" id="undertaking2"/></div></div></td>
                                                            </tr> 
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                                (i) That proposed / installed DG Set is / will be having integral acoustic enclosure/ acoustic treated room to meet the prescribed norms under the Environment (Protection) Rules 1986, as amended to date for Diesel Generation and have /shall provide adequate stack height for the DG Set as per the prescribed norms <br>
                                                                (ii) That used oil generated from DG set(s)/ units shall be disposed only through the recycler of used oil authorized by State Pollution Control Board/ Central Pollution Control Board. (For DG Sets only)
                                                                    &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking3" id="undertaking3"/></div></div></td>
                                                            </tr>  
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=""><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                                That provisions of Water Act, 1974, Air Act, 1981, Environment (Protection) Act 1986 and Rules made there under, as amended to date, shall be complied &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking4" id="undertaking4"/></div></div></td>
                                                            </tr>  
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                               That in case of any change in the process(es) or activity(ies) leading to change of the
                                                               categorization of the activities from White Category to some other Category, Application for Consent to Establish &amp; Consent to Operate under the Air and Water Act and other applicable Rules under the Environment (Protection) Act 1986, as amended to date, shall be sought from JKPCC and the activity(ies) shall not be carried out without taking prior Consent from JKPCC. <br> Failure to seek the consent in case of activity does not fall under white category,
                                                               shall attract action under environmental laws.
                                                                    &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking5" id="undertaking5"/></div></div></td>
                                                            </tr>  
                                                            
                                                            <tr style="background-color: #F5FAFA;">
                                                            <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> Self Declaration / Compliance </span>
                                                                                                         
                                                               </tr>
                                                            
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                            <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                            I, hereby verify and declare that what has been stated above is true and correct to
                                                            the best of my knowledge and nothing has been concealed therefrom. I hold myself
                                                            liable for perjury, falsehood, misrepresentation and / or omission and / or
                                                            falsification or act of dishonesty from any fraudulent, fake or tampered documents
                                                            that have been submitted
                                                                &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking6" id="undertaking6"/></div></div></td>
                                                        </tr>
                                                        
                                                     
                                                  
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;"> (*) </span>
                                                                That I hereby agree to abide by all the conditions mentioned in the self declaration /
                                                                certification / undertaking.
                                                                    &nbsp;<div style="text-align: right;"><input type="checkbox" class="txt4" id="" size="30" name="undertaking" value="undertaking7" id="undertaking7"/></div></div></td>
                                                            </tr>  





                                                            <tr  style="background-color: #F5FFFA;" align="center">
                                                                <td width="40%" class="srno" style="color: red;">Do You Want To Save The Application as</td>
                                                                <td width="60%" class="dataView" colspan="3">
                                                                    <input type="radio" class="txt4" id="completionStatus" size="30" name="completionStatus" value="Completed" onclick="return printChecked();"/><span> Completed </span>&nbsp;&nbsp;&nbsp;
                                                                    <input type="radio" class="txt4" id="completionStatus" size="30" name="completionStatus" value="In-Progress" checked/><span> In-Progress </span>
                                                                </td>
                                                            </tr>

                                                            <tr  style="background-color: #F5FFFA;" align="center">

                                                                <input type="hidden" class="txt4" id="" size="30" name="id" value="${whiteCateInt.id}"/>
                                                                <td width="100%" class="dataView" colspan="4" style="text-align: left;">All Asterisk <span style="color: red; font-weight:  bold;">(*)</span> Marks Are Required. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                    <input type="submit" class="btn btn-primary btn-sm" id="" size="30" name="save" value="Submit"  /></td>

                                                            </tr>

                                                        </form>
                                                    </table>

                                                    <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="">
                                                        <tr >
                                                            <td>
                                                                <div  class="hcfheader1" >Intimation (for White Category)</div><br><br>
                                                            </td>
                                                        </tr>
                                                    </table>





                                                </td>
                                            </tr>

                                        </table></td>
                                    </tr>

                                </table></td>
                            </tr>
                        </table></td>
                    </tr>
                    <!-- code for spcb Footer -->

                </table></td>
                <td><g:include controller="userMaster" action="showSpcbFooter"/></td>
            </tr>
        </table>
        
        <script type="text/javascript">
        
        var frmvalidator  = new Validator("whiteCateroy");
           frmvalidator.addValidation("serialNo","req","Please ennter Serial No. of White Category as listed in UCM 2016 of CPCB/JKPCC.");
           frmvalidator.addValidation("aadharNo","req","Please ennter Aadhar No. of Applicant");
    //       frmvalidator.addValidation("noOfWorkers","req","Please ennter the No. of workers"); 
           frmvalidator.addValidation("pollutionMeasures","req","Please ennter Pollution Control Measures / Green initiative / Plantation / Water harvesting / any other");
           frmvalidator.addValidation("photoLatAndLong","req","Please attach Photograph showing Latitude and Longitude of the premises of Industry/unit/establishment");
           frmvalidator.addValidation("panCard","req","Please attach Copy of Pan Card");
           frmvalidator.addValidation("dicRegistration","req","Please attach DIC Registration / UDYAM Registration");  
    //       frmvalidator.addValidation("product","req","Please enter Products to be manufactured as per DPR");
      //    frmvalidator.addValidation("quantity","req","Please enter Quantity of Manufacturing Products as per DPR");

        </script>
        
            <script language="JavaScript" type="text/javascript">
                check1();
            </script>
            
            
            <script language="JavaScript" type="text/javascript">
            function printChecked(){
				var items=document.getElementsByName('undertaking');
				var selectedItems=false;
				var tem1=false;
				var tem2=false;
				var tem3=false;
				var tem4=false;
				var tem5=false;
				var tem6=false;
				var tem7=false;
				for(var i=0; i<items.length; i++){
					if(items[i].type=='checkbox' && items[i].checked==false){
						//selectedItems+=items[i].value+"\n";
						if(items[i].value=="undertaking1")
							tem1=true;
						if(items[i].value=="undertaking2")
							tem2=true;
						if(items[i].value=="undertaking3")
							tem3=true;
						if(items[i].value=="undertaking4")
							tem4=true;
						if(items[i].value=="undertaking5")
							tem5=true;
						if(items[i].value=="undertaking6")
							tem6=true;
						if(items[i].value=="undertaking7")
							tem7=true;
					}
				}
				if(tem1 || tem2 || tem3 || tem4 ||  tem5 || tem6 || tem7){
					alert("All Asterisk (*) Marks Are Required!!!");
					return false;
				}
				
			}
            	  
            
           </script> 
           
           <script type="text/javascript">
           
            
            function Checkfiles2(){
            	
               //	alert("INSDE ext 333");
                var frm = document.forms["whiteCateroy"];


                var fupp = document.getElementsByName('panCard');

                var fup12 = fupp[0];


                var fileName = fup12.value;

                var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



                //alert("ext 333");

                if(ext != "pdf" && ext != "jpg" && ext != "bmp" && fileName !="" ){
                alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
                return false;
                }
                else {
                return true;
                }
                }
            </script>
            <script type="text/javascript">
            function Checkfiles1(){
         	   
              //	alert("INSDE ext 111");
               var frm = document.forms["whiteCateroy"];


               var fupp = document.getElementsByName('dicRegistration');

               var fup12 = fupp[0];


               var fileName = fup12.value;

               var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



               //alert("ext 333");

               if(ext != "pdf" && ext != "jpg" && ext != "bmp" && fileName !="" ){
               alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
               return false;
               }
               else {
               return true;
               }
               }
            
            
         // frmvalidator.setAddnlValidationFunction("Checkfiles"); 
          // frmvalidator.setAddnlValidationFunction("Checkfiles1"); 
           frmvalidator.setAddnlValidationFunction("Checkfiles2");
           

            </script>
            

        </body>
</html>


