<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
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

<!--
body {
	background-color: #dadada;
}
-->


<style type="text/css">
<!--
.style1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #0033CC;
}
-->
</style>
<style type="text/css">
<!--
body {
	background-color: #fffff;
}
.style2 {color: #FFFFFF}
body,td,th {
	color: #0066FF;
}
-->
</style>
<% String cont=request.getContextPath();

%>
<g:javascript library="prototype" />
<g:javascript>
document.observe('dom:loaded', function() {
<!--	$("grp").observe("change", respondToSelectGrp); -->
   $("officeSelected").observe("change", respondToSelect);
   });

   
 function respondToSelect(event)
 {
 
       new Ajax.Updater("groupSelected",
          "<%=cont%>/workFlowMaster/updateSelectRegularIns",
          {method:'get', parameters: {selectedValue : $F("officeSelected")} }
         );
 }
 
 
</g:javascript>
<g:javascript>
function createRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempAddRoles.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>
<% 

      String contex=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
</head>

<body >

<g:form action="saveActRegularInspection" method="post">
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
              </tr>  <%
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
                <td height="24" bgcolor="#EEEEF3"><table width="100%"> 
<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td class="top-lnks" >Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
					<td  align="left">
					<g:link  action="create" ><span class="innerlink">&nbsp;Forwarding Rights&nbsp;</span></g:link>
					 		
					</td>
							
							
					   </tr></table></td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" bgcolor="#FFFFFF" 	class=""><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                      	<g:if test="${flash.message}">
				           				 <div class="message">${flash.message}</div>
				            			</g:if>
				            			<g:hasErrors bean="${groupMasterInstance}">
				            			
				              			  <g:renderErrors bean="${groupMasterInstance}" as="list" />
				            			
				            		</g:hasErrors>
                      </div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="557" align="left" valign="top"><table style="height:100%" width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
         <div style="border:0px solid gray; width:720px; margin-bottom: 1em; padding: 10px;" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="1"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="149" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Activity Rights</a></td>
                              <td  valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  						  
							  
							 <td width="299"><!-- <input name="test1" type="radio"/>TEST
							 <input name="test1" type="radio"/>TEST1 --></td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
				                      
                      <tr>
          <td colspan="2"><table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
              <tr align="center" bgcolor="#F4F7FB" >
               
                <td width="15%"   align="center" valign="middle"     class="headngblue">Select Office</td>
				<td width="25%"   align="center" valign="middle"   >
				<g:select class="txt4" optionKey="id" noSelection="${['null':'Select Office']}" from="${OfficeMaster.list()}" id="officeSelected" name="officeId" value="${off}"></g:select>				</td>
				<td><a href="popupex.html" onclick="return popitup('../officeMaster/create1')"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD OFFICE" ></a></td>
				  <td width="15%"  align="center" valign="middle"   class="headngblue">Select Group</td>
				<td width="25%"   align="center" valign="middle">
				
				<div id ="groupSelected">
				<g:select class="txt4" optionKey="id"  id="grp" noSelection="${['':'Select Group']}" name="grp" from="" onchange="${remoteFunction(controller:'workFlowMaster', action:'updateActRightsRegularIns',update:'actRightsRegular', params:'\'cont=\' + this.value' )}" value="${g}"></g:select>
				</div><td ><a href="popupex.html" onclick="return popitup('../groupMaster/poptemp.gsp')"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD GROUP" ></a></td>
				 
              </tr>
              <tr >
                        
                   	       
							<td colspan="6" class="headngblue" align="center">Assign Rights</td>
							
						</tr>
              <!--<tr><td>&nbsp;</td></tr>-->
			  <tr>
			 
			  <td colspan="9"><div id="actRightsRegular">
			  
			  </div></td>
			 
			   
			  </tr>
              
             <!--<tr>
          <td colspan="2"><img src="images/spacer.gif"  width="1" height="10" /></td>
        </tr>-->
          </table></td>
        
        </table>
        </div>
        <script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script><div align="center">
   <table width="95%">
				  <tr ><td colspan="2">&nbsp;</td></tr>
					  <tr >
						<td align="center"><input type="submit" name="save" value="Save" class="actionbutton"></td>
						
					  </tr>
				</table>
		          <div align="left" class="txt" style="color: navy">
			  <br>
			   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to create the workflow:-
			  <ul> 
				<li>Create a Group under Office(HO/RO/DO) [Data Administration->Group Administration] </li>
				<li>Attach  Districts to above created Group(Data Administration->Attach\Remove District from Group)</li>
				<li>Create Roles under above created Group and Attach Primary and Link Officer (Note: Attach Primary Officer whose credentials are known so that you can Log in Later to view the application in pending list)  [User Management->Role Management]</li>
			  </ul>
			  Workflow Creation:(Workflow Administration):-
			  <ul> 
				<li>Select Office and Corresponding Group from dropdown (Roles for selected Group will get listed along with activity rights)</li>
				<li>Select a Role and give forwarding rights by checking the Roles under Can Forward To Label</li>
				<li>Assign Activity Rights to Role by checking Activity Rights (Note: Assigning 'is Receiving Officer' right is necessary to route the application)</li>
				<li>Click save to save workflow for that Role</li>
			  </ul><hr>
		</div>
            <br />
            <br />
         
		  
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
</body>

<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>
