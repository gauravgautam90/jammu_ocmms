<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!----------------------Added by VINEET KUMAR RAGHAV- For Audit Code:--START------------------>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="X-Frame-Options" content="deny">

<style id="antiClickjack">body{display:none !important;}</style>

<script type="text/javascript">
if (self === top) {
    var antiClickjack = document.getElementById("antiClickjack");
    antiClickjack.parentNode.removeChild(antiClickjack);
} else {
    top.location = self.location;
}
</script>
<!-------------------------end------------------------------>
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<style type="text/css">

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
</style>
<% 
		def status
		def indUserIns = (IndUser)(session.indUser)
    	def abc1 = IndUser.get(indUserIns.id)
    	def industryRegMasterInstance2 = abc1.industryRegMaster
 		def applist = IndApplicationDetails.findAll("from IndApplicationDetails as appDet where appDet.indUser = ? and appDet.applicationType = 'CTE' and appDet.completionStatus = 'completed'", [industryRegMasterInstance2])
 		System.out.println(applist + "hhhhh");
  		if(applist){
  			for(int i=0;i<applist.size();i++){
    		def appPend = ApplicationPendingDetails.findByApplication(applist.get(i))
    		if(appPend){
    				System.out.println(appPend.applicationStatus + "jjjjj");
  					if (appPend.applicationStatus == "approved" ){
    					status = "true"
    						}
  				else{
  					status = "false"
  					}
  				}
  				}
 		 }
  System.out.println(status);
  %>
  
  <!--
  
  
<script type="text/javascript">

function checkMIS(){
 
if((document.getElementById('oldFileNo').value).trim()!= ''){
var oldFileNo= document.getElementById('oldFileNo').value
var oldFileNoLength= oldFileNo.length
var oldFileNo1=oldFileNo.substr(0,3)
var oldFileNo2=oldFileNo.substr(3,oldFileNoLength)
if(Number(oldFileNo1) >= 0){
alert("Old MIS File No should be 3 characters and 4 numeric");
return false;
}else if(Number(oldFileNo2) >= 0){
if(!((oldFileNo1.length==3)&&(oldFileNo2.length==4)))
{
alert("Old MIS File No should be 3 characters and 4 numeric")
return false;
}
else{
return true;
}
}else{
alert("Old MIS File No should be 3 characters and 4 numeric");
return false;
}
}

}

 function checking(){
	for(var i = 0; i<document.myForm.radiobutton1.length; i++){
 		if(document.myForm.radiobutton1[i].checked){
		 var radiomenu = document.myForm.radiobutton1[i]
			if(radiomenu.value == "CTO"){
				if(<%=status%> == true ){
				 return true;
				}
				else{
				 alert("You are not authorized for CTO appliance.")
				 return false;
				}
			}
		}
	}
 }
  
</script>

	-->

<script type="text/javascript">



function hidediv() {
for(var i = 0; i<document.myForm.radiobutton1.length; i++){
 if(document.myForm.radiobutton1[i].checked){
 var radiomenu = document.myForm.radiobutton1[i]

   	 if (radiomenu.value == "CTO") { 
   	    document.getElementById('hazardeousType').checked=false;
    	if(document.getElementById('SelectTemp'))
		document.getElementById('SelectTemp').style.display = 'block'; 
		if(document.getElementById('SelectTemp1'))
		document.getElementById('SelectTemp1').style.display = 'none'; 
		document.getElementById('check').style.display = 'block';
		 document.myForm.authorFor.checked = false;
		 
		} 
	else { 
		if (radiomenu.value == "CTE") { 
		document.getElementById('hazardeousType').checked=true;
		//document.myForm.consent[2].checked = true;
		if(document.getElementById('SelectTemp1'))
		document.getElementById('SelectTemp1').style.display = 'block';
		if(document.getElementById('SelectTemp'))
		document.getElementById('SelectTemp').style.display = 'none';
		document.getElementById('check').style.display = 'none';
		document.myForm.authorFor.checked = true;
		
		 
					}  

			} 
		} 
	} 
}


function hideDivIndustry()
{
	for(var i = 0; i<document.myForm.existingOrNew.length; i++){
	if(document.myForm.existingOrNew[i].checked){
	var radiomenu = document.myForm.existingOrNew[i]
	if (radiomenu.value == "newIndustry") {
		var obj =document.getElementsByClassName('typeHide');
		for(var i=0;i<obj.length;i++)
			{
			   obj[i].checked = false;
			   obj[i].disabled=true;
			}
		obj =document.getElementsByClassName('typeShow');
		for(var i=0;i<obj.length;i++)
			{
			   obj[i].checked = true;
			}
		
		document.getElementById('SelectOldIndustryType').style.display = 'none';		
		} 
	else { 
		if (radiomenu.value == "existingIndustry") { 
		document.getElementById('SelectOldIndustryType').style.display = 'block';
		var obj =document.getElementsByClassName('typeHide');
		for(var i=0;i<obj.length;i++)
			{
			   obj[i].checked = false;
			   obj[i].disabled =false;
			}
		}
	}
  }
}

     
}

</script> 

<g:javascript>

function select()
{
var selectmenu1=document.getElementById("envirImpact")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp').style.display = 'block'; 
   	 
	 }
else{
    document.getElementById('selectTemp').style.display = 'none';
   		 }
   }
} 


function select1()
{
var selectmenu1=document.getElementById("factoriesAct")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp1').style.display = 'block'; 
   	 
	 }
else{
    document.getElementById('selectTemp1').style.display = 'none';
   		 }
   }
} 


function select2()
{
var selectmenu1=document.getElementById("pressNote")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
		document.getElementById('selectTemp2').style.display = 'block'; 
	 }
else{
    document.getElementById('selectTemp2').style.display = 'none';
   		 }
   }
} 


function select3()
{
var selectmenu1=document.getElementById("completeMach")
selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "YES")
   	 {
   	 document.getElementById('selectTemp3').style.display = 'block'; 
   	 
	 }
else{
    document.getElementById('selectTemp3').style.display = 'none';
   		 }
   }
} 
</g:javascript>

<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<!-- <script type="text/javascript">
function code(var a){
	if(a==1){
		document.myForm.text1.disabled = true;
	}
}
</script> -->
<script language="javascript" type="text/javascript" src="${createLinkTo(dir:'js',file:'datetimepicker.js')}"></script>


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
		<!-- code for menuAdminHorizontal-->
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
              <%	
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
            			        indId = ind.id;
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
             	               <td height="24" bgcolor="#EEEEF3">
             	               <table width="100%">
             	               <% if((UserMaster)session.getAttribute("userMaster"))
             	               {
             	            	   %>

            <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>

			<% } 

             	     if(  (IndUser)session.getAttribute("indUser") )
		    { %>
            
		    <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
		
		    <% } %>
					 <tr>
							<td>&nbsp;</td>
					   </tr>
					</table>
				</td>
              </tr>
              
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:100%; height:20px; vertical-align:middle"><span class="error"><g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if></span></div></td>
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
	<g:form method="post" action="saveConsentForSingleWindow" name="myForm" enctype="multipart/form-data">
	
         <div style="border":0px solid gray; width:1000px; margin-bottom: 1em; padding: 10px" >
		 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >		
		
		
		
		
                            <tr style="display:none">
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1"></a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="1"></td>
							  
							  
							  <td width="431">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
		  
  			<table width="95%" border="0" align="left" cellpadding="0" cellspacing="1" bgcolor="">
  			<%
				 def sessionIndUser=(IndUser)session.getAttribute("indUser");
				 def sessIndustry = IndUser.get(sessionIndUser.id);
    			 def industryRegMasterInstance = sessIndustry.industryRegMaster;
    						 %>
  			
  			    
			
               <!--added by shashank-->
                   		<tr >
                            <td align="right" width="60%" bgcolor="#A8DAF3" class="headngblue">Consent For<span style="color:red">*</span>:</td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt"><input type="radio" name="consent" id="consent" value="both" checked> 
                                <span >Industry</span><input type="radio" name="consent" id="consent" value="dgset" > 
<span >D.G.Set</span><br>
<input type="radio" name="consent" id="consent" value="stonecrusher"><span>Stone Crusher</span><br>
<input type="radio" name="consent" id="consent" value="hotmixplants"><span>Hot mix plants</span><br>
<input type="radio" name="consent" id="consent" value="stonecrusher and hotmixplants"><span>Stone Crusher and Hot mix plants</span><br>
<input type="radio" name="consent" id="consent" value="brickkilns"><span >Brick Kilns</span>
<input type="radio" name="consent" id="consent" value="hotel"><span >Hotel</span>
</td>
                          </tr>
               
                      <tr>
                              <td valign="top" bgcolor="#FFFFFF">
                              <div  style="display:block; border:0;"  id="SelectConsentType">
                              
                                <tr align="center" bgcolor="#F4F7FB">
                                  <td width="60%" align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Hazardeous waste:</td>
                                  
                                  <td width="40%" align="left" bgcolor="#E8F6F9" class="txt">
                                  <input type="radio" name="hazardeousType" id="hazardeousType"  checked value="HWM" > 
	                                <span >Haz</span>                              
  	                            <input type="radio" name="hazardeousType" id="hazardeousType" value="NONHWM">
                                  <span >Non-Haz</span>
                                
                                  
                                  
                                  </td>
                                </tr>
                                
                               </div>
                               </td>
                            </tr>
						   <% def indUserInstance=session.indUser
                        	
                            %>
                          <input type="hidden" id='cafUniqueNo' name="cafUniqueNo" value="${session.cafUniqueNo}" />
                          <input type="hidden" id='radiobutton1' name="radiobutton1" value="${radiobutton1}" />
                          <input type="hidden" id='appFor' name="appFor" value="${appFor}" />
                          <input type="hidden" id='serviceId' name="serviceId" value="${serviceId}" />
                          </table>
                         </div>
                         </td>
                </tr>
                      
                      <!--end-->
               
             
                        </table></td>
                      </tr>	 
                      <tr bgcolor="#FFFFFF" ><td colspan="2">&nbsp;</td></tr>
							  <tr bgcolor="#FFFFFF">
								<td align="center" colspan="2"><input type="submit" onClick="//javascript:return checking()" name="save" value="Next" class="actionbutton"></td>
								
							  </tr>
	  </table>
	  

						

				
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

          </div>
          </td>
          <td width="132" align="left" valign="top">&nbsp;</td>		
          </tr>
          </table></td>
          </tr>
          </table>
          </td>
          </tr>
          </table>
          </td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>
</g:form>
	
     <script language="JavaScript" type="text/javascript">
 		var frmvalidator  = new Validator("myForm");
  	 	frmvalidator.EnableFocusOnError(false); 
  	 	function Checkfiles(){
  
  	 	var frm = document.forms["myform"];  
  	 	var fup = document.getElementById('factoriesAct');
  	 	var fup5 = document.getElementById('factoriesActStatus');
  	 	var fup1 = document.getElementById('pressNote');
  	 	var fup6 = document.getElementById('pressNoteStatus');
  	 	var fup2 = document.getElementById('radiobutton1').checked;
  	 	var fup3 = document.getElementById('envirImpact'); 
  	 	var fup4 = document.getElementById('envirImpactStatus'); 
        var fupp = document.getElementsByName('envirImpactAttach');
  	 	var fupp1 = document.getElementsByName('factoriesActAttach');
  	 	var fupp2 = document.getElementsByName('pressNoteAttach');
  	 	var fupp3 = document.getElementsByName('completeMachAttach');
  	 	var fup12 = fupp[0];
  	 	var fup13 = fupp1[0];
  	 	var fup14 = fupp2[0];
  	 	var fup15 = fupp3[0];
  	 	var fileName = fup12.value;
  	 	var fileName1 = fup13.value;
  	 	var fileName2 = fup14.value;
  	 	var fileName3 = fup15.value;
        var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
  	 	var ext1 = fileName1.substring(fileName1.lastIndexOf('.') + 1).toLowerCase();
  	 	var ext2 = fileName2.substring(fileName2.lastIndexOf('.') + 1).toLowerCase();
  	 	var ext3 = fileName3.substring(fileName3.lastIndexOf('.') + 1).toLowerCase();
   
       
  	 	if(fup.value == "YES" && fup5.value == "")
  	 	{
      	 sfm_show_error_msg('Status of obtaining site clearance from SCA-cum-SAC(Factories Act - 1948) is required...... ',fup);
    	 return false;
  	 	}
  	 	else if(fup1.value == "YES" && fup6.value == "")
  	 	{
      	 sfm_show_error_msg('Status of obtaining the environment from SCA-cum-SAC(Press Note - 17) is required...... ',fup1);
    	 return false;
  	 	}
  	 	else if(fup2==false && fup3.value == "YES" && fup4.value == "")
  	 	{
    
      	 sfm_show_error_msg('EIA Notification Details are mandatory...... ',fup3);
    	 return false;
  	 	}
  	 	else if(ext != "pdf" && ext != "jpg" && ext != "bmp" &&  fileName !="" ){
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
  	 	else {
	      return true;
  	 	} 
  	 }
 	
  	 frmvalidator.setAddnlValidationFunction("Checkfiles"); 
     frmvalidator.addValidation("appFor","selone_radio","select Application For");
   
  </script>  		    
</body>
</html>


