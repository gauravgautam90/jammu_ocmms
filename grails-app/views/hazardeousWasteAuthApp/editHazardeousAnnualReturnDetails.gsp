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
function hidedivFor() {
	 var ScreenWidth=window.screen.width;
     var ScreenHeight=window.screen.height;
     var movefromedge=0;
     placementx=(ScreenWidth/2)-((400)/2);
     placementy=(ScreenHeight/2)-((300+50)/2);
     WinPop=window.open("About:Blank","","width=800,height=500,toolbar=0,location=0,directories=0,status=0,scrollbars=0,menubar=0,resizable=0,left="+placementx+",top="+placementy+",scre enX="+placementx+",screenY="+placementy+",");
     
     var SayWhat = "<p><font color='red'>Please get ready with the following documents to be uploaded, before start filling the application </font></p>"; 
     var SayWhat1 = "<p>\n<font color='black'>1. Consent to establish by the State Pollution Control Board under the Water (Prevention and Control of Pollution) Act,1974 (25 of 1974) and the Air (Prevention and Control of Pollution) Act,1981 (21 of 1981). </font></p>"; 
     var SayWhat2 = "<p><font color='black'>2. Consent to operate granted by the State Polution Control Board under the Water (Prevention and Control of Pollution ) Act,1974 (25 of 1974) and/or Air (Prevention and Control of Pollution ) Act,1981,(21 of 1981). </font></p>"; 
     var SayWhat3 = "<p><font color='black'>3. In Case of renewal of authorization ,a self-certified compliance report in respect of effluent,emission standards and the conditions specified in  the authorisation for hazardous and other waste. </font></p>"; 
     var SayWhat4 = "<p><font color='black'>4. Site Plan of the industry showing the location of hazardous waste storage facility area/rooms. </font></p>"; 
     var SayWhat5 = "<p><font color='black'>5. Compliance report of the conditions of earlier authorization under HWM Rules .</font></p>"; 
     var SayWhat6 = "<p><font color='black'>6. Form IV as prescribed in the Hazardous Waste (Management ,Handling & trans -Boundry Movements) Rules ,2016 dully filed & signed.. </font></p>"; 
     var SayWhat7 = "<p><font color='black'>7. Copy of agreement signed with Comman Hazardous Waste Treatment Facility regarding disposal of hazardous waste.</font></p>"; 
     var SayWhat8 = "<p><font color='black'>8. Compliance report of the conditions of latest Environment Clearance granted to the industry..</font></p>"; 
     var SayWhat9 = "<p><font color='black'>9. Compliance report on the CPCB guidelines for SOP's in case of Actual User/Recycler/Recovery/Captive use.</font></p>"; 
     WinPop.document.write('<html>\n<head>\n</head>\n<body>'+SayWhat+SayWhat1+SayWhat2+SayWhat3+SayWhat4+SayWhat5+SayWhat6+SayWhat7+SayWhat8+SayWhat9+'</body></html>');
     
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
<g:javascript>
function select9()
{
var selectmenu1=document.getElementById("complianceWithGuidelines")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp15').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp15').style.display = 'none';
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



</head>


	<g:form action="submitAnnualReturnDetails" method="post" id="myform" name="myform" enctype="multipart/form-data">
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
																			
																			<td align="left" valign="top">
																				<div style="padding: 0px 0px 0px 0px;">
																					<div style="" :1px solidgray; width:900px; margin-bottom: 1em; padding: 10px" >
																						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
																							<tr valign="middle">
																								<td width="100%" align="center">
																									<ol id="toc">
																										<li><a href="#country1"><span>General Details</span></a></li>
																									    <li><a href="#country2"><span>Part A</span></a></li>
																										<li><a href="#country3"><span>Part B </span></a></li>
																										<li><a href="#country4"><span>Part C </span></a></li>
																										<li><a href="#country5"><span>Part D </span></a></li>
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
									 	 <td  align="center" colspan="2" valign="middle" bgcolor="lightgrey" class="headngblue"><b>HWM Annual Return Details</b></td>
                                     </tr> 

									<tr>
							            <td width="60%" bgcolor="#A8DAF3" align="left" class="headngblue"> </td>
							            <td width="40%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
							              <table style="width:100%;">
								             <tr>
											     </tr>
											  </table>
							             </td>
						             </tr>
									
									
									
									
								
						             <tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Peried : </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <input type="text" name="fff" readonly  cols="45" id="fff" maxlength="200" class="txt4" value="${hazardeousAnnualReturnDetailsInstance.financialYear}"/>
										  </td>
									</tr> 
								    
								   <tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <textarea name="applicantDesignation" readonly rows="2" cols="45" id="applicantDesignation" maxlength="200" class="txt4">${indRegInstance?.indName}</textarea>
										  </td>
									</tr> 
									
									<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Address: </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										  <!--<input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" value="${indRegInstance?.indAddress}" size="45"/>-->
										  <textarea name="indAddress" readonly rows="2" cols="45" id="indAddress" maxlength="200" class="txt4">${indRegInstance?.indAddress}</textarea>
										  </td>
									</tr> 
									
								<tr>
										<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">UID:</td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										<%
										def userId = IndUser.find("from IndUser as gm where  gm.industryRegMaster=? ",[indRegInstance])
								     	%>
									
								<input type="text"  class="txt4" id="applicantDesignation" readonly name="applicantDesignation" value="${userId}" size="20"/></td>
									</tr>
									
								
								
								<tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Authorisation No<span style="color:red">*</span>:                                              
				               </td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="text"  class="txt4" id="authorisationNo"  name="authorisationNo" value="${hazardeousAnnualReturnDetailsInstance.authorisationNo}" size="20"/>
								 </td>
							    </tr> 
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of issue<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								<calendar:datePicker name="dateOfIssue"  dateFormat="%d/%m/%Y"  defaultValue="${hazardeousAnnualReturnDetailsInstance.dateOfIssue}"/></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Date of Expiry<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								<calendar:datePicker name="dateOfExpiry"  dateFormat="%d/%m/%Y" defaultValue="${hazardeousAnnualReturnDetailsInstance.dateOfExpiry}" /></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the authorised person
								<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="text"  class="txt4" id="authorisedPersonName"  name="authorisedPersonName" value="${hazardeousAnnualReturnDetailsInstance.authorisedPersonName}" size="20"/></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation of the authorised person
								<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="text"  class="txt4" id="authorisedPersonDesignation"  name="authorisedPersonDesignation" value="${hazardeousAnnualReturnDetailsInstance.authorisedPersonDesignation}" size="20"/></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Correspondence Address<span style="color:red">*</span>:</td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								 <textarea name="address"  rows="2" cols="45" id="address" maxlength="200" class="txt4"  >${hazardeousAnnualReturnDetailsInstance.address}</textarea></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile No<span style="color:red">*</span>:</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="text" size="20" pattern="[789][0-9]{9}" class="txt4" id="mobileNo" maxlength="10" name="mobileNo" value="${hazardeousAnnualReturnDetailsInstance.mobileNo}" size="11"/></td>
								     </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Land Line No (with area code):</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="text"  class="txt4" id="applicantDesignation"  name="landLineNo" value="${hazardeousAnnualReturnDetailsInstance.landLineNo}" size="20"/></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">fax number (with area code):</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="text"  class="txt4" id="applicantDesignation"  name="faxNumber" value="${hazardeousAnnualReturnDetailsInstance.faxNumber}" size="20"/></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">e-mail<span style="color:red">*</span>:</td>
								
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
								  <input type="email"  class="txt4" id="email"  name="email" value="${hazardeousAnnualReturnDetailsInstance.email}" size="20"/></td>
							    </tr>
							    <tr>
								<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Production during the year (product wise), wherever applicable <span style="color:red">*</span>:</td>
								
							  
							    <td width="100%" class="headngblue" align="left">
								          <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/addAnnualProduction/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a> &nbsp;&nbsp;&nbsp;                                                
						                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewAnnualProduction/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a> &nbsp;&nbsp; &nbsp;                                             
						                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteAnnualProduction/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >Delete</a>
						      <input type="hidden" name="returnId" value="${hazardeousAnnualReturnDetailsInstance.id}">
						                  </td>
								</tr>
								
								
						          <table style="display:none; border:4px;"  id="selectTemp2">
											<tr>
											<td width="100%" class="headngblue" align="center">
											          <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/addAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a>                                                 
									                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a>                                               
									                  <a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteAuthorisationPopup/<%=hazardeousWasteAuthAppInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >Delete</a>
									        </td>
											</tr>
									  </table>
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
		                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousAnnualReturnDetailsInstance.id%>"/>
		                <input type="hidden" id='appId' name="appId" value="${appId}" />
		                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			                   <tr>
									<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by hazardous waste generators<span style="color:red"></span></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/hazardeousPartADetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartADetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteHazardeousPartADetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
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
               <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
               <input type="hidden" id='appId' name="appId" value="${appId}" />
               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
	                   <tr>
							<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by Treatment, storage and disposal facility operators<span style="color:red"></span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/hazardeousPartBDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartBDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteHazardeousPartBDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
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
                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
                <input type="hidden" id='appId' name="appId" value="${appId}" />
                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
	                   <tr>
							<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">To be filled by recyclers or co-processors or other users<span style="color:red"></span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/hazardeousPartCDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartCDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteHazardeousPartCDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
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
	                <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=hazardeousWasteAuthAppInstance.id%>"/>
	                <input type="hidden" id='appId' name="appId" value="${appId}" />
	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		                   <tr>
								<td bgcolor="#A8DAF3" width="70%" align="center" valign="middle"  class="headngblue">Quantity of products dispatched (wherever applicable)<span style="color:red"></span></td>
								<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/hazardeousPartDDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
								<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/viewHazardeousPartDDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
								<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteHazardeousPartDDetails/<%=hazardeousAnnualReturnDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
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
					  
			   
		<hr>
           <br/>	
			</td></tr>
			
			</table>	
			
			
			
			
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
																				onclick="return myFunction();" value="Save"
																				 class="actionbutton" /></td>
																			
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
					 		</td>
						</tr>
					
					</table>
				</td>
			</tr>
		</table>
	</g:form>
	<script language="JavaScript" type="text/javascript">
	    var frmvalidator  = new Validator("myform");
    	frmvalidator.EnableFocusOnError(false); 
    	frmvalidator.EnableMsgsTogether(); 
    	
    	function tosubmithh()
    	{
    		

 			if(!(document.getElementById("chkIndustry").checked) && !(document.getElementById("chkTsdf").checked) && !(document.getElementById("chkRecycle").checked))
 			{ 
 				alert("Please check Atleast one Hazardous waste handling/generation Check Box");
 				return false;
 			}
			
    		if(!(document.getElementById("chkGeneration").checked) && !(document.getElementById("chkCollection").checked) && !(document.getElementById("chkStorage").checked) && !(document.getElementById("chkTransportation").checked) && !(document.getElementById("chkReception").checked) && !(document.getElementById("chkReuse").checked) && !(document.getElementById("chkRecycling").checked) && !(document.getElementById("chkRecovery").checked) && !(document.getElementById("chkPre-processing").checked) && !(document.getElementById("chkCo-processing").checked) && !(document.getElementById("chkUtilisation").checked) && !(document.getElementById("chkTreatment").checked) && !(document.getElementById("chkDisposal").checked) && !(document.getElementById("chkIncineration").checked))
 			{ 
 				alert("Please Check Atleast one Authorization Reqired For Check Box");
 				return false;
 			}
    		if((document.getElementById("isRecyclerOrUsers").value=="Yes"))
 			{ 
    			
    			var abc = document.getElementById("furnishInstalledCapacity").value
    			if(!abc)
    			{
    				alert("Please Attatch Furnish installed capacity");
    				return false;
    			}
    			var abc1 = document.getElementById("processDescriptionIncluding").value
    			if(!abc1)
    			{
    				alert("Please Attatch Process description including process flow sheet");
    				return false;
    			}
    			var abc2 = document.getElementById("pollutionControlSystems").value
    			if(!abc2)
    			{
    				alert("Details of pollution control systems such as Effluent Treatment Plant, scrubbers, etc. including mode of disposal of waste");
    				return false;
    			}
   			}
 			else
 			{
 				
	 			for(var i = 0; i<document.myform.radioIs_Renew.length; i++)
	 			{
		
 					if(document.myform.radioIs_Renew[i].checked)
					{
 						var radiomenu = document.myform.radioIs_Renew[i]
						if (radiomenu.value == "renew" || radiomenu.value == "varied")
						{ 
 			                if(document.getElementById('auth_Renew_No').value=='')
		 			        {
			 					alert("Please Enter Authorization Renew Number ");
			 					return false;
			 		        }
	 				    }
	 				     if (radiomenu.value == "renew" || radiomenu.value == "varied")
	 				    {
	 				        if(document.getElementById('auth_Renew_Date').value=='')
 			                {
	 					         alert("Please confirm the Authorization Renew Date ");
	 					         return false;
	 				        }
	 				    }
	 			    }
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
	    		frmvalidator.addValidation("hw_Type","req","Please enter Hazardeous Waste Type");
	    		frmvalidator.addValidation("hw_Qty","req","Please enter Hazardeous Waste Quantity");
	    		frmvalidator.addValidation("hw_Qty","numeric","Please enter valid Raw Material Quantity");
	    		frmvalidator.addValidation("product_Name1","req","Please enter ffffProduct Name");
	    		frmvalidator.addValidation("product_Name2","req","Please enter rrrrProduct Name");
	    		frmvalidator.addValidation("product_Name3","req","Please entervvvvv Product Name");
	    		frmvalidator.addValidation("product_Name4","req","Please enter bbbbbbbProduct Name");
	    		frmvalidator.addValidation("hw_Source","req","Please enter Hazardeous Waste Source");
	    		frmvalidator.addValidation("mode_Of_Storage","req","Please enter Mode Of Storage");
	    		frmvalidator.addValidation("method_Of_Disposal","req","Please enter Method of Disposal");
	    		frmvalidator.addValidation("capacity_Of_Disposal","req","Please enter Capacity Of Disposal");
	    		frmvalidator.addValidation("quantityDisposed","req","Please enter Disposed Quantity");
	    		frmvalidator.addValidation("quantityDisposed","numeric","Please enter Numeric value for Quantity Disposed");  
	    		frmvalidator.addValidation("generatinghazardousquantity","numeric","Please enter Numeric value for Quantity generating hazardous waste as defined in these Rules"); 
	    		frmvalidator.addValidation("capacity_Of_Disposal","numeric","Please enter valid Capacity Of Disposal");
	    		
 					 
 			}
 			
 			
    	}	
		
	</script>
	
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
	
	function handleClick(tittle) {
		
		if(tittle=="Industry")
		  {
			  document.getElementById("chkTsdf").disabled = true;
			  document.getElementById("chkRecycle").disabled = true;
			  
		  }else if (tittle=="TSDF Operator")
		  {
			  document.getElementById("chkIndustry").disabled = true;
			  document.getElementById("chkRecycle").disabled = true;
		  }else if (tittle=="RPCU")
		  {
			  document.getElementById("chkIndustry").disabled = true;
			  document.getElementById("chkTsdf").disabled = true;
		  }
		}
	
	function handleClick1(cb) {
		 var value=cb.checked
		 if(!value)
		 {
			 document.getElementById("chkIndustry").disabled = false;
			 document.getElementById("chkTsdf").disabled = false;
			 document.getElementById("chkRecycle").disabled = false;
		 }
	}
	redirecty();
	</script>
	
	<script language="javascript" type="text/javascript">
	function redirecty()
	 {
	 hidedivFor();	
	 select2();
	 
	 }
	</script>
	<script>
	function myFunction() {
		if(document.getElementById('radioInprogress').checked) {
			  return true;
			}else{
	var x = document.getElementById("authorisationNo").value;
	if(x==""){
	alert("Please Enter authorisationNo");
	document.getElementById("authorisationNo").focus();
	 return false;
	  }
	var x2 = document.getElementById("authorisedPersonName").value;
	if(x2==""){
	alert("Please Enter Name of the authorised person");
	document.getElementById("authorisedPersonName").focus();
	 return false;
	  }
	var x9 = document.getElementById("authorisedPersonDesignation").value;
	if(x9==""){
	alert("Please Enter Designation of the authorised person ");
	document.getElementById("authorisedPersonDesignation").focus();
	 return false;
	  }
	var x3 = document.getElementById("address").value;
	if(x3==""){
	alert("Please Enter address");
	document.getElementById("address").focus();
	 return false;
	  }
	var x4 = document.getElementById("mobileNo").value;
	if(x4==""){
	alert("Please Enter Mobile No");
	document.getElementById("mobileNo").focus();
	 return false;
	  }
	var x5 = document.getElementById("email").value;
	if(x5==""){
	alert("Please Enter Email");
	document.getElementById("email").focus();
	 return false;
	  }

	}
		}
	
	</script>
</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
