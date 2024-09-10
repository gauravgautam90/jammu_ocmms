<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
</head>
<body>
<table width="760" border="0" align="center" cellpadding="0"
cellspacing="0" id="countrytabs">
<tr valign="middle">
<td width="90%" align="left">


<%
String appFor1 = indApplicationDetailsInstance.applicationFor ;

%>

<ol id="toc">
<li><a href="#country1"><span>General</span></a></li>
<li><a href="#country7"><span>Enclosures</span></a></li>
<%if(appFor1.equals("both")) {%>
<li><a href="#country9"><span>Other</span></a></li>
<li><a href="#country2"><span>Product/Cost</span></a></li>
<li><a href="#country4"
title="Water Emission/Discharge"><span>W Emiss./Disch.</span></a></li>

<%}
						def a4 = indApplicationDetailsInstance.indUser.category.id
			
				 if (((a4==1)||(a4==2))&& appFor1.equals("both")){ %>
<li><a href="#country10"><span>HWM</span></a></li>
<% }
						 if(appFor.equals("both")) {
						  %>
<li><a href="#country6"><span>Air
                                                            Emission</span></a></li>

<%}%>
<li><a href="#country3"><span>Fee</span></a></li>
<%if((appFor1.equals("stonecrusher")) || (appFor1.equals("hotmixplants")) || (appFor1.equals("stonecrusher and hotmixplants"))) {%>
<li><a href="#country2"><span>Product</span></a></li>
<li><a href="#country12"><span>Stone Crusher</span></a></li>
<%}%>
<%if(appFor1.equals("dgset")) {%>
<li><a href="#country13"><span>D.G.Set</span></a></li>
<%}%>
<%if(appFor1.equals("brickkilns")) {%>
<li><a href="#country2"><span>Product</span></a></li>
<li><a href="#country14"><span>Brick Kilns</span></a></li>
<%}%>
<%if(appFor1.equals("hotel")) {%>
<li><a href="#country15"><span>Hotel</span></a></li>
<%}%>
</ol>

</td>
<td align="left">

<%if(indApplicationDetailsInstance.completionStatus != "pending"){ %>
<% if(indApplicationDetailsInstance.applicationFor.equals("air")) { %>

<font size="1" face="Verdana">Print Form </font>
<g:def var="versionVal" value="air"/> <g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink"><u>Air</u></span></g:link>
<!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FormAir&docType=pdf"><span class="innerlink"><u>Air</u></span></a> -->
<% }else if(indApplicationDetailsInstance.applicationFor.equals("water")){%>
<font size="1" face="Verdana">Print Form </font>
<g:def var="versionVal1" value="water"/> <g:def var="fooVar1" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar1,verValue:versionVal1]"><span class="innerlink"><u>Water</u></span></g:link>
<!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FromWaterPdf&docType=pdf"><span class="innerlink"><span class="innerlink"><u>Water</u></span></span></a> -->
<%}else{ %>
<font size="1" face="Verdana">
<!--		Print(<g:def var="versionVal" value="air"/> <g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink"><u>Air</u></span></g:link>| --> Print ( <g:def var="versionVal1" value="water"/> <g:def var="fooVar1" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdf" controller="indApplicationDetails" params="[appliLoc:fooVar1,verValue:versionVal1]"><span class="innerlink"><u>Form</u></span></g:link> <!-- <a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FormAir&docType=pdf"><span class="innerlink"><u>Air</u> </span></a>|<a href="<%=request.getContextPath()%>/indApplicationDetails/viewFile?appliLoc=<%=indApplicationDetailsInstance.id%>&docName=FormWater&docType=pdf"><span class="innerlink"><u>Water</u></span></a> -->)</font>
<%}
}%>


</td>

</tr>
</table>
		
		
<div class="content" id="country1">
<table width="100%" border="0" align="center" cellpadding="0"
cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
style="border-collapse: collapse;">
<tr>
<td bgcolor="#FFFFFF">



<table width="100%" border="0" align="left"
cellpadding="2" cellspacing="1" class="tblbdr">

<tr bgcolor="#D1D1D1">
<td colspan="2" align="center" valign="middle"
class="headngblue">General Details</td>
</tr>

<tr>
<td width="35%" align="left" valign="middle"
bgcolor="#A8DAF3" class="headngblue">Consent
                                                                    Type<span style="color:red">*</span>:</td>
<td width="65%" align="left" bgcolor="#E8F6F9"
class="headngblue">${fieldValue(bean:indApplicationDetailsInstance,
field:'applicationType')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Consent For<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indApplicationDetailsInstance,
field:'applicationFor')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Application For<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:indApplicationDetailsInstance,
field:'certificateFor')}</td>
</tr>

<tr bgcolor="#D1D1D1">
<td colspan="2" align="center" valign="middle"
class="headngblue">Industry/Hotel Information</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry/Hotel Name<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.indName}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Category:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.category}</td>
</tr>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Scale of Industry:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.industryScale}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry Type:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.industryType}</td>
</tr>


<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Other Industry Type Detail:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${industryRegMasterInstance?.indTypeOther}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry Status:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indStatus')}</td>
</tr>
<%if(appFor1.equals("hotel")) {%>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Hotel Area:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'hotelArea')}</td>
</tr>
<%}%>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Commisioning Year:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${industryRegMasterInstance?.dateOfComm}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Industry Registration/ License/DIC No<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indRegNum')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Total Capital Investment<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indCapInvt')} &nbsp;Lakhs</td>
</tr>
<!--
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Capital Investment of Land<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indCapInvt')} &nbsp;Lakhs</td>
</tr>
<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Capital Investment of Building<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">&nbsp;Lakhs</td>
</tr>
<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Investment:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue"> &nbsp;Lakhs</td>
</tr>-->

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Address<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indAddress')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Village/City:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indCity')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Pin:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'indPin')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">S.T.D. Code(Phone)<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indPhoneCode')}</td>
</tr>


<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Phone No<span style="color:red">*</span>:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indPhoneNo')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Fax Code :</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indFaxCode')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Fax No. :</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indFaxNo')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">E-Mail Address:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'indEmail')}</td>
</tr>

<tr bgcolor="#D1D1D1">
<td colspan="2" align="center" valign="middle"
class="headngblue">Occupiers Details</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Name:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occName')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Designation:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occDesignation')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Residential Address:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occAddress')}</td>
</tr>

<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3"
class="headngblue">Status Of Aplicant:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'statusOfAppl')}</td>
</tr>
<tr class="headngblue txt4" >

<td align="left" class="headngblue" bgcolor="#A8DAF3">Name of Directors/Partner/Proprietor with Contact Details :</td>

      <td align="left"class="headngblue1" bgcolor="#E8F6F9">${fieldValue(bean:industryRegMasterInstance,field:'nameAddressPartners')}</td>

      </tr>
     
      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Village/City:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occCity')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Pin:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occPin')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">S.T.D. Code(Phone)<span style="color:red">*</span>:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occPhoneCode')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Phone No<span style="color:red">*</span>:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occPhoneNo')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Fax Code :</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occFaxCode')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Fax No. :</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'occFaxNo')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Mobile No:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occMobile')}</td>
      </tr>

      <tr>
        <td align="left" valign="middle" bgcolor="#A8DAF3"
            class="headngblue">Email Address:</td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
${fieldValue(bean:industryRegMasterInstance,field:'occEmail')}</td>
      </tr>



      </table>





      </td>
      </tr>
      </table>




      <br />
      </div>

      <div class="content" id="country9">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">
              <table width="100%" border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td colspan="2" align="center" valign="middle" class="headngblue">Other Details</td>
                </tr>
                <%	
				 if ((a4==1)||(a4==2)){ %>
                <tr>
                  <td align="left" width="60%" valign="middle" bgcolor="#A8DAF3" class="headngblue">Equipments To Which Separate Meters Are Installed For Recording Consumption Of Electric Energy:</td>
                  <td align="center" width="40%" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'equipWithSepMeters')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Equipments Connected To D.G.Set:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'equipDGSet')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Tree Plantation/Green Belt Development(in hectares):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'treePlantDev')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details Of Schemes For Waste Minimization/Resource Recovery/Recycling Implementation:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'wasteMinDetail')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is Industry Comes Under Public Hearing:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'underPubHearing')}</td>
                </tr>
                <%	
				 } %>
                <tr>
                  <td align="left" width="60%" valign="middle" bgcolor="#A8DAF3" class="headngblue">Is Site Located Near River Bank/Water Bodies:</td>
                  <td align="center" width="40%" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'nearRiver')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.nearRiver=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name Of River/Water Body:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'riverName')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Distance From River Bank/Water Body:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'riverDist')}</td>
                </tr>
<%}%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Site Located Near Residential Colony:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'nearResidCol')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.nearResidCol=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Population Of Colony:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'colPopulation')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Location Of Colony:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'colLocation')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Distance:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'colDistance')}</td>
                </tr>
<%}%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Site Located Near Industrial Estate:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'nearIndEstate')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.nearIndEstate=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether Collection, Treatment & Disposal System Provided:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'disposalSysProv')}</td>
                </tr>
<% if(industryRegMasterInstance.disposalSysProv=="Yes"){%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Will Applicant Utilize The System:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'utilizeSys')}</td>
                </tr>
<% if(industryRegMasterInstance.utilizeSys=="No"){%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details Of Proposal:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'proposalDetails')}</td>
                </tr>
<%}%>
<%}%>
<%}%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Plot Area (in square meter):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'totalPlotArea')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Build-up Area (in square meter):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'plotArea')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Area used for Treated Sewage/Trade Effluent (in square meter):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'builtUpArea')}</td>
                </tr>
<%	
				 if ((a4==1)||(a4==2)){ %>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Project Cost (in Rs.):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'totalProjectCost')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Inv. Proposed on Pollution/Env. Protection (in %):</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'pollutionMonitoringCost')}</td>
                </tr>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are sewage & trade effluents mixed together ?:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'sewage')}</td>
                </tr>
<% if(industryRegMasterInstance!=null && industryRegMasterInstance.sewage=="Yes"){%>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">At which state ?:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'sewageState')}</td>
                </tr>

<%}%>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity of Treated Effluent :</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'treatedEffCapacity')}</td>
                </tr>
                <tr align="center" bgcolor="lightgrey" rowspan="2">
                  <td width="30%" align="center" valign="middle" colspan="2"
                      class="headngblue">Non-Hazardeous Solid Waste Details<span style="color:red"></span></td>

                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Non-Hazardous Solid Waste:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,field:'nonHwmProdName')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Area of Land:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'landArea')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capacity:</td>
                  <td align="center" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance, field:'prodCapacity')}</td>
                </tr>
<%	
				 } %>

              </table>
            </td>
          </tr>
        </table>

      </div>





      <div class="content" id="country2">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Product/Estimeted Cost Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td width="90%" align="center" valign="middle"
                      class="headngblue">Product Details</td>

                  <td width="10%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popProductDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>
 <%
				 	def a2 = indApplicationDetailsInstance.indUser.category.id
			
				 if(appFor.equals("both")&&((a2==1)||(a2==2))) 
				 {%>
                <tr>
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Estimeted Cost Details</td>

                  <td width="30%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEstimetedDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>
<%}%>
              </table>

            </td>
          </tr>
        </table>


        <br />
      </div>


      <div class="content" id="country3">

        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">
              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td colspan="2" align="center" valign="middle"
                      class="headngblue">Fee Details (Water
                                                                    Consumptions)</td>
                </tr>

                <tr>
                  <td width="60%" align="left" valign="middle"
                      bgcolor="#A8DAF3" class="headngblue">Category:</td>
                  <td width="40%" align="left" bgcolor="#E8F6F9"
                      class="headngblue">${fieldValue(bean:industryRegMasterInstance,
field:'category.name')}</td>
                </tr>

                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Capital Investment (In Lakhs):</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:industryRegMasterInstance,
field:'indCapInvt')}</td>
                </tr>

                    <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Number of Year<span style="color:red">*</span>:</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInstance,
field:'noOfYears')}</td>
                </tr>

<tr>

<td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Number of Additional Years<span style="color:red">*</span>:</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue">${fieldValue(bean:consentFeeMasterInstance,
field:'noOfYearsadditionalYears')}</td>
                </tr>


 <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Fee for First Year Applied(In Rupees)</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${fieldValue(bean:consentFeeMasterInstance,
field:'outstandingDueInd')}</td>
                </tr>

 <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Fee for Additional Year Applied(In Rupees)</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${fieldValue(bean:consentFeeMasterInstance,
field:'outstandingDueBrd')}</td>
                </tr>
                <tr>
                  <td align="left" valign="middle" bgcolor="#A8DAF3"
                      class="headngblue">Total Fee Applied(In Rupees)</td>
                  <td align="left" bgcolor="#E8F6F9" class="headngblue"><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/> ${fieldValue(bean:consentFeeMasterInstance,
field:'totalApplicableFee')}</td>
                </tr>





                <tr bgcolor="#D1D1D1">
                  <td colspan="2" align="center" valign="middle"
                      class="headngblue">Bank Details</td>
                </tr>

              <%
									
								def feesOnline = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
									
									
									def feesBank = FeeBankDetails.find("from FeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])
									
									
									def feesBankOnline = BankTransactionDetails.find("from BankTransactionDetails fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
									%>
											
             <tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1 ,resizable=yes');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>

<%if(feesBank) {%>
														
														
															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																	<td width="10%" class="headngblue" align="center">Bank Draft Details</td>
																		
																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
														
														<%if(feesBankOnline) {%>
															<tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																	<td width="10%" class="headngblue" align="center">Online Payment Details</td>
																		
																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popChallan/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View Challan </a></td>

																	</tr>
																</table>
																</td>
															</tr>

														<%}%>
												



              </table>


            </td>
          </tr>
        </table>



        <br />
      </div>


      <div class="content" id="country6">
<%if((indApplicationDetailsInstance.applicationFor).equals("air")||(indApplicationDetailsInstance.applicationFor).equals("both")) {%>
        <table width="100%" border="0" align="center"
               cellpadding="0" cellspacing="1" bgcolor="#A5CAF4"
               class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">


              <table id="22" width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Air Emission</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

<%
			
			def a1 = indApplicationDetailsInstance.indUser.category.id
			if(a1==4)
			{
			
			%>
			
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Boiler Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBoilerDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			  
			  
			  <tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Furnace Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFurnaceDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			 <tr>
                  <td align="center" valign="middle" class="headngblue">Miscellaneous Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popMiscellaneousView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
			
			
			
			<%}else{%>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Stack Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Flue Gas Emission Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFlueEmmisionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                  <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Air Miscellaneous Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirMiscDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
 <%}%>

              </table>
            </td>
          </tr>
        </table>

        <br />



<%}else{ %>
        <div class="headngblue" align="center">Not Applicable</div>
<% } %> <br />

      </div>


      <div class="content" id="country4">
<%if((indApplicationDetailsInstance.applicationFor).equals("water")||(indApplicationDetailsInstance.applicationFor).equals("both")) {%>
        <table width="100%" border="0" align="center"
               cellpadding="0" cellspacing="1" bgcolor="#A5CAF4"
               class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">


              <table id="22" width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Water Emission/Discharge</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

<%
			def a = indApplicationDetailsInstance.indUser.category.id
			if(a==4)
			{
			
			%>
<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Water Usage Detail</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterUsageDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Waste Water Discharge</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteDischargeView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
							  </tr>
							</table>
					</td>
			</tr>
   <tr  bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Solid Wastes Generation Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

			
			<%}
			
			else
			{
			%>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Source
                                                                    of Water, Use and Consumption Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Waste
                                                                    Water Treatment Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterTreatmentView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Waste
                                                                    Water Discharge</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteGenView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

             

<%}
			
			%>
              </table>
            </td>
          </tr>
        </table>

        <br />



<%}else{ %>
        <div class="headngblue" align="center">Not Applicable</div>
<% } %> <br />

      </div>

      <div class="content" id="country10">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Hazardous Waste Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td width="90%" align="center" valign="middle"
                      class="headngblue">Activity/Hazardous Waste Generation Details</td>

                  <td width="10%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>

                <tr>
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Storage/Disposal Details</td>

                  <td width="30%" class="headngblue" align="center"><a
                      href="#"
                      onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStorageDisposalDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                    View </a></td>


                </tr>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Hazardous Chemical Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardousChemicalView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>


              </table>

            </td>
          </tr>
        </table>


        <br />
      </div>

      <div class="content" id="country13">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">D.G.Set Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">D.G. Set Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGsetView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">D.G. Set Emission Source Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGSourceView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">D.G. Set Parameter Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGParameterView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
			

              </table>
            </td>
          </tr>


        </table>

      

        <br />
      </div>

      <div class="content" id="country12">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">



              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Stone Crusher Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Stone Crusher Siting Criteria Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneSittingCriteriaView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Stone Crusher Pollution Control Devices Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneCrusherControlDevicesView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                <tr>
                  <td align="center" valign="middle" class="headngblue">NOC Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popNocAuthorityView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

		<tr  bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Water Source Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr >
                  <td align="center" valign="middle" class="headngblue">Water Consumption Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

              </table>
            </td>
          </tr>


        </table>

       
        <br />
      </div>


      <div class="content" id="country15">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">

              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Hotel/Restaurant Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Hotel/Restaurant General Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelOtherDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Hotel/Restaurant Facility Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelFacilityView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Hotel/Restaurant Waste Emmission Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWasteEmissionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                 <tr >
                  <td align="center" valign="middle" class="headngblue">Water Source Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Water Consumption Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWaterConsumptionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>


        </table>

       
        <br />
      </div>




      <div class="content" id="country7">

        <table width="100%" border="0" align="center"
               cellpadding="0" cellspacing="1" bgcolor="#A5CAF4"
               class="tab-txt" style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">


              <table id="22" width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">

                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue" colspan="2">Enclosures Details</td>

                </tr>

                <g:def var="dList" value="${DocumentChecklistMaster.list()}" />

                <g:each var="doc" in="${listDoc}">
                  <tr>
                    <td width="60%" align="left" valign="middle"
                        bgcolor="#A8DAF3" class="headngblue">${doc.level}</td>
                    <td width="40%" align="left" bgcolor="#E8F6F9"
                        class="headngblue"><g:def var="fooVar"
                                              value="${indApplicationDetailsInstance.id}"/><g:def var="docN" value="${doc.level}"/> <g:link
                                              action="viewFile1"
                                              params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td> 
                                              
                                             
                  </tr>
                </g:each>


              </table>
            </td>
          </tr>
        </table>

        <br />


      </div>


     <div class="content" id="country14">
        <table width="100%" border="0" align="center" cellpadding="0"
               cellspacing="1" bgcolor="#A5CAF4" class="tab-txt"
               style="border-collapse: collapse;">
          <tr>
            <td bgcolor="#FFFFFF">

              <table width="100%" border="0" align="left"
                     cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#D1D1D1">
                  <td width="70%" align="center" valign="middle"
                      class="headngblue">Brick Kiln Details</td>
                  <td width="30%" align="center" valign="middle"
                      class="headngblue">Action</td>
                </tr>

                <tr>
                  <td align="center" valign="middle" class="headngblue">Brick Siting Criteria Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickSittingCriteriaView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Brick Kilns Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickKilnView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
<tr>
                  <td align="center" valign="middle" class="headngblue">Water Source Details</td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>

                <tr bgcolor="#A8DAF3">
                  <td align="center" valign="middle" class="headngblue">Water Consumption Details </td>
                  <td align="center" valign="middle" class="headngblue">
                    <table width="100%">
                      <tr>

                        <td align="center"><a href="#"
                                              onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                                                                                    View </a></td>

                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>


        </table>

       
        <br />
      </div>



</body>		
		  
		  
		  
		  
		  
          