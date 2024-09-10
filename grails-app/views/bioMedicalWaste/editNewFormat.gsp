<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
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


<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
function changeOtherCheckBox(){

if(document.getElementById('checkboxGeneration').checked==true){
document.getElementById('checkboxCollection').checked=true;
document.getElementById('checkboxReception').checked=true;
document.getElementById('checkboxStorage').checked=true;
}
}
function check1()
    {

   			var selectmenu1=document.getElementById('addrPlaceDisposalOfWaste.id').value;
   			

  		
		if(selectmenu1 == "Other")
		{
		
			document.getElementById('selectTemp').style.display = 'block';
						document.getElementById('selectTemp1').style.display = 'block';
			
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
							document.getElementById('selectTemp1').style.display = 'none';
				
		}

       
    }
    

function hidediv() {

for(var i = 0; i<document.myform.radiobuttonfresh.length; i++){
 if(document.myform.radiobuttonfresh[i].checked){
 var radiomenu = document.myform.radiobuttonfresh[i]

   	 if (radiomenu.value == "FreshApplication") { 
 			
 			console.log("---Inside in Fres")
 			document.getElementById('prevauthNo').disabled = true;
 			document.getElementById('prevauthDate').disabled = true;
 			document.getElementById('prevExpDate').disabled = true;
 			
 			document.getElementById('SelectTemp11').style.display = 'none';
 			document.getElementById('SelectTemp22').style.display = 'none';
 			
 	        
		} 
	
		else { 
	
		document.getElementById('prevauthNo').disabled = false;
		document.getElementById('prevauthDate').disabled = false;
 			document.getElementById('prevExpDate').disabled = false;
		document.getElementById('SelectTemp22').style.display = 'block';
		document.getElementById('SelectTemp11').style.display = 'block';
	
					}  
	
			
		} 
	} 
}

function hidediv()
{
document.getElementById('selectTemp919').style.display = 'none';
document.getElementById('selectTemp199').style.display = 'none';

document.getElementById('auth').style.display = 'none';
document.getElementById('auth1').style.display = 'none';
document.getElementById('auth2').style.display = 'none';
document.getElementById('prevauthNo').disabled = true;
document.getElementById('prevauthDate').disabled = true;
document.getElementById('prevExpDate').disabled = true;



}


function hidedivRenew()
{
document.getElementById('selectTemp919').style.display = 'block';
document.getElementById('selectTemp199').style.display = 'block';
document.getElementById('auth').style.display = 'block';
document.getElementById('auth1').style.display = 'block';
document.getElementById('auth2').style.display = 'block';
document.getElementById('prevauthNo').disabled = false;
document.getElementById('prevauthDate').disabled = false;
document.getElementById('prevExpDate').disabled = false;

}

 function hidediv() {
    for(var i = 0; i<document.myform.radioIs_Renew.length; i++){
 if(document.myform.radioIs_Renew[i].checked){
 var radiomenu = document.myform.radioIs_Renew[i]

   	 if (radiomenu.value == "fresh") { 
 		 
 		  document.getElementById('SelectTemp11').style.display = 'none';	
         document.getElementById('authorization11').style.display = 'none';
         document.getElementById('ShowFreshAuth').style.display = 'block';
	        document.getElementById('ShowRenewAuth').style.display = 'none';
	        
		} 
	
		if (radiomenu.value == "renew") { 
	    
	    document.getElementById('SelectTemp11').style.display = 'block';
		document.getElementById('authorization11').style.display = 'block';
		 document.getElementById('ShowFreshAuth').style.display = 'none';
	        document.getElementById('ShowRenewAuth').style.display = 'block';
					}  
	
			
		} 
	} 
}



//addded by sharvan start
 function checkField(id)
    {
         // alert('Inside checkfield function'+id)
        if (id.value == "" )
        {
    
            id.value = "0";
        }
        var total=0;
        var a=eval(document.getElementById("anatomicalwaste").value);
        var a1=document.getElementById("anatomicalwaste").value;
        if(a1.indexOf(".")>-1){
        var a11=a1.split(".");
        if(a11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("anatomicalwaste").value=eval(document.getElementById("anatomicalwaste").value).toFixed(2);
        }
        }
        var b=eval(document.getElementById("animalwaste").value);
        var b1=document.getElementById("animalwaste").value;
        if(b1.indexOf(".")>-1){
        var b11=b1.split(".");
        if(b11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("animalwaste").value=eval(document.getElementById("animalwaste").value).toFixed(2);
        }
        }
        var c=eval(document.getElementById("soiledwaste").value);
        var c1=document.getElementById("soiledwaste").value;
        if(c1.indexOf(".")>-1){
        var c11=c1.split(".");
        if(c11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("soiledwaste").value=eval(document.getElementById("soiledwaste").value).toFixed(2);
        }
        }
        var d=eval(document.getElementById("discardedwaste").value);
        var d1=document.getElementById("discardedwaste").value;
        if(d1.indexOf(".")>-1){
        var d11=d1.split(".");
        if(d11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("discardedwaste").value=eval(document.getElementById("discardedwaste").value).toFixed(2);
        }
        }
        var e=eval(document.getElementById("chemicalSolidWaste").value);
        var e1=document.getElementById("chemicalSolidWaste").value;
        if(e1.indexOf(".")>-1){
        var e11=e1.split(".");
        if(e11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("chemicalSolidWaste").value=eval(document.getElementById("chemicalSolidWaste").value).toFixed(2);
        }
        }
        var f=eval(document.getElementById("chemicalLiquidWaste").value);
        var f1=document.getElementById("chemicalLiquidWaste").value;
        if(f1.indexOf(".")>-1){
        var f11=f1.split(".");
        if(f11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("chemicalLiquidWaste").value=eval(document.getElementById("chemicalLiquidWaste").value).toFixed(2);
        }
        }
        var g=eval(document.getElementById("discardedLinen").value);
        var g1=document.getElementById("discardedLinen").value;
        if(g1.indexOf(".")>-1){
        var g11=g1.split(".");
        if(g11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("discardedLinen").value=eval(document.getElementById("discardedLinen").value).toFixed(2);
        }
        }
        var h=eval(document.getElementById("otherClinicLabWaste").value);
        var h1=document.getElementById("otherClinicLabWaste").value;
        if(h1.indexOf(".")>-1){
        var h11=h1.split(".");
        if(h11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("otherClinicLabWaste").value=eval(document.getElementById("otherClinicLabWaste").value).toFixed(2);
        }
        }
        var i=eval(document.getElementById("contaminatedWaste").value);
        var i1=document.getElementById("contaminatedWaste").value;
        if(i1.indexOf(".")>-1){
        var i11=i1.split(".");
        if(i11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("contaminatedWaste").value=eval(document.getElementById("contaminatedWaste").value).toFixed(2);
        }
        }
        var j=eval(document.getElementById("wasteSharps").value);
        var j1=document.getElementById("wasteSharps").value;
        if(j1.indexOf(".")>-1){
        var j11=j1.split(".");
        if(j11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("wasteSharps").value=eval(document.getElementById("wasteSharps").value).toFixed(2);
        }
        }
        var k=eval(document.getElementById("glassWare").value);
        var k1=document.getElementById("glassWare").value;
        if(k1.indexOf(".")>-1){
        var k11=k1.split(".");
        if(k11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("glassWare").value=eval(document.getElementById("glassWare").value).toFixed(2);
        }
        }
        var l=eval(document.getElementById("metallicBodyImplants").value);
        var l1=document.getElementById("metallicBodyImplants").value;
        if(l1.indexOf(".")>-1){
        var l11=l1.split(".");
        if(l11[1].length>2){
        	alert("Please Enter only two digits after decimal");
        	document.getElementById("metallicBodyImplants").value=eval(document.getElementById("metallicBodyImplants").value).toFixed(2);
        }
        }
        if(a!='' && a!=null){
        total=total+a;
        }
        if(b!='' && b!=null){
        total=total+b;
        } 
        
        if(c!='' && c!=null){
        total=total+c;
        } 
        if(d!='' && d!=null){
        total=total+d;
        } 
        if(e!='' && e!=null){
        total=total+e;
        } 
        if(f!='' && f!=null){
        total=total+f;
        } 
        
        if(g!='' && g!=null){
        total=total+g;
        } 
       
        if(h!='' && h!=null){
        total=total+h;
        } 
        if(i!='' && i!=null){
        total=total+i;
        } 
        
        
        if(j!='' && j!=null){
        total=total+j;
        } 
        
        if(k!='' && k!=null){
        total=total+k;
        } 
        
        if(l!='' && l!=null){
        total=total+l;
        } 
        
        
       //alert("Sum" +total)
    //document.getElementById("total1").value = eval(document.getElementById("anatomicalwaste").value)+eval(document.getElementById("animalwaste").value)+eval(document.getElementById("biowaste").value)+eval(document.getElementById("wastesharp").value)+eval(document.getElementById("discardedwaste").value)+eval(document.getElementById("soiledwaste").value)+eval(document.getElementById("solidwaste").value)+eval(document.getElementById("ash").value)+eval(document.getElementById("chemicalwaste").value);
    var total1=total.toString();
    if(total1.indexOf(".")>-1){
    document.getElementById("total1").value =total.toFixed(2);
    }
    else{
      document.getElementById("total1").value =total;
    }
      
    }
     function checkField2(id)
    {
    
        if (id.value == "" )
        {
    
            id.value = "0";
        }
        var total=0;
        var a=eval(document.getElementById("anatomicalwaste1").value);
        var b=eval(document.getElementById("animalwaste1").value);
        var c=eval(document.getElementById("biowaste1").value);
        var d=eval(document.getElementById("wastesharp1").value);
        var e=eval(document.getElementById("discardedwaste1").value);
        var f=eval(document.getElementById("soiledwaste1").value);
        var g=eval(document.getElementById("solidwaste1").value);
        var h=eval(document.getElementById("ash1").value);
        var i=eval(document.getElementById("chemicalwaste1").value);
        if(a!='' && a!=null){
        total=total+a;
        }
        if(b!='' && b!=null){
        total=total+b;
        } 
        
        if(c!='' && c!=null){
        total=total+c;
        } 
        if(d!='' && d!=null){
        total=total+d;
        } 
        if(e!='' && e!=null){
        total=total+e;
        } 
        if(f!='' && f!=null){
        total=total+f;
        } 
        if(g!='' && g!=null){
        total=total+g;
        } 
        if(h!='' && h!=null){
        total=total+h;
        } 
        if(i!='' && i!=null){
        total=total+i;
        }
    
          
    //document.getElementById("total2").value = eval(document.getElementById("anatomicalwaste1").value)+eval(document.getElementById("animalwaste1").value)+eval(document.getElementById("biowaste1").value)+eval(document.getElementById("wastesharp1").value)+eval(document.getElementById("discardedwaste1").value)+eval(document.getElementById("soiledwaste1").value)+eval(document.getElementById("solidwaste1").value)+eval(document.getElementById("ash1").value)+eval(document.getElementById("chemicalwaste1").value);
      document.getElementById("total2").value=total;
    }
    
   //end


 function Calculate()
   {	
   	//alert("inside calculate");
   	var etc;
   	
   	var indTyp;
   	
   		indTyp=document.getElementById('catVale').value;
   	//alert("indTye......."+indTyp);
   	
   	var capitalInvestMent=document.getElementById('noOfMaterials').value;
   	//alert("capitalInvestMent     "+capitalInvestMent);
   	
   	var result;
   	
   	var ValidationRequired;
   	
   	ValidationRequired="/^.*(?=.*[0-9]).*$/";

   	// Calculating applicable consent fee based on above selection	
   			if(indTyp=="HOSPITAL")
      		{
      		etc = document.getElementById('indNewCapInvt').value;
      //		alert("etc   "+etc);
      		
      		
      		
      		
      			if(capitalInvestMent <= 4)
       		{
       			if(etc!=0)
       			{
       				result=1000;
       			}
       			else
       			{
       				result=500;
       			}
       		}
       		else if(  capitalInvestMent >=  5 && capitalInvestMent <= 24)
       		{
       			if(etc!=0)
       			{
       				result=2500;
       			}
       			else
       			{
       				result=1000;
       			}
       		}
       		else if(capitalInvestMent >= 25 && capitalInvestMent <= 49)
       		{
       		if(etc!=0)
       			{
       				result=5000;
       			}
       			else
       			{
       				result=2500;
       			}
       		}
       		else if(capitalInvestMent >= 50 && capitalInvestMent <= 199)
       		{
       		if(etc!=0){
       			result=7500;
       			}
       			else{
       			result=5000;
       			}
       		}
       		else if(capitalInvestMent >= 200 && capitalInvestMent <= 499)
       		{
       			if(etc!=0){
       			result=10000;
       			}
       			else{
       			result=7500;
       			}
       		}
       		else if(capitalInvestMent >= 500)
       		{
       			result=10000;
       			
       		}
       	}
       	else if(indTyp=="DENTAL CLINIC")
      		{
      			if(capitalInvestMent <= 2499)
       		{
       			result=500;
       		}
       		else if(  capitalInvestMent >= 2500 && capitalInvestMent <=4999)
       		{
       			result=1000;
       		}
       		else if(capitalInvestMent >=  5000 && capitalInvestMent <=7499)
       		{
       			result=2500;
       		}
       		else if(capitalInvestMent >=  7500 && capitalInvestMent <=9999)
       		{
       			result=5000;
       		}
       		
       		else if(capitalInvestMent >=  10000)
       		{
       			result=7500;
       			
       		}
       	}
       	
   		else if(indTyp=="LAB"||indTyp=="BLOOD BANK"||indTyp=="VETERINARY"|| indTyp=="CLINIC")
      		{
      			if(capitalInvestMent <= 2499)
       		{
       			result=500;
       		}
       		else if(capitalInvestMent >= 2500 && capitalInvestMent <= 4999)
       		{
       			result=1000;
       		}
       		else if(capitalInvestMent >=  5000 && capitalInvestMent <= 7499)
       		{
       			result=2500;
       		}
       		else if(capitalInvestMent >=  7500 && capitalInvestMent <= 9999)
       		{
       			result=5000;
       		}
       		else if(capitalInvestMent >= 10000)
       		{
       			result=7500;
       		}
       		
       	}		
       	
       	
       	
   		var feeApp = document.getElementsByName('feeApplicable');
   		//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
   		
   			if( feeApp != null){
   				
   				//alert("asas");
   				feeApp[0].value=result*(1);
   				
   				//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
   			}
   	return true;
   }



</script>

<script type="text/javascript">

function select1()
{
   	 var chosenoption=document.getElementById('test1')
   	 if(chosenoption.value == "HCF")
   	 {
       if(document.getElementById('hcfTypeMenu'))
   	 document.getElementById('hcfTypeMenu').style.display = 'block';
   	 if(document.getElementById('hcfTemp'))
   	  document.getElementById('hcfTemp').style.display = 'block';
   	  if(document.getElementById('cbmwtfTemp'))
   	   document.getElementById('cbmwtfTemp').style.display = 'none';
   	  if(document.getElementById('bmwfacility'))
   	   document.getElementById('bmwfacility').value = "HCF-Common Facility Member";
   	 // if(document.getElementById('tempA'))
   	   //document.getElementById('tempA').style.display = 'block';
   	  //if(document.getElementById('bmwofficeaddressHcf'))
   	   //document.getElementById('bmwofficeaddressHcf').style.display = 'block';
   	  //if(document.getElementById('bmwstatus'))
   	   //document.getElementById('bmwstatus').style.display = 'none';
   	  //if(document.getElementById('locfacilityHcf'))
   	    //document.getElementById('locfacilityHcf').style.display = 'block';
   	  //if(document.getElementById('locfacility'))
   	   //document.getElementById('locfacility').style.display = 'none';
   	  //if(document.getElementById('wastedisposalplaceHcf'))
   	    //document.getElementById('wastedisposalplaceHcf').style.display = 'block';
   	  //if(document.getElementById('wastedisposalplace'))
   	  // document.getElementById('wastedisposalplace').style.display = 'none';
   	   
   	  // document.getElementById("checkboxGeneration").checked=true;
   	   //document.getElementById("checkboxStorage").checked=true;
   	   //document.getElementById("checkboxCollection").checked=true;
   	   //document.getElementById("checkboxDisposal").checked=true;
   	   
   	   //document.getElementById("checkboxCollection").checked=false;
   	   //document.getElementById("checkboxTransportation").checked=false;
   	   //document.getElementById("checkboxTreatment").checked=false;
   	   //document.getElementById("checkboxReception").checked=false;*/
   	   //document.getElementById("checkboxDisposal").checked=false;
	 }
else if(chosenoption.value == "CBMWTF"){

        if(document.getElementById('hcfTypeMenu'))
    	document.getElementById('hcfTypeMenu').style.display = 'none';
    	if(document.getElementById('hcfTemp'))
    	document.getElementById('hcfTemp').style.display = 'none';
     	if(document.getElementById('cbmwtfTemp'))
     	document.getElementById('cbmwtfTemp').style.display = 'block';
     	if(document.getElementById('bmwfacility'))
     	document.getElementById('bmwfacility').value = "CBMWTF-Common Facility";
     	//if(document.getElementById('tempA'))
     	//document.getElementById('tempA').style.display = 'none';
     	//if(document.getElementById('bmwofficeaddressHcf'))
     	//document.getElementById('bmwofficeaddressHcf').style.display = 'none';
   	   //if(document.getElementById('bmwstatus'))
   	   //document.getElementById('bmwstatus').style.display = 'block';
   	   //if(document.getElementById('locfacilityHcf'))
   	   //document.getElementById('locfacilityHcf').style.display = 'none';
   	   //if(document.getElementById('locfacility'))
   	    //document.getElementById('locfacility').style.display = 'block';
   	   //if(document.getElementById('wastedisposalplaceHcf'))
   	   //document.getElementById('wastedisposalplaceHcf').style.display = 'none';
   	   //if(document.getElementById('wastedisposalplace'))
   	    //document.getElementById('wastedisposalplace').style.display = 'block';
   	    
   	    // document.getElementById("checkboxGeneration").checked=false;
   	   // document.getElementById("checkboxGeneration").checked=true;
   	   //document.getElementById("checkboxStorage").checked=false;
   	   //document.getElementById("checkboxCollection").checked=true;
   	   //document.getElementById("checkboxDisposal").checked=true;
   	   
   	    
   	    //document.getElementById("checkboxCollection").checked=true;
   	   //document.getElementById("checkboxTransportation").checked=true;
   	   //document.getElementById("checkboxTreatment").checked=true;
   	   //document.getElementById("checkboxReception").checked=true;
   	   //document.getElementById("checkboxDisposal").checked=true;*/
   	
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
								                        String userType = aa.accessLevel;
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
                    <tr><!-- Div area for errors-->
                     <span class="error"> <g:if test="${flash.message}">
            <div align="center" class="message">${flash.message}</div>
            </g:if></span>
            <g:hasErrors bean="${bioMedicalWasteInstance}">
            <div class="errors">
                <g:renderErrors bean="${bioMedicalWasteInstance}" as="list" />
            </div>
            </g:hasErrors>
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
    <g:form name="myform" action="saveEditNewFormat" method="post" enctype="multipart/form-data">
    <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
    <input type="hidden" name="bioMedId" value="${bioMedicalWasteInstance?.id}" />
    <input type="hidden" name="editableMode" value="${editableMode}" />
    <input type="hidden" name="testValue" value="${testValue}" />
   <table width="100%" border="0" align="center" cellpadding="2" cellspacing="1"  >
				<tr>
                  <td width="100%">
					<ol id="toc">
						<li><a href="#country1"><span>General Details</span></a></li>
						<li><a href="#country2"><span>Bio-Medical Waste Generation Details</span></a></li>
						<li><a href="#country6"><span>Bio-Medical Waste Management Details</span></a></li>
						<!--<li><a href="#country4"><span>Documents</span></a></li>-->											
						<li><a href="#country3"><span>BMW Treatment Equipments details</span></a></li>
						<li><a href="#country7"><span>Fee</span></a></li>	
						<li><a href="#country4"><span>Documents</span></a></li>
						
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
         
         <% //System.out.println("Insideeeee jsp edittt block"+bioMedicalWasteInstance) 
      def bioMedicalWasteInst =BioMedicalWaste.find("from BioMedicalWaste where id=?",[bioMedicalWasteInstance.id]) 
      		def hcfType=bioMedicalWasteInst.hcfType
      		def bmwstatus=bioMedicalWasteInst.bmwstatus
           //System.out.println("Query Executedddd in edit blockkkk>>>"+bioMedicalWasteInst)
           //System.out.println("Query Executedddd in edit blockkkk>>>"+bmwstatus)
           %>
         
         
     <!--*************Country 1 Start from Here*********--> 
         		    <div class="content" id="country1" >
		   <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		   <!-- added by sharvan for new changes  start from here (code commented )-->
		   <!--<tr>
					<td   align="center" valign="middle" bgcolor="#D1D1D1" colspan=2 class="headngblue">Applicant Details</td>
					
			</tr>
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Applicant Name <span style="color:red">*</span>: </td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstance?.occName} 
					
					</td>
				</tr> 
			
		      <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation<span style="color:red">*</span>: </td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					 ${indRegInstance?.occDesignation}
					</td>
			</tr> 
			<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name: </td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indName}
					</td>
			</tr> 
		   	<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Address:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.indAddress}
					</td>
			</tr> 
		   
		   <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${indRegInstance?.category}
					</td>
			</tr> 
		       
		   
		
			
			<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Type: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="applicantDesignation" size="80" readonly name="applicantDesignation" value="${indRegInstance?.industryType}" /></span></td>
				</tr>--> 
			
          <tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Wheather your HCF/CBMWTF generates/handles Bio-Medical Wastes</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">Yes
					  
					</td>
			</tr> 
			
		<tr>
			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> BMW Authorization now Applied For <span style="color:red">*</span> :</td>
			<td width="60%" bgcolor="#E8F6F9"  align="left" class="headngblue">
		<g:if test="${bioMedicalWasteInstance.authorisationAppliedFor=='fresh'}">
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="fresh" onclick="hidediv();"   checked="checked"/>
		
		</g:if>
		<g:else>
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="fresh" onclick="hidediv();"   />
		</g:else>
		Fresh 
		<g:if test="${bioMedicalWasteInstance.authorisationAppliedFor=='renew'}">
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="renew" onclick="hidediv();" checked="checked"/>
		</g:if>
		<g:else>
		<input name="authorisationAppliedFor" id="radioIs_Renew" type="radio"  value="renew" onclick="hidediv();"   />
		</g:else>
		
		Renew
		
    </td>
			</tr> 
			
		  <!-- ##################### BMW In Case Of Renewal ########################### -->
    <tr>
	<tr class="prop"><td colspan="2" valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"><div style="display:none; border:0;"  id="SelectTemp11"  >In case of Renewal,please enter the details of previously issued authorisation:(Attach copies of Authorisations) </div></td> </tr>
    
    <tr>
		<td colspan="3">														
	<div id="authorization11" style="display:none; border:0;" >
		<table>
		<tr>
		<%System.out.println("-----approveApplicationList---"+approveApplicationList.size());
		if(approveApplicationList.size()<=0){%>
		 <td bgcolor="#A8DAF3" width="60%" align="center" valign="middle"  class="headngblue"></td>
		 <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/addAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>                                                 
         <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/viewAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a></td>                                                 
         <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/deleteAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >Delete</a></td>
		<%}else{%>	
			<td bgcolor="#A8DAF3" width="60%" align="center" valign="middle"  class="headngblue"></td>
			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/addAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>                                                 
	         <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/viewAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >View</a></td>                                                 
	         <td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/deleteAuthorisationPopup/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" >Delete</a></td>                                                 
           	<%}%>
		</tr>
		</table>
 
 
   <!--		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="15%" align="center" class="headngblue">Date of Application for BWWA</td>
             <td  width="15%" align="center" class="headngblue">BMWA Type </td>
             <td  width="15%" align="center" class="headngblue">Authorisation No</td>
              <td  width="15%" align="center" class="headngblue">Issued date</td> 
              <td  width="15%" align="center" class="headngblue">Valid date</td>  </tr>
             <tr>
           <td><input type="text" name="HWApplication_Date" placeholder="dd/mm/yyyy"></td>
              <td><span class="headngblue"><select name="HWAType" id="menu" class="txt4"">
			<option  value="Fresh">Fresh</option>
			<option  value="Renewal">Renewal</option>
			</select></span>
			</td>
              <td><input type="text" name="AuthorisationNo" placeholder="Authorisation Number"></td>
            <td><input type="text" name="Issued_date" placeholder="dd/mm/yyyy"></td>
            <td><input type="text" name="Valid_date" placeholder="dd/mm/yyyy"></td>
               </tr>
                             </table>  -->
														    									
	</br>	
			</div>													
			    </td>
              	</tr>
              		
             	<%
              	scrutinyReturn=WasteManagementPendingDetails.find("from WasteManagementPendingDetails where applicationId= ? order by id desc",[bioMedicalWasteInstance.id.toString()])
              	if(scrutinyReturn){%>
				<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Scrutiny Reply<span style="color:red">*</span>: </td>
				<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
				<textarea name="scrutinyReply" rows="5" cols="45" id="scrutinyReply" maxlength="200" class="txt4"></textarea></td>
			</tr>
				<%}else{%>
				<%}%>
			
			
			
		    <tr class="prop">
                                <td colspan="2" valign="top" bgcolor="#A8DAF3" align="left" class="headngblue"> 
                                    <label for="activityAuthorizationSoughtFor">Activity for which Authorization is required for<span style="color:red">*</span>:</label>
                                </td>
                            </tr>
                           <tr class="prop">
                               <td colspan="2" width="100%" bgcolor="#E8F6F9"  class="headngblue">
								    <% int b=0;%>
									<g:if test="${tmp1}">
									<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Generation'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
										<g:if test="${b==1}">
										<input type="checkbox" name="checkboxGeneration" checked="checked" id="checkboxGeneration"  />
								  			Generation, segregation
							  			</g:if>
							  			<g:else>
							  				<input type="checkbox" name="checkboxGeneration" id="checkboxGeneration" />
								  			Generation, segregation 
							  			</g:else>
							  		
							  			
							  			
							  			<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Collection'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
										 <input type="checkbox" name="checkboxCollection" checked="checked" id="checkboxCollection"  />
								  			Collection 
							  			</g:if>
							  			<g:else>
						  				 <input type="checkbox" name="checkboxCollection" id="checkboxCollection" />
								  			Collection 
							  			</g:else>
							  			
							  			
							  	<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Storage'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		  <input type="checkbox" name="checkboxStorage" checked="checked" id="checkboxStorage" />
								        	Storage  
							  			</g:if>
							  			<g:else>
								   		  <input type="checkbox" name="checkboxStorage" id="checkboxStorage"/>
								        	Storage 
							  			</g:else>
							  			
							  		
							  		<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Packaging'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
										 <input type="checkbox" name="checkboxPackaging" checked="checked" id="checkboxPackaging"  />
								  			Packaging 
							  			</g:if>
							  			<g:else>
						  				 <input type="checkbox" name="checkboxPackaging" id="checkboxPackaging" />
								  			Packaging 
							  			</g:else>
							  		
							  		
							  		<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Reception'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		<input type="checkbox" name="checkboxReception" checked="checked" id="checkboxReception" />
											Reception 
							  			</g:if>
							  			<g:else>
								   		<input type="checkbox" name="checkboxReception" id="checkboxReception"/>
											Reception 
							  			</g:else>
							  		
							  <br/> 
								        	
							       	<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Transportation'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		  <input type="checkbox" name="checkboxTransportation" checked="checked" id="checkboxTransportation" />
								    		Transportation 
							  			</g:if>
							  			<g:else>
								   		  <input type="checkbox" name="checkboxTransportation" id="checkboxTransportation"/>
								    		Transportation
							  			</g:else>
							  		
										
						          	<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Treatment or processing or conversion'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		  <input type="checkbox" name="checkboxTreatment" checked="checked" id="checkboxTreatment" />
											Treatment or processing or conversion
							  			</g:if>
							  			<g:else>
								   		  <input type="checkbox" name="checkboxTreatment" id="checkboxTreatment"/>
											Treatment or processing or conversion
							  			</g:else>  
							  			
							  			
							  			<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Recycling'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		  <input type="checkbox" name="checkboxRecycling" checked="checked" id="checkboxRecycling" />
											Recycling
							  			</g:if>
							  			<g:else>
								   		  <input type="checkbox" name="checkboxRecycling" id="checkboxRecycling"/>
											Recycling
							  			</g:else>     	
								       	
								        	   
					            	<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Disposal or destruction use'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		 	<input type="checkbox" name="checkboxDisposal" checked="checked" id="checkboxDisposal" /> 
											Disposal or destruction use
							  			</g:if>
							  			<g:else>
								   		 	<input type="checkbox" name="checkboxDisposal" id="checkboxDisposal"/> 
											Disposal or destruction use
							  			</g:else>  
							  			<br/>
							  				<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Offering for sale'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		 	<input type="checkbox" name="checkboxOffering" checked="checked" id="checkboxOffering" /> 
											Offering for sale, transfer
							  			</g:if>
							  			<g:else>
								   		 	<input type="checkbox" name="checkboxOffering" id="checkboxOffering"/> 
											Offering for sale, transfer
							  			</g:else>
							  			
								    	 
									<% b=0;%>
							  		<%for(int i=0;i<tmp1.size();i++){%>
									<g:if test="${tmp1[i]=='Any other form of Handling'}">
								     <%b=1;%>
								     </g:if>
								     <%}%>
							  		
							  		<g:if test="${b==1}">
								   		 	<input type="checkbox" name="checkboxAnyother" checked="checked" id="checkboxAnyother" /> 
											Any other form of Handling 
							  			</g:if>
							  			<g:else>
								   		 	<input type="checkbox" name="checkboxAnyother" id="checkboxAnyother" /> 
											Any other form of Handling 
							  			</g:else>  
							  			
							  			
							  			</g:if>
							  				
							  				
							  				
							  				<g:else>
											
							  			   	<input type="checkbox" name="checkboxGeneration" id="checkboxGeneration" />
								  			Generation, segregation 
								  			&nbsp; &nbsp; &nbsp;  
								        <input type="checkbox" name="checkboxCollection" id="checkboxCollection" />
								  			Collection 
								  			&nbsp; 
								  			
								  		<input type="checkbox" name="checkboxStorage" id="checkboxStorage"/>
								        	Storage 
								        	<br/>  	
								  			
								  		<input type="checkbox" name="checkboxPackaging" id="checkboxPackaging"/>
								        	Packaging &nbsp;
								   		<input type="checkbox" name="checkboxReception" id="checkboxReception"/>
											Reception 
											&nbsp; &nbsp; 
								         
								        <input type="checkbox" name="checkboxTransportation" id="checkboxTransportation"/>
								    		Transportation
								    	<input type="checkbox" name="checkboxTreatment" id="checkboxTreatment"/>
											Treatment or processing or conversion 
											
										<input type="checkbox" name="checkboxRecycling" id="checkboxRecycling"/>
								    		Recycling		
										<input type="checkbox" name="checkboxDisposal" id="checkboxDisposal"/> 
											Disposal or destruction use
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <br/>
										
										<input type="checkbox" name="checkboxOffering" id="checkboxOffering"/>
								    		Offering for sale, transfer	
										<input type="checkbox" name="checkboxAnyother" id="checkboxAnyother" /> 
											Any other form of Handling 
							  			
							  			</g:else> 
							  			</td>
										</tr>
										
		   <% //System.out.println("In gform.........") %>
		   
		     

    
 
      
      
      
      
      
      
      
                            <td width="35" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table>
                        
		   
		   </div>
         
    <!--*************Country 1 End Here*********-->
     <!--*************Country 2 Start from Here*********-->        
        <div class="content" id="country2" >
         
		  <table class="tblbdr" width="100%" align="center">
                        <tbody>
                        
				<input type="hidden" id="indAppDetId" name="indAppDetId" value="<%=bioMedicalWasteInstance.id%>"/>
				 
			<input type="hidden" name="nameAddressInstitution" id="nameAddressInstitution" value="">
				<input type="hidden" name="nameOfApplicant" id="nameOfApplicant" value="">
								<input type="hidden" name="nameOfInstitution" id="nameOfInstitution" >
					 
					   
                             <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">HCF/CBMWTF Type<scope style="color:red">*</scope></td>
        <td align="left" bgcolor="#E8F6F9">
        
        <g:select name="hcfType" id="test1" from ="${['select','HCF','CBMWTF']}"   onclick="javascript:select1()" value="${fieldValue(bean:bioMedicalWasteInst,field:'hcfType')}"></g:select>
       
       <div style="display:none;border:0;"  id="tempB" >
       </div>
	   <div style="border:0;"  id="tempA">
	   <g:select from ="${['Select HCF Type','Private Hospital (Bedded)','Govt Hospital (Bedded)','Bedded Any Other','Clinic (Non-Bedded)','Blood Bank (Non-Bedded)','Clinical Laboratory (Non-Bedded)','Forensic Laboratory','Research Laboratory','Health Camps/Medical Camps/Vaccinaton/Blood Donation','Veterinary Institutions','Educations Institutions','Research Institute (Non-Bedded)','Veterinary Hospital (Non-Bedded)','Animal House (Non-Bedded)','Dispensary (Non-Bedded)','Non-bedded-Any-Other (Non-Bedded)']}" name="hcfTypeMenu" id="hcfTypeMenu" value="${fieldValue(bean:bioMedicalWasteInst,field:'hcfTypeMenu')}"></g:select>
       </div>
       </td>                             
       </tr>
   
   <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Bio-Medical Waste Facility Status <scope style="color:red">*</scope></td>
        <td align="left" bgcolor="#E8F6F9">
        <g:select from ="${['Select Status','CBMWTF-Common Facility','HCF-Common Facility Member']}" name="bmwfacility" id="bmwfacility" value="${fieldValue(bean:bioMedicalWasteInst,field:'bmwfacility')}"></g:select>
     </td> 
   </tr>
   
    <tr>  
        <td align="left" bgcolor="#A8DAF3" rowspan="2" class="headngblue">CBMWTF-location and Office address of  treatment and disposal <scope style="color:red">*</scope></td></td>
        <td align="left" bgcolor="#E8F6F9">
     <!--<g:select  from ="${HcfCommonFacilityBmwMaster.list()}" noSelection="${['':'Select CBMWTF Location address']}"  name="wastedisposalplaceHcf" id="wastedisposalplaceHcf" style="width:300px;" value="${bioMedicalWasteInst?.wastedisposalplace}" optionKey="hcfCommonFacilityName"></g:select>-->  
    <g:select  from="${HcfCommonFacilityBmwMaster.list()}"   noSelection="${['':'Select CBMWTF Location address']}" name="wastelocationaddress" id="locfacility" style="width:300px;" value="${bioMedicalWasteInst?.wastelocationaddress}" optionKey="hcfCommonFacilityName"></g:select>
     </td> 
     
   </tr>
   
   <tr>  
        <td align="left" bgcolor="#E8F6F9">
        <g:select id="bmwstatus" name="bmwstatus" value="${bioMedicalWasteInst?.bmwstatus}" optionKey="hcfFacilityName" optionKey="hcfFacilityName" from="${HcfAddressFacilityBmwMaster.list()}"   noSelection="${['':'Select CBMWTF Office address']}"  style="width:300px;" ></g:select>
       	<!--<g:select  from="${HcfAddressFacilityBmwMaster.list()}"   noSelection="${['':'Select CBMWTF Office address']}" name="bmwstatus" id="bmwstatus1" style="width:300px;" value="${bioMedicalWasteInst?.bmwstatus}" optionKey="hcfFacilityName"></g:select>-->
		    
     </td> 
   </tr>
 
   
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Mode of Transportation of BMW </td></td>
        <td align="left" bgcolor="#E8F6F9">Common Facility Vehicle</td>
   </tr>
   
   <!--Added by sharvan start from here-->
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Status of CTE/CTO-latest consent type, issued date and validity date </td>
        <!--<td align="left" bgcolor="#E8F6F9"><input type="text" name="statusCteCto" id="statusCteCto"   value="${fieldValue(bean:bioMedicalWasteInst,field:'statusCteCto')}"></td>-->
  		<td align="left" bgcolor="#E8F6F9"><textarea name="statusCteCto" rows="5" cols="45" id="statusCteCto" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'statusCteCto')}</textarea></td>
   </tr> 
    
    <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">GPS Coordinates -Lat/Lon of the location of applicant facility (in Decimal degrees with 6 decimals):
		</br>Ex: Latitude: 8.123456 N, 12.236544 N, etc
		</br>
		Longitude: 77.235648 E, 78.253674 E,etc
		</td>
        <td  bgcolor="#E8F6F9" bgcolor="#E8F6F9">Latitude &nbsp;
        <input type="text" name="latitude" id="latitude" size="8"  maxlength="9"  value="${fieldValue(bean:bioMedicalWasteInst,field:'latitude')}"> N Decimal Degrees
        Longitude 
        <input type="text" name="longtitude" id="longtitude" size="8"  maxlength="9"   value="${fieldValue(bean:bioMedicalWasteInst,field:'longtitude')}"> E Decimal Degrees</td>
   </tr> 
   
   <tr>  
        <td align="left" bgcolor="#A8DAF3" class="headngblue">Details of directions or notices or legal actions if any during the period of earlier authorisation (Attach documents if any) </td>
        <!--<td align="left" bgcolor="#E8F6F9"><input type="text" name="detailsOfDirections" id="detailsOfDirections"   value="${fieldValue(bean:bioMedicalWasteInst,field:'detailsOfDirections')}"></td>-->
   		<td align="left" bgcolor="#E8F6F9"><textarea name="detailsOfDirections" rows="5" cols="45" id="detailsOfDirections" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'detailsOfDirections')}</textarea></td>
   </tr>
   
   
    
   <!-- added by sharvan end here-->     
  
         
   <table class="tblbdr" width="100%" align="center" id="hcfTemp">
   <tr>  
        <td colspan="3" align="center" bgcolor="#A8DAF3" class="headngblue">Details of Activity & Facility-For HCF only </td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
        
     <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">a).	Medical treatment Facility provided to Outpatients</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="outpatientsFacility"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'outpatientsFacility')}" ></td>
      <td align="left" class="headngblue"  bgcolor="#E8F6F9">Nos./Day</td>
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">b).	Medical treatment Facility provided to Inpatients</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="inpatientsFacility"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'inpatientsFacility')}" > </td>
      <td align="left" class="headngblue"  bgcolor="#E8F6F9">Nos./Day</td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">c).	No of Beds of HCF</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="noofbeds" id="noofbeds1"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'noofbeds')}"></td>
      <td align="left" class="headngblue"  bgcolor="#E8F6F9">Nos.</td>
   </tr> 
   
 <!-- added by sharvan on 21/04/2015 start-->
   
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d) For Non bedded Hospital (Specify) </td>
     <td align="left" bgcolor="#E8F6F9"><textarea name="noOfNonBeds" rows="5" cols="25" id="noOfNonbeds" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'noOfNonBeds')}</textarea></td>
      <td align="left" bgcolor="#E8F6F9"><textarea name="noOfNonBeds1" rows="5" cols="25" id="noOfNonbeds1" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'noOfNonBeds1')}</textarea></td>
   </tr> 
   
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e) Total number of inpatients & outpatients treated per month in the HCF</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="noOfInOutPatients" size="3" id="noOfInOutPatients"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'noOfInOutPatients')}"></td>
      
   </tr> 
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f) Whether the colour coded bags or containers has been provided for collection and segregation of BMW as prescribed in BMW rules?  </td>
      <td align="left" bgcolor="#E8F6F9"><textarea name="colorCodedBags" rows="5" cols="25" id="colorCodedBags" maxlength="500" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'colorCodedBags')}</textarea></td>
   </tr> 
   
 
  <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">g) Details of training conducted to the paramedical staff/sanitary workers in the BMW management  </td>
      <td align="left" bgcolor="#E8F6F9"><textarea name="detailsOfTraining" rows="5" cols="25" id="detailsOfTraining" maxlength="500" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'detailsOfTraining')}</textarea></td>
   </tr>
 <!-- Added by sharvan for new changes  Code Commented by sharvan
   
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d).	Others (specify)</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="other1" value="${fieldValue(bean:bioMedicalWasteInst,field:'other1')}"></td><td align="left" class="headngblue"  bgcolor="#E8F6F9"><input type="text" name="other2" value="${fieldValue(bean:bioMedicalWasteInst,field:'other2')}"></td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e).	Total number of inpatients & outpatients treated per month in the HCF</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="patientspermonth"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'patientspermonth')}"> </td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f).	No of Needle destroyers/cutters in the HCF</td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="destroyer"  maxlength="5" value="${fieldValue(bean:bioMedicalWasteInst,field:'destroyer')}"> </td>
   </tr> 
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">g). Whether the Colour coded bins has provided (ward wise) as prescribed in BMW rules</td>
      <td align="left" bgcolor="#E8F6F9">
      <%//if(bioMedicalWasteInst.bmwrules1=="Yes"){%>
      <input type="radio" name="bmwrules1" value="Yes" checked >Yes 
      <%//}else{%>
		 <input type="radio" name="bmwrules1" value="Yes">Yes 
		<%//}
		//if(bioMedicalWasteInst.bmwrules1=="No"){%>
      <input type="radio" name="bmwrules1" value="No" checked>No
      <%//}
      //else{%>
      <input type="radio" name="bmwrules1" value="No">No
      <%//}%>
      
      </td>
   </tr> -->
 </table>
  <div id="cbmwtfTemp" style="display:none;"> 
 <table class="tblbdr" width="100%" align="center">
  <tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">Details of Facility-For CBMWTF Only</td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
    
    <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">a). No of HCFs covered by the CBMWTF <scope style="color:red"></scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="NoofHCF" maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'NoofHCF')}"></td>
   </tr>     
   
   <!-- Added by sharvan for new Changes start from here-->
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">b) No of beds covered by the CBMWTF <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" size="3" name="NoofBedsCbmwtf" id="NoofBedsCbmwtf" maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'noOfBedsCbmwtf')}"></td>
   </tr>
   
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">c) Installed treatment and disposal capacity of CBMWTF <scope style="color:red"></scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="treatmentAndDisposal" size="8" maxlength="12" id="treatmentAndDisposal"  value="${fieldValue(bean:bioMedicalWasteInst,field:'treatmentAndDisposal')}"></td>
   		<td align="left" bgcolor="#E8F6F9">Kg/day</td>
   </tr>	
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d) Quantity of BMW treated or disposed by CBMWTF <scope style="color:red"></scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="qtyOfBmwTreated" size="8" maxlength="12" id="qtyOfBmwTreated" maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'qtyOfBmwTreated')}"></td>
   		<td align="left" bgcolor="#E8F6F9">Kg/day</td>
   </tr>
   
 <!-- Added by sharvan for new Changes end here-->
 
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e). Jurisdictional area and distance covered by the CBMWTF <scope style="color:red"></scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="Jurisdictionalarea"  value="${fieldValue(bean:bioMedicalWasteInst,field:'Jurisdictionalarea')}"></td>
   </tr>
   
 <!-- added by sharvan for new changes-->
 <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f) Contingency (future upgradation) plan of CBMWTF(Attach documents if any)  </td>
   		<td align="left" bgcolor="#E8F6F9"><textarea name="contingencyPlan" rows="5" cols="25" id="contingencyPlan"  class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'contingencyPlan')}</textarea></td>
   </tr>
   
   
  
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">g). Details of training conducted to the paramedical staff/sanitary workers in the BMW management  </td>
  		<td align="left" bgcolor="#E8F6F9"><textarea name="detailsOfTraining1" rows="5" cols="25" id="detailsOfTraining1"  class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'detailsOfTraining')}</textarea></td>
   </tr>
   
 <!-- Code commented by sharvan for new changes  
   <tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">c)  Total quantity for which Authorisation is required to handle the BMW in CBMWTF  <scope style="color:red">*</scope></td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue" ></td></tr>

   <tr>
		<td colspan="3">														
	<div id="authorization" >
		
		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="15%" align="center" class="headngblue">T/Day</td>
             <td  width="15%" align="center" class="headngblue">T/Month</td>
              </tr>
             <tr>
           <td><input type="text" name="authorisationDay" value="${fieldValue(bean:bioMedicalWasteInst,field:'authorisationDay')}" ></td>
              <td><input type="text" name="authorisationMonth" value="${fieldValue(bean:bioMedicalWasteInst,field:'authorisationMonth')}"></td>
            
               
                             </table>
														    									
	</br>	
			</div>													
			    </td>
              	</tr>
      
       
     
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d)  No of Shredders in CBMWTF <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="shedders"  maxlength="3" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}">
      </td>
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e) Onsite APC measures provided for Incinerators and other emission sources in CBMWTF <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="detailapc" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}">
      </td>
   </tr>
   
   <tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f) Onsite ETP for liquid wastes in CBMWTF <scope style="color:red">*</scope></td>
      <td align="left" bgcolor="#E8F6F9"><input type="text" name="detailetp" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}">
      </td>
   </tr>
   
    <tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">g) Status of treated BMW disposal quantity in CBMWTF <scope style="color:red">*</scope></td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
   
      <tr>
		<td colspan="3">														
	<div id="authorization" >
		
		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="15%" align="center" class="headngblue">Waste Category Description</td>
             <td  width="15%" align="center" class="headngblue">Disposal Method </td>
             <td  width="15%" align="center" class="headngblue">Quantity in T/day</td>
              <td  width="15%" align="center" class="headngblue">Quantity in T/Month</td> 
              </tr>
             <tr>
           <td>Incineration Ash from Cat.1,2,3,5,6& 10.</td>
              <td> Dedicated SLF</td>
              <td><input type="text" name="quantityperDay" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
            <td><input type="text" name="quantityperMonth" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
           
               </tr>
               
               <tr>
           <td>Shredder Solid Watses from Cat.4 & 7</td>
            <td> Sold to recyclers</td>
            <td> <input type="text" name="quantityperDay1" value="${fieldValue(bean:bioMedicalWasteInst,field:'quantityperDay1')}"></td>
            <td> <input type="text" name="quantityperMonth1" value="${fieldValue(bean:bioMedicalWasteInst,field:'quantityperMonth1')}"></td>
           
               </tr>
               
              </table>
		</br>	
			</div>													
			    </td>
              	</tr>
         </div>  -->     	
  
  <!--<tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">Whether all the paramedical staff/sanitary workers are trained in the Bio Medical Waste Management?</td>
       <td align="left" bgcolor="#E8F6F9">
        
        <%//if(bioMedicalWasteInst.authapply=="Yes"){%>
       <input type="radio" name="authapply" value="Yes" checked />Yes
       <%//}else{%>
        <input type="radio" name="authapply" value="Yes" />Yes
        <%//}
		//if(bioMedicalWasteInst.authapply=="No"){%>
        <input type="radio" name="authapply" value="No" checked/>No
         <%//}
      //else{%>
       <input type="radio" name="authapply" value="No"/>No
      <%//}%>
        
        
        </td>
      </tr>-->
  
  <!--
       <tr>  
        <td colspan="2" align="left" bgcolor="#A8DAF3" class="headngblue">Status of issue of Consent under Water and Air Acts Please enter the details of issued consents:(Attach copies  of Consents)</td>
        <td align="left" bgcolor="#A8DAF3" class="headngblue"></td></tr>
   
     <tr>
		<td colspan="3">														
	<div id="authorization" >
		
		<table border="1" align="left" cellpadding="0"
	cellspacing="0" class="tblbdr" bordercolor="black">

			<tr bgcolor="#A8DAF3" >
            
             <td  width="15%" align="center" class="headngblue">Date of Application for Consent</td>
             <td  width="15%" align="center" class="headngblue">Consent Type </td>
              <td  width="15%" align="center" class="headngblue">Issued date</td> 
              <td  width="15%" align="center" class="headngblue">Valid date</td>  
              </tr>
            
             <tr>
           <td><input type="text" name="consentDate" placeholder="dd/mm/yyyy"></td>
              <td><span class="headngblue"><select name="HWAType" id="menu" class="txt4" onchange="change1();">
			<option  value="Fresh">Fresh</option>
			<option  value="Renewal">Renewal</option>
			</select></span>
			</td>
             <td><input type="text" name="Issued_date" placeholder="dd/mm/yyyy"></td>
            <td><input type="text" name="Valid_date" placeholder="dd/mm/yyyy"></td>
               </tr>
                             </table>
														    									
	</br>	
			</div>													
			    </td>
              	</tr>
    
     -->
     
      </td>
       </tbody>
          </table></tbody></table>
                     </div>
             
      <!-- ********** country 2 ends here****************-->
      
        <!-- ********** country 3 Start from  here change by sharvan ****************-->
     
      <div class="content" id="country3">
      
      
		   <!-- added by sharvan for new changes start from here -->		   
     		<table width="50%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#A5CAF4" class="center">
    		<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#A5CAF4" class="center" >
  			<tr bgcolor="#A8DAF3" align="left" class="headngblue">
			<td align="left" colspan="4" bgcolor="#E8F6F9" class="headngblue">	Details of Treatment Equiments available for treatment of Bio-Medical Waste</td>
			</tr>
  			
  			<tr align="left" bgcolor="#FFFFFF" >
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue" >SI No.</th>
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Treatment equipment</th> 
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">No of Units</th>
      		<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Type and capacity of each unit</th>
      		</tr> 
      		
      		<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>1</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Incinerators </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="incinrators"   id="incinrators" value="${fieldValue(bean:bioMedicalWasteInst,field:'incinrators')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="incinratorsType" rows="5" cols="25" id="incinratorsType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'incinratorsType')}</textarea></td>
   			</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>2</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Plasma Pyrolysis </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="plasmaPyrolysis"   id="plasmaPyrolysis" value="${fieldValue(bean:bioMedicalWasteInst,field:'plasmaPyrolysis')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="plasmaPyrolysisType" rows="5" cols="25" id="plasmaPyrolysisType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'plasmaPyrolysisType')}</textarea></td>
     		</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>3</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Autoclaves </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="autoclaves"   id="autoclaves" value="${fieldValue(bean:bioMedicalWasteInst,field:'autoclaves')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="autoclavesType" rows="5" cols="25" id="autoclavesType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'autoclavesType')}</textarea></td>
     		</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>4</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Microwave </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="microwave"   id="microwave" value="${fieldValue(bean:bioMedicalWasteInst,field:'microwave')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="microwaveType" rows="5" cols="25" id="microwaveType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'microwaveType')}</textarea></td>
     		
   			</tr>   
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>5</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Hydroclave </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="hydroclave"   id="hydroclave" value="${fieldValue(bean:bioMedicalWasteInst,field:'hydroclave')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="hydroclaveType" rows="5" cols="25" id="hydroclaveType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'hydroclaveType')}</textarea></td>
     		
   			</tr>                          
            
            <tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>6</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Shredders </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="shredders"   id="shredders" value="${fieldValue(bean:bioMedicalWasteInst,field:'shredders')}"></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="shreddersType" rows="5" cols="25" id="shreddersType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'shreddersType')}</textarea></td>
     		</tr>
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>7</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Needle tip cutter or destroyer </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="needleTipCutter"   id="needleTipCutter" value="${fieldValue(bean:bioMedicalWasteInst,field:'needleTipCutter')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="needleTipCutterType" rows="5" cols="25" id="needleTipCutterType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'needleTipCutterType')}</textarea></td>
     		</tr>  
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>8</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Sharp encapsulation or Concrete pit </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="sharpEncapsulation"   id="sharpEncapsulation" value="${fieldValue(bean:bioMedicalWasteInst,field:'sharpEncapsulation')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="sharpEncapsulationType" rows="5" cols="25" id="sharpEncapsulationType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'sharpEncapsulationType')}</textarea></td>
     		</tr>  
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>9</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Deep burial pits </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="deepBurial"   id="deepBurial" value="${fieldValue(bean:bioMedicalWasteInst,field:'deepBurial')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="deepBurialType" rows="5" cols="25" id="deepBurialType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'deepBurialType')}</textarea></td>
     		</tr>  
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>10</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Chemical disinfection </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="chemDisinfection"   id="chemDisinfection" value="${fieldValue(bean:bioMedicalWasteInst,field:'chemDisinfection')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="chemDisinfectionType" rows="5" cols="25" id="chemDisinfectionType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'chemDisinfectionType')}</textarea></td>
     		</tr>  
   			
   			<tr> 
      		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>11</b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b> Any other treatment equipment </b></td>
     		<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="anyOtherTreatmentEquip"   id="anyOtherTreatmentEquip" value="${fieldValue(bean:bioMedicalWasteInst,field:'anyOtherTretmntEquip')}"></td>
   			<td align="left"  bgcolor="#E8F6F9" class="headngblue"><textarea name="anyOtherTretmntEquipType" rows="5" cols="25" id="anyOtherTretmntEquipType" maxlength="200" class="txt4">${fieldValue(bean:bioMedicalWasteInst,field:'anyOtherTretmntEquipType')}</textarea></td>
   			</tr>              
 
      
		  
		 <!-- <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">	
		  <tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">BMW Authorisation Fee Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hospitals/Common Facility Located in area within </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">BMWA fee(Rs)
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Municipal Corporations </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1500
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Selection Grade & Special Grade Muncipalities</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1000
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Other Muncipalities</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">750
				  </td>
				</tr> 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Town Panchayats,Panchayat Unions and other local bodies if any</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">500
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"></td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
				  </td>
				</tr> -->
				
				<%  //def industryRegId=bioMedicalWasteInstance.industryRegMasterObj
                  //System.out.println("Industry reg master iddddd issss>>>"+industryRegId)
                 //def localBodyType1 =industryRegId.localBodyType.localBodyTypeName
				    //System.out.println("localBodyType issss>>>"+localBodyType1) %>
				
				
				<!--<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">BMW Authorisation Fee Applicable Rs.</td>
					
					<%// if(localBodyType1.equalsIgnoreCase("Municipality")){%>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1500
				  </td>
				  <%// } else if((localBodyType1.equalsIgnoreCase("Others")) || (localBodyType1.equalsIgnoreCase("Corporation"))){%> 
				
			        <td  align="left" bgcolor="#E8F6F9"  class="headngblue">1000
				  </td>
				  
				  <% //}else{%> 
				      <td  align="left" bgcolor="#E8F6F9"  class="headngblue">500
				  </td>
				   <% //}%>
				
				 </tr>--> 
				
				
				<!--<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reason for deviation in payment</td>
				   <td>	 <textarea name="paymentDeviation" class="txt4"  id="paymentDeviation" value="${fieldValue(bean:bioMedicalWasteInst,field:'paymentDeviation')}"></textarea> 
				  </td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">BMW Authorisation Fee Remitted now </td>
					 <td><span style="color: white">Rs. </span><input type="text" name="remittedFees" class="txt4" id="applicantDesignation" value="${fieldValue(bean:bioMedicalWasteInst,field:'remittedFees')}" />  </td>
				  
				</tr> 
				
				</table>
				
					
				
				
	
			  
			
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
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsAddBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsEditBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
					</tr>
					</table>
					</td>
				</tr>  -->
	      </table>
	
			</table>	
			
 </div>
    
     <!--stast by shashank for fee--> 
     <!-- added by shashank for fee -->
 <div class="content" id="country7">
		  

 <table width="90%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">	

  <%
  def ConsentFeeMasterBMW=ConsentFeeMasterBMW.findByApplication(bioMedicalWasteInstance)
  def noOfYear=ConsentFeeMasterBMW?.noOfYears;
  def fee=ConsentFeeMasterBMW?.calculatedFee;
 def cat = IndustryRegMaster.findById(indRegInstance.id.toLong())
 def capInv = indRegInstance.indCapInvt.toInteger()
 def noOfMaterials = capInv
 def pat =indRegInstance.indCapInvt.toInteger()
 %>									
 		<tr>
 			<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
 			<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue" > ${cat.category.name}</td>
 		</tr> 
 		
 		<input type="hidden" id="catVale" value="${cat.category.name}">
 		<input type="hidden" id="noOfBeds" value="${capInv}">
 		<input type="hidden" id="noOfMaterials" value="${noOfMaterials}">
 		<!--by shashank-->
 		<input type="hidden" id="typeHce" value="${cat.industryType.industryType}">
 		<input type="hidden" id="bedNo" value="${cat.plotNo}">
 		
 		<%def etc=indRegInstance.extraFacilities%>
 		<%System.out.println("etc"+indRegInstance.extraFacilities)%>
 		
 		<%def ring=indRegInstance.anyOther%>
 			<%System.out.println("ring-----"+ring)%>
 		
 		<% if(cat.category.name.equals("HOSPITAL")) {%>
 		
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Extra Facilities If Any :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="extraFacilities" type="text" class="txt4" size="30" readonly="readonly" value="${indRegInstance.extraFacilities}" AUTOCOMPLETE=OFF maxlength="50" />
 			<br><br>
 			<%if(etc){
 			if(etc.contains("AnyOther")){%>
 			<input name="anyOther" type="text" class="txt4" size="30" readonly="readonly" value="${ring}" AUTOCOMPLETE=OFF maxlength="50" />
 			<%}}%>
 			
 			</td>
 	</tr> 
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">No of Beds :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	
 	<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average Number of Patients per month:</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indNewCapInvt" id="indNewCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${pat}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 


 	<%}%>

 <% if(cat.category.name.equals("BLOOD BANK")) {%>
 	
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average Number of Samples per month :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	

 	<%}%>


 <% if(cat.category.name.equals("LAB")) {%>
 	
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average Number of Samples per month :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	

 	<%}%>

 <% if(cat.category.name.equals("VETERINARY")) {%>
 	
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average Number of Animals per month :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	

 	<%}%>



 <% if(cat.category.name.equals("CLINIC")) {%>
 	
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average Number of Patients per month :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	

 	<%}%>
  <% if(cat.category.name.equals("DENTAL CLINIC")) {%>
 	
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Average Number of Patients per month:</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	

 	<%}%>

 	
 	
 	
 <% if(cat.category.name.equals("CBWTF")) {%>
 	
 	
 	
 		<tr>
 			<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Number of Beds :</td>
 			<td   align="left" bgcolor="#E8F6F9"  class="headngblue">
 			  <input name="indCapInvt" type="text" class="txt4" size="30" readonly="readonly" value="${capInv}" AUTOCOMPLETE=OFF maxlength="50" />
 			</td>
 	</tr> 
 	

 	<%}%>


 		<tr>
 			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
 			<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
 			
 			<input name="yearsApplied" id="yearsApplied" type="text" class="txt4" value="${noOfYear}"  maxlength="2" size="10"/>
 			&nbsp;</span></td>
 			
 			
 		</tr> 
 		
 		<tr>
 			<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable : </td>
 			<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
 			<input name="feeApplicable" id="feeApplicable" type="text" class="txt4" size="10" value="${fee}" />
 	<a href="javascript:{}" onclick="return calculateForBMW();"  class="bulletinside"><b>Calculate</b></a>
 			&nbsp;<span class="sidetxt">(Click to calculate fee for new industry)</span></span></td>
 		</tr>  
 	  
 	</td></tr>
 <!--
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
 			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsAddBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
 			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
 			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeDetailsEditBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
 			</tr>
 			</table>
 			</td>
 		</tr>  
 -->
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
 			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeOtherDetailsAddBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
 			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeOtherDetailsViewBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
 			<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popFeeOtherDetailsEditBMW/<%=bioMedicalWasteInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
 			</tr>
 			</table>
 			</td>
 		</tr>  


 	</table>	
 	



  
          </div>
     <!--end by shashank for fee-->     
       <div id="country6" class="content">
     
   <table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#A5CAF4" class="center">
    <table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#A5CAF4" class="center" >
    <tr bgcolor="#A8DAF3" align="left" class="headngblue">
			<td align="left" colspan="4" bgcolor="#E8F6F9" class="headngblue">	Quantity of BMW handled, treated or disposal</td>
			</tr>
  <tr align="left" bgcolor="#FFFFFF" >
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue" >Category</th>
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Type of Waste</th> 
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Quantity Generated or collected in Kg/day</th>
      <!--<th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Quantity handled in Kg/Month</th>
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Treatment and Disposal</th>-->
      <th style="text-align:center;" bgcolor="#A8DAF3" class="headngblue">Method of Treatment and Disposal as per Schedule-I</th>
      </tr>                           
      
      
      <tr> 
      <td align="left" rowspan="8" bgcolor="#E8F6F9" class="headngblue"><b>Yellow</b></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>a) Human Anatomical Waste <scope style="color:red"></scope></b></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="anatomicalwaste" id="anatomicalwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'anatomicalwaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="anatomicalwaste1" id="anatomicalwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>CBMWTF</b></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>Incineration</b></td>
    </tr>
    
     <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>2</b></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>b) Animal Anatomical Waste <scope style="color:red"></scope></b></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="animalwaste" id="animalwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'animalwaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="animalwaste1" id="animalwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><b>CBMWTF</b></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <!-- added by sharvan start from here -->
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>c) Soiled Waste </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="soiledwaste"  maxlength="12" onclick="this.value=''" onblur="checkField(this)" id="soiledwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'soiledwaste')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>d) Expired or Discarded Medicines </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="discardedwaste"   onclick="this.value=''" onblur="checkField(this)" id="discardedwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'discardedwaste')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>e) Chemical Solid Waste </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="chemicalSolidWaste"  maxlength="12" onclick="this.value=''" onblur="checkField(this)" id="chemicalSolidWaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'chemicalSolidWaste')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>f) Chemical Liquid Waste </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="chemicalLiquidWaste"  maxlength="12" onclick="this.value=''" onblur="checkField(this)" id="chemicalLiquidWaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'chemicalLiquidWaste')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Onsite ETP to treat and conform to the discharge standards</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>g)Discarded linen, mattresses, beddings contaminated with blood or body fluid  </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="discardedLinen"  onclick="this.value=''" onblur="checkField(this)" id="discardedLinen" value="${fieldValue(bean:bioMedicalWasteInst,field:'discardedLinen')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Disinfection followed by  Incineration</b></span></td>
    </tr>
    
    <tr> 
     <!-- <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>h)Microbiology,  Biotechnology and other clinical laboratory waste  </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="otherClinicLabWaste"  onclick="this.value=''" onblur="checkField(this)" id="otherClinicLabWaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'otherClininLabWaste')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Sterilisation followed by  Incineration</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Red</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Contaminated waste (Recyclable)  </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="contaminatedWaste"   onclick="this.value=''" onblur="checkField(this)" id="contaminatedWaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'contaminatedwaste')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Autoclaving followed by shredding. Treated waste to be sent to Authorised recyclers or for energy recovery or plastic to Diesel or fuel oil or for road making</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>White( Translucent)</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b> Waste sharps including Metals  </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="wasteSharps"  onclick="this.value=''" onblur="checkField(this)" id="wasteSharps" value="${fieldValue(bean:bioMedicalWasteInst,field:'wasteSharps')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Autoclaving followed by shredding. Treated waste to be sent to Iron foundries or sanitary landfill or designated concrete waste sharp pit.</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  rowspan="2" bgcolor="#E8F6F9" class="headngblue"><span><b>Blue</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b> Glassware  </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="glassWare"  onclick="this.value=''" onblur="checkField(this)" id="glassWare" value="${fieldValue(bean:bioMedicalWasteInst,field:'glassWare')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Disinfection or  Autoclaving or microwaving or hydroclaving and then sent for recycling</b></span></td>
    </tr>
    
    <tr> 
      <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>-->
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b> Metallic Body Implants  </b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="metallicBodyImplants"   id="metallicBodyImplants" onclick="this.value=''" onblur="checkField(this)" value="${fieldValue(bean:bioMedicalWasteInst,field:'metallicBodyImplants')}"></td>
     <!--<td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" onclick="this.value=''" onblur="checkField2(this)" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>-->
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b> </b></span></td>
    </tr>
    
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b></b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Total</b><scope style="color:red"></scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="total1" id="total1" value="${fieldValue(bean:bioMedicalWasteInst,field:'total1')}" ></td>
     
     </tr>
    
    </table>
 
  </table>
    
    <!--<tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>3</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Microbiology & Biotechnology Waste </b><scope style="color:red">*</scope>(Wastes from lab. Cultures, stocks of specimens of micro-organisms live or attenuated vaccines, human and animal incineration* cell culture used in research and infectious agents from research and industrial laboratories, wastes from production of biologicals, toxins, dishes and devices sued for transfer of cultures)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste" id="biowaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'biowaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="biowaste1" id="biowaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Chemical disinfection/ Autoclaving followed by Incineration</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span ><b>4</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span ><b>Waste Sharps </b> <scope style="color:red">*</scope>Needles, syringes, scalpels, blades, glass etc. that may cause puncture and cuts. This includes both used and unused sharps)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="wastesharp" id="wastesharp" value="${fieldValue(bean:bioMedicalWasteInst,field:'wastesharp')}" ></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="wastesharp1" id="wastesharp1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" ></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Chemical disinfection/ Autoclaving followed by shredding</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span ><b>5</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Discarded Medicines & Cytotoxic drugs </b><scope style="color:red">*</scope>(Wastes comprising of outdated contaminated and discarded medicines)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="discardedwaste" id="discardedwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'discardedwaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="discardedwaste1" id="discardedwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration and dedicated SLF</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>6</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Soiled Waste </b> <scope style="color:red">*</scope>(Items contaminated with blood, and body fluids including cotton, dressing, soiled plaster casts, lines, beddings, other material contaminated with blood)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="soiledwaste" id="soiledwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'soiledwaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="soiledwaste1" id="soiledwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>7</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Solid Waste </b><scope style="color:red">*</scope>(Waste generated from disposable items other than sharps such as tubings catheters, intravenous sets, etc.)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="solidwaste" id="solidwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'solidwaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="solidwaste1" id="solidwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>CBMWTF</b></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Chemical Disinfection, Autoclaving and shredding</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>8</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Liquid Waste </b><scope style="color:red">*</scope>(Laboratory and washing, cleaning, house keeping and disinfecting activities in KLD) </span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="liquidwaste" id="liquidwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'liquidwaste')}" >unit as KLD</td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="liquidwaste1" id="liquidwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" ></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Onsite ETP/Chemical treatment</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>9</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Incineration Ash </b><scope style="color:red">*</scope>(Ash from incineration of any bio-medical waste)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="ash" id="ash" value="${fieldValue(bean:bioMedicalWasteInst,field:'ash')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="ash1" id="ash1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Does not arise</b></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Dedicated SLF</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>10</b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Chemical Waste </b><scope style="color:red">*</scope>(Chemical used in production of biological, chemicals used in insecticides etc.)</span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="chemicalwaste" id="chemicalwaste" value="${fieldValue(bean:bioMedicalWasteInst,field:'chemicalwaste')}" onclick="this.value=''" onblur="checkField(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="chemicalwaste1" id="chemicalwaste1" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" onclick="this.value=''" onblur="checkField2(this)"></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="chemicalwaste2" id="chemicalwaste2" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" ></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Onsite ETP/Chemical treatment/ Dedicated SLF</b></span></td>
    </tr>
    
    <tr> 
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b></b></span></td>
      <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Total(Except Sl.No.8)</b><scope style="color:red">*</scope></span></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="total1" id="total1" value="${fieldValue(bean:bioMedicalWasteInst,field:'total1')}" ></td>
     <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="total2" id="total2" value="${fieldValue(bean:bioMedicalWasteInst,field:'')}" ></td>
     </tr>
    
 	</table>
  </table>-->
</div>
       
     <!-- ############# Fees Tab ################ -->  
      
     
   <div class="content" id="country4">
               <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
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
				<tr>
				<td colspan="4"><div id="ShowFreshAuth">
				<table width="100%" cellpadding="0" cellspacing="0">
				<tr bgcolor="#A8DAF3">
					<td width="35%" align="center" class="headngblue" valign="top">Upload Required Documents for Fresh</td>
					<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popUploadDocBmwFresh/<%=bioMedicalWasteInst.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Upload </a></td>
				</tr> 
			</table>
        </div>
        <div id="ShowRenewAuth">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr bgcolor="#A8DAF3">
				<td width="35%" align="center" class="headngblue" valign="top">Upload Required Documents for Renewal</td>
				<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popUploadDocBmwRenew/<%=bioMedicalWasteInst.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Upload </a></td>
			</tr> 
		</table>
      </div></td><tr bgcolor="#A8DAF3">
      <td width="35%" align="center" class="headngblue" valign="top">Delete Saved Documents</td>
      <td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popDeleteDocBmw/<%=bioMedicalWasteInst.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
      </tr>
				</tr>
		 	 </table>	  
					  
			  
			  
       
       
     	
		  	   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  Please select "Yes" if you want to send the documents By Post/ By Hand and "No" to upload the required document online.<br>For Online Document Upload:
			  &nbsp;<ul> 
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
           <br/>														</div>
			
		

		   
		    <%
                    int y=0;
                    %>
                    <g:if test="${bioMedicalWasteInstance?.completionStatus =='Completed'}">
                    <%y=1;%>
                     </g:if>
                    <table width="90%"  border="0" align="center" class="tblbdr"  >
               		<tbody>
               		
               	 <%
               	 System.out.println("editableMode--------"+editableMode);
               	System.out.println("testValue--------"+testValue);
               	 if(editableMode=="true" || testValue=="true"){%>
		               <tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Do You Want To Save The Application as
							<input name="appStatus" type="radio" value="Completed" checked="checked"  />  <span class="style3">Completed</span> 
							</td>
						</tr>
						 <%}else{%>
						<tr>
							<td valign="top" bgcolor="#A8DAF3" class="headngblue">Do You Want To Save The Application as
							<input name="appStatus" type="radio" value="Completed" />  <span class="style3">Completed</span> 
							&nbsp;
							<input name="appStatus" type="radio" value="Inprogress" checked="checked"/>  <span class="style3">In Progress</span>
		                	</td>
						</tr>
					<%}%>
					</tbody>	
               		</table>
                    <table width="95%"> 
						<tr>
							<td width="15%">&nbsp;</td>
							<td colspan="4" align="center" class="txtR">Fields marked * are mandatory</td>
						</tr>
					</table>  
					
                     <table width="75%" align="center">
	                     <tbody>
						        <tr class="prop" >
	                                <td valign="top" align="center">
	                                <span class="button">
	                                <%if(editableMode=="true" || testValue=="true"){%>
	                                <input class="actionbutton"  type="submit" value="Re-submit" onclick="return tosubmit();"/>
	                                <%}else{%>
	                                <input class="actionbutton"  type="submit" value="Update" onclick="return tosubmit();"/>
	                                <%}%>
	                                
	                                
	                                </span>
	                                </td>
	                            </tr> 
	                    </tbody>
	                    
              </table>
                    
		   
     </g:form>


      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              <!-- code for spcb Footer -->
        	  <g:include controller="userMaster" action="showSpcbFooter"/>
            </table></td>
          </tr>
          
        </table></td>
      </tr>
     
    </table></td>
  </tr>
</table>
<script language="JavaScript" type="text/javascript">

 


 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether(); 
 function tosubmit()
{
	  	
					  	
	if(!(document.getElementById("checkboxGeneration").checked) && !(document.getElementById("checkboxCollection").checked) && !(document.getElementById("checkboxReception").checked) && !(document.getElementById("checkboxStorage").checked) && !(document.getElementById("checkboxTransportation").checked) && !(document.getElementById("checkboxTreatment").checked)&& !(document.getElementById("checkboxDisposal").checked)&& !(document.getElementById("checkboxAnyother").checked))
 			{ 
 			
 				alert("Please Check Atleast one Authorization Required For Check Box");
 				return false;
 			}
 			
 			else
	{
	
	/*if(!(document.getElementById("checkboxHAW").checked) &&!(document.getElementById("checkboxAW").checked) && !(document.getElementById("checkboxMBW").checked) && !(document.getElementById("checkboxWS").checked) && !(document.getElementById("checkboxDMCD").checked) && !(document.getElementById("checkboxSW6").checked) && !(document.getElementById("checkboxSW7").checked) && !(document.getElementById("checkboxLW").checked) && !(document.getElementById("checkboxIA").checked) && !(document.getElementById("checkboxCW").checked))
	{
	alert("Please Check Atleast one Category Check Box");
	return false;
 	}
 	else
 	{				  	
if(document.getElementById("checkboxHAW").checked)
 { 
 frmvalidator.addValidation("categHAW","req","Please enter value for Category no. 1 ");
 frmvalidator.addValidation("categHAW","dec","enter valid value for Category no. 1 " );
  frmvalidator.addValidation("categHAWUnit","req","Please enter value for unit of Category no. 1 " );
 }
 
 if(document.getElementById("checkboxAW").checked)
 { 
 frmvalidator.addValidation("categAW","req","Please enter value for Category no. 2 ");
 frmvalidator.addValidation("categAW","dec","enter valid value for Category no. 2 ");
 frmvalidator.addValidation("categAWUnit","req","Please enter value for unit of Category no. 2 " );
 } 
  
 if(document.getElementById("checkboxMBW").checked)
 { 
 frmvalidator.addValidation("categMBW","req","Please enter value for Category no. 3 ");
 frmvalidator.addValidation("categMBW","dec","enter valid value for Category no. 3 ");
 frmvalidator.addValidation("categMBWUnit","req","Please enter value for unit of Category no. 3 " );
 } 
  
 if(document.getElementById("checkboxWS").checked)
 { 
 frmvalidator.addValidation("categWS","req","Please enter value for Category no. 4 ");
 frmvalidator.addValidation("categWS","dec","enter valid value for Category no. 4 ");
  frmvalidator.addValidation("categWSUnit","req","Please enter value for Unit of Category no. 4 ");
 } 
 
 if(document.getElementById("checkboxDMCD").checked)
 { 
 frmvalidator.addValidation("categDMCD","req","Please enter value for Category no. 5 ");
 frmvalidator.addValidation("categDMCD","dec","enter valid value for Category no. 5 ");
  frmvalidator.addValidation("categDMCDUnit","req","Please enter value for unit of Category no. 5 ");
 
 } 
 
 if(document.getElementById("checkboxSW6").checked)
 { 
 frmvalidator.addValidation("categSW6","req","Please enter value for Category no. 6 ");
frmvalidator.addValidation("categSW6","dec","enter valid value for Category no. 6 ");
 frmvalidator.addValidation("categSW6Unit","req","Please enter value for unit of  Category no. 6 ");

 }
 
 if(document.getElementById("checkboxSW7").checked)
 { 
 frmvalidator.addValidation("categSW7","req","Please enter value for Category no. 7 ");
 frmvalidator.addValidation("categSW7","dec","enter valid value for Category no. 7 ");
  frmvalidator.addValidation("categSW7Unit","req","Please enter value for unit of Category no. 7 ");
 

 }
 
 if(document.getElementById("checkboxLW").checked)
 { 
 frmvalidator.addValidation("categLW","req","Please enter value for Category no. 8 ");
 frmvalidator.addValidation("categLW","dec","enter valid value for Category no. 8 ");
  frmvalidator.addValidation("categLWUnit","req","Please enter value for Unit of Category no. 8 ");
 
 }
 
 if(document.getElementById("checkboxIA").checked)
 { 
 frmvalidator.addValidation("categIA","req","Please enter value for Category no. 9 " );
 frmvalidator.addValidation("categIA","dec","enter valid value for Category no. 9 ");
  frmvalidator.addValidation("categIAUnit","req","Please enter value for Unit of Category no. 9 " );
 
 
 }
 
 if(document.getElementById("checkboxCW").checked)
 { 
 frmvalidator.addValidation("categCW","req","Please enter value for Category no. 10 ");
 frmvalidator.addValidation("categCW","dec","enter valid value for Category no. 10 ");
  frmvalidator.addValidation("categCWUnit","req","Please enter value for unit of Category no. 10 ");
 
 
 }*/
  
 frmvalidator.addValidation("authorizationType","selone_radio","Please Select any one of the Authorization Type");
 
 
 	/*if(document.getElementById("radiobuttonRenew").checked)
	{
	
	frmvalidator.addValidation("prevauthNo","req","Please Enter Authorization Renew Number ");
	
	frmvalidator.addValidation("prevauthDate","req","Please Enter Authorization Renew Date");
	
	frmvalidator.addValidation("prevexpDate","req","Please Enter Authorization Expiry Date ");
	}
 
if(document.getElementById("addrPlaceDisposalOfWaste.id").value == 100){
 alert("Please select Address of Place Disposal Of Waste");
 return false;
 }
 if(document.getElementById("addrPlaceDisposalOfWaste.id").value == "Other"){
 
 frmvalidator.addValidation("addrTreatmentFacility","req","Please enter Address of Treatment Facility");
 }
 
 frmvalidator.addValidation("createdBy","req","Please enter createdBy");
 frmvalidator.addValidation("createdBy","alpha_s","enter valid Entry for createdBy");
 
 frmvalidator.addValidation("descrip","req","Please enter Description");
 
 
 //frmvalidator.addValidation("modeTrans","req","Please enter Mode of Transportation");
 frmvalidator.addValidation("modeTrans","alpha_s","enter valid Entry for Mode of Transportation");
 
  //frmvalidator.addValidation("modeTreat","req","Please enter Mode of Treatment");
 //frmvalidator.addValidation("modeTreat","alpha_s","enter valid Entry for Mode of Treatment");
 
 
 frmvalidator.addValidation("appStatus","selone_radio","Please select any one of the Application Status ");
}*/

		/* ############## validaton for country2 start by sharvan ##################*/
	var lat=document.getElementById("latitude").value
	
	if(lat.length>0){
	if(lat.length>9||lat.length<9){
		alert("Latitude Value must be of 9 digits with 6 Decimal digits like as(12.123456)");
 		return false;
	}  
	}
	var longt= document.getElementById("longtitude").value	
		if(longt.length>0){
		if(longt.length>9||longt.length<9){
		alert("Longtitude Value must be of 9 digits with 6 Decimal digits like as(12.123456)");
 		return false;
	} 
	}
   	frmvalidator.addValidation("latitude","decimal","Plese Enter the Latitude in Decimal Degrees with 6 Decimals"); 
   	frmvalidator.addValidation("longtitude","decimal","Plese Enter the Longitude in Decimal Degrees with 6 Decimals");  	
   	frmvalidator.addValidation("outpatientsFacility","decimal","Medical treatment Facility provided to Outpatients must be Numeric ");
   	frmvalidator.addValidation("inpatientsFacility","decimal","Medical treatment Facility provided to Inpatients must be Numeric "); 
   	frmvalidator.addValidation("noofbeds","decimal","No of Beds of HCF must be Numeric ");
   	frmvalidator.addValidation("noOfInOutPatients","decimal","Total number of inpatients & outpatients treated per month in the HCF must be Numeric"); 
   	frmvalidator.addValidation("NoofHCF","decimal","No of HCFs covered by the CBMWTF must be numeric ");
   	frmvalidator.addValidation("NoofBedsCbmwtf","decimal","No of beds covered by the CBMWTF must be numeric ");
   	frmvalidator.addValidation("treatmentAndDisposal","decimal","Installed treatment and disposal capacity of CBMWTF must be numeric ");
   	frmvalidator.addValidation("qtyOfBmwTreated","decimal","Quantity of BMW treated or disposed by CBMWTF must be numeric ");
   
   	/* ############## validaton for country2 End##################*/
   	
   	/* ############## validaton for country3 start##################*/
   	frmvalidator.addValidation("scrutinyReply","req","Please enter Scrutiny Reply");
   frmvalidator.addValidation("incinrators","decimal","Incinerators No of Units must be numeric ");
   frmvalidator.addValidation("plasmaPyrolysis","decimal","Plasma Pyrolysis No of Units must be numeric ");
   frmvalidator.addValidation("autoclaves","decimal","Autoclaves must No of Units be numeric ");
   frmvalidator.addValidation("microwave","decimal","Microwave must No of Units be numeric ");
   frmvalidator.addValidation("hydroclave","decimal","Hydroclave No of Units must be numeric ");
   frmvalidator.addValidation("shredders","decimal","Shredders No of Units must be numeric ");
   frmvalidator.addValidation("needleTipCutter","decimal","Needle tip cutter or destroyer No of Units must be numeric ");
   frmvalidator.addValidation("sharpEncapsulation","decimal","Sharp encapsulation or Concrete pit No of Units must be numeric ");
   frmvalidator.addValidation("deepBurial","decimal","Deep burial pits No of Units must be numeric ");
   frmvalidator.addValidation("chemDisinfection","decimal","Chemical disinfection No of Units must be numeric ");
   frmvalidator.addValidation("anyOtherTreatmentEquip","decimal","Any other treatment equipment must be numeric ");
   	/* ############## validaton for country3 End##################*/
   	
   /* ############## validaton for country5 Start ##################*/
   frmvalidator.addValidation("anatomicalwaste","decimal","Human Anatomical Waste per day Quantity must be numeric"); 
   frmvalidator.addValidation("animalwaste","decimal","Animal Waste per day Quantity must be numeric");
   frmvalidator.addValidation("soiledwaste","decimal","Soiled Waste per day Quantity must be numeric");
   frmvalidator.addValidation("discardedwaste","decimal","Expired or Discarded Medicines per day Quantity must be numeric");
   frmvalidator.addValidation("chemicalSolidWaste","decimal","Chemical Solid Waste per day Quantity must be numeric");
   frmvalidator.addValidation("chemicalLiquidWaste","decimal","Chemical Liquid Waste per day Quantity must be numeric");
   frmvalidator.addValidation("discardedLinen","decimal","Discarded linen, mattresses, beddings contaminated with blood or body fluid per day Quantity must be numeric");
   frmvalidator.addValidation("otherClinicLabWaste","decimal","Microbiology,Biotechnology and other clinical laboratory waste per day Quantity must be numeric");
   frmvalidator.addValidation("contaminatedWaste","decimal","Contaminated waste (Recyclable) per day Quantity must be numeric");
   frmvalidator.addValidation("wasteSharps","decimal","Waste sharps including Metals per day Quantity must be numeric");
   frmvalidator.addValidation("glassWare","decimal","Glassware per day Quantity must be numeric");
   frmvalidator.addValidation("metallicBodyImplants","decimal","Metallic Body Implants per day Quantity must be numeric");
 

 }
 
 	
  frmvalidator.addValidation("bmwfacility","dontselect=0","Please Select Bio-Medical Waste Facility Status");
   frmvalidator.addValidation("bmwstatus","req","Please Select Office address of the common facility handling BMW");
   frmvalidator.addValidation("locfacility","req","Please Select Address of the location of the common facility");
   frmvalidator.addValidation("wastedisposalplace","req","Please Select Address of the place of disposal of wastes");
   frmvalidator.addValidation("test1","dontselect=0","Please Select HCF/CBMWTF Type");
   //frmvalidator.addValidation("hcfTypeMenu1","dontselect=0","Please Select HCF/CBMWTF Type");
   
 
   
    
    
 frmvalidator.addValidation("anatomicalwaste","decimal","Human Anatomical Waste per day Quantity must be numeric"); 
 frmvalidator.addValidation("animalwaste","decimal","Animal Waste per day Quantity must be numeric");
 //frmvalidator.addValidation("biowaste","decimal","Microbiology & Biotechnology Waste per day Quantity must be numeric");
// frmvalidator.addValidation("wastesharp","decimal","Waste Sharps Needles, syringes, scalpels, blades, glass etc. that may cause puncture and cuts per day Quantity must be numeric");
 frmvalidator.addValidation("discardedwaste","decimal","Discarded Medicines & Cytotoxic drugs per day Quantity must be numeric");
 frmvalidator.addValidation("soiledwaste","decimal","Soiled Waste per day Quantity must be numeric");
 //frmvalidator.addValidation("solidwaste","decimal","Solid Waste per day Quantity must be numeric");
 //frmvalidator.addValidation("liquidwaste","decimal","Liquid Waste per day Quantity  must be numeric");
 //frmvalidator.addValidation("ash","decimal","Incineration Ash per day Quantity must be numeric");
 //frmvalidator.addValidation("chemicalwaste","decimal","Chemical Waste per day Quantity must be numeric");
 frmvalidator.addValidation("total1","decimal","Total Quantity handled Per Day Must Be Numeric");
 
 
  //frmvalidator.addValidation("anatomicalwaste","req","please enter Human Anatomical Waste per day Quantity "); 
 //frmvalidator.addValidation("animalwaste","req","please enter Animal Waste per day Quantity");
 //frmvalidator.addValidation("biowaste","req","please enter Microbiology & Biotechnology Waste per day Quantity");
 //frmvalidator.addValidation("wastesharp","req","please enter Waste Sharps Needles, syringes, scalpels, blades, glass etc. that may cause puncture and cuts per day Quantity");
 //frmvalidator.addValidation("discardedwaste","req","please enter Discarded Medicines & Cytotoxic drugs per day Quantity");
 //frmvalidator.addValidation("soiledwaste","req","please enter Soiled Waste per day Quantity");
 //frmvalidator.addValidation("solidwaste","req","please enter Solid Waste per day Quantity");
 //frmvalidator.addValidation("liquidwaste","req","please enter Liquid Waste per day Quantity");
 //frmvalidator.addValidation("ash","req","please enter Incineration Ash per day Quantity");
 //frmvalidator.addValidation("chemicalwaste","req","please enter Chemical Waste per day Quantity");
 //frmvalidator.addValidation("total1","req","please enter Total Quantity handled Per day Quantity");



 
 
}
 function calculateForBMW(){
	 var radiomenu
	 	 var results
	 	
	       if(document.myform.radioIs_Renew[0].checked){
	    	radiomenu = document.myform.radioIs_Renew[0]
	    	}
	       else{
	    	  radiomenu = "renew"
	 	   }
	     
	  	var hcfTypeMenu1=document.getElementById('hcfTypeMenu').value;
	  	
	  	var noofYears = document.getElementById('yearsApplied').value;
	  
	  	var noofbeds=document.getElementById('noofbeds1').value;
	  	 if(radiomenu.value=="fresh") {  
	  		
	  			if(hcfTypeMenu1=="Private Hospital (Bedded)" || hcfTypeMenu1== "Govt Hospital (Bedded)" ||hcfTypeMenu1=="Bedded Any Other")
	     		{   if(!noofbeds){
	     			alert(" please enter no of Beds 1")
	     		}
	  				if(noofbeds<30 && noofbeds>=1){
	  					if(noofYears<=8 && noofYears>=1){
	  					results=2500
	  					}else{
	  						alert(" Not applicable for more than 8 Years ")
	  					}
	  				}else if(noofbeds>=30 && noofbeds<50){
	  					if(noofYears<=8 && noofYears>=1){
	  					results=3000
	  					}else{
	  						alert(" Not applicable for more than 8 Years ")
	  					}
	  				}else if(noofbeds>=50 && noofbeds<100 ){
	  					if(noofYears<=8 && noofYears>=1){
	  					results=3500
	  					}else{
	  						alert(" Not applicable for more than 8 Years ")
	  					}
	  				}else if(noofbeds>=100 && noofbeds<200){
	  					if(noofYears<=5 && noofYears>=1){
	  					results=4500
	  					}else{
	  						alert(" Not applicable for more than 5 Years ")
	  					}
	  				} else if(noofbeds>=200 && noofbeds<500){
	  					if(noofYears<=5 && noofYears>=1){
	  					results=5200
	  					}else{
	  						alert(" Not applicable for more than 5 Years ")
	  					}
	  				}else if(noofbeds>=500){
	  					if(noofYears<=5 && noofYears>=1){
	  					results=6500;
	  					}else{
	  						alert(" Not applicable for more than 5 Years ")
	  					}
	  				}
	     		}
	  			if(hcfTypeMenu1=="Clinic (Non-Bedded)" ||hcfTypeMenu1== "Dispensary (Non-Bedded)"){
	  				if(noofYears<=12 && noofYears>=1){
	  				console.log("---Clinic---")
	  				results=1250;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Blood Bank (Non-Bedded)"||hcfTypeMenu1=="Clinical Laboratory (Non-Bedded)"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=2100;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Forensic Laboratory"||hcfTypeMenu1=="Research Laboratory"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=2000;
	  				console.log("---results--in for")
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Educations Institutions"||hcfTypeMenu1=="Research Institute (Non-Bedded)"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=1250;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Health Camps/Medical Camps/Vaccinaton/Blood Donation"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=850;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Veterinary Institutions"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=1250;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Veterinary Hospital (Non-Bedded)"||hcfTypeMenu1=="Animal House (Non-Bedded)"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=450;
	  			}
	  				else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	 }}
	       if(radiomenu=="renew"){
	       	  
	  			if(hcfTypeMenu1=="Private Hospital (Bedded)" || hcfTypeMenu1== "Govt Hospital (Bedded)" ||hcfTypeMenu1=="Bedded Any Other")
	     		{  if(!noofbeds){
	     			alert(" please enter no of Beds")
	     			
	     		}
	  				if(noofbeds<=30 && noofbeds>=1){
	  					if(noofYears<=8 && noofYears>=1){
	  					results=1250
	  					}else{
	  						alert(" Not applicable for more than 8 Years ")
	  					}
	  				}else if(noofbeds>=30 && noofbeds<50){
	  					if(noofYears<=8 && noofYears>=1){
	  				   results=1500
	  					}else{
	  						alert(" Not applicable for more than 8 Years ")
	  					}
	  				}else if(noofbeds>=50 && noofbeds<100){
	  					if(noofYears<=8 && noofYears>=1)
	  					{
	  					results=1750
	  					}else{
	  						alert(" Not applicable for more than 8 Years ")
	  					}
	  				}else if(noofbeds>=100 && noofbeds<200){
	  					if(noofYears<=5 && noofYears>=1){
	  				    results=2250
	  					}else{
	  						alert(" Not applicable for more than 5 Years ")
	  					}
	  				}else if(noofbeds>=200 &&  noofbeds<500){
	  					if(noofYears<=5 && noofYears>=1){	
	  				    results=2600
	  					}else{
	  						alert(" Not applicable for more than 5 Years ")	
	  					}
	  				}
	  				else if(noofbeds>=500){
	  					if(noofYears<=5 && noofYears>=1){
	  				   results=3200;
	  					}else{
	  						alert(" Not applicable for more than 5 Years ")
	  					}
	  				}
	     		}
	  			if(hcfTypeMenu1=="Clinic (Non-Bedded)" ||hcfTypeMenu1== "Dispensary (Non-Bedded)"){
	  				if(noofYears<=12 && noofYears>=1){
	  			  results=625;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Blood Bank (Non-Bedded)"||hcfTypeMenu1=="Clinical Laboratory (Non-Bedded)"){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=1050;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=='Forensic Laboratory'||hcfTypeMenu1=='Research Laboratory'){
	  				if(noofYears<=12 && noofYears>=1){
	  				results=1000;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=='Educations Institutions'||hcfTypeMenu1=='Research Institute (Non-Bedded)'){
	  				if(noofYears<=12 && noofYears>=1){	
	  			results=625;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=='Health Camps/Medical Camps/Vaccinaton/Blood Donation'){
	  				if(noofYears<=12 && noofYears>=1){
	  			  results=425;
	  				}else{
	  					alert(" Not applicable for more than 12 Years ")
	  				}
	  			}
	  			if(hcfTypeMenu1=="Veterinary Institutions"){
	  				if(noofYears<=12 && noofYears>=1)
	  				{
	  				results=625;
	  			}else{
	  				alert(" Not applicable for more than 12 Years ")
	  			}
	  				}
	  			if(hcfTypeMenu1=='Veterinary Hospital (Non-Bedded)'||hcfTypeMenu1=='Animal House (Non-Bedded)'){
	  				if(noofYears<=12 && noofYears>=1)
	  				{
	  				results=225;
	  			}else{alert(" Not applicable for more than 12 Years ")
	  				}
	  			}

	       }
	       var feeApp = document.getElementsByName('feeApplicable');
	 	   		//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
	 	   		
	 	   			if( feeApp != null){
	 	   				
	 	   				feeApp[0].value=results*noofYears;
	 	   				
	 	   				//alert("feeApp" +document.getElementsByName('feeApplicable')+"sss "+feeApp[0].value);
	 	   			}
	 	return true;
	       

	 } 

 select1();
 hidediv();
</script>
 
</body>
</html>


