<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />







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
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: 

Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>

<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! 

(UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
 


<g:javascript>

function select10()
{ 
var selectmenu1=document.getElementById("certiFor")


selectmenu1.onchange=function()
 {    
   	 var chosenoption=this.options[this.selectedIndex]
         
   	 if(chosenoption.value == "refusal")
   	 {
 document.getElementById('selectTemp6666').style.display = 'block';
  document.getElementById('selectTemp9999').style.display = 'none';
   	 document.getElementById('selectTemp101').style.display = 'none';
   	    	 document.getElementById('selectTemp10').style.display = 'none';
   	 document.getElementById('selectTemp222').style.display = 'block';
   	 document.getElementById('selectTemp333').style.display = 'none';
   	 
	 }
else{
document.getElementById('selectTemp6666').style.display = 'none';
  document.getElementById('selectTemp9999').style.display = 'block';
     document.getElementById('selectTemp101').style.display = 'block';
     document.getElementById('selectTemp222').style.display = 'none';
  document.getElementById('selectTemp333').style.display = 'block';
     document.getElementById('selectTemp10').style.display = 'block';
   		 }
   }
} 
</g:javascript>


</head>

<body >

<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" 

cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
      
        <td height="32" align="left" valign="top" 

background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		
		<!-- Start of menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                   

                      
        <%} %>
     <% if((UserMaster)session.getAttribute("userMaster")){
			UserMaster aa = (UserMaster)session.getAttribute("userMaster");
			String userType = aa.accessLevel
				if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" 

action="showAdminMenuHorizontal"/>                                      
			<% 	}else{ %>
					<g:include controller="userMaster" 

action="showSpcbUserMenuHorizontal"/> 
				<%}
		} %>
     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! 

(UserMaster)session.getAttribute("userMaster") )  )   {%>
			<g:include controller="userMaster" 

action="showIndexMenuHorizontal"/>        
	  <% } %>
	  <!-- END of menuAdminHorizontal-->
	  
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" 

cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- Start of menuAdmin-->
			<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" 

action="showSpcbIndustryMenu"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = 

(UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" 

action="showAdminMenu"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" 

action="showSpcbUserMenu"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! 

(UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
			<!-- End of menuAdmin-->
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" 

cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" 

height="134" /></td>
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
						 <tr height="10px" 

width="100%">
						 	<td>Welcome 

<%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : 

${roleHeader}</td>
						 	<td class="top-lnks" 

align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					</table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" 

border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; 

vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${certificateRecordInstance}">
            <div class="errors">
                <g:renderErrors bean="${certificateRecordInstance}" as="list" />
            </div>
            </g:hasErrors>  
            
                

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" 

cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
    <g:form  name="myForm" action="pdfRevokeBothHwm" method="post" >
          <input type="hidden" name="idIndApp" value="${indApplicationDetailsInstance?.id}" />
       
               
   
   				
         
         
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                             <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Draft Letter</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
							
	    </table>
	  
	   <%  
	    ////
			
			def date1 = new Date()
			String year1 = date1.getYear().toString()
			String yearString = (String)year1.substring(1,3)
			def cat = indRegInstance.category.id
			def district = indRegInstance.district.districtCode
			if(cat==2)
			{
				cat = 'R'
			}
			if(cat==3)
			{
				cat = 'O'
			}
			if(cat==4)
			{
				cat = 'G'
			}
			def apply = indApplicationDetailsInstance.applicationType
			def applicationFor = indApplicationDetailsInstance.applicationFor
			def type = ""
			if(apply=='CTO')
			{
				if(applicationFor=='air')
				{
				type = 'A'
				}
				else if(applicationFor=='water')
				{
				type = 'W'
				}
				else
				{
				type = 'HWM'
				}
			}
			
			String check = cat+yearString+district+apply+type+indApplicationDetailsInstance
			////
	    
	    %>
          <div id="country1" style="border:1px solid gray;overflow: auto;  height:470px; width:610px;   margin-bottom: 1em; padding: 10px">
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 
  			 <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Industry Details:</div></td>
                        
                      </tr>
						
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div 

align="right" class="style3">District:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                         ${fieldValue(bean:indRegInstance, field:'district')}
                        </span></td>
                      </tr>
                         <!--   <tr align="center" >
                              <td width="150px" bgcolor="#A8DAF3" align="right" valign="middle" 

class="headngblue"><div align="right" class="style3">Tehsill:</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
    ${fieldValue(bean:indRegInstance, field:'tehsil')}                    
                       </span> </div></td>
                      </tr> -->
                      <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div 

align="right" class="style3">Industry Name:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
                         ${fieldValue(bean:indRegInstance, field:'indName')}
                        </span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div 

align="right" class="style3">Address:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                        
                       
    
                 
                        
                        
                        
                   ${fieldValue(bean:indRegInstance, field:'indAddress')}
                        </span></td>
                      </tr>
					  <tr bgcolor="#E8F6F9"><td 

colspan="2"><span class="style8"></span>
					  </td>
					  </tr>
					  
					  <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" 

class="style3">Consent letter details:</div></td>
                        
                      </tr>
					  
                     
                     <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Certificate For:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                          
                          
                           <select class="txt4" name="certiFor" id="certiFor"  onClick="javascript:select10()">
				   				<option value="Revoke">Revoke</option>
				   								   				
				   				
			      </select>
			      </tr>
                     
                     
                     
                     
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div 

align="right" class="style3">Letter Sent To:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                          
                          ${fieldValue(bean:indRegInstance, field:'occName')}
                        </span></td>
                      </tr>
					  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div 

align="right" class="style3">Designation:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                          ${fieldValue(bean:indRegInstance, field:'occDesignation')}
                        </span></td>
                      </tr>
                      
                   <tr bgcolor="#D1D1D1" >
                          <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Details:</div></td>
                        </tr>
                    
                      
                      <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="15" cols="70" name="details"></textarea></td>
					</tr>
                       <input type="hidden" name="checkAir" id="checkAir" value="HWM">  
                        <input type="hidden" id="option" name="option">
					  <input type="hidden" name="check" value="${check}" />
 
                       </table>
                          
                     
				  <table width="96%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td width="46%" align="right"><input type="submit"  

value="Generate Certificate" class="draftbutton" ></td>
			
				
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

