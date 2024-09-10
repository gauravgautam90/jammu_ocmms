<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
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
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
<script src="https:////ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

<g:javascript>
function Check()
{
${remoteFunction(controller:'userMaster', action:'ajaxGrpSrch',params:'\'id=\' + escape(this.value)')}
}
</g:javascript>


<g:javascript>
function changeValue()
{
//alert("hhhhhhhhhhhh  ");
	var indtype = document.getElementById("applicationTypeid").value
	if(indtype=="CTO")
	{
		//alert("hhhhhhhhhhhh  "+applicationTypeid);
		document.getElementById("div2").style.display="block";
		document.getElementById("div1").style.display="none";
	document.getElementById("div3").style.display="none";
	
	}
	
	else 
	{
		//alert("hhhhhhhhhhhh  "+industryTypeid);
	document.getElementById("div1").style.display="none";
	document.getElementById("div2").style.display="none"
	document.getElementById("div3").style.display="block"
	
	}
	
}
</g:javascript>


<body  >
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
			
							<g:include controller="userMaster" action="showIndexMenu"/>            

                            
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
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
				                     <g:if test="${flash.message}">
									<div class="message">${flash.message}</div>
									</g:if>
									

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
		
		
		
		
 <g:form action="updateDataAb" name="myform" method="post" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                               <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search Waste Authorization</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		<!----------------START BY VINEET------------------------>
            
            
			<tr bgcolor="#E8F6F9">
            
			 <td width="15%" align="left"  class="headngblue" >Application For :</td>
            <td width="33%" align="left" colspan="0">
            <g:select  class="txt4" from="${['getDetails','deleteExtra','updateReg','updateCompStatus','SENDMAIL','x','sendtestingcheckoldnew','sendtestingcheckold','sendtestingcheck','sendtestingcheckoldnewhttp','sendtestingcheckAphttps','sendtestingcheckAphttp','XXXXXXzzz','Aaa']}" name="appFor" noSelection="${['101':'SELECT']}" ></g:select>
            </td>
            
            
		     <td width="15%" align="left"  class="headngblue" >Application Id :</td>
            <td width="33%" align="left" colspan="0">
            <input type="text" name="appId" id="appId" />
            </td>
          	
   	       </tr>
   	       <tr bgcolor="#E8F6F9">
            
			
            
            
		     <td width="15%" align="left"  class="headngblue" >reg Id :</td>
            <td width="33%" align="left" colspan="0">
            <input type="text" name="regid" id="regid" />
            </td>
          	
   	       </tr>
   	       
                 
	    <!----------------START BY VINEET------------------------>     

        </table>
                
		
		<table width="100%"  border="0" align="center" class="tblbdr">
		               
		 <tr>
                <td  align="right"><input type="submit" name="Search" value="Search" class="actionbutton"></td>
                <td align="left"><g:link controller="userMaster" action="newRegIndustryMenu">
    			<input type="button" class="actionbutton" value="Back">
    			</g:link>
    			</td>
    			</tr>
		 </table>

  	</g:form>
  	  			
  			
  		
  			
  			  			
  			
  			
  			
  			
  			<g:if test="${recordd}">
  		    
  		  	<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">

  		  	                 
  		  	     </table>
  		  	    
  		  	<g:if test="${session.sqlDate!=null}">       
  		  	<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
  		  	<tr height="20" bgcolor="#2B547E">
  		  	<td align="left" >
  		  	<b><font color="yellow" size="2">Bank payment list</font></b>
  		  	</td>
  		  	</tr>
  		  	</table>
  		  	</g:if>   
  		  	<div style="overflow: auto;height: 300px; width: 650px;">

  		  		<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt" border="1">
  		  	 				<tr height="20" bgcolor="#A8DAF3">

  		  	                     
  		  	 						    <th align="center" class="headngblue" >industry id</th>
  		  	 						    <th align="center" class="headngblue" >Unit Name Id</th>
  		  	 						    <th align="center" class="headngblue" >Date Created</th>
  		  	                   	        <th align="center" class="headngblue" >Distirct Name</th>
  		  	                   	        <th align="center" class="headngblue" >RegId</th>
  		  	                   	        <th align="center" class="headngblue" >user Id </th>
  		  	                   	        <th align="center" class="headngblue" >cafId</th>
  		  	                   	       
  		  	                   	       
  		  	                 </tr>
  		  	                 <g:each in="${recordd}" status="i" var="abc">
  		  	                    <%
  		  	                 
  		  	                  %>
  		  	                    
  		  	                   <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
  		  	                       
  		  	                     		
  		  	                     	   <td align="center" height="25" class="txt4" ><%=abc.id%></td>
  		  	                     	   <td align="center" height="25" class="txt4"><%=abc.indName%></td>
  		  	                     	   <td align="center" height="25" class="txt4"><%=abc.dateCreated%></td>
  		  	                           <td align="center" height="25" class="txt4"><%=abc.district.districtName%></td>
  		  	                           <td align="center" height="25" class="txt4"><%=abc.regId%></td>
  		  	                           <td align="center" height="25" class="txt4"><%=abc.userId%></td>
  		  	                           <td align="center" height="25" class="txt4"><%=abc.cafUniqueNo%></td>
  		  	                           
  		  	                       
  		  	                        	</tr>
  		  	                    </g:each>
  		  				</table>
  		  				<br/>
  		  				<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
  		  				<tr height="20" bgcolor="#2B547E">
  		  				<td align="left" >
  		  				<font color="yellow" size="2"><b>Total Application: <%=recordd.size()%></b></font>
  		  				</td>
  		  				</tr>
  		  				</table>
  		  			 </div>
  		  			</g:if>
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  	<br/>

</body>
<HEAD> <g:javascript library='scriptaculous'/>
<g:javascript>

		window.onload = function()   
           	  {       
           	        
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>