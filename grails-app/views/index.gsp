<!DOCTYPE html>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<html class="no-js" lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta content='width=device-width, initial-scale=1' name='viewport' />
<title> Online Consent Management &amp; Monitoring System</title>
<meta name="description" content="">

<link href="css/stylessheet.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<% String cont=request.getContextPath() %>
   <!-- CSS FILES -->
                        <link rel="stylesheet" href="css/bootstrap.min.css" />
                        <link rel="stylesheet" href="css/style11.css">
                         <link rel="stylesheet" href="css/grid-css.css">
                        <link rel="stylesheet" href="css/slider.css" />
                        <link href="css/flexSlider/flexslider.css" rel="stylesheet" />
                       
                                           
                        <script src="js/jquery-2.1.3.min.js"></script>
                        <script src="css/flexSlider/jquery.flexslider-min.js" type="text/javascript"></script>
                        <script type="text/javascript" src="js/jquery.flexisel.js"></script>
                        
                        <script type="text/javascript">
                        anylinkmenu.init("menuanchorclass")
                        </script>                    
<script src="js/jquery_002.js"></script>
<script>
$(document).ready(function(e) {
	$('img[usemap]').rwdImageMaps();
	
	$('area').on('click', function() {
		alert($(this).attr('alt') + ' clicked');
	});
});
</script> 


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
.capcha{
	background-image:url(images/globe.jpg);
	border:1px solid #000;
	
	height:33px; 
	width:102px;
	font-size:25px;
	color:indigo;
    text-align:center;
    margin-left:68px;
    margin-top:8px;
    margin-bottom :8px;
   font-style: italic; 
-webkit-user-select: none; 
   
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
            $(function() {
                $('.marquee').marquee();
                $('.marquee-with-options').marquee({
                    speed: 15000,
                    gap: 50,
                    delayBeforeStart: 0,
                    duration: 5000,
                    direction: 'up',
                    duplicated: true,
                    pauseOnHover: true
                });
            });

            $(window).load(function() {
                $('.flexslider').flexslider({
                    animation: "fade",
                    slideshowSpeed:3500,
                    animationSpeed: 800,
                    controlNav: false,
                    directionNav: false,
                    start: function(slider) {
                        $('body').removeClass('loading');
                    }
                });
            });

          
</script>
<script type="text/javascript">

function hidediv() {

for(var i = 0; i<document.form1.consentType.length; i++){

 if(document.form1.consentType[i].checked){
 
 var radiomenu = document.form1.consentType[i]

   	 if (radiomenu.value == "CTO") { 
   		//alert("cto")
 			
   		
 		document.getElementById('selectTemp66').style.display = 'block';
   		//alert("selectTemp66")
		document.getElementById('selectTemp666').style.display = 'none';
   		//alert("selectTemp666")
		} 
	else { 
		
		if (radiomenu.value == "CTE") {
			//alert("cte")
		document.form1.indTyp[0].checked = true;
		
		document.getElementById('selectTemp66').style.display = 'none';
		
	document.getElementById('selectTemp666').style.display = 'block';
	//alert("selectTemp666")
	
		
		
		}  

			} 
		} 
	} 
}

</script>
<script type="text/javascript">

function Calculate()
{

alert("cteeeeeeeeeeeeeeeeeeeee........")
	var indTyp;
	var consent;
	
	if(document.getElementById('indTypR').checked==true)
	{
		indTyp=document.getElementById('indTypR').value;
	}
	else if(document.getElementById('indTypO').checked==true)
	{
		indTyp=document.getElementById('indTypO').value;
	}
	else
	{
		indTyp=document.getElementById('indTypG').value;
	}
	
	var capitalInvestMent; 
	capitalInvestMent=document.getElementById('capital').value;
	
	var consentType; 
	consentType=document.getElementById('consentType').value;
	
	var certificatefor
	if(document.getElementById('consentY').checked==true)
	{
		certificatefor=document.getElementById('consentY').value;
	}
	else
	{
		certificatefor=document.getElementById('consentN').value;
	}
//	alert ('yyyyyy11'+certificatefor);
	var result;
	
	var ValidationRequired;
	ValidationRequired="/^.*(?=.*[0-9]).*$/";
	
	
	if(capitalInvestMent=="")
	{
		alert("Please give the Amount.");
		return false;
	}
	else
	{
		if(certificatefor=="Fresh")
		{
		if(consentType=="CTE")
		{
		if(indTyp=="RED")
   		{
   			if(capitalInvestMent <= 1)
    		{
    			result=400;
    		}
    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
    		{
    			result=800;
    		}
    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
    		{
    			result=1500;
    		}
    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
    		{
    			result=3000;
    		}
    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
    		{
    			result=6000;
    		}
    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
    		{
    			result=10000;
    		}
    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
    		{
    			result=20000;
    		}
    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
    		{
    			result=35000;
    		}
    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
    		{
    			result=55000;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
    		{
    			result=80000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=110000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
    		{
    			result=150000;
    		}
    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
    		{
    			result=200000;
    		}
    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
    		{
    			result=270000;
    		}
    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
    		{
    			result=370000;
    		}
    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
    		{
    			result=500000;
    		}
    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
    		{
    			result=1000000;
    		}
    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
    		{
    			result=2500000;
    		}
    		else if(capitalInvestMent > 500000)
    		{
    			result=5000000;
    		}
    			}
		else if(indTyp=="ORANGE")
   		{	
   			if(capitalInvestMent <= 1)
    		{
    			result=360;
    		}
    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
    		{
    			result=720;
    		}
    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
    		{
    			result=1350;
    		}
    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
    		{
    			result=2700;
    		}
    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
    		{
    			result=5400;
    		}
    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
    		{
    			result=9000;
    		}
    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
    		{
    			result=18000;
    		}
    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
    		{
    			result=31500;
    		}
    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
    		{
    			result=49500;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
    		{
    			result=72000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=99000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
    		{
    			result=135000;
    		}
    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
    		{
    			result=180000;
    		}
    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
    		{
    			result=243000;
    		}
    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
    		{
    			result=333000;
    		}
    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
    		{
    			result=450000;
    		}
    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
    		{
    			result=900000;
    		}
    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
    		{
    			result=2250000;
    		}
    		else if(capitalInvestMent > 500000)
    		{
    			result=4500000;
    		}
    		
    	}
		else if(indTyp=="GREEN")
   		{
			if(capitalInvestMent <= 1)
    		{
    			result=200;
    		}
    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
    		{
    			result=500;
    		}
    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
    		{
    			result=1000;
    		}
    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
    		{
    			result=2100;
    		}
    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
    		{
    			result=4200;
    		}
    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
    		{
    			result=7000;
    		}
    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
    		{
    			result=14000;
    		}
    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
    		{
    			result=24500;
    		}
    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
    		{
    			result=38500;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
    		{
    			result=56000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=77000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
    		{
    			result=105000;
    		}
    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
    		{
    			result=140000;
    		}
    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
    		{
    			result=189000;
    		}
    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
    		{
    			result=259000;
    		}
    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
    		{
    			result=350000;
    		}
    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
    		{
    			result=700000;
    		}
    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
    		{
    			result=1750000;
    		}
    		else if(capitalInvestMent > 500000)
    		{
    			result=3500000;
    		}
      }	}else{
    		
  	 	if(category=="RED")
     		{
     			if(capitalInvestMent <= 1)
      		{
      			result=400;
      		}
      		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
      		{
      			result=800;
      		}
      		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
      		{
      			result=1500;
      		}
      		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
      		{
      			result=3000;
      		}
      		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
      		{
      			result=6000;
      		}
      		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
      		{
      			result=10000;
      		}
      		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
      		{
      			result=20000;
      		}
      		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
      		{
      			result=35000;
      		}
      		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
      		{
      			result=55000;
      		}
      		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
      		{
      			result=80000;
      		}
      		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
      		{
      			result=110000;
      		}
      		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
      		{
      			result=150000;
      		}
      		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
      		{
      			result=200000;
      		}
      		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
      		{
      			result=270000;
      		}
      		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
      		{
      			result=370000;
      		}
      		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
      		{
      			result=500000;
      		}
      		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
      		{
      			result=1000000;
      		}
      			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
      		{
      			result=2500000;
      		}
      		else if(capitalInvestMent > 500000)
      		{
      			result=5000000;
      		}
      			}
      	if(category=="ORANGE")
     		{	
     			if(capitalInvestMent <= 1)
      		{
      			result=360;
      		}
      		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
      		{
      			result=720;
      		}
      		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
      		{
      			result=1350;
      		}
      		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
      		{
      			result=2700;
      		}
      		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
      		{
      			result=5400;
      		}
      		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
      		{
      			result=9000;
      		}
      		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
      		{
      			result=18000;
      		}
      		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
      		{
      			result=31500;
      		}
      		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
      		{
      			result=49500;
      		}
      		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
      		{
      			result=72000;
      		}
      		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
      		{
      			result=99000;
      		}
      		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
      		{
      			result=135000;
      		}
      		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
      		{
      			result=180000;
      		}
      		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
      		{
      			result=243000;
      		}
      		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
      		{
      			result=333000;
      		}
      		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
      		{
      			result=450000;
      		}
      		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
      		{
      			result=900000;
      		}
      			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
      		{
      			result=2250000;
      		}
      		else if(capitalInvestMent > 500000)
      		{
      			result=4500000;
      		}
      		
      	}
  		if(category=="GREEN")
     		{
  			if(capitalInvestMent <= 1)
      		{
      			result=200;
      		}
      		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
      		{
      			result=500;
      		}
      		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
      		{
      			result=1000;
      		}
      		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
      		{
      			result=2100;
      		}
      		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
      		{
      			result=4200;
      		}
      		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
      		{
      			result=7000;
      		}
      		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
      		{
      			result=14000;
      		}
      		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
      		{
      			result=24500;
      		}
      		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
      		{
      			result=38500;
      		}
      		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
      		{
      			result=56000;
      		}
      		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
      		{
      			result=77000;
      		}
      		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
      		{
      			result=105000;
      		}
      		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
      		{
      			result=140000;
      		}
      		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
      		{
      			result=189000;
      		}
      		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
      		{
      			result=259000;
      		}
      		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
      		{
      			result=350000;
      		}
      		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
      		{
      			result=700000;
      		}
      			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
      		{
      			result=1750000;
      		}
      		else if(capitalInvestMent > 500000)
      		{
      			result=3500000;
      		}
      }    
      
      }}if(certificatefor=="Renew")
		{

			if(consentType=="CTE")
			{	
				if(indTyp=="RED")
 		{
					if(capitalInvestMent <= 1)
  		{
  			result=250;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=500;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=900;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1800;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3600;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=6000;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=14000;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=24500;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=38500;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=56000;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=77000;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=112500;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=150000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=202500;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=277500;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=375000;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=750000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1875000;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=375000;
  		}
  		}
  	if(indTyp=="ORANGE")
 		{	
 			if(capitalInvestMent <= 1)
  		{
  			result=200;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=400;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=800;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1600;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3200;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=5400;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=12600;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=22100;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=34700;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=50400;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=69300;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=101300;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=135000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=182300;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=249800;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=337500;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=675000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1687500;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=3375000;
  		}
  		
  	}
		if(indTyp=="GREEN")
 		{
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
}  		
  		else
  		{
  		if(indTyp=="RED")
 		{
 			if(capitalInvestMent <= 1)
  		{
  			result=250;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=500;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=900;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1800;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3600;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=6000;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=14000;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=24500;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=38500;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=56000;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=77000;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=112500;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=150000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=202500;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=277500;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=375000;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=750000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1875000;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=375000;
  		}
  		}
  	if(indTyp=="ORANGE")
 		{	
 			if(capitalInvestMent <= 1)
  		{
  			result=200;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=400;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=800;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1600;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3200;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=5400;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=12600;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=22100;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=34700;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=50400;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=69300;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=101300;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=135000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=182300;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=249800;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=337500;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=675000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1687500;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=3375000;
  		}
  	}
		if(indTyp=="GREEN")
 		{
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
  }

		}
	//alert("result44444444444.."+result)	
	for(var i = 0; i<document.form1.consentType.length; i++){

 	if(document.form1.consentType[i].checked){
 
 	var radiomenu = document.form1.consentType[i]

   	 if (radiomenu.value == "CTO") {
   	
   	document.getElementById('result1').value=result; 
   	
 			
			
		} 
	
		if (radiomenu.value == "CTE") {
	
		document.getElementById('result1').value=result;
					}  

	} 
		
  } 
	
	}
	return true;
}
</script>
<script type="text/javascript">
function Calculate1()
{
//	alert ('yyyyyy'+document.getElementById('indTypR').checked)

	var indTyp;
	var consent;
	
	
		if(document.getElementById('indTypR').checked==true)
	{
			//alert ('yyyyyy11');
		indTyp=document.getElementById('indTypR').value;
	}
	else if(document.getElementById('indTypO').checked==true)
	{
		indTyp=document.getElementById('indTypO').value;
	}
	else
	{
		indTyp=document.getElementById('indTypG').value;
	}
	
	var capitalInvestMent; 
	capitalInvestMent=document.getElementById('capital').value;
	
	var consentType; 
	consentType=document.getElementById('consentType').value;
	//alert ('yyyyyy11'+consentType);
	var certificatefor
	if(document.getElementById('consentY').checked==true)
	{
		certificatefor=document.getElementById('consentY').value;
	}
	else
	{
		certificatefor=document.getElementById('consentN').value;
	}
	//alert ('yyyyyy11'+certificatefor);
	var result2;
	
	var ValidationRequired;
	ValidationRequired="/^.*(?=.*[0-9]).*$/";
	
	
	if(capitalInvestMent=="")
	{
		alert("Please give the Amount.");
		return false;
	}
	else
	{
		if(certificatefor=="Fresh")
		{
		if(consentType=="CTE")
		{
		if(indTyp=="RED")
   		{
   			if(capitalInvestMent <= 1)
    		{
    			result=400;
    		}
    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
    		{
    			result=800;
    		}
    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
    		{
    			result=1500;
    		}
    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
    		{
    			result=3000;
    		}
    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
    		{
    			result=6000;
    		}
    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
    		{
    			result=10000;
    		}
    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
    		{
    			result=20000;
    		}
    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
    		{
    			result=35000;
    		}
    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
    		{
    			result=55000;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
    		{
    			result=80000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=110000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
    		{
    			result=150000;
    		}
    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
    		{
    			result=200000;
    		}
    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
    		{
    			result=270000;
    		}
    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
    		{
    			result=370000;
    		}
    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
    		{
    			result=500000;
    		}
    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
    		{
    			result=1000000;
    		}
    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
    		{
    			result=2500000;
    		}
    		else if(capitalInvestMent > 500000)
    		{
    			result=5000000;
    		}
    			}
		else if(indTyp=="ORANGE")
   		{	
   			if(capitalInvestMent <= 1)
    		{
    			result=360;
    		}
    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
    		{
    			result=720;
    		}
    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
    		{
    			result=1350;
    		}
    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
    		{
    			result=2700;
    		}
    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
    		{
    			result=5400;
    		}
    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
    		{
    			result=9000;
    		}
    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
    		{
    			result=18000;
    		}
    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
    		{
    			result=31500;
    		}
    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
    		{
    			result=49500;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
    		{
    			result=72000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=99000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
    		{
    			result=135000;
    		}
    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
    		{
    			result=180000;
    		}
    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
    		{
    			result=243000;
    		}
    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
    		{
    			result=333000;
    		}
    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
    		{
    			result=450000;
    		}
    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
    		{
    			result=900000;
    		}
    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
    		{
    			result=2250000;
    		}
    		else if(capitalInvestMent > 500000)
    		{
    			result=4500000;
    		}
    		
    	}
		else if(indTyp=="GREEN")
   		{
			if(capitalInvestMent <= 1)
    		{
    			result=200;
    		}
    		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
    		{
    			result=500;
    		}
    		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
    		{
    			result=1000;
    		}
    		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
    		{
    			result=2100;
    		}
    		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
    		{
    			result=4200;
    		}
    		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
    		{
    			result=7000;
    		}
    		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
    		{
    			result=14000;
    		}
    		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
    		{
    			result=24500;
    		}
    		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
    		{
    			result=38500;
    		}
    		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
    		{
    			result=56000;
    		}
    		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
    		{
    			result=77000;
    		}
    		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
    		{
    			result=105000;
    		}
    		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
    		{
    			result=140000;
    		}
    		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
    		{
    			result=189000;
    		}
    		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
    		{
    			result=259000;
    		}
    		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
    		{
    			result=350000;
    		}
    		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
    		{
    			result=700000;
    		}
    			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
    		{
    			result=1750000;
    		}
    		else if(capitalInvestMent > 500000)
    		{
    			result=3500000;
    		}
      }	}else{
    		
  	 	if(category=="RED")
     		{
     			if(capitalInvestMent <= 1)
      		{
      			result=400;
      		}
      		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
      		{
      			result=800;
      		}
      		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
      		{
      			result=1500;
      		}
      		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
      		{
      			result=3000;
      		}
      		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
      		{
      			result=6000;
      		}
      		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
      		{
      			result=10000;
      		}
      		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
      		{
      			result=20000;
      		}
      		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
      		{
      			result=35000;
      		}
      		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
      		{
      			result=55000;
      		}
      		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
      		{
      			result=80000;
      		}
      		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
      		{
      			result=110000;
      		}
      		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
      		{
      			result=150000;
      		}
      		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
      		{
      			result=200000;
      		}
      		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
      		{
      			result=270000;
      		}
      		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
      		{
      			result=370000;
      		}
      		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
      		{
      			result=500000;
      		}
      		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
      		{
      			result=1000000;
      		}
      			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
      		{
      			result=2500000;
      		}
      		else if(capitalInvestMent > 500000)
      		{
      			result=5000000;
      		}
      			}
      	if(category=="ORANGE")
     		{	
     			if(capitalInvestMent <= 1)
      		{
      			result=360;
      		}
      		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
      		{
      			result=720;
      		}
      		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
      		{
      			result=1350;
      		}
      		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
      		{
      			result=2700;
      		}
      		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
      		{
      			result=5400;
      		}
      		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
      		{
      			result=9000;
      		}
      		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
      		{
      			result=18000;
      		}
      		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
      		{
      			result=31500;
      		}
      		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
      		{
      			result=49500;
      		}
      		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
      		{
      			result=72000;
      		}
      		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
      		{
      			result=99000;
      		}
      		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
      		{
      			result=135000;
      		}
      		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
      		{
      			result=180000;
      		}
      		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
      		{
      			result=243000;
      		}
      		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
      		{
      			result=333000;
      		}
      		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
      		{
      			result=450000;
      		}
      		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
      		{
      			result=900000;
      		}
      			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
      		{
      			result=2250000;
      		}
      		else if(capitalInvestMent > 500000)
      		{
      			result=4500000;
      		}
      		
      	}
  		if(category=="GREEN")
     		{
  			if(capitalInvestMent <= 1)
      		{
      			result=200;
      		}
      		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
      		{
      			result=500;
      		}
      		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
      		{
      			result=1000;
      		}
      		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
      		{
      			result=2100;
      		}
      		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
      		{
      			result=4200;
      		}
      		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
      		{
      			result=7000;
      		}
      		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
      		{
      			result=14000;
      		}
      		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
      		{
      			result=24500;
      		}
      		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
      		{
      			result=38500;
      		}
      		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
      		{
      			result=56000;
      		}
      		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
      		{
      			result=77000;
      		}
      		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
      		{
      			result=105000;
      		}
      		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
      		{
      			result=140000;
      		}
      		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
      		{
      			result=189000;
      		}
      		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
      		{
      			result=259000;
      		}
      		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
      		{
      			result=350000;
      		}
      		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
      		{
      			result=700000;
      		}
      			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
      		{
      			result=1750000;
      		}
      		else if(capitalInvestMent > 500000)
      		{
      			result=3500000;
      		}
      }    
      
      }}if(certificatefor=="Renew")
		{

			if(consentType=="CTE")
			{	
				if(indTyp=="RED")
 		{
					if(capitalInvestMent <= 1)
  		{
  			result=250;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=500;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=900;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1800;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3600;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=6000;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=14000;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=24500;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=38500;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=56000;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=77000;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=112500;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=150000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=202500;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=277500;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=375000;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=750000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1875000;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=375000;
  		}
  		}
  	if(indTyp=="ORANGE")
 		{	
 			if(capitalInvestMent <= 1)
  		{
  			result=200;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=400;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=800;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1600;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3200;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=5400;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=12600;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=22100;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=34700;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=50400;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=69300;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=101300;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=135000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=182300;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=249800;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=337500;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=675000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1687500;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=3375000;
  		}
  		
  	}
		if(indTyp=="GREEN")
 		{
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
}  		
  		else
  		{
  		if(indTyp=="RED")
 		{
 			if(capitalInvestMent <= 1)
  		{
  			result=250;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=500;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=900;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1800;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3600;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=6000;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=14000;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=24500;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=38500;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=56000;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=77000;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=112500;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=150000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=202500;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=277500;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=375000;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=750000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1875000;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=375000;
  		}
  		}
  	if(indTyp=="ORANGE")
 		{	
 			if(capitalInvestMent <= 1)
  		{
  			result=200;
  		}
  		else if(capitalInvestMent > 1 && capitalInvestMent <= 5)
  		{
  			result=400;
  		}
  		else if(capitalInvestMent > 5 && capitalInvestMent <= 10)
  		{
  			result=800;
  		}
  		else if(capitalInvestMent > 10 && capitalInvestMent <= 25)
  		{
  			result=1600;
  		}
  		else if(capitalInvestMent >25 && capitalInvestMent <= 50)
  		{
  			result=3200;
  		}
  		else if(capitalInvestMent > 50 && capitalInvestMent <= 100)
  		{
  			result=5400;
  		}
  		else if(capitalInvestMent > 100 && capitalInvestMent <= 500)
  		{
  			result=12600;
  		}
  		else if(capitalInvestMent > 500 && capitalInvestMent <= 1000)
  		{
  			result=22100;
  		}
  		else if(capitalInvestMent > 1000 && capitalInvestMent <= 2500)
  		{
  			result=34700;
  		}
  		else if(capitalInvestMent > 2500 && capitalInvestMent <= 5000)
  		{
  			result=50400;
  		}
  		else if(capitalInvestMent > 5000 && capitalInvestMent <= 10000)
  		{
  			result=69300;
  		}
  		else if(capitalInvestMent > 10000 && capitalInvestMent <= 25000)
  		{
  			result=101300;
  		}
  		else if(capitalInvestMent > 25000 && capitalInvestMent <= 50000)
  		{
  			result=135000;
  		}
  		else if(capitalInvestMent > 50000 && capitalInvestMent <= 100000)
  		{
  			result=182300;
  		}
  		else if(capitalInvestMent > 100000 && capitalInvestMent <= 500000)
  		{
  			result=249800;
  		}
  		else if(capitalInvestMent > 500000 && capitalInvestMent <= 1000000)
  		{
  			result=337500;
  		}
  		else if(capitalInvestMent > 1000000 && capitalInvestMent <= 250000)
  		{
  			result=675000;
  		}
  			else if(capitalInvestMent > 250000 && capitalInvestMent <= 500000)
  		{
  			result=1687500;
  		}
  		else if(capitalInvestMent > 500000)
  		{
  			result=3375000;
  		}
  	}
		if(indTyp=="GREEN")
 		{
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
  }

		}
	//alert("result44444444444.."+result)	
	for(var i = 0; i<document.form1.consentType.length; i++){

 	if(document.form1.consentType[i].checked){
 
 	var radiomenu = document.form1.consentType[i]

   	 if (radiomenu.value == "CTO") {
   	
   	document.getElementById('result1').value=result; 
   	
 			
			
		} 
	
		if (radiomenu.value == "CTE") {
	
		document.getElementById('result1').value=result;
					}  

	} 
		
  } 
	
	}
	return true;

	
}
</script>
</head>
<body>

<header id="header">
<div id="top-bar">
<div class="container-fluid">
<div class="row">
<div class="col-sm-8 top-info hidden-xs"><span><i class=""></i></span>
<span><i class=""></i></span></div>

<div class="col-sm-4 top-info">
<ul>
	<li><a href="" class="my-tweet">A+</a></li>
	<li><a href="" class="my-facebook">A</a></li>
	<li><a href="" class="my-skype">A-</a></li>
</ul>
</div>


</div>
</div>
</div>
<div id="logo-bar">
<div class="container-fluid">



<div class="row top_head_bg"><!-- Logo start -->
<div class="col-lg-3 col-sm-3 left-position">
<div class="inline-section logo "><a href="index.gsp"><img 	src="images/jammu.jpg"  height="70" width="60"/></a></div>
<div class="inline-section top-space-5">
<h3 class="text-green">J & K <br><span> Pollution Control Committee</span></h3>
</div>
</div>
<!-- Navigation
    ================================================== -->
<div class="col-lg-7 col-sm-7">
<div class="top_header center-position">
<h1>Online Consent Management &amp; Monitoring System</h1>
<p>Ministry of Environment, Forest and Climate Change <br>
Government of india</p>

</div>
</div>

<div class="col-lg-2 col-sm-2 right-position "><img	src="images/right-logo.png" /></div>
</div>

<div class="row">
<div class="col-lg-12 col-sm-12 header_bg ">
<div class="navbar navbar-default navbar-static-top" role="navigation">
<!--  <div class="container">-->
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse"
	data-target=".navbar-collapse"><span class="sr-only">Toggle
navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
<span class="icon-bar"></span></button>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav">
	<li><a href="https://ocmms.nic.in/OCMMS_NEW/"><i class="fa fa-home"></i>Home</a></li>
	
	<li>
	<a href="#" data-toggle="modal" data-target="#faq1">
	<i class="fa  fa-user"></i>FAQ</a></li>
	
	<li><a href="<%=cont%>/userMaster/EnvironmentPolicy.gsp"> <i class="fa  fa-user"> </i>
	Environment Policy</a>
	
	</li>
	
	<li>
	<a href="<%=cont%>/SPCB_DOCUMENTS/Guidelines.pdf" target="_blank">
	<i class="fa  fa-lightbulb-o"></i>Guidelines</a>
	
	</li>
	
	<li><a href="<%=cont%>/SPCB_DOCUMENTS/Consent Manual.pptx" data-toggle="modal">
	<i class="fa  fa-lightbulb-o"></i>Industry User Manual</a>
		</li>
		
	<li><a href="#" data-toggle="modal" data-target="#sop1">
		<i class="fa  fa-lightbulb-o"></i>Circular</a>
			</li>
	
	<li>
	<a href="#" data-toggle="modal" data-target="#contact1">
	<i class="fa fa-lg fa-phone"></i>Contact Us</a></li>
	
	<li>
	   <a href="<%=cont%>/allReports/dashboard" target="_blank">
	        <i class="fa  fa-dashboard"></i>Dashboard</a> 
	</li>
	
	<li> 
	<a href="#" data-toggle="modal" data-target="#notice1">
	<i class="fa  fa-info-circle"></i>Help</a></li>
	
	
	


</ul>
</div>
</div>
</div>


</div>

</div>

</div>


</header>
<!--End Header-->
<%


 Random rand=new Random();
		        String s ="";
		        for (int i = 0; i < 6; i++)
		        {
		        	s=s+rand.nextInt(10).toString();
		        }
def tunt=rand.nextInt(100)+99;
def capCode1=s

session.tunt=tunt.toString()
session.capCode=capCode1

%>
<marquee scrollamount="5" onMouseOver="this.stop()" onMouseOut="this.start()">
<font  font="BOLD" size="3" style="color:red">
Unit holders are advised to apply for their consent cases on single window portal of UT of jammu and kashmir only which is as </font> <font font="BOLD" size="3" style="color:blue">https://singlewindow.jk.gov.in </font><font font="BOLD" size="3" style="color:red">as jkocmms of jkpcc is going to close soon.
  </font> 
  </marquee>
  
  <marquee scrollamount="5" onMouseOver="this.stop()" onMouseOut="this.start()">
  <font  font="BOLD" size="2" style="color:green">
  All Green Category Industry as per Order No.78 and 79 of JK PCC dated 29.03.2022 can now apply for RENEWAL of their Consents through AUTO-RENEWAL Mode in the JKOCMMS as per EoDB
    </font> 
    </marquee>
    
<!--start wrapper-->
<section class="wrapper">
<div class="blank_2"></div>
<!--Start Slider-->
<div class="container-fluid">
<div class="row">

<div class="col-md-3">

<div class="row">

<div class="col-md-12">
<div class="panel panel-primary blank" >

<div class="panel-heading font-s"><span
	class="glyphicon glyphicon-list-alt"></span>News/Press</div>


<ul class="list-group scroll-w">
<!--	<li class="news-item">There are many variations of passages of Lorem Ipsum available..<a href="#">Read
	more...</a></li>
	<li class="news-item">Contrary to popular belief, Lorem Ipsum is not simply random text.. <a href="#">Read
	more...</a></li>
 	<li class="news-item">There are many variations of passages of Lorem Ipsum available. <a href="#">Read
	more...</a></li>
	<li class="news-item">Contrary to popular belief, Lorem Ipsum is not simply random text.. <a href="#">Read
	more...</a></li>
-->
<li class="news-item">Joint Statement issued at the conclusion of he 22 Basic Ministerial Meeting on Climate Change India on 7 April 2016 Joint Statement issued....</li>

<li class="news-item">The first meeting of the National  River Basin Authority was held on 5 October 2009 under the Chairmanship of the Prime Minister. The meeting 

On July 10 ,2009 , the Supreme Court passed an order on the  issue in response to an affidavit filed by the Ministry of Environment & Forests, along with
The National Estimation of the Status of the Tiger is based on established scientific procedure to provide information on tiger populations in India</li>

</ul>





</div>

</div>




<div class="col-md-12">
<div class="panel panel-primary blank">

<div class="panel-heading font-s"><span
	class="glyphicon glyphicon-list-alt"></span>Important Links</div>



<ul class="list-group scroll-w">
  <li class="list-group-item  mar-s "><a href="https://jkspcb.nic.in/" target="_blank" class="list-group-item list-group-item-action"><i class="fa fa-chevron-circle-right " aria-hidden="true"></i>
  Jammu & Kashmir Pollution Control Committee</a></li>
  <li class="list-group-item  mar-s "> <a href="https://www.cpcb.nic.in/" target="_blank" class="list-group-item list-group-item-action"><i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
  Central Pollution Control Committee</a></li>
  <li class="list-group-item  mar-s "><a href="https://www.moef.nic.in/" target="_blank" class="list-group-item list-group-item-action"> <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
  Ministry of Environment & Forests</a></li>
  <li class="list-group-item  mar-s "><a href="<%=cont%>/allReports/dashboard" target="_blank" class="list-group-item list-group-item-action"> <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
  Dashboard</a></li>
  <li class="list-group-item  mar-s "><a href="https://drive.google.com/drive/folders/1bmgn7ij3djPh0nTM-1mqLqIJ0oCT4H_7?usp=sharing" target="_blank" class="list-group-item list-group-item-action"> <i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
  Mobile App</a></li>
 
</ul>


</div>

</div>


<div class="col-md-12">

<div class="panel panel-primary blank">

<div class="panel-body ">
<a href="#"><img src="images/feedack.gif"  class="img-responsive  "/></a>
<a href="#"><img src="images/query.gif"  class="img-responsive  "/></a>

</div>
</div>
</div>




</div>




</div>

<div class="col-md-6 ">

<div class="row">

<div class="col-md-12  mar-s blank_2   ">
<div class="mid-panel-header">
<div class="flexslider ">
<ul class="slides ">
<!--    <li><img src="images/slider/14.jpg" class="img-responsive" /></li>    -->
<li><img src="images/slider/05.jpg" class="img-responsive" /></li>
<li><img src="images/slider/06.jpg" class="img-responsive" /></li>
<li><img src="images/slider/07.jpg" class="img-responsive" /></li>
</ul>
</div>
</div>

</div>

<div class="clearfix"></div>

<div class="col-md-12 blank_mar  box-border ">
<div class="row ">

<div class="col-md-6">
<div class="heading1">About PCB</div>
<div class="heading-text">
<img src="images/pic.jpg" class="img-responsive thumbnail " align="left" vspace="3" hspace="3"  />The Pollution Control Committee has been established as a regulatory authority for implementing various pollution control laws. <a href="#" data-toggle="modal" data-target="#more1">More>></a>
</div>
</div>

<div class="col-md-6">
<div class=" heading1">Hazardous Waste Management Granted Applications </div>
<div class="heading-text">
<img src="images/pic.jpg" class="img-responsive thumbnail " align="left" vspace="3" hspace="3"  />Hazardous Waste Management Granted Applications.<!--<a href="#" data-toggle="modal" data-target="#more2">More>></a>-->
</div>
</div>



</div>



</div>



<div >&nbsp;</div>
<% String cont12=request.getContextPath(); %>
<div class="col-md-12">
<div>
<div class="col-md-3"><g:link controller="userMaster" action="pendingAppSearch" class="link-r css_blink">Consent Pending</g:link></div>
<div class="col-md-3"><g:link controller="userMaster" action="grantedApplicationSearch" class="link-r css_blink">Consent Granted Applications</g:link></div>
<div class="col-md-3"><g:link controller="userMaster" action="rejectedApplicationSearch" class="link-r css_blink">Consent Rejected Applications</g:link></div>
<div class="col-md-3"><g:link controller="userMaster" action="authApplicationSearch" class="link-r css_blink">Waste Applications Status Report</g:link></div>
<!--<div class="col-md-3"><g:link controller="userMaster" action="inspectionApplicationSearch" class="link-r css_blink">Inspection Generated Applications</g:link></div> -->

</div>

</div>






</div>


<div class="row">

<div class="col-md-12">
 <div class="marquee-box"> 
 
 <marquee  scrollamount="5" onMouseOver="this.stop()" onMouseOut="this.start()">

 <a href="https://youtu.be/yWXfNaIrfng" target="_blank">
 <font  font="BOLD" size="2" style="color:red">
 User Manual Video
 </font>
    </a>
    </marquee>
    
    <marquee  scrollamount="5" onMouseOver="this.stop()" onMouseOut="this.start()">

    <a href="<%=request.getContextPath()%>/SPCB_DOCUMENTS/Latest_118_Final_Directions.pdf" target="_blank">
    <font  font="BOLD" size="2" style="color:red">
    Revised Classification of Industrial Sectors
    </font>
       </a>
       </marquee>
       
       
 
    <marquee  scrollamount="5" onMouseOver="this.stop()" onMouseOut="this.start()">
    
    <a href="<%=request.getContextPath()%>/SPCB_DOCUMENTS/T_C_JKPCB.pdf" target="_blank">
    <font  font="BOLD" size="2" style="color:red">
    Terms and Conditions for Online Payment
    </font>
       </a>
       </marquee>
   
 <marquee scrollamount="5" onMouseOver="this.stop()" onMouseOut="this.start()">
   
 OCMMS Help Desk from 06:00 A.M to 10:00 P.M,Phone No : 011-49878310, 011-49878410
   
   </marquee>
 

 <font  font="BOLD" size="2" style="color:blue">
 &nbsp;&nbsp;User are advised to browse this site using Google chrome browser for trouble free filing.
 </font>
 </div>

</div>


</div>



</div>



<form id="form1" name="form1" method="POST" action="userMaster/doLogin">
<div class="col-md-3">
<div class="row ">
<div class="col-md-12">

<div class="panel panel-primary blank ">

<div class="panel-heading font-s">User Login</div>

<div class="panel-body pad-bot ">
<div class="row">
<div class="col-lg-10 col-md-10">
<g:if test="${flash.message}">
<div class="style1"> 
	<span class="error">${flash.message}</span><br/>
</div>
</g:if>
<div class="right mar">
<input id="radioButton" name="radioButton"  type="radio" value="SPCB" checked="checked" />
            <label for="SPCB">SPCB Login</label> <br>
            
 <input id="radioButton" name="radioButton" type="radio" value="Industry" />
<label for="Industry">Industry Login/Auto-Renewal</label>
            

</div>
</div>


</div>

<div class="row">
<div class="col-lg-12 col-md-12">
 User ID :
</div>

<div class="col-lg-12 col-md-12">
<input type="text" id="userId" name='userId' AUTOCOMPLETE=OFF  class="input_bg"  />
</div>

</div>


<div class="row">
<div class="col-lg-12 col-md-12">
 Password :
</div>

<div class="col-lg-12 col-md-12">
<input type="password" id="password" name='password' AUTOCOMPLETE=OFF class="input_bg"  />
</div>
<input type ="hidden" name = "browserDetails" id="browserDetails" value="">
<g:hiddenField name="tunt1" value="${tunt}" />
</div>

<div class="row">
<div class="col-lg-12 col-md-12">
 
Captcha Code 
</div>

<div class="col-lg-6 col-md-6">
<input type="text" id="captchaCode" name='captchaCode' AUTOCOMPLETE=OFF class="input_bg"  />
</div>


<div class="col-lg-6 col-md-6">

<div class="capcha" style="font-size:20px;margin-left:8px;">${capCode1}</div>
</div>

</div>




<div class="row">

<div class="col-lg-5 col-md-5">
<input name="" type="submit" value="Login" onClick="loginEncryption();loginForm();" class="login_but">

</div>

<div class="col-lg-7 col-md-7 mar-top-but" >
<g:link controller="indCatMaster" action="forgetPassword" class="link-g ">Forgot Password</g:link> 
</div>

</div>

<div class="row ">

<div class="col-lg-10 col-md-10 blank-top-5 right ">


<button type="button" class="btn btn-danger but_blink  " onClick="registration()">
<i class="fa  fa-check-square-o"> </i>
New Industry/HCF Registration

</button>

</div>


</div>


</div>
</div>
</div>

</form>
<div class="col-md-12">

<div class="panel panel-primary blank">

<div class="panel-heading font-s">Fee Calculator</div>

<div class="panel-body pad-bot ">
<div class="row">
<div class="col-lg-5 col-md-5">
Consent Type:
</div>

<div class="col-lg-7 col-md-7">
<div >
<input title="Consent to Establish" id="consentType" name="consentType" type="radio" value="CTE" checked="checked" onclick="javascript:hidediv();"  />CTE
<input title="Consent to Operate" id="consentType" name="consentType" type="radio" value="CTO" onclick="javascript:hidediv();"/>CTO
           

</div>
</div>


</div>


<div class="row">
<div class="col-lg-5 col-md-5">
Industry Type:
</div>

<div class="col-lg-7 col-md-7">
<div >
<input id="indTypR" name="indTyp" type="radio" value="RED" checked="checked"/>Red
<input id="indTypO" name="indTyp" type="radio" value="ORANGE" />Orange
<input id="indTypG" name="indTyp" type="radio" value="GREEN" />Green

</div>
</div>


</div>

<div class="row">
<div class="col-lg-5 col-md-5">
Certificate For:
</div>

<div class="col-lg-7 col-md-7">
<div >
<input id="consentY" name="consent" type="radio" value="Fresh" checked="checked" />
<label for="male"> Fresh</label>

<input id="consentN" name="consent" type="radio" value="Renew" />
<label for="female">Renew</label>


</div>
</div>


</div>


<div class="row">
<div class="col-lg-12 col-md-12">
 Capital Investment(in lakhs): 
</div>

<div class="col-lg-12 col-md-12">
<input id="capital" name="capital" type="number" size="10" class="input_bg"  />
</div>

</div>

<div class="row">
<div class="col-lg-12 col-md-12">
 Consent Fee: 
	 <div class="row">
	 <div class="col-lg-6 col-md-6"><input id="result1" size="10" name="result1" type="text" readonly="readonly" class="input_bg"  /></div>
</div>
	 <div class="col-lg-12 col-md-12" style="display:none;" id="selectTemp66">
<div class="row">

<div class="col-lg-1 col-md-1 left mar-s"><img src="images/rupeegray.png" class="img-responsive" align="left" /></div>
<div class="col-lg-5 col-md-5"> 

<a href="javascript:{}" onclick="return Calculate();" align="center" class="bulletinside"><b>Calculate</b></a>

</div>
</div>
</div>
</div>
</div>

<div class="col-lg-12 col-md-12" style="display:block;" id="selectTemp666">
<div class="row">

<div class="col-lg-1 col-md-1 left mar-s"><img src="images/rupeegray.png" class="img-responsive" align="left" /></div>
<div class="col-lg-5 col-md-5"> 

<a href="javascript:{}" onclick="return Calculate1();"  >
<b>Calculate</b></a>
</div>
</div>
</div>
</div>


</div>





</div>

</div>




</div>




</div>




<!--End Slider-->

<div class="clearfix"></div>



<div class="clear blank_10"></div>

<!--footer_bottom start-->
<section class="footer_bottom">
<div class="container-fluid">

<div class="row">
<div class="col-sm-12 center-position">

<p class="copyright">Site designed, hosted by National Informatics Center <br>
&copy; Content Owned, Updated and Maintained by J & K Pollution Control Committee</p>
</div>

</div>


</div>
</section>
<!--footer_bottom end-->






<!-- Modal start -->
<div id="myModal" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title"> Cirulars Header</h4>
</div>
<div class="modal-body">
<p>Some text in the ...</p>
</div>

</div>

</div>
</div>
<!-- Modal  end -->




<!-- Modal start -->
<div id="myModal2" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">About PCB</h4>
</div>
<div class="modal-body">
<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. </p>
<br/>
<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. </p>
</div>

</div>

</div>
</div>
<!-- Modal  end -->




<!-- Modal start -->
<div id="myModal4" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">FAQ's</h4>
</div>
<div class="modal-body">
        <p>Ques:What are important Environmental Laws in the Country?
        <br/>
Ans: The Water (Prevention and Control of Pollution) Act, 1974

The Air (Prevention and Control of Pollution) Act, 1981

The Water (prevention and Control of Pollution) Cess Act, 1977

The Environment (Protection) Act, 1986 and Rules there under

The Public Liability Insurance Act, 1981
</p>
      </div>
      
      <div class="modal-body">
      <p>Ques:Is any fee required for obtaining consent? What do you mean by Consent Fee?
      <br/>
Ans: Yes Sir. The consent fee means the fees charged by the Board for the grant of consent by the Board.
</p>
    </div>
    
    <div class="modal-body">
      <p>Ques:What do you mean by Water and Air Consent?
              Who are required to obtain consent from Board?
      <br/>
Ans: Consent
means the sanction of the authority of the Board for the discharge of
the effluent (sewage or trade effluent into a stream or well or sewer
or on land ) or emission of air pollutant into the atmosphere. The
consent issued by Board under section 25/26 of the Water (Prevention
and Control of Pollution) Act 1974 is known as water consent and under
section 21 of the Air (Prevention and Control of Pollution) Act, 1981
is known as air consent</p>
<p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">As
per section 25 of the Water (Prevention and Control of Pollution) Act
1974, no person shall without the previous consent of the State Board,</p>
<ol class="txt4">
  <li>
    <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Establish or take any steps to establish any industry,
    operation or process, or any treatment and disposal system or any
    extension or addition thereto, which is likely to discharge sewage
    or trade effluent into a stream or well or sewer or on land; or</li>
  <li>
    <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Bring into use any new or altered outlets for the
    discharge of sewage; or</li>
  <li>
    <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Being to make any new discharge of sewage.</li>
</ol>
<p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">And,
as per section 21 of the Air (Prevention and Control of Pollution)
Act, 1981, no person shall without previous consent of the State
Board, establish or operate any industrial plant in an air pollution
control area.
</p>
    </div>
      
      <div class="modal-body">
        <p>Ques:Is any fee required for obtaining consent? What do you mean by Consent Fee?
        <br/>
Ans: Yes Sir. The consent fee means the fees charged by the Board for the grant of consent by the Board.
</p>
      </div>
      
      <div class="modal-body">
        <p>Ques:What do you mean by investment?
        <br/>
Ans: The investment means the amount of capital invested by the industry on capital works including land; machinery; and equipment. This is the gross block (without depreciation) of all fixed assets.
</p>
      </div>
      
      
      <div class="modal-body">
        <p>Ques:Is there any prescribed form for consent application?
        <br/>
Ans: Yes Sir, There are prescribed forms of application for obtaining consent.
</p>
      </div>
      
      
      <div class="modal-body">
        <p>Ques:Where the consent application forms are available?
        <br/>
Ans: The consent application forms are available at Offices of the Jammu & Kashmir State Pollution Control Committee.
</p>
      </div>
      
      <div class="modal-body">
        <p>Ques:Whether consent renewal fee has to be paid annually?
        <br/>
Ans: A web-site contains several works such as literary works, artistic works (photographs etc.), sound recordings, video clips, cinematograph films and broadcastings and computer software too. Therefore, a separate application has to be filed for registration of all these works.
</p>
      </div>


</div>

</div>
</div>
<!-- Modal  end -->




<!-- Modal start -->
<div id="myModal5" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Contact Us</h4>
</div>

<div class="modal-body">
<div class="row ">
<div class="col-lg-10 con-s">
  <p> <span>Sh. Sanjay Singh Gahlout</span><br>
        Deputy Director General</p>
<p><span>    
National Informatics Center</span></p>
<p class="blank_2">

Department of Electronics & Information Technology
<br/>
A-Block, Room No.351, CGO Complex, Lodhi Road
<br/>
New Delhi -110003 India
<br/>
Phone : <strong>011-24364294</strong>
<br/>
Email : <strong>gahlout@nic.in</strong>
</p>

</div>


<div class="col-lg-10 con-s">
 <p><span>Head,C P Division</span><p>
     
 <p><span>      
Ministry of Environment & Forest</span></p>
<p class="blank_2">
Paryavaran Bhawan, CGO Complex, Lodhi Road
<br/>
New Delhi -110003 India
<br/>
Phone : <strong>011-24360734</strong>
<br/>
Email : <strong>hasan-moef@nic.in</strong>
</p>

</div>

</div>


</div>
      
      


</div>

</div>
</div>
<!-- Modal  end -->




<!-- Modal start -->
<div id="myModal6" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Copyright Policy</h4>
</div>
<div class="modal-body">
<p>Some text in the ...</p>
</div>

</div>

</div>
</div>
<!-- Modal  end -->

<!-- Notices --->

<div id="notice1" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Online OCMMS Help Desk</h4>
</div>
      
      <div class="modal-body">
        <p>
    <!--    <b>Online OCMMS Help Desk</b>
        <br/>
       <br/>
       -->  For any Issue related to OCMMS site like Indusry Registration form filling, Application form filling.
        <br/>
        The help Desk are operational Daily 06:00 A.M to 10:00 P.M,
        <br/>
        Phone No : 011-49878310, 011-49878410
        <br/>
        E.mail: ocmms.pcb@gov.in
</p>
      </div>
  


</div>

</div>
</div>

<!--Notices end -->

<!-- Circular --->

<div id="sop1" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Circular</h4>
</div>
      
      <div class="modal-body">
        <p>1.
        <a href="<%=cont%>/SPCB_DOCUMENTS/Circular.pdf" target="_blank"><u><font color="blue">Creation of new passwords in case of blocking of User ID's reg</font></u></a>  
	    <br>2.
	     <a href="<%=cont%>/SPCB_DOCUMENTS/Revision of consent validity period.pdf" target="_blank"><u><font color="blue">Revision of Consent validity period of 5, 8 & 12 years</font></u></a>                 
	     <br>3.
	     <a href="<%=cont%>/SPCB_DOCUMENTS/eodb ord.pdf" target="_blank"><u><font color="blue">EODB</font></u></a>
	     <br>5.
	     <a href="<%=cont%>/SPCB_DOCUMENTS/consent fee jk.pdf" target="_blank"><u><font color="blue">Consent FEE</font></u></a>                  
	     <br>6.
	     <a href="<%=cont%>/SPCB_DOCUMENTS/Fee Structure BMW.pdf" target="_blank"><u><font color="blue">BIO-MEDICAL FEE</font></u></a>  
</p>
      </div>
  

<div class="modal-footer">
<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>
</div>

</div>
</div>

<!--SOP end -->

<!-- Contact Us --->

<div id="contact1" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Contact Us</h4>
</div>
      
      <div class="modal-body">
      
      <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" >
      
     			   <tr class="txt4" >
        <td width="100%" height="100%"  class="headngblue1" border="0">
       <b><u>CHAIRMAN</u></b><br>
     <!--	Dr. Mohit Gera (IFS)<br> -->
    <!-- 	Mob:-9412053296<br>  -->
       Telephone: (Jammu), 0191-2476927 <br>
      	           (Srinagar), 0194-2313966<br>
   <!--   	 (Fax), 19112476927<br>          --> 
        Email:-chairman87jkspcb@gmail.com<br>
   <!--			chairman.spcb@jk.gov.in <br>
        	mohitgera87@gmail.com    -->
       </td>
             </tr>
             <tr class="txt4" >
             <td width="100%" height="100%"  class="headngblue1" border="0">
            <b> <u>MEMBER SECRETARY</u></b><br>
              Sh. Ghansham Singh, JKAS<br>	         
	          	Telephone: (Jammu), 0191-2476925<br>
	          	           (Srinagar), 0194-2311165<br>
	            Email:-membersecretaryjkspcb@gmail.com<br>

            </td>
                  </tr>
                  <tr class="txt4" >
                  <td width="100%" height="100%"  class="headngblue1" border="0">
                  <b><u>REGIONAL DIRECTOR JAMMU</u></b><br>
                  Ms. Shaveta Jandial, IFS      <br>  	         
  	          	Telephone No: (Office) 0191-2476926 <br>
				Email: regionaldiretorjkspcbjmu@gmail.com <br>			
                 </td>
                       </tr>
                       <tr class="txt4" >
                       <td width="100%" height="100%"  class="headngblue1" border="0">
                   	<b><u>REGIONAL DIRECTOR Kashmir</u></b><br>
                   	Sh. Abhijeet Joshi, SFS     <br>
    	        
                   	Telephone No: (Jammu) 0194-2311165<br>
    	          	Email:- regionadirectorkmr@gmail.com<br>
    	     
    	          	 </td>
                            </tr>
                            
                            <tr class="txt4" >
                            <td width="100%" height="100%"  class="headngblue1" border="0">
                            <b><u>ENVIRONMENTAL ENGINEER </u></b><br>
                            Er. J. N. Sharma<br>
                            HEAD E-GOVERNANCE<br>
                            Nodal Officer (JKOCMMS/EoDB)<br>  
                            Email : headegovernancejkspcb@gmail.com<br>
                            	</td>
                                 </tr>
                                 
                                 
                                 
                                 
                                 
                           <!-- <tr class="txt4" >
                            <td width="100%" height="100%"  class="headngblue1" border="0">
                            <b><u>LEGAL ADVISOR</u></b><br>
            	          	Mr. M M Shah<br>
            	          	Telephone: 9419062063<br>
            (Residence) 01933-222201
                           </td>
                                 </tr> -->
                               <!--  <tr class="txt4" >
                                 <td width="100%" height="100%"  class="headngblue1" border="0">
                                 Telephone No.:0172-2700149
                                </td>
                                      </tr>
                                      <tr class="txt4" >
                                      <td width="100%" height="100%"  class="headngblue1" border="0">
                                      Telefax No.:0172-2700311
                                     </td>
                                           </tr> -->
             </table>

      </div>
  


</div>

</div>
</div>

<!--Contact Us end -->


  


</div>

</div>
</div>

<!--Tenders end -->

<!-- Environment Policy --->

<div id="policy1" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Environment Policy</h4>
</div>
      
      <div class="modal-body">
      <p style="font: normal 11px verdana;line-height:100%; margin-left: 10; margin-right:20" align="justify">
      Environmental policy refers to the commitment of an organization to the laws, regulations, and 
    other policy mechanisms concerning environmental issues and sustainability. These issues generally include air and water pollution, solid waste management, biodiversity, ecosystem management, maintenance of biodiversity, the protection of natural resources, wildlife and endangered species.
    <br><br>
    Policies concerning energy or regulation of toxic substances including pesticides and many types of industrial waste are part of the topic of environmental policy. This policy can be deliberately taken to direct and oversee human activities and thereby prevent harmful effects on the biophysical environment and natural resources, as well as to make sure that changes in the environment do not have harmful effects on humans
    <br><br>
    It is useful to consider that environmental policy comprises two majorterms: environment and policy. Environment refers to the physical ecosystems, but can also take into consideration the social dimension (quality of life, health) and an economic dimension (resource management, biodiversity). Policy can be defined as a "course of action or principle adopted or proposed by a government, party, business or individual". Thus, environmental policy focuses on problems arising from human impact on the environment, which retroacts onto human society by having a (negative) impact on human values such as good health or the 'clean and green' environment
    <br><br>
    <b>Our Policy is</b> 
    <br><br>
    (a) Planning of  comprehensive  programme  for  the  prevention,  control  or abatement  of  pollution  of  streams  and  wells  in  the  state  and  to  secure  the execution there of;<br><br>

    (b) To advise the State Government on any matter concerning the prevention, control or abatement of water pollution;<br><br>

    (c) To collect and disseminate information relating to water pollution and the prevention, control or abatement thereof;<br><br>

    (d  To  encourage,  conduct  and  participate  in  investigations  and research relating  to  problems  of  water  pollution  and  prevention,  control  or  abatement  of water pollution<br><br>

    (e) To  collaborate  with  the  Central  Board  in  organising  the  training  of persons engaged or to  be  engaged  in  programmes relating  to  prevention, control or  abatement  of  water  pollution  and  to  organise  mass  education  programmes relating thereto;<br><br>

    (f)  To  inspect  sewage  or  trade  effluents,  works  and  plants  for  the treatment  of  sewage  and  trade  effluents  and  to  review  plans,  specifications  or other  data  relating  to  plants  set  up  for  the  treatment  of  water,  works  for  the purification  thereof  and the  system  for the disposal  of  sewage  or  trade effluents or in connection with the grant of any consent as required by this Act;
    (g)  Lay  down,  modify  or  annul  effluent  standards  for  the  sewage  and trade effluents and for the quality of receiving waters (not being water in an inter - state  stream)  resulting  from  the discharge of effluents  and  to  classify  waters  of the state;<br><br>

    (h)  To  evolve  economical  and  reliable  methods  of  treatment  of  sewage and trade effluents, with regard to the peculiar  conditions of soils, climate and water  resources  of  different  regions  and  more  especially  the  prevailing  flow characteristic of water  in streams  and wells which  render it  impossible  to  attain even the minimum degree of dilution;<br><br>

         To evolve methods of utilisation of sewage and suitable trade effluents in agriculture;

    (j) To evolve  efficient methods  of disposal  of  sewage and  trade effluents on  land,  as  are  necessary  on  account  of  the  predominant  conditions  of  scant stream  flows  that  do not  provide  for  major part  of the  year the minimum degree of dilution;<br><br>

    (k)  To  lay  down  standards  of  treatment  of sewage and  trade  effluents to be  discharged  into  any  particular  stream  taking  into  account  the  minimum  fair weather  dilution  available  in  that  stream  and  the  tolerance  limits  of  pollution permissible in the water of the stream, after the discharge of such effluents;<br><br>

    (l)  To  advice  the  State  Government  with  respect  to  the  location  of  any industry the carrying on of which is likely to pollute a stream or well.<br><br>


      </div>
  


</div>

</div>
</div>

<!--Environment Policy end -->

<div id="more1" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">About PCB</h4>
</div>
      
      <div class="modal-body">
        <p>The Pollution Control Committee has been established as a regulatory authority for implementing various pollution control laws.
</p>
      </div>
  


</div>

</div>
</div>





<!-- FAQ --->

<div id="faq1" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">FAQ</h4>
</div>
      
      <div class="modal-body">
      
      
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 6px;">
             </td>
         </tr>
         
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
                 
                    <b>Ques:</b>What are important Environmental Laws in the Country? 
             </td>
         </tr>
     </table>
     
      <div id="div">
         <table border="0" cellpadding="5" cellspacing="0">
             <tr>
                 <td align="left" valign="top"><b>Ans:</b>
                     <p class="txt4">
                     The Water (Prevention and
                             Control of Pollution) Act, 1974  </p>
                 
                                               <p class="txt4">
                                                  The Air (Prevention and
                             Control of Pollution) Act, 1981</p>
                              <p class="txt4">
                              The Water
                             (prevention and Control of Pollution) Cess Act, 1977</p>
                               <p class="txt4">
                               The Environment (Protection)
                             Act, 1986 and Rules there under</p>
                              <p class="txt4">
                              The Public Liability Insurance Act, 1981 
                              </p>
</p>
                            



</td>
</tr>
</table>
     </div>
     
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 6px;">
             </td>
         </tr>
         
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
                 
                     <b>Ques:</b>What do you mean by Water and Air Consent?
                             Who are required to obtain consent from Board?</span>
             </td>
         </tr>
     </table>
     
      <div id="div_hi">
         <table border="0" cellpadding="5" cellspacing="0">
             <tr>
                 <td  align="left" valign="top"><b>Ans:</b>
                 Consent
                 means the sanction of the authority of the Board for the discharge of
                 the effluent (sewage or trade effluent into a stream or well or sewer
                 or on land ) or emission of air pollutant into the atmosphere. The
                 consent issued by Board under section 25/26 of the Water (Prevention
                 and Control of Pollution) Act 1974 is known as water consent and under
                 section 21 of the Air (Prevention and Control of Pollution) Act, 1981
                 is known as air consent</p>
                 <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">As
                 per section 25 of the Water (Prevention and Control of Pollution) Act
                 1974, no person shall without the previous consent of the State Board,</p>
                 <ol class="txt4">
                   <li>
                     <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Establish or take any steps to establish any industry,
                     operation or process, or any treatment and disposal system or any
                     extension or addition thereto, which is likely to discharge sewage
                     or trade effluent into a stream or well or sewer or on land; or</li>
                   <li>
                     <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Bring into use any new or altered outlets for the
                     discharge of sewage; or</li>
                   <li>
                     <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Being to make any new discharge of sewage.</li>
                 </ol>
                 <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">And,
                 as per section 21 of the Air (Prevention and Control of Pollution)
                 Act, 1981, no person shall without previous consent of the State
                 Board, establish or operate any industrial plant in an air pollution
                 control area.</p>
                            



</td>
</tr>
</table>
     </div>
     
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 6px;">
             </td>
         </tr>
         
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
                 <b>Ques:</b>Is any fee required for obtaining consent? What do you mean by Consent Fee?</span>
             </td>
         </tr>
     </table>
     
      <div id="div_hi8">
         <table border="0" cellpadding="5" cellspacing="0">
             <tr>
                 <td   align="left" valign="top"><b>Ans:</b>
                     <p class="txt4">
                     Yes Sir. The consent fee means the fees charged by the Board for the grant of consent by the Board.


</p>
                            
</td>
</tr>
</table>
     </div>
     
   
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 6px;">
             </td>
         </tr>
         
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
               <b>Ques:</b>What do you mean by investment?
             </td>
         </tr>
     </table>
     
      <div id="div_hi8">
         <table border="0" cellpadding="5" cellspacing="0">
             <tr>
                 <td   align="left" valign="top"><b>Ans:</b>
                     <p class="txt4">
                     The investment means the amount of capital invested by the industry on capital works including land; machinery; and equipment. This is the gross block (without depreciation) of all fixed assets. 



</p>
                            



</td>
</tr>
</table>
     </div>
     
     
     
     
     
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 6px;">
             </td>
         </tr>
         
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
                <b>Ques:</b>Is there any prescribed form for consent application?</span>
             </td>
         </tr>
     </table>
     
      <div id="div_hi8">
         <table border="0" cellpadding="5" cellspacing="0">
             <tr>
                 <td   align="left" valign="top"><b>Ans:</b>
                     <p class="txt4">
                     Yes Sir, There are prescribed forms of application for obtaining  consent	

</p>
                            



</td>
</tr>
</table>
     </div>
     
     
    
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 6px;">
             </td>
         </tr>
         
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
                 <b>Ques:</b>Where the consent application forms are available?</span>
             </td>
         </tr>
     </table>
     
      <div id="div_hi8">
         <table border="0" cellpadding="5" cellspacing="0">
             <tr>
                 <td   align="left" valign="top"><b>Ans:</b>
                     <p class="txt4">
                     The consent application forms are available at Offices  of the Jammu & Kashmir Pollution Control Committee.


</p>
                            



</td>
</tr>
</table>
     </div>
      
     
  
<table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
             <td style="height: 5px;">
             </td>
         </tr>
         <tr>
             <td align="left" style="height: 15px;" style="width: 100%">
                  <b>Ques:</b>Whether consent renewal fee has to be paid annually?
                      </span>
             </td>
         </tr>
     </table>
      <div id="div_hide_ans1" style="display: block;">
         <table border="0" cellpadding="0" cellspacing="0">
             <tr>
             <td   align="left" valign="top"><b>Ans:</b>
             <p class="txt4">
             A web-site contains several works such as literary works, artistic works
             (photographs etc.), sound recordings, video clips, cinematograph films and broadcastings
             and computer software too. Therefore, a separate application has to be filed for
             registration of all these works.
        </td>
             </tr>
         </table>
         </div>
        
  
         
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                      <td style="height: 5px;">
                      </td>
                  </tr>
                  <tr>
                      <td align="left" style="height: 15px;" style="width: 100%">
                           <b>Ques:</b>What do you mean by Environmental Clearance?  Which type of activities/projects required Environmental Clearance?
                               </span>
                      </td>
                  </tr>
              </table>
               <div id="div_hide_ans1" style="display: block;">
                  <table border="0" cellpadding="0" cellspacing="0">
                      <tr>
                      <td   align="left" valign="top"><b>Ans:</b>
                      <p class="txt4">
                      The clearance accorded by Ministry of Environment
                      and Forests, Government of India for expansion or modernization of any
                      activity (if pollution load is to exceed the existing one) or a new
                      project listed in schedule I of the Environment Impact Assessment
                      Notification, 1994 is known as Environmental Clearance.</span></font></p>
                      <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4"><span style="mso-bidi-font-size: 13.0pt">Following
                      thirty types of activities/projects are required Environmental
                      Clearance:-</span></p>
                      <ol class="txt4">
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Nuclear
                          power and related project such as Heavy Water Plants, nuclear fuel
                          complex, rare earths.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">River
                          Valley projects including hydel power, major irrigation and their
                          combination including flood control.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Ports,
                          harbours, Airports (except minor ports and harbours).</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Petroleum
                          Refineries including crude and product pipelines.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Chemical
                          Fertilizers (Nitrogenous and phosphatic other than single super
                          phosphate).</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Pesticides
                          (Technical)</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Petrochemical
                          complexes (Both Olefinic and Aromatic) and Petro-Chemical
                          intermediates such as DMT, Caprolactam, LAB etc. and production of
                          basic plastics such as LDPE, HDPE, PP, PVC.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Bulk
                          drugs and pharmaceuticals.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Exploration
                          for oil and gas and their production, transportation and storage.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Synthetic
                          Rubber.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Asbestos
                          and Asbestos products</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Hydro
                          cyanic acid and its derivatives.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">(a)
                          <span style="mso-spacerun:yes">&nbsp;</span>Primary metallurgical
                          industries (such as production of Iron and Steel, Aluminium,
                          Copper, Zinc, Lead and Ferro Alloys).</p>
                        </li>
                      </ol>
                      <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      (b) <span style="mso-spacerun:yes">&nbsp;&nbsp;</span>Electric arc
                      furnaces (Mini Steel plants).<o:p>
                      </o:p>
                      </p>
                      <ol class="txt4">
                        <li value="14">
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Chlor-alkali
                          industry.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Integrated
                          plant complex including manufacture of resins and basic raw
                          material required in the manufacture of paints.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4" >Viscose
                          Staple fibre and filament yarn.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Storage
                          batteries integrated with manufacture of oxides of lead and lead
                          antimony alloy.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">All
                          tourism projects between 200m-500 meters of High Tide Line or at
                          locations with an elevation of more than 1000 meters with
                          investment of more than Rs. 5 Crores.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Thermal
                          Power Plants</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Mining
                          Project (major minerals) with leases more than 5 hectares.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Highway
                          Projects except projects relating to improvement work including
                          widening and strengthening of roads with marginal land acquisition
                          along the existing alignments provided it does not pass through
                          ecologically sensitive areas such as National Parks, Sanctuaries,
                          Tiger reserves, Reserve forests.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Tarred
                          Roads in Himalayas and/or Forest areas.</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Distilleries</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Raw
                          Skins and Hides</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Pulp,
                          paper and newsprint</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Dyes</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" CLASS="TXT4">Cement</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Foundries
                          (individual)</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Electroplating</p>
                        </li>
                        <li>
                          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Meta
                          amino phenol
                 </td>
                      </tr>
                  </table>
                  </div>
                 

</div>

</div>
</div>

<!--FAQ end -->



<div id="more2" class="modal fade" role="dialog">
<div class="modal-dialog"><!-- Modal content-->
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">&times;</button>
<h4 class="modal-title">Hazardous Waste Management Granted Applications </h4>
</div>
      
      <div class="modal-body">
        <p>Ques: What do you mean by Water and Air Consent? Who are required to obtain consent from Board?
        <br/>
Ans: Consent means the sanction of the authority of the Board for the discharge of the effluent (sewage or trade effluent into a stream or well or sewer or on land ) or emission of air pollutant into the atmosphere. The consent issued by Board under section 25/26 of the Water (Prevention and Control of Pollution) Act 1974 is known as water consent and under section 21 of the Air (Prevention and Control of Pollution) Act, 1981 is known as air consent,As per section 25 of the Water (Prevention and Control of Pollution) Act 1974, no person shall without the previous consent of the State Board,

   
</p>
      </div>
  


</div>

</div>
</div>


<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.bootstrap.newsbox.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.smartmenus.min.js"></script>
<script type="text/javascript"	src="js/jquery.smartmenus.bootstrap.min.js"></script>
<script type="text/javascript" src="js/swipe.js"></script>
<script type="text/javascript" src="js/jquery-scrolltofixed-min.js"></script>
<script type="text/javascript" src="js/jflickrfeed.js"></script>
<script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
<script src="js/main.js"></script>
<script type="text/javascript">
    $(function () {

		
		$(".demo2").bootstrapNews({
            newsPerPage: 4,
            autoplay: true,
			pauseOnHover: true,
			navigation: false,
            direction: 'down',
            newsTickerInterval: 2500,
            onToDo: function () {
                //console.log(this);
            }
        });

 
    });
</script>
<script type="text/javascript">
function loginForm() {
	
	document.form1.submit();
}   
</script>
<script type="text/javascript">
function registration() {
	
//	window.location.assign("https://singlewindow.jk.gov.in/")
	// hide by Deepak for Single Window registraion 
	 window.location.href = '<g:createLink controller="industryRegMaster"         action="create1" />';
	   
} 
</script>
</body>
</html>
