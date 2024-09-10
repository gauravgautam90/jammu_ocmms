<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="java.util.Calendar"%>
<%@page import="java.text.*;"%>
   <head>
      <%
         response.setHeader("Cache-Control","no-cache"); 
         response.setHeader("Pragma","no-cache"); 
         response.setDateHeader ("Expires", -1);
     %>

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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
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
     
     <script type="text/javascript" language="javascript">

         
     function calYear()
     {
     	var dd = document.getElementById("yearsApplied").value;
     	//var fee = document.getElementById("feeApplicableBothAct1").value;
     	var startDates = document.getElementById("strtDate").value;
     	//alert("Hiiiii "+dd);
     	//alert("startDates "+startDates);
     	var bb = "";
     	
     /*	<%if(auotoRenewObj){%>
     	bb = document.getElementById("lastValidYear").value;
     	<%}%> */
     	//alert("bbbb-----"+bb);
		// Return today's date and time
		 var currentTime = new Date()
		
		                                                       var startDates=new Date(startDates).toLocaleDateString();
		                                                     //  alert("startDates 2 " +startDates);
	                                                        //   startDates.setDate(startDates.getDate() + 1);
		                                                    //   alert("startDates 3 " +startDates);
		
		                                                       var endDates=new Date(startDates);
		                                                       endDates.setFullYear(endDates.getFullYear() + parseInt(dd));
		                                                       var endDatess=new Date(endDates).toLocaleDateString();
		                                                      //	alert("endDatess " +endDatess);
		 
		// returns the month (from 0 to 11)
		// var month = currentTime.getMonth() 
		
		// returns the day of the month (from 1 to 31)
		// var day = currentTime.getDate() 
		
		// returns the year (four digits)
		var year = currentTime.getFullYear()
		if(bb)
			year = parseInt(bb)
		//alert("year----"+year)
		var endyear = year + parseInt(dd)
		//alert("endyear----"+endyear)
		// write output MM/dd/yyyy
		//document.write(month + "/" + day + "/" + year)
		    var sd =""
			
		// document.getElementById("sd").value= startDates;
		document.getElementById("strtDate").value= startDates;
		//alert("strtDate-New---"+startDates)
		document.getElementById("endDate").value= endDatess;
		//alert("endDate-New---"+endDate)
		//document.getElementById("validUpto").value= "31" + "/" + "03" + "/" + endyear;

		document.getElementById('feeApplicableBothAct1').value=fee;
		document.getElementById('feeApplicableBothAct').value=0;
     }
    </script>

    <script type="text/javascript">
    	function nonZero(){
    		var selectmenu1=document.getElementById("ddAmount").value
    			if(selectmenu1==0){
    				alert("please enter Amount more then zero");
    				document.getElementById("ddAmount").value=""
    			}
    		}
    	
    	        function Calculate()
    	        {	
    		    document.getElementById('showFee').style.display = 'block';	
    		    var showFeeValue=document.getElementById('showFeeValue').value
    			var feeApp = document.getElementById('feeApplicableWaterAct');
    			feeApp.value=showFeeValue;
    			var feeApp1 = document.getElementById('feeApplicableWaterAct1');
    			feeApp1.value=showFeeValue;
    			
    			
    			var showFeeValueForBothAct=showFeeValue*2;
    			var feeAppForBothAct = document.getElementById('feeApplicableBothAct');
    			feeAppForBothAct.value=showFeeValueForBothAct;
    			var feeAppForBothAct1 = document.getElementById('feeApplicableBothAct1');
    			feeAppForBothAct1.value=showFeeValueForBothAct;   
    			
    			var feeCurrentDemand = document.getElementById('feeCurrentDemand');
    			feeCurrentDemand.value=showFeeValueForBothAct;
    			
    			
    			var feeArrearsDemandValue = document.getElementById('feeArrearsDemand').value;
    			var feeArrDemandVal;
    			if(feeArrearsDemandValue!=''){
    			feeArrDemandVal=feeArrearsDemandValue
    			}else{
    			feeArrDemandVal=0;
    			}
    			var totalFeeDemand = document.getElementById('totalFeeDemand');
    			totalFeeDemand.value=parseInt(showFeeValueForBothAct)+parseInt(feeArrDemandVal);
    			var totalFeeDemand1 = document.getElementById('totalFeeDemand1');
    			totalFeeDemand1.value=parseInt(showFeeValueForBothAct)+parseInt(feeArrDemandVal);
    		
    			return true;
    	}
    	
    	       
    </script>
   
    <script type="text/javascript">
   
    function  hideshow11(){
    	
    	var aa = document.getElementById('unitFall').value 
    	
    	
    	if(aa=="Yes"){
    	
    	 	document.getElementById('pwmRule').style.display = 'block';
    	 	
    	 	
    		
    	}else {
    			
    		 document.getElementById('pwmRule').style.display = 'none';	
    		
    		 
    	}
    }
    
function  hideshow12(){
    	
    	var aa = document.getElementById('eia').value 
    	
    	
    	if(aa=="Yes"){
    	
    	 	document.getElementById('eiaCheck').style.display = 'block';
    	 	
    	 	
    		
    	}else {
    			
    		 document.getElementById('eiaCheck').style.display = 'none';	
    		
    		 
    	}
    }
    
    function Calculate1()
   
    {	
  //  alert("in Calculate1");
    var capitalInvestMent=parseInt(document.getElementById('showFeeValue').value);
    var result=625;
    var b;
    var consent="<%=indApplicationDetailsInstance.certificateFor%>";
    var appFor= "<%=indApplicationDetailsInstance.applicationFor%>";
    //alert("appFor--"+appFor);
    var year=parseInt(document.getElementById('yearsApplied').value);
 	
    if(capitalInvestMent <= 1)
	{
		result=100;
	}
	else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	{
		result=300;
	}
	else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	{
		result=600;
	}
	else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	{
		result=1300;
	}
	else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	{
		result=2500;
	}
	else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	{
		result=4200;
	}
	else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	{
		result=9800;
	}
	else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	{
		result=17200;
	}
	else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	{
		result=27000;
	}
	else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	{
		result=39200;
	}
	else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	{
		result=53900;
	}
	else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	{
		result=78800;
	}
	else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	{
		result=105000;
	}
	else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	{
		result=141800;
	}
	else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	{
		result=194300;
	}
	else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	{
		result=262500;
	}
	else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	{
		result=525000;
	}
		else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	{
		result=1312500;
	}
	else if(capitalInvestMent > 500000)
	{
		result=2625000;
	}


     result = result * year;
  // alert("result--3--"+result);  
     document.getElementById('feeApplicableBothAct').value=result;
     document.getElementById('feeApplicableBothAct1').value=result;
  // alert('helo'+b)
   
    return true;
 }
    
    function CalculateHotel()
    
    {	
  //  alert("in CalculateHotel");
    var capitalInvestMent=parseInt(document.getElementById('showFeeValue').value);
    var result=625;
    var b;
    var consent="<%=indApplicationDetailsInstance.certificateFor%>";
    var appFor= "<%=indApplicationDetailsInstance.applicationFor%>";
 //   alert("appFor--"+appFor);
    var year=parseInt(document.getElementById('yearsApplied').value);
    var hClass=document.getElementById('hotelClass').value;
    var noRooms=document.getElementById('noRooms').value;
 //  alert("hClass--"+hClass);
  //  alert("noRooms--"+noRooms);
    
    if(appFor=='hotel')  {
    	
    	if(hClass=='A'){    		
    	
    	   if(noRooms =>20 && noRooms <=50 )
    		{
    			result=1750;
    		}
    	   if(noRooms >50 && noRooms <=100 )
   		    {
   			result=3000;
   		    }
    	    if(noRooms >100 )
  		    {
  			result=3500;
  		    }
    	   
    	}
    	if(hClass=='B'){ 
    		
    		if(noRooms <= 20)
     		{
     			result=750;
     		}
     	   if(noRooms > 20 && noRooms <=50 )
     		{
     			result=1500;
     		}
     	   if(noRooms >50 )
    		    {
    			result=2500;
    		    }     	   
     	  }
    	
          if(hClass=='C'){ 
    		
    		if(noRooms <= 20)
     		{
     			result=625;
     		}
     	   if(noRooms > 20 && noRooms <=50 )
     		{
     			result=1250;
     		}
     	   if(noRooms >50 )
    		    {
    			result=2000;
    		    }     	   
     	}
          if(hClass=='D'){ 
      		
      		if(noRooms < 20)
       		{
       			result=500;
       		}
       	   if(noRooms > 20 && noRooms <=50 )
       		{
       			result=1000;
       		}
       	   if(noRooms >50 )
      		    {
      			result=1500;
      		    }     	   
       	}
    	
    }else{
    	
    if(capitalInvestMent <= 1)
	{
		result=100;
	}
	else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
	{
		result=300;
	}
	else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
	{
		result=600;
	}
	else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
	{
		result=1300;
	}
	else if(capitalInvestMent >25 && capitalInvestMent <= 50)
	{
		result=2500;
	}
	else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
	{
		result=4200;
	}
	else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
	{
		result=9800;
	}
	else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
	{
		result=17200;
	}
	else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
	{
		result=27000;
	}
	else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
	{
		result=39200;
	}
	else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
	{
		result=53900;
	}
	else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
	{
		result=78800;
	}
	else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
	{
		result=105000;
	}
	else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
	{
		result=141800;
	}
	else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
	{
		result=194300;
	}
	else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
	{
		result=262500;
	}
	else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
	{
		result=525000;
	}
		else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
	{
		result=1312500;
	}
	else if(capitalInvestMent > 500000)
	{
		result=2625000;
	}

    } 		

    result = result * year;
 // alert("result--3--"+result);  
    document.getElementById('feeApplicableBothAct').value=result;
    document.getElementById('feeApplicableBothAct1').value=result;
    	    
 // alert('helo'+b)
   
    return true;
 }
    
    
    function checkTotal(id)
    {
    //	alert("id.value---"+id.value)
    if (id.value == "" )
    {
       id.value = "0";
    }

    var AddFees = id.value;
    var lateFees
    
    document.getElementById("addFee1").value = AddFees;
    
    var calVal = eval(document.getElementById("feeApplicableBothAct").value) +  eval(document.getElementById("addFee1").value);
  
    document.getElementById("totalFee").value=calVal
 

    }
    </script>
    
      <script type="text/javascript">
         anylinkmenu.init("menuanchorclass")
      </script>
     
      <script language="javascript" type="text/javascript" src="${createLinkTo(dir:'js',file:'datetimepicker.js')}"></script>
      <script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script>
   </head>
  
<script language=javascript type='text/javascript'> 
function myHide(){
	//alert('myHide');
	document.getElementById('calculator').style.visibility = 'hidden';
}

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}


function hidediv() { 
if (document.getElementById) { // DOM3 = IE5, NS6 
document.getElementById('hideShow').style.visibility = 'hidden'; 
} 
else { 
if (document.layers) { // Netscape 4 
document.hideShow.visibility = 'hidden'; 
} 
else { // IE 4 
document.all.hideShow.style.visibility = 'hidden'; 
} 
} 
} 

function showdiv() { 
if (document.getElementById) { // DOM3 = IE5, NS6 
document.getElementById('hideShow').style.visibility = 'visible'; 
} 
else { 
if (document.layers) { // Netscape 4 
document.hideShow.visibility = 'visible'; 
} 
else { // IE 4 
document.all.hideShow.style.visibility = 'visible'; 
} 
} 
} 
		</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

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




<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>

	<script>
				$(document).ready(function(){
  				$("#mineAddress1").change(function(){
  				
    			dropdown = $('#mineralExcavated').val();
   
		  if (dropdown == 'Other')
 
      	  {
           $('#otherMineral').show();
       	 }
 
  				else
   					{
 
   				$('#otherMineral').hide();
  
  					}
   				});
  				});
				
				</script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body AUTOCOMPLETE=OFF onload="calYear(); loadHidediv210(); loadHidediv2100(); loadHidediv211();">
<% String cont=request.getContextPath(); %>
      <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
         <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
         <td height="91" align="left" valign="top" class="bgtop">
            <!-- code for spcbHeader  -->
            <g:include controller="userMaster" action="showSpcbHeader"/>
         </td>
      </tr>
      <tr>
         <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
            <!-- code for menuAdminHorizontal-->
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
         </td>
      </tr>
      <tr>
         <td align="left" valign="top">
            <table width="1003" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                     <!-- code for menuSpcbUser-->
                     <g:include controller="userMaster" action="showSpcbIndustryMenu"/>
                  </td>
                  <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                  <td width="778" align="left" valign="top">
                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
                                        		UserProfile aa=(UserProfile)session.getAttribute("userprof");
                                       		  firstname=aa.employeeFirstName;
                                     		  lastName=aa.employeeLastName;
                                     		  access=um.accessLevel;
                           
                           	}	
                           
                           	else
                           		{
                           			if(  (IndUser)session.getAttribute("indUser")  )
                           
                           				{
                           					IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
                                      					 indname=ind.indName;
//                                                           indType=ind.typeOfIndustry
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
                                    </td>
                                 </tr>
                                 <% } %>
                                 <tr>
                                    <td>&nbsp;</td>
                                 </tr>
                              </table>
                           </td>
                        </tr>
                        <tr>
                           <td height="0" align="left" valign="top" class="middlespacer">
                              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                 <tr>
                                    <!-- Div area for errors-->
                                    <td align="center" valign="top">
                                       <div style="width:100%; height:20px; vertical-align:middle">
                                          <span class="error">
                                             <g:if test="${flash.message}">
                                                <div class="message">${flash.message}</div>
                                                <div class="message">${flash.clear()}</div>
                                             </g:if>
                                          </span>
                                       </div>
                                    </td>
                                 </tr>
                                
                                 <tr>
                                    <td height="0" align="left" valign="top">
                                       <table width="778" border="0" cellspacing="0" cellpadding="0">
                                          <tr>
                                             <td width="15" align="left" valign="top">&nbsp;</td>
                                             <td align="left" valign="top">
                                                <div style="padding:0px 0px 0px 0px;" >
                                      <g:form name="myform" method="post" enctype="multipart/form-data" action="saveAutoRenewDetails" >
                                         <div align="left" class="txt" style="color: navy">
                                                
											<% 
										  		def category=industryRegMasterInstance.category.id;
										  		def catApp=IndCatMaster.get(category).name;
										  		def GFA=industryRegMasterInstance.indCapInvt;
													
												
												//def category=(params.cat).toLong();
												//System.out.println("-------jhghg-------"+industryRegMasterInstance.id);
												//def catApp= params.catName;
												// def GFA=(params.gfaValue).toFloat();
												
												
												
												 
												  def feeListFirst
												  def feeListSecond
												  def feeListThird
												  def feeListFourth
												  def feeFirst=0.00
												  def feeSecond=0.00
												  def feeThird=0.00
												  def feeFourth=0.00
												  
												// feeListFirst=FeeCalculatorMaster.findAll("from FeeCalculatorMaster abc where abc.fromYear='1996' and abc.toYear='2009' and abc.category.id=? and abc.aboveGFA<? and abc.uptoGFA>=?",[category,GFA,GFA]);
											//if(feeListFirst.size()!=0){
											//feeFirst=feeListFirst[0].feeAmount	
											//feeFirst=feeFirst.toFloat()
										//}
										 
										 if(GFA>0 && GFA<=500)
										{
									//	feeListSecond=FeeCalculatorMaster.findAll("from FeeCalculatorMaster abc where abc.fromYear='2009' and abc.toYear='2010' and abc.category.id=? and abc.aboveGFA<? and abc.uptoGFA>=?",[category,GFA,GFA]);
									//	if(feeListSecond.size()!=0){
									//	feeSecond=feeListSecond[0].feeAmount
									//	feeSecond=feeSecond.toFloat()
										//}
										}
										else if(GFA>500 && GFA<=1000)
										{
										         if(catApp=="RED")
										          {
										               feeSecond=GFA*150
										          }
										          else if(catApp=="ORANGE")
										          {
										               feeSecond=GFA*100
										          }
										          else if(catApp=="GREEN")
										          {
										               feeSecond=GFA*50
										          }
										}
										else if(GFA>1000 && GFA<=100000)
										{
										          if(catApp=="RED")
										          {
										              feeSecond=150000+((GFA-1000)*15)
										          }
										          else if(catApp=="ORANGE")
										          {
										              feeSecond=100000+((GFA-1000)*10)
										          }
										          else if(catApp=="GREEN")
										          {
										              feeSecond=50000+((GFA-1000)*5)
										          }

										}
										else if(GFA>100000)
										{
										         if(catApp=="RED")
										          {
										              feeSecond=1635000+(((GFA-100000)/2.5)*15)
										          }
										          else if(catApp=="ORANGE")
										          {		               
										               feeSecond=1090000+(((GFA-100000)/2.0)*10)
										          }
										          else if(catApp=="GREEN")
										          {		                
										               feeSecond=545000+(((GFA-100000)/2.0)*5)
										          }
										}

										if(GFA>0 && GFA<=500)
										{
										//feeListThird =FeeCalculatorMaster.findAll("from FeeCalculatorMaster abc where abc.fromYear='2010' and abc.category.id=? and abc.aboveGFA<? and abc.uptoGFA>=?",[category,GFA,GFA]);
										//if(feeListThird.size()!=0){
										//feeThird=feeListThird[0].feeAmount	
										//feeThird=feeThird.toFloat()
										//}
										}
										else if(GFA>500 && GFA<=1000)
										{
										         if(catApp=="RED")
										          {
										               feeThird=GFA*70
										          }
										          else if(catApp=="ORANGE")
										          {
										               feeThird=GFA*45
										          }
										          else if(catApp=="GREEN")
										          {
										               feeThird=GFA*30
										          }
										}
										else if(GFA>1000 && GFA<=5000)
										{
										          if(catApp=="RED")
										          {
										              feeThird=70000+((GFA-1000)*26)
										          }
										          else if(catApp=="ORANGE")
										          {
										              feeThird=45000+((GFA-1000)*20)
										          }
										          else if(catApp=="GREEN")
										          {
										              feeThird=30000+((GFA-1000)*8)
										          }

										}
										 else if(GFA>5000 && GFA<=10000)
										{
										          if(catApp=="RED")
										          {
										              feeThird=174000+((GFA-5000)*15)
										          }
										          else if(catApp=="ORANGE")
										          {
										              feeThird=125000+((GFA-5000)*10)
										          }
										          else if(catApp=="GREEN")
										          {
										              feeThird=62000+((GFA-5000)*8)
										          }

										}
										 else if(GFA>10000 && GFA<=100000)
										{
										          if(catApp=="RED")
										          {
										              feeThird=249000+((GFA-10000)*3.50)
										          }
										          else if(catApp=="ORANGE")
										          {
										              feeThird=175000+((GFA-10000)*2.50)
										          }
										          else if(catApp=="GREEN")
										          {
										              feeThird=94000+((GFA-10000)*2)
										          }

										}
										else if(GFA>100000)
										{
										         if(catApp=="RED")
										          {
										              feeThird=564000+((GFA-100000)*1.75)
										              if(feeThird>2000000){
										              feeThird=2000000
										              }
										          }
										          else if(catApp=="ORANGE")
										          {
										              feeThird=400000+((GFA-100000)*1)
										              if(feeThird>1500000){
										              feeThird=1500000
										              }
										          }
										          else if(catApp=="GREEN")
										          {
										              feeThird=274000+((GFA-100000)*1)
										              if(feeThird>575000){
										              feeThird=575000
										              }
										          }
										          
										}	
										
										 if(GFA>0 && GFA<=500)
										 {
											 
										//feeListFourth=FeeCalculatorMaster.findAll("from FeeCalculatorMaster abc where abc.fromYear='2018' and abc.toYear='2019' and abc.category.id=? and abc.aboveGFA<? and abc.uptoGFA>=?",[category,GFA,GFA]);
									//	if(feeListFourth.size()!=0){
										//	feeFourth=feeListFourth[0].feeAmount	
										//	feeFourth=feeFourth.toFloat()
										 //	}
										}
										
										 else if(GFA>500 && GFA<=1000)
										 {
										          if(catApp=="RED")
										           {
										        	  feeFourth=GFA*105
										           }
										           else if(catApp=="ORANGE")
										           {
										        	   feeFourth=GFA*65
										           }
										           else if(catApp=="GREEN")
										           {
										        	   feeFourth=GFA*42
										           }
										}
										 else if(GFA>1000 && GFA<=5000)
										 {
										           if(catApp=="RED")
										           {
										        	   feeFourth=105000+((GFA-1000)*40)
										           }
										           else if(catApp=="ORANGE")
										           {
										        	   feeFourth=65000+((GFA-1000)*30)
										           }
										           else if(catApp=="GREEN")
										           {
										        	   feeFourth=42000+((GFA-1000)*12)
										           }
										 
										 }
										  else if(GFA>5000 && GFA<=10000)
										 {
										           if(catApp=="RED")
										           {
										        	   feeFourth=265000+((GFA-5000)*23)
										           }
										           else if(catApp=="ORANGE")
										           {
										        	   feeFourth=185000+((GFA-5000)*15)
										           }
										           else if(catApp=="GREEN")
										           {
										        	   feeFourth=90000+((GFA-5000)*12)
										           }
										 
										 }
										  else if(GFA>10000 && GFA<=100000)
										 {
										           if(catApp=="RED")
										           {
										        	   feeFourth=380000+((GFA-10000)*5)
										           }
										           else if(catApp=="ORANGE")
										           {
										        	   feeFourth=260000+((GFA-10000)*4)
										           }
										           else if(catApp=="GREEN")
										           {
										        	   feeFourth=150000+((GFA-10000)*3)
										           }
										 
										 }
										 else if(GFA>100000)
										 {
									          if(catApp=="RED")
									           {
									        	  feeFourth=830000+((GFA-100000)*3)
									               if(feeFourth>3100000){
									            	   feeFourth=3100000
									               }
									           }
									           else if(catApp=="ORANGE")
									           {
									        	   feeFourth=620000+((GFA-100000)*2)
									               if(feeFourth>2300000){
									            	   feeFourth=2300000
									               }
									           }
									           else if(catApp=="GREEN")
									           {
									        	   feeFourth=420000+((GFA-100000)*1)
									               if(feeFourth>800000){
									            	   feeFourth=800000
									               }
									           }
										 }
										feeFirst=Math.round(feeFirst)	
										feeSecond=Math.round(feeSecond)
										feeThird=Math.round(feeThird)	
										feeFourth=Math.round(feeFourth)
										
										%>
												

												
                                          		<input type="hidden" id="consentY" name="consent" value="${indApplicationDetailsInstance.certificateFor}" />
												<input type="hidden" id="consentFor" name="consentFor" value="${indApplicationDetailsInstance.applicationFor}" />
												<input type="hidden" id="consentOrderAutoYear" name="consentOrderAutoYear" value=${new Date();}/>
										
											   <!-- old Instance of data -->
											   <input type="hidden" id='lastConsentGranted' name="lastConsentGranted" value="${lastConsentGranted}"/>
                                                <input type="hidden" id='oldIndApplicationId' name="oldIndApplicationId" value="${oldIndApplicationId}"/>
                                                
                                             	<input type="hidden" id="category.id" name="category.id" value="${industryRegMasterInstance?.category?.id}">
                                             
                                                <!-- new Instance of data -->
                                                <input type="hidden" id='regMasId' name="regMasId" value="${industryRegMasterInstance?.id}"/>
												<input type="hidden" id='otherId' name="otherId" value="${indOtherInstance?.id}"/>
				
												<input type="hidden" id="consenttypeForCte" value="${indApplicationDetailsInstance?.applicationType}">
												<input type="hidden" id="certificateForExpan" value="${indApplicationDetailsInstance?.certificateFor}">
											
												<input name="addFee1" id="addFee1" type="hidden" value="0" />
				
												<input type="hidden" id='indAppDetId' name="indAppDetId" value="${indApplicationDetailsInstance?.id}" /> 
				
                                            <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                                                <table width="109%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                  <tr>
                                                  	<td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                                                  	<td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Apply for Auto Renewal</a></td>
                                                  	<td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                                                  	<td width="1"></td>
                                                  	<td width="431">&nbsp;</td>
                                                </tr>
                                                
                                                
                                               
                                                </table>
                                                
                                                
                                                
                                             <div id="country1" >
                                                <table width="118%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
                                                <tr>
                                                <td valign="top" bgcolor="#FFFFFF">
                                                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                               	
                                                <tr>
                                                <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of the Proprietor / Partner</td>
                    							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.occName}</td>
                    							  </tr>
                                                <tr>
                                                <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name and Address of the Industry:</td>
                    							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indName},&nbsp;${industryRegMasterInstance.indAddress}</td>
                    							  </tr>
                    							  </tr>
                                                  <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">  i. Email :</td>
                      							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indEmail}</td>
                      							  </tr>
                      							  </tr>
                                                  <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">  ii. Contact No. :</td>
                      							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indPhoneNo}</td>
                      							  </tr>
                      							 
                      							
                    						
                				
                								   <tr>
                                                  <td width="60%" align="center" colspan="2" valign="middle" bgcolor="#A8DAF3" class="headngblue">SELF CERTIFICATION / UNDERTAKING:</td>
                      							
                      							  </tr>
                      							  <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">i. that there is no increase in production over the consented quantity.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="noIncreaseProduction"  id="noIncreaseProduction" checked> </td>
                      							  </tr>
                				  <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">ii. that there is no increase in quantity of sewage and trade effluent over the consented quantity.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="noSewageTradeEffluent"  id="noSewageTradeEffluent" checked> </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">iii. that there is no increase in the number of stacks and in emission over the consented quantity.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="noIncreaseStacksEmission"  id="noIncreaseStacksEmission" checked> </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">iv. that there is no change in the management or ownership of the company.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="noChangeManagementOwnership"  id="noChangeManagementOwnership" checked> </td>
                      							  </tr>
                      							  
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">v. that no court case is pending in respect of our unit against the Board/JK PCC in High Court/Supreme Court/NGT/Appellate Authority or any other courts (as applicable).<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="noCasePending"  id="noCasePending" checked> </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">vi. I/we certify that the information / data provided above are true to the best of my/our knowledge  and submission of false information or suppression of any factual information in the above self certification form would attract an action under environmental laws.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="noIncreaseProductionOverconsented"  id="noIncreaseProductionOverconsented" checked> </td>
                      							  </tr>
                      							 
                      							 <tr>
                                                 <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">vii. that adequate Pollution Control Devices are installed / pollution control measures have been adopted in our unit efficiently as per norms.<span style="color:red">*</span></td>
                     						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="devicesInstalled"  id="devicesInstalled" checked> </td>
                     							  </tr>
                     							 
                      							    <tr>
                                                  <td width="60%" align="center" colspan="2" valign="middle" bgcolor="#A8DAF3" class="headngblue">Self Declaration / Compliance:</td>
                      							
                      							  </tr>
                				 <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">viii. that the consent conditions stipulated in the earlier consent issued by the Board / JK PCC have been complied.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="consentConditions"  id="consentConditions" checked> </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">ix. I understand that failure on my part to comply with the prescribed standards or conditions of consent is liable to attract action as warranted under extant environmental laws.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="failure"  id="failure" checked> </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">x. that I hereby agree to abide by all the conditions mentioned in the self declaration / certification / undertaking.<span style="color:red">*</span></td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"><input type="checkbox" name="abide"  id="abide" checked> </td>
                      							  </tr>
                      							 
															
            
			 
			<%
				
				def latestCopyAudited=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Latest copy of Audited Balance Sheet' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def complianceReport=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Compliance report on conditions of Consent Renewal Issued' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def underTaking=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Under taking Letter/Self Declaration Letter for Auto Renewal' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
			
				def statusOfConstruction=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Status of construction with Chartered Engineer certificate' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def selfClerification=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Self certification in the format prescribed' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def otherDocument=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Other Document' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
			
				def envReportCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Evironment Statement Report of Last Financial Year' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def pwmReportCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='unit falls under the provisions of PWM Rules' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def airResultCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Air Results' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def waterResultCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Water Results' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				
				def prjReportCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Approval of industries department / Approved project report' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				def eiaReportCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='EIA Applicable' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
				
				%>
			
			 <%
             System.out.println("industryRegMasterInstance "+industryRegMasterInstance.id);
             def appCheck = ApplicationPendingDetails.find("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO' order by completionDate desc",[industryRegMasterInstance])
             
             def recordInst = RecordCertificate.find("from RecordCertificate where applicationId=? and applicationId.applicationType='CTO' and typeofCertificate = 'Prepared' order by dateCreated desc",[appCheck.application])
             def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
             %>
			 
			<input type="hidden" id='consentType' name="consentType" value="${consentType}"/>
			
			<tr>
			<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Copy of last consent issued by the Board / PCC:<span style="color:red">*</span></td>
			<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><br><a class="addViewDelete"
                href="#"
                    style="color: #0645AD"
                    onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowOfficer/<%=appCheck.applicationId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                     View Previous Consent Form
                 </a> <br><input type="file"  name="latestConsent" id="latestConsent" /><br><span class="sidetxt">*Upload Previous Consent</span><br>
						<%if(latestConsent){%>
<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${latestConsent.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
<%}%> 
<br><br>
		 
			 </td>
		</tr> 
		
	<!--	<tr>
		<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Copy of last consent issued by the Board / PCC:<span style="color:red">*</span><br> Online mode (to be linked automatically from the previous ID of the unit)
		</td>
		<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">
		<a class="addViewDelete"
            href="#"
            style="color: #0645AD"
            onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowOfficer/<%=appCheck.applicationId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
             View Previous Consent Form
         </a>
		 </td>
	</tr> -->
		<%System.out.println("unitFall"+unitFall)%>
		<tr>
		
		<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">If the unit falls under the provisions of PWM Rules, 2016 (PIPB):<br>
		(If yes, the unit holder is required to upload EPR endorsed by Secretary, UDD, JK UT as per Rule 9 and 13 of PWM Rules, 2016)<span style="color:red">*</span>
		</td> <td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><br>
		<g:select class="txt4" from="${['No','Yes']}" name="unitFall" id="unitFall" onChange="hideshow11();"></g:select> 
		
		<div id="pwmRule" style="display:none;">
		<input type="file"  name="unitFall" id="unitFall" /><br><span class="sidetxt">*Upload only non-editable files as pdf files</span><br>
<br><br>
		<%if(unitFall){%>
<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${unitFall.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
<%}%> </div>
<br><br>

		 </td>
		
	</tr>
		
		
	
	
	
<tr>
<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Latest photographs of the unit, P&M and PCDs with date and name of the Industry on it  </td>
<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><input type="file"  name="photographs" id="photographs" /><br><span class="sidetxt">*Upload only non-editable pdf files only</span><br>
			<%if(photographs){%>
<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${photographs.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
<%}%> 
<br><br>
		
<!--<span>Compliance format</span>	<u><a href="<%=request.getContextPath()%>/OspcbBoard/complianceauto.pdf" target="_blank"><font  size="1" style="color:blue">click here</font></a></u>-->
 </td>
</tr>




</tr>
	<% System.out.println("auotoRenewObj on gsp===="+auotoRenewObj); %>
            <tr height="40px">
			 <%
			 def noOfYear = ""
				def  str11 = ""
				//def	str2 = ""
			 if(auotoRenewObj){
				 
				 noOfYear = auotoRenewObj.noOfYear
				 //def sdfh5 = new SimpleDateFormat("dd/MM/yyyy"); 
				// str1 =  sdfh5.format(auotoRenewObj.validUpto)
				 str11 = auotoRenewObj.validUpto			 
				
				 System.out.println("str11---- "+str11);
			 }
			 %>
			 
			 <td  align="left" width="60%" bgcolor="#A8DAF3" class="headngblue">Select Number of Years/Periods for which Consent Renewal Required and then press Calculate<span style="color:red"></span>: </td>
					<td  align="left" width="40%" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4">					
					<g:select onchange="calYear()" from="${['1','2','3','4','5','6','7','8','9','10','11','12']}" name="yearsApplied" id="yearsApplied" value="${noOfYear}" class="txt4"></g:select>	(In Years)
					<table align="right" width="80%">
						<tr>
							<td  align="center" width="20%" bgcolor="#E8F6F9" class="headngblue"><span class="txt4"><input type="hidden" id="strtDate" name="strtDate" size="7" type="text" value="${str11}"/></td>
						<!--	<td  align="center" width="20%" bgcolor="#E8F6F9" class="headngblue"><span class="txt4"><input type="hidden" id="sd" name="sd" size="7" type="text" value="${str1}"/></td> -->
							<td  align="center" width="20%" bgcolor="#E8F6F9" class="headngblue"><span class="txt4"><input type="hidden" id="endDate" name="endDate" size="7" type="text" value="${str2}"/></td>
						</tr>
					</table>
						</td>
			</tr> 
	<!-- only return case execute-->	
			<%
			def indPenList=ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id=?  order by id desc",[indApplicationDetailsInstance.id])
				System.out.println("indPenList------"+indPenList)
			%>
			<%if(indPenList){%>
			<%if(consentType=="CTO" || consentType=="CTE"){%>
			<tr bgcolor="#417FB2">
			<td width="100%" colspan="2" align="center" valign="middle"  class="headngblue"><span style="color: white">Uploaded Documents Details</span></td>
			</tr> 
			<tr>
			<td colspan="2">
			<table width="100%" border="0" >
			
				<tr>
					<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Latest copy of Audited Balance Sheet :</td>
					<td align="left" bgcolor="#E8F6F9" class="headngblue">
					<g:def var="versionValc" value="auditatedBalanceSheet"/> 
					<g:def var="fooVarc" value="${indApplicationDetailsInstance.id}"/>
					<g:link action="autoDocumentDownload" controller="indApplicationDetails" params="[appliLoc:fooVarc,verValue:versionValc]"><span class="innerlink"><u>Download</u></span></g:link> 
					</td>
				</tr>

				<tr>
					<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Compliance report on conditions of Consent Renewal Issued :</td>
					<td align="left" bgcolor="#E8F6F9" class="headngblue">
					<g:def var="versionValb" value="complianceToConsent"/>
					<g:def var="fooVarb" value="${indApplicationDetailsInstance.id}"/>
					<g:link action="autoDocumentDownload" controller="indApplicationDetails" params="[appliLoc:fooVarb,verValue:versionValb]"><span class="innerlink"><u>Download</u></span></g:link>
				</td>
			</tr>

			<tr>
	  			<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Undertaking Letter/Self-Declaration Letter for Auto Renewal :</td>
	  			<td align="left" bgcolor="#E8F6F9" class="headngblue">
	  			<g:def var="versionVals" value="selfDeclarationLetterSheet"/> 
	  			<g:def var="fooVars" value="${indApplicationDetailsInstance.id}"/>
	  			<g:link action="autoDocumentDownload" controller="indApplicationDetails" params="[appliLoc:fooVars,verValue:versionVals]">
	  			<span class="innerlink"><u>Download</u></span></g:link>
	  			</td>
	  		</tr>
	  		
	</table>
	
	
	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse: collapse;">
	<tr>
		<td bgcolor="#FFFFFF">
		<table width="100%" border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			

	<tr bgcolor="#D1D1D1">
	<td colspan="2" align="center" valign="middle" class="headngblue">Bank Details</td>
	</tr>
	<!--added by shashank-->
	<%
	def feesOnline = FeeBankOtherDetails.find("from FeeBankOtherDetails fee where fee.application=?",[indApplicationDetailsInstance])
	def feesBank = FeeBankDetails.find("from FeeBankDetails fee where fee.application=?",[indApplicationDetailsInstance])
	def feesBankOnline = BankTransactionDetails.find("from BankTransactionDetails fee where fee.indApplication=? and fee.transactionStatus='S' order by id desc",[indApplicationDetailsInstance])
	def feesAlreadyPaid = FeeChequeRecord.find("from FeeChequeRecord fee where fee.indApplication=? and fee.level='Fee_Already_Paid' order by id desc",[indApplicationDetailsInstance])
//	System.out.println("fees Already Paid--------->"+feesAlreadyPaid);
	%>


	<%if(feesBank){%>
	<tr>
	<td colspan="2">
	<table width="100%" border="0">
		<tr>
			<td width="10%" align="center"  class="headngblue">Fee Bank Details</td>
			<td width="10%" class="headngblue" align="left"> 
			<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=500,scrollbars=1');">
			View </a></td>

		</tr>
	</table>
	</td>
	</tr>
	<%}%>

	
	<%if(feesBankOnline==null && feesBank==null){%>
	<tr>
	<td colspan="2">
	<table width="100%" border="0">
		<tr>

			<td width="10%" class="headngblue" align="center">payment not submitted</td>

		</tr>
	</table>
	</td>
	</tr>
	<%}%>

	<%if(feesBankOnline) {%>

	<tr bgcolor="#D1D1D1">
	<td colspan="2" align="center" valign="middle"
		class="headngblue">Online Payment Details</td>
	</tr>
	<tr>
	<td colspan="2">
	<table width="100%" border="0">
		<tr>

			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popChallan/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');">
			 View Challan </a></td>

		</tr>
	</table>
	</td>
	</tr>
	<%}%>
														
	

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
			 <g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="viewAlreadyPaidPdf" controller="indApplicationDetails" params="[appliLoc:fooVar]"><span class="innerlink"><u>Money Reciept</u></span></g:link>
			</td>

		</tr>
	</table>
	</td>
	</tr>
	<%}%>

	</table>

	</td>
	</tr>

	</table>
</td>
</tr>
<%}%>
			<%}%>
	<!-- only return case execute-->	
			
			<tr bgcolor="#417FB2">
					<td width="100%" colspan="2" align="center" valign="middle"  class="headngblue"><span style="color: white">Fee Details</span></td>
			</tr> 
			<% System.out.println("indApplicationDetailsInstance.applicationFor----"+indApplicationDetailsInstance.applicationFor)%>
			
			<% if(indApplicationDetailsInstance.applicationFor=='hotel') {%>
			              <% System.out.println("inside if")%>
			              <tr>
							<td colspan="2">
							<table width="100%" border="0" >
									
							
							<input type="hidden" name="showFeeValue" id="showFeeValue" value="${industryRegMasterInstance.indCapInvt}"/>
							
							
								<tr>
									<!--<td width="10%" class="headngblue" align="center">Payment of Consent Fee</td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsAdd?id=<%=indApplicationDetailsInstance.id%>&indId=<%=industryRegMasterInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>-->
									<!--<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsView?id=<%=indApplicationDetailsInstance.id%>&gfaValue=<%=industryRegMasterInstance.indCapInvt%>&cat=<%=industryRegMasterInstance.category%>&captInvAS=<%=indCapInvt%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>	-->				
								</tr>
									
							<!--	<tr>
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Category:</td>
									<td width="45%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance.category}</td>
								</tr> -->
								<tr >
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Capital Investment (In Lakhs) <br> 
								(Land & Building, Plant and Machinery) :</td>
								<td  align="left" bgcolor="#E8F6F9" class="headngblue"><span>${industryRegMasterInstance.indCapInvt}</span> </td>
								</tr>
								
								<tr >
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Select Class :<br> 
								</td>
								<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">
								<g:select class="txt4" from="${['A','B','C','D']}" name="hotelClass" id="hotelClass" ></g:select> 
								</td>
								</tr>
								
								<tr >								
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Number of Rooms :<br> 
								</td>
								<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"> 
								<!--	<input type="text" name="noRooms" id="noRooms"  class="txt4" size="10" value="${20}"/>     -->
							<g:select class="txt4" from="${['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19']}" name="noRooms" id="noRooms" ></g:select> 
								<span class="sidetxt">As Per Previous Consent</span><br>
								</td>
								</tr>
								
								<tr>
								 <td  align="left" bgcolor="#E8F6F9"  class="headngblue"></td>
									<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
									<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/><a href="javascript:{}" onclick="return CalculateHotel();"  class="bulletinside"><b>Calculate</b></a>
									</td>
								 </tr>
								 
								 
								 
								 <% def feeApplicableWaterAct=0
								  def feeApplicableBothAct=0
								  def totalFeeDemand=0
								 
								    if(consentFeeMasterInstance)
								   {
								    feeApplicableWaterAct=Math.round(consentFeeMasterInstance?.feeApplicableWaterAct)
									feeApplicableBothAct=Math.round(consentFeeMasterInstance?.feeApplicableBothAct)
									totalFeeDemand=Math.round(consentFeeMasterInstance?.totalFeeDemand) 
									} %>
									
									  
									
									<tr>
										<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Consent Fee Applicable : </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										<input name="feeApplicableBothAct" id="feeApplicableBothAct" type="text" class="txt4" size="10" value="${feeApplicableBothAct}" disabled/>
										<input name="feeApplicableBothAct1" id="feeApplicableBothAct1" type="hidden" value="${feeApplicableBothAct}"/>
										&nbsp;<span class="sidetxt">(In Rs.)</span></span>
										<input name="appId" type="hidden" value="<%=appDetId%>" /></td>
									</tr>
								
								 
								 <tr >								
									<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Addtional Fee incase of Restaurant <br>
									               <span style="color:red">(Incase of false information regarding any fee data application will be consider as rejected )</span>
									</td>
									<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"> 
									<input type="text" name="addRestFee" id="addRestFee"  class="txt4" size="10" onblur="checkTotal(this)" />	
									 <a href="<%=cont%>/SPCB_DOCUMENTS/Fee Structure for DG Set and Hotel.pdf" target="_blank" class="bulletinside">	
									 &nbsp;<span class="sidetxt">(Click to view fee for Hotel/Restaurent)</span>
									</td>
									</tr>
									
								
									 <tr >								
										<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Total Fee Applicable :
										</td>
										<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"> 
										<input type="text" name="totalFee" id="totalFee"  class="txt4" size="10" value="" readOnly/>									
										</td>
										</tr>
							
				                 
							</table>
							</td>
						</tr> 
				
				<%}else {%>
				          <% System.out.println("inside else----")%>
				          
				          <tr>
							<td colspan="2">
							<table width="100%" border="0" >
									
							
							<input type="hidden" name="showFeeValue" id="showFeeValue" value="${industryRegMasterInstance.indCapInvt}"/>
							
							
								<tr>
									<!--<td width="10%" class="headngblue" align="center">Payment of Consent Fee</td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsAdd?id=<%=indApplicationDetailsInstance.id%>&indId=<%=industryRegMasterInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>-->
									<!--<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsView?id=<%=indApplicationDetailsInstance.id%>&gfaValue=<%=industryRegMasterInstance.indCapInvt%>&cat=<%=industryRegMasterInstance.category%>&captInvAS=<%=indCapInvt%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
									<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>	-->				
								</tr>
									
							<!--	<tr>
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Category:</td>
									<td width="45%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance.category}</td>
								</tr> -->
								<tr >
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Capital Investment (In Lakhs) <br> 
								(Land & Building, Plant and Machinery) :</td>
								<td  align="left" bgcolor="#E8F6F9" class="headngblue"><span>${industryRegMasterInstance.indCapInvt}</span> </td>
								</tr>
								
								
								 <tr>
								 <td  align="left" bgcolor="#E8F6F9"  class="headngblue"></td>
									<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
									<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/><a href="javascript:{}" onclick="return Calculate1();"  class="bulletinside"><b>Calculate</b></a>
									</td>
								 </tr>
								 
								 <% def feeApplicableWaterAct=0
								  def feeApplicableBothAct=0
								  def totalFeeDemand=0
								 
								 if(consentFeeMasterInstance)
								 {
								    feeApplicableWaterAct=Math.round(consentFeeMasterInstance?.feeApplicableWaterAct)
									feeApplicableBothAct=Math.round(consentFeeMasterInstance?.feeApplicableBothAct)
									totalFeeDemand=Math.round(consentFeeMasterInstance?.totalFeeDemand) 
									} %>
									
									  
									
									<tr>
										<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Consent Fee Applicable : </td>
										<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
										<input name="feeApplicableBothAct" id="feeApplicableBothAct" type="text" class="txt4" size="10" value="${feeApplicableBothAct}" disabled/>
										<input name="feeApplicableBothAct1" id="feeApplicableBothAct1" type="hidden" value="${feeApplicableBothAct}"/>
										&nbsp;<span class="sidetxt">(In Rs.)</span></span>
										<input name="appId" type="hidden" value="<%=appDetId%>" /></td>
									</tr>
								
				                 
							</table>
							</td>
						</tr> 
				<%}%>
				
												
                                                </table>
                                               </td> 
                                              </tr>  
                                            </table>    
                                          </div>
                                        </div>
                                        
                                        
                                         
		  <table width="100%" align="center">
				<tr>
				<td align="center" class="txt4">Do You Want To Save The Application as <input name="appStatus" id="appStatus" type="radio" value="completed" />  <span class="style3">Submit and Proceed to pay </span> &nbsp;<input name="appStatus" type="radio" value="inProgress" checked="checked"/>  <span class="style3">Save Draft</span>
                                
				
				
				</td>
				
				
				</tr>
				<tr>
				<td colspan="2">&nbsp;</td>
				</tr>
				<tr >
					<td colspan="2" align="center">
					<div id="disbl">
						<input type="submit" name="Save" value="Save" class="actionbutton" onclick="return toSubmit();">
						</div>
						<div id="disbl1" style="display:none;">
						<input type="button" id="butt" name="Submitting" value="Submitting...." class="actionbutton">
						</div>
					</td>
					
			  	</tr>
				<tr>
					<td colspan="2" >&nbsp;</td>
				</tr>
		  </table>
                                        
                                    
                                
		  
		  
                                              
 </g:form>


											  </div></td>
                                                <td width="132" align="left" valign="top">&nbsp;</td>
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
                        <!-- code for spcb Footer -->
                        <g:include controller="userMaster" action="showSpcbFooter"/>
                     </table>
                  </td>
               </tr>
            </table>
            


<script type="text/javascript">
 var frmvalidator  = new Validator("myform");
 	//frmvalidator.addValidation("ddAmount","req","Please ennter consent Order No.");
    frmvalidator.addValidation("feeApplicableBothAct1","req","Please Calculate fees in Fee Tab");
   
    frmvalidator.addValidation("latestConsent","req","Please attach Copy of last / latest consent issued by the Board / PCC");
    frmvalidator.addValidation("photographs","req","Please attach file for Latest photographs of the unit, P&M and PCDs with date and name of the Industry on it");

 </script>

 <script type="text/javascript">
            
function Checkfiles(){
	//alert("ext");
	var frm = document.forms["myform"];


var fupp = document.getElementsByName('latestConsent');

var fup12 = fupp[0];


var fileName = fup12.value;

var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



//alert("ext 11");

if(ext != "pdf" && ext != "jpg" && ext != "bmp" && fileName !="" ){
alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
return false;
}
else {
return true;
}
}

            
 function Checkfiles1(){
//	alert("ext 222");
 var frm = document.forms["myform"];


 var fupp = document.getElementsByName('photographs');

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
frmvalidator.setAddnlValidationFunction("Checkfiles");
frmvalidator.setAddnlValidationFunction("Checkfiles1");

 </script>
            <!-- Added by Deepak kumar-->
            <script type="text/javascript">
            function toSubmit()
            {
            	  	
            //	alert("Inside function toSubmit");				  	
            	if((document.getElementById("noIncreaseProduction").checked) && (document.getElementById("noSewageTradeEffluent").checked) && (document.getElementById("noIncreaseStacksEmission").checked) && (document.getElementById("noChangeManagementOwnership").checked) && (document.getElementById("noCasePending").checked) && (document.getElementById("noIncreaseProductionOverconsented").checked) && (document.getElementById("devicesInstalled").checked) && (document.getElementById("consentConditions").checked) && (document.getElementById("failure").checked) && (document.getElementById("abide").checked))
             			{ 
            	     return true;
             				
             			} else{
             				       alert("Please Check All Required  Check Box");
             				        return false;
             				
             			      }
            }
            </script>	
            		    
   </body>
</html>