<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=popSearchByIndustryNameExc.xls");
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
         <div>
		
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         <tr bgcolor="#E8F6F9">
        	<td width="15%" align="center"  style="color:red;font-size:13px;" class="headngblue" >Search By Industry Name</td>
        </tr>
        </table>
<!--  tables for records start-->		

<div style="overflow: auto;height: 600px; width: 1000px;">
<table width=100% align="center" border="2" style="font-weight: inherit;border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr width="100%" bgcolor="#A8DAF3"  >
           
           	       <th align="center" style="width:5%;" class="headngblue" >S.No.</th>
           	       <th align="left" style="width:15%;" class="headngblue" >Office</th>
    	           <th align="left" style="width:20%;" class="headngblue" >File No.<br>Name Of the Unit</th>
    	           <th align="left" style="width:40%;" class="headngblue" >Industry Type<br>Category-Classification</th>
    	           <th align="center" style="width:20%;" class="headngblue" >Action</th>
</tr>
          
            <%if(!allSummaryReportList || allSummaryReportList.size()==0){%>
            <td align="left" colspan="5">No Record Founds..</td>
            <%}%>
           	<g:each in="${allSummaryReportList}" status="i" var="allSummaryReportListInstance">
           	<%
           	    def industryRegMasterListInstance=IndustryRegMaster.get((allSummaryReportListInstance.indRegMasterId).toLong());
           	%>
           	<tr>
           	          <td align="center"><%=(i+1)%></td>
           	          <td align="left"><%=allSummaryReportListInstance.districtName%></td>
           	          <td align="left"><span style="color:blue;"></span><br><%=allSummaryReportListInstance.applicationName%></td>
           	          <td align="left"><%=industryRegMasterListInstance.industryType%><br><i>${industryRegMasterListInstance?.category.name}-${industryRegMasterListInstance?.industryScale}</i></td>
           	          <td align="center">
           	             <%
           	                  def grantApplicationInstance = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.indUser.id=? and applicationStatus!='pending' order by id desc",[industryRegMasterListInstance.id])
	                          if(grantApplicationInstance){%>
		                      <a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/newPage/${industryRegMasterListInstance.id}', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Previous Application Details&nbsp; </span></a>
	                     <%}%>
           	                         	              
           	       <!--        <a target="_blank" href="<%=request.getContextPath()%>/industryMasterDetails/createIndustryMaster?indUserId=<%=industryRegMasterListInstance.id%>"><span class="innerlink"> Prepare Industry Master Data </span></a>
           	              -->
           	          </td>
           	          
           	          
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