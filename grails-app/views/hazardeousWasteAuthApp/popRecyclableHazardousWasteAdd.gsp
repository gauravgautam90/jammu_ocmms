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

function set_disabled() 
	{
      document.getElementById("passbookType").disabled = true;
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

        <g:form name="myForm" method="post" action="saveRecyclableHazardousWaste" >
        
		<table width="95%"  border="0" align="center">
              <tr>
                   <td>
                        <br>
		                <table width="100%"   border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
             				<tr bgcolor="#D1D1D1">
            					<td colspan="11" style="font-size:13px;" align="center" valign="middle"  class="headngblue">Recyclable hazardous wastes in Schedule-IV procured per annum</td>
			            	</tr>
				        </table>
						<br>	
						<br>
						<table style="border-collapse:collapse;" width="100%" border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
				            <tr>
				            <% String cont=request.getContextPath() 
				            System.out.println("cont---"+cont);%>
				                <input type="hidden" name="appId" id="appId" value="${appId}">
			                    <td style="width:30%;" align="center"><b>Hazardous Wastes Type</b>&nbsp;
			                        <g:select onchange="new Ajax.Request('${cont}/hazardeousWasteAuthApp/updatePassbookType',{asynchronous:true,evalScripts:true,onComplete:function(e){updatePassbookType(e)},parameters:'menu1=' + escape(this.value)});" name="hazardousWasteType" id="hazardousWasteType" noSelection="${['':'Select Hazardous Waste Type']}" from="['Brass Dross','Copper Dross','Copper Oxide mill scale','Copper reverts, cake and residue','Waste Copper and copper alloys in dispersible from','Slags from copper processing for further processing or refining','Insulated Copper Wire Scrap or copper with PVC sheathing including ISRI-code material namely Druid','Jelly filled Copper cables','Spent cleared metal catalyst containing copper','Spent catalyst containing nickel, cadmium, Zinc, copper, arsenic, vanadium and cobalt','Zinc Dross-Hot dip Galvanizers SLAB','Zinc Dross-Bottom Dross','Zinc ash/Skimmings arising from galvanizing and die casting operations','Zinc ash/Skimming/other zinc bearing wastes arising from smelting and refining','Zinc ash and residues including zinc alloy residues in dispersible from','Spent cleared metal catalyst containing zinc','Used Lead acid battery including grid plates and other lead scrap/ashes/residues not covered under Batteries (Management and Handling) Rules, 2001. (Battery scrap, namely: Lead battery plates covered by ISRI, Code word Rails Battery lugs covered by ISRI, Code word Rakes. Scrap drained/dry while intact, lead batteries covered by ISRI, Code word rains.','Components of waste electrical and electronic assembles comprising accumulators and other batteries included in Part A of Schedule III, mercury-switches, activated glass cullets from cathode-ray tubes and other activated glass and PCB-capacitors, or any other component contaminated with Schedule II constituents (e.g. cadmium, mercury, lead, polychlorinated biphenyl) to an extent that they exhibit hazard characteristics indicated in part C of Schedule III.','Paint and ink Sludge/residues','Used oil and waste oil']" style="width:200px;" class="txt4"></g:select>
			                    </td>
			                    
			                    <td style="width:21%;" align="center" ><b>Passbook Type</b>&nbsp;
			                        <input type="text" name="passbookType" id="passbookType" style="width:150px;" class="txt4" readOnly>
			                        <!--<g:select name="passbookType" id="passbookType" noSelection="${['':'Select Passbook Type']}" from="['Non Ferrous other than Lead','Lead bearing','E-wastes','Used /waste Oil']" style="width:150px;" class="txt4" ></g:select>-->
			                    </td>
				                
				                <td style="width:26%;" align="center"><b>Quantity</b>&nbsp;
				                    <input type="text" name="quantity" id="quantity" style="width:150px;" class="txt4">
			                        &nbsp;<g:select name="quantityUnit" id="quantityUnit" noSelection="${['':'Select unit']}" from="['T/Annum','KL/Annum']" style="width:90px;" class="txt4"></g:select>
			                    </td>
			                    
			                    <td style="border: none;" align="center"><b>Source (Domestic/Imported)</b></td>
				                <td style="border: none;" align="center"><input type="text" name="source" id="source" style="width:150px;" class="txt4"></td>
			                 </tr>
			                 
			                 <tr>
                                  <td colspan="5" align="center"><input style="cursor:pointer;background-color:#CCC;color: black;padding: 5px 20px;text-align: center;display:inline-block;font-size:12px;" type="submit" name="Add" value="Add" ></td>
                             </tr>
               		     </table>
                   </td>
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
  frmvalidator.addValidation("hazardousWasteType","req","Please select Hazardous Waste Type");
  frmvalidator.addValidation("passbookType","req","Please select Passbook Type");
  frmvalidator.addValidation("quantity","req","Please enter Quantity");
  frmvalidator.addValidation("quantity","decimal","Quantity should be numeric or decimal"); 
  frmvalidator.addValidation("quantityUnit","req","Please select Quantity unit");
  frmvalidator.addValidation("source","req","Please select source");
  
  </script> 
  
  <script language="JavaScript" type="text/javascript">
  function updatePassbookType(e)
  {
     var value=e.responseText;
     document.getElementById("passbookType").value=value;
  }
  
 </script> 
 
	
    <table border="1" width="95%" align="center" cellpadding="0"	cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#CCC" >
			    <td width="5%" align="center" class="headngblue">#</td>
                <td width="55%" align="center" class="headngblue">Hazardous Wastes Type</td>
                <td width="10%" align="center" class="headngblue">Passbook Type</td>
                <td width="15%" align="center" class="headngblue">Quantity</td>
                <td width="15%" align="center" class="headngblue">Source<br>(Domestic/Imported)</td>
             </tr>
       <g:each in="${recyclableHazardousWasteHWMList}" status="i" var="recyclableHazardousWasteHWMListInstance">
  	        <tr align="center" >
  			    <td align="center" class="txt4">${(i+1)}</td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.hazardousWasteType}</td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.passbookType}</td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.quantity} <b>${recyclableHazardousWasteHWMListInstance.quantityUnit}</b></td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.source}</td>
  		   </tr>		
       </g:each>	
       	     <g:if test="${recyclableHazardousWasteHWMList.size()==0}">
  			       <tr><td colspan="5" >No records Founds...</td></tr>
  			    </g:if>


	</table>		  
		  
		  	 
</body>
