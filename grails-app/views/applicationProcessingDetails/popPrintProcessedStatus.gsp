<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">

<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>

<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

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

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>

<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

</head>

<body >
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr>

<%
String dd1;
String dd2;

if(sqlDate)
{
java.util.Date utilDate1 = new java.util.Date(sqlDate.getTime());
java.util.Date utilDate2 = new java.util.Date(sqlDate2.getTime());
java.util.Date utilDate3 = new java.util.Date(sqlDate3.getTime());


SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

dd1=dmyFormat.format(utilDate1);
dd2=dmyFormat.format(utilDate2);
dd3=dmyFormat.format(utilDate3);
}
%>

<td colspan="9" align="center" >
<span class="headngblue">
     <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
</span>
</td>
</tr>
</table>

<table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">

<tr height="20" bgcolor="#A8DAF3">

<th align="center" class="headngblue" >S.No.</th>
 	        <th align="center" class="headngblue" >Application ID</th>
 	        <th align="center" class="headngblue" >Application Name </th>
 	        <th align="center" class="headngblue" >Industry Type</th>
 	        <th align="center" class="headngblue" >Location</th>
 	        <th align="center" class="headngblue" >Category</th>
 	        <th align="center" class="headngblue" >Application Date</th>
 	        <th align="center" class="headngblue" >District</th>  
	       <th align="center" class="headngblue" >Consent For</th>
 	        <th align="center" class="headngblue" >Status</th>
 	        
        </tr>


  
  
  
  <g:each in="${arr11}" status="i" var="abc11">
                     <%
                   //  System.out.println("abc11-----"+abc11);
                   //  System.out.println("abc11--111---"+abc11.getClass());
                  //   System.out.println("abc11---222--"+abc11.getClass().getName());
          String status = ""
          	String pending = ""
          		String offName = ""
          def appProcess = ApplicationPendingDetails.findByApplication(abc11);
          if(appProcess){
          	
          	status = appProcess.applicationStatus
          		pending = (appProcess.role).toString()
          		System.out.println("pending-----"+pending);
          		
          }
          SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
          String strDate = sdfDestination.format(abc11.actualApplicationDate );
          
          String applicationFor = abc11.applicationFor
          if(applicationFor.equals("brickkilns")){
          applicationFor="Brick Kilns"
          }
          if(applicationFor.equals("both")){
          applicationFor = "Industry "
          }
          if(applicationFor.equals("stonecrusher")){
          applicationFor = "Stone Crusher"
          }
          if(applicationFor.equals("hotmixplants")){
              applicationFor = "Hot mix plants"
              }
          if(applicationFor.equals("stonecrusher and hotmixplants")){
              applicationFor = "Stone Crusher and Hot mix plants"
              }
          if(applicationFor.equals("hotel")){
           applicationFor = "Hotel"
          }
          if(applicationFor.equals("dgset")){
           applicationFor = "DGSet"
          }
          String consentFor = abc11.certificateFor
          
          if(consentFor.equals("new")){
          consentFor="Fresh"
          }
          if(consentFor.equals("expan")){
              consentFor = "Expansion"
              }
          if(consentFor.equals("Modern")){
          consentFor = "Modernization"
          }
          if(consentFor.equals("reNew")){
           consentFor = "Renew"
          }
                     %> 	
                          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          <td align="center" height="25" class="txt4"  >${i+1}</td>
                          
                              <td align="center" height="25" class="txt4"  ><g:link action="doGetShow" controller="indApplicationDetails" id="${abc11.id}">${fieldValue(bean:abc11, field:'id')}</g:link></td>
                              <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.indName')}</td>
                              <td align="center" height="25" class="txt4"  ><%=applicationFor%></td>
                          
                              <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.indAddress')}</td>
                          
                              <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.category.name')}</td>
                          
                              <td align="center" height="25" class="txt4"  ><%=strDate%></td>
                              <td align="center" height="25" class="txt4"  >${fieldValue(bean:abc11, field:'indUser.district.districtName')}</td>
                              <td align="center" height="25" class="txt4"  >${abc11.applicationType} ( <%=consentFor%> )</td>
                              <td align="center" height="25" class="txt4"  ><%=status%></td>
                            
                          
                             
                          </tr>
                      </g:each>
</table>

<br />
<br />
</div>

</form>



</div>

<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
</div></td>
          <td width="82" align="left" valign="top">&nbsp;</td>
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


