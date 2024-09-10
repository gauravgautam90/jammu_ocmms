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
        
        <g:form name="waterSourceUses" method="post" action="deleteRecyclableHazardousWaste" >
		<table width="95%"  border="0" align="center">
              <tr>
                   <td>
                        <br>
		                <table width="100%"   border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
             				<tr bgcolor="#D1D1D1">
            					<td colspan="11" style="font-size:13px;" align="center" valign="middle"  class="headngblue">Recyclable hazardous wastes in Schedule-IV procured per annum</td>
			            	</tr>
				        </table>
						
                   </td>
              </tr>
             
		</table>

		
	<br>
    <table border="1" width="95%" align="center" cellpadding="0"	cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#CCC" >
			    <td width="5%" align="center" class="headngblue">#</td>
                <td width="55%" align="center" class="headngblue">Hazardous Wastes Type</td>
                <td width="10%" align="center" class="headngblue">Passbook Type</td>
                <td width="15%" align="center" class="headngblue">Quantity</td>
                <td width="15%" align="center" class="headngblue">Source<br>(Domestic/Imported)</td>
                <td width="15%" align="center" class="headngblue">Delete</td>
             </tr>
       <g:each in="${recyclableHazardousWasteHWMList}" status="i" var="recyclableHazardousWasteHWMListInstance">
  	        <tr align="center" >
  			    <td align="center" class="txt4">${(i+1)}</td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.hazardousWasteType}</td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.passbookType}</td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.quantity} <b>${recyclableHazardousWasteHWMListInstance.quantityUnit}</b></td>
  			    <td align="center" class="txt4">${recyclableHazardousWasteHWMListInstance.source}</td>
  			    <td align="center" class="txt4"><span class="txt style6"><input type="checkbox" name="delete" value="<%=recyclableHazardousWasteHWMListInstance.id%>" /></span></td>
  		   </tr>		
       </g:each>	
       	        <g:if test="${recyclableHazardousWasteHWMList.size()==0}">
  			       <tr><td colspan="6" >No records Founds...</td><tr>
  			    </g:if>
  			    <g:else>
  			        <tr border="0"  bgcolor="#F4F7FB">
 					    <td align="center" colspan="6"><input type="hidden" name="appId" value="<%=recyclableHazardousWasteHWMList[0].application.id%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
 					</tr>
  			    </g:else>
  			    


	</table>		  
    </g:form>
		  	 
</body>
