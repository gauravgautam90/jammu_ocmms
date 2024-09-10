<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'../tempDoEdit.gsp',{ insertion:Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>

<g:javascript>



    // A $( document ).ready() block.
    jQuery( document ).ready(function() {
        jQuery('.grant_letter').hide();
    });


    function select10() {
        console.log("select10: ");
        var selectedValue = jQuery("#certiFor option:selected").text();
        console.log("selectedValue: " + selectedValue);
        if (selectedValue == "Refusal") {

            console.log("0");
            jQuery('.refusal_letter').show();
            console.log("1");
            jQuery('.grant_letter').hide();
            console.log("2");


        }
        else {
            console.log("00");
            jQuery('.refusal_letter').hide();
            console.log("4");
            jQuery('.grant_letter').show();
            console.log("5");


        }


    }
</g:javascript>
<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
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
		
		<!-- Start of menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
        <%} %>
     <% if((UserMaster)session.getAttribute("userMaster")){
			UserMaster aa = (UserMaster)session.getAttribute("userMaster");
			String userType = aa.accessLevel
				if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      
			<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
				<%}
		} %>
     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
			<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
	  <% } %>
	  <!-- END of menuAdminHorizontal-->
	  
		</td>
      </tr>
      <tr>
     <td align="left" valign="top">
								<table width="1003" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="224" align="left" valign="top" bgcolor="#DEEED0">
											<!-- code for menuAdmin-->
											<%
								              if(  (IndUser)session.getAttribute("indUser")  ){ %>
								                        <g:include controller="userMaster" action="eWasteIndustryMenuVertical"/><%} %>
								          	<%if((UserMaster)session.getAttribute("userMaster")){
								                        UserMaster aa = (UserMaster)session.getAttribute("userMaster");
								                        String userType = aa.accessLevel
								                              if(userType.equals("admin")) { %>   
								                              <g:include controller="userMaster" action="eWasteAdminMenuVertical"/>                                          
					                        <%    }else{ %>
					                              <g:include controller="userMaster" action="eWasteEmpMenuVertical"/> 
					                        <%    }
						                  		} %>
								         	<% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
								               	<g:include controller="userMaster" action="showIndexMenu"/>            
								         	<% } %>
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
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
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
					<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px" width="100%">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					<tr>
							
				
							<td  align="left"><%
						if(chk)
						{
						//int id=${hazardeousWasteAuthAppInstance.id};%>
						<g:link controller="eWaste" action="viewEWasteCert1"  id="${hazardeousWasteAuthAppInstance.id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;|</span></g:link>
						<%}
						%></td>
							<td >&nbsp;</td>
							
							
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      
                

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
    
        <g:form  action="createNewCertificate" name="myform" method="post" >
          <input type="hidden" id="hazardeousWasteAuthAppInstanceid" name="hazardeousWasteAuthAppInstanceid" value="${hazardeousWasteAuthAppInstance?.id}" />	
           <input type="hidden" id="role" name="role" value="${roleHeader}" />
         <% def recordCerti=RecordCertificateEW.findByApplication(hazardeousWasteAuthAppInstance)      
         System.out.println("-recordCerti---------"+recordCerti)
              %>
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Draft Letter</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
	    
	  
          <div id="country1" style="border:1px solid gray;overflow: auto;   width:610px;   margin-bottom: 1em; padding: 10px">
  			<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                <div id="refusal_letter" name = "refusal_letter">
                    <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Industry Details :</div></td>
                    </tr>
                    <tr>
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">District :</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">${district}</span></td>
                    </tr>
                    <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Industry Name :</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
                         ${fieldValue(bean:indRegInstance, field:'indName')}
                        </span></div></td>
                    </tr>
                    <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Address :</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                            ${fieldValue(bean:indRegInstance, field:'indAddress')}
                        </span></td>
                    </tr>
                    <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Authorization letter Details:</div></td>
                    </tr>
					   
                   


            <div >

                       
                        <tr >
                            <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Letter Sent To :</div></td>
                            <td align="left" bgcolor="#E8F6F9"><span class="txt4">

                                ${fieldValue(bean:indRegInstance, field:'occName')}
                            </span></td>
                        </tr>
                        <tr >
                            <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Designation :</div></td>
                            <td align="left" bgcolor="#E8F6F9"><span class="txt4">

                                ${fieldValue(bean:indRegInstance, field:'occDesignation')}
                            </span></td>
                        </tr>
                         <%
                                int x = year - 2000
                                System.out.println("x:"+x)
                                def abc = hazardeousWasteAuthAppInstance.industryReg.id+x.toString()+"EW"+hazardeousWasteAuthAppInstance.id
                                System.out.println("abc.."+abc)
                            %>
                            
                            <input type = "hidden" name ="authNo" value="${abc}"/>
                       
                       
                       <%if(hazardeousWasteAuthAppInstance.authorisationType=='chkManufactureOrRefurbisher'){%>
                        <tr>
                            <td width="150px" bgcolor="#A8DAF3" colspan="2" class="headngblue"><div align="left" class="style3">1.(a) Authorization No.:
                                <%=abc%>
                        and <br>&nbsp;&nbsp;&nbsp;(b) date of issue:
                                <calendar:datePicker name="draftDate" value="${recordCerti?.draftLetterDate}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                            </div></td>
                        </tr>
                        
                         <tr bgcolor="#D1D1D1">
                            <td width="150px" bgcolor="#A8DAF3" colspan="2" class="headngblue" >2.<input type="text" name="text21" value="${recordCerti?.text21}"/> of <input type="text" name="text22" value="${recordCerti?.text22}"/> is hereby granted an authorisation &nbsp;&nbsp;&nbsp;for generation, storage, treatment, disposal of e-waste on the premises situated at </br>&nbsp;&nbsp;&nbsp; <input type="text"  name="text25" value="${recordCerti?.text25}"> for the following:
                            </br> a. quantity of e-waste:
                            <input type="text" name="text23" value="${recordCerti?.text23}"/>
                            </br> b. nature of e-waste:
                            <input type="text" name="text24" value="${recordCerti?.text24}"/>
                            
                            
                            </td>
                        </tr>
                       
                        <tr >
                            <td width="150px" bgcolor="#A8DAF3" colspan="2" class="headngblue">3. The authorization shall be valid for a period </br>From:&nbsp;
                            
                                <calendar:datePicker name="issueDate" value="${recordCerti?.issueDate}"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                             &nbsp;To:&nbsp;
                                <calendar:datePicker name="expiryDate" value="${recordCerti?.expiryDate}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                            </td>
                        </tr>
                       
                        <tr bgcolor="#D1D1D1">
                            <td width="150px" bgcolor="#A8DAF3" colspan="2" class="headngblue" >4.The e-waste mentioned above shall be treated/disposed off in a manner <input type="text" name="text41" value="${recordCerti?.text41}"/> at <input type="text" name="text42" value="${recordCerti?.text42}"/> .</td>
                        </tr>
                        
                       <%}else{%>
                       
                        <tr >
                            <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Authorization No. :</div></td>
                            <td align="left" bgcolor="#E8F6F9"><span class="txt4">

                                <%=abc%>
                            </span></td>
                        </tr>
                       
                       
                       <tr>
                            <td width="150px" bgcolor="#A8DAF3"  class="headngblue"><div align="right" class="style3">Date of Issue:</div></td>
                               
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4"> 
                                <calendar:datePicker name="draftDate" value="${recordCerti?.draftLetterDate}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                            </span></td>
                        </tr>
                       <tr bgcolor="#D1D1D1">
                            <td width="150px" bgcolor="#A8DAF3" class="headngblue" > The Authorisation is granted for collection, storage and dismantling of  
                            </td><td align="left" bgcolor="#E8F6F9">
                            
                            <input type="text" name="text2" value="${recordCerti?.text2}"/> .</td>
                        </tr>
                        
                        <tr >
                            <td width="150px" bgcolor="#A8DAF3" colspan="2" class="headngblue"> The authorization shall be valid for a period </br>From:&nbsp;
                            
                                <calendar:datePicker name="issueDate" value="${recordCerti?.issueDate}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                             &nbsp;To:&nbsp;
                                <calendar:datePicker name="expiryDate" value="${recordCerti?.expiryDate}" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                            </td>
                        </tr>
                        
                        <tr bgcolor="#D1D1D1">
                            <td width="150px" bgcolor="#A8DAF3" colspan="2" class="headngblue" > The Authorisation is granted for collection off e-Waste from  <input type="text" name="text4" value="${recordCerti?.text4}"/> Districts.</td>
                        </tr>
                       
                         <%}%>
                         <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Specific Condition:</div></td>
                      </tr>
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="10" cols="70" name="termsco">${fieldValue(bean:recordCerti,field:'termsco')}</textarea></td>      
                      </tr>
                     
                    </tr>
                         
                         
                        <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Copy To:</div></td>
                      </tr>
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="10" cols="70" name="copyTo">${fieldValue(bean:recordCerti,field:'copyTo')}</textarea></td>      
                      </tr>
                     
                    </tr>
            </table>

          </div>
         </td>          
    </tr>







	  </table>
	   <table width="96%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td width="75%" align="right"><input type="submit"  value="Generate Certificate" class="draftbutton" /></td>

			
				<!-- onclick="window.open('../openCertificate', 'windowname1', 'width=810, height=650, scrollbars=1'); return false;" name="save" -->
					
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
</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

