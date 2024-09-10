<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
	}
</script>
<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>
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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<% String cont=request.getContextPath()

%>



<g:javascript library="prototype" />
<g:javascript>


document.observe('dom:loaded', function() {
	

   $("grpSelected").observe("change", respondToSelect);
   });

   
 function respondToSelect(event)
 {
        new Ajax.Updater("roleSelected",
          "<%=cont%>/groupDistrictMaster/updateSelect",
          {method:'get', parameters: {selectedValue : $F("grpSelected")} }
         );
 }





</g:javascript>




<% 

      String contex=request.getContextPath()

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
		<!-- code for menuAdminHorizontal-->
		<% 

if(  (IndUser)session.getAttribute("indUser")  ){ %>

                                          <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         

                                    <%} %>

                                                      

                                    <% 

                                    if((UserMaster)session.getAttribute("userMaster")){

                                          UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                          String userType = aa.accessLevel

                                          if(userType.equals("admin")) { %>   

                                                <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

                                          <% }else{ %>

                                                <g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 

                                          <%}} %>

                                                      

                                    <% if( (!(IndUser)session.getAttribute("indUser") ) && 

(! (UserMaster)session.getAttribute("userMaster") )  )   {%>

                                          <g:include controller="userMaster" action="showIndexMenuHorizontal"/>        

                                    <% } %>

 
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<%

						if(  (IndUser)session.getAttribute("indUser")  )
										
										{ %>

                                                      <g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         

                                                <%} %>

                                                                  

                                                <% 

                                                if((UserMaster)session.getAttribute("userMaster")){

                                                      UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                                      String userType = aa.accessLevel

                                                      if(userType.equals("admin")) { %>   

                                                            <g:include controller="userMaster" action="showAdminMenu"/>                                          

                                                      <% }else{ %>

                                                            <g:include controller="userMaster" action="showSpcbUserMenu"/> 

                                                      <%}} %>

                                                                  

                                                <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>

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
					<table width="100%"><tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr> <tr>
					<td width="100%" align="left">
					<g:link controller="groupDistrictMaster" action="del" ><span class="innerlink">&nbsp;Remove District&nbsp;</span></g:link> 
					
							</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${groupDistrictMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${groupDistrictMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                           
                            <td align="center" >
	  
        
				 
    
       <g:form action="save" method="post" >
        
	<table width="70%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="150" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Attach District</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="429">&nbsp;</td>
							</tr>
	    </table>
	    
	    <!--  <table width="60%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" class="print">

                           <tr>

                              <td width="5"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>

                              <td width="150" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Attach District </a></td>

                              <td width="10" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>

                                            <td width="1">&nbsp;</td>

                                            <td width="11" bgcolor="#5A89D9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>

                           				   <td width="150" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country2">Remove District</a></td>

                           				   <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>

                                            

                                            <td width="270" align="center">&nbsp;</td>

                                          </tr>

          </table> 
          <table width="60%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" class="print">
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Attach District</span></a></li>
						<li><a href="#country2"><span>Remove District</span></a></li>
					</ol>
				  </td>
				</tr>		
	    </table> -->

            

	    <div class="content" id="country1">
          
  			<table width="70%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
			<tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Office:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                          
                <g:select class="txt4" optionKey="id" from="${OfficeMaster.list()}" id="officeSelected" name="officeId" onchange="${remoteFunction(controller:'groupDistrictMaster', action:'updateSelect1',update:'GroupSelected', params:'\'cont1=\' + this.value' )} " noSelection="${['xyz':'Not Selected']}"  ></g:select>          
                       
                        <span class="txt4">(select office)</span></span></td>
                      </tr>
			<tr >
						<td  colspan="2">
			 <div id ="GroupSelected">
				 <table width="100%">
						<tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Group:</div></td>
                        <td align="left" bgcolor="#E8F6F9" ><span class="txt style6">
                       <div id ="GroupSelected"> 
    
                   <g:select class="txt4" noSelection="${['xyz1':'Select Group']}" optionKey="id" from="${roleList}"  name="group_id" value="${groupDistrictMasterInstance?.group?.id}" >
                   <span class="txt4">(select group)</span></g:select>
                        
                        
                        
                    </span></td>
                      </tr>
                            <tr >
                        <td width="30%" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">District To Attach:</div></td>
                        <td align="left" bgcolor="#E8F6F9" ><span class="txt style6">
                        
                        
				  <g:select class="txt4" optionKey="id" noSelection="${['xyz1':'Select District']}" from="${finalDistrictList}"  size="5" multiple="multiple" name="district_id"  >
				  <span class="txt4">(select districts)</span></g:select>
				
                        </span></td>
                      </tr>
					  </table>
					  </div>
					  
                      </td></tr>
                      
                      
                      
                     
	  </table>
			
	   <table width="50%" align="center">
	   		
		  <tr>
			<td align="center" colspan="2"><input type="submit" name="save" value="Attach" class="actionbutton" ></td>
			
			
		  </tr>
		 
		</table>
				<br>
				<table width="70%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
				<thead class="headngblue" border="1">List of districts attached to the selected Office and Group.</thead>
					<tr>
						<td width="30%" bgcolor="#A8DAF3" class="headngblue" >
							<div align="right" class="style3">List of Districts:</div>
						</td><td>
						<div id ="roleSelected" align="left" class="txt4">
							<table><tr><td align="left">&nbsp</td></tr></table>
						</div></td>
					</tr>
				</table>
			
		<div align="left" class="txt" style="color: navy">
			   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to attach the district:-
			  <ul> 
			  	<li>Select office name from drop down list</li>
				<li>Select Corresponding group name</li>
				<li>Select district name(s) to be attached with the selected group</li>
				<li>Press ctrl key and select multiple districts</li>
				<li>Click attatch button to attach the selected districts in the group</li>
			  </ul>
		</div>	
  			 </g:form>
			</div>
			
		

      </div></td>


                           
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

