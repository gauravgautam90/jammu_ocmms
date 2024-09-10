<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<META NAME="Author" CONTENT="Designed by Infogain">
<title>Online Consent Management Systems</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #CCCCCC;
}
-->
</style>
<link href="css/stylessheet.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
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
	var x; 
	x=document.getElementById('capital').value;
	var y=parseInt(x)/1000;
	document.getElementById('result').value=y
	return true;

}
</script>

</head>
<body onload="MM_preloadImages('images/hazardous_waste_over.JPG','images/hazardous_waste.jpg','images/water_pollution.jpg','images/bio_waste.jpg','images/globe.jpg')">
<table width="1023" border="0" cellspacing="0" cellpadding="0" align="center" bgcolor="#FFFFFF">
  <tr>
    <td height="91" valign="top" background="images/top_header_bg.jpg"><table width="1023" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="707" align="left" valign="top"><img src="images/logo.gif" alt="Online Consent Management System" width="707" height="91" /></td>
        <td width="296" align="left" valign="top"><table width="296" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="61" height="91" valign="top">&nbsp;</td>
              <td width="229" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="left" valign="top"><table width="229" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="9" valign="top"><img src="images/left_corner.gif" width="9" height="24" /></td>
                          <td width="211" valign="top" bgcolor="#50A4C8"><table width="211" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="31"><img src="images/gtalk.gif" width="24" height="16" /></td>
                                <td width="44"><a href="#" class="gtalk"><span class="top-lnks">eTalk</span></a></td>
                                <td width="17">&nbsp;</td>
                                <td width="16"><img src="images/contact.gif" width="14" height="14" /></td>
                                <td width="49"><a href="#" class="gtalk"><span class="top-lnks">Contact</span></a></td>
                                <td width="12">&nbsp;</td>
                                <td width="22"><img src="images/email.gif" width="16" height="16" /></td>
                                <td width="20"><a href="#" class="gtalk"><span class="top-lnks">Email</span></a></td>
                              </tr>
                          </table></td>
                          <td width="9" valign="top"><img src="images/right_corner.gif" width="9" height="24" /></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5" align="left" valign="top"></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top"><img src="images/tree2.gif" width="50" height="61" /></td>
                  </tr>
              </table></td>
              <td width="6" valign="top">&nbsp;</td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="25" valign="top" background="images/button_BG.gif">&nbsp;</td>
  </tr>
  <tr>
    <td height="32" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td valign="top"><table width="267" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td valign="bottom" bgcolor="#E6E6DC"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="756" height="196">
                  <param name="movie" value="flash.swf" />
                  <param name="quality" value="high" />
                  <embed src="flash.swf" quality="high" pluginspage="https://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="756" height="196"></embed>
                </object></td>
              </tr>
              
              <tr>
                <td valign="top" background="images/bg_text.gif" ><table width="756" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td valign="top" ><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image27','','images/globe.jpg',1)"><img src="images/globe_over.JPG" style="float:left; padding-right:12px; padding-top:18px; padding-left:20px; name="Image27" width="59" height="55" border="0" id="Image27" /></a></td>
                      <td width="50%" valign="top" class="maintext3"><div align="justify"><img src="images/about.gif" alt="about spb" width="112" height="27"  style="padding-top:18px;" /><br />
                          <strong>The Pollution Control Board has been established as a regulatory authority for implementing various pollution control laws. </strong>The board is committed to provide pollution free environment to the people of Punjab. The Board has undertaken various studies of underground water, soil and air to take remedial steps to control pollution.<br />
                          The Board has also formulated time-targeted action plan to clean the polluted cities .<br />
                          <br />
                        </div></td>
                      <td width="25" valign="bottom" ><img src="images/linev.gif" width="1" height="161" hspace="12" /></td>
                      <td width="50%" valign="top" class="bulletinside"><img src="images/news.gif" alt="about spb" width="120" height="19"  style="padding-top:18px;" />
                        <ul>
                          <li><a href="#">Noise pollution level high in residential areas </a></li>
                          <li><a href="#">Tamil Nadu Pollution Control Board notices</a><br />
                          </li>
                          <li><a href="#">MPCB cracks whip on 230 healthcare units </a></li>
                          <li><a href="#">Mismanagement of bio-medical waste in hospitals </a></li>
						  <li><a href="#">Monitor operations of CETPs on a daily basis </a></li>
                        </ul></td>
                    </tr>
                  </table></td>
              </tr>
              <tr>
                <td align="center" valign="top"  ><img src="images/middle_banner.gif" width="662" height="62" style="padding-bottom:22px;" /></td>
              </tr>
              <tr>
                <td height="222" align="left" valign="top" bgcolor="#EEEEEE"  ><table width="100%" height="238" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><img src="images/latest.gif" alt="Latest Updates" width="146" height="22" hspace="44" vspace="7" /></td>
                    </tr>
                    <tr>
                      <td valign="top" background="images/lineh.gif" style="background-repeat:repeat-x;"><img src="images/lineh.gif" width="74" height="2" /></td>
                    </tr>
                    <tr>
                      <td valign="top"><div class="box1">
                          <div><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image24','','images/hazardous_waste.jpg',1)"><img src="images/hazardous_waste_over.JPG" name="Image24" width="59" height="44" border="0" id="Image24" /></a><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image24','','images/hazardous_waste_over.JPG',1)"></a></div>
                          <div class="clear"></div>
                          <div class="maintext"><strong>Hazardous Waste</strong><br />
                            To create awareness among people regarding pollution control.The Board has also formulated time-targeted action plan to clean the polluted cities . Thus the Board wants sustainable development.</div>
                        </div>
                        <div class="box1">
                          <div><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image25','','images/water_pollution.jpg',1)"><img src="images/water_pollution_over.JPG" name="Image25" width="59" height="44" border="0" id="Image25" /></a></div>
                          <div class="clear"></div>
                          <div class="maintext"><strong>Water &amp; Air Pollution</strong><br />
                          Polluction Control Board is awareness among people regarding pollution control.The Board has also formulated time-targeted action plan to clean the polluted cities .Thus the Board wants sustainable development. </div>
                        </div>
                        <div class="box1">
                          <div><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image26','','images/bio_waste.jpg',1)"><img src="images/bio_waste_over.JPG" name="Image26" width="59" height="44" border="0" id="Image26" /><br />
                          </a></div>
                          <div class="clear"></div>
                          <div class="maintext"><strong>Biomedical Wastes</strong><br />
                            Board wants sustainable development.To create awareness among people regarding pollution control.The Board has also formulated time-targeted action plan to clean the polluted cities.<br />
							<div align="right"><a href="#">Read More..	<br />
							  <br />
							  <br />
							  <br />
							 
							</a></div>
                    </div>
                        </div>
                      </div></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
          <td width="267" valign="top"><table width="267" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="218" valign="top" background="images/bg_upcoming-events.gif" style="background-repeat:no-repeat;"><div class="evnt-txt"><img src="images/dot.gif" /><a href="#">Noise pollution level high inresidential &nbsp;&nbsp;areas</a><br />
                    <img src="images/lin.gif" /><br />
                    <img src="images/dot.gif" /><a href="#">Tamil Nadu Pollution Control Board &nbsp;&nbsp;&nbsp;notices to government agencies </a><br />
                    <img src="images/lin.gif" /><br />
                    <img src="images/dot.gif" /><a href="#">Monitor operations of CETPs on 
                    a daily &nbsp;&nbsp;&nbsp;basis</a> </div></td>
              </tr>
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			 
               <tr>
                <td valign="top" bgcolor="#EEEEEE" style="padding-top:8px; padding-bottom:8px;"><div>
                  <!--<form id="form1" name="form1" method="post" action="userMaster/doLogin" onSubmit="return validateForm();">-->
                  <form id="form1" name="form1" method="post" action="userMaster/doLogin">  
                   <div id="t" align="center" ><g:if test="${flash.message}">
           			 <div class="style1"><span class="error">${flash.message}</span><br/></div>
            		</g:if></div>
					
					
                    <div class="radio">
                      <label>
                      <input id="radioButton" name="radioButton"  type="radio" value="SPCB" /> 
                      </label>
                    </div>
                    <div class="login_heading"> SPCB Login</div>
                    <div class="radio">
                      <label>
                      <input id="radioButton" name="radioButton" type="radio" value="Industry" />
                      </label>
                    </div>
                  <div class="login_heading"> Industrial Login</div>
                  
                  
                  <div class="clear"></div>
                  <div class="login">User ID</div>
                  <div>
                    <input type="text" id="userId" name='userId' class="form1" />
                  </div>
                  <div class="clear"></div>
                  <div class="login">Password</div>
                  <div>
                    <input type="password" id="password" name='password' class="form1" />&nbsp;
					<a href="javascript:{}" onclick="return validateForm();"  class="bulletinside"><b>Login</b></a>
                  </div>
				  <div class="clear"></div>
				 <!-- <div class="maintext1" align="center"> -->
					<!--<input  type="submit" value="Login" name="#" />-->
					<!--<a href="javascript:{}" onkeypress="return validateForm();" onclick="document.getElementById('form1').submit(); return false;" >Submit</a>-->
					<!--<a href="javascript:{}" onclick="return validateForm();" ><b>Submit</b></a>-->
					<!--<a href="javascript:validateForm()" ><b>Login</b></a>-->
				 <!-- </div>
					<div class="clear"></div>-->
					</form>
					<div class="maintext1" align="center"> <g:link controller="industryRegMaster" action="create">New Registration</g:link> &nbsp;&nbsp; <a href="forgetPassword.gsp">Forget Password</a></div>
                  <!--<div class="maintext1" align="center"> <a href="#">New User Registration</a> &nbsp;&nbsp; <a href="#">Hint Password</a></div>-->
				  
				  </div></td>
              </tr>
			  
			 
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
              <tr>
                <td valign="top"><a href="#" target="_blank"><img src="images/feedack.gif" width="268" height="73" border="0" /></a></td>
              </tr>
              <tr>
                <td valign="top"><a href="#"><img src="images/query.gif" alt="Query" width="268" height="73" border="0" /></a></td>
              </tr>
              <tr>
                <td height="254" valign="top" background="images/bg2.gif" style="background-repeat:no-repeat;"><img src="images/fee_calc.gif" alt="Fee Calculator" width="113" height="22" hspace="12" vspace="8" />
                  <div class="box2">
                    <div class="maintext">
					
					
					
					
					
                      <table width="228" border="0" cellpadding="2" cellspacing="1" bordercolor="#330000" bgcolor="#FFFFFF">
    <tr>
      <td width="87" bgcolor="#D3D8D2"><div align="right"><span class="style3 style5">Consent Type:</span></div></td>
      <td width="153" bgcolor="#D3D8D2"><span class="style6">
      <input name="radiobutton" type="radio" value="radiobutton" checked="checked" />
CTE
<input name="radiobutton" type="radio" value="radiobutton" />
CTO</span></td>
    </tr>
    <tr>
      <td bgcolor="#D3D8D2">&nbsp;</td>
      <td bgcolor="#D3D8D2"><span class="style6">
      <input name="radiobutton1" type="radio" value="radiobutton" />
Air
<input name="radiobutton1" type="radio" value="radiobutton" />
Water
<input name="radiobutton1" type="radio" value="radiobutton" checked="checked" />
Both</span></td>
    </tr>
    
    <tr>
      <td bgcolor="#D3D8D2" class="style3"><div align="right" class="style5">Capital Investment: </div></td>
      <td bgcolor="#D3D8D2"><input id="capital" name="capital" type="text"> </td>
    </tr>
    <tr>
      <td bgcolor="#D3D8D2" class="style3"><div align="right" class="style7">Consent Fee: </div></td>
      <td bgcolor="#D3D8D2" class="style3 style7 style5"><input id="result" name="result" type="text"></td>
    </tr>
    <tr>
      <td colspan="2" bgcolor="#D3D8D2" class="style3 style8"><div align="center"><input type="submit" value="Calculate" onclick="Calculate()"> </div></td>
    </tr>
  </table>
 


                      <div align="right"><a href="#">Read More..</a></div>
                    </div>
                  </div></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td align="right" valign="middle" class="copyright">Pollution Control  Board, Copyright &copy; 2009All Rights Reserved NIC India</td>
  </tr>
</table>
<div align="center"></div>
</body>
</html>
