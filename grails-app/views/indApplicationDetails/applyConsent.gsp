
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
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<g:javascript library="prototype"/>
<% 
		def status
		def indUserIns = (IndUser)(session.indUser)
    	def abc1 = IndUser.get(indUserIns.id)
    	def industryRegMasterInstance2 = abc1.industryRegMaster
 		def applist = IndApplicationDetails.findAll("from IndApplicationDetails as appDet where appDet.indUser = ? and appDet.applicationType = 'CTE' and appDet.completionStatus = 'completed'", [industryRegMasterInstance2])
 		
  		if(applist){
  			for(int i=0;i<applist.size();i++){
    		def appPend = ApplicationPendingDetails.findByApplication(applist.get(i))
    		if(appPend){
    				
  					if (appPend.applicationStatus == "approved" ){
    					status = "true"
    						}
  				else{
  					status = "false"
  					}
  				}
  				}
 		 }

  %>
  
  <!--
  
  
<script type="text/javascript">
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
	<g:javascript>

	function selectEnvironmentClearence()
	{
	var selectmenu1=document.getElementById("environmentClearence")
	selectmenu1.onchange=function()
	 {    
	   	 var chosenoption=this.options[this.selectedIndex]
	         
	   	 if(chosenoption.value == "Yes")
	   	 {
	   	 document.getElementById('selectEnvironmentClearenceDiv').style.display = 'block';
		 }
		else if(chosenoption.value == "Please Select"){
	    	document.getElementById('selectEnvironmentClearenceDiv').style.display = 'none';
	    	document.getElementById('EnvironmentClearenceDiv').style.display = 'none';
	   	}
	   	else {
	    	document.getElementById('selectEnvironmentClearenceDiv').style.display = 'none';
	    	document.getElementById('EnvironmentClearenceDiv').style.display = 'none';
	   		 }
	   }
	}

	function checkEnvironmentClearence(){
		var environmentClearence; 
		environmentClearence=document.getElementById('environmentClearenceTxt').value;
		 if(environmentClearence.length<15){
	     		alert("Please Enter Valid EC Proposal Number and then Check Environmental Clearance Details");
	    	 	return false;
	     	}
	     	else{
	     		//alert("elseeeeeee")
			<g:remoteFunction controller="indApplicationDetails" action="ajaxGetEnvironmentClearence" params="{environmentClearence:environmentClearence}" onComplete="updateEnvironmentClearence(e)"/>
			}
	}
	function updateEnvironmentClearence(e){

	if(e.responseText=="Yes"){
	document.getElementById('EnvironmentClearenceDiv').style.display = 'block';

	}else{
	alert("EC Proposal Number is not valid !");
	}


	}
	</g:javascript>
<script type="text/javascript">



function hidediv() {

for(var i = 0; i<document.myForm.radiobutton1.length; i++){
 if(document.myForm.radiobutton1[i].checked){
 var radiomenu = document.myForm.radiobutton1[i]

   	 if (radiomenu.value == "CTO") { 
  
		document.getElementById('SelectTemp').style.display = 'block'; 
		document.getElementById('SelectTemp1').style.display = 'none'; 
		} 
	else { 
		if (radiomenu.value == "CTE") { 

		document.getElementById('SelectTemp1').style.display = 'block';
		document.getElementById('SelectTemp').style.display = 'none';
		 
					}  

			} 
		} 
	} 
}

</script> 

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

	if(  (IndUser)session.getAttribute("indUser")  )
		
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
					   </tr></table>
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
	<g:form method="post" action="saveConsent" name="myForm">
	
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Apply For Consent</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="1"></td>
							  
							  
							  <td width="431">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
		  
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				                      
                      <tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                          <tr align="center" bgcolor="#F4F7FB">
                            <td width="60%" align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue"> Consent Type<span style="color:red">*</span>:</td>
                            <td width="40%" align="left" bgcolor="#E8F6F9"  class="txt"><input onclick="javascript:hidediv();" name="radiobutton1" type="radio" id="radiobutton1" value="CTE" > 
                            <span >CTE</span>
							<input onclick="javascript:hidediv();" name="radiobutton1" type="radio" id="radiobutton1" value="CTO" checked > <span >CTO</span>							</td>
                          </tr>
                  <!--    
                          <tr >
                            <td align="right" width="60%" bgcolor="#A8DAF3" class="headngblue">Consent For<span style="color:red">*</span>:</td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt"><input type="radio" name="consent" id="consent" value="air" checked> 
                                <span >Air</span><input type="radio" name="consent" id="consent" value="water" > 
<span >Water</span><input type="radio" name="consent" id="consent" value="both" >  
<span >Both</span></td>
                          </tr>
                    -->      
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
          			
        		<tr bgcolor="#F4F7FB"> 
        		<td colspan="2">
                    <div  style="visibility:visible; border:0;"  id="SelectTemp">
                      			 
                     <table width="100%" cellpadding="0" cellspacing="0">
                       
                            <td align="right" width="60%" bgcolor="#A8DAF3" class="headngblue">Application For<span style="color:red">*</span>: </td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt">
                                    <input type="radio" name="appFor" id="appFor" checked value="new"> 
	                                <span >Fresh</span>
	                                <!-- <input type="radio" name="appFor" id="appFor" value="Modern">
                                    <span >Modernization</span>      -->                             
                                    <input type="radio" name="appFor" id="appFor" value="expan" > 
                                	<span >Expansion</span>                              
    	                            <input type="radio" name="appFor" id="appFor" value="reNew">
                                    <span >Renew</span>
                                    <input type="radio" name="appFor" id="appFor" value="autoReNew">
                                    <span >Autorenew</span>
                                   
                            </td>    
                         
                      </table> </div>
                      </td>
                      </tr>
                     
                           <tr bgcolor="#F4F7FB">
                           <td colspan="2">
                   		 <div  style="display:none; border:0;"  id="SelectTemp1">
                      			 
                    	 <table width="100%" cellpadding="0" cellspacing="0">
                            <td align="right" width="60%" bgcolor="#A8DAF3" class="headngblue">Application For<span style="color:red">*</span>: </td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt">
                                    <input type="radio" name="appFor" id="appFor"  value="new" > 
	                                <span >Fresh</span>                              
    	                         <!--   <input type="radio" name="appFor" id="appFor" value="Modern">
                                    <span >Modernization</span>     -->                               
                                    <input type="radio" name="appFor" id="appFor" value="expan" > 
                                	<span >Expansion</span>
                                	 <input type="radio" name="appFor" id="appFor" value="reNew" > 
                                	<span >Renew</span>
                                	
                                	
                            </td>
                          </table> </div>
                      </td>
                      </tr>
                      
                      
                      <!--added by shashank-->
                      
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
                            
                            <!--end-->
                      
                      
                      
                      
                      
                      
                      <!-----------------------------clearance----------start-------------->    
                      
                      
                      <tr align="center" bgcolor="#F4F7FB">
                      <td width="60%" align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue">Do you have Environmental clearance :</td>
                      <td width="40%" align="left" bgcolor="#E8F6F9"  class="txt">
                      <g:select name="environmentClearence" id="environmentClearence" onclick="javascript:selectEnvironmentClearence()" from="${['Please Select','Yes','No','Not Required']}" class="txt4" value="">
     				 </g:select>
     				 </td>
     				 </tr>
     				 
     					<tr>
           				 <td width="60%" align="right" valign="top" bgcolor="#A8DAF3" class="headngblue"></td>
           				 <td>
           				 <div id="selectEnvironmentClearenceDiv" style="display:none; border:0;">
           				 <table>
           				 	<tr align="center" bgcolor="#F4F7FB">
           				 	<td width="100%" align="left" valign="top" bgcolor="#A8DAF3" class="headngblue">
           				 	Enter EC Proposal Number: 
           					</td>
           					<td width="40%" align="left" valign="left" bgcolor="#A8DAF3" class="headngblue">
           								<input type="text" class="text4" name="environmentClearenceTxt" id="environmentClearenceTxt">
           					</td>
           					</tr>
           					<tr align="center">
           					
           					<td width="100%" align="center" valign="middle"   colspan="2" bgcolor="#FFFFFF">
           					<a href="javascript:{}" onclick="return checkEnvironmentClearence();" class="actionbutton">
           					<font face="Verdana" color="white"><b>Check Environment Clearance</b></font></a>
           					</td>
           					<tr>
           					</table>
           					  </div>
             				 
           					<div id="EnvironmentClearenceDiv" style="display:none; border:0;">
        				 	<table>
        				 	<tr align="center" bgcolor="#F4F7FB">
        				 	<td width="100%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
        				 	Environmental Clearence Details: 
        					</td>
        					<td width="50%" align="left" valign="left" bgcolor="#A8DAF3" class="headngblue">
        								<a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/popEnvironmentalClearenceDetails/<%=industryRegMasterInstance2.id%>', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');" >View</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				 
        					</td>
        					</tr>
        					</table>
        					</div>
        				 </td>
        				 </tr>	
             				 
             			
             				 
             				 
             				 
             			<!--------------------------end------------------------------------->	
     				           
                          <%if(ec){ 
                          		if(ecType=="ec"){%>
                          
                          <tr >
                            <td align="right" width="60%"  bgcolor="#A8DAF3" class="headngblue">EC NO<span style="color:red">*</span>:</td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt"><input type="text" class="txt4" size="10" name="ec_crz" value="<%if(ecNum){out.print(ecNum);}%>"/><span class="sidetxt">(Please enter EC number)</span> </td>
                          </tr>
                          <%}else{ %>
                           <tr >
                            <td align="right" width="60%" bgcolor="#A8DAF3" class="headngblue">CRZ NO<span style="color:red">*</span>:</td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt"><input type="text" class="txt4" size="10" name="ec_crz" value="<%if(ecNum){out.print(ecNum);}%>" /><span class="sidetxt"> (Please enter CRZ number)</span></td>
                          </tr>
						  <%} %>
						   <tr >
                            <td align="right" width="60%" bgcolor="#A8DAF3" class="headngblue">Issue Date<span style="color:red">*</span>:</td>
                            <td width="40%" valign="center" align="left" bgcolor="#E8F6F9" class="txt"><input type="text" class="txt4" size="10" name="date" value="<%= ecDate%>" readonly="readonly"/><span class="sidetxt">  (EC/CRZ issue date)</span></td>
                          </tr>
                          	<% }%>
						  
                        </table></td>
                      </tr>	 
                     
	  </table>
	  

						  <table width="95%" align="center">
						  <tr ><td colspan="2">&nbsp;</td></tr>
							  <tr bgcolor="#FFFFFF">
								<td align="center"><input type="submit" onClick="//javascript:return checking()" name="save" value="Next" class="actionbutton"></td>
								
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
</g:form>
	<script language="JavaScript" type="text/javascript">
 
 		 var frmvalidator  = new Validator("myForm");
  	 	frmvalidator.EnableFocusOnError(false); 
 	
     frmvalidator.addValidation("appFor","selone_radio","select Application For");
   
  </script>  		    
</body>
</html>


