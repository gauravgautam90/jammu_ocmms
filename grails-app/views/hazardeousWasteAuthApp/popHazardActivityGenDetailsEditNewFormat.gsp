<head>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</g:javascript>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
</head>
<body>
           
      <g:form name="waterSourceUses" method="post" action="deleteHazardGenDetailsNewFormat" >
      
      <table width="95%"  border="0" align="center">
              <tr>
                   <td>
		                <table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
             				<tr bgcolor="#D1D1D1">
            					<td colspan="10"  align="center" valign="middle"  class="headngblue">Hazardous Waste Generation Details</td>
			            	</tr>
			            </table>
			       </td>
			  </tr>
		   </table>    
			
			<br>


    <table border="1" width="95%" align="center" cellpadding="0" cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#A8DAF3" >
			     <td width="5%" align="center" class="headngblue">#</td>
                <td width="8%" align="center" class="headngblue">Schedule</td>
                <td width="20%" align="center" class="headngblue">Name of Process</td>
                <td width="25%" align="center" class="headngblue">Name of Process Waste(Category No)</td>
                <td width="10%" align="center" class="headngblue">Quantity</td>
                <td width="10%" align="center" class="headngblue">Waste Type</td>
                <td width="10%" align="center" class="headngblue">Waste Storage</td>
                <td width="10%" align="center" class="headngblue">Waste Disposal</td>
                <td width="10%" align="center" class="headngblue">Source of generation of waste</td>
                <td width="10%" align="center" class="headngblue">Physical status</td>
                <td width="10%" align="center" class="headngblue">Quantity stored at any time </td>
                <td width="10%" align="center" class="headngblue">Quantity accumulated as on 31st March</td>
                <td width="10%" align="center" class="headngblue">Delete</td>
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
                <td align="center" class="txt4">${hazardousWasteDetailsListInstance.qtyStored}<b>${hazardousWasteDetailsListInstance.qtyStoredUnit}</b></td>
                <td align="center" class="txt4">${hazardousWasteDetailsListInstance.qtyAccumalated} <b>${hazardousWasteDetailsListInstance.qtyAccumalatedUnit}</b></td>
  			    <td align="center" class="txt4"><span class="txt style6"><input type="checkbox" name="delete" value="<%=hazardousWasteDetailsListInstance.id%>" /></span></td>
           </tr>		
       </g:each>	
       	        <g:if test="${hazardousWasteDetailsList.size()==0}">
  			       <td colspan="13" >No records Founds...</td>
  			    </g:if>
  			    <g:else>
  			        <tr border="0"  bgcolor="#F4F7FB">
 					    <td align="center" colspan="13"><input type="hidden" name="appId" value="<%=hazardousWasteDetailsList[0].application.id%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
 					</tr>
  			    </g:else>
  			    


	</table>
	</g:form>

</body>