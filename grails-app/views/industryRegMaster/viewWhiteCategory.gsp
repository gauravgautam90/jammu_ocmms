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
                            
                            <%
                              System.out.println("industryRegMasterInstance------ongsp---"+industryRegMasterInstance)
                              System.out.println("whiteCateInt------ongsp---"+whiteCateInt)
                            %>
                            
                            <%
            				
            				def photoLatAndLong=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile where applicationId=? and typeOfFile='Photograph showing Latitude and Longitude' order by id desc",[whiteCateInt])
            				System.out.println("photoLatAndLong "+photoLatAndLong);
            				def dicRegistration=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile where applicationId=? and typeOfFile='DIC Registration' order by id desc",[whiteCateInt])
            				System.out.println("dicRegistration "+dicRegistration);
            				def panCard=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile where applicationId=? and typeOfFile='Pan Card' order by id desc",[whiteCateInt])
            		       	System.out.println("panCard "+panCard);
            				def detProjectReport=WhiteCategoryIntergrationFile.find("from WhiteCategoryIntergrationFile where applicationId=? and typeOfFile='Details Project Report' order by id desc",[whiteCateInt])
            		       	System.out.println("detProjectReport "+detProjectReport);
            				
            				
            				
            				
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
                                                        <%if(whiteCateInt.completionStatus == true){%>
                                                            <tr>
                                                                <td align="left"   valign="top" class="headngblue">
                                                                    %{--<a href="<%=request.getContextPath()%>/industryRegMaster/viewFormPdf?appliLoc=<%=whiteCateInt?.id%>"><span class="headngblue">Download Form</span></a>--}%
                                                                    <a href="<%=request.getContextPath()%>/industryRegMaster/generateViewAcknowledgement?appliLoc=<%=whiteCateInt?.id%>&intimationFor=acknowledgement"><span class="headngblue">Download Acknowledgement</span></a>
                                                                </td>
                                                                <td align="right"   valign="top" class="headngblue">
                                                                  %{--<a href="<%=request.getContextPath()%>/industryRegMaster/viewACKNOWLEDGEMENTPdf?appliLoc=<%=whiteCateInt?.id%>"><span class="headngblue">Download CERTIFICATE</span></a>--}%
                                                                </td>
                                                            </tr>
                                                       <%}%>
                                                    </table>
                                                    <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="">
                                                        <tr >
                                                            <td>
                                                                <div  class="hcfheader" >Integration</div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <table width="100%"  border="1" align="center" cellpadding="2" cellspacing="1" class="" style="">
                                                       
                                                        
                                                      <!--  <tr  style="background-color: #FFFAFA;">
                                                            <td width="50%" class="srno" >Raw Materials used</td>
                                                            <td width="50%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popRawMaterialDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                         </tr> -->
                                                         <!--    <tr  style="background-color: #F5FAFA;">
                                                            <td width="50%" class="srno" >Source of Water</td>
                                                            <td width="50%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popProductDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                        </tr>   -->
                                                        <!--     <tr  style="background-color: #FFFAFA;">
                                                        	<td width="50%" class="srno" >Water Consumption (Kl/per day)</td>
                                                        	<td width="50%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popSourceOfWaterView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                       </tr>   -->
                                                       <!--      <tr  style="background-color: #F5FAFA;">
                                                    		<td width="50%" class="srno" >Water Consumption Details (KLD)</td>
                                                    		<td width="50%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popWaterConsumptionDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                            </tr>  -->
                                                            <!--   	<tr  style="background-color: #FFFAFA;">
                                                			<td width="50%" class="srno" >Domestic Waste Water generation <br><span style="font-style: oblique;font-size: 10px;;">(Industrial waste water generation / disposal in not allowed for white category units)</span></td>
                                                			<td width="50%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDomesticWasteWaterView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                		</tr>    -->
                                                		  <!--    	<tr  style="background-color: #F5FAFA;">
                                                			<td width="50%" class="srno" >DG set Details<br><span style="font-style: oblique;font-size: 10px;">(No other source of air pollution is allowed to be installed for white category units)</span></td>
                                                            <td width="20%" class="dataView" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/industryRegMaster/popDGSetDetailsView/<%=whiteCateInt.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
                                                		</tr>     -->
                                                        
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
                                                        <td width="60%" class="headngblue" colspan="3">
                                                        <%if(photoLatAndLong){%>
                                         				<g:link controller="industryRegMaster" action="downLoadUploadedDoc"  id="${photoLatAndLong.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
                                         			<%}%></td>
                                                  </tr>
                                                  
                                                  
                                                  <tr style="background-color: #F5FAFA;">
                                                      <td width="40%" class="srno" >Line of Activity:<span style="color:red">*</span></td>
                                                      <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.industryType?.industryType}</td>
                                                  </tr>
                                                
                                                <!--  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Serial No. of White Category as listed in UCM 2016 of CPCB/JKPCC:</td>
                                                    
                                                     <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.serialNo}</td>
                                                  
                                                 
                                                  </tr>  -->
                                                  
                                                  <tr style="background-color: #F5FAFA;">
                                                  <td width="40%" class="srno" >Category of unit as per UCM of CPCB/JKPCC:<span style="color:red"></span></td>
                                                  <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.category?.name}</td>
                                              </tr>
                                              
                                              
                                              <tr style="background-color: #F5FAFA;">
                                              <td width="40%" class="srno" >Products to be manufactured as per DPR:<span style="color:red">*</span></td>
                                              <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.product}</td>
                                              </tr>
                                              
                                              <tr style="background-color: #F5FAFA;">
                                              <td width="40%" class="srno" >Quantity of Manufacturing Products as per DPR:<span style="color:red">*</span></td>
                                              <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.quantity}</td>
                                              </tr>
                                              
                                              <tr style="background-color: #F5FAFA;">
                                              <td width="40%" class="srno" >Uploaded Detailed Project Report:<span style="color:red">*</span></td>
                                              <td width="60%" align="left"  class="headngblue">
                                          	<%if(detProjectReport){%>
                             				<g:link controller="industryRegMaster" action="downLoadUploadedDoc"  id="${detProjectReport.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
                             			<%}%>
                                              </td>
                                           </tr>
                                              
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >DIC Registration / UDYAM Registration:<span style="color:red">*</span></td>
                                                     <td width="60%" align="left"  class="headngblue">
                                                 	<%if(dicRegistration){%>
                                    				<g:link controller="industryRegMaster" action="downLoadUploadedDoc"  id="${dicRegistration.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
                                    			<%}%>
                                                     </td>
                                                  </tr>
                                                  
                                                  <tr style="background-color: #F5FAFA;">
                                                  <td width="40%" class="srno" >Date of Commencement of the Industry/unit/establishment: <span style="color:red">*</span></td>
                                                  <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.commMonth},&nbsp;${industryRegMasterInstance?.dateOfComm}</td>
                                               </tr>
                                                
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >PAN Card of Applicant:</td>
                                                     <td width="60%" class="headngblue" colspan="3">
                                                     <%if(panCard){%>
                                     				<g:link controller="industryRegMaster" action="downLoadUploadedDoc"  id="${panCard.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
                                     			<%}%></td>
                                                  </tr>
                                                 
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Capital Investment in Rs. (Plant and Machinery):<span style="color:red">*</span></td>
                                                     <td  align="left" bgcolor="#E8F6F9" class="headngblue"><span>${industryRegMasterInstance?.indCapInvt}</span> </td>
                                                  </tr>
                                                     
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Aadhar No. of Applicant<span style="color:red">*</span></td>                                                     
                                                     <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.aadharNo}</td>
                                                  </tr>
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >No. of workers: <span style="color:red">*</span></td>
                                                     <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.noOfWorkers}</td>
                                                  </tr>
                                                  <tr style="background-color: #F5FAFA;">
                                                  <td width="40%" class="srno" >Electricity load<span style="color:red"></span></td>
                                                  <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.electricityLoad}</td>
                                              
                                               </tr>
                                                
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Pollution Control Measures / Green initiative / Plantation / Water harvesting / any
                                                     other:</td>
                                                     <td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue">${whiteCateInt?.pollutionMeasures}</td>
                                                  </tr>
                                                    <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Mobile No.:<span style="color:red">*</span></td>
                                                     <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indPhoneNo}</td>
                                                  </tr>
                                                  <tr style="background-color: #F5FAFA;">
                                                     <td width="40%" class="srno" >Email: <span style="color:red">*</span></td>
                                                     <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indEmail}</td>
                                                  </tr>

                                                  <tr style="background-color: #F5FAFA;">
                                                  
                                                  <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;">  SELF CERTIFICATION / UNDERTAKING </span>
                                                                                               
                                                  </tr>
                                                		   <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div>
                                                                That there is / will be no trade effluent generation and discharge from the
                                                                aforementioned Industry / Unit / Establishment and not required to install ETP /
                                                                Waste Water Treatment system.
                                                                </div></td>
                                                            </tr>   
                                                            
                                                                 <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div>
                                                                That the Industry/ Unit/ Establishment does not/ will not possess any boiler, furnace
                                                                and does not/ will not carry any activity leading to the change of the White
                                                                categorization of aforementioned Industry/ Unit/ Establishment
                                                                </div></td>
                                                            </tr>   
                                                            
                                                                <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div>
                                                                (i) That proposed / installed DG Set is / will be having integral acoustic enclosure/
                                                                acoustic treated room to meet the prescribed norms under the Environment
                                                                (Protection) Rules 1986, as amended to date for Diesel Generation and have 
                                                                shall provide adequate stack height for the DG Set as per the prescribed norms</br></br>
                                                                (ii) That used oil generated from DG set(s)/ units shall be disposed only through the
                                                                recycler of used oil authorized by State Pollution Control Board/ Central
                                                                Pollution Control Board. </br>
                                                                    </div></td>
                                                            </tr>    
                                                                   <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=""><div>
                                                                That provisions of Water Act, 1974, Air Act, 1981, Environment (Protection) Act
                                                                1986 and Rules made there under, as amended to date, shall be complied
                                                                    </div></td>
                                                            </tr>  
                                                                   <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";"><div>
                                                              That in case of any change in the process(es) or activity(ies) leading to change of the
                                                              categorization of the activities from White Category to some other Category,
                                                              Application for Consent to Establish &amp; Consent to Operate under the Air and Water
                                                              Act and other applicable Rules under the Environment (Protection) Act 1986, as
                                                              amended to date, shall be sought from JKPCC and the activity(ies) shall not be
                                                              carried out without taking prior Consent from JKPCC.</br>
                                                              Failure to seek the consent in case of activity does not fall under white category,
                                                              shall attract action under environmental laws.
                                                                    </div></td>
                                                            </tr> 
                                                            
                                                            <tr style="background-color: #F5FAFA;">
                                                            
                                                            <td width="100%" class="srno" colspan="4" style=";"><div><span style="color: red; font-weight:  bold;">  Self Declaration / Compliance  </span>
                                                                                                         
                                                               </tr>
                                                                        <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                                <td width="100%" class="srno" colspan="4" style=";">
                                                                I, hereby verify and declare that what has been stated above is true and correct to
                                                                the best of my knowledge and nothing has been concealed therefrom. I hold myself
                                                                liable for perjury, falsehood, misrepresentation and / or omission and / or
                                                                falsification or act of dishonesty from any fraudulent, fake or tampered documents
                                                                that have been submitted
                                                                    </div></td>
                                                            </tr>   
                                                            
                                                            </tr>   
                                                            <tr style="background-color: #F5FAFA;font-style: oblique;">
                                                    <td width="100%" class="srno" colspan="4" style=";">
                                                    That I hereby agree to abide by all the conditions mentioned in the self declaration /
                                                    certification / undertaking.
                                                        </div></td>
                                                </tr> 
                                                		
                                            	     </table>

                                                    <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="">
                                                        <tr >
                                                            <td>
                                                                <div  class="hcfheader1" >Integration</div><br><br>
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
<script language="JavaScript" type="text/javascript">
    check1();
</script>
</body>
</html>


