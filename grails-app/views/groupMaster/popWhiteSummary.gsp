<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=WhiteApplicationSummary.xls");
%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">
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
<!--
<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
			 }
</g:javascript>
-->

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
	String cont2=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont2+"/index.gsp")	;	
	 } %>



</head>
<body >
<div>

 <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr" style="font-weight: inherit;border:3px solid green;">
         <tr bgcolor="#E8F6F9">
        	<td colspan="8" width="50%" align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >White Category Application</td>
        </tr>
        </table>
        
        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="1" bgcolor="white" class="tab-txt" style="white-space:nowrap;border-bottom:3px solid green;">
        <tr>
        	
               <%
               String dd1;
               String dd2;
               String dd3;
               if(sqlDate)
               {
               java.util.Date utilDate1 = new java.util.Date(sqlDate.getTime());
               java.util.Date utilDate2 = new java.util.Date(sqlDate2.getTime());
               
               SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

               dd1=dmyFormat.format(utilDate1);
               dd2=dmyFormat.format(utilDate2);
               }
               %>
               
              
              </tr> 
              <tr>
                 <td colspan="8" align="center" ><span class="headngblue"> 
                 <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd2%></font><%}%>
                 </span>
                 </td>
             </tr>
             
             
             <tr>
            <td colspan="8" align="center" ><span class="headngblue"> 
            <font color="red">White Application Summary</font>
            </span>
            </td>
            </tr>
            
            
           
           
          
           
           
           
            
              <tr><td></td></tr>
        	

        </table>
<table width=100% align="center" border="2" style="font-weight: inherit;border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr width="100%" bgcolor="#A8DAF3"  >
           
<th align="center"  style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >S.No.</th>
  <th align="center"  style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Application No</th>
   <th align="center"  style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Name Of the Unit</th>
   <th align="center"  style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Application Date</th>
   <th align="center"  style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Status</th>
    <th align="center" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >District</th>
	<th align="center"  style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Intustry Type</th>
	
</tr>   
            <%if(!abc || abc.size()==0){%>
            <td align="left" colspan="5">No Record Founds..</td>
            <%}%>
           	<g:each in="${abc}" status="i" var="abc">
           	<tr>
           	<td align="center"><%=(i+1)%></td>
           	<td align="center"><%=abc.id%></td>
           	<td align="center"><%=abc.indUser.indName%></td>
           	<td align="center"><g:formatDate format="dd-MM-yyyy" date="${abc.dateOfCreated}"/></td>
           	<td align="center">Approved</td>

           	<td align="center"><%=abc.indUser.district.districtName%></td>
           	<td align="center"><%=abc.indUser.industryType%></td>

            	</tr>
           	</g:each>
           	       
           	       
        
</table>

</div>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>