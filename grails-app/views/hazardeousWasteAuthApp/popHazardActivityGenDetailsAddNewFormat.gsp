<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
        <g:form name="myForm" method="post" action="saveHazardGenDetailsNewFormat" >
        
		<table width="95%"  border="0" align="center">
              <tr>
                   <td>
		                <table width="100%"   border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
             				<tr bgcolor="#D1D1D1">
            					<td colspan="11"  align="center" valign="middle"  class="headngblue">Hazardous Waste Generation Details</td>
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
						                </td>
						                
						                <td colspan="2" id="menu2">Name of Hazardous Waste<br>(Category No)</td>
						                <td colspan="3" id="menu1Data">
						                    <g:select name="menu2" id="menu2Schedule" optionKey="id" style="width:300px;" noSelection="${['':'Not Selected']}" class="txt4"></g:select>
						                </td>
						            </tr>
						            </table>
						            <br>
						            <table width="100%" border="1" cellpadding="2" cellspacing="0" class="">
						            <tr bgcolor="#CCC" style="height: 20px;">
						                <td>Quantity</td>
						                <td colspan="2"><input type="text" name="quantity" id="quantity" style="width:150px;" class="txt4">
                                        <g:select name="quantityUnit" id="quantityUnit" noSelection="${['':'Select unit']}" from="['T/Annum','KL/Annum']" style="width:90px;" class="txt4"></g:select></td>
						                
						                <td>Waste Type</td>
						                <td><g:select name="wasteType" id="wasteType" noSelection="${['':'Select HW Type']}" from="['Incinerable','Recyclable','Landfillable']" style="width:150px;" class="txt4"></g:select></td>
						                
						                <td>Waste Storage</td>
						                <td colspan="2"><g:select name="wasteStorage" id="wasteStorage" onchange="otherField(this)" noSelection="${['':'Select HW storage']}" from="['MS Drums','Plastic Drums','MS Tanks','Concrete Tanks','Containers-shipping','Others']" style="width:150px;" class="txt4"></g:select>
						                <input type="text" name="wasteStorageOthers" id="wasteStorageOthers" style="display:none;width:150px;" class="txt4"></td>
						                
						            </tr>
						            </table>
						            <br>
						            <table width="100%" border="1" cellpadding="2" cellspacing="0" class="">
						            <tr bgcolor="#CCC" style="height: 20px;">
						                <td>Waste Disposal</td>
						                <td><g:select name="wasteDisposal" id="wasteDisposal" onchange="otherField(this)" noSelection="${['':'Select HW Disposal']}" from="['Common Landfill-TSDF,Gummidipoondi','Incineration-Captive','Co-processing in Cement Kilns','Incineration- TSDF,Gummidipoondi','Onsite SLF','Recovery and Reuse-Captive','Recovery and Reuse-Authorized recyclers','Pre-processors-GEPIL,Ranipet','Others']" style="width:150px;" class="txt4"></g:select>
						                &nbsp;<input type="text" style="display:none;width:150px;" name="wasteDisposalOthers" id="wasteDisposalOthers" class="txt4"></td> 
						                
						                <td>Source of generation of waste</td>
						                <td><input type="text" name="sourceOfWaste" id="sourceOfWaste" style="width:150px;" class="txt4"></td> 
						                
						            </tr>
						            </table>
						            <br>
						            <table width="100%" border="1" cellpadding="2" cellspacing="0" class="">
						            <tr bgcolor="#CCC" style="height: 20px;">
						                <td>Physical status</td>
						                <td ><g:select name="physicalStatus" id="physicalStatus" noSelection="${['':'Select HW Status']}" from="['Oily','Liquid','Solid','Semi solid']" style="width:150px;" class="txt4"></g:select></td>
						                
						                <td>Quantity stored<br> at any time</td>
						                <td><input name="qtyStored" id="qtyStored" style="width:150px;" class="txt4"> 
						                <g:select name="qtyStoredUnit" id="qtyStoredUnit" noSelection="${['':'Select unit']}" from="['T','KL']" style="width:90px;" class="txt4"></g:select></td>
						                 
						                
						                <td>Quantity accumulated<br>as on 31st March</td>
						                <td><input name="qtyAccumalated" id="qtyAccumalated" style="width:150px;" class="txt4">&nbsp;<g:select name="qtyAccumalatedUnit" id="qtyAccumalatedUnit" noSelection="${['':'Select unit']}" from="['T','KL']" style="width:100px;" class="txt4"></g:select></td> 
						            </tr>
			                     </table>
			                     <br>
			                 </td></tr>
               		     </table>
                   </td>
              </tr>
               
              <tr>
                   <td align="center"><input type="submit" name="Add" value="Add" class="actionbutton" onclick="otherFieldNullValidatot()" ></td>
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

 <script language="JavaScript" type="text/javascript">
 
  var frmvalidator  = new Validator("myForm");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("menu1","req","Please select Process Name");
  frmvalidator.addValidation("menu2","req","Please select Name of Hazardous Waste");
  frmvalidator.addValidation("quantity","req","Please enter Quantity");
  frmvalidator.addValidation("quantity","decimal","Quantity should be numeric or decimal"); 
  frmvalidator.addValidation("quantityUnit","req","Please select Quantity unit");
  frmvalidator.addValidation("wasteType","req","Please select waste type");
  frmvalidator.addValidation("wasteStorage","req","Please select waste storage");
  frmvalidator.addValidation("wasteDisposal","req","Please select waste disposal");
  frmvalidator.addValidation("sourceOfWaste","req","Please enter Source of generation of waste");
  frmvalidator.addValidation("physicalStatus","req","Enter the physical status details");
  frmvalidator.addValidation("qtyStored","req","Please enter Quantity stored at any time ");
  frmvalidator.addValidation("qtyStoredUnit","req","Please enter Unit of Quantity stored at any time ");
  frmvalidator.addValidation("qtyStored","decimal","Quantity should be numeric or decimal for Qunatity Stored at any time"); 
  frmvalidator.addValidation("qtyAccumalated","req","Please enter Quantity accumulated as on 31st March ");
  frmvalidator.addValidation("qtyAccumalated","decimal","Quantity should be numeric or decimal Quantity Accumalated"); 
  frmvalidator.addValidation("qtyAccumalatedUnit","req","Please select Unit of Quantity stored /accumulated ");
  
  
function otherFieldNullValidatot()
 {
	
	var getwasteDisposal = document.getElementById("wasteDisposal").value;
	var valueWasteDisposalOthers = document.getElementById('wasteDisposalOthers').value;
	
	
	var getwasteStorage = document.getElementById("wasteStorage").value;
	var valuewasteStorageOthers = document.getElementById('wasteStorageOthers').value;
	
	if(getwasteStorage=="Others" && getwasteDisposal=="Others"  )
	{
		if(valueWasteDisposalOthers.length == 0 || valueWasteDisposalOthers == null)
		{
			frmvalidator.addValidation("wasteDisposalOthers","req","’Enter the other waste disposal details");
  		}
  		if(valuewasteStorageOthers.length == 0 || valuewasteStorageOthers == null)
		{
			frmvalidator.addValidation("wasteStorageOthers","req","’Enter the other waste storage details");
		}
		else
		{
			return true;
		}
	}
	
	else if(getwasteStorage=="Others")
	{
		
  		if(valuewasteStorageOthers.length == 0 || valuewasteStorageOthers == null)
		{
			frmvalidator.addValidation("wasteStorageOthers","req","’Enter the other waste storage details");
		}
		else
		{
			return true;
		}
	}
	else if(getwasteDisposal=="Others"  )
	{
		if(valueWasteDisposalOthers.length == 0 || valueWasteDisposalOthers == null)
		{
			frmvalidator.addValidation("wasteDisposalOthers","req","’Enter the other waste disposal details");
  		}
  		
		else
		{
			return true;
		}
	}
	
}
  
 </script> 
	
<script language="JavaScript" type="text/javascript">	 
function getOtherWasteStorage(obj)
{
    if(obj.value=="Others")
    {
        document.getElementById("selectOtherWasteStorage").style.display="block";
        
    }
    else
    {
       document.getElementById("selectOtherWasteStorage").style.display="none";
    }
}	

function getOtherWasteDisposal(obj)
{
    if(obj.value=="Others")
    {
        document.getElementById("selectOtherWasteDisposal").style.display="block";
    }
    else
    {
       document.getElementById("selectOtherWasteDisposal").style.display="none";
    }
}	  
	
	
function otherField(obj)
{
   if(obj.value=="Others")
    {
        document.getElementById(obj.id+"Others").style.display="block";
    }
    else
    {
       document.getElementById(obj.id+"Others").style.display="none";
    }
}


		  
</script>   
		
    <table border="1" width="95%" align="center" cellpadding="0"	cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#CCC" >
			    <td width="5%" align="center" class="headngblue">#</td>
                <td width="8%" align="center" class="headngblue">Schedule</td>
                <!--<td width="20%" align="center" class="headngblue">Name of Process</td>-->
                <td width="20%" align="center" class="headngblue">Name of Process/Class/Part</td>
                <td width="25%" align="center" class="headngblue">Name of Process Waste(Category No)</td>
                <td width="10%" align="center" class="headngblue">Quantity</td>
                <td width="10%" align="center" class="headngblue">Waste Type</td>
                <td width="10%" align="center" class="headngblue">Waste Storage</td>
                <td width="10%" align="center" class="headngblue">Waste Disposal</td>
                <td width="10%" align="center" class="headngblue">Source of generation of waste</td>
                <td width="10%" align="center" class="headngblue">Physical status</td>
                <td width="10%" align="center" class="headngblue">Quantity stored at any time </td>
                <td width="10%" align="center" class="headngblue">Quantity accumulated as on 31st March</td>
                                
              </tr>
       <g:each in="${hazardousWasteDetailsList}" status="i" var="hazardousWasteDetailsListInstance">
  	        <tr align="center" >
  			    <td align="center" class="txt4">${(i+1)}</td>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.schedule}</td>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.source}</td>
  			    <g:if test="${hazardousWasteDetailsListInstance.category.id!=333330}">
  			       <td align="center" class="txt4">${hazardousWasteDetailsListInstance.category}</td>
  			    </g:if>
  			    <g:else>
  			       <td align="center" class="txt4">${hazardousWasteDetailsListInstance.categoryText}</td>
  			    </g:else>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.quantity} <b>${hazardousWasteDetailsListInstance.quantityUnit}</b></td>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.wasteType}</td>
  			    <td align="center" class="txt4"><g:if test="${hazardousWasteDetailsListInstance.wasteStorage!='Others'}">${hazardousWasteDetailsListInstance.wasteStorage}</g:if><g:else>${hazardousWasteDetailsListInstance.wasteStorageOthers}</g:else></td>
  			    <td align="center" class="txt4"><g:if test="${hazardousWasteDetailsListInstance.wasteDisposal!='Others'}">${hazardousWasteDetailsListInstance.wasteDisposal}</g:if><g:else>${hazardousWasteDetailsListInstance.wasteDisposalOthers}</g:else></td>
  			    <td align="center" class="txt4">${hazardousWasteDetailsListInstance.sourceOfWaste}</td>
                <td align="center" class="txt4">${hazardousWasteDetailsListInstance.physicalStatus}</td>
                <td align="center" class="txt4">${hazardousWasteDetailsListInstance.qtyStored} <b>${hazardousWasteDetailsListInstance.qtyStoredUnit}</b></td>
                <td align="center" class="txt4">${hazardousWasteDetailsListInstance.qtyAccumalated} <b>${hazardousWasteDetailsListInstance.qtyAccumalatedUnit}</b></td>
  			    	
           </tr>		
       </g:each>	
       	     <g:if test="${hazardousWasteDetailsList.size()==0}">
  			       <td colspan="12" >No records Founds...</td>
  			    </g:if>


	</table>		  
		  
		  	 
</body>
