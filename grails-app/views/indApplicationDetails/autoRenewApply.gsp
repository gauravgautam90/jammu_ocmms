<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="java.text.DateFormat" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.*;"%>
   <head>
      <%
         response.setHeader("Cache-Control","no-cache"); 
         response.setHeader("Pragma","no-cache"); 
         response.setDateHeader ("Expires", -1);
         %>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
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
     
     

     

     
    
      <script type="text/javascript">
         anylinkmenu.init("menuanchorclass")
      </script>
     
      <script language="javascript" type="text/javascript" src="${createLinkTo(dir:'js',file:'datetimepicker.js')}"></script>
      <script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script>
   </head>
  
<script language=javascript type='text/javascript'> 
function myHide(){
	
	document.getElementById('calculator').style.visibility = 'hidden';
}

</script>

<script language="Javascript" type="text/javascript">

function onlyNos(e, t) {
    try {
        if (window.event) {
            var charCode = window.event.keyCode;
        }
        else if (e) {
            var charCode = e.which;
        }
        else { return true; }
        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            return false;
        }
        return true;
    }
    catch (err) {
        alert(err.Description);
    }
}

</script>


<script type="text/javascript">
anylinkmenu.init("menuanchorclass")

function  hideshow12(){
	
	var aa = document.getElementById('autoRenwalApplied').value 
	
	
	if(aa=="Yes"){
	
	 	document.getElementById('trIssueDt').style.display = 'block';	
	 	document.getElementById('trIssueDt1').style.display = 'block';
		document.getElementById('trProvDetails').style.display = 'block'; 
		document.getElementById('trProvDetails1').style.display = 'block';
		document.getElementById('divSubmit').style.display = 'block';
		document.getElementById('uploadLastconsentapplication').style.display = 'block';
		document.getElementById('condition').style.display = 'none';
		
		
		
	}else if(aa=="No") {

		 	document.getElementById('trIssueDt').style.display = 'none';	
			document.getElementById('trProvDetails').style.display = 'none'; 
			 document.getElementById('trIssueDt1').style.display = 'none';	
			document.getElementById('trProvDetails1').style.display = 'none'; 
			document.getElementById('divSubmit').style.display = 'none';
			document.getElementById('uploadLastconsentapplication').style.display = 'none';
			document.getElementById('condition').style.display = 'block';
	}else{
		document.getElementById('trIssueDt').style.display = 'none';	
		document.getElementById('trProvDetails').style.display = 'none'; 
		 document.getElementById('trIssueDt1').style.display = 'none';	
		document.getElementById('trProvDetails1').style.display = 'none'; 
		document.getElementById('divSubmit').style.display = 'none';
		document.getElementById('uploadLastconsentapplication').style.display = 'none';
		document.getElementById('condition').style.display = 'none';
	}
}

function  hideshow11(){
	
	var aa = document.getElementById('indApplied').value 
	
	
	if(aa=="Yes"){
	
	 	document.getElementById('trWhether').style.display = 'block';
	 	document.getElementById('trWhether1l').style.display = 'block';	
	 	//document.getElementById('condition').style.display = 'block';
	 	document.getElementById('Indcondition').style.display = 'none';
	 	
		
	}else {
			
		 document.getElementById('trWhether').style.display = 'none';	
		 document.getElementById('trWhether1l').style.display = 'none';	
		 document.getElementById('uploadLastconsentapplication').style.display = 'none'; 
		 
		 document.getElementById('trProvDetails').style.display = 'none';
		 document.getElementById('trProvDetails1').style.display = 'none';
		 document.getElementById('trIssueDt').style.display = 'none';
		 document.getElementById('trIssueDt1').style.display = 'none';
		 document.getElementById('divSubmit').style.display = 'none';
		 document.getElementById('condition').style.display = 'none';
		 document.getElementById('Indcondition').style.display = 'block';
		 
		 
		 
	}
}

</script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js">
</script>



<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<body>

      <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
         <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
         <td align="left" valign="top">
            <table width="1003" border="0" cellspacing="0" cellpadding="0">
               <tr>
                  <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                     <!-- code for menuSpcbUser-->
                     <g:include controller="userMaster" action="showSpcbIndustryMenu"/>
                  </td>
                  <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                  <td width="778" align="left" valign="top">
                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
//                                                           indType=ind.typeOfIndustry
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
                                    </td>
                                 </tr>
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
                                    </td>
                                 </tr>
                                 <% } %>
                                 <tr>
                                    <td>&nbsp;</td>
                                 </tr>
                              </table>
                           </td>
                        </tr>
                        <tr>
                           <td height="0" align="left" valign="top" class="middlespacer">
                              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                 <tr>
                                    <!-- Div area for errors-->
                                    <td align="center" valign="top">
                                       <div style="width:100%; height:20px; vertical-align:middle">
                                          <span class="error">
                                             <g:if test="${flash.message}">
                                                <div class="message">${flash.message}</div>
                                                <div class="message">${flash.clear()}</div>
                                             </g:if>
                                          </span>
                                       </div>
                                    </td>
                                 </tr>
                                 <!--<tr>        
                                    <td align="center" valign="top">Row for Page Heading</td>
                                    </tr>-->
                                 <tr>
                                    <td height="0" align="left" valign="top">
                                       <table width="778" border="0" cellspacing="0" cellpadding="0">
                                          <tr>
                                             <td width="82" align="left" valign="top">&nbsp;</td>
                                             <td align="left" valign="top">
                                                <div style="padding:0px 0px 0px 0px;" >
      <g:form name="myform" method="post" enctype="multipart/form-data" action="saveAutoRenewConsent" >
                                                  
                 <input type="hidden" name="consentFor" id="consentFor" value="${consentFor}"/>
                 <input type="hidden" name="consentType" id="consentType" value="${consentType}"/>
                 
                  <input type="hidden" id="online" name="online" value="online">
                <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                   <table width="105%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                      <tr>
                                                            <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                                                            <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Apply for Auto Renewal</a></td>
                                                            <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                                                            <td width="1"></td>
                                                            <td width="431">&nbsp;</td>
                                                         </tr>
                                                      </table>
                                             <div id="country2" >
                                                <table width="105%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
                                                <tr>
                                                <td valign="top" bgcolor="#FFFFFF">
                                                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                               <!--bothMine condition added by akhi007  in the case of mine-->	
		
                                               <%
                                               System.out.println("industryRegMasterInstance on gsp "+industryRegMasterInstance.id);
                                               def appCheck = ApplicationPendingDetails.find("from ApplicationPendingDetails where application.indUser = ? and applicationStatus='approved' and application.applicationType='CTO' order by completionDate desc",[industryRegMasterInstance])
                                               
                                               def recordInst = RecordCertificate.find("from RecordCertificate where applicationId=? and applicationId.applicationType='CTO' and typeofCertificate = 'Prepared' order by dateCreated desc",[appCheck.application])
                                            
                                               def sdfh = new SimpleDateFormat("dd/MM/yyyy"); 
                                               System.out.println("appCheck "+appCheck.application.id);
                                               System.out.println("recordInst "+recordInst.id);
                                               System.out.println("recordInst "+recordInst.endDate);
                                               %>
                                               
                                               <tr>
                               				<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Last CTO granted Application :</td>
                               				<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">	

                               				${appCheck.application.id}
                               				<input type="hidden" name="prevApp" id="prevApp" value="${appCheck.application.id}"/>
                               				</td>
                               			</tr> 
                                               
                               		 <tr>
                        				<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Last CTO granted Valid upto :</td>
                        				<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">	
                        				<%if(recordInst){%>
                        				${sdfh.format(recordInst.endDate)}
                        				
                        				<input type="hidden" name="expDate" id="expDate" value="${sdfh.format(recordInst.endDate)}"/>
                        				<input type="hidden" name="issDate" id="issDate" value="${sdfh.format(recordInst.startDate)}"/>
                        				<%}%>
                        				</td>
                        			</tr> 
                                               
                               			<tr>
                           				<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Last CTO granted Form :</td>
                           				<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">	

                           			 <a class="addViewDelete"
                                         href="#"
                                         style="color: #0645AD"
                                         onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/doGetShowOfficer/<%=appCheck.applicationId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                          View Form
                                      </a>
                           				
                           				</td>
                           			</tr> 
                           			
                           			<!--
                                               <tr>
				<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Whether the Industry is registered in OCMMS?:</td>
				<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">	
				<br><g:select class="txt4" from="${['Yes','No']}" name="indApplied" id="indApplied" onChange="hideshow11();"></g:select> </td>
			</tr> 
			-->
			<tr>
			<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">
			<div id="trWhether" style="display:none;">
			<%if(consentType=="CTO"){%>
				Whether the industry has obtained last Renewal of Consent online through OCMMS?:
					<%}else{%>
					Whether industry has obtained CTE through OCMMS :
					<%}%>
			</div></td>
			<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">
				<div id="trWhether1l" style="display:none;">
					<br><g:select class="txt4" from="${['Select','No','Yes']}" name="autoRenwalApplied" id="autoRenwalApplied" onChange="hideshow12();"></g:select>
			 </div></td>
		</tr> 
		
			
			
			<tr bgcolor="#F4F7FB" >
                            <td width="60%" align="right"  bgcolor="#A8DAF3" class="headngblue" >
                            	<div id="trProvDetails" style="display:none;">
                            		<%if(consentType=="CTO"){%>
                            		If Yes, Provide details of last Consent Renewal Order<br> <font style="color:#564dd6">
                            			Consent Renewal Order [Air (or) Water] No:
                            			<%}else{%>
                            			If Yes,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            			<br> Provide details of last CTE  Order [Air (or) Water] No:
                            			<%}%>
                            			</font><br>
                            			<font style="color:red">
                            			only and not the Auto renewal order</font>
                            	</div>
                            </td>
                            <td width="40%" align="left" bgcolor="#E8F6F9" class="txt">
                            <div  id="trProvDetails1" style="display:none;">
                            	<span class="txt style6"><br> <input type="text" id="lastestConRenewalNo" name="lastestConRenewalNo" maxlength="12"  onkeypress="return onlyNos(event,this);"/>
                            </span>
                            </div>
							</td>
                          </tr>
			
			<tr>
				<td width="60%" align="center" valign="center" bgcolor="#A8DAF3" class="headngblue">
				<div id="trIssueDt" style="display:none;" >
				<br>Consent Renewal Issued Date :<calendar:resources lang="en" theme="aqua"/><br><br>
				<calendar:datePicker id="validUpto" years="1950,2050" name="validUpto" dateFormat="%d/%m/%Y"/>
				<!--<input id="validUpto" name="validUpto" type="text" class="txt4" size="15"/>
				<span class="sidetxt">dd-mm-yyyy</span>-->
				</div>
				</td>
			
				<td width="60%" align="center" valign="center" bgcolor="#A8DAF3" class="headngblue">
				<div id="trIssueDt1" style="display:none;">
				<br>Consent Renewal Valid Date:<br><br>
				<calendar:datePicker id="consentDate" name="consentDate"  years="1950,2050" dateFormat="%d/%m/%Y"/>
				<!--<input id="consentDate" name="consentDate" type="text" class="txt4" size="15"/>
				<span class="sidetxt">dd-mm-yyyy</span>-->
				</div>
				</td>
			</tr> 
			
			<tr align="center" bgcolor="#F4F7FB" >
                            <td width="40%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue" colspan="2"><div id="uploadLastconsentapplication" >
                            <input type="checkbox" name="termsconditions" value="terms" id="termsconditions"/> I Agree with this Terms & Conditions For Auto Renewal<span style="color:red">*</span>
                            	<br><u><a href="<%=request.getContextPath()%>/SPCB_DOCUMENTS/AutoTermsAndConditions.pdf" target="_blank"><font  size="1" style="color:red"> View Terms & Conditions</font></a></u>
                            </div></td>
           </tr>
           
           <tr>
   		<td width="60%" align="center"  bgcolor="#A8DAF3" class="headngblue" colspan="2">
   		<div id="condition" style="display:none;">
   		<span class="sidetxt">
   		<%if(consentType=="CTO"){%>
   		Industry is not eligible for Auto Renewal of Consent as per the prescribed Terms & Conditions & Industry shall apply for consent renewal thro’ the port of CTO Renewal.
   		<%}else{%>
   		 Industry is not eligible for Auto renewal of CTE as per the prescribed Terms & conditions & Industry shall apply for CTE New along with consent  fees
   		<%}%>
   		
   		</span></div>
   		
   		<div id="Indcondition" style="display:none;">
   		<span class="sidetxt">
   		<%if(consentType=="CTO"){%>
   		Industry is not eligible for Auto Renewal of Consent as per the prescribed ‘’Terms & Conditions’’ and Industry shall apply for Consent Renewal thro’ the port of CTO-Renewal.
   		<%}else{%>
   		Industry is not eligible for Auto renewal of CTE as per the prescribed Terms & conditions & Industry shall apply for CTE New along with consent  fees
   	    <%}%>
   		</span></div>
   		</td></tr>
			 
												
                                                </table>
                                               </td> 
                                              </tr>  
                                            </table>    
                                          </div>
                                        </div>
                                        
                                        
                                         
		  <table width="100%" align="center">
				
				
				<tr ><td colspan="2">&nbsp;</td></tr>
							  <tr bgcolor="#FFFFFF">
								<td align="center">
								<div id="divSubmit">
								<input type="submit" name="save" value="Proceed" class="actionbutton" onclick="return toSubmit();">
								</div>
								</td>
								
							  </tr>
				 </table>
                                        
                                  
                                              
 </g:form>


											  </div></td>
                                                <td width="132" align="left" valign="top">&nbsp;</td>
                                                </tr>
                                               
                                                </table>
                                             </td>
                                          </tr>
                                       </table>
                                    </td>
                                 </tr>
                              </table>
                           </td>
                        </tr>
                        <!-- code for spcb Footer -->
                        <g:include controller="userMaster" action="showSpcbFooter"/>
                     </table>
                  </td>
               </tr>
            </table>
            


            <script language="JavaScript" type="text/javascript">
 var frmvalidator  = new Validator("myform");
 
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();   
   

 </script>

 <script type="text/javascript">
  function toSubmit(){  
	  
  	var aa=document.getElementById("autoRenwalApplied").value
  	var bb=document.getElementById("lastestConRenewalNo").value
  	
if(!document.getElementById("termsconditions").checked)
	{
 		alert("Please Read and Check Terms and Conditions");
 		return false;
 	}
 	
 	
 	if(aa=="Yes"){
 		if(bb==""){
  			alert("Please Enter the last Consent Renewal Order No.");
 			return false;
  		}else{
			return true;  	
  		}
  		
  	}
  	
  	
 	
   }   
function Checkfiles(){
var frm = document.forms["myform"];


var fupp = document.getElementsByName('auditatedBalanceSheet');

var fup12 = fupp[0];


var fileName = fup12.value;

var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



//alert(ext);

if(ext != "pdf" && ext != "jpg" && ext != "bmp" && fileName !="" ){
alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
return false;
}
else {
return true;
}
}

            
 function Checkfiles1(){
var frm = document.forms["myform"];


var fupp = document.getElementsByName('complianceToConsent');

var fup12 = fupp[0];


var fileName = fup12.value;

var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();



//alert(ext);

if(ext != "pdf" && ext != "jpg" && ext != "bmp" && fileName !="" ){
alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
return false;
}
else {
return true;
}
}
frmvalidator.setAddnlValidationFunction("Checkfiles");
frmvalidator.setAddnlValidationFunction("Checkfiles1");

            </script>
            
            		    
   </body>
</html>