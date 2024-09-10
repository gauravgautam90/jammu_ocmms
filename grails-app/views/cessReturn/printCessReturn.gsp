<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
a:link {
	text-decoration: none;
	color: #1E6BBD;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<g:javascript library="prototype" />
<g:javascript>
function createRow(){

alert("hi");
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'templateCess.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>






<%
String cont=request.getContextPath();
 if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(cont+"/index.gsp")  ;     
} %>

</head>
<body>
 <table><tr><td width="299" align="right"><a href="#" onclick="window.print();return false;" ><img  src="${createLinkTo(dir:'images',file:'print.png')}" border="0" align="center" alt="Print this Form" >Print</a></td></tr></table>
<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print">
			
			
				<tr>
                  <td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Month</td>
				  <td width="25%" align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:cessReturnInstance, field:'month')}
				  <td  width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Year :</td>
					<td width="25%"  align="left" bgcolor="#E8F6F9"  class="headngblue">
					${fieldValue(bean:cessReturnInstance, field:'year')}
					</td>
				 
			  </tr> 
				   
				
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'indName')}
					 
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue txt4">${fieldValue(bean:industryRegId, field:'indAddress')}</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Plot No./Khata * : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'plotNo')}
					 
                    </td>
                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${fieldValue(bean:industryRegId, field:'indCity')} 
					  
					</td>
				</tr>        
				    
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${fieldValue(bean:industryRegId, field:'district')}
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'indPin')}
					
					</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reading for First Day of Calender month : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:cessReturnInstance, field:'firstDayReading')}
					
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Reading for Last Day of Calender month  : </td>
				    <td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:cessReturnInstance, field:'lastDayReading')}
					
					</td>
				</tr>        
				
				
				
			
			
			
	</table>
	<g:if test="${cessDetailList}"> 
	
	<g:each in="${cessDetailList}" status="i" var="cessDetailInstance">
	<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print">
	<tr>
		<td  align="left" valign="middle" bgcolor="#A8DAF3" colspan="2" class="headngblue">Purpose of which Water Consumed   :</td>
					<td  align="left" bgcolor="#E8F6F9" colspan="5" class="headngblue">
					  ${cessDetailInstance?.waterConsumptionPurposeMaster?.purpose }
					</td>
	</tr>
	<tr bgcolor="#A8DAF3" class="headngblue"><td >Source Of Consumption</td><td>Meter Reading</td><td>Start Reading</td><td>End Reading</td><td>Quantity (Kl)</td><td>Water Quantity(3 Month Avg.)</td><td>Quantity of water for rebate</td></tr>
	<tr class="headngblue" bgcolor="#E8F6F9"><td>${cessDetailInstance?.waterSourceConsumptionMaster?.source }</td><td>${fieldValue(bean:cessDetailInstance, field:'meterWorking')}</td><td>${fieldValue(bean:cessDetailInstance, field:'startReading')}</td><td>${fieldValue(bean:cessDetailInstance, field:'endReading')}</td><td>${fieldValue(bean:cessDetailInstance, field:'quantity')}</td><td>${fieldValue(bean:cessDetailInstance, field:'threeMonthWaterQtyAvg')}</td><td>${fieldValue(bean:cessDetailInstance, field:'qtyForWaterRebate')}</td></tr>
	<tr><td colspan="2" class="headngblue">Remarks: </td><td bgcolor="#E8F6F9" colspan="5" class="headngblue">${fieldValue(bean:cessDetailInstance, field:'remarks')}</td></tr>
	</table>
	</g:each>
 </g:if>
  
  
  
  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print"  >	
  
  <tr bgcolor="#D1D1D1">
	<td   align="left"  colspan="9" valign="middle" height="10"  class="headngblue tblbdr">&nbsp;</td>
	</tr>            
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Unit of water consumption:</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totunitOfWaterConsumption')}</td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water Consumed:</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totQuantityOfWaterConsumed')}</td>
      </tr>
      
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >3 Months Avg. Water Consumption, if meter not working: </td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'threeMonthsAvgWaterConsumption')}</td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water qualifying for rebate according to the Assesee :</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totQuantityOfWaterRebate')}</td>
      </tr>
    </table>
</body>
</html>