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
		
    <table border="1" width="95%" align="center" cellpadding="0"	cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#CCC" >
			    <td width="5%" align="center" class="headngblue">#</td>
                <td width="20%" align="center" class="headngblue">Category</td>
               
                <td width="20%" align="center" class="headngblue">Quantity in stock at <br>the beginning of the year </td>
                <td width="25%" align="center" class="headngblue">Quantity of waste received<br> during the year<br> from Domestic sources</td>
                <td width="10%" align="center" class="headngblue">Quantity of waste received <br>during the year Imported </td>
                <td width="10%" align="center" class="headngblue">Quantity recycled or <br>co-processed or used</td>
                <td width="10%" align="center" class="headngblue">Quantity of waste generated</td>
                <td width="10%" align="center" class="headngblue">Quantity of waste disposed</td>
                 <td width="10%" align="center" class="headngblue">Quantity re-exported <br>(wherever applicable)</td>
                <td width="10%" align="center" class="headngblue">Quantity in storage<br> at the end  of the year </td>
                <td width="10%" align="center" class="headngblue"> </td>
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
  			  <td align="center" class="txt4">${hazardousWasteDetailsListInstance.quantityReExported}</td>
  			<td align="center" class="txt4">${hazardousWasteDetailsListInstance.quantityInstorageEndYear}</td>
  			<td align="center" class="txt4">
  			<a href="#" onclick="window.open('<%=request.getContextPath()%>/hazardeousWasteAuthApp/deleteHazardeousPartCDetailsRecord/<%=hazardousWasteDetailsListInstance.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1,resizable=yes');" class="actionbutton">  <input type="button" value="Delete" class="actionbutton">	</a>
  			</td>
  			</tr>		
       </g:each>	
       	     <g:if test="${hazardousWasteDetailsList.size()==0}">
  			       <td colspan="12" >No records Founds...</td>
  			    </g:if>


	</table>		  
		  
		  	 
</body>
