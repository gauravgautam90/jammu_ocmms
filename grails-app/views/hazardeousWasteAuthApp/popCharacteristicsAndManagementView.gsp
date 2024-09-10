<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<style>
td {
     overflow: hidden;
    height: 25px;
}
</style>
<g:javascript library="prototype" />


			
			
		
			


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
       
        <br>
		<table width="95%"  border="0" align="center">
              <tr>
                   <td>
		                <table width="100%"   border="1" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">
             				<tr bgcolor="#D1D1D1">
            					<td colspan="11"  align="center" valign="middle"  class="headngblue"><br>Details of characteristics and management of wastes within the plant<br><br></td>
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

		
    <table border="1" width="95%" align="center" cellpadding="0"	cellspacing="0" class="tblbdr" bordercolor="black">

			 <tr bgcolor="#CCC" >
			    <input type="hidden" name="id" value="${appDetId}">
			    <td align="center" class="headngblue">#</td>
                <td align="center" class="headngblue">Schedule</td>
                <td align="center" class="headngblue">Name of Process</td>
                <td align="center" class="headngblue">Name of Hazardous Waste (Category No)</td>
                <td  align="center" class="headngblue">Quantity</td>
                <td  align="center" class="headngblue">Characterisitics of each waste</td>
                <td  align="center" class="headngblue">Details of utilization within the plant such as SLF,etc</td>
                <td  align="center" class="headngblue">If not utilised within the plant, provide details of what is done with this waste</td>
                <td  align="center" class="headngblue">Details of arrangements for transportation to actual users/ TSDF</td>
                <td  align="center" class="headngblue">Details of the environmental safeguards and environmental facilities provided for safe handling </td>                                
              </tr>
       <g:each in="${hazardousWasteDetailsList}" status="i" var="hazardousWasteDetailsListInstance">
  	        <tr align="center" >
  	            <%
  	                def instCharacteristicsAndManagementHWM=CharacteristicsAndManagementHWM.findByWasteDetails(hazardousWasteDetailsListInstance);
  	                
  	            %>
  	            <input type="hidden" name="hazardousWasteDetailsId" value="${hazardousWasteDetailsListInstance.id}">
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
  			    <td align="center" class="txt4"><input readonly style="width:100px;" class="txt4" type="text" value="${instCharacteristicsAndManagementHWM?.characterisitics}" name="characterisitics" id="characterisitics"></td>
  			    <td align="center" class="txt4"><input readonly style="width:100px;" class="txt4" type="text" value="${instCharacteristicsAndManagementHWM?.utilization}" name="utilization" id="utilization"></td>
  			    <td align="center" class="txt4"><input readonly style="width:100px;" class="txt4" type="text" value="${instCharacteristicsAndManagementHWM?.ifNotUtilized}" name="ifNotUtilized" id="ifNotUtilized"></td>
  			    <td align="center" class="txt4"><input readonly style="width:100px;" class="txt4" type="text" value="${instCharacteristicsAndManagementHWM?.arrangementsForTransportation}" name="arrangementsForTransportation" id="arrangementsForTransportation"></td>
  			    <td align="center" class="txt4"><input readonly style="width:100px;" class="txt4" type="text" value="${instCharacteristicsAndManagementHWM?.environmentalSafeguards}" name="environmentalSafeguards" id="environmentalSafeguards"></td>	
           </tr>		
       </g:each>	
       	     <g:if test="${hazardousWasteDetailsList.size()==0}">
  			       <tr><td colspan="12" >No records Founds...</td></tr>
  			    </g:if>
  			    
  			    
  			     
              


	</table>		  
  
		  	 
</body>
