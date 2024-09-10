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
		
	
function Calculate()
{	
//alert("inside calculate");
	
	var indTyp;
	
		indTyp=document.getElementById('catVale').value;
	//alert("indTyp    "+indTyp);
	
	var capitalInvestMent=document.getElementById('noOfMaterials').value;
	//alert("capitalInvestMent     "+capitalInvestMent);
	
	var result;
	
	var ValidationRequired;
	
	ValidationRequired="/^.*(?=.*[0-9]).*$/";

	// Calculating applicable consent fee based on above selection	
			if(indTyp)
   		{
   			if(capitalInvestMent <= 60)
    		{
    			result=1500;
    		}
    		else if(  capitalInvestMent > 60 && capitalInvestMent <= 300)
    		{
    			result=2000;
    		}
    		else if(capitalInvestMent >300 && capitalInvestMent <= 500)
    		{
    			result=2500;
    		}
    		else if(capitalInvestMent >500 && capitalInvestMent <= 1000)
    		{
    			result=3000;
    		}
    		else if(capitalInvestMent>1000 && capitalInvestMent <= 2000)
    		{
    			result=3500;
    		}
    		
    		else if(capitalInvestMent>2000 && capitalInvestMent <= 3000)
    		{
    			result=4000;
    		}
    		
    		else if(capitalInvestMent>3000 && capitalInvestMent <= 5000)
    		{
    			result=4500;
    		}
    		else if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
    		{
    			result=5000;
    		}
    		else if(capitalInvestMent>10000 && capitalInvestMent <= 50000)
    		{
    			result=6000;
    		}
    		
    		else if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
    		{
    			result=7000;
    		}
    		
    		else if(capitalInvestMent>100000 && capitalInvestMent <= 500000)
    		{
    			result=7500;
    		}
    		
    		
    		else if(capitalInvestMent >500000)
    		{
    			result=8000;
    			
    		}
    	}
    	else if(indTyp=="DENTAL CLINIC")
   		{
   			if(capitalInvestMent <= 2499)
    		{
    			result=500;
    		}
    		else if(  capitalInvestMent >2500 && capitalInvestMent <=4999)
    		{
    			result=1000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <=7499)
    		{
    			result=2500;
    		}
    		else if(capitalInvestMent >  7500 && capitalInvestMent <=9999)
    		{
    			result=5000;
    		}
    		
    		else if(capitalInvestMent >  10000)
    		{
    			result=7500;
    			
    		}
    	}
    	else if(indTyp=="CBWTF")
   		{
   			if(capitalInvestMent < 50)
    		{
    			result=500;
    		}
    		else if(  capitalInvestMent > 49 && capitalInvestMent < 200)
    		{
    			result=3000;
    		}
    		else if(capitalInvestMent > 199 && capitalInvestMent < 500)
    		{
    			result=5000;
    		}
    		else if(capitalInvestMent > 499)
    		{
    			result=10000;
    			
    		}
    	}
	
		else if(indTyp=="LAB"||indTyp=="BLOOD BANK"||indTyp=="VETERINARY"|| indTyp=="CLINIC")
   		{
   			if(capitalInvestMent <= 2499)
    		{
    			result=500;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 4999)
    		{
    			result=1000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 7499)
    		{
    			result=2500;
    		}
    		else if(capitalInvestMent > 7500 && capitalInvestMent <= 9999)
    		{
    			result=5000;
    		}
    		else if(capitalInvestMent > 10000)
    		{
    			result=7500;
    		}
    		
    	}		
    	
    	
    	
		var feeApp = document.getElementsByName('feeApplicable');
		//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
		
			if( feeApp != null){
				
				//alert("asas");
				feeApp[0].value=result*(5);
				
				//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
			}
	return true;
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
		
		
		function capShow(){
		
		
		
		
		
		
		}
		
		
		}
		
		
		
		
		</g:javascript>
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
<body onload="capShow()">

	<g:form action="update" method="post" name="myform" enctype="multipart/form-data">
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
																						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
																							<tr valign="middle">
																								<td width="78%" align="center">
																									<ol id="toc">
																										<li><a href="#country1"><span>General Details</span></a></li>
																										<li><a href="#country2"><span>Product Details</span></a></li>
																										<li><a href="#country5"><span>Fee</span></a></li>
																										<li><a href="#country3"><span>Hazardous Waste Details</span></a></li>
																										<li><a href="#country4"><span>Details Files</span></a></li>
																										
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
																										<table width="76%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																											
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Name of the Unit:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="txtIndName" type="text" size="30" maxlength="25" readOnly="readonly" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indName')}" />
																												</td>
																		 									 </tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue" >Address:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="txtIndAddress" type="text"  size="30" readOnly="readonly" maxlength="100" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indAddress')}" />
																												</td>
																		 								 	</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">City:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="txtIndCity" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indCity')}" />
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">District:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		        									<input name="txtIndDistrict" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${district}" />
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Tehsil:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		        									<input name="txtIndTehsil" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${tehsil}" />
																		    									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Pin:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																													<input name="txtIndPin" type="text"  size="30" readOnly="readonly" maxlength="6" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indPin')}" />
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Location of Activity*:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																													<input id="location_Of_Activity" name="location_Of_Activity" type="text" size="30"  maxlength="50" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'location_Of_Activity')}"/>
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Authorization Required for: </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
																				      								<p>
																											  			<% int b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Collection'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkCollection" id="chkCollection"  checked="checked"/>
																												  			Collection 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkCollection" id="chkCollection"  />
																				  											Collection
																											  			</g:else>
																				        								 
																				        								<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Reception'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkReception" id="chkReception"  checked="checked"/>
																												  			Reception 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkReception" id="chkReception"  />
																															Reception
																											  			</g:else>
																				   										
																				   										<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Treatment'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkTreatment" id="chkTreatment"  checked="checked"/>
																												  			Treatment 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkTreatment" id="chkTreatment"  />
																				        									Treatment
																											  			</g:else> 
																				        								      
																				      								</p>
																			      									<p>
																			      										<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Transport'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkTransport" id="chkTransport"  checked="checked"/>
																												  			Transport 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkTransport" id="chkTransport"  />
																			    											Transport 
																											  			</g:else>
																			        									
																			        									<%  b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Storage'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkStorage" id="chkStorage"  checked="checked"/>
																												  			Storage 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkStorage" id="chkStorage"  />
																															Storage 
																											  			</g:else>
																			    										
																			    										<% b=0;%>
																														<%for(int i=0;i<tmp1.size();i++){%>
																														<g:if test="${tmp1[i]=='Disposal'}">
																												     	<%b=1;%>
																												     	</g:if>
																												     	<%}%>
																														<g:if test="${b==1}">
																														<input type="checkbox" name="chkDisposal" id="chkDisposal"  checked="checked"/>
																												  			Disposal 
																											  			</g:if>
																											  			<g:else>
																											  				<input type="checkbox" name="chkDisposal" id="chkDisposal"  /> 
																															Disposal 
																											  			</g:else>
																														
																				 									</p>
																		     									</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Is Authorization Renew? </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		    										<g:if test="${hazardeousWasteAuthAppInstance?.is_Renew== 'Yes'}">
																														<input name="is_Renew" id="radioIs_RenewYes" type="radio"  value="Yes" onclick="enablingDisablingAgain();" checked="checked" />
																		    											Yes 
																		        										<input name="is_Renew" id="radioIs_RenewNo" type="radio" value="No" onclick="enablingDisabling();" />
																														No 
																										  			</g:if>
																										  			<g:else>
																										  				<input name="is_Renew" id="radioIs_RenewYes" type="radio"  value="Yes" onclick="enablingDisablingAgain();" />
																		    											Yes 
																		        										<input name="is_Renew" id="radioIs_RenewNo" type="radio" value="No" onclick="enablingDisabling();" checked="checked" />
																														No
																										  			</g:else>
																												</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">In case of renewal , please mention authorization number and Date </td>
																											    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    <table width="293" border="1">
																												      <tr >
																												        <td>Number : </td>
																												        <td>Date(dd/mm/yyyy): </td>
																												      </tr>
																												      <tr >
																												      	<g:if test="${hazardeousWasteAuthAppInstance?.is_Renew== 'Yes'}">
																												        <td><input name="auth_Renew_No" id="auth_Renew_No" type="text"  size="30" maxlength="25" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'auth_Renew_No')}" /></td>
																												        <td><calendar:datePicker name="auth_Renew_Date"  dateFormat="%d/%m/%Y" years="1900,2300"  value="${hazardeousWasteAuthAppInstance?.auth_Renew_Date}" /></td>
																												      	</g:if>
																												      	<g:else>
																										  				<td><input name="auth_Renew_No" id="auth_Renew_No" type="text"  size="30" maxlength="20" AUTOCOMPLETE=OFF class="txt4"  disabled="disabled" /></td>
																												        <td><calendar:datePicker name="auth_Renew_Date"  dateFormat="%d/%m/%Y"  years="1900,2300" disabled="disabled"/></td>
																														No
																										  			</g:else>
																												      </tr>
																												    </table>      
																												</td>
																		  									</tr>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Whether the unit is generating hazardous waste as defined in the rules?*</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																		      										<input name="hw_Defined" id="radioHWDefinedYes" type="radio" value="Yes" checked="checked" />
																														Yes
																			  										<input name="hw_Defined" id="radioHWDefinedNo" type="radio" value="No" />
																														No
																												</td>
																		  									</tr>
																		  									<%System.out.println("killl mmeee"+indRegInstance)%>
																		  									<%if(indRegInstance.typeOfIndustry!="bmw"){%>
																		  									
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"><div  id="select1234">Total Capital Investment on Project(in Rs. Lacs)</div> </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left"><div  id="select1235">
																		    										<input name="totalCapitalInves" type="text"  readOnly="readonly" size="30" maxlength="20" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'indCapInvt')}" />
																												</div>
																												</td>
																		  									</tr>
																		  									<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"><div id="select123">Expexted Return(in Rs. Lacs)*:</div></td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left"><div  id="select124">
																													<input id="expectedReturn" name="expectedReturn" type="text" size="30"  maxlength="50" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'expectedReturn')}"/>
																												</div></td>
																		  									</tr>
																		  									<%}%>
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Year of Commencement of Production:</td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																													<input name="yearofcommision" type="text" readOnly="readonly" size="30" maxlength="4" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'dateOfComm')}" />
																												</td>
																		  									</tr>
																											<%System.out.println("indRegInstance.typeOfIndustry...."+indRegInstance.typeOfIndustry)%>
																											<%if(indRegInstance.typeOfIndustry !="bmw"){%>
																											
																											<tr>
																		    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Industry Working Shift: </td>
																		    									<td width="60%" bgcolor="#E8F6F9"  align="left">
																		    										<input name="industryShift" type="text" readOnly="readonly" size="30" maxlength="20" AUTOCOMPLETE=OFF class="txt4" value="${fieldValue(bean:indRegInstance,field:'shiftsIndustry')}" />
																		    									</td>
																		  									</tr>
																		  									<%}%>
																		  									
																										</table>
																									</tbody>
																								</table>
																							</div>
																						</div>
																						<div id="country2" class="content">
																							
																							<div class="dialog">
																								<table width="79%" align="center" border="0" cellpadding="0" cellspacing="0">
																									<tr>
																										<td>
																											<table width="87%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																											<%if(hwProductDetailsList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
																											<g:each in="${hwProductDetailsList}" status="i" var="indHWProductDetailsInstance">
																											<input type="hidden" name="indHWProductDetailsInstanceId" value="${indHWProductDetailsInstance?.id}" />
																												<tr>
																				    								<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Product Details: </td>
																				    								<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																						    							<table width="293" border="1">
																						      								<tr >
																						        								<td>Product</td>
																						        								<td>Quantity(Tonnes/KL)</td>
																						        								<td>By Products </td>
																						        								<td>Quantity(Tonnes/KL)</td>
																						      								</tr>
																															<tr >
																				        										<td>
																																	${fieldValue(bean:indHWProductDetailsInstance,field:'product_Name')}
																																</td>
																				        										<td>
																					        										${fieldValue(bean:indHWProductDetailsInstance,field:'product_Qty')}
																				        										</td>
																				        										<td>
																																	${fieldValue(bean:indHWProductDetailsInstance,field:'by_Product_Name')}
																																</td>
																														        <td>
																															        ${fieldValue(bean:indHWProductDetailsInstance,field:'by_Product_Qty')}
																														        </td>
																				      										</tr>
																														</table>
																													</td>
																												</tr>
																												<tr>
																			    									<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Raw Material Details: </td>
																			    									<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																														<table  border="1">
																													      <tr>
																													        <td >Product</td>
																													        <td >Quantity(Tonnes/KL)</td>
																													      </tr>
																													      <tr >
																													        <td>${fieldValue(bean:indHWProductDetailsInstance,field:'raw_Material_Name')}</td>
																													        <td>
																														        ${fieldValue(bean:indHWProductDetailsInstance,field:'raw_Material_Qty')}
																														    </td>
																													      </tr>
																				    									</table>
																													</td>
																												</tr>
																												<tr><td  bgcolor="#A8BBE6" align="left" class="headngblue" colspan="2">
															  													
															  													<g:def var="versionVal" value="${hazardeousWasteAuthAppInstance?.id}"/> <g:def var="fooVar" value="${indHWProductDetailsInstance.id}"/>
															  													
															  													<div style="width:100%;color:#585858;text-align:right;font-weight:bold;font-size:16px;font-family:Arial"><g:link action="deleteRowPro" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar,verValue:versionVal]"><marquee WIDTH=18% BEHAVIOR=ALTERNATE />Delete Product</g:link></div>
															  													
															  													</tr>
																											</g:each>
																												<tr><td  bgcolor="#A8DAF3" align="left" class="headngblue" colspan="2"><input type="button" onclick="createRow();" value="Add Product" /></td></tr>
                     																							<tr><td width="100%" colspan="2"> <div id="AjaxPanel"></div></td></tr>
																											</table>
																										</td>
																									</tr>
																								</table>
																							</div>
																						</div>
																						<div id="country3" class="content">
																							
																							<div class="dialog">
																								<table width="79%" align="center" border="0" cellpadding="0" cellspacing="0">
																									<tr>
																										<td>
																											<table width="87%" id="table12" name="table12"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																												<%if(hazardeousWasteDetailsList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
																												<g:each in="${hazardeousWasteDetailsList}" status="i" var="indHazardeousWasteDetailsInstance">
																												<input type="hidden" name="indHazardeousWasteDetailsInstanceId" id="indHazardeousWasteDetailsInstanceId" value="${indHazardeousWasteDetailsInstance?.id}" />
																												<tr>
															    													<td bgcolor="#A8DAF3" align="left" class="headngblue">Hazardous waste generated:</td>
															    													<td bgcolor="#E8F6F9"  align="left" class="headngblue">
																    													<table border="1">
																														      		<tr>
																														        		<td >Type</td>
																														        		<td >Quantity(Tonnes/KL)</td>
																														        	</tr>
																														        	<tr>
																														        		<td>
																														       				${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Type')}</td>
																														        		<td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Qty')}</td>
																														      		</tr>
																														        	<tr>
																														        		<td >Waste Characteristics</td>
																														        		<td >Source</td>
																														        	</tr>	
																														        	<tr>
																														        	 	<td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'waste_Characteristics')}																												      			</td>
																														      		 	<td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Source')}</td>
																														         	</tr>
																														   
																    													</table>
																  													</td>
															  													</tr>
																												<tr>
															    													<td bgcolor="#A8DAF3" align="left" class="headngblue">Storage and Disposal Details: </td>
															    													<td bgcolor="#E8F6F9"  align="left" class="headngblue">
																    													<table border="1">
																														   <tr>
																														        <td >Mode of Storage </td>
																														        <td >Method of Disposal </td>
																														   </tr>
																														   <tr>
																														   		<td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'mode_Of_Storage')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'method_Of_Disposal')}</td>
																														   </tr>
																														   <tr>
																														   		<td >Capacity(Tonnes/KL)</td>
																														    	<td >Quantity Disposed</td>
																														   </tr>	
																														   <tr>
																														    	<td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'capacity_Of_Disposal')}</td>
																														        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'quantityDisposed')}</td>
																														   </tr>
																														   
																    													</table>
																													</td>
															  													</tr>
															  													
															  													<tr><td  bgcolor="#A8BBE6" align="left" class="headngblue" colspan="2">
															  													
															  													<g:def var="versionVal" value="${hazardeousWasteAuthAppInstance?.id}"/> <g:def var="fooVar" value="${indHazardeousWasteDetailsInstance.id}"/>
															  													 <div style="width:100%;color:#585858;text-align:right;font-weight:bold;font-size:16px;font-family:Arial"><g:link action="deleteRow" controller="hazardeousWasteAuthApp" params="[appliLoc:fooVar,verValue:versionVal]"><marquee WIDTH=15% BEHAVIOR=ALTERNATE />Delete Waste</g:link></div>
															  													</td>
															  													
															  													</tr>
                     																							
															  													</g:each>
															  													<tr><td  bgcolor="#A8DAF3" align="left" class="headngblue" colspan="2" ><input type="button" onclick="createNewRow();" value="Add Waste" />
																													
																													
															  													<!--<input type="button" value="Delete" onclick="deleteTable()" />  -->
																												</td></tr>
                     																							
                     																							<tr><td width="100%" colspan="2"> <div id="AjaxPanel1"></div></td></tr>
																											</table>
																										</td>
																									</tr>
																								</table>
																							</div>
																						</div> 
																						
																						
														<div class="content" id="country5">
		  
		  <table width="90%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
								
								<%
								def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
	def capInv = indRegInstance.indCapInvt.toInteger()
	                            def noOfMaterials = capInv
	                            def hazardeousWasteAuthAppInstance1 = HazardeousWasteAuthApp.get((hazardeousWasteAuthAppInstance.id).toLong())
								def consentFeeMasterInst = ConsentFeeMasterHWM.findByApplication(hazardeousWasteAuthAppInstance)
								
								%>	
								<input type="hidden" name="id" value="${hazardeousWasteAuthAppInstance.id}">
								<input type="hidden" id="catVale" value="${cat.category.name}">
				<input type="hidden" id="noOfBeds" value="${capInv}">
				<input type="hidden" id="noOfMaterials" value="${noOfMaterials}">
																						
															<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Investment :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="indCapInvt" type="text" class="txt4" size="30"  value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 					
			
			
			<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					
					<input name="yearsApplied" id="yearsApplied" type="text" class="txt4" maxlength="4" size="10" value="5" readonly/>
					&nbsp;</span></td>
					
					
				</tr> 
				
			<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10"  value="${consentFeeMasterInst?.calculatedFee}" readonly />
			<a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
					&nbsp;<span class="sidetxt">(Click to calculate fee for new industry)</span></span></td>
				</tr>  
			  
			</td></tr>
			
			<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Fee  Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<tr>
					<%System.out.println("qqqqqqqqqqqqqqqq"+hazardeousWasteAuthAppInstance)%>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeOtherDetailsAddHWM/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeOtherDetailsViewHWM/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/popFeeOtherDetailsEditHWM/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
					</tr>
					</table>
					</td>
				</tr>  
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			
						</table>	
																							
							</div>
																						
																						
																						
																						
																						
																						<div id="country4" class="content">
																							
																							<div class="dialog">
																								<table width="79%" align="center" border="0" cellpadding="0" cellspacing="0">
																									<tr>
																										<td>
																											<table width="87%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
																												<tr >
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Detailed proposal of the facility (to be attached) to include:</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">&nbsp;</td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Attach flow diagram of manufacturing process showing input and output in terms of products ans waste generated including for captive power generation and demineralised water:</td> 
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="flowDiagramManufacturingProcess" id="flowDiagramManufacturingProcess" />
																												    </td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Location of Site(Provide Map):</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="locationOfSite" id="locationOfSite" />
																												    </td>
																												</tr>
																												
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> Details of Processing Technology:</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="processingTechDetails" id="processingTechDetails" />
																												    </td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Site clearance (from local authority):</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="siteClearance" id="siteClearance" />
																												    </td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Utilization programme for waste processed (Product utilization):</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="utilizationProgramme" id="utilizationProgramme" />
																												    </td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Method of disposal (details in brief be given): </td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="disposalMethod" id="disposalMethod" />
																												    </td>
																												</tr>
																												
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> Nature and composition of waste:</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="wasteNatureAndComposition" id="wasteNatureAndComposition" />
																												    </td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue"> Methodology and operational details of landfilling/incineration:</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="landfillingIncinerationMethodology" id="landfillingIncinerationMethodology" />
																												    </td>
																												</tr>
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Measures to be taken for prevention and control of environmental pollution including treatment of leachate:</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="preventionAndControlMeasures" id="preventionAndControlMeasures" />
																												    </td>
																												</tr>
																												
																												<tr>
																												    <td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Measures to be taken for safety of workers working in the plant:</td>
																												    <td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
																												    	<input type="file" name="safetyMeasures" id="safetyMeasures" />
																												    </td>
																												</tr>
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
																	<table width="95%"> 
																		<tr>
																			<td align="center" class="txtR">Fields marked * are mandatory</td>
																		</tr>
																		<tr>
																		  <td align="center" class="headngblue">Do you want to save the application as
																		 <input name="progress_Status" id="radioCompleted" type="radio" value="Completed" />
																			Completed
																		 <input name="progress_Status" id="radioInprogress" type="radio" value="Inprogress" checked="checked" />
																			Inprogress
																		 
																			
																			
																			</td>
																	</tr>
																	<tr>
																			<td width="15%">&nbsp;</td>
																	</tr>
																	</table>   
																	<table width="95%">
																	
																		<tr>
																			<td  align="center"><input type="submit" name="save"
																				onclick="return tosubmit();" value="Save"
																				 class="actionbutton" /></td>
																			
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
	</g:form>
		
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
	 				
	 			//	frmvalidator.addValidation("auth_Renew_No","numeric","Enter Numeric value for Authorization Renew Number");
	 			}
	    		frmvalidator.addValidation("expectedReturn","req","Please enter Expected Return");
	    		frmvalidator.addValidation("expectedReturn","numeric","Please enter Numeric value for Expected Return");
	    		
	    		
	    		frmvalidator.addValidation("product_Qty","req","Please enter Product Quantity");
	    		frmvalidator.addValidation("product_Qty","numeric","Please enter valid value for Product Quantity");
	    		
	    		frmvalidator.addValidation("by_Product_Name","req","Please enter ByProduct Name");
	    		
	    		frmvalidator.addValidation("by_Product_Qty","req","Please enter ByProduct Quantity");
	    		frmvalidator.addValidation("by_Product_Qty","numeric","Please enter valid ByProduct Quantity");
	    		
	    		frmvalidator.addValidation("raw_Material_Name","req","Please enter Raw Material Name");
	    		
	    		frmvalidator.addValidation("raw_Material_Qty","req","Please enter Raw Material Quantity");
	    		frmvalidator.addValidation("raw_Material_Qty","numeric","Please enter valid Raw Material Quantity");
	    		
	    		frmvalidator.addValidation("hw_Type","req","Please enter Hazardeous Waste Type");
	    		
	    		frmvalidator.addValidation("hw_Qty","req","Please enter Hazardeous Waste Quantity");
	    		frmvalidator.addValidation("hw_Qty","numeric","Please enter valid Raw Material Quantity");
	    		
	    		
	    		frmvalidator.addValidation("product_Name1","req","Please enter ffffProduct Name");
	    		frmvalidator.addValidation("product_Name2","req","Please enter rrrrProduct Name");
	    		frmvalidator.addValidation("product_Name3","req","Please entervvvvv Product Name");
	    		frmvalidator.addValidation("product_Name4","req","Please enter bbbbbbbProduct Name");
	    		
	    		<g:each in="${product_Name}" status="i" var="product_NameIns">
	    		
	    	</g:each>
	    		frmvalidator.addValidation("product_Name","req","Please enter Product");
	    		//frmvalidator.addValidation("product_Name","req","Please enter Product Name");
	    		
	    		frmvalidator.addValidation("hw_Source","req","Please enter Hazardeous Waste Source");
	    		
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
