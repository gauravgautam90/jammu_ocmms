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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>



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
				<% } %>
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
					<g:include controller="userMaster" action="showMenu"/>        

                <% } %>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<%
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
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
						<% if( (!(IndUser)session.getAttribute("indUser") ) && 
							(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
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
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" width="100%">
					<table width="100%" border="0" >
						 <tr height="10px" width="100%">
						 	<td></td>
						 	<td class="top-lnks" align="right">  </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
							
							<!--<td width="20%" align="left"><g:link controller="officeMaster" action="updateoffice" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link></td> -->
							<td width="80%">&nbsp;</td>
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
									<g:hasErrors bean="${officeMasterInstance}">
									<div class="errors">
										<g:renderErrors bean="${officeMasterInstance}" as="list" />
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
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		<g:form action="save" name="myform" method="post" >
		
	<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
     <tr>
     <td><img src="${createLinkTo(dir:'images',file:'arr.jpg')}" />&nbsp;&nbsp;</td>
          <td width="95%" align="left" class="headngbig" bgcolor="">Introduction </td>
     </tr>
	    </table>
		
<!--  <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Introduction</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right" ></td>
							</tr>
	    </table>-->
	    
		            <!--    content change...START  -->	
		
 
<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" >
 
			   <tr class="txt4" >
   <td width="100%" height="100%"  class="headngblue1" border="0">
  

            <p style="line-height: 200%; margin-left: 10; margin-right:20" align="justify">
                 J&KSPCB was constituted /created in the year 1986/87 under water (RECD) Act 1974 for prevention & control and maintenance an restoration of wholesomeness of water in the state thereafter functions, duties and powers were enjoyed upon it under air (PECP) Act 1981 and E.P. Act 1986.Today, the Board has its offices, in all the districts of the state.</font>
          </td>
          
      <tr>
          <td width="100%" height="1" class="headngblue">
            <p style="line-height: 200%; margin-left: 10; margin-right: 20" align="left">HIGHLIGHTS OF THE BOARD:-&nbsp;</p>
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Infrastructure: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">The Board has one Central office & two full-fledged Regional office at Srinagar & Jammu. To widen its base & reach all areas of the state, the Board in 1999 established offices in all the districts of the state. The Board with the intent of strengthen its infrastructure, has constructed spacious & well designed premises for its Regional office, with Laboratory at Jammu.The construction of Regional office and Laboratory, has been taken up in Srinagar.
               
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Laboratories: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">The Board has two Regional laboratories at Srinagar & Jammu. Additional equipments & facilities were acquired, to strength Regional laboratories. A mobile laboratory has been acquired with sophisticated equipment for analysis of water, wastewater and air quality.In addition, the Regional offices are provided with adequate monitoring equipments for monitoring of water quality, air quality including noise and stack emissions.
            
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Computerisation: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">As part of its computerisation plans, the Board is equipping its Regional offices with necessary computer facilities. A Data Bank (Inventory of Industries) is being created with details on industries of every district, covered under various PC laws. Some districts has already finalised the same while some are updating their inventory. The Website of the Board is launched to enable the public to have access to information pertaining to the Board & its activities.
              
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Monitoring & Enforcement: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">Industries have been classified as Red, Orange & Green , based on their pollution potential. Previously all the industries were required to renew consents every year. This has now been reduced to once in 3 years for Orange Category once in 5 years for Green category. For Red category, it remains as one year. For effective monitoring, each Regional office has seperate cells for BMW, MSW, Complaints, water quality monitoring, Air monitoring, Inventionization, Noise monitoring, DG sets.
                  
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Resources: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">The main resources of the Board is grants from State Govt. In addition, the Board collects consent fee from the industries.<br>
                  
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Human Resource Development: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">In 1996, additional manpower based on the actual responsibilities was estimated & sanction obtained from the Govt. to increase staff strength.The working staff strength of the Board rose in 2000 & 2001.In order to improve the work efficiency & skill of the Board offices, they are regularily deputed to training programmes.
                  
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Public Awareness: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">100 Eco-clubs under National Green Corps Programme , have been established in each district of the state. Wide ranging Awareness Programme to educate the public, are being conducted regularily.<br>
                  
          </td>
      </tr>
      <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Additional Initiatives: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">Zoning Atlas for Srinagar district, for identification of suitable sites for establishing industries based on environmental considerations, has been completed. Zoning Atlas for Jammu district, is nearing completion.*Work of Zoning Atlas for Anantnag, Pulwama & Kathua districts, is being taken up.
                  
          </td>
      </tr>
      
       <tr>
          <td width="100%" height="100%" >
           <p class="headngblue"> Future Plans:: </p><p style="line-height: 200%; margin-left: 10; margin-right: 20" align="justify" class="txt4">To complete the ongoing infrastructure developmental activities, including the office-cum-Lab of Srinagar.
        <br>
            <b>*</b>
          To provide infrastructure with all facilities to all offices & laboratories of the Board.<br>
            <b>*</b>
          To complete Zoning Atlas for remaining distrists of the state.<br>
            <b>*</b>
          To frame Eco-city concept for Srinagar & Jammu cities.
          <br>
            <b>*</b>
          To establish permanent ambient air quality monitoring stations.
          <br>
            <b>*</b>
          Upgradation of library facilities.
          <br>
            <b>*</b>
          Enforcement of cleaner technologies(recover, recycle, & reuse concept).
                  
          </td>
      </tr>
  
      
		
 
		
		
		
       
						
				<!-- content change  END	-->	
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr> 
		
		</table>
		        <div align="left" class="txt" style="color: navy">
			  <br>
			
		</div>
		
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


