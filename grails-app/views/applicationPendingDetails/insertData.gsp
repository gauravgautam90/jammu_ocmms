<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
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
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

	
	
	<script type="text/javascript"	src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
	<link rel="stylesheet" type="text/css"	href="${createLinkTo(dir:'css',file:'design.css')}" />
	<script type="text/javascript"	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

	<g:javascript library="prototype" />


<script type="text/javascript">


</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>




<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>
<g:javascript>
	
	

function updateCity1(e) {
// The response comes back as a bunch-o-JSON
var cities = eval("(" + e.responseText + ")") // evaluate JSON

if (cities) {
var rselect = document.getElementById('industryType.id')
var CatVale = document.getElementById('category1')


// Clear all previous options
var l = rselect.length

while (l > 0) {
l--
rselect.remove(l)
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



}





	function Checkfiles(){
	   var frm = document.forms["myForm"];
	   
	   var fupp = document.getElementsByName('consentOrder');
	   var fup12 = fupp[0];

	   var fileName = fup12.value;
	   var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();


	   if(ext != "pdf" && fileName !="" ){
	   alert("Please upload non-editable files only (.pdf)");
	   return false;
	   }
	  
	   else {
		  
		   return true;
	   }
	   
	   }


	
</g:javascript>




<g:javascript>
function hideDivAction()
{   
	var radiomenu800 = document.getElementById('lastAction').value;
	
	
	if (radiomenu800 == "SCN"  ) {
		document.getElementById('SelectSCN').style.display =  'block';
		document.getElementById('SelectSCN1').style.display =  'block';
		
		document.getElementById('Select11').style.display =  'block';
		document.getElementById('Select1').style.display =  'block';
		document.getElementById('Select22').style.display =  'block';
		document.getElementById('Select2').style.display =  'block';
		document.getElementById('Select33').style.display =  'block';
		document.getElementById('Select3').style.display =  'block';
		document.getElementById('Select4').style.display =  'block';
		document.getElementById('Select44').style.display =  'block';
		
		} 
		
	else { 
		document.getElementById('SelectSCN').style.display =  'none';
		document.getElementById('SelectSCN1').style.display =  'none';
		
		document.getElementById('Select11').style.display =  'none';
		document.getElementById('Select1').style.display =  'none';
		document.getElementById('Select22').style.display =  'none';
		document.getElementById('Select2').style.display =  'none';
		document.getElementById('Select33').style.display =  'none';
		document.getElementById('Select3').style.display =  'none';
		document.getElementById('Select4').style.display =  'none';
		document.getElementById('Select44').style.display =  'none';
	}	
}

function hideDivScnAction()
{   
	var radiomenu800 = document.getElementById('lastActionScn').value;
	
	
	if (radiomenu800 == "SCN"  ) {
		document.getElementById('SelectSCNa').style.display =  'block';
		document.getElementById('SelectSCNaa').style.display =  'block';
		
		document.getElementById('Selecta').style.display =  'block';
		document.getElementById('Selectaa').style.display =  'block';
		document.getElementById('Selectb').style.display =  'block';
		document.getElementById('Selectbb').style.display =  'block';
		document.getElementById('Selectc').style.display =  'block';
		document.getElementById('Selectcc').style.display =  'block';
		document.getElementById('Selectd').style.display =  'block';
		document.getElementById('Selectdd').style.display =  'block';
		
		
		} 
		
	else { 
		document.getElementById('SelectSCNa').style.display =  'none';
		document.getElementById('SelectSCNaa').style.display =  'none';
		
		document.getElementById('Selecta').style.display =  'none';
		document.getElementById('Selectaa').style.display =  'none';
		document.getElementById('Selectb').style.display =  'none';
		document.getElementById('Selectbb').style.display =  'none';
		document.getElementById('Selectc').style.display =  'none';
		document.getElementById('Selectcc').style.display =  'none';
		document.getElementById('Selectd').style.display =  'none';
		document.getElementById('Selectdd').style.display =  'none';
		
	}	
}


function hideDivActionNew()
{   
	var radiomenu800 = document.getElementById('lastAction').value;
	var radiomenu801 = document.getElementById('nonComplying').value;
	
	if (radiomenu801 == "Yes") {
		
		document.getElementById('SelectLA').style.display =  'block';
		document.getElementById('SelectLA1').style.display =  'block';
		
		document.getElementById('SelectSCN1').style.display =  'block';
		document.getElementById('SelectSCN').style.display =  'block';
		
		
		
		} 
		
	else { 
		
		document.getElementById('SelectSCN1').style.display =  'none';
		document.getElementById('SelectSCN').style.display =  'none';
		
		document.getElementById('SelectLA').style.display =  'none';
		document.getElementById('SelectLA1').style.display =  'none';
		
		
		
	}	
}



function hideDivActionA()
{   
	var radiomenu800 = document.getElementById('lastActionScn').value;
	var radiomenu801 = document.getElementById('ccaExpiry').value;
	
	if (radiomenu801 == "Yes") {

		document.getElementById('SelectLAScn').style.display =  'block';
		document.getElementById('SelectLAScna').style.display =  'block';
		document.getElementById('SelectSCNa').style.display =  'block';
		document.getElementById('SelectSCNaa').style.display =  'block';
		
		} 
		
	else { 
		document.getElementById('SelectLAScn').style.display =  'none';
		document.getElementById('SelectLAScna').style.display =  'none';
		
		document.getElementById('SelectSCNa').style.display =  'none';
		document.getElementById('SelectSCNaa').style.display =  'none';
		
		
	}	
}


</g:javascript>


<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

<g:javascript>




function selectIndType(){
//alert("aaaaaaa");
	var radiomenu = document.getElementById('industryType.id')
	var indtype = radiomenu.value
	//alert("indtype--"+indtype);
	if(radiomenu.value == "100" || radiomenu.value == ""){

		alert("Please select Industry Type First");

			}
	else{
		document.getElementById('indType').value = indtype
		document.getElementById('autocomplete_choices').style.display = 'block';

		new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/applicationPendingDetails/ajaxAutoCompleteTest",
				{minChars: 3,parameters:'indType='+(document.getElementById('industryType.id').value)+'&indDist='+(document.getElementById('district.id').value), afterUpdateElement : getSelectionId},
		                       );
		
		
	}
}

function getSelectionId(text, li) {
	${remoteFunction(controller:"applicationPendingDetails", action:"ajaxVineet",params:"'id=' + text.value+\'&indType=\'+document.getElementById(\'industryType.id\').value+\'&indDist=\'+document.getElementById(\'district.id\').value",onComplete:"updateValue(e)")}
    document.getElementById('autocomplete_choices').style.display = 'none';
}

function updateValue(e){
	//alert("aaaa---"+e)
	var cities = e.responseText
	//alert("cities---"+cities)
	var valueAA=cities.split('#')
	var cities1 = valueAA[0]; 
	var cities2 = valueAA[1];
	var cities3 = valueAA[2];
	var cities4 = valueAA[3];
	var cities5 = valueAA[4];
	var cities6 = valueAA[5];
	var cont = "<%=request.getContextPath()%>";
	
	if(e.responseText)
	{
	
		document.getElementById("indAddress").value =cities1;
		//document.getElementById('indAddress').disabled = true;
		document.getElementById('indAddress').readOnly = true;
		document.getElementById("mobileNo").value =cities2;
		//document.getElementById("category").value =cities3;
		document.getElementById('category').readOnly = true;
		document.getElementById("indregId").value =cities4;
		document.getElementById("indScale").value =cities6;
		if(cities5!=""){
		
		document.getElementById("cert2").innerHTML="<a href='"+cont+"/applicationPendingDetails/downLoadingCertificate1/"+cities5+"'>View Certificate</a>";
			
		document.getElementById("certApp").value =cities5;
		document.getElementById('cert1').style.display = 'block';
		}
	}
	else{
		document.getElementById("indAddress").value ="";
		document.getElementById("mobileNo").value ="";
		
		document.getElementById("indregId").value ="";
		document.getElementById('cert1').style.display = 'none';
	}
	
	
	
}

function updateField(){

	document.getElementById("autocomplete1").value ="";
	document.getElementById("indAddress").value ="";
	document.getElementById("mobileNo").value ="";
	document.getElementById("indScale").value ="small";
	document.getElementById("indregId").value ="";
	document.getElementById('cert1').style.display = 'none';
}

</g:javascript>

<g:javascript>


function selectGpi(){
	
	var selectmenu=document.getElementById('gpi').value;
	
	
	   	 if(selectmenu == "Yes")
	   	 {
	   		
	   		document.getElementById('SelectLoc').style.display =  'block';
			document.getElementById('SelectLoc1').style.display =  'block';
			document.getElementById('SelectName').style.display =  'block';
			document.getElementById('SelectName1').style.display =  'block';
	   		 
		 }
	   	 else
	   	 {
	   		document.getElementById('SelectLoc').style.display =  'none';
			document.getElementById('SelectLoc1').style.display =  'none';
			document.getElementById('SelectName').style.display =  'none';
			document.getElementById('SelectName1').style.display =  'none';	 
	   		 
	   	 }

}

function selectComp(){
	
	var selectmenu=document.getElementById('complying').value;
	var selectmenu1=document.getElementById('nonComplying').value;
	
	   	 if(selectmenu1 == "Yes")
	   	 {
	   		
	   	 if(selectmenu == "Yes"){
	   		
	   		alert("Industry is Complying so Non Complying will be No");
	   		document.getElementById('nonComplying').value="No";
	   	 }
	   		 
		 }


}

function selectclose(){
	
	var selectmenu=document.getElementById('operational').value;
	var selectmenu1=document.getElementById('closed').value;
	
	   	 if(selectmenu1 == "Yes")
	   	 {
	   		
	   	 if(selectmenu == "Yes"){
	   		
	   		alert("Industry is Operational so can not be closed");
	   		document.getElementById('closed').value="No";
	   	 }
	   		 
		 }


}
</g:javascript>
<g:javascript>
function selectDate1(){
	
	
	alert("aaaaa---");


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
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
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
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
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
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
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
					 </td></tr>
					
					 <tr >
						
						<td width="100%" align="left" >
							<g:link controller="applicationPendingDetails" action="updatePage" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link> 				
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
					 </td></tr>
		
		<% } %>
	
					 </table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
										<div class="message">${flash.message}</div>
										</g:if>
										<g:hasErrors bean="${groupMasterInstance}">
										<div class="errors">
											<g:renderErrors bean="${groupMasterInstance}" as="list" />
										</div>
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
       
			<FORM id="myForm" name=myForm action="saveData" method="post" enctype="multipart/form-data" >  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		
		<!--<FORM id="myForm" name='myForm' action="search" method="post">-->
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Insert Industry Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
			<input type="hidden" id="indType" name="indType" value="">
			<input type="hidden" id="indregId" name="indregId" value="">
			<input type="hidden" id="certApp" name="certApp" value="">
				
			
			<%
	          def distList
	          if(session.relatedDistrict){
	           distList = session.relatedDistrict;
	          }
	          else if(userType.equals("admin")){
	        	  
	        	  distList = DistrictMaster.list();  
	          }
	          
	          //System.out.println("distList----"+distList);
	          
	          %>
	         <tr  >
	         <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >District:<span style="color:red">*</span></td>
	         <td align="left" colspan="2" bgcolor="#E8F6F9">
	        
	         <g:select optionKey="id" optionValue="districtName" name="district.id" id="district.id" from="${distList}"  onChange="updateField();" >

	         </g:select>
	         <span class="txt4">(Select district)</span>

	        </td>
					
	       </tr>
	       
			 <tr>
             <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Category:<span style="color:red">*</span></td>
             <td align="left" colspan="2" bgcolor="#E8F6F9">
            
             <g:select  from="${['Not-Selected','RED','ORANGE','GREEN']}" name="category" id="category" class="txt4"
            	 onchange="${remoteFunction( controller:'industryRegMaster', action:'ajaxGetCitiesRep',
						params:'\'id=\' + escape(this.value)', onComplete:'updateCity1(e)')}" 
						style="width:400px"
               ></g:select>
               

            </td>
				
           </tr>
			
           <tr  >
           <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Industry Type:<span style="color:red">*</span></td>
           <td align="left" colspan="2" bgcolor="#E8F6F9">
          
           <g:select optionKey="id" optionValue="industryType" name="industryType.id" id="industryType.id" style="width:300px;" >

           </g:select>
           <span class="txt4">(Select Industry Type)</span>

          </td>
				
         </tr>
          
       
					
						
                      <tr  >
                        <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Industry Name:<span style="color:red">*</span></td>
                        <td align="left" colspan="2" bgcolor="#E8F6F9">
                        <input type="text" class="txt4" id="autocomplete1" size="40" name="autocomplete_parameter1" onClick="selectIndType();"/>
                        <span class="txt4">(Enter first 3 letter of Industry Name)</span></td>
						
                      </tr>
					  <div id="autocomplete_choices" class="autocomplete1" style="display:none;" ></div>
                     
					  <tr  >
                      <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Industry Address:<span style="color:red">*</span></td>
                      <td align="left" colspan="2" bgcolor="#E8F6F9">
                      <input name="indAddress" id="indAddress" type="text"	size="40"
						 class="txt4" AUTOCOMPLETE=OFF />

                     </td>
						
                    </tr>
                    
                    <tr  >
                    <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Mobile No:<span style="color:red">*</span></td>
                    <td align="left" colspan="2" bgcolor="#E8F6F9">
                    <input name="mobileNo" id="mobileNo" type="text" size="20" maxlength="12"	
						 class="txt4" AUTOCOMPLETE=OFF />

                   </td>
						
                  </tr>
                 
                
                <tr  >
                <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Industry Scale:</td>
                <td align="left" colspan="2" bgcolor="#E8F6F9">
                <g:select  from="${['Small','Medium','Large']}" name="indScale" id="indScale" class="txt4"></g:select>

               </td>
					
              </tr>
                
                <tr  >
                <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Operational:</td>
                <td align="left" colspan="2" bgcolor="#E8F6F9">
                <g:select  from="${['Yes','No']}" name="operational" id="operational" onchange="javascript:selectclose();" class="txt4"></g:select>

               </td>
					
              </tr>
              
              <tr  >
              <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Closed:</td>
              <td align="left" colspan="2" bgcolor="#E8F6F9">
              <g:select  from="${['No','Yes']}" name="closed" id="closed" onchange="javascript:selectclose();" class="txt4"></g:select>

             </td>
					
            </tr>
            
            <tr  >
            <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >whether GPI(Grossly Polluting Industry):</td>
            <td align="left" colspan="2" bgcolor="#E8F6F9">
            <g:select  from="${['No','Yes']}" name="gpi" id="gpi" onchange="javascript:selectGpi();"  class="txt4"></g:select>

           </td>
  				
          </tr>
              
          
  	 
        <tr  >
        <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
        <div id="SelectLoc" style="display:none">
        Located in Ganga Basin:
      	  </div>
      	  </td>
        <td align="left" colspan="2" bgcolor="#E8F6F9">
        <div id="SelectLoc1" style="display:none">
        <g:select  from="${['Yes','No']}" name="ganga" id="ganga" class="txt4"></g:select>
        <div>
       </td>
  			
      </tr>
           
      <tr  >
      <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
      <div id="SelectName" style="display:none">
      Name of concerned recipient water course:
    	  </div>
    	  </td>
      <td align="left" colspan="2" bgcolor="#E8F6F9">
      <div id="SelectName1" style="display:none">
     
      <textarea name="waterCourse" id="waterCourse" rows="4" cols="40" maxlength="500" class="txt4"></textarea>
      <div>
     </td>
			
    </tr>
      
            
            <tr  >
            <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Complying:</td>
            <td align="left" colspan="2" bgcolor="#E8F6F9">
            <g:select  from="${['Yes','No']}" name="complying" id="complying" onchange="javascript:selectComp();hideDivActionNew();"  class="txt4"></g:select>

           </td>
				
          </tr>
          
          <tr  >
          <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Non-Complying:</td>
          <td align="left" colspan="2" bgcolor="#E8F6F9">
          <g:select  from="${['No','Yes']}" name="nonComplying" id="nonComplying" onchange="javascript:selectComp();hideDivActionNew();"  class="txt4"></g:select>

         </td>
				
        </tr>
            
        
	 
      <tr  >
      <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
      <div id="SelectLA" style="display:none">
      Last Action Taken:
    	  </div>
    	  </td>
      <td align="left" colspan="2" bgcolor="#E8F6F9">
      <div id="SelectLA1" style="display:none">
      <g:select  from="${['CLOSURE','SCN','LEGAL','UNDER PROCESS']}" name="lastAction" id="lastAction" onclick="javascript:hideDivActionNew();" class="txt4"></g:select>
      <div>
     </td>
			
    </tr>
      
    <tr  >
    <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
    <div id="SelectSCN1" style="display:none">
    Details:<span style="color:red">*</span>
    </div>
    </td>
    <td align="left" colspan="2" bgcolor="#E8F6F9">
    <div id="SelectSCN" style="display:none">
    <textarea name="scnNote" id="scnNote" rows="5" cols="45" maxlength="1000" class="txt4"></textarea>
    <input type="file" name="scnDoc" />
    </div>
   </td>
			
  </tr>
    
  <!-- new fields added start -->
  <tr  >
  <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
  <div id="Select1" style="display:none">
  Show Cause Notice/Directions issued under the Env. Acts:<span style="color:red"></span>
  </div>
  </td>
  <td align="left" colspan="2" bgcolor="#E8F6F9">
  <div id="Select11" style="display:none">
  <g:select  from="${['No','Yes']}" name="direction" id="direction" value="" class="txt4"></g:select>

 
  </div>
 </td>
			
</tr>
  
<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Select2" style="display:none">
Closure Directions issued under the Env. Acts:<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Select22" style="display:none">
<g:select  from="${['No','Yes']}" name="colDirection" id="colDirection" value="" class="txt4"></g:select>


</div>
</td>
			
</tr>

<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Select3" style="display:none">
Legal Cases filed in the court(s):<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Select33" style="display:none">
<g:select  from="${['No','Yes']}" name="legal" id="legal" value="" class="txt4"></g:select>


</div>
</td>
			
</tr>


<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Select4" style="display:none">
Action is under process:<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Select44" style="display:none">
<g:select  from="${['No','Yes']}" name="underProcess" id="underProcess" value="" class="txt4"></g:select>


</div>
</td>
			
</tr>

	<tr  >
	<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
	
	CCA Expiry:</td>
	<td align="left" colspan="2" bgcolor="#E8F6F9">
	<g:select  from="${['No','Yes']}" name="ccaExpiry" id="ccaExpiry" value="" onclick="javascript:hideDivActionA();" class="txt4"></g:select>

	</td>
	
	</tr>     

<!----- new modification --->

<tr  >
	<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
	<div id="SelectLAScn" style="display:none">
	Last Action Taken:
		</div>
		</td>
	<td align="left" colspan="2" bgcolor="#E8F6F9">
	<div id="SelectLAScna" style="display:none">
	<g:select  from="${['CLOSURE','SCN','LEGAL','UNDER PROCESS']}" name="lastActionScn" id="lastActionScn" class="txt4"></g:select>
	</div>
	</td>
		
	</tr>

<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="SelectSCNa" style="display:none">
Details:<span style="color:red">*</span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="SelectSCNaa" style="display:none">
<textarea name="scnNoteScn" id="scnNoteScn" rows="5" cols="45" maxlength="1000" class="txt4"></textarea>
<input type="file" name="scnDocScn" />
</div>
</td>
		
</tr>

<!-- new fields added start -->
<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Selecta" style="display:none">
Show Cause Notice/Directions issued under the Env. Acts:<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Selectaa" style="display:none">
<g:select  from="${['No','Yes']}" name="directionScn" id="directionScn" value="" class="txt4"></g:select>


</div>
</td>
		
</tr>

<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Selectb" style="display:none">
Closure Directions issued under the Env. Acts:<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Selectbb" style="display:none">
<g:select  from="${['No','Yes']}" name="colDirectionScn" id="colDirectionScn" value="" class="txt4"></g:select>


</div>
</td>
		
</tr>

<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Selectc" style="display:none">
Legal Cases filed in the court(s):<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Selectcc" style="display:none">
<g:select  from="${['No','Yes']}" name="legalScn" id="legalScn" value="" class="txt4"></g:select>


</div>
</td>
		
</tr>


<tr  >
<td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >
<div id="Selectd" style="display:none">
Action is under process:<span style="color:red"></span>
</div>
</td>
<td align="left" colspan="2" bgcolor="#E8F6F9">
<div id="Selectdd" style="display:none">
<g:select  from="${['No','Yes']}" name="underProcessScn" id="underProcessScn" value="" class="txt4"></g:select>


</div>
</td>
		
</tr>



<!--- new modification end ---->
	

  <!-- new fields added end -->
    <tr  >
    <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >CCA Validity:</td>
    <td align="left" colspan="2" bgcolor="#E8F6F9">
   
	<calendar:datePicker id="ccaValidity" name="ccaValidity" defaultValue="${new Date()}" onClick="javascript:selectDate()"  dateFormat="%d/%m/%Y"  />
   </td>
		
  </tr>
  
  <tr >
  <td width="50%" class="headngblue"  bgcolor="#A8DAF3" colspan="2"  align="left" >Upload Certificate: </td>
  <td align="left" colspan="2" bgcolor="#E8F6F9"><span class="style30">
  <div id="cert2" align="left">
  
	</div>
	
	<div id="cert1" align="left" style="display:none; border:0;">
	  
	  <span style="color:red"><font size="3">Kindly check Certificate, if you want to change other Certificate please upload it.</font></span>
 
  </div>
  <input type="file" name="consentOrder" />
	
	</td>
</tr>
  
  
	 </table>
	 <input type="hidden" name="passwordEncrypt" id="passwordEncrypt"  value="<%=Math.round((Math.random()+100000)*Math.random()+10000)%>" />
		
		<input type="hidden" name="password" id="password" value="" /> 
	  
	  
	   <table width="95%" align="center">
	   		
		  <tr>
			<td align="center"><input type="submit" name="save" id="save" value="Save" onclick="industryPassEncryption();return Checkfiles();" class="actionbutton" ></td>
		<!--	<td align="left"><input type="reset" name="save" value="Reset" class="actionbutton"></td>
			-->
		  </tr>
 
		</table>
 		
		
		<g:if test="${abc}">
            
           

<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

                  <tr height="20" bgcolor="#A8DAF3">
                  <th align="center" class="headngblue">District</th>
                  <th align="center" class="headngblue" >Category</th>
                   	        <th align="center" class="headngblue">Industry Type</th>
                   	        <th align="center" class="headngblue" >Industry Name </th>
                   	        <th align="center" class="headngblue" >Industry Address</th>
                   	        <th align="center" class="headngblue" >Mobile No</th>
                   	       
                   	     <th align="center" class="headngblue" >Industry Scale</th>
                   	        <th align="center" class="headngblue" >Operational</th>
                   	        <th align="center" class="headngblue" >Closed</th>
                   	     
                   	  <th align="center" class="headngblue" >GPI</th> 
                 
                      <%
              	    if(abc.gpi=="Yes")
					{
              	       %>
                   	  <th align="center" class="headngblue" >Located in Ganga Basin</th>
                   	<th align="center" class="headngblue" >Name of concerned recipient water course</th> 
                   	<%}%>
                   	
                   	        <th align="center" class="headngblue" >Complying</th>
                   	        <th align="center" class="headngblue" >Non Complying</th>
                   	        
                   	     <%
                    	    if(abc.nonComplying=="Yes")
 						{
                    	       %>
                   	       <th align="center" class="headngblue" >Last Action Taken</th> 
                   	       
                   	       <%}
                   	   
                   	       %>
                   	       
                   	   
                   	    
               	    <th align="center" class="headngblue" >CCA Expiry</th> 
               	 <%
           	    if(abc.ccaExpiry=="Yes")
 				{
           	       %>      
               	  <th align="center" class="headngblue" >Last Action Taken</th> 
          	       
          	      
      	       
      	       <%}%>
               	    
                   	      <th align="center" class="headngblue" >CCA Validy</th> 
                   	   <th align="center" class="headngblue" >Consent Order</th> 
                   	        </tr>

                    <g:each in="${abc}" status="i" var="abc">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'district')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'category')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'industryTypeNew')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'industryName')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'indAddress')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'mobileNo')}</td>
                       
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'indScale')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'operational')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'closed')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'gpi')}</td>
                        <%
                  	    if(abc.gpi=="Yes")
    					{
                  	       %>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'ganga')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'waterCourse')}</td>
                        <%}%>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'complying')}</td>
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'nonComplying')}</td>
                        <%if(abc.nonComplying=="Yes"){%>   
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'lastAction')}
                                
                                 <%if(abc.lastAction!=""){%>        
                             <br>
                                 ${fieldValue(bean:abc, field:'scnNote')} 
                                 <%if(abc.scnDoc==true){%>
                                 
                                 <br>  
                                 <g:link action="downLoadingSCNDoc"  id="${abc.id}" ><span class="innerlink">View Document</span></g:link>     
                                 
                           <%}}%>  
                           </td>
                           
                           
                   	       
                           
                   	    <%}%>
                   	    
                   	 <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'ccaExpiry')}</td>
                     
             	       <%
             	    if(abc.ccaExpiry=="Yes")
      			{
             	       %>
                   	 
                   	 <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'lastActionScn')}
                     
                     <%if(abc.lastActionScn!=""){%>        
                 <br>
                     ${fieldValue(bean:abc, field:'scnNoteScn')} 
                     <%if(abc.scnDocScn==true){%>
                     
                     <br>  
                     <g:link action="downLoadingSCNDocScn"  id="${abc.id}" ><span class="innerlink">View Document</span></g:link>     
                     
               <%}}%>  
               </td>
               
               
       	     
               
       	    <%}%>
                   	 
                   	    
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc, field:'ccaValidity')}</td>
                    <%if(abc.certificate==true){%>
                        <td align="center" height="25" class="txt4"  >
                        <g:link action="downLoadingCertificate"  id="${abc.id}" ><span class="innerlink">View Consent Order</span></g:link>
                        </td>
                        <%}%>
                        
                        </tr>
                    </g:each>
					
					 
                </table>
		
		
		</g:if>
		
		
            <br />
            <br />
          </div>
		  
		  </form>
		  
	  
		  
          </div>
	
          <script language="JavaScript" type="text/javascript">
          var frmvalidator  = new Validator("myForm");
           frmvalidator.EnableFocusOnError(false); 
           frmvalidator.EnableMsgsTogether();  
           
           function CheckSCN(){
        	   var abc="";
        	   var frm = document.forms["myForm"];
        	   var fupp1 = document.getElementById('nonComplying');
        	   var fupp11 = document.getElementById('scnNote');
        	   
        	   var fupp = document.getElementsByName('scnDoc');
        	   var fup12 = fupp[0];
        	  
        	   var fileName = fup12.value;
        	   var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        	   
        	   if(ext != "pdf" && fileName !="" ){
         	   alert("Please upload non-editable files only (.pdf)");
         	   return false;
         	   }
        	  
        	   
        	   var fupp1a = document.getElementById('ccaExpiry');
        	   var fupp11a = document.getElementById('scnNoteScn');
        	   
        	   var fuppa = document.getElementsByName('scnDocScn');
        	   var fup12a = fuppa[0];
        	  
        	   var fileNamea = fup12a.value;
        	   var exta = fileNamea.substring(fileNamea.lastIndexOf('.') + 1).toLowerCase();
        	   
        	   if(exta != "pdf" && fileNamea !="" ){
         	   alert("Please upload non-editable files only (.pdf)");
         	   return false;
         	   }
        	   
        	   
        	   
        	   
        	   if(fupp1.value=="Yes"){
        		  
        	  if(fupp11.value=="")
        	  {
        		  alert("Please enter Note");
        	   return false;  
        		  
        	  }
        	  else if(fileName ==""){
        		  alert("Please browse file first.");
        		  return false;
        		  }
        	  else {
        	 
        		  abc="checked";
        	   }
        	   }
        	   
        	   if(fupp1a.value=="Yes"){
         		  
             	  if(fupp11a.value=="")
             	  {
             		  alert("Please enter Note");
             	   return false;  
             		  
             	  }
             	  else if(fileNamea ==""){
             		  alert("Please browse file first.");
             		  return false;
             		  }
             	  else {
             	 
             		 abc="checked";
             	   }
             	   }
        	   else {
        		   
        		   return true;
         	   }
        	   if( abc=="checked"){
        		   return true;  
        		   
        	   }
        }
           frmvalidator.addValidation("district.id","req","Please select district");
           frmvalidator.addValidation("category","dontselect=0","please enter industry category");
          frmvalidator.addValidation("mobileNo","numeric","please enter Valid Mobile No");
          frmvalidator.addValidation("mobileNo","req","please enter Mobile No");
          frmvalidator.addValidation("industryType.id","reg","please Select Industry Type");
          frmvalidator.addValidation("autocomplete_parameter1","req","please enter Industry Name");
          frmvalidator.addValidation("indAddress","req","please enter industry address");
          //frmvalidator.addValidation("category","req","please enter industry category");
          
//          frmvalidator.setAddnlValidationFunction("Checkfiles");
          frmvalidator.setAddnlValidationFunction("CheckSCN");
        </script>       
          
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
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
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


