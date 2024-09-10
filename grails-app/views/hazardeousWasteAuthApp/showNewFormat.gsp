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
		<title>Application For Authorization</title>
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
			
			
			function enablingDisabling()
			{
				
				var a= document.getElementById("radioIs_RenewYes").value;
				if(a=="Yes")
					{
						document.getElementById("auth_Renew_No").disabled = true;
						document.getElementById("auth_Renew_No").value="";
						document.getElementById("auth_Renew_Date").disabled = true;
						document.getElementById("auth_Renew_Date").value="";
					}
			}
			
			function enablingDisablingAgain()
			{
				
				var a= document.getElementById("radioIs_RenewYes").value;
				if(a=="Yes")
					{
						document.getElementById("auth_Renew_No").disabled = false;
						document.getElementById("auth_Renew_Date").disabled = false;
					}
			}
		</script>
		
		<g:javascript>
			function createRow(){

  			try{
      			var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'addProduct.gsp', {evalScripts: true, insertion: Insertion.Bottom });
  				}catch(e){
      		alert('Failed to call Ajax');
  					}
			}
			
			function createNewRow(){

  			try{
      			var oAjax=new Ajax.Updater({success: 'AjaxPanel1'},'addWaste.gsp', { insertion: Insertion.Bottom });
  				}catch(e){
      		alert('Failed to call Ajax');
  					}
			}
			
			
		function select1()
{
var selectmenu1=document.getElementById("recycleHazard")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp1').style.display = 'none';
   	 document.getElementById('selectTemp').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp').style.display = 'none';
    document.getElementById('selectTemp1').style.display = 'block';
   		 }
   }
}
function select2()
{
var selectmenu1=document.getElementById("importHazard");

   //	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(selectmenu1.value == "YES")
   	 {
   	
   	 document.getElementById('selectTemp2').style.display = 'block';
  	 
	 }
else{
    document.getElementById('selectTemp2').style.display = 'none';
   
    
   		 }

   
  }



function select3()
{

var selectmenu11=document.getElementById("importHazard11")
selectmenu11.onchange=function()
 {    
   	 var chosenoption1=this.options[this.selectedIndex]
         
   	 if(chosenoption1.value == "YES")
   	 {
   	 document.getElementById('selectTemp33').style.display = 'none';
   	 document.getElementById('selectTemp22').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp22').style.display = 'none';
    document.getElementById('selectTemp33').style.display = 'block';
   		 }
   }
}


function select4()
{

var selectmenu88=document.getElementById("importHazard01")
selectmenu88.onchange=function()
 {    
   	 var chosenoption1=this.options[this.selectedIndex]
        
   	 if(chosenoption1.value == "YES")
   	 {
   	 document.getElementById('selectTemp88').style.display = 'block';
   	 document.getElementById('selectTemp99').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp88').style.display = 'none';
    document.getElementById('selectTemp99').style.display = 'none';
   		 }
   }
}

</g:javascript>

<Script Language=JavaScript>
	function getStats(control){
		var fName = control.value;
		// alert(control.name);
		var hContName = control.name+"extn";
		// alert(hContName);
		var hCont = document.getElementsByName(hContName);
		// alert('size '+hCont)
		fullName = fName;
		shortName = fullName.match(/[^\/\\.]+$/);
		//document.forms.Form1.dispName.value = shortName
		// alert(shortName);
		var a = hCont[0];
		a.value = shortName;
		//alert(a.value);
	}
</Script>
		
		<script language="javascript">
function deleteTable()
{
var table = document.getElementById("table1");

for(var i = table.rows.length - 1; i > 2; i--)
{
    table.deleteRow(i);
}

var tbody = document.getElementById("table1").tBodies[0]; 
var row = document.createElement("TR"); 
var cell1 = document.createElement("TD");
cell1.setAttribute("width","100%");
cell1.setAttribute("colspan","2");
var div = document.createElement("DIV"); 
div.setAttribute("id","AjaxPanel1");
cell1.appendChild(div);
row.appendChild(cell1);
tbody.appendChild(row);
}
</script>

<script language="javascript" type="text/javascript">
		
	
		
			
function hidediv() 
{
	for(var i = 0; i<document.myform.radioIs_Renew.length; i++)
	{
	   if(document.myform.radioIs_Renew[i].checked)
	   {
	      var radiomenu = document.myform.radioIs_Renew[i]
	  
	   	   if (radiomenu.value == "Fresh") 
	   	   { 
	 			if(document.getElementById('auth_Renew_No'))
	 			document.getElementById('auth_Renew_No').disabled = true;
	 			if(document.getElementById('SelectTemp11'))
	 			document.getElementById('SelectTemp11').style.display = 'none';
	 			if(document.getElementById('SelectTemp22'))
	 			document.getElementById('SelectTemp22').style.display = 'none';
	 			if(document.getElementById('docAttachmentDiv'))
	 			document.getElementById('docAttachmentDiv').style.display = 'none';
			} 
			else if (radiomenu.value == "Renew") 
			{ 
		
				if(document.getElementById('auth_Renew_No'))
				document.getElementById('auth_Renew_No').disabled = false;
				if(document.getElementById('SelectTemp22'))
				document.getElementById('SelectTemp22').style.display = 'block';
				if(document.getElementById('SelectTemp11'))
				document.getElementById('SelectTemp11').style.display = 'block';
				if(document.getElementById('docAttachmentDiv'))
				document.getElementById('docAttachmentDiv').style.display = 'block';
			}  
		    else if (radiomenu.value == "Amendment") 
		    { 
				if(document.getElementById('auth_Renew_No'))
				document.getElementById('auth_Renew_No').disabled = false;
				if(document.getElementById('SelectTemp22'))
				document.getElementById('SelectTemp22').style.display = 'block';
				if(document.getElementById('SelectTemp11'))
				document.getElementById('SelectTemp11').style.display = 'block';
				if(document.getElementById('docAttachmentDiv'))
				document.getElementById('docAttachmentDiv').style.display = 'none';
			} 
		}  
	}
}







// this calculator created by shashank

function Calculate()
{
 //  alert("inside calculate");
  
   var  capitalinvestment=document.getElementById('capInv').value; 
		
	var result;
	
	var ValidationRequired;
	
	ValidationRequired="/^.*(?=.*[0-9]).*$/";

	// Calculating applicable consent fee based on above selection	
			if(capitalinvestment<60)
   		{
   	
   			result=1500
   		//	alert("result<60"+result)
    	}  
    	else if(capitalinvestment>=60 && capitalinvestment<300){
    	     result=2000
   		//	alert("result>=60 && <=300"+result)
       	}  	
       else if(capitalinvestment>=300 && capitalinvestment<500){
    	     result=2500
   			//alert("result>=60 && <=300"+result)
       	}  
       	 else if(capitalinvestment>=500 && capitalinvestment<1000){
    	     result=3000
   		//	alert("result>=500 && <=1000"+result)
       	} 
       	else if(capitalinvestment>=1000 && capitalinvestment<2000){
    	     result=3500
   		//	alert("result>=1000 && <=2000"+result)
       	} 
       	else if(capitalinvestment>=2000 && capitalinvestment<3000){
    	     result=4000
   		//	alert("result>=2000 && <=3000"+result)
       	}  
       	else if(capitalinvestment>=3000 && capitalinvestment<5000){
    	     result=4500
   		//	alert("result>=3000 && <=5000"+result)
       	} 
       	else if(capitalinvestment>=5000 && capitalinvestment<10000){
    	     result=5000
   		//	alert("result>=5000 && <=10000"+result)
       	}  
       	else if(capitalinvestment>=10000 && capitalinvestment<50000){
    	     result=6000
   		//	alert("result>=10000 && <=50000"+result)
       	} 
       	else if(capitalinvestment>=50000 && capitalinvestment<100000){
    	     result=7000
   		//	alert("result>=50000 && <=100000"+result)
       	} 
       	 	else if(capitalinvestment>=100000 && capitalinvestment<500000){
    	     result=7500
   		//	alert("result>=50000 && <=100000"+result)
       	}     
       		else if(capitalinvestment>=500000 ){
    	     result=8000
   		//	alert("result>=500000 "+result)
       	}
              	
    	    	
    	
		var feeApp = document.getElementsByName('feeApplicable');
	//	alert("feeApp" +(document.getElementsByName('feeApplicable')[0]).value+"sss "+feeApp[0].value+"result"+result);
		
			if( feeApp != null){
				
				//alert("asas");
				feeApp[0].value=result*((document.getElementsByName('yearsApplied')[0]).value);
				
		    	//alert("feeApp...." +(document.getElementsByName('feeApplicable')[0]).value+"Fee Applicable : "+feeApp[0].value+"typeOfHce.."+typeOfHce+"  bed no.."+bedOfNo);
			}
	return true;

}

function change1()
{
var generatinghazardousObj=document.getElementById('generatinghazardous1').value

if(generatinghazardousObj=="YES")
{
document.getElementById('generatinghazardous').style.display = 'block';
}
else{
document.getElementById('generatinghazardous').style.display = 'none';
}
}



		</script>	


<script language="javascript" type="text/javascript">
function redirecty()
 {
 select2();
 }
</script>
</head>
<body>

	
		<table id="" width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
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
							<td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
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
								                        <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="wasteManagementAdminVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="wasteManagementEmpVertical"/> 
					                        <%    }
						                  		} %>
								         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
								               	<g:include controller="userMaster" action="showIndexMenu"/>            
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
														<img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" />
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
																if((UserMaster)session.getAttribute("userMaster"))
																{
															%>
															<tr bgcolor="#4C8BC0">
																<td class="top-lnks">
																	<table width="100%">
																		<tr height="10px">
																			<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
																			<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
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
																			<td class="top-lnks" align="right">Date :&nbsp;<%=date %>-<%=month %>-<%=year %></td>
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
												<g:def var="appForWhich1" value="HWM"/><g:def var="applicationId" value="${hazardeousWasteAuthAppInstance.id}"/>
												
												<tr>
												<td class="headngblue">
												 <% if(  (IndUser)session.getAttribute("indUser")  )
										           { 
										            }
										            else {%>
										            
										            <%  def WasteManagementPendingDetailsobj=WasteManagementPendingDetails.findWhere(applicationId:(hazardeousWasteAuthAppInstance.id).toString(),applicationFor:'HWM')%>
										            <%if(WasteManagementPendingDetailsobj){%>
										            <a href="#" onclick="window.open('<g:createLink controller="wasteManagementProcessingDetails" action="openApplicationDetails" params="[docName:appForWhich1,appliId:applicationId]" ></g:createLink>', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
										            <% } }%>
												
												<g:if test="${hazardeousWasteAuthAppInstance?.applicationStatus =='approved'}">
												
													
													<%
														def certUpload = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='HWM' and afr.typeOfFile='uploaded' order by afr.id desc",[hazardeousWasteAuthAppInstance.id.toLong()])
		   												System.out.println("certUpload"+certUpload)
		   												if(certUpload){ %>
														<g:link controller="wasteManagementProcessingDetails" action="viewUploadedHazCert"  id="${hazardeousWasteAuthAppInstance.id}" ><span class="headngblue">&nbsp;View Uploaded Certificate&nbsp;</span></g:link>
													<%}%>
													
												</g:if>
												<g:if test="${hazardeousWasteAuthAppInstance?.applicationStatus =='rejected'}">
												
												
												<%
													def certUpload = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor='HWM' and afr.typeOfFile='uploaded' order by afr.id desc",[hazardeousWasteAuthAppInstance.id.toLong()])
	   												if(certUpload){ %>
													<g:link controller="wasteManagementProcessingDetails" action="viewUploadedHazCert"  id="${hazardeousWasteAuthAppInstance.id}" ><span class="headngblue">&nbsp;View Uploaded Certificate&nbsp;</span></g:link>
												<%}%>
												
											</g:if>
												</td>
												
												</tr>
												<tr>
													<td height="0" align="left" valign="top">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															<g:if test="${hazardeousWasteAuthAppInstance?.completionStatus=='Completed'}">
															<tr>
																<td align="right"   valign="top" class="headngblue">
																	<a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewFormPdf?appliLoc=<%=hazardeousWasteAuthAppInstance?.id%>"><span class="headngblue">Download Form</span></a>
																</td>
															</tr>
															</g:if>
															<tr>
																<!-- Div area for errors-->
																<td align="center" valign="top">
																	<div style="width: 500px; height: 20px; vertical-align: middle">
																		<span class="error"> 
																			<g:if test="${flash.message}">
																				<div class="message">${flash.message}</div>
																			</g:if>
																			<g:hasErrors bean="${indUserInstance}">
																				<div class="errors">
																					<g:renderErrors	bean="${indUserInstance}" as="list" />
																				</div>
																			</g:hasErrors>
																			<g:hasErrors bean="${indRegMasterInstance}">
																				<div class="errors">
																					<g:renderErrors bean="${indRegMasterInstance}" as="list" />
																				</div>
																			</g:hasErrors>
																		</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="0" align="left" valign="top">
																	<table width="100%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																			
																			<td align="left" valign="top">
																				<div style="padding: 0px 0px 0px 0px;">
																					<div style="" :1px solidgray; width:900px; margin-bottom: 1em; padding: 10px" >
																						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
																							<tr valign="middle">
																								<td width="100%" align="center">
																									<ol id="toc">
																										<li><a href="#country1"><span>General Details</span></a></li>
																									    <li><a href="#country2"><span>Hazardous Waste Generation Details</span></a></li>
																										<li><a href="#country3"><span>HW Generators </span></a></li>
																										<li><a href="#country4"><span>TSDF operators </span></a></li>
																										<li><a href="#country5"><span>Recyclers/Pre-processors/Co-processors/Users </span></a></li>
																										<li><a href="#country7"><span>Fee</span></a></li>
																										<li><a href="#country6"><span>Documents</span></a></li>
																									</ol>
																								</td>
																								<td width="30%" align="right">
																								</td>
																							</tr>
																						</table>
																						
       <div id="country1" class="content">
			<div class="dialog">
				 <table>
						<tbody>
							   <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
									 <tr>
									 	 <td  align="center" colspan="2" valign="middle" bgcolor="lightgrey" class="headngblue"><b>Applicant Details</b></td>
                                     </tr> 

									<tr>
										<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hazardous waste handling/generation ? </td>
										<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">Yes
								          <!--<g:select class="txt4" from="['Yes','No']"  name="isHandlerGenerator" id="isHandlerGenerator" value="${hazardeousWasteAuthAppInstance.isHandlerGenerator}" disabled="true"></g:select>-->
									    </td>
									</tr>
								
									<tr>
										<td width="40%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Occupier Name<span style="color:red">*</span>: </td>
										<td width="60%" align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								          <input type="text"  class="txt4" id="applicantName" readonly  name="applicantName" value="${indRegInstance?.occName}" size="40"/> 
									    </td>
									</tr>
				
				 
									<%
									     def occupierDesignation
									     if(indRegInstance.occDesignation.equals("Others")){
											occupierDesignation=(indRegInstance.otherOccDesignation).toString()
								           }else{
								        	   occupierDesignation=(indRegInstance.occDesignation).toString()
								           }
							
									%>
									<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation<span style="color:red">*</span>: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
									  <input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" value="${occupierDesignation}" size="40"/>  </td>
									</tr> 
								    
								    <tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry/TSDF-Location Postal Address: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										 <!-- <input type="text"  class="txt4" readonly  value="${indRegInstance?.indAddress}" size="45"/>-->
										  <textarea name="indAddress" readonly rows="2" cols="40" id="pollutionControlSystems" maxlength="500" class="txt4">${indRegInstance?.indAddress}</textarea>
										</td>
									</tr> 
								    
								    <tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <!--<input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" value="${indRegInstance?.indName}" size="45"/>-->
										  <textarea name="indAddress" readonly rows="2" cols="40" id="pollutionControlSystems" maxlength="500" class="txt4">${indRegInstance?.indName}</textarea>
										  </td>
									</tr> 
									
									<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Address: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <!--<input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" value="${indRegInstance?.indAddress}"size="45" />-->
										  <textarea name="indAddress" readonly rows="2" cols="40" id="indAddress" maxlength="500" class="txt4">${indRegInstance?.indName}</textarea>
										  </td>
									</tr> 
									
								<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										<input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" value="${indRegInstance?.category}" size="20"/></td>
									</tr>
									
									
									
									<tr>
									<%def industrypobj=IndustryRegMaster.get(indRegInstance.id)
									 def xyz=industrypobj.industryType
									 %>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Type: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <!--<input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" size="45" value="${xyz}"  />-->
										  <textarea name="indAddress" readonly rows="2" cols="40" id="indAddress" maxlength="500" class="txt4">${xyz}</textarea>
										</td>
									</tr> 
									<!-- make a field hidden-->
									 <tr><td hidden="true" width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Hazardous waste generation?</td>
									<td hidden="true" width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue"> Yes
									
								</td></tr>
						      
						      <!--<tr><td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Already applied for Authorisation?<br>If Yes, please enter the details of previously issued authorization:</td>
						          <td bgcolor="#E8F6F9"  align="left" class="txt4" colspan="2">
					                  <g:select name="Auhorisation_status" id="importHazard" from="['NO','YES']" disabled="true" value="${hazardeousWasteAuthAppInstance.Auhorisation_status}" onclick="javascript:select2()" class="txt4">
									  </g:select>	
									  <table style="display:none; border:4px;"  id="selectTemp2">
											<tr>
											<td width="100%" class="headngblue" align="center">
											                                                           
									                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a>                                               
									                  
									        </td>
											</tr>
									  </table>
							      </td>
							  </tr>-->
						
		                 	<tr>
								<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization now Applied For :</td>
								<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
								   
									<input name="is_Renew" id="radioIs_Renew" type="radio"  disabled="true" value="Fresh" onclick="hidediv();" checked="checked"  />
									Fresh 
									<g:if test="${hazardeousWasteAuthAppInstance.is_Renew=='Renew'}">
									<input name="is_Renew" id="radioIs_Renew" type="radio"  disabled="true" value="Renew" onclick="hidediv();" checked="checked" />
									</g:if>
									<g:else>
									<input name="is_Renew" id="radioIs_Renew" type="radio"  disabled="true" value="Renew" onclick="hidediv();" />
									</g:else>
									Renew
									<g:if test="${hazardeousWasteAuthAppInstance.is_Renew=='Amendment'}">
									<input name="is_Renew" id="radioIs_Renew" type="radio"  disabled="true" value="Amendment" onclick="hidediv();" checked="checked"/>
									</g:if>
									<g:else>
									<input name="is_Renew" id="radioIs_Renew" type="radio"  disabled="true" value="Amendment" onclick="hidediv();" />
									</g:else>
									Amendment
								</td>
		                    </tr>

 
	  
	  
						  <tr>
							<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization Required for*: </td>
							<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
							   <table style="width:100%;">
							       <tr><th><b style="color:black;">i.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Generation</td><td><input title="Generation" type="checkbox" disabled="true" name="chkGeneration" id="chkGeneration" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Generation(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">ii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Collection</td><td><input title="Collection" type="checkbox" disabled="true" name="chkCollection" id="chkCollection" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Collection(.*)')}">checked</g:if>/></td></tr>
								   <tr><th><b style="color:black;">iii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Storage</td><td><input title="Storage" type="checkbox" disabled="true" name="chkStorage" id="chkStorage" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Storage(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">iv.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Transportation</td><td><input title="Transportation"  type="checkbox" disabled="true" name="chkTransportation" id="chkTransportation" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Generation(.*)')}">checked</g:if>/></td></tr>
								   <tr><th><b style="color:black;">v.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Reception</td><td><input title="Reception" type="checkbox" disabled="true" name="chkReception" id="chkReception" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Reception(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">vi.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Reuse</td><td><input title="Reuse" type="checkbox" disabled="true" name="chkReuse" id="chkReuse" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Reuse(.*)')}">checked</g:if>/></td></tr>
								   <tr><th><b style="color:black;">vii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Recycling</td><td><input title="Recycling" type="checkbox" disabled="true" name="chkRecycling" id="chkRecycling" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Recycling(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">viii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Recovery</td><td><input title="Recovery" type="checkbox" disabled="true" name="chkRecovery" id="chkRecovery" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Recovery(.*)')}">checked</g:if>/></td></tr>
								   <tr><th><b style="color:black;">ix.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Pre-processing</td><td><input title="Pre-processing" type="checkbox" disabled="true" name="chkPre-processing" id="chkPre-processing" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Pre-processing(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">x.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Co-processing</td><td><input title="Co-processing" type="checkbox" disabled="true" name="chkCo-processing" id="chkCo-processing" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Co-processing(.*)')}">checked</g:if>/></td></tr>
								   <tr><th><b style="color:black;">xi.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Utilisation</td><td><input title="Utilisation" type="checkbox" disabled="true" name="chkUtilisation" id="chkUtilisation" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Utilisation(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">xii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Treatment</td><td><input title="Treatment" type="checkbox" disabled="true" name="chkTreatment" id="chkTreatment" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Treatment(.*)')}">checked</g:if>/></td></tr>
								   <tr><th><b style="color:black;">xiii.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Disposal</td><td><input title="Disposal" type="checkbox" disabled="true" name="chkDisposal" id="chkDisposal" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Disposal(.*)')}">checked</g:if>/></td>
								       <th><b style="color:black;">xiv.</b></th><td style="cursor:pointer" onclick="checkThis(this)">Incineration</td><td><input title="Incineration" type="checkbox" disabled="true" name="chkIncineration" id="chkIncineration" <g:if test="${hazardeousWasteAuthAppInstance.authorization_Required_For.matches('(.*)Incineration(.*)')}">checked</g:if>/></td></tr>
								</table>
							</td>
						  </tr>
		
							<tr>
							    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Whether the industry works general/2 shifts/round the clock?</td>
								<td width="60%" bgcolor="#E8F6F9"  align="left" >
								<span class="headngblue"></span>&nbsp;<g:select disabled="true"  value="${hazardeousWasteAuthAppInstance.industrywork}" name="industrywork" from="['one shifts','two shifts','Round the clock']" id="industrywork" class="txt4" onchange="change1();">
								</g:select>
								</td>
						   </tr>
						   <%
		                   def applicationDoc1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of the Emergency Response Plan' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc2 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Undertaking or declaration to comply' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc3 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Manufacturing process with flow sheet' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc4 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Hazardous and other wastes generated from storage' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc5 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Furnish installed capacity as per registration' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc6 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Process description including process flow sheet' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc7 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Facility been set up as per Central Pollution Control Board' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc8 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Layout map of the TSDF' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc9 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of prior Environmental Clearance' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc11 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='renewal of Authorisation' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc12 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of any other activities' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc13 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of secured storage of wastes' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc14 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of end users of products' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc15 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of pollution control systems' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def applicationDoc16 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Central Pollution Control Board guidelines' and abc.applicationId=? and abc.resubmittedDoc=false order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
							
						   ////// For resubmitted doc
						   def resubmitDoc1 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of the Emergency Response Plan' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc2 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Undertaking or declaration to comply' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc3 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Manufacturing process with flow sheet' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc4 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Hazardous and other wastes generated from storage' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc5 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Furnish installed capacity as per registration' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc6 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Process description including process flow sheet' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc7 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Facility been set up as per Central Pollution Control Board' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc8 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Layout map of the TSDF' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc9 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Copy of prior Environmental Clearance' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc11 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='renewal of Authorisation' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc12 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of any other activities' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc13 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of secured storage of wastes' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc14 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of end users of products' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc15 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Details of pollution control systems' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
						   def resubmitDoc16 = WasteManagementFile.findAll("from WasteManagementFile abc where abc.applicationFor='HWM' and abc.typeOfFile='Application Document' and abc.description='Central Pollution Control Board guidelines' and abc.applicationId=? and abc.resubmittedDoc=true order by abc.id desc",[hazardeousWasteAuthAppInstance.id]);
							
						   
						   
						   //System.out.println("TTTTT"+applicationDoc7);
						   %>
						   <tr>
							 <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">
							     Provide copy of the Emergency Response Plan (ERP) which should address procedures for dealing with emergency situations (viz. Spillage or release or fire) as specified in the guidelines of Central Pollution Control Board. Such ERP shall comprise the following, but not limited to:  
						           <ul><li>	Containing and controlling incidents so as to minimise the effects and to limit danger to the persons, environment and property;</li> 
						               <li>Implementing the measures necessary to protect persons and the environment;</li>  
						               <li>Description of the actions which should be taken to control the conditions at events and to limit their consequences, including a description of the safety equipment and resources available;</li> 
						               <li>Arrangements for training staff in the duties  which they are expected to perform;</li> 
						               <li>Arrangements for informing concerned authorities and emergency services; and </li> 
						               <li>Arrangements for providing assistance with off-site mitigatory action.</li> 
						            </ul>
						      </td>
						      <!--<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
						         Attached
								</td>-->
								<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
						        <%if(applicationDoc1){%>
								<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
								 <g:link action="viewDocumentRecy_1" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
							         <span class="innerlink"><u>Uploaded Document</u></span>
							   </g:link>
							    <%}%>
							    <br>
							    <%if(resubmitDoc1){%>
								<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
								 <g:link action="viewDocumentRecy_1" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
							         <span class="innerlink"><u>Resubmitted Document</u></span>
							   </g:link>
							    <%}%>
							</td>
							</tr>
	
							<tr>
							 <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">
							     Provide undertaking or declaration to comply with all provisions including the scope of submitting bank guarantee in the event of spillage, leakage or fire while handling the hazardous and other waste
						      </td>
							     <!--<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
						         Attached
								</td>-->
								<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
								 <%if(applicationDoc2){%>
									<g:def var="fooVar2" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
									 <g:link action="viewDocumentRecy_2" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar2,status:status]">
								         <span class="innerlink"><u>Uploaded Document</u></span>
								   </g:link>
								  <%}%>
								  <br>
								  <%if(resubmitDoc2){%>
									<g:def var="fooVar2" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
									 <g:link action="viewDocumentRecy_2" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar2,status:status]">
								         <span class="innerlink"><u>Resubmitted Document</u></span>
								   </g:link>
								  <%}%>
							</td>
							</tr>
							
							<tr>
								<td colspan="2">
								<div id="docAttachmentDiv" <g:if test="${hazardeousWasteAuthAppInstance.is_Renew!='Renew'}">style="display:none;"</g:if> >
								 <table><tr><td width="60%" bgcolor="#A8DAF3" align="left" class="headngblue">
								     In case of renewal of Authorisation, furnish details  of annual returns furnished for last three years including the compliance reports with respect to the conditions of Prior Environmental Clearance, wherever applicable
							      </td>
								     <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
									 <%if(applicationDoc11){%>
										<g:def var="fooVar2" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
										 <g:link action="viewDocumentRecy_11" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar2,status:status]">
									         <span class="innerlink"><u>Uploaded Document</u></span>
									   </g:link>
									  <%}%>
									  <br>
									  <%if(resubmitDoc11){%>
										<g:def var="fooVar2" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
										 <g:link action="viewDocumentRecy_11" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar2,status:status]">
									         <span class="innerlink"><u>Resubmitted Document</u></span>
									   </g:link>
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
		
          
        <div id="country2" class="content">
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
	            <tr>
	                <td bgcolor="#FFFFFF">
		                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
		                <input type="hidden" id='appId' name="appId" value="${appId}" />
		                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			                   <tr>
									<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">Hazardous Waste Generation Details<span style="color:red">*</span></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popHazardActivityGenDetailsViewNewFormat/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
									
			                    </tr> 
                 	  </table>
		           </td>
		         </tr>
		   </table>		
       </div>		
       
       <div id="country3" class="content">
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
	            <tr>
	                <td bgcolor="#FFFFFF">
		                
		                <input type="hidden" id='appId' name="appId" value="${appId}" />
		                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			                   <tr>
									<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are you a generator of hazardous waste ? </td>
									<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
									     <g:select class="txt4" disabled="true" onchange="hideShow(this)" from="['No','Yes']"  value="${hazardeousWasteAuthAppInstance.isGenerator}" name="isGenerator" id="isGenerator"></g:select>
									</td>
							  </tr>
							  <tr>
							     <td colspan="3">
							     <%
					             def var=hazardeousWasteAuthAppInstance.isGenerator;
					           //  System.out.println("VINEET---"+var);
					             if(var=='Yes'){%>
							              <div id="isGeneratorDiv" >
									        <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Products and By products manufactured Per Annum </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													    <!-- <input name="prouctsManufactured" readonly id="prouctsManufactured" value="${hazardeousWasteAuthAppInstance.prouctsManufactured}" type="txt4" class="txt4" size="45">-->
													     <textarea name="prouctsManufactured" readonly rows="2" cols="40" id="prouctsManufactured" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.prouctsManufactured}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Manufacturing process with flow sheet indicating Input, Output and sources of HW generation ? </td>
													<!--<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Attached</td>-->
													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
											        <%if(applicationDoc3){%>
													<g:def var="fooVar3" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
													 <g:link action="viewDocumentRecy_3" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar3,status:status]">
												         <span class="innerlink"><u>Uploaded Document</u></span>
												   </g:link>
												    <%}%>
												    <br>
												    <%if(resubmitDoc3){%>
													<g:def var="fooVar3" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
													 <g:link action="viewDocumentRecy_3" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar3,status:status]">
												         <span class="innerlink"><u>Resubmitted Document</u></span>
												   </g:link>
												    <%}%>
												 </td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of characteristics and management of wastes within the plant: </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													<table style="width:100%;">
														<tr>
														<td class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popCharacteristicsAndManagementView/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a></td>
														
														</tr>
													</table>
													</td>
										        </tr>
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hazardous and other wastes generated from storage of hazardous chemicals as defined under the Manufacture, Storage and Import of Hazardous Chemicals Rules, 1989. </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													     <!--<input name="generatedWastes" readonly id="generatedWastes" value="${hazardeousWasteAuthAppInstance.generatedWastes}" type="txt4" class="txt4" size="45">-->
														<textarea name="generatedWastes" readonly rows="2" cols="40" id="generatedWastes" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.generatedWastes}</textarea>
													</td>
										        </tr>
										        
									        </table>
									    </div>
									       <%}%>
									    
								  </td>
						     </tr>
                 	  </table>
		           </td>
		         </tr>
		   </table>		
       </div>																				

          
        <div id="country4" class="content">
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
	            <tr>
	                <td bgcolor="#FFFFFF">
		                
		                
		                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			                   <tr>
									<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are you a TSDF operator ? </td>
									<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
									     <g:select class="txt4" disabled="true" onchange="hideShow(this)" from="['No','Yes']" value="${hazardeousWasteAuthAppInstance.isTSDFOperator}"  name="isTSDFOperator" id="isTSDFOperator"  ></g:select>
									</td>
							  </tr>
							  <tr>
							     <td colspan="3">
							     <%
					             def var12=hazardeousWasteAuthAppInstance.isTSDFOperator;
					            // System.out.println("VINEET Q---"+var12);
					             if(var12=='Yes'){%>
									     <div id="isTSDFOperatorDiv" >
									        <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Location address of  TSDF site</td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													     <!--<input readonly type="txt4" class="txt4" value="${indRegInstance?.indAddress}" size="50">-->
													     <textarea name="generatedWastes" readonly rows="2" cols="40" id="generatedWastes" maxlength="500" class="txt4">${indRegInstance?.indAddress}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the Safe storage of the waste and storage capacity </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="storageCapacity" id="storageCapacity" value="${hazardeousWasteAuthAppInstance.storageCapacity}" type="txt4" class="txt4" size="50">-->
													    <textarea name="storageCapacity" readonly rows="2" cols="40" id="storageCapacity" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.storageCapacity}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the treatment processes and their capacities  </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="treatmentProcesses" id="treatmentProcesses" value="${hazardeousWasteAuthAppInstance.treatmentProcesses}" type="txt4" class="txt4" size="50">-->
													    <textarea name="treatmentProcesses" readonly rows="2" cols="40" id="treatmentProcesses" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.treatmentProcesses}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the secured landfills </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="securedLandfills" id="securedLandfills" value="${hazardeousWasteAuthAppInstance.securedLandfills}" type="txt4" class="txt4" size="50">-->
													    <textarea name="securedLandfills" readonly rows="2" cols="40" id="securedLandfills" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.securedLandfills}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the Incineration, if any </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													   <!-- <input readonly name="detailOfIncineration" id="detailOfIncineration" value="${hazardeousWasteAuthAppInstance.detailOfIncineration}" type="txt4" class="txt4" size="50">-->
													    <textarea name="detailOfIncineration" readonly rows="2" cols="40" id="detailOfIncineration" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.detailOfIncineration}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the leachate collection and treatment system </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="treatmentSystem" id="treatmentSystem" type="txt4" value="${hazardeousWasteAuthAppInstance.treatmentSystem}" class="txt4" size="50">-->
													    <textarea name="treatmentSystem" readonly rows="2" cols="40" id="treatmentSystem" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.treatmentSystem}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the fire fighting systems </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="fireFightingSystems" id="fireFightingSystems" value="${hazardeousWasteAuthAppInstance.fireFightingSystems}" type="txt4" class="txt4" size="50">-->
													    <textarea name="fireFightingSystems" readonly rows="2" cols="40" id="fireFightingSystems" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.fireFightingSystems}</textarea>
													    
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the environmental management plan including monitoring </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="environmentalManagementPlan" id="environmentalManagementPlan" value="${hazardeousWasteAuthAppInstance.environmentalManagementPlan}" type="txt4" class="txt4" size="50">-->
													    <textarea name="environmentalManagementPlan" readonly rows="2" cols="40" id="environmentalManagementPlan" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.environmentalManagementPlan}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of the arrangement for transportation of waste from generators </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													   <!-- <input readonly name="transportation" id="transportation" type="txt4" value="${hazardeousWasteAuthAppInstance.transportation}" class="txt4" size="50">-->
													    <textarea name="transportation" readonly rows="2" cols="40" id="transportation" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.transportation}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of any other activities undertaken at the Treatment, storage and disposal facility site </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
													    <!--<input readonly name="otherActivities" id="otherActivities" value="${hazardeousWasteAuthAppInstance.otherActivities}" type="text" class="txt4" size="50">
													     <textarea name="otherActivities" readonly rows="2" cols="40" id="otherActivities" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.otherActivities}</textarea>-->
													     <%if(applicationDoc12){%>
															<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
															 <g:link action="viewDocumentRecy_12" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
														         <span class="innerlink"><u>Uploaded Document</u></span>
														   </g:link>
														    <%}%>
														    <br>
														    <%if(resubmitDoc12){%>
															<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
															 <g:link action="viewDocumentRecy_12" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
														         <span class="innerlink"><u>Resubmitted Document</u></span>
														   </g:link>
														    <%}%>
													     </td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Layout map of the TSDF </td>
													<!--<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Attached</td>-->
													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
											        <%if(applicationDoc8){%>
													<g:def var="fooVar8" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
													 <g:link action="viewDocumentRecy_8" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar8,status:status]">
												         <span class="innerlink"><u>Uploaded Document</u></span>
												   </g:link>
												    <%}%>
												    <br>
												    <%if(resubmitDoc8){%>
													<g:def var="fooVar8" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
													 <g:link action="viewDocumentRecy_8" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar8,status:status]">
												         <span class="innerlink"><u>Resubmitted Document</u></span>
												   </g:link>
												    <%}%>
												 </td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Copy of prior Environmental Clearance </td>
													<!--<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Attached</td>-->
													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
											        <%if(applicationDoc9){%>
													<g:def var="fooVar9" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
													 <g:link action="viewDocumentRecy_9" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar9,status:status]">
												         <span class="innerlink"><u>Uploaded Document</u></span>
												   </g:link>
												    <%}%>
												    <br>
												    <%if(resubmitDoc9){%>
													<g:def var="fooVar9" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
													 <g:link action="viewDocumentRecy_9" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar9,status:status]">
												         <span class="innerlink"><u>Resubmitted Document</u></span>
												   </g:link>
												    <%}%>
												 </td>
										        </tr>
										        
									        </table>
									    </div>
									    <%}%>
								  </td>
						     </tr>
                 	  </table>
		           </td>
		         </tr>
		   </table>		
       </div>																				
          
          
           <div id="country5" class="content">
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
	            <tr>
	                <td bgcolor="#FFFFFF">
		                
		                <input type="hidden" id='appId' name="appId" value="${appId}" />
		                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			                   <tr>
									<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Are you a recyclers or pre-processors or co-processors or users of hazardous or other wastes ? </td>
									<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
									     <g:select class="txt4" disabled="true" onchange="hideShow(this)" from="['No','Yes']"  value="${hazardeousWasteAuthAppInstance.isRecyclerOrUsers}" name="isRecyclerOrUsers" id="isRecyclerOrUsers"  ></g:select>
									</td>
							  </tr>
							  <tr>
							     <td colspan="3">
									     <div id="isRecyclerOrUsersDiv" <g:if test="${hazardeousWasteAuthAppInstance.isRecyclerOrUsers!='Yes'}">style="display:none;"</g:if> >
									        <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
										        
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Nature and quantity of different commonly recyclable hazardous wastes in Schedule-IV procured per annum from domestic sources or imported or both: </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
														<table style="width:100%;">
														<tr>
														<td class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popRecyclableHazardousWasteView/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
														</tr>
														</table>
													</td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Furnish installed capacity as per registration issued by the District Industries Centre or any other authorised Government agency  </td>
													<!--<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Attached</td>-->
													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
											        <%if(applicationDoc5){%>
													<g:def var="fooVar5" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
													 <g:link action="viewDocumentRecy_5" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar5,status:status]">
												         <span class="innerlink"><u>Uploaded Document</u></span>
												   </g:link>
												    <%}%>
												    <br>
												    <%if(resubmitDoc5){%>
													<g:def var="fooVar5" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
													 <g:link action="viewDocumentRecy_5" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar5,status:status]">
												         <span class="innerlink"><u>Resubmitted Document</u></span>
												   </g:link>
												    <%}%>
												 </td>
										        </tr>
										        
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of secured storage of wastes including the storage capacity</td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													  <%if(applicationDoc13){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
														 <g:link action="viewDocumentRecy_13" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Uploaded Document</u></span>
													   </g:link>
													    <%}%>
													    <br>
													    <%if(resubmitDoc13){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
														 <g:link action="viewDocumentRecy_13" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Resubmitted Document</u></span>
													   </g:link>
													    <%}%>
													    </td>
										        </tr>
										        
										        <tr>
													<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Process description including process flow sheet indicating equipment details, inputs and outputs (input wastes, chemicals, products, by-products, waste generated, emissions, waste water, etc.)  </td>
													<!--<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Attached</td>-->
													<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;&nbsp;
											        <%if(applicationDoc6){%>
													<g:def var="fooVar6" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
													 <g:link action="viewDocumentRecy_6" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar6,status:status]">
												         <span class="innerlink"><u>Uploaded Document</u></span>
												   </g:link>
												    <%}%>
												    <br>
												    <%if(resubmitDoc6){%>
													<g:def var="fooVar6" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
													 <g:link action="viewDocumentRecy_6" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar6,status:status]">
												         <span class="innerlink"><u>Resubmitted Document</u></span>
												   </g:link>
												    <%}%>
												 </td>
										        </tr>
										        
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of end users of products or by-products </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													 <%if(applicationDoc14){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
														 <g:link action="viewDocumentRecy_14" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Uploaded Document</u></span>
													   </g:link>
													    <%}%>
													    <br>
													    <%if(resubmitDoc14){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
														 <g:link action="viewDocumentRecy_14" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Resubmitted Document</u></span>
													   </g:link>
													    <%}%>
													    </td>
										        </tr>
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of pollution control systems such as Effluent Treatment Plant, scrubbers, etc. including mode of disposal of waste </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													 <%if(applicationDoc15){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
														 <g:link action="viewDocumentRecy_15" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Uploaded Document</u></span>
													   </g:link>
													    <%}%>
													    <br>
													    <%if(resubmitDoc15){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
														 <g:link action="viewDocumentRecy_15" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Resubmitted Document</u></span>
													   </g:link>
													    <%}%>
													    </td>
										        </tr>
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of occupational health and safety measures </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													     <!--<input name="safetyMeasures" id="safetyMeasures" type="txt4" value="${hazardeousWasteAuthAppInstance.safetyMeasures}" class="txt4" size="50">-->
													     <textarea name="safetyMeasures" readonly rows="2" cols="40" id="safetyMeasures" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.safetyMeasures}</textarea>
													</td>
										        </tr>
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Has the facility been set up as per Central Pollution Control Board guidelines? If yes, provide a report on the compliance with the guidelines </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													 <%if(applicationDoc16){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="false"/>
														 <g:link action="viewDocumentRecy_16" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Uploaded Document</u></span>
													   </g:link>
													    <%}%>
													    <br>
													    <%if(resubmitDoc16){%>
														<g:def var="fooVar1" value="${hazardeousWasteAuthAppInstance.id}"/><g:def var="status" value="true"/>
														 <g:link action="viewDocumentRecy_16" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar1,status:status]">
													         <span class="innerlink"><u>Resubmitted Document</u></span>
													   </g:link>
													    <%}%>
													    </td>
										        </tr>
										        
										        <tr>
													<td  style="width:60%;" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Arrangements for transportation of waste to the facility </td>
													<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
													     <!--<input readonly name="transportationUsers" id="transportationUsers" type="txt4" value="${hazardeousWasteAuthAppInstance.transportationUsers}" class="txt4" size="50">-->
													     <textarea name="transportationUsers" readonly rows="2" cols="40" id="transportationUsers" maxlength="500" class="txt4">${hazardeousWasteAuthAppInstance.transportationUsers}</textarea>
													</td>
										        </tr>
										        
									        </table>
									    </div>
								  </td>
						     </tr>
                 	  </table>
		           </td>
		         </tr>
		   </table>		
       </div>			
		
		     <!--new div added by shashank-->
          
          
          <div class="content" id="country7">
		  
		  <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">	
		  
		   <%
		   
	       def capInv = indRegInstance.indCapInvt.toInteger()
	       
	       def calculatedfee = ConsentFeeMasterHWM.findByApplication(hazardeousWasteAuthAppInstance)
	 
	 
          %>		
	           
				
					
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Investment : </td>
					<td  align="left" bgcolor="#E8F6F9" class="headngblue">${capInv}
					&nbsp;<span class="sidetxt">(In Lakhs)</span></td>
				</tr> 
						
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><%if(calculatedfee){%>${calculatedfee.noOfYears}<%}%></td>
				</tr> 
				
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><%if(calculatedfee){%>${calculatedfee.calculatedFee} <%}%><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></td>
					
				</tr>  
			  
			</td></tr>
	
				
				
				<!--strat by shashank-->
				<%
									
								def feesOnline = FeeBankOtherDetailsHWM.find("from FeeBankOtherDetailsHWM fee where fee.application=?",[hazardeousWasteAuthAppInstance])
						    	def feesBank = FeeBankDetailsHWM.find("from FeeBankDetailsHWM fee where fee.application=?",[hazardeousWasteAuthAppInstance])
									
									
								def feesBankOnline = BankTransactionDetailsHWM.find("from BankTransactionDetailsHWM fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[hazardeousWasteAuthAppInstance])
 
                                def feesAlreadyPaid = FeeChequeRecordHWM.find("from FeeChequeRecordHWM fee where fee.indApplication=? and fee.level='Fee_Already_Paid' order by id desc",[hazardeousWasteAuthAppInstance])

                                                  %>
												
                                               <%if(feesOnline){%>
                                               <tr bgcolor="#417FB2">
				                             	<td colspan="2">
					                                <table width="100%" cellpadding="0" cellspacing="0">
					                             	<tr>
					                            	<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
					                              	<td  align="right" valign="middle"  class="headngblue"></td>
					                          	    </tr>
				                            	  </table>
					                             </td>
				                                </tr>
	                                                  <tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeOtherDetailsViewHWM/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>
											<%}%>				
											<%if(feesBank) {%>
														
														
												<tr bgcolor="#417FB2">
					                                 <td colspan="2">
					                                <table width="100%" cellpadding="0" cellspacing="0">
					                              	<tr>
					                               	<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Draft Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
					                               	<td  align="right" valign="middle"  class="headngblue"></td>
					                             	</tr>
					                              </table>
					                               </td>
				                                </tr>
														
													 <tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeDetailsViewHWM/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View </a></td>

																	</tr>
																</table>
																</td>
															</tr>	
														
														<%}%>
														
														<%if(feesBankOnline) {%>
														<tr bgcolor="#417FB2">
					                                    <td colspan="2">
					                                    <table width="100%" cellpadding="0" cellspacing="0">
					                              	    <tr>
					                                 	<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Online Payment Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
					                                 	<td  align="right" valign="middle"  class="headngblue"></td>
					                                 	</tr>
					                                    </table>
					                                    </td>
				                                        </tr>
				                                        
				                                        <tr>
																<td colspan="2">
																<table width="100%" border="0">
																	<tr>

																		<td width="10%" class="headngblue" align="center"><a
																			href="#"
																			onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popChallan/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
																		View Challan </a></td>

																	</tr>
																</table>
																</td>
															</tr>	
														
														<%}%>
																				
																						
				
				<!--end by shashank-->
				<%if(feesAlreadyPaid) {%>
	<tr bgcolor="#D1D1D1">
	<td colspan="2" align="center" valign="middle"
		class="headngblue">Payment Already Paid</td>
</tr>
<tr>
	<td colspan="2">
	<table width="100%" border="0">
		<tr>

			<td width="10%" class="headngblue" align="center">
			
			 <g:def var="fooVar" value="${hazardeousWasteAuthAppInstance.id}"/><g:link action="viewAlreadyPaidPdf" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar]"><span class="innerlink"><u>Money Reciept</u></span></g:link>
			
			
			</td>

		</tr>
	</table>
	</td>
</tr>
	<%}%>
				
	
	
			</table>	
			
  
  
  
          </div>
          
          
          
          <!--end by shashank-->  																				
		  <div class="content" id="country6">
               <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		           <tr>
		               <td bgcolor="#FFFFFF">
			               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				              <tr bgcolor="#417FB2">
					             <td colspan="2">
					                 <table width="100%" cellpadding="0" cellspacing="0">
						                  <tr>
						                       <td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Documents Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						                       <td  align="right" valign="middle"  class="headngblue"></td>
						                  </tr>
					                </table>
					             </td>
				              </tr>
				
				       <td colspan="4"><div id="hideShow">
					       <table width="100%" border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
								<tr bgcolor="#D1D1D1">
									<td colspan="2" align="center" valign="middle" class="headngblue">Documents Details</td>
								</tr>
															
								<g:each var="doc" in="${listDoc}">
										<tr>
											<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
											<td width="40%" align="left" bgcolor="#E8F6F9" class="headngblue">
											   <g:def var="fooVar" value="${hazardeousWasteAuthAppInstance.id}"/>
	      	                                   <g:def var="docN" value="${doc.description}"/>
	      	                                   <g:def var="docId"	value="${doc.id}"/>
			                                   <g:link  action="viewFileNewFormat" params="[appliLoc:fooVar,docName:docN,docType:'pdf',docId:docId]" >Download</g:link>
											</td>
										</tr>
								</g:each>
								<%if(listDoc1){%>
								<tr bgcolor="#D1D1D1">
								<td colspan="2" align="center" valign="middle" class="headngblue">Resubmitted Documents Details</td>
							</tr>
								<%}%>
								
								<g:each var="doc" in="${listDoc1}">
								<tr>
									<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
									<td width="40%" align="left" bgcolor="#E8F6F9" class="headngblue">
									   <g:def var="fooVar" value="${hazardeousWasteAuthAppInstance.id}"/>
  	                                   <g:def var="docN" value="${doc.description}"/>
  	                                   <g:def var="docId"	value="${doc.id}"/>
	                                   <g:link  action="viewFileNewFormat" params="[appliLoc:fooVar,docName:docN,docType:'pdf',docId:docId]" >Download</g:link>
									</td>
								</tr>
						</g:each>
							</table>
				      </td>
				  </tr>
		    </table>
		</div>
		</div>
		</div>
			</td>
				</tr>
		 	 </table>	  
					  
			 </td></tr>
			</table>	
			
			
			
			
		  	   						</div>
																			</td>
																		</tr>
																	</table>
																	<%
																	def editMode=false;
																	def appPending=WasteManagementPendingDetails.findByApplicationId((hazardeousWasteAuthAppInstance.id).toString());
																	System.out.println("appPending-----"+appPending);
																	if(appPending && appPending.applicationStatus=="rejected")
																	{
																	   def appProcessing=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? order by id desc",[(hazardeousWasteAuthAppInstance.id).toString()]);
																	   System.out.println("appProcessing---rejected--"+appProcessing);
																	   if(appProcessing){
																	   if((appProcessing.reject==true) && (appProcessing.resubmitStatus==false) )
																	   {  System.out.println("appProcessing.reject-"+appProcessing.reject);
																	      editMode=true;
																	   }
																	}}else if(appPending && appPending.applicationStatus=="returned"){
																		   def appProcessing=WasteManagementProcessingDetails.find("from WasteManagementProcessingDetails where applicationId=? order by id desc",[(hazardeousWasteAuthAppInstance.id).toString()]);
																		   System.out.println("appProcessing---returned--"+appProcessing);
																		   if(appProcessing){
																		   if((appProcessing.returned==true) && (appProcessing.resubmitStatus==false) ){
																			   System.out.println("appProcessing-----"+appProcessing.returned);
																			   editMode=true;
																			   
																		   }
																		}}
																	System.out.println("editMode-----"+editMode);
																	%>
																	<g:if test="${hazardeousWasteAuthAppInstance.completionStatus=='Inprogress' || editMode}">
																	<table width="95%">
																			<g:form name="general" method="post" action="editNewFormat">
														                        <tr>
															                          <input type="hidden" name="edit" value="1" />
															                          <input type="hidden" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>" />
															                          <input type="hidden" name="editMode" value="<%=editMode%>" />
																                       
															                          <td align="center">
															                          <input type="submit" name="Edit" value="Edit" class="actionbutton"></td>
														                          </tr>
														                     </g:form>
																			</td>
																		</tr>
																	</table>
																   </g:if>
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
					 		</td>
						</tr>
					
					</table>
				</td>
			</tr>
		</table>
	
		
	
		
	
	
	
	<script language="JavaScript" type="text/javascript">
	
	function checkThis(obj)
	{
	   var objValue=obj.innerHTML;
	   if(document.getElementById("chk"+objValue).checked == true)
	       document.getElementById("chk"+objValue).checked = false;
	   else
	       document.getElementById("chk"+objValue).checked = true;
	}
	
	function hideShow(obj)
	{
	  if(obj.value=="Yes")
	  {
	     document.getElementById(obj.id+"Div").style.display = "block";
	  }
	  else if(obj.value=="No")
	  {
	     document.getElementById(obj.id+"Div").style.display = "none";
	  }
	}
		
	
	</script>
	
	<script language="JavaScript" type="text/javascript">
	redirecty();
		</script>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
