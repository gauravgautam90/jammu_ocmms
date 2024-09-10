<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

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

</script>

<script language="javascript" type="text/javascript">
var flag=0;   
var cur_click="btn_1";
function chg_color_over(data){
document.getElementById("btn_"+data).style.background="url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}')";
}
function chg_color_out(data){
if(flag==0)
	document.getElementById("btn_"+data).style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";

else
	{
	if(cur_click!="btn_"+data)
	document.getElementById("btn_"+data).style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
	}
}


function chg_color_click(data){
document.getElementById('btn_1').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
document.getElementById('btn_2').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
document.getElementById('btn_3').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
document.getElementById('btn_4').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
document.getElementById('btn_5').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
document.getElementById('btn_6').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
document.getElementById('btn_7').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";
//document.getElementById('btn_8').style.background="url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}')";

document.getElementById("btn_"+data).style.background="url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}')";
flag=1;
cur_click="btn_"+data;
}

</script>





<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- code for menuIndustryHorizontal-->
		<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<g:include controller="userMaster" action="showSpcbIndustryMenu"/>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>
              <tr>
                <td height="24" bgcolor="#EEEEF3">&nbsp;</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">&nbsp;</span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
							<tr>
                              <td  width="25%" align="center" class="top-lnks" onmouseover="chg_color_over('1')" onclick="chg_color_click('1')" onmouseout="chg_color_out('1')" ><div style="background:url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}'); height:27px;" id="btn_1" name="btn_1"><a href="#" rel="country1">General</a></div></td>
                        
							  <td  width="25%" align="center"  class="top-lnks" onmouseover="chg_color_over('2')" onclick="chg_color_click('2')"  onmouseout="chg_color_out('2')"><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); background-repeat:no-repeat; height:27px;" id="btn_2" name="btn_2"><a href="#" rel="country2">Product</a></div></td>						  
                              <td  width="25%" align="center" class="top-lnks" onmouseover="chg_color_over('3')" onclick="chg_color_click('3')" onmouseout="chg_color_out('3')" ><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); height:27px;" id="btn_3" name="btn_3"><a href="#" rel="country3">Fee Details</a></div></td>
                        
							  <td width="25%"  height="27" align="center"  class="top-lnks" onmouseover="chg_color_over('4')" onclick="chg_color_click('4')"  onmouseout="chg_color_out('4')"><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); background-repeat:no-repeat; height:27px;" id="btn_4" name="btn_4"><a href="#" rel="country4">Water Emision/ Discharge</a></div></td>				
							</tr>
							
							<tr>
                              <td  width="25%" align="center" class="top-lnks" onmouseover="chg_color_over('5')" onclick="chg_color_click('5')" onmouseout="chg_color_out('5')" ><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); height:27px;" id="btn_5" name="btn_5"><a href="#" rel="country5">Effluent Standards</a></div></td>
                        
							  <td  width="25%" align="center"  class="top-lnks" onmouseover="chg_color_over('6')" onclick="chg_color_click('6')"  onmouseout="chg_color_out('6')"><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); background-repeat:no-repeat; height:27px;" id="btn_6" name="btn_6"><a href="#" rel="country6">Air Emmission</a></div></td>						  
                              <td  width="25%" align="center" class="top-lnks" onmouseover="chg_color_over('7')" onclick="chg_color_click('7')" onmouseout="chg_color_out('7')" ><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); height:27px;" id="btn_7" name="btn_7"><a href="#" rel="country7">Documents</a></div></td>
                        
							  <!--<td width="25%"  height="27" align="center"  class="top-lnks" onmouseover="chg_color_over('8')" onclick="chg_color_click('8')"  onmouseout="chg_color_out('8')"><div style="background:url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}'); background-repeat:no-repeat; height:27px;" id="btn_8" name="btn_8"><a href="#" rel="country8">Documents</a></div></td>	-->			
							  <td width="25%"  height="27" align="center">&nbsp;</td>
							  
							</tr>		
									
							
								
	    </table>
		
		
		
          <div id="country1" >
		  
		  
		  
		  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">General Details </td>
				</tr> 
				
				<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent For*:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>  
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Industry Details</td>
				</tr>  
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name*:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
					  
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Commisioning Year:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Registeration/License No.:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industrial area*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone) :*</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No :* </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-Mail Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>
				
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Occupiers Details </td>
				</tr>
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone) :* </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No. :*</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile No:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>        
				         
					  
					  
				</table>	  
					  
					  
			
			
					  
			</td></tr>
			</table>		  
					                  
                     

				
            <br />
          </div>
		  
		  
		  
		  
		  
		  
          <div id="country2">
		  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="4"  align="center" valign="middle"  class="headngblue">Product Details </td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="30%" align="center" class="headngblue">Product Name </td>
                <td width="20%" align="center" class="headngblue">Quantity</td>
                <td width="20%" align="center" class="headngblue">Unit</td>
                <td width="30%" align="center" class="headngblue">Product/By Product </td>
              </tr>
			  
 			<!-- <g:each in="${indProductDetailsInstanceList}" status="i" var="indProductDetailsInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                  <td class="headngblue" align="center"  >${fieldValue(bean:indProductDetailsInstance, field:'product')}</td>
                  <td class="headngblue" align="center" >${fieldValue(bean:indProductDetailsInstance, field:'quantity')}</td>
                  <td class="headngblue" align="center" >${fieldValue(bean:indProductDetailsInstance, field:'unit')}</td>
                  <td class="headngblue" align="center" >${fieldValue(bean:indProductDetailsInstance, field:'byProduct')}</td>
                </tr>
              </g:each>-->
			  
			  <tr >
                <td   align="center" class="headngblue">Value </td>
                <td  align="center" class="headngblue">Value</td>
                <td  align="center" class="headngblue">Value</td>
                <td  align="center" class="headngblue">Value</td>
              </tr>
			  
		  
		  
		  </table>	  
					  
					  
			
			
					  
			</td></tr>
			</table>		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  <div id="country3">
		  
		   <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Fee Details (Water Consumptions) </td>
				</tr> 
							
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment (In Lakhs):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable (In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Notifications/Rules Applied </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hazardous Waste Rule 1989</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Environment Clearence Rule </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Outstanding dues from Industry (In Rupees):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Outstanding amount with Board (In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Fee Applied </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Bank Details</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<!-- code for Bank Details-->
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="20%" align="center"   > DD/Cheque No </td>
							  <td width="10%" align="center" >Date</td>
							  <td width="30%" align="center" >Bank Name</td>
							  <td width="30%" align="center" >Branch Name</td>
							  <td width="10%" align="center" >Amount</td>
							  
						    </tr>
						  <tr>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value </td>
						  </tr>
						</table>
					
					</td>
				</tr> 
				
				
				
				
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  

		  
            <br />
          </div>
		  
		  
		  
		  
		  <div id="country4">
		  
		  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td   align="center" valign="middle"  class="headngblue">Water Consumption</td>
				</tr> 
				
				<tr><td>
					
					<table width="100%"  border="0" >
			
				<tr bgcolor="#A8DAF3">
					<td colspan="2" width="50%" align="center" valign="middle"  class="headngblue">Water Consumption  </td>
					<td colspan="2" width="50%" align="center" valign="middle"  class="headngblue">Maximum Waste Water Generation  </td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td  width="35%" align="center" class="headngblue">Select Mode  </td>
                <td width="15%" align="center" class="headngblue">Quantity (Kl/D)</td>
                <td width="35%" align="center" class="headngblue">Select Mode </td>
                <td width="15%" align="center" class="headngblue">Quantity (Kl/D) </td>
              </tr>

			  <tr >
                <td   align="center" class="headngblue">Value </td>
                <td  align="center" class="headngblue">Value</td>
                <td  align="center" class="headngblue">Value</td>
                <td  align="center" class="headngblue">Value</td>
              </tr>
		  </table>
						
				</td></tr>
				<tr bgcolor="#D1D1D1">
					<td   align="center" valign="middle"  class="headngblue">Water Discharge</td>
				</tr> 
				
				
				
				<tr><td>
					<table width="100%">
					  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="center"   > Waste Water Type  </td>
							  <td width="15%" align="center" >Maximum Effluent Generation </td>
							  <td width="10%" align="center" >Effluent To Be Recycled </td>
							  <td width="15%" align="center" >Effluent To Be Disposed/Discharged </td>
							  <td width="30%" align="center" >Disposal Mode </td>
							  
						    </tr>
						  <tr>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value </td>
						  </tr>
					</table>
				</td></tr> 
				
				
		 	 </table>	  
					  
			  
			</td></tr>
			</table>
		  
		  
		  
		  
		  
		  
		  
		  
		  
           
            <br />
          </div>
		  
		  
		  <div id="country5">
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="4"  align="center" valign="middle"  class="headngblue">Effluent Standards </td>
				</tr> 
				
				<tr bgcolor="#A8DAF3" >
                <td width="25%" align="center" class="headngblue">Effluent Type* </td>
                <td width="25%" align="center" class="headngblue">Standards*</td>
                <td width="25%" align="center" class="headngblue">Parameter</td>
                <td width="25%" align="center" class="headngblue">Parameter Standard  </td>
              </tr>
			  
 			<!-- <g:each in="${indProductDetailsInstanceList}" status="i" var="indProductDetailsInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                  <td class="headngblue" align="center"  >${fieldValue(bean:indProductDetailsInstance, field:'product')}</td>
                  <td class="headngblue" align="center" >${fieldValue(bean:indProductDetailsInstance, field:'quantity')}</td>
                  <td class="headngblue" align="center" >${fieldValue(bean:indProductDetailsInstance, field:'unit')}</td>
                  <td class="headngblue" align="center" >${fieldValue(bean:indProductDetailsInstance, field:'byProduct')}</td>
                </tr>
              </g:each>-->
			  
			  <tr >
                <td   align="center" class="headngblue">Value </td>
                <td  align="center" class="headngblue">Value</td>
                <td  align="center" class="headngblue">Value</td>
                <td  align="center" class="headngblue">Value</td>
              </tr>
			  
		  
		  
		  </table>	  
					  
					  
			
			
					  
			</td></tr>
			</table>
		  
            <br />
          </div>
		  
		  
		  
		  <div id="country6">
             <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Air (Stack) Emission Details</td>
				</tr> 
				
				<!--<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Selected Option:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">Stack Emission</td>
				</tr>--> 
				
				<tr>
					<td colspan="2">
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="20%" align="center" >Stack to Plant</td>
							  <td width="20%" align="center" >Source Capacity</td>
							  <td width="20%" align="center" >Source Unit</td>
							  <td width="20%" align="center" >Prescribed Parameter</td>
							  <td width="20%" align="center" >Pescribed Standards</td>
							  
						    </tr>
						  <tr>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value </td>
						  </tr>
						</table>
					</td>
				</tr> 
								
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Height in Meters*:</td>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr>
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Control Measures*:</td>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">
						<select name="" size="3" multiple="MULTIPLE">
								  <option selected="selected">Bag Filter</option>
								  <option>Bag House</option>
								  <option selected="selected">Caustic Scrubber</option>
								  <option>Cooling Chamber</option>
								  <option>Cyclone</option>
								  <option>ESP</option>
						</select>
					</td>
				</tr> 
				
				<tr>
					<td colspan="2">
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="20%" align="center" >Fuel Type</td>
							  <td width="20%" align="center" >Fuel Name</td>
							  <td width="20%" align="center" >Fuel Quantity</td>
							  <td width="10%" align="center" >Unit</td>
							  <td width="20%" align="center" >Capacity</td>
							  <td width="10%" align="center" >Unit</td>
						    </tr>
						  <tr>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value </td>
						  </tr>
						</table>
					</td>
				</tr> 
				
				<tr bgcolor="#D1D1D1"><td align="center" colspan="2" class="headngblue">Fugitive Emission</td></tr>
				<!--aa-->
				<!--<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Selected Option:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">Fugitive Emission</td>
				</tr>-->
				
				<tr>
					<td colspan="2">
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="33%" align="center" >Source of Fugitive Emission</td>
							  <td width="33%" align="center" >Prescribed Parameter</td>
							  <td width="34%" align="center" >Pescribed Standards</td>
							  
						    </tr>
						  <tr>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
						  </tr>
						</table>
					</td>
				</tr> 
				
				
				<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Control Measures</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">
						<select name="" size="5" multiple="MULTIPLE">
								  <option selected="selected">Bag Filter</option>
								  <option selected="selected">Bag House</option>
								  <option>Caustic Scrubber</option>
								  <option selected="selected">Cooling Chamber</option>
								  <option>Cyclone</option>
								  <option>ESP</option>
						</select>
					</td>
				</tr>
				 
				<!--aa-->
				
				
				
				<tr bgcolor="#D1D1D1"><td align="center" colspan="2" class="headngblue">Ambient Air Quality Standards</td></tr>
				<!--aa-->
				<!--<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Selected Option:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">Ambient Air Quality Standards</td>
				</tr>-->
				
				<tr>
					<td colspan="2">
						<table width="100%" border="0" >
						  <tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="38%" align="center" >&nbsp;</td>
							  <td width="5%" align="center" >Selected Option</td>
							  <td width="37%" align="center" >Area Category</td>
							  <td width="5%" align="center" >SPM</td>
							  <td width="5%" align="center" >SO</td>
							  <td width="5%" align="center" >CO</td>
							  <td width="5%" align="center" >NOx</td>
							  
							  
						    </tr>
						  <tr bgcolor="#E8F6F9">
							<td rowspan="3" align="center" class="headngblue">Ambient Air Quality Standards</td>
							<td  align="center" class="headngblue"><input type="checkbox" name="checkbox" value="checkbox" /></td>
							<td  align="center" class="headngblue">Industrial and mixed use</td>
							<td  align="center" class="headngblue">Value </td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value</td>
							<td  align="center" class="headngblue">Value </td>
						  </tr>
						  
						  <tr bgcolor="#A8DAF3">
							 <td align="center" class="headngblue"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
							  <td  align="center" class="headngblue">Residential and Rural</td>
							  <td  align="center" class="headngblue">Value </td>
							  <td  align="center" class="headngblue">Value</td>
							  <td  align="center" class="headngblue">Value</td>
							  <td  align="center" class="headngblue">Value </td>
							  
							  
						    </tr>
							
						<tr bgcolor="#E8F6F9">
							  <td align="center"><input type="checkbox" name="checkbox3" value="checkbox" /></td>
							  <td align="center" class="headngblue">Sensative</td>
							  <td  align="center" class="headngblue">Value </td>
							  <td  align="center" class="headngblue">Value</td>
							  <td  align="center" class="headngblue">Value</td>
							  <td  align="center" class="headngblue">Value </td>
							  
						    </tr>	
						  
						</table>
					</td>
				</tr>  
				
				<!--aa-->
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  <div id="country7">
            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">Documents Details </td>
				</tr> 
				
				<tr>
				<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Letter of Land Allotment </td>
					<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue"><a href="#">Download</a></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Project Report</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><a href="#">Download</a></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Article of Memorandom / partnership deed</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><a href="#">Download</a></td>
				</tr>
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Site Plan</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><a href="#">Download</a></td>
				</tr>
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Infrastructure Report</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><a href="#">Download</a></td>
				</tr>
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  
            <br />
          </div>
		  
		  
		  
		  
		  
		  <!--
		  <div id="country8">
		  
		   <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">General Details </td>
				</tr> 
				
				<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  

            <br />
          </div>  -->
		  
		   <table width="100%">
				<tr >
					<td align="center"><input type="submit" name="Edit" value="Edit" class="actionbutton"></td>
					<!--<td align="center"><input type="submit" name="cancel" value="Cancel" class="actionbutton"></td>-->
			  	</tr>
				<tr>
					<td >&nbsp;</td>
				</tr>
		  </table>
		  
		  
		  
		  
		  
		  
          </div>
	  
		  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>
</body>
</html>


