<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="https://java.sun.com/jsp/jstl/fmt" %>
<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<style>
td {
     overflow: hidden;
    height: 25px;
}
</style>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }


function checkArea(distance)
{
if(distance!=""){
if(Number(distance) > 0){
      
       if(distance.indexOf('.')!=-1){  
       var d1=  distance.split(".")[0].length
       var d2=  distance.split(".")[1].length
       
            if(d2 > 2){                
               alert("Area should be numeric or 2 decimals");
               return false;  
            }  
         }            
                                    
       }else{
      alert("Area should be numeric or 2 decimals");
               return false;
       }
}
}

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<script language="javascript" type="text/javascript">
			
function hidediv()
{

        try
        {
            var rSelect = document.getElementById("menu2Schedule");
			var l = rSelect.length
			while (l > 0) {
			l--
			rSelect.remove(l)
			}
	
	        var opt = document.createElement('option');
			opt.text = "Not Selected"
			opt.value = ""
			
			try {
			rSelect.add(opt, null) // standards compliant; doesn't work in IE
			}
			catch(ex){
			rSelect.add(opt) // IE only
			} 
        }
        catch(ex)
        {
        
        }
                

     for(var i = 0; i<document.myForm.radiobutton1.length; i++)
     {
         if(document.myForm.radiobutton1[i].checked)
         {
            var menu2=document.getElementById('menu2')
            var radiomenu = document.myForm.radiobutton1[i]
	   	    if (radiomenu.value == "Schedule I") 
	   	    { 
	 			menu2.innerHTML="Name of Hazardous Waste<br>(Category No)";
	 			document.getElementById("menu1Schedule1").style.display = 'block';
                document.getElementById("menu1Schedule2").style.display = 'none';
                document.getElementById("menu1Schedule3").style.display = 'none';
                
			} 
			else if (radiomenu.value == "Schedule II")
			{ 
				menu2.innerHTML="Name of Waste constituents with concentration limits<br>(Category No)";
				document.getElementById("menu1Schedule1").style.display = 'none';
                document.getElementById("menu1Schedule2").style.display = 'block';
                document.getElementById("menu1Schedule3").style.display = 'none';
			}  
	        else if (radiomenu.value == "Schedule III")
			{ 
				menu2.innerHTML="Name of Basel No with description of Hazardous wastes<br>(Category No)";
				document.getElementById("menu1Schedule1").style.display = 'none';
                document.getElementById("menu1Schedule2").style.display = 'none';
                document.getElementById("menu1Schedule3").style.display = 'block';
			} 
			
			
			 
        } 
     } 
}
		</script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body>
        <g:form name="myForm" method="post" action="saveHazardeousPartADetails" >
        
		<table width="95%"  border="0" align="center">
              <tr>
                   <td>
		                <table width="100%"   border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
             				<tr bgcolor="#D1D1D1">
            					<td colspan="11"  align="center" valign="middle"  class="headngblue">Part A. To be filled by hazardous waste generators</td>
			            	</tr>
				
							<tr>
								<td colspan="11"  align="center" valign="middle"  class="headngblue">
								    <input type="hidden" name="appId" id="appId" value="${appDetId}">
								  <input type="radio" value="Schedule I" name="radiobutton1"  onclick="hidediv();" checked> Schedule I 
									<input type="radio" value="Schedule II" name="radiobutton1"  onclick="hidediv();"> Schedule II
									<input type="radio" value="Schedule III" name="radiobutton1"  onclick="hidediv();"> Schedule III
							    </td>
				            </tr>
				            <tr><td>
				               <table width="100%" border="1" cellpadding="2" cellspacing="0" class="">
		              				<tr bgcolor="#CCC" style="height: 20px;">
						                <td >Name of Process/Class/Part</td>
						                <!-- <td >Name of Process</td>-->
						                <td colspan="2">
						                    <g:select name="menu1" id="menu1Schedule1" optionKey="id" style="width:250px;" from="${hazarMasterList1}" noSelection="${['':'Not Selected']}" onchange="${remoteFunction(controller:'hazardeousWasteAuthApp', action:'myAjaxNewFormat',update:'menu1Data', params:'\'menu1Id=\' + this.value' )}" class="txt4"></g:select>
						                    <g:select name="menu1" id="menu1Schedule2" optionKey="id" style="width:250px;display:none;" from="${hazarMasterList2}" noSelection="${['':'Not Selected']}" onchange="${remoteFunction(controller:'hazardeousWasteAuthApp', action:'myAjaxNewFormat',update:'menu1Data', params:'\'menu1Id=\' + this.value' )}" class="txt4"></g:select>
						                    <g:select name="menu1" id="menu1Schedule3" optionKey="id" style="width:250px;display:none;" from="${hazarMasterList3}" noSelection="${['':'Not Selected']}" onchange="${remoteFunction(controller:'hazardeousWasteAuthApp', action:'myAjaxNewFormat',update:'menu1Data', params:'\'menu1Id=\' + this.value' )}" class="txt4"></g:select>
						                    <span style="color:red">*</span> </td>
						                
						                <td colspan="2" id="menu2">Name of Hazardous Waste<br>(Category No)<span style="color:red">*</span></td>
						                <td colspan="3" id="menu1Data">
						                    <g:select name="category" id="menu2Schedule" optionKey="id" style="width:300px;"  noSelection="${['':'Not Selected']}" class="txt4"></g:select>
						                    <input type="text" name="partCHHazardWaste" id="partCHHazardWaste" style="display:none;width:150px;" class="txt4">
						                </td>
						              <!--  <td>Unit</td>
						                <td ><input type="text" readonly name="aaaa" id="UnitId" size="7" ></td> -->
						            </tr>
						            </table>
						            <br>
						         
						       
						            <table width="100%" border="1" cellpadding="2" cellspacing="0" class="">
						            <tr bgcolor="#CCC" style="height: 20px;">
						                <td>Quantity in stock at<br> the beginning of the year<span style="color:red">*</span></td>
						                <td ><input type="number" name="beginningStockQuantity" id="beginningStockQuantity" ></td>
						                
						                <td>Total quantity  <br> of waste generated<span style="color:red">*</span></td>
						                <td ><input type="number" name="totalQuantity" id="totalQuantity" ></td>
						                
						                <td>Quantity dispatched  <br> to disposal facility<span style="color:red">*</span> </td>
						                <td ><input type="number" name="dispatchedQuantityToDisposalFacility" id="dispatchedQuantityToDisposalFacility" ></td>
						                <td>Quantity dispatched  <br>to  recycler or co-processors <br> or pre-processor <span style="color:red">*</span></td>
						                <td ><input type="number" name="dispatchedQuantityToRecycler" id="dispatchedQuantityToRecycler" ></td>
						                </tr>
						                <tr bgcolor="#CCC" style="height: 20px;">
						                <td>Quantity dispatched to others<span style="color:red">*</span></td>
						                <td ><input type="number" name="dispatchedQuantityToOthers" id="dispatchedQuantityToOthers" ></td>
						                
						                <td>Quantity utilised in house<span style="color:red">*</span></td>
						                <td ><input type="number" name="utilisedQuantityInHouse" id="utilisedQuantityInHouse" ></td>
						                
						                <td>Quantity in storage at the end  of the year <span style="color:red">*</span></td>
						                <td ><input type="number" name="quantityInstorageEndYear" id="quantityInstorageEndYear" ></td>
						               
						                </tr>
						            
						           </table>
			                     <br>
			                 </td></tr>
               		     </table>
                   </td>
              </tr>
               
              <tr>
                   <td align="center"><input type="submit" name="Add" value="Add" class="actionbutton" onclick="return myFunction();" ></td>
              </tr>
			  
			
              
            

              <tr>
					<!-- Div area for errors-->
					<td align="center" valign="middle">
					    <span class="error">
						     <g:if test="${flash.message}">
						          <div class="message">${flash.message}</div>
						     </g:if>
						</span>
					</td>
	    	  </tr>				
		</table>
</g:form>

<script>
function myFunction() {

var x = document.getElementById("menu2Schedule").value;
if(x=="" || x=="9999"){
alert("Please Select Name of Hazardous Waste");
document.getElementById("menu2Schedule").focus();
 return false;
  }
var x2 = document.getElementById("beginningStockQuantity").value;
if(x2==""){
alert("Please Enter Quantity in stock at the beginning of the year");
document.getElementById("beginningStockQuantity").focus();
 return false;
  }

var x3 = document.getElementById("totalQuantity").value;
if(x3==""){
alert("Please Enter Total quantity  of waste generated");
document.getElementById("totalQuantity").focus();
 return false;
  }
var x4 = document.getElementById("dispatchedQuantityToDisposalFacility").value;
if(x4==""){
alert("Please Enter Quantity dispatched to disposal facility");
document.getElementById("dispatchedQuantityToDisposalFacility").focus();
 return false;
  }
var x5 = document.getElementById("dispatchedQuantityToRecycler").value;
if(x5==""){
alert("Please Enter Quantity dispatched to  recycler or co-processors");
document.getElementById("dispatchedQuantityToRecycler").focus();
 return false;
  }
var x6 = document.getElementById("dispatchedQuantityToOthers").value;
if(x6==""){
alert("Please Enter Quantity dispatched to others");
document.getElementById("dispatchedQuantityToOthers").focus();
 return false;
  }
var x7 = document.getElementById("utilisedQuantityInHouse").value;
if(x7==""){
alert("Please Enter Quantity utilised in house");
document.getElementById("utilisedQuantityInHouse").focus();
 return false;
  }
var x8 = document.getElementById("quantityInstorageEndYear").value;
if(x8==""){
alert("Quantity in storage at the end  of the year ");
document.getElementById("quantityInstorageEndYear").focus();
 return false;
  }


	}

</script>  
<script>
function otherFieldCH(abc) {
	if(abc=="116610")
{
document.getElementById("UnitId").value="Number";

}else{
	document.getElementById("UnitId").value="Metric Ton";
}
	    }
</script>

    <table border="1" width="95%" align="center" cellpadding="0"	cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#CCC" >
			    <td width="5%" align="center" class="headngblue">#</td>
                <td width="8%" align="center" class="headngblue">Category</td>
               
                <td width="20%" align="center" class="headngblue">Quantity in stock at<br> the beginning of the year</td>
                <td width="25%" align="center" class="headngblue">Total quantity  <br> of waste generated</td>
                <td width="10%" align="center" class="headngblue">Quantity dispatched  <br> to disposal facility</td>
                <td width="10%" align="center" class="headngblue">Quantity dispatched  <br>to  recycler or co-processors <br> or pre-processor </td>
                <td width="10%" align="center" class="headngblue">Quantity dispatched to others</td>
                <td width="10%" align="center" class="headngblue">Quantity utilised in house</td>
                <td width="10%" align="center" class="headngblue">Quantity in storage<br> at the end  of the year </td>
              </tr>
       <g:each in="${hazardousWasteDetailsList}" status="i" var="hazardousWasteDetailsListInstance">
  	        <tr align="center" >
  			    <td align="center" class="txt4">${(i+1)}</td>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.category}</td>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.beginningStockQuantity}</td>
  			   <td align="center" class="txt4">${hazardousWasteDetailsListInstance.totalQuantity}</td>
  			   <td align="center" class="txt4">${hazardousWasteDetailsListInstance.dispatchedQuantityToDisposalFacility}</td>
  			   <td align="center" class="txt4">${hazardousWasteDetailsListInstance.dispatchedQuantityToRecycler}</td>
  			   <td align="center" class="txt4">${hazardousWasteDetailsListInstance.dispatchedQuantityToOthers}</td>
  			   <td align="center" class="txt4">${hazardousWasteDetailsListInstance.utilisedQuantityInHouse}</td>
  			  <td align="center" class="txt4">${hazardousWasteDetailsListInstance.quantityInstorageEndYear}</td>
  			  
  			    	
           </tr>		
       </g:each>	
       	     <g:if test="${hazardousWasteDetailsList.size()==0}">
  			       <td colspan="12" >No records Founds...</td>
  			    </g:if>


	</table>		  
		  
		  	 
</body>
