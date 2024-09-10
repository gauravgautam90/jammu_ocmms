<%@ page import="java.text.SimpleDateFormat"%>
<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<calendar:resources lang="en" theme="aqua"/>
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

<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px; align:center" >
 <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >
 					
 <tr><td> <span class="txt" style="color: navy"><b>List of Water Budget Details added.</b></span>
	<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
	<tr bgcolor="#A8DAF3">
	<td></td>
	<td></td>
	<td>Water Consumption(in KLD)</td>
	
	<td></td>
	<td>Effluent Generation(in KLD)</td>
	<td></td>
	</tr>
	
	<tr bgcolor="#A8DAF3" >
	<td  width="35%" align="center" class="headngblue" >S.No.</td>
 <td  width="35%" align="center" class="headngblue">Type</td>
 
 <td width="15%" align="center" class="headngblue">Present</td>
 <td width="15%" align="center" class="headngblue">Previous</td>
 <td width="15%" align="center" class="headngblue">Present</td>
 <td width="15%" align="center" class="headngblue">Previous</td>
 
 </tr>

 <g:each in="${waterBudgetList}" status="i" var="waterBudgetList">
 <tr align="center" >
	<td rowspan="4"><span class="txt style6">
	<%=i+1%></span></td>
	
	<td ><span class="txt style6">
		${waterBudgetList.waterbudgettype}</span></td>
                     <td ><span class="txt style6">${waterBudgetList.wcpresent}
                     </span></td>
                     <td ><span class="txt style6">${waterBudgetList.wcprevious}
                     </span></td>
                     <td ><span class="txt style6">${waterBudgetList.egpresent}
                     </span></td>
                     <td ><span class="txt style6">${waterBudgetList.egprevious}
                     </span></td> </tr>
                 <tr align="center">   <td ><span class="txt style6">
					${waterBudgetList.waterbudgettype2}</span></td>
                         <td ><span class="txt style6">${waterBudgetList.wcpresent2}
                         </span></td>
                         <td ><span class="txt style6">${waterBudgetList.wcprevious2}
                         </span></td>
                         <td ><span class="txt style6">${waterBudgetList.egpresent2}
                         </span></td>
                         <td ><span class="txt style6">${waterBudgetList.egprevious2}
                         </span></td> </tr>
                       <tr align="center">  <td ><span class="txt style6">
     					${waterBudgetList.waterbudgettype3}</span></td>
                             <td ><span class="txt style6">${waterBudgetList.wcpresent3}
                             </span></td>
                             <td ><span class="txt style6">${waterBudgetList.wcprevious3}
                             </span></td>
                             <td ><span class="txt style6">${waterBudgetList.egpresent3}
                             </span></td>
                             <td ><span class="txt style6">${waterBudgetList.egprevious3}
                             </span></td> </tr>
                          <tr align="center">   <td ><span class="txt style6">
           					${waterBudgetList.waterbudgettype4}</span></td>
                                 <td ><span class="txt style6">${waterBudgetList.wcpresent4}
                                 </span></td>
                                 <td ><span class="txt style6">${waterBudgetList.wcprevious4}
                                 </span></td>
                                 <td ><span class="txt style6">${waterBudgetList.egpresent4}
                                 </span></td>
                                 <td ><span class="txt style6">${waterBudgetList.egprevious4}
                                 </span></td>
                     
                           
 </tr>		
</g:each>		
 				
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>
 
<tr >
<td align="center">
<% if(type=="REGULAR"){
		System.out.println("type...."+type)
		%>
	
	<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

		()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
			
	<%}else{%>
   
		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

	<%}%></td></tr>	
</td></tr>
</table>

 		  	 
</body>