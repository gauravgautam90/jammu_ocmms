<%@ page import="java.text.SimpleDateFormat;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
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
			
			
		</g:javascript>
		
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
</head>
<body>

	<form action="save" method="post" id="myform" name="myform" enctype="multipart/form-data">
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
								                        <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="eWasteEmpMenuVertical"/> 
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
															<tr>
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
												<tr>
													<td height="0" align="left" valign="top">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
																			<td width="82" align="left" valign="top">
																				&nbsp;
																			</td>
																			<td align="left" valign="top">
																				<div style="padding: 0px 0px 0px 0px;">
																					<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
																					<table width="764"  border="0" align="center" cellpadding="0" cellspacing="0"  >
																						<tr valign="middle" width="100%">
                 																							 <td  width="100%" align="left" >
																									<ol id="toc">
                                                                                                        <%  ArrayList temp = new ArrayList()
                                                                                                        def temp1= eWasteInstance.checkBoxButton
                                                                                                        temp = temp1.split(",")

                                                                                                       
                                                                                                        if(eWasteInstance.authorisationType=='chkManufactureOrRefurbisher'){
                                                                                                        
                                                                                                        
                                                                                                        %>
                                                                                                            <li><a href="#country1"><span>General Details</span></a></li>
                                                                                                            <li><a href="#country8"><span>Manufacture/Refurbisher</span></a></li>
                                                                                                            <li><a href="#country4"><span>Documents</span></a></li>
																										<%}else if(eWasteInstance.authorisationType=='chkDismantlerOrRecycler'){%>
                                                                                                            <li><a href="#country1"><span>General</span></a></li>
                                                                                                            <li><a href="#country2"><span>Product</span></a></li>
                                                                                                            <li><a href="#country5"><span>Waste Management</span></a></li>
                                                                                                            <li><a href="#country7"><span>Other</span></a></li>
                                                                                                            <li><a href="#country4"><span>Documents</span></a></li>
                                                                                                        <%}else{%>
                                                                                                            <li><a href="#country1"><span>General</span></a></li>
                                                                                                            <li><a href="#country2"><span>Product</span></a></li>
                                                                                                            <!--<li><a href="#country3"><span>Water Consumption</span></a></li>
                                                                                                            <li><a href="#country6"><span>Air Pollution Control</span></a></li>-->
                                                                                                            <li><a href="#country5"><span>Waste Management</span></a></li>
                                                                                                            <li><a href="#country8"><span>Manufacture/Refurbisher</span></a></li>
                                                                                                            <li><a href="#country7"><span>Other</span></a></li>
                                                                                                            <li><a href="#country4"><span>Documents</span></a></li>
                                                                                                        <%}%>
																									</ol>
																								</td>
																								
																							</tr>
																						</table>
																						<div id="country1" class="content">
																							
																							<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  
			
			
			 <tr><td bgcolor="#FFFFFF">
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
			<input name="wasteType" type="hidden"  class="txt4" value="${wasteType}"/>
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Industry Details </span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>  
			
		
																											<tr>
																		    									<td  width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the Unit :</td>
																		    									<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
																		    										<input name="indName" type="text" size="30" maxlength="25" readOnly="readonly" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indName')}" />
																												</span></td>
																		 									 </tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Address :</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="indAddress" type="text"  size="30" readOnly="readonly" maxlength="100" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indAddress')}" />
																												</td>
																		 								 	</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Name of the occupier :</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="occName" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'occName')}" />
																		    								<input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=eWasteInstance%>"/>
						                                                                            <input type="hidden" id="indRegId" name="indRegId"  value="${indRegInstance?.id}"/>
			 	
																		    									
																		    									
																		    									</td>
																		  									</tr>
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Designation of the occupier :</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="occDesignation" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'occDesignation')}" />
																		    								</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Phone No. With Code :</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="occPhoneCode" type="text" readOnly="readonly" maxlength="10" class="txt4" value="${fieldValue(bean:indRegInstance,field:'occPhoneCode')}" size="10" AUTOCOMPLETE=OFF /> 
																		    										<input name="occPhoneNo" type="text" readOnly="readonly" maxlength="10" class="txt4" value="${fieldValue(bean:indRegInstance,field:'occPhoneNo')}"	size="15" AUTOCOMPLETE=OFF />
																		    								</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Fax No. With Code :</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="occFaxCode" type="text" readOnly="readonly" maxlength="10"	class="txt4" value="${fieldValue(bean:indRegInstance,field:'occFaxCode')}" size="10" AUTOCOMPLETE=OFF />
																		    										 <input name="occFaxNo" type="text" readOnly="readonly" class="txt4" value="${fieldValue(bean:indRegInstance,field:'occFaxNo')}" size="15" maxlength="20" AUTOCOMPLETE=OFF />
																		    								</td>
																		  									</tr>
																		  									 <%
																		 									 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   	                                                                                                         def dateOfComm = sdf.format(indRegInstance.indRegNumDate)
																		 									 %>
																		  								<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Date of commissioning of the unit :</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="dateOfCom" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${dateOfComm}" />
			 	
																		    									
																		    									
																		    									</td>
																		  									</tr>
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">No. of workers(including contract labour):</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="noOfEmp" type="text"  size="30" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'noOfEmp')}" />
			 	
																		    									
																		    									
																		    									</td>
																		  									</tr>
																		  								
																		  			
																		  									<% System.out.println("VVVVVVVVVVVV.authorisationType---------"+eWasteInstance.authorisationType)%>
																		  									
																		  									
																		  									<% ///if(eWasteInstance.authorisationType=='chkDismantlerOrRecycler' || eWasteInstance.authorisationType=='Both'){%>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Water Consent From : </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    	<calendar:datePicker name="waterConsFrom" class="${hasErrors(bean:eWasteInstance,field:'waterConsFrom','errors')} " value="${eWasteInstance.waterConsFrom}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}" />

																		    									
																		    									
																		    									</td>
																		  									</tr>
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Water Consent To : </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    			<calendar:datePicker name="waterConsTo" class="${hasErrors(bean:eWasteInstance,field:'waterConsTo','errors')} " value="${eWasteInstance.waterConsTo}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
									</td>
																		  									</tr>	
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Air Consent From : </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    	<calendar:datePicker name="airConsFrom" class="${hasErrors(bean:eWasteInstance,field:'airConsFrom','errors')} " value="${eWasteInstance.airConsFrom}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>

																		    									
																		    									
																		    									</td>
																		  									</tr>
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Air Consent To : </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    			<calendar:datePicker name="airConsTo" class="${hasErrors(bean:eWasteInstance,field:'airConsTo','errors')} " value="${eWasteInstance.airConsTo}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
									</td>
																		  									</tr>	
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">E-Waste Authorization From : </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    	<calendar:datePicker name="authorizationFrom" class="${hasErrors(bean:eWasteInstance,field:'authorizationFrom','errors')} " value="${eWasteInstance.authorizationFrom}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>

																		    									
																		    									
																		    									</td>
																		  									</tr>
																		  									
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">E-Waste Authorization To : </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    			<calendar:datePicker name="authorizationTo" class="${hasErrors(bean:eWasteInstance,field:'authorizationTo','errors')} " value="${eWasteInstance.authorizationTo}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
									</td>
																		  									</tr>	
																										<%//}%>
																								</table>	  
		
					  
			</td></tr>
			</table>		  
					                  
                     

				
          
          </div>
          
          
																					
																						<div id="country2" class="content">
																							
																							<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Product Details</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>

<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Production Details : Installed Capacity in MT/Year</td>
					<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductionDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">Add</span> </a></td>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductionDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductionDetailsedit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">Delete</span> </a></td>
								</tr>	
				</td>
				</table>
							</tr>
							
<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">E-Waste Processed during last three years :</td>
					<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">Add</span> </a></td>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopProductDetailsedit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">Delete</span> </a></td>
								</tr>	
				</td>
				</table>
							</tr>
			
				

						<tr bgcolor="#E8F6F9">
			
							<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Raw Material Details :</td>
							<td   align="left" valign="middle">
							<table width="100%">
							  <tr>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRawMaterialsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">Add</span> </a></td>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRawMaterialsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">View</span> </a></td>
								<td align="center"  class="headngblue"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRawMaterialsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > <span style="color: black">Delete</span> </a></td>
								</tr>	
				</td>
				</table>
							</tr>
													</table>
													</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the product details</li>
				<li>click "View" link to view the product details</li>
				<li>click "Delete" link to delete the product details</li>
				<li>To update the product delete, first delete the product details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>
           <br/>
          </div>
          
          	
					
          
          
          
          
		<div id="country3" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Water Consumption/Discharge</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			<tr bgcolor="#E8F6F9">
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Water Cess paid Upto :</td>
					
				<td align="left" bgcolor="#E8F6F9"  class="txt">
				
											<calendar:datePicker name="regDate" class="${hasErrors(bean:eWasteInstance,field:'regDate','errors')} " value="${eWasteInstance.regDate}" size="10" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
																	
																</td>
															</tr>	
<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Water Consumption Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterConsumptionDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterConsumptionDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterConsumptionDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td>
</tr>



<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste Water Generation Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterGenerationDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterGenerationDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterGenerationDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td>
</tr>


<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste Water Treatment Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterTreatmentDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterTreatmentDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterTreatmentDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td>
</tr>



<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste Water Discharge Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterDischargeDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterDischargeDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWaterDischargeDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td>
</tr>








</table>
</td></tr>
</table>

           <br/> 

           <%//}else{ %>
           <div class="headngblue" align="center"></div>
           
           <%//}%>
  		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There are three sections under W Emiss./Disch. Please fill all the details pertaining to W Emiss./Disch. To enter the details, use the links as follows:<>
			  &nbsp; 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the delete, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>           
          </div>
																					
		 <div id="country4" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Document Details</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
				<tr>
				</tr> 
				<tr>
				<td colspan="4"><div id="hideShow">
					<table width="100%" cellpadding="0" cellspacing="0">
				<tr bgcolor="#A8DAF3">
					<td width="35%" align="center" class="headngblue" valign="top">Upload Required Documents :</td>
					<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popUploadDoc/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Upload </a></td>
				</tr> 
				
				<tr bgcolor="#A8DAF3">
					<td width="35%" align="center" class="headngblue" valign="top">Delete Saved Documents :</td>
					<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/popDeleteDoc/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
				</tr> 
				
				
				</table>
				</div></td>
				</tr>
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  	   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  <ul> 
				<li>Click link "Upload" to upload the document</li>
				<li>Click "Browse" to select the document</li>
				<li>You can select multiple documents at the same time</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Click "Save" button to upload the document</li>
				<li>Message "Document successfully uploaded" will be displayed</li>
			  </ul>
		</div>
		<hr>
           <br/>
          </div>
         <div id="country6" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Air Pollution Control</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			
			<tr bgcolor="#E8F6F9">
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details for facilities provided for control of fugitive emission due to material handling, process, utilities etc :</td>
					
				<td align="left" bgcolor="#E8F6F9"  class="txt">
											<input name="fugEmission" type="text"  size="30"  maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:eWasteInstance,field:'fugEmission')} " />
											</td></tr>	
			
			
<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Fuel Consumption Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopFuelconsumptionAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopFuelconsumptionView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopFuelconsumptionEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td>
</tr>


<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Stack Emission Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopStackEmissionMonitoringAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopStackEmissionMonitoringView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopStackEmissionMonitoringEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td></tr>


<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Ambient Air Details :</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopAmbientAirStandardAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopAmbientAirStandardView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopAmbientAirStandardEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td></tr>








</table>
</td></tr>
</table>

           <br/> 

           <%//}else{ %>
           <div class="headngblue" align="center"></div>
           
           <%//}%>
  		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There is one section under Air Pollution Control. Please fill all the details pertaining to Air pollution To enter the details, use the links as follows :<>
			  &nbsp; 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the delete, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>           
          </div>
																	
				<div id="country5" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Waste Generation/Disposal</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
                <tr>
                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Treatment Storage and Disposal Facility Details :</td>

                    <td bgcolor="#E8F6F9" align="left" class="headngblue"><input name="disposal" type="text" size="20" class="txt4" value="${fieldValue(bean:eWasteInstance,field:'disposal')} "/>

                    </td>
                </tr>


                <tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Waste generation Details in processing E-Waste:</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteGenDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteGenDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteGenDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td></tr>

<tr bgcolor="#E8F6F9">
			
					<td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Disposal Details of residue:</td>
					<td align="center" valign="middle" class="headngblue">
<table width="100%">
<tr>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteDisposalDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteDisposalDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopWasteDisposalDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
</table>
</td></tr>
</table>
</td></tr>
</table>

           <br/> 

           <%//}else{ %>
           <div class="headngblue" align="center"></div>
           
           <%//}%>
  		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There are three sections under W Emiss./Disch. Please fill all the details pertaining to W Emiss./Disch. To enter the details, use the links as follows:<>
			  &nbsp; 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the delete, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>           
          </div>




                                                                                    <div id="country8" class="content">

                                                                                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                                                            <tr ><td bgcolor="#FFFFFF">
                                                                                                <table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                                                                    <tr bgcolor="#417FB2">
                                                                                                        <td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Manufacture/Refurbisher Details</span></td>
                                                                                                        <td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td>
                                                                                                    </tr>
                                                                                                    <tr bgcolor="#E8F6F9">
                                                                                                        <td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Are you a Manufacture or Refurbisher :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <table>
                                                                                                                <tr >
                                                                                                                    <td style="font-size: 10px;" >
                                                                                                                        <input id="ewasteManufactureOrRefurbisherNo"
                                                                                                                               type="radio"
                                                                                                                               name="ewasteManufactureOrRefurbisher"
                                                                                                                               value="no"
                                                                                                                               checked="checked"/>
                                                                                                                        <label>
                                                                                                                            No
                                                                                                                        </label>
                                                                                                                    </td>
                                                                                                                    <td style="font-size: 10px;" >
                                                                                                                        <input id="ewasteManufactureOrRefurbisherYes"
                                                                                                                               type="radio"
                                                                                                                               name="ewasteManufactureOrRefurbisher"
                                                                                                                               value="yes"/>
                                                                                                                        <label>
                                                                                                                            Yes
                                                                                                                        </label>
                                                                                                                    </td>
                                                                                                                </tr>

                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Authorization Required for :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <table width="100%">
                                                                                                                <tr bgcolor="#F4F7FB" style="font-size: 11px;" >
                                                                                                                    <td align="left" bgcolor="#E8F6F9" style="font-size: 11px;">
                                                                                                                        <input type="checkbox" name="chkConsent" id="chkConsent" checked>Generation during manufacturing or refurbishing<br>
                                                                                                                        <input type="checkbox" name="chkBMW" id="chkBMW" >Treatment if any<br>
                                                                                                                        <input type="checkbox" name="chkHWM" id="chkHWM">Collection, Transportation, Storage<br>
                                                                                                                        <input type="checkbox" name="chkSWM" id="chkSWM">Refurbishing<br>

                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total quantity E waste Generated in MT/A :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <table width="100%">
                                                                                                                <tr>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopTotalQuantityAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopTotalQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopTotalQuantityEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
                                                                                                                </tr>
                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity Refurbished :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <table width="100%">
                                                                                                                <tr>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRefurbishedQuantityAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRefurbishedQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRefurbishedQuantityEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
                                                                                                                </tr>
                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity send for Recycling :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <table width="100%">
                                                                                                                <tr>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRecycleQuantityAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRecycleQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopRecycleQuantityEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
                                                                                                                </tr>
                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Quantity send for Disposal :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <table width="100%">
                                                                                                                <tr>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopDisposalQuantityAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopDisposalQuantityView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
                                                                                                                    <td align="center"><a href="#" style="font-size: 11px;" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopDisposalQuantityEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
                                                                                                                </tr>
                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Details of facilities for Storage/ Handling/ Treatment/ Refurbishing :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <input name="facilityDetail" type="text"  size="25" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:eWasteInstance,field:'facilityDetail')} " />
                                                                                                            <br><input type="file" name="eWasteFacilityDetails"/>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">In case of renewal of authorization previous authorization number and date and details of annual returns :</td>
                                                                                                        <td align="left" bgcolor="#E8F6F9"  class="txt">
                                                                                                            <input name="renewalAuth" type="text"  size="25"  maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:eWasteInstance,field:'renewalAuth')} " />
                                                                                                            <br><input type="file" name="eWasteRenewal"/>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                </table>
                                                                                            </td></tr>
                                                                                        </table>
                                                                                    </div>





















                                    <div id="country7" class="content">
																							
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
        <tr ><td bgcolor="#FFFFFF">
            <table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Other Details</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			    </tr>
                <tr bgcolor="#E8F6F9">
                    <td  bgcolor="#A8DAF3" align="left" valign="middle"  class="headngblue">Details of e-waste proposed to be procured from reprocessing :</td>
					<td align="center" valign="middle" class="headngblue">
                        <table width="100%">
                            <tr>
                                <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopEWasteDetailsAdd/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
                                <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopEWasteDetailsView/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
                                <td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/eWaste/EWpopEWasteDetailsEdit/<%=eWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether the industry has provided adequate pollution control system/equipment to meet the standards of emission/effluent : </td>
					<td align="left" bgcolor="#E8F6F9"  class="txt">
					    <g:select name="adequatePoll" id="adequatePoll"  from="${['NO','YES']}" class="txt4" value="${fieldValue(bean:eWasteInstance,field:'adequatePoll')}">
				        </g:select>
				    </td>
				</tr>
                <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether industry is in compliance with conditions laid down in the Authorization : </td>
					<td align="left" bgcolor="#E8F6F9"  class="txt">
					    <g:select name="indCompliance" id="indCompliance"  from="${['NO','YES']}" class="txt4" value="${fieldValue(bean:eWasteInstance,field:'indCompliance')}">
				        </g:select>
				    </td>
				</tr>
                <tr>
				    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Occupational safety and health aspects Details :</td>
                    <td align="left" bgcolor="#E8F6F9"  class="txt">
                        <input name="healthAspects" type="text"  size="30" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:eWasteInstance,field:'healthAspects')} " />
                        <br><input type="file" name="eWasteOccupationalSafetyDetails"/>
                    </td>
                </tr>
                <tr>
				    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Any other Information of relevance :</td>
                    <td align="left" bgcolor="#E8F6F9"  class="txt">
                        <input name="relInfo" type="text"  size="30"  maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:eWasteInstance,field:'relInfo')} " />
                        <br><input type="file" name="eWasteRelevantInformation"/>
                    </td>
                </tr>
            </table>
        </td></tr>
    </table>
                                    </div>
																						</div>
																						
																
																				</div>
																			</td>
																		</tr>
																	</table>
																	
																	
																														</div>							
																	
																	
																	
																	
          
          
		  		  
																 		  <table width="100%" align="center">
				
	<%//if(indApplicationDetailsInstance.completionStatus != "completed"){ %>
                                
		<%//}%>		
		
		<%//if(indApplicationDetailsInstance.completionStatus == "completed"){ %>
		<!--		<input name="appStatus" id="appStatus" type="hidden" value="completed"/>  -->
                                
							<tr>
								<td align="center" class="txt4">Do You Want To Save The Application as <input name="appStatus" id="appStatus" type="radio" value="completed" />  <span class="style3">Completed</span> 
								&nbsp;<input name="appStatus" id="appStatus" type="radio" value="inProgress" checked="checked"/>  <span class="style3">In Complete</span>
				
				</td>
				</tr>
				<tr>
				<td align="center" class="txt4"><b>**Note:</b> Select Completed to submit your application to APPCB official<br> Select In-Complete to keep application in your account for future editing
				<td colspan="2">&nbsp;</td>
				</tr>
				
				<%System.out.println("---testValue-------"+testValue)
				if(testValue=="true"){%>
				<tr >
					<td colspan="2" align="center">
					<input type="hidden" name="testValue" value="${testValue}">
						<input type="submit" name="Save" value="resubmit" class="actionbutton">
						
					</td>
					<% }else{%>
					<tr >
					<td colspan="2" align="center">
					
						<input type="submit" name="Save" value="Save" class="actionbutton">
						
						
						
					</td>
					
			  	</tr>
			  	<%}%>
				<tr>
					<td colspan="2" >&nbsp;</td>
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
								</table>
					 		</td>
						</tr>
					 <g:include controller="userMaster" action="showSpcbFooter"/>
					</table>
				</td>
			</tr>
		</table>
	</form>
		
	<script language="JavaScript" type="text/javascript">
		
		var frmvalidator  = new Validator("myform");
    	frmvalidator.EnableFocusOnError(false); 
    	frmvalidator.EnableMsgsTogether(); 
    	
    	function Checkfiles(){
	  
						    var frm = document.forms["myform"];  
						    if(document.getElementById('flowDiagramManufacturingProcess') != null)
						    {
						    	var fup = document.getElementById('flowDiagramManufacturingProcess');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Flow Diagram Manufacturing Process');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('locationOfSite') != null)
						    {
						    	var fup = document.getElementById('locationOfSite');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Location Of Site');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('processingTechDetails') != null)
						    {
						    	var fup = document.getElementById('processingTechDetails');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Processing Technology Details');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('siteClearance')!= null)
						    {
						    	var fup = document.getElementById('siteClearance');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Site Clearance');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('utilizationProgramme') != null)
						    {
						    	var fup = document.getElementById('utilizationProgramme');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Utilization Programme');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('disposalMethod') != null)
						    {
						    	var fup = document.getElementById('disposalMethod');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Disposal Method');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('wasteNatureAndComposition') != null)
						    {
						    	var fup = document.getElementById('wasteNatureAndComposition');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Waste Nature And Composition');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('landfillingIncinerationMethodology') != null)
						    {
						    	var fup = document.getElementById('landfillingIncinerationMethodology');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Landfilling/Incineration Methodology');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('preventionAndControlMeasures') != null)
						    {
						    	var fup = document.getElementById('preventionAndControlMeasures');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Prevention And Control Measures');
								   	 	return false;
									}
						    }
						    
						    if(document.getElementById('safetyMeasures') != null)
						    {
						    	var fup = document.getElementById('safetyMeasures');
						  
						  
							    var fileName = fup.value;
							    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
							    
							      	     if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" ||  ext == "pdf" || fileName =="" )
										  {
							      	    	
										  
										   } 
								     else
									 {
								    	
								    	 sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only for Safety Measures');
								   	 	return false;
									}
						    }
						    
						    return true;
						    
					}
					
    	function tosubmit()
    	{
    		
    		if(!(document.getElementById("chkCollection").checked) && !(document.getElementById("chkReception").checked) && !(document.getElementById("chkTreatment").checked) && !(document.getElementById("chkTransport").checked) && !(document.getElementById("chkStorage").checked) && !(document.getElementById("chkDisposal").checked))
 			{ 
 				alert("Please Check Atleast one Authorization Reqired For Check Box");
 				return false;
 			}
 			else
 			{
 				
 				frmvalidator.addValidation("location_Of_Activity","req","Please enter Location of Activity");
 			
	 			if(document.getElementById("radioIs_RenewYes").checked)
	 			{
	 				if(document.getElementById("auth_Renew_No").value=="")
	 				{
	 					alert("Please Enter Authorization Renew Number ");
	 					return false;
	 				}
	 				if(document.getElementById("auth_Renew_Date").value=="")
	 				{
	 					alert("Please Enter Authorization Renew Date ");
	 					return false;
	 				}
	 				
	 				frmvalidator.addValidation("auth_Renew_No","numeric","Enter Numeric value for Authorization Renew Number");
	 			}
	    		frmvalidator.addValidation("expectedReturn","req","Please enter Expected Return");
	    		frmvalidator.addValidation("expectedReturn","numeric","Please enter Numeric value for Expected Return");
	    		
	    		frmvalidator.addValidation("product_Name","req","Please enter Product Name");
	    		
	    		frmvalidator.addValidation("product_Qty","req","Please enter Product Quantity");
	    		frmvalidator.addValidation("product_Qty","numeric","Please enter valid value for Product Quantity");
	    		
	    		frmvalidator.addValidation("by_Product_Name","req","Please enter ByProduct Name");
	    		
	    		frmvalidator.addValidation("by_Product_Qty","req","Please enter ByProduct Quantity");
	    		frmvalidator.addValidation("by_Product_Qty","numeric","Please enter valid ByProduct Quantity");
	    		
	    		frmvalidator.addValidation("raw_Material_Name","req","Please enter Raw Material Name");
	    		
	    		frmvalidator.addValidation("raw_Material_Qty","req","Please enter Raw Material Quantity");
	    		frmvalidator.addValidation("raw_Material_Qty","numeric","Please enter valid Raw Material Quantity");
	    		
	    		frmvalidator.addValidation("eew_Type","req","Please enter Hazardeous Waste Type");
	    		
	    		frmvalidator.addValidation("eew_Qty","req","Please enter Hazardeous Waste Quantity");
	    		frmvalidator.addValidation("eew_Qty","numeric","Please enter valid Raw Material Quantity");
	    		
	    		
	    		frmvalidator.addValidation("product_Name1","req","Please enter ffffProduct Name");
	    		frmvalidator.addValidation("product_Name2","req","Please enter rrrrProduct Name");
	    		frmvalidator.addValidation("product_Name3","req","Please entervvvvv Product Name");
	    		frmvalidator.addValidation("product_Name4","req","Please enter bbbbbbbProduct Name");
	    		
	    		<g:each in="${product_Name}" status="i" var="product_NameIns">
	    		
	    		<% System.out.println("ABCD"); %>
	    		</g:each>
	    		
	    		
	    		frmvalidator.addValidation("eew_Source","req","Please enter Hazardeous Waste Source");
	    		
	    		frmvalidator.addValidation("mode_Of_Storage","req","Please enter Mode Of Storage");
	    		
	    		frmvalidator.addValidation("method_Of_Disposal","req","Please enter Method of Disposal");
	    		
	    		frmvalidator.addValidation("capacity_Of_Disposal","req","Please enter Capacity Of Disposal");
	    		frmvalidator.addValidation("quantityDisposed","req","Please enter Disposed Quantity");
	    		frmvalidator.addValidation("quantityDisposed","numeric","Please enter Numeric value for Quantity Disposed");
	    		frmvalidator.addValidation("capacity_Of_Disposal","numeric","Please enter valid Capacity Of Disposal");
	    		
	    		frmvalidator.setAddnlValidationFunction("Checkfiles");
 				
 					 
 			}
 			
 			
    	}
	</script>
	<script language="JavaScript" type="text/javascript">
	
	
		
	
	</script>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
