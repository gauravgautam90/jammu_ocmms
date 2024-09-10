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
     	//alert("Hiiiii "+dd);
     	
     	
		// Return today's date and time
		var currentTime = new Date()
		
		// returns the month (from 0 to 11)
		// var month = currentTime.getMonth() + 1
		
		// returns the day of the month (from 1 to 31)
		// var day = currentTime.getDate()
		
		// returns the year (four digits)
		var year = currentTime.getFullYear()+1
		var endyear = year + parseInt(dd)
		
		// write output MM/dd/yyyy
		//document.write(month + "/" + day + "/" + year)
		document.getElementById("strtDate").value= "01" + "/" + "04" + "/" + year;
		
		document.getElementById("endDate").value= "31" + "/" + "03" + "/" + endyear;
		
		//document.getElementById("validUpto").value= "31" + "/" + "03" + "/" + endyear;

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
   
    function Calculate1()
    {	
    var feeVal=parseInt(document.getElementById('showFeeValue').value);
    var a=3000;
    var b;
    var consent="<%=indApplicationDetailsInstance.certificateFor %>";
    var appFor= "<%=indApplicationDetailsInstance.applicationFor%>";
   
            
            if(feeVal => 1000000)
            {
            a=1000000+1000000
            }
            if(feeVal > 500000 && feeVal <= 1000000 )
    	    {
    	    a=750000+750000
    	    }
    	    if(feeVal > 100000 && feeVal <= 500000 )
    	    {
    	    a=500000+500000
    	    }
    	    if(feeVal > 60000 && feeVal <= 100000 )
    	    {
    	    a=400000+400000
    	    }
    	    if(feeVal > 30000 && feeVal <= 60000 )
    	    {
    	    a=250000+250000
    	    }
    	    if(feeVal > 10000 && feeVal <= 30000 )
    	    {
    	    a=150000+150000
    	    }
    	    if(feeVal > 5000 && feeVal <= 10000 )
    	    {
    	    a=100000+100000
    	    }
    	    if(feeVal > 500 && feeVal  <= 5000 )
    	    {
    	    a=75000+75000
    	    }
    	    else if(feeVal > 300 && feeVal <= 500 )
    	    {
    	    a=25000+25000
    	     }
    	    if(feeVal > 100 && feeVal <= 300 )
    	    {
    	    a=15000+15000
    	    }
    	    if(feeVal > 50 && feeVal <= 100 )
    	    {
    	    a=7000+7000
    	    }
    	    if(feeVal > 10 && feeVal <= 50 )
    	    {
    	    a=3000+3000
    	    }
    	   
    	    if(consent=='autoReNew')
    	    {
    	  //  b=(a*40/100)
    	    if(appFor=='both')
    	    {
    	    document.getElementById('feeApplicableBothAct').value=a
    	    }
    	    else
    	    {
    	    document.getElementById('feeApplicableBothAct').value=a/2	
    	    }
            }
    	    else{
        	//b=(a*40/100)
            if(appFor=='both')
        	{
        	document.getElementById('feeApplicableBothAct').value=a
        	}
        	else
        	{
        	document.getElementById('feeApplicableBothAct').value=a/2	
        	}
            }
            // alert('helo'+b)
   
    return true;
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
                                      <g:form name="myform" method="post" enctype="multipart/form-data" action="editAutoRenewConsent" >
                                         <div align="left" class="txt" style="color: navy">
											
                                                
											<% 
										  		def category=industryRegMasterInstance.category.id;
										  		def catApp=IndCatMaster.get(category).name;
										  		def GFA=industryRegMasterInstance.indCapInvt;
													
												
												//def category=(params.cat).toLong();
												System.out.println("-------jhghg-------"+industryRegMasterInstance.id);
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
											
												
				
												<input type="hidden" id='indAppDetId' name="indAppDetId" value="${indApplicationDetailsInstance?.id}" /> 
				
                                            <div >
                                                
                                                
                                                <table><td><tr>
                                                <%if(indApplicationDetailsInstance.certificateFor=="autoReNew"){%>
                                        		
                                        		<tr>
                                        		<td >
                                        			<table  width="100%" >
                                        				<tr >
                                        				
                                        					<td >
                                        					<font size="1" face="Verdana">
                                        					</font></td>
                                        					<td width="50%" bgcolor="" align="left" style="border-style: ridge; border-width: 0px; padding: 0"><font size="1" face="Verdana">
                                        						<% 
                                        						    
                                        						    if(formView=="air") 
                                        						    {%>
                                        					        <%}else
                                        							{
                                        						     if(formView=="water")
                                        					 			{
                                        					 			%> 
                                        								<%}else
                                        								{
                                        								%>	
                                        								
                                        					            </td>
                                        					
                                        				</tr>
                                        			</table>
                                        		</td>
                                        					<%}
                                        				}%>
                                        	
                                        		
                                        	</tr>
                                        		
                                        		
                                        		<%if(indApplicationDetailsInstance.applicationType=="CTO"){%>
                                        			
                                        		
                                        		
                                        		<tr><td width="100%"  bgcolor="" align="left" >
                                        		<g:def var="versionValUnderTaking31" value="underTakingLetter"/> 
                                        			<g:def var="fooVar1121" value="${indApplicationDetailsInstance.id}"/>
                                        			<g:link action="viewAutoRenewConsentWater" controller="indApplicationDetails" params="[appliLoc:fooVar1121,verValue:versionValUnderTaking31]">
                                        			<span class="innerlink"></br><b>Download Consent order.</b></span></g:link>
                                        		</td>
                                        		
                                        		<td  width="150%"  bgcolor="" align="right" ><font size="1" face="Verdana">
                        						<% 
                        						    
                        						    if(formView=="air") 
                        						    {%>
                        							<g:def var="versionVal" value="air"/> <g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdfAutoRenew" controller="indApplicationDetails" params="[appliLoc:fooVar,verValue:versionVal]"><span class="innerlink"></br><b>Print (Form Air)</b></span></g:link>
                        					        <%}else
                        							{
                        						     if(formView=="water")
                        					 			{
                        					 			%> 
                        					 			<g:def var="versionVal1" value="water"/> <g:def var="fooVar1" value="${indApplicationDetailsInstance.id}"/><g:link action="viewFormPdfAutoRenew" controller="indApplicationDetails" params="[appliLoc:fooVar1,verValue:versionVal1]"><span class="innerlink"></br><b>Print (Form Water)</b></span></g:link>
                        								<%}else
                        								{
                        								%>	
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
                                        		
                                        	<%}}}else{%>
                                        			<tr><td width="100%" colspan="3" bgcolor="" align="left" >
                                        			<g:def var="versionValLatest4" value="statusOfConstruction"/> 
                                        	   		<g:def var="fooVar" value="${indApplicationDetailsInstance.id}"/>
                                        	   		<g:link action="viewAttechedDocumentCTE" controller="indApplicationDetails" params="[appliLoc:fooVar,verValue:versionValLatest4]">
                                        	   		<span class="innerlink"></br><b>1.Status of construction with Chartered Engineer certificate.</b></span></g:link>
                                        	   	</td>
                                        	</tr>
                                        	<tr><td width="100%" colspan="3" bgcolor="" align="left" >
                                        	<g:def var="versionValCompliance5" value="selfCertificateReport"/> 
                                        		<g:def var="fooVar13" value="${indApplicationDetailsInstance.id}"/>
                                        		<g:link action="viewAttechedDocumentCTE" controller="indApplicationDetails" params="[appliLoc:fooVar13,verValue:versionValCompliance5]">
                                        		<span class="innerlink"></br><b>2.Self certification in the format prescribed .</b></span></g:link>
                                        	</td>
                                        	</tr>
                                        	<tr><td width="100%" colspan="3" bgcolor="" align="left" >
                                        	<g:def var="versionValUnderTaking6" value="otherDocument"/> 
                                        	<g:def var="fooVar114" value="${indApplicationDetailsInstance.id}"/>
                                        	<g:link action="viewAttechedDocumentCTE" controller="indApplicationDetails" params="[appliLoc:fooVar114,verValue:versionValUnderTaking6]">
                                        	<span class="innerlink"></br><b>3.Any other Documents.</b></span></g:link>
                                        	</td>
                                        	</tr>
                                        		
                                        	
                                        			 <%}%>
                                        			<%}%>
                                                
                                                </td></tr></table>
                                                
                                               <%
                                				System.out.println("indApplicationDetailsInstance.id "+indApplicationDetailsInstance.id);
                                				def selfDeclarationLetterSheet=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Undertaking Letter/Self-Declaration Letter for Auto Renewal' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				System.out.println("selfDeclarationLetterSheet "+selfDeclarationLetterSheet);
                                				def complianceToConsent=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Upload Self Monitoring report of MoEF/Board/PCC Lab' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				System.out.println("complianceToConsent "+complianceToConsent);
                                				def latestConsent=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Copy of last / latest consent issued by the Board / PCC' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                			    System.out.println("latestConsent "+latestConsent);
                                				def unitFall=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='The unit falls under the provisions of PWM Rules, 2016 (PIPB)' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				System.out.println("unitFall "+unitFall);
                                				def legalAction=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Legal action taken by the JKPCC (Notice/Closure order/withdrawal order)' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				System.out.println("legalAction "+legalAction);
                                				def photographs=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Latest photographs of the unit, P&M and PCDs with date and name of the Industry on it' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                		       	System.out.println("photographs "+photographs);
                                				def otherReport=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Other Report' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                			    def permanentRegistration=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Copy of DIC Permanent Registration' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				//def airResultCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Air Results' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				//def waterResultCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Water Results' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				
                                				//def prjReportCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='Approval of industries department / Approved project report' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				//def eiaReportCheck=ApplicationDocuments.find("from ApplicationDocuments where indApplication.id=? and level='EIA Applicable' order by id desc",[(indApplicationDetailsInstance.id).toLong()])
                                				
                                				
                                				%>
                                				
                                				<%
                                                def appCheck = ApplicationPendingDetails.find("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO' order by completionDate desc",[industryRegMasterInstance])
                                                
                                                def recordInst = RecordCertificate.find("from RecordCertificate where applicationId=? and applicationId.applicationType='CTO' and typeofCertificate = 'Prepared' order by dateCreated desc",[appCheck.application])
                                                def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
                                                %>
                                                
                                             <div id="country1" >
                                                <table width="118%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
                                             
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
						 <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">  i. Email :</td>
                      							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indEmail}</td>
                      							  </tr>
                         <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">  ii. Contact No. :</td>
                      							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indPhoneNo}</td>
                      
															
            </tr>
        <tr>
                                                  <td width="60%" align="center" colspan="2" valign="middle" bgcolor="#A8DAF3" class="headngblue">SELF CERTIFICATION / UNDERTAKING:</td>
                      							
                      							  </tr>
                      							  <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">i. that there is no increase in production over the consented quantity.</td>
                                                  <td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.noIncreaseProduction} </td>
                      							  </tr>
                				  <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">ii. that there is no increase in quantity of sewage and trade effluent over the consented quantity.</td>
                                                  <td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj.noSewageTradeEffluent}  </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">iii. that there is no increase in the number of stacks and in emission over the consented quantity.</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"> ${auotoRenewObj?.noIncreaseStacksEmission} </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">iv. that there is no change in the management or ownership of the company.</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.noChangeManagementOwnership}</td>
                      							  </tr>
                      							  
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">v. that no court case is pending in respect of our unit against the Board/JK PCC in High Court/Supreme Court/NGT/Appellate Authority or any other courts (as applicable).</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.noCasePending}</td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">vi. that adequate Pollution Control Devices are installed / pollution control measures have been adopted in our unit efficiently as per norms.</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.devicesInstalled}</td>
                      							  </tr>
                      							 <tr>
                                                 <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">vii. I/we certify that the information / data provided above are true to the best of my/our knowledge  and submission of false information or suppression of any factual information in the above self certification form would attract an action under environmental laws.</td>
                     						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.noIncreaseProductionOverconsented}</td>
                     							  </tr>
                      							  
                      							    <tr>
                                                  <td width="60%" align="center" colspan="2" valign="middle" bgcolor="#A8DAF3" class="headngblue">Self Declaration / Compliance:</td>
                      							
                      							  </tr>
                				 <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">viii. that the consent conditions stipulated in the earlier consent issued by the Board / JK PCC have been complied.</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.consentConditions} </td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">ix. I understand that failure on my part to comply with the prescribed standards or conditions of consent is liable to attract action as warranted under extant environmental laws.</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue"> ${auotoRenewObj?.failure}</td>
                      							  </tr>
                      							   <tr>
                                                  <td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">x. that I hereby agree to abide by all the conditions mentioned in the self declaration / certification / undertaking.</td>
                      						    	<td width="40%" align="center" bgcolor="#E8F6F9"  class="headngblue">${auotoRenewObj?.abide}</td>
                      							  </tr>
		
			 
                      							<tr>
                      							<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Copy of last consent issued by the Board / PCC:</td>
                      							<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><br><a class="addViewDelete"
                      				                href="#"
                      				                    style="color: #0645AD"
                      				                    onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowOfficer/<%=appCheck.applicationId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                      				                     View Previous Consent Form
                      				                 </a> <br><br>
                      										<%if(latestConsent){%>
                      				<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${latestConsent.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
                      				<%}%> 
                      				<br><br>
                      						 
                      							 </td>
                      						</tr>
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">If the unit falls under the provisions of PWM Rules, 2016 (PIPB):<br>
        				(If yes, the unit holder is required to upload EPR endorsed by Secretary, UDD, JK UT as per Rule 9 and 13 of PWM Rules, 2016)<span style="color:red">*</span></td>
        				
				<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><br><span class="sidetxt"></span><br>
				<%if(unitFall){%>
				<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${unitFall.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
			<%}%>
			</td>
				
			</tr>
			
		
		
		
	



<tr>
<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Latest photographs of the unit, P&M and PCDs with date and name of the Industry on it<span style="color:red">*</span></td>
	
<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><br><span class="sidetxt"></span><br>
<%if(photographs){%>
<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${photographs.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
<%}%>
</td>

</tr>

			
			 
			
			 
			<input type="hidden" id='consentType' name="consentType" value="${consentType}"/>
			
	      <%if(consentType=="CTO"){%>
			
		
		
		
		
		
		
	
	
		
		
	
	
<tr height="40px">
<%
def noOfYear = ""

if(auotoRenewObj){
	 noOfYear = auotoRenewObj.noOfYear
}

%>
<td  align="left" width="60%" bgcolor="#A8DAF3" class="headngblue">Number of Years/Periods for which Consent Renewal Required<span style="color:red"></span>: </td>
<td  align="left" width="40%" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4">					
<!--<g:select  onchange="calYear()" from="${['1','2','3','4','5','6','7','8','9','10','11','12']}" name="yearsApplied" value="${noOfYear}" class="txt4"></g:select> -->

${noOfYear} (In Years)
<table align="right" width="80%">
	<tr>
		<td  align="center" width="20%" bgcolor="#E8F6F9" class="headngblue"><span class="txt4"><input type="hidden" id="strtDate" name="strtDate" size="7" type="text" value="${str1}"/></td>
		<td  align="center" width="20%" bgcolor="#E8F6F9" class="headngblue"><span class="txt4"><input type="hidden" id="endDate" name="endDate" size="7" type="text" value="${str2}"/></td>
	</tr>
</table>
	</td>
</tr> 

<!--	<%
	if(indApplicationDetailsInstance.applicationFor=="air" || indApplicationDetailsInstance.applicationFor=="both"){	
		
		%>
	<tr>
<	<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Air Results :</td>
	<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">

	

	<%if(airResultCheck){%>
	<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${airResultCheck.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
	<%}%> 

	</td>
	</tr>
	<%}
	if(indApplicationDetailsInstance.applicationFor=="water" || indApplicationDetailsInstance.applicationFor=="both"){	
	%>
	<tr>
	<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Water Results :</td>
	<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">

	

	<%if(waterResultCheck){%>
	<g:link controller="indApplicationDetails" action="downLoadUploadedDoc"  id="${waterResultCheck.id}" ><span class="innerlink">&nbsp;View Document&nbsp;</span></g:link>
	<%}%> 

	</td>
	</tr>

	<%}
      }%> -->
      
			<%
		//	def indPenList=ApplicationPendingDetails.find("from ApplicationPendingDetails where application.id=? and scrutinyStatus='In-Complete' order by id desc",[indApplicationDetailsInstance.id])
			//	System.out.println("indPenList------"+indPenList)
			%>
			
	<!-- only return case execute-->	
			
			<tr bgcolor="#417FB2">
					<td width="100%" colspan="2" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span></td>
			</tr> 
			<tr>
					<td colspan="2">
					<table width="100%" border="0" >
							
					
					<input type="hidden" name="showFeeValue" id="showFeeValue" value="${industryRegMasterInstance?.indCapInvt}"/>
					
					
						<tr>
							<!--<td width="10%" class="headngblue" align="center">Payment of Consent Fee</td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsAdd?id=<%=indApplicationDetailsInstance.id%>&indId=<%=industryRegMasterInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>-->
							<!--<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsView?id=<%=indApplicationDetailsInstance.id%>&gfaValue=<%=industryRegMasterInstance.indCapInvt%>&cat=<%=industryRegMasterInstance.category%>&captInvAS=<%=indCapInvt%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
							<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>	-->				
						</tr>
							
						<tr>
						<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Category:</td>
							<td width="45%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance.category}</td>
						</tr>
						<tr >
						<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Capital Investment (In Lakhs) <br> (Land & Building, Plant and Machinery):</td>
						<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span>${industryRegMasterInstance?.indCapInvt}</span> <span style="color:black"> In Lakhs.</span></td>
						</tr>
						
						<tr >
						<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Consent Fee Applicable : </td>
						<td  align="left" bgcolor="#E8F6F9" class="headngblue"><span>${auotoRenewObj?.feeApplicable} </span> <span style="color:black">Rs.</span></td>
						</tr>
						
						<% String cont=request.getContextPath(); %>
						
						 
						 <% def feeApplicableWaterAct=0
						 
						  def totalFeeDemand=0
						 
						 if(consentFeeMasterInstance)
						 {
						    feeApplicableWaterAct=Math.round(consentFeeMasterInstance?.feeApplicableWaterAct)
							//feeApplicableBothAct=Math.round(consentFeeMasterInstance?.feeApplicableBothAct)
							totalFeeDemand=Math.round(consentFeeMasterInstance?.totalFeeDemand) 
							} %>
							
							   
							
						<!--	<tr>
								<td  align="left"  bgcolor="#E8F6F9" class="headngblue">Consent Fee Applicable : </td>
								<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
							
								<input name="feeApplicableBothAct1" id="feeApplicableBothAct1" type="hidden" value=""/>
								&nbsp;<span class="sidetxt">(In Rs.)</span></span></td>
							</tr>  -->
						 
							
					</table>
					</td>
				</tr> 
												
                                                </table>
                                               </td> 
                                              </tr>  
                                            </table>    
                                          </div>
                                        </div>
                                        
                                        
                                         
		     <table width="100%" align="center">
				
				<tr>
				<td colspan="2">&nbsp;</td>
				</tr>
				<tr >
					<td colspan="2" align="center">
					<div id="disbl">
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
    frmvalidator.addValidation("feeApplicableBothAct","req","Please Calculate fees in Fee Tab");
   
   //frmvalidator.addValidation("auditatedBalanceSheet","req","Please choose file for Audited balance sheet And Please upload non-editable files only (.jpg,.pdf,.bmp)");
    //frmvalidator.addValidation("complianceToConsent","req","Please choose file for Compliance to consent conditions And Please upload non-editable files only (.jpg,.pdf,.bmp)");

 </script>

 <script type="text/javascript">
            
function Checkfiles(){
var frm = document.forms["myform"];


var fupp = document.getElementsByName('auditatedBalanceSheet');

var fup12 = fupp[0];


var fileName = fup12.value;

var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



//alert(ext);

if(ext != "pdf" && ext != "jpg" && ext != "bmp" && fileName !="" ){
alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
return false;
}
else {
return true;
}
}

            
 function Checkfiles1(){
var frm = document.forms["myform"];


var fupp = document.getElementsByName('complianceToConsent');

var fup12 = fupp[0];


var fileName = fup12.value;

var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



//alert(ext);

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
            
            		    
   </body>
</html>