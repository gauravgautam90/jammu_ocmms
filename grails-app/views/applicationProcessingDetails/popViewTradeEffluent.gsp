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
 					
 				<tr><td> <span class="txt" style="color: navy"><b>List of Trade Effluent Details added.</b></span>
 				<table border="1" class="tblbdr" cellpadding="0" cellspacing="0" bordercolor="black">
 				<tr bgcolor="#A8DAF3" >
 				
                <td  width="25%" align="center" class="headngblue">Date of Sampling and Sample collected by</td>
                <td width="25%" align="center" class="headngblue">pH</td>
                <td width="25%" align="center" class="headngblue">D.O in(mg/l)</td>
                <td width="25%" align="center" class="headngblue">B.D.O in(mg/l)</td>
                <td width="25%" align="center" class="headngblue">C.O.D in(mg/l)</td>
                <td width="25%" align="center" class="headngblue">SS in(mg/l)</td>
                <td width="25%" align="center" class="headngblue">O&G in(mg/l)</td>
                <td width="25%" align="center" class="headngblue">Other Relevant Parameters</td>
              	</tr>
 <g:each in="${tradeEffulentList}" status="i" var="tradeEffulentList">
  	<tr align="center" >
  	<%def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
  	def x=tradeEffulentList.doss
  	def date2=sdfh.format(x)

  	%>
  	
  					<td ><span class="txt style6">${date2}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.ph}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.doin}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.bdo}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.cod}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.ss}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.og}
                        </span></td>
                        <td ><span class="txt style6">${tradeEffulentList.other}
                        </span></td>
                              
    </tr>		
 </g:each>		
 					
 			<!--		
 		<tr><td ><span class="txt style6">Licencesed Annual Capacity Of the Factory
                        </span></td>
                        <td><input class="txt4" type="text" value="${d}" readonly name="annualProdCap"/></td>			
 					</tr>
 			-->		
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div>

</td></tr>
<tr><td align="center">
<% if(type=="REGULAR"){
		System.out.println("type...."+type)
		%>
	
	<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

		()%>/applicationProcessingDetails/inspectionPage/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">
			
	<%}else{%>
   
		<input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath

()%>/applicationProcessingDetails/popConsentInspectionReport/<%=appDetId%>', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');">

	<%}%></td></tr>		

</table>

 		  	 
</body>