<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>



<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>
<calendar:resources lang="en" theme="aqua"/>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
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

</script>
<g:javascript>
function select9()
{
var selectmenu1=document.getElementById("treatmentplant")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp9').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp9').style.display = 'none';
   		 }
   }
} 
function districtPlan()
{
var selectmenu1=document.getElementById("districtIndustriesCenter")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp101').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp101').style.display = 'none';
   		 }
   }
} 

function districtPlan2()
{
var selectmenu1=document.getElementById("districtIndustriesCenter1")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp100').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp100').style.display = 'none';
   		 }
   }
}

function checkThis(obj)
{
   var objValue=obj.innerHTML;
   if(document.getElementById("chk"+objValue).checked == true)
       document.getElementById("chk"+objValue).checked = false;
   else
       document.getElementById("chk"+objValue).checked = true;
}

function hidediv() {
    for(var i = 0; i<document.myform.radioIs_Renew.length; i++){
 if(document.myform.radioIs_Renew[i].checked){
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
}


function select103()
{
	var selectmenu1=document.getElementById("enclosure")
	selectmenu1.onchange=function()
	 {    
	   	 var chosenoption=this.options[this.selectedIndex]
	         
	   	 if(chosenoption.value == "Yes")
	   	 {
	   	 document.getElementById('selectEnclosure100').style.display = 'block';
		 }
	else{
	    document.getElementById('selectEnclosure100').style.display = 'none';
	   		 }
	   }
	}

function select102()
{
var selectmenu1=document.getElementById("waterAct")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp102').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp102').style.display = 'none';
   		 }
   }
}

function select123()
{
var selectmenu1=document.getElementById("airAct")   
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
     if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp123').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp123').style.display = 'none';
   		 }
   }
}
function selectWheather()
{
var selectmenu1=document.getElementById("emmisionEffulant")   
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
     if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTempWheather').style.display = 'block';
	 }
else{
    document.getElementById('selectTempWheather').style.display = 'none';
   		 }
   }
}


function Calculate()
{	
	//alert("inside calculate");
	
	var indTyp;
	
		indTyp=document.getElementById('catVale').value;
	//alert(indTyp)
	var capitalInvestMent=document.getElementById('noOfBeds').value;
	//alert(capitalInvestMent)
	
	var result;
	
	var ValidationRequired;
	
	ValidationRequired="/^.*(?=.*[0-9]).*$/";

	// Calculating applicable consent fee based on above selection	
			if(indTyp=="ORANGE")
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
    	else if(indTyp=="RED")
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
    	else if(indTyp=="GREEN")
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
		else if(indTyp=="CLINIC")
   		{
   			
    			result=250;
    		
    	}
		else if(indTyp=="LAB"||indTyp=="BLOOD BANK"||indTyp=="VETERINARY")
   		{
   			if(capitalInvestMent <= 5000)
    		{
    			result=500;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=1000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 20000)
    		{
    			result=2000;
    		}
    		else if(capitalInvestMent > 20000)
    		{
    			result=4000;
    		}
    		
    	}		
    	
    	
    	
		var feeApp = document.getElementsByName('feeApplicable');
		//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
		
			if( feeApp != null){
				
				//alert("asas");
				feeApp[0].value=result*((document.getElementsByName('yearsApplied')[0]).value);
				
				//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
			}
	return true;
}

</g:javascript>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")

function enablingDisabling()
{
var a= document.getElementById("radiobuttonfresh").value;
if(a=="FreshApplication")
	{
	document.getElementById("prevauthNo").disabled = false;
	document.getElementById("prevauthDate").disabled = false;
	}
}

function enablingDisablingAgain()
{
var a= document.getElementById("radiobuttonfresh").value;
if(a=="FreshApplication")
	{
	document.getElementById("prevauthNo").disabled = true;
	document.getElementById("prevauthDate").disabled = true;
	}
}
</script>
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
                <td height="24" bgcolor="#EEEEF3">
					
					<table width="100%" bgcolor="#4C8BC0">
						 <tr >
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors--><td>
<span class="error">
                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${municipalSolidWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${municipalSolidWasteInstance}" as="list" />
            </div>
            </g:hasErrors></span></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="33" align="left" valign="top">&nbsp;</td>
                            <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
			 
    <br/>
    <g:form name="myform" action="save" method="post" enctype="multipart/form-data">
    <%System.out.println("hi "+indRegInstanceGet?.id)%>
    <input type="hidden" name="indRegId" value="${indRegInstanceGet?.id}" />
    <input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=PlasticWasteInstance.id%>"/>
   		<table width="75%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td>
					<ol id="toc">
						<li><a href="#country1"><span>General</span></a></li>
						<li><a href="#country2"><span>Plastic Waste</span></a></li>
						<li><a href="#country3"><span>Product/Raw Material</span></a></li>
						<li><a href="#country4"><span>Solid Waste Details</span></a></li>
						<li><a href="#country6"><span>Documents</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
         
	    
	    <div class="content" id="country1" >
		   <table width="75%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the unit :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="industryName" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.indName }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
				</tr> 
				<tr>
				<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Location of unit :<span style="color:red"></span></td>
				<td align="left" bgcolor="#E8F6F9"
					class="txt">
				<g:select  from="${['Industrial Area','Redevelopment Area','Other Area']}" name="unitLocation" value="" class="txt4"></g:select>
				</td>
																
				</tr>
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address of the unit :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="industryAddress" type="text" class="txt4" size="30" value="${indRegInstanceGet?.indAddress }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			
			<tr bgcolor="#F4F7FB">
			<td align="left" bgcolor="#A8DAF3" class="headngblue ">Year of Commencement of Production
			:</td>
			<td align="left" bgcolor="#E8F6F9"
				class="value ${hasErrors(bean:industryRegMasterInstance,field:'monOfComm','errors')} txt"><span
				class="txt style6"> 
								
		<%
		System.out.println("AAAAAAA---"+indRegInstance.indRegNumDate)
		SimpleDateFormat	 sdfh = new SimpleDateFormat("dd/MM/yyyy");
		def dateDefault = sdfh.format(indRegInstance.indRegNumDate);
		
		
		
		
		
		
		%>		
				
	  <input name="dateOfCom" type="text"  size="30" readOnly="readonly" maxlength="30" AUTOCOMPLETE=OFF class="txt4" value="${dateDefault}" />		       	        
	  			       	        
	  			       	        
				
			
			</td>
		</tr>
			
			
			<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Invested on the Project : </td>
			<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
			  <input type="text" class="txt4" id="indCapInvt" name="indCapInvt"  value="${indRegInstanceGet?.indCapInvt }" />
			&nbsp</span></td>
		</tr> 
			
			
			<tr>
			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Applicant Name :</td>
			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
			  <input name="applicantName" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstanceGet?.occName }" AUTOCOMPLETE=OFF maxlength="50" />
			</td>
	</tr>
	
	<tr>
	<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation : </td>
	
	<%  def occupierDesignation
		if(indRegInstanceGet.occDesignation.equals("Others")){
		occupierDesignation=(indRegInstanceGet.otherOccDesignation).toString()
		}else{
		occupierDesignation=(indRegInstanceGet.occDesignation).toString()
		}
	 %>
	
<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
<input type="text"  class="txt4" id="applicantDesignation" name="applicantDesignation"  value="${occupierDesignation}" /> 
	</span>
</td>

</tr> 
<tr>
	
			
					  <input name="City" type="hidden" class="txt4" size="30"  value="${indRegInstanceGet}" AUTOCOMPLETE=OFF maxlength="50" />
					
					  <input name="District" type="hidden" class="txt4" size="30"  value="${indRegInstanceGet }" AUTOCOMPLETE=OFF maxlength="50" />
				
					  <input name="Tehsil" type="hidden" class="txt4" size="30"  value="${indRegInstanceGet }" AUTOCOMPLETE=OFF maxlength="50" />
				
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Pin" type="text" class="txt4" size="30"  value="${indRegInstanceGet?.indPin }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			 
			
			<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No. With Code :</td>
			<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
			  <input type="text" class="txt4" id="indPhoneCode" name="indPhoneCode" value="${indRegInstanceGet?.indPhoneCode}" size="8" AUTOCOMPLETE=OFF/>
			  <input type="text" class="txt4" id="indPhoneNo" name="indPhoneNo" value="${indRegInstanceGet?.indPhoneNo}" size="13" AUTOCOMPLETE=OFF/>
			  <span class="sidetxt">(phone no with code)</span></span></td>
		   </tr>
		   
			<tr>
			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. With Code:</td>
			<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
			  <input type="text" class="txt4" id="indFaxCode" name="indFaxCode" value="${indRegInstanceGet?.indFaxCode}" size="8" AUTOCOMPLETE=OFF/>
			  <input type="text" class="txt4" id="indFaxNo" name="indFaxNo" value="${indRegInstanceGet?.indFaxNo}" size="13" AUTOCOMPLETE=OFF/>
			  <span class="sidetxt">(fax no with code)</span></span></td>
		   </tr> 
			
		 	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Mobile" type="text" class="txt4" size="30"  value="${indRegInstanceGet?.occMobile }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
			
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-mail Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  <input name="Email" type="text" class="txt4" size="30"  value="${indRegInstanceGet?.indEmail }" AUTOCOMPLETE=OFF maxlength="50" />
					</td>
			</tr> 
		   
			<tr>
		    <td align="left" bgcolor="#A8DAF3" class="headngblue">
				<div id="ting40">No. of workers (including Contract Labour) :
				</div>
			</td>
			<td width="70%" align="left" bgcolor="#E8F6F9"	class="txt">
			
			<div id="ting41"><input name="expNoEmp" maxlength="100" type="text"class="txt4"value="${indRegInstanceGet?.expNoEmp}"size="20" AUTOCOMPLETE=OFF />
			</div></td>
		</tr>
		
    
    <tr>
		<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Manufacturing Capacity :</td>
		<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
		<input type="text"  class="txt4" id="manufactoringCapacity" name="manufactoringCapacity" value=""/>
		</td>
</tr> 
    
    


<tr>
<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">PWM Authorization now Applied For <span style="color:red">*</span> :</td>
<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
	
		<%
			System.out.println("PlasticWasteInstance.authorisationAppliedFor"+PlasticWasteInstance.authorisationAppliedFor)
		%>
		<g:if test="${PlasticWasteInstance.authorisationAppliedFor==''}">
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="fresh" onclick="hidediv();" checked="checked"  />
		Fresh 
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="renew" onclick="hidediv();" />
		Renewal
		</g:if>
		
		
		<g:else>
		<g:if test="${PlasticWasteInstance.authorisationAppliedFor=='fresh'}">
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="fresh" onclick="hidediv();"   checked="checked"/>
		
		</g:if>
		<g:else>
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="fresh" onclick="hidediv();"   />
		</g:else>
		Fresh 
		<g:if test="${PlasticWasteInstance.authorisationAppliedFor=='renew'}">
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="renew" onclick="hidediv();" checked="checked"/>
		</g:if>
		<g:else>
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="renew" onclick="hidediv();"   />
		</g:else>
		
		Renewal
		
		</g:else>
		
 </td>
</tr>

 <!-- ##################### PWM In Case Of Renewal ########################### -->
 <tr>
	<tr class="prop"><td colspan="2" valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"><div style="display:none; border:0;"  id="SelectTemp11"  >In case of Renewal,please enter the details of previously issued authorisation:(Attach copies of Authorisations) </div></td> </tr>
 
 <tr>
		<td colspan="3">														
	<div id="authorization11" style="display:none; border:0;" >
		<table>
		<tr>
		<%
			
		%>
		
		<td bgcolor="#A8DAF3" width="60%" align="center" valign="middle"  class="headngblue"></td>
		<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/addAuthorisationPopup/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>                                                 
      <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/viewAuthorisationPopup/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a></td>                                                 
       <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/editAuthorisationPopup/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >Delete</a></td>
			
				 </tr>
				 </table>
			
    
    
		<tr>
		<td width="40%" bgcolor="#A8DAF3" align="left" class="headngblue">Registration required for manufacturing of : </td>
		<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue" >
		   <table style="width:100%;">
			   <tr><td style="cursor:pointer" onclick="checkThis(this)">Generation during manufacturing or refurbishing</td><td><input title="Generation" type="checkbox" name="chkGeneration" id="chkGeneration"/></td></tr>
			       <tr><td style="cursor:pointer" onclick="checkThis(this)">Treatment if any</td><td><input title="Collection" type="checkbox" name="chkTreatment" id="chkTreatment"/></td></tr>
			       <tr><td style="cursor:pointer" onclick="checkThis(this)">Collection, Transportation, Storage</td><td><input title="Generation" type="checkbox" name="chkStorage" id="chkStorage"/></td></tr>
			       <tr><td style="cursor:pointer" onclick="checkThis(this)">Refurbishing</td><td><input title="Generation" type="checkbox" name="chkRefurbishing" id="chkRefurbishing"/></td></tr>
			</table>
		</td>
	  </tr>
			
		   </table>
		   
      
		   
		   </div>
	    
	    
		   <div class="content" id="country2" >
	         
			  <table class="tblbdr" width="75%" align="center">
	                        <tbody>
	                       
	                        <tr bgcolor="#A8DAF3">
							<td width="30%" align="left" valign="middle"  class="headngblue">Consent Validity for Water : </td>
							<td align="left" colspan="3"  bgcolor="#E8F6F9" class="txt"><span class="txt style6">
							<calendar:datePicker id="waterValidity" name="waterValidity"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}" /></td>
							</tr>
							
							<tr bgcolor="#A8DAF3">
							<td width="30%" align="left" valign="middle"  class="headngblue">Consent Validity for Air : </td>
							<td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt"><span class="txt style6">
							<calendar:datePicker id="airValidity" name="airValidity"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}" /></td>
							</tr>
							
							<tr bgcolor="#A8DAF3">
							<td width="30%" align="left" valign="middle"  class="headngblue">Consent Validity for Authorization : </td>
							<td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt"><span class="txt style6">
							<calendar:datePicker id="authorizationValidity" name="authorizationValidity"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}" /></td>
							</tr>
							
							
						 
						 <tr class="headngblue" bgcolor="#A8DAF3">
						 <td width="30%" align="left" >Is the unit registered with District Industries Centre of the State Goverment or Union Territory ? if yes ,attatch a copy :</td>
							<td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt">
						<g:select class="txt4" from="${['No','Yes']}" name="districtIndustriesCenter1" id="districtIndustriesCenter1"  onclick="javascript:districtPlan2()"  value="${fieldValue(bean:industryRegMasterInstance,field:'districtIndustriesCenter')}" ></g:select>
						  	 <div style="display:none; border:0;" id="selectTemp100">
							 <input type="file"  id="attachDistrictPlan1" name="attachDistrictPlan1" onchange='showFileSize_100();'/> &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
						</td>
						</tr>
	                            
						
				   
				  
				   
				  
				  <tr class="headngblue" bgcolor="#A8DAF3">
				   <td width="30%" align="left" valign="middle"  class="headngblue">Manufacturing Process :</td>
				 	  <td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt">
				      <div style="" id="selectTemp9">
				 	        <input type="file"  id="processManufacturing" name="processManufacturing" onchange='showFileSize_104();'/> 
				 	        &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
				 	      </td>
				 	     </tr> 
				  
				  <tr class="headngblue" bgcolor="#A8DAF3">
				   <td width="30%" align="left" valign="middle"  class="headngblue">Waste Collection and transportation details .:</td>
				 	  <td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt">
				      <div style="" id="selectTemp9">
				 	        <input type="file"  id="wasteCollectionDetails" name="wasteCollectionDetails" onchange='showFileSize_104();'/> 
				 	        &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
				 	      </td>
				 	     </tr>    
				 	     
				 	    <tr class="headngblue" bgcolor="#A8DAF3">
						<td width="30%" align="left" >Provide details of the disposal facility, whether the facility is authorized by SPCB or PCC :</td>
						<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">
						<input type="text"  class="txt4" id="detailsDisposalFacility" name="detailsDisposalFacility" value=""/>
						 </td>
						</tr>   
				 	     
				 	    <tr class="headngblue" bgcolor="#A8DAF3">
				 	    <td width="30%" align="left" valign="middle"  class="headngblue">Please attach analysis report of characterization of waste generated(including leachate test if applicable) .:</td>
				 	   <td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt">
				 	    <input type="file"  id="attachmentAnalysis" name="attachmentAnalysis" onchange='showFileSize_104();'/> 
				 	   </td>
				 	    </tr>
				  
					 	<tr class="headngblue" bgcolor="#A8DAF3">
						<td width="30%" align="left" >Details of plastic waste proposed to be acquired through sale, auction, contract or import, as the case may be, for use as raw material :</td>
						<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">Name 
						<input type="text"  class="txt4" id="namePlastic" name="namePlastic" value=""/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						Quantity<input type="text"  class="txt4" id="quantityPlastic" name="quantityPlastic" value=""/>
						 </td>
						</tr>	     
					 	     
					 	     
					 	    <tr class="headngblue" bgcolor="#A8DAF3">
					        <td width="70%" align="left" valign="middle"  class="headngblue"><div>Details of Occupational Safety and health aspects :</div> </td>
							<td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt"><span class="txt style6"><div>
							<textarea	name="occupationalFacilities" rows="5" cols="40"
								maxlength="1000" class="txt4">${fieldValue(bean:industryRegMasterInstance,field:'occupationalFacilities')}</textarea>
							</div></span></td>
					    </tr>
					 	     
				  <tr class="headngblue" bgcolor="#A8DAF3">
					 <td width="30%" align="left" >Wheather the unit has adequate pollution control system or equipment to meet as standards of emission or effulant.:</td>
						<td bgcolor="#E8F6F9" colspan="3" align="left" class="headngblue">
					<g:select class="txt4" from="${['No','Yes']}" name="emmisionEffulant" id="emmisionEffulant" onclick="javascript:selectWheather()"  value="${fieldValue(bean:industryRegMasterInstance,field:'emmisionEffulant')}" ></g:select>
					  	 <div style="display:none; border:0;" id="selectTempWheather">
					  	<input type="text"  class="txt4" id="emmisionEffulantDetails" name="emmisionEffulantDetails" value=""/>
						</td>
				 </tr>
						
				 <tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="30%" align="left" >Wheather the unit is in compliance with condition laid down in said rules.:</td>
					<td bgcolor="#E8F6F9" colspan="3" align="left" class="headngblue">
				<g:select class="txt4" from="${['No','Yes']}" name="unitCompliance" id="unitCompliance" onclick="javascript:select103()"  value="${fieldValue(bean:industryRegMasterInstance,field:'emmisionEffulant')}" ></g:select>
			   </td>
										     
			  </tr>
			  <tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="30%" align="left" >Wheather conditions exists or are likely to exits of the material being handled or proccess posing adverse immediate or delayed impacts on the environment:</td>
					<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">
				<g:select class="txt4" from="${['No','Yes']}" name="materialProceed" id="materialProceed" onclick="javascript:select103()"  value="${fieldValue(bean:industryRegMasterInstance,field:'emmisionEffulant')}" ></g:select>
			   </td>
			</tr>
			  <tr class="headngblue" bgcolor="#A8DAF3">
				 <td width="30%" align="left" >Wheather conditions exists or are likely to exits of the material being handled or proccessed by any means capable of yielding another material (e.g leachate whicjh many posses eco toxicity):</td>
					<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">
				<g:select class="txt4" from="${['No','Yes']}" name="materialHandled" id="materialHandled" onclick="javascript:select103()"  value="${fieldValue(bean:industryRegMasterInstance,field:'emmisionEffulant')}" ></g:select>
			 </td>
			</tr>
				 
			<tr class="headngblue" bgcolor="#A8DAF3">
			 <td width="30%" align="left" >Any Other relative information including fire or accident mitigative measures :</td>
				<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">
				<input type="text"  class="txt4" id="otherInfor" name="otherInfor" value=""/>
		 </td>
		</tr>
		
		  <tr class="headngblue" bgcolor="#A8DAF3">
			 <td width="30%" align="left" >List of enclosure as per rule:</td>
				<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">
			<g:select class="txt4" from="${['No','Yes']}" name="enclosure" id="enclosure" onclick="javascript:select103()"  value="${fieldValue(bean:industryRegMasterInstance,field:'emmisionEffulant')}" ></g:select>
			<div style="display:none; border:0;" id="selectEnclosure100">
			 <input type="file"  id="attachEnclosure" name="attachEnclosure" onchange='showFileSize_100();'/> &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
			</td>
									     
		  </tr>
				 
				 
						
	                        </tbody>
	                    </table>
	                    
			   </div>
	    
	    
			   <div class="content" id="country3" >
		        
				  <table class="tblbdr" width="75%" align="center">
		                      <tbody>
		                      
		  				<tr bgcolor="#A8DAF3">
							<td width="70%" align="center" valign="middle"  class="headngblue">Product Details</td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popProductDetailsAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popProductDetailsView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popProductDetailsEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
						</tr>
		  				
		  			    <tr bgcolor="#A8DAF3">
		  					<td width="70%" align="center" valign="middle"  class="headngblue">By Product Details</td>
		  					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popByProductDetailsAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
		  					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popByProductDetailsView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
		  					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popByProductDetailsEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
		  				</tr>
		  				
		  				<tr bgcolor="#A8DAF3" >
							<td width="70%" align="center" valign="middle"  class="headngblue">Raw-Material Details</td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popRawMaterialAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popRawMaterialView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popRawMaterialEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
						</tr>
						
						<tr bgcolor="#A8DAF3" >
						<td width="70%" align="center" valign="middle"  class="headngblue">Furnish a flow diagram of manufacturing process showing input and output in terms of products and waste generated including for captive power generation and water</td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDescriptionOfProcessOfManufactureAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDescriptionOfProcessOfManufactureView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
						<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDescriptionOfProcessOfManufactureEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
						</tr>
					
						
		                      
		                      </tbody>
		                      </table>
		             </div>
			    
			   
			   
			   
	    <div class="content" id="country4" >
        
		  <table class="tblbdr" width="75%" align="center">
                    <tbody>
                    
                    <tr bgcolor="#A8DAF3">
    				<td width="70%" align="center" valign="middle"  class="headngblue">Solid Waste or Rejects</td>
    				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popWaterSolidWasteAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
    				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popWaterSolidWasteView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
    				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popWaterSolidWasteEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
    			  </tr>
    				
    			  <tr bgcolor="#A8DAF3">
  				<td width="70%" align="center" valign="middle"  class="headngblue">Waste Disposal Details</td>
  				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDisposalAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
  				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDisposalView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
  				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDisposalEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
  			  </tr>
  			  
  			<tr bgcolor="#A8DAF3">
				<td width="70%" align="center" valign="middle"  class="headngblue">Waste Generation Details</td>
				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popGenerationAdd/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popGenerationView/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
				<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popGenerationEdit/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
			  </tr>
    			  
    				<tr bgcolor="#A8DAF3">
    					<td width="70%" align="center" valign="middle"  class="headngblue">Status of compliance with these rules-Thickness-fifty micron ?</td>
    					<td colspan="3" bgcolor="#E8F6F9" align="left" class="headngblue">
    					<span class="txt style6"> 
    						<g:select class="txt4" from="${['No','Yes']}" name="thiknessRulz" id="thiknessRulz" value="${fieldValue(bean:industryRegMasterInstance,field:'thiknessRulz')}" onchange="upgradeStatusofSolid(this.value)"> </g:select> 
    						</span>
    						</td>
    				</tr>
    				
    				<tr bgcolor="#A8DAF3">
    				 <td width="70%" align="center" valign="middle"  class="headngblue" >Does the unit have a valid consent under the Water (Prevention and control of pollution) Act,1974 (6 of 1974)? if yes ,attatch a copy.:</td>
    					<td colspan="3" bgcolor="#E8F6F9" align="left" class="headngblue">
    				    <g:select class="txt4" from="${['No','Yes']}" name="waterAct" id="waterAct"   onclick="javascript:select102()"  value="${fieldValue(bean:industryRegMasterInstance,field:'waterAct')}" ></g:select>
    				  	 <div style="display:none; border:0;" id="selectTemp102">
    					 <input type="file"  id="waterActAttatch" name="waterActAttatch" onchange='showFileSize_102();'/> &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
    					</td>
    			  </tr>
    			  
    			  <tr bgcolor="#A8DAF3" >
    				 <td width="70%" align="center" valign="middle"  class="headngblue"  >Does the unit have a valid consent under the Air (Prevention and control of pollution) Act,1981 (14 of 1981)? if yes ,attatch a copy.:</td>
    					<td bgcolor="#E8F6F9" align="left" class="headngblue" colspan="3">
    					<g:select class="txt4" from="${['No','Yes']}" name="airAct" id="airAct" onclick="javascript:select123()"  value="${fieldValue(bean:industryRegMasterInstance,field:'airAct')}" ></g:select>
    				  	 <div style="display:none; border:0;" id="selectTemp123">
    					 <input type="file"  id="airActAttatch" name="airActAttatch" onchange='showFileSize_103();'/> &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
    					</td>
    										     
    			  </tr>
    			  
    			  
    			  <tr class="headngblue" bgcolor="#A8DAF3">
    		      <td width="30%" align="left"  class="headngblue">Attach or provide list of personal or Brand owners to whom the products will be supplied.:</td>
    			       <td align="left" bgcolor="#E8F6F9" colspan="3"  class="txt">
    		      <div style="" id="selectTemp9">
    			        <input type="file"  id="brandOwner" name="brandOwner" onchange='showFileSize_105();'/> 
    			        &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
    			      </td>
    			 </tr>
    			 <tr class="headngblue" bgcolor="#A8DAF3">
    		     <td width="30%" align="left"  class="headngblue">Attach or provide list of person supplying plastic to be used as raw material to manufacture carry bags or plastic sheet of like or multilayered packaging.:</td>
    		      <td colspan="3" bgcolor="#E8F6F9" align="left" class="headngblue">
    		     <div style="" id="selectTemp9">
    		       <input type="file"  id="supplyingPlastic1" name="supplyingPlastic1" onchange='showFileSize_104();'/> 
    		       &nbsp;<span class="sidetxt">(maximum size 5 mb)</span></span></div>
    		     </td>
    		    </tr>
    		    
    		    
    		    
    			<tr class="headngblue" bgcolor="#A8DAF3">
    			<td width="30%" align="left" valign="middle"  class="headngblue">List of producers and quantum of raw materials supplied to producers :</td>
    			<td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt">
    			<input type="file"  id="producersQuantumAttachment" name="producersQuantumAttachment" />
    		    </td>
    	    </tr>
    			
    	    
    		    <tr class="headngblue" bgcolor="#A8DAF3">
    			<td width="30%" align="left" valign="middle"  class="headngblue">Action Plan on collecting back the plastic waste :</td>
    			<td align="left" colspan="3" bgcolor="#E8F6F9"  class="txt">
    			<textarea	name="actionPlan" rows="5" cols="40"
    				maxlength="1000" class="txt4">${fieldValue(bean:industryRegMasterInstance,field:'actionPlan')}</textarea>
    		    </td>
    	    </tr>
    	    
                    </tbody>
                    </table>
           </div>
           
           
           
	    
	    
         
		   
		   
		   <div class="content" id="country5" >
	        
			  <table class="tblbdr" width="75%" align="center">
	                      <tbody>
	                      
	  				<%
			 def cat = IndustryRegMaster.findById(indRegInstanceGet.id.toLong())
			 def capInv = indRegInstanceGet.indCapInvt.toInteger()
			 def noOfMaterials = indRegInstanceGet.plotNo
			%>									
						<tr>
							<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue" > ${cat.category.name}</td>
						</tr> 
						
						<input type="hidden" id="catVale" value="${cat.category.name}">
						<input type="hidden" id="noOfBeds" value="${capInv}">
						<input type="hidden" id="noOfMaterials" value="${noOfMaterials}">
						<!--by shashank-->
						<!--<input type="hidden" id="typeHce" value="cat.other">-->
						<input type="hidden" id="bedNo" value="${cat.plotNo}">
						
					
						
						
				
				
				
						<tr>
							<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
							<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><input name="yearsApplied" id="yearsApplied" type="text" class="txt4" maxlength="4" size="10" value=''/>
							&nbsp;<span class="sidetxt">(Enter no of yrs)</span></span></td>
						</tr> 
						
						<tr>
							<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable : </td>
							<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
							<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value='' />
							
							 <a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>					
							
							&nbsp;<span class="sidetxt">(Click to calculate fee)</span>
							
							 </td>
							
						</tr>  
					  
					</td></tr>
			
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
							<table width="100%" border="0" >
							<tr>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsAddPWM/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsViewPWM/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popFeeDetailsEditPWM/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
							</tr>
							</table>
							</td>
						</tr>  
			
	                            
	                        </tbody>
	                    </table>
	                    
			   </div>
	          
			   
			   <div class="content" id="country6" >
		        
				  <table class="tblbdr" width="75%" align="center">
		                      <tbody>
		                      
		  				<tr>
		      <td bgcolor="#FFFFFF">
		         <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="3" class="tblbdr">
		            <tr bgcolor="#417FB2">
		               <td colspan="2">
		                  <table width="100%" cellpadding="0" cellspacing="0">
		                     <tr>
		                        <td width="95%" align="center" valign="middle"  class="headngblue">
		                           <span style="color: white">Documents Details</span>
		                           <a href="popupex.html" onclick="return popitup('instruction.gsp')"/>
		                        </td>
		                        <td  align="right" valign="middle"  class="headngblue"></td>
		                     </tr>
		                  </table>
		               </td>
		            </tr>
					<tr>
		            <td colspan="4">
					<div id="hideShow">
						<table width="100%" cellpadding="0" cellspacing="0">
							<tr bgcolor="#A8DAF3">
								<td width="35%" align="center" class="headngblue" valign="top">Upload Required Documents</td>
								<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popUploadDocPwm/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Upload </a></td>
							</tr> 
						</table>
		            </div>
				</td>
		    </tr>
		            <tr bgcolor="#A8DAF3">
		               <td width="35%" align="center" class="headngblue" valign="top">Delete Saved Documents</td>
		               <td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/plasticWaste/popDeleteDocPwm/<%=PlasticWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
		            </tr>
		         </table>
		         
		      </td>
		   </tr>
		                        </tbody>
		                    </table>
		                    <div align="center" class="txt" style="color: navy">
		   <br>
		   &nbsp;<b>* Instructions:</b> <br>
		   Please select "Yes" if you want to send the documents By Post/ By Hand and "No" to upload the required document online.<br>For Online Document Upload:
		   &nbsp;
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
				   </div>
		   
		   <table width="95%"> 
			<tr>
				<td align="center" class="txtR">Fields marked * are mandatory</td>
			</tr>
			<tr>
			  <td align="center" class="headngblue">Do you want to save the application as
			 <input name="appStatus" id="radioCompleted" type="radio" value="Completed" />
				Completed
			 <input name="appStatus" id="radioInprogress" type="radio" value="Inprogress" checked="checked" />
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
		      </g:form>


      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
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
 <script language="JavaScript" type="text/javascript">
 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 

function tosubmit()
{
	if( !(document.getElementById("chkGeneration").checked) && !(document.getElementById("chkTreatment").checked) && !(document.getElementById("chkStorage").checked) && !(document.getElementById("chkRefurbishing").checked))
		{ 
			alert("Please Check Atleast one Authorization Reqired For Check Box");
			return false;
		}
 
 

 return true;
}
 
 
 
 hidediv();
</script>

</body>
</html>


