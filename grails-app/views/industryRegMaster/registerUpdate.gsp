<%@ page import="java.util.Calendar;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
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
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

	<g:javascript library="prototype" />
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

<script type="text/javascript">
function random_number(min,max) {

		return(Math.round((max-min) * Math.random() + min));
	} 

</script>

<g:javascript>

function checkValue()
{
	var chosenoption=document.getElementById("type");
	var chosenoption1=document.getElementById("capNo").value;
	
	if(chosenoption.value == "bmw")
  	 {
		if(chosenoption1==""){
		alert("Please enter no of beds");
		return false;
		}
  	 }
	else{
		if(chosenoption1==""){
			alert("Please enter capital investment");
			return false;
			}
	}
	
	
	if(!chosenoption1){
		if(chosenoption.value == "bmw")
	   	 {
			alert("Please enter No. of Beds");
			return false;
	   	 }
		else{
			alert("Please enter Capital Investment");
			return false;
			
		}
	}
	else{
		
		return true;
	}
}

function select1()
{
var chosenoption=document.getElementById("type");
	
         
   	 if(chosenoption.value == "bmw")
   	 {
   	 
   	document.getElementById('ting1').style.display = 'none';
  	 document.getElementById('ting2').style.display = 'block';
  	document.getElementById('ting11').style.display = 'none';
 	 document.getElementById('ting22').style.display = 'block';
  	
	 }
else{
   
    document.getElementById('ting1').style.display = 'block';
  	 document.getElementById('ting2').style.display = 'none';
  	document.getElementById('ting11').style.display = 'block';
 	 document.getElementById('ting22').style.display = 'none';
  	
   		 }
   
} 



function updateCity1(e) {
// The response comes back as a bunch-o-JSON
//alert("abccc");
var cities = eval("(" + e.responseText + ")") // evaluate JSON
//alert("cities"+cities);
if (cities) {
var rselect = document.getElementById('industryType.id')
//var CatVale = document.getElementById('category2')



// Clear all previous options
var l = rselect.length

while (l > 0) {
l--
rselect.remove(l)
}



// Rebuild the select
for (var i=0; i < cities.length; i++) {
var tehsil = cities[i]
var opt = document.createElement('option');
opt.text = tehsil.industryType
opt.value = tehsil.id
try {
rselect.add(opt, null) // standards compliant; doesn't work in IE
}
catch(ex) {
rselect.add(opt) // IE only
}
}
}


}

</g:javascript>


</head>

<body onLoad="select1();">
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
			<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        

		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			
											<g:include controller="userMaster" action="showIndexMenu"/>            

                                 
			
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
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr>
							<td >&nbsp;</td>
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                    <g:if test="${flash.message}">
									<div class="message">${flash.message}</div>
									</g:if>

                      </span></div></td>
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
		
		
		
		
		<g:form action="regUpdate" name="myform" method="post" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Profile Details</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			                    
			
			
			
               <tr align="center" >
                        <td bgcolor="#A8DAF3" width="150px" align="right" valign="middle" class="headngblue">Applicant Name:<span style="color:red">*</span></td>
                        <td bgcolor="#E8F6F9" align="left" class="headngblue1">
                                    <input type="text"  name="name"  class="txt4" AUTOCOMPLETE=OFF>
                                </td>
                      </tr>
                      <input type="hidden" name="newId" id="newId" value="${newUserInst.id}" />
      				<input type="hidden" name="regId" id="regId" value="${newUserInst.regId}" />
      				<input type="hidden" name="type" id="type" value="${newUserInst.registrationFor}" />
      				<input type="hidden" name="district.id" id="district.id" value="${newUserInst.districtId}" />
      				<tr align="center" >
                    <td bgcolor="#A8DAF3" width="150px" height="40px" align="right" valign="middle" class="headngblue">District:<span style="color:red">*</span></td>
                    <td bgcolor="#E8F6F9" align="left" height="40px" valign="middle" class="headngblue">
                   
                   ${newUserInst?.district}
                 
                    </td>
                  </tr>
                  <tr align="center" >
                  <td bgcolor="#A8DAF3" width="150px" align="right" height="40px" valign="middle" class="headngblue">Block:<span style="color:red">*</span></td>
                  <td bgcolor="#E8F6F9" align="left" height="40px" valign="middle" class="headngblue">
                  <div id="updateSelect"><g:select optionKey="id"
						from="${tehsilList}" name="tehsil.id" id="tehsil.id"
						
						class="txt4"></g:select>&nbsp;(select industry block)
					  </td>
                </tr>
                <tr align="center">
                <td bgcolor="#A8DAF3" width="150px" height="40px" align="right" valign="middle" class="headngblue">Hint
				Question:<span style="color:red">*</span></td>
				<td bgcolor="#E8F6F9" align="left" height="40px" valign="middle" class="headngblue">
				<div align="left" class="style6"><span
					class="txt style6"> <select name="hintQuestion"
					class="txt4">

					<option value="What is your Nickname?">What is
					your Nickname?</option>
					<option value="What is your Birthplace?">What
					is your Birthplace?</option>
					<option value="What was your first mobile number?">What
					was your first mobile number?</option>
					<option value="What is your first school's name ?">What
					is your first school's name ?</option>
					<option value="What is your Spouse's name?">What
					is your Spouse's name?</option>
				</select> </span><span class="txt4">(select question)</span></div>
				</td>
			</tr>
                <tr align="center">
                <td bgcolor="#A8DAF3" width="150px" height="40px" align="right" valign="middle" class="headngblue">Hint Answer:<span style="color:red">*</span></td>
                <td bgcolor="#E8F6F9" align="left" height="40px" valign="middle" class="headngblue">
                            <input type="text"  name="answer"  class="txt4" AUTOCOMPLETE=OFF>
                        </td>
              </tr>
			<tr>
			<td align="right" bgcolor="#A8DAF3" class="headngblue">
				<div style="display:block; border:0;" id="ting11" >Capital Investment(Rs in Lakhs)
			:</div>
			<div style="display:none; border:0;" id="ting22" >
		No. of Beds:
		</div>
		<span style="color:red">*</span>	
	</td>
			
			<td width="70%" align="left" bgcolor="#E8F6F9" >


			 <input type="text"  name="capNo" id="capNo"  class="txt4" AUTOCOMPLETE=OFF>


</td>
			
											
		</tr>
			
                
	  </table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Submit" value="Submit" onClick="return checkValue();" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
            <br />
            <br />
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
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
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    
    frmvalidator.addValidation("name","req","Please enter Industry Name");
   // frmvalidator.addValidation("district.id","dontselect=0","Please select district");
    frmvalidator.addValidation("answer","req","Please enter answer");
    frmvalidator.addValidation("capNo","decimal","Please enter Numeric value");
    
</script>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


