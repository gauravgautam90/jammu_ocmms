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
<table align="center" width="100%">

	<tr align="center">

		<td width="100%" align="center">

		<div>





		
		<div >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td  align="center" valign="middle"  class="headngblue">Waste Disposal Details</td>
				</tr> 
 					<tr><td><table width="100%">
 					
 					<tr bgcolor="#A8DAF3" >
			  
			  <td width="25%" align="center" class="headngblue">Type</td>
                <td  width="25%" align="center" class="headngblue">Category</td>
                <td width="25%" align="center" class="headngblue">Quantity</td>
                  <td width="25%" align="center" class="headngblue">Unit</td>
               
              	</tr>
 <g:each in="${wasteDisposalList}" status="i" var="WasteDisposalDetails">
  	<tr align="center" >
  	 <td bgcolor="#E8F6F9"><span class="txt style6">${WasteDisposalDetails.type}
                        </span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${WasteDisposalDetails.category}
                        </span></td>
                       
                       
                        <td bgcolor="#E8F6F9"><span class="txt style6">${WasteDisposalDetails.quantity}
                        </span></td>
                       
                  <td bgcolor="#E8F6F9"><span class="txt style6">${WasteDisposalDetails.unit.unitName} </span></td>        
    </tr>		
 </g:each>		
 					
 			

		</table>
		</td>
	</tr>



</table>

		</div>
		</div>
		</td>
	</tr>

<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { 
	
	%>
<!--<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/eEWaste/spcbShowForm?appliId=<%=appDetId%>#country5', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>-->
<%}}%>




	<!-- <tr>

    <td align="center" height="1" colspan="2" bgcolor="#d0d1d0"><input type="button" name="back" value="Back" onclick="history.back()" class="actionbutton"></td>
		  
  </tr> -->
</table>
</body>