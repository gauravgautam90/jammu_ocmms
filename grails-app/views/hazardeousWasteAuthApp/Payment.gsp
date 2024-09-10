<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow-x:hidden; 
	overflow-y:auto;
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
span.smallfont {color:#ffffff;font-weight:bold;font-size:11px;}


-->
</style>





<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>


<script language="javascript">
function whichButton(event)
{
 if (event.button==2)//For right click
 {
  alert("Right Click Not Allowed!");
 }
}

function noCTRL(e)
{
 var code = (document.all) ? event.keyCode:e.which;
 var msg = "Sorry, this functionality is disabled.";
 if (parseInt(code)==17) // This is the Key code for CTRL key
 {
  
  window.event.returnValue = false;
 }
}


</script>
</head>

<body ondragstart="//return false" onselectstart="//return false" onMouseDown="//whichButton(event)" onKeyDown="//return noCTRL(event)">
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
			<g:include controller="userMaster" action="wasteManagementIndustryVertical"/>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr> <%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aa=(UserProfile)session.getAttribute("userprof");
             		  firstname=aa.employeeFirstName;
           		  lastName=aa.employeeLastName;
           		  access=um.accessLevel;

		}	

		else
			{
				if(  (IndUser)session.getAttribute("indUser")  )

					{
						IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 indname=ind.indName;

					}	
				else
					{
						decVar=false;
						
					}
			}




						
				
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              
              <tr>
                <td height="24" bgcolor="#4C8BC0">

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>


					<table width="100%" bgcolor="#4C8BC0">
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
		
		<% } %>
</td>
              </tr>
              
              <tr><td>

</td></tr>


              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">&nbsp;</span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    
                    <tr>
										<!-- Div area for errors-->
										<td align="center" valign="top">
										<b><font
											color="#417FB2">
										If the Details mentioned below are correct then select your Payment Mode to start the Fee Payment Process.
										<!--<br>Click on Back to make Changes. -->
										</font></b>
										</td>
									</tr>
                    <tr>
                      <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    
         <div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
		 
		 
		<g:form name="general" method="post" enctype="multipart/form-data" action="paymentOption" >
      <!--         <input type="hidden" id='regMasId' name="regMasId" value="${industryRegMasterInstance?.id}" />   -->	
				<input type="hidden" id='indAppDetId' name="indAppDetId" value="${hazardeousWasteAuthAppInstance?.id}" /> 
			
			<br>
			<br>
			<br>
			
		<table width="80%" border="0" align="right" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
         <div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
			
			<table width="70%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Merchant Name:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					JKSPCB</span></td>
				</tr>
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Application Id:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
					${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'id')}</span></td>
				</tr> 
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Payable Amount(in Rs.):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
			<%if(feesPaid){
			session.setAttribute("fee",feesPaid);
				println(feesPaid)
				}else{
				session.setAttribute("fee",feeAmount);
				println(feeAmount)}%><img src="${createLinkTo(dir:'images',file:'rupeeblue.jpg')}" width="17"/></span></td>
					
					<input type="hidden" value="${feesPaid}" name="fees" id="fees" />
					<input type="hidden" value="${feeAmount}" name="fees1" id="fees1" />
				</tr> 
				
				<tr>
				<td width="50%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Select your Payment Mode:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt4 ">
				 <input type="radio" value="online" name="radio" id="radio" checked/>Online 
					<input type="radio" value="offline" name="radio" id="radio" checked />Offline 	</span></td>
					
					
				</tr>
				    
				    <tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">&nbsp;</td>
					
			  	</tr>
	<!--	<tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">
					
						<input type="submit" name="Proceed" value="Proceed" class="actionbutton"> 
						<input type="button" name="Back" value="Back" class="actionbutton">
					</td> -->
					
					
					
	<tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">
					
						<input type="submit" name="Proceed" value="Proceed" class="actionbutton"> 
   <a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/editNewFormat?indAppDetId=<%=hazardeousWasteAuthAppInstance.id%>"><input type="button" class="actionbutton" name="back" value="Back" ></a> 
		</td>  
  </tr>

					
					
					
					
					
			  	</tr>   
				</table>
				
				</div>
		</td>
		</tr>
		
		</table>
		
											</g:form>
										<!-- </div> -->
									

      </div></td>
                            <td width="25" align="left" valign="top">&nbsp;</td>
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



 var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("indName","req","Please enter Industry Name");
 
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric");

 frmvalidator.addValidation("indEmail","email","Enter valid email");
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits");
 
 frmvalidator.addValidation("indRegNum","req","please enter industry registration no.");
 
 frmvalidator.addValidation("applicantName","req","please enter Applicant Name.");
 
 frmvalidator.addValidation("applicantDesignation","req","please enter Applicant Designation.");
 
 frmvalidator.addValidation("indCapInvt","numeric","Total Capital investment must be numeric");
 
frmvalidator.addValidation("indCity","alpha_s","check industry's city name");
 
 frmvalidator.addValidation("indPin","numeric","Pin number  must be numeric");
 
 frmvalidator.addValidation("indPhoneNo","numeric","Phone number  must be numeric");
 
 frmvalidator.addValidation("indFaxNo","numeric","Fax number  must be numeric");
 
 frmvalidator.addValidation("occName","req","Enter your Name");
 
 frmvalidator.addValidation("occDesignation","req","please enter designation");

 frmvalidator.addValidation("occAddress","req","please enter occupier Address");
 
 frmvalidator.addValidation("occCity","req","please enter City");
 
 frmvalidator.addValidation("occPin","req","please enter PIN");
 frmvalidator.addValidation("occPin","numeric","Pin number  must be numeric");
 
 frmvalidator.addValidation("occPhoneNo","req","please enter Phone number");
 frmvalidator.addValidation("occPhoneNo","numeric","Phone number  must be numeric");
 

 frmvalidator.addValidation("occFaxNo","numeric","Fax number  must be numeric");
 

 frmvalidator.addValidation("occMobile","numeric","Mobile number  must be numeric");

 frmvalidator.addValidation("occMobile","maxlen=12","mobile number is not valid");
 
 frmvalidator.addValidation("occEmail","email","Enter valid email");
 frmvalidator.addValidation("occEmail","req","please enter email-id");
 
 frmvalidator.addValidation("hintAnswer","req","please enter hint Answer");
 frmvalidator.addValidation("password","req","please press generate button for password");
 
 //frmvalidator.addValidation("quantity","req","please enter Quantity");
 //frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 


</script> 

  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  
  
  
  
  function Checkfiles(){
  
    var frm = document.forms["myform"];  
    
    
    var fupp = document.getElementsByName('industryMunicipalLimits');
    var fupp1 = document.getElementsByName('focalPointsAttach');
    var fupp2 = document.getElementsByName('classificationOfAreaAttach');
    var fupp3 = document.getElementsByName('changeOfLandAttach');
    var fupp4 = document.getElementsByName('noChangeAndClassificationAttach');
    var fupp5 = document.getElementsByName('manufacturingInvolvedAttach');
    
    var fup12 = fupp[0];
     var fup13 = fupp1[0];
      var fup14 = fupp2[0];
       var fup15 = fupp3[0];
       var fup16 = fupp4[0];
       var fup17 = fupp5[0];
       
    var fileName = fup12.value;
    var fileName1 = fup13.value;
    var fileName2 = fup14.value;
    var fileName3 = fup15.value;
    var fileName4 = fup16.value;
    var fileName5 = fup17.value;
    
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
   var ext1 = fileName1.substring(fileName1.lastIndexOf('.') + 1).toLowerCase();
   var ext2 = fileName2.substring(fileName2.lastIndexOf('.') + 1).toLowerCase();
   var ext3 = fileName3.substring(fileName3.lastIndexOf('.') + 1).toLowerCase();
   var ext4 = fileName4.substring(fileName4.lastIndexOf('.') + 1).toLowerCase();
   var ext5 = fileName5.substring(fileName5.lastIndexOf('.') + 1).toLowerCase();
   
   var application = document.general.appStatus[0].value;
   
   var application1 = document.general.appStatus[0].checked;
   
  var fupp51 = document.getElementById('yearsApplied').value;
  var fupp52 = document.getElementById('feeApplicable').value;
   
 
  
   if(ext != "pdf" && ext != "jpg" && ext != "bmp" &&  fileName !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
  	else if(ext1 != "pdf" && ext1 != "jpg" && ext1 != "bmp" &&  fileName1 !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
  	else if(ext2 != "pdf" && ext2 != "jpg" && ext2 != "bmp" &&  fileName2 !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
  	else if(ext3 != "pdf" && ext3 != "jpg" && ext3 != "bmp" &&  fileName3 !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
  	else if(ext4 != "pdf" && ext4 != "jpg" && ext4 != "bmp" &&  fileName4 !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
  	else if(ext5 != "pdf" && ext5 != "jpg" && ext5 != "bmp" &&  fileName5 !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
  	else if(application1 == true && application == "completed" && fupp51 == "" && fupp52 == ""){
        alert("Please Enter Number of Years or Fee Applicable");
  	 	return false;
  	}
     else {
	      return true;
	   } 
  }
 	
frmvalidator.setAddnlValidationFunction("Checkfiles"); 
  
  
  
 // frmvalidator.addValidation("yearsApplied","req","Please enter years Applied of Consent in Fee tab");
  frmvalidator.addValidation("yearsApplied","numeric","Applied Years of Consent in Fee tab must be numeric");
  frmvalidator.addValidation("feeApplicable","numeric","Fees must be numeric");
 // frmvalidator.addValidation("totalApplied","req","please enter total applicable Fee in Fee Tab");
 // frmvalidator.addValidation("totalApplied","numeric"," total applicable fees must be numeric");
  </script>
   <!--  
   <script language="JavaScript" type="text/javascript">
	var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("quantity","req","please enter Quantity");
 	frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 </script>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("ddNo","req","please enter DD number");
  frmvalidator.addValidation("ddNo","numeric","DD number must be numeric");
  frmvalidator.addValidation("date","req","please enter date");
 
frmvalidator.addValidation("bankName","req","please enter bank name");
  frmvalidator.addValidation("bankName","alnum_s","Enter valid bank name");
  
  frmvalidator.addValidation("branchName","req","please enter branch Name");
  frmvalidator.addValidation("branchName","alnum_s","Enter valid branch name");
  
  frmvalidator.addValidation("ddAmount","req","please enter Amount");
  frmvalidator.addValidation("ddAmount","numeric","DD Amount must be numeric");
 </script>   
 
  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("conQuantity","req","please enter quantity");
    frmvalidator.addValidation("conQuantity","numeric","quantity must be numeric");
    frmvalidator.addValidation("maxEffGen","req","please enter max effluent generation");
   frmvalidator.addValidation("effRecycle","req","please enter Effluent to be recycled");
    frmvalidator.addValidation("effDisposed","req","please enter effluent to be disposed");
  
 </script> 

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("parameterStandard","req","please enter parameter Standard");
    
  
 </script>  

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("stackPlant","req","please enter quantity");
  
    frmvalidator.addValidation("sourceCapacity","req","please enter sorce capacity");
   frmvalidator.addValidation("presStand","req","please enterpescribed standards");
   
   
    frmvalidator.addValidation("fuelQuantity","req","please enter fuel quantity");
   frmvalidator.addValidation("fuelCapacity","req","please enter fuel capacity");
   
    frmvalidator.addValidation("sourceFugitiveEmmision","req","please enter Source of fugitive emission");
   frmvalidator.addValidation("fugPresStand","req","please enter pescribed Stds");
 </script>
 
  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("upfile","req","please upload document");
    frmvalidator.addValidation("ProjectReport","req","please upload Project Report");
  
 </script>
 -->
</body>
</html>
