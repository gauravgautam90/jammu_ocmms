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
	<g:include controller="userMaster" action="showMenu"/>
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
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
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
          <td width="95%" align="left" class="headngbig" bgcolor="">Air Pollution</td>
     </tr>
	    </table>
	
		
		

 <!--  content change...START  -->
	
  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" >
			   <tr class="txt4" >
 
      <tr>
          <td width="100%" height="18">
            <P style="line-height: 200%; margin-left: 5; margin-right: 35" align="justify" class="txt4">Overview</B> </p>
 </td>
      </tr>
      <tr>
          <td width="100%" height="100">
            <p style="line-height: 150%; margin-left: 5; margin-right: 35" align="justify" class="txt4"><span style="letter-spacing: 0pt">Air pollution is indication of disturbances to the composition of compounds in the atmosphere, as it may be summarized as shown:</span></p>
            <ol class="txt4">
              <li>
                <p style="line-height: 200%; margin-left: 5; margin-right: 35" align="justify">Excess emission of
                gases/vapours into atmosphere</li>
              <li>
                <p style="line-height: 200%; margin-left: 5; margin-right: 35" align="justify">Saturation of chemical compounds/particulates</font></li>
              <li>
                <p style="line-height: 200%; margin-left: 5; margin-right: 35" align="justify">Rate of dissipation &lt; (smaller than) rate of absorption through various cycles (i.e. carbon and nitrogen cycle)</li>
              <li>
                <p style="line-height: 200%; margin-left: 5; margin-right: 35" align="justify">Emergence of new chemical reactions of reactive and non-biodegradable compounds.</li>
            </ol>
          </td>
      </tr>
      <tr>
          <td width="100%" >
                              <P align=justify  style="line-height: 200%; margin-left: 5; margin-right: 35" class="txt4">Global
                              warming, acid rain, smog, ozone depletion are some
                              effects of air pollution.</P>
                              <P align=justify  style="line-height: 200%; margin-left: 5; margin-right: 35" class="txt4">In
                              relation to this, we may observe the cycle which
                              involves in our daily lives: carbon and nitrogen
                              cycle. These 2 cycles are the most important of
                              all, regulating the composition of carbon and
                              nitrogen of Earth.&nbsp;</P>
          </td>
      </tr>
      <tr>
          <td width="100%" height="100">
                        <P style="line-height: 200%; margin-left: 5; margin-right: 35" align="justify" class="txt4">
                        <B>Sources
                        and Methods</B><br>
                        We can classify major sources that lead to air 
                        pollution to the&nbsp;following categories:</P>
                        <UL class="txt4">
                          <LI>
                          <p style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>motor vehicle exhaust</FONT> </p>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>heat and power generation facilities</FONT> 
                          </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>industrial processes</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>auto manufacturing</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>fertilizers plants</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>building demolition</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>solid waste disposal</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>solvent evaporation</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>volcanic eruption</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>fuel production</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>roadway construction</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>electrical components manufacturing</FONT> 
                          </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>extraction of metals</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>forest fires</FONT> </P>
                          <LI>
                          <P style="line-height: 100%; margin-left: 5; margin-right: 35" align="justify"><FONT face=Arial 
                          size=2>agriculture</FONT></P></LI></UL>
                         
          </td>
      </tr>
    </table>

  

						
				<!-- content change  END	-->	
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr> 
		
		</table>
		        <div align="left" class="txt" style="color: navy">
			  <br>
			<!--   <hr><b>* Instructions:</b><br><br>
			  Please follow below steps to add new office:-
			  <ul> 
				<li>Enter Office name (max 15 Characters)</li>
				<li>Select Priority. Priority defines 1 as higher and 10 as lower. Head Office (HO) will have priority 1, RO as 2 etc.</li>
				<li>Click save button to save the office</li>
			  </ul> -->
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


