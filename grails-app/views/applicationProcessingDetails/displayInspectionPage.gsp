<%@ page import="java.text.SimpleDateFormat"%>
<html>
    <head>
        <title>SPCB Admin Page</title>
        
<!-- For validations-->
    <script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"> </script>
	
<!-- For tabs-->
	<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
	
<!-- For Calendar-->
	<calendar:resources lang="en" theme="aqua"/>
	<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		
<!-- For designing-->
	<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
	
<!-- For designing of button-->
	<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
	
	<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
	
	    
	</head>
<body>

 <g:form controller="applicationProcessingDetails" method="post" name="myForm1" action="editInspection" AUTOCOMPLETE=OFF>
    
<table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle" width="100%">
                  <td  width="80%" align="left" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>General Information of Unit</span></a></li>
						<li><a href="#country2"><span>Air Pollution</span></a></li>
						<li><a href="#country3"><span>Water Consumption</span></a></li>
			            <li><a href="#country4"><span>Water Pollution</span></a></li>
			            <li><a href="#country5"><span>Hazardous Waste Management</span></a></li>
			            <li><a href="#country6"><span>Hazardous Chemicals Handling & Managemnet and PLI Act,1991</span></a></li>
			   
			    </ol>
			    
			    </td> 
			      <td style="text-align:right;"><g:link controller="applicationProcessingDetails" action="download12" id="${indApplicationDetailsInstance.id}" >Print your PDF</g:link> </td>
	 
			    </tr>  </table>

<div id="country1" class="content">
     <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
   
  
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Name & Address of the unit : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'nameadd')} </td> 
 </tr>
      <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Email id of the unit/occupier : </td>
           <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'email')} </td> 
   </tr>
    </tr>
      <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Telephone Nos. : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'telephone')} </td> 
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Fax Nos. : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'fax')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Date & Time of Inspection : </td>
        <!-- Display date in "dd/MM/yyyy" format-->
    <%
    def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
    String str=sdfh.format(insrep.date);
    %>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${str} </td> 
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Category of Unit : </td>
         <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'category')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Type of Units : </td>
             <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'typeofunit')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Size of unit based upon investment cost of Plant & Machinery : </td>
           <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'sizeofunit')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Name of the representative of the unit with designation present at the time of the inspection : </td>
              <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'nameofunit')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Name of the Directors/Partners/Proprietor/Manager/Occupier etc. : </td>
             <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'name')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Detail of products/by product manufactured(with capacity of installation & quantity per annum) : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailofproduct')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Detail of Raw Material used(with quantity per annum) : </td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailofrawmaterial')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Manufacturing Process (in brief) : </td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'manufacturingprocess')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Detail of Machinery installed involving polluting process : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailofmachinery')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Date of Commissioning of the unit : </td>
  <!-- Display date in "dd/MM/yyyy" format-->
    <%
    def sdfh1 = new SimpleDateFormat("dd/MM/yyyy"); 
    String str1=sdfh1.format(insrep.dateofcommissioning);
    %>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${str1} </td> 
  </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of Consent to Establish : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofCTE')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of Consent to Operate : </td>
     <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofCTO')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of Authorization under HWM Rules : </td>
     <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofauthorization')} </td>
   </tr>
 </table>
	</div>

<div id="country2" class="content">
     <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
   
  
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Sources of air emissions from process of unit
                          including fugitive emissions with type of Boliers/Furness, Capacity & stack height. : </td>
   <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'sourcesofemission')} </td>
   </tr>	
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of online monitoring System(Stacks/AAQ) if applicable : </td>
   <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofonline')} </td>
   </tr>
    </tr>	
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Details about deviation in the details/stack of Air emission/type of fuel if any already
 provided to Board : </td>
   <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailsofdeviation')} </td>
  </tr>
<tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Details of Stacks/Chimneys/Vents : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailsof')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether Height of all stacks/Chimneys as per norms : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'height')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Capacity of D.G. Sets : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'capacityofdgsets')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Stack height of D.G. Sets above programme and whether as per norms : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'stackheight')} </td>
    </tr>	
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of Acoustic Enclosure on D.G. Sets : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'Statusofdgsets')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Noise results of DG Sets Monitored during inspection : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'Noiseresults')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Type & Quantity of Fuel used(Separate for each source) : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'typequantity')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue" colspan="2">Status of Air Pollution Control Devices(APCD) : </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(a) Required or Not : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'apcdrequired')} </td></tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(b) Provided or Not : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'apcdprovided')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(c) Details of APCD provided with detail of all Components. : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailsofapcd')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(d) Whether Structurally adequate or Not : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'apcdadequate')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(e) Whether operating APCD Satisfactorily : </td>
    <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'apcdsatisfactorily')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether provided separate flow meters in case of wet scrubber : </td>
    <td align="left" bgcolor="#E8F6F9"class="headngblue"> ${fieldValue(bean:insrep,field:'flowmeters')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether maintained Log book for consumption of Electricity Chemicals/water for APCD. : </td>
      <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'apcdlogbook')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Details of treatment of effluent in case of wet scrubber & its mode of disposal. : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailoftreatment')} </td>
    </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue"> Whether provided Sampling arrangments on all stacks/chemniys including DG Sets. : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'sampling')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue"> General Remarks : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'remarksofairpollution')} </td>
   </tr>
   </table>
   </div>
<div id="country3" class="content">
     <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
   
  
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Sources of water supply : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'sourcesofwater')} </td>
    </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Details of measuring devices provided if any such as flow Meters, V-notch etc. : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailofmeasurng')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether measuring devices has been sealed : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'measuringdevices')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether maintained the log book for supply of water from all sources & comsumption for various uses. : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'logbook')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue" colspan="2">Detail of Water Consumption per day/month : </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(a) Domestic Purpose : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'domesticpurpose')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(b) Boiler/Cooling : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'boiler')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(c) Industrial use(Easily Biodegradable) : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'industrialusebio')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(d) Industrial use(Not Easily Biodegradable) : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'industrialusenotbio')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(e) Other : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'other')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">General Remarks : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'genmarks')} </td>
   </tr>
   </table> </div>
<div id="country4" class="content">
     <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Source & processes of water Pollution including raw water treatment if any : </td>
          <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'sourcesprocesses')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">No. of outlets for discharge of effluent : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
         <table> 
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue"> Domestic :</td>      <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'noofoutletsdomestic')} </td> </tr>
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue"> Trade :</td>      <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'noofoutletstrade')} </td> </tr>
         </table>
        </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Quality of Effluent in KLD : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
         <table> 
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue"> Domestic :</td> <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'qualityofeffluentdomestic')} </td> </tr>
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue"> Trade :</td> <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'qualityofeffluenttrade')} </td> </tr>
         </table>
        </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of Effluent Treatment Plant(ETP)/Sewage
   Treatment Plant(STP) : </td>
          <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusoftreatmentplant')} </td> 
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(a) Required or Not : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofrequired')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(b) Installed or Not : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofinstalled')} </td>
    </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(c) Detail of STP/ETP Provided(if required)
   with detail of all components and technology used : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofallcomponents')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(d) Whether structurally adequate or not : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofadequate')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(e) Whether operating STP/ETP Satisfactorily : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofoperating')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">&nbsp(f) Whether provided online chemical dozing system/ pH meter : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofonlinechemical')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Mode of Discharge of effluent : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue">
         <table> 
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue"> Domestic :</td>     <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'modeofdischargedomestic')} </td> </tr>
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue"> Trade :</td>     <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'modeofdischargetrade')} </td> </tr>
         </table>
        </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Name of Water recipient body if any : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'nameofwaterbody')} </td>
    </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Detail of land in case effluent is discharged fpr percolation
    /irrigation purpose with justification for its 100% utilization. : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailofland')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of ZLD as per CPCB directions if applicable : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'statusofzld')} </td>
    </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether provided flow meters on outlet & inlet of ETP/STP : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'flowmeterson')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether provided separate electricity meter on ETP/STP : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'electricitymeter')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether maintained log Book for consumption of Electricity/Chemicals/Quantity of Effluent. : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'logbookforconsumption')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of online monitoring System, if applicable : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'onlinemonitoring')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">General Remarks : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'genremarks')} </td>
    </tr>
   </table> </div>
<div id="country5" class="content">
     <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Category of Hazardous Waste generated as per rules : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'hazardouswaste')} </td>
    </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Type of Qty. of Hazardous Waste generated : </td>
         <td align="left" bgcolor="#E8F6F9" class="headngblue">
         <table> 
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue">(i) Incinerable :</td> <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'typeqtyincinerable')} </td> </tr>
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue">(ii) Recyclable :</td> <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'typeqtyrecyclable')} </td> </tr>
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue">(iii) Disposable for landfill :</td> <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'typeqtydisposable')} </td> </tr>
          <tr> <td class="headngblue" bgcolor="#E8F6F9" class="headngblue">(iv) Total :</td>     <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'typeqtytotal')} </td> </tr>
         
         </table>
        </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Stock-Pile Quantity of Hazardous Waste : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'stockpileqty')} </td>
    </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Mode of Disposal & treatment of Haz. Waste : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'modeofdisposal')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Size of Hazardous waste storage site : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'sizeofhazardouswaste')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Display Board for Hazardous Waste at factory Gate Provided or not : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'displayboard')} </td>
   </tr>
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether agreement made with the services provider for
    disposal of hazardous waste(if yes, give detail with validity) : </td>
       <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'serviceprovider')} </td>
    </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Details of hazardous Waste transported to service provider : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'detailofhazardouswaste')} </td>
   </tr>
   </table> </div>
 
 <div id="country6" class="content">
     <table width="80%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="center">
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">List & Qty. of Hazardous chemical handled & used(if any) with
   threshold quantity : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'listqty')} </td>
   </tr> 
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether prepared on site emergency plan and taken
   Insurance policy under PLI Act, 1991. : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'preparedonsite')} </td>
   </tr> 
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Name of insurer agency with date & validity of policy : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'nameofinsurer')} </td>
    </tr>  
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether Hazardous chemicals handling & storage facility is adequate : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'hazardouschemicals')} </td>
   </tr>
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Remarks : </td>
        <td align="left" bgcolor="#E8F6F9" class="headngblue"> ${fieldValue(bean:insrep,field:'remarks')} </td>
   </tr>
  </table> </div> 
<input type="hidden" name="id" value="${fieldValue(bean:insrep,field:'id')}" />  
   <div style="text-align:center;">
  
    </div>
  </g:form>
</body>
</html>