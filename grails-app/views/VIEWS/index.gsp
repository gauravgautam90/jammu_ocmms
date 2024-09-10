<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<META NAME="Author" CONTENT="Designed by Infogain">
<title>Online Consent Management Systems</title>
<style type="text/css">
A {
	 TEXT-DECORATION: none
}

<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #E5E5E5;

}
-->
</style>
<link href="css/stylessheet.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<script type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->

function validateForm()
{
	//var aa = document.form1.elements[1].value;
	//alert("OK..." + aa);
	// check user type .. radio button
	if (!document.form1.elements[0].checked)
	{
		if (!document.form1.elements[1].checked)
		{
		alert ("Please select User Type!");
		return false;
		}
	}
	// check user id
	if (document.form1.elements[2].value == "")
	{
		alert ("Please enter User Id!");
		return false;
	}
	// check password
	if (document.form1.elements[3].value == "")
	{
		alert ("Please enter Password!");
		return false;
	}
	document.getElementById('form1').submit(); 
return true;
}


</script>

    
<script type="text/javascript">


function Calculate()
{
  
			



	var contype;
	var conFor;
	var consent;
	
	if(document.getElementById('consentTypeY').checked==true)
	{
	contype=document.getElementById('consentTypeY').value;
	}
	else
	{
	contype=document.getElementById('consentTypeN').value;
	}

	
	if(document.getElementById('consentForY').checked==true)
	{
	conFor=document.getElementById('consentForY').value;
	}
	else
	{
	if(document.getElementById('consentForB').checked==true)
	{
	conFor=document.getElementById('consentForB').value;
	}
	else
	{
	conFor=document.getElementById('consentForN').value;
	}
	}
	
	
	if(document.getElementById('consentY').checked==true)
	{
	consent=document.getElementById('consentY').value;
	}
	else
	{
	consent=document.getElementById('consentN').value;
	}
	
	
	
	var capitalInvestMent; 
	capitalInvestMent=document.getElementById('capital').value;
	
	var result;
	
	var ValidationRequired;
	ValidationRequired="/^.*(?=.*[0-9]).*$/";
	if(capitalInvestMent=="")
	{
		alert("Please give the Amount.");
		return false;
	}
	else
	{
		
	if(contype=="CTE")
	{	
	
	if(consent=="NEW")
    			{
    			
    			/*if(conFor=="AIR")	
    				{
    				
    					if(capitalInvestMent>100000)
    							{
    							
    								result=1000000*2;
    							}
    						if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
    							{
    							
    								result=500000*2;
    							}
    						if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
    							{
    							
    								result=250000*2;
    							}
    						if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
    							{
    							
    								result=150000*2;
    							}
        		
    						if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
    							{
    							
    								result=100000*2;
    							}
    						if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
    							{
    							
    								result=80000*2;
    							}
    						if(capitalInvestMent>300 && capitalInvestMent <= 1000)
    							{
    							
    								result=60000*2;
    							}
    						if(capitalInvestMent>200 && capitalInvestMent <= 300)
    							{
    							
    								result=3000*2;
    							}
    						if(capitalInvestMent>100 && capitalInvestMent <= 200)
    							{
    							
    								result=2000*2;
    							}
    						if(capitalInvestMent<=100)
    							{
    							
    								result=1000*2;
    							}
    			
    					}*/
    					if(conFor!="BOTH")	//if(conFor=="WATER")
    					{
    					
    						if(capitalInvestMent>100000)
    							{
    							
    								result=1000000;
    							}
    						if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
    							{
    							
    								result=500000;
    							}
    						if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
    							{
    							
    								result=250000;
    							}
    						if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
    							{
    							
    								result=150000;
    							}
    		
    						if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
    							{
    						
    								result=100000;
    							}
    						if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
    							{
    							
    								result=80000;
    							}
    						if(capitalInvestMent>300 && capitalInvestMent <= 1000)
    							{
    							
    								result=60000;
    							}
    						if(capitalInvestMent>200 && capitalInvestMent <= 300)
    							{
    							
    								result=3000;
    							}
    						if(capitalInvestMent>100 && capitalInvestMent <= 200)
    							{
    							
    								result=2000;
    							}
    						if(capitalInvestMent<=100)
    							{
    							
    								result=1000;
    							}
    		
    					} 
    					if(conFor=="BOTH")	
    					{

    						if(capitalInvestMent>100000)
							{
							
								result=1000000*2;
							}
						if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
							{
							
								result=500000*2;
							}
						if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
							{
							
								result=250000*2;
							}
						if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
							{
							
								result=150000*2;
							}
    		
						if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
							{
							
								result=100000*2;
							}
						if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
							{
							
								result=80000*2;
							}
						if(capitalInvestMent>300 && capitalInvestMent <= 1000)
							{
							
								result=60000*2;
							}
						if(capitalInvestMent>200 && capitalInvestMent <= 300)
							{
							
								result=3000*2;
							}
						if(capitalInvestMent>100 && capitalInvestMent <= 200)
							{
							
								result=2000*2;
							}
						if(capitalInvestMent<=100)
							{
							
								result=1000*2;
							}
    				/*	if(capitalInvestMent>100000)
    							{
    							
    								result=1000000*2+1000000;
    							}
    						if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
    							{
    							
    								result=500000*2+500000;
    							}
    						if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
    							{
    							
    								result=250000*2+250000;
    							}
    						if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
    							{
    							
    								result=150000*2+150000;
    							}
        		
    						if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
    							{
    							
    								result=100000*2+100000;
    							}
    						if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
    							{
    							
    								result=80000*2+80000;
    							}
    						if(capitalInvestMent>300 && capitalInvestMent <= 1000)
    							{
    							
    								result=60000*2+60000;
    							}
    						if(capitalInvestMent>200 && capitalInvestMent <= 300)
    							{
    							
    								result=3000*2+3000;
    							}
    						if(capitalInvestMent>100 && capitalInvestMent <= 200)
    							{
    							
    								result=2000*2+2000;
    							}
    						if(capitalInvestMent<=100)
    							{
    							
    								result=1000*2+1000;
    							}
    								*/
    					} 
    				}else
    						{
			    				alert("CTE is Applicable For New");
			    				document.getElementById('result1').value="";
			    				return false;
	    					}
    		}
    			
    		
    		else
    			{
    			if(consent=="NEW")
    			{
    			result=0;
    			}else
    			{
    			/*if(conFor=="AIR")
    			{
    				if(capitalInvestMent>100000)
					{
						result=250000*2;
					}
				if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
					{
						result=150000*2;
					}
				if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
					{
						result=100000*2;
					}
				if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
					{
						result=75000*2;
					}
    		
				if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
					{
						result=50000*2;
					}
				if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
					{
						result=35000*2;
					}
				if(capitalInvestMent>300 && capitalInvestMent <= 1000)
					{
						result=25000*2;
					}
				if(capitalInvestMent>200 && capitalInvestMent <= 300)
					{
						result=2000*2;
					}
				if(capitalInvestMent>100 && capitalInvestMent <= 200)
					{
						result=1000*2;
					}
				if(capitalInvestMent<=100)
					{
						result=500*2;
					}
    		
    			}*/
    			
    			if(conFor!="BOTH")//if(conFor=="WATER")
    			{
    			
    				if(capitalInvestMent>100000)
    					{
    						result=250000;
    					}
    				if(capitalInvestMent>50000 && capitalInvestMent  <= 100000)
    					{
    						result=150000;
    					}
    				if(capitalInvestMent>20000 && capitalInvestMent  <= 50000)
    					{
    						result=100000;
    					}
    				if(capitalInvestMent>10000 && capitalInvestMent  <= 20000)
    					{
    						result=75000;
    					}
        		
    				if(capitalInvestMent>5000 && capitalInvestMent  <= 10000)
    					{
    						result=50000;
    					}
    				if(capitalInvestMent>1000 && capitalInvestMent  <= 5000)
    					{
    						result=35000;
    					}
    				if(capitalInvestMent>300 && capitalInvestMent  <= 1000)
    					{
    						result=25000;
    					}
    				if(capitalInvestMent>200 && capitalInvestMent  <= 300)
    					{
    						result=2000;
    					}
    				if(capitalInvestMent>100 && capitalInvestMent <= 200)
    					{
    						result=1000;
    					}
    				if(capitalInvestMent<=100)
    					{
    						result=0;//result=500;
    					}
        		
    			
    			}
    			if(conFor=="BOTH")
    			{
    				if(capitalInvestMent>100000)
					{
						result=250000*2;
					}
				if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
					{
						result=150000*2;
					}
				if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
					{
						result=100000*2;
					}
				if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
					{
						result=75000*2;
					}
    		
				if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
					{
						result=50000*2;
					}
				if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
					{
						result=35000*2;
					}
				if(capitalInvestMent>300 && capitalInvestMent <= 1000)
					{
						result=25000*2;
					}
				if(capitalInvestMent>200 && capitalInvestMent <= 300)
					{
						result=2000*2;
					}
				if(capitalInvestMent>100 && capitalInvestMent <= 200)
					{
						result=1000*2;
					}
				if(capitalInvestMent<=100)
					{
						result=0;//result=500*2;
					}
    				/*if(capitalInvestMent>100000)
					{
						result=250000*2+250000;
					}
				if(capitalInvestMent>50000 && capitalInvestMent <= 100000)
					{
						result=150000*2+150000;
					}
				if(capitalInvestMent>20000 && capitalInvestMent <= 50000)
					{
						result=100000*2+100000;
					}
				if(capitalInvestMent>10000 && capitalInvestMent <= 20000)
					{
						result=75000*2+75000;
					}
    		
				if(capitalInvestMent>5000 && capitalInvestMent <= 10000)
					{
						result=50000*2+50000;
					}
				if(capitalInvestMent>1000 && capitalInvestMent <= 5000)
					{
						result=35000*2+35000;
					}
				if(capitalInvestMent>300 && capitalInvestMent <= 1000)
					{
						result=25000*2+25000;
					}
				if(capitalInvestMent>200 && capitalInvestMent <= 300)
					{
						result=2000*2+2000;
					}
				if(capitalInvestMent>100 && capitalInvestMent <= 200)
					{
						result=1000*2+1000;
					}
				if(capitalInvestMent<=100)
					{
						result=500*2+500;
					}*/
    		
    			}
    			}
    		}
	
	
	
	
	
	
	
	
	
	document.getElementById('result1').value=result
	return true;

}}
</script>

</head>
<body onload="MM_preloadImages('images/hazardous_waste_over.JPG','images/hazardous_waste.jpg','images/water_pollution.jpg','images/bio_waste.jpg','images/globe.jpg')">
<table width="1000px" border="0" bordercolor="" cellspacing="0" cellpadding="0" align="center" bgcolor="#FFFFFF">
  	<!--<tr>
    	<td width="100%" height="100%" valign="top" background="images/top_header_bg.jpg">
    	  <table width="100%" border="0" bordercolor="red" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="#E5E5E5"><img width="1000" src="images/header2.bmp"> </td>
			</tr>
			</table>
		  Start of Title	  
  		  <table width="100%" border="1" bordercolor="red" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="#E5E5E5"><img src="images/leftHeader.JPG"> </td>
				<td width="70%" align="center"   valign="center" background="images/middleHeader.JPG"><font color="green" style="font-family:verdana;font-size:20px;" ><b>Online Consent Management & Monitoring System</b></font> </td>
				<td width="30%" align="left" valign="top" background="images/middleHeader.JPG">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width = "20%"></td>
							<td width="80%" valign="top" align = "right">
								  <table width="100%" border="1" bordercolor="red" cellspacing="0" cellpadding="0">
									<tr>
										<td width = "100%" align = "right">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="3%" valign="top"><img src="images/left_corner.gif"/></td>
													<td width="95%" valign="top" bgcolor="#50A4C8">
														<table width="100%" border="0" cellspacing="0"	cellpadding="0">
															<tr>
																<td width="15%"><img src="images/gtalk.gif"	/></td>
																<td width="20%"><a href="#" class="gtalk"><span	class="top-lnks">eTalk</span></a></td>
																<td width="7%">&nbsp;</td>
																<td width="8%"><img src="images/contact.gif"/></td>
																<td width="20%"><a href="#" class="gtalk"><span	class="top-lnks">Contact</span></a></td>
																<td width="7%">&nbsp;</td>
																<td width="10%"><img src="images/email.gif"	/></td>
																<td width="13%"><a href="#" class="gtalk"><span class="top-lnks">Email</span></a></td>
															</tr>
														</table>
													</td>
													<td width="2" valign="top"><img	src="images/right_corner.gif" width="9" height="24" /></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td height="5" align="left" valign="top"></td>
									</tr>
									<tr>
										<td colspan = "2" align="right" valign="top"><img src="images/tree.gif" /></td>
									</tr> 
								</table>
							</td>
							<td valign="top">&nbsp;</td>
						</tr>
					</table>
				</td>
				<td valign="top" bgcolor="#E5E5E5"><img src="images/rightHeader.JPG"> </td>
			</tr>
		  </table>
		  End of Title -->
		<tr>
			<td bgcolor="#E5E5E5"><img width="1000" src="images/header.JPG"> </td>
		</tr>
		<tr>
   	<!-- horizontal menu -->
   	
    	<td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
						
				<span >		<g:include controller="userMaster" action="showMenu"/></span>	</td>	
						</tr>
  <!--  	<tr>
    	<td   valign="top" background="images/button_BG.gif">&nbsp;</td>
  	</tr>  -->
  	<tr>
    	<td  valign="top" >
			<table width="100%" border="0" bordercolor="green" cellspacing="0" cellpadding="0">
				<tr>
					<!-- Start of TD 1 -->
					<td valign="top" width="80%" align="center">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="100%" valign="bottom" bgcolor="#E6E6DC">
									<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="100%" height="196" >
									<param name="movie" value="flash.swf" />
									<param name="quality" value="high" />
									<embed src="flash.swf" quality="high" pluginspage="https://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100%" height="100"></embed>
									</object>
								</td>
							</tr>
			  
							<tr>
								<td valign="top" width="96%" background="images/bg_text.gif" >
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="6%" valign="top" >
												<a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image27','','images/globe.jpg',1)">
												<img src="images/globe_over.JPG" style="float:left; padding-right:12px; padding-top:18px; padding-left:20px; name="Image27" width="59" height="55" border="0" id="Image27" />
												</a>
											</td>
											<td width="40%" valign="top" class="maintext3">
												<div align="justify">
													<img src="images/about.gif" alt="about spb" width="112" height="27"  style="padding-top:18px;" /><br />
													<strong>The Pollution Control Board has been established as a regulatory authority for implementing various pollution control laws. </strong>The board is committed to provide pollution free environment to the people of State. The Board has undertaken various studies of underground water.
													&nbsp;&nbsp;<% String cont=request.getContextPath(); %>
													<a href="<%=cont%>/userMaster/aboutSpcb.gsp">More..</a><br />
												</div>
											</td>
											<td width="4%" valign="bottom" >
												<img src="images/linev.gif" width="1" height="100" hspace="12" />
											</td>
											<td width="50%" valign="top" align="left" class="bulletinside">
												<img src="images/news.gif" alt="about spb" width="120" height="19"  style="padding-top:18px;" />
												<ul align="left"  >
													<li ><a href="<%=cont%>/userMaster/Flyash.gsp">Fly Ash Mandatory in Construction Works near Power Plant</a></li>
													<li><a href="<%=cont%>/userMaster/PolyBags.gsp">Use of poly carry bags banned in state </a></li>
													<li><a href="<%=cont%>/userMaster/Jailterm.gsp">Jail term, fine for polluting unit owner</a></li>
													<li><a href="<%=cont%>/userMaster/Loksabha.gsp">Lok Sabha Passes Bill On Water Cess</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=cont%>/userMaster/news.gsp">More...</a></li>
												</ul>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<!-- <tr>
								<td align="center" valign="top"  ><img src="images/middle_banner.gif" width="96%" height="62" style="padding-bottom:10px;" /></td>
							</tr> -->
							
							<tr>
								<td height="100%" align="left" valign="top" bgcolor="#EEEEEE"  >
									<table width="100%"  border="0" bordercolor="blue" cellpadding="0" cellspacing="0">
										<tr>
											<td width="100%">
												<img src="images/latest.gif" alt="Latest Updates" width="146" height="22" hspace="15" vspace="2" />
											</td>
										</tr>
										<tr>
											<td valign="top" background="images/lineh.gif" style="background-repeat:repeat-x;">
											</td>
										</tr>
										<tr>
											<td valign="top" bgcolor="#D6D7D1">
												<table border="0" bordercolor="red">
													<tr>
														<td valign="top" class="maintext3">
														 	<a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image24','','images/hazardous_waste.jpg',1)">
															<img src="images/hazardous_waste_over.JPG" name="Image24" width="59" height="44" border="0" id="Image24"/> </a>
															<a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image24','','images/hazardous_waste_over.JPG',1)"></a>
														</td>
														<td valign="top"  class="maintext3">
															<strong>Hazardous Waste: </strong>To create awareness among people regarding pollution control.&nbsp;&nbsp;<a href="<%=cont%>/userMaster/Hazardouswaste.gsp">More..</a><br />
														</td>
														<td valign="top"  class="maintext3">
														 	<a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image25','','images/water_pollution.jpg',1)"><img src="images/water_pollution_over.JPG" name="Image25" width="59" height="44" border="0" id="Image25" /></a>
														</td>
														<td valign="top"  class="maintext3">
															<strong>Water &amp; Air Pollution: </strong>Polluction Control Board is awareness among people regarding pollution &nbsp;&nbsp;<a href="<%=cont%>/userMaster/AirPollution.gsp">More..</a><br />
														</td>
														<td valign="top"  class="maintext3">
															<a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image26','','images/bio_waste.jpg',1)">
																<img src="images/bio_waste_over.JPG" name="Image26" width="59" height="44" border="0" id="Image26" />
															</a>
														</td>
														<td valign="top"  class="maintext3">
															<strong>Biomedical Wastes: </strong>Board wants sustainable development.&nbsp;&nbsp;<a href="<%=cont%>/userMaster/Biomedical.gsp">More..</a><br />
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr >
										 	<td  valign="top" height="40px" background="images/bg_filler.gif" style="background-repeat:repeat-x;"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td> <!-- End of TD 1 -->
					
					<!-- Start of TD 2 -->
					<td width="20%" valign="top">
						<table width="100%" border="0" bordercolor="red" cellspacing="0" cellpadding="0">
							<tr>
								<!-- <td width="100%" height="218" valign="top" background="images/bg_upcoming-events.gif" style="background-repeat:no-repeat;">
									<div class="evnt-txt">
										<img src="images/dot.gif" /><a href="#">Noise pollution level high inresidential &nbsp;&nbsp;areas</a><br />
										<img src="images/lin.gif" /><br />
										<img src="images/dot.gif" /><a href="#">State Pollution Control Board &nbsp;&nbsp;&nbsp;notices to government agencies </a><br />
										<img src="images/lin.gif" /><br />
										<img src="images/dot.gif" /><a href="#">Monitor operations of CETPs on a daily &nbsp;&nbsp;&nbsp;basis</a> 
									</div>
								</td> -->
							</tr>
							<tr>
								<td valign="top" bgcolor="#EEEEEE" style="padding-top:8px; padding-bottom:8px;">
									<div>
										<!--<form id="form1" name="form1" method="post" action="userMaster/doLogin" onSubmit="return validateForm();">-->
										<form id="form1" name="form1" method="post" action="userMaster/doLogin">  
											<div id="t" align="center" >
											
											<g:if test="${flash.message}">
												<div class="style1">
													<span class="error">${flash.message}</span><br/>
												</div>
											</g:if>
					
											</div>
											<div class="radio">	<label> <input id="radioButton" name="radioButton"  type="radio" value="SPCB" checked="checked" /></label> </div>
											<div class="login_heading"> SPCB Login</div>
											<div class="radio"> <label>	<input id="radioButton" name="radioButton" type="radio" value="Industry" /></label></div>
											<div class="login_heading"> Industrial Login </div>
											<div class="clear"></div>
											<div class="login">User ID</div>
											<div> <input type="text" id="userId" name='userId' class="form1" AUTOCOMPLETE=OFF /></div>
											<div class="clear"></div>
											<div class="login">Password</div>
											<div> <input type="password" id="password" name='password' class="form1" AUTOCOMPLETE=OFF  />&nbsp;<a href="#" onclick="loginEncryption();"  class="bulletinside"><b>Login</b></a></div>
											<div class="clear"></div>
										</form>
											<div class="maintext1" align="left"> <g:link controller="industryRegMaster" action="create">New Industry Registration</g:link> &nbsp;&nbsp;		<g:link controller="indCatMaster" action="forgetPassword">Forget Password</g:link>
											</div>
									</div>
								</td>
							</tr>
							<tr>
								<td valign="top"><a href="#" target="_blank"><img src="images/feedack.gif" width="268" height="70" border="0" /></a></td>
							</tr>
							<tr>
								<td valign="top"><a href="#"><img src="images/query.gif" alt="Query" width="268" height="70" border="0" /></a></td>
							</tr>  
							<tr>
								<td valign="top" background="images/bg2.gif" style="background-repeat:no-repeat;">
									<img src="images/fee_calc.gif" alt="Fee Calculator" width="113" height="22" hspace="12" vspace="8" />
									<div class="box2">
										<!-- <div class="maintext"> -->
											<g:form name="myform">
												<table width="275" border="0" cellpadding="2" cellspacing="1" bordercolor="#FFFFFF">
													<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent Type:</span></div>
														</td>
														<td width="60%" ><span class="style6">
															 <input id="consentTypeY" name="consentType" type="radio" value="CTE" checked="checked" />CTE
															<input  id="consentTypeN" name="consentType" type="radio" value="CTO" />CTO</span>
														</td>
													</tr>
													<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent For:</span></div>
														</td>
														<td width="60%">
															<span class="style6">
																<input id="consentForN" name="consentFor" type="radio" value="AIR" checked="checked"/>Air
																<input id="consentForY" name="consentFor" type="radio" value="WATER" />Water
																<input id="consentForB" name="consentFor" type="radio" value="BOTH" />Both
															</span>
														</td>
													</tr>
					
													<tr>
														<td width="40%" ><div align="left"><span class="style3 style5">Consent:</span></div></td>
														<td width="60%" >
															<span class="style6">
																	<input id="consentY" name="consent" type="radio" value="NEW" checked="checked" />New
																	<input  id="consentN" name="consent" type="radio" value="RENEW" />Renew
															</span>
														</td>
													</tr>
					
													<tr>
														<td  class="style3" width="40%"><div align="left" class="style5">Capital Investment<span class="txt">(in Lakhs)</span>: </div></td>
														<td width="60%" >
															<input id="capital" name="capital" type="text" class="txt4" size="10">  
														</td>
													</tr>
													<tr>
														<td  width="40%"class="style3"><div align="left" class="style7">Consent Fee: </div></td>
														<td width="60%"class="style3 style7 style5"><input id="result1" size="10" class="txt4" name="result1" type="text" readonly="readonly"></td>
													</tr>
													<tr>
														<td colspan="2" align="right" class="style3 style8">
															 <a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
														</td>
													</tr>
												</table>
											</g:form>
										<!-- </div> -->
									</div>
								</td>
							</tr>
						</table>
					</td> <!-- End of TD 2 -->				
				</tr>
			</table>    		
      	</td>
  	</tr>
	<tr>
	    <td align="right" valign="middle" class="copyright">Pollution Control  Board, Copyright &copy; 2009All Rights Reserved NIC India</td>
	</tr>
</table> 
<div align="center">
</div>
</body>
</html>


