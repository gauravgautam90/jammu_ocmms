<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<% String cont=request.getContextPath(); %>
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


<style type="text/css">
textarea {

	font-size: 12pt;
	font-family: Arial;

}
</style>


<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<g:javascript library="prototype" />
<g:javascript>
function checkField(id)
{
	
     alert('Inside checkfield function'+id)
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
    console.log("----Value of l------"+l)
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
alert("inside alert --"+id)
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

function checkMIS(){
 
if((document.getElementById('oldFileNo').value).trim()!= ''){
var oldFileNo= document.getElementById('oldFileNo').value
var oldFileNoLength= oldFileNo.length
var oldFileNo1=oldFileNo.substr(0,3)
var oldFileNo2=oldFileNo.substr(3,oldFileNoLength)
if(Number(oldFileNo1) >= 0){
alert("Old MIS File No should be 3 characters and 4 numeric");
return false;
}else if(Number(oldFileNo2) >= 0){
if(!((oldFileNo1.length==3)&&(oldFileNo2.length==4)))
{
alert("Old MIS File No should be 3 characters and 4 numeric")
return false;
}
else{
return true;
}
}else{
alert("Old MIS File No should be 3 characters and 4 numeric");
return false;
}
}

}
 function checkWaterBody(){

   if((document.getElementById('distanceWaterBody').value).trim()!= ''){
		var distance=  document.getElementById('distanceWaterBody').value

       if(Number(distance) >= 0){
        if(distance.length>4){  
             alert("Distance of the water body should have 4 numeric");
               return false;
         }                                    
       }else{
      alert("Distance of the water body should have 4 numeric");
               return false;
       }
}
}
function checkWaterSource(){

   if((document.getElementById('distanceWaterSource').value).trim()!= ''){
		var distance=  document.getElementById('distanceWaterSource').value

       if(Number(distance) >= 0){
        if(distance.length>4){  
             alert("Distance of the water source should have 4 numeric");
               return false;
         }                                    
       }else{
      alert("Distance of the water source should have 4 numeric");
               return false;
       }
}
}

function checkLattitude(){

   if((document.getElementById('lattitude').value).trim()!= ''){
		var distance=  document.getElementById('lattitude').value

       if(Number(distance) >= 0){
      
       if(distance.indexOf('.')!=-1){  
       var d1=  distance.split(".")[0].length
       var d2=  distance.split(".")[1].length
       
            if((d1 > 2)||(d2 > 6)){                
               alert("lattitude should have 2 No and 6 decimals");
               return false;  
            }  
         }  
       else if(distance.length>2){  
             alert("lattitude should have 2 No and 6 decimals");
               return false;
         }
                                    
       }else{
      alert("lattitude should have 2 No and 6 decimals");
               return false;
       }
}
 
}
function checkLogntitude(){

   if((document.getElementById('logntitude').value).trim()!= ''){
		var distance=  document.getElementById('logntitude').value

       if(Number(distance) >= 0){
      
       if(distance.indexOf('.')!=-1){  
       var d1=  distance.split(".")[0].length
       var d2=  distance.split(".")[1].length
       
            if((d1 > 2)||(d2 > 6)){                
               alert("logntitude should have 2 No and 6 decimals");
               return false;  
            }  
         }  
       else if(distance.length>2){  
             alert("logntitude should have 2 No and 6 decimals");
               return false;
         }
                                    
       }else{
      alert("logntitude should have 2 No and 6 decimals");
               return false;
       }
}
 
}

function checkEmptyField(){

if(((document.getElementById('oldFileNo').value).trim()!= '') && (document.getElementById('oldFileNo').value!= 'New')){
var oldFileNo= document.getElementById('oldFileNo').value
var oldFileNoLength= oldFileNo.length
var oldFileNo1=oldFileNo.substr(0,3)
var oldFileNo2=oldFileNo.substr(3,oldFileNoLength)
if(Number(oldFileNo1) >= 0){
alert("Old MIS File No should be 3 characters and 4 numeric");
return false;
}else if(Number(oldFileNo2) >= 0){
if(!((oldFileNo1.length==3)&&(oldFileNo2.length==4)))
{
alert("Old MIS File No should be 3 characters and 4 numeric")
return false;
}
else{
return true;
}
}else{
alert("Old MIS File No should be 3 characters and 4 numeric");
return false;
}
}

   if((document.getElementById('distanceWaterBody').value).trim()!= ''){
		var distance=  document.getElementById('distanceWaterBody').value

       if(Number(distance) >= 0){
        if(distance.length>4){  
             alert("Distance of the water body should have 4 numeric");
               return false;
         }                                    
       }else{
      alert("Distance of the water body should have 4 numeric");
               return false;
       }
}

 if((document.getElementById('distanceWaterSource').value).trim()!= ''){
		var distance=  document.getElementById('distanceWaterSource').value

       if(Number(distance) >= 0){
        if(distance.length>4){  
             alert("Distance of the water source should have 4 numeric");
               return false;
         }                                    
       }else{
      alert("Distance of the water source should have 4 numeric");
               return false;
       }
}
 
 if((document.getElementById('lattitude').value).trim()!= ''){
		var distance=  document.getElementById('lattitude').value

       if(Number(distance) >= 0){
      
       if(distance.indexOf('.')!=-1){  
       var d1=  distance.split(".")[0].length
       var d2=  distance.split(".")[1].length
       
            if((d1 > 2)||(d2 > 6)){                
               alert("lattitude should have 2 No and 6 decimals");
               return false;  
            }  
         }  
       else if(distance.length>2){  
             alert("lattitude should have 2 No and 6 decimals");
               return false;
         }
                                    
       }else{
      alert("lattitude should have 2 No and 6 decimals");
               return false;
       }
}


 if((document.getElementById('logntitude').value).trim()!= ''){
		var distance=  document.getElementById('logntitude').value

       if(Number(distance) >= 0){
      
       if(distance.indexOf('.')!=-1){  
       var d1=  distance.split(".")[0].length
       var d2=  distance.split(".")[1].length
       
            if((d1 > 2)||(d2 > 6)){                
               alert("logntitude should have 2 No and 6 decimals");
               return false;  
            }  
         }  
       else if(distance.length>2){  
             alert("logntitude should have 2 No and 6 decimals");
               return false;
         }
                                    
       }else{
      alert("logntitude should have 2 No and 6 decimals");
               return false;
       }
}
}
	function showHideDivGO(e){
		var select1=document.getElementById('goRelaxation').value;
		var select2=document.getElementById('environmentalClearance').value;
		var select3=document.getElementById('crzClearance').value;
		if(select1=="Yes" || select2=="Yes" || select3=="Yes"){
		document.getElementById('sectionDivGO').style.display = 'block';
		}
		else{
		document.getElementById('sectionDivGO').style.display = 'none';
		}
		
	}
	function hidediv(){
		var radios = document.getElementsByName('under17Category');
		for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
		var radioVal=radios[i].value;
		if(radioVal=="Yes"){
			document.getElementById('tempUnderIndCategory').style.display = 'block';
		 }else{
		 document.getElementById('tempUnderIndCategory').style.display = 'none';
		 }
	     break;
	    }
	  }
   }
   function showHideDivTNEB(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivTNEB').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivTNEB').style.display = 'none';
		}
   }
   function showHideDivHW(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivHW').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivHW').style.display = 'none';
		}
   }
   function showHideDivHWAuth(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivHWAuth').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivHWAuth').style.display = 'none';
		}
   }
   function showHideDivDischargeSurface(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivDischargeSurface').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivDischargeSurface').style.display = 'none';
		}
   }
   function showHideDivComplaints(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivComplaints').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivComplaints').style.display = 'none';
		}
   }
   function showHideDivLegalAction(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivLegalAction').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivLegalAction').style.display = 'none';
		}
   }
   function showHideDivTotalGfa(e){
   		if(e=="Yes"){
			document.getElementById('sectionDivTotalGfa').style.display = 'block';
		}
		else{
			document.getElementById('sectionDivTotalGfa').style.display = 'none';
		}
   }
   

</g:javascript>


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
				//*((document.getElementsByName('yearsApplied')[0]).value);
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




<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
 
 
 
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
		<!-- Start of menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
        <%} %>
     <% if((UserMaster)session.getAttribute("userMaster")){
			UserMaster aa = (UserMaster)session.getAttribute("userMaster");
			String userType = aa.accessLevel
				if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      
			<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
				<%}
		} %>
     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
			<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
	  <% } %>
	  <!-- END of menuAdminHorizontal-->
            		
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- Start of menuAdmin-->
			<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenu"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenu"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
			<!-- End of menuAdmin-->

			
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
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
			<table width="100%" > 
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					<tr>
							
				
							
						</td>
							<td >&nbsp;</td>
							
							
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${certificateRecordInstance}">
            <div class="errors">
                <g:renderErrors bean="${certificateRecordInstance}" as="list" />
            </div>
            </g:hasErrors>  
            
                

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
    <g:form  name="myForm" action="saveWasteMaster" method="post" >
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                    
  <tr>
                              <td width="5"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="120" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Industry Details</a></td>
                              <td width="5" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
	    
	    
	    
          <div id="country1" style="border:1px solid gray;overflow: auto;  height:470px; width:710px;   margin-bottom: 1em; padding: 10px">
  			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
			 		  <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Industry Details:</div></td>  
                      </tr>
					  <tr >
                        <td width="50%" align="left" bgcolor="#E8F6F9"><span class="txt4"></span>
                        <input type="hidden" name="id" value="${bioMedicalWasteInst?.id}">
                        </td>
                      </tr>

			<!-- static data from industry by AKhi007 -->
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
					  <input name="indName" type="text" value="${industryMasterDetailsInstance?.indName}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(industry name max 250 char)</span>
					</span></td>
				</tr> 

			
					<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Scale of Industry:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue"><span class="style6"><span class="txt style6">
<g:select class="txt4" from="${['Small','Medium','Large']}" name="industryScale" id="industryScale" value="${fieldValue(bean:industryMasterDetailsInstance,field:'industryScale')}" > </g:select>
&nbsp;<span class="sidetxt">(e.g. small/medium/large)</span></span></span></td>
</tr>
			
	<!--	 <tr><td align="left" bgcolor="#A8DAF3" class="headngblue">
				Category:<span style="color:red">*</span></td>
				<td width="70%" align="left" bgcolor="#E8F6F9"	>
			<g:select   optionKey="id" optionValue="name" name="category.id" id="category.id" from="${IndCatMaster.list()}"
	        onchange="${remoteFunction( controller:'industryRegMaster', action:'ajaxGetCities', 
	            params:'\'id=\' + escape(this.value)', onComplete:'updateCity(e)')}" 
	             value="${fieldValue(bean:industryRegMasteInstance,field:'category')}">
	        </g:select></td>
	        </tr>
	         <tr><td align="left" bgcolor="#A8DAF3" class="headngblue">
				Industry Type:<span style="color:red">*</span></td>
				<td width="70%" align="left" bgcolor="#E8F6F9"	>
	    <g:select optionKey="id" optionValue="industryType" name="industryType.id" id="industryType.id"  onclick="javascript:select1()" value="${fieldValue(bean:industryRegMasteInstance,field:'industryType')}">
	   
	    </g:select>
	     <div style="display:none; border:0;"  id="selectTemp"  >
							       <input	name="indTypeOther" type="text"	value="${fieldValue(bean:industryRegMasteInstance,field:'indTypeOther')}"
									maxlength="250" size="25" AUTOCOMPLETE=OFF /><span
										class="txt4">(enter other industry type name, max 250 characters)</span>
									</div>
	    </td>
	    </tr> -->
							
	
				<tr>
<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status:</td>
<td align="left" bgcolor="#E8F6F9" class="headngblue"><span class="style6"><span class="txt style6">
<g:select class="txt4" from="${['Operational','Proposed','Closed']}" name="indStatus" id="indStatus" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indStatus')}" > </g:select>
&nbsp;<span class="sidetxt">(e.g. operational/proposed/closed)</span></span></span></td>
</tr>


		<!-- <%if(app.applicationFor.equals("hotel")) {%>
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hotel Area:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					 <g:select  from="${['Mountainuous','Plans','Cluster','Isolated','Other']}" name="hotelArea" id ="hotelArea" value="" class="txt4"></g:select>
					 </span></span></td>
				</tr>        
				<%}%> -->
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Commisioning Year:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" name="dateOfComm" value="${industryMasterDetailsInstance?.dateOfComm}" />
					&nbsp;<span class="sidetxt">(e.g. 2002)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Registration/ License/DIC No.<span style="color:red">*</span>:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indRegNum" name="indRegNum" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indRegNum')}"/>
					&nbsp;<span class="sidetxt">(reg/license/dic no of industry)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Capital Investment<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvt" name="indCapInvt" onblur="checkField(this)" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indCapInvt')}" />
					&nbsp;<span class="sidetxt">(capital investment of plant & machinery)</span></span></td>
				</tr>
			<!---
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment of Land<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvtLand" name="indCapInvtLand" onblur="checkField(this)" value="" />					&nbsp;<span class="sidetxt">(capital investment of land)</span></span></td>
				</tr>
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment of Building<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvtBuilding" name="industryMasterDetailsInstance" onblur="checkField(this)" value="" />
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
					   <input type="text"  class="txt4" id="indAddress" name="indAddress" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indAddress')}"/>
					&nbsp;<span class="sidetxt">(address where industry is established)</span></span></td>
				</tr>        
				 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Village/City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="indCity" name="indCity" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indCity')}"/>
					&nbsp;<span class="sidetxt">(city industry address)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPin" name="indPin" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indPin')}"/>
					&nbsp;<span class="sidetxt">(pin of address locality)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone)<span style="color:red">*</span>:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPhoneCode" name="indPhoneCode" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indPhoneCode')}"/>
					&nbsp;<span class="sidetxt">(std code of phone no)</span></span></td>
				</tr>        
				<input type="hidden" name="cat" id ="cat" value="${industryMasterDetailsInstance?.category}"/>		
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No<span style="color:red">*</span>: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPhoneNo" name="indPhoneNo" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indPhoneNo')}"/>
					&nbsp;<span class="sidetxt">(phone no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indFaxCode" name="indFaxCode" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indFaxCode')}"/>
					&nbsp;<span class="sidetxt">(std code of fax no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indFaxNo" name="indFaxNo" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indFaxNo')}"/>
					&nbsp;<span class="sidetxt">(fax no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-Mail Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="indEmail" name="indEmail" value="${fieldValue(bean:industryMasterDetailsInstance,field:'indEmail')}"/>
					&nbsp;<span class="sidetxt">(e.g. info@abc.com)</span></span></td>
				</tr>
				<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Expected Date of Production :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryMasterDetailsInstance,field:'expDate','errors')} txt">
																	  <calendar:datePicker name="expDate" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
																</td>
															</tr>
															
																<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Shifts in Industry :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryMasterDetailsInstance,field:'shiftsIndustry','errors')} txt">
																<g:select  from="${['General Shift','Two Shifts','Round the Clock']}" name="shiftsIndustry" value="${fieldValue(bean:industryRegMasteInstance,field:'shiftsIndustry')}" class="txt4"></g:select></td>
															</tr>
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Monitoring is being :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:monitoring,field:'monitoring','errors')} txt">
																<g:select  from="${['Done','Proposed']}" name="monitoring" value="${fieldValue(bean:industryMasterDetailsInstance,field:'shiftsIndustry')}" class="txt4"></g:select></td>
															</tr>
															
															
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Total number of Workers:</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryRegMasteInstance,field:'expNoEmp','errors')} txt">
																<input name="expNoEmp" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasteInstance,field:'expNoEmp')}"
																	size="20" AUTOCOMPLETE=OFF /></td>
															</tr>
						
						
						                                     <tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																Total number of office Staff:<span style="color:red">*</span></td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryMasterDetailsInstance,field:'noOfEmp','errors')} txt">
																<input name="noOfEmp" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasteInstance,field:'noOfEmp')}"
																	size="20" AUTOCOMPLETE=OFF /></td>
															</tr>
						
															<tr bgcolor="#F4F7FB">
																<td align="left" bgcolor="#A8DAF3" class="headngblue">
																What monitoring arrangement is currently there or proposed :</td>
																<td width="70%" align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryMasterDetailsInstance,field:'waterMonitoring','errors')} txt">
																<input name="waterMonitoring" maxlength="100" type="text"
																	class="txt4"
																	value="${fieldValue(bean:industryRegMasteInstance,field:'waterMonitoring')}"
																	size="20" AUTOCOMPLETE=OFF /><span class="sidetxt">(maximum 100 characters)</span></td>
															</tr>
															<tr>
																<td align="left" bgcolor="#A8DAF3" class="headngblue">Site
																Area:<span style="color:red">*</span></td>
																<td align="left" bgcolor="#E8F6F9"
																	class="value ${hasErrors(bean:industryMasterDetailsInstance,field:'siteArea','errors')} txt"><span
																	class="txt style6"> <select name="siteArea"
																	class="txt4">

																	<option value="Industrial Area">Industrial Area</option>
																	<option value="Outside Industrial Area">Outside Industrial Area</option>
																	

																</select></span></td>
															</tr>
			

					<!-- occuiper details starts here  -->
					
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
					<input type="text"  class="txt4" id="occName" name="occName" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occName')}"/>&nbsp;<span class="sidetxt">(name of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occDesignation" name="occDesignation" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occDesignation')}"/>&nbsp;<span class="sidetxt">(designation of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Residential Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occAddress" name="occAddress" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occAddress')}"/>&nbsp;<span class="sidetxt">(address of occupant)</span></span></td>
				</tr>   
				
				<tr>
																	<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status Of Applicant: </td>
																<td width="70%" align="left" bgcolor="#E8F6F9" >
																<g:select  from="${['Individual','Proprietory concern','Partnership firm','Joint Family Concern','Private Limited company','Public Limited Company','State Government','Central Government','Union Territory','Foreign Company','Any other Associate or Body']}" name="statusOfAppl"  class="txt4"></g:select><span class="txt4"></span></td>
															</tr>
				
				<tr align="center" bgcolor="#F4F7FB">
															<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name of Directors/Partner/Proprietor with Contact Details
															</td>
															<td align="left" bgcolor="#E8F6F9"  class="txt">
																<textarea	name="nameAddressPartners" rows="5" cols="40"
																	maxlength="1000" class="txt4">${fieldValue(bean:industryMasterDetailsInstance,field:'nameAddressPartners')}</textarea>
															</td>
															
															</tr>	
															
															
															
															
															<tr align="center" bgcolor="#F4F7FB">
															<td align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Conclusion
															</td>
															<td align="left" bgcolor="#E8F6F9"  class="txt">
																<textarea	name="conclution" rows="5" cols="40"
																	maxlength="1000" class="txt4">${fieldValue(bean:industryMasterDetailsInstance,field:'conclution')}</textarea>
															</td>
															
															</tr>												
															
															
															
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Village/City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occCity" name="occCity" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occCity')}"/>
					&nbsp;<span class="sidetxt">(city where occupant live)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occPin" name="occPin" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occPin')}"/>&nbsp;<span class="sidetxt">(pin of address locality)</span>
					</span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone)<span style="color:red">*</span>:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occPhoneCode" name="occPhoneCode" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occPhoneCode')}"/>
					&nbsp;<span class="sidetxt">(std code of phone no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No<span style="color:red">*</span>:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="occPhoneNo" name="occPhoneNo" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occPhoneNo')}"/>
					&nbsp;<span class="sidetxt">(phone no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occFaxCode" name="occFaxCode" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occFaxCode')}"/>
					&nbsp;<span class="sidetxt">(std code of fax no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occFaxNo" name="occFaxNo" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occFaxNo')}"/>
					&nbsp;<span class="sidetxt">(fax no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile No:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="occMobile" name="occMobile" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occMobile')}"/>
					&nbsp;<span class="sidetxt">(mobile no upto 12 characters with country code)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occEmail" name="occEmail" value="${fieldValue(bean:industryMasterDetailsInstance,field:'occEmail')}"/>
					&nbsp;<span class="sidetxt">(e.g. info@abc.com)</span></span></td>
				</tr>        
				         
				<!-- other details of industry starts here -->
				
					 <tr><td bgcolor="#FFFFFF" colspan="2">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="100%" align="center" valign="middle"  class="headngblue"><span style="color: white">
						Other Details
						 </span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"></td>
						</tr>
					</table>
					</td>
				</tr>  
				
				
  					<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Site Is Located Near River Bank/Water Bodies:</td>
							      <td bgcolor="#E8F6F9" align="left" class="headngblue">
										 <g:select class="txt4" from="${['No','Yes']}" name="nearRiver" id="nearRiver" onclick="javascript:select10()" value="${fieldValue(bean:industryRegMasteInstance,field:'nearRiver')}" ></g:select>
												
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
												<input	name="riverName" id="riverName"  type="text"  value="${fieldValue(bean:industryRegMasteInstance,field:'riverName')}"  class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="25"/>
													
											</td>
											<td align="center" >
												(Distance in meters)
												<br>
												<input	name="riverDist" id="riverDist" type="text" class="txt4" value="${fieldValue(bean:industryRegMasteInstance,field:'riverDist')}" maxlength="20"	AUTOCOMPLETE=OFF size="25"/>
													
											</td>
											
											</tr></table>
																	 </div>
										         </td>          
										    </tr>		
										  				<tr class="headngblue" bgcolor="#A8DAF3">
																	  <td width="30%" align="left" >Site Is Located Near Residential Colony:</td>
																	      <td bgcolor="#E8F6F9" align="left" class="headngblue">
															
															<g:select class="txt4" from="${['Yes','No']}" name="nearResidCol" id="nearResidCol"   onclick="javascript:select9()"  value="${fieldValue(bean:industryMasterDetailsInstance,field:'nearResidCol')}" ></g:select>
										
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
		<input	name="colPopulation" id=""  type="text"  value="${fieldValue(bean:industryRegMasteInstance,field:'colPopulation')}"  class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center" >
		(Location)
		<br>
		<input	name="colLocation" id="colLocation" type="text" class="txt4" value="${fieldValue(bean:industryRegMasteInstance,field:'colLocation')}" maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center">
		(Distance in Meters)
		
		<br>
		<input	name="colDistance" id="colDistance"  type="text" class="txt4" value="${fieldValue(bean:industryRegMasteInstance,field:'colDistance')}" 	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	
	</tr></table>
							 </div>
         </td>          
    </tr>
    
    <tr class="headngblue" bgcolor="#A8DAF3">
							  <td  align="left" >Is Site Located Near Industrial Estate:</td>
							  <td bgcolor="#E8F6F9" align="left" class="headngblue">
								<g:select class="txt4" from="${['No','Yes']}" name="nearIndEstate" id="nearIndEstate"  onclick="javascript:select100()"  value="${fieldValue(bean:industryMasterDetailsInstance,field:'nearIndEstate')}" ></g:select>
										  
							  
							 
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
						<g:select class="txt4" from="${['No','Yes']}" name="disposalSysProv" id="disposalSysProv" onclick="javascript:select2()"  value="${fieldValue(bean:industryMasterDetailsInstance,field:'disposalSysProv')}" ></g:select>
								
						 
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
						 
						 <g:select class="txt4" from="${['Yes','No']}" name="utilizeSys" id="utilizeSys"  onclick="javascript:select3()"  value="${fieldValue(bean:industryMasterDetailsInstance,field:'utilizeSys')}" ></g:select>
						
						 
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
					  <input name="proposalDetails" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'proposalDetails')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter detalis of the proposal, max 250)</span>
					</span></td>
					</tr></table>
				</div></td>
			</tr>
    
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Total Plot Area:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="totalPlotArea" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'totalPlotArea')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(in square meter)</span>
					</span></td>		
  				</tr>
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Build-up Area:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="plotArea" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'plotArea')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(in square meter)</span>
					</span></td>		
  				</tr>
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Area used for Treated Sewage/Trade Effluent:</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="builtUpArea" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'builtUpArea')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(for treated sewage/trade effluent area in square meter)</span>
					</span></td>		
  				</tr>	
  				
  				<%	
				 if ((a4==1)||(a4==2)){ %>
				 
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Total Project Cost (in Rs.):</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="totalProjectCost" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'totalProjectCost')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter total project cost)</span>
					</span></td>		
  				</tr>	
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Total Capital Inv. Proposed on Pollution/Env. Protection (in %):</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="pollutionMonitoringCost" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'pollutionMonitoringCost')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(calculate on the basis of total investment of industry)</span>
					</span></td>		
  				</tr>	
  				
  					<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="left" >Are sewage & trade effluents mixed together ?:</td>
							      <td bgcolor="#E8F6F9" align="left" class="headngblue">
									 <g:select class="txt4" from="${['No','Yes']}" name="sewage" id="sewage"  onclick="javascript:select12()"  value="${fieldValue(bean:industryRegMasteInstance,field:'sewage')}" ></g:select>
																			
													</td>							     
														     
														      
													      </tr>
													      
						 
										
						<tr class="headngblue" bgcolor="#A8DAF3">
				 <td colspan=2>
				 <div style="display:none; border:0;"  id="selectTemp12"  >
					<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
					<tr class="headngblue" bgcolor="#A8DAF3">				 
						  <td width="35%" align="left" >At which state ?:</td>
						  <td bgcolor="#E8F6F9" align="left" class="headngblue">
						 <g:select class="txt4" from="${['Before Treatment','After Treatment','Intermittently']}" name="sewageState" id="sewageState"   value="${fieldValue(bean:industryRegMasteInstance,field:'sewageState')}" ></g:select>
									
						
						 </td>
					</tr></table>
				</div></td>
			</tr>
									
  				<tr class="headngblue txt4" >
    				<td align="left" bgcolor="#A8DAF3">Capacity of Treated Effluent :</td>
   					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="treatedEffCapacity" type="text" value="${fieldValue(bean:industryMasterDetailsInstance,field:'treatedEffCapacity')}" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(enter sump, guard, pond if any)</span>
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
		<input	name="nonHwmProdName" id="nonHwmProdName"  type="text"  value="${fieldValue(bean:industryMasterDetailsInstance,field:'nonHwmProdName')}"  class="txt4"	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center" >
		(Area of Land)
		<br>
		<input	name="landArea" id="landArea" type="text" class="txt4" value="${fieldValue(bean:industryMasterDetailsInstance,field:'landArea')}" maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	<td align="center">
		(Capacity)
		
		<br>
		<input	name="prodCapacity" id="prodCapacity"  type="text" class="txt4" value="${fieldValue(bean:industryMasterDetailsInstance,field:'prodCapacity')}" 	maxlength="20"	AUTOCOMPLETE=OFF size="20"/>
			
	</td>
	
	</tr></table>
		
         </td>          
    </tr>
	<%} %>		
				
			
				
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
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popFeeDetailsView/<%=bioMedicalWasteInst.id%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');" > View </a></td>
					</tr>
					</table>
					</td>
				</tr> 
						
					
					<!-- new changes by Akhi007 For CFO Master Starts  -->
					

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
<td align="left" bgcolor="#E8F6F9"><input type="text" name="noofbeds"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'noofbeds')}"></td>
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
 Added by sharvan for new changes  Code Commented by sharvan


<tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">d).	Others (specify)</td>
<td align="left" bgcolor="#E8F6F9"><input type="text" name="other1" value="${fieldValue(bean:bioMedicalWasteInst,field:'other1')}"></td><td align="left" class="headngblue"  bgcolor="#E8F6F9"><input type="text" name="other2" value="${fieldValue(bean:bioMedicalWasteInst,field:'other2')}"></td>
</tr> 

<tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">e).	Total number of inpatients & outpatients treated per month in the HCF</td>
<td align="left" bgcolor="#E8F6F9"><input type="text" name="patientspermonth"  maxlength="6" value="${fieldValue(bean:bioMedicalWasteInst,field:'patientspermonth')}"> </td>
</tr> 

<tr> <td align="left" bgcolor="#A8DAF3" class="headngblue">f).	No of Needle destroyers/cutters in the HCF</td>
<td align="left" bgcolor="#E8F6F9"><input type="text" name="destroyer"  maxlength="5" value="${fieldValue(bean:bioMedicalWasteInst,field:'destroyer')}"> </td>
</tr> 	
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
 
 <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b> </b></span></td>
</tr>


<tr> 
  <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b></b></span></td>
  <td align="left"  bgcolor="#E8F6F9" class="headngblue"><span><b>Total</b><scope style="color:red"></scope></span></td>
 <td align="left"  bgcolor="#E8F6F9" class="headngblue"><input type="text" name="total1" id="total1" value="${fieldValue(bean:bioMedicalWasteInst,field:'total1')}" ></td>
 
 </tr>
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
					
</table>
	   <table width="96%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td width="75%" align="right"><input type="submit"  value="Save" class="actionbutton" onclick="return checkEmptyField()"><input type="hidden" name="bioAppId" value=value="${fieldValue(bean:bioMedicalWasteInst,field:'id')}"></td>
			
				<!-- onclick="window.open('../openCertificate', 'windowname1', 'width=810, height=650, scrollbars=1'); return false;" name="save" -->
					
		  </tr>
		</table>
  			</g:form>
  			
            <br />
            <br />
          </div>
          
           <div class="box2" id="calculator" style="visibility: hidden;">
										<!-- <div class="maintext"> -->
											<g:form name="myform">
												<table width="275" border="0" cellpadding="2" cellspacing="1" bordercolor="#FFFFFF">
													
													
					
													
					
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
		  
          </div>
		  
		  
	
		  
		  
		  
		  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
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
</body>

<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myForm");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("indName","req","Please enter Industry Name");
 
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric");

 <!-- frmvalidator.addValidation("indEmail","email","Enter valid email");-->
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits");
 
 //frmvalidator.addValidation("indRegNum","req","please enter industry registration no.");
 
 frmvalidator.addValidation("indCapInvt","numeric","Capital investment must be numeric");
 
frmvalidator.addValidation("indCity","alpha_s","check industry's city name");
 
 frmvalidator.addValidation("indPin","numeric","Pin number  must be numeric");
 
 frmvalidator.addValidation("indPhoneNo","numeric","Phone number  must be numeric");
 
 frmvalidator.addValidation("indFaxNo","numeric","Fax number  must be numeric");
 
 frmvalidator.addValidation("occName","req","Enter your Name");
 
 frmvalidator.addValidation("occDesignation","req","please enter designation");

 //frmvalidator.addValidation("occAddress","req","please enter occupier Address");
 
 //frmvalidator.addValidation("occCity","req","please enter City");
 
 //frmvalidator.addValidation("occPin","req","please enter PIN");
 frmvalidator.addValidation("occPin","numeric","Pin number  must be numeric");
 
// frmvalidator.addValidation("occPhoneNo","req","please enter Phone number");
 frmvalidator.addValidation("occPhoneNo","numeric","Phone number  must be numeric");
 

 frmvalidator.addValidation("occFaxNo","numeric","Fax number  must be numeric");
 

 frmvalidator.addValidation("occMobile","numeric","Mobile number  must be numeric");

 frmvalidator.addValidation("occMobile","maxlen=12","mobile number is not valid");
 
 frmvalidator.addValidation("occEmail","email","Enter valid email");
 //frmvalidator.addValidation("occEmail","req","please enter email-id");
 
 frmvalidator.addValidation("hintAnswer","req","please enter hint Answer");
 frmvalidator.addValidation("password","req","please press generate button for password");
 
 //frmvalidator.addValidation("quantity","req","please enter Quantity");
 //frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 
 
</script> 

  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("myForm");
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
    var frmvalidator  = new Validator("myForm");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("conQuantity","req","please enter quantity");
    frmvalidator.addValidation("conQuantity","numeric","quantity must be numeric");
    frmvalidator.addValidation("maxEffGen","req","please enter max effluent generation");
   frmvalidator.addValidation("effRecycle","req","please enter Effluent to be recycled");
    frmvalidator.addValidation("effDisposed","req","please enter effluent to be disposed");
  
 </script> 

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("myForm");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("parameterStandard","req","please enter parameter Standard");
    
  
 </script>  

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("myForm");
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
  
 </script>

<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

