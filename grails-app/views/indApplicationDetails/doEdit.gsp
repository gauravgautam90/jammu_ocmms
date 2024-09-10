<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<% String cont=request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow-x:hidden; 
	overflow-y:auto;
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
span.smallfont {color:#ffffff;font-weight:bold;font-size:11px;}


-->
</style>

<g:javascript>
function hideDivIndustry10()
{   
	var radiomenu03 = document.getElementById('radiobutton30').value;
	var radiomenu31 = document.getElementById('radiobutton31').value;
	
	if (radiomenu03 == "yes") {
		document.getElementById('SelectOldIndustryType40').style.display =  'block';
		document.getElementById('SelectOldIndustryType41').style.display =  'block';
		} 
}
function hideDivIndustry11()
{   
	
	var radiomenu03 = document.getElementById('radiobutton30').value;
	var radiomenu13 = document.getElementById('radiobutton31').value;
	
	 if (radiomenu13 == "no") { 
		document.getElementById('SelectOldIndustryType40').style.display = 'none';	
		document.getElementById('SelectOldIndustryType41').style.display =  'none';
	}	
}
</g:javascript>


<g:javascript>
function hideDivIndustry101()
{   
	var radiomenu03 = document.getElementById('radiobutton301').value;
	var radiomenu31 = document.getElementById('radiobutton311').value;
	
	if (radiomenu03 == "yes") {
		document.getElementById('SelectOldIndustryType401').style.display =  'block';
		document.getElementById('SelectOldIndustryType411').style.display =  'block';
		} 
}
function hideDivIndustry111()
{   
	
	var radiomenu03 = document.getElementById('radiobutton301').value;
	var radiomenu13 = document.getElementById('radiobutton311').value;
	
	 if (radiomenu13 == "no") { 
		document.getElementById('SelectOldIndustryType401').style.display = 'none';	
		document.getElementById('SelectOldIndustryType411').style.display =  'none';
	}	
}
</g:javascript>



<script>
function calculateScale(gfa)
{
if(gfa>0 && gfa<=25){
document.getElementById("industryScale").value ="Micro"
document.getElementById("industryScale1").value ="Micro"
}
if(gfa>25 && gfa<=500){
document.getElementById("industryScale").value ="Small"
document.getElementById("industryScale1").value ="Small"

}else if(gfa>500 && gfa<=1000){
document.getElementById("industryScale").value ="Medium"
document.getElementById("industryScale1").value ="Medium"

}
else if(gfa>1000){
document.getElementById("industryScale").value ="Large"
document.getElementById("industryScale1").value ="Large"
}
}
</script>






<g:javascript>
	function updateCity(e) {
		// The response comes back as a bunch-o-JSON
		var cities = eval("(" + e.responseText + ")")	// evaluate JSON

		if (cities) {
			var rselect = document.getElementById('industryType.id')

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

var selectmenu1=document.getElementById("industryType.id").value;

        
   	 if((selectmenu1 == "8916")||(selectmenu1 == "8917")||(selectmenu1 == "8918")||(selectmenu1 == "12895")||(selectmenu1 == "12896"))
   	 {
   	 document.getElementById('selectTemp').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp').style.display = 'none';
   		 }
   }
		
	
	// This is called when the page loads to initialize city
	var zselect = document.getElementById('category.id')
	var zopt = zselect.options[zselect.selectedIndex]
	${remoteFunction(controller:"industryRegMaster", action:"ajaxGetCities", params:"'id=' + zopt.value", onComplete:"updateCity(e)")}

   
</g:javascript>
<g:javascript>

function select1()
{
var selectmenu1=document.getElementById("industryType.id")
selectmenu1.onchange=function()
 {    
 
   	 var chosenoption=this.options[this.selectedIndex]
        
   	 if((chosenoption.value == "8916")||(chosenoption.value == "8917")||(chosenoption.value == "8918")||(chosenoption.value == "12895")||(chosenoption.value == "12896"))
   	 {
   	 document.getElementById('selectTemp').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp').style.display = 'none';
   		 }
   }
} 
</g:javascript>


<script>
    
    function checkField(id)
    {
        if (id.value == "" )
        {
    
            id.value = "0";
        }
          
        
        document.getElementById("indNewCapInvt").value = eval(document.getElementById("indCapInvtLand").value)+ eval(document.getElementById("indCapInvtBuilding").value)+eval(document.getElementById("indCapInvt").value);
      
    }
       
     
    </script>
    
<g:javascript library="prototype" />
<g:javascript>
function createRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createRowFee(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFee'},'tempDoEditFee.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createRowWaterCon(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelWaterCon'},'tempDoEditWaterCon.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createRowWaterDis(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelWaterDis'},'tempDoEditWaterDis.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createEffStand(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelEffluent'},'tempDoEditEffluent.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
function createAirEmmFugitive(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFugitive'},'tempDoEditFugitive.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

function createAirEmmStack(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelStack'},'tempDoEditStack.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
function createAirEmmFuel(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFuel'},'tempDoEditFuel.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

function waterSource()
 {
       new Ajax.Updater("updateWaterSource",
          "<%=request.getContextPath()%>/indApplicationDetails/updateWaterSource",
          {method:'get', parameters: {selectedValue : '1'} }
         );
 }
</g:javascript>
<script type="text/javascript">


function Calculate()
{	
//alert("KAVIIIIIIII")

var category
	var contype;
	var conFor;
	var consent;
	var year;
	
	// Getting value of "Consent Type"
	if(document.getElementById('consentTypeY').checked==true)
		contype=document.getElementById('consentTypeY').value;
	else
		contype=document.getElementById('consentTypeN').value;

	// Getting value of "Consent For"
	
		
	year=document.getElementById('yearsApplied').value;
	
	category=document.getElementById('cat').value;
	//alert("category------"+category)
	
	if(document.getElementById('consentForY').checked==true)
		conFor=document.getElementById('consentForY').value;
	else
	{
		if(document.getElementById('consentForB').checked==true)
			conFor=document.getElementById('consentForB').value;
		else
			conFor=document.getElementById('consentForN').value;
	}

	// Getting value of Consent
	if(document.getElementById('consentY').checked==true)
		consent=document.getElementById('consentY').value;
	else
		consent=document.getElementById('consentN').value;

	// Getting value of Capital Investment
	var capitalInvestMent; 
	capitalInvestMent=document.getElementById('indCapInvt').value;
	
	
	var result;
	
	var ValidationRequired;
	ValidationRequired="/^.*(?=.*[0-9]).*$/";

	// Calculating applicable consent fee based on above selection	
			if(contype=="CTE")
			{	
	
	
	
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
    	
	    	
 }  		
    		else
    		{	
	
	
	
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
        
    }
    			
  
		var feeApp = document.getElementsByName('feeApplicable1');
		//alert("feeApp" +document.getElementsByName('feeApplicable1')+"sss "+feeApp[0].value);
		//alert("result" + result);
			if( feeApp != null){
				feeApp[0].value=result
				*((document.getElementsByName('yearsApplied')[0]).value);
				//alert("feeApp" +document.getElementsByName('feeApplicable1')+"sss "+feeApp[0].value);
			}

	return true;


}


</script>
<g:javascript>


function Calculate1() {
	
	

var category
	var contype;
	var conFor;
	var consent;
	var year;
	
	// Getting value of "Consent Type"
	if(document.getElementById('consentTypeY').checked==true)
		contype=document.getElementById('consentTypeY').value;
	else
		contype=document.getElementById('consentTypeN').value;

	// Getting value of "Consent For"
	
		
	year=document.getElementById('yearsApplied1').value;
	//alert("year-----"+year)
	if(!year){
	
	alert("Please Enter Additional Year")
	return false
	}
	
	category=document.getElementById('cat').value;
	//alert("category------22222222222222222222"+category)
	
	if(document.getElementById('consentForY').checked==true)
		conFor=document.getElementById('consentForY').value;
	else
	{
		if(document.getElementById('consentForB').checked==true)
			conFor=document.getElementById('consentForB').value;
		else
			conFor=document.getElementById('consentForN').value;
	}

	// Getting value of Consent
	if(document.getElementById('consentY').checked==true)
		consent=document.getElementById('consentY').value;
	else
		consent=document.getElementById('consentN').value;

	// Getting value of Capital Investment
	var capitalInvestMent; 
	capitalInvestMent=document.getElementById('indCapInvt').value;
	
	
	
	var result;
	
	var ValidationRequired;
	ValidationRequired="/^.*(?=.*[0-9]).*$/";

	// Calculating applicable consent fee based on above selection	
			if(contype=="CTE")
			{	
	
	
	
				if(category=="RED")
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
    	
    			
		 if(category=="ORANGE")
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
		if(category=="GREEN")
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
    		
    		
    		
				if(category=="RED")
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
    	
    			
		 if(category=="ORANGE")
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
		if(category=="GREEN")
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
    			
  
		var feeApp = document.getElementsByName('feeApplicable2');
		//alert("feeApp" +document.getElementsByName('feeApplicable2')+"sss "+feeApp[0].value);
		//alert("result" + result);
			if( feeApp != null){
				feeApp[0].value=result*year
				//*((document.getElementsByName('yearsApplied')[0]).value);
		///	alert("feeApp" +document.getElementsByName('feeApplicable2')+"sss "+feeApp[0].value);
			}

	return true;





}


function Calculate2(){
//alert("kkkkkkkkk")

var fee1= eval(document.getElementById('feeApplicable1').value);
var fee2=eval( document.getElementById('feeApplicable2').value);
//alert("fee111111"+fee1)
//alert("fee2222222"+fee2)
var feeApp = document.getElementsByName('feeApplicable');

if( feeApp != null){
				feeApp[0].value=fee1+fee2
				
			}
return true;
}
function select9()
{
var selectmenu1=document.getElementById("nearResidCol")
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
</g:javascript>
<g:javascript>

function select10()
{
var selectmenu1=document.getElementById("nearRiver")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "Yes")
   	 {
   	 document.getElementById('selectTemp10').style.display = 'block';
	 }
else{
    document.getElementById('selectTemp10').style.display = 'none';
   		 }
   }
} 
</g:javascript>
<g:javascript>
function select100()
{

	var selectmenu1=document.getElementById("nearIndEstate")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp100").style.display = 'block';
			document.getElementById("disposalSysProv").value="No";
		}
		else
		{
			document.getElementById("selectTemp100").style.display = 'none';
			document.getElementById("selectTemp2").style.display = 'none';
			document.getElementById("selectTemp3").style.display = 'none';
		}
	}
} 
</g:javascript>

<g:javascript>
function select2()
{
	var selectmenu1=document.getElementById("disposalSysProv")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp2").style.display = 'block';
			document.getElementById("utilizeSys").value="Yes";
		}
		else
		{
			document.getElementById("selectTemp2").style.display = 'none';
			document.getElementById("selectTemp3").style.display = 'none';
		}
	}
} 
</g:javascript>

<g:javascript>
function select3()
{
	var selectmenu1=document.getElementById("utilizeSys")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "No")
		{
			document.getElementById("selectTemp3").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp3").style.display = 'none';
		}
	}
} 
</g:javascript>
<g:javascript>
function select12()
{
	var selectmenu1=document.getElementById("sewage")
	selectmenu1.onchange=function()
	{    
		var chosenoption=this.options[this.selectedIndex]
		if(chosenoption.value == "Yes")
		{
			document.getElementById("selectTemp12").style.display = 'block';
		}
		else
		{
			document.getElementById("selectTemp12").style.display = 'none';
		}
	}
} 
</g:javascript>

<script language=javascript type='text/javascript'> 
function myHide(){
	
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
</head>

<body>
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
			<g:include controller="userMaster" action="showSpcbIndustryMenu"/>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr> <%	
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
                <td height="24" bgcolor="#4C8BC0">

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>


					<table width="100%" bgcolor="#4C8BC0">
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
		
		<% } %>
</td>
              </tr>
              <tr><td>
              <FONT SIZE="4" FACE="courier" COLOR=red><MARQUEE WIDTH=100% BEHAVIOR=left onmouseover="this.stop();" onmouseout="this.start();" >Any applicant knowingly giving incorrect information or suppressing information pertaining to any of the items of the application shall be liable for punishment as per provisions under the relevent Water(Prevention and Control of Pollution) Act,1974, Air(Prevention and Control of Pollution)Act,1981 and Authorization under Hazardous Wastes(Management and Handling) Rules, 1989,as amended.</MARQUEE></FONT> 
		 
              </td></tr>
              
              
              
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    
                    <br><tr>
<!-- Div area for errors-->
<td align="center" valign="top">
<span class="error"> <g:if test="${flash.message}">
<div class="message">${flash.message}</div>
</g:if>

</td>
</tr>

                   
                    <tr>
                      <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
         <div style="border":1px solid gray; width:760px; margin-bottom: 1em; padding: 10px" >
		 	
		 
		<g:form name="general" method="post" enctype="multipart/form-data" action="saveNew" >
                <input type="hidden" id='regMasId' name="regMasId" value="${industryRegMasterInstance?.id}" />
				<input type="hidden" id='indAppDetId' name="indAppDetId" value="${indApplicationDetailsInstance?.id}" /> 
				<input type="hidden" name="testVal" value="<%=testVal%>"
		
			
		<table width="760"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Industry</span></a></li>
						<li><a href="#country8"><span>Occupier</span></a></li>	
						<li><a href="#country7"><span>Enclosures</span></a></li>
						
						 <%if(indApplicationDetailsInstance.applicationFor.equals("both")) {%>					
						<li><a href="#country9"><span>Other</span></a></li>
						<li><a href="#country2"><span>Product/Cost</span></a></li>					
						<li><a href="#country4" title="Water Emission/Discharge"><span>W Emiss./Disch.</span></a></li>
					<%}
						def a4 = indApplicationDetailsInstance.indUser.category.id
			
				 if (((a4==1)||(a4==2))&& indApplicationDetailsInstance.applicationFor.equals("both")){ %>
						<li><a href="#country5"><span>HWM</span></a></li>
						 <% }
						 if(indApplicationDetailsInstance.applicationFor.equals("both")) {
						  %>	
						<li><a href="#country6"><span>Air Emission</span></a></li>
						<%}%>
						<% if(indApplicationDetailsInstance.hazardeousType=="HWM"){ %>
						
						<li><a href="#country50" title="Hazardous Wastes Management"><span>Solid Waste</span></a></li>
						<% } %>
						
						
						
						 <%if((indApplicationDetailsInstance.applicationFor.equals("stonecrusher")) || 
								 (indApplicationDetailsInstance.applicationFor.equals("hotmixplants")) ||
								 (indApplicationDetailsInstance.applicationFor.equals("stonecrusher and hotmixplants"))) {%>
						 <li><a href="#country2"><span>Product</span></a></li>	
						 <li><a href="#country12"><span>Stone Crusher/Hot mix plants</span></a></li>
						 <%}%>
						  <%if(indApplicationDetailsInstance.applicationFor.equals("dgset")) {%>
						 <li><a href="#country13"><span>D.G.Set</span></a></li>
						 <%}%>
						  <%if(indApplicationDetailsInstance.applicationFor.equals("brickkilns")) {%>
						  <li><a href="#country2"><span>Product</span></a></li>	
						 <li><a href="#country14"><span>Brick Kilns</span></a></li>
						 <%}%>
						  <%if(indApplicationDetailsInstance.applicationFor.equals("hotel")) {%>
						 <li><a href="#country15"><span>Hotel</span></a></li>
						 <%}%>
						 <li><a href="#country3"><span>Fee</span></a></li>
						
					</ol>
				  

				  </td>
				</tr>		
	    </table>
		
		
		
		
				
				
          <div class="content" id="country1" >
		  
		  
		  
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Industry/Hotel Information</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>  
				
				<tr>
					<td  width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry/Hotel Name<span style="color:red">*</span>:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="indName" type="text" value="${industryRegMasterInstance?.indName}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(industry name max 250 char)</span>
					</span></td>
				</tr> 
				
				<tr>
				<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Scale of Industry
				:</td>
				<td align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'industryScale','errors')} txt">
			 <div style="display:block; border:0;" id="selectTemp191" > 
				<input name="industryScale1" id="industryScale1" type="text" size="8" class="txt4" disabled value="${fieldValue(bean:industryRegMasterInstance,field:'industryScale')}"
					 AUTOCOMPLETE=OFF />
					<input type="hidden" name="industryScale" id="industryScale" value="${fieldValue(bean:industryRegMasterInstance,field:'industryScale')}"/>
									</div> </td>
				</tr>
			
	<!--	 <tr><td align="left" bgcolor="#A8DAF3" class="headngblue">
				Category:<span style="color:red">*</span></td>
				<td width="70%" align="left" bgcolor="#E8F6F9"	>
			<g:select   optionKey="id" optionValue="name" name="category.id" id="category.id" from="${IndCatMaster.list()}"
	        onchange="${remoteFunction( controller:'industryRegMaster', action:'ajaxGetCities', 
	            params:'\'id=\' + escape(this.value)', onComplete:'updateCity(e)')}" 
	             value="${fieldValue(bean:industryRegMasterInstance,field:'category')}">
	        </g:select></td>
	        </tr>
	         <tr><td align="left" bgcolor="#A8DAF3" class="headngblue">
				Industry Type:<span style="color:red">*</span></td>
				<td width="70%" align="left" bgcolor="#E8F6F9"	>
	    <g:select optionKey="id" optionValue="industryType" name="industryType.id" id="industryType.id"  onclick="javascript:select1()" value="${fieldValue(bean:industryRegMasterInstance,field:'industryType')}">
	   
	    </g:select>
	     <div style="display:none; border:0;"  id="selectTemp"  >
							       <input	name="indTypeOther" type="text"	value="${fieldValue(bean:industryRegMasterInstance,field:'indTypeOther')}"
									maxlength="250" size="25" AUTOCOMPLETE=OFF /><span
										class="txt4">(enter other industry type name, max 250 characters)</span>
									</div>
	    </td>
	    </tr> -->
							
	
				<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue"><span class="style6"><span class="txt style6">
<g:select class="txt4" from="${['Operational','Proposed','Closed']}" name="indStatus" id="indStatus" value="${fieldValue(bean:industryRegMasterInstance,field:'indStatus')}" > </g:select>
&nbsp;<span class="sidetxt">(e.g. operational/proposed/closed)</span></span></span></td>
</tr>


		 <%if(indApplicationDetailsInstance.applicationFor.equals("hotel")) {%>
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hotel Area:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					 <g:select  from="${['Mountainuous','Plans','Cluster','Isolated','Other']}" name="hotelArea" id ="hotelArea" value="" class="txt4"></g:select>
					 </span></span></td>
				</tr>        
				<%}%>
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Commisioning Year:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" name="dateOfComm" value="${industryRegMasterInstance?.dateOfComm}" />
					&nbsp;<span class="sidetxt">(e.g. 2002)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Registration/ License/DIC No.:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indRegNum" name="indRegNum" value="${fieldValue(bean:industryRegMasterInstance,field:'indRegNum')}"/>
					&nbsp;<span class="sidetxt">(reg/license/dic no of industry)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvt" name="indCapInvt"  onblur="calculateScale(this.value);" value="${fieldValue(bean:industryRegMasterInstance,field:'indCapInvt')}" />
					&nbsp;<span class="sidetxt">(capital investment of plant & machinery)</span></span></td>
				</tr>
				<!--<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment of Land<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvtLand" name="indCapInvtLand" onblur="checkField(this)" value="" />
					&nbsp;<span class="sidetxt">(capital investment of land)</span></span></td>
				</tr>
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment of Building<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvtBuilding" name="indCapInvtBuilding" onblur="checkField(this)" value="" />
					&nbsp;<span class="sidetxt">(capital investment of building)</span></span></td>
				</tr>
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Investment</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" readonly class="txt4" id="indNewCapInvt" name="indNewCapInvt" onblur="checkField(this)" value="" />
					&nbsp;<span class="sidetxt">(capital investment)</span></span></td>
				</tr> 
				-->  
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="indAddress" name="indAddress" value="${fieldValue(bean:industryRegMasterInstance,field:'indAddress')}"/>
					&nbsp;<span class="sidetxt">(address where industry is established)</span></span></td>
				</tr>        
				 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Village/City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="indCity" name="indCity" value="${fieldValue(bean:industryRegMasterInstance,field:'indCity')}"/>
					&nbsp;<span class="sidetxt">(city industry address)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPin" name="indPin" value="${fieldValue(bean:industryRegMasterInstance,field:'indPin')}"/>
					&nbsp;<span class="sidetxt">(pin of address locality)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPhoneCode" name="indPhoneCode" value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneCode')}"/>
					&nbsp;<span class="sidetxt">(std code of phone no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPhoneNo" name="indPhoneNo" value="${fieldValue(bean:industryRegMasterInstance,field:'indPhoneNo')}"/>
					&nbsp;<span class="sidetxt">(phone no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indFaxCode" name="indFaxCode" value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxCode')}"/>
					&nbsp;<span class="sidetxt">(std code of fax no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indFaxNo" name="indFaxNo" value="${fieldValue(bean:industryRegMasterInstance,field:'indFaxNo')}"/>
					&nbsp;<span class="sidetxt">(fax no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-Mail Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="indEmail" name="indEmail" value="${fieldValue(bean:industryRegMasterInstance,field:'indEmail')}"/>
					&nbsp;<span class="sidetxt">(e.g. info@abc.com)</span></span></td>
				</tr>
				<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Expected Date of Production :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'expDate','errors')} txt">
																	  <calendar:datePicker name="expDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
																</td>
															</tr>
															
																<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Shifts in Industry :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'shiftsIndustry','errors')} txt">
																<g:select  from="${['General Shift','Two Shifts','Round the Clock']}" name="shiftsIndustry" value="${fieldValue(bean:industryRegMasterInstance,field:'shiftsIndustry')}" class="txt4"></g:select></td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Monitoring is being :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:monitoring,field:'monitoring','errors')} txt">
																<g:select  from="${['Done','Proposed']}" name="monitoring" value="${fieldValue(bean:industryRegMasterInstance,field:'shiftsIndustry')}" class="txt4"></g:select></td>
															</tr>
															
															
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Total number of Workers:</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'expNoEmp','errors')} txt">
																<input name="expNoEmp" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'expNoEmp')}"
																	size="20" AUTOCOMPLETE=OFF /></td>
															</tr>
						
						
						                                     <tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Total number of office Staff:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'noOfEmp','errors')} txt">
																<input name="noOfEmp" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'noOfEmp')}"
																	size="20" AUTOCOMPLETE=OFF /></td>
															</tr>
						
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																What monitoring arrangement is currently there or proposed :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'waterMonitoring','errors')} txt">
																<input name="waterMonitoring" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasterInstance,field:'waterMonitoring')}"
																	size="20" AUTOCOMPLETE=OFF /><span class="sidetxt">(maximum 100 characters)</span></td>
															</tr>
															<tr>
																<td align="left" bgcolor="#A8DAF3" class="headngblue">Site
																Area:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasterInstance,field:'siteArea','errors')} txt"><span
																	class="txt style6"> <select name="siteArea"
																	class="txt4">

																	<option value="Industrial Area">Industrial Area</option>
																	<option value="Outside Industrial Area">Outside Industrial Area</option>
																	

																</select></span></td>
															</tr>
				</table>	  
		
					  
			</td></tr>
			</table>		  
					                  
                     

				
          
          </div>
				
		<div class="content" id="country8" >
		
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Occupiers Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>  
				
				<tr>
				<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occName" name="occName" value="${fieldValue(bean:industryRegMasterInstance,field:'occName')}"/>&nbsp;<span class="sidetxt">(name of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occDesignation" name="occDesignation" value="${fieldValue(bean:industryRegMasterInstance,field:'occDesignation')}"/>&nbsp;<span class="sidetxt">(designation of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Residential Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occAddress" name="occAddress" value="${fieldValue(bean:industryRegMasterInstance,field:'occAddress')}"/>&nbsp;<span class="sidetxt">(address of occupant)</span></span></td>
				</tr>   
				
				<tr>
																	<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status Of Applicant: </td>
																<td width="70%" align="left" bgcolor="#E8F6F9" class="value ${hasErrors(bean:industryRegMasterInstance,field:'statusOfAppl','errors')} txt">
																<g:select  from="${['Individual','Proprietory concern','Partnership firm','Joint Family Concern','Private Limited company','Public Limited Company','State Government','Central Government','Union Territory','Foreign Company','Any other Associate or Body']}" name="statusOfAppl" value="${industryRegMasterInstance.statusOfAppl}" class="txt4"></g:select><span class="txt4"></span></td>
															</tr>
				
				<tr align="center" bgcolor="#F4F7FB">
															<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Directors/Partner/Proprietor with Contact Details
															</td>
															<td align="left" bgcolor="#E8F6F9"  class="txt">
																<textarea	name="nameAddressPartners" rows="5" cols="40"
																	maxlength="1000" class="txt4">${fieldValue(bean:industryRegMasterInstance,field:'nameAddressPartners')}</textarea>
															</td>
															
															</tr>	
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Village/City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occCity" name="occCity" value="${fieldValue(bean:industryRegMasterInstance,field:'occCity')}"/>
					&nbsp;<span class="sidetxt">(city where occupant live)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occPin" name="occPin" value="${fieldValue(bean:industryRegMasterInstance,field:'occPin')}"/>&nbsp;<span class="sidetxt">(pin of address locality)</span>
					</span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occPhoneCode" name="occPhoneCode" value="${fieldValue(bean:industryRegMasterInstance,field:'occPhoneCode')}"/>
					&nbsp;<span class="sidetxt">(std code of phone no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="occPhoneNo" name="occPhoneNo" value="${fieldValue(bean:industryRegMasterInstance,field:'occPhoneNo')}"/>
					&nbsp;<span class="sidetxt">(phone no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occFaxCode" name="occFaxCode" value="${fieldValue(bean:industryRegMasterInstance,field:'occFaxCode')}"/>
					&nbsp;<span class="sidetxt">(std code of fax no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occFaxNo" name="occFaxNo" value="${fieldValue(bean:industryRegMasterInstance,field:'occFaxNo')}"/>
					&nbsp;<span class="sidetxt">(fax no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile No:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="occMobile" name="occMobile" value="${fieldValue(bean:industryRegMasterInstance,field:'occMobile')}"/>
					&nbsp;<span class="sidetxt">(mobile no upto 12 characters with country code)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occEmail" name="occEmail" value="${fieldValue(bean:industryRegMasterInstance,field:'occEmail')}"/>
					&nbsp;<span class="sidetxt">(e.g. info@abc.com)</span></span></td>
				</tr>        
				         
					
			
				</table>	  
		
					  
			</td></tr>
			</table>				
           <br/>
          </div>

		      <div class="content" id="country9" >
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">
						Other Details
						 </span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>  
				<%	
				 if ((a4==1)||(a4==2)){ %>
				<tr>
					<td  width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Equipments To Which Separate Meters Are Installed For Recording Consumption Of Electric Energy:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="equipWithSepMeters" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'equipWithSepMeters')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter pollution control name, max 250)</span>
					</span></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Equipments Connected To D.G.Set:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="equipDGSet" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'equipDGSet')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(during normal failure, max 250)</span>
					</span></td>
				</tr>        
					  
				<tr>
					<td align="left" bgcolor="#A8DAF3" class="headngblue">Tree Plantation/Green Belt Development(in hectares):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="treePlantDev" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'treePlantDev')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter area in hectares)</span>
					</span></td>													
				</tr>
	
				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Details Of Schemes For Waste Minimization/Resource Recovery/Recycling Implementation:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="wasteMinDetail" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'wasteMinDetail')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter scheme detail, max 250)</span>
					</span></td>		
  				</tr>
  				
  				<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Industry Comes Under Public Hearing:</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue">
							  <g:select class="txt4" from="${['Yes','No']}" name="underPubHearing" id="underPubHearing" value="${fieldValue(bean:industryRegMasterInstance,field:'underPubHearing')}" ></g:select>
							</td>
				 </tr>	
				 
				 
				
				 <%	
				 } %>
  					<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Site Is Located Near River Bank/Water Bodies:</td>
							      <td bgcolor="#E8F6F9" align="left" class="headngblue">
										 <g:select class="txt4" from="${['No','Yes']}" name="nearRiver" id="nearRiver" onclick="javascript:select10()" value="${fieldValue(bean:industryRegMasterInstance,field:'nearRiver')}" ></g:select>
												
													</td>							     
														     
														      
													      </tr>
													      
						 
										<tr>
										<td bgcolor="#E8F6F9" colspan="2">
										<div style="display:none; border:0;"  id="selectTemp10" >
										<table cellpadding="0" cellspacing="0" >
										<tr>
										   <td align="center">
												(Name)
												<br>
												<input	name="riverName" id="riverName"  type="text"  value="${fieldValue(bean:industryRegMasterInstance,field:'riverName')}"  class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="25"/>
													
											</td>
											<td align="center" >
												(Distance in meters)
												<br>
												<input	name="riverDist" id="riverDist" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'riverDist')}" maxlength="20"	AUTOCOMPLETE=OFF size="25"/>
													
											</td>
											
											</tr></table>
																	 </div>
										         </td>          
										    </tr>		
										  				<tr class="headngblue" bgcolor="#A8DAF3">
																	  <td width="30%" align="left" >Site Is Located Near Residential Colony:</td>
																	      <td bgcolor="#E8F6F9" align="left" class="headngblue">
															
															<g:select class="txt4" from="${['Yes','No']}" name="nearResidCol" id="nearResidCol"   onclick="javascript:select9()"  value="${fieldValue(bean:industryRegMasterInstance,field:'nearResidCol')}" ></g:select>
										
																</td>							     
														     
														      
													      </tr>
													      
						 
<tr>
<td bgcolor="#E8F6F9" colspan="2">
<div style="display:none; border:0;"  id="selectTemp9" >
<table cellpadding="0" cellspacing="0" >
<tr>
   <td align="center">
		(Population)
		<br>
		<input	name="colPopulation" id="colPopulation"  type="text"  value="${fieldValue(bean:industryRegMasterInstance,field:'colPopulation')}"  class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center" >
		(Location)
		<br>
		<input	name="colLocation" id="colLocation" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'colLocation')}" maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center">
		(Distance in Meters)
		
		<br>
		<input	name="colDistance" id="colDistance"  type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'colDistance')}" 	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	
	</tr></table>
							 </div>
         </td>          
    </tr>
    
    <tr class="headngblue" bgcolor="#A8DAF3">
							  <td  align="left" >Is Site Located Near Industrial Estate:</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue">
								<g:select class="txt4" from="${['No','Yes']}" name="nearIndEstate" id="nearIndEstate"  onclick="javascript:select100()"  value="${fieldValue(bean:industryRegMasterInstance,field:'nearIndEstate')}" ></g:select>
										  
							  
							 
							</td>
				</tr>
<!--==============================================================================-->				
			<tr class="headngblue" bgcolor="#A8DAF3">
				 <td colspan=2>
				 <div style="display:none; border:0;"  id="selectTemp100"  >
					<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr class="headngblue" bgcolor="#A8DAF3">				 
						  <td width="35%" align="left" >Whether Collection, Treatment & Disposal System Provided:</td>
						  <td bgcolor="#E8F6F9" align="left" class="headngblue">
						<g:select class="txt4" from="${['No','Yes']}" name="disposalSysProv" id="disposalSysProv" onclick="javascript:select2()"  value="${fieldValue(bean:industryRegMasterInstance,field:'disposalSysProv')}" ></g:select>
								
						 
						 </td>
					</tr></table>
				</div></td>
			</tr>
								
			<tr class="headngblue" bgcolor="#A8DAF3">
				 <td colspan=2>
				 <div style="display:none; border:0;"  id="selectTemp2"  >
					<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr class="headngblue" bgcolor="#A8DAF3">				 
						  <td width="35%" align="left" >Will Applicant Utilize The System:</td>
						  <td bgcolor="#E8F6F9" align="left" class="headngblue">
						 
						 <g:select class="txt4" from="${['Yes','No']}" name="utilizeSys" id="utilizeSys"  onclick="javascript:select3()"  value="${fieldValue(bean:industryRegMasterInstance,field:'utilizeSys')}" ></g:select>
						
						 
						 </td>
					</tr></table>
				</div></td>
			</tr>
			
			<tr class="headngblue" bgcolor="#A8DAF3">
				 <td colspan=2>
				 <div style="display:none; border:0;"  id="selectTemp3"  >
					<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr class="headngblue" bgcolor="#A8DAF3">				 
						  <td width="35%" align="left" >Details Of Proposal:</td>
						  <td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="proposalDetails" type="text" value="${industryRegMasterInstance.proposalDetails}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter detalis of the proposal, max 250)</span>
					</span></td>
					</tr></table>
				</div></td>
			</tr>
    
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Total Plot Area:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="totalPlotArea" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'totalPlotArea')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(in square meter)</span>
					</span></td>		
  				</tr>
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Build-up Area:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="plotArea" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'plotArea')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(in square meter)</span>
					</span></td>		
  				</tr>
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Area used for Treated Sewage/Trade Effluent:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="builtUpArea" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'builtUpArea')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(for treated sewage/trade effluent area in square meter)</span>
					</span></td>		
  				</tr>	
  				
  				<%	
				 if ((a4==1)||(a4==2)){ %>
				 
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Total Project Cost (in Rs.):</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="totalProjectCost" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'totalProjectCost')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter total project cost)</span>
					</span></td>		
  				</tr>	
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Total Capital Inv. Proposed on Pollution/Env. Protection (in %):</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="pollutionMonitoringCost" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'pollutionMonitoringCost')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(calculate on the basis of total investment of industry)</span>
					</span></td>		
  				</tr>	
  				
  					<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Are sewage & trade effluents mixed together ?:</td>
							      <td bgcolor="#E8F6F9" align="left" class="headngblue">
									 <g:select class="txt4" from="${['No','Yes']}" name="sewage" id="sewage"  onclick="javascript:select12()"  value="${fieldValue(bean:industryRegMasterInstance,field:'sewage')}" ></g:select>
																			
													</td>							     
														     
														      
													      </tr>
													      
						 
										
						<tr class="headngblue" bgcolor="#A8DAF3">
				 <td colspan=2>
				 <div style="display:none; border:0;"  id="selectTemp12"  >
					<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr class="headngblue" bgcolor="#A8DAF3">				 
						  <td width="35%" align="left" >At which state ?:</td>
						  <td bgcolor="#E8F6F9" align="left" class="headngblue">
						 <g:select class="txt4" from="${['Before Treatment','After Treatment','Intermittently']}" name="sewageState" id="sewageState"   value="${fieldValue(bean:industryRegMasterInstance,field:'sewageState')}" ></g:select>
									
						
						 </td>
					</tr></table>
				</div></td>
			</tr>
									
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Capacity of Treated Effluent :</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="treatedEffCapacity" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'treatedEffCapacity')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter sump, guard, pond if any)</span>
					</span></td>		
  				</tr>
  				<tr align="center" bgcolor="lightgrey" rowspan="2">
				<td width="30%" align="center" valign="middle" colspan="2"
					class="headngblue">Non-Hazardeous Solid Waste Details<span style="color:red"></span></td>
				
			</tr>
			
			<tr>
<td bgcolor="#E8F6F9" colspan="2">
<table cellpadding="0" cellspacing="0" >
<tr>
   <td align="center">
		(Name)
		<br>
		<input	name="nonHwmProdName" id="nonHwmProdName"  type="text"  value="${fieldValue(bean:industryRegMasterInstance,field:'nonHwmProdName')}"  class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center" >
		(Area of Land)
		<br>
		<input	name="landArea" id="landArea" type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'landArea')}" maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center">
		(Capacity)
		
		<br>
		<input	name="prodCapacity" id="prodCapacity"  type="text" class="txt4" value="${fieldValue(bean:industryRegMasterInstance,field:'prodCapacity')}" 	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	
	</tr></table>
		
         </td>          
    </tr>
	<%} %>		
			</table>	  
			</td></tr>
			</table>		  
	  

          </div>
			
          <div class="content" id="country2">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Product/Power Consumption Details</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
				<tr bgcolor="#A8DAF3">
					<td width="70%" align="center" valign="middle"  class="headngblue">Product Details</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popProductDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popProductDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popProductDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a></td>
				</tr> 
			
				 <%
				 	def a2 = indApplicationDetailsInstance.indUser.category.id
			
				 if(indApplicationDetailsInstance.applicationFor.equals("both")&&((a2==1)||(a2==2))) 
				 {%>
				<tr>
					<td width="70%" align="center" valign="middle"  class="headngblue">Estimated Cost Details</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEstimetedDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEstimetedDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEstimetedDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a></td>
				</tr> 
					<%}%>
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
          
          
          <div class="content" id="country50">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Hazardous Wastes</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			
			<tr bgcolor="#A8DAF3">
					<td width="70%" align="left" valign="middle"  class="headngblue">Activity/Hazardous Waste Generation Details</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
			</tr> 
	
	
		
 	<tr bgcolor="#A8DAF3">
					<td width="70%" align="left" valign="middle"  class="headngblue">Mode of storage</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoreModeAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Add</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoreModeView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoreModeEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
	</tr>
	
	<tr bgcolor="#A8DAF3">
	<td width="70%" align="left" valign="middle"  class="headngblue">Quantity of Hazardous waste disposed</td>
	<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popQuantHazAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Add</a></td>
	<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popQuantHazView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</a></td>
	<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popQuantHazEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
	
<tr bgcolor="#A8DAF3">
<td width="70%" align="left" valign="middle"  class="headngblue">Hazardous substances used</td>
<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazsubAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Add</a></td>
<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazsubView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</a></td>
<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazsubEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>
	


<tr bgcolor="#A8DAF3">
<td width="70%" align="left" valign="middle"  class="headngblue"> Hazardous waste is being produced</td>
<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazwasteAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Add</a></td>
<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazwasteView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</a></td>
<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazwasteEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
</tr>

	<table width="100%"  border="0" align="left" cellpadding="" cellspacing="" class="tblbdr">
	
	
	<tr class="headngblue txt4" >
	<td align="left" bgcolor="#A8DAF3">Total cost on pollution control (in Rupees):</td>
		<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
	  <input name="totalCostPoll" type="text" value="${fieldValue(bean:industryRegMasterInstance,field:'totalCostPoll')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt"></span>
	</span></td>		
	</tr>
	
	
	
	<table width="100%"  border="0" align="left" cellpadding="" cellspacing="" class="tblbdr">
	
	<tr bgcolor="#F4F7FB" class="headngblue">
	        <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" width="70%">Whether the unit is generating hazardous waste as defined in the Hazardous Waste(Management and handling)Rules, 1989, as amended.:</td>
			<td align="left" bgcolor="#E8F6F9" width="30%">
								<g:radio name="possibilityOfRecovery" id="radiobutton30" value="yes" onclick="javascript:hideDivIndustry10();" />Yes
								<g:radio  name="possibilityOfRecovery" id="radiobutton31" value="no" checked="true" onclick="javascript:hideDivIndustry11();"/>No </td>
		
	</tr>
	
	 

<tr bgcolor="#F4F7FB" class="headngblue">
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" width="70%"> Present treatment of hazardous Waste, if any:</td>
<td align="left" bgcolor="#E8F6F9" width="30%">
					<g:radio name="present" id="radiobutton301" value="yes" onclick="javascript:hideDivIndustry101();" />Yes
					<g:radio  name="present" id="radiobutton311" value="no" checked="true" onclick="javascript:hideDivIndustry111();"/>No </td>

</tr>

<tr>
<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" width="70%"><div id="SelectOldIndustryType401" style="display:none"> If yes, give type and capacity of treatment units:</div></td>
<td align="left" bgcolor="#E8F6F9"  class="txt">
<div id="SelectOldIndustryType411"  style="display:none"><textarea	name="presentdetails" rows="5" cols="40"
	maxlength="1000" class="txt4">${fieldValue(bean:industryRegMasterInstance,field:'presentdetails')}</textarea>
</td>

	
	</table>
	
	
	
	
	<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    
			
</table>
	
	
	
	
	
	 		
				
		
		  </table>
			</td></tr>
			</table>		
		  
		  
		<hr>
           <br>
			
          </div>
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
		  <div class="content" id="country3">
		  
		   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Fee Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr> 
				<input type="hidden" name="cat" id ="cat" value="${industryRegMasterInstance?.category}"/>		
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.category}</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment (In Lakhs):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${industryRegMasterInstance?.indCapInvt}</td>
				</tr> 
				<%if(indApplicationDetailsInstance.certificateFor.equals("new")){%>
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Year<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input name="yearsApplied" id="yearsApplied" type="text" class="txt4" size="10" value="" />
					
					
					&nbsp;<span class="sidetxt">(Enter no of yrs)</span></span></td>
					<input name="yearsApplied1" id="yearsApplied1" type="hidden" class="txt4" size="10" value="" />
					<input name="feeApplicable" id="feeApplicable" type="hidden" class="txt4" size="10" value="" />
					<input name="feeApplicable2" id="feeApplicable2" type="hidden" class="txt4" size="10" value="" />
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable (In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/><input name="feeApplicable1" id="feeApplicable1" type="text" class="txt4" size="10" value="${intTest1}" />
					 <%if(indApplicationDetailsInstance.applicationFor.equals("both") || indApplicationDetailsInstance.applicationFor.equals("stonecrusher and hotmixplants")|| indApplicationDetailsInstance.applicationFor.equals("brickkilns") || indApplicationDetailsInstance.applicationFor.equals("hotmixplants") || indApplicationDetailsInstance.applicationFor.equals("stonecrusher")) {%>	
					<a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
					&nbsp;<span class="sidetxt">(Click to calculate fee)</span>
					 <%}else {%>
					 <a href="<%=cont%>/SPCB_DOCUMENTS/Fee Structure for DG Set and Hotel.pdf" target="_blank" class="bulletinside">	
					 &nbsp;<span class="sidetxt">(Click to view fee for D.G.Set/Hotel/Restaurent)</span>
					  <%}%>	
					</span></td>
				</tr> 
				
				
				
				<%}else if(indApplicationDetailsInstance.certificateFor.equals("reNew") || indApplicationDetailsInstance.certificateFor.equals("expan") ||indApplicationDetailsInstance.certificateFor.equals("Modern") ){%>
				
				
				
				
				</tr> 
					<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Renwal Years :<span style="color:red"></span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input name="yearsApplied1" id="yearsApplied1" type="text" class="txt4" size="10"  />
					
					
					&nbsp;<span class="sidetxt">(Enter no of yrs)</span></span></td>
				</tr> 
				
			<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable renewal Year(In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/><input name="feeApplicable2" id="feeApplicable2" type="text" class="txt4" size="10" value="${intTest2}" />
					 <%if(indApplicationDetailsInstance.applicationFor.equals("both")) {%>	
					<a href="javascript:{}" onclick="return Calculate1();"  class="bulletinside"><b>Calculate</b></a>
					&nbsp;<span class="sidetxt">(Click to calculate fee)</span>
					 <%}else {%>
					 <a href="<%=cont%>/SPCB_DOCUMENTS/Fee Structure for DG Set and Hotel.pdf" target="_blank" class="bulletinside">	
					 &nbsp;<span class="sidetxt">(Click to view fee for D.G.Set/Hotel/Restaurent)</span>
					  <%}%>	
					</span></td>
				</tr> 
				<%}%>
				<!-- <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Notifications/Rules Applied </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hazardous Waste Rule 1989</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">200.00</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Environment Clearence Rule </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">500.00</td>
				</tr> --> 
				<!--  
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Outstanding dues from Industry (In Rupees):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">0.00</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Outstanding amount with Board (In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">0.00</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Fee Applied (In Rupees)</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input name="totalApplied" type="text" readonly class="txt4" value="16450" size="8" />
					&nbsp;<span class="sidetxt">(DD of this amount)</span></span></td>
				</tr> 
				-->
				<!-- Added by deepak -->
				<%if(testVal=="true"){%>
				<tr>
				<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Scrutiny Reply<span style="color:red">*</span>: </td>
				<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
				<textarea name="scrutinyReply" rows="5" cols="45" id="scrutinyReply" maxlength="200" class="txt4"></textarea></td>
				   
			</tr>
				<%}else{%>
				<%}%>
				
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<!--<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr> -->
					</table>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<!--<tr>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeOtherDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > Delete </a></td>					
					</tr> -->
					</table>
					</td>
				</tr> 
				
				
				
				
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
      		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  Please enter number of year you are applying consent for. To enter the DD/Cheque details, use the link as follows:
			   <br> click "Add" add details, "View" to view details and "Delete" link to delete details. <br>
				To update the details, first delete you want to edit and then add new one.
		</div>
		<hr>    
          </div>
		  

		  
		  
		  <div class="content" id="country4">
		  
		
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Water Emission/Discharge</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			<%
			def a = indApplicationDetailsInstance.indUser.category.id
			
			
			if(a==4)
			{
			
			%>
			
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Water Usage Detail</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterUsageDetailAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterUsageDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterUsageDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Waste Water Discharge</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteDischargeAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteDischargeView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteDischargeEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr bgcolor="#A8DAF3">
						<td   align="center" valign="middle"  class="headngblue">Solid Wastes Generation Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
				</tr> 
				
			<%}
			else
			{
			
			%>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Source of Water, Use and Consumption Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr  bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Waste Water Treatment Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterTreatmentAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=900,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterTreatmentView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=900,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterTreatmentEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=900,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Waste Water Discharge</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteGenAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteGenView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterWasteGenEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr bgcolor="#A8DAF3">
						<td   align="center" valign="middle"  class="headngblue">Solid Wastes Generation Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=750,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSolidWasteEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=700,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
				</tr> 
			<%}
			
			%>
			</table>
			
	</td></tr>
</table>

           <br/> 

          
  		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There are three sections under W Emiss./Disch. Please fill all the details pertaining to W Emiss./Disch. To enter the details, use the links as follows:<>
			  &nbsp; 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the details, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>           
          </div>
 <div class="content" id="country5">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Hazardous Waste Details</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
				<tr bgcolor="#A8DAF3">
					<td width="70%" align="center" valign="middle"  class="headngblue">Activity/Hazardous Waste Generation Details</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</span></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardActivityGenDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete</a></td>
				</tr> 
			
				<tr>
					<td width="70%" align="center" valign="middle"  class="headngblue">Storage/Disposal Details</td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStorageDisposalDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Add</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStorageDisposalDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View</a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStorageDisposalDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
				</tr> 
				<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Hazardous Chemical Details</td>
					
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardousChemicalAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardousChemicalView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
						<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHazardousChemicalEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
					
			</tr>
	
				
				
		  </table>
			</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the Hazardous Waste details</li>
				<li>click "View" link to view the Hazardous Waste details</li>
				<li>click "Delete" link to delete the Hazardous Waste details</li>
				<li>To update the Hazardous Waste details, first delete the Hazardous Waste details you want to edit and then add new one.</li>
			  </ul>
		      </div>
				<hr>
		           <br/>
      </div>
		  
	
		    
		  <div class="content" id="country6">
		
             <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Air Emission</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			<%
			
			def a1 = indApplicationDetailsInstance.indUser.category.id
			if(a1==4)
			{
			
			%>
			
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Boiler Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBoilerDetailAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBoilerDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBoilerDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			  
			  
			  <tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Furnace Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFurnaceDetailAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFurnaceDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFurnaceDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr >				
					
					<td  align="center" valign="middle"  class="headngblue">Miscellaneous Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popMiscelleneousAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Add</a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popMiscellaneousView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a></td>
					<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popMiscellaneousEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >Delete</a></td>
						  </tr>
							</table>
					</td>
			</tr>
			
			
			
			<%}else{%>
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Stack Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Flue Gas Emission Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFlueEmmision/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFlueEmmisionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFlueEmmisionEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<!--
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Fugitive Emission</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFugitiveEmmision/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFugitiveEmmisionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirFugitiveEmmisionEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
		
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Ambient Air Quality Standards</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAmbientAirStandardAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAmbientAirStandardView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAmbientAirStandardDelete/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
				
			<tr>
					<td   align="center" valign="middle"  class="headngblue">Air Pollution Control Equipment details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackEquipmentAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackEquipmentView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirStackEquipmentEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			-->
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Air Miscellaneous Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirMiscDetail/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirMiscDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popAirMiscDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  <%}%>
			</table>
			
	</td></tr>
</table>	
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There are four sections under Air Emission. Please fill all the details pertaining to Air Emission. To enter the details, use the links as follows:
			  &nbsp;<ul> 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the details, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>
		  
           <br/>
        
          </div>
		  
		  
		  
		  <div class="content" id="country7">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Enclosures Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<!-- <td colspan="4"  align="center" valign="middle"  class="headngblue">Do You Want To Submit Enclosures Manually ? &nbsp; &nbsp; &nbsp; <input type="radio" name="doc" id="consent" onclick="${remoteFunction(controller:'indApplicationDetails', action:'docSel',update:'docPanel', params:'\'cont=\' + this.value' )}" value="yes"  checked="checked" />Yes &nbsp;&nbsp;<input type="radio" name="doc" id="consent" onclick="${remoteFunction(controller:'indApplicationDetails', action:'docSel',update:'docPanel', params:'\'cont=\' + this.value' )}" value="no" />No</td>-->
				<!--<td colspan="4"  align="center" valign="middle"  class="headngblue">Do You Want To Submit Enclosures Manually ? &nbsp; &nbsp; &nbsp; <input onclick="javascript:hidediv();" type="radio" name="doc" id="consent"  value="yes"   />Yes &nbsp;&nbsp;<input type="radio" name="doc" id="consent"  value="no" onclick="javascript:showdiv();" checked="checked" />No</td>-->
				</tr> 
				<tr>
				<td colspan="4"><div id="hideShow">
					<table width="100%" cellpadding="0" cellspacing="0">
				<tr bgcolor="#A8DAF3">
					<td width="35%" align="center" class="headngblue" valign="top">Upload Required Enclosures</td>
					<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popUploadDoc/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=500,HEIGHT=500,scrollbars=1,resizable=yes');" > Upload </a></td>
				</tr> 
				</table>
				</td>
				</tr>
				</div>
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  	   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  Please select "Yes" if you want to send the documents By Post/ By Hand and "No" to upload the required enclosures online.<br>For Online Enclosures Upload:
			  &nbsp;<ul> 
				<li>Click link "Upload" to upload the enclosures</li>
				<li>Click "Browse" to select the enclosures</li>
				<li>You can select multiple documents at the same time</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Click "Save" button to upload the enclosures</li>
				<li>Message "Enclosures successfully uploaded" will be displayed</li>
			  </ul>
		</div>
		<hr>
           <br/>
          </div>
		  		  
		  <div class="content" id="country13">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">D.G.Set Details</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
				<tr>
					<td   align="center" valign="middle"  class="headngblue">D.G. Set Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGsetAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGsetView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGsetEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">D.G. Set Emission Source Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGSourceAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGSourceView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGSourceEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			<tr>
					<td   align="center" valign="middle"  class="headngblue">D.G. Set Parameter Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGParameterAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGParameterView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popDGParameterEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
	
				
				
		  </table>
			</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the D.G.Set details</li>
				<li>click "View" link to view the D.G.Set details</li>
				<li>click "Delete" link to delete the D.G.Set details</li>
				<li>To update the D.G.Set details, first delete the D.G.Set details you want to edit and then add new one.</li>
			  </ul>
		      </div>
				<hr>
		           <br/>
      </div>
		  
<!--=====================================================================================
========================================stone crusher==================================
=======================================================================================
-->	
	
	<div class="content" id="country12">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Stone Crusher/Hot mix plants Details</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Stone Crusher/Hot mix plants Siting Criteria Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneSittingCriteriaAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneSittingCriteriaView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneSittingCriteriaEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Stone Crusher/Hot mix plants Pollution Control Devices Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneCrusherControlDevicesAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneCrusherControlDevicesView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popStoneCrusherControlDevicesEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr>
					<td   align="center" valign="middle"  class="headngblue">NOC Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popNocAuthorityAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popNocAuthorityView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popNocAuthorityEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
					 <tr  bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Water Source Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			
			<tr>
					<td   align="center" valign="middle"  class="headngblue">Water Consumption Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
		  </table>
			</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the Stone Crusher/Hot mix plants details</li>
				<li>click "View" link to view the Stone Crusher/Hot mix plants details</li>
				<li>click "Delete" link to delete the Stone Crusher/Hot mix plants details</li>
				<li>To update the Stone Crusher/Hot mix plants details, first delete the Stone Crusher/Hot mix plants details you want to edit and then add new one.</li>
			  </ul>
		      </div>
				<hr>
		           <br/>
      </div>
	
	
<!--=====================================================================================
========================================brick kiln==================================
=======================================================================================
-->	
	
	<div class="content" id="country14">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Brick Kiln Details</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Brick Siting Criteria Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickSittingCriteriaAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickSittingCriteriaView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickSittingCriteriaEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Brick Kilns Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickKilnAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickKilnView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popBrickKilnEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			 <tr >
					<td   align="center" valign="middle"  class="headngblue">Water Source Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Water Consumption Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterConsumptionDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
				
		  </table>
			</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the Brick Kiln details</li>
				<li>click "View" link to view the Brick Kiln details</li>
				<li>click "Delete" link to delete the Brick Kiln details</li>
				<li>To update the Brick Kiln details, first delete the Brick Kiln details you want to edit and then add new one.</li>
			  </ul>
		      </div>
				<hr>
		           <br/>
      </div>
	
	
<!--==========================================================================-->	
		  	<div class="content" id="country15">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
		
			<tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Hotel/Restaurant Details</span></td>
					<td width="30%" colspan="3" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Hotel/Restaurant General Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelOtherDetailAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelOtherDetailView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelOtherDetailEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Hotel/Restaurant Facility Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelFacilityAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelFacilityView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelFacilityEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			  
			
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Hotel/Restaurant Waste Emmission Details </td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWasteEmissionAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWasteEmissionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWasteEmissionEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=500,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			 	 <tr >
					<td   align="center" valign="middle"  class="headngblue">Water Source Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popWaterSourceDetailsEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
				<tr  bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Water Consumption Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWaterConsumptionAdd/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWaterConsumptionView/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popHotelWaterConsumptionEdit/<%=indApplicationDetailsInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
		  </table>
			</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the Hotel/Restaurant details</li>
				<li>click "View" link to view the Hotel/Restaurant details</li>
				<li>click "Delete" link to delete the Hotel/Restaurant details</li>
				<li>To update the Hotel/Restaurant details, first delete the Hotel/Restaurant details you want to edit and then add new one.</li>
			  </ul>
		      </div>
				<hr>
		           <br/>
      </div>
	
		  
<!--		  <table width="100%" align="center">
				<tr>
				<td align="center" class="txt4">Do You Want To <input name="appStatus" id="appStatus" type="radio" value="completed" />  <span class="style3">Submit Application to JKSPCB</span> &nbsp;<input name="appStatus" type="radio" value="inProgress" checked="checked"/>  <span class="style3">Save Draft</span>
                                
				
				
				</td>
				
				
				</tr>
				<tr>
				<td colspan="2">&nbsp;</td>
				</tr>
				<tr >
					<td colspan="2" align="center">
						<input type="submit" name="Save" value="Save" class="actionbutton">
						
					</td>
					
			  	</tr>
				<tr>
					<td colspan="2" >&nbsp;</td>
				</tr>
		  </table>
		  
	-->
	 <!--code by vikas rathore-->
		  <table width="100%" align="center">
			<tr>

<% 
System.out.println("testVal.on gsp.."+testVal)
if(testVal=="true") { %>
			<td align="center" class="txt4">Do You Want To Re-Submit The Application as 
			
                        <% } else { %>
                        
                        <td align="center" class="txt4">Do You Want To Save The Application as 
			 <% } %>  
			<input name="appStatus" id="appStatus" type="radio" value="completed" />  
			<span class="style3">Completed</span> &nbsp;
			<input name="appStatus" id="appStatus" type="radio" value="inProgress" checked="checked"/>  
			<span class="style3">In Progress</span>
                        
                        
                       
		
	
		
			
			</td>
			
			
			</tr>
			
			<tr>
			<td colspan="2">&nbsp;</td>
			</tr>
			<tr >
				<td colspan="2" align="center">
				
				<% if(testVal=="true") { %>
					<input type="submit" name="Re-Submit" value="Re-Submit" class="actionbutton">
					<% } else {%>
					<%if(indApplicationDetailsInstance.completionStatus != "completed"){ %>
				
					<input type="submit" name="Save" onclick="//javascript:confirm()" value="Save" class="actionbutton">
					
					<%}%>
					<!--code ended by vikas rathore-->	
				<%if(indApplicationDetailsInstance.completionStatus == "completed"){ %>
				
					<input type="submit" name="Submit" value="Submit" class="actionbutton">
					
					<%} %>
					
					<% } %>
					
				</td>
				
		  	</tr>
			<tr>
				<td colspan="2" >&nbsp;</td>
			</tr>
			<input type="hidden" name="typeOfIndustry" id="typeOfIndustry" value="<%=typeOfIndustry%>"/>
	  </table>
	
	
		  
		  </g:form>
		
          </div>
	  <div class="box2" id="calculator" style="visibility: hidden;">
										<!-- <div class="maintext"> -->
											<g:form name="myform">
												<table width="275" border="0" cellpadding="2" cellspacing="1" bordercolor="#FFFFFF">
													<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent Type:</span></div>
														</td>
														<td width="60%" ><span class="style6">
															 <input id="consentTypeY" name="consentType" type="radio" value="CTE" <%if(indApplicationDetailsInstance.applicationType == "CTE"){ %>checked="checked"<%} %> />CTE
															<input  id="consentTypeN" name="consentType" type="radio" value="CTO" <%if(indApplicationDetailsInstance.applicationType == "CTO"){ %>checked="checked"<%} %> />CTO</span>
														</td>
													</tr>
													<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent For:</span></div>
														</td>
														<td width="60%">
															<span class="style6">
																<input id="consentForN" name="consentFor" type="radio" value="AIR" <%if(indApplicationDetailsInstance.applicationFor == "air"){ %>checked="checked"<%} %>/>Air
																<input id="consentForY" name="consentFor" type="radio" value="WATER" <%if(indApplicationDetailsInstance.applicationFor == "water"){ %>checked="checked"<%} %> />Water
																<input id="consentForB" name="consentFor" type="radio" value="BOTH" <%if(indApplicationDetailsInstance.applicationFor == "both"){ %>checked="checked"<%} %> />Both
															</span>
														</td>
													</tr>
					
													<tr>
														<td width="40%" ><div align="left"><span class="style3 style5">Consent:</span></div></td>
														<td width="60%" >
															<span class="style6">
																	<input id="consentY" name="consent" type="radio" value="NEW" <%if(indApplicationDetailsInstance.certificateFor == "new"){ %>checked="checked"<%}%> />New
																	<input  id="consentN" name="consent" type="radio" value="RENEW" <%if(indApplicationDetailsInstance.certificateFor == "reNew"){ %>checked="checked"<%}%> />Renew
															</span>
														</td>
													</tr>
					
													<tr>
														<td  class="style3" width="40%"><div align="left" class="style5">Capital Investment<span class="txt">(in Lakhs)</span>: </div></td>
														<td width="60%" >
															<input id="capital" name="capital" type="text" class="txt4" size="10" value="${industryRegMasterInstance?.indCapInvt}">  
														</td>
													</tr>
													<tr>
														<td  width="40%"class="style3"><div align="left" class="style7">Consent Fee: </div></td>
														<td width="60%"class="style3 style7 style5"><input id="result1" size="10" class="txt4" name="result1" type="text" readonly="readonly"></td>
													</tr>
													<tr>
														<td colspan="2" align="right" class="style3 style8">
															 <a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
														</td>
													</tr>
												</table>
											</g:form>
										<!-- </div> -->
									</div>
		  

      </div></td>
                            <td width="25" align="left" valign="top">&nbsp;</td>
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



 var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("indName","req","Please enter Industry Name");
 
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric");

 <!-- frmvalidator.addValidation("indEmail","email","Enter valid email");-->
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits");
 
 //frmvalidator.addValidation("indRegNum","req","please enter industry registration no.");
 
<!-- frmvalidator.addValidation("indCapInvt","numeric","Capital investment must be numeric"); -->
 
frmvalidator.addValidation("indCity","alpha_s","check industry's city name");
 
 frmvalidator.addValidation("indPin","numeric","Pin number  must be numeric");
 
 frmvalidator.addValidation("indPhoneNo","numeric","Phone number  must be numeric");
 
 frmvalidator.addValidation("indFaxNo","numeric","Fax number  must be numeric");
 
 frmvalidator.addValidation("occName","req","Enter your Name");
 
 frmvalidator.addValidation("occDesignation","req","please enter designation");

 //frmvalidator.addValidation("occAddress","req","please enter occupier Address");
 
 frmvalidator.addValidation("occCity","req","please enter City");
 
// frmvalidator.addValidation("occPin","req","please enter PIN");
 frmvalidator.addValidation("occPin","numeric","Pin number  must be numeric");
 
 //frmvalidator.addValidation("occPhoneNo","req","please enter Phone number");
 frmvalidator.addValidation("occPhoneNo","numeric","Phone number  must be numeric");
 

 frmvalidator.addValidation("occFaxNo","numeric","Fax number  must be numeric");
 

 frmvalidator.addValidation("occMobile","numeric","Mobile number  must be numeric");

 frmvalidator.addValidation("occMobile","maxlen=12","mobile number is not valid");
 
 frmvalidator.addValidation("occEmail","email","Enter valid email");
 frmvalidator.addValidation("occEmail","req","please enter email-id");
 
 frmvalidator.addValidation("hintAnswer","req","please enter hint Answer");
 frmvalidator.addValidation("password","req","please press generate button for password");
 
 //frmvalidator.addValidation("quantity","req","please enter Quantity");
 //frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 
 
</script> 

  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 // frmvalidator.addValidation("yearsApplied","req","Please enter years Applied of Consent in Fee tab");
  frmvalidator.addValidation("yearsApplied","numeric","Applied Years of Consent in Fee tab must be numeric");
 // frmvalidator.addValidation("feeApplicable","req","please enter fees in Fee Tab");
  frmvalidator.addValidation("feeApplicable","numeric","Fees must be numeric");
 
  </script>
   <!--  
   <script language="JavaScript" type="text/javascript">
	var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("quantity","req","please enter Quantity");
 	frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 </script>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("ddNo","req","please enter DD number");
  frmvalidator.addValidation("ddNo","numeric","DD number must be numeric");
  frmvalidator.addValidation("date","req","please enter date");
 
frmvalidator.addValidation("bankName","req","please enter bank name");
  frmvalidator.addValidation("bankName","alnum_s","Enter valid bank name");
  
  frmvalidator.addValidation("branchName","req","please enter branch Name");
  frmvalidator.addValidation("branchName","alnum_s","Enter valid branch name");
  
  frmvalidator.addValidation("ddAmount","req","please enter Amount");
  frmvalidator.addValidation("ddAmount","numeric","DD Amount must be numeric");
 </script>   
 
  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("conQuantity","req","please enter quantity");
    frmvalidator.addValidation("conQuantity","numeric","quantity must be numeric");
    frmvalidator.addValidation("maxEffGen","req","please enter max effluent generation");
   frmvalidator.addValidation("effRecycle","req","please enter Effluent to be recycled");
    frmvalidator.addValidation("effDisposed","req","please enter effluent to be disposed");
  
 </script> 

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("parameterStandard","req","please enter parameter Standard");
    
  
 </script>  

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("stackPlant","req","please enter quantity");
  
    frmvalidator.addValidation("sourceCapacity","req","please enter sorce capacity");
   frmvalidator.addValidation("presStand","req","please enterpescribed standards");
   
   
    frmvalidator.addValidation("fuelQuantity","req","please enter fuel quantity");
   frmvalidator.addValidation("fuelCapacity","req","please enter fuel capacity");
   
    frmvalidator.addValidation("sourceFugitiveEmmision","req","please enter Source of fugitive emission");
   frmvalidator.addValidation("fugPresStand","req","please enter pescribed Stds");
 </script>
 
  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("upfile","req","please upload enclosures");
    frmvalidator.addValidation("ProjectReport","req","please upload Project Report");
    
//  frmvalidator.addValidation("quantity","req","please enter Quantity");
    //frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
  
 </script>
 -->
</body>
</html>
